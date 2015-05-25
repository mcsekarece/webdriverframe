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

public class CancelReferralOrder extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Cancel Refferral ordering Labs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewReferralOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateReferralOrder";
		orderData.testCaseId = "TC_OR_006";
		orderData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		cancelReferralOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	
	/**
	 * cancelReferralOrder
	 * function to cancelReferralOrder
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Jun 10, 2014
	 */
	
	public boolean cancelReferralOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
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
			assertTrue(switchRole(selenium,orderData.switchRole), "could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Create External Provider//
			//--------------------------------------------------------------------//
			
			SystemSettingsLib providerData = new SystemSettingsLib();
			providerData.workSheetName = "CreateExternalProviders";
			providerData.testCaseId = "TC_EP_001";
			providerData.fetchSystemSettingTestData();
			
			assertTrue(click(selenium,lnkSettings),"unable to click settings link",selenium,ClassName,MethodName);
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
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,orderData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Delete Encounter from Encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,orderData),"", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			if(isElementVisible(selenium,ajxProviderSugBox)){
				String str = getText(selenium, lnkTopMenu);
				String Rprovider = str.replaceAll(", " + orderData.switchRole, "");
				String tempArray[] = Rprovider.split(" ");
				String providerName = tempArray[1] + ", " + tempArray[0];

				assertTrue(selectValueFromAjaxList(selenium,ajxProviderSugBox,providerName),"ajx failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				}
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Orders//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteOrders(selenium,orderData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Order referral Page//
			//--------------------------------------------------------------------//
			assertTrue(selenium.isVisible(imgReferralIcon),"Navigation Failed", selenium, ClassName, MethodName);
			
			assertTrue(clickReferralIcon(selenium,orderData),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		
			//--------------------------------------------------------------------//
			//  Step-5: Create Referral Order//
			//--------------------------------------------------------------------//
			
			assertTrue(orderNewReferral(selenium,orderData),"Order Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,allergyTitle)){
				returnValue=true;
			}else
				returnValue=false;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
