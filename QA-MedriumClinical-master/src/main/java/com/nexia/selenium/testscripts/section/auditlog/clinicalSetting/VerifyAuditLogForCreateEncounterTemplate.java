package com.nexia.selenium.testscripts.section.auditlog.clinicalSetting;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForCreateEncounterTemplate extends AbstractAuditLog{
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing audit log for add encounter template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAuditLogForCreateEncounterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		AuditLogLib encounterTemplateTestData = new AuditLogLib();
		encounterTemplateTestData.workSheetName = "AuditLogForEncounterTemplate";
		encounterTemplateTestData.testCaseId = "TC_ET_001";
		encounterTemplateTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		encounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify audit log for add encounter template
	* @Specification  SRS_EMR_Encounter_Structure_Templates Rev0.0
	* @action 		  Verifying audit log for add encounter template
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 21, 2013
	***************************************************************************************************/
	
	public boolean encounterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, AuditLogLib encounterTemplateTestData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterTemplateTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterTemplateTestData.userName, encounterTemplateTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Change the switch role 									  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,encounterTemplateTestData.switchRole),"Could not change the switch role;More Details:"+encounterTemplateTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter Template 							  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToEncounterTemplate(selenium),"Navigation to encounter template Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Delete All Encounter Template 							  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllEncounterTemplate(selenium),"Could not Delete All Encounter Template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
						
			//--------------------------------------------------------------------//
			//  Step-5: Add new Encounter Template 								  //
			//--------------------------------------------------------------------//
			assertTrue(addEncounterTemplate(selenium, encounterTemplateTestData),"Could not add new Encounter Template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify the encounter template values in summary page      //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoreValuesEncounterTemplate(selenium, encounterTemplateTestData),"Verification failed for added encounter template in summary page", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-7: Go to  securitySetting and navigate to Audit Log 		  //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify Audit log for Encounter template					  //
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, encounterTemplateTestData, userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, encounterTemplateTestData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify whether Templates gets saved properly			  //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesForTemplates(selenium,encounterTemplateTestData, userAccount)){
				Assert.fail("User details not saved properly; More Details :"+ encounterTemplateTestData.toString());
				returnValue=false;
			}else{
				return returnValue;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + encounterTemplateTestData.toString());
		}
		return returnValue;
	}
	
	public boolean verifyStoredValuesForTemplates(Selenium selenium,AuditLogLib auditData, String account){
		String systemDate=null;
		String lblExpandEncounterTemplate="//div[@id='collapsableDesc']/div";
		
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy");
			systemDate=DateFormat.format(cal.getTime());
		}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			systemDate=DateFormat.format(cal.getTime());
		}
		
		
		if(!getText(selenium,lblExpandEncounterTemplate).trim().contains(systemDate.trim())){
			return false;
		}
		if(!getText(selenium,lblExpandEncounterTemplate).toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.active.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblExpandEncounterTemplate).toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.templateName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblExpandEncounterTemplate).toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.templateDescription.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}
