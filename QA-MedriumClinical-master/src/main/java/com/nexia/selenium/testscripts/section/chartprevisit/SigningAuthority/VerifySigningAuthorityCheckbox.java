package com.nexia.selenium.testscripts.section.chartprevisit.SigningAuthority;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySigningAuthorityCheckbox extends AbstractChartPreVisit {	
	
	private String[] ordersFeatureName = {"Labs", "Diagnostic Tests", "Prescriptions" , "Referrals"};
	private String[] reportsFeatureName = {"Labs", "Diagnostic Tests", "Correspondence"};
	private String outerFeatureName;
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate Signing Authority is only allowed for user with Full Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void fullAccessSigningAuthorityCheckboxTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib authData = new ChartPreVisitLib();
		authData.workSheetName = "SigningAuthority";
		authData.testCaseId = "TC_SA_001";
		authData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		signingAuthorityCheckboxValidation(seleniumHost, seleniumPort, browser, webSite, userAccount, authData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to validate Signing Authority is only allowed for user with Full Access  
	 * @Specification  EMR-26: Limit Who Can Sign Prescriptions/DI/Lab 
	 * @action 		   Signing Authority
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       Aug 13, 2014
	 ***************************************************************************************************/

	public boolean signingAuthorityCheckboxValidation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib authData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + authData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, authData.userName, authData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role - FULL  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,authData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3:Go to Security Settings and navigate to User Role to edit
			//--------------------------------------------------------------------//
			assertTrue(navigateToEditUserRolePage(selenium,authData.editRole), "Could not edit user role " +authData.editRole , selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Signing authority feature
			//--------------------------------------------------------------------//			
			assertTrue(click(selenium, lblClinicalCategory),"Could not click Clinical category link.", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblOrdersCategory),"Could not click Orders category link.", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		 
			
			//Test Orders Category
			outerFeatureName = "Orders";
			for (int i = 0; i < ordersFeatureName.length; i++) {			

				//--------------------------------------------------------------------//
				//  Step-5: Test View Only Radio button
				//--------------------------------------------------------------------//
				assertTrue( setViewOnlyRadioButtonForInnerFeature(selenium, ordersFeatureName[i],outerFeatureName), "Could not click View Only radio button for feature: " +ordersFeatureName, selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue( isSigningAuthoriryDisabledForInnerFeature(selenium, ordersFeatureName[i],outerFeatureName), "Signing Authoriry is NOT disabled for feature: " +ordersFeatureName, selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-6: Test Limited Access Radio button
				//--------------------------------------------------------------------//
				assertTrue( setLimitedAccessRadioButtonForInnerFeature(selenium, ordersFeatureName[i],outerFeatureName), "Could not click Full Access radio button for feature: " +ordersFeatureName, selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue( ! isSigningAuthoriryDisabledForInnerFeature(selenium, ordersFeatureName[i],outerFeatureName), "Signing Authoriry is disabled for feature: " +ordersFeatureName, selenium, ClassName, MethodName);
				assertTrue( selectSigningAuthoriryForInnerFeature(selenium, ordersFeatureName[i],outerFeatureName), "Not able to select Signing Authoriry for feature: " +ordersFeatureName, selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				//--------------------------------------------------------------------//
				//  Step-7: Test Full Access Radio button
				//--------------------------------------------------------------------//
				assertTrue( setFullAccessRadioButtonForInnerFeature(selenium, ordersFeatureName[i],outerFeatureName), "Could not click Full Access radio button for feature: " +ordersFeatureName, selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue( ! isSigningAuthoriryDisabledForInnerFeature(selenium, ordersFeatureName[i],outerFeatureName), "Signing Authoriry is disabled for feature: " +ordersFeatureName, selenium, ClassName, MethodName);
				assertTrue( selectSigningAuthoriryForInnerFeature(selenium, ordersFeatureName[i],outerFeatureName), "Not able to select Signing Authoriry for feature: " +ordersFeatureName, selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//Test Reports category
			outerFeatureName = "Reports";	
			assertTrue(click(selenium, lblReportsCategory),"Could not click Orders category link.", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			for (int i = 0; i < reportsFeatureName.length; i++) {			

				//--------------------------------------------------------------------//
				//  Step-8: Test View Only Radio button
				//--------------------------------------------------------------------//
				assertTrue( setViewOnlyRadioButtonForInnerFeature(selenium, reportsFeatureName[i],outerFeatureName), "Could not click View Only radio button for feature: " +ordersFeatureName, selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue( isSigningAuthoriryDisabledForInnerFeature(selenium, reportsFeatureName[i],outerFeatureName), "Signing Authoriry is NOT disabled for feature: " +ordersFeatureName, selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-9: Test Limited Access Radio button
				//--------------------------------------------------------------------//
				assertTrue( setLimitedAccessRadioButtonForInnerFeature(selenium, ordersFeatureName[i],outerFeatureName), "Could not click Full Access radio button for feature: " +ordersFeatureName, selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue( ! isSigningAuthoriryDisabledForInnerFeature(selenium, ordersFeatureName[i],outerFeatureName), "Signing Authoriry is disabled for feature: " +ordersFeatureName, selenium, ClassName, MethodName);
				assertTrue( selectSigningAuthoriryForInnerFeature(selenium, ordersFeatureName[i],outerFeatureName), "Not able to select Signing Authoriry for feature: " +ordersFeatureName, selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				//--------------------------------------------------------------------//
				//  Step-10: Test Full Access Radio button
				//--------------------------------------------------------------------//
				assertTrue( setFullAccessRadioButtonForInnerFeature(selenium, reportsFeatureName[i],outerFeatureName), "Could not click Full Access radio button for feature: " +ordersFeatureName, selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue( ! isSigningAuthoriryDisabledForInnerFeature(selenium, reportsFeatureName[i],outerFeatureName), "Signing Authoriry is disabled for feature: " +ordersFeatureName, selenium, ClassName, MethodName);
				assertTrue( selectSigningAuthoriryForInnerFeature(selenium, reportsFeatureName[i],outerFeatureName), "Not able to select Signing Authoriry for feature: " +ordersFeatureName, selenium, ClassName, MethodName);
				waitForPageLoad(selenium);				
			}
			
			assertTrue(click(selenium, btnsaveProvider), "Could not click Save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + authData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}

}

