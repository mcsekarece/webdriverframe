package com.projectname.testutils.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.Constants;
import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class ImmunizationPage extends SeleniumWebDriver{

	private By readyLocator = By.id("refusedByPatientcheckbox");

	private By lnkTopMenu= By.id("username");
	private By btnErrorClose=By.id("errorCloseButton");
	private By chkrefused = By.id("refusedByPatientcheckbox");
	private By ajxcanSuggestbox=By.xpath("(//input[@id='immunizationCanadianSuggestBox'])[2]");
	private By txtRefusedImmunization=By.xpath("(//input[@id='immunizationSuggestBox'])[2]");
	private By txtRefusedOndate= By.id("refusedOnDate");
	private By txtRefusedComment=By.xpath("(//textarea[@id='summaryComment'])[2]");
	private By chkadmin= By.id("administeredElsewherecheckbox");
	private By ajxcanSuggestbox1= By.id("immunizationCanadianSuggestBox");
	private By ajxImmunization= By.id("immunizationSuggestBox");
	private By txtadminOnDate= By.id("administeredOnDate");
	private By txtcomment= By.id("summaryComment");
	private By ajxVaccine= By.id("searchVaccineBox");
	private By txtLotNo = By.id("lotNumberBox");
	private By txtImmDosage = By.id("dosageValue");
	private By txtImmDosageUnit = By.id("dosagesuggestBox");
	private By txtexpiryDate = By.id("expiryDate");
	private By txtadminDate = By.xpath("(//input[@id='administeredOnDate'])[2]");
	private By ajxSeries1 = By.id("series1suggestBox");
	private By ajxSeries2 = By.id("series2suggestBox");
	private By ajxSite = By.id("sitesuggestBox");
	private By lnkImmShowMoreArrow = By.id("medicationsMoreDetails");
	private By ajxImmRoute = By.id("routesuggestBox");
	private By chkConsentBox = By.id("consentCheckBoxcheckbox");
	private By ajxConsentSuggest = By.id("consentsuggestBox");
	private By ajxadminsteredBy = By.id("administeredBy");
	private By ajxImmCpt1 = By.id("cpt1suggestBox");
	private By ajxImmCp2 = By.id("cpt2suggestBox");
	private By ajxImmreaction = By.id("reactionsuggestBox");
	private By txtImmComment = By.xpath("(//textarea[@id='summaryComment'])[3]");
	private By btnAdd = By.id("add");
	private By btnSaveEditImmunization = By.id("saveImmunizationEdit");
	private By btnSaveImmunization = By.id("saveImmunization");
	private By btnEdit = By.xpath("//a[contains(text(),'Edit')]");
	private By lnkEncounterImmunization = By.xpath("(//a[contains(text(),'Immunizations')])[2]");

	
	/***
	 * Call to super constructor
	 */
	public ImmunizationPage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}

	/**
	 * saveImmunization function to a click Save button
	 * @since  	@since March 24, 2015
	 * @version 2.1
	 */
	
	public boolean saveImmunization(WebDriver driver)
	{
		try{
		verifyTrue(click(driver, btnSaveImmunization), "Save button not found", driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}

		return true;
	}

	/**
	 * saveImmunizationEdit function to a click Save button
	 * @since  	@since March 24, 2015
	 * @version 2.1
	 */
	
	public boolean saveImmunizationEdit(WebDriver driver)
	{
		try{
		verifyTrue(click(driver, btnSaveEditImmunization), "Save button not found", driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}

		return true;
	}

	/**
	 * clickEditImmnization function to a Click Edit button
	 * @since  	@since March 24, 2015
	 * @version 2.1
	 */

	public boolean clickEditImmnization(WebDriver driver)
	{
		try{
			verifyTrue(click(driver, btnEdit), "edit button not found", driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
		}	
		catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}

	/**
	 * createImmunization function to a  create Immunization
	 * @param 	ChartPreVisitLib- Data for Immunization, Account
	 * @since  	@since March 16, 2015
	 * @version 2.1
	 */

	public boolean createImmunization(WebDriver driver,ChartPreVisitLib immunizationData, String account) throws IOException, ExceptionHandler {
		
		String providerNameTemp = getText(driver, lnkTopMenu);
		String providerName = providerNameTemp.replaceAll(", FULL", "");
		immunizationData.adminBy = providerName;
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
		try {
			if(isElementPresent(driver, btnErrorClose))
				verifyTrue(click(driver, btnErrorClose),"Could not click on Close Button",driver);

			if (immunizationData.refused.equals("yes")) {

				if (!isChecked(driver, chkrefused))
					verifyTrue(click(driver, chkrefused),
							"Could not click refused check box;More Details:"
									+ immunizationData.toString(), driver);
				waitForPageLoad(driver);
				if (account.equals(Constants.CAACCOUNT)) {
					if (!immunizationData.immunizationCA.equals("")){

					verifyTrue(selectValueFromAjaxList(driver, ajxcanSuggestbox,
							immunizationData.immunizationCA),
							"Could not select"
									+ immunizationData.toString(), driver);
					}
				}
				else
				{
					if (!immunizationData.immunization.equals("")){

					verifyTrue(selectValueFromAjaxList(driver, txtRefusedImmunization,
							immunizationData.immunization),
							"Could not select"
									+ immunizationData.toString(), driver);
					}
				}
				verifyTrue(enterDate(driver, txtRefusedOndate, date),
						"Could not enter the resued Date;More Details:"
								+ immunizationData.toString(), driver);

				if (!immunizationData.comment.equals("")){

				verifyTrue(
						type(driver, txtRefusedComment,
								immunizationData.comment),
								"Could not enter the comment;More Details:"
										+ immunizationData.toString(), driver);
				}
			}

			if (immunizationData.admin.equals("yes")) {

				if (!isChecked(driver, chkadmin))					
					verifyTrue(click(driver, chkadmin), "" + "Could not click the admin check box;More Details:", driver);	
				waitForPageLoad(driver);
		

				if (account.equals(Constants.CAACCOUNT)) {
					if (!immunizationData.immunizationCA.equals("")){

					verifyTrue(selectValueFromAjaxList(driver, ajxcanSuggestbox1,
							immunizationData.immunizationCA),
							"Could not select"
									+ immunizationData.toString(), driver);
					}
				}
				else
				{
					if (!immunizationData.vaccineUS.equals("")){

					verifyTrue(selectValueFromAjaxList(driver, ajxImmunization,immunizationData.vaccineUS),"Could not click refused check box;More Details:"+ immunizationData.toString(), driver);

					}
				}			
				verifyTrue(enterDate(driver, txtadminOnDate, date),
						"Could not enter the Admin on ;More Details:"
								+ immunizationData.toString(), driver);
				if (!immunizationData.comment.equals("")){

				verifyTrue(
						type(driver, txtcomment, immunizationData.comment),
						"Could not enter the comment;More Details:"
								+ immunizationData.toString(), driver);
				}
			} else if (!immunizationData.refused.equals("yes")
					&& !immunizationData.admin.equals("yes")) {

				if (isChecked(driver, chkrefused))
					verifyTrue(click(driver, chkrefused),
								"Could not click refused check box;More Details:"
										+ immunizationData.toString(), driver);

					if (isChecked(driver, chkadmin))
						verifyTrue(click(driver, chkadmin),
								"Could not click the admin check box;More Details:"
										+ immunizationData.toString(), driver);
					waitForPageLoad(driver);

					if (account.equals(Constants.CAACCOUNT)) {
						if (!immunizationData.Vaccine1CA.equals("")){
						verifyTrue(selectValueFromAjaxList(driver, ajxVaccine,immunizationData.Vaccine1CA),"", driver);
						}
					}
					else
					{
						if (!immunizationData.vaccineUS.equals("")){
						verifyTrue(selectValueFromAjaxList(driver, ajxVaccine,immunizationData.vaccineUS)," ", driver);
						}
					}
					
					if (!immunizationData.lotNumber.equals("")){
					verifyTrue(
							type(driver, txtLotNo, immunizationData.lotNumber),
							"Could not enter the lot number", driver);
					}
					
					if (!immunizationData.dosage.equals("")){
					verifyTrue(
							type(driver, txtImmDosage, immunizationData.dosage),
							"Could not enter the dosage value;More Details:"
									+ immunizationData.toString(), driver);

					verifyTrue(selectValueFromAjaxList(driver, txtImmDosageUnit,
							immunizationData.dosageUnit)," ", driver);
					}
					
					verifyTrue(enterDate(driver, txtexpiryDate, date),
					"Could not enter the expiry date;More Details:"
							+ immunizationData.toString(), driver);

					verifyTrue(enterDate(driver, txtadminDate, date),
					"Could not enter the Admin on date;More Details:"
							+ immunizationData.toString(), driver);

		if(!isVisible(driver,ajxSeries1))
		{
			verifyTrue(click(driver, lnkImmShowMoreArrow)," ",driver);
		}
		if (!immunizationData.series.equals("")){
		verifyTrue(selectValueFromAjaxList(driver, ajxSeries1,
								immunizationData.series)," ", driver);
		}
		
		if (!immunizationData.seriesof.equals("")){
		verifyTrue(selectValueFromAjaxList(driver, ajxSeries2,
								immunizationData.seriesof), " ",driver);
		}
		
		if (!immunizationData.site.equals("")){
		verifyTrue(selectValueFromAjaxList(driver, ajxSite,
								immunizationData.site)," ", driver);
		}
		
		if (!immunizationData.route.equals("")){
		verifyTrue(selectValueFromAjaxList(driver, ajxImmRoute,
								immunizationData.route),"",driver);
		}
		
						if (immunizationData.consentCheck.equals("yes")) {
							verifyTrue(click(driver, chkConsentBox),
									"Could not click the check box",driver);
							
							if (!immunizationData.consent.equals("")){
							verifyTrue(selectValueFromAjaxList(driver, ajxConsentSuggest,
									immunizationData.consent),"", driver);
							}
						}
						
						if (!immunizationData.adminBy.equals("")){
						verifyTrue(selectValueFromAjaxList(driver, ajxadminsteredBy,
								immunizationData.adminBy),"", driver);
						}
						
						if (!immunizationData.cptCode1.equals("")){
						verifyTrue(selectValueFromAjaxList(driver, ajxImmCpt1,
								immunizationData.cptCode1), " ", driver);
						}
						
						if (!immunizationData.cptCode2.equals("")){
						verifyTrue(selectValueFromAjaxList(driver, ajxImmCp2,
								immunizationData.cptCode2), " ", driver);
						}
						
						if (!immunizationData.reaction.equals("")){
						verifyTrue(selectValueFromAjaxList(driver, ajxImmreaction,
								immunizationData.reaction)," ", driver);
						waitForPageLoad(driver);
						}
						waitForPageLoad(driver);
						if (!immunizationData.comment.equals("")){
						verifyTrue(type(driver, txtImmComment, immunizationData.comment), ""	+ "Could not type the comments;More Details", driver);
						}
			}
		}
			catch (Exception e) {
				new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
			}

			return true;
	}
	
	/**
	 * addImmunization function to a click Add button
	 * @since  	@since March 24, 2015
	 * @version 2.1
	 */
	
	public boolean addImmunization(WebDriver driver)
	{
		try{
		verifyTrue(click(driver, btnAdd), "add button not found", driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		}
		catch (Exception e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
		}

		return true;
	}

}
