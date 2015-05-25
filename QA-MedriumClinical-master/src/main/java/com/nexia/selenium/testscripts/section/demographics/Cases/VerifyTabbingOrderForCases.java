package com.nexia.selenium.testscripts.section.demographics.Cases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForCases extends AbstractHomeTest{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Case")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifytabingOrderForCases(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLib casesData = new HomeLib();
		casesData.workSheetName = "NewCases";
		casesData.testCaseId = "TC_NC_010";
		casesData.fetchHomeTestData();
		verifyTabbingOrderForCases(seleniumHost, seleniumPort, browser, webSite, userAccount, casesData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Adding a New patient Case
	* @action 		  Adding a New patient Case
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Approved
	* @useraccount    Both
	* @since  	      March 22, 2012
	***************************************************************************************************/
	public void verifyTabbingOrderForCases(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,HomeLib casesTaborder) throws InterruptedException, IOException{
		Selenium selenium = null;	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + casesTaborder.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, casesTaborder.userName, casesTaborder.userPassword),"Login Failed", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role                                   	  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,casesTaborder.switchRole),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			searchPatientNexia(selenium,casesTaborder.patientID);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Cases                                         //
			//--------------------------------------------------------------------//
			assertTrue(goToCases(selenium), "Could not navigate to Cases Page", selenium, ClassName, MethodName);
						
			//---------------------------------------------------------- ---------//
			//  Step-4: Create a new case                                         //
			//--------------------------------------------------------------------//
			assertTrue(goToAddCase(selenium),"Could not Navigate to Add Cases Button : "+ casesTaborder.toString(), selenium, ClassName, MethodName);
			
			// Tab order //
			for(int i =0;i<csspathsCases.length;i++){
				assertTrue(isElementPresent(selenium,csspathsCases[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspathsCases[i]);
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,csspathsCases[i]);
				selenium.keyPress(csspathsCases[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspathsCases[i]));
			}
			
			click(selenium,btnAddCaseDates);
			waitForPageLoad(selenium);
			for(int i =0;i<csspathsCases.length;i++){
				assertTrue(isElementPresent(selenium,csspathsCases[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspathsCases[i]);
				waitForElementToEnable(selenium,csspathsCases[i]);
				selenium.keyPress(csspathsCases[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspathsCases[i]));
				}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}



