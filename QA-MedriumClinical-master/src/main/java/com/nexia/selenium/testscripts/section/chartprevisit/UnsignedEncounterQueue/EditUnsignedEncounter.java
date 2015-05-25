package com.nexia.selenium.testscripts.section.chartprevisit.UnsignedEncounterQueue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class EditUnsignedEncounter extends AbstractChartPreVisit {
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editUnsignedEncounterFromEncounterQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib ecData = new ChartPreVisitLib();
		ecData.workSheetName = "UnsignedEncounterQueue";
		ecData.testCaseId = "TC_UEQ_001";
		ecData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editUnsignedEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, ecData);
	}
	/**
	 * editUnsignedEncounter
	 * Function to edit Unsigned Encounter
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite 
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @since  	    Nov 1, 2012
	 */
	
	public boolean editUnsignedEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib ecData) throws InterruptedException, IOException{
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
			//  Step-2: Switch Role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,ecData.switchRole),"Could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to an encounter list from encounter queue//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,"//div[@id='Unsignedencounters']/div/span[2]"),"Could not click on encounter queue button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			assertTrue(selectValueFromAjaxList(selenium,"suggestBox","My encounters"),"Selection failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Select an encounter from the list//
			//--------------------------------------------------------------------//

			waitForElement(selenium, "//div[@id='UnsignedEncounterList']/table/tbody/tr/td/div/div/div[2]/span/div/div/span", WAIT_TIME);
			int count=1;
			
			String number= getText(selenium,"//div[@id='Unsignedencounters']/div/span");
			Integer noOfEncounters= Integer.parseInt(number);
		
			while(isElementPresent(selenium,"//div[@id='UnsignedEncounterList']/table/tbody/tr["+count+"]/td/div/div/div[2]/span/div/div/span")){
				if(getText(selenium,"//div[@id='UnsignedEncounterList']/table/tbody/tr["+count+"]/td/div/div/div[2]/span/div/div/span").toLowerCase(new java.util.Locale("en","Us")).trim().contains(ecData.patientName.trim().toLowerCase(new java.util.Locale("en","Us")))){
					click(selenium,"//div[@id='UnsignedEncounterList']/table/tbody/tr["+count+"]/td/div/div/div[2]/span/div/div/span");
					waitForPageLoad(selenium);
					break;
				}
				else count++;
				if(count>50)
					if(isElementPresent(selenium,"UnsignedEncounterListMoreLink")){
						click(selenium,"UnsignedEncounterListMoreLink");
						Thread.sleep(1000);
				}
				else if(count==noOfEncounters){
					break;
				}
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Edit the selected encounter from the list//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"//div[@id='unsignedEncounterListItem']/div/div[2]"),"Could not click on encounter;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
									   //div[@id='unsignedEncounterListItem']/div/div[2]
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			assertTrue(editUnsignedEncounters(selenium,ecData,userAccount), "Creation failed",selenium,ClassName,MethodName);
			
			if(isElementPresent(selenium,"sign")){
				return false;
				}
			else return true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
}




