package com.nexia.selenium.testscripts.section.demographics.Identifiers;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;
public class CreateIdentifiers extends AbstractHomeTest{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying create Identifier")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewIdentifiers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib identifierTestData = new HomeLib();
		identifierTestData.workSheetName = "CreateIdentifiers";
		identifierTestData.testCaseId = "TC_ID_001";
		identifierTestData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createIdentifier(seleniumHost, seleniumPort, browser, webSite, userAccount, identifierTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify create Identifier
	* @action 		  verifying create Identifier
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 27, 2012
	***************************************************************************************************/
	public boolean createIdentifier(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib identifierData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = false;
		
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
			//  Step-3: Create Identifer Group and Type at Admin section  //
			//--------------------------------------------------------------------//
			
			/*waitForPageLoad(selenium);
			click(selenium,lnkSystemSetting);
			waitForPageLoad(selenium);
			
			identifierData.workSheetName = "IdentifiersAdmin";
			identifierData.testCaseId = "TC_IDA_001";
			identifierData.fetchHomeTestData();
			assertTrue(click(selenium,lnkIdentifierGroup),"Could not click on Identifier Group link:" + identifierData .toString());
			waitForPageLoad(selenium); 
			
			assertTrue(deleteAllIdentifiersGroup(selenium));
			waitForPageLoad(selenium);
			
			assertTrue(createIdGroup(selenium,identifierData),"Identifier Groups Creation failed");
			waitForPageLoad(selenium);
				
			assertTrue(createIdType(selenium,identifierData),"Identifier Types Creation failed");
			waitForPageLoad(selenium);
			click(selenium,btnBackButton);
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID  //
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,identifierData.patientID);
			waitForPageLoad(selenium);
			click(selenium,lnkIdentifier);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Deleting existing identifier for the selected patient  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllIdentifiers(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Create a new Identifier //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddIdentifier),"Could not click on Add Identifers Button:"+identifierData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createIdentifierCAView(selenium,identifierData,userAccount),"identifier creation failed", selenium, ClassName, MethodName);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			String date=DateFormat.format(cal.getTime());
			
			DateFormat=new SimpleDateFormat("HH");
			String time=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			
			assertTrue(verifyTimeStamp(selenium, lblDateIdentifier, date, time),"", selenium, ClassName, MethodName);
			click(selenium,lnkEditIdentifier);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesIdentifier(selenium,identifierData,userAccount)){
				Assert.fail("Identifier details not saved properly; More Details :"+ identifierData.toString());
				returnValue=true;
			}else{
				return returnValue;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}		
}
