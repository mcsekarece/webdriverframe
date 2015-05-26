package com.projectname.testutils.pages;


import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.Constants;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.genericutility.testDataLib.SystemSettingsLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;



public class PatientChartPage extends SeleniumWebDriver{
	private ProblemListPage problemListPage;
	private EncounterPage encounterPage;
	private LabOrderPage labOrderPage;	
	private MedicationsPage medicationsPage;	
	private VitalsPage vitalsPage;	
	private SocialHistoryPage socialHistoryPage;	
	private InjectionPage injectionPage;
	private ChartDisclosurePage chartDisclosurePage;
	private ReferralLetterPage referralLetterPage;
	private FamilyHistoryPage familyHistoryPage;
	private static By readyLocator = By.id("!chartEncounters");
	private By lnkencounterTab = By.id("!chartEncounters");
	private By lnkencounterTabSave = By.xpath("//div[contains(@id,'pendingCell')]");
	private By lnkPatientSummary=By.id("!chartSummary");
	private By btnBeginEncounter = By.id("BeginEncounterButton");
	private By lnkToManagedCare=By.xpath("//a[2]/span");
	private By lnkMore=By.linkText("More");
	private By inkUnSignedEnCounterAction=By.xpath("//div[2]/div/div[2]/table/tbody/tr[1]/td[2]/div/div");
	private By txtdeleteReason = By.id("deleteReason");
	private By contentPanel=By.id("contentPanel");
	private By lnkPreviousencounter=By.xpath("//td/div/div/table/tbody/tr");
	private By lnkTimeLine = By.id("!chartTimeline");
	private By lblTimelineEncounter = By.id("headerHtmlPanel");
	private By lblPendingEncounter = By.xpath("//div[contains(@id,'pendingCell')]");
	private By lblPendingEncounter2 = By.xpath("(//div[contains(@id,'pendingCell')])[2]");
	private By lnkProblemList = By.id("ProblemListTitle");
	private By lnkShowMarkup = By.xpath("//div[@id='actionList']/div");
	private By lnkAllergy =  By.id("AllergiesTitle");
	private By lnkProcedure =  By.id("MedicalandSurgicalHistoryTitle");
	private By lnkActionFirst=By.xpath("(//*[contains(@id,'action')])[1]");
	private By btnActionSignedEncounter = By.xpath("//div[@id='EncountersSignedList']/table/tbody/tr/td[2]/div/div/div/div/div");
	private By contentPanel1=By.xpath("xpath=(//div[@id='headerHtmlPanel'])[2]");
	private By btnActionSignedEn3=By.xpath("(//div[contains(@id,'action')])[3]");
	private By lnkLab = By.id("!chartLabReportsFlowSheet");
	private By lnkSearchForOLISReports = By.linkText("Search for OLIS reports");
	private By lnkMoreEncounterPendingList=By.id("EncountersPendingListMoreLink");
	private By lblSignedBy= By.id("signedBy");
	private By lblTimelineEncounter1=By.xpath("(//div[@id='headerHtmlPanel'])[2]");
	private String btnActionsSignedEncounter= "//div[@id='EncountersSignedList']//div[contains(@class,'actions-pick-list noPrint')][%s]";
	private By lnkDeleteEncounter=By.xpath("//div[contains(@id,'encounterDelete')]");
	private By lnkEncounterPendingList= By.id("EncountersPendingList");
	private By lnkExpandAll=By.linkText("Expand all");
    private By showMarkUp2=By.id("itemWrapper1");
    private By showMarkUp1=By.id("itemWrapper2");
    private By lnkInjection = By.id("InjectionsTitle");
	private By btnSignedActiontwo=By.xpath("(//div[contains(@id,'action')])[2]");
	private By btnSignedEdit=By.xpath("//div[contains(@id,'encounterEdit')]");
	private By lnkEncounterProblemlist=By.xpath("(//a[contains(text(),'Problem List')])[2]");
	private By   lnkShowMore = By.id("EncountersPendingListMoreLink");
	private By   lnkDeleteReason = By.xpath("//button[contains(@id,'deleteReason')]");
	private By lnkSummary = By.id("!chartSummary");
	private By btnAdd = By.id("add");
	private By btnProblemListCollapse = By.xpath("//a[contains(@id,'problemsExpandAnchor_')]");
	private By btnImmunizationCollapse = By.xpath("//a[contains(@id,'immunizationExpandAnchor_')]");
	private By lnkProblemListShowMoreArrow = By.id("medicationsMoreDetails");
	private By lbluserLabel1=By.id("user1");
	private By lbluserLabel2=By.id("user2");
	private By lbluserLabel3=By.id("user3");
	private By lbluserLabel4=By.id("user4");
	private By lblSummaryAllergy=By.xpath("//a[contains(text(),'Allergies')]");
	private By lnksummaryProblemlist=By.xpath("//a[contains(text(),'Problem List')]");
	private By lblSecondSignedEncounter=By.xpath("(//div[contains(@id,'collapsableTitle')])[2]");
	private By lnkVersion = By.id("user");
	private By lnkPatientOptions = By.linkText("Patient Options");
	private By lnkChartDisclosure = By.xpath("//a[@id='chartDisclosureRequestView']/span");
	private By lnkFileNewReport = By.id("patientOptionsManualEntry");
	private By lnkListView =By.id("ListViewTab");
	private By lblReport = By.xpath("//span[@id='unsignedLabdescription1']/b");
	private By lnkBillingHistory = By.id("patientOptionsBillingSummary");
	private By lnkVitals = By.linkText("VITALS");
	private By lnkMedication = By.id("MedicationTitle");
	private By lnkImmunization = By.id("ImmunizationsTitle");
    private By injectionArrowExpand=By.xpath("//a[contains(@id,'injectionExpandAnchor_')]");
private By lnkMedicationsSummaryPage = By.id("MedicationTitle");

private By patientViewReg = By.cssSelector("#patientOptionsRegistration > span");
private By lnkFamilyHistory = By.id("FamilyHistoryTitle");
private By lnkFamilyHistoryCollapse = By.xpath("//a[contains(@id,'familyHistoryExpandAnchor_')]");

private By lnkSocialHistoryTittle = By.id("SocialHistoryTitle");
private By lnkMoreDetails = By.id("medicationsMoreDetails");

private By lnkSocialHistoryExpandArrow = By.xpath("(//a[contains(@Id,'socialHistoryExpandAnchor')])");
private By lnkProcedureCollapse = By.xpath("//a[contains(@id,'procedureExpandAnchor_')]");
	/***
	 * Call to super constructor
	 */
	public PatientChartPage(){
		PageFactory.initElements(TestBaseClass.driver,this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
		
	}
	/**
	 * clickSavedEncounter
	 * function to click the saved Encounter from encounter tab
	 * param driver
	 * @since  	March 16, 2015
	 * @version 2.1
	 */	
	public boolean clickSavedEncounter(WebDriver driver)
	{
		try{
			verifyTrue(click(driver,lnkencounterTabSave),"Could not click the encounter tab", driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
		}catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "","", "fail", "", getCallingMethodAndLineNumber()) );
		} 
		return true;
	}

	/**
	 * fileReportWithMandatory function to file Report With Mandatory
	 * @throws IOException 
	 * @throws ExceptionHandler 
	 * 
	 * @since Mar 20, 2015
	 */
	public boolean fileReportWithMandatory(WebDriver driver, ChartPreVisitLib labData, String account,FileNewReportPage fileNewReportPage) throws IOException, ExceptionHandler {
		
		fileNewReportPage.fileReportWithMandatory(driver, labData, account);
		return true;
	}
	
	/**
	 * clickEncounterTab
	 * function to click the Encounter Tab
	 * param driver
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */	
	public boolean clickEncounterTab(WebDriver driver)
	{
		try{
			waitForPageLoad(driver);
			verifyTrue(click(driver,lnkencounterTab),"Could not click the encounter tab", driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
		}catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "","", "fail", "", getCallingMethodAndLineNumber()) );
		} 
		return true;
	}
	/**
	 * goToEncounterProblemList
	 * Function to Navigate To Encounter ProblemList
	 * @param 	driver
	 * @throws Exception 
	 * @since	Mar 23,2015
	 * @version 2.1
	 */  
	public void verifyAlertProblemListItemDeleted(WebDriver driver,EncounterPage encounterPage)
	{
		try {
		encounterPage.verifyAlertProblemListItemDeleted(driver);
		}catch (Exception e) {
			  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	    }
}
	 
	/**
	/**
	 * saveAddedSummaryMedications
	 * Function to Save Added summary Medications
	 * @param 	driver
	 * @param  medicationsPage
	 * @since  	Mar 24, 2015
	 * @version 2.1
	 */	

	public void saveAddedSummaryMedications(WebDriver driver,MedicationsPage medicationsPage){
	try{
		medicationsPage.saveAddedSummaryMedications(driver);
	   }catch (Exception e) {
			  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		    }
	}
	
	/**
	 * goToSummaryVitals
	 * function to click the Vitals link
	 * param driver
	 * @since  	Mar 24, 2015
	 * @version 2.1
	 */	
	public VitalsPage goToSummaryVitals(WebDriver driver)
	{
		try{
			verifyTrue(click(driver,lnkVitals),"Could not click the Vitals link", driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
		}catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "","", "fail", "", getCallingMethodAndLineNumber()) );
		} 
		return new VitalsPage();
	}

	/**
	 * navigateToReferralLetterPage function to navigate to Referral Letter Page
	 * @param driver
	 * @param encounterPage
	 * @since  	@since April 27, 2015
	 * @version 2.1
	 */

	public ReferralLetterPage navigateToReferralLetterPage(WebDriver driver, EncounterPage encounterPage) throws IOException {
	try{
		
		referralLetterPage= encounterPage.navigateToReferralLetterPage(driver);
		waitForPageLoad(driver);

	} catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	}

		return referralLetterPage;
	}
	
	/**
	 * verifyMultipleProviderNamesInReferralSuggestBox function to verify Multiple Provider Names In Referral SuggestBox
	 * @param driver
	 * @param ChartPreVisitLib - referralData
	 * @param referralLetterPage
	 * @param encounterPage
	 * @since  	@since April 27, 2015
	 * @version 2.1
	 */
	
	public boolean verifyMultipleProviderNamesInReferralSuggestBox(WebDriver driver, SystemSettingsLib providerData, String provdata, int count, ReferralLetterPage referralLetterPage, EncounterPage encounterPage) throws IOException {

		try{
			encounterPage.verifyMultipleProviderNamesInReferralSuggestBox(driver, providerData, provdata, count, referralLetterPage);
			waitForPageLoad(driver);

		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}
	
		return true;
	}	

	/**
	 * verifyPracticeInReferralSuggestBox function to verify Practice Name In Referral SuggestBox
	 * @param driver
	 * @param ChartPreVisitLib - referralData
	 * @param referralLetterPage
	 * @param encounterPage
	 * @since  	@since April 27, 2015
	 * @version 2.1
	 */
	
	public boolean verifyPracticeInReferralSuggestBox(WebDriver driver, SystemSettingsLib pracData, SystemSettingsLib providerData, ReferralLetterPage referralLetterPage, EncounterPage encounterPage) throws IOException {

		try{
			encounterPage.verifyPracticeInReferralSuggestBox(driver,pracData, providerData, referralLetterPage);
			waitForPageLoad(driver);

		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}
	
		return true;
	}	

	/**
	 * verifyHeadIconInSearch function to verify HeadIcon In Search Referral SuggestBox
	 * @param driver
	 * @param ChartPreVisitLib - referralData
	 * @param SystemSettingsLib - providerData
	 * @param referralLetterPage
	 * @param encounterPage
	 * @since  	@since April 29, 2015
	 * @version 2.1
	 */
	
	public boolean verifyHeadIconInSearch(WebDriver driver, ChartPreVisitLib referralData, ReferralLetterPage referralLetterPage, EncounterPage encounterPage) throws IOException {

		try{
			encounterPage.verifyHeadIconInSearch(driver, referralData, referralLetterPage);
			waitForPageLoad(driver);
		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}
	
		return true;
	}	

	/**
	 * verifyLetterContents function to verify Letter Contents in Referral Letter Page
	 * @param driver
	 * @param referralLetterPage
	 * @param encounterPage
	 * @param ChartPreVisitLib - referralData
	 * @param String - defaultTemplateName
	 * @since  	@since April 28, 2015
	 * @version 2.1
	 */

	public boolean verifyLetterContents(WebDriver driver, ChartPreVisitLib referralData, String defaultTemplateName, ReferralLetterPage referralLetterPage, EncounterPage encounterPage) throws IOException {
	try{
		encounterPage.verifyLetterContents(driver, referralData, defaultTemplateName, referralLetterPage);
		waitForPageLoad(driver);

	} catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	}
		return true;
	}

	/**
	 * goToSummaryMedication
	 * function to click the Medication link
	 * param driver
	 * @since  	Mar 24, 2015
	 * @version 2.1
	 */	
	public MedicationsPage goToSummaryMedication(WebDriver driver)
	{
		try{
			verifyTrue(click(driver,lnkMedication),"Could not click the Medication link", driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
		}catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "","", "fail", "", getCallingMethodAndLineNumber()) );
		} 
		return new MedicationsPage();
	}

	
	/**
	 * goToSummaryImmunization
	 * function to click the Immunization link
	 * param driver
	 * @since  	Mar 24, 2015
	 * @version 2.1
	 */	
	public ImmunizationPage goToSummaryImmunization(WebDriver driver)
	{
		try{
			verifyTrue(click(driver,lnkImmunization),"Could not click the Immunization link", driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
		}catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "","", "fail", "", getCallingMethodAndLineNumber()) );
		} 
		return new ImmunizationPage();
	}

	/**
	 * createImmunization function to a  create Immunization
	 * @param 	ChartPreVisitLib- Data for Immunization, Account
 	 * @param 	immunizationPage
	 * @since  	@since March 24, 2015
	 * @version 2.1
	 */

	public boolean createImmunization(WebDriver driver,
			ChartPreVisitLib immunizationData, String account,ImmunizationPage immunizationPage) throws IOException, ExceptionHandler {
    try{
		immunizationPage.createImmunization(driver, immunizationData, account);
		
	}catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
    }return true;
	}
	/**
	 * goToChartDisclosure
	 * function to  go To ChartDisclosure
	 * param driver
	 * @since  	Mar 20, 2015
	 * @version 2.1
	 */	
	public ChartDisclosurePage goToChartDisclosure(WebDriver driver)
	{
		verifyTrue(click(driver,lnkPatientOptions),"Could not click the Patient Options link", driver);
		waitForPageLoad(driver);
		verifyTrue(click(driver,lnkChartDisclosure),"Could not click the Chart Disclosure link", driver);
		waitForPageLoad(driver);

		return new ChartDisclosurePage();
	}
	
	/**
	 * goToFileNewReport
	 * function to  go To File New Report
	 * param driver
	 * @since  	Mar 20, 2015
	 * @version 2.1
	 */	
	public FileNewReportPage goToFileNewReport (WebDriver driver)
	{
		verifyTrue(click(driver,lnkPatientOptions),"Could not click the Patient Options link", driver);
		waitForPageLoad(driver);
		verifyTrue(click(driver,lnkFileNewReport),"Could not click the File New Report link", driver);
		waitForPageLoad(driver);

		return new FileNewReportPage();
	}
	
	/**
	 * clickListView function to click ListView
	 * @throws IOException 
	 * @throws ExceptionHandler 
	 * 
	 * @since Mar 20, 2015
	 */
	public boolean clickListView(WebDriver driver) throws IOException, ExceptionHandler {

		verifyTrue(click(driver,lnkListView),"Could not click the Patient Options link", driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		return true;
	}

		/**
		 * clickOnReport
		 * function to  click On Report
		 * param driver
		 * @since  	Mar 20, 2015
		 * @version 2.1
		 */	
		public FileNewReportPage clickOnReport (WebDriver driver)
		{
			verifyTrue(click(driver,lblReport),"Could not click the lblReport", driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);

			return new FileNewReportPage();
		}

		
	/**
	 * saveFileReport function to save file Report With Mandatory
	 * @throws IOException 
	 * @throws ExceptionHandler 
	 * param driver, fileNewReportPage
	 * @since Mar 20, 2015
	 */
	public boolean saveFileReport(WebDriver driver, FileNewReportPage fileNewReportPage) throws IOException, ExceptionHandler {

		fileNewReportPage.saveFileReport(driver);
		return true;
	}

	/**
	 * goToAssignTask
	 * function to  go To Assign Task
	 * param driver
	 * param encounterPage
	 * @since  	Mar 20, 2015
	 * @version 2.1
	 */	
	public boolean goToAssignTask (WebDriver driver, EncounterPage encounterPage)
	{
		encounterPage.goToAssignTask(driver);
		waitForPageLoad(driver);
		return true;
	}

	/**
	 * Verify encounter date in encounter tab
	 * function to click the Encounter Tab
	 * param driver
 	 * @param 	ClinicalSettingLib- Data for verifying encounter values
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */	
	public boolean verifyencounterdate(WebDriver driver, ClinicalSettingLib encounterTemplateTestData)
	{
		waitForPageLoad(driver);
		return isTextPresent(driver,encounterTemplateTestData.encounterdateverfify);
	}
	/**
	 * clickbeginEncounter
	 * function to click the Begin Encounter Button
	 * @param driver
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */	
	public EncounterPage clickbeginEncounter(WebDriver driver)  {
		try{
		if (isElementPresent(driver, btnBeginEncounter)) {
			assertTrue(click(driver, btnBeginEncounter),"Could not click on Close Button",driver, className, methodName);
		}
			waitForPageLoad(driver);
		}catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}
		return new EncounterPage();
	}

    public ProcedurePage goToEncounterProcedure(WebDriver driver, EncounterPage encounterPage)
    {
    	encounterPage.goToEncounterProcedure(driver);
    	waitForPageLoad(driver);
    	return new ProcedurePage();
    	
    }

	public boolean recordWidgetsInEditedEncounterNote(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,String date, EncounterPage encounterPage) 

	{

	encounterPage.recordWidgetsInEditedEncounterNote(driver,encounterTemplateTestData,date);

	waitForPageLoad(driver);

	return true;

	}


	
	/**
	 * verifySuperBillPageNotPresent
	 * function to verify SuperBill Page Not Present page
	 * @param driver
	 * @param encounterPage- Page
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */	
	public boolean verifySuperBillPageNotPresent(WebDriver driver, EncounterPage encounterPage) 
	{
	try{
		encounterPage.verifySuperBillPageNotPresent(driver);
		waitForPageLoad(driver);
	} catch (Exception e)
	 {
		 assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

	 }
		return true;
	}
	
	/**
	 * verifyEncounterDetails
	 * function to verify Encounter Details after sign the encounter
	 * @param driver
	 * @param userAccount
	 * @since  May 18, 2015
	 * @version 2.1
	 */	
	public boolean verifyEncounterDetails(WebDriver driver,String account) 
	{
	try{
		String date = null;
		
		if (account.equals(Constants.CAACCOUNT)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MMM dd, yyyy");
			date = DateFormat.format(cal.getTime());
		} else {
			Calendar cal1 = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat.format(cal1.getTime());
		}
		
		assertTrue(isTextPresent(driver,date),"verify encounter  details failed",driver, className, methodName);
		
		waitForPageLoad(driver);
	} catch (Exception e)
	 {
		 assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

	 }
		return true;
	}
	
	
	
	
	
	/**
	 * beginEncounter
	 * function to enter mandatory fields of encounter page
	 * @param driver
	 * @param encounterPage- Page
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */	
	public boolean beginEncounter(WebDriver driver, EncounterPage encounterPage) 
	{
	try{
		encounterPage.beginEncounter(driver);
		waitForPageLoad(driver);
	} catch (Exception e)
	 {
		 assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

	 }
		return true;
	}
	
	
	
	
	
	
	/**
	 * beginEncounterReferral
	 * function to enter mandatory fields of encounter page
	 * @param driver
	 * @param encounterPage- Page
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */	
	public boolean beginEncounterReferral(WebDriver driver, EncounterPage encounterPage,ChartPreVisitLib referralData) 
	{
	try{
		encounterPage.beginEncounterReferral(driver,referralData);
		waitForPageLoad(driver);
	} catch (Exception e)
	 {
		 assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

	 }
		return true;
	}
	
	
	
	/**
	 * click previous encounter
	 * function to click previous encounter
	 * @throws Exception 
	 * @Version 2.1
	 * @since Nov 01, 2012
	 */
	public boolean clickPreviousencounter(WebDriver driver, EncounterPage encounterPage) 
	{
		assertTrue(click(driver, lnkPreviousencounter),"Could not click on PendingSignOffLabel button",driver, className, methodName);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		return true;
	}
	
	/**
	 * click first saved encounter
	 * function to click first saved encounter
	 * param driver
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */	
	
	public boolean clickPendingSignOffLabel(WebDriver driver) 
	{
		assertTrue(click(driver, lblPendingEncounter),"Could not click on PendingSignOffLabel button",driver, className, methodName);
		waitForPageLoad(driver);
		return true;
	}
	
	/**
	 *click Second saved encounter
	 * function to click Second saved encounter
	 * param driver
	 * @since  	Mar 13, 2015
	 * @version 2.1
	 */	
	
	public boolean clickSecondPendingSignOffLabel(WebDriver driver) 
	{
		waitForPageLoad(driver);
		assertTrue(click(driver, lblPendingEncounter2),"Could not click on PendingSignOffLabel button",driver, className, methodName);
		waitForPageLoad(driver);
		waitForPageLoad(driver);

		return true;
	}
	
	
	/**
	 * deleteAllEncounters
	 * function to delete all encounters
	 * @since  	Jan 08, 2015
	 * @version 2.1
	 */	
	
	public boolean deleteAllEncounters(WebDriver driver ) throws IOException{
        boolean medDeleted = true;
        inkUnSignedEnCounterAction =By.xpath("(//div[contains(@id,'action')])");
        try {
            while(isVisible(driver, lnkShowMore))

            {
              assertTrue(click(driver, lnkShowMore),"could not click on Show More", driver, className, methodName);
                  waitForPageLoad(driver);
            }
                        int count = 0;
                        count=(Integer) getXpathCount(driver,inkUnSignedEnCounterAction);
                        
                       while(count>0)
                        {
                              while(isVisible(driver, lnkShowMore))

                            {
                                    assertTrue(click(driver, lnkShowMore),"could not click on Show More", driver, className, methodName);
                                    waitForPageLoad(driver);
                            }
                              inkUnSignedEnCounterAction =By.xpath("(//div[contains(@id,'action')])"+"["+count+"]");

                                        if (isElementPresent(driver, inkUnSignedEnCounterAction)) {
                                                        assertTrue(click(driver, inkUnSignedEnCounterAction),
                                                                                        "Could not click on Actions button;More Details"
                                                                                        , driver, className, methodName);
                                                        waitForPageLoad(driver);
                                        
                                                        if(isElementPresent(driver,lnkDeleteEncounter))
                                                        {
                                                                        assertTrue(click(driver, lnkDeleteEncounter),
                                                                                                        "Could not click on delete button;More Details",
                                                                                                        driver, className, methodName);
                                                                        waitForPageLoad(driver);
                                                                        assertTrue(type(driver, txtdeleteReason, "Reason"),
                                                                                                        "Could not type reason ;More Details", 
                                                                                                        driver, className, methodName);
                                                                        waitForPageLoad(driver);
                                                                        assertTrue(click(driver, lnkDeleteReason),
                                                                                                        "Could not click on Delete button;More Details"
                                                                        		, driver, className, methodName);
                                                                        waitForPageLoad(driver);
                                                                        waitForPageLoad(driver);
                                                                        waitForPageLoad(driver);
                                                                        waitForPageLoad(driver);
                                                                        waitForPageLoad(driver);
                                                                        waitForPageLoad(driver);
                                                        }
                                                      
                                                     
                                                       
                                                        
                                                        }
                        
                                        count--;
                        }
                       waitForPageLoad(driver);
                       waitForPageLoad(driver);
                       waitForPageLoad(driver);
                       waitForPageLoad(driver);
        } catch (RuntimeException e) {
                        e.printStackTrace();
        }
        return medDeleted;

	}
	
	  public boolean VerifyDefaultTemplateInEncounterNote(WebDriver driver,ClinicalSettingLib encounterTemplateTestData, EncounterPage encounterPage)
	    {	
	    waitForPageLoad(driver);
		  encounterPage.VerifyDefaultTemplateInEncounterNote(driver, encounterTemplateTestData);
			
		  return true;
	    }
	   

	  public boolean verifyDeletedWidgetsInNote(WebDriver driver,ClinicalSettingLib encounterTemplateTestData, EncounterPage encounterPage)
	    {	waitForPageLoad(driver);
	    waitForPageLoad(driver);
		  encounterPage.verifyDeletedWidgetsInNote(driver, encounterTemplateTestData);
			
		  return true;
	    }
	  /**
		 * Record Values in all encounter Note widgets
		 * function to Record Values in all encounter Note widgets
		 * @param encounterPage- Page
		 * @since  	Jan 08, 2015
		 * @version 2.1
		 */
	  public boolean recordWidgetsInEncounterNote(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,String date, EncounterPage encounterPage) 
	  {
		  encounterPage.recordWidgetsInEncounterNote(driver,encounterTemplateTestData,date);
		//  waitForPageLoad(driver);
		  return true;
		  
	  }
	  /**
			 * Record Values in all encounter Note widgets
			 * function to Record Values in all encounter Note widgets
			 * @param encounterPage- Page
			 * @since  	Jan 08, 2015
			 * @version 2.1
			 */
	  public boolean recordValuesForWidgetsInEncounter(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,String date, EncounterPage encounterPage)  
	  {
		  encounterPage.recordValuesForWidgetsInEncounter(driver,encounterTemplateTestData,date);
		  waitForPageLoad(driver);
		  return true;
		  
	  }
	  /**
			 * Record Values in all encounter Note Edit Mode widgets
			 * function to Record Values in all encounter NoteEdit Mode widgets
			 * @param encounterPage- Page
			 * @since  	Jan 08, 2015
			 * @version 2.1
			 */
	  public boolean recordValuesForWidgetsInEncounterEdit(WebDriver driver,ClinicalSettingLib encounterTemplateTestData,String date, EncounterPage encounterPage)  
	  {
		  encounterPage.recordValuesForWidgetsInEditEncounter(driver,encounterTemplateTestData,date);
		  waitForPageLoad(driver);
		  return true;
		  
	  }
	  /**
		 * Record Values In All Encounter Note Deleted widgets
		 * function to Record Values In All Encounter Note Deleted widgets
		 * @param encounterPage- Page
		 * @since  	Jan 08, 2015
		 * @version 2.1
		 */
	  public boolean recordWidgetsDeletedWidgetEncounterNote(WebDriver driver, EncounterPage encounterPage) throws Exception
	  {
		  encounterPage.recordWidgetsDeletedWidgetEncounterNote(driver);
		  waitForPageLoad(driver);
		  return true;
		  
	  }
	  
	  /**
		 * saveEncounter
		 * function to save encounter
		 * @param driver
		 * @param encounterPage- Page, driver
		 * @since  	Jan 08, 2015
		 * @version 2.1
		 */	
	  public boolean saveEncounter (WebDriver driver, EncounterPage encounterPage)
	    {
		  try{
			  encounterPage.saveEncounter(driver);
			  waitForPageLoad(driver);
			  waitForPageLoad(driver);
			  waitForPageLoad(driver);
			  waitForPageLoad(driver);
		  }catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}      
		  return true;
	    }
	   public boolean VerifyEditedDefaultTemplateInEncounterNote(WebDriver driver,ClinicalSettingLib encounterTemplateTestData, EncounterPage encounterPage)
	    {
		   
		   waitForPageLoad(driver);
		   encounterPage.VerifyEditedDefaultTemplateInEncounterNote(driver, encounterTemplateTestData);
		 
		   return true;
	    }
	  
	   
	   public boolean VerifyEditedDefaultTemplateInPrevouusEncounterNote(WebDriver driver,ClinicalSettingLib encounterTemplateTestData, EncounterPage encounterPage){
	    	
		   encounterPage.VerifyEditedDefaultTemplateInPrevouusEncounterNote(driver, encounterTemplateTestData);
		   waitForPageLoad(driver);
		   return true;
	   }
	   
	   /**
		 * signEncounter
		 * function to sign encounter
		 * @param encounterPage- Page, driver
		 * @since  	Jan 08, 2015
		 * @version 2.1
		 */	
	    public boolean signEncounter(WebDriver driver, EncounterPage encounterPage)
	    {   waitForPageLoad(driver);
		   waitForPageLoad(driver);  
		   waitForPageLoad(driver);
		   waitForPageLoad(driver);
		   encounterPage.signEncounter(driver);
		   waitForPageLoad(driver);
		   waitForPageLoad(driver);
		   return true;
	    }

	    /**
		 * editEncounter
		 * function to edit encounter
		 * @since  	Jan 08, 2015
		 * @version 2.1
		 */	
