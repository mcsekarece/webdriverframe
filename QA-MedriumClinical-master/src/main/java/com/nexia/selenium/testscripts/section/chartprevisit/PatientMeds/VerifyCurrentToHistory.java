package com.nexia.selenium.testscripts.section.chartprevisit.PatientMeds;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCurrentToHistory extends AbstractChartPreVisit{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for moving current medication in meds tab to history")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCurrentToHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_093";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		moveToHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * moveToHistory
	 * Function to verify moving a medication from current to History
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Nov 19, 2012
	 */
	public boolean moveToHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=false;
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
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Delete MEdication//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the medication tabs", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllPendingMedication(selenium,prescribeData),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
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
			
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-5: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnEdit)){
				 returnValue=true;
			}else
				returnValue=false;
			assertTrue(click(selenium,"print"),"Could not click the print button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			
			Robot robot = new Robot();
			Thread.sleep(20000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			waitForPageLoad(selenium);
		
			
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the Medication tab;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxMedShow,"Current");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			
			int count=(Integer)selenium.getXpathCount(lblCureentMedsname);
			int counter=2;
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
		
				if(getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeCa)
						|| getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeName)){
					selenium.focus(lnkOption1);
					selenium.clickAt(lnkOption1, "");
					
					if(selenium.isTextPresent("Move to history"))
					assertTrue(click(selenium,"//div[4]/div/div/a/span"),"Could not click move to History button ", selenium, ClassName, MethodName);
					
				}
				else{
					while(count>=counter){
						if(getText(selenium,"//div[4]/div["+counter+"]/div").toLowerCase().contains(prescribeData.prescribeName.toLowerCase())
								|| getText(selenium,"//div[4]/div["+counter+"]/div").toLowerCase().contains(prescribeData.prescribeCa.toLowerCase())){
							selenium.focus("//div[4]/div["+counter+"]/div[2]/div/a/span");
							selenium.clickAt("//div[4]/div["+counter+"]/div[2]/div/a/span", "");
						
							if(selenium.isTextPresent("Move to history"))
								assertTrue(click(selenium,"//div[4]/div/div/a/span"),"Could not click move to History button ", selenium, ClassName, MethodName);
							break;
						}
						counter++;
					}
				}
				
				selectValueFromAjaxList(selenium,ajxMedShow,"Historical");
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				
				int count1=(Integer)selenium.getXpathCount(lblHistoryMedsname);
				int counter1=2;
				if(getText(selenium,lblHistoryMedsname).contains(prescribeData.prescribeCa)
						|| getText(selenium,lblHistoryMedsname).contains(prescribeData.prescribeName)){
					selenium.focus(lnkOption1);
					selenium.clickAt(lnkOption1, "");
					assertTrue(click(selenium,lnkHistory),"Could not click move to History button ", selenium, ClassName, MethodName);
					
				}else{
					while(count1>=counter1){
						if(getText(selenium,"//tr[3]/td/div/div[2]/table/tbody/tr["+counter1+"]/td/div/span/div").contains(prescribeData.prescribeCa)
								||getText(selenium,"//tr[3]/td/div/div[2]/table/tbody/tr["+counter1+"]/td/div/span/div").contains(prescribeData.prescribeName)){
							selenium.focus("//tr[3]/td/div/div[2]/table/tbody/tr["+counter1+"]/td[2]/div/div");
							selenium.clickAt("//tr[3]/td/div/div[2]/table/tbody/tr["+counter1+"]/td[2]/div/div", "");
							
							
							assertTrue(click(selenium,lnkHistory),"Could not click the move to history button", selenium, ClassName, MethodName);
							break;
						}
						counter1++;
					}
				}
			
			int count2=(Integer)selenium.getXpathCount(lblCureentMedsname);
			if(count==count2)
				returnValue=true;
			else
				returnValue=false;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}
