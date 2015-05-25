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

public class VerifyListViewForProblemList extends AbstractChartPreVisit {
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyListView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPL_033";
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
		String date="";
		String time="";
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
			
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,proData),"Deletion Failed",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");	
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lblEncounterSave),"Could not click on encounter save",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete All existing Problem List//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllProblemList(selenium, proData),"Deletion faied",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Procedure//
			//--------------------------------------------------------------------//
			assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify Collapse View//
			//--------------------------------------------------------------------//
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
					date=DateFormat.format(cal.getTime());
					int date1=Integer.parseInt(date);
					if(date1<10){
						SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
						date=DateForma1t.format(cal.getTime());
						DateFormat=new SimpleDateFormat("HH");
						time=DateFormat.format(cal.getTime());
					}else{
						SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");
						date=DateFormat2.format(cal.getTime());
						DateFormat=new SimpleDateFormat("HH");
						time=DateFormat.format(cal.getTime());
					}
				}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
				DateFormat=new SimpleDateFormat("HH");
				time=DateFormat.format(cal.getTime());
			}
				
			if(!verifyCollapseView(selenium,proData,userAccount)){
				Assert.fail("Problem List details not saved properly in collapse view :"+ proData.toString());
			}
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Expand View View//
			//--------------------------------------------------------------------//
			if(!verifyExpandView(selenium,proData)){
				Assert.fail("Problem List details not saved properly in Expand view :"+ proData.toString());
			}
			
				
				
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyCollapseView(Selenium selenium, ChartPreVisitLib proData,String account) throws IOException{
		String date=null;
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			date=DateFormat.format(cal.getTime());
					
				
			}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
			
		}
		
		assertTrue(selenium.isTextPresent(proData.medicalCondition1),""+"Problem Medical Condition Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selenium.isTextPresent(date),""+"Problem list Date Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
	
		assertTrue(selenium.isTextPresent(proData.itemStatus),""+"Problem ItemStatus Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	
		
		assertTrue(selenium.isTextPresent(proData.comment),""+" Problem Comment Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
	
		return true;
	}	
	
	public boolean verifyExpandView(Selenium selenium, ChartPreVisitLib proData) throws IOException{
		assertTrue(click(selenium,lblCollapseViewArrow),"Could not click on Expand button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selenium.isTextPresent(proData.lifeStage),""+"Problem Life Stage Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		waitForPageLoad(selenium);
	
		return true;
	}	
}

