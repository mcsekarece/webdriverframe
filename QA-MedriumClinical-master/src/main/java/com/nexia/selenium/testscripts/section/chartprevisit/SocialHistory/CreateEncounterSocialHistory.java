package com.nexia.selenium.testscripts.section.chartprevisit.SocialHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CreateEncounterSocialHistory extends AbstractChartPreVisit {
	// smoke Testcase
	@Test(groups = {"Smoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Create Social History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createSocialHistoryWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib socialData = new ChartPreVisitLib();
		socialData.workSheetName = "CreateSocialHistory";
		socialData.testCaseId = "TC_CSH_013";
		socialData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	
	/**
	 * addSocialHistory
	 * function to add SocialHistory
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 23, 2012
	 */

	public boolean addSocialHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib socialData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + socialData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, socialData.userName, socialData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,"FULL"),"unable to switch the user role",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,socialData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,socialData),"Deletion failed",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Family History							  //
			//--------------------------------------------------------------------//
			//Check if the Social History link is Visible
			assertTrue(selenium.isVisible(lnkSocialHistory),"Social History Link Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllSocialHistory(selenium,socialData),"Deletion failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
									
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkSocialHistory,"");
			selenium.focus(lnkSocialHistory);
			selenium.fireEvent(lnkSocialHistory,"keypress");			
			waitForPageLoad(selenium);		
			
			
			//--------------------------------------------------------------------//
			//  Step-6: Add Social History//
			//--------------------------------------------------------------------//
			
			assertTrue(createSocialHistory(selenium,socialData),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Added Social History								  //
			//--------------------------------------------------------------------//
			
			assertTrue(selenium.isTextPresent(socialData.type),"",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-8: Sign the Encounter										  //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnBeginEncounter),"Could not click Encounter begin button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		    
		    assertTrue(isElementPresent(selenium,btnSign),"Could not find the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);	
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
				selenium.chooseOkOnNextConfirmation();
				}

			assertTrue(click(selenium,btnSign),"Could not click the sign link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
						
						
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}