package com.nexia.selenium.testscripts.section.clinicalsettings.cdsAlerts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCDSAlertForTobacoAssessment extends AbstractChartPreVisit{
    @Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCDSAlertForTobbaco(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLib cdsData = new ChartPreVisitLib();
		cdsData.workSheetName = "CreateSocialHistory";
		cdsData.testCaseId = "TC_CSH_008";
		cdsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCdsAlert(seleniumHost, seleniumPort, browser, webSite, userAccount, cdsData);
	}
    /**
	 * verifyCdsAlert
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 11, 2012
	 */
	
	public boolean verifyCdsAlert(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib cdsData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String contact="Scheduled";
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + cdsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, cdsData.userName, cdsData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to CDS and uncheck all the rules//
			//--------------------------------------------------------------------//
			
			navigateToCDSUncheck(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search for a patient//
			//--------------------------------------------------------------------//
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "NewPatientCheckIn";
			PatientData.testCaseId = "TC_NPC_013";
			PatientData.fetchHomeTestData();
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the button;More Details:"+cdsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnknewPatientAction),"Could not click the link view patient chart", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createNewPatientForBPM(selenium,PatientData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String patId = getText(selenium, btnPatientId);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPatientOptionsLink ), "Could not click on patient options link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientChartView), "Could not click on patient chart link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxContactMode,contact),"Select Failed", selenium, ClassName, MethodName);

			//selectValueFromAjaxList(selenium, ajxProvider1, cdsData.provider);
			//assertTrue(enterDate(selenium, txtEncounterDate, "08/08/2011"),"could not enter", selenium, ClassName, MethodName);
			click(selenium,btnSign);		
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxContactMode,contact),"Select Failed", selenium, ClassName, MethodName);
			
			//selectValueFromAjaxList(selenium, ajxProvider1, cdsData.provider);
			//assertTrue(enterDate(selenium, txtEncounterDate, "08/08/2011"),"could not enter", selenium, ClassName, MethodName);
			click(selenium,btnSign);		
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Add Social History details //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lblEncounterChoosePanel)){
				if(isElementPresent(selenium,lnkNewEncounterLink3)){
					waitForPageLoad(selenium);
					click(selenium,lnkNewEncounterLink3);
					waitForPageLoad(selenium);
				}
				else if(isElementPresent(selenium,lnkStartNewWncouter)){
					waitForPageLoad(selenium);
					click(selenium,lnkStartNewWncouter);
					waitForPageLoad(selenium);
					}else{
						click(selenium,lnkEncounterLink2);
					}
				}
				
				waitForPageLoad(selenium);
				
				assertTrue(deleteSocialHistoryForEncounter(selenium,cdsData ),"Deletion Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				selenium.focus(lnkEncounterSoicalHistory);
				selenium.clickAt(lnkEncounterSoicalHistory, "");
				
				assertTrue(createSocialHistory(selenium,cdsData),"Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(selectValueFromAjaxList(selenium,ajxContactMode,contact),"Select Failed", selenium, ClassName, MethodName);

				click(selenium,btnSign);		
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-5: Select the CDS Alert rule//
				//--------------------------------------------------------------------//
				navigateToCDSCheck(selenium);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-6: Verify CDS Alerts//
				//--------------------------------------------------------------------//
			
				if(!verifyCDSAlert(selenium,cdsData,patId)){
				Assert.fail("CDS alert is not displayed as expected: More Details :"+ cdsData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyCDSAlert(Selenium selenium,ChartPreVisitLib cdsData,String patId) throws IOException{
		boolean returnValue=true;
		
		click(selenium,btnNexiaLogo);
		waitForPageLoad(selenium);
		
		if(isElementPresent(selenium, "errorCloseButton"))
			assertTrue(click(selenium, "errorCloseButton"),"Could not click the Close Button link",selenium, ClassName, MethodName);
		
		assertTrue(type(selenium,txtsearchbox,patId),"Could not type patient id", selenium, ClassName, MethodName);
		selenium.keyPress(txtsearchbox, "\\13");
		waitForElement(selenium,lblsearchResult,10000);
		assertTrue(selenium.isElementPresent(lblsearchResult),"Search Results are not displayed for the patient with ID :-"+cdsData.patientId, selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblsearchResult).contains(patId),"", selenium, ClassName, MethodName);
		click(selenium,lblsearchResult);
		waitForPageLoad(selenium);
		
		if(cdsData.testCaseId.equals("TC_CSH_007")){
			if(isElementPresent(selenium,lblCdsAlertForSH)){
				returnValue=false;
			}
			else returnValue=true;
		}
		
		else if(!cdsData.testCaseId.equals("TC_CSH_007")){
		 if((getText(selenium,lnkCheckCDS)).contains("Tobacco")){
			returnValue=false;
		}
			
		if(!selenium.isTextPresent("Tobacco")){
			returnValue=false;
		}
		
		if(cdsData.testCaseId.equals("TC_CSH_006")){
			click(selenium,btnCloseAlert);
			if(isElementPresent(selenium,lblPatientChart)){
			returnValue=false;	
				}
			}
		}
		return returnValue;
	}
}

