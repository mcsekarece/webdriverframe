package com.nexia.selenium.testscripts.section.chartprevisit.MedsQueue;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;

import com.thoughtworks.selenium.Selenium;

public class VerifyCountInMedicationQueue extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying the count of medication in meds queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyShowOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_106";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCount(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * verifyCount
	 * Function to verify count of medication in meds queue
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 26, 2012
	 */
	public boolean verifyCount(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
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
			assertTrue(switchRole(selenium,prescribeData.switchRole), "could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String resultList=getText(selenium,medicationQueue);
			String[] splitS = resultList.split(" ");
			int metricResult1 = Integer.parseInt(splitS[0]);
			System.out.println(metricResult1);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Pending Medication//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllPendingMedication(selenium, prescribeData), "Pending medication deleteion failed", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescribeData.provider = pName;
			
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-5: Add to Pending Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddToPending),"Could not click the Add to Pending button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String resultList1=getText(selenium,medicationQueue);
			String[] split = resultList1.split(" ");
			int metricResult = Integer.parseInt(split[0]);
			System.out.println(metricResult);
			//--------------------------------------------------------------------//
			//  Step-7: compare the count before and after creating the lab report//
			//--------------------------------------------------------------------//
			assertTrue(metricResult>=metricResult1,"Metric results are not equal", selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
