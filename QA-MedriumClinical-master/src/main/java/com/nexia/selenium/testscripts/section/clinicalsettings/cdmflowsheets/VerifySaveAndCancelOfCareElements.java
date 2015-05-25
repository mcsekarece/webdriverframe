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

public class VerifySaveAndCancelOfCareElements extends AbstractCdmFlowSheets{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify the save actions on care elements.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveCareElements(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_022";
		mcTemplate.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
		verifySaveAndCancelOfCareElements(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify the cancel actions on care elements.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelCareElements(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_024";
		mcTemplate.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
		verifySaveAndCancelOfCareElements(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify the save and cancel actions on care elements.
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verifying save and cancel actions on care elements
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 20, 2014
	***************************************************************************************************/
	
	public boolean verifySaveAndCancelOfCareElements(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException{
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
			//  Step-5: Add Managed Care Template	 					          //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=dateFormat.format(cal.getTime());
			assertTrue(enterDetailsForeManagedCareTemplate(selenium,mcTemplate,uniqueName),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(addNewCategoryInAddCareElementPage(selenium,mcTemplate,uniqueName,userAccount),"Creation of care element Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verification Managed Care Element	 					          //
			//--------------------------------------------------------------------//
			
			if(mcTemplate.testCaseId.equals("TC_MCT_022")){
				assertTrue(verifySaveCareElement(selenium,mcTemplate,userAccount),"Save failed", selenium, ClassName, MethodName);
			}
			else
			{
				assertTrue(verifyCancelCareElement(selenium,mcTemplate,userAccount),"Cancel failed", selenium, ClassName, MethodName);
			}
				
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
}
	
	public boolean verifySaveCareElement(Selenium selenium,ClinicalSettingLib mcTemplate,String account) throws IOException{
		assertTrue(click(selenium,ajxCategory),"could ot click category", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(getText(selenium,"currentItem_1").toLowerCase(new java.util.Locale("en","Us")).trim().contains(mcTemplate.category.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

		assertTrue(click(selenium,lnkCancelMedication),"could ot click cancel", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(isTextPresent(selenium,mcTemplate.category),"could ot click cancel", selenium, ClassName, MethodName);
		
		return true;
	}
	
public boolean verifyCancelCareElement(Selenium selenium,ClinicalSettingLib mcTemplate,String account) throws IOException{
	assertTrue(click(selenium,ajxCategory),"could ot click category", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	
	assertTrue(!getText(selenium,"currentItem_1").toLowerCase(new java.util.Locale("en","Us")).trim().contains(mcTemplate.category.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

	assertTrue(click(selenium,lnkCancelMedication),"could ot click cancel", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	
	assertTrue(!isTextPresent(selenium,mcTemplate.category),"could ot click cancel", selenium, ClassName, MethodName);
			
		return true;
	}
}