package com.nexia.selenium.testscripts.section.chartprevisit.PatientMeds;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySignoffPatientMeds extends AbstractChartPreVisit{
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for restart a medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void signoffPatientMeds(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_020";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySignoffPatientMeds(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	/**
	 * verifySignoffPatientMeds
	 * Function to verify Sign off Patient Meds
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Sep 19, 2012
	 */
	public boolean verifySignoffPatientMeds(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws IOException{
		boolean returnValue=true;
		Selenium selenium=null;
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
			//  Step-3: Delete all existing pending Medication//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllPendingMedication(selenium, prescribeData), "Pending medication deleteion failed", selenium, ClassName, MethodName);
			
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
			//  Step-6: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnAddToPending), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Medication //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the medication", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			int count=(Integer)selenium.getXpathCount(lblCureentMedsname);
			int counter=2;
			if(getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeName)){
				//assertTrue(click(selenium,"//tr[3]/td/div/div[2]/table/tbody/tr/td[2]/div/div"),"Could not click options button");
				selenium.focus(lnkOption);;
				selenium.clickAt(lnkOption, "");
				assertTrue(click(selenium,lnkPendingSign),"Could not click sign button ", selenium, ClassName, MethodName);
				
			}
			else{
				while(count>=counter){
					if(getText(selenium,"//tr["+counter+"]/td/div/span/div").contains(prescribeData.prescribeName)){
						//assertTrue(click(selenium,"//td/div/div[2]/table/tbody//tr["+counter+"]/td[2]/div/div"),"Could not click the options button");
						selenium.focus(lnkOption);;
						selenium.clickAt(lnkOption, "");
						assertTrue(click(selenium,lnkPendingSign),"Could not click the sign button", selenium, ClassName, MethodName);
						break;
					}
					counter++;
				}
			}
			if(getText(selenium,lblMedsPrescribe).trim().contains(prescribeData.prescribeName.trim())){
				return true;
			}else
				return false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
