package com.nexia.selenium.testscripts.section.portability;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class CreateAdminPracticePortability extends AbstractSystemSettingsTest {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability" , "BeforeLocation"}, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPracticesMainClinic(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_001";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability" , "BeforeLocation"}, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewPracticesNexiaPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_002";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability" , "BeforeLocation"}, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewPracticesCatherineKids(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_003";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability" , "BeforeLocation"}, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewPracticesStagePractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_004";
		pracData.fetchSystemSettingTestData();	
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability" , "BeforeLocation"}, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewPracticesCFDS(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_005";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability" , "BeforeLocation"}, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewSchedulingPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_006";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}

	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default", "BeforeUserPortability" , "BeforeLocation"}, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewAPbPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_007";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}

	@Test(groups = {"Regression","review","firefox", "iexplore", "safari", "default", "BeforeUserPortability" , "BeforeLocation"}, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewAllDataSharePractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_008";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}

	@Test(groups = {"Regression","review","firefox", "iexplore", "safari", "default", "BeforeUserPortability" , "BeforeLocation"}, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewAllMedicalSummarySharePractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_009";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}

	@Test(groups = {"Regression","review","firefox", "iexplore", "safari", "default", "BeforeUserPortability" , "BeforeLocation"}, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewRestrictedPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_010";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}
	@Test(groups = {"Regression","review","firefox", "iexplore", "safari", "default", "BeforeUserPortability" , "BeforeLocation"}, description = "Test for Adding a Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewRestrictedPracticeforEncounterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "PortPractice";
		pracData.testCaseId = "TC_CPR_011";
		pracData.fetchSystemSettingTestData();		
		checkPractices(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);	
	}
	/*************************************************************************************************** 
	 * @purpose        To Verify create Admin Practices
	 * @action 		  Verifying create Admin Practices
	 * @author         Aspire QA
	 * @throws 		  IOException 
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	      Sep 06, 2013
	 ***************************************************************************************************/
	public boolean checkPractices(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application 								  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pracData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, pracData.userName, pracData.userPassword),
					"Login Failed", selenium, ClassName, MethodName);			

			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Practices			  //
			//--------------------------------------------------------------------//
			assertTrue(gotoSystemSetting(selenium), "Not able to navigate to System Settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				

			//--------------------------------------------------------------------//
			//  Step-3: Search Practice    										  //
			//--------------------------------------------------------------------//
			if(searchCurrentPractice(selenium,pracData, userAccount))
				createAdminPracticesWithMandatory(selenium,pracData,userAccount);
			else
				System.out.println("Practice with name " + pracData.practiceName + " is already created");				

		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue( false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString()
					, selenium, ClassName, MethodName);
		}
		return returnValue;
	}	


	public boolean searchCurrentPractice(Selenium selenium,SystemSettingsLib pracData, String account) throws IOException{
		boolean returnValue=true;
		int possition=1;		
		assertTrue(click(selenium, chkIncludeInactivePractice),
				"Could not click on inactive check box:" + pracData .toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//if number of programs not exist more than ten means, text box will not be appear.
		//FIXME MNT-1369 
		if((selenium.isVisible(btnpracticesearch))){
			assertTrue(type(selenium,txtpracticebox,pracData.practiceName ),
					"Could not click on Search box:" + pracData .toString(),selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);
			//FIXME MNT-1369 
			assertTrue(click(selenium,btnpracticesearch),"Could not click on  Search button:" + pracData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		else{
			//So, We use loop to find the position of program in the displayed list
			//String proCount=getText(selenium,lblProgram);
			String proCount=getText(selenium,"practiceCount");
			int progCount=Integer.parseInt(proCount.replaceAll(".*\\(|\\).*", ""));					
			for(int count=1;count<=progCount;count++){
				if(getText(selenium,lblPracticeListItem + "[" +count+ "]").toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){
					possition=count;							
					break;
				}
			}
		}

		//after finding position, verify the practice name
		if(getText(selenium,lblPracticeListItem + "[" +possition+ "]").toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){
			//to check the practice name active/in active			
			if(getText(selenium,lblPracticeListItem + "[" +possition+ "]").toLowerCase(new java.util.Locale("en","US")).trim().contains("Inactive".trim().toLowerCase(new java.util.Locale("en","US")))){
				assertTrue(click(selenium,"//div[@id='practices']/table/tbody/tr["+possition+"]/td[2]/div/a"),"Could not click on activate link:" + pracData .toString(),selenium, ClassName, MethodName);				
				waitForPageLoad(selenium);	
			}
			if(getText(selenium, "//div[@id='practices']/table/tbody/tr["+possition+"]/td[2]/div/a").equalsIgnoreCase("Delete")){			
				//Verify presence of Location's
				assertTrue(click(selenium,lblPracticeListItem + "[" +possition+ "]"),"Could not click on practice:" + pracData .toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	

				String practiceMaininfo = getText(selenium,"//div[@class='org-structure-main-item']").toLowerCase();
				System.out.println(practiceMaininfo);
				System.out.println(pracData.locationName1.toLowerCase());
				if(pracData.testCaseId.equals("TC_CPR_002")){
					if(!((practiceMaininfo.toLowerCase().contains(pracData.locationName1.toLowerCase()))
							&&(practiceMaininfo.toLowerCase().contains(pracData.locationName2.toLowerCase()))
							&&(practiceMaininfo.toLowerCase().contains(pracData.locationName3.toLowerCase()))
							&&(practiceMaininfo.toLowerCase().contains(pracData.locationName4.toLowerCase())))){
						assertTrue(addLocationAdminPortability(selenium,pracData,account),"Practice Creation Failed",selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
					}

				}else if(!pracData.testCaseId.equals("TC_CPR_002")){
					if(!((practiceMaininfo.toLowerCase().contains(pracData.locationName1.toLowerCase()))
							&&(practiceMaininfo.toLowerCase().contains(pracData.locationName2.toLowerCase())))){
						assertTrue(addLocationAdminPortability(selenium,pracData,account),"Practice Creation Failed",selenium, ClassName, MethodName);
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

	public boolean createAdminPracticesWithMandatory(Selenium selenium, SystemSettingsLib pracData,String account) throws Exception{

		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-5: Add Practice											  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddPractice),"Could not click the add from practice page",selenium, ClassName, MethodName);
			assertTrue(addAdminPracticeAWithMandatoryPortability(selenium,pracData,account),"Practice Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-6: Verify the stored internal programs					      //
			//--------------------------------------------------------------------//
			assertTrue( verifyStoredValuesForMandatory(selenium,pracData,account),
					"Practice details not saved properly; More Details :"+ pracData.toString(), selenium, ClassName, MethodName);

		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue( false, "Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	public boolean verifyStoredValuesForMandatory(Selenium selenium,SystemSettingsLib pracData,String account) throws IOException{
		assertTrue(click(selenium,btnEdit1),"Could not click the edit button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(getValue(selenium,btnPracticeName).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.practiceName.trim().toLowerCase(new java.util.Locale("en","US"))),
				"Not able to find text " +pracData.practiceName , selenium, ClassName, MethodName);	
		if(!account.equals(CAAccount)){
		assertTrue( getValue(selenium,btnTaxId).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.taxId.trim().toLowerCase(new java.util.Locale("en","US"))),
				"Not able to find text " +pracData.taxId , selenium, ClassName, MethodName);	
		}
		assertTrue( getValue(selenium,txtAddr1).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.address1.trim().toLowerCase(new java.util.Locale("en","US"))),
				"Not able to find text " +pracData.address1 , selenium, ClassName, MethodName);	

		assertTrue( getValue(selenium,txtAddr2).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.address2.trim().toLowerCase(new java.util.Locale("en","US"))),
				"Not able to find text " +pracData.address2 , selenium, ClassName, MethodName);	

		assertTrue( getValue(selenium,txtCity).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.city.trim().toLowerCase(new java.util.Locale("en","US"))),
				"Not able to find text " +pracData.city , selenium, ClassName, MethodName);	

		if(account.equals(CAAccount)){

			assertTrue( getValue(selenium,ajxStateSuggestBoxSuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.stateCA.trim().toLowerCase(new java.util.Locale("en","US"))),
					"Not able to find text " +pracData.stateCA , selenium, ClassName, MethodName);	

			assertTrue( getValue(selenium,txtZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.zipcodeCa.trim().toLowerCase(new java.util.Locale("en","US"))),
					"Not able to find text " +pracData.zipcodeCa , selenium, ClassName, MethodName);	

		}else{			
			assertTrue( getValue(selenium,ajxStateSuggestBoxSuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.state.trim().toLowerCase(new java.util.Locale("en","US"))),
					"Not able to find text " +pracData.state , selenium, ClassName, MethodName);	

			assertTrue( getValue(selenium,txtZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.zipcode.trim().toLowerCase(new java.util.Locale("en","US"))),
					"Not able to find text " +pracData.zipcode , selenium, ClassName, MethodName);
		}

		assertTrue( getValue(selenium,ajxStateCountryBoxSuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(pracData.country.trim().toLowerCase(new java.util.Locale("en","US"))),
				"Not able to find text " +pracData.country , selenium, ClassName, MethodName);	

		return true;
	}
}