public boolean editEncounter(WebDriver driver) throws Exception
	{
	assertTrue(click(driver, btnSignedActiontwo),"Could not click on PendingSignOffLabel button",driver, className, methodName);
	waitForPageLoad(driver);
	assertTrue(click(driver, btnSignedEdit),"Could not click on PendingSignOffLabel button",driver, className, methodName);
	waitForPageLoad(driver);
	return true;
	}



         public boolean verifyRecordedWidgetInTimeLineForManagedCare(WebDriver driver,ClinicalSettingLib mcTemplate) 
                {
        	 try{
        	   assertTrue(click(driver, lnkTimeLine),"Could not click the Time line tab", driver, className, methodName);	
		    	waitForPageLoad(driver);
		    	assertTrue(click(driver, lblTimelineEncounter),"Could not click the encounter in Timeline", driver, className, methodName);	
		    	waitForPageLoad(driver);
		    	assertTrue(getText(driver,contentPanel).contains(mcTemplate.condtionAge),"Unable to find the recorded value",driver,className,methodName);
        	 }
        	 catch (Exception e)
        	 {
        		 assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
 
        	 }
		    	return true;
                }
           
           public boolean verifyRecordedWidgetInTimeLineForEditedManagedCare(WebDriver driver,ClinicalSettingLib mcTemplate) 
           {
        	   try{
   	   assertTrue(click(driver, lnkTimeLine),"Could not click the Time line tab", driver, className, methodName);	
	    	waitForPageLoad(driver);
	    	assertTrue(click(driver, lblTimelineEncounter1),"Could not click the encounter in Timeline", driver, className, methodName);	
	    	waitForPageLoad(driver); 
	    	assertTrue(getText(driver,contentPanel1).contains(mcTemplate.condtionAge),"Unable to find the recorded value",driver,className,methodName);
	    	assertTrue(getText(driver,contentPanel1).contains(mcTemplate.conditionAgeIn),"Unable to find the recorded value",driver,className,methodName);
        	   }
        	   catch(Exception e)
        	   {
        		   assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);

        	   }
        	   return true;
           }
	   
	   public boolean verifyFirstRecordedWidgetInTimeLine(WebDriver driver,ClinicalSettingLib encounterTemplateTestData, EncounterPage encounterPage)
	   {
		   try
		   {
			   waitForPageLoad(driver); 
			   assertTrue(	isTextPresent(driver,encounterTemplateTestData.freeTextComment),"", driver, className, methodName);
			   assertTrue(	isTextPresent(driver,encounterTemplateTestData.numericWidgetValue),"", driver, className, methodName);
			   assertTrue(isTextPresent(driver,encounterTemplateTestData.numericWidgetComment),"", driver, className, methodName);
			   assertTrue(isTextPresent(driver,encounterTemplateTestData.Answer4),"", driver, className, methodName);
			   assertTrue(isTextPresent(driver,encounterTemplateTestData.fromDate),"", driver, className, methodName);
			   assertTrue(isTextPresent(driver,encounterTemplateTestData.toDate),"", driver, className, methodName);
			   assertTrue(isTextPresent(driver,encounterTemplateTestData.questionWidgetComment),"", driver, className, methodName);
			   assertTrue(isTextPresent(driver,encounterTemplateTestData.QuestionWidgetComment1),"", driver, className, methodName);
			   assertTrue(isTextPresent(driver,encounterTemplateTestData.dateComment),"", driver, className, methodName);
			   assertTrue(isTextPresent(driver,encounterTemplateTestData.Answer8),"", driver, className, methodName);
			   assertTrue(isTextPresent(driver,encounterTemplateTestData.Answer9),"", driver, className, methodName);
			   assertTrue(isTextPresent(driver,encounterTemplateTestData.answer12),"", driver, className, methodName);
			   assertTrue(isTextPresent(driver,encounterTemplateTestData.answer20),"Question widget answers in not present", driver, className, methodName);
			   assertTrue(isTextPresent(driver,encounterTemplateTestData.questionWidgetComment3),"", driver, className, methodName);
			   assertTrue(isTextPresent(driver,encounterTemplateTestData.questionWidgetComment4),"", driver, className, methodName);
			   assertTrue(isTextPresent(driver,encounterTemplateTestData.scorefieldone),"", driver, className, methodName);
			   assertTrue(isTextPresent(driver,encounterTemplateTestData.scorefieldtwo),"", driver, className, methodName);
			   assertTrue(isTextPresent(driver,encounterTemplateTestData.assessmenttextbox),"", driver, className, methodName);
				Thread.sleep(3000);
		   }
		   catch (Exception e)
		   {
			   new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		   }
	    	
	    	
		   return true;
	   }
	   
	   
	   public boolean verifySecondRecordedWidgetInTimeLine(WebDriver driver,ClinicalSettingLib encounterTemplateTestData, EncounterPage encounterPage)
	   {
		   try
		   {	
			   encounterPage.verifySecondRecordedWidgetInTimeLine(driver, encounterTemplateTestData); 
		   }
		   catch (Exception e)
		   {
			   new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		   }
	    	
	    	
		   return true;
	   }
	   
	   
	  public boolean clicktimelinedate(WebDriver driver)
	  {
		  try{
			  assertTrue(click(driver, lnkTimeLine),"Could not click the Time line tab", driver, className, methodName);	
		    	waitForPageLoad(driver);
		    	assertTrue(click(driver, lblTimelineEncounter),"Could not click the encounter in Timeline", driver, className, methodName);	
		  		    	waitForPageLoad(driver); 
		    	waitForPageLoad(driver); 
		  
		    	  }
		  catch(Exception e ){
			  
			  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		  }
		return true;
	  }
	   

	   public boolean verifyRecordedWidgetValuesInTimeLine(WebDriver driver,ClinicalSettingLib encounterTemplateTestData, EncounterPage encounterPage)
	   {
		   try
		   {
			  
		    	assertTrue(isTextPresent(driver,encounterTemplateTestData.freeTextComment),"freeTextComment is not present",driver, className, methodName);
		    	assertTrue(isTextPresent(driver,encounterTemplateTestData.numericWidgetValue),"numericWidgetValue is not present",driver, className, methodName);
		    	assertTrue(isTextPresent(driver,encounterTemplateTestData.questionWidgetAnswer1),"questionWidgetAnswer1 is not present",driver, className, methodName);
		    	assertTrue(isTextPresent(driver,encounterTemplateTestData.numericWidgetComment),"numericWidgetValue is not present",driver, className, methodName);
		    	assertTrue(isTextPresent(driver,"20"),"value is not present",driver, className, methodName);
		   }
		   catch (Exception e)
		   {
			   Assert.fail();
		   }
		   return true;
	   }
	   

	    /**
		 * Navigate to pending encounter and click first encounter
		 * Funtion ToNavigate to pending encounter and click first encounter
		 * @param driver
		 * @param encounterPage- Page
		 * @since  	Jan 08, 2015
		 * @version 2.1
		 */	
	    
	   public EncounterPage gotoPendingEncounters(WebDriver driver)
	   {
	    	assertTrue(click(driver, lnkencounterTab),"Could not click the Encounter tab", driver, className, methodName);	
	    	waitForPageLoad(driver); 
	    	assertTrue(click(driver, lblPendingEncounter),"Could not click the lblPendingEncounter", driver, className, methodName);	
	    	waitForPageLoad(driver); 
	       	waitForPageLoad(driver); 
	       	waitForPageLoad(driver); 
	    	return new EncounterPage();
	   }
	   /**
	 		 * Verify Cancelled Encounter
	 		 * function to go to problem list
	 		 * @since  	Jan 08, 2015
	 		 * @version 2.1
	 		 */	

	   public EncounterPage veifyCancelledEncounter(WebDriver driver)
	   {
		   waitForPageLoad(driver); 
	    	assertTrue(!isElementPresent(driver, lblPendingEncounter),"Cancelled encounter should not be in pending encounter list ", driver, className, methodName);
			return encounterPage;	
	    		
	   }
	   
	   /**
		 * goToProblemList
		 * function to go to problem list
		 * @param driver
		 * @since  	Jan 08, 2015
		 * @version 2.1
		 */		   
	   public ProblemListPage goToProblemList(WebDriver driver)
	    {
		   try{
		   click(lnkProblemList);
		   waitForPageLoad(driver);
		   }
			catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
		   return new ProblemListPage();
	    }
	   
	   /**
		 * goToSocialHistory
		 * function to go to Social History
		 * @param driver
		 * @since  May 21, 2015
		 * @version 2.1
		 */		   
	   public SocialHistoryPage goToSocialHistory(WebDriver driver)
	    {
		  try{
		    	verifyTrue(click(driver, lnkSocialHistoryTittle),"Could not click the Social History link", driver);	
		    	waitForPageLoad(driver);   
		   waitForPageLoad(driver);
		   }
			catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}
		   return new SocialHistoryPage();
	    }
	   
	   /**
		 * Cancel encounter
		 * function to Cancel encounter
		 * @since  	Jan 08, 2015
		 * @version 2.1
		 */	
	   public boolean cancelEncounter (WebDriver driver ,EncounterPage encounterPage)
	    {
		   encounterPage.cancelEncounter(driver);
		   return true;
	    }
	   /**
		 * deleteAllProblemList
		 * function to go to delete all problem list
		 * @param problemListPage- Page
		 * @param proData- data to delete problem list
		 * @since  	Jan 08, 2015
		 * @version 2.1
		 */	
	   public void deleteAllProblemList(ProblemListPage problemListPage, ChartPreVisitLib proData) throws IOException{
		   problemListPage.deleteAllProblemList(driver, proData);		   
	   }
	   
	   /**
		 * ifEncounterPendingListPresent
		 * function to verify if Encounter PendingList is Present
		 * @since  	Jan 08, 2015
		 * @version 2.1
		 */	
	   public boolean ifEncounterPendingListPresent(WebDriver driver)
	    {
		   return isElementPresent(lnkEncounterPendingList);
		
	    }
	   /**
		 * selectAssessment
		 * function to select an assessment
		 * @param encounterPage- Page
		 * @since  	Jan 08, 2015
		 * @version 2.1
		 */	
	   public void selectAssessment(EncounterPage encounterPage,String medicalCondition)  {
		   encounterPage.selectAssessment(medicalCondition);
		 }
	   /**
		 * enterComplaint
		 * function to enter a complaint
		 * @since  	Jan 08, 2015
		 * @version 2.1
		 */	
	   public void enterComplaint(EncounterPage encounterPage,String complaint)  {
		   encounterPage.enterComplaint(complaint);
		 }
	   
	   /**
		 * createProblemList
		 * function to create Problem List
		 * @param encounterPage- Page
		 * @param proData- Data to create problem list
		 * @since  	Jan 08, 2015
		 * @version 2.1
		 */	
	   public void createProblemList(EncounterPage encounterPage, ChartPreVisitLib proData)  {
		   problemListPage=new ProblemListPage();
		   encounterPage.createProblemList(problemListPage, proData);
	    }
	   
	   /**
		 * getCosigner
		 * function to get cosigner from Cosigner drop down
		 * @param encounterPage- Page
		 * @since  	Jan 08, 2015
		 * @version 2.1
		 */	
	  public String getCosigner(EncounterPage encounterPage) {
		  return encounterPage.getCosigner();			 
		 }
	  
	  /**
		 * selectCosign
		 * function to select cosigner from Cosigner drop down
		 * @param encounterPage- Page
		 * @since  	Jan 08, 2015
		 * @version 2.1
		 */	
	   public void selectCosign(EncounterPage encounterPage,ChartPreVisitLib encounterData)  {
		   encounterPage.selectCosign(encounterData);
		 }
	   
	   /**
	 		 * Go To Encounter Allergy
	 		 * function to Go To Encounter Allergy
	 		 * @since  	Jan 08, 2015
	 		 * @version 2.1
	 		 */	
	   public AllergyPage goToEncounterAllergy(WebDriver driver, EncounterPage encounterPage)
	    {
		   waitForPageLoad(driver);
		   waitForPageLoad(driver);
		   AllergyPage allergyPage = encounterPage.goToEncounterAllergy(driver);
		   waitForPageLoad(driver);
		   return allergyPage;
	    }
	   
	   public AllergyPage nvigatetoSummaryallergy(WebDriver driver)
	   {   waitForPageLoad(driver);
	   click(driver,lblSummaryAllergy);
	   waitForPageLoad(driver);
		   return new AllergyPage();
	   }
	   
	   
	   /**lnkFamilyHistory
		 * navigateToAllergy
		 * @throws IOException 
		 * @since Jan 22, 2015
		 */
		public AllergyPage navigateToAllergy(WebDriver driver) throws IOException {
			
			assertTrue(click(driver, lnkAllergy),
					"Could not click on allergy link;More Details",driver, className, methodName);
			   waitForPageLoad(driver);
			return  new AllergyPage();	
		}
		
		  
		   /**navigatetoProcedure
			 * @throws IOException 
			 * @since May 21, 2015
			 * @version 2.1
			 */
		public ProcedurePage navigatetoProcedure(WebDriver driver)
		   {   waitForPageLoad(driver);
		   click(driver,lnkProcedure);
		   waitForPageLoad(driver);
			   return new ProcedurePage();
		   }
	   
		   /**
			 * navigateToFamilyHistory
			 * @param driver
			 * @throws IOException 
			 * @since Jan 22, 2015
			 */
			public FamilyHistoryPage navigateToFamilyHistory(WebDriver driver) throws IOException {
				
				verifyTrue(click(driver, lnkFamilyHistory),	"Could not click on Family History link;More Details",driver);
				   waitForPageLoad(driver);
				return  new FamilyHistoryPage();	
			}

	        /**
	         * goToEncounterFamilyHistory
	    		 * Function to go To Encounter FamilyHistory
	    		 * @param 	driver
	    	  	 * @throws Exception 
	    		 * @since	May 20,2015
	    		 * @Version 2.1
	    		 */ 
	        public FamilyHistoryPage goToEncounterFamilyHistory(WebDriver driver, EncounterPage encounterPage)
	        {
	        	try{
	        		familyHistoryPage=encounterPage.goToEncounterFamilyHistory(driver);
	        		waitForPageLoad(driver);
	        	}
	        	catch(Exception e)
	        	{
	        		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	        	}
	        	return familyHistoryPage;
	        }

		/**
		 * deleteAllergy 
		 * function to delete Allergy
		 * @throws IOException 
		 * @since Oct 17, 2012
		 */

	   public boolean deleteAllAllergy(AllergyPage allergyPage,WebDriver driver,
				ChartPreVisitLib allergyData) throws IOException
	   {
	       allergyPage.deleteAllAllergy(driver, allergyData);
	       waitForPageLoad(driver);
		   return true;
	   }
	   
	   /**
		 * deleteAllProcedure 
		 * function to delete Procedure
		 * @throws IOException 
		 * @since May 21, 2015
		 * @version 2.1
		 */

	   public boolean deleteAllProcedure(ProcedurePage procedurePage,WebDriver driver,
				ChartPreVisitLib allergyData) throws IOException
	   {
		   procedurePage.deleteProcedure(allergyData);
	       waitForPageLoad(driver);
		   return true;
	   }
	   
	   public boolean createAllergy(AllergyPage allergyPage,WebDriver driver,
				ChartPreVisitLib allergyData,String userAccount) throws Exception
	   {
	       allergyPage.createAllergy(driver, allergyData,userAccount);
	       waitForPageLoad(driver);
		   return true;
	   }
	   
	   
		/**
		 * createEncounterAllergy
		 * function to create Encounter Allergy 
		 * @throws Exception 
		 * @since Nov 01, 2012
		 */
		public boolean createEncounterAllergy(WebDriver driver,ChartPreVisitLib allergyData, String account, EncounterPage encounterPage,AllergyPage allergyPage) throws Exception
		{
			encounterPage.createEncounterAllergy(driver, allergyData, account,allergyPage);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			return true;
		}
		
		/**
		 * createEncounterProcedure
		 * function to create Encounter Procedure 
		 * @throws Exception 
		 * @since May 21, 2015
		 * @version 2.1
		 */
		public boolean createEncounterProcedure(WebDriver driver,ChartPreVisitLib allergyData, String account, EncounterPage encounterPage,ProcedurePage procedurePage) throws Exception
		{
			encounterPage.createEncounterProcedure(driver, allergyData, account, procedurePage);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			return true;
		}
		
		/**
		 * createSummaryProcedure
		 * function to create Summary Procedure 
		 * @throws Exception 
		 * @since May 21, 2015
		 * @version 2.1
		 */
		public boolean createSummaryProcedure(WebDriver driver,ChartPreVisitLib allergyData, String account, ProcedurePage procedurePage) throws Exception
		{
			procedurePage.createProcedure(driver,allergyData, account);
			waitForPageLoad(driver);
			return true;
		}

		/**
		 * Verify Show mark up
		 * function to Verify Show mark up
		 * @throws Exception 
		 * @since Nov 01, 2014
		 * @Version 2.1
		 */
		public boolean verifyShowMarkupInSignedEncounter(WebDriver driver,ClinicalSettingLib encounterTemplateTestData ,ClinicalSettingLib encounterTemplateTestData1,ChartPreVisitLib allergyData, String date,String account )
		{
			assertTrue(click(driver, btnActionSignedEncounter),"Could not click on Action", driver, className, methodName);	
	    	waitForPageLoad(driver); 
	    	assertTrue(click(driver, lnkShowMarkup),"Could not click on Show Markup", driver, className, methodName);	
	    	waitForPageLoad(driver); 
	    	waitForPageLoad(driver); 	    	  	
	       	if (account.equals("CA2000"))	
			{
	       		assertTrue(isTextPresent(driver,allergyData.allergenCa),"Could notFind Allgery details in show mark up", driver, className, methodName);		    		       
			}
	    	else
	    	{
	    		assertTrue(isTextPresent(driver,allergyData.allergen),"Could not Find  allgrgy details in show mark up ", driver, className, methodName);	
		    		    	}
	       	return true;
		}
		
		public boolean showMarkupInUnSignedEncounter(WebDriver driver)
		{
			assertTrue(click(driver, lnkActionFirst),"Could not click on Action", driver, className, methodName);	
	    	waitForPageLoad(driver); 
	    	assertTrue(click(driver, lnkShowMarkup),"Could not click on Show Markup", driver, className, methodName);	
	    	waitForPageLoad(driver); 
	    	waitForPageLoad(driver); 
	    	waitForPageLoad(driver); 
	    	waitForPageLoad(driver); 
	    	waitForPageLoad(driver); 
	    	return true;
		}
		/**
		 * To Verify the show mark up version one
		 * function to verify the show mark up version one
		 * param driver
		 * param  ClinicalSettingLib data- encounterTemplateTestData
		 * @throws Exception 
		 * @Version 2.1
		 * @since Nov 01, 2012
		 */
		public boolean verifyManagedCareShowMarkupFirst(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)
		{
			try
			{
			click(driver,showMarkUp1);
			waitForPageLoad(driver);
			isTextPresent(driver,encounterTemplateTestData.freeTextComment);
			isTextPresent(driver,encounterTemplateTestData.numericWidgetComment);
			}catch(Exception e)
			{ 
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
	    	}
			return true;
		}
		
		/**
		 * To Verify the show mark up version two 
		 * function to verify the show mark up version two
		 * param driver
		 * param  ClinicalSettingLib data- encounterTemplateTestData
		 * @throws Exception 
		 * @Version 2.1
		 * @since Nov 01, 2012
		 */
		public boolean verifyManagedCareShowMarkupSecond(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)
		{
			try
			{
			click(driver,showMarkUp2);
			waitForPageLoad(driver);
			isTextPresent(driver,encounterTemplateTestData.freeTextComment);
			isTextPresent(driver,encounterTemplateTestData.numericWidgetComment);
		    }catch(Exception e)
			{ 
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
	    	}
			return true;
		}
		
		/**
		 * To Verify the show mark up 
		 * function to verify the show mark up
		 * param driver
		 * param  ClinicalSettingLib data- encounterTemplateTestData
		 * @throws Exception 
		 * @Version 2.1
		 * @since Nov 01, 2012
		 */
		public boolean verifyShowMarkupforPendingEncounter(WebDriver driver,ClinicalSettingLib encounterTemplateTestData)
		{
			assertTrue(click(driver, lnkActionFirst),"Could not click on Action", driver, className, methodName);	
	    	waitForPageLoad(driver); 
	    	assertTrue(click(driver, lnkShowMarkup),"Could not click on Show Markup", driver, className, methodName);	
	    	waitForPageLoad(driver); 
	    	waitForPageLoad(driver); 
	    	waitForPageLoad(driver); 
	    	/*assertTrue(isTextPresent(driver,encounterTemplateTestData.freeTextComment),"freeTextComment is not present",driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.numericWidgetValue),"numericWidgetValue is not present",driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.numericWidgetComment),"numericWidgetValue is not present",driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.questionWidgetAnswer1),"questionWidgetAnswer1 is not present",driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.fromDate),"fromDate is not present",driver, className, methodName);
	    	assertTrue(isTextPresent(driver,encounterTemplateTestData.toDate),"toDate is not present",driver, className, methodName);
	    	assertTrue(isTextPresent(driver,"20"),"value is not present",driver, className, methodName);*/
	    	   	return true;
		}

		
		
		
		public boolean verifyShowMarkupInThirdSignedEncounter(WebDriver driver,ClinicalSettingLib encounterTemplateTestData ,ClinicalSettingLib encounterTemplateTestData1,ChartPreVisitLib allergyData, String date,String account )
		{waitForPageLoad(driver); 
    	waitForPageLoad(driver); 
    	waitForPageLoad(driver); 
			assertTrue(click(driver, btnActionSignedEn3),"Could not click on Action", driver, className, methodName);	
	    	waitForPageLoad(driver); 
	    	assertTrue(click(driver, lnkShowMarkup),"Could not click on Show Markup", driver, className, methodName);	
	    	waitForPageLoad(driver); 
	    	waitForPageLoad(driver); 
	    	waitForPageLoad(driver); 
	    	waitForPageLoad(driver); 
	    	waitForPageLoad(driver); 
	    	waitForPageLoad(driver); 
	       	if (account.equals("CA2000"))	
			{
	   		assertTrue(isTextPresent(driver,allergyData.allergenCa),"allergenCa is not present",driver, className, methodName);
			}
			else
			{
		   	assertTrue(isTextPresent(driver,allergyData.allergen),"allergen is not present",driver, className, methodName);
			}
	    	waitForPageLoad(driver); 
	    	waitForPageLoad(driver); 
	    	return true;
		}
		
		
		
		

		  /**
				 *To click Edit Button In Allergy Window
				 * Function to click Edit Button In Allergy Window
				 * @param 	selenium
			  	 * @throws Exception 
				 * @since	JAN 06,2014
				 */ 
			
