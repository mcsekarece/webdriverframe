package com.nexia.selenium.testscripts.section.demographics.Programs;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.thoughtworks.selenium.Selenium;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;

public class UnitTestNewPatientCheckinPrograms extends AbstractHomeTest{
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Program is blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void programBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest programTestData = new  HomeLibUnitTest();
		programTestData.workSheetName = "UnitTest_FV_PC_Programs";
		programTestData.testCaseId = "TC_P_002";
		programTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
				
		addProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "From Date is blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void fromDateBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest programTestData = new  HomeLibUnitTest();
		programTestData.workSheetName = "UnitTest_FV_PC_Programs";
		programTestData.testCaseId = "TC_P_003";
		programTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
				
		addProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "From Date with invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void fromDateInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest programTestData = new  HomeLibUnitTest();
		programTestData.workSheetName = "UnitTest_FV_PC_Programs";
		programTestData.testCaseId = "TC_P_004";
		programTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
				
		addProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "To Date with invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void toDateInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest programTestData = new  HomeLibUnitTest();
		programTestData.workSheetName = "UnitTest_FV_PC_Programs";
		programTestData.testCaseId = "TC_P_005";
		programTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
				
		addProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Valid Data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void validData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest programTestData = new  HomeLibUnitTest();
		programTestData.workSheetName = "UnitTest_FV_PC_Programs";
		programTestData.testCaseId = "TC_P_006";
		programTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
				
		addProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "To Date Invalid Format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void toDateInvalidFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest programTestData = new  HomeLibUnitTest();
		programTestData.workSheetName = "UnitTest_FV_PC_Programs";
		programTestData.testCaseId = "TC_P_007";
		programTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
				
		addProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Prior state Max Value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void priorStateMax(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest programTestData = new  HomeLibUnitTest();
		programTestData.workSheetName = "UnitTest_FV_PC_Programs";
		programTestData.testCaseId = "TC_P_008";
		programTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
				
		addProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Outcome Max Value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void outcomeMax(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest programTestData = new  HomeLibUnitTest();
		programTestData.workSheetName = "UnitTest_FV_PC_Programs";
		programTestData.testCaseId = "TC_P_009";
		programTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
				
		addProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "From Date Invalid Format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void fromDateInvalidFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest programTestData = new  HomeLibUnitTest();
		programTestData.workSheetName = "UnitTest_FV_PC_Programs";
		programTestData.testCaseId = "TC_P_010";
		programTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
				
		addProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Referral Source With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void referralSourceWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest programTestData = new  HomeLibUnitTest();
		programTestData.workSheetName = "UnitTest_FV_PC_Programs";
		programTestData.testCaseId = "TC_P_012";
		programTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
				
		addProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Referred To With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void referredToWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest programTestData = new  HomeLibUnitTest();
		programTestData.workSheetName = "UnitTest_FV_PC_Programs";
		programTestData.testCaseId = "TC_P_013";
		programTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
				
		addProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programTestData);
	} 
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Referred Date With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void referredDateWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest programTestData = new  HomeLibUnitTest();
		programTestData.workSheetName = "UnitTest_FV_PC_Programs";
		programTestData.testCaseId = "TC_P_014";
		programTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
				
		addProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programTestData);
	} 
	
	/*************************************************************************************************** 
	* @purpose        To verify unit test from New Patient Check in Programs
	* @action 		  verify unit test from New Patient Check in Programs
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Apr 02, 2012
	***************************************************************************************************/
	public boolean addProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,HomeLibUnitTest programTestData) throws IOException{
		Selenium selenium = null;
		String alertText="";
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  step-1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + programTestData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, programTestData.userName, programTestData.userPassword);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"Could not click Error button",selenium, ClassName, MethodName);
			
			assertTrue(switchRole(selenium,programTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"Could not click Error Button",selenium, ClassName, MethodName);
			
			//Advanced search with Patient ID
			/*waitForElement(selenium, registerPatient, 6000);
			if (isElementPresent(selenium, registerPatient))*/
			searchPatientNexia(selenium,programTestData.patientID);
			waitForPageLoad(selenium);

			// Go to Programs
			click(selenium, lnkProgram);
			waitForPageLoad(selenium);
			int counter=(Integer) selenium.getXpathCount(lnkDeleteContact);			
			while(isElementPresent(selenium,"//div[@id='PatientContactList']/table/tbody/tr["+counter+"]/td[3]/div/a")){
			click(selenium,"//div[@id='PatientContactList']/table/tbody/tr["+counter+"]/td[3]/div/a");
			click(selenium,btnYesButton);
			waitForPageLoad(selenium);
			counter--;
			}
			// Select Programs Add button
			click(selenium,btnAddPrograms);
			waitForPageLoad(selenium);
			// Submit Program			
			if(!submitProgram(selenium, programTestData) && programTestData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).contains("yes")){
				if(isElementPresent(selenium,lblPara)){
					alertText = getText(selenium, lblPara);
					if(userAccount.equalsIgnoreCase(CAAccount)){
						if(alertText.toLowerCase(new java.util.Locale("en", "US")).startsWith(programTestData.alertMessageCA.trim().toLowerCase(new java.util.Locale("en", "US"))))
						{
							return returnValue;			
						}else{
							Assert.fail("An unxpected Alert is displayed with message; The Expected :"+programTestData.alertMessageCA+" ;The Actual:"+alertText + "; More Details :" + programTestData.toString());
						}
					}
					else{
						if(alertText.toLowerCase(new java.util.Locale("en", "US")).startsWith(programTestData.alertMessage.trim().toLowerCase(new java.util.Locale("en", "US"))))
						{
							return returnValue;			
						}else{
							Assert.fail("An unxpected Alert is displayed with message; The Expected :"+programTestData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + programTestData.toString());
						}
					}
				}else{
					Assert.fail("Alert is not getting displayed; More Details :" + programTestData.toString());
				}	
			}else if(programTestData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).equals("no")){
				return returnValue;
			}else{
				Assert.fail("Expected Alert is not displayed; The Expected :"+programTestData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + programTestData.toString());
			}
		}	
		catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/**
	 * submitProgram
	 * function to submit Program
	 * @throws IOException 
	 * @since  	     Apr 02, 2012
	 */
	public boolean submitProgram(Selenium selenium, HomeLibUnitTest programTestData) throws IOException{
		try{
			selectValueFromAjaxListUsingTypeKeys(selenium,ajkSuggestBox, programTestData.program);
			waitForPageLoad(selenium);
			/*selectValueFromAjaxListUsingTypeKeys(selenium,"//div[@id='department']/div/div/input", programTestData.department);
			waitForPageLoad(selenium);*/
			assertTrue(enterDate(selenium,txtFromDate, programTestData.fromdate),"Could not enter date; More Details :" + programTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtToDate,programTestData.todate),"Could not enter the date; More Details :" + programTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtPrior,programTestData.priorstate),"Could not enter the Prior State value; More Details :" + programTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtOutCome,programTestData.outcome),"Could not enter the Outcome value; More Details :" + programTestData.toString(), selenium, ClassName, MethodName);
			if(programTestData.testCaseId.equals("TC_P_012")||programTestData.testCaseId.equals("TC_P_013")||programTestData.testCaseId.equals("TC_P_014")){
				selectValueFromAjaxList(selenium,ajxReferalSource, programTestData.refFrom);
				selectValueFromAjaxList(selenium,ajxReferedTo, programTestData.referredTo);
				enterDate(selenium,txtReferralDate, programTestData.refDate);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + programTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lblPatientContactList)){
				return true;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
}

