package com.nexia.selenium.testscripts.section.clinicalLists.medicationReconciliation;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeleteButtonForPrescribedMedication extends AbstractChartPreVisit{

	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Delete button")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	
	public void DeleteEncounterMedicationReconcillation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_007";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifyDeletePrescribe(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}

	public boolean VerifyDeletePrescribe(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws IOException{
		  Selenium selenium=null;
			boolean returnValue=true;
	try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + medicationData.toString());
				assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, medicationData.userName, medicationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
				//--------------------------------------------------------------------//
				//  Step-2: Advanced search with Patient ID//
				//--------------------------------------------------------------------//				
				searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId);
				waitForPageLoad(selenium);	
				assertTrue(deleteAllPendingMedication(selenium,medicationData),"Deletion failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				//--------------------------------------------------------------------//
				//  Step-3: Delete Medication //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,lnkMedication),"Could not click the link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				assertTrue(deleteMedication(selenium,medicationData),"Deletion Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-4:Create Prescribe Medication//
				//--------------------------------------------------------------------//				
				assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				ChartPreVisitLib medicationData1 = new ChartPreVisitLib();
				medicationData1.workSheetName = "PrescribeMedi";
				medicationData1.testCaseId = "TC_PM_009";
				medicationData1.fetchChartPreVisitTestData();	
				assertTrue(SearchPrescribeMed(selenium,medicationData1,userAccount),"Could not click the link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(addPrescribeMedication(selenium,medicationData1,userAccount),"Creation Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);	
				assertTrue(click(selenium,btnPrint),"Could not click the Print button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);				
				Robot robot = new Robot();
				Thread.sleep(20000);
				robot.keyPress(KeyEvent.VK_ESCAPE); 
				waitForPageLoad(selenium);				
				//--------------------------------------------------------------------//
				//  Step-5: Begin Encounter 										  //
				//--------------------------------------------------------------------//			
				assertTrue(goToBeginEncounter(selenium),"Could not navigate to begin encounter", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(selenium.isVisible(lnkEncounterMedication),"Medication Link is Not Visible;More Details",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);						
				selenium.clickAt(lnkEncounterMedication,"");
				waitForPageLoad(selenium);				
				//--------------------------------------------------------------------//
				//  Step-5: Verify Delete Button 										  //
				//--------------------------------------------------------------------//	
				assertTrue(isElementPresent(selenium,btnDelete),"Delete Button not present for External Medication", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(!isElementVisible(selenium,btnDelete),"Delete button should not be present for Prescribed medication", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
	}

catch(Exception e)
{

assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);

}
return true;
	}



















}
