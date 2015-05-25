package com.nexia.selenium.testscripts.section.chartprevisit.Vitals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionsForVitals extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "VerifySecurityOption";
		vitalsData.testCaseId = "TC_VSP_001";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "VerifySecurityOption";
		vitalsData.testCaseId = "TC_VSP_002";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "VerifySecurityOption";
		vitalsData.testCaseId = "TC_VSP_003";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "VerifySecurityOption";
		vitalsData.testCaseId = "TC_VSP_004";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 29, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib vitalsData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + vitalsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, vitalsData.userName, vitalsData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,vitalsData.switchRole),"Could not change the switch role;More Details:"+vitalsData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
							
			if(vitalsData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
				assertTrue(searchPatientNexiaNoAccess(selenium,vitalsData.patientId),"Could search patient", selenium, ClassName, MethodName);				
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Visit the Vital Link									  //
			//--------------------------------------------------------------------//		
			
			if(!vitalsData.testCaseId.equals("TC_VSP_003")){
				  
				searchPatientNexiaForProviderHomePage(selenium,vitalsData.patientId);	
				waitForPageLoad(selenium);
				//goToBeginEncounter(selenium);
				assertTrue(click(selenium,lnkVitals),"Could not click the Allergy link;More Details",selenium,ClassName,MethodName);		
				waitForPageLoad(selenium);							
					
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);			
			}		
			
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,vitalsData)){
				Assert.fail("Security option not show properly; More Details :"+ vitalsData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib vitalsData) throws IOException {
		//Limited Access
		waitForPageLoad(selenium);	
		if(vitalsData.testCaseId.equals("TC_VSP_001")){
			vitalsData.workSheetName = "CreateVitals";
			vitalsData.testCaseId = "TC_CV_001";
			vitalsData.fetchChartPreVisitTestData();
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkVitals),"Could not click the Vital link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(addVitals(selenium,vitalsData),"Vitals Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(getText(selenium, btnAdd).equalsIgnoreCase(btnUpdate))
				return true;
			else
				return false;
		}
		//View Only
		if(vitalsData.testCaseId.equals("TC_VSP_002")){
			waitForPageLoad(selenium);
			if(selenium.isElementPresent(btnAdd)||selenium.isElementPresent("heightSuggestBoxsuggestBox")){
			   return false;
			}else
				return true;
		}
		
		//Full Access
		if(vitalsData.testCaseId.equals("TC_VSP_004")){vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_001";
		vitalsData.fetchChartPreVisitTestData();
		waitForPageLoad(selenium);
		assertTrue(addVitals(selenium,vitalsData),"Vitals Creation failed",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		if(getText(selenium, btnAdd).equalsIgnoreCase(btnUpdate))
			return true;
		else
			return false;
		}
		return true;
	}
}
