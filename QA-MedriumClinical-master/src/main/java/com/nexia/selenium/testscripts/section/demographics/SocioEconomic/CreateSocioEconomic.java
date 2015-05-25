/*************************************************************************************************** 
* @purpose Testcase to create the verify the Socio Economic for a patient in the US Account
* @Specification  SRS_REG_Patient Details_Socio Economic_Rev0.2 
* @action Input user patient in all the Socio Economic fields
* @expected Socio Economic date of patient is successfully saved
* 
* @author       ASPIRE
* @state        Ready for Approved
* @useraccount  US
***************************************************************************************************/

package com.nexia.selenium.testscripts.section.demographics.SocioEconomic;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;
			
public class CreateSocioEconomic extends AbstractHomeTest {
	
	@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient socio economic")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewSocioEconomicForPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib sEconomicData = new HomeLib();
		sEconomicData.workSheetName = "NewPatientCheckIn";
		sEconomicData.testCaseId = "TC_NPC_001";
		sEconomicData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createNewSocioEconomic(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Create Socio Economic
	* @action 		  verifying Create Socio Economic
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Apr 02, 2012
	***************************************************************************************************/
	public boolean createNewSocioEconomic(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib sEconomicData) throws Exception{
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
			waitForPageLoad(selenium);
			assertTrue(createNewPatientWithMandatory(selenium,sEconomicData),"Patient Checkin Failed", selenium, ClassName, MethodName);	
			
			click(selenium,lnkSocioEconomics);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-5: Create a new Socio-Economic for a patient //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit),"Could not Click on edit Button:"+ sEconomicData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			sEconomicData.workSheetName = "NewSocioEconomic";
			sEconomicData.testCaseId = "TC_SE_001";
			sEconomicData.fetchHomeTestData();
			
			assertTrue(createSocioEconomic(selenium,sEconomicData, userAccount),"Socio-Economic creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,btnEdit);
			assertTrue(click(selenium,btnEdit),"Could not Click on create Button:"+ sEconomicData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue( verifyStoredValuesCreateSocioEconomics(selenium,sEconomicData, userAccount),
					"Socio-Economic details not saved properly; More Details :"+ sEconomicData.toString(), selenium, ClassName, MethodName);
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
