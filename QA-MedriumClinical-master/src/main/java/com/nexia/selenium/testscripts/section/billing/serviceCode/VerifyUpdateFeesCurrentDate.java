package com.nexia.selenium.testscripts.section.billing.serviceCode;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUpdateFeesCurrentDate extends AbstractBilling {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Update Fees By Percentage")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUpdateFeesByPercentage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_001";
		billingData.fetchBillingTestData();
		verifyUpdateFees(seleniumHost,seleniumPort,browser,webSite, userAccount, billingData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Update Fees By Amount")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUpdateFeesByAmount(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_002";
		billingData.fetchBillingTestData();
		verifyUpdateFees(seleniumHost,seleniumPort,browser,webSite, userAccount, billingData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Update Custom Fees By Percentage")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUpdateCustomFeesByPercentage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_007";
		billingData.fetchBillingTestData();
		verifyUpdateFees(seleniumHost,seleniumPort,browser,webSite, userAccount, billingData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Update Custom Fees By Amount")
	@Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUpdateCustomFeesByAmount(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_008";
		billingData.fetchBillingTestData();
		verifyUpdateFees(seleniumHost,seleniumPort,browser,webSite, userAccount, billingData);
	}

	/*************************************************************************************************** 
	 * @purpose        VerifyUpdateFeesBy Amount/Percentage
	 * @action 		  VerifyUpdateFeesBy Amount/Percentage
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    US and CA
	 * @since  	      Feb 15, 2014	
	 ***************************************************************************************************/

	public boolean verifyUpdateFees(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//

			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			if(selenium.isElementPresent("errorCloseButton") && selenium.isVisible("errorCloseButton")){
				assertTrue( click(selenium, "errorCloseButton"), "Could not click Close button in error dialog box", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			}

			//--------------------------------------------------------------------//
			//  Step-2: Navigate to service code								  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToServiceCode(selenium),"Could not navigate to service code", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Add Master List Service Code							  //
			//--------------------------------------------------------------------//

			assertTrue(click(selenium, btnManageServiceCodes),"Could not click the add button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(billingData.testCaseId.equalsIgnoreCase("TC_SC_001")|| billingData.testCaseId.equalsIgnoreCase("TC_SC_002")){
				assertTrue(click(selenium, lnkMasterListTab),"Could not click the master list tab", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);

				if(userAccount.equalsIgnoreCase(CAAccount)){
					assertTrue(selectValueFromAjaxList(selenium, ajxCodingSystem, billingData.codingSystemCA),"Could not select the type of coding system", selenium, ClassName,MethodName);
				}
				else{
					assertTrue(selectValueFromAjaxList(selenium, ajxCodingSystem, billingData.codingSystem),"Could not select the type of coding system", selenium, ClassName,MethodName);
				}
				waitForPageLoad(selenium);

				billingData.serviceCode1 = getText(selenium, lblMasterListServiceCode1);
				billingData.serviceDescription1 = getText(selenium, lblMasterListServiceDescription1);

				billingData.serviceCode2 = getText(selenium, lblMasterListServiceCode2);
				billingData.serviceDescription2 = getText(selenium, lblMasterListServiceDescription2);

				assertTrue(click(selenium, chkMasterListServiceCode1),"Could not check the the first master list code", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, chkMasterListServiceCode2),"Could not check the the second master list code", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}

			//--------------------------------------------------------------------//
			//  Step-4: Add Custom Service Code									  //
			//--------------------------------------------------------------------//
			else if(billingData.testCaseId.equalsIgnoreCase("TC_SC_007")||billingData.testCaseId.equalsIgnoreCase("TC_SC_008")){
				assertTrue(click(selenium, lnkCustomTab),"Could not click the custom tab", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);

				// get the Unique custom service code using current date and time

				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat;
				DateFormat = new SimpleDateFormat("MMddHHmmss");
				billingData.serviceCode1 = DateFormat.format(cal.getTime());
				billingData.serviceDescription1 = billingData.serviceDescription1 + billingData.serviceCode1;

				assertTrue(type(selenium, txtCustomServiceCode, billingData.serviceCode1),"Could not type the custom service code", selenium, ClassName,MethodName);
				assertTrue(type(selenium, txtCustomDescription, billingData.serviceDescription1),"Could not type the custom service description", selenium, ClassName,MethodName);
				assertTrue(click(selenium, btnAddCustomServiceCode),"Could not click the add button in the custom service code tab", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);

				// get the Unique custom service code using current date and time

				cal = Calendar.getInstance();
				DateFormat = new SimpleDateFormat("MMddHHmmss");
				billingData.serviceCode2 = DateFormat.format(cal.getTime());
				billingData.serviceDescription2 = billingData.serviceDescription2 + billingData.serviceCode2;

				assertTrue(type(selenium, txtCustomServiceCode, billingData.serviceCode2),"Could not type the custom service code", selenium, ClassName,MethodName);
				assertTrue(type(selenium, txtCustomDescription, billingData.serviceDescription2),"Could not type the custom service description", selenium, ClassName,MethodName);
				assertTrue(click(selenium, btnAddCustomServiceCode),"Could not click the add button in the custom service code tab", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);

			}

			assertTrue(click(selenium, rdoSetServiceFees),"Could not click the set service fees radio button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Fill details in service fees						      //
			//--------------------------------------------------------------------//

			assertTrue(updateFillServiceFeeAndDefault(selenium, billingData, userAccount),"Could not fill the service fees", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			/*//----------------------------------------------------------------------------------------------//
			//  Step-6: Verify selected service code and set service fee details in set service default     //
			//----------------------------------------------------------------------------------------------//
			assertTrue(verifyDetailsInSetServiceDefault(selenium, billingData),"Verify failed for the selected service code and set service fee details in set service default", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-7: Fill details in set service default					      //
			//--------------------------------------------------------------------//

			assertTrue(fillSetServiceDefault(selenium, billingData, userAccount),"Could not fill the set service default", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, btnDoneServiceCode),"Could not click the done button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			 */
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Update fees								  //
			//--------------------------------------------------------------------//

			assertTrue(click(selenium, btnUpdateFees),"Could not click the update fee button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);

			// Search the service code 

			assertTrue(type(selenium, txtFilterCodeRangeFrom, billingData.serviceCode1),"Could not type the code in range from", selenium, ClassName,MethodName);
			assertTrue(type(selenium, txtFilterCodeRangeEnd, billingData.serviceCode2),"Could not type the code in range end", selenium, ClassName,MethodName);
			selenium.keyPress(txtFilterCodeRangeEnd, "\\13");

			//--------------------------------------------------------------------//
			//  Step-9: Set the increase amount conditions					      //
			//--------------------------------------------------------------------//

			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (userAccount.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("dd/MM/YYYY");
			}else{
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			billingData.effectiveOnDateCurrent = DateFormat.format(cal.getTime());

			assertTrue(updateFees(selenium, billingData, userAccount),"Could not update the fees", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-10: Verify the Updated Fees values			    //
			//--------------------------------------------------------------------//

			assertTrue(verifyUpdateFees(selenium, billingData, userAccount),"Verify the Updated Fees values	 failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}

	public boolean verifyUpdateFees(Selenium selenium,BillingLib billingData,String userAccount) throws IOException {

		if(billingData.testCaseId.equalsIgnoreCase("TC_SC_002")|| billingData.testCaseId.equalsIgnoreCase("TC_SC_008")){

			assertTrue( getValue(selenium, txtUpdateFeeAmount).trim().contains(billingData.updatedAmt.trim()),
					"Not able to find text " +billingData.updatedAmt , selenium, ClassName, MethodName);				

			assertTrue( getValue(selenium, txtUpdateFeeAmount1).trim().contains(billingData.updatedAmt1.trim()),
					"Not able to find text " +billingData.updatedAmt1 , selenium, ClassName, MethodName);

		}else if (billingData.testCaseId.equalsIgnoreCase("TC_SC_001")|| billingData.testCaseId.equalsIgnoreCase("TC_SC_007")) {

			assertTrue( getValue(selenium, txtUpdateFeeAmount).trim().contains(billingData.updatedAmtPercent.trim()),
					"Not able to find text " +billingData.updatedAmtPercent , selenium, ClassName, MethodName);				

			assertTrue( getValue(selenium, txtUpdateFeeAmount1).trim().contains(billingData.updatedAmtPercent1.trim()),
					"Not able to find text " +billingData.updatedAmtPercent1 , selenium, ClassName, MethodName);				
		}

		assertTrue( getValue(selenium, txtNewFeeDate).trim().contains(billingData.effectiveOnDateCurrent.trim()),
				"Not able to find text " +billingData.effectiveOnDateCurrent , selenium, ClassName, MethodName);				

		assertTrue( getValue(selenium, txtNewFeeDate1).trim().contains(billingData.effectiveOnDateCurrent.trim()),
				"Not able to find text " +billingData.effectiveOnDateCurrent , selenium, ClassName, MethodName);				

		return true;
	}
}


