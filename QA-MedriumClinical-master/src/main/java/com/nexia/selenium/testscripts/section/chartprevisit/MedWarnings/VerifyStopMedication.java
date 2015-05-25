package com.nexia.selenium.testscripts.section.chartprevisit.MedWarnings;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStopMedication extends AbstractChartPreVisit{
	@Test(groups = {"SingleThreadUS","AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStopMedicationCheckBox(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_061";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStopMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * createPrescribe
	 * Function to create Prescribe
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Apr 22, 2012
	 */
	public boolean verifyStopMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData)throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
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
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-5: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,btnPrint),"Could not click the print button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			
			Robot robot = new Robot();
			Thread.sleep(20000);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			//--------------------------------------------------------------------//
			//  Step-7: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,chkStopbox)){
				if(selenium.isTextPresent("Stop this medication upon override")){
					assertTrue(click(selenium,chkStopbox),"Could not click the check box", selenium, ClassName, MethodName);
				}
			}
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,btnPrint),"Could not click the print button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Thread.sleep(20000);
			robot.keyPress(KeyEvent.VK_ESCAPE);
		
			assertTrue(verifyStoreValue(selenium,prescribeData),"Details not saved prperly", selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyStoreValue(Selenium selenium,ChartPreVisitLib prescribeData) throws IOException{
		assertTrue(click(selenium,lnkMedicationTab),"Could not click the print button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		int count=(Integer)selenium.getXpathCount("//div[2]/div/div/div[4]/div/div");
		int counter=2;
		if(!getText(selenium,"//div[2]/div/div/div[4]/div/div").toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescribeData.prescribeName.toLowerCase(new java.util.Locale("en","Us")).trim())){
			assertTrue(click(selenium,"//div[2]/div/div/div[4]/div/div"),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,"//div/div/div[4]/div/table").trim().contains("Stopped by".trim()),"Not matching", selenium, ClassName, MethodName);
		}else{
			while(count<=counter){
				if(!getText(selenium,"//tr["+counter+"]/td/div/span/div").toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescribeData.prescribeName.toLowerCase(new java.util.Locale("en","Us")).trim())){
					assertTrue(click(selenium,"//tr["+counter+"]/td/div/span/div"),"", selenium, ClassName, MethodName);
					//String s=getText(selenium,"//tr["+counter+"]/td/div/span/div");
					if(!getText(selenium,"//tr["+counter+"]/td/div/span/div").trim().contains("Stopped by".trim())){
					count++;
					}
				}
			}	
		}
		return true;
	}
}
