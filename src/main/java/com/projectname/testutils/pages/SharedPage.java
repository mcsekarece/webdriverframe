package com.projectname.testutils.pages;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;


public class SharedPage extends SeleniumWebDriver{

	public  SharedPage(){
	    PageFactory.initElements(SeleniumWebDriver.driver,this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	private  By  readyLocator = By.linkText("Quick actions");
	private By txtAccount = By.id("loginAccountText");
	private By txtUserName = By.id("loginUseridText");
	private By txtPassword = By.id("loginPasswordText");
	private By btnLogin = By.id("loginButton");
	private By txtPatientBox = By.id("searchPatientBox");
	private By btnErrorClose = By.id("errorCloseButton");
	private By lnkQuickLink = By.linkText("Quick Actions");
	private By lnkSettings = By.linkText("Settings");
	private By lnkSecuritysetting=By.id("securitySettingsAction");
	private By lnkRecordLocking=By.id("!recordLockingMain");
	private By lnkSearchR=By.xpath("//input[@id='searchTextBox']/parent::div/following-sibling::a");
	private By chkEntry=By.cssSelector("input[type=\"checkbox\"]");
	private By lnkUnlock=By.linkText("Unlock");
	private By btnSearch=By.xpath("(//div[@class='search-box-wrapper'])[2]/a");
	
	private By lnkClinicalSettingsLink = By.id("clinicalSettingsAction");
	private By lnkQuickActions=By.linkText("Quick Actions");
	private By lnkCalendar=By.id("operationsAction");
	private By lnkBillingHistory =By.linkText("Billing history"); 
    private By lnkPostCharge =By.xpath("//a[contains(text(),'Post charges')]");
    public By lnkPostCharge1 = By.xpath("(//a[contains(text(),'Post charges')])[2]");
    private By lnkPostCharge2 =By.linkText("Encounter not found. Post new charges.");
	
	private By lnkBillingSettings =By.id("billingSettingsAction");
	//switch role
	private By lnkTopMenu=By.id("username");
	private By lnkSwitchrole=By.id("switchRoleAction");
	private By ajxSwitchrole=By.id("suggestBox");
	private By txtDeleteReason=By.id("deleteReason");

	//sign out
	private By lnkSignout=By.id("signOutAction");
	private By btnYes = By.id("yesButton");
	private By lnkBtnContinue=By.linkText("Continue");
	private By lnkBtnYes=By.linkText("Yes");
	private By lnkContinuelogout=By.linkText("Continue logging out");

	
	//Search
	private By lblPatientResult=By.id("patientInfoWidget");
	
	private String  lblPatientResultMousehover = "patientInfoWidget";
	private By lblPatientName=By.id("patientName");
	private By lnkPatientSelect=By.id("doNotShowAgaincheckbox");
	private By lnkContinue=By.linkText("link=Continue");
	private By btnYesbutton = By.id("yesButton");

	
	// Begin Encounter
	private By lnkPatientOptions = By.linkText("Patient Options");
	private By patientChart = By.cssSelector("#patientOptionsChartView > span");
	
	//Payer
	private By lnkPostNewCharge =By.linkText("Encounter not found. Post new charges.");
	 
	private By btnNexiaLogo =By.id("logoAnchor");
	private By lbl = By.xpath("//tr/td/a/span");
	//Create a patient
		private By lnkRegisterPatient=By.id("newPatientAction");
		private By lnkLocationMenuHeader = By.id("locationMenuHeader");
		private By lnkUnsignedEncounterQueue= By.id("Unsignedencounters");
		private By txtSearchUnsignedEncounter= By.id("searchTextBox");
		private By ajxShow=By.id("suggestBox");
		private By lblUnsignedEncounterListItem= By.id("unsignedEncounterListItem");
		private String lblUnsignedEncounterList= "(//div[contains(@id,'unsignedEncounterListItem')])[%s]";
		private By lnkPatientOption = By.linkText("Patient Options");
		private By lnkChartDisclosure=By.id("chartDisclosureRequestView");
		
		private By lnkUnfinishedItem= By.xpath("//div[@id='unfinishedItemMenuID']/a");
		private By lnkFirstUnfinishedItem = By.cssSelector("div.unfinished-item-name");
		private By btnBack = By.id("back");
		private By btnNo = By.id("No");
		
		private By lnkSystemSettings = By.id("systemSettingsAction");
		private By lnkTemplateSettings = By.id("templateSetupAction");
		
	//------------
	
	/***
	 * Call to super constructor
	 */
	public SharedPage(WebDriver driver){
		super(driver);
	}

	/**
	 * loginForNexiaFromProviderSite
	 * This function will login For Nexia From Provider Site
	 * @param 		driver (an instance of current driver browser )
	 * @param 		userAccount
	 * @param 		userName
	 * @param 		userPassword
	 * @throws       IOException 
	 * @since  	     Mar 29, 2010
	 */
	public boolean loginForNexiaFromProviderSite(WebDriver driver, String userAccount, String userName, String userPassword) {            
     try{
		if(!waitForElement(driver,txtAccount, WAIT_TIME*1000)){
        	AssertJUnit.fail("Login Page Not loaded More Details; UserAccount :- "+userAccount +"  UserName :- " +userName+ " UserPassword :- "+ userPassword);
        }
        type(driver, txtAccount, userAccount);
        type(driver, txtUserName, userName);
        type(driver, txtPassword, userPassword);
        
        click(driver, btnLogin);
        waitForPageLoad(driver);
       /* if(isElementPresent(driver,btnAgree)){
        	click(driver,btnAgree);
        }*/
        if(waitForElement(driver, btnErrorClose, WAIT_TIME*1000))
        {
        if(isElementPresent(driver, btnErrorClose)){
			assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
        }
        }
        waitForPageLoad(driver);
            if(waitForElement(driver, txtPatientBox, WAIT_TIME*1000)){
        	 if(isElementPresent(driver, btnErrorClose)){
     			assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
             }
        	return true;
        }else{
               return false;
        }
        
     }catch(RuntimeException e){
         e.printStackTrace();
     } 
	return true;
	}
	
	/**
	 * goToFirstUnfinishedItem
	 * function for    goin to First UnfinishedItem
	 * @param 		driver 
	 * @since  	    Mar 18, 2015
	 */

	public boolean goToFirstUnfinishedItem (WebDriver driver)
	{
		verifyTrue(click(driver, lnkUnfinishedItem),"could not click Unfinished Item link", driver);
		waitForPageLoad(driver);
		verifyTrue(click(driver, lnkFirstUnfinishedItem),"could not click first Unfinished Item link", driver);
		waitForPageLoad(driver);

		return true;
	}

	/**
	 * goToSystemSettings
	 * function for  navigating to System Settings
	 * @param 		driver 
	 * @since  	    Apr 27, 2015
	 */

	public SystemSettingsPage goToSystemSettings (WebDriver driver)
	{
		verifyTrue(click(driver, lnkSettings),"could not click Settings link", driver);
		waitForPageLoad(driver);
		verifyTrue(click(driver, lnkSystemSettings),"could not click first System Settings link", driver);
		waitForPageLoad(driver);

		return new SystemSettingsPage();
	}


	/**
	 * scrollDownPage
	 * function for  Page ScrollDown
	 * @param 		driver 
	 * @since  	    Apr 28, 2015
	 */

	public boolean scrollDownPage (WebDriver driver)
	{
    	try{
    	
    //FIXME VEL-8211
    By scroll=By.xpath("//*[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div[2]/div");
    WebElement scrollUp = driver.findElement(scroll);
  	scrollUp.sendKeys(Keys.PAGE_DOWN);
   	scrollUp.sendKeys(Keys.PAGE_DOWN);
  	scrollUp.sendKeys(Keys.PAGE_DOWN);
  	scrollUp.sendKeys(Keys.PAGE_DOWN);
  	scrollUp.sendKeys(Keys.PAGE_DOWN);
 	waitForPageLoad(driver); 
  	scrollUp.sendKeys(Keys.PAGE_DOWN);
  	scrollUp.sendKeys(Keys.PAGE_DOWN);
  	scrollUp.sendKeys(Keys.PAGE_DOWN);
    	}
    	catch(Exception e)
    	{
    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

    	}
		return true;
	
	}

	/**
	 * goToSystemSettings
	 * function for  navigating to System Settings
	 * @param 		driver 
	 * @since  	    Apr 27, 2015
	 */

	public TemplateSettingsPage goToTemplateSettings (WebDriver driver)
	{
		verifyTrue(click(driver, lnkSettings),"could not click Settings link", driver);
		waitForPageLoad(driver);
		verifyTrue(click(driver, lnkTemplateSettings),"could not click first System Settings link", driver);
		waitForPageLoad(driver);

		return new TemplateSettingsPage();
	}

	/**
	 * clickNo
	 * function for clicking the No button
	 * @param 		driver 
	 * @since  	    Mar 19, 2015
	 */

	public boolean clickNo (WebDriver driver)
	{
		if(isElementPresent(driver,btnNo))
		verifyTrue(click(driver, btnNo),"could not click Unfinished Item link", driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		return true;
	}

	
	/**
	 * searchPatientNexiaForProviderHomePage
	 * function for Searching a patient in the Nexia application   
	 * @param 		driver
	 * @param 		patientID (Patient ID to be searched)
	 * @throws IOException 
	 
	 * @since  	    Sep 29, 2012
	 */
	public DemographicsPage searchPatientNexiaForProviderHomePage(WebDriver driver,String patientID){
	try{
		assertTrue(type(driver,txtPatientBox,patientID),"Could not type patient id", driver, className,methodName);
		
		//click(driver,txtPatientBox);
		
		//driver.keyPress(txtPatientBox, "\\9");
		waitForElement(driver,lblPatientResult,30000);
		assertTrue(isElementPresent(driver,lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patientID, driver, className,methodName);
		waitForPageLoad(driver);
		
		assertTrue(getText(driver,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))),"could not get patient id", driver, className,methodName);
		//Assert.assertTrue(getText(driverlblPatientResult).contains(patientID));
		waitForPageLoad(driver);
		click(driver,lblPatientResult);
		waitForPageLoad(driver);
		assertTrue(isElementPresent(driver,lblPatientName),"The searched patient information could not be loaded", driver, className,methodName);
		if(isElementPresent(driver,lnkPatientSelect)){
			assertTrue(click(driver,lnkPatientSelect),"Could not select the patient ", driver, className,methodName);
		}
		
		
		if(isElementPresent(driver,lnkContinue)){
			click(driver,lnkContinue);
		}
		if(isElementPresent(driver, btnErrorClose))

			assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
	}catch(RuntimeException e){
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return  new DemographicsPage();		
	}
	
	//-----------------
	
	/**
	 * goToPatientRegPage
	 * function to go to Patient Registration Page
	 * @param 		driver (an instance of current driver browser )
	 * @param 		switchRole
	 * @Version 2.1
	 * @since  	     Nov 25, 2010
	 */
	
	public PatientRegistationPage goToPatientRegPage(WebDriver driver)throws Exception
	{
		try {
		assertTrue(click(driver,lnkQuickLink),"Could not click on quick action", driver, className, methodName);
		waitForPageLoad(driver);
		assertTrue(click(driver,lnkRegisterPatient),"Could not click the Register Patient", driver, className, methodName);
		waitForPageLoad(driver);
	}catch (Exception e) {
			  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		    }
		return new PatientRegistationPage();
	}
	
		/**
		 * switchRole
		 * This function will switchRole to Nexia Site
		 * @param 		driver (an instance of current driver browser )
		 * @param 		switchRole
		 * @since  	     Nov 25, 2010
		 */
	    public HomePage switchRole(WebDriver driver, String switchRole)throws Exception{            
	        
			if(!waitForElement(driver, lnkTopMenu, WAIT_TIME)){
	        	AssertJUnit.fail(" Top Menu Header not opened More Details; switchRole :- "+switchRole);
	        }
			if(isElementPresent(driver, btnErrorClose)) {		
					assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);				
			}
			String TopMenu=getText(driver, lnkTopMenu);
			int index=TopMenu.indexOf(',');
			TopMenu=(TopMenu.substring(index+1)).trim();
			
			if(!TopMenu.equalsIgnoreCase(switchRole)){
				click(driver,lnkTopMenu);
		        click(driver,lnkSwitchrole);
		        if(isElementPresent(driver, btnErrorClose)) {
					try {
						assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					waitForPageLoad(driver);
				}	
		        waitForPageLoad(driver);
		        selectValueFromAjaxList(driver,ajxSwitchrole,switchRole);
		        click(driver,txtDeleteReason);
		        waitForPageLoad(driver);
		        waitForPageLoad(driver);
		        
				if(isElementPresent(driver, btnErrorClose)) {
					try {
						assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					waitForPageLoad(driver);
				}			
		        
		        if(getText(driver, lnkTopMenu).toLowerCase().contains(switchRole.toLowerCase())){
		        	waitForPageLoad(driver);  
		        	 if(isElementPresent(driver, btnErrorClose)) {
		 				try {
		 					assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
		 				} catch (Exception e) {
		 					// TODO Auto-generated catch block
		 					e.printStackTrace();
		 				}
		 				waitForPageLoad(driver);
		 			}	
		        }
			}
			return new HomePage();
	    }

	    /**
		 * searchPatientNexia
		 * function for Searching a patient in the Nexia application   
		 * @param 		driver
		 * @param 		patientID (Patient ID to be searched)
		 * @throws      IOException 
		 * @since  	     Nov 25, 2012
		 */
		public PatientChartPage searchPatientNexia(WebDriver driver,String patientID) throws Exception{
			try{
				
			if(isElementPresent(driver, btnErrorClose))
				assertTrue(click(driver, btnErrorClose),"could not click on error close", driver, className,methodName);
			assertTrue(type(driver,txtPatientBox,patientID),"Could not type patient id", driver, className,methodName);
			driver.findElement(txtPatientBox).sendKeys(Keys.ENTER);					
			waitForElement(driver,lblPatientResult,10000);
			/*if(isElementPresent(patientInfoWidget)){
			assertTrue(isElementPresent(patientInfoWidget),"Search Results are not displayed for the patient with ID :-"+patientID, driver, className,methodName);
			assertTrue(getText(driver,patientInfoWidget).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not get patient id", driver, className,methodName);
			click(driver,patientInfoWidget);
			}*/
			if(isElementPresent(lblPatientResult))
			{
				assertTrue(isElementPresent(driver,lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patientID, driver, className,methodName);
				assertTrue(getText(driver,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not get patient id", driver, className,methodName);
				click(driver,lblPatientResult);
			}
			waitForPageLoad(driver);
			if(isElementPresent(driver, btnErrorClose))
				assertTrue(click(driver, btnErrorClose),"could not click on error close", driver, className,methodName);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			}catch(RuntimeException e){
				e.printStackTrace();
			}
			return new PatientChartPage();
		}
		
		/**
		 * searchPatientForBillerRole
		 * function to search a patient for biller role
		 * @param patientID- Patient Id to search(String)
		 * @throws  Exception 
		 * @since  	Dec 17, 2014
		 * @version 2.1
		 */	
		public BillingHistoryPage searchPatientForBillerRole(WebDriver driver,String patientID) throws Exception{
			try{
				
			if(isElementPresent(driver, btnErrorClose))
				assertTrue(click(driver, btnErrorClose),"could not click on error close", driver, className,methodName);
			assertTrue(type(driver,txtPatientBox,patientID),"Could not type patient id", driver, className,methodName);
			driver.findElement(txtPatientBox).sendKeys(Keys.ENTER);					
			waitForElement(driver,lblPatientResult,10000);
			if(isElementPresent(lblPatientResult))
			{
				assertTrue(isElementPresent(driver,lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patientID, driver, className,methodName);
				assertTrue(getText(driver,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not get patient id", driver, className,methodName);
				click(driver,lblPatientResult);
			}
			waitForPageLoad(driver);
			if(isElementPresent(driver, btnErrorClose))
				assertTrue(click(driver, btnErrorClose),"could not click on error close", driver, className,methodName);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			}catch(RuntimeException e){
				e.printStackTrace();
			}
			return new BillingHistoryPage();
		}
    /********************
    **  Go to chart  **
    *******************/

	public boolean goToChart(WebDriver driver) throws IOException {
		try {

			assertTrue(click(driver, lnkPatientOptions),
					"Could not click Patient options", driver, className,
					methodName);
			waitForPageLoad(driver);
			assertTrue(click(driver, patientChart),
					"Could not click on Pateint chart", driver, className,
					methodName);
			waitForPageLoad(driver);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}

//	public boolean createPatient(WebDriver driver,HomeLib programData,String userAccount)
//	{
//	try{
//	    PatientRegistationPage patientRegPage=new PatientRegistationPage();
//		patientRegPage.createPatient(driver,programData,userAccount);
//	}catch(Exception e)
//	{
//		e.printStackTrace();
//		return false;
//	}
//	return true;
//	}

	/**selectPractice
	 * function to select encounter template practice
	 * @param driver
	 * @param patientID(Patient ID to be searched)
	 * @throws IOException
	 * @since Nov 25, 2012
	 */
	public boolean selectPractice(WebDriver driver,String practice) throws Exception
	{
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		if(isElementPresent(driver, btnErrorClose)){
			assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
                }
		if(!getText(driver,lnkLocationMenuHeader).contains(practice)){
			assertTrue(click(driver,lnkLocationMenuHeader),"Could not click on practices link:", driver, className, methodName);
			waitForPageLoad(driver);
		 int Count;
			int Count1=(Integer) getXpathCount(driver,By.xpath("//tr/td/a/span"));
			for(Count=1;Count<=Count1;Count++)		{
				if(getText(driver,By.xpath("//tr["+Count+"]/td/a/span")).contains(practice)){
					
					assertTrue(click(driver,By.xpath("//tr["+Count+"]/td/a/span")),"Could not click on practices link:", driver, className, methodName);
					waitForPageLoad(driver);
					break;
				}
			}	
			if(isElementPresent(driver, btnErrorClose)) {
				try {
					assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
	   return true;
	   }


	/**Record unlocking
	 * function to Record unlocking
	 * @param driver
	 * @param patientID(Patient ID to be searched)
	 * @throws IOException
	 * @since Nov 25, 2012
	 * @Version 2.1
	 */
	   public boolean unlock(WebDriver driver) throws IOException{
		      try{
		        if(isElementPresent(driver, btnErrorClose))
		                  assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
		        waitForPageLoad(driver);
		        
		        assertTrue(click(driver,lnkSettings),"Could not click on quick action",driver, className,methodName);
		          waitForPageLoad(driver);
		              if(isElementPresent(driver, lnkSecuritysetting)){
		                assertTrue(click(driver,lnkSecuritysetting),"Could not click on security settings",driver, className,methodName);
		                waitForPageLoad(driver);
		                if(isElementPresent(driver,lnkRecordLocking)){
		                assertTrue(click(driver,lnkRecordLocking),"Could not click on Record Locking link",driver, className,methodName);
		                waitForPageLoad(driver);
		                assertTrue(click(driver,lnkSearchR),"could not click on Search Link",driver, className,methodName);
		                waitForPageLoad(driver);
		                click(driver,btnSearch);
		                waitForPageLoad(driver);
		                if(isElementPresent(driver, btnErrorClose))
		                              assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
		                if(isVisible(driver,chkEntry)){
		                      assertTrue(click(driver,chkEntry),"Could not check the entry",driver, className,methodName);
		                      assertTrue(click(driver,lnkUnlock),"Could not unlock entry",driver, className,methodName);
		                      assertTrue(click(driver,btnYesbutton),"Could not click on yes button",driver, className,methodName);
		                      waitForPageLoad(driver);
		                     }
		                
		                  assertTrue(click(driver,btnNexiaLogo),"Could not click the back button",driver, className,methodName);
		                }else{
		                    
		                    assertTrue(click(driver,btnNexiaLogo),"Could not click the back button",driver, className,methodName);
		                }
		                if(isElementPresent(driver, btnErrorClose))
		                        assertTrue(click(driver, btnErrorClose),"could not click error close",driver, className,methodName);
		              }else{
		                   assertTrue(click(driver,lnkQuickLink),"Could not click on quick action",driver, className,methodName);
		                   waitForPageLoad(driver);
		              }
		          }catch(RuntimeException e){
		                e.printStackTrace();
		          }
		          return true;
		    }


	
	/**
	 * gotoChargeEntryPage function to gotoChargeEntryPage
	 * @param driver
	 * @param patientID- 	(Patient ID to be searched)
	 * @throws IOException
	 * @since Dec 22, 2014
	 */
	  public PostChargesPage gotoChargeEntryPage(WebDriver driver, String patientId) throws IOException {
			
				// Navigate to  Patient
				
				if(isElementPresent(driver, btnErrorClose))
				assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
				waitForPageLoad(driver);
				assertTrue(type(driver, txtPatientBox, patientId),"Could not type patient last name", driver, className,methodName);
				waitForPageLoad(driver);
				waitForElement(driver, lblPatientResult, 10000);
				
				assertTrue(isElementPresent(driver,lblPatientResult),"Search Results are not displayed for the patient with ID :-"+ patientId, driver, className,methodName);
				waitForPageLoad(driver);
				
				mouseOver(lblPatientResultMousehover);
				waitForPageLoad(driver);
				
				if(isElementPresent(driver, lnkPostCharge)){
                    assertTrue(click(driver, lnkPostCharge),"Could not present Post charge link", driver, className, methodName);
                    waitForPageLoad(driver);
                    }else{
                    assertTrue(click(driver, lnkPostCharge1),"Could not present Post charge link", driver,className,methodName);
                    waitForPageLoad(driver);
                    }
              waitForPageLoad(driver);
              waitForPageLoad(driver);
              waitForPageLoad(driver);
              waitForPageLoad(driver);
                    if(isElementPresent(driver, lnkPostCharge2)){
                    assertTrue(click(driver, lnkPostCharge2),"Could not present Post new charge link", driver, className, methodName);
                    waitForPageLoad(driver);
                    }else{
                    assertTrue(click(driver, lnkPostCharge1),"Could not present Post new charge link", driver,className,methodName);
                    waitForPageLoad(driver);
                    }
              if(isElementPresent(driver, btnErrorClose))
              assertTrue(click(driver, btnErrorClose),"could not click error close",driver, className, methodName);
              waitForPageLoad(driver);
              waitForPageLoad(driver);
              waitForPageLoad(driver);
              waitForPageLoad(driver);             
              return new PostChargesPage();

		
	}
		
		
		/**
		 * statementTrigger
		 * To Verify statementTrigger
		 *  @param driver
		 * @since	DEC 22,2014
		 */
		
		public boolean statementTrigger(WebDriver driver){
			try{
				String webSite = "https://108.161.43.79:8443/";
				
				assertTrue(click(driver,btnNexiaLogo),"Click not Nexia Logo failed", driver, className,methodName);
				waitForPageLoad(driver);
				if(isElementPresent(driver, btnErrorClose))
					assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
					waitForPageLoad(driver);
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat;
				DateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = DateFormat.format(cal.getTime());
				String genrateUrl = webSite + "AdminConsole/generateStatements?today="+date+"";
			
				//Store the current window handle
			
				String winHandleBefore = driver.getWindowHandle();
				
				//Switch to new window opened
				
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
				
				for(String winHandle : driver.getWindowHandles()){

					driver.switchTo().window(winHandle);
					// Perform the actions on new window
					driver.get(genrateUrl);
				}
				
				//Switch back to original browser (first window)
			
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		    	driver.switchTo().window(winHandleBefore);

				waitForPageLoad(driver);
				waitForPageLoad(driver);
		    	return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			}
		
		/**navigateToBillingHistory
		 * function to navigateToBillingHistory 
		 * @param driver
	         * @param patientID(Patient ID to be searched)
		 * * @throws IOException
		 * @since Dec 22, 2014
	 */

			public BillingHistoryPage navigateToBillingHistory(WebDriver driver, String patientData) throws IOException {
				
				try {
					// Navigate to  Patient
					
					if(isElementPresent(driver, btnErrorClose))
					assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
					waitForPageLoad(driver);
					assertTrue(type(driver, txtPatientBox, patientData),"Could not type patient last name", driver, className,methodName);
					waitForPageLoad(driver);
					//assertTrue(click(driver, txtPatientBox),"Could not type patient last name", driver, className,methodName);
	                	
					//driver.click("searchPatientBox");
				
					waitForElement(driver, lblPatientResult, 10000);
					assertTrue(isElementPresent(driver,lblPatientResult),"Search Results are not displayed for the patient with ID :-"+ patientData, driver, className,methodName);
					waitForPageLoad(driver);
					
					mouseOver(lblPatientResultMousehover);
					waitForPageLoad(driver);
					
					assertTrue(click(driver,lnkBillingHistory),"Could not Billing History link", driver,className, methodName);
					waitForPageLoad(driver);
					
					if(isElementPresent(driver, btnErrorClose))
					assertTrue(click(driver, btnErrorClose),"could not click error close",driver, className, methodName);

				} catch (RuntimeException e) {
					e.printStackTrace();
				
				}
				return new BillingHistoryPage();
			}
			

			public CalendarPage navigateToCalendar(WebDriver driver)
			{
				assertTrue(click(driver,lnkQuickActions),"Unable to click the quick actions",driver,className,methodName);
				assertTrue(click(driver,lnkCalendar),"Unable to click the calendar link",driver,className,methodName);
				waitForPageLoad(driver);
				return new CalendarPage();
			}
			
			/**
			
			 * Function go To Statement Preferences
			 * @param 	selenium
			 * @since Dec 22, 2014
			 */
			
			public BillingSettingsPage goToBillingSettingsPage(WebDriver driver) {
				
				try {
					assertTrue(click(driver, lnkSettings), "could not click Settings Link",driver,className,methodName);
					waitForPageLoad(driver);
					assertTrue(click(driver, lnkBillingSettings),"could not click Billing Settings", driver,className,methodName);
					waitForPageLoad(driver);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
				return new BillingSettingsPage ();
			}
			
			/**
			 * Select different practice for encounter structure template 
			 * @param 	selenium
			 * @throws IOException 
			 * @since	DEC 25,2014
			 */
		 public boolean selectPractice(WebDriver driver) throws IOException, ExceptionHandler  {
		    	waitForPageLoad(driver);
		    	waitForPageLoad(driver);
		    	waitForPageLoad(driver);
		    	if(!getText(driver,lnkLocationMenuHeader).contains("Encounter")){
		    		assertTrue(click(driver,lnkLocationMenuHeader),"Could not click on practices link:", driver, className, methodName);
		    		waitForPageLoad(driver);
		    	 int count;
		    	 		for(count=1;count<=3;count++)		{
		    	 By position = By.id("xpath=(//a[contains(@id,'practice')])["+count+"]");	    			 
		    			if(getText(driver,position).contains("Encounter Structure Template")){
		    				assertTrue(click(driver,position),"Could not click on practices link:", driver, className, methodName);
		    				waitForPageLoad(driver);
		    				break;
		    			}
		    		}		
		    	}		
		    	return true;
		    }
			/**
			 * searchPatientForTestingtester
			 * function for Searching a patient in the Nexia application for Testingtester  
			 * @param 		driver
			 * @param 		patientID (Patient ID to be searched)
			 * @throws IOException 
			 * @throws ExceptionHandler 
		     * @Version 2.1
			 * @since  	    Dec 26, 2014
			 */
			public PatientChartPage searchPatientForTestingtester(WebDriver driver,String patientID) throws ExceptionHandler, IOException{
			try{
				waitForPageLoad(driver);
				assertTrue(type(driver,txtPatientBox,patientID),"Could not type patient id", driver, className,methodName);
				
				//click(driver,txtPatientBox);
				
				//driver.keyPress(txtPatientBox, "\\9");
				waitForElement(driver,lblPatientResult,30000);
				assertTrue(isElementPresent(driver,lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patientID, driver, className,methodName);
				waitForPageLoad(driver);
				
				assertTrue(getText(driver,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))),"could not get patient id", driver, className,methodName);
				//Assert.assertTrue(getText(driverlblPatientResult).contains(patientID));
				waitForPageLoad(driver);
				click(driver,lblPatientResult);
				waitForPageLoad(driver);
				assertTrue(isElementPresent(driver,lblPatientName),"The searched patient information could not be loaded", driver, className,methodName);
				if(isElementPresent(driver,lnkPatientSelect)){
					assertTrue(click(driver,lnkPatientSelect),"Could not select the patient ", driver, className,methodName);
				}
				if(isElementPresent(driver,lnkContinue)){
					click(driver,lnkContinue);
				}
				if(isElementPresent(driver, btnErrorClose))

					assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
			}catch(RuntimeException e) {
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientID.toString());
			}
				return  new PatientChartPage();		
			}
			
			


	/**
			 * clickNexiaLogo
			 * function to click Nexia Logo  
			 * @param 		driver
			 * @param 		patientID (Patient ID to be searched)
			 * @return 
			 * @throws IOException btnBack
			 
			 * @since  	    Dec 26, 2014
			 */
			public boolean clickNexiaLogo(WebDriver driver){
				assertTrue(click(driver,btnNexiaLogo),"Could not click the nexia logo", driver, className,methodName);
				waitForPageLoad(driver);
				if(isElementPresent(driver, btnErrorClose))
					assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
							return true;
			}

			
			/**
			 * clickBackButton
			 * function to click Back Button  
			 * @param 		driver
			 * @throws IOException 
			 * @since  	    Mar 18, 2015
			 */
			public boolean clickBackButton(WebDriver driver){
				assertTrue(click(driver,btnBack),"Could not click the Back button", driver, className,methodName);
				waitForPageLoad(driver);
				if(isElementPresent(driver, btnErrorClose))
					assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
							return true;
			}
			
			
			/**
			 * selectAutomationPractice
			 * function to select Automation Practice  
			 * @param 		driver
			 * @param 		patientID (Patient ID to be searched)
			 * @throws IOException 
			 * @throws ExceptionHandler 
			 
			 * @since  	    Dec 26, 2014
			 */
		    public boolean selectAutomationPractice(WebDriver driver) throws IOException, ExceptionHandler
		    {

		    	if(!getText(driver,lnkLocationMenuHeader).contains("Automation")){
		    		assertTrue(click(driver,lnkLocationMenuHeader),"Could not click on practices link:", driver, className, methodName);
		    		waitForPageLoad(driver);
		    	 int Count;
		    		int Count1=(Integer) getXpathCount(driver,lbl);
		    		for(Count=1;Count<=Count1;Count++)		{
		    			if(getText(driver,By.xpath("//tr["+Count+"]/td/a/span")).contains("Automation Nexia Clinic")){
		    				
		    				assertTrue(click(driver,By.xpath("//tr["+Count+"]/td/a/span")),"Could not click on practices link:", driver, className, methodName);
		    				waitForPageLoad(driver);
		    			}
		    		}		
		    	}		
		    	return true;
		    }
		    /**
			 * NavigateToClinicalSettings1
			 * Function to Navigate To ClinicalSettings1
			 * @param 	driver
			 * @version 2.1
			 * @since	Jan 27,2015
			 */
		    public ClinicalSettingPage navigateToClinicalSettings(WebDriver driver)
			{
		    try{
			assertTrue(click(driver, lnkSettings), "Could not click on Quick Actions button", driver, className, methodName);
			assertTrue(click(driver, lnkClinicalSettingsLink), "Could not click on Clinical settings", driver, className, methodName);
			}catch (Exception e) {
				  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		    }
			return new ClinicalSettingPage();
			}
		
			/**
			 * NavigateToClinicalSettings1
			 * Function to Navigate To ClinicalSettings1
			 * @param 	driver
			 * @since	Jan 27,2015
			 */
		    
		    public ClinicalSettingPage navigateToClinicalSettings1(WebDriver driver)
			{
			assertTrue(click(driver, lnkSettings), "Could not click on Settings link", driver, className, methodName);
			assertTrue(click(driver, lnkClinicalSettingsLink), "Could not click on Clinical settings", driver, className, methodName);
			return new ClinicalSettingPage();
			}
		    
		    
			/**
			 * LogoutofApplication
			 * Function to logoutofApplication
			 * @param 	selenium
			 * @since	Sep 03,2013
			 */
			
			public boolean logoutofApplication(WebDriver driver){
				
				waitForPageLoad(driver);
				if(click(driver, lnkTopMenu)){
				    if(!isElementPresent(driver,lnkSignout)){
					click(driver,lnkTopMenu);
				    }
					if(click(driver, lnkSignout)){
						// increment the possition value after sign out
						if(isElementPresent(driver,btnYes)){
							click(driver,btnYes);
						}else if(isElementPresent(driver,lnkBtnContinue)){
							click(driver,lnkBtnContinue);
							if(isElementPresent(driver,btnYes)){
								click(driver,btnYes);
							}else{
								click(driver,lnkBtnYes);
							}
						}else if(isElementPresent(driver,lnkContinuelogout)){
							click(driver,lnkContinuelogout);
							if(isElementPresent(driver,btnYes)){
								click(driver,btnYes);
							}else{
								click(driver,lnkBtnYes);
							}
						}else if(isElementPresent(driver,btnYesbutton)){
							click(driver,btnYesbutton);
						}
						
						else{
							click(driver,lnkBtnYes);
						}
						
					}
				}

			return true;	
			
			}
			/**
			 * getProviderName
			 * function to get ProviderName
			 * @param 		driver
			 * @since  	    Jan 09, 2015
			 * @version     2.1
			 */
			public boolean getProviderName (WebDriver driver,ClinicalSettingLib encounterTemplateTestData) throws ExceptionHandler, IOException
			{
				String providerNameTemp= getText(driver, lnkTopMenu);
				String providerName= providerNameTemp.replaceAll(", FULL", "");
				encounterTemplateTestData.provider = providerName;
				return true;
			}
			/**
			 * clickUnsignedEncounterQueue
			 * function to click Unsigned Encounter Queue
			 * @param 		driver
			 * @since  	    Jan 09, 2015
			 * @version     2.1
			 */
			public boolean clickUnsignedEncounterQueue(WebDriver driver){
				assertTrue(click(driver,lnkUnsignedEncounterQueue),"Could not click the nexia logo", driver, className,methodName);
				waitForPageLoad(driver);
				return true;
			}
			
			
			/**
			 * verifyUnsignedEncounterListItem
			 * function to click verify Unsigned Encounter in Queue
			 * @param 		driver
			 * @since  	    Jan 09, 2015
			 * @version     2.1
			 */
			public boolean isUnsignedEncounterListPresent(){
				try {
					isElementPresent(lblUnsignedEncounterListItem);
					waitForPageLoad(driver);
				} catch (Exception e) {
					new ExceptionHandler(e, driver, e.getMessage());
				}
				
				return true;
			}
			/**
			 * verifyUnsignedEncounterListItem
			 * function to click verify Unsigned Encounter in Queue
			 * @param 		driver
			 * @since  	    Jan 09, 2015
			 * @version     2.1
			 */
			public PatientChartPage selectEncounterListItem(String listNum){
				try {
					By listItem=By.xpath(String.format(lblUnsignedEncounterList, listNum));
					click(listItem);
					waitForPageLoad(driver);
					waitForPageLoad(driver);
					return new PatientChartPage();
				} catch (Exception e) {
					new ExceptionHandler(e, driver, e.getMessage());
				}
				return null;
			}
			/**
			 * searchUnsignedEncounter
			 * function to search Unsigned Encounter in Queue with search key word
			 * @param 		driver
			 * @since  	    Jan 09, 2015
			 * @version     2.1
			 */
			public boolean searchUnsignedEncounter(WebDriver driver, String searchKeyWord, String show){
				try {
					type(driver,txtSearchUnsignedEncounter, searchKeyWord);
					driver.findElement(txtSearchUnsignedEncounter).sendKeys(Keys.ENTER);
					waitForPageLoad(driver);
					selectValueFromAjaxList(driver, ajxShow, show);
				} catch (Exception e) {
					new ExceptionHandler(e, driver, e.getMessage());
				}
				
				return true;
			}

			public HomePage navigateToHomePage(WebDriver driver)
			{
				assertTrue(click(driver,btnNexiaLogo),"unable to click the nexia logo button",driver,className,methodName);
				waitForPageLoad(driver);
				if(isElementPresent(driver,btnErrorClose))
				{
					assertTrue(click(driver,btnErrorClose),"unable to click the error ok button",driver,className,methodName);	
				}
				
				return new HomePage();
			}
			
			public ChartDisclosurePage navigatetochartdisclouser(WebDriver driver)
			{
				try{
					waitForPageLoad(driver);
					click(driver,lnkPatientOption);
					waitForPageLoad(driver);
					click(driver,lnkChartDisclosure);
					waitForPageLoad(driver);
					waitForPageLoad(driver);
				}
				catch(Exception e)
				{
					new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
				}
				return new ChartDisclosurePage();
				
			}

			/**
			 * verifyAlertNotPresent function to a verify Alert Not Present
			 * @since  	@since March 18, 2015
			 * @version 2.1
			 */

			public boolean verifyAlertNotPresent (WebDriver driver)
			{
				try{
				if(isAlertPresent(driver))
				{

					System.out.println("Alert is present");
					assertTrue(!isTextPresent(driver,"You are leaving a page with unsaved"),"Alert is present",driver,className,methodName);	

				}
				else
					return true;
				}
				catch (Exception e) {
					new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}

				return true;
			}
			
}



