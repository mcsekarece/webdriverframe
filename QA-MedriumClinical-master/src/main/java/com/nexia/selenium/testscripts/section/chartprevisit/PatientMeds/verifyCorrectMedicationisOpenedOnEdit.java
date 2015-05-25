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

public class verifyCorrectMedicationisOpenedOnEdit extends AbstractChartPreVisit{
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Value of Prescribe Medication with two medications")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCorrectMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_092";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyCorrectMedicationOpenOnEdit(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/*************************************************************************************************** 
	* @purpose        To verify whether the correct medication is opened for edit
	* @DefectId		  #3524
	* @action 		  create two medication and verify the saved values
	* @expected       The correct values should be opened for edit
	* @author         Aspire QA
	* @state          Completed
	* @useraccount    Both
	* @since  	      April 01, 2013
	***************************************************************************************************/
	
	public boolean verifyCorrectMedicationOpenOnEdit(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
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
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			ChartPreVisitLib prescribePatientData = new ChartPreVisitLib();
			prescribePatientData.workSheetName = "NewPatientCheckIn";
			prescribePatientData.testCaseId = "TC_NP_001";
			prescribePatientData.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,prescribePatientData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			prescribeData.provider = pName;
			System.out.println(prescribeData.providerName);
			
		/*	selectValueFromAjaxList(selenium,ajxProvider,prescribeData.provider);
			waitForPageLoad(selenium);*/
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
			assertTrue(click(selenium,lnlEdit1),"Could not click the Prescribe link;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
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
			assertTrue(click(selenium, lnkMore),"Could not click on More  link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedicationTab),"Could not click medication tab"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnOptions), "Could not click on Options button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkCurrentEdit), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			if(!verifyStoredValues(selenium,prescribeData)){
				Assert.fail("Pending medication details not saved properly; More Details :"+ prescribeData.toString());
				returnValue = false;
			}else 
				returnValue=true;
			assertTrue(click(selenium, btnMedsCancel), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkGoToPending)){
				returnValue = true;
			}else
				returnValue=false;
			ChartPreVisitLib prescribeData1 = new ChartPreVisitLib();
			prescribeData1.workSheetName = "PrescribeMedi";
			prescribeData1.testCaseId = "TC_PM_011";
			prescribeData1.fetchChartPreVisitTestData();

			assertTrue(SearchPrescribeMed(selenium,prescribeData1,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-7: Edit Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData1,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnAddToPending), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedicationTab),"Could not click medication tab"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		assertTrue(click(selenium, btnOptions), "Could not click on Options button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkCurrentEdit), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyStoredValues(selenium,prescribeData1)){
				Assert.fail("Pending medication details not saved properly; More Details :"+ prescribeData.toString());
				returnValue = false;
			}else 
				returnValue = true;
			assertTrue(click(selenium, btnMedsCancel), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkGoToPending)){
				returnValue = true;
			}else
				returnValue=false;
			assertTrue(click(selenium, lnkMore),"Could not click on More  link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMedicationTab), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyStoredValuesInSummaryPage(selenium,prescribeData,prescribeData1)){
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
	
	
	public boolean verifyStoredValuesInSummaryPage(Selenium selenium, ChartPreVisitLib prescribeData,ChartPreVisitLib prescribeData1) throws IOException{
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("MMMMMMM dd, yyyy");
		String date=DateFormat1.format(cal.getTime());
		System.out.println(getText(selenium, "//div[2]/div/div/div[2]/div/div"));
		//System.out.println(prescribeData1.prescribeName);
		
		if(!getText(selenium, "itemHTMLPanelCurrent1").toLowerCase(new java.util.Locale("en","Us")).trim().contains("ALVESCO".trim().toLowerCase(new java.util.Locale("en","Us")))||
				!getText(selenium, "itemHTMLPanelCurrent1").toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescribeData1.prescribeCa.trim().toLowerCase(new java.util.Locale("en","Us"))))
			return false;
		if(!selenium.isTextPresent("Added to pending on "+date))
			return false;
		
			assertTrue(click(selenium,"link=Expand All"),"Could not click the Expand button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			if(!selenium.isTextPresent(prescribeData1.direction.trim())){
				return false;
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
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib prescribeData) throws IOException{
		String providerNameTemp= getText(selenium, lnkTopMenu);
		String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
		String tempArray[]=providerName.split(" ");
		String pName=tempArray[1]+", "+tempArray[0];
		prescribeData.provider = pName;
		System.out.println(prescribeData.providerName);
		if(isElementPresent(selenium,btnSave)){
			assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		//waitForPageLoad(selenium);
			/*if(!getText(selenium,"css=div.inlineBlock.larger").trim().startsWith(prescribeData.prescribeName.trim())){
				return false;
			}*/
			if(!getValue(selenium,ajxProvider).trim().startsWith(pName.toUpperCase())){
				return false;
			}
		
			if(!getValue(selenium,txtDirectionNotes).trim().startsWith(prescribeData.direction.trim())){
				return false;
			}
			/*if(!getValue(selenium,txtDispense).trim().startsWith(prescribeData.dispense.trim())){
				return false;
			}*/
		
			if(!getValue(selenium,txtNotesToPharmacy).trim().startsWith(prescribeData.notesToPharmacy.trim())){
				return false;
			}
			return true;
		
	}
}