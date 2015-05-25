package com.nexia.selenium.testscripts.section.chartprevisit.SocialHistory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyProviderNameAndDateTimeForSocialHistory  extends AbstractChartPreVisit {

	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify ProviderNameAndDateTime For Social History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProviderNameAndDateTimeForSocialHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib socialData = new ChartPreVisitLib();
		socialData.workSheetName = "CreateSocialHistory";
		socialData.testCaseId = "TC_CSH_001";
		socialData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyProviderName(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	

	/*************************************************************************************************** 
	* @purpose        VerifyProviderNameAndDateaAndTime For Social History
	* @action 		  Verifying ProviderName And DateaAndTime For Social History
	* @author         Aspire QA
	* @throws         IOException 
	* @Ticket         #4013
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Aug 26, 2013
	***************************************************************************************************/	


	public boolean verifyProviderName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib socialData) throws IOException{
		
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
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + socialData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, socialData.userName, socialData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
					
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to System Settings//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, lnkSettings), "Could not click on Quick Actions button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemsetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-3: Verify the User Name//
			//--------------------------------------------------------------------//
			
			Provider_Name1 = verifyUserNameChart(selenium,socialData);
			waitForPageLoad(selenium);
			System.out.println("Provider_Name1"+Provider_Name1);
			assertTrue(click(selenium,btnBack),"Could not click the back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,socialData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete  Social History //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllSocialHistory(selenium,socialData),"Deletion failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
					
			//--------------------------------------------------------------------//
			//  Step-6: Verify Unknown Check Box //
			//--------------------------------------------------------------------//
			
			if(isChecked(selenium,chkNoknownItem)){
				Assert.fail("Verify Unknown Check Box Failed");
			}
		
			//--------------------------------------------------------------------//
			//  Step-7: Create  Social History//
			//--------------------------------------------------------------------//
		
			assertTrue(createSocialHistory(selenium,socialData),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!isElementPresent(selenium,btnDelete)){
			Assert.fail("Create  Social History failed ");	
			}
					
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
			
			assertTrue(click(selenium,lnkMenuArrow),"Could not click the arrow;More Details:"+socialData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(verifyTimeStampForProviderPage(selenium, vfyUserName1, date, time), "Time stamp is not displayed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify the User Name //
			//--------------------------------------------------------------------//
			if(!getText(selenium,vfyUserName1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(Provider_Name1.trim().toLowerCase(new java.util.Locale("en","Us")))){
				Assert.fail("Verify User Name failed in Expand view");
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
