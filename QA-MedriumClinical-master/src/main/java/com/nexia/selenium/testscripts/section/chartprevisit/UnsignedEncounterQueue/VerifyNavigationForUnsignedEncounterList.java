package com.nexia.selenium.testscripts.section.chartprevisit.UnsignedEncounterQueue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyNavigationForUnsignedEncounterList extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNavigationForUnsignedEncounterList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib ecData = new ChartPreVisitLib();
		ecData.workSheetName = "UnsignedEncounterQueue";
		ecData.testCaseId = "TC_UEQ_005";
		ecData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyNavigation(seleniumHost, seleniumPort, browser, webSite, userAccount, ecData);
	}
	/**
	 * verifyNavigation
	 * Function to edit Unsigned Encounter
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 5, 2012
	 */
	
	public boolean verifyNavigation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib ecData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + ecData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, ecData.userName, ecData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to an encounter list from encounter queue//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,"//div[3]/div/div/span[2]"),"Could not click on encounter queue button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			selectValueFromAjaxList(selenium,"suggestBox","All encounters");
			
			//--------------------------------------------------------------------//
			//  Step-3: Select an encounter from the list//
			//--------------------------------------------------------------------//

			waitForElement(selenium, "//div[@id='UnsignedEncounterList']/table/tbody/tr/td/div/div/div[2]/span/div/div/span", WAIT_TIME);
			int count=1;
			
			String number= getText(selenium,"css=span.gwt-InlineHTML");
			Integer noOfEncounters= Integer.parseInt(number);
		
			while(isElementPresent(selenium,"//div[@id='UnsignedEncounterList']/table/tbody/tr["+count+"]/td/div/div/div[2]/span/div/div/span")){
				if(getText(selenium,"//div[@id='UnsignedEncounterList']/table/tbody/tr["+count+"]/td/div/div/div[2]/span/div/div/span").toLowerCase(new java.util.Locale("en","Us")).trim().contains(ecData.patientName.trim().toLowerCase(new java.util.Locale("en","Us")))){
					click(selenium,"//div[@id='UnsignedEncounterList']/table/tbody/tr["+count+"]/td/div/div/div[2]/span/div/div/span");
					if(isElementPresent(selenium,"errorCloseButton")){ 
                        waitForPageLoad(selenium); 
                        assertTrue(click(selenium,"errorCloseButton"),"Could not click error close button"+ecData.toString(),selenium,ClassName,MethodName);
                        waitForPageLoad(selenium); 
					}
					click(selenium,"//div[@id='UnsignedEncounterList']/table/tbody/tr["+count+"]/td/div/div/div[2]/span/div/div/span");
					waitForPageLoad(selenium);
					break;
				}
				else count++;
				if(count>20)
					if(isElementPresent(selenium,"UnsignedEncounterListMoreLink")){
						click(selenium,"UnsignedEncounterListMoreLink");
				}
				if(count==noOfEncounters){
					break;
				}
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Navigation//
			//--------------------------------------------------------------------//
			
			click(selenium,"xpath=(//button[@type='button'])[8]");
			waitForPageLoad(selenium);
			
			if(getText(selenium,"patientName").toLowerCase(new java.util.Locale("en","Us")).trim().contains(ecData.patientName.trim().toLowerCase(new java.util.Locale("en","Us")))){
				return false;
				}
			else return true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
}