package com.nexia.selenium.testscripts.section.chartprevisit.SocialHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeleteEncounterSocialHistoryInSummary extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Delete Encounter Social History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteEncounterSocialHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib socialData = new ChartPreVisitLib();
		socialData.workSheetName = "CreateSocialHistory";
		socialData.testCaseId = "TC_CSH_021";
		socialData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
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

	public boolean addSocialHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib socialData) throws IOException{
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
			 
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete Social History//
			//--------------------------------------------------------------------//
	
			
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkSocialHistory,"");
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
			assertTrue(click(selenium,lnkSummary),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: verify Stored Value in Family History //
			//--------------------------------------------------------------------//
						
			if(!verifyCollapseViewForSocialHistory(selenium,socialData,userAccount)){
				Assert.fail("Social History details not saved properly in Collapse View; More Details:");
					
			}
			
			if(!verifyExpandViewForSocialHistory(selenium,socialData,userAccount)){
				Assert.fail("Social History details not saved properly in Expand View; More Details:");
			}
			
			
			assertTrue(click(selenium,btnSOSave),"Could not click the Social save button;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9:Again  Navigate to Encounter //
			//--------------------------------------------------------------------//
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
				selenium.chooseOkOnNextConfirmation();
			}
			try{
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}catch(Exception e){
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}if(isElementPresent(selenium,lblEncounterChoosePanel))
				if(isElementPresent(selenium,"css=div.pointer > table > tbody > tr"))
					click(selenium,"css=div.pointer > table > tbody > tr");	
			
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
				selenium.chooseOkOnNextConfirmation();
			}
			
			//--------------------------------------------------------------------//
			//  Step-10: Delete Encounter Social History//
			//--------------------------------------------------------------------//
			selenium.clickAt(lnkSocialHistory,"");
			//selenium.focus(lnkSocialHistory);
			//selenium.fireEvent(lnkSocialHistory,"keypress");			
			waitForPageLoad(selenium);
			assertTrue(deleteSocialHistoryForEncounter(selenium,socialData ),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		
			
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblEncounterSave),"Could not click on save",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11: verify Stored Value in Spocial History //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lblFamilyUppercase)){
				returnValue = false;
			}else
				returnValue=true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
		
	/*public boolean verifyCollapseView(Selenium selenium,ChartPreVisitLib historyData){
		if(!getText(selenium,lblCollapseView1).trim().contains(historyData.type.trim())){
			return false;
		}
		if(!getText(selenium,lblCollapseView1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(historyData.status.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getText(selenium,lblCollapseView1).trim().contains(historyData.detailsNum.trim())){
			return false;
		}
		if(!getText(selenium,lblCollapseView1).trim().contains(historyData.detailsText.trim())){
			return false;
		}
		if(!getText(selenium,lblCollapseView1).trim().contains(historyData.period.trim())){
			return false;
		}
		if(!getText(selenium,lblCollapseView1).trim().contains(historyData.year.trim())){
			return false;
		}
		if(!getText(selenium,lblCollapseView1).trim().contains(historyData.comment.trim())){
			return false;
		}
		return true;
	}*/
	/*public boolean verifyExpandView(Selenium selenium,ChartPreVisitLib historyData) throws IOException{
		assertTrue(click(selenium,lnlSocialArrow),"Colud not click the arrow;More Details:"+historyData.toString(),selenium, ClassName, MethodName);
		System.out.println(getText(selenium,lblFamilyExpanView));
		System.out.println(historyData.lifeStage);
		if(!getText(selenium,lblFamilyExpanView).trim().contains(historyData.lifeStage.trim())){
			return false;
		}
		if(!getText(selenium,lblFamilyExpanView).toLowerCase(new java.util.Locale("en","Us")).trim().contains(historyData.startAge.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getText(selenium,lblFamilyExpanView).trim().contains(historyData.historyType.trim())){
			return false;
		}
		return true;
	}*/
}

