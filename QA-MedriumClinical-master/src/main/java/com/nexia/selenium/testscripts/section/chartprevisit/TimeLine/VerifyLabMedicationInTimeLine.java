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

public class VerifyLabMedicationInTimeLine extends AbstractChartPreVisit {
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Lab Medication In TimeLine")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabMedicationInTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_046";
		labData.fetchChartPreVisitTestData();
		verifyLabMedicationInTimeLine(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Lab Medication In TimeLine
	* @action 		  Verify Lab Medication In TimeLine
	* @author         Aspire QA
	* @throws 		  Exception 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Aug 23, 2013
	***************************************************************************************************/
	public boolean verifyLabMedicationInTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws Exception{
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
			//  Step-10: Verify simple view of Lab in timeline Summary page 	  //
			//--------------------------------------------------------------------//
			if(!verifyLabSimpleView(selenium,labData, userAccount,expandedView)){
				Assert.fail("Prescripe details not saved properly; More Details :"+ prescribeData.toString());
				return false;
			}
			
			//----------------------------------------------------------------------//
			//  Step-11: Verify Expanded view of medication in timeline Summary page//
			//----------------------------------------------------------------------//
			expandedView = true;
			if(!verifyMedicationSimpleView(selenium,prescribeData, userAccount, expandedView)){
				Assert.fail("Prescripe details not saved properly; More Details :"+ prescribeData.toString());
				return false;
			}
			
			//--------------------------------------------------------------------//
			//  Step-12: Verify Expanded view of Lab in timeline Summary page 	  //
			//--------------------------------------------------------------------//
			if(!verifyLabSimpleView(selenium,labData, userAccount, expandedView)){
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
		
		String lblPrecrbeMeds="//div[@class='chartPanelHeight centerNoSidePadding']/div/div/div[4]/div/div/div[1]/div[2]/div[1]";
		String lnkExpandMed="//a[@class='closedArrowTimeline']";
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat1;
		
		if(account.equalsIgnoreCase(CAAccount)){
			DateFormat1=new SimpleDateFormat("MMMM dd, yyyy");
		}
		else{
			DateFormat1=new SimpleDateFormat("MMMM dd, yyyy");
		}
		
		date=DateFormat1.format(cal.getTime());
		if(account.equalsIgnoreCase(CAAccount)){
			if(!getText(selenium, lblPrecrbeMeds).contains(prescribeData.prescribeCa)){
				return false;
			}
		}
		else{
			if(!getText(selenium, lblPrecrbeMeds).contains(prescribeData.prescribe)){
				return false;
			}
		}
		
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
		
		
		
		if(expandedView){
			if(isElementPresent(selenium, lnkExpandMed)){
				click(selenium, lnkExpandMed);
			}
			
			if(!getText(selenium,lblPrecrbeMeds).trim().contains(date.trim())){
				return false;
			}
		}
		
		return true;
	}
	
	
	public boolean verifyLabSimpleView(Selenium selenium,ChartPreVisitLib labData, String account, boolean expandedView) throws Exception
	{
		String date=null;
		
		String lblSummaryLab="//div[@class='chartPanelHeight centerNoSidePadding']/div/div/div[4]/div/div/div[1]/div[2]/div[2]";
		
		String lnkExpandLab="css=a.closedArrowTimeline";
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat1;
		
		if(account.equalsIgnoreCase(CAAccount)){
			DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
		}
		else{
			DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
		}
		
		date=DateFormat1.format(cal.getTime());
		
		
	
		if(!getText(selenium, lblSummaryLab).contains(labData.labName)){
			return false;
		}
		
		if(!getText(selenium,lblSummaryLab).trim().contains(labData.cTime.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryLab).trim().contains(date.trim())){
			return false;
		}
		
		if(expandedView){
			if(isElementPresent(selenium, lnkExpandLab)){
				click(selenium, lnkExpandLab);
			}
			
			if(!getText(selenium,lblSummaryLab).trim().contains(labData.testName.trim())){
				return false;
			}
			if(!getText(selenium,lblSummaryLab).trim().contains(labData.result.trim())){
				return false;
			}
			if(!getText(selenium,lblSummaryLab).trim().contains(labData.low.trim())){
				return false;
			}
			if(!getText(selenium,lblSummaryLab).trim().contains(labData.high.trim())){
				return false;
			}
			if(!getText(selenium,lblSummaryLab).trim().contains(labData.units.trim())){
				return false;
			}
			if(!getText(selenium,lblSummaryLab).trim().contains(labData.comments.trim())){
				return false;
			}
		}

		return true;
	}
}
