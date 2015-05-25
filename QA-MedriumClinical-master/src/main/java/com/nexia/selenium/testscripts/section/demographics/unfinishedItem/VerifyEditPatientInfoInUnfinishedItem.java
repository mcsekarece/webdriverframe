package com.nexia.selenium.testscripts.section.demographics.unfinishedItem;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditPatientInfoInUnfinishedItem extends AbstractHomeTest {
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Edit Patient Info In Unfinished Item")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditPatientInfoInUnfinishedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_010";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyEditPatientInfoInUnfinishedItem(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Edit Patient Info In Unfinished Item
	* @action 		  verifying Edit Patient Info In Unfinished Item
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      July 10, 2013
	***************************************************************************************************/
	public boolean verifyEditPatientInfoInUnfinishedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws Exception{
		Selenium selenium = null;
		String currentUnfinishedItem="Edit Personal Info for";
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
			assertTrue(switchRole(selenium,patientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete all unfinished item                                //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllUnfinishedItem(selenium),"Could not Delete all unfinished item  :"+ patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to system setting 								  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkQuickAction),"Could not click on the quick action link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkShowMoreLink),"Could not click on the show more action link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSetting),"Could not click the systemSettings link;More Deatils:",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5:Delete All Mandatory data  								  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click admin Mandatory", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllMandatory(selenium), "Could not delete all mandatory fields", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Click New Patient Check-in   							  //
			//--------------------------------------------------------------------//				
			click(selenium,btnBackButton);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkRegisterPatient), "Could not click on Clinical Lists",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createPatient(selenium,patientData,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			
			
			click(selenium,btnRegistrationEdit);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesPatientCheckinInfo(selenium,patientData)){
				Assert.fail("Patient details are not Create properly; More Details :"+ patientData.toString());
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-8: Edit the created patient details  //
			//--------------------------------------------------------------------//
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_009";
			patientData.fetchHomeTestData();
			assertTrue(createPatient(selenium,patientData,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Store data in unfinished item							  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnBackButton),"Could not Click Back button",selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnYesUnfinishedItem),"Could not click Yes button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
									
			//--------------------------------------------------------------------//
			//  Step-10: Navigate to unfinished item							  //
			//--------------------------------------------------------------------//
								
			//assertTrue(navigateToUnfinishedItem(selenium, currentUnfinishedItem),"Could not Navigate to unfinished item; More Details :"+ patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			if(selenium.isAlertPresent()){
				Assert.assertFalse(selenium.isAlertPresent(),"Patient not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
			}
			
			if(!verifyStoredValuesPatientCheckinInfo(selenium,patientData)){
				Assert.fail("Patient details are not saved properly; More Details :"+ patientData.toString());
			}
			
			
			// Complete the unfinished item
			click(selenium,btnSave1);
			
			assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(selenium.isAlertPresent()){
				Assert.assertFalse(selenium.isAlertPresent(),"Patient not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
			}
			
			//--------------------------------------------------------------------//
			//  Step-11: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesinSummaryPagePatientCheckinInfo(selenium,patientData)){
				Assert.fail("Patient details are not saved properly; More Details :"+ patientData.toString());
			}
			
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

