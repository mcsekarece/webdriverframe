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

public class EditAnnouncement extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a Announcement")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editAnnouncementForProviderHomePage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib announcementData = new ChartPreVisitLib();
		announcementData.workSheetName = "ProviderHomePage";
		announcementData.testCaseId = "TC_PHPA_001";
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
			//--------------------------------------------------------------------//
			//  Step-3:Verify the details are properly
			//--------------------------------------------------------------------//
			if(!verifyStroeValue(selenium,announcementData,uniqueName)){
				fail("Patient Info details are not edited properly; More Details :"+ announcementData.toString());
				returnValue=false;
			}else
				return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
	public boolean verifyStroeValue(Selenium selenium,ChartPreVisitLib announcementData,String uniqueName){
		waitForPageLoad(selenium);
		if(!getText(selenium,txtAnnouncement).trim().contains(announcementData.announcements+uniqueName.trim())){
			return true;
		}
		return false;
	}
}
