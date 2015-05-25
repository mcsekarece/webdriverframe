package com.nexia.selenium.testscripts.section.chartprevisit.FamilyHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForFamilyHistory extends AbstractChartPreVisit{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Medical Condition With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicalConditionWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest historyData = new ChartPreVisitLibUnitTest();
		historyData.workSheetName = "UnitTest_History";
		historyData.testCaseId = "TC_FM_001";
		historyData.fetchHomeTestData();
		unitTestHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyAgeOfWithCharater")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAgeOfWithCharater(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest historyData = new ChartPreVisitLibUnitTest();
		historyData.workSheetName = "UnitTest_History";
		historyData.testCaseId = "TC_FM_002";
		historyData.fetchHomeTestData();
		unitTestHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyAgeOfWithMaxminumNumber")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAgeOfWithMaxminumNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest historyData = new ChartPreVisitLibUnitTest();
		historyData.workSheetName = "UnitTest_History";
		historyData.testCaseId = "TC_FM_003";
		historyData.fetchHomeTestData();
		unitTestHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyAgeOfWithSpecialChar")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAgeOfWithSpecialChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest historyData = new ChartPreVisitLibUnitTest();
		historyData.workSheetName = "UnitTest_History";
		historyData.testCaseId = "TC_FM_004";
		historyData.fetchHomeTestData();
		unitTestHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyAgeOfWithAlphaNumeri")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAgeOfWithAlphaNumeri(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest historyData = new ChartPreVisitLibUnitTest();
		historyData.workSheetName = "UnitTest_History";
		historyData.testCaseId = "TC_FM_005";
		historyData.fetchHomeTestData();
		unitTestHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyAgeOfWithAlphaNumeri")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAgeAtDeathWithChartacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest historyData = new ChartPreVisitLibUnitTest();
		historyData.workSheetName = "UnitTest_History";
		historyData.testCaseId = "TC_FM_006";
		historyData.fetchHomeTestData();
		unitTestHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyAgeOfWithAlphaNumeri")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAgeAtDeathWithSepecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest historyData = new ChartPreVisitLibUnitTest();
		historyData.workSheetName = "UnitTest_History";
		historyData.testCaseId = "TC_FM_007";
		historyData.fetchHomeTestData();
		unitTestHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyAgeAtDeathWithAlphaNumeri")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAgeAtDeathWithAlphaNumeri(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest historyData = new ChartPreVisitLibUnitTest();
		historyData.workSheetName = "UnitTest_History";
		historyData.testCaseId = "TC_FM_008";
		historyData.fetchHomeTestData();
		unitTestHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyTreatmentWithMaxmiumCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTreatmentWithMaxmiumCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest historyData = new ChartPreVisitLibUnitTest();
		historyData.workSheetName = "UnitTest_History";
		historyData.testCaseId = "TC_FM_009";
		historyData.fetchHomeTestData();
		unitTestHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyTreatmentWithMinmumLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTreatmentWithMinmumLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest historyData = new ChartPreVisitLibUnitTest();
		historyData.workSheetName = "UnitTest_History";
		historyData.testCaseId = "TC_FM_010";
		historyData.fetchHomeTestData();
		unitTestHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyTreatmentWithMaxmiumCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCommentWithMaxmiumCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest historyData = new ChartPreVisitLibUnitTest();
		historyData.workSheetName = "UnitTest_History";
		historyData.testCaseId = "TC_FM_011";
		historyData.fetchHomeTestData();
		unitTestHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	} 
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "verifyCommentWithMinmumLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCommentWithMinmumLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLibUnitTest historyData = new ChartPreVisitLibUnitTest();
		historyData.workSheetName = "UnitTest_History";
		historyData.testCaseId = "TC_FM_012";
		historyData.fetchHomeTestData();
		unitTestHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	} 
	
	public boolean unitTestHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLibUnitTest historyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String data;
		int count;
		int count1;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + historyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,historyData.patientID);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			// step 3:perform unit test for various fields in  Immunization//
			//--------------------------------------------------------------------//
			if(historyData.maxLength.equals("")){
				assertTrue(unitTestForFamilyHistory(selenium, historyData),"failed", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium, historyData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
				assertTrue(getText(selenium, historyData.validationFieldID).contains(historyData.validationMessage), "The expected validation message should contain the text - "+ historyData.validationMessage + " The actual validation message shown - " + getText(selenium, historyData.validationFieldID), selenium, ClassName, MethodName);
				returnValue=true;
			}else{
				if(historyData.test.contains("MaxLength")){
					assertTrue(familyHistoryUnitTestForMaxLength(selenium,historyData),"", selenium, ClassName, MethodName);
					data=getValue(selenium,historyData.validationFieldID);
					count=data.length();
					waitForPageLoad(selenium);
					count1=Integer.parseInt(historyData.maxLength);
					waitForPageLoad(selenium);
					if(count>count1)
						returnValue=false;
					else if(count==count1)
						returnValue=true;
					waitForPageLoad(selenium);
				}
				else if(historyData.test.contains("MinLength")||historyData.test.contains("ExactLength")){
					assertTrue(prescribeMedicationUnitTest(selenium,historyData),"", selenium, ClassName, MethodName);
					if(isElementPresent(selenium,btnEdit))
						returnValue=true;
					else
						returnValue=false;
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
