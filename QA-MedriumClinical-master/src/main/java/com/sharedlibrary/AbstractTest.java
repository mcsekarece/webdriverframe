package com.sharedlibrary;

import static com.sharedlibrary.ThreadSafeSeleniumSessionStorage.session;
import static com.sharedlibrary.ThreadSafeSeleniumSessionStorage.startSeleniumSession;
import static com.sharedlibrary.ThreadSafeSeleniumSessionStorage.startSeleniumSessionWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import com.sharedlibrary.annotations.MapToTestLink;
import com.sharedlibrary.testlink.xmlrpcclient.TestLinkAPIClient;
import com.sharedlibrary.testlink.xmlrpcclient.TestLinkAPIException;
import com.sharedlibrary.testlink.xmlrpcclient.TestLinkAPIResults;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleniumException;
import com.thoughtworks.selenium.Wait;

public class AbstractTest {
	public int possition =1;
	public String chkServiceCode1="//input[@id='002ETE_checkboxcheckbox']";
	public String lnkPatientOption = "link=Patient Options";
	public String btnNexiaLogo ="logoAnchor";
	public String AdvDownarrow="arrowAnchor";
	public String lblWaitlist="showListButton";
	public String lblHeader="//div[4]/div/div/div[2]/div/div";
	public String lnkContinue="link=Continue";
	public String lnkContinuelogout="link=Continue logging out";
	public String lnkTopMenu="username";
	public String TabSummaryMore="!chartSummaryMore";
	public String txtSearchPatRefile="xpath=(//input[@id='searchPatientBox'])[2]";
	public String lnkLocationHeader = "locationMenuHeader";
	public String lnkPractice="xpath=(//a[contains(@id,'practice')])[2]";
	public String lnkSignout="signOutAction";
	public String lnkBtnYes="link=Yes";
	public String lnkBtnContinue="link=Continue";
	public String btnYes="id=Yes";
	public String currentItem="currentItem_1";
	public String taskMenu="//div[@id='Tasks']/div/span[2]";
			public String searchBox="id=searchTextBox";
	public String suggBox="id=suggestBox";
	public String	checkElement="//div[@id='taskListItem']/div[2]/span[2]";

	public String btnYes1="Yes";
	public String btnSearchAction="searchActionButton";
	public String lnkSearchPatient="searchPatient";
	public String txtHeaderSearch="headerSearchInput";
	public String lnkSearch="headerMagnifierButton";
	public String lblPatientId="cellPatientId";
	public String lblPatient="//div[@id='fixedcontent']/div[2]/div[1]/div[1]/div/a";
	public String lblpatientName = "patientName";
	public String btnWizardNext1="//a[@id='wizardNextButton']/div";
	public String lnkviewchart="link=View chart";
	public String btnActivateAutoGen="link=Deactivate auto generation of statements";

	public String txtBalanceAtLeast="//input[@id='balanceAtLeast']";

	public String txtWriteOffBalance="(//input[@id='balanceAtLeast'])[2]";
	public String lblpatientname1 ="patientName";
	public String txtPatientBox="searchPatientBox";
	public String txtPatientBoxBookVisit="searchPatientBoxInBookVisit";
	public String lblPatientResult="patientInfoWidget";
	public String lblPatientResult2="patientPanel";
	public String btnErrorClose="errorCloseButton";
	public String lblPatientInfoSummary="!patientInfoSummary";
	public String lblPatientName="patientName";
	public String lnkPatientSelect="doNotShowAgaincheckbox";
	public String txtAccount="loginAccountText";
	public String txtUserName="loginUseridText";
	public String txtPassword="loginPasswordText";
	public String btnLogin="loginButton";
	public String lnkClinicalHeader="headerClinicalMenu";
	public String btnAgree="agreeButton";
	public String lnkSwitchrole="switchRoleAction";
	public String ajxSwitchrole1="xpath=(//input[@id='suggestBox'])[2]";
	public String ajxSwitchrole="suggestBox";
	public String txtDeleteReason="deleteReason";
	public String lblAjaxList="css=div.gwt-PopupPanel.localizedSuggestBoxOracle";
	public String lblAjaxList1="css=div.quickListSuggestBoxOracle";
	public String lblAjaxList2="css=div.gwt-PopupPanel.dropdown-box";
	public String lblImageLoad="//img[@src='images/loading2.gif']";
	
	public String ClassName=null;
	public String MethodName=null;
	public String password = fetchProperty("clinical", "UsPwd").trim().equals("") ? "0" : fetchProperty("clinical", "UsPwd").trim();
	public String USAccount = fetchProperty("clinical", "USAccount").trim().equals("") ? "0" : fetchProperty("clinical", "USAccount").trim();
	public String CAAccount = fetchProperty("clinical", "CAAccount").trim().equals("") ? "0" : fetchProperty("clinical", "CAAccount").trim();
	//public String USAccount2 = fetchProperty("clinical", "USAccount2").trim().equals("") ? "0" : fetchProperty("clinical", "USAccount2").trim();
	public final static  ArrayList<Selenium> seleniumSessions = new ArrayList<Selenium>();
	public final static ArrayList<WebDriver> driverSessions = new ArrayList<WebDriver>();
	public int WAIT_TIME = fetchProperty("clinical", "waittime").trim().equals("") ? 0 : Integer.parseInt(fetchProperty("clinical", "waittime").trim());
	public String pauseTime = fetchProperty("clinical", "pausetime").trim().equals("") ? "0" : fetchProperty("clinical", "pausetime").trim();
	public String url = fetchProperty("clinical", "url").trim().equals("") ? "0" : fetchProperty("clinical", "url").trim();
	public String port = fetchProperty("clinical", "url").trim().equals("") ? "0" : fetchProperty("clinical", "port").trim();
	public String database = fetchProperty("clinical", "url").trim().equals("") ? "0" : fetchProperty("clinical", "database").trim();
	public String dbusername = fetchProperty("clinical", "dbusername").trim().equals("") ? "0" : fetchProperty("clinical", "dbusername").trim();
	public String dbpwd = fetchProperty("clinical", "dbpwd").trim().equals("") ? "0" : fetchProperty("clinical", "dbpwd").trim();

	//--------------------------------------------------------//
	//  Record Locking                                    //
	//--------------------------------------------------------//
  public String lnkSecuritysetting="securitySettingsAction";
  public String lnkRecordLocking="!recordLockingMain";
  public String lnkQuickAction="link=Quick Actions";
  public String lnkLocationMenuHeader = "locationMenuHeader";
  public String lnkSettings="link=Settings";
  public String lnkSearchR="//input[@id='searchTextBox']/parent::div/following-sibling::a";
  public String chkEntry="css=input[type=\"checkbox\"]";
  public String lnkUnlock="link=Unlock";
  public String lnkEditRL="link=Edit";
  public String txtRTime="css=input.gwt-TextBox";
  public String ajxTimeUnit="timeUnitSuggestBoxanchor";
  public String lblRecordLockPopupEdit="css=button.secondary-button.absoluteTopRight";
  public String lblRecordLockEdit="css=span.gwt-InlineHTML";
  public String lblRecordLockDelete="css=div.gwt-Label";
  public String lblRecordLockClose="css=a.close-popup-x.close-help-about-popup";
  public String btnNo="no";
  public String btnYesbutton = "yesButton";
  public String back="back";
private Capabilities capability;

//------------------------------------------------------//
// 	Testlink
//-----------------------------------------------------//
//EnvironmentPropertiesReader environmentPropertiesReader;
String notes=null;
String testLinkResult=null;
TestLinkAPIClient api=null;

	
  	
  
  	
  	
  	
  	
  
	public Selenium getSession(String seleniumHost, int seleniumPort,String browser, String webSite) {
		if(session()== null){
			startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
			seleniumSessions.add(session());
			session().setTimeout("210000");
			session().windowMaximize();
		}else{
			// Handling Logout
			
			if(click(session(), lnkTopMenu)){
				if(click(session(), lnkSignout)){
					// increment the possition value after sign out
					possition =1;
					if(isElementPresent(session(),btnYes)){
						click(session(),btnYes);
					}else if(isElementPresent(session(),lnkBtnContinue)){
						click(session(),lnkBtnContinue);
						if(isElementPresent(session(),btnYes)){
							click(session(),btnYes);
						}else{
							click(session(),lnkBtnYes);
						}
					}else if(isElementPresent(session(),lnkContinuelogout)){
						click(session(),lnkContinuelogout);
						if(isElementPresent(session(),btnYes)){
							click(session(),btnYes);
						}else{
							click(session(),lnkBtnYes);
						}
					}
					
					else{
						click(session(),lnkBtnYes);
					}
					int confirmationCounter = 0;
					while(confirmationCounter < (WAIT_TIME/1000)){
						try {
							Thread.sleep(1000);
							confirmationCounter++;
						} catch (InterruptedException e) {
								e.printStackTrace();
					}
					if(session().isAlertPresent()){
						session().chooseCancelOnNextConfirmation();
						break;
						}
					}
				}
			}
		}try{
			session().deleteAllVisibleCookies();
			session().open("/");
			session().waitForPageToLoad("130000");
		}catch(SeleniumException e){
			try {
				session().stop();
			} catch (RuntimeException e1) {

			}
			startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
			seleniumSessions.add(session());
			session().setTimeout("210000");
			session().windowMaximize();
			session().deleteAllVisibleCookies();
			session().open("/");
			session().waitForPageToLoad("130000");
		}
		return session();
	}
	
		
	
	
	public Selenium getSessionWebdriver(String seleniumHost, int seleniumPort,String browser, String webSite, WebDriver driver) {
		if(session()== null){
			startSeleniumSessionWebDriver(seleniumHost, seleniumPort, browser, webSite,driver);
			seleniumSessions.add(session());
			session().setTimeout("210000");
			session().windowMaximize();


		}else{
			// Handling Logout
			
			if(click(session(), lnkTopMenu)){
				if(click(session(), lnkSignout)){
					
					click(session(),btnYes);
					int confirmationCounter = 0;
					while(confirmationCounter < (WAIT_TIME/1000)){
						try {
							Thread.sleep(1000);
							confirmationCounter++;
						} catch (InterruptedException e) {
								e.printStackTrace();
					}
					if(session().isAlertPresent()){
						session().chooseCancelOnNextConfirmation();
						break;
						}
					}
				}
			}
		}try{
			session().deleteAllVisibleCookies();
			session().open("/");
			session().waitForPageToLoad("130000");
		}catch(SeleniumException e){
			try {
				session().stop();
			} catch (RuntimeException e1) {

			}
			startSeleniumSessionWebDriver(seleniumHost, seleniumPort, browser, webSite,driver);
			seleniumSessions.add(session());
			session().setTimeout("210000");
			//driver.manage().window().maximize();
			session().windowMaximize();
			session().deleteAllVisibleCookies();
			session().open("/");
			session().waitForPageToLoad("130000");
		}
		return session();
	}
	


	public WebDriver getWebdriver(String seleniumHost, int seleniumPort,String browser, String webSite,String className, String methodName, WebDriver driver) throws SecurityException, IOException {
	
        try{       

        	getWebDriverLog(driver, className, methodName);
        	    	
        	InetAddress IP=InetAddress.getLocalHost();
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setBrowserName(browser);			
			
			
			
			driver = new RemoteWebDriver(new URL("http://"+seleniumHost+":5555/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			//driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
			
			if(!IP.getHostAddress().equals("10.33.1.183") )	    	    	
		    {    	    	
				driver.manage().window().maximize();
		    }		            	
        	driver.manage().deleteAllCookies();
        	driver.get(webSite);			
			
			
		}catch(WebDriverException e){
			try {
				driver.close();
			} catch (RuntimeException e1) {

			}			
		}
		return driver;
	}

	public void getWebDriverLog(WebDriver driver, String className,String methodName) throws IOException {
		
		 try{
		
		InetAddress IP=InetAddress.getLocalHost();
    	
	    // If the Selenium Tests are running on any VMs in the Markham lab or Jenkins then following are the conditions
	    if( IP.getHostAddress().equals("10.1.21.90") || IP.getHostAddress().equals("10.33.3.20") || IP.getHostAddress().equals("10.33.2.140") || IP.getHostAddress().equals("10.33.3.87") || IP.getHostAddress().equals("10.33.2.159")|| IP.getHostAddress().equals("10.1.13.90")|| IP.getHostAddress().equals("10.1.13.91"))	    	    	
	    {    	    	
	    	String OutputDirectory = "\\\\MARQAA04\\Failure-Screenshot";
	    	outputWebDriverLogs(OutputDirectory, driver, className, methodName);	    	    	
	    } 
	    // Jenkins Linux Machine
	    else if (IP.getHostAddress().equals("10.33.1.183") )
	    {
	    	String OutputDirectory = "/mnt/marqaa04";
	    	outputWebDriverLogs(OutputDirectory, driver, className, methodName);    	    	
	    }	
	    	
	    else    	    	
	    {    	    	    	
	    	String OutputDirectory = "C:" + File.separator + "SeleniumWD-Logs";	    	    	
	    	File theDir = new File(OutputDirectory);	    	    	
	    	if (!theDir.exists())
			  {
			    System.out.println("creating directory: " + theDir);
			    boolean result = false;
			    try{
			    	result = theDir.mkdirs();
			    	
			    }
			    catch (Exception e) {
					System.out.println(e);
				}
			    if(result){    
			       System.out.println(theDir + " DIR created");  
			    }

			  }
	    	
	    	outputWebDriverLogs(OutputDirectory, driver, className, methodName);	    	    	
	    }  	
	    
		 }catch(RuntimeException e){
				try {
					driver.close();
				} catch (RuntimeException e1) {

				}			
			} catch (UnknownHostException e2) {
			System.err.println("IP address Not found" + e2.getMessage() );
			e2.printStackTrace();
		} 

		
	}
	
	
  public void outputWebDriverLogs(String OutputDirectory,WebDriver driver, String className,String methodName) throws SecurityException, IOException {		
	  	  
	  try{
		  
		    String logName = className + "_" + methodName  + "_"+ new SimpleDateFormat("MM-dd-yyyy_HH").format(new GregorianCalendar().getTime()) + ".txt";
		    String logPath = OutputDirectory +  File.separator + logName;	    	
			    			    
			Logger logger = Logger.getLogger(RemoteWebDriver.class.getName());
			FileHandler fh;
			fh = new FileHandler(logPath,true);
			logger.addHandler(fh);
			logger.setLevel(Level.ALL);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logger.addHandler(fh);		    
		    
	  }catch(WebDriverException e){
			try {
				driver.close();
			} catch (RuntimeException e1) {

			}			
		}  		
   }
	

  public void copyWebDriverLogs(WebDriver driver, String className,String methodName) throws SecurityException, IOException {
			  
	  try{
		  
		  InetAddress IP=InetAddress.getLocalHost();
	    	
		    // If the Selenium Tests are running on any VMs in the Markham lab or Jenkins then following are the conditions
		    if( IP.getHostAddress().equals("10.1.21.90") || IP.getHostAddress().equals("10.33.3.20") || IP.getHostAddress().equals("10.33.2.140") || IP.getHostAddress().equals("10.33.3.87") || IP.getHostAddress().equals("10.33.2.159")|| IP.getHostAddress().equals("10.1.13.90")|| IP.getHostAddress().equals("10.1.13.91"))	    	    	
		    {    	    	
		    	String OutputDirectory2 = "\\\\MARQAA04\\Failure-Screenshot";	    	
		    	
		      	String logName = className + "_" + methodName  + "_"+ new SimpleDateFormat("MM-dd-yyyy_HH").format(new GregorianCalendar().getTime()) + ".txt";
		    	String logPath = OutputDirectory2 +  File.separator + logName;		    			    
			   
		    	// Copy the captured testcase log file to report html folder
				 String strBasePath = null;
				 String file = null;
				 File dir1 = new  File (".");		    		    
				 strBasePath=dir1.getCanonicalPath();
				 file=strBasePath + File.separator + "test-output" + File.separator + "html";
				 File destDir = new File(file);
				 FileUtils.copyFileToDirectory(new File(logPath), destDir);
				  
				 reportWebDriverLog(logName);		    		    	    	
		    } 
		    // Jenkins Linux Machine
		    else if (IP.getHostAddress().equals("10.33.1.183") )
		    {
		    	String OutputDirectory2 = "/mnt/marqaa04";		    	
		    	String logName = className + "_" + methodName  + "_"+ new SimpleDateFormat("MM-dd-yyyy_HH").format(new GregorianCalendar().getTime()) + ".txt";
		    	String logPath = OutputDirectory2 +  File.separator + logName;		    			    
			   		    	
			    // Copy the testcase log file to report html folder
			    String strBasePath = null;
			    String file = null;
			    
			    File dir1 = new  File (".");		    
			    strBasePath=dir1.getCanonicalPath();
			    file=strBasePath + File.separator + "target" + File.separator + "surefire-reports" + File.separator + "html" ;
			    File destDir = new File(file);
			    FileUtils.copyFileToDirectory(new File(logPath), destDir);
			    
		    	reportWebDriverLog(logName);		    	
		    }	
		    	
		    else    	    	
		    {    	    	    	
		    	String OutputDirectory2 = "C:" + File.separator + "SeleniumWD-Logs";
		    	
		    	String logName = className + "_" + methodName  + "_"+ new SimpleDateFormat("MM-dd-yyyy_HH").format(new GregorianCalendar().getTime()) + ".txt";
		    	String logPath = OutputDirectory2 +  File.separator + logName;		    			    
			   
		    	// Copy the captured testcase log file to report html folder
				 String strBasePath = null;
				 String file = null;
				 File dir1 = new  File (".");		    		    
				 strBasePath=dir1.getCanonicalPath();
				 file=strBasePath + File.separator + "test-output" + File.separator + "html";
				 File destDir = new File(file);
				 FileUtils.copyFileToDirectory(new File(logPath), destDir);
				  
				 reportWebDriverLog(logName);		    	
		    }  	
		    
	  }catch(WebDriverException e){
			try {
				driver.close();
			} catch (RuntimeException e1) {

			}			
		}  		
   }
  
   protected Selenium initiateSeleniumConnection(String seleniumHost, int seleniumPort,String browser,String webSite){
		startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
		Selenium selenium = session();
		selenium.setTimeout("180000");
		selenium.windowMaximize();
		return selenium;
	}

	protected Selenium initiateSeleniumConnectionWebdriver(String seleniumHost, int seleniumPort,String browser,String webSite,WebDriver driver){
		startSeleniumSessionWebDriver(seleniumHost, seleniumPort, browser, webSite,driver);
		/*WebDriver driver = new FirefoxDriver();
		Selenium selenium = new  WebDriverBackedSelenium(driver, webSite);*/
		Selenium selenium = session();
		selenium.setTimeout("180000");
		selenium.windowMaximize();
		return selenium;
	}
	
	
	public void searchPatient(Selenium selenium,String patientID){	
		click(selenium,btnSearchAction);
		click(selenium,lnkSearchPatient);
		waitForElement(selenium, txtHeaderSearch,10000);
		type(selenium,txtHeaderSearch, patientID);
		selenium.click(lnkSearch);
		waitForPageLoad(selenium);
		waitForElement(selenium, lblPatientId+patientID,10000);
		try {
			assertTrue(selenium.isElementPresent(lblPatientId+patientID),"Search Results are not displayed for the patient with ID :- "+ patientID, selenium, ClassName,MethodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(selenium,lblPatientId+patientID);
		waitForPageLoad(selenium);
	}
	
	/**
	 * goToAdvancedSearchPage
	 * function to navigate to Advanced Search Page
	 * @param 		selenium
	 * @since  	     Feb 08, 2012
	 */	
	public boolean goToAdvancedSearchPage(Selenium selenium) {
		boolean returnValue = false;
		waitForElement(selenium, lblPatient, 4000);
		if (isElementPresent(selenium, lblPatient)) {
			int i = 0;
			while (!selenium.isElementPresent(txtPatientBox)) {
				if (i == 10)
					break;
				try {
					i++;
					click(selenium, lblPatientResult);
					Thread.sleep(900);
				} catch (Exception e) {
					System.out.println(e.toString());
					break;
				}
			}
			if (isElementPresent(selenium, lnkTopMenu)) {
				returnValue = true;
			}
		}
		return returnValue;
	}
	
	/**
	 * clickAndVerify
	 * function Will click on the element and verify the click happened
	 * @param 		selenium
	 * @param 		elementToBeClicked
	 * @param 		elementToVarify
	 
	 * @since  	     Feb 08, 2012
	 */	
	public boolean clickAndVerify(Selenium selenium, String elementToBeClicked, String elementToVarify) {
		boolean returnValue = false;
		waitForElement(selenium, elementToBeClicked, 4000);
		if (isElementPresent(selenium, elementToBeClicked)) {
			int i = 0;
			while (!selenium.isElementPresent(elementToVarify)) {
				if (i == 10)
					break;
				try {
					i++;
					click(selenium, elementToBeClicked);
					Thread.sleep(900);
				} catch (Exception e) {
					System.out.println(e.toString());
					break;
				}
			}
			if (isElementPresent(selenium, elementToVarify)) {
				returnValue = true;
			}
		}
		return returnValue;
	}
	
	/**
	 * searchPatientNexia
	 * function for Searching a patient in the Nexia application   
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws IOException 
	 
	 * @since  	     Feb 21, 2012
	 */
	public boolean searchPatientNexia(Selenium selenium,String patientID) throws IOException{
		try{
			
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click on error close", selenium, ClassName,MethodName);
		assertTrue(type(selenium,txtPatientBox,patientID),"Could not type patient id", selenium, ClassName,MethodName);
		
		selenium.clickAt("searchPatientBox","");
		selenium.focus("searchPatientBox");			
		selenium.fireEvent("searchPatientBox","keypress");		
		
		//selenium.keyPress(txtPatientBox, "\\9");
		waitForElement(selenium,lblPatientResult,10000);
		if(selenium.isElementPresent("css=div.patientInfoWidget")){
		assertTrue(selenium.isElementPresent("css=div.patientInfoWidget"),"Search Results are not displayed for the patient with ID :-"+patientID, selenium, ClassName,MethodName);
		
		assertTrue(getText(selenium,"css=div.patientInfoWidget").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not get patient id", selenium, ClassName,MethodName);
		click(selenium,"css=div.patientInfoWidget");
		}else{
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patientID, selenium, ClassName,MethodName);
			assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not get patient id", selenium, ClassName,MethodName);
			click(selenium,lblPatientResult);
		}
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium,lblPatientInfoSummary),"The searched patient information could not be loaded", selenium, ClassName,MethodName);
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click on error close", selenium, ClassName,MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return true;
	}

		
	/**
	 * searchPatientNexia
	 * function for Searching a patient in the Nexia application for NoAccess   
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws IOException 
	 
	 * @since  	     August 21, 2013
	 */
	public boolean searchPatientNexiaNoAccess(Selenium selenium,String patientID) throws IOException{
		try{
			
		//assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
		//assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);	
			
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click on error close", selenium, ClassName,MethodName);
		assertTrue(type(selenium,txtPatientBox,patientID),"Could not type patient id", selenium, ClassName,MethodName);
		selenium.keyPress(txtPatientBox, "\\9");
		waitForElement(selenium,lblPatientResult,10000);		
		assertTrue(!selenium.isElementPresent("css=div.patientInfoWidget"),"Search Results are displayed for the patient with ID :-"+patientID, selenium, ClassName,MethodName);
		assertTrue(!getText(selenium,"css=div.patientInfoWidget").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))),"could not get patient id", selenium, ClassName,MethodName);
				
		}		
		catch(RuntimeException e){
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * searchPatientNexia
	 * function for Searching a patient in the Nexia application for NoAccess (Mix Security)   
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws IOException 
	 
	 * @since  	     Feb 20 21, 2014
	 */
	
	public boolean searchPatientNexiaMixSecurityNoAccess(Selenium selenium,String patientID) throws IOException{
		try{
			
		assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
		assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);	
			
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose), "could not click error close", selenium, ClassName,MethodName);
		assertTrue(type(selenium,txtPatientBox,patientID),"Could not type patient id", selenium, ClassName,MethodName);
		selenium.keyPress(txtPatientBox, "\\9");
		waitForElement(selenium,lblPatientResult,10000);		
		assertTrue(!selenium.isElementPresent("css=div.patientInfoWidget"),"Search Results are displayed for the patient with ID :-"+patientID, selenium, ClassName,MethodName);
		assertTrue(!getText(selenium,"css=div.patientInfoWidget").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))),"could not click error close", selenium, ClassName,MethodName);
				
		}		
		catch(RuntimeException e){
			e.printStackTrace();
		}
		return true;
	}	
		
	
	/**
	 * searchPatientNexiaUsingWebDriver
	 * function for Searching a patient in the Nexia application   
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws IOException 
	 
	 * @since  	     Feb 21, 2012
	 */
	public void searchPatientNexiaUsingWebDriver(Selenium selenium,String patientID,WebDriver driver) throws IOException{
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		assertTrue(type(selenium,txtPatientBox,patientID),"Could not type patient id", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		driver.findElement(By.id(txtPatientBox)).sendKeys(Keys.TAB);
		waitForPageLoad(selenium);
		//selenium.keyPress(txtPatientBox, "\\9");
		waitForElement(selenium,lblPatientResult,10000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patientID, selenium, ClassName,MethodName);
		assertTrue(getText(selenium,lblPatientResult).contains(patientID),"could not get patient id", selenium, ClassName,MethodName);
		click(selenium,lblPatientResult);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium,lblPatientInfoSummary),"The searched patient information could not be loaded", selenium, ClassName,MethodName);
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		
	}
	
	/**
	 * searchPatientNexiaForProviderHomePage
	 * function for Searching a patient in the Nexia application   
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws IOException 
	 
	 * @since  	    Sep 29, 2012
	 */
	public boolean searchPatientNexiaForProviderHomePage(Selenium selenium,String patientID){
	try{
		assertTrue(type(selenium,txtPatientBox,patientID),"Could not type patient id", selenium, ClassName,MethodName);
		selenium.clickAt("searchPatientBox","");
		selenium.focus("searchPatientBox");			
		selenium.fireEvent("searchPatientBox","keypress");
		
		//selenium.keyPress(txtPatientBox, "\\9");
		waitForElement(selenium,lblPatientResult,30000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patientID, selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))),"could not get patient id", selenium, ClassName,MethodName);
		//Assert.assertTrue(getText(selenium,lblPatientResult).contains(patientID));
		//waitForPageLoad(selenium);
		click(selenium,lblPatientResult);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium,lblPatientName),"The searched patient information could not be loaded", selenium, ClassName,MethodName);
		if(isElementPresent(selenium,lnkPatientSelect)){
			assertTrue(click(selenium,lnkPatientSelect),"Could not select the patient ", selenium, ClassName,MethodName);
		}
		
		
		if(isElementPresent(selenium,lnkContinue)){
			selenium.click(lnkContinue);
		}
		if(isElementPresent(selenium, btnErrorClose))

			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	}catch(RuntimeException e){
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return true;
		
	}

	/**
	 * searchPatientNexiaForProviderHomePage
	 * function for Searching a patient in the Nexia application   
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws IOException 
	 
	 * @since  	    Sep 29, 2012
	 */
	public void searchPatientNexiaForProviderHomePageUsingWebDriver(Selenium selenium,String patientID,WebDriver driver) throws IOException{
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click the error close", selenium, ClassName,MethodName);
		
		assertTrue(type(selenium,txtPatientBox,patientID),"Could not type patient id", selenium, ClassName,MethodName);
	
		driver.findElement(By.id(txtPatientBox)).sendKeys(Keys.TAB);
		waitForPageLoad(selenium);
		waitForElement(selenium,lblPatientResult,10000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patientID, selenium, ClassName,MethodName);
		//Assert.assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))));
		assertTrue(getText(selenium,lblPatientResult).contains(patientID),"could not get patient id", selenium, ClassName,MethodName);
		click(selenium,lblPatientResult);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium,lblPatientName),"The searched patient information could not be loaded", selenium, ClassName,MethodName);
		if(isElementPresent(selenium,lnkPatientSelect)){
			assertTrue(click(selenium,lnkPatientSelect),"Could not select the patient ", selenium, ClassName,MethodName);
		}
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	
	}
	
	/**
	 * searchPatientNexiaCA
	 * function for Searching a patient in the Nexia application   
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws IOException 
	 
	 * @since  	     Feb 21, 2012
	 */
	public void searchPatientNexiaCA(Selenium selenium,String patientID) throws IOException{
		assertTrue(type(selenium,txtPatientBox,patientID),"Could not type patient id", selenium, ClassName,MethodName);
		selenium.clickAt(txtPatientBox,"");
		selenium.focus(txtPatientBox);			
		selenium.fireEvent(txtPatientBox,"keypress");
		//selenium.keyPress(txtPatientBox, "\\9");
		waitForPageLoad(selenium);
		waitForElement(selenium,lblPatientResult,10000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patientID, selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US") ).contains(patientID.toLowerCase(new java.util.Locale("en","US") )),"could not get patient id", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		click(selenium,lblPatientResult);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium,lblPatientName),"The searched patient information could not be loaded", selenium, ClassName,MethodName);
		
	}
	
	/**
	 * waitForElement
	 * function for waiting for the AJAX element load or until the timeOut value    
	 * @param 		selenium
	 * @param 		ajaxElementName (Name of the ajax element)
	 * @param 		timeOutValue (The time out value until which the selenium can wait for the element to load)
	 
	 * @since  	     Mar 24, 2010
	 */
	public boolean waitForElement(final Selenium selenium, final String ajaxElementName, int timeOutValue ){
		try{
			WaitClass wait = new WaitClass(selenium, ajaxElementName) ;
			wait.wait("The Element '" + ajaxElementName + "' did not appear  within "
					+ timeOutValue + " ms.", timeOutValue);
			return true;
		}catch(RuntimeException e){
			return false;	
		}
	}
	
	
	
	
	public boolean waitForElement(WebDriver driver,String ajaxElementName, int timeOutValue ){
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, timeOutValue);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ajaxElementName)));
			wait.withMessage("The Element '" + ajaxElementName + "' did not appear  within "
					+ timeOutValue + " ms.");			
			
			return true;
		}catch(RuntimeException e){
			return false;	
		}
	}

	public boolean waitForXPATHElement(WebDriver driver,String ajaxElementName, int timeOutValue ){
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, timeOutValue);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ajaxElementName)));
			wait.withMessage("The Element '" + ajaxElementName + "' did not appear  within "
					+ timeOutValue + " ms.");			
			
			return true;
		}catch(RuntimeException e){
			return false;	
		}
	}
	

	/**
	 * isElementPresent
	 * function to verify if the AJAX based element is present     
	 * @param 		selenium
	 * @param 		ajaxElementName (Name of the ajax element)
	 
	 * @since  	     Jun 08, 2010
	 */
	public boolean isElementPresent(Selenium selenium, String ajaxElementName, int wait){

		ajaxElementName = ajaxElementName != null ? ajaxElementName.trim():"";
		if(waitForElement(selenium, ajaxElementName,wait)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isElementPresent(WebDriver driver, String ajaxElementName, int wait){

		ajaxElementName = ajaxElementName != null ? ajaxElementName.trim():"";
		if(waitForElement(driver, ajaxElementName,wait)){
			return true;
		}else{
			return false;
		}
	}
	public boolean isXPathElementPresent(WebDriver driver, String ajaxElementName, int wait){

		ajaxElementName = ajaxElementName != null ? ajaxElementName.trim():"";
		if(waitForXPATHElement(driver, ajaxElementName,wait)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isXPATHElementPresent(WebDriver driver,String ajaxElementName) {
		boolean present = false;
		try{
			driver.findElement(By.xpath(ajaxElementName));
			present=true;
			int wait = WAIT_TIME;
			ajaxElementName = ajaxElementName != null ? ajaxElementName.trim():"";
			while(!present && wait > 0) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				wait -= 500;
				driver.findElement(By.xpath(ajaxElementName));
				present=true;
			}
			return present;
		}catch(Exception e){
			e.printStackTrace();
		}
		return present;		
	}	
	
	/**
	 * searchPatientNexiaForCoreespondence Refile
	 * function for Searching a patient in the Nexia application   
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws IOException 
	 
	 * @since  	    Sep 29, 2012
	 */
	public boolean searchPatientNexiaForCorrespondenceRefile(Selenium selenium,String patientID){
	try{
		assertTrue(type(selenium,txtSearchPatRefile,patientID),"Could not type patient id", selenium, ClassName,MethodName);
		assertTrue(clickAt(selenium,txtSearchPatRefile,""),"Could not Perform click at", selenium, ClassName,MethodName);
		assertTrue(focus(selenium,txtSearchPatRefile),"Could not not perform click at ", selenium, ClassName,MethodName);
		selenium.fireEvent(txtSearchPatRefile,"keypress");
		
		//selenium.keyPress(txtPatientBox, "\\9");
		waitForElement(selenium,lblPatientResult,30000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patientID, selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))),"could not get patient id", selenium, ClassName,MethodName);
		//Assert.assertTrue(getText(selenium,lblPatientResult).contains(patientID));
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lblPatientResult),"The searched patient information could not be loaded", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		if(isElementPresent(selenium,lnkContinue)){
			selenium.click(lnkContinue);
		}
		if(isElementPresent(selenium, btnErrorClose))

			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		
	}catch(RuntimeException e){
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return true;
		
	}
	
	public boolean isElementPresent(Selenium selenium,String ajaxElementName) {
		boolean present = false;
		try{
			present = selenium.isElementPresent(ajaxElementName);
			int wait = WAIT_TIME;
			ajaxElementName = ajaxElementName != null ? ajaxElementName.trim():"";
			while(!present && wait > 0) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				wait -= 500;
				present = selenium.isElementPresent(ajaxElementName);
			}
			return present;
		}catch(Exception e){
			e.printStackTrace();
		}
		return present;	
	}
	
	public boolean isElementPresent(WebDriver driver,String ajaxElementName) {
		boolean present = false;
		try{
			driver.findElement(By.id(ajaxElementName));
			present=true;
			int wait = WAIT_TIME;
			ajaxElementName = ajaxElementName != null ? ajaxElementName.trim():"";
			while(!present && wait > 0) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				wait -= 500;
				driver.findElement(By.id(ajaxElementName));
				present=true;
			}
			return present;
		}catch(Exception e){
			e.printStackTrace();
		}
		return present;		
	}
	
	public boolean isElementLinkPresent(WebDriver driver,String ajaxElementName) {
		boolean present = false;
		try{
			driver.findElement(By.linkText(ajaxElementName));
			present=true;
			int wait = WAIT_TIME;
			ajaxElementName = ajaxElementName != null ? ajaxElementName.trim():"";
			while(!present && wait > 0) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				wait -= 500;
				driver.findElement(By.linkText(ajaxElementName));
				present=true;
			}
			return present;
		}catch(Exception e){
			e.printStackTrace();
		}
		return present;		
	}	
	
	
	public boolean isElementVisible(Selenium selenium,String ajaxElementName) {
		boolean present = selenium.isVisible(ajaxElementName);
		int wait = WAIT_TIME;
		ajaxElementName = ajaxElementName != null ? ajaxElementName.trim():"";
		while(!present && wait > 0) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			wait -= 500;
			present = selenium.isVisible(ajaxElementName);
		}
		return present;
	}
	
	public boolean isElementVisible(WebDriver driver,String ajaxElementName) {
		WebElement webElement2 = driver.findElement(By.id(ajaxElementName));		
		boolean present = webElement2.isDisplayed();
		int wait = WAIT_TIME;
		ajaxElementName = ajaxElementName != null ? ajaxElementName.trim():"";
		while(!present && wait > 0) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			wait -= 500;
			present = webElement2.isDisplayed();
		}
		return present;
	}
	

	public boolean isTextPresent(WebDriver driver,String ajaxElementName) {
		boolean present = driver.getPageSource().contains(ajaxElementName);
		int wait = WAIT_TIME;
		ajaxElementName = ajaxElementName != null ? ajaxElementName.trim():"";
		while(!present && wait > 0) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			wait -= 500;
			present = driver.getPageSource().contains(ajaxElementName);
		}
		return present;
	}
	
	/**
	 * isChecked
	 * function to verify if the AJAX based Checkbox is checked     
	 * @param 		selenium
	 * @param 		ajaxCheckboxName (Name of the ajax Checkbox)
	 
	 * @since  	     Jun 17, 2010
	 */
	public boolean isChecked(Selenium selenium, String ajaxCheckboxName){

		ajaxCheckboxName = ajaxCheckboxName != null ? ajaxCheckboxName.trim():"";
		if(waitForElement(selenium, ajaxCheckboxName, WAIT_TIME)){
			if(selenium.isChecked(ajaxCheckboxName)){
				return true;	
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public boolean isTextPresent(Selenium selenium,String ajaxElementName) {
		boolean present = false;
		try{
			present = selenium.isTextPresent(ajaxElementName);
			int wait = WAIT_TIME;
			ajaxElementName = ajaxElementName != null ? ajaxElementName.trim():"";
			while(!present && wait > 0) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				wait -= 500;
				present = selenium.isTextPresent(ajaxElementName);
			}
			return present;
		}catch(Exception e){
			e.printStackTrace();
		}
		return present;	
	}

	/** 
	* isChecked
	 * function to verify if the AJAX based Checkbox is checked for WebDriver     
	 * @param 		selenium
	 * @param 		ajaxCheckboxName (Name of the ajax Checkbox)
	 
	 * @since  	     May 13, 2014
	 */
	public boolean isChecked(WebDriver driver, String ajaxCheckboxName){

		ajaxCheckboxName = ajaxCheckboxName != null ? ajaxCheckboxName.trim():"";
		if(waitForElement(driver, ajaxCheckboxName, WAIT_TIME)){
			if(driver.findElement(By.id(ajaxCheckboxName)).isSelected()){
				return true;	
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	
	
	
	
	/**
	 * waitForValue
	 * function for waiting for value for the AJAX element or until the timeOut value    
	 * @param 		selenium
	 * @param 		ajaxElementName (Name of the ajax element)
	 * @param 		timeOutValue (The time out value until which the selenium can wait for the value in the element) 
	 
	 * @since  	     Mar 24, 2010
	 */
	public boolean waitForValue(Selenium selenium, String ajaxElementName, int timeOutValue ){

		boolean isPresent = false;
		timeOutValue = timeOutValue/100;
		ajaxElementName = ajaxElementName != null ? ajaxElementName.trim():"";

		try{
			if(ajaxElementName.trim().equals(""))
			{
				return isPresent;
			}else if(!waitForElement(selenium, ajaxElementName, timeOutValue)){
				return isPresent;
			}

			for(int i = 0; i<timeOutValue; i++ ){
				if (!selenium.getText(ajaxElementName).trim().equals("")){
					isPresent = true;
					break;
				}else{
					Thread.sleep(100);
					continue;
				}
			}
			return isPresent;
		}catch (RuntimeException e) {
			return isPresent;
		} catch (InterruptedException e) {
			return isPresent;
		}
	}

	/**
	 * waitForListToLoad
	 * function for waiting for List to Load for the AJAX element or until the timeOut value    
	 * @param 		selenium
	 * @param 		listName (Name of the List element)
	 * @param 		timeOutValue (The time out value until which the selenium can wait for the value in the element) 
	 
	 * @since  	     Apr 27, 2010
	 */
	public boolean waitForListToLoad(Selenium selenium, String listName, int timeOutValue ){

		boolean isPresent = false;
		timeOutValue = timeOutValue/100;
		listName = listName != null ? listName.trim():"";

		try{
			if(listName.trim().equals("") || waitForElement(selenium, listName, timeOutValue))
			{
				return isPresent;
			}
			if (waitForValue(selenium, listName, WAIT_TIME)){
				isPresent = true;
			}
			return isPresent;
		}catch (RuntimeException e) {
			return isPresent;
		}
	}

	/**
	 * loginFromPublicSite
	 * This function will login to Clinical Site
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		userAccount
	 * @param 		userName
	 * @param 		userPassword
	 
	 * @since  	     Mar 29, 2010
	 */
	public boolean loginFromPublicSite(Selenium selenium, String userAccount, String userName, String userPassword){		
		if(!waitForElement(selenium, txtAccount, 30000)){
			Assert.fail("Login Page Not loaded More Details; UserAccount :- "+userAccount +"  UserName :- " +userName+ " UserPassword :- "+ userPassword);
		}
		type(selenium, txtAccount, userAccount);
		type(selenium, txtUserName, userName);
		
         type(selenium, txtPassword, userPassword);
		click(selenium, btnLogin);
		
		if(waitForElement(selenium, lnkClinicalHeader, WAIT_TIME) && selenium.isTextPresent("Sign out")){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * loginForNexiaFromPublicSite
	 * This function will login to Nexia Site
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		userAccount
	 * @param 		userName
	 * @param 		userPassword
	 * @throws IOException 
	 
	 * @since  	     Mar 29, 2010
	 */
	public boolean loginForNexiaFromPublicSite(Selenium selenium, String userAccount, String userName, String userPassword) throws IOException{            
		 try{
				if(!waitForElement(selenium, txtAccount, WAIT_TIME*4)){
		        	Assert.fail("Login Page Not loaded More Details; UserAccount :- "+userAccount +"  UserName :- " +userName+ " UserPassword :- "+ userPassword);
		        }
		        type(selenium, txtAccount, userAccount);
		        type(selenium, txtUserName, userName);
		        type(selenium, txtPassword, userPassword);
		        click(selenium, btnLogin);
		        if(isElementPresent(selenium,btnAgree)){
		        	click(selenium,btnAgree);
		        }
		        waitForPageLoad(selenium);
		        waitForPageLoad(selenium);
		      //  if(isElementPresent(selenium, btnErrorClose))
					//assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		        		        
		    //   assertTrue(unlock(selenium),"Unlock failed",selenium, ClassName, MethodName);		        
		        
		        if(waitForElement(selenium, txtPatientBox, WAIT_TIME*3)){
		               return true;
		        }else{
		               return false;
		        	}
		        }catch(RuntimeException e){
		            e.printStackTrace();
		        }/*catch(IOException e){
		       	 e.printStackTrace();
		        }*/
		      return true;
			}
	/**
	 * loginForNexiaFromProviderSite
	 * This function will login For Nexia From Provider Site
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		userAccount
	 * @param 		userName
	 * @param 		userPassword
	 * @throws       IOException 
	 * @since  	     Mar 29, 2010
	 */
	public boolean loginForNexiaFromProviderSite(Selenium selenium, String userAccount, String userName, String userPassword) {            
     try{
		if(!waitForElement(selenium, txtAccount, WAIT_TIME*4)){
        	Assert.fail("Login Page Not loaded More Details; UserAccount :- "+userAccount +"  UserName :- " +userName+ " UserPassword :- "+ userPassword);
        }
		
        type(selenium, txtAccount, userAccount);
        type(selenium, txtUserName, userName);
        type(selenium, txtPassword, userPassword);
        
        click(selenium, btnLogin);
        if(isElementPresent(selenium,btnAgree)){
        	click(selenium,btnAgree);
        }
         //After login wait until the home page loads
          waitForElement(selenium, txtPatientBox, WAIT_TIME*15);
          if(isTextPresent(selenium,"A process on this page did not complete as expected, please retry your action or contact support if this problem persists"))
          {
        	  if(isElementPresent(selenium,btnErrorClose))
        	  {
        		  click(selenium,btnErrorClose);
        	  }
          }
           //if(isElementPresent(selenium, btnErrorClose))
   			//assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
              waitForPageLoad(selenium);
    try
     {
    	//assertTrue(unlock(selenium),"Unlock failed",selenium, ClassName, MethodName);
     }
     catch(Exception e)
     {
    	 
     }
     
        if(waitForElement(selenium, txtPatientBox, WAIT_TIME*3)){
               return true;	
        }else{
               return false;
        }
     }catch(RuntimeException e){
         e.printStackTrace();
     }
	return true;
	}
	
	
	public boolean loginForNexiaForWebdriver(WebDriver driver, String userAccount, String userName, String userPassword) throws InterruptedException{            
	     try{
	    	 
	    	 if(!waitForElement(driver, txtAccount, WAIT_TIME*4)){
	        	Assert.fail("Login Page Not loaded More Details; UserAccount :- "+userAccount +"  UserName :- " +userName+ " UserPassword :- "+ userPassword);
	        }	    	 
	    	         
	    	 driver.findElement(By.id(txtAccount)).sendKeys(userAccount);	    	
	    	 driver.findElement(By.id(txtUserName)).sendKeys(userName);
	    	 driver.findElement(By.id(txtPassword)).sendKeys(userPassword); 
	    	 
	    	 driver.findElement(By.id(btnLogin)).click();
	    	
	    	 if(isElementPresentWebDriver(By.id(btnAgree), driver)){
		         
	    		 driver.findElement(By.id(btnAgree)).click();	    		 
	         }
	    	 
	    	 if(isElementPresentWebDriver(By.id(btnErrorClose), driver)){
		         
	    		 driver.findElement(By.id(btnErrorClose)).click();	    		 
	         }               
	        
	       
	        if(waitForElement(driver, txtPatientBox, WAIT_TIME*3)){
	               return true;
	        }else{
	               return false;
	        }
	     }
	     catch(RuntimeException e){
	         e.printStackTrace();
	     }/*catch(IOException e){
	    	 e.printStackTrace();
	     }*/
		return true;
		}
	/**
	 * getCountOfElementsWithSimilarXpath
	 * This function will return count of all elements which have similar XPaths, differ only by an index.
	 * Example completeXpath = partialXpath1 + index + partialXpath2
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		partialXpath1 (XPath from LHS of index)
	 * @param 		partialXpath2 (XPath from RHS of index)
	 * @since  	     May 12, 2014
	 */
	public int getCountOfElementsWithSimilarXpath(Selenium selenium, String partialXpath1, String partialXpath2) {
		int count = 0;		
		do {
			count++;
		} while (isElementPresent(selenium, partialXpath1 + count + partialXpath2));
		count--;
		return count;
	}
	

	
		
	public static boolean isElementPresentWebDriver(By by, WebDriver driver) 
    {
      boolean present;
      try
        {
          driver.findElement(by);
          present = true;
        }catch (NoSuchElementException e)
        {
          present = false;
         }
     return present;
    }
	
	/**
     * unlock
     * Function to unlock all the locked resources
     * @param selenium
     * @param prescribeData
     * @return
     * @throws IOException 
     * @since Jan 24,2013
     */
    public boolean unlock(Selenium selenium){
      try{
    	  if(isElementPresent(selenium, btnErrorClose))
  			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
    	  waitForPageLoad(selenium);
    	  
    	  assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
          waitForPageLoad(selenium);
          if(isElementPresent(selenium, btnErrorClose))
  			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
          if(isElementPresent(selenium, lnkSecuritysetting)){
	          assertTrue(click(selenium,lnkSecuritysetting),"Could not click on security settings",selenium, ClassName, MethodName);
	          waitForPageLoad(selenium);
	          if(isElementPresent(selenium,lnkRecordLocking)){
	          assertTrue(click(selenium,lnkRecordLocking),"Could not click on Record Locking link",selenium, ClassName, MethodName);
	          waitForPageLoad(selenium);
	          assertTrue(click(selenium,lnkSearchR),"could not click on Search Link",selenium, ClassName, MethodName);
	          waitForPageLoad(selenium);
	          click(selenium,"xpath=(//div[@class='search-box-wrapper'])[2]/a");
	          waitForPageLoad(selenium);
	          if(isElementPresent(selenium, btnErrorClose))
	  	  			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	          if( selenium.isVisible(chkEntry)){
	                assertTrue(click(selenium,chkEntry),"Could not check the entry",selenium, ClassName, MethodName);
	                assertTrue(click(selenium,lnkUnlock),"Could not unlock entry",selenium, ClassName, MethodName);
	                assertTrue(click(selenium,btnYesbutton),"Could not click on yes button",selenium, ClassName, MethodName);
	                waitForPageLoad(selenium);
	               }
	          
	          	assertTrue(click(selenium,btnNexiaLogo),"Could not click the back button", selenium, ClassName, MethodName);
	          }else{
	        	  
	        	  assertTrue(click(selenium,btnNexiaLogo),"Could not click the back button", selenium, ClassName, MethodName);
	          }
	          if(isElementPresent(selenium, btnErrorClose))
	  			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	        }else{
	        	 assertTrue(click(selenium,lnkQuickAction),"Could not click on quick action",selenium, ClassName, MethodName);
	             waitForPageLoad(selenium);
	        }
          }catch(RuntimeException e){
                e.printStackTrace();
          }catch(IOException e){
                e.printStackTrace();
          }
          return true;
    }
    public boolean selectPractice(Selenium selenium, String practice) throws IOException
    {
    	waitForPageLoad(selenium);
    	waitForPageLoad(selenium);
    	waitForPageLoad(selenium);
    	if(!getText(selenium,lnkLocationMenuHeader).contains(practice)){
    		assertTrue(click(selenium,lnkLocationMenuHeader),"Could not click on practices link:", selenium, ClassName, MethodName);
    		waitForPageLoad(selenium);
    	 int Count;
    		int Count1=(Integer) selenium.getXpathCount("//tr/td/a/span");
    		for(Count=1;Count<=Count1;Count++)		{
    			if(getText(selenium,"//tr["+Count+"]/td/a/span").contains(practice)){
    				
    				assertTrue(click(selenium,"//tr["+Count+"]/td/a/span"),"Could not click on practices link:", selenium, ClassName, MethodName);
    				waitForPageLoad(selenium);
    			}
    		}		
    	}		
    	return true;
    }
    /**
   	 * switchRole
   	 * This function will switchRole to Nexia Site
   	 * @param 		selenium (an instance of current selenium browser )
   	 * @param 		switchRole
   	 * @since  	     Mar 29, 2010
   	 */
       public boolean switchRole(Selenium selenium, String switchRole){            
           try{
           	
           	if(!waitForElement(selenium, lnkTopMenu, WAIT_TIME)){
               	Assert.fail(" Top Menu Header not opened More Details; switchRole :- "+switchRole);
               }
       		if(isElementPresent(selenium, btnErrorClose)) {    		
       				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);    			
       		}
       		String TopMenu=getText(selenium, lnkTopMenu);
       		int index=TopMenu.indexOf(',');
       		TopMenu=(TopMenu.substring(index+1)).trim();
       		
       		if(!TopMenu.equalsIgnoreCase(switchRole)){
       			click(selenium,lnkTopMenu);
       	        click(selenium,lnkSwitchrole);
       	        if(isElementPresent(selenium, btnErrorClose)) {    				
       					assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);    				
       				waitForPageLoad(selenium);
       			}	
       	        waitForPageLoad(selenium);
       	        if(selenium.isElementPresent(ajxSwitchrole1))
       	        {
       	        	assertTrue( selectValueFromAjaxList(selenium,ajxSwitchrole1,switchRole),"could not Select the Role ", selenium, ClassName,MethodName);
       	        }
       	        else
       	        {
       	        	assertTrue(selectValueFromAjaxList(selenium,ajxSwitchrole,switchRole),"could not select the role", selenium, ClassName,MethodName);
       	        }
       	        assertTrue( click(selenium,txtDeleteReason),"could not select the role", selenium, ClassName,MethodName);
       	        waitForPageLoad(selenium);
       	        waitForPageLoad(selenium);
       	        waitForPageLoad(selenium);
       			if(isElementPresent(selenium, btnErrorClose)) {   			
       					assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
       			 				waitForPageLoad(selenium);
       			}			
       	        
       	        if(getText(selenium, lnkTopMenu).toLowerCase().contains(switchRole.toLowerCase())){
       	        	waitForPageLoad(selenium);  
       	        	 if(isElementPresent(selenium, btnErrorClose)) {    	 				
       	 					assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);    	 		
       	 				waitForPageLoad(selenium);    	 		
       	        	    
       	        	 } 
       	        	 
       	        	 }
       	        else
       	        {
       	        	return false;
       	        }
       		}
       		
           }
           catch(Exception e)
           {
           	Assert.fail();
           	
           }
   		return true;
   		
   	}

	
	
	/**
	 * MaximizeWindow
	 * This function will Focus and Maximize the current Firefox Window
	 * @param 		selenium (an instance of current selenium browser )
	 * @since  	     Mar 29, 2010
	 */
	public void maximizeWindow(Selenium selenium){
		selenium.windowFocus();
		selenium.windowMaximize();
	}

	/**
	 * type
	 * This function will type a value into a TextBox / Text Area after waiting for the mentioned WAIT TIME
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		textboxName (Name of the Text Box / Text Area)
	 * @param       valueForEntry (The value that must be entered in to the TextBox / TextArea)  
	 
	 * @since  	     Mar 30, 2010
	 */
	public boolean type(Selenium selenium, String textboxName, String valueForEntry){
		textboxName = textboxName != null ? textboxName.trim() : "";
		valueForEntry = valueForEntry != null ? valueForEntry.trim() : "";
		if(!textboxName.equals("")){
			if(waitForElement(selenium, textboxName, WAIT_TIME) && selenium.isVisible(textboxName)){
				selenium.type(textboxName, valueForEntry);
				return true;
			}else{
				return false;
			}
		}else{
			return true;
		}
	}

	
	public boolean type(WebDriver driver, String textboxName, String valueForEntry){
		textboxName = textboxName != null ? textboxName.trim() : "";
		valueForEntry = valueForEntry != null ? valueForEntry.trim() : "";
		if(!textboxName.equals("")){
			if(waitForElement(driver, textboxName, WAIT_TIME)){
				driver.findElement(By.id(textboxName)).sendKeys(Keys.TAB); 
				driver.findElement(By.id(textboxName)).clear();
				driver.findElement(By.id(textboxName)).sendKeys(valueForEntry);
				driver.findElement(By.id(textboxName)).sendKeys(Keys.ENTER);
				return true;
			}else{
				return false;
			}
		}else{
			return true;
		}
	}
	
	public boolean typeXPath(WebDriver driver, String textboxName, String valueForEntry){
		textboxName = textboxName != null ? textboxName.trim() : "";
		valueForEntry = valueForEntry != null ? valueForEntry.trim() : "";
		if(!textboxName.equals("")){			
				driver.findElement(By.xpath(textboxName)).sendKeys(Keys.TAB); 
				driver.findElement(By.xpath(textboxName)).clear();
				driver.findElement(By.xpath(textboxName)).sendKeys(valueForEntry);
				driver.findElement(By.xpath(textboxName)).sendKeys(Keys.ENTER);
				return true;			
		}else{
			return false;
		}
	}

	
	// Type at the CSS element
	
	public boolean typeCss(WebDriver driver, String textboxName, String valueForEntry){
		textboxName = textboxName != null ? textboxName.trim() : "";
		valueForEntry = valueForEntry != null ? valueForEntry.trim() : "";
		if(!textboxName.equals("")){
			if(waitForElement(driver, textboxName, WAIT_TIME)){
				driver.findElement(By.cssSelector(textboxName)).sendKeys(Keys.TAB); 
				driver.findElement(By.cssSelector(textboxName)).clear();
				driver.findElement(By.cssSelector(textboxName)).sendKeys(valueForEntry);
				driver.findElement(By.cssSelector(textboxName)).sendKeys(Keys.ENTER);
				return true;
			}else{
				return false;
			}
		}else{
			return true;
		}
	}
	/**
	 * enterDate
	 * This function will enter a date value into a TextBox after waiting for the mentioned WAIT TIME
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		dateField (Name of the Date Text Box)
	 * @param       valueForEntry (The value that must be entered in to the TextBox)  
	 
	 * @since  	     Jun 10, 2010
	 */
	public boolean enterDate(Selenium selenium, String dateField, String valueForEntry){
		dateField = dateField != null ? dateField.trim() : "";
		valueForEntry = valueForEntry != null ? valueForEntry.trim() : "";
		if(!dateField.equals("") && waitForElement(selenium, dateField, WAIT_TIME) && selenium.isVisible(dateField)){
			selenium.type(dateField, valueForEntry);
			selenium.keyDown(dateField,  "\\9");
			return true;
		}else{
			return false;
		}
	}
	
	
	
	/**
	 * enterDate (WebDriver)
	 * This function will enter a date value into a TextBox after waiting for the mentioned WAIT TIME
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		dateField (Name of the Date Text Box)
	 * @param       valueForEntry (The value that must be entered in to the TextBox)  
	 
	 * @since  	     May 14, 2014
	 */
	public boolean enterDate(WebDriver driver, String dateField, String valueForEntry){
		dateField = dateField != null ? dateField.trim() : "";
		valueForEntry = valueForEntry != null ? valueForEntry.trim() : "";
		if(!dateField.equals("")){
			type(driver,dateField, valueForEntry);
			
			return true;
		}else{
			return false;
		}
	}

	

	/**
	 * select
	 * This function will select a value from a list after waiting for the mentioned WAIT TIME
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		listName (Name of the list)
	 * @param       valueForSelection (The value that must be selected from list)  
	 
	 * @since  	     Apr 01, 2010
	 */
	public boolean select(Selenium selenium, String listName, String valueForSelection){
		listName = listName != null ? listName.trim() : "";
		valueForSelection = valueForSelection != null ? valueForSelection.trim() : "";
		try{
			if(isElementPresent(selenium, listName) && selenium.isVisible(listName)){
				selenium.select(listName, "label="+ valueForSelection);
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * selectValueFromAjaxListForUnit
	 * This function will select a value from an Ajaz based list after waiting for the mentioned WAIT TIME
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		textboxName (Name of the list)
	 * @param       valueForSelection (The value that must be selected from list)
	 * @since  	     Jun 06, 2013
	 */
	
	public boolean selectValueFromajxListForUnit(Selenium selenium, String textboxName, String valueForSelection){
		waitForPageLoad(selenium);
		textboxName = textboxName != null ? textboxName.trim() : "";
		valueForSelection = valueForSelection != null ? valueForSelection.trim() : "";
		waitForPageLoad(selenium);
		try{
			if(!textboxName.equals("") && waitForElement(selenium, textboxName, WAIT_TIME)){
				selenium.typeKeys(textboxName, "\b");
				selenium.type(textboxName, "");
				waitForPageLoad(selenium);
				selenium.focus(textboxName);
				selenium.type(textboxName,valueForSelection);
				selenium.typeKeys(textboxName,valueForSelection);
				return true;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("selectValueFromAjaxList:" + textboxName + "," +valueForSelection,e);
			return false;
		}
		return true;
		
	}
	
	/**
	 * selectValueFromAjaxList
	 * This function will select a value from an Ajaz based list after waiting for the mentioned WAIT TIME
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		textboxName (Name of the list)
	 * @param       valueForSelection (The value that must be selected from list)
	 * @since  	     Apr 22, 2010
	 */
	public boolean selectValueFromAjaxList(Selenium selenium, String textboxName, String valueForSelection){
		//waitForPageLoad(selenium);
		textboxName = textboxName != null ? textboxName.trim() : "";
		valueForSelection = valueForSelection != null ? valueForSelection.trim() : "";
		int count=0;
		boolean clicked = true;
		int MODIFIED_WAIT_TIME=1000;
		try{
			if(!textboxName.equals("") && !valueForSelection.equals("") && waitForElement(selenium, textboxName, WAIT_TIME)){
				selenium.typeKeys(textboxName, "\b");
				selenium.type(textboxName, "");
			//	waitForPageLoad(selenium);
				selenium.focus(textboxName);
			//	waitForPageLoad(selenium);
				//waitForPageLoad(selenium);
				selenium.type(textboxName,valueForSelection);
				//selenium.typeKeys(textboxName,valueForSelection);
				selenium.fireEvent(textboxName,"keydown");
				selenium.fireEvent(textboxName,"keypress");                           
				selenium.fireEvent(textboxName,"keyup");
				selenium.keyPress(textboxName, "\\13");
				selenium.clickAt(textboxName, "");
				selenium.clickAt(textboxName, "");
				waitForPageLoad(selenium);
				//waitForPageLoad(selenium);
				// System.out.println((getText(selenium, "//body//div[9]/div/div/div/div/div".toLowerCase())));
			//	 System.out.println(valueForSelection.toLowerCase());
				if(waitForElement(selenium,lblAjaxList,WAIT_TIME) || waitForElement(selenium,lblAjaxList2,WAIT_TIME) || waitForElement(selenium,lblAjaxList1,WAIT_TIME)){
					
					//selenium.click(lblAjaxList);
					while(count<WAIT_TIME){
						
						  if(isElementPresent(selenium,"currentItem_1",MODIFIED_WAIT_TIME)
								 && (getText(selenium, "currentItem_1").toLowerCase().contains(valueForSelection.toLowerCase()))){
								 click(selenium,"currentItem_1"); 
								 break;
								 }
						 else if(isElementPresent(selenium,"currentItem_2",MODIFIED_WAIT_TIME)
								 && (getText(selenium, "currentItem_2").toLowerCase().contains(valueForSelection.toLowerCase()))){
								 click(selenium,"currentItem_2"); 
								 break;
								 }
						 else if(isElementPresent(selenium,"currentItem_3",MODIFIED_WAIT_TIME)
								 && (getText(selenium, "currentItem_3").toLowerCase().contains(valueForSelection.toLowerCase()))){
								 click(selenium,"currentItem_3"); 
								 break;
								 }
						 else if(isElementPresent(selenium,"currentItem_4",MODIFIED_WAIT_TIME)
								 && (getText(selenium, "currentItem_4").toLowerCase().contains(valueForSelection.toLowerCase()))){
								 click(selenium,"currentItem_4"); 
								 break;
								 }
						  
						 else if(isElementPresent(selenium,"currentItem_5",MODIFIED_WAIT_TIME)
								 && (getText(selenium, "currentItem_5").toLowerCase().contains(valueForSelection.toLowerCase()))){
								 click(selenium,"currentItem_5"); 
								 break;
								 }
						  
						 else if(isElementPresent(selenium,"currentItem_6",MODIFIED_WAIT_TIME)
								 && (getText(selenium, "currentItem_6").toLowerCase().contains(valueForSelection.toLowerCase()))){
								 click(selenium,"currentItem_6"); 
								 break;
								 }
						 else if(isElementPresent(selenium,"//body/div[6]/div/div/div/div/div", MODIFIED_WAIT_TIME)
								 && (getText(selenium, "//body/div[6]/div/div/div/div/div").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"//body/div[6]/div/div/div/div/div");
                            break;
						 }
						 else if(isElementPresent(selenium,"//body/div[4]/div/div/div/div/div",MODIFIED_WAIT_TIME)
								 && (getText(selenium, "//body/div[4]/div/div/div/div/div").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"//body/div[4]/div/div/div/div/div");	
							break;
						}
						 else if(isElementPresent(selenium,"//div[5]/div/div/div/div/div",MODIFIED_WAIT_TIME)
								 && (getText(selenium, "//div[5]/div/div/div/div/div").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"//div[5]/div/div/div/div/div");	
							break;
						}
						 else if(isElementPresent(selenium,"//body//div[9]/div/div/div/div/div", MODIFIED_WAIT_TIME)
									&& (getText(selenium, "//body//div[9]/div/div/div/div/div").toLowerCase()).contains(valueForSelection.toLowerCase()))
						 {
								click(selenium,"//body//div[9]/div/div/div/div/div");
	                            break;
							}
						 else if(isElementPresent(selenium,"//body/div[7]/div/div/div/div/div", MODIFIED_WAIT_TIME)
									&& (getText(selenium, "//body/div[7]/div/div/div/div/div").toLowerCase()).contains(valueForSelection.toLowerCase()))
						 {
								click(selenium,"//body/div[7]/div/div/div/div/div");
	                            break;
							}//body/div[5]/div/div/div/div/div
						else if(isElementPresent(selenium,"//body/div[5]/div/div/div/div/div",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//body/div[5]/div/div/div/div/div").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"//body/div[5]/div/div/div/div/div");
							break;
						}
						else if(isElementPresent(selenium,"//body/div[3]/div/div/div/div/div",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//body/div[3]/div/div/div/div/div").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"//body/div[3]/div/div/div/div/div");	
							break;
						}else if(isElementPresent(selenium,"//div[7]/div/div/div/div/div",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//div[7]/div/div/div/div/div").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"//div[7]/div/div/div/div/div");
							break;
					
						}
						else if(isElementPresent(selenium, "//body/div[7]/div/div/div/div/div[2]",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//body/div[7]/div/div/div/div/div[2]").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"//body/div[7]/div/div/div/div/div[2]");
							break;
						}
						else if(isElementPresent(selenium, "//div[5]/div/div/div/div/div",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//div[5]/div/div/div/div/div").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"//div[5]/div/div/div/div/div");
							break;
						}

						else if(isElementPresent(selenium, "//body/div[5]/div/div/div/div/div/div/span",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//body/div[5]/div/div/div/div/div/div/span").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"//body/div[5]/div/div/div/div/div/div/span");
							break;
						}
						
						else if(isElementPresent(selenium, "//body/div[4]/div/div/div/div/div/div/span",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//body/div[4]/div/div/div/div/div/div/span").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"//body/div[4]/div/div/div/div/div/div/span");
							break;
						}
						
						else if(isElementPresent(selenium, "//body/div[8]/div/div/div/div/div",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//body/div[8]/div/div/div/div/div").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"//body/div[8]/div/div/div/div/div");
							break;
						}
						else if(isElementPresent(selenium, "//div[5]/div/div/div/div/input",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//div[5]/div/div/div/div/input").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"//div[5]/div/div/div/div/input");
							break;
						}
						else if(isElementPresent(selenium, "//div[7]/div/div/div/div/input",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//div[7]/div/div/div/div/input").toLowerCase().contains(valueForSelection.toLowerCase())))
						{
							click(selenium,"//div[7]/div/div/div/div/input");
							break;
						}
						 
						 
						else if(isElementPresent(selenium, "//div[4]/div/div/div/div/div/span",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//div[4]/div/div/div/div/div/span").toLowerCase().contains(valueForSelection.toLowerCase())))
						{
							click(selenium,"//div[4]/div/div/div/div/div/span");
							break;
						}
						 
						else if(isElementPresent(selenium, "//div[4]/div/div/div/div/div/span",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//div[4]/div/div/div/div/div/span").toLowerCase().contains(valueForSelection.toLowerCase())))
						{
							click(selenium,"//div[4]/div/div/div/div/div/span");
							break;
						}
						 
						 
						else if(isElementPresent(selenium, "//div[4]/div/div/div[2]/div/div/div/input",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//div[4]/div/div/div[2]/div/div/div/input").toLowerCase().contains(valueForSelection.toLowerCase())))
						{
							click(selenium,"//div[4]/div/div/div[2]/div/div/div/input");
							break;
						}
						else if(isElementPresent(selenium, "//div[3]/div/div/input",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//div[3]/div/div/input").toLowerCase().contains(valueForSelection.toLowerCase())))
						{
							click(selenium,"//div[3]/div/div/input");
							break;
						}
					 
						else if(isElementPresent(selenium, "//div[6]/div/div[2]/div/div[2]/div/input",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//div[6]/div/div[2]/div/div[2]/div/input").toLowerCase().contains(valueForSelection.toLowerCase())))
						{
							click(selenium,"//div[6]/div/div[2]/div/div[2]/div/input");
							break;
						}
				 
						else if(isElementPresent(selenium, "//div/div/div[2]/div/div/input",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//div/div/div[2]/div/div/input").toLowerCase().contains(valueForSelection.toLowerCase())))
						{
							click(selenium,"//div/div/div[2]/div/div/input");
							break;
						}
					 
						else if(isElementPresent(selenium, "//div[3]/div/div/input",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//div[3]/div/div/input").toLowerCase().contains(valueForSelection.toLowerCase())))
						{
							click(selenium,"//div[3]/div/div/input");
							break;
						}
				 
						else if(isElementPresent(selenium, "//div[4]/div/div/input",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//div[4]/div/div/input").toLowerCase().contains(valueForSelection.toLowerCase())))
						{
							click(selenium,"//div[4]/div/div/input");
							break;
						}
			 
						else if(isElementPresent(selenium, "//div/div[2]/div[2]/div/div/input",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//div/div[2]/div[2]/div/div/input").toLowerCase().contains(valueForSelection.toLowerCase())))
						{
							click(selenium,"//div/div[2]/div[2]/div/div/input");
							break;
						}
						
						else if(isElementPresent(selenium, "//div[6]/div/div/div/div/div/div/div/div/a",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//div[6]/div/div/div/div/div/div/div/div/a").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"//div[6]/div/div/div/div/div/div/div/div/a");
							break;
						}
				 
						
						else if(isElementPresent(selenium, "//div[2]/div[3]/div/div/input",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//div[2]/div[3]/div/div/input").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"//div[2]/div[3]/div/div/input");
							break;
						}
				 
						else if(isElementPresent(selenium, "//div[3]/div/div/div[2]/div/div/div/input",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//div[3]/div/div/div[2]/div/div/div/input").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"//div[3]/div/div/div[2]/div/div/div/input");
							break;
						}
						else if(isElementPresent(selenium, "//div[4]/div/div/div/div/div",MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//div[4]/div/div/div/div/div").toLowerCase().contains(valueForSelection.toLowerCase()))) {
							click(selenium,"//div[4]/div/div/div/div/div");
							break;
						}else if(isElementPresent(selenium,"//div[6]/div/div/div/div/div", MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//div[6]/div/div/div/div/div").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"//div[6]/div/div/div/div/div");
                            break;
						}else if(isElementPresent(selenium,"//body/div[9]/div/div/div/div/div", MODIFIED_WAIT_TIME)
								&& (getText(selenium, "//body/div[9]/div/div/div/div/div").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"//body/div[9]/div/div/div/div/div");
                            break;
						}else if(isElementPresent(selenium,"css=span.gwt-InlineLabel", MODIFIED_WAIT_TIME)
								&& (getText(selenium, "css=span.gwt-InlineLabel").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"css=span.gwt-InlineLabel");
                            break;
						}
						 else if(isElementPresent(selenium,"//div[5]/div/div/div/div/div/span",MODIFIED_WAIT_TIME)
								 && (getText(selenium, "//div[5]/div/div/div/div/div/span").toLowerCase().contains(valueForSelection.toLowerCase()))){
							click(selenium,"//div[5]/div/div/div/div/div/span");	
							break;
					


	}
						 
						count=count+1000;
					}
					
				}
				
				
			}
			return clicked;
		}catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("selectValueFromAjaxList:" + textboxName + "," +valueForSelection,e);
			return false;
		}
	}

	/**
	 * selectValueFromAjaxList
	 * This function will select a value from an Ajaz based list after waiting for the mentioned WAIT TIME
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		textboxName (Name of the list)
	 * @param       valueForSelection (The value that must be selected from list)
	 * @throws InterruptedException 
	 * @since  	    Apr 22, 2010
	 */
	@SuppressWarnings("null")
	public boolean selectValueFromAjaxList(WebDriver driver, String textboxName, String valueForSelection) throws InterruptedException{
		waitForPageLoad(driver);
		textboxName = textboxName != null ? textboxName.trim() : "";
		valueForSelection = valueForSelection != null ? valueForSelection.trim() : "";
		
		/*WebElement selectElement = driver.findElement(By.id(textboxName));
		selectElement.sendKeys("All");
		new Select(selectElement).selectByVisibleText(valueForSelection);*/
		
		
		/*WebElement mnuElement = driver.findElement(By.id(textboxName));					
		Actions builder = new Actions(driver);					
		builder.moveToElement(mnuElement).clickAndHold().build().perform();*/
		
		/*JavascriptExecutor js = null;
		js.executeScript("document.getElementById(textboxName).focus()");*/
		
		driver.findElement(By.id(textboxName)).sendKeys(Keys.TAB); 
		
		driver.findElement(By.id(textboxName)).clear();		
		driver.findElement(By.id(textboxName)).sendKeys(valueForSelection);		
		waitForPageLoad(driver);	
		
		
		int count=0;
		boolean clicked = true;
		int MODIFIED_WAIT_TIME=50;
		try{
			if(!textboxName.equals("") && !valueForSelection.equals("") && waitForElement(driver, textboxName, WAIT_TIME)){
				
				
				//if(waitForElement(driver,lblAjaxList,WAIT_TIME) || waitForElement(driver,lblAjaxList2,WAIT_TIME) || waitForElement(driver,lblAjaxList1,WAIT_TIME)){
					
					//selenium.click(lblAjaxList);
					//while(count<WAIT_TIME){
						
						
						 if(isXPathElementPresent(driver, "//body/div[6]/div/div/div/div/div", MODIFIED_WAIT_TIME)
								 && (driver.findElement(By.xpath("//body/div[6]/div/div/div/div/div")).getText().toLowerCase().contains(valueForSelection.toLowerCase()))) 
						  {							 
							driver.findElement(By.xpath("//body/div[6]/div/div/div/div/div")).click();
                            //break;
						  } else if(isXPathElementPresent(driver,"//body/div[4]/div/div/div/div/div",MODIFIED_WAIT_TIME)
								  && (driver.findElement(By.xpath("//body/div[4]/div/div/div/div/div")).getText().toLowerCase().contains(valueForSelection.toLowerCase()))){
							  
							driver.findElement(By.xpath("//body/div[4]/div/div/div/div/div")).click();								
							//break;
						 }
						
						 else if(isXPathElementPresent(driver,"//body//div[9]/div/div/div/div/div", MODIFIED_WAIT_TIME)
								 && (driver.findElement(By.xpath("//body//div[9]/div/div/div/div/div")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))							 
						 {
							    
								driver.findElement(By.xpath("//body//div[9]/div/div/div/div/div")).click();
	                           // break;
						 }
						
						else if(isXPathElementPresent(driver,"//body/div[5]/div/div/div/div/div",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//body/div[5]/div/div/div/div/div")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))
						{								
							driver.findElement(By.xpath("//body/div[5]/div/div/div/div/div")).click();							
							//break;
						}
						 
						else if(isXPathElementPresent(driver,"//body/div[3]/div/div/div/div/div",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//body/div[3]/div/div/div/div/div")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))					
						{
							
							driver.findElement(By.xpath("//body/div[3]/div/div/div/div/div")).click();								
							//break;
						}						 
						else if(isXPathElementPresent(driver,"//div[7]/div/div/div/div/div",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//div[7]/div/div/div/div/div")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))
						{	
							
							driver.findElement(By.xpath("//div[7]/div/div/div/div/div")).click();							
							//break;					
						}
						else if(isXPathElementPresent(driver, "//body/div[7]/div/div/div/div/div[2]",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//body/div[7]/div/div/div/div/div[2]")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))							
						{
							
							driver.findElement(By.xpath("//body/div[7]/div/div/div/div/div[2]")).click();							
							//break;
						}
						else if(isXPathElementPresent(driver, "//div[5]/div/div/div/div/div",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//div[5]/div/div/div/div/div")).getText().toLowerCase().contains(valueForSelection.toLowerCase()))) {
							
							driver.findElement(By.xpath("//div[5]/div/div/div/div/div")).click();							
							//break;
						}
						else if(isXPathElementPresent(driver, "//body/div[5]/div/div/div/div/div/div/span",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//body/div[5]/div/div/div/div/div/div/span")).getText().toLowerCase().contains(valueForSelection.toLowerCase()))) 
						{
							
							driver.findElement(By.xpath("//body/div[5]/div/div/div/div/div/div/span")).click();							
							//break;
						}						
						else if(isXPathElementPresent(driver, "//body/div[4]/div/div/div/div/div/div/span",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//body/div[4]/div/div/div/div/div/div/span")).getText().toLowerCase().contains(valueForSelection.toLowerCase()))) {
							
							driver.findElement(By.xpath("//body/div[4]/div/div/div/div/div/div/span")).click();							
							//break;
						}						
						else if(isXPathElementPresent(driver, "//body/div[8]/div/div/div/div/div",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//body/div[8]/div/div/div/div/div")).getText().toLowerCase().contains(valueForSelection.toLowerCase()))) {
							
							driver.findElement(By.xpath("//body/div[8]/div/div/div/div/div")).click();							
							//break;
						}
						else if(isXPathElementPresent(driver, "//div[5]/div/div/div/div/input",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//div[5]/div/div/div/div/input")).getText().toLowerCase().contains(valueForSelection.toLowerCase()))) {
							
							driver.findElement(By.xpath("//div[5]/div/div/div/div/input")).click();							
							//break;
						}
						else if(isXPathElementPresent(driver, "//div[7]/div/div/div/div/input",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//div[7]/div/div/div/div/input")).getText().toLowerCase().contains(valueForSelection.toLowerCase()))) {						
							driver.findElement(By.xpath("//div[7]/div/div/div/div/input")).click();
							//break;
						}						 
						 
						else if(isXPathElementPresent(driver, "//div[4]/div/div/div/div/div/span",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//div[4]/div/div/div/div/div/span")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))								
						{
							driver.findElement(By.xpath("//div[4]/div/div/div/div/div/span")).click();
							//break;
						}
						
						else if(isXPathElementPresent(driver, "//div[4]/div/div/div[2]/div/div/div/input",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//div[4]/div/div/div[2]/div/div/div/input")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))								
						{
							driver.findElement(By.xpath("//div[4]/div/div/div[2]/div/div/div/input")).click();
							//break;
						}
						 
						else if(isXPathElementPresent(driver, "//div[3]/div/div/input",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//div[3]/div/div/input")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))								
						{
							driver.findElement(By.xpath("//div[3]/div/div/input")).click();
							//break;
						}									 
						 
						else if(isXPathElementPresent(driver, "//div[6]/div/div[2]/div/div[2]/div/input",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//div[6]/div/div[2]/div/div[2]/div/input")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))								
						{
							driver.findElement(By.xpath("//div[6]/div/div[2]/div/div[2]/div/input")).click();
							//break;
						}						 
					 	
						else if(isXPathElementPresent(driver, "//div/div/div[2]/div/div/input",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//div/div/div[2]/div/div/input")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))								
						{
							driver.findElement(By.xpath("//div/div/div[2]/div/div/input")).click();
							//break;
						}
						 
						else if(isXPathElementPresent(driver, "//div[3]/div/div/input",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//div[3]/div/div/input")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))								
						{
							driver.findElement(By.xpath("//div[3]/div/div/input")).click();
							//break;
						}
											 
						else if(isXPathElementPresent(driver, "//div[4]/div/div/input",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//div[4]/div/div/input")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))								
						{
							driver.findElement(By.xpath("//div[4]/div/div/input")).click();
							//break;
						}				 
			 
						else if(isXPathElementPresent(driver, "//div/div[2]/div[2]/div/div/input",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//div/div[2]/div[2]/div/div/input")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))								
						{
							driver.findElement(By.xpath("//div/div[2]/div[2]/div/div/input")).click();
							//break;
						}
						
						else if(isXPathElementPresent(driver, "//div[6]/div/div/div/div/div/div/div/div/a",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//div[6]/div/div/div/div/div/div/div/div/a")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))								
						{
							driver.findElement(By.xpath("//div[6]/div/div/div/div/div/div/div/div/a")).click();
							//break;
						}					
				 
						else if(isXPathElementPresent(driver, "//div[2]/div[3]/div/div/input",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//div[2]/div[3]/div/div/input")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))								
						{
							driver.findElement(By.xpath("//div[2]/div[3]/div/div/input")).click();
							//break;
						}				
						
						else if(isXPathElementPresent(driver, "//div[3]/div/div/div[2]/div/div/div/input",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//div[3]/div/div/div[2]/div/div/div/input")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))								
						{
							driver.findElement(By.xpath("//div[3]/div/div/div[2]/div/div/div/input")).click();
							//break;
						}
				 
						else if(isXPathElementPresent(driver, "//div[4]/div/div/div/div/div",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//div[4]/div/div/div/div/div")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))								
						{
							driver.findElement(By.xpath("//div[4]/div/div/div/div/div")).click();
							//break;
						}
						
						else if(isXPathElementPresent(driver, "//div[4]/div/div/div/div/div/div/div/div/a",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//div[4]/div/div/div/div/div/div/div/div/a")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))								
						{
							driver.findElement(By.xpath("//div[4]/div/div/div/div/div/div/div/div/a")).click();
							//break;
						}
						else if(isXPathElementPresent(driver, "//div[6]/div/div/div/div/div",MODIFIED_WAIT_TIME)
								&& (driver.findElement(By.xpath("//div[6]/div/div/div/div/div")).getText().toLowerCase().contains(valueForSelection.toLowerCase())))								
						{
							driver.findElement(By.xpath("//div[6]/div/div/div/div/div")).click();
							//break;
						}					
						 
						//count=count+1000;
					//}
					
				} 
		}catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("selectValueFromAjaxList:" + textboxName + "," +valueForSelection,e);
			return false;
		}
		
				
		return true;
	}

	/**
	 * selectValueFromAjaxListUsingTypeKeys
	 * This function will select a value from an Ajaz based list after waiting for the mentioned WAIT TIME
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		textboxName (Name of the list)
	 * @param       valueForSelection (The value that must be selected from list)
	 
	 * @since  	     Apr 22, 2010
	 */
	public boolean selectValueFromAjaxListUsingTypeKeys(Selenium selenium, String textboxName, String valueForSelection){
		textboxName = textboxName != null ? textboxName.trim() : "";
		valueForSelection = valueForSelection != null ? valueForSelection.trim() : "";
		int MODIFIED_WAIT_TIME=1000;
		int count=0;
		try{
			if(!textboxName.equals("") && !valueForSelection.equals("") && waitForElement(selenium, textboxName, WAIT_TIME)){
				selenium.focus(textboxName);
				selenium.typeKeys(textboxName,valueForSelection);
				selenium.fireEvent(textboxName,"keydown");
				selenium.fireEvent(textboxName,"keypress");                           
				selenium.fireEvent(textboxName,"keyup");
				if(waitForElement(selenium,lblAjaxList,WAIT_TIME)){
					selenium.click(lblAjaxList);
					while(count<WAIT_TIME){	
					if(isElementPresent(selenium,"//body/div[6]/div/div/div/div/div", MODIFIED_WAIT_TIME)){
						click(selenium,"//body/div[6]/div/div/div/div/div");
						break;
					}else if(isElementPresent(selenium,"//body/div[4]/div/div/div/div/div",MODIFIED_WAIT_TIME)){
						click(selenium,"//body/div[4]/div/div/div/div/div");	
						break;
					}
					else if(isElementPresent(selenium,"//body/div[5]/div/div/div/div/div",MODIFIED_WAIT_TIME)){
						click(selenium,"//body/div[5]/div/div/div/div/div");
						break;
					}
					else if(isElementPresent(selenium,"//body/div[3]/div/div/div/div/div",MODIFIED_WAIT_TIME)){
						click(selenium,"//body/div[3]/div/div/div/div/div");	
						break;
					}else if(isElementPresent(selenium,"//div[7]/div/div/div/div/div",MODIFIED_WAIT_TIME)){
						click(selenium,"//div[7]/div/div/div/div/div");
						break;
				
					}
					else if(isElementPresent(selenium, "//body/div[7]/div/div/div/div/div[2]",MODIFIED_WAIT_TIME)){
						click(selenium,"//body/div[7]/div/div/div/div/div[2]");
						break;
					}
					else if(isElementPresent(selenium, "//div[5]/div/div/div/div/div",MODIFIED_WAIT_TIME)){
						click(selenium,"//div[5]/div/div/div/div/div");
						break;
					}

					else if(isElementPresent(selenium, "//body/div[5]/div/div/div/div/div/div/span",MODIFIED_WAIT_TIME))
					{
						click(selenium,"//body/div[5]/div/div/div/div/div/div/span");
						break;
					}
					
					else if(isElementPresent(selenium, "//body/div[4]/div/div/div/div/div/div/span",MODIFIED_WAIT_TIME))
					{
						click(selenium,"//body/div[4]/div/div/div/div/div/div/span");
						break;
					}
					
					else if(isElementPresent(selenium, "//div[5]/div/div/div/div/input",MODIFIED_WAIT_TIME))

					if(isElementPresent(selenium, "//div[5]/div/div/div/div/input",MODIFIED_WAIT_TIME))

					{
						click(selenium,"//div[5]/div/div/div/div/input");
						break;
					}
					else if(isElementPresent(selenium, "//div[7]/div/div/div/div/input",MODIFIED_WAIT_TIME))
					{
						click(selenium,"//div[7]/div/div/div/div/input");
						break;
					}
					else if(isElementPresent(selenium, "//div[4]/div/div/div[2]/div/div/div/input",MODIFIED_WAIT_TIME))
					{
						click(selenium,"//div[4]/div/div/div[2]/div/div/div/input");
						break;
					}
					else if(isElementPresent(selenium, "//div[3]/div/div/input",MODIFIED_WAIT_TIME))
					{
						click(selenium,"//div[3]/div/div/input");
						break;
					}
				 
					else if(isElementPresent(selenium, "//div[6]/div/div[2]/div/div[2]/div/input",MODIFIED_WAIT_TIME))
					{
						click(selenium,"//div[6]/div/div[2]/div/div[2]/div/input");
						break;
					}
			 
					else if(isElementPresent(selenium, "//div/div/div[2]/div/div/input",MODIFIED_WAIT_TIME))
					{
						click(selenium,"//div/div/div[2]/div/div/input");
						break;
					}
				 
					else if(isElementPresent(selenium, "//div[3]/div/div/input",MODIFIED_WAIT_TIME))
					{
						click(selenium,"//div[3]/div/div/input");
						break;
					}
			 
					else if(isElementPresent(selenium, "//div[4]/div/div/input",MODIFIED_WAIT_TIME))
					{
						click(selenium,"//div[4]/div/div/input");
						break;
					}
		 
					else if(isElementPresent(selenium, "//div/div[2]/div[2]/div/div/input",MODIFIED_WAIT_TIME))
					{
						click(selenium,"//div/div[2]/div[2]/div/div/input");
						break;
					}
			 
					else if(isElementPresent(selenium, "//div[2]/div[3]/div/div/input",MODIFIED_WAIT_TIME))
					{
						click(selenium,"//div[2]/div[3]/div/div/input");
						break;
					}
			 
					else if(isElementPresent(selenium, "//div[3]/div/div/div[2]/div/div/div/input",MODIFIED_WAIT_TIME))
					{
						click(selenium,"//div[3]/div/div/div[2]/div/div/div/input");
						break;
					}
					else if(isElementPresent(selenium, "//div[4]/div/div/div/div/div",MODIFIED_WAIT_TIME)){
						click(selenium,"//div[4]/div/div/div/div/div");
						break;
					}
					count=count+1000;
				}
				
			}
			}	
			return true;
		}
		catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("selectValueFromAjaxList:" + textboxName + "," +valueForSelection,e);
			return false;
		}

	}

	/**
	 * selectValueFromAjaxList
	 * This function will select a value from an Ajaz based list after waiting for the mentioned WAIT TIME
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		textboxName (Name of the list)
	 * @param       valueForSelection (The value that must be selected from list)
	 
	 * @since  	     Apr 22, 2010
	 */
	public boolean selectFirstMatchingValueFromAjaxList(Selenium selenium, String textboxName, String valueForSelection){
		textboxName = textboxName != null ? textboxName.trim() : "";
		valueForSelection = valueForSelection != null ? valueForSelection.trim() : "";

		try{
			if(!textboxName.equals("") && !valueForSelection.equals("") && waitForElement(selenium, textboxName, WAIT_TIME)){
				selenium.type(textboxName, valueForSelection);
				waitForElement(selenium, textboxName, 200);
				selenium.keyDown(textboxName, "\\13");
				if(isElementPresent(selenium,"//body/div[3]/div/div/div/div/div")){
					click(selenium,"//body/div[3]/div/div/div/div/div");
					waitForPageLoad(selenium);
				}
				if(isElementPresent(selenium,"//div[4]/div/div/div/div/div",10000)){
					click(selenium,"//div[4]/div/div/div/div/div");
					waitForPageLoad(selenium);
				}
				

				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e) {
			return false;
		}
	}
	
	/**
	 * selectValueFromAjaxList
	 * This function will select a second matching value from an Ajax list
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		textboxName (Name of the list)
	 * @param       valueForSelection (The value that must be selected from list)
	 * @since  	    July 05, 2013
	 */
	public boolean selectSecondMatchingValueFromAjaxList(Selenium selenium, String textboxName, String valueForSelection){
		textboxName = textboxName != null ? textboxName.trim() : "";
		valueForSelection = valueForSelection != null ? valueForSelection.trim() : "";

		try{
			if(!textboxName.equals("") && !valueForSelection.equals("") && waitForElement(selenium, textboxName, WAIT_TIME)){
				selenium.focus(textboxName);
				selenium.type(textboxName,valueForSelection);
				selenium.fireEvent(textboxName,"keydown");
				selenium.fireEvent(textboxName,"keypress");                           
				selenium.fireEvent(textboxName,"keyup");
				
				if(isElementPresent(selenium,"//div[6]/div/div/div/div/div[2]")){
					click(selenium,"//div[6]/div/div/div/div/div[2]");
					waitForPageLoad(selenium);
				}

				else if(isElementPresent(selenium,"//div[7]/div/div/div/div/div[2]")){
					click(selenium,"//div[7]/div/div/div/div/div[2]");
					waitForPageLoad(selenium);
				}
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e) {
			return false;
		}
	}
	
	
	/**
	 * selectEmptyValueFromAjaxList
	 * This function will select a empty value from an Ajax based list after waiting for the mentioned WAIT TIME
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		textboxName (Name of the list)
	 * @param       valueForSelection (The value that must be selected from list)
	 
	 * @since  	     Apr 22, 2010
	 */
	public boolean selectEmptyValueFromAjaxList(Selenium selenium, String textboxName, String valueForSelection){
		textboxName = textboxName != null ? textboxName.trim() : "";
		//valueForSelection = valueForSelection != null ? valueForSelection.trim() : "";

		try{
			if(!textboxName.equals("") && valueForSelection.equals("") && waitForElement(selenium, textboxName, WAIT_TIME)){
				selenium.click(textboxName);
				waitForElement(selenium, textboxName, 200);
				selenium.focus(textboxName);
				selenium.keyDown(textboxName, "\\46");
				selenium.keyPress(textboxName, "\\46");
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e) {
			return false;
		}
	}

	/**
	 * selectMatchingValueFromAjaxList
	 * This function will select a value from an Ajax based list
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		textboxName (Name of the list)
	 * @param       valueForSelection (The value that must be selected from list)
	 
	 * @since  	     Feb 17, 2012
	 */
	public boolean selectMatchingValueFromAjaxList(Selenium selenium, String textboxName, String valueForSelection){
		textboxName = textboxName != null ? textboxName.trim() : "";
		valueForSelection = valueForSelection != null ? valueForSelection.trim() : "";

		try{
			if(!textboxName.equals("") && !valueForSelection.equals("") && waitForElement(selenium, textboxName, WAIT_TIME)){				
				selenium.type(textboxName,valueForSelection);
				waitForElement(selenium, textboxName, 200);				
				selenium.keyPress(textboxName, "13");		
				if(isElementPresent(selenium,"//body/div[3]/div/div/div/div/div")){
					click(selenium,"//body/div[3]/div/div/div/div/div");
					waitForPageLoad(selenium);
				}

				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e) {
			return false;
		}
	}

	/**
	 * click
	 * This function will wait for the element for the mentioned WAIT TIME and then click
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		elementName (Name of the element which needs to be clicked)
	 
	 * @since  	     Mar 30, 2010
	 */
	public boolean click(Selenium selenium, String elementName){
		try{elementName = elementName != null ? elementName.trim() : "";
			if(!elementName.equals("") && waitForElement(selenium, elementName, WAIT_TIME)&& (selenium.isVisible(elementName))){
				selenium.click(elementName);
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	

	/**
	 * clickAt
	 * This function will wait for the element for the mentioned WAIT TIME and then will do Click at 
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		elementName (Name of the element which needs to be clicked)
	 
	 * @since  	    Aug 25, 2014
	 */
	public boolean clickAt(Selenium selenium, String elementName,String position){
		try{elementName = elementName != null ? elementName.trim() : "";
			if(!elementName.equals("") && waitForElement(selenium, elementName, WAIT_TIME)&& (selenium.isVisible(elementName))){
				selenium.clickAt(elementName,position);
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Focus
	 * This function will wait for the element for the mentioned WAIT TIME and then will do Click at 
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		elementName (Name of the element which needs to be clicked)
	 
	 * @since  	    Aug 25, 2014
	 */
	public boolean focus(Selenium selenium, String elementName){
		try{elementName = elementName != null ? elementName.trim() : "";
			if(!elementName.equals("") && waitForElement(selenium, elementName, WAIT_TIME)&& (selenium.isVisible(elementName))){
				selenium.focus(elementName);
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	/**
	 * fireEvent
	 * This function will wait for the element for the mentioned WAIT TIME and then will do fireEvent 
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		elementName (Name of the element which needs to be clicked)
	 
	 * @since  	    Aug 25, 2014
	 */
	public boolean fireEvent(Selenium selenium, String elementName,String position){
		try{elementName = elementName != null ? elementName.trim() : "";
			if(!elementName.equals("") && waitForElement(selenium, elementName, WAIT_TIME)&& (selenium.isVisible(elementName))){
				selenium.fireEvent(elementName,position);
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	

	/**
	 * keyPress
	 * This function will wait for the element for the mentioned WAIT TIME and then will do keyPress 
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		elementName (Name of the element which needs to be clicked)
	 
	 * @since  	    Aug 25, 2014
	 */
	public boolean keyPress(Selenium selenium, String elementName,String position){
		try{elementName = elementName != null ? elementName.trim() : "";
			if(!elementName.equals("") && waitForElement(selenium, elementName, WAIT_TIME)&& (selenium.isVisible(elementName))){
				selenium.keyPress(elementName,position);
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	public boolean click(WebDriver driver, String elementName){
		try{elementName = elementName != null ? elementName.trim() : "";
			if(!elementName.equals("")){
				driver.findElement(By.id(elementName)).click();
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clickXPath(WebDriver driver, String elementName){
		try{elementName = elementName != null ? elementName.trim() : "";
			if(!elementName.equals("")){
				driver.findElement(By.xpath(elementName)).click();
				
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clickCss(WebDriver driver, String elementName){
		try{elementName = elementName != null ? elementName.trim() : "";
			if(!elementName.equals("")){
				driver.findElement(By.cssSelector(elementName)).click();
				
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clickClassName(WebDriver driver, String elementName){
		try{elementName = elementName != null ? elementName.trim() : "";
			if(!elementName.equals("")){
				driver.findElement(By.className(elementName)).click();
				
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean clickLinkText(WebDriver driver, String elementName){
		try{elementName = elementName != null ? elementName.trim() : "";
			if(!elementName.equals("")){
				driver.findElement(By.linkText(elementName)).click();
				
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	
		
	/**
	* click1
	* This function will wait for the element for the mentioned WAIT TIME and then click
	* This function will not check the visibility of the element
	* @param 		selenium (an instance of current selenium browser )
	* @param 		elementName (Name of the element which needs to be clicked)
	* @since  	    Jan 27, 2014
	*/
	public boolean click1(Selenium selenium, String elementName){
		try{elementName = elementName != null ? elementName.trim() : "";
			if(!elementName.equals("") && waitForElement(selenium, elementName, WAIT_TIME)){
				selenium.click(elementName);
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * check
	 * This function will wait for the element for the mentioned WAIT TIME and then select a check box
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		elementName (Name of the element which needs to be checked)
	 
	 * @since  	     Jun 18, 2010
	 */
	public boolean check(Selenium selenium, String elementName){
		elementName = elementName != null ? elementName.trim() : "";
		if(!elementName.equals("")&& waitForElement(selenium, elementName, WAIT_TIME)){
			selenium.check(elementName);
			return true;
		}else{
			return false;
		}
	}

	/**
	 * uncheck
	 * This function will wait for the element for the mentioned WAIT TIME and then uncheck a check box
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		elementName (Name of the element which needs to be unchecked)
	 
	 * @since  	     Jun 18, 2010
	 */
	public boolean uncheck(Selenium selenium, String elementName){
		elementName = elementName != null ? elementName.trim() : "";
		if(!elementName.equalsIgnoreCase("") && waitForElement(selenium, elementName, WAIT_TIME)){
			selenium.uncheck(elementName);
			return true;
		}else{
			return false;
		}
	}

	/**
	 * getText
	 * This function will wait for the element for the mentioned WAIT TIME and then Get the Text
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		elementName (Name of the element which needs to be clicked)
	 
	 * @since  	     Apr 27, 2010
	 */
	public String getText(Selenium selenium, String elementName){
		elementName = elementName != null ? elementName.trim() : "";

		if(!elementName.equals("") && waitForElement(selenium, elementName, WAIT_TIME)){
			return selenium.getText(elementName);
		}else{
			return "";
		}
	}
	
	/**
	 * getText
	 * This function will wait for the element for the mentioned WAIT TIME and then Get the Text
	 * @param 		WebDriver (an instance of current WebDriver browser )
	 * @param 		elementName (Name of the element which needs to be clicked)
	 
	 * @since  	     Sept 17, 2014
	 */
	public String getText(WebDriver driver, String elementName){
		elementName = elementName != null ? elementName.trim() : "";

		if(!elementName.equals("")){
			return driver.findElement(By.id(elementName)).getText();
		}else{
			return "";
		}
	}

	public String getMessage(Selenium selenium, String elementName){
		elementName = elementName != null ? elementName.trim() : "";

		if(selenium.isElementPresent(elementName) && selenium.isVisible(elementName)){
			return selenium.getText(elementName);
		}else{
			return "";
		}
	}
	/**
	 * getText
	 * This function will wait for the element for the mentioned WAIT TIME and then Get the Text
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		elementName (Name of the element which needs to be clicked)
	 
	 * @since  	     Apr 27, 2010
	 */
	public String getText(Selenium selenium, String elementName,int wait){
		elementName = elementName != null ? elementName.trim() : "";

		if(!elementName.equals("") && waitForElement(selenium, elementName,wait)){
			return selenium.getText(elementName);
		}else{
			return "";
		}
	}


	/**
	 * getValue
	 * This function will wait for the element for the mentioned WAIT TIME and then Get the Value
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		elementName (Name of the element which needs to be clicked)
	 
	 * @since  	     Apr 27, 2010
	 */
	public String getValue(Selenium selenium, String elementName){
		elementName = elementName != null ? elementName.trim() : "";
		if(!elementName .equals("") && waitForElement(selenium, elementName, WAIT_TIME) && selenium.isVisible(elementName)){
			return selenium.getValue(elementName);
		}else{
			return "";
		}
	}
	
	
	
	
	/**
	 * getSelectedValue
	 * This function will wait for the element for the mentioned WAIT TIME and then Get the selected value
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		listName (Name of the element which needs to be clicked)
	 
	 * @since  	     May 03, 2010
	 */
	public String getSelectedValue(Selenium selenium, String listName){
		listName = listName != null ? listName.trim() : "";
		try{
			if(!listName.equals("") && waitForElement(selenium, listName, WAIT_TIME) && selenium.isVisible(listName)){
				return selenium.getSelectedLabel(listName);
			}else{
				return "";
			}
		}catch (RuntimeException e) {
			return "";
		}
	}

	/**
	 * generateCharacters
	 * function is used to generate a series of unique characters / uniqe strings again and again
	 * @param 		stringLength - Length of the character string to be generated 
	 * @param 		textToRepeat - Text / Characters that must be repeated in the string
	 
	 * @since  	     Apr 05, 2010
	 */
	public String generateCharacters(int stringLength, String textToRepeat){

		textToRepeat = textToRepeat != null ? textToRepeat.trim() : "";
		StringBuffer tempBuffer = new StringBuffer();
		if(stringLength > 0 && !textToRepeat.trim().equalsIgnoreCase("")){
			while (stringLength >0){
				tempBuffer.append(textToRepeat);
				stringLength--;
			}
			return tempBuffer.toString().trim();
		}else{
			return "";
		}
	}

	/**
	 * fetchProperty
	 * function is used to fetch the property from a property file
	 * @param 		fileName - Name of the Property File Name 
	 * @param 		propertyKey - Key using which the value needs to be searched for
	 
	 * @since  	     Apr 01, 2010
	 */
	public String fetchProperty(String fileName, String propertyKey){		
		int check = 0;
		String propertyValue = "";
		FileInputStream in =null;
		fileName = fileName != null ? fileName.trim():"";
		propertyKey = propertyKey != null ? propertyKey.trim():"";

		if(fileName.equals("") && propertyKey.equals("")){
			return propertyValue;
		}else if(fileName.equals("")){
			return propertyValue;
		}else if(propertyKey.equals("")){
			return propertyValue;
		}else{
			if(!fileName.contains(".properties")){
				fileName = fileName+ ".properties";
			}
		
			try{
				while(check == 0){
					check = 1;
					File file = new File(fileName);
					if(file.exists()){
						Properties properties = new Properties();
						in = new FileInputStream(file);
						properties.load(in);
						propertyValue = properties.getProperty(propertyKey);
					}
					else{
						check = 0;
						break;
					}
				}
				in.close();
			}
			catch(IOException e){
				try {
					in.close();
				} catch (IOException e1) {
					
				}
			}
			finally{
				try {
					in.close();
				} catch (IOException e) {
					
				}
			}
		}
		return propertyValue;
	}

	/**
	 * waitForPageLoad
	 * function is used to wait a page to load completely 
	 * @param 		selenium 
	 * @return		boolean
	 
	 * @since  	     Apr 27, 2010
	 */
	
	public boolean waitForPageLoad(Selenium selenium) {
		try {
			
			int i = 0;
			int j = 0;
			try {
				while(!selenium.isElementPresent(lblImageLoad) && i<(WAIT_TIME/200)){
					Thread.sleep(100);
					i++;
				}
				Thread.sleep(3000);
				if(selenium.isElementPresent(lblImageLoad)){
					while(selenium.isElementPresent(lblImageLoad) && j<(WAIT_TIME/100)){
						Thread.sleep(100);
						j++;
					}
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * waitForPageLoad
	 * function is used to wait a page to load completely 
	 * @param 		selenium 
	 * @return		boolean
	 
	 * @since  	     Apr 27, 2010
	 */
	public boolean waitForPageLoad(WebDriver driver) {
		try {
			int i = 0;
			int j = 0;
			try {
				
			
				
				while((driver.findElement(By.id(btnNexiaLogo)) == null) && i<(WAIT_TIME/100)){
					Thread.sleep(600);
					i++;
				}
				
				if(driver.findElement(By.id(btnNexiaLogo)) != null){
					while((driver.findElement(By.id(btnNexiaLogo)) == null) && j<(WAIT_TIME/100)){
						Thread.sleep(600);
						j++;
					}
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * verifyTimeStamp
	 * function is verify the time stamp 
	 * @param 		selenium 
	 * @return		boolean
	 * @since  	    sept 21, 2012
	 */
	public boolean verifyTimeStamp(Selenium selenium , String elementId, String date, String time){
		boolean returnValue=false;
		try{
			String lastUpdate="Last updated by";
			if(getText(selenium,elementId).contains(lastUpdate))
				waitForPageLoad(selenium);
				if(getText(selenium, elementId).contains(date))
					waitForPageLoad(selenium);					
					if(getText(selenium, elementId).contains(time))
						
						returnValue = true;
					
			else{
				Assert.fail("Time stamp is not present in summary page");
				returnValue = false;
			}
			return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * verifyTimeStamp
	 * function is verify the time stamp 
	 * @param 		selenium 
	 * @return		boolean
	 * @since  	    sept 21, 2012
	 */
	public boolean verifyTimeStampForProviderPage(Selenium selenium , String elementId, String date, String time){
		boolean returnValue=true;
		try{
			
			String lastUpdate="Last updated by";
			if(getText(selenium,elementId).contains(lastUpdate))
				if(getText(selenium, elementId).contains(date))
					if(getText(selenium, elementId).contains(time))
						returnValue = true;
			
					else{
				Assert.fail("Time stamp is not present in summary page");
				returnValue = false;
			}
			return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * verifyTimeStampForProviderPage
	 * function is verify Time Stamp For Provider Page
	 * @param 		selenium 
	 * @return		boolean
	 * @since  	    sept 21, 2012
	 */
	public boolean verifyTimeStampForNicholas(Selenium selenium , String elementId, String date, String time){
		boolean returnValue=false;
		try{
			
			String lastUpdate="Last updated by Nicholas Reeves at ";
			if(getText(selenium,elementId).contains(lastUpdate))
				if(getText(selenium, elementId).contains(date))
					if(getText(selenium, elementId).contains(time))
						returnValue = true;
			
					else{
				Assert.fail("Time stamp is not present in summary page");
				returnValue = false;
			}
			return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	public static void waitForAjaxRequestDone(final Selenium selenium,final String timeout){
		selenium.waitForCondition(
				"selenium.browserbot.getCurrentWindow().jQuery.active == 0",
				timeout);
		}

	/**
	 * waitForElementToEnable
	 * function is used to wait until the elemnt is enabled 
	 * @param 		selenium 
	 * @return		boolean
	 
	 * @since  	     May 05, 2010
	 */	
	public boolean waitForElementToEnable(Selenium selenium, String elementName){
		boolean isEditable = false;
		try {
			for(int i=1; i<=120;i++){
				if(!selenium.isEditable(elementName)){
					Thread.sleep(1000);
					continue;
				}else {
					isEditable = true;
					break;
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return isEditable;
	}

	public String getCurrentlyExecutingMethodName() {
		Throwable t = new Throwable(); 
		StackTraceElement[] elements = t.getStackTrace(); 
		if (elements.length <= 0) return "[No Stack Information Available]";
		if (elements.length < 2) return null;
		return elements[1].getMethodName();
	}
	public String getListCount(String listCount){
		listCount = listCount.substring(listCount.indexOf("(")+1,listCount.indexOf(")"));
		return listCount;
	}
	/**
	 * Capturing screenshot, Setting test result and creating log files after
	 * each test run
	 * 
	 * @param result
	 * @throws IOException
	 * @throws TestLinkAPIException 
	 */

	@AfterMethod(alwaysRun = true)
	public final void tearDown(ITestResult result) throws IOException, TestLinkAPIException {
		MapToTestLink mapToTestLink=result.getMethod().getMethod().getAnnotation(MapToTestLink.class);
		if(mapToTestLink!=null){
			String testCase=mapToTestLink.testCaseID();
				if (result.isSuccess()) {
					testLinkResult= TestLinkAPIResults.TEST_PASSED;
					notes="Executed successfully";
					api=new TestLinkAPIClient(fetchProperty("clinical", "testlinkKey"), fetchProperty("clinical", "testlinkUrl"));
					api.reportTestCaseResult(fetchProperty("clinical", "testProject"), fetchProperty("clinical", "testPlan"), fetchProperty("clinical", "testSuiteID"), testCase, notes, testLinkResult,fetchProperty("clinical", "testBuildId"));
				}
				else
				{
					testLinkResult= TestLinkAPIResults.TEST_FAILED;
					notes="Execution Failed";
					api=new TestLinkAPIClient(fetchProperty("clinical", "testlinkKey"), fetchProperty("clinical", "testlinkUrl"));
					api.reportTestCaseResult(fetchProperty("clinical", "testProject"), fetchProperty("clinical", "testPlan"), fetchProperty("clinical", "testSuiteID"), testCase, notes, testLinkResult,fetchProperty("clinical", "testBuildId"));
				}
		}
	}


	@AfterSuite
	public static void closeSessions(){
		try {
			for(int counter = 0;counter< seleniumSessions.size(); counter ++){
				if (null != seleniumSessions.get(counter)) {
					seleniumSessions.get(counter).stop();					
				}
			}
		} catch (Exception e) {
			// Exception will occur while trying to close the crashed session. So no need to make it failed  
			e.printStackTrace();
		}
	}
	
	public Collection<String> getDataBaseIDs(Selenium selenium,String locator){

		Collection<String> firstList = new ArrayList<String>();
		int xpathCounter = (Integer) selenium.getXpathCount("//a[starts-with(@id, '"+locator+"')]");
		for(int i=0;i<xpathCounter;i++){
			// Replaced the XPATH with CSS path to increase the search speed
			firstList.add(selenium.getAttribute("css=a[id*="+locator+"]:nth("+i+")@id"));	
		}
		return firstList;

	}
	
	//New Method to get dynamic ids and avoid the looping in the existing method as well as reduce the selenium communication , Not yet started to use
	public Collection<String> getDataBaseIDs_New(Selenium selenium,String locator){
		Collection<String> firstList = new ArrayList<String>();
		String allLinkIds = Arrays.asList(selenium.getAllLinks()).toString(); 
		System.out.println("All link Ids  : " + allLinkIds);
		String dbIds[] = allLinkIds.substring(allLinkIds.indexOf(locator), allLinkIds.indexOf(", ", allLinkIds.lastIndexOf(locator))).split(", ");
		
		firstList.addAll(Arrays.asList(dbIds));
		
		System.out.println(" Val  : "+ dbIds.length);
		return firstList;//(Collection<String>)Arrays.asList(dbIds);

	}

	//--------------------------------------------------------------------//
	//  Capture Screenshot												  // 
	//--------------------------------------------------------------------// 
	
	public void assertTrue(boolean condition, String message, Selenium selenium, String className, String methodName) throws IOException {
	    if(!condition) {	    		
	    	
	    	   InetAddress IP=InetAddress.getLocalHost();    	    
	    	    
	    	    // If the Selenium Tests are running on any VMs in the Markham lab or Jenkins then following are the conditions
	    	    if( IP.getHostAddress().equals("10.33.3.87") || IP.getHostAddress().equals("10.33.2.159") || IP.getHostAddress().equals("10.33.2.171") || IP.getHostAddress().equals("10.1.13.93") || IP.getHostAddress().equals("10.33.2.27")|| IP.getHostAddress().equals("10.33.2.140"))	    	    	
	    	    {
	    	    	
	    	    String OutputDirectory = "\\\\MARQAA04\\Failure-Screenshot";
    	    	captureScreenShot(message, OutputDirectory, selenium, className, methodName);	    	    	
	    	    } 
	    	    // Jenkins Linux Machine
	    	    else if (IP.getHostAddress().equals("10.33.1.183") )
	    	    {
	    	    	String OutputDirectory = "/mnt/marqaa04";
	    	    	captureScreenShot(message, OutputDirectory, selenium, className, methodName);
	    	    	
	    	    }	
	    	    	
	    	    else    	    	
	    	    {
	    	    	    	
	    	    	String OutputDirectory = "C:" + File.separator + "Failure-Screenshot";	    	    	
	    	    	File theDir = new File(OutputDirectory);	    	    	
	    	    	if (!theDir.exists())
					  {
					    System.out.println("creating directory: " + theDir);
					    boolean result = false;
					    try{
					    	result = theDir.mkdirs();
					    	
					    }
					    catch (Exception e) {
							System.out.println(e);
						}
					    if(result){    
					       System.out.println(theDir + " DIR created");  
					    }
		
					  }
	    	    	
	    	    	captureScreenShot(message, OutputDirectory, selenium, className, methodName);	    	    	
	    	    }  	        	    
	 							
				
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }

				failNotEquals( Boolean.valueOf(condition), Boolean.TRUE, message);
	    }
	}	
	
	//--------------------------------------------------------------------//
		//  Capture Screenshot												  // 
		//--------------------------------------------------------------------// 
		
		public void assertTrue(boolean condition, String message, WebDriver driver, String className, String methodName) throws IOException {
		    if(!condition) {	    		
		    	
		    	    InetAddress IP=InetAddress.getLocalHost();    	    
		    	    
		    	    // If the Selenium Tests are running on any VMs in the Markham lab or Jenkins then following are the conditions
		    	    if( IP.getHostAddress().equals("10.1.21.90") || IP.getHostAddress().equals("10.33.3.20") || IP.getHostAddress().equals("10.33.2.140") || IP.getHostAddress().equals("10.33.3.87") || IP.getHostAddress().equals("10.33.2.159")|| IP.getHostAddress().equals("10.1.13.90")|| IP.getHostAddress().equals("10.1.13.91"))	    	    	
		    	    {
		    	    	
		    	    	String OutputDirectory = "\\\\MARQAA04\\Failure-Screenshot";
		    	    	captureScreenShot(message, OutputDirectory, driver, className, methodName);	    	    	
		    	    } 
		    	    // Jenkins Linux Machine
		    	    else if (IP.getHostAddress().equals("10.33.1.183") )
		    	    {
		    	    	String OutputDirectory = "/mnt/marqaa04";
		    	    	captureScreenShot(message, OutputDirectory, driver, className, methodName);
		    	    	
		    	    }	
		    	    	
		    	    else    	    	
		    	    {
		    	    	    	
		    	    	String OutputDirectory = "C:" + File.separator + "Failure-Screenshot";	    	    	
		    	    	File theDir = new File(OutputDirectory);	    	    	
		    	    	if (!theDir.exists())
						  {
						    System.out.println("creating directory: " + theDir);
						    boolean result = false;
						    try{
						    	result = theDir.mkdirs();
						    	
						    }
						    catch (Exception e) {
								System.out.println(e);
							}
						    if(result){    
						       System.out.println(theDir + " DIR created");  
						    }
			
						  }
		    	    	
		    	    	captureScreenShot(message, OutputDirectory, driver, className, methodName);	    	    	
		    	    }  	        	    
		 							
					
	                try {
	                    Thread.sleep(5000);
	                }catch (InterruptedException e) {
	                    e.printStackTrace();
	                }

					failNotEquals( Boolean.valueOf(condition), Boolean.TRUE, message);
					driver.quit();
		    }
		}	
	
	
	// If the selenium tests are executed on Jenkins Linux machine
	protected void reportLogScreenshot(String StrFile) {
	      System.setProperty("org.uncommons.reportng.escape-output", "false");      
	      
	      //System.out.println("Linux ImagePath" + StrFile );	      
	      Reporter.log("<a href=" + StrFile + "><p align=\"left\">Error screenshot on " + new Date()+ "</p>");
	      
	      		
	}
	
	// If the selenium tests are executed on Jenkins Linux machine
	protected void reportWebDriverLog(String StrFile) {
	      System.setProperty("org.uncommons.reportng.escape-output", "false");      
		      
	      //System.out.println("Linux ImagePath" + StrFile );	      
	      Reporter.log("<a href=" + StrFile + "><p align=\"left\">WebDriver Log on " + new Date()+ "</p>");
	    
		      		
	}

   public void captureScreenShot(String message, String OutputDirectory, Selenium selenium, String className, String methodName) {
		
	 try {	    
	    	    
	    InetAddress IPLinux=InetAddress.getLocalHost();
	    // If the tests are executed on the Jenkins Linux machine
	    if (IPLinux.getHostAddress().equals("10.33.1.183"))	    	
	    {	
	    	String imageName = className + "_" + methodName  + "_"+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
	    	String imagePath = OutputDirectory +  File.separator + imageName;
	    	
		    String base64Screenshot = session().captureEntirePageScreenshotToString("");
		    byte[] decodedScreenshot = Base64.decodeBase64(base64Screenshot.getBytes());
		    FileOutputStream fos = new FileOutputStream(new File(imagePath));
		    fos.write(decodedScreenshot);
		    fos.close();
	    	
		    // Copy the capture image file to report html folder
		    String strBasePath = null;
		    String file = null;
		    
		    File dir1 = new  File (".");		    
		    strBasePath=dir1.getCanonicalPath();
		    file=strBasePath + File.separator + "target" + File.separator + "surefire-reports" + File.separator + "html" ;
		    File destDir = new File(file);
		    FileUtils.copyFileToDirectory(new File(imagePath), destDir);
		    
	    	reportLogScreenshot(imageName);
	    	
	    } else
	    {	
	    	
	     String imageName = className + "_" + methodName  + "_"+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
		 String imagePath = OutputDirectory +  File.separator + imageName;
		    	    	    
		 String base64Screenshot = session().captureEntirePageScreenshotToString("");
		 byte[] decodedScreenshot = Base64.decodeBase64(base64Screenshot.getBytes());
		 FileOutputStream fos = new FileOutputStream(new File(imagePath));
		 fos.write(decodedScreenshot);
		 fos.close();
		 
		// Copy the capture image file to report html folder
		 String strBasePath = null;
		 String file = null;
		 File dir1 = new  File (".");		    		    
		 strBasePath=dir1.getCanonicalPath();
		 file=strBasePath + File.separator + "test-output" + File.separator + "html";
		 File destDir = new File(file);
		 FileUtils.copyFileToDirectory(new File(imagePath), destDir);
		  
		 reportLogScreenshot(imageName);
	     
	    }
	    
		} catch (Exception e) {
		      e.printStackTrace();
		 }
		
	}
   /**
	 * searchPatientNexiaForProviderHomePage
	 * function for Searching a patient in the Nexia application   
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws IOException 
	 
	 * @since  	    Sep 29, 2012
	 */
	public boolean searchPatientNexiaForNoAccess(Selenium selenium,String patientID){
	try{
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		assertTrue(type(selenium,txtPatientBox,patientID),"Could not type patient id", selenium, ClassName,MethodName);
		selenium.clickAt("searchPatientBox","");
		selenium.focus("searchPatientBox");			
		selenium.fireEvent("searchPatientBox","keypress");
		selenium.keyPress(txtPatientBox, "\\9");
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		waitForElement(selenium,lblPatientResult,30000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patientID, selenium, ClassName,MethodName);
		//waitForPageLoad(selenium);		
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		click(selenium,lblPatientResult);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,lnkPatientSelect)){
			assertTrue(click(selenium,lnkPatientSelect),"Could not select the patient ", selenium, ClassName,MethodName);
		}
		
		if(isElementPresent(selenium,lnkContinue)){
			selenium.click(lnkContinue);
		}
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	}catch(RuntimeException e){
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return true;
		
	}

public void captureScreenShot(String message, String OutputDirectory, WebDriver driver, String className, String methodName) {
	
	 try {	    
	    	    
	    InetAddress IPLinux=InetAddress.getLocalHost();
	    // If the tests are executed on the Jenkins Linux machine
	    if (IPLinux.getHostAddress().equals("10.33.1.183"))	    	
	    {	
	    	String imageName = className + "_" + methodName  + "_"+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
	    	String imagePath = OutputDirectory +  File.separator + imageName;
	    	
		    //String base64Screenshot = .captureEntirePageScreenshotToString("");
	    	String base64Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		    byte[] decodedScreenshot = Base64.decodeBase64(base64Screenshot.getBytes());
		    FileOutputStream fos = new FileOutputStream(new File(imagePath));
		    fos.write(decodedScreenshot);
		    fos.close();
	    	
		    // Copy the capture image file to report html folder
		    String strBasePath = null;
		    String file = null;
		    
		    File dir1 = new  File (".");		    
		    strBasePath=dir1.getCanonicalPath();
		    file=strBasePath + File.separator + "target" + File.separator + "surefire-reports" + File.separator + "html" ;
		    File destDir = new File(file);
		    FileUtils.copyFileToDirectory(new File(imagePath), destDir);
		    
	    	reportLogScreenshot(imageName);
	    	
	    } else
	    {	
	    	
	     String imageName = className + "_" + methodName  + "_"+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
		 String imagePath = OutputDirectory +  File.separator + imageName;
		    	    	    
		 //String base64Screenshot = session().captureEntirePageScreenshotToString("");
		 String base64Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		 byte[] decodedScreenshot = Base64.decodeBase64(base64Screenshot.getBytes());
		 FileOutputStream fos = new FileOutputStream(new File(imagePath));
		 fos.write(decodedScreenshot);
		 fos.close();
		 
		// Copy the capture image file to report html folder
		 String strBasePath = null;
		 String file = null;
		 File dir1 = new  File (".");		    		    
		 strBasePath=dir1.getCanonicalPath();
		 file=strBasePath + File.separator + "test-output" + File.separator + "html";
		 File destDir = new File(file);
		 FileUtils.copyFileToDirectory(new File(imagePath), destDir);
		  
		 reportLogScreenshot(imageName);
	     
	    }
	    
		} catch (Exception e) {
		      e.printStackTrace();
		 }
		
	}

	
	
	private void failNotEquals(Object actual , Object expected, String message ) {
	    fail(format(actual, expected, message));
	}
	
	public void fail(String message) {
		Assert.fail(message);		
		System.out.println("test");
	    //throw new AssertionError(message);
	}
	
	String format(Object actual, Object expected, String message) {
	    String formatted = "";
	    if (null != message) {
	      formatted = message + " ";
	    }
	    
	    return formatted + "expected:<" + expected + "> but was:<" + actual + ">";
	}
}

class WaitClass extends Wait{
	Selenium selenium;
	String ajaxElementName;
	public WaitClass(Selenium selenium,String ajaxElementName) {
		this.selenium = selenium;
		this.ajaxElementName = ajaxElementName;
	} 
	@Override
	public boolean until() {
		return selenium.isElementPresent(ajaxElementName);
	}

}
