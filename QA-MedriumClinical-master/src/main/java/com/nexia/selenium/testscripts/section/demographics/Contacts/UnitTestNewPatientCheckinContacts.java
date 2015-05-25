package com.nexia.selenium.testscripts.section.demographics.Contacts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestNewPatientCheckinContacts extends AbstractHomeTest{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Contact Type with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void contactTypeWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_001";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Contact Type with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void contactTypeWithEmergencyContact(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_0A1";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Contact Type with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void contactTypeWithGuarantor(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_0A2";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Contact Type with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void contactTypeWithGuardian(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_0A3";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Contact Type with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void contactTypeWithSubstituteDecisionMarker(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_0A4";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Contact Type with other")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void contactTypeWithOther(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_0A5";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Contact Type with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void contactTypeWithOtherEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_065";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "relationship with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void relationshipWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_002";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "relationship with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void relationshipWithInvalidValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_0A6";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "last name with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void lastNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_003";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "last name with space")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void lastNameWithSpace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_006";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "first name with numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void firstNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_007";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "first name with space")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void firstNameWithSpace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_010";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "primary phone number with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void priPhoneNumWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_015";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "secondary phone number with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void secPhoneNumWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_016";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "tertiary phone number with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void terPhoneNumWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_017";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "primary phone number with alphanumeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void priPhoneNumWithAlphanum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_018";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "secondary phone number with alphanumeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void secPhoneNumWithAlphanum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_019";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "tertiary phone number with alphanumeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void terPhoneNumWithAlphanum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_020";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "primary phone number with space")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void priPhoneNumWithSpace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_024";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "secondary phone number with space")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void secPhoneNumWithSpace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_025";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "tertiary phone number with space")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void terPhoneNumWithSpace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_026";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "primary phone number with more than maximum length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void priPhoneNumWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_027";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "secondary phone number with more than maximum length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void secPhoneNumWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_028";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "tertiary phone number with more than maximum length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void terPhoneNumWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_029";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "primary extension number with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void priExtnNumWithAlphanum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_030";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "secondary extension number with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void secExtnNumWithAlphanum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_031";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "tertiary extension number with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void terExtnNumWithAlphanum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_032";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "primary extension number with space")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void priExtnNumWithSpace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_036";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "secondary extension number with space")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void secExtnNumWithSpace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_037";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "tertiary extension number with space")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void terExtnNumWithSpace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_038";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "primary extension number with more than maximum length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void priExtnNumWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_039";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "secondary extension number with more than maximum length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void secExtnNumWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_040";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "tertiary extension number with more than maximum length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void terExtnNumWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_041";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "city name with alphanumeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void cityWithAphaNum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_046";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "zip code with alpha numeric value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void zipCodeWithAphaNum(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_049";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "zip code with more than maximum length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void zipCodeWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_052";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "email with space")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void emailWithSpace(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_054";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "email with invalid characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void emailWithInvalidFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_055";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "last name with more than maximum length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void lastNameWithMaxLength (String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_056";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "first name with more than maximum length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void firstNameWithMaxLength (String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_057";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "address1 with more than maximum length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addr1WithMaxLength (String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_058";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "address2 with more than maximum length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addr2WithMaxLength (String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_059";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "city with more than maximum length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void cityWithMaxLength (String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_060";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "email with more than maximum length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void emailWithMaxLength (String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_061";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "all valid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void fieldsWithAllValid (String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest ContactTypeTestData= new HomeLibUnitTest();
		ContactTypeTestData.workSheetName = "UnitTest_FV_PC_Contacts";
		ContactTypeTestData.testCaseId = "TC_CON_062";
		ContactTypeTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, ContactTypeTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "comments With Max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void commentsWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException, InterruptedException{
		HomeLibUnitTest caseData= new HomeLibUnitTest();
		caseData.workSheetName = "UnitTest_FV_PC_Contacts";
		caseData.testCaseId = "TC_CON_064";
		caseData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addContactType(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Unit test in Contact
	* @action 		  Verifying Unit test in Contact
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 09, 2012
	***************************************************************************************************/
	public boolean addContactType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,HomeLibUnitTest ContactTypeTestData) throws IOException{
		Selenium selenium = null;
		String alertText="";
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			// Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + ContactTypeTestData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, ContactTypeTestData.userName, ContactTypeTestData.userPassword);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"Could not click error button", selenium, ClassName, MethodName);
			
			assertTrue(switchRole(selenium,ContactTypeTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"Could not click error button", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID //
			//--------------------------------------------------------------------// 
			searchPatientNexia(selenium,ContactTypeTestData.patientID);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-4: Navigation to the next page and click on Contacts Link    //
			//--------------------------------------------------------------------// 
			assertTrue(click(selenium,lnkContactList),"Could not find Contacts Link:"+ ContactTypeTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete All exiting Contact   //
			//--------------------------------------------------------------------// 
			assertTrue(deleteAllContact(selenium),"Contact details not saved properly; More Details :"+ ContactTypeTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAddContact),"Could not Click on Add Contacts Contacts Button:"+ ContactTypeTestData.toString(), selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-6:  Enter Test Data and Submit                               //
			//--------------------------------------------------------------------//
			try {
				if(!addContact(selenium, ContactTypeTestData) && ContactTypeTestData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).contains("yes")){
					if(isElementPresent(selenium,"//p")){
						alertText = getText(selenium, "//p");
						System.out.println("Alert Text Displayed as - " + alertText);
						if(alertText.toLowerCase(new java.util.Locale("en", "US")).contains(ContactTypeTestData.alertMessage.trim().toLowerCase(new java.util.Locale("en", "US")))
								||alertText.toLowerCase(new java.util.Locale("en", "US")).contains(ContactTypeTestData.alertMessageCA.trim().toLowerCase(new java.util.Locale("en", "US")))){
							return returnValue;			
						}else{
							Assert.fail("An unexpected Alert is displayed with message; The Expected :"+ContactTypeTestData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + ContactTypeTestData.toString());
						}
					}else{
						Assert.fail("Alert is not getting displayed; The Expected :"+ContactTypeTestData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + ContactTypeTestData.toString());
					}	
				}else if(ContactTypeTestData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).equals("no")){
					return returnValue;
				}else{
					Assert.fail("Expected Alert is not displayed; The Expected :"+ContactTypeTestData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + ContactTypeTestData.toString());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ContactTypeTestData.toString());
				returnValue=false;
			}
		}	
		catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ContactTypeTestData.toString());
			returnValue=false;
		}
		return returnValue;
	}
	 
	/*************************************************************************************************** 
	* @purpose        To Add a New patient Contact
	* @action 		  Add a New patient Contact
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 23, 2010
	***************************************************************************************************/
	public boolean addContact(Selenium selenium, HomeLibUnitTest ContactTypeTestData ) throws InterruptedException, IOException{
		try{
			if(ContactTypeTestData.contactType.contains("othercheckbox")){
				assertTrue(click(selenium, ContactTypeTestData.contactType), "Could not check the contact type, " + ContactTypeTestData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,chkOtherContactType);
				assertTrue(isElementPresent(selenium,chkOtherContactType),"Could not find suggest box for entering other option", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, chkOtherContactType, ContactTypeTestData.contactType1);
			}else if(!ContactTypeTestData.contactType.contains("othercheckbox")){
				check(selenium, ContactTypeTestData.contactType);
			}
			
			selectValueFromAjaxList(selenium, ajkRelationship, ContactTypeTestData.relationship);
			selectValueFromAjaxList(selenium, ajkTitle,ContactTypeTestData.title);
			assertTrue(type(selenium, txtLastName, ContactTypeTestData.lastName),"Could not enter Last Name; More Details:" + ContactTypeTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstName, ContactTypeTestData.firstName),"Could not enter First Name; More Details:" + ContactTypeTestData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajkSuffix, ContactTypeTestData.suffix);
			assertTrue(type(selenium, txtEmail, ContactTypeTestData.email),"Could not enter Email; More Details:" + ContactTypeTestData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajkLanguage,ContactTypeTestData.languageSpoken);
			assertTrue(type(selenium, txtComments, ContactTypeTestData.comments), "Could not Enter comments, Expected value to be Selected" + ContactTypeTestData.comments, selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtContactAddr1, ContactTypeTestData.residentialAddrStreet1),"Could not enter Residential Address; More Details:" + ContactTypeTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtContactAddr2, ContactTypeTestData.residentialAddrStreet2),"Could not enter Residential Address; More Details:" + ContactTypeTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtContactCity, ContactTypeTestData.residentialAddrcity),"Could not enter City; More Details:" + ContactTypeTestData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajkContactState,ContactTypeTestData.residentialAddrstate);
			assertTrue(type(selenium, txtContactZipCode, ContactTypeTestData.residentialAddrzipCode),"Could not enter Zip; More Details:" + ContactTypeTestData.toString(), selenium, ClassName, MethodName);
			selenium.keyPress(ajkContactCountry, "\\9");
			click(selenium,btnYesButton);
			waitForPageLoad(selenium);
/*			waitForElementToEnable(selenium,txtContactAddr1);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,txtContactAddr2);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,txtContactCity);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,ajkContactState);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,ajkContactCountry);
			waitForPageLoad(selenium);*/
			selectValueFromAjaxList(selenium, ajkPrimPhone1,ContactTypeTestData.telephoneType1);
			click(selenium,ajkValueSelect1);
			assertTrue(type(selenium, txtPrimaryPhone, ContactTypeTestData.telephoneNo1),"Could not enter phone number; More Details:" + ContactTypeTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtPrimPhoneExtn, ContactTypeTestData.telephoneextnNo1),"Could not enter extn number; More Details:" + ContactTypeTestData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajkPrimPhone2,ContactTypeTestData.telephoneType2);
			click(selenium,ajkValueSelect1);
			assertTrue(type(selenium, txtSecPhone, ContactTypeTestData.telephoneNo2),"Could not enter Phone number; More Details:" + ContactTypeTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtSecPhoneExtn, ContactTypeTestData.telephoneextnNo2),"Could not enter extn number; More Details:" + ContactTypeTestData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajkPrimPhone3,ContactTypeTestData.telephoneType3);
			click(selenium,ajkValueSelect1);
			assertTrue(type(selenium, txtTertiaryPhone, ContactTypeTestData.telephoneNo3),"Could not enter Fax number; More Details:" + ContactTypeTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtTertiaryPhoneExtn, ContactTypeTestData.telephoneextnNo3),"Could not enter extn number; More Details:" + ContactTypeTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + ContactTypeTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium, lblTitle),"Could not find title", selenium, ClassName, MethodName);
				return true;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
}
