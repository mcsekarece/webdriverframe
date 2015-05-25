package com.nexia.selenium.testscripts.section.chartprevisit.ReferralLetter;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class AddReferralLetterTemplate extends AbstractChartPreVisit {

	@Test(groups = {"Smoke","Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test to create Referral Letter template ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addLetterTemplateTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IR_006";
		letterTemplateTestData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		createReferralLetterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,letterTemplateTestData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for creating Referral letter template with same field twice on a template ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addLetterTemplateWithSameFieldTwiceTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IR_013";
		letterTemplateTestData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		createReferralLetterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,letterTemplateTestData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for creating Consult letter template. ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addConsultLetterTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IR_015";
		letterTemplateTestData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		createReferralLetterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,letterTemplateTestData);
	}

	/*************************************************************************************************** 
	 * @purpose        Creating a new referral letter template 
	 * @action 		   Edit letter template 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       June 16, 2014	
	 ***************************************************************************************************/

	public boolean createReferralLetterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib letterTemplateTestData ) throws IOException{

		Selenium selenium=null;
		boolean returnValue=true;
		
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
			assertTrue(switchRole(selenium,"FULL"),"unable to switch the user role",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(switchRole(selenium,letterTemplateTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Letter template  						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToLetterTemplate(selenium),"Could not navigate to Letter Template page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			

			//--------------------------------------------------------------------//
			//  Step-4: Add new Referral Letter template  						  //
			//--------------------------------------------------------------------//
			assertTrue(addNewReferralLetterTemplate(selenium,letterTemplateTestData), "Could not create new referral letter template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Verify if presence of newly created Letter template. //
			//--------------------------------------------------------------------//
			assertTrue(verifyIfLetterTemplateExits(selenium,letterTemplateTestData.letterTemplateName), "The template " +letterTemplateTestData.letterTemplateName+ " not exits", selenium, ClassName, MethodName);

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}
