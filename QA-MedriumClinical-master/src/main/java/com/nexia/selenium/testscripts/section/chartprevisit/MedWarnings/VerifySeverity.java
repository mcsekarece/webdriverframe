package com.nexia.selenium.testscripts.section.chartprevisit.MedWarnings;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySeverity extends AbstractChartPreVisit{
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying severe severity")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifysevereSeverity(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "MedWarnings";
		prescribeData.testCaseId = "TC_PMW_003";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		severityOfInteraction(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying severe severity")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHighSeverity(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "MedWarnings";
		prescribeData.testCaseId = "TC_PMW_004";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		severityOfInteraction(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying severe severity")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyModerateSeverity(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "MedWarnings";
		prescribeData.testCaseId = "TC_PMW_005";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		severityOfInteraction(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * severityOfInteraction
	 * Function to verify food drink interaction 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 14, 2012
	 */
	public boolean severityOfInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue = false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Verify Food/Drink Interaction for the medication //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValues(selenium,prescribeData,userAccount),"Could not store the datas.", selenium, ClassName, MethodName);
			return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib labData,String account) throws IOException{
		waitForPageLoad(selenium);	
		if(account.equals(CAAccount)){
			if(labData.testCaseId.equals("TC_PMW_003")){
				assertTrue(isElementPresent(selenium,lblWarningSeverity),"Warning severity lable is missing", selenium, ClassName, MethodName);
				assertTrue(getText(selenium,labSeverity).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.indications.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
				assertTrue(getText(selenium,labSeverity).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.prescribeCa.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
				assertTrue(getText(selenium,labSeverity).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.severity.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			}
			else if(labData.testCaseId.equals("TC_PMW_004")){
				assertTrue(isElementPresent(selenium,lblWarningSeverity),"Warning severity lable is missing", selenium, ClassName, MethodName);
				assertTrue(getText(selenium,lblIndication).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.indications.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
				assertTrue(getText(selenium,lblIndication).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.prescribeCa.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
				assertTrue(getText(selenium,lblIndication).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.severity.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			}
			else if(labData.testCaseId.equals("TC_PMW_005")){
				assertTrue(isElementPresent(selenium,imgFoodWarning),"Warning severity lable is missing", selenium, ClassName, MethodName);
				assertTrue(getText(selenium,lblFoodInteraction).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.indications.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
				assertTrue(getText(selenium,lblFoodInteraction).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.prescribeCa.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
				assertTrue(getText(selenium,lblFoodInteraction).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.severity.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			}
			return true;
		}
		
		else
		if(labData.testCaseId.equals("TC_PMW_003")){
			assertTrue(isElementPresent(selenium,lblWarningSeverity),"Warning severity lable is missing", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,labSeverity).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.indications.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,labSeverity).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.prescribeName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,labSeverity).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.severity.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
		}
		else if(labData.testCaseId.equals("TC_PMW_004")){
			
			assertTrue(isElementPresent(selenium,lblWarningSeverity),"Warning severity lable is missing", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblIndication).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.indications.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblIndication).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.prescribeName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);	
			assertTrue(getText(selenium,lblIndication).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.severity.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
		}
		else if(labData.testCaseId.equals("TC_PMW_005")){
			assertTrue(isElementPresent(selenium,imgFoodWarning),"Warning severity lable is missing", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblFoodInteraction).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.indications.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblFoodInteraction).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.prescribeName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblFoodInteraction).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.severity.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
		}
		return true;
	}	
}
