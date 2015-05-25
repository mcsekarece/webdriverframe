package com.nexia.selenium.testscripts.section.demographics.patientCheckinInfo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForPatientInfoCAView extends AbstractHomeTest{

	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Tabbing order for a New patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForPatientInfo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientTaborder = new HomeLib();
		patientTaborder.workSheetName = "NewPatientCheckInCAView";
		patientTaborder.testCaseId = "TC_NPC_001";
		patientTaborder.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyTabbingOrderForPatientInfo(seleniumHost, seleniumPort, browser, webSite, userAccount,patientTaborder);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Tabbing Order For Patient Info
	* @action 		  verifying Tabbing Order For Patient Info
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 06, 2012
	***************************************************************************************************/
	public void verifyTabbingOrderForPatientInfo(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,HomeLib patienttaborder) throws InterruptedException, IOException{
			
		Selenium selenium = null;
		try{
			//login//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patienttaborder.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patienttaborder.userName, patienttaborder.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			assertTrue(goToNewPatientCheckIn(selenium), "Could not navigate to Patient information page", selenium, ClassName, MethodName);
			
			if(selenium.isChecked(chkMailingAsResidential)){
				selenium.click(chkMailingAsResidential);
			}
			
			// Tab order // 
			for(int i =1;i<cssPathPatientCheckinCA.length;i++){
				assertTrue(isElementPresent(selenium,cssPathPatientCheckinCA[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(cssPathPatientCheckinCA[i]);
				waitForElementToEnable(selenium,cssPathPatientCheckinCA[i]);
				selenium.keyPress(cssPathPatientCheckinCA[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(cssPathPatientCheckinCA[i]));
				if(cssPathPatientCheckinCA[i].equals("css=#prematurecheckbox")||cssPathPatientCheckinCA[i].equals("css=#mailingAsResidentialcheckbox")){
					click(selenium,cssPathPatientCheckinCA[i]);
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}
