package com.nexia.selenium.testscripts.section.schedulingsettings.ResourceCalendars;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class CreatePatternForResourceCalender extends AbstractSchedulingTest {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "CreatePatternForResourceCalender")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPatternForResourceCalender(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();SchedulingTestLib createResourceCalData = new SchedulingTestLib();
		createResourceCalData.workSheetName = "CreateResourceCalender";
		createResourceCalData.testCaseId = "TC_CRC_004";
		createResourceCalData.fetchSchedulingTestData();	
		createPattern(seleniumHost, seleniumPort, browser, webSite, userAccount, createResourceCalData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "CreateMultiPatternForResourceCalender")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createMultiPatternForResourceCalender(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();SchedulingTestLib createResourceCalData = new SchedulingTestLib();
		createResourceCalData.workSheetName = "CreateResourceCalender";
		createResourceCalData.testCaseId = "TC_CRC_003";
		createResourceCalData.fetchSchedulingTestData();	
		createPattern(seleniumHost, seleniumPort, browser, webSite, userAccount, createResourceCalData);
	}
	
	/**     
	  * @purpose        CreatePatternForResourceCalender
     *  @action         Create New Pattern for ResourceCalender With MandatoryFields
     *  @expected       After Create  Pattern for ResourceCalender ,details will be stored properly
     *  @author         Aspire QA
	 * @throws			IOException 
     *  @state          Developing
     *  @useraccount    Both
	  * @since  	    Jun 17, 2013
	*/
	
	
	
	public boolean createPattern(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SchedulingTestLib createResourceCalData) throws  IOException{
		Selenium selenium = null;
		boolean returnValue= true;
		try{
			//--------------------------------------------------------------------//
			// Step 1:Login to the application//
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + createResourceCalData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, createResourceCalData.userName, createResourceCalData.userPassword),"Login Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to SchedulingSettings //
			//--------------------------------------------------------------------//
			
			assertTrue(goToScheduling(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkResourceCalender),"Could not click Resource Calender link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete all Resource Calender //
			//--------------------------------------------------------------------//
                
			//assertTrue(deleteAllResourceCalendar(selenium),"Deletion failed", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			assertTrue(click(selenium,chkIncludeInactiveCheckbox),"Could not click IncludeInactiveCheckbox", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 			 
			 assertTrue(type(selenium,txtSearchResourceCal,createResourceCalData.search),"Could not select search resource"+createResourceCalData.toString(), selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 selenium.typeKeys(txtSearchResourceCal, "a");
			 waitForPageLoad(selenium);
			 	
			 if(getText(selenium,lblResourceCalendarDetials1).toLowerCase(new java.util.Locale("en","US")).trim().contains(createResourceCalData.resource.trim().toLowerCase(new java.util.Locale("en","US")))){
				  if (selenium.isTextPresent("Activate"))					  
				  {				  
				  assertTrue(click(selenium,btnActivate),"Could not click Activate button", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				  assertTrue(click(selenium,btnYesButton),"Could not click Yes button", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				  
				  }
				  assertTrue(click(selenium,btnEdit),"Could not click Edit button", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);			 			 
			  }		
			  else 
			  {  
				assertTrue(click(selenium,btnAdd),"Could not click add new button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			  }
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Add New ResourceCalender //
			//--------------------------------------------------------------------//
            						
			assertTrue(createPatternForResourceCalender(selenium, createResourceCalData,userAccount), "Create pattern for calender failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			     
			/*int resourceCalendarCount=(Integer) selenium.getXpathCount(lnkResourceCalendarDetials2);
			
			 for(int count=1;count<=resourceCalendarCount;count++){
				if(getText(selenium,"//td[2]/div/div/div/div[3]/div/div[2]/table/tbody/tr["+count+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(createResourceCalData.resource.trim().toLowerCase(new java.util.Locale("en","US")))){
					
					assertTrue(click(selenium,"//div[@id='ResourceCalendarsList']/table/tbody/tr["+count+"]/td[2]/div/a"), "Could not click the View Details", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
			    	 break;
				}
					
			 }*/
			 try
			 {
		    if(!verifyStoreValues(selenium,createResourceCalData)){
		    	fail("The Pattern Values are not stored properly");
		    }
		    
		    if(createResourceCalData.testCaseId.equals("TC_CRC_003")){ 
		    	 if(!verifyStoreValuesMulti(selenium,createResourceCalData)){
				    	fail("The Multi Pattern Values are not stored properly");
				    }
		    }}catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		    
			
			
		}
		catch (RuntimeException e){
			
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + createResourceCalData.toString(), selenium, ClassName, MethodName);
			
		}
		return returnValue;
	}
	       
	
	
	
	public boolean  verifyStoreValues(Selenium selenium,SchedulingTestLib createResourceCalData)throws Exception{
		 
		  String date =null;
		  Calendar cal=Calendar.getInstance();
		  SimpleDateFormat DateFormat1=new SimpleDateFormat("MMMM dd");
		  date=DateFormat1.format(cal.getTime());
	
		 assertTrue(type(selenium,txtSearchResourceCal,createResourceCalData.search),"Could not select search resource"+createResourceCalData.toString(), selenium, ClassName, MethodName);
		 waitForPageLoad(selenium);
		 
		 selenium.typeKeys(txtSearchResourceCal, "a");
		 waitForPageLoad(selenium);
		 
		 assertTrue(getText(selenium,lblResourceCalendarDetials1).toLowerCase(new java.util.Locale("en","US")).trim().contains(createResourceCalData.resource.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed",selenium, ClassName, MethodName);
		 
		
		/*if(!getText(selenium,lblResourceCalendarDetials1).toLowerCase(new java.util.Locale("en","US")).trim().contains(createResourceCalData.patternStartsMonth.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;                       
		 }
		if(!getText(selenium,lblResourceCalendarDetials1).toLowerCase(new java.util.Locale("en","US")).trim().contains(createResourceCalData.patternStartsDate.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;                       
		 }*/
		 
		 
		
		 return true;
		 
	 }
	
   public boolean  verifyStoreValuesMulti(Selenium selenium,SchedulingTestLib createResourceCalData)throws Exception{
	   
	      String date =null;
		  Calendar cal=Calendar.getInstance();
		  SimpleDateFormat DateFormat1=new SimpleDateFormat("MMMM dd");
		  date=DateFormat1.format(cal.getTime());
		  
		 assertTrue(type(selenium,txtSearchResourceCal,createResourceCalData.search),"Could not select search resource"+createResourceCalData.toString(), selenium, ClassName, MethodName);
		 waitForPageLoad(selenium);
		 
		 selenium.typeKeys(txtSearchResourceCal, "a");
		 waitForPageLoad(selenium);
		
		 assertTrue(getText(selenium,lblResourceCalendarDetials1).toLowerCase(new java.util.Locale("en","US")).trim().contains(createResourceCalData.resource.trim().toLowerCase(new java.util.Locale("en","US"))),"verification failed",selenium, ClassName, MethodName);
		
		/*if(!getText(selenium,lblResourceCalendarDetials1).toLowerCase(new java.util.Locale("en","US")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		 }
		if(!getText(selenium,lblResourceCalendarDetials1).toLowerCase(new java.util.Locale("en","US")).trim().contains(createResourceCalData.patternStartsMonth.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;                       
		 }
		if(!getText(selenium,lblResourceCalendarDetials1).toLowerCase(new java.util.Locale("en","US")).trim().contains(createResourceCalData.patternStartsDate.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;                       
		 }
		if(!getText(selenium,lblResourceCalendarDetials1).toLowerCase(new java.util.Locale("en","US")).trim().contains(createResourceCalData.patternStartsMonth1.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;                       
		 }
		if(!getText(selenium,vfyStorevaluePattern2).toLowerCase(new java.util.Locale("en","US")).trim().contains(createResourceCalData.patternStartsDate1.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;                       
		 }*/
				 
		 return true;
		 
	 }

}
