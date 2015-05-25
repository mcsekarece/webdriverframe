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

public class VerifyStoredValuesinListView  extends AbstractHomeTest {

	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Stored values for  Medical Payers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForMedicalPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_004";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Stored values for  Other Payers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForOtherPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_005";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify  Stored Values in ListView 
	* @action 		  Delete All Payers
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 23, 2013
	***************************************************************************************************/
	
	public boolean createPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib payerData) throws IOException{
		
		Selenium selenium=null;
		String date =null;
		String time =null;
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
			
			if(payerData.testCaseId.equals("TC_CP_004")){
				assertTrue(click(selenium,btnPatientMedicalPayers),"Could not click the Medical Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if(payerData.testCaseId.equals("TC_CP_005")){
				assertTrue(click(selenium,btnPatientOtherPayers),"Could not click the Others Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}

			//--------------------------------------------------------------------//
			//  Step-4: Delete all Payers //
			//--------------------------------------------------------------------//
			
			assertTrue(deleteAllPayers(selenium),"Delete All Payers failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium); 	
		
			//--------------------------------------------------------------------//
			//  Step-5: Create Payers //
			//--------------------------------------------------------------------//
			
			if(payerData.testCaseId.equals("TC_CP_005")){
				 for(int i =1;i<10;i++){
					selenium.focus(btnAddNewForOtherPayer);
					selenium.clickAt(btnAddNewForOtherPayer, "");
					selenium.keyPress(btnAddNewForOtherPayer, "\\13");
				    }
			}else{
			assertTrue(click(selenium, btnAddNew), "Could not click New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			  	date=DateFormat1.format(cal.getTime());
			  	SimpleDateFormat DateFormat=new SimpleDateFormat("HH");
				 time=DateFormat.format(cal.getTime());
		    }else {
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
					SimpleDateFormat DateFormat=new SimpleDateFormat("HH");
					time=DateFormat.format(cal.getTime());
			}
			
			assertTrue(addNewPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify Stored Values //
			//--------------------------------------------------------------------//
			 
			if(payerData.testCaseId.equals("TC_CP_005")){
			    assertTrue(verifyStoredValuesOtherPayer(selenium,payerData,date,userAccount),"verify Stored Values in List View failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			else{
			assertTrue(verifyStoredValues(selenium,payerData,date,userAccount),"verify Stored Values in List View failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			
						
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyStoredValues(Selenium selenium,HomeLib payerData,String Date,String account) throws IOException{
		
	vfyPayerDetails="visitListItem1";
	assertTrue(getText(selenium,vfyPayerDetails).contains(payerData.patientId),"Could not get text", selenium, ClassName, MethodName);
	assertTrue(getText(selenium,vfyPayerDetails).contains(payerData.relationshipStatus),"Could not get text", selenium, ClassName, MethodName);
	assertTrue(getText(selenium,vfyPayerDetails).contains(payerData.memberId),"Could not get text", selenium, ClassName, MethodName);
	assertTrue(getText(selenium,vfyPayerDetails).contains(payerData.groupNo),"Could not get text", selenium, ClassName, MethodName);
	
	if(payerData.testCaseId.equals("TC_CP_005")){
		
		assertTrue(getText(selenium,vfyPayerDetails).contains(payerData.typeofCoverage),"Could not get text", selenium, ClassName, MethodName);
	}else{
		assertTrue(getText(selenium,vfyPayerDetails).contains(payerData.payerName),"Could not get text", selenium, ClassName, MethodName);
	}
	
	lnkExpandAll1="css=div.chart-list-item-main-content";
	
    assertTrue(click(selenium,vfyPayerDetails),"Could not click the Expand Arrow",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	
/*	System.out.println(getText(selenium,vfyPayerDetails1));
	
        assertTrue(getText(selenium,vfyPayerDetails1).contains(payerData.coPay),"Could not get text", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,vfyPayerDetails1).contains(payerData.specialistCoPay),"Could not get text", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,vfyPayerDetails1).contains(payerData.deductible),"Could not get text", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,vfyPayerDetails1).contains(payerData.coInsurance),"Could not get text", selenium, ClassName, MethodName);*/
	/*
	assertTrue(getText(selenium,vfyPayerDetails1).trim().contains(payerData.telNum2),"Could not get text", selenium, ClassName, MethodName);
	assertTrue(getText(selenium,vfyPayerDetails1).contains(payerData.sex),"Could not get text", selenium, ClassName, MethodName);
	if(account.equals(CAAccount)){
		assertTrue(getText(selenium,vfyPayerDetails1).contains(payerData.dobCA),"Could not get text", selenium, ClassName, MethodName);
	}else{
		assertTrue(getText(selenium,vfyPayerDetails1).contains(payerData.dob),"Could not get text", selenium, ClassName, MethodName);
	}*/
	
	return true;
	}
	
	public boolean verifyStoredValuesOtherPayer(Selenium selenium,HomeLib payerData,String Date,String account) throws IOException{
		
		vfyPayerDetails="patientOtherPayer";
		assertTrue(getText(selenium,vfyPayerDetails).contains(payerData.patientId),"Could not get text", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,vfyPayerDetails).contains(payerData.relationshipStatus),"Could not get text", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,vfyPayerDetails).contains(payerData.memberId),"Could not get text", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,vfyPayerDetails).contains(payerData.groupNo),"Could not get text", selenium, ClassName, MethodName);
		
		if(payerData.testCaseId.equals("TC_CP_005")){
			assertTrue(getText(selenium,vfyPayerDetails).contains(payerData.typeofCoverage),"Could not get text", selenium, ClassName, MethodName);
		}else{
			assertTrue(getText(selenium,vfyPayerDetails).contains(payerData.payerName),"Could not get text", selenium, ClassName, MethodName);
		}
		
		
		
		return true;
		}
}
