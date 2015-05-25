package com.nexia.selenium.testscripts.section.systemsettings.enterprise_Variables;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class EnterpriseVariableInSocioEconomics extends AbstractSystemSettingsTest{
	public String CAAccount = fetchProperty("clinical", "CAAccount").trim().equals("") ? "0" : fetchProperty("clinical", "CAAccount").trim();
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Enterprise")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEnterpriseVaribleInSEconomics(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib enterPriseData = new SystemSettingsLib();
		enterPriseData.workSheetName = "AdminEnterPriseVariables";
		enterPriseData.testCaseId = "TC_Pv_001";
		enterPriseData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyEnterpriseVaribleInSocioEconomics(seleniumHost, seleniumPort, browser, webSite, userAccount, enterPriseData);
	}
	/**
	 * verify enterprise Variable In SocioEconomics
	 * function to verify Enterprise Variable In SocioEconomics
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		: InterruptedException 
	 
	 * @since  	     June 05, 2010
	*/
	public boolean verifyEnterpriseVaribleInSocioEconomics(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib enterPriseData) throws Exception{
		
		Selenium selenium=null;
		boolean returnValue=false;
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
			assertTrue(switchRole(selenium,enterPriseData.switchRole),"Switch Role failed", selenium, ClassName, MethodName);
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
			click(selenium,btnBack );
			waitForPageLoad(selenium);
			enterPriseData.workSheetName = "NewSocioEconomic" ;
			enterPriseData.testCaseId = "TC_SE_001";
			enterPriseData.fetchSystemSettingTestData();
			waitForElement(selenium, lnkNewPatientCheckIn , 4000);
			waitForPageLoad(selenium);
			
			if(userAccount.equalsIgnoreCase(CAAccount)){
				searchPatientNexia(selenium,enterPriseData.CAPatientId);				
			}
			else{
				searchPatientNexia(selenium,enterPriseData.patientId);
			}
			//searchPatientNexia(selenium,enterPriseData.patientId);
			waitForPageLoad(selenium);
			click(selenium, lnkPatietnSocialHistory);
			waitForPageLoad(selenium);
			//---------------------------------------------------------------------//
			//---------------------Step-4: SocioEconomics--------------------//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,"edit"),"Could not click the edit button;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxParentEthnicitysuggestBox,enterPriseData.parentEthnicityPanel),"Could not select"+enterPriseData.toString(), selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxLivingArrangementsuggestBox ,enterPriseData.livingArrangement),"Could not select"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(	selectValueFromAjaxList(selenium,ajxStudentStatussuggestBox,enterPriseData.studentStatus),"Could not select"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxEducationLevelsuggestBox,enterPriseData.educationLevel),"Could not select"+enterPriseData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,"save"),"Could not click the save button;More Details:"+enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEdit1),"Could not Click on create Button:"+ enterPriseData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValues(selenium, enterPriseData), 
					"Socio-Economic details not saved properly; More Details :"+enterPriseData.toString(), selenium, ClassName, MethodName);
			
			}catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
			return returnValue;
		}
	public boolean verifyStoredValues(Selenium selenium, SystemSettingsLib  enterPriseData){
		waitForPageLoad(selenium);
		
		if(!getValue(selenium,ajxParentEthnicitysuggestBox).trim().contains(enterPriseData.parentEthnicityPanel.trim())){
			return false;
		}
		if(!getValue(selenium,ajxLivingArrangementsuggestBox ).trim().contains(enterPriseData.livingArrangement.trim())){
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
