package com.nexia.selenium.testscripts.section.auditlog.systemsetting;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForEditExternalProvider extends AbstractAuditLog {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a External Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void createNewExternalProvider(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib providerData = new AuditLogLib();
		providerData.workSheetName = "AuditLogForExternalProvider";
		providerData.testCaseId = "TC_ALEP_001";
		providerData.fetchHomeTestData();
		editExternalProvidersForAuditLog(seleniumHost, seleniumPort, browser, webSite, providerData, userAccount);
	}

	/**
	 * createExternalProvider
	 * function to create External Provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	     May 17, 2012
	 */
	
	public boolean editExternalProvidersForAuditLog(String seleniumHost, int seleniumPort,String browser, String webSite, AuditLogLib providerData,String userAccount) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData .toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, providerData.userAccount, providerData.userName, providerData.userPassword),"Login Failed ");
			
			//-----------------------------//
			//  Step-2:Change Switch Role  //
			//-----------------------------//
			Assert.assertTrue(switchRole(selenium,providerData.switchRole));
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to External Providers //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			click(selenium,"systemSettings");
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"!adminExternalProviderList"),"Could not click on External Providers link:" + providerData .toString());
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-4: Deleting existing External Providers //
			//--------------------------------------------------------------------//
			Assert.assertTrue(deleteAllExternalProvider(selenium));
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-5: Add a new External Provider //
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,"addReferringProvider"),"Could not click on Add External Providers link:" + providerData .toString());
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueNo=DateFormat.format(cal.getTime());
			Assert.assertTrue(createExternalProvider(selenium,providerData,uniqueNo),"External Providers Creation failed");
			waitForPageLoad(selenium);
			
			//----------------------------------//
			//  Step-6: Edit External Provider  // 
			//----------------------------------//
			providerData.workSheetName = "AuditLogForExternalProvider";
			providerData.testCaseId = "TC_ALEP_002";
			providerData.fetchHomeTestData();
			
			Assert.assertTrue(click(selenium,"editButtonId"),"Could not click the edit button;More details:"+providerData.toString());
			waitForPageLoad(selenium);
			
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueNo1=DateFormat1.format(cal1.getTime());

			Assert.assertTrue(createExternalProvider(selenium,providerData,uniqueNo1),"External Providers Creation failed");
			waitForPageLoad(selenium);
			
			//-----------------------------------------------------------//
			//  Step-7: Go to  securitySetting and navigate to Audit Log //
			//-----------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------//
			//  Step-8: Verify Audit log for External Providers //
			//--------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, providerData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, providerData, userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			//----------------------------------------------------------------------//
			//  Step-9: Verify whether External Providers gets saved properly(Info) //
			//----------------------------------------------------------------------//
			if(!verifyStoredValuesForExternalProvider(selenium,providerData)){
				Assert.fail("User details not saved properly; More Details :"+ providerData.toString());
				returnValue=false;
			}
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------------//
			//  Step-10: Verify whether External Providers gets saved properly(Address) //
			//--------------------------------------------------------------------------//
			Assert.assertTrue(verifyStoredValue(selenium, providerData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			int count=1;
			while(isElementPresent(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div")){
				if(getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div").contains(providerData.action)&&getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div").contains(providerData.section1)){
					click(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div");
					break;
				}
				count++;
				if(count>20)
					Assert.fail("Program details not found;More details:"+providerData.toString());
			}
			
			if(!verifyStoredValuesForExternalProviderAddress(selenium,providerData)){
				Assert.fail("User details not saved properly; More Details :"+ providerData.toString());
				returnValue=false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public boolean verifyStoredValuesForExternalProvider(Selenium selenium,AuditLogLib providerData){
		System.out.println(getText(selenium,"collapsableDesc"));
		/*if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.referringCode.toLowerCase(new java.util.Locale("en","US")).trim())){
			return false;
		}*/
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.lastName.toLowerCase(new java.util.Locale("en","US")).trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.firstName.toLowerCase(new java.util.Locale("en","US")).trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.middleInitial.toLowerCase(new java.util.Locale("en","US")).trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.licenseNum.toLowerCase(new java.util.Locale("en","US")).trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.credentials.toLowerCase(new java.util.Locale("en","US")).trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.npi.toLowerCase(new java.util.Locale("en","US")).trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.upin.toLowerCase(new java.util.Locale("en","US")).trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.taxonomyCode.toLowerCase(new java.util.Locale("en","US")).trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.comments.toLowerCase(new java.util.Locale("en","US")).trim())){
			return false;
		}
		return true;
	}
	
	public boolean verifyStoredValuesForExternalProviderAddress(Selenium selenium,AuditLogLib providerData){
		System.out.println(getText(selenium,"collapsableDesc"));
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.practiceName1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.epstreet11.toLowerCase(new java.util.Locale("en","US")).trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.epstreet12.toLowerCase(new java.util.Locale("en","US")).trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.epcity1.toLowerCase(new java.util.Locale("en","US")).trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.epzipcode1.toLowerCase(new java.util.Locale("en","US")).trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.epcountry1.toLowerCase(new java.util.Locale("en","US")).trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.epphone1.toLowerCase(new java.util.Locale("en","US")).trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.epfax1.toLowerCase(new java.util.Locale("en","US")).trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.epemail1.toLowerCase(new java.util.Locale("en","US")).trim())){
			return false;
		}
		return true;
	}
	
}