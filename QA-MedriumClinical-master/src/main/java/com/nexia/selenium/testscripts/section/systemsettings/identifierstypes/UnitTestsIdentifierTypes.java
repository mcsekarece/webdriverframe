package com.nexia.selenium.testscripts.section.systemsettings.identifierstypes;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestsIdentifierTypes extends AbstractSystemSettingsTest {
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Group With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyGroupWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest idTypeData= new SystemsSettingsUnitTest();
		idTypeData.workSheetName = "UnitTest_SS_IdTypes";
		idTypeData.testCaseId = "TC_SS_IDT_001";
		idTypeData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addIdentifierType(seleniumHost, seleniumPort, browser, webSite, userAccount, idTypeData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Type With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTypeWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest idTypeData= new SystemsSettingsUnitTest();
		idTypeData.workSheetName = "UnitTest_SS_IdTypes";
		idTypeData.testCaseId = "TC_SS_IDT_002";
		idTypeData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addIdentifierType(seleniumHost, seleniumPort, browser, webSite, userAccount, idTypeData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Type With Max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTypeWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest idTypeData= new SystemsSettingsUnitTest();
		idTypeData.workSheetName = "UnitTest_SS_IdTypes";
		idTypeData.testCaseId = "TC_SS_IDT_003";
		idTypeData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addIdentifierType(seleniumHost, seleniumPort, browser, webSite, userAccount, idTypeData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Description With Max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDescriptionWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest idTypeData= new SystemsSettingsUnitTest();
		idTypeData.workSheetName = "UnitTest_SS_IdTypes";
		idTypeData.testCaseId = "TC_SS_IDT_004";
		idTypeData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addIdentifierType(seleniumHost, seleniumPort, browser, webSite, userAccount, idTypeData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Type Mask With Invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTypeMaskWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest idTypeData= new SystemsSettingsUnitTest();
		idTypeData.workSheetName = "UnitTest_SS_IdTypes";
		idTypeData.testCaseId = "TC_SS_IDT_005";
		idTypeData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addIdentifierType(seleniumHost, seleniumPort, browser, webSite, userAccount, idTypeData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Type Mask With Max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTypeMaskWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest idTypeData= new SystemsSettingsUnitTest();
		idTypeData.workSheetName = "UnitTest_SS_IdTypes";
		idTypeData.testCaseId = "TC_SS_IDT_006";
		idTypeData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addIdentifierType(seleniumHost, seleniumPort, browser, webSite, userAccount, idTypeData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Identifier With Max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIdentifierWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest idTypeData= new SystemsSettingsUnitTest();
		idTypeData.workSheetName = "UnitTest_SS_IdTypes";
		idTypeData.testCaseId = "TC_SS_IDT_007";
		idTypeData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addIdentifierType(seleniumHost, seleniumPort, browser, webSite, userAccount, idTypeData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Identifier With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyIdentifierWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemsSettingsUnitTest idTypeData= new SystemsSettingsUnitTest();
		idTypeData.workSheetName = "UnitTest_SS_IdTypes";
		idTypeData.testCaseId = "TC_SS_IDT_008";
		idTypeData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addIdentifierType(seleniumHost, seleniumPort, browser, webSite, userAccount, idTypeData);
	}
	
	/**
	 * addIdentifierType
	 * function to add Identifier Type
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	     May 21, 2012
	 */
public boolean addIdentifierType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemsSettingsUnitTest idTypeData) throws IOException{
	Selenium selenium = null;
	boolean returnValue=true;
	try{
			
		//--------------------------------------------------------------------//
		// Login to the application//
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + idTypeData.toString());
		assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, idTypeData.userName, idTypeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		
		//--------------------------------------------------------------------//
		//---------------  Step-2:Change Switch Role  --------------//
		//--------------------------------------------------------------------//
		assertTrue(switchRole(selenium,idTypeData.switchRole),"Switch Role failed", selenium, ClassName, MethodName);
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
		//---------------------------------------------------------- ----------//
		//  Step-3: Deleting existing Identifier Groups  //
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,lnkIdentifierGroup),"Could not click", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(deleteAllIdentifiersGroup(selenium),"Deletion failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//---------------------------------------------------------- ----------//
		//  Step-4: Deleting existing Identifier Groups  //
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,lnkIdentifierType),"Could not click on Identifier Type link:" + idTypeData .toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(deleteAllIdentifiersTypes(selenium),"Deletion failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, lnkAddIdentifierType),"Could not click on Add Identifier Type link:" + idTypeData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//--------------------------------------------------------------------//
		//------------------------Step-5: Verify the Unit Test----------------// 
		//--------------------------------------------------------------------//
		
		assertTrue(addIdentifierType(selenium,idTypeData ),"Identifier failed", selenium, ClassName, MethodName);
		idTypeData.alert= idTypeData.alert == null ? idTypeData.alert = "" : idTypeData.alert.trim();
		if(!idTypeData.alert.equals("")){
			assertTrue(isElementPresent(selenium, idTypeData .alert), "The validation message field did not appear", selenium, ClassName, MethodName);
			assertTrue(getText(selenium, idTypeData .alert).contains(idTypeData .alertMessage), "The expected validation message should contain the text - "+ idTypeData .alertMessage + " The actual validation message shown - " + getText(selenium,idTypeData .alert), selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
		}
		}catch (RuntimeException e) {
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		returnValue=false;
		}
		return returnValue;
	}
	public boolean addIdentifierType(Selenium selenium,SystemsSettingsUnitTest idTypeData) throws IOException{
		try{
                 select(selenium, btnIdGroup,idTypeData.groupFor);
			
			selectValueFromAjaxList(selenium,ajxSuggestBoxIdType,idTypeData.idGroup);
			
			assertTrue(type(selenium, txtType,idTypeData.idType),"Could not enter the group;More details:"+idTypeData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtdescription ,idTypeData.typeDescription),"Could not enter the group decription;More details:"+idTypeData.toString(), selenium, ClassName, MethodName);
			if(!idTypeData.freeTextRadio.equalsIgnoreCase("yes")){
				assertTrue(click(selenium,rdbtnDefinedList ),"Could not click on radio button; More details"+ idTypeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,rdbtnDefinedList ),"Could not click on radio button; More details"+ idTypeData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtIdentifier,idTypeData.identifier),"Could not enter the identifier;More details:"+idTypeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnAddId),"Could not click on add button; More details"+ idTypeData.toString(), selenium, ClassName, MethodName);
			}
			type(selenium,txtMask ,idTypeData.idTypeMask);
			if(idTypeData.restricted.equals("Yes")){
				assertTrue(click(selenium,chkRestrictedBox ),"Could not click the reatractionlevel check box;More Details:"+idTypeData.toString(), selenium, ClassName, MethodName);
			}
			if(idTypeData.expDate.equals("Yes")){
				assertTrue(click(selenium,chkEndDateRequiredBox),"Could not click the reatractionlevel check box;More Details:"+idTypeData.toString(), selenium, ClassName, MethodName);
			}
			
			if(idTypeData.typeDefault.equals("Yes")){
				assertTrue(click(selenium,chkDefaultBox),"Could not click the defaultType check box;More Details:"+idTypeData.toString(), selenium, ClassName, MethodName);
			}
			
		
			if(idTypeData.practice.equals("Yes")){
				assertTrue(click(selenium,rdbtnpracticeLevel),"Could not click the practice Level radio box;More Details:"+idTypeData.toString(), selenium, ClassName, MethodName);
			}
			if(!(idTypeData.testCaseId.equalsIgnoreCase("TC_SS_IDT_007")||idTypeData.testCaseId.equalsIgnoreCase("TC_SS_IDT_008")))
					assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ idTypeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return false;
		}
	}
}
	