package com.nexia.selenium.testscripts.section.portability;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class CreatePayersForPortability extends AbstractSystemSettingsTest {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforePayerPatientPortability" }, description = "Test for Creating Payers For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPayer001(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib createPayer = new SystemSettingsLib();
		createPayer.workSheetName = "PortAddPayers";
		createPayer.testCaseId = "TC_AP_001";
		createPayer.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		CreatePayer(seleniumHost, seleniumPort, browser, webSite, userAccount, createPayer);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Creating Payers For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPayer002(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib createPayer = new SystemSettingsLib();
		createPayer.workSheetName = "PortAddPayers";
		createPayer.testCaseId = "TC_AP_002";
		createPayer.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		CreatePayer(seleniumHost, seleniumPort, browser, webSite, userAccount, createPayer);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Creating Payers For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPayer003(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib createPayer = new SystemSettingsLib();
		createPayer.workSheetName = "PortAddPayers";
		createPayer.testCaseId = "TC_AP_003";
		createPayer.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		CreatePayer(seleniumHost, seleniumPort, browser, webSite, userAccount, createPayer);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Creating Payers For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPayer004(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib createPayer = new SystemSettingsLib();
		createPayer.workSheetName = "PortAddPayers";
		createPayer.testCaseId = "TC_AP_004";
		createPayer.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		CreatePayer(seleniumHost, seleniumPort, browser, webSite, userAccount, createPayer);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Creating Payers For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPayer005(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib createPayer = new SystemSettingsLib();
		createPayer.workSheetName = "PortAddPayers";
		createPayer.testCaseId = "TC_AP_005";
		createPayer.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CreatePayer(seleniumHost, seleniumPort, browser, webSite, userAccount, createPayer);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Creating Payers For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPayer006(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib createPayer = new SystemSettingsLib();
		createPayer.workSheetName = "PortAddPayers";
		createPayer.testCaseId = "TC_AP_006";
		createPayer.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CreatePayer(seleniumHost, seleniumPort, browser, webSite, userAccount, createPayer);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Creating Payers For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPayer007(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib createPayer = new SystemSettingsLib();
		createPayer.workSheetName = "PortAddPayers";
		createPayer.testCaseId = "TC_AP_007";
		createPayer.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CreatePayer(seleniumHost, seleniumPort, browser, webSite, userAccount, createPayer);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Creating Payers For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPayer008(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib createPayer = new SystemSettingsLib();
		createPayer.workSheetName = "PortAddPayers";
		createPayer.testCaseId = "TC_AP_008";
		createPayer.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CreatePayer(seleniumHost, seleniumPort, browser, webSite, userAccount, createPayer);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Creating Payers For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPayer009(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib createPayer = new SystemSettingsLib();
		createPayer.workSheetName = "PortAddPayers";
		createPayer.testCaseId = "TC_AP_009";
		createPayer.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CreatePayer(seleniumHost, seleniumPort, browser, webSite, userAccount, createPayer);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Creating Payers For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPayer010(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib createPayer = new SystemSettingsLib();
		createPayer.workSheetName = "PortAddPayers";
		createPayer.testCaseId = "TC_AP_010";
		createPayer.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CreatePayer(seleniumHost, seleniumPort, browser, webSite, userAccount, createPayer);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Creating Payers For Portability")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPayer011(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		SystemSettingsLib createPayer = new SystemSettingsLib();
		createPayer.workSheetName = "PortAddPayers";
		createPayer.testCaseId = "TC_AP_011";
		createPayer.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		CreatePayer(seleniumHost, seleniumPort, browser, webSite, userAccount, createPayer);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Creating Payers For Portability 
	* @action 		  verifying Creating Payers For Portability 
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 13, 2010
	***************************************************************************************************/
	
	public boolean CreatePayer(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib createPayer) throws Exception{
		Selenium selenium = null;
		boolean CreatePayer=true;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + createPayer.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, createPayer.userName, createPayer.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			
	//		assertTrue(switchRole(selenium,createPayer.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate to System Setting								  //
			//--------------------------------------------------------------------//
			
			assertTrue(gotoSystemSetting(selenium),"Could not click on System settings link:" + createPayer .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkDirectories),"Could not click the Directories link;More Details:"+createPayer.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Search Payer						  //
			//--------------------------------------------------------------------//

			CreatePayer =  searchPayers(selenium, createPayer);
		
			if(CreatePayer == true){
				
		    //Create New Payer	
				
				System.out.println("Create a New Payer");
				assertTrue(click(selenium,btnAddNewPayer),"Could not click the AddNewPayer; More details"+createPayer.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(createNewPayer(selenium,createPayer,userAccount),"Could not add a New Payer"  + createPayer .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				System.out.println(createPayer.payerName + "Created");
			}else{
				System.out.println("Payer already Created");
			}
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}	

	public boolean searchPayers(Selenium selenium, SystemSettingsLib createPayer) throws IOException{
		
		
		if(isElementPresent(selenium,"//a[@id='payerAdmin_UserHintCloseButton']/img")){
			click(selenium,"//a[@id='payerAdmin_UserHintCloseButton']/img");
		}
		
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtSearchBox ,createPayer.payerName),"Could not type a PayerName" + createPayer.toString(),selenium, ClassName, MethodName);
		selenium.keyPress(txtSearchBox, "\\9");
		selenium.keyPress(txtSearchBox, "\\13");
	    waitForPageLoad(selenium);
	    waitForPageLoad(selenium);
	    if(getText(selenium,"//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr/td[2]/div/div/div/div[4]/div/div[2]").contains(createPayer.payerName)){
	    	return false;
	    }
	    
		if(!isChecked(selenium,chkIncludeInactivescheckbox)){
			assertTrue(click(selenium,chkIncludeInactivescheckbox),"Could not click the Include inactive check box; More details"+createPayer.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		int count = (Integer)selenium.getXpathCount("//div[@id='adminPayerListView']/table/tbody/tr/td/div");
		int counter = 1;
		for (counter = 1;counter<=count;counter++ ){
			if(getText(selenium,"//div[@id='adminPayerListView']/table/tbody/tr["+counter+"]/td/div").contains("Inactive")){
				if(getText(selenium,"//div[@id='adminPayerListView']/table/tbody/tr["+counter+"]/td/div").contains(createPayer.payerName)){
					assertTrue(click(selenium,"//div[@id='adminPayerListView']/table/tbody/tr["+counter+"]/td/div"),"Could not Click Required PayerName" + createPayer.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnActivateInactive),"Could not Click Activate Button" + createPayer.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					
					return false;
				}
			}
		}
		
		return true;
							
	}
	
}
