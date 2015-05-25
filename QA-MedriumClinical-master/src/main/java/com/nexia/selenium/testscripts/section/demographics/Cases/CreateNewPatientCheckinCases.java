package com.nexia.selenium.testscripts.section.demographics.Cases;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class CreateNewPatientCheckinCases extends AbstractHomeTest{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Case")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewCasesForPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		HomeLib casesData = new HomeLib();
		casesData.workSheetName = "NewCases";
		casesData.testCaseId = "TC_NC_001";
		casesData.fetchHomeTestData();
		createNewCases(seleniumHost, seleniumPort, browser, webSite, userAccount, casesData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Case With Termination As Status")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewCasesForPatientWithTerminationAsStatus(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		HomeLib casesData = new HomeLib();
		casesData.workSheetName = "NewCases";
		casesData.testCaseId = "TC_NC_003";
		casesData.fetchHomeTestData();
		createNewCases(seleniumHost, seleniumPort, browser, webSite, userAccount, casesData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verifying a New patient Case
	* @action 		  Verifying a New patient Case
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      April 02, 2012
	***************************************************************************************************/
	public boolean createNewCases(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib casesData) throws Exception{
		String date=null;
		String time=null;
		Selenium selenium = null;	
			
		boolean returnValue=true;
		try{	
			//--------------------------------------------------------------------//
			// Step-1: Login to the application and search for the given patient  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + casesData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, casesData.userName, casesData.userPassword),"Login Failed", selenium, ClassName, MethodName);
		
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role                                         //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,casesData.switchRole),"Could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			searchPatientNexia(selenium,casesData.patientID);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Cases and deleting existing Cases             //
			//--------------------------------------------------------------------//
			assertTrue(goToCases(selenium), "Could not navigate to Cases Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(deleteAllCases(selenium), "Could not delete cases", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			//---------------------------------------------------------- ---------//
			//  Step-4: Create a new case                                         //
			//--------------------------------------------------------------------//
			assertTrue(goToAddCase(selenium),"Could not Navigate to Add Cases Button : "+ casesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createCases(selenium,casesData,userAccount),"Cases creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				 date=DateFormat.format(cal.getTime());
				 DateFormat=new SimpleDateFormat("HH");
				 time=DateFormat.format(cal.getTime());
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				 date=DateFormat.format(cal.getTime());
				DateFormat=new SimpleDateFormat("HH");
				 time=DateFormat.format(cal.getTime());
				}
			/*assertTrue(click(selenium,lnkExpandAll),"Could not click Expand All; More Details :" + casesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(verifyTimeStamp(selenium, lblTimeStamp, date, time),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			*/
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly              //
			//--------------------------------------------------------------------//
			click(selenium,lnkEdit);
			waitForPageLoad(selenium);
			
			assertTrue(verifyStoredValuesCreateCase(selenium,casesData,date,userAccount),"Cases details not saved properly; More Details :"+ casesData.toString(), selenium, ClassName, MethodName);
	       return returnValue;
			}catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + casesData.toString(), selenium, ClassName, MethodName);
				
			}
			return returnValue;
		}
}
