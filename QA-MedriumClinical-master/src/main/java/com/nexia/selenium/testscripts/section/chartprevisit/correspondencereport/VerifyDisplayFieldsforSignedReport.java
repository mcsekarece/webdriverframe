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

public class VerifyDisplayFieldsforSignedReport extends AbstractChartPreVisit{

	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the Signed report details ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addingCorreespondanceReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_028";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the Signed report details and Sign statement ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySignBlueText(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_029";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	public boolean createCorresReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib corresData) throws IOException{
		Selenium selenium=null;	
		
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + corresData.toString());
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, corresData.userName, corresData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
		//--------------------------------------------------------------------//
		//  Step-2: Switch role to full Access
		//--------------------------------------------------------------------//
		assertTrue(switchRole(selenium,corresData.switchRole),"Could not change the switch role;More Details:"+corresData.toString(),selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		//--------------------------------------------------------------------//
		//  Step-3:Delete All Correspondence report							 //
		//--------------------------------------------------------------------//
		assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search patient",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
	    assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(DeletecorrespondenceReport(selenium, corresData),"Could not click File button btn", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);	
		//--------------------------------------------------------------------//
		//  Step-4: Create a Correspondence report 
		//--------------------------------------------------------------------//
		assertTrue(navigateToCorresReport(selenium,corresData),"Could not Navigate to File document",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		assertTrue(CreateCorrespondenceReport(selenium,corresData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
		waitForPageLoad(selenium);
    	assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		//--------------------------------------------------------------------//
		//  Step-5: Search the patient 
		//--------------------------------------------------------------------//
		assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search patient",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
	     assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblFirstCorresReport),"Refiles record is not found", selenium, ClassName,MethodName);
		//--------------------------------------------------------------------//
		//  Step-6:Verify the display fields
		//--------------------------------------------------------------------//
	
		if(corresData.testCaseId.equals("TC_CCR_028"))
		{
			assertTrue(	verifyDisplayFields(selenium,corresData,userAccount),"Verification failed", selenium, ClassName,MethodName);
		}
			//--------------------------------------------------------------------//
		//  Step-7:Sign Report and verify Signed details 
		//--------------------------------------------------------------------//
		if(corresData.testCaseId.equals("TC_CCR_029"))
		{
			 assertTrue(click(selenium, btncorressign),"Could not click sign button in correspondence report", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
			 waitForPageLoad(selenium);
			 String providerNameTemp = getText(selenium, lnkTopMenu);
			String pName = providerNameTemp.replaceAll(", "+ corresData.switchRole, "");		
			String signStatement="Signed by Dr."+pName+" at";
			assertTrue(getText(selenium,txtSignedby).toLowerCase(new java.util.Locale("en","US")).trim().contains(signStatement.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find the added details", selenium, ClassName,MethodName);			
		}
		
		return true;
	}
	
	public boolean verifyDisplayFields(Selenium selenium, ChartPreVisitLib corresData,String userAccount)
	{
		
		
		
		try {
			String providerNameTemp = getText(selenium, lnkTopMenu);
			String pName = providerNameTemp.replaceAll(", "+ corresData.switchRole, "");					
				String date = null;  
				if(userAccount.equals(CAAccount)){
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy ");
					date=DateFormat.format(cal.getTime());

				}else{
					Calendar cal1=Calendar.getInstance();
					SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
					date=DateForma1t.format(cal1.getTime());		
				}		
				String ReportData=corresData.ReportType;		
			
			String verifyText="report sent by "+corresData.Sender+" to Dr."+pName+" on "+date.trim();				
			assertTrue(getText(selenium,lblcorresQFirst).toLowerCase(new java.util.Locale("en","US")).trim().contains(ReportData.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find the added details", selenium, ClassName,MethodName);			
			assertTrue(getText(selenium,lblcorresQFirst).toLowerCase(new java.util.Locale("en","US")).trim().contains(verifyText.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find the added details", selenium, ClassName,MethodName);
			assertTrue(isElementPresent(selenium,lblNewTag),"Could not Find New Tag in Corres Queue", selenium, ClassName,MethodName);			
			assertTrue(isElementPresent(selenium,corresData.patientId),"Could not Find Patient Corres Queue", selenium, ClassName,MethodName);			
			return true;	
		}	
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
		
	}
	
	
	
}
