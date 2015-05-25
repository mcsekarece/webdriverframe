package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyRefillsDisabledForControlledDrug extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying whether refills directions enabled for controlled drug")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrescribeMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_033";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyRefillsDisabled(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	/**
	 * verifyRefillsDisabled
	 * function to verify Prescribe
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Mar 01, 2012
	 */
	public boolean verifyRefillsDisabled(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		@SuppressWarnings("unused")
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ",selenium,ClassName,MethodName);;
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click Prescibe Medication Link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			
		/*	assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not Search Prescribe Medication ");
			waitForPageLoad(selenium);			
			waitForPageLoad(selenium);*/
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
			//  Step-5: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(verifyRefillForControlled(selenium,prescribeData),"Refills present for controlled drug!",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnEdit),"Edit button Could not found;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			System.out.println(getText(selenium,btnSend));
		
			assertTrue(getText(selenium,btnSend).contains("Send"),"Find the send button;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			System.out.println(selenium.getAttribute(txtSendTitle));
			if(selenium.getAttribute(txtSendTitle).contains("Controlled medications may not be sent electronically"))
				returnValue=true;
			else
				Assert.fail("Send button message is not correct");
			//--------------------------------------------------------------------//
			//  Step-5: verfiy Medication //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit),"Could not click edit button"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(verifyRefillForControlled(selenium,prescribeData),"Refills present for controlled drug!",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
		}
		return false;
	}
}
