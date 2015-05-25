package com.nexia.selenium.testscripts.section.chartprevisit.correspondencereport;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTimeLineForCorresReport extends AbstractChartPreVisit {

	
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Time line")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySaveCommets(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_018";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	
	

	public boolean createCorresReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib corresData) throws IOException{
		Selenium selenium=null;	
		boolean returnvalue=true;
		 try{
		
			 	//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + corresData.toString());
				assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, corresData.userName, corresData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
				//--------------------------------------------------------------------//
				//  Step-2:Delete All Correspondence report							 //
				//--------------------------------------------------------------------//
				assertTrue(goToRegisterPatient(selenium),"Could not navigated to register patient",selenium, ClassName, MethodName);	
				waitForPageLoad(selenium);
				ChartPreVisitLib patientData = new ChartPreVisitLib();
				patientData.workSheetName = "NewPatientCheckIn";
				patientData.testCaseId = "TC_NP_007";
				patientData.fetchChartPreVisitTestData();		
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat dateFormat=new SimpleDateFormat("MdHHmmss");
				String date=dateFormat.format(cal.getTime());
				patientData.lastName=patientData.lastName+date;			
				corresData.patientId=patientData.lastName;
				assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed",selenium, ClassName, MethodName);	
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-3:Correspondence  Report for A patient 
				//--------------------------------------------------------------------//		
				assertTrue(navigateToCorresReport(selenium,corresData),"Could not Navigate to File document",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);			
				assertTrue(CreateCorrespondenceReport(selenium,corresData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
		        waitForPageLoad(selenium);		
		    	assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);	
				//--------------------------------------------------------------------//
				//  Step-4:Search the Patient
				//--------------------------------------------------------------------//	
				assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search patient",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			
				waitForPageLoad(selenium);	
				//--------------------------------------------------------------------//
				//  Step-4:Verify Correspondence report in timeLine Page.
				//--------------------------------------------------------------------//					
				assertTrue(verifyTimeLine(selenium,corresData,userAccount),"Time line verification failed",selenium, ClassName, MethodName);
		 
		 }
		catch (Exception e)
		{		
			assertTrue(false,"Test for verifying Time line for corresreport failed", selenium, ClassName, MethodName);
		}				
		
		return returnvalue;		
	}
	public boolean verifyTimeLine(Selenium selenium, ChartPreVisitLib corresDataString, String userAccount) throws IOException
	{		
		try
		{	
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
			String date=dateFormat.format(cal.getTime());
			
			
			String timeLineData="From "+corresDataString.Sender+" received on"+date;
			assertTrue(selenium.isTextPresent("Correspondence Reports"),"Could not click the Time li logo", selenium, ClassName,MethodName);			
			assertTrue(selenium.isTextPresent(timeLineData),"Could not click the Time li logo", selenium, ClassName,MethodName);			
			
		}
		
		catch(Exception e)
		{
			assertTrue(false,"Function for verifying Time line failed", selenium, ClassName, MethodName);
		}
		return true;
				
	}
	
	
	
	
	
}
