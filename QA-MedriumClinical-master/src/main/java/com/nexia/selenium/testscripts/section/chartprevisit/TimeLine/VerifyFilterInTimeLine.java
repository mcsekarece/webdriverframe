package com.nexia.selenium.testscripts.section.chartprevisit.TimeLine;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyFilterInTimeLine extends AbstractChartPreVisit {
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Filter In Time Line")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFilterInTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_046";
		labData.fetchChartPreVisitTestData();
		verifyFilterInTimeLine(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Filter In Time Line
	* @action 		  verify Filter In Time Line
	* @author         Aspire QA
	* @throws 		  Exception 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Aug 28, 2013
	***************************************************************************************************/
	public boolean verifyFilterInTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		
		String lblTimeLineSummary="//div[@class='height575px relative']/div[4]";
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + labData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, labData.userName, labData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Create New Patient										  //
			//--------------------------------------------------------------------//
			assertTrue(goToRegisterPatient(selenium), "Could not go to register patient", selenium, ClassName, MethodName);
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_002";
			patientData.fetchHomeTestData();
			
			if(isElementPresent(selenium,lnkContinue)){
				selenium.click(lnkContinue);
			}
			createNewPatientWithMandatory(selenium,patientData);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigation to File new lab report						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateTofileReport(selenium,labData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: File new lab report 									  //
			//--------------------------------------------------------------------//
			assertTrue(fileReport(selenium,labData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: verify Created lab report								  //
			//--------------------------------------------------------------------//
			if(!isElementPresent(selenium,lnkEnterData)){
				Assert.fail("Could not see the enter data");
			}
				
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Prescribe Medication					      //
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Search  Prescribe Medication 							  //
			//--------------------------------------------------------------------//
			ChartPreVisitLib prescribeData = new ChartPreVisitLib();
			prescribeData.workSheetName = "PrescribeMedi";
			prescribeData.testCaseId = "TC_PM_114";
			prescribeData.fetchChartPreVisitTestData();
			
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, "cancelButton")){
				click(selenium, "cancelButton");
			}
			
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-8: create Prescribe Medication 							  //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"print"),"Could not click the print button;More Deatils:"+prescribeData.toString(),selenium,ClassName,MethodName);
			Robot robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			
			
			
			//--------------------------------------------------------------------//
			//  Step-9: Begin an encounter										  //
			//--------------------------------------------------------------------//
			ChartPreVisitLib encounterData = new ChartPreVisitLib();
			encounterData.workSheetName = "EncounterOverAll";
			encounterData.testCaseId = "TC_EO_002";
			encounterData.fetchChartPreVisitTestData();
			
			try{
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}catch(Exception e){
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}if(isElementPresent(selenium,lblEncounterChoosePanel))
				if(isElementPresent(selenium,"beginNewEncounter"))
					click(selenium,"beginNewEncounter");
			
			selectValueFromAjaxList(selenium,"providerSuggestBoxIdsuggestBox",encounterData.provider);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSign),"Could not click the  sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkTimeLine),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9 : Verify the Default value in  time line 					  //
			//--------------------------------------------------------------------//
			
			if(getValue(selenium,txtMedsSearchTextBox ).contains("Search by keyword")){
			Assert.fail("Verify the Default value in  time line search failed");
			}
			/*if(getValue(selenium,ajxRxShow ).contains("All")){
				Assert.fail("Verify the Default value in  time line search failed");
			}*/
			
			//--------------------------------------------------------------------//
			//  Step-10: Verify Filter in timeline Summary page				      //
			//--------------------------------------------------------------------//
			//Filter based on encounter
			selectValueFromAjaxList(selenium, ajxRxShow, "Encounters");
			waitForPageLoad(selenium);
			
			if(!getText(selenium, lblTimeLineSummary).contains("Encounter")){
				return false;
			}
			if(userAccount.equalsIgnoreCase(CAAccount)){
				if(getText(selenium, lblTimeLineSummary).contains(prescribeData.prescribeNameCa)){
					return false;
				}
			}
			else{
				if(getText(selenium, lblTimeLineSummary).contains(prescribeData.prescribeName)){
					return false;
				}
			}
			if(getText(selenium, lblTimeLineSummary).contains(labData.labName)){
				return false;
			}
			
			
			//Filter based on prescription
			selectValueFromAjaxList(selenium, ajxRxShow, "Prescriptions");
			waitForPageLoad(selenium);
			
			if(getText(selenium, lblTimeLineSummary).contains("Encounter")){
				return false;
			}
			
			if(userAccount.equalsIgnoreCase(CAAccount)){
				if(!getText(selenium, lblTimeLineSummary).contains(prescribeData.prescribeNameCa)){
					return false;
				}
			}
			else{
				if(!getText(selenium, lblTimeLineSummary).contains(prescribeData.prescribeName)){
					return false;
				}
			}
			
			if(getText(selenium, lblTimeLineSummary).contains(labData.labName)){
				return false;
			}
			
			//Filter based on lab
			selectValueFromAjaxList(selenium, ajxRxShow, "Lab Reports");
			waitForPageLoad(selenium);
			
			if(getText(selenium, lblTimeLineSummary).contains("Encounter")){
				return false;
			}
			
			if(userAccount.equalsIgnoreCase(CAAccount)){
				if(getText(selenium, lblTimeLineSummary).contains(prescribeData.prescribeNameCa)){
					return false;
				}
			}
			else{
				if(getText(selenium, lblTimeLineSummary).contains(prescribeData.prescribeName)){
					return false;
				}
			}
			
			if(!getText(selenium, lblTimeLineSummary).contains(labData.labName)){
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
