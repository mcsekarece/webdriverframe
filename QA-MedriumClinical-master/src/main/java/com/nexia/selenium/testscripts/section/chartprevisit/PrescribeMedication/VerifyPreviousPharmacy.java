package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPreviousPharmacy extends AbstractChartPreVisit{
	
	@Test (enabled = false)
	//@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing whether Previous pharmacy function")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchPharmacyMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_079";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySearchPharmacy(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Default Value for Search Pharmacy Within")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultSearchPharmacyWithin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_080";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDefaultValueInSearchPharmacy(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
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
			assertTrue(click(selenium,lnkQuickAction),"Could not click the chart Medication;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"css=#systemSettingsAction > span.actionItemSpan"),"Could not click the chart Medication;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Delete Exist Directories  //
			//--------------------------------------------------------------------//
			SystemSettingsLib directoriesData = new SystemSettingsLib();
			directoriesData.workSheetName = "CreateDirectories";
			directoriesData.testCaseId = "TC_CDIR_001";
			directoriesData.fetchSystemSettingTestData();
			
			if(userAccount.equals(CAAccount)){
				assertTrue(click(selenium,lnkDirectoriesCa),"Could not click the DirectoriesCA link;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}else{
				assertTrue(click(selenium,lnkDirectoriesCa),"Could not click the Directories link;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
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
			//  Step-6: Create a new patient//
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
			//  Step-6: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,ajxProvider,prescribeData.provider);
			selectValueFromAjaxList(selenium,ajxLoaction,prescribeData.loaction);
			if(userAccount.equals(CAAccount)){
			assertTrue(type(selenium,ajxDrugsList,prescribeData.prescribeCa),"Could not type Prescribe Medication;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			}else{
				assertTrue(type(selenium,ajxDrugsList,prescribeData.prescribe),"Could not type Prescribe Medication;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkEdit),"Could not click the Prescribe link;More Deatils:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//Check if the "Proceed Anyway" Button is present
			if(isElementPresent(selenium,btnCancelButton)){
				assertTrue(click(selenium,btnCancelButton),"Could not Click Proceed Anyway button"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(),selenium,ClassName,MethodName);
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
			//  Step-9: Verify Stored Value in Summary page //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnPrint), "Could not click on Add to pending button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			Robot robot = new Robot();
			Thread.sleep(20000);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			selectValueFromAjaxList(selenium,ajxProvider,prescribeData.provider);
			selectValueFromAjaxList(selenium,ajxLoaction,prescribeData.loaction);
			if(userAccount.equals(CAAccount)){
				assertTrue(type(selenium,ajxDrugsList,prescribeData.prescribeCa),"Could not type Prescribe Medication;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				}else{
					assertTrue(type(selenium,ajxDrugsList,prescribeData.prescribe),"Could not type Prescribe Medication;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				}
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkEdit),"Could not click the Prescribe link;More Deatils:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,btnPreviousPharmacy),"Could not click the previous pharmacy button;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(getText(selenium,lblPharmacy).contains(prescribeData.pharmacyName))
				return true;
			else
				Assert.fail("Prevous pharmacy button not working properly");
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
	
	/**
	 * verifyDeafultValueInSearchPharmacy
	 * function to verify Default Value In Search Pharmacy
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Apr 22, 2012
	 */
	
	public boolean verifyDefaultValueInSearchPharmacy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
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
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescribeData.provider = pName;
			
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Check if the "Proceed Anyway" Button is present
			if(isElementPresent(selenium,btnCancelButton)){
				assertTrue(click(selenium,btnCancelButton),"Could not Click Proceed Anyway button"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-4: Click search pharmachy //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnSearchDatabase),"Could not click search pharmachy button;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify default value in search pharmacy //
			//--------------------------------------------------------------------//
			if(isChecked(selenium, chkSearchwithin))
				return true;
			else
				return false;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyStoreValue(Selenium selenium,ChartPreVisitLib prescribeData,SystemSettingsLib directoriesData){
		if(!getText(selenium,lblPharmacyDetails1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(directoriesData.city.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getText(selenium,lblPharmacyDetail2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(directoriesData.country.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		
		if(!getText(selenium,lblPharmacyDetail2).trim().contains(directoriesData.zipcode.trim())){
			return false;
		}
		if(!getText(selenium,lblPharacyDetails3).trim().contains(directoriesData.phone.trim())){
			return false;
		}
		if(!getText(selenium,lblPharacyDetails3).trim().contains(directoriesData.fax1.trim())){
			return false;
		}
		return true;
	}

}	