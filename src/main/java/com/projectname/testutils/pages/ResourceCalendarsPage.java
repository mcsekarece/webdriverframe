package com.projectname.testutils.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.testDataLib.SchedulingTestLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class ResourceCalendarsPage extends SeleniumWebDriver{
	
	public   ResourceCalendarsPage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);
		SeleniumWebDriver.isElementPresent(readyLocator);
		}
	
	private static By readyLocator = By.xpath("//a/div");
	private By ajxResCalOwnerBoxsuggestBox = By.id( "resCalOwnerBoxsuggestBox");
	private By ajxLocationSuggestBox = By.id( "suggestBox");
	private By ajxvisitLocationsuggestBox =  By.id("visitLocationBoxsuggestBox");
	private By ajxvisitTypesuggestBox =  By.id("visitTypeOrGroupBoxsuggestBox");
	private By ajxrunningMonthsBoxsuggestBox =  By.id("runningMonths");
	private By txtResCalEffectiveDate =  By.id("resCalEffectiveDate");
	private By lnkStartBlank =  By.id("startBlank");
	private By btnLocationNext = By.id( "locationNextButton");
	private By btnresCalSave =  By.id("resCalSave");
	private By chkbxIncludeInactive = By.id("includeInactiveTemplatescheckbox");
	
	//Make Resource Appointment
	private By ajxTimeSuggestBox = By.id("setupEndTime-hour");
	private By txtMaxBooking =By.id( "maxBookings");
	private By btnAppointmentSave = By.id("saveButton");
	   
	   
	/*
	 * createResourceCalender
	 * function to createResourceCalender With MandatoryFields
	 * @since  	     June 07, 2013
	 */	

	 public boolean  createResourceCalender(WebDriver driver,SchedulingTestLib createResourceCalData, String account) throws Exception{
			String date = null;  
			assertTrue(clickClassName(driver,"add-button"),"Could not click add New button Class", driver, className, methodName);
			waitForPageLoad(driver);	
			if(createResourceCalData.testCaseId.equals("TC_SBA_006")){
			 assertTrue(selectValueFromAjaxList(driver,ajxResCalOwnerBoxsuggestBox,createResourceCalData.searchResource),"Could not select search resource", driver, className, methodName);

			}else{
				assertTrue(selectValueFromAjaxList(driver,ajxResCalOwnerBoxsuggestBox,createResourceCalData.searchResource),"Could not select search resource", driver, className, methodName);
	
			}			
			assertTrue(type(driver,ajxrunningMonthsBoxsuggestBox,createResourceCalData.cycle),"Could not select proper cycle", driver, className, methodName);		   
    
			if(account.contains("CA")){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat1.format(cal.getTime());
		    }else {
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
			}
			assertTrue(enterDate(driver,txtResCalEffectiveDate,date),"Could not enter the Effective Date;More Details:"+createResourceCalData.toString(),driver, className, methodName);

		    assertTrue(click(driver,lnkStartBlank),"Could not click Start Blank Link;More Details:", driver, className, methodName);
			assertTrue(selectValueFromAjaxList(driver,ajxLocationSuggestBox,createResourceCalData.location),"Could not select the location", driver, className, methodName);

			assertTrue(click(driver,btnLocationNext),"Could not click location Next Button;More Details:", driver, className, methodName);
			// Make 5 different daily appointments in a week (Monday-Friday)
			assertTrue(makeResourceAppointment(driver, createResourceCalData,"Mon"), "Create Appointment failed", driver, className, methodName);
			
			assertTrue(makeResourceAppointment(driver, createResourceCalData, "Tue"), "Create Appointment failed", driver, className, methodName);
		
			assertTrue(makeResourceAppointment(driver, createResourceCalData, "Wed"), "Create Appointment failed", driver, className, methodName);
		
			assertTrue(makeResourceAppointment(driver, createResourceCalData, "Thu"), "Create Appointment failed", driver, className, methodName);
	
			assertTrue(makeResourceAppointment(driver, createResourceCalData,"Fri"), "Create Appointment failed", driver, className, methodName);
		
		    assertTrue(click(driver,btnresCalSave),"Could not click Start Blank Link;More Details:", driver, className, methodName);
					    	    
			if(isChecked(driver,chkbxIncludeInactive)){
				assertTrue(click(driver,chkbxIncludeInactive),"Could not click check include inactive", driver, className, methodName);
				waitForPageLoad(driver);
			}
			if(!isXPathElementPresent(driver,"//a[contains(text(),'Edit')]")){
				return false;
			}
		 return true;
   }
	 /**
		 * Make an appointment
		 * function to create New Calendar Template
	 * @throws InterruptedException 
	 * @throws IOException 
		 * @since  	     June 06, 2013
	 */
	 
	 public boolean makeResourceAppointment(WebDriver driver, SchedulingTestLib createResourceCalData, String WeekDay) throws Exception {
		    waitForPageLoad(driver);
		    if (WeekDay.equals("Mon"))
		    {System.out.println("Inside the Monday Loop");
		    	WebElement mnuElement2 = driver.findElement(By.id(createResourceCalData.coordinateMon));
		    Actions builder2 = new Actions(driver);					
			builder2.moveToElement(mnuElement2).clickAndHold().build().perform();
			}
		    else if(WeekDay.equals("Tue")) 
		    {System.out.println("Inside the Tuesday Loop");
		    WebElement mnuElement3 = driver.findElement(By.id(createResourceCalData.coordinateTues));
		    Actions builder3 = new Actions(driver);					
			builder3.moveToElement(mnuElement3).clickAndHold().build().perform();				    
		    }
		    else if(WeekDay.equals("Wed")) 
		    {System.out.println("Inside the Wednesday Loop");
		    WebElement mnuElement4 = driver.findElement(By.id(createResourceCalData.coordinateWed));
		    Actions builder4 = new Actions(driver);					
			builder4.moveToElement(mnuElement4).clickAndHold().build().perform();				    
		    }
		    else if(WeekDay.equals("Thu")) 
		    {System.out.println("Inside the Thursday Loop");
		    WebElement mnuElement5 = driver.findElement(By.id(createResourceCalData.coordinateThur));
		    Actions builder5 = new Actions(driver);					
			builder5.moveToElement(mnuElement5).clickAndHold().build().perform();				    
		    }
		    else if(WeekDay.equals("Fri")) 
		    {System.out.println("Inside the Friday Loop");
		    WebElement mnuElement6 = driver.findElement(By.id(createResourceCalData.coordinateFri));
		    Actions builder6 = new Actions(driver);					
			builder6.moveToElement(mnuElement6).clickAndHold().build().perform();				    
		    }
			waitForPageLoad(driver);
			waitForPageLoad(driver);					
			assertTrue(selectValueFromAjaxList(driver,ajxvisitLocationsuggestBox,createResourceCalData.location),"Could not click Resource Calender link", driver, className, methodName);

		    assertTrue(selectValueFromAjaxList(driver,ajxvisitTypesuggestBox,createResourceCalData.visitType),"Could not select visitType"+createResourceCalData.toString(), driver, className, methodName);

		    assertTrue(click(driver,ajxTimeSuggestBox),"Could not Click on AM/PM Selection Box", driver, className, methodName );
		    
		    assertTrue(type(driver,ajxTimeSuggestBox,createResourceCalData.startFormat),"Could not Click on PM Selection", driver, className, methodName );
		   waitForPageLoad(driver);
		    assertTrue(type(driver,txtMaxBooking,createResourceCalData.maxBooking),"Could not select proper cycle"+createResourceCalData.toString(), driver, className, methodName);

		    assertTrue(click(driver,btnAppointmentSave),"Could not click Save button", driver, className, methodName );
		    waitForPageLoad(driver);
			return true;
	 }
	 
	 /*
		 * createResourceCalender
		 * function to createResourceCalender With MandatoryFields
		 * @since  	     June 07, 2013
		 */	
	 
		 public boolean  editResourceCalender(WebDriver driver,SchedulingTestLib createResourceCalData, String account) throws Exception{
				String date = null;  
				if(createResourceCalData.testCaseId.equals("TC_SBA_006")){
				 assertTrue(selectValueFromAjaxList(driver,ajxResCalOwnerBoxsuggestBox,createResourceCalData.searchResource),"Could not select search resource", driver, className, methodName);
				 waitForPageLoad(driver);
				}else{
					assertTrue(selectValueFromAjaxList(driver,ajxResCalOwnerBoxsuggestBox,createResourceCalData.searchResource),"Could not select search resource", driver, className, methodName);
					waitForPageLoad(driver);
				}
				assertTrue(type(driver,ajxrunningMonthsBoxsuggestBox,createResourceCalData.cycle),"Could not select proper cycle", driver, className, methodName);
			    waitForPageLoad(driver);	     
				if(account.contains("CA")){
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
					date=DateFormat1.format(cal.getTime());
			    }else {
						Calendar cal=Calendar.getInstance();
						SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
						date=DateFormat1.format(cal.getTime());
				}
				assertTrue(enterDate(driver,txtResCalEffectiveDate,date),"Could not enter the Effective Date;More Details:"+createResourceCalData.toString(), driver, className, methodName);
			    waitForPageLoad(driver);
			    assertTrue(makeResourceAppointment(driver, createResourceCalData, "Monday"), "Create Appointment failed", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(makeResourceAppointment(driver, createResourceCalData, "Tuesday"), "Tuesday Appointment failed", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(makeResourceAppointment(driver, createResourceCalData, "Wednesday"), "Wednesday Appointment failed", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(makeResourceAppointment(driver, createResourceCalData, "Thursday"), "Thursday Appointment failed", driver, className, methodName);
				waitForPageLoad(driver);
				assertTrue(makeResourceAppointment(driver, createResourceCalData,"Friday"), "Friday Appointment failed", driver, className, methodName);
				waitForPageLoad(driver);
			  	assertTrue(click(driver,btnresCalSave),"Could not click save button;More Details:", driver, className, methodName);
				waitForPageLoad(driver);
			         return true;
                }
}