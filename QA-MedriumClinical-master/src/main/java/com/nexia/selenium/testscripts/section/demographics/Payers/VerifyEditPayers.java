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

public class VerifyEditPayers extends AbstractHomeTest{

	
	@Test(groups = {"Smoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Edit Medical Payers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditMedicalPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_001";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Edit Other Payers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyEditOtherPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_002";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Edit Cancel For Payers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyEditCancelForPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_014";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        To Verify Edit Medical And Other Payers
	* @action 		  Edit Medical And Other Payers
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 20, 2013
	***************************************************************************************************/
	
	public boolean editPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib payerData) throws Exception{
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
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			  	date=DateFormat1.format(cal.getTime());
		    }else {
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
			}
			if(payerData.testCaseId.equals("TC_CP_001")){
				assertTrue(click(selenium,btnPatientMedicalPayers),"Could not click the Medical Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(deleteAllPayers(selenium),"Delete All Payers failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium); 
				assertTrue(click(selenium,btnAddNew),"Could not click on addnew Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(addNewPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if(payerData.testCaseId.equals("TC_CP_002")||payerData.testCaseId.equals("TC_CP_014")){
				assertTrue(click(selenium,btnPatientOtherPayers),"Could not click the Others Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(deleteAllOtherPayers(selenium),"Unable to delete the payers",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnAddNewOtherPayer),"Could not click the Others Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(addNewOtherPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-6: Edit Payers //
			//--------------------------------------------------------------------//
		 
			if(payerData.testCaseId.equals("TC_CP_014")){
			    assertTrue(click(selenium,btnEditOther), "Could not click Edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnlnkCancel), "Could not click Cancel button ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(isElementPresent(selenium,btnAddNewOtherPayer)){
					return returnValue;
				}else{
					Assert.fail("Edit cancel not working");
				}
			}
			
			if(payerData.testCaseId.equals("TC_CP_001")){
				payerData.workSheetName = "AddPayers";
				payerData.testCaseId = "TC_CP_008";
				payerData.fetchHomeTestData();
			}else{
				payerData.workSheetName = "AddPayers";
				payerData.testCaseId = "TC_CP_013";
				payerData.fetchHomeTestData();
			}
			
			if(payerData.testCaseId.equals("TC_CP_013")){
				assertTrue(click(selenium,btnEditOther), "Could not click Edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			else
			{
			assertTrue(clickEditButtonForMedicalPayers(selenium),"unable to click edit button",selenium,ClassName,MethodName);	
			//assertTrue(click(selenium,btnEdit1), "Could not click Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			if(payerData.testCaseId.equals("TC_CP_013")||payerData.testCaseId.equals("TC_CP_008"))
			{
			assertTrue(editNewPayer(selenium,payerData,date,userAccount),"Edit Payer Details failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Edited Values //
			//--------------------------------------------------------------------//
			assertTrue(verifyEditedValues(selenium,payerData),"Edit Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
    public boolean verifyEditedValues(Selenium selenium, HomeLib payerData) throws IOException {
		
    	if(payerData.testCaseId.equals("TC_CP_013")){
			assertTrue(isTextPresent(selenium,payerData.typeofCoverage),"Could not get text", selenium, ClassName, MethodName);
		}
    	assertTrue(isTextPresent(selenium,payerData.memberId),"Could not get text", selenium, ClassName, MethodName);
		assertTrue(isTextPresent(selenium,payerData.groupNo),"Could not get text", selenium, ClassName, MethodName);
		assertTrue(isTextPresent(selenium,payerData.groupName),"Could not get text", selenium, ClassName, MethodName);
	
		
		
	return true;
    }		
}
