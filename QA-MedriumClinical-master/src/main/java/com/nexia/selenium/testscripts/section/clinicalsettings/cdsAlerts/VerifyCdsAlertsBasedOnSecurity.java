package com.nexia.selenium.testscripts.section.clinicalsettings.cdsAlerts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCdsAlertsBasedOnSecurity extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		ChartPreVisitLib cdsData = new ChartPreVisitLib();
		cdsData.workSheetName = "VerifySecurityOption";
		cdsData.testCaseId = "TC_VSP_001";
		cdsData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite,userAccount, cdsData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		ChartPreVisitLib cdsData = new ChartPreVisitLib();
		cdsData.workSheetName = "VerifySecurityOption";
		cdsData.testCaseId = "TC_VSP_002";
		cdsData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite,userAccount, cdsData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		ChartPreVisitLib cdsData = new ChartPreVisitLib();
		cdsData.workSheetName = "VerifySecurityOption";
		cdsData.testCaseId = "TC_VSP_003";
		cdsData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite,userAccount, cdsData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		ChartPreVisitLib cdsData = new ChartPreVisitLib();
		cdsData.workSheetName = "VerifySecurityOption";
		cdsData.testCaseId = "TC_VSP_004";
		cdsData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite,userAccount, cdsData);
	}
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 11, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, ChartPreVisitLib cdsData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + cdsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, cdsData.userName, cdsData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-2: Navigate to CDS//
			//--------------------------------------------------------------------//
			
			navigateToCDSCheck(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Change the switch role //
			//--------------------------------------------------------------------//			
			assertTrue(switchRole(selenium,cdsData.switchRole),"Could not change the switch role;More Details:"+cdsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify security option //
			//--------------------------------------------------------------------//
		
			assertTrue(type(selenium,txtPatientBox,cdsData.patientId),"Could not type patient id", selenium, ClassName, MethodName);
		
			selenium.keyPress(txtPatientBox, "\\9");
			
			selenium.clickAt("searchPatientBox","");
			selenium.focus("searchPatientBox");			
			selenium.fireEvent("searchPatientBox","keypress");
			
			waitForElement(selenium,lblPatientResult,10000);
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+cdsData.patientId, selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(cdsData.patientId.trim().toLowerCase(new java.util.Locale("en","US"))),"", selenium, ClassName, MethodName);
			//assertTrue(getText(selenium,lblPatientResult).contains(patientID));
			click(selenium,lblPatientResult);
			waitForPageLoad(selenium);
			
			
			if(!verifySecurity(selenium,cdsData)){
				Assert.fail("Security option not show properly; More Details :"+ cdsData.toString());
				returnValue= false;
			}else
				returnValue=true;
			}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib cdsData){
		boolean returnValue=true;
		if(cdsData.testCaseId.equals("TC_VSP_009")){
			if(isElementPresent(selenium,chkdoNotShowAgaincheckbox)){
				return false;
			}else
				 return true;
			
		}
		if(cdsData.testCaseId.equals("TC_VSP_006")){
			if(isElementPresent(selenium,chkdoNotShowAgaincheckbox)){
				returnValue= true;
			}else
				returnValue= false;
			click(selenium,btnCloseAlert);
			if(!isElementPresent(selenium,lblpatientname))
				returnValue= false;
			else
				returnValue=true;
			return returnValue;
		}
		if(cdsData.testCaseId.equals("TC_VSP_007")){
			if(isElementPresent(selenium,chkdoNotShowAgaincheckbox)){
				returnValue=true;
			}else
				returnValue=false;
			click(selenium,btnCloseAlert);
			if(!isElementPresent(selenium,lblpatientname))
				returnValue= false;
			else
				returnValue=true;
			return returnValue;
		}
		if(cdsData.testCaseId.equals("TC_VSP_008")){
			if(isElementPresent(selenium,chkdoNotShowAgaincheckbox)){
				 returnValue=true;
			}else
				 returnValue=false;
			click(selenium,btnCloseAlert);
			if(!isElementPresent(selenium,lblpatientname))
				returnValue= false;
			else
				returnValue=true;
			return returnValue;
		}
		return returnValue;
	}
}
