package com.nexia.selenium.testscripts.section.portability;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class CreateServiceCodePortability extends AbstractBilling {
    	
    @Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify service code portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createServiceCodePortability(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_006";
		billingData.fetchBillingTestData();
		createServiceCodePortability(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    
    @Test(groups = {"Regression","Review","firefox", "iexplore", "safari", "default" }, description = "Verify service code portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createParticularServiceCodePortability(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib billingData = new BillingLib();
		billingData.workSheetName = "ServiceCodes";
		billingData.testCaseId = "TC_SC_037";
		billingData.fetchBillingTestData();
		createServiceCodePortability(seleniumHost, seleniumPort, browser, webSite, userAccount, billingData);
	}
    
    /*************************************************************************************************** 
	* @purpose        Verify service code portability
	* @action 		  verifying service code portability
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    US
	* @since  	      Jan 24, 2014	
	***************************************************************************************************/
    
	public boolean createServiceCodePortability(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib billingData) throws IOException{
		Selenium selenium=null;
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
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Add Master List Service Code							  //
			//--------------------------------------------------------------------//
			
			waitForPageLoad(selenium);
			
			if(billingData.testCaseId.equals("TC_SC_006")){
			assertTrue(click(selenium, btnAddServiceCode),"Could not click the add button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkMasterListTab),"Could not click the master list tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(userAccount.equalsIgnoreCase(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium, ajxCodingSystem, billingData.codingSystemCA),"Could not select the type of coding system", selenium, ClassName,MethodName);
			}
			else{
				assertTrue(selectValueFromAjaxList(selenium, ajxCodingSystem, billingData.codingSystem),"Could not select the type of coding system", selenium, ClassName,MethodName);
			}
			assertTrue(type(selenium, txtFilterCodeRangeFrom, billingData.serviceCode),"Could not type the code in range from", selenium, ClassName,MethodName);
			assertTrue(type(selenium, txtFilterCodeRangeEnd, billingData.serviceCode4),"Could not type the code in range end", selenium, ClassName,MethodName);
			selenium.keyPress(txtFilterCodeRangeEnd, "\\13");
			waitForPageLoad(selenium);
			}
			
			// createParticularServiceCodePortability
		  
		else if(billingData.testCaseId.equals("TC_SC_037")) {
			
		// Verify the code is already created or not
		
			assertTrue(type(selenium, txtSearchInServiceCode, billingData.serviceCode1),"Could not type the code in search box", selenium, ClassName,MethodName);
		    selenium.keyPress(txtSearchInServiceCode, "\\13");
			   waitForPageLoad(selenium);
				if ((getText(selenium, lblFilterResultInServiceCode).trim().contains(billingData.serviceCode1.trim()))){
					System.out.println("Service Code "+billingData.serviceCode1+" is Already Available");
					return true;
				}
			
		// Check the code is in inactive state 
			
		   if(!isChecked(selenium, chkIncludeInactive)){
					assertTrue(click(selenium, chkIncludeInactive),"Could not click the include inactive check box", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					assertTrue(type(selenium, txtSearchInServiceCode, billingData.serviceCode1),"Could not type the code in search box", selenium, ClassName,MethodName);
					selenium.keyPress(txtSearchInServiceCode, "\\13");
					waitForPageLoad(selenium);
				
					if ((getText(selenium, lblFilterResultInServiceCode).trim().contains(billingData.serviceCode1.trim()))){
						assertTrue(click(selenium, lblInActiveServiceCode),"Could not navigate to service code section", selenium,ClassName, MethodName);
						waitForPageLoad(selenium);
						assertTrue(click(selenium, btnActiveServiceCode),"Could not click the Activate", selenium, ClassName,MethodName);
						waitForPageLoad(selenium);
						
						return true;
					}
		   }
		   
		   // 	 Check the code is in inactive state if not add it from master list		
		   
			assertTrue(click(selenium, btnAddPostCharge),"Could not click the add button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, lnkMasterListTab),"Could not click the master list tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(userAccount.equalsIgnoreCase(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium, ajxCodingSystem, billingData.codingSystemCA),"Could not select the type of coding system", selenium, ClassName,MethodName);
			}
			else{
				assertTrue(selectValueFromAjaxList(selenium, ajxCodingSystem, billingData.codingSystem),"Could not select the type of coding system", selenium, ClassName,MethodName);
			}
			assertTrue(type(selenium, txtSearchInMasterList, billingData.serviceCode1),"Could not type the code in serach master list", selenium, ClassName,MethodName);
			selenium.keyPress(txtSearchInMasterList, "\\13");
			waitForPageLoad(selenium);
		   }
	
			int count = (Integer) selenium.getXpathCount(chkMasterListServiceCode1);
			
			for(int tempCount=1; tempCount<=count; tempCount++){
				assertTrue(click(selenium, chkMasterListServiceCode1+"["+tempCount+"]"),"Could not check all the master list filtered code", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(click(selenium, btnDoneServiceCode),"Could not click the done button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------------------//
			//  Step-4: Verify the created service code details in service code summary	      //
			//--------------------------------------------------------------------------------//
			if(billingData.equals("TC_SC_006")){
			assertTrue(type(selenium, txtSearchInServiceCode, billingData.serviceCode.substring(0, 5)),"Could not type the code in search box", selenium, ClassName,MethodName);
			selenium.keyPress(txtSearchInServiceCode, "\\13");
			waitForPageLoad(selenium);
			
			if (!(getText(selenium, lblFilterResultInServiceCode).trim().contains(billingData.serviceCode.trim())
					&& getText(selenium, lblFilterResultInServiceCode).trim().contains(billingData.serviceCode2.trim())
					&& getText(selenium, lblFilterResultInServiceCode).trim().contains(billingData.serviceCode3.trim())
					&& getText(selenium, lblFilterResultInServiceCode).trim().contains(billingData.serviceCode4.trim()))){
				if(!isChecked(selenium, chkIncludeInactive)){
					assertTrue(click(selenium, chkIncludeInactive),"Could not click the include inactive check box", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
				}
				
				//Include inactive not implemented
			}
			
			}
		
			// Verify createParticularServiceCodePortability
			
			else if(billingData.equals("TC_SC_037")) {
				
				assertTrue(type(selenium, txtSearchInServiceCode, billingData.serviceCode1),"Could not type the code in search box", selenium, ClassName,MethodName);
				selenium.keyPress(txtSearchInServiceCode, "\\13");
				waitForPageLoad(selenium);
				assertTrue(((getText(selenium, lblFilterResultInServiceCode).trim().contains(billingData.serviceCode1.trim()))),"Create Particular Service Code Portability Failed", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}

