package com.nexia.selenium.testscripts.section.chartprevisit.TimeLine;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForTimeLine extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib timeLineData = new ChartPreVisitLib();
		timeLineData.workSheetName = "VerifySecurityOption";
		timeLineData.testCaseId = "TC_VSP_001";
		timeLineData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, timeLineData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib timeLineData = new ChartPreVisitLib();
		timeLineData.workSheetName = "VerifySecurityOption";
		timeLineData.testCaseId = "TC_VSP_002";
		timeLineData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, timeLineData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib timeLineData = new ChartPreVisitLib();
		timeLineData.workSheetName = "VerifySecurityOption";
		timeLineData.testCaseId = "TC_VSP_003";
		timeLineData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, timeLineData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib timeLineData = new ChartPreVisitLib();
		timeLineData.workSheetName = "VerifySecurityOption";
		timeLineData.testCaseId = "TC_VSP_004";
		timeLineData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, timeLineData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Security Option For TimeLine
	* @action 		  Verify Security Option For TimeLine
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Aug 26, 2013
	***************************************************************************************************/
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib timeLineData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + timeLineData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, timeLineData.userName, timeLineData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role 									  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,timeLineData.switchRole),"Could not change the switch role;More Details:"+timeLineData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										  //
			//--------------------------------------------------------------------//
			if(timeLineData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
				
				assertTrue(searchPatientNexiaNoAccess(selenium,timeLineData.patientId),"Could search patient", selenium, ClassName, MethodName);
				return true;
			}		
			
			//--------------------------------------------------------------------//
			//  Step-4: Visit the Allergy Link 									  //
			//--------------------------------------------------------------------//		
			if(!timeLineData.testCaseId.equals("TC_VSP_003")){
				  
				searchPatientNexiaForProviderHomePage(selenium,timeLineData.patientId);	
				waitForPageLoad(selenium);	
				assertTrue(click(selenium,lnkPatientOptionsLink),"Could not click the PatientOptions link;", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);							
				if(isElementPresent(selenium, lnkPatientChartView))
				{
					assertTrue(click(selenium,lnkPatientChartView),"Could not click the link;", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);							
				}
				assertTrue(click(selenium,lnkTimeLine),"Could not click the link;", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);							
				
				assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
					
			}													
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option 									  //
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,timeLineData,userAccount)){
				fail("Security option not show properly; More Details :"+ timeLineData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib timeLineData,String account) throws IOException{
		boolean returnValue=true;
	
		if(!isElementPresent(selenium, lnlPrintsend)){
			return false;
		}
		return returnValue;
	}
		
}
