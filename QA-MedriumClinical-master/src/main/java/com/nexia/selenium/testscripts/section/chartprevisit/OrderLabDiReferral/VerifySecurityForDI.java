package com.nexia.selenium.testscripts.section.chartprevisit.OrderLabDiReferral;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityForDI extends AbstractChartPreVisit{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying the Security of DI")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityForFullAcces(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateDiganosticImaging";
		orderData.testCaseId = "TC_ODI_009";
		orderData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying the Security of DI  ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityForViewOnly(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateDiganosticImaging";
		orderData.testCaseId = "TC_ODI_012";
		orderData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying the Security of DI  ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityForNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateDiganosticImaging";
		orderData.testCaseId = "TC_ODI_011";
		orderData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}	


	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying the Security of DI ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityForLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateDiganosticImaging";
		orderData.testCaseId = "TC_ODI_010";
		orderData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}	
	/**
	 * verifySecurity of DI
	 * function to verify Security for DI
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	   July 1,2014
	 */


	public boolean verifySecurity(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{

		Selenium selenium=null;

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
			//verify ViewOnly		

			if(orderData.testCaseId.contains("TC_ODI_012"))
			{	
				searchPatientNexiaForProviderHomePage(selenium,orderData.patientId);
				waitForPageLoad(selenium);
				assertTrue(!isElementVisible(selenium,btnBeginEncounter),"For View only Access Begin Encounter Button Should not be Visible", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				return true;
			}
			//verify NoAccess

			if(orderData.testCaseId.contains("TC_ODI_011"))
			{	
	        /*****************UPDATE Security case as per the nexia permission Structure document *********************/		
			assertTrue(click(selenium,lnkQuickAction),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,lnknewPatientAction),"Patient Registration not present in quick actions",selenium,ClassName,MethodName);
			searchPatientNexiaForProviderHomePage(selenium,orderData.patientId);
			assertTrue(!isElementPresent(selenium,imgLabOrderIcon),"Lab Icon present in the no user access profile",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//assertTrue(selenium.isTextPresent("No Permission"),"No Permission Present",selenium, ClassName, MethodName);
			//assertTrue(selenium.isTextPresent("An error has occurred")," Error Message Present",selenium, ClassName, MethodName);
			//	assertTrue(searchPatientNexiaNoAccess(selenium,orderData.patientId),"Could search patient", selenium, ClassName, MethodName);		
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
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,orderData),"", selenium, ClassName, MethodName); 

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
			assertTrue(selenium.isVisible(imgDiOrderIcon),"link is not visible", selenium, ClassName, MethodName);
			assertTrue(clickDiIcon(selenium,orderData),"Navigation Failed", selenium, ClassName, MethodName);
			if(orderData.testCaseId.contains("TC_ODI_010"))
			{
				assertTrue(!isElementVisible(selenium,btnSignDiagnostic),"Navigation Failed", selenium, ClassName, MethodName);			
				waitForPageLoad(selenium);
			}		
			//--------------------------------------------------------------------//
			//  Step-7: Create Lab Order Page//
			//--------------------------------------------------------------------//

			assertTrue(orderNewDi(selenium,orderData),"Order Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-8: Verify Security 											//
			//--------------------------------------------------------------------//
			if(orderData.testCaseId.contains("TC_ODI_009"))
			{
				assertTrue(click(selenium,lblEncounterData),"Could not Click on Added Lab in Recommendation and plan section", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);		
				assertTrue(VerifyFullAccess(selenium),"Verification for full access is failed", selenium, ClassName, MethodName);

			}	
			if(orderData.testCaseId.contains("TC_ODI_010"))
			{
				assertTrue(click(selenium,lblEncounterData),"Could not Click on Added Lab in Recommendation and plan section", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);		
				assertTrue(VerifyLimitesAccess(selenium),"Verification for Limited  access is failed", selenium, ClassName, MethodName);

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
	public boolean VerifyLimitesAccess(Selenium selenium) throws IOException
	{
		assertTrue(isElementPresent(selenium,btnEditLab),"Element Not Present", selenium, ClassName, MethodName);
		return true;
	}

}
