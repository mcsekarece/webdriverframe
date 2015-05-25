package com.nexia.selenium.testscripts.section.demographics.frontOfficeHomePage;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPatientDemographicsInformation extends AbstractHomeTest {
	HomeLib PatientData = new HomeLib();
	@Test(groups = {"Regression ","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying demographics patient information")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPreviewPatientInformation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_014";
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
	         
	         assertTrue(click(selenium,"css=#systemSettingsAction > span.actionItemSpan"),"Could not click system setting", selenium, ClassName, MethodName);
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
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			
			//Verify Today's appointments
			assertTrue(getText(selenium,lblCenterFrontdesk).contains("Today's Overview"),"could not get text",selenium,ClassName,MethodName);
			assertTrue(getText(selenium,lblCenterFrontdesk).contains("Appointments per Provider"),"could not get text",selenium,ClassName,MethodName);
			assertTrue(getText(selenium,lblNeedsAction).contains("Needs action"),"could not get text",selenium,ClassName,MethodName);
			
			assertTrue(click(selenium,lnkQuickAction),"Could not click on quick action",selenium, ClassName, MethodName);
	        waitForPageLoad(selenium);
			
	        //verify access for registering a patient
			assertTrue(click(selenium,lnkRegisterPatient),"Could not click the Register Patient;More Deatils:"+patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("ddHHmm");
				String uniqueName=DateFormat.format(cal.getTime());
				HomeLib patientcaData = new HomeLib();
				patientcaData.workSheetName = "NewPatientCheckInCAView";
				patientcaData.testCaseId = "TC_NPC_001";
				patientcaData.fetchHomeTestData();
				
				assertTrue(createPatientCAView(selenium,patientcaData,uniqueName),"Patient Checkin Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
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
			
			/*searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			*/
			/*click(selenium,"!patientInfoView");*/
			
			//Verify Patient information
			if(!verifyStoredValuesinSummaryPagePatientCheckinInfo(selenium,patientData)){
				Assert.fail("Patient details are not saved properly; More Details :"+ patientData.toString());
				returnValue=false;
			}
			else{
				 returnValue=true;
			}
				
			//Verify demographics access
			if(isElementPresent(selenium,lnkSocioEconomics)){
				returnValue=true;
			}
			else{
				Assert.fail("Demographics access is denied; More Details :"+ patientData.toString());
			}
			
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}