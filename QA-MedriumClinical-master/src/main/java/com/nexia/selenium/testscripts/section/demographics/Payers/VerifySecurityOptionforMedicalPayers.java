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

public class VerifySecurityOptionforMedicalPayers extends AbstractHomeTest {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "VerifySecurityOption";
		payerData.testCaseId = "TC_VSP_001";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "VerifySecurityOption";
		payerData.testCaseId = "TC_VSP_002";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "VerifySecurityOption";
		payerData.testCaseId = "TC_VSP_003";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "VerifySecurityOption";
		payerData.testCaseId = "TC_VSP_004";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	

	/*************************************************************************************************** 
	* @purpose        To Verify Security Option for Medical Payers
	* @action 		   Verify Security Option for Medical Payers
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 13, 2013
	***************************************************************************************************/
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib payerData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + payerData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, payerData.userName, payerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			
			if(!payerData.testCaseId.equals("TC_VSP_002")){
				assertTrue(switchRole(selenium,payerData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,payerData, userAccount)){
				Assert.fail("Security option not show properly for Medical Payers; More Details :"+ payerData.toString());
			}else
				returnValue=true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySecurity(Selenium selenium,HomeLib payerData, String userAccount) throws IOException{
		
		String date =null;
		if(userAccount.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
		  	date=DateFormat1.format(cal.getTime());
	    }else {
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat1.format(cal.getTime());
		}
		Calendar cal1=Calendar.getInstance();
		// Limited Access
		
		if(payerData.testCaseId.equals("TC_VSP_001")){	
		
			payerData.workSheetName = "AddPayers";
			payerData.testCaseId = "TC_CP_001";
			payerData.fetchHomeTestData();
			HomeLib patientData = new HomeLib();	
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_001";
			patientData.fetchHomeTestData();	
			assertTrue(goToRegisterPatient(selenium),"Could not navigated to register patient",selenium, ClassName, MethodName);	
		
            SimpleDateFormat dateFormat=new SimpleDateFormat("MMMdd,yyyyHHmm:ss");
            String date1=null;
            date1=dateFormat.format(cal1.getTime());
            patientData.lastName=patientData.lastName+date1;
            payerData.patientId = patientData.lastName;
            assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed",selenium, ClassName, MethodName);
			assertTrue(searchPatientNexia(selenium,payerData.patientId),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
            //Add new payer

			//assertTrue(selenium.isElementPresent(btnAddNew),"Add Button is not visible", selenium, ClassName, MethodName);
			if(!selenium.isElementPresent(btnAddNew)){
				Assert.fail("Add Button is not visible");
			}
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnAddNew), "Could not click New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(addNewPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
		// Delete button
		//	assertTrue(!selenium.isElementPresent(btnDeletePayer),"Delete Button is  visible", selenium, ClassName, MethodName);
			if(selenium.isElementPresent(btnDelete)){
				Assert.fail("Delete Button is  visible");
			}
		}
		
		// View Only Access
		
		if(payerData.testCaseId.equals("TC_VSP_002")){
		
			// Switch to Full Role  
			payerData.workSheetName = "VerifySecurityOption";
			payerData.testCaseId = "TC_VSP_004";
			payerData.fetchHomeTestData();
			
			assertTrue(switchRole(selenium,payerData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(searchPatientNexia(selenium,payerData.patientId),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			payerData.workSheetName = "AddPayers";
			payerData.testCaseId = "TC_CP_001";
			payerData.fetchHomeTestData();
			
			assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Add new payer
			assertTrue(click(selenium, btnAddNew), "Could not click New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(addNewPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			// Switch to View Only role
		
			payerData.workSheetName = "VerifySecurityOption";
			payerData.testCaseId = "TC_VSP_002";
			payerData.fetchHomeTestData();
			
			if(!(getText(selenium, lnkTopMenu).contains(payerData.switchRole))){
				click(selenium,lnkTopMenu);
		        click(selenium,lnkSwitchrole);
		        waitForPageLoad(selenium);
		        selectValueFromAjaxList(selenium,ajxSwitchrole,payerData.switchRole);
		        click(selenium,"//div[7]/div/div/div/div/div");
		        click(selenium,txtDeleteReason);
		        waitForPageLoad(selenium);
			click(selenium,"//body/div[7]/div/div/div/div/div");
			 click(selenium,txtDeleteReason);
			 if(getText(selenium, lnkTopMenu).contains(payerData.switchRole)){
		        waitForPageLoad(selenium);  
			waitForPageLoad(selenium);
			 }
			}
			assertTrue(searchPatientNexia(selenium,payerData.patientId),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//assertTrue(!selenium.isElementPresent(btnAddNew),"AddNew Button is  visible", selenium, ClassName, MethodName);
			if(selenium.isTextPresent("Add")){
				Assert.fail("Add New Button is  visible");
			}
			assertTrue(!selenium.isTextPresent("Delete"),"Delete Button is  visible", selenium, ClassName, MethodName);
		    assertTrue(!selenium.isElementPresent("btnEditPayer"),"Edit Button is  visible", selenium, ClassName, MethodName);			
		
		}
		
		// No Access
		if(payerData.testCaseId.equals("TC_VSP_003")){			
			assertTrue(searchPatientNexiaNoAccess(selenium,payerData.patientId),"Could search patient", selenium, ClassName, MethodName);
		}

		// Full Access
		
		if(payerData.testCaseId.equals("TC_VSP_004")){
		
			payerData.workSheetName = "AddPayers";
			payerData.testCaseId = "TC_CP_001";
			payerData.fetchHomeTestData();
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_001";
			patientData.fetchHomeTestData();	
			  SimpleDateFormat dateFormat=new SimpleDateFormat("MMMdd,yyyyHHmm:ss");
	            String date1=null;
	            date1=dateFormat.format(cal1.getTime());
	            patientData.lastName=patientData.lastName+date1;
	            payerData.patientId = patientData.lastName;
	        
	        	assertTrue(goToRegisterPatient(selenium),"Could not navigated to register patient",selenium, ClassName, MethodName);	
	        	waitForPageLoad(selenium);	
	            assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed",selenium, ClassName, MethodName);
	        	assertTrue(searchPatientNexia(selenium,payerData.patientId),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Add new payer
			
			assertTrue(click(selenium, btnAddNew), "Could not click New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(addNewPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			// Edit button
			
			assertTrue(selenium.isElementPresent(btnEditPayer),"Edit Button is not visible", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnEditPayer),"Could not click the Edit Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			click(selenium,btnYesButton);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxRelationShip,"spouse"),"Could not select Relationship Status"+ payerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnlnkSave), "Could not click Save button" +  payerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Delete button
		    
			assertTrue(selenium.isElementPresent(btnDeletePayer),"Delete Button is not visible", selenium, ClassName, MethodName);
			
		}
		
		return true;
	}	
	
	}

