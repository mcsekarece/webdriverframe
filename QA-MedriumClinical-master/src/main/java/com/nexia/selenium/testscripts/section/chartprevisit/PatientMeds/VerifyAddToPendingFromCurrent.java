package com.nexia.selenium.testscripts.section.chartprevisit.PatientMeds;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAddToPendingFromCurrent extends AbstractChartPreVisit {
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Stop Medication In Allergy Interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAddToPendingFromCurrent(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_051";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		stopMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify deletion of a pendig medication
	* @action 		  Delete pending prescribe medication
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      April 11, 2013
	***************************************************************************************************/
	public boolean stopMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
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
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,prescribeData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
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
			//  Step-5: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
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
			//  Step-6 : create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnEdit)){
				 returnValue=true;
			}else
				returnValue=false;
			assertTrue(click(selenium,btnPrint),"Could not click the print button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			Robot robot = new Robot();
			Thread.sleep(20000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
		
			//--------------------------------------------------------------------//
			//  Step-7 : Move to Add To Pending//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the medication link;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnOptions),"Could not click the option button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkAddToPending),"Could not click the option button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxRxShow,"Pending");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//assertTrue(click(selenium,btnOption),"Could not click the option button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			//assertTrue(click(selenium,btnAddToPending1),"Could not click the option button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-8 : Delete Pending Medication//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllPendingMedication(selenium, prescribeData), "Pending medication deleteion failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-9 : Verify Current Medication//
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium, ajxRxShow, "Current");
			waitForPageLoad(selenium);
			if((selenium.isTextPresent(prescribeData.prescribeCa))|| (selenium.isTextPresent(prescribeData.prescribe))){
				return returnValue;
			}
			else 
			 returnValue=false;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
