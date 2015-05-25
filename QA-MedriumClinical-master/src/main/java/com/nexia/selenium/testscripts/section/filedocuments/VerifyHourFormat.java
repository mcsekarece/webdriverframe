package com.nexia.selenium.testscripts.section.filedocuments;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;

import com.nexia.selenium.genericlibrary.templateSetup.AbstractTemplateSetup;
import com.nexia.selenium.genericlibrary.templateSetup.TemplateSetupLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyHourFormat extends AbstractTemplateSetup{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify delete day sheet template ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void hourFormatInFileDoucment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		TemplateSetupLib documentTestData = new TemplateSetupLib();
		documentTestData.workSheetName = "CreateTemplateSetup";
		documentTestData.testCaseId = "TC_TS_001";
		documentTestData.fetchTemplateSetupTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyHourFormat(seleniumHost, seleniumPort, browser, webSite, userAccount,documentTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify Hour Format in File Document
	* @action 		  verifying Hour Format in File Document
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @defect 		  #7590 	
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 22, 2013	
	***************************************************************************************************/
	
	public boolean verifyHourFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TemplateSetupLib documentTestData ) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;
		String date="";
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application 								  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + documentTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, documentTestData.userName, documentTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,documentTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Day sheet template  						  //
			//--------------------------------------------------------------------//
//			assertTrue(navigateToFileDocument(selenium),"Could not navigate to day sheet template", selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
//			
//			//--------------------------------------------------------------------//
//			//  Step-4: Delete all Day sheet template							  //
//			//--------------------------------------------------------------------//
//			ChartPreVisitLib CorresData = new ChartPreVisitLib();
//			CorresData.workSheetName = "CreateCorresReport";
//			CorresData.testCaseId = "TC_CCR_020";
//			CorresData.fetchChartPreVisitTestData();		
//
//			assertTrue(createCorrespondenceReport(selenium, CorresData, userAccount),"Could not navigate to day sheet template", selenium, ClassName, MethodName);

			//Date and Time Format
			Calendar cal=Calendar.getInstance();
			
			SimpleDateFormat DateFormat1=new SimpleDateFormat("dd");
			String day=DateFormat1.format(cal.getTime());
			int days = Integer.parseInt(day);

			if(days<10)
			{
				SimpleDateFormat DateFormat=new SimpleDateFormat("MMM d,yyyy");
				date=DateFormat.format(cal.getTime());
			}
			else
			{
				SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd,yyyy");
				date=DateFormat.format(cal.getTime());
			}
	
				
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll( ", "+documentTestData.switchRole, "");
			String Providername=getValue(selenium,ajxSelectBatch).toLowerCase().trim();
			System.out.println(date+" "+Providername.toLowerCase());
			System.out.println(providerName);
			assertTrue(getValue(selenium,ajxSelectBatch).contains(date), "Could not find date", selenium, ClassName, MethodName);
			assertTrue(Providername.toLowerCase().trim().contains(providerName.toLowerCase().trim()), "Could not find Provider", selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
	
	
}
