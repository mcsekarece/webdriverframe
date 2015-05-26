package com.projectname.testutils.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class PrescribeMedicationPage extends SeleniumWebDriver {

	private By readyLocator = By.id("locationListSuggestBoxsuggestBox");	
	private By ajxLoaction = By.id("locationListSuggestBoxsuggestBox");	
	private By ajxDrugsList = By.id("drugsQuicklistBox");	
	private By lnkEdit =By.linkText("Edit");	
	private By btnOverride = By.id("overrideButton");
	private By txtoveridereason=By.id("overrideReasonQuicklist");
	private By btnCancelButton = By.id("cancelButton");
	private By lnlEdit1 = By.xpath("(//a[contains(text(),'Edit')])[2]");
	private By btnBack=By.xpath("//img[@title='Patient']");
	private By chkOneTimeOnly =By.id("oneTimeOnlyIDcheckbox");
	private By chkFreeText = By.id("freeTextIDcheckbox");
	private By txtDirectionNotes = By.id("directionsNotesTextBoxId");
	private By txtDispense = By.id("dispenseID");
	private By ajxUnitList = By.id("unitListSuggestBoxsuggestBox");
	private By txtFillon = By.id("fillOnID");
	private By txtDurationNumber = By.id("durationNumberID");
	private By lnkNo = By.linkText("No");
	private By btnContinueId = By.id("continueID");
	private By btnEdit = By.id("edit");
	private By btnPrint = By.id("print");
	private By btnErrorClose = By.id("errorCloseButton");

	
	
	public PrescribeMedicationPage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	public boolean clickOnPrintPrescribeMedication (WebDriver driver) throws InterruptedException, AWTException
	{
		
		Thread.sleep(10000);
		Thread.sleep(20000);
		assertTrue(click(driver, btnPrint),"Could not click the Print button",driver, className, methodName);
		Thread.sleep(20000);
		Thread.sleep(20000);
		Robot rb =new Robot();			 
		// pressing keys with the help of keyPress and keyRelease events		
		rb.keyPress(KeyEvent.VK_ESCAPE);
		rb.keyRelease(KeyEvent.VK_ESCAPE);		
		Thread.sleep(2000);		
		if(isElementPresent(driver, btnErrorClose)) {
			
				assertTrue(click(driver, btnErrorClose),"could not click error close", driver, className,methodName);
		}
			return true;
	}
	
	/**
	 * SearchPrescribeMed function to SearchPrescribeMed
	 * @throws Exception 
	 * 
	 * @since Sep 12, 2012
	 */
	public boolean SearchPrescribeMed(WebDriver driver,ChartPreVisitLib prescribeData, String account) {
		waitForPageLoad(driver);
		assertTrue(selectValueFromAjaxList(driver, ajxLoaction, prescribeData.loaction),"Could not search the prescribe medication"+ prescribeData.toString(),driver, className, methodName);
		waitForPageLoad(driver);
		if (account.equals("CA2000"))	{
			assertTrue(selectValueFromAjaxList(driver, ajxDrugsList,prescribeData.prescribeCa),"Could not type Prescribe Medication;More Details:"+ prescribeData.toString(),driver, className, methodName);
			waitForPageLoad(driver);
		} else		{
			assertTrue(selectValueFromAjaxList(driver, ajxDrugsList,prescribeData.prescribe),"Could not type Prescribe Medication;More Details:"+ prescribeData.toString(),driver, className, methodName);
			waitForPageLoad(driver);
		}
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		if (isElementPresent(driver,btnBack )) {
			waitForPageLoad(driver);
			if(account.equalsIgnoreCase("CA2000")){
				assertTrue(click(driver, lnkEdit),"Could not click the Prescribe link;More Deatils:"+ prescribeData.toString(),driver, className, methodName);
			}
			else{
				assertTrue(click(driver, lnlEdit1),	"Could not click the Prescribe link;More Deatils:"+ prescribeData.toString(),driver, className, methodName);
			}
		} 
		else{
			waitForPageLoad(driver);
			assertTrue(click(driver, lnkEdit),"Could not click the Prescribe link;More Deatils:"+ prescribeData.toString(),driver, className, methodName);
		}
		waitForPageLoad(driver);
		if ((isElementPresent(driver, btnOverride))&&( isElementPresent(driver, btnCancelButton))){
			assertTrue(type(driver, txtoveridereason,prescribeData.loaction),"Could not type over ride reason Proceed Anyway button"+ prescribeData.toString(), driver, className, methodName);
			waitForPageLoad(driver);
			assertTrue(click(driver, btnOverride),"Could not Click Proceed Anyway button"+ prescribeData.toString(), driver, className, methodName);
			return true;

	}
		return true;
	}
	
	
	/**
	 * addPrescribeMedication function to add Prescribe Medication
	 * @throws Exception 
	 * @since Sep 12, 2012
	 */
	public boolean addPrescribeMedication(WebDriver driver,
			ChartPreVisitLib prescribeData, String account)  {
		String date = null;
		try {
			waitForPageLoad(driver);
			assertTrue(type(driver, txtDurationNumber, "2"),"Could not enter dispense;More Details:"
								+ prescribeData.toString(),driver, className, methodName);
	
					if (!isChecked(driver, chkOneTimeOnly))
					{						assertTrue(click(driver, chkOneTimeOnly),
								"Could not click the one time only check box;More Details:"
										+ prescribeData.toString(),driver, className, methodName);}
					if (prescribeData.freeText.equals("Yes"))
					{
						if (!isChecked(driver, chkFreeText)){
							assertTrue(click(driver, chkFreeText),
									"Could not click the Free text check box;More Details:"
											+ prescribeData.toString(),driver, className, methodName);
						assertTrue(
								type(driver, txtDirectionNotes,
										prescribeData.direction),
										"Could not enter the text;More Details:"
												+ prescribeData.toString(),driver, className, methodName);

					}
					}
		

					waitForPageLoad(driver);
					if (account.equals("CA2000")) {
						Calendar cal = Calendar.getInstance();				
						SimpleDateFormat dateFormat1 = new SimpleDateFormat(
								"dd/MM/yyyy");
						date = dateFormat1.format(cal.getTime());
					}
					else
					{
						Calendar cal = Calendar.getInstance();				
						SimpleDateFormat dateFormat1 = new SimpleDateFormat(
								"MM/dd/yyyy");
						date = dateFormat1.format(cal.getTime());
					}
					
					assertTrue(enterDate(driver, txtFillon, date),
							"Could not enter the Date;More Details:",driver, className, methodName);

					assertTrue(
							type(driver, txtDispense, prescribeData.dispense),
							"Could not enter dispense;More Details:"
							+ prescribeData.toString(),driver, className, methodName);
					waitForPageLoad(driver);
					if (account.equals("CA2000")) {
					selectValueFromAjaxList(driver, ajxUnitList,
							prescribeData.unitListCA);
					waitForPageLoad(driver);
					}
					else
					{
						selectValueFromAjaxList(driver, ajxUnitList,
								prescribeData.unitList);
						
					}

						if(isElementPresent(driver,lnkNo))
				{
					assertTrue(click(driver, lnkNo),
							"Could not click No button in dispense window;More Details:"
									+ prescribeData.toString(),driver, className, methodName);
				}

				assertTrue(click(driver, btnContinueId),
						"Could not click the Continue button;More Details:"
								+ prescribeData.toString(),driver, className, methodName);
				waitForPageLoad(driver);
		waitForPageLoad(driver);

				if (isElementPresent(driver, btnEdit)) {
					return true;
				} else {
					return false;
				}
				
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			return true;
		



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
}


