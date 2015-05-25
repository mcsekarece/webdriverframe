package com.nexia.selenium.testscripts.section.chartprevisit.SigningAuthority;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyNewUserRoleDefaultAccess extends AbstractChartPreVisit {	
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate that default permission for newly created roles will be No Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void newUserRoleDefaultAccessTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib authData = new ChartPreVisitLib();
		authData.workSheetName = "SigningAuthority";
		authData.testCaseId = "TC_SA_005";
		authData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyNoAccessForNewUserRole(seleniumHost, seleniumPort, browser, webSite, userAccount, authData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to validate that default permission for newly created roles will be No Access  
	 * @Specification  EMR-26: Limit Who Can Sign Prescriptions/DI/Lab 
	 * @action 		   Signing Authority
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       Aug 13, 2014
	 ***************************************************************************************************/

	public boolean verifyNoAccessForNewUserRole(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib authData) throws Exception{
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
			//  Step-2: Change Switch Role - FULL  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,authData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Go to Security Settings and navigate to User Role screen
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkSettings), "Could not click Quick Actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSecuritySettings),"Could not click System Settings link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkUserRole),"Could not click the User Role link.", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Click Add New user role button
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddNewUserRole),"Could not click Add New button.", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Verify all check boxes related to No Access are selected
			//--------------------------------------------------------------------//			
			String currentCheckBox;
			int n = (Integer) selenium.getXpathCount(chkNoAccessCheckBoxes);
			for (int i = 1; i <= n; i++) {
				currentCheckBox = chkNoAccessCheckBoxes + "[" +i+ "]";				
				assertTrue(isChecked(selenium, currentCheckBox), "No Access checkbox not selected", selenium, ClassName, MethodName);				
			}		

			//--------------------------------------------------------------------//
			//  Step-6: Verify all check boxes related to View Only are not selected
			//--------------------------------------------------------------------//
			n = (Integer) selenium.getXpathCount(chkViewOnlyCheckBoxes);
			for (int i = 1; i <= n; i++) {
				currentCheckBox = chkViewOnlyCheckBoxes + "[" +i+ "]";				
				assertTrue( !isChecked(selenium, currentCheckBox), "View Only checkbox selected", selenium, ClassName, MethodName);				
			}

			//--------------------------------------------------------------------//
			//  Step-7: Verify all check boxes related to Limited Access are not selected
			//--------------------------------------------------------------------//
			n = (Integer) selenium.getXpathCount(chkLimitedAccessCheckBoxes);
			for (int i = 1; i <= n; i++) {
				currentCheckBox = chkLimitedAccessCheckBoxes + "[" +i+ "]";				
				assertTrue( !isChecked(selenium, currentCheckBox), "Limited Access checkbox selected", selenium, ClassName, MethodName);				
			}

			//--------------------------------------------------------------------//
			//  Step-8: Verify all check boxes related to Full Access are not selected
			//--------------------------------------------------------------------//
			n = (Integer) selenium.getXpathCount(chkFullAccessCheckBoxes);
			for (int i = 1; i <= n; i++) {
				currentCheckBox = chkFullAccessCheckBoxes + "[" +i+ "]";				
				assertTrue( !isChecked(selenium, currentCheckBox), "Full Access checkbox selected", selenium, ClassName, MethodName);				
			}
			
			//Click Cancel button
			assertTrue(click(selenium, btnCancelID),"Could not click Cancel button.", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + authData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}

}

