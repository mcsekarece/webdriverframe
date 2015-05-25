package com.nexia.selenium.testscripts.section.schedulingsettings.VisitGroups;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStoreValueForVisitGroupWithColor extends AbstractSchedulingTest{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Store Value For Visit Group With Color")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void storeValueForVisitGroupWithColor(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib visitGroup = new SchedulingTestLib();
		visitGroup.workSheetName = "CreateVisitGroup";
		visitGroup.testCaseId = "TC_VG_006";
		visitGroup.fetchSchedulingTestData();
		verifyStoreValueWithColcor(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Store Value For Visit Group With Custom Color")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void storeValueForVisitGroupWithCustomColor(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib visitGroup = new SchedulingTestLib();
		visitGroup.workSheetName = "CreateVisitGroup";
		visitGroup.testCaseId = "TC_VG_007";
		visitGroup.fetchSchedulingTestData();
		verifyStoreValueWithColcor(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	}
	/*************************************************************************************************** 
	* @purpose        To verify Store Value For Visit Group With color
	* @action 		  verifying Store Value For Visit Group With color
	* @author         Aspire QA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jun 13, 2013
	***************************************************************************************************/
	
	public boolean verifyStoreValueWithColcor(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingTestLib visitGroup) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			// Step-1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + visitGroup.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, visitGroup.userName, visitGroup.userPassword),"Login Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,visitGroup.switchRole),"Could not Switch role",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Naviagte to Scheduling section							  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Could not Navigate to Scheduling section",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Naviagte to Visit Type				                     //
			//--------------------------------------------------------------------//
			SchedulingTestLib visitGroup1 = new SchedulingTestLib();
			visitGroup1.workSheetName = "CreateVisittype";
			visitGroup1.testCaseId = "TC_VT_001";
			visitGroup1.fetchSchedulingTestData();
				
			assertTrue(click(selenium,lnkVisitType),"could not click the Visit Type Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			assertTrue(deleteAllVisitType(selenium,visitGroup),"Could not delete the exisiting record",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			assertTrue(click(selenium,btnAdd),"Could not click on add new button",selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			assertTrue(createVisitType(selenium,visitGroup1,uniqueName),"Create visit type is failled",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Naviagte to Visit Group					                  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkVisitGroup),"could not click the Visit Group Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Delete Existing Visit Group					              //
			//--------------------------------------------------------------------//
			assertTrue(deleteVisitGroup(selenium),"Could not delete the exisiting record",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Create Visit Group						      		      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddVisitGroup),"Could not click on add new button",selenium, ClassName, MethodName);
			assertTrue(createVisitGroup(selenium,visitGroup,uniqueName),"Create visit Group is failled",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Verify Stored Values For Visit type					      //
			//--------------------------------------------------------------------//
			
			// Work on this Section when the definite element ID is provided to colorStrip
			
			/*String color= selenium.getAttribute(lnkColorStrip);
			System.out.println(color);
			if(visitGroup.testCaseId.equals("TC_VG_006")){
				if(color.trim().contains("rgb(153, 204, 255)".trim()))
					returnValue = true;
				else
					Assert.fail("color is not getting displayed");
			}else{
				if(color.trim().contains("rgb(255, 116, 179)".trim()))
					returnValue = true;
				else
					Assert.fail("color is not getting displayed");
			}*/
			assertTrue(verfyStoredValuesForVisitGroup(selenium,visitGroup,uniqueName),"Visit Group is not created correctly",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + visitGroup.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
