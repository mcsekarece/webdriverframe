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

public class VerifyDeleteAssesmentInEditAssesmentPage extends AbstractChartPreVisit{
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Delete Encounter Assesment In Summary Page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValueOfSignedEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_006";
		encounterData.fetchChartPreVisitTestData();
		verifySignedEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Delete Encounter Assessment In Summary Page
	* @action 		  Verifying Delete Encounter Assessment In Summary Page
	* @author         Aspire QA
	 * @throws        IOException 
	* @state          Developing
	* @defect 		  #7632	
	* @useraccount    Both
	* @since  	      May 29, 2013
	***************************************************************************************************/
	public boolean verifySignedEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
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
			
			/*selectValueFromAjaxList(selenium,ajxEncounterProvider,encounterData.provider);
			waitForPageLoad(selenium);*/
			
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
			//  Step-7:Verify Stored value After delete //
			//--------------------------------------------------------------------//
			if(!verifyStoredValue(selenium,encounterData,userAccount)){
				Assert.fail("Signed Encounter details not saved properly; More Details :"+ encounterData.toString());
			}
		
			
			//--------------------------------------------------------------------//
			//  Step-8: Edit Assesments//
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,lblEncounterDetails),"Could not find the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.clickAt(lblEncounterDetails,"");
			
			assertTrue(click(selenium,btnEdit),"Could not click the edit button;More Details:"+encounterData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-8:Verify Edit Assesment Details//
			//--------------------------------------------------------------------//
			if(!verifyStoredValueForEditAssesment(selenium, encounterData,userAccount)){
				Assert.fail("Details are not saved properly");
			}
			
			//--------------------------------------------------------------------//
			//  Step-9: DeleteAssesment in Edid Assesment page        //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnDeleteProlist),"Could not click the Delete button;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//assertTrue(type(selenium,txtdeleteReason,encounterData.medical ),"Could not click the Delete button;", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnYes),"Could not click the Yes button;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10:Verify Delete Record in Encounter Note Page               //
			//--------------------------------------------------------------------//

			
			assertTrue(!selenium.isTextPresent(encounterData.medicalCondition), ""	+ "Assessment Medical Condition Present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			/*if((getText(selenium,lblEncounterDetails).toLowerCase(new java.util.Locale("en","Us")).trim().contains(encounterData.medicalCondition.trim().toLowerCase(new java.util.Locale("en","Us"))))){
				Assert.fail("Reocrd is not Deleted");
			}else
				returnValue = true;
			*/
			
			
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return returnValue;
		}
		return returnValue;
	}
	
	public boolean verifyStoredValue(Selenium selenium,ChartPreVisitLib encounterData,String account) throws IOException{
		//Verify created assessment in encounter
		
		assertTrue(selenium.isTextPresent(encounterData.medicalCondition), ""	+ "Assessment Medical Condition Not Present", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
				
		//Verify created assessment in summary page
		assertTrue(selenium.isTextPresent(encounterData.itemStatus), ""	+ "Assessement Item Status Not Present", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
	
	public boolean verifyStoredValueForEditAssesment(Selenium selenium, ChartPreVisitLib proData,String account) throws IOException{
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
		if (getText(selenium, lnkAllShowmore).equalsIgnoreCase("Show more details")) 
			assertTrue(click(selenium, lnkAllergyShowmore),"Could not on show more button", selenium, ClassName, MethodName);
	
		if(!getValue(selenium,"medicalConditionTextBox").toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(proData.medicalCondition1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getValue(selenium,"onsetDate").trim().contains(date.trim())){
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
		if(!getValue(selenium,"diagnosissuggestBox").toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.diagnosis.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
	}
		if(!getValue(selenium,txtcomment).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.comment.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}	
}
