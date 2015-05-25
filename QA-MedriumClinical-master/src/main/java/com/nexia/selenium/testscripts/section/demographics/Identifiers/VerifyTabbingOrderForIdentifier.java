package com.nexia.selenium.testscripts.section.demographics.Identifiers;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForIdentifier extends AbstractHomeTest{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewIdentifiers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib identifierTaborder = new HomeLib();
		identifierTaborder.workSheetName = "CreateIdentifiers";
		identifierTaborder.testCaseId = "TC_ID_014";
		identifierTaborder.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyTabbingOrderForIdentifier(seleniumHost, seleniumPort, browser, webSite, userAccount, identifierTaborder);
	}
	 
	/*************************************************************************************************** 
	* @purpose        To verify tabbing order
	* @action 		  verifying tabbing order
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 27, 2012
	***************************************************************************************************/
	public void verifyTabbingOrderForIdentifier(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,HomeLib contactTaborder) throws InterruptedException, IOException{
		
		Selenium selenium = null;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + contactTaborder.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, contactTaborder.userName, contactTaborder.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,contactTaborder.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID //
			//--------------------------------------------------------------------//
			/*waitForElement(selenium, registerPatient, 6000);
			if (isElementPresent(selenium, registerPatient))*/
			searchPatientNexia(selenium,contactTaborder.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// Step-4: Go to Identifier
			//--------------------------------------------------------------------//
			click(selenium,lnkIdentifier);
			waitForPageLoad(selenium);
			click(selenium,btnAddIdentifier);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// Step-5: verify Tabbing Order
			//--------------------------------------------------------------------//
			for(int i =0;i<csspathsIdentifiers.length;i++){
				assertTrue(isElementPresent(selenium,csspathsIdentifiers[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspathsIdentifiers[i]);
				waitForElementToEnable(selenium,csspathsIdentifiers[i]);
				selenium.keyPress(csspathsIdentifiers[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspathsIdentifiers[i]));
				}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}

