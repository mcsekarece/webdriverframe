package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyBlueBoxEdit extends AbstractChartPreVisit{
	@Test(enabled=false)
	//@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Blue Box Edit for free from")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyBlueBoxEditForFreeFrom(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_075";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		pendingMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	/**
	 * pendingMedication
	 * Function to create Pending medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Sep 18, 2012
	 */
	public boolean pendingMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
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
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,prescribeData.switchRole),"switch role failedS",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete all existing pending Medication//
			//--------------------------------------------------------------------//
			//assertTrue(deleteAllPendingMedication(selenium, prescribeData), "Pending medication deleteion failed");
			//waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			
			String providerName= providerNameTemp.replaceAll(", FULL", "");
			
			String tempArray[]=providerName.split(" ");
			
			String pName=tempArray[1]+", "+tempArray[0];
			//sets the current provider name
			prescribeData.provider=pName;
			
			assertTrue(SearchPrescribeMedForFreeFrom(selenium,prescribeData,userAccount),"Could not click the Free from link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnAddToPending), "Could not click on Add to pending button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkGoToPending)){
				 returnValue=true;
			}else
				Assert.fail("Blue box not present");
			assertTrue(click(selenium,lnkGoToPending),"Could not click the Go to Pending link"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnlPendingEdit),"Could not clink on the edit button"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			prescribeData.workSheetName = "PrescribeMedi";
			prescribeData.testCaseId = "TC_PM_029";
			prescribeData.fetchChartPreVisitTestData();
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnAddToPending), "Could not click on Add to pending button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(verifyStoredValuesInPendingPrescriptions(selenium,prescribeData,userAccount))
				return returnValue;
			else
				Assert.fail("The values are not stored properly in pending prescription page");
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
		}
		return false;
	}
public boolean verifyStoredValuesInPendingPrescriptions(Selenium selenium, ChartPreVisitLib prescribeData, String account){
		
	if(account.equals(CAAccount)){
		if(!getText(selenium,lblPendingDetails1).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.prescribeNameCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
		}
	}else{
		if(!getText(selenium,lblPendingDetails1).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.prescribeName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
	}
	}
		if(!getText(selenium,lblPendingDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.direction.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
		}
		if(!selenium.isElementPresent(lnlPendingEdit)){
			return false;
		}
		if(!selenium.isElementPresent(lblPending1)){
			return false;
		}
		if(!selenium.isElementPresent(lblPending2)){
			return false;
		}
		return true;
	}	
}