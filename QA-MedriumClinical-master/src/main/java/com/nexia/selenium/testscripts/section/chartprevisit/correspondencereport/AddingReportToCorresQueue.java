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

public class AddingReportToCorresQueue extends AbstractChartPreVisit{

	@Test(groups = {"SmokeSingle","SingleThread", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Correspondance report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addingCorreespondancereport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_001";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Correspondance report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCorresReportQueueCount(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_002";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	 /***************************************************************************************************
     * @purpose To add the report to the Correspondence Queue 
     * @action It will add the Report in Queue 
     * @author Aspire QA
     * @throws IOException
     * @state Developing
     * @useraccount Both (US and Canada)
     * @since Oct 2, 2014
     ***************************************************************************************************/
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
			//  Step-2:Delete previous Correspondence report
			//--------------------------------------------------------------------//			
			// Verify Correspondence Q count before adding Report
			String corresQueue=getText(selenium,QueeCorrespondenace);
			System.out.println(corresQueue);
			String[] splitS = corresQueue.split(" ");
			int queueResult = Integer.parseInt(splitS[0]);
			System.out.println(queueResult);
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
			assertTrue(navigateToCorresReport(selenium,corresData),"Could not Navigate to File document",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			//--------------------------------------------------------------------//
			//  Step-3:Correspondence  Report for A patient 
			//--------------------------------------------------------------------//
			assertTrue(CreateCorrespondenceReport(selenium,corresData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
	        waitForPageLoad(selenium);		
	        assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);			
			String corresQueue1=getText(selenium,QueeCorrespondenace);
			System.out.println(corresQueue1);
			String[] splitS1 = corresQueue1.split(" ");
			int queueResult1 = Integer.parseInt(splitS1[0]);
			if(queueResult1>queueResult){
				returnvalue=true;				
			}
			else
			{
				assertTrue(false,"Correspondence Q count not getting updated", selenium, ClassName, MethodName);
			}
			
			if(corresData.testCaseId.equals("TC_CCR_001"))			
			{
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID//
			//--------------------------------------------------------------------//			
			searchPatientNexiaForProviderHomePage(selenium,corresData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5:Goto correspondence  Tab //
			//--------------------------------------------------------------------//			
			assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblFirstCorresReport),"Could not click First unsigned corres report", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			 if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-6:	Verify added details in Unsigned Correspondence Report															//
			//--------------------------------------------------------------------//		
			assertTrue(VerifyCorrespondenceReportInTab(selenium, corresData,userAccount),"Verification for Correspondence report failed", selenium, ClassName,MethodName);
						
			}
			      
			//--------------------------------------------------------------------//
			//  Step-7:Verify the report in Queue.								 //
			//--------------------------------------------------------------------//
			if(corresData.testCaseId.equals("TC_CCR_002"))			
			{
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			assertTrue(click(selenium,QueeCorrespondenace),"Could not click the correspondence Queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			assertTrue(selectValueFromAjaxList(selenium, forPickList,corresData.For), "Could not select Docu type",	selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(selectValueFromAjaxList(selenium, showPickList,corresData.Show), "Could not select Docu type",	selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(type(selenium,searchBox,corresData.patientId),"Could not type patient id",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(clickAt(selenium,searchBox, ""),"Could not perform click At",selenium, ClassName, MethodName);
			assertTrue(focus(selenium,searchBox),"Could not perform focus",selenium, ClassName, MethodName);
			assertTrue(fireEvent(selenium,searchBox,"keypress"),"Could not perform fireevent",selenium, ClassName, MethodName);			
			assertTrue(keyPress(selenium,searchBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			assertTrue(	waitForElement(selenium,lblcorresQFirst,30000),"Element not present", selenium, ClassName,MethodName);
			assertTrue(verifyCorrespondenceReportInQueue(selenium, corresData,userAccount),"Verification for Correspondence report failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			assertTrue(click(selenium,lblcorresQFirst),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			assertTrue(isElementPresent(selenium,btncorressign),"Could not Find the Sign button,Report not opened (not clicked in queue)fron Q", selenium, ClassName,MethodName);
			assertTrue(verifyCorrespondenceReportInFromQueue(selenium, corresData,userAccount),"Verification for Correspondence report failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);				
			assertTrue(click(selenium,btncorressign),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(isTextPresent(selenium,"Signed by"),"Could not find the Signed by blue text after sign off", selenium, ClassName,MethodName);			
					assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);		
					assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(	waitForElement(selenium,lblFirstSignedCorresReport,30000),"Element not present", selenium, ClassName,MethodName);
			assertTrue(isElementPresent(selenium,lblFirstSignedCorresReport),"Could not Find the Signed record under signed corres report", selenium, ClassName,MethodName);
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);				
			String corresQueue3=getText(selenium,QueeCorrespondenace);
			System.out.println(corresQueue3);
			String[] splitS3 = corresQueue.split(" ");
			int queueResult3 = Integer.parseInt(splitS3[0]);
			System.out.println(queueResult3);
			if(queueResult3==queueResult){
				return true;
			}
			else{
				assertTrue(false,"After Sign the Count in the Q not decreased Befor Count=+"+queueResult+",After Count=="+queueResult3, selenium, ClassName, MethodName);
			}
			}
			
			return returnvalue;
		}
			catch(Exception e)	{
			assertTrue(false,"Test for verifying Correspondenace Queue Failed", selenium, ClassName, MethodName);
		}
		return false;
		
	}		
	
	
	public boolean verifyCorrespondenceReportInQueue(Selenium selenium,ChartPreVisitLib corresData, String userAccount)
	{
		
		
		try {
			String providerNameTemp = getText(selenium, lnkTopMenu);
			String pName = providerNameTemp.replaceAll(", "+ corresData.switchRole, "");					
				String date = null;  
				if(userAccount.equals(CAAccount)){
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat dateFormat=new SimpleDateFormat("MMM dd, yyyy ");
					date=dateFormat.format(cal.getTime());

				}else{
					Calendar cal1=Calendar.getInstance();
					SimpleDateFormat dateForma1t=new SimpleDateFormat("MM/dd/yyyy");
					date=dateForma1t.format(cal1.getTime());		
				}		
				String reportData=corresData.ReportType;		
			
			String verifyText="report sent by "+corresData.Sender+" to Dr."+pName+" on "+date.trim();				
			assertTrue(getText(selenium,lblcorresQFirst).toLowerCase(new java.util.Locale("en","US")).trim().contains(reportData.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find the added details", selenium, ClassName,MethodName);			
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
	
	public boolean verifyCorrespondenceReportInFromQueue(Selenium selenium,ChartPreVisitLib corresData, String userAccount)
	{
		
		
		try {
			String providerNameTemp = getText(selenium, lnkTopMenu);
			String pName = providerNameTemp.replaceAll(", "+ corresData.switchRole, "");					
				String date = null;  
				if(userAccount.equals(CAAccount)){
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat dateFormat=new SimpleDateFormat("MMM dd, yyyy");
					date=dateFormat.format(cal.getTime());

				}else{
					Calendar cal1=Calendar.getInstance();
					SimpleDateFormat dateForma1t=new SimpleDateFormat("MMM dd, yyyy");
					date=dateForma1t.format(cal1.getTime());		
				}		
			
			assertTrue(click(selenium, InkCorresShowMore),"Could not click Show morw details link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			String verifyText="report sent by "+corresData.Sender+" to Dr."+pName+" on "+date.trim();	
			
			assertTrue(getText(selenium,lblOrderPro).toLowerCase(new java.util.Locale("en","US")).trim().contains("dr."+pName.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find the Ordering provider name", selenium, ClassName,MethodName);
		
			assertTrue(getText(selenium,ReceivingPro).toLowerCase(new java.util.Locale("en","US")).trim().contains("dr."+pName.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find the Receiving provider name", selenium, ClassName,MethodName);
			
			assertTrue(getText(selenium,lblsign).toLowerCase(new java.util.Locale("en","US")).trim().contains(verifyText.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find the added details sign details", selenium, ClassName,MethodName);
		
			assertTrue(getText(selenium,lblDOS).toLowerCase(new java.util.Locale("en","US")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find the added details sign details", selenium, ClassName,MethodName);
			
			
			return true;	
		}	
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
	}
	
	
	
}
