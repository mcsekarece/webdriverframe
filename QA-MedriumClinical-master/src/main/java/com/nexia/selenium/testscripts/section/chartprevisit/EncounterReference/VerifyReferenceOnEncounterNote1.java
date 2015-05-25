package com.nexia.selenium.testscripts.section.chartprevisit.EncounterReference;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyReferenceOnEncounterNote1 extends AbstractChartPreVisit {
	@Test(groups =  {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Creating Reference")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDirectAccessReference(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "CreateEncounterReference";
		encounterData.testCaseId = "TC_ER_007";
		encounterData.fetchChartPreVisitTestData();
		addEncounterReference(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	@Test(groups =  {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Creating Reference")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteReference(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "CreateEncounterReference";
		encounterData.testCaseId = "TC_ER_012";
		encounterData.fetchChartPreVisitTestData();
		addEncounterReference(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	/*************************************************************************************************** 
	* @purpose        To verify test for add Encounter References
	* @action 		  verifying test for add Encounter References 
	* @author         Aspire QA
	 * @throws        IOException 
	* @state          Completed
	* @useraccount    Both(Us and Canada)
	* @since  	      July 18, 2013
	***************************************************************************************************/
	
	
	public boolean addEncounterReference(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium= null;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId),"could not Select", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,encounterData),"could not delete", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Naviagte to Reference//
			//--------------------------------------------------------------------//
			selenium.focus(lnkBeginEncounterAction);
			selenium.clickAt(lnkBeginEncounterAction, "");
			
			assertTrue(click(selenium,lnkReference),"Could not click the Refernce link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			//assertTrue(click(selenium, "class=add-button"),"Could not click add refrence button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium); 	
			
				assertTrue(type(selenium,txtLnkRefrence,encounterData.reference),"could not enter the details", selenium, ClassName, MethodName);
				assertTrue(click(selenium,lnkGo),"could not enter the details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				String st1[]=selenium.getAllWindowNames();
				waitForPageLoad(selenium);
				switchto(st1[1]);
				selenium.selectWindow(st1[1]);
				selenium.windowFocus();
				
				
				if(isElementPresent(selenium,"link=Home")){
					return returnValue;
				}
				else{
					returnValue=false;
				}
			
				String st2[]=selenium.getAllWindowNames();
				waitForPageLoad(selenium);
				switchto(st2[0]);
				selenium.selectWindow(st1[0]);
				selenium.windowFocus();
				
				if(getText(selenium,"//div[15]").contains(encounterData.reference)){
					returnValue=true;
				}
				
				if(encounterData.testCaseId.contains("TC_ER_012")){
					assertTrue(click(selenium,"//a[contains(text(),'Delete')]"),"could not delete details", selenium, ClassName, MethodName);
					assertTrue(click(selenium,"link=Yes"),"Colud not click", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					
					if(getText(selenium,"//div[15]").contains(encounterData.reference)){
						returnValue=true;
					}
				}
				
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}	
		private void switchto(String string) {
			// TODO Auto-generated method stub
		}
	}