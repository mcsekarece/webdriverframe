package com.nexia.selenium.testscripts.section.systemsettings.mandatoryfields;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class CreateMandatoryField extends AbstractSystemSettingsTest {
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding an Mandatory")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewMandatory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib mandData = new SystemSettingsLib();
		mandData.workSheetName = "CreateMandatoryField";
		mandData.testCaseId = "TC_MF_001";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createMandatoryField(seleniumHost, seleniumPort, browser, webSite, userAccount, mandData);
	}
	
	/**
	 * createMandatoryField
	 * function to create Mandatory Field
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    June 27, 2012
	 */
	
	public boolean createMandatoryField(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib mandData) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mandData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, mandData.userName, mandData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,mandData.switchRole), "Switch role failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Mandatory User Field //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkSettings),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAdminMandatoryUserField),"Could not click on Mandatory User Field link:" + mandData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-3: Deleting existing entries  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllMandatoryUserField(selenium),"Delete mandatory failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Add a new Mandatory User Field
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAddMandatoryUserField),"Could not click on Add Mandatory User Field link:" + mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createMandatoryUserField(selenium,mandData),"Mandatory User Field Creation failed", selenium, ClassName, MethodName);
		
			
			//assertTrue(verifyTextPresentMandatory(selenium, mandData));
			
			
			if(!verifyTextPresentMandatory(selenium, mandData, userAccount)){
				Assert.fail("Mandatory User Field details not saved properly; More Details :"+ mandData.toString());
				returnValue=false;
			}else
				return returnValue;
			
			
			//assertTrue(verifyTimeStamp(selenium, vfyStamp, date, time));
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			if(!verifyStoredValues(selenium,mandData)){
				Assert.fail("Mandatory User Field details not saved properly; More Details :"+ mandData.toString());
				returnValue=false;
			}else
				return returnValue;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyTextPresentMandatory(Selenium selenium, SystemSettingsLib mandData, String userAccount){
		
		
		Calendar calCA=Calendar.getInstance();
		SimpleDateFormat DateFormatCA=new SimpleDateFormat("dd");
		String dateCA=DateFormatCA.format(calCA.getTime());
		DateFormatCA=new SimpleDateFormat("HH");
		String timeCA=DateFormatCA.format(calCA.getTime());
		waitForPageLoad(selenium);
		String time = null;
		String date = null;
		if(userAccount.equals(CAAccount)){
			int date1=Integer.parseInt(dateCA);
			if(date1 < 10){
			SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
			dateCA=DateForma1t.format(calCA.getTime());
			}else{
			SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");
			dateCA=DateFormat2.format(calCA.getTime());
			}
		}else{
		
		
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
			DateFormat=new SimpleDateFormat("HH");
			time=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
		}
		if(userAccount.equalsIgnoreCase(CAAccount)){
			if(!selenium.isTextPresent("Last updated by") || !selenium.isTextPresent(timeCA) || !selenium.isTextPresent(dateCA)){
				return false;
			}
		}
		else{			
			if(!selenium.isTextPresent("Last updated by") || !selenium.isTextPresent(time) || !selenium.isTextPresent(date)){
				return false;
			}
		}		
		return true;
	}
	
	
	public boolean verifyStoredValues(Selenium selenium, SystemSettingsLib mandData){
		if(!getText(selenium,lblPatientIdentifierGroup).trim().contains(mandData.unit.trim())){
				return false;
		}
		if(!getText(selenium,lblPatientIdentifierGroup).trim().contains(mandData.field.trim())){
			return false;
		}
		return true;
	}
	
	
	
}

