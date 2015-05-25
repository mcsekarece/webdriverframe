package com.nexia.selenium.testscripts.section.demographics.Programs;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabingOrderForProgram extends AbstractHomeTest {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Tabing order a Program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForPrograms(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib programTaborder = new HomeLib();
		programTaborder.workSheetName = "NewProgram";
		programTaborder.testCaseId = "TC_P_013";
		programTaborder.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyTabbingOrderForPrograms(seleniumHost, seleniumPort, browser, webSite, userAccount,programTaborder);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify tabbing order New Patient Check in Programs
	* @action 		  verifying tabbing order New Patient Check in Programs
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Apr 02, 2012
	***************************************************************************************************/
	public void verifyTabbingOrderForPrograms(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,HomeLib patientTaborder) throws InterruptedException, IOException{
		
		Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientTaborder.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientTaborder.userName, patientTaborder.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patientTaborder.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Advanced search with Patient ID
			/*waitForElement(selenium, registerPatient, 6000);
			if (isElementPresent(selenium, registerPatient))*/
			searchPatientNexia(selenium,patientTaborder.patientID);
			waitForPageLoad(selenium);
			
			
			// Go to Programs
			click(selenium, lnkProgram);
			waitForPageLoad(selenium);

			// Select Programs Add button
			click(selenium,btnAddPrograms);
			waitForPageLoad(selenium);
			
			// Tab order // 
			for(int i =0;i<csspathsPrograms.length;i++){
				assertTrue(isElementPresent(selenium,csspathsPrograms[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspathsPrograms[i]);
				waitForElementToEnable(selenium,csspathsPrograms[i]);
				selenium.keyPress(csspathsPrograms[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex(activeElementInPage), selenium.getElementIndex(csspathsPrograms[i]));
				}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}

