package com.projectname.test.functional.clinicalsettings.practiceLibrary;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.pages.AllergyPage;
import com.projectname.testutils.pages.ChartDisclosurePage;
import com.projectname.testutils.pages.ClinicalSettingPage;
import com.projectname.testutils.pages.EncounterPage;
import com.projectname.testutils.pages.HomePage;
import com.projectname.testutils.pages.LabOrderPage;
import com.projectname.testutils.pages.LoginPage;
import com.projectname.testutils.pages.PatientChartPage;
import com.projectname.testutils.pages.PatientRegistationPage;
import com.projectname.testutils.pages.PracticeLibrary;
import com.projectname.testutils.pages.PrescribeMedicationPage;
import com.projectname.testutils.pages.ProblemListPage;
import com.projectname.testutils.pages.SharedPage;
import com.projectname.testutils.retryAnalyser.RetryRule;
import java.text.SimpleDateFormat;
import java.util.Calendar;
@Listeners(com.projectname.testutils.baseclass.CustomizedReporter.class)
public class EncounterEndToEndOne  extends TestBaseClass{
	
	
	@Test(retryAnalyzer = RetryRule.class, groups = {"EncounterEndToEndOne" }, description = "Test to verify Custom defined components and sactions")
	@Parameters({"userAccount","webSite","browser","seleniumHost","seleniumPort"})
	
	public void verifyEncounterEndToEndOne(String userAccount,String webSite,String browser, String seleniumHost, String seleniumPort)
	{		
		className=this.getClass().getName().substring(39);	
		methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "CreateVisitSection";
		encounterTemplateTestData.testCaseId = "TC_VS_001";
		encounterTemplateTestData.fetchClinicalSettingsTestData();	
		encounterTemplate(userAccount, encounterTemplateTestData,seleniumHost);
	}
	
	/**
	 * verify Custom defined components and sactions
	 * function to verify Custom defined components and sactions
	 * @param encounterTemplateTestData 
	 * @param 		patientData
	 * @param 		browser
	 * @param 		webSite
	 * @throws      Exception 
	 * @since  	    Dec 26, 2014
	 */
	
	public boolean encounterTemplate( String userAccount, ClinicalSettingLib encounterTemplateTestData,String seleniumHost)  {
		boolean returnValue=true;
		 HomePage homePage=null;
		 SharedPage sharedPage=null;
		 ClinicalSettingPage clinicalSettingPage=null;
		 PracticeLibrary practiceLibrary=null;
		 this.videorecording=true;
				try{
					
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			logTitleMessage("Login to application");
			LoginPage loginPage=new LoginPage();
			logTitleMessage("Login Successful");
			//Start Video recording 
			startVideoRecording(driver, seleniumHost,"Issue in starting the Video Recording");
			homePage = loginPage.loginForNexiaFromProviderSite(driver,userAccount, encounterTemplateTestData.userName, encounterTemplateTestData.userPassword);

			//--------------------------------------------------------------------//
			//  Step-2: Change the switch role 									  //
			//--------------------------------------------------------------------//			
			logTitleMessage("Switch practice to Encounter Template ");
			sharedPage=homePage.navigateToSharedPage();
			sharedPage.selectPractice(driver,"Encounter");
			sharedPage.switchRole(driver, encounterTemplateTestData.switchRole);
			sharedPage.getProviderName(driver, encounterTemplateTestData);
			logTitleMessage("Switch practice to Encounter Template  succeccful");
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter Template 							  //
			//--------------------------------------------------------------------//
			logTitleMessage("Navigate to practice libraray page and create visit section");
			clinicalSettingPage = sharedPage.navigateToClinicalSettings1(driver);
			practiceLibrary=clinicalSettingPage.navigateToEncounterTemplate(driver);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create a Custom section with widget 					  //
			//--------------------------------------------------------------------//
			clinicalSettingPage.navigateToVisitsection(driver, practiceLibrary);
			clinicalSettingPage.deleteAllCustomSection(driver, practiceLibrary);		
			clinicalSettingPage.createVisitSectionWithWidget(driver, encounterTemplateTestData, practiceLibrary);
			logTitleMessage("Successfully created visit section ");
			//--------------------------------------------------------------------//
			//  Step-5: Add Created section with Default visit outline			  //
			//--------------------------------------------------------------------//
			logTitleMessage("Add visit section with default visit outline");
			clinicalSettingPage.navigateToVisitoutline(driver, practiceLibrary);
			clinicalSettingPage.selectDefaultTemplate(driver, practiceLibrary);
			clinicalSettingPage.clickOnEncoEdit(driver, practiceLibrary);
			clinicalSettingPage.deleteCustomComponenetInEditDefalutPage(driver, practiceLibrary);
			clinicalSettingPage.addVisitSectionWithVisitOutline(driver, encounterTemplateTestData, practiceLibrary);
			logTitleMessage("Successfully Added visit section with default visit outline");	
			//Stop Video Recording 
			stopVideoRecording(driver, className, methodName,"Issue Saving/Stopping Video Recording");
		}catch(RuntimeException e ){
	e.printStackTrace();
	assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnValue;

	}

	}
