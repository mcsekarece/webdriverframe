package com.nexia.selenium.testscripts.section.billing.batchstatement;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;
public class verifySecurityOptionForBatchstatement extends AbstractBilling
{
	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for View Only")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
	
    public void verifyViewOnly(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception{
		ClassName = this.getClass().getName().substring(39);
		MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "VerifySecurityOption";
		billingData.testCaseId = "TC_VSP_002";
		billingData.fetchBillingTestData();	
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
		
	}
	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for View Only")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
	 public void verifyLimitedAccess(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
			ClassName = this.getClass().getName().substring(39);
			MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "VerifySecurityOption";
			billingData.testCaseId = "TC_VSP_001";
			billingData.fetchBillingTestData();
			verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
		    }
	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for View Only")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
	public void verifyNoAccess(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
			ClassName = this.getClass().getName().substring(39);
			MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "VerifySecurityOption";
			billingData.testCaseId = "TC_VSP_003";
			billingData.fetchBillingTestData();
			verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
		    }
	@Test(groups = { "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for View Only")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
	 public void verifyFullAccess(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
			ClassName = this.getClass().getName().substring(39);
			MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			BillingLib billingData = new BillingLib();
			billingData.workSheetName = "VerifySecurityOption";
			billingData.testCaseId = "TC_VSP_004";
			billingData.fetchBillingTestData();
			verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
		    }
	
	
	 public boolean verifySecurity(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount, BillingLib billingData)
			    throws IOException {
			Selenium selenium = null;
			boolean returnValue = true;
		
			try {
			    // --------------------------------------------------------------------//
			    // Step-1: Login to the application and search for the given patient
			    // //
			    // --------------------------------------------------------------------//
			    selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			    Assert.assertNotNull(selenium, "Could Not Retrive the New Selenium Session; More Details :" + billingData.toString());
			    assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, billingData.userName, billingData.userPassword), "Login Failed ", selenium,
				    ClassName, MethodName);

			    // --------------------------------------------------------------------//
			    // Step-2: change the switch role //
			    // --------------------------------------------------------------------//
			    BillingLib CreateStatemwnt = new BillingLib();
			    CreateStatemwnt.workSheetName = "VerifySecurityOption";
			    CreateStatemwnt.testCaseId = "TC_VSP_004";
			    CreateStatemwnt.fetchBillingTestData();	    
			    
			    assertTrue(switchRole(selenium,CreateStatemwnt.switchRole), "Could not change the switch role;More Details:" + billingData.toString(), selenium,
				    ClassName, MethodName);
			    waitForPageLoad(selenium);

			    // --------------------------------------------------------------------//
			    // Step-3: No Access User Role //
			    // --------------------------------------------------------------------//
			    if (billingData.testCaseId.equals("TC_VSP_003")) {
			    	 assertTrue(switchRole(selenium,billingData.switchRole), "Could not change the switch role;More Details:" + billingData.toString(), selenium,
							    ClassName, MethodName);
						    waitForPageLoad(selenium);
				assertTrue(!selenium.isTextPresent("No permission"), "No Permission Present", selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"), " Error Message Present", selenium, ClassName, MethodName);
				assertTrue(searchPatientNexiaNoAccess(selenium, billingData.patientID), "Could search patient", selenium, ClassName, MethodName);
				return true;
			    }
			    // --------------------------------------------------------------------//
			    // Step-4: Create a Unprinted Statement //
			    // --------------------------------------------------------------------//
	
				assertTrue(click(selenium,btnNexiaLogo),"Click Nexia Logo failed", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				  HomeLib PatientData = new HomeLib();
					PatientData.workSheetName = "NewPatientCheckIn";
					PatientData.testCaseId = "TC_NPC_025";
					PatientData.fetchHomeTestData();
					
				BillingLib chargeEntryData = new BillingLib();
				chargeEntryData.workSheetName = "ChargeEntry";
				chargeEntryData.testCaseId = "TC_CE_014";
				chargeEntryData.fetchBillingTestData();
				
				assertTrue(callChargeEntry(selenium,billingData),"Could not navigate and search the patient",selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(postCharge(selenium,PatientData, chargeEntryData,userAccount)," PostCharge for patient  failed", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnNexiaLogo),"Click Nexia Logo failed", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"Click Failed", selenium, ClassName,MethodName);
				assertTrue(statmentTrigger(selenium, webSite),"Patient Payment failed", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				  // --------------------------------------------------------------------//
			    // Step-4: Verify Security for BatchStatement
			    // --------------------------------------------------------------------//
			    //view only
				
				   if (billingData.testCaseId.equals("TC_VSP_002")) 
				    {
					   assertTrue(click(selenium,btnNexiaLogo),"Click Nexia Logo failed", selenium, ClassName,MethodName);
						waitForPageLoad(selenium);
						
						if(isElementPresent(selenium, btnErrorClose))
							assertTrue(click(selenium, btnErrorClose),"Click Failed", selenium, ClassName,MethodName);
						
						if(!(getText(selenium, lnkTopMenu).contains(billingData.switchRole))){
							click(selenium,lnkTopMenu);
					        click(selenium,lnkSwitchrole);
					        waitForPageLoad(selenium);
					        selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[5]",billingData.switchRole);     
					        click(selenium,txtDeleteReason);
					        waitForPageLoad(selenium);
					        waitForPageLoad(selenium);				        
					        assertTrue(getText(selenium, lnkTopMenu).contains(billingData.switchRole),"Patient Payment failed", selenium, ClassName,MethodName);
					      
						}					
					   	 selenium.click("//div[@id='Unprintedstatements']/div/span[2]");
					   	 waitForPageLoad(selenium);
					   	selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[2]","Unprinted");
					 		waitForPageLoad(selenium);							
								  assertTrue(click(selenium, "css=div.display-cell.width-230"),"Could not click UNprinted statement from list", selenium, ClassName, MethodName);	   
								
								if(!isElementVisible(selenium, btnPrintSendUnprintStatement)&&!isElementPresent(selenium,btnEdit)&&!isElementPresent(selenium,"link=Remove") &&isElementPresent(selenium,"css=div.box") )								
							{
							
								return true;
							}
								else
								{
									return false;
								}
				    
				    }		 
				   
				   //Limited Access only
				   
				   if (billingData.testCaseId.equals("TC_VSP_001")) 
				   {
					   assertTrue(click(selenium,btnNexiaLogo),"Click Nexia Logo failed", selenium, ClassName,MethodName);
						waitForPageLoad(selenium);
						
						if(isElementPresent(selenium, btnErrorClose))
							assertTrue(click(selenium, btnErrorClose),"Click Failed", selenium, ClassName,MethodName);
						
						if(!(getText(selenium, lnkTopMenu).contains(billingData.switchRole))){
							click(selenium,lnkTopMenu);
					        click(selenium,lnkSwitchrole);
					        waitForPageLoad(selenium);
					        selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[5]",billingData.switchRole);     
					        click(selenium,txtDeleteReason);
					        waitForPageLoad(selenium);
					        waitForPageLoad(selenium);				        
					        assertTrue(getText(selenium, lnkTopMenu).contains(billingData.switchRole),"Patient Payment failed", selenium, ClassName,MethodName);
		  	  	}								
						 selenium.click("//div[@id='Unprintedstatements']/div/span[2]");
					   	 waitForPageLoad(selenium);
					   	selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[2]","Unprinted");
					 		waitForPageLoad(selenium);							
					 		  assertTrue(click(selenium, btnPrintSendUnprintStatement),"Could not click UNprinted statement from list", selenium, ClassName, MethodName);	   
						if(isElementVisible(selenium, btnPrintSendUnprintStatement) && isElementPresent(selenium,btnEdit) && !isElementPresent(selenium,"link=Remove") && isElementPresent(selenium,btnPrintUnprintStatement))
						{
							waitForPageLoad(selenium);			
							  assertTrue(click(selenium, "css=div.display-cell.width-230"),"Could not click UNprinted statement from list", selenium, ClassName, MethodName);
							  waitForPageLoad(selenium);	
							  if(isElementPresent(selenium,"statement-edit-save-button"))
							  {
							
							return true;
							}
							
						}
						else
						{
							return false;
						}				
				   }	
				   
				   //Full access only
				   if (billingData.testCaseId.equals("TC_VSP_004")) 
				   {
					   assertTrue(click(selenium,btnNexiaLogo),"Click Nexia Logo failed", selenium, ClassName,MethodName);
						waitForPageLoad(selenium);	
						
						if(isElementPresent(selenium, btnErrorClose))
							assertTrue(click(selenium, btnErrorClose),"Click Failed", selenium, ClassName,MethodName);
						
						 selenium.click("//div[@id='Unprintedstatements']/div/span[2]");
					   	 waitForPageLoad(selenium);
					   	selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[2]","Unprinted");
					 		waitForPageLoad(selenium);							
					 		  assertTrue(click(selenium, btnPrintSendUnprintStatement),"Could not click UNprinted statement from list", selenium, ClassName, MethodName);	   
						if(isElementVisible(selenium, btnPrintSendUnprintStatement) && isElementPresent(selenium,btnEdit) && isElementPresent(selenium,"link=Remove") && isElementPresent(selenium,btnPrintUnprintStatement))
						{
							waitForPageLoad(selenium);			
							  assertTrue(click(selenium, "css=div.display-cell.width-230"),"Could not click UNprinted statement from list", selenium, ClassName, MethodName);
							  waitForPageLoad(selenium);	
							  if(isElementPresent(selenium,"statement-edit-save-button"))
							  {
							
							return true;
							}
							
						}
						else
						{
							return false;
						}				
				   }   
		}
	catch(Exception e)
	{
		
	}
			return returnValue;
	 
}
		
	 public boolean postCharge(Selenium selenium,HomeLib PatientData , BillingLib chargeEntryData,String  userAccount) throws Exception{
		    
			//String date =null;
			boolean returnValue = false;
			try{	
				
				// Navigate to  Patient
				if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"Click Failed", selenium, ClassName,MethodName);
				assertTrue(type(selenium, txtPatientBox, PatientData.lastName),"Could not type patient last name", selenium, ClassName,MethodName);
				selenium.clickAt("searchPatientBox","");
				selenium.focus("searchPatientBox");			
				selenium.fireEvent("searchPatientBox","keypress");		
				waitForElement(selenium, lblPatientResult, 10000);
				assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+ PatientData.patientID, selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selenium.mouseOver(lblPatientResult2);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				
				// Navigate to Post New charge
				
				assertTrue(goToPostNewCharge(selenium, chargeEntryData),"PostNewCharge failed", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				// Post New Charge for the patient
				
				assertTrue(savePostChargeEntry(selenium, chargeEntryData,userAccount)," Save Post New Charge Entry failed", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				returnValue = true;
				
				}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + chargeEntryData.toString());
			}
			return returnValue;
		}	 


}

	