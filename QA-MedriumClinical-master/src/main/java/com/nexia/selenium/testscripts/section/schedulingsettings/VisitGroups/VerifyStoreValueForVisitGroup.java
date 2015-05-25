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

public class VerifyStoreValueForVisitGroup extends AbstractSchedulingTest{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Store Value For Add Visit Group ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValueForAddVisitGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib visitGroup = new SchedulingTestLib();
		visitGroup.workSheetName = "CreateVisitGroup";
		visitGroup.testCaseId = "TC_VG_002";
		visitGroup.fetchSchedulingTestData();
		verifyAddStoreValuForVisitGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Store Value For Edit Visit Group ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValueForEditVisitGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib visitGroup = new SchedulingTestLib();
		visitGroup.workSheetName = "CreateVisitGroup";
		visitGroup.testCaseId = "TC_VG_002";
		visitGroup.fetchSchedulingTestData();
		verifyEditStoreValuForVisitGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Store Value For Summary Visit Group ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValueForSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib visitGroup = new SchedulingTestLib();
		visitGroup.workSheetName = "CreateVisitGroup";
		visitGroup.testCaseId = "TC_VG_002";
		visitGroup.fetchSchedulingTestData();
		verifyStoreValuForSummaryPage(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Store Value For Add Visit Group
	* @action 		  verifying Store Value For Add Visit Group 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jun 21, 2012
	***************************************************************************************************/
	public boolean verifyAddStoreValuForVisitGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingTestLib visitGroup) throws IOException{
		Selenium selenium=null;
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
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,visitGroup.switchRole),"Could not change the role",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Naviagte to Scheduling section							  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Could not Naviagte to Scheduling Setting",selenium, ClassName, MethodName);
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
			assertTrue(click(selenium,lnkEdit),"Could not click on add new button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(verfyStoredValuesForEditVisitGroup(selenium,visitGroup),"Visit Group is not created correctly",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + visitGroup.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Store Value For Edit Visit Group
	* @action 		  verifying Store Value For Edit Visit Group 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jun 21, 2012
	***************************************************************************************************/
	
	public boolean verifyEditStoreValuForVisitGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingTestLib visitGroup) throws IOException{
		Selenium selenium=null;
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
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,visitGroup.switchRole),"Could not change the role",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Naviagte to Scheduling section							  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Could not Navigate to Scheduling",selenium, ClassName, MethodName);
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
			//  Step-6:Edit Visit Group						      		          //
			//--------------------------------------------------------------------//
			
			visitGroup.workSheetName = "CreateVisitGroup";
			visitGroup.testCaseId = "TC_VG_004";
			visitGroup.fetchSchedulingTestData();
			
			assertTrue(click(selenium,lnkEdit),"Could not click on add new button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createVisitGroup(selenium,visitGroup,uniqueName),"Create visit Group is failled",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Verify Stored Values For Visit type					      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkEdit),"Could not click on add new button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(verfyStoredValuesForEditVisitGroup(selenium,visitGroup),"Visit Group is not created correctly",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + visitGroup.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Store Value For Summary Page 
	* @action 		  verifying Store Value For Summary Page 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jun 21, 2012
	***************************************************************************************************/
	public boolean verifyStoreValuForSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingTestLib visitGroup) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date=null;
		String time = null;
		try{
			//--------------------------------------------------------------------//
			// Step-1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + visitGroup.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, visitGroup.userName, visitGroup.userPassword),"Login Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,visitGroup.switchRole),"Could not change the role",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Naviagte to Scheduling section							  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Could not Navigate to Scheduling setting",selenium, ClassName, MethodName);
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
			
			if(userAccount.equals(CAAccount)){
				Calendar cal1=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat.format(cal1.getTime());
				 DateFormat=new SimpleDateFormat("HH");
				 time=DateFormat.format(cal1.getTime());
			}else{
				Calendar cal1=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
				 date=DateFormat.format(cal1.getTime());
				 DateFormat=new SimpleDateFormat("HH");
				 time=DateFormat.format(cal1.getTime());
				}
			//--------------------------------------------------------------------//
			//  Step-7:Verify Stored Values For Visit type					      //
			//--------------------------------------------------------------------//
			assertTrue(verifyCollapseViewForVisitGroup(selenium,visitGroup),"Visit Group is not created correctly",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//assertTrue(verifyTimeStampForCalenderSetting(selenium,lblGroupsummary1, date, time),"Date and time is not update properly");
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + visitGroup.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
