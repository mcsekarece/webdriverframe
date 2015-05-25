package com.nexia.selenium.testscripts.section.chartprevisit.ProblemList;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityForProblemList extends AbstractChartPreVisit {
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProblemListWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "VerifySecurityOption";
		proData.testCaseId = "TC_VSP_001";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With View Only User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProblemListWithViewOnly(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "VerifySecurityOption";
		proData.testCaseId = "TC_VSP_002";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProblemListWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "VerifySecurityOption";
		proData.testCaseId = "TC_VSP_003";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProblemListWithFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "VerifySecurityOption";
		proData.testCaseId = "TC_VSP_004";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	/**
	 * verifySecurity
	 * function to verify Security
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 11, 2012
	 */

	public boolean verifySecurity(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + proData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, proData.userName, proData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
		/*	//--------------------------------------------------------------------//
			//  Step-2: Select Role//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,"topMenuHeader"),"Could not click top mean header;More Details:"+proData.toString());
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"switchRoleAction"),"Could not click switch Role link;More Details:"+proData.toString());
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"suggestBox",proData.switchRole);
			click(selenium,"//div[7]/div/div/div/div/div");
			assertTrue(click(selenium,txtdeleteReason),"Could not click the select button:More Details:"+proData.toString());
			waitForPageLoad(selenium);
			*/
			
			assertTrue(switchRole(selenium,proData.switchRole),"Could not change the switch role;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: Search Patient//
			//--------------------------------------------------------------------//
			if(proData.testCaseId.equals("TC_VSP_001")||proData.testCaseId.equals("TC_VSP_004"))
			{
				searchPatientNexiaForProviderHomePage(selenium, proData.patientId);
				waitForPageLoad(selenium);
			}
			
			if(proData.testCaseId.equals("TC_VSP_003")){
				
				if(!verifySecurity(selenium,proData,userAccount)){
					Assert.fail("Security for" +proData.switchRole+ "is not proper:"+ proData.toString());
					returnValue=false;
				}else
					return returnValue;
			}
			
			
			if(proData.testCaseId.equals("TC_VSP_002"))
			{
				searchPatientNexiaForProviderHomePage(selenium, proData.patientId);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkPatientOption),"Unable to click patient options",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium, lnkViewChart))
				{
				assertTrue(click(selenium,lnkViewChart),"Unable to navigate patient chart",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				}
				else
				{
			    assertTrue(click(selenium,lnkPatientOption),"Unable to click patient options",selenium, ClassName, MethodName);
				}
				waitForPageLoad(selenium);
			}			
			if(isElementPresent(selenium, btnErrorClose))
             assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			assertTrue(click(selenium,lnkSummary),"unable to click the chart summary",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Verify Security//
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,proData,userAccount)){
				Assert.fail("Security for" +proData.switchRole+ "is not proper:"+ proData.toString());
				returnValue=false;
			}else
				return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium, ChartPreVisitLib proData,String userAccount) throws IOException{
		boolean returnValue=true;
		//Limited Access
		if(proData.testCaseId.equals("TC_VSP_001")){
			ChartPreVisitLib probData = new ChartPreVisitLib();
			probData.workSheetName = "CreateProblemList";
			probData.testCaseId = "TC_CPL_001";
			probData.fetchChartPreVisitTestData();
			assertTrue(createProblemList(selenium,probData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			if(selenium.isTextPresent("Delete")){
				returnValue=false;
			}else
				return returnValue;
		}
		
		//View Only
		if(proData.testCaseId.equals("TC_VSP_002")){
			if(isElementPresent(selenium,btnAdd)){
			//if(selenium.isVisible(btnAdd)){
				returnValue=false;
			}else
				 returnValue=true;
		}
		
		//No Access
		if(proData.testCaseId.equals("TC_VSP_003")){
			//if(selenium.isTextPresent("An error has occured") || selenium.isTextPresent("No Permission") ){
			if(isElementPresent(selenium,txtMedicatl)){	
				returnValue=false;
			}else
				returnValue=true;
			
		}
		
		//Full Access
		if(proData.testCaseId.equals("TC_VSP_004")){
			ChartPreVisitLib probData = new ChartPreVisitLib();
			probData.workSheetName = "CreateProblemList";
			probData.testCaseId = "TC_CPL_001";
			probData.fetchChartPreVisitTestData();
			assertTrue(createProblemList(selenium,probData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			if(isElementPresent(selenium,btnDelete)){
				returnValue=true;
			}else
			returnValue=false;
		}
		return returnValue;
	}
}

