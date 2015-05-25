package com.nexia.selenium.testscripts.section.demographics.Payers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEnterpriseLevelForPayerDataFields extends AbstractHomeTest{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Enterprise Level For MedicalPayer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEnterpriseLevelForMedicalPayer(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_001";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Enterprise Level For Other Payer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEnterpriseLevelForOtherPayer(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_002";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Enterprise Level For Payer Data Fields 
	* @action 		  To Verifying Enterprise Level For Payer Data Fields 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 11, 2013
	***************************************************************************************************/
	public boolean createPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib payerData) throws Exception{
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
			assertTrue(navigateToNewPatientRegistration(selenium),"unable to navigate to patient registration page",selenium,ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-2:Search Patient //
			//--------------------------------------------------------------------//
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "PatientData";
			patientData.testCaseId = "TC_NPC_001";
			patientData.fetchHomeTestData();
			assertTrue(createPatientMandatory(selenium,patientData),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String patientID=getText(selenium,lblPatientId);
			//--------------------------------------------------------------------//
			//  Step-3: Delete all Payers //
			//--------------------------------------------------------------------//
			
			
			assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(payerData.testCaseId.equals("TC_CP_001")){
				assertTrue(click(selenium,btnPatientMedicalPayers),"Could not click the Medical Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(deleteAllPayers(selenium),"Delete All Payers failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium); 
			}
			if(payerData.testCaseId.equals("TC_CP_002")){
				assertTrue(click(selenium,btnPatientOtherPayers),"Could not click the Others Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(deleteAllOtherPayers(selenium),"Unable to delete the payers",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
				
			
			//--------------------------------------------------------------------//
			//  Step-5: Create Payers //
			//--------------------------------------------------------------------//
			if(payerData.testCaseId.equals("TC_CP_002")){
				assertTrue(click(selenium,btnAddNewOtherPayer), "Could not click Edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				    }
			else{
			assertTrue(click(selenium, btnAddNew), "Could not click New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			  	date=DateFormat1.format(cal.getTime());
		    }else {
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
			}
			if(payerData.testCaseId.equals("TC_CP_001"))
			{
			assertTrue(addNewPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			}
			else
			{
				assertTrue(addNewOtherPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-6: Switch to Another Practice //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, lnkLocationHeader), "Could not click Practice Header", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			int counter=1; 
			int count = (Integer) selenium.getXpathCount("//tr/td/a/span");
			System.out.println(count);
			for (counter=1; counter<=count;counter++){
				if(getText(selenium,"//tr["+counter+"]/td/a/span").toLowerCase().contains(payerData.anotherPractice.toLowerCase())){
				assertTrue(click(selenium,"//tr["+counter+"]/td/a/span"),"could not click another practice",selenium, ClassName, MethodName);
			 	waitForPageLoad(selenium);
			 	break;
				}
			}
   			if(isElementPresent(selenium, btnErrorClose)) {   			
					assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	 				waitForPageLoad(selenium);
			}			

			assertTrue(switchRole(selenium,payerData.switchRole),"Could not switch role", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-7:Search Patient //
			//--------------------------------------------------------------------//
			
			if(payerData.testCaseId.equals("TC_CP_001")){
				payerData.workSheetName = "AddPayers";
				payerData.testCaseId = "TC_CP_004";
				payerData.fetchHomeTestData();
			}
			if(payerData.testCaseId.equals("TC_CP_002")){
				payerData.workSheetName = "AddPayers";
				payerData.testCaseId = "TC_CP_003";
				payerData.fetchHomeTestData();
			}
			assertTrue(searchPatientNexia(selenium,patientID),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Payers //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(payerData.testCaseId.equals("TC_CP_004")){
				assertTrue(click(selenium,btnPatientMedicalPayers),"Could not click the Medical Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(deleteAllPayers(selenium),"Delete All Payers failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if(payerData.testCaseId.equals("TC_CP_003")){
				assertTrue(click(selenium,btnPatientOtherPayers),"Could not click the Others Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(deleteAllOtherPayers(selenium),"Unable to delete the payers",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			if(payerData.testCaseId.equals("TC_CP_003")){
				assertTrue(click(selenium,btnAddNewOtherPayer),"Could not click the Others Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				    }
			else{
			assertTrue(click(selenium, btnAddNew), "Could not click New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-8: Create Payers //
			//--------------------------------------------------------------------//
			if(payerData.testCaseId.equals("TC_CP_003"))
			{
				assertTrue(addNewOtherPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			else
			{
			assertTrue(addNewPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			}
			//--------------------------------------------------------------------//
			//  Step-9: Verify Stored Values //
			//--------------------------------------------------------------------//
			 
			assertTrue(verifyStoredValues(selenium,payerData,userAccount),"verify Stored Values in List View failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyStoredValues(Selenium selenium,HomeLib payerData,String account) throws IOException{
		
       if(payerData.testCaseId.equals("TC_CP_003")){
			assertTrue(getText(selenium,vfyPayerDetails).contains(payerData.typeofCoverage),"Could not get text", selenium, ClassName, MethodName);
		}else{
			assertTrue(isTextPresent(selenium,payerData.payerName),"Could not get text", selenium, ClassName, MethodName);
		}
		return true;
		
	}

}
