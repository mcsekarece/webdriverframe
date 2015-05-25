package com.nexia.selenium.testscripts.section.chartprevisit.correspondencereport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyHideAndShowDetails extends AbstractChartPreVisit{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Hide details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHideDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_012";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify show details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyShowDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_013";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	public boolean createCorresReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib corresData) throws IOException{
		Selenium selenium=null;	
	
		try
		{	//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + corresData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, corresData.userName, corresData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2:Delete All Correspondence report							 //
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	        assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(DeletecorrespondenceReport(selenium, corresData),"Could not click File button btn", selenium, ClassName,MethodName);
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
	        assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblFirstCorresReport),"Could not click First unsigned corres report", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium, btnSign),"Could not click First unsigned corres report", selenium, ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-5:Verify Hide and Shoe Details in Correspondence report page
			//--------------------------------------------------------------------//
			
			assertTrue(verifyHideandShowDetails(selenium,corresData,userAccount),"Could not verify hide and show more details link", selenium, ClassName,MethodName);
			
		}

catch(Exception e)
{
	assertTrue(false,"Test for verifying Hide and Shoe details failed"+e.getMessage(), selenium, ClassName, MethodName);	
}	
		return	true;

	}
	
	public boolean verifyHideandShowDetails(Selenium selenium,ChartPreVisitLib corresData,String userAccount)
	{
		try{
			
			if(corresData.testCaseId.equals("TC_CCR_013"))		{
				
				assertTrue(selenium.getText(InkCorresShowMore).trim().contains("Show report details"),"Show more link is not present", selenium, ClassName,MethodName);	
				assertTrue(click(selenium, InkCorresShowMore),"Could not click Show morw details link", selenium, ClassName,MethodName);
				waitForPageLoad(selenium); 
				assertTrue(isElementPresent(selenium, lblOrderPro),"After Click Show More Details button ,Details not displyed", selenium, ClassName,MethodName);
						}
			
			if(corresData.testCaseId.equals("TC_CCR_012"))	
			{

				assertTrue(selenium.getText(InkCorresShowMore).trim().contains("Show report details"),"Show more link is not present", selenium, ClassName,MethodName);	
				assertTrue(click(selenium, InkCorresShowMore),"Could not click Show morw details link", selenium, ClassName,MethodName);
				waitForPageLoad(selenium); 
				assertTrue(isElementVisible(selenium, lblOrderPro),"After Click Show More Details button ,Details not displyed", selenium, ClassName,MethodName);
				assertTrue(selenium.getText(InkCorresShowMore).trim().contains("Hide report details"),"Show more link is not present", selenium, ClassName,MethodName);	
				assertTrue(click(selenium, InkCorresShowMore),"Could not click Hide morw details link", selenium, ClassName,MethodName);
				waitForPageLoad(selenium); 	
				assertTrue(!isElementVisible(selenium, lblOrderPro),"Could not click Hide morw details link", selenium, ClassName,MethodName);
				waitForPageLoad(selenium); 	
				
			}			
			
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
