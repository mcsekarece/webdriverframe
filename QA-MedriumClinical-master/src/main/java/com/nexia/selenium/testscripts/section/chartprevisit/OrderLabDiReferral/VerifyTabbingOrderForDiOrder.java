package com.nexia.selenium.testscripts.section.chartprevisit.OrderLabDiReferral;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForDiOrder extends AbstractChartPreVisit{
	

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify tabbing order for Diagnostic imaging")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForDiOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateDiganosticImaging";
		orderData.testCaseId = "TC_ODI_001";
		orderData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyTabbingOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	
	/**
	 * verifyTabbingOrder
	 * verify tabbing order for diagnostic imaging
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @param orderData
	 * @throws InterruptedException
	 * @throws IOException 
	 * @since Dec 04, 2012
	 */
	public void verifyTabbingOrder(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,ChartPreVisitLib orderData) throws InterruptedException, IOException{
		Selenium selenium = null;
		try{
			String csspaths[]={"css=#labTestNameSuggestBox", "css=textarea.width370px.height50", "//span/input", "css=input.width370px"};
				
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + orderData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, orderData.userName, orderData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,orderData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Diagnostic Imaging Page//
			//--------------------------------------------------------------------//
			assertTrue(clickDiIcon(selenium,orderData),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ---------//
			//  Step-5:Tab order                                        //
			//--------------------------------------------------------------------//
			for(int i =0;i<csspaths.length;i++){
				assertTrue(isElementPresent(selenium,csspaths[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspaths[i]);
				waitForElementToEnable(selenium,csspaths[i]);
				selenium.keyPress(csspaths[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths[i]));
			}
			
	}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}