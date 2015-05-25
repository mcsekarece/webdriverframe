package com.nexia.selenium.testscripts.section.demographics.patientSearch;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyLastReferral extends AbstractHomeTest {
    	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Create Medical Payers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createMedicalPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_001";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
    	
    	/*************************************************************************************************** 
	* @purpose        To Verify Create Medical And Other Payers
	* @action 	  To Verifying Create Medical Other Payers
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	  Oct 16, 2013
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
			Assert.assertNotNull(selenium,"Could Not Retrieve the New Selenium Session; More Details :" + payerData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, payerData.userName, payerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		
			//--------------------------------------------------------------------//
			//  Step-2:Search Patient //
			//--------------------------------------------------------------------//
			
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,payerData.patientId),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Payers //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(payerData.testCaseId.equals("TC_CP_001")){
				assertTrue(click(selenium,btnPatientMedicalPayers),"Could not click the Medical Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if(payerData.testCaseId.equals("TC_CP_002")){
				assertTrue(click(selenium,btnPatientOtherPayers),"Could not click the Others Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
						
			//--------------------------------------------------------------------//
			//  Step-4: Create Payers //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddNew), "Could not click New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			  	date=DateFormat1.format(cal.getTime());
		    }else {
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
			}
			
			assertTrue(addNewPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			HomeLib refData = new HomeLib();
			refData.workSheetName = "CreateReferral";
			refData.testCaseId = "TC_CRL_001";
			refData.fetchHomeTestData();
			
			assertTrue(click(selenium, lnkReferrals), "Could not click Referral link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Deleting existing Programs for the selected patient  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllReferral(selenium), "Could not delete all referrals", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-5: Create a new Referral //
			//---------------------------------------------------------- ----------//
			assertTrue(click(selenium,btnAddReferral),"Could not Click on Add Referral Button:"+ refData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createReferralWithPayer(selenium,refData,payerData),"Referral creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPatientInfoSummary),"Could not Click Patient Summary Link:"+ refData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyLastReferral(selenium,refData), 
					"List Referral information didn't get displayed", selenium, ClassName, MethodName);
			
			return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyLastReferral(Selenium selenium,HomeLib refData) throws IOException{
	    	
	    	String pName=refData.refBy;
		String[] splitStr1 = pName.split(",");
		//String[] SplitStr2 = splitStr1[1].split("\\s",4);
		System.out.println(splitStr1[0]);
		System.out.println(splitStr1[1]);	
		
		//FIXME MNT-1427
		assertTrue(getText(selenium,"//div[3]/div[2]/div/div/span[2]").toLowerCase(new java.util.Locale("en","Us")).trim().contains(splitStr1[0].toLowerCase(new java.util.Locale("en","Us")).trim()), 
				"Not able to find text " +splitStr1[0] , selenium, ClassName, MethodName);						
		
		assertTrue(getText(selenium,"//div[3]/div[2]/div/div/span[2]").toLowerCase(new java.util.Locale("en","Us")).trim().contains(splitStr1[1].toLowerCase(new java.util.Locale("en","Us")).trim()), 
				"Not able to find text " +splitStr1[1] , selenium, ClassName, MethodName);				
		
		assertTrue(getText(selenium,"//div[3]/div[2]/div/div/span").toLowerCase(new java.util.Locale("en","Us")).trim().contains(refData.referralDate.toLowerCase(new java.util.Locale("en","Us")).trim()), 
				"Not able to find text " +refData.referralDate , selenium, ClassName, MethodName);						
		
		return true;
	}
}
