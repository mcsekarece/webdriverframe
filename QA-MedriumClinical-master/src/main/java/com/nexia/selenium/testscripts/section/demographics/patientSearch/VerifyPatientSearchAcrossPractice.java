package com.nexia.selenium.testscripts.section.demographics.patientSearch;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPatientSearchAcrossPractice extends AbstractHomeTest {
	HomeLib PatientData = new HomeLib();
	@Test(groups = {"Regression ","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying patient name with last name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientSearchWithLastName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_014";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	
	@Test(groups = {"Regression ","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying patient name with first name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientSearchWithFirstName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_001";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	
	@Test(groups = {"Regression ","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying patient name with patient id")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientSearchWithPatientId(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_007";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	
	@Test(groups = {"Regression ","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying patient name with alias 1")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientSearchWithPatientAlias1(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_007";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	
	@Test(groups = {"Regression ","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying patient name with alias 2")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientSearchWithPatientAlias2(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_008";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	
	@Test(groups = {"Regression ","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying patient name with phone number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientSearchWithPatientPhoneNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_009";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	
	@Test(groups = {"Regression ","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying patient name with dob")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientSearchWithPatientDob(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_010";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	
	@Test(groups = {"RegressionCA ","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying patient name with hcn")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientSearchWithPatientHCN(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_004";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	@Test(enabled=false)
	//@Test(groups = {"Regression ","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying patient name with hcn")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyClosePatientSearchResult(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_005";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createNewPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify create a New Patient entry
	* @action 		  verifying create a New Patient entry
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 23, 2012
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
			/*assertTrue(switchRole(selenium,patientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
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
				patientcaData.testCaseId = "TC_NPC_004";
				patientcaData.fetchHomeTestData();
				
				assertTrue(createPatientCAView(selenium,patientcaData,uniqueName),"Patient Checkin Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				click(selenium,btnSave1);
				
				assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(selenium.isAlertPresent()){
					Assert.assertFalse(selenium.isAlertPresent(),"Patient not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
				}
				
				String patId = getText(selenium, "patientID");
				waitForPageLoad(selenium);
				
				if(patientData.testCaseId.equals("TC_NPC_004")){
				    
					try{
						assertTrue(type(selenium,txtPatientBox,"6337685090"),"Could not type patient id",selenium, ClassName, MethodName);
					}catch(Exception e){
						assertTrue(type(selenium,txtPatientBox,"6337685090"),"Could not type patient id",selenium, ClassName, MethodName);
					}
					selenium.keyPress(txtPatientBox, "\\9");
					waitForElement(selenium,lblPatientResult,10000);
					
					if(!getText(selenium,lblPatientResult).contains("6337685090")){
					
					    assertTrue(click(selenium, btnRegistrationEdit),"Could not find the edit button", selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						
						selectValueFromAjaxList(selenium,"canadianProvincesuggestBox","Ontario");
						assertTrue(type(selenium,"healthcardNumber","6337685090"),"Type failed", selenium, ClassName, MethodName);
						assertTrue(type(selenium,"healthcardNumberVersion","ON"),"Type failed", selenium, ClassName, MethodName);
						click(selenium,btnSave1);
						try{
							assertTrue(type(selenium,txtPatientBox,"6337685090"),"Could not type patient id",selenium, ClassName, MethodName);
						}catch(Exception e){
							assertTrue(type(selenium,txtPatientBox,"6337685090"),"Could not type patient id",selenium, ClassName, MethodName);
						}
						selenium.keyPress(txtPatientBox, "\\9");
						waitForElement(selenium,lblPatientResult,10000);
						
					}
					
					assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patId,selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains("6337685090".trim().toLowerCase(new java.util.Locale("en","US"))),"match failed",selenium, ClassName, MethodName);
					//assertTrue(getText(selenium,lblPatientResult).contains(patientID));
					waitForPageLoad(selenium);
					return true;
				}
			}
			else{
				assertTrue(createPatient(selenium,patientData,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);	
				waitForPageLoad(selenium);
				
				click(selenium,btnSave1);
				
				assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(selenium.isAlertPresent()){
					Assert.assertFalse(selenium.isAlertPresent(),"Patient not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
				}
				
				
			}
			
			
			String patId = getText(selenium, "patientID");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkTopMenu),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSignout),"Could not click the log out button",selenium,ClassName,MethodName);
			click(selenium,btnYesButton);
			waitForPageLoad(selenium);
			click(selenium,lnkYes);
			waitForPageLoad(selenium);
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, "ELABSTEST", "aspire@123"),"Login Failed while using the password which has been reset",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(patientData.testCaseId.equals("TC_NPC_014")){
				try{
					assertTrue(type(selenium,txtPatientBox,patientData.lastName),"Could not type patient id",selenium, ClassName, MethodName);
				}catch(Exception e){
					assertTrue(type(selenium,txtPatientBox,patientData.lastName),"Could not type patient id",selenium, ClassName, MethodName);
				}
				selenium.keyPress(txtPatientBox, "\\9");
				waitForElement(selenium,lblPatientResult,10000);
				assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patId,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US"))),"match failed",selenium, ClassName, MethodName);
				//assertTrue(getText(selenium,lblPatientResult).contains(patientID));
				waitForPageLoad(selenium);
				return true;
			}
			
			if(patientData.testCaseId.equals("TC_NPC_001")){
				try{
					assertTrue(type(selenium,txtPatientBox,patientData.firstName),"Could not type patient id",selenium, ClassName, MethodName);
				}catch(Exception e){
					assertTrue(type(selenium,txtPatientBox,patientData.firstName),"Could not type patient id",selenium, ClassName, MethodName);
				}
				selenium.keyPress(txtPatientBox, "\\9");
				waitForElement(selenium,lblPatientResult,10000);
				assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patId,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.firstName.trim().toLowerCase(new java.util.Locale("en","US"))),"match failed",selenium, ClassName, MethodName);
				//assertTrue(getText(selenium,lblPatientResult).contains(patientID));
				waitForPageLoad(selenium);
				return true;
			}
			
			if(patientData.testCaseId.equals("TC_NPC_003")){
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
				return true;
			}
			
			if(patientData.testCaseId.equals("TC_NPC_007")){
				try{
					assertTrue(type(selenium,txtPatientBox,patientData.alias1),"Could not type patient id",selenium, ClassName, MethodName);
				}catch(Exception e){
					assertTrue(type(selenium,txtPatientBox,patientData.alias1),"Could not type patient id",selenium, ClassName, MethodName);
				}
				selenium.keyPress(txtPatientBox, "\\9");
				waitForElement(selenium,lblPatientResult,10000);
				assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patId,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias1.trim().toLowerCase(new java.util.Locale("en","US"))),"match failed",selenium, ClassName, MethodName);
				//assertTrue(getText(selenium,lblPatientResult).contains(patientID));
				waitForPageLoad(selenium);
				return true;
			}
			
			if(patientData.testCaseId.equals("TC_NPC_008")){
				try{
					assertTrue(type(selenium,txtPatientBox,patientData.alias2),"Could not type patient id",selenium, ClassName, MethodName);
				}catch(Exception e){
					assertTrue(type(selenium,txtPatientBox,patientData.alias2),"Could not type patient id",selenium, ClassName, MethodName);
				}
				selenium.keyPress(txtPatientBox, "\\9");
				waitForElement(selenium,lblPatientResult,10000);
				assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patId,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias2.trim().toLowerCase(new java.util.Locale("en","US"))),"match failed",selenium, ClassName, MethodName);
				//assertTrue(getText(selenium,lblPatientResult).contains(patientID));
				waitForPageLoad(selenium);
				return true;
			}
			
			if(patientData.testCaseId.equals("TC_NPC_009")){
				try{
					assertTrue(type(selenium,txtPatientBox,patientData.telephoneNo1),"Could not type patient id",selenium, ClassName, MethodName);
				}catch(Exception e){
					assertTrue(type(selenium,txtPatientBox,patientData.telephoneNo1),"Could not type patient id",selenium, ClassName, MethodName);
				}
				selenium.keyPress(txtPatientBox, "\\9");
				waitForElement(selenium,lblPatientResult,10000);
				assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patId,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains("(999) 999-9999".trim().toLowerCase(new java.util.Locale("en","US"))),"match failed",selenium, ClassName, MethodName);
				//assertTrue(getText(selenium,lblPatientResult).contains(patientID));
				waitForPageLoad(selenium);
				return true;
			}
			
			if(patientData.testCaseId.equals("TC_NPC_010")){
			    
			    if(userAccount.equals(CAAccount)){
				assertTrue(type(selenium,txtPatientBox,"05/06/1991"),"Could not type patient id",selenium, ClassName, MethodName);
				selenium.keyPress(txtPatientBox, "\\9");
				waitForElement(selenium,lblPatientResult,10000);
				assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patId,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains("05/06/1991".trim().toLowerCase(new java.util.Locale("en","US"))),"match failed",selenium, ClassName, MethodName);
				//assertTrue(getText(selenium,lblPatientResult).contains(patientID));
				waitForPageLoad(selenium);
				return true;
			    }
			    else{
				try{
					assertTrue(type(selenium,txtPatientBox,patientData.dob),"Could not type patient id",selenium, ClassName, MethodName);
				}catch(Exception e){
					assertTrue(type(selenium,txtPatientBox,patientData.dob),"Could not type patient id",selenium, ClassName, MethodName);
				}
			    }
				selenium.keyPress(txtPatientBox, "\\9");
				waitForElement(selenium,lblPatientResult,10000);
				assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patId,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.dob.trim().toLowerCase(new java.util.Locale("en","US"))),"match failed",selenium, ClassName, MethodName);
				//assertTrue(getText(selenium,lblPatientResult).contains(patientID));
				waitForPageLoad(selenium);
				return true;
			}
			
			if(patientData.testCaseId.equals("TC_NPC_005")){
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
				
				assertTrue(click(selenium,lnkSearchClose),"Could not find close",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(isElementPresent(selenium,lblPatientResult)){
				    Assert.fail("Patient search results are still visible");
				}
				if(isElementPresent(selenium,lnkSearchClose)){
				    Assert.fail("Close button still visible");
				}
				return true;
			}
			
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}