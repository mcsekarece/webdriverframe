package com.nexia.selenium.testscripts.section.clinicalsettings.cdmflowsheets;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractCdmFlowSheets;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultView extends AbstractCdmFlowSheets {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying default view in manage care template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createManageCareTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_001";
		mcTemplate.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
		createManagedCareTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	/*************************************************************************************************** 
	* @purpose        To verify add manage care template
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verifying add action for manage care template
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Jun 25, 2014
	***************************************************************************************************/
	
	public boolean createManagedCareTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException{
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
			//  Step-4: Delete Existing Managed Care Template						          //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllManagedCareTemplate(selenium,mcTemplate),"Deletion Failed:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Default View					          //
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium,btnCreateCustom)){
				assertTrue(click(selenium, btnCreateCustom), "Could not click on create button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			if(isElementPresent(selenium,lnkstartBlankTemplate)){
				assertTrue(click(selenium, lnkstartBlankTemplate), "Could not click on Start Blank Template", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				}
			
			assertTrue(!isChecked(selenium,chkMedication),"", selenium, ClassName, MethodName);
			assertTrue(!isChecked(selenium,chkAllergy),"", selenium, ClassName, MethodName);
			assertTrue(!isChecked(selenium,chkRiskFactors),"", selenium, ClassName, MethodName);
			assertTrue(!isChecked(selenium,chkFlowSheets),"", selenium, ClassName, MethodName);
		}catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}	
	return returnValue;
	}
}
