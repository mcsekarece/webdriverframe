package com.nexia.selenium.testscripts.section.chartprevisit.SigningAuthority;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCorrespondenceReportForNoSignAuth extends AbstractChartPreVisit {	
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate no Sign button on Correspondance report in patient's chart when signing authority is not selected for Full Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFileReportWithoutSigningAuthorityFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_008";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyFileReportWithoutSigningAuthority(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate no Sign button on Correspondance report in patient's chart when signing authority is not selected for Limited Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFileReportWithoutSigningAuthorityLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_009";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyFileReportWithoutSigningAuthority(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}

		
	/*************************************************************************************************** 
	 * @purpose        Test to validate no Sign button on Correspondance report in patient's chart when signing authority is not selected for Full/Limited Access  
	 * @Specification  EMR-26: Limit Who Can Sign Prescriptions/DI/Lab 
	 * @action 		   Signing Authority
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       Aug 22, 2014
	 ***************************************************************************************************/

	public boolean verifyFileReportWithoutSigningAuthority(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib accessData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + accessData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, accessData.userName, accessData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role - FULL  					 //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,accessData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Set Required Signing Authority values  					 //
			//--------------------------------------------------------------------//
			if (accessData.accessLevel.equalsIgnoreCase("Full") ) {   
				assertTrue(setFullAccessWithOutSigningAuthorityForUserRole(selenium, accessData), "Could not set user role", selenium, ClassName, MethodName);
			} 
			if (accessData.accessLevel.equalsIgnoreCase("Limited")) {
				assertTrue(setLimitedAccessWithOutSigningAuthorityForUserRole(selenium, accessData), "Could not set user role", selenium, ClassName, MethodName);
			}

			//--------------------------------------------------------------------//
			//  Step-4: Switch Role
			//--------------------------------------------------------------------//			
			assertTrue(switchRole(selenium,accessData.editRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to File Document Page
			//--------------------------------------------------------------------//
			assertTrue(navigateToFileDocumentPage(selenium, "", accessData.patientId, accessData.documentType),
					"Could not navigate to File Document Page", selenium, ClassName,MethodName);  
			
			//--------------------------------------------------------------------//
			//  Step-6: Check Sign button not found in Filing Document window
			//--------------------------------------------------------------------//
			assertTrue(!isElementVisible(selenium, btnSign),"Sign button found", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-7: Fill Correspondence Report For Filing
			//--------------------------------------------------------------------//
			//Modifying Senders data to add time stamp so that it can be uniquely identified			
			SimpleDateFormat ft = new SimpleDateFormat ("yyMMddHHmmss");
			accessData.sender = accessData.sender + ft.format(new Date());	 

			assertTrue(fillMandatoryCorrespondenceReportForFiling(selenium,accessData),"Not able to fill form correctly", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-8: Click Save & Next button
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnSaveNext),"Could not click Save&Next button.", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//Verify that after clicking Save button control navigated to next screen
			assertTrue(selenium.isTextPresent("Scan and Edit Documents"),"Not able to file " +accessData.documentType, selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-9: Verify saved Report
			//--------------------------------------------------------------------//
			assertTrue(verifySavedCorrespondenceReport(selenium, accessData),"Could not verify Saved correspondence Report.", selenium, ClassName, MethodName);


		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + accessData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}

	private boolean verifySavedCorrespondenceReport(Selenium selenium,	ChartPreVisitLib accessData) throws IOException {
		boolean isVerified = false;

		//Advanced search with Patient ID
		assertTrue(searchPatientNexiaForProviderHomePage(selenium,accessData.patientId),"Could not search patient", selenium, ClassName, MethodName);		
		waitForPageLoad(selenium);

		//Go To Correspondence Tab	
		
		assertTrue(click(selenium,lnkTabMore),"Could not click the more option tab", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		assertTrue(click(selenium,CorresTab),"Could not click the Corres tab", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Search for correspondence report
		String lblReportsDes = "xpath=(//div[@class='gwt-Label'])";
		String lblReportDes = "";
		boolean textFound = false;
		int n = (Integer) selenium.getXpathCount(lblReportsDes);
		for (int i = 1; i <= n; i++) {
			lblReportDes = lblReportsDes + "[" +i+ "]";
			if (getText(selenium, lblReportDes).contains(accessData.sender)) {
				assertTrue(click(selenium, lblReportDes),"Could not click the report", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				textFound = true;
				break;
			}
		}
		
		if (!textFound) {
			System.out.println("Not able to find text " +accessData.sender+ " in Correspondence Reports table");
			isVerified = false;
			return isVerified;
		}
		
		assertTrue(!(isElementPresent(selenium, btnSign) && isElementVisible(selenium, btnSign)),
				"Sign button found", selenium, ClassName, MethodName);
				
		isVerified = true;
	
		return isVerified;
	}	

	private boolean setLimitedAccessWithOutSigningAuthorityForUserRole(Selenium selenium, ChartPreVisitLib authData) throws IOException {
		boolean result = false; 
		//Go to Security Settings and navigate to User Rules			
		assertTrue(navigateToEditUserRolePage(selenium,authData.editRole), "Could not edit user role " +authData.editRole , selenium, ClassName, MethodName);

		//Navigate to required Signing authority feature			
		assertTrue(click(selenium, lblClinicalCategory),"Could not click Clinical category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblReportsCategory),"Could not click Reports category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//Set Limited Access for Reports > Labs without Signing Authority
		assertTrue(click(selenium,"rd3456radio"), "Could not select Limited Access Radio button for Reports > Correspondence.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(uncheck(selenium,"chk1456checkbox"), "Could not un-select Signing Authority check Box for Reports > Correspondence.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Click Save button
		assertTrue(click(selenium, btnsaveProvider), "Could not click Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		 if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		 assertTrue( !isElementPresent(selenium, btnsaveProvider), "Not able to save User Role", selenium, ClassName, MethodName);
		result = true;
		return result;
	}

	private boolean setFullAccessWithOutSigningAuthorityForUserRole(Selenium selenium, ChartPreVisitLib authData ) throws IOException {
		boolean result;
		//Go to Security Settings and navigate to User Rules			
		assertTrue(navigateToEditUserRolePage(selenium,authData.editRole), "Could not edit user role " +authData.editRole , selenium, ClassName, MethodName);

		//Navigate to required Signing authority feature			
		assertTrue(click(selenium, lblClinicalCategory),"Could not click Clinical category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblReportsCategory),"Could not click Reports category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Set Full Access for Reports > Labs without Signing Authority
		assertTrue(click(selenium,"rd4456radio"), "Could not select Full Access Radio button for Reports > Correspondence.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(uncheck(selenium,"chk1456checkbox"), "Could not un-select Signing Authority check Box for Reports > Correspondence.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Click Save button
		assertTrue(click(selenium, btnsaveProvider), "Could not click Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		 if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		 assertTrue( !isElementPresent(selenium, btnsaveProvider), "Not able to save User Role", selenium, ClassName, MethodName);
		result = true;
		return result;
	}


}


