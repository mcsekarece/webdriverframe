package com.nexia.selenium.testscripts.section.chartprevisit.LabReportQueue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyProviderNameInLabQueue extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Final as Report status for Lab Report in Queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProviderInQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_041";
		labData.fetchChartPreVisitTestData();
		verifyProviderCountInQueue(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Proiver Count In Lab Queue
	* @action 		  verifying Proiver Count In Lab Queue
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @defect		  #5163
	* @useraccount    Both (US and Canada)
	* @since  	      Aug 21, 2013
	***************************************************************************************************/
	public boolean verifyProviderCountInQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=false;
		boolean providerValue = false;
		int count;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + labData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, labData.userName, labData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Get the Practcice  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,"locationMenuHeader"),"Could not click the Quick action", selenium, ClassName, MethodName);		
			String txtpractice ="";
			String practice= getText(selenium, txtpractice);
			//String providerName= practiceTemp.replaceAll(", FULL", "");
			
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate to the System setting //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkSettings),"Could not click the Quick action", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemsetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4:Search Practice //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		for(int Pracount=1;Pracount<=10;Pracount++)
		{
			if(getText(selenium,"xpath=(//div[@id='chartListItem'])["+Pracount+"]").contains(practice))
			{
				click(selenium,"xpath=(//div[@id='chartListItem'])["+Pracount+"]");
				waitForPageLoad(selenium);
				break;
			}
		}
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Assoicate provider //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddProvider),"Could not click the add button from tha Assoicate provider", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Count the provider
			
			int providerCount = (Integer) selenium.getXpathCount("xpath=(//span[@id='providerName'])");
			String assoicateProvider[] =new String[100];
			
			for(count=1; count<=providerCount; count++){
				String prvTemp = getText(selenium,"xpath=(//span[@id='providerName'])["+count+"]");
				String tempArray[] = prvTemp.split(" ");
				assoicateProvider[count] = (String) (tempArray[2]+" "+tempArray[1]);
				System.out.println(assoicateProvider[count] );
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnCancelProvider),"Could not click the cancel button from the Assoicate provider", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,btnBack),"Could not click the back button r", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Lab queue//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkLabQueue),"Could not click the lab queue", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,forProviderSuggestBox),"Could not click the lab queue", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			/*int labProviderCount = (Integer) selenium.getXpathCount("//div[7]/div/div/div/div/div");
			
			/*if(providerCount==labProviderCount){
				
				for(count = 2; count<=labProviderCount; count++){
					for(count = 2; count<=labProviderCount; count++){
						String providerTemp = getText(selenium,"//div[7]/div/div/div/div/div["+count+"]");
						if(getText(selenium,providerTemp).trim().contains(assoicateProvider[count].trim())){
							break;
						}else
							Assert.fail("The Lab provider is not equal to associate provider");
					}
				}
				
			}else
				Assert.fail("The count is not equal");*/
			
			
			int labProviderCount = providerCount+1;
			int count1=0;
			for(count = 2; count<=labProviderCount; count++){
				String providerTemp = getText(selenium,"//body/div[6]/div/div/div/div/div["+count+"]");
				for(count = 2; count<=labProviderCount; count++){
					
					if(getText(selenium,providerTemp).toLowerCase(new java.util.Locale("en","Us")).trim().contains(assoicateProvider[count1].trim().toLowerCase(new java.util.Locale("en","Us")))){
						providerValue = true;
						break;
					}
					count1=count1+1;
				}
				
				if(!providerValue){
					Assert.fail("The Lab provider is not equal to associate provider");
					
				}
				providerValue = false;
			}

		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return true;
	}
}
