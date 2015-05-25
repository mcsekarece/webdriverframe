package com.nexia.selenium.testscripts.section.demographics.patientCheckinInfo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySelectOptionsForPatentCheckInInfo extends AbstractHomeTest {
	@Test(groups ={"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying search field for Country")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchFieldForPatientInfo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_001";
		PatientData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySearchResults(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Select Options For Patent CheckIn Info
	* @action 		  verifying Select Options For Patent CheckIn Info
	* @author         Aspire QA
	* @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      July 02, 2012
	***************************************************************************************************/
	public boolean verifySearchResults(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=false;
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
			//  Step-3: Click New Patient Check-in   							  //
			//--------------------------------------------------------------------//				
			assertTrue(goToNewPatientCheckIn(selenium), "Could not navigate to Patient information page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!patientData.lastName.isEmpty())
				if(!patientData.lastName.contains("N/A"))
					assertTrue(type(selenium, txtLastName, patientData.lastName), "Could not Enter Last name, Expected value to be typed" + patientData.lastName, selenium, ClassName, MethodName);
			if(!patientData.firstName.isEmpty())
				if(!patientData.firstName.contains("N/A"))
					assertTrue(type(selenium, txtFirstName, patientData.firstName), "Could not Enter First name, Expected value to be typed" + patientData.firstName, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Select options display    						  //
			//--------------------------------------------------------------------//	
			if(!verifySelectOptionsPatientInfo(selenium,patientData)){
				returnValue=false;
				Assert.fail("Selected options are not displayed properly in the select boxes");
			}
			else
				returnValue=true;
			
		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
