package com.nexia.selenium.testscripts.section.smoketest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.smoketest.SmokeTestLib;
import com.nexia.selenium.genericlibrary.smoketest.AbstractSmokeTest;
import com.thoughtworks.selenium.Selenium;

public class VerifyCdsAlertForTobacco extends AbstractSmokeTest {
	@Test(groups = {"Smoke","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCDSAlertForTobbaco(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SmokeTestLib cdsData = new SmokeTestLib();
		cdsData.workSheetName = "CreateSocialHistory";
		cdsData.testCaseId = "TC_CSH_001";
		cdsData.fetchSmokeTestData();		
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
	
	public boolean verifyCdsAlert(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SmokeTestLib cdsData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + cdsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, cdsData.userName, cdsData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to CDS and uncheck all the rules//
			//--------------------------------------------------------------------//
			
			assertTrue(navigateToCDSUncheck(selenium),"Navigation failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search for a patient//
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage_smoke(selenium,cdsData.patientId),"selection failed Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Count the number of encounters present//
			//--------------------------------------------------------------------//
			if(!cdsData.testCaseId.equals("TC_CSH_007")){
			click(selenium,lnkencounterTab);
			waitForPageLoad(selenium);
			int count=1,count1=1;
			while(isElementPresent(selenium,"//div[2]/div/div[2]/table/tbody/tr["+count+"]/td[2]/div/div")){
				count++;
				
				if(count>15)
					break;
			}
			
			while(isElementPresent(selenium,"//div[2]/div[2]/div/div[2]/table/tbody/tr["+count1+"]/td[2]/div/div")){
				count1++;
				
				if(count1>15)
					break;
			}
			
			int counter=count+count1;
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(counter<3){
				assertTrue(click(selenium,BeginEncounter),"Could not click the Begin Encounter link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lblEncounterChoosePanel)){
					if(isElementPresent(selenium,elementNewEncounterLink3)){
						click(selenium,elementNewEncounterLink3);
						click(selenium,btnSign);		
						waitForPageLoad(selenium);}
					else if(isElementPresent(selenium,lnkStartNewWncouter)){
						click(selenium,lnkStartNewWncouter);
						click(selenium,btnSign);		
						waitForPageLoad(selenium);}
					}else{
						click(selenium,elementNewEncounterLink2);
						click(selenium,btnSign);	
					}
					
					waitForPageLoad(selenium);
			}
			else if(counter==1){
				assertTrue(click(selenium,BeginEncounter),"Could not click the Begin Encounter link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(isElementPresent(selenium,lblEncounterChoosePanel)){
					if(isElementPresent(selenium,elementNewEncounterLink3)){
						click(selenium,elementNewEncounterLink3);
						click(selenium,btnSign);		
						waitForPageLoad(selenium);}
					else if(isElementPresent(selenium,lnkStartNewWncouter)){
						click(selenium,lnkStartNewWncouter);
						click(selenium,btnSign);		
						waitForPageLoad(selenium);}
					}else{
						click(selenium,elementNewEncounterLink2);
						click(selenium,btnSign);	
					}
					
					waitForPageLoad(selenium);
					assertTrue(click(selenium,BeginEncounter),"Could not click the Begin Encounter link"
							,selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					
					if(isElementPresent(selenium,lblEncounterChoosePanel)){
						if(isElementPresent(selenium,elementNewEncounterLink3)){
							click(selenium,elementNewEncounterLink3);
							click(selenium,btnSign);		
							waitForPageLoad(selenium);}
						else if(isElementPresent(selenium,lnkStartNewWncouter)){
							click(selenium,lnkStartNewWncouter);
							click(selenium,btnSign);		
							waitForPageLoad(selenium);}
						}else{
							click(selenium,elementNewEncounterLink2);
							click(selenium,btnSign);	
						}
						
						waitForPageLoad(selenium);
				}
			}
			//--------------------------------------------------------------------//
			//  Step-4: Add Social History details //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,BeginEncounter),"Could not click the Begin Encounter link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lblEncounterChoosePanel)){
				if(isElementPresent(selenium,elementNewEncounterLink3)){
					waitForPageLoad(selenium);
					click(selenium,elementNewEncounterLink3);
					waitForPageLoad(selenium);
				}
				else if(isElementPresent(selenium,lnkStartNewWncouter)){
					waitForPageLoad(selenium);
					click(selenium,lnkStartNewWncouter);
					waitForPageLoad(selenium);
					}else{
						click(selenium,elementNewEncounterLink2);
					}
				}
				
				waitForPageLoad(selenium);
				
				assertTrue(deleteSocialHistoryForEncounter(selenium,cdsData ),"Deletion Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				selenium.focus(lnkEncounterSoicalHistory);
				selenium.clickAt(lnkEncounterSoicalHistory, "");
				
				assertTrue(createSocialHistory(selenium,cdsData),"Creation failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				
			
				click(selenium,btnSign);		
				waitForPageLoad(selenium);
				if(isElementPresent(selenium, btnContinue)){
					assertTrue(click(selenium,btnContinue),"Could not click save button",selenium,ClassName,MethodName);
				}
				//--------------------------------------------------------------------//
				//  Step-5: Select the CDS Alert rule//
				//--------------------------------------------------------------------//
				navigateToCDSCheck(selenium);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-6: Verify CDS Alerts//
				//--------------------------------------------------------------------//
			
				if(!verifyCDSAlert(selenium,cdsData)){
				Assert.fail("CDS alert is not displayed as expected: More Details :"+ cdsData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public boolean verifyCDSAlert(Selenium selenium,SmokeTestLib cdsData) throws IOException{
		boolean returnValue=true;
		
		click(selenium,btnNexiaLogo);
		waitForPageLoad(selenium);
				
		assertTrue(type(selenium,txtSearchPatient,cdsData.patientId),"Could not type patient id",selenium,ClassName,MethodName);
		selenium.clickAt("searchPatientBox","");
		selenium.focus("searchPatientBox");			
		selenium.fireEvent("searchPatientBox","keypress");
		//selenium.keyPress(txtSearchPatient, "\\9");
		waitForElement(selenium,"patientInfoWidget",10000);
assertTrue(selenium.isElementPresent("patientInfoWidget"),"Search Results are not displayed for the patient with ID :-"+cdsData.patientId,selenium,ClassName,MethodName);
		assertTrue(getText(selenium,"patientInfoWidget").contains(cdsData.patientId),"not present",selenium,ClassName,MethodName);
		click(selenium,"patientInfoWidget");
		waitForPageLoad(selenium);
		
		if(cdsData.testCaseId.equals("TC_CSH_008")){
			if(!getText(selenium,"css=div.gwt-Label.larger").contains("Tobacco Cessation Intervention")){
				returnValue=true;
			}
		}
		
		if(cdsData.testCaseId.equals("TC_CSH_006")){
			
		if(!getText(selenium,"css=div.gwt-Label.larger").contains("Tobacco Cessation Intervention")){
			returnValue=false;
			}
		}
		
		if(cdsData.testCaseId.equals("TC_CSH_007")){
			click(selenium,"//a/img");
			if(!getText(selenium,"css=div.gwt-Label.larger").contains("Tobacco Cessation Intervention")){
				returnValue=true;
			}
		}
		
		return returnValue;
	}
}

