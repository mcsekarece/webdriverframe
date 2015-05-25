package com.nexia.selenium.testscripts.section.chartprevisit.SocialHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySelectedItemInSummaryPage extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "function to verify selected Item in summary")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySelectedItemInSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib socialData = new ChartPreVisitLib();
		socialData.workSheetName = "CreateSocialHistory";
		socialData.testCaseId = "TC_CSH_028";
		socialData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	/**
	 * addSocialHistory
	 * function to verify selected Item in summary 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @since  	    Nov 01, 2012
	 */

	public boolean addSocialHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib socialData) throws InterruptedException, IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + socialData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, socialData.userName, socialData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,socialData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
						
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblEncounterSave),"Could not click on encounter save",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Social History //
			//--------------------------------------------------------------------//
			
			
			try{
				selenium.fireEvent(lnkSocialHistory, "click");
			}catch(Exception e){
				selenium.fireEvent(lnkSocialHistory, "click");
			}
			
			
			//assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Social History Entries                    //
			//--------------------------------------------------------------------//
			
			assertTrue(deleteAllSocialHistory(selenium,socialData),"Deletion failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Add Social History//
			//--------------------------------------------------------------------//
			
			assertTrue(createSocialHistory(selenium,socialData),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: verify Selected item show in the summary page//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,chkshowAllRecords),"Could not click the show All recorded check box;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//selenium.chooseOkOnNextConfirmation();
			assertTrue(click (selenium,btnSave),"Could not click the save button;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			//selenium.getConfirmation();
			
			try{
				selenium.fireEvent(lnkSocialHistory, "click");
			}catch(Exception e){
				selenium.fireEvent(lnkSocialHistory, "click");
			}	
			
	
			try{
				selenium.fireEvent(lnkSocialHistory, "click");
			}catch(Exception e){
				selenium.fireEvent(lnkSocialHistory, "click");
			}			
			
			//assertTrue(click(selenium,lnkSocialHistory),"Could not click the social history link;More Details");
			waitForPageLoad(selenium);
			//Check off the created Allergy and save 
			assertTrue(click(selenium,"//td/div/input"),"Could not click the check box;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click the save nutton;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			
			if(getText(selenium,lblSocialDetails1).equalsIgnoreCase("No social history added")){
				returnValue = true;
			}else
				returnValue = false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySelectedItem(Selenium selenium,ChartPreVisitLib socialData) throws InterruptedException{
		Thread.sleep(10000);
		
		//if(!getText(selenium,"//span/div/span").toLowerCase(new java.util.Locale("en","US")).trim().contains(socialData.type.trim().toLowerCase(new java.util.Locale("en","US")))){
		//if(!getText(selenium,"//div[2]/div/div/div/div/div/div[2]/div/span/div/span").toLowerCase(new java.util.Locale("en","US")).trim().contains(socialData.type.trim().toLowerCase(new java.util.Locale("en","US")))){
		if(!getText(selenium,lblSocialDetails2).toLowerCase(new java.util.Locale("en","US")).trim().contains(socialData.type.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}
