package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyApproveFromBlueBox extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Approve Blue box")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForFreeText(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount ) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_028";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoreValueForPrescribeMedication(seleniumHost, seleniumPort, browser,webSite,userAccount, prescribeData);
	}
	
	/**
	 * verifyStoreValueForPrescribeMedication
	 * function to verify Store Value For Prescribe Medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    Sep 12, 2012
	 */
	public boolean verifyStoreValueForPrescribeMedication(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount,ChartPreVisitLib prescripeData) throws Exception{
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
			assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the medication tab;More Details:"+prescripeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllPendingMedication(selenium,prescripeData),"Could not be delte Pending medications",selenium,ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String pName= providerNameTemp.replaceAll(", "+prescripeData.switchRole, "");
			String tempArray[]=pName.split(" ");
			String providerName=tempArray[1]+", "+tempArray[0];
			prescripeData.providerName = providerName;
			
			assertTrue(SearchPrescribeMed(selenium,prescripeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescripeData.reason),"Could not type reason;More Details:"+prescripeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescripeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-5: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescripeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Verify Stored Value in Summary page //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddToPending),"Could not click the Add to Pending button;More Deatils:"+prescripeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the back button;More Deatils:"+prescripeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,prescripeData.patientId);
			waitForPageLoad(selenium);
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkGoToPending),"Could not click the Go to Pending link button;More Deatils:"+prescripeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkApprove),"Could not click the Approve button;More Deatils:"+prescripeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnEditBlue)&&(isElementPresent(selenium,btnDeleteBlue)
					)&&(isElementPresent(selenium,btnApproveBlue)))
				return returnValue;
			else
				Assert.fail("Buttons not present");
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescripeData.toString());
		}
		return false;
	}
}
