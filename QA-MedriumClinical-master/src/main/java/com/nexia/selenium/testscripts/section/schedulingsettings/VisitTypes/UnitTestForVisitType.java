package com.nexia.selenium.testscripts.section.schedulingsettings.VisitTypes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingUnitTestLib;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForVisitType extends AbstractSchedulingTest{

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Visit name with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void vistNameWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT001";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "duration name with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void durationWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT002";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "duration With Characte")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void durationWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT003";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "duration With Less Then Five")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void durationWithLessThenFive(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT004";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "uration With Greater Then Five")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void durationWithGreaterThenFive(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT005";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "duration With Special Charater")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void durationWithSpecialCharater(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT006";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "duration With Decimal Value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void durationWithDecimalValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT007";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "cannot Repeat With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void cannotRepeatWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT008";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "cannot Repeat With SpecialCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void cannotRepeatWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT009";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "cannot Repeat With DecimalValue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void cannotRepeatWithDecimalValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT010";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "multiple Booking With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void multipleBookingWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT011";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "multiple Booking With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void multipleBookingWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT012";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "multiple Booking With Decimal value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void multipleBookingWithDecimalValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT013";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "followup With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void followupWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT014";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "followup With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void followupWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT015";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "followup With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void followupWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT016";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "followup With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void followupWithdecimalValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT017";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "followupTime With empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void followupTimeWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT018";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "confirmVisit With empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void confirmVisitWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT019";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "confirmVisit With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void confirmVisitWithcharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT020";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "confirmVisit With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void confirmVisitWithSpecialcharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT021";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "confirmVisit With decimal Value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void confirmVisitWithDecimalValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT022";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "multiple Booking With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void multipleBookingWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT023";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "TicketNo - #6873")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void visitTypeWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingUnitTestLib visitType = new SchedulingUnitTestLib();
		visitType.workSheetName = "UnitTest_VisitType";
		visitType.testCaseId = "TC_UVT024";
		visitType.fetchSchedulingSettingsTestData();
		addVisitType(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify unit test for Visit Type 
	* @action 		  verifying unit test for Visit Type 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Completed
	* @useraccount    Both
	* @since  	      Jun 06, 2013
	***************************************************************************************************/
	
	public boolean addVisitType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingUnitTestLib visitType) throws IOException{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			// Step-1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + visitType.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, visitType.userName, visitType.userPassword),"Login Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,visitType.switchRole),"Could not the Switch Role",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Naviagte to Scheduling section							//
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Could not Navigate to Scheduling section",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Uint test for Scheduling section							//
			//--------------------------------------------------------------------//
			
			assertTrue(unit_VisitType(selenium,visitType),"Visist type Failed",selenium, ClassName, MethodName);
			
			if(visitType.testCaseId.equals("TC_UVT024")){
				if(selenium.isTextPresent("Visit Type Name can only contain alphanumeric characters")){
                    Assert.fail("Verify VisitType With Special Characters ");					
				}else{
					return true;
				}
			}
			visitType.validationFieldID = visitType.validationFieldID == null ? visitType.validationFieldID ="" : visitType.validationFieldID.trim();
			if(!visitType.validationFieldID.equals("")){
				assertTrue(isElementPresent(selenium, visitType.validationFieldID), "The validation message field did not appear",selenium, ClassName, MethodName);
				assertTrue(getText(selenium, visitType.validationFieldID).contains(visitType.validationMessage), "The expected validation message should contain the text - "+ visitType.validationMessage + " The actual validation message shown - " + getText(selenium, visitType.validationFieldID),selenium, ClassName, MethodName);
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + visitType.toString(), selenium, ClassName, MethodName);
		}
		return false;
	}
	
}