public boolean clickEditAllergy(WebDriver driver,EncounterPage encounterPage)
{
	 waitForPageLoad(driver); 
	 encounterPage.clickEditAllergy(driver);
	 return true;
}
/**
 *To click Edit Button In Allergy Window
 * Function to click Edit Button In Allergy Window
 * @param 	selenium
	 * @throws Exception 
 * @since	JAN 06,2014
 */ 

public boolean clickEditProcedure(WebDriver driver,EncounterPage encounterPage)
{
waitForPageLoad(driver); 
encounterPage.clickEditAllergy(driver);
return true;
}

public PrescribeMedicationPage clickPresMedi(WebDriver driver,EncounterPage encounterPage)
{ 
	waitForPageLoad(driver); 
	PrescribeMedicationPage prescribeMedicationPage = encounterPage.clickPresIcon(driver);
	return prescribeMedicationPage;
}

public boolean SearchPrescribeMed(WebDriver driver,ChartPreVisitLib prescribeData, String account,EncounterPage encounterPage,PrescribeMedicationPage prescribeMedicationPage) throws Exception
{

	encounterPage.SearchPrescribeMed(driver, prescribeData, account, prescribeMedicationPage);
	return true;	
}


public boolean addPrescribeMedication(WebDriver driver, ChartPreVisitLib prescribeData, String account,EncounterPage encounterPage,PrescribeMedicationPage prescribeMedicationPage) throws Exception
{
	encounterPage.addPrescribeMedication(driver, prescribeData, account, prescribeMedicationPage);
	return true;
}

