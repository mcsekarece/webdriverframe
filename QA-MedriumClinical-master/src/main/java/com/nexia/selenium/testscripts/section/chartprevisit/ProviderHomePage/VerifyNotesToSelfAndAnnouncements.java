package com.nexia.selenium.testscripts.section.chartprevisit.ProviderHomePage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.taskManagement.AbstractTaskManagement;
import com.nexia.selenium.genericlibrary.taskManagement.TaskManagementLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyNotesToSelfAndAnnouncements extends AbstractChartPreVisit {
    	@Test(groups = {"Regression","Approved","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a Announcement")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editAnnouncementForProviderHomePage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib announcementData = new ChartPreVisitLib();
		announcementData.workSheetName = "ProviderHomePage";
		announcementData.testCaseId = "TC_PHPA_003";
		announcementData.fetchChartPreVisitTestData();
		editAnnounment(seleniumHost, seleniumPort, browser, webSite, userAccount, announcementData);
	}
    	
    	@Test(groups = {"Regression","Approved","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a Announcement")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLineFeedFromAnouncements(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib announcementData = new ChartPreVisitLib();
		announcementData.workSheetName = "ProviderHomePage";
		announcementData.testCaseId = "TC_PHPA_004";
		announcementData.fetchChartPreVisitTestData();
		editAnnounment(seleniumHost, seleniumPort, browser, webSite, userAccount, announcementData);
	}
    	
	/**
	 * editAnnounment
	 * function to editAnnounment
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Sep 14, 2012
	 */
	public boolean editAnnounment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib announcementData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + announcementData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, announcementData.userName, announcementData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Announment and click to Edit button //
			//--------------------------------------------------------------------//
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueName=DateFormat.format(cal.getTime());
			
			
			assertTrue(isElementPresent(selenium,btnAnnEdit),"Could not present the Announcement link;More Details:"+announcementData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAnnEdit),"Could not click edit button;More details:"+announcementData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAnnouncement,announcementData.announcements+uniqueName),"Could not enter the value;More details:"+announcementData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAnnsave),"Could not click the save button;More Details:"+announcementData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(announcementData.testCaseId.equals("TC_PHPA_004")){
			    click(selenium,btnAnnEdit);
			
			
			if(!getValue(selenium,txtAnnouncement).trim().contains(announcementData.announcements+uniqueName.trim())){
				return false;
			}
			return true;
			}
			assertTrue(isElementPresent(selenium,btnNoteEdit),"Could not present the Announcement link;More Details:"+announcementData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNoteEdit),"Could not click edit button;More details:"+announcementData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtNote,announcementData.noteToeSelf+uniqueName),"Could not enter the value;More details:"+announcementData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnNoteSave),"Could not click the save button;More Details:"+announcementData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			AbstractTaskManagement task = new AbstractTaskManagement();
			TaskManagementLib tasklib = new TaskManagementLib();
			assertTrue(task.logoutofApplication(selenium,tasklib),"Logout Application failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, "TESTPROVIDER", "aspire@123"),"Login Failed while using the password which has been reset",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Verify the details are properly
			//--------------------------------------------------------------------//
			if(!verifyStroeValue(selenium,announcementData,uniqueName)){
				fail("Patient Info details are not edited properly; More Details :"+ announcementData.toString());
				returnValue=false;
			}
			
			assertTrue(task.logoutofApplication(selenium,tasklib),"Logout Application failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			ChartPreVisitLib historyData = new ChartPreVisitLib();
			historyData.workSheetName = "VerifySecurityOption";
			historyData.testCaseId = "TC_VSP_001";
			historyData.fetchChartPreVisitTestData();
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(switchRole(selenium,historyData.switchRole),"Could not change the switch role;More Details:"+historyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,btnAnnEdit),"Could not present the Announcement link;More Details:"+announcementData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAnnEdit),"Could not click edit button;More details:"+announcementData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAnnouncement,announcementData.announcements+uniqueName),"Could not enter the value;More details:"+announcementData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAnnsave),"Could not click the save button;More Details:"+announcementData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,btnNoteEdit),"Could not present the Announcement link;More Details:"+announcementData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNoteEdit),"Could not click edit button;More details:"+announcementData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtNote,announcementData.noteToeSelf+uniqueName),"Could not enter the value;More details:"+announcementData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnNoteSave),"Could not click the save button;More Details:"+announcementData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			historyData.workSheetName = "VerifySecurityOption";
			historyData.testCaseId = "TC_VSP_002";
			historyData.fetchChartPreVisitTestData();
			
			assertTrue(switchRole(selenium,historyData.switchRole),"Could not change the switch role;More Details:"+historyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyStoreValue(selenium,announcementData,uniqueName)){
				fail("Patient Info details are not edited properly; More Details :"+ announcementData.toString());
				returnValue=false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyStroeValue(Selenium selenium,ChartPreVisitLib announcementData,String uniqueName){
		waitForPageLoad(selenium);
		boolean returnValue=true;
		if(getText(selenium,txtAnnouncement).trim().contains(announcementData.announcements+uniqueName.trim())){
			return false;
		}
		if(getText(selenium,txtNote).trim().contains(announcementData.noteToeSelf+uniqueName.trim())){
			return false;
		}
		return returnValue;
	}
	
	public boolean verifyStoreValue(Selenium selenium,ChartPreVisitLib announcementData,String uniqueName){
		waitForPageLoad(selenium);
		boolean returnValue=true;
		
		click(selenium,btnAnnEdit);
		
		if(!getValue(selenium,txtAnnouncement).trim().contains(announcementData.announcements+uniqueName.trim())){
			return false;
		}
		
		
		click(selenium,btnNoteEdit);
		
		if(!getValue(selenium,txtNote).trim().contains(announcementData.noteToeSelf+uniqueName.trim())){
			return false;
		}
		
		click(selenium,btnNoteSave);
		waitForPageLoad(selenium);
		
		return returnValue;
	}
	
}