package com.nexia.selenium.testscripts.section.chartprevisit.Allergies;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeleteEncounterAllergyInSummary extends AbstractChartPreVisit{
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to verify delete Encounter Allergy in summary page ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteEncounterAllergyInSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_032";
		allergyData.fetchChartPreVisitTestData();
		verifyDeleteAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	
	/**
	 * verifyDeleteAllergy
	 * function to verify delete Encounter Allergy in summary page 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 25, 2012
	 */
	
	public boolean verifyDeleteAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date=null;
		String time=null;
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
			assertTrue(deleteAllEncounters(selenium,allergyData),"could not delete the record", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//

			assertTrue(goToBeginEncounter(selenium),"Could not navigate to encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lblEncounterSave),"could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			

			//Delete All existing Allergy in summary page
			assertTrue(click(selenium,lnkAllergy),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+allergyData.toString());
			//waitForPageLoad(selenium);
			assertTrue(click(selenium,btnCancel),"Could not click the cancel button;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//Navigate to Encounter Page
			assertTrue(goToBeginEncounter(selenium),"could not navigate to encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//Delete All Existing Allergies in Encounter Page 
			assertTrue(deleteAllEncounterAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Click on Allergies Link in Encounter Page
			assertTrue(isElementPresent(selenium,lnkAllergy),"Could not find the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkAllergy,"");
			
			//--------------------------------------------------------------------//
			//  Step-3: Add Allergy                                               //
			//--------------------------------------------------------------------//
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy");
				date=DateFormat.format(cal.getTime());
				
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy");
				date=DateFormat.format(cal.getTime());
				
			}
			
			//--------------------------------------------------------------------//
			//  Step-8: verify Stored Value for Allergy in List view //
			//--------------------------------------------------------------------//
			
			
			assertTrue(click(selenium,lnkSummary),"Could not click the link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyStoredValueForAllergyWithSummaryPage(selenium,allergyData,userAccount),"Details is not stored", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-7: verify Stored Value for Allergy in List view //
			//--------------------------------------------------------------------//
		
			assertTrue(deleteAllEncounterAllergy(selenium,allergyData ),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Click on save in Encounter Page
			assertTrue(click(selenium,saveAllergyButton),"unable to click the allery save button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			int count=0;
			while(isElementPresent(selenium,lnkBeginEncounterAction)){
			selenium.clickAt(lnkBeginEncounterAction,"");
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lblEncounterSave)){
				break;
			}
			
			if(count>10){
				break;
			}
				
			}
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-10: Verify delete Allergries in summary page                //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSummary),"Could not click on summary link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			/*if(!getText(selenium,"//td[2]/div/div/div/div/div/div[2]/div[2]/div/div/div/div/div/div[2]/div/span").equalsIgnoreCase("No known drug allergies")){
				fail("Deletion Failed");
				returnValue = false;
			}else
				returnValue=true;*/
			
			assertTrue(selenium.isTextPresent("No allergies added"),"No known drug allergies is  present", selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
}
