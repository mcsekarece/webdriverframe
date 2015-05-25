package com.nexia.selenium.testscripts.section.demographics.HealthCareTeam;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyOrderOfDisplayForPatientStaff extends AbstractHomeTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New Health Care Team")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOrderOfDisplayForPStaff(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib healthTestData = new  HomeLib();
		healthTestData.workSheetName = "EditHealthCareTeam";
		healthTestData.testCaseId = "TC_HCT_007";
		healthTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyOrderOfDisplay(seleniumHost, seleniumPort, browser, webSite, userAccount, healthTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Order Of Display In Health Care Team
	* @action 		  Verifying Order Of Display In Health Care Team
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 21, 2012
	***************************************************************************************************/
	public boolean verifyOrderOfDisplay(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib healthTestData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		String staffOne="";
		String staffTwo="";
		String letterOne="";
		String letterTwo="";
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + healthTestData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, healthTestData.userName, healthTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,healthTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-3: Create role and reason For deletion at Admin section//
			//--------------------------------------------------------------------//
			HomeLib epData = new  HomeLib();
			epData.workSheetName = "AdminHealthCareTeam";
			epData.testCaseId = "TC_HCTA_001";
			epData.fetchHomeTestData();

			//---------------------------------------------------------- ----------//
			//  Step-4:Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,healthTestData.patientID);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-5: Create a new Health Care Team //
			//--------------------------------------------------------------------//
			click(selenium,lnkPatientHealthcare);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-6: Deleting existing Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllHealthCareteam(selenium,epData,userAccount), "Could not delete all health care team ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			//  Step-7: Edit Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit),"Could not click the edit button;More details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajkSuggestBox,healthTestData.teamName);
			waitForPageLoad(selenium);
			type(selenium,txtSearchTextBox,"a ");
			waitForPageLoad(selenium);
			selenium.typeKeys(txtSearchTextBox, "\\b");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblSearchedFirstStaffDisplay)){
				staffOne=getText(selenium,lblSearchedFirstStaffDisplay);
				int position=staffOne.indexOf(" ");
				letterOne=staffOne.substring(position+1);
			}
			if(isElementPresent(selenium,lblSearchedSecondStaffDisplay)){
				staffTwo=getText(selenium,lblSearchedSecondStaffDisplay);
				int position=staffTwo.indexOf(" ");
				letterTwo=staffTwo.substring(position+1);
			}
			if(letterTwo.compareTo(letterOne)>0){
				return returnValue;
			}else
				return false;
			
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
			
			
