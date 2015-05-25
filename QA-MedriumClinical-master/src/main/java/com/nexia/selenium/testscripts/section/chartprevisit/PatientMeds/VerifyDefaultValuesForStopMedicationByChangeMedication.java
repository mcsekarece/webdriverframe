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

public class VerifyDefaultValuesForStopMedicationByChangeMedication extends AbstractChartPreVisit{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Default Values For Stop Medication By Change Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStopMedicationByOthers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_066";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		stopMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}

	/*************************************************************************************************** 
	* @purpose        To Verifying Default Values For Stop Medication By Change Medication
	* @action 		  Verify Default Values For Stop Medication By Change Medication
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      April 30, 2013
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
			
			String tempProvider=getText(selenium,lnkTopMenu);
            String providerNameInTop = tempProvider.replaceAll(", FULL", "");
            
            String tempProviderNameInPrescribe[]=providerNameInTop.split(" ");
            String providerNameInPrescribe=tempProviderNameInPrescribe[1]+", "+tempProviderNameInPrescribe[0];
            
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
			waitForPageLoad(selenium);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			if(isElementPresent(selenium,lnkMedicationTab))
			click(selenium, lnkMedicationTab);
				
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MMMMMMM dd, yyyy");
			String uniqueName=DateFormat.format(cal.getTime());
			System.out.println(uniqueName);
			
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxRxShow,"Current");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			count=(Integer)selenium.getXpathCount("//div[@id='Medications']/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr/td/div/span/div");
			counter=1;
			
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
				}
			}
			
		
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Stop the medication because of Change in medication/dose  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,"yes"),"Could not click the save allergy", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------------//
			//  Step-8: Verify Default Values For Stop Medication By Change Medication  //
			//--------------------------------------------------------------------------//
			if(getText(selenium,ajxProvider).equalsIgnoreCase(providerNameInPrescribe)){
				if(getText(selenium,ajxDrugsList).equalsIgnoreCase(prescribeData.prescribeCa)
					||getText(selenium,ajxDrugsList).equalsIgnoreCase(prescribeData.prescribe)){
						returnValue= true;
					}
				}
			else{
				return false;
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-9: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------------------------------//
			//  Step-10: Verify notes to pharmacy shows, "this medication replaces " old medication name  //
			//--------------------------------------------------------------------------------------------//
			if(isElementPresent(selenium, txtNotesToPharmacy)){
				
					if(getText(selenium,txtNotesToPharmacy).contains("This medication replaces "+prescribeData.prescribeCa)
							|| getText(selenium,txtNotesToPharmacy).contains("This medication replaces "+prescribeData.prescribe)){
						returnValue= true;
					}
				}
			
			else{
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
