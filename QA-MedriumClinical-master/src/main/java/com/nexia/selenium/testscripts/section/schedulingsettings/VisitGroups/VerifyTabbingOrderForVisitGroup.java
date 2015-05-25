package com.nexia.selenium.testscripts.section.schedulingsettings.VisitGroups;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForVisitGroup  extends AbstractSchedulingTest {
	

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "VerifyTabbingOrderForVisitGroup")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForVisitGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib visitGroup = new SchedulingTestLib();
		visitGroup.workSheetName = "CreateVisitGroup";
		visitGroup.testCaseId = "TC_VG_001";
		visitGroup.fetchSchedulingTestData();
		verifyTabbingOrderForVisitGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	}
	

	/*************************************************************************************************** 
	* @purpose        To verify Tabbing order in visit Group
	* @action 		  verifying Tabbing order in visit Group
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jun 25, 2013
	***************************************************************************************************/
	
	
	public boolean verifyTabbingOrderForVisitGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingTestLib visitGroup) throws InterruptedException, IOException{
		Selenium selenium=null;
		String ClassName = null;
		ClassName=this.getClass().getName().substring(39);
		String MethodName = null;
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			
			//--------------------------------------------------------------------//
			// Step-1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + visitGroup.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, visitGroup.userName, visitGroup.userPassword),"Login Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-2:Naviagte to Scheduling section							  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Could not Navigate to Scheduling section",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Naviagte to Visit Group					                  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkVisitGroup),"could not click the Visit Group Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			for(int i =0;i<csspathsGroup1.length;i++){
				assertTrue(isElementPresent(selenium,csspathsGroup1[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspathsGroup1[i]);
				waitForElementToEnable(selenium,csspathsGroup1[i]);
				selenium.keyPress(csspathsGroup1[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex(activeElementInPage), selenium.getElementIndex(csspathsGroup1[i]));
				}
			
			assertTrue(click(selenium,btnAddVisitGroup),"Could not click on add new button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			for(int i =0;i<csspathsGroup1.length;i++){
				assertTrue(isElementPresent(selenium,csspathsGroup[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspathsGroup[i]);
				waitForElementToEnable(selenium,csspathsGroup[i]);
				selenium.keyPress(csspathsGroup[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex(activeElementInPage), selenium.getElementIndex(csspathsGroup[i]));
				}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + visitGroup.toString(), selenium, ClassName, MethodName);
		}
		return true;
	}

}
