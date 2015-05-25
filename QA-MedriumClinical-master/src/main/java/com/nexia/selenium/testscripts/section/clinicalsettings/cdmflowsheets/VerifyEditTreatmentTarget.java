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

public class VerifyEditTreatmentTarget extends AbstractCdmFlowSheets{
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify care element added in patient chart is not present in managed care template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditCareElementInPatientChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_045";
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
	
	public boolean verifyEditCareElementInPatientChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException{
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
			assertTrue(addVitalsCareElement(selenium,mcTemplate,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveWhole),"could ot click save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-6: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,mcTemplate.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Managed Care//
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareFlowSheet(selenium,mcTemplate,userAccount ),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkFlowSheet),"Could not click the Flow sheet;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			mcTemplate.workSheetName = "ManagedCaredTemplate";
			mcTemplate.testCaseId = "TC_MCT_030";
			mcTemplate.fetchClinicalSettingsTestData();
			assertTrue(addVitalsCareElementInPatientChart(selenium,mcTemplate,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(isTextPresent(selenium,mcTemplate.display),"Care Element is not present", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Baseline"),"Care Element is not present", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Target"),"Care Element is not present", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Due every"),"Care Element is not present", selenium, ClassName, MethodName);

			assertTrue(click(selenium, btnEdit1), "Could not click on Add button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyCareElementEditValue(selenium,mcTemplate,userAccount),"Edit failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
	
	public boolean verifyCareElementEditValue(Selenium selenium,ClinicalSettingLib proData,String account) throws IOException{
		
		assertTrue(getValue(selenium,txtDisplayAs).toLowerCase(new java.util.Locale("en","Us")).trim().contains(proData.display.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,ajxCarepanel).toLowerCase(new java.util.Locale("en","Us")).trim().contains(proData.measurement.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,ajxtargetType).toLowerCase(new java.util.Locale("en","Us")).trim().contains(proData.targetType.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,txtHeightUpperLimt).toLowerCase(new java.util.Locale("en","Us")).trim().contains(proData.heightUpperLimit.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

		return true;
	}
}	
