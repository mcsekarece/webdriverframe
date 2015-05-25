package com.nexia.selenium.testscripts.section.portability;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class PortAssociateProviderForPractice extends AbstractSystemSettingsTest {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPracticesAutomationNexiaClinic(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_001";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewPracticesNexiaPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_002";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewPracticesCatherineKids(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_003";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewPracticesStagePractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_004";
		pracData.fetchSystemSettingTestData();	
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewPracticesCFDS(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_005";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}
	
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewEncounterStructureTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_011";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}
	/**
	 * createPractices
	 * function to createPractices
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    July 30, 2012
	 */
	public boolean checkPractices(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws Exception{
		{
			Selenium selenium=null;
			boolean returnValue=true;
			
			try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application //
				//--------------------------------------------------------------------//
			
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pracData .toString());
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, pracData.userName, pracData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
								
			
				//--------------------------------------------------------------------//
				//  Step-2: Go to System Settings and navigate to Practices			  //
				//--------------------------------------------------------------------//
				
				assertTrue(gotoSystemSetting(selenium),"Couldn't navigate to system settings",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);				
				
				//----------------------------//
				//  Step-3: Search Practice    //
				//----------------------------//
		
				if(!searchCurrentPractice(selenium,pracData))
					Assert.fail("Practice doesn't exist");
				else
					System.out.println("Practice with name " + pracData.practiceName + " is already created");				
				
				//-----------------------------------------------//
				//  Step-4: Add Associated Providers    //
				//-----------------------------------------------//					
				
				if(!addAssociateProvider(selenium,pracData))
					Assert.fail("Practice doesn't exist");
				else
					System.out.println("Practice with name " + pracData.practiceName + " is already created");
				
				}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString());
			}
			return returnValue;
		}
	}	
	
	
	
public boolean searchCurrentPractice(Selenium selenium,SystemSettingsLib pracData) throws IOException{

	boolean returnValue=true;
		//int possition=0;		
		
		
		//if number of programs not exist more than ten means, text box will not be appear.
		
		if((getText(selenium, btnpracticesearch)).equalsIgnoreCase("Search")){
			
			assertTrue(type(selenium,txtpracticebox,pracData.practiceName ),"Could not click on System settings link:" + pracData .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnpracticesearch),"Could not click on System settings link:" + pracData .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lblPracticeListItem),"Could not click on System settings link:" + pracData .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			return returnValue;

		}
		else{
			
			String proCount=getText(selenium,lnkSecPractices1);
			int progCount=Integer.parseInt(proCount.replaceAll(".*\\(|\\).*", ""));					
			for(int count=1;count<=progCount;count++){
				
				if(getText(selenium,"//div[4]/div/div[2]/table/tbody/tr["+count+"]/td/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){		
					
					assertTrue(click(selenium,"//div[4]/div/div[2]/table/tbody/tr["+count+"]/td/div"),"Could not click on System settings link:",selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					return returnValue;
				}
			}
			
		}
			assertTrue(click(selenium,chkIncludeInactivePractice),"Could not click on System settings link:" + pracData .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			int count = 1;
			while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td")){
				System.out.println(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td"));
				System.out.println(pracData.practiceName);
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){
					assertTrue(click(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td"),"Could not click on System settings link:" + pracData .toString(),selenium,ClassName,MethodName);
					return returnValue;
				}else
					count ++;
				}
			
			return false;
}
	public boolean addAssociateProvider(Selenium selenium,SystemSettingsLib pracData) throws IOException{
		
		pracData.workSheetName = "AssociateProvider";
		pracData.testCaseId = "TC_PRO_001";
		pracData.fetchSystemSettingTestData();	

		boolean returnValue=true;
		
		if(!(getText(selenium, lblPractice2)).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.aprovider1.trim().toLowerCase(new java.util.Locale("en","US")))){
			assertTrue(click(selenium,btnAddProvider),"Could not click on add button:" + pracData .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtPracticeProviderSearch,pracData.aprovider1),"Could not type in the search box",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnSearchAssociate),"Could not click the search button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			click(selenium,rdGlobalHealth);
			assertTrue(click(selenium,btnPRSave),"Could not click the save button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		
		if(!(getText(selenium, lblPractice2)).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.aprovider2.trim().toLowerCase(new java.util.Locale("en","US")))){
			assertTrue(click(selenium,btnAddProvider),"Could not click on add button:" + pracData .toString(),selenium,ClassName,MethodName); 
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtPracticeProviderSearch,pracData.aprovider2),"Could not type in the search box",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnSearchAssociate),"Could not click the search button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			click(selenium,rdGlobalHealth);
			assertTrue(click(selenium,btnPRSave),"Could not click the save button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		
		if(!(getText(selenium, lblPractice2)).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.aprovider3.trim().toLowerCase(new java.util.Locale("en","US")))){
			assertTrue(click(selenium,btnAddProvider),"Could not click on add button:" + pracData .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtPracticeProviderSearch,pracData.aprovider3),"Could not type in the search box",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnSearchAssociate),"Could not click the search button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			click(selenium,rdGlobalHealth);
			assertTrue(click(selenium,btnPRSave),"Could not click the save button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		if(!(getText(selenium, lblPractice2)).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.aprovider4.trim().toLowerCase(new java.util.Locale("en","US")))){
			assertTrue(click(selenium,btnAddProvider),"Could not click on add button:" + pracData .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtPracticeProviderSearch,pracData.aprovider4),"Could not type in the search box",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnSearchAssociate),"Could not click the search button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			click(selenium,rdGlobalHealth);
			assertTrue(click(selenium,btnPRSave),"Could not click the save button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		
		if(!(getText(selenium, lblPractice2)).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.aprovider5.trim().toLowerCase(new java.util.Locale("en","US")))){
			assertTrue(click(selenium,btnAddProvider),"Could not click on add button:" + pracData .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtPracticeProviderSearch,pracData.aprovider5),"Could not type in the search box",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnSearchAssociate),"Could not click the search button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			click(selenium,rdGlobalHealth);
			assertTrue(click(selenium,btnPRSave),"Could not click the save button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		
		if(!(getText(selenium, lblPractice2)).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.aprovider6.trim().toLowerCase(new java.util.Locale("en","US")))){
			assertTrue(click(selenium,btnAddProvider),"Could not click on add button:" + pracData .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtPracticeProviderSearch,pracData.aprovider6),"Could not type in the search box",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnSearchAssociate),"Could not click the search button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			click(selenium,rdGlobalHealth);
			assertTrue(click(selenium,btnPRSave),"Could not click the save button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		
		if(!(getText(selenium, lblPractice2)).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.aprovider7.trim().toLowerCase(new java.util.Locale("en","US")))){
			assertTrue(click(selenium,btnAddProvider),"Could not click on add button:" + pracData .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtPracticeProviderSearch,pracData.aprovider7),"Could not type in the search box",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnSearchAssociate),"Could not click the search button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			click(selenium,rdGlobalHealth);
			assertTrue(click(selenium,btnPRSave),"Could not click the save button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		
		if(!(getText(selenium, lblPractice2)).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.aprovider8.trim().toLowerCase(new java.util.Locale("en","US")))){
			assertTrue(click(selenium,btnAddProvider),"Could not click on add button:" + pracData .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtPracticeProviderSearch,pracData.aprovider8),"Could not type in the search box",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnSearchAssociate),"Could not click the search button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			click(selenium,chkChartCheckBox1);
			assertTrue(click(selenium,btnPRSave),"Could not click the save button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		
		return returnValue;
	}
}


