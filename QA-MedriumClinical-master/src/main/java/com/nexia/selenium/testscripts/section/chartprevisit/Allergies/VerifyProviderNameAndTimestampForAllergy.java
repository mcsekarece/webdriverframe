package com.nexia.selenium.testscripts.section.chartprevisit.Allergies;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyProviderNameAndTimestampForAllergy extends AbstractChartPreVisit {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify ProviderNameAndDateTime For Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProviderNameAndDateTimeForAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_003";
		allergyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyProviderName(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        VerifyProviderNameAndDateaAndTime For Allergy
	* @action 		  Verifying ProviderName And DateaAndTime For Allergy
	* @author         Aspire QA
	* @throws         IOException 
	* @Ticket         #4013
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Aug 27, 2013
	***************************************************************************************************/
	
	
	public boolean verifyProviderName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws IOException{
		
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
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
					
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
			
			Provider_Name1 = verifyUserNameChart(selenium,allergyData);
			waitForPageLoad(selenium);
			System.out.println("Provider_Name1"+Provider_Name1);
			assertTrue(click(selenium,btnBack),"Could not click the back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete Allergy //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			//--------------------------------------------------------------------//
			//  Step-6: Verify Unknown Check Box //
			//--------------------------------------------------------------------//
			
			if(isChecked(selenium,chkNoknownItem)){
				Assert.fail("Verify Unknown Check Box Failed");
			}
		
			//--------------------------------------------------------------------//
			//  Step-7: Create Allergy//
			//--------------------------------------------------------------------//
		
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium,"//div[@id='AllergyList']/table/tbody/tr/td/div/a")){
				Assert.fail("Create  Allergy failed ");	
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
			
			assertTrue(click(selenium,"//td[2]/div/div/div/div/div[2]"),"Could not click the arrow;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			assertTrue(verifyTimeStampForProviderPage(selenium, lblAllergyUpdatetime, date, time), "Time stamp is not displayed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify the User Name//
			//--------------------------------------------------------------------//
			System.out.println(getText(selenium,vfyUserName));
			if(!getText(selenium,vfyUserName).toLowerCase(new java.util.Locale("en","Us")).trim().contains(Provider_Name1.trim().toLowerCase(new java.util.Locale("en","Us")))){
				Assert.fail("Verify User Name failed in Expand view");
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
