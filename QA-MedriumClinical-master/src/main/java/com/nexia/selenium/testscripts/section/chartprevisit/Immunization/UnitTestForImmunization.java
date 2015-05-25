package com.nexia.selenium.testscripts.section.chartprevisit.Immunization;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForImmunization extends AbstractChartPreVisit{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Vaccine With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyVaccineWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_001";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "ExpiryDate With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExpiryDateWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_002";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "ExpiryDate With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExpiryDateWithDifferentFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_003";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "ExpiryDate With Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExpiryDateWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_004";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "ExpiryDate With Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExpiryDateWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_005";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "AdminOn With Future Date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdminOnWithFutureDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_006";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Admin on With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdminOnWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_007";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Admin on With Different Format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdminOnWithDifferentFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_008";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "AdminOn With Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdminOnWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_009";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Admin on With Special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdminOnWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_010";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Series With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySeriesWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_011";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifySeriesWithLessThanSeriesof")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySeriesWithLessThanSeriesof(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_012";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "ImmunizationWithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyImmunizationWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_013";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Refused With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefusedDateWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_014";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Refused Date with Different Format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefusedDateWithDifferentFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_015";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Refused Date with Invalid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefusedDateWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_016";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Refused Date with Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRefusedDateWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_017";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "AdministeredOnWithBlank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdministeredonWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_018";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "AdministeredOnWithDifferentFormat")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdministeredonWithDifferentFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_019";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "AdministeredOnWithInvalidDate")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdministeredonWithInvalidDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_020";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "AdministeredOnWithNumber")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAdministeredonWithNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_021";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "DosagewithCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDosagewithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_022";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "DosagewithSpecialCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDosagewithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest immunizationData = new ChartPreVisitLibUnitTest();
		immunizationData.workSheetName = "UnitTest_Immunization";
		immunizationData.testCaseId = "TC_IMM_023";
		immunizationData.fetchHomeTestData(); 
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		unitTestImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	/**
	 * unitTestImmunization
	 * function to unit Test Immunization
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 04, 2012
	 */
	
	public boolean unitTestImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLibUnitTest immunizationData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + immunizationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, immunizationData.userName, immunizationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,immunizationData.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// step 3:perform unit test for various fields in  Immunization//
			//--------------------------------------------------------------------//
			assertTrue(unitTestForImmunization(selenium,immunizationData,userAccount),"Injection Failed", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium, immunizationData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, immunizationData.validationFieldID).contains(immunizationData.validationMessage), "The expected validation message should contain the text - "+ immunizationData.validationMessage + " The actual validation message shown - " + getText(selenium, immunizationData.validationFieldID), selenium, ClassName, MethodName);
			returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
