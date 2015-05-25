package com.nexia.selenium.testscripts.section.demographics.Contacts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForContacts extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Tabing order a Contact")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForContacts(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib contactTaborder = new HomeLib();
		contactTaborder.workSheetName = "CreateNewContact";
		contactTaborder.testCaseId = "TC_CPC_017";
		contactTaborder.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTabbingOrderForContacts(seleniumHost, seleniumPort, browser, webSite, userAccount,contactTaborder);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify Tabbing Order For Contact
	* @action 		  Verifying Tabbing Order For Contact 
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Mar 30, 2012
	***************************************************************************************************/
	public void verifyTabbingOrderForContacts(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,HomeLib contactTaborder) throws InterruptedException, IOException{
		
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
			//  Step-3:Advanced search with Patient ID //
			//--------------------------------------------------------------------//
			/*waitForElement(selenium, registerPatient, 6000);
			if (isElementPresent(selenium, registerPatient))*/
			searchPatientNexia(selenium,contactTaborder.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Click the Contact Link //
			//--------------------------------------------------------------------//
			click(selenium,lnkContactList);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Select Contacts Add button //
			//--------------------------------------------------------------------//
			click(selenium,btnAddContact);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Tab order //
			//--------------------------------------------------------------------//
			for(int i =0;i<csspathsContacts.length;i++){
				assertTrue(isElementPresent(selenium,csspathsContacts[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspathsContacts[i]);
				waitForElementToEnable(selenium,csspathsContacts[i]);
				selenium.keyPress(csspathsContacts[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspathsContacts[i]));
				}
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}
