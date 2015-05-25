package com.nexia.selenium.testscripts.section.demographics.Notes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestNewPatientCheckinNotes extends AbstractHomeTest{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New Notes")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyfieldNoteWithPositiveData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest notes=new HomeLibUnitTest();
		notes.workSheetName="UnitTest_FV_PC_Info_Notes";
	    notes.testCaseId="NT_IN_001";
		notes.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addNoteType(seleniumHost, seleniumPort, browser, webSite, userAccount,notes);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding  patientnote with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyfieldPatientNoteWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest notes=new HomeLibUnitTest();
		notes.workSheetName="UnitTest_FV_PC_Info_Notes";
	    notes.testCaseId="NT_IN_002";
		notes.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addNoteType(seleniumHost, seleniumPort, browser, webSite, userAccount,notes);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding  patientnote with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyfieldPatientNoteWithSpecialchar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest notes=new HomeLibUnitTest();
		notes.workSheetName="UnitTest_FV_PC_Info_Notes";
	    notes.testCaseId="NT_IN_003";
		notes.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addNoteType(seleniumHost, seleniumPort, browser, webSite, userAccount,notes);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding  patientnote with Numbers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyfieldPatientnoteWithNumerals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest notes=new HomeLibUnitTest();
		notes.workSheetName="UnitTest_FV_PC_Info_Notes";
	    notes.testCaseId="NT_IN_004";
		notes.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addNoteType(seleniumHost, seleniumPort, browser, webSite, userAccount,notes);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding  patientnote with  Alphanum and special characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyfieldPatientnoteWithAlphanumandspecialcharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest notes=new HomeLibUnitTest();
		notes.workSheetName="UnitTest_FV_PC_Info_Notes";
	    notes.testCaseId="NT_IN_005";
		notes.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addNoteType(seleniumHost, seleniumPort, browser, webSite, userAccount,notes);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding  patientnote with  Alphanum")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyfieldPatientNoteWithAlphanum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest notes=new HomeLibUnitTest();
		notes.workSheetName="UnitTest_FV_PC_Info_Notes";
	    notes.testCaseId="NT_IN_006";
		notes.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addNoteType(seleniumHost, seleniumPort, browser, webSite, userAccount,notes);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding  patientNote with white space")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFieldPatientNoteWithWhitespace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest notes=new HomeLibUnitTest();
		notes.workSheetName="UnitTest_FV_PC_Info_Notes";
	    notes.testCaseId="NT_IN_007";
		notes.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addNoteType(seleniumHost, seleniumPort, browser, webSite, userAccount,notes);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding  patientNote with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyfieldPatientNoteWithMaxlength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest notes=new HomeLibUnitTest();
		notes.workSheetName="UnitTest_FV_PC_Info_Notes";
	    notes.testCaseId="NT_IN_008";
		notes.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addNoteType(seleniumHost, seleniumPort, browser, webSite, userAccount,notes);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding  Note date with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyfieldNotedateWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest notes=new HomeLibUnitTest();
		notes.workSheetName="UnitTest_FV_PC_Info_Notes";
	    notes.testCaseId="NT_IN_009";
		notes.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addNoteType(seleniumHost, seleniumPort, browser, webSite, userAccount,notes);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding  Note date with other format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyfieldNotedateWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest notes=new HomeLibUnitTest();
		notes.workSheetName="UnitTest_FV_PC_Info_Notes";
	    notes.testCaseId="NT_IN_010";
		notes.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addNoteType(seleniumHost, seleniumPort, browser, webSite, userAccount,notes);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding  Note date with past date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyfieldNotedateWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest notes=new HomeLibUnitTest();
		notes.workSheetName="UnitTest_FV_PC_Info_Notes";
	    notes.testCaseId="NT_IN_011";
		notes.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addNoteType(seleniumHost, seleniumPort, browser, webSite, userAccount,notes);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding  Note date with  future date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyfiledNotedateWithfuturedate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest notes=new HomeLibUnitTest();
		notes.workSheetName="UnitTest_FV_PC_Info_Notes";
	    notes.testCaseId="NT_IN_012";
		notes.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addNoteType(seleniumHost, seleniumPort, browser, webSite, userAccount,notes);
	}
	/*@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding followup with empty date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyfieldFollowupWithEmptyDateFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest notes=new HomeLibUnitTest();
		notes.workSheetName="UnitTest_FV_PC_Info_Notes";
	    notes.testCaseId="NT_IN_013";
		notes.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addNoteType(seleniumHost, seleniumPort, browser, webSite, userAccount,notes);
	}*/
	/*@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding followsup with past date ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyfieldfollowsupWithPastDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest notes=new HomeLibUnitTest();
		notes.workSheetName="UnitTest_FV_PC_Info_Notes";
	    notes.testCaseId="NT_IN_014";
		notes.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addNoteType(seleniumHost, seleniumPort, browser, webSite, userAccount,notes);
	}*/
	
	/*@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding followsup with  future date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyfieldFollowsupWithCurrentDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest notes=new HomeLibUnitTest();
		notes.workSheetName="UnitTest_FV_PC_Info_Notes";
	    notes.testCaseId="NT_IN_015";
		notes.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addNoteType(seleniumHost, seleniumPort, browser, webSite, userAccount,notes);
	}*/
	
