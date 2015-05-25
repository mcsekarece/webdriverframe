package com.nexia.selenium.testscripts.section.chartprevisit.EMRSecurity;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CreateEmergencyAccessForAUser extends AbstractChartPreVisit {	

	@Test(groups = {"AdvancedSmoke","Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify that Security Admin can setup emergency access for particular user")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createEmergencyAccessForAUserTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib providerData = new ChartPreVisitLib();
		providerData.workSheetName = "EMRSecurity";
		providerData.testCaseId = "TC_ES_003";
		providerData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyEmergencyAccessForAUser(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to verify that Security Admin can setup emergency access for particular user 
	 * @Specification  TCH-5 - Improve Security in Nexia 
	 * @action 		   Provide emergency access for particular user
	 * @expected       User with emergency access should be listed in Emergency Access page
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       May 29, 2014
	 ***************************************************************************************************/

	public boolean verifyEmergencyAccessForAUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib providerData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;

		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,providerData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Enable Emergency Access for specified provider//
			//--------------------------------------------------------------------//
			assertTrue(enableEmergencyAccessForUser(selenium, providerData),"Could not enable Emergency access for user " +providerData.provider, selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify user is added//
			//--------------------------------------------------------------------//
			if(validateIfUserHasEmergencyAccess(selenium, providerData.provider))
				return returnValue;
			else
				Assert.fail("Not able to provide Emergency Access to user successfully");		

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}

	private boolean validateIfUserHasEmergencyAccess(Selenium selenium, String userName) throws IOException {
		Boolean textFound = false;

		//Check if control is in Emergency Access Page
		assertTrue(selenium.isTextPresent("Emergency Access"), "Could not find text Emergency Access", selenium, ClassName, MethodName);

		String providerName[] = userName.split(",");
		for (int i = 0; i < providerName.length; i++) {
			assertTrue(selenium.isTextPresent("regexpi:"+providerName[i]), "Could not find text " +providerName[i], selenium, ClassName, MethodName);
		}
		textFound = true;
	
		return textFound;

	}

}

