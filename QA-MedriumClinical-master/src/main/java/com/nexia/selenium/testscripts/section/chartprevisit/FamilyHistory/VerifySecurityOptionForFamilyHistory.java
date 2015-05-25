package com.nexia.selenium.testscripts.section.chartprevisit.FamilyHistory;

import java.io.IOException;

import org.openqa.selenium.internal.seleniumemulation.IsVisible;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForFamilyHistory extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.testCaseId = "TC_VSP_004";
		historyData.workSheetName = "VerifySecurityOption";
		historyData.fetchChartPreVisitTestData();
		verifySecurityOptionForLimitedAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}

	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_002";
		historyData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_003";
		historyData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_004";
		historyData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 11, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + historyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,historyData.switchRole),"Could not change the switch role;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
							
			if(historyData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
				assertTrue(searchPatientNexiaNoAccess(selenium,historyData.patientId),"Could search patient", selenium, ClassName, MethodName);				
			}	
			
			//--------------------------------------------------------------------//
			//  Step-4: Visit the Family History Link							  //
			//--------------------------------------------------------------------//		
			
			if(!historyData.testCaseId.equals("TC_VSP_003")){
				  
				searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);	
				waitForPageLoad(selenium);					
				assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);	
				waitForPageLoad(selenium);							
					
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);			
			}		
		
				
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option 									  //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);				
			assertTrue(verifySecurity(selenium,historyData),"Text Not Present",selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);				
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib historyData) throws IOException{
			
		//ViewOnlyAccess
		if(historyData.testCaseId.equals("TC_VSP_002")){
					
			waitForPageLoad(selenium);
			if(selenium.isElementPresent(btnAdd)||selenium.isElementPresent(ajxFamilyMedical)){
				return false;
			}else
				return true;
		}		
		
		//Full Access
		if(historyData.testCaseId.equals("TC_VSP_004")){
			historyData.workSheetName = "CreateFamilyHistory";
			historyData.testCaseId = "TC_CFM_001";
			historyData.fetchChartPreVisitTestData();
			waitForPageLoad(selenium);
			assertTrue(deleteFamilyHistory(selenium,historyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createFamilyHistory(selenium,historyData),"Creation failed", selenium, ClassName, MethodName);
			if(isElementPresent(selenium,btnDelete)){
				return true;
			}else
				return false;
		}
		return true;
	}
	
	// Security Option for Limited Access
	public boolean verifySecurityOptionForLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
		Selenium selenium=null;

		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + historyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,historyData.switchRole),"Could not change the switch role;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			historyData.workSheetName = "CreateFamilyHistory";
			historyData.testCaseId = "TC_CFM_001";
			historyData.fetchChartPreVisitTestData();
			
			searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);	
			waitForPageLoad(selenium);					
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);							
				
			assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
		
			// Delete and Create the Family History
			
			assertTrue(deleteFamilyHistory(selenium,historyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createFamilyHistory(selenium,historyData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click the cancel button;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			
			// Limited Access 
			ChartPreVisitLib historyData1 = new ChartPreVisitLib();
			historyData1.workSheetName = "VerifySecurityOption";
			historyData1.testCaseId = "TC_VSP_001";
			historyData1.fetchChartPreVisitTestData();    
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(selenium.isConfirmationPresent()){
                System.out.println(selenium.getConfirmation());
                selenium.chooseOkOnNextConfirmation();
        }    	
			assertTrue(isElementPresent(selenium,lnkTopMenu),"Could not fine the link;More Details:"+historyData1.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkTopMenu),"Could not click the top Menu Header;More Details:"+historyData1.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"switchRoleAction"),"Could not click the switch role;More Details:"+historyData1.toString(), selenium, ClassName, MethodName);
		
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,ajxSwitchrole)){
				historyData1.switchRole="ALimitedAccess";
			selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[2]",historyData1.switchRole);
			selenium.click("//body/div[7]/div/div/div/div/div");
			}
			
			waitForPageLoad(selenium);
			click(selenium,txtdeleteReason);
			waitForPageLoad(selenium);
						
		
			selenium.type("searchPatientBox", historyData.patientId);

			selenium.clickAt("searchPatientBox","");
			selenium.focus("searchPatientBox");			
			selenium.fireEvent("searchPatientBox","keypress");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForElement(selenium,lblPatientResult,10000);
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-", selenium, ClassName, MethodName);
			click(selenium,lblPatientResult);
			waitForPageLoad(selenium);
	        if(isElementPresent(selenium, btnErrorClose))
                assertTrue(click(selenium, btnErrorClose)," ", selenium, ClassName, MethodName);
			if(isElementPresent(selenium,lnkPatientSelect)){
				assertTrue(click(selenium,lnkPatientSelect),"Could not click the ", selenium, ClassName, MethodName);
			}
			
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"", selenium, ClassName, MethodName);
			
			// Look for the Absence of Delete Button 
			assertTrue(!isElementVisible(selenium,btnDeleteAllergy),"Element is present",selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
		
}