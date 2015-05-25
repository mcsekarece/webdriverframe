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

public class VerifyChangeBillingOrderForPayer extends AbstractHomeTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Change Billing Order by Drag and Drop")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyChangeBillingOrderByDragAndDrop(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_008";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		changeBillingOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        VerifyChangeBillingOrderforpayer
	* @action 		  Test for Verify Change Billing Order payer Using  Drag and Drop
	* @author         Aspire QA
	 * @throws        IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 30, 2013
	***************************************************************************************************/
	
	public boolean changeBillingOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib payerData) throws IOException{
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
		
			//--------------------------------------------------------------------//
			//  Step-4: Delete all Payers //
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
		    }else {
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
			}
			
			assertTrue(addNewPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-6: Create another Payers //
			//--------------------------------------------------------------------//
			HomeLib payersData = new HomeLib();
			payersData.workSheetName = "AddPayers";
			payersData.testCaseId = "TC_CP_001";
			payersData.fetchHomeTestData();
			
			assertTrue(click(selenium, btnAddNew), "Could not click New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(addNewPayer(selenium,payersData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Change Billing order //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnChangeBillingOrder), "Could not click change billing order button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(dragAndDrop(selenium, payersData), "Drag and drop failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify Billing order //
			//--------------------------------------------------------------------//
			
			assertTrue(getText(selenium,vfyPayerDetails2).contains(payersData.payerName),"Verify billing order failed", selenium, ClassName, MethodName);
			/*payerData.workSheetName = "AddPayers";
			payerData.testCaseId = "TC_CP_008";
			payerData.fetchHomeTestData();*/
			assertTrue(getText(selenium,vfyMedPayerDetails).contains(payerData.payerName),"Verify billing order failed", selenium, ClassName, MethodName);
					
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean dragAndDrop(Selenium selenium,  HomeLib payerData) throws IOException{
		
		selenium.mouseOver(dragSource);
		selenium.mouseDown(dragSource);
		selenium.focus(dragSource);
		selenium.dragAndDropToObject(dragSource,dragDestination);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnlnkSave), "Could not click Save button ", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
}	
	
