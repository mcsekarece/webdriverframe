package com.nexia.selenium.testscripts.section.chartprevisit.PatientMeds;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyRestartMedication extends AbstractChartPreVisit{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for restart a medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRestartMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_098";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyRestart(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * verifyRestart
	 * Function to verify restart a medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Nov 20, 2012
	 */
	public boolean verifyRestart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
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
			
			if(!getValue(selenium, lblNoMeds).equalsIgnoreCase("No medication added")){
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
				 returnValue=false;
			}else
				returnValue=false;
			assertTrue(click(selenium,btnPrint),"Could not click the print button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			Robot robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the Medication tab;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-6: MOve current medication to Historical medication //
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,showPickList,"Current");
			int count=(Integer)selenium.getXpathCount(lblCureentMedsname);
			int counter=2;

				if(getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeCa)
						||getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeName)){
					selenium.focus(lnkOption1);
					selenium.clickAt(lnkOption1, "");
					//assertTrue(click(selenium,"//tr[3]/td/div/div[2]/table/tbody/tr/td[2]/div/div"),"Could not click move to History button ");
					if(selenium.isTextPresent("Move to history"))
						assertTrue(click(selenium,"//div[4]/div/div/a/span"),"Could not click move to History button ", selenium, ClassName, MethodName);
				}
				else{
					while(count>=counter){
						if(getText(selenium,"//tr["+counter+"]/td/div/span/div").contains(prescribeData.prescribeCa)
								||getText(selenium,"//tr["+counter+"]/td/div/span/div").contains(prescribeData.prescribeName)){
							//assertTrue(click(selenium,"//td/div/div[2]/table/tbody//tr["+counter+"]/td[2]/div/div"),"Could not click the options button");
							selenium.focus(lnkOption1);
							selenium.clickAt(lnkOption1, "");
							if(selenium.isTextPresent("Move to history"))
								assertTrue(click(selenium,"//div[4]/div/div/a/span"),"Could not click move to History button ", selenium, ClassName, MethodName);
							break;
						}
						counter++;
					}
				}
			
			
			
			//---------------------------------------------------------------------//
			//  Step-7: Restart the medication  //
			//---------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,showPickList,"Historical");
			int count1=(Integer)selenium.getXpathCount(lblHistoryMedsname);
			int counter1=2;
			
				if(getText(selenium,lblHistoryMedsname).contains(prescribeData.prescribeCa)
						||getText(selenium,lblHistoryMedsname).contains(prescribeData.prescribe)){
					//assertTrue(click(selenium, "//tr[3]/td/div/div[2]/table/tbody/tr/td/div/span/div/div/div[4]"), "Could not click on Expand arrow");
					//assertTrue(getValue(selenium, "//div[2]/div/div[2]/span").equalsIgnoreCase("Moved to history"));
					selenium.focus(lnkOption1);
					selenium.clickAt(lnkOption1, "");
					//assertTrue(click(selenium,"//tr[3]/td/div/div[2]/table/tbody/tr/td[2]/div/div"),"Could not click options button");
					assertTrue(click(selenium,lnkCurrentEdit),"Could not click on Restart ", selenium, ClassName, MethodName);
					assertTrue(type(selenium, txtDeleteReaseon, prescribeData.reasonForRestart), "Could not type reason to restart", selenium, ClassName, MethodName);
					assertTrue(click(selenium, btnContinue), "Could not click on continue button", selenium, ClassName, MethodName);
				}
				else{
					while(count1>=counter1){
						if(getText(selenium,"//tr[3]/td/div/div[2]/table/tbody/tr["+counter1+"]/td/div/span/div").contains(prescribeData.prescribeCa)
								||getText(selenium,"//tr[3]/td/div/div[2]/table/tbody/tr["+counter1+"]/td/div/span/div").contains(prescribeData.prescribe)){
							//assertTrue(click(selenium, "//tr[3]/td/div/div[2]/table/tbody/tr["+counter1+"]/td/div/span/div/div/div[4]"), "Could not click on Expand arrow");
							//assertTrue(getValue(selenium, "//tr["+counter1+"]/td/div/span/div/div[2]/div/div[2]/span").equalsIgnoreCase("Moved to history"));
							selenium.focus("//td/div/div[2]/table/tbody//tr["+counter1+"]/td[2]/div/div");
							selenium.clickAt("//td/div/div[2]/table/tbody//tr["+counter1+"]/td[2]/div/div", "");
							//assertTrue(click(selenium,"//tr[3]/td/div/div[2]/table/tbody/tr["+counter1+"]/td[2]/div/div"),"Could not click the options button");
							assertTrue(click(selenium,lnkCurrentEdit),"Could not click on Restart", selenium, ClassName, MethodName);
							assertTrue(type(selenium, txtDeleteReaseon, prescribeData.reasonForRestart), "Could not type reason to restart", selenium, ClassName, MethodName);
							assertTrue(click(selenium, btnContinue), "Could not click on continue button", selenium, ClassName, MethodName);
							break;
						}
						counter1++;
					}
				}
			
			
			
			//---------------------------------------------------------------------//
			//  Step-8: verify Restart medication in current medication  //
			//---------------------------------------------------------------------//
			int count3=(Integer)selenium.getXpathCount(lblCureentMedsname);
			int counter3=2;
			System.out.println(getText(selenium,lblCureentMedsname));
			System.out.println(prescribeData.prescribeCa);
			System.out.println(prescribeData.prescribeName);
				if(getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeCa)
						||getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeName)){
					selenium.focus(lnkOption1);
					selenium.clickAt(lnkOption1, "");
					assertTrue(click(selenium, lnkRestart), "Could not click on Expand arrow", selenium, ClassName, MethodName);
					//assertTrue(getValue(selenium, "//span/div/div[2]/div").contains("Restarted"),"", selenium, ClassName, MethodName);
					//assertTrue(getValue(selenium, "//span/div/div[2]/div").contains(prescribeData.reasonForRestart),"", selenium, ClassName, MethodName);
				}
				else{
					while(count3>=counter3){
						if(getText(selenium,"//tr["+counter3+"]/td/div/span/div").contains(prescribeData.prescribeCa)
								||getText(selenium,"//tr["+counter3+"]/td/div/span/div").contains(prescribeData.prescribeName)){
							//assertTrue(click(selenium, "//tr["+counter3+"]/td/div/span/div/div/div[4]"), "Could not click on Expand arrow");
							selenium.focus("//td/div/div[2]/table/tbody//tr["+counter+"]/td[2]/div/div");
							selenium.clickAt("//td/div/div[2]/table/tbody//tr["+counter+"]/td[2]/div/div", "");
							assertTrue(getValue(selenium, "//tr["+counter3+"]/td/div/span/div/div[2]/div").contains("Restart"),"", selenium, ClassName, MethodName);
							assertTrue(getValue(selenium, "//tr["+counter3+"]/td/div/span/div/div[2]/div").contains(prescribeData.reasonForRestart),"", selenium, ClassName, MethodName);
							break;
						}
						counter++;
					}
				}
			
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
