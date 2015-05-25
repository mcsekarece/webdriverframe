package com.nexia.selenium.testscripts.section.chartprevisit.ReferralLetter;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CreateGroupFieldsWithPunctuation extends AbstractChartPreVisit {	
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify creating Letter template Group fields with punctuation marks.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createGroupFieldsWithPunctuationTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IR_010";
		letterTemplateTestData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		creatingGroupFieldsWithSymbols(seleniumHost, seleniumPort, browser, webSite, userAccount,letterTemplateTestData);
	}
	
	/*************************************************************************************************** 
	 * @purpose        Verify creating/selecting letter template group field with punctuation marks. 
	 * @action 		   Create Group field 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       June 19, 2014	
	 ***************************************************************************************************/

	public boolean creatingGroupFieldsWithSymbols(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib letterTemplateTestData ) throws IOException{

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
			//  Step-3: Navigate to Letter templates page  						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToLetterTemplate(selenium),"Could not navigate to Letter Template page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			

			//--------------------------------------------------------------------//
			//  Step-4: Click Add button used to add a letter template  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddLetterTemplate), "Could not click on add new Letter template button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Create specified Letter template fields    //
			//--------------------------------------------------------------------//
			assertTrue(createAllTemplateField(selenium, letterTemplateTestData.allTemplateFields), "Could not create all specified template field", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-6: Verify if specified Letter template fields present    //
			//--------------------------------------------------------------------//
			assertTrue(verifyIfTemplateFieldsPresent(selenium, letterTemplateTestData.allTemplateFields), "All created/selected template fields not found", selenium, ClassName, MethodName);
			

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}
