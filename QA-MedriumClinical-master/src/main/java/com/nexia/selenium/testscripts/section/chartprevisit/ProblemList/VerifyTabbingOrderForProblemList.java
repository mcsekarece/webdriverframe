package com.nexia.selenium.testscripts.section.chartprevisit.ProblemList;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForProblemList extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "VerifyTabbbing order for Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPL_040";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTabbingOrderForProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	/**
	 * verifyTabbingOrderForProblemList
	 * Function to verify tabbing order for Problem List
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 02, 2012
	 */	
	public void verifyTabbingOrderForProblemList(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,ChartPreVisitLib injectionData) throws InterruptedException, IOException{
		Selenium selenium = null;
		try{
			String csspaths[]={tabMedical,tabOnset, tabItem};
			String csspaths1[]={tablifeStage, tabResolve, tabCodeingSys, tabComment};
				
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + injectionData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, injectionData.userName, injectionData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,injectionData.patientId);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ---------//
			//  Step-3: Navigate to Problem List                             //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
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
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkProblemListShowMore),"Could not click the show more details link",selenium, ClassName, MethodName);
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
