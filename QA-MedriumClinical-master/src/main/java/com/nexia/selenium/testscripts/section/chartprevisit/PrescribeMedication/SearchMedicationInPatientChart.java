package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class SearchMedicationInPatientChart extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Search medication in the patient chart")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchMedicationInPatientChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_044";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		searchMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify Search medication feature in the patient chart
	* @action 		  Verifying Search medication feature in the patient chart
	* @expected       After creating prescribe medication, Verify the search feature in the patient chart
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      April 04, 2013
	***************************************************************************************************/
	public boolean searchMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
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
			
		
			
			assertTrue(deleteAllPendingMedication(selenium,prescribeData),"Deletion Failed",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-5: create Prescribe Medication //
			//--------------------------------------------------------------------//
			String firstMedication=null;
			if(userAccount.equalsIgnoreCase(CAAccount)){
				firstMedication=prescribeData.prescribeCa;
			}else{
				firstMedication=prescribeData.prescribe;
			}
			
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddToPending),"Could not click add To Pending button"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: create another Prescribe Medication //
			//--------------------------------------------------------------------//
			prescribeData.workSheetName = "PrescribeMedi";
			prescribeData.testCaseId = "TC_PM_045";
			prescribeData.fetchChartPreVisitTestData();
			
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
 			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddToPending),"Could not click add To Pending button"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			
			//-------------------------------------------------------------------------------------------//
			//  Step-7: search the first created medication and verify it displayed in the search result //
			//-------------------------------------------------------------------------------------------//
				
			
			assertTrue(selectValueFromAjaxList(selenium,ajxRxShow, prescribeData.show),"Could not click add To Pending button"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtMedsSearchTextBox, firstMedication),"Could not click add To Pending button"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			selenium.keyPress(txtMedsSearchTextBox, "\\13");
			
			waitForPageLoad(selenium);
			
			
			
			if(getText(selenium, "mainPanel").contains(firstMedication)){
				
				//verify the second created medication is not displayed in the result.. Because, we search first medication only
				if(userAccount.equalsIgnoreCase(CAAccount)){
					if(!(getText(selenium, "mainPanel").contains(prescribeData.prescribeCa))){
						return  true;
					}
					returnValue =false;
				}
				else{
					if(!(getText(selenium, "mainPanel").contains(prescribeData.prescribe))){
						return   true;
					}
					else{
						returnValue =false;
					}
				}
				
			}else{
				returnValue=false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
}
