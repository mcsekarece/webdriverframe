package com.nexia.selenium.testscripts.section.chartprevisit.Allergies;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForAllergy extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "VerifySecurityOption";
		allergyData.testCaseId = "TC_VSP_007";
		allergyData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 29, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,allergyData.switchRole),"Could not change the switch role;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click on error close", selenium, ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
			
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_020";
			userRoleData.fetchSystemSettingTestData();			
							
			if(userRoleData.allergies.contains("No Access")){
				
				assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
				assertTrue(searchPatientNexiaNoAccess(selenium,allergyData.patientId),"Could search patient", selenium, ClassName, MethodName);				
			}		
			
			//--------------------------------------------------------------------//
			//  Step-4: Visit the Allergy Link 									  //
			//--------------------------------------------------------------------//		
			
			if(userRoleData.allergies.contains("View Only") || userRoleData.personalInfo.contains("Full Access")){
				  
				searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);	
				waitForPageLoad(selenium);					
				assertTrue(click(selenium,lnkAllergy),"Could not click the link;", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);							
					
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
				
				if(!verifySecurity(selenium,allergyData,userRoleData,userAccount)){
					fail("Security option not show properly; More Details :"+ allergyData.toString());
					returnValue= false;
				}else
					returnValue=true;
			}													
									
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			
			if(userRoleData.allergies.contains("Limited Access")){
				
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
				
				if(!verifySecurityOptionForLimitedAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData)){
					fail("Security option not show properly; More Details :"+ allergyData.toString());
					returnValue= false;
				}else
					returnValue=true;
			}
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib allergyData,SystemSettingsLib userRoleData,String account) throws IOException{
		boolean returnValue=true;
	
		// View Only Access				
		if(userRoleData.personalInfo.contains("View Only")){
			 
			waitForPageLoad(selenium);
			//if(isElementPresent(selenium,"add")){
			if(selenium.isElementPresent("id=allergenSuggestBox")){
				returnValue=false;
			}else
				return returnValue;
		}
		
		// Full Access 		
		else if(userRoleData.personalInfo.contains("Full Access")){
			allergyData.workSheetName = "CreateAllergy";
			allergyData.testCaseId = "TC_CA_001";
			allergyData.fetchChartPreVisitTestData();
	
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createAllergy(selenium,allergyData,account),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"//a[contains(text(),'Delete')]")){
				return true;
			}else
				return false;
		}	    			
		return returnValue;		
		
	}
	public boolean verifySecurityOptionForLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws IOException{
		Selenium selenium=null;		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,allergyData.switchRole),"Could not change the switch role;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			allergyData.workSheetName = "CreateAllergy";
			allergyData.testCaseId = "TC_CA_001";
			allergyData.fetchChartPreVisitTestData();
			
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
									
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			ChartPreVisitLib allergyData1 = new ChartPreVisitLib();
			allergyData1.workSheetName = "VerifySecurityOption";
			allergyData1.testCaseId = "TC_VSP_001";
			allergyData1.fetchChartPreVisitTestData();
			
			
			assertTrue(isElementPresent(selenium,"topMenuHeader"),"Could not fine the link;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,"topMenuHeader"),"Could not click the top Menu Header;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"switchRoleAction"),"Could not click the switch role;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			if(isElementPresent(selenium,"//div[5]/div/div/div[2]/div/div/div/input")){
			selectValueFromAjaxList(selenium,"//div[5]/div/div/div[2]/div/div/div/input",allergyData1.switchRole);
			}
			if(isElementPresent(selenium,"//div[6]/div/div/div[2]/div/div/div/input")){
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"//div[6]/div/div/div[2]/div/div/div/input",allergyData1.switchRole);
			}
			click(selenium,"//body/div[7]/div/div/div/div/div");

			waitForPageLoad(selenium);
			click(selenium,txtdeleteReason);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"link=Show recent patients"),"Could not click the link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForElement(selenium,"css=div.patientInfoWidget",10000);
			assertTrue(selenium.isElementPresent("css=div.patientInfoWidget"),"Search Results are not displayed for the patient with ID :-", selenium, ClassName, MethodName);
			
			click(selenium,"css=div.patientInfoWidget");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"", selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium,"//a[contains(text(),'Delete')]")){
				returnValue= false; 
			}else
					return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
}