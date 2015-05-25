package com.nexia.selenium.testscripts.section.demographics.Cases;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyListFeatureForCases extends AbstractHomeTest{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying the list feature of the cases")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewCasesForPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLib casesData = new HomeLib();
		casesData.workSheetName = "NewCases";
		casesData.testCaseId = "TC_NC_008";
		casesData.fetchHomeTestData();
		verifyListFeatureCases(seleniumHost, seleniumPort, browser, webSite, userAccount, casesData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verifying the list feature of the cases
	* @action 		  verifying the list feature of the cases
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      Augest 09, 2012
	***************************************************************************************************/
	public boolean verifyListFeatureCases(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib casesData) throws Exception{
		
		Selenium selenium = null;	
		boolean returnValue=true;
		try{	
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + casesData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, casesData.userName, casesData.userPassword),"Login Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,casesData.switchRole),"Could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			searchPatientNexia(selenium,casesData.patientID);
		
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Cases and deleting existing Cases             //
			//--------------------------------------------------------------------//
			assertTrue(goToCases(selenium), "Could not navigate to Cases Page", selenium, ClassName, MethodName);
			assertTrue(deleteAllCases(selenium), "Could not delete cases", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  step-4:Verify the list feature is invisible for empty page		  //
			//--------------------------------------------------------------------//
			if(!isElementPresent(selenium, lnkExpandAll)){
				assertTrue(getText(selenium, lblNoDetailsAdded).equalsIgnoreCase("No cases added."),"Expand all is present in contact summary Page after deleted the existing contacts", selenium, ClassName, MethodName);
				returnValue = true;
			}
			//--------------------------------------------------------------------//
			//  Step-5: Create a new case                                         //
			//--------------------------------------------------------------------//
			assertTrue(goToAddCase(selenium),"Could not Navigate to Add Cases Button : "+ casesData.toString(), selenium, ClassName, MethodName);
			assertTrue(createCases(selenium,casesData,userAccount),"Cases creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			HomeLib caseData = new HomeLib();
			caseData.workSheetName = "NewCases";
			caseData.testCaseId = "TC_NC_002";
			caseData.fetchHomeTestData();
		
			//--------------------------------------------------------------------//
			//  Step-6: Create a new case                                         //
			//--------------------------------------------------------------------//
			assertTrue(goToAddCase(selenium),"Could not Navigate to Add Cases Button : "+ casesData.toString(), selenium, ClassName, MethodName);
			assertTrue(createCases(selenium,caseData,userAccount),"Cases creation Failed", selenium, ClassName, MethodName);
		
			//----------------------------------------------------------------------------------//
			//  Step-7: Verifying whether collapse all link exist after clicking Expand all link //
			//----------------------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkExpandAll),"Could not click Expand All button", selenium, ClassName, MethodName);
			if(isElementPresent(selenium,lnkCollapseAll)){
				returnValue=true;
			}else{
				Assert.fail("Expand All Button found");
				return false;
			}
			waitForPageLoad(selenium);
			assertTrue(deleteAllCases(selenium), "Could not delete cases", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-8: Create a new case                                         //
			//--------------------------------------------------------------------//
			assertTrue(goToAddCase(selenium),"Could not Navigate to Add Cases Button : "+ casesData.toString(), selenium, ClassName, MethodName);
			assertTrue(createCases(selenium,casesData,userAccount),"Cases creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkExpandAll),"Expand All Button found", selenium, ClassName, MethodName);
				returnValue=true;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}