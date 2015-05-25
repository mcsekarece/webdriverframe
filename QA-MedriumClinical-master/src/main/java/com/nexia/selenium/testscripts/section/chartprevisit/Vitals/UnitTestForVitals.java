package com.nexia.selenium.testscripts.section.chartprevisit.Vitals;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForVitals extends AbstractChartPreVisit{

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Height in feet with character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHtInFeetWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_001";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Height in feet with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHtInFeetWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_002";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Height in cm or inches with  character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHtInCmOrInchesWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_003";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Height in cm or inches with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHtInCmOrInchesWithSplChara(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_004";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "weight with  character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWeightWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_005";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "weight with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWeightWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_006";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Waist with character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWaistWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_007";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Waist with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWaistWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_008";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Systolic rate with Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySystolicRateWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_009";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Systolic rate with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySystolicRateWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_010";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Diastolic rate with Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDiastolicRateWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_011";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Diastolic rate with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDiastolicRateWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_012";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Heart rate with Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHeartRateWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_013";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Heart rate with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHeartRateWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_014";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Temperature with Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTempWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_015";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Temparature with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifytempWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_016";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Blood sugar with Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBloodSugarWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_017";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Blood sugar with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBloodSugarWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_018";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Respiratory with Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRespiratoryWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_019";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Respiratory with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRespiratoryWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_020";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Oxygen saturation with Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOxyStaurationWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_021";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Oxygen saturation with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOxyStaurationWithSplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_022";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "PEFR with Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPefrWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_023";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "PEFR with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPefrWithsplChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_024";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "PEFR with special character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFillinBlooedPressure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest vitalsData = new ChartPreVisitLibUnitTest();
		vitalsData.workSheetName = "UnitTest_Vitals";
		vitalsData.testCaseId = "TC_UV_024";
		vitalsData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		unitTestForFillVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	/**
	 * unitTestForVitals
	 * Unit test for vitals
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @param vitalsData
	 * @return
	 * @since Nov 29, 2012
	 */
	public boolean unitTestForVitals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLibUnitTest vitalsData)throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + vitalsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, vitalsData.userName, vitalsData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID							  //
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,vitalsData.patientId);
			waitForPageLoad(selenium);
			//unable to add vitals in the summary page. So Update the script with the begin encounter script.
			goToBeginEncounter(selenium);
			assertTrue(click(selenium,lnkVitals),"Could not click the Vitals link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// step 3:perform unit test for various fields in  Vitaals            //
			//--------------------------------------------------------------------//
			
			assertTrue(unitTestForVitals(selenium,vitalsData),"Vitals Unit test Failed",selenium,ClassName,MethodName);
			vitalsData.validationFieldID=vitalsData.validationFieldID==null?vitalsData.validationFieldID = "" : vitalsData.validationFieldID.trim();
			
			if(!vitalsData.validationFieldID.equals("")){
			assertTrue(isElementPresent(selenium, vitalsData.validationFieldID), "The validation message field did not appear",selenium,ClassName,MethodName);
			assertTrue(getText(selenium, vitalsData.validationFieldID).contains(vitalsData.validationMessage), "The expected validation message should contain the text - "+ vitalsData.validationMessage + " The actual validation message shown - " + getText(selenium, vitalsData.validationFieldID),selenium,ClassName,MethodName);
			returnValue=true;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
	/**
	 * unitTestForFillVitals
	 * unit Test For Fill Vitals
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @param vitalsData
	 * @return
	 * @since Nov 29, 2012
	 */
	public boolean unitTestForFillVitals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLibUnitTest vitalsData)throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + vitalsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, vitalsData.userName, vitalsData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Create New patient						  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			ChartPreVisitLib vitals1Data = new ChartPreVisitLib();
			vitals1Data.workSheetName = "NewPatientCheckIn";
			vitals1Data.testCaseId = "TC_NP_001";
			vitals1Data.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,vitals1Data),"Patient Checkin Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to View patient chart					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkPatientOption),"Could not click the patient link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the patient link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//unable to add vitals in the summary page. So Update the script with the begin encounter script.
			goToBeginEncounter(selenium);
			assertTrue(click(selenium,lnkVitals),"Could not click the Vitals link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// step 3:perform unit test for various fields in  Vitals            //
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtSystolic,vitalsData.systolicRate),"Could not enter the value",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnAdd),"Could not click the add button;More details",selenium,ClassName,MethodName);
			if(isElementPresent(selenium,lblVitalspop)){
				returnValue= true;
			}else
				returnValue= false;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
}
