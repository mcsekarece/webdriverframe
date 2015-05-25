package com.nexia.selenium.testscripts.section.demographics.frontOfficeHomePage;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAppointmentsOnFoHomePage extends AbstractHomeTest {
	HomeLib PatientData = new HomeLib();
	@Test(groups = {"AdvancedSmoke","Regression ","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying Count of Appointment Schedule")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCountOfAppointmentSchedule(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_001";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	
	@Test(groups = {"Regression ","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying Appointment Schedule")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAppointmentSchedule(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_002";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	
	@Test(groups = {"Regression ","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verfying Pie Chart")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPieChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "NewPatientCheckIn";
		PatientData.testCaseId = "TC_NPC_003";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createSchedule(seleniumHost, seleniumPort, browser, webSite, userAccount, PatientData);
	}
	
		/*************************************************************************************************** 
		* @purpose        To verify appointment schedule on front office home page
		* @action 		  To verify appointment schedule on front office home page
		* @author         Aspire QA
		* @state          Developing
		* @useraccount    Both
		* @since  	      Sep 23, 2012
		***************************************************************************************************/
	
		public boolean createSchedule(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws Exception{
			Selenium selenium = null;
			boolean returnValue = false;
			
			try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
				
				
				
				//--------------------------------------------------------------------//
				//  Step-2:Change Switch Role  										  //
				//--------------------------------------------------------------------//
				assertTrue(switchRole(selenium,patientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				
				
				//--------------------------------------------------------------------//
				//  Step-3:Add Resources to my view										  //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,btnNexiaLogo),"Could not click Nexia logo button;More Deatils:"+patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium, btnErrorClose))
				{
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
				}	
				assertTrue(isElementPresent(selenium,lnkViewCalender),"Could not find view calander;More Deatils:"+patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
	
				assertTrue(click(selenium,lnkViewCalender1),"Could not click view calander;More Deatils:"+patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
	
				if(!isElementPresent(selenium,lnkAddResource)){
					Assert.fail("My View Not Present");
				}
				
				assertTrue(click(selenium,lnkAddResource),"Could not click Add resource button;More Deatils:"+patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,"css=div.margin-top-10 > div.search-box-wrapper > a.searchMagnifier"),"Could not click search icon button;More Deatils:"+patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				int count=1;
				while(isElementPresent(selenium,"//div["+count+"]/div/div/span/input")){
					click(selenium, "//div["+count+"]/div/div/span/input");
					count++;
					
					if(count>15){
						break;
					}
				}
				
				if(isElementPresent(selenium,lnkCurrentVIew)){
					
				assertTrue(click(selenium,lnkViewCalender),"Could not click Add resource button;More Deatils:"+patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,"link=Set current view as My View"),"Could not set current view;More Deatils:"+patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnNexiaLogo),"Could not click on nexia logo;More Deatils:"+patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(isElementPresent(selenium, btnErrorClose))
		    			assertTrue(click(selenium, btnErrorClose),"Could not click error button", selenium, ClassName, MethodName);
				
				//--------------------------------------------------------------------//
				//  Step-4: Verify Count of Appointment schedule 								  //
				//--------------------------------------------------------------------//
				
				click(selenium,btnNexiaLogo);
				
				if(isElementPresent(selenium, btnErrorClose))
		    			assertTrue(click(selenium, btnErrorClose),"Could not Click error button", selenium, ClassName, MethodName);
				
				 assertTrue(isElementPresent(selenium,btnAppointmentCout),"Could not find the count of appointments",selenium, ClassName, MethodName);
		         waitForPageLoad(selenium);
		         
		         String resultList=getText(selenium,"css=span.gwt-InlineHTML");
				 String[] splitS = resultList.split(" ");
				 int metricResult1 = Integer.parseInt(splitS[0]);
				 System.out.println(metricResult1);
					
				 if(metricResult1>=0){
					returnValue=true;
				}
				else{
					Assert.fail("Could not find appointments schedule on front ofice home page");;
				}
			
				 if(patientData.testCaseId.contains("TC_NPC_003")){
					 
					 if(metricResult1>0){
						 assertTrue(getText(selenium,lblAppointment).contains("%"),"could not get text",selenium,ClassName,MethodName);
						 assertTrue(getText(selenium,lblAppointment).contains("Dr"),"could not get text",selenium,ClassName,MethodName);
					 }
					 else{
						 assertTrue(getText(selenium,lblAppointment).contains("No data"),"Pie chart didn't appear",selenium,ClassName,MethodName);
						 System.out.println("Create Schduling appointment manually for verifying the pie chart on home page");
					 }
				 }
		         
				//--------------------------------------------------------------------//
				//  Step-5:Verify Appointment schedule								  //
				//--------------------------------------------------------------------//	
				
				 if(patientData.testCaseId.contains("TC_NPC_002")){
					 
					 if(metricResult1>0){
						 assertTrue(getText(selenium,lblAppointment).contains("Returning patients")||getText(selenium,lblAppointment).contains("First-time appointments"),"Subset appointment didn't appear",selenium,ClassName,MethodName);
							 return true;
						 
					 }
					 else{
						 System.out.println("Create Schduling appointment manually for verifying the appoitment on home page");
						 return true;
					 }
				 }
				 
				}
			}
			catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
			return returnValue;
		}
	}