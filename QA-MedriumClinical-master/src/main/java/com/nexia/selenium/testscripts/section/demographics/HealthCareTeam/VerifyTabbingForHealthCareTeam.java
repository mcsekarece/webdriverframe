package com.nexia.selenium.testscripts.section.demographics.HealthCareTeam;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingForHealthCareTeam extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New Health Care Team")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabingOrderForHealthCareTeam(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib healthCareTabOrder = new  HomeLib();
		healthCareTabOrder.workSheetName = "EditHealthCareTeam";
		healthCareTabOrder.testCaseId = "TC_HCT_009";
		healthCareTabOrder.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTabbingOrderForHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, healthCareTabOrder);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify Tabbing Order In Health Care Team
	* @action 		  Verifying Tabbing Order In Health Care Team
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      April 02, 2012
	***************************************************************************************************/
	public void verifyTabbingOrderForHealthCareTeam(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,HomeLib healthCareTabOrder) throws InterruptedException, IOException{
		Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);		
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + healthCareTabOrder.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, healthCareTabOrder.userName, healthCareTabOrder.userPassword);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,healthCareTabOrder.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-3:Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,healthCareTabOrder.patientID);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-4:Go to HealthCareTeam//
			//--------------------------------------------------------------------//
			click(selenium, lnkPatientHealthcare);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-5:Tab order//
			//--------------------------------------------------------------------//
			click(selenium,btnEdit);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-6:Select HealthCareTeam Add button//
			//--------------------------------------------------------------------//
			 for(int i =0;i<csspathsHealthCareTeam.length;i++){
				assertTrue(isElementPresent(selenium,csspathsHealthCareTeam[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspathsHealthCareTeam[i]);
				waitForElementToEnable(selenium,csspathsHealthCareTeam[i]);
				selenium.keyPress(csspathsHealthCareTeam[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspathsHealthCareTeam[i]));
				}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}
