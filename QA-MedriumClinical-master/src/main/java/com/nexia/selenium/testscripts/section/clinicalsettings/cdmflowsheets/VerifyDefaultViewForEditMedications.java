package com.nexia.selenium.testscripts.section.clinicalsettings.cdmflowsheets;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractCdmFlowSheets;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultViewForEditMedications extends AbstractCdmFlowSheets {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying defult view for Edit Medications")
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
			//  Step-5: Add Managed Care Template						          //
			//--------------------------------------------------------------------//
					
			if(isElementPresent(selenium,btnCreateCustom)){
				assertTrue(click(selenium, btnCreateCustom), "Could not click on create button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			if(isElementPresent(selenium,lnkstartBlankTemplate)){
				assertTrue(click(selenium, lnkstartBlankTemplate), "Could not click on Start Blank Template", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			if(!isChecked(selenium,chkMedication)){
				assertTrue(click(selenium, chkMedication), "Could not click on Medicatio check box ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if(!isChecked(selenium,chkAllergy)){
				assertTrue(click(selenium, chkAllergy), "Could not click on Allergy check box ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if(!isChecked(selenium,chkRiskFactors)){
				assertTrue(click(selenium, chkRiskFactors), "Could not click on Risk Factors check box ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if(!isChecked(selenium,chkFlowSheets)){
				assertTrue(click(selenium, chkFlowSheets), "Could not click on Flow sheets check box ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Default for Edit Medications						          //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkEditMedications), "Could not click on edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!isChecked(selenium,rdoAll)){
				return false;
			}
			
			if(isChecked(selenium,rdoSelect)){
				return false;
			}
			
		}catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}	
	return returnValue;
	}
}
