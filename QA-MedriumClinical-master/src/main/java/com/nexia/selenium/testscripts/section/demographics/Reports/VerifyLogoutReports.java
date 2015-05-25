package com.nexia.selenium.testscripts.section.demographics.Reports;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyLogoutReports extends AbstractHomeTest{
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default"}, description = "Test for Verifying Select Options in Referral")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLogOutReports(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib loginData = new HomeLib();
		loginData.workSheetName = "Login";
		loginData.testCaseId = "TC_LG_001";
		loginData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyLogOutReports(seleniumHost, seleniumPort, browser, webSite, userAccount, loginData);

	}

	/*************************************************************************************************** 
	* @purpose        To verify closing of Reports windows on Logout 
	* @action 		  To verify closing of Reports windows on Logout
	* @author         Jagmit Singh
	* @state          Developing
	* @useraccount    Both
	* @since  	      July 18, 2014
	***************************************************************************************************/
	public boolean verifyLogOutReports(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib loginData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application 								  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + loginData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, loginData.userName, loginData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Reports link from Quick Actions			  //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the Quick Actions link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkReports),"Could not click on Reports link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			selenium.waitForPopUp("_blank", "30000");
			selenium.selectWindow("_blank");
			
			//System.out.println("PopUp selected");
			
			//--------------------------------------------------------------------//
			//  Step-3: Signout from Nexia Application							  //
			//--------------------------------------------------------------------//
			selenium.selectWindow("null");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkTopMenu),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSignout),"Could not click the log out button",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnYes),"Could not click yes button;More Details"+loginData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
									
			
			//---------------------------------------------------------- ----------//
			//  Step-4: Verify that EWebReport external windows is also closed     //
			//---------------------------------------------------------- ----------//
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			try{
			selenium.selectWindow("eWebReports");
			assertTrue(false,"EReport window should close on Logout", selenium, ClassName, MethodName);
			
			}catch (RuntimeException e){								
				if (e.getMessage().contains("Could not find window with title eWebReports")){
				assertTrue(true,"passed due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);}			
			}
				    	
			
		}catch (RuntimeException e){
			e.printStackTrace();			
						
		} 
		
		
		return returnValue;
	}
}