package com.nexia.selenium.testscripts.section.portability;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class CreatePracticePortability extends AbstractSystemSettingsTest{
	
	boolean CreatePractice = false;
	
	@Test(enabled = false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPracticesMainClinic(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_001";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}
	@Test(enabled = false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewPracticesNexiaPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_002";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}
	@Test(enabled = false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewPracticesCatherineKids(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_003";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}
	@Test(enabled = false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewPracticesStagePractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_004";
		pracData.fetchSystemSettingTestData();	
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}
	@Test(enabled = false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewPracticesCFDS(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_005";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}
	@Test(enabled = false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewSchedulingPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_006";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}
	@Test(enabled = false)
	//@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewAPbPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_007";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}
	@Test(enabled = false)
	//@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Practice")
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
			assertTrue(gotoSystemSetting(selenium),"Couldn't go to system settings",selenium,ClassName,MethodName);
		    waitForPageLoad(selenium);				
				
	        //----------------------------//
			//  Step-3: Search Practice    //
			//----------------------------//
			if(searchCurrentPractice(selenium,pracData, userAccount))
				createPracticesWithMandatory(selenium,pracData,userAccount);
			else
				System.out.println("Practice with name " + pracData.practiceName + " is already created");				
				}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString());
			}
		return returnValue;
	}	
	
	
	
	public boolean searchCurrentPractice(Selenium selenium,SystemSettingsLib pracData, String account) throws IOException{
		boolean returnValue=true;
		int possition=1;		
		assertTrue(click(selenium,chkIncludeInactivescheckbox),"Could not click on System settings link:" + pracData .toString(),selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		//if number of programs not exist more than ten means, text box will not be appear.
		if((getText(selenium, btnSearchButton)).equalsIgnoreCase("Search")){
			assertTrue(type(selenium,btnSearchTextBox,pracData.practiceName ),"Could not click on System settings link:" + pracData .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSearchButton),"Could not click on System settings link:" + pracData .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
		}
		else{
			//So, We use loop to find the position of program in the displayed list
			String proCount=getText(selenium,"//td[2]/div/div/div/div[2]/div/div/div/div/span/span/span");
			int progCount=Integer.parseInt(proCount.replaceAll(".*\\(|\\).*", ""));					
			for(int count=1;count<=progCount;count++){
				
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){		
					
					possition=count;							
					break;
				}
			}
		}
		
		//after finding possition, verify the practice name
		if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+possition+"]/td/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){
			//to check the practice name active/in active
			if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+possition+"]/td/div").toLowerCase(new java.util.Locale("en","US")).trim().contains("Inactive".trim().toLowerCase(new java.util.Locale("en","US")))){
				assertTrue(click(selenium,"//div[@id='practices']/table/tbody/tr["+possition+"]/td[2]/div/a"),"Could not click on activate link:" + pracData .toString(),selenium,ClassName,MethodName);
			
			}
			if(getText(selenium, "//div[@id='practices']/table/tbody/tr["+possition+"]/td[2]/div/a").equalsIgnoreCase("Delete")){
				//Verify presence of Location's
				assertTrue(click(selenium,"//div[@id='practices']/table/tbody/tr["+possition+"]/td/div"),"Could not click on practice:" + pracData .toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);	
				
				if(pracData.testCaseId.equals("TC_CPR_002")){
					System.out.println(getText(selenium, "//td[2]/div/div/div/div/div"));
					if(!(getText(selenium, "//td[2]/div/div/div/div/div").contains(pracData.locationName1))&&
							(getText(selenium, "//td[2]/div/div/div/div/div").contains(pracData.locationName2))){
						assertTrue(addLocationPortability(selenium,pracData,account),"Practice Creation Failed",selenium,ClassName,MethodName);
						waitForPageLoad(selenium);
					}
				}else{
					if(!((getText(selenium, lblResultPractice).contains(pracData.locationName1)))){
						assertTrue(addLocationPortability(selenium,pracData,account),"Practice Creation Failed",selenium,ClassName,MethodName);
						waitForPageLoad(selenium);
					}
				}
				returnValue=false;
			}
			else{
				returnValue = true;
			}
		}					
		
		return returnValue;
	}
	
	
	/**
	 * createPracticesWithMandatory
	 * function to createPractices
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    July 31, 2012
	 */
	
	public boolean createPracticesWithMandatory(Selenium selenium, SystemSettingsLib pracData,String account) throws Exception{
					
			boolean returnValue=true;
			try{
			
				//--------------------------------------------------------------------//
				//  Step-5: Add Practice//
				//--------------------------------------------------------------------//
			
				assertTrue(addPracticeWithMandatoryPortability(selenium,pracData,account),"Practice Creation Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-6: Verify the stored internal programs						//
				//--------------------------------------------------------------------//
				if(!verifyStoredValuesForMandatory(selenium,pracData,account)){
					Assert.fail("Practice details not saved properly; More Details :"+ pracData.toString());
					returnValue=false;
				}
			
				
			}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString());
			}
			return returnValue;
		}
	
	public boolean verifyStoredValuesForMandatory(Selenium selenium,SystemSettingsLib pracData,String account) throws IOException{
		assertTrue(click(selenium,btnEdit1),"Could not click the edit button",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		if(!getValue(selenium,btnPracticeName).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,btnTaxId).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.taxId.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtAddr1).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.address1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtAddr2).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.address2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtCity).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.city.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(account.equals(CAAccount)){
			if(!getValue(selenium,ajxStateSuggestBoxSuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.stateCA.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,txtZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.zipcodeCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}else{
			if(!getValue(selenium,ajxStateSuggestBoxSuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.state.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		
			if(!getValue(selenium,txtZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.zipcode.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		if(!getValue(selenium,ajxStateCountryBoxSuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.country.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}