public boolean clickOnPrintPrescribeMedication (WebDriver driver,EncounterPage encounterPage,PrescribeMedicationPage prescribeMedicationPage) throws InterruptedException, AWTException
{
	encounterPage.clickOnPrintPrescribeMedication(driver, prescribeMedicationPage);
	return true;
}

public ManagedCareTemplateOnPatientChartPage navigateToManagedCare(WebDriver driver) throws Exception
{
	assertTrue(click(driver, lnkMore), "Could not click on more link", driver, className, methodName);
	waitForPageLoad(driver);	
	assertTrue(click(driver,lnkToManagedCare),"Unable to navigate to Managed care template",driver,className,methodName);
	waitForPageLoad(driver);
    return new ManagedCareTemplateOnPatientChartPage();	
}

public boolean associateManagedCareTemplateOnPatientChartPage(ManagedCareTemplateOnPatientChartPage managedCareTemplate,WebDriver driver,String uniqueName,String userAccount,ClinicalSettingLib mcTemplate)throws Exception
{
	managedCareTemplate.navigateToParticularManagedCareTemplate(driver,mcTemplate,uniqueName,userAccount);
	return true;
}

public boolean recordValueForManagedCare(ManagedCareTemplateOnPatientChartPage managedCareTemplate,WebDriver driver,ClinicalSettingLib mcTemplate)throws Exception
{
	 managedCareTemplate.recordValueForManagedCare(driver,mcTemplate);
	 return true;
}

public boolean recordValueForEditedManagedCare(ManagedCareTemplateOnPatientChartPage managedCareTemplate,WebDriver driver)throws Exception
{
	 managedCareTemplate.recordValueForEditedManagedCare(driver);
	 return true;
}

public boolean verifyOnManagedCareTemplate(ManagedCareTemplateOnPatientChartPage managedCareTemplate,WebDriver driver,ClinicalSettingLib mcTemplate)throws Exception
{
	 managedCareTemplate.verifyOnManagedCareTemplate(driver,mcTemplate);
	 return true;
}

public boolean verifyDefaultVisitOutlineOnManagedCareTemplate(ManagedCareTemplateOnPatientChartPage managedCareTemplate,WebDriver driver,ClinicalSettingLib encounterVisitSection)throws Exception
{
	 managedCareTemplate.verifyDefaultOnManagedCareTemplate(driver,encounterVisitSection);
	 return true;
}

public void clickViewEdit(WebDriver driver, ManagedCareTemplateOnPatientChartPage managedCareTemplateOnPatientChartPage)throws Exception
{
	managedCareTemplateOnPatientChartPage.clickViewEdit(driver);
}



public boolean verifyEditedManagedCareTemplate(ManagedCareTemplateOnPatientChartPage managedCareTemplate,WebDriver driver,ClinicalSettingLib mcTemplate)throws Exception
{
	 managedCareTemplate.verifyEditedManagedCareTemplate(driver,mcTemplate);
	 return true;
}

public boolean clickOnLab (WebDriver driver)
{	waitForPageLoad(driver);
	assertTrue(click(driver, lnkLab),"Could not click the Lab link",driver, className, methodName);
	waitForPageLoad(driver);
	waitForPageLoad(driver);
	return true;
}

public boolean clickSearchForOLISReportsLink (WebDriver driver)
{
	assertTrue(click(driver, lnkSearchForOLISReports),"Could not click the Search For OLIS Reports link",driver, className, methodName);
	waitForPageLoad(driver);
	waitForPageLoad(driver);
	return true;
}


public boolean verifyAllRecordedValuesInEncounterNote (WebDriver driver,ChartPreVisitLib prescribeData,ChartPreVisitLib allergyData, String account,ClinicalSettingLib encounterEditTemplateTestData,EncounterPage encounterPage)
{	waitForPageLoad(driver);
waitForPageLoad(driver);
waitForPageLoad(driver);
	encounterPage.verifyAllRecordedValuesInEncounterNote(driver, prescribeData, allergyData, account,encounterEditTemplateTestData);
	return true;
}
public boolean verifythirdEncounterDetails (WebDriver driver,ChartPreVisitLib prescribeData,ChartPreVisitLib allergyData, String account,ClinicalSettingLib encounterEditTemplateTestData,EncounterPage encounterPage)
{	waitForPageLoad(driver);
	encounterPage.verifythirdEncounterDetails(driver, prescribeData, allergyData, account,encounterEditTemplateTestData);
	return true;
}

public boolean verifyNewlyCreatedWidgetsInEncounterNote (WebDriver driver ,ClinicalSettingLib sectionCdata ,ClinicalSettingLib sectionDdata ,EncounterPage encounterPage)
{
	encounterPage.verifyNewlyCreatedWidgetsInEncounterNote(driver, sectionCdata, sectionDdata);
    return true;
}
public ManagedCareTemplateOnPatientChartPage navigateToManagedCareOnPatientChart(WebDriver driver) throws Exception
{
	assertTrue(click(driver, lnkMore), "Could not click on more link", driver, className, methodName);
	waitForPageLoad(driver);	
	assertTrue(click(driver,lnkToManagedCare),"Unable to navigate to Managed care template",driver,className,methodName);
	waitForPageLoad(driver);
    return new ManagedCareTemplateOnPatientChartPage();	
}

public boolean removeAlreadyCreatedTemplate(WebDriver driver,ManagedCareTemplateOnPatientChartPage managedCareTemplatePage)
{
	managedCareTemplatePage.removeAlreadyCreatedTemplate(driver);
	return true;
}

public boolean navigateToCareTemplateAlreadyOpen(WebDriver driver,ManagedCareTemplateOnPatientChartPage managedCareTemplate)
{
	managedCareTemplate.navigateToCareTemplateAlreadyOpen(driver);
	return true;
}

public boolean recordVlaueInReuseWidgetsInEncounterNote(WebDriver driver,String date,ClinicalSettingLib encounterEditTemplateTestData,EncounterPage encounterPage) throws Exception
{
	  encounterPage.recordVlaueInReuseWidgetsInEncounterNote(driver,date,encounterEditTemplateTestData);
	  waitForPageLoad(driver);
	  return true;
	  
}

public boolean verifyDeletedSectionsInEncounterNote (WebDriver driver ,ClinicalSettingLib sectionCdata ,ClinicalSettingLib sectionDdata ,EncounterPage encounterPage)
{
	encounterPage.verifyDeletedSectionsInEncounterNote(driver, sectionCdata, sectionDdata);
	return true;
}
/**
 * verifyTextPresent
 * function to verify a text present
 * @param encounterPage- Page
 * @since  	Jan 08, 2015
 * @version 2.1
 */	
public boolean verifyTextPresent(String text)
{
	return isTextPresent(driver, text);
}

public boolean verifyRecordedWidgetInEditMode(WebDriver driver,ClinicalSettingLib encounterTemplateTestData, EncounterPage encounterPage) throws Exception
{  waitForPageLoad(driver);
	  encounterPage.verifyRecordedWidgetInEditMode(driver,encounterTemplateTestData);
	
	
	  return true;
	  
}
/**
 * enter encounter date
 * function to enter encounter date
 * @param driver
 * @param encounterPage- Page
 * @since  	Jan 08, 2015
 * @version 2.1
 */	


public boolean enterencounterdate(WebDriver driver,ClinicalSettingLib encounterTemplateTestData, EncounterPage encounterPage) throws Exception
{  waitForPageLoad(driver);
	  encounterPage.enterencounterdate(driver,encounterTemplateTestData);
	
	
	  return true;
	  
}
public boolean verifyRecordedWidgetDeletedWidget(WebDriver driver,EncounterPage encounterPage) throws Exception
{  waitForPageLoad(driver);
	  encounterPage.verifyRecordedWidgetvalueInDeletedwidgets(driver);
	 return true;
	  
}

/**
 * clickMoreEncounterPendingList
 * function to click on More Link of Pending Encounter List
 * @since  	Jan 08, 2015
 * @version 2.1
 */	
public boolean clickMoreEncounterPendingList(WebDriver driver)
{
	assertTrue(click(driver,lnkMoreEncounterPendingList),"Could not click the show More Encounter Pending List Link", driver, className, methodName);
	waitForPageLoad(driver);
	waitForPageLoad(driver);
	return true;
}

/**
 * ifDeleteEncounterPresent
 * function to check if Delete button is present for encounter
 * @since  	Jan 08, 2015
 * @version 2.1
 */	
public boolean ifDeleteEncounterPresent(){
	return isElementPresent(lnkDeleteEncounter);
}
/**
 * clickExpandAll
 * function to click Expand All Link
 * @since  	Jan 08, 2015
 * @version 2.1
 */	
public void clickExpandAll(){
	 waitForPageLoad(driver);
	click(lnkExpandAll);
}



		/**
		 * click Second signed encounter 
		 * function to click Expand All Link
		 * @since  	Jan 08, 2015
		 * @version 2.1
		 */	
		public void clickSecondencounterExpand(){
			  waitForPageLoad(driver);
			click(lblSecondSignedEncounter);
			
			  waitForPageLoad(driver);
		}	
		
/**
 * ifEncounterSignedListPresent
 * function to check if Encounter Signed List is Present
 * @since  	Jan 08, 2015
 * @version 2.1
 */	
public boolean ifEncounterSignedListPresent(WebDriver driver)
{
 return isElementPresent(lblSignedBy);

}

/**
 * goToCreateOrderLabTest
 * Function to Navigate To Create Order Lab Test Page 
 * @param encounterPage- Page
 * @param 	driver
 * @throws Exception 
 * @since	Jan 28,2015
 */  

