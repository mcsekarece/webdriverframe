package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyXbuttonInMultipleDirectionPrescription extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Store Value For Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescripeData = new ChartPreVisitLib();
		prescripeData.workSheetName = "PrescribeMedi";
		prescripeData.testCaseId = "TC_PM_010";
		prescripeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyXbuttonInMultipleDirection(seleniumHost, seleniumPort, browser, webSite, userAccount, prescripeData);
	}
	/**
	 * verifyXbuttonInMultipleDirection
	 * function to verify X button In Multiple Directions
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Nov 05, 2012
	 */
	public boolean verifyXbuttonInMultipleDirection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescripeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=false;
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
			
			assertTrue(SearchPrescribeMed(selenium,prescripeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
						
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescripeData.reason),"Could not type reason;More Details:"+prescripeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescripeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-5: Verify X button In Multiple Direction //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,chkMultipleDirection),"Could not click the multiple direction check box;More Deatils:"+prescripeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"//div[5]/div/div/div/div/div/div/div[5]"))
				if(isElementPresent(selenium,"//div[2]/div[2]/div/div[5]")){
					click(selenium,"//div[5]/div/div/div/div/div/div/div[5]");
					if(!isChecked(selenium,chkMultipleDirection))
						click(selenium,"//div[5]/div/div/div/div/div/div/div[5]");
					if(isElementPresent(selenium,"//div[2]/div[2]/div/div[5]"))
						click(selenium,"//div[2]/div[2]/div/div[5]");
					if(!isChecked(selenium,chkMultipleDirection))
						returnValue=true;
					else
						returnValue=false;
						
				}
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescripeData.toString());
			returnValue=false;
		}
		return returnValue;
	}

}
