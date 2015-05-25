package com.nexia.selenium.testscripts.section.clinicalLists.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOption extends AbstractClinicalList{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib caseData = new ClinicalListLib();
		caseData.workSheetName = "VerifySecurityOption";
		caseData.testCaseId = "TC_VSP_001";
		caseData.fetchClinicalListTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}

	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib caseData = new ClinicalListLib();
		caseData.workSheetName = "VerifySecurityOption";
		caseData.testCaseId = "TC_VSP_004";
		caseData.fetchClinicalListTestData();
		verifySecurityOptionForViewOnly(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib caseData = new ClinicalListLib();
		caseData.workSheetName = "VerifySecurityOption";
		caseData.testCaseId = "TC_VSP_003";
		caseData.fetchClinicalListTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib caseData = new ClinicalListLib();
		caseData.workSheetName = "VerifySecurityOption";
		caseData.testCaseId = "TC_VSP_004";
		caseData.fetchClinicalListTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}
	
	/*
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccessPermission(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib caseData = new ClinicalListLib();
		caseData.workSheetName = "VerifySecurityOption";
		caseData.testCaseId = "TC_VSP_005";
		caseData.fetchClinicalListTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	}*/
	
	/**
	 * verifySecurityOption
	 * function to verifySecurityOption
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Dec 17, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib caseData) throws IOException{
		boolean returnValue=true;
		Selenium selenium=null;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + caseData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, caseData.userName, caseData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,caseData.switchRole),"Could not change the switch role;More Details:"+caseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose)){
            	assertTrue(click(selenium,btnErrorClose),"Could not click on the link", selenium, ClassName, MethodName);
                	
            }
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Clinical Lists//
			//--------------------------------------------------------------------//
			
				assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
				
			if(caseData.testCaseId.equals("TC_VSP_003")){
				assertTrue(!isElementPresent(selenium,lnkClinicalLists),"No access user role improper", selenium, ClassName, MethodName);

			/*	if(isElementPresent(selenium,lnkClinicalLists)){
					fail("No access user role improper");
				}*/
				assertTrue(selenium.isTextPresent("No Permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
				return true;
			}
			
			if(!caseData.testCaseId.equals("TC_VSP_005"))
			assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify security option//
			//--------------------------------------------------------------------//
			assertTrue(verifySecurityAccess(selenium,caseData),"Security option not show properly; More Details :"+ caseData.toString(),selenium, ClassName, MethodName);

		/*	if(!verifySecurityAccess(selenium,caseData)){
				Assert.fail("Security option not show properly; More Details :"+ caseData.toString());
				return false;
			}else
				return true;*/
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySecurityAccess(Selenium selenium,ClinicalListLib caseData) throws IOException{
		//Lmited Access
		int possition = 1;
		boolean returnValue=true;
		if(caseData.testCaseId.equals("TC_VSP_001")){
			caseData.workSheetName = "verifySearchForSex";
			caseData.testCaseId = "TC_VSS_001";
			caseData.fetchClinicalListTestData();
			//assertTrue(click(selenium,"!advancedPatientSearchMain"),"Could not click the clinical patient List link;More Details");
			//waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkCustomListTab),"Could not click on custom list tab ;More Details", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnNewSearch),"Could not click on new search button ;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				assertTrue(click(selenium,btnAddNew),"Could not click on Add New button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(runSearchQueryForSex(selenium,caseData,"MatchAll",possition),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click on Save button button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(type(selenium,txtClinicalListSave,caseData.searchName+uniqueName),"Could not enter the comments;More Details:"+caseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveBtn),"Could not click on Save button button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnDelete)){
				returnValue=false;
			}else
				return returnValue;
		}
		/*if(caseData.testCaseId.equals("TC_VSP_005")){
			if(isElementPresent(selenium,btnErrorClose)){
				click(selenium,btnErrorClose);
			}
		}*/
		
		
		if(caseData.testCaseId.equals("TC_VSP_004")){
			caseData.workSheetName = "verifySearchForSex";
			caseData.testCaseId = "TC_VSS_001";
			caseData.fetchClinicalListTestData();
			
			assertTrue(click(selenium,lnkCustomListTab),"Could not click on custom list tab ;More Details", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnNewSearch),"Could not click on new search button ;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				assertTrue(click(selenium,btnAddNew),"Could not click on Add New button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(runSearchQueryForSex(selenium,caseData,"MatchAll",possition),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click on Save button button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(type(selenium,txtClinicalListSave,caseData.searchName+uniqueName),"Could not enter the comments;More Details:"+caseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveBtn),"Could not click on Save button button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnDelete)){
				return returnValue;
			}else
				returnValue=false;
		}
		return returnValue;
	}
	
public boolean verifySecurityOptionForViewOnly(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib caseData) throws IOException{
		
	boolean returnValue=true;
	Selenium selenium=null;
	int possition = 1;
	try{
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + caseData.toString());
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, caseData.userName, caseData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		
		
		//--------------------------------------------------------------------//
		//  Step-2: change the switch role //
		//--------------------------------------------------------------------//
		assertTrue(switchRole(selenium,caseData.switchRole),"Could not change the switch role;More Details:"+caseData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		//--------------------------------------------------------------------//
		//  Step-2: Navigate to Clinical Lists//
		//--------------------------------------------------------------------//
		
			assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
		
		assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
		assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
		
		caseData.workSheetName = "verifySearchForSex";
		caseData.testCaseId = "TC_VSS_004";
		caseData.fetchClinicalListTestData();
		//assertTrue(click(selenium,"!advancedPatientSearchMain"),"Could not click the clinical patient List link;More Details");
		//waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkCustomListTab),"Could not click on custom list tab ;More Details", selenium, ClassName, MethodName);
		assertTrue(click(selenium,btnNewSearch),"Could not click on new search button ;More Details", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddNew),"Could not click on Add New button;More Details", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(runSearchQueryForSex(selenium,caseData,"MatchAll",possition),"Creation failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnSave),"Could not click on Save button button;More Details", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String uniqueName=DateFormat.format(cal.getTime());
		assertTrue(type(selenium,txtClinicalListSave,caseData.searchName+uniqueName),"Could not enter the comments;More Details:"+caseData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,btnSaveBtn),"Could not click on Save button button;More Details", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		caseData.workSheetName = "VerifySecurityOption";
		caseData.testCaseId = "TC_VSP_002";
		caseData.fetchClinicalListTestData();
		
		assertTrue(switchRole(selenium,caseData.switchRole),"Could not change the switch role;More Details:"+caseData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
		
		assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkCustomListTab),"Could not click on custom list tab ;More Details", selenium, ClassName, MethodName);
		
		if(isElementPresent(selenium,btnEditLink))
			returnValue=false;
		else
			return returnValue;
		
		if(isElementVisible(selenium,btnNewSearch))
			returnValue=false;
		else
			return returnValue;
		 
		/*assertTrue(click(selenium,lnkSearch),"Could not click on Search button button;More Details", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(!selenium.isEditable(chkContact), "Able to click CheckBox", selenium, ClassName, MethodName);*/
	}
	catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
	}
	return returnValue;
	}
}
