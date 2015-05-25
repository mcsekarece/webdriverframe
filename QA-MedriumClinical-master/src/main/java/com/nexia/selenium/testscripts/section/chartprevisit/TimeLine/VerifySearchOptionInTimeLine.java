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

public class VerifySearchOptionInTimeLine extends AbstractChartPreVisit {
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify The Search Option In TimeLine")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchOptionInTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_112";
		prescribeData.fetchChartPreVisitTestData();
		verifySearchOptionInTimeLine(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify The Search Option In TimeLine
	* @action 		  Verify The Search Option In TimeLine
	* @author         Aspire QA
	* @throws 		  Exception 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Aug 27, 2013
	***************************************************************************************************/
	public boolean verifySearchOptionInTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		String lblTimeLineSummary="//div[@class='height575px relative']/div[4]";
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
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
			//  Step-3: Navigate to Prescribe Medication					      //
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication 							  //
			//--------------------------------------------------------------------//
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
			//  Step-5: create Prescribe Medication 							  //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"print"),"Could not click the print button;More Deatils:"+prescribeData.toString(),selenium,ClassName,MethodName);
			Robot robot = new Robot();
			Thread.sleep(20000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Prescribe Medication					      //
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Search  Prescribe Medication 							  //
			//--------------------------------------------------------------------//
			ChartPreVisitLib prescribeData1 = new ChartPreVisitLib();
			prescribeData1.workSheetName = "PrescribeMedi";
			prescribeData1.testCaseId = "TC_PM_113";
			prescribeData1.fetchChartPreVisitTestData();
			
			assertTrue(SearchPrescribeMed(selenium,prescribeData1,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, "cancelButton")){
				click(selenium, "cancelButton");
			}
			
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData1.reason),"Could not type reason;More Details:"+prescribeData1.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData1.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-8: create second Prescribe Medication						  //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData1,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"print"),"Could not click the print button;More Deatils:"+prescribeData.toString(),selenium,ClassName,MethodName);
			robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			
			assertTrue(click(selenium,lnkTimeLine),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify the created medications in timeline Summary page   //
			//--------------------------------------------------------------------//
			if(userAccount.equalsIgnoreCase(CAAccount)){
				if(!getText(selenium,lblTimeLineSummary).trim().contains(prescribeData.prescribeNameCa.trim())){
					return false;
				}
				
				if(!getText(selenium,lblTimeLineSummary).trim().contains(prescribeData1.prescribeNameCa.trim())){
					return false;
				}
				
				assertTrue(type(selenium,txtMedsSearchTextBox,prescribeData.prescribeCa),"Could not type prescribe name;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				selenium.keyPress(txtMedsSearchTextBox, "\\13");
				waitForPageLoad(selenium);
				
				if(!getText(selenium,lblTimeLineSummary).trim().contains(prescribeData.prescribeNameCa.trim())){
					return false;
				}
				
				if(getText(selenium,lblTimeLineSummary).trim().contains(prescribeData1.prescribeNameCa.trim())){
					return false;
				}
			}
			else{
				if(!getText(selenium,lblTimeLineSummary).trim().contains(prescribeData.prescribeName.trim())){
					return false;
				}
				
				if(!getText(selenium,lblTimeLineSummary).trim().contains(prescribeData1.prescribeName.trim())){
					return false;
				}
				
				assertTrue(type(selenium,txtMedsSearchTextBox,prescribeData.prescribe),"Could not type prescribe name;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				selenium.keyPress(txtMedsSearchTextBox, "\\13");
				waitForPageLoad(selenium);
				
				if(!getText(selenium,lblTimeLineSummary).trim().contains(prescribeData.prescribeName.trim())){
					return false;
				}
				
				if(getText(selenium,lblTimeLineSummary).trim().contains(prescribeData1.prescribeName.trim())){
					return false;
				}
			}
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
