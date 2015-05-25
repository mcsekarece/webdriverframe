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

public class VerifyHeaderandFooterForCorresReport extends AbstractChartPreVisit{

	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying header and Footer information")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrinAndFax(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_017";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	
	
	public boolean createCorresReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib corresData) throws IOException{
		Selenium selenium=null;	
		boolean returnvalue=true;
		
		try
		{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + corresData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, corresData.userName, corresData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2:Delete previous Correspondence report
			//--------------------------------------------------------------------//			
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not find patient", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		

			assertTrue(click(selenium, CorresTab),"Could not click corres tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(DeletecorrespondenceReport(selenium, corresData),"Could not click File button btn", selenium, ClassName,MethodName);
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
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID//
			//--------------------------------------------------------------------//			
			searchPatientNexiaForProviderHomePage(selenium,corresData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5:Goto correspondence  Tab //
			//--------------------------------------------------------------------//			
			assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkLabPrint),"Could not click Print&Send button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnOkButton),"Could not click Print button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6:Verify Print Preview Page								 //
			//--------------------------------------------------------------------//				
			assertTrue(verifyHeaderandFooter(selenium,corresData,userAccount),"Could not Navigate to File document",selenium, ClassName, MethodName);
			
			
		}
	catch(Exception e)
	{
		assertTrue(false,"Test for verifying Header and Footer details failed"+e.getMessage(), selenium, ClassName, MethodName);	
	}	
					
	return returnvalue;
	}
	
	public boolean verifyHeaderandFooter(Selenium selenium,ChartPreVisitLib CorresData, String userAccount) throws IOException
	{
		try{
			String providerNameTemp = getText(selenium, lnkTopMenu);
			String pName = providerNameTemp.replaceAll(", "+ CorresData.switchRole, "");
			String patirntName = getText(selenium, lblpatientName);
			String patientNAme[]=patirntName.split(" ");
			patirntName=patientNAme[1].trim()+" "+patientNAme[0].trim();
				String date = null;  
				if(userAccount.equals(CAAccount)){
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat dateFormat=new SimpleDateFormat("MMM d, yyyy");
					date=dateFormat.format(cal.getTime());

				}else{
					Calendar cal1=Calendar.getInstance();
					SimpleDateFormat dateForma1t=new SimpleDateFormat("MM/dd/yyyy");
					date=dateForma1t.format(cal1.getTime());		
				}					
							
			String patientDoB=getText(selenium, txtPatientDob);
			patientDoB=patientDoB.replace("(", "");
			patientDoB=patientDoB.replace(")", "");
			System.out.println(selenium.getText(txtPrintPreview));
	
			assertTrue(getText(selenium,txtPrintPreview).toLowerCase(new java.util.Locale("en","US")).trim().contains("CORRESPONDENCE REPORT".trim().toLowerCase(new java.util.Locale("en","US"))),"Entered details not found in Print preview", selenium, ClassName,MethodName);		
			assertTrue(getText(selenium,txtPrintPreview).toLowerCase(new java.util.Locale("en","US")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","US"))),"Entered details not found in Print preview", selenium, ClassName,MethodName);		
			assertTrue(getText(selenium,txtPrintPreview).toLowerCase(new java.util.Locale("en","US")).trim().contains("Printed on".trim().toLowerCase(new java.util.Locale("en","US"))),"Entered details not found in Print preview", selenium, ClassName,MethodName);		
			assertTrue(getText(selenium,txtPrintPreview).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientDoB.trim().toLowerCase(new java.util.Locale("en","US"))),"Entered details not found in Print preview", selenium, ClassName,MethodName);		
			assertTrue(getText(selenium,txtPrintPreview).toLowerCase(new java.util.Locale("en","US")).trim().contains("1 of 1".trim().toLowerCase(new java.util.Locale("en","US"))),"Entered details not found in Print preview", selenium, ClassName,MethodName);		
				}
		
		catch(Exception e)
		{
			assertTrue(false,"Function for verifying Header and Footer details failed"+e.getMessage(), selenium, ClassName, MethodName);
			
		}
		
		return true;
	}
	
}
