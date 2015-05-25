package com.nexia.selenium.testscripts.section.demographics.Identifiers;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyListFeaturesForIdentifiers extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void featuresForIdentifiers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib identifierTestData = new HomeLib();
		identifierTestData.workSheetName = "CreateIdentifiers";
		identifierTestData.testCaseId = "TC_ID_012";
		identifierTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyListFeaturesForIdentifiers(seleniumHost, seleniumPort, browser, webSite, userAccount, identifierTestData);
	}

	/**
	 * verifyListFeaturesForIdentifiers
	 * function to verify List Features For Identifiers
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	    Aug 06, 2012
	 */	

	public boolean verifyListFeaturesForIdentifiers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib identifierData) throws IOException{
		Selenium selenium = null;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + identifierData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, identifierData.userName, identifierData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,identifierData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Advanced search with Patient ID
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,identifierData.patientID);
			waitForPageLoad(selenium);
			click(selenium,lnkIdentifier);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Deleting  identifier for the selected patient  //
			//--------------------------------------------------------------------//
			int counter =(Integer) selenium.getXpathCount(lnkDeleteIdentifier);
			while(isElementPresent(selenium,"//div[@id='PatientExternalIDList']/table/tbody/tr["+counter+"]/td[3]/div/a")){
				assertTrue(click(selenium,"//div[@id='PatientExternalIDList']/table/tbody/tr["+counter+"]/td[3]/div/a"),"", selenium, ClassName, MethodName);
				click(selenium,btnYesButton);
				waitForPageLoad(selenium);
				counter--;
			}
			
			if(isElementPresent(selenium,lblNoDetailsAdded)){
				return true;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
}
