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

public class VerifyPreviousPatientPayer extends AbstractHomeTest{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Previous Patient Payer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPreviousPatientMedicalPayer(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_001";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		previousPatientPayer(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Plan Override for Other Payer")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPreviousPatientOtherPayer(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_002";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		previousPatientPayer(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	/*************************************************************************************************** 
	* @purpose        ToVerifyPreviousPatientPayer
	* @action 		  Verifying the PreviousPatient Payer
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 24, 2013
	***************************************************************************************************/
	
	public boolean previousPatientPayer(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib payerData) throws IOException{
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
		
			if(payerData.testCaseId.equals("TC_CP_001")){
				assertTrue(click(selenium,btnPatientMedicalPayers),"Could not click the Medical Payer", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if(payerData.testCaseId.equals("TC_CP_002")){
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
			
			if(payerData.testCaseId.equals("TC_CP_002")){
				assertTrue(click(selenium, btnAddNewOtherPayer), "Could not click New button", selenium, ClassName, MethodName);
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
			
			assertTrue(addNewPayer(selenium,payerData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-6: Select  Payers //
			//--------------------------------------------------------------------//
			if(payerData.testCaseId.equals("TC_CP_002"))
			{
			assertTrue(click(selenium, btnAddNewOtherPayer),"Could not click New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}else
			{
				assertTrue(click(selenium, btnAddNew),"Could not click New button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
	
			//--------------------------------------------------------------------//
			//  Step-7: Select  Payers //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkSelectPayer), "Could not click Select payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForElement(selenium,lblPatientResult,10000);
			
			int counter=1; 
			


while(isElementPresent(selenium,String.format(ajxListPatientForPayers,counter))||isElementVisible(selenium,String.format(ajxListPatientForPayers,counter)))
					{
				if(getText(selenium,String.format(ajxListPatientForPayers,counter)).contains(payerData.payerName))
				{
					assertTrue(click(selenium,String.format(ajxListPatientForPayers,counter)),"could not click required Payer",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					break;
				}
					}
			/*int count = (Integer) selenium.getXpathCount("//div[@class='pick-list-wrapper payerSelectWrapper left-button-spacer inlineBlock']/div/div/div");
			for (counter=1; counter<=count;counter++){
				if(getText(selenium,"//div[@class='pick-list-wrapper payerSelectWrapper left-button-spacer inlineBlock']/div/div/div["+counter+"]").contains(payerData.payerName)){
				assertTrue(click(selenium,"//div[@class='pick-list-wrapper payerSelectWrapper left-button-spacer inlineBlock']/div/div/div["+counter+"]"),"could not click required Payer",selenium, ClassName, MethodName);
				 for(int i =1;i<10;i++){
				selenium.focus("//div[@class='pick-list-wrapper payerSelectWrapper left-button-spacer inlineBlock']/div/div/div["+counter+"]");
				selenium.clickAt("//div[@class='pick-list-wrapper payerSelectWrapper left-button-spacer inlineBlock']/div/div/div["+counter+"]", "");
				selenium.keyPress("//div[@class='pick-list-wrapper payerSelectWrapper left-button-spacer inlineBlock']/div/div/div["+counter+"]", "\\13");
			 	waitForPageLoad(selenium);
				 }
			 	break;
				}
			}
			if(counter > count){
				Assert.fail("Required Payer not found");
			}
		*/
			//--------------------------------------------------------------------//
			//  Step-8: Verify Previous Patient Payers //
			//--------------------------------------------------------------------//
			
			assertTrue(getValue(selenium,ajxPayerSelect).contains(payerData.payerName),"Verify Previous Patient Payers failed", selenium, ClassName, MethodName);
			if(payerData.testCaseId.equals("TC_CP_002")){
			assertTrue(getValue(selenium,ajxTypeOfCoverageSuggest).contains(payerData.typeofCoverage),"Verify Previous Patient Payers failed", selenium, ClassName, MethodName);
		    }
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
