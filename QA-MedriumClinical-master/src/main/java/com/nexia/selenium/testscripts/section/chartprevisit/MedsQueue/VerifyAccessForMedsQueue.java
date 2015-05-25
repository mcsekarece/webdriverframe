package com.nexia.selenium.testscripts.section.chartprevisit.MedsQueue;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAccessForMedsQueue extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying the show option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyShowOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_027";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying the hide option")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHideOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_002";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * verifyAccess
	 * Function to edit pending medication from meds queue
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 26, 2012
	 */
	public boolean verifyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,prescribeData.switchRole), "could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescribeData.provider = pName;
			
			if(prescribeData.testCaseId.equals("TC_PM_027")){
				assertTrue(click(selenium,lnkRxRenewal),"Could not click the Meds queue button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,show),"Could not find the meds queue show suggest box", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium,txtRxPatientSearch),"Could not find the meds queue for suggest box", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium,ajxRxProvider),"Could not find the meds queue search box", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajxRxShow,prescribeData.show);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxRxProvider,prescribeData.provider);
				waitForPageLoad(selenium);
				assertTrue(getValue(selenium,show).contains(prescribeData.show),"Could not get the value", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(getValue(selenium,ajxRxProvider).toLowerCase().contains(prescribeData.provider.toLowerCase()),"Could not get the value", selenium, ClassName, MethodName);
			}
			else if(prescribeData.testCaseId.equals("TC_PM_002")){
				assertTrue(click(selenium,lnkRxRenewal),"Could not click the Meds queue button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,hide),"Could not click the Hide button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(!isElementPresent(selenium,medsQueueFrame),"Can find the meds queue", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium,appointmentFor),"Could not find the Appointment For box", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium,day),"Could not find the day suggest box", selenium, ClassName, MethodName);
			}
		
		}catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
