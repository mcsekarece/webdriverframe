package com.nexia.selenium.testscripts.section.demographics.Notes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabingOrderForNotes extends AbstractHomeTest{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Tabing order a Program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForNotes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib notesTaborder = new HomeLib();
		notesTaborder.workSheetName = "createNewNote";
		notesTaborder.testCaseId = "TC_NO_001";
		notesTaborder.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyTabbingOrderForNotes(seleniumHost, seleniumPort, browser, webSite, userAccount,notesTaborder);
	}

	/*************************************************************************************************** 
	* @purpose        To verify tabbing order Notes
	* @action 		  verifying verify tabbing order Notes
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 22, 2010
	***************************************************************************************************/
	public void verifyTabbingOrderForNotes(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,HomeLib notesTaborder) throws InterruptedException, IOException{
		
		Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + notesTaborder.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, notesTaborder.userName, notesTaborder.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,notesTaborder.switchRole),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID //
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,notesTaborder.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// Step-4: Go to Notes
			//--------------------------------------------------------------------//
			click(selenium,lnkNotes);
			waitForPageLoad(selenium);
			
			click(selenium,btnAddNote);
			waitForPageLoad(selenium);
			
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
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}
