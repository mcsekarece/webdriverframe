package com.nexia.selenium.testscripts.section.smoketest;

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

public class CreateNewPatient  extends AbstractHomeTest {
	@Test(groups = {"Smoke","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewpatientToCheckContactPreference(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_006";
		PatientData.fetchHomeTestData();
		createNewPatient(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
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
	
	public boolean createNewPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = false;
		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patientData.switchRole),"selection failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-3: Navigate to system setting   --------------//
			//--------------------------------------------------------------------//
			
			waitForPageLoad(selenium);
		  	  assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
		      waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSetting),"Could not click the systemSettings link;More Deatils:",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			//assertTrue(click(selenium,"systemSettings"),"Could not click system setting");
			//waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-4:Delete All Mandatory data   --------------//
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkAdminMandatory),"Could not click admin Mandatory", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllMandatory(selenium),"Could not delete", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-5: Click New Patient Check-in   --------------//
			//--------------------------------------------------------------------//
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy");
			String uniqueName=DateFormat.format(cal.getTime());
			
			
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			  if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);		        		        
			assertTrue(click(selenium,lnkQuickLink),"Could not click on System settings link:" + patientData .toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkRegisterPatient),"Could not click the Register Patient;More Deatils:"+patientData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(createPatient(selenium,patientData,uniqueName, userAccount),"Patient Checkin Failed", selenium, ClassName,MethodName);	
			waitForPageLoad(selenium);
			assertTrue(waitForElement(selenium, btnRegistrationEdit, 10000),"Could not find the edit button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(selenium.isAlertPresent()){
				Assert.assertFalse(selenium.isAlertPresent(),"Patient not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
			}
			
			if(!verifyStoredValuesinSummaryPage(selenium,patientData,userAccount)){
				Assert.fail("Patient details are not saved properly; More Details :"+ patientData.toString());
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
			if(!verifyStoredValues(selenium,patientData,userAccount)){
				Assert.fail("Patient details are not Create properly; More Details :"+ patientData.toString());
				returnValue=false;
			}
			else{
				returnValue=true;
				}
			
		
			
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,btnSave1),"Could not click Save button"+patientData.toString(), selenium, ClassName, MethodName);
			//click(selenium,btnSave1);
			waitForPageLoad(selenium);
						
			
			assertTrue(createSocioEconomic(selenium, userAccount),"Could not click the link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//assertTrue(goEncounter(selenium),"Could not click the link");
			//waitForPageLoad(selenium);
			
			}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
		}
		return returnValue;
	}
	
	public boolean verifyStoredValues(Selenium selenium, HomeLib patientData, String userAccount) {	
		waitForPageLoad(selenium);
		if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US") ).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtMiddleName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.middleName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		
		if(userAccount.equalsIgnoreCase(CAAccount)){
			if(!getValue(selenium,txtDOB).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.dobCa.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}			
	    }
		else{
			if(!getValue(selenium,txtDOB).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.dob.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
	    }			
		
				
		if(!getValue(selenium,ajxPrematureMeasure).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.measure.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxSex).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.sex.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		
		if(!getValue(selenium,ajxStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtStatusDate).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.statusDate.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtResidentAddress1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtResidentAddress2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
					
		if(userAccount.equalsIgnoreCase(CAAccount)){			
			if(!getValue(selenium,txtResidentialZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrzipCodeCA.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
	    }
		else{
			if(!getValue(selenium,txtResidentialZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrzipCode.trim().toLowerCase(new java.util.Locale("en","US")))){
				waitForPageLoad(selenium);
				return false;
			}
	    }	
		
		if(!getValue(selenium,ajxPhoneType1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType1.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtPrimaryPhone).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo4.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		
		if(!getValue(selenium,ajxPhoneType2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone1Extn).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,ajxPhoneType3).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium,txtOtherPhone2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		
		if(!getValue(selenium,txtMailingAddress1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.mailingAddressStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtMailingAddress2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.mailingAddressStreet2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
			
		if(!getValue(selenium,txtMailingZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.mailingAddressZipcode.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtcmt).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.comments.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
		}	
	
		public boolean verifyStoredValuesinSummaryPage(Selenium selenium,HomeLib patientData, String userAccount){
		waitForPageLoad(selenium);	
		if(!getText(selenium,lblPatientName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblPatientName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,txtMiddleName).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.middleName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblTitlePatient).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.title.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblSuffix).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.suffix.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblAlais).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblAlais).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.alias2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblSex).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.sex.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!userAccount.equalsIgnoreCase(CAAccount)){
			if(!getText(selenium,"dob").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.dob.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
	    }
						
		
		if(!getText(selenium,lblStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,txtcmt).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.comments.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,txtResidentAddress1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,txtResidentAddress2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrStreet2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(userAccount.equalsIgnoreCase(CAAccount)){
		
			if(!getText(selenium,txtResidentialZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrzipCodeCA.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
	    }
		else
		{
			if(!getText(selenium,txtResidentialZip).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.residentialAddrzipCode.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
	    }	
			
		if(!getText(selenium,lblPhoneType1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblPhoneExtn1).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,lblPhoneType2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,lblPhoneExtn2).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
	
		if(!getText(selenium,lblPhoneType3).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneType3.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,lblPhoneExtn3).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,txtEmail).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.email.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
	

	return true;
	
		
	}
		
	public boolean createSocioEconomic(Selenium selenium, String userAccount) throws IOException{
		
		assertTrue(click(selenium,lnkSocioEconomics),"Could not click on Socio Econimic Link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(isElementPresent(selenium,btnYes1)){
			assertTrue(click(selenium,btnYes1),"Could not click Yes button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		HomeLib sEconomicData = new HomeLib();
		sEconomicData.workSheetName = "NewSocioEconomic";
		sEconomicData.testCaseId = "TC_SE_005";
		sEconomicData.fetchHomeTestData();
		//---------------------------------------------------------- ----------//
		//  Step-5: Create a new Socio-Economic for a patient //
		//--------------------------------------------------------------------//
		
		assertTrue(click(selenium,btnEdit),"Could not click on Edit Button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	
			
		assertTrue(createSocioEconomic(selenium,sEconomicData, userAccount),"Socio-Economic creation Failed", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForElementToEnable(selenium,btnEdit);
		assertTrue(click(selenium,btnEdit),"Could not Click on create Button:"+ sEconomicData.toString(), selenium, ClassName,MethodName);
		
		waitForPageLoad(selenium);
		
		return true;
		
		}		

}
