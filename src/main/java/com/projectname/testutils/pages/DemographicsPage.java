package com.projectname.testutils.pages;

import com.projectname.testutils.seleniumutils.SeleniumWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;



public class DemographicsPage extends SeleniumWebDriver{

	
	public  DemographicsPage() {
        PageFactory.initElements(TestBaseClass.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	
	private static By readyLocator = By.id("!patientInfoView");
	private By lnkReferrals=By.id("!patientReferralList");
	private By lnkPatientOptions = By.linkText("Patient Options");
    private By patientChart = By.cssSelector("#patientOptionsChartView > span");
    private By btnEdit=By.id("editButton");
	private By payersLink=By.id("!patientPayersList");
	
	public PatientChartPage goToChart(WebDriver driver) throws Exception {
        try {

            assertTrue(click(driver, lnkPatientOptions),
					"Could not click Patient options", driver, className,
					methodName);
			waitForPageLoad(driver);
			assertTrue(click(driver, patientChart),
					"Could not click on Pateint chart", driver, className,
					methodName);
			waitForPageLoad(driver);
		} catch (RuntimeException e) {
			e.printStackTrace();
        }
        return new PatientChartPage();
}
	



public boolean verifyCancelButton(WebDriver driver)
{
	assertTrue(click(driver,btnEdit),"Unable to click the edit button",driver,className,methodName);
	waitForPageLoad(driver);
	PatientRegistationPage patientRegPage=new PatientRegistationPage();
	patientRegPage.verifyCancel(driver);
	return true;
}

public boolean deleteAllReferral(ReferralsPage referralsPage,WebDriver driver) throws Exception {
	referralsPage.deleteAllReferral(driver);
	return true;
}

public boolean createReferral(ReferralsPage referralsPage, WebDriver driver, HomeLib refData) throws Exception {
	referralsPage.createReferral(driver, refData);
	return true;
}
/**
 * clickAddReferral
 * function to click Add Referral Button
 * @param 	referralsPage- Page
 * @throws  Exception 
 * @since  	Dec 17, 2014
 * @version 2.1
 */
public void clickAddReferral(ReferralsPage referralsPage){
	referralsPage.clickAddReferral();
}

public ReferralsPage goToReferral(WebDriver driver) throws Exception {
    try {

        assertTrue(click(driver, lnkReferrals),
				"Could not click Patient options", driver, className,
				methodName);
		waitForPageLoad(driver);
	} catch (RuntimeException e) {
		e.printStackTrace();
    }
    return new ReferralsPage();
}

public boolean verifyDoNotDisturbStatusDemographicsPage(WebDriver driver)
{
	PatientPersonalInfoPage patientPersonalInfopage=new PatientPersonalInfoPage();
	patientPersonalInfopage.verifyDoNotDisturbStatusDemographicsPage(driver);
	return true;
}

public boolean verifyDoNotDisturbStatusOnAnthorPractice(WebDriver driver)
{
	PatientPersonalInfoPage patientPersonalInfopage=new PatientPersonalInfoPage();
	patientPersonalInfopage.verifyDoNotDisturbStatusOnAnthorPracticeDemographicsPage(driver);
	return true;
}


public boolean verifyCancelButtonOnPatientDemographicsPage(WebDriver driver)

{
	PatientPersonalInfoPage patientPersonalInfoPage=new PatientPersonalInfoPage();
	patientPersonalInfoPage.verifyCancelButtonOnPatientDemographicsPage(driver);
    return true;
}

/**
 * verifySchedulingInReferralSummary
 * function to verify scheduling details in Referral  summary
 * @param 	referralsPage- Page
 * @throws  Exception 
 * @since  	May 12, 2015
 * @version 2.1
 */
public boolean verifySchedulingInReferralSummary(ReferralsPage referralsPage, String authoNumber, String visitsScheduled,String visitsAllowed, String visitsUsed, String testCaseID){
	return referralsPage.verifySchedulingInReferralSummary(authoNumber, visitsScheduled, visitsAllowed, visitsUsed, testCaseID);	
}

/**
 * verifySchedulingInReferralSummary
 * function to verify details in Referral  summary
 * @param 	referralsPage- Page
 * @throws  Exception 
 * @since  	May 12, 2015
 * @version 2.1
 */
public boolean verifyReferralSummary(ReferralsPage referralsPage, String inOut, String providerPracticeBy,String providerPracticeTo, String Date){
	return referralsPage.verifyReferralSummary(inOut, providerPracticeBy,providerPracticeTo, Date);	
}

/**
 * navigateToRefferals
 * function to navigate To Referrals
 * @ 	referralsPage- Page
 * @throws  Exception 
 * @since  	May 08, 2015
 * @version 2.1
 */
public ReferralsPage navigateToRefferals(WebDriver driver) {
	assertTrue(click(driver, lnkReferrals),
			"unable to click the referrals", driver, className, methodName);
	waitForPageLoad(driver);
	return new ReferralsPage();
}

public String getPatientId(PatientPersonalInfoPage patientPersonalInfoPage,WebDriver driver)throws Exception
{
String patientId=patientPersonalInfoPage.getPatientId(driver);
	return patientId;
}

public PatientRegistationPage clickEditButtonOnPatientInfoPage(WebDriver driver){
	PatientPersonalInfoPage patientPersonalInfoPage=new PatientPersonalInfoPage();
	PatientRegistationPage patientRegistationPage=patientPersonalInfoPage.clickEditButton(driver);
	return patientRegistationPage;
}

     /**
     * goToPayers
	 * Function to navigate to Payers
	 * @param 	driver
	 * @param   encounterTemplateTestData
  	 * @throws Exception 
	 * @since	May 12,2015
	 * @Version 2.1
	 */
public PatientPayersPage navigateToPayersPage(WebDriver driver) throws Exception {
    try {
        assertTrue(click(driver, payersLink),
				"Could not click Patient options", driver, className,
				methodName);
		waitForPageLoad(driver);
	} catch (RuntimeException e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
    }
    return new PatientPayersPage();
}



/**
* clickAddNewMedicalPayers
* Function to navigate to Payers
* @param 	driver
* @param   encounterTemplateTestData
	 * @throws Exception 
* @since	May 12,2015
* @Version 2.1
*/
public boolean clickAddNewMedicalPayers(WebDriver driver,PatientPayersPage patientPayersPage) throws Exception {
try {
	patientPayersPage.clickAddNewMedicalPayers(driver);
} catch (RuntimeException e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
}
return true;
}



/**
* clickAddNewMedicalPayers
* Function to navigate to Payers
* @param 	driver
* @param   encounterTemplateTestData
	 * @throws Exception 
* @since	May 12,2015
* @Version 2.1
*/
public boolean addNewMedicalPayerWithMandatoryFields(WebDriver driver,PatientPayersPage patientPayersPage,HomeLib payerData) throws Exception {
try {
	patientPayersPage.addNewMedicalPayerWithMandatoryFields(driver,payerData);
} catch (RuntimeException e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
}
return true;
}


/**
* saveMedicalPayer
* Function to save the created to Payers
* @param 	driver
* @param   encounterTemplateTestData
	 * @throws Exception 
* @since	May 12,2015
* @Version 2.1
*/
public boolean saveMedicalPayer(WebDriver driver,PatientPayersPage patientPayersPage) throws Exception {
try {
	patientPayersPage.saveMedicalPayer(driver);
} catch (RuntimeException e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
}
return true;
}

/**
 * verifyReferralDetails
 * function to verify Referral Details
 * @param driver,referralsPage,referralData,date
 * @since  	May 12, 2015
 */	
public boolean verifyReferralDetails(WebDriver driver,ReferralsPage referralsPage, ChartPreVisitLib referralData,String date) throws Exception {
    try {

    	referralsPage.verifyReferralDetails(driver,referralData,date);
      	waitForPageLoad(driver);
	} catch (RuntimeException e) {
		e.printStackTrace();
    }
    return true;
}



}
