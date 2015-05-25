package com.nexia.selenium.testscripts.section.chartprevisit.OrderLabDiReferral;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStoredValueForReferralOrder extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying stored value of a created order for referral")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewReferralOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateReferralOrder";
		orderData.testCaseId = "TC_OR_001";
		orderData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createReferralOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);

	}
	/**
	 * createReferralOrder
	 * function to verify stored value of a created order for referral
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 29, 2012
	 */

	public boolean createReferralOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{

		Selenium selenium=null;
		boolean returnValue=true;
		try{

			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not retrieve the New Selenium Session; More Details :" + orderData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, orderData.userName, orderData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			SystemSettingsLib providerData = new SystemSettingsLib();
			providerData.workSheetName = "CreateExternalProviders";
			providerData.testCaseId = "TC_EP_001";
			providerData.fetchSystemSettingTestData();

			assertTrue(click(selenium,lnkSettings),"Could not click settings link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemsetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkExternalProviderList ),"Could not click on External Providers link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(deleteAllExternalProvider(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,lnkAddReferringProvider),"Could not click on Add External Providers link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueNo=DateFormat.format(cal.getTime());

			assertTrue(createExternalProvider(selenium,providerData,uniqueNo),"External Providers Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			searchPatientNexiaForProviderHomePage(selenium,orderData.patientId);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the Encounter link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllEncounters(selenium,orderData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Orders//
			//--------------------------------------------------------------------//

			assertTrue(deleteOrders(selenium,orderData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Order referral Page//
			//--------------------------------------------------------------------//
			assertTrue(clickReferralIcon(selenium,orderData),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Create Referral Order//
			//--------------------------------------------------------------------//			
			assertTrue(orderNewReferral(selenium,orderData),"Order Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(verifyStoredValues(selenium,orderData), 
					"Contacts details not saved properly in summary section; More Details :"+ orderData.toString(), selenium, ClassName, MethodName);

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib orderData) throws IOException{
		//		waitForPageLoad(selenium);

		assertTrue(isTextPresent(selenium,"Referred To Ahmad, Omar"),"verify Stored Values in encounter page Failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		waitForPageLoad(selenium);	
		waitForPageLoad(selenium);	
		assertTrue(click(selenium,lblDiOrderEditIcon),"", selenium, ClassName, MethodName);
		assertTrue(click(selenium,btnEdit),"", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		if(selenium.isConfirmationPresent()){
			selenium.chooseOkOnNextConfirmation();
		}
		//	if(!getText(selenium,lblReDetails).contains(orderData.referral1))
		//		return false;
		System.out.println(getValue(selenium,txtAuthcode));
		System.out.println(orderData.authorization);
		if(!getValue(selenium,txtAuthcode).contains(orderData.authorization))
			return false;
		assertTrue(click(selenium,btnReferral), "Could not click on save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnSign),"Could not click the sign button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkencounterTab),"Could not click the Encounter link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		click(selenium,"errorCloseButton");
		assertTrue(click(selenium,arrowExpand),"Could not click the expand arrow", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(isTextPresent(selenium,"Referred To Ahmad, Omar"),"verify Stored Values in signed encounter page Failed ", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		return true;
	}	
}
