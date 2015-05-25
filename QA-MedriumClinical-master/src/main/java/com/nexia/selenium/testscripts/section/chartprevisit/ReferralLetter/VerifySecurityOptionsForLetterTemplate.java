package com.nexia.selenium.testscripts.section.chartprevisit.ReferralLetter;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionsForLetterTemplate extends AbstractChartPreVisit {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify that the users with No access will not be able to access EMR Letter Templates.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionsForNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IR_014";
		letterTemplateTestData.fetchChartPreVisitTestData();
		
		ChartPreVisitLib letterTemplateSecurityData = new ChartPreVisitLib();
		letterTemplateSecurityData.workSheetName = "VerifySecurityOption";
		letterTemplateSecurityData.testCaseId = "TC_VSP_003";
		letterTemplateSecurityData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOptionsForLetterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,letterTemplateTestData,letterTemplateSecurityData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify that the users with Aiew Only access will not be able to edit EMR Letter Templates.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionsForViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IR_014";
		letterTemplateTestData.fetchChartPreVisitTestData();
		
		ChartPreVisitLib letterTemplateSecurityData = new ChartPreVisitLib();
		letterTemplateSecurityData.workSheetName = "VerifySecurityOption";
		letterTemplateSecurityData.testCaseId = "TC_VSP_002";
		letterTemplateSecurityData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOptionsForLetterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,letterTemplateTestData,letterTemplateSecurityData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify that the users with No access can add, edit and delete EMR Letter Templates.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionsForFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IR_014";
		letterTemplateTestData.fetchChartPreVisitTestData();
		
		ChartPreVisitLib letterTemplateSecurityData = new ChartPreVisitLib();
		letterTemplateSecurityData.workSheetName = "VerifySecurityOption";
		letterTemplateSecurityData.testCaseId = "TC_VSP_004";
		letterTemplateSecurityData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOptionsForLetterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,letterTemplateTestData,letterTemplateSecurityData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify that the users with Limited access cannot delete EMR Letter Templates.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionsForLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IR_014";
		letterTemplateTestData.fetchChartPreVisitTestData();
		
		ChartPreVisitLib letterTemplateSecurityData = new ChartPreVisitLib();
		letterTemplateSecurityData.workSheetName = "VerifySecurityOption";
		letterTemplateSecurityData.testCaseId = "TC_VSP_001";
		letterTemplateSecurityData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOptionsForLetterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,letterTemplateTestData,letterTemplateSecurityData);
	}

	/*************************************************************************************************** 
	* @purpose        Verify security for No Access user 
	* @action 		  Access letter template 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      June 23, 2014	
	***************************************************************************************************/
	
	public boolean verifySecurityOptionsForLetterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib letterTemplateTestData, ChartPreVisitLib letterTemplateSecurityData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application 								  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + letterTemplateSecurityData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, letterTemplateSecurityData.userName, letterTemplateSecurityData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Verify Security											  //
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,letterTemplateTestData, letterTemplateSecurityData,userAccount)){
				Assert.fail("Security for" +letterTemplateSecurityData.switchRole+ "is not proper:"+ letterTemplateSecurityData.toString());
			}else
				return returnValue;
						
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySecurity(Selenium selenium, ChartPreVisitLib letterTemplateTestData, ChartPreVisitLib letterTemplateSecurityData, String userAccount) throws IOException {
		boolean returnValue=true;
		
		//No Access Permission
		if(letterTemplateSecurityData.testCaseId.equals("TC_VSP_003")){
			
			//--------------------------------------------------------------------//
			//  Step-3: Switch Role//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,letterTemplateSecurityData.switchRole),"Could not change the switch role;More Details:"+letterTemplateSecurityData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSettings),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, lnkTemplateSetup)){
				return false;
			}
		}else{
			//--------------------------------------------------------------------//
			//  Step-3: Switch Role												  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,"DFFullAccess"),"Could not change the switch role;More Details:"+letterTemplateSecurityData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Letter template  						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToLetterTemplate(selenium),"Could not navigate to Letter Template page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-5: Create New Letter template							  //
			//--------------------------------------------------------------------//
			assertTrue(addNewReferralLetterTemplate(selenium, letterTemplateTestData), "Could not Add new Letter template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Switch Role											      //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,letterTemplateSecurityData.switchRole),"Could not change the switch role;More Details:"+letterTemplateSecurityData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Letter template Page 						  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkSettings), "Could not click on Quick Actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkTemplateSetup), "Could not click on Template Setup", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkLetterTemplate), "Could not click on Letter Template link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Full Access Permission	
			if(letterTemplateSecurityData.testCaseId.equals("TC_VSP_004")){
				assertTrue(selenium.isElementPresent(btnAddLetterTemplate),"Add Letter template not present",selenium, ClassName, MethodName);
				assertTrue(selenium.isElementPresent(lnkTemplateEdits),"Edit Letter template not present",selenium, ClassName, MethodName);
				assertTrue(selenium.isElementPresent(lnkTemplateDeletes),"Delete Letter template not present",selenium, ClassName, MethodName);				
			}
			
			//Limited Access Permission	
			if(letterTemplateSecurityData.testCaseId.equals("TC_VSP_001")){
				assertTrue(selenium.isElementPresent(btnAddLetterTemplate),"Add Letter template not present",selenium, ClassName, MethodName);
				assertTrue(selenium.isElementPresent(lnkTemplateEdits),"Edit Letter template not present",selenium, ClassName, MethodName);
				if(!isElementPresent(selenium,lnkTemplateDeletes)){
					 Assert.fail("Delete Letter template present for Limited access");                      
				}				
			}
		
			//View Only Access Permission
			if(letterTemplateSecurityData.testCaseId.equals("TC_VSP_002")){
				
					if(isElementPresent(selenium,btnAddLetterTemplate)){
						 Assert.fail("Add Letter template not present for View only access");                      
					}
					if(!isElementPresent(selenium,lnkTemplateEdits)){
						 Assert.fail("Edit Letter template present for View only access");            
					}
					if(!isElementPresent(selenium,lnkTemplateDeletes)){
						 Assert.fail("Delete Letter template present for View only access");                      
					}
				
			}
			
			 
		}
		
		return returnValue;
	
	
	}
}
