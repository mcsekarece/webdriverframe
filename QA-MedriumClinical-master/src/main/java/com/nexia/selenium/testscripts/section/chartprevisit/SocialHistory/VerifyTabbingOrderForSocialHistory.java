package com.nexia.selenium.testscripts.section.chartprevisit.SocialHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForSocialHistory extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Family History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbing(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib socialData = new ChartPreVisitLib();
		socialData.workSheetName = "CreateSocialHistory";
		socialData.testCaseId = "TC_CSH_031";
		socialData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		tabbingOrderForSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	/**
	 * verifyTabbingOrderForCases
	 * Function to verify tabbing order
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	     Mar 22, 2012
	 */	
	public void tabbingOrderForSocialHistory(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,ChartPreVisitLib historyData) throws InterruptedException, IOException{
		Selenium selenium = null;
		try{
			String csspaths[]={tabtype,tabStatus};
			String csspaths1[]={tabSocial,tabDetailsTextBox,tabYear,tabStartAge,tabStopped,tabSociallifeStage,tabSummaryComment};
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + historyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ---------//
			//  Step-3: Navigate to FamilyHistory                                         //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSocialShowMore),"Could not click the show more details link",selenium, ClassName, MethodName);
			//---------------------------------------------------------- ---------//
			//  Step-4:Tab order                                        //
			//--------------------------------------------------------------------//
			for(int i =0;i<csspaths.length;i++){
				assertTrue(isElementPresent(selenium,csspaths[i]),"Not found",selenium, ClassName, MethodName);
				selenium.focus(csspaths[i]);
				waitForElementToEnable(selenium,csspaths[i]);
				selenium.keyPress(csspaths[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths[i]));
			}
			//---------------------------------------------------------- ---------//
			//  Step-5:Tab order With Show More Details                                       //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSocialShowMore),"Could not click the show more details link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			for(int i =0;i<csspaths1.length;i++){
				assertTrue(isElementPresent(selenium,csspaths1[i]),"Not found",selenium, ClassName, MethodName);
				selenium.focus(csspaths1[i]);
				waitForElementToEnable(selenium,csspaths1[i]);
				selenium.keyPress(csspaths1[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths1[i]));
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)");
		}
	}
}
