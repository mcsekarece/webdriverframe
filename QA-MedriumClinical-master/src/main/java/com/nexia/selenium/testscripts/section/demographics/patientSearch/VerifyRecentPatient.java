package com.nexia.selenium.testscripts.section.demographics.patientSearch;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyRecentPatient extends AbstractHomeTest {
    @Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify recent patient search with 10 patients")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyRecentPatientSearch(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "PatientData";
		PatientData.testCaseId = "TC_NPC_001";
		PatientData.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);	
		

	}	
    	
    /*************************************************************************************************** 
	* @purpose        To verify recent patient search list
	* @action         Verifying create new contact
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	  Feb 22, 2010
	***************************************************************************************************/
    	
	public boolean checkPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib PatientData) throws Exception{
		Selenium selenium = null;
		String patientArray[]={"MATHEWAAB","MATHEWAAC","MATHEWAAD","MATHEWAAE","MATHEWAAF","MATHEWAAG","MATHEWAAH","MATHEWAAI","MATHEWAAJ","MATHEWAAK"};
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + PatientData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, PatientData.userName, PatientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search for 10 Patients//
			//--------------------------------------------------------------------//
		
			assertTrue(switchRole(selenium,PatientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			searchPatientNexia(selenium,PatientData.firstName);
			waitForPageLoad(selenium);
			int i =  0;
			
			while(i<=9){
			    searchPatientNexia(selenium,patientArray[i]);
			    waitForPageLoad(selenium);
			    waitForPageLoad(selenium);
			    i++;
			}
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify Recent Patients//
			//--------------------------------------------------------------------//
		
			assertTrue(click(selenium,lnkShowRecentPatient),"Could not find Show recent patient link", selenium, ClassName, MethodName);
			
			int count=1,iter=9;
			while(isElementPresent(selenium,"//div/div["+count+"]/div/div/table/tbody/tr/td[2]")){
			    if(!getText(selenium,"//div/div["+count+"]/div/div/table/tbody/tr/td[2]").toLowerCase(new java.util.Locale("en","Us")).trim().contains(patientArray[iter].toLowerCase(new java.util.Locale("en","Us")).trim())){
				break;
			    }
			    count++;
			    iter--;
			}
			  
			if(isElementPresent(selenium,"//div/div["+count+"]/div/div/table/tbody/tr/td[2]")){
			    Assert.fail("Only 10 patients should get displayed in show recent patient's list");
			}
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
