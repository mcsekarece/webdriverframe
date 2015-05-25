package com.nexia.selenium.testscripts.section.schedulingsettings.pDGRecordAttendance;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDateLimitationInRecordAttendance extends AbstractSchedulingTest{
	
	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For verify Created Progarm group in record attendance")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCreateProgramGroupInRecordAttendance(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		
		SchedulingTestLib pdgSeriesData = new SchedulingTestLib();
	    pdgSeriesData.workSheetName = "ProgramAddSeries";
	    pdgSeriesData.testCaseId = "TC_PAS_002";
	    pdgSeriesData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        To verify Created Program group in record attendance
	* @action 		  verify Created Program group in record attendance
	* @expected       To Ensure that the Create Program group in record attendance
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES / & SRS_ADMIN_PDG_Rev 0.0  
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Nov 04, 2013
	***************************************************************************************************/
	public boolean createProgramGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib pdgSeriesData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pdgSeriesData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, pdgSeriesData.userName, pdgSeriesData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
	
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pdgSeriesData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate To Program Group						 		  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Could not navigate to Calender Setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkProgramGroup), "could not able to click the Program group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Program Group					 				  //
			//--------------------------------------------------------------------//
			assertTrue(deleteProgramForPDGAdmin(selenium,pdgSeriesData),"Could not delete Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAdd),"Could not click add new button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-5: Create Program					 						  //
			//--------------------------------------------------------------------//
			SchedulingTestLib pDGData = new SchedulingTestLib();
			pDGData.workSheetName = "ProgramGroupAdmin";
			pDGData.testCaseId = "TC_PDG_010";
			pDGData.fetchSchedulingTestData();
			
			selectValueFromAjaxList(selenium,ajxProgramType,pDGData.programType);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createProgramForPDGAdmin(selenium,pDGData,uniqueName),"Could not Create Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Add New Series											  //
			//--------------------------------------------------------------------//
			assertTrue(addNewSeriesForAttendanceGroup(selenium,pdgSeriesData,userAccount),"Could not Create series", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Added Series										  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnSeriesAction),"Could not click Action ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkViewAllSeries),"Could not click View Series ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyStoredValuesForSeriesInSummary(selenium,pdgSeriesData),"Could not verify the Created series in the summary", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8:Navigate To record attendance							  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToRecordAttendance(selenium, pdgSeriesData, pDGData),"Could not navigate to record attendance section", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: verify Created Program group in record attendance		  //
			//--------------------------------------------------------------------//
			/*assertTrue(verifyStoredValuesForRecordAttendanceSummary(selenium,pdgSeriesData, pDGData),"Could not verify the Created series in record attendance", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Click First record in attendance group participants	  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkFirstRecordAttendance),"Could not click the first record in attendance group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			*/
			
			//--------------------------------------------------------------------//
			//  Step-11: verify the next week and date label in record attendance //
			//--------------------------------------------------------------------//
			Calendar cal1=Calendar.getInstance();

			//add one year from the current year
			cal1.add(Calendar.YEAR,1);

			//this is used for find the first date of the sunday for the current month
			cal1.add( Calendar.DAY_OF_WEEK, -(cal1.get(Calendar.DAY_OF_WEEK)-1)); 
			
			cal1.add(Calendar.DATE, -((cal1.get(Calendar.DATE)/7)*7));
			
			//we set the start date and end date of the series( set end date 3 weeks from the start date)
			//so, we loop three times click the 'next week' and verify the date label result
			for(int count=1; count<=3; count++){
				DateFormat=new SimpleDateFormat("MMM dd-");
				
			 assertTrue(getText(selenium,lblDateShow).toLowerCase(new java.util.Locale("en","US")).trim().contains(DateFormat.format(cal1.getTime()).trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed",selenium, ClassName, MethodName);
			      
				
				DateFormat=new SimpleDateFormat(", yyyy");

				assertTrue(getText(selenium,lblDateShow).toLowerCase(new java.util.Locale("en","US")).trim().contains(DateFormat.format(cal1.getTime()).trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed",selenium, ClassName, MethodName);
				
				cal1.add(Calendar.DATE, 7);
				
				assertTrue(click(selenium,lnkNextWeek),"Could not click the next week link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//After three times of clicking that next week, the next will not work( because, we set the date range like that)
				if(count==3){
					cal1.add(Calendar.DATE, -7);
					
					assertTrue(getText(selenium,lblDateShow).toLowerCase(new java.util.Locale("en","US")).trim().contains(DateFormat.format(cal1.getTime()).trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed",selenium, ClassName, MethodName);
				
				}
				
			}
			
			
			//------------------------------------------------------------------------//
			//  Step-12: verify the previous week and date label in record attendance //
			//------------------------------------------------------------------------//
			for(int count=1; count<=3; count++){
				DateFormat=new SimpleDateFormat("MMM dd-");
				
				assertTrue(getText(selenium,lblDateShow).toLowerCase(new java.util.Locale("en","US")).trim().contains(DateFormat.format(cal1.getTime()).trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed",selenium, ClassName, MethodName);
	
				
				DateFormat=new SimpleDateFormat(", yyyy");

				assertTrue(getText(selenium,lblDateShow).toLowerCase(new java.util.Locale("en","US")).trim().contains(DateFormat.format(cal1.getTime()).trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed",selenium, ClassName, MethodName);
				
				cal1.add(Calendar.DATE, -7);
				
				assertTrue(click(selenium,lnkPreviousWeek),"Could not click the previous week link", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//After three times of clicking that previous week link, the previous will not work( because, we set the date range like that)
				if(count==3){
					assertTrue(getText(selenium,lblDateShow).toLowerCase(new java.util.Locale("en","US")).trim().contains(DateFormat.format(cal1.getTime()).trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed",selenium, ClassName, MethodName);
					      
				}
				
			}
		}
		catch(RuntimeException e){
			e.printStackTrace();
			
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
