package com.nexia.selenium.testscripts.section.chartprevisit.MedWarnings;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForMedWarnings extends AbstractChartPreVisit{
	@Test(groups ={"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify override reason with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOverrideReasonWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_MedWarnings";
		medicationTestData.testCaseId = "TC_UTMW_001";
		medicationTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestMedWarnings(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verify override reason with max length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOverrideReasonWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLibUnitTest medicationTestData = new  ChartPreVisitLibUnitTest();
		medicationTestData.workSheetName = "UnitTest_MedWarnings";
		medicationTestData.testCaseId = "TC_UTMW_002";
		medicationTestData.fetchHomeTestData();	
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestMedWarnings(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationTestData);
	} 
	/**
	 * unitTestMedWarnings
	 * Function to perform unit tests on med warnings 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 14, 2012
	 */
	public boolean unitTestMedWarnings(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLibUnitTest prescribeData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(SearchPrescribeMedUnit(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(prescribeData.test.equalsIgnoreCase("Reason with Empty")){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type override reason ;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				prescribeData.validationFieldID = prescribeData.validationFieldID == null ? prescribeData.validationFieldID = "" : prescribeData.validationFieldID.trim();
				if(!(prescribeData.validationFieldID.equals(""))){
				assertTrue(isElementPresent(selenium, prescribeData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
				assertTrue(getText(selenium, prescribeData.validationFieldID).contains(prescribeData.validationMessage), "The expected validation message should contain the text - "+ prescribeData.validationMessage + " The actual validation message shown - " + getText(selenium, prescribeData.validationFieldID), selenium, ClassName, MethodName);
				returnValue=true;
				}
			}else{
				if(prescribeData.test.equalsIgnoreCase("Reason For Max Length")){
					assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type override reason ;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
					selenium.typeKeys(txtOverride3, "Extra String");
					waitForPageLoad(selenium);
					
					prescribeData.validationFieldID = prescribeData.validationFieldID == null ? prescribeData.validationFieldID = "" : prescribeData.validationFieldID.trim();
					if(!(prescribeData.validationFieldID.equals(""))){
					assertTrue(isElementPresent(selenium, prescribeData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
					assertTrue(getText(selenium, prescribeData.validationFieldID).contains(prescribeData.validationMessage), "The expected validation message should contain the text - "+ prescribeData.validationMessage + " The actual validation message shown - " + getText(selenium, prescribeData.validationFieldID), selenium, ClassName, MethodName);
					returnValue=true;
					}
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			returnValue=false;
		}
		return returnValue;
	}
}
