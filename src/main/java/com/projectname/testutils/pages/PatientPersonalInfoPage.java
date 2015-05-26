package com.projectname.testutils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class PatientPersonalInfoPage extends SeleniumWebDriver{

	public  PatientPersonalInfoPage(){
	    PageFactory.initElements(SeleniumWebDriver.driver,this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	private By readyLocator=By.id("editButton");
	private By doNotContactTag=By.xpath("//div[@id='personalInfoDiv']/div[2]");
    private By btnEdit=By.id("editButton");
    private By patientId=By.id("patientID");
    
    
	public boolean verifyDoNotDisturbStatusDemographicsPage(WebDriver driver)
	{
		try
		{
		assertTrue(getText(driver,doNotContactTag).contains("Do not contact"),"Unable to find the do not contact tag",driver,className,methodName);
		}catch(Exception e)
		{
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
		}
		return true;
	}
	
	public boolean verifyDoNotDisturbStatusOnAnthorPracticeDemographicsPage(WebDriver driver)
	{
		try
		{
		assertTrue(!getText(driver,doNotContactTag).contains("Do not contact"),"Unable to find the do not contact tag",driver,className,methodName);
		}catch(Exception e)
		{
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
		}
		return true;
	}
	
	
	public boolean verifyCancelButtonOnPatientDemographicsPage(WebDriver driver)

	{
	assertTrue(click(driver,btnEdit),"Unable to click the edit button",driver,className,methodName);
	waitForPageLoad(driver);
	PatientRegistationPage patientRegPage=new PatientRegistationPage();
	patientRegPage.verifyCancel(driver);
	return true;
	}
	public String getPatientId(WebDriver driver)throws Exception
	{
		String id=getText(driver,patientId);
		return id;
	}
	public PatientRegistationPage clickEditButton(WebDriver driver)

	{
	assertTrue(click(driver,btnEdit),"Unable to click the edit button",driver,className,methodName);
	waitForPageLoad(driver);
	return new PatientRegistationPage();
	}
	
}
