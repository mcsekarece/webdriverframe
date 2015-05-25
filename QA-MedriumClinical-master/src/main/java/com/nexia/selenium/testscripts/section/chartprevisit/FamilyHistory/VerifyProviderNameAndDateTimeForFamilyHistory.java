package com.nexia.selenium.testscripts.section.chartprevisit.FamilyHistory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyProviderNameAndDateTimeForFamilyHistory extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify ProviderNameAndDateTime For FamilyHistory")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProviderNameAndDateTimeForFamilyHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "CreateFamilyHistory";
		historyData.testCaseId = "TC_CFM_001";
		historyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyProviderName(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	/*************************************************************************************************** 
	* @purpose        VerifyProviderNameAndDateaAndTime For Family History
	* @action 		  Verifying ProviderName And DateaAndTime For Family History
	* @author         Aspire QA
	* @throws         IOException 
	* @Ticket         #4013
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Aug 26, 2013
	***************************************************************************************************/	

	
	public boolean verifyProviderName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
	
	    Selenium selenium=null;
		boolean returnValue=true;
		String date = null;
		String time = null;
		String Provider_Name1 = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + historyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
					
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to System Settings//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, lnkSettings), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemsetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-3: Verify the User Name//
			//--------------------------------------------------------------------//
			
			Provider_Name1 = verifyUserNameChart(selenium,historyData);
			waitForPageLoad(selenium);
			System.out.println("Provider_Name1"+Provider_Name1);
			assertTrue(click(selenium,btnBack),"Could not click the back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete Family History //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteFamilyHistory(selenium,historyData ),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
								
			//--------------------------------------------------------------------//
			//  Step-6: Verify Unknown Check Box //
			//--------------------------------------------------------------------//
			
			if(isChecked(selenium,chkNoknownItem)){
				Assert.fail("Verify Unknown Check Box Failed");
			}
		
			//--------------------------------------------------------------------//
			//  Step-7: Create Family History//
			//--------------------------------------------------------------------//
		
			assertTrue(createFamilyHistory(selenium,historyData),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnFamilyEdit),"Creation failed",selenium, ClassName, MethodName);
							
		   //--------------------------------------------------------------------//
		   //  Step-8: Verify Time Stamp and User//
		   //--------------------------------------------------------------------//
			
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
					date=DateFormat.format(cal.getTime());
					int date1=Integer.parseInt(date);
					if(date1<10){
						SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
						date=DateForma1t.format(cal.getTime());
						System.out.println(date);
						DateFormat=new SimpleDateFormat("HH");
						time=DateFormat.format(cal.getTime());
					}else{
						SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");
						date=DateFormat2.format(cal.getTime());
						DateFormat=new SimpleDateFormat("HH");
						time=DateFormat.format(cal.getTime());
					}
				}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
				DateFormat=new SimpleDateFormat("HH");
				time=DateFormat.format(cal.getTime());
			}
			
			assertTrue(click(selenium,lblInjectionCollapseview),"Could not click the arrow;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			assertTrue(verifyTimeStampForProviderPage(selenium, lblLastUpdateBy, date, time), "Time stamp is not displayed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify the User Name //
			//--------------------------------------------------------------------//
			System.out.println(getText(selenium,vfyUserName));
			
			assertTrue(getText(selenium,vfyUserName).toLowerCase(new java.util.Locale("en","Us")).trim().contains(Provider_Name1.trim().toLowerCase(new java.util.Locale("en","Us"))),"Could not find the text"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
