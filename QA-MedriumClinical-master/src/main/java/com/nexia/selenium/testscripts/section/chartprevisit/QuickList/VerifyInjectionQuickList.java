package com.nexia.selenium.testscripts.section.chartprevisit.QuickList;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyInjectionQuickList extends AbstractChartPreVisit{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the added injection in quick list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyInjectionInQuickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib QuicklstData = new ChartPreVisitLib();
		QuicklstData.workSheetName = "CreateInjection";
		QuicklstData.testCaseId = "TC_CI_009";
		QuicklstData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyQuickListInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, QuicklstData);
	}
	/*************************************************************************************************** 
	* @purpose        To verify added quick list injection is displayed
	* @Specification  SRS_EMR_Med_Summary_Injections_Rev0.0
	* @action 		  verifying added quick list injection is displayed
	* @expected       After add the injection, When click the quick list, It should shows the added injection
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both
	* @testcaseid     TAC_QL_003
	* @since  	      March 20, 2013
	***************************************************************************************************/
	
	public boolean verifyQuickListInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib QuicklstData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + QuicklstData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, QuicklstData.userName, QuicklstData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
						
			searchPatientNexiaForProviderHomePage(selenium,QuicklstData.patientId);
			waitForPageLoad(selenium);
			
			System.out.println(MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Injection//
			//--------------------------------------------------------------------//
			//assertTrue(click(selenium,lnkSummary),"Could not click the chart summary;More Details");
			//waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkInjection),"Could not click the Injection link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteInjection(selenium),"Delete Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(click(selenium,"css=button.quick-list-button.gradient"),"Could not click the QuickList button;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);

			while((Integer) selenium.getXpathCount("//div[starts-with(@id, 'currentItem')]")>0){
				assertTrue(click(selenium,lnkPrescribeDelete1),"Could not delete the QuickList value;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnProcedureQuickList),"Could not click the QuickList button;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Create Injection//
			//--------------------------------------------------------------------//
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ QuicklstData.switchRole , "");
			
			assertTrue(createInjection(selenium,QuicklstData,userAccount,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Save Injection to Quick List//
			//--------------------------------------------------------------------//
			
			assertTrue(verifyQuickListViewForInjection(selenium,QuicklstData,userAccount),"Verify QuickListView Failed",selenium,ClassName,MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + QuicklstData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
	

}
