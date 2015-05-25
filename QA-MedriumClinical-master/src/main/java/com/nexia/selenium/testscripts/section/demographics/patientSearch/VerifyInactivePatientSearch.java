package com.nexia.selenium.testscripts.section.demographics.patientSearch;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyInactivePatientSearch extends AbstractHomeTest {
	
	@Test(groups = {"Regression ","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying in active patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPreviewPatientInformation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_015";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify create a New Patient entry
	* @action 	  verifying create a New Patient entry
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	  Sep 23, 2012
	***************************************************************************************************/
	public boolean createNewPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = false;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			/*assertTrue(switchRole(selenium, patientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to system setting 								  //
			//--------------------------------------------------------------------//
			
			 assertTrue(click(selenium,lnkQuickAction),"Could not click on quick action",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
	         
			 assertTrue(click(selenium,lnkSystemSettin),"Could not click system setting", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Delete All Mandatory data  								  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click admin Mandatory", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllMandatory(selenium), "Could not delete all mandatory fields", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkEnterpriseVariables),"Could not click the Enter prise Variable;More Details:"+patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			SystemSettingsLib enterPriseData = new SystemSettingsLib();
			enterPriseData.workSheetName = "AdminEnterPriseVariables";
			enterPriseData.testCaseId = "TC_Pv_004";
			enterPriseData.fetchSystemSettingTestData();
			
			assertTrue(deleteEnterPrise(selenium,enterPriseData),"Deleteion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Add Enterprise Variables //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddenterprise),"Could not click the Add button;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createEnterPrise(selenium,enterPriseData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Click New Patient Check-in   							  //
			//--------------------------------------------------------------------//				
			click(selenium,btnBackButton);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkQuickAction),"Could not click on quick action",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//verify access for registering a patient
			assertTrue(click(selenium,lnkRegisterPatient),"Could not click the Register Patient;More Deatils:"+patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String uniqueName="";
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("ddHHmm");
				uniqueName=DateFormat.format(cal.getTime());
				HomeLib patientcaData = new HomeLib();
				patientcaData.workSheetName = "NewPatientCheckInCAView";
				patientcaData.testCaseId = "TC_NPC_007";
				patientcaData.fetchHomeTestData();
				
				assertTrue(createPatientCAView(selenium,patientcaData,uniqueName),"Patient Checkin Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(selenium.isAlertPresent()){
					Assert.assertFalse(selenium.isAlertPresent(),"Patient not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
				}
				
				String patId = getText(selenium, "patientID");
				waitForPageLoad(selenium);
				
				try{
					assertTrue(type(selenium,txtPatientBox,patientData.lastName),"Could not type patient id",selenium, ClassName, MethodName);
				}catch(Exception e){
					assertTrue(type(selenium,txtPatientBox,patientData.lastName),"Could not type patient id",selenium, ClassName, MethodName);
				}
				selenium.keyPress(txtPatientBox, "\\9");
				waitForElement(selenium,lblPatientResult,10000);
				assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patId,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(!isChecked(selenium,"includeInactivescheckbox")){
					assertTrue(click(selenium,"includeInactivescheckbox"),"could not check include inactive check box",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				
				try{
					assertTrue(type(selenium,txtPatientBox,patId),"Could not type patient id",selenium, ClassName, MethodName);
				}catch(Exception e){
					assertTrue(type(selenium,txtPatientBox,patId),"Could not type patient id",selenium, ClassName, MethodName);
				}
				selenium.keyPress(txtPatientBox, "\\9");
				waitForElement(selenium,lblPatientResult,10000);
				
				assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patId,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patId.trim().toLowerCase(new java.util.Locale("en","US"))),"match failed",selenium, ClassName, MethodName);
				//assertTrue(getText(selenium,lblPatientResult).contains(patientID));
				waitForPageLoad(selenium);
				
				assertTrue(getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains("Inactive".trim().toLowerCase(new java.util.Locale("en","US"))),"could not get text",selenium,ClassName,MethodName);
				return true;
				
			}
			else{
				assertTrue(createPatient(selenium,patientData,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);	
				waitForPageLoad(selenium);
			}
			assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(selenium.isAlertPresent()){
				Assert.assertFalse(selenium.isAlertPresent(),"Patient not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
			}
			
			String patId = getText(selenium, "patientID");
			waitForPageLoad(selenium);
			
			try{
				assertTrue(type(selenium,txtPatientBox,patientData.lastName),"Could not type patient id",selenium, ClassName, MethodName);
			}catch(Exception e){
				assertTrue(type(selenium,txtPatientBox,patientData.lastName),"Could not type patient id",selenium, ClassName, MethodName);
			}
			selenium.keyPress(txtPatientBox, "\\9");
			waitForElement(selenium,lblPatientResult,10000);
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patId,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!isChecked(selenium,"includeInactivescheckbox")){
				assertTrue(click(selenium,"includeInactivescheckbox"),"could not check include inactive check box",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			try{
				assertTrue(type(selenium,txtPatientBox,patId),"Could not type patient id",selenium, ClassName, MethodName);
			}catch(Exception e){
				assertTrue(type(selenium,txtPatientBox,patId),"Could not type patient id",selenium, ClassName, MethodName);
			}
			selenium.keyPress(txtPatientBox, "\\9");
			waitForElement(selenium,lblPatientResult,10000);
			
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patId,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patId.trim().toLowerCase(new java.util.Locale("en","US"))),"match failed",selenium, ClassName, MethodName);
			//assertTrue(getText(selenium,lblPatientResult).contains(patientID));
			waitForPageLoad(selenium);
			
			assertTrue(getText(selenium,lblPatientSearchResults).toLowerCase(new java.util.Locale("en","US")).trim().contains("Inactive".trim().toLowerCase(new java.util.Locale("en","US"))),"could not get text",selenium,ClassName,MethodName);
			return true;
			
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
