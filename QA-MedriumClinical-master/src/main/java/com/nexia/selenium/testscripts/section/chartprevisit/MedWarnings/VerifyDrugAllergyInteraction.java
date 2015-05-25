package com.nexia.selenium.testscripts.section.chartprevisit.MedWarnings;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDrugAllergyInteraction extends AbstractChartPreVisit{
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Drug Allergy Interaction")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDrugAllergyInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "MedWarnings";
		prescribeData.testCaseId = "TC_PMW_013";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		drugAllergyInteraction(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Mild Allergy Interaction")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMildAllergyInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "MedWarnings";
		prescribeData.testCaseId = "TC_PMW_008";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		drugAllergyInteraction(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Mmoderate Allergy Interaction")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMmoderateAllergyInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "MedWarnings";
		prescribeData.testCaseId = "TC_PMW_009";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		drugAllergyInteraction(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify High Allergy Interaction")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHighAllergyInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "MedWarnings";
		prescribeData.testCaseId = "TC_PMW_010";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		drugAllergyInteraction(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Severe Allergy Interaction")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySevereAllergyInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "MedWarnings";
		prescribeData.testCaseId = "TC_PMW_011";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		drugAllergyInteraction(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	/**
	 * drugAllergyInteraction
	 * function to verify drug Allergy interaction
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 13, 2012
	 */
	
	public boolean drugAllergyInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Create a new patient and get Patient Id					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			ChartPreVisitLib vitalsData = new ChartPreVisitLib();
			vitalsData.workSheetName = "NewPatientCheckIn";
			vitalsData.testCaseId = "TC_NP_001";
			vitalsData.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,vitalsData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String patId = getText(selenium, "patientID");
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back link", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with created Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lblEncounterSave),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete All existing Allergy//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllAllergy(selenium,prescribeData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Add Allergy//
			//--------------------------------------------------------------------//
			assertTrue(createAllergyForMedWarnings(selenium,prescribeData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkAllergyEdit),"Edit allergy is not present", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//Allergy warning is displayed in search medication page
			assertTrue(isElementPresent(selenium, labPrescribeAllergen),"", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-6: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,ajxProvider,prescribeData.provider);
			selectValueFromAjaxList(selenium,ajxLoaction,prescribeData.loaction);
			if(userAccount.equals(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,prescribeData.allergenCa),"Could not type Prescribe Medication;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}else{
				assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,prescribeData.allergen),"Could not type Prescribe Medication;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,lnkEdit),"Could not click the Prescribe link;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			
			// Check for Override condition
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			waitForPageLoad(selenium);
			
			//Verify drug allergy interaction
			assertTrue(isElementPresent(selenium, imgAllergyInteraction), "Drug Allergy interaction is not displayed", selenium, ClassName, MethodName);
			returnValue = true;
			
			if(prescribeData.testCaseId.equals("TC_PMW_008")){
				System.out.println(getText(selenium, lblAllergyIntWarning));
				assertTrue(getText(selenium, lblAllergyIntWarning).equalsIgnoreCase("Mild"),"", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium, lblWarningAllergen),"", selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnCancel), "Could not click cancel button", selenium, ClassName, MethodName);
				returnValue = true;
			}
			else if(prescribeData.testCaseId.equals("TC_PMW_009")){
				System.out.println(getText(selenium, lblAllergyIntWarning));
				assertTrue(getText(selenium, lblAllergyIntWarning).equalsIgnoreCase("Moderate"),"", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium, lblWarningAllergen),"", selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnCancel), "Could not click cancel button", selenium, ClassName, MethodName);
				returnValue = true;
			}
			else if(prescribeData.testCaseId.equals("TC_PMW_010")){
				System.out.println(getText(selenium, lblAllergyIntWarning));
				assertTrue(getText(selenium, lblAllergyIntWarning).equalsIgnoreCase("High"),"", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium, lblWarningAllergen),"", selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnCancel), "Could not click cancel button", selenium, ClassName, MethodName);
				returnValue = true;
			}
			else if(prescribeData.testCaseId.equals("TC_PMW_011")){
				System.out.println(getText(selenium, lblAllergyIntWarning));
				assertTrue(getText(selenium, lblAllergyIntWarning).equalsIgnoreCase("Severe"),"", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium, lblWarningAllergen),"", selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnCancel), "Could not click cancel button", selenium, ClassName, MethodName);
				returnValue = true;
			}
			assertTrue(verifyStoredValues(selenium,prescribeData,userAccount),"Warning details are not displayed", selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib prescribeDate,String account) throws IOException{
		if(account.equals(CAAccount)){
			assertTrue(getText(selenium,lblWarningAllergen).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeDate.allergenCa.trim().toLowerCase(new java.util.Locale("en","US"))),"Verificatin failed", selenium, ClassName, MethodName);
		}else{
			assertTrue(getText(selenium,lblWarningAllergen).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeDate.allergen.trim().toLowerCase(new java.util.Locale("en","US"))),"Verificatin failed", selenium, ClassName, MethodName);
		}
		/*if(!getText(selenium,lblWarningSeverity).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeDate.severity.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		assertTrue(selenium.isTextPresent(prescribeDate.severity),"severity text is not present", selenium, ClassName, MethodName);
		return true;
	}
}
