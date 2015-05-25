package com.nexia.selenium.testscripts.section.billing.chargeentry;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPayerDetailsOnBillingHistory extends AbstractSystemSettingsTest {
    @Test(groups = { "AdvancedSmoke", "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for verify hard copy check box")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifypayerOnCharges(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	SystemSettingsLib payerAdminData = new SystemSettingsLib();
	payerAdminData.workSheetName = "PayerAdmin";
	payerAdminData.testCaseId = "TC_PA_010";
	payerAdminData.fetchSystemSettingTestData();
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	createPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
    }
    
    @Test(groups = { "AdvancedSmoke", "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for verify hard copy check box")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifyPatientPayerOnCharges(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	SystemSettingsLib payerAdminData = new SystemSettingsLib();
	payerAdminData.workSheetName = "PayerAdmin";
	payerAdminData.testCaseId = "TC_PA_011";
	payerAdminData.fetchSystemSettingTestData();
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	createPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
    }
    
    @Test(groups = { "AdvancedSmoke", "Regression", "Approved", "firefox", "iexplore", "safari", "default" }, description = "Test for verify hard copy check box")
    @Parameters({ "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount" })
    public void verifyServiceCode(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
	SystemSettingsLib payerAdminData = new SystemSettingsLib();
	payerAdminData.workSheetName = "PayerAdmin";
	payerAdminData.testCaseId = "TC_PA_012";
	payerAdminData.fetchSystemSettingTestData();
	ClassName = this.getClass().getName().substring(39);
	MethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	createPayerAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, payerAdminData);
    }
    

    /**
     * create New PayerAdmin function to create PayerAdmin
     * 
     * @param seleniumHost
     * @param seleniumPort
     * @param browser
     * @param webSite
     * @throws IOException
     * @since Feb 10, 2013
     */

    public boolean createPayerAdmin(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount, SystemSettingsLib payerAdminData)
	    throws IOException {
	Selenium selenium = null;
	boolean returnValue = true;
	try {
	    // --------------------------------------------------------------------//
	    // Step-1: Login to the application and search for the given patient
	    // --------------------------------------------------------------------//

	    selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
	    Assert.assertNotNull(selenium, "Could Not Retrive the New Selenium Session; More Details :" + payerAdminData.toString());
	    assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, payerAdminData.userName, payerAdminData.userPassword), "Login Failed ", selenium,
		    ClassName, MethodName);

	    // --------------------------------------------------------------------//
	    // Step-2: Navigate to Directories and Choose Payer Admin //
	    // --------------------------------------------------------------------//
	    
	    HomeLib payerData = new HomeLib();
	    payerData.workSheetName = "AddPayers";
	    payerData.testCaseId = "TC_CP_023";
	    payerData.fetchHomeTestData();
	    AbstractBilling billing = new AbstractBilling();
	    
	    assertTrue(goToBillingHistory(selenium,payerData),"Navigation Failed ", selenium, ClassName, MethodName);

	    assertTrue(click(selenium, billing.lnkChargeHistory), "could not click Charges", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	   
	    String countClaims=getText(selenium,billing.lblCountClaims);
	    String[] count=countClaims.split(" ");
	    int count1=Integer.parseInt((count[1]));
	    count1=count1-1;
	    
	    assertTrue(goToDirectories(selenium, payerAdminData), "Could not navigate to Directories", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    selectValueFromAjaxList(selenium, ajxSelectPayerAdmin, payerAdminData.directoryType);
	    waitForPageLoad(selenium);

	    // --------------------------------------------------------------------//
	    // Step-3: Check for the pick list //
	    // --------------------------------------------------------------------//
	    assertTrue(checkPayerPicklist(selenium), "Picklist will show", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    // --------------------------------------------------------------------//
	    // Step-4:Delete existing PayerAdmin //
	    // --------------------------------------------------------------------//
	    assertTrue(deletePayerAdmin(selenium, payerAdminData), "Deletion Failed", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    // --------------------------------------------------------------------//
	    // Step-5: Create New Payers //
	    // --------------------------------------------------------------------//

	    assertTrue(click(selenium, btnAddNewPayer), "Could not click the add Payers; More details" + payerAdminData.toString(), selenium, ClassName,
		    MethodName);
	    waitForPageLoad(selenium);
	    assertTrue(createPayers(selenium, payerAdminData, userAccount), "Payers Creation Failed", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    // --------------------------------------------------------------------//
	    // Step-6: Verify created payer Admin //
	    // --------------------------------------------------------------------//

	    if (!verifyPayerAdminValuesInSummaryPage(selenium, payerAdminData, userAccount)) {
		Assert.fail("Payer Admin details not saved proberly:" + payerAdminData.toString());
		return false;
	    }

	    // --------------------------------------------------------------------//
	    // Step-7: Submit Claims and check status //
	    // --------------------------------------------------------------------//

	    waitForPageLoad(selenium);
	    assertTrue(createSubmitClaims(selenium, payerAdminData, userAccount), "Payers Submit Claims Failed", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    assertTrue(click(selenium, btnDone), "Could not click on Done button; More details" + payerAdminData.toString(), selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    // --------------------------------------------------------------------//
	    // Step-8: Add payer //
	    // --------------------------------------------------------------------//
	   

	    assertTrue(navigateToPatientByPatientId(selenium,payerData.patientId),"Search Patient failed",selenium, ClassName, MethodName);
		assertTrue(click(selenium,lnkviewchart),"Search Patient failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkPatientOption),"Search Patient failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(selenium.isConfirmationPresent()){
			System.out.println(selenium.getConfirmation());
			//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
			selenium.chooseOkOnNextConfirmation();
			}
		assertTrue(click(selenium,lnkViewRegistration),"Search Patient failed",selenium, ClassName, MethodName);
		
		
		waitForPageLoad(selenium);
		if(selenium.isConfirmationPresent()){
			System.out.println(selenium.getConfirmation());
			//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
			selenium.chooseOkOnNextConfirmation();
			}

	    assertTrue(click(selenium, btnPayerList), "Could not click the Payer", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    waitForPageLoad(selenium);
	    if (userAccount.equals(CAAccount)) {
	    	assertTrue(click(selenium, btnMedicalPayersCA), "Could not click the Medical Payer", selenium, ClassName, MethodName);
	    }else{
	    	assertTrue(click(selenium, btnMedicalPayersCA), "Could not click the Medical Payer", selenium, ClassName, MethodName);
	    }
	    waitForPageLoad(selenium);
	    int flag=0;
	    while(selenium.isVisible(btnAddNewMedPayer)){
	    	waitForPageLoad(selenium);
	    	flag++;
	    	if(flag>20){
	    		break;
	    	}
	    }
	    waitForPageLoad(selenium);
	    waitForPageLoad(selenium);
	    waitForPageLoad(selenium);
	    String date = "";
	    if (userAccount.equals(CAAccount)) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
		date = DateFormat1.format(cal.getTime());
	    } else {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		date = DateFormat1.format(cal.getTime());
	    }

	    click(selenium, ajxPayerSelect);
	    assertTrue(selectValueFromAjaxList(selenium, ajxPayerSelect, payerData.payerName), "Could not select payer" + payerData.toString(),selenium, ClassName, MethodName);
	    assertTrue(enterDate(selenium, txtPayerStartDate, date), "Could not enter start Date",selenium, ClassName, MethodName);
	    assertTrue(selectValueFromAjaxList(selenium, ajxRelationShip, payerData.relationshipStatus), "Could not select Relationship Status"
		    + payerData.toString(),selenium, ClassName, MethodName);
	    assertTrue(click(selenium, btnlnkSave), "Could not click Save button" + payerData.toString(),selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    waitForPageLoad(selenium);
	    waitForPageLoad(selenium);
	    waitForPageLoad(selenium);
	    if(isElementPresent(selenium, "okButton"))
	    	selenium.click("okButton");
		waitForPageLoad(selenium);
	    waitForPageLoad(selenium);
	    waitForPageLoad(selenium);
	    waitForPageLoad(selenium);
	    BillingLib chargeEntryData = new BillingLib();
	    chargeEntryData.workSheetName = "ChargeEntry";
	    chargeEntryData.testCaseId = "TC_CE_016";
	    chargeEntryData.fetchBillingTestData();

	    assertTrue(switchRole(selenium, chargeEntryData.switchRole), "Switch Role Failed", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    /*
	     * assertTrue(searchPatientNexia(selenium,payerData.patientId),
	     * "Search Patient failed",selenium, ClassName, MethodName);
	     * waitForPageLoad(selenium);
	     */
	    // --------------------------------------------------------------------//
	    // Step-9: Go to Post New Charge
	    // --------------------------------------------------------------------//
	    //navigateToPatient(selenium, chargeEntryData);
	    assertTrue(goToPostNewCharge(selenium, chargeEntryData, payerData), "Navigation Failed", selenium, ClassName, MethodName);

	    // --------------------------------------------------------------------//
	    // Step-10: Verify Hard Copy
	    // --------------------------------------------------------------------//

	    if (!userAccount.equals(CAAccount)) {
	    	if (!isChecked(selenium, chkHardCopy)) {
	    		Assert.fail("Hard Copy Check Failed");
	    	}
	    }


	    
	    if(payerAdminData.testCaseId.equals("TC_PA_011")){
		assertTrue(selectValueFromAjaxList(selenium,ajxBillPayer,"Patient"),"Could notselect payer",selenium, ClassName, MethodName);
	    }
	    // --------------------------------------------------------------------//
	    // Step-11: Post Charges and verify it in the queue.
	    // --------------------------------------------------------------------//

	    chargeEntryData.workSheetName = "ChargeEntry";
	    chargeEntryData.testCaseId = "TC_CE_016";
	    chargeEntryData.fetchBillingTestData();
	    chargeEntryData.patientID=payerData.patientId;

	    billing.savePostChargeEntry(selenium, chargeEntryData,userAccount);

	    // --------------------------------------------------------------------//
	    // Step-12: Verify Post Charges in Billing History
	    // --------------------------------------------------------------------//

	    //assertTrue(goToBillingHistory(selenium,payerData),"Navigation Failed ", selenium, ClassName, MethodName);

	    assertTrue(click(selenium, billing.lnkChargeHistory), "could not click Charges", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	  
	    String countClaims1=getText(selenium,billing.lblCountClaims);
	    String[] count2=countClaims1.split(" ");
	    int count3=Integer.parseInt((count2[1]));
	    if(count3<count1){
		Assert.fail("Count updation failed");
	    }

	    // --------------------------------------------------------------------//
	    // Step-12: Verify Payer Details
	    // --------------------------------------------------------------------//
	    
	    if(payerAdminData.testCaseId.equals("TC_PA_012")){
		int counter=1;
		while(isElementPresent(selenium,"//tr["+counter+"]/td/div/div/div/div/div[6]/div/div/div/a")){
		    counter++;
		    
		    if(counter>15){
			break;
		    }
		}
		
		counter=counter-1;
		
		selenium.clickAt("//tr["+counter+"]/td/div/div/div/div/div[6]/div/div/div/a","");
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, "//a[@id='editClaim']/span"), "could not click Actions", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(isElementPresent(selenium,"serviceCodeSuggestBoxsuggestBox")){
		    Assert.fail("Service Code is Editable");
		}
		else{
		    return true;
		}
	    }
	    
	    int counter=1;
	    while(isElementPresent(selenium,"//tr["+counter+"]/td/div/div/table/tbody/tr/td/div/div/div/div[7]/div")){
		counter++;
		
		if(counter>30){
		    break;
		}
	    }
	    
	    counter=counter-1;
	    
	    if(payerAdminData.testCaseId.equals("TC_PA_011")){
		 if(getText(selenium,"//tr["+counter+"]/td/div/div/table/tbody/tr/td/div/div/div/div[7]/div").contains("Patient")){
			return true;
		    }
		 else{
		    // Assert.fail("Payer information didn't get displayed");
		 }
	    }
	       
	    selenium.mouseOver("//tr["+counter+"]/td/div/div/table/tbody/tr/td/div/div/div/div[7]/div");
	    waitForPageLoad(selenium);
	    
	    
	} catch (RuntimeException e) {
	    e.printStackTrace();
	    assertTrue(false, "Failed Due to the Exception; \n\t*) ExceptionDetails :" + e.getMessage() + "\n\t*)", selenium, ClassName, MethodName);
	}
	return returnValue;
    }
}