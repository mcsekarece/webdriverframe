package com.nexia.selenium.testscripts.section.demographics.Referral;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestNewPatientCheckinReferral extends AbstractHomeTest{
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "suggestboxWithBlankspace")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void suggestboxWithBlankspace(String seleniumHost, int seleniumPort,String browser, String webSite) throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_001";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );	
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "referredFromWithBlankspace")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void referredFromWithBlankspace(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_002";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );	
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "ReferredFrom With SpecialCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void referredFromWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_003";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );	
	}
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "ReferredFromwithNumbers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void referredFromwithNumbers(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_004";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
		
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "AuthorizationwithCharcters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void  authorizationwithCharcters(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_005";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "AuthorizationwithSpecialCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void  authorizationwithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_006";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "AuthorizationwithAlphanumericalCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void  authorizationwithAlphanumericalCharacters(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_007";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "referralstatusWithBlankSpace")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void referralstatusWithBlankSpace(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_008";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "startDatewithCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void referralStartDateWithCharacters(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_009";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "startDatewithSpecialcharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void referralStartDatewithSpecialcharacters(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_010";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "startDatewithNumbers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void referralStartDatewithNumbers(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_011";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "startDatewithalphanumbericalCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void referralStartDatewithalphanumbericalCharacter(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_012";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "enddatewithCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void referralEnddatewithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_013";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "enddatewithSpecialcharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void referralEnddatewithSpecialcharacter(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_014";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "enddatewithSNumbers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void referralEnddatewithSNumbers(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_015";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "enddatewithalphanumbericalCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void referralEnddatewithalphanumbericalCharacter(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_016";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "Daterequestedwithdata")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void daterequestedwithdate(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_017";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "DateRequestedwithCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void dateRequestedwithCharacters(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_018";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "DaterequestedwithSpecialCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void daterequestedwithSpecialCharacter (String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_019";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "DaterequestedwithalphanumbericalCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void  daterequestedwithalphanumbericalCharacter(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_020";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "dateallowedwithCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void  dateapprovedwithCharacters(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_021";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "dateallowedwithSpecialcharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void  dateapprovedwithSpecialcharacters(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_022";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "dateallowedwithNumbers")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void  dateapprovedwithNumbers(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_023";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "dateallowedwithalphanumbericalCharacter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void  dateapprovedwithalphanumbericalCharacter(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_024";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "amountwithCharacters(")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void amountwithCharacters(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_025";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	

	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "amountwithSpecialcharacters(")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void amountwithSpecialcharacters(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_026";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "VisitAllowedwithCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void visitAllowedwithCharacters(String seleniumHost, int seleniumPort,String browser, String webSite) throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_027";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "VisitAllowedwithSpecialCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void visitAllowedwithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite)throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_028";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "VisitAllowedwithAlphanumericalCharacters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void visitAllowedwithAlphanumericalCharacters(String seleniumHost, int seleniumPort,String browser, String webSite) throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_029";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	@Test(groups = {"firefox", "iexplore", "safari", "default"}, description = "ValidData")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void fieldsWithvalidData(String seleniumHost, int seleniumPort,String browser, String webSite) throws IOException{

		HomeLibUnitTest ReferralTestData = new HomeLibUnitTest();
		ReferralTestData.workSheetName = "UnitTest_FV_PC_Referrals";
		ReferralTestData.testCaseId = "UT_REF_030";
		ReferralTestData.fetchHomeTestData();
		createReferral(seleniumHost, seleniumPort, browser, webSite, ReferralTestData );
	}
	
	/**
	 * createReferral
	 * Function to createReferral
	 * @param 		seleniumHost
	 * @param 		seleninumPort
	 * @param 		browser
	 * @param 		website
	 * @author 		Aspire QA
	 * @throws IOException 
	 * @since  	     Feb 15, 2012
	 */  
	
	public boolean createReferral(String seleniumHost, int seleniumPort,String browser, String webSite, HomeLibUnitTest ReferralTestData) throws IOException{
		
		Selenium selenium = null;
		String alertText="";
		boolean returnValue= true;
			 
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application  //
			//--------------------------------------------------------------------//

			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + ReferralTestData.toString());
			loginFromPublicSite(selenium, ReferralTestData.userAccount, ReferralTestData.userName, ReferralTestData.userPassword);
			goToNewPatientCheckIn(selenium);
			waitForPageLoad(selenium);
			
			click(selenium, "!patientReferralList");
			waitForPageLoad(selenium);
			click(selenium, "addReferral");
			waitForPageLoad(selenium);
			
			if(!addReferrals(selenium, ReferralTestData) && ReferralTestData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).equals("yes")){
				if(isElementPresent(selenium, "//p")){
					alertText = getText(selenium, "//p");
					if(alertText.trim().toLowerCase(new java.util.Locale("en", "US")).startsWith(ReferralTestData.alertMessage.trim().toLowerCase(new java.util.Locale("en", "US")))){
						return returnValue;
					}else{
						Assert.fail("An unxpected Alert is displayed with message ; The Expected :"+ReferralTestData.alertMessage+"; The Actual :" + alertText +"; More Details :"+ ReferralTestData.toString());
					}
				}else{
					Assert.fail("Alert is not getting displayed ;  More Details :"+ ReferralTestData.toString());
				}
			}
			else if(ReferralTestData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).equals("no")){
					return returnValue;
			}
				else{
				Assert.fail("Expected Alert is not displayed ; The Expected :"+ReferralTestData.alertMessage+"; The Actual :" + alertText +"; More Details :"+ ReferralTestData.toString());
				}
		}
		catch (RuntimeException e) {
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" +ReferralTestData.toString());
		try{
			Thread.sleep(60000);
		}catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}finally{
			try {
				if(selenium != null){
					if(selenium.isElementPresent("errorCloseButton") && selenium.isVisible("errorCloseButton")){
						click(selenium, "errorCloseButton");
						waitForPageLoad(selenium);	
					}
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
		return returnValue;
	}
	
	/**
	 * addReferral
	 * Function to add a Referral
	 * @param 		seleniumHost
	 * @param 		seleninumPort
	 * @param 		browser
	 * @param 		website
	 * @author 		Aspire QA
	 * @throws IOException 
	 * @since  	     Feb 15,2012
	 */  
		
	public boolean addReferrals(Selenium selenium, HomeLibUnitTest ReferralTestData) throws IOException{
			
			try{
				
				selectValueFromAjaxList(selenium,"suggestBox",ReferralTestData.suggestBox);
				selectValueFromAjaxList(selenium,"//div[@id='referralReferralType']/div/div/input",ReferralTestData.referralType);
				selectValueFromAjaxListUsingTypeKeys(selenium,"//div[@id='referredFromBox']/div/div/div/div/div/div[2]/input",ReferralTestData.referredFrom);
				selectValueFromAjaxListUsingTypeKeys(selenium,"//div[@id='referredToBox']/div/div/div/div/div/div[2]/input",ReferralTestData.referredTo);
				assertTrue(type(selenium,"referralAuthorizationNumber",ReferralTestData.authorization),"Could not Type Referr to; More Deatisl"+ReferralTestData.toString(), selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='nullBox'])[3]",ReferralTestData.payer);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[3]",ReferralTestData.referralstatus);
				assertTrue(type(selenium,"referralReasonForReferral",ReferralTestData.reasonforreferral),"Could not Type Reason for Referral; More Deatils:"+ReferralTestData.toString(), selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,"referralStartDate", ReferralTestData.startDate),"Could not enter Start Date; More Details" + ReferralTestData.toString(), selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium, "referralEndDate", ReferralTestData.endDate),"Could not enter Directive End Date; More Details" + ReferralTestData.toString(), selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium, "referralDateRequested", ReferralTestData.daterequest),"Could not enter  Daterequested; More Details" + ReferralTestData.toString(), selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium, "referralDateApproved", ReferralTestData.dateapproved),"Could not enter  DataApproved; More Details" + ReferralTestData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,"referralNumberVisitAllowed",ReferralTestData.visitallowed),"Could not enter visist Allowed; More Details "+ReferralTestData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,"referralNumberVisitSchedule",ReferralTestData.visitscheduled),"Could not Type Visit scheduled; More Details"+ReferralTestData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,"referralNumberVisitUsed",ReferralTestData.visitused),"Could not Type Visit Allowed; More Details"+ReferralTestData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,"referralCaseMaximumCashAmount",ReferralTestData.amount),"Could not Type Visit Allowed; More Details:"+ReferralTestData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,"referralNextAppointment",ReferralTestData.nextappt),"Could not Type Visit Allowed; More Details:"+ReferralTestData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,"referralSave"),"Could not click Validate Button; More Details"+ReferralTestData.toString(), selenium, ClassName, MethodName);
			
				if(isElementPresent(selenium, "css=span.title")){
					return true;
				}else{
					return false;
				}
			}
		catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}		
}
}
