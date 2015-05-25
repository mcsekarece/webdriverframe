package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchPharmacyWithPrescreibe extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Search Pharmacy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchPharmacyMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_082";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySearchPharmacy(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Ticket no: 6641 ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyNoPharmacyFound(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_001";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySearchPharmacy(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * verifySearchPharmacy
	 * function to verify Search Pharmacy
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Jan 02, 2012
	 */
	
	public boolean verifySearchPharmacy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ",selenium,ClassName,MethodName);;
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Quick Action and click System setting  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSettings),"Could not click the Quick Action Link;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemsetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete Exist Directories  //
			//--------------------------------------------------------------------//
			SystemSettingsLib directoriesData = new SystemSettingsLib();
			directoriesData.workSheetName = "CreateDirectories";
			directoriesData.testCaseId = "TC_CDIR_004";
			directoriesData.fetchSystemSettingTestData();
			
			assertTrue(click(selenium,lnkDirectories),"Could not click the Directories link;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,"suggestBox","Pharmacies");
			waitForPageLoad(selenium);
			
			assertTrue(deleteDirectories(selenium),"Deleteion Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Delete Exist Directories  //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnAddDirectories),"Could not click the add Directories; More details"+directoriesData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(createDirectories(selenium,directoriesData,userAccount),"Directories Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			

			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescribeData.provider = pName;
			
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-8: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnEdit),"Edit button Could not found;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify No Pharmacy Found//
			//--------------------------------------------------------------------//
			
			if(prescribeData.testCaseId.equals("TC_PM_001")){
				
				assertTrue(click(selenium,btnEdit),"Could not click Edit button"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnPreviousPharmacy),"Could not click Previous Pharmacy button"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(!getText(selenium,lblNoPharmacyFound).trim().contains("No pharmacy entry found")){
					Assert.fail("verify No Pharmacy Found failed");
				}
			}
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
	
}
