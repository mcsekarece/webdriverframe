package com.nexia.selenium.testscripts.section.demographics.Programs;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import java.util.Calendar;
import org.testng.annotations.Test;
import com.thoughtworks.selenium.Selenium;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;

public class VerifyDefaultValueForPrograms extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Default Value For Programs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void todateDefault(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest programTestData = new  HomeLibUnitTest();
		programTestData.workSheetName = "UnitTest_FV_PC_Programs";
		programTestData.testCaseId = "TC_P_011";
		programTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programTestData);
	} 
	
	/*************************************************************************************************** 
	* @purpose        To verify Default Value For Programs
	* @action 		  verify Default Value For Programs
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Apr 02, 2012
	***************************************************************************************************/
	public boolean addProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLibUnitTest programTestData) throws IOException{

		boolean returnValue=true;
		Selenium selenium = null;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);		
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + programTestData.toString());
			loginForNexiaFromPublicSite(selenium,userAccount, programTestData.userName, programTestData.userPassword);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,programTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//Advanced search with Patient ID
			/*waitForElement(selenium, registerPatient, 6000);
			if (isElementPresent(selenium, registerPatient))*/
			searchPatientNexia(selenium,programTestData.patientID);
			waitForPageLoad(selenium);
						
			// Go to Programs
			click(selenium, lnkProgram);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllPrograms(selenium), "Could not delete all programs", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Select Programs Add button
			click(selenium,btnAddPrograms);
			waitForPageLoad(selenium);
											
			if(!verifyStoredValues(selenium,programTestData, userAccount)){
				Assert.fail("Default value is incorrect; More Details :"+ programTestData.toString());
				returnValue=false;
			}			else
				return returnValue;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium, HomeLibUnitTest programTestData, String userAccount) throws IOException{
		Calendar currentDateCA = Calendar.getInstance();
		SimpleDateFormat formatterCA =new SimpleDateFormat("dd/MM/yyyy");
		String dateNowCA = formatterCA.format(currentDateCA.getTime());
		
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
		String dateNow = formatter.format(currentDate.getTime());
		
		if(userAccount.equalsIgnoreCase(CAAccount)){
			assertTrue(getValue(selenium,txtFromDate).trim().equalsIgnoreCase(dateNowCA.trim()),"could not From date",selenium,ClassName,MethodName);
		}
		else{
			assertTrue(getValue(selenium,txtFromDate).trim().equalsIgnoreCase(dateNow.trim()),"could not get from date",selenium,ClassName,MethodName);
		}	
				
		return true;
	}
}
