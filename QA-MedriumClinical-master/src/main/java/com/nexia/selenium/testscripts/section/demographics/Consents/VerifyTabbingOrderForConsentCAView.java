package com.nexia.selenium.testscripts.section.demographics.Consents;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForConsentCAView extends AbstractHomeTest {
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Tabing order a Consent")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForConsentsCAView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib programTaborder = new HomeLib();
		programTaborder.workSheetName = "NewConsentCAView";
		programTaborder.testCaseId = "TC_NCCA_009";
		programTaborder.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyTabbingOrderForConsentsCAView(seleniumHost, seleniumPort, browser, webSite, userAccount,programTaborder);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify tabbing order for consents in CA view
	* @action 		  Verifying tabbing order for consents in CA view
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Approved
	* @useraccount    Both
	* @since  	      March 16, 2012
	***************************************************************************************************/
	public void verifyTabbingOrderForConsentsCAView(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,HomeLib patientTaborder) throws InterruptedException, IOException{
		
		Selenium selenium = null;
			try{
				//--------------------------------------------------------------------//	
				//  Step-1: Login to the Application
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientTaborder.toString());
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientTaborder.userName, patientTaborder.userPassword),"Login Failed ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-2:Change Switch Role  										  //
				//--------------------------------------------------------------------//
				assertTrue(switchRole(selenium,patientTaborder.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-3: Advanced search with Patient ID
				//--------------------------------------------------------------------//
				searchPatientNexiaCA(selenium,patientTaborder.patientID);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-4: Go to Consent
				//--------------------------------------------------------------------//	
				click(selenium, lnkConsentsPatient);
				waitForPageLoad(selenium);
				click(selenium,btnConsentsAdd);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-5:Verify Tabbing Order
				//--------------------------------------------------------------------//	
				for(int i =0;i<csspathspatient.length;i++){
					assertTrue(isElementPresent(selenium,csspathspatient[i]),"Not found", selenium, ClassName, MethodName);
					selenium.focus(csspathspatient[i]);
					waitForElementToEnable(selenium,csspathspatient[i]);
					selenium.keyPress(csspathspatient[i], "\\9");
					Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspathspatient[i]));
				}
				click(selenium,rdoSignedByOthers);
				waitForPageLoad(selenium);
				
				for(int i =0;i<csspathssubstitution.length;i++){
					assertTrue(isElementPresent(selenium,csspathssubstitution[i]),"Not found", selenium, ClassName, MethodName);
					selenium.focus(csspathssubstitution[i]);
					waitForElementToEnable(selenium,csspathssubstitution[i]);
					selenium.keyPress(csspathssubstitution[i], "\\9");
					Assert.assertEquals(selenium.getElementIndex(activeElementInPage), selenium.getElementIndex(csspathssubstitution[i]));
				}
		}catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}	
}
