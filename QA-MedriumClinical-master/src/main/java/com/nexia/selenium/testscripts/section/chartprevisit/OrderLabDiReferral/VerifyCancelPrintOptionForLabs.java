package com.nexia.selenium.testscripts.section.chartprevisit.OrderLabDiReferral;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCancelPrintOptionForLabs extends AbstractChartPreVisit {
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verfing Cancel Print option for Labs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySignForLabOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateLabOrder";
		orderData.testCaseId = "TC_OL_005";
		orderData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySignForLab(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verfing Cancel Print option for Labs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySignForLabOrderForGeneralForm(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateLabOrder";
		orderData.testCaseId = "TC_OL_015";
		orderData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySignForLab(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	
	/**
		 * verifySignForLab 
		 * function to verify Sign For Lab
		 * @param 		seleniumHost
		 * @param 		seleniumPort
		 * @param 		browser
		 * @param 		webSite
		 * @throws IOException 
		 * @since  	    Nov 16, 2012
		 */
		
		public boolean verifySignForLab(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{
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
				//  Step-3: Delete Encounter from Encounter tab//
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				//--------------------------------------------------------------------//
				//  Step-3: Begin Encounters//
				//--------------------------------------------------------------------//
				assertTrue(goToBeginEncounter(selenium),"Could not go to begin Encounter", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				//--------------------------------------------------------------------//
				//  Step-4: Delete Existing Lab Orders//
				//--------------------------------------------------------------------//
				assertTrue(deleteOrders(selenium,orderData),"Deletion Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-4: Navigate to Lab Order Page//
				//--------------------------------------------------------------------//
				assertTrue(clickLabIcon(selenium,orderData),"Navigation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-5: Create Lab Order Page//
				//--------------------------------------------------------------------//
				assertTrue(orderNewLabs(selenium,orderData),"Order Failed", selenium, ClassName, MethodName);
				
				if(!orderData.testCaseId.equals("TC_OL_015")){
					assertTrue(click(selenium,btnCancelButton1),"Could not click on cancel lab order button", selenium, ClassName, MethodName);
					if(!getText(selenium,lblLabTestName).toLowerCase(new java.util.Locale("en","US")).trim().contains(orderData.labTestName.trim().toLowerCase(new java.util.Locale("en","US")))){
						returnValue=false;
					}
					if(!getText(selenium,lblLabTestName).toLowerCase(new java.util.Locale("en","US")).trim().contains(orderData.sendTo.trim().toLowerCase(new java.util.Locale("en","US")))){
						returnValue=false;
					}
				}
				else{
					if(!isElementPresent(selenium,btnPrintLab)){
						return false;
					}
				}
			}
			catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
			return returnValue;
	}
}


