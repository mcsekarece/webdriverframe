package com.nexia.selenium.genericlibrary.billing;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.sharedlibrary.AbstractTest;
import com.thoughtworks.selenium.Selenium;

public class AbstractBilling extends AbstractTest{
	public String lnkQuickAction = "link=Quick Actions";
	public String lnkShowMoreLink="showMoreActions";
	public String lnkBillingSettings = "billingSettingsAction";
	public String lnkAdjustmentCodes = "!billingAdjustmentCodes";
	public String lnkSystemSettingAction="systemSettingsAction";
	public String lnkMandatoryUserFields="!adminMandatoryUserField";
	public String lblAdjustmentCodes = "adjustmentReasonsEmptyList";
	public String btnEncounter = "BeginEncounterButton";
	public String btnWizardNext1="//a[@id='wizardNextButton']/div";
	public String lnkPatientPostPatientPayments = "link=Post patient payments";
	public String lnkStartNewBatch = "link=Or start a new batch >>";

	public String txtSearchPatientBox="searchPatientBox";
	public String btnAddNewForOtherPayer= "addNewOtherPayerButton";
	 public String txtPayerName = "Payer Name";
	public String txtLastName="lastName";
	public String txtFirstName="firstName";
	public String txtDOB="dob";
	private String btnBack1="notDuplicateButton"; 
	public String btnBack="backButton";
	public String chkPremature="prematurecheckbox";
	public String ajxPrematureDuration="prematureDurationSuggestBoxsuggestBox";
	public String ajxStatus="statusSuggestBoxsuggestBox";
	public String ajxRelationSex =  "sexSuggestBoxsuggestBox";
	public String btnSave1="saveButton";
	public String lnkRegisterPatient="newPatientAction";
	public String btnYesButton="yesButton";
	public String btnActivateAutoGen="link=Activate auto generation of statements";
	public String ajxOtherpayerSelect = "xpath=(//input[@id='payerSearchSuggestBoxsuggestBox'])[2]";
	public String ajxTypeOfCoverageSuggest ="typeOfCoverageSuggestBoxsuggestBox";
	public String txtOtherPayerStartDate = "xpath=(//input[@id='startDate'])[2]";
	public String ajxReleaseOfInformatiom ="releaseOfInformationSuggestBoxsuggestBox";
	public String ajxOtherPayerRelationShip = "xpath=(//input[@id='subscriberRelationshipSuggestBoxsuggestBox'])[2]";
	public String ajxRelationShip ="subscriberRelationshipSuggestBoxsuggestBox";
	public String ajxPayerSelect ="payerSearchSuggestBoxsuggestBox";
	public String txtPayerStartDate ="startDate";
	public String btnlnkSave = "link=Save";
	public String btnOK = "okButton";
	//Batch Eligibility
	public String lnkBatchEligibility = "!BatchEligibiltiyPreferencesShow";
	public String btnActivateAutoGenerationOfBatchEligibility = "link=Activate auto generation of batch preferences";
	public String btnDelete1InCheckOnly = "xpath=(//a[contains(text(), 'Delete')])[1]";
	public String btnDelete2InCheckOnly = "xpath=(//a[contains(text(), 'Delete')])[2]";
	
	//EtE
	public String lblDateValiue="xpath=(//div[@id='dateValue'])";
	public String lblServiceCodeForCharges= "xpath=(//div[@id='serviceCode'])";
	public String lblChargeAmountCharges="xpath=(//div[@id='chargeAmount'])";		
	public String lblAmountDue="xpath=(//div[@id='amountDue'])";
	public String lblCurrentPayer="xpath=(//div[@id='currentPayer'])";
	
	//FIXME-BLG-574
	public String lblAmount="//div[5]/div/div/div/div/div/div/div[3]/div/span";
	
	//Batch Statements
	
	public String ajxSuggestBox = "suggestBox";
	public String ajxUnprinted = "xpath=(//input[@id='suggestBox'])[2]";
	public String lnkHideAnchor = "SlideWindowHideAnchor";
	
	public String lnkRemove = "link=Remove";
	public String btnStatementSave = "statement-edit-save-button";
	public String btnStatementCancel = "statement-edit-cancel-button";
	
	public String lblUnprinted = "//div[starts-with(@id,'statement')]";
	public String lnkUpdateFinancial = "updateFinancialStatus";
	public String lnkBadDebtStatus = "statusBadDebtradio";
	public String lnkPendingCollectionStatus = "statusPendingCollectionradio";
	public String chkSelectAll = "SQSelectAllcheckbox";
	public String EditStatemetDOS="//div[@id='printInfo']/div/div[3]/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/div";
	public String EditStatemetserCode="//div[@id='printInfo']/div/div[3]/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/div[3]";
	public String EditStatementProvoder="//div[@id='printInfo']/div/div[3]/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/div[2]";
	public String EditStatementPayerCode="//div[@id='patientPayerWidget']/div/div/div[4]/div/div/div/div[4]/div[2]/span";
	public String EditStatementBalance="css=div.display-cell.textAlignRight";
	public String EditStatementcheckbox="//div//span//input[@id='gwt-uid-4556']";
	public String txtBlgStatementHistorySearch = "BillingStatementHistorySearchBox";
	public String chkbxPrintedStatement = "//div[@id='statement_21']/span/input";


	public String dateOfService ="dateOfService"; 

	//Need Action
	public String lnkViewChart = "link=View chart";
	public String btnBeginEncounter = "BeginEncounterButton";
	
	// Super Bill SetUp
	public String lnkSuperDel="deleteButton";
	public String lnkSuperBillSetUp = "!billingSuperbillSetup";
	public String lnkDeleteSuperBill = "//div[@id='SuperbillTemplateList']/table/tbody/tr/td[4]/div/a";
	public String lnkEditSuperBill = "//div[@id='SuperbillTemplateList']/table/tbody/tr/td[3]/div/a";
	public String lnkCopySuperBill = "//div[@id='SuperbillTemplateList']/table/tbody/tr/td[2]/div/a";
	public String lnkSBIAddNew = "//a[@id='addNew']";
	public String lnkSBIActivate = "//div[@id='SuperbillTemplateList']/table/tbody/tr/td[4]/div/a";

	public String btnPreviewCircle = "PreviewCircle";
	public String btnSCAddNew = "//div[contains(text(),'Add New')]";
	public String btnYes = "yesButton";
	public String btnSBIBack = "backButton";
	public String btnSBINext = "nextButton";
	public String btnSBIDone = "doneButton";
	public String btnServiceCodeDelete = "xpath=(//div[contains(text(),'Delete')])[1]";
	public String btnServicecodeMoreDelete = "xpath=(//div[contains(text(),'Delete')])[2]";
	public String btnSBSCopy = "//div[@id='SuperbillTemplateList']/table/tbody/tr/td[2]";
	public String chkSBTServiceCode = "serviceCodes";
	public String chkSBTInformation = "superbillInformation";
	
	public String txtTempletaName = "templateName";
	public String txtSectionLabel = "sectionLabel0";
	public String txtSectionLabel1 = "sectionLabel1";
	public String txtSectionLabel2 = "sectionLabel2";
	public String txtSectionLabel3 = "sectionLabel3";
	public String txtSectionLabel4 = "sectionLabel4";
	public String txtSectionLabel5 = "sectionLabel5";
	
	public String txtSCdescription = "description0";
	public String txtSCdescription1 = "description1";
	public String txtSCdescription2 = "description2";
	public String txtSCdescription3 = "description3";
	public String txtSCdescription4 = "description4";
	public String txtSCdescription5 = "description5";
	
	public String ajxSpecialty = "specialtySBsuggestBox";
	public String ajxSCServiceCode = "serviceCodeSBsuggestBox";
	public String ajxSCServiceCode1 = "xpath=(//input[@id='serviceCodeSBsuggestBox'])[2]";
	public String ajxSCServiceCode2 = "xpath=(//input[@id='serviceCodeSBsuggestBox'])[3]";
	public String ajxSCServiceCode3 = "xpath=(//input[@id='serviceCodeSBsuggestBox'])[4]";
	public String ajxSCServiceCode4 = "xpath=(//input[@id='serviceCodeSBsuggestBox'])[5]";
	public String ajxSCServiceCode5 = "xpath=(//input[@id='serviceCodeSBsuggestBox'])[6]";
	public String ajxSCModifiers1 = "//input[@id='modifier1SBsuggestBox']";
	public String ajxSCModifiers2 = "//input[@id='modifier2SBsuggestBox']";
	
	public String ajxSCModifiers3 = "xpath=(//input[@id='modifier1SBsuggestBox'])[2]";
	public String ajxSCModifiers4 = "xpath=(//input[@id='modifier2SBsuggestBox'])[2]";
	public String chkpreviewCheckBox = "xpath=//input[@type='checkbox']";
	public String chkInactiveSuperBill = "//span/input";

	public String lblsection = "//div[@class='row-fluid superbill-tables']/div/div/div";
	public String lblServiceCode = "//div[@class='row-fluid superbill-tables']/div/div/div[2]";
	public String lblsection1 = "//div[@class='row-fluid superbill-tables']/div[2]/div/div";
	public String lblServiceCode1 = "//div[@class='row-fluid superbill-tables']/div[2]/div/div[2]";
	public String lblSummerySuperBill = "//div[@id='SuperbillTemplateList']/table/tbody/tr/td";
	public String lblSummarySuperBillSetUp = "css=div.settings-content";
	public String cssPathSBI[] = { "css=#templateName", "css=#specialtySBsuggestBox" };

	public String cssPathServiceCode[] = { "css=#sectionLabel0",
			"css=#serviceCodeSBsuggestBox", "css=#description0",
			"css=#modifier1SBsuggestBox",
			"css=#modifier2SBsuggestBox" };

	public String cssPathServiceCode1[] = { "css=#sectionLabel1",
			"xpath=(//input[@id='serviceCodeSBsuggestBox'])[2]", "css=#description1",
			"xpath=(//input[@id='modifier1SBsuggestBox'])[2]",
			"xpath=(//input[@id='modifier2SBsuggestBox'])[2]" };

	// Super Bill Entry

	public String lnkSuperReviewQueue = "Unpostedsuperbills";
	public String chkManualReview="//div[@class='checkbox-group margin-left-10']/span/input";
	
	// Fee Schedlue
	public String lblEditFeeScheduleSummary = "css=div.billing-information-box";
	public String lnkFeeSchedule = "!billingFeeSchedule";
	public String lnkDelete = "//a[contains(text(),'Delete')]";
	public String btnAddNewFeeSchedule = "addNewFeeSchedule";
	public String ajxPayer = "payerSuggestBoxsuggestBox";
	public String ajxPlan = "suggestBox";
	public String ajxPractice = "practiceSuggestBoxsuggestBox";
	public String ajxLocation = "locationSuggestBoxsuggestBox";
	public String ajxSpeciality = "specialtySuggestBoxsuggestBox";
	public String ajxProvider = "providerSuggestBoxsuggestBox";
	public String ajxModifier = "modifierSuggestBoxsuggestBox";

	public String serviceCodeHTML = "serviceCodeHTML";
	public String ajxSearch = "searchTextBox";
	public String lblFeeSummary = "//table[@id='table']/tbody/tr/td/div/div"; 
	public String txtCodeRangeFrom = "codeRangeStart";
	public String txtCodeRangeTo = "codeRangeEnd";
	public String txtAllowedAmount = "xpath=(//input[@type='text'])[18]";
	public String txtEffectiveDate = "xpath=(//input[@type='text'])[19]";
	public String txtBaseUnits = "xpath=(//input[@type='text'])[20]";
	public String txtAllowedUnits = "xpath=(//input[@type='text'])[21]";
	public String txtAllowedAmount1 = "allowedAmountTextBox";
	public String txtEffectiveDate1 = "effectiveDate";
	public String txtBaseUnits1 = "baseUnits";
	public String txtAllowedUnits1 = "allowedBaseUnits";
	public String txtIncreaseAmount = "xpath=(//input[@type='text'])[12]";
	public String txtCopyEffectiveDate = "effectiveDateBox";
	public String txtFeeAllowAmount = "//input[@id='allowedAmountTextBox']";
	public String txtFeeEffectiveDate = "xpath=(//input[@id='effectiveDate'])";
	public String chkFeeInactive = "includeInactivesCheckboxcheckbox";
	public String serviceCodeSearchResult3 = "serviceCodeHTML";
	
	public String btnCancelFeeSchedule = "cancel";
	public String btnCopy = "link=Copy";

	public String lblFeeScheduleSummary = "//div[@id='FeeSchedulesList']/table/tbody/tr/td/div/div";

	public String ajxCopyPayer = "existingPayerSuggestBoxsuggestBox";
	public String ajxCopyProvider = "copyOptionsSuggestBoxsuggestBox";
	public String ajxAmountType = "xpath=(//input[@id='suggestBox'])[2]";

	public String lblFeeSchedule = "css=table.0.1";
	public String lnkEdit = "//a[contains(text(),'Edit')]";

	public String chkIncludeIactive = "//span/input";
	public String lnkActivate = "//a[contains(text(),'Activate')]";

	public String btnSaveFeeSchedule = "saveFeeSchedule";
	public String lblamountAlert="allowedAmountTextBoxNum11";
	
	public String lblAllowedAmountAlert="allowedAmountTextBoxNum9";
	public String lblDateAlert="//div[@id='effectiveDate']";
    public String lblChargeAmount = "xpath=(//div[@class='billing-table-rows'])[3]/div/div[2]";
	public String lblChargeUnit = "xpath=(//div[@class='billing-table-rows'])[3]/div/div[5]";

	public String csspathsFeeSchedule[] = { "" };

	// Adjustment Reasons
	public String txtSearchAdjustmentReason = "id=searchAdjustmentReasons";
	public String txtadjustmentReason = "id=adjustmentReason";
	public String txtdescription = "id=description";
	public String ajxc_DAdjusment = "xpath=(//input[@id='suggestBox'])[1]";
	public String ajxReportCategory = "xpath=(//input[@id='suggestBox'])[2]";
	public String ajxReportCategoryForEdit = "xpath=(//input[@id='suggestBox'])[1]";
	public String btnSave = "link=Save";
	public String btnAdd = "adjustmentReasonsAddNew";
	public String btnEdit = "link=Edit";
	public String btnDelete = "//a[contains(text(),'Delete')]";
	public String summaryAdjustmentReasons = "id=adjustmentReasons0";
	
	public String btnCancel = "link=Cancel";

	public String ajxSearchAdjustmentReason = "id=searchAdjustmentReasons";
	public String chkInactiveAdjustmentReason = "adjustmentReasonsIncludeInactivescheckbox";
	public String btnSaveAndAddAnother = "link=Save And Add Another";
	public String btnYesDeleteAdjustmentReason = "id=yesButton";
	public String lblEmptyList="id=adjustmentReasonsEmptyList";
	public String btnAdjActive = "link=Activate";





	// Service Codes Section Page Factoring
	public String btnManageServiceCodes = "manageServiceCodes";
	public String lnkServiceCode = "!billingServiceCodes";
	public String btnAddServiceCode = "manageServiceCodes";
	public String btnAddCustomServiceCode = "link=Add";
	public String lnkCustomTab = "!billingServiceCodesManageCustom";
	public String txtCustomServiceCode = "customServiceCode";
	public String txtCustomDescription = "customDescription";
	public String btnDoneServiceCode = "wizardDoneButton";
	public String txtServiceCode = "serviceCodeId";
	public String txtServiceCodeDescription = "serviceCodeDescription";
	public String txtCurrentFee = "currentFee";
	public String txtCurrentEffectiveDate = "currentEffectiveDate";
	public String txtNewFee = "newFee";
	public String txtNewEffectiveDate = "newEffectiveDate";
	public String txtUnits = "units";
	public String txtDrugCode = "drugCode";
	public String ajxServiceCodeModifier = "serviceCodeModifiersuggestBox";
	public String txtTotalRVU = "totalRVU";
	public String ajxTypeOfService = "typeOfServiceSuggestBoxsuggestBox";
	public String txtWorkRVU = "workRVU";
	public String txtGlobalPeriod = "globalPeriod";
	public String ajxReportGroup = "reportGroupSuggestBoxsuggestBox";
	public String ajxProviderSpeciality = "providerSpecialtySuggestBoxsuggestBox";
	public String txtInstructionToBiller = "instructionsToBiller";
	public String chkMultiplyFee = "multiplyFeecheckbox";
	public String chkTimedProcedure = "timedProcedurecheckbox";
	public String chkEPSDT = "epsdtcheckbox";
	public String chkFamilyPlanning = "familyPlanningcheckbox";
	public String chkTaxable = "taxablecheckbox";
	public String lnkMasterListTab = "!billingServiceCodesManageMasterlist";
	public String ajxCodingSystem = "suggestBox";
	public String txtSearchInMasterList = "searchCodeBox";
	public String txtFilterCodeRangeFrom = "codeRangeStart";
	public String txtFilterCodeRangeEnd = "codeRangeEnd";
	public String txtCodeStartDate = "codeStartDate";
	public String txtCodeEndDate = "codeEndDate";
	
	public String rdoSetServiceDefault = "//div[contains(text(),'Set Service Defaults')]/preceding-sibling::div/div/a";
	public String rdoSetServiceFees = "//div[contains(text(),'Set Service Fees')]/preceding-sibling::div/div/a";

	public String lblAddedServiceCodes = "//div[contains(text(),'Selected Service Codes')]/following-sibling::div[2]";
	public String lblFirstSearchResultInMasterList = "//div[@class='search-result-item']";
	public String lblFilterResultInMasterList = "//div[@class='search-results-wrapper']";
	public String lblFilterResultInSetServiceFee = "//div[@class='settings-table-content display-table']";
	public String lblFilterResultInServiceCode = "//div[@class='settings-table-content display-table preview-list']";
	public String lblFilterResultInServiceCodeFirst = "//div[@class='settings-table-content display-table preview-list']/div";
	public String lblDuplicateServiceCode = "//div[@id='customServiceCode']";
	public String lblSelectedServiceCodeFirstResult = "//div[contains(text(),'Selected Service Codes ')]/parent::div/div/div";

	public String lblMasterListServiceCode1 = "//div[@class='masterListCode']/div[3]/div/div[1]/div/div/div[2]";
	public String lblMasterListServiceCode2 = "//div[@class='masterListCode']/div[3]/div/div[2]/div/div/div[2]";
	public String lblMasterListServiceCode3 = "//div[@class='masterListCode']/div[3]/div/div[3]/div/div/div[2]";
	public String lblMasterListServiceCode4 = "//div[@class='masterListCode']/div[3]/div/div[4]/div/div/div[2]";

	public String lblMasterListServiceDescription1 = "//div[@class='masterListCode']/div[3]/div/div[1]/div/div/div[3]";
	public String lblMasterListServiceDescription2 = "//div[@class='masterListCode']/div[3]/div/div[2]/div/div/div[3]";
	public String lblSummaryServiceCodeRightPanel = "//div[contains(@class,'bordered-box-content')]";

	public String chkMasterListServiceCode1 = "xpath=(//input[@id='serviceCodeCheckBoxcheckbox'])";
	public String chkMasterListServiceCode2 = "xpath=(//input[@id='serviceCodeCheckBoxcheckbox'])[2]";
	public String chkSelectAllServiceCode = "//label[contains(text(), 'Select all')]/preceding-sibling::input";
	
	public String txtFeeAmountSecond = "xpath=(//input[@id='feeAmount'])[2]";
	public String txtUnitsSecond = "xpath=(//input[@id='units'])[2]";
	public String txtEffectiveDateInServiceFeeSecond = "xpath=(//input[@id='effectiveDate'])[2]";

	public String txtFeeAmount = "fee";
	public String txtEffectiveDateInServiceFee = "effectiveDate";
	public String btnSaveAndNext = "saveAndNext";
	public String btnEditServiceCode = "editServiceCode";
	public String btnSaveServiceCode = "saveServiceCode";
	public String btnCancelEdit = "cancelEdit";
	public String btnDeleteServiceCode = "deleteServiceCode";
	public String txtSearchInServiceCode = "searchCodeOrDescription";
	public String btnYesbutton = "yesButton";
	public String btnNobutton = "noButton";
	public String chkIncludeInactive = "includeInactivescheckbox";
	public String btnActiveServiceCode = "activeServiceCode";
	public String btnUpdateFees = "updateFees";
	public String btnCancelUpdateFees = "cancelButton";
	public String btnNextWizard = "wizardNextButton";
	public String btnBackWizard = "wizardBackButton";
	public String btnCopyServiceCode = "copyServiceCode";
	public String btnApply = "link=Apply";
	
	public String lblInActiveServiceCode = "css=div.display-row.list-item > div.display-cell.service-code-name";
	//Fix Me - MNT-1362
	public String lblStandaredFeeInSetServiceFee = "//div[@class='billing-table-rows']/div[2]/div[4]/span";
	public String lblStandaredEffectiveDateInSetServiceFee = "//div[@class='settings-table-content display-table']/div[2]/div[5]/span";
	
	public String txtIncreaseValue = "increaseAmount";
	public String ajxModiferType = "increaseModifierSuggestBoxsuggestBox";
	public String txtEffectiveNewDates = "effectiveDateNewFees";
	public String txtUpdateFeeAmount= "updateFeeAmount";
	public String txtUpdateFeeAmount1= "xpath=(//input[@id='updateFeeAmount'])[2]";
	public String txtNewFeeDate= "newFeeDate";
	public String txtNewFeeDate1= "xpath=(//input[@id='newFeeDate'])[2]";
	public String btnAddNewInServiceDefault = "link=Add new";
	public String txtPrivateFee1 ="privateFee";
	public String txtPrivateEffectiveDate1 = "effectiveOn";
	
	public String clkOverrideAll = "overrideAll";
	public String clkOverrideSome = "overrideSome";
	public String clkOverrideCancel = "overrideCancel";
	public String clkApply = "applyFeesButton";
	public String txtFeeAmount1 = "xpath=(//input[@id='feeAmount'])[2]";
	public String txtFeeAmount2 = "xpath=(//input[@id='fee'])[2]";
	
	public String btnSaveUpdate = "saveButton";
	public String lblFilterResultInServiceCodeFirst1 = "//div[@class='settings-table-content display-table preview-list']/div[2]";
	public String lblSummaryHeader = "//div[@class='settings-table-headings display-table']";
	public String vfyCurrentfee = "//div[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div/div[3]/div/div/div/div/div/div/div/div[3]/div/div[3]";
	public String vfyCurrentfee1 = "//div[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div/div[3]/div/div/div/div/div/div/div/div[3]/div[2]/div[3]";
	public String vfyNewfee = "//div[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div/div[3]/div/div/div/div/div/div/div/div[3]/div/div[4]";

	
	
	

		
	// Complete Super bill
	public String ajxServiceCode = "xpath=(//div[@id='panel'])[2]/input";
	public String ajxModifier1 = "xpath=(//div[@id='panel'])[3]/input";
	public String ajxModifier2 = "xpath=(//div[@id='panel'])[4]/input";
	public String ajxDiaCode = "xpath=(//div[@id='panel']/input)[8]";
	public String chkPayer = "link=Select payers";
	public String ajxBillTo = "billToPayersListSuggestBoxsuggestBox";
	public String chkCSBHardCopy = "//label[contains(text(),'Hard copy')]/parent::span/parent::div/span/input";
	public String ajxServiceCodePremium="xpath=(//input[@id='serviceCodeSuggestBoxsuggestBox'])[2]";
	
	
	
	// super bill review Queue
	public String lnkSuperBill = "Unpostedsuperbills";
	public String lnkSuperBillHide = "SlideWindowHideAnchor";
	public String ajxRenderingProvider = "renderingProvidersuggestBox"; 
	public String ajxBillingProvider = "id=billingProvidersuggestBox";
	public String ajxSEQLocation = "locationsuggestBox";
	public String ajxBProvider="billingProvidersuggestBox";
	public String ajxPlaceOfService = "placeOfServicesuggestBox";
	public String txtDateOfService="css=input.gwt-DateBox";
	public String txtSBIUnits = "units";
	public String txtSearch = "css=input.width175px.roundedSearchBox";
	public String txtFromData = "xpath=(//input[@type='text'])[10]";
	public String txtToData = "xpath=(//input[@type='text'])[11]";
	
	public String chkServiceCode ="xpath=(//input[contains(@id,'checkboxcheckbox')])";

	public String lblDateOfService = "//div[@class='settings-table-headings display-table box']/div/div[2]";
	public String lblProvider= "//div[@class='settings-table-headings display-table box']/div/div[3]";
	public String lblPatient = "//div[@class='settings-table-headings display-table box']/div/div[4]";
	public String lblLocation = "//div[@class='settings-table-headings display-table box']/div/div[5]";
	public String lblClaimCount = "//div[contains(@id,'superbillQueueItem')]";
	
	//public String lblCountPaperQueue ="//div[@id='Paperclaimstoreview']/div/span";
	public String lblCountPaperQueue ="//div[@id='Claimsonhold']/div";
	

	public String cssPathBillQueue[]={"css=input.width175px.roundedSearchBox","xpath=(//input[@type='text'])[10]","xpath=(//input[@type='text'])[11]"};


	// Charge Entry
	// FIXME 
	
	public String lnkUpdateDemographics="link=Update demographics";
	public String lnkPostCharge = "xpath=(//a[contains(text(),'Post charges')])[2]";
	public String lnkPostChargeHome = "link=Post charges";
	public String lnkViewRegistration="patientOptionsRegistration";
	public String lnkPostNewCharge = "link=Post new charges with no encounter.";
	public String btnAddNewDiagnosisCode = "addNewRowButton";
	public String btnAddNewDiagnosisCode1 = "xpath=(//a[@id='addNewRowButton']/div)[2]";
	public String btnAddNewServiceLine = "addButton";
	public String btnDelDiagnosisCode = "xpath=(//a[@id='deleteDiagnosisCodesRow'])[2]";
	public String lstDiagnosis41 = "//div/input[@id='diagnosisCode41suggestBox']";
	public String lstDiagnosis51 = "//div/input[@id='diagnosisCode51suggestBox']";
	public String lstDiagnosis61 = "//div/input[@id='diagnosisCode61suggestBox']";
	public String lstDiagnosis71 = "//div/input[@id='diagnosisCode71suggestBox']";
	public String lstDiagnosis82 = "//div/input[@id='diagnosisCode82suggestBox']";
	public String lnkDeleteServiceLine = "//a[@id='deleteButton']/div";
	public String lnkDeleteServiceLine1 = "xpath=(//a[@id='deleteButton']/div)[2]";
	public String lnkDeleteServiceLine2 = "xpath=(//a[@id='deleteButton']/div)[3]";
	public String txtServiceLineUnits1 = "id=units";
	public String txtServiceLineUnits2 = "xpath=(//input[@id='units'])[2]";
	public String dateSLDateCA2="xpath=(//div[@id='serviceItemDateServicedPanel']/input)[2]";
	public String btnCopyServiceLine1 = "copyButton";
	public String btnActions = "link=Actions";
	public String lnkCancel = "id=cancel";
	public String btnAddNewProvider = "link=Add new provider";
	public String ajxProviderChargeEntry = "id=providersuggestBox";
	public String ajxProviderChargeEntry0 = "id=provider0suggestBox";
	public String ajxProviderTypeChargeEntry = "id=providerTypesuggestBox";
	public String ajxProviderTypeChargeEntry0 = "id=providerType0suggestBox";
	public String btnDeleteProvider = "css=div.delete-button";
	public String btnAddNew = "css=div.inline-block > a.secondary-button > div.add-button";
	public String lstRenderingProvider = "id=renderingProvidersuggestBox";
	public String ajxSpecialtyCE = "specialtySuggestBoxsuggestBox";
	public String lstBillingProvider = "id=billingProvidersuggestBox";
	public String location = "id=locationsuggestBox";
	public String placeOfService = "id=placeOfServicesuggestBox";
	public String lstDiagnosis00 = "diagnosisCode00suggestBox";
	public String ajxServiceCodeCharge = "serviceCodeSuggestBoxsuggestBox";
	public String txtFee = "fee";
	public String lblChargeAmountCE = "id=chargeAmount";
	public String lblChargeAmountPremium="xpath=(//input[@id='chargeAmount'])[2]";
	public String lblChargeAmountCE2 = "xpath=(//input[@id='chargeAmount'])[2]";
	public String lblTotal = "id=totalCharges";
	public String serviceCode = "id=serviceCodeSuggestBoxsuggestBox";
	public String btnSaveChargeEntry = "link=Save";
	public String btnPostChargeEntry = "link=Post";
	public String ajxPayToBox = "payToSuggestBoxsuggestBox";
	//FIXME MNT-1314
	public String serviceTimePopUp = "servUnitPopup";
	public String startTimeServiceTimeHr = "startTimeHours";
	public String startTimeServiceTimeMin =  "startTimeMinutes";
	public String chkBoxManualReview="hardCopyCheckBox";
	public String txtWriteOffBalance="xpath=(//input[@id='balanceAtLeast'])[2]";
	//FIX_ME BLG-574
	public String ajxPayToSuggestBox = "xpath=(//input[@id='suggestBox'])[4]";
	public String chkBoxAccident = "accidentRelatedChargecheckbox";
	public String chkBoxEmployment = "employmentAccidentcheckbox";
	public String chkBoxAuto = "autoAccidentcheckbox";
	public String chkBoxOther = "otherAccidentcheckbox";
	public String dateAccidentDate = "//div[2]/div/div[1]/div[2]/input";
	public String lstAccidentState = "id=accidentStatesuggestBox";
	public String txtAccidentChargeDate = "accidentDate";
	public String txtStartHour = "startHour";
	public String txtStartMinute = "startMinute";
	public String lstamPm = "amPMSelectsuggestBox";
	public String btnAddNewDate = "link=Add new date";
	public String btnDeleteDate1 = "link=Delete";
	public String dateAddDate = "id=null0";
	public String lstDateType = "id=dateType0suggestBox";
	public String lstspecialty = "id=specialtySuggestBoxsuggestBox";
	public String lstReferringProvider = "id=referringProvidersuggestBox";
	public String lstCase = "id=entryCasesuggestBox";
	public String lstProgram = "id=programsuggestBox";
	public String lstmodifiers = "id=modifier1SuggestBoxsuggestBox";
	public String diagnosisCodeSL = "diagnosisCode1SuggestBoxsuggestBox";
	public String diagnosisCodeSLCA="diagnosisCodeSuggestBoxsuggestBox";
	public String dateSLStartDate = "//div[@id='serviceItemDateServicedFromPanel']/input";
	public String dateSLEndDate = "//div[@id='serviceItemDateServicedToPanel']/input";
	public String medicalPayers = "//div[3]/div[2]/div/div/div/div/div[3]/div[2]/div/div";
	public String lstAmbulanceTransReason = "id=ambulanceTransportReasonsuggestBox";
	public String lnkShowDetail = "id=detailsAnchor";
	public String chkAmbulanceTrans = "id=visitContainsAmbulancecheckbox";
	public String lnkClickToSelectConditionCode = "xpath=(//a[contains(text(),'Click to select')])[1]";
	public String lstMultiSelectConditionCode = "//div[4]/div[4]/div[2]/div/div/div";
	public String lstMultiSelectEPSDT = "//div[2]/div/div/div[4]/div[4]/div[1]/div/div/div";
	public String btnPayerList = "!patientPayersList";
	public String btnPatientMedicalPayers = "medicalPayers";
	public String lnkUnprintedStatements = "id=Unprintedstatements";
	public String btnPatientOtherPayers = "otherPayers";
	public String lblEmpPayers = "id=patientPayerWidget";
	public String lblNoPayer = "//div[3]/div[2]/div/div/div/div/div[1]/div";
	public String lnkReferrals = "!patientReferralList";
	public String btnAddReferral = "addReferral";
	public String lstAuthorization = "id=authorizationNumberSuggestBoxsuggestBox";
	public String lstSpclProgCode = "id=specialProgramCodesuggestBox";
	public String lstDelayReaCode = "id=delayReasonCodesuggestBox";
	public String chkStnFamilyPlanning = "id=situationFamilyPlanningcheckbox";
	public String chkStnEmergency = "id=situationEmergencycheckbox";
	public String chkStnEPSDT = "id=situationEPSDTcheckbox";
	public String chkChiroPrac = "id=visitContainsChiropracticcheckbox";
	public String chkDME = "id=visitContainsDMEcheckbox";
	public String chkOxygen = "id=visitContainsOxygencheckbox";
	public String chkNDCDrug = "id=visitContainsNdccheckbox";
	public String lstCorrection = "id=correctionToTakesuggestBox";
	public String txtOrgClaimRef = "id=originalClaimReferenceNumber";
	public String txtPatientWeight = "id=patientWeight";
	public String txtPatientCount = "id=patientCount";
	public String txtTransDist = "id=ambulanceTransportReasonsuggestBox";
	public String txtTransDistance = "transportDistance";
	public String txtRoungTrip = "id=roundTripPurpose";
	public String txtStretcherPurpose = "stretcherPurpose";
	public String txtStreet1 = "id=addr1";
	public String txtDropStreet1 = "xpath=(//input[@id='addr1'])[2]";
	public String txtStreet2 = "id=addr2";
	public String txtDropStreet2 = "xpath=(//input[@id='addr2'])[2]";
	public String txtCity = "id=city";
	public String txtDropCity = "xpath=(//input[@id='city'])[2]";
	public String lstState = "id=stateSuggestBoxsuggestBox";
	public String lstDropState = "xpath=(//input[@id='stateSuggestBoxsuggestBox'])[2]";
	public String txtZip = "id=zip";
	public String txtstatementNote = "css=textarea.text-area";
	public String txtDropZip = "xpath=(//input[@id='zip'])[2]";
	public String lstCountry = "id=countrySuggestBoxsuggestBox";
	public String lstDropCountry = "xpath=(//input[@id='countrySuggestBoxsuggestBox'])[2]";
	public String lstPatientCond = "id=patientConditionsuggestBox";
	public String txtCondDesc = "id=conditionDescription";
	public String dateInitialTreat = "id=initialTreatmentDate";
	public String dateAcuteMan = "id=acuteManifestationDate";
	public String radYes = "id=Yesradio";
	public String radNo = "id=Noradio";
	public String dateLastXray = "id=initialTreatmentDate";
	public String lstDMECerti = "id=dmeCertificationsuggestBox";
	public String txtCTCode = "certificateTransmissionCodesuggestBox";
	public String txtEquipDuration = "id=equipmentDuration";
	public String dateCertiRev = "id=certificationRevisionDate";
	public String dateBeginTherapy = "id=beginTherapyDate";
	public String dateLastCerti = "id=lastCertificationDate";
	public String txtPatientHeight = "id=patientHeight";
	public String txtDMEPatientWeight = "id=dmePatientWeight";
	public String txtLenMedicalNece = "id=lengthOfMedicalNecessity";
	public String txtRentalPrice = "id=rentalPrice";
	public String lstRentalPriceUnit = "id=rentalPriceUnitsuggestBox";
	public String txtPurchasePrice = "id=purchasePrice";
	public String lnkDMECertiCondition = "xpath=(//a[contains(text(),'Click to select')])[3]";
	public String lstOxyCerti = "id=oxygenCertificationsuggestBox";
	public String txtOxyduration = "id=oxygenDuration";
	public String lnkOxyCertiCondition = "xpath=(//a[contains(text(),'Click to select')])[3]";
	public String dateOxyCertiRev = "id=oxygenCertificationRevisionDate";
	public String ajxOxygenCertificateTransission = "oxygenCertificateTransmissionCodesuggestBox";
	public String dateOxyBeginTherapy = "id=oxygenBeginTherapyDate";
	public String dateOxyLastCerti = "id=oxygenLastCertificationDate";
	public String txtNDCDrugCode = "id=drugCode";
	public String txtQuantity = "id=quantity";
	public String lstPresciptionType = "id=unitTypesuggestBox";
	public String lstUnitType = "id=unitTypesuggestBox";
	public String txtPrescriptionNum = "id=prescriptionNumber";
	public String datePrescription = "id=prescriptionDate";
	public String practice = "//div[@id='practices']/table/tbody[1]/tr";
	public String lnkpractice = "//div[@id='practices']/table/tbody[1]/tr[%d]/td[1]/div/div/div/span";
	public String providers = "//div[1]/div/div/div[1]/div[1]/span/span";
	public String rendingProviders = "//body/div[5]/div/div/div/div/div";
	public String lnkSystemSetings = "id=systemSettingsAction";
	public String lnkAdminOrgStructureLists = "!adminOrgStructureLists";
	public String lnkExternalProviders = "!adminExternalProviderList";
	public String externalProviders = "//div[@id='AdminReferringProviderList']/table/tbody[1]/tr";
	public String lnkPatientBillingHistory = "css=div.chart-title.title-underlined";
	public String lblCountClaims = "css=div.gwt-Label";
	public String lnkClose = "css=a.close-popup-x.close-help-about-popup";
	public String lnkEncounterNote = "link=View encounter note";
	public String lblEncounterNote = "//body/div[6]/div/div";
	
	//FIXME-BLG-574
	public String btnAddPostCharge = "css=div.add-button";
	
	public String ajxPostChargeSearchPatient = "xpath=(//input[@id='searchPatientBox'])[2]";
	public String noteServiceLine = "css=div.add-note-comment-icon";
	// public String notePopUp="//body/div[6]/div";
	public String lnkNoteEdit = "id=DEFAULTEdit";
	public String lnkNoteSave = "id=DEFAULTSave";
	public String lnkNoteComment = "id=DEFAULTCommentBox";
	public String lnkNoteViewHistory = "id=DEFAULTViewHistory";
	public String lnkNoteCancel = "id=DEFAULTCancel";
	public String lnkNoteHideComment = "id=DEFAULTHideComment";
	public String lblNoteHistory = "//div[@id='commentsAnchor']/div/div[%d]/div";
	public String lblNoteHistoryCount = "//div[@id='commentsAnchor']/div/div";
	public String lblProviderCount = "//div/div[2]/div[4]/div/div/div[1]/div[1]/span/span";
	public String lstBillTo = "id=billToPayersListSuggestBoxsuggestBox";
	public String endTimeServiceTimeHr = "//div[2]/div[3]/div/div[2]/div/input";
	public String endTimeServiceTimeMin = "//div[3]/div/div[4]/div/input";
	public String durationServiceTime = "//div[5]/div/div[2]/input";
	public String btnSaveServiceTime = "//div[6]/button[1]";
	public String btnCancelServiceTive = "//div[6]/button[2]";
	public String lblPatientInfo = "css=div.chart-content";
	public String lnkBillingHistory = "link=Billing history";
	public String lnkBillingSummary = "!billingSummaryHistory";
	public String lnkChargeHistory = "!billingChargesHistory";
	public String lnkPaymentHistory = "!billingPaymentsHistory";
	public String lnkStatementHistory = "!billingStatementsHistory";
	public String lnkPayerHistory = "!billingPayersHistory";
	public String lnkVisitHistory = "!billingVisitHistory";
	public String lnkPersonalHistory = "!billingPersonalHistory";
	public String lnkReferralsHistory = "!billingReferralsHistory";
	public String lblgender = "female";
	public String lbldob = "01/19/1966";
	public String lblAddress = "789 Memory Lane, Bakersfield CA 93309";
	public String lblContactNumber = "(661) 123-1234";
	public String ajxTherapy="//input[@id='suggestBox']";
	public String btnSaveTherapy="xpath=(//a[contains(text(),'Save')])[3]";
	public String ajxRenderingProviderSL="renderProviderSuggestBoxsuggestBox";
	public String chkboxInpatient ="inPatientCheckBoxcheckbox";
	public String dateOfAddmission="dateOfAdmission";
	public String ajxserviceLevInd="suggestBox";
	// #FIX ME 
	public String ajxPayTo="xpath=(//input[@id='suggestBox'])[4]";
	public String ajxGroupNumber="xpath=(//input[@id='suggestBox'])[4]";
	public String btnAddPremium="addPremiumButton";

	public String ajxPaymentProgram="paymentProgramSuggestBoxsuggestBox";

	//post Patient Payments
	
	public String lnkEpandArrow = "expand";
	public String lnkStartNewBranch = "link=Or start a new batch >>";
	
	public String txtdepositDate = "depositDate";
	public String txtreferenceNo = "referenceNumber";
	public String txpaidAmount = "paidAmount";
	public String txPaidAmount1 = "xpath=(//input[@id='paidAmount'])[2]";
	public String txtPaidAmount3= "xpath=(//input[@id='paidAmount'])[3]";
	public String txtPaidAmount4 = "xpath=(//input[@id='paidAmount'])[4]";
	public String txtPaidAmount5 = "xpath=(//input[@id='paidAmount'])[5]";
	public String txtSPaidAmount="paidAmount";
	public String txtTotalPaidAmount = "totalPaidAmount";
	public String txtCommentBox = "DEFAULTCommentBox";
	public String scrollPanel="class=scrollPanel";
	
	public String ajxMethodOfPayment= "methodOfPaymentSBsuggestBox";
	public String ajxMethodOfPayment2 = "xpath=(//input[@id='methodOfPaymentSBsuggestBox'])[2]";
	public String ajxMOP="xpath=(//input[@id='suggestBox'])[5]";
	public String ajxPPPprovider = "providerSuggetionBox";
	public String ajxPPPLocation = "locationSuggestBox";
	public String ajxChargesOpen ="//div[contains(text(),'Charges')]/following-sibling::div/div/div/input";
	
	public String chkUnAllocate = "leaveUnallocatedcheckbox";
	public String chkAutoAllocate = "xpath=(//input[@id='autoAllocatecheckbox'])[2]";
	public String chkAutoAllocatePayment = "autoAllocatecheckbox";
	public String chkAutoAllocate1 = "xpath=(//input[@id='autoAllocatecheckbox'])[3]";
	
	public String imgNotePopUp="addCommentIcon";
	public String imgSPaidAmount = "warningPopupPanel";
	public String imgUnAllocatedPopUp = "css=div.popupContent";
	public String lblPPChargeEntry = "//div[@class='billing-inner-table-wrapper']/div[4]";
	public String txtUnAppliedAmount = "unappliedAmount";
	
	public String lblTotalPaidAmount = "totalPaidAmountLabelWrapper";
	public String lblTotalAppliedAmount = "totalAppliedAmountLabelWrapper";
	public String lblTotalUnAppliedAmount ="totalUnappliedAmountLabelWrapper";
	public String lblChDateOfService = "css=div.display-row.vertical-align-top > div.display-cell.width-90";
	public String lblChServiceCode = "css=div.display-row.vertical-align-top > div.display-cell.width-80";
	public String lblChChargeAmount = "//div[@id='patientChargesPanel']/div/div[3]";
	public String lblChAmountDue = "//div[@id='printInfo']/div/div[3]/div/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div[4]/div/div[4]";
	public String lblChCurrentPayer = "css=div.display-row.vertical-align-top > div.display-cell.width-95";
	public String lblChProvider = "provider";
	public String lblChLocation = "location";
	public String lblChSpecialty = "css=div.display-row.vertical-align-top > div.display-cell.width-180";
	
	public String btnPPRemove = "//div[@class='display-cell remove input-col text-align-center']/a";
	public String btnPPRemove1 = "xpath=(//div[@class='display-cell remove input-col text-align-center']/a)[2]";
	public String btnPPRemoveYes="xpath=(//button[@type='button'])[4]";
	public String btnPPRemoveNo="xpath=(//button[@type='button'])[5]";
	public String btnPost ="post";
	public String btnPostYes = "YesFormButton";
	public String btnPPPCancel="cancel";
	public String btnPPtSave = "save";
	public String btnPopUpSave = "DEFAULTSave";
	
	// Post Patient Payment Queue
	public String lnkPPatientPaymentQueue = "recordAttendanceActionInHomePage";
	public String btnPPatiemtPaymentAdd = "link=Add New";
	public String txtSearchPatientId = "xpath=(//div[@class='search-box-wrapper'])[2]/div/input";
	public String txtSearchPatientId1 = "xpath=(//div[@class='search-box-wrapper'])[4]/div/input";
	public String txtSearchPatient = "xpath=(//input[@id='searchPatientBox'])[2]";
	public String txtSearchPatient1 = "xpath=(//input[@id='searchPatientBox'])[5]";
	
	
	//Enter Patient Payment
	public String lnkEnterPatientPayment = "!patientPaymentBatch";
	public String lnkPostPayerPayment = "postPayerPayments";
	
	//statement Preferences
	
	public String lnkStatementPreferences="!billingSettingsStatementPreferencesShow";
	public String btnDeactivateAutoGen="link=Deactivate auto generation of statements";
	public String btnEditStatePre="link=Edit";
	public String btnWizardNext="id=wizardNextButton";
	public String btnWizardBack="id=wizardBackButton";
	public String btnWizardDone="id=wizardDoneButton";
	public String lnkDotMetaInfo="//*[@id='BlueNavigationWiget_MainPanel']/div[2]/div[1]/div[1]/div/a";
	public String lnkDotFormate="//*[@id='BlueNavigationWiget_MainPanel']/div[2]/div[2]/div[1]/div/a";
	public String lnkDotStatementCycle="//*[@id='BlueNavigationWiget_MainPanel']/div[2]/div[3]/div[1]/div/a";
	public String lnkDotDunningMsg="//*[@id='BlueNavigationWiget_MainPanel']/div[2]/div[4]/div[1]/div/a";
	public String chkIncludeInactiveSP="includeInactivePatientscheckbox";
	public String chkInCollection="includeInCollectionsPatientscheckbox";
	public String chkIncludeDeceased="includeDeceasedPatientscheckbox";
	public String txtWaitDays="waitDays";
	public String chkSendStmtAftFullPay="sendStatementAfterFullPaymentcheckbox";
	public String chkShowChrgPaid="showChargesPaidSinceLastStatementcheckbox";
	public String lblWaitDays="//div/div/div/div/div/div[2]/div/div[1]/div/div/div[3]";
	public String txtMinPayment="id=minimumPayment";
	public String lblMinimumPayment="//div[2]/div/div[2]/div[1]/div[1]";
	public String lblBalanceAtLeast="//div[2]/div/div[2]/div[2]/div[1]";
	public String lblWriteOffBalance="//div[3]/div/div/div/div/div/div/div[2]/div/div[3]/div/div";
	public String txtBalanceAtLeast="balanceAtLeast";
	public String lstAdjustmentCode="id=suggestBox";
	public String txtSearchClaimPatient =  "BillingPaymentHistorySearchBox";
	public String lblPayerNameUnpostQueue1 = "//div[@id='superbillQueueItem_8']/div/div/div[4]";
	public String btnClaimAdd = "add-button";

	
	// Payer payment Section Page Factoring
	public String lnkPayerPayment = "!managePaymentBatch";
	public String lnkUnpostedQuee = "Unpostedpayerbatches";
	public String ajxInsurance = "insuranceSBsuggestBox";
	public String txtCheckAmount = "chequeAmount";
	public String txtCheck = "chequeNumber";
	public String txtDepositDate = "depositDate";
	public String txtTotalPaidAmt = "totalPaidAmount";
	public String adjustmentReason = "contractualAdjustmentReasonSBsuggestBox";
	public String txtClaimNumber = "claimNumber";
	public String txtClaimPatientSearch = "xpath=(//input[@id='searchPatientBox'])[2]";
	public String txtClaimPatientSearch1 = "xpath=(//input[@id='searchPatientBox'])[3]";
	public String btnAddClaim = "addNew";
	public String txtAllowedAmt1 = "allowedAmount";
	public String txtDeductable1 = "deductible";
	public String txtCoInsurance1 = "coInsurance";
	public String txtCoPayment1 = "coPayment";
	public String txtPaidAmount1 = "paidAmount";
	public String txtContaractualAdjustment1 = "contractualAdjustment";
	public String ajxAdjustmentReason1 = "adjustmentReasonSBsuggestBox";
	public String txtAdjustmentAmount1 = "adjustmentAmount";
	
	public String txtAllowedAmt2 = "xpath=(//input[@id='allowedAmount'])[2]";
	public String txtDeductable2 = "xpath=(//input[@id='deductible'])[2]";
	public String txtCoInsurance2 = "xpath=(//input[@id='coInsurance'])[2]";
	public String txtCoPayment2 = "xpath=(//input[@id='coPayment'])[2]";
	public String txtPaidAmount2 = "xpath=(//input[@id='paidAmount'])[2]";
	public String txtContaractualAdjustment2 = "xpath=(//input[@id='contractualAdjustment'])[2]";
	public String txtAdjustmentAmount2 = "xpath=(//input[@id='adjustmentAmount'])[2]";
	public String ajxPatientClaim = "filterClaimsSearchBox"; 
	
	
	public String lblSubTotalAllowedAmt = "//div[@class='display-row billing-subtotal-row']/div[5]";
	public String lblSubTotalDeductable = "//div[@class='display-row billing-subtotal-row']/div[6]";
	public String lblSubTotalCoInsurance = "//div[@class='display-row billing-subtotal-row']/div[7]";
	public String lblSubTotalCoPayment = "//div[@class='display-row billing-subtotal-row']/div[8]";
	public String lblSubTotalPaidAmount = "//div[@class='display-row billing-subtotal-row']/div[9]";
	public String lblSubTotalContaractualAdjustment = "//div[@class='display-row billing-subtotal-row']/div[10]";
	public String lblSubTotalAdjustmentAmount = "//div[@class='display-row billing-subtotal-row']/div[12]";
	
	public String ajxNextPayer = "nextPayerSBsuggestBox";
	public String btnShowClaimAdjustment = "show";
	public String chkHold = "putOnHoldcheckbox";
	
	public String txtClaimSearch = "filterClaims";
	public String lnkDeleteClaim = "xpath=(//a[contains(@class,'delete-x-medium-icon')])[1]";
	public String lblSecondClaim = "xpath=(//strong[contains(text(),'Claim')])[2]";
	public String lnkDeleteSecondClaim = "xpath=(//a[contains(@class,'delete-x-medium-icon')])[2]";
	public String txtCASAmount = "claimAdjustmentAmount";
	public String CASSave = "xpath=(//button[@id='save'])[2]";
	public String CASCancel = "xpath=(//button[@id='cancel'])[2]";
	public String lblTotalPaidAmountPayer = "totalPaidAmountLabel";
	public String lblRemainingBalance = "balanceLabel";
	public String lblUnpostedCount = "//div[@id='Unpostedpayerbatches']/div/span";
	public String lblSummaryUnpostQueue = "//div[@class='box']";
	public String lblPayerNameUnpostQueue = "//div[@class='settings-table-headings display-table']/div/div[2]";
	public String lblCheckNumberUnpostQueue = "//div[@class='settings-table-headings display-table']/div/div[3]";
	public String lblEnteredAmtUnpostQueue = "//div[@class='settings-table-headings display-table']/div/div[4]";
	public String lblCheckAmtUnpostQueue = "//div[@class='settings-table-headings display-table']/div/div[5]";
	public String lblStartedOnUnpostQueue = "//div[@class='settings-table-headings display-table']/div/div[6]";
	public String lblDepositDateUnpostQueue = "//div[@class='settings-table-headings display-table']/div/div[7]";
	public String lblFirstRowInUnpostedQueue = "//div[@class='box']/div/div/div";
	public String btnYesInPost = "YesFormButton";
	public String btnNoInPost = "NoFormButton";
	
	//Paper Claims To Review
	public String lnkPaperClaims = "Paperclaimstoreview";
	public String chkHardCopy = "//div[3]/div/span/input";
	public String txtPaperSearchPatient = "searchTextBox";
	public String txtFromDate = "//div[@id ='serviceItemDateServicedFromPanel']/input";
	public String txtToDate = "css=#serviceItemDateServicedToPanel > input.gwt-DateBox.text-box";
	public String txtAccidentDate = "css=div.control-group.validation-error > div.display-cell > input.gwt-DateBox";
	public String txtFromDate1 = "//div[@id='serviceItemDateServicedPanel']/input"; 

	//On Hold Claims
	public String lnkOnHold = "Claimsonhold";
	public String lnkUnprintedStatement = "Unprintedstatements";
	public String ajxDateFor = "xpath=(//input[@id='suggestBox'])[3]";
	
	//Claims Rejection Queue
	public String lnkClaimsRejection= "ClaimRejectionstoreview";
	
	// Statement Batch Review Section Page Factoring
	//ajxSearch
	//ajxSpecialty
	//ajxSCModifiers1
	public String txtFromDateUnprintStatement = "SQFromDateBox";
	public String txtToDateUnprintStatement = "SQToDateBox";
	public String btnPrintSendUnprintStatement = "css=div.print-send-button";
	public String btnPrintUnprintStatement = "css=span.buttons > button.gwt-Button";
	public String chkFirstItemInUnprintStatement = "//div[@class='display-table']/div/span/input";
	public String lnkClosePreview="framePopupViewCloseButton";
	//lnkSuperBillHide
	//lnkUnprintedStatements

	public String lnkchargePayerAction = "link=Actions";
	public String lnkChargeAction = "xpath=(//a[contains(text(),'Actions')])[3]";
	public String lnkChargeActionLink = "xpath=(//a[contains(text(),'Actions')])"; 
	public String lnkAdjustCharge = "adjustCharge";
	public String ajxchrReason = "suggestBox";
	public String txtChrAmount ="css=input.gwt-TextBox";
	public String txtPayerReason = "changePayerReason";
	public String txtPAppliedAmount = "css=input.margin0";
	public String ajxChrPayer = "xpath=(//input[@id='suggestBox'])[6]";
	public String btnChrSave = "css=a.inline-block.secondary-button";
	public String btnChrYes = "link=Yes";
	public String lblInsurance = "insuranceBalance";
	public String lnkpostPatientPayment = "postPatientPayments";
	public String lnkApplyPatientPayment ="applyPatientPayment";
	public String lnkChangeToPatient = "changeToPatient";
	public String lnkChangePayer = "changePayer";
	public String lnkSend = "link=Send";
	public String lnkVoidCharge = "voidCharge";
	public String lnkVoidPayment = "voidPayment";
	public String btnPaymentYes = "css=button.secondary-button.triggerClose";
	public String lnkSettings ="link=Settings";
	public String dateSLDateCA="serviceItemDateServicedPanel";
	
	
	
	 
	 
	
	public String ajxServiceCode2 = "xpath=(//input[@id='serviceCodeSuggestBoxsuggestBox'])[2]";
	public String ajxServiceCode3 = "xpath=(//input[@id='serviceCodeSuggestBoxsuggestBox'])[3]";
	public String ajxServiceCode4 = "xpath=(//input[@id='serviceCodeSuggestBoxsuggestBox'])[4]";
	public String ajxServiceCode5 = "xpath=(//input[@id='serviceCodeSuggestBoxsuggestBox'])[5]";
	public String ajxServiceCode6 = "xpath=(//input[@id='serviceCodeSuggestBoxsuggestBox'])[6]";
	public String ajxServiceCode7 = "xpath=(//input[@id='serviceCodeSuggestBoxsuggestBox'])[7]";
	public String ajxServiceCode8 = "xpath=(//input[@id='serviceCodeSuggestBoxsuggestBox'])[8]";
	public String ajxServiceCode9 = "xpath=(//input[@id='serviceCodeSuggestBoxsuggestBox'])[9]";
	public String ajxServiceCode10= "xpath=(//input[@id='serviceCodeSuggestBoxsuggestBox'])[10]";
	
	public String txtFee2 = "xpath=(//input[@id='fee'])[2]";
	public String txtFee3 = "xpath=(//input[@id='fee'])[3]";
	public String txtFee4 = "xpath=(//input[@id='fee'])[4]";
	public String txtFee5 = "xpath=(//input[@id='fee'])[5]";
	public String txtFee6 = "xpath=(//input[@id='fee'])[6]";
	public String txtFee7 = "xpath=(//input[@id='fee'])[7]";
	public String txtFee8 = "xpath=(//input[@id='fee'])[8]";
	public String txtFee9 = "xpath=(//input[@id='fee'])[9]";
	public String txtFee10 = "xpath=(//input[@id='fee'])[10]";
	public String txtFromDate2 ="Xpath=(//div[@id ='serviceItemDateServicedFromPanel'])[2]/input";
	public String txtFromDate3 ="Xpath=(//div[@id ='serviceItemDateServicedFromPanel'])[3]/input";
	public String txtFromDate4 ="xpath=(//div[@id ='serviceItemDateServicedFromPanel'])[4]/input";
	public String txtFromDate5 ="Xpath=(//div[@id ='serviceItemDateServicedFromPanel'])[5]/input";
	public String txtFromDate6 ="Xpath=(//div[@id ='serviceItemDateServicedFromPanel'])[6]/input";
	public String txtFromDate7 ="Xpath=(//div[@id ='serviceItemDateServicedFromPanel'])[7]/input";
	public String txtFromDate8 ="Xpath=(//div[@id ='serviceItemDateServicedFromPanel'])[8]/input";
	public String txtFromDate9 ="Xpath=(//div[@id ='serviceItemDateServicedFromPanel'])[9]/input";
	public String txtFromDate10 ="Xpath=(//div[@id ='serviceItemDateServicedFromPanel'])[10]/input";
	public String txtTotalCharge = "totalCharges";
	public String lblPatientBalance = "patientBalance";
	public String lnkPostPayer ="link=Post payer payments";
	
	public String txtReferenceNo = "xpath=(//input[@id='referenceNumber'])[2]";
	public String lnkShowDetails = "xpath=(//div[@id='showDetailsLabel'])[11]";
	public String lnkReverse = "link=Reverse";
	
	public String diagnosisCode2 = "diagnosisCode10suggestBox";
	public String diagnosisCode3 = "diagnosisCode20suggestBox";
	public String diagnosisCode4 = "diagnosisCode30suggestBox";
	public String diagnosisCode5 = "diagnosisCode41suggestBox";
	public String diagnosisCode6 = "diagnosisCode51suggestBox";
	public String diagnosisCode7 = "diagnosisCode61suggestBox";
	public String diagnosisCode8 = "diagnosisCode71suggestBox";
	public String diagnosisCode9 = "diagnosisCode82suggestBox";
	public String diagnosisCode10 = "diagnosisCode92suggestBox";
	public String diagnosisCode11= "diagnosisCode102suggestBox";
	public String diagnosisCode12 = "diagnosisCode112suggestBox";
	
	public String Modifier2= "modifier2SuggestBoxsuggestBox";
	public String Modifier3= "modifier3SuggestBoxsuggestBox";
	public String Modifier4= "modifier4SuggestBoxsuggestBox";
	
	public String Modifier5= "xpath=(//input[@id='modifier1SuggestBoxsuggestBox'])[2]";
	public String Modifier6= "xpath=(//input[@id='modifier2SuggestBoxsuggestBox'])[2]";
	public String Modifier7= "xpath=(//input[@id='modifier3SuggestBoxsuggestBox'])[2]";
	public String Modifier8= "xpath=(//input[@id='modifier4SuggestBoxsuggestBox'])[2]";
	
	public String Modifier9= "xpath=(//input[@id='modifier1SuggestBoxsuggestBox'])[3]";
	public String Modifier10="xpath=(//input[@id='modifier2SuggestBoxsuggestBox'])[3]";
	public String Modifier11= "xpath=(//input[@id='modifier3SuggestBoxsuggestBox'])[3]";
	public String Modifier12= "xpath=(//input[@id='modifier4SuggestBoxsuggestBox'])[3]";
	
	public String Modifier13= "xpath=(//input[@id='modifier1SuggestBoxsuggestBox'])[4]";
	public String Modifier14= "xpath=(//input[@id='modifier2SuggestBoxsuggestBox'])[4]";
	public String Modifier15= "xpath=(//input[@id='modifier3SuggestBoxsuggestBox'])[4]";
	public String Modifier16= "xpath=(//input[@id='modifier4SuggestBoxsuggestBox'])[4]";
	
	public String Modifier17= "xpath=(//input[@id='modifier1SuggestBoxsuggestBox'])[5]";
	public String Modifier18= "xpath=(//input[@id='modifier2SuggestBoxsuggestBox'])[5]";
	public String Modifier19= "xpath=(//input[@id='modifier3SuggestBoxsuggestBox'])[5]";
	public String Modifier20= "xpath=(//input[@id='modifier4SuggestBoxsuggestBox'])[5]";
	
	public String Modifier21= "xpath=(//input[@id='modifier1SuggestBoxsuggestBox'])[6]";
	public String Modifier22= "xpath=(//input[@id='modifier2SuggestBoxsuggestBox'])[6]";
	public String Modifier23= "xpath=(//input[@id='modifier3SuggestBoxsuggestBox'])[6]";
	public String Modifier24= "xpath=(//input[@id='modifier4SuggestBoxsuggestBox'])[6]";
	
	public String Modifier25= "xpath=(//input[@id='modifier1SuggestBoxsuggestBox'])[7]";
	public String Modifier26= "xpath=(//input[@id='modifier2SuggestBoxsuggestBox'])[7]";
	public String Modifier27= "xpath=(//input[@id='modifier3SuggestBoxsuggestBox'])[7]";
	public String Modifier28= "xpath=(//input[@id='modifier4SuggestBoxsuggestBox'])[7]";
	
	public String Modifier29= "xpath=(//input[@id='modifier1SuggestBoxsuggestBox'])[8]";
	public String Modifier30= "xpath=(//input[@id='modifier2SuggestBoxsuggestBox'])[8]";
	public String Modifier31= "xpath=(//input[@id='modifier3SuggestBoxsuggestBox'])[8]";
	public String Modifier32= "xpath=(//input[@id='modifier4SuggestBoxsuggestBox'])[8]";
	
	public String Modifier33= "xpath=(//input[@id='modifier1SuggestBoxsuggestBox'])[9]";
	public String Modifier34= "xpath=(//input[@id='modifier2SuggestBoxsuggestBox'])[9]";
	public String Modifier35= "xpath=(//input[@id='modifier3SuggestBoxsuggestBox'])[9]";
	public String Modifier36= "xpath=(//input[@id='modifier4SuggestBoxsuggestBox'])[9]";
	
	public String Modifier37= "xpath=(//input[@id='modifier1SuggestBoxsuggestBox'])[10]";
	public String Modifier38= "xpath=(//input[@id='modifier2SuggestBoxsuggestBox'])[10]";
	public String Modifier39= "xpath=(//input[@id='modifier3SuggestBoxsuggestBox'])[10]";
	public String Modifier40= "xpath=(//input[@id='modifier4SuggestBoxsuggestBox'])[10]";
	
	public String btnModifier1 = "addNewModifierButton";
	public String btnModifier2 = "xpath=(//a[@id='addNewModifierButton'])[2]";
	public String btnModifier3 = "xpath=(//a[@id='addNewModifierButton'])[3]";
	public String btnModifier4 = "xpath=(//a[@id='addNewModifierButton'])[4]";
	public String btnModifier5 = "xpath=(//a[@id='addNewModifierButton'])[5]";
	public String btnModifier6 = "xpath=(//a[@id='addNewModifierButton'])[6]";
	public String btnModifier7 = "xpath=(//a[@id='addNewModifierButton'])[7]";
	public String btnModifier8 = "xpath=(//a[@id='addNewModifierButton'])[8]";
	public String btnModifier9 = "xpath=(//a[@id='addNewModifierButton'])[9]";
	public String btnModifier10 ="xpath=(//a[@id='addNewModifierButton'])[10]";
	public String btnPostAndHold = "postAndHoldClaim";
	
	public String txtUnit6 = "xpath=(//input[@id='units'])[6]";
	public String txtUnit7 = "xpath=(//input[@id='units'])[7]";
	public String txtUnit8 = "xpath=(//input[@id='units'])[8]";
	public String txtUnit9 = "xpath=(//input[@id='units'])[9]";
	public String txtUnit10 = "xpath=(//input[@id='units'])[10]";
	public String txtBalanceAtleast = "xpath=(//input[@id='balanceAtLeast'])[2]";
	
	public String lblChargeAmount1 = "//div[@id='chargeAmountPanel']/div/input";
	public String lblChargeAmount6= "xpath=(//div[@id='chargeAmountPanel']/div)[6]/input";
	public String lblChargeAmount7= "xpath=(//div[@id='chargeAmountPanel']/div)[7]/input";
	public String lblChargeAmount8= "xpath=(//div[@id='chargeAmountPanel']/div)[8]/input";
	public String lblChargeAmount9= "xpath=(//div[@id='chargeAmountPanel']/div)[9]/input";
	public String lblChargeAmount10= "xpath=(//div[@id='chargeAmountPanel']/div)[10]/input";
	
	public String lnkChargeEntryShowDetails = "detailsAnchor";
	public String lnkEditclaim ="editClaim";
	public String lnkReSubmitClaim = "resubmitClaim";
	
	public String ajxGroupCode = "claimAdjustmentGroupsSBsuggestBox";
	public String ajxReasonCode = "claimAdjustmentReasonCodesSB";
	public String lnkCreateTask="//a[@id='createATask']";
	public String lnkPostAndHoldClaim="//a[@id='postAndHoldClaim']";
	//a[@id='postAndHoldClaim']/span
	
	
	public String btnCircleMetaInfo="css=a.wizard-step-circle.current-wizard-step-circle";

	public String btnCircleFormat="xpath=(//a[@class='wizard-step-circle'])[1]";
	public String btnCircleStatementCycle="xpath=(//a[@class='wizard-step-circle'])[2]";
	public String btnCircleDunningMessages="xpath=(//a[@class='wizard-step-circle'])[3]";

	public String rdoAllCharges="xpath=(//input[@name='allOrNewPatientCharges'])[1]";
	public String rdoNewPatientCharges="xpath=(//input[@name='allOrNewPatientCharges'])[1]";

	public String ajxAdminCode = "suggestBox";

	public String chkPending ="pendingInsuranceChargescheckbox";
	public String chkZero ="zeroBalanceChargescheckbox";
	    	
	public String chkPayment ="paymentscheckbox";
	public String chkAdjustmentBox ="adjustmentscheckbox";
	public String chkServiceCodeBox="serviceCodecheckbox";
	public String chkServiceCodeDesc ="serviceCodeDescriptioncheckbox";
	    	
	public String chkMaster ="mastercardcheckbox";
	public String chkDiscover ="discovercheckbox";
	public String chkVisa="visacheckbox";
	public String chkAmerExpress ="americanExpresscheckbox";
	public String btnPreview ="css=button.primary-button.left-button-spacer";
	
	
	public String btnAddStmtCycleInfo = "class=add-button";
    public String ajxPatientSelection ="patientSelectionTypesuggestBox";
    public String txtFromName ="fromName";
    public String txtToName ="toName";
    
    public String rdoMonthly ="monthlyradio";
    public String rdoWeekly ="weeklyradio";
    public String rdoDaily ="dailyradio";
    
    public String chkMonday ="mondaycheckbox";
    public String chkTuesday ="tuesdaycheckbox";
    public String chkWednesday ="wednesaycheckbox";
    public String chkThursday ="thursdaycheckbox";
    public String chkFriday ="fridaycheckbox";
    public String chkSaturday ="saturdaycheckbox";
    public String chkSunday ="sundaycheckbox";
    
    public String rdoDayOfMonth ="dayOfMonthradio";
    public String rdoWeekOfMonth ="weekOfMonthradio";
    
    public String txtInterval ="interval";
    public String ajxDateOfMonth ="dateOfMonthSuggestBoxsuggestBox";
    public String ajxRecurring ="recurringMonthlyQualifierSuggestBoxsuggestBox";
    public String ajxDaySelection ="daySelectionSuggestBoxsuggestBox";
    
    public String ajxBadDept ="badDebtStatusLevelBoxsuggestBox";
    public String ajxCollection ="collectionsLevelBoxsuggestBox";
    
    public String txtDunningMsg ="//textarea[@class='text-area']";
    
    public String txtDunningMsg1 ="xpath=(//textarea[@class='text-area'])[1]";
    public String txtDunningMsg2 ="xpath=(//textarea[@class='text-area'])[2]";
    public String txtDunningMsg3 ="xpath=(//textarea[@class='text-area'])[3]";
    public String txtDunningMsg4 ="xpath=(//textarea[@class='text-area'])[4]";
    public String txtDunningMsg5 ="xpath=(//textarea[@class='text-area'])[5]";
    
    public String dunningMsg1 ="This balance is your responsibility. If you have insurance, please complete the back of this statement. If you have a financial problem, contact our office immediately at the number on this statement.";
    public String dunningMsg2 ="We have not received your payment. Account Balances are due within 30 days of the original statement date. Please send your payment now or call our office at the number on this statement.";
    public String dunningMsg3 ="No payment has been received. Your account is now past due. If you have a financial problem, please contact our billing office at the number on this statement. Otherwise, please remit payment immediately.";
    public String dunningMsg4 ="We have not had a response regarding your account balance. If we do not receive a payment in 30 days, collection proceedings will begin.";
    public String dunningMsg5 ="***FINAL NOTICE*** If a payment is not received in our office within 15 days of the date on this statement, we will forward all outstanding balances to our collection agency for collection action.";


	/**
	 * goToPatientChart function go To goToPatientChart
	 * 
	 * @throws IOException
	 * @since Jan 29, 2014
	 */
	public boolean goToPatientChart(Selenium selenium) throws IOException {
		assertTrue(click(selenium, "link=Patient Options"),
				"Could not click Patient Option", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, "patientOptionsChartView"),
				"Could not View Patient chart link", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium, btnEncounter),
				"Encounter button is not present", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);
		return true;
	}

	/**
	 * goToAdjustmentReasons function go To AdjustmentReasons
	 * 
	 * @since Jan 03, 2014
	 */
	public boolean goToAdjustmentReasons(Selenium selenium) {
		try {

			assertTrue(click(selenium, lnkSettings),
					"Could not click Quick Action", selenium, ClassName,
					MethodName);

			assertTrue(click(selenium, lnkBillingSettings),
					"Could not click Billing Settings", selenium, ClassName,
					MethodName);

			waitForPageLoad(selenium);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, lnkAdjustmentCodes),
					"Could not click Adjustment Reasons", selenium, ClassName,
					MethodName);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * verifyAdjustmentReasonsView function verifies Adjustment Reason view
	 * 
	 * @since Jan 07, 2014
	 */
	public void verifyAdjustmentReasonsView(Selenium selenium) {
		try {
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium, lblAdjustmentCodes),
					"Adjustment Reason label not present", selenium, ClassName,
					MethodName);
			assertTrue(isElementPresent(selenium, ajxSearchAdjustmentReason),
					"Search Box not present", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium, chkInactiveAdjustmentReason),
					"Include Inactives Check Box not present", selenium,
					ClassName, MethodName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * deleteAllAdjustmentCodes function To delete all AdjustmentReasons
	 * @throws IOException 
	 * 
	 * @since Jan 03, 2014
	 */

	public boolean deleteAllAdjustmentCodes(Selenium selenium) throws IOException {
		waitForPageLoad(selenium);
		boolean adjustmentsDeleted = true;
		type(selenium, txtSearchAdjustmentReason,"AR");
		selenium.keyPress(txtSearchAdjustmentReason, "\\13");
		waitForPageLoad(selenium);		
		adjustmentsDeleted=deleteAllAdjustmentCodesExceptPort(selenium);
		type(selenium, txtSearchAdjustmentReason,"RA");
		selenium.keyPress(txtSearchAdjustmentReason, "\\13");
		waitForPageLoad(selenium);	
		adjustmentsDeleted=deleteAllAdjustmentCodesExceptPort(selenium);
		return adjustmentsDeleted;
		
		
	}


	/**
	 * verifyEditDeleteAdjustmentReasonsSummary function verifies Adjustment
	 * Reasons Summary
	 * 
	 * @since Jan 22, 2014
	 */

	public boolean verifyEditDeleteAdjustmentReasonsSummary(Selenium selenium,
			BillingLib adjustmentCodeData) {

		waitForPageLoad(selenium);
		try {
			assertTrue(isElementPresent(selenium, btnDelete),
					"Delete Button not present in summary", selenium,
					ClassName, MethodName);
			assertTrue(isElementPresent(selenium, btnEdit),
					"Delete Button not present in summary", selenium,
					ClassName, MethodName);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * goToFeeSchedule function go To Fee Schedule
	 * 
	 * @since Jan 05, 2014
	 */
	public boolean goToFeeSchedule(Selenium selenium) {
		boolean returnValue = true;
		try {
			assertTrue(click(selenium, lnkSettings), "Navigation Failed",
					selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkBillingSettings),
					"could not click Billing Settings", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkFeeSchedule),
					"Could not click on fee schedule link:", selenium,
					ClassName, MethodName);

			if (getText(selenium, lblFeeSchedule).contains("Fee Schedules")
					&& isElementPresent(selenium, ajxSearch)) {
				return returnValue;
			}
			return returnValue;
		} catch (Exception e) {
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}

	/*
	 * deleteAllFeeSchedule function delete all Fee Schedules
	 * 
	 * @since Jan 08, 2014
	 */
	public boolean deleteAllFeeSchedule(Selenium selenium) {
		boolean returnValue = true;
		try {
			waitForPageLoad(selenium);
			boolean adjustmentsDeleted = true;
			int count;
			while ((Integer) selenium.getXpathCount(lnkDelete) > 0) {
				count = (Integer) selenium.getXpathCount(lnkDelete);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkDelete),
						"could not click delete button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnYes), "could not click yest button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				int counter = (Integer) selenium.getXpathCount(lnkDelete);
				waitForPageLoad(selenium);
				if (count == counter) {
					adjustmentsDeleted = false;
					break;
				}
			}
			return adjustmentsDeleted;
		} catch (Exception e) {
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}

	/**
     * addFeeSchedule function add Fee Schedule
     * 
     * @since Jan 05, 2014
     */
	 public boolean addFeeSchedule(Selenium selenium, BillingLib billingData, String account) {
			boolean returnValue = true;
			try {
			    click(selenium, btnAddNewFeeSchedule);
			    waitForPageLoad(selenium);
			    
			    assertTrue(selectValueFromAjaxList(selenium, ajxPayer, billingData.payer1), "could not select payer", selenium, ClassName, MethodName);
			    assertTrue(selectValueFromAjaxList(selenium, ajxPlan, billingData.plan), "could not select plan", selenium, ClassName, MethodName);
			    assertTrue(selectValueFromAjaxList(selenium, ajxPractice, billingData.practice), "could not select practice", selenium, ClassName, MethodName);
			    assertTrue(selectValueFromAjaxList(selenium, ajxLocation, billingData.location), "could not select location", selenium, ClassName, MethodName);
			    assertTrue(selectValueFromAjaxList(selenium, ajxSpeciality, billingData.speciality), "could not select speciality", selenium, ClassName, MethodName);
			    assertTrue(selectValueFromAjaxList(selenium, ajxProvider, billingData.provider), "could not select provider", selenium, ClassName, MethodName);
			    assertTrue(selectValueFromAjaxList(selenium, ajxModifier, billingData.modifier), "could not select modifier", selenium, ClassName, MethodName);

			    if(!billingData.testCaseId.equals("TC_FS_002")){
				   if(account.equals(CAAccount)){
					   assertTrue(selectValueFromAjaxList(selenium, ajxSearch, billingData.serviceCodeCA), "could not search searchServiceCode", selenium, ClassName,MethodName);
				   }else
					   assertTrue(selectValueFromAjaxList(selenium, ajxSearch, billingData.searchServiceCode), "could not search searchServiceCode", selenium, ClassName,MethodName);
			    }
			    if(billingData.testCaseId.equals("TC_FS_007")){
				
				float ibalanceNumber1=Float.parseFloat(getText(selenium, lblChargeAmount).trim())+10;
				String ibalanceNumber=String.valueOf(ibalanceNumber1);
				assertTrue(type(selenium, txtAllowedAmount,ibalanceNumber), "could not enter allowedAmount", selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnSaveFeeSchedule), "could not click on save button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
					if(getText(selenium,lblAllowedAmountAlert).startsWith("Allowed Amount must be at most")){
					    return true;
					}
					else{
					    Assert.fail("User is able to enter the allowed amount more than charge amount");
					}
				
			    }
			    
			    if(billingData.testCaseId.equals("TC_FS_008")){
				String ibalanceNumber=getText(selenium, lblChargeAmount);
				assertTrue(type(selenium, txtAllowedAmount,ibalanceNumber), "could not enter allowedAmount", selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnSaveFeeSchedule), "could not click on save button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
					if(getText(selenium,lblDateAlert).startsWith("Please provide the effective date")){
					    return true;
					}
					else{
					    Assert.fail("User is allowed to save without entering date");
						}
				
			    }    
			    
			    if(billingData.testCaseId.equals("TC_FS_011")){
				assertTrue(click(selenium, btnSaveFeeSchedule), "could not click on save button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(isElementPresent(selenium, btnSaveFeeSchedule), "User is allowed to save without entering date", selenium, ClassName, MethodName);
			   }
			    if (!billingData.testCaseId.equals("TC_FS_002")) {
				    assertTrue(type(selenium, txtAllowedAmount, billingData.allowedAmount), "could not enter allowedAmount", selenium, ClassName, MethodName);
				    assertTrue(enterDate(selenium, txtEffectiveDate, billingData.effectiveDate), "could not enter effectiveDate", selenium, ClassName, MethodName);
				    assertTrue(type(selenium, txtBaseUnits, billingData.baseUnits), "could not enter baseUnits", selenium, ClassName, MethodName);
				    assertTrue(type(selenium, txtAllowedUnits, billingData.allowedUnit), "could not enter allowedUnit", selenium, ClassName, MethodName);
			    }
			    if (billingData.testCaseId.equals("TC_FS_002")) {
			    	 if(account.equals(CAAccount)){
						   //assertTrue(selectValueFromAjaxList(selenium, ajxSearch, billingData.serviceCodeCA), "could not search searchServiceCode", selenium, ClassName,MethodName);
						   assertTrue(type(selenium, txtCodeRangeFrom, "25605"), "could not enter codeRangeFrom", selenium, ClassName, MethodName);
							assertTrue(type(selenium, txtCodeRangeTo, "25609"), "could not enter codeRangeTo", selenium, ClassName, MethodName);
					   }else{
						  // assertTrue(selectValueFromAjaxList(selenium, ajxSearch, billingData.searchServiceCode), "could not search searchServiceCode", selenium, ClassName,MethodName);
						   assertTrue(type(selenium, txtCodeRangeFrom, billingData.codeRangeFrom), "could not enter codeRangeFrom", selenium, ClassName, MethodName);
						   waitForPageLoad(selenium);
						   waitForPageLoad(selenium);
						   assertTrue(type(selenium, txtCodeRangeTo, billingData.codeRangeFrom), "could not enter codeRangeTo", selenium, ClassName, MethodName);
					   }
			    	 waitForPageLoad(selenium);
			    	 selenium.keyPress(txtCodeRangeTo, "\\13");
			    	 waitForPageLoad(selenium);
				assertTrue(type(selenium, txtAllowedAmount1, billingData.allowedAmount1), "could not enter allowedAmount1", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium, txtEffectiveDate1, billingData.effectiveDate1), "could not enter effectiveDate1", selenium, ClassName,
					MethodName);
				assertTrue(type(selenium, txtBaseUnits1, billingData.baseUnits1), "could not enter baseUnits1", selenium, ClassName, MethodName);
				assertTrue(type(selenium, txtAllowedUnits1, billingData.allowedUnit1), "could not enter allowedUnit1", selenium, ClassName, MethodName);

					/*if (!isElementPresent(selenium, serviceCodeSearchResult3)) {
					    Assert.fail("Search Filter Failed");
					}*/
			    }

			    if (billingData.testCaseId.equals("TC_FS_003")) {
				assertTrue(click(selenium, btnCancelFeeSchedule), "could not click on Cancel button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				if (!isElementPresent(selenium, btnAddNewFeeSchedule)) {
				    returnValue = false;
				}

				return true;
			    }
			    assertTrue(click(selenium, btnSaveFeeSchedule), "could not click on save button", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);

			    if (!isElementPresent(selenium, btnAddNewFeeSchedule)) {
			    	returnValue = false;
			    }

			    return returnValue;
			} catch (Exception e) {
			    e.printStackTrace();
			    returnValue = false;
			}
		return returnValue;
	 }




	/**
	 * copyFeeSchedule function add Fee Schedule
	 * 
	 * @since Jan 09, 2014
	 */
	public boolean copyFeeSchedule(Selenium selenium, BillingLib billingData) {
		boolean returnValue = true;
		try {
			assertTrue(click(selenium, btnAddNewFeeSchedule),
					"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(
					selectValueFromAjaxList(selenium, ajxPayer,
							billingData.payer1), "could not select payer",
					selenium, ClassName, MethodName);
			assertTrue(
					selectValueFromAjaxList(selenium, ajxPlan, billingData.plan),
					"could not select plan", selenium, ClassName, MethodName);
			assertTrue(
					selectValueFromAjaxList(selenium, ajxPractice,
							billingData.practice), "could not select practice",
					selenium, ClassName, MethodName);
			assertTrue(
					selectValueFromAjaxList(selenium, ajxLocation,
							billingData.location), "could not select location",
					selenium, ClassName, MethodName);
			assertTrue(
					selectValueFromAjaxList(selenium, ajxSpeciality,
							billingData.speciality),
					"could not select speciality", selenium, ClassName,
					MethodName);
			assertTrue(
					selectValueFromAjaxList(selenium, ajxProvider,
							billingData.provider), "could not select provider",
					selenium, ClassName, MethodName);
			assertTrue(
					selectValueFromAjaxList(selenium, ajxModifier,
							billingData.modifier), "could not select modifier",
 					selenium, ClassName, MethodName);

			assertTrue(
					selectValueFromAjaxList(selenium, ajxCopyPayer,
							billingData.payer1),
					"could not select existingPayer", selenium, ClassName,
					MethodName);
			assertTrue(
					selectValueFromAjaxList(selenium, ajxCopyProvider,
							billingData.plan), "could not select practice",
					selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtIncreaseAmount, billingData.allowedUnit),
					"could not enter IncreaseAmount", selenium, ClassName,
					MethodName);
			assertTrue(
					selectValueFromAjaxList(selenium, ajxAmountType,
							billingData.allowedType), "could not AmountType",
					selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtCopyEffectiveDate,
							billingData.effectiveDate),
					"could not enter Effective Date", selenium, ClassName,
					MethodName);

			assertTrue(click(selenium, btnCopy),
					"could not click on copy button", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);

			return returnValue;
		} catch (Exception e) {
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}


	/**
	 * unitTestaddFeeSchedule function add Fee Schedule
	 * 
	 * @since Jan 06, 2014
	 */
	public boolean unitTestaddFeeSchedule(Selenium selenium,
			BillingUnitTestLib billingData) {
		boolean returnValue = true;
		try {
			assertTrue(click(selenium, btnAddNewFeeSchedule),
					"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(
					selectValueFromAjaxList(selenium, ajxPayer,
							billingData.payer), "could not select payer",
					selenium, ClassName, MethodName);

			if (billingData.testCaseId.equals("TC_UFS_001")
					|| billingData.testCaseId.equals("TC_UFS_002")
					|| billingData.testCaseId.equals("TC_UFS_008")) {
				assertTrue(click(selenium, btnSaveFeeSchedule),
						"could not click on save button", selenium, ClassName,
						MethodName);
				waitForPageLoad(selenium);

				return true;
			}

			if (billingData.testCaseId.equals("TC_UFS_009")
					|| billingData.testCaseId.equals("TC_UFS_010")
					|| billingData.testCaseId.equals("TC_UFS_011")
					|| billingData.testCaseId.equals("TC_UFS_012")
					|| billingData.testCaseId.equals("TC_UFS_013")
					|| billingData.testCaseId.equals("TC_UFS_014")
					|| billingData.testCaseId.equals("TC_UFS_015")
					|| billingData.testCaseId.equals("TC_UFS_016")
					|| billingData.testCaseId.equals("TC_UFS_017")
					|| billingData.testCaseId.equals("TC_UFS_018")
					|| billingData.testCaseId.equals("TC_UFS_019")) {

				assertTrue(
						selectValueFromAjaxList(selenium, ajxCopyPayer,
								billingData.existingPayer),
						"could not select existingPayer", selenium, ClassName,
						MethodName);
				assertTrue(
						selectValueFromAjaxList(selenium, ajxCopyProvider,
								billingData.practice),
						"could not select practice", selenium, ClassName,
						MethodName);
				assertTrue(
						type(selenium, txtIncreaseAmount,
								billingData.allowedUnit),
						"could not enter IncreaseAmount", selenium, ClassName,
						MethodName);
				assertTrue(
						selectValueFromAjaxList(selenium, ajxAmountType,
								billingData.amountType),
						"could not AmountType", selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtCopyEffectiveDate,
								billingData.effectiveDate),
						"could not enter Effective Date", selenium, ClassName,
						MethodName);

				assertTrue(click(selenium, btnCopy),
						"could not click on copy button", selenium, ClassName,
						MethodName);
				waitForPageLoad(selenium);

				return true;

			}

			else {
				assertTrue(
						selectValueFromAjaxList(selenium, ajxPlan,
								billingData.plan), "could not select plan",
						selenium, ClassName, MethodName);
				assertTrue(
						selectValueFromAjaxList(selenium, ajxPractice,
								billingData.practice),
						"could not select practice", selenium, ClassName,
						MethodName);
				assertTrue(
						selectValueFromAjaxList(selenium, ajxLocation,
								billingData.location),
						"could not select location", selenium, ClassName,
						MethodName);
				assertTrue(
						selectValueFromAjaxList(selenium, ajxSpeciality,
								billingData.speciality),
						"could not select speciality", selenium, ClassName,
						MethodName);
				assertTrue(
						selectValueFromAjaxList(selenium, ajxProvider,
								billingData.provider),
						"could not select provider", selenium, ClassName,
						MethodName);
				assertTrue(
						selectValueFromAjaxList(selenium, ajxModifier,
								billingData.modifier),
						"could not select modifier", selenium, ClassName,
						MethodName);

				assertTrue(
						selectValueFromAjaxList(selenium, ajxSearch,
								billingData.searchServiceCode),
						"could not search searchServiceCode", selenium,
						ClassName, MethodName);

				assertTrue(
						enterDate(selenium, txtAllowedAmount,
								billingData.allowedAmount),
						"could not enter allowedAmount", selenium, ClassName,
						MethodName);
				assertTrue(
						type(selenium, txtEffectiveDate,
								billingData.effectiveDate),
						"could not enter effectiveDate", selenium, ClassName,
						MethodName);
				assertTrue(type(selenium, txtBaseUnits, billingData.baseUnits),
						"could not enter baseUnits", selenium, ClassName,
						MethodName);
				assertTrue(
						type(selenium, txtAllowedUnits, billingData.allowedUnit),
						"could not enter allowedUnit", selenium, ClassName,
						MethodName);

				assertTrue(click(selenium, btnSaveFeeSchedule),
						"could not click on save button", selenium, ClassName,
						MethodName);
				waitForPageLoad(selenium);

				if (!isElementPresent(selenium, btnAddNewFeeSchedule)) {
					returnValue = false;
				}

			}
			return returnValue;
		} catch (Exception e) {
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}

	/**
	 * unitTestAddAdjustmentReasons function add Fee Schedule
	 * 
	 * @since Jan 08, 2014
	 */
	public boolean unitTestAddAdjustmentReasons(Selenium selenium,
			BillingUnitTestLib billingData) {
		boolean returnValue = true;
		try {
			waitForPageLoad(selenium);

			if (billingData.testCaseId.equals("TC_UAC_001")
					|| billingData.testCaseId.equals("TC_UAC_002")) {
				if (isElementPresent(selenium, txtadjustmentReason)) {
					assertTrue(
							type(selenium, txtadjustmentReason,
									billingData.adjusmentReason),
							"Could not type Adjustment Reason", selenium,
							ClassName, MethodName);
				}

				if (isElementPresent(selenium, txtdescription)) {
					assertTrue(
							type(selenium, txtdescription,
									billingData.description),
							"Could not type Description", selenium, ClassName,
							MethodName);
				}

				if (isElementPresent(selenium, ajxc_DAdjusment)) {
					assertTrue(
							selectValueFromAjaxList(selenium, ajxc_DAdjusment,
									billingData.c_DAdjusment),
							"Could not select credit or debit adjustment",
							selenium, ClassName, MethodName);
				}

				if (isElementPresent(selenium, ajxReportCategory)) {
					assertTrue(
							selectValueFromAjaxList(selenium,
									ajxReportCategory,
									billingData.reportCategory),
							"Could not select Report category for adjustment",
							selenium, ClassName, MethodName);
				}
				if (isElementPresent(selenium, btnSave)) {
					assertTrue(click(selenium, btnSave),
							"Could not click Save button", selenium, ClassName,
							MethodName);
				}

				return true;
			}
			if (billingData.testCaseId.equals("TC_UAC_003")) {
				if (isElementPresent(selenium, txtadjustmentReason)) {
					assertTrue(
							type(selenium, txtadjustmentReason,
									billingData.adjusmentReason),
							"Could not type Adjustment Reason", selenium,
							ClassName, MethodName);
				}
				selenium.typeKeys(txtadjustmentReason, "k");
				return true;
			}

			if (billingData.testCaseId.equals("TC_UAC_004")) {
				if (isElementPresent(selenium, txtadjustmentReason)) {
					assertTrue(
							type(selenium, txtdescription,
									billingData.description),
							"Could not type Adjustment Reason", selenium,
							ClassName, MethodName);
				}
				selenium.typeKeys(txtdescription, "k");
				return true;
			}

			waitForPageLoad(selenium);

			return returnValue;
		} catch (Exception e) {
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}

	/**
	 * verifyAdjustmentReasonsSummary function verifies Adjustment Reasons
	 * Summary
	 * 
	 * @since Jan 06, 2014
	 */
	public boolean verifyAdjustmentReasonsSummary(Selenium selenium,
			BillingLib adjustmentCodeData) {
		String provider = getText(selenium, lnkTopMenu);
		String onBehalfOf = provider.replaceAll(", "
				+ adjustmentCodeData.switchRole, "");

		waitForPageLoad(selenium);
		try {
			if (!getText(selenium, summaryAdjustmentReasons).trim().contains(
					adjustmentCodeData.adjusmentReason.trim())) {
				return false;
			}
			if (!getText(selenium, summaryAdjustmentReasons).trim().contains(
					adjustmentCodeData.description.trim())) {
				return false;
			}
			if (!getText(selenium, summaryAdjustmentReasons).trim().contains(
					adjustmentCodeData.c_DAdjusment.trim())) {
				return false;
			}
			if (!getText(selenium, summaryAdjustmentReasons).trim().contains(
					adjustmentCodeData.reportCategory.trim())) {
				return false;
			}
			if (!getText(selenium, summaryAdjustmentReasons).trim()
						.contains(onBehalfOf)) {
					return false;
				}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * verifyAdjustmentReasonsSummary function verifies Adjustment Reasons
	 * Summary
	 * @throws IOException 
	 * 
	 * @since Jan 06, 2014
	 */
	
  public boolean verifyAdjustmentReasonsEditPage(Selenium selenium,BillingLib adjustmentCodeData) throws IOException {
		
		try {
			
			assertTrue(selenium.isTextPresent(adjustmentCodeData.adjusmentReason), "" + "Adjustment Reason Not Present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
					
			assertTrue(selenium.isTextPresent(adjustmentCodeData.description), "" + "Adjustment Description Not Present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(selenium.isTextPresent(adjustmentCodeData.c_DAdjusment), "" + "Adjustment c_DAdjusment Not Present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
								
			assertTrue(selenium.isTextPresent(adjustmentCodeData.reportCategory), "" + "adjustment reportCategory Not Present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEdit ),"Could not Edit button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.getValue(txtadjustmentReason).trim().contains(adjustmentCodeData.adjusmentReason.trim()), "adjustment Reason Not Present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.getValue(txtdescription).trim().contains(adjustmentCodeData.description.trim()), "adjustment description Not Present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			assertTrue(selenium.getValue(ajxc_DAdjusment).trim().contains(adjustmentCodeData.c_DAdjusment.trim()), "Dadjustment Not Present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.getValue(ajxReportCategory).trim().contains(adjustmentCodeData.reportCategory.trim()), "adjustment Report Category Not Present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	
	/**
	 * addAdjustmentReasons function adds a new Adjustment Reasons
	 * 
	 * @since Jan 06, 2014
	 */

  public boolean addAdjustmentReasons(Selenium selenium,
			
			BillingLib adjustmentCodeData) throws IOException {
		waitForPageLoad(selenium);
		String date = null;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("MMddHHmm");
		date = DateFormat.format(cal.getTime());
		
		if(!((adjustmentCodeData.testCaseId.equals("TC_AC_020"))||(adjustmentCodeData.testCaseId.equals("TC_AC_021")))){
			adjustmentCodeData.adjusmentReason = adjustmentCodeData.adjusmentReason
					+ date;

		}
		
		if (isElementPresent(selenium, txtadjustmentReason)) {
			assertTrue(
					type(selenium, txtadjustmentReason,
							adjustmentCodeData.adjusmentReason),
					"Could not type Adjustment Reason", selenium, ClassName,
					MethodName);
		}

		waitForPageLoad(selenium);
		if (isElementPresent(selenium, txtdescription)) {
			assertTrue(
					type(selenium, txtdescription,
							adjustmentCodeData.description),
					"Could not type Description", selenium, ClassName,
					MethodName);
		}

		waitForPageLoad(selenium);

		if (isElementPresent(selenium, ajxc_DAdjusment)) {
			assertTrue(
					selectValueFromAjaxList(selenium, ajxc_DAdjusment,
							adjustmentCodeData.c_DAdjusment),
					"Could not select credit or debit adjustment", selenium,
					ClassName, MethodName);
		}

		if (isElementPresent(selenium, ajxReportCategory)) {
			assertTrue(
					selectValueFromAjaxList(selenium, ajxReportCategory,
							adjustmentCodeData.reportCategory),
					"Could not select Report category for adjustment",
					selenium, ClassName, MethodName);
		}
		
		if (adjustmentCodeData.testCaseId.equals("TC_AC_003")||adjustmentCodeData.testCaseId.equals("TC_AC_010")||adjustmentCodeData.testCaseId.equals("TC_AC_009")||adjustmentCodeData.testCaseId.equals("TC_AC_011")||adjustmentCodeData.testCaseId.equals("TC_AC_014")||adjustmentCodeData.testCaseId.equals("TC_AC_015") || adjustmentCodeData.testCaseId.equals("TC_AC_016") ||adjustmentCodeData.testCaseId.equals("TC_AC_017")
				||adjustmentCodeData.testCaseId.equals("TC_AC_018")||adjustmentCodeData.testCaseId.equals("TC_AC_019") ||adjustmentCodeData.testCaseId.equals("TC_AC_020") ||adjustmentCodeData.testCaseId.equals("TC_AC_021") ) {
			if (isElementPresent(selenium, btnSave)) {
				assertTrue(click(selenium, btnSave),
						"Could not click Cancel button", selenium, ClassName,
						MethodName);
			}
		}
		waitForPageLoad(selenium);

		return true;
	}


	/**
	 * verifySaveAndAnotherAjustment function verifies save and and Adjustment
	 * Reasons
	 * 
	 * @since Jan 10, 2014
	 */

	public boolean verifySaveAndAnotherAjustment(Selenium selenium,
			BillingLib adjustmentCodeData) throws IOException {

		assertTrue(isElementPresent(selenium, txtadjustmentReason),
				"Adjustment Reason textbox not Present", selenium, ClassName,
				MethodName);

		waitForPageLoad(selenium);

		assertTrue(isElementPresent(selenium, txtdescription),
				"Description textbox not Present", selenium, ClassName,
				MethodName);

		waitForPageLoad(selenium);

		assertTrue(isElementPresent(selenium, ajxc_DAdjusment),
				"credit or debit adjustment listbox not Present", selenium,
				ClassName, MethodName);

		assertTrue(isElementPresent(selenium, ajxReportCategory),
				"Report category listbox not Present", selenium, ClassName,
				MethodName);
		return true;
	}

	/**
	 * searchAdjustmentReasons function searches Adjustment Reasons
	 * 
	 * @since Jan 10, 2014
	 */

	public boolean searchAdjustmentReasons(Selenium selenium,
			BillingLib adjustmentCodeData) throws IOException {
		type(selenium, txtSearchAdjustmentReason,
				adjustmentCodeData.adjusmentReason);
		selenium.keyPress(txtSearchAdjustmentReason, "\\13");
		waitForPageLoad(selenium);
		return true;
	}

	/**
	 * gotoBillerSettings function go To Biller Settings
	 * 
	 * @throws IOException
	 * @since Jan 07, 2014
	 */
	public boolean goToBillerSettings(Selenium selenium) throws IOException {

		assertTrue(click(selenium, lnkSettings), "Navigation Failed",
				selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkBillingSettings),
				"could not click Billing Settings", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		if (!isElementPresent(selenium, lnkSuperBillSetUp)) {
			Assert.fail("Biller Setting page is not getting displayed");
		}
		return true;
	}

	/**
	 * deleteSuperBillEntry function deleteSuperBillEntry
	 * 
	 * @throws IOException
	 * @since Jan 07, 2014
	 */
	public boolean deleteSuperBillEntry(Selenium selenium,
			BillingLib billInfoData) throws IOException {
		boolean deleteSuperBill = true;
		int billerCount;
		assertTrue(type(selenium, ajxSearch, billInfoData.templateName),
				"Could not type the template Name", selenium, ClassName,
				MethodName);
		selenium.keyPress(ajxSearch, "\\13");
		waitForPageLoad(selenium);
		int deleteBillerCount = (Integer) selenium
				.getXpathCount("//div[@id='SuperbillTemplateList']/table/tbody/tr/td[4]/div/a");
		for (billerCount = 0; billerCount < deleteBillerCount; billerCount++) {
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkDeleteSuperBill),
					"Could not click the delete button", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnYes),
					"Could not click the yes button", selenium, ClassName,
					MethodName);

		}
		return deleteSuperBill;
	}

	/**
	 * addSuperBillInfo function addSuperBillInfo
	 * 
	 * @throws IOException
	 * @since Jan 07, 2014
	 */
	public boolean addSuperBillInfo(Selenium selenium, BillingLib billInfoData,
			String uniqueName) throws IOException {
		assertTrue(
				type(selenium, txtTempletaName, billInfoData.templateName
						+ uniqueName), "Could not type the template Name",
				selenium, ClassName, MethodName);
		assertTrue(
				selectValueFromAjaxList(selenium, ajxSpecialty,
						billInfoData.specialty),
				"Could not select the specialty ", selenium, ClassName,
				MethodName);

		assertTrue(click(selenium, btnSBINext),
				"Could not click the next button", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);
		if (isElementPresent(selenium, txtTempletaName)) {
			Assert.fail("Could not move to Service code page");
		}
		return true;

	}

	/**
	 * unitTest_addSuperBillInfo function unitTest_addSuperBillInfo
	 * 
	 * @throws IOException
	 * @since Jan 21, 2014
	 */
	public boolean unitTest_addSuperBillInfo(Selenium selenium,
			BillingUnitTestLib billInfoData) throws IOException {
		
		assertTrue(type(selenium, txtTempletaName, billInfoData.templateName),
				"Could not type the template Name", selenium, ClassName,
				MethodName);
		assertTrue(
				selectValueFromAjaxList(selenium, ajxSpecialty,
						billInfoData.specialty),
				"Could not type the template Name", selenium, ClassName,
				MethodName);

		assertTrue(click(selenium, btnSBINext),
				"Could not click the next button", selenium, ClassName,
				MethodName);

		return true;

	}

	/**
	 * unitTest_serviceCode function unitTest_serviceCode
	 * 
	 * @throws IOException
	 * @since Jan 21, 2014
	 */
	public boolean unitTest_serviceCode(Selenium selenium,
			BillingUnitTestLib billInfoData) throws IOException {
		assertTrue(type(selenium, txtSectionLabel, billInfoData.sectionLabel),
				"Could not type the section label", selenium, ClassName,
				MethodName);
		assertTrue(
				selectValueFromAjaxList(selenium, ajxSCServiceCode,
						billInfoData.serviceCode),
				"Could not select service code", selenium, ClassName,
				MethodName);
		assertTrue(type(selenium, txtSCdescription, billInfoData.description),
				"Could not type the description ", selenium, ClassName,
				MethodName);
		assertTrue(
				selectValueFromAjaxList(selenium, ajxSCModifiers1,
						billInfoData.modifiers), "Could not select Modifiers",
				selenium, ClassName, MethodName);
		assertTrue(
				selectValueFromAjaxList(selenium, ajxSCModifiers2,
						billInfoData.modifiers1),
				"Could not select Modifiers1", selenium, ClassName, MethodName);

		assertTrue(click(selenium, btnSBINext),
				"Could not click the next button", selenium, ClassName,
				MethodName);

		return true;

	}

	/**
	 * addServiceCode function addServiceCode
	 * 
	 * @throws IOException
	 * @since Jan 07, 2014
	 */

	public boolean addServiceCode(Selenium selenium, BillingLib billInfoData, String account, String uniqueName)throws IOException {
		assertTrue(type(selenium, txtTempletaName, billInfoData.templateName+uniqueName), "Could not type the template Name",
				selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtSectionLabel, billInfoData.sectionLabel),"Could not type the section label", selenium, ClassName,MethodName);
		
		if(account.equals(CAAccount)){
			assertTrue(selectValueFromAjaxList(selenium, ajxSCServiceCode,billInfoData.serviceCodeCA),"Could not select service code", selenium, ClassName,MethodName);
	
		}else{
			assertTrue(selectValueFromAjaxList(selenium, ajxSCServiceCode,billInfoData.serviceCode),"Could not select service code", selenium, ClassName,MethodName);
		}
		waitForPageLoad(selenium);
		click(selenium, txtSCdescription);
		selenium.focus(txtSCdescription);
		System.out.println(getValue(selenium, txtSCdescription));
			String descriptionDetails = getValue(selenium, txtSCdescription);
		billInfoData.description = descriptionDetails;
		if(!account.equalsIgnoreCase(CAAccount)){
		assertTrue(
				selectValueFromAjaxList(selenium, ajxSCModifiers1,
						billInfoData.modifiers), "Could not select Modifiers",
				selenium, ClassName, MethodName);
		assertTrue(
				selectValueFromAjaxList(selenium, ajxSCModifiers2,
						billInfoData.modifiers1),
				"Could not select Modifiers1", selenium, ClassName, MethodName);
		}
		
		if (billInfoData.testCaseId.equals("TC_SBS_004")
				|| billInfoData.testCaseId.equals("TC_SBS_011")) {

			if (billInfoData.testCaseId.equals("TC_SBS_011")) {
				assertTrue(click(selenium, btnSCAddNew),
						"Could not click the Add New button", selenium,
						ClassName, MethodName);
				return true;
			}
			assertTrue(click(selenium, btnSCAddNew),
					"Could not click the Add New button", selenium, ClassName,
					MethodName);
			assertTrue(
					type(selenium, txtSectionLabel1, billInfoData.sectionlabel2),
					"Could not type the section label", selenium, ClassName,
					MethodName);
			assertTrue(
					selectValueFromAjaxList(selenium, ajxSCServiceCode2,
							billInfoData.serviceCode2),
					"Could not select service code", selenium, ClassName,
					MethodName);
			String descriptionDetail = getValue(selenium, txtSCdescription1);
			billInfoData.description1 = descriptionDetail;
			
			if(!account.equalsIgnoreCase(CAAccount)){
				assertTrue(
						selectValueFromAjaxList(selenium, ajxSCModifiers3,
								billInfoData.modifiers),
						"Could not select service code1", selenium, ClassName,
						MethodName);
				assertTrue(
						selectValueFromAjaxList(selenium, ajxSCModifiers4,
								billInfoData.modifiers1),
						"Could not select service code2", selenium, ClassName,
						MethodName);
			}
		}

		if (billInfoData.testCaseId.equals("TC_SBS_004")) {
			assertTrue(click(selenium, btnServicecodeMoreDelete),
					"Could not click the Delete button", selenium, ClassName,
					MethodName);
			return true;
		}

		if (billInfoData.testCaseId.equals("TC_SBS_005")) {
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSBINext),
					"Could not click the Back button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSBIBack),
					"Could not click the Back button", selenium, ClassName,
					MethodName);
			return true;
		}

		if (billInfoData.testCaseId.equals("TC_SBS_007")
				|| billInfoData.testCaseId.equals("TC_SBS_008")) {
			assertTrue(click(selenium, btnPreviewCircle),
					"Could not click the Next button", selenium, ClassName,
					MethodName);
			return true;
		}

		if (billInfoData.testCaseId.equals("TC_SBS_003")) {
			assertTrue(click(selenium, btnSCAddNew),
					"Could not click the Add New Button", selenium, ClassName,
					MethodName);
			
			if(account.equals(CAAccount)){
			assertTrue(
					selectValueFromAjaxList(selenium, ajxSCServiceCode1,
							billInfoData.serviceCodeCA),
					"Could not select service code", selenium, ClassName,
					MethodName);
			}else
				assertTrue(
						selectValueFromAjaxList(selenium, ajxSCServiceCode1,
								billInfoData.serviceCode),
						"Could not select service code", selenium, ClassName,
						MethodName);
			String descriptionDetails1 = getValue(selenium, txtSCdescription1);
			billInfoData.description = descriptionDetails1;
			if(!account.equalsIgnoreCase("CAAccount")){
				assertTrue(selectValueFromAjaxList(selenium, ajxSCModifiers3 ,billInfoData.modifiers), "Could not select Modifiers",selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxSCModifiers4,billInfoData.modifiers1),"Could not select Modifiers1", selenium, ClassName, MethodName);
			}
			
		}assertTrue(click(selenium, btnSBINext),
				"Could not click the Next button", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);
		if (billInfoData.testCaseId.equals("TC_SBS_006")) {
			assertTrue(click(selenium, btnSBIBack),
					"Could not click the Back button", selenium, ClassName,
					MethodName);
			return true;
		}
		assertTrue(click(selenium, btnSBIDone),
				"Could not click the Done button", selenium, ClassName,
				MethodName);
		return true;
		
	}

	/**
	 * completeSuperBill
	 * @throws IOException
	 * @since Jan 07, 2014
	 */

	public boolean completeSuperBill(Selenium selenium, BillingLib billInfoData, String account)throws IOException {
		@SuppressWarnings("unused")
		String date = null;
		try{
			//Get the provider name in top menu header
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+billInfoData.switchRole, "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];	
			
			
			
			
			//Get Cureent Date
			if (account.equals(CAAccount)) {
				Calendar cal1 = Calendar.getInstance();
				SimpleDateFormat DateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
				date = DateFormat1.format(cal1.getTime());
				
			} else {
				Calendar cal1 = Calendar.getInstance();
				SimpleDateFormat DateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat1.format(cal1.getTime());
			}
			
			
			
			if(!((billInfoData.testCaseId.equals("TC_SBE_006"))||(billInfoData.testCaseId.equals("TC_SBE_011")))){
				billInfoData.rprovider = pName;
			}
			
			if(!((billInfoData.testCaseId.equals("TC_SBE_006"))||(billInfoData.testCaseId.equals("TC_SBE_011")))){
				selectValueFromAjaxList(selenium, ajxCodingSystem,billInfoData.templateName);
			}
			
			if(account.equals(CAAccount)){
				selectValueFromAjaxList(selenium,ajxRenderingProvider, billInfoData.payTo);
				selectValueFromAjaxList(selenium, ajxSEQLocation, billInfoData.paymentProgram);
				selectValueFromAjaxList(selenium, ajxSpecialtyCE, billInfoData.billTo);
			}
			selectValueFromAjaxList(selenium,ajxRenderingProvider,billInfoData.rprovider);
			selectValueFromAjaxList(selenium, ajxSEQLocation, billInfoData.location);
			selectValueFromAjaxList(selenium, ajxSpecialtyCE, billInfoData.specialty);
			selectValueFromAjaxList(selenium, ajxPlaceOfService, billInfoData.placeOfService);
//			if(!getValue(selenium,ajxBProvider).toLowerCase(new java.util.Locale("en","US")).trim().contains(billInfoData.rprovider.trim().toLowerCase(new java.util.Locale("en","US")))){
//				return false;
//			}
			billInfoData.units="1";
	
			if(!((billInfoData.testCaseId.equals("TC_SBE_006"))||(billInfoData.testCaseId.equals("TC_SBE_011")))){
				if(account.equals(CAAccount)){
					assertTrue(click(selenium, chkServiceCode),"Could not click the Service Code check box", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					assertTrue(type(selenium,txtSBIUnits,billInfoData.units),"Cound not enter the units", selenium, ClassName, MethodName);
				}else{
					assertTrue(click(selenium, chkServiceCode),"Could not click the Service Code check box", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					assertTrue(type(selenium,txtSBIUnits,billInfoData.units),"Cound not enter the units", selenium, ClassName, MethodName);
				}
			}
			
			assertTrue(type(selenium,txtFeeAmount,billInfoData.fee1),"Cound not enter fee Value", selenium, ClassName, MethodName);

			if(account.equals(CAAccount)){
				assertTrue(enterDate(selenium, dateOfService, date),
						"not able to add end date", selenium, ClassName,
						MethodName);
				
/*				assertTrue(
						selectValueFromAjaxList(selenium, serviceCode,
								billInfoData.serviceCodeCA),
						"not able to add service code", selenium, ClassName,
						MethodName);
*/			}
			if(billInfoData.testCaseId.equals("TC_SBE_015")){
				//click Cancel Button
				assertTrue(click(selenium, btnCancel), "Could not click the Cancel button",selenium, ClassName, MethodName);
			}else
				// click save button
				assertTrue(click(selenium, btnSave), "Could not click the Save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
			
				if(account.equals(USAccount)){
					if(isElementPresent(selenium,chkCSBHardCopy)){
						return false;
					}else
						return true;
				}
				else
					return true;

			}catch(Exception e){
		}
		return false;
	}

	/**
	 * function to navigate service code
	 * 
	 * @param selenium
	 * @throws IOException
	 * @since Jan 07,2014
	 */
	public boolean navigateToServiceCode(Selenium selenium) throws IOException {

		assertTrue(click(selenium, lnkSettings),
				"Could not click the quick action link", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		assertTrue(click(selenium, lnkBillingSettings),
				"Could not click the billing seting link", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		assertTrue(click(selenium, lnkServiceCode),
				"Could not navigate to service code section", selenium,
				ClassName, MethodName);
		waitForPageLoad(selenium);

		return true;
	}

	/**
	 * function to add custom service code
	 * @param selenium
	 * @throws IOException
	 * @since Jan 07,2014
	 */
	public boolean addCustomServiceCode(Selenium selenium,
			BillingUnitTestLib billingData) throws IOException {
		assertTrue(click(selenium, btnAddServiceCode),
				"Could not click the add button in the service code", selenium,
				ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(click(selenium, lnkCustomTab),
				"Could not click the custom tab", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		assertTrue(
				type(selenium, txtCustomServiceCode,
						billingData.customServiceCode),
				"Could not type the custom service code", selenium, ClassName,
				MethodName);
		assertTrue(
				type(selenium, txtCustomDescription,
						billingData.customServiceDescription),
				"Could not type the custom service description", selenium,
				ClassName, MethodName);

		assertTrue(
				click(selenium, btnAddServiceCode),
				"Could not click the add button in the custom service code tab",
				selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		return true;
	}

	/**
	 * function to verify the added service code
	 * 
	 * @param selenium
	 * @throws IOException
	 * @since Jan 08,2014
	 */
	public boolean verifyAddedServiceCodeInRightPanel(Selenium selenium,
			BillingUnitTestLib billingData) throws IOException {
		String lblFirstAddedServiceCode = getText(selenium,
				lblAddedServiceCodes).trim();

		if (!lblFirstAddedServiceCode.toLowerCase().contains(
				billingData.customServiceCode.toLowerCase().trim())) {
			return false;
		}
		if (!lblFirstAddedServiceCode.toLowerCase().contains(
				billingData.customServiceDescription.toLowerCase().trim())) {
			return false;
		}

		return true;
	}

	/**
	 * function to verify the added service code
	 * 
	 * @param selenium
	 * @throws IOException
	 * @since Jan 29,2014
	 */
	public boolean verifyAddedServiceCodeInRightPanel1(Selenium selenium,
			BillingLib billingData) throws IOException {
		String lblFirstAddedServiceCode = getText(selenium,
				lblAddedServiceCodes).trim();

		if (!lblFirstAddedServiceCode.toLowerCase().contains(
				billingData.serviceCode1.toLowerCase().trim())) {
			return false;
		}
		if (!lblFirstAddedServiceCode.toLowerCase().contains(
				billingData.serviceDescription1.toLowerCase().trim())) {
			return false;
		}

		return true;
	}
	public String curfee;
	
	public boolean fillServiceFee(Selenium selenium, BillingLib billingData,
			String userAccount) throws IOException {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat;
		if(userAccount.equals(CAAccount)){			billingData.units = String.valueOf(0);
			 curfee= getText(selenium, lblStandaredFeeInSetServiceFee).trim();
			 System.out.println(curfee);
			DateFormat = new SimpleDateFormat("dd/MM/YYYY");
			billingData.effectiveOnDateCurrent = DateFormat.format(cal.getTime());
			assertTrue(enterDate(selenium, txtEffectiveDateInServiceFee,billingData.effectiveOnDateCurrent),"Could not type effect", selenium, ClassName, MethodName);
		}
		else{
			if (userAccount.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("dd/MM/YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
		}
			billingData.effectiveOnDateCurrent = DateFormat.format(cal.getTime());
			System.out.println(billingData.currentFees);
			System.out.println("aa"+curfee+"bbbb");
			try{
				if(Integer.valueOf(curfee)>0){
					billingData.currentFees = curfee;
					assertTrue(type(selenium, txtFeeAmount, billingData.currentFees),"Could not type the fee amount", selenium, ClassName,MethodName);
				}
			}catch(NumberFormatException e){
				assertTrue(type(selenium, txtFeeAmount,billingData.currentFees ),"Could not type the fee amount", selenium, ClassName,MethodName);
			}
			assertTrue(enterDate(selenium, txtEffectiveDateInServiceFee,billingData.effectiveOnDateCurrent),"Could not type effect", selenium, ClassName, MethodName);
			if(!userAccount.equals(CAAccount)){
				assertTrue(type(selenium, txtUnits, billingData.units),"Could not type the units", selenium, ClassName, MethodName);assertTrue(type(selenium, txtUnits, billingData.units),"Could not type the units", selenium, ClassName, MethodName);			}
		
		return true;
	}
	
	/**
	 * function to fill service fee- second row
	 * @param selenium
	 * @throws IOException
	 * @since Jan 24,2014
	 */
	public boolean fillServiceFeeSecond(Selenium selenium,
			BillingLib billingData, String userAccount) throws IOException {
		if(!userAccount.equals(CAAccount)){
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (userAccount.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("dd/MM/YYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			billingData.effectiveOnDateCurrent = DateFormat.format(cal.getTime());
	
			assertTrue(type(selenium, txtFeeAmountSecond, billingData.currentFees),
					"Could not type the fee amount", selenium, ClassName,
					MethodName);
			assertTrue(
					enterDate(selenium, txtEffectiveDateInServiceFeeSecond,
							billingData.effectiveOnDateCurrent),
					"Could not type effect", selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtUnitsSecond, billingData.units),
					"Could not type the units", selenium, ClassName, MethodName);
		}

		return true;
	}

	/**
	 * function to verify the set service fee details
	 * 
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Jan 29,2014
	 */
	public boolean verifyDetailsInSetServiceFees(Selenium selenium,
			BillingLib billingData) throws IOException {

		if (!getValue(selenium, txtFeeAmount).toLowerCase().contains(
				billingData.currentFees.toLowerCase().trim())) {
			return false;
		}
		if (!getValue(selenium, txtEffectiveDateInServiceFee).toLowerCase()
				.contains(billingData.effectiveOnDateCurrent.toLowerCase())) {
			return false;
		}
		if (!getValue(selenium, txtUnits).toLowerCase().contains(
				billingData.units.toLowerCase())) {
			return false;
		}
		return true;
	}

	/**
	 * function to verify the selected service code and set service fee details
	 * in set service default
	 * 
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Jan 22,2014
	 */
	public boolean verifyDetailsInSetServiceDefault(Selenium selenium,
			BillingLib billingData, String userAccount) throws IOException {
		try{
			if(billingData.serviceCode1.endsWith("A")){
				int len=billingData.serviceCode1.length();
			billingData.serviceCode1=billingData.serviceCode1.substring(0, len-1);
			}
			
			if (!getValue(selenium, txtServiceCode).toLowerCase().contains(
				billingData.serviceCode1.toLowerCase().trim())) {
			return false;
		}
		
		if(!userAccount.equals(CAAccount)){
			if (!getValue(selenium, txtCurrentFee).toLowerCase().contains(
					billingData.currentFees.toLowerCase())) {
				return false;
			}
			if (!getValue(selenium, txtCurrentEffectiveDate).toLowerCase()
					.contains(billingData.effectiveOnDateCurrent.toLowerCase())) {
				return false;
			}
			
			if (!getValue(selenium, txtServiceCodeDescription).toLowerCase()
					.contains(billingData.serviceDescription1.toLowerCase())) {
				return false;
			}
			
			if (!getValue(selenium, txtUnits).toLowerCase().contains(
					billingData.units.toLowerCase())) {
				return false;
			}
		}
		return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * function to fill set service default
	 * 
	 * @param selenium
	 * @param billingData
	 * @param userAccount
	 * @return boolean value
	 * @throws IOException
	 * @since Jan 23,2014
	 */
	public boolean fillSetServiceDefault(Selenium selenium,
			BillingLib billingData, String userAccount) throws IOException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat = null;
		
		if(!userAccount.equalsIgnoreCase(CAAccount)){
			
			if (userAccount.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("dd/MM/YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			billingData.effectiveOnDateCurrent = DateFormat.format(cal.getTime());
			assertTrue(type(selenium, txtServiceCode, billingData.serviceCode1),
					"Could not type the service code", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			assertTrue(
					type(selenium, txtServiceCodeDescription,
							billingData.serviceDescription1),
					"Could not type the service description", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtCurrentFee, billingData.currentFees),
					"Could not type the fee amount", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			assertTrue(
					enterDate(selenium, txtCurrentEffectiveDate,
							billingData.effectiveOnDateCurrent),
					"Could not type effect", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtUnits, billingData.units),
					"Could not type the units", selenium, ClassName, MethodName);
		

			if (billingData.testCaseId.equalsIgnoreCase("TC_SC_002")
					|| billingData.testCaseId.equalsIgnoreCase("TC_SC_005")) {
				
				cal.add(Calendar.DATE, 1);
				billingData.effectiveOnDateNew = DateFormat.format(cal.getTime());
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtNewFee, billingData.newFees),
						"Could not type the new fees", selenium, ClassName,
						MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						enterDate(selenium, txtNewEffectiveDate,
								billingData.effectiveOnDateNew),
						"Could not enter the new effective date", selenium,
						ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtDrugCode, billingData.drugCode),
						"Could not type the drug code", selenium, ClassName,
						MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						selectValueFromAjaxList(selenium, ajxServiceCodeModifier,
								billingData.serviceCodeModifier),
						"Could not select the service code modifier", selenium,
						ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtTotalRVU, billingData.totalRVU),
						"Could not type the total RVU", selenium, ClassName,
						MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						selectValueFromAjaxList(selenium, ajxTypeOfService,
								billingData.typeOfService),
						"Could not select the type of service", selenium,
						ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtWorkRVU, billingData.workRVU),
						"Could not type the work RVU", selenium, ClassName,
						MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, txtGlobalPeriod, billingData.globalPeriod),
						"Could not type the global period", selenium, ClassName,
						MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						selectValueFromAjaxList(selenium, ajxReportGroup,
								billingData.reportGroup),
						"Could not select the report group", selenium, ClassName,
						MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						selectValueFromAjaxList(selenium, ajxProviderSpeciality,
								billingData.providerSpeciality),
						"Could not select the provider speciality", selenium,
						ClassName, MethodName);
				waitForPageLoad(selenium);
	
				if (!isChecked(selenium, chkMultiplyFee)) {
					waitForPageLoad(selenium);
					assertTrue(click(selenium, chkMultiplyFee),
							"Could not check the multiply fee", selenium,
							ClassName, MethodName);
				}
				if (!isChecked(selenium, chkTimedProcedure)) {
					waitForPageLoad(selenium);
					assertTrue(click(selenium, chkTimedProcedure),
							"Could not check the timed procedure", selenium,
							ClassName, MethodName);
				}
				if (!isChecked(selenium, chkEPSDT)) {
					waitForPageLoad(selenium);
					assertTrue(click(selenium, chkEPSDT),
							"Could not check the EPSDT", selenium, ClassName,
							MethodName);
				}
				if (!isChecked(selenium, chkFamilyPlanning)) {
					waitForPageLoad(selenium);
					assertTrue(click(selenium, chkFamilyPlanning),
							"Could not check the family planning", selenium,
							ClassName, MethodName);
				}
				if (!isChecked(selenium, chkTaxable)) {
					waitForPageLoad(selenium);
					assertTrue(click(selenium, chkTaxable),
							"Could not check the taxable", selenium, ClassName,
							MethodName);
				}
			}
		}
		
		if(userAccount.equalsIgnoreCase(CAAccount)){
			assertTrue(type(selenium, txtServiceCode, billingData.serviceCode1),
					"Could not type the service code", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
		}
		if (billingData.testCaseId.equalsIgnoreCase("TC_SC_002")
				|| billingData.testCaseId.equalsIgnoreCase("TC_SC_005")) {
			assertTrue(
					type(selenium, txtInstructionToBiller,
							billingData.instructionToBiller),
					"Could not type the instruction to the biller", selenium,
					ClassName, MethodName);
		
		assertTrue(click(selenium, btnSaveAndNext),"Could not click the done button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
				
			
		}

		return true;
	}

	/**
	 * function to added service code details in summary page
	 * 
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Jan 23,2014
	 */
	public boolean verifyServiceCodeDetailsInSummary(Selenium selenium,
			BillingLib billingData, String userAccount) throws IOException {

		String FirstFilteredResultInServiceCode = getText(selenium,
				lblFilterResultInServiceCodeFirst);
		
		if(billingData.serviceDescription1.length()>50){
			billingData.serviceDescription1=billingData.serviceDescription1.substring(0, 50);
		}
		assertTrue(FirstFilteredResultInServiceCode.toLowerCase().contains(billingData.serviceCode1.toLowerCase().trim()),"", selenium, ClassName,MethodName);
		
		assertTrue(FirstFilteredResultInServiceCode.toLowerCase().contains(billingData.serviceDescription1.toLowerCase()),"", selenium, ClassName,MethodName);
		
		assertTrue(FirstFilteredResultInServiceCode.toLowerCase().contains(billingData.currentFees.toLowerCase()),"", selenium, ClassName,MethodName);
		//if the account type is CA then we perform some calculation to find out the unit value
		if(userAccount.equalsIgnoreCase(CAAccount)){
			System.out.println(billingData.units);
			billingData.units = String.valueOf(getUnitValueUsingFeeValue(selenium, billingData));
			System.out.println(String.valueOf(getUnitValueUsingFeeValue(selenium, billingData)));
		}
		assertTrue(FirstFilteredResultInServiceCode.toLowerCase().contains(
				billingData.units.toLowerCase()),"", selenium, ClassName,MethodName);
		return true;
	}
	
	/**
	 * This function used to get the unit value based on some calculations
	 * @param selenium
	 * @param billingData
	 * @return
	 */
	private int getUnitValueUsingFeeValue(Selenium selenium, BillingLib billingData){
		int unitValue = 0;
		
		Float divideByValue = (float) 1; 
		System.out.println(billingData.currentFees);
		Float currentFee = Float.valueOf(billingData.currentFees);
		
		if(billingData.serviceCode1.endsWith("A")){
			divideByValue = Float.valueOf(currentFee);
		}else if(billingData.serviceCode1.endsWith("B")){
			divideByValue = (float) 33.35;
		}else if(billingData.serviceCode1.endsWith("C")){
			divideByValue = (float) 15.01;
		}

		if(currentFee!=0){
			unitValue = Math.round(currentFee/divideByValue);
		}
		return unitValue;
	}

	/**
	 * function to added service code details in summary page right panel
	 * 
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Jan 29,2014
	 */
	public boolean verifyServiceCodeDetailsInSummaryRightPanel(
			Selenium selenium, BillingLib billingData, String account) throws IOException {

		try{
			
		String SummaryServiceCodeRightPanel = getText(selenium,
				lblSummaryServiceCodeRightPanel);

		// verify entered mandatory field values in right side panel
		if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
				billingData.serviceCode1.toLowerCase().trim())) {
			return false;
		}
		if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
				billingData.serviceDescription1.toLowerCase())) {
			return false;
		}
		if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
				billingData.currentFees.toLowerCase())) {
			return false;
		}
		if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
				billingData.units.toLowerCase())) {
			return false;
		}

		if(!account.equalsIgnoreCase(CAAccount)){
			
			String date = null;
			
			if (account.equals(CAAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd");
				date = DateFormat.format(cal.getTime());
				int date1 = Integer.parseInt(date);
				if (date1 < 10) {
					SimpleDateFormat DateForma1t = new SimpleDateFormat(
							"MMM d, yyyy");
					date = DateForma1t.format(cal.getTime());
				} else {
					SimpleDateFormat DateFormat2 = new SimpleDateFormat(
							"MMM dd, yyyy");
					date = DateFormat2.format(cal.getTime());
				}
			} else {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal.getTime());

			}
			billingData.effectiveOnDateNew = date;
			
			String multipliedByNoOfUnitsUncheck = "This fee should not be multiplied by the number of units";
			String multipliedByNoOfUnitsCheck = "This fee should be multiplied by the number of units";

			String timedProcedureUncheck = "This is not a timed procedure";
			String timedProcedureCheck = "This is a timed procedure";

			String EPSDTServiceUncheck = "This is not an EPSDT service (Early Periodic Screening, Diagnosis, and Treatment)";
			String EPSDTServiceCheck = "This is an EPSDT service (Early Periodic Screening, Diagnosis, and Treatment)";

			String familiyPlanningUncheck = "This is not a family planning code";
			String familiyPlanningCheck = "This is a family planning code";

			String taxableUncheck = "This service is not taxable";
			String taxableCheck = "This service is taxable";
			
			if (billingData.testCaseId.equalsIgnoreCase("TC_SC_001")
					|| billingData.testCaseId.equalsIgnoreCase("TC_SC_004")) {
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						multipliedByNoOfUnitsUncheck.toLowerCase())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						timedProcedureUncheck.toLowerCase())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						EPSDTServiceUncheck.toLowerCase())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						familiyPlanningUncheck.toLowerCase())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						taxableUncheck.toLowerCase())) {
					return false;
				}
			}
	
			// verify entered all field values in right side panel
			if (billingData.testCaseId.equalsIgnoreCase("TC_SC_002")
					|| billingData.testCaseId.equalsIgnoreCase("TC_SC_005")) {
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						billingData.newFees.toLowerCase().trim())) {
					return false;
				}
				
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						billingData.effectiveOnDateNew.toLowerCase())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						billingData.drugCode.toLowerCase())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						billingData.instructionToBiller.toLowerCase())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						billingData.serviceCodeModifier.toLowerCase())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						billingData.totalRVU.toLowerCase().trim())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						billingData.typeOfService.toLowerCase())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						billingData.workRVU.toLowerCase())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						billingData.globalPeriod.toLowerCase())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						billingData.reportGroup.toLowerCase().trim())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						billingData.providerSpeciality.toLowerCase())) {
					return false;
				}
	
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						multipliedByNoOfUnitsCheck.toLowerCase())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						timedProcedureCheck.toLowerCase())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						EPSDTServiceCheck.toLowerCase())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						familiyPlanningCheck.toLowerCase())) {
					return false;
				}
				if (!SummaryServiceCodeRightPanel.toLowerCase().contains(
						taxableCheck.toLowerCase())) {
					return false;
				}
			}
			
		}

		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * function to fill set service default unit
	 * 
	 * @param selenium
	 * @param billingData
	 * @param userAccount
	 * @return boolean value
	 * @throws IOException
	 * @since Jan 23,2014
	 */
	public boolean fillSetServiceDefaultUnit(Selenium selenium,
			BillingUnitTestLib billingData, String userAccount)
			throws IOException {
		String date = null;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat;
		if (userAccount.equalsIgnoreCase(CAAccount)) {
			DateFormat = new SimpleDateFormat("MMM dd, YYYY");
		} else {
			DateFormat = new SimpleDateFormat("MM/dd/YYYY");
		}
		date = DateFormat.format(cal.getTime());
		assertTrue(
				type(selenium, txtServiceCode, billingData.customServiceCode),
				"Could not type the service code", selenium, ClassName,
				MethodName);
		assertTrue(
				type(selenium, txtServiceCodeDescription,
						billingData.customServiceDescription),
				"Could not type the service description", selenium, ClassName,
				MethodName);
		assertTrue(type(selenium, txtCurrentFee, billingData.fees),
				"Could not type the fee amount", selenium, ClassName,
				MethodName);
		assertTrue(enterDate(selenium, txtCurrentEffectiveDate, date),
				"Could not type effect", selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtUnits, billingData.units),
				"Could not type the units", selenium, ClassName, MethodName);

		cal.add(Calendar.DATE, 1);
		date = DateFormat.format(cal.getTime());

		assertTrue(type(selenium, txtNewFee, billingData.fees),
				"Could not type the new fees", selenium, ClassName, MethodName);
		assertTrue(enterDate(selenium, txtNewEffectiveDate, date),
				"Could not enter the new effective date", selenium, ClassName,
				MethodName);
		assertTrue(type(selenium, txtDrugCode, billingData.drugCode),
				"Could not type the drug code", selenium, ClassName, MethodName);
		selectValueFromAjaxList(selenium, ajxServiceCodeModifier,
				billingData.serviceCodeModifier);
		assertTrue(type(selenium, txtTotalRVU, billingData.totalRVU),
				"Could not type the total RVU", selenium, ClassName, MethodName);
		selectValueFromAjaxList(selenium, ajxTypeOfService,
				billingData.typeOfService);
		assertTrue(type(selenium, txtWorkRVU, billingData.workRVU),
				"Could not type the work RVU", selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtGlobalPeriod, billingData.globalPeriod),
				"Could not type the global period", selenium, ClassName,
				MethodName);
		selectValueFromAjaxList(selenium, ajxReportGroup,
				billingData.reportGroup);
		selectValueFromAjaxList(selenium, ajxProviderSpeciality,
				billingData.providerSpeciality);
		assertTrue(
				type(selenium, txtInstructionToBiller,
						billingData.instructionToBiller),
				"Could not type the instruction to the biller", selenium,
				ClassName, MethodName);

		return true;
	}

	/**
	 * function to navigate to billing history
	 * 
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Jan 27,2014
	 */
	public boolean goToBillingHistory(Selenium selenium, BillingLib billingData)
		throws IOException {
	
		boolean returnValue = true;
		try {
			assertTrue(type(selenium, txtPatientBox, billingData.patientID),
					"Could not type patient id", selenium, ClassName,
					MethodName);
		} catch (Exception e) {
			assertTrue(type(selenium, txtPatientBox, billingData.patientID),
					"Could not type patient id", selenium, ClassName,
					MethodName);
		}
		selenium.clickAt("searchPatientBox","");
		selenium.focus("searchPatientBox");			
		selenium.fireEvent("searchPatientBox","keypress");		
		waitForElement(selenium, lblPatientResult, 10000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+ billingData.patientID, selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		//selenium.mouseOver(lblPatientResult);
		
		selenium.mouseOver(lblPatientResult);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, lnkBillingHistory),
				"could not click Billing Settings", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);
		
		if (!(isElementPresent(selenium, lnkBillingSummary))) {
			returnValue = false;
		}
		
		return returnValue;
	}




	/**
	 * function to verify billing history
	 * 
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Jan 27,2014
	 */
	public boolean verifyBillingSumary(Selenium selenium, BillingLib billingData)
			throws IOException {

		boolean returnValue = true;

		if (!(isElementPresent(selenium, lnkBillingSummary))) {
			returnValue = false;
		}
		if (!(isElementPresent(selenium, lnkChargeHistory))) {
			returnValue = false;
		}
		if (!(isElementPresent(selenium, lnkPaymentHistory))) {
			returnValue = false;
		}
		if (!(isElementPresent(selenium, lnkStatementHistory))) {
			returnValue = false;
		}
		if (!(isElementPresent(selenium, lnkPayerHistory))) {
			returnValue = false;
		}
		if (!(isElementPresent(selenium, lnkVisitHistory))) {
			returnValue = false;
		}
		if (!(isElementPresent(selenium, lnkPersonalHistory))) {
			returnValue = false;
		}
		if (!(isElementPresent(selenium, lnkReferralsHistory))) {
			returnValue = false;
		}

		return returnValue;
	}

	/**
	 * function to verify patient info
	 * 
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Jan 27,2014
	 */
	public boolean verifyPatientInfo(Selenium selenium, HomeLib billingData)
			throws IOException {

		boolean returnValue = true;
		System.out.println(getText(selenium, lblPatientInfo));
		assertTrue(getText(selenium, lblPatientInfo).contains(billingData.lastName),"",selenium, ClassName, MethodName);
		assertTrue(getText(selenium, lblPatientInfo).contains(billingData.sex),"",selenium, ClassName, MethodName);
		assertTrue(getText(selenium, lblPatientInfo).contains(billingData.dob),"",selenium, ClassName, MethodName);
		return returnValue;
	}

	/**
	 * function to verify billing information
	 * 
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Jan 27,2014
	 */
	public boolean verifyBillingInformation(Selenium selenium,
			String userAccount) throws IOException {

		boolean returnValue = true;

		if(userAccount.equals(CAAccount)){
			assertTrue(getText(selenium, lblPatientInfo).contains("Financial status"),"",selenium, ClassName, MethodName);
			assertTrue(getText(selenium, lblPatientInfo).contains("Last patient payment"),"",selenium, ClassName, MethodName);
			assertTrue(getText(selenium, lblPatientInfo).contains("Patient balance"),"",selenium, ClassName, MethodName);
			assertTrue(getText(selenium, lblPatientInfo).contains("Insurance Balance"),"",selenium, ClassName, MethodName);
			assertTrue(getText(selenium, lblPatientInfo).contains("Unapplied amount"),"",selenium, ClassName, MethodName);
			assertTrue(getText(selenium, lblPatientInfo).contains("Last statement"),"",selenium, ClassName, MethodName);
			assertTrue(getText(selenium, lblPatientInfo).contains("Last visit"),"",selenium, ClassName, MethodName);
			assertTrue(getText(selenium, lblPatientInfo).contains("Last referral"),"",selenium, ClassName, MethodName);
		}else{
			assertTrue(getText(selenium, lblPatientInfo).contains("Status"),"",selenium, ClassName, MethodName);
			assertTrue(getText(selenium, lblPatientInfo).contains("Note"),"",selenium, ClassName, MethodName);
			assertTrue(getText(selenium, lblPatientInfo).contains("Next Visit"),"",selenium, ClassName, MethodName);
			assertTrue(getText(selenium, lblPatientInfo).contains("Last Billing"),"",selenium, ClassName, MethodName);
			assertTrue(getText(selenium, lblPatientInfo).contains("Last Visit"),"",selenium, ClassName, MethodName);
			assertTrue(getText(selenium, lblPatientInfo).contains("Last referral"),"",selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	/**
	 * goToPostNewCharge function go To Post New Charge
	 * 
	 * @since Jan 24, 2014
	 */
	public boolean goToPostNewCharge(Selenium selenium,
			BillingLib chargeEntryData) {
		try {

			/*assertTrue(
					type(selenium, txtPatientBox, chargeEntryData.patientID),
					"Could not type patient id", selenium, ClassName,
					MethodName);
			selenium.keyPress(txtPatientBox, "\\9");
			waitForElement(selenium, lblPatientResult, 10000);
			assertTrue(selenium.isElementPresent(lblPatientResult),
					"Search Results are not displayed for the patient with ID :-"
							+ chargeEntryData.patientID, selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			assertTrue(
					getText(selenium, lblPatientResult)
							.toLowerCase(new java.util.Locale("en", "US"))
							.trim()
							.contains(
									"Mathewaa".trim().toLowerCase(
											new java.util.Locale("en", "US"))),
					"match failed", selenium, ClassName, MethodName);
			// assertTrue(getText(selenium,lblPatientResult).contains(patientID));
			waitForPageLoad(selenium);

			selenium.mouseOver(lblPatientResult);
			waitForPageLoad(selenium);
*/
			 if(isElementPresent(selenium, lnkPostCharge))
					assertTrue(click(selenium, lnkPostCharge), "Could not present Post charge link",selenium, ClassName, MethodName);
			 else if(isElementPresent(selenium, lnkPostChargeHome))
					assertTrue(click(selenium, lnkPostChargeHome), "Could not present Post charge link",selenium, ClassName, MethodName);
				
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkPostNewCharge),
					"Could not click the Post new charge link", selenium,
					ClassName, MethodName);
			waitForPageLoad(selenium);


			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	public boolean savePostChargeEntry(Selenium selenium,
			BillingLib chargeEntryData, String account) throws IOException {
		String date = null;
//		chargeEntryData.workSheetName = "ChargeEntry";
//		chargeEntryData.testCaseId = "TC_CE_014";
//		chargeEntryData.fetchBillingTestData();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
		if(account.equals(CAAccount)){
			DateFormat = new SimpleDateFormat("dd/MM/yyyy");
		}
		date = DateFormat.format(cal.getTime());
		chargeEntryData.dateOfService1=date;
		chargeEntryData.dateOfService2=date;
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium, lstRenderingProvider),
				"Rendering Provider textbox not Present", selenium, ClassName,
				MethodName);
		assertTrue(isElementPresent(selenium, lstBillingProvider),
				"Billing Provider textbox not Present", selenium, ClassName,
				MethodName);
		assertTrue(isElementPresent(selenium, location),
				"Location textbox not Present", selenium, ClassName,
				MethodName);
		assertTrue(isElementPresent(selenium, placeOfService),
				"Place of service textbox not Present", selenium, ClassName,
				MethodName);
		if(account.equals(USAccount)){
		assertTrue(isElementPresent(selenium, lstDiagnosis00),
				"Diagnosis Code textbox not Present", selenium, ClassName,
				MethodName);
		}
		
		

		assertTrue(isElementPresent(selenium, serviceCode),
				"Service Code textbox not Present", selenium, ClassName,
				MethodName);
		if(account.equals(USAccount)){
		assertTrue(isElementPresent(selenium, diagnosisCodeSL),
				"Diagnosis Code textbox not Present in Service Line", selenium, ClassName,
				MethodName);
		}else
			assertTrue(isElementPresent(selenium, diagnosisCodeSLCA),
					"Diagnosis Code textbox not Present in Service Line", selenium, ClassName,
					MethodName);
		assertTrue(isElementPresent(selenium, txtFee),
				"Fee textbox not Present", selenium, ClassName,
				MethodName);
		assertTrue(isElementPresent(selenium, btnSaveChargeEntry),
				"Save Button not Present", selenium, ClassName,
				MethodName);

		assertTrue(
				selectValueFromAjaxList(selenium, lstRenderingProvider,
						chargeEntryData.renderingProvider),
				"Not able to add Rendering Provider", selenium, ClassName,
				MethodName);
		assertTrue(
				selectValueFromAjaxList(selenium, location,
						chargeEntryData.location),
				"Not able to add Location", selenium, ClassName,
				MethodName);
		if(account.equals(CAAccount)){
			assertTrue(
					selectValueFromAjaxList(selenium, ajxserviceLevInd,
							chargeEntryData.ServiceLevelIndicator),
					"not able to add service code", selenium, ClassName,
					MethodName);
		}
		if(account.equals(USAccount)){
			assertTrue(
					selectValueFromAjaxList(selenium, placeOfService,
							chargeEntryData.placeOfServiceUS),
					"Not able to add Place of Service", selenium, ClassName,
					MethodName);
			assertTrue(
					selectValueFromAjaxList(selenium, lstBillingProvider,
							chargeEntryData.billingProviderUS),
					"Not able to add Billing provider", selenium, ClassName,
					MethodName);
		}else
		{
		assertTrue(
				selectValueFromAjaxList(selenium, placeOfService,
						chargeEntryData.placeOfService),
				"Not able to add Place of Service", selenium, ClassName,
				MethodName);
		assertTrue(
				selectValueFromAjaxList(selenium, lstBillingProvider,
						chargeEntryData.billingProvider),
				"Not able to add Billing provider", selenium, ClassName,
				MethodName);
		}
		if(account.equals(USAccount)){
		assertTrue(
				selectValueFromAjaxList(selenium, lstDiagnosis00,
						chargeEntryData.diagnosisCode),
				"Not able to add diagonsis code", selenium, ClassName,
				MethodName);
		}
		if(account.equals(CAAccount)){
			assertTrue(enterDate(selenium, dateSLDateCA, chargeEntryData.dateOfService1),
					"not able to add end date", selenium, ClassName,
					MethodName);
		assertTrue(
					selectValueFromAjaxList(selenium, serviceCode,
							chargeEntryData.serviceCodeCA),
					"not able to add service code", selenium, ClassName,
					MethodName);
		}else{
			assertTrue(enterDate(selenium, dateSLEndDate, chargeEntryData.dateOfService2),
					"not able to add end date", selenium, ClassName,
					MethodName);
			assertTrue(enterDate(selenium, dateSLStartDate, chargeEntryData.dateOfService1),
					"not able to add start date", selenium, ClassName,
					MethodName);
		assertTrue(
				selectValueFromAjaxList(selenium, serviceCode,
						chargeEntryData.serviceCode),
				"not able to add service code", selenium, ClassName,
				MethodName);
		}
		if(account.equals(USAccount)){
		assertTrue(
				selectValueFromAjaxList(selenium, diagnosisCodeSL,
						chargeEntryData.diagnosisCodeSL),
				"no able to add diagnosis code in service line", selenium, ClassName,
				MethodName);
		}else
		assertTrue(
				selectValueFromAjaxList(selenium, diagnosisCodeSLCA,
						chargeEntryData.diagnosisCodeSL),
				"no able to add diagnosis code in service line", selenium, ClassName,
				MethodName);
		assertTrue(type(selenium, txtUnits, chargeEntryData.units),
				"Not able to add units", selenium, ClassName,
				MethodName);
		assertTrue(type(selenium, txtFee, chargeEntryData.fee),
				"Not able to add units", selenium, ClassName,
				MethodName);
		assertTrue(selectValueFromAjaxList(selenium, ajxPayToBox, chargeEntryData.payTo),
				"not able to add end date", selenium, ClassName,
				MethodName);
		
		assertTrue(
				selectValueFromAjaxList(selenium, ajxBillTo,
						"Patient"),
				"no able to add diagnosis code in service line", selenium, ClassName,
				MethodName);
		
		assertTrue(
				selectValueFromAjaxList(selenium, ajxPaymentProgram,
						"HCP - Health Claims Payment"),
				"no able to add diagnosis code in service line", selenium, ClassName,
				MethodName);
		
		if (chargeEntryData.testCaseId.equals("TC_CE_015")
				|| chargeEntryData.testCaseId.equals("TC_CE_016")||chargeEntryData.testCaseId.equals("TC_CE_020")
				|| chargeEntryData.testCaseId.equals("TC_CE_021")) {
			assertTrue(isElementPresent(selenium, chkBoxAccident),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			assertTrue(click(selenium, chkBoxAccident),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, chkBoxEmployment),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			assertTrue(click(selenium, chkBoxEmployment),"Adjustment Reason textbox not Present", selenium,	ClassName, MethodName);
			assertTrue(isElementPresent(selenium, dateAccidentDate),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			if(account.equals(CAAccount)){
				assertTrue(enterDate(selenium, dateAccidentDate,chargeEntryData.dateOfService1),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			}else{
				assertTrue(enterDate(selenium, dateAccidentDate,chargeEntryData.dateOfService1),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			}
			if(account.equals(USAccount)){
			assertTrue(isElementPresent(selenium, lstAccidentState),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, lstAccidentState,chargeEntryData.accidentState),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			}
			assertTrue(isElementPresent(selenium,txtStartHour ),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtStartHour,chargeEntryData.accidentHour),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium,txtStartMinute ),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtStartMinute,chargeEntryData.accidentHour),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium,txtStartMinute ),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtStartMinute,chargeEntryData.accidentMins),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium,lstamPm ),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, lstamPm,chargeEntryData.amPm),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
		}
		
		if (chargeEntryData.testCaseId.equals("TC_CE_020")
				|| chargeEntryData.testCaseId.equals("TC_CE_021")) {
			
			assertTrue(isElementPresent(selenium, lstspecialty),"speciality textbox not present", selenium,ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, lstspecialty,chargeEntryData.specialty),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			
			assertTrue(isElementPresent(selenium, lstReferringProvider),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, lstReferringProvider,chargeEntryData.referringProvider),"Adjustment Reason textbox not Present", selenium,	ClassName, MethodName);
			
			assertTrue(isElementPresent(selenium, lstCase),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, lstCase,chargeEntryData.caseChargeEntry),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			
			assertTrue(isElementPresent(selenium, lstProgram),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, lstProgram,chargeEntryData.program),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			
			if(account.equals(USAccount)){
			assertTrue(isElementPresent(selenium,lstmodifiers),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, lstmodifiers,chargeEntryData.modifiers),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			}
			if(account.equals(USAccount)){
			assertTrue(isElementPresent(selenium,diagnosisCodeSL ),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, diagnosisCodeSL,chargeEntryData.diagnosisCodeSL),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
			}else{
				assertTrue(isElementPresent(selenium,diagnosisCodeSLCA ),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, diagnosisCodeSLCA,chargeEntryData.diagnosisCodeSL),"Adjustment Reason textbox not Present", selenium,ClassName, MethodName);
				
			}
			
		}
		
		if (chargeEntryData.testCaseId.equals("TC_CE_036")) {
			assertTrue(click(selenium, chkChiroPrac),"Show All Detail link not present", selenium,ClassName, MethodName);
			
			assertTrue(isElementPresent(selenium, lstPatientCond),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtCondDesc),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, dateInitialTreat),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, dateAcuteMan),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, radYes),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, radNo),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, dateLastXray),"Show All Detail link not present", selenium,ClassName, MethodName);
			
			
			assertTrue(type(selenium, lstPatientCond,chargeEntryData.patientCond),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtCondDesc, chargeEntryData.condDesc),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(enterDate(selenium, dateInitialTreat,chargeEntryData.dateInitialTreat),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(enterDate(selenium, dateAcuteMan,chargeEntryData.dateAcuteMan),"Show All Detail link not present", selenium,ClassName, MethodName);
			if (chargeEntryData.radYes.equals("True")) {
				assertTrue(click(selenium, radYes),"Show All Detail link not present", selenium,ClassName, MethodName);
			}
			if (chargeEntryData.radNo.equals("True")) {
				assertTrue(click(selenium, radNo),"Show All Detail link not present", selenium,ClassName, MethodName);
			}
			assertTrue(
					enterDate(selenium, dateLastXray,chargeEntryData.dateLastXray),"Show All Detail link not present", selenium,ClassName, MethodName);
		}
		if (chargeEntryData.testCaseId.equals("TC_CE_035")) {
			
			assertTrue(click(selenium, chkAmbulanceTrans),"Show All Detail link not present", selenium,ClassName, MethodName);
			
			assertTrue(isElementPresent(selenium, txtPatientWeight),"Patient Weight textbox not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtPatientCount),"Patient Count textbox not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtTransDist),"Transport Distance not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtRoungTrip),"Round Trip tes", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, lstAmbulanceTransReason),"Round Trip tes", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtStretcherPurpose),	"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtStreet1),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtStreet2),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtCity),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, lstState),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtZip),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, lstCountry),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtDropStreet1),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtDropStreet2),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtDropCity),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, lstDropState),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtDropZip),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, lstDropCountry),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium,lnkClickToSelectConditionCode),"Show All Detail link not present", selenium,ClassName, MethodName);

			assertTrue(type(selenium, txtPatientWeight,chargeEntryData.patientWeight),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtPatientCount,chargeEntryData.patientCount),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtTransDist,chargeEntryData.transDistance),"Show All Detail link not present", selenium,	ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, lstAmbulanceTransReason,chargeEntryData.transReason),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtRoungTrip, chargeEntryData.roundTrip),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtStretcherPurpose,chargeEntryData.stretcherPurpose),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtStreet1, chargeEntryData.pickStreet1),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtStreet2, chargeEntryData.pickStreet2),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtCity, chargeEntryData.pickCity),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, lstState,chargeEntryData.pickState),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtZip, chargeEntryData.pickZip),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, lstCountry,chargeEntryData.pickCountry),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtDropStreet1,chargeEntryData.dropStreet1),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtDropStreet2,chargeEntryData.dropStreet2),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtDropCity, chargeEntryData.dropCity),"Show All Detail link not present", selenium,ClassName, MethodName);			
			assertTrue(selectValueFromAjaxList(selenium, lstDropState,chargeEntryData.dropState),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtDropZip, chargeEntryData.dropZip),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, lstDropCountry,chargeEntryData.dropCountry),"Show All Detail link not present", selenium,ClassName, MethodName);
			
			}
		if (chargeEntryData.testCaseId.equals("TC_CE_037")) {
			
			assertTrue(click(selenium, chkDME),"Show All Detail link not present", selenium,ClassName, MethodName);
			
			assertTrue(isElementPresent(selenium, lstDMECerti),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtEquipDuration),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, dateCertiRev),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, dateBeginTherapy),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, dateLastCerti),	"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtPatientHeight),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtDMEPatientWeight),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtLenMedicalNece),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtRentalPrice),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, lstRentalPriceUnit),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtPurchasePrice),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, lnkDMECertiCondition),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtCTCode),"Show All Detail link not present", selenium,ClassName, MethodName);
			chargeEntryData.certiRevDate=date;
			chargeEntryData.beginTherapyDate=date;
			chargeEntryData.lastCertiDate=date;
			assertTrue(selectValueFromAjaxList(selenium, lstDMECerti,chargeEntryData.dMECertificate),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtEquipDuration,chargeEntryData.equipDuration),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(enterDate(selenium, dateCertiRev,chargeEntryData.certiRevDate),"Show All Detail link not present", selenium,	ClassName, MethodName);
			assertTrue(enterDate(selenium, dateBeginTherapy,chargeEntryData.beginTherapyDate),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(enterDate(selenium, dateLastCerti, chargeEntryData.lastCertiDate),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtPatientHeight,chargeEntryData.patientHeight),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtDMEPatientWeight, chargeEntryData.dMEPatientWeight),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtLenMedicalNece, chargeEntryData.lenMedicalNece),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtRentalPrice, chargeEntryData.rentalPrice),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, lstRentalPriceUnit,chargeEntryData.rentalPriceUnit),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtPurchasePrice, chargeEntryData.purchasePrice),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, txtCTCode, chargeEntryData.ctCode),"Show All Detail link not present", selenium,ClassName, MethodName);
			
			
		}
		if (chargeEntryData.testCaseId.equals("TC_CE_038")) {
			
			assertTrue(click(selenium, chkOxygen),"Show All Detail link not present", selenium,ClassName, MethodName);
			
			assertTrue(isElementPresent(selenium, lstOxyCerti),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtOxyduration),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, lnkOxyCertiCondition),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, dateOxyCertiRev),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, dateOxyBeginTherapy),	"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, dateOxyLastCerti),"Show All Detail link not present", selenium,ClassName, MethodName);
			chargeEntryData.oxyCertiRevDate=date;
			chargeEntryData.oxyBeginTherapyDate=date;
			assertTrue(selectValueFromAjaxList(selenium, lstOxyCerti,chargeEntryData.oxyCertificate),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtOxyduration,chargeEntryData.oxyDuration),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(enterDate(selenium, lnkOxyCertiCondition,chargeEntryData.oxyCertiCondition),"Show All Detail link not present", selenium,	ClassName, MethodName);
			assertTrue(enterDate(selenium, dateOxyCertiRev,chargeEntryData.oxyCertiRevDate),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(enterDate(selenium, dateOxyBeginTherapy, chargeEntryData.oxyBeginTherapyDate),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, dateOxyLastCerti,chargeEntryData.oxyLastCertiDate),"Show All Detail link not present", selenium,ClassName, MethodName);
			
			
		}
		
		if (chargeEntryData.testCaseId.equals("TC_CE_039")) {
			
			assertTrue(click(selenium, chkNDCDrug),"Show All Detail link not present", selenium,ClassName, MethodName);
			
			assertTrue(isElementPresent(selenium, txtNDCDrugCode),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtQuantity),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, lstPresciptionType),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, lstUnitType),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, txtPrescriptionNum),	"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, datePrescription),"Show All Detail link not present", selenium,ClassName, MethodName);
			
			assertTrue(selectValueFromAjaxList(selenium, txtNDCDrugCode,chargeEntryData.NDCDrugCode),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, txtQuantity,chargeEntryData.quantity),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(enterDate(selenium, lstPresciptionType,chargeEntryData.presciptionType),"Show All Detail link not present", selenium,	ClassName, MethodName);
			assertTrue(enterDate(selenium, lstUnitType,chargeEntryData.unitType),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(enterDate(selenium, txtPrescriptionNum, chargeEntryData.prescriptionNum),"Show All Detail link not present", selenium,ClassName, MethodName);
			assertTrue(type(selenium, datePrescription,chargeEntryData.PrescriptionDate),"Show All Detail link not present", selenium,ClassName, MethodName);
		}
		if (chargeEntryData.testCaseId.equals("TC_CE_058")){
			assertTrue(isElementPresent(selenium, ajxSpeciality),"Speciality Suggestbox ia present fot multiple rendering provider", selenium,ClassName, MethodName);
			assertTrue(isElementPresent(selenium, ajxRenderingProviderSL),"Speciality Suggestbox ia present fot multiple rendering provider", selenium,ClassName, MethodName);
		}
		if (chargeEntryData.testCaseId.equals("TC_CE_059")){
			assertTrue(click(selenium, chkboxInpatient),"Not able to click Inpatient Check box", selenium,ClassName, MethodName);
			assertTrue(enterDate(selenium, dateOfAddmission, chargeEntryData.DateOfAdmission),"Not able to click Inpatient Check box", selenium,ClassName, MethodName);
		}
			
		
		
		if (chargeEntryData.testCaseId.equals("TC_CE_013")||chargeEntryData.testCaseId.equals("TC_CE_021")||chargeEntryData.testCaseId.equals("TC_CE_015")) {
			assertTrue(click(selenium, btnSaveChargeEntry),
					"Not able to click Save Button", selenium,
					ClassName, MethodName);
		}

		if (chargeEntryData.testCaseId.equals("TC_CE_014")||chargeEntryData.testCaseId.equals("TC_CE_020")||chargeEntryData.testCaseId.equals("TC_CE_016")||chargeEntryData.testCaseId.equals("TC_CE_035")||chargeEntryData.testCaseId.equals("TC_CE_036")||chargeEntryData.testCaseId.equals("TC_CE_037")||chargeEntryData.testCaseId.equals("TC_CE_038")||chargeEntryData.testCaseId.equals("TC_CE_039")||chargeEntryData.testCaseId.equals("TC_CE_058")||chargeEntryData.testCaseId.equals("TC_CE_059")) {
			assertTrue(click(selenium, btnPostChargeEntry),
					"Not able to click Post Button", selenium,
					ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent("Summary"),
					"Not navigated to Summary page after Post Charge Entry", selenium,
					ClassName, MethodName);
		}

		waitForPageLoad(selenium);

		return true;
	}





	
	/**
	 * navigateToPatient 
	 * function navigateToPatient
	 * @since Feb 04, 2014
	 **/ 
	public boolean navigateToPatient(Selenium selenium, BillingLib PatientData) throws IOException{
		 if(isElementPresent(selenium, btnErrorClose)) {
			 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		 }
		assertTrue(type(selenium, txtPatientBox, PatientData.patientID),"Could not type patient id", selenium, ClassName,MethodName);
		selenium.clickAt("searchPatientBox","");
		selenium.focus("searchPatientBox");			
		selenium.fireEvent("searchPatientBox","keypress");		
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForElement(selenium, lblPatientResult, 10000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+ PatientData.patientID, selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		selenium.mouseOver(lblPatientResult2);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		return true;
		}
	/**
	 * navigateToPatient 
	 * function navigateToPatient
	 * @since Feb 04, 2014
	 **/ 
	public boolean navigateToPatientByPatientId(Selenium selenium, String patientId) throws IOException{
		
		assertTrue(type(selenium, txtPatientBox, patientId),"Could not type patient id", selenium, ClassName,MethodName);
		selenium.clickAt("searchPatientBox","");
		selenium.focus("searchPatientBox");			
		selenium.fireEvent("searchPatientBox","keypress");		
		waitForElement(selenium, lblPatientResult, 10000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+ patientId, selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		selenium.mouseOver(lblPatientResult2);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		return true;
		}
	

	
	/**
	 * navigateToPostPatientPayment 
	 * function navigateToPostPatientPayment
	 * @@since Feb 04, 2014
	 **/ 
public boolean navigateToNewPatient(Selenium selenium, BillingLib PatientData) throws IOException{
		
		assertTrue(type(selenium, txtPatientBox, PatientData.patientID),"Could not type patient id", selenium, ClassName,MethodName);
		selenium.clickAt("searchPatientBox","");
		selenium.focus("searchPatientBox");			
		selenium.fireEvent("searchPatientBox","keypress");		
		waitForElement(selenium, lblPatientResult, 10000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+ PatientData.patientID, selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		selenium.mouseOver(lblPatientResult2);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		return true;
		}
	/**
	public boolean navigateToPostPatientPayment(Selenium selenium, BillingLib PPPData) throws IOException{
		
		assertTrue(isElementPresent(selenium, lnkPatientPostPatientPayments),"Could not present Post Patient Payments", selenium,ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(click(selenium, lnkPatientPostPatientPayments),"Could not present Post Patient Payments", selenium,ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(isElementPresent(selenium,lnkStartNewBranch))
			assertTrue(click(selenium, lnkStartNewBranch),"Could not click the Start New branch Link", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);

		return true;
	}
	
	/**
	 * addPatientPayment 
	 * function addPatientPayment
	 * @@since Feb 04, 2014
	 **/ 
	public boolean addPatientPayment(Selenium selenium, BillingLib PPPData)throws IOException {
		
		String date = null;
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
		date=DateFormat.format(cal.getTime());
		
		if(PPPData.testCaseId.equals("TC_PPP_001")||PPPData.testCaseId.equals("TC_PPP_003")){
			assertTrue(enterDate(selenium, txtdepositDate, date),"Could not enter the deposit Date", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		assertTrue(selectValueFromAjaxList(selenium,ajxMethodOfPayment,PPPData.methodOfPayment),"Could not select the Method Of Payment", selenium , ClassName, MethodName);
		assertTrue(type(selenium,txtreferenceNo,PPPData.referenceNo),"Could not enter the reference No", selenium,ClassName, MethodName);
		
		if(PPPData.testCaseId.equals("TC_PPP_021")|| PPPData.testCaseId.equals("TC_PPP_022")){
			//assertTrue(type(selenium,txpaidAmount,PPPData.paidAmount),"Could not enter the Paid Amount", selenium,ClassName, MethodName);
			return true;
		}
		
		assertTrue(type(selenium,txpaidAmount,PPPData.paidAmount),"Could not enter the Paid Amount", selenium,ClassName, MethodName);
		assertTrue(selectValueFromAjaxList(selenium,ajxPPPprovider,PPPData.provider),"Could not select the Provider", selenium , ClassName, MethodName);
		assertTrue(selectValueFromAjaxList(selenium,ajxPPPLocation,PPPData.location),"Could not select the Location", selenium , ClassName, MethodName);
		
		if(PPPData.leaveUnallocate.equals("Yes")&& ((PPPData.testCaseId.equals("TC_PPP_023")|| PPPData.testCaseId.equals("TC_PPP_024")
				||PPPData.testCaseId.equals("TC_PPP_025")||PPPData.testCaseId.equals("TC_PPP_026")))){
			assertTrue(click(selenium, lnkEpandArrow),"Could not click the Expand Arrow", selenium,ClassName, MethodName);
			//assertTrue(click(selenium, chkUnAllocate),"Could not check the leave un allocate check box", selenium,ClassName, MethodName);
			return true;
		}
		
		
		if(PPPData.autoallocate.equals("Yes")&& ((PPPData.testCaseId.equals("TC_PPP_010")|| PPPData.testCaseId.equals("TC_PPP_011")))){
			assertTrue(click(selenium, chkAutoAllocate),"Could not check the auto allocate check box", selenium,ClassName, MethodName);
			assertTrue(click(selenium, lnkEpandArrow),"Could not click the Expand Arrow", selenium,ClassName, MethodName);
			return true;
			
		}
		
		if(PPPData.testCaseId.equals("TC_PPP_012")|| PPPData.testCaseId.equals("TC_PPP_013")||PPPData.testCaseId.equals("TC_PPP_014")
				||PPPData.testCaseId.equals("TC_PPP_015")||PPPData.testCaseId.equals("TC_PPP_016")||PPPData.testCaseId.equals("TC_PPP_017")
				||PPPData.testCaseId.equals("TC_PPP_018")||PPPData.testCaseId.equals("TC_PPP_019")||PPPData.testCaseId.equals("TC_PPP_027")
				||PPPData.testCaseId.equals("TC_PPP_028")){
			assertTrue(click(selenium, lnkEpandArrow),"Could not click the Expand Arrow", selenium,ClassName, MethodName);
			return true;
		}
		
		if(PPPData.testCaseId.equals("TC_PPP_002")){
			assertTrue(click(selenium, lnkEpandArrow),"Could not click the Expand Arrow", selenium,ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxChargesOpen,"Show open patient charges"),"Could not select the Method Of Payment", selenium , ClassName, MethodName);
			return true;
		}
		
		
		if(PPPData.testCaseId.equals("TC_PPP_003")||PPPData.testCaseId.equals("TC_PPP_008")||PPPData.testCaseId.equals("TC_PPP_009")){
			assertTrue(click(selenium, btnPPPCancel),"Could not click the cancel button", selenium,ClassName, MethodName);
			return true;
		}
		
		/*if(PPPData.testCaseId.equals("TC_PPP_008")||PPPData.testCaseId.equals("TC_PPP_009")){
			assertTrue(click(selenium, btnPPtSave),"Could not click the save button", selenium,ClassName, MethodName);
		}*/
		
		if(PPPData.testCaseId.equals("TC_PPP_004")||PPPData.testCaseId.equals("TC_PPP_005")
				||PPPData.testCaseId.equals("TC_PPP_006")||PPPData.testCaseId.equals("TC_PPP_007")){
			assertTrue(click(selenium, btnPPatiemtPaymentAdd),"Could not click the Add New button", selenium,ClassName, MethodName);
			assertTrue(click(selenium, btnPPRemove1),"Could not click the remove button", selenium,ClassName, MethodName);
			return true;
		}
		else{
		assertTrue(click(selenium, btnPost),"Could not click the post button", selenium,ClassName, MethodName);
		assertTrue(click(selenium, btnPostYes),"Could not click the yes button", selenium,ClassName, MethodName);
		
		}
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose), "could not click error close",selenium, ClassName, MethodName);
		return true;
		
	}

	/**
	 * navigate to enter Patient Payment
	 * function navigateToEnterPatientPayment
	 * @throws IOException 
	 * @@since Feb 04, 2014
	 **/ 
	
	public boolean navigateToEnterPatientPayment(Selenium selenium) throws IOException{
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName, MethodName);
		assertTrue(click(selenium, lnkQuickAction),"Could not click the Quick Action", selenium,ClassName, MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName, MethodName);
		
		assertTrue(click(selenium, lnkEnterPatientPayment),"Could not click the Enter patient payment", selenium,ClassName, MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,lnkStartNewBranch)){
			assertTrue(click(selenium, lnkStartNewBranch),"Could not click the Start New branch Link", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		return true;
	}

	
	/**
	 * searchPatientPayment
	 * function search Patient Payment
	 * @throws IOException 
	 * @@since Feb 04, 2014
	 **/ 
	
	public boolean searchPatientPayment(Selenium selenium, BillingLib PostPatientData) throws IOException{
		
		assertTrue(type(selenium, txtSearchPatient, PostPatientData.patientID),"Could not type patient id", selenium, ClassName,MethodName);
		selenium.clickAt(txtSearchPatient,"");
		selenium.focus(txtSearchPatient);			
		selenium.fireEvent(txtSearchPatient,"keypress");		
		waitForElement(selenium, lblPatientResult, 10000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+ PostPatientData.patientID, selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		selenium.click(lblPatientResult);
		waitForPageLoad(selenium);
		return true;
		
	}
	
	
	
	/**
	 * addPostPatientPayment
	 * function search Patient Payment
	 * @throws IOException 
	 * @@since Feb 04, 2014
	 **/ 
	public boolean addPostPatientPayment(Selenium selenium, BillingLib PostPatientData)throws IOException{
		
		//search patient
		assertTrue(searchPatientPayment(selenium,PostPatientData ),"Could not search the patient",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//Create Patient Payment Batch
		
		assertTrue(addPatientPayment(selenium,PostPatientData ),"Patient Payment creation Failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		return true;
	}
	
	/**
	 * goToStatmentPreferences function go To AdjustmentReasons
	 * 
	 * @since Feb 04, 2014
	 */
	public boolean goToStatmentPreferences(Selenium selenium) {
		try {

			assertTrue(click(selenium, lnkSettings),
					"Could not click Quick Action", selenium, ClassName,
					MethodName);

			assertTrue(click(selenium, lnkBillingSettings),
					"Could not click Billing Settings", selenium, ClassName,
					MethodName);

			waitForPageLoad(selenium);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, lnkStatementPreferences),
					"Could not click Statement Preferences", selenium, ClassName,
					MethodName);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * function to navigate to batch payer payment
	 * @param  selenium
	 * @throws IOException
	 * @since  Feb 05,2014
	 */
	public boolean navigateToBatchPayerPayment(Selenium selenium) throws IOException {

		assertTrue(click(selenium, lnkQuickAction),
				"Could not click the quick action link", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);
		
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkPayerPayment),
				"Could not click the payer payment link", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		return true;
	}
	
	/**
	 * function to fill batch payer entry
	 * 
	 * @param selenium
	 * @param billingData
	 * @throws IOException
	 * @since Feb 06,2014
	 */
	public boolean fillBatchPayerEntry(Selenium selenium,
			BillingLib billingData, String userAccount) throws IOException {
		String date = null;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat;
		if (userAccount.equalsIgnoreCase(CAAccount)) {
			DateFormat = new SimpleDateFormat("dd/MM/YYYY");
		} else {
			DateFormat = new SimpleDateFormat("MM/dd/YYYY");
		}
		date = DateFormat.format(cal.getTime());
		assertTrue(
				selectValueFromAjaxList(selenium, ajxInsurance,
						billingData.insurance),
				"Could not select the Payer/ Insurance", selenium, ClassName,
				MethodName);
		assertTrue(type(selenium, txtCheckAmount, billingData.checkAmount),
				"Could not type the check amount", selenium, ClassName,
				MethodName);
		assertTrue(type(selenium, txtCheck, billingData.checkNumber),
				"Could not type the check number", selenium, ClassName,
				MethodName);

		assertTrue(enterDate(selenium, txtDepositDate, date),
				"Could not enter the date in the deposit date", selenium,
				ClassName, MethodName);
		assertTrue(
				type(selenium, txtTotalPaidAmt, billingData.totalPaidAmount),
				"Could not type the Total paid amount", selenium, ClassName,
				MethodName);

		assertTrue(
				selectValueFromAjaxList(selenium, adjustmentReason,
						billingData.adjustmentReason),
				"Could not select the contaractual adjustment reason",
				selenium, ClassName, MethodName);	

		return true;
	}


	/**
	 * function for payer payment data setup
	 * @param selenium
	 * @param billingData
	 * @throws IOException
	 * @since Feb 06,2014
	 */
	public boolean dataSetupForPayerPayment(Selenium selenium,
			BillingLib adjustmentCodeData, BillingLib chargeEntryData,
			String userAccount) throws IOException {

		// navigate to adjustment reason
		/*assertTrue(goToAdjustmentReasons(selenium),
				"Adjustment Navigation Failed", selenium, ClassName, MethodName);

		if (isElementPresent(selenium, btnAdd)) {
			assertTrue(click(selenium, btnAdd),
					"Not able to click Add New", selenium, ClassName,
					MethodName);
		}

		// add adjustment reason
		assertTrue(addAdjustmentReasons(selenium, adjustmentCodeData),
				"Not able to Add New Adjustment Reason", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);*/

		/*assertTrue(click(selenium,btnNexiaLogo),"Could not click the post button", selenium, ClassName,MethodName);
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose));*/
		
		// navigate to charge entry
		assertTrue(navigateToPatient(selenium, chargeEntryData),
				"post charge Navigation Failed", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);
	
		assertTrue(goToPostNewCharge(selenium, chargeEntryData),
				"post charge Navigation Failed", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		// post charge entry
		assertTrue(postChargeForPayerPaymentSetUp(selenium, chargeEntryData, userAccount),
				"post charge entry failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		return true;
	}


	/**
	 * function to fill first claim entry
	 * @param selenium
	 * @param billingData
	 * @throws IOException
	 * @since Feb 14,2014
	 */
	public boolean fillFirstClaimEntry(Selenium selenium, BillingLib billingData, String userAccount) throws IOException {
		
		assertTrue(type(selenium, txtAllowedAmt1, billingData.allowedAmt1), "Could not type the allowed amount", selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtDeductable1, billingData.deductable1), "Could not type the deductable", selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtCoPayment1, billingData.coPayment1), "Could not type the co- payment", selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtPaidAmount1, billingData.paidAmt1), "Could not type the paid amount", selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtContaractualAdjustment1, billingData.contractualAmt1), "Could not type the contractual amount", selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtAdjustmentAmount1, billingData.adjustmentAmt1), "Could not type the adjustment amount", selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtCoInsurance1, billingData.coInsurance1), "Could not type the co- insurance", selenium, ClassName, MethodName);
		
		return true;
	}

	
	/**
	 * function to fill second claim entry
	 * @param selenium
	 * @param billingData
	 * @throws IOException
	 * @since Feb 14,2014
	 */
	public boolean fillSecondClaimEntry(Selenium selenium, BillingLib billingData, String userAccount) throws IOException {
		
		assertTrue(type(selenium, txtAllowedAmt2, billingData.allowedAmt2), "Could not type the allowed amount", selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtDeductable2, billingData.deductable2), "Could not type the deductable", selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtCoPayment2, billingData.coPayment2), "Could not type the co- payment", selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtPaidAmount2, billingData.paidAmt2), "Could not type the paid amount", selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtContaractualAdjustment2, billingData.contractualAmt2), "Could not type the contractual amount", selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtAdjustmentAmount2, billingData.adjustmentAmt2), "Could not type the adjustment amount", selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtCoInsurance2, billingData.coInsurance2), "Could not type the co- insurance", selenium, ClassName, MethodName);
		
		return true;
	}



	/**
	 * function for postChargeForPayerPaymentSetUp
	 * @param selenium
	 * @param billingData
	 * @throws IOException
	 * @since Feb 15,2014
	 */
	public boolean postChargeForPayerPaymentSetUp(Selenium selenium,BillingLib chargeEntryData,String userAccount) throws IOException{
		try{
		assertTrue(selectValueFromAjaxList(selenium, ajxRenderingProvider,chargeEntryData.renderingProvider),"Could not select the rendering provider", selenium, ClassName,MethodName);
		assertTrue(selectValueFromAjaxList(selenium, ajxBillingProvider,chargeEntryData.billingProvider),"Could not select the billing provider", selenium, ClassName,MethodName);
		assertTrue(selectValueFromAjaxList(selenium, location,chargeEntryData.location),"Could not select the Location", selenium, ClassName,MethodName);
		assertTrue(selectValueFromAjaxList(selenium, placeOfService,chargeEntryData.placeOfService),"Could not select the place of service", selenium, ClassName,MethodName);
		if(userAccount.equals(USAccount)){
		assertTrue(selectValueFromAjaxList(selenium, lstDiagnosis00,chargeEntryData.diagnosisCode),"could not select the diagnosisi code", selenium, ClassName,MethodName);
		}
		
		if(userAccount.equals(CAAccount)){
			assertTrue(selectValueFromAjaxList(selenium, ajxServiceCodeCharge,chargeEntryData.serviceCodeCA),"Could not select the service code", selenium, ClassName,MethodName);
		}else{
			assertTrue(selectValueFromAjaxList(selenium, ajxServiceCodeCharge,chargeEntryData.serviceCode),"Could not select the service code", selenium, ClassName,MethodName);
		}
		assertTrue(type(selenium, txtUnits, chargeEntryData.unitsServiceLine),"Could not enter the units", selenium, ClassName,MethodName);
		assertTrue(type(selenium, txtFee, chargeEntryData.fee),"Could not enter the Fee", selenium, ClassName,MethodName);
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat;
		if (userAccount.equalsIgnoreCase(CAAccount)) {
			DateFormat = new SimpleDateFormat("dd/MM/YYYY");
		} else {
			DateFormat = new SimpleDateFormat("MM/dd/YYYY");
		}
		String date = DateFormat.format(cal.getTime());
		
		chargeEntryData.fromDate = date;
		
		chargeEntryData.toDate = date;
		
		assertTrue(enterDate(selenium,txtFromDate1,chargeEntryData.fromDate ),"Could not enter the From Date", selenium, ClassName, MethodName);
		if(userAccount.equals(USAccount)){
		assertTrue(enterDate(selenium,txtToDate,chargeEntryData.toDate ),"Could not enter the From Date", selenium, ClassName, MethodName);
		}
		
		assertTrue(click(selenium,btnPostChargeEntry),"Could not click the post button", selenium, ClassName,MethodName);
		
		
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName, MethodName);
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}







	/**
	 * function for postChargeForPatientPaymentSetUp
	 * @param selenium
	 * @param billingData
	 * @throws IOException
	 * @since Feb 08,2014
	 */
	public boolean postChargeForPatientPaymentSetUp(Selenium selenium,BillingLib chargeEntryData,String userAccount) throws IOException{
		String date = null;
		assertTrue(selectValueFromAjaxList(selenium, ajxRenderingProvider,chargeEntryData.renderingProvider),"Could not select the rendering provider", selenium, ClassName,MethodName);
		assertTrue(selectValueFromAjaxList(selenium, ajxSpecialtyCE,chargeEntryData.specialty),"Could not select the Specialty", selenium, ClassName,MethodName);
		assertTrue(selectValueFromAjaxList(selenium, ajxBillingProvider,chargeEntryData.billingProvider),"Could not select the billing provider", selenium, ClassName,MethodName);
		assertTrue(selectValueFromAjaxList(selenium, location,chargeEntryData.location),"Could not select the Location", selenium, ClassName,MethodName);
		assertTrue(selectValueFromAjaxList(selenium, placeOfService,chargeEntryData.placeOfService),"Could not select the place of service", selenium, ClassName,MethodName);
		if(userAccount.equals(USAccount)){
		assertTrue(selectValueFromAjaxList(selenium, lstDiagnosis00,chargeEntryData.diagnosisCode),"could not select the diagnosisi code", selenium, ClassName,MethodName);
		}
		if(userAccount.equals(CAAccount)){
			assertTrue(selectValueFromAjaxList(selenium, ajxServiceCodeCharge,chargeEntryData.serviceCodeCA),"Could not select the service code", selenium, ClassName,MethodName);
		}else{
			assertTrue(selectValueFromAjaxList(selenium, ajxServiceCodeCharge,chargeEntryData.serviceCode),"Could not select the service code", selenium, ClassName,MethodName);
		}
		
		assertTrue(type(selenium, txtUnits, chargeEntryData.units),"Could not enter the units", selenium, ClassName,MethodName);
		assertTrue(type(selenium, txtFee, chargeEntryData.fee),"Could not enter the Fee", selenium, ClassName,MethodName);
		
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat;
		if (userAccount.equalsIgnoreCase(CAAccount)) {
			DateFormat = new SimpleDateFormat("dd/MM/YYYY");
		} else {
			DateFormat = new SimpleDateFormat("MM/dd/YYYY");
		}
		date = DateFormat.format(cal.getTime());
		
		chargeEntryData.fromDate = date;
		
		chargeEntryData.toDate = date;
		if(userAccount.equals(USAccount)){
		assertTrue(enterDate(selenium,txtFromDate,chargeEntryData.fromDate ),"Could not enter the From Date", selenium, ClassName, MethodName);
		}else{
			assertTrue(enterDate(selenium,dateSLDateCA,chargeEntryData.fromDate ),"Could not enter the From Date", selenium, ClassName, MethodName);
		}
		if(userAccount.equals(USAccount)){
		assertTrue(enterDate(selenium,txtToDate,chargeEntryData.toDate ),"Could not enter the From Date", selenium, ClassName, MethodName);
		}
		if(!(getValue(selenium,txtFromDate).contains(chargeEntryData.fromDate)) && (getValue(selenium, txtToDate).contains(chargeEntryData.toDate))){
			return false;
		}
		assertTrue(click(selenium,btnPostChargeEntry),"Could not click the post button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,btnNexiaLogo),"Could not click the nexia logo", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
	
		if(!isElementPresent(selenium,lnkPPatientPaymentQueue)){
			return false;
		}
		return true;
	}
	
	/**
	 * gotoSystemSetting
	 * function to gotoSystemSetting
	 * @throws IOException 
	 * @since  	    Feb 11, 2014
	 */	
	
	public boolean gotoSystemSetting(Selenium selenium) throws IOException{
		
		assertTrue(click(selenium,lnkSettings),"Could not click the settings option", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkSystemSetings),"Could not click system setting", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,lnkAdminOrgStructureLists)){
			return true;
		}else
			return false;
		
	}
	

	
	public boolean gotoSystemSettingExternalProviders(Selenium selenium) throws IOException{
			
			assertTrue(click(selenium,lnkSettings),"Could not click the Quick option", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSetings),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);assertTrue(click(selenium,lnkExternalProviders),"Could not click the system setting link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkExternalProviders)){
				return true;
			}else
				return false;
			
		}


	
	/**
	 * function to fill service fee for Update fees
	 * 
	 * @param selenium
	 * @throws IOException
	 * @since Feb 16,2014
	 */
	public boolean updateFillServiceFeeAndDefault(Selenium selenium, BillingLib billingData,
		String userAccount) throws IOException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat;
		if (userAccount.equalsIgnoreCase(CAAccount)) {
			DateFormat = new SimpleDateFormat("dd/MM/YYYY");
		} else {
			DateFormat = new SimpleDateFormat("MM/dd/YYYY");
		}
		billingData.effectiveOnDateCurrent = DateFormat.format(cal.getTime());
		assertTrue(type(selenium, txtFeeAmount, billingData.currentFees),
				"Could not type the fee amount", selenium, ClassName,
				MethodName);
		assertTrue(type(selenium, txtFeeAmount2, billingData.currentFees1),
				"Could not type the fee amount", selenium, ClassName,
				MethodName);
		assertTrue(
				enterDate(selenium, txtEffectiveDateInServiceFee,
						billingData.effectiveOnDateCurrent),
				"Could not type effect", selenium, ClassName, MethodName);
		
		assertTrue(
				enterDate(selenium, "xpath=(//input[@id='effectiveDate'])[2]",
						billingData.effectiveOnDateCurrent),
				"Could not type effect", selenium, ClassName, MethodName);
		
		
		if(selenium.isVisible(txtUnits)){
			assertTrue(type(selenium, txtUnits, billingData.units),
					"Could not type the units", selenium, ClassName, MethodName);
		}
		
		assertTrue(click(selenium, rdoSetServiceDefault),"Could not click the set service default radio button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSaveAndNext),"Could not click the Save and Next button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSaveAndNext),"Could not click the second time Save and Next button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnDoneServiceCode),"Could not click the done button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
	

	
	/**
	 * function to updateFees  in summary page
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 15,2014
	 */
	
	public boolean updateFees(Selenium selenium,BillingLib billingData,String userAccount) throws IOException {

		if(billingData.testCaseId.equalsIgnoreCase("TC_SC_002")|| billingData.testCaseId.equalsIgnoreCase("TC_SC_008")){
			assertTrue(type(selenium, txtIncreaseValue, billingData.amount),"Could not type the increase amount", selenium, ClassName,MethodName);
			assertTrue(selectValueFromAjaxList(selenium, ajxModiferType, "dollars"),"Could not select the increase type modifier", selenium,ClassName, MethodName);
		}else if(billingData.testCaseId.equalsIgnoreCase("TC_SC_001")|| billingData.testCaseId.equalsIgnoreCase("TC_SC_007")){
			assertTrue(type(selenium, txtIncreaseValue, billingData.percentage),"Could not type the increase amount", selenium, ClassName,MethodName);
			assertTrue(selectValueFromAjaxList(selenium, ajxModiferType, "percent"),"Could not select the increase type modifier", selenium,ClassName, MethodName);
		}
		assertTrue(enterDate(selenium,txtEffectiveNewDates,billingData.effectiveOnDateCurrent),"Could not enter the new effective date", selenium,ClassName, MethodName);
		
		assertTrue(click(selenium, clkApply),"Could not click the apply button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, clkOverrideAll),"Could not click the continue and apply to all button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
				
		return true;
	}

	
	
	
	public  String savePostChargeEntryForBalanceCalculation(Selenium selenium,
			BillingLib chargeEntryData, String balance, String userAccount) throws IOException {
		String date = null;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
		if(userAccount.equals(CAAccount)){
			DateFormat = new SimpleDateFormat("dd/MM/yyyy");
		}
		date = DateFormat.format(cal.getTime());
		chargeEntryData.dateOfService1=date;
		chargeEntryData.dateOfService2=date;
		//waitForPageLoad(selenium);

		assertTrue(isElementPresent(selenium, lstRenderingProvider),
				"Rendering Provider textbox not Present", selenium, ClassName,
				MethodName);
		assertTrue(isElementPresent(selenium, lstBillingProvider),
				"Billing Provider textbox not Present", selenium, ClassName,
				MethodName);
		assertTrue(isElementPresent(selenium, location),
				"Location textbox not Present", selenium, ClassName,
				MethodName);
		assertTrue(isElementPresent(selenium, placeOfService),
				"Place of service textbox not Present", selenium, ClassName,
				MethodName);
		if(userAccount.equals(USAccount)){
		assertTrue(isElementPresent(selenium, lstDiagnosis00),
				"Diagnosis Code textbox not Present", selenium, ClassName,
				MethodName);
		}
		
		

		assertTrue(isElementPresent(selenium, serviceCode),
				"Service Code textbox not Present", selenium, ClassName,
				MethodName);
		if(userAccount.equals(USAccount)){
		assertTrue(isElementPresent(selenium, diagnosisCodeSL),
				"Diagnosis Code textbox not Present in Service Line", selenium, ClassName,
				MethodName);
		}else
			assertTrue(isElementPresent(selenium, diagnosisCodeSLCA),
					"Diagnosis Code textbox not Present in Service Line", selenium, ClassName,
					MethodName);
		assertTrue(isElementPresent(selenium, txtFee),
				"Fee textbox not Present", selenium, ClassName,
				MethodName);
		assertTrue(isElementPresent(selenium, btnSaveChargeEntry),
				"Save Button not Present", selenium, ClassName,
				MethodName);

		assertTrue(
				selectValueFromAjaxList(selenium, lstRenderingProvider,
						chargeEntryData.renderingProvider),
				"Not able to add Rendering Provider", selenium, ClassName,
				MethodName);
		assertTrue(
				selectValueFromAjaxList(selenium, location,
						chargeEntryData.location),
				"Not able to add Location", selenium, ClassName,
				MethodName);
		if(userAccount.equals(CAAccount)){
			assertTrue(
					selectValueFromAjaxList(selenium, ajxserviceLevInd,
							chargeEntryData.ServiceLevelIndicator),
					"not able to add service code", selenium, ClassName,
					MethodName);
		}
		if(userAccount.equals(USAccount)){
			assertTrue(
					selectValueFromAjaxList(selenium, placeOfService,
							chargeEntryData.placeOfServiceUS),
					"Not able to add Place of Service", selenium, ClassName,
					MethodName);
			assertTrue(
					selectValueFromAjaxList(selenium, lstBillingProvider,
							chargeEntryData.billingProviderUS),
					"Not able to add Billing provider", selenium, ClassName,
					MethodName);
		}else
		{
		assertTrue(
				selectValueFromAjaxList(selenium, placeOfService,
						chargeEntryData.placeOfService),
				"Not able to add Place of Service", selenium, ClassName,
				MethodName);
		assertTrue(
				selectValueFromAjaxList(selenium, lstBillingProvider,
						chargeEntryData.billingProvider),
				"Not able to add Billing provider", selenium, ClassName,
				MethodName);
		}
		if(userAccount.equals(USAccount)){
		assertTrue(
				selectValueFromAjaxList(selenium, lstDiagnosis00,
						chargeEntryData.diagnosisCode),
				"Not able to add diagonsis code", selenium, ClassName,
				MethodName);
		}
		if(userAccount.equals(USAccount)){
			assertTrue(enterDate(selenium, dateSLEndDate, chargeEntryData.dateOfService2),
					"not able to add end date", selenium, ClassName,
					MethodName);
			assertTrue(enterDate(selenium, dateSLStartDate, chargeEntryData.dateOfService1),
					"not able to add start date", selenium, ClassName,
					MethodName);
			}
			if(userAccount.equals(CAAccount)){
				assertTrue(enterDate(selenium, dateSLDateCA, chargeEntryData.dateOfService1),
						"not able to add end date", selenium, ClassName,
						MethodName);
				
				}

		if(userAccount.equals(CAAccount)){
			assertTrue(
					selectValueFromAjaxList(selenium, serviceCode,
							chargeEntryData.serviceCodeCA),
					"not able to add service code", selenium, ClassName,
					MethodName);
		}else
		assertTrue(
				selectValueFromAjaxList(selenium, serviceCode,
						chargeEntryData.serviceCode),
				"not able to add service code", selenium, ClassName,
				MethodName);
		if(userAccount.equals(USAccount)){
		assertTrue(
				selectValueFromAjaxList(selenium, diagnosisCodeSL,
						chargeEntryData.diagnosisCodeSL),
				"no able to add diagnosis code in service line", selenium, ClassName,
				MethodName);
		}else
		assertTrue(
				selectValueFromAjaxList(selenium, diagnosisCodeSLCA,
						chargeEntryData.diagnosisCodeSL),
				"no able to add diagnosis code in service line", selenium, ClassName,
				MethodName);
		assertTrue(type(selenium, txtUnits, chargeEntryData.units),
				"Not able to add units", selenium, ClassName,
				MethodName);	
		assertTrue(type(selenium, txtFee, chargeEntryData.fee),
				"Not able to add units", selenium, ClassName,
				MethodName);
		assertTrue(
				selectValueFromAjaxList(selenium, ajxBillTo,
						"Patient"),
				"no able to add diagnosis code in service line", selenium, ClassName,
				MethodName);
		
		assertTrue(
				selectValueFromAjaxList(selenium, ajxPaymentProgram,
						"HCP - Health Claims Payment"),
				"no able to add diagnosis code in service line", selenium, ClassName,
				MethodName);
		
		String chargeAmount=getValue(selenium,txtFee);
		
		if (chargeEntryData.testCaseId.equals("TC_CE_013")||chargeEntryData.testCaseId.equals("TC_CE_021")||chargeEntryData.testCaseId.equals("TC_CE_015")) {
			assertTrue(click(selenium, btnSaveChargeEntry),
					"Adjustment Reason textbox not Present", selenium,
					ClassName, MethodName);
		}

		if (chargeEntryData.testCaseId.equals("TC_CE_014")||chargeEntryData.testCaseId.equals("TC_CE_020")||chargeEntryData.testCaseId.equals("TC_CE_016")||chargeEntryData.testCaseId.equals("TC_CE_035")||chargeEntryData.testCaseId.equals("TC_CE_036")||chargeEntryData.testCaseId.equals("TC_CE_037")||chargeEntryData.testCaseId.equals("TC_CE_038")||chargeEntryData.testCaseId.equals("TC_CE_039")) {
			assertTrue(click(selenium, btnPostChargeEntry),
					"Adjustment Reason textbox not Present", selenium,
					ClassName, MethodName);
		}

		waitForPageLoad(selenium);

		return chargeAmount;
	}

	/**
	 * function to search Service Code  in summary page
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 26,2014
	 */
	
	
	public boolean searchServiceCode(Selenium selenium,BillingLib serviceCode ) throws IOException{
		 try{
			    assertTrue(type(selenium,txtSearchInServiceCode,serviceCode.serviceCode1),"Could not enter the service code", selenium, ClassName, MethodName);
			    selenium.keyPress(txtSearchInServiceCode, "\\13");
			    waitForPageLoad(selenium);
			    if(getText(selenium,lblFilterResultInServiceCodeFirst).toLowerCase().contains(serviceCode.serviceCode1.toLowerCase())){
					return true;
				  }else{
					assertTrue(click(selenium,chkIncludeInactive),"Could not click the inactive check box in service cocde page", selenium, ClassName, MethodName);
						if(getText(selenium,lblFilterResultInServiceCodeFirst).toLowerCase().contains(serviceCode.serviceCode1.toLowerCase())){
						    assertTrue(click(selenium,lblFilterResultInServiceCodeFirst),"could not click the search data in the service code page", selenium, ClassName, MethodName);
						    assertTrue(click(selenium,btnActiveServiceCode),"could not Click the active button in service code page", selenium, ClassName, MethodName);
						    return true;
						}
				    }
		    }catch(Exception e){
		    	e.printStackTrace();
		 }
		    
	    return false;
	}
	
	
	/**
	 * function to endToEndServiceCode
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 24,2014
	 */
	
	/**
	 * function to endToEndServiceCode
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 24,2014
	 */
	
	public boolean endToEndServiceCode(Selenium selenium, BillingLib sCodeData, String account) throws IOException{
		try{
			String date = null;
			String pastDate = null;
			assertTrue(click(selenium, lnkCustomTab),"Could not click the custom tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium, txtCustomServiceCode, sCodeData.serviceCode1),"Could not type the custom service code", selenium, ClassName,MethodName);
			assertTrue(type(selenium, txtCustomDescription, sCodeData.serviceDescription1),"Could not type the custom service description", selenium, ClassName,MethodName);
			assertTrue(click(selenium, btnAddServiceCode),"Could not click the add button in the custom service code tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, rdoSetServiceFees),"Could not click the set service fees radio button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(!((sCodeData.testCaseId.equals("TC_SC_019")||sCodeData.testCaseId.equals("TC_SC_020")||sCodeData.testCaseId.equals("TC_SC_021")||sCodeData.testCaseId.equals("TC_SC_022")||
					sCodeData.testCaseId.equals("TC_SC_023")||sCodeData.testCaseId.equals("TC_SC_024")||sCodeData.testCaseId.equals("TC_SC_025")||sCodeData.testCaseId.equals("TC_SC_026")||
					sCodeData.testCaseId.equals("TC_SC_027")||sCodeData.testCaseId.equals("TC_SC_028")||sCodeData.testCaseId.equals("TC_SC_029")))){
				assertTrue(fillServiceFee(selenium, sCodeData, account),"Could not fill the service fees", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium, btnNextWizard),"Could not click the set service default next button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			if(sCodeData.testCaseId.equals("TC_SC_019")||sCodeData.testCaseId.equals("TC_SC_020")||sCodeData.testCaseId.equals("TC_SC_021")||sCodeData.testCaseId.equals("TC_SC_022")||
					sCodeData.testCaseId.equals("TC_SC_023")||sCodeData.testCaseId.equals("TC_SC_024")||sCodeData.testCaseId.equals("TC_SC_025")||sCodeData.testCaseId.equals("TC_SC_026")||
					sCodeData.testCaseId.equals("TC_SC_027")||sCodeData.testCaseId.equals("TC_SC_028")||sCodeData.testCaseId.equals("TC_SC_029")){
				Calendar cal=Calendar.getInstance();
				Calendar cal1=Calendar.getInstance();
				if(account.equals(CAAccount)){
					SimpleDateFormat DateFormat4=new SimpleDateFormat("dd/MM/yyyy");
					if(sCodeData.testCaseId.equals("TC_SC_019")||sCodeData.testCaseId.equals("TC_SC_020")||sCodeData.testCaseId.equals("TC_SC_021")){
						cal.add(Calendar.YEAR,10);
					}
					
					if(sCodeData.testCaseId.equals("TC_SC_022")||sCodeData.testCaseId.equals("TC_SC_023")||sCodeData.testCaseId.equals("TC_SC_024")){
					
						cal.add(Calendar.DATE,-2);
						cal1.add(Calendar.DATE,-1);
						pastDate = DateFormat4.format(cal1.getTime());
						
					}
					date=DateFormat4.format(cal.getTime());
				}else{
					SimpleDateFormat DateFormat3=new SimpleDateFormat("MM/dd/YYYY");
					if(sCodeData.testCaseId.equals("TC_SC_019")||sCodeData.testCaseId.equals("TC_SC_020")||sCodeData.testCaseId.equals("TC_SC_021")){
						cal.add(Calendar.YEAR,10);
					}
					
					if(sCodeData.testCaseId.equals("TC_SC_022")||sCodeData.testCaseId.equals("TC_SC_023")||sCodeData.testCaseId.equals("TC_SC_024")){
						
						cal.add(Calendar.DATE,-2);
						cal1.add(Calendar.DATE,-1);
						pastDate = DateFormat3.format(cal1.getTime());
						
					}
					
					
					date = DateFormat3.format(cal.getTime());
				}	
				
				assertTrue(type(selenium, txtFeeAmount, sCodeData.currentFees),"Could not type the fee amount", selenium, ClassName,MethodName);
				assertTrue(enterDate(selenium, txtEffectiveDateInServiceFee,date),"Could not type effect", selenium, ClassName, MethodName);
				assertTrue(type(selenium, txtUnits, sCodeData.units),"Could not type the units", selenium, ClassName, MethodName);
				
				assertTrue(click(selenium, btnNextWizard),"Could not click the set service default next button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				
				
				assertTrue(enterDate(selenium, txtCodeStartDate, date),"Could not type Effective date", selenium, ClassName,MethodName);
				
				if(sCodeData.testCaseId.equals("TC_SC_022")||sCodeData.testCaseId.equals("TC_SC_023")||sCodeData.testCaseId.equals("TC_SC_024")){
					assertTrue(enterDate(selenium, txtCodeEndDate, pastDate),"Could not type Effective date", selenium, ClassName,MethodName);
				}
				
				if(sCodeData.testCaseId.equals("TC_SC_025")||sCodeData.testCaseId.equals("TC_SC_026")||sCodeData.testCaseId.equals("TC_SC_027")||sCodeData.testCaseId.equals("TC_SC_028")
						||sCodeData.testCaseId.equals("TC_SC_029")){
					
					selectValueFromAjaxList(selenium,ajxServiceCodeModifier,sCodeData.serviceCodeModifier);
				}
			
			}
			
			
			if(!isChecked(selenium,chkMultiplyFee)){
				assertTrue(click(selenium, chkMultiplyFee),"Could not click the multiply fee check box", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(click(selenium, btnDoneServiceCode),"Could not click the done button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * function to createEndToEndServiceCode
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 24,2014
	 */
	
	public boolean createEndToEndServiceCode(Selenium selenium,BillingLib serviceCode, String account) throws IOException{
	  try{
		boolean verifyServiceCode = false;
		
		if(!searchServiceCode(selenium, serviceCode)){
			assertTrue(click(selenium, btnManageServiceCodes),"Could not click the add button in serive code page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			// --------------------------------------------------------------------//
			// Step-4:Create Adjustment with Creadit Option                        //
			// --------------------------------------------------------------------//
			assertTrue(endToEndServiceCode(selenium, serviceCode,account),"Could not create the adjutment Reason", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			verifyServiceCode = true;
			
		}else{
			if(!verifyServiceCodeInSummaryPage(selenium,serviceCode)){
				waitForPageLoad(selenium);
				
				assertTrue(endToEndEditServiceCode(selenium, serviceCode,account),"Could not create the adjutment Reason", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				verifyServiceCode = true;
			}
		}
		
		//Verify Store Value
		if(verifyServiceCode){
			if(!verifyServiceCodeInSummaryPage(selenium,serviceCode)){
				Assert.fail("Adjustment Details are not stored Properly");
			}
				
		}
		return true;
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	  return false;
	}
	
	/**
	 * function to endToEndEditServiceCode
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 20,2014
	 */
	public boolean endToEndEditServiceCode(Selenium selenium,BillingLib serviceCode, String account) {
		try{
			
			assertTrue(type(selenium,txtCurrentFee,serviceCode.currentFees),"Could not enter the current fee", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveServiceCode),"Could not click the service code",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	
	
	/**
	 * function to verify service Code in summary page
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 24,2014
	 */
	
	public boolean verifyServiceCodeInSummaryPage(Selenium selenium,BillingLib serviceCode) throws IOException{
		try{
			assertTrue(type(selenium,txtSearchInServiceCode,serviceCode.serviceCode1),"Could not enter the service code", selenium, ClassName, MethodName);
		    selenium.keyPress(txtSearchInServiceCode, "\\13");
		    waitForPageLoad(selenium);
			if(!getText(selenium,lblFilterResultInServiceCodeFirst ).contains(serviceCode.serviceCode1)){
				return false;
			}
			
			assertTrue(click(selenium,lblFilterResultInServiceCodeFirst ),"Could not Edit button in Service Code Page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnEditServiceCode ),"Could not Edit button in Service Code Page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(!getValue(selenium,txtServiceCode ).contains(serviceCode.serviceCode1)){
				return false;
			}
			if(serviceCode.testCaseId.equals("TC_SC_019")||serviceCode.testCaseId.equals("TC_SC_020")||serviceCode.testCaseId.equals("TC_SC_021")){
				if(!getValue(selenium,"newFee" ).contains(serviceCode.currentFees)){
					return false;
				}
			}else{
				if(!getValue(selenium,txtCurrentFee ).contains(serviceCode.currentFees)){
					return false;
				}
			}
			assertTrue(click(selenium,btnSaveServiceCode),"Could not click the service code",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	/**
	 * function to search Adjustment Reason  in summary page
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 24,2014
	 */
	public boolean searchAdjustmentReason(Selenium selenium,BillingLib adjustmentData) throws IOException{
		try{
			assertTrue(type(selenium,ajxSearchAdjustmentReason,adjustmentData.adjusmentReason),"Could not type the template Name", selenium, ClassName, MethodName);
			selenium.keyPress(ajxSearchAdjustmentReason, "\\13");
			waitForPageLoad(selenium);
			System.out.println(getText(selenium,summaryAdjustmentReasons).toLowerCase());
			System.out.println(adjustmentData.adjusmentReason.toLowerCase());
			System.out.println(adjustmentData.reportCategory.toLowerCase());
			System.out.println(adjustmentData.c_DAdjusment.toLowerCase());
			
			if(selenium.isTextPresent("No adjustment reasons added"))
			{
				
			System.out.println("No Search Results, Please create a New Adjustment Code");	
				return false;				
			}
			
			if((getText(selenium,summaryAdjustmentReasons).toLowerCase().contains(adjustmentData.adjusmentReason.toLowerCase())&&(getText(selenium,summaryAdjustmentReasons).toLowerCase().contains(adjustmentData.c_DAdjusment.toLowerCase())
					&& getText(selenium,summaryAdjustmentReasons).toLowerCase().contains(adjustmentData.reportCategory.toLowerCase())))){
				return true;
			}else{
				assertTrue(click(selenium,chkInactiveAdjustmentReason),"could not click the Inactive Check box", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if((getText(selenium,summaryAdjustmentReasons).toLowerCase().contains(adjustmentData.adjusmentReason.toLowerCase())&&(getText(selenium,summaryAdjustmentReasons).toLowerCase().contains(adjustmentData.c_DAdjusment.toLowerCase())
						&& getText(selenium,summaryAdjustmentReasons).toLowerCase().contains(adjustmentData.reportCategory.toLowerCase())))){
					assertTrue(click(selenium,btnAdjActive),"could not click the Active button in adjusment reason page", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					return true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * function to createEndToEndAjustmentReason summary page
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 24,2014
	 */
	
	public boolean createEndToEndAjustmentReason(Selenium selenium,BillingLib adjustmentCodeData) throws IOException{
		
		
		boolean verifyAdreason = false;
		
		if(!searchAdjustmentReason(selenium, adjustmentCodeData)){
			assertTrue(click(selenium, lnkAdjustmentCodes),"Not able to click Add New", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			// --------------------------------------------------------------------//
			// Step-4:Create Adjustment                       //
			// --------------------------------------------------------------------//
			
			if (isElementPresent(selenium, btnAdd)) {
				assertTrue(click(selenium, btnAdd),
						"Not able to click Add New", selenium, ClassName,
						MethodName);
			}
			
			assertTrue(addAdjustmentReasons(selenium, adjustmentCodeData),"Could not create the adjutment Reason", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			verifyAdreason = true;
			
		}else{
			if(!verifyAdjustmentReasonsEditPage(selenium,adjustmentCodeData)){
				waitForPageLoad(selenium);
				
				assertTrue(addAdjustmentReasons(selenium, adjustmentCodeData),"Could not create the adjutment Reason", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				verifyAdreason = true;
			}
		}
		
		//Verify Store Value
		if(verifyAdreason){
			if(!verifyAdjustmentReasonsEditPage(selenium,adjustmentCodeData)){
				Assert.fail("Adjustment Details are not stored Properly");
			}
				
		}
		return true;
	}
	
	/**
	 * function to searchSuperBillTemplate summary page
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 26,2014
	 */
	
	public boolean searchSuperBillTemplate(Selenium selenium,BillingLib sBTData) throws IOException{
		try{
			assertTrue(type(selenium,ajxSearch,sBTData.templateName),"Could not type the template Name", selenium, ClassName, MethodName);
			selenium.keyPress(ajxSearch, "\\13");
			waitForPageLoad(selenium);
			System.out.println(getText(selenium,lblSummerySuperBill).toLowerCase());
			System.out.println(sBTData.templateName.toLowerCase());
			if(getText(selenium,lblSummerySuperBill).toLowerCase().contains(sBTData.templateName.toLowerCase())){
				return true;
			}else{
				if(getText(selenium,lblSummerySuperBill).toLowerCase().contains(sBTData.templateName.toLowerCase())){
				assertTrue(click(selenium,chkInactiveSuperBill),"Could not check the inactive Super Bill check box",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,lnkSBIActivate),"Could not click  the Activate Button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnYes),"Could not click the yes button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				return true;
				}
			}
		}catch(Exception e){
					e.printStackTrace();
				}
		return false;
	}
	
	/**
	 * function to endToEndSuperBillSetUp
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 26,2014
	 */
	
	
	public boolean endToEndSuperBillSetUp(Selenium selenium,BillingLib sBTData) throws IOException{
		try{
			int sCodeCount;
			int sCodePossition = 1;
			 String[] sCode = null;
			//Create Super Bill
			assertTrue(type(selenium, txtTempletaName, sBTData.templateName), "Could not type the template Name",selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, ajxSpecialty,sBTData.specialty),"Could not select the specialty ", selenium, ClassName,MethodName);
	
			assertTrue(click(selenium, btnSBINext),"Could not click the next button", selenium, ClassName,MethodName);
			
			BillingLib sCodeData = new BillingLib();
			sCodeData.workSheetName = "ServiceCodes";
			if(sBTData.testCaseId.equals("TC_SBS_013")){
				//service code
				sCode =new String[]{"TC_SC_009","TC_SC_010","TC_SC_011","TC_SC_012","TC_SC_013","TC_SC_014"};
				
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					assertTrue(type(selenium, "sectionLabel"+sCodeCount+"", sBTData.sectionLabel),"Could not type the section label", selenium, ClassName,MethodName);
					assertTrue(selectValueFromAjaxList(selenium, "xpath=(//input[@id='serviceCodeSBsuggestBox'])["+sCodePossition+"]",sCodeData.serviceCode1),"Could not select service code", selenium, ClassName,MethodName);
					
					if(sCodePossition!=sCode.length){
						assertTrue(click(selenium, btnSCAddNew),"Could not click the Add New button", selenium,ClassName, MethodName);
					}
					sCodePossition++;
				}
			}
			
			if(sBTData.testCaseId.equals("TC_SBS_014")){
				sCode =new String[]{"TC_SC_019","TC_SC_020","TC_SC_021"};
				//suprr
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					assertTrue(type(selenium, "sectionLabel"+sCodeCount+"", sBTData.sectionLabel),"Could not type the section label", selenium, ClassName,MethodName);
					assertTrue(selectValueFromAjaxList(selenium, "xpath=(//input[@id='serviceCodeSBsuggestBox'])["+sCodePossition+"]",sCodeData.serviceCode1),"Could not select service code", selenium, ClassName,MethodName);
					
					if(sCodePossition!=sCode.length){
						assertTrue(click(selenium, btnSCAddNew),"Could not click the Add New button", selenium,ClassName, MethodName);
					}
					sCodePossition++;
				}
				
			}
			
			if(sBTData.testCaseId.equals("TC_SBS_015")){
				sCode =new String[]{"TC_SC_022","TC_SC_023","TC_SC_024"};
				//suprr
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					assertTrue(type(selenium, "sectionLabel"+sCodeCount+"", sBTData.sectionLabel),"Could not type the section label", selenium, ClassName,MethodName);
					assertTrue(selectValueFromAjaxList(selenium, "xpath=(//input[@id='serviceCodeSBsuggestBox'])["+sCodePossition+"]",sCodeData.serviceCode1),"Could not select service code", selenium, ClassName,MethodName);
					
					if(sCodePossition!=sCode.length){
						assertTrue(click(selenium, btnSCAddNew),"Could not click the Add New button", selenium,ClassName, MethodName);
					}
					sCodePossition++;
				}
				
			}
			
			if(sBTData.testCaseId.equals("TC_SBS_016")){
				sCode =new String[]{"TC_SC_025","TC_SC_026"};
				//suprr
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					assertTrue(type(selenium, "sectionLabel"+sCodeCount+"", sBTData.sectionLabel),"Could not type the section label", selenium, ClassName,MethodName);
					assertTrue(selectValueFromAjaxList(selenium, "xpath=(//input[@id='serviceCodeSBsuggestBox'])["+sCodePossition+"]",sCodeData.serviceCode1),"Could not select service code", selenium, ClassName,MethodName);
					
					if(sCodePossition!=sCode.length){
						assertTrue(click(selenium, btnSCAddNew),"Could not click the Add New button", selenium,ClassName, MethodName);
					}
					sCodePossition++;
				}
			}
			if(sBTData.testCaseId.equals("TC_SBS_017")){
				sCode =new String[]{"TC_SC_027","TC_SC_028","TC_SC_029"};
				
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					assertTrue(type(selenium, "sectionLabel"+sCodeCount+"", sBTData.sectionLabel),"Could not type the section label", selenium, ClassName,MethodName);
					assertTrue(selectValueFromAjaxList(selenium, "xpath=(//input[@id='serviceCodeSBsuggestBox'])["+sCodePossition+"]",sCodeData.serviceCode1),"Could not select service code", selenium, ClassName,MethodName);
					
					if(sCodePossition!=sCode.length){
						assertTrue(click(selenium, btnSCAddNew),"Could not click the Add New button", selenium,ClassName, MethodName);
					}
					sCodePossition++;
				}
			}
			
			if(sBTData.testCaseId.equals("TC_SBS_018")){
				sCode =new String[]{"TC_SC_019","TC_SC_022","TC_SC_025"};
				
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					assertTrue(type(selenium, "sectionLabel"+sCodeCount+"", sBTData.sectionLabel),"Could not type the section label", selenium, ClassName,MethodName);
					assertTrue(selectValueFromAjaxList(selenium, "xpath=(//input[@id='serviceCodeSBsuggestBox'])["+sCodePossition+"]",sCodeData.serviceCode1),"Could not select service code", selenium, ClassName,MethodName);
					
					if(sCodePossition!=sCode.length){
						assertTrue(click(selenium, btnSCAddNew),"Could not click the Add New button", selenium,ClassName, MethodName);
					}
					sCodePossition++;
				}
			}
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSBINext),"Could not click the Next button in super bill template page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSBIDone),"Could not click the Done button in super bill template page", selenium, ClassName,MethodName);
			
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	public boolean endToEndEditSuperBillSetUp(Selenium selenium,BillingLib sBTData) throws IOException{
		try{
			int sCodeCount;
			int sCodePossition = 1;
			 String[] sCode = null;
			//Create Super Bill
			assertTrue(type(selenium, txtTempletaName, sBTData.templateName), "Could not type the template Name",selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, ajxSpecialty,sBTData.specialty),"Could not select the specialty ", selenium, ClassName,MethodName);
	
			assertTrue(click(selenium, btnSBINext),"Could not click the next button", selenium, ClassName,MethodName);
			
			BillingLib sCodeData = new BillingLib();
			sCodeData.workSheetName = "ServiceCodes";
			if(sBTData.testCaseId.equals("TC_SBS_013")){
				//service code
				sCode =new String[]{"TC_SC_009","TC_SC_010","TC_SC_011","TC_SC_012","TC_SC_013","TC_SC_014"};
				
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					if(!isElementPresent(selenium,"sectionLabel"+sCodeCount)){
						assertTrue(click(selenium, btnSCAddNew),"Could not click the Add New button", selenium,ClassName, MethodName);
					}
					
					assertTrue(type(selenium, "sectionLabel"+sCodeCount+"", sBTData.sectionLabel),"Could not type the section label", selenium, ClassName,MethodName);
					assertTrue(selectValueFromAjaxList(selenium, "xpath=(//input[@id='serviceCodeSBsuggestBox'])["+sCodePossition+"]",sCodeData.serviceCode1),"Could not select service code", selenium, ClassName,MethodName);
					
					
					sCodePossition++;
				}
			}
			
			if(sBTData.testCaseId.equals("TC_SBS_014")){
				sCode =new String[]{"TC_SC_019","TC_SC_020","TC_SC_021"};
				//suprr
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					if(!isElementPresent(selenium,"sectionLabel"+sCodeCount)){
						assertTrue(click(selenium, btnSCAddNew),"Could not click the Add New button", selenium,ClassName, MethodName);
					}
					assertTrue(type(selenium, "sectionLabel"+sCodeCount+"", sBTData.sectionLabel),"Could not type the section label", selenium, ClassName,MethodName);
					assertTrue(selectValueFromAjaxList(selenium, "xpath=(//input[@id='serviceCodeSBsuggestBox'])["+sCodePossition+"]",sCodeData.serviceCode1),"Could not select service code", selenium, ClassName,MethodName);
					
					
					
					sCodePossition++;
				}
				
			}
			
			if(sBTData.testCaseId.equals("TC_SBS_015")){
				sCode =new String[]{"TC_SC_022","TC_SC_023","TC_SC_024"};
				//suprr
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					if(!isElementPresent(selenium,"sectionLabel"+sCodeCount)){
						assertTrue(click(selenium, btnSCAddNew),"Could not click the Add New button", selenium,ClassName, MethodName);
					}
					assertTrue(type(selenium, "sectionLabel"+sCodeCount+"", sBTData.sectionLabel),"Could not type the section label", selenium, ClassName,MethodName);
					assertTrue(selectValueFromAjaxList(selenium, "xpath=(//input[@id='serviceCodeSBsuggestBox'])["+sCodePossition+"]",sCodeData.serviceCode1),"Could not select service code", selenium, ClassName,MethodName);
					
					
					sCodePossition++;
				}
				
			}
			
			if(sBTData.testCaseId.equals("TC_SBS_016")){
				sCode =new String[]{"TC_SC_025","TC_SC_026"};
				//suprr
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					if(!isElementPresent(selenium,"sectionLabel"+sCodeCount)){
						assertTrue(click(selenium, btnSCAddNew),"Could not click the Add New button", selenium,ClassName, MethodName);
					}
					
					assertTrue(type(selenium, "sectionLabel"+sCodeCount+"", sBTData.sectionLabel),"Could not type the section label", selenium, ClassName,MethodName);
					assertTrue(selectValueFromAjaxList(selenium, "xpath=(//input[@id='serviceCodeSBsuggestBox'])["+sCodePossition+"]",sCodeData.serviceCode1),"Could not select service code", selenium, ClassName,MethodName);
					
					
					sCodePossition++;
				}
			}
			if(sBTData.testCaseId.equals("TC_SBS_017")){
				sCode =new String[]{"TC_SC_027","TC_SC_028","TC_SC_029"};
				
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					if(!isElementPresent(selenium,"sectionLabel"+sCodeCount)){
						assertTrue(click(selenium, btnSCAddNew),"Could not click the Add New button", selenium,ClassName, MethodName);
					}
					
					assertTrue(type(selenium, "sectionLabel"+sCodeCount+"", sBTData.sectionLabel),"Could not type the section label", selenium, ClassName,MethodName);
					assertTrue(selectValueFromAjaxList(selenium, "xpath=(//input[@id='serviceCodeSBsuggestBox'])["+sCodePossition+"]",sCodeData.serviceCode1),"Could not select service code", selenium, ClassName,MethodName);
					
					
					sCodePossition++;
				}
			}
			
			if(sBTData.testCaseId.equals("TC_SBS_018")){
				sCode =new String[]{"TC_SC_019","TC_SC_022","TC_SC_025"};
				
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					if(!isElementPresent(selenium,"sectionLabel"+sCodeCount)){
						assertTrue(click(selenium, btnSCAddNew),"Could not click the Add New button", selenium,ClassName, MethodName);
					}
					
					assertTrue(type(selenium, "sectionLabel"+sCodeCount+"", sBTData.sectionLabel),"Could not type the section label", selenium, ClassName,MethodName);
					assertTrue(selectValueFromAjaxList(selenium, "xpath=(//input[@id='serviceCodeSBsuggestBox'])["+sCodePossition+"]",sCodeData.serviceCode1),"Could not select service code", selenium, ClassName,MethodName);
					
				
					sCodePossition++;
				}
			}
			assertTrue(click(selenium, btnSBINext),"Could not click the next button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSBIDone),"Could not click the Done button in super bill template page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	/**
	 * function to verifySuperBillSetUpData
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 26,2014
	 */
	
	public boolean verifySuperBillSetUpData(Selenium selenium,BillingLib sBTData) throws IOException{
		try{
			

			assertTrue(selenium.isTextPresent(sBTData.templateName), "" + "Template Name Not Present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			
			
			assertTrue(click(selenium,lnkEditSuperBill),"Could not click the Edit button in Super bill set up page",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.getValue(txtTempletaName).contains(sBTData.templateName), "" + "Template Name Not Present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,chkSBTServiceCode),"Could not click the blue circle",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			/*//String sCode[] ={"TC_SC_009","TC_SC_010","TC_SC_011","TC_SC_012","TC_SC_013","TC_SC_014"};
			String sCode[] = {"TC_SC_019","TC_SC_020","TC_SC_021"};
			//String sCode[] ={"TC_SC_009","TC_SC_010","TC_SC_011","TC_SC_012","TC_SC_013","TC_SC_014"};
*/			
			int sCodeCount;			
			int sCodePossition = 1;
			String[] sCode = null;
			
			BillingLib sCodeData = new BillingLib();
			sCodeData.workSheetName = "ServiceCodes";
			
			
			if(sBTData.testCaseId.equals("TC_SBS_013")){
				//service code
				sCode =new String[]{"TC_SC_009","TC_SC_010","TC_SC_011","TC_SC_012","TC_SC_013","TC_SC_014"};
				
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					if(!getValue(selenium,"xpath=(//input[@id='serviceCodeSBsuggestBox'])["+sCodePossition+"]").contains(sCodeData.serviceCode1)){
						return false;
					}					
					sCodePossition++;
				}				
			}
			
			if(sBTData.testCaseId.equals("TC_SBS_014")){
				sCode =new String[]{"TC_SC_019","TC_SC_020","TC_SC_021"};
				//suprr
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					if(!getValue(selenium,"xpath=(//input[@id='serviceCodeSBsuggestBox'])["+sCodePossition+"]").contains(sCodeData.serviceCode1)){
						return false;
					}					
					sCodePossition++;
				}				
			}
			
			if(sBTData.testCaseId.equals("TC_SBS_015")){
				sCode =new String[]{"TC_SC_022","TC_SC_023","TC_SC_024"};
				//suprr
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					if(!getValue(selenium,"xpath=(//input[@id='serviceCodeSBsuggestBox'])["+sCodePossition+"]").contains(sCodeData.serviceCode1)){
						return false;
					}					
					sCodePossition++;
				}				
			}
			
			if(sBTData.testCaseId.equals("TC_SBS_016")){
				sCode =new String[]{"TC_SC_025","TC_SC_026"};
				//suprr
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					if(!getValue(selenium,"xpath=(//input[@id='serviceCodeSBsuggestBox'])["+sCodePossition+"]").contains(sCodeData.serviceCode1)){
						return false;
					}					
					sCodePossition++;
				}				
			}
			
			if(sBTData.testCaseId.equals("TC_SBS_017")){
				sCode =new String[]{"TC_SC_027","TC_SC_028","TC_SC_029"};
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					if(!getValue(selenium,"xpath=(//input[@id='serviceCodeSBsuggestBox'])["+sCodePossition+"]").contains(sCodeData.serviceCode1)){
						return false;
					}
					
					sCodePossition++;
				}				
			}
			
			if(sBTData.testCaseId.equals("TC_SBS_018")){
				sCode =new String[]{"TC_SC_019","TC_SC_022","TC_SC_025"};
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					if(!getValue(selenium,"xpath=(//input[@id='serviceCodeSBsuggestBox'])["+sCodePossition+"]").contains(sCodeData.serviceCode1)){
						return false;
					}
					
					sCodePossition++;
				}				
			}		
			
		return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	
	/**
	 * function to createEndToEndAjustmentReason summary page
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 24,2014
	 */
	
public boolean createEndToEndSuperBillSetUp(Selenium selenium,BillingLib sBTData) throws IOException{
		
		
		boolean verifySBT = false;
		
		if(!searchSuperBillTemplate(selenium, sBTData)){
			assertTrue(click(selenium, lnkSBIAddNew),"Not able to click Add New in Super Bill Template Page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			// --------------------------------------------------------------------//
			// Step-4:Create Adjustment                       //
			// --------------------------------------------------------------------//
			assertTrue(endToEndSuperBillSetUp(selenium, sBTData),"Could not create the adjutment Reason", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			verifySBT = true;
			
		}else{
			if(!verifySuperBillSetUpData(selenium,sBTData)){
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,lnkSuperBillSetUp),"Could not click the Super bill Set up link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//assertTrue(click(selenium, chkSBTInformation),"Not able to click Super Bill Information blue circle", selenium, ClassName,MethodName);
				//waitForPageLoad(selenium);
												
				assertTrue(click(selenium, lnkEdit),"Could not click the next button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(endToEndEditSuperBillSetUp(selenium, sBTData),"Could not create the adjutment Reason", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				verifySBT = true;
			}
		}
		
		//Verify Store Value
		if(verifySBT){
			if(!verifySuperBillSetUpData(selenium,sBTData)){
				Assert.fail("Adjustment Details are not stored Properly");
			}
				
		}
		return true;
	}	
	
	/**
	 * function to navigate to view Chart page
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 27,2014
	 */
	
	public boolean navigateToViewChart(Selenium selenium,BillingLib billerData,AbstractChartPreVisit chartVisit) throws IOException{
		
		assertTrue(navigateToPatient(selenium, billerData),"Could not search the patient",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkViewChart),"Could not click the view chart link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(!isElementPresent(selenium,chartVisit.btnBeginEncounter)){
			Assert.fail("View Chart page is not getting displayed");
		}
		
		return true;
	}
	
	/**
	 * function to endToEndCompleteSuperBill
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 27,2014
	 */
	
	public boolean endToEndCompleteSuperBill(Selenium selenium,BillingLib entryData,HomeLib payerData,String account) throws IOException{
		try{
			selectValueFromAjaxList(selenium, ajxCodingSystem,entryData.templateName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			
			if(entryData.testCaseId.equals("TC_SBE_009")|| entryData.testCaseId.equals("TC_SBE_010")){
				assertTrue(click(selenium,entryData.serviceCode+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
				assertTrue(click(selenium,entryData.serviceCode2+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
				assertTrue(click(selenium,entryData.serviceCode3+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
			}if(entryData.testCaseId.equals("TC_SBE_011")){
				assertTrue(click(selenium,entryData.serviceCode+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
				assertTrue(click(selenium,entryData.serviceCode2+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
			}
			if(entryData.testCaseId.equals("TC_SBE_006")){
				assertTrue(click(selenium,entryData.serviceCode+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
				assertTrue(click(selenium,entryData.serviceCode2+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
				assertTrue(click(selenium,entryData.serviceCode3+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
				assertTrue(click(selenium,entryData.serviceCode4+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
				assertTrue(click(selenium,entryData.serviceCode5+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
				assertTrue(click(selenium,entryData.serviceCode6+"_checkboxcheckbox"),"Could not click the service code",selenium, ClassName, MethodName);
				assertTrue(verifyCompleteSuperBillData(selenium,entryData),"Unit and fee details are not displayed properly",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			
	
			selectValueFromAjaxList(selenium,ajxBillTo,payerData.payerName);
			waitForPageLoad(selenium);
			
			if(!isChecked(selenium,chkCSBHardCopy)){
				return false;
			}
			
			if(entryData.testCaseId.equals("TC_SBE_009")|| entryData.testCaseId.equals("TC_SBE_010")){
				assertTrue(click(selenium, btnSave), "Could not click the Save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(entryData.testCaseId.equals("TC_SBE_009")){
					if(!selenium.isTextPresent("Service code ETS001 is not valid for current date of service"))
					return false;
				}
				
				if(entryData.testCaseId.equals("TC_SBE_010")){
					if(!selenium.isTextPresent("Service code ETE004 is not valid for current date of service"))
					return false;
				}
				
				return true;
			}
			assertTrue(completeSuperBill(selenium,entryData,account),"Complete Super Bill Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * function to verifyCompleteSuperBillData
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 27,2014
	 */
	public boolean verifyCompleteSuperBillData(Selenium selenium,BillingLib seriveCode ){
		try{	
			String sCode[] =null;
			if(seriveCode.testCaseId.equals("TC_SBE_006")){
				 sCode =new String[]{"TC_SC_009","TC_SC_010","TC_SC_011","TC_SC_012","TC_SC_013","TC_SC_014"};
			}
			/*if(seriveCode.testCaseId.equals("TC_SBE_009")){
				 sCode =new String[]{"TC_SC_019","TC_SC_020","TC_SC_021"};
			}*/
			/*if(seriveCode.testCaseId.equals("TC_SBE_010")){
				 sCode =new String[]{"TC_SC_022","TC_SC_023","TC_SC_024"};
			}*/
			
			if(seriveCode.testCaseId.equals("TC_SBE_011")){
				 sCode =new String[]{"TC_SC_025","TC_SC_026"};
			}
			
			int sCodeCount;
			int sCodePossition = 1;
			if(!seriveCode.testCaseId.equals("TC_SBE_009")||seriveCode.testCaseId.equals("TC_SBE_010")){
				for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
					BillingLib sCodeData = new BillingLib();
					sCodeData.workSheetName = "ServiceCodes";
					sCodeData.testCaseId = sCode[sCodeCount];
					sCodeData.fetchBillingTestData();
					
					if(!((getValue(selenium,"xpath=(//input[@id='units'])["+sCodePossition+"]").contains(sCodeData.units))
							&&(getValue(selenium,"xpath=(//input[@id='fee'])["+sCodePossition+"]").contains(sCodeData.currentFees)))){
						return false;
					}
					sCodePossition++;
				}
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
			return true;
		}
	
	/**
	 * function to verifyCompleteSuperBillData
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 27,2014
	 */
	
	public boolean verifySuperBillDetailsInSuperBillQueue(Selenium selenium,BillingLib billData) throws IOException{
		try{
			assertTrue(type(selenium,txtSearch,billData.location),"Could not type the provider", selenium, ClassName, MethodName);
			selenium.keyPress(txtSearch, "\\13");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			int count;
			int claimsCount = (Integer) selenium.getXpathCount(lblClaimCount);
			
			
			for(count =1; count <=claimsCount;count++ ){
				System.out.println(getText(selenium, "xpath=("+lblClaimCount+"/div)["+count+"]"));
				System.out.println(getText(selenium, "xpath=("+lblClaimCount+"/div)["+count+"]").toLowerCase());
				System.out.println(billData.location.toLowerCase());
				if(((getText(selenium, "xpath=("+lblClaimCount+"/div)["+count+"]").contains(billData.patientID))
						&&(getText(selenium, "xpath=("+lblClaimCount+"/div)["+count+"]").toLowerCase().contains(billData.location.toLowerCase())))){
					
					if(!getText(selenium,"xpath=("+lblClaimCount+"/div)["+count+"]").contains(billData.rprovider)){
						return false;
					}
					
					if(!getText(selenium,"xpath=("+lblClaimCount+"/div)["+count+"]").toLowerCase().contains(billData.patientID.toLowerCase())){
						return false;
					}
					
					if(!getText(selenium,"xpath=("+lblClaimCount+"/div)["+count+"]").toLowerCase().contains(billData.location.toLowerCase())){
						return false;
					}
					
					selenium.clickAt("xpath=("+lblClaimCount+"/div)["+count+"]","");
					//assertTrue(click(selenium,"//div[4]/div/div/div["+count+"]/div"),"Could not click the data", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					return true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * function to verifyChargeEntryNote
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 28,2014
	 */
	
	public boolean verifyChargeEntryNote(Selenium selenium,ChartPreVisitLib encounterData ) throws IOException{
		
		assertTrue(click(selenium,lnkEncounterNote),"Could not click the Encounter Note", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		if(!selenium.isTextPresent(encounterData.medicalCondition1)){
			return false;
		}
		assertTrue(click(selenium,"css=a.close-popup-x.close-help-about-popup"),"Could not click the Encounter Note", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	
	/**
	 * function to navigateToPostPaymentOption
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 28,2014
	 */
	
	public boolean navigateToPostPaymentOption(Selenium selenium) throws IOException{
		
		assertTrue(click(selenium,lnkPatientOption),"Could not click the Patient Option link", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,lnkPostPayerPayment),"Could not click Post Payer payment option in Patient action under", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		if(!selenium.isTextPresent("Insurance")){
			Assert.fail("Insurance Text is not present in post payer payment");
		}
		
		return true;
	}
	
	
	/**
	 * function to endToEndPayerPayment
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 28,2014
	 */
	
	public boolean endToEndPayerPayment(Selenium selenium,BillingLib billData, HomeLib payerData, String account) throws IOException{
		try{
			float checkamount;
			float paidamount;
			float claimpaidamount;
			String claimsPaidAmount;
			
			int cAdjreason;
			String cAdjusmentValue ="";
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (account.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			String date = DateFormat.format(cal.getTime());
			
			selectValueFromAjaxList(selenium,ajxInsurance, billData.insurance);
			assertTrue(type(selenium, txtCheckAmount,billData.checkAmount),"Could not enter the check amount in payer payment page" , selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtCheck,billData.checkNumber),"Could not enter the check Number in payer payment page", selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium, txtdepositDate,date),"Could not enter the deposit Date in payer payment page", selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtTotalPaidAmount,billData.checkAmount),"Could not enter the Paid amount in payer payment page", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,adjustmentReason,"End Credit");
			
			waitForPageLoad(selenium);
			//search Patient
			assertTrue(type(selenium, txtClaimPatientSearch, billData.patientName),"Could not type patient id", selenium, ClassName, MethodName);
			
			selenium.keyPress(txtClaimPatientSearch, "\\13");
			waitForElement(selenium,lblPatientResult,10000);
			
	 		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+billData.patientName, selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(billData.patientName.trim().toLowerCase(new java.util.Locale("en","US"))),"could not get patient name", selenium, ClassName, MethodName);
			click(selenium,lblPatientResult);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			int ajxCAdjcount =(Integer) selenium.getXpathCount("//input[@id='contractualAdjustment']"); 
			for(cAdjreason = 1;cAdjreason <= ajxCAdjcount;cAdjreason++){
				assertTrue(type(selenium,"xpath=(//input[@id='contractualAdjustment'])["+cAdjreason+"]",cAdjusmentValue),"Could not clear value",selenium, ClassName, MethodName);
			}
			
			
			assertTrue(type(selenium,txpaidAmount,"100"),"Could not enter the paid amount in claims", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//Calculation 
			String paidAmount = getValue(selenium, txpaidAmount);
			System.out.println(paidAmount);
			paidamount = Float.parseFloat(paidAmount);
			System.out.println(paidamount);
			checkamount = Float.parseFloat(billData.checkAmount);
			System.out.println(checkamount);
			claimpaidamount = checkamount - paidamount;
			System.out.println(claimpaidamount);
			claimsPaidAmount = String.valueOf(claimpaidamount);
			
			assertTrue(type(selenium,txPaidAmount1,claimsPaidAmount),"Could not enter the paid amount in 2 service code", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click (selenium,btnPost),"Could not enter the post button in Batch Payment entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click (selenium,btnPostYes),"Could not enter the yes button in Batch Payment entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * function to navigateToBillingHXCharge
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 28,2014
	 */
	
	public boolean navigateToBillingHXCharge(Selenium selenium,BillingLib billData) throws IOException{
		assertTrue(navigateToPatient(selenium, billData),"Could not search the patient",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click (selenium,lnkBillingHistory),"Could not click the Billing History link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(!isElementPresent(selenium,lnkChargeHistory )){
			return false;
		}
		return true;
	}
	
	/**
	 * function to verfyChargeDetailsInChargePage
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 28,2014
	 */
	
	public boolean verfyChargeDetailsInChargePage(Selenium selenium,BillingLib billData ){
		
		if(!(selenium.isTextPresent(billData.serviceCode)&&(selenium.isTextPresent(billData.serviceCode2)&&(selenium.isTextPresent(billData.serviceCode3)
				&&(selenium.isTextPresent(billData.serviceCode4)&&(selenium.isTextPresent(billData.serviceCode5)&&(selenium.isTextPresent(billData.serviceCode6)))))))){
			return false;	
		}
		

		return true;
	}
	
	public boolean  callChargeEntry(Selenium selenium, BillingLib chargeEntryData)throws IOException {
		
		if(isElementPresent(selenium, btnErrorClose)) {
			 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		 }
		
		assertTrue(click(selenium, lnkPostChargeHome),
				"Could not click the Booking Appointment", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);
		
		 if(isElementPresent(selenium, btnErrorClose)) {
			 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		 }
		assertTrue(click(selenium, btnAddPostCharge),
				"Could not click the Booking Appointment", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);
		
		 if(isElementPresent(selenium, btnErrorClose)) {
			 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		 }
		 
		assertTrue(
				type(selenium, ajxPostChargeSearchPatient,
						chargeEntryData.patientID),
				"Could not type patient id", selenium, ClassName, MethodName);
		selenium.clickAt(ajxPostChargeSearchPatient, "");
		selenium.focus(ajxPostChargeSearchPatient);
		selenium.fireEvent(ajxPostChargeSearchPatient, "keypress");
		waitForElement(selenium, lblPatientResult, 10000);
		assertTrue(selenium.isElementPresent(lblPatientResult),
				"Search Results are not displayed for the patient with ID :-"
						+ chargeEntryData.patientID, selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);
		selenium.click(lblPatientResult);
		waitForPageLoad(selenium);
		return true;
	}
	
	/**
	 * function to verifyBillingHistryCreditAmount
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 28,2014
	 */
	public boolean verifyBillingHistryCreditAmount(Selenium selenium, BillingLib payerPaymemtData) throws IOException{
		assertTrue(click(selenium, lnkBillingSummary),"Could not click the Summary link in Billing summary page", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		if(!selenium.isTextPresent("$0.00")){
			return false;
		}

		
		
		
		if(!getText(selenium,lblInsurance).contains(payerPaymemtData.paidAmt1)){
			return false;
		}
		

		return true;
	}
	
	/**
	 * function to adjustAllCharges
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Sep 18,2014
	 */
	public boolean adjustAllCharges(Selenium selenium, BillingLib payerPaymemtData) throws IOException{
		
		int countRows=0,count=1;
		
		while(isElementPresent(selenium,lnkChargeActionLink)){
			selenium.clickAt(lnkChargeActionLink+"["+countRows+2+"]", "");
			waitForPageLoad(selenium);
			
			String amountDue = getText(selenium,lblAmountDue+"["+count+"]").replace("$", "");
			System.out.println(amountDue);
			
			assertTrue(click(selenium,lnkAdjustCharge),"Could not click the Adjust charge in Charge Entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxchrReason,"End Credit"),"Selection Failed", selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtChrAmount,amountDue),"Could not enter the charge amount",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnChrSave),"Could not click the save button in charge page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
		}
		
		return true;
	 }
	
	/**
	 * function to verifyBillingHistryDebitAmount
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 28,2014
	 */
	public boolean verifyBillingHistryDebitAmount(Selenium selenium, BillingLib payerPaymemtData) throws IOException{
		assertTrue(click(selenium, lnkBillingSummary),"Could not click the Summary link in Billing summary page", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		if(!selenium.isTextPresent("$0.00")){
			return false;
		}

		if(!getText(selenium,lblInsurance).contains(payerPaymemtData.paidAmt1)){
			return false;
		}
		

		return true;
	}
	
	/**
	 * function to patientPaymentAmount
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 28,2014
	 */
	
	public boolean patientPaymentAmount(Selenium selenium,BillingLib patientPaymemtData) throws IOException{
		
		assertTrue(click(selenium,lnkPatientOption),"Could not click the Patient Option link", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,lnkpostPatientPayment),"Could not click Post Payer payment option in Patient action under", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(type(selenium, txtreferenceNo, patientPaymemtData.referenceNo),"Could not  enter the refference no in Patient payment page",selenium, ClassName,MethodName);
		assertTrue(type(selenium, txpaidAmount, patientPaymemtData.paidAmount),"Could not  enter the Paid amount  in Patient payment page",selenium, ClassName,MethodName);
		
		assertTrue(click(selenium,btnPost),"Could not click Save button in Patient action under", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
	
	/**
	 * function to verifyPatientPaidAmount
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 28,2014
	 */
	public boolean verifyPatientPaidAmount(Selenium selenium, BillingLib patientPaidData) throws IOException{
		assertTrue(click(selenium, lnkBillingSummary),"Could not click the Summary link in Billing summary page", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		float autoAllocate, paidamount, totalAmount;
		
		autoAllocate = Float.parseFloat(patientPaidData.autoallocate);
		paidamount = Float.parseFloat(patientPaidData.paidAmount);
		totalAmount = autoAllocate - paidamount;
		
		patientPaidData.autoallocate = String.valueOf(totalAmount);
		
		if(!selenium.isTextPresent(patientPaidData.autoallocate)){
			return false;
		}

		if(!selenium.isTextPresent(patientPaidData.paidAmount)){
			return false;
		}
		
		if(!getText(selenium,txtUnAppliedAmount).contains("0.00")){
			return false;
		}

		return true;
	}
	
	public boolean claimCreationOne(Selenium selenium,BillingLib claimData,HomeLib payerData ,String account){
		try{
			 float Fee1, Fee2, Fee3, amount;
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (account.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			String date = DateFormat.format(cal.getTime());
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+claimData.switchRole, "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			
			claimData.renderingProvider = pName;
	
			assertTrue(selectValueFromAjaxList(selenium, ajxRenderingProvider,claimData.renderingProvider),"Could not select the rendering provider", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			//assertTrue(selectValueFromAjaxList(selenium, ajxBillingProvider,chargeEntryData.billingProvider),"Could not select the billing provider", selenium, ClassName,MethodName);
			assertTrue(selectValueFromAjaxList(selenium, location,claimData.location),"Could not select the Location", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);		
			assertTrue(selectValueFromAjaxList(selenium, placeOfService,claimData.placeOfService),"Could not select the place of service", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(account.equals(USAccount)){
			assertTrue(selectValueFromAjaxList(selenium, lstDiagnosis00,claimData.diagnosisCodes),"could not select the diagnosisi code", selenium, ClassName,MethodName);
			}
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxBillTo,payerData.payerName );
			
			
			if(claimData.testCaseId.equals("TC_SBE_007")){
				//service code one
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCodeCharge,claimData.serviceCode),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(enterDate(selenium,txtFromDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(type(selenium, txtUnits, claimData.units),"Could not enter the units", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtFee, claimData.fee1),"Could not enter the Fee", selenium, ClassName,MethodName);
				selenium.typeKeys(txtFee, "\\b");
				waitForPageLoad(selenium);
				//assertTrue(enterDate(selenium,txtToDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				
				//service code two
				assertTrue(click(selenium,btnAddNewServiceLine),"Could not click the Add New button in Charge Entry Page", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtFromDate2,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode2,claimData.serviceCode2),"Could not select the service code", selenium, ClassName,MethodName);
				//assertTrue(type(selenium, txtUnits, claimData.units),"Could not enter the units", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtFee2, claimData.fee2),"Could not enter the Fee", selenium, ClassName,MethodName);
				selenium.typeKeys(txtFee2, "\\b");
				waitForPageLoad(selenium);
				//assertTrue(enterDate(selenium,txtToDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				
				
				
				//service code three
				assertTrue(click(selenium,btnAddNewServiceLine),"Could not click the Add New button in Charge Entry Page", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtFromDate3,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode3,claimData.serviceCode3),"Could not select the service code", selenium, ClassName,MethodName);
				//assertTrue(type(selenium, txtUnits, claimData.units),"Could not enter the units", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtFee3, claimData.fee3),"Could not enter the Fee", selenium, ClassName,MethodName);
				selenium.typeKeys(txtFee3, "\\b");
				waitForPageLoad(selenium);
				
				//assertTrue(enterDate(selenium,txtToDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				
				Fee1 = Float.parseFloat(claimData.fee1);
				Fee2 = Float.parseFloat(claimData.fee2);
				Fee3 = Float.parseFloat(claimData.fee3);
				
				amount = Fee1+Fee2+Fee3;
				claimData.toTalFee1 = String.valueOf(amount);
				if(!getValue(selenium,txtTotalCharge).contains(claimData.toTalFee1)){
					return false;
				}
			}
			if(claimData.testCaseId.equals("TC_SBE_011")){	
				
				assertTrue(enterDate(selenium,txtFromDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCodeCharge,claimData.serviceCode),"Could not select the service code", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnAddNewServiceLine),"Could not click the Add New button in Charge Entry Page", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtFromDate2,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode2,claimData.serviceCode2),"Could not select the service code", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnAddNewServiceLine),"Could not click the Add New button in Charge Entry Page", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtFromDate3,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode3,claimData.serviceCode3),"Could not select the service code", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnAddNewServiceLine),"Could not click the Add New button in Charge Entry Page", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtFromDate4,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode4,claimData.serviceCode4),"Could not select the service code", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
			}
			assertTrue(click(selenium,btnPostChargeEntry),"Could not click the post button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,location)){
			    return false;
			}else
			    return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	
	
	/**
	 * function to claimCreationTwo
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 06,2014
	 */
	
	public boolean claimCreationTwo(Selenium selenium,BillingLib claimData,HomeLib payerData, String account){
		try{
			float Fee1, Fee2, amount;
		    Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (account.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			String date = DateFormat.format(cal.getTime());
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+claimData.switchRole, "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			
			claimData.renderingProvider = pName;
			
			assertTrue(selectValueFromAjaxList(selenium, ajxRenderingProvider,claimData.renderingProvider),"Could not select the rendering provider", selenium, ClassName,MethodName);
			//assertTrue(selectValueFromAjaxList(selenium, ajxBillingProvider,chargeEntryData.billingProvider),"Could not select the billing provider", selenium, ClassName,MethodName);
			assertTrue(selectValueFromAjaxList(selenium, location,claimData.location),"Could not select the Location", selenium, ClassName,MethodName);
			assertTrue(selectValueFromAjaxList(selenium, placeOfService,claimData.placeOfService),"Could not select the place of service", selenium, ClassName,MethodName);
			if(account.equals(USAccount)){
			assertTrue(selectValueFromAjaxList(selenium, lstDiagnosis00,claimData.diagnosisCodes),"could not select the diagnosisi code", selenium, ClassName,MethodName);
			}
			selectValueFromAjaxList(selenium,ajxBillTo,payerData.payerName );
			//service code one
			assertTrue(selectValueFromAjaxList(selenium, ajxServiceCodeCharge,claimData.serviceCode),"Could not select the service code", selenium, ClassName,MethodName);
			assertTrue(enterDate(selenium,txtFromDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
			//assertTrue(enterDate(selenium,txtToDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtUnits, claimData.units),"Could not enter the units", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtFee, claimData.fee1),"Could not enter the Fee", selenium, ClassName,MethodName);
			selenium.typeKeys(txtFee, "\\b");
			waitForPageLoad(selenium);
			
			//service code two
			assertTrue(click(selenium,btnAddNewServiceLine),"Could not click the Add New button in Charge Entry Page", selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode2,claimData.serviceCode2),"Could not select the service code", selenium, ClassName,MethodName);
			assertTrue(enterDate(selenium,txtFromDate2,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
			//assertTrue(type(selenium, txtUnits, claimData.units),"Could not enter the units", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtFee2, claimData.fee2),"Could not enter the Fee", selenium, ClassName,MethodName);
			selenium.typeKeys(txtFee2, "\\b");
			waitForPageLoad(selenium);
			//assertTrue(enterDate(selenium,txtToDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
			Fee1 = Float.parseFloat(claimData.fee1);
			Fee2 = Float.parseFloat(claimData.fee2);
			
			
			amount = Fee1+Fee2;
			
			claimData.toTalFee2 = String.valueOf(amount);
			if(!getValue(selenium,txtTotalCharge).contains(claimData.toTalFee2)){
				return false;
			}
			assertTrue(click(selenium,btnPostChargeEntry),"Could not click the post button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,location)){
			    return false;
			}else
			    return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	
	/**
	 * function to claimCreationTwo
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 06,2014
	 */
	
	public boolean claimCreationThree(Selenium selenium,BillingLib claimData,HomeLib payerData, String account){
		try{
			 
		    Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (account.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			String date = DateFormat.format(cal.getTime());
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+claimData.switchRole, "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			
			claimData.renderingProvider = pName;
			
			assertTrue(selectValueFromAjaxList(selenium, ajxRenderingProvider,claimData.renderingProvider),"Could not select the rendering provider", selenium, ClassName,MethodName);
			//assertTrue(selectValueFromAjaxList(selenium, ajxBillingProvider,chargeEntryData.billingProvider),"Could not select the billing provider", selenium, ClassName,MethodName);
			assertTrue(selectValueFromAjaxList(selenium, location,claimData.location),"Could not select the Location", selenium, ClassName,MethodName);
			assertTrue(selectValueFromAjaxList(selenium, placeOfService,claimData.placeOfService),"Could not select the place of service", selenium, ClassName,MethodName);
			if(account.equals(USAccount)){
			assertTrue(selectValueFromAjaxList(selenium, lstDiagnosis00,claimData.diagnosisCodes),"could not select the diagnosisi code", selenium, ClassName,MethodName);
			}
			selectValueFromAjaxList(selenium,ajxBillTo,payerData.payerName );
			
			//service code one
			assertTrue(selectValueFromAjaxList(selenium, ajxServiceCodeCharge,claimData.serviceCode6),"Could not select the service code", selenium, ClassName,MethodName);
			assertTrue(enterDate(selenium,txtFromDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtUnits, claimData.units),"Could not enter the units", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtFee, claimData.fee6),"Could not enter the Fee", selenium, ClassName,MethodName);
			selenium.typeKeys(txtFee, "\\b");
			//assertTrue(enterDate(selenium,txtToDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
			
			claimData.toTalFee3 = claimData.fee6;
			
			if(!getValue(selenium,txtTotalCharge).contains(claimData.toTalFee3)){
				return false;
			}
			
			assertTrue(click(selenium,btnPostChargeEntry),"Could not click the post button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,location)){
			    return false;
			}else
			    return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	
	/**
	 * function to claimCreationFour
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 06,2014
	 */
	
	public boolean claimCreationFour(Selenium selenium,BillingLib claimData,HomeLib payerData, String account){
		try{
			float Fee1, Fee2, amount;
		    Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (account.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			String date = DateFormat.format(cal.getTime());
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+claimData.switchRole, "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			
			claimData.renderingProvider = pName;
			
			assertTrue(selectValueFromAjaxList(selenium, ajxRenderingProvider,claimData.renderingProvider),"Could not select the rendering provider", selenium, ClassName,MethodName);
			//assertTrue(selectValueFromAjaxList(selenium, ajxBillingProvider,chargeEntryData.billingProvider),"Could not select the billing provider", selenium, ClassName,MethodName);
			assertTrue(selectValueFromAjaxList(selenium, location,claimData.location),"Could not select the Location", selenium, ClassName,MethodName);
			assertTrue(selectValueFromAjaxList(selenium, placeOfService,claimData.placeOfService),"Could not select the place of service", selenium, ClassName,MethodName);
			if(account.equals(USAccount)){
			assertTrue(selectValueFromAjaxList(selenium, lstDiagnosis00,claimData.diagnosisCodes),"could not select the diagnosisi code", selenium, ClassName,MethodName);
			}
			
			
			if(!isChecked(selenium,chkBoxAccident)){
				assertTrue(click(selenium,chkBoxAccident),"Could not chekc the accident related check box", selenium, ClassName, MethodName);
				if(!isChecked(selenium,chkBoxEmployment)){
					assertTrue(click(selenium,chkBoxEmployment),"Could not check the Employment check box", selenium, ClassName, MethodName);
				}
				if(account.equals(USAccount)){
				selectValueFromAjaxList(selenium,lstAccidentState,"Alabama" );
				}
				assertTrue(enterDate(selenium,"accidentDate",date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(type(selenium, "startHour", "01"),"Could not enter the Fee", selenium, ClassName,MethodName);
				assertTrue(type(selenium, "startMinute","10"),"Could not enter the Fee", selenium, ClassName,MethodName);
			}

			selectValueFromAjaxList(selenium,ajxBillTo,payerData.payer );
			
			//service code one
			assertTrue(enterDate(selenium,txtFromDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, ajxServiceCodeCharge,claimData.serviceCode5),"Could not select the service code", selenium, ClassName,MethodName);
			
			//assertTrue(type(selenium, txtUnits, claimData.units),"Could not enter the units", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtFee, claimData.fee5),"Could not enter the Fee", selenium, ClassName,MethodName);
			selenium.typeKeys(txtFee, "\\b");
			waitForPageLoad(selenium);
			//assertTrue(enterDate(selenium,txtToDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
			
			//service code two
			assertTrue(click(selenium,btnAddNewServiceLine),"Could not click the Add New button in Charge Entry Page", selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtFromDate2,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode2,claimData.serviceCode6),"Could not select the service code", selenium, ClassName,MethodName);
			//assertTrue(type(selenium, txtUnits, claimData.units),"Could not enter the units", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtFee2, claimData.fee6),"Could not enter the Fee", selenium, ClassName,MethodName);
			selenium.typeKeys(txtFee2, "\\b");
			waitForPageLoad(selenium);
			//assertTrue(enterDate(selenium,txtToDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
			
			Fee1 = Float.parseFloat(claimData.fee5);
			Fee2 = Float.parseFloat(claimData.fee6);
		
			
			amount = Fee1+Fee2;
			claimData.toTalFee4 = String.valueOf(amount);
			if(!getValue(selenium,txtTotalCharge).contains(claimData.toTalFee4)){
				return false;
			}
			assertTrue(click(selenium,btnPostChargeEntry),"Could not click the post button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,location)){
			    return false;
			}else
			    return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	
	/**
	 * function to claimCreationFour
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 06,2014
	 */
	
	public boolean claimCreationFive(Selenium selenium,BillingLib claimData,HomeLib payerData, String account){
		try{
			float Fee1, Fee2, amount;
		    Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (account.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			String date = DateFormat.format(cal.getTime());
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+claimData.switchRole, "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			
			claimData.renderingProvider = pName;
			
			assertTrue(selectValueFromAjaxList(selenium, ajxRenderingProvider,claimData.renderingProvider),"Could not select the rendering provider", selenium, ClassName,MethodName);
			//assertTrue(selectValueFromAjaxList(selenium, ajxBillingProvider,chargeEntryData.billingProvider),"Could not select the billing provider", selenium, ClassName,MethodName);
			assertTrue(selectValueFromAjaxList(selenium, location,claimData.location),"Could not select the Location", selenium, ClassName,MethodName);
			assertTrue(selectValueFromAjaxList(selenium, placeOfService,claimData.placeOfService),"Could not select the place of service", selenium, ClassName,MethodName);
			if(account.equals(USAccount)){
			assertTrue(selectValueFromAjaxList(selenium, lstDiagnosis00,claimData.diagnosisCodes),"could not select the diagnosisi code", selenium, ClassName,MethodName);
			}
			selectValueFromAjaxList(selenium,ajxBillTo,"Patient" );
			
			//service code one
			assertTrue(enterDate(selenium,txtFromDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, ajxServiceCodeCharge,claimData.serviceCode2),"Could not select the service code", selenium, ClassName,MethodName);
			//assertTrue(type(selenium, txtUnits, claimData.units),"Could not enter the units", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtFee, claimData.fee2),"Could not enter the Fee", selenium, ClassName,MethodName);
			selenium.typeKeys(txtFee, "\\b");
			waitForPageLoad(selenium);
			//assertTrue(enterDate(selenium,txtToDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
			
			//service code two
			assertTrue(click(selenium,btnAddNewServiceLine),"Could not click the Add New button in Charge Entry Page", selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtFromDate2,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode2,claimData.serviceCode4),"Could not select the service code", selenium, ClassName,MethodName);
			//assertTrue(type(selenium, txtUnits, claimData.units),"Could not enter the units", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtFee2, claimData.fee4),"Could not enter the Fee", selenium, ClassName,MethodName);
			selenium.typeKeys(txtFee2, "\\b");
			waitForPageLoad(selenium);
			//assertTrue(enterDate(selenium,txtToDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
			
			Fee1 = Float.parseFloat(claimData.fee2);
			Fee2 = Float.parseFloat(claimData.fee4);
			
			amount = Fee1+Fee2;
			claimData.toTalFee5 = String.valueOf(amount);
			if(!getValue(selenium,txtTotalCharge).contains(claimData.toTalFee5)){
				return false;
			}
			
			assertTrue(click(selenium,btnPostChargeEntry),"Could not click the post button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,location)){
			    return false;
			}else
			    return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * function to claimCreationFour
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 06,2014
	 */
	public boolean endToEndPayerPaymentTwo(Selenium selenium,BillingLib payerPayment,BillingLib billData,HomeLib payerData,HomeLib payerDataB,String account) throws IOException{
		try{
			int cAdjreason ,  ajxCAdjcount;
			String cAdjusmentValue ="";
			float amount1, amount2, amount3 ,amount4, totalAmount;
			
			
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (account.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			String date = DateFormat.format(cal.getTime());
			
			selectValueFromAjaxList(selenium,ajxInsurance, payerData.payerName);
			assertTrue(type(selenium, txtCheckAmount,payerPayment.checkAmount),"Could not enter the check amount in payer payment page" , selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtCheck,payerPayment.checkNumber),"Could not enter the check Number in payer payment page", selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium, txtdepositDate,date),"Could not enter the deposit Date in payer payment page", selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtTotalPaidAmount,payerPayment.checkAmount),"Could not enter the Paid amount in payer payment page", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,adjustmentReason,"End Credit");
			
			
			//search PatientA
			payerPayment.patientName = payerData.patientId;
			assertTrue(type(selenium, txtClaimPatientSearch, payerPayment.patientName),"Could not type patient id", selenium, ClassName, MethodName);
			
			selenium.keyPress(txtClaimPatientSearch, "\\13");
			waitForElement(selenium,lblPatientResult,10000);
			
	 		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+payerPayment.patientName, selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(payerPayment.patientName.trim().toLowerCase(new java.util.Locale("en","US"))),"could not get patient name", selenium, ClassName, MethodName);
			click(selenium,lblPatientResult);
			waitForPageLoad(selenium);
			
			 ajxCAdjcount =(Integer) selenium.getXpathCount("//input[@id='contractualAdjustment']"); 
			for(cAdjreason = 1;cAdjreason <= ajxCAdjcount;cAdjreason++){
				assertTrue(type(selenium,"xpath=(//input[@id='contractualAdjustment'])["+cAdjreason+"]",cAdjusmentValue),"Could not clear value",selenium, ClassName, MethodName);
			}
			
			
			
			assertTrue(type(selenium,txpaidAmount,"0"),"Could not enter the Paid Amount in Payer Payment Page",selenium,ClassName, MethodName);
			assertTrue(type(selenium,txPaidAmount1,billData.fee1),"Could not enter the Paid Amount in Payer Payment Page",selenium,ClassName, MethodName);
			assertTrue(type(selenium,txtPaidAmount3,billData.fee3),"Could not enter the Paid Amount in Payer Payment Page",selenium,ClassName, MethodName);
			assertTrue(type(selenium,txtPaidAmount4,billData.fee2),"Could not enter the Paid Amount in Payer Payment Page",selenium,ClassName, MethodName);
			assertTrue(type(selenium,txtPaidAmount5,billData.fee1),"Could not enter the Paid Amount in Payer Payment Page",selenium,ClassName, MethodName);
			
			//Calculation For Patient A
			amount1 = Float.parseFloat(billData.fee1);
			amount2 = Float.parseFloat(billData.fee3);
			amount3 = Float.parseFloat(billData.fee2);
			amount4 = Float.parseFloat(billData.fee1);
			
			totalAmount = amount1+amount2+amount3+amount4;
			
			billData.toTalFee7 = String.valueOf(totalAmount);
			
			//search PatientB
			assertTrue(click(selenium,btnAddClaim),"Could not click the Add New button in Payer Payment page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			payerPayment.patientName = payerDataB.patientId;
			
			assertTrue(type(selenium, txtClaimPatientSearch1, payerPayment.patientName),"Could not type patient id", selenium, ClassName, MethodName);
			
			selenium.keyPress(txtClaimPatientSearch1, "\\13");
			waitForElement(selenium,lblPatientResult,10000);
			
	 		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+payerPayment.patientName, selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(payerPayment.patientName.trim().toLowerCase(new java.util.Locale("en","US"))),"could not get patient name", selenium, ClassName, MethodName);
			click(selenium,lblPatientResult);
			waitForPageLoad(selenium);
			
			 ajxCAdjcount=(Integer) selenium.getXpathCount("//input[@id='contractualAdjustment']"); 
			for(cAdjreason = 1;cAdjreason <= ajxCAdjcount;cAdjreason++){
				assertTrue(type(selenium,"xpath=(//input[@id='contractualAdjustment'])["+cAdjreason+"]",cAdjusmentValue),"Could not clear value",selenium, ClassName, MethodName);
			}
			assertTrue(type(selenium,"xpath=(//input[@id='paidAmount'])[6]","0"),"Could not enter the Paid Amount in Payer Payment Page",selenium,ClassName, MethodName);
			assertTrue(type(selenium,"xpath=(//input[@id='paidAmount'])[7]",billData.fee1),"Could not enter the Paid Amount in Payer Payment Page",selenium,ClassName, MethodName);
			assertTrue(type(selenium,"xpath=(//input[@id='paidAmount'])[8]",billData.fee3),"Could not enter the Paid Amount in Payer Payment Page",selenium,ClassName, MethodName);
			
			//Calculation For Patient B
			amount1 = Float.parseFloat(billData.fee1);
			amount2 = Float.parseFloat(billData.fee3);
			totalAmount = amount1+amount2;
			billData.toTalFee8 = String.valueOf(totalAmount);
			
			assertTrue(click (selenium,btnPPtSave),"Could not enter the post button in Batch Payment entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}return false;
		
		
	}
	
	/**
	 * function to claimCreationFour
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 06,2014
	 */
	
	public boolean verifyUnPostedQueue(Selenium selenium,BillingLib payerPaymemtData, HomeLib payer,String account) throws IOException{
		try{
			assertTrue(click(selenium,lnkUnpostedQuee),"Could not click the Unposted Payer Batch", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String lblUnposted = "//div[starts-with(@id,'unpostedBatch')]/div/div";
			int count;
			int claimsCount = (Integer) selenium.getXpathCount(lblUnposted);
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (account.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			
			String date = DateFormat.format(cal.getTime());
			
			for(count =1; count <=claimsCount; count++ ){
				if(((getText(selenium, "xpath=(//div[starts-with(@id,'unpostedBatch')]/div/div)["+count+"]").contains(payerPaymemtData.checkNumber))
						&&(getText(selenium,"xpath=(//div[starts-with(@id,'unpostedBatch')]/div/div)["+count+"]").contains(payerPaymemtData.checkAmount))
						&&(getText(selenium,"xpath=(//div[starts-with(@id,'unpostedBatch')]/div/div)["+count+"]").contains(payer.payerName))
						&&(getText(selenium,"xpath=(//div[starts-with(@id,'unpostedBatch')]/div/div)["+count+"]").contains(date)))){
					
								
					selenium.clickAt("xpath=(//div[starts-with(@id,'unpostedBatch')]/div/div)["+count+"]/div", "");
					waitForPageLoad(selenium);
					
				
					assertTrue(click(selenium,btnPost),"Could not click the post button in  Payer Batch page screen", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					
					assertTrue(click(selenium,btnPostYes),"Could not click the yes button in  Payer Batch page screen", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					
					return true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * function to verifyAfterPaostPaymentWithPatientA
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 06,2014
	 */
	public boolean verifyAfterPostPaymentWithPatientA(Selenium selenium,BillingLib billData, String totalAmount) throws IOException{
		float  amount2,amount3, toTalAmount;
		
		
		amount2 = Float.parseFloat(billData.toTalFee7);
		amount3 = Float.parseFloat(totalAmount);
		
		
		toTalAmount =  amount3 - amount2;
		billData.insuranceBalance = String .valueOf(toTalAmount);
		
		assertTrue(click(selenium, lnkBillingSummary),"Could not click the Summary link in Billing summary page", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		if(!selenium.isTextPresent(billData.insuranceBalance)){
			return false;
		}
		
		if(!selenium.isTextPresent(billData.toTalFee5)){
			return false;
		}
		
		return true;
	}
	
	/**
	 * function to verifyAfterPaostPaymentWithPatientA
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 06,2014
	 */
	public boolean verifyAfterPostPaymentPayerTwoWithPatientA(Selenium selenium,BillingLib billData, BillingLib paymentData) throws IOException{
		try{
			float amount1, amount2, toTalAmount;
			
			amount1 = Float.parseFloat(billData.insuranceBalance);
			amount2 = Float.parseFloat(billData.toTalFee9);
			
			toTalAmount =  amount1 - amount2;
			billData.insuranceBalance = String .valueOf(toTalAmount);
			
			assertTrue(click(selenium, lnkBillingSummary),"Could not click the Summary link in Billing summary page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(!selenium.isTextPresent(billData.insuranceBalance)){
				return false;
			}
			
			/*if(!selenium.isTextPresent(billData.toTalFee5)){
				return false;
			}*/
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * function to verifyAfterPaostPaymentWithPatientB
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 06,2014
	 */
	public boolean verifyAfterPaostPaymentWithPatientB(Selenium selenium,BillingLib billData) throws IOException{
		float amount1, amount2, toTalAmount;
		
		amount1 = Float.parseFloat(billData.toTalFee8);
		amount2 = Float.parseFloat(billData.toTalFee1);
		
		toTalAmount =  amount2 - amount1;
		billData.patientBalance1 = String .valueOf(toTalAmount);
		
		assertTrue(click(selenium, lnkBillingSummary),"Could not click the Summary link in Billing summary page", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		if(!getText(selenium,lblPatientBalance).contains(billData.patientBalance1)){
			
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * function to endToEndPayerPaymentTwoWithPayerTwo
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 06,2014
	 */
	public boolean endToEndPayerPaymentTwoWithPayerTwo(Selenium selenium,BillingLib payerPayment,BillingLib billData,HomeLib payerData,String account) throws IOException{
		try{
			int cAdjreason ,  ajxCAdjcount;
			String cAdjusmentValue ="";
			float amount1, amount2, totalAmount;
			
	
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (account.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			String date = DateFormat.format(cal.getTime());
			
			selectValueFromAjaxList(selenium,ajxInsurance, payerData.payerName);
			assertTrue(type(selenium, txtCheckAmount,payerPayment.checkAmount),"Could not enter the check amount in payer payment page" , selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtCheck,payerPayment.checkNumber),"Could not enter the check Number in payer payment page", selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium, txtdepositDate,date),"Could not enter the deposit Date in payer payment page", selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtTotalPaidAmount,payerPayment.checkAmount),"Could not enter the Paid amount in payer payment page", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,adjustmentReason,"End Credit");
			
			
			//search PatientA
			payerPayment.patientName = payerData.patientId;
			assertTrue(type(selenium, txtClaimPatientSearch, payerPayment.patientName),"Could not type patient id", selenium, ClassName, MethodName);
			
			selenium.keyPress(txtClaimPatientSearch, "\\13");
			waitForElement(selenium,lblPatientResult,10000);
			
	 		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+payerPayment.patientName, selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(payerPayment.patientName.trim().toLowerCase(new java.util.Locale("en","US"))),"could not get patient name", selenium, ClassName, MethodName);
			click(selenium,lblPatientResult);
			waitForPageLoad(selenium);
			
			 ajxCAdjcount =(Integer) selenium.getXpathCount("//input[@id='contractualAdjustment']"); 
			for(cAdjreason = 1;cAdjreason <= ajxCAdjcount;cAdjreason++){
				assertTrue(type(selenium,"xpath=(//input[@id='contractualAdjustment'])["+cAdjreason+"]",cAdjusmentValue),"Could not clear value",selenium, ClassName, MethodName);
			}
	
			String sCode1 = getText(selenium,"xpath=(//span[@id='serviceCode'])[1]");
			//String fee = getText(selenium,"xpath=(//span[@id='chargeAmount'])[1]").replace("$", "");
			if(sCode1.equals("006ETE")){
				assertTrue(type(selenium,txpaidAmount,"125"),"Could not enter the Paid Amount in Payer Payment Page",selenium,ClassName, MethodName);
			}else{
				assertTrue(type(selenium,txpaidAmount,"100"),"Could not enter the Paid Amount in Payer Payment Page",selenium,ClassName, MethodName);
			}
			
			/*if(!fee1.equals("100.00")){
				fee1 = "100.00";
			}*/
			
			
			String sCode2 = getText(selenium,"xpath=(//span[@id='serviceCode'])[2]");
			if(sCode2.equals("001ETE")){
				assertTrue(type(selenium,txPaidAmount1,"100"),"Could not enter the Paid Amount in Payer Payment Page",selenium,ClassName, MethodName);
			}else{
			assertTrue(type(selenium,txtPaidAmount3,"125"),"Could not enter the Paid Amount in Payer Payment Page",selenium,ClassName, MethodName);
			}
			
			//Calculation For Patient A
			amount1 = Float.parseFloat(billData.fee6);
			amount2 = Float.parseFloat(billData.fee2);
			
			
			totalAmount = amount1+amount2;
			
			billData.toTalFee9 = String.valueOf(totalAmount);
			
			assertTrue(click(selenium,btnPost),"Could not click the post button in Payer Payment page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click (selenium,btnPostYes),"Could not click the yes button in Batch Payment entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;

	}
	
	/**
	 * function to endToEndEnterPatientPayment
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 07,2014
	 */
	public boolean endToEndEnterPatientPayment(Selenium selenium,BillingLib postPatientData, BillingLib postData,HomeLib payerData) throws IOException{
		try{
			assertTrue(type(selenium,txtTotalPaidAmount,postPatientData.toTalPaidAmount),"Could not enter the Paid Amount", selenium,ClassName, MethodName);
			
			assertTrue(searchPatientPayment(selenium,postPatientData ),"Could not search the patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxMethodOfPayment,postPatientData.methodOfPayment),"Could not select the Method Of Payment", selenium , ClassName, MethodName);
			assertTrue(type(selenium,txtreferenceNo,postPatientData.referenceNo),"Could not enter the reference No", selenium,ClassName, MethodName);
			
			assertTrue(type(selenium,txpaidAmount,postPatientData.paidAmount),"Could not enter the Paid Amount", selenium,ClassName, MethodName);
			assertTrue(click(selenium,chkUnAllocate),"Could not click the Un autoallocate payment", selenium, ClassName, MethodName);
			
			
			//search anOther payer 
			assertTrue(click(selenium,btnPPatiemtPaymentAdd),"Could not click the Add new button in patient payment page", selenium, ClassName, MethodName);
			postData.patientID = payerData.patientId;
			assertTrue(type(selenium, txtClaimPatientSearch1, postData.patientID),"Could not type patient id", selenium, ClassName,MethodName);
			selenium.clickAt(txtClaimPatientSearch1,"");
			selenium.focus(txtClaimPatientSearch1);			
			selenium.fireEvent(txtClaimPatientSearch1,"keypress");		
			waitForElement(selenium, lblPatientResult, 10000);
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+ postData.patientID, selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			selenium.click(lblPatientResult);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxMethodOfPayment,postData.methodOfPayment),"Could not select the Method Of Payment", selenium , ClassName, MethodName);
			assertTrue(type(selenium,txtReferenceNo,postData.referenceNo),"Could not enter the reference No", selenium,ClassName, MethodName);
			assertTrue(type(selenium,"xpath=(//div[@class='display-cell paid-amount input-col']/div/div/input)[2]",postData.paidAmount),"Could not enter the Paid Amount", selenium,ClassName, MethodName);
			
			assertTrue(click(selenium,chkAutoAllocate1),"Could not click the autoallocate payment in second patient", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium, btnPost),"Could not click the post button", selenium,ClassName, MethodName);
			assertTrue(click(selenium, btnPostYes),"Could not click the yes button", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return false;
	}
	
	public boolean verifyPostPatientPaymentWithPatientA(Selenium selenium,BillingLib postData ) throws IOException{
		try {
			assertTrue(click(selenium, lnkBillingSummary),"Could not click the Summary link in Billing summary page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(!selenium.isTextPresent(postData.patientBalance1)){
				return false;
			}
			
			
			
			if(!selenium.isTextPresent(postData.insuranceBalance)){
				return false;
			}
			
			
			if(!getText(selenium,txtUnAppliedAmount).contains(postData.patientBalance1)){
				return false;
			}
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return false;
	}
	
	/**
	 * function to verifyPostPatientPaymentWithPatientB
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 07,2014
	 */
	public boolean verifyPostPatientPaymentWithPatientB(Selenium selenium,BillingLib postData ) throws IOException{
		try{
			assertTrue(click(selenium, lnkBillingSummary),"Could not click the Summary link in Billing summary page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(!selenium.isTextPresent(postData.patientBalance1)){
				return false;
			}
			
			if(!getText(selenium,lblPatientBalance).contains("0.00")){
				return false;
			}
			
			if(!getText(selenium,lblInsurance).contains("0.00")){
				return false;
			}
			
			
			if(!getText(selenium,txtUnAppliedAmount).contains("0.00")){
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * function to verifyAfterApplyingPatientPaymentInPatientA
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 07,2014
	 */
	public boolean verifyAfterApplyingPatientPaymentInPatientA(Selenium selenium,BillingLib billData, BillingLib postData) throws IOException{
		try {
			float paidAmount, pBalance, amount;
			billData.patientBalance = "220";
			String patientBalance;
			paidAmount = Float.parseFloat(postData.paidAmount);
			pBalance = Float.parseFloat(billData.patientBalance);
			amount = pBalance - paidAmount;
			
			patientBalance = String.valueOf(amount);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkBillingSummary),"Could not click the Summary link in Billing summary page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(!selenium.isTextPresent(postData.paidAmount)){
				return false;
			}
			
			
			
			if(!getText(selenium,lblInsurance).contains(billData.insuranceBalance)){
				return false;
			}
			
			if(!getText(selenium,txtUnAppliedAmount).contains("0.00")){
				return false;
			}
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * function to verifyDataAfterReversingAPayment
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 07,2014
	 */
	public boolean verifyDataAfterReversingAPayment(Selenium selenium,BillingLib billData,BillingLib  postData) throws IOException{
		try{
			assertTrue(click(selenium, lnkBillingSummary),"Could not click the Summary link in Billing summary page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(!selenium.isTextPresent(postData.paidAmount)){
				return false;
			}
			
			if(!selenium.isTextPresent(billData.insuranceBalance)){
				return false;
			}
			if(!getText(selenium,txtUnAppliedAmount).contains(postData.paidAmount)){
				return false;
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * function to claimForCreationOne
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 06,2014
	 */
	
	public boolean claimCreationForOne(Selenium selenium, BillingLib billData,HomeLib payerData, String account ){
		
		try{
			
			 if(isElementPresent(selenium, btnErrorClose)) {
				 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 }
			 
			 float Fee1, Fee2, Fee3,Fee4,Fee5, Fee6, Fee7, Fee8,Fee9, Fee10, amount;
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat;
				if (account.equalsIgnoreCase(CAAccount)) {
					DateFormat = new SimpleDateFormat("MMM dd, YYYY");
				} else {
					DateFormat = new SimpleDateFormat("MM/dd/YYYY");
				}
				String date = DateFormat.format(cal.getTime());
				
				String providerNameTemp= getText(selenium, lnkTopMenu);
				String providerName= providerNameTemp.replaceAll(", "+billData.switchRole, "");
				String tempArray[]=providerName.split(" ");
				String pName=tempArray[1]+", "+tempArray[0];
				
				billData.renderingProvider = pName;
		
				assertTrue(selectValueFromAjaxList(selenium, ajxRenderingProvider,billData.renderingProvider),"Could not select the rendering provider", selenium, ClassName,MethodName);
				//assertTrue(selectValueFromAjaxList(selenium, ajxBillingProvider,chargeEntryData.billingProvider),"Could not select the billing provider", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, location,billData.location),"Could not select the Location", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, placeOfService,billData.placeOfService),"Could not select the place of service", selenium, ClassName,MethodName);
				
				selectValueFromAjaxList(selenium,ajxBillTo,payerData.payerName );
			
				//Add 12 Diagnosis Code 
				if(account.equals(USAccount)){
				assertTrue(selectValueFromAjaxList(selenium, lstDiagnosis00,"0011"),"could not select the diagnosisi code", selenium, ClassName,MethodName);
				}
				assertTrue(selectValueFromAjaxList(selenium, diagnosisCode2,"001"),"could not select the diagnosisi code", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, diagnosisCode3,"0019"),"could not select the diagnosisi code", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, diagnosisCode4,"002"),"could not select the diagnosisi code", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnAddNewDiagnosisCode),"Could not click the Add new button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(selectValueFromAjaxList(selenium, diagnosisCode5,"0030"),"could not select the diagnosisi code", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, diagnosisCode6,"003"),"could not select the diagnosisi code", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, diagnosisCode7,"0020"),"could not select the diagnosisi code", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, diagnosisCode8,"0021"),"could not select the diagnosisi code", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,"xpath=(//a[@id='addNewRowButton']/div)[2]"),"Could not click the Add new button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(selectValueFromAjaxList(selenium, diagnosisCode9,"0031"),"could not select the diagnosisi code", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, diagnosisCode10,"0022"),"could not select the diagnosisi code", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, diagnosisCode11,"0023"),"could not select the diagnosisi code", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, diagnosisCode12,"0029"),"could not select the diagnosisi code", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				//Add 10 Service code
				
				//service code one
				assertTrue(enterDate(selenium,txtFromDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCodeCharge,billData.serviceCode),"Could not select the service code", selenium, ClassName,MethodName);
				
				//add 4 Modifiers
				assertTrue(selectValueFromAjaxList(selenium, lstmodifiers,"21"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier2,"22"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier1),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier3,"23"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier1),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier4,"24"),"Could not select the service code", selenium, ClassName,MethodName);
				
				
				//assertTrue(type(selenium, txtUnits, billData.units),"Could not enter the units", selenium, ClassName,MethodName);
				assertTrue(type(selenium, txtFee, billData.fee1),"Could not enter the Fee", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selenium.typeKeys(txtFee, "\\b");
				waitForPageLoad(selenium);
				
				//service code two
				assertTrue(click(selenium,btnAddNewServiceLine),"Could not click the Add New button in Charge Entry Page", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtFromDate2,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode2,billData.serviceCode2),"Could not select the service code", selenium, ClassName,MethodName);
				
				//add 4 Modifiers
				assertTrue(selectValueFromAjaxList(selenium, Modifier5,"21"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier6,"22"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier2),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier7,"23"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier2),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier8,"24"),"Could not select the service code", selenium, ClassName,MethodName);

				assertTrue(type(selenium, txtFee2, billData.fee2),"Could not enter the Fee", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selenium.typeKeys(txtFee2, "\\b");
				waitForPageLoad(selenium);
				
				//service code Three
				assertTrue(click(selenium,btnAddNewServiceLine),"Could not click the Add New button in Charge Entry Page", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtFromDate3,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode3,billData.serviceCode3),"Could not select the service code", selenium, ClassName,MethodName);
				
				//add 4 Modifiers
				assertTrue(selectValueFromAjaxList(selenium, Modifier9,"21"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier10,"22"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier3),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier11,"23"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier3),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier12,"24"),"Could not select the service code", selenium, ClassName,MethodName);
				
				assertTrue(type(selenium, txtFee3, billData.fee3),"Could not enter the Fee", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selenium.typeKeys(txtFee3, "\\b");
				waitForPageLoad(selenium);
				
				//service code four
				assertTrue(click(selenium,btnAddNewServiceLine),"Could not click the Add New button in Charge Entry Page", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtFromDate4,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode4,billData.serviceCode4),"Could not select the service code", selenium, ClassName,MethodName);
				
				//add 4 Modifiers
				assertTrue(selectValueFromAjaxList(selenium, Modifier13,"21"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier14,"22"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier4),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier15,"23"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier4),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier16,"24"),"Could not select the service code", selenium, ClassName,MethodName);
				
				assertTrue(type(selenium, txtFee4, billData.fee4),"Could not enter the Fee", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selenium.typeKeys(txtFee4, "\\b");
				waitForPageLoad(selenium);
				
				//service code Five
				assertTrue(click(selenium,btnAddNewServiceLine),"Could not click the Add New button in Charge Entry Page", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtFromDate5,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode5,billData.serviceCode5),"Could not select the service code", selenium, ClassName,MethodName);
				
				//add 4 Modifiers
				assertTrue(selectValueFromAjaxList(selenium, Modifier17,"21"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier18,"22"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier5),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier19,"23"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier5),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier20,"24"),"Could not select the service code", selenium, ClassName,MethodName);
				
				
				assertTrue(type(selenium, txtFee5, billData.fee5),"Could not enter the Fee", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selenium.typeKeys(txtFee5, "\\b");
				waitForPageLoad(selenium);
				
				//service code Six
				assertTrue(click(selenium,btnAddNewServiceLine),"Could not click the Add New button in Charge Entry Page", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtFromDate6,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode6,billData.serviceCode6),"Could not select the service code", selenium, ClassName,MethodName);
				
				//add 4 Modifiers
				assertTrue(selectValueFromAjaxList(selenium, Modifier21,"21"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier22,"22"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier6),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier23,"23"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier6),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier24,"24"),"Could not select the service code", selenium, ClassName,MethodName);
				
				assertTrue(type(selenium, txtUnit6, billData.unit2),"Could not enter the Fee", selenium, ClassName,MethodName);
				assertTrue(type(selenium, txtFee6, billData.fee6),"Could not enter the Fee", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selenium.typeKeys(txtFee6, "\\b");
				waitForPageLoad(selenium);
				String fee6 = getValue(selenium,lblChargeAmount6);
				
				
				//service code Seven
				assertTrue(click(selenium,btnAddNewServiceLine),"Could not click the Add New button in Charge Entry Page", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtFromDate7,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode7,billData.serviceCode7),"Could not select the service code", selenium, ClassName,MethodName);
				
				//add 4 Modifiers
				assertTrue(selectValueFromAjaxList(selenium, Modifier25,"21"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier26,"22"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier7),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier27,"23"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier7),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier28,"24"),"Could not select the service code", selenium, ClassName,MethodName);
				
				assertTrue(type(selenium, txtUnit7, billData.unit3),"Could not enter the Fee", selenium, ClassName,MethodName);
				assertTrue(type(selenium, txtFee7, billData.fee7),"Could not enter the Fee", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selenium.typeKeys(txtFee7, "\\b");
				waitForPageLoad(selenium);
				String fee7 = getValue(selenium,lblChargeAmount7);
				
				
				//service code Eight
				assertTrue(click(selenium,btnAddNewServiceLine),"Could not click the Add New button in Charge Entry Page", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtFromDate8,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode8,billData.serviceCode8),"Could not select the service code", selenium, ClassName,MethodName);
				
				//add 4 Modifiers
				assertTrue(selectValueFromAjaxList(selenium, Modifier29,"21"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier30,"22"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier8),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier31,"23"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier8),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier32,"24"),"Could not select the service code", selenium, ClassName,MethodName);
				
				assertTrue(type(selenium, txtUnit8, billData.unit4),"Could not enter the Fee", selenium, ClassName,MethodName);
				assertTrue(type(selenium, txtFee8, billData.fee8),"Could not enter the Fee", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selenium.typeKeys(txtFee8, "\\b");
				waitForPageLoad(selenium);
				String fee8 = getValue(selenium,lblChargeAmount8);
				
				//service code Nine
				assertTrue(click(selenium,btnAddNewServiceLine),"Could not click the Add New button in Charge Entry Page", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtFromDate9,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode9,billData.serviceCode9),"Could not select the service code", selenium, ClassName,MethodName);
				
				//add 4 Modifiers
				assertTrue(selectValueFromAjaxList(selenium, Modifier33,"21"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier34,"22"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier9),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier35,"23"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier9),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier36,"24"),"Could not select the service code", selenium, ClassName,MethodName);
				
				assertTrue(type(selenium, txtUnit9, billData.unit5),"Could not enter the Fee", selenium, ClassName,MethodName);
				assertTrue(type(selenium, txtFee9, billData.fee9),"Could not enter the Fee", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selenium.typeKeys(txtFee9, "\\b");
				waitForPageLoad(selenium);
				String fee9= getValue(selenium,lblChargeAmount9);
				
				//service code Ten
				assertTrue(click(selenium,btnAddNewServiceLine),"Could not click the Add New button in Charge Entry Page", selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtFromDate10,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode10,billData.serviceCode10),"Could not select the service code", selenium, ClassName,MethodName);
			
				//add 4 Modifiers
				assertTrue(selectValueFromAjaxList(selenium, Modifier37,"21"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier38,"22"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier10),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier39,"23"),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnModifier10),"Could not click the Add New button in Modifier", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, Modifier40,"24"),"Could not select the service code", selenium, ClassName,MethodName);
				
				assertTrue(type(selenium, txtUnit10, billData.unit6),"Could not enter the Fee", selenium, ClassName,MethodName);
				assertTrue(type(selenium, txtFee10, billData.fee10),"Could not enter the Fee", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selenium.typeKeys(txtFee10, "\\b");
				waitForPageLoad(selenium);
				String fee10 = getValue(selenium,lblChargeAmount10);
				
				
				
				//String to Float converation
				Fee1 = Float.parseFloat(billData.fee1);
				Fee2 = Float.parseFloat(billData.fee2);
				Fee3 = Float.parseFloat(billData.fee3);
				Fee4 = Float.parseFloat(billData.fee4);
				Fee5 = Float.parseFloat(billData.fee5);
				Fee6 = Float.parseFloat(fee6);
				Fee7 = Float.parseFloat(fee7);
				Fee8 = Float.parseFloat(fee8);
				Fee9 = Float.parseFloat(fee9);
				Fee10 = Float.parseFloat(fee10);
				
				amount = Fee1 + Fee2 + Fee3+Fee4+Fee5+Fee6+Fee7+Fee8+Fee9+Fee10;
				System.out.println(amount);
				String Amount =  String.valueOf(amount);
				
				Amount =  Amount.substring(0,1)+","+Amount.substring(1, 4);
				
				billData.toTalFee1 =Amount ;
				
				if(!getValue(selenium,txtTotalCharge).contains(billData.toTalFee1)){
					return false;
				}
				
				selenium.clickAt(btnActions, "");
				assertTrue(click(selenium,btnPostAndHold),"Could not click the Post and Hold Claims", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	
	/**
	 * function to claimForCreationOne
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 06,2014
	 */
	
	public boolean claimCreationForTwo(Selenium selenium, BillingLib billData,BillingLib entryData, HomeLib payerData, String account ){
		
		try{
			if(isElementPresent(selenium, btnErrorClose)) {
				 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 }
			
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat;
				if (account.equalsIgnoreCase(CAAccount)) {
					DateFormat = new SimpleDateFormat("MMM dd, YYYY");
				} else {
					DateFormat = new SimpleDateFormat("MM/dd/YYYY");
				}
				String date = DateFormat.format(cal.getTime());
				
				String providerNameTemp= getText(selenium, lnkTopMenu);
				String providerName= providerNameTemp.replaceAll(", "+billData.switchRole, "");
				String tempArray[]=providerName.split(" ");
				String pName=tempArray[1]+", "+tempArray[0];
				
				billData.renderingProvider = pName;
		
				assertTrue(selectValueFromAjaxList(selenium, ajxRenderingProvider,billData.renderingProvider),"Could not select the rendering provider", selenium, ClassName,MethodName);
				//assertTrue(selectValueFromAjaxList(selenium, ajxBillingProvider,chargeEntryData.billingProvider),"Could not select the billing provider", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, location,billData.location),"Could not select the Location", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, placeOfService,billData.placeOfService),"Could not select the place of service", selenium, ClassName,MethodName);
				if(account.equals(USAccount)){
				assertTrue(selectValueFromAjaxList(selenium, lstDiagnosis00,billData.diagnosisCodes),"could not select the diagnosisi code", selenium, ClassName,MethodName);
				}
				selectValueFromAjaxList(selenium,ajxBillTo,payerData.payerName );
				//service code one
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCodeCharge,billData.serviceCode),"Could not select the service code", selenium, ClassName,MethodName);
				assertTrue(enterDate(selenium,txtFromDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(type(selenium, txtUnits, billData.unit7),"Could not enter the units", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtFee, billData.fee10),"Could not enter the Fee", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selenium.typeKeys(txtFee, "\\b");
				waitForPageLoad(selenium);
				
				String fee = getValue(selenium,lblChargeAmount1);
				
				
				
				if(!getValue(selenium,txtTotalCharge).contains(fee)){
					return false;
				}
				//assertTrue(enterDate(selenium,txtToDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				
				if(getText(selenium,lnkChargeEntryShowDetails).contains("Show all details"))
					assertTrue(click(selenium,lnkChargeEntryShowDetails),"Could not click the Show details", selenium, ClassName, MethodName);
	
				if(!isChecked(selenium,chkAmbulanceTrans)){
					assertTrue(click(selenium,chkAmbulanceTrans),"Could not click the Ambulance check box", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(createAmbulanceDetails(selenium,entryData),"Amblance Details Creation Failed", selenium, ClassName, MethodName);
				}
				
				if(!isChecked(selenium,chkDME)){
					assertTrue(click(selenium,chkDME),"Could not click the Ambulance check box", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(createDME(selenium,entryData,date ),"DME Creation Failed", selenium, ClassName, MethodName);
				}
				
				if(!isChecked(selenium,chkOxygen)){
					assertTrue(click(selenium,chkOxygen),"Could not click the Ambulance check box", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(createOxygenDetails(selenium,entryData,date ),"OxygenDetails Creation Failed", selenium, ClassName, MethodName);
				}
				
				assertTrue(click(selenium,btnPostChargeEntry),"Could not click the post button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,location)){
				    return false;
				}else
				    return true;
				
		}catch(Exception e){
			e.printStackTrace();
		}

		return true;
	}
	
	/**
	 * function to createAmbulanceDetails
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 12,2014
	 */
	public boolean createAmbulanceDetails(Selenium selenium,BillingLib chargeData) throws IOException{
		try{	
			assertTrue(type(selenium,txtPatientWeight, chargeData.patientWeight),"Could not enter the patient wegiht", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPatientCount, chargeData.patientCount),"Could not enter the patient count", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,lstAmbulanceTransReason,chargeData.transReason);
			assertTrue(type(selenium,txtTransDistance, chargeData.transDistance),"Could not enter the trans Distance ", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtRoungTrip, chargeData.roundTrip),"Could not enter the round trip", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtStretcherPurpose, chargeData.stretcherPurpose),"Could not enter the stretcher purpose", selenium, ClassName, MethodName);
			
			//Pick up Location
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtStreet1, chargeData.pickStreet1),"Could not enter the pick Street", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtStreet2, chargeData.pickStreet2),"Could not enter the pick Street", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtCity, chargeData.pickCity),"Could not enter the city ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,lstState,chargeData.pickState);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtZip, chargeData.pickZip),"Could not enter the zip", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,lstCountry,chargeData.pickCountry);
			waitForPageLoad(selenium);
			
			//Drop - off - location
			assertTrue(type(selenium,txtDropStreet1, chargeData.dropStreet1),"Could not enter the drop Street", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtDropStreet2, chargeData.dropStreet2),"Could not enter the drop Street2", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtDropCity, chargeData.dropCity),"Could not enter the city ", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,lstDropState,chargeData.dropState);
			assertTrue(type(selenium,txtDropZip, chargeData.dropZip),"Could not enter the zip", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,lstDropCountry,chargeData.dropCountry);
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * function to createDME
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 12,2014
	 */
	public boolean createDME(Selenium selenium,BillingLib chargeData,String date) throws IOException{
		try{
			selectValueFromAjaxList(selenium,lstDMECerti,chargeData.dMECertificate);

			assertTrue(enterDate(selenium,dateCertiRev, date),"Could not enter the enter datez", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,txtCTCode,chargeData.ctCode);
			assertTrue(type(selenium,txtPatientHeight, chargeData.patientHeight),"Could not enter the Patient Hight", selenium, ClassName, MethodName);
			
			assertTrue(type(selenium,txtRentalPrice, chargeData.rentalPrice),"Could not enter the Rental price ", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtEquipDuration, chargeData.equipDuration),"Could not enter the Equip Duration", selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,dateBeginTherapy, date),"Could not enter the  date", selenium, ClassName, MethodName);
			
			//Pick up Location
			assertTrue(type(selenium,txtDMEPatientWeight, chargeData.patientWeight),"Could not enter the weight", selenium, ClassName, MethodName);
			
			selectValueFromAjaxList(selenium,lstRentalPriceUnit,chargeData.rentalPriceUnit);
			assertTrue(enterDate(selenium,dateLastCerti,date),"Could not enter the zip", selenium, ClassName, MethodName);
			
			
			//Drop - off - location
			assertTrue(type(selenium,txtLenMedicalNece, chargeData.lenMedicalNece),"Could not enter the drop Street", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPurchasePrice, chargeData.purchasePrice),"Could not enter the drop Street2", selenium, ClassName, MethodName);
			
		
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	/**
	 * function to createOxygenDetails
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 12,2014
	 */
	public boolean createOxygenDetails(Selenium selenium,BillingLib chargeData,String date) throws IOException{
		try{
			selectValueFromAjaxList(selenium,lstOxyCerti,chargeData.oxyCertificate);
			assertTrue(enterDate(selenium,dateOxyCertiRev, date),"Could not enter the enter date", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxOxygenCertificateTransission,chargeData.ctCode);
			assertTrue(type(selenium,txtOxyduration, chargeData.oxyDuration),"Could not enter the Oxy Duration", selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,dateOxyBeginTherapy,date),"Could not enter the date", selenium, ClassName, MethodName);
			
			assertTrue(enterDate(selenium,dateOxyLastCerti, date),"Could not enter Date ", selenium, ClassName, MethodName);
		
	
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
		
	}
	
	/**
	 * function to verifyShowAllDetailsEditClaim
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 13,2014
	 */
	
	public boolean verifyShowAllDetailsEditClaim(Selenium selenium, BillingLib chargeData) throws IOException{
		
		if(getText(selenium,lnkChargeEntryShowDetails).contains("Show all details")){
			assertTrue(click(selenium,lnkChargeEntryShowDetails),"Could not click the Show details", selenium, ClassName, MethodName);
		}
		/*if(!getValue(selenium, txtPatientWeight).contains(chargeData.patientWeight)){
			return false;
		}
		
		if(!getValue(selenium, txtPatientCount).contains(chargeData.patientCount)){
			return false;
		}
		if(!getValue(selenium, lstAmbulanceTransReason).contains(chargeData.transReason)){
			return false;
		}
		if(!getValue(selenium, txtTransDistance).contains(chargeData.transDistance)){
			return false;
		}
		if(!getValue(selenium, txtRoungTrip).contains(chargeData.roundTrip)){
			return false;
		}
		if(!getValue(selenium, txtStretcherPurpose).contains(chargeData.stretcherPurpose)){
			return false;
		}
		if(!getValue(selenium, txtStreet1).contains(chargeData.pickStreet1)){
			return false;
		}
		if(!getValue(selenium, txtStreet2).contains(chargeData.pickStreet2)){
			return false;
		}
		if(!getValue(selenium, txtCity).contains(chargeData.pickCity)){
			return false;
		}
		if(!getValue(selenium, lstState).contains(chargeData.pickState)){
			return false;
		}
		if(!getValue(selenium, txtZip).contains(chargeData.pickZip)){
			return false;
		}
		if(!getValue(selenium, lstCountry).contains(chargeData.pickCountry)){
			return false;
		}
		if(!getValue(selenium, txtDropStreet1).contains(chargeData.dropStreet1)){
			return false;
		}
		if(!getValue(selenium, txtDropStreet2).contains(chargeData.dropStreet2)){
			return false;
		}
		
		if(!getValue(selenium, lstDropState).contains(chargeData.dropState)){
			return false;
		}
		
		if(!getValue(selenium, txtDropCity).contains(chargeData.dropCity)){
			return false;
		}
		
		if(!getValue(selenium, txtDropZip).contains(chargeData.dropZip)){
			return false;
		}
		
		if(!getValue(selenium, lstDropCountry).contains(chargeData.dropCountry)){
			return false;
		}
		
		if(!getValue(selenium, lstDMECerti).contains(chargeData.dMECertificate)){
			return false;
		}
		
		
		if(!getValue(selenium, txtCTCode).contains(chargeData.ctCode)){
			return false;
		}
		
		if(!getValue(selenium, txtPatientHeight).contains(chargeData.patientHeight)){
			return false;
		}
		
		if(!getValue(selenium, txtRentalPrice).contains(chargeData.rentalPrice)){
			return false;
		}
		
		if(!getValue(selenium, txtEquipDuration).contains(chargeData.equipDuration)){
			return false;
		}
		
		if(!getValue(selenium, txtDMEPatientWeight).contains(chargeData.patientWeight)){
			return false;
		}
		
		if(!getValue(selenium, lstRentalPriceUnit).contains(chargeData.rentalPriceUnit)){
			return false;
		}
		
		if(!getValue(selenium, txtLenMedicalNece).contains(chargeData.lenMedicalNece)){
			return false;
		}
		
		
		if(!getValue(selenium, txtPurchasePrice).contains(chargeData.purchasePrice)){
			return false;
		}
		
		if(!getValue(selenium, lstOxyCerti).contains(chargeData.oxyCertificate)){
			return false;
		}
		if(!getValue(selenium, ajxOxygenCertificateTransission).contains(chargeData.ctCode)){
			return false;
		}
		if(!getValue(selenium, txtOxyduration).contains(chargeData.oxyDuration)){
			return false;
		}
		if(!getValue(selenium, txtDropStreet2).contains(chargeData.dropStreet2)){
			return false;
		}
		if(!getValue(selenium, txtPatientWeight).contains(chargeData.patientWeight)){
			return false;
		}*/
		return true;
	}

	/**
	 * function to verifyOnHoldClaimsInOnHoldQueue
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 13,2014
	 */
	
	public boolean verifyOnHoldClaimsInOnHoldQueue(Selenium selenium,BillingLib chargeData, HomeLib payerData ) throws IOException{
		try{
			assertTrue(click(selenium,lnkOnHold),"Could not click On Hold Queue in the home page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(type(selenium,txtPaperSearchPatient,payerData.patientId),"Could not type the provider", selenium, ClassName, MethodName);
			selenium.keyPress(txtPaperSearchPatient, "\\13");
			waitForPageLoad(selenium);
			String lblOnHold = "//div[starts-with(@id,'onHoldClaim')]/div/div";
			int count;
			int claimsCount = (Integer) selenium.getXpathCount(lblOnHold);
			
			
			for(count =1; count <=claimsCount;count++ ){
				
				if(((getText(selenium, "xpath=(//div[starts-with(@id,'onHoldClaim')]/div/div)["+count+"]").toLowerCase().contains(payerData.payerName.toLowerCase()))
						&&(getText(selenium, "xpath=(//div[starts-with(@id,'onHoldClaim')]/div/div)["+count+"]").toLowerCase().contains(payerData.patientId.toLowerCase())))){
					
					selenium.clickAt("xpath=(//div[starts-with(@id,'onHoldClaim')]/div/div)["+count+"]/span["+count+"]", "");
					waitForPageLoad(selenium);
					return true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * function to verifyOnHoldClaimsInOnHoldQueue
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 13,2014
	 */
	public boolean verifyCliamdetailsInChargePage(Selenium selenium,BillingLib billingData,BillingLib chargeData, HomeLib payerData ) throws IOException{
		
		try{
			
			if(!selenium.isTextPresent("On Hold")){
				return false;
			}
			if(!((selenium.isTextPresent(billingData.serviceCode))&&(selenium.isTextPresent(billingData.serviceCode2))&&(selenium.isTextPresent(billingData.serviceCode3))
					&&(selenium.isTextPresent(billingData.serviceCode4))&&(selenium.isTextPresent(billingData.serviceCode5))&&(selenium.isTextPresent(billingData.serviceCode6))
					&&(selenium.isTextPresent(billingData.serviceCode7))&&(selenium.isTextPresent(billingData.serviceCode8))&&(selenium.isTextPresent(billingData.serviceCode9))
					&&(selenium.isTextPresent(billingData.serviceCode10)))){
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return true;
	}
	
	/**
	 * function to verifyOnHoldClaimsInOnHoldQueue
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 13,2014
	 */
	public boolean applyAmountToCharge(Selenium selenium) throws IOException{
		try{
			int count;
 			int counter = 1;
			int defaultCount = 11;
			int applyCounter = 1;
			String chargeAmount = null;
			String currentPayer = null;
			assertTrue(click(selenium,lnkChargeHistory),"Could not click the charge entry in Billing Summary Page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			for(count = 1; count <defaultCount; count++){
				currentPayer = getText(selenium,"xpath=(//div[@id='currentPayer'])["+applyCounter+"]");
				chargeAmount = getText(selenium,"xpath=(//div[@id='chargeAmount'])["+applyCounter+"]").replace("$", "");
			if((chargeAmount.equals("145.00"))&&(!(currentPayer.equals("Patient")))){
				
					selenium.clickAt("xpath=(//div[contains(text(),'"+currentPayer+"')]/parent::div/parent::div/div[10]/div/div)["+applyCounter+"]", "");
					waitForPageLoad(selenium);
					assertTrue(click(selenium,lnkApplyPatientPayment),"Could not click the Apply patient payments post button", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					
					assertTrue(type(selenium,txtPAppliedAmount,chargeAmount),"Could not enter the paid amount", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				
					assertTrue(click(selenium,btnChrSave),"Could not click the save button in charge entry page", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					break;
				}
				applyCounter++;
			}
			
			for(count = 1; count <defaultCount; count++){
				currentPayer = getText(selenium,"xpath=(//div[@id='currentPayer'])["+counter+"]");
				chargeAmount = getText(selenium,"xpath=(//div[@id='chargeAmount'])["+counter+"]").replace("$", "");
				if(!currentPayer.equals("Patient")){
					
					selenium.clickAt("xpath=(//div[contains(text(),'"+currentPayer+"')]/parent::div/parent::div/div[10]/div/div)["+counter+"]", "");
					waitForPageLoad(selenium);
					assertTrue(click(selenium,lnkApplyPatientPayment),"Could not click the Apply patient payments post button", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					
					assertTrue(type(selenium,txtPAppliedAmount,chargeAmount),"Could not enter the paid amount", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				
					assertTrue(click(selenium,btnChrSave),"Could not click the save button in charge entry page", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					}
				counter++;
				//applyCounter++;
			}
			
			String  patientAmount = getText(selenium,"totalAmountDueDiv").replace("$", "");
			
			assertTrue(click(selenium, lnkBillingSummary),"Could not click the Summary link in Billing summary page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			/*assertTrue(!selenium.isTextPresent(patientAmount), "" + "could not caluculate the patient balance", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
		
			//As per test case document i have update the script 
			assertTrue(selenium.isTextPresent(patientAmount), "" + "could not caluculate the patient balance", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * function to verifyOnHoldClaimsInOnHoldQueue
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 13,2014
	 */
	

	public boolean statmentTrigger(Selenium selenium, String webSite){
		try{
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			String date = DateFormat.format(cal.getTime());
			
			String genrateUrl = webSite + "AdminConsole/generateStatements";
			selenium.openWindow(genrateUrl, "Nexia");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * function to verifyUnprintedQueue
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 13,2014
	 */
	public boolean verifyUnprintedQueue(Selenium selenium, HomeLib payerData, String account) throws IOException{
		try{
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			 if(isElementPresent(selenium, btnErrorClose)) {
				 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 }
			 
			assertTrue(click(selenium,lnkUnprintedStatement),"Could not click Unprinted Statement in the home page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			 if(isElementPresent(selenium, btnErrorClose)) {
				 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 }
			
			assertTrue(type(selenium,ajxSearch,payerData.patientId),"Could not type the provider", selenium, ClassName, MethodName);
			selenium.keyPress(ajxSearch, "\\13");
			waitForPageLoad(selenium);
			
			String lblUnprinted = "//div[starts-with(@id,'statement')]";
			int count;
			int claimsCount = (Integer) selenium.getXpathCount(lblUnprinted);
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (account.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			String date = DateFormat.format(cal.getTime());
		
			for(count = 1; count <=claimsCount; count++ ){
				System.out.println(getText(selenium,"xpath=(//div[starts-with(@id,'statement')]))[1]"));
				System.out.println(payerData.patientId.toLowerCase());
				System.out.println(date);
				if(!(getText(selenium,"xpath=(//div[starts-with(@id,'statement')])["+count+"]").toLowerCase().contains(payerData.patientId.toLowerCase())
						&&(getText(selenium,"xpath=(//div[starts-with(@id,'statement')])["+count+"]").contains(date)))){
					if(!getText(selenium,"xpath=(//div[starts-with(@id,'statement')])["+count+"]").toLowerCase().contains(payerData.patientId.toLowerCase())){
						return true;
					}
					if(!getText(selenium,"xpath=(//div[starts-with(@id,'statement')])["+count+"]").toLowerCase().contains(date)){
						return true;
					}
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * function to verifyUnprintedQueue
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 13,2014
	 */
	public boolean verifyUnprintedStatmentQueue(Selenium selenium, HomeLib PatientData,BillingLib billingData, String account) throws IOException{
		try{
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (account.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			String date = DateFormat.format(cal.getTime());
		
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkUnprintedStatement),"Could not click Unprinted Statement in the home page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,ajxSearch,PatientData.patientId),"Could not type the provider", selenium, ClassName, MethodName);
			selenium.keyPress(ajxSearch, "\\13");
			waitForPageLoad(selenium);
			if(billingData.testCaseId.equals("TC_BS_003")){
				selectValueFromAjaxList(selenium,ajxSuggestBox,billingData.financialStatus);
			}
			if(billingData.testCaseId.equals("TC_BS_005")){
				assertTrue(enterDate(selenium,txtFromDateUnprintStatement,date),"Could not type From Date", selenium, ClassName, MethodName);
				selenium.keyPress(txtFromDateUnprintStatement, "\\13");
			}
			if(billingData.testCaseId.equals("TC_BS_006")){
				assertTrue(enterDate(selenium,txtToDateUnprintStatement,date),"Could not type To Date", selenium, ClassName, MethodName);
				selenium.keyPress(txtFromDateUnprintStatement, "\\13");
			}
			
			String lblUnprinted = "//div[starts-with(@id,'statement')]";
			int count;
			int claimsCount = (Integer) selenium.getXpathCount(lblUnprinted);
		
			for(count = 1; count <=claimsCount; count++ ){
				if((getText(selenium,"xpath=(//div[starts-with(@id,'statement')])["+count+"]").toLowerCase().contains(PatientData.patientId.toLowerCase())
						&&(getText(selenium,"xpath=(//div[starts-with(@id,'statement')])["+count+"]").contains(date)))){
				if((billingData.testCaseId.equals("TC_BS_007"))|| (billingData.testCaseId.equals("TC_BS_008"))){
			    	if((getText(selenium,"xpath=(//div[starts-with(@id,'statement')])["+count+"]").toLowerCase().contains(billingData.financialStatus.toLowerCase()))){
			    	return true;
			    	}
			    }
					return true;
			}	
		}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * function to Set Unprinted Statment FinancialStatus
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Apr  15,2014
	 */
	public boolean setUnprintedStatmentFinancialStatus(Selenium selenium, HomeLib PatientData, BillingLib billingData ) throws IOException{
		try{
			assertTrue(type(selenium, txtPatientBox, PatientData.lastName),
					"Could not type patient id", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt("searchPatientBox","");
			selenium.focus("searchPatientBox");			
			selenium.fireEvent("searchPatientBox","keypress");		
			waitForElement(selenium, lblPatientResult, 10000);
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+ PatientData.patientID, selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			selenium.mouseOver(lblPatientResult);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkBillingHistory),"could not click Billing Settings", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, "link=Patient Options"),
					"Could not click Patient Option", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

	   		if(billingData.testCaseId.equals("TC_BS_007")){
			assertTrue(click(selenium, lnkBadDebtStatus),
					"Could not click link BadDebt Status", selenium, ClassName, MethodName);
	   		}
	   		if(billingData.testCaseId.equals("TC_BS_008")){
	   			assertTrue(click(selenium, lnkPendingCollectionStatus),
						"Could not click link Pending Collection Status", selenium, ClassName, MethodName);
	   		}
	   	
	   		assertTrue(click(selenium, btnSave),"could not click Button Save", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
	   		
			waitForPageLoad(selenium);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * function to updatedStamentPreference
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 13,2014
	 */
	
	public boolean updatedStamentPreference(Selenium selenium){
		try{
			assertTrue(goToStatmentPreferences(selenium),"Could not navigate to Statment Preference section", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnEdit),"Could not click the edit button in Statment Preference page", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtBalanceAtleast,"2355"),"could not enter the amount in Balance Atleast text box", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnDoneServiceCode),"Could not click the Done button in Statment Preference page", selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium,txtBalanceAtleast)){
				return false;
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * function to endToEndFeeSchedule
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 17,2014
	 */
	
	public boolean endToEndFeeSchedule(Selenium selenium,BillingLib feeData,String account  ){
		try{
			
			
		    assertTrue(selectValueFromAjaxList(selenium, ajxPayer, feeData.payer), "could not select payer", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
		    
		    if(feeData.testCaseId.equals("TC_FS_010")){
			    assertTrue(selectValueFromAjaxList(selenium, ajxSpeciality, feeData.speciality), "could not select ", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			 }
			assertTrue(type(selenium,txtCodeRangeFrom,feeData.codeRangeFrom),"Could not enter the code range from value",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCodeRangeTo,feeData.CodeRangeTo),"Could not enter the code range To value",selenium, ClassName, MethodName);
		
			 selenium.keyPress(txtCodeRangeTo, "\\13");
			 waitForPageLoad(selenium);
			 
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (account.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
				
			assertTrue(verifyServiceCodeInFeeSchedule(selenium, feeData),"service code value is not getting displayed in fee schedule page",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			int count;
			int allowAmountCount = (Integer) selenium.getXpathCount(txtFeeAllowAmount);
			
			 String date = DateFormat.format(cal.getTime());
			 for(count = 1; count <= allowAmountCount; count++ ){
				 assertTrue(type(selenium,"xpath=(//input[@id='allowedAmountTextBox'])["+count+"]",feeData.allowedAmount),"Could not enter the code range To value",selenium, ClassName, MethodName);
				 assertTrue(type(selenium,"xpath=(//input[@id='effectiveDate'])["+count+"]",date),"Could not enter date",selenium, ClassName, MethodName);
			 }
			
			 assertTrue(click(selenium,btnSaveFeeSchedule ),"could not click the save button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 if(isElementPresent(selenium,ajxPayer)){
				return false; 
			 }else
				 return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * function to editEndToEndFeeSchedule
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 17,2014
	 */
	
	public boolean editEndToEndFeeSchedule(Selenium selenium,BillingLib feeData,String account){
		try{
			int count;
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (account.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			System.out.println("Navigate to Fee page");
			 waitForPageLoad(selenium);
			assertTrue(type(selenium,txtCodeRangeFrom,feeData.codeRangeFrom),"Could not enter the code range To value",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			assertTrue(type(selenium,txtCodeRangeTo,feeData.CodeRangeTo),"Could not enter date",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 selenium.keyPress(txtCodeRangeTo, "\\13");
			 waitForPageLoad(selenium);
			 String date = DateFormat.format(cal.getTime());
			 int allowAmountCount = (Integer) selenium.getXpathCount(txtFeeAllowAmount);
			 for(count = 1; count <= allowAmountCount; count++ ){
				 System.out.println(feeData.allowedAmount);
				 assertTrue(type(selenium,"xpath=(//input[@id='allowedAmountTextBox'])["+count+"]",feeData.allowedAmount),"Could not enter the code range To value",selenium, ClassName, MethodName);
				 assertTrue(enterDate(selenium,"xpath=(//input[@id='effectiveDate'])["+count+"]",date),"Could not enter date",selenium, ClassName, MethodName);
			 }
			
			 assertTrue(click(selenium,btnSaveFeeSchedule ),"could not click the save button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 if(isElementPresent(selenium,ajxPayer)){
				return false; 
			 }else
				 return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	/**
	 * function to verifyServiceCodeInFeeSchedule
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 17,2014
	 */
	
	public boolean verifyServiceCodeInFeeSchedule(Selenium selenium,BillingLib seriveCode ){
		try{	
			String sCode[] ={"TC_SC_025","TC_SC_026","TC_SC_027","TC_SC_028","TC_SC_029"};
		
			int sCodeCount;
			int sCodePossition = 1;
			BillingLib sCodeData = new BillingLib();
			sCodeData.workSheetName = "ServiceCodes";
			for(sCodeCount = 0; sCodeCount < sCode.length; sCodeCount++){
				
				sCodeData.testCaseId = sCode[sCodeCount];
				sCodeData.fetchBillingTestData();
				
				if (sCodePossition == 1)					
				{				
					if(!getText(selenium,serviceCodeHTML).contains(sCodeData.serviceCode1)){
						return false;
					}					
				}				
				else				
				{
					if(!getText(selenium,"xpath=(//span[@id='serviceCodeHTML'])["+sCodePossition+"]").contains(sCodeData.serviceCode1)){
					return false;
					}
				}				
				sCodePossition++;
			}
			assertTrue(click(selenium,btnSaveFeeSchedule ),"could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}	
	
	/**
	 * function to searchFeeSchedule
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 17,2014
	 */
	public boolean searchFeeSchedule(Selenium selenium,BillingLib feeCode){
		
		try{
			assertTrue(type(selenium,ajxSearch, feeCode.payer),"Could not enter the payer name",selenium , ClassName,MethodName);
			waitForPageLoad(selenium);
			selenium.keyPress(ajxSearch, "\\13");
			waitForPageLoad(selenium);
			System.out.println(getText(selenium,lblFeeSummary).toLowerCase());
			waitForPageLoad(selenium);
			System.out.println(feeCode.payer.toLowerCase());
			waitForPageLoad(selenium);
			if((getText(selenium,lblFeeSummary).toLowerCase().equalsIgnoreCase(feeCode.payer.toLowerCase()))){
					return true;
			}else{
				assertTrue(click(selenium,chkFeeInactive),"could not click the Inactive Check box", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if((getText(selenium,lblFeeSummary).equalsIgnoreCase(feeCode.payer))){
					assertTrue(click(selenium,lnkActivate),"could not click the Active button in Fee Schedule  page", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					return true;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return false;
	}
	
	/**
	 * function to createEndToEndFeeSchedule
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 24,2014
	 */
	
	public boolean createEndToEndFeeSchedule(Selenium selenium,BillingLib feeCodeData,String account) throws IOException{
		try{
		
			boolean verifyFeeSchedule = false;
			
			if(!searchFeeSchedule(selenium, feeCodeData)){
				assertTrue(click(selenium, btnAddNewFeeSchedule),"Not able to click Add New in Fee Schedule", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				// --------------------------------------------------------------------//
				// Step-4:Create Adjustment                       //
				// --------------------------------------------------------------------//
				assertTrue(endToEndFeeSchedule(selenium, feeCodeData,account ),"Could not create the adjutment Reason", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				verifyFeeSchedule = true;
				
			}else{
				assertTrue(click(selenium,lnkEdit),"Could not clikc the edit button in fee schedule page", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(!verifyServiceCodeInFeeSchedule(selenium,feeCodeData)){
					waitForPageLoad(selenium);
					
					assertTrue(editEndToEndFeeSchedule(selenium, feeCodeData,account),"Could not create the fee Schedule", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					verifyFeeSchedule = true;
				}
			}
			
			//Verify Store Value
			if(verifyFeeSchedule){
				
				assertTrue(type(selenium,ajxSearch, feeCodeData.payer),"Could not enter the payer name",selenium , ClassName,MethodName);
				selenium.keyPress(ajxSearch, "\\13");				
				assertTrue(click(selenium,lnkEdit),"Could not clikc the edit button in fee schedule page", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);			
				
				if(!verifyServiceCodeInFeeSchedule(selenium,feeCodeData)){
					Assert.fail("Adjustment Details are not stored Properly");
				}
					
			}
			return true;
		}catch(Exception e){
				e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * function to verifyAllowedForPayerPayment
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 19,2014
	 */
	
	public boolean verifyAllowedForPayerPayment(Selenium selenium, BillingLib billData, HomeLib payerData, String account){
		try{
			int cAdjreason;
			String cAdjusmentValue ="";
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (account.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			}else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			String date = DateFormat.format(cal.getTime());
			
			selectValueFromAjaxList(selenium,ajxInsurance, billData.insurance);
			assertTrue(type(selenium, txtCheckAmount,billData.checkAmount),"Could not enter the check amount in payer payment page" , selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtCheck,billData.checkNumber),"Could not enter the check Number in payer payment page", selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium, txtdepositDate,date),"Could not enter the deposit Date in payer payment page", selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtTotalPaidAmount,billData.checkAmount),"Could not enter the Paid amount in payer payment page", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,adjustmentReason,"End Credit");
			
			assertTrue(type(selenium, txtClaimPatientSearch, billData.patientName),"Could not type patient id", selenium, ClassName, MethodName);
			
			selenium.keyPress(txtClaimPatientSearch, "\\13");
			waitForElement(selenium,lblPatientResult,10000);
			waitForElement(selenium,lblPatientResult,10000);
			
	 		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient", selenium, ClassName, MethodName);
	 		waitForElement(selenium,lblPatientResult,10000);
	 		waitForElement(selenium,lblPatientResult,10000);
			assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(billData.patientName.trim().toLowerCase(new java.util.Locale("en","US"))),"Search Results are not displayed for the patient", selenium, ClassName, MethodName);
			waitForElement(selenium,lblPatientResult,10000);
			waitForElement(selenium,lblPatientResult,10000);
			click(selenium,lblPatientResult);
			waitForPageLoad(selenium);
	
			int ajxCAdjcount =(Integer) selenium.getXpathCount("//input[@id='contractualAdjustment']"); 
			for(cAdjreason = 1;cAdjreason <= ajxCAdjcount;cAdjreason++){
				assertTrue(type(selenium,"xpath=(//input[@id='contractualAdjustment'])["+cAdjreason+"]",cAdjusmentValue),"Could not clear value",selenium, ClassName, MethodName);
				assertTrue(type(selenium,"xpath=(//input[@id='paidAmount'])["+cAdjreason+"]",billData.paidAmt1),"Could not Enter the value in paid text field",selenium, ClassName, MethodName);
			}
			assertTrue(click (selenium,btnPost),"Could not enter the post button in Batch Payment entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click (selenium,btnPostYes),"Could not enter the yes button in Batch Payment entry page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * function to verifyUpdateFeeInServiceCode
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 19,2014
	 */	
	public boolean verifyUpdateFeeInServiceCode(Selenium selenium,BillingLib billData, String account ){
		
		try{
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (account.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			}else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			String date = DateFormat.format(cal.getTime());
			
			
			assertTrue(type(selenium, txtCodeRangeFrom, "ETE007"),"Could not enter the Code Range From",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtCodeRangeTo, "ETE011"),"Could not enter the Code Range To",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtIncreaseValue, "100"),"Could not enter the amount",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxModiferType,"dollars");
			assertTrue(enterDate(selenium, txtEffectiveNewDates, date),"Could not type patient id",selenium, ClassName, MethodName);
			assertTrue(click (selenium,clkApply),"Could not click the apply button is update service code fees", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"overrideAll"),"could not click the over ride all link",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click (selenium,btnSaveUpdate),"Could not click the save button is update service code fees", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}return false;
	}
	
	/**
	 * function to deleteServiceCode
	 * @param  selenium
	 * @param  billingData
	 * @return boolean value
	 * @throws IOException
	 * @since  Mar 20,2014
	 */	
	public boolean deleteServiceCodeForEndToEndWorkFlow(Selenium selenium,BillingLib billData){
		try{
			assertTrue(type(selenium, txtSearchInServiceCode, billData.serviceCode1),"Could not enter the service code",selenium, ClassName, MethodName);
			selenium.keyPress(txtSearchInServiceCode, "\\13");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lblFilterResultInServiceCodeFirst),"Could not click the filter row",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnDeleteServiceCode),"Could not click Delete button in Service code page",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			return true;	
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deletePayer(Selenium selenium,HomeLib payerData){
		try{
			AbstractSystemSettingsTest systemData = new AbstractSystemSettingsTest();
			
			assertTrue(type(selenium,systemData.txtSearchBox,payerData.payerName ),"Could not enter the Start Date", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.keyPress(systemData.txtSearchBox, "\\13");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,systemData.btnDeletePayerAdmin),"Could not click the Delete in payer page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,systemData.btnYes),"Could not click the yes button in payer page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		return false;
	}
	
	/**
	 * deleteAllAdjustmentCodesExceptPort function To delete all AdjustmentReasons
	 * @throws IOException 
	 * 
	 * @since Jan 03, 2014
	 */

	public boolean deleteAllAdjustmentCodesExceptPort(Selenium selenium) throws IOException {
		waitForPageLoad(selenium);
		boolean adjustmentsDeleted = true;
		int count;		
		while ((Integer) selenium.getXpathCount(btnDelete) > 0) {
			count = (Integer) selenium.getXpathCount(btnDelete);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnDelete),
					"could not click delete button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnYesDeleteAdjustmentReason),
					"could not click delete button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			int counter = (Integer) selenium.getXpathCount(btnDelete);
			waitForPageLoad(selenium);
			if (count == counter) {
				adjustmentsDeleted = false;
				break;
			}

		}
		return adjustmentsDeleted;
		
	}


	/**
	 * function to verifyDuplicateServiceCode
	 * @param  selenium
	 * @param  billingData
	 * @return boolean value
	 * @throws IOException
	 * @since  Apr 01,2014
	 */	
	public boolean verifyDuplicateServiceCode(Selenium selenium, BillingLib billData,String account){
try{
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (account.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("dd/MM/YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			String date = DateFormat.format(cal.getTime());
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+billData.switchRole, "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			
			billData.renderingProvider = pName;
	
			assertTrue(selectValueFromAjaxList(selenium, ajxRenderingProvider,billData.renderingProvider),"Could not select the rendering provider", selenium, ClassName,MethodName);
			//assertTrue(selectValueFromAjaxList(selenium, ajxBillingProvider,chargeEntryData.billingProvider),"Could not select the billing provider", selenium, ClassName,MethodName);
			assertTrue(selectValueFromAjaxList(selenium, location,billData.location),"Could not select the Location", selenium, ClassName,MethodName);
			assertTrue(selectValueFromAjaxList(selenium, placeOfService,billData.placeOfService),"Could not select the place of service", selenium, ClassName,MethodName);
			if(account.equals(USAccount)){
			assertTrue(selectValueFromAjaxList(selenium, lstDiagnosis00,billData.diagnosisCode),"could not select the diagnosisi code", selenium, ClassName,MethodName);
			}
			
			if(account.equals(CAAccount)){
				assertTrue(enterDate(selenium, dateSLDateCA, billData.dateOfService1),
						"Adjustment Reason textbox not Present", selenium, ClassName,
						MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCodeCharge,billData.serviceCodeCA),"Could not select the service code", selenium, ClassName,MethodName);
				
			}
			else{
			assertTrue(enterDate(selenium, dateSLStartDate, billData.dateOfService1),
					"Adjustment Reason textbox not Present", selenium, ClassName,
					MethodName);
			assertTrue(enterDate(selenium, dateSLEndDate, billData.dateOfService2),
					"Adjustment Reason textbox not Present", selenium, ClassName,
					MethodName);
			assertTrue(selectValueFromAjaxList(selenium, ajxServiceCodeCharge,billData.serviceCode),"Could not select the service code", selenium, ClassName,MethodName);
			
			}
			assertTrue(type(selenium, txtUnits, billData.units),"Could not enter the units", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtFee, billData.fee),"Could not enter the Fee", selenium, ClassName,MethodName);
			selenium.typeKeys(txtFee, "\\b");
			waitForPageLoad(selenium);
			//assertTrue(enterDate(selenium,txtToDate,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
			
			//service code two
			assertTrue(click(selenium,btnAddNewServiceLine),"Could not click the Add New button in Charge Entry Page", selenium, ClassName, MethodName);
			if(account.equals(CAAccount)){
				assertTrue(enterDate(selenium,dateSLDateCA2,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode2,billData.serviceCodeCA),"Could not select the service code", selenium, ClassName,MethodName);
				
			}else{
			assertTrue(enterDate(selenium,txtFromDate2,date ),"Could not enter the From Date", selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, ajxServiceCode2,billData.serviceCode),"Could not select the service code", selenium, ClassName,MethodName);
			
			}
			if(account.equals(USAccount)){
				assertTrue(
						selectValueFromAjaxList(selenium, diagnosisCodeSL,
								billData.diagnosisCodeSL),
						"no able to add diagnosis code in service line", selenium, ClassName,
						MethodName);
				}else{
				assertTrue(
						selectValueFromAjaxList(selenium, diagnosisCodeSLCA,
								billData.diagnosisCodeSL),
						"no able to add diagnosis code in service line", selenium, ClassName,
						MethodName);
				}

			//assertTrue(type(selenium, txtUnits, claimData.units),"Could not enter the units", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtFee2, billData.fee),"Could not enter the Fee", selenium, ClassName,MethodName);
			selenium.typeKeys(txtFee2, "\\b");
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium, ajxPayToBox, "P"),
					"not able to add end date", selenium, ClassName,
					MethodName);
			
			assertTrue(
					selectValueFromAjaxList(selenium, ajxBillTo,
							"Patient"),
					"no able to add diagnosis code in service line", selenium, ClassName,
					MethodName);
			
			assertTrue(
					selectValueFromAjaxList(selenium, ajxPaymentProgram,
							"HCP - Health Claims Payment"),
					"no able to add diagnosis code in service line", selenium, ClassName,
					MethodName);
			
			assertTrue(click(selenium,btnPostChargeEntry),"Could not click the post button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(Exception e ){
			e.printStackTrace();
		}return false;
		
		
	}
	
	/**
	 * goToFeeSchedule function go To Statement Preferences
	 * 
	 * @since Apr 10, 2014
	 */
	public boolean goToStatementPreferences(Selenium selenium) {
		boolean returnValue = true;
		try {
			assertTrue(click(selenium, lnkSettings), "Navigation Failed",
					selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkBillingSettings),
					"could not click Billing Settings", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkStatementPreferences),
					"Could not click on Statement preferences link:", selenium,
					ClassName, MethodName);

			if (isElementPresent(selenium, btnDeactivateAutoGen) || isElementPresent(selenium, btnActivateAutoGen) ) {
				return returnValue;
			}
			else{
			    returnValue=false;
			}
			return returnValue;
		} catch (Exception e) {
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}
	
	  /**
     * verifyDefaultValueForMetaInformation function verify default values for
     * meta information
     * 
     * @since Apr 10, 2014
     */
    public boolean verifyDefaultValueForMetaInformation(Selenium selenium) {
		boolean returnValue = true;
		try {
		    assertTrue(!isChecked(selenium, chkIncludeInactiveSP), "Include Inactive patient check box is checked", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
	
		    assertTrue(!isChecked(selenium, chkInCollection), "Include In Collection check box is checked", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
	
		    assertTrue(!isChecked(selenium, chkIncludeDeceased), "Include Deceased check box is checked", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
	
		    assertTrue(!isChecked(selenium, chkSendStmtAftFullPay), "Send Statement check box is checked", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
	
		    assertTrue(!isChecked(selenium, chkShowChrgPaid), "Send Statement check box is checked", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
	
		    assertTrue(getValue(selenium, txtWaitDays).contains("28"), "Default Value for wait days is incorrect", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
	
		    assertTrue(getValue(selenium, txtMinPayment).contains("0.00"), "Default Value for Min Payment is incorrect", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
	
		    assertTrue(getValue(selenium, txtBalanceAtLeast).contains("5.00"), "Default Value for balance is incorrect", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
	
		    assertTrue(getValue(selenium, txtWriteOffBalance).contains("0.00"), "Default Value for balance is incorrect", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
			} catch (Exception e) {
			    e.printStackTrace();
			    returnValue = false;
		}
			return returnValue;
	   }

    /**
     * verifyDefaultValueForMetaInformation function verify default values for
     * meta information
     * 
     * @since Apr 10, 2014
     */
    public boolean verifyMetaInformation(Selenium selenium, BillingLib billingData) {
		boolean returnValue = true;
		try {
	
		    if (!isChecked(selenium, chkIncludeInactiveSP)) {
			assertTrue(click(selenium, chkIncludeInactiveSP), " could not check Include Inactive patient check box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    }
		    if (!isChecked(selenium, chkInCollection)) {
			assertTrue(click(selenium, chkInCollection), " could not check collection patient check box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    }
	
		    if (!isChecked(selenium, chkIncludeDeceased)) {
			assertTrue(click(selenium, chkIncludeDeceased), " could not check deceased patient check box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    }
	
		    if (!isChecked(selenium, chkSendStmtAftFullPay)) {
			assertTrue(click(selenium, chkSendStmtAftFullPay), " could not check send statement check box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    }
	
		    if (!isChecked(selenium, chkShowChrgPaid)) {
			assertTrue(click(selenium, chkShowChrgPaid), " could not check show charges check box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    }
	
		    assertTrue(type(selenium, txtMinPayment, billingData.minPayment), "Default Value for Min Payment is incorrect", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
	
		    assertTrue(type(selenium, txtBalanceAtLeast, billingData.balanceAtLeast), "Default Value for balance is incorrect", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
	
		    assertTrue(type(selenium, txtWriteOffBalance, billingData.writeOff), "Default Value for balance is incorrect", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
	
		    assertTrue(selectValueFromAjaxList(selenium, ajxAdminCode, billingData.adCode), "could not select payer", selenium, ClassName, MethodName);
		    assertTrue(click(selenium, btnNextWizard), "could not click on next button", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
		    
		    assertTrue(selenium.isTextPresent("Select fields you would like to include in all statements"), "could not select payer", selenium, ClassName, MethodName);
		
		} catch (Exception e) {
		    e.printStackTrace();
		    returnValue = false;
		}
		return returnValue;
	  }

    /**
     * deleteAllStatementCycle function to delete syayement cycle
     * @since Apr 11, 2014
     */
    public boolean deleteAllStatementCycle(Selenium selenium) {
	boolean returnValue = true;
	try {
	    int count = 0;
	    while (isElementPresent(selenium, btnDelete)) {
		assertTrue(click(selenium, btnDelete), "Yes button is not present", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnYesbutton), "Yes button is not present", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		count++;

		if (count > 15) {
		    break;
		}
	    }
	    return returnValue;
	} catch (Exception e) {
	    e.printStackTrace();
	    returnValue = false;
	}
	return returnValue;
    }
    
    /**
     * navigateToStatementCycle function to navigate statement cycle
     * @since Apr 11, 2014
     */
    public boolean navigateToStatementCycle(Selenium selenium) {
	boolean returnValue = true;
	try {
	    if (!isElementPresent(selenium, btnEdit)) {
		assertTrue(click(selenium, btnDeactivateAutoGen), "Could not find Activate button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	    }

	    assertTrue(click(selenium, btnEdit), "Could not find edit button", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    assertTrue(click(selenium, btnCircleStatementCycle), "Could not click format circle", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    assertTrue(selenium.isTextPresent("Below is a list of criteria for generating statements. To add a new criteria, click 'Add new.'"),
		    "Could not navigate to statement cycle", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    return returnValue;
	} catch (Exception e) {
	    e.printStackTrace();
	    returnValue = false;
	}
	return returnValue;
    }
    
    /**
     * navigateToDunningMessage function to navigate dunning message
     * @since Apr 11, 2014
     */
    public boolean navigateToDunningMessage(Selenium selenium) {
	boolean returnValue = true;
	try {
	    if (!isElementPresent(selenium, btnEdit)) {
		assertTrue(click(selenium, btnDeactivateAutoGen), "Could not find Activate button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	    }

	    assertTrue(click(selenium, btnEdit), "Could not find edit button", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    assertTrue(click(selenium, btnCircleDunningMessages), "Could not click format circle", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    assertTrue(selenium.isTextPresent("Below you can specify a custom message per dunning level to your patients that will appear on the statements "),
		    "Could not navigate to statement cycle", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    return returnValue;
	} catch (Exception e) {
	    e.printStackTrace();
	    returnValue = false;
	}
	return returnValue;
    }
    
    
    /**
     * verifyStatementHomeScreen function to verify statement home screen
     * @since Apr 11, 2014
     */
    public boolean verifyStatementHomeScreen(Selenium selenium) {
	boolean returnValue = true;
	try {
	    assertTrue(isElementPresent(selenium, btnWizardNext), "Wizard Next button is not present", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, btnWizardDone), "Wizard Done button is not present", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, btnWizardBack), "Wizard Back button is not present", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, btnAddStmtCycleInfo), "Add New button is not present", selenium, ClassName, MethodName);
	    return returnValue;
	} catch (Exception e) {
	    e.printStackTrace();
	    returnValue = false;
	}
	return returnValue;
    }
    
    /**
     * verifyDunningWizard function to verify statement home screen
     * @since Apr 11, 2014
     */
    public boolean verifyDunningWizard(Selenium selenium) {
	boolean returnValue = true;
	try {
	    assertTrue(isElementPresent(selenium, ajxBadDept), "Could not find bed dept", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, ajxCollection), "Could not find collection", selenium, ClassName, MethodName);

	    assertTrue(selenium.isTextPresent("Below you can specify a custom message per dunning level to your patients that will appear on the statements"),
		    "Could not find the text", selenium, ClassName, MethodName);

	    int count = (Integer) selenium.getXpathCount(txtDunningMsg);

	    int countNew = 10 - count;

	    for (int i = 0; i < countNew; i++) {
		assertTrue(click(selenium, btnAddStmtCycleInfo), "Add New button is not present", selenium, ClassName, MethodName);
	    }

	    assertTrue(!selenium.isTextPresent("Add"), "Could not find collection", selenium, ClassName, MethodName);

	    assertTrue(getValue(selenium, txtDunningMsg1).contains(dunningMsg1), "Default value is incorrect", selenium, ClassName, MethodName);
	    assertTrue(getValue(selenium, txtDunningMsg2).contains(dunningMsg2), "Default value is incorrect", selenium, ClassName, MethodName);
	    assertTrue(getValue(selenium, txtDunningMsg3).contains(dunningMsg3), "Default value is incorrect", selenium, ClassName, MethodName);
	    assertTrue(getValue(selenium, txtDunningMsg4).contains(dunningMsg4), "Default value is incorrect", selenium, ClassName, MethodName);
	    assertTrue(getValue(selenium, txtDunningMsg5).contains(dunningMsg5), "Default value is incorrect", selenium, ClassName, MethodName);
	    
	    assertTrue(click(selenium, btnWizardDone), "Wizard Done button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    assertTrue(isElementPresent(selenium, btnEdit), "Could not find collection", selenium, ClassName, MethodName);
	    
	    return returnValue;
	} catch (Exception e) {
	    e.printStackTrace();
	    returnValue = false;
	}
	return returnValue;
    }
    
    /**
     * verifyStatementAddWizard function to verify statement Add Wizard
     * @since Apr 11, 2014
     */
    public boolean verifyStatementAddWizard(Selenium selenium,BillingLib billingData ) {
	boolean returnValue = true;
	try {
	    assertTrue(click(selenium, btnAddStmtCycleInfo), "Add New button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    assertTrue(selenium.isTextPresent("You can add multiple cycles, one at a time. No overlaps are allowed."), "Could not navigate to statement cycle",
		    selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    assertTrue(isElementPresent(selenium, btnSave), "Save button is not present", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, btnCancel), "Cancel button is not present", selenium, ClassName, MethodName);

	    assertTrue(selenium.isTextPresent("Who?"), "Could not find the text", selenium, ClassName, MethodName);
	    assertTrue(selenium.isTextPresent("When?"), "Could not find the text", selenium, ClassName, MethodName);

	    //Verify Default Value
	    assertTrue(getValue(selenium, ajxPatientSelection).contains("All patients"), "Default Value is incorrect", selenium, ClassName, MethodName);
	    assertTrue(selectValueFromAjaxList(selenium, ajxPatientSelection, billingData.patientSelection), "could not select the option", selenium,
		    ClassName, MethodName);

	    assertTrue(selenium.isTextPresent("By patient last name"), "Could not find the text", selenium, ClassName, MethodName);

	    assertTrue(type(selenium, txtFromName, billingData.fromName), "could not type from name", selenium, ClassName, MethodName);
	    assertTrue(type(selenium, txtToName, billingData.toName), "could not type to name", selenium, ClassName, MethodName);

	    assertTrue(isElementPresent(selenium, rdoMonthly), "could not find monthly radio button", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, rdoWeekly), "could not find weekly radio button", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, rdoDaily), "could not find daily radio button", selenium, ClassName, MethodName);

	    assertTrue(isChecked(selenium, rdoWeekly), "weekly radio button is not checked", selenium, ClassName, MethodName);
	    
	    assertTrue(isChecked(selenium, chkMonday), "check box is not checked", selenium, ClassName, MethodName);
	    assertTrue(isChecked(selenium, chkTuesday), "check box is not checked", selenium, ClassName, MethodName);
	    assertTrue(isChecked(selenium, chkWednesday), "check box is not checked", selenium, ClassName, MethodName);
	    assertTrue(isChecked(selenium, chkThursday), "check box is not checked", selenium, ClassName, MethodName);
	    assertTrue(isChecked(selenium, chkFriday), "check box is not checked", selenium, ClassName, MethodName);
	    assertTrue(!isChecked(selenium, chkSaturday), "check box  not checked", selenium, ClassName, MethodName);
	    assertTrue(!isChecked(selenium, chkSunday), "check box not checked", selenium, ClassName, MethodName);
	    
	    if (isChecked(selenium, chkMonday)) {
		assertTrue(click(selenium, chkMonday), "Could not find check box", selenium, ClassName, MethodName);
	    }
	    if (isChecked(selenium, chkTuesday)) {
		assertTrue(click(selenium, chkTuesday), "Could not find check box", selenium, ClassName, MethodName);
	    }
	    if (isChecked(selenium, chkWednesday)) {
		assertTrue(click(selenium, chkWednesday), "Could not find check box", selenium, ClassName, MethodName);
	    }
	    if (isChecked(selenium, chkThursday)) {
		assertTrue(click(selenium, chkThursday), "Could not find check box", selenium, ClassName, MethodName);
	    }
	    if (isChecked(selenium, chkFriday)) {
		assertTrue(click(selenium, chkFriday), "Could not find check box", selenium, ClassName, MethodName);
	    }
	    if (isChecked(selenium, chkSaturday)) {
		assertTrue(click(selenium, chkSaturday), "Could not find check box", selenium, ClassName, MethodName);
	    }
	    if (isChecked(selenium, chkSunday)) {
		assertTrue(click(selenium, chkSunday), "Could not find check box", selenium, ClassName, MethodName);
	    }
	    
	    // Save with no check box is checked
	    
	    assertTrue(click(selenium, btnSave), "Save button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    assertTrue(selenium.isTextPresent("Occurring days must be selected at least one day"), "Could not find the text", selenium, ClassName, MethodName);
	    
	    //Save with Monthly
	    
	    assertTrue(click(selenium, rdoMonthly), "Monthly radio button is not checked", selenium, ClassName, MethodName);
	    
	    assertTrue(isElementPresent(selenium, rdoDayOfMonth), "could not find monthly radio button", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, rdoWeekOfMonth), "could not find weekly radio button", selenium, ClassName, MethodName);
	    
	    assertTrue(click(selenium, rdoDayOfMonth), "could not find monthly radio button", selenium, ClassName, MethodName);
	    assertTrue(selectValueFromAjaxList(selenium, ajxDateOfMonth,billingData.dom), "could not select dom", selenium, ClassName, MethodName);
	    assertTrue(type(selenium, txtInterval,billingData.interval), "could not type interval", selenium, ClassName, MethodName);
	    
	    assertTrue(click(selenium, btnSave), "Save button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    assertTrue(isElementPresent(selenium, lnkEdit), "could not find monthly radio button", selenium, ClassName, MethodName);
	    assertTrue(isElementPresent(selenium, btnDelete), "could not find weekly radio button", selenium, ClassName, MethodName);
	    
	    return returnValue;
	} catch (Exception e) {
	    e.printStackTrace();
	    returnValue = false;
	}
	return returnValue;
    }
    
    /**
     * verifyEditStatementCycle function to verify edit statement cycle
     * @since Apr 11, 2014
     */
    public boolean verifyEditStatementCycle(Selenium selenium,BillingLib billingData) {
	boolean returnValue = true;
	try {
	    assertTrue(click(selenium, lnkEdit), "could not find edit button", selenium, ClassName, MethodName);

	    assertTrue(getValue(selenium, ajxDateOfMonth).contains(billingData.dom), "Value is not getting displayed", selenium, ClassName, MethodName);
	    assertTrue(getValue(selenium, txtInterval).contains(billingData.interval), "Value is not getting displayed", selenium, ClassName, MethodName);
	    assertTrue(getValue(selenium, txtFromName).contains(billingData.fromName), "Value is not getting displayed", selenium, ClassName, MethodName);
	    assertTrue(getValue(selenium, txtToName).contains(billingData.toName), "Value is not getting displayed", selenium, ClassName, MethodName);

	    assertTrue(click(selenium, rdoWeekOfMonth), "could not find monthly radio button", selenium, ClassName, MethodName);
	    assertTrue(selectValueFromAjaxList(selenium, ajxRecurring, billingData.monthlyQualifier), "could not select dom", selenium, ClassName, MethodName);
	    assertTrue(selectValueFromAjaxList(selenium, ajxDaySelection, billingData.daySelect), "could not type interval", selenium, ClassName, MethodName);

	    assertTrue(click(selenium, btnSave), "Save button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    return returnValue;
	} catch (Exception e) {
	    e.printStackTrace();
	    returnValue = false;
	}
	return returnValue;
    }

    /**
     * verifyOverlapInStatementCycle function to verify overlap in statement cycle
     * @since Apr 11, 2014
     */
    public boolean verifyOverlapInStatementCycle(Selenium selenium,BillingLib billingData) {
	boolean returnValue = true;
	try {
	    assertTrue(click(selenium, btnAddStmtCycleInfo), "Add New button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    assertTrue(selectValueFromAjaxList(selenium, ajxPatientSelection, billingData.patientSelection), "could not select the option", selenium,
		    ClassName, MethodName);
	    
	    assertTrue(type(selenium, txtFromName, billingData.fromName), "could not type from name", selenium, ClassName, MethodName);
	    assertTrue(type(selenium, txtToName, billingData.toName), "could not type to name", selenium, ClassName, MethodName);
	    
	    //Verify Popup by saying no
	    assertTrue(click(selenium, btnWizardNext), "Wizard Next button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    assertTrue(click(selenium, btnNobutton), "no button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);  

	    assertTrue(click(selenium, rdoMonthly), "Monthly radio button is not checked", selenium, ClassName, MethodName);
	    
	    assertTrue(click(selenium, rdoWeekOfMonth), "could not find monthly radio button", selenium, ClassName, MethodName);
	    assertTrue(selectValueFromAjaxList(selenium, ajxRecurring,billingData.monthlyQualifier), "could not select dom", selenium, ClassName, MethodName);
	    assertTrue(selectValueFromAjaxList(selenium, ajxDaySelection,billingData.daySelect), "could not type interval", selenium, ClassName, MethodName);
	    
	    assertTrue(click(selenium, btnSave), "Save button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    //Verify overlap alert
	    assertTrue(selenium.isTextPresent("Overlaps with existing criteria"), "Alert Not Present", selenium, ClassName, MethodName);
	    
	    //Verify popup by saying yes
	    assertTrue(click(selenium, btnWizardNext), "Wizard Next button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    assertTrue(click(selenium, btnYesbutton), "Yes button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);  
	    
	    assertTrue(isElementPresent(selenium, ajxBadDept), "Navigation failed", selenium, ClassName, MethodName);
	    
	    assertTrue(click(selenium, btnWizardBack), "Wizard Back button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    return returnValue;
	} catch (Exception e) {
	    e.printStackTrace();
	    returnValue = false;
	}
	return returnValue;
    }

    /**
     * verifyCancel function to verify cancel
     * @since Apr 11, 2014
     */
    public boolean verifyCancel(Selenium selenium,BillingLib billingData) {
	boolean returnValue = true;
	try {
	    assertTrue(click(selenium, btnAddStmtCycleInfo), "Add New button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    assertTrue(click(selenium, btnCancel), "Cancel is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    assertTrue(click(selenium, btnNobutton), "no button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);  
	    
	    assertTrue(click(selenium, btnCancel), "Cancel is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    assertTrue(click(selenium, btnYesbutton), "Yes button is not present", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium); 
	    
	    assertTrue(isElementPresent(selenium, btnAddStmtCycleInfo), "Cancellation Failed", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);

	    return returnValue;
	} catch (Exception e) {
	    e.printStackTrace();
	    returnValue = false;
	}
	return returnValue;
    }
    
    /**
	 * function to verifyStatement generated
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Mar 13,2014
	 */
	
	public boolean verifyStatementGenerated(Selenium selenium, HomeLib PatientData,BillingLib billingData, String account) throws IOException{
		try{
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click error close button", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkUnprintedStatement),"Could not click Unprinted Statement in the home page", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
						
			assertTrue(type(selenium,ajxSearch,PatientData.lastName),"Could not type the provider", selenium, ClassName, MethodName);
			selenium.keyPress(ajxSearch, "\\13");
			waitForPageLoad(selenium);
		
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if (account.equalsIgnoreCase(CAAccount)) {
				DateFormat = new SimpleDateFormat("MMM dd, YYYY");
			} else {
				DateFormat = new SimpleDateFormat("MM/dd/YYYY");
			}
			String date = DateFormat.format(cal.getTime());
			String lblUnprinted = "//div[starts-with(@id,'statement')]";
		
			int count;
			int claimsCount = (Integer) selenium.getXpathCount(lblUnprinted);
		
			for(count = 1; count <=claimsCount; count++ ){
				if((getText(selenium,"xpath=(//div[starts-with(@id,'statement')])["+count+"]").toLowerCase().contains(PatientData.lastName.toLowerCase())
						&&(getText(selenium,"xpath=(//div[starts-with(@id,'statement')])["+count+"]").contains(date)))){
					return true;
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * function to navigate batch Eligibility
	 * @param selenium
	 * @throws IOException
	 * @since May 15,2014
	 */
	public boolean navigateToBatchEligibility(Selenium selenium) throws IOException {

		assertTrue(click(selenium, lnkSettings),
				"Could not click the quick action link", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);

		assertTrue(click(selenium, lnkBillingSettings),
				"Could not click the billing seting link", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		assertTrue(click(selenium, lnkBatchEligibility),
				"Could not navigate to batch eligibility section", selenium,
				ClassName, MethodName);
		waitForPageLoad(selenium);

		return true;
	}

	/**
	 * function to navigate to billing history
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Jan 27,2014
	 */
	public boolean createEndToEndPayerList(Selenium selenium,HomeLib payerData, String date, String account ) throws IOException{
		
		if(payerData.testCaseId.equals("TC_CP_027")){
			assertTrue(click(selenium,btnPatientOtherPayers),"Could not click the Others Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			for(int i =1;i<10;i++){
				selenium.focus(btnAddNewForOtherPayer);
				selenium.clickAt(btnAddNewForOtherPayer, "");
				selenium.keyPress(btnAddNewForOtherPayer, "\\13");
			    }
		
		}else{
			assertTrue(click(selenium,btnPatientMedicalPayers),"Could not click the Medical Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,btnAddNew),"Could not click the add new button Medical Payer", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		assertTrue(payerWithMandatory(selenium,payerData,date,account),"Add New Payer failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		return true;
	}
	
	/**
	 * function to navigate to billing history
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Jan 27,2014
	 */
	public boolean payerWithMandatory(Selenium selenium,HomeLib payerData, String date, String account){
		try {
		if(payerData.testCaseId.equals("TC_CP_027")){
			assertTrue(selectValueFromAjaxList(selenium,ajxOtherpayerSelect,payerData.payerName),"Could not select payer"+ payerData.toString(), selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxTypeOfCoverageSuggest,payerData.typeofCoverage),"Could not select Type of Coverage"+ payerData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtOtherPayerStartDate,date), "Could not enter start Date", selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxOtherPayerRelationShip,payerData.relationshipStatus),"Could not select Relationship Status"+ payerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, "xpath=(//a[contains(text(),'Save')])[4]"), "Could not click Save button" +  payerData.toString(), selenium, ClassName, MethodName);
			 
		}else{
			assertTrue(selectValueFromAjaxList(selenium,ajxPayerSelect,payerData.payerName),"Could not select payer"+ payerData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtPayerStartDate,date), "Could not enter start Date", selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxRelationShip,payerData.relationshipStatus),"Could not select Relationship Status"+ payerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnlnkSave), "Could not click Save button" +  payerData.toString(), selenium, ClassName, MethodName);
		}
			
			
			
			waitForPageLoad(selenium);
			click(selenium,btnOK);
		
		return true;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	/**
	 * createNewPatientWithMandatoryCAView
	 * function to create New Patient With Mandatory CA view
	 * @throws IOException 
	 * @since  	     Feb 09, 2012
	 */	
	public boolean createNewPatientWithMandatoryCAView(Selenium selenium, HomeLib patientData,String userAccount) throws IOException{
	boolean returnValue = false;
	try{
		waitForPageLoad(selenium);
		//selectValueFromAjaxList(selenium,ajxResponsbleProvider,patientData.responsibleProvider);
		assertTrue(type(selenium,txtLastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(), selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtFirstName,patientData.firstName),"Could not type the first Name : More Details"+patientData.toString(), selenium, ClassName, MethodName);
		
		assertTrue(enterDate(selenium, txtDOB, patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob, selenium, ClassName, MethodName);
		click(selenium,btnBack);
		if(selenium.isElementPresent(btnBack1))
		{
			assertTrue(click(selenium, btnBack1),"Could click back button, Expected value to be typed"+ patientData.dob,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}

		assertTrue(click(selenium,chkPremature),"Could not click prematurecheck box : More Details"+patientData.toString(), selenium, ClassName, MethodName);
		selectValueFromAjaxList(selenium,ajxPrematureDuration,patientData.duration);
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium,ajxStatus,patientData.status);
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium,ajxRelationSex,patientData.sex);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnSave1),"Could not click Save button More Dateils"+patientData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		returnValue = true;	
		waitForPageLoad(selenium);
		}
	catch(RuntimeException e) {
		e.printStackTrace();
		Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
	}
	return returnValue;
}
	
	/**
	 * function to navigate to view Chart page
	 * @param selenium
	 * @param billingData
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 27,2014
	 */
	
	public boolean navigateToViewChartByID(Selenium selenium,String patientID) throws IOException{
		
		assertTrue(navigateToPatientByPatientId(selenium, patientID),"Could not search the patient",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkViewChart),"Could not click the view chart link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(isElementPresent(selenium,lnkViewChart),"View Chart page is not getting displayed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	
		return true;
	}
 }