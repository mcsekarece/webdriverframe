package com.nexia.selenium.testscripts.section.demographics.Consents;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteConsentFromCAView extends AbstractHomeTest{

	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleting  a consent")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewConsentSignedByPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib consentCAData = new HomeLib();
		consentCAData.workSheetName = "NewConsentCAView";
		consentCAData.testCaseId = "TC_NCCA_004";
		consentCAData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		deleteConsent(seleniumHost, seleniumPort, browser, webSite, userAccount, consentCAData);
	}

	/*************************************************************************************************** 
	* @purpose        To deleting consents 
	* @action 		  Verifying delete consents
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      June 25, 2012
	***************************************************************************************************/
	public boolean deleteConsent(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib consentData) throws Exception{
		boolean returnValue=true;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + consentData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, consentData.userName, consentData.userPassword),"Login Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,consentData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			searchPatientNexiaCA(selenium, consentData.patientID);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Consents and deleting existing Consents       //
			//--------------------------------------------------------------------//
			assertTrue(goToConsents(selenium), "Could not navigate to Consents Page", selenium, ClassName, MethodName);
			assertTrue(deleteAllConsents(selenium), "Could not delete consents", selenium, ClassName, MethodName);
					
			//--------------------------------------------------------------------//
			//  Step-4: Create a new Consent                                      //
			//--------------------------------------------------------------------//
			assertTrue(goToAddConsent(selenium),"Could not Navigate to Add Consents Page : "+ consentData.toString(), selenium, ClassName, MethodName);
			assertTrue(createConsentsCAView(selenium,consentData),"Consents creation Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verifying deletion of a consent                           //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllConsents(selenium), "Could not delete consents", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
/*	public boolean verifyStoredValues(Selenium selenium, HomeLib consentCAData) throws IOException{
		waitForPageLoad(selenium);
		assertTrue(getValue(selenium,ajkConsentsType).trim().contains(consentCAData.consentType.trim()), "Could get text", selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,ajkConsentsName).trim().contains(consentCAData.consentName.trim()), "Could get Name", selenium, ClassName, MethodName);
		if(consentCAData.signedBy.equalsIgnoreCase("Substitution Decision Maker")){
			assertTrue(getValue(selenium,ajkRelationship).trim().contains(consentCAData.relationship.trim()), "Could get relationship", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,txtFirstName).trim().contains(consentCAData.firstName.trim()), "Could get first name", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,txtLastName).trim().contains(consentCAData.lastName.trim()), "Could get last name", selenium, ClassName, MethodName);
		}
		if(consentCAData.status.equals("Enrolled")){
			assertTrue(getValue(selenium,ajkEnrolementStatusSugBox).trim().contains(consentCAData.status.trim()), "Could get enrollment", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,ajkEnrolledSugBox).trim().contains(consentCAData.entrolled.trim()), "Could get enroll form suggest box", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,ajkEnrolementDte).trim().contains(consentCAData.entrolledDate.trim()), "Could not get enroll date", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,txtCommentsConsents).trim().contains(consentCAData.comments.trim()), "Could get comments", selenium, ClassName, MethodName);
		}
		if(consentCAData.status.equals("Ended")){
			assertTrue(getValue(selenium,ajkEnrolementStatusSugBox).trim().contains(consentCAData.status.trim()), "Could not get enroll form status box", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,ajkEnrolledSugBox).trim().contains(consentCAData.entrolled.trim()), "Could not get enroll form sugest box", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,ajkEnrolementDte).trim().contains(consentCAData.entrolledDate.trim()), "Could not get enroll date", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,txtEnrolmentEndDate).trim().contains(consentCAData.endDate.trim()), "Could not get enroll date", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,txtReasonConsents).trim().contains(consentCAData.reason.trim()), "Could not get reason", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,txtCommentsConsents).trim().contains(consentCAData.comments.trim()), "Could not get comments", selenium, ClassName, MethodName);
			
		}
		return true;
	}*/
}
