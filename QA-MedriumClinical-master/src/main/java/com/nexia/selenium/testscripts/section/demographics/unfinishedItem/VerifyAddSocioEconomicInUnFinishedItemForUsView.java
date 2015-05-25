package com.nexia.selenium.testscripts.section.demographics.unfinishedItem;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAddSocioEconomicInUnFinishedItemForUsView extends AbstractHomeTest{
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient socio economic")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewSocioEconomicForPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib sEconomicData = new HomeLib();
		sEconomicData.workSheetName = "NewPatientCheckIn";
		sEconomicData.testCaseId = "TC_NPC_001";
		sEconomicData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createNewSocioEconomicForUsView(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Create Socio Economic For Us View 
	* @action 		  verifying Create Socio Economic For Us View 
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      July 11, 2013
	***************************************************************************************************/
	public boolean createNewSocioEconomicForUsView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib sEconomicData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		String currentUnfinishedItem="Edit Socio-Economics for";
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
			//  Step-3: Delete all unfinished item                                //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllUnfinishedItem(selenium),"Could not Delete all unfinished item  :"+ sEconomicData.toString(), selenium, ClassName, MethodName);
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
			sEconomicData.testCaseId = "TC_SE_006";
			sEconomicData.fetchHomeTestData();
			
			assertTrue(createSocioEconomic(selenium,sEconomicData, userAccount),"Socio-Economic creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6 Store data in unfinished item							  //
			//--------------------------------------------------------------------//
			assertTrue(storeDataInUnfinishedItem(selenium),"Could not Store data in unfinished item; More Details :"+ sEconomicData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to unfinished item							  //
			//--------------------------------------------------------------------//
			//get the current patient name
			String patientName[]= getText(selenium, lblPatientName).split(",");
			
			//customize the patient name for our need
			String patientNameAltered= patientName[1] +" "+ patientName[0];
			
			//append the patient name with the current unfinished item section
			currentUnfinishedItem= currentUnfinishedItem + patientNameAltered ;
			
			assertTrue(navigateToUnfinishedItem(selenium,currentUnfinishedItem),"Could not Navigate to unfinished item; More Details :"+ sEconomicData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-8: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesCreateSocioEconomics(selenium,sEconomicData, userAccount)){
				Assert.fail("Socio-Economic details not saved properly; More Details :"+ sEconomicData.toString());
				returnValue=false;
			}
			assertTrue(click(selenium,btnSave),"Could not Click on create Button:"+ sEconomicData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!isElementPresent(selenium,btnEdit)){
				Assert.fail("Socio-Economic details not saved properly; More Details :"+ sEconomicData.toString());
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
