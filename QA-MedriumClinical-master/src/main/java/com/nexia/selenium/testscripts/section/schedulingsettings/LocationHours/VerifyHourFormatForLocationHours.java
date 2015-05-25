package com.nexia.selenium.testscripts.section.schedulingsettings.LocationHours;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyHourFormatForLocationHours extends AbstractSchedulingTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify 12 hour format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verify12HourFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib lhour = new SchedulingTestLib();
		lhour.workSheetName = "LocationHours";
		lhour.testCaseId = "TC_LH_009";
		lhour.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyHourFormat(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify 24 hour format")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verify24HourFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib lhour = new SchedulingTestLib();
		lhour.workSheetName = "LocationHours";
		lhour.testCaseId = "TC_LH_010";
		lhour.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyHourFormat(seleniumHost, seleniumPort, browser, webSite, userAccount, lhour);
	}

	
	/*************************************************************************************************** 
	* @purpose        To verify 12/24 hour format in location hours
	* @action 		  verifying 12/24 hour format in location hours
	* @expected       To Ensure that 12/24 hour format works fine    
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      June 16, 2013
	***************************************************************************************************/
	public boolean verifyHourFormat(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib lhour) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + lhour.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, lhour.userName, lhour.userPassword),"Login Failed ",selenium, ClassName, MethodName);
	
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,lhour.switchRole),"could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Change Switch Practice										  //
			//--------------------------------------------------------------------//
			 assertTrue(click(selenium,lnkTopPracticeMenu),"Could not click on practice menu",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 int count=1;
			 while(isElementPresent(selenium,"//tr["+count+"]/td/a/span")){
				 if(getText(selenium,"//tr["+count+"]/td/a/span").contains(lhour.practiceName)){
				 click(selenium,"//tr["+count+"]/td/a/span");
				 waitForPageLoad(selenium);
				}else{
					 count++;
				 } if(count>15){
					 break;
				 }
			 }
		        
			
			//--------------------------------------------------------------------//
			//  Step-4:Navigate To Location Hours						  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "could not able to click the quick action link",selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkScheduling), "could not able to click the Scheduling Setting link",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Search Location Hour						  //
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,txtSearchBox,lhour.location1);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,lblLocationHoursDisplay).contains(lhour.location1),"Verify Location hours failed", selenium,ClassName, MethodName);
			  			 
			//--------------------------------------------------------------------//
			//  Step-6: Edit Location Hour						  //
			//--------------------------------------------------------------------//
			assertTrue(editlocationHour(selenium, lhour), "Unit test failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 
			//--------------------------------------------------------------------//
			//  Step-7: Verify Saved Entry for 12 hour and 24 hour
			//--------------------------------------------------------------------//
			if(!isElementPresent(selenium,lnkEdit)){
				 return false;
			} 
			
			if(lhour.testCaseId.equalsIgnoreCase("TC_LH_009")){
				selectValueFromAjaxList(selenium,txtSearchBox,lhour.location1);
				
				String editedLocationHours= lhour.startHour+":"+lhour.startMin+lhour.startFormat.toUpperCase()+" - "+lhour.endHour+":"+lhour.endMin+lhour.endFormat.toUpperCase();
				 
				assertTrue(getText(selenium,lblLocationHours).contains(editedLocationHours),"Verify Location hours failed", selenium,ClassName, MethodName);
				if(!verify12HourFormat(selenium, lhour)){
					return false;
				}
				
			}
			else{
				boolean check24HourFormat;//to tell time format 12/24 for the called function
				
				//set 24 hour format time for current practice
				assertTrue(click(selenium,lnkQuickAction),"Could not click the Quick option", selenium, ClassName, MethodName);
				assertTrue(click(selenium,"systemSettingsAction"),"Could not click the system setting link", selenium, ClassName, MethodName);
				
				check24HourFormat= true;
				searchCurrentPractice(selenium, lhour, check24HourFormat);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-3:Navigate To Location Hours						  //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium, lnkQuickAction), "could not able to click the quick action link",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkScheduling), "could not able to click the Scheduling Setting link",selenium, ClassName, MethodName);
				
				selectValueFromAjaxList(selenium,txtSearchBox,lhour.location1);
				
				String editedLocationHours= convertTo24Hour(lhour.startHour, lhour.startFormat)+":"+lhour.startMin+" - "
															+convertTo24Hour(lhour.endHour, lhour.endFormat)+":"+lhour.endMin;
				 
			    assertTrue(getText(selenium,lblLocationHours).contains(editedLocationHours),"Verify location hours failed",selenium, ClassName, MethodName);
			    
				if(!verify24HourFormat(selenium, lhour)){
					return false;
				}
				assertTrue(click(selenium, btncancelLocationHours), "could not able to click SaveLocatioHours", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				 
				//set 12 hour format time for current practice
				assertTrue(click(selenium,lnkQuickAction),"Could not click on the quick action link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkShowMoreLink),"Could not click on the show more action link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkSystemSetting),"Could not click the systemSettings link;More Deatils:",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				check24HourFormat= false;
				searchCurrentPractice(selenium, lhour, check24HourFormat);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium, "edit"),"Practice Creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isChecked(selenium, chk24HourFormat)){
					return false;
				}
			}
			 
		}
		catch(RuntimeException e){
			e.printStackTrace();
			//assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/**
	 * function to verify 12 hour format
	 * @param selenium
	 * @param lhour
	 * @return
	 */
	private boolean verify12HourFormat(Selenium selenium, SchedulingTestLib lhour){
		try
		{
		assertTrue(click(selenium, lnkEdit), "could not able to click the edit link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		 
		assertTrue(getValue(selenium,txtStartHour).trim().equalsIgnoreCase(lhour.startHour.trim()),"Verification Failed",selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtStartMin).trim().equalsIgnoreCase(lhour.startMin.trim()),"Verification failed",selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,ajxHourFormatStart).trim().equalsIgnoreCase(lhour.startFormat.trim()),"Verification Failed",selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtEndHour).trim().equalsIgnoreCase(lhour.endHour.trim()),"Verification failed",selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,txtEndMin).trim().equalsIgnoreCase(lhour.endMin.trim()),"Verification Failed",selenium, ClassName, MethodName);
			
	    assertTrue(getValue(selenium,ajxHourFormatEnd).trim().equalsIgnoreCase(lhour.endFormat.trim()),"Verification Failed",selenium, ClassName, MethodName);
	    
		}  catch(Exception e)
		{
		  e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * function to verify 24 hour format
	 * @param selenium
	 * @param lhour
	 * @return
	 */
	private boolean verify24HourFormat(Selenium selenium, SchedulingTestLib lhour){
		try
		{
		assertTrue(click(selenium, lnkEdit), "could not able to click the edit link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		 
		String start24HrFormat=convertTo24Hour(lhour.startHour, lhour.startFormat);
		assertTrue(getValue(selenium,txtStartHour).trim().equalsIgnoreCase(start24HrFormat.trim()),"Verification Failed",selenium, ClassName, MethodName);

		assertTrue(getValue(selenium,txtStartMin).trim().equalsIgnoreCase(lhour.startMin.trim()), "Verification Failed",selenium, ClassName, MethodName);
		
		
		String end24HrFormat=convertTo24Hour(lhour.endHour, lhour.endFormat);
		assertTrue(getValue(selenium,txtEndHour).trim().equalsIgnoreCase(end24HrFormat.trim()),"Verification Failed",selenium, ClassName, MethodName);
			
		assertTrue(getValue(selenium,txtEndMin).trim().equalsIgnoreCase(lhour.endMin.trim()),"Verification Failed",selenium, ClassName, MethodName);
		
		if((selenium.isVisible( ajxHourFormatStart) && selenium.isVisible( ajxHourFormatEnd))){
			return false;
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * function to conver time to 24 hour format
	 * @param hour
	 * @param format
	 * @return
	 */
	private String convertTo24Hour(String hour, String format){
		int Hour1=Integer.parseInt(hour);
		//Calculate to 24 hour format
		if(format.equalsIgnoreCase("pm")){
			
			if(Hour1!=12){
				Hour1= Hour1 + 12;
			}
		}
		return String.valueOf(Hour1);
	}
}

