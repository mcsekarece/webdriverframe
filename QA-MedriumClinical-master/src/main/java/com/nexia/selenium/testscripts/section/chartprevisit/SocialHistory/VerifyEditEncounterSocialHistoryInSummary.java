package com.nexia.selenium.testscripts.section.chartprevisit.SocialHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditEncounterSocialHistoryInSummary  extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for EditEncounter SocialHistory In Summary ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyeditEncounterSocialHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib socialData = new ChartPreVisitLib();
		socialData.workSheetName = "CreateSocialHistory";
		socialData.testCaseId = "TC_CSH_024";
		socialData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	/**
	 * addSocialHistory
	 * function to add SocialHistory
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 23, 2012
	 */

	public boolean editSocialHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib socialData) throws IOException{
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
			//  Step-3: Delete Social History//
			//--------------------------------------------------------------------//
			 assertTrue(click(selenium,lnkSocialHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllSocialHistory(selenium,socialData),"Deletion failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 
			assertTrue(click(selenium,btnSocialHistorysave),"Could not click the save button;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,socialData),"Deletion failed",selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
	

			
			//--------------------------------------------------------------------//
			//  Step-5: Delete Social History//
			//--------------------------------------------------------------------//
			

			
		//	assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.focus(lnkEncounterSoicalHistory);
			selenium.clickAt(lnkEncounterSoicalHistory,"");
			//selenium.focus(lnkSocialHistory);
			//selenium.fireEvent(lnkSocialHistory,"keypress");			
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Social History//
			//--------------------------------------------------------------------//
			
			assertTrue(createSocialHistory(selenium,socialData),"Creation failed",selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: verify Stored Value in summary page//
			//--------------------------------------------------------------------//
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
				selenium.chooseOkOnNextConfirmation();
			}
			waitForPageLoad(selenium);
			selenium.focus(lnkSummary);
			assertTrue(click(selenium,lnkSummary),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: verify Stored Value in Social History //
			//--------------------------------------------------------------------//
			if(!verifyCollapseView(selenium,socialData)){
				Assert.fail("History details not saved properly; More Details :"+ socialData.toString());
				
			}
			
			if(!verifyExpandView(selenium,socialData)){
				Assert.fail("History details not saved properly; More Details :"+ socialData.toString());
			}		waitForPageLoad(selenium);
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
				selenium.chooseOkOnNextConfirmation();
			}
			assertTrue(click(selenium,btnSocialHistorysave),"Could not click the save button;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
						
			//--------------------------------------------------------------------//
			//  Step-9:Again  Navigate to Encounter //
			//--------------------------------------------------------------------//
			try{
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}catch(Exception e){
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}if(isElementPresent(selenium,lblEncounterChoosePanel))
				if(isElementPresent(selenium,"css=div.pointer > table > tbody > tr"))
					click(selenium,"css=div.pointer > table > tbody > tr");		
			
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"Could not click Close Button",selenium,ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-10: Edit Encounter Social History//
			//--------------------------------------------------------------------//
			
			assertTrue(isElementPresent(selenium,lblEnSumSocHistoryDetails),"Could not find the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.focus(lblEnSumSocHistoryDetails);
			selenium.clickAt(lblEnSumSocHistoryDetails,"");
			assertTrue(click(selenium,lblSocialHis),"Could not click the button;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(click(selenium,btnEditSocHis),"Could not click the edit button;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			
			socialData.workSheetName = "CreateSocialHistory";
			socialData.testCaseId = "TC_CSH_025";
			socialData.fetchChartPreVisitTestData();
			assertTrue(createSocialHistory(selenium,socialData),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the button;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11: verify Stored Value in Social History //
			//--------------------------------------------------------------------//
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
				selenium.chooseOkOnNextConfirmation();
			}
			assertTrue(click(selenium,lnkSummary),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			if(!verifyCollapseView(selenium,socialData)){
				Assert.fail("History details not saved properly; More Details :"+ socialData.toString());
				
			}
			
			if(!verifyExpandView(selenium,socialData)){
				Assert.fail("History details not saved properly; More Details :"+ socialData.toString());
			}
			
			return true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyCollapseView(Selenium selenium,ChartPreVisitLib historyData){
		if(!selenium.isTextPresent(historyData.type.trim())){
			return false;
		}
	
		if(!selenium.isTextPresent(historyData.detailsNum.trim())){
			return false;
		}
		if(!selenium.isTextPresent(historyData.detailsNum.trim())){
			return false;
		}
		if(!selenium.isTextPresent(historyData.period.trim())){
			return false;
		}
		if(!selenium.isTextPresent(historyData.year.trim())){
			return false;
		}
		if(!selenium.isTextPresent(historyData.comment.trim())){
			return false;
		}
		return true;
	}
	public boolean verifyExpandView(Selenium selenium,ChartPreVisitLib historyData) throws IOException{
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lblProCollapseView),"Colud not click the arrow;More Details:"+historyData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		
		if(!selenium.isTextPresent(historyData.lifeStage.trim())){
			waitForPageLoad(selenium);
			return false;
		}
		if(!selenium.isTextPresent(historyData.startAge.trim())){
			return false;
		}
		if(!selenium.isTextPresent(historyData.historyType.trim())){
			return false;
		}
		return true;
	}
}

