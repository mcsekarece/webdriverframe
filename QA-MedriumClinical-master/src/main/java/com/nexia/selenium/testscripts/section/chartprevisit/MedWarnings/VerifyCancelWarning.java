package com.nexia.selenium.testscripts.section.chartprevisit.MedWarnings;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCancelWarning extends AbstractChartPreVisit{
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify cancel warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "MedWarnings";
		prescribeData.testCaseId = "TC_PMW_006";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyCancelWarning(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * verifyCancelWarning
	 * Function to verify cancel warning
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 19, 2012
	 */
	public boolean verifyCancelWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		String warning1="";
		String warning2="";
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
			
			int count=1;
			warning1=getText(selenium, "//div[3]/div["+count+"]/div/div[2]/table/tbody/tr/td/div");
			count++;
			
			while(isElementPresent(selenium,"//div[3]/div["+count+"]/div/div[2]/table/tbody/tr/td/div")){
				warning2=getText(selenium, "//div[3]/div["+count+"]/div/div[2]/table/tbody/tr/td/div");
				
				assertTrue(warning1.equals(warning2),"Duplicate warning appeared", selenium, ClassName, MethodName);
				count++;
			}
			
			System.out.println("Success");
			
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//----------------------------------------------------------------------------//
			//  Step-5: verify Cancel Warning                                             //
			//----------------------------------------------------------------------------//
			if(isElementPresent(selenium,btnSave)){
				assertTrue(click(selenium, btnCancel),"Could not click on Cancel button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}else{
				assertTrue(click(selenium, "cancelID"),"Could not click on Cancel button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(isElementPresent(selenium, ajxDrugsList),"Element not present", selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}

}
