package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyRunsOutDate extends AbstractChartPreVisit{
	@Test(groups = {"SingleThreadUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the Run out date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void runsOutDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_064";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyRunsoutDate(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify added Repriint is displayed in Print
	* @Specification  SRS_EMR_Med_Summary_PrescribeMedication_Rev0.0
	* @action 		  verifying added quick list problem list is displayed
	* @expected       After add the Medication, When click the Resend, It should shows the Reprint option
	* @author         Aspire QA
	* @defectno 	  #3577
	* @state          Closed
	* @useraccount    Both
	* @since  	      April 16, 2013
	***************************************************************************************************/
	
	@SuppressWarnings("static-access")
	public boolean verifyRunsoutDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		Date date=null;
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
			
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the search button;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			selectValueFromAjaxList(selenium,ajxMedShow,"Current");
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MMMMMMMMMM dd, yyyy");
			cal.add(cal.DATE, 5);
			String date1=DateFormat.format(cal.getTime());
			
			int counter=2;
			
			if(userAccount.equals(CAAccount)){
				if(getText(selenium,lblCuPrescribe).contains(prescribeData.prescribeNameCa)){
					if(getText(selenium,lblRun).contains("Runs out on "+date1+".")){
						return true;
					}
				}else{			
					while(getText(selenium,"//tr["+counter+"]/td/div/span/div").contains(prescribeData.prescribeNameCa)){
						if(getText(selenium,"//tr["+counter+"]/td/div/span/div/div[3]").contains("Runs out on "+date1+".")){
							return true;
						}
						counter++;
						if(counter>20)
							break;
					}
					
				}
				
			}
			else{
				if(getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeName)){
					if(getText(selenium,lblRun).contains("Runs out on "+date+".")){
						return true;
					}
				}else{			
					while(getText(selenium,"//tr["+counter+"]/td/div/span/div").contains(prescribeData.prescribeName)){
						if(getText(selenium,"//tr["+counter+"]/td/div/span/div/div[3]").contains("Runs out on "+date+".")){
							return true;
						}
						counter++;
						if(counter>20)
							break;
					}
				}
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
		
	}

}
