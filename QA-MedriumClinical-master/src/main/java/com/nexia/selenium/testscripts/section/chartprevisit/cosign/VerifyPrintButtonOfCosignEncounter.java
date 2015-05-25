package com.nexia.selenium.testscripts.section.chartprevisit.cosign;

import java.awt.Robot;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPrintButtonOfCosignEncounter extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing print mode of  Co-signed encounter in  encounter Queue ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrintButtonForCosignEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "Cosign";
		encounterData.testCaseId = "TC_CO_005";
		encounterData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCoEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing print mode of  Co-signed encounter in  encounter Queue ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEncounterDetailsInHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "Cosign";
		encounterData.testCaseId = "TC_CO_008";
		encounterData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCoEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	public boolean verifyCoEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
try
{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//  
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
				searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button",selenium,ClassName,MethodName);			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Encounter//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllEncounters(selenium,encounterData),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isVisible(lnkProblemList),"Problem List Link Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			assertTrue(deleteAllProblemList(selenium, encounterData),"Deletion faied",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Begin an encounter//
			//--------------------------------------------------------------------//			
			assertTrue(goToBeginEncounter(selenium),"begin Encounter failed",selenium,ClassName,MethodName);			
			//--------------------------------------------------------------------//
			//  Step-5: Enter assessment Details//
		 	//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("ddyymm:HH:ss");
			String date=dateFormat.format(cal.getTime());
			encounterData.chiefComplaint=encounterData.chiefComplaint+date;
			String searchKeyWord=	encounterData.chiefComplaint;
			assertTrue(selectValueFromAjaxList(selenium,ajxAssessmentSearch,encounterData.medicalCondition),"Could not select",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			deleteProbleforMedRecon(selenium,encounterData);
			waitForPageLoad(selenium);	
			encounterData.workSheetName = "CreateProblemList";
			encounterData.testCaseId = "TC_CPL_013";
			encounterData.fetchChartPreVisitTestData();
			
			//--------------------------------------------------------------------//
			//  Step-6: Create Problem list//
			//--------------------------------------------------------------------//
			
			assertTrue(createProblemList(selenium,encounterData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);		
			assertTrue(type(selenium,txtChiefCompliant,encounterData.chiefComplaint),"Could not select",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);	
			selenium.fireEvent(txtChiefCompliant, "blur");
			if(selenium.isConfirmationPresent()){
	            System.out.println(selenium.getConfirmation());
	            selenium.chooseOkOnNextConfirmation();    }
			assertTrue(click(selenium,btnSign),"could not sign the encounter", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
			   	assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			if(isElementPresent(selenium,btnContinue))
			{
					String tempProv[]=selenium.getValue(ajxCosignProv).split(",");
					encounterData.CosignProv=tempProv[1]+" "+tempProv[0];
					waitForPageLoad(selenium);										
				assertTrue(click(selenium,btnContinue),"Could not click Save button in Co-sign pop up window",selenium,ClassName,MethodName);
			}
			else
			{
				Assert.fail("Co-sign Pop up not displayed");
			}
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkencounterTab),"Could not click Encounter tab",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(encounterData.testCaseId.equals("TC_CO_008"))
			{
				assertTrue(selectValueFromAjaxList(selenium,ajxRxShow,"Unsigned"),"Could not click Encounter tab",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);			
				assertTrue(verifyEncounterDetailsInHistory(selenium,encounterData,userAccount),"Verifying Encounter details in encounter history is failed", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);		
				assertTrue(click(selenium,btnNexiaLogo),"Could not click the post button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);	
									
			}
						
			//--------------------------------------------------------------------//
			//  Step-8: login as co sign provider				  //
			//--------------------------------------------------------------------//
					encounterData.workSheetName = "Cosign";
					encounterData.testCaseId = "TC_CO_004";
					encounterData.fetchChartPreVisitTestData();
					selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
					waitForPageLoad(selenium);			
				assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
					waitForPageLoad(selenium);					
					//--------------------------------------------------------------------//
					//  Step-9: search Added Medication in Queue						  //
					//--------------------------------------------------------------------//
					assertTrue(click(selenium,lnkUnSigned),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);      
					waitForPageLoad(selenium);
					assertTrue(type(selenium,"searchTextBox",searchKeyWord),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);
					selenium.keyPress("searchTextBox", "\\13");
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium,ajxRxShow,"My encounters");
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);		
					assertTrue(verifyEncounterDetailsInHistory(selenium,encounterData,userAccount),"Verifying Encounter details in encounter history is failed", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);		
				if(isElementPresent(selenium,lnkUnSignedlist))	{
			
				returnValue=true;
				selenium.click(lnkUnSignedlist);
					waitForPageLoad(selenium);		
				assertTrue(click(selenium,lnkEncounterAction),"Could not click the  un sign button ",selenium,ClassName,MethodName);      
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnPrint),"Could not click the  print button ",selenium,ClassName,MethodName);      
				waitForPageLoad(selenium);		
				Robot robot = null;
				robot = new Robot();
				Thread.sleep(5000);
			}
			else
			{
				Assert.fail("serach result is not present");
				 return false;
			}



}
catch(Exception e)
{
	Assert.fail(e.getMessage());
	
	
}	return returnValue;	
	
	}
	
	
	public boolean verifyEncounterDetailsInHistory(Selenium selenium, ChartPreVisitLib encounterData,String userAccount)
	{
		try
			{
			String date=null;
			
		 if (userAccount.equals(CAAccount)) {
				Calendar cal1 = Calendar.getInstance();
				SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
				date = dateFormat.format(cal1.getTime());
			    } else {
				Calendar cal2 = Calendar.getInstance();
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = dateFormat.format(cal2.getTime());

			    }
		
		 assertTrue(selenium.isTextPresent("Chief Complaint:"),"Check complaint Data not Present",selenium, ClassName, MethodName);		
		assertTrue(selenium.isTextPresent("Signed by "),"Signed by Data not present",selenium, ClassName, MethodName);		
		System.out.println("Requires co-signature from"+encounterData.CosignProv);
		assertTrue(selenium.isTextPresent("Requires co-signature from"+encounterData.CosignProv),"Co-signature data not present",selenium, ClassName, MethodName);		
		assertTrue(selenium.isTextPresent(date),"Date not present",selenium, ClassName, MethodName);		
		assertTrue(selenium.isTextPresent("Co-Sign"),"Co-sign label in Blue coloue is not Present",selenium, ClassName, MethodName);		
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		
		return true;
		
	}
	
	
}
