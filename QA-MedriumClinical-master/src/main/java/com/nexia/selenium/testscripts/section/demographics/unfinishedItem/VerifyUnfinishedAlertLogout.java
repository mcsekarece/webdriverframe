package com.nexia.selenium.testscripts.section.demographics.unfinishedItem;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUnfinishedAlertLogout extends AbstractHomeTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Unfinished Alert while Logout" )
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUnfinishedAlertLogout(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib noteData=new HomeLib();
		noteData.workSheetName="createNewNote";
		noteData.testCaseId="TC_NO_007";
		noteData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyUnfinishedAlertLogout(seleniumHost, seleniumPort, browser, webSite, userAccount, noteData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To VerifyUnfinished Item AlertLogout 
	* @action 		  Verifying  Unfinished Item AlertLogout 
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Aug 16, 2013
	***************************************************************************************************/
	public boolean verifyUnfinishedAlertLogout(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib noteData) throws Exception{
		Selenium selenium = null;
		String currentUnfinishedItem="Add Notes for";
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + noteData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, noteData.userName, noteData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,noteData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3: Delete all unfinished item                                //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllUnfinishedItem(selenium),"Could not Delete all unfinished item  :"+ noteData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to patient Note  //
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,noteData.patientID);
			waitForPageLoad(selenium);
			click(selenium,lnkNotes);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Deleting existing note for the selected patient  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllNotes(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-6: Create a new Note //
			//--------------------------------------------------------------------//
		
			assertTrue(click(selenium,btnAddNote),"Could not click on add Note button:"+noteData.toString(), selenium, ClassName, MethodName);
	          
			if(userAccount.equalsIgnoreCase(CAAccount)){
		    	assertTrue(enterDate(selenium,txtNoteDate,noteData.notedateCA),"Could not enter date; More Details:"+noteData.toString(), selenium, ClassName, MethodName);
			}
			else{
				assertTrue(enterDate(selenium,txtNoteDate,noteData.notedate),"Could not enter date; More Details:"+noteData.toString(), selenium, ClassName, MethodName);
			}			
			
			selectValueFromAjaxList(selenium,ajkSuggestBox,noteData.category);
			assertTrue(type(selenium,txtNote,noteData.patientnote), "Could not type patient note; More Details :"+noteData.toString(), selenium, ClassName, MethodName);
		    
			//--------------------------------------------------------------------//
			//  Step-7: Logout  //
			//--------------------------------------------------------------------//
			 
			assertTrue(click(selenium,lnkTopMenu),"Could not click on Top Menu :"+noteData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkSignOut),"Could not click on Sign out button"+noteData.toString(), selenium, ClassName, MethodName);
			String x=getText(selenium,lnkAlertSgnout);
			if(selenium.isTextPresent("You are logging out leaving a page with unsaved data")){
				return true;
			}else{
				Assert.fail("Alert message not displayed");
			}
			
			
			
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + noteData.toString(), selenium, ClassName, MethodName);
			
		}
		return true;
	}
}