public LabOrderPage goToCreateOrderLabTest(WebDriver driver,EncounterPage encounterPage ) throws Exception {
try {   
	waitForPageLoad(driver);
    waitForPageLoad(driver);
    waitForPageLoad(driver);
    waitForPageLoad(driver);
	labOrderPage = encounterPage.goToCreateOrderLabTest(driver);

}catch (Exception e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
    return  labOrderPage;
}

/**
 * Create New Order Lab Test
 * Function to Create New Order Lab Test 
 * @param 	driver
 * @param    diData - Test Data
 * @param 	encounterPage
 * @param 	labOrderPage
 * param  ChartPreVisitLib data- diData
 * @throws Exception 
 * @since	Jan 28,2015
 */  

public void createNewOrderLabTest(WebDriver driver,ChartPreVisitLib diData,EncounterPage encounterPage,LabOrderPage labOrderPage) throws Exception {
try{	
encounterPage.createNewOrderLabTest(driver,diData,labOrderPage);
waitForPageLoad(driver);
}catch (Exception e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
}

/**
 * Create New Order Lab Test
 * Function to Create New Order Lab Test 
 * @param 	driver
 * @param 	encounterPage
 * @param 	labOrderPage
 * @param ChartPreVisitLib data- diData
 * @throws Exception 
 * @since	Jan 28,2015
 */  

public void createNewOrderLabTestwithoutprint(WebDriver driver,ChartPreVisitLib diData,EncounterPage encounterPage,LabOrderPage labOrderPage) throws Exception {
	waitForPageLoad(driver);	
encounterPage.createNewOrderLabTestwithoutprint(driver,diData,labOrderPage);
waitForPageLoad(driver);	
waitForPageLoad(driver);	
}
/**
 * Go TO Order Lab Test
 * Function for Go TO Order Lab Test
 * @param encounterPage
 * @param 	driver
 * @throws Exception 
 * @since	Jan 29,2015
 */  

public void goTOOrderLabTest(WebDriver driver,EncounterPage encounterPage) throws Exception {
	try{
	encounterPage.goTOOrderLabTest(driver);
	waitForPageLoad(driver);
   }catch (Exception e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
  }
}

/**
 * Verify New Order Lab Test
 * Function to Verify Order Lab Test 
 * @param 	driver
 * @param 	encounterPage
 * @param 	labOrderPage
 * @param ChartPreVisitLib data- diData
 * @throws  Exception 
 * @since	Jan 29,2015
 */  


public void verifyNewOrderLabTest(WebDriver driver,ChartPreVisitLib diData,EncounterPage encounterPage,LabOrderPage labOrderPage) throws Exception {
try{	
encounterPage.verifyNewOrderLabTest(driver,diData,labOrderPage);
waitForPageLoad(driver);
}catch (Exception e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}

}
/**
 * Verify Checked Order Lab Test
 * Function to Verify Order Lab Test 
 * @param 	driver
 * @param   diData - Test Data
 * @param 	encounterPage
 * @param 	labOrderPage
 * @throws  Exception 
 * @since	Jan 29,2015
 */  


public void verifyCheckedOrderLabTest(WebDriver driver,ChartPreVisitLib diData,EncounterPage encounterPage,LabOrderPage labOrderPage) throws Exception {
	
encounterPage.verifyCheckedOrderLabTest(driver,diData,labOrderPage);
waitForPageLoad(driver);

}
/**
 * Verify Cancelled Allergy In Summary
 * Function to Verify Cancelled Allergy In Summary
 * @param 	driver
 * @throws  Exception 
 * @since	Jan 29,2015
 */  

public boolean verifyCancelledAllergy(WebDriver driver,ChartPreVisitLib allergyData,ChartPreVisitLib proData ,String account, EncounterPage encounterPage) throws Exception
{  waitForPageLoad(driver);
	  encounterPage.verifycancelledAllergyInNote(driver, allergyData,proData, account);
	
	  return true;
	  
}

public boolean verifyAllergyandMedicationinSummary(WebDriver driver,ChartPreVisitLib allergyData,String account)
{
	try{
		
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		assertTrue(click(driver, lnkPatientSummary),"Could not click the Action button in Encounter note", driver, className, methodName);	
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
	
			if (account.equals("CA2000")) {
		    assertTrue(!isTextPresent(driver, allergyData.allergenCa),"Allergen not found",driver,className,methodName);
			}
			else{
				 assertTrue(isTextPresent(driver, allergyData.allergen),"Allergen not found",driver,className,methodName);
			}
		    assertTrue(!isTextPresent(driver, allergyData.severity.toUpperCase()),"severity not found",driver,className,methodName);
		    assertTrue(!isTextPresent(driver, allergyData.status),"status not found",driver,className,methodName);
		    assertTrue(!isTextPresent(driver, allergyData.comment),"comment not found",driver,className,methodName);
		
	}
	catch(Exception e)
	{
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :", driver, className, methodName);
	}
	return true;
	
}

/**
 * goToEncounterProblemList
 * Function to Navigate To ProblemList of Encounter Page
 * @param 	driver
 * @param ChartPreVisitLib data- proData
 * @param account
 * @param problemListPage
 * @param encounterPage
 * @throws Exception 
 * @since	Mar 12,2015
 * @version 2.1
 */  
public boolean createEncounterProblemListEndToEnd(WebDriver driver,ChartPreVisitLib proData, String account, ProblemListPage problemListPage,EncounterPage encounterPage)
{
try{
	encounterPage.createEncounterProblemListEndToEnd(driver, proData, account, problemListPage);
	
} catch (Exception e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}

return true;
}

/**
* createEncounterSocialHistoryEndToEnd
* Function to Navigate To Social History of Encounter Page
* @param 	driver
* @param ChartPreVisitLib socialHistory data - socialHisData1
* @param account
* @param socialHistoryPage
* @param encounterPage
* @throws Exception 
* @since	May 21,2015
* @version 2.1
*/ 

public boolean createEncounterSocialHistoryEndToEnd(WebDriver driver,ChartPreVisitLib socialHisData1, String account, SocialHistoryPage socialHistoryPage,EncounterPage encounterPage)
{
try{
		encounterPage.createEncounterSocialHistoryEndToEnd(driver, socialHisData1, account, socialHistoryPage);
	
} catch (Exception e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}

return true;
}


/**
 * clickSaveEditProblemList function to a Click Add button
 * @param driver
 * @param problemListPage
 * @since  	@since March 12, 2015
 * @version 2.1
 */

public boolean clickSaveEditProblemList(WebDriver driver, ProblemListPage problemListPage)
{
	try{
	problemListPage.clickSaveEditProblemList(driver);
	waitForPageLoad(driver);
	waitForPageLoad(driver);
	waitForPageLoad(driver);
} catch (Exception e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	return true;
}

/**
 * clickSaveEditSocialHistory function to a Click Save button
 * @param driver
 * @param socialHistoryPage
 * @since  	@since May 21, 2015
 * @version 2.1
 */

public boolean clickSaveEditSocialHistory(WebDriver driver, SocialHistoryPage socialHistoryPage)
{
	try{
	socialHistoryPage.clickSaveEditSocialHistory(driver);
	waitForPageLoad(driver);
	waitForPageLoad(driver);
	waitForPageLoad(driver);
} catch (Exception e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	return true;
}

/**
 * clickSaveSummaryEditSocialHistory function to a Click Save button
 * @param driver
 * @param socialHistoryPage
 * @since  	@since May 21, 2015
 * @version 2.1
 */

public boolean clickSaveSummaryEditSocialHistory(WebDriver driver, SocialHistoryPage socialHistoryPage)
{
	try{
	socialHistoryPage.clickSaveSummaryEditSocialHistory(driver);
	waitForPageLoad(driver);
	waitForPageLoad(driver);
	waitForPageLoad(driver);
} catch (Exception e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	return true;
}


/**
 * createProblemListEndToEnd
 * Function to createProblemListEndToEnd 
 * @param 	driver
 * @param problemListPage- Page
 *  @param problemListPage- Page
 * @param problemListData- Test Data
 * @param User Account
 * @throws Exception 
 * @since	Mar 12,2015
 */ 

public void navigateToEditProblemListEndToEnd(WebDriver driver,EncounterPage encounterPage) throws Exception {
	
//	encounterPage.editProblemListEndToEnd(driver);
    waitForPageLoad(driver);
 
}

/**
 * createProblemListEndToEnd
 * Function to createProblemListEndToEnd 
 * @param 	driver
 * @param problemListPage- Page
 *  @param problemListPage- Page
 * @param problemListData- Test Data
 * @param User Account
 * @throws Exception 
 * @since	Mar 12,2015
 */ 

public void editProblemListEndToEnd(WebDriver driver,ProblemListPage problemListPage,EncounterPage encounterPage,ChartPreVisitLib problemListData, String userAccount) throws Exception {
	
//	encounterPage.editProblemListEndToEnd(driver, problemListPage,problemListData, userAccount);
    waitForPageLoad(driver);
 
}
/**
 * cancelEncounter
 * Function to Cancel Encounter
 * @param 	encounterPage
 * @throws Exception 
 * @since	Mar 12,2015
 * @version 2.1
 */
public boolean cancelEncounter(EncounterPage encounterPage)
{
	encounterPage.cancelEncounter();
	return true;
}

/**
 * goToEncounterProblemList
 * Function to Navigate To ProblemList of Encounter Page
 * @param 	driver
 * @param encounterPage
 * @throws Exception 
 * @since	Jan 28,2015
 * @version 2.1
 */  
public ProblemListPage goToEncounterProblemList(WebDriver driver,EncounterPage encounterPage)
{
 try{
   problemListPage=encounterPage.goToEncounterProblemList(driver);
  }catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
  }
   return problemListPage;
}

/**
 * goToEncounterSocialHistory
 * Function to Navigate To Social History of Encounter Page
 * @param 	driver
 * @param encounterPage
 * @throws Exception 
 * @since	Jan 28,2015
 * @version 2.1
 */  
public SocialHistoryPage goToEncounterSocialHistory(WebDriver driver,EncounterPage encounterPage)
{
 try{
	 socialHistoryPage = encounterPage.goToEncounterSocialHistory(driver);
  }catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
  }
   return socialHistoryPage;
}





/**
 * goTo Summary ProblemList
 * Function to Navigate To ProblemList of summary Page
 * @param 	driver
 * @throws Exception 
 * @since	March 12,2015
 * @version 2.1
 */  
public ProblemListPage goTosummaryProblemList(WebDriver driver)
{waitForPageLoad(driver);
	click(driver,lnksummaryProblemlist);
	
	waitForPageLoad(driver);
	  return new ProblemListPage();
}
/**
 * Verify Unchecked Order Lab Test
 * Function to Verify Order Lab Test 
 * @param 	driver
 * @param   diData - Test Data
 * @param 	encounterPage
 * @param 	labOrderPage
 * @throws  Exception 
 * @since	Jan 29,2015
 */  

public void verifyUncheckedOrderLabTest(WebDriver driver,ChartPreVisitLib diData,EncounterPage encounterPage,LabOrderPage labOrderPage) throws Exception {
	
encounterPage.verifyUncheckedOrderLabTest(driver,diData,labOrderPage);
waitForPageLoad(driver);
}

/**
 * Verify Edit Lab Order Test
 * Function to Verify Edit Lab Order Test
 * @param 	driver
 * @param 	encounterPage
 * @param 	labOrderPage
 * @throws  Exception 
 * @since	Jan 30,2015
 */  


public void editLabOrderTest(WebDriver driver,ChartPreVisitLib diData,EncounterPage encounterPage,LabOrderPage labOrderPage) throws Exception {
	
encounterPage.editLabOrderTest(driver,diData,labOrderPage);
waitForPageLoad(driver);

}

/**
 * editAssessmentInEncounterNote
 * Function to edit Assesment
 * @param encounterData- data to edit Assesment
 * @param 	driver
 * @throws Exception 
 * @since	Jan 28,2015
 * @version 2.1
 */  
public EncounterPage editAssessmentInEncounterNote(ChartPreVisitLib encounterData)
{
	encounterPage= new EncounterPage();
	problemListPage=encounterPage.goToeditAssessment();
	waitForPageLoad(driver);
	problemListPage.clickEditSaveProblemList();
	waitForPageLoad(driver);
	
	return encounterPage;
	
}

public boolean selectActionButtonForSignedEncounter(int listItem){
	By btnActionButton=By.xpath(String.format(btnActionsSignedEncounter,listItem));
	return click(btnActionButton);
}
/**
 * create chart disclose
 * function to create chart disclose
 * @param encounterPage- Page
 * @since  	MAR 11,2015
 * @version 2.1
 */	
public boolean createchartdisclose(WebDriver driver,ChartPreVisitLib chartDisclosureData, String account,ChartDisclosurePage chartDisclosurePage)
{
	chartDisclosurePage.createchartdisclose(driver, chartDisclosureData, account);
	waitForPageLoad(driver);
	return true;
	
}

/**
 *verify lab order name 
 * Function to verify lab order name 
 * @param Chart- Page
 * @since  	MAR 16,2015
 * @version 2.1
 */	

public boolean verifylaborder(WebDriver driver,ChartPreVisitLib diData){
	
	
	 assertTrue( isTextPresent(driver, diData.labTestName),"Lab order name not found",driver,className,methodName);

	return true;
	
	
}

/**
 *verify Problem list details
 * Function to verify lab order name 
 * @param Chart- Page
 * @since  	MAR 16,2015
 * @version 2.1
 */	

public boolean verifyproblemlistdata(WebDriver driver,ChartPreVisitLib proData){
	
	
	  assertTrue(isTextPresent(driver, proData.medicalCondition1),"Lab order name not found",driver,className,methodName);

	return true;
	
	
}
/**
 *verify Second Version of Encounter in Note 	
 * Function to verify lab order name 
 * @param Chart- Page
 * @since  	MAR 16,2015
 * @version 2.1
 */	

public boolean clicksecondversion(WebDriver driver){
	
	waitForPageLoad(driver);
	  assertTrue(click(driver, lbluserLabel3),"Lab order name not found",driver,className,methodName);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
	return true;
	
	
}
/**
 * clickEncounterEditProblemList function to a Click Edit button
 * @param encounterPage
 * @since  	@since March 24, 2015
 * @version 2.1
 */

public void clickEncounterEditProblemList(EncounterPage encounterPage)
{
	encounterPage.clickEncounterEditProblemList();
	
}

/**
 * removeEncounterProblemList function to a Click Remove button
 * @param encounterPage
 * @since April 07, 2015
 * @version 2.1
 */

public void removeEncounterProblemList(EncounterPage encounterPage)
{
	try{
	encounterPage.removeEncounterProblemList();
}catch (Exception e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
}

/**
 * removeEncounterProblemList function to a Click Remove button
 * @param encounterPage
 * @since May 26, 2015
 * @version 2.1
 */

public void removeEncounterInjection(WebDriver driver,EncounterPage encounterPage)
{
	try{
	encounterPage.removeEncounterInjection(driver);
}catch (Exception e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
}

/**
 * saveImmunization function to a click Save button
 * @param driver
 * @param immunizationPage
 * @since  	@since March 24, 2015
 * @version 2.1
 */

public boolean saveImmunization(WebDriver driver, ImmunizationPage immunizationPage)
{
try{
	immunizationPage.saveImmunization(driver);
}catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	    }
	return true;
}

/**
 * saveImmunizationEdit function to a click Save button
 * @param driver
 * @param immunizationPage
 * @since  	@since March 24, 2015
 * @version 2.1
 */

public boolean saveImmunizationEdit(WebDriver driver, ImmunizationPage immunizationPage)
{
	try{
	immunizationPage.saveImmunizationEdit(driver);
	}catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	    }
	return true;
}

/**
 * clickEditImmnization function to a Click Edit button
 * @param driver
 * @param immunizationPage
 * @since  	@since March 24, 2015
 * @version 2.1
 */

public boolean clickEditImmnization(WebDriver driver, ImmunizationPage immunizationPage)
{
try{
	immunizationPage.clickEditImmnization(driver);
}catch (Exception e) {
	  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	return true;
}

/**
 * saveMedication function to a Click Save button
 * @param driver
 * @param medicationsPage
 * @since  	@since March 24, 2015
 * @version 2.1
 */

public boolean saveMedication(WebDriver driver, MedicationsPage medicationsPage)
{
	medicationsPage.saveMedication(driver);
	return true;
}

/**
 * saveMedicationEdit function to a click Save button
 * @param driver
 * @param medicationsPage
 * @since  	@since March 24, 2015
 * @version 2.1
 */

public boolean saveMedicationEdit(WebDriver driver, MedicationsPage medicationsPage)
{
	medicationsPage.saveMedicationEdit(driver);
	return true;
}

/**
 * goToEncounterImmunization
 * function to  go To Encounter Immnization
 * param driver
 * @param encounterPage
 * @since  	Mar 25, 2015
 * @version 2.1
 */	
public ImmunizationPage goToEncounterImmunization (WebDriver driver, EncounterPage encounterPage)
{
	ImmunizationPage immunizationPage=encounterPage.goToEncounterImmunization(driver);
	return immunizationPage;
}
/**
 * clickEditMedication function to a Click Edit button
 * @param driver
 * @param medicationsPage
 * @since  	@since March 24, 2015
 * @version 2.1
 */

public boolean clickEditMedication(WebDriver driver, MedicationsPage medicationsPage)
{
	medicationsPage.clickEditMedication(driver);
	return true;
}
/**
 *verify encounter details in chart disclose
 * verify encounter details in chart disclose
 * @param chartDisclosurePage- Page
 * @param ChartPreVisitLib data - chartDisclosureData
 * @param driver, account
 * @since  	MAR 11,2015
 * @version 2.1
 */	
public boolean verifyencounterdetailsinchartdiscloser(WebDriver drive,ChartPreVisitLib chartDisclosureData, String account,ChartDisclosurePage chartDisclosurePage)
{waitForPageLoad(driver);
	chartDisclosurePage.verifyencounterdetailsinchartdisclose(driver, chartDisclosureData, account);
	waitForPageLoad(driver);
	return true;
	
}
/**
 * saveAddedEncounterMedications
 * Function to Save Added Encounter Medications
 * @param 	driver
 * @param  encounterPage
 * @param  medicationsPage
 * @since  	Mar 23, 2015
 * @version 2.1
 */	
public void saveAddedEncounterMedications(WebDriver driver,EncounterPage encounterPage,MedicationsPage medicationsPage){
try{    
encounterPage.saveAddedEncounterMedications(driver,medicationsPage);
}catch (Exception e) {
	  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
}



/**
 * Click Summary Tab
 * Function to click on Summary Tab
 *  @param driver
 * @since  	MAR 12,2015
 * @version 2.1
 */	
public boolean clickSummaryTab(WebDriver driver)
{
	try{
		verifyTrue(click(driver,lnkSummary),"ajxItem not found", driver);
		waitForPageLoad(driver);			
		waitForPageLoad(driver);
	}
	catch(Exception e){
	       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
	}  
	return true;
}

/**
 * createProblemListEndToEnd function to  create Problem List
 * @param driver,ChartPreVisitLib- Data for Problem List, ProblemListPage object, User Account
 * @since  	@since March 12, 2015
 * @version 2.1
 */

public boolean createProblemListEndToEnd(WebDriver driver,ChartPreVisitLib proData, String account, ProblemListPage problemListPage)   {
try {
	problemListPage.createProblemListEndToEnd(driver,proData,account);
	waitForPageLoad(driver);
 }
	catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}

	return true;
}

/**
 * createSocialHistoryEndToEnd function to  create Social History
 * @param driver,ChartPreVisitLib- Data for Social History, ProblemListPage problemList, User Account
 * @since  May 21, 2015
 * @version 2.1
 */

public boolean createSocialHistoryEndToEnd(WebDriver driver,ChartPreVisitLib socialHisData, String account, SocialHistoryPage socialHistoryPage)   {
try {
	socialHistoryPage.createSocialHistoryEndToEnd(driver,socialHisData,account);
	waitForPageLoad(driver);
 }
	catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}

	return true;
}

/**
 * saveSummaryProblemList function to a save Created Problem List
 * @param driver,ChartPreVisitLib- Data for Problem List, ProblemListPage object
 * @since March 12, 2015
 * @version 2.1
 */

public boolean saveSummaryProblemList(WebDriver driver, ProblemListPage problemListPage)
{
	try{
	problemListPage.saveSummaryProblemList(driver);
	}	catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	return true;
}

/**
 * saveSummarySocialHistory function to a save Created Social History
 * @param driver, SocialHistoryPage object
 * @since May 21, 2015
 * @version 2.1
 */

public boolean saveSummarySocialHistory(WebDriver driver, SocialHistoryPage socialHistoryPage)
{
	try{
		socialHistoryPage.saveSummarySocialHistory(driver);
	}	catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	return true;
}



/**
 * addProblemList function to a click Add button for Problem List
 * @param driver
 * @param problemListPage
 * @since  	@since March 13, 2015
 * @version 2.1
 */

public boolean addProblemList(WebDriver driver, ProblemListPage problemListPage)
{
	problemListPage.addProblemList(driver);
	return true;
}

/**
 * addImmunization function to a click Add button
 * @param driver
 * @param immunizationPage
 * @since  	@since March 24, 2015
 * @version 2.1
 */

public boolean addImmunization(WebDriver driver, ImmunizationPage immunizationPage)
{
	immunizationPage.addImmunization(driver);
	return true;
}
/**
 * saveSummaryProblemList function to a save Created Problem List
 * @param driver, account,ChartPreVisitLib- Data for Problem List, ProblemListPage object
 * @since March 12, 2015
 * @version 2.1
 */

public boolean verifyProblemListInSummary(WebDriver driver,ChartPreVisitLib proData, ChartPreVisitLib proData1, String account)
{
	try{
	String date ="";
    assertTrue(isTextPresent(driver, proData.medicalCondition1),"medicalCondition not found",driver,className,methodName);
    assertTrue(isTextPresent(driver, proData.itemStatus),"itemStatus not found",driver,className,methodName);
	verifyTrue(click(driver, btnProblemListCollapse), "lnkProblemListShowMoreArrow not found", driver);
	if (account.equals(Constants.CAACCOUNT)) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
		date = DateFormat.format(cal.getTime());
	    assertTrue(isTextPresent(driver,date),"date not found",driver,className,methodName);

	} else {
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
		date = DateFormat.format(cal1.getTime());
		
	    assertTrue(isTextPresent(driver, date),"date not found",driver,className,methodName);
	}

    assertTrue(isTextPresent(driver, proData.lifeStage),"lifeStage not found",driver,className,methodName);
    assertTrue(isTextPresent(driver, proData1.diagnosis),"diagnosis not found",driver,className,methodName);
    assertTrue(isTextPresent(driver, proData1.comment),"comment not found",driver,className,methodName);
    assertTrue(isTextPresent(driver,"Onset"),"Onset date not found",driver,className,methodName);
    assertTrue(isTextPresent(driver, "Resolved"),"Resolved not found",driver,className,methodName);
	}
	catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}

	return true;	
}

/**
 * saveSummaryProblemList function to a save Created Problem List
 * @param driver, account,ChartPreVisitLib- Data for Problem List, ProblemListPage object
 * @since March 12, 2015
 * @version 2.1
 */

public boolean verifySocialHistoryInSummary(WebDriver driver,ChartPreVisitLib socialHisData, ChartPreVisitLib socialHisData1, String account)
{
	try{
		
    
	assertTrue(isTextPresent(driver, socialHisData.type),"Social Type not found",driver,className,methodName);

    verifyTrue(click(driver, lnkSocialHistoryExpandArrow), "lnk Social History ShowMore Arrow not found", driver);

 //   assertTrue(isTextPresent(driver, socialHisData.status),"Type Status not found",driver,className,methodName);
    assertTrue(isTextPresent(driver,socialHisData.detailsText),"Details text found",driver,className,methodName);
    assertTrue(isTextPresent(driver,socialHisData.period),"Period not found",driver,className,methodName);
    assertTrue(isTextPresent(driver, socialHisData.year),"Year not found",driver,className,methodName);
    
    assertTrue(isTextPresent(driver, socialHisData.startAge),"Start Age not found",driver,className,methodName);
    assertTrue(isTextPresent(driver, socialHisData.historyType),"Stopped type not found",driver,className,methodName);
    assertTrue(isTextPresent(driver, socialHisData.stopAge)," Stop Age not found",driver,className,methodName);
   
 // Edited Values 
    
    assertTrue(isTextPresent(driver, socialHisData1.item),"Edited Item not found",driver,className,methodName);
    assertTrue(isTextPresent(driver, socialHisData1.detailsNum),"Edited Details Num not found",driver,className,methodName);
    assertTrue(isTextPresent(driver, socialHisData1.comment),"Edited comment not found",driver,className,methodName);
  
    
	}
	
	catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}

	return true;	
}



