package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyActiveProvidersInPrescripeMedication extends AbstractChartPreVisit {
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Active Providers In Prescripe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyActiveProviderInPrescripe(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_008";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyActiveProviderInPrescripeMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * verifyActiveProviderInPrescripeMedication
	 * function to vverify Active Provider InPrescripe Medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 * @since  	    Sep 18, 2010 
	*/
	public boolean verifyActiveProviderInPrescripeMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData)throws Exception {
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
			//  Step-2: Go to System Settings and navigate to Provider //
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,lnkQuickAction),"Could not found Quick action link;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickAction),"Could not click the Quick action Link;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"css=#systemSettingsAction > span.actionItemSpan"),"Could not click system setting link button;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Create Provider //
			//--------------------------------------------------------------------//
			ChartPreVisitLib providerData = new ChartPreVisitLib();
			providerData.workSheetName = "CreateProvider";
			providerData.testCaseId = "TC_PD_001";
			providerData.fetchChartPreVisitTestData();
			
			assertTrue(deleteProvider(selenium,providerData),"Could not delete the provider",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnProvider),"Could not click add provider;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProviderWithMandatory(selenium,providerData,userAccount),"create Provider failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtSearchProvider, providerData.firstName), "could not type Provider name in search box",selenium,ClassName,MethodName);
			assertTrue(click(selenium, btnSearchProvider), "Could not click on search button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkProvider), "Could not click on Provider",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//Associate Practice into Provider
			assertTrue(addPracticeToProvider(selenium, providerData), "Could not add practice to provider",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to search Patient //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,back),"Could not click the back button;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescribeData.provider = pName;
			
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-7: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verifying Entered Provider are saved properly  //
			//--------------------------------------------------------------------//
			if(!verifyStoredValues(selenium,prescribeData)){
				Assert.fail("Prescribe details are not Create properly; More Details :"+ prescribeData.toString());
				returnValue=false;
			}else
				returnValue=true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib prescribeData) {
		waitForPageLoad(selenium);
		
		if(!getText(selenium,lblPatientName).toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescribeData.patientName.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		
		if(!getText(selenium,lblProviderName).toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescribeData.providerName.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		return true;
	}
}
