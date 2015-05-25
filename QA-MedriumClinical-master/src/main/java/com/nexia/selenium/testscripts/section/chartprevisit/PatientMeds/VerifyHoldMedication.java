package com.nexia.selenium.testscripts.section.chartprevisit.PatientMeds;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyHoldMedication extends AbstractChartPreVisit{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for moving current medication in meds tab to history")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHoldMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_097";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		holdMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * holdMedication
	 * Function to hold a medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 06, 2012
	 */
	public boolean holdMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
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
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the Medication tab;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,showPickList,"Current");
			int count=(Integer)selenium.getXpathCount(lblCureentMedsname);
			int counter=2;
			
			
				if(getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeCa)
						||getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeName) ){
					selenium.focus(lnkOption1);
					selenium.clickAt(lnkOption1, "");
					assertTrue(click(selenium,"//a[4]/span"),"Could not click move to Hold button ", selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,"xpath=(//div[@id='panel']/input)[3]","other");
					assertTrue(type(selenium,txtDeleteReaseon,prescribeData.userName),"", selenium, ClassName, MethodName);
					assertTrue(click(selenium,btnContinue),"Could not click continue button", selenium, ClassName, MethodName);
				}
				else{
					while(count>=counter){
						if(getText(selenium,"//div[4]/div["+counter+"]/div").toLowerCase().contains(prescribeData.prescribeName.toLowerCase())
								|| getText(selenium,"//div[4]/div["+counter+"]/div").toLowerCase().contains(prescribeData.prescribeCa.toLowerCase())){
							//assertTrue(click(selenium,"//div[@id='Medications']/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr["+counter+"]/td[2]/div/div"),"Could not click the options button");
							selenium.focus("//div[4]/div["+counter+"]/div[2]/div/a/span");
							selenium.clickAt("//div[4]/div["+counter+"]/div[2]/div/a/span", "");
							assertTrue(click(selenium,"//a[4]/span"),"Could not click the hold button", selenium, ClassName, MethodName);
							selectValueFromAjaxList(selenium,"xpath=(//div[@id='panel']/input)[3]","other");
							assertTrue(type(selenium,txtDeleteReaseon,prescribeData.userName),"", selenium, ClassName, MethodName);
							assertTrue(click(selenium,btnContinue),"Could not click continue button", selenium, ClassName, MethodName);
							break;
						}
						counter++;
					}
				}
			
			selectValueFromAjaxList(selenium,showPickList,"current");
			waitForPageLoad(selenium);
			
			if(!selenium.isTextPresent("Held")){
				Assert.fail("Verify hold failed");
			}
			/*if(!getText(selenium,"//div[4]/div["+counter+"]/div").contains("Held")){
				Assert.fail("Verify hold failed");
			}*/
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
