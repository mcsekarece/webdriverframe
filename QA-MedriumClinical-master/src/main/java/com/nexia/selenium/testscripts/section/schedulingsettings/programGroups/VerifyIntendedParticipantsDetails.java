package com.nexia.selenium.testscripts.section.schedulingsettings.programGroups;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyIntendedParticipantsDetails extends AbstractSchedulingTest{
	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Verifying Intended Participants Details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyParticipants(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ProgramGroupAdmin";
		pDGData.testCaseId = "TC_PDG_001";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyScheduleSeriesPopUp(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Intended Participants Details
	* @action 		  verify Intended Participants Details
	* @expected       To Ensure that the Intended Participants Details works fine 
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES /   & SRS_ADMIN_PDG_Rev 0.0 
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 16, 2013
	***************************************************************************************************/
	public boolean verifyScheduleSeriesPopUp(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib pDGData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pDGData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, pDGData.userName, pDGData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
	
	
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pDGData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate To Progarm Group						  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Could not navigate to Calender Setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkProgramGroup), "could not able to click the Program group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAdd),"Could not click add new button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
				
			selectValueFromAjaxList(selenium,ajxProgramType,"Personal Development");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Age Group Details			  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkageGroup),"Could not click Age Group Link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.isTextPresent("adults (35-49 years)"),"adults (35-49 years) is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("babies (0-18 months)"),"babies (0-18 months) is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("general population"),"general populationis not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("older adults (50-64 years)"),"older adults (50-64 years)is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("older youth (15-19 years)"),"older youth (15-19 years)is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("older youth (15-19 years)"),"older youth (15-19 years)is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("preschool children (19 months-4 years)"),"preschool children (19 months-4 years)is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("school age children (5-9 years)"),"school age children (5-9 years)is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("young adults (20-34 years"),"seniors (65 years and over)is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("younger youth (10-14 years)"),"adults (35-49 years)is not present",selenium,ClassName, MethodName);
			
			assertTrue(click(selenium,imgPlanClose),"Could not click Age Group Link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Gender Details			  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkGender),"Could not click Gender Link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxProgramType,pDGData.programType);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.isTextPresent("both sexes"),"both sexes is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("female"),"female is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("male"),"male not present",selenium,ClassName, MethodName);
			
			
			assertTrue(click(selenium,imgPlanClose),"Could not click Gender Link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify role Identity or Status Details			  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,inkRole),"Could not click Gender Link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.isTextPresent("business people"),"business people is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("caregivers"),"caregivers is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("community leaders"),"community leaders not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("community members"),"community members is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("community volunteers"),"community volunteers is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("community leaders"),"community leaders not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("criminal offenders"),"criminal offenders is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("employees"),"employees is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("employers"),"employers not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("expectant parents"),"expectant parents is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("family members"),"family members is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("gays/lesbians"),"gays/lesbian is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("health providers"),"health providers is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("immigrants"),"immigrants is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("newcomers"),"newcomers is  not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("new parents"),"new parents is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("persons without a health card"),"persons without a health card is  not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("refugees"),"refugees is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("single parent"),"single parent is  not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("students"),"students is not present",selenium,ClassName, MethodName);
			
			assertTrue(click(selenium,imgPlanClose),"Could not close the Role",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify social demo Details			  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSocial),"Could not click Social Link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.isTextPresent("environmental polution"),"environmental polution is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("homelessness"),"homelessness is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("inadequate housing"),"inadequate housing not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("language/cultural barrier"),"language/cultural barrier is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("low income/poverty"),"low income/poverty is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("low literacy"),"low literacy not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("occupational/workplace risks"),"occupational/workplace risks is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("racism/discrimination"),"racism/discrimination is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("social isolation"),"social isolation not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("underemployment"),"underemployment is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("unemployment"),"unemployment is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("violence/abuse"),"violence/abuse is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("victims of violence/abuse"),"health providersvictims of violence/abuse is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("witnesses of violence/abuse"),"witnesses of violence/abuse is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("perpetrators of violence/abuse"),"perpetrators of violence/abuse is  not present",selenium,ClassName, MethodName);
			
			
			assertTrue(click(selenium,imgPlanClose),"Could not close the Role",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
		}
		catch(RuntimeException e){
			e.printStackTrace();
			
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
