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

public class VerifyTreatmentTargetAndExceptions extends AbstractCdmFlowSheets {
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify Save action on Target Exceptions.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveTargetExceptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_037";
		mcTemplate.fetchClinicalSettingsTestData();
		verifyTreatmentTargetAndExceptions(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify Cancel action on Target Exceptions.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelTargetExceptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_038";
		mcTemplate.fetchClinicalSettingsTestData();
		verifyTreatmentTargetAndExceptions(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify Multiple Exceptions.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAddMultipleExceptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_039";
		mcTemplate.fetchClinicalSettingsTestData();
		verifyTreatmentTargetAndExceptions(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
		
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify the Overlap of Target Exceptions.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOverlapOfExceptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_040";
		mcTemplate.fetchClinicalSettingsTestData();
		verifyTreatmentTargetAndExceptions(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
		
	/*************************************************************************************************** 
	* @purpose        To verify Target Exceptions.
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verifying values of Target Exceptions
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Nov 04, 2014
	***************************************************************************************************/
	
	public boolean verifyTreatmentTargetAndExceptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException{
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
			
			if(mcTemplate.testCaseId.equals("TC_MCT_037")){
				assertTrue(verifySave(selenium,mcTemplate,userAccount),"Save failed", selenium, ClassName, MethodName);
			}
			else if(mcTemplate.testCaseId.equals("TC_MCT_038")){
				assertTrue(verifyCancel(selenium,mcTemplate,userAccount),"Save failed", selenium, ClassName, MethodName);
			}
			else if(mcTemplate.testCaseId.equals("TC_MCT_039")){
				assertTrue(verifyMultiple(selenium,mcTemplate,userAccount),"Save failed", selenium, ClassName, MethodName);
			}
			else{
				assertTrue(verifyOverlap(selenium,mcTemplate,userAccount),"Save failed", selenium, ClassName, MethodName);
			}
				
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
}
	
	public boolean verifySave(Selenium selenium,ClinicalSettingLib mcTemplate,String account) throws IOException{
		
		assertTrue(addTargetException(selenium,mcTemplate,account),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSaveCategoryName), "Could not click on Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(isTextPresent(selenium,mcTemplate.targetExceptionType),"could ot click cancel", selenium, ClassName, MethodName);
		assertTrue(isTextPresent(selenium,mcTemplate.eheightUpperLimit),"could ot click cancel", selenium, ClassName, MethodName);
		assertTrue(isTextPresent(selenium,mcTemplate.eheightLowerLimit),"could ot click cancel", selenium, ClassName, MethodName);
		assertTrue(isTextPresent(selenium,mcTemplate.forWho),"could ot click cancel", selenium, ClassName, MethodName);
		assertTrue(isTextPresent(selenium,mcTemplate.condtionType),"could ot click cancel", selenium, ClassName, MethodName);
		assertTrue(isTextPresent(selenium,mcTemplate.condtionAge),"could ot click cancel", selenium, ClassName, MethodName);
		assertTrue(isTextPresent(selenium,mcTemplate.conditionAgeIn),"could ot click cancel", selenium, ClassName, MethodName);
		
		return true;
	}
	
public boolean verifyCancel(Selenium selenium,ClinicalSettingLib mcTemplate,String account) throws IOException{
	
	assertTrue(addTargetException(selenium,mcTemplate,account),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(click(selenium, btnCancelCategoryName), "Could not click on Cancel button", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
		
		assertTrue(!isTextPresent(selenium,mcTemplate.targetExceptionType),"could ot click cancel", selenium, ClassName, MethodName);
		assertTrue(!isTextPresent(selenium,mcTemplate.eheightUpperLimit),"could ot click cancel", selenium, ClassName, MethodName);
		assertTrue(!isTextPresent(selenium,mcTemplate.eheightLowerLimit),"could ot click cancel", selenium, ClassName, MethodName);
		assertTrue(!isTextPresent(selenium,mcTemplate.forWho),"could ot click cancel", selenium, ClassName, MethodName);
		assertTrue(!isTextPresent(selenium,mcTemplate.condtionType),"could ot click cancel", selenium, ClassName, MethodName);
		assertTrue(!isTextPresent(selenium,mcTemplate.condtionAge),"could ot click cancel", selenium, ClassName, MethodName);
		assertTrue(!isTextPresent(selenium,mcTemplate.conditionAgeIn),"could ot click cancel", selenium, ClassName, MethodName);
		return true;
	}

public boolean verifyMultiple(Selenium selenium,ClinicalSettingLib mcTemplate,String account) throws IOException{
	assertTrue(addTargetException(selenium,mcTemplate,account),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(click(selenium, btnSaveCategoryName), "Could not click on Save button", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	
	mcTemplate.workSheetName = "ManagedCaredTemplate";
	mcTemplate.testCaseId = "TC_MCT_038";
	mcTemplate.fetchClinicalSettingsTestData();
	assertTrue(addTargetException(selenium,mcTemplate,account),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	
	assertTrue(click(selenium, btnSaveCategoryName), "Could not click on Save button", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	
	assertTrue(isTextPresent(selenium,mcTemplate.targetExceptionType),"could ot click cancel", selenium, ClassName, MethodName);
	assertTrue(isTextPresent(selenium,mcTemplate.eheightUpperLimit),"could ot click cancel", selenium, ClassName, MethodName);
	assertTrue(isTextPresent(selenium,mcTemplate.eheightLowerLimit),"could ot click cancel", selenium, ClassName, MethodName);
	assertTrue(isTextPresent(selenium,mcTemplate.forWho),"could ot click cancel", selenium, ClassName, MethodName);
	assertTrue(isTextPresent(selenium,mcTemplate.condtionType),"could ot click cancel", selenium, ClassName, MethodName);
	assertTrue(isTextPresent(selenium,mcTemplate.condtionAge),"could ot click cancel", selenium, ClassName, MethodName);
	assertTrue(isTextPresent(selenium,mcTemplate.conditionAgeIn),"could ot click cancel", selenium, ClassName, MethodName);
	
	return true;
}

public boolean verifyOverlap(Selenium selenium,ClinicalSettingLib mcTemplate,String account) throws IOException{
	
	assertTrue(addTargetException(selenium,mcTemplate,account),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(click(selenium, btnSaveCategoryName), "Could not click on Save button", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	
	assertTrue(!isTextPresent(selenium,"These values are already included in other exceptions. Please adjust the parameters."),"could ot click cancel", selenium, ClassName, MethodName);

	return true;
}
}
