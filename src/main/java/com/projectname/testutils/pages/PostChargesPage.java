package com.projectname.testutils.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.projectname.testutils.seleniumutils.SeleniumWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import com.projectname.testutils.baseclass.TestBaseClass;
import com.projectname.testutils.genericutility.testDataLib.BillingLib;

public class PostChargesPage extends SeleniumWebDriver{

	public  PostChargesPage() {
        PageFactory.initElements(TestBaseClass.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	private static By readyLocator = By.id("serviceCodeSuggestBoxsuggestBox");

	private By lstRenderingProvider = By.id("renderingProvidersuggestBox");
	private By lstBillingProvider = By.id("billingProvidersuggestBox");
	private By location =By.id("locationsuggestBox");
	private By placeOfService = By.id("placeOfServicesuggestBox");
	private By lstDiagnosis00 = By.id("diagnosisCode00suggestBox");
	private By serviceCode = By.id("serviceCodeSuggestBoxsuggestBox");
	private By diagnosisCodeSL = By.id("diagnosisCode1SuggestBoxsuggestBox");
	private By diagnosisCodeSLCA=By.id("diagnosisCodeSuggestBoxsuggestBox");
	private By txtFee = By.id("fee");
	private By btnSaveChargeEntry = By.id("Save");
	private By ajxserviceLevInd=By.id("suggestBox");
	private By dateSLDateCA=By.cssSelector("input.gwt-DateBox.text-box");
	private By txtUnits = By.id("units");
	private By dateSLStartDate = By.xpath("//div[@id='serviceItemDateServicedFromPanel']/input");
	private By dateSLEndDate = By.xpath("//div[@id='serviceItemDateServicedToPanel']/input");
	private By ajxPayToBox = By.id("billToPayersListSuggestBoxsuggestBox");

	private By btnPostChargeEntry = By.linkText("Post");
	private By chkBoxAccident = By.id("accidentRelatedChargecheckbox");
	private By chkBoxEmployment = By.id("employmentAccidentcheckbox");
	private By dateAccidentDate = By.xpath("//div[2]/div/div[1]/div[2]/input");
	private By lstAccidentState = By.id("accidentStatesuggestBox");
	private By txtStartHour = By.id("startHour");
	private By txtStartMinute = By.id("startMinute");
	private By lstamPm = By.id("amPMSelectsuggestBox");
	private By lstspecialty = By.id("specialtySuggestBoxsuggestBox");
	private By lstReferringProvider = By.id("referringProvidersuggestBox");
	private By lstCase = By.id("entryCasesuggestBox");
	private By lstProgram = By.id("programsuggestBox");
	private By lstmodifiers = By.id("modifier1SuggestBoxsuggestBox");
	private By lstAmbulanceTransReason = By.id("ambulanceTransportReasonsuggestBox");
	private By chkAmbulanceTrans = By.id("visitContainsAmbulancecheckbox");
	private By lnkClickToSelectConditionCode = By.xpath("(//a[contains(text(),'Click to select')])[1]");
	private By lstAuthorization = By.id("authorizationNumberSuggestBoxsuggestBox");
	private By chkChiroPrac = By.id("visitContainsChiropracticcheckbox");
	private By chkDME = By.id("visitContainsDMEcheckbox");
	private By chkOxygen = By.id("visitContainsOxygencheckbox");
	private By chkNDCDrug = By.id("visitContainsNdccheckbox");
	private By txtPatientWeight = By.id("patientWeight");
	private By txtPatientCount = By.id("patientCount");
	private By txtTransDist = By.id("ambulanceTransportReasonsuggestBox");
	private By txtRoungTrip = By.id("roundTripPurpose");
	private By txtStretcherPurpose = By.id("stretcherPurpose");
	private By txtStreet1 = By.id("addr1");
	private By txtDropStreet1 = By.xpath("(//input[@id='addr1'])[2]");
	private By txtStreet2 = By.id("addr2");
	private By txtDropStreet2 = By.xpath("(//input[@id='addr2'])[2]");
	private By txtCity = By.id("city");
	private By txtDropCity = By.xpath("(//input[@id='city'])[2]");
	private By lstState = By.id("stateSuggestBoxsuggestBox");
	private By lstDropState = By.xpath("(//input[@id='stateSuggestBoxsuggestBox'])[2]");
	private By txtZip = By.id("zip");
	private By txtDropZip = By.xpath("(//input[@id='zip'])[2]");
	private By lstCountry = By.id("countrySuggestBoxsuggestBox");
	private By lstDropCountry = By.xpath("(//input[@id='countrySuggestBoxsuggestBox'])[2]");
	private By lstPatientCond = By.id("patientConditionsuggestBox");
	private By txtCondDesc = By.id("conditionDescription");
	private By dateInitialTreat = By.id("initialTreatmentDate");
	private By dateAcuteMan = By.id("acuteManifestationDate");
	private By radYes = By.id("Yesradio");
	private By radNo = By.id("Noradio");
	private By dateLastXray = By.id("initialTreatmentDate");
	private By lstDMECerti = By.id("dmeCertificationsuggestBox");
	private By txtCTCode = By.id("certificateTransmissionCodesuggestBox");
	private By txtEquipDuration = By.id("equipmentDuration");
	private By dateCertiRev = By.id("certificationRevisionDate");
	private By dateBeginTherapy = By.id("beginTherapyDate");
	private By dateLastCerti = By.id("lastCertificationDate");
	private By txtPatientHeight = By.id("patientHeight");
	private By txtDMEPatientWeight = By.id("dmePatientWeight");
	private By txtLenMedicalNece = By.id("lengthOfMedicalNecessity");
	private By txtRentalPrice = By.id("rentalPrice");
	private By lstRentalPriceUnit = By.id("rentalPriceUnitsuggestBox");
	private By txtPurchasePrice = By.id("purchasePrice");
	private By lnkDMECertiCondition = By.xpath("(//a[contains(text(),'Click to select')])[3]");
	private By lstOxyCerti = By.id("oxygenCertificationsuggestBox");
	private By txtOxyduration = By.id("oxygenDuration");
	private By lnkOxyCertiCondition = By.xpath("(//a[contains(text(),'Click to select')])[3]");
	private By dateOxyCertiRev = By.id("oxygenCertificationRevisionDate");
	private By dateOxyBeginTherapy = By.id("oxygenBeginTherapyDate");
	private By dateOxyLastCerti = By.id("oxygenLastCertificationDate");
	private By txtNDCDrugCode = By.id("drugCode");
	private By txtQuantity = By.id("quantity");
	private By lstPresciptionType = By.id("unitTypesuggestBox");
	private By lstUnitType = By.id("nitTypesuggestBox");
	private By txtPrescriptionNum = By.id("prescriptionNumber");
	private By datePrescription = By.id("prescriptionDate");
	private By ajxSpeciality =  By.id("specialtySuggestBoxsuggestBox");
	private By ajxRenderingProviderSL= By.id("renderProviderSuggestBoxsuggestBox");
	private By chkboxInpatient= By.id("inPatientCheckBoxlabel");
	private By dateOfAddmission= By.id("dateOfAdmission");
	private By AddNewAuthorization= By.id("authorizationAddNewButton");
	private By txtvisitsAuthorized= By.id("numAuthorizedVisits1");
	private By txtAuthorizationNumber= By.id("authorizationNum1");
	private By btnSaveAuthorization= By.id("authorizationSaveButton");
	private By ajxPayerForAuthorization= By.id("payerSuggestBox1suggestBox");
	
	private By lnkBillingCharges = By.id("!billingChargesHistory");
	
	
	

	/**savePostChargeEntry
	 * function to savePostChargeEntry 
	 * @param driver
	 * @param chargeEntryData (Test Data for Post Charge)
         * @param patientID(Patient ID to be searched)
	 * @throws IOException
	 * @since Dec 22, 2014
 */

	public BillingHistoryPage savePostChargeEntry(WebDriver driver,BillingLib chargeEntryData, String account) throws Exception {
		String date = null;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
		if(account.contains("CA")){
			DateFormat = new SimpleDateFormat("dd/MM/yyyy");
		}
		date = DateFormat.format(cal.getTime());
		chargeEntryData.dateOfService1=date;
		chargeEntryData.dateOfService2=date;
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		
		assertTrue(isElementPresent(driver, lstRenderingProvider),"Rendering Provider textbox not Present", driver, className,methodName);
		assertTrue(isElementPresent(driver, lstBillingProvider),"Billing Provider textbox not Present", driver, className,methodName);
		assertTrue(isElementPresent(driver, location),"Location textbox not Present", driver, className,methodName);
		assertTrue(isElementPresent(driver, placeOfService),"Place of service textbox not Present", driver, className,methodName);
		
		if(!account.contains("CA")){
		assertTrue(isElementPresent(driver, lstDiagnosis00),"Diagnosis Code textbox not Present", driver, className,methodName);
		}

		assertTrue(isElementPresent(driver, serviceCode),"Service Code textbox not Present", driver, className,methodName);
		
		if(!account.contains("CA")){
		assertTrue(isElementPresent(driver, diagnosisCodeSL),"Diagnosis Code textbox not Present in Service Line", driver, className,methodName);
		}else
		assertTrue(isElementPresent(driver, diagnosisCodeSLCA),"Diagnosis Code textbox not Present in Service Line", driver, className,methodName);
		
		assertTrue(isElementPresent(driver, txtFee),
				"Fee textbox not Present", driver, className,
				methodName);
		assertTrue(
				selectValueFromAjaxList(driver, lstRenderingProvider,
						chargeEntryData.renderingProvider),
				"Not able to add Rendering Provider", driver, className,
				methodName);
		assertTrue(
				selectValueFromAjaxList(driver, location,
						chargeEntryData.location),
				"Not able to add Location", driver, className,
				methodName);
		if(account.contains("CA")){
			assertTrue(
					selectValueFromAjaxList(driver, ajxserviceLevInd,
							chargeEntryData.ServiceLevelIndicator),
					"not able to add service code", driver, className,
					methodName);
		}
		if(!account.contains("CA")){
			assertTrue(
					selectValueFromAjaxList(driver, placeOfService,
							chargeEntryData.placeOfServiceUS),
					"Not able to add Place of Service", driver, className,
					methodName);
			assertTrue(
					selectValueFromAjaxList(driver, lstBillingProvider,
							chargeEntryData.billingProviderUS),
					"Not able to add Billing provider", driver, className,
					methodName);
		}else
		{
		assertTrue(
				selectValueFromAjaxList(driver, placeOfService,
						chargeEntryData.placeOfService),
				"Not able to add Place of Service", driver, className,
				methodName);
		assertTrue(
				selectValueFromAjaxList(driver, lstBillingProvider,
						chargeEntryData.billingProvider),
				"Not able to add Billing provider", driver, className,
				methodName);
		}
		if(!account.contains("CA")){
			type(driver, lstDiagnosis00,
					chargeEntryData.diagnosisCode);
		assertTrue(
				selectValueFromAjaxList(driver, lstDiagnosis00,
						chargeEntryData.diagnosisCode),
				"Not able to add diagonsis code", driver, className,
				methodName);
		}
		if(account.contains("CA")){
			assertTrue(enterDate(driver, dateSLDateCA, chargeEntryData.dateOfService1),
					"not able to add end date", driver, className,
					methodName);
			
			}
		if(account.contains("CA")){
			assertTrue(
					selectValueFromAjaxList(driver, serviceCode,
							chargeEntryData.serviceCodeCA),
					"not able to add service code", driver, className,
					methodName);
		}else
		assertTrue(
				selectValueFromAjaxList(driver, serviceCode,
						chargeEntryData.serviceCode),
				"not able to add service code", driver, className,
				methodName);
		if(!account.contains("CA")){
		assertTrue(
				selectValueFromAjaxList(driver, diagnosisCodeSL,
						chargeEntryData.diagnosisCodeSL),
				"no able to add diagnosis code in service line", driver, className,
				methodName);
		}else
		assertTrue(
				selectValueFromAjaxList(driver, diagnosisCodeSLCA,
						chargeEntryData.diagnosisCodeSL),
				"no able to add diagnosis code in service line", driver, className,
				methodName);
		assertTrue(type(driver, txtUnits, chargeEntryData.units),
				"Not able to add units", driver, className,
				methodName);
		assertTrue(type(driver, txtFee, chargeEntryData.fee),
				"Not able to add units", driver, className,
				methodName);

		
		if(!account.contains("CA")){
		assertTrue(enterDate(driver, dateSLEndDate, chargeEntryData.dateOfService2),
				"not able to add end date", driver, className,
				methodName);
		assertTrue(enterDate(driver, dateSLStartDate, chargeEntryData.dateOfService1),
				"not able to add start date", driver, className,
				methodName);
		}
		
		//Pay to Patient 
		selectValueFromAjaxList(driver, ajxPayToBox, chargeEntryData.payTo);
		
		
		if (chargeEntryData.testCaseId.equals("TC_CE_015")
				|| chargeEntryData.testCaseId.equals("TC_CE_016")||chargeEntryData.testCaseId.equals("TC_CE_020")
				|| chargeEntryData.testCaseId.equals("TC_CE_021")) {
			assertTrue(isElementPresent(driver, chkBoxAccident),"Adjustment Reason textbox not Present", driver,className, methodName);
			assertTrue(click(driver, chkBoxAccident),"Adjustment Reason textbox not Present", driver,className, methodName);
			assertTrue(isElementPresent(driver, chkBoxEmployment),"Adjustment Reason textbox not Present", driver,className, methodName);
			assertTrue(click(driver, chkBoxEmployment),"Adjustment Reason textbox not Present", driver,	className, methodName);
			assertTrue(isElementPresent(driver, dateAccidentDate),"Adjustment Reason textbox not Present", driver,className, methodName);
			if(account.contains("CA")){
				assertTrue(enterDate(driver, dateAccidentDate,chargeEntryData.dateOfService1),"Adjustment Reason textbox not Present", driver,className, methodName);
			}else{
				assertTrue(enterDate(driver, dateAccidentDate,chargeEntryData.dateOfService1),"Adjustment Reason textbox not Present", driver,className, methodName);
			}
			if(!account.contains("CA")){
			assertTrue(isElementPresent(driver, lstAccidentState),"Adjustment Reason textbox not Present", driver,className, methodName);
			assertTrue(selectValueFromAjaxList(driver, lstAccidentState,chargeEntryData.accidentState),"Adjustment Reason textbox not Present", driver,className, methodName);
			}
			assertTrue(isElementPresent(driver,txtStartHour ),"Adjustment Reason textbox not Present", driver,className, methodName);
			assertTrue(type(driver, txtStartHour,chargeEntryData.accidentHour),"Adjustment Reason textbox not Present", driver,className, methodName);
			assertTrue(isElementPresent(driver,txtStartMinute ),"Adjustment Reason textbox not Present", driver,className, methodName);
			assertTrue(type(driver, txtStartMinute,chargeEntryData.accidentHour),"Adjustment Reason textbox not Present", driver,className, methodName);
			assertTrue(isElementPresent(driver,txtStartMinute ),"Adjustment Reason textbox not Present", driver,className, methodName);
			assertTrue(type(driver, txtStartMinute,chargeEntryData.accidentMins),"Adjustment Reason textbox not Present", driver,className, methodName);
			assertTrue(isElementPresent(driver,lstamPm ),"Adjustment Reason textbox not Present", driver,className, methodName);
			assertTrue(type(driver, lstamPm,chargeEntryData.amPm),"Adjustment Reason textbox not Present", driver,className, methodName);
		}
		
		if (chargeEntryData.testCaseId.equals("TC_CE_020")
				|| chargeEntryData.testCaseId.equals("TC_CE_021")) {
			
			assertTrue(isElementPresent(driver, lstspecialty),"speciality textbox not present", driver,className, methodName);
			assertTrue(selectValueFromAjaxList(driver, lstspecialty,chargeEntryData.specialty),"Adjustment Reason textbox not Present", driver,className, methodName);
			
			assertTrue(isElementPresent(driver, lstReferringProvider),"Adjustment Reason textbox not Present", driver,className, methodName);
			assertTrue(selectValueFromAjaxList(driver, lstReferringProvider,chargeEntryData.referringProvider),"Adjustment Reason textbox not Present", driver,	className, methodName);
			
			assertTrue(isElementPresent(driver, lstCase),"Adjustment Reason textbox not Present", driver,className, methodName);
			assertTrue(selectValueFromAjaxList(driver, lstCase,chargeEntryData.caseChargeEntry),"Adjustment Reason textbox not Present", driver,className, methodName);
			
			assertTrue(isElementPresent(driver, lstProgram),"Adjustment Reason textbox not Present", driver,className, methodName);
			assertTrue(selectValueFromAjaxList(driver, lstProgram,chargeEntryData.program),"Adjustment Reason textbox not Present", driver,className, methodName);
			
			if(!account.contains("CA")){
			assertTrue(isElementPresent(driver,lstmodifiers),"Adjustment Reason textbox not Present", driver,className, methodName);
			assertTrue(selectValueFromAjaxList(driver, lstmodifiers,chargeEntryData.modifiers),"Adjustment Reason textbox not Present", driver,className, methodName);
			}
			if(!account.contains("CA")){
			assertTrue(isElementPresent(driver,diagnosisCodeSL ),"Adjustment Reason textbox not Present", driver,className, methodName);
			assertTrue(selectValueFromAjaxList(driver, diagnosisCodeSL,chargeEntryData.diagnosisCodeSL),"Adjustment Reason textbox not Present", driver,className, methodName);
			}else{
				assertTrue(isElementPresent(driver,diagnosisCodeSLCA ),"Adjustment Reason textbox not Present", driver,className, methodName);
				assertTrue(selectValueFromAjaxList(driver, diagnosisCodeSLCA,chargeEntryData.diagnosisCodeSL),"Adjustment Reason textbox not Present", driver,className, methodName);
				
			}
			
			assertTrue(isElementPresent(driver,dateSLStartDate ),"Adjustment Reason textbox not Present", driver,className, methodName);
			assertTrue(type(driver, dateSLStartDate,chargeEntryData.dateOfService1),"Adjustment Reason textbox not Present", driver,className, methodName);
			if(!account.contains("CA")){
			assertTrue(isElementPresent(driver,dateSLEndDate ),"Adjustment Reason textbox not Present", driver,className, methodName);
			assertTrue(type(driver, dateSLEndDate,chargeEntryData.dateOfService2),"Adjustment Reason textbox not Present", driver,className, methodName);
			}
			
		}
		
		if (chargeEntryData.testCaseId.equals("TC_CE_036")) {
			assertTrue(click(driver, chkChiroPrac),"Show All Detail link not present", driver,className, methodName);
			
			assertTrue(isElementPresent(driver, lstPatientCond),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtCondDesc),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, dateInitialTreat),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, dateAcuteMan),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, radYes),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, radNo),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, dateLastXray),"Show All Detail link not present", driver,className, methodName);
			
			
			assertTrue(type(driver, lstPatientCond,chargeEntryData.patientCond),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtCondDesc, chargeEntryData.condDesc),"Show All Detail link not present", driver,className, methodName);
			assertTrue(enterDate(driver, dateInitialTreat,chargeEntryData.dateInitialTreat),"Show All Detail link not present", driver,className, methodName);
			assertTrue(enterDate(driver, dateAcuteMan,chargeEntryData.dateAcuteMan),"Show All Detail link not present", driver,className, methodName);
			if (chargeEntryData.radYes.equals("True")) {
				assertTrue(click(driver, radYes),"Show All Detail link not present", driver,className, methodName);
			}
			if (chargeEntryData.radNo.equals("True")) {
				assertTrue(click(driver, radNo),"Show All Detail link not present", driver,className, methodName);
			}
			assertTrue(
					enterDate(driver, dateLastXray,chargeEntryData.dateLastXray),"Show All Detail link not present", driver,className, methodName);
		}
		if (chargeEntryData.testCaseId.equals("TC_CE_035")) {
			
			assertTrue(click(driver, chkAmbulanceTrans),"Show All Detail link not present", driver,className, methodName);
			
			assertTrue(isElementPresent(driver, txtPatientWeight),"Patient Weight textbox not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtPatientCount),"Patient Count textbox not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtTransDist),"Transport Distance not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtRoungTrip),"Round Trip tes", driver,className, methodName);
			assertTrue(isElementPresent(driver, lstAmbulanceTransReason),"Round Trip tes", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtStretcherPurpose),	"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtStreet1),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtStreet2),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtCity),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, lstState),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtZip),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, lstCountry),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtDropStreet1),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtDropStreet2),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtDropCity),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, lstDropState),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtDropZip),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, lstDropCountry),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver,lnkClickToSelectConditionCode),"Show All Detail link not present", driver,className, methodName);

			assertTrue(type(driver, txtPatientWeight,chargeEntryData.patientWeight),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtPatientCount,chargeEntryData.patientCount),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtTransDist,chargeEntryData.transDistance),"Show All Detail link not present", driver,	className, methodName);
			assertTrue(selectValueFromAjaxList(driver, lstAmbulanceTransReason,chargeEntryData.transReason),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtRoungTrip, chargeEntryData.roundTrip),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtStretcherPurpose,chargeEntryData.stretcherPurpose),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtStreet1, chargeEntryData.pickStreet1),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtStreet2, chargeEntryData.pickStreet2),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtCity, chargeEntryData.pickCity),"Show All Detail link not present", driver,className, methodName);
			assertTrue(selectValueFromAjaxList(driver, lstState,chargeEntryData.pickState),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtZip, chargeEntryData.pickZip),"Show All Detail link not present", driver,className, methodName);
			assertTrue(selectValueFromAjaxList(driver, lstCountry,chargeEntryData.pickCountry),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtDropStreet1,chargeEntryData.dropStreet1),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtDropStreet2,chargeEntryData.dropStreet2),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtDropCity, chargeEntryData.dropCity),"Show All Detail link not present", driver,className, methodName);			
			assertTrue(selectValueFromAjaxList(driver, lstDropState,chargeEntryData.dropState),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtDropZip, chargeEntryData.dropZip),"Show All Detail link not present", driver,className, methodName);
			assertTrue(selectValueFromAjaxList(driver, lstDropCountry,chargeEntryData.dropCountry),"Show All Detail link not present", driver,className, methodName);
			
			}
		if (chargeEntryData.testCaseId.equals("TC_CE_037")) {
			
			assertTrue(click(driver, chkDME),"Show All Detail link not present", driver,className, methodName);
			
			assertTrue(isElementPresent(driver, lstDMECerti),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtEquipDuration),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, dateCertiRev),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, dateBeginTherapy),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, dateLastCerti),	"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtPatientHeight),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtDMEPatientWeight),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtLenMedicalNece),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtRentalPrice),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, lstRentalPriceUnit),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtPurchasePrice),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, lnkDMECertiCondition),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtCTCode),"Show All Detail link not present", driver,className, methodName);
			chargeEntryData.certiRevDate=date;
			chargeEntryData.beginTherapyDate=date;
			chargeEntryData.lastCertiDate=date;
			assertTrue(selectValueFromAjaxList(driver, lstDMECerti,chargeEntryData.dMECertificate),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtEquipDuration,chargeEntryData.equipDuration),"Show All Detail link not present", driver,className, methodName);
			assertTrue(enterDate(driver, dateCertiRev,chargeEntryData.certiRevDate),"Show All Detail link not present", driver,	className, methodName);
			assertTrue(enterDate(driver, dateBeginTherapy,chargeEntryData.beginTherapyDate),"Show All Detail link not present", driver,className, methodName);
			assertTrue(enterDate(driver, dateLastCerti, chargeEntryData.lastCertiDate),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtPatientHeight,chargeEntryData.patientHeight),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtDMEPatientWeight, chargeEntryData.dMEPatientWeight),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtLenMedicalNece, chargeEntryData.lenMedicalNece),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtRentalPrice, chargeEntryData.rentalPrice),"Show All Detail link not present", driver,className, methodName);
			assertTrue(selectValueFromAjaxList(driver, lstRentalPriceUnit,chargeEntryData.rentalPriceUnit),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtPurchasePrice, chargeEntryData.purchasePrice),"Show All Detail link not present", driver,className, methodName);
			assertTrue(selectValueFromAjaxList(driver, txtCTCode, chargeEntryData.ctCode),"Show All Detail link not present", driver,className, methodName);
			
			
		}
		if (chargeEntryData.testCaseId.equals("TC_CE_038")) {
			
			assertTrue(click(driver, chkOxygen),"Show All Detail link not present", driver,className, methodName);
			
			assertTrue(isElementPresent(driver, lstOxyCerti),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtOxyduration),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, lnkOxyCertiCondition),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, dateOxyCertiRev),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, dateOxyBeginTherapy),	"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, dateOxyLastCerti),"Show All Detail link not present", driver,className, methodName);
			chargeEntryData.oxyCertiRevDate=date;
			chargeEntryData.oxyBeginTherapyDate=date;
			assertTrue(selectValueFromAjaxList(driver, lstOxyCerti,chargeEntryData.oxyCertificate),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtOxyduration,chargeEntryData.oxyDuration),"Show All Detail link not present", driver,className, methodName);
			assertTrue(enterDate(driver, lnkOxyCertiCondition,chargeEntryData.oxyCertiCondition),"Show All Detail link not present", driver,	className, methodName);
			assertTrue(enterDate(driver, dateOxyCertiRev,chargeEntryData.oxyCertiRevDate),"Show All Detail link not present", driver,className, methodName);
			assertTrue(enterDate(driver, dateOxyBeginTherapy, chargeEntryData.oxyBeginTherapyDate),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, dateOxyLastCerti,chargeEntryData.oxyLastCertiDate),"Show All Detail link not present", driver,className, methodName);
			
			
		}
		
		if (chargeEntryData.testCaseId.equals("TC_CE_039")) {
			
			assertTrue(click(driver, chkNDCDrug),"Show All Detail link not present", driver,className, methodName);
			
			assertTrue(isElementPresent(driver, txtNDCDrugCode),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtQuantity),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, lstPresciptionType),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, lstUnitType),"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, txtPrescriptionNum),	"Show All Detail link not present", driver,className, methodName);
			assertTrue(isElementPresent(driver, datePrescription),"Show All Detail link not present", driver,className, methodName);
			
			assertTrue(selectValueFromAjaxList(driver, txtNDCDrugCode,chargeEntryData.NDCDrugCode),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, txtQuantity,chargeEntryData.quantity),"Show All Detail link not present", driver,className, methodName);
			assertTrue(enterDate(driver, lstPresciptionType,chargeEntryData.presciptionType),"Show All Detail link not present", driver,	className, methodName);
			assertTrue(enterDate(driver, lstUnitType,chargeEntryData.unitType),"Show All Detail link not present", driver,className, methodName);
			assertTrue(enterDate(driver, txtPrescriptionNum, chargeEntryData.prescriptionNum),"Show All Detail link not present", driver,className, methodName);
			assertTrue(type(driver, datePrescription,chargeEntryData.PrescriptionDate),"Show All Detail link not present", driver,className, methodName);
		}
		if (chargeEntryData.testCaseId.equals("TC_CE_058")){
			assertTrue(!isElementPresent(driver, ajxSpeciality),"Speciality Suggestbox ia present fot multiple rendering provider", driver,className, methodName);
			assertTrue(isElementPresent(driver, ajxRenderingProviderSL),"Speciality Suggestbox ia present fot multiple rendering provider", driver,className, methodName);
			
			
			
		}
		if (chargeEntryData.testCaseId.equals("TC_CE_059")){
			assertTrue(click(driver, chkboxInpatient),"Not able to click Inpatient Check box", driver,className, methodName);
			assertTrue(enterDate(driver, dateOfAddmission, chargeEntryData.DateOfAdmission),"Not able to click Inpatient Check box", driver,className, methodName);
		}
		if(chargeEntryData.testCaseId.equals("TC_CE_067")||chargeEntryData.testCaseId.equals("TC_CE_069")){
			assertTrue(selectValueFromAjaxList(driver, lstReferringProvider,chargeEntryData.referringProvider),"Could not enter referring Provider", driver,className, methodName);
			assertTrue(click(driver, AddNewAuthorization),"Could not click on add new authorization", driver,className, methodName);
			waitForPageLoad(driver);
			assertTrue(selectValueFromAjaxList(driver, ajxPayerForAuthorization, chargeEntryData.authorizationPayer),"Not able to click Inpatient Check box", driver,className, methodName);
			assertTrue(type(driver, txtAuthorizationNumber,chargeEntryData.authorizationToAdd),"Could not click on add new authorization", driver,className, methodName);
			assertTrue(type(driver, txtvisitsAuthorized, chargeEntryData.authorizationVisits),"Could not click on add new authorization", driver,className, methodName);
			assertTrue(click(driver, btnSaveAuthorization),"Could not click on add new authorization", driver,className, methodName);
			waitForPageLoad(driver);
		}
		if(chargeEntryData.testCaseId.equals("TC_CE_067")||chargeEntryData.testCaseId.equals("TC_CE_068")||chargeEntryData.testCaseId.equals("TC_CE_069")||chargeEntryData.testCaseId.equals("TC_CE_070")){
			assertTrue(selectValueFromAjaxList(driver, lstReferringProvider,chargeEntryData.referringProvider),"Could not enter referring Provider", driver,className, methodName);
			assertTrue(selectValueFromAjaxList(driver, lstAuthorization, chargeEntryData.authorizationToSelect),"Not able to click Inpatient Check box", driver,className, methodName);
		}
			
		
		
		if (chargeEntryData.testCaseId.equals("TC_CE_013")||chargeEntryData.testCaseId.equals("TC_CE_021")||chargeEntryData.testCaseId.equals("TC_CE_015")) {
			assertTrue(click(driver, btnSaveChargeEntry),
					"Not able to click Save Button", driver,
					className, methodName);
		}

		if (chargeEntryData.testCaseId.equals("TC_CE_014")||chargeEntryData.testCaseId.equals("TC_CE_020")||chargeEntryData.testCaseId.equals("TC_CE_016")||chargeEntryData.testCaseId.equals("TC_CE_035")||chargeEntryData.testCaseId.equals("TC_CE_036")||chargeEntryData.testCaseId.equals("TC_CE_037")||chargeEntryData.testCaseId.equals("TC_CE_038")||chargeEntryData.testCaseId.equals("TC_CE_039")||chargeEntryData.testCaseId.equals("TC_CE_058")||chargeEntryData.testCaseId.equals("TC_CE_059")||chargeEntryData.testCaseId.equals("TC_CE_067")||chargeEntryData.testCaseId.equals("TC_CE_068")||chargeEntryData.testCaseId.equals("TC_CE_069")||chargeEntryData.testCaseId.equals("TC_CE_070")||chargeEntryData.testCaseId.equals("TC_CFS_001")||chargeEntryData.testCaseId.equals("TC_CFS_003")) {
			assertTrue(click(driver, btnPostChargeEntry),
					"Not able to click Post Button", driver,
					className, methodName);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			assertTrue(isTextPresent(driver,"Summary"),
					"Not navigated to Summary page after Post Charge Entry", driver,
					className, methodName);
		}

		waitForPageLoad(driver);

		return new BillingHistoryPage();
	}	
	/**
	 * verifyAvailableAuthorization
	 * function to verify if an authorization is available in the Authorization drop down 
	 * @param 	String- referredBy
	 * @param 	String- authorization code
	 * @throws  Exception 
	 * @since  	Dec 18, 2014
	 * @version 2.1
	 */
	public boolean verifyAvailableAuthorization(String referredBy,String authorization) throws Exception{
		assertTrue(selectValueFromAjaxList(driver, lstReferringProvider,referredBy),"Could not enter referring Provider", driver,className, methodName);
		return selectValueFromAjaxList(driver, lstAuthorization, authorization);
		
	}
	
	/**
	 * verifyPostCharges
	 * function to verify Post Charges access from charge entry page
	 * @param 	driver
	 * @param    billingData
	 * @throws  Exception 
	 * @since  	May 19, 2015
	 * @version 2.1
	 */
	public void verifyPostCharges(WebDriver driver,BillingLib billingData ) throws Exception{
		
		assertTrue(isElementPresent(driver,lnkBillingCharges),"Could not post charge", driver,className, methodName);
		waitForPageLoad(driver);
	}
	
	
}
