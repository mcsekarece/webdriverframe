package com.nexia.selenium.testscripts.section.chartprevisit.ReferralLetter;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CopyReferralLetterTemplate extends AbstractChartPreVisit { 
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify copy operation of Letter template ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void copyReferralLetterTemplateTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IR_003";
		letterTemplateTestData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		copyOfReferralLetterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,letterTemplateTestData);
	}

	/*************************************************************************************************** 
	* @purpose        Verify copy operation of Letter template
	* @action 		  Letter Template copy
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      June 10, 2014	
	***************************************************************************************************/
	
	public boolean copyOfReferralLetterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib letterTemplateTestData ) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		String targetTemplateName;

		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application 								  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + letterTemplateTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, letterTemplateTestData.userName, letterTemplateTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,letterTemplateTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Letter template  						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToLetterTemplate(selenium),"Could not navigate to Letter Template page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			targetTemplateName = letterTemplateTestData.templateNameToCopy;
			assertTrue(copyLetterTemplate(selenium, letterTemplateTestData), "Could not copy letter template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify if renamed Letter template exists							  //
			//--------------------------------------------------------------------//
			assertTrue(verifyIfLetterTemplateExits(selenium,targetTemplateName), "The template " +targetTemplateName+ " not exits", selenium, ClassName, MethodName);				
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	private boolean copyLetterTemplate(Selenium selenium, ChartPreVisitLib letterTemplateTestData) throws IOException {
		boolean result = true;
		String lnkTemplateCopy = "";
		
		int templateIndex = getIndexOfLetterTemplate(selenium, letterTemplateTestData.letterTemplateName);
		if( templateIndex == 0 ){
			System.out.println("The Letter template with name " + letterTemplateTestData.letterTemplateName + " not found");
			assertTrue(addNewReferralLetterTemplate(selenium,letterTemplateTestData), "Could not create new referral letter template", selenium, ClassName, MethodName);
		}else
			System.out.println("The Letter template with name " + letterTemplateTestData.letterTemplateName + " is "+templateIndex);
		
		lnkTemplateCopy = lnkTemplateCopys + "[" +templateIndex+ "]";
		
		assertTrue(click(selenium,lnkTemplateCopy),"Could not click Edit link.", selenium , ClassName, MethodName);		
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtLetterTemplateName,letterTemplateTestData.templateNameToCopy),"Could not type template name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		assertTrue(selectValueFromAjaxList(selenium, ajxPageSize,letterTemplateTestData.templatePageSize), "Could not select Page Size in add Day sheet template", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		assertTrue(selectValueFromAjaxList(selenium, ajxTemplateType, letterTemplateTestData.templateType), "Could not select Template Type in add Day sheet template", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		assertTrue(click(selenium, btnSave ), "Could not click Save button in the popup", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		
		if (isElementPresent(selenium, ajxTemplateType)) {
			System.out.println("User is not navigated to Letter Templates list page after clicking Save button");
			result = false;
		}	

		return result;
	}
	
}
