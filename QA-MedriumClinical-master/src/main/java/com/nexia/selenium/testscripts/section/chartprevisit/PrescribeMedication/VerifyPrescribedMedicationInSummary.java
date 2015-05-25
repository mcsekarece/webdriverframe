package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;
public class VerifyPrescribedMedicationInSummary extends AbstractChartPreVisit{
	@Test (enabled = false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Prescribe Medication with refills")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPrescribeMedicationWithFreeFrom(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_076";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPrescribe(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test (enabled = false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Prescribe Medication with refills")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPrescribeMedicationWithFreeFormDirections(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_077";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPrescribe(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}

	/**
	 * createPrescribe
	 * Function to create Prescribe
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    Sep 12, 2012
	 */
	public boolean createPrescribe(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
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
			
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			ChartPreVisitLib prescribeData1 = new ChartPreVisitLib();
			prescribeData1.workSheetName = "NewPatientCheckIn";
			prescribeData1.testCaseId = "TC_NP_001";
			prescribeData1.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,prescribeData1),"Patient Checkin Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(SearchPrescribeMedForFreeFrom(selenium,prescribeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnEdit)){
				returnValue=true;
			}else
				returnValue=false;
			assertTrue(click(selenium,btnAddToPending),"Could not click the Print button;More Deatils:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			/*assertTrue(click(selenium,lnkSummary),"Could not click the Summary Tab;More Deatils:"+prescribeData.toString());
			waitForPageLoad(selenium);*/
			if(!verifyStoredValues(selenium, prescribeData,userAccount))
				Assert.fail("The values are not stored in the summary");
			else
				return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
		}
		return false;
	}
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib prescribeData, String account){
		if(account.equals(CAAccount)){
			if(!getText(selenium,lblPrescribeMedsDetails).contains(prescribeData.prescribeNameCa))
				return false;
		}else{
			if(!getText(selenium,lblPrescribeMedsDetails).contains(prescribeData.prescribeName))
				return false;
		}
		if(prescribeData.testCaseId.equals("TC_PM_029")){
			if(!getText(selenium,lblPrescribeMedsDetails).trim().contains(prescribeData.refillMethod.trim())){
				return false;
			}if(account.equals(CAAccount)){
				if(!getText(selenium,lblPrescribeMedsDetails).trim().contains(prescribeData.refillQuantityCa.trim())){
					return false;
				}
			}else{
				if(!getText(selenium,lblPrescribeMedsDetails).trim().contains(prescribeData.refillQuantity.trim())){
					return false;
			}
			if(!getText(selenium,lblPrescribeMedsDetails).trim().contains(prescribeData.refillUnit.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMedsDetails).trim().contains(prescribeData.refillRoute.trim())){
				return false;
			}
			}if(account.equals(CAAccount)){
				if(!getText(selenium,lblPrescribeMedsDetails).trim().contains(prescribeData.refillFrequencyCa.trim())){
					return false;
				}
			}else{
				if(!getText(selenium,lblPrescribeMedsDetails).trim().contains(prescribeData.refillFrequency.trim())){
					return false;
				}
			}
			if(!getText(selenium,lblPrescribeMedsDetails).trim().contains(prescribeData.refillUsage.trim())){
				return false;
			}
		}
		return true;
	}
}