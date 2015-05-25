package com.nexia.selenium.testscripts.section.systemsettings.enterprise_Variables;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteEnterpriseVariable extends AbstractSystemSettingsTest {
	public String CAAccount = fetchProperty("clinical", "CAAccount").trim().equals("") ? "0" : fetchProperty("clinical", "CAAccount").trim();

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for deleting an Enterprise Vaiable")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEnterpriseVaribleInSEconomics(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib enterPriseData = new SystemSettingsLib();
		enterPriseData.workSheetName = "AdminEnterPriseVariables";
		enterPriseData.testCaseId = "TC_Pv_003";
		enterPriseData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteEnterpriseVariable(seleniumHost, seleniumPort, browser, webSite, userAccount, enterPriseData);
	}
	/**
	 * delete enterprise Variable
	 * function to delete an Enterprise Variable 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @throws 		InterruptedException 
	 * @since  	     June 20, 2010
	 */
	public boolean deleteEnterpriseVariable(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib enterPriseData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + enterPriseData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, enterPriseData.userName, enterPriseData.userPassword),"Login Failed ", selenium, ClassName, MethodName);


			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,enterPriseData.switchRole), "Switch Role failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Enterprise Variables //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkEnterpriseVariables),"Could not click the Enter prise Variable;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete exist Enterprise Variables //
			//--------------------------------------------------------------------//
			assertTrue(deleteEnterPrise(selenium,enterPriseData),"Deleteion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Add Enterprise Variables //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddenterprise),"Could not click the Add button;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(createEnterPrise(selenium,enterPriseData,uniqueName),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//---------------------------------------------------------------------//
			//---------------------Step-4: Search Patient Nexia--------------------//
			//--------------------------------------------------------------------//
			click(selenium,btnBack);
			waitForPageLoad(selenium);
			enterPriseData.workSheetName = "NewSocioEconomic" ;
			enterPriseData.testCaseId = "TC_SE_002";
			enterPriseData.fetchSystemSettingTestData();
			waitForElement(selenium,lnkNewPatientCheckIn, 4000);
			waitForPageLoad(selenium);

			if(userAccount.equalsIgnoreCase(CAAccount)){
				searchPatientNexia(selenium,enterPriseData.CAPatientId);
			}
			else{
				searchPatientNexia(selenium,enterPriseData.patientId);
			}

			//searchPatientNexia(selenium,enterPriseData.patientId);
			waitForPageLoad(selenium);
			click(selenium,lnkPatietnSocialHistory);
			waitForPageLoad(selenium);
			//---------------------------------------------------------------------//
			//---------------------Step-4: SocioEconomics--------------------//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit1),"Could not click the edit button;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxParentEthnicitysuggestBox,enterPriseData.parentEthnicityPanel);
			selectValueFromAjaxList(selenium,ajxLivingArrangementsuggestBox,enterPriseData.livingArrangement);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxStudentStatussuggestBox,enterPriseData.studentStatus);
			selectValueFromAjaxList(selenium, ajxEducationLevelsuggestBox,enterPriseData.educationLevel);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEdit1),"Could not Click on create Button:"+ enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValues(selenium, enterPriseData), 
					"Socio-Economic details not saved properly; More Details :"+enterPriseData.toString(), selenium, ClassName, MethodName);

			assertTrue(click(selenium, btnSaveSocio),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,btnBack);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkEnterpriseVariables),"Could not click the Enter prise Variable;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			/*selenium.clickAt("entrepriseIdSuggestBoxsuggestBox","");
		selenium.keyPress("entrepriseIdSuggestBoxsuggestBox", "\\46");
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium,"entrepriseIdSuggestBoxsuggestBox",enterPriseData.livingArrangement);
		waitForPageLoad(selenium);
		selenium.keyPress("entrepriseIdSuggestBoxsuggestBox", "\\9");
		waitForPageLoad(selenium);


		int counter=(Integer) selenium.getXpathCount("//div[@id='EnterpriseIDList']/table/tbody/tr/td[3]/div/div/a[2]");
		while(isElementPresent(selenium,"//div[@id='EnterpriseIDList']/table/tbody/tr["+counter+"]/td[3]/div/div/a[2]")){
			waitForPageLoad(selenium);
			click(selenium,"//div[@id='EnterpriseIDList']/table/tbody/tr["+counter+"]/td[3]/div/div/a[2]");
			waitForPageLoad(selenium);
			counter--;
		}
		selenium.clickAt("entrepriseIdSuggestBoxsuggestBox","");
		selenium.keyPress("entrepriseIdSuggestBoxsuggestBox", "\\46");
		waitForPageLoad(selenium);
		type(selenium,"entrepriseIdSuggestBoxsuggestBox",enterPriseData.livingArrangement);
		waitForPageLoad(selenium);*/
			assertTrue(deleteEnterPrise(selenium,enterPriseData),"Deleteion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!isElementPresent(selenium, lblPopupPanel )){
				returnValue=true;
			}
			else{
				returnValue=false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	public boolean verifyStoredValues(Selenium selenium, SystemSettingsLib  enterPriseData){
		waitForPageLoad(selenium);

		if(!getValue(selenium,ajxParentEthnicitysuggestBox  ).trim().contains(enterPriseData.parentEthnicityPanel.trim())){
			return false;
		}
		if(!getValue(selenium,ajxLivingArrangementsuggestBox).trim().contains(enterPriseData.livingArrangement.trim())){
			return false;
		}
		if(!getValue(selenium,ajxStudentStatussuggestBox).trim().contains(enterPriseData.studentStatus.trim())){
			return false;
		}
		if(!getValue(selenium,ajxEducationLevelsuggestBox).trim().contains(enterPriseData.educationLevel.trim())){
			return false;
		}
		return true;
	}
}

