package com.nexia.selenium.testscripts.section.demographics.Referral;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;
public class VerifyTabbingOrderForReferral extends AbstractHomeTest  {
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default"}, description = "Test for verify Tabbing Order For Referral")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForReferal(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib refData = new HomeLib();
		refData.workSheetName = "CreateReferral";
		refData.testCaseId = "TC_CRL_012";
		refData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTabbingOrderForReferrals(seleniumHost, seleniumPort, browser, webSite, userAccount,refData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Tabbing Order For Referral
	* @action 		  verifying Tabbing Order For Referral
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 16, 2012
	***************************************************************************************************/
	public void verifyTabbingOrderForReferrals(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,HomeLib patientTaborder) throws InterruptedException, IOException{
		
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
			//  Step-3: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			//waitForElement(selenium, registerPatient, 6000);
			//if (isElementPresent(selenium, registerPatient))
			searchPatientNexia(selenium,patientTaborder.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create a new Referral //
			//--------------------------------------------------------------------//
			click(selenium, lnkReferrals);
			waitForPageLoad(selenium);
			click(selenium,btnAddReferral);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify tab order //
			//--------------------------------------------------------------------//
			for(int i =0;i<csspathsReferrals.length;i++){
				assertTrue(isElementPresent(selenium,csspathsReferrals[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspathsReferrals[i]);
				waitForElementToEnable(selenium,csspathsReferrals[i]);
				selenium.keyPress(csspathsReferrals[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex(activeElementInPage), selenium.getElementIndex(csspathsReferrals[i]));
				if(csspathsReferrals[i].equals(btnAuthorization)){
					click(selenium,csspathsReferrals[i]);
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}

