package com.nexia.selenium.testscripts.section.demographics.patientCheckinInfo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabingOrderForPatientInfo extends AbstractHomeTest {
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Tabbing order for a New patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForPatientInfo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientTaborder = new HomeLib();
		patientTaborder.workSheetName = "NewPatientCheckIn";
		patientTaborder.testCaseId = "TC_NPC_002";
		patientTaborder.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyTabbingOrderForPatientInfo(seleniumHost, seleniumPort, browser, webSite, userAccount,patientTaborder);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Tabing Order For PatientInfo
	* @action 		  verifying Tabing Order For PatientInfo
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 06, 2012
	***************************************************************************************************/
	public void verifyTabbingOrderForPatientInfo(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,HomeLib patienttaborder) throws InterruptedException, IOException{
			
		Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patienttaborder.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patienttaborder.userName, patienttaborder.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patienttaborder.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(goToNewPatientCheckIn(selenium), "Could not navigate to Patient information page", selenium, ClassName, MethodName);
			
			if(selenium.isChecked(chkMailingAsResidential)){
				selenium.click(chkMailingAsResidential);
			}
			
			// Tab order // 
			for(int i =1;i<cssPathPatientCheckin.length;i++){
				assertTrue(isElementPresent(selenium,cssPathPatientCheckin[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(cssPathPatientCheckin[i]);
				waitForElementToEnable(selenium,cssPathPatientCheckin[i]);
				selenium.keyPress(cssPathPatientCheckin[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(cssPathPatientCheckin[i]));
				if(cssPathPatientCheckin[i].equals("css=#prematurecheckbox")||cssPathPatientCheckin[i].equals("css=#mailingAsResidentialcheckbox")){
					waitForPageLoad(selenium);
					click(selenium,cssPathPatientCheckin[i]);
					waitForPageLoad(selenium);
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}
