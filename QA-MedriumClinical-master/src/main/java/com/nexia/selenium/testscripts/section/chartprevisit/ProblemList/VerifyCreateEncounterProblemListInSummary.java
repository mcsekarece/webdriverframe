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

public class VerifyCreateEncounterProblemListInSummary extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCreateEncounterProblemListInSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPL_027";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	/**
	 * addProblemList
	 * function to add ProblemList
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 04, 2012
	 */

	public boolean addProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws IOException{
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
			//--------------------------------------------------------------------//
			//  Step-4: Delete All existing Problem List//
			//--------------------------------------------------------------------//

			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllProblemList(selenium, proData),"Deletion faied",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			/*assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+proData.toString());
			waitForPageLoad(selenium);*/
			//--------------------------------------------------------------------//
			//  Step-4: Begin Encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-5: Delete Encounter Problem list//
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,lnkEncounterProblemList),"Could not find the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkEncounterProblemList,"");
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Procedure//
			//--------------------------------------------------------------------//
			assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSummary),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Verify Stored Values//
			//--------------------------------------------------------------------//
			if(!verifyCollapseView(selenium,proData,userAccount, sectionName)){
				Assert.fail("Problem List details not saved properly in collapse view :"+ proData.toString());
			}
			
			if(!verifyExpandView(selenium,proData,sectionName)){
				Assert.fail("Problem List details not saved properly in Expand view :"+ proData.toString());
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyCollapseView(Selenium selenium, ChartPreVisitLib proData, String account, String sectionName){
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
			
		int sectionCount = (Integer) selenium.getXpathCount("//td[2]/div/div/div/div/div/div/table/tbody/tr/td/div/div");
		for(int count = 1; count <=sectionCount; count++ ){
			String section = selenium.getText("//td[2]/div/div/div/div/div/div/table/tbody/tr["+count+"]/td/div/div");
			if(section.contains(sectionName)){
				
				if(!(section).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.medicalCondition1.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				if(!(section).trim().contains(upDate.trim())){
					return false;
				}
				
				if(!(section).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.itemStatus.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				
				if(!(section).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.comment.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
			}
			break;
		}
		
		
		return true;
	}	
	
	public boolean verifyExpandView(Selenium selenium, ChartPreVisitLib proData, String sectionName) throws IOException{
		int sectionCount = (Integer) selenium.getXpathCount("//td[2]/div/div/div/div/div/div/table/tbody/tr/td/div/div");
		for(int count = 1; count <=sectionCount; count++ ){
			String section = selenium.getText("//td[2]/div/div/div/div/div/div/table/tbody/tr["+count+"]/td/div/div");
			if(section.contains(sectionName)){
				assertTrue(click(selenium,"//td[2]/div/div/div/div/div/div/table/tbody/tr["+count+"]/td/div/div/div[2]/div/div/div/div/div/div[3]/a"), "Could not click the arrow", selenium, ClassName, MethodName)	;
				String expandDetails = selenium.getText("//td[2]/div/div/div/div/div/div/table/tbody/tr["+count+"]/td/div/div/div[2]/div/div/div/div/div/div[2]");
				
				if(!(expandDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.lifeStage.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				if(!(expandDetails).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.diagnosis.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				break;
			}
		}
		return true;
	}	
}