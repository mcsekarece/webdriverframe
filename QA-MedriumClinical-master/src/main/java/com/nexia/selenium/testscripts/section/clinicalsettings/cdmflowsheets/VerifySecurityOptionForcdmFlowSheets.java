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

public class VerifySecurityOptionForcdmFlowSheets extends AbstractCdmFlowSheets {
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "VerifySecurityOption";
		mcTemplate.testCaseId = "TC_VSP_007";
		mcTemplate.fetchClinicalSettingsTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib timeLineData = new ClinicalSettingLib();
		timeLineData.workSheetName = "VerifySecurityOption";
		timeLineData.testCaseId = "TC_VSP_008";
		timeLineData.fetchClinicalSettingsTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, timeLineData);
	}

	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib timeLineData = new ClinicalSettingLib();
		timeLineData.workSheetName = "VerifySecurityOption";
		timeLineData.testCaseId = "TC_VSP_009";
		timeLineData.fetchClinicalSettingsTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, timeLineData);
	}

	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib timeLineData = new ClinicalSettingLib();
		timeLineData.workSheetName = "VerifySecurityOption";
		timeLineData.testCaseId = "TC_VSP_010";
		timeLineData.fetchClinicalSettingsTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, timeLineData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Security Option For cdmFlowSheets
	* @action 		  Verify Security Option For cdmFlowSheets
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 15, 2014
	***************************************************************************************************/
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib timeLineData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{			
						
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + timeLineData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, timeLineData.userName, timeLineData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Change the switch role 									  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,timeLineData.switchRole),"Could not change the switch role;More Details:"+timeLineData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			if(timeLineData.testCaseId.equals("TC_VSP_009")||timeLineData.testCaseId.equals("TC_VSP_008")){

			searchPatientNexiaForProviderHomePage(selenium,timeLineData.patientId);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lnkPatientInfo))
			{
				assertTrue(NavigateToPatientToPatientChart(selenium),"Could not navigate to patient chart", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,lnkProblemListTitle),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: No Access User Role										  //
			//--------------------------------------------------------------------//
			if(timeLineData.testCaseId.equals("TC_VSP_009")){
				assertTrue(!isElementPresent(selenium,chkTrackCondition),"Element is present", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				return true;
			}else
			{
				returnValue=false;
			}
			//--------------------------------------------------------------------//
			//  Step-9: View Only User Role										  //
			//--------------------------------------------------------------------//
			if(timeLineData.testCaseId.equals("TC_VSP_008")){
				assertTrue(!isElementPresent(selenium,chkTrackCondition),"Element is present", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				return true;
			}
			else
			{
				return false;
			}			
			}
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Managed Care Template						  //
			//--------------------------------------------------------------------//
			if(timeLineData.testCaseId.equals("TC_VSP_007")){
				assertTrue(switchRole(selenium,"Full"),"Could not change the switch role;More Details:"+timeLineData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
			mcTemplate.workSheetName = "ManagedCaredTemplate";
			mcTemplate.testCaseId = "TC_MCT_022";
			mcTemplate.fetchClinicalSettingsTestData();
			assertTrue(navigateToManagedCareTemplate(selenium),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Existing Managed Care Template						          //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllManagedCareTemplate(selenium,mcTemplate),"Deletion Failed:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Add Managed Care Template						          //
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

			//--------------------------------------------------------------------//
			//  Step-5: change the switch role 									  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,timeLineData.switchRole),"Could not change the switch role;More Details:"+timeLineData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,timeLineData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Managed Care//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkMore),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,lnkFlowSheets),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			assertTrue(click(selenium,lnkProblemListTitle),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-10: Limited Access User Role										  //
			//--------------------------------------------------------------------//
			if(timeLineData.testCaseId.equals("TC_VSP_007")){
				assertTrue(selenium.isVisible(chkTrackCondition),"Not Visible", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnCancelProblemList),"Could not click the Cancel Problrm List", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(navigateToManagedCareFlowSheet(selenium,mcTemplate,userAccount ),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
												
				assertTrue(click(selenium,lnkFlowSheet),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(selenium.isVisible(lnkRemove),"It is present", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				return true;
			}
			else
			{
				returnValue=false;
			}
			//--------------------------------------------------------------------//
			//  Step-11: Full Access User Role										  //
			//--------------------------------------------------------------------//
			if(timeLineData.testCaseId.equals("TC_VSP_010")){
				assertTrue(selenium.isVisible(chkTrackCondition),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnCancelProblemList),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(navigateToManagedCareFlowSheet(selenium,mcTemplate,userAccount ),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
								
				assertTrue(click(selenium,lnkFlowSheet),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				/*assertTrue(selenium.isVisible(lnkRemove),"It is not Present", selenium, ClassName, MethodName);
				waitForPageLoad(selenium); */
				
				return true;
			}
			else
			{
				returnValue=false;
			}
			
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
}
}
