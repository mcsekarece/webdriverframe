package com.nexia.selenium.testscripts.section.chartprevisit.OrderLabDiReferral;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStoredValueForEditDiOrder extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying stored values of the edited DI order")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editNewDiOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateDiganosticImaging";
		orderData.testCaseId = "TC_ODI_001";
		orderData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createDiOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
		/**
		 * createDiOrder
		 * function to verify stored value for edited diagnostic Imaging
		 * @param 		seleniumHost
		 * @param 		seleniumPort
		 * @param 		browser
		 * @param 		webSite
		 * @throws IOException 
		 * @since  	    Nov 29, 2012
		 */
		
		public boolean createDiOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{
			
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
				//---------------  Step-2:Change Switch Role  --------------//
				//--------------------------------------------------------------------//
				assertTrue(switchRole(selenium,orderData.switchRole),"", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-2: Advanced search with Patient ID//
				//--------------------------------------------------------------------//
				
				searchPatientNexiaForProviderHomePage(selenium,orderData.patientId);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-3: Delete Existing lab reports//
				//--------------------------------------------------------------------//
				assertTrue(deletelabReport(selenium,orderData),"Deletion Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			    assertTrue(deleteAllEncounters(selenium,orderData),"", selenium, ClassName, MethodName);
				//--------------------------------------------------------------------//
				//  Step-3: Begin Encounters//
				//--------------------------------------------------------------------//
				assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
				
				//--------------------------------------------------------------------//
				//  Step-4: Delete Existing Lab Orders//
				//--------------------------------------------------------------------//
				
				assertTrue(deleteOrders(selenium,orderData),"Deletion Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-4: Navigate to Diganostic Imaging Page//
				//--------------------------------------------------------------------//
				assertTrue(clickDiIcon(selenium,orderData),"Navigation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-5: Create Lab Order Page//
				//--------------------------------------------------------------------//
				
				assertTrue(orderNewDi(selenium,orderData),"Order Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-6: edit Created Lab Order Page//
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,lblDiOrderEditIcon),"Couldn't click on Lab order new icon", selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnEdit2),"Couldn't click on edit  Lab order link ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(selenium.isConfirmationPresent()){
				selenium.chooseOkOnNextConfirmation();
				}
				orderData.workSheetName = "CreateDiganosticImaging";
				orderData.testCaseId = "TC_ODI_002";
				orderData.fetchChartPreVisitTestData();
				
				assertTrue(orderNewDi(selenium,orderData),"Order Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(!verifyStoredValues(selenium,orderData)){
					Assert.fail("Contacts details not saved properly in summary section; More Details :"+ orderData.toString());
					returnValue=false;
				}
				else
					return returnValue;
			}catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
			return returnValue;
	}
		public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib orderData) throws IOException{
			//waitForPageLoad(selenium);
			
			System.out.println(orderData.labTestName);
	    	assertTrue(isTextPresent(selenium,orderData.labTestName),"verify Stored Values Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			/*if(!getText(selenium,lblLabTestName).toLowerCase(new java.util.Locale("en","US")).trim().contains(orderData.labTestName.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
			return true;
		}	
}
