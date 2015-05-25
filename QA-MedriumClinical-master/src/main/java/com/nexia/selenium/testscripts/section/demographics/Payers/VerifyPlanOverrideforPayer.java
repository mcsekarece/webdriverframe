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

public class VerifyPlanOverrideforPayer extends AbstractHomeTest{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Plan Override for Medical Payer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPlanOverrideforMedicalPayer(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_001";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyPlanOverrideforPayer(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Plan Override for Other Payer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPlanOverrideforOtherPayer(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_002";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyPlanOverrideforPayer(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        To Verify PlanOverride for Payer
	* @action 		  Verify PlanOverride for Payer
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 16, 2013
	***************************************************************************************************/
	
	public boolean verifyPlanOverrideforPayer(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib payerData) throws Exception{
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
			//  Step-3: Navigate to Payers //
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
			//  Step-6: Edit Payers //
			//--------------------------------------------------------------------//
			if(payerData.testCaseId.equals("TC_CP_001")){
				payerData.workSheetName = "AddPayers";
				payerData.testCaseId = "TC_CP_004";
				payerData.fetchHomeTestData();
			}else{
				payerData.workSheetName = "AddPayers";
				payerData.testCaseId = "TC_CP_003";
				payerData.fetchHomeTestData();
			}
			if(payerData.testCaseId.equals("TC_CP_004"))
			{
				assertTrue(click(selenium,btnEditMedicalPayer),"unable to click the edit button of medical payer",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			else
			{
				assertTrue(click(selenium,btnEditOtherPayer),"unable to click the edit button of medical payer",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			if(payerData.testCaseId.equals("TC_CP_004"))
			{
			assertTrue(type(selenium, txtCoPay,payerData.coPay),"Could not type the Payer's Co-Pay Amount;More details:", selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtSpecialistCoPay,payerData.specialistCoPay),"Could not type the Specialist Co Pay;More details:", selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtDeductible,payerData.deductible),"Could not type the Payer Deductible Amount;More details:", selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtCoInsurance,payerData.coInsurance),"Could not type the Payer Co-insurance Percentage;More details:", selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnlnkSave), "Could not click Save button" +  payerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			else
			{
				assertTrue(type(selenium, txtOtherCoPay,payerData.coPay),"Could not type the Payer's Co-Pay Amount;More details:", selenium, ClassName, MethodName);
				assertTrue(type(selenium, txtSpecialistotherCoPay,payerData.specialistCoPay),"Could not type the Specialist Co Pay;More details:", selenium, ClassName, MethodName);
				assertTrue(type(selenium, txtOtherDeductible,payerData.deductible),"Could not type the Payer Deductible Amount;More details:", selenium, ClassName, MethodName);
				assertTrue(type(selenium, txtOtherCoInsurance,payerData.coInsurance),"Could not type the Payer Co-insurance Percentage;More details:", selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnlnkSave), "Could not click Save button" +  payerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Edited Values //
			//--------------------------------------------------------------------//		
			assertTrue(verifyPlanOverrideValues(selenium,payerData),"Verify Plan Override Values failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

    public boolean verifyPlanOverrideValues(Selenium selenium, HomeLib payerData) throws IOException {
	waitForPageLoad(selenium);
	if(payerData.testCaseId.equals("TC_CP_004"))
    	 assertTrue(click(selenium,vfyFirstPayer),"Could not click the Expand Arrow", selenium, ClassName, MethodName);
	else
		 assertTrue(click(selenium,vfyPayerDetails),"Could not click the Expand Arrow", selenium, ClassName, MethodName);

    		waitForPageLoad(selenium);
    	    assertTrue(isTextPresent(selenium,payerData.coPay),"Could not get text", selenium, ClassName, MethodName);
    		assertTrue(isTextPresent(selenium,payerData.specialistCoPay),"Could not get text", selenium, ClassName, MethodName);
    		assertTrue(isTextPresent(selenium,payerData.deductible),"Could not get text", selenium, ClassName, MethodName);
    		assertTrue(isTextPresent(selenium,payerData.coInsurance),"Could not get text", selenium, ClassName, MethodName);
	return true;
    }		
}
