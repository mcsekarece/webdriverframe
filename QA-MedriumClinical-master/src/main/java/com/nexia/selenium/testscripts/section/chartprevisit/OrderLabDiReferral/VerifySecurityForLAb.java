package com.nexia.selenium.testscripts.section.chartprevisit.OrderLabDiReferral;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;



public class VerifySecurityForLAb extends AbstractChartPreVisit{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying the security of Lab ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityForFullAcces(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateLabOrder";
		orderData.testCaseId = "TC_OL_011";
		orderData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying the security of Lab  ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityForViewOnly(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateLabOrder";
		orderData.testCaseId = "TC_OL_012";
		orderData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying the security of Lab ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityForNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateLabOrder";
		orderData.testCaseId = "TC_OL_013";
		orderData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying the security of Lab ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityForLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateLabOrder";
		orderData.testCaseId = "TC_OL_014";
		orderData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}	
	/**
		 * verifySecurity of Lab
		 *function to verify Security for DI
		 * @param 		seleniumHost
		 * @param 		seleniumPort
		 * @param 		browser
		 * @param 		webSite
		 * @throws IOException 
		 * @since  	   July 1,2014
		 */
	
	public boolean verifySecurity(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + orderData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, orderData.userName, orderData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,orderData.switchRole), "could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//verify ViewOnly		
			
			if(orderData.testCaseId.contains("TC_OL_012"))
			{	
				searchPatientNexiaForProviderHomePage(selenium,orderData.patientId);
				waitForPageLoad(selenium);
				assertTrue(!isElementVisible(selenium,btnBeginEncounter),"For View only Access Begin Encounter Button Should not be Visible", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				return true;
			}
			//verify NoAccess
			
			if(orderData.testCaseId.contains("TC_OL_013"))
			{	assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			assertTrue(searchPatientNexiaNoAccess(selenium,orderData.patientId),"Could search patient", selenium, ClassName, MethodName);		
				return true;
			}
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,orderData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Encounter from Encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
						
			//--------------------------------------------------------------------//
			//  Step-4: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete Existing Lab Orders//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteOrders(selenium,orderData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Lab Order Page//
			//--------------------------------------------------------------------//
			assertTrue(clickLabIcon(selenium,orderData),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Create Lab Order Page//
			//--------------------------------------------------------------------//
			
			/*if(orderData.testCaseId.contains("TC_OL_014"))
			{
				assertTrue(!isElementVisible(selenium,btnOrderNewSign),"Navigation Failed", selenium, ClassName, MethodName);
			}*/
			assertTrue(orderNewLabs(selenium,orderData),"Order Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify Security 											//
			//--------------------------------------------------------------------//
			if(orderData.testCaseId.contains("TC_OL_011"))
			{
				assertTrue(click(selenium,lblDiOrderEditIcon),"Could not Click on Added Lab in Recommendation and plan section", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);		
				assertTrue(VerifyFullAccess(selenium),"Verification for full access is failed", selenium, ClassName, MethodName);
				
			}	
			if(orderData.testCaseId.contains("TC_OL_014"))
			{
				assertTrue(click(selenium,lblDiOrderEditIcon),"Could not Click on Added Lab in Recommendation and plan section", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(VerifyLimitedAccess(selenium),"Verification for Limited  access is failed", selenium, ClassName, MethodName);
			}
		}
	
	catch(Exception e)
	{
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);

	}
		return true;
		
	}
	
public boolean VerifyFullAccess(Selenium selenium)
{
	if(!isElementPresent(selenium,btnEditLab))	{
		return false;
	}
	if(!isElementPresent(selenium,btnDeleteLabOrder))	{
		return false;
	}
	return true;
}
	
public boolean VerifyLimitedAccess(Selenium selenium)
{
	if(!isElementPresent(selenium,btnEditLab))	{
		return false;
	}
	if(isElementPresent(selenium,btnDeleteLabOrder))	{
		return false;
	}
	return true;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
