package com.nexia.selenium.testscripts.section.chartprevisit.QuickList;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchProcedureQuickList extends AbstractChartPreVisit{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the searched procedure in quick list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProcedureInQuickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib QuicklstData = new ChartPreVisitLib();
		QuicklstData.workSheetName = "CreateProcedure";
		QuicklstData.testCaseId = "TC_CP_016";
		QuicklstData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyQuickListProcedure(seleniumHost, seleniumPort, browser, webSite, userAccount, QuicklstData);
	}
	/*************************************************************************************************** 
	* @purpose        To verify searched quick list procedure is displayed
	* @Specification  SRS_EMR_Med_Summary_Procedures_Rev0.0
	* @action 		  verifying searched quick list procedure is displayed
	* @expected       After add the procedure, When click the quick list, It should shows the added procedure
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Apr 23, 2013
	***************************************************************************************************/
	
	public boolean verifyQuickListProcedure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib QuicklstData) throws IOException{
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
			//  Step-3: Navigate to Surgical history//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSummary),"Could not click the chart summary;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkProcedure),"Could not click the procedure link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteProcedure(selenium,QuicklstData),"Could not delete the procedure",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(click(selenium,"procedureQuickListButton"),"Could not click the QuickList button;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			while((Integer) selenium.getXpathCount("//body/div[4]/div/div/div/div/div")>0){
				assertTrue(click(selenium,lnkPrescribeDelete1),"Could not delete the QuickList value;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,"procedureQuickListButton"),"Could not click the QuickList button;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Create procedure with quick list feature//
			//--------------------------------------------------------------------//
			assertTrue(createProcedureQuickList(selenium,QuicklstData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Create procedure//
			//--------------------------------------------------------------------//
			ChartPreVisitLib QuicklstData1 = new ChartPreVisitLib();
			QuicklstData1.workSheetName = "CreateProcedure";
			QuicklstData1.testCaseId = "TC_CP_015";
			QuicklstData1.fetchChartPreVisitTestData();
			
			assertTrue(createProcedure(selenium,QuicklstData1,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify searched quick list procedure is displayed//
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtProcedureName,QuicklstData.proName),"Could not type procedure name",selenium,ClassName,MethodName);
			
			selenium.fireEvent(txtProcedureName,"keydown");
			selenium.fireEvent(txtProcedureName,"keypress");                           
			selenium.fireEvent(txtProcedureName,"keyup");
			selenium.keyPress(txtProcedureName, "\\13");
			waitForPageLoad(selenium);
			
			
			if(getText(selenium,"css=span.gwt-InlineLabel").toLowerCase(new java.util.Locale("en","US")).trim().contains(QuicklstData1.proName.trim().toLowerCase(new java.util.Locale("en","US"))) && (isElementPresent(selenium,"css=img.gwt-Image.marginRight5"))){
					
				if(getText(selenium,"//div[4]/div/div/div/div/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(QuicklstData.proName.trim().toLowerCase(new java.util.Locale("en","US")))){
					 if(!isElementPresent(selenium,"//div[4]/div/div/div/div/div[2]/div/img")){
						 return false;
					 }
				}
				 
			}
			
			assertTrue(click(selenium,"procedureQuickListButton"),"Could not click the QuickList button;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);

			
			if(getText(selenium,"css=span.gwt-InlineLabel").toLowerCase(new java.util.Locale("en","US")).trim().contains(QuicklstData.proName.trim().toLowerCase(new java.util.Locale("en","US")))){
				 if(isElementPresent(selenium,"css=img.gwt-Image.marginRight5")){
					 returnValue=true;
				 }
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + QuicklstData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
	

}
