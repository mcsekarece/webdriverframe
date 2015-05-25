package com.nexia.selenium.testscripts.section.demographics.HealthCareTeam;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.thoughtworks.selenium.Selenium;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;

public class UnitTestNewPatientCheckinHealthCareTeam extends AbstractHomeTest{
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Search With Invaild Member")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithInvaildMember(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException, InterruptedException{
		HomeLibUnitTest healthTestData = new  HomeLibUnitTest();
		healthTestData.workSheetName = "UnitTest_FV_PC_HealthCareTeam";
		healthTestData.testCaseId = "TC_HCT_001";
		healthTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addHealthCare(seleniumHost, seleniumPort, browser, webSite, userAccount, healthTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "End date is empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endDateEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest healthTestData = new  HomeLibUnitTest();
		healthTestData.workSheetName = "UnitTest_FV_PC_HealthCareTeam";
		healthTestData.testCaseId = "TC_HCT_002";
		healthTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, healthTestData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "End date is invalid")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endDateInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest healthTestData = new  HomeLibUnitTest();
		healthTestData.workSheetName = "UnitTest_FV_PC_HealthCareTeam";
		healthTestData.testCaseId = "TC_HCT_003";
		healthTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, healthTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "End Data with Different Foramt")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endDatawithDifferentForamt(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest healthTestData = new  HomeLibUnitTest();
		healthTestData.workSheetName = "UnitTest_FV_PC_HealthCareTeam";
		healthTestData.testCaseId = "TC_HCT_004";
		healthTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, healthTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "End After Number With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endAfterNumberWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest healthTestData = new  HomeLibUnitTest();
		healthTestData.workSheetName = "UnitTest_FV_PC_HealthCareTeam";
		healthTestData.testCaseId = "TC_HCT_005";
		healthTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, healthTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "End After Number With Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endAfterNumberWithCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest healthTestData = new  HomeLibUnitTest();
		healthTestData.workSheetName = "UnitTest_FV_PC_HealthCareTeam";
		healthTestData.testCaseId = "TC_HCT_006";
		healthTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, healthTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "End After Number With Special Character")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endAfterNumberWithSpecialCharacter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest healthTestData = new  HomeLibUnitTest();
		healthTestData.workSheetName = "UnitTest_FV_PC_HealthCareTeam";
		healthTestData.testCaseId = "TC_HCT_007";
		healthTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, healthTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "End After Number With AlphaNumeric")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endAfterNumberWithAlphaNumeric(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest healthTestData = new  HomeLibUnitTest();
		healthTestData.workSheetName = "UnitTest_FV_PC_HealthCareTeam";
		healthTestData.testCaseId = "TC_HCT_008";
		healthTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, healthTestData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "End After Number With Alpha Numeric And Special Char")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void endAfterNumberWithAlphaNumericAndSpecialChar(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest healthTestData = new  HomeLibUnitTest();
		healthTestData.workSheetName = "UnitTest_FV_PC_HealthCareTeam";
		healthTestData.testCaseId = "TC_HCT_009";
		healthTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, healthTestData);
		
	}	

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "End After Number With Alpha Numeric And Special Char")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void roleWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest healthTestData = new  HomeLibUnitTest();
		healthTestData.workSheetName = "UnitTest_FV_PC_HealthCareTeam";
		healthTestData.testCaseId = "TC_HCT_010";
		healthTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, healthTestData);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify Unit Test In Health Care Team
	* @action 		  Verifing Unit Test In Health Care Team
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 23, 2012
	***************************************************************************************************/
	public void addHealthCareTeam(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLibUnitTest healthTestData) throws IOException{
		
		if(userAccount.equalsIgnoreCase(CAAccount)){
			healthTestData.alertCA = healthTestData.alertCA == null ? "" : healthTestData.alertCA.trim();
			healthTestData.alertMessage = healthTestData.alertMessage == null ? "" : healthTestData.alertMessage.trim();
			Assert.assertFalse((healthTestData.alertCA.trim().equals("No") && !(healthTestData.alertMessage.equals(""))) || (healthTestData.alertCA.trim().equals("Yes")) && healthTestData.alertMessage.equals(""),"The Alert Details or Alert Message Details are not proper in the Test Data Sheet; More Details :" + healthTestData.toString());
			
		}
		else{
			
			healthTestData.alert = healthTestData.alert == null ? "" : healthTestData.alert.trim();
			healthTestData.alertMessage = healthTestData.alertMessage == null ? "" : healthTestData.alertMessage.trim();
			Assert.assertFalse((healthTestData.alert.trim().equals("No") && !(healthTestData.alertMessage.equals(""))) || (healthTestData.alert.trim().equals("Yes")) && healthTestData.alertMessage.equals(""),"The Alert Details or Alert Message Details are not proper in the Test Data Sheet; More Details :" + healthTestData.toString());
		}	
		
		Selenium selenium = null;
		try{
			//---------------------------------------------------------- ----------//
			//  Step-1:Login to the Application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);		
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + healthTestData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, healthTestData.userName, healthTestData.userPassword);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,healthTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-3:Create role and reason For deletion at Admin section//
			//--------------------------------------------------------------------//
			//Create role and reason For deletion at Admin section
			HomeLibUnitTest epData = new  HomeLibUnitTest();
			epData.workSheetName = "AdminHealthCareTeam";
			epData.testCaseId = "TC_HCTA_001";
			epData.fetchHomeTestData();
			
			//---------------------------------------------------------- ----------//
			//  Step-4:Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,healthTestData.patientID);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-5:Go to HealthCareTeam//
			//--------------------------------------------------------------------//
			
			click(selenium, lnkPatientHealthcare);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-6:Deleting existing Health Care Team 	//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllHealthCareteams_Unit(selenium,epData),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,btnEdit);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-7:Submit Health Care Team	//
			//--------------------------------------------------------------------//
			assertTrue(submitHealthCareTeam(selenium,healthTestData, epData,userAccount ),"Patient Health care team failed", selenium, ClassName, MethodName);
			
			if(userAccount.equalsIgnoreCase(CAAccount)){
				healthTestData.alertCA = healthTestData.alertCA == null ? healthTestData.alertCA = "" : healthTestData.alertCA.trim();
				if(!healthTestData.alertCA.equals("")){
				assertTrue(isElementPresent(selenium, healthTestData.alertCA), "The validation message field did not appear", selenium, ClassName, MethodName);
				assertTrue(getText(selenium, healthTestData.alertCA).contains(healthTestData.alertMessage), "The expected validation message should contain the text - "+ healthTestData.alertMessage + " The actual validation message shown - " + getText(selenium, healthTestData.alertCA), selenium, ClassName, MethodName);
				
				}
			}
			else{
				healthTestData.alert = healthTestData.alert == null ? healthTestData.alert = "" : healthTestData.alert.trim();
				if(!healthTestData.alert.equals("")){
				assertTrue(isElementPresent(selenium, healthTestData.alert), "The validation message field did not appear", selenium, ClassName, MethodName);
				assertTrue(getText(selenium, healthTestData.alert).contains(healthTestData.alertMessage), "The expected validation message should contain the text - "+ healthTestData.alertMessage + " The actual validation message shown - " + getText(selenium, healthTestData.alert), selenium, ClassName, MethodName);
				}	
			}
		}catch (RuntimeException e) {
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				if(selenium != null){
					if(isElementPresent(selenium,btnErrorClose) && selenium.isVisible(btnErrorClose)){
						click(selenium, btnErrorClose);
						waitForPageLoad(selenium);	
					}
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	}
	

	/*************************************************************************************************** 
	* @purpose        To Verify Unit Test In Health Care Team
	* @action 		  Verifing Unit Test In Health Care Team
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 23, 2012
	***************************************************************************************************/
	public boolean addHealthCare(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLibUnitTest healthTestData) throws InterruptedException, IOException{

		Selenium selenium = null;
		String alertText="";
		boolean returnValue=true;
		try{
			//---------------------------------------------------------- ----------//
			//  Step-1:Login to the Application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);		
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + healthTestData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, healthTestData.userName, healthTestData.userPassword);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,healthTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-3:Create role and reason For deletion at Admin section//
			//--------------------------------------------------------------------//
			HomeLibUnitTest epData = new  HomeLibUnitTest();
			epData.workSheetName = "AdminHealthCareTeam";
			epData.testCaseId = "TC_HCTA_001";
			epData.fetchHomeTestData();
			
			//---------------------------------------------------------- ----------//
			//  Step-4:Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,healthTestData.patientID);
			waitForPageLoad(selenium);

			//---------------------------------------------------------- ----------//
			//  Step-5:Go to HealthCareTeam//
			//--------------------------------------------------------------------//
			click(selenium, lnkPatientHealthcare);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-6:Deleting existing Health Care Team 	//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllHealthCareteams_Unit(selenium,epData),"", selenium, ClassName, MethodName);
			click(selenium,btnEdit);
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-7:Submit Health Care Team	//
			//--------------------------------------------------------------------//
			try {
				if(!healthCareTeam(selenium,healthTestData)&&healthTestData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).contains("yes")){
					if(isElementPresent(selenium,lblHealthCareSearchDisplayedArea)){
						alertText = getText(selenium, lblHealthCareSearchDisplayedArea);
						if(alertText.toLowerCase(new java.util.Locale("en", "US")).startsWith(healthTestData.alertMessage.trim().toLowerCase(new java.util.Locale("en", "US"))))
						{
				   			return returnValue;			
						}else{
							Assert.fail("An unxpected result is displayed; The Expected :"+healthTestData.alertMessage+" ;The Actual:"+alertText + "; More Details :" +healthTestData.toString());
						}
					}else{
						Assert.fail("Search results are not displayed as expected; The Expected :"+healthTestData.alertMessage+" ;The Actual:"+alertText + "; More Details :" +healthTestData.toString());
					}	
				}else if(healthTestData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).equals("no")){
					return returnValue;
				}else{
					Assert.fail("Search results are not displayed as expected:"+healthTestData.alertMessage+" ;The Actual:"+alertText + "; More Details :" +healthTestData.toString());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" +healthTestData.toString());
				returnValue=false;
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean submitHealthCareTeam(Selenium selenium, HomeLibUnitTest healthTestData,HomeLibUnitTest epData, String userAccount)throws IOException{
		try{
			
			selectValueFromAjaxList(selenium,ajkSuggestBox,healthTestData.teamName);
			waitForPageLoad(selenium);
			if(healthTestData.testCaseId.equals("TC_HCT_001")){
				assertTrue(type(selenium,txtSearchTextBox,healthTestData.searchMember),"Could not enter the data in search box;More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSearch),"Could not click the Search button;More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			if(healthTestData.itemCheckBox.equals("Yes")){
			assertTrue(click(selenium,chkCheckBox),"Could not click Item check box ; More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			
					
			if(healthTestData.pcpCheckbox.equals("Yes")){
				assertTrue(click(selenium,"//span[2]/span/input"),"Could not click the pcp check box;More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			}
			if(healthTestData.teamLead.equals("Yes")){
				assertTrue(click(selenium,"//span[2]/input"),"Could not click the Team Lead check box;More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			}
		
			waitForPageLoad(selenium);
			if(healthTestData.duration.equals("End By")){
				selectValueFromAjaxList(selenium,ajkDuration,healthTestData.duration);
				waitForPageLoad(selenium);
				assertTrue(enterDate(selenium,"//div[@id='selectedMemberList']/div/div[2]/div/div/input",healthTestData.endDate),"could not enter the date; More Details :"+healthTestData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"//div[@id='teamRoleSuggestBox_93panel']/input",epData.switchRole);
				click(selenium,ajkValueSelect1);
				waitForPageLoad(selenium);
			}
			else if(healthTestData.duration.equals("End After")){
				selectValueFromAjaxList(selenium,ajkDuration,healthTestData.duration);
				waitForPageLoad(selenium);
				
				assertTrue(type(selenium,"//div[@id='selectedMemberList']/div/div[2]/div/div/input[2]",healthTestData.endNumber),"Could not enther the number : More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
				
				selectValueFromAjaxList(selenium,"//div[2]/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/input",healthTestData.timeperiod);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"//div[2]/div/div/div/div/input",healthTestData.switchRole);
				click(selenium,ajkValueSelect1);
				waitForPageLoad(selenium);
			}
			else if(healthTestData.location.equals(ajxLocation)){
				waitForElementToEnable(selenium,ajxLocation);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxLocation,healthTestData.location);
				waitForPageLoad(selenium);
				selectValueFromAjaxListUsingTypeKeys(selenium,ajxSpeciality,healthTestData.specialty);
			}
			assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" + healthTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
	public boolean healthCareTeam(Selenium selenium, HomeLibUnitTest healthTestData)throws InterruptedException, IOException{
		try{
			selectValueFromAjaxList(selenium,ajkSuggestBox,healthTestData.teamName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtSearchTextBox,healthTestData.searchMember),"Could not enter the data in search box;More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSearch),"Could not click the Search button;More Details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!isElementPresent(selenium,lblHealthCareSearchDisplayedArea)){
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
}
		
	
