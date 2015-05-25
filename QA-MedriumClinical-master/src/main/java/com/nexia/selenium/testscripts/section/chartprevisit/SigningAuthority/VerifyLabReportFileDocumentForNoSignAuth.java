package com.nexia.selenium.testscripts.section.chartprevisit.SigningAuthority;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyLabReportFileDocumentForNoSignAuth extends AbstractChartPreVisit {	
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate no Sign button on Filing Document window if LAB report/signing authority is not selected for Full Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFileReportWithoutSigningAuthorityFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_006";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyFileReportWithoutSigningAuthority(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate no Sign button on Filing Document window if LAB report/signing authority is not selected for Limited Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFileReportWithoutSigningAuthorityLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_007";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyFileReportWithoutSigningAuthority(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}

		
	/*************************************************************************************************** 
	 * @purpose        Test to validate no Sign button on Filing Document window if LAB report/signing authority is not selected for Full\Limited Access  
	 * @Specification  EMR-26: Limit Who Can Sign Prescriptions/DI/Lab 
	 * @action 		   Signing Authority
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       Aug 19, 2014
	 ***************************************************************************************************/

	public boolean verifyFileReportWithoutSigningAuthority(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib authData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + authData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, authData.userName, authData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role - FULL  					 //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,authData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Set Required Signing Authority values  					 //
			//--------------------------------------------------------------------//
			if (authData.testCaseId == "TC_SA_006") { 
				setFullAccessWithOutSigningAuthorityForUserRole(selenium, authData);
			} 
			if (authData.testCaseId == "TC_SA_007") {
				setLimitedAccessWithOutSigningAuthorityForUserRole(selenium, authData);
			}

			//--------------------------------------------------------------------//
			//  Step-4: Switch Role
			//--------------------------------------------------------------------//			
			assertTrue(switchRole(selenium,authData.editRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Check Sign Button in Filing Document window
			//--------------------------------------------------------------------//
			assertTrue(navigateToFileDocumentPage(selenium, "", authData.patientId, authData.documentType),
					"Could not navigate to File Document Page", selenium, ClassName,MethodName);  
			
			assertTrue(!isElementVisible(selenium, btnSign),"Sign button found", selenium, ClassName, MethodName);



		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + authData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}

	private void setLimitedAccessWithOutSigningAuthorityForUserRole(Selenium selenium, ChartPreVisitLib authData) throws IOException {

		//Go to Security Settings and navigate to User Rules			
		assertTrue(navigateToEditUserRolePage(selenium,authData.editRole), "Could not edit user role " +authData.editRole , selenium, ClassName, MethodName);

		//Navigate to required Signing authority feature			
		assertTrue(click(selenium, lblClinicalCategory),"Could not click Clinical category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblOrdersCategory),"Could not click Orders category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		assertTrue(click(selenium, lblReportsCategory),"Could not click Reports category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//Set Limited Access for Reports > Labs without Signing Authority
		assertTrue(click(selenium,"rd347radio"), "Could not select Limited Access Radio button for Reports > Labs.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(uncheck(selenium,"chk147checkbox"), "Could not un-select Signing Authority check Box for Reports > Labs.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Click Save button
		assertTrue(click(selenium, btnsaveProvider), "Could not click Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		 if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	}

	private void setFullAccessWithOutSigningAuthorityForUserRole(Selenium selenium, ChartPreVisitLib authData ) throws IOException {

		//Go to Security Settings and navigate to User Rules			
		assertTrue(navigateToEditUserRolePage(selenium,authData.editRole), "Could not edit user role " +authData.editRole , selenium, ClassName, MethodName);

		//Navigate to required Signing authority feature			
		assertTrue(click(selenium, lblClinicalCategory),"Could not click Clinical category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblOrdersCategory),"Could not click Orders category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblReportsCategory),"Could not click Reports category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Set Full Access for Reports > Labs without Signing Authority
		assertTrue(click(selenium,"rd447radio"), "Could not select Full Access Radio button for Reports > Labs.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(uncheck(selenium,"chk147checkbox"), "Could not un-select Signing Authority check Box for Reports > Labs.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Click Save button
		assertTrue(click(selenium, btnsaveProvider), "Could not click Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		 if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	}


}


