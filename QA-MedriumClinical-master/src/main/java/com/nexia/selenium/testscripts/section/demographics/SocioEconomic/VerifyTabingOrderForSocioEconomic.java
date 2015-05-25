package com.nexia.selenium.testscripts.section.demographics.SocioEconomic;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabingOrderForSocioEconomic extends AbstractHomeTest{

	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Tabing order a  SocioEconomic")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingorderForSocioEconomic(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib sEconomicTaborder = new HomeLib();
		sEconomicTaborder.workSheetName = "EditPatientInfo";
		sEconomicTaborder.testCaseId = "TC_EPI_002";
		sEconomicTaborder.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyTabbingorderForSocioEconomic(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicTaborder);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify tabbing order Socio Economic
	* @action 		  verifying tabbing order Socio Economic
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Mar 16, 2012
	***************************************************************************************************/
	public void verifyTabbingorderForSocioEconomic(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,HomeLib patientTaborder) throws InterruptedException, IOException{
		
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
			
			//--------------------------------------------------------------------//
			//  Step-3: Create a patient  //
			//--------------------------------------------------------------------//
			/*waitForElement(selenium, registerPatient, 6000);
			if (isElementPresent(selenium, registerPatient))*/
			searchPatientNexia(selenium,patientTaborder.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Go to SocialHistory  //
			//--------------------------------------------------------------------//
			click(selenium, lnkSocioEconomics);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Select SocialHistory create button //
			//--------------------------------------------------------------------//
			click(selenium,btnEdit);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Tab order //
			//--------------------------------------------------------------------//
			for(int i =0;i<csspathsSocioEconomics.length;i++){
				assertTrue(isElementPresent(selenium,csspathsSocioEconomics[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspathsSocioEconomics[i]);
				waitForElementToEnable(selenium,csspathsSocioEconomics[i]);
				selenium.keyPress(csspathsSocioEconomics[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex(activeElementInPage), selenium.getElementIndex(csspathsSocioEconomics[i]));
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}
