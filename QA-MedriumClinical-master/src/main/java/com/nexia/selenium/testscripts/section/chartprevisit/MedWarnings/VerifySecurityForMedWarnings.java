package com.nexia.selenium.testscripts.section.chartprevisit.MedWarnings;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityForMedWarnings extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With Limitted Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "VerifySecurityOption";
		prescribeData.testCaseId = "TC_VSP_001";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With View Only User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationWithViewOnly(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "VerifySecurityOption";
		prescribeData.testCaseId = "TC_VSP_002";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "VerifySecurityOption";
		prescribeData.testCaseId = "TC_VSP_003";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationWithFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "VerifySecurityOption";
		prescribeData.testCaseId = "TC_VSP_004";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * verifySecurity
	 * function to verify Security
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 17, 2012
	 */

	public boolean verifySecurity(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Select Role//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,prescribeData.switchRole),"Could not change the switch role;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
							
			if(prescribeData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
				assertTrue(searchPatientNexiaNoAccess(selenium,prescribeData.patientId),"Could search patient", selenium, ClassName, MethodName);				
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Search Patient											  //
			//--------------------------------------------------------------------//
			
			if(!prescribeData.testCaseId.equals("TC_VSP_003")){
				  
				searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
				waitForPageLoad(selenium);							
					
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);			
			}	
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Security//
			//--------------------------------------------------------------------//

			assertTrue(verifySecurity(selenium,prescribeData,userAccount),"Security for" +prescribeData.switchRole+ "is not proper:"+ prescribeData.toString(), selenium, ClassName, MethodName);
							
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium, ChartPreVisitLib prescribeData,String account) throws IOException{
		boolean returnValue=true;
					
		//View Only User Role
		if(prescribeData.testCaseId.equals("TC_VSP_002")){
			assertTrue(isElementPresent(selenium,lnkPatientOption),"Could not find Patient options link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkPatientOption),"Could not click Patient options link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium,lnkPrescribeMedication),"Prescribe medication button is present", selenium, ClassName, MethodName);
		}else
			 returnValue=true;
		
		//Limited Access User Role
		if(prescribeData.testCaseId.equals("TC_VSP_001")){
			prescribeData.workSheetName = "PrescribeMedi";
			prescribeData.testCaseId = "TC_PM_017";
			prescribeData.fetchChartPreVisitTestData();
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,ajxProvider,prescribeData.provider);
			selectValueFromAjaxList(selenium,ajxLoaction,prescribeData.loaction);
			if(account.equals(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,prescribeData.prescribeCa),"Could not type Prescribe Medication;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				}else{
					assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,prescribeData.prescribe),"Could not type Prescribe Medication;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkEdit),"Could not click the Prescribe link;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
						
			if(!selenium.isVisible(btnOverride)){
			//if(isElementPresent(selenium,btnSave))	{
				return true;
			}else
				return false;
			}
			//assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
		
		//Full Access User Role
		if(prescribeData.testCaseId.equals("TC_VSP_004")){
			prescribeData.workSheetName = "PrescribeMedi";
			prescribeData.testCaseId = "TC_PM_017";
			prescribeData.fetchChartPreVisitTestData();
			
			// Delete Pending Medication
			
			deleteAllPendingMedication(selenium, prescribeData);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,ajxProvider,prescribeData.provider);
			selectValueFromAjaxList(selenium,ajxLoaction,prescribeData.loaction);
			if(account.equals(CAAccount)){
			assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,prescribeData.prescribeCa),"Could not type Prescribe Medication;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}else{
				assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,prescribeData.prescribe),"Could not type Prescribe Medication;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(click(selenium,lnkEdit),"Could not click the Prescribe link;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-6: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,account),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnAddToPending), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.isTextPresent("Go to Pending Medications"),"Go to pending medication is not present", selenium, ClassName, MethodName);
		}
		
		return returnValue;
	}
}
