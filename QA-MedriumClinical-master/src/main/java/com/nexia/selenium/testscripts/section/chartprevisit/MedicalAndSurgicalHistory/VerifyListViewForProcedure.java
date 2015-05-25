package com.nexia.selenium.testscripts.section.chartprevisit.MedicalAndSurgicalHistory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyListViewForProcedure extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProcedureWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProcedure";
		proData.testCaseId = "TC_CP_030";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyListView(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	
	/**
	 * verifyListView
	 * function to verify List View
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Sep 27, 2012
	 */
	
	public boolean verifyListView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws IOException{
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
			
			//--------------------------------------------------------------------//
			//  Step-4: delete  Procedure//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkProcedure),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteProcedure(selenium,proData),"Could not delete the procedure",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Procedure//
			//--------------------------------------------------------------------//
			assertTrue(createProcedure(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
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
				
			assertTrue(click(selenium,lnkProcedure),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Verify Collapse View//
			//--------------------------------------------------------------------//
			assertTrue(verifyCollapseViewForProcedure(selenium,proData,userAccount),"Problem List details not saved properly in collapse view :"+ proData.toString(),selenium, ClassName, MethodName);
	
			//--------------------------------------------------------------------//
			//  Step-7: Verify Expand View View//
			//--------------------------------------------------------------------//
			assertTrue(verifyExpandViewForProcedure(selenium,proData,userAccount),"Problem List details not saved properly in Expand view :"+ proData.toString(),selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify time stamp//
			//--------------------------------------------------------------------//
			
			//assertTrue(verifyTimeStampForProviderPage(selenium, "//span/div/div[3]/span", date, time), "Time stamp is not displayed");
			//waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
