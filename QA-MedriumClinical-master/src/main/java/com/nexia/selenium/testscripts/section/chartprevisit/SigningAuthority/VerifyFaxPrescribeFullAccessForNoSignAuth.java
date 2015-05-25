package com.nexia.selenium.testscripts.section.chartprevisit.SigningAuthority;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyFaxPrescribeFullAccessForNoSignAuth extends AbstractChartPreVisit {	

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate that System should allow faxing medication if Signing Authority is not selected")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFileReportWithoutSigningAuthorityFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_025";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyFileReportWithoutSigningAuthority(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}


	/*************************************************************************************************** 
	 * @purpose        Test to validate that System should allow faxing medication if Signing Authority is not selected  
	 * @Specification  EMR-26: Limit Who Can Sign Prescriptions/DI/Lab 
	 * @action 		   Signing Authority
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       Aug 27, 2014
	 ***************************************************************************************************/

	public boolean verifyFileReportWithoutSigningAuthority(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib accessData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application 								  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + accessData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, accessData.userName, accessData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role - FULL  					 			  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,accessData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Set Required Signing Authority values  					 //
			//--------------------------------------------------------------------//
			assertTrue(setFullAccessWithOutSigningAuthorityForUserRole(selenium, accessData), "Could not set user role", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Switch Role
			//--------------------------------------------------------------------//			
			assertTrue(switchRole(selenium,accessData.editRole), "Could not switch the role", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-5: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,accessData.patientId), "Could not find patient: " +accessData.patientId, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not Navigate to prescribe medication page",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//Get prescribe data
			ChartPreVisitLib prescribeData = new ChartPreVisitLib();
			prescribeData.workSheetName = "PrescribeMedi";
			prescribeData.testCaseId = "TC_PM_126";
			prescribeData.fetchChartPreVisitTestData();		
			
			//--------------------------------------------------------------------//
			//  Step-7: Add  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(searchPrescribeMedication(selenium,prescribeData,userAccount),"Could not search for prescribed medicine", selenium, ClassName, MethodName);

			//Click Edit Link			
			assertTrue(click(selenium, lnkEdit),"Could not click Edit link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Could not search for prescribed medicine", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-8: Find Print button
			//--------------------------------------------------------------------//
			assertTrue(isElementVisible(selenium, btnPrint),"Print button not found", selenium, ClassName, MethodName);
			
			//========================================
			//Click button add to pending
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddToPending),"Could not click Add To Pending button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Go to Medication tab
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkMore),"Could not click on More  link", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMedicationTab),"could not click the medication tab", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-10: Sign Prescription
			//--------------------------------------------------------------------//
			//click Action button
			assertTrue(click(selenium, "//a[contains(@id,'pendingAction')]"),"Could not click Action", selenium, ClassName,	MethodName);
			
			//Click Sign button
			assertTrue(click(selenium, "//a[contains(@id,'sign')]"),"Could not click Sign", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-11: Resend the signed prescription
			//--------------------------------------------------------------------//
		
			//Find Print button			
			assertTrue(click(selenium, btnPrint),"Print button could not clicked", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//Go to Medication tab
			assertTrue(click(selenium, lnkMore),	"Could not click on More  link", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMedicationTab),"could not click the medication tab", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);
			
			//click Action button
			assertTrue(click(selenium, "//a[contains(@id,'pendingAction')]"),"Could not click Action", selenium, ClassName,	MethodName);
			
			//Click resend button
			assertTrue(click(selenium, "//a[contains(@id,'resend')]"),"Could not click resend", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-12: Check for Print and Fax button
			//--------------------------------------------------------------------//
		
			//Find Print button			
			assertTrue(isElementVisible(selenium, btnPrint),"Print button not found", selenium, ClassName, MethodName);
			
			//Find Fax button			
			assertTrue(isElementVisible(selenium, "fax"),"Fax button not found", selenium, ClassName, MethodName);
													

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + accessData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}

	private boolean setFullAccessWithOutSigningAuthorityForUserRole(Selenium selenium, ChartPreVisitLib authData ) throws IOException {
		boolean result;
		//Go to Security Settings and navigate to User Rules			
		assertTrue(navigateToEditUserRolePage(selenium,authData.editRole), "Could not edit user role " +authData.editRole , selenium, ClassName, MethodName);

		//Navigate to required Signing authority feature			
		assertTrue(click(selenium, lblClinicalCategory),"Could not click Clinical category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblOrdersCategory),"Could not click Orders category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Set Full Access for Orders > Prescriptions without Signing Authority
		assertTrue(click(selenium,"rd463radio"), "Could not select Full Access Radio button.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(uncheck(selenium,"chk163checkbox"), "Could not un-select Signing Authority check Box.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Click Save button
		assertTrue(click(selenium, btnsaveProvider), "Could not click Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		 if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		result = true;
		return result;
	}


}


