package com.nexia.selenium.testscripts.section.demographics.patientCheckinInfo;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultValueForInfo extends AbstractHomeTest{
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Default Last Name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFiledDefulatLastName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLDLM_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForDefaultValue(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Default First Name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFiledDefulatFirstName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLFM_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForDefaultValue(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Default Status ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFiledDefulatStatus(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest patientData = new HomeLibUnitTest();
		patientData.workSheetName = "UnitTest_FV_PC_Info";
		patientData.testCaseId = "TC_FLSTA_001";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyFieldForDefaultValue(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Field For Default Value
	* @action 		  verifying Field For Default Value
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Apr 02, 2012
	***************************************************************************************************/
	public boolean verifyFieldForDefaultValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLibUnitTest patientData) throws IOException{
		boolean returnValue=true;
		Selenium selenium =null;
		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application  								  //
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
			//  Step-3: Verify the Unit Test  								      // 
			//--------------------------------------------------------------------//	
			assertTrue(goToNewPatientCheckIn(selenium), "Could not navigate to Patient information page", selenium, ClassName, MethodName);
			
			assertTrue(createPatient_UnitTest(selenium,patientData),"Patient Check-in failed", selenium, ClassName, MethodName);
			
			
			if(!verifyStoreValuePatientCheckinDefaultValue(selenium,patientData)){
				Assert.fail("Default Value is incorrect :"+ patientData.toString());
				returnValue=false;
				
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}


