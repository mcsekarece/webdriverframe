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

public class VerifyPatientChartCareElementNotPresentInManageCareTemplate extends AbstractCdmFlowSheets{
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify care element added in patient chart is not present in managed care template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientChartCareElementNotPresentInManageCareTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_022";
		mcTemplate.fetchClinicalSettingsTestData();
		verifyPatientChartCareElementNotPresentInManageCareTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify care element added in patient chart is not visible in managed care template.
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verifying care element added in patient chart is not visible in managed care template
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 16, 2014
	***************************************************************************************************/
	
	public boolean verifyPatientChartCareElementNotPresentInManageCareTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException{
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
			assertTrue(addCustomWidgetCareElement(selenium,mcTemplate,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
									
			assertTrue(click(selenium,btnSaveWhole),"could ot click save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			ClinicalSettingLib mcTemplate1 = new ClinicalSettingLib();
			mcTemplate1.workSheetName = "ManagedCaredTemplate";
			mcTemplate1.testCaseId = "TC_MCT_023";
			mcTemplate1.fetchClinicalSettingsTestData();
			//--------------------------------------------------------------------//
			//  Step-6: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,mcTemplate1.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Managed Care//
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareFlowSheet(selenium,mcTemplate,userAccount ),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
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
			//  Step-9: Navigate to Managed Care Template						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareTemplate(selenium),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!isTextPresent(selenium,mcTemplate1.display),"Care Element is present", selenium, ClassName, MethodName);

			
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}
