package com.nexia.selenium.testscripts.section.chartprevisit.QuickList;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPrescribeMedicationQuickList extends AbstractChartPreVisit{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying created prescribed medication quick list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyQuickListIcon(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_049";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPrescribe(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Directions for created prescribed medication quick list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDirectionPrescribeMedicationQuickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_054";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPrescribe(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Free text for created prescribed medication quick list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFreeTextPrescribeMedicationQuickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_055";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPrescribe(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Incres/ Decrees Dosage for created prescribed medication quick list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIncresDecresPrescribeMedicationQuickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_056";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPrescribe(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Multiple Direction for created prescribed medication quick list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMultiDirectionPrescribeMedicationQuickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_057";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createPrescribe(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/*************************************************************************************************** 
	* @purpose        To Verify created prescribed medication quick list
	* @action 		  Verifying created prescribed medication quick list 
	* @expected       After add the medication, When click the quick list, It should shows the added medication
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      April 03, 2013
	***************************************************************************************************/
	
	public boolean createPrescribe(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Create a new patient and get Patient Id					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			ChartPreVisitLib prescribePatientData = new ChartPreVisitLib();
			prescribePatientData.workSheetName = "NewPatientCheckIn";
			prescribePatientData.testCaseId = "TC_NP_001";
			prescribePatientData.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,prescribePatientData),"Patient Checkin Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete all Quick list items								  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnPrescibeQuick),"Could not click the QuickList button;More details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			while((Integer) selenium.getXpathCount(ajxMedsQuickUs)>0){
				assertTrue(click(selenium,lnkPrescribeDelete),"Could not delete the QuickList value;More details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnPrescibeQuick),"Could not click the QuickList button;More details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-6: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
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
			
			assertTrue(click(selenium,btnPrint),"Could not click the print button;More Deatils:"+prescribeData.toString(),selenium,ClassName,MethodName);
			Robot robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify created quick list //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			if(userAccount.equals(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,prescribeData.prescribeCa),"Could not type Prescribe Medication;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}else{
				assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,prescribeData.prescribe),"Could not type Prescribe Medication;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			
			
			if(prescribeData.testCaseId.equals("TC_PM_049")){
				click(selenium,btnPrescibeQuick);
				waitForPageLoad(selenium);
				
				if(isElementPresent(selenium,imgPrescribeStar)){
					return true;
				}
				else{
					Assert.fail("Quick list icon didn't appear");
				}
			}
			assertTrue(click(selenium,btnPrescibeQuick),"Could not click quick list button"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnlPopQuickList),"Could not click quick list button"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxProvider,prescribeData.provider);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxLoaction,prescribeData.loaction);
			
			assertTrue(click(selenium,lnkEdit),"Could not click the Prescribe link;More Deatils:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			if(getText(selenium,lblQukPrescribe).contains(prescribeData.prescribeName)||
					getText(selenium,lblQukPrescribe).contains(prescribeData.prescribeNameCa)){
				assertTrue(verifyStoredRefillsPrescribeQuickList(selenium,prescribeData, userAccount),"Verification in Refills Prescribe medication Quick list failed"+prescribeData.toString(),selenium,ClassName,MethodName);
				
				if(prescribeData.testCaseId.equalsIgnoreCase("TC_PM_054")){
					assertTrue(verifyStoredDirectionPrescribeQuickList(selenium,prescribeData, userAccount),"Verification in Direction Prescribe medication Quick list failed"+prescribeData.toString(),selenium,ClassName,MethodName);
				}
				else if(prescribeData.testCaseId.equalsIgnoreCase("TC_PM_055")){
					assertTrue(verifyStoredFreeTextPrescribeQuickList(selenium,prescribeData),"Verification in Free text Prescribe medication Quick list failed"+prescribeData.toString(),selenium,ClassName,MethodName);
				}
				else if(prescribeData.testCaseId.equalsIgnoreCase("TC_PM_056")){
					assertTrue(verifyStoredIncresDecresPrescribeQuickList(selenium,prescribeData, userAccount),"Verification in increase decrease dosage Prescribe medication Quick list failed"+prescribeData.toString(),selenium,ClassName,MethodName);
				}
				else if(prescribeData.testCaseId.equalsIgnoreCase("TC_PM_057")){
					assertTrue(verifyStoredMultipleDirectionPrescribeQuickList(selenium,prescribeData, userAccount),"Verification in Multiple Direction Prescribe medication Quick list failed"+prescribeData.toString(),selenium,ClassName,MethodName);
				}
			}else
				returnValue=false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
	
	
	public boolean verifyStoredRefillsPrescribeQuickList(Selenium selenium, ChartPreVisitLib prescribeData, String account){
		if(account.equalsIgnoreCase(CAAccount)){
			if(!getValue(selenium,txtofRefills).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.ofRefill.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,txtDurationNo).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.ofRefill.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxRFDurationList).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage1Ca.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxRFMethod).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillMethodCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxRFQuatity).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillQuantityCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxRFUnit).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUnitCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxRFRoute).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillRouteCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxRFFrequency).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillFrequencyCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxRFDuration).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refilldurationCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxRFUsage).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage4Ca.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		else{
			if(!getValue(selenium,txtofRefills).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.ofRefill.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,txtDurationNo).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.ofRefill.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxRFDurationList).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage1.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxRFMethod).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillMethod.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxRFQuatity).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillQuantity.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxRFUnit).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUnit.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxRFRoute).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillRoute.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxRFFrequency).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillFrequency.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxRFDuration).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillduration.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxRFUsage).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage4.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		return true;
	}
	
	public boolean verifyStoredDirectionPrescribeQuickList(Selenium selenium, ChartPreVisitLib prescribeData, String account){
		if(account.equalsIgnoreCase(CAAccount)){
			if(!getValue(selenium,ajxMethod).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillMethodCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxQuantity).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.qualityCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxUnit).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.unitCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			/*if(!getValue(selenium,ajxRoute).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.routeCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
			if(!getValue(selenium,ajxFrequency).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.frequencyCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxDuration).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.duration.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxUsage).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage4Ca.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,txtDirectionNotes).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.direction.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		else{
			if(!getValue(selenium,ajxMethod).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillMethod.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxQuantity).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.quality.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxUnit).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.unit.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			/*if(!getValue(selenium,ajxRoute).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.route.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
			if(!getValue(selenium,ajxFrequency).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.frequency.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxDuration).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.duration.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxUsage).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage4.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,txtDirectionNotes).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.direction.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		return true;
		
	}
	
	
	public boolean verifyStoredFreeTextPrescribeQuickList(Selenium selenium, ChartPreVisitLib prescribeData){
		if(!isChecked(selenium,chkFreeText)){
			return false;
		}
		if(!getValue(selenium,txtDirectionNotes).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.direction.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
	
	
	public boolean verifyStoredIncresDecresPrescribeQuickList(Selenium selenium, ChartPreVisitLib prescribeData, String account){
		if(!isChecked(selenium,chkIncreaseDecreaseDirection)){
			return false;
		}
		if(account.equalsIgnoreCase(CAAccount)){
			
			if(!getValue(selenium,ajxInRefillMethod).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillMethodCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxInRefillQuantity).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillQuantityCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			/*if(!getValue(selenium,ajxInRefilUnit).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUnitCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
			/*if(!getValue(selenium,ajxInRefillRoute).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillRouteCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
			if(!getValue(selenium,ajxInRefillFrequency).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillFrequencyCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxInRefillDuration).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refilldurationCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxInRefillUsage).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage4Ca.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxRefilUsage).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsageCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			
			if(!getValue(selenium,ajxInUsage).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.usageCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,txtDuration).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.durationIn.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxInRefillUsage1).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage1Ca.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxInRefillUsage2).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage2Ca.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajaxInRefillUsage3).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage3Ca.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,txtDirectionNotes).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.direction.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		else{
			if(!getValue(selenium,ajxInRefillMethod).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillMethod.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxInRefillQuantity).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillQuantity.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxInRefilUnit).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUnit.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			/*if(!getValue(selenium,ajxInRefillRoute).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillRoute.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
			if(!getValue(selenium,ajxInRefillFrequency).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillFrequency.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxInRefillDuration).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillduration.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxInRefillUsage).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage4Ca.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxRefilUsage).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxInUsage).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.usage.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,txtDuration).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.durationIn.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxInRefillUsage1).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage1.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxInRefillUsage2).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage2.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajaxInRefillUsage3).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage3.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,txtDirectionNotes).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.direction.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		return true;
	}
	
	public boolean verifyStoredMultipleDirectionPrescribeQuickList(Selenium selenium, ChartPreVisitLib prescribeData, String account){
		if(!isChecked(selenium,"multipleDirectionIDcheckbox")){
			return false;
		}
		
		if(account.equalsIgnoreCase(CAAccount)){
			if(!getValue(selenium,ajxMDRefilMethod).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillMethodCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxMDRefillQuantity).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillQuantityCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			/*if(!getValue(selenium,ajxMDRefillUnit).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUnitCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
			/*if(!getValue(selenium,ajxMDRefillRoute).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillRouteCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
			if(!getValue(selenium,ajxMDRefillFrequency).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillFrequencyCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxMDRefillDuration).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refilldurationCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxMDRefillUsage).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage5Ca.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			
			if(!getValue(selenium,ajxMDMethod).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.methodCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxMDQuantity).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.qualityCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			/*if(!getValue(selenium,ajxMDUnit).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.unitCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxMDRoute).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.routeCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
			if(!getValue(selenium,ajxMDFrequency).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.frequencyCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxMDDuration).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.duration.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxMDUsage).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage4Ca.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,txtDirectionNotes).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.direction.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		else{
			if(!getValue(selenium,ajxMDRefilMethod).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillMethod.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxMDRefillQuantity).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillQuantity.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxMDRefillUnit).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUnit.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			/*if(!getValue(selenium,ajxMDRefillRoute).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillRoute.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
			if(!getValue(selenium,ajxMDRefillFrequency).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillFrequency.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxMDRefillDuration).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillduration.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxMDRefillUsage).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage5.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			
			if(!getValue(selenium,ajxMDMethod).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.method.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxMDQuantity).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.quality.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxMDUnit).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.unit.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			/*if(!getValue(selenium,ajxMDRoute).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.route.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
			if(!getValue(selenium,ajxMDFrequency).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.frequency.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxMDDuration).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.duration.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxMDUsage).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.refillUsage4.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,txtDirectionNotes).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.direction.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		return true;
		
	}
	
}
