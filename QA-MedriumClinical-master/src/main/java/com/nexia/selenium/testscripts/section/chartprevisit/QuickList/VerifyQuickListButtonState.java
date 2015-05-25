package com.nexia.selenium.testscripts.section.chartprevisit.QuickList;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyQuickListButtonState extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify quick list button status after selecting quick list")
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
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify quick list button status after selecting quick list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyInjectionInQuickListInOffMode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib QuicklstData = new ChartPreVisitLib();
		QuicklstData.workSheetName = "CreateInjection";
		QuicklstData.testCaseId = "TC_CI_011";
		QuicklstData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyQuickListInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, QuicklstData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify quick list button status after selecting quick list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyQuickListDefaultState(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib QuicklstData = new ChartPreVisitLib();
		QuicklstData.workSheetName = "CreateInjection";
		QuicklstData.testCaseId = "TC_CI_013";
		QuicklstData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyQuickListInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, QuicklstData);
	}

	
	/*************************************************************************************************** 
	* @purpose        To verify quick list button status after selecting quick list
	* @action 		  verifying quick list button status after selecting quick list
	* @expected       After selecting the created quick list medication, the state of the quick list will be changed to off
	*@defect          #3535
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      April 05, 2013
	***************************************************************************************************/
	
	public boolean verifyQuickListInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib QuicklstData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=false;
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
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Injection//
			//--------------------------------------------------------------------//
			//assertTrue(click(selenium,lnkSummary),"Could not click the chart summary;More Details");
			//waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkInjection),"Could not click the Injection link;More Details",selenium,ClassName,MethodName);
		    waitForPageLoad(selenium);
			
			if(QuicklstData.testCaseId.equals("TC_CI_013")){
				String buttonState=selenium.getAttribute(quickButtonAttribute);				
				assertTrue( buttonState.equalsIgnoreCase("quick-list-button gradient"),
						"Default state is incorrect", selenium, ClassName, MethodName);				
			}
			

//			assertTrue(deleteInjection(selenium),"Delete Failed",selenium,ClassName,MethodName);
//			waitForPageLoad(selenium);
			
			
//			assertTrue(click(selenium,btnInjection),"Could not click the QuickList button;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);

			while((Integer) selenium.getXpathCount("//*[contains(@id,'currentItem_')]")>0){	
				assertTrue(click(selenium,lnkPrescribeDelete1),"Could not delete the QuickList value;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				//assertTrue(click(selenium,btnInjection),"Could not click the QuickList button;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);
				//waitForPageLoad(selenium);
				assertTrue(type(selenium, txtdeleteReason, "reason"),
						"Could not type reason for deletion",selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnDeleteReason),
						"Could not click Delete button;More Details:",selenium, ClassName, MethodName);				
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
			//  Step-5: Verify state of the Quick List//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnInjection1),"Could not click the QuickList button;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);

			if(QuicklstData.testCaseId.equals("TC_CI_011")){
				if(getText(selenium,"css=span.gwt-InlineLabel").toLowerCase(new java.util.Locale("en","US")).trim().contains(QuicklstData.injection.trim().toLowerCase(new java.util.Locale("en","US")))){
					assertTrue(click(selenium,lnkPrescribeDelete),"Could not delete the QuickList value;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
				}
				
				String buttonState=selenium.getAttribute(quickButtonAttribute);
				if(buttonState.equalsIgnoreCase("quick-list-button gradient")){
					return returnValue;
				}
			} else if(QuicklstData.testCaseId.equals("TC_CI_009")){
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"Could not click close button",selenium,ClassName,MethodName);
			if(!getText(selenium,"css=span.gwt-InlineLabel").toLowerCase(new java.util.Locale("en","US")).trim().contains(QuicklstData.injection.trim().toLowerCase(new java.util.Locale("en","US")))){
				return true;
			}else {
				assertTrue(false,"Verify injection in quick list failed",selenium,ClassName,MethodName);
			}
			}
			String buttonState=selenium.getAttribute(quickButtonAttribute);
			if(buttonState.equalsIgnoreCase("quick-list-button gradient")){
				returnValue= true;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + QuicklstData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}

}
