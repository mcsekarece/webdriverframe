package com.nexia.selenium.testscripts.section.chartprevisit.PreventiveCare;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyNeverRecallCancelButton extends AbstractChartPreVisit {
			
	@Test(groups = {"Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate that Clicking Cancel in Never Recall popup wll not make any changes and return user to care alert list with previously selected option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void neverRecallCancelButtonTest(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib careData = new ChartPreVisitLib();
		careData.workSheetName = "PreventiveCare";
		careData.testCaseId = "TC_PC_002";
		careData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		neverRecallCancelButtonVerification(seleniumHost, seleniumPort, browser, webSite, userAccount,careData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to validate that Clicking Cancel will not make any changes and return user to care alert list with previously selected option
	 * @action 		   Manage Care Alerts 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       Aug 07 2014	
	 ***************************************************************************************************/

	public boolean neverRecallCancelButtonVerification(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib careData ) throws IOException{

		Selenium selenium=null;
		boolean returnValue=true;
		
		int index = getCareAlertIndex(selenium, careData);
		if(index == -1)
			fail("Invalid Alert name supplied in test data. Alert name: " +careData.alertName);
			
		String rdoNeverRecallButton = rdoNeverRecallButtons + "[" +index+ "]";
		String lnkEditRemovalReason = lnkEditRemovalReasons + "[" +(index*2-1)+ "]";
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application 								  
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + careData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, careData.userName, careData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-2: Change Switch Role  										
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,careData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,careData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Go to Manage Care Alerts screen 
			//--------------------------------------------------------------------//
			assertTrue(goToManageCareAlertsScreen(selenium),"Could not navigate Manage Care Alerts screen", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:	Make all Automated Recall radio buttons are selected
			//--------------------------------------------------------------------//
			int n = (Integer) selenium.getXpathCount(rdoAutomatedRecallButtons);
			for (int i = 1; i <= n; i++) {
				String rdoAutomatedRecallButton2 = rdoAutomatedRecallButtons + "[" +i+ "]";
				assertTrue(click(selenium,rdoAutomatedRecallButton2),"Could not check Automated Recall radio button. Index - " +i, selenium , ClassName, MethodName);
				waitForPageLoad(selenium);
			}
				
			//--------------------------------------------------------------------//
			//  Step-6: Click Never Recall Radio button 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, rdoNeverRecallButton),"Could not click Never Recall radio button.", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent("Reason:"),"Could not find text 'Reason:'" , selenium , ClassName, MethodName);
			
			//Get reason text for Never Recall			
			String lblReason = "";
			String reason = "";
			String initialReasonText = "";
			int m = (Integer) selenium.getXpathCount(lblReasonText);
			for (int i = 1; i <= m; i++) {
				lblReason = lblReasonText + "[" + i + "]";
				reason = getText(selenium, lblReason);				
				if (selenium.isVisible(lblReason) )
					initialReasonText = initialReasonText + " " + reason;				
			}	
						
			System.out.println("Initial reason text: " +initialReasonText);
			
			//--------------------------------------------------------------------//
			//  Step-7: Click Edit Removal Reason link 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkEditRemovalReason),"Could not click Edit Never Recall Reason link.", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Type removal reason 
			//--------------------------------------------------------------------//
			Date date = new Date();
			String ts = (new Timestamp(date.getTime())).toString(); 
			careData.reason = careData.reason + " CANCEL " +ts;			
			assertTrue(type(selenium,txtRemovalReason,careData.reason),"Could not type Removal reason.", selenium , ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-9: Click cancel on removal reason popup  
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnCancelPopup),"Could not click Cancel button in the popup.", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Verify reason for Cancel is not present  
			//--------------------------------------------------------------------//
			String finalReasonText = "";
			m = (Integer) selenium.getXpathCount(lblReasonText);
			for (int i = 1; i <= m; i++) {
				lblReason = lblReasonText + "[" + i + "]";
				reason = getText(selenium, lblReason);				
				if (selenium.isVisible(lblReason) )
					finalReasonText = finalReasonText + " " + reason;				
			}	
				
			System.out.println("Final reason text: " +finalReasonText);
			if (finalReasonText.contains(ts)) {
				fail("Reason entered prior to clicking Cancel button appeared");
			}		
						
			//--------------------------------------------------------------------//
			//  Step-11: Click on Cancel button in the Manage Care Alert Page as a cleanup activity
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnCancelCareAlerts),"Could not click Cancel button.", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}	