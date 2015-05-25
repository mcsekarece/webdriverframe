package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchForPrograms extends AbstractSystemSettingsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleting a program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deletePrograms(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib programData = new SystemSettingsLib();
		programData.workSheetName = "CreateProgram";
		programData.testCaseId = "TC_CP_001";
		programData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	/**
	 * deleteProgram
	 * function to deleteProgram
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 05, 2010
	 */
	public boolean deleteProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib programData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		String btnProgramSearch ="//span[contains(text(),'Programs')]/parent::div/following-sibling::div/span/button";
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + programData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, programData.userName, programData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			/*assertTrue(switchRole(selenium,programData.switchRole),"switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to External Providers //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			assertTrue(click(selenium,btnAddProgram),"Could not click on add a program link:" + programData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());

			assertTrue(createProgram(selenium,programData,uniqueName),"Create program failed", selenium, ClassName, MethodName);
			click(selenium,lnkAdminOrgStructureLists);
			waitForPageLoad(selenium);
			
			assertTrue(deleteProgram(selenium, programData),"could not delete the program", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Verify the Inactive Details
			assertTrue(click(selenium,chkIncludeInactiveProgramsCheckbox),"Could not click on Include inactives check box:" + programData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
				if(getText(selenium,btnProgramSearch).contains("Search")){
					assertTrue(type(selenium,txtSearchTextBox2,programData.program+uniqueName),"Could not type the Program Name", selenium, ClassName, MethodName);
					selenium.keyPress(txtSearchTextBox2, "\\13");
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnActiveHealth),"could not activate the Program", selenium, ClassName, MethodName);
			    //assertTrue(click(selenium,btnActiveHealth),"could not activate the Program", selenium, ClassName, MethodName);
			   
				waitForPageLoad(selenium);
				}else{
					
					int programCount  = (Integer) selenium.getXpathCount("//div[@id='programs']/table/tbody/tr/td/div/div");
					for(int count =1; count<programCount; count++){
						if(getText(selenium,"//div[@id='programs']/table/tbody/tr["+count+"]/td/div/div").contains(programData.program+uniqueName))
						assertTrue(click(selenium,"//div[@id='programs']/table/tbody/tr["+count+"]/td[2]/div/a"),"could not activate the Program", selenium, ClassName, MethodName);
					}
				}
			
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify Active the Program Details //
			//--------------------------------------------------------------------//
			if(isChecked(selenium,chkIncludeInactiveProgramsCheckbox)){
				assertTrue(click(selenium,chkIncludeInactiveProgramsCheckbox),"Could not click on Include inactives check box:" + programData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			

		
				if(getText(selenium,btnProgramSearch).contains("Search")){
				assertTrue(type(selenium,txtSearchTextBox2,programData.program+uniqueName),"Could not type the Program Name", selenium, ClassName, MethodName);
			    selenium.keyPress(txtSearchTextBox2, "\\13");
			    assertTrue(click(selenium,btnProgramSearch),"Could not click on Include inactives check box:" + programData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			    if(selenium.isTextPresent("Inactive")){
					Assert.fail("Inactive Details are getting displayed");
				}
			  }else{
				int programCount  = (Integer) selenium.getXpathCount("//div[@id='programs']/table/tbody/tr/td/div/div");
				for(int count =1; count<programCount; count++){
					if(getText(selenium,"//div[@id='programs']/table/tbody/tr["+count+"]/td/div/div").contains("Inactive"))
						Assert.fail("Inactive Details are getting displayed");
				}
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"  + programData.toString(), selenium, ClassName, MethodName);
			Thread.sleep(10000);
		}
	return returnValue;
	}
}
