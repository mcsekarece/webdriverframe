package com.nexia.selenium.testscripts.section.chartprevisit.EncounterReference;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCancelForEncounterReserence extends AbstractChartPreVisit {
	@Test(groups =  {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing Reference")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelInEdit(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "CreateEncounterReference";
		encounterData.testCaseId = "TC_ER_004";
		encounterData.fetchChartPreVisitTestData();
		editEncounterReference(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	@Test(groups =  {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing Reference")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancel(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "CreateEncounterReference";
		encounterData.testCaseId = "TC_ER_005";
		encounterData.fetchChartPreVisitTestData();
		editEncounterReference(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	@Test(groups =  {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing Reference")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelReferenceQA(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "CreateEncounterReference";
		encounterData.testCaseId = "TC_ER_006";
		encounterData.fetchChartPreVisitTestData();
		editEncounterReference(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	/*************************************************************************************************** 
	* @purpose        To verify test for edit Encounter References
	* @action 		  verifying test for edit Encounter References 
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Completed
	* @useraccount    Both(Us and Canada)
	* @since  	      July 17, 2013
	***************************************************************************************************/
	public boolean editEncounterReference(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
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
			
			if(encounterData.testCaseId.equals("TC_ER_006")){
				assertTrue(goToReference(selenium),"Could not click the link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,"cancel"),"Could not click on cancel", selenium, ClassName, MethodName);
				
				assertTrue(!isElementPresent(selenium,txtReference),"Could not click the link", selenium, ClassName, MethodName);
				
			}
			assertTrue(	searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId),"Could not Select", selenium, ClassName, MethodName);
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
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Naviagte to Reference//
			//--------------------------------------------------------------------//
			selenium.focus(lnkBeginEncounterAction);
			selenium.clickAt(lnkBeginEncounterAction, "");
			assertTrue(click(selenium,lnkReference),"Could not click the Refernce link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Delete Exist Reference//
			//--------------------------------------------------------------------//s
			assertTrue(deleteEncounterReference(selenium,encounterData),"Could not delete", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Create Encounter Reference//
			//--------------------------------------------------------------------//
		    assertTrue(createEncounterReference(selenium,encounterData),"creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8:Edit Created Reference//
			//--------------------------------------------------------------------//
			
		
			
			int count=1;
			while(isElementPresent(selenium,"//div[@id='userReferenceListView']/table/tbody/tr["+count+"]/td[2]/div/a")){
				if(getText(selenium,"//div[@id='userReferenceListView']/table/tbody/tr["+count+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.bookMark.toLowerCase(new java.util.Locale("en","US")).trim())){
					assertTrue(click(selenium,"//div[@id='userReferenceListView']/table/tbody/tr["+count+"]/td[2]/div/a"),"could not click", selenium, ClassName, MethodName);
					encounterData.workSheetName = "CreateEncounterReference";
					encounterData.testCaseId = "TC_ER_003";
					encounterData.fetchChartPreVisitTestData();
					assertTrue(type(selenium,"//div[@id='userReferenceListView']/table/tbody/tr["+count+"]/td/div/div/div/input",encounterData.bookMark),"Could not type the Book mark details", selenium, ClassName, MethodName);
					assertTrue(type(selenium,"//div[@id='userReferenceListView']/table/tbody/tr["+count+"]/td/div/div/div/input[2]",encounterData.reference),"could not enter the details", selenium, ClassName, MethodName);
					
					assertTrue(click(selenium,btnCancelID),"could not click", selenium, ClassName, MethodName);
			
					waitForPageLoad(selenium);
					break;
				}else
					count++;
				
				if(count>50){
					break;
				}
			}	
			
			
			if(!getText(selenium,"//div[6]/table/tbody/tr[2]/td[2]/div/div/div[2]/div/div[3]").toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.bookMark.toLowerCase(new java.util.Locale("en","US")).trim())){
				returnValue=true;
			}else
				fail("Encounter Reference is not Created");
			
			if(encounterData.testCaseId.equals("TC_ER_005")){
				assertTrue(click(selenium,"cancel"),"Could not click on cancel", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!isElementPresent(selenium,lnkBookMark),"could not Find the Element", selenium, ClassName, MethodName);
				
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}

