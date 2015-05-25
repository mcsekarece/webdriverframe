package com.nexia.selenium.testscripts.section.chartprevisit.SocialHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCreateEncounterSocialHistoryInSummary extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Create Encounter Social History ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createSocialHistoryWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib socialData = new ChartPreVisitLib();
		socialData.workSheetName = "CreateSocialHistory";
		socialData.testCaseId = "TC_CSH_018";
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
			//  Step-3: Delete Family History//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllSocialHistory(selenium,socialData ),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
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
			
			assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the button;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: verify Stored Value in summary page//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the  Social histoy link;More Details",selenium, ClassName, MethodName);
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
			
			assertTrue(click(selenium,btnProEdit),"Could not click the edit link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyStoredValue(selenium,socialData)){
				Assert.fail("History details not saved properly; More Details :"+ socialData.toString());
			
			}
			else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
			
	public boolean verifyStoredValue(Selenium selenium, ChartPreVisitLib proData) throws IOException{
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkSocialShowMore),"Could not on show more button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
			
		if(!getValue(selenium,ajxType).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(proData.type.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
	/*	if(!getValue(selenium,ajxStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		if(!getValue(selenium,txtSocialQuickList).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.item.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getValue(selenium,txtDetailsNumBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.detailsNum.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getValue(selenium,txtDetailsSmallBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.detailsNum.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,ajxPeriod).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.period.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtYear).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.year.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtStartAge).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.startAge.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,ajxStopped).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.historyType.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,ajxLifeStage).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.lifeStage.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtcomment).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.comment.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}