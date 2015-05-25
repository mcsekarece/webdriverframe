package com.nexia.selenium.testscripts.section.chartprevisit.EncounterRunWizard;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CreateImmunizationInRunWizard extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Immunization")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_003";
		immunizationData.fetchChartPreVisitTestData();
		addImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}

	/**
	 * addImmunization
	 * function to add Immunization
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 *@defect		#6137
	 * @since  	    Sep 26, 2012
	 */
	
	public boolean addImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib immunizationData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
	Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + immunizationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, immunizationData.userName, immunizationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			int i=0;
			if(i==0)
			{
			
			searchPatientNexiaForProviderHomePage(selenium,immunizationData.patientId);
			waitForPageLoad(selenium);
			}
			waitForPageLoad(selenium);waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,immunizationData),"could not delete", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate to Begin Encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(clickAt(selenium,lnkBeginEncounterAction,""),"could not Click", selenium, ClassName, MethodName);
			assertTrue(focus(selenium,lnkBeginEncounterAction),"could not Focus", selenium, ClassName, MethodName);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");
			
			//Navigate to Run Wizard Summary
			assertTrue(click(selenium, lnkRunWizard),"could not click the Run Wizard Summary Page",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);		

			//--------------------------------------------------------------------//
			//  Step-4: click Immunzation Link//
			//--------------------------------------------------------------------//
			while(!isElementPresent(selenium,chkrefused)){
				if(selenium.isConfirmationPresent()){
                    System.out.println(selenium.getConfirmation());
                    selenium.chooseOkOnNextConfirmation();
                 	
            }				assertTrue(click(selenium, chkImmunization),"could not click theImmunication link button",selenium, ClassName, MethodName);

            
         
            
				waitForPageLoad(selenium);		
			}
			//Delete existing immunization
			assertTrue(deleteImmunization(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Create Immunzation//
			//--------------------------------------------------------------------//
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 //  assertTrue(selenium.isElementPresent(btnNext),"could not click theImmunication link button",selenium, ClassName, MethodName);
	
			if(i==0)
			{
				
				if(isElementPresent(selenium,"add")){
					assertTrue(click(selenium, "add"),"could not click the add button",selenium, ClassName, MethodName);	
					waitForPageLoad(selenium);		
				}
				
				assertTrue(isElementPresent(selenium,btnImmunizationEdit),"Creation failed", selenium, ClassName, MethodName);
				
			
			}
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}
