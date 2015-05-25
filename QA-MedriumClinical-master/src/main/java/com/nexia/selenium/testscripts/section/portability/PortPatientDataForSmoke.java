package com.nexia.selenium.testscripts.section.portability;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class PortPatientDataForSmoke extends AbstractHomeTest {
	
	boolean CreatePatient = false;	
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewpatient001(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib PatientDataSmoke = new HomeLib();
		PatientDataSmoke.workSheetName = "PatientDataSmoke";
		PatientDataSmoke.testCaseId = "TC_NPC_001";
		PatientDataSmoke.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);	
		

	}		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient002(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_002";
			PatientDataSmoke.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
		
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient003(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_003";
			PatientDataSmoke.fetchHomeTestData();
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
		
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient004(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_004";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			PatientDataSmoke.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient005(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_005";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			PatientDataSmoke.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient006(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_006";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			PatientDataSmoke.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
		
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient007(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_007";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			PatientDataSmoke.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
		
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient008(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_008";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			PatientDataSmoke.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
		
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient009(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_009";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			PatientDataSmoke.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient010(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_010";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			PatientDataSmoke.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient011(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_011";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			PatientDataSmoke.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient012(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_012";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			PatientDataSmoke.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient013(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_013";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			PatientDataSmoke.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient014(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_014";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			PatientDataSmoke.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient015(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_015";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			PatientDataSmoke.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient016(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_016";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			PatientDataSmoke.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient017(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_017";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			PatientDataSmoke.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient018(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_018";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			PatientDataSmoke.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient019(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_019";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			PatientDataSmoke.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
		
		@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient020(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_020";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			PatientDataSmoke.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }
	  
	  	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
		@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
		public void createNewpatient021(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
			HomeLib PatientDataSmoke = new HomeLib();
			PatientDataSmoke.workSheetName = "PatientDataSmoke";
			PatientDataSmoke.testCaseId = "TC_NPC_021";
			ClassName=this.getClass().getName().substring(39);	
			MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
			PatientDataSmoke.fetchHomeTestData();
		checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientDataSmoke);
	  }	
	  	
	public boolean checkPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib PatientDataSmoke) throws Exception{
			Selenium selenium = null;
			boolean returnValue = false;
			CreatePatient=false;
			
			try{
				
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + PatientDataSmoke.toString());
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, PatientDataSmoke.userName, PatientDataSmoke.userPassword),"Login Failed ",selenium,ClassName,MethodName);
				
				//--------------------------------------------------------------------//
				//  Step-2: Advanced search with Patient ID//
				//--------------------------------------------------------------------//
				CreatePatient = searchPatientNexiaForHomePage(selenium,PatientDataSmoke.lastName);
				waitForPageLoad(selenium);		

				if (CreatePatient==true)				
					createNewPatient(selenium,PatientDataSmoke);				
				else				
					System.out.println("Patient with lastname " + PatientDataSmoke.lastName + " is already created");				
				
				}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + PatientDataSmoke.toString());
			}
			return returnValue;
		}	
		
		
		/**
		 * searchPatientNexiaForProviderHomePage
		 * function for Searching a patient in the Nexia application   
		 * @param 		selenium
		 * @param 		patientID (Patient ID to be searched)
		 * @throws IOException 
		 
		 * @since  	    Sep 29, 2012
		 */
		public boolean searchPatientNexiaForHomePage(Selenium selenium,String lastName) throws IOException{
			
			boolean returnValue = false;
			assertTrue(type(selenium,txtSearchPatientBox,lastName),"Could not type patient id",selenium,ClassName,MethodName);
		
			selenium.keyPress(txtSearchPatientBox, "\\9");
			waitForElement(selenium,lblPatientBorderBottom,10000);
			//assertTrue(selenium.isElementPresent(lblPatientBorderBottom),"Search Results are not displayed for the patient with ID :-"+lastName);
			System.out.println(getText(selenium,lblPatientBorderBottom));
			if (!getText(selenium,lblPatientBorderBottom).contains(lastName)){
				returnValue=true;
				System.out.println("Patient with lastName " + lastName + " Not created,  create a new one");
			}else{			
				System.out.println("Patient with lastname " + lastName + " is already created, No More Work");				
				returnValue = false;
			}
			return returnValue;
		}	
			
		
		
		/**
		 * createNewPatient
		 * function to create a New Patient entry
		 * @param 		seleniumHost
		 * @param 		seleniumPort
		 * @param 		browser
		 * @param 		webSite
		 * @since  	     Jan 17, 2013
		 */	
		
		
		public boolean createNewPatient(Selenium selenium, HomeLib PatientDataSmoke) throws Exception{
		
			boolean returnValue = false;
			
			try{				
												
				//--------------------------------------------------------------------//
				//---------------  Step-3: Navigate to system setting   --------------//
				//--------------------------------------------------------------------//	

								
				assertTrue(click(selenium, txtSearchPatientBox),"Could not click patient search",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkQuickActions),"Could not click on the link" + PatientDataSmoke .toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkShowMoreLink),"Could not click the show More link;More Deatils:"+PatientDataSmoke.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkSystemSettingAction),"Could not click the systemSettings link;More Deatils:"+PatientDataSmoke.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				
				//--------------------------------------------------------------------//
				//---------------  Step-4:Delete All Mandatory data   --------------//
				//--------------------------------------------------------------------//	
				assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click admin Mandatory",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(deleteAllMandatory(selenium),"Could not click delete all mandatory field",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//---------------  Step-5: Click New Patient Check-in   --------------//
				//--------------------------------------------------------------------//
				
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy");
				String uniqueName=DateFormat.format(cal.getTime());
				
				
				click(selenium,btnBack);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkQuickActions),"Could not click on the link" + PatientDataSmoke .toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkRegisterPatient),"Could not click the Register Patient;More Deatils:"+PatientDataSmoke.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				//assertTrue(createPatient(selenium,PatientDataSmoke),"Patient Checkin Failed");	
				assertTrue(createNewPatientWithMandatory(selenium,PatientDataSmoke),"Patient Checkin Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(selenium.isAlertPresent()){
					Assert.assertFalse(selenium.isAlertPresent(),"Patient not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
				}
				
				if(!verifyStoredValuesinSummaryPage(selenium,PatientDataSmoke)){
					Assert.fail("Patient details are not saved properly; More Details :"+ PatientDataSmoke.toString());
					returnValue=false;
				}
				else{
					 returnValue=true;
				}
					waitForPageLoad(selenium);
					click(selenium,btnRegistrationEdit);
					waitForPageLoad(selenium);
					
				//--------------------------------------------------------------------//
				//  Step-4: Verifying Entered Details are saved properly  //
				//--------------------------------------------------------------------//
				
				if(!verifyStoredValues(selenium,PatientDataSmoke)){
					Assert.fail("Patient details are not Create properly; More Details :"+ PatientDataSmoke.toString());
					returnValue=false;
				}
				else{
					returnValue=true;
					}
				
				waitForPageLoad(selenium);
				click(selenium,"saveButton");
				waitForPageLoad(selenium);				
				
				
				//assertTrue(goEncounter(selenium),"Could not click the link");
				//waitForPageLoad(selenium);
				
				}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + PatientDataSmoke.toString());
			}
			return returnValue;
		}
		
		public boolean verifyStoredValues(Selenium selenium, HomeLib patientData) {
			
			waitForPageLoad(selenium);
			if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US") ).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			if(!getValue(selenium,txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
					
			
			if(!getValue(selenium,"dob").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.dob.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			
			
			if(!getValue(selenium,"statusSuggestBoxsuggestBox").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
			
			return true;
			}
			
		
		
		public boolean verifyStoredValuesinSummaryPage(Selenium selenium,HomeLib patientData){
			waitForPageLoad(selenium);
		
			waitForPageLoad(selenium);
			
			if(!getText(selenium,"patientName").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getText(selenium,"patientName").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			
			if(!getText(selenium,txtDOB).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.dob.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getText(selenium,lblStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			
			return true;
			
			}
			
}
		