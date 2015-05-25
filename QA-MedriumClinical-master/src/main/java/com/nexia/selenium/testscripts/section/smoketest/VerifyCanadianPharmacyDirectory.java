/*************************************************************************************************** 
* @purpose 			This testcase perform Sanity test. Search for a pharmacy using a postal code  to further verify if the data loader has run properly.
* @Specification 	Canadian Pharmacy Mapping and Data 20130201,    
* @action 			Perform the pharmacy search with the postal code  
* @expected  		Verify that the appropriate pharmacy shows up
* 
* @author       Jagmit 
* @state        Developing
* @useraccount  Canada
***************************************************************************************************/

package com.nexia.selenium.testscripts.section.smoketest;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.nexia.selenium.genericlibrary.smoketest.AbstractSmokeTest;
import com.nexia.selenium.genericlibrary.smoketest.SmokeTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCanadianPharmacyDirectory extends AbstractSmokeTest{

	@Test(groups = {"SmokeCA","RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Search Pharmacy with a postal code")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void CanadianPharmacyDirectory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SmokeTestLib searchData = new SmokeTestLib();
		searchData.workSheetName = "SearchPharmacy";
		searchData.testCaseId = "TC_SP_001";
		searchData.fetchSmokeTestData();
		SearchPharmacy(seleniumHost, seleniumPort, browser, webSite, userAccount, searchData);
	}	
	
	
	/**
	 * SearchPharmacy
	 * function to Canadian Search Pharmacy
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    March 13, 2013
	 */
	
	public boolean SearchPharmacy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SmokeTestLib searchData) throws IOException{
	
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + searchData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, searchData.userName, searchData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
									
			searchPatientNexiaForProviderHomePage_smoke(selenium,searchData.patientId);
			waitForPageLoad(selenium);		
			
			//--------------------------------------------------------------------//
			//  Step-3: Add Prescribe Medication		                          //
			//--------------------------------------------------------------------//			
			
					
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			assertTrue(SearchPrescribeMed_smoke(selenium,searchData),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);	
			
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,searchData.reason),"Could not type reason;More Details:"+ searchData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+ searchData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Search Pharmacy					                          //
			//--------------------------------------------------------------------//			
			
			assertTrue(searchPharmacy(selenium,searchData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
				
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Search Pharmacy									  //
			//--------------------------------------------------------------------//
			if(!verifySearchPharmacy(selenium,searchData)){
				Assert.fail("Search Data not available; More Details :"+ searchData.toString());
				returnValue= false;
			}else 
				returnValue=true;
			
		}catch(RuntimeException e){
			
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data");
		}
		return returnValue;
	}
	
	public boolean verifySearchPharmacy(Selenium selenium , SmokeTestLib searchData) throws IOException{
			
		assertTrue(selenium.isTextPresent("Select"), "Select not Present", selenium, ClassName,MethodName);
		assertTrue(selenium.isTextPresent("Tel"), "Tel not Present", selenium, ClassName,MethodName);
		assertTrue(selenium.isTextPresent("Fax"), "Fax not Present",selenium, ClassName,MethodName);	
		return true;
	}
}
