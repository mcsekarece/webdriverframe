package com.nexia.selenium.testscripts.section.demographics.Payers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyInactivePayerInAddPayerDropDown extends AbstractHomeTest {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Inactive Payer In Add Payer Drop Down")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"} )
	public void verifyInactivePayerInAddPayerDropDown(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib payerData = new HomeLib();
		payerData.workSheetName = "AddPayers";
		payerData.testCaseId = "TC_CP_015";
		payerData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPayers(seleniumHost, seleniumPort, browser, webSite, userAccount, payerData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Inactive Payer In Add Payer Drop Down
	* @action 		  To Verifying Inactive Payer In Add Payer Drop Down
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Nov 13, 2013
	***************************************************************************************************/
	
	public boolean createPayers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib payerData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date = null;
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
			//  Step-2:Navigate to System Setting and Directories							  //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkSystemSettings1),"Could not click the  Settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingAction),"Could not click system setting ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPayerDirectories),"Could not click the Directories link;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
           
			//--------------------------------------------------------------------//
			//  Step-3: Delete Particular Payer //
			//--------------------------------------------------------------------//
			
			assertTrue(type(selenium,txtSearchBox,payerData.payerName),"Could not type the Payer Name", selenium, ClassName, MethodName);
			selenium.keyPress(txtSearchBox, "\\13");
			selenium.keyPress(txtSearchBox, "\\13");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnDelete),"Could not click the Delete Payer link;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnYesbutton),"Could not click the Delete Yes button :", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Search Patient //
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib patientData = new ChartPreVisitLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NP_007";
			patientData.fetchChartPreVisitTestData();		
			
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("MMMdd,yyyyHHmm:ss");
		
		    date=dateFormat.format(cal1.getTime());
			patientData.lastName=patientData.lastName+date;
			payerData.patientId = patientData.lastName;
		
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient),"Could not click on Clinical Lists",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			assertTrue(searchPatientNexia(selenium,payerData.patientId),"Search Patient failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Payers //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnPayerList),"Could not click the Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			//--------------------------------------------------------------------//
			//  Step-6: Create Payers //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnAddNew), "Could not click New button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-7: Verify Inactive Payer In Add Payer Drop Down //
			//--------------------------------------------------------------------//
			
			assertTrue(selectValueFromAjaxList(selenium,ajxPayerSelect,payerData.payerName),"Could not select payer"+ payerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		    assertTrue(click(selenium, btnlnkSave), "Could not click Save button" + payerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!selenium.isTextPresent("Payer must have a valid value selected")){
				Assert.fail("Verify Inactive Payer In Add Payer Drop Down failed");
			}
								
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}

	
	


