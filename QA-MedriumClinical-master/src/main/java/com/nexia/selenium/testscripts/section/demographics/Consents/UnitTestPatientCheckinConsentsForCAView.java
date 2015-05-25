package com.nexia.selenium.testscripts.section.demographics.Consents;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestPatientCheckinConsentsForCAView extends AbstractHomeTest{
	
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "entrolled To With Blank")	
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void entrolledToWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentsCATestData = new  HomeLibUnitTest();
		consentsCATestData.workSheetName = "UnitTest_FV_PC_ConsentsCAView";
		consentsCATestData.testCaseId = "TC_CICA_001";
		consentsCATestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsentsCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, consentsCATestData);
	}

	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "reasonWithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void reasonWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentsCATestData = new  HomeLibUnitTest();
		consentsCATestData.workSheetName = "UnitTest_FV_PC_ConsentsCAView";
		consentsCATestData.testCaseId = "TC_CICA_002";
		consentsCATestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsentsCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, consentsCATestData);
	}
	
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "EntorlledDatewithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void entorlledDatewithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentsCATestData = new  HomeLibUnitTest();
		consentsCATestData.workSheetName = "UnitTest_FV_PC_ConsentsCAView";
		consentsCATestData.testCaseId = "TC_CICA_003";
		consentsCATestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsentsCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, consentsCATestData);
	}
	
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "EntorlledDatewithChar")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void entorlledDatewithChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentsCATestData = new  HomeLibUnitTest();
		consentsCATestData.workSheetName = "UnitTest_FV_PC_ConsentsCAView";
		consentsCATestData.testCaseId = "TC_CICA_004";
		consentsCATestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsentsCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, consentsCATestData);
	} 

	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "EntorlledDatewithDifferentFormat")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void entorlledDatewithDifferentFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentsCATestData = new  HomeLibUnitTest();
		consentsCATestData.workSheetName = "UnitTest_FV_PC_ConsentsCAView";
		consentsCATestData.testCaseId = "TC_CICA_005";
		consentsCATestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsentsCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, consentsCATestData);
	}

	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "EntorlledDatewithNumber")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void entorlledDatewithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentsCATestData = new  HomeLibUnitTest();
		consentsCATestData.workSheetName = "UnitTest_FV_PC_ConsentsCAView";
		consentsCATestData.testCaseId = "TC_CICA_006";
		consentsCATestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsentsCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, consentsCATestData);
	}

	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "EntorlledDatewithSpacialChar")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void entorlledDatewithSpecialCahr(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentsCATestData = new  HomeLibUnitTest();
		consentsCATestData.workSheetName = "UnitTest_FV_PC_ConsentsCAView";
		consentsCATestData.testCaseId = "TC_CICA_007";
		consentsCATestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsentsCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, consentsCATestData);
	} 
	
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "entorlledDatewithLessThanStartDate")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void entorlledDatewithLessThanStartDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentsCATestData = new  HomeLibUnitTest();
		consentsCATestData.workSheetName = "UnitTest_FV_PC_ConsentsCAView";
		consentsCATestData.testCaseId = "TC_CICA_008";
		consentsCATestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsentsCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, consentsCATestData);
	}
	
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "endDatewithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endDatewithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentsCATestData = new  HomeLibUnitTest();
		consentsCATestData.workSheetName = "UnitTest_FV_PC_ConsentsCAView";
		consentsCATestData.testCaseId = "TC_CICA_009";
		consentsCATestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsentsCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, consentsCATestData);
	} 
	
	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "endDatewithDifferentFormat")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endDatewithDifferentFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentsCATestData = new  HomeLibUnitTest();
		consentsCATestData.workSheetName = "UnitTest_FV_PC_ConsentsCAView";
		consentsCATestData.testCaseId = "TC_CICA_010";
		consentsCATestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsentsCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, consentsCATestData);
	}

	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "endDatewithNumber")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endDatewithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentsCATestData = new  HomeLibUnitTest();
		consentsCATestData.workSheetName = "UnitTest_FV_PC_ConsentsCAView";
		consentsCATestData.testCaseId = "TC_CICA_011";
		consentsCATestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsentsCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, consentsCATestData);
	}

	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "eEntorlledDatewithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endDatewithSpecialChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentsCATestData = new  HomeLibUnitTest();
		consentsCATestData.workSheetName = "UnitTest_FV_PC_ConsentsCAView";
		consentsCATestData.testCaseId = "TC_CICA_012";
		consentsCATestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsentsCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, consentsCATestData);
	}

	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "endDatewithChar")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endDatewithChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentsCATestData = new  HomeLibUnitTest();
		consentsCATestData.workSheetName = "UnitTest_FV_PC_ConsentsCAView";
		consentsCATestData.testCaseId = "TC_CICA_013";
		consentsCATestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsentsCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, consentsCATestData);
	}

	@Test(groups = {"RegressionCAUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "endDateLessThenEntrolledDate")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endDateLessThenEntrolledDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentsCATestData = new  HomeLibUnitTest();
		consentsCATestData.workSheetName = "UnitTest_FV_PC_ConsentsCAView";
		consentsCATestData.testCaseId = "TC_CICA_014";
		consentsCATestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addConsentsCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, consentsCATestData);
	}

	/*************************************************************************************************** 
	* @purpose        To add Consents CA View
	* @action 		  Verifying add Consents CA View
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Approved
	* @useraccount    Both
	* @since  	      June 26, 2012
	***************************************************************************************************/
	public void addConsentsCAView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLibUnitTest consentData) throws IOException{
		Selenium selenium = null;
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
			//  Step-2: Navigate to Consents and deleting existing Consents       //
			//--------------------------------------------------------------------//
			assertTrue(goToConsents(selenium), "Could not navigate to Consents Page", selenium, ClassName, MethodName);
			assertTrue(deleteAllConsents(selenium), "Could not delete consents", selenium, ClassName, MethodName);
					
			//--------------------------------------------------------------------//
			//  Step-3: Create a new Consent                                      //
			//--------------------------------------------------------------------//
			assertTrue(goToAddConsent(selenium),"Could not Navigate to Add Consents Page : "+ consentData.toString(), selenium, ClassName, MethodName);
			assertTrue(submitConsentCAView(selenium,consentData),"Patient Consents failed", selenium, ClassName, MethodName);
			consentData.validationFieldID = consentData.validationFieldID == null ? consentData.validationFieldID = "" : consentData.validationFieldID.trim();
			assertTrue(isElementPresent(selenium, consentData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, consentData.validationFieldID).contains(consentData.alertMessage), "The expected validation message should contain the text - "+ consentData.alertMessage + " The actual validation message shown - " + getText(selenium, consentData.validationFieldID), selenium, ClassName, MethodName);
		}catch (RuntimeException e) {
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
	/**
	 * submitConsentCAView
	 * function to submit Consent CA View
	 * @throws IOException 
	 * @since  	    June 26, 2012
	 */
	public boolean submitConsentCAView(Selenium selenium, HomeLibUnitTest consentsCATestData) throws IOException{
		try{	
			selectValueFromAjaxList(selenium,ajkConsentsType, consentsCATestData.consentType);
			selectValueFromAjaxList(selenium,ajkConsentsName, consentsCATestData.consentName);
			assertTrue(enterDate(selenium,txtDateSigned,consentsCATestData.dateSigned),"Could not enter the start Date;More Deatils:"+consentsCATestData.toString(), selenium, ClassName, MethodName);
			if(consentsCATestData.status.equals("Enrolled")){
				 selectValueFromAjaxList(selenium,ajkEnrolementStatusSugBox,consentsCATestData.status);
				 //selectValueFromAjaxList(selenium,ajkEnrolledSugBox,consentsCATestData.entrolledTo);
				 assertTrue(type(selenium,ajkEnrolledSugBox,consentsCATestData.entrolledTo),"", selenium, ClassName, MethodName);
				 assertTrue(enterDate(selenium,ajkEnrolementDte,consentsCATestData.entrolledDate),"", selenium, ClassName, MethodName);
				 assertTrue(type(selenium,txtCommentsConsents,consentsCATestData.comments),"Could not type the comments;More Details:"+consentsCATestData.toString(), selenium, ClassName, MethodName);
			 }
			if(consentsCATestData.status.equals("Ended")){
				selectValueFromAjaxList(selenium,ajkEnrolementStatusSugBox,consentsCATestData.status);
				selectValueFromAjaxList(selenium,ajkEnrolledSugBox,consentsCATestData.entrolledTo);
				assertTrue(enterDate(selenium,ajkEnrolementDte,consentsCATestData.entrolledDate),"", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtEnrolmentEndDate,consentsCATestData.endDate),"", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,txtReasonConsents,consentsCATestData.reason);
			}
			 if(consentsCATestData.signedBy.equalsIgnoreCase("Substitution Decision Maker")){
				assertTrue(click(selenium,rdoSubstitutionMark),"Could not select the susbstitution maker; More Details :" + consentsCATestData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,ajkRelationship);
				selectValueFromAjaxList(selenium,ajkRelationship,consentsCATestData.relationship);
				assertTrue(type(selenium,txtFirstName,consentsCATestData.firstName),"Could not enter the first name; More Details :" + consentsCATestData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtLastName,consentsCATestData.lastName),"Could not enter last name; More Details :" + consentsCATestData.toString(), selenium, ClassName, MethodName);
			}
			 assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + consentsCATestData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
}
