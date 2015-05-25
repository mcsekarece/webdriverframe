package com.nexia.selenium.testscripts.section.chartprevisit.MedsQueue;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeleteMedicationCountInMedQueue extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying the count of medication in meds queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyShowOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_108";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDeleteCount(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	/**
	 * verifyDeleteCount
	 * Function to verify Delete Count of medication in meds queue
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Feb 08, 2012
	 */
	
	public boolean verifyDeleteCount(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
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
			
			//--------------------------------------------------------------------//
			//---------------  Step-3:Count Medication --------------//
			//--------------------------------------------------------------------//
			//Before deleting the count in Med Queue
			String resultList=getText(selenium,lnkRxRenewal);
			String[] splitS = resultList.split(" ");
			int metricResult1 = Integer.parseInt(splitS[0]);
			System.out.println(metricResult1);
			
			//--------------------------------------------------------------------//
			//---------------  Step-4:delete Medication --------------//
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescribeData.provider = pName;
			
			assertTrue(click(selenium,lnkRxRenewal),"Could not click the Rx renewals", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			selectValueFromAjaxList(selenium,ajxRxProvider,prescribeData.provider);
			waitForPageLoad(selenium);
		    waitForElement(selenium, lblRxqitem, WAIT_TIME*5);    
			if(isElementPresent(selenium, btnPendingAction)){
				assertTrue(click(selenium, btnPendingAction),"Could not click the Rx renewals", selenium, ClassName, MethodName);
			}else 
					assertTrue(click(selenium,lblRxqitem),"Could not click the Rx renewals", selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);			
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnDeleteBlue),"", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnDeleteBlue),"Could not click the delete button", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtDeleteReaseon,"reason"),"Could not type the reason", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnContinue),"Could not click the continue button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-5:Count Compersion --------------//
			//--------------------------------------------------------------------//
		//Click on Nexia logo
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				//After deleting the count in Med Queue
			String resultList1=getText(selenium,lnkRxRenewal);
			String[] splits = resultList1.split(" ");
			int metricResult = Integer.parseInt(splits[0]);
			
			//Compare Before & After Deleteing the count
			assertTrue(metricResult1>metricResult,"Metric resutls are not equal", selenium, ClassName, MethodName);
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			
		}
		return returnValue;
	}
}
