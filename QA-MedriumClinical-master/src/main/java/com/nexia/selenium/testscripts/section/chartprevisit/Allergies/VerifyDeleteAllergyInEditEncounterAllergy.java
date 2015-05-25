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

public class VerifyDeleteAllergyInEditEncounterAllergy extends AbstractChartPreVisit{
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to verify edit Allergy in Encounter From Summary")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditAllergyInEncounterFromSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_042";
		allergyData.fetchChartPreVisitTestData();
		VerifyDeleteAllergyInEdit(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	
	/**
	 * verifyDeleteAllergyInEditEncounterAllergy
	 * Function to verify Delete Allergy In Edit EncounterAllergy
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @defect		#7654
	 * @throws      IOException 
	 * @since  	    Dec 20, 2013
	 */
	public boolean VerifyDeleteAllergyInEdit(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws   IOException{
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
			assertTrue(deleteAllEncounters(selenium,allergyData),"could not delete the encouner record", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Allergy//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnCancel),"Could not click the save button;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Coul not navigate to encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Delete existing Encounter Allergy//
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,lnkEncounterAllergy),"Could not find the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkEncounterAllergy,"");
			selenium.focus(lnkEncounterAllergy);
			selenium.fireEvent(lnkEncounterAllergy,"keypress");
			
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Create Encounter Allergy//
			//--------------------------------------------------------------------//
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate Allergy in summary page                          //
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,lblEncounterAllergyDetails),"Could not find the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.clickAt(lblEncounterAllergyDetails,"");
			
			assertTrue(click(selenium,btnEdit),"Could not click the edit button;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8: Verify edit Page Value                          //
			//--------------------------------------------------------------------//
			
			assertTrue(verifyAllergyEditPageValue(selenium,allergyData,userAccount),"Details are not displayed properly", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//  Step-9: Delete Allergy in Edid Allergy page                      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEncoudeleteAllerge),"Could not click the Delete button;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtdeleteReason,allergyData.allergen ),"Could not click the Delete button;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnDeleteReason),"Could not click the Delete button;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		//	assertTrue(click(selenium,btnBeginEncounter),"Could not click begin encounter", selenium, ClassName, MethodName);
		//	waitForPageLoad(selenium);			
			//--------------------------------------------------------------------//
			//  Step-10:Verify Delete Record in Encounter Note Page               //
			//--------------------------------------------------------------------//

			assertTrue((getText(selenium,lblEncounterAllergyDetails).toLowerCase(new java.util.Locale("en","Us")).trim().contains(allergyData.allergenCa.trim().toLowerCase(new java.util.Locale("en","Us"))))|| getText(selenium,lblEncounterAllergyDetails).toLowerCase(new java.util.Locale("en","Us")).trim().contains(allergyData.allergen.trim().toLowerCase(new java.util.Locale("en","Us"))),"Values not stored Properly",selenium, ClassName, MethodName);
			
			
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
	public boolean verifyAllergyEditPageValue(Selenium selenium,ChartPreVisitLib injectionData,String account) throws IOException{
		String date = null;
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			 date=DateFormat.format(cal.getTime());
			assertTrue(getValue(selenium,ajxSearchAllergy).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.allergenCa.trim().toLowerCase(new java.util.Locale("en","Us"))),"Value not matched in Allergen",selenium, ClassName,MethodName);

		}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
			assertTrue(getValue(selenium,ajxSearchAllergy).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.allergen.trim().toLowerCase(new java.util.Locale("en","Us"))),"Value not matched in Allergen",selenium, ClassName,MethodName);

		}
		assertTrue(click(selenium,lnkInjectionShowMore),"Could not click the Delete button;", selenium, ClassName, MethodName);
		

		/*if(!getValue(selenium,ajxAllergyReaction).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.reaction.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}*/
		
		//assertTrue((getValue(selenium,ajxSearchAllergy).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.allergenCa.trim().toLowerCase(new java.util.Locale("en","Us"))))&&getValue(selenium,ajxSearchAllergy).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.allergen.trim().toLowerCase(new java.util.Locale("en","Us"))),"Values not match with ajax list",selenium, ClassName,MethodName);
		assertTrue(getValue(selenium,ajxSeverity).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.severity.trim().toLowerCase(new java.util.Locale("en","Us"))),"Value not matched in severity",selenium, ClassName,MethodName);
		assertTrue(getValue(selenium,ajxStatus).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.status.trim().toLowerCase(new java.util.Locale("en","Us"))),"Value not matched in status",selenium, ClassName,MethodName);
		assertTrue(getValue(selenium,txtOnset).trim().contains(date.trim()),"Value not matched in txtOnset",selenium, ClassName,MethodName);
		assertTrue(getValue(selenium,ajxlifeStage).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.lifeStage.trim().toLowerCase(new java.util.Locale("en","Us"))),"Value not matched in lifeStage",selenium, ClassName,MethodName);
		assertTrue(getValue(selenium,txtcomment).trim().contains(injectionData.comment.trim()),"Value not matched in txtcomment",selenium, ClassName,MethodName);
		
		
		
		
		return true;
	}
}