/*	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding note date with character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyfieldFollowUpDateWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest notes=new HomeLibUnitTest();
		notes.workSheetName="UnitTest_FV_PC_Info_Notes";
	    notes.testCaseId="NT_IN_016";
		notes.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addNoteType(seleniumHost, seleniumPort, browser, webSite, userAccount,notes);
	}*/
	
	/*@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding followsup with numbers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyfieldFollowsupWithnumbers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest notes=new HomeLibUnitTest();
		notes.workSheetName="UnitTest_FV_PC_Info_Notes";
	    notes.testCaseId="NT_IN_017";
		notes.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addNoteType(seleniumHost, seleniumPort, browser, webSite, userAccount,notes);
	}*/
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify field Category is empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyfieldCategorywithempty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLibUnitTest notes=new HomeLibUnitTest();
		notes.workSheetName="UnitTest_FV_PC_Info_Notes";
	    notes.testCaseId="NT_IN_018";
		notes.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addNoteType(seleniumHost, seleniumPort, browser, webSite, userAccount,notes);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify unit test in Notes section
	* @action 		  verifying unit test in Notes section
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 10, 2012
	***************************************************************************************************/
	public boolean addNoteType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,HomeLibUnitTest notesTestData) throws IOException{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			// Step-1: Login to the application                                   //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + notesTestData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, notesTestData.userName, notesTestData.userPassword);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,notesTestData.switchRole),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			// Step-3: Advanced search with Patient ID
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,notesTestData.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// Step-4: Go to notes 
			//--------------------------------------------------------------------//
			click(selenium,lnkNotes);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Deleting existing note for the selected patient           //
			//--------------------------------------------------------------------//
			while(waitForElement(selenium,lnkDeleteNotes, 5000)){
				click(selenium,lnkDeleteNotes);
				waitForPageLoad(selenium);
				click(selenium,btnYesButton);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-6: Click Add Note                                            //
			//--------------------------------------------------------------------//
			click(selenium,btnAddNote);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// Step-7:Verify the Unit Test
			//--------------------------------------------------------------------//
			assertTrue(submitnotes(selenium,notesTestData),"Patient Consents failed", selenium, ClassName, MethodName);
			notesTestData.alert = notesTestData.alert== null ? notesTestData.alert = "" : notesTestData.alert.trim();
			if(!notesTestData.alert.equals("")){
				if(userAccount.equalsIgnoreCase(CAAccount)){
					
					assertTrue(isElementPresent(selenium, notesTestData.alertCA), "The validation message field did not appear", selenium, ClassName, MethodName);
					assertTrue(getText(selenium, notesTestData.alertCA).contains(notesTestData.alertMessageCA), "The expected validation message should contain the text - "+ notesTestData.alertMessage + " The actual validation message shown - " + getText(selenium, notesTestData.alertCA), selenium, ClassName, MethodName);
				}
				else{
					assertTrue(isElementPresent(selenium, notesTestData.alert), "The validation message field did not appear", selenium, ClassName, MethodName);
					assertTrue(getText(selenium, notesTestData.alert).contains(notesTestData.alertMessage), "The expected validation message should contain the text - "+ notesTestData.alertMessage + " The actual validation message shown - " + getText(selenium, notesTestData.alert), selenium, ClassName, MethodName);
				}
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
	public boolean submitnotes(Selenium selenium, HomeLibUnitTest notesTestData) throws IOException{
		try{
			assertTrue(enterDate(selenium,txtNoteDate,notesTestData.notedate),"Could not enter date; More Details:"+notesTestData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajkSuggestBox,notesTestData.category);
			assertTrue(enterDate(selenium,txtNote,notesTestData.patientnote), "Could not type patient note; More Details :"+notesTestData.toString(), selenium, ClassName, MethodName);
			//assertTrue(enterDate(selenium,"followupDate",notesTestData.followup),"Could not enter date; More Details:"+notesTestData.toString());
			assertTrue(click(selenium,btnSave),"Could not click save button; More Details:"+notesTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
}
	
	
	