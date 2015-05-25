package com.nexia.selenium.testscripts.section.chartprevisit.UnsignedEncounterQueue;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import org.testng.Assert;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;


public class VerifyBoldnessOfDateInEncounterQueue extends AbstractChartPreVisit{


	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Date is in bold in encounter Queue ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_002";
		encounterData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifyBoldNess(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}

	/**
	 * VerifyBoldNess Of Date
	 * Function to verify serach filter
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    May 29,2014
	 */
	
	
	public boolean VerifyBoldNess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
	
	try{
	
		
		//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
	           	Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
				assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);

				assertTrue(switchRole(selenium,encounterData.switchRole),"Could not change the switch role;More Details:"+encounterData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				//--------------------------------------------------------------------//  
				//  Step-2: Advanced search with Patient ID//
				//--------------------------------------------------------------------//
				
				searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-3: Delete All existing Problem List//
				//--------------------------------------------------------------------//
				assertTrue(deleteAllProblemList(selenium,encounterData),"Deletion problem list failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnCancelSummaryProblemList),"Could not find cancel problem list button",selenium,ClassName,MethodName);
											
				//--------------------------------------------------------------------//
				//  Step-3: Delete Encounter//
				//--------------------------------------------------------------------//
				
				assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);

				assertTrue(deleteAllEncounters(selenium,encounterData),"Creation Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-4: Begin an encounter//
				//--------------------------------------------------------------------//
				
				assertTrue(goToBeginEncounter(selenium),"begin Encounter failed",selenium,ClassName,MethodName);
				
				//--------------------------------------------------------------------//
				//  Step-5: Enter assessment Details//
			 	//--------------------------------------------------------------------//
				//assertTrue(assesmentSectionForSignedEncounter(selenium,encounterData),"could not Enter the data");
				
				selectValueFromAjaxList(selenium,ajxAssessmentSearch,encounterData.medicalCondition);
				waitForPageLoad(selenium);
			
				encounterData.workSheetName = "CreateProblemList";
				encounterData.testCaseId = "TC_CPL_013";
				encounterData.fetchChartPreVisitTestData();
				
				//--------------------------------------------------------------------//
				//  Step-6: Create Problem list//
				//--------------------------------------------------------------------//
				
				assertTrue(createProblemList(selenium,encounterData,userAccount),"Creation failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);		
				assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the action button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lblEncounterSave),"Could not click the save link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnNexiaLogo),"Could not click the post button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			      if(isElementPresent(selenium, btnErrorClose))
						assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);

				if(selenium.isConfirmationPresent()){
		            System.out.println(selenium.getConfirmation());
		            selenium.chooseOkOnNextConfirmation();    }
				assertTrue(click(selenium,"Unsignedencounters"),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);      
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxRxShow,"My encounters");
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);		
		
				//--------------------------------------------------------------------//
				//  Step-7: Verify ascending order of Unsigned encounter queue//
				//--------------------------------------------------------------------//
				//This Verifivation is removed, since the date is not in Bold font according to ticket VEL-5143
				//assertTrue(verifyDate(selenium,userAccount),"Date field in Unsigned Encounter Queue should be Bold",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);			
	}		
		catch(Exception e)
		{			
			e.printStackTrace();
			return false;		
		}
		return true;
	}	

	boolean verifyDate(Selenium selenium,String userAccount)
	{
		
		if(isElementPresent(selenium,"unsignedEncounterListItem"))
		{
			String BlodAtt=selenium.getAttribute("css=div.smallPlus.reallyLighter@style").trim();
			if(BlodAtt.equals(";"))
			{
				return false;
			}
			else
			{
				return true;
			}
			
		}

		else
		{
			Assert.fail("Serach Result not present");
		}
		return true;
	}
}
