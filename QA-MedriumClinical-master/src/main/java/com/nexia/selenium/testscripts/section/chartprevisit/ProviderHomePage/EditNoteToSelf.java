package com.nexia.selenium.testscripts.section.chartprevisit.ProviderHomePage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class EditNoteToSelf extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a NoteToSelf")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editNoteToSelfForProviderHomePage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib noteToSelfData = new ChartPreVisitLib();
		noteToSelfData.workSheetName = "ProviderHomePage";
		noteToSelfData.testCaseId = "TC_PHPA_002";
		noteToSelfData.fetchChartPreVisitTestData();
		editNoteToSelf(seleniumHost, seleniumPort, browser, webSite, userAccount, noteToSelfData);
	}
	/**
	 * editNoteToSelf
	 * function to edit NoteToSelf
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	  * @since  	    Sep 14, 2012
	 */
	public boolean editNoteToSelf(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib noteToSelfData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + noteToSelfData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, noteToSelfData.userName, noteToSelfData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Announment and click to Edit button //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueName=DateFormat.format(cal.getTime());
			
			
			assertTrue(isElementPresent(selenium,btnNoteEdit),"Could not present the Announcement link;More Details:"+noteToSelfData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNoteEdit),"Could not click edit button;More details:"+noteToSelfData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtNote,noteToSelfData.noteToeSelf+uniqueName),"Could not enter the value;More details:"+noteToSelfData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnNoteSave),"Could not click the save button;More Details:"+noteToSelfData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Verify the details are properly
			//--------------------------------------------------------------------//
			if(!verifyStroeValue(selenium,noteToSelfData,uniqueName)){
				fail("Patient Info details are not edited properly; More Details :"+ noteToSelfData.toString());
				returnValue=false;
			}else
				return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
	public boolean verifyStroeValue(Selenium selenium,ChartPreVisitLib noteToSelfData,String uniqueName){
		waitForPageLoad(selenium);
		if(!getText(selenium,txtNote).trim().contains(noteToSelfData.noteToeSelf+uniqueName.trim())){
			return true;
		}
		return false;
	}
}
