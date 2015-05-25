package com.nexia.selenium.testscripts.section.chartprevisit.PatientMeds;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPrintFromPendingMedication extends AbstractChartPreVisit{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for print a pending medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void printPendingMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_004";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyPrintPendingMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * verifyPrintPendingMedication
	 * Function to print Pending medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Mar 04, 2012
	 */
	
	public boolean verifyPrintPendingMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
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
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,prescribeData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-2: Register a patient//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			ChartPreVisitLib prescribeData1 = new ChartPreVisitLib();
			prescribeData1.workSheetName = "NewPatientCheckIn";
			prescribeData1.testCaseId = "TC_NP_001";
			prescribeData1.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,prescribeData1),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescribeData.provider = pName;
			
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnAddToPending), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkGoToPending)){
				returnValue = true;
			}else
				returnValue=false;
			ChartPreVisitLib prescribeData2 = new ChartPreVisitLib();
			prescribeData2.workSheetName = "PrescribeMedi";
			prescribeData2.testCaseId = "TC_PM_009";
			prescribeData2.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkMedicationTab), "Could not click on medication tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkOption1), "Could not click on option button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
				assertTrue(click(selenium,lnkCurrentEdit), "Could not click on Edit button", selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Edit Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData2,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnPrint), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Robot robot = new Robot();
			Thread.sleep(20000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6:Verify stored values //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesInSummaryPage(selenium,prescribeData,userAccount)){
				Assert.fail("Medication details not saved properly; More Details :"+ prescribeData.toString());
				returnValue = false;
			}else 
				return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
	public boolean verifyStoredValuesInSummaryPage(Selenium selenium, ChartPreVisitLib prescribeData,String account) throws IOException{
		String date =null;
		
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("MMMMMMM dd, yyyy");
		 date=DateFormat1.format(cal.getTime());
		
		
		System.out.println(prescribeData.prescribeName);
		System.out.println(prescribeData.prescribeNameCa);
		if(account.equals(CAAccount)){
			if(!getText(selenium, "//div/div/div[4]/div/div/div").trim().contains(prescribeData.prescribeCa.trim()))
				return false;
		}else{
			if(!getText(selenium, "//div/div/div[4]/div/div/div").trim().contains(prescribeData.prescribeName.trim()))
				return false;
		}
		if(isElementPresent(selenium, "css=a.chart-list-item-arrow")){
			assertTrue(click(selenium, "css=a.chart-list-item-arrow"), "Could not click expand link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}

		if(!getText(selenium, "//div/div/div[4]/div/table/tbody").contains("Signed by"))
			return false;
		if(!getText(selenium, "//div/div/div[4]/div/table/tbody").contains(date))
			return false;
		if(!getText(selenium, "//div/div/div[4]/div/table/tbody").contains("ABBY ABRAHAM"))
			return false;
		return true;
	}
}
