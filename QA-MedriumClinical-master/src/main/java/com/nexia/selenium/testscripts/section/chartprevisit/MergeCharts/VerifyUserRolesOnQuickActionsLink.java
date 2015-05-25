package com.nexia.selenium.testscripts.section.chartprevisit.MergeCharts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUserRolesOnQuickActionsLink extends AbstractHomeTest {
	@Test(groups = {"Approved","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying merge chart option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUserRolesWithFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "VerifySecurityOption";
	    patientData.testCaseId = "TC_VSP_007";
		patientData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyUserRolesOnQuickActionsLink(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	@Test(groups = {"Approved","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying merge chart option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUserRolesWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "VerifySecurityOption";
	    patientData.testCaseId = "TC_VSP_008";
		patientData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyUserRolesOnQuickActionsLink(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	/**
	 * VerifyUserRolesOnQuickActionsLink
	 * function to verify access on user roles
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    November 10, 2014
	 */
	
	public boolean verifyUserRolesOnQuickActionsLink(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws IOException
	{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//---------------------------------------------------------------------//
			//  Step-2: Verify UserRole is exit or not
			//---------------------------------------------------------------------//
			assertTrue(userRoleValidaitonForChartManagement(selenium,patientData),"Unable to create the user role",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//----------------------------------------------------------------------//
			//  Step-3 switch role
			//----------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patientData.switchRole),"Could not change the switch role;More Details:"+patientData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//----------------------------------------------------------------------//
			//  Step-4: Validate chart Management
			//----------------------------------------------------------------------//
			if(isElementPresent(selenium, btnErrorClose))
			{
			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		    waitForPageLoad(selenium);
			}
			if(patientData.testCaseId.equals("TC_VSP_007"))
			{
			assertTrue(click(selenium,lnkQuickActions),"Could not click on the link" + patientData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkChartMgmt),"Chart management is not found",selenium,ClassName,MethodName);
			}
			if(patientData.testCaseId.equals("TC_VSP_008"))
			{
			assertTrue(click(selenium,lnkQuickActions),"Could not click on the link" + patientData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium,lnkChartMgmt),"Chart management is found",selenium,ClassName,MethodName);
			}
			}catch(RuntimeException e)
			{
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
				return false;
			}
		return true;
	}
}
