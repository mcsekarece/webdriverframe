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
import com.thoughtworks.selenium.Selenium;

public class FlowSheetSectionView extends AbstractCdmFlowSheets{
	@Test(groups = {"Regression","Approved","SingleThread","firefox", "iexplore", "safari", "default" }, description = "Test to verify the view of the Flow Sheet Section..")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyViewOfFlowSheet(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_022";
		mcTemplate.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
		verifyView(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify the view in edit flowsheet pages for immunization and lab.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyViewImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_045";
		mcTemplate.fetchClinicalSettingsTestData();
		verifyViewImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify the view of the Flow Sheet Section.
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verifying the view of the Flow Sheet Section
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Nov 05, 2014
	***************************************************************************************************/
	
	public boolean verifyView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException{
		Selenium selenium=null;
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
			//  Step-4: Delete Existing Managed Care Template						          //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllManagedCareTemplate(selenium,mcTemplate),"Deletion Failed:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Managed Care Template						          //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=dateFormat.format(cal.getTime());
			assertTrue(enterDetailsForeManagedCareTemplate(selenium,mcTemplate,uniqueName),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(addImmunizationCareElement(selenium,mcTemplate,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveWhole),"could ot click save", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-7: Advanced search with Patient ID                           //
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,mcTemplate.patientId);
			waitForPageLoad(selenium);
			AbstractChartPreVisit obj=new AbstractChartPreVisit();
			assertTrue(obj.goToBeginEncounter(selenium),"Could not navigate to encounter", selenium, ClassName, MethodName);  
			assertTrue(click(selenium,lnkSummary),"Could not click the Summary tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-8: Add Immunization                                          //
			//--------------------------------------------------------------------//
			assertTrue(selenium.isVisible(lnkImmunization),"Immunization Link Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(obj.deleteImmunization(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-9: Create Immunization                                       //
			//--------------------------------------------------------------------//
			ChartPreVisitLib immunizationData = new ChartPreVisitLib();
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_070";
			immunizationData.fetchChartPreVisitTestData();
			
			assertTrue(obj.createImmunization(selenium,immunizationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Create Another Immunization  and save Encounter           //
			//--------------------------------------------------------------------//
			ChartPreVisitLib immunizationData1 = new ChartPreVisitLib();
			immunizationData1.workSheetName = "CreateImmunization";
			immunizationData1.testCaseId = "TC_CIM_071";
			immunizationData1.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(obj.createImmunization(selenium,immunizationData1,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			selenium.clickAt(obj.lnkBeginEncounterAction,"");
			selenium.focus(obj.lnkBeginEncounterAction);
			selenium.fireEvent(obj.lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, obj.lblEncounterSave),"could not click on encounter save",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-13: Navigate to Managed Care                                 //
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareFlowSheet(selenium,mcTemplate,userAccount ),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyView(selenium,mcTemplate,immunizationData,immunizationData1,userAccount),"Save failed", selenium, ClassName, MethodName);

		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
	
	public boolean verifyView(Selenium selenium,ClinicalSettingLib mcTemplate,ChartPreVisitLib immunizationData,ChartPreVisitLib immunizationData1,String account) throws IOException{
			int date1;
			String date2="";
			assertTrue(getText(selenium,lblBaseLine).toLowerCase(new java.util.Locale("en","Us")).trim().contains("Baseline".trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblCareElementName).toLowerCase(new java.util.Locale("en","Us")).trim().contains(mcTemplate.display.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

			
			if (account.equals(CAAccount)) {
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
				date=DateFormat.format(cal.getTime());
				date1=Integer.parseInt(date);
				if(date1<10){
					SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
					date=DateForma1t.format(cal.getTime());
				
				}else{
					SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");
					date=DateFormat2.format(cal.getTime());
					
				}
				assertTrue(getText(selenium,lblEncounterDate).toLowerCase(new java.util.Locale("en","Us")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);
				assertTrue(getText(selenium,lblCareElementValue).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData1.Vaccine1CA.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);
				assertTrue(click(selenium,lblCareElementValueollapse),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(getText(selenium,lblCareElementValue).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.Vaccine1CA.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

				assertTrue(getText(selenium,lblEncounterValue).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData1.Vaccine1CA.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);
				assertTrue(click(selenium,lblEncounterValueCollapse),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(getText(selenium,lblEncounterValue).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.Vaccine1CA.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);


			} else if(account.equals(USAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MMM dd, yyyy");
				date2 = DateFormat.format(cal.getTime());
				assertTrue(getText(selenium,lblEncounterDate).toLowerCase(new java.util.Locale("en","Us")).trim().contains(date2.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);
				assertTrue(getText(selenium,lblCareElementValue).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData1.vaccineUS.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);
				assertTrue(click(selenium,lblCareElementValue),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(getText(selenium,lblCareElementValue).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.vaccineUS.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

				assertTrue(getText(selenium,lblEncounterValue).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData1.Vaccine1CA.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);
				assertTrue(click(selenium,lblEncounterValueCollapse),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(getText(selenium,lblEncounterValue).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.Vaccine1CA.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

			}

			return true;
}
	
	/*************************************************************************************************** 
	* @purpose        To verify the view of the Flow Sheet Section.
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verifying the view of the Flow Sheet Section
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Nov 07, 2014
	***************************************************************************************************/
	
	public boolean verifyViewImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException{
		Selenium selenium=null;
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
			//  Step-4: Delete Existing Managed Care Template						          //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllManagedCareTemplate(selenium,mcTemplate),"Deletion Failed:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Managed Care Template						          //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=dateFormat.format(cal.getTime());
			assertTrue(enterDetailsForeManagedCareTemplate(selenium,mcTemplate,uniqueName),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Add Selecetd Immunization To Care Element					          //
			//--------------------------------------------------------------------//
			assertTrue(addImmunizationCareElement(selenium,mcTemplate,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent(mcTemplate.immunization),"Immunization text is not present", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-7: Add One more Selecetd Immunization To Care Element					          //
			//--------------------------------------------------------------------//
			ClinicalSettingLib mcTemplate1 = new ClinicalSettingLib();
			mcTemplate1.workSheetName = "ManagedCaredTemplate";
			mcTemplate1.testCaseId = "TC_MCT_046";
			mcTemplate1.fetchClinicalSettingsTestData();
			assertTrue(click(selenium, "link="+mcTemplate.immunization), "Could not click on select link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium, ajxSearchImmunization,mcTemplate1.immunization), "Could not type due", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
		if(!isChecked(selenium,chkImmunization1)){
			assertTrue(click(selenium, chkImmunization1), "Could not check Immunization", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		if(isElementPresent(selenium,lnkDelete)){
			assertTrue(click(selenium, lnkClose), "Could not click close", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}

			assertTrue(selenium.isTextPresent(mcTemplate.immunization+"..."),"Immunizations text is not present", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-8: Remove Selecetd Immunization 					          //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, "link="+mcTemplate.immunization+"..."), "Could not click on select link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkDelete), "Could not click on Delete", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isChecked(selenium, chkVaricella),"Care Element is present", selenium, ClassName, MethodName);

			assertTrue(click(selenium, lnkClose), "Could not click close", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(mcTemplate1.immunization),"Immunization text is not present", selenium, ClassName, MethodName);

		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}
