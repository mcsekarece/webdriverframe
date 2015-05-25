package com.nexia.selenium.testscripts.section.chartprevisit.PatientMeds;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStoredValuesForPendingMedication extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Store Value of Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_101";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		pendingMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Value of Prescribe Medication with Free Text")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForFreeText(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_104";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		pendingMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Store Value of Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValueForEditPendingMed(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_101";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPendingMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Value of Prescribe Medication with Free Text")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForFreeForm(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_103";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		pendingMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Value of Prescribe Medication with Free Text")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForFreeFormWithDirections(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_102";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		pendingMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Value of Prescribe Medication with Free Text")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForEditFreeFormWithDirections(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_102";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		editPendingMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
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
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,prescribeData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			assertTrue(deleteAllPendingMedication(selenium, prescribeData), "Pending medication deleteion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			
			String providerName= providerNameTemp.replaceAll(", FULL", "");
			
			String tempArray[]=providerName.split(" ");
			
			prescribeData.provider=tempArray[1]+", "+tempArray[0];
			
			if(prescribeData.testCaseId.equals("TC_PM_103")||prescribeData.testCaseId.equals("TC_PM_102")){
				selectValueFromAjaxList(selenium,ajxProvider,prescribeData.provider);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxLoaction,prescribeData.loaction);
				
				assertTrue(click(selenium,lnkFreeFrom),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			}else if(prescribeData.testCaseId.equals("TC_PM_104")){
				selectValueFromAjaxList(selenium,ajxProvider,prescribeData.provider);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxLoaction,prescribeData.loaction);
				waitForPageLoad(selenium);
				if(userAccount.equals(CAAccount)){
					assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,prescribeData.prescribeCa),"Could not type Prescribe Medication;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}else{
					assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,prescribeData.prescribe),"Could not type Prescribe Medication;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				waitForPageLoad(selenium);
				//testss
				assertTrue(click(selenium,lnlEdit1),"Could not click the Prescribe link;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}else
				assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-5: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, btnAddToPending), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkGoToPending)){
				returnValue = true;
			}else
				returnValue = false;
			assertTrue(click(selenium, lnkMedicationTab),"could not click the medication tab", selenium, ClassName,MethodName);
			if(!verifyStoredValuesInDrugdbPage(selenium,prescribeData,userAccount)){
				Assert.fail("Pending medication details not saved properly; More Details :"+ prescribeData.toString());
				returnValue = false;
			}else 
				returnValue = true;
			if(!verifyStoredValuesInSummaryPage(selenium,prescribeData,userAccount)){
				Assert.fail("Pending medication details not saved properly; More Details :"+ prescribeData.toString());
				returnValue = false;
			}else 
				returnValue= true;

			selenium.focus(lnkOption1);
			selenium.clickAt(lnkOption1, "");
			assertTrue(click(selenium,"link=Edit"),"Could not click View Monograph button", selenium, ClassName, MethodName);
			if(!verifyStoredValues(selenium,prescribeData,userAccount)){
				Assert.fail("Pending medication details not saved properly; More Details :"+ prescribeData.toString());
				
			}else 
				returnValue= true;

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return false;
		}
		return returnValue;
	}

	/**
	 * editPendingMedication
	 * Function to edit Pending medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Sep 18, 2012
	 */

	public boolean editPendingMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
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
			assertTrue(switchRole(selenium,prescribeData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Delete all existing pending Medication//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllPendingMedication(selenium, prescribeData), "Pending medication deleteion failed", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			
			String providerName= providerNameTemp.replaceAll(", FULL", "");
			
			String tempArray[]=providerName.split(" ");
			
			prescribeData.provider=tempArray[1]+", "+tempArray[0];
			
			if(prescribeData.testCaseId.equals("TC_PM_102")){
				assertTrue(SearchPrescribeMedForFreeFrom(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			else
				assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}

			//--------------------------------------------------------------------//
			//  Step-6: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, btnAddToPending), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkGoToPending)){
				returnValue = true;
			}else
				returnValue=false;
			if(prescribeData.testCaseId.equals("TC_PM_101")){
				prescribeData.workSheetName = "PrescribeMedi";
				prescribeData.testCaseId = "TC_PM_010";
				prescribeData.fetchChartPreVisitTestData();
			}
			else{
				prescribeData.workSheetName = "PrescribeMedi"; 
				prescribeData.testCaseId = "TC_PM_030";
				prescribeData.fetchChartPreVisitTestData();
			}
			assertTrue(click(selenium, lnkMedicationTab), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.focus(lnkOption1);
			selenium.clickAt(lnkOption1, "");
			assertTrue(click(selenium,"//a[2]/span"), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-7: Edit Prescribe Medication //
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, btnAddToPending), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkGoToPending)){
				returnValue = true;
			}else
			returnValue=false;
			click(selenium, lnkMore);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMedicationTab), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!verifyStoredValuesInDrugdbPage(selenium,prescribeData,userAccount)){
				Assert.fail("Pending medication details not saved properly; More Details :"+ prescribeData.toString());
				returnValue = false;
			}else 
				returnValue = true;
			if(!verifyStoredValuesInSummaryPage(selenium,prescribeData,userAccount)){
				Assert.fail("Pending medication details not saved properly; More Details :"+ prescribeData.toString());
				returnValue = false;
			}else 
				return returnValue;

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}

	/**
	 * verifyStoredValuesInSearchMedPage
	 * @param selenium
	 * @param prescribeData
	 * @return
	 */
	public boolean verifyStoredValuesInDrugdbPage(Selenium selenium, ChartPreVisitLib prescribeData,String account){
		waitForPageLoad(selenium);
		String lblMedDetail="itemHTMLPanelCurrent1";
		if(prescribeData.testCaseId.equals("TC_PM_104")){
			/*if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.direction.trim())){
				return false;
			}*/
		}else if(prescribeData.testCaseId.equals("TC_PM_101")||prescribeData.testCaseId.equals("TC_PM_030")){
			System.out.println(getText(selenium,lblMedDetail));
			if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.refillMethod.trim())){
				return false;
			}
			if(account.equals(CAAccount)){
				if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.qualityCa.trim())){
					return false;
				}
				if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.routeCa.trim())){
					return false;
				}
				if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.frequencyCa.trim())){
					return false;
				}
			}else{
				if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.quality.trim())){
					return false;
				}
				if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.route.trim())){
					return false;
				}
				if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.frequency.trim())){
					return false;
				}
			}
			
			if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.unit.trim())){
				return false;
			}
			
			
			/*if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.duration.trim())){
				return false;
			}*/
			if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.usage.trim())){
				return false;
			}
		}
		return true;
	}

	public boolean verifyStoredValuesInSummaryPage(Selenium selenium, ChartPreVisitLib prescribeData,String account) throws IOException{
		String lblPrescribeDetail="mainPanelCurrent1";
 		String lnkExpandArrow="link=Expand All";
		
		String lblMedDetail="historyPanelCurrent1";
		 	
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("MMMMMMMMM dd, yyyy");
		String date=DateFormat1.format(cal.getTime());
		
		if(!getText(selenium, lblPrescribeDetail).contains("Added to pending on "+date))
			return false;
		if(prescribeData.testCaseId.equals("TC_PM_104")){
			assertTrue(click(selenium,lnkExpandArrow),"Could not click the Expand button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			System.out.println(getText(selenium,lblMedDetail));
			System.out.println(prescribeData.direction);
			if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.direction.trim())){
				return false;
			}
			
		}
		else if(prescribeData.testCaseId.equals("TC_PM_101")||prescribeData.testCaseId.equals("TC_PM_030")){
			assertTrue(click(selenium,lnkExpandArrow),"Could not click the Expand button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			System.out.println(getText(selenium,lblMedDetail));
			if(!getText(selenium,lblMedDetail).contains(prescribeData.refillMethod))
				return false;
			
			if(account.equals(CAAccount)){
				if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.unitCa.trim())){
					return false;
				}
				if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.routeCa.trim())){
					return false;
				}
				if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.frequencyCa.trim())){
					return false;
				}
			}else{
				if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.unit.trim())){
					return false;
				}
				if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.route.trim())){
					return false;
				}
				if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.frequency.trim())){
					return false;
				}
			}
			
			/*
			if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.duration.trim())){
				return false;
			}*/
			if(!getText(selenium,lblMedDetail).trim().contains(prescribeData.usage.trim())){
				return false;
			}
			if(!getText(selenium,lblMedDetail).trim().contains(date.trim())){
				return false;
			}
		}
		return true;
	}
	/**
	 * verifyStoredValues
	 * @param selenium
	 * @param prescribeData
	 * @return
	 * @throws IOException 
	 */
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib prescribeData,String account) throws IOException{
		if(isElementPresent(selenium,btnSave)){
			assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		

		if(prescribeData.testCaseId.equals("TC_PM_101")){
			if(account.equals(CAAccount)){
				if(!getText(selenium,"responsibleProvider").trim().contains(prescribeData.prescribeNameCa.trim())){
					return false;
				}
				/*if(!getValue(selenium,"refillQuantitySuggestBoxsuggestBox").trim().contains(prescribeData.qualityCa.trim())){
					return false;
				}*/
				if(!getValue(selenium,"refillFrequencySuggestBoxsuggestBox").trim().contains(prescribeData.frequencyCa.trim())){
					return false;
				}
			}else{
				if(!getText(selenium,"css=div.inlineBlock.larger").trim().contains(prescribeData.prescribeName.trim())){
					return false;
				}
				if(!getValue(selenium,"refillQuantitySuggestBoxsuggestBox").trim().contains(prescribeData.quality.trim())){
					return false;
				}
				if(!getValue(selenium,"refillFrequencySuggestBoxsuggestBox").trim().contains(prescribeData.frequency.trim())){
					return false;
				}
			}
			
		/*	if(!getValue(selenium,ajxLoaction).trim().equalsIgnoreCase(prescribeData.loaction.trim())){
				return false;
			}*/
			if(!getValue(selenium,ajxMethod).trim().contains(prescribeData.refillMethod.trim())){
				return false;
			}
			
			if(!getValue(selenium,ajxUnit).trim().contains(prescribeData.unit.trim())){
				return false;
			}
					
			/*if(!getValue(selenium,"refillDurationSuggestBoxsuggestBox").trim().contains(prescribeData.duration.trim())){
				return false;
			}*/
			if(!getValue(selenium,"refillUsageSuggestBoxsuggestBox").trim().contains(prescribeData.usage.trim())){
				return false;
			}
			if(!getValue(selenium,txtDirectionNotes).trim().contains(prescribeData.direction.trim())){
				return false;
			}
			/*if(!getValue(selenium,txtDispense).trim().contains(prescribeData.dispense.trim())){
				return false;
			}*/
			if(!getValue(selenium,ajxUnitList).trim().contains(prescribeData.unitList.trim())){
				return false;
			}
			if(!getValue(selenium,txtNotesToPharmacy).trim().contains(prescribeData.notesToPharmacy.trim())){
				return false;
			}
			
			return true;
		}
		else if(prescribeData.testCaseId.equals("TC_PM_104")){
			if(account.equals(CAAccount)){
				if(!getText(selenium,"responsibleProvider").trim().contains(prescribeData.prescribeCa.trim())){
					return false;
				}
			}else{
				if(!getText(selenium,"responsibleProvider").trim().contains(prescribeData.prescribe.trim())){
					return false;
				}
			}
			
			if(!getValue(selenium,txtDirectionNotes).trim().contains(prescribeData.direction.trim())){
				return false;
			}
			if(!getValue(selenium,txtDispense).trim().contains(prescribeData.dispense.trim())){
				return false;
			}
			if(!getValue(selenium,ajxUnitList).trim().contains(prescribeData.unitList.trim())){
				return false;
			}
			if(!getValue(selenium,txtNotesToPharmacy).trim().contains(prescribeData.notesToPharmacy.trim())){
				return false;
			}
			return true;
		}else if(prescribeData.testCaseId.equals("TC_PM_103")){
			if(account.equals(CAAccount)){
				if(!getValue(selenium,"responsibleProvider").trim().contains(prescribeData.prescribeCa.trim())){
					return false;
				}
			}else{
				if(!getValue(selenium,"responsibleProvider").trim().contains(prescribeData.prescribeName.trim())){
					return false;
				}
			}
			
			System.out.println(getValue(selenium,ajxProvider));
			if(!getValue(selenium,ajxProvider).trim().contains("ABRAHAM, ABBY")){
				return false;
			}
			if(!getValue(selenium,ajxLoaction).trim().contains(prescribeData.loaction.trim())){
				return false;
			}
			if(!getValue(selenium,txtDirectionNotes).trim().contains(prescribeData.direction.trim())){
				return false;
			}
			if(!getValue(selenium,txtDispense).trim().contains(prescribeData.dispense.trim())){
				return false;
			}
			if(!getValue(selenium,ajxUnitList).trim().contains(prescribeData.unitList.trim())){
				return false;
			}
			if(!getValue(selenium,txtNotesToPharmacy).trim().contains(prescribeData.notesToPharmacy.trim())){
				return false;
			}
			return true;
		}

		return true;
	}
}
