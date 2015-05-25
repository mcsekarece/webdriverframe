package com.nexia.selenium.testscripts.section.chartprevisit.Immunization;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;

import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForImmunization extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying tabbing order of medical summary-Immunization.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_003";
		immunizationData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyTabbingOrderForImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
		}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying tabbing order of medical summary-Refused by Immunization.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForRefusedImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_001";
		immunizationData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyTabbingOrderForImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying tabbing order of medical summary-Administered By Immunization.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForAdministeredImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_002";
		immunizationData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyTabbingOrderForImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}

	/**
	 * verifyTabbingOrderForImmunization
	 * function to verify tabbing order
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 02, 2012
	 */
	public boolean verifyTabbingOrderForImmunization(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,ChartPreVisitLib immunizationData) throws InterruptedException, IOException{
		
		Selenium selenium = null;
	    String csspaths0[]={ajxcanSuggestbox,txtCssRefeused,txtRefusedComment};
	    String csspaths1[]={ajxcanSuggestbox1,txtCssadmin,tabComment};
		
	    try{			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + immunizationData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, immunizationData.userName, immunizationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,immunizationData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Click the Contact Link //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkImmunization),"Could not click Immunization link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Tab order //
			//--------------------------------------------------------------------//
			if(immunizationData.refused.equalsIgnoreCase("yes")){		
		
			  assertTrue(click(selenium,chkrefused),"Could not click refused by patient check box", selenium, ClassName, MethodName);
		  
			  if(!userAccount.equals(CAAccount)){
				  csspaths0[0]=txtRefusedImmunization;
				  	 } 
				  for(int i =0;i<csspaths0.length;i++){
					assertTrue(isElementPresent(selenium,csspaths0[i]),"Not found", selenium, ClassName, MethodName);
					selenium.focus(csspaths0[i]);
					waitForElementToEnable(selenium,csspaths0[i]);
					selenium.keyPress(csspaths0[i], "\\9");
					Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths0[i]));
					}
				 return true;
			}
			else if(immunizationData.admin.equalsIgnoreCase("Yes")){
				assertTrue(click(selenium,chkadmin),"Could not click administered elsewhere check box", selenium, ClassName, MethodName);
				if(!userAccount.equals(CAAccount)){
					 csspaths1[0]=ajxImmunization;
				 }			
  		
				for(int i =0;i<csspaths1.length;i++){
					assertTrue(isElementPresent(selenium,csspaths1[i]),"Not found", selenium, ClassName, MethodName);
					selenium.focus(csspaths1[i]);
					waitForElementToEnable(selenium,csspaths1[i]);
					selenium.keyPress(csspaths1[i], "\\9");
					Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths1[i]));
					}
			}
			else{
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkImmShowMore),"Could not click show more details button", selenium, ClassName, MethodName);
				assertTrue(click(selenium,chkConsentBox),"Could not click consent check box", selenium, ClassName, MethodName);
				String csspaths2[]={"css=#searchVaccineBox",txtLotNo,"css=#dosageValue","css=#dosagesuggestBox","css=#expiryDate",txtadminDate,"css=#series1suggestBox","css=#series2suggestBox","css=#administeredBy","css=#sitesuggestBox","css=#cpt1suggestBox","css=#routesuggestBox","css=#cpt2suggestBox","//div[4]/div/span/input","css=#consentsuggestBox","css=#reactionsuggestBox",txtImmComment};
				
				for(int i =0;i<csspaths2.length;i++){
					assertTrue(isElementPresent(selenium,csspaths2[i]),"Not found", selenium, ClassName, MethodName);
					selenium.focus(csspaths2[i]);
					waitForElementToEnable(selenium,csspaths2[i]);
					selenium.keyPress(csspaths2[i], "\\9");
					Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths2[i]));
					}
			}
			}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}