/**
 * verifyVitalsInSummary function to verify Vitals In Summary
 * @param 	ChartPreVisitLib- Data for vitals, account
 * @param driver, account
 * @since  	@since March 27, 2015
 * @version 2.1
 */

public boolean verifyVitalsInSummary(WebDriver driver,ChartPreVisitLib proData, String account)
{
	try{
    assertTrue(isTextPresent(driver, proData.heightInCm),"height not found",driver,className,methodName);
	}
	catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}

	return true;	
}

/**
 * saveSummaryImmunization function to a save Created Immunization
<<<<<<< HEAD
 * @param immData - Test Data for Immunization
 * @param driver
 * @param account - Application Environment
=======
 * @param 	ChartPreVisitLib- Data for Immunization
 * @param driver , account
>>>>>>> refs/remotes/origin/2.0_WD
 * @since  	March 25, 2015
 * @version 2.1
 */

public boolean verifyImmunizationsInSummary(WebDriver driver,ChartPreVisitLib immData, String account)
{
	try{
	
	String date ="";
    assertTrue(isTextPresent(driver, immData.Vaccine1CA),"Vaccine1CA not found",driver,className,methodName);
    assertTrue(isTextPresent(driver, immData.reaction),"reaction not found",driver,className,methodName);
	verifyTrue(click(driver, btnImmunizationCollapse), "btnImmunizationCollapse not found", driver);
	if (account.equals(Constants.CAACCOUNT)) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("MMM dd, yyyy");
		date = DateFormat.format(cal.getTime());
	    assertTrue(isTextPresent(driver,date),"date not found",driver,className,methodName);

	} else {
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
		date = DateFormat.format(cal1.getTime());
		
	    assertTrue(isTextPresent(driver, date),"date not found",driver,className,methodName);
	}

    assertTrue(isTextPresent(driver, immData.comment),"comment not found",driver,className,methodName);
	
	}
	catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}

	return true;	
}


/**
 * verifyImmunizationInFlowSheet
 * Function Verify Immunization In FlowSheet
 * @param driver
 * @param mcTemplate - test data
 * @param immData - test data
 * @param managedCareTemplateOnPatientChartPage- page
 * @since April 01, 2015
 * @version 2.1
 */

public boolean verifyImmunizationInFlowSheet(WebDriver driver,ClinicalSettingLib mcTemplate,ChartPreVisitLib immData, ManagedCareTemplateOnPatientChartPage managedCareTemplateOnPatientChartPage)
{
	managedCareTemplateOnPatientChartPage.verifyImmunizationInFlowSheet(driver, mcTemplate, immData);
	return true;
}

/**
 * clickEditProblemList function to a Click Edit button
<<<<<<< HEAD
 * @param drive
 * @param mcTemplate - test data
 * @since March 12, 2015
=======
 * @param driver
 * @param mcTemplate - test data
 * @since  	@since March 12, 2015
>>>>>>> refs/remotes/origin/2.0_WD
 * @version 2.1
 */

public void verifyMedicationsInSummary(WebDriver driver,ClinicalSettingLib mcTemplate)
{
	try{
		assertTrue(isTextPresent(driver, mcTemplate.medicationName1),"Medication name not found",driver,className,methodName);
		waitForPageLoad(driver);
	    assertTrue(isTextPresent(driver,mcTemplate.display),"Medications Comments not found",driver,className,methodName);
	    waitForPageLoad(driver);	
	}catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	    }
	
}

/**
 * clickEditProblemList function to a Click Edit button
 * @param problemListPage 
 * @since March 12, 2015
 * @version 2.1
 */

public boolean clickEditProblemList( ProblemListPage problemListPage)
{
try{
	problemListPage.clickEditProblemList();
} catch (Exception e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	return true;
}

/**
 * clickEditEncounterSocialHistory function to a Click Edit button
 * @param socialHistoryPage 
 * @since May 21, 2015
 * @version 2.1
 */

public boolean clickEditEncounterSocialHistory(WebDriver driver,SocialHistoryPage socialHistoryPage)
{
try{
	socialHistoryPage.clickEditEncounterSocialHistory(driver);
} catch (Exception e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	return true;
}




/**
 * goToEditProblemListFromEncounter function to  Edit Problem List from encounter
 * @param encounterPage, problemListPage
 * @since  	@since March 13, 2015
 * @version 2.1
 */

public boolean goToEditProblemListFromEncounter(EncounterPage encounterPage,ProblemListPage problemListPage)
{
	encounterPage.goToEditProblemListFromEncounter(problemListPage);
	return true;
	
}


/**
 * goToBillingHistoryPage function to  go to Billing History Page
 * @param driver
 * @since  	@since March 23, 2015
 * @version 2.1
 */

public BillingHistoryPage goToBillingHistoryPage(WebDriver driver)
{
	try{
		verifyTrue(click(driver, lnkPatientOptions), "lnkPatientOptions button not found", driver);
		waitForPageLoad(driver);
		verifyTrue(click(driver, lnkBillingHistory), "lnkBillingHistory button not found", driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
	}
	catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}

	return new BillingHistoryPage();
}

/**
 * verifyBlankProblemList function to  verify Problem List is empty
 * @param ChartPreVisitLib data - proData
 * @since  	@since March 13, 2015
 * @version 2.1
 */

public boolean verifyBlankProblemList(ChartPreVisitLib proData)
{
    assertTrue(!isTextPresent(driver, proData.medicalCondition1),"medicalCondition1 is present",driver,className,methodName);
    assertTrue(isTextPresent(driver, "No problem list added"),"Text not found",driver,className,methodName);
	return true;
	
}

/**
 * clickSaveSummaryProblemList function to a save Problem List
 * @param driver 
 * @param problemListPage
 * @since  	@since March 13, 2015
 * @version 2.1
 */

public boolean clickSaveSummaryProblemList(WebDriver driver,ProblemListPage problemListPage)
{
try{
	problemListPage.clickSaveSummaryProblemList(driver);
}catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}

	return true;
}

/**
 * verifyVersionInShowMarkUp function to  check number of versions displayed
 * @param count - integer
 * @since  	@since March 18, 2015
 * @version 2.1
 */

public boolean verifyVersionInShowMarkUp(WebDriver driver, int count)
{
	try{
	for(int i=1; i<=count; i++)
	{
	  By temp = By.id("user"+i);
  	if(!getText(driver,temp).contains("Billy"))
		  return false;
		//waitForPageLoad(driver);
	}
	}
	catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}

	return true;
}

/**
 * verifyVersionInShowMarkUp function to  check number of versions displayed
 * @param driver, account
 * @param ChartPreVisitLib data - allergyData
 * @since  	@since March 18, 2015
 * @version 2.1
 */

public boolean verfiyAllergyInShowMarkUp(WebDriver driver, ChartPreVisitLib allergyData , String account)
{
	try{
		if (account.equals("CA2000")) {
	    assertTrue(isTextPresent(driver, allergyData.allergenCa),"Allergen not found",driver,className,methodName);
		}
		else{
			 assertTrue(isTextPresent(driver, allergyData.allergen),"Allergen not found",driver,className,methodName);
		}
	    assertTrue(isTextPresent(driver, allergyData.severity.toUpperCase()),"severity not found",driver,className,methodName);
	    assertTrue(isTextPresent(driver, allergyData.status),"status not found",driver,className,methodName);
	    assertTrue(isTextPresent(driver, allergyData.comment),"comment not found",driver,className,methodName);
	}
	catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}

	return true;
}
/**
 * deleteEncounterProblemList
 * Function to Delete the Encounter ProblemList
 * @param 	driver
 * @since	Mar 17,2015
 * @version 2.1
 */  
public void  deleteEncounterProblemList(WebDriver driver,EncounterPage encounterPage,ProblemListPage problemListPage,ChartPreVisitLib problemListData)
{
   encounterPage.deleteEncounterProblemList(driver,problemListPage,problemListData);
  
}


/**
 * goToencounterVitals
 * function to goTo encounter Vitals Page 
 *  @param 	driver
 *  @param  encounterPage
 * @since  	Mar 18, 2015
 * @version 2.1
 */	
