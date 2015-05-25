package com.nexia.selenium.testscripts.section.schedulingsettings.VisitTypes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchOptionForVisitType extends AbstractSchedulingTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Search Visit type")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchVisitTypeWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "CreateVisittype";
		visitType.testCaseId = "TC_VT_001";
		visitType.fetchSchedulingTestData();
		searchVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        To verify Search Function for Visit Type 
	* @action 		  verifying search Function  for Visit Type 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jun 17, 2012
	***************************************************************************************************/
	public boolean searchVisitType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingTestLib visitType) throws IOException{
		Selenium selenium = null;
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
			//  Step-4:Delete Existing Visit Type							      //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllVisitType(selenium,visitType),"Could not delete the exisiting record",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Create Visit type							      		  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAdd),"Could not click on add new button",selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			assertTrue(createVisitType(selenium,visitType,uniqueName),"Create visit type is failled",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Create AnotherVisit type							      	//
			//--------------------------------------------------------------------//
			visitType.workSheetName = "CreateVisittype";
			visitType.testCaseId = "TC_VT_002";
			visitType.fetchSchedulingTestData();
			
			assertTrue(click(selenium,btnAdd),"Could not click on add new button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueName1=DateFormat1.format(cal1.getTime());
			waitForPageLoad(selenium);
			assertTrue(createVisitType(selenium,visitType,uniqueName1),"Create visit type is failled",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Verify Search Values For Visit type					      //
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtSearchType,visitType.visitName),"Could not Type the visit name",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.keyPress(txtSearchType, "\\13");
			waitForPageLoad(selenium);
			
			 assertTrue(getText(selenium, lblSummaryVisitDetails).contains(visitType.visitName),"Search result is not getting displayed",selenium, ClassName, MethodName);
			 return true;
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + visitType.toString(), selenium, ClassName, MethodName);
		}
		return true;
	}
}
