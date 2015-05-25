package com.nexia.selenium.testscripts.section.demographics.SocioEconomic;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class EditSocioEconomic extends AbstractHomeTest{
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Edit Socio Economic")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editNewSocioEconomicForPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib sEconomicData = new HomeLib();
		sEconomicData.workSheetName = "NewPatientCheckIn";
		sEconomicData.testCaseId = "TC_NPC_011";
		sEconomicData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		editNewSocioEconomic(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicData);
	}	
	
	/*************************************************************************************************** 
	* @purpose        To verify Edit Socio Economic
	* @action 		  verifying Edit Socio Economic
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Apr 02, 2012
	***************************************************************************************************/
	public boolean editNewSocioEconomic(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib sEconomicData) throws Exception{
		Selenium selenium = null;
			
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + sEconomicData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, sEconomicData.userName, sEconomicData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
				
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,sEconomicData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create a patient  //
			//--------------------------------------------------------------------//
			assertTrue(goToNewPatientCheckIn(selenium), "Could not navigate to Patient information page", selenium, ClassName, MethodName);
			assertTrue(createNewPatientWithMandatory(selenium,sEconomicData),"Patient Checkin Failed", selenium, ClassName, MethodName);	
				
			click(selenium,lnkSocioEconomics);
			waitForPageLoad(selenium);
				
			//---------------------------------------------------------- ----------//
			//  Step-5: Create a new Socio-Economic for a patient //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit),"Could not Click on create Button:"+ sEconomicData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			sEconomicData.workSheetName = "NewSocioEconomic";
			sEconomicData.testCaseId = "TC_SE_001";
			sEconomicData.fetchHomeTestData();
				
			assertTrue(createSocioEconomic(selenium,sEconomicData, userAccount),"Socio-Economic creation Failed", selenium, ClassName, MethodName);
				
			//--------------------------------------------------------------------//
			//  Step-6: Edit Socio Economic details //
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,btnEdit),"Could not find edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,btnEdit);
			waitForPageLoad(selenium);
				
			sEconomicData.workSheetName = "NewSocioEconomic";
			sEconomicData.testCaseId = "TC_SE_002";
			sEconomicData.fetchHomeTestData();
		
			assertTrue(editSocioEconomic(selenium,sEconomicData),"Socio-Economic creation Failed", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,btnEdit),"Could not find edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,btnEdit);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesEditSocioEconomics(selenium,sEconomicData)){
				Assert.fail("Edited Socio-Economic details not saved properly; More Details :"+ sEconomicData.toString());
				returnValue=false;
			}else
				return returnValue;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
