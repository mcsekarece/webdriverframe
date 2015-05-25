package com.nexia.selenium.testscripts.section.schedulingsettings.VisitTypes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForVisitTypes extends AbstractSchedulingTest{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Tabbing order in visit types")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForVisitTypes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "CreateVisittype";
		visitType.testCaseId = "TC_VT_001";
		visitType.fetchSchedulingTestData();
		verifyTabbingOrderForVisitTypes(seleniumHost, seleniumPort, browser, webSite, userAccount,visitType);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Tabbing order in visit types
	* @action 		  verifying Tabbing order in visit types
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jun 24, 2013
	***************************************************************************************************/
	public void verifyTabbingOrderForVisitTypes(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,SchedulingTestLib visitType) throws InterruptedException, IOException{
		
		Selenium selenium = null;
		String ClassName = null;
		
		try{
			//--------------------------------------------------------------------//
			// Step-1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + visitType.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, visitType.userName, visitType.userPassword),"Login Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,visitType.switchRole),"Could not the Switch Role",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Naviagte to Scheduling section							  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Could not Navigate to Scheduling section",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Naviagte to Visit Type							          //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkVisitType),"could not click the Visit Type Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Add Visit type							      		  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAdd),"Could not click on add new button",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			// Step-5: verify Tabbing Order
			//--------------------------------------------------------------------//
			for(int i =0;i<csspathsNotes.length;i++){
				assertTrue(isElementPresent(selenium,csspathsNotes[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspathsNotes[i]);
				waitForElementToEnable(selenium,csspathsNotes[i]);
				selenium.keyPress(csspathsNotes[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex(activeElementInPage), selenium.getElementIndex(csspathsNotes[i]));
				}
			}catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + visitType.toString(), selenium, ClassName, MethodName);
		}
	}
}
