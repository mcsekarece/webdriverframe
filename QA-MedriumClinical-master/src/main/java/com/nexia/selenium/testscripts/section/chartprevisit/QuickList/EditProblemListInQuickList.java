package com.nexia.selenium.testscripts.section.chartprevisit.QuickList;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class EditProblemListInQuickList extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_QL_001";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		quickListCheck(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	/*************************************************************************************************** 
	* @purpose        To verify added quick list problem list is displayed
	* @Specification  SRS_EMR_Med_Summary_Procedures_Rev0.0
	* @action 		  verifying added quick list problem list is displayed
	* @expected       After add the problem list, When click the quick list, It should shows the added problem list
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both
	* @defect         ##7649
	* @since  	      March 19, 2013
	***************************************************************************************************/
	public boolean quickListCheck(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + proData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, proData.userName, proData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete All existing Problem List//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkProblemList),"Could not click the Immunization link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllProblemList(selenium, proData),"Delete problem list failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"medicalConditionQuickListButton"),"Could not click the QuickList button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			while((Integer) selenium.getXpathCount("//body/div[4]/div/div/div/div/div")>0){
				//a[contains(text(),'Delete')]
				assertTrue(click(selenium,"xpath=(//a[contains(text(),'Delete')])[2]"),"Could not delete the QuickList value;More details:"+proData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,"medicalConditionQuickListButton"),"Could not click the QuickList button;More details:"+proData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,"medicalConditionQuickListButton"),"Could not click the QuickList button;More details:"+proData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Add Procedure//
			//--------------------------------------------------------------------//
			assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
             
			//--------------------------------------------------------------------//
			//  Step-6:  search different Patient   //
			//--------------------------------------------------------------------//
			ChartPreVisitLib proData1 = new ChartPreVisitLib();
			proData1.workSheetName = "CreateProblemList";
			proData1.testCaseId = "TC_QL_006";
			proData1.fetchChartPreVisitTestData();
			
			searchPatientNexiaForProviderHomePage(selenium,proData1.patientId);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkProblemList),"Could not click the Immunization link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyQuickListViewForProblemList(selenium,proData,userAccount),"Verify QuickListView Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
								
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + proData.toString());
		}
		return returnValue;
	}
}
