package com.nexia.selenium.testscripts.section.demographics.Consents;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultValuesForConsentsCAView extends AbstractHomeTest{
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "entrolled To With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void defaultEnrolledDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentCATestData = new  HomeLibUnitTest();
		consentCATestData.workSheetName = "UnitTest_FV_PC_ConsentsCAView";
		consentCATestData.testCaseId = "TC_CICA_015";
		consentCATestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		defaultEntorlledDate(seleniumHost, seleniumPort, browser, webSite, userAccount, consentCATestData);
	}
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Default End Date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void defaultEndDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest consentCATestData = new  HomeLibUnitTest();
		consentCATestData.workSheetName = "UnitTest_FV_PC_ConsentsCAView";
		consentCATestData.testCaseId = "TC_CICA_016";
		consentCATestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		defaultDate(seleniumHost, seleniumPort, browser, webSite, userAccount, consentCATestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify default values for consents
	* @action 		  Verifying default values for consents
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Approved
	* @useraccount    Both
	* @since  	      June 26, 2012
	***************************************************************************************************/
	public boolean defaultEntorlledDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLibUnitTest consentsCATestData) throws IOException{
		boolean returnValue=true;
		Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//	
			//  Step-1: Login to the Application
			//--------------------------------------------------------------------//	
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);		
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + consentsCATestData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, consentsCATestData.userName, consentsCATestData.userPassword);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID
			//--------------------------------------------------------------------//
			/*waitForElement(selenium, registerPatient, 6000);
			if (isElementPresent(selenium, registerPatient))*/
			searchPatientNexiaCA(selenium,consentsCATestData.patientID);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-3: Go to Consent
			//--------------------------------------------------------------------//	
			click(selenium, lnkConsentsPatient);
			waitForPageLoad(selenium);
			click(selenium,btnConsentsAdd);
			waitForPageLoad(selenium);
			
			String dateNow = null;
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
			dateNow = formatter.format(currentDate.getTime());
			
			
			selectValueFromAjaxList(selenium,ajkConsentsType, consentsCATestData.consentType);
			selectValueFromAjaxList(selenium,ajkConsentsName, consentsCATestData.consentName);
			assertTrue(enterDate(selenium,txtDateSigned,consentsCATestData.dateSigned),"Could not enter the start Date;More Deatils:"+consentsCATestData.toString(), selenium, ClassName, MethodName);
			if(consentsCATestData.status.equals("Enrolled")){
				 selectValueFromAjaxList(selenium,ajkEnrolementStatusSugBox,consentsCATestData.status);
				 waitForPageLoad(selenium);
				 selectValueFromAjaxList(selenium,ajkEnrolledSugBox,consentsCATestData.entrolledTo);
				 waitForPageLoad(selenium);
				 assertTrue(enterDate(selenium,ajkEnrolementDte,dateNow),"", selenium, ClassName, MethodName);
				 //assertTrue(type(selenium,"css=textarea.gwt-TextArea",consentsCATestData.comments),"Could not type the comments;More Details:"+consentsCATestData.toString());
			 }
			if(consentsCATestData.status.equals("Ended")){
				selectValueFromAjaxList(selenium,"enrolementstatussuggestBox",consentsCATestData.status);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajkEnrolledSugBox,consentsCATestData.entrolledTo);
				waitForPageLoad(selenium);
				click(selenium,ajkDateTypeSelected);
				assertTrue(enterDate(selenium,ajkEnrolementDte,dateNow),"", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtEnrolmentEndDate,dateNow),"", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,"reasonForTerminationsuggestBox",consentsCATestData.reason);
				click(selenium,ajkDateTypeSelected);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Default Values
			//--------------------------------------------------------------------//							
			assertTrue(verifyEnrolleddateValue(selenium,consentsCATestData),"Default value is incorrect; More Details :"+ consentsCATestData.toString(), selenium, ClassName, MethodName);
				return returnValue;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			
		}
		return returnValue;
	}
	
	
	public boolean defaultDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLibUnitTest consentsCATestData) throws IOException{
		boolean returnValue=true;
		Selenium selenium = null;
		try{
			//--------------------------------------------------------------------//	
			//  Step-1: Login to the Application
			//--------------------------------------------------------------------//	
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);		
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + consentsCATestData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, consentsCATestData.userName, consentsCATestData.userPassword);
			
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID
			//--------------------------------------------------------------------//
			/*waitForElement(selenium, registerPatient, 6000);
			if (isElementPresent(selenium, registerPatient))*/
			searchPatientNexia(selenium,consentsCATestData.patientID);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-3: Go to Consent
			//--------------------------------------------------------------------//
			
			String dateNow1 = null;
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
			dateNow1 = formatter.format(currentDate.getTime());
			
			click(selenium, lnkConsentsPatient);
			waitForPageLoad(selenium);
			click(selenium,btnConsentsAdd);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajkConsentsType, consentsCATestData.consentType);
			selectValueFromAjaxList(selenium,ajkConsentsName, consentsCATestData.consentName);
			assertTrue(enterDate(selenium,txtDateSigned,consentsCATestData.dateSigned),"Could not enter the start Date;More Deatils:"+consentsCATestData.toString(), selenium, ClassName, MethodName);
			if(consentsCATestData.status.equals("Enrolled")){
				 selectValueFromAjaxList(selenium,ajkEnrolementStatusSugBox,consentsCATestData.status);
				 waitForPageLoad(selenium);
				 selectValueFromAjaxList(selenium,ajkEnrolledSugBox,consentsCATestData.entrolledTo);
				 waitForPageLoad(selenium);
				 assertTrue(enterDate(selenium,ajkEnrolementDte,consentsCATestData.entrolledDate),"", selenium, ClassName, MethodName);
				 //assertTrue(type(selenium,"css=textarea.gwt-TextArea",consentsCATestData.comments),"Could not type the comments;More Details:"+consentsCATestData.toString());
			 }
			if(consentsCATestData.status.equals("Ended")){
				selectValueFromAjaxList(selenium,ajkEnrolementStatusSugBox,consentsCATestData.status);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajkEnrolledSugBox,consentsCATestData.entrolledTo);
				waitForPageLoad(selenium);
				click(selenium,ajkDateTypeSelected);
				assertTrue(enterDate(selenium,ajkEnrolementDte,dateNow1),"", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtEnrolmentEndDate,dateNow1),"", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,txtReasonConsents,consentsCATestData.reason);
				click(selenium,ajkDateTypeSelected);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Default Values
			//--------------------------------------------------------------------//							
			assertTrue(verifydateValueConsents(selenium,consentsCATestData),"Default value is incorrect; More Details :"+ consentsCATestData.toString(), selenium, ClassName, MethodName);
				return returnValue;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			
		}
		return returnValue;
	}
	
}
