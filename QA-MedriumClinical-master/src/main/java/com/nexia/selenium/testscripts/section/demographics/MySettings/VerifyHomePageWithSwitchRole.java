package com.nexia.selenium.testscripts.section.demographics.MySettings;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyHomePageWithSwitchRole extends AbstractHomeTest {
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing the switch Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySwitchRole(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib switchRoleData = new HomeLib();
		switchRoleData.workSheetName = "SwitchRole";
		switchRoleData.testCaseId = "TC_SR_001";
		switchRoleData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySwitchRole(seleniumHost, seleniumPort, browser, webSite, userAccount, switchRoleData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Switch Role
	* @action 		  verifying Switch Role
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 27, 2012
	***************************************************************************************************/
	public boolean verifySwitchRole(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib switchRoleData) throws Exception{
		Selenium selenium = null;	
		int counter=0;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + switchRoleData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, switchRoleData.userName, switchRoleData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,switchRoleData.switchRole),"",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Set Home page settings For read only User //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSecuritySetting),"Could not click on System settings link:" + switchRoleData .toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAdminUserRoleList),"Could noy click the User Role link:"+switchRoleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lnkAdminUserRoleMoreLink)){
				click(selenium,lnkAdminUserRoleMoreLink);
			}
			
			waitForPageLoad(selenium);
			int count=1;
			while(isElementPresent(selenium,"//div[@id='AdminUserRoleList']/table/tbody/tr["+count+"]/td/div/span/div")){
				if(getText(selenium,"//div[@id='AdminUserRoleList']/table/tbody/tr["+count+"]/td/div/span/div").contains(switchRoleData.switchRole)){
					counter = count;
					break;
				}else
					count++;
			}
			
			assertTrue(click(selenium, "//tr["+counter+"]/td[2]/div/a"),"Could not click edit button of created User Role",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxHomePageView,"Front Desk");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click save button:"+switchRoleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			/*//--------------------------------------------------------------------//
			//  Step-4: Set Home page settings For Administrator //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,"xpath=(//a[contains(text(),'Edit')])[3]"),"Could not click on Edit link:"+switchRoleData.toString());
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxHomePageView,"Front Desk");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click save button:"+switchRoleData.toString());
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-5: Go to TOp Mean  and navigate to switch role //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTopMenu),"Could not click top mean header;More Details:"+switchRoleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSwitchRole),"Could not click switch Role link;More Details:"+switchRoleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajkSuggestBox,switchRoleData.switchRole);
			click(selenium,ajkValueSelect3);
			assertTrue(click(selenium,txtDeleteReason),"Could not click the select button:More Details:"+switchRoleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:  Verifying Role is saved properly   //
			//--------------------------------------------------------------------//
			if(!verifyStoreValue(selenium,switchRoleData)){
				Assert.fail("Role is not saved properly; More Details :"+ switchRoleData.toString());
				return false;
			}
			
			//--------------------------------------------------------------------//
			//  Step-7:  Verifying Home Page for associated Role  //
			//--------------------------------------------------------------------//
			if(!isElementPresent(selenium,lblHomePageContent)){
				Assert.fail("Home page is not changed according to the role");
			}
			
			//--------------------------------------------------------------------//
			//  Step-8: Go to TOp Mean  and navigate to switch role //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTopMenu),"Could not click top mean header;More Details:"+switchRoleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSwitchRole),"Could not click switch Role link;More Details:"+switchRoleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajkSuggestBox,switchRoleData.switchRole);
			click(selenium,ajkValueSelect3);
			assertTrue(click(selenium,txtDeleteReason),"Could not click the select button:More Details:"+switchRoleData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Go to TOp Mean  and navigate to switch role //
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium,registerPatient)){
				return true;
			}
			else Assert.fail("Home page is not changed according to the role");
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
	public boolean verifyStoreValue (Selenium selenium,HomeLib switchRoleData) throws IOException{
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,lnkTopMenu).trim().contains(switchRoleData.switchRole.trim()),"could not get text",selenium,ClassName,MethodName);
		return true;
	}
}
