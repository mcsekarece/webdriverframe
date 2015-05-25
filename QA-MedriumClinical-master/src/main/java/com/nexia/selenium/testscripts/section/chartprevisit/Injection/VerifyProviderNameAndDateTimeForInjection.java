package com.nexia.selenium.testscripts.section.chartprevisit.Injection;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyProviderNameAndDateTimeForInjection  extends AbstractChartPreVisit{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify ProviderNameAndDateTime For Injection")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProviderNameAndDateTimeForInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_004";
		injectionData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyProviderName(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        VerifyProviderNameAndDateaAndTime For Injection
	* @action 		  Verifying ProviderName And DateaAndTime For  Injection
	* @author         Aspire QA
	* @throws         IOException 
	* @Ticket         #4013
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Aug 27, 2013
	***************************************************************************************************/
	
	
	
	public boolean verifyProviderName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib injectionData) throws IOException{
		
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
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + injectionData.toString());
				assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, injectionData.userName, injectionData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
						
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
				
				Provider_Name1 = verifyUserNameChart(selenium,injectionData);
				waitForPageLoad(selenium);
				System.out.println("Provider_Name1"+Provider_Name1);
				assertTrue(click(selenium,btnNexiaLogo),"Could not click the back button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-4: Advanced search with Patient ID//
				//--------------------------------------------------------------------//
				
				searchPatientNexiaForProviderHomePage(selenium,injectionData.patientId);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-5: Delete Injection //
				//--------------------------------------------------------------------//
				
				assertTrue(click(selenium,lnkInjection),"Could not click Injections link;More Details:",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(deleteInjection(selenium),"Deletion Failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
									
				//--------------------------------------------------------------------//
				//  Step-6: Verify Unknown Check Box //
				//--------------------------------------------------------------------//
				
				if(isChecked(selenium,chkNoknownItem)){
					Assert.fail("Verify Unknown Check Box Failed");
				}
			
				//--------------------------------------------------------------------//
				//  Step-7: Create injection//
				//--------------------------------------------------------------------//
				String providerNameTemp= getText(selenium, lnkTopMenu);
				String providerName= providerNameTemp.replaceAll(", "+ injectionData.switchRole , "");
				
				assertTrue(createInjection(selenium,injectionData,userAccount,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(!isElementPresent(selenium,btnInjectionEdit)){
				Assert.fail("Create Injection failed ");	
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
				
				assertTrue(click(selenium,lblInjectionCollapseview),"Could not click the arrow;More Details:"+injectionData.toString(), selenium, ClassName, MethodName);
				
				assertTrue(verifyTimeStampForProviderPage(selenium, vfyUserName1, date, time), "Time stamp is not displayed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-9: Verify the User Name //
				//--------------------------------------------------------------------//
				System.out.println(getText(selenium,lblAllerfyDateTime1));
				
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
