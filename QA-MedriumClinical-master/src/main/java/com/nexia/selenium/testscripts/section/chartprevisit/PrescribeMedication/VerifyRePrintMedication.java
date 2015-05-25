

package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyRePrintMedication extends AbstractChartPreVisit{
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Reprint a Prescribe Medication ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRePrint(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_009";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		rePrintMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}

	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Resend cancel a Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelResendMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_081";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		rePrintMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify added Repriint is displayed in Print
	* @Specification  SRS_EMR_Med_Summary_PrescribeMedication_Rev0.0
	* @action 		  verifying added quick list problem list is displayed
	* @expected       After add the Medication, When click the Resend, It should shows the Reprint option
	* @author         Aspire QA
	* @defectno 	  #1186
	* @state          Closed
	* @useraccount    Both
	* @since  	      April 16, 2013
	***************************************************************************************************/
	
	public boolean rePrintMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ",selenium,ClassName,MethodName);;
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescribeData.provider = pName;
			
			
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-5: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnPrint),"Could not click the Print button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			Robot robot = new Robot();
			Thread.sleep(20000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			assertTrue(click(selenium, lnkMore),	"Could not click on More  link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the search button;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,"suggestBox","Current");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			int count2=(Integer)selenium.getXpathCount(lblCureentMedsname);
			int counter2=2;
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeNameCa)
					||getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeName)){
				
				assertTrue(click(selenium,btnOptions),"Could not click on the option button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnAddToPending1),"Could not click on the Resend button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			
			}else{			
				while(getText(selenium,"//tr["+counter2+"]/td/div/span/div").contains(prescribeData.prescribeNameCa)||getText(selenium,"//tr["+counter2+"]/td/div/span/div").contains(prescribeData.prescribeName)){
					if(getText(selenium,"//tr["+counter2+"]/td/div/span/div").contains(prescribeData.prescribeNameCa)
						||getText(selenium,"//tr["+counter2+"]/td/div/span/div").contains(prescribeData.prescribeName))
						waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
						selenium.focus("//td/div/div[2]/table/tbody//tr["+counter2+"]/td[2]/div/div");
						selenium.clickAt("//td/div/div[2]/table/tbody//tr["+counter2+"]/td[2]/div/div", "");
						assertTrue(click(selenium,"//div[4]/div/div/div[6]"),"Could not click on the Resend button",selenium,ClassName,MethodName);
						
						counter2++;
					if(count2<counter2)
						break;
				}
			}
			
			if(prescribeData.testCaseId.equals("TC_PM_009")){
				assertTrue(click(selenium,btnRePrint),"Could not click the reprint button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtRePrintreason,prescribeData.reason),"Could not type the Reprint reason",selenium,ClassName,MethodName);
				assertTrue(type(selenium,txtRePassword,prescribeData.userPassword),"Could not type the password",selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnSave),"Could not click the Save  button",selenium,ClassName,MethodName);
				
				Thread.sleep(20000);
				robot.keyPress(KeyEvent.VK_ESCAPE); 
			}else{
				assertTrue(click(selenium,btnResendCancel),"Could not click the reprint button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			if(isElementPresent(selenium,ajxProvider)){
				returnValue=true;
			}else{
				Assert.fail("Prescribe Page is not getting displayed");
				return false;
			}

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
		
	}
}
