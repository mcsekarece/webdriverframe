package com.nexia.selenium.testscripts.section.chartprevisit.OrderLabDiReferral;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestsForLabOrder extends AbstractChartPreVisit {
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "lab Test with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void labTestWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest orderData = new ChartPreVisitLibUnitTest();
		orderData.workSheetName = "UnitTestLabOrder";
		orderData.testCaseId = "TC_ULO_001";
		orderData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createLabOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "lab Test with Invalid Characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void labTestWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest orderData = new ChartPreVisitLibUnitTest();
		orderData.workSheetName = "UnitTestLabOrder";
		orderData.testCaseId = "TC_ULO_002";
		orderData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createLabOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	@Test(groups ={"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Coments With Max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void commentsWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest orderData = new ChartPreVisitLibUnitTest();
		orderData.workSheetName = "UnitTestLabOrder";
		orderData.testCaseId = "TC_ULO_003";
		orderData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createLabOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "SendTo with invalid values")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void sendToWithInvalidValues(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLibUnitTest orderData = new ChartPreVisitLibUnitTest();
		orderData.workSheetName = "UnitTestLabOrder";
		orderData.testCaseId = "TC_ULO_004";
		orderData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createLabOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	
	/**
	 * createLabOrder
	 * function to create order for labs
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 15, 2012
	 */
	
	public boolean createLabOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLibUnitTest orderData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		String data;
		int count,count1;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + orderData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, orderData.userName, orderData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,orderData.switchRole), "could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,orderData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Lab Order Page//
			//--------------------------------------------------------------------//
			int i=0;
			waitForPageLoad(selenium);
			selenium.focus(imgLabOrderIcon);
			selenium.clickAt(imgLabOrderIcon, "");
			//assertTrue(click(selenium,"//img[@title='Order New Labs']"),"Could not click on lab order link");
			waitForPageLoad(selenium);
			
			while(isElementPresent(selenium,imgLabOrderIcon)){
				
				click(selenium,imgLabOrderIcon);
				if(isElementPresent(selenium,btnDiagnosticSave)){
					return true;
				}
				else
					i++;
				if(i>10){
					break;
				}
				
			}		
			
			
			//assertTrue(click(selenium,"//img[@title='Order New Labs']"),"Could not click on lab order link");
			//waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Field Validation //
			//--------------------------------------------------------------------//
			if(orderData.maxLength.equals("")){
				assertTrue(unitTestLabOrders(selenium, orderData),"", selenium, ClassName, MethodName);
				orderData.validationFieldID = orderData.validationFieldID == null ? orderData.validationFieldID = "" : orderData.validationFieldID.trim();
				if(!orderData.validationFieldID.equals("")){
					waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium, orderData.validationFieldID), "The validation message field did not appear", selenium, ClassName, MethodName);
				assertTrue(getText(selenium, orderData.validationFieldID).contains(orderData.validationMessage), "The expected validation message should contain the text - "+ orderData.validationMessage + " The actual validation message shown - " + getText(selenium, orderData.validationFieldID), selenium, ClassName, MethodName);
				returnValue=true;
				}
			}else{
				if(orderData.test.contains("MaxLength")){
					assertTrue(labOrderUnitTestForMaxLength(selenium,orderData),"", selenium, ClassName, MethodName);
					data=getValue(selenium,orderData.validationFieldID);
					count=data.length();
					waitForPageLoad(selenium);
					count1=Integer.parseInt(orderData.maxLength);
					waitForPageLoad(selenium);
					if(count>count1)
						returnValue=false;
					else if(count==count1)
						returnValue=true;
					waitForPageLoad(selenium);
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/**
	 * medicationUnitTestForMaxLength
	 * function to medication Unit Test For MaxLength
	 * @throws IOException 
	 * @since  	    Oct 11, 2012
	 */	
	public boolean labOrderUnitTestForMaxLength(Selenium selenium,ChartPreVisitLibUnitTest orderData) throws IOException{
		try{
			selectValueFromAjaxList(selenium, ajxTestName,orderData.labTestName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtLabComments, orderData.labTestComments1), "Could not type comments", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxLabFacility,orderData.sendTo);
			assertTrue(click(selenium,btnNewSave), "Could not click on save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return true;
	}
}




