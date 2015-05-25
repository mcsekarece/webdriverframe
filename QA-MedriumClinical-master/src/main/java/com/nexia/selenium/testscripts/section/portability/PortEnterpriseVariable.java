package com.nexia.selenium.testscripts.section.portability;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class PortEnterpriseVariable extends AbstractHomeTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Create enterprise variable for notes")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createEVForNotes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib epData = new  HomeLib();
		epData.workSheetName = "EnterpriseVariables";
		epData.testCaseId = "TC_AdNo_001";
		epData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createEV(seleniumHost, seleniumPort, browser, webSite, userAccount, epData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Create enterprise variable for socio economics")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createEVForSocioEconomics(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib epData = new  HomeLib();
		epData.workSheetName = "EnterpriseVariables";
		epData.testCaseId = "TC_AdNo_002";
		epData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createEV(seleniumHost, seleniumPort, browser, webSite, userAccount, epData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Create enterprise variable for Health Care Team")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createEVForHealthCareTeam1(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib epData = new  HomeLib();
		epData.workSheetName = "EnterpriseVariables";
		epData.testCaseId = "TC_AdNo_003";
		epData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createEV(seleniumHost, seleniumPort, browser, webSite, userAccount, epData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Create enterprise variable for Consents")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createEVForConsents(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib epData = new  HomeLib();
		epData.workSheetName = "EnterpriseVariables";
		epData.testCaseId = "TC_AdNo_004";
		epData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createEV(seleniumHost, seleniumPort, browser, webSite, userAccount, epData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Create enterprise variable for Health Care Team reason for delettion")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createEVForHealthCareTeam2(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib epData = new  HomeLib();
		epData.workSheetName = "EnterpriseVariables";
		epData.testCaseId = "TC_AdNo_005";
		epData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createEV(seleniumHost, seleniumPort, browser, webSite, userAccount, epData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Create enterprise variable for Health Care Team reason for delettion")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createEVForHealthCareTeam3(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib epData = new  HomeLib();
		epData.workSheetName = "EnterpriseVariables";
		epData.testCaseId = "TC_AdNo_006";
		epData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createEV(seleniumHost, seleniumPort, browser, webSite, userAccount, epData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Create enterprise variable for Health Care Team reason for delettion")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createEVForAddressBook1(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib epData = new  HomeLib();
		epData.workSheetName = "EnterpriseVariables";
		epData.testCaseId = "TC_AdNo_007";
		epData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createEV(seleniumHost, seleniumPort, browser, webSite, userAccount, epData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Create enterprise variable for Health Care Team reason for delettion")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createEVForAddressBook2(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib epData = new  HomeLib();
		epData.workSheetName = "EnterpriseVariables";
		epData.testCaseId = "TC_AdNo_008";
		epData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createEV(seleniumHost, seleniumPort, browser, webSite, userAccount, epData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Create enterprise variable for Referal speciality")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createEVForReferalSpeciality(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib epData = new  HomeLib();
		epData.workSheetName = "EnterpriseVariables";
		epData.testCaseId = "TC_AdNo_009";
		epData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createEV(seleniumHost, seleniumPort, browser, webSite, userAccount, epData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Create enterprise variable for Referal speciality")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createEnterpriseVariableForPatientInactivation1(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib epData = new  HomeLib();
		epData.workSheetName = "EnterpriseVariables";
		epData.testCaseId = "TC_AdNo_010";
		epData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createEV(seleniumHost, seleniumPort, browser, webSite, userAccount, epData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Create enterprise variable for Referal speciality")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createEnterpriseVariableForPatientInactivation2(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib epData = new  HomeLib();
		epData.workSheetName = "EnterpriseVariables";
		epData.testCaseId = "TC_AdNo_011";
		epData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createEV(seleniumHost, seleniumPort, browser, webSite, userAccount, epData);
	}
	public boolean createEV(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib epData) throws Exception{
		boolean returnValue=true;
		Selenium selenium = null;
	try{
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + epData.toString());
		assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, epData.userName, epData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-2:Change Switch Role  										  //
		//--------------------------------------------------------------------//
		assertTrue(switchRole(selenium,epData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	
		assertTrue(click(selenium,lnkQuickActions),"Could not click on the quick action link",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkShowMoreLink),"Could not click on the show more action link" ,selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkShowMoreLink),"Could not click show more link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkSystemSettingAction),"Could not click system setting", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-3:Check whether the enterprise variable is already exists    //
		//--------------------------------------------------------------------//
		
		assertTrue(click(selenium,lnkEnterpriseVariable),"Could not click on Identifier Group link:" + epData .toString(),selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtSearchBox ,epData.variableValue),"Could not enter the variable type",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnSearchBox),"Could not click on Search button:" + epData .toString(),selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		int rowCount=(Integer) selenium.getXpathCount("//div[@id='EnterpriseIDList']/table/tbody/tr/td[1]");
		Boolean flag=false;
		for(int count=1;count<=rowCount;count++){
		if(((getText(selenium,"//div[@id='EnterpriseIDList']/table/tbody/tr["+count+"]/td").trim().contains(epData.variableType.trim()))
				&& (getText(selenium,"//div[@id='EnterpriseIDList']/table/tbody/tr["+count+"]/td[2]").trim().contains(epData.variableValue.trim())))){
			flag=true;
			break;
		}
		}
			//Create Enter prise Variabble
		if(flag==false)
			assertTrue(createEnterpriseVariable(selenium,epData),"Could not created",selenium,ClassName,MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-4:Verify Store Value    //
		//--------------------------------------------------------------------//

		if(!verifyStoreValue(selenium,epData)){
			Assert.fail("Details are not stored properly");
		}
	
	}catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)",selenium,ClassName,MethodName);
	}
		return returnValue;
	}
	
	public boolean createEnterpriseVariable(Selenium selenium,  HomeLib epData) throws IOException{
		assertTrue(click(selenium,btnEnterpriseAdd),"Could not click on Add Identifier Group link:" + epData.toString(),selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium,ajkVariableType,epData.variableType);
		type(selenium,txtVariableValue,epData.variableValue);
		click(selenium,btnSave);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,ajkVariableType)){
			Assert.fail("Creation failed");
		}
		return true;
	}
	
	public boolean verifyStoreValue(Selenium selenium, HomeLib epData) throws IOException{
		assertTrue(type(selenium,txtSearchBox ,epData.variableValue),"Could not enter the variable type",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnSearchBox),"Could not click on Search button:" + epData .toString(),selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		int rowCount=(Integer) selenium.getXpathCount("//div[@id='EnterpriseIDList']/table/tbody/tr/td[1]");
		for(int count=1;count<=rowCount;count++){
		if(((getText(selenium,"//div[@id='EnterpriseIDList']/table/tbody/tr["+count+"]/td").trim().contains(epData.variableType.trim()))
				&& (getText(selenium,"//div[@id='EnterpriseIDList']/table/tbody/tr["+count+"]/td[2]").trim().contains(epData.variableValue.trim())))){
			return true;
		}
		}
//		if(!getText(selenium,"//div[@id='EnterpriseIDList']/table/tbody/tr/td").trim().contains(epData.variableType.trim())){
//			return false;
//		}
//		if(!getText(selenium,"//div[@id='EnterpriseIDList']/table/tbody/tr/td[2]").trim().contains(epData.variableValue.trim())){
//			return false;
//		}
		return false;
	}
}
