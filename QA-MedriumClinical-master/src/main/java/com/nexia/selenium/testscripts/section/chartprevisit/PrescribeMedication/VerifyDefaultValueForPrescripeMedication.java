package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultValueForPrescripeMedication extends AbstractChartPreVisit{
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Default Value For Prescripe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescripeData = new ChartPreVisitLib();
		prescripeData.workSheetName = "PrescribeMedi";
		prescripeData.testCaseId = "TC_PM_007";
		prescripeData.fetchChartPreVisitTestData();
		verifyDefaultValueForPrescripeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescripeData);
	}
	/**
	 * verifyDefaultValueForPrescripeMedication
	 * function to verify Default Value For Prescripe Medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Sep 18, 2012
	 */
	
	public boolean verifyDefaultValueForPrescripeMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescripeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescripeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescripeData.userName, prescripeData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescripeData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescripeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescripeData.providerName = pName;
			
			assertTrue(SearchPrescribeMed(selenium,prescripeData,userAccount),"Could not Search the Medication name",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
		/*	selectValueFromAjaxList(selenium,ajxProvider,prescripeData.provider);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxLoaction,prescripeData.loaction);
			if(userAccount.equals(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,prescripeData.prescribeCa),"Could not type Prescribe Medication;More Details:"+prescripeData.toString());
				waitForPageLoad(selenium);
			}else{
				assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,prescripeData.prescribe),"Could not type Prescribe Medication;More Details:"+prescripeData.toString());
				waitForPageLoad(selenium);
			}
			
			
			assertTrue(click(selenium,lnlEdit1),"Could not click the Prescribe link;More Deatils:"+prescripeData.toString());
			waitForPageLoad(selenium);*/
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescripeData.reason),"Could not type reason;More Details:"+prescripeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescripeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			//assertTrue(click(selenium,"increaseDecreaseIDcheckbox"),"Could not click the increase Decrease ID Check box;More Details:"+prescripeData.toString());
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Default Value //
			//--------------------------------------------------------------------//
			if(!verifyDefaultValue(selenium,prescripeData,userAccount)){
				Assert.fail("Prescripe details not saved properly; More Details :"+ prescripeData.toString());
				returnValue=false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	public boolean verifyDefaultValue(Selenium selenium,ChartPreVisitLib prescripeData,String account ){
		
		String dateNow=null;
		
		
		if(account.equals(CAAccount)){
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			dateNow = formatter.format(currentDate.getTime());
			System.out.println("Now the date is :  " + dateNow);
			
			if(!getValue(selenium,txtFillon).trim().equals(dateNow)){
				return false;
			}
		}else{
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			dateNow = formatter.format(currentDate.getTime());
			System.out.println("Now the date is :  " + dateNow);
			if(!getValue(selenium,txtFillon).trim().equals(dateNow)){
				return false;
			}
			
		}
		return true;
		
	}
}
