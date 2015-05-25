package com.nexia.selenium.testscripts.section.demographics.Notes;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;


public class VerifySelectOptionsForNotes extends AbstractHomeTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying the display of the selected options")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySelectOptionsForNotes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib noteData=new HomeLib();
		noteData.workSheetName="createNewNote";
		noteData.testCaseId="TC_NO_001";
		noteData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySelectOptions(seleniumHost, seleniumPort, browser, webSite, userAccount, noteData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Select Options For Notes
	* @action 		  verifying Select Options For Notes
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 22, 2010
	***************************************************************************************************/
	public boolean verifySelectOptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib noteData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
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
			assertTrue(switchRole(selenium,noteData.switchRole),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID //
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
			//  Step-6: Verify the select value display //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddNote),"Could not click on add Note button:"+noteData.toString(), selenium, ClassName, MethodName);
			if(verifySelectOptionNotes(selenium,noteData))
				returnValue=true;
			else
			{
				returnValue=false;
				Assert.fail("Selected options are not displaying properly");
			}
		
			waitForPageLoad(selenium);
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
