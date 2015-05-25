package com.nexia.selenium.testscripts.section.demographics.Notes;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;

import com.thoughtworks.selenium.Selenium;

public class EditNewPatientCheckinNotes extends AbstractHomeTest {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Edit New Patient Checkin Notes")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editNotesForPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib noteData=new HomeLib();
		noteData.workSheetName="createNewNote";
		noteData.testCaseId="TC_NO_007";
		noteData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		editNotes(seleniumHost, seleniumPort, browser, webSite, userAccount, noteData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Edit New Patient Checkin Notes
	* @action 		  verifying Edit New Patient Checkin Notes
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 23, 2010
	***************************************************************************************************/
	public boolean editNotes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib noteData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + noteData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, noteData.userName, noteData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
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
			//  Step-6: Create a new Note //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddNote),"Could not click on add Note button:"+noteData.toString(), selenium, ClassName, MethodName);
			assertTrue(createNotes(selenium,noteData, userAccount),"Note creation Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-7: Edit patient Note //
			//--------------------------------------------------------------------//	
			click(selenium,lnkEditNotes);
			waitForPageLoad(selenium);
			
			noteData.workSheetName="EditNote";
			noteData.testCaseId="TC_EN_001";
			noteData.fetchHomeTestData();
			
			waitForPageLoad(selenium);
			
			if(userAccount.equalsIgnoreCase(CAAccount)){			
				assertTrue(enterDate(selenium,txtNoteDate,noteData.notedateCA.trim()),"could not get Note date",selenium,ClassName,MethodName);
			}
			else{			
				assertTrue(enterDate(selenium,txtNoteDate,noteData.notedate.trim()),"could not get note date",selenium,ClassName,MethodName);
			}		
			
			selectValueFromAjaxList(selenium,ajkSuggestBox,noteData.category);
			assertTrue(type(selenium,txtNote,noteData.patientnote), "Could not type patient note; More Details :"+noteData.toString(), selenium, ClassName, MethodName);
			//assertTrue(enterDate(selenium,"followupDate",noteData.followup),"Could not enter date; More Details:"+noteData.toString());
			assertTrue(click(selenium,btnSave),"Could not click save button; More Details:"+noteData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			click(selenium,lnkEditNotes);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify Stored Values //
			//--------------------------------------------------------------------//	
			if(!verifyStoredValuesNotes(selenium,noteData, userAccount)){
				Assert.fail("Notes details not Edited properly; More Details :"+ noteData.toString());
				returnValue=false;
			}else
				return returnValue;
				
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
