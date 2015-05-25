package com.nexia.selenium.testscripts.section.chartprevisit.PatientHandOuts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPatientHandoutWithSearchDrugName extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Prescribe Medication with Increasing/Decreasing dose")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientOrderDataWithDrugPrescribeName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_025";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		verifyDrugName(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * verifyDrugName
	 * function to verifyDrugName
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 28, 2012
	 */
	
	public boolean verifyDrugName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{
		boolean returnValue=true;
		Selenium selenium=null;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + orderData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, orderData.userName, orderData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,orderData.switchRole), "could not switch the role" , selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,orderData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-4:Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			
			selenium.focus(imbPrescribeIcon);
			selenium.clickAt(imbPrescribeIcon, "");
			
			/*waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,imbPrescribeIcon),"Could not click the img");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);*/
			//--------------------------------------------------------------------//
			//  Step-5: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(SearchPrescribeMed(selenium,orderData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,orderData.reason),"Could not type reason;More Details:"+orderData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+orderData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: create Prescribe Medication //
			//--------------------------------------------------------------------//

			assertTrue(addPrescribeMedication(selenium,orderData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddToPending),"Could not click the print optiion", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to View Handouts //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,elementPatienHandOutLink ), "Could not click on patient handouts link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: click on Patient Handout link //
			//--------------------------------------------------------------------//
			int count=1;
			
				while(getText(selenium,lblHandoutsPrescribe).toLowerCase(new java.util.Locale("en","Us")).trim().contains(orderData.prescribeNameCa.trim().toLowerCase(new java.util.Locale("en","Us")))
						|| getText(selenium,lblHandoutsPrescribe).toLowerCase(new java.util.Locale("en","Us")).trim().contains(orderData.prescribeName.trim().toLowerCase(new java.util.Locale("en","Us")))){
					if(getText(selenium,"//div["+count+"]/div/div/span/span").toLowerCase(new java.util.Locale("en","Us")).trim().contains(orderData.prescribeNameCa.trim().toLowerCase(new java.util.Locale("en","Us")))
							||getText(selenium,"//div["+count+"]/div/div/span/span").toLowerCase(new java.util.Locale("en","Us")).trim().contains(orderData.prescribeName.trim().toLowerCase(new java.util.Locale("en","Us")))){
						assertTrue(click(selenium,"//div["+count+"]/div/div[2]/a"),"", selenium, ClassName, MethodName);
						break;
					}else
					count++;
					if(count>3)
						break;
				}
			
			waitForPageLoad(selenium);
			String st1[]=selenium.getAllWindowNames();
			
			switchto(st1[1]);
			selenium.selectWindow(st1[1]);
			selenium.windowFocus();
			
		
			assertTrue(click(selenium,lnkDrugs),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxSearchtext,orderData.prescribe);
			//assertTrue(type(selenium,"searchtext_primary",orderData.prescribe),"Could not type prescribe Name");
			assertTrue(click(selenium,lnkSearch),"Could not click the Go button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lblPatient)){
				returnValue=true;
			}else
				returnValue=false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	return returnValue;
	}
	private void switchto(String string) {
		// TODO Auto-generated method stub
		
	}
}
