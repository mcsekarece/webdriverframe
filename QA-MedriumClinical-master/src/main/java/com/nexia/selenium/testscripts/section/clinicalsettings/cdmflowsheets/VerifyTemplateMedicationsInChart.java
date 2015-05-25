package com.nexia.selenium.testscripts.section.clinicalsettings.cdmflowsheets;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractCdmFlowSheets;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTemplateMedicationsInChart extends AbstractCdmFlowSheets {
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Template medications in chart")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAllMedicationsInChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_031";
		mcTemplate.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAllMedications(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Template Specified medications in chart")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySpcifiedMedicationsInChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_031";
		mcTemplate.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySpecifiedMedications(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Template Specified medications in chart")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationsView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_047";
		mcTemplate.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySpecifiedMedications(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	/*************************************************************************************************** 
	* @purpose        Create Template medications and verify in Patient chart
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verifying Template medications in Patient chart
	* @author         AspireQA
	 * @throws Exception 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Jun 25, 2014
	***************************************************************************************************/
	
	public boolean verifyAllMedications(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws Exception{
		Selenium selenium=null;
		boolean returnValue= true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mcTemplate.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, mcTemplate.userName, mcTemplate.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Change the switch role 									  //
			//--------------------------------------------------------------------//
//			assertTrue(switchRole(selenium,mcTemplate.switchRole),"Could not change the switch role;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Managed Care Template						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareTemplate(selenium),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Add Managed Care Template						          //
			//--------------------------------------------------------------------//
			cal=Calendar.getInstance();
			dateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			uniqueName=dateFormat.format(cal.getTime());
			assertTrue(enterDetailsForeManagedCareTemplate(selenium,mcTemplate,uniqueName),"Template creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify All medication is selected
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, TemplateMedEdit), "Could not click on Template Medication edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSave), "Could not click on save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Create Patient with mandatory datum					      //
			//--------------------------------------------------------------------//
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_002";
			patientData.fetchHomeTestData();
			assertTrue(createNewPatientWithMandatoryFields(selenium,patientData),"Mandatory patient cration failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String patId = getText(selenium, "patientID");
			if(userAccount.equals(CAAccount)){
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			}
			else{
				USsearchPatientGotoChart(selenium,patId);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-7: Create Medication								          //
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareFlowSheetWithUniqueName(selenium,mcTemplate,userAccount,uniqueName),"search failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,ChartCareMed), "Could not click on add Medication Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			AbstractChartPreVisit absChart=new AbstractChartPreVisit();
			ChartPreVisitLib medicationData = new ChartPreVisitLib();
			medicationData.workSheetName = "CreateMedication";
			medicationData.testCaseId = "TC_PSM_051";
			medicationData.fetchChartPreVisitTestData();
			assertTrue(absChart.createMedication(selenium,medicationData,userAccount),"Medication creation failed", selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnSaveMedication),"Could not click the Save all medication button;More Details:"+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify created medication is added on Template            //
			//--------------------------------------------------------------------//
			assertTrue(verifyCreatedMedicationAddedonTemplate(selenium,medicationData,userAccount),"Medication is not added to template", selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}	
	return returnValue;
	}
	
	/*************************************************************************************************** 
	* @purpose        Create Template Specified medications and verify in Patient chart
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verifying Template specified medications in Patient chart
	* @author         AspireQA
	 * @throws Exception 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Jun 25, 2014
	***************************************************************************************************/

public boolean verifySpecifiedMedications(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws Exception{
	Selenium selenium=null;
	boolean returnValue= true;
	try{
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mcTemplate.toString());
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, mcTemplate.userName, mcTemplate.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-2: Change the switch role 									  //
		//--------------------------------------------------------------------//
		assertTrue(switchRole(selenium,mcTemplate.switchRole),"Could not change the switch role;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-3: Navigate to Managed Care Template						  //
		//--------------------------------------------------------------------//
		assertTrue(navigateToManagedCareTemplate(selenium),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-4: Add Managed Care Template						          //
		//--------------------------------------------------------------------//
		cal=Calendar.getInstance();
		dateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
		uniqueName=dateFormat.format(cal.getTime());
		assertTrue(enterDetailsForeManagedCareTemplate(selenium,mcTemplate,uniqueName),"Template creation failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-5: Create Spcified Medication template				          //
		//--------------------------------------------------------------------//
		assertTrue(createSpecifiedMedication(selenium,mcTemplate,userAccount),"Specified medication creation failed", selenium, ClassName, MethodName);

		//--------------------------------------------------------------------//
		//  Step-6: Create Patient with mandatory datum				          //
		//--------------------------------------------------------------------//
		System.out.println(userAccount);
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "NewPatientCheckIn";
		patientData.testCaseId = "TC_NPC_002";
		patientData.fetchHomeTestData();
		assertTrue(createNewPatientWithMandatoryFields(selenium,patientData),"Mandatory patient cration failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		String patId = getText(selenium, "patientID");
		if(userAccount.equals(CAAccount)){
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			}
			else{
				USsearchPatientGotoChart(selenium,patId);
				waitForPageLoad(selenium);
			}
		System.out.println(userAccount);
		
		//--------------------------------------------------------------------//
		//  Step-7: Create Medication								          //
		//--------------------------------------------------------------------//
		assertTrue(navigateToManagedCareFlowSheetWithUniqueName(selenium,mcTemplate,userAccount,uniqueName),"search failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,ChartCareMed), "Could not click on Medication Link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		System.out.println(userAccount);
		AbstractChartPreVisit absChart=new AbstractChartPreVisit();
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_051";
		medicationData.fetchChartPreVisitTestData();
		assertTrue(absChart.createMedication(selenium,medicationData,userAccount),"Medication cration failed", selenium, ClassName, MethodName);
		assertTrue(click(selenium, btnSaveMedication),"Could not click the all Medication save button;More Details:"+ medicationData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-8: Verify Specified medication is added on Template          //
		//--------------------------------------------------------------------//
		assertTrue(verifyCreatedMedicationAddedonTemplate(selenium,medicationData,userAccount),"Specified Medication is not added to template", selenium, ClassName, MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-9: Verify Medication View on Template          			  //
		//--------------------------------------------------------------------//
        if(mcTemplate.testCaseId.equals("TC_MCT_047")){
		assertTrue(getText(selenium,ChartTempMed).contains(medicationData.comment),"Specified Medication Comment is not added to template", selenium, ClassName, MethodName);
		assertTrue(click(selenium, lnkMedicationExpandAnchor),"Could not click the Expand Anchor;More Details:"+ medicationData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,ChartTempMed).contains(medicationData.refillQuantity),"Specified Medication Comment is not added to template", selenium, ClassName, MethodName);
		assertTrue(click(selenium, lnkMedicationTitle),"Could not click the Medication Title;More Details:"+ medicationData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(getText(selenium,lblAllergy1).contains(mcTemplate.medicationName1)){
            assertTrue(isChecked(selenium,chkAllergy1),"Unable to save the allergy",selenium, ClassName, MethodName); }
        }
		
	}catch(RuntimeException e){
	e.printStackTrace();
	assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}	
return returnValue;
}
}
