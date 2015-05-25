package com.nexia.selenium.testscripts.section.schedulingsettings.VisitGroups;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingUnitTestLib;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForVisitGroup extends AbstractSchedulingTest{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Group name with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void groupNameWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitGroup = new SchedulingUnitTestLib();
		visitGroup.workSheetName = "UnitTest_VisitGroup";
		visitGroup.testCaseId = "TC_UVG001";
		visitGroup.fetchSchedulingSettingsTestData();
		addVisitGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "visit Type With Invalid Name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void visitTypeWithInvalidName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitGroup = new SchedulingUnitTestLib();
		visitGroup.workSheetName = "UnitTest_VisitGroup";
		visitGroup.testCaseId = "TC_UVG002";
		visitGroup.fetchSchedulingSettingsTestData();
		addVisitGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify unit test for Visit Group
	* @action 		  verifying unit test for Visit Group 
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Completed
	* @useraccount    Both
	* @since  	      Jun 12, 2013
	***************************************************************************************************/
	public boolean addVisitGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingUnitTestLib visitGroup) throws IOException{
		Selenium selenium =null;
		String alertText="";
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			// Step-1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + visitGroup.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, visitGroup.userName, visitGroup.userPassword),"Login Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Naviagte to Scheduling section							  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Could not Navigate to Scheduling",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Uint test for Scheduling section							  //
			//--------------------------------------------------------------------//
			
			if(!unit_VisitGroup(selenium, visitGroup)&& visitGroup.validationFieldID.trim().toLowerCase(new java.util.Locale("en", "US")).contains("yes")){
				if(isElementPresent(selenium,lblNoVisitTypeFound)){
					alertText = getText(selenium, lblNoVisitTypeFound);
					if(alertText.toLowerCase(new java.util.Locale("en", "US")).startsWith(visitGroup.validationMessage.trim().toLowerCase(new java.util.Locale("en", "US"))))
					{
			   			return returnValue;			
					}else{
						Assert.fail("An unxpected result is displayed; The Expected :"+visitGroup.validationMessage+" ;The Actual:"+alertText + "; More Details :" + visitGroup.toString());
					}
				}else{
					Assert.fail("Search results are not displayed as expected; The Expected :"+visitGroup.validationMessage+" ;The Actual:"+alertText + "; More Details :" + visitGroup.toString());
				}	
			}else if(visitGroup.validationFieldID.trim().toLowerCase(new java.util.Locale("en", "US")).equals("no")){
				return returnValue;
			}else{
				return returnValue;
				
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + visitGroup.toString(), selenium, ClassName, MethodName);
		}
		return false;
	}

}
