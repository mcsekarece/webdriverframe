package com.nexia.selenium.testscripts.section.smoketest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.smoketest.SmokeTestLib;
import com.nexia.selenium.genericlibrary.smoketest.AbstractSmokeTest;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForSmoke extends AbstractSmokeTest{
	@Test(groups = {"Smoke","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SmokeTestLib consentData = new SmokeTestLib();
		consentData.workSheetName = "VerifySecurityOption";
		consentData.testCaseId = "TC_VSP_001";
		consentData.fetchSmokeTestData();		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, consentData);
	}
	
	
	/*@Test(groups = {"Smoke","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SmokeTestLib consentData = new SmokeTestLib();
		consentData.workSheetName = "VerifySecurityOption";
		consentData.testCaseId = "TC_VSP_004";
		consentData.fetchSmokeTestData();		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, consentData);
	}*/
	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 05, 2012
	 */
	
  public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SmokeTestLib consentData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + consentData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, consentData.userName, consentData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,consentData.switchRole),"Could not change the switch role;More Details:"+consentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkSettings),"Could not click on the link" + consentData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemsetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifySecurity(selenium,consentData)){
				Assert.fail("Security option not show properly; More Details :"+ consentData.toString());
				returnValue= false;
			}else
				returnValue=true;
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SmokeTestLib consentData) throws IOException{
		//boolean returnValue=true;
		
		if(consentData.testCaseId.equals("TC_VSP_001")){
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Various Sections except Directores and Import Patient//
			//--------------------------------------------------------------------//			
			
			assertTrue(click(selenium,"!adminOrgStructureLists"),"Could not click the Organizational Structure", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Practices"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Programs"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"could not find text",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"could not find text",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!adminMandatoryUserField"),"Could not click the Mandatory User Field", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Mandatory Field"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"could not find text", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!adminAddressBookList"),"Could not click the Address Book",selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Manage Address Book"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"could not find text", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!adminExternalProviderList"),"Could not click the External Provider",selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Referring Providers"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"could not find text", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!adminIdentifierGroupList"),"Could not click the Identifier Groups", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Identifier Groups"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"could not find text", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!adminIdentifierTypeList"),"Could not click the Identifier Types", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Identifier Types"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"could not find text", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!enterpriseID"),"Could not click the Enterprise Variables", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Enterprise Variables"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"could not find text", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!adminHealthcareTeamList"),"Could not click the Healthcare Team", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Healthcare Team Administration"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"could not find text", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}
		
		if(consentData.testCaseId.equals("TC_VSP_004")){
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to All Sections //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,"!adminOrgStructureLists"),"Could not click the Organizational Structure", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Practices"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Programs"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"could not find ext", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"could not find text", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			
			assertTrue(click(selenium,"!adminMandatoryUserField"),"Could not click the Mandatory User Field", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Mandatory field"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"could not find text", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			assertTrue(click(selenium,"!adminAddressBookList"),"Could not click the Address Book", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Manage Address Book"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"could not find text", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!adminPayerList"),"Could not click the Directories", selenium, ClassName, MethodName);			
			assertTrue(isTextPresent(selenium,"Manage Directories"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"could not find text", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!adminExternalProviderList"),"Could not click the External Provider", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"External Providers"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"could not find text", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!adminIdentifierGroupList"),"Could not click the Identifier Groups", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Identifier Groups"),"could not find text",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"could not find text", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!adminIdentifierTypeList"),"Could not click the Identifier Types", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Identifier Types"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"could not find text", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!enterpriseID"),"Could not click the Enterprise Variables", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Enterprise Variables"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"could not find text", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!adminHealthcareTeamList"),"Could not click the Healthcare Team", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Healthcare Team Administration"),"could not find text", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"could not find text",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"could not find text", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!importChart"),"Could not click the Import Patient", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,"Electronic data import"),"could not find text",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"could not find text",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"could not find text", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}		
		return true;
	}	
}
