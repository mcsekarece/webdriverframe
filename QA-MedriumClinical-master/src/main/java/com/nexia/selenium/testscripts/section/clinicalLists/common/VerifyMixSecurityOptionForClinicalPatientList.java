package com.nexia.selenium.testscripts.section.clinicalLists.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForClinicalPatientList extends AbstractClinicalList {
    @Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Mixed security role")
	@Parameters({"seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
	ClinicalListLib caseData = new ClinicalListLib();
	caseData.workSheetName = "VerifySecurityOption";
	caseData.testCaseId = "TC_VSP_006";
	
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	caseData.fetchClinicalListTestData();
		
	verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	
	}
	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		IOException 
	 * @since  	   	Nov 11, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib cdsData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + cdsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, cdsData.userName, cdsData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,cdsData.switchRole),"Could not change the switch role;More Details:"+cdsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									  //
			//--------------------------------------------------------------------//
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_022";
			userRoleData.fetchSystemSettingTestData();
			
			if(userRoleData.clinicalLists.contains("No Access")){				
			    assertTrue(noAccessUserClinicalList(selenium, cdsData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);				
			}			
			
			//--------------------------------------------------------------------//
			//  Step-4: Full, View Access User Role 									  //
			//--------------------------------------------------------------------//
			
			if(!userRoleData.clinicalLists.contains("No Access")){
			    assertTrue(fullViewAccessUserClinicalList(selenium, cdsData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);;				
			    
			    if(!verifySecurity(selenium,cdsData, userRoleData, userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ cdsData.toString());
				returnValue= false;
			    }else
				returnValue=true;
			}			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySecurity(Selenium selenium,ClinicalListLib cdsData,SystemSettingsLib userRoleData, String userAccount) throws IOException{
		boolean returnValue=true;
		
		//Full Access Permission	
		if(userRoleData.clinicalLists.contains("Full Access")){
		    	ClinicalListLib caseData = new ClinicalListLib();
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
	
		//View Only Access Permission
		if(userRoleData.clinicalLists.contains("View Only")){
		    	assertTrue(switchRole(selenium,"DFFullAccess"),"Could not change the switch role;More Details:"+cdsData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Clinical Lists//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			
			ClinicalListLib caseData = new ClinicalListLib();
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
			
			assertTrue(switchRole(selenium,cdsData.switchRole),"Could not change the switch role;More Details:"+caseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkClinicalLists),"Could not click on Clinical list link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkCustomListTab),"Could not click on custom list tab ;More Details", selenium, ClassName, MethodName);
			assertTrue(!isElementPresent(selenium,btnEdit),"Edit is present", selenium, ClassName, MethodName);
			assertTrue(!isElementPresent(selenium,btnNewSearch),"New Search is present", selenium, ClassName, MethodName);

		/*	if(isElementPresent(selenium,btnEdit))
				returnValue=false;
			else
				return returnValue;
			
			if(isElementPresent(selenium,btnNewSearch))
				returnValue=false;
			else
				return returnValue;*/
			 
			assertTrue(click(selenium,lnkSearch),"Could not click on Search button button;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,chkContact)){
				assertTrue(click(selenium,chkContact), "Click didnt happen", selenium, ClassName, MethodName);
				Assert.fail("ABle to click on contact check box");
			}
		    	  
		}
		 
		//Limited Access Permission
		if(userRoleData.clinicalLists.contains("Limited Access")){
		    	ClinicalListLib caseData = new ClinicalListLib();
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
			assertTrue(!isElementPresent(selenium,btnDelete),"Present", selenium, ClassName, MethodName);
				
		}
		
		//No Access Permission
		if(userRoleData.clinicalLists.contains("No Access")){
		    assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClinicalLists), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"!automatedRecallList"), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!getText(selenium,lblHeader).contains("Custom Lists"),"Is present", selenium, ClassName, MethodName);
			    
		}
		return returnValue;
	}

}
