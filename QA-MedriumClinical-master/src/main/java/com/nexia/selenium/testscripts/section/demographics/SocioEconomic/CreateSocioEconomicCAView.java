/*************************************************************************************************** 
* @purpose Testcase to create the verify the Socio Economic for a patient in the Canada Account
* @Specification  SRS_REG_Patient Details_Socio Economic_Rev0.2 Ver 1.11 (Jan2, 2013) update
* @action Input user patient in all the Socio Economic fields
* @expected Socio Economic date of patient is successfully saved
* 
* @author       ASPIRE 
* @state        Ready for Approved
* @useraccount  Canada
***************************************************************************************************/

package com.nexia.selenium.testscripts.section.demographics.SocioEconomic;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class CreateSocioEconomicCAView extends AbstractHomeTest{
	
	@Test(groups = {"AdvancedSmokeCA","RegressionCA","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient socio economic")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewSocioEconomicCAView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib sEconomicData = new HomeLib();
		sEconomicData.workSheetName = "NewPatientCheckInCAView";
		sEconomicData.testCaseId = "TC_NPC_001";
		sEconomicData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createNewSocioEconomicCAView(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Create Socio Economic
	* @action 		  verifying Create Socio Economic
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      June 20, 2012
	***************************************************************************************************/
	public boolean createNewSocioEconomicCAView(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib sEconomicData) throws InterruptedException, IOException{
		Selenium selenium=null;
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
			//  Step-3: Navigate to system setting 								  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkSettings),"Could not click on the quick action link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSetting),"Could not click the systemSettings link;More Deatils:",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Delete All Mandatory data  								  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click admin Mandatory", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllMandatory(selenium), "Could not delete all mandatory fields", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Create a patient  //
			//--------------------------------------------------------------------//
			click(selenium,btnBackButton);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkQuickLink),"Could not click on quick action", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkRegisterPatient),"Could not click the Register Patient;More Deatils:"+sEconomicData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(createNewPatientWithMandatoryCAView(selenium,sEconomicData,userAccount),"Patient Checkin Failed", selenium, ClassName, MethodName);	
			
			click(selenium,lnkSocioEconomics);
			waitForPageLoad(selenium);
		
			sEconomicData.workSheetName = "SocioEconomicCAView";
			sEconomicData.testCaseId = "TC_SEV_001";
			sEconomicData.fetchHomeTestData();
			
			//---------------------------------------------------------- ----------//
			//  Step-6: Create a new Socio-EconomicCAView for a patient 		   //
			//---------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit),"Could not Click on create Button:"+ sEconomicData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createSocioEconomicCAView(selenium,sEconomicData),"Socio-Economic creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,btnEdit);
			assertTrue(click(selenium,btnEdit),"Could not Click on create Button:"+ sEconomicData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verifying Entered Details are saved properly  			  //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesCreateSocioEconomicsCA(selenium,sEconomicData)){
				Assert.fail("Socio-Economic details not saved properly; More Details :"+ sEconomicData.toString());
				returnValue=false;
			}else
				returnValue=true;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;	
	}
}
