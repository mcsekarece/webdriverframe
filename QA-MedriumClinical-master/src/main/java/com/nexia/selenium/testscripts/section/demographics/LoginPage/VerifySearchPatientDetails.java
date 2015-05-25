package com.nexia.selenium.testscripts.section.demographics.LoginPage;

import static com.sharedlibrary.ThreadSafeSeleniumSessionStorage.session;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;


public class VerifySearchPatientDetails extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Search Patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchPatientDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLib searchPatient= new HomeLib();
		searchPatient.workSheetName = "SearchPatient";
		searchPatient.testCaseId = "TC_SP_001";
		searchPatient.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySearchPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, searchPatient);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Login Page
	* @action 		  verifying Login Page
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Aug 31, 2012
	***************************************************************************************************/
	public boolean verifySearchPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib searchPatient) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + searchPatient.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, searchPatient.userName, searchPatient.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Search Patient//
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,txtSearchPatientBox),"Could not element present;More DEtails:"+searchPatient.toString(),selenium,ClassName,MethodName);
			assertTrue(type(selenium,txtSearchPatientBox,searchPatient.searchpatient),"Could not enter the patient name;More details:"+searchPatient.toString(),selenium,ClassName,MethodName);
			selenium.keyPress(txtSearchPatientBox, "\\9");
			
			//--------------------------------------------------------------------//
			//  Step-3:Sign out and sign //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTopMenu),"Could not click on the link" + searchPatient .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSignOut),"Could not click on System settings link:" + searchPatient .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			click(session(),btnYesButton);
			assertTrue(click(selenium,"link=Yes"),"Could not click on System settings link:" + searchPatient .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, searchPatient.userName, searchPatient.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,txtSearchPatientBox),"Could not element present;More DEtails:"+searchPatient.toString(),selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4:Verify Search Patient name is display //
			//--------------------------------------------------------------------//
			if(!verifySearchPatient(selenium,searchPatient)){
				returnValue=false;
				Assert.fail("Search patient name is display More Details :"+ searchPatient.toString());
			}else
				return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
	public boolean verifySearchPatient(Selenium selenium,HomeLib searchPatient) throws IOException{
		assertTrue(!getValue(selenium,txtSearchPatientBox).trim().contains(searchPatient.searchpatient),"Verification failed failed", selenium, ClassName, MethodName);
		return true;
	}
	
}
