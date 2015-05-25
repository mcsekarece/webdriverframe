package com.nexia.selenium.testscripts.section.demographics.Referral;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPayerDetailsInReferral extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Create Medical Payers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createMedicalPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_016";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Create Medical And Other Payers
	* @action 		  To Verifying Create Medical Other Payers
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both
	* @defect 		  #7047
	* @since  	      Sep 16, 2013
	***************************************************************************************************/
	
	public boolean createPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib payerData) throws IOException{
		Selenium selenium=null;
		String date =null;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + payerData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, payerData.userName, payerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role                                         //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,payerData.switchRole),"Could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Search Patient //
			//--------------------------------------------------------------------//
			
			assertTrue(searchPatientNexia(selenium,payerData.patientId),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Payers //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnPatientMedicalPayers),"Could not click the Medical Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Payers //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllPayers(selenium),"Delete All Payers failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium); 	
			
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Create Payers //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddNew), "Could not click New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			  	date=DateFormat1.format(cal.getTime());
			  	//ndDate =DateFormat1.format(cal.getTime());
			  	cal.add(Calendar.DATE,-1);
			  	date=DateFormat1.format(cal.getTime());
		    }else {
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
					cal.add(Calendar.DATE,-1);
					date=DateFormat1.format(cal.getTime());
			}
			assertTrue(addNewPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-6: Deleting existing Programs for the selected patient  //
			//--------------------------------------------------------------------//
			click(selenium,lnkReferrals);
			waitForPageLoad(selenium);
			
			HomeLib refData = new HomeLib();
			refData.workSheetName = "CreateReferral";
			refData.testCaseId = "TC_CRL_002";
			refData.fetchHomeTestData();
			
			refData.payer = payerData.payerName;
			assertTrue(deleteAllReferral(selenium), "Could not delete all referals", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-7: Create a new Referral //
			//---------------------------------------------------------- ----------//
			assertTrue(click(selenium,btnAddReferral),"Could not Click on Add Referral Button:"+ refData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createReferral(selenium,refData),"Referral creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			click(selenium,lnkEditReferral);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesReferrals(selenium,refData)){
				Assert.fail("Referral details not saved properly; More Details :"+ refData.toString());
			}else
				return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
