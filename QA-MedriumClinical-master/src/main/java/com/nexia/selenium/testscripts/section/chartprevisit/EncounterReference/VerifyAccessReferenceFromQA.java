package com.nexia.selenium.testscripts.section.chartprevisit.EncounterReference;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAccessReferenceFromQA extends AbstractChartPreVisit {

	@Test(groups =  {"Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Creating Reference")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "CreateEncounterReference";
		encounterData.testCaseId = "TC_ER_006";
		encounterData.fetchChartPreVisitTestData();
		addEncounterReference(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	@Test(groups =  {"Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Creating Reference")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDirectAccessReference(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "CreateEncounterReference";
		encounterData.testCaseId = "TC_ER_007";
		encounterData.fetchChartPreVisitTestData();
		addEncounterReference(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify test for add Encounter References
	* @action 		  verifying test for add Encounter References 
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Completed
	* @useraccount    Both(Us and Canada)
	* @since  	      July 18, 2013
	***************************************************************************************************/
	
	
	public boolean addEncounterReference(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium= null;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			

			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Quick actions//
			//--------------------------------------------------------------------//
			assertTrue(goToReference(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			if(encounterData.testCaseId.equals("TC_ER_007")){
				assertTrue(type(selenium,txtUrl,encounterData.reference),"could not enter the details", selenium, ClassName, MethodName);
				assertTrue(click(selenium,lnkGo),"could not enter the details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				String st1[]=selenium.getAllWindowNames();
				waitForPageLoad(selenium);
				switchto(st1[1]);
				selenium.selectWindow(st1[1]);
				selenium.windowFocus();
				
				assertTrue(isElementPresent(selenium,"link=Home"),"Could not click the link", selenium, ClassName, MethodName);
							}
			
			//--------------------------------------------------------------------//
			//  Step-6:Delete Exist Reference//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteEncounterReferenceQA(selenium,encounterData),"Could not delete", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Create Encounter Reference//
			//--------------------------------------------------------------------//
			assertTrue(createEncounterReference(selenium,encounterData),"creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium,"//div[4]/div/div/div[2]/div/div[3]").toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.bookMark.toLowerCase(new java.util.Locale("en","US")).trim())){
				returnValue=true;
			}else{
				fail("Encounter Reference is not Created");
				returnValue=false;
			}
			
			//--------------------------------------------------------------------//
			//  Step-7:Verify Reference Access//
			//--------------------------------------------------------------------//
			assertTrue(verifyAccess(selenium,encounterData),"creation failed", selenium, ClassName, MethodName);
			
					
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyAccess(Selenium selenium, ChartPreVisitLib encounterData) throws IOException{
		boolean returnValue=true;
		int count=1;
		while(isElementPresent(selenium,"//div[@id='userReferenceListView']/table/tbody/tr["+count+"]/td")){
			if(getText(selenium,"//div[@id='userReferenceListView']/table/tbody/tr["+count+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.bookMark.toLowerCase(new java.util.Locale("en","US")).trim())){
				assertTrue(click(selenium,"//div[@id='userReferenceListView']/table/tbody/tr["+count+"]/td"),"could not click", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				break;
			}else
				count++;
			
			if(count>50){
				break;
			}
		}
		
		String st1[]=selenium.getAllWindowNames();
		waitForPageLoad(selenium);
		switchto(st1[1]);
		selenium.selectWindow(st1[1]);
		selenium.windowFocus();
		
		
		assertTrue(isElementPresent(selenium,"link=Home"),"Could not click the link", selenium, ClassName, MethodName);
		return returnValue;
	}

	private void switchto(String string) {
		// TODO Auto-generated method stub
	}
}
