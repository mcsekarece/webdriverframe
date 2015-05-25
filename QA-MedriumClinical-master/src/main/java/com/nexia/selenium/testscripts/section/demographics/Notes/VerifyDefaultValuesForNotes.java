package com.nexia.selenium.testscripts.section.demographics.Notes;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultValuesForNotes extends AbstractHomeTest {
	
	@Test(groups = {"firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New Notes")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyDefaultValuesForNotes(String seleniumHost, int seleniumPort,String browser, String webSite)throws Exception {
		HomeLibUnitTest noteData=new HomeLibUnitTest();
		noteData.workSheetName="UnitTest_FV_PC_Info_Notes";
		noteData.testCaseId="NT_IN_001";
		noteData.fetchHomeTestData();
		verifyDefaultValue(seleniumHost, seleniumPort, browser, webSite, noteData);
	}

	/**
	 * verifyDefaultValue
	 * Function to verify Default Value
	 * @param 		seleniumHost
	 * @param 		seleninumPort
	 * @param 		browser
	 * @param 		website
	 * @author 		Aspire QA
	 * @since  	    June 27, 2012
	 */
	public boolean verifyDefaultValue(String seleniumHost, int seleniumPort,String browser, String webSite, HomeLibUnitTest noteData) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + noteData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, noteData.userAccount, noteData.userName, noteData.userPassword),"Login Failed " , selenium, ClassName, MethodName);
			
			//Advanced search with Patient ID
			waitForElement(selenium, "newPatientCheckIn", 4000);
			waitForPageLoad(selenium);
			searchPatientNexia(selenium,noteData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,"!patientNotesList");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigation to Notes
			//--------------------------------------------------------------------//
			click(selenium,"!patientNotesList");
			waitForPageLoad(selenium);
		    assertTrue(click(selenium,"addNote"),"Could not click on add Note button:"+noteData.toString() , selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3:Verify Default Value
			//--------------------------------------------------------------------//
			
			if(!verifyStoredValues(selenium,noteData)){
				Assert.fail("Default value is incorrect; More Details :"+ noteData.toString());
				returnValue=false;
			}			else
				return returnValue;
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + noteData.toString());
		}
		return returnValue;
	}

	public boolean verifyStoredValues(Selenium selenium, HomeLibUnitTest noteData) throws IOException{
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
		String dateNow = formatter.format(currentDate.getTime());
		assertTrue(getValue(selenium,"noteDate").trim().equalsIgnoreCase(dateNow.trim()),"could not get text",selenium,ClassName,MethodName);
		return true;
	}
	
}
			
			