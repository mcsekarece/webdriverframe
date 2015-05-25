package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyNonEditableInAssesmentEditPage extends AbstractChartPreVisit{
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing NonEditable Element In Assesment EditPage")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void nonEditableInAssesmentEditPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_006";
		encounterData.fetchChartPreVisitTestData();
		VerifyNonEditableElement(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify NonEditable InAssesment EditPage
	* @action 		  Verifying Verify NonEditable InAssesment EditPage
	* @author         Aspire QA
	 * @throws        IOException 
	* @state          Developing
	* @defect 		  #7631	
	* @useraccount    Both
	* @since  	      Dec 23, 2013
	***************************************************************************************************/
	public boolean VerifyNonEditableElement(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		boolean returnValue=true;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Create a new patient and get Patient Id					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			ChartPreVisitLib vitalsData1 = new ChartPreVisitLib();
			vitalsData1.workSheetName = "NewPatientCheckIn";
			vitalsData1.testCaseId = "TC_NP_001";
			vitalsData1.fetchChartPreVisitTestData();
			
			assertTrue(createNewPatientWithMandatory(selenium,vitalsData1),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String patId = getText(selenium, txtpatientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back link", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with created Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			
						
			//--------------------------------------------------------------------//
			//  Step-5: Create Problem list//
			//--------------------------------------------------------------------//
			encounterData.workSheetName = "CreateProblemList";
			encounterData.testCaseId = "TC_CPL_013";
			encounterData.fetchChartPreVisitTestData();
			waitForPageLoad(selenium);
			
			int count=0;
			while(isElementPresent(selenium,ajxAssessmentSearch)){

				selectValueFromAjaxList(selenium,ajxAssessmentSearch,encounterData.medicalCondition);
				waitForPageLoad(selenium);
				selenium.fireEvent(ajxAssessmentSearch,"keydown");
				selenium.fireEvent(ajxAssessmentSearch,"keypress");                           
				selenium.fireEvent(ajxAssessmentSearch,"keyup");
				waitForPageLoad(selenium);
				click(selenium,"//div[5]/div/div/div/div/div");
				waitForPageLoad(selenium);
				selenium.clickAt(ajxAssessmentSearch, "");
				selenium.keyPress(ajxAssessmentSearch, "\\9");
			
				if(isElementPresent(selenium,txtMedicatl)){
					break;
				}
				count++;
			
				if(count>20){
					break;
				}
			}
			
			assertTrue(createProblemList(selenium,encounterData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Edit Assesments//
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,lblEncounterDetails),"Could not find the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.clickAt(lblEncounterDetails,"");
			
			assertTrue(click(selenium,btnEdit),"Could not click the edit button;More Details:"+encounterData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9:Verify Delete Record in Encounter Note Page               //
			//--------------------------------------------------------------------//
			if(!verifyStoredValueForEditAssesment(selenium, encounterData,userAccount)){
				Assert.fail("Details are not saved properly");
			}
			
			//--------------------------------------------------------------------//
			//  Step-10:Verify Non Editable Element In Edit Assesment Page       //
			//--------------------------------------------------------------------//
			if(!verifyNonEditableInEditAssesmentPage(selenium)){
				Assert.fail("user i s able to edit the non editable field");
			}
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return returnValue;
		}
		return returnValue;
	}
	
	
	
	public boolean verifyStoredValueForEditAssesment(Selenium selenium, ChartPreVisitLib proData,String account) throws IOException{
		assertTrue(click(selenium,lnkProblemListShowMoreArrow),"Could not click the edit button;More Details:", selenium, ClassName, MethodName);

		String date="";
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			date=DateFormat.format(cal.getTime());
			
		}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
			
		}
		if(!getValue(selenium,"medicalConditionTextBox").toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(proData.medicalCondition1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getValue(selenium,txtOnset).trim().contains(date.trim())){
			return false;
		}
		
		if(!getValue(selenium,"itemStatusInputsuggestBox").toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.itemStatus.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getValue(selenium,"lifeStagesuggestBox").toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.lifeStage.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getValue(selenium,txtResolvedDate).trim().contains(date.trim())){
			return false;
		}
		/*if(!getValue(selenium,ajxCodeingSystem).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.codingSystem.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
//		if(!getValue(selenium,"diagnosissuggestBox").toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.diagnosis.trim().toLowerCase(new java.util.Locale("en","US")))){
//			return false;
//		}
		if(!getValue(selenium,txtcomment).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.comment.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
	
	
	public boolean verifyNonEditableInEditAssesmentPage(Selenium selenium) throws IOException{
		//waitForPageLoad(selenium);
		try{
		assertTrue(!selenium.isEditable(txtMedicatl),"Medicatl is not editable", selenium, ClassName, MethodName);
		assertTrue(!selenium.isEditable(txtOnset),"Onset date is not editable", selenium, ClassName, MethodName);
		assertTrue(!selenium.isEditable(txtResolvedDate),"Resolved Date is not editable", selenium, ClassName, MethodName);
		assertTrue(!selenium.isEditable(ajxCodeingSystem),"Coding system is not editable", selenium, ClassName, MethodName);
		assertTrue(!selenium.isEditable(ajxdiagnosis),"Diagnosis is not editable", selenium, ClassName, MethodName);
		}
		catch(Exception e)
		{
			
		}
		return true;
	}
}
