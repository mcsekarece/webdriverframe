package com.nexia.selenium.testscripts.section.demographics.Notes;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyListOfFeaturesForNotes extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify List Of Features For Notes")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void featuresForNotes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib noteData=new HomeLib();
		noteData.workSheetName="createNewNote";
		noteData.testCaseId="TC_NO_001";
		noteData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyListOfFeaturesForNotes(seleniumHost, seleniumPort, browser, webSite, userAccount, noteData);
	}
	 
	/*************************************************************************************************** 
	* @purpose        To Verify List Of Features For Notes
	* @action 		  Verifying List Of Features For Notes
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 22, 2010
	***************************************************************************************************/
	public boolean verifyListOfFeaturesForNotes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib noteData)throws Exception{
		Selenium selenium=null;
		int count=1;
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
			//  Step-3:Advanced search with Patient ID
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,noteData.patientID);
			waitForPageLoad(selenium);
			click(selenium,lnkNotes);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Deleting  Notes for the selected patient  //
			//--------------------------------------------------------------------//
			/*int counter=(Integer) selenium.getXpathCount(lnkDeleteNotes);
			while(isElementPresent(selenium,"//div[@id='PatientNoteList']/table/tbody/tr["+counter+"]/td[4]/div/a")){
			click(selenium,"//div[@id='PatientNoteList']/table/tbody/tr["+counter+"]/td[4]/div/a");
			click(selenium,btnYesButton);
			waitForPageLoad(selenium);
			counter--;
			}*/
			while(isElementPresent(selenium,String.format(btnDeleteForNotes,count)))
			{
				click(selenium,String.format(btnDeleteForNotes,count));
				click(selenium,btnYesButton);
				count++;
				waitForPageLoad(selenium);
			}
			
			while(isElementPresent(selenium,btnDeleteForNotes1))
			{
				click(selenium,(btnDeleteForNotes1));
				click(selenium,btnYesButton);
				waitForPageLoad(selenium);
			}
		
		   assertTrue(getText(selenium,lblNoDetailsAdded).equalsIgnoreCase("No notes added."),"Could not find text", selenium, ClassName, MethodName);
		   return true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
}
