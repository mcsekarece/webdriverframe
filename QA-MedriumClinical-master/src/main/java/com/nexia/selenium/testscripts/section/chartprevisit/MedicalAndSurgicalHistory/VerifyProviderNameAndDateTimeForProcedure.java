package com.nexia.selenium.testscripts.section.chartprevisit.MedicalAndSurgicalHistory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyProviderNameAndDateTimeForProcedure extends AbstractChartPreVisit{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify ProviderNameAndDateTime For Procedure")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProviderNameAndDateTimeForProcedure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProcedure";
		proData.testCaseId = "TC_CP_001";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyProviderName(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	
	/**
	 * VerifyProviderNameAndDateaAndTime For Procedure
	 * function to Verifying ProviderName And DateaAndTime For Procedure
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Aug 26,2013
	 */
	
public boolean verifyProviderName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws IOException{
		
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
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + proData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, proData.userName, proData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
					
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to System Settings//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, lnkQuickLink), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSettings),"Could not click show more link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemsetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-3: Verify the User Name//
			//--------------------------------------------------------------------//
			
			Provider_Name1 = verifyUserNameChart(selenium,proData);
			waitForPageLoad(selenium);
			System.out.println("Provider_Name1"+Provider_Name1);
			assertTrue(click(selenium,btnBack),"Could not click the back button", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete Procedure //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkProcedure),"Could not click the procedure link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteProcedure(selenium,proData),"Could not delete the procedure",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
					
			//--------------------------------------------------------------------//
			//  Step-6: Verify Unknown Check Box //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//assertTrue(isChecked(selenium,chkNoknownItem1),"Verify Unknown Check Box Failed",selenium, ClassName, MethodName);
		
			//--------------------------------------------------------------------//
			//  Step-7: Create Procedure//
			//--------------------------------------------------------------------//
		
			assertTrue(createProcedure(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lblProDetails),"Create Procedure failed",selenium, ClassName, MethodName);
				
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
			
			assertTrue(click(selenium,lnkMenuArrow),"Could not click the arrow;More Details:"+proData.toString(), selenium, ClassName, MethodName);
			
			assertTrue(verifyTimeStampForProviderPage(selenium, vfyUserName1, date, time), "Time stamp is not displayed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify the User Name //
			//--------------------------------------------------------------------//
			
			System.out.println(getText(selenium,vfyUserName1));
			
			assertTrue(getText(selenium,vfyUserName1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(Provider_Name1.trim().toLowerCase(new java.util.Locale("en","Us"))),"Verify User Name failed in Expand view",selenium, ClassName, MethodName);
					
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
		}

}
