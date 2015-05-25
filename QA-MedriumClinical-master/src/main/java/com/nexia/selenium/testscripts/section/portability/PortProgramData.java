package com.nexia.selenium.testscripts.section.portability;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;


public class PortProgramData extends AbstractSystemSettingsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Add Program Data If Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProgramPhysicalRehab(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib programData = new SystemSettingsLib();
		programData.workSheetName = "CreateProgram";
		programData.testCaseId = "TC_CP_004";
		programData.fetchSystemSettingTestData();
		createProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);	
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Add Program Data If Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProgramProgramName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib programData = new SystemSettingsLib();
		programData.workSheetName = "CreateProgram";
		programData.testCaseId = "TC_CP_005";
		programData.fetchSystemSettingTestData();
		createProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);	
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Add Program Data If Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProgramSmokingCessation(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib programData = new SystemSettingsLib();
		programData.workSheetName = "CreateProgram";
		programData.testCaseId = "TC_CP_006";
		programData.fetchSystemSettingTestData();
		createProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);	
	}
	
	/**
	 * createProgram
	 * function to create Program
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	     May 17, 2012
	 */
	
	public boolean createProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib programData) throws Exception{
		{
			Selenium selenium=null;
			boolean returnValue=true;
			int possition=1;
			try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + programData .toString());
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, programData.userName, programData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
				
				//--------------------------------------------------------------------//
				//  Step-2:Change Switch Role                                          //
				//--------------------------------------------------------------------//
				assertTrue(switchRole(selenium,programData.switchRole),"Switch Role failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium, btnErrorClose)){
						assertTrue(click(selenium, btnErrorClose),"could not click the error close button",selenium,ClassName,MethodName);
				}
				SystemSettingsLib deptData = new SystemSettingsLib();
				if(programData.testCaseId.equals("TC_CP_004")){
				deptData.workSheetName = "CreateDepartment";
				deptData.testCaseId = "TC_CD_002";
				deptData.fetchSystemSettingTestData();
				}
				else if(programData.testCaseId.equals("TC_CP_005")|| programData.testCaseId.equals("TC_CP_006")){
					deptData.workSheetName = "CreateDepartment";
					deptData.testCaseId = "TC_CD_003";
					deptData.fetchSystemSettingTestData();
				}
				
				//--------------------------------------------------------------------//
				//  Step-3: Go to System Settings and navigate to Internal Programs //
				//--------------------------------------------------------------------//
				assertTrue(gotoSystemSetting(selenium),"Action failed",selenium,ClassName,MethodName);
				//click include inactive departments to list all departments
				assertTrue(click(selenium,chkIncludeInactiveDepartmentsBox),"Could not click on System settings link:" + programData .toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);

				//if number of departments not exist more than ten means, text box will not be appear.
				if(selenium.isVisible(txtDepartmentSearch)){
					assertTrue(type(selenium,txtDepartmentSearch,programData.department ),"Could not click on System settings link:" + programData .toString(),selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnDepartmentSearch),"Could not click on System settings link:" + programData .toString(),selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					//if we search the department using search box, The result department will be displayed at first position
					possition=1;
				}
				else{
					//So, We use loop to find the position of department in the displayed list
					String depCount=getText(selenium,getDepartmentCount);				
					if (!selenium.isTextPresent("No department found"))
					{
						//System.out.println("depCount = " + depCount);
						int departCount=Integer.parseInt(depCount.replaceAll(".*\\(|\\).*", ""));	
						for(int count=1;count<=departCount;count++){
							System.out.println(getText(selenium,"xpath=(//span[contains(@id,'departmentListItem')])["+count+"]").toLowerCase(new java.util.Locale("en","US")).trim());
							System.out.println(programData.department.trim().toLowerCase(new java.util.Locale("en","US")));
							if(getText(selenium,"xpath=(//span[contains(@id,'departmentListItem')])["+count+"]").toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.department.trim().toLowerCase(new java.util.Locale("en","US")))){
								possition=count;
								break;
							}
						}						
					 }		
				   }

				// depends on the position we check the department name presents
				if(getText(selenium,"xpath=(//span[contains(@id,'departmentListItem')])["+possition+"]").toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.department.trim().toLowerCase(new java.util.Locale("en","US")))){
					//if department presents, Checks of active/ inactive status
					if(getText(selenium,"xpath=(//a[contains(@id,'ActivateDepartment')])["+possition+"]").toLowerCase(new java.util.Locale("en","US")).trim().contains("Activate".trim().toLowerCase(new java.util.Locale("en","US")))){
						assertTrue(click(selenium,lnkActivate),"Could not click on activate link:" + programData .toString(),selenium,ClassName,MethodName);
						waitForPageLoad(selenium);
					}
					else 
						returnValue=true;
				}
				else
				{
					assertTrue(createDepartmentForPort(selenium,deptData),"Could not create the department",selenium,ClassName,MethodName);
				}
				
				//--------------------------------------------------------------------//
				//  Step-4: Check whether the program is active //
				//--------------------------------------------------------------------//
				
				assertTrue(click(selenium,chkIncludeInactiveProgramsCheckbox),"Could not click on System settings link:" + programData .toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);				
				//if number of programs not exist more than ten means, text box will not be appear.
				if(selenium.isVisible(txtSearchTextBox2)){
					assertTrue(type(selenium,txtSearchTextBox2,programData.program ),"Could not click on System settings link:" + programData .toString(),selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnProgramSearch),"Could not click on System settings link:" + programData .toString(),selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					//if we search the program using search box, The result program will be displayed at first position
					possition=1;
				}
				else{
					//So, We use loop to find the position of program in the displayed list
					String proCount=getText(selenium,getProgramCount);
					if (!selenium.isTextPresent("No program found"))
					{
						
					int progCount=Integer.parseInt(proCount.replaceAll(".*\\(|\\).*", ""));
					for(int count=1;count<=progCount;count++){
						if(getText(selenium,"xpath=(//div[@id='programListItemMainContent'])["+count+"]").toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.program.trim().toLowerCase(new java.util.Locale("en","US")))){
							possition=count;
							break;
						}
					}
					}
				}	
				// depends on the position we check the program name presents
				if(getText(selenium,"xpath=(//div[@id='programListItemMainContent'])["+possition+"]").toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.program.trim().toLowerCase(new java.util.Locale("en","US")))){
					//if program presents, Checks of active/ inactive status
					if(getText(selenium,"xpath=(//div[@id='programListItemMainContent'])["+possition+"]").toLowerCase(new java.util.Locale("en","US")).trim().contains("Inactive".trim().toLowerCase(new java.util.Locale("en","US")))){
						
						assertTrue(click(selenium,lnkActivate),"Could not click on activate link:" + programData .toString(),selenium,ClassName,MethodName);
						waitForPageLoad(selenium);
						
					}
					else 
						returnValue=true;
					
				}				
		
				//--------------------------------------------------------------------//
				//  Step-5: Add a Program//
				//--------------------------------------------------------------------//
				else
				{					
					assertTrue(click(selenium,btnAddProgram),"Could not click on add a program link:" + programData .toString(),selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					assertTrue(createProgramForPort(selenium,programData),"Creation Failed",selenium,ClassName,MethodName);
				}
			}
			catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + programData.toString());
			}
			return returnValue;
		}
	}
}


