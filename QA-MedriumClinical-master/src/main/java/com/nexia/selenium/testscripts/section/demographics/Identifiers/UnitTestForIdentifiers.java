package com.nexia.selenium.testscripts.section.demographics.Identifiers;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForIdentifiers extends AbstractHomeTest{
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Type with empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void typeWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest identifiersData= new HomeLibUnitTest();
		identifiersData.workSheetName="UnitTest_FV_PC_Identifier";
		identifiersData.testCaseId="TC_IDN_001";
		identifiersData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addIdentifiers(seleniumHost, seleniumPort, browser, webSite, userAccount, identifiersData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Mask Value With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void maskValueWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest identifiersData= new HomeLibUnitTest();
		identifiersData.workSheetName="UnitTest_FV_PC_Identifier";
		identifiersData.testCaseId="TC_IDN_002";
		identifiersData.fetchHomeTestData();

		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addIdentifiers(seleniumHost, seleniumPort, browser, webSite, userAccount, identifiersData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Value With MaxLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void valueWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest identifiersData= new HomeLibUnitTest();
		identifiersData.workSheetName="UnitTest_FV_PC_Identifier";
		identifiersData.testCaseId="TC_IDN_003";
		identifiersData.fetchHomeTestData();

		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addIdentifiers(seleniumHost, seleniumPort, browser, webSite, userAccount, identifiersData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "expiration Date is blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void expirationDateisblank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest identifiersData= new HomeLibUnitTest();
		identifiersData.workSheetName="UnitTest_FV_PC_Identifier";
		identifiersData.testCaseId="TC_IDN_004";
		identifiersData.fetchHomeTestData();

		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		if(!(userAccount.equalsIgnoreCase(CAAccount))){
			addIdentifiers(seleniumHost, seleniumPort, browser, webSite, userAccount, identifiersData);
		}
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "expiration Date is blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void expirationDateWithLessThenToday(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest identifiersData= new HomeLibUnitTest();
		identifiersData.workSheetName="UnitTest_FV_PC_Identifier";
		identifiersData.testCaseId="TC_IDN_005";
		identifiersData.fetchHomeTestData();

		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		if(!(userAccount.equalsIgnoreCase(CAAccount))){
			addIdentifiers(seleniumHost, seleniumPort, browser, webSite, userAccount, identifiersData);
		}
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "expiration Date is blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void expirationDateWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest identifiersData= new HomeLibUnitTest();
		identifiersData.workSheetName="UnitTest_FV_PC_Identifier";
		identifiersData.testCaseId="TC_IDN_006";
		identifiersData.fetchHomeTestData();

		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		if(!(userAccount.equalsIgnoreCase(CAAccount))){
			addIdentifiers(seleniumHost, seleniumPort, browser, webSite, userAccount, identifiersData);
		}
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "expiration Date is blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void expirationDateWithdifferentFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest identifiersData= new HomeLibUnitTest();
		identifiersData.workSheetName="UnitTest_FV_PC_Identifier";
		identifiersData.testCaseId="TC_IDN_007";
		identifiersData.fetchHomeTestData();

		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		if(!(userAccount.equalsIgnoreCase(CAAccount))){
			addIdentifiers(seleniumHost, seleniumPort, browser, webSite, userAccount, identifiersData);
		}
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Group with blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void groupWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest identifiersData= new HomeLibUnitTest();
		identifiersData.workSheetName="UnitTest_FV_PC_Identifier";
		identifiersData.testCaseId="TC_IDN_008";
		identifiersData.fetchHomeTestData();

		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addIdentifiers(seleniumHost, seleniumPort, browser, webSite, userAccount, identifiersData);
	}
	
	/**
	 * addIdentifier
	 * function to add a AddIdentifier Type
	/*************************************************************************************************** 
	* @purpose        To verify Unit test in Identifier section
	* @action 		  verifying Unit test in Identifier section
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 17, 2012
	***************************************************************************************************/
	public boolean addIdentifiers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,HomeLibUnitTest identifiersData) throws IOException{
		Selenium selenium = null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			// Step-1: Login to the application                                   //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + identifiersData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, identifiersData.userName, identifiersData.userPassword);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,identifiersData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//---------------------------------------------------------------------//
			//  Step-3: Navigate to Identifier Group //
			//--------------------------------------------------------------------//
			
			/*assertTrue(click(selenium,lnkSystemSetting),"Could not click the system settings");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkIdentifierGroup),"Could not click on Identifier Group link:" + identifiersData .toString());
			waitForPageLoad(selenium);
			HomeLibUnitTest identifierUnitData= new HomeLibUnitTest();
			identifierUnitData.workSheetName = "IdentifiersAdmin";
			identifierUnitData.testCaseId = "TC_IDA_002";
			identifierUnitData.fetchHomeTestData();
			//---------------------------------------------------------------------//
			//  Step-4: Deleting existing Identifier Groups//
			//--------------------------------------------------------------------//
			int counter=0;
			while(isElementPresent(selenium,"//a[contains(text(),'Delete')]")){
			assertTrue(click(selenium,"//a[contains(text(),'Delete')]"));
			waitForPageLoad(selenium);
			click(selenium,btnYesButton);
			waitForPageLoad(selenium);
			int countAfterDeletion =(Integer) selenium.getXpathCount("//a[contains(text(),'Delete')]");
			if((counter==countAfterDeletion)&&(countAfterDeletion!=0)){
				Assert.fail("Could not Delete the case;More Details:"+identifiersData.toString());
			}
			counter++;
			waitForPageLoad(selenium);
			}
			assertTrue(createIdGroupUnitTests(selenium,identifierUnitData),"Identifier Groups Creation failed");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkIdentifierType),"Could not click on Identifier Group link:" + identifierUnitData .toString());
			waitForPageLoad(selenium);
			//---------------------------------------------------------------------//
			//  Step-5: Deleting existing Identifier Types//
			//--------------------------------------------------------------------//
			int count=0;
			while(isElementPresent(selenium,"//a[contains(text(),'Delete')]")){
			assertTrue(click(selenium,"//a[contains(text(),'Delete')]"));
			waitForPageLoad(selenium);
			click(selenium,btnYesButton);
			waitForPageLoad(selenium);
			int countAfterDeletion =(Integer) selenium.getXpathCount("//a[contains(text(),'Delete')]");
			if((count==countAfterDeletion)&&(countAfterDeletion!=0)){
				Assert.fail("Could not Delete the Identifier Types ;More Details:"+identifiersData.toString());
			}count++;
			waitForPageLoad(selenium);
			}
			assertTrue(createIdTypeUnitTests(selenium,identifierUnitData),"Identifier Types Creation failed");
			click(selenium,btnBackButton);
			waitForPageLoad(selenium);
			*/
			
			//--------------------------------------------------------------------//
			// Step-6: Advanced search with Patient ID
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,identifiersData.patientID);	
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// Step-7: Go to Identifier
			//--------------------------------------------------------------------//
			click(selenium,lnkIdentifier);
			waitForPageLoad(selenium);
			while(waitForElement(selenium,lnkDeleteIdentifier, 5000)){
				assertTrue(click(selenium,lnkDeleteIdentifier),"", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				click(selenium,btnYesButton);
				waitForPageLoad(selenium);
			}
			
			click(selenium,btnAddIdentifier);
			waitForPageLoad(selenium);
			assertTrue(addIdentifier(selenium,identifiersData, userAccount),"Patient Consents failed", selenium, ClassName, MethodName);
			identifiersData.alert = identifiersData.alert== null ? identifiersData.alert = "" : identifiersData.alert.trim();
			if(!identifiersData.alert.equals("")){
			assertTrue(isElementPresent(selenium, identifiersData.alert), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, identifiersData.alert).contains(identifiersData.alertMessage), "The expected validation message should contain the text - "+ identifiersData.alertMessage + " The actual validation message shown - " + getText(selenium, identifiersData.alert), selenium, ClassName, MethodName);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}	
	
	/**
	 * addIdentifier
	 * function to add a Identifier
	 * @throws IOException 
	 * @since  	     Apr 17, 2012
	 */  
	
	public boolean addIdentifier(Selenium selenium, HomeLibUnitTest identifiersData, String userAccount) throws IOException {
		boolean returnValue=false;
		try{
			waitForPageLoad(selenium);
			
			if(identifiersData.testCaseId.equalsIgnoreCase("TC_IDN_008")){
				type(selenium,ajxGroup,identifiersData.group);
			}
			else{
				selectValueFromAjaxList(selenium,ajxGroup,identifiersData.group);
			}
			
			waitForPageLoad(selenium);
			if(userAccount.equalsIgnoreCase(CAAccount)){
				selectValueFromAjaxList(selenium,ajxType,identifiersData.typeCA);
			}
			else{
				selectValueFromAjaxList(selenium,ajxType,identifiersData.type);
			}
			waitForPageLoad(selenium);
			if((identifiersData.type.equalsIgnoreCase("Social Security Number"))||(identifiersData.typeCA.equalsIgnoreCase("Social Insurance Number"))){
				assertTrue(type(selenium,txtValueMask,identifiersData.value),"Could not enter mask ; More Details :"+identifiersData.toString(), selenium, ClassName, MethodName);
			}
			if(identifiersData.type.equalsIgnoreCase("Driver's License Number")){
				assertTrue(enterDate(selenium,txtExpiration,identifiersData.expirationdate),"Could not enter Expire date ; More Details :"+identifiersData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtValueMask,identifiersData.value),"Could not enter mask ; More Details :"+identifiersData.toString(), selenium, ClassName, MethodName);
				
			}
			
			if(identifiersData.testCaseId.contains("TC_IDN_003")){
			    assertTrue(getValue(selenium,txtValueMask).equals(identifiersData.value),"Failed validation field",selenium,ClassName,MethodName);
				return true;
			}
			assertTrue(click(selenium,btnSave),"could not click save button; More Details:"+identifiersData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}

