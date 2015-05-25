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

public class VerifyDeletePayers extends AbstractHomeTest {

	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Delete Medical Payers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteMedicalPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_001";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Delete  Other Payers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyDeleteOtherPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_002";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Delete all Payers
	* @action 		  Delete All Payers
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 20, 2013
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
			//  Step-2:Search Patient //
			//--------------------------------------------------------------------//
			
			assertTrue(searchPatientNexia(selenium,payerData.patientId),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Payers //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(payerData.testCaseId.equals("TC_CP_001")){
				assertTrue(click(selenium,btnPatientMedicalPayers),"Could not click the Medical Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(deleteAllPayers(selenium),"Delete All MedicalPayers failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium); 	
				assertTrue(click(selenium, btnAddNew), "Could not click New button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if(payerData.testCaseId.equals("TC_CP_002")){
				assertTrue(click(selenium,btnPatientOtherPayers),"Could not click the Others Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			
				assertTrue(deleteAllOtherPayers(selenium),"Delete All other Payers failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium); 	
				assertTrue(click(selenium, btnAddNewForOtherPayer), "Could not click New button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
					
			}
			
					//--------------------------------------------------------------------//
			//  Step-5: Create Payers //
			//--------------------------------------------------------------------//
			
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
			
			//--------------------------------------------------------------------//
			//  Step-6: Delete all Payers //
			//--------------------------------------------------------------------//
			
			if(payerData.testCaseId.equals("TC_CP_001")){
				assertTrue(deleteAllPayers(selenium),"Delete All MedicalPayers failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium); 	
				}
				if(payerData.testCaseId.equals("TC_CP_002")){
					assertTrue(deleteAllOtherPayers(selenium),"Delete All other Payers failed",selenium, ClassName, MethodName);
					waitForPageLoad(selenium); 	
				}
			//--------------------------------------------------------------------//
			//  Step-6: Verify  Delete all Payers //
			//--------------------------------------------------------------------//
			String value = null;
			String finalvalue = null;
			
			int counter ; 
			
			if(payerData.testCaseId.equals("TC_CP_001")){
			    value = getText(selenium,btnPatientOtherPayers);
			    System.out.println(value);
				waitForPageLoad(selenium);
				try{
					finalvalue =  value.replace("Medical Payers (","");
					finalvalue = finalvalue .replace(")","");
					System.out.println(finalvalue);
					counter = Integer.parseInt(finalvalue);
					if(counter == 0){
						return true;
					}else{
						Assert.fail("Verify  Delete all Payers failed");
					}
					
				}
				catch(Exception e){
					
				}
			}
			if(payerData.testCaseId.equals("TC_CP_002")){
			    value = getText(selenium,btnPatientOtherPayers);
			    System.out.println(value);
				waitForPageLoad(selenium);
				try{
					finalvalue =  value.replace("Other Payers (","");
					finalvalue = finalvalue .replace(")","");
					System.out.println(finalvalue);
					counter = Integer.parseInt(finalvalue);
					if(counter == 0){
						return true;
					}else{
						Assert.fail("Verify  Delete all Payers failed");
					}
					if(!selenium.isTextPresent("No Payers Added")){
						Assert.fail("Verify  Delete all Payers failed");
					}
				}
				catch(Exception e){
					
				}
			
			if(isElementPresent(selenium,lnkOtherPayerDel)){
				Assert.fail("Verify Delete all payers failed");
			}
			
			}	
			
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
	boolean test(HomeLib payerData, Selenium selenium){
		String value = null;
		String finalvalue = null;
		
		int counter ; 
		
		if(payerData.testCaseId.equals("TC_CP_002")){
		    value = getText(selenium,btnPatientOtherPayers);
		   System.out.println(value);
			waitForPageLoad(selenium);
			try{
				finalvalue =  value.replace("Other Payers (","");
				finalvalue = finalvalue .replace(")","");
				System.out.println(finalvalue);
				counter = Integer.parseInt(finalvalue);
				if(counter == 0){
					return true;
				}else{
					Assert.fail("Verify  Delete all Payers failed");
				}
				if(!selenium.isTextPresent("No Payers Added")){
					Assert.fail("Verify  Delete all Payers failed");
				}
			}
			catch(Exception e){
				
			}
	}
		return false;
	}
	
}
