package com.nexia.selenium.testscripts.section.chartprevisit.SigningAuthority;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyRxRenewalForSignAuth extends AbstractChartPreVisit {	

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate that System should allow user with Full access and signing authority to prescribe medication from the RxRenewal queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRxRenewalForFullAccessWithSignAuthTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_028";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyRxRenewalWithSigningAuthority(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate that System should allow user with Full access and signing authority to prescribe medication from the RxRenewal queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRxRenewalForLimitedAccessWithSignAuthTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_029";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyRxRenewalWithSigningAuthority(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}


	/*************************************************************************************************** 
	 * @purpose        Test to validate that System should allow user with Full access and signing authority to prescribe medication from the RxRenewal queue   
	 * @Specification  EMR-26: Limit Who Can Sign Prescriptions/DI/Lab 
	 * @action 		   Signing Authority
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       Aug 28, 2014
	 ***************************************************************************************************/

	public boolean verifyRxRenewalWithSigningAuthority(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib accessData) throws Exception{
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
			//  Step-2: Change Switch Role - FULL  					 //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,accessData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//Delete pending medications
			//Get prescribe data
			ChartPreVisitLib prescribeData = new ChartPreVisitLib();
			prescribeData.workSheetName = "PrescribeMedi";
			prescribeData.testCaseId = "TC_PM_126";
			prescribeData.fetchChartPreVisitTestData();			
			prescribeData.patientId = accessData.patientId;

			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,accessData.patientId), "Could not find patient: " +accessData.patientId, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Delete all Pending Medication In Medication Tab//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteAllPendingMedication(selenium,prescribeData),"Could not delete the pending medications", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Set Required Signing Authority values  					 //
			//--------------------------------------------------------------------//
			if (accessData.accessLevel.equalsIgnoreCase("Full") ) {   
				assertTrue(setFullAccessWithSigningAuthorityForUserRole(selenium, accessData), "Could not set user role", selenium, ClassName, MethodName);
			} 
			if (accessData.accessLevel.equalsIgnoreCase("Limited")) {
				assertTrue(setLimitedAccessWithSigningAuthorityForUserRole(selenium, accessData), "Could not set user role", selenium, ClassName, MethodName);
			}

			//--------------------------------------------------------------------//
			//  Step-6: Switch Role
			//--------------------------------------------------------------------//			
			assertTrue(switchRole(selenium,accessData.editRole), "Could not switch the role", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-7: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,accessData.patientId), "Could not find patient: " +accessData.patientId, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not Navigate to prescribe medication page",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			

			//--------------------------------------------------------------------//
			//  Step-9: Add Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(searchPrescribeMedication(selenium,prescribeData,userAccount),"Could not search for prescribed medicine", selenium, ClassName, MethodName);

			//Click Edit Link			
			assertTrue(click(selenium, lnkEdit),"Could not click Edit link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Could not search for prescribed medicine", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-10: Find Print button
			//--------------------------------------------------------------------//
			assertTrue(isElementVisible(selenium, btnPrint),"Print button not found", selenium, ClassName, MethodName);

			//---------------------------------------------------------------------//
			// Step-11: Click button add to pending
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddToPending),"Could not click Add To Pending button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-12:Search Pending Medication  In Meds Queue//
			//--------------------------------------------------------------------//

			//Click on Nexia a Logo
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the back button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//Click on RxRenewal Queue
			assertTrue(click(selenium,lnkRxRenewal),"Could not click the Meds queue button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//Search Created Pending Medication name
			String medicationSearchBox="medicationSlideWindowSearchBox";
			assertTrue(type(selenium,medicationSearchBox,prescribeData.patientId),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.keyDown(medicationSearchBox, "\\13"); 
			selenium.keyUp(medicationSearchBox, "\\13");
			selenium.keyPress(medicationSearchBox, "\\13");

			assertTrue(selectValueFromAjaxList(selenium,elementShowFilter,prescribeData.show),"Could not set show value", selenium, ClassName, MethodName);
			click(selenium,"//body/div[5]/div/div/div/div/div");
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxRxProvider,"Myself");
			click(selenium,"//body/div[5]/div/div/div/div/div");

			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-13: Verify Store Medication Value in Meds Queue//
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValues(selenium,prescribeData,userAccount),"The values are not stored properly in queue", selenium, ClassName, MethodName);

		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + accessData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}

	private boolean setLimitedAccessWithSigningAuthorityForUserRole(Selenium selenium, ChartPreVisitLib authData) throws IOException {
		boolean result = false;
		//Go to Security Settings and navigate to User Rules			
		assertTrue(navigateToEditUserRolePage(selenium,authData.editRole), "Could not edit user role " +authData.editRole , selenium, ClassName, MethodName);

		//Navigate to required Signing authority feature			
		assertTrue(click(selenium, lblClinicalCategory),"Could not click Clinical category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblOrdersCategory),"Could not click Orders category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Set Limited Access for Orders > Prescriptions with Signing Authority
		assertTrue(click(selenium,"rd363radio"), "Could not select Limited Access Radio button.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(check(selenium,"chk163checkbox"), "Could not select Signing Authority check Box.",selenium, ClassName, MethodName);
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


	private boolean setFullAccessWithSigningAuthorityForUserRole(Selenium selenium, ChartPreVisitLib authData ) throws IOException {
		boolean result;
		//Go to Security Settings and navigate to User Rules			
		assertTrue(navigateToEditUserRolePage(selenium,authData.editRole), "Could not edit user role " +authData.editRole , selenium, ClassName, MethodName);

		//Navigate to required Signing authority feature			
		assertTrue(click(selenium, lblClinicalCategory),"Could not click Clinical category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblOrdersCategory),"Could not click Orders category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Set Full Access for Orders > Prescriptions with Signing Authority
		assertTrue(click(selenium,"rd463radio"), "Could not select Full Access Radio button.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(check(selenium,"chk163checkbox"), "Could not select Signing Authority check Box.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Click Save button
		assertTrue(click(selenium, btnsaveProvider), "Could not click Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		 if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		result = true;
		return result;
	}

	private boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib prescribeData,String account){

		String date = null;
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dateFormat=new SimpleDateFormat("MMMMMMMM dd, yyyy");
		date=dateFormat.format(cal.getTime());
		waitForPageLoad(selenium);

		if(account.equals(CAAccount)){
			if(!getText(selenium,lblMedsQueue).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.prescribeCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}

		}else{
			if(!getText(selenium,lblMedsQueue).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.prescribeName.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}


		if(!getText(selenium,lblMedsQueue).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.patientId.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}

		if(!getText(selenium,lblMedsQueue).trim().contains("On "+date.trim())){
			return false;
		}
		return true;
	}


}


