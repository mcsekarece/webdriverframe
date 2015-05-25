package com.nexia.selenium.testscripts.section.chartprevisit.QuickList;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class EditProcedureQuickList  extends AbstractChartPreVisit{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the Edited procedure in quick list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditProcedureInQuickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib QuicklstData = new ChartPreVisitLib();
		QuicklstData.workSheetName = "CreateProcedure";
		QuicklstData.testCaseId = "TC_CP_002";
		QuicklstData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyEditQuickListProcedure(seleniumHost, seleniumPort, browser, webSite, userAccount, QuicklstData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        To verify Edited quick list procedure is displayed
	* @Specification  SRS_EMR_Med_Summary_Procedures_Rev0.0
	* @action 		  verifying Edited quick list procedure is displayed
	* @expected       After add the procedure, When click the quick list, It should shows the added procedure
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @testcaseid     TC_CP_002
	* @since  	      May 23, 2013
	***************************************************************************************************/
  public boolean verifyEditQuickListProcedure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib QuicklstData) throws Exception{
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
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Surgical history//
			//--------------------------------------------------------------------//
			//assertTrue(click(selenium,lnkSummary),"Could not click the chart summary;More Details");
			//waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkProcedure),"Could not click the procedure link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteProcedure(selenium,QuicklstData),"Could not delete the procedure",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(click(selenium,btnProcedureQuickList),"Could not click the QuickList button;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			while((Integer) selenium.getXpathCount("//div[starts-with(@id, 'currentItem')]")>0){
				assertTrue(click(selenium,lnkPrescribeDelete1),"Could not delete the QuickList value;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnProcedureQuickList),"Could not click the QuickList button;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Create procedure//
			//--------------------------------------------------------------------//
			assertTrue(createProcedureQuickList(selenium,QuicklstData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			

			//--------------------------------------------------------------------//
			//  Step-5: Edit Quick List View//
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtProcedureName,QuicklstData.proName),"Could not type procedure name",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkProcedureShowMore),"Could not on show more button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,txtcpt,QuicklstData.cptOne);
			waitForPageLoad(selenium);
			if(!isChecked(selenium,chkQuickList)){
				assertTrue(click(selenium,chkQuickList),"Could not click the Save Quick List check box;More Details:"+QuicklstData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,btnAdd),"Could not click the add button;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Edit Quick List View//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnProcedureQuickList),"Could not click the QuickList button;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblQuickValue1).toLowerCase(new java.util.Locale("en","US")).trim().contains(QuicklstData.proName.trim().toLowerCase(new java.util.Locale("en","US")))){
				assertTrue(click(selenium,lblQuickValue1),"Could not click the quicklist procedure;More Details"+QuicklstData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,lnkProcedureShowMore),"Could not on show more button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			

			if(getValue(selenium,txtcpt).toLowerCase(new java.util.Locale("en","US")).trim().contains(QuicklstData.cptOne.trim().toLowerCase(new java.util.Locale("en","US"))))
				returnValue = true;
			else
			       Assert.fail("The edit Values are not stored properly");	
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + QuicklstData.toString(),selenium,ClassName,MethodName);
		}
	  return returnValue;
	}
	
}
