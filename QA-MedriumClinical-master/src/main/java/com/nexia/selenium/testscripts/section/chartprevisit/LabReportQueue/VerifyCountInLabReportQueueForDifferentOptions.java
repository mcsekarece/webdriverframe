package com.nexia.selenium.testscripts.section.chartprevisit.LabReportQueue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCountInLabReportQueueForDifferentOptions extends AbstractChartPreVisit {

	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify count of lab reports in lab report queue For DifferentOptions")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCountInLabReportQueueForDifferentOptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_022";
		labData.fetchChartPreVisitTestData();
		verifyCount(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	/**
	 * verifyCount -- #3024
	 * function to verify count of the lab report queue
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 26, 2012
	 */
	public boolean verifyCount(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + labData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, labData.userName, labData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  	//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,labData.switchRole),"Could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		
			//--------------------------------------------------------------------//
			//  Step-3: Get the count of the lab reports//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String resultList=getText(selenium,labReportQueue);
			System.out.println(resultList);
			String[] splitS = resultList.split(" ");
			int metricResult = Integer.parseInt(splitS[0]);
			System.out.println(metricResult);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,labData.patientId);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-5: Delete Existing lab reports//
			//--------------------------------------------------------------------//
			
			assertTrue(deletelabReport(selenium,labData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			//--------------------------------------------------------------------//
			//  Step-6: Get the count of the lab reports//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			String resultList1=getText(selenium,labReportQueue);
			System.out.println(resultList1);
			String[] splitS1 = resultList1.split(" ");
			int metricResult1 = Integer.parseInt(splitS1[0]);
			System.out.println(metricResult1);
		
			if(metricResult1<=metricResult)
				System.out.println("Count is decreasing properly");
			else
				Assert.fail("Count is not decreasing properly");
			
			
			//--------------------------------------------------------------------//
			//  Step-7:Go to Top Manu click Sign out//
			//--------------------------------------------------------------------//
	
			assertTrue(click(selenium,lnkTopMenu),"Could not click top mean header;More Details:"+ labData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSignout),"Could not click the sign out link;More Details:"+ labData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkBtnYes),"Could not click yes button;More Details"+ labData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + labData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, labData.userName, labData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			

			//--------------------------------------------------------------------//
			//  Step-9: Get the count of the lab reports//
			//--------------------------------------------------------------------//
			
			String resultList2=getText(selenium,labReportQueue);
			System.out.println(resultList2);
			String[] splitS2 = resultList2.split(" ");
			int metricResult2 = Integer.parseInt(splitS2[0]);
			System.out.println(metricResult2);
			
			if(metricResult2 == metricResult1)
				System.out.println("Count is stored properly");
			else
			Assert.	fail("Count is not stored properly");
			
		}
       catch(RuntimeException e){
    	   e.printStackTrace();
    	   assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
       }
       return returnValue;
	}
}

		
		
		
		
		
		
		
		
		