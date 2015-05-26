package com.projectname.testutils.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.Constants;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class DiagnosticImagingPage extends SeleniumWebDriver{

	public  DiagnosticImagingPage() {
        PageFactory.initElements(TestBaseClass.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	
	private static By readyLocator = By.id("labTestNameSuggestBox");
	private By ajxSearch = By.id("labTestNameSuggestBox");
	private By txtComments = By.id("comments");
	private By chkUrgent = By.id("urgentcheckbox");
	private By ajxSendTo = By.xpath("(//input[@id='suggestBox'])[2]");
	private By ajxProviderSearch = By.id("providerListSuggestBoxsuggestBox");
	private By ajxLocation = By.id("locationListSuggestBoxsuggestBox");
	private By txtNotifyMeIn = By.id("durationsuggestBox");
	private By ajxDuration = By.id("durationUnitsuggestBox");
	private By txtAuthorization = By.id("authorization");
	private By btnsave = By.id("saveDiagnosticImaging");
	
	
	/**
	 * createDIReport 
	 * function to a create DI Report
	 * @param driver,ChartPreVisitLib- Data for DI,userAccount
	 * @since May 26, 2015
	 * @version 2.1
	 */

	public boolean createDIReport(WebDriver driver,ChartPreVisitLib proData, String account)   {
		try {
			waitForPageLoad(driver);

			if (!proData.medicalCondition1.equals("")){
				verifyTrue(selectValueFromAjaxList(driver, ajxSearch,proData.lifeStage), "ajxSearch not found", driver);
				waitForPageLoad(driver);
			}
			
			if (!proData.itemStatus.equals("")){
				verifyTrue(type(driver, txtComments, proData.comment), "comment not found", driver);
			waitForPageLoad(driver);
			}

			if (!proData.showAllDetails.equals("")){
				verifyTrue(click(driver, chkUrgent), "chkUrgent not found", driver);
			waitForPageLoad(driver);
			}

			if (!proData.lifeStage.equals("")){
				verifyTrue(selectValueFromAjaxList(driver, ajxSendTo,proData.lifeStage), "ajxSendTo not found", driver);
				waitForPageLoad(driver);
			}

			if (!proData.lifeStage.equals("")){
				verifyTrue(selectValueFromAjaxList(driver, ajxProviderSearch,proData.lifeStage), "Provider Search Box not found", driver);
				waitForPageLoad(driver);
			}

			if (!proData.lifeStage.equals("")){
				verifyTrue(selectValueFromAjaxList(driver, ajxLocation,proData.lifeStage), "ajxLocation not found", driver);
				waitForPageLoad(driver);
			}

			if (!proData.lifeStage.equals("")){
				verifyTrue(selectValueFromAjaxList(driver, txtNotifyMeIn,proData.lifeStage), "txtNotifyMeIn not found", driver);
				waitForPageLoad(driver);
			}

			if (!proData.lifeStage.equals("")){
				verifyTrue(selectValueFromAjaxList(driver, ajxDuration,proData.lifeStage), "ajxDuration not found", driver);
				waitForPageLoad(driver);
			}
			
			if (!proData.comment.equals("")){
				verifyTrue(type(driver, txtAuthorization, proData.comment), "txtAuthorization not found", driver);
				waitForPageLoad(driver);
			}
			
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
	
	public boolean clickSaveDI(WebDriver driver)
	{
		try{
		verifyTrue(click(driver, btnsave), "Save not found", driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}
		return true;
	}

}
