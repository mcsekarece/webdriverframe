package com.nexia.selenium.testscripts.section.chartprevisit.MedicalAndSurgicalHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForProcedure extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to verify tabbing order for Procedure")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForProcedure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProcedure";
		proData.testCaseId = "TC_CP_002";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTabbingOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	/**
	 * verifyTabbingOrder
	 * Function to verify tabbing order for Procedure
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 06, 2012
	 */	
	public void verifyTabbingOrder(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,ChartPreVisitLib injectionData) throws InterruptedException, IOException{
		Selenium selenium = null;
		try{
			String csspaths[]={tabSearchProcedure, tabProcedureDate};
				
			String csspaths1[]={ tabAjxProCp1t, tabSummaryComment, tabChkConsentBox};
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
			//  Step-3: Navigate to Injection                             //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkProcedure),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
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
			assertTrue(click(selenium,"medicationsMoreDetails"),"Could not click the show more details link",selenium, ClassName, MethodName);
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
