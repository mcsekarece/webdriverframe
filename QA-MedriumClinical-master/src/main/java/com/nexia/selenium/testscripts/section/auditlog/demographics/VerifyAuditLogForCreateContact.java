package com.nexia.selenium.testscripts.section.auditlog.demographics;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForCreateContact extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Contact")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void createNewContactForPatient(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib ContactData = new AuditLogLib();
		ContactData.workSheetName = "AuditLogForContact";
		ContactData.testCaseId = "TC_ALCont_001";
		ContactData.fetchHomeTestData();
		createNewContact(seleniumHost, seleniumPort, browser, webSite,userAccount, ContactData);
	}
	/**
	 * createNewContact
	 * function to createNewContact
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    July 217, 2012
	 */
	public boolean createNewContact(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib ContactData) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + ContactData.toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, ContactData.userName, ContactData.userPassword),"Login Failed ");
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,ContactData.switchRole));
			waitForPageLoad(selenium);
			//Advanced search with Patient ID
			searchPatientNexia(selenium,ContactData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,"!patientContactsList");
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Deleting existing contacts for the selected patient  //
			//--------------------------------------------------------------------//
			Assert.assertTrue(deleteAllContact(selenium),"Contact details not saved properly; More Details :"+ ContactData.toString());
			//--------------------------------------------------------------------//
			//  Step-4: Create a new Contact //
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(click(selenium,"addContact"),"Could not Click on Add Contacts Contacts Button:"+ ContactData.toString());
			Assert.assertTrue(createContact(selenium,ContactData),"Contact details not saved properly; More Details :"+ ContactData.toString());
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Go to System Settings and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//Step-6: Verify Audit log for consents
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, ContactData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, ContactData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Verify whether Program gets saved properly //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesContact(selenium,ContactData)){
				Assert.fail("User details not saved properly; More Details :"+ ContactData.toString());
				returnValue=false;
			}else{
				return returnValue;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ContactData.toString());
		}
		return returnValue;
	}
	public boolean verifyStoredValuesContact(Selenium selenium,AuditLogLib auditData){
		
		
		
		Calendar cal1=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("yyyy-MM-dd");
		String systemDate=DateFormat1.format(cal1.getTime());
		
		
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.residentialAddrzipCode.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").trim().contains(systemDate.trim())){
			return false;
		}
		
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.residentialAddrcity.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.filter.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.title.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.suffix.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.telephoneType1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.telephoneNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.telephoneextnNo1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.telephoneType2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.telephoneNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.telephoneextnNo2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.telephoneType3.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.telephoneNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.telephoneextnNo3.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.email.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.comments.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.languageSpoken.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}
