package com.nexia.selenium.testscripts.section.chartprevisit.SigningAuthority;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySigningAuthorityReferralAccess extends AbstractChartPreVisit {	

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate Signing authority/Referrals with Full Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void signingAuthorityReferralFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_002";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySignAuthReferralAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate Signing authority/Referrals with Limited Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void signingAuthorityReferralLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_003";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySignAuthReferralAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}


	/*************************************************************************************************** 
	 * @purpose        Test to validate Signing authority/Referrals with Full/Limited Access  
	 * @Specification  EMR-26: Limit Who Can Sign Prescriptions/DI/Lab 
	 * @action 		   Signing Authority
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       Aug 14, 2014
	 ***************************************************************************************************/

	public boolean verifySignAuthReferralAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib accessData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + accessData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, accessData.userName, accessData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role - FULL  					 //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,accessData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Set Required Signing Authority values  					 //
			//--------------------------------------------------------------------//
			if (accessData.accessLevel.equalsIgnoreCase("Full") ) { 
				setFullAccessSigningAuthorityForUserRole(selenium, accessData);
			} 
			if (accessData.accessLevel.equalsIgnoreCase("Limited")) {
				setLimitedAccessSigningAuthorityForUserRole(selenium, accessData);
			}
			//--------------------------------------------------------------------//
			//  Step-4: Go to Security Settings and navigate to User Rules//
			//--------------------------------------------------------------------//			
			assertTrue(switchRole(selenium,accessData.editRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Verify Signing Authority for Referrals full access
			//--------------------------------------------------------------------//
			ChartPreVisitLib orderData = new ChartPreVisitLib();
			orderData.workSheetName = "CreateReferralOrder";
			orderData.testCaseId = "TC_OR_005";
			orderData.fetchChartPreVisitTestData();			
			
			//--------------------------------------------------------------------//
			//  Step-6: Advanced search with Patient ID//
			//--------------------------------------------------------------------//			
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,accessData.patientId),"Could not search patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-7: Delete Encounter from Encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,orderData),"Unable to delete previous encounters", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-8: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-9: Delete Existing Orders//
			//--------------------------------------------------------------------//
			assertTrue(deleteOrders(selenium,orderData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-10: Navigate to Referral Page//
			//--------------------------------------------------------------------//
			assertTrue(clickReferralIcon(selenium,orderData),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-11: Check if Sign button present
			//--------------------------------------------------------------------//
			assertTrue(isElementVisible(selenium, btnRefSign),"Sign button not found", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-12: Create Referral Order//
			//--------------------------------------------------------------------//
			assertTrue(orderNewReferral(selenium,orderData),"Order creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			assertTrue(isElementPresent(selenium,btnPrint),"Not able to find Print button", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Review Referral Note"),"Not able to find text - Review Referral Letter", selenium, ClassName, MethodName);
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + accessData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}

	private void setLimitedAccessSigningAuthorityForUserRole(Selenium selenium, ChartPreVisitLib accessData) throws IOException {

		//Go to Security Settings and navigate to User Rules			
		assertTrue(navigateToEditUserRolePage(selenium,accessData.editRole), "Could not edit user role " +accessData.editRole , selenium, ClassName, MethodName);

		//Navigate to required Signing authority feature			
		assertTrue(click(selenium, lblClinicalCategory),"Could not click Clinical category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblOrdersCategory),"Could not click Orders category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	

		String featureName = accessData.featureName;						

		// Set Limited Access for Referrals Radio button for Orders Category		
		assertTrue(click(selenium,"rd"+"3464radio"), "Could not select Full Access radio button.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue( selenium.isEditable("chk"+"1464checkbox"), "Signing Authority is disabled for feature: " +featureName, selenium, ClassName, MethodName);
		assertTrue( check(selenium, "chk"+"1464checkbox"), "Not able to select Signing Authority for feature: " +featureName, selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Click Save button
		assertTrue(click(selenium, btnsaveProvider), "Could not click Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		 if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	}

	private void setFullAccessSigningAuthorityForUserRole(Selenium selenium, ChartPreVisitLib accessData ) throws IOException {

		//Go to Security Settings and navigate to User Rules			
		assertTrue(navigateToEditUserRolePage(selenium,accessData.editRole), "Could not edit user role " +accessData.editRole , selenium, ClassName, MethodName);

		//Navigate to required Signing authority feature			
		assertTrue(click(selenium, lblClinicalCategory),"Could not click Clinical category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblOrdersCategory),"Could not click Orders category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	

		String featureName = accessData.featureName;						

		//  Set Full Access for Referrals Radio button for Orders Category
		assertTrue(click(selenium,"rd"+"4464radio"), "Could not select Full Access radio button.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue( selenium.isEditable("chk"+"1464checkbox"), "Signing Authority is disabled for feature: " +featureName, selenium, ClassName, MethodName);
		assertTrue( check(selenium, "chk"+"1464checkbox"), "Not able to select Signing Authority for feature: " +featureName, selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//Click Save button
		assertTrue(click(selenium, btnsaveProvider), "Could not click Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		 if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	}
	
	
}


