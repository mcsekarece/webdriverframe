package com.nexia.selenium.testscripts.section.demographics.unfinishedItem;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditProgramsInUnfinishedItem extends AbstractHomeTest{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Edit  Programs in unfinished item")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditProgramsInUnfinishedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib ProgramData = new HomeLib();
		ProgramData.workSheetName = "NewProgram";
		ProgramData.testCaseId = "TC_P_009";
		ProgramData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyEditProgramsInUnfinishedItem(seleniumHost, seleniumPort, browser, webSite, userAccount, ProgramData);
	}


	/*************************************************************************************************** 
	* @purpose      Verify EditPrograms In UnfinishedItem
	* @action 		 Verify EditPrograms In UnfinishedItem
	* @author        Aspire QA
	* @state         developing
	* @useraccount   Both
	* @since  	     July 10, 2013
	***************************************************************************************************/

	public boolean verifyEditProgramsInUnfinishedItem(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib ProgramData) throws Exception{
		Selenium selenium = null;
		String currentUnfinishedItem="Edit Programs for";
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + ProgramData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, ProgramData.userName, ProgramData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,ProgramData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete all unfinished item                                //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllUnfinishedItem(selenium),"Could not Delete all unfinished item  :"+ ProgramData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID //
			//--------------------------------------------------------------------//
			
			searchPatientNexia(selenium,ProgramData.patientID);
			waitForPageLoad(selenium);
			click(selenium,lnkProgram);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Deleting existing Programs for the selected patient  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllPrograms(selenium), "Could not delete all programs", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-6: Create a new Program //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddPrograms),"Could not Click on Add Programs Button:"+ ProgramData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProgram(selenium,ProgramData,userAccount),"Program creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		 
			
			//---------------------------------------------------------- ----------//
			//  Step-6: Edit a new Program //
			//--------------------------------------------------------------------//	
			
			assertTrue(click(selenium, lnkEditPrograms),"Could not find Edit button; More Details:" + ProgramData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			ProgramData.workSheetName = "EditProgram";
			ProgramData.testCaseId = "TC_EP_008";
			ProgramData.fetchHomeTestData();
		
			
			//---------------------------------------------------------- ----------//
			//  Step-8: Create a new Program //
			//--------------------------------------------------------------------//
			if(userAccount.equalsIgnoreCase(CAAccount)){
				assertTrue(enterDate(selenium,txtFromDate, ProgramData.fromdateCA),"Could not enter date; More Details :" + ProgramData.toString(), selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtToDate,ProgramData.todateCA),"Could not enter the date; More Details :" + ProgramData.toString(), selenium, ClassName, MethodName);
			}else{
				assertTrue(enterDate(selenium,txtFromDate, ProgramData.fromdate),"Could not enter date; More Details :" + ProgramData.toString(), selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtToDate,ProgramData.todate),"Could not enter the date; More Details :" + ProgramData.toString(), selenium, ClassName, MethodName);
			}
			assertTrue(type(selenium,txtPrior,ProgramData.priorstate),"Could not enter the Prior State value; More Details :" + ProgramData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtOutCome,ProgramData.outcome),"Could not enter the Outcome value; More Details :" + ProgramData.toString(), selenium, ClassName, MethodName);
			

			//--------------------------------------------------------------------//
			//  Step-9: Store data in unfinished item							  //
			//--------------------------------------------------------------------//
			assertTrue(storeDataInUnfinishedItem(selenium),"Could not Store data in unfinished item; More Details :"+ ProgramData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			
			//--------------------------------------------------------------------//
			//  Step-10: Navigate to unfinished item							  //
			//--------------------------------------------------------------------//
			//get the current patient name
			String patientName[]= getText(selenium, lblPatientName).split(",");
			
			//customize the patient name for our need
			String patientNameAltered= patientName[1] +" "+ patientName[0];
			
			//append the patient name with the current unfinished item section
			currentUnfinishedItem= currentUnfinishedItem + patientNameAltered ;
			
			assertTrue(navigateToUnfinishedItem(selenium, currentUnfinishedItem),"Could not Navigate to unfinished item; More Details :"+ ProgramData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			
			if(!verifyStoredValuesAddPrograms(selenium,ProgramData,userAccount)){
				Assert.fail("Add Programs details not saved properly in contacts page :"+ ProgramData.toString());
			}
			
			// Complete the unfinished item
			assertTrue(click(selenium, btnSave),"Could not find save button; More Details:" + ProgramData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			//---------------------------------------------------------------------------//
			//  Step-14: Verifying Completed unfinished item Details are saved properly  //
			//---------------------------------------------------------------------------//
			if(!verifyStoredValuesInSummaryAddPrograms(selenium,ProgramData, userAccount)){
				Assert.fail("Add Programs details not saved properly in summary section; More Details :"+ ProgramData.toString());
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}	
	



