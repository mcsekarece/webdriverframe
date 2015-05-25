package com.nexia.selenium.testscripts.section.portability;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class CreatePatientForPayer extends AbstractHomeTest{

	boolean CreatePatient = false;
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewpatient130(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib patientcaData = new HomeLib();
		patientcaData.workSheetName = "PatientDataCAView";
		patientcaData.testCaseId = "TC_NPC_130";
		patientcaData.fetchHomeTestData();
	    checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	}	
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Adding New Patient If Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewpatient131(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception {
		HomeLib patientcaData = new HomeLib();
		patientcaData.workSheetName = "PatientDataCAView";
		patientcaData.testCaseId = "TC_NPC_131";
		patientcaData.fetchHomeTestData();
	    checkPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, patientcaData);
	}	
	/*************************************************************************************************** 
	* @purpose        To verify Creating Payers Associate with Patient For Portability 
	* @action 		  verifying Creating Payers Associate with PatientPayers For Portability 
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    CA Account
	* @since  	      May 31, 2014
	***************************************************************************************************/
	public boolean checkPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientcaData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = false;
		CreatePatient=false;
		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientcaData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientcaData.userName, patientcaData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForHomePage(selenium,patientcaData.lastName);
			waitForPageLoad(selenium);		

			if (CreatePatient==true)					
			createPatientCA(selenium,patientcaData);
			//createNewPatient(selenium,patientData);				
			else				
			System.out.println("Patient with lastname " + patientcaData.lastName + " is already created");
			
			//--------------------------------------------------------------------//
			//  Step-3: Create Medication  with PatientData //
			//--------------------------------------------------------------------//
			  
			createPayer(selenium,patientcaData,userAccount );
			waitForPageLoad(selenium); 
			
			
			}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientcaData.toString());
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
		waitForPageLoad(selenium);
		if(isElementPresent(selenium, "errorCloseButton"))
			assertTrue(click(selenium, "errorCloseButton"),"Could not click error close button",selenium,ClassName,MethodName);
		
		assertTrue(type(selenium,txtSearchPatientBox,lastName),"Could not type patient id",selenium,ClassName,MethodName);
	
		selenium.keyPress(txtSearchPatientBox, "\\9");
		waitForElement(selenium,lblPatientBorderBottom,10000);
		//Assert.assertTrue(selenium.isElementPresent(lblPatientBorderBottom),"Search Results are not displayed for the patient with ID :-"+lastName);
		
		if ((getText(selenium,lblPatientBorderBottom).contains(lastName))== false || selenium.isElementPresent(lblPatientBorderBottom) == false){
			returnValue=true;
			CreatePatient=true;
			
			System.out.println("Patient with lastName " + lastName + " Not created,  create a new one");			
		}				
		else
			System.out.println("Patient with lastname " + lastName + " is already created, No More Work");
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
	
	
	public boolean createPatientCA(Selenium selenium, HomeLib patientcaData) throws Exception{
	
		boolean returnValue = false;
		
		try{				
											
			//--------------------------------------------------------------------//
			//---------------  Step-3: Navigate to system setting   --------------//
			//--------------------------------------------------------------------//	

							
			assertTrue(click(selenium, txtSearchPatientBox),"Couldn't search Patient",selenium,ClassName,MethodName);
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click on the link" + patientcaData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingAction),"Could not click the systemSettings link;More Deatils:"+patientcaData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-4:Delete All Mandatory data   --------------//
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click admin Mandatory",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllMandatory(selenium),"Couldn't delete all mandatory field",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-5: Click New Patient Check-in   --------------//
			//--------------------------------------------------------------------//
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("ddHHmm");
			String uniqueName=DateFormat.format(cal.getTime());
			
			
			click(selenium,btnBack);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickActions),"Could not click on the link" + patientcaData .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkRegisterPatient),"Could not click the Register Patient;More Deatils:"+patientcaData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//Assert.assertTrue(createPatient(selenium,patientcaData),"Patient Checkin Failed");
			assertTrue(createPatientCAView(selenium,patientcaData,uniqueName),"Patient Checkin Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);				
			assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(selenium.isAlertPresent()){
				Assert.assertFalse(selenium.isAlertPresent(),"Patient not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
			}
			
			if(!verifyStoredValuesinSummaryPage(selenium,patientcaData)){
				Assert.fail("Patient details are not saved properly; More Details :"+ patientcaData.toString());
				returnValue=false;
			}
			else{
				 returnValue=true;
			}
				waitForPageLoad(selenium);
				click(selenium,"editButton");
				waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-4: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			
			if(!verifyStoredValues(selenium,patientcaData)){
				Assert.fail("Patient details are not Create properly; More Details :"+ patientcaData.toString());
				returnValue=false;
			}
			else{
				returnValue=true;
				}
			
			waitForPageLoad(selenium);
			click(selenium,"saveButton");
			waitForPageLoad(selenium);				
			
			
			//Assert.assertTrue(goEncounter(selenium),"Could not click the link");
			//waitForPageLoad(selenium);
			
			}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientcaData.toString());
		}
		return returnValue;
	}
	
	public boolean createPayer(Selenium selenium, HomeLib  patientcaData, String userAccount) throws IOException{
		
		//Selenium selenium=null;
		boolean returnValue=true;
		try{
			
			/*//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + medicationData.toString());
			Assert.assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, medicationData.userName, medicationData.userPassword),"Login Failed ");
			*/
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient Last Name//
			//--------------------------------------------------------------------//
			
		
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Medication //
			//--------------------------------------------------------------------//
			//Assert.assertTrue(isElementPresent(selenium,"medicationSummaryWidget"),"Could not find the link");
			if(isElementPresent(selenium,btnPayerList )){
				assertTrue(click(selenium,btnPayerList),"Could not click the Payer list link",selenium,ClassName,MethodName);
			}else{
				assertTrue(click(selenium,"link=Patient Options"),"Could not click Patient option link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,"patientOptionsRegistration"),"Could not click the Patient option Registration link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnPayerList),"Could not click the payer list link",selenium,ClassName,MethodName);
			}
			
				
			waitForPageLoad(selenium);
			String date;
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			  	date=DateFormat1.format(cal.getTime());
		    }else {
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
			}
			//--------------------------------------------------------------------//
			//  Step-4: Create Medication//
			//--------------------------------------------------------------------//
			
			if(patientcaData.testCaseId.equals("TC_NPC_130")){
				patientcaData.workSheetName = "AddPayers";
				patientcaData.testCaseId = "TC_CP_037";
				patientcaData.fetchHomeTestData();
			}if(patientcaData.testCaseId.equals("TC_NPC_131")){
				patientcaData.workSheetName = "AddPayers";
				patientcaData.testCaseId = "TC_CP_038";
				patientcaData.fetchHomeTestData();
			}
			
			assertTrue(click(selenium,btnPatientMedicalPayers),"Could not click the Medical Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			assertTrue(click(selenium,btnAddNew),"Could not click on addnew Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(addNewPayer(selenium,patientcaData,date,userAccount),"Add New Payer failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			if(isElementPresent(selenium,btnEdit1)){
				returnValue=true;
			}else
				returnValue=false;
		}catch(RuntimeException e){
			e.printStackTrace();
			
		}
		return returnValue;
	}
	
	public boolean verifyStoredValues(Selenium selenium, HomeLib patientcaData) {
	
		waitForPageLoad(selenium);
		if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US") ).trim().contains(patientcaData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtMiddleName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.middleName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}		
		
		if(!getValue(selenium,txtDOB).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.dob.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPrematureMeasure).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.measure.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxSex).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.sex.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		
		if(!getValue(selenium,ajxStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtStatusDate).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.statusDate.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtResidentAddress1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.residentialAddrStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtResidentAddress2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.residentialAddrStreet2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
	
		if(!getValue(selenium,txtResidentialZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.residentialAddrzipCode.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
	
		if(!getValue(selenium,"commType1SuggestBoxsuggestBox").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.telephoneType1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,"primaryPhone").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.telephoneNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		
		if(!getValue(selenium,"commType2SuggestBoxsuggestBox").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.telephoneType2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,"ohterPhone1").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.telephoneNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,"otherPhone1Extension").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.telephoneextnNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,"commType3SuggestBoxsuggestBox").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.telephoneType3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,"otherPhone2").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.telephoneNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,"otherPhone2").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.telephoneNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		
		if(!getValue(selenium,"mailingAddr1").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.mailingAddressStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,"mailingAddr2").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.mailingAddressStreet2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
			
		if(!getValue(selenium,"mailingZip").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.mailingAddressZipcode.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,"comments").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.comments.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
		}
	
	
	
		public boolean verifyStoredValuesinSummaryPage(Selenium selenium,HomeLib patientcaData){
		waitForPageLoad(selenium);
	
		if(!getText(selenium,"patientName").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"patientName").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,txtMiddleName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.middleName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblTitlePatient).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.title.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblSuffix).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.suffix.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblAlais).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.alias1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblAlais).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.alias2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"patientDetails").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.sex.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"patientDetails").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.dob.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"status").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"comments").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.comments.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,txtResidentAddress1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.residentialAddrStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,txtResidentAddress2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.residentialAddrStreet2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,txtResidentialZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.residentialAddrzipCode.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblPhoneType1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.telephoneType1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblPhoneExtn1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.telephoneextnNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,lblPhoneType2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.telephoneType2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,lblPhoneExtn2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.telephoneextnNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
	
		if(!getText(selenium,lblPhoneType3).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.telephoneType3.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,lblPhoneExtn3).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.telephoneextnNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,txtEmail).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.email.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblContactPreference).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientcaData.contactPreferences.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
		
		}

	
}
