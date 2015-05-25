package com.nexia.selenium.testscripts.section.clinicalsettings.cdsAlerts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.thoughtworks.selenium.Selenium;

public class VerifyCdsAlertForTobaccoAssessment extends AbstractChartPreVisit {
    	@Test(enabled=false)
	//@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	//@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCDSAlertForTobbaco(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLib cdsData = new ChartPreVisitLib();
		cdsData.workSheetName = "CreateSocialHistory";
		cdsData.testCaseId = "TC_CSH_008";
		cdsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCdsAlert(seleniumHost, seleniumPort, browser, webSite, userAccount, cdsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCloseCDSAlert(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLib cdsData = new ChartPreVisitLib();
		cdsData.workSheetName = "CreateSocialHistory";
		cdsData.testCaseId = "TC_CSH_006";
		cdsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyCdsAlert(seleniumHost, seleniumPort, browser, webSite, userAccount, cdsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCDSAlertWithOneEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ChartPreVisitLib cdsData = new ChartPreVisitLib();
		cdsData.workSheetName = "CreateSocialHistory";
		cdsData.testCaseId = "TC_CSH_007";
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
			
			assertTrue(navigateToCDSUncheck(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search for a patient//
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,cdsData.patientId),"", selenium, ClassName, MethodName);
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
				assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lblEncounterChoosePanel)){
					if(isElementPresent(selenium,lnkNewEncounterLink3)){
						assertTrue(click(selenium,lnkNewEncounterLink3),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						waitForPageLoad(selenium);}
					else if(isElementPresent(selenium,lnkStartNewWncouter)){
						assertTrue(click(selenium,lnkStartNewWncouter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						waitForPageLoad(selenium);}
					}else{
						assertTrue(click(selenium,lnkEncounterLink2),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						
					}
					
					waitForPageLoad(selenium);
			}
			else if(counter==1){
				assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(isElementPresent(selenium,lblEncounterChoosePanel)){
					if(isElementPresent(selenium,lnkNewEncounterLink3)){
						assertTrue(click(selenium,lnkNewEncounterLink3),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						waitForPageLoad(selenium);}
					else if(isElementPresent(selenium,lnkStartNewWncouter)){
						assertTrue(click(selenium,lnkStartNewWncouter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						waitForPageLoad(selenium);}
					}else{
						assertTrue(click(selenium,lnkEncounterLink2),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
						}
					
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					
					if(isElementPresent(selenium,lblEncounterChoosePanel)){
						if(isElementPresent(selenium,lnkNewEncounterLink3)){
							assertTrue(click(selenium,lnkNewEncounterLink3),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
							assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
							
							waitForPageLoad(selenium);}
						else if(isElementPresent(selenium,lnkStartNewWncouter)){
							assertTrue(click(selenium,lnkStartNewWncouter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
							assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
							
							waitForPageLoad(selenium);}
						}else{
							assertTrue(click(selenium,lnkEncounterLink2),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
							assertTrue(click(selenium,btnSign),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
							}
						
						waitForPageLoad(selenium);
				}
			}
			//--------------------------------------------------------------------//
			//  Step-4: Add Social History details //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lblEncounterChoosePanel)){
				if(isElementPresent(selenium,lnkNewEncounterLink3)){
					waitForPageLoad(selenium);
					assertTrue(click(selenium,lnkNewEncounterLink3),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				else if(isElementPresent(selenium,lnkStartNewWncouter)){
					waitForPageLoad(selenium);
					assertTrue(click(selenium,lnkStartNewWncouter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					}else{
						assertTrue(click(selenium,lnkEncounterLink2),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
					}
				}
				
				waitForPageLoad(selenium);
				
				assertTrue(deleteSocialHistoryForEncounter(selenium,cdsData ),"Deletion Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				selenium.focus(lnkEncounterSoicalHistory);
				selenium.clickAt(lnkEncounterSoicalHistory, "");
				
				assertTrue(createSocialHistory(selenium,cdsData),"Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnSign),"could not click sign button", selenium, ClassName, MethodName);	
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-5: Select the CDS Alert rule//
				//--------------------------------------------------------------------//
				assertTrue(navigateToCDSUncheck(selenium),"", selenium, ClassName, MethodName);
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
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyCDSAlert(Selenium selenium,ChartPreVisitLib cdsData) throws IOException{
		boolean returnValue=true;
		
		click(selenium,btnNexiaLogo);
		waitForPageLoad(selenium);
		
		assertTrue(type(selenium,txtsearchbox,cdsData.patientId),"Could not type patient id", selenium, ClassName, MethodName);
		selenium.keyPress(txtsearchbox, "\\9");
		waitForElement(selenium,lblsearchResult,10000);
		assertTrue(selenium.isElementPresent(lblsearchResult),"Search Results are not displayed for the patient with ID :-"+cdsData.patientId, selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblsearchResult).contains(cdsData.patientId),"", selenium, ClassName, MethodName);
		click(selenium,lblsearchResult);
		waitForPageLoad(selenium);
		
		if(cdsData.testCaseId.equals("TC_CSH_007")){
			if(isElementPresent(selenium,lblCdsAlertForSH)){
				returnValue=false;
			}
			else returnValue=true;
		}
		
		else if(!cdsData.testCaseId.equals("TC_CSH_007")){
		 if(selenium.isTextPresent("clinical Decision Support Warning")){
			returnValue=false;
		}
			
		if(!isTextPresent(selenium,"Tobacco")){
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

