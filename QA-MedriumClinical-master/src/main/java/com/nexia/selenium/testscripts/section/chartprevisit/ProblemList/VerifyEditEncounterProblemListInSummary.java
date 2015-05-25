package com.nexia.selenium.testscripts.section.chartprevisit.ProblemList;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditEncounterProblemListInSummary extends AbstractChartPreVisit{
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Edit Encounter Problem List In Summary")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditEncounterProblemListInSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPL_032";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	/**
	 * editProblemList
	 * function to edit ProblemList
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 04, 2012
	 */

	public boolean editProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String sectionName = "Problem List";
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + proData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, proData.userName, proData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,proData),"Deletion Failed",selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete All existing Problem List//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllProblemList(selenium, proData),"Deletion faied",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			/*assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			//--------------------------------------------------------------------//
			//  Step-4: Begin Encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			//--------------------------------------------------------------------//
			//  Step-5: Delete Encounter Problem list//
			//--------------------------------------------------------------------//
		/*	assertTrue(deleteProblemListInEncounter(selenium,proData),"deletion failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			*/
			
			assertTrue(isElementPresent(selenium,lnkEncounterProblemList),"Could not find the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkEncounterProblemList,"");
			
			waitForPageLoad(selenium);			
			
			//--------------------------------------------------------------------//
			//  Step-6: Add Encounter Problem list//
			//--------------------------------------------------------------------//
			assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-7: Verify Stored Problem list//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSummary),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyCollapseView(selenium,proData,userAccount,sectionName),"Problem List details not saved properly in collapse view :"+ proData.toString(),selenium, ClassName, MethodName);

		/*	if(!verifyCollapseView(selenium,proData,userAccount,sectionName)){
				Assert.fail("Problem List details not saved properly in collapse view :"+ proData.toString());
			}*/

			assertTrue(verifyExpandView(selenium,proData,sectionName),"Problem List details not saved properly in Expand view :"+ proData.toString(),selenium, ClassName, MethodName);

		/*	if(!verifyExpandView(selenium,proData,sectionName)){
				Assert.fail("Problem List details not saved properly in Expand view :"+ proData.toString());
			}*/
			assertTrue(click(selenium,btnSaveProblemList),"Could not click the save button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8:Again  Navigate to Encounter //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lblEnProblemList),"Could not click the data a entry;More Details"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEdit),"Could not click the edit button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			
			proData.workSheetName = "CreateProblemList";
			proData.testCaseId = "TC_CPL_005";
			proData.fetchChartPreVisitTestData();
			
			assertTrue(editProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Verify Stored Problem list//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkSummary),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyCollapseView(selenium,proData,userAccount,sectionName),"Problem List details not saved properly in collapse view :"+ proData.toString(),selenium, ClassName, MethodName);

		/*	if(!verifyCollapseView(selenium,proData,userAccount,sectionName)){
				Assert.fail("Problem List details not saved properly in collapse view :"+ proData.toString());
			}*/
	
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyCollapseView(Selenium selenium, ChartPreVisitLib proData, String account, String sectionName) throws IOException{
		String upDate="";

		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			 upDate=DateFormat.format(cal.getTime());
			
		}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			upDate=DateFormat.format(cal.getTime());
			
		}
		assertTrue(getText(selenium,lnkExpandArrow).toUpperCase().contains(proData.medicalCondition1.toUpperCase()),""+"Problem list Medical Condition Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		
		
		assertTrue(selenium.isTextPresent(upDate),""+"Problem list Date Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
	
		assertTrue(selenium.isTextPresent(proData.itemStatus),""+"Problem ItemStatus Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	
		
		assertTrue(selenium.isTextPresent(proData.comment),""+" Problem Comment Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		return true;
	}	
	
	public boolean verifyExpandView(Selenium selenium, ChartPreVisitLib proData, String sectionName) throws IOException{
		assertTrue(click(selenium,lblCollapseViewArrow),"Could not click on Expand button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selenium.isTextPresent(proData.lifeStage),""+"Problem Life Stage Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}	
}