public VitalsPage goToencounterVitals(WebDriver driver,EncounterPage encounterPage)  {
try{	
	vitalsPage = encounterPage.goToencounterVitals(driver);
}catch (Exception e) {
	  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	return vitalsPage;
	
}
/**
 * verifyVitalsInFlowSheet
 * Function Verify Vitals In FlowSheet
 * @param driver
 * @param  ManagedCareTemplateOnPatientChartPage
 * @param mcTemplate - test data
 * @param VitalsData - test data
 * @since March 30, 2015
 * @version 2.1
 */

public boolean verifyVitalsInFlowSheet(WebDriver driver, ManagedCareTemplateOnPatientChartPage managedCareTemplateOnPatientChartPage,ClinicalSettingLib mcTemplate,ChartPreVisitLib vitalsData)
{
try{
	managedCareTemplateOnPatientChartPage.verifyVitalsInFlowSheet(driver,mcTemplate,vitalsData);
}catch (Exception e) {
	  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	return true;
}

/**
 * verifyValuesInFlowSheet
 * Function Verify Vitals In FlowSheet
 * @param driver
 * @param  ManagedCareTemplateOnPatientChartPage
 * @param mcTemplate - test data
 * @param VitalsData - test data
 * @since March 30, 2015
 * @version 2.1
 */

public boolean verifyValuesInFlowSheet(WebDriver driver,ManagedCareTemplateOnPatientChartPage managedCareTemplateOnPatientChartPage,ClinicalSettingLib mcTemplate,ChartPreVisitLib immData,ChartPreVisitLib immData2,ClinicalSettingLib mcTemplatesVital,ChartPreVisitLib vitalsData)
{
try{
	
	managedCareTemplateOnPatientChartPage.verifyValuesInFlowSheet(driver,mcTemplate,immData,immData2,mcTemplatesVital,vitalsData);
}catch (Exception e) {
	  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	return true;
}



/**
 * verifyMedicationsInFlowSheet
 * Function Verify Medications In FlowSheet
 * @param driver
 * @param  ManagedCareTemplateOnPatientChartPage
 * @param mcTemplate - test data
 * @since March 30, 2015
 * @version 2.1
 */

public boolean verifyMedicationsInFlowSheet(WebDriver driver, ManagedCareTemplateOnPatientChartPage managedCareTemplateOnPatientChartPage,ClinicalSettingLib mcTemplate)
{
try{
	managedCareTemplateOnPatientChartPage.verifyMedicationsInFlowSheet(driver,mcTemplate);
}catch (Exception e) {
	  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	return true;
}

/**
 * goToEncounterMedications
 * function to goTo Encounter Medications Page 
 *  @param 	driver
 *  @param  encounterPage
 * @since  	Mar 19, 2015
 * @version 2.1
 */	

public MedicationsPage goToSummaryMedications(WebDriver driver)  {
	try{
			verifyTrue(click(driver,lnkMedicationsSummaryPage), "Could not click on Medications  click", driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
	 }catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	    }
		 return new MedicationsPage();
	}
	

/**
 * goToEditEncounterMedications
 * function to goTo Edit Encounter Medications Page 
 * @param 	driver
 * @param  encounterPage
 * @param  medicationsPage
 * @since  	Mar 25, 2015
 * @version 2.1
 */	

public void goToEditEncounterMedications(WebDriver driver,EncounterPage encounterPage,MedicationsPage medicationsPage)  {
 try{
	encounterPage.goToEditEncounterMedications(driver,medicationsPage);
}catch (Exception e) {
	  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
   }
	
}

/**
 * goToEncounterMedications
 * function to goTo Encounter Medications Page 
 * @param 	driver
 * @param  encounterPage
 * @param  medicationsPage
 * @since  	Mar 25, 2015
 * @version 2.1
 */	

public MedicationsPage goToEncounterMedications(WebDriver driver,EncounterPage encounterPage)  {
 try{
	 medicationsPage = encounterPage.goToEncounterMedications(driver);
   }catch (Exception e) {
	  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
   }
 return medicationsPage;
}

/**
 * deleteEncounterMedications
 * function to Delete Encounter Medications Page 
 * @param 	driver
 * @param  encounterPage
 * @since  	Mar 19, 2015
 * @version 2.1
 */	

public void deleteEncounterMedications(WebDriver driver,EncounterPage encounterPage)  {
try{
	encounterPage.deleteEncounterMedications(driver);
}catch (Exception e) {
	  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	
}

/**
 * deleteEncounterImmunizations
 * function to Delete Encounter Immunizations Page 
 *  @param 	driver
 *  @param  encounterPage
 * @since  	Mar 25, 2015
 * @version 2.1
 */	

public void deleteEncounterImmunizations(WebDriver driver,EncounterPage encounterPage)  {
try{
	encounterPage.deleteEncounterImmunizations(driver);
}catch (Exception e) {
	  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	
}

/**
 * Add Encounter Vitals
 * Function to Add Encounter Vitals
 * @param 	driver
 * @param  encounterPage
 * @param  vitalsPage
 * @param  ChartPreVisitLib - Vitals test data
 * @since  	Mar 19, 2015
 * @version 2.1
 */	

public boolean addEncounterVitals(WebDriver driver,EncounterPage encounterPage,VitalsPage vitalsPage,ChartPreVisitLib vitalsData){
try{	
    encounterPage.addEncounterVitals(driver,vitalsPage,vitalsData);
}catch (Exception e) {
	  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	return true;
	
}

/**
 * goToEncounterVitals
 * function to  go To Encounter Vitals
 * param driver
 * @since  	Mar 25, 2015
 * @version 2.1
 */	
public VitalsPage goToEncounterVitals (WebDriver driver,EncounterPage encounterPage)
{
	vitalsPage=encounterPage.goToEncounterVitals(driver);
	return vitalsPage;
}

/**
 * Add Encounter Medications
 * Function to Add Encounter Medciations
 * @param 	driver
 * @param  encounterPage
 * @param  vitalsPage
 * @param  ClinicalSettingLib - Medications test data
 * @since  	Mar 19, 2015
 * @version 2.1
 */	

public MedicationsPage addEncounterMedications(WebDriver driver,EncounterPage encounterPage,MedicationsPage medicationsPage,ClinicalSettingLib mcTemplate){
 try{
	encounterPage.addEncounterMedications(driver,medicationsPage,mcTemplate);
}catch (Exception e) {
	  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	return medicationsPage;
}

/**
	 * Add Summary Medications
	 * Function to AddSummary Medications
	 * @param 	driver
	 * @param  vitalsPage
	 * @param  ClinicalSettingLib - Medications test data
	 * @since  	Mar 19, 2015
	 * @version 2.1
	 */	
	public MedicationsPage addSummaryMedications(WebDriver driver,MedicationsPage medicationsPage,ClinicalSettingLib mcTemplate)  {
		try{
			medicationsPage.addEncounterMedications(driver,mcTemplate);
	       
		}catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	    }
		 return new MedicationsPage();
	}
/**
 * edit Encounter Medications
 * Function to Edit Encounter Medciations
 * @param 	driver
 * @param  encounterPage
 * @since  	Mar 25, 2015
 * @version 2.1
 */	

public MedicationsPage editEncounterMedications(WebDriver driver,EncounterPage encounterPage,MedicationsPage medicationsPage,ClinicalSettingLib mcTemplate){
 try{
	encounterPage.editEncounterMedications(driver,medicationsPage, mcTemplate);
}catch (Exception e) {
	  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}return medicationsPage;
}

/**
 * addRenewedMedication
 * Function to add Encounter renewed medications
 * @param 	driver
 * @throws IOException 
 * @since	Mar 23,2015
 */

public boolean addRenewedMedication(WebDriver driver,ChartPreVisitLib medData,MedicationsPage medicationsPage){

	medicationsPage.addRenewedMedication(driver, medData);
	waitForPageLoad(driver);			
	return true;
}

/**
 * addEncounterProblemList function to a Click Add button
 * @param driver,	problemListPage
 * @since March 27, 2015
 * @version 2.1
 */

public boolean addEncounterProblemList(WebDriver driver, ProblemListPage problemListPage)
{
try{
	problemListPage.addEncounterProblemList(driver);
	waitForPageLoad(driver);
	waitForPageLoad(driver);
	waitForPageLoad(driver);
}catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	    }
	return true;
}

/**
 * addEncounterSocialHistory function to a Click Add button
 * @param driver,	socialHistoryPage
 * @since May 22, 2015
 * @version 2.1
 */

public boolean addEncounterSocialHistory(WebDriver driver, SocialHistoryPage socialHistoryPage)
{
try{
	socialHistoryPage.addEncounterSocialHistory(driver);
	waitForPageLoad(driver);
	}catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	    }
	return true;
}



/**
 * verifyVitalsInSummary function to a Click Edit button
 * @param driver
 * @param vitalsData - test data
 * @since March 12, 2015
 * @version 2.1
 */

public void verifyVitalsInSummary(WebDriver driver,ChartPreVisitLib vitalsData)
{
	try{
		assertTrue(isTextPresent(driver, vitalsData.heightInCm),"Type height not found",driver,className,methodName);
		assertTrue(isTextPresent(driver,vitalsData.heightMU),"Type height unit not found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,vitalsData.weight),"Type weight not found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,vitalsData.weightMU),"Type weight unit not found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,vitalsData.waist),"Waist not found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,vitalsData.waistMU),"Waist unit not found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,vitalsData.systolicRate),"Systolic Rate not found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,vitalsData.diastolicRate),"Diastolic Rate not found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,vitalsData.bPM),"Heart rate not found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,vitalsData.description),"Heart rate description not found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,vitalsData.rhythm),"Heart rate rhythm not found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,vitalsData.temperature),"Temperaturenot found",driver,className,methodName);
	    //assertTrue(isTextPresent(driver,vitalsData.tempRU),"Temperature not found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,vitalsData.bloodSuger),"BloodSuger found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,vitalsData.bSUnit),"BloodSuger Unit found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,vitalsData.repositoryRate),"Respiratory rate found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,vitalsData.rR_BPM),"Respiratory rate Unit found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,vitalsData.oxygenSaturation),"Oxygen Saturation found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,vitalsData.pEFR),"PEFR found",driver,className,methodName);
	    assertTrue(isTextPresent(driver,vitalsData.time),"PEFR time found",driver,className,methodName);
	    
	}catch (Exception e) {
		  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	    }
}

/**
 * addNewReferralLetter function to add Referral Letter
 * @param driver
 * @param ChartPreVisitLib - referralData
 * @param referralLetterPage
 * @param encounterPage
 * @since  	@since April 27, 2015
 * @version 2.1
 */

public boolean addNewReferralLetter(WebDriver driver, ChartPreVisitLib referralData, ReferralLetterPage referralLetterPage, EncounterPage encounterPage) throws IOException {

	encounterPage.addNewReferralLetter(driver, referralData, referralLetterPage);
	return true;
}


/**
 * Remove Encounter Vitals
 * Function to Remove Encounter Vitals
 * @param 	driver
 * @param  encounterPage
 * @param  vitalsPage
 * @since  	Apr 29, 2015
 * @version 2.1
 */	

public boolean removeEncounterVitals(WebDriver driver,EncounterPage encounterPage,VitalsPage vitalsPage){
try{	
    encounterPage.removeEncounterVitals(driver,vitalsPage);
}catch (Exception e) {
	  new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	return true;
}

/**
 * verifyBlankVitalsList function to  verify Vitals List is empty
 * @param ChartPreVisitLib data - proData
 * @since  	@since March 13, 2015
 * @version 2.1
 */

public boolean verifyBlankVitalsList(WebDriver driver)
{
    
    assertTrue(isTextPresent(driver, "No Vitals Recorded"),"Text not found",driver,className,methodName);
	return true;
	
}


/**
 * verifyBlankImmunizationList function to  verify Immunization List is empty
 * @param ChartPreVisitLib data - proData
 * @since  	@since March 13, 2015
 * @version 2.1
 */

public boolean verifyBlankImmunizationList(ChartPreVisitLib immData)
{
    assertTrue(!isTextPresent(driver, immData.Vaccine1CA),"medicalCondition1 is present",driver,className,methodName);
    assertTrue(isTextPresent(driver, "No immunizations added"),"Text not found",driver,className,methodName);
	return true;
	
}

/**
 * verifyAssessmentInLetter function to verify Assessment In Letter
 * @param driver
 * @param ChartPreVisitLib - referralData
 * @param referralLetterPage
 * @since  May 05, 2015
 * @version 2.1
 */

public boolean verifyAssessmentInLetter(WebDriver driver, ChartPreVisitLib proData, ReferralLetterPage referralLetterPage, EncounterPage encounterPage) throws IOException {

	try{
		encounterPage.verifyAssessmentInLetter(driver, proData, referralLetterPage);
		waitForPageLoad(driver);
	}
	catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	}

	return true;
}	

/**
 * verifyImageWidgetInEncounter
	 * Function to verify Image Widget In Encounter Edit Mode 
	 * @param 	driver
	 * @param   encounterTemplateTestData
  	 * @throws Exception 
	 * @since	May 07,2015
	 * @Version 2.1
	 */ 
public boolean verifyImageWidgetInEncounter(WebDriver driver, ClinicalSettingLib encounterTemplateTestData, ClinicalSettingLib visitOutlineData, EncounterPage encounterPage)
{
	try{
		encounterPage.verifyImageWidgetInEncounter(driver, encounterTemplateTestData, visitOutlineData);
		waitForPageLoad(driver);
  	}
	catch(Exception e)
	{
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	}
	return true;
}
/**
 * Create New Order Lab Test
 * Function to Create New Order Lab Test 
 * @param 	driver
 * @param 	encounterPage
 * @param 	labOrderPage
 * @param ChartPreVisitLib data- diData
 * @throws Exception 
 * @since	May 12, 2015
 */  

public void createDIOrder(WebDriver driver,ChartPreVisitLib diData,EncounterPage encounterPage,LabOrderPage labOrderPage) throws Exception {
	waitForPageLoad(driver);	
encounterPage.createDIOrder(driver,diData,labOrderPage);
waitForPageLoad(driver);	
waitForPageLoad(driver);	
}
/**
 * goToCreateOrderLabTest
 * Function to Navigate To Create Order Lab Test Page 
 * @param encounterPage- Page
 * @param 	driver
 * @throws Exception 
 * @since	Jan 28,2015
 */  

