package com.nexia.selenium.testscripts.section.chartprevisit.PatientHandOuts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPatientHandoutWithlabReport extends AbstractChartPreVisit {
	@Test(groups ={"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientorderDataWithLabReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_001";
		labData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyHandout(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientorderDataWithEmptyLabReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_002";
		labData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		

		verifyEmptyHandout(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for File New Report")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyViewHandoutsWithEmptyLabReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_024";
		labData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		

		verifyViewHandout(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	/**
	 * verifyHandout
	 * function to file new lab report
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 11, 2012
	 */
	public boolean verifyHandout(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{
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
			assertTrue(switchRole(selenium,orderData.switchRole), "could not switch the role" , selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,orderData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate to Begin Encounter", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate To Patient Handouts//
			//--------------------------------------------------------------------//
			
			int i=0;
			
			for(i=0;i<3;i++)
			{
			selenium.focus(elementPatienHandOutLink);
		    selenium.clickAt(elementPatienHandOutLink,"");
			}
		    
		    
			//assertTrue(click(selenium,elementPatienHandOutLink ), "Could not click on patient handouts link");
			//waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify Patient handouts for Lab Reports//
			//--------------------------------------------------------------------//
			int count=1,counter=0;
			while(isElementPresent(selenium,"xpath=(//a[contains(text(),'View Handout')])["+count+"]")){
				counter++;
				count++;
				if(count>100){
					break;
				}
			}
			//--------------------------------------------------------------------//
			//  Step-7:Navigation to File new lab report//
			//--------------------------------------------------------------------//
			
			assertTrue(navigateTofileReport(selenium,orderData),"Could not navigate to File New Report", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: File new lab report//
			//--------------------------------------------------------------------//
			
			assertTrue(fileReport(selenium,orderData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate to Encounter", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-10: Navigate To Patient Handouts//
			//--------------------------------------------------------------------//
			selenium.focus(elementPatienHandOutLink);
			
			assertTrue(click(selenium,elementPatienHandOutLink ), "Could not click on patient handouts link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11: verify Patient handouts for Lab Reports//
			//--------------------------------------------------------------------//
			int count1=1,counter1=0;
			while(isElementPresent(selenium,"xpath=(//a[contains(text(),'View Handout')])["+count1+"]")){
				counter1++;
				count1++;
				if(count1>100){
					break;
				}
			}
			
			if(counter1>counter){
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
	/**
	 * verifyEmptyHandout
	 * function to file new lab report
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 11, 2012
	 */
	public boolean verifyEmptyHandout(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{
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
			assertTrue(switchRole(selenium,orderData.switchRole), "could not switch the role" , selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Create Patient//
			//--------------------------------------------------------------------//
			HomeLib patientData = new HomeLib(); 
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_001";
			patientData.fetchHomeTestData();
			
			assertTrue(goToRegisterPatient(selenium), "Could not go to register patient", selenium, ClassName, MethodName);
			assertTrue(createNewPatientWithMandatory(selenium, patientData), "Could not create a new patient", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigation to File new lab report//
			//--------------------------------------------------------------------//
			
			assertTrue(navigateTofileReport(selenium,orderData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate To Patient Handouts//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,elementPatienHandOutLink ), "Could not click on patient handouts link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: verify Patient handouts for empty Lab Reports//
			//--------------------------------------------------------------------//
			if(!isTextPresent(selenium,"No Lab report list added")){
				returnValue=false;
			}
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/**
	 * verifyViewHandout
	 * function to verify View Handout
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Jan 02, 2012
	 */
	public boolean verifyViewHandout(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{
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
			assertTrue(switchRole(selenium,orderData.switchRole), "could not switch the role" , selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,orderData.patientId);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigation to File new lab report//
			//--------------------------------------------------------------------//
			
			assertTrue(navigateTofileReport(selenium,orderData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: File new lab report//
			//--------------------------------------------------------------------//
			
			assertTrue(fileReport(selenium,orderData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate To Patient Handouts//
			//--------------------------------------------------------------------//
			
			selenium.focus(elementPatienHandOutLink);
			selenium.clickAt(elementPatienHandOutLink,"");

		//	assertTrue(click(selenium,elementPatienHandOutLink ), "Could not click on patient handouts link");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: click on Patient Handout link //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,"xpath=(//a[contains(text(),'View Handout')])[2]"),"", selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			
			
			if(userAccount.equalsIgnoreCase(CAAccount)){
				if(isElementPresent(selenium,lnkPrint)){
					returnValue= true;
				}else
					returnValue= false;
			}
			else{
				returnValue= switchto(selenium);
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	private boolean switchto(Selenium selenium) {
		String st1[]=selenium.getAllWindowNames();
		waitForPageLoad(selenium);
		selenium.selectWindow(st1[1]);
		selenium.windowFocus();
		
		if(isElementPresent(selenium,lnkDurgs)){
			return true;
		}else
			return false;
		
	}
	
}
