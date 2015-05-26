package com.projectname.testutils.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.Constants;
import com.projectname.testutils.genericutility.testDataLib.SchedulingTestLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class CalendarPage extends SeleniumWebDriver {

	public CalendarPage(){
		PageFactory.initElements(TestBaseClass.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	private By readyLocator= By.id("!schedulingOperationsCalendar");
	private By searchBoxProvider=By.id("searchResources");
	private By calendarTab=By.id("!schedulingOperationsCalendar");

	private By searchBoxPatient=By.id("searchPatientBoxInBookVisit");
	private By patientPanel=By.id("patientPanel");
	private By btnSave=By.id("save");
	private By btnYes=By.id("yesButton");
	private By ajxreferred=By.id("referredBySuggestBoxsuggestBox");
	private By chkBoxConfirmBook=By.id("rb2Checkbox");
	private By btnSaveWithConfirm=By.xpath("(//button[@id='save'])[2]");
	
	private By lnkCancelVisit=By.linkText("Cancel Visit");
	private By noShowSuggBox=By.xpath("(//input[@id='suggestBox'])[2]");
	
	private By reasonSuggBox=By.id("cancellationReasonSuggestBoxsuggestBox");
	private By authNumber=By.id("authorizationNumberSuggestBoxsuggestBox");
	private By authSuggBox=By.id("authorizationNumberSuggestBoxsuggestBox");
	private By saveCancelVisit=By.xpath("(//a[contains(text(),'Save')])[2]");
	private By editPatientVisit=By.linkText("Edit Patient Visit");
	private By editSave=By.id("editSave");
	
	private By appointmentOne=By.id("appointment1");
	private By appointmentTwo=By.id("appointment2");
	private By resourceCalendar=By.id("visitTypeLink");
	private By dropDown=By.id("currentItem_1");
	String calendarPagePath="scrollPanel";
	String appiontmentPath="appointment";
	
	
	/**
	 * openProvidersCalendar
	 * function to choose particular provider calendar Page 
	 * @param calendarTemplate(TestData)
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */
	
	public boolean openProvidersCalendar(SchedulingTestLib calendarTemplate,WebDriver driver)throws Exception
	{
		if(!isTextPresent(driver,calendarTemplate.search))
		{
	   assertTrue(type(driver,searchBoxProvider,calendarTemplate.search),"Unable to find the resource Name in the serach Box",driver,className,methodName);
	   waitForPageLoad(driver);
	   if(getText(driver,dropDown).contains(calendarTemplate.resource))
	   { 
		  click(driver,dropDown);  
	   }
	   
		}
		return true;
	}
	
	/**
	 * deleteAllAppointment
	 * function to delete all appointment which are previously created 
	 * @param calendarTemplate(TestData)
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */
	public boolean deleteAllAppointment(WebDriver driver,SchedulingTestLib calendarTemplate)throws Exception
	{
		int count=1;
		
		WebElement scrollUp = driver.findElement(By.id(calendarPagePath));
		scrollUp.sendKeys(Keys.PAGE_UP);
		waitForPageLoad(driver);
		scrollUp.sendKeys(Keys.PAGE_UP);
		while(isElementPresent(driver,By.id(appiontmentPath+count)))
		{
			driver.findElement(By.id(appiontmentPath+count)).click();
			waitForPageLoad(driver);
			assertTrue(click(driver,lnkCancelVisit),"Unable to click the link",driver,className,methodName);
			waitForPageLoad(driver);
			assertTrue(selectValueFromAjaxList(driver,reasonSuggBox,calendarTemplate.editStatus),"Unable to select the value from ajax list",driver,className,methodName);
			assertTrue(click(driver,saveCancelVisit),"Unable to click the save button",driver,className,methodName);
			waitForPageLoad(driver);
		}
		return true;
	}
	/**
	 * makeResourceAppointment
	 * function to create an appointment for a provider in calendar page  
	 * @param calendarTemplate(TestData)
	 * @since  	Jan 22, 2015
	 * @version 2.1
	 */
	public boolean makeResourceAppointment(WebDriver driver, SchedulingTestLib calendarTemplate,String appointmentCount,String patientId) throws Exception {
	  waitForPageLoad(driver);
	    String date=null;
	    String hour=null;
	    String coordinate=null;
	    assertTrue(click(driver,calendarTab),"Unable to click the calendar page",driver,className,methodName);
	    waitForPageLoad(driver);
		    Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("a");
			date = DateFormat.format(cal.getTime());
			SimpleDateFormat Hour1 = new SimpleDateFormat("HH");
			hour =Hour1.format(cal.getTime());
			if(date.equals("AM"))
			{
				coordinate=valueCalcForAM(hour,appointmentCount);
			}
			else if(date.equals("PM"))
			{
				coordinate=valueCalcForPM(hour,appointmentCount);
			}
		WebElement mnuElement3 = driver.findElement(By.id(coordinate));
	    Actions builder3 = new Actions(driver);					
		builder3.moveToElement(mnuElement3).clickAndHold().build().perform();
		assertTrue(click(driver,resourceCalendar),"Unable to click the element",driver,className,methodName);
		waitForElement(driver,searchBoxPatient,Constants.WAIT_TIME*100);
		if(!patientId.equals(""))
		{
			calendarTemplate.patientId=patientId;
		}
		type(driver,searchBoxPatient,calendarTemplate.patientId);
		waitForElement(driver,patientPanel,Constants.WAIT_TIME*100);
		click(driver,patientPanel);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		if(isElementPresent(btnYes)){
			click(btnYes);
		}
		if(calendarTemplate.referredByPracticename!=""){
			assertTrue(selectOtherValueFromAjaxList(driver, ajxreferred, calendarTemplate.referredByPracticename, calendarTemplate.referredByProvider),"Unable to select Referred provider name by practice name number",driver,className,methodName);
		}
		if(calendarTemplate.verifyAuthorization!=""){
			assertTrue(selectValueFromAjaxList(driver,authNumber,calendarTemplate.verifyAuthorization),"Unable to select authorization number",driver,className,methodName);
		}
	
		assertTrue(click(driver,btnSave),"Unable to click the save button",driver,className,methodName);
		waitForPageLoad(driver);
		if(isElementPresent(driver,btnSaveWithConfirm))
		{
			assertTrue(click(driver,chkBoxConfirmBook),"Unable to click the confirm check box",driver,className,methodName);
			click(driver,btnSaveWithConfirm);
			waitForPageLoad(driver);
		}
		return true;
 }	
	/**
	 * valueCalcForAM
	 * function to calculate dynamic values to interact with calendar page depending upon the local system time  
	 * @param Time(local system time)
	 * @param count(number of appointment going to be created)
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */
	public String valueCalcForAM(String time,String count){
		String value=null;
		if(count.equals("one"))
	{
		if(time.equals("24"))
		{
			return "x0y2";
		}
		if(time.equals("01"))
		{
			return "x0y14";
		}
		if(time.equals("02"))
		{
			return "x0y26";
		}
		if(time.equals("03"))
		{
			return "x0y38";
		}
		if(time.equals("04"))
		{
			return "x0y50";
		}
		if(time.equals("05"))
		{
			return "x0y62";
		}
		if(time.equals("06"))
		{
			return "x0y74";
		}
		if(time.equals("07"))
		{
			return "x0y86";
		}
		if(time.equals("08"))
		{
			return "x0y98";
		}
		if(time.equals("09"))
		{
			return "x0y110";
		}
		if(time.equals("10"))
		{
			return "x0y122";
		}
		if(time.equals("11"))
		{
			return "x0y134";
		}
	}	
	else if(count.equals("two"))
	{
		if(time.equals("24"))
		{
			return "x0y5";
		}
		if(time.equals("01"))
		{
			return "x0y17";
		}
		if(time.equals("02"))
		{
			return "x0y29";
		}
		if(time.equals("03"))
		{
			return "x0y41";
		}
		if(time.equals("04"))
		{
			return "x0y53";
		}
		if(time.equals("05"))
		{
			return "x0y65";
		}
		if(time.equals("06"))
		{
			return "x0y77";
		}
		if(time.equals("07"))
		{
			return "x0y89";
		}
		if(time.equals("08"))
		{
			return "x0y101";
		}
		if(time.equals("09"))
		{
			return "x0y113";
		}
		if(time.equals("10"))
		{
			return "x0y125";
		}
		if(time.equals("11"))
		{
			return "x0y137";
		}
	}
	else if(count.equals("three"))
	{
		if(time.equals("12"))
		{
			return "x0y8";
		}
		if(time.equals("01"))
		{
			return "x0y20";
		}
		if(time.equals("02"))
		{
			return "x0y32";
		}
		if(time.equals("03"))
		{
			return "x0y44";
		}
		if(time.equals("04"))
		{
			return "x0y57";
		}
		if(time.equals("05"))
		{
			return "x0y68";
		}
		if(time.equals("06"))
		{
			return "x0y80";
		}
		if(time.equals("07"))
		{
			return "x0y92";
		}
		if(time.equals("08"))
		{
			return "x0y104";
		}
		if(time.equals("09"))
		{
			return "x0y117";
		}
		if(time.equals("10"))
		{
			return "x0y128";
		}
		if(time.equals("11"))
		{
			return "x0y140";
		}
	}
		return value;
	}
	
	/**
	 * valueCalcForAM
	 * function to calculate dynamic values to interact with calendar page depending upon the local system time  
	 * @param Time(local system time)
	 * @param count(number of appointment going to be created)
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */
	public String valueCalcForPM(String time,String count){
		String value=null;
	if(count.equals("one"))
	{
		if(time.equals("12"))
		{
			return "x0y146";
			
		}
		if(time.equals("13"))
		{
			return "x0y158";
			
		}
		if(time.equals("14"))
		{
			return "x0y170";
			
		}
		if(time.equals("15"))
		{
			return "x0y182";
			
		}
		if(time.equals("16"))
		{
			return "x0y194";
			
		}
		if(time.equals("17"))
		{
			return "x0y206";
			
		}
		if(time.equals("18"))
		{
			return "x0y218";
		}
		if(time.equals("19"))
		{
			return "x0y230";
		}
		if(time.equals("20"))
		{
			return "x0y242";
		}
		if(time.equals("21"))
		{
			return "x0y254";
		}
		if(time.equals("22"))
		{
			return "x0y266";
		}
		if(time.equals("23"))
		{
			return "x0y278";
		}
	}
	else if(count.equals("two"))
	{
		if(time.equals("12"))
		{
			return "x0y149";
			
		}
		if(time.equals("13"))
		{
			return "x0y161";
			
		}
		if(time.equals("14"))
		{
			return "x0y173";
			
		}
		if(time.equals("15"))
		{
			return "x0y185";
			
		}
		if(time.equals("16"))
		{
			return "x0y197";
			
		}
		if(time.equals("17"))
		{
			return "x0y209";
			
		}
		if(time.equals("18"))
		{
			return "x0y221";
		}
		if(time.equals("19"))
		{
			return "x0y233";
		}
		if(time.equals("20"))
		{
			return "x0y245";
		}
		if(time.equals("21"))
		{
			return "x0y257";
		}
		if(time.equals("22"))
		{
			return "x0y269";
		}
		if(time.equals("23"))
		{
			return "x0y281";
		}
	}
	else if(count.equals("three"))
	{
		if(time.equals("12"))
		{
			return "x0y152";
		}
		if(time.equals("13"))
		{
			return "x0y164";
		}
		if(time.equals("14"))
		{
			return "x0y176";
		}
		if(time.equals("15"))
		{
			return "x0y188";
		}
		if(time.equals("16"))
		{
			return "x0y200";			
		}
		if(time.equals("17"))
		{
			return "x0y212";	
		}
		if(time.equals("18"))
		{
			return "x0y224";
		}
		if(time.equals("19"))
		{
			return "x0y236";
		}
		if(time.equals("20"))
		{
			return "x0y248";
		}
		if(time.equals("21"))
		{
			return "x0y260";
		}
		if(time.equals("22"))
		{
			return "x0y272";
		}
		if(time.equals("23"))
		{
			return "x0y284";
		}
	}
		return value;
	}
	/**
	 * cancelVisit
	 * function to cancel already created appointment in the calendar page
	 * @param calendarTemplate(TestData)
	 * @since  	Jan 23, 2015
	 * @version 2.1
	 */
	public boolean cancelVisit(WebDriver driver,SchedulingTestLib calendarTemplate)throws Exception
	{
			WebElement scrollUp = driver.findElement(By.id(calendarPagePath));
			scrollUp.sendKeys(Keys.PAGE_UP);
			waitForPageLoad(driver);
			scrollUp.sendKeys(Keys.PAGE_UP);
			waitForPageLoad(driver);
			driver.findElement(appointmentOne).click();
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		assertTrue(click(driver,lnkCancelVisit),"Unable to click the link",driver,className,methodName);
		waitForPageLoad(driver);
		assertTrue(selectValueFromAjaxList(driver,reasonSuggBox,calendarTemplate.editStatus),"Unable to select the value from ajax list",driver,className,methodName);
		assertTrue(click(driver,saveCancelVisit),"Unable to click the save button",driver,className,methodName);
		waitForPageLoad(driver);
		return true;
	}

	/**
	 * editPatientVisit
	 * function to Edit patient visit already created in the calendar page
	 * @param calendarTemplate(TestData)
	 * @since  	Jan 23, 2015
	 * @version 2.1
	 */
	public boolean editPatientVisit(WebDriver driver,SchedulingTestLib calendarTemplate,String testCaseId)throws Exception
	{
		WebElement scrollUp = driver.findElement(By.id(calendarPagePath));
		scrollUp.sendKeys(Keys.PAGE_UP);
		waitForPageLoad(driver);
		scrollUp.sendKeys(Keys.PAGE_UP);
		waitForPageLoad(driver);
		if(!testCaseId.equals("TC_ETE_007"))
		{
			driver.findElement(appointmentOne).click();
		}
		if(testCaseId.equals("TC_ETE_007"))
		{
			driver.findElement(appointmentTwo).click();
		}
		assertTrue ( click(driver,editPatientVisit) ,"Unable to click the patient edit link",driver,className,methodName);
		waitForElement(driver,noShowSuggBox,Constants.WAIT_TIME*100);
		if(!calendarTemplate.editStatus.equals(""))
		{
			if(calendarTemplate.editStatus.equals("No Show"))
			{
				assertTrue(selectValueFromAjaxList(driver,noShowSuggBox,calendarTemplate.editStatus),"Unable to select the no show",driver,className,methodName);
			}
		}
		if(!calendarTemplate.editStatus.equals(""))
		{
			if(calendarTemplate.editStatus.equals("Auth Changed"))
			{
				assertTrue(selectValueFromAjaxList(driver,authSuggBox,calendarTemplate.verifyAuthorization),"Unable to enter the authorizaiton value",driver,className,methodName);
			}
		}
		assertTrue(click(driver,editSave),"unable to save after selecting no show value",driver,className,methodName);
		waitForPageLoad(driver);
		return true;
	}
	
	
	
	
}
