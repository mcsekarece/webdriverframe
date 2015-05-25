package com.nexia.selenium.testscripts.section.demographics.patientCheckinInfo;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class VerifyCustomMandatoryFieldInPatientCheckInfo extends AbstractHomeTest{
	@Test(groups ={"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Health Care Team")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createMandatoryField(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLibUnitTest mandatoryData = new HomeLibUnitTest();
		mandatoryData.workSheetName="UnitTest_FV_CM_Field";
		mandatoryData.testCaseId="TC_CMF_001";
		mandatoryData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createCustomMandatoryField(seleniumHost, seleniumPort, browser, webSite, userAccount, mandatoryData);
	}
	 
	/*************************************************************************************************** 
	* @purpose        To verify create Custom MandatoryField
	* @action 		  verifying create Custom MandatoryField
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      June 19, 2012
	***************************************************************************************************/
	public boolean createCustomMandatoryField(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLibUnitTest mandatoryData) throws Exception{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mandatoryData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, mandatoryData.userName, mandatoryData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,mandatoryData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to Mandatory User Field//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkQuickLink),"Could not click Quick Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSystemSetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click on Health Care Team link:" + mandatoryData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-4: Deleting existing Mandatory User Field //
			//--------------------------------------------------------------------//
			int count=(Integer) selenium.getXpathCount(lnkDeleteMandatoryUserFields);
			while(isElementPresent(selenium,"//div[@id='adminMandatoryUserFieldList']/table/tbody/tr["+count+"]/td[2]/div/a")){
				waitForPageLoad(selenium);
				click(selenium,"//div[@id='adminMandatoryUserFieldList']/table/tbody/tr["+count+"]/td[2]/div/a");
				waitForPageLoad(selenium);
				click(selenium,btnYesButton);
				waitForPageLoad(selenium);
				count--;
			}
			
			//---------------------------------------------------------- ----------//
			//  Step-5: Add a new External Provider //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddExtnalProvider),"Could not click the add mandatory button;More Details:"+mandatoryData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createMandatoryUserfields(selenium,mandatoryData),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			// Step-6: Search Patient Nexia//
			//--------------------------------------------------------------------//
			
			mandatoryData.workSheetName = "UnitTest_FV_PC_Info";
			mandatoryData.testCaseId = "TC_FV_CMF_001";
			mandatoryData.fetchHomeTestData();
			waitForPageLoad(selenium);
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickLink),"Could not click Quick Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkRegisterPatient),"Could not click Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: create Patient Info //
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtLastName,mandatoryData.lastName),"Could not type the last name;More Details:"+mandatoryData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtFirstName,mandatoryData.firstName),"Could not type the last name;More Details:"+mandatoryData.toString(), selenium, ClassName, MethodName);
			selectEmptyValueFromAjaxList(selenium, ajxStatus, mandatoryData.status);
			selectEmptyValueFromAjaxList(selenium,ajxLiveArrangements,mandatoryData.livingArrangement);
			assertTrue(click(selenium,btnSave1),"Could not click the save button;More Details:"+mandatoryData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify Custom Mandatory Field //
			//--------------------------------------------------------------------//
			selenium.mouseOver(ajxLiveArrangements);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium, mandatoryData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, mandatoryData.validationFieldID).contains(mandatoryData.validationMessage), "The expected validation message should contain the text - "+ mandatoryData.validationMessage + " The actual validation message shown - " + getText(selenium, mandatoryData.validationFieldID), selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-9: Go to System Settings and navigate to Mandatory User Field//
			//--------------------------------------------------------------------//
			click(selenium,btnCancel);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickLink),"Could not click Quick Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSystemSetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click on Health Care Team link:" + mandatoryData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-10: Deleting existing Mandatory User Field //
			//--------------------------------------------------------------------//
			int counter=(Integer) selenium.getXpathCount(lnkDeleteMandatoryUserFields);
			while(isElementPresent(selenium,"//div[@id='adminMandatoryUserFieldList']/table/tbody/tr["+counter+"]/td[2]/div/a")){
				waitForPageLoad(selenium);
				click(selenium,"//div[@id='adminMandatoryUserFieldList']/table/tbody/tr["+counter+"]/td[2]/div/a");
				waitForPageLoad(selenium);
				click(selenium,btnYesButton);
				waitForPageLoad(selenium);
				counter--;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
		
	}
}
