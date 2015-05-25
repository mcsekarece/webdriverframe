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

public class VerifyEditEncounterAllergyInSummaryPage extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to verify Edit Encounter Allergy in summary page ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditEncounterAllergyInSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_034";
		allergyData.fetchChartPreVisitTestData();
		verifyEditAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	
	/**
	 * verfiyEditAllergy
	 * function to verify create Encounter Allergy in summary page 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 25, 2012
	 */
	public boolean verifyEditAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws IOException{
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
			assertTrue(deleteAllEncounters(selenium,allergyData),"", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Delete All existing Allergy in summary page//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,btnAllergyCancel),"Could not click the cancel button;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"could not navigate to the encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			
			//--------------------------------------------------------------------//
			//  Step-5:DeleteAllergy in Encounter page //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllEncounterAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Click on Allergies Link in Encounter Page
			selenium.clickAt(lnkEncounterAllergy,"");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Add Allergy                                               //
			//--------------------------------------------------------------------//
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//Get Current date and Time
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MMM d, yyyy");
				date=DateFormat.format(cal.getTime());
				DateFormat=new SimpleDateFormat("HH");
				time=DateFormat.format(cal.getTime());
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy");
				date=DateFormat.format(cal.getTime());
				DateFormat=new SimpleDateFormat("HH");
				time=DateFormat.format(cal.getTime());
			}
			
			//--------------------------------------------------------------------//
			//  Step-7: verify Stored Value for Allergy in List view //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSummary),"Could not click on summary link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(verifyCollapseView(selenium,allergyData,userAccount),"Allergy details not saved properly; More Details :"+ allergyData.toString(), selenium, ClassName, MethodName);
			
			assertTrue(verifyExpandView(selenium,allergyData,date,time),"Allergy details not saved properly; More Details :"+ allergyData.toString(), selenium, ClassName, MethodName);
			
			
			
			assertTrue(click(selenium,btnAllergyCancel),"Could not click the cancel button;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-8:Again  Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"could not navigate to the encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			
			assertTrue(isElementPresent(selenium,lblEncounterAllergy),"Could not find the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lblEncounterAllergy,"");
			
			
			//--------------------------------------------------------------------//
			//  Step-9:click on Edit button //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit1),"Could not click the edit button;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
				
			allergyData.workSheetName = "CreateAllergy";
			allergyData.testCaseId = "TC_CA_004";
			allergyData.fetchChartPreVisitTestData();
			
			//Edit Allergy
			assertTrue(editAllergy(selenium,allergyData,userAccount),"Edit Allergy failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Get current date and Time
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy");
				date=DateFormat.format(cal.getTime());
				DateFormat=new SimpleDateFormat("HH");
				time=DateFormat.format(cal.getTime());
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy");
				date=DateFormat.format(cal.getTime());
				DateFormat=new SimpleDateFormat("HH");
				time=DateFormat.format(cal.getTime());
			}
			
		assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the button;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Navigate to Summary Page//
			//--------------------------------------------------------------------//

			assertTrue(click(selenium,lnkSummary),"Could not click on summary link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAllergy),"selenium, ClassName, MethodName", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		//	assertTrue(click(selenium,lnkAllergy),"selenium, ClassName, MethodName", selenium, ClassName, MethodName);
			
			assertTrue(verifyCollapseView(selenium,allergyData,userAccount),"Allergy details not saved properly; More Details :"+ allergyData.toString(), selenium, ClassName, MethodName);
			
			
			assertTrue(verifyExpandView(selenium,allergyData,date,time),"Allergy details not saved properly; More Details :"+ allergyData.toString(), selenium, ClassName, MethodName);
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyCollapseView(Selenium selenium,ChartPreVisitLib allergyData, String userAccount){
				
		try
		{
			if(userAccount.equals(CAAccount)){
				assertTrue(selenium.isTextPresent(allergyData.allergenCa),"Could not find Allgery", selenium, ClassName, MethodName);		
			}
			else{
				assertTrue(selenium.isTextPresent(allergyData.allergen.toUpperCase()),"Could not find Allgery", selenium, ClassName, MethodName);
						}
			assertTrue(selenium.isTextPresent(allergyData.severity.toUpperCase()),"Could not find Severity", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(allergyData.status),"Could not find status", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(allergyData.comment),"Could not find Cooment", selenium, ClassName, MethodName);
			
					return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
		
	}
	public boolean verifyExpandView(Selenium selenium,ChartPreVisitLib allergyData,String date,String time) throws IOException{
		
	
		click(selenium,lblAllergyCollapseView);
	
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(allergyData.lifeStage.trim()),"Could not find Life stage", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(date),"Could not find date", selenium, ClassName, MethodName);
		
		
		return true;
	}
}
	
