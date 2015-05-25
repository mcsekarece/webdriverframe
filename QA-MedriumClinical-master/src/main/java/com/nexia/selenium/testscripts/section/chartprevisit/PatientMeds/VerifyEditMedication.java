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

public class VerifyEditMedication extends AbstractChartPreVisit {
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Edit  medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_094";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	/**
	 * editMedication
	 * Function to edit Medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 04, 2012
	 */
	
	public boolean editMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue =true;
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
			//assertTrue(click(selenium,lnkMedicationTab),"Could not click the medication tabs");
			//waitForPageLoad(selenium);
			
			assertTrue(deleteAllPendingMedication(selenium,prescribeData),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//if(!getValue(selenium, "css=div.noDataLabel").equalsIgnoreCase("No medication added")){
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
			if(isElementPresent(selenium,btnPrint)){
				returnValue=true;
			}
			assertTrue(click(selenium,btnPrint),"Could not click the print button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Robot robot = new Robot();
			Thread.sleep(20000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the Medication tab;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//}
			//--------------------------------------------------------------------//
			//  Step-6: Edit Medication //
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,ajxMedShow,"Current");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
		
			int count=(Integer)selenium.getXpathCount(lblCureentMedsname);
			int counter=2;
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
				if(getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeCa)
						||getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeName)){
					waitForPageLoad(selenium);
					selenium.focus(lnkOption1);;
					selenium.clickAt(lnkOption1, "");
					//assertTrue(click(selenium,lnkOption),"Could not click options button");
					assertTrue(click(selenium,lnkCurrentEdit),"Could not click Edit button ", selenium, ClassName, MethodName);
				}else{
					while(count>=counter){
						
						if(getText(selenium,"//div[4]/div["+counter+"]/div").toLowerCase().contains(prescribeData.prescribeName.toLowerCase())
								|| getText(selenium,"//div[4]/div["+counter+"]/div").toLowerCase().contains(prescribeData.prescribeCa.toLowerCase())){
							waitForPageLoad(selenium);
							selenium.focus("//div[4]/div["+counter+"]/div[2]/div/a/span");
							selenium.clickAt("//div[4]/div["+counter+"]/div[2]/div/a/span", "");
							
							//assertTrue(click(selenium,"//td/div/div[2]/table/tbody/tr["+counter+"]/td[2]/div/div"),"Could not click the options button");
							assertTrue(click(selenium,lnkCurrentEdit),"Could not click the Edit button", selenium, ClassName, MethodName);
							break;
						}
						counter++;
					}
				}
				
			
			prescribeData.workSheetName = "PrescribeMedi";
			prescribeData.testCaseId = "TC_PM_095";
			prescribeData.fetchChartPreVisitTestData();
			
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Editing Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnPrint)){
				return returnValue;
			}else
				returnValue=false;
			assertTrue(click(selenium,btnPrint),"Could not click the print button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			Robot robot1 = new Robot();
			Thread.sleep(20000);
			robot1.keyPress(KeyEvent.VK_ESCAPE); 
			if(isElementPresent(selenium,lnkMedicationTab))
				returnValue=true;
			else
				returnValue=false;
			
		
			//--------------------------------------------------------------------//
			//  Step-7: verify Store Value //
			//--------------------------------------------------------------------//
			count=(Integer)selenium.getXpathCount(lblCureentMedsname);
			counter=2;
			if(getText(selenium,lblCureentMedsname).toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescribeData.prescribeName.trim().toLowerCase(new java.util.Locale("en","Us")))
					||getText(selenium,lblCureentMedsname).toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescribeData.prescribeCa.trim().toLowerCase(new java.util.Locale("en","Us")))){
				if(!verifyStoreValueForMedication(selenium,prescribeData)){
					returnValue=false;
				}else
					returnValue = true;
			}else{
				while(count>=counter){
					if(getText(selenium,"//div[4]/div["+counter+"]/div").toLowerCase().contains(prescribeData.prescribeName.toLowerCase())
							|| getText(selenium,"//div[4]/div["+counter+"]/div").toLowerCase().contains(prescribeData.prescribeCa.toLowerCase())){
						assertTrue(click(selenium,"//div[4]/div["+counter+"]/div"),"Could not click the arrow link", selenium, ClassName, MethodName);
						if(!verifyStoreValueForMedication(selenium,prescribeData)){
							returnValue=false;
						}else
							returnValue = true;
						//break;
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
	
	public boolean verifyStoreValueForMedication(Selenium selenium,ChartPreVisitLib medicationData){
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MMMM-dd-yyyy");
		System.out.print("Month is :"+ Calendar.MONTH);
		String uniqueName=DateFormat.format(cal.getTime());
		if(!getText(selenium,lblPendingPrecribeName).toLowerCase(new java.util.Locale("en","Us")).trim().contains(medicationData.prescribeName.trim().toLowerCase(new java.util.Locale("en","Us")))
				||!getText(selenium,lblPendingPrecribeName).toLowerCase(new java.util.Locale("en","Us")).trim().contains(medicationData.prescribeCa.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getText(selenium,lblMedicationDetails).contains(uniqueName)){
			return false;
		}
			
		if(!getText(selenium,lblMedicationDetails).toLowerCase(new java.util.Locale("en","Us")).trim().contains(medicationData.providerName.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getText(selenium,lblMedicationDetails).toLowerCase(new java.util.Locale("en","Us")).trim().contains(medicationData.addby.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		
	return true;
	}
}
