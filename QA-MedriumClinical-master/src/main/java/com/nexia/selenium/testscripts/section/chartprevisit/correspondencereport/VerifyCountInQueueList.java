package com.nexia.selenium.testscripts.section.chartprevisit.correspondencereport;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCountInQueueList extends AbstractChartPreVisit{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the comment")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCountinWaitListView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_020";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	
	public boolean createCorresReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib corresData) throws IOException{
		Selenium selenium=null;	
try
{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + corresData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, corresData.userName, corresData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2:Delete All Correspondence report							 
			//--------------------------------------------------------------------//	
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,corresData.patientId),"Could not search patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	        assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(DeletecorrespondenceReport(selenium, corresData),"Could not click File button btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-3:Create a correspondence report for the patient 						 
			//-------------------------------------------------------------------
			assertTrue(navigateToCorresReport(selenium,corresData),"Could not Navigate to File document",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			assertTrue(CreateCorrespondenceReport(selenium,corresData,userAccount),"Creation of Corres Report failed ", selenium, ClassName,MethodName);  
			waitForPageLoad(selenium);
	    	assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Goto home page				 
			//-------------------------------------------------------------------
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
			assertTrue(	click(selenium,lblcorresQFirst),"Could not click the record from Queue", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-4:Verify the count in Encounter LIst Above action button				 
			//-------------------------------------------------------------------
			assertTrue(	verifycountinList(selenium,userAccount,corresData),"Verification failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			
			
	
}
	catch(Exception e)
	{
	Assert.fail(e.getMessage());
	}
return true;
	}
public boolean verifycountinList(Selenium selenium,String userAccount, ChartPreVisitLib corresData) throws IOException
{
int beforCount=Splitfuction(selenium);
waitForPageLoad(selenium);	
assertTrue(click(selenium, btncorressign),"Could not sign Action button in  corres report page", selenium, ClassName,MethodName);
waitForPageLoad(selenium);
waitForPageLoad(selenium);
int afterCount=Splitfuction(selenium);
if(beforCount<afterCount)
{
	return true;
}
else
{
	
	
	assertTrue(false,"cout is not reduced after clicked next report in queue", selenium, ClassName, MethodName);	
}
return true;

}	

int Splitfuction(Selenium selenium)
{
	String countTemp=selenium.getText(lblWaitlist);
	String Spit[]=	countTemp.split(" ");
	String temP=Spit[2];
	temP=temP.replace("(", "");
	temP=temP.replace(")", "");
	int finalCount=Integer.parseInt(temP);
	
	return finalCount;
}


}
