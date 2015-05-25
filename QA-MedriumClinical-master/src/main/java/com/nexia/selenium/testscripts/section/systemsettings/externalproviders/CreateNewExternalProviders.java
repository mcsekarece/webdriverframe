package com.nexia.selenium.testscripts.section.systemsettings.externalproviders;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class CreateNewExternalProviders extends AbstractSystemSettingsTest {
	public String CAAccount = fetchProperty("clinical", "CAAccount").trim().equals("") ? "0" : fetchProperty("clinical", "CAAccount").trim();
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a External Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewExternalProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateExternalProviders";
		providerData.testCaseId = "TC_EP_001";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createExternalProviders(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
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

	public boolean createExternalProviders(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//

			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not retrieve the New Selenium Session; More Details :" + providerData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,providerData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to External Providers //
			//--------------------------------------------------------------------//

			assertTrue(click(selenium, lnkSettings),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkSystemSettingsAction ),"Could not click on link System Settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkExternalProviderList ),"Could not click on External Providers link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//---------------------------------------------------------- ----------//
			//  Step-3: Deleting existing External Providers //
			//--------------------------------------------------------------------//

			assertTrue(deleteAllExternalProvider(selenium),"Delete all Providers failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//---------------------------------------------------------- ----------//
			//  Step-4: Add a new External Provider //
			//--------------------------------------------------------------------//

			assertTrue(click(selenium,lnkAddReferringProvider),"Could not click on Add External Providers link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueNo=DateFormat.format(cal.getTime());
			assertTrue(createExternalProvider(selenium,providerData,uniqueNo,userAccount),"External Providers Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValues(selenium,providerData,uniqueNo,userAccount), 
					"External Provider details not saved properly; More Details :"+ providerData.toString(), selenium, ClassName, MethodName);

		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	public boolean verifyStoredValues(Selenium selenium, SystemSettingsLib providerData, String uniqueNo, String userAccount) throws IOException{
		String date=null;
		String time= null;
		if(userAccount.equalsIgnoreCase(CAAccount)){
			Calendar calCA=Calendar.getInstance();
			SimpleDateFormat DateFormatCA=new SimpleDateFormat("dd");
			String dateCA=DateFormatCA.format(calCA.getTime());
			DateFormatCA=new SimpleDateFormat("HH");
			time=DateFormatCA.format(calCA.getTime());
			waitForPageLoad(selenium);
			int date1=Integer.parseInt(dateCA);
			if(date1 < 10){
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
				date=DateForma1t.format(calCA.getTime());
			}else{
				SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd,yyyy");
				date=DateFormat2.format(calCA.getTime());
			}
		}
		else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
			DateFormat=new SimpleDateFormat("HH");
			time=DateFormat.format(cal.getTime());
		}
		waitForPageLoad(selenium);
		assertTrue(verifyTimeStamp(selenium, vfyStoreExternalProvider2, date, time),"Verify Stamp failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,vfyStoreExternalProvider2)){			
			assertTrue(getText(selenium,vfyStoreExternalProvider2).trim().contains(providerData.referringCode.trim()), 
					"Not able to find text " +providerData.referringCode, selenium, ClassName, MethodName);					

			assertTrue(getText(selenium,vfyStoreExternalProvider2).trim().contains(providerData.lastName.trim()), 
					"Not able to find text " +providerData.lastName, selenium, ClassName, MethodName);						

			assertTrue(getText(selenium,vfyStoreExternalProvider2).trim().contains(providerData.firstName.trim()), 
					"Not able to find text " +providerData.firstName, selenium, ClassName, MethodName);						

			assertTrue(getText(selenium,vfyStoreExternalProvider2).trim().contains(providerData.licenseNum.trim()), 
					"Not able to find text " +providerData.licenseNum, selenium, ClassName, MethodName);						

			/*if(!getText(selenium,vfyStoreExternalProvider2).trim().contains(providerData.reportMethod.trim())){
				return false;
			}*/

			if(!userAccount.equalsIgnoreCase(CAAccount)){				
				assertTrue(getText(selenium,vfyStoreExternalProvider2).trim().contains(providerData.npi.trim()), 
						"Not able to find text " +providerData.npi, selenium, ClassName, MethodName);

				assertTrue(getText(selenium,vfyStoreExternalProvider2).trim().contains(providerData.upin.trim()), 
						"Not able to find text " +providerData.upin, selenium, ClassName, MethodName);						

				assertTrue(getText(selenium,vfyStoreExternalProvider2).trim().contains(providerData.taxonomyCode.trim()), 
						"Not able to find text " +providerData.taxonomyCode, selenium, ClassName, MethodName);						
			}

			assertTrue(getText(selenium,vfyStoreExternalProvider2).trim().contains(providerData.practiceName1.trim()), 
					"Not able to find text " +providerData.practiceName1, selenium, ClassName, MethodName);						

			assertTrue(getText(selenium,vfyStoreExternalProvider2).trim().contains(providerData.epstreet11.trim()), 
					"Not able to find text " +providerData.epstreet11, selenium, ClassName, MethodName);						

			assertTrue(getText(selenium,vfyStoreExternalProvider2).trim().contains(providerData.epstreet12.trim()), 
					"Not able to find text " +providerData.epstreet12, selenium, ClassName, MethodName);						
			return true;
		}
		return false;
	}
}

