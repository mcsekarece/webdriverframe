package com.nexia.selenium.testscripts.section.chartprevisit.QuickList;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySamePrescribeMedicationInQuickList extends AbstractChartPreVisit{
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Same Prescribe Medication In QuickList")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFreeTextPrescribeMedicationQuickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_055";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPrescribe(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Same Prescribe Medication In QuickList
	* @action 		  Verify Same Prescribe Medication In QuickList
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      June 03, 2013
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
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Create a new patient and get Patient Id					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			ChartPreVisitLib prescribePatientData = new ChartPreVisitLib();
			prescribePatientData.workSheetName = "NewPatientCheckIn";
			prescribePatientData.testCaseId = "TC_NP_001";
			prescribePatientData.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,prescribePatientData),"Patient Checkin Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete all Quick list items								  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnPrescibeQuick),"Could not click the QuickList button;More details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			while((Integer) selenium.getXpathCount(ajxMedsQuickUs)>0){
				assertTrue(click(selenium,lnkPrescribeDelete1),"Could not delete the QuickList value;More details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnPrescibeQuick),"Could not click the QuickList button;More details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-6: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnPrint),"Could not click the print button;More Deatils:"+prescribeData.toString(),selenium,ClassName,MethodName);
			Robot robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			
			click(selenium, btnBack);
			
			
			
			//--------------------------------------------------------------------//
			//  Step-7: Create a new patient and get Patient Id					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			prescribePatientData = new ChartPreVisitLib();
			prescribePatientData.workSheetName = "NewPatientCheckIn";
			prescribePatientData.testCaseId = "TC_NP_001";
			prescribePatientData.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,prescribePatientData),"Patient Checkin Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
		
			selectValueFromAjaxList(selenium,ajxProvider,prescribeData.provider);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxLoaction,prescribeData.loaction);
			waitForPageLoad(selenium);
			
			selenium.typeKeys(ajxDrugsList, "\b");
			selenium.type(ajxDrugsList, "");
			waitForPageLoad(selenium);
			selenium.focus(ajxDrugsList);
			
			if(userAccount.equals(CAAccount)){
				
				selenium.type(ajxDrugsList,prescribeData.prescribeCa);
				waitForPageLoad(selenium);
			}else{
				selenium.type(ajxDrugsList,prescribeData.prescribe);
				waitForPageLoad(selenium);
			}
			
			selenium.fireEvent(ajxDrugsList,"keydown");
			selenium.fireEvent(ajxDrugsList,"keypress");                           
			selenium.fireEvent(ajxDrugsList,"keyup");
			
			waitForPageLoad(selenium);
			selenium.typeKeys(ajxDrugsList, "\b");
			
			click(selenium, "//div[4]/div/div/div/div/div[2]");
			
			
			if(isElementPresent(selenium,"//img[@title='Patient']")){
				assertTrue(click(selenium,lnlEdit2),"Could not click the Prescribe link;More Deatils:"+prescribeData.toString(),selenium,ClassName,MethodName);
			 }else
				 assertTrue(click(selenium,lnlEdit2),"Could not click the Prescribe link;More Deatils:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-10: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnPrint),"Could not click the print button;More Deatils:"+prescribeData.toString(),selenium,ClassName,MethodName);
			robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			
	
			
			//--------------------------------------------------------------------//
			//  Step-11: Verify the same quick list value for different patient //
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,ajxProvider,prescribeData.provider);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxLoaction,prescribeData.loaction);
			if(userAccount.equals(CAAccount)){
				
				selenium.type(ajxDrugsList,prescribeData.prescribeCa);
				waitForPageLoad(selenium);
			}else{
				selenium.type(ajxDrugsList,prescribeData.prescribe);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,btnPrescibeQuick),"Could not click quick list button"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			int qlCount=2;
			for(int count=1;count<=qlCount;count++){
				if(userAccount.equals(CAAccount)){
					if(!getText(selenium, "//body/div[4]/div/div/div/div/div["+count+"]").contains(prescribeData.prescribeCa)){
						return false;
					}
				}
				else{
					if(!getText(selenium, "//body/div[4]/div/div/div/div/div["+count+"]").contains(prescribeData.prescribe)){
						return false;
					}
				}
			}
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
}
