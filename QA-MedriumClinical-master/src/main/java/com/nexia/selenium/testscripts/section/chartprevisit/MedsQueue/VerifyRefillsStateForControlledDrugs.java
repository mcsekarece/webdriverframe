package com.nexia.selenium.testscripts.section.chartprevisit.MedsQueue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyRefillsStateForControlledDrugs extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Refills State For Controlled Drugs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefillsStateForControlledDrugs(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_067";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyControlledDrugs(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify Refills State For Controlled Drugs
	* @action 		  Verifying Refills State For Controlled Drugs
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 31, 2013
	***************************************************************************************************/
	public boolean verifyControlledDrugs(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,prescribeData.switchRole), "could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete All the Pending Medication//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllPendingMedication(selenium,prescribeData),"Could not delete the pending medications", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Navigato Prescribe Medication", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescribeData.provider = pName;
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-6: Add to Pending Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddToPending),"Could not click the Add to Pending button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-7: Search Pending Medication In Meds Queue//
			//--------------------------------------------------------------------//
			
			//Click on Nexia a Logo
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the back button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//Clcik on RxRenewal Queue
			assertTrue(click(selenium,lnkRxRenewal),"Could not click the Meds queue button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Search Created Pending Medication 
			assertTrue(type(selenium,txtRxPatientSearch,prescribeData.patientId),"Could not enter the search text;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.keyPress(txtRxPatientSearch, "\\13");
			waitForPageLoad(selenium);
		
			selectValueFromAjaxList(selenium,ajxRxShow,prescribeData.show);
			waitForPageLoad(selenium);
			click(selenium,"//div[5]/div/div/div/div/div");
			selectValueFromAjaxList(selenium,ajxRxProvider,prescribeData.provider);
			waitForPageLoad(selenium);
			click(selenium,"//div[5]/div/div/div/div/div");
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify MEdication Details in Meds Queue//
			//--------------------------------------------------------------------//
			assertTrue (verifyStoredValues(selenium,prescribeData,userAccount),"The values are not stored properly", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-9: Click Created Pending Medication In Meds Queue//
			//--------------------------------------------------------------------//
			
			int count1=(Integer)selenium.getXpathCount(lblMedsQueue);
			int counter1=2;
			
			if(getText(selenium,lblMedsQueue1).contains(prescribeData.patientId)){
				assertTrue(click(selenium,lblMedsQueue1),"Could not click on the patient medication", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
		
			else{
				while(getText(selenium,"//div[4]/div/div/div/div/div/div/div[2]/div").contains(prescribeData.patientName)){
					if(getText(selenium,"//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div["+counter1+"]/div/div").contains(prescribeData.patientName)){
						assertTrue(click(selenium,"//div/div/div[2]/div/div/div/div["+counter1+"]/div/div[2]/div/div/div/div[2]"),"Could not click on the patient medication", selenium, ClassName, MethodName);
						break;
					}
					counter1++;
					if(count1<counter1)
						break;
				}
			
			}	
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			type(selenium, "xpath=(//input[@id='ofRefillsid'])[2]", "1");
			
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify Medication Details//
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValues(selenium,prescribeData,userAccount),"The values are not stored properly", selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib prescribeData, String account) throws IOException{
		
		String  date = null; 
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MMMMMMMM dd, yyyy");
	     date=DateFormat.format(cal.getTime());
		
		if(account.equals(CAAccount)){
			assertTrue(getText(selenium,lblMedsQueue1).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.prescribeCa.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find the added details", selenium, ClassName, MethodName);
			
		}else{
			assertTrue(getText(selenium,lblMedsQueue1).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.prescribeName.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find the added details", selenium, ClassName, MethodName);
			
		}
	
		assertTrue(getText(selenium,lblMedsQueue1).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.patientId.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find the added details", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblMedsQueue1).trim().contains("On "+date.trim()),"Could not find the added details", selenium, ClassName, MethodName);
		
		
		
	  return true;
	}	
	
	public boolean verifyStoredValuesInRxRenewals(Selenium selenium, ChartPreVisitLib prescribeData, String account) throws IOException{
		
		assertTrue(!getText(selenium,"xpath=(//input[@id='ofRefillsid'])[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains("1".trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
		click(selenium, "//div[@id='printInfo']/div/div/div[3]/div/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/div[2]/div[5]/table/tbody/tr[2]/td[2]/div/div/div/div/div[2]/div/div/div/div/a");
		
		
		//get the provider name
		
		String provider=getText(selenium, lnkTopMenu);
		String providerName[]=provider.split(",");
		
		
		assertTrue(getText(selenium,lblWarning2).toLowerCase(new java.util.Locale("en","US")).trim().contains(providerName[0].trim().toLowerCase(new java.util.Locale("en","US"))),"Verificatin failed", selenium, ClassName, MethodName);
			
	  return true;
	}	

}
