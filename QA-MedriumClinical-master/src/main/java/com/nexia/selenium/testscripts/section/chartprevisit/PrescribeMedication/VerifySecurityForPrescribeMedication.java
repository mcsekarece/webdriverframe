package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityForPrescribeMedication extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrescribeMedicationWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "VerifySecurityOption";
		prescribeData.testCaseId = "TC_VSP_004";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOptionForLimitedAccess (seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With View Only User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrescribeMedicationWithViewOnly(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "VerifySecurityOption";
		prescribeData.testCaseId = "TC_VSP_002";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	 @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrescribeMedicationWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "VerifySecurityOption";
		prescribeData.testCaseId = "TC_VSP_003";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPrescribeMedicationWithFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
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
	 * @since  	    Oct 11, 2012
	 */

	public boolean verifySecurity(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData)throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ",selenium,ClassName,MethodName);;
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Select Role//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,prescribeData.switchRole),"Could not change the switch role;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
							
			if(prescribeData.testCaseId.equals("TC_VSP_003")){
				if(isElementPresent(selenium, btnErrorClose))
		   		assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);				
				assertTrue(!isElementPresent(selenium,lnkRxRenewal),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(searchPatientNexiaForNoAccess(selenium,prescribeData.patientId),"Could search patient", selenium, ClassName, MethodName);	
				assertTrue(!isElementPresent(selenium,lnkMedicationTab),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(	click(selenium,lnkPatientOption),"Could not click Patient Option ",selenium, ClassName, MethodName);
				assertTrue(!isElementPresent(selenium,lnkPrescribMedication),"Prescribe mediction link should not present ",selenium, ClassName, MethodName);
				
				
				
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
			//  Step-5: Verify Security											  //
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,prescribeData,userAccount)){
				Assert.fail("Security for" +prescribeData.switchRole+ "is not proper:"+ prescribeData.toString());
				returnValue=false;
			}else
				return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium, ChartPreVisitLib proData,String account)throws Exception{
		boolean returnValue=true;
			
		//View only access
		if(proData.testCaseId.equals("TC_VSP_002")){
			proData.workSheetName = "VerifySecurityOption";
			proData.testCaseId = "TC_VSP_004";
			proData.fetchChartPreVisitTestData();
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientOption),"Could not click the patient option link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(selenium.isElementPresent(lnkPrescribeMedication)){
				Assert.fail("Access definetions not Working Properly");
			}else
				 returnValue = true;
			assertTrue(click(selenium,lnkPatientOption),"Could not click the patient option link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(switchRole(selenium,proData.switchRole),"Could not change the switch role;More Details:"+proData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			waitForPageLoad(selenium);	
				
			ChartPreVisitLib probData = new ChartPreVisitLib();
			probData.workSheetName = "PrescribeMedi";
			probData.testCaseId = "TC_PM_001";
			probData.fetchChartPreVisitTestData();
			
			assertTrue(deleteAllPendingMedication(selenium, probData), "Pending medication deleteion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
		
			
		//	selectValueFromAjaxList(selenium,ajxProvider,probData.provider);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxLoaction,probData.loaction);
			if(account.equals(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,probData.prescribeCa),"Could not type Prescribe Medication;More Details:"+probData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}else{
				assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,probData.prescribe),"Could not type Prescribe Medication;More Details:"+probData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(click(selenium,lnkEdit),"Could not click the Prescribe link;More Deatils:"+probData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnCancelButton)){
				assertTrue(click(selenium,btnCancelButton),"Could not Click Proceed Anyway button"+probData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,probData.reason),"Could not type reason;More Details:"+probData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+probData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(addPrescribeMedication(selenium,probData,account),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);	
			
			
			assertTrue(click(selenium,btnAddToPending),"Could not click add to pending button"+probData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click Nexia Logo"+probData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			ChartPreVisitLib probData1= new ChartPreVisitLib();
			probData1.workSheetName = "VerifySecurityOption";
			probData1.testCaseId = "TC_VSP_002";
			probData1.fetchChartPreVisitTestData();
			assertTrue(switchRole(selenium,probData1.switchRole),"Could not change the switch role;More Details:"+proData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,proData.patientId),"Could not Select"+proData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientOptionsLink),"Could not Click"+proData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkPatientChartView)){
				assertTrue(click(selenium,lnkPatientChartView),"Could not Click"+proData.toString(),selenium,ClassName,MethodName);
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the Medication tab;More Deatils:"+proData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(focus(selenium,lnkOption1),"Could not focus"+proData.toString(), selenium, ClassName, MethodName);
			assertTrue(clickAt(selenium,lnkOption1, ""),"Could not do click at"+proData.toString(), selenium, ClassName, MethodName);
			
			assertTrue(!selenium.isElementPresent(lnkDelete),"Delete Button Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isElementPresent(lnkOptionEdit),"Edit Button Present",selenium, ClassName, MethodName);
		return true;
			
		}
			
		
		//Full Access
		if(proData.testCaseId.equals("TC_VSP_004")){
			waitForPageLoad(selenium);
			ChartPreVisitLib probData = new ChartPreVisitLib();
			probData.workSheetName = "PrescribeMedi";
			probData.testCaseId = "TC_PM_001";
			probData.fetchChartPreVisitTestData();			
		//	assertTrue(deleteAllPendingMedication(selenium, probData), "Pending medication deleteion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			
			assertTrue(SearchPrescribeMed(selenium,probData,account),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,probData.reason),"Could not type reason;More Details:"+probData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+probData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
				
			assertTrue(addPrescribeMedication(selenium,probData,account),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			if(!selenium.isElementPresent(btnPrint)){
				return false;
			}else
				return true;			
		}
		
		return returnValue;
	}
	
	// Limited Access 
	public boolean verifySecurityOptionForLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws IOException{
		Selenium selenium=null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + proData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, proData.userName, proData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,proData.switchRole),"Could not change the switch role;More Details:"+proData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
						
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			String patrintSerch=proData.patientId;
			waitForPageLoad(selenium);	
				
			ChartPreVisitLib probData = new ChartPreVisitLib();
			probData.workSheetName = "PrescribeMedi";
			probData.testCaseId = "TC_PM_004";
			probData.fetchChartPreVisitTestData();
			
			assertTrue(deleteAllPendingMedication(selenium, probData), "Pending medication deleteion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);			

			selectValueFromAjaxList(selenium,ajxProvider,probData.provider);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxLoaction,probData.loaction);
			if(userAccount.equals(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,probData.prescribeCa),"Could not type Prescribe Medication;More Details:"+probData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}else{
				assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,probData.prescribe),"Could not type Prescribe Medication;More Details:"+probData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(click(selenium,lnkEdit),"Could not click the Prescribe link;More Deatils:"+probData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			// Override with Reason
			
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,probData.reason),"Could not type reason;More Details:"+probData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+probData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			
			
			assertTrue(addPrescribeMedication(selenium,probData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);	
						
			assertTrue(click(selenium,btnAddToPending),"Could not click add to pending button"+probData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click back button"+probData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			// Limited Access Switch Role
			ChartPreVisitLib limitedData = new ChartPreVisitLib();
			limitedData.workSheetName = "VerifySecurityOption";
			limitedData.testCaseId = "TC_VSP_001";
			limitedData.fetchChartPreVisitTestData();
			
			
			assertTrue(switchRole(selenium,limitedData.switchRole),"Could not change the switch role;More Details:"+proData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	        
			searchPatientNexiaForProviderHomePage(selenium,patrintSerch);
			waitForPageLoad(selenium);
			
			//assertTrue(click(selenium,lnkMore),"Could not medication tab", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the Medication tab;More Deatils:"+proData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Check for the Absence of Delete and Presence of Edit for the Limited Access
			assertTrue(click(selenium,lnkOption1),"Could not click the action link",selenium,ClassName,MethodName);			
			
			assertTrue(!selenium.isElementPresent(lnkDelete),"Delete Button Present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Edit"),"Edit Button is not Present",selenium, ClassName, MethodName);
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
}