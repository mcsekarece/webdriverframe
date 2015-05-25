package com.nexia.selenium.testscripts.section.chartprevisit.OrderLabDiReferral;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CancelDiOrder extends AbstractChartPreVisit{
	@Test(groups =  {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Cancel DI ordering Labs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewDiOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateDiganosticImaging";
		orderData.testCaseId = "TC_ODI_008";
		orderData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		cancelDiOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	/**
	 * cancelDiOrder
	 * function to cancelDiOrder
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Jun 10, 2014
	 */
	
	public boolean cancelDiOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{
		
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
			assertTrue(switchRole(selenium,orderData.switchRole), "could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,orderData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Encounter from Encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,orderData),"", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			if(isElementVisible(selenium,ajxProviderSugBox)){
				String str = getText(selenium, lnkTopMenu);
				String Rprovider = str.replaceAll(", " + orderData.switchRole, "");
				String tempArray[] = Rprovider.split(" ");
				String providerName = tempArray[1] + ", " + tempArray[0];

				assertTrue(selectValueFromAjaxList(selenium,ajxProviderSugBox,providerName),"ajx failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				}
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Lab Orders//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteOrders(selenium,orderData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Diganostic Imaging Page//
			//--------------------------------------------------------------------//
			assertTrue(selenium.isVisible(imgDiOrderIcon),"link is not visible", selenium, ClassName, MethodName);
			assertTrue(clickDiIcon(selenium,orderData),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-5: Create Lab Order Page//
			//--------------------------------------------------------------------//
			
			assertTrue(orderNewDi(selenium,orderData),"Order Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,"AllergiesTitle")){
				returnValue=true;
			}else
				returnValue=false;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
