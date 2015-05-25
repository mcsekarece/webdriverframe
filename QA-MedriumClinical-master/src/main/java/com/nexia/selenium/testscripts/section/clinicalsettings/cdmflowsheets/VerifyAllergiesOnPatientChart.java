package com.nexia.selenium.testscripts.section.clinicalsettings.cdmflowsheets;

import java.io.IOException;
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


public class VerifyAllergiesOnPatientChart extends AbstractCdmFlowSheets {
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify manged care template on the patient Chart")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addManagedCareTemplateForAllergiesWithAll(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception
	{
		ClinicalSettingLib templateData = new ClinicalSettingLib();
		templateData.workSheetName = "ManagedCaredTemplate";
		templateData.testCaseId = "TC_MCT_004";
		templateData.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyManagedCareTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, templateData);
	}
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify managed care template on the patient chart")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addManagedCareTemplateForAllergiesWithSelectedAll(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception
	{
		ClinicalSettingLib templateData = new ClinicalSettingLib();
		templateData.workSheetName = "ManagedCaredTemplate";
		templateData.testCaseId = "TC_MCT_011";
		templateData.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyManagedCareTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, templateData);
	}
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify managed care template on the patient chart")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addManagedCareTemplateForAllergiesWithSelectedDrugType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception
	{
		ClinicalSettingLib templateData = new ClinicalSettingLib();
		templateData.workSheetName = "ManagedCaredTemplate";
		templateData.testCaseId = "TC_MCT_014";
		templateData.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyManagedCareTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, templateData);
	}
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify managed care template on the patient chart")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addManagedCareTemplateForAllergiesWithSelecteNonDrugType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception
	{
		ClinicalSettingLib templateData = new ClinicalSettingLib();
		templateData.workSheetName = "ManagedCaredTemplate";
		templateData.testCaseId = "TC_MCT_017";
		templateData.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyManagedCareTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, templateData);
	}
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Allergies View")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAllergiesView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception
	{
		ClinicalSettingLib templateData = new ClinicalSettingLib();
		templateData.workSheetName = "ManagedCaredTemplate";
		templateData.testCaseId = "TC_MCT_045";
		templateData.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyManagedCareTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, templateData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To check the template Applied or not
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0                 
	* @action 		  Verifying add action for manage care template    
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 15, 2014
	***************************************************************************************************/
	
	public boolean verifyManagedCareTemplate(String seleniumHost,int seleniumPort,String browser,String webSite,String userAccount,ClinicalSettingLib templateData)throws Exception
	{
		Selenium selenium=null;
		boolean returnValue=true;
		
		try
		{
			//--------------------------------------------------------------------//
			//  Step-1 Login to the application                                   //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + templateData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, templateData.userName, templateData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2 Change the switch role 									  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,templateData.switchRole),"Could not change the switch role;More Details:"+templateData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3 Navigate to Managed Care Template						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareTemplate(selenium),"Could not navigate to managed care teamplates;More Details:"+templateData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4 Delete Existing Managed Care Template					  //
			//--------------------------------------------------------------------//
		    assertTrue(deleteAllManagedCareTemplate(selenium,templateData),"Deletion Failed:"+templateData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5 Add Managed Care Template						          //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=dateFormat.format(cal.getTime());
			assertTrue(createManagedCareTemplateWithMandatory(selenium,templateData,uniqueName),"Creation Failed"+templateData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//---------------------------------------------------------------------//
			//  Step-6 Managed care template with All Item
			//---------------------------------------------------------------------//
			assertTrue(editManagedCareTemplate(selenium),"Unable to Edit the Managed Care template",selenium,ClassName, MethodName);
			if(templateData.testCaseId.equals("TC_MCT_004"))
			{
				
				assertTrue(click(selenium,btnSaveWhole),"Unable to click the save Button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//----------------------------------------------------------------------//
			// Step-7 Managed care template Selected Item with All
			//----------------------------------------------------------------------//
			
			if(templateData.testCaseId.equals("TC_MCT_011")||templateData.testCaseId.equals("TC_MCT_045"))
			{
				assertTrue(selectParticularAllergiesInManagedCare(selenium,templateData),"Unable to select particular Allergy in Managed Care template",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			//----------------------------------------------------------------------//
			// Step-8 Managed Care template selected Item with Drug Type
			//----------------------------------------------------------------------//
			if(templateData.testCaseId.equals("TC_MCT_014"))
			{
				assertTrue(selectParticularAllergiesInManagedCare(selenium,templateData),"Unable to select particular Allergy in Managed Care template",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			//----------------------------------------------------------------------//
			// Step-9 Managed Care template Selected Item with Non Drug Type
			//----------------------------------------------------------------------//
			if(templateData.testCaseId.equals("TC_MCT_017"))
			{
				assertTrue(selectParticularAllergiesInManagedCare(selenium,templateData),"Unable to select particular Allergy in Managed Care template",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-10 Verify Created Managed Care Template			          //
			//--------------------------------------------------------------------//
			assertTrue(verifyCreatedManagedCareTemplate(selenium,templateData,uniqueName),"Details are incorrect"+templateData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkHome),"Unable to Navigate to HomePage",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-11 Create a patient with Mandatory fields                    //                                              
			//--------------------------------------------------------------------//
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "CreatePatientForMedication";
			patientData.testCaseId = "TC_CPM_001";
			patientData.fetchHomeTestData();
			assertTrue(createNewPatientWithMandatoryFields(selenium,patientData),"Unable to Create a New Patient with Mandatory Fields",selenium, ClassName, MethodName);
			//------------------------------------------------------------------------------------// 
			// Step-12 Enter into the patient chart and Associate Managed Care with the Patient   //                                                                    
			//------------------------------------------------------------------------------------//
			assertTrue(NavigateToPatientToPatientChart(selenium),"Unable to navigate to patient chart",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//------------------------------------------------------------------------------//
			//  Step-13 Navigate to Managed care template                                   //
			//------------------------------------------------------------------------------//
			assertTrue(navigateToManagedCare(selenium,templateData,userAccount,uniqueName),"Unable to navigate to the managed care template",selenium,ClassName,MethodName);
			assertTrue(click(selenium,lnkAllergy),"Unable enter into allergy",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//-----------------------------------------------------------------------------//
			//  Step-14 Create an allergy
			//-----------------------------------------------------------------------------//
			AbstractChartPreVisit allergy=new AbstractChartPreVisit();
			ChartPreVisitLib allergyData= new ChartPreVisitLib();
			allergyData.workSheetName = "CreateAllergy";
			allergyData.testCaseId = "TC_CA_003";
			allergyData.fetchChartPreVisitTestData();
			assertTrue(allergy.createAllergyQuickList(selenium,allergyData,userAccount),"Allergy Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveAllergy),"Unable to save the allergy",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//------------------------------------------------------------------------------//
			// Step-15 Verify Managed Care Template with All Item                           //
			//------------------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAllergyTempEdit),"Unable to enter into the allergy template",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(templateData.testCaseId.equals("TC_MCT_004"))
			{
			assertTrue(getText(selenium,lnkForCheckAllergy).toLowerCase().contains("Allergy".toLowerCase()),"Allergy not added in the template",selenium, ClassName, MethodName);
			}
			//------------------------------------------------------------------------------//
			//  Step-16 Verify Managed Care Template with Selected Item 
			//------------------------------------------------------------------------------//
			if(templateData.testCaseId.equals("TC_MCT_011")||templateData.testCaseId.equals("TC_MCT_014")||templateData.testCaseId.equals("TC_MCT_017")||templateData.testCaseId.equals("TC_MCT_045"))
			{
            assertTrue(!getText(selenium,lnkForCheckAllergy).contains("allergy"),"Allergy displayed",selenium, ClassName, MethodName);
            waitForPageLoad(selenium);
            assertTrue(click(selenium,lnkCloseTemplate),"Unable to click the close button",selenium,ClassName, MethodName);
            waitForPageLoad(selenium);
            //-------------------------------------------------------------------------------//
            //  Step-17 Create an Intolerance
            //-------------------------------------------------------------------------------//
            ChartPreVisitLib intoleranceData = new ChartPreVisitLib();
            if(templateData.testCaseId.equals("TC_MCT_004")||templateData.testCaseId.equals("TC_MCT_011")||templateData.testCaseId.equals("TC_MCT_014"))
            {
                intoleranceData.workSheetName = "CreateAllergy";
                intoleranceData.testCaseId = "TC_CA_004";
            }
            if(templateData.testCaseId.equals("TC_MCT_017"))
            {
            	intoleranceData.workSheetName = "CreateAllergy";
                intoleranceData.testCaseId = "TC_CA_004";
            }
            if(templateData.testCaseId.equals("TC_MCT_045"))
            {
            	intoleranceData.workSheetName = "CreateAllergy";
                intoleranceData.testCaseId = "TC_CA_046";
            }
            	
            intoleranceData.fetchChartPreVisitTestData();
            assertTrue(click(selenium,lnkAllergy),"Unable enter into allergy",selenium, ClassName, MethodName);
            waitForPageLoad(selenium);
            assertTrue(allergy.editAllergy(selenium, intoleranceData, userAccount),"Intolerance Creation failed",selenium, ClassName, MethodName);
            waitForPageLoad(selenium);
            assertTrue(click(selenium, btnSaveAllergy),"Could not click the save button;More details:"+ allergyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//---------------------------------------------------------------------------------//
			//  Step-18 Verify on patient chart severity 
			//---------------------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAllergyTempEdit),"Unable to enter into the allergy template",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
            assertTrue(getText(selenium,lnkForCheckAllergy).toLowerCase().contains("Intolerance".toLowerCase()),"Intolerance not added in the template",selenium, ClassName, MethodName);
			
            //---------------------------------------------------------------------------------//
			//  Step-18 Verify Allergies View on patient chart  
			//---------------------------------------------------------------------------------//
            if(templateData.testCaseId.equals("TC_MCT_045")){

            assertTrue(getText(selenium,lnkForCheckAllergy).contains(intoleranceData.status),"Status not added in the template",selenium, ClassName, MethodName);
            assertTrue(getText(selenium,lnkForCheckAllergy.toLowerCase()).contains(intoleranceData.severity.toLowerCase()),"Severity not added in the template",selenium, ClassName, MethodName);
			if (userAccount.equals(CAAccount)) {
            assertTrue(getText(selenium,lnkForCheckAllergy.toLowerCase()).contains(intoleranceData.allergenCa.toLowerCase()),"Allergen not added in the template",selenium, ClassName, MethodName);
			}
			else
			{
	            assertTrue(getText(selenium,lnkForCheckAllergy.toLowerCase()).contains(intoleranceData.allergen.toLowerCase()),"Allergen not added in the template",selenium, ClassName, MethodName);
			}
            assertTrue(click(selenium,linkAllergyExpandAnchor),"Unable to save the allergy",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
            assertTrue(getText(selenium,lnkForCheckAllergy).contains(intoleranceData.lifeStage),"Life Stage not added in the template",selenium, ClassName, MethodName);

            assertTrue(click(selenium,lnkAllergy),"Unable to save the allergy",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
            if(getText(selenium,lblAllergy1).contains("Allergy"))
            {
                assertTrue(!isChecked(selenium,chkAllergy1),"Unable to save the allergy",selenium, ClassName, MethodName);
            }
            if(getText(selenium,lblAllergy2).contains("Intolerance"))
            {
                assertTrue(isChecked(selenium,chkAllergy2),"Unable to save the allergy",selenium, ClassName, MethodName);
            }
            }
			}
		}catch(RuntimeException e)
		{
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}