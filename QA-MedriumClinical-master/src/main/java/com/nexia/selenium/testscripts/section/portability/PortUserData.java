package com.nexia.selenium.testscripts.section.portability;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class PortUserData extends AbstractSystemSettingsTest{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required", priority=2)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUser001(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "UserData";
		userData.testCaseId = "TC_NU_001";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userData.fetchSystemSettingTestData();
		checkUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);	
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required", priority=2)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUser002(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "UserData";
		userData.testCaseId = "TC_NU_002";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userData.fetchSystemSettingTestData();
		checkUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);	
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required", priority=1)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUser003(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "UserData";
		userData.testCaseId = "TC_NU_003";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userData.fetchSystemSettingTestData();
		checkUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);	
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required", priority=1)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUser004(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "UserData";
		userData.testCaseId = "TC_NU_004";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userData.fetchSystemSettingTestData();
		checkUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);	
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required", priority=1)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUser005(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "UserData";
		userData.testCaseId = "TC_NU_005";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userData.fetchSystemSettingTestData();
		checkUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);	
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required", priority=1)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUser006(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "UserData";
		userData.testCaseId = "TC_NU_006";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userData.fetchSystemSettingTestData();
		checkUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);	
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required", priority=2)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUser007(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "UserData";
		userData.testCaseId = "TC_NU_007";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userData.fetchSystemSettingTestData();
		checkUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);	
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required", priority=2)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUser008(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "UserData";
		userData.testCaseId = "TC_NU_008";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userData.fetchSystemSettingTestData();
		checkUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);	
	}
	

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required", priority=2)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUser009(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "UserData";
		userData.testCaseId = "TC_NU_009";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userData.fetchSystemSettingTestData();
		checkUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);	
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required", priority=1)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUser010(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "UserData";
		userData.testCaseId = "TC_NU_010";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userData.fetchSystemSettingTestData();
		checkUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);	
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required", priority=1)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUser011(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "UserData";
		userData.testCaseId = "TC_NU_011";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userData.fetchSystemSettingTestData();
		checkUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);	
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required", priority=1)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUser012(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "UserData";
		userData.testCaseId = "TC_NU_012";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userData.fetchSystemSettingTestData();
		checkUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);	
	}

	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required", priority=1)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUser013(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "UserData";
		userData.testCaseId = "TC_NU_013";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userData.fetchSystemSettingTestData();
		checkUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);	
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required", priority=1)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUser014(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "UserData";
		userData.testCaseId = "TC_NU_014";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userData.fetchSystemSettingTestData();
		checkUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);	
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required", priority=1)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUser015(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "UserData";
		userData.testCaseId = "TC_NU_015";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userData.fetchSystemSettingTestData();
		checkUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);	
	}
	
	@Test(groups = {"Regression", "review","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required", priority=1)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUser016(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "UserData";
		userData.testCaseId = "TC_NU_016";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userData.fetchSystemSettingTestData();
		checkUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);	
	}
	
	@Test(groups = {"Regression", "review","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required", priority=1)
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewUser019(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib userData = new SystemSettingsLib();
		userData.workSheetName = "UserData";
		userData.testCaseId = "TC_NU_019";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		userData.fetchSystemSettingTestData();
		checkUser(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);	
	}

	public boolean checkUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib userData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		boolean verifyCreatedUser=false;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + userData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, userData.userName, userData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to System setting
			//--------------------------------------------------------------------//
			assertTrue(gotoSystemSetting(selenium),"Could not go to system settings",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//----------------------------//
			//  Step-3: Search User       //
			//----------------------------//
			if(!searchUser(selenium,userData)){
				//--------------------------------------------------------------------//
				//---------------  Step-4: Create New User   -------------------------//
				//--------------------------------------------------------------------//	
				assertTrue(createUserPortability(selenium,userData,userAccount),"Create new user",selenium,ClassName,MethodName);
				verifyCreatedUser=true;
				waitForPageLoad(selenium);
			}
			else{

				if(!verifyStoreValue(selenium,userData,userAccount)){
					waitForPageLoad(selenium);
					if(isElementPresent(selenium, "edit"))
					assertTrue(click(selenium,"edit"),"Could not click the edit putton",selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					editUserPortability(selenium,userData,userAccount);
					verifyCreatedUser=true;
				}
			}
			
			//---------------------------------------------------------//
			//---------------  Step-4:Verify Store Value --------------//
			//---------------------------------------------------------//	
			if(verifyCreatedUser){
				
				if(!verifyStoreValue(selenium,userData,userAccount)){
					Assert.fail("user details are not Create properly; More Details :"+ userData.toString());
					returnValue=false;
				}else 
					returnValue=true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + userData.toString());
		}
		return returnValue;
	}

	
	public boolean searchUser(Selenium selenium,SystemSettingsLib userData) throws IOException{
		String userCount=getText(selenium, "//div[contains(text(), 'Users')]/span/span");
        String splitStr1 = userCount.replaceAll("[()]","");
        
        
        int usercount=Integer.parseInt(splitStr1);
        int count=1;
        if(usercount<=10){
              while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td/div/div/div")){
            	  
            	  click(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td/div/div/div");
            	  waitForPageLoad(selenium);
            	  
            	  if(getText(selenium, "userId").equalsIgnoreCase(userData.userName1)){
            		  break;
            	  }
            	  else{
            		click(selenium,lnkAdminOrgStructureLists);   
            		waitForPageLoad(selenium);
            		count++;
            	  }
                    
                   if(count>10){
                         break;
                   }
              }
              
              
        }
        else{
			
			assertTrue(type(selenium,txtUserSearch,userData.userName1),"Could not type the last name",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnUserSearch),"Could not click the search button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			boolean userPresent= false;
			
			while(isElementPresent(selenium, "//div[@id='users']/table/tbody/tr["+count+"]/td/div/div/div")){
				click(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td/div/div/div");
				waitForPageLoad(selenium);
				
		      	if(!getText(selenium, "userId").equalsIgnoreCase(userData.userName1)){
		      		click(selenium,lnkAdminOrgStructureLists);
		      		waitForPageLoad(selenium);
		      		
		      		assertTrue(type(selenium,txtUserSearch,userData.userName1),"Could not type the last name",selenium,ClassName,MethodName);
		      		assertTrue(click(selenium,btnUserSearch),"Could not click the search button",selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					count++;
		      	}
		      	else{
		      		userPresent= true;
		      		break;
		      	}
		      	if(count>10){
                    break;
                }
		    }
			if(!userPresent){
      			if(!isChecked(selenium, "id=includeInactiveUserscheckbox")){
      				click(selenium,"id=includeInactiveUserscheckbox");
      				waitForPageLoad(selenium);
      			}
				count = 1;
				while(isElementPresent(selenium, "//div[@id='users']/table/tbody/tr["+count+"]/td/div/div/div")){
					click(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td/div/div/div");
					waitForPageLoad(selenium);
					
			      	if(!getText(selenium, "userId").equalsIgnoreCase(userData.userName1)){
			      		click(selenium,lnkAdminOrgStructureLists);
			      		waitForPageLoad(selenium);
			      		
			      		assertTrue(type(selenium,txtUserSearch,userData.userName1),"Could not type the last name",selenium,ClassName,MethodName);
			      		assertTrue(click(selenium,btnUserSearch),"Could not click the search button",selenium,ClassName,MethodName);
						waitForPageLoad(selenium);
						if(!isChecked(selenium, "id=includeInactiveUserscheckbox")){
		      				click(selenium,"id=includeInactiveUserscheckbox");
		      				waitForPageLoad(selenium);
		      			}
						waitForPageLoad(selenium);
						
						
			      	}
			      	else{
			      		click(selenium,lnkAdminOrgStructureLists);
			      		waitForPageLoad(selenium);
			      		
			      		assertTrue(type(selenium,txtUserSearch,userData.userName1),"Could not type the last name",selenium,ClassName,MethodName);
			      		assertTrue(click(selenium,btnUserSearch),"Could not click the search button",selenium,ClassName,MethodName);
						waitForPageLoad(selenium);
						if(!isChecked(selenium, "id=includeInactiveUserscheckbox")){
		      				click(selenium,"id=includeInactiveUserscheckbox");
		      				waitForPageLoad(selenium);
		      			}
						waitForPageLoad(selenium);
						
						assertTrue(click(selenium,"xpath=(//a[contains(text(),'Activate')])["+count+"]"),"Could not click xpath",selenium,ClassName,MethodName);
						click(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td/div/div/div");
						waitForPageLoad(selenium);
						
						userPresent= true;
						
						break;
			      	}
			      	count++;
			      	if(count>10){
	                    break;
	                }
			    }
			      	
			      	
	      	}
             
        }
			
		if(isElementPresent(selenium,"edit")){
			return true;
		}else
			return false;
	}
	
	
	public boolean verifyStoreValue(Selenium selenium,SystemSettingsLib userData, String userAccount){
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		
		String practice=null;
		
		try {
		if(userAccount.equalsIgnoreCase(CAAccount)){
			practice=userData.practiseCA;
		}
		else{
			practice=userData.practise;
		}
		if(!getText(selenium,"roles").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.userRole.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"roles").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.userRole2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,"roles").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.userRole3.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,"roles").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.userRole4.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"roles").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.userRole5.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"roles").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.userRole6.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"roles").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.userRole7.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"roles").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.userRole8.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"roles").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.userRole9.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(userData.testCaseId.equalsIgnoreCase("TC_NU_014")){
			if(!getText(selenium,"roles").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.userRole10.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			
			if(!getText(selenium,"roles").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.userRole11.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getText(selenium,"roles").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.userRole12.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getText(selenium,"roles").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.userRole13.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getText(selenium,"roles").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.userRole14.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getText(selenium,"roles").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.userRole15.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getText(selenium,"roles").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.userRole16.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		
		
			assertTrue(click(selenium,"edit"),"Could not click the edit putton",selenium,ClassName,MethodName);
		
		waitForPageLoad(selenium);
		
		if(userData.testCaseId.equalsIgnoreCase("TC_NU_001")||userData.testCaseId.equalsIgnoreCase("TC_NU_002")
				||userData.testCaseId.equalsIgnoreCase("TC_NU_007")||userData.testCaseId.equalsIgnoreCase("TC_NU_008")
				||userData.testCaseId.equalsIgnoreCase("TC_NU_009")|| userData.testCaseId.equalsIgnoreCase("TC_NU_015")){
			
			if(isElementPresent(selenium,"//span/input")){
				if(!isChecked(selenium, "//span/input")){
					return false;
				}
			}
		}
		else{
			if(isElementPresent(selenium,"//span/input")){
				if(isChecked(selenium, "//span/input")){
					return false;
				}
			}
		}
			
			
		if(!getText(selenium,"userName").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.userName1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,"lastName").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,"firstName").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,"credentials").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.credentials.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		
		if(!getValue(selenium,"xpath=(//input[@id='suggestBox'])[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if((userData.testCaseId.equalsIgnoreCase("TC_NU_007")) || (userData.testCaseId.equalsIgnoreCase("TC_NU_003"))
				|| (userData.testCaseId.equalsIgnoreCase("TC_NU_014"))){
			
			if(!getValue(selenium,"xpath=(//input[@id='suggestBox'])[3]").toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			
			if(!getValue(selenium,"xpath=(//input[@id='suggestBox'])[4]").toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			
			if(!getValue(selenium,"xpath=(//input[@id='suggestBox'])[5]").toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			
			
			if(userData.testCaseId.equalsIgnoreCase("TC_NU_007")|| (userData.testCaseId.equalsIgnoreCase("TC_NU_014"))){
				
				if(!getValue(selenium,"xpath=(//input[@id='suggestBox'])[6]").toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				
				if(!getValue(selenium,"xpath=(//input[@id='suggestBox'])[7]").toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				if(!getValue(selenium,"xpath=(//input[@id='suggestBox'])[8]").toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				if(!getValue(selenium,"xpath=(//input[@id='suggestBox'])[9]").toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				if(!getValue(selenium,"xpath=(//input[@id='suggestBox'])[10]").toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				
				if(userData.testCaseId.equalsIgnoreCase("TC_NU_014")){
					if(!getValue(selenium,"xpath=(//input[@id='suggestBox'])[11]").toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}
					
					if(!getValue(selenium,"xpath=(//input[@id='suggestBox'])[12]").toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}
					if(!getValue(selenium,"xpath=(//input[@id='suggestBox'])[13]").toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}
					if(!getValue(selenium,"xpath=(//input[@id='suggestBox'])[14]").toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}
					if(!getValue(selenium,"xpath=(//input[@id='suggestBox'])[15]").toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}
					if(!getValue(selenium,"xpath=(//input[@id='suggestBox'])[16]").toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}
					if(!getValue(selenium,"xpath=(//input[@id='suggestBox'])[17]").toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.trim().toLowerCase(new java.util.Locale("en","US")))){
						return false;
					}
				}
			}
			
		}
		
		click(selenium,"save");
		waitForPageLoad(selenium);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return true;
	}
}
