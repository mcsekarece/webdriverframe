package com.nexia.selenium.testscripts.section.demographics.SocioEconomic;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForSocioEconomicCAView extends AbstractHomeTest{
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Tabing order a  SocioEconomic")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingorderForSocioEconomicCAView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib sEconomicTaborder = new HomeLib();
		sEconomicTaborder.workSheetName = "NewPatientCheckInCAView";
		sEconomicTaborder.testCaseId = "TC_NPC_006";
		sEconomicTaborder.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyTabbingorderForSocioEconomicCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicTaborder);
	}

	/*************************************************************************************************** 
	* @purpose        To verify tabbing order Socio Economic
	* @action 		  verifying tabbing order Socio Economic
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Apr 02, 2012
	***************************************************************************************************/
	public void verifyTabbingorderForSocioEconomicCAView(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,HomeLib patientTaborder) throws InterruptedException, IOException{
		
		Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrieve the New Selenium Session; More Details :" + patientTaborder.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientTaborder.userName, patientTaborder.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patientTaborder.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Create a patient  //
			//--------------------------------------------------------------------//
			assertTrue(goToNewPatientCheckIn(selenium), "Could not navigate to Patient information page", selenium, ClassName, MethodName);
		
			assertTrue(createNewPatientWithMandatoryCAView(selenium,patientTaborder,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);	
			
			//--------------------------------------------------------------------//
			//  Step-4: Go to SocialHistory  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkSocioEconomics), "Not able to click SocioEconomic link" , selenium, ClassName, MethodName);					
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Select SocialHistory create button //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit), "Not able to click Edit button", selenium, ClassName, MethodName);					
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Tab order //
			//--------------------------------------------------------------------//
			for(int i =0;i<csspathsSocioEconomicsCA.length;i++){
				assertTrue(isElementPresent(selenium,csspathsSocioEconomicsCA[i]),"Could not find "+csspathsSocioEconomicsCA[i] , selenium, ClassName, MethodName);
				selenium.focus(csspathsSocioEconomicsCA[i]);
				waitForElementToEnable(selenium,csspathsSocioEconomicsCA[i]);
				selenium.keyPress(csspathsSocioEconomicsCA[i], "\\9");
				assertTrue(selenium.getElementIndex(activeElementInPage).equals(selenium.getElementIndex(csspathsSocioEconomicsCA[i])),
						"Expected element index not matched ", selenium, ClassName, MethodName);					
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}

}
