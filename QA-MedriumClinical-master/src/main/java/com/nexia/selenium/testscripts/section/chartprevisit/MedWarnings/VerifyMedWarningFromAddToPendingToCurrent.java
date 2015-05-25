package com.nexia.selenium.testscripts.section.chartprevisit.MedWarnings;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMedWarningFromAddToPendingToCurrent extends AbstractChartPreVisit {
	@Test(groups = {"SingleThread","AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Free text for created prescribed medication quick list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyMedWarningOnCurrent(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_055";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPrescribe(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	/*************************************************************************************************** 
	* @purpose        Verify Med Warning On Current
	* @action 		  Verify Med Warning On Current
	* @expected       Med Warning should get displayed with proper details
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      April 03, 2013
	***************************************************************************************************/
	
	public boolean createPrescribe(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
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
			//  Step-3: Create a new patient and get Patient Id					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			ChartPreVisitLib prescribePatientData = new ChartPreVisitLib();
			prescribePatientData.workSheetName = "NewPatientCheckIn";
			prescribePatientData.testCaseId = "TC_NP_001";
			prescribePatientData.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,prescribePatientData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete all Quick list items								  //
		/*	//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnPrescibeQuick),"Could not click the QuickList button;More details:"+prescribeData.toString());
			waitForPageLoad(selenium);*/
			
			/*assertTrue(click(selenium,btnPrescibeQuick),"Could not click the QuickList button;More details:"+prescribeData.toString());
			waitForPageLoad(selenium);
			
			while((Integer) selenium.getXpathCount(ajxMedsQuickUs)>0){
				assertTrue(click(selenium,lnkPrescribeDelete),"Could not delete the QuickList value;More details:"+prescribeData.toString());
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnPrescibeQuick),"Could not click the QuickList button;More details:"+prescribeData.toString());
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
			}
			
			assertTrue(click(selenium,btnPrescibeQuick),"Could not click the QuickList button;More details:"+prescribeData.toString());
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-6: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", FULL", "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			prescribeData.provider = pName;
			
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-7: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnAddToPending), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//assertTrue(click(selenium, lnkGoToPending), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			selenium.focus(lnkGoToPending);
			selenium.click(lnkGoToPending);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			click(selenium,btnNoteEdit);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnContinueId),"Could not click the Continue button;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			assertTrue(click(selenium,btnPrint),"Could not click the print button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Robot robot = new Robot();
			Thread.sleep(20000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnEditBlue)){
				click(selenium,btnEditBlue);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium, lnkMore),"Could not click on More  link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedicationTab),"Could not click medication tab"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkExpandAll),"Could not click medication tab"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			
			/*if(!getText(selenium,"mainPanel").toLowerCase(new java.util.Locale("en","US")).trim().contains((prescribeData.reason).trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
			//get the provider name
			
			String provider=getText(selenium, lnkTopMenu);
			String providerName1[]=provider.split(",");
			
			assertTrue(getText(selenium,"chartListItem").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerName1[0].trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
