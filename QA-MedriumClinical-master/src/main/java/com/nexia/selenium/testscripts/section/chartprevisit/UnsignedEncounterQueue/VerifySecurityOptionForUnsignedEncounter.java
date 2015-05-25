package com.nexia.selenium.testscripts.section.chartprevisit.UnsignedEncounterQueue;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForUnsignedEncounter extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib ecData = new ChartPreVisitLib();
		ecData.workSheetName = "VerifySecurityOption";
		ecData.testCaseId = "TC_VSP_001";
		ecData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, ecData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib ecData = new ChartPreVisitLib();
		ecData.workSheetName = "VerifySecurityOption";
		ecData.testCaseId = "TC_VSP_002";
		ecData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, ecData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib ecData = new ChartPreVisitLib();
		ecData.workSheetName = "VerifySecurityOption";
		ecData.testCaseId = "TC_VSP_003";
		ecData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, ecData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib ecData = new ChartPreVisitLib();
		ecData.workSheetName = "VerifySecurityOption";
		ecData.testCaseId = "TC_VSP_004";
		ecData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, ecData);
	} 
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 11, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib ecData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + ecData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, ecData.userName, ecData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			
			if(!ecData.testCaseId.equals("TC_VSP_002")|| ecData.testCaseId.equals("TC_VSP_001")){
			assertTrue(switchRole(selenium,ecData.switchRole),"Could not change the switch role;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			}
		
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
							
			if(ecData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
				assertTrue(searchPatientNexiaNoAccess(selenium,ecData.patientId),"Could search patient", selenium, ClassName, MethodName);				
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,ecData)){
				Assert.fail("Security is not handled properly; More Details :"+ ecData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib ecData) throws IOException{
		//Limited access
		if(ecData.testCaseId.equals("TC_VSP_001")){
			
			searchPatientNexiaForProviderHomePage(selenium,ecData.patientId);
			waitForPageLoad(selenium);
			
			assertTrue(goToBeginEncounter(selenium),"Could not navigate the encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(selenium.isConfirmationPresent()){
                System.out.println(selenium.getConfirmation());
                selenium.chooseOkOnNextConfirmation();        }
			
			selenium.focus(btnsaveProvider);
			selenium.clickAt(btnsaveProvider, "");
			
			
			assertTrue(click(selenium, btnNexiaLogo),"Could not click", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			
			
			assertTrue(switchRole(selenium,ecData.switchRole),"Could not change the switch role;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
//			click(selenium,"//div[8]/div/div/div/div/div");
//			click(selenium,txtdeleteReason);
//			waitForPageLoad(selenium);
			if(selenium.isConfirmationPresent()){
                System.out.println(selenium.getConfirmation());
                selenium.chooseOkOnNextConfirmation();        }
			
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			if(selenium.isConfirmationPresent()){
                System.out.println(selenium.getConfirmation());
                selenium.chooseOkOnNextConfirmation();        }
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"Could not click close button",selenium,ClassName,MethodName);
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click Nexia Logo:"+ecData.toString(),selenium,ClassName,MethodName);

			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
			     assertTrue(click(selenium, btnErrorClose),"Could not click close button",selenium,ClassName,MethodName);
			
			
			assertTrue(click(selenium,lnkUnSigned),"Could not click on encounter queue button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			if(selenium.isConfirmationPresent()){
                System.out.println(selenium.getConfirmation());
                selenium.chooseOkOnNextConfirmation();        }
			if(isElementPresent(selenium, btnErrorClose))

			     assertTrue(click(selenium, btnErrorClose),"Could not click close button",selenium,ClassName,MethodName);
			
			selectValueFromAjaxList(selenium,"suggestBox","My encounters");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			int count=(Integer)selenium.getXpathCount("//div[2]/table/tbody/tr/td/div/div/div[2]/span/div/div/span");
			assertTrue(click(selenium,"xpath=(//div[2]/table/tbody/tr/td/div/div/div[2]/span/div/div/span)["+count+"]"),"Could not click on encounter;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose)){
				assertTrue(click(selenium, btnErrorClose),"Could not click close button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(click(selenium,lnkencounterTab),"Could not click on encounter;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
		   	assertTrue(click(selenium,"//div[@id='EncountersPendingList']/table/tbody/tr/td[2]/div/div"),"Could not find Action button",selenium,ClassName,MethodName);		
			
			if(getText(selenium, "sign").equalsIgnoreCase("sign")){
				return false;
			}else{	
				return true;
			}
		}
		
		//View only access
		if(ecData.testCaseId.equals("TC_VSP_002")){
		    
		    assertTrue(click(selenium, btnNexiaLogo),"Could not click", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(switchRole(selenium,ecData.switchRole),"Could not change the switch role;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
		    assertTrue(click(selenium,"//div[@id='Unsignedencounters']"),"Could not click on encounter queue button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			
			//selectValueFromAjaxList(selenium,"suggestBox","All encounters");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			waitForElement(selenium, lnkEncounterEntry, WAIT_TIME);
			if(!isElementPresent(selenium,lnkEncounterEntry)){
			    waitForElement(selenium, lnkEncounterEntry, WAIT_TIME);
			}
			if(!isElementPresent(selenium,lnkEncounterEntry)){
			    waitForElement(selenium, lnkEncounterEntry, WAIT_TIME);
			}
			assertTrue(click(selenium,lnkEncounterEntry),"Could not click on encounter;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"sign") ||isElementPresent(selenium,"signencounterNote")){
				return false;
			}else
				return true;
		}
		
				
		//Full Access
		if(ecData.testCaseId.equals("TC_VSP_004")){
			
			searchPatientNexiaForProviderHomePage(selenium,ecData.patientId);
			waitForPageLoad(selenium);
			
			assertTrue(goToBeginEncounter(selenium),"Could  not begin encounter", selenium, ClassName, MethodName);
			
			assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			
			int count=0;
			while(isElementPresent(selenium,lnkBeginEncounterAction)){
				click(selenium,lnkBeginEncounterAction);
				
				if(isElementPresent(selenium,lblEncounterSave1)){
					break;
				}
				
				count++;
				if(count>20){
					break;
				}
			}
			
			assertTrue(click(selenium,lblEncounterSave1),"Could not click the save button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"//div[@id='Unsignedencounters']"),"Could not click on encounter queue button;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			
			//selectValueFromAjaxList(selenium,"suggestBox","All encounters");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			waitForElement(selenium, lnkEncounterEntry, WAIT_TIME);
			if(!isElementPresent(selenium,lnkEncounterEntry)){
			    waitForElement(selenium, lnkEncounterEntry, WAIT_TIME);
			}
			if(!isElementPresent(selenium,lnkEncounterEntry)){
			    waitForElement(selenium, lnkEncounterEntry, WAIT_TIME);
			}
			assertTrue(click(selenium,lnkEncounterEntry),"Could not click on encounter;More Details:"+ecData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"sign") ||isElementPresent(selenium,"signencounterNote")){
				return true;
			}else
				return false;
		}
		return true;
	}
}
