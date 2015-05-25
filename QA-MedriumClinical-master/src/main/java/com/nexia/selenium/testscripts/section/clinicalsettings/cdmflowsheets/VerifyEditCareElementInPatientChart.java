package com.nexia.selenium.testscripts.section.clinicalsettings.cdmflowsheets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractCdmFlowSheets;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditCareElementInPatientChart extends AbstractCdmFlowSheets{
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify care element added in patient chart is not present in managed care template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditCareElementInPatientChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_022";
		mcTemplate.fetchClinicalSettingsTestData();
		verifyEditCareElementInPatientChart(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify the values of care element after editing in patient chart.
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verifying values of care element after editing in patient chart
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 16, 2014
	***************************************************************************************************/
	
	public boolean verifyEditCareElementInPatientChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws Exception{
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
			
			assertTrue(navigateToVisitSection(selenium),"Unable to navigate to visit section",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			ClinicalSettingLib vsTemplate = new ClinicalSettingLib();
			vsTemplate.workSheetName = "CreateVisitSection";
			vsTemplate.testCaseId = "TC_VS_001";
			vsTemplate.fetchClinicalSettingsTestData();
			assertTrue(deleteAllCustomSection(selenium),"unable to delete widget",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(createVisitSectionWithSingleTextWidget(selenium,vsTemplate),"unable to create a single visit section",selenium,ClassName,MethodName);
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
			assertTrue(addCustomWidgetCareElement(selenium,mcTemplate,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
									
			assertTrue(click(selenium,btnSaveWhole),"could ot click save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			ClinicalSettingLib mcTemplate1 = new ClinicalSettingLib();
			mcTemplate1.workSheetName = "ManagedCaredTemplate";
			mcTemplate1.testCaseId = "TC_MCT_024";
			mcTemplate1.fetchClinicalSettingsTestData();
			//--------------------------------------------------------------------//
			//  Step-6: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,mcTemplate1.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Managed Care//
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareFlowSheet(selenium,mcTemplate,userAccount),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkFlowSheet),"Could not click the Flow sheet;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-8: add Custom Widget Care Element in patient chart
			//--------------------------------------------------------------------//
			assertTrue(addCustomWidgetCareElementInPatientChart(selenium,mcTemplate1,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSaveWhole),"Could not click Save;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify Edited Care Element In Patient Chart					  //
			//--------------------------------------------------------------------//
						
			assertTrue(isTextPresent(selenium,mcTemplate1.display),"Care Element is present", selenium, ClassName, MethodName);

			assertTrue(click(selenium,lnkFlowSheet),"Could not click the Flow sheet;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium, btnEdit1), "Could not click on Add button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyCareElementEditValue(selenium,mcTemplate1,userAccount),"Edit failed", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium, btnSaveCare), "Could not click on save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Verify Remove Option In Edit Flow Sheet					  //
			//--------------------------------------------------------------------//
			assertTrue(verifyRemoveCareElementInPatientChart(selenium,mcTemplate1,userAccount),"Verify failed", selenium, ClassName, MethodName);

			
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
	public boolean verifyCareElementEditValue(Selenium selenium,ClinicalSettingLib proData,String account) throws IOException{
		
		assertTrue(getValue(selenium,ajxCategory).toLowerCase(new java.util.Locale("en","Us")).trim().contains(proData.category.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

		assertTrue(getValue(selenium,txtUpcoming).toLowerCase(new java.util.Locale("en","Us")).trim().contains(proData.due.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

		assertTrue(getValue(selenium,txtDue).toLowerCase(new java.util.Locale("en","Us")).trim().contains(proData.due.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

		assertTrue(getValue(selenium,txtDisplayAs).toLowerCase(new java.util.Locale("en","Us")).trim().contains(proData.display.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

		assertTrue(getValue(selenium,ajxDueType).toLowerCase(new java.util.Locale("en","Us")).trim().contains(proData.dueType.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

		assertTrue(getValue(selenium,ajxAdvanceDue).toLowerCase(new java.util.Locale("en","Us")).trim().contains(proData.dueType.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

		return true;
	}
}
