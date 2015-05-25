package com.nexia.selenium.testscripts.section.demographics.patientSearch;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyNavigationArrows extends AbstractHomeTest {
	HomeLib PatientData = new HomeLib();
	@Test(groups = {"Regression ","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying navigation arrows")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNavigationArrows(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
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
			//  Step-2: Search Patient										     //
			//--------------------------------------------------------------------//	
			try{
				assertTrue(type(selenium,txtPatientBox,patientData.lastName),"Could not type patient id",selenium, ClassName, MethodName);
			}catch(Exception e){
				assertTrue(type(selenium,txtPatientBox,patientData.lastName),"Could not type patient id",selenium, ClassName, MethodName);
			}
			selenium.keyPress(txtPatientBox, "\\9");
			waitForElement(selenium,lblPatientResult,10000);
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patientData.lastName,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US"))),"match failed",selenium, ClassName, MethodName);
			//assertTrue(getText (selenium,lblPatientResult).contains(patientID));
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify Down arrow								             //
			//--------------------------------------------------------------------//	
			
			assertTrue(isElementPresent(selenium,btnNavArrowDown),"Could not find Down arrow",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String patientId=getText(selenium,lblPatientid);
			
			assertTrue(click(selenium,btnNavArrowDown),"Could not find up arrow",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblPatSearch).equals(patientId)){
				Assert.fail("Navigation failed");
			}
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify Up arrow								             //
			//--------------------------------------------------------------------//
			
			assertTrue(isElementPresent(selenium,btnNavArrowUP),"Could not find up arrow",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnNavArrowUP),"Could not find up arrow",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(getText(selenium,lblPatSearch1).equals(patientId),"Navigation failed",selenium,ClassName,MethodName);
			
			assertTrue(click(selenium,btnNavArrowUP),"Could not find up arrow",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getText(selenium,lblPatSearch2).equals(patientId),"Navigation failed",selenium,ClassName,MethodName);
			
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
