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

public class VerifySaveAndAddAnotherCareElement extends AbstractCdmFlowSheets {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify the save and add another action for care elements.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveAndAddAnotherCareElement(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_032";
		mcTemplate.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
		verifySaveAndAddAnother(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	/*************************************************************************************************** 
	* @purpose        To verify the save and add another action for care elements.
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verifying the save and add another action for care elements.
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 28, 2014
	***************************************************************************************************/
	
	public boolean verifySaveAndAddAnother(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException{
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
			//  Step-6: Add Custom Widget Care Element			                  //
			//--------------------------------------------------------------------//
						
			assertTrue(addCustomWidgetCareElement(selenium,mcTemplate,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Values in the Default Fields			                  //
			//--------------------------------------------------------------------//
			
			assertTrue(verifyCareElementDefaultValue(selenium,mcTemplate,userAccount),"Edit failed", selenium, ClassName, MethodName);

		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
	public boolean verifyCareElementDefaultValue(Selenium selenium,ClinicalSettingLib proData,String account) throws IOException{
		
		assertTrue(getValue(selenium,ajxCategory).toLowerCase(new java.util.Locale("en","Us")).trim().contains(proData.category.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

		assertTrue(getValue(selenium,txtUpcoming).toLowerCase(new java.util.Locale("en","Us")).trim().contains(proData.due.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

		assertTrue(getValue(selenium,txtDue).toLowerCase(new java.util.Locale("en","Us")).trim().contains(proData.due.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

		assertTrue(getValue(selenium,ajxCareElementPanelsuggestBox).toLowerCase(new java.util.Locale("en","Us")).trim().contains("Custom Widget".trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

		assertTrue(getValue(selenium,ajxDueType).toLowerCase(new java.util.Locale("en","Us")).trim().contains(proData.dueType.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

		assertTrue(getValue(selenium,ajxAdvanceDue).toLowerCase(new java.util.Locale("en","Us")).trim().contains(proData.dueType.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

		return true;
	}
}
	
	
