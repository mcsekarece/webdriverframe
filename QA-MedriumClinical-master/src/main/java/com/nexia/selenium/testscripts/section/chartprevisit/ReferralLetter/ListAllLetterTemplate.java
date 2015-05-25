package com.nexia.selenium.testscripts.section.chartprevisit.ReferralLetter;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class ListAllLetterTemplate extends AbstractChartPreVisit {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify listing of all Letter template ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void listAllLetterTemplateTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IR_002";
		letterTemplateTestData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		listingReferralLetterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount,letterTemplateTestData);
	}

	/*************************************************************************************************** 
	* @purpose        Verify listing of all Letter template 
	* @action 		  Edit letter template 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      June 16, 2014	
	***************************************************************************************************/
	
	public boolean listingReferralLetterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib letterTemplateTestData ) throws IOException{
		
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
			assertTrue(switchRole(selenium,letterTemplateTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Letter template screen  						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToLetterTemplate(selenium),"Could not navigate to Letter Template page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Click Show all button 						  //
			//--------------------------------------------------------------------//						
			assertTrue(click(selenium,chkShowAllTemplates), "Could not click Show All checkbox", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Get count of all templates listed 						  //
			//--------------------------------------------------------------------//
			int templatesCount = (Integer) selenium.getXpathCount(lblLetterTemplates);
			System.out.println("Total number of templated listed is " +templatesCount);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}
