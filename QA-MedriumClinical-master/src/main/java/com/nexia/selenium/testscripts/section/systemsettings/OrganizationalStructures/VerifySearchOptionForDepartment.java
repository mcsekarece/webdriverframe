package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchOptionForDepartment extends AbstractSystemSettingsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleteing a department")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteDepartment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib deptData = new SystemSettingsLib();
		deptData.workSheetName = "CreateDepartment";
		deptData.testCaseId = "TC_CD_001";
		deptData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteDepartment(seleniumHost, seleniumPort, browser, webSite, userAccount, deptData);
	}
	/**
	 * deleteDepartment
	 * function to delete Department
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 05, 2010
	 */
public boolean deleteDepartment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib deptData) throws Exception{
	
		
		Selenium selenium=null;
		boolean returnValue=true;
		String btnDepartmentSearch ="//span[contains(text(),'Department')]/parent::div/following-sibling::div/span/button";
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + deptData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, deptData.userName, deptData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
				assertTrue(switchRole(selenium,deptData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Departments //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			waitForPageLoad(selenium);
			
			if(!getText(selenium,btnDepartmentSearch).contains("Search")){
				
				return returnValue;
			}	
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(deleteDepartment(selenium,deptData),"Could not delete the department", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Create a Department //
			//--------------------------------------------------------------------//
			assertTrue(createDepartment(selenium,deptData,uniqueName),"Could not create the department", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete a Department //
			//--------------------------------------------------------------------//
			int counter=1;
			while(getText(selenium,vfyDelDepartment).contains(deptData.department)){
				if(getText(selenium,"//div[@id='departments']/table/tbody/tr["+counter+"]/td/div/span",10000).contains(deptData.department+uniqueName)){
					click(selenium,"//div[@id='departments']/table/tbody/tr["+counter+"]/td[2]/div/a");
					click(selenium,btnYes);
					break;
				}
				else if(getText(selenium,vfySearchDepartment1 ,10000).contains(deptData.department+uniqueName)){
					click(selenium,vfySearchDepartment2);
					click(selenium,btnYes);
					break;
				}
				counter++;
			}
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,chkIncludeInactiveDepartmentsBox),"Could not click on Include inactives check box:" + deptData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-5:Verify InActive Department //
			//--------------------------------------------------------------------//
			
			
				if(getText(selenium,btnDepartmentSearch).contains("Search")){
					assertTrue(type(selenium,txtDepartmentSearch,deptData.department+uniqueName),"Could not type the Program Name", selenium, ClassName, MethodName);
					selenium.keyPress(txtDepartmentSearch, "\\13");
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnActiveHealth),"could not activate the Program", selenium, ClassName, MethodName);
			    //assertTrue(click(selenium,btnActiveHealth),"could not activate the Program", selenium, ClassName, MethodName);
			   
				waitForPageLoad(selenium);
				}else{
					
					int departmentCount  = (Integer) selenium.getXpathCount("//div[@id='departments']/table/tbody/tr/td");
					for(int count =1; count<departmentCount; count++){
						if(getText(selenium,"//div[@id='departments']/table/tbody/tr["+count+"]/td").contains(deptData.department+uniqueName))
						assertTrue(click(selenium,"//div[@id='departments']/table/tbody/tr["+count+"]/td[2]/div/a"),"could not activate the Program", selenium, ClassName, MethodName);
					}
				}
			
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify Active the Department Details //
			//--------------------------------------------------------------------//
			if(isChecked(selenium,chkIncludeInactiveDepartmentsBox)){
				assertTrue(click(selenium,chkIncludeInactiveDepartmentsBox),"Could not click on Include inactives check box:" + deptData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			
				if(getText(selenium,btnDepartmentSearch).contains("Search")){
				assertTrue(type(selenium,txtSearchTextBox2,deptData.department+uniqueName),"Could not type the Program Name", selenium, ClassName, MethodName);
			    selenium.keyPress(txtSearchTextBox2, "\\13");
			    assertTrue(click(selenium,btnDepartmentSearch),"Could not click on Include inactives check box:" + deptData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			    if(selenium.isTextPresent("Inactive")){
					Assert.fail("Inactive Details are getting displayed");
				}
			  }else{
				int programCount  = (Integer) selenium.getXpathCount("//div[@id='departments']/table/tbody/tr/td");
				for(int count =1; count<programCount; count++){
					if(getText(selenium,"//div[@id='departments']/table/tbody/tr["+count+"]/td").contains("Inactive"))
						Assert.fail("Inactive Details are getting displayed");
				}
			}
			

		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + deptData.toString(), selenium, ClassName, MethodName);
			Thread.sleep(10000);
		}
	return returnValue;
	}	
}
