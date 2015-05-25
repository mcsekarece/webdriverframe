package com.nexia.selenium.testscripts.section.demographics.Referral;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class CreateNewPatientCheckinReferral extends AbstractHomeTest {
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default"}, description = "Test for Adding a New patient Referral")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewReferral(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib refData = new HomeLib();
		refData.workSheetName = "CreateReferral";
		refData.testCaseId = "TC_CRL_001";
		refData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createNewReferral(seleniumHost, seleniumPort, browser, webSite, userAccount, refData);
	}
	@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default"}, description = "Test for Adding a New patient Referral")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewReferralWithMandatory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib refData = new HomeLib();
		refData.workSheetName = "CreateReferral";
		refData.testCaseId = "TC_CRL_002";
		refData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createNewReferralWithMandatoryFields(seleniumHost, seleniumPort, browser, webSite, userAccount, refData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Create New Patient Checkin Referral
	* @action 		  verifying Create New Patient Checkin Referral
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 07, 2012
	***************************************************************************************************/
	public boolean createNewReferral(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib refData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		String date1 = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + refData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, refData.userName, refData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,refData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,refData.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Deleting existing Programs for the selected patient  //
			//--------------------------------------------------------------------//
			click(selenium,lnkReferrals);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllReferral(selenium), "Could not delete all referals", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-5: Create a new Referral //
			//---------------------------------------------------------- ----------//
			assertTrue(click(selenium,btnAddReferral),"Could not Click on Add Referral Button:"+ refData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createReferral(selenium,refData),"Referral creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			String date=DateFormat.format(cal.getTime());
			DateFormat=new SimpleDateFormat("HH");
			String time=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkExpandAll),"Could not click Expand All; More Details :" + refData.toString(), selenium, ClassName, MethodName);
			assertTrue(verifyTimeStamp(selenium, lblTimeStampReferral, date, time),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,lnkEditReferral);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesReferrals(selenium,refData)){
				Assert.fail("Referral details not saved properly; More Details :"+ refData.toString());
			
			}else
				return returnValue;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Create New Patient Checkin Referral
	* @action 		  verifying Create New Patient Checkin Referral
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 07, 2012
	***************************************************************************************************/
	public boolean createNewReferralWithMandatoryFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib refData) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + refData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, refData.userName, refData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,refData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,refData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,lnkReferrals);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Deleting existing Programs for the selected patient  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllReferral(selenium), "Could not delete all referals", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-5: Create a new Referral //
			//---------------------------------------------------------- ----------//
			assertTrue(click(selenium,btnAddReferral),"Could not Click on Add Referral Button:"+ refData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createReferralWithMandatory(selenium,refData),"Referral creation Failed", selenium, ClassName, MethodName);
			
			click(selenium,lnkEditReferral);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesForMandatoryReferrals(selenium,refData,userAccount)){
				Assert.fail("Referral details not saved properly; More Details :"+ refData.toString());
				returnValue=false;
			}else
				return returnValue;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}

