package com.projectname.testutils.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;



import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;



public class HomePage extends SeleniumWebDriver{
	
	protected static By readyLocator = By.id("note");
	private static By  sharedPageReadyLocator = By.linkText("Quick Actions");
	
	private By btnErrorClose = By.id("errorCloseButton");
	private By queueStatements =By.id("Unprintedstatements");
	private By btnNexiaLogo =By.id("logoAnchor");
	private By txtPatientBox = By.id("searchPatientBox");
	private By lblPatientResult=By.id("patientInfoWidget");
	private By lnkPostCharge =By.linkText("Post Charges");
	private By lnkPostNewCharge =By.linkText("Encounter not found. Post new charges.");
	private By viewChart=By.id("viewChart");
	private By txtSearchPatient =By.id("searchTextBox");
	private By lblQueueStatements =By.cssSelector("css=div.box");
	private By lnkOperations =By.id("operationsAction");
	private By lnkWaitListMgmt = By.id("waitListAction");
	
	/***
	 * Call to super constructor
	 */
	public  HomePage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);
		SeleniumWebDriver.isElementPresent(readyLocator);

		}
	
	/**
	 * navigateToSharedPage
	 * function to navigate to shared Page 
	 * @param encounterData 
	 * @param 		userAccount
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */

	public SharedPage navigateToSharedPage(){
		SharedPage pageObject=PageFactory.initElements(SeleniumWebDriver.driver, SharedPage.class);	
		SeleniumWebDriver.isElementPresent(sharedPageReadyLocator);
		return pageObject;
	}
	
	

/**getStatementCount
	 * function to getStatementCount 
	 * @param driver
	 * * @throws IOException
	 * @since Dec 24, 2014
 */
	public Integer getStatementCount(WebDriver driver){
		int  statementCountValue = 0;
		try{
			assertTrue(click(driver,btnNexiaLogo),"Click not Nexia Logo failed", driver, className,methodName);
			waitForPageLoad(driver);
			if(isElementPresent(driver, btnErrorClose))
				assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
				waitForPageLoad(driver);
			String statementCount = getText(driver,queueStatements);
			System.out.println(statementCount);
			String[] splitS = statementCount.split(" ");
		    statementCountValue = Integer.parseInt(splitS[0]);
			System.out.println("StatementCount" + statementCountValue);
			waitForPageLoad(driver);
	    	return statementCountValue;
		}catch(Exception e){
			e.printStackTrace();
			return statementCountValue ;
		}
	
	}
	
	
	/**verifySetStatementGeneratedForCurrentPatient
	 * function to verifySetStatementGeneratedForCurrentPatient 
	 * @param driver
     * @param patientID(Patient ID to be searched)
	 * @since Dec 22, 2014
 */

	public boolean verifySetStatementGeneratedForCurrentPatient(WebDriver driver, String patientData){
		
		try{
			assertTrue(click(driver,btnNexiaLogo),"Click not btn Nexia Logo", driver, className,methodName);
			waitForPageLoad(driver);
				
			if(isElementPresent(driver, btnErrorClose))
			assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
			waitForPageLoad(driver);
			
			assertTrue(click(driver,queueStatements),"Click not Statement Queue", driver, className,methodName);
			waitForPageLoad(driver);
			 
			assertTrue(type(driver,txtPatientBox,patientData),"Could not type patient id", driver, className,methodName);
			waitForPageLoad(driver);
			driver.findElement(txtSearchPatient).sendKeys(Keys.DOWN);
			
			assertTrue(getText(driver,lblQueueStatements).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.trim().toLowerCase(new java.util.Locale("en","US"))),"could not get patient id", driver, className,methodName);
			waitForPageLoad(driver);
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false ;
		}
	}
	
	/**
	 * mousehover
	 * function to mouse hover an element 
	 * @param encounterData 
	 * @param 		userAccount
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */
	
	public boolean  mousehover(WebDriver driver){
		
		try{
			
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "PatientData";
	    patientData.testCaseId = "TC_NPC_001";
		
	    patientData.lastName = "mathew";
	    
		assertTrue(type(driver, txtPatientBox,patientData.lastName),"Could not type patient last name", driver, className,methodName);
		waitForPageLoad(driver);

		assertTrue(click(driver, txtPatientBox),"Could not type patient last name", driver, className,methodName);
		driver.findElement(txtPatientBox).sendKeys(Keys.DOWN);	
				
		waitForElement(driver, lblPatientResult, 10000);
		assertTrue(isElementPresent(driver,lblPatientResult),"Search Results are not displayed for the patient with ID :-", driver, className,methodName);
		waitForPageLoad(driver);
		
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.id("patientInfoWidget"));
		actions.moveToElement(menuHoverLink);

		WebElement subLink = driver.findElement(By.linkText("Post Charges"));
		actions.moveToElement(subLink);
		actions.click();
		actions.perform();
		
		assertTrue(click(driver,lnkPostCharge),"Could not present Post charge link", driver,className, methodName);
		waitForPageLoad(driver);
		
		if(isElementPresent(driver, btnErrorClose))
		assertTrue(click(driver, btnErrorClose),"could not click error close",driver, className, methodName);

	    assertTrue(click(driver, lnkPostNewCharge),"Could not click the Post new charge link", driver,className, methodName);
		waitForPageLoad(driver);
		return true ;
		
		
	}catch(Exception e){
	 e.printStackTrace();
	 return false ;
		}

	}
	
	/**
	 * navigateToPatientChartPage
	 * function to go to patient chart page 
	 * @param encounterData 
	 * @param 		userAccount
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */
    public PatientChartPage navigateToPatientChartPage(WebDriver driver)
    {
    	assertTrue(click(driver,viewChart),"unable to click view chart in the home page",driver,className,methodName);
    	waitForPageLoad(driver);
    	waitForPageLoad(driver);
    	return new PatientChartPage();
    }
    
    /**
	 * verifyQuickActionLink
	 * function to verify quick action link
	 * @param driver 
	 * @since  	May 22, 2015
	 * @version 2.0
	 */
    public HomePage verifyQuickActionLink(WebDriver driver)
    {
    	assertTrue(click(driver,sharedPageReadyLocator),"Could not click the quick action",driver,className,methodName);
    	waitForPageLoad(driver);
		
    	assertTrue(isElementPresent(driver,lnkOperations),"Could not find lnk operations",driver,className,methodName);
    	waitForPageLoad(driver);
    	
    	assertTrue(isElementPresent(driver,lnkWaitListMgmt),"Could not find wait list management",driver,className,methodName);
    	waitForPageLoad(driver);
    	return new HomePage();
    }
	

}
