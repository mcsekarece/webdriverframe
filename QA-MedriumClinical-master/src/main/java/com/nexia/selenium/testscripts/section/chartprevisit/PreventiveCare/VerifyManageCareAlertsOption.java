package com.nexia.selenium.testscripts.section.chartprevisit.PreventiveCare;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyManageCareAlertsOption extends AbstractChartPreVisit {	
	
	@Test(groups = {"Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate Manage Care Alerts page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void manageCareAlertsOptionTest(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib careData = new ChartPreVisitLib();
		careData.workSheetName = "PreventiveCare";
		careData.testCaseId = "TC_PC_001";
		careData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		manageCareAlertsOptionVerification(seleniumHost, seleniumPort, browser, webSite, userAccount,careData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to validate Manage Care Alerts page 
	 * @action 		   Manage Care Alerts 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       July 23, 2014	
	 ***************************************************************************************************/

	public boolean manageCareAlertsOptionVerification(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib careData ) throws IOException{

		Selenium selenium=null;
		boolean returnValue=true;

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
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "PatientData";
		    patientData.testCaseId = "TC_NPC_141";
			patientData.fetchHomeTestData();
			assertTrue(navigateToNewPatientRegistration(selenium),"Unable to navigate to Patient Registration page",selenium,ClassName,MethodName);
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Unable to create Patient",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			String patientId=getText(selenium,lblPatientId);
			
			searchPatientNexiaForProviderHomePage(selenium,patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Go to Manage Care Alerts screen 
			//--------------------------------------------------------------------//
			assertTrue(goToManageCareAlertsScreen(selenium),"Could not navigate Manage Care Alerts screen", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Check if Save and Cancel buttons are present 
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium, btnSaveCareAlerts),"Could not find Save button.", selenium , ClassName, MethodName);
			assertTrue(isElementPresent(selenium, btnCancelCareAlerts),"Could not find cancel button.", selenium , ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-6: Check if messages and texts are present
			//--------------------------------------------------------------------//
			String message = "When a patient's profile matches the criteria for periodic health maintenance, "
					+ "the patient is automatically recalled for a visit and an alert is added to their Clinical Summary. "
					+ "If you want to manually add or remove them from a recall list, you can do that below. ";
			
			assertTrue(selenium.isTextPresent(message),"Could not find prompt message.", selenium , ClassName, MethodName);
			
			assertTrue(selenium.isTextPresent("Definitions of terms"),"Could not find text - Definitions of terms", selenium , ClassName, MethodName);
			
			String[] standardCareAlerts = {"Flu shot", "Fecal Occult Blood Test", "Pap Smear", "Mammogram", "Child Immunization"};
			for (int i = 0; i < standardCareAlerts.length; i++) {
				assertTrue(selenium.isTextPresent(standardCareAlerts[i]),"Could not find text for Standard Care Alert - " +standardCareAlerts[i], selenium , ClassName, MethodName);
			}
						 
			//--------------------------------------------------------------------//
			//  Step-7: Check if all Automated Recall radio buttons are selected
			//--------------------------------------------------------------------//
			int n = (Integer) selenium.getXpathCount(rdoAutomatedRecallButtons);
			for (int i = 1; i <= n; i++) {
				String rdoAutomatedRecallButton = rdoAutomatedRecallButtons + "[" +i+ "]";
				assertTrue(selenium.isChecked(rdoAutomatedRecallButton),"Automated Recall radio button is not selected. Index - " +i, selenium , ClassName, MethodName);
			}
			
			
			n = (Integer) selenium.getXpathCount(rdoNeverRecallButtons);
			for (int i = 1; i <= n; i++) {
				String rdoNeverRecallButton = rdoNeverRecallButtons + "[" +i+ "]";
				assertTrue(!selenium.isChecked(rdoNeverRecallButton),"Never Recall radio button is selected. Index - " +i, selenium , ClassName, MethodName);
			}
			
			
			n = (Integer) selenium.getXpathCount(rdoForceRecallButtons);
			for (int i = 1; i <= n; i++) {
				String rdoForceRecallButton = rdoForceRecallButtons + "[" +i+ "]";
				assertTrue(!selenium.isChecked(rdoForceRecallButton),"Force Recall radio button is selected. Index - " +i, selenium , ClassName, MethodName);
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}	