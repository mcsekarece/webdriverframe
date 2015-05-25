package com.nexia.selenium.testscripts.section.chartprevisit.Allergies;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySelectedItemInSummaryPage extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to Verify whether selected value is present in summary page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySelectedItemInSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_037";
		allergyData.fetchChartPreVisitTestData();
		verifySelectedItem(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	/**
	 * verifySelectedItem
	 * Function to Verify whether selected value is present in summary page. 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 29, 2012
	 */
	
	public boolean verifySelectedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,allergyData),"Could not delete the record", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//

			assertTrue(goToBeginEncounter(selenium),"Could not navigate the encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lblEncounterSave),"could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			try{
				selenium.fireEvent(lnkAllergy, "click");
			}catch(Exception e){
				selenium.fireEvent(lnkAllergy, "click");
			}
		
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Delete All Existing Allergy                               //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Add Allergy//
			//--------------------------------------------------------------------//
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: verify Selected item show in the summary page//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,chkshowAllRecords),"Could not click the show All recorded check box;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click (selenium,btnSave),"Could not click the save button;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			assertTrue(verifySelectedItem(selenium,allergyData,userAccount),"Allergy details not saved properly; More Details :"+ allergyData.toString(), selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			try{
				selenium.fireEvent(lnkAllergy, "click");
			}catch(Exception e){
				selenium.fireEvent(lnkAllergy, "click");
			}
			
			assertTrue(click(selenium,"css=div > input[type='checkbox']"),"Could not click the check box;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click the save nutton;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			
			assertTrue(!getText(selenium,"//div[4]/table/tbody/tr[2]/td[2]/div/div/div/div[2]").contains(allergyData.allergen),"Could not match the data", selenium, ClassName, MethodName);
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySelectedItem(Selenium selenium,ChartPreVisitLib allergyData, String account){
		if(account.equalsIgnoreCase(CAAccount)){
			if(!getText(selenium,"//span[@id='detailPanel']/div/div/span[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(allergyData.allergenCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			return true;
		}
		else{
			if(!getText(selenium,"//span[@id='detailPanel']/div/div/span[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(allergyData.allergen.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			return true;
		}
		
	}
}

