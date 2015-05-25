package com.nexia.selenium.testscripts.section.demographics.Cases;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class EditNewPatientCheckinCases extends AbstractHomeTest{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing patient Case")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editNewPatientCheckinCases(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLib casesData = new HomeLib();
		casesData.workSheetName = "NewCases";
		casesData.testCaseId = "TC_NC_005";
		casesData.fetchHomeTestData();
		editCases(seleniumHost, seleniumPort, browser, webSite, userAccount, casesData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Editing patient Case
	* @action 		  Editing patient Case
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      April 09, 2012
	***************************************************************************************************/
	public boolean editCases(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib casesData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		String date=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + casesData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, casesData.userName, casesData.userPassword),"Login Failed", selenium, ClassName, MethodName);
		
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role                                   	  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,casesData.switchRole),"Could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium); 
			
			searchPatientNexia(selenium,casesData.patientID);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Cases and deleting existing Cases             //
			//--------------------------------------------------------------------//
			assertTrue(goToCases(selenium), "Could not navigate to Cases Page", selenium, ClassName, MethodName);
			assertTrue(deleteAllCases(selenium), "Could not delete cases", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create a new case                                         //
			//--------------------------------------------------------------------//
			assertTrue(goToAddCase(selenium),"Could not Navigate to Add Cases Button : "+ casesData.toString(), selenium, ClassName, MethodName);
			assertTrue(createCases(selenium,casesData,userAccount),"Cases creation Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5:Edit patient Cases                                         //
			//--------------------------------------------------------------------//
			click(selenium,lnkEdit);
			waitForPageLoad(selenium);
				
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat.format(cal.getTime());
				
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
				
				}
			
			
			casesData.workSheetName = "EditCases";
			casesData.testCaseId = "TC_EC_001";
			casesData.fetchHomeTestData();
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtDescription,casesData.description),"Could not type patient cases; More Detils"+casesData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajkProgram, casesData.program);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtReason,casesData.reason),"Could not enter Reason ; More Details :"+casesData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,lstReferral,casesData.referral);
			//assertTrue(type(selenium,"icdCode",casesData.icecode),"Could not icecode; More Details :" + casesData.toString());
			assertTrue(enterDate(selenium,txtStartDate,date),"Could not enter the date; More Details :" + casesData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajkCaseStatus,casesData.casesstatus);
			assertTrue(enterDate(selenium,txtTerminationDateEdit,date),"Could not enter the date; More Details :" + casesData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtTerminationReasonEdit,casesData.terminationReason),"Could not enter the Reason ; More Details :"+casesData.toString(), selenium, ClassName, MethodName);
			//click(selenium,"addCaseDates");
			if (isElementPresent(selenium, txtDateType)){
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,txtDateType, casesData.datetype1);
				waitForPageLoad(selenium);
				assertTrue(enterDate(selenium,txtDate,date),"Could not enter the date; More Details :" + casesData.toString(), selenium, ClassName, MethodName);
			}assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + casesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,lnkEdit);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-6: Verifying Entered Details are saved properly  			  //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValuesEditCase(selenium,casesData,date),"Cases details not saved properly; More Details :"+ casesData.toString(), selenium, ClassName, MethodName);
				return returnValue;
		}
		catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