public LabOrderPage goToCreateOrderDITest(WebDriver driver,EncounterPage encounterPage ) throws Exception {
try {   
	waitForPageLoad(driver);
    waitForPageLoad(driver);
    waitForPageLoad(driver);
    waitForPageLoad(driver);
	labOrderPage = encounterPage.goToCreateOrderDITest(driver);

}catch (Exception e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
    return  labOrderPage;
}
/**
 * goToEdit Di Order
 * Function to Navigate To Create Order Lab Test Page 
 * @param encounterPage- Page
 * @param 	driver
 * @throws Exception 
 * @since	Jan 28,2015
 */  

public LabOrderPage editDIOrder(WebDriver driver,EncounterPage encounterPage ) throws Exception {
try {   
	waitForPageLoad(driver);
    waitForPageLoad(driver);
    waitForPageLoad(driver);
    waitForPageLoad(driver);
	labOrderPage = encounterPage.editDiOrder(driver);

}catch (Exception e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
    return  labOrderPage;
}
/**
 * Verify the widgets in encounter note in details
 * Function  Verify the widgets in encounter note in details
 * @param encounterPage- Page
 * @param 	driver
 * @throws Exception 
 * @since	Jan 28,2015
 */  

public boolean verifythewidgets(WebDriver driver,ClinicalSettingLib encounterTemplateTestData, EncounterPage encounterPage)
{	
waitForPageLoad(driver);
 // encounterPage.verifyDefaultWidgetValues(driver, encounterTemplateTestData);
	
  return true;
}

/**
		 * goToCreateDI
		 * Function to Navigate To Create DI Page 
		 * @param 	driver
		 * @throws  Exception 
	  	 * @since	May 26,2015
		 */  
  
  public DiagnosticImagingPage goToCreateDI(WebDriver driver, EncounterPage encounterPage)   {
	 
	  encounterPage.goToCreateDI(driver);
	  waitForPageLoad(driver);
  	
  	return new DiagnosticImagingPage();
  	
	}

	/**
	 * createDIReport 
	 * function to a create DI Report
	 * @param driver,ChartPreVisitLib- Data for DI,userAccount
	 * @since May 26, 2015
	 * @version 2.1
	 */

	public boolean createDIReport(WebDriver driver,ChartPreVisitLib proData, String account, DiagnosticImagingPage diagnosticImagingPage, EncounterPage encounterPage)   {
		try {
			encounterPage.createDIReport(driver, proData, account, diagnosticImagingPage);
			  waitForPageLoad(driver);
		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
		return true;
	}

	/**
	 * clickSaveDI 
	 * function to a save DI
	 *@since May 26, 2015
	 * @version 2.1
	 */
	
	public boolean clickSaveDI(WebDriver driver, DiagnosticImagingPage diagnosticImagingPage, EncounterPage encounterPage)
	{
		try{
			encounterPage.clickSaveDI(driver, diagnosticImagingPage);
			waitForPageLoad(driver);
		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
		return true;
	}

    /**
		 * editDIReport
		 * Function to Navigate To Edit Di report Page 
		 * @param 	driver
		 * @throws  Exception 
	  	 * @since	May 26,2015
		 */  
  
  public DiagnosticImagingPage editDIReport(WebDriver driver, EncounterPage encounterPage)   {
	 
	  encounterPage.editDIReport(driver);
	  waitForPageLoad(driver);
  	
  	return new DiagnosticImagingPage();
  	
	}

/**
 * Verify the Text in application
 * Function  Text in application
 * @param encounterPage- Page
 * @param 	driver
 * @throws Exception 
 * @since	Jan 28,2015
 */  

public boolean verifytext(WebDriver driver,String text)
{	
waitForPageLoad(driver);
assertTrue(isTextPresent(driver, text),"Required Text is not present ",driver,className,methodName);
	
  return true;
}


/**
 * verifyPracticeDetailsOnThePage
	 * Function to verify Image Widget In Encounter Edit Mode 
	 * @param 	driver
	 * @param   encounterTemplateTestData
  	 * @throws Exception 
	 * @since	May 12,2015
	 * @Version 2.1
	 */ 
public boolean verifyPracticeDetailsOnThePage(WebDriver driver,EncounterPage encounterPage,ChartPreVisitLib letterTemplateTestData)
{
	try{
		encounterPage.verifyPracticeDetailsOnThePage(driver, letterTemplateTestData);
		waitForPageLoad(driver);
  	}
	catch(Exception e)
	{
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	}
	return true;
}

     /**
     * selectProviderInReferralPage
	 * Function to verify Image Widget In Encounter Edit Mode 
	 * @param 	driver
	 * @param   encounterTemplateTestData
  	 * @throws Exception 
	 * @since	May 12,2015
	 * @Version 2.1
	 */ 
     public boolean selectProviderInReferralPage(WebDriver driver,EncounterPage encounterPage,ChartPreVisitLib letterTemplateTestData)
     {
	try{
		encounterPage.selectProviderInReferralPage(driver, letterTemplateTestData);
		waitForPageLoad(driver);
  	}
	catch(Exception e)
	{
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
	}
	return true;
     }
     
     
     /**
      * verifyPayersDetailsOnThePage
 	 * Function to verify payer details on the page 
 	 * @param 	driver
 	 * @param   encounterTemplateTestData
   	 * @throws Exception 
 	 * @since	May 12,2015
 	 * @Version 2.1
 	 */ 
      public boolean verifyPayersDetailsOnThePage(WebDriver driver,EncounterPage encounterPage,HomeLib payerData,HomeLib patientData)
      {
 	try{
 		encounterPage.verifyPayersDetailsOnThePage(driver, payerData,patientData);
 		waitForPageLoad(driver);
   	}
 	catch(Exception e)
 	{
 		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
 	}
 	return true;
      }
     
     
      public DemographicsPage goToPatientRegistration(WebDriver driver) throws Exception {
    	    try {

    	        assertTrue(click(driver, lnkPatientOptions),
    					"Could not click Patient options", driver, className,
    					methodName);
    			waitForPageLoad(driver);
    			assertTrue(click(driver, patientViewReg),
    					"Could not click on Pateint View Registration", driver, className,
    					methodName);
    			waitForPageLoad(driver);
    		} catch (RuntimeException e) {
    			e.printStackTrace();
    	    }
    	    return  new DemographicsPage();		
    	}

      /**
       * uploadImageInEncounter
  		 * Function to upload Image In Encounter 
  		 * @param 	driver
  		 * @param   encounterTemplateTestData
  	  	 * @throws Exception 
  		 * @since	May 18,2015
  		 * @Version 2.1
  		 */ 
      public boolean uploadImageInEncounter(WebDriver driver, ClinicalSettingLib encounterTemplateTestData,EncounterPage encounterPage)
      {
    	  try{
    		  encounterPage.uploadImageInEncounter(driver, encounterTemplateTestData);
   			  waitForPageLoad(driver);
 	  }
  	catch(Exception e)
  	{
  		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
  	}
		return true;
    }

      /**
       * deleteUploadedImageInEncounter
  		 * Function to delete the uploaded Image In Encounter 
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 18,2015
  		 * @Version 2.1
  		 */ 
      public boolean deleteUploadedImageInEncounter(WebDriver driver,EncounterPage encounterPage)
      {
      	try{
      		encounterPage.deleteUploadedImageInEncounter(driver);
 			waitForPageLoad(driver);
      	}
      	catch(Exception e)
      	{
      		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
      	}
  		return true;
      }

      /**
       * getImageDimension
  		 * Function to compare Deleted And Newly Uploaded image
  		 * @param 	driver
       * @param dimesions 
  	  	 * @throws Exception 
  		 * @since	May 18,2015
  		 * @Version 2.1
  		 */ 
      public Dimension getImageDimension(WebDriver driver, Dimension dimesions,EncounterPage encounterPage)
      {
      	try{
     		   dimesions=encounterPage.getImageDimension(driver, dimesions);
     		   waitForPageLoad(driver);

      	}
      	catch(Exception e)
      	{
      		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
      	}
 			return dimesions;
      }

      /**
       * verifyNewlyUploadedImage
  		 * Function to verify Newly Uploaded Image 
  		 * @param 	driver
  	  	 * @throws Exception 
  		 * @since	May 18,2015
  		 * @Version 2.1
  		 */ 
      public boolean verifyNewlyUploadedImage(WebDriver driver, Dimension dimension1, Dimension dimension2,EncounterPage encounterPage)
      {
      	try{
      		encounterPage.verifyNewlyUploadedImage(driver, dimension2, dimension2);
      		waitForPageLoad(driver);
      	}
      	catch(Exception e)
      	{
      		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
      	}
  		return true;
      }

  	/**
  	 * createAllergyEndToEnd
  	 * function to create Allergy
  	 * @param allergyData
  	 * @param driver
  	 * @param account
  	 * @throws Exception 
  	 * @since May 21, 2015
  	 */
  	public boolean createSummaryAllergyEndToEnd(WebDriver driver,ChartPreVisitLib allergyData, String account, AllergyPage allergyPage) throws Exception {
  		try {
  			allergyPage.createAllergyEndToEnd(driver, allergyData, account);
          	waitForPageLoad(driver);
          	}
          	catch(Exception e)
          	{
          		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
          	}
          	return true;
          }

  	/**
  	 * createEncounterAllergyEndToEnd
  	 * function to create Allergy
  	 * @param allergyData
  	 * @param driver
  	 * @param account
  	 * @throws Exception 
  	 * @since May 21, 2015
  	 */
  	public boolean createEncounterAllergyEndToEnd(WebDriver driver,ChartPreVisitLib allergyData, String account, AllergyPage allergyPage,EncounterPage encounterPage) throws Exception {
  		try {
  			encounterPage.createAllergyEndToEnd(driver, allergyData, account, allergyPage);
          	waitForPageLoad(driver);
          	}
          	catch(Exception e)
          	{
          		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
          	}
          	return true;
          }

	/**
	 * addAllergy
	 * function to Add Allergy
	 * @param driver
	 * @throws Exception 
	 * @since May 21, 2015
	 */
	public boolean addAllergy(WebDriver driver, AllergyPage allergyPage) throws Exception {
		try {
			allergyPage.addAllergy(driver);
			waitForPageLoad(driver);
		}
		catch (RuntimeException e) {
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}
		return true;
	}

	/**
	 * saveAllergy
	 * function to Add Allergy
	 * @param driver
	 * @throws Exception 
	 * @since May 21, 2015
	 */
	public boolean saveAllergy(WebDriver driver, AllergyPage allergyPage) throws Exception {
		try {
			allergyPage.saveAllergy(driver);
			waitForPageLoad(driver);
		}
		catch (RuntimeException e) {
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}
		return true;
	}

	/**
	 * clickEditAllergy
	 * function to  Click Edit button
	 * @since May 21, 2015
	 * @version 2.1
	 */
	public boolean clickEditAllergy(AllergyPage allergyPage)
	{
		try{
			allergyPage.clickEditAllergy();
			waitForPageLoad(driver);
		}	
		catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}

	/**
	 * clickSaveEditAllergy 
	 * function to a Click Save button
	 * @param driver
	 * @since May 21, 2015
	 * @version 2.1
	 */
	
	public boolean clickSaveEditAllergy(WebDriver driver, AllergyPage allergyPage)
	{
		try{
			allergyPage.clickSaveEditAllergy(driver);
			waitForPageLoad(driver);
		}catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}

	/**
	 * createSummaryFamilyHistory 
	 * function to create FamilyHistory From Summary
	 * @param driver
	 * @param historyData
	 * @throws IOException 
	 * @since May 21, 2015
	 */
	public boolean createSummaryFamilyHistory(WebDriver driver, ChartPreVisitLib historyData, FamilyHistoryPage familyHistoryPage) throws IOException {
		try {
			familyHistoryPage.createFamilyHistory(driver, historyData);
			waitForPageLoad(driver);
		}catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}

	/**
	 * createEncounterFamilyHistory 
	 * function to create FamilyHistory from Encounter
	 * @param driver
	 * @param historyData
	 * @throws IOException 
	 * @since May 21, 2015
	 */
	public boolean createEncounterFamilyHistory(WebDriver driver, ChartPreVisitLib historyData, FamilyHistoryPage familyHistoryPage, EncounterPage encounterPage) throws IOException {
		try {
			encounterPage.createFamilyHistory(driver, historyData, familyHistoryPage);
        	waitForPageLoad(driver);
    	}
    	catch(Exception e)
    	{
    		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", driver, className, methodName);
    	}
    	return true;
    }

	/**
	 * addFamilyHistory
	 * function to Add FamilyHistory
	 * @param driver
	 * @throws Exception 
	 * @since May 21, 2015
	 */
	public boolean addFamilyHistory(WebDriver driver, FamilyHistoryPage familyHistoryPage) throws Exception {
		try {
			familyHistoryPage.addFamilyHistory(driver);
			waitForPageLoad(driver);
		}
		catch (RuntimeException e) {
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}
		return true;
	}

	/**
	 * saveAddedFamilyHistory
	 * function to Save Added Family History
	 * @param driver
	 * @throws Exception 
	 * @since May 21, 2015
	 */
	public boolean saveAddedFamilyHistory(WebDriver driver, FamilyHistoryPage familyHistoryPage) throws Exception {
		try {
			familyHistoryPage.saveAddedFamilyHistory(driver);
			waitForPageLoad(driver);
		}
		catch (RuntimeException e) {
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}
		return true;
	}

	/**
	 * clickEditFamilyHistory
	 * function to  Click Edit button
	 * @since May 21, 2015
	 * @version 2.1
	 */
	public boolean clickEditFamilyHistory(FamilyHistoryPage familyHistoryPage)
	{
		try{
			familyHistoryPage.clickEditFamilyHistory();
			waitForPageLoad(driver);
		}	
		catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}

	/**
	 * clickSaveEditFamilyHistory 
	 * function to a Click Save button
	 * @param driver
	 * @since May 21, 2015
	 * @version 2.1
	 */
	
	public boolean clickSaveEditFamilyHistory(WebDriver driver, FamilyHistoryPage familyHistoryPage)
	{
		try{
			familyHistoryPage.clickSaveEditFamilyHistory(driver);
			waitForPageLoad(driver);
		}catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}

	/**
	 * verfiyFamilyHistoryInSummary 
	 * function to verfiy FamilyHistory In Summary
	 * @param driver
	 * @since May 21, 2015
	 * @version 2.1
	 */
	
	public boolean verfiyFamilyHistoryInSummary(WebDriver driver, ChartPreVisitLib historyData)
	{
		try{
			assertTrue(isTextPresent(driver,historyData.medical),"medical not present",driver, className, methodName);
			assertTrue(isTextPresent(driver,historyData.relation.toUpperCase()),"relation not present",driver, className, methodName);
			assertTrue(isTextPresent(driver,historyData.age),"Onset age not present",driver, className, methodName);
			verifyTrue(click(driver, lnkFamilyHistoryCollapse), "lnkFamilyHistoryCollapse button not found", driver);
			waitForPageLoad(driver);
			assertTrue(isTextPresent(driver,historyData.diagnosis),"diagnosis not present",driver, className, methodName);
			assertTrue(isTextPresent(driver,historyData.lifeStage),"lifeStage not present",driver, className, methodName);
			if (historyData.cause.equals("yes")) {
			assertTrue(isTextPresent(driver,historyData.ageAtDeath),"ageAtDeath not present",driver, className, methodName);
			}
			assertTrue(isTextPresent(driver,historyData.treatment),"treatment not present",driver, className, methodName);
			assertTrue(isTextPresent(driver,historyData.comment),"comment not present",driver, className, methodName);
			waitForPageLoad(driver);
		}catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}

	/**
	 * goToInjection
	 * function to go to Injection
	 * @param driver
	 * @since  	May 21, 2015
	 * @version 2.1
	 */		   
   public InjectionPage goToInjection(WebDriver driver)
    {
	   try{
	   click(lnkInjection);
	   waitForPageLoad(driver);
	   }
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}
	   return new InjectionPage();
    }
   
   /**
    * createEncounterInjectionEndToEnd
    * Function to Navigate To Injection of Encounter Page
    * @param 	driver
    * @param ChartPreVisitLib data- proData
    * @param account
    * @param InjectionPage
    * @param encounterPage
    * @throws Exception 
    * @since	May 21,2015
    * @version 2.1
    */  
   public boolean createEncounterInjectionEndToEnd(WebDriver driver,ChartPreVisitLib proData, String account, InjectionPage injectionPage,EncounterPage encounterPage)
   {
   try{
   	encounterPage.createEncounterInjectionEndToEnd(driver, proData, account, injectionPage);
   } catch (Exception e) {
   	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
   }

   return true;
   }
   
   /**
    * clickSaveEditInjection function to a Click Add button
    * @param driver
    * @param injectionPage
    * @since  	@since March 12, 2015
    * @version 2.1
    */

   public boolean clickSaveEditInjection(WebDriver driver, InjectionPage injectionPage)
   {
   	try{
   	injectionPage.clickSaveInjection(driver);
   	waitForPageLoad(driver);
   	waitForPageLoad(driver);
   	waitForPageLoad(driver);
   } catch (Exception e) {
   	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
   }

   	return true;
   }
   
   /**
    * createInjectionEndToEnd function to  create Injection
    * @param driver,ChartPreVisitLib- Data for Injection, ProblemListPage object, User Account
    * @since  	@since May 21, 2015
    * @version 2.1
    */

   public boolean createInjectionEndToEnd(WebDriver driver,ChartPreVisitLib proData, String account, InjectionPage injectionPage)   {
   try {
   	injectionPage.createInjection(driver,proData,account);
   	waitForPageLoad(driver);
    }
   	catch (Exception e) {
   		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
   }

   	return true;
   }
   /**
    * saveSummaryInjection function to a save Created Injection
    * @param driver,ChartPreVisitLib- Data for Injection, InjectionPage object
    * @since May 21, 2015
    * @version 2.1
    */

   public boolean saveSummaryInjection(WebDriver driver,InjectionPage injectionPage)
   {
   	try{
   		injectionPage.saveSummaryInjection(driver);
   	}	catch (Exception e) {
   		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
   }
   	return true;
   }
   
	/**
	 * clickSaveEditProblemList function to a Click Add button
	 * @param driver
	 * @since March 12, 2015
	 * @version 2.1
	 */
	
	public boolean clickSaveInjection(WebDriver driver,InjectionPage injectionPage)
	{
		try{
	   		injectionPage.clickSaveInjection(driver);
			waitForPageLoad(driver);
		}catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}

   /**
    * verifyInjectionInSummary function to a save Created Injection
    * @param driver, account,ChartPreVisitLib- Data for Injection, Injection object
    * @since May 21, 2015
    * @version 2.1
    */

   public boolean verifyInjectionInSummary(WebDriver driver,ChartPreVisitLib proData,String account)
   {
   	try{
   	String date ="";
   	assertTrue(click(driver,injectionArrowExpand),"unable to click the arrow expandor",driver,className,methodName);
   	waitForPageLoad(driver);
   	waitForPageLoad(driver);
   	assertTrue(isTextPresent(driver, proData.injection),"lifeStage not found",driver,className,methodName);
   	assertTrue(isTextPresent(driver, proData.lotNumber),"lifeStage not found",driver,className,methodName);
   	assertTrue(isTextPresent(driver, proData.dosage),"lifeStage not found",driver,className,methodName);
   	assertTrue(isTextPresent(driver, proData.dosageUnit),"lifeStage not found",driver,className,methodName);
   	if (account.equals(Constants.CAACCOUNT)) {
   		Calendar cal = Calendar.getInstance();
   		SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
   		date = DateFormat.format(cal.getTime());
   	    assertTrue(isTextPresent(driver,date),"date not found",driver,className,methodName);
   	} else {
   		Calendar cal1 = Calendar.getInstance();
   		SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
   		date = DateFormat.format(cal1.getTime());
   	    assertTrue(isTextPresent(driver, date),"date not found",driver,className,methodName);  
   	}
   	assertTrue(isTextPresent(driver, proData.reaction),"lifeStage not found",driver,className,methodName);
   	assertTrue(isTextPresent(driver, proData.verifyCpt1),"lifeStage not found",driver,className,methodName);
   	assertTrue(isTextPresent(driver, proData.verifyCpt2),"lifeStage not found",driver,className,methodName);
   	}
   	catch (Exception e) {
   		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
   }

   	return true;	
   }

/**
 * clickEditInjection function to a Click Edit button
 * @param injectin 
 * @since May 21, 2015
 * @version 2.1
 */

public boolean clickEditInjection(WebDriver driver,InjectionPage injectionPage)
{
try{
	injectionPage.clickEditInjection(driver);
} catch (Exception e) {
	new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	return true;
}

/**
 * goToEncounterInjection
 * Function to Navigate To Injection of Encounter Page
 * @param 	driver
 * @param encounterPage
 * @throws Exception 
 * @since	May 21,2015
 * @version 2.1
 */  
public InjectionPage goToEncounterInjection(WebDriver driver,EncounterPage encounterPage)
{
 try{
	 injectionPage=encounterPage.goToEncounterInjection(driver);
  }catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
  }
   return injectionPage;
}

/**
 * addEncounterSocialHistory function to a Click Add button
 * @param driver,	socialHistoryPage
 * @since May 22, 2015
 * @version 2.1
 */

public boolean addEncounterSocialHistory(WebDriver driver)
{
	try{
		verifyTrue(click(driver, btnAdd), "Social History Add button not found ", driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
	}catch(Exception e){
	       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
	}  
	return true;
}

/**
 * clickEditProcedure
 * function to edit Procedure 
 * @throws Exception 
 * @since May 22, 2015
 * @version 2.1
 */
public boolean clickEditProcedure(ProcedurePage procedurePage){
	procedurePage.clickEditProcedure();
	return true;
}

/**
 * saveEditededProcedure
 * function to add Procedure 
 * @throws Exception 
 * @since May 22, 2015
 * @version 2.1
 */

public boolean saveEditededProcedure(ProcedurePage procedurePage){
	procedurePage.saveEditededProcedure();
	return true;
}

/**
 * saveAddedProcedure
 * function to add Procedure 
 * @throws Exception 
 * @since May 22, 2015
 * @version 2.1
 */

public boolean saveAddedProcedure(ProcedurePage procedurePage){
	procedurePage.saveAddedProcedure();
	return true;
}

/**
 * clickAddProcedure
 * function to add Procedure 
 * @throws Exception 
 * @since May 22, 2015
 * @version 2.1
 */

public boolean clickAddProcedure(ProcedurePage procedurePage){
	procedurePage.clickAddProcedure();
	return true;
}

/**
 * verifyProcedureInSummary 
 * function to a verify Procedure In Summary
 * @param driver, account,ChartPreVisitLib- Data for Procedure
 * @since May 22, 2015
 * @version 2.1
 */

public boolean verifyProcedureInSummary(WebDriver driver,ChartPreVisitLib proData,String account)
{
	try{
		String date="";
	assertTrue(isTextPresent(driver, proData.proName),"Procedure name not found",driver,className,methodName);
	assertTrue(isTextPresent(driver, proData.comment),"comment not found",driver,className,methodName);
   	if (account.equals(Constants.CAACCOUNT)) {
   		Calendar cal = Calendar.getInstance();
   		SimpleDateFormat DateFormat = new SimpleDateFormat("MMM dd, yyyy");
   		date = DateFormat.format(cal.getTime());
   	    assertTrue(isTextPresent(driver,date),"date not found",driver,className,methodName);
   	} else {
   		Calendar cal1 = Calendar.getInstance();
   		SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
   		date = DateFormat.format(cal1.getTime());
   	    assertTrue(isTextPresent(driver, date),"date not found",driver,className,methodName);  
   	}
	verifyTrue(click(driver, lnkProcedureCollapse), "lnkProcedureCollapse button not found", driver);
	}
	catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
	return true;	
}


}
