package com.nexia.selenium.testscripts.section.chartprevisit.ProviderHomePage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForProviderHomePage extends AbstractChartPreVisit{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a NoteToSelf")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitTestForNoteToSelf(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest noteToSelfData = new ChartPreVisitLibUnitTest();
		noteToSelfData.workSheetName = "ProviderHomePage";
		noteToSelfData.testCaseId = "TC_PHNS_001";
		noteToSelfData.fetchHomeTestData();
		unitTestForNote(seleniumHost, seleniumPort, browser, webSite, userAccount, noteToSelfData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a NoteToSelf")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void unitTestForAnnouncement(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest noteToSelfData = new ChartPreVisitLibUnitTest();
		noteToSelfData.workSheetName = "ProviderHomePage";
		noteToSelfData.testCaseId = "TC_PHNS_002";
		noteToSelfData.fetchHomeTestData();
		unitTestForAnnouncment(seleniumHost, seleniumPort, browser, webSite, userAccount, noteToSelfData);
	}
	
	/**
	 * unitTestForNote
	 * function to unitTestForNote
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	  * @since  	    Sep 14, 2012
	 */
	
	public boolean unitTestForNote(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLibUnitTest noteToSelfData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + noteToSelfData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, noteToSelfData.userName, noteToSelfData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Announment and click to Edit button //
			//--------------------------------------------------------------------//
			assertTrue(unitNotes(selenium,noteToSelfData),"Message not appear", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			noteToSelfData.validationFieldID= noteToSelfData.validationFieldID == null ? noteToSelfData.validationFieldID = "" : noteToSelfData.validationFieldID.trim();
			if(!noteToSelfData.validationFieldID.equals("")){
			assertTrue(isElementPresent(selenium, noteToSelfData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, noteToSelfData.validationFieldID).contains(noteToSelfData.validationMessage), "The expected validation message should contain the text - "+ noteToSelfData.validationMessage + " The actual validation message shown - " + getText(selenium, noteToSelfData.validationFieldID), selenium, ClassName, MethodName);
			returnValue=true;
			}

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/**
	 * unitNote
	 * function to unitNote
	 * @throws IOException 
	 * @since  	Sep 14, 2012
	 */
	
	public boolean unitNotes(Selenium selenium,ChartPreVisitLibUnitTest noteToSelfData) throws IOException{
		try{
			assertTrue(click(selenium,btnNoteEdit),"Could not click edit button;More details:"+noteToSelfData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtNote,noteToSelfData.noteToeSelf),"Could not enter the value;More details:"+noteToSelfData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnNoteSave),"Could not click the save button;More Details:"+noteToSelfData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
	
	/**
	 * unitTestForNote
	 * function to unitTestForNote
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	  * @since  	    Sep 14, 2012
	 */
	
	public boolean unitTestForAnnouncment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLibUnitTest noteToSelfData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + noteToSelfData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, noteToSelfData.userName, noteToSelfData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Announment and click to Edit button //
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,btnNoteEdit),"Could not present the Announcement link;More Details:"+noteToSelfData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(unitAnnouncement(selenium,noteToSelfData),"message is not appear", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			noteToSelfData.validationFieldID= noteToSelfData.validationFieldID == null ? noteToSelfData.validationFieldID = "" : noteToSelfData.validationFieldID.trim();
			if(!noteToSelfData.validationFieldID.equals("")){
			assertTrue(isElementPresent(selenium, noteToSelfData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, noteToSelfData.validationFieldID).contains(noteToSelfData.validationMessage), "The expected validation message should contain the text - "+ noteToSelfData.validationMessage + " The actual validation message shown - " + getText(selenium, noteToSelfData.validationFieldID), selenium, ClassName, MethodName);
			returnValue=true;
			}

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/**
	 * unitAnnouncement
	 * function to unitAnnouncement
	 * @throws IOException 
	 * @since  	Sep 14, 2012
	 */
	
	public boolean unitAnnouncement(Selenium selenium,ChartPreVisitLibUnitTest announcementData) throws IOException{
		try{
			assertTrue(click(selenium,btnAnnEdit),"Could not click edit button;More details:"+announcementData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtAnnouncement,announcementData.announcements),"Could not enter the value;More details:"+announcementData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAnnsave),"Could not click the save button;More Details:"+announcementData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
}