package com.nexia.selenium.testscripts.section.demographics.Cases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyReferralICDCodeInCase extends AbstractHomeTest{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Referral ICD Code In Case")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void referralICDCodeInCase(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLib refData = new HomeLib();
		refData.workSheetName = "CreateReferral";
		refData.testCaseId = "TC_CRL_002";
		refData.fetchHomeTestData();
		verifyReferralICDCodeInCCase(seleniumHost, seleniumPort, browser, webSite, userAccount, refData);
	}

	/*************************************************************************************************** 
	* @purpose        To Verifing Referral ICD Code In Case
	* @action 		  Verifing Referral ICD Code In Case
	* @author         Aspire QA
	* @throws IOException 
	* @state          Approved
	* @useraccount    Both
	* @since  	      Augest 30, 2012
	***************************************************************************************************/
	public boolean verifyReferralICDCodeInCCase(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib refData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + refData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, refData.userName, refData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role                                   	  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,refData.switchRole),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,refData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,lnkReferralList);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Deleting existing Programs for the selected patient  	  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllReferral(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			//  Step-5: Create a new Referral 									   //
			//---------------------------------------------------------- ----------//
			assertTrue(click(selenium,btnAddReferral),"Could not Click on Add Referral Button:"+ refData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createReferralWithMandatory(selenium,refData),"Referral creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			//  Step-6: Navigate to Cases 										   //
			//---------------------------------------------------------------------//
			HomeLib caseData = new HomeLib();
			caseData.workSheetName = "ICDCodeInCase";
			caseData.testCaseId = "TC_ICD_001";
			caseData.fetchHomeTestData();
			assertTrue(goToCases(selenium), "Could not navigate to Cases Page", selenium, ClassName, MethodName);
			assertTrue(deleteAllCases(selenium), "Could not delete cases", selenium, ClassName, MethodName);
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat.format(cal.getTime());
				
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
			}
			//--------------------------------------------------------------------//
			//  Step-7: Create a new case                                         //
			//--------------------------------------------------------------------//
			assertTrue(goToAddCase(selenium),"Could not Navigate to Add Cases Button : "+ caseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			select(selenium,lstReferral,caseData.referral);
			selectValueFromAjaxList(selenium,ajkCaseStatus,caseData.casesstatus);
			//assertTrue(enterDate(selenium,"terminationEndDate",caseData.terminationDate),"Could not enter the date");
			assertTrue(enterDate(selenium,txtStartDate,date),"Could not enter the date", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click save button:"+ caseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkEdit),"Could not click edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-8: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			
			/*assertTrue(verifyICDCode(selenium,caseData),"Referral details not saved properly; More Details :"+ refData.toString(), selenium, ClassName, MethodName);
				return returnValue;*/
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyICDCode(Selenium selenium,HomeLib caseData) throws IOException{
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium,"referralList"),"",selenium,ClassName,MethodName);
		selenium.getSelectedValues("referralList");
		System.out.println(selenium.getSelectedValues("referralList"));
		System.out.println(getValue(selenium,"referralList"));
		
        assertTrue(getValue(selenium,"referralList").toLowerCase(new java.util.Locale("en","Us")).trim().contains(caseData.referral.trim().toLowerCase(new java.util.Locale("en","Us"))),"Referal list not present", selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,"//div[8]/div/div/span").contains(caseData.referralDate),"Date not present", selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,"//div[9]/div/div/span").contains(caseData.icdcode),"Date not present", selenium, ClassName, MethodName);
	
		return true;
		}
}
