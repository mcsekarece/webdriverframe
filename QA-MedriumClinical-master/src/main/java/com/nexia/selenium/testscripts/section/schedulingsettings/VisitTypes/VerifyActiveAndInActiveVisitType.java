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

public class VerifyActiveAndInActiveVisitType extends AbstractSchedulingTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test For Verifing Active And InActive Visit Type ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void activeAndInActiveVisitType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "CreateVisittype";
		visitType.testCaseId = "TC_VT_002";
		visitType.fetchSchedulingTestData();
		verifyActiveAndInActiveVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}

	/*************************************************************************************************** 
	* @purpose        To verify InActivce And Active Visit Type 
	* @action 		  verifying InActivce And Active Visit Type 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Dec 16, 2012
	***************************************************************************************************/
	
	public boolean verifyActiveAndInActiveVisitType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingTestLib visitType) throws        IOException{
		Selenium selenium=null;
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
			assertTrue(switchRole(selenium,visitType.switchRole), "Unable to change switch role",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Naviagte to Scheduling section							  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium), "Unable to navigate scheduling section",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Naviagte to Visit Type							          //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkVisitType),"could not click the Visit Type Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Delete Existing Visit Type							      //
			//--------------------------------------------------------------------//
			//assertTrue(deleteAllVisitType(selenium),"Could not delete the exisiting record", "",selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Create Visit type							      		  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAdd),"Could not click on add new button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			
			assertTrue(createVisitType(selenium,visitType,uniqueName),"Create visit type is failled", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Verify Stored Values For Visit type					      //
			//--------------------------------------------------------------------//
			String tempVisitTypeName = visitType.visitName + uniqueName;
			
			assertTrue(selectValueFromAjaxList(selenium,txtSearchType, tempVisitTypeName),"Could not type the visit group name in the search text box",selenium, ClassName, MethodName);
			selenium.focus(txtSearchType);
			selenium.fireEvent(txtSearchType, "\\13");
			selenium.typeKeys(txtSearchType, "a");
			
			
			assertTrue(verfyStoredValuesForVisitType(selenium,visitType),"Visit type is not created correctly", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Delete New Visit Type							      //
			//--------------------------------------------------------------------//
		
			
			assertTrue(deleteAllVisitType(selenium,visitType),"Could not delete the exisiting record", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		
			
			if(getText(selenium,lblGroupsummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(tempVisitTypeName.trim().toLowerCase(new java.util.Locale("en","US")))){
				Assert.fail("The resource calender deletion failed");
			}
			
			assertTrue(click(selenium,chkVisitInclude),"Could not click Include Inactiv eCheckbox",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtSearchType, tempVisitTypeName),"Could not type the visit group name in the search text box",selenium, ClassName, MethodName);
			selenium.focus(txtSearchType);
				
			selenium.fireEvent(txtSearchType, "\\13");
			selenium.typeKeys(txtSearchType, "a");
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,lblSummaryVisitDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(tempVisitTypeName.trim().toLowerCase(new java.util.Locale("en","US"))),"The Include inactive check box not working properly",selenium, ClassName, MethodName);
				 
			//--------------------------------------------------------------------//
			//  Step-11: Active the Inactive Visit Group					      //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnActivate) ,"could not able to click the Activate Visit Type", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent("Are you sure you want to activate this record?") ,"text is not present", selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnYesButton) , "could not able to click the yes in the activate Visit type", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,chkVisitInclude),"Could not click Include Inactiv eCheckbox",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtSearchType, tempVisitTypeName),"Could not type the visit group name in the search text box",selenium, ClassName, MethodName);
			selenium.focus(txtSearchType);
				
			selenium.fireEvent(txtSearchType, "\\13");
			selenium.typeKeys(txtSearchType, "a");
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
				if(getText(selenium,lblSummaryVisitDetails).trim().contains("Inactive")){
					Assert.fail("The Include inactive check box not working properly");
				}
			
			}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + visitType.toString());
		}
		return true;
	}
}
