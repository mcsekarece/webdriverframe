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

public class VerifyCalculationBasedOnMasterListServiceCode extends AbstractBilling {
    	
    @Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Calculation based on Master List service code suffix with-A - Provider Fee")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalculationBasedOnMasterListServiceCodeSuffix_A(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_034";
		billingData.fetchBillingTestData();
		verifyCalculation(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    @Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Calculation based on Master List service code suffix with-B - Assistant's Fee")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalculationBasedOnMasterListServiceCodeSuffix_B(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_035";
		billingData.fetchBillingTestData();
		verifyCalculation(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    @Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Calculation based on Master List service code suffix with-C - Anaesthetist's and non-Anaesthetist's Fee")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCalculationBasedOnMasterListServiceCodeSuffix_C(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_036";
		billingData.fetchBillingTestData();
		verifyCalculation(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    
   
    /*************************************************************************************************** 
	* @purpose        Verify Calculation In Master List Service Code based on suffixes
	* @action 		  verifying Calculation In Master List Service Code based on suffixes
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    CA
	* @since  	      May 08, 2014	
	***************************************************************************************************/
	public boolean verifyCalculation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
		String serviceCodeEndsWith;
		String tempServiceCode;
		Boolean serviceCodeFound = false;
		int serviceListCount ;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to service code								  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToServiceCode(selenium),"Could not navigate to service code", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//-------------------------------------------------------------------------//
			//  Step-3: Search the Service Codes In Master List	ends with needed value //
			//-------------------------------------------------------------------------//
			assertTrue(click(selenium, btnManageServiceCodes),"Could not click the add button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium); 
			
			assertTrue(click(selenium, lnkMasterListTab),"Could not click the master list tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium, ajxCodingSystem, billingData.codingSystemCA),"Could not select the type of coding system", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			serviceCodeEndsWith = billingData.endsWithValue;

			assertTrue(type(selenium, txtSearchInMasterList, billingData.endsWithValue),"Could not type the code in search box", selenium, ClassName,MethodName);
			selenium.keyPress(txtSearchInMasterList, "\\9");
			waitForPageLoad(selenium);
			
			//get the service code count after search
			serviceListCount = (Integer) selenium.getXpathCount("//div[@class='display-cell result-title service-code-name']");

			for(int count=1; count<=serviceListCount; count++){
				//get the service code value
				tempServiceCode = getText(selenium, "xpath=(//div[@class='display-cell result-title service-code-name'])["+count+"]");
				
				//compare the service code value with what we expected
				if(tempServiceCode.endsWith(serviceCodeEndsWith)){
					//if found set the current service code value into the excel object value
					billingData.serviceCode1 = tempServiceCode;
					//check the particular service code
					assertTrue(click(selenium, "xpath=(//input[@id='serviceCodeCheckBoxcheckbox'])["+count+"]"),"Could not check the service code", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					//set the boolean value to 'true'. Because, we found what we needed
					serviceCodeFound = true;
					break;
				}
			}
			
			//if no service code found ends with the value(comes from excel), Stop the execution
			if(!serviceCodeFound){
				return true;
			}
			
			//get the current date
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (userAccount.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("dd/MM/YYYY");
			}else{
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			billingData.effectiveOnDateCurrent = DateFormat.format(cal.getTime());
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to set service fee							      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, rdoSetServiceFees),"Could not click the set service fees radio button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to service default							      //
			//--------------------------------------------------------------------//
			//get the standard fee value and store it into excel object
			billingData.currentFees = getText(selenium, lblStandaredFeeInSetServiceFee).trim();
		
			assertTrue(enterDate(selenium,txtEffectiveDate1,billingData.effectiveOnDateCurrent),"Could not enter the new effective date", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, rdoSetServiceDefault),"Could not click the set service default radio button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Complete the service code process						  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnDoneServiceCode),"Could not click the done button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------------------//
			//  Step-7: Verify the created service code Unit value shows based on condition   //
			//--------------------------------------------------------------------------------//
			assertTrue(type(selenium, txtSearchInServiceCode, billingData.serviceCode1),"Could not type the service code in search box", selenium, ClassName,MethodName);
			selenium.keyPress(txtSearchInServiceCode, "\\13");
			waitForPageLoad(selenium);
			
			//if service code ends with 'A' then unit becomes '1'
			if(billingData.testCaseId.equalsIgnoreCase("TC_SC_034")){
				billingData.dividedByValue = billingData.currentFees;
			}
			billingData.units = String.valueOf(getUnitValueUsingFeeValue(selenium, billingData));
			
			String FirstFilteredResultInServiceCode = getText(selenium,lblFilterResultInServiceCodeFirst);

			if (!FirstFilteredResultInServiceCode.toLowerCase().contains(billingData.serviceCode1.toLowerCase().trim())) {
				return false;
			}
			if (!FirstFilteredResultInServiceCode.toLowerCase().contains(billingData.serviceDescription1.toLowerCase())) {
				return false;
			}
			if (!FirstFilteredResultInServiceCode.toLowerCase().contains(billingData.currentFees.toLowerCase())) {
				return false;
			}
			if (!FirstFilteredResultInServiceCode.toLowerCase().contains(billingData.units.toLowerCase())) {
				return false;
			}
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
	
	/**
	 * This function used to get the unit value based on some calculations
	 * @param selenium
	 * @param billingData
	 * @return
	 */
	private int getUnitValueUsingFeeValue(Selenium selenium, BillingLib billingData){
		int unitValue = 0;
		System.out.println(billingData.currentFees);
		Float currentFee = Float.valueOf(billingData.currentFees);
		Float divideByValue = Float.valueOf(billingData.dividedByValue);
		if(currentFee!=0){
			unitValue = Math.round(currentFee/divideByValue);
		}
		return unitValue;
	}
}

