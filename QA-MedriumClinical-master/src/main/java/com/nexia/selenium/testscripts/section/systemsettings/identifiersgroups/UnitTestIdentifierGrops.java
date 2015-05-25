package com.nexia.selenium.testscripts.section.systemsettings.identifiersgroups;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestIdentifierGrops extends AbstractSystemSettingsTest {
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Group With Max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyGroupWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest idGroupData= new SystemsSettingsUnitTest();
		idGroupData.workSheetName = "UnitTest_SS_IdGroups";
		idGroupData.testCaseId = "TC_SS_IDG_001";
		idGroupData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addIdentifierGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, idGroupData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Description With Max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDescriptionWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest idGroupData= new SystemsSettingsUnitTest();
		idGroupData.workSheetName = "UnitTest_SS_IdGroups";
		idGroupData.testCaseId = "TC_SS_IDG_002";
		idGroupData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addIdentifierGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, idGroupData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Group With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyGroupWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest idGroupData= new SystemsSettingsUnitTest();
		idGroupData.workSheetName = "UnitTest_SS_IdGroups";
		idGroupData.testCaseId = "TC_SS_IDG_003";
		idGroupData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addIdentifierGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, idGroupData);
	}
	/**
	 * addIdentifierGroup
	 * function to add Identifier Groups
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	     May 21, 2012
	 */
	public boolean addIdentifierGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemsSettingsUnitTest idGroupData) throws IOException{
	    Selenium selenium = null;
		String alertText="";
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			// Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + idGroupData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, idGroupData.userName, idGroupData.userPassword);
			waitForPageLoad(selenium);
			
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,idGroupData.switchRole),"Switch Role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to system settings  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkIdentifierGroup),"Could not click on Identifier Group link:" + idGroupData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllIdentifiersGroup(selenium),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddIdentifierGroup),"Could not click on Add Identifier Group link:" + idGroupData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:  Enter Test Data and Submit                               //
			//--------------------------------------------------------------------//
			try {
				if(!addIdentifierGrp(selenium, idGroupData) && idGroupData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).contains("yes")){
					if(isElementPresent(selenium,"//p")){
						alertText = getText(selenium, "//p");
						if(alertText.toLowerCase(new java.util.Locale("en", "US")).startsWith(idGroupData.alertMessage.trim().toLowerCase(new java.util.Locale("en", "US"))))
						{
				   			return returnValue;			
						}else{
							Assert.fail("An unxpected Alert is displayed with message; The Expected :"+idGroupData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + idGroupData.toString());
						}
					}else{
						Assert.fail("Alert is not getting displayed; The Expected :"+idGroupData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + idGroupData.toString());
					}	
				}else if(idGroupData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).equals("no")){
					return returnValue;
				}else{
					Assert.fail("Expected Alert is not displayed; The Expected :"+idGroupData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + idGroupData.toString());
				}
			}catch (Exception e) {
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + idGroupData.toString(), selenium, ClassName, MethodName);
				returnValue=false;
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			returnValue=false;
		}
		return returnValue;
	}
	public boolean addIdentifierGrp(Selenium selenium,SystemsSettingsUnitTest idGroupData) throws IOException{
		try{
			select(selenium, btnIdGroup,idGroupData.groupFor);
			assertTrue(type(selenium,txtGroup ,idGroupData.groupName),"Could not enter the group;More details:"+idGroupData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtdescription ,idGroupData.groupDescription),"Could not enter the group decription;More details:"+idGroupData.toString(), selenium, ClassName, MethodName);
			select(selenium,btnStatusIdGroup,idGroupData.groupFor);
			assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ idGroupData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnEditIdGroup)){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"  + idGroupData.toString(), selenium, ClassName, MethodName);
			return false;
		}
	}
}
	