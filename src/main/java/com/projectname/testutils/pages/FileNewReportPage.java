package com.projectname.testutils.pages;

import java.io.IOException;
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

public class FileNewReportPage extends SeleniumWebDriver{

	
	public  FileNewReportPage() {
		PageFactory.initElements(TestBaseClass.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	private static By readyLocator = By.linkText("Enter data »");

	private By lnkEnterData = By.xpath("(//a[starts-with(text(),'Enter data')])");
	private By lnkTopMenu=By.id("username");
	private By ajxRProvider = By.id("receivingProviderSuggestsuggestBox");
	private By ajxOProvider = By.id("orderingProviderSuggestsuggestBox");
	private By ajxLabName = By.id("reportingLabSuggestsuggestBox");
	private By elementCdate = By.id("collectionDateBox");
	private By elementCtime = By.id("timeTextBox");
	private By elementResult = By.id("resultTextBox");
	private	By ajxLabTestName = By.id("testNameSuggestsuggestBox");
	private By btnSave2 = By.id("save");
	private By btnContinue =By.id("Continue");



	
	/**
	 * fileReportWithMandatory function to file Report With Mandatory
	 * @throws IOException 
	 * @throws ExceptionHandler 
	 * 
	 * @since Mar 20, 2015
	 */
	public boolean fileReportWithMandatory(WebDriver driver, ChartPreVisitLib labData, String account) throws IOException, ExceptionHandler {
		
		try{
		String date = null;
		if (account.equals(Constants.CAACCOUNT)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = DateFormat.format(cal.getTime());

		} else {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat.format(cal.getTime());

		}			
		verifyTrue(click(driver, lnkEnterData),	"Could not find enter data link",driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		if(isElementPresent(driver,btnContinue)){
			waitForPageLoad(driver);
			click(driver,btnContinue);
		}

		waitForPageLoad(driver);
		waitForPageLoad(driver);
		String str = getText(driver, lnkTopMenu);
		String Rprovider = str.replaceAll(", " + labData.switchRole, "");

		String tempArray[] = Rprovider.split(" ");
		String providerName = tempArray[1] + ", " + tempArray[0];

		verifyTrue(selectValueFromAjaxList(driver, ajxRProvider, providerName), "ajxRProvider not found ",driver);
		waitForPageLoad(driver);

		verifyTrue(selectValueFromAjaxList(driver, ajxOProvider, labData.oProvider), "ajxOProvider not found", driver);
		waitForPageLoad(driver);
		if(account.equals(Constants.CAACCOUNT)){
			verifyTrue(selectValueFromAjaxList(driver, ajxLabName, labData.labNameCA), "", driver);
		}else
			verifyTrue(selectValueFromAjaxList(driver, ajxLabName, labData.labName), "", driver);
		waitForPageLoad(driver);

		verifyTrue(	enterDate(driver, elementCdate, date),	"Could not enter the collrction Date;More Details:"	+ labData.toString(),driver);
		verifyTrue(type(driver, elementCtime, labData.cTime),
				"Could not type time",driver);
		verifyTrue(selectValueFromAjaxList(driver, ajxLabTestName, labData.testName), " ", driver);
		waitForPageLoad(driver);
		verifyTrue(type(driver, elementResult, labData.result),	"Could not type results",driver);
		waitForPageLoad(driver);

		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
}

		return true;

	}
	
	
	/**
	 * saveFileReport function to save file Report With Mandatory
	 * @throws IOException 
	 * @throws ExceptionHandler 
	 * 
	 * @since Mar 20, 2015
	 */
	public boolean saveFileReport(WebDriver driver) throws IOException, ExceptionHandler {
		
		try{
			verifyTrue(click(driver, btnSave2),	"Could not find save button",driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
		}
		
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}

		return true;

	}

}
