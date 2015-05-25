package com.nexia.selenium.testscripts.section.demographics.Household;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestNewPatientCheckinHousehold extends AbstractHomeTest {
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Search With Invalid Patient Name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithInvalidPatientName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest householdData= new HomeLibUnitTest();
		householdData.workSheetName = "UnitTest_FV_PC_Info_Household";
		householdData.testCaseId = "TC_UHH_001";
		householdData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addHousehold(seleniumHost, seleniumPort, browser, webSite, userAccount, householdData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Search With Invalid Patient ID")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithInvalidPatientID(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest householdData= new HomeLibUnitTest();
		householdData.workSheetName = "UnitTest_FV_PC_Info_Household";
		householdData.testCaseId = "TC_UHH_002";
		householdData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addHousehold(seleniumHost, seleniumPort, browser, webSite, userAccount, householdData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Search With Special Characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest householdData= new HomeLibUnitTest();
		householdData.workSheetName = "UnitTest_FV_PC_Info_Household";
		householdData.testCaseId = "TC_UHH_003";
		householdData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addHousehold(seleniumHost, seleniumPort, browser, webSite, userAccount, householdData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Search With Alpha numeric Characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchWithAlphanumericCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest householdData= new HomeLibUnitTest();
		householdData.workSheetName = "UnitTest_FV_PC_Info_Household";
		householdData.testCaseId = "TC_UHH_004";
		householdData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addHousehold(seleniumHost, seleniumPort, browser, webSite, userAccount, householdData);
	}

	/*************************************************************************************************** 
	* @purpose        To Verify Unit test the Household section
	* @action 		  Verifying Unit test the Household section
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      April 02, 2012
	***************************************************************************************************/
	public boolean addHousehold(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,HomeLibUnitTest householdData) throws IOException{
		
		Selenium selenium = null;	
		String alertText="";
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			// Step-1: Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + householdData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, householdData.userName, householdData.userPassword);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,householdData.switchRole),"",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Search for a patient  //
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,householdData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,lnkHouseHold);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-4: Create House hold for a patient //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddHouseHold),"Could not Click on Add Family Member Button:"+ householdData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:  Enter Test Data and Submit                               //
			//--------------------------------------------------------------------//
			try {
				if(!addHouseholdMember(selenium, householdData)&& householdData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).contains("yes")){
					if(isElementPresent(selenium,lblNoPatientDataFound)){
						alertText = getText(selenium, lblNoPatientDataFound);
						if(alertText.toLowerCase(new java.util.Locale("en", "US")).startsWith(householdData.alertMessage.trim().toLowerCase(new java.util.Locale("en", "US"))))
						{
				   			return returnValue;			
						}else{
							Assert.fail("An unxpected result is displayed; The Expected :"+householdData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + householdData.toString());
						}
					}else{
						Assert.fail("Search results are not displayed as expected; The Expected :"+householdData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + householdData.toString());
					}	
				}else if(householdData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).equals("no")){
					return returnValue;
				}else{
					return returnValue;
					//Assert.fail("Search results are not displayed as expected:"+householdData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + householdData.toString());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + householdData.toString());
				returnValue=false;
			}
		}	
		catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean addHouseholdMember(Selenium selenium, HomeLibUnitTest householdData ) throws InterruptedException, IOException{
		try{
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSearchPatient),"could not click search patients button; More Details:"+householdData.toString(),selenium,ClassName,MethodName);
			assertTrue(type(selenium,txtSearchboxHouseHold,householdData.searchpatient),"Could not enter patientID ; More Details :"+householdData.toString(),selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnSearchHouseHold),"could not click search button; More Details:"+householdData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(!isElementPresent(selenium,lblNoPatientDataFound)){
				waitForPageLoad(selenium);
				return true;
			}
		
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		
		return true;
	}
}




