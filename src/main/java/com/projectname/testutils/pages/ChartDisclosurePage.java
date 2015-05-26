package com.projectname.testutils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class ChartDisclosurePage extends SeleniumWebDriver{

	
	public  ChartDisclosurePage() {
		PageFactory.initElements(TestBaseClass.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	private static By readyLocator = By.id("requestedBySuggestBoxsuggestBox");
	private By txtChartDLSInst=By.id("instructionsTextBoxId");
	private By ajxChartReqBy=By.id("requestedBySuggestBoxsuggestBox");
	private By ajxChartRepType=By.id("recipientTypeSuggestBoxsuggestBox");
	private By ajxChartDeliverryMethod=By.id("deliveryMethodSuggestBoxsuggestBox");
	private By ajxChartConsentName=By.id("consentNameSuggestBoxsuggestBox");
	private By ajxFirstchartItem=By.id("currentItem_1");
	private By btnCntnue=By.id("continue");
	private By chkinclude=By.id("includePartialChartradio");
	private By chkselectall=By.id("selectAllTimelinecheckbox");
	private By btninnercontin=By.id("continueButton");
	private By btnPrint=By.id("printButton");
	private By btnFrameclose=By.id("framePopupViewCloseButton");
	
	
	
	

	/**
	 * create chart disclose
	 * function to create chart disclose
	 * @param encounterPage- Page
	 * @since  	MAR 11,2015
	 * @version 2.1
	 */	
public boolean createchartdisclose(WebDriver driver,ChartPreVisitLib chartDisclosureData, String account)
{
	try{
				type(driver, txtChartDLSInst,
				chartDisclosureData.Instruction);
				selectValueFromAjaxList(driver, ajxChartReqBy,
				chartDisclosureData.Requestedby);
				selectValueFromAjaxList(driver, ajxChartRepType,
				chartDisclosureData.Recipienttype);
				selectValueFromAjaxList(driver, ajxChartDeliverryMethod,
				chartDisclosureData.Deliverymethod);
				webElementclick(driver,ajxChartConsentName);
				Thread.sleep(1000);
				click(driver,ajxFirstchartItem);
				click(driver,btnCntnue);
				waitForPageLoad(driver);
				click(driver,chkinclude);
				waitForPageLoad(driver);
				click(driver,chkselectall);
				waitForPageLoad(driver);
				click(driver,btninnercontin);
				waitForPageLoad(driver);	
				
	}
	catch(Exception e)
	
	{
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
	}
	return true;
}



/**
 *verify encounter details in chart disclose
 * verify encounter details in chart disclose
 * @param encounterPage- Page
 * @since  	MAR 11,2015
 * @version 2.1
 */	
public boolean verifyencounterdetailsinchartdisclose(WebDriver driver,ChartPreVisitLib chartDisclosureData, String account)
{
	try{
		
		click(driver,btnPrint);
		waitForPageLoad(driver);			
		waitForPageLoad(driver);		
		click(driver,btnFrameclose);
		waitForPageLoad(driver);				
	}
	catch(Exception e)
	{
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
	}
	return true;
}





































}
