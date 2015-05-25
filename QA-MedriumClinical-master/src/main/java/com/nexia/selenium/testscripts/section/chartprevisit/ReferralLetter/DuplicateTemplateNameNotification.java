package com.nexia.selenium.testscripts.section.chartprevisit.ReferralLetter;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class DuplicateTemplateNameNotification extends AbstractChartPreVisit {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify notification for using an existing name for a template ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void duplicateTemplateNameNotificationTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IR_004";
		letterTemplateTestData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		duplicateTemplateNotification(seleniumHost, seleniumPort, browser, webSite, userAccount,letterTemplateTestData);
	}

	/*************************************************************************************************** 
	 * @purpose       Verify notification for using an existing name for a template 
	 * @action 		  Edit letter template 
	 * @author        Aspire QA
	 * @throws        IOException 
	 * @state         Developing
	 * @useraccount   Both (US and Canada)
	 * @since  	      June 13, 2014	
	 ***************************************************************************************************/

	public boolean duplicateTemplateNotification(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib letterTemplateTestData ) throws IOException{

		Selenium selenium=null;
		boolean returnValue=true;
		String errorMsg = "A Letter Template with the same name already exists";

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
			assertTrue(navigateToLetterTemplate(selenium),"Could not navigate to Letter template page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			if(renameLetterTemplate(selenium,letterTemplateTestData))  {
				fail("Template was renamed successfully. Please provide existing template name");
			} else {
				assertTrue(selenium.isTextPresent(errorMsg), "Not able to find error message- " +errorMsg, selenium, ClassName, MethodName);	
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}
