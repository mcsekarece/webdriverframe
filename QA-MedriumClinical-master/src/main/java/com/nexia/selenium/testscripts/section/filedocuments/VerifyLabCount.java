package com.nexia.selenium.testscripts.section.filedocuments;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.taskManagement.AbstractTaskManagement;
import com.nexia.selenium.genericlibrary.templateSetup.AbstractTemplateSetup;
import com.nexia.selenium.genericlibrary.templateSetup.TemplateSetupLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyLabCount extends AbstractTemplateSetup{
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
	* @defect 		  #6670	
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 22, 2013	
	***************************************************************************************************/
	
	public boolean verifyHourFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, TemplateSetupLib documentTestData ) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;
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
			//  Step-3: Get Lab Count 										      //
			//--------------------------------------------------------------------//
			AbstractChartPreVisit labData = new AbstractChartPreVisit();
			ChartPreVisitLib labReportData = new ChartPreVisitLib();
			String resultList=getText(selenium,labData.labReportQueue);
			System.out.println(resultList);
			String[] splitS = resultList.split(" ");
			int metricResult = Integer.parseInt(splitS[0]);
			System.out.println(metricResult);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to File Document						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToFileDocument(selenium),"Could not navigate to day sheet template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Upload the file						  //
			//--------------------------------------------------------------------//
			AbstractTaskManagement fileData = new AbstractTaskManagement();
			
			assertTrue(fileData.addAttachment(selenium), "Could not Update the file",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Search Patient				  //
			//--------------------------------------------------------------------//
			assertTrue(patientSearch(selenium),"Could not searc hthe patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-6:Create File Report			  //
			//--------------------------------------------------------------------//
			assertTrue(labData.fileReport(selenium, labReportData, userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Navigate Home Page		  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnNexiaLogo),"Could not click the nexia Logo",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			String resultList1=getText(selenium,labData.labReportQueue);
			System.out.println(resultList1);
			String[] split1 = resultList.split(" ");
			int metricResult1= Integer.parseInt(split1[0]);
			System.out.println(metricResult1);
			waitForPageLoad(selenium);
			
			if(!(metricResult1<=metricResult)){
				Assert.fail("Value is not increased");
			}
			
			assertTrue(click(selenium,labData.labReportQueue),"Could not click Lab report queue", selenium, ClassName, MethodName);
			assertTrue(type(selenium,labData.searchBox,"MATHEWAAA"),"",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,labData.forPickList,"Myself");
			
			if(!(getText(selenium,"//div[3]/div/div/div/div/div/div/div[2]/div/div/div/div").contains("MATHEWAAA"))){
				Assert.fail("Detail is not getting displayed");
			}
			
			
			
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
