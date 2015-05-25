package com.nexia.selenium.testscripts.section.chartprevisit.TimeLine;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTimeLineUpdate extends AbstractChartPreVisit {
	@Test(groups = {"SmokeTest","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Time Line Update")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTimeLineUpdate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_046";
		labData.fetchChartPreVisitTestData();
		verifyTimeLineUpdate(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Time Line Update
	* @action 		  verify Time Line Update
	* @author         Aspire QA
	* @throws 		  Exception 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 04, 2013
	***************************************************************************************************/
	public boolean verifyTimeLineUpdate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		boolean expandedView= false;
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
			Thread.sleep(20000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			
			assertTrue(click(selenium,lnkTimeLine),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify simple view of medication in timeline Summary page //
			//--------------------------------------------------------------------//
			if(!verifyMedicationSimpleView(selenium,prescribeData, userAccount,expandedView)){
				Assert.fail("Prescripe details not saved properly; More Details :"+ prescribeData.toString());
				return false;
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-10: Edit the created Prescribe Medication 					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the medication tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"//a/div"),"Could not click the options", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkEdit),"Could not click the edit link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			ChartPreVisitLib prescribeData1 = new ChartPreVisitLib();
			prescribeData1.workSheetName = "PrescribeMedi";
			prescribeData1.testCaseId = "TC_PM_113";
			prescribeData1.fetchChartPreVisitTestData();
			
			assertTrue(addPrescribeMedication(selenium,prescribeData1,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"print"),"Could not click the print button;More Deatils:"+prescribeData.toString(),selenium,ClassName,MethodName);
			robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			
			assertTrue(click(selenium,lnkTimeLine),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//----------------------------------------------------------------------//
			//  Step-11: Verify updated medication details in timeline Summary page //
			//----------------------------------------------------------------------//
			if(!verifyMedicationSimpleView(selenium,prescribeData1, userAccount,expandedView)){
				Assert.fail("Prescripe details not saved properly; More Details :"+ prescribeData.toString());
				return false;
			}
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
	public boolean verifyMedicationSimpleView(Selenium selenium,ChartPreVisitLib prescribeData, String account, boolean expandedView) throws Exception
	{
		String date=null;
		
		String lblPrecrbeMeds="//div[@class='chartPanelHeight centerNoSidePadding']/div/div/div[4]/div/div/div/div[2]";
		
		//String lblPrecrbeMeds  = "//div/div[2]/div[2]/div";
		
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat1;
		
		
		
		if(account.equalsIgnoreCase(CAAccount)){
			DateFormat1=new SimpleDateFormat("MMMM dd, yyyy");
			//selectValueFromAjaxList(selenium,"searchTextBox",prescribeData.prescribeCa);
		}
		else{
			DateFormat1=new SimpleDateFormat("MMMM dd, yyyy");
			//selectValueFromAjaxList(selenium,"searchTextBox",prescribeData.prescribe);
		}
		
		date=DateFormat1.format(cal.getTime());
		System.out.println(getText(selenium,lblPrecrbeMeds));
		System.out.println(date);
		if(!getText(selenium,lblPrecrbeMeds).trim().contains(date.trim())){
			return false;
		}
		
		if(!getText(selenium,lblPrecrbeMeds).trim().contains(prescribeData.refillMethod.trim())){
			return false;
		}
		if(!getText(selenium,lblPrecrbeMeds).toLowerCase().trim().contains(prescribeData.unit.toLowerCase().trim())){
			return false;
		}
		if(!getText(selenium,lblPrecrbeMeds).trim().contains(prescribeData.route.trim())){
			return false;
		}
		if(!getText(selenium,lblPrecrbeMeds).trim().contains(prescribeData.frequency.trim())){
			return false;
		}
		if(!getText(selenium,lblPrecrbeMeds).trim().contains(prescribeData.duration.trim())){
			return false;
		}
		
		return true;
	}
	
}
