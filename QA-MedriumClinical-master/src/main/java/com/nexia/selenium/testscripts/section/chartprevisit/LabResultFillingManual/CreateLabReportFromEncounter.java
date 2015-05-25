package com.nexia.selenium.testscripts.section.chartprevisit.LabResultFillingManual;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CreateLabReportFromEncounter extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for ordering Labs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewLabOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateLabOrder";
		orderData.testCaseId = "TC_OL_006";
		orderData.fetchChartPreVisitTestData();
		createLabOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	/**
	 * createLabOrder
	 * function to create order for labs
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws     IOException 
	 * @since  	    Nov 15, 2012
	 */
	
	public boolean createLabOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + orderData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, orderData.userName, orderData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,orderData.patientId);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3: Sign Existing Lab reports//
			//--------------------------------------------------------------------//
			assertTrue(navigateTofileReport(selenium,orderData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			int count=1,counter=0,countInitial=0,countFinal=0;
			countInitial=(Integer) selenium.getXpathCount(labCountXpath);
		
			//--------------------------------------------------------------------//
			//  Step-3: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Lab Orders//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteOrders(selenium,orderData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Lab Order Page//
			//--------------------------------------------------------------------//
			selenium.focus(elementLabOrderLink);
			selenium.clickAt(elementLabOrderLink, "");
			
			//assertTrue(click(selenium,elementLabOrderLink),"Could not click on lab order link");
			//waitForPageLoad(selenium);
			
			assertTrue(orderNewLabs(selenium,orderData),"Order Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSign),"Could not click the sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Verify Created Lab Order on File Lab Report Page//
			//--------------------------------------------------------------------//
			assertTrue(navigateTofileReport(selenium,orderData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			int count1=1,counter1=0;
			countFinal=(Integer) selenium.getXpathCount(labCountXpath);
			
			if(countFinal>countInitial){
				return returnValue;
			}
			else 
				returnValue=false;
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkEnterData),"Could not enter", selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,elementCdate,"01/13/2013"),"Could not enter the collrction Date;More Details:"+orderData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium, elementCtime, "11:56"), "Could not type time", selenium, ClassName, MethodName);
			assertTrue(type(selenium,elementResult, "3"), "Could not type results", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSign),"Could not find sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			int count12=1,counter12=0;
			while(isElementPresent(selenium,"//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr[2]/td[2]/div[2]/div[5]/table/tbody/tr[2]/td[2]/div/div/div[2]/div/div/div[2]/table/tbody/tr["+count12+"]/td[2]/div/a")){
				counter12++;
				count12++;
				if(count12>15){
					break;
				}
			}
			
			if(counter12<counter1){
				return returnValue;
			}
			else 
				returnValue=false;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
