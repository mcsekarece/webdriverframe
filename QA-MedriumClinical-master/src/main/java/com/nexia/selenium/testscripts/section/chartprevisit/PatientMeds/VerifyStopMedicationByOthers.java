package com.nexia.selenium.testscripts.section.chartprevisit.PatientMeds;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStopMedicationByOthers extends AbstractChartPreVisit{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for stop medication by other reason")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStopMedicationByOthers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_065";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		stopMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}

	/*************************************************************************************************** 
	* @purpose        To verifying stop medication by other reason
	* @action 		  verifying stop medication by other reason
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      April 26, 2013
	***************************************************************************************************/
	public boolean stopMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		int count=0;
		int counter=1;
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
			Thread.sleep(5000);
			waitForPageLoad(selenium);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the Medication tab;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MMMM dd, yyy");
			String uniqueName=DateFormat.format(cal.getTime());
			System.out.println(uniqueName);
			
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxRxShow,"Current");
			waitForPageLoad(selenium);
			
			
			count=(Integer)selenium.getXpathCount(lblStopPrescribe);
			counter=1;
			
			//verify Stop Medication 
			
			if(getText(selenium,lblCureentMedsname).toLowerCase().contains(prescribeData.prescribeName.toLowerCase())
					|| getText(selenium,lblCureentMedsname).toLowerCase().contains(prescribeData.prescribeCa.toLowerCase())){
				selenium.focus(lnkOption1);
				selenium.clickAt(lnkOption1, "");
				assertTrue(click(selenium,"//a[3]/span"),"Could not click the stop button", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium,ajxDeleteReaseon,prescribeData.reasonForDelete), "", selenium, ClassName, MethodName);
				type(selenium, txtDeleteReaseon, prescribeData.reasonForRestart);
				assertTrue(click(selenium,btnContinue),"Could not click continue button", selenium, ClassName, MethodName);
			}else{
			
				while(count>=counter){
					if(getText(selenium,"//div[4]/div["+counter+"]/div").toLowerCase().contains(prescribeData.prescribeName.toLowerCase())
							|| getText(selenium,"//div[4]/div["+counter+"]/div").toLowerCase().contains(prescribeData.prescribeCa.toLowerCase())){
						selenium.focus("//div[4]/div["+counter+"]/div[2]/div/a/span");
						selenium.clickAt("//div[4]/div["+counter+"]/div[2]/div/a/span", "");
						assertTrue(click(selenium,"//a[3]/span"),"Could not click the stop button", selenium, ClassName, MethodName);
						assertTrue(selectValueFromAjaxList(selenium,ajxDeleteReaseon,prescribeData.reasonForDelete), "", selenium, ClassName, MethodName);
						type(selenium, txtDeleteReaseon, prescribeData.reasonForRestart);
						assertTrue(click(selenium,btnContinue),"Could not click continue button", selenium, ClassName, MethodName);
						break;
					}
					counter++;
					if(counter>15){
						break;
					}
				}
				
			}
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Stop the medication because of other reason 		      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,"yes"),"Could not click the replace Yes button ", selenium, ClassName, MethodName);
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
