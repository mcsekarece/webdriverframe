package com.nexia.selenium.genericlibrary.clinicalsettings;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.sharedlibrary.AbstractTest;
import com.thoughtworks.selenium.Selenium;

public class AbstractClinicalSettings extends AbstractTest{
	//
	public String btnAddCustom ="createCustomTmplbtn";
	public String ajxSpecialitySuggest ="specialtySuggestBoxIdsuggestBox";
	public String lnkSettings ="link=Settings";
	//Encounter Template
	public String lnkReaction="reactionLink";
	public String chkfirst="1checkboxAllergyReaction";
	public String btnpopclose="multiSelectionCloseButton";
    public String ajxSeverity = "severitysuggestBox";
    public String btnNoDuplicate = "notDuplicateButton";
	public String lblWholeEncounterTemplateSummary ="//div[@class='settings-list-edit-delete']";
	public String lnkPractice="locationMenuHeader";
	public String lnkPractice1="//a[starts-with(@id,'practice')]";
	public String lnkEncounterTemplate="!encounterTemplates";
	public String lnkDeleteEncounterTemplate1="xpath=(//a[contains(text(),'Delete')])[2]";
	public String lnkAutomatedRecallList="!automatedRecallList";
	public String btnSectionSave="topSave";
	public String btntopsave="topSave";
	public String btnSave2="save";
	 public String lblWarningForLowLevel= "updateInteractionPanel";
	public String btnOption="xpath=(//button[@type='button'])[6]";
	public String OptionPop="css=div.popup-pointer.popup-pointer-bottom-right > div.popupContent";
	public String  radioEditComponenetName="name=occurs";
	public String txtEditName="css=input.text-box";
	public String btnOptionSave="css=div.popup-buttons > button.secondary-button";
	public String lblEncountertemplate="xpath=(//div[@id='templateFocusPanel'])[1]";
	public String lblEncountertemplate2="xpath=(//div[@id='templateFocusPanel'])[2]";
	public String ajxassociatedVisit="id=visitSuggestBox1suggestBox";
	public String btnAllergysave="saveAllergyButton";
	public String tbnEncounterTemplatedelete="deletetBtn";
	public String ajxspecialitySuugestbox  ="specialitysuggestBox";
	public String ajxVisittype ="visitSuggestBox1suggestBox";
	public String btnEditfreetext="titleText";
	public String btnDeleteSpeciality= "//a[starts-with(@id,'deletevisit')]";
	public String btnDeleteSpeciality1= "deletevisit1";
	public String btnAddnewSpeciality="//button[starts-with(@id,'addNewVisitList')]";
	public String btnAddNew="createCustomTmplbtn";
	public String lnkApplyExisting="applyExistingTemplate";
	public String lnkStartBlank="//div[@class='wizard-options-wrapper']/div[1]/a";
	public String txtTemplateName="templateName";
	public String lblTitle="title";
    public String txtAreaTemplateDescription="templateDescription";
	public String btnPreview="xpath=(//button[@type='button'])[1]";
	public String btnSaveEncounterTemp="id=save";
	public String btnCancelEncounterTemp="cancel";
	public String lnkDeleteEncounterTemplate="//a[contains(text(),'Delete')]";
	public String btnYesButton="yesButton";
	public String btnNoButton="noButton";
	public String btneyeOption="//button[@id='option3']";
	public String lblEncounterTemplateSummary="CustomEncounterTemplateEncounterTemplate";
	public String lnkExpand="//div[@class='chart-list-item']/div";
	public String lnkExpandEncounterTemplate1="xpath=(//div[@class='chart-list-item'])[2]/div";
	public String lnkExpandEncounterTemplate = "xpath=(//a[@class='chart-list-item-arrow'])[2]";
	public String ajxShowOutline="createdSuggestBoxsuggestBox";
	public String EncoEdit="editBtn";
	public String ajxFor="xpath=(//input[@id='templSuggestBoxsuggestBox'])[2]";
	public String txtSearch="id=search";
	public String chkIncludeInactive="includeInactivescheckbox";
	public String lnkEditForVisitSettings="xpath=(//div[@id='editDiv']/a)[1]";
	//FIXME MNT-1344
	public String btnAddNewUserDefined="xpath=(//button[@type='button'])[8]";
	public String btnEditComp="xpath=(//div[@id='editDiv']/a)[10]";
	public String chkSelectall="selectAllcheckbox";
	public String chkUserDefined1="//div[text()='User Defined']/parent::div/parent::div/div/div/span/input";
	public String txtUserDefinedDisplayAs1="xpath=(//input[@type='text'])[6]";
	public String txtUserDefinedDisplayAs2="xpath=(//input[contains(@id,'customComponentName')])[2]";
	public String txtUserDefinedDisplayAs3="xpath=(//input[contains(@id,'customComponentName')])[3]";
	public String txtUserDefinedDisplayAs4="xpath=(//input[contains(@id,'customComponentName')])[4]";
	public String btnSaveCustomSection = "link=Save";
	public String txtwidgettextarea="xpath=(//textarea [contains(@id,'freeTextdescription')])";
	public String btnValue="xpath=(//*[contains(@id,'numericWidgetvalue')])";
	public String lnkDeleteCustomSection="xpath=(//a[contains(text(),'Remove')])[3]";
	public String btnwidgtSave="css=div.settings-header-top-right > button.secondary-button.saveWidget";
	public String txtPastMedicalHistoryDisplayAs="//div[text()='Past Medical History']/parent::div/parent::div/div[3]/input";
	public String lblDisplayAsCheifComplient="css=span.gwt-RadioButton > label";
	public String lblDisplayAsAssesment="//div[text()='Assessments']/parent::div/parent::div/div[3]/div";
	public String chkReviewOfSystem="checkBox15checkbox";
	public String ajxSelectiontemp="templateSuggestBoxsuggestBox";
	public String btnPastMedicalOption="xpath=(//div[@id='btnDiv']/button)[2]";
	public String btnOptionPop="xpath=(//button[contains(@id,'option4')])";
	public String chkPEAudit="//tr[6]/td/div/div/div/div/div/span/input";
	public String chkPEPediatric="//div[text()='Physical Examination (Pediatric)']/parent::div/parent::div/div/div/span/input";
	public String lnkEditReviewOfSystem="xpath=(//div[@id='editDiv']/a)[5]";
	public String lnkEditAudlt = "xpath=(//a[contains(text(),'Edit')])[6]";
	public String btnSectionCacel="topCancel";
	public String chkEyes="//tr[2]/td/div/div/div/div/div/span/input";
	public String chkEars="//tr[3]/td/div/div/div/div/div/span/input";
	public String chkCardiovascular = "//tr[4]/td/div/div/div/div/div/span/input";
	public String chkRespiratory ="//tr[5]/td/div/div/div/div/div/span/input";
	public String chkGastrointestinal= "//tr[6]/td/div/div/div/div/div/span/input";
	public String chkGenitourinary = "//tr[7]/td/div/div/div/div/div/span/input";
	public String chkMusculoskeletal = "//tr[8]/td/div/div/div/div/div/span/input";
	public String chkSkin="//tr[9]/td/div/div/div/div/div/span/input";
	public String chkNeurologic = "//tr[10]/td/div/div/div/div/div/span/input";
	public String chkPsychiatric = "//tr[11]/td/div/div/div/div/div/span/input";
	public String chkHematologic = "//tr[12]/td/div/div/div/div/div/span/input";
	public String ajxSelectLibrary="xpath=(//input[contains(@id,'selectLibrarySuggest')])";
	public String txtUserDefinedName="xpath=(//input[contains(@id,'customComponentName')])";
public String chkQuestionWidget="ansChkBoxQueRenderDiv2";
	public String lnkdraganddrop3 = "//tr[2]/td/div/div/div/div/div[2]/div";
	public String lnkTemp="startBlankTemplate";

	public String lnkdraganddrop4 = "//tr[3]/td/div/div/div/div/div[2]";
	public String chkDisplayas="name=occurs";
	public String chkPastMEdical="xpath=(//input[contains(@id,'checkBox')])[2]";
	public String chkCheifCompl="xpath=(//input[contains(@id,'checkBox')])[3]";
	public String historyof="xpath=(//input[contains(@id,'checkBox')])[4]";
	public String Reviewsystems="xpath=(//input[contains(@id,'checkBox')])[5]";
	public String PhysicalExam1="xpath=(//input[contains(@id,'checkBox')])[6]";
	public String PhysicalExam2="xpath=(//input[contains(@id,'checkBox')])[7]";	
	public String Assessment="xpath=(//input[contains(@id,'checkBox')])[8]";
	public String txttepmplatepannel="previewPanelDiv";
	//#FIXME 
	public String lblCodingSystem="css=span.bold"; 
	public String lnkPracticePref="!practicePreferences"; 
	public String lnkClinicalSetting = "clinicalSettingsAction";

	public String chkSelectAll = "//span/input";
	public String lnkAddRestrictionEyes="xpath=(//a[contains(text(),'Click to add restriction')])[2]";
	public String ajxSexSuggestBox="xpath=(//input[@id='sexSuggestBoxsuggestBox'])[2]";
	public String ajxAgeSuggestBox="xpath=(//input[@id='ageSuggestBoxsuggestBox'])[16]";
	public String ajxAgeUnitSuggestBox="xpath=(//input[@id='ageUnitSuggestBoxsuggestBox'])[16]";
	public String txtAgeRestriction1="xpath=(//input[@type='text'])[98]";
	public String txtAgeRestriction2="xpath=(//input[@type='text'])[99]";
	public String lblMenuSummaryFirstEncounter="//ul[@class='encounter-structure-preview']";
	public String csspathsNotes[]={"css=input.gwt-TextBox","css=textarea.text-area","css=#suggestBox"};
	public String activeElementInPage="dom=document.activeElement";
	
	public String txtUserDefined = "//div[text()='User Defined']/parent::div/parent::div/div[3]/input";
	
	
	//ajxSex
	
	public String lnkdraganddrop1 = "//tr[2]/td/div/div/div/div/div[2]/div";
	public String lnkdraganddrop2 = "//tr[3]/td/div/div/div/div/div[2]/div";
	public String lblPreviewPopupContent="previewPanelDiv";
	public String btnApplyTemplate="link=Use this";
	public String lnkExpandAll1="link=Expand All";
	public String btnActivate="activateBtn";
	public String lnkClickInActive="xpath=(//div[@id='templateFocusPanel']/div)[2]";
	//Mu Measures
	public String lnkSwitchRole="css=#switchRoleAction > span.topMenuItemSpan.light";
	public String lnkMuMeasures="!qualityMeasurementMain";
	public String lnkUpdateResults="link=Update Results";
	
	public String btnCollapsTitle="//div[@id='collapsableTitleClinical summaries']/div[3]";
	public String btnCollapsTitle1="//div[@id='collapsableTitleIncorporate lab test results']/div[3]";
	public String btnCollapsTitle2="//div[@id='collapsableTitleElectronic copy of patient health information']/div[3]";
	public String btnCollapsTitle3="//div[@id='collapsableTitleVitals, BMI, Growth Charts']/div[3]";
	public String btnaddNote="addNote";
	public String btnSave="saveBtn";
	public String btnPrint="link=Print/Send";
	public String btnBack="back";
	public String inkUnSignedEnCounterAction="//div[2]/div/div[2]/table/tbody/tr[1]/td[2]/div/div";
	public String txtdeleteReason = "deleteReason";
	public String btnDeleteReasonBox ="//button[@id='deleteReason']";
	public String btnBack1="backButton";
	public String btnPatientSave="saveButton";
	public String btnAdd="add";
	public String btnYes="yesButton";
	
	public String lnkMandatoryField="!adminMandatoryUserField";
	public String lnknewPatientAction="newPatientAction";
	public String lnknewPatientAction1="css=#newPatientAction > span.actionItemSpan";
	public String lnkShowRecentPatient="link=Show recent patients";
	public String lnkCMSinfo="link=Click here to visit the CMS site for more information";
	public String lnkMedicare="link=Medicare";
	public String lnkExpandAll="link=Expand all";
	public String lnkNewEncounterLink1="beginNewEncounter";
	public String lnkLabOrderLink="//img[@title='Order New Labs']";
	public String lnkPatientChart="css=span.topMenuItemSpan.light";
	public String lnkExportChart="css=#patientOptionsExportChart > span.topMenuItemSpan.light";
	public String lnkClinicalList="clinicalListsAction";
	public String lnkVitals="link=VITALS";
	public String lnkTemplateName="xpath=(//div[@id='templateFocusPanel']/div/div)[3]";
	public String lnkTemplateDescription="xpath=(//div[@id='templateFocusPanel']/div/div)[4]";
	
	
	
	
	public String ajxAllergySuggestBox="searchAllergyTextBox";
	public String ajxpefrDescription="pefrDescriptionSuggestBoxsuggestBox";
	public String ajxrespiratoryRate="respiratoryRateDescriptionSuggestBoxsuggestBox";
	public String ajxtempLoc="temperatureLocationSuggestBoxsuggestBox";
	public String ajxbloodSugarUnit="bloodSugarUnitSuggestBoxsuggestBox";
	public String ajxtempUnit="temperatureUnitSuggestBoxsuggestBox";
	public String ajxhight="heightSuggestBoxsuggestBox";
	public String ajxweight="weightSuggestBoxsuggestBox";
	public String ajxposition="positionSuggestBoxsuggestBox";
	public String ajxlimb="limbSuggestBoxsuggestBox";
	public String ajxcuff="cuffSizeSuggestBoxsuggestBox";
	public String ajxrhythm="rhythmSuggestBoxsuggestBox";
	public String ajxdescription="descriptionSuggestBoxsuggestBox";
	public String ajxWaist="waistSuggestBoxsuggestBox";
	public String ajxProviderSuggestBox="providerSuggestBoxIdsuggestBox";
	public String ajxSuggestBox="suggestBox";
	public String ajxSuggestBoxOption="//div[6]/div/div/div/div/div";
	public String ajxSuggestBoxOption1="//div[4]/div/div/div/div/div/span";
	public String ajxPrematureDuration="prematureDurationSuggestBoxsuggestBox";
	public String ajxSex="sexSuggestBoxsuggestBox";
	public String ajxPrematureMeasurement="prematureMeasureUnitSuggestBoxsuggestBox";
	public String ajxStatus="statusSuggestBoxsuggestBox";
	public String ajxValue="currentItem_2";
	public String	btnsearch="xpath=(//a[@id='searchMagnifier'])[2]"; 
	public String chkprematurecheckbox="prematurecheckbox";
	public String chkIncludeInactivecheckbox="includeInactivecheckbox";
	
	public String txthieghtInFeet="xpath=(//input[@type='text'])[6]";
	public String txthieghtInCm="xpath=(//input[@type='text'])[12]";
	public String txtweight="xpath=(//input[@type='text'])[14]";
	public String txtsystolicRate="xpath=(//input[@type='text'])[26]";
	public String txtdiastolicRate="xpath=(//input[@type='text'])[27]";
	public String txtbPM="xpath=(//input[@type='text'])[32]";
	public String txtWaist="xpath=(//input[@type='text'])[18]";
	public String txtTemp="xpath=(//input[@type='text'])[35]";
	public String txtBloodSugar="xpath=(//input[@type='text'])[38]";
	public String txtRepository="xpath=(//input[@type='text'])[40]";
	
	public String txtOxegenSaturation="xpath=(//input[@type='text'])[42]";
	public String txtpEFR="xpath=(//input[@type='text'])[43]";
	public String txtDate="css=input.gwt-DateBox";
	public String txtFromDate="qualityMeasuresFromDate";
	public String txtToDate="qualityMeasuresToDate";
	public String txtNoteDate="noteDate";
	public String txtNote="note";
	public String txtLastName="lastName";
	public String txtFirstName="firstName";
	public String txtDob="dob";
	
	public String lblShowMoreDetails="//div[16]/div";
	public String lblNoteTitle="css=span.title";
	public String lblAlert="css=div.large.dark";
	public String lblAlergy="//div[@id='AllergyList']/table/tbody/tr/td[4]/div/a";
	public String lblMandatoryField="//div[@id='adminMandatoryUserFieldList']/table/tbody/tr/td[2]/div/a";
	public String lblRecentPatient="//div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div/span[2]";
	public String lblMeasureInfo="css=div.listSection.italic";
	public String lblResultList2="//div[@id='collapsableTitleActive medications list']/div[3]";
	public String lblResultList3="//div[@id='collapsableTitleActive medications allergy list']/div[3]";
	public String lblResultList1="//div[@id='collapsableTitleUp-to-date problem list']/div[3]";//"//span/div/div[3]";
	public String lblResultList4="//div[@id='collapsableTitleRecord demographics']/div[3]";
	public String lblResultList5="//div[@id='collapsableTitlePatient-specific education']/div[3]";
	public String lblResultList9="//div[@id='collapsableTitleVitals, BMI, Growth Charts']/div[3]";
	public String lblResultList10="//div[@id='collapsableTitleRecord smoking status']/div[3]";
	public String lblResultList7="//div[@id='collapsableTitleCPOE']/div[3]";
	public String lblResultList12="//div[@id='collapsableTitleElectronic copy of patient health information']/div[3]";
	public String lblResultList6="//div[@id='collapsableTitleTimely Access']/div[3]";
	public String lblResultList13="//div[@id='collapsableTitleClinical summaries']/div[3]";
	public String lblResultList14="//div[@id='collapsableTitleMedication reconciliation']/div[3]";
	public String lblResultList8="//div[@id='collapsableTitleGenerate AND transmit eRx']/div[3]";
	public String lblResultList11="//div[@id='collapsableTitleIncorporate lab test results']/div[3]";
	
	public String lblMeasureInfo2="//tr[2]/td/div/span/div/div[4]";
	public String lblMeasureInfo3="//tr[3]/td/div/span/div/div[4]";
	public String lblMeasureInfo1="//span/div/div[4]";
	public String lblMeasureInfo4="//tr[4]/td/div/span/div/div[4]";
	public String lblMeasureInfo5="//tr[5]/td/div/span/div/div[4]";
	public String lblMeasureInfo9="//tr[9]/td/div/span/div/div[4]";
	public String lblMeasureInfo10="//tr[10]/td/div/span/div/div[4]";
	public String lblMeasureInfo7="//tr[7]/td/div/span/div/div[4]";
	public String lblMeasureInfo12="//tr[12]/td/div/span/div/div[4]";
	public String lblMeasureInfo6="//tr[6]/td/div/span/div/div[4]";
	public String lblMeasureInfo13="//tr[13]/td/div/span/div/div[4]";
	public String lblMeasureInfo14="//tr[14]/td/div/span/div/div[4]";
	public String lblMeasureInfo8="//tr[8]/td/div/span/div/div[4]";
	public String lblMeasureInfo11="//tr[11]/td/div/span/div/div[4]";
	
	public String lbltargetLevel2="//tr[2]/td/div/span/div/div[2]";
	public String lbltargetLevel3="//tr[3]/td/div/span/div/div[2]";
	public String lbltargetLevel1="//span/div/div[2]";
	public String lbltargetLevel4="//tr[4]/td/div/span/div/div[2]";
	public String lbltargetLevel5="//tr[5]/td/div/span/div/div[2]";
	public String lbltargetLevel9="//tr[9]/td/div/span/div/div[2]";
	public String lbltargetLevel10="//tr[10]/td/div/span/div/div[2]";
	public String lbltargetLevel7="//tr[7]/td/div/span/div/div[2]";
	public String lbltargetLevel12="//tr[12]/td/div/span/div/div[2]";
	public String lbltargetLevel6="//tr[6]/td/div/span/div/div[2]";
	public String lbltargetLevel13="//tr[13]/td/div/span/div/div[2]";
	public String lbltargetLevel14="//tr[14]/td/div/span/div/div[2]";
	public String lbltargetLevel8="//tr[8]/td/div/span/div/div[2]";
	public String lbltargetLevel11="//tr[11]/td/div/span/div/div[2]";
	public String lblResultlabel="//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr/td[2]/div/div/div/div[7]";
	
	public String lblVitalsEntry="//div[9]/div/div[2]/div/div";
	public String lblVitalsEntry1="//div[6]/table/tbody/tr[2]/td[2]/div/div/div[3]/div/div/div/div";
	public String lblExpandEncounterTemplate="xpath=(//div[@class='chart-list-item'])[2]";
	//Lab report
	public String rdoPartial = "//span[2]/input";
	public String btnSign="sign";
	public String btnBeginEncounter = "BeginEncounterButton";
	public String lnkStartNewWncouter = "beginNewEncounter"; 
	public String txtEncouDate= "dateField";
	public String lblPatientInfo = "patientInfoWidget";
	public String btnCancel = "cancel";
	public String btnErrorClose="errorCloseButton";
	public String btnSaveButton = "saveNewLabs";
	public String btnDeleteReasonButton = "//button[@id='deleteReason']";
	public String btnEnterData = "//div[3]/a";
	public String btnOkButton="okButton";
	public String btnAddTestResult="addTestResult";
	public String btnLabSign="signNewLabs";
	
	public String lnkPatientOptionsLink = "link=Patient Options";
	public String lnkActionsLink = "link=Actions";
	public String lnkSummaryLabLink = "!chartLabReportsFlowSheet";
	public String lnkLabReportLink = "css=#patientOptionsManualEntry > span.topMenuItemSpan.light";
	public String lnkPrescribeLink ="patientOptionsPrescribeMedication";
	public String lnkAddNewComponent="addNewComponent";
	public String lnkEditDefaultTemp="xpath=(//input[contains(@id,'selectLibrarySuggest')])[1]";
	
	public String ajxLabProvider = "receivingProviderSuggestsuggestBox";
	public String ajxtoProvider ="orderingProviderSuggestsuggestBox";
	public String ajxLabName = "reportingLabSuggestsuggestBox";
	public String ajxLabTestName ="testNameSuggestsuggestBox";
	public String ajxLabTestName1 = "//div[2]/div[2]/div/div[2]/div/div[2]/div/input";
	public String ajxLabTestName2 ="labTestNameSuggestBox";
	public String ajxSendTo ="xpath=(//input[@id='suggestBox'])[2]";
	
	public String txtaccNumber = "//div[2]/input";
	public String txtCdate = "collectionDateBox";
	public String txtCtime = "timeTextBox";
	public String txtNotes =  "labNotes";
	public String txtResult = "resultTextBox";
	public String txtLow = "lowTextBox";
	public String txtHigh = "highTextBox";
	public String txtUnits = "unitsTextBox";
	public String txtComment ="labComments";
	public String txtResult1 ="//div[2]/div[2]/div[2]/div[2]/input";
	public String txtLow1 = "//div[2]/div[2]/div[3]/div[2]/input";
	public String txtHigh1 = "//div[2]/div[2]/div[3]/div[3]/input";
	public String txtUnits1 = "//div[2]/div[2]/div[3]/div[4]/input";
	public String txtComment1 = "//div[2]/div[2]/div[4]/div[2]/textarea";
	public String txtComments="css=textarea.width370pxImportant.height50";
	
	public String chkAbnormal="//div[5]/span/input";
	
	public String lblAbnormalLabel = "//td/span";
	
	public String btnDeletelabReport = "//body/div[4]/div/div/div";
	public String btnSave1="save";
	
	/*public String DeleteTestResult = "//div[2]/div/div[2]/div/span/button";
	
	public String SignedRecord="//div[2]/table/tbody/tr/td/div/table/tbody/tr/td[2]/span";
	public String Error="css=li > div";
	
	public String LabOrderLink="//img[@title='Order New Labs']";
	public String EncounterChoosePanel="css=div.pickupEncounterPanel.zIndex1000";
	public String NewEncounterLink1="beginNewEncounter";
	
	public String NewEncounterLink2="//div[5]/div/div/div[2]/div[2]";
	public String NewEncounterLink3="//body/div[4]/div/div/div[2]/div[2]";
	public String ShowFilter="suggestBox";
	public String LabSummary="css=div.fullWidth";
	
	public String CancelReport = "sign";
	public String LabReportEntryOnSummery = "css=td.fullWidth";
	public String rdoPartial = "//span[2]/input";
	public String LabReportEntry = "css=b";
	public String LabResltCheckBox ="//span/input";
	public String LabResltCheckBox1="//div[2]/div/div/span/input";
	public String LabGraph ="graph";
	public String LabTestName2 ="//div[2]/div[2]/div/div[2]/div";
	public String LabReportChart ="chart";
	
	public String CancelGraph="cancel";
	public String lnkBeginEncounterAction="actionAnchorEncounter";
	public String CommentIcon="//div[6]/a";
	public String CommentText="//div[8]/div/blockquote/div/textarea";
	public String ShowAllComments="link=Show all comments";
	public String HideAllComments="link=Hide all comments";
	public String DeleteReports="css=#deleteLabReports > span.topMenuItemSpan.light";
	public String HideShow="//a/table/tbody/tr/td[2]";
	public String SpecimenShowHide="//div[2]/div/table/tbody/tr/td/a/table/tbody/tr/td[2]";
	public String LabReportDetails1="//div[7]/table/tbody/tr[2]/td/div/div";
	public String LabReportDetails2="//div/div/div[2]/div[2]/div";
	public String LabReportDetails3="//div[8]/div/div/div/div[5]/div";
	public String LabHistory="//div[8]/div/div/div/div[5]/div";
	
	
	public String ReportCommentsIcon = "link=Add Comments";
	public String ReportCommentsText = "//blockquote/div/textarea";
	public String SaveComments = "link=Save";
	public String CancelComments1 = "link=Cancel";
	public String HideComments = "link=Hide Comment";
	public String EditComments = "link=Edit";
	public String ViewHistory = "link=View History";
	public String ShowComments = "link=Show Comments";
	public String CancelComments2 = "//div[3]/div/a";
	public String HistoryOfComments = "css=blockquote.commentsBubble";
	public String DateForComments = "//blockquote/div[2]/div/div";*/
	
	//Encounter
	public String EditComments = "link=Edit";
	public String lnkChartLabFlowSheet="!chartLabReportsFlowSheet";
	public String lnkLabtab ="id=ListViewTab";
	public String lnkAdd="link=Add";
	
	public String lnkencounterTab ="!chartEncounters";
	public String lnkOptions = "//div[2]/div[2]/div/div[2]/table/tbody/tr/td[2]/div/div";
	public String lnkDelete = "//body/div[5]/div/div/div";
	public String txtDeleteReason = "deleteReason";
	public String txtEncounterDate="css=input.gwt-DateBox";
	public String btnDeleteContinue = "//button[@id='deleteReason']";
	public String btnDelete ="//body/div[5]/div/div/div";

	//Interaction Warning Magement
	public String lnkChartSummary="!chartSummary";
	public String lnkAllergy="link=Allergies";
	public String lnkEdit="link=Edit";
	public String lnkEncounterTemplateEdit1="xpath=(//a[contains(text(),'Edit')])[2]";
	public String lnkQuickLink ="link=Quick Actions";
	public String lnkClinicalSettingsLink = "clinicalSettingsAction";
	public String lnkSystemSettingsLink = "css=#systemSettingsAction > span.actionItemSpan";
	public String lnkShowMoreLink="showMoreActions";
	public String lnkInteractionWarningLink = "!interactionWarnings";
	public String lnkTopMenuHeader = "username";
	public String lnkMySettingsLink = "mySettingsAction";
	public String lnkMySettingsInteractionWarningLink = "!mySettingInteractionWarnings";
	public String lnkPatientOptions = "link=Patient Options";
	public String lnkPatientOptionInteracWaringLink = "patientOptionsInteractionWarnings";
	public String lnkCustomTextInEdit="xpath=(//input[contains(@id,'customComponentName')])[1]";
	public String lnkSave="//a/span";
	public String lnkEncounterList="xpath=(//div[contains(@id,'savedBy')])[1]";
	public String lnkEncounterListEdit="xpath=(//div[contains(@id,'savedBy')])[2]";
    public String lnkPatientSearchBox="searchPatientBox";
	
	
	public String rdoSevereOnly = "severeradio";
	public String rdoHighToSevere = "highradio";
	public String rdoModerateToSevere = "moderateradio";
	public String rdoMildToSevere = "mildradio";
	public String btnEditSave = "editWarningButton";
	//public String btnWarningSave = "css=button.primary-button";
	public String btnWarningSave = "//button[contains(text(),'Save')]";
	public String btnChangeMedication="changeMedicationID";
	public String btnCancelButton="cancelButton";
	public String btnOverride = "overrideButton";
	public String btnCancelWarning = "//button[contains(text(),'Cancel')]";
	public String btnSaveOnPatientOptions = "css=span.buttons > button.gwt-Button";
	public String btnWheelIcon ="updateInteractionLevel";
	public String btnCloseButton="css=a.absolute.right10 > img";
	public String lblWarningOnSummary="css=span.red";
	public String lblPatientWarningonSummary="//div[5]/table/tbody/tr[2]/td[2]/div/div/div/div/div[2]";
	public String lblCreatedAllergy="//div[@id='AllergyList']/table/tbody/tr/td/div/a";
	public String lblPrescribeInteractionWarning="css=div.GKPPEI2BEJ";
	public String lblWarningForHighLevel= "//div[5]/div/div/div[4]/div";
	public String lblForSavePrescribeMedWarning= "//body/div[5]/div/div/div[3]/div/span";
	public String lblForCancelPrescribeMedWarning= "css=span.red.bold";
	public String lblForDefaultWarning= "css=span.red.bold";

	public String lblFoodAndDrinkInteractionWarning="css=div.foodAndDrinkInteractionImg";
	public String lblMedicationName="css=div.inlineBlock.larger";
	public String lblWarninglabel="css=div.inlineBlock > span.red.bold";
	
	public String ajxProvider="providerListSuggestBoxsuggestBox";
	public String ajxLoaction="locationListSuggestBoxsuggestBox";
	public String ajxDrugsList="drugsQuicklistBox";
	
	public String btnSaveOnPatientOptions1 = "css=button.primary-button";
	public String btnEditWarning = "editWarningButton";
	
	public String templateName="templateSuggestBoxsuggestBox";
	public String templateName2="xpath=(//input[contains(@id,'selectLibrarySuggest')])[2]";
	public String templateName3="xpath=(//input[contains(@id,'selectLibrarySuggest')])[3]";
	public String templateName4="xpath=(//input[contains(@id,'selectLibrarySuggest')])[4]";

	public String lnkEncounterAction = "actionAnchorEncounter";
	public String txtCustomSectionLAbel="xpath=(//input[starts-with(@id,'customComponentName')])";
    public String ajxTemplateType="xpath=(//input[starts-with(@id,'selectLibrarySuggest')])";
    public String btnSelectfronlibrary="xpath=(//button[contains(@id,'selectLibrary')])";
    public String lblTemplate1="templateFocusPanel";

		public String lnkRegisterPatient="newPatientAction";




		public String SectionName=null;
		public String SectionDescription=null;
		public String Speciality=null;
			public String WidgetRow1=null;
		public String  WidgetRow2=null;
		public String  WidgetRow3=null;
		public String  WidgetRow4=null;
		//Visit Section
		
				public String lnkFreeTextLabelwid="addButton-Free text";
				public String lnkNumericWidget="addButton-Numeric Input";
				public String lnkQuestionWidget="addButton-Question";
				public String lnkTitleWidget="addButton-Title";
				
				
				//FIXME EMR-1316
				public String txtWidgetRow1="widget_0";
				public String txtWidgetRow2="widget_1";
				public String txtWidgetRow3="widget_2";
				public String txtWidgetRow4="widget_3";
				public String txtWidgetRow5="widget_4";
				public String txtWidgetRow6="widget_5";
				public String txtWidgetRow7="widget_6";
				
				public String txtFreeTextLable="titleText";
				public String btnRemove="xpath=(//a[contains(text(),'Remove')])[10]";	
				public String btnSaveWidget="save";
				public String txtNumericLabel="titleText";
				public String ajxMumericFormat="numberFormatsuggestBox";
				
				public String txtNumericMin="minValue";
				public String txtNumericMax="maxValue";
				public String txtNumericUnit="//div[5]/div[2]/input";
				public String ajxNumericDefault="xpath=(//input[@id='suggestBox'])[3]";
				public String btnNumericWidgetSave="save";
				
				public String lnkAddWidget=" addAnchor_Freetext1";
				public String txtEditWidget = "editAnchor_Freetext1";
				
				public String txtQuestionLabel="labelText";
				public String txtQuestionTotalAnswer="totalAns";		
				public String ajxQuestionDefault="defaultAnssuggestBox";
				public String btnQuestionsave="save";
				public String btnQuestionsave1="save";
				public String txtTitlelabel="titleText";
				public String txtQuestionAns1="ans_1";
				public String txtQuestionAns2="ans_2";
				public String txtQuestionAns3="ans_3";
				public String txtQuestionAns4="ans_4";
				public String txtQuestionAns5="ans_5";
				public String txtCustomCompName="xpath=(//input[contains(@id,'customComponentName')])";
				public String lblTemplate="templateFocusPanel";
				public String btnComponentEdit="xpath=(//a[contains(text(),'Edit')])[10]";
		//FIXME EMR-1045
		public String btnAddcustomSection="addNew";
		public String btnusethis="useBtn";
		public String btnCustomComponenetEdit="xpath=(//a[contains(text(),'Edit')])[10]";
		public String btnEncountreSave="//a[@id='saveEncounter']/";
		public String continueButton="link=Continue";
		public String btnVisitysectionEdit="editBtn";
		public String txtWidgetRow8="//tr[8]/td/div";
		public String txtWidgetRow9="xpath=(//div[contains(@id,'widget')])[9]";
		public String btnDeleteCustomComponenet="xpath=(//a[contains(text(),'Remove')])[10]";
		public String lblCustomVisitSection="xpath=(//span[@id='label'])[4]";
		public String txtWidgetRow10="//tr[10]/td/div";
		
		//Tickets in Review
		public String txtWidgetRow11="xpath=(//div[contains(@id,'widget')])[11]";
		
		public String PendingSignOffLabel="xpath=//div[contains(@id,'pendingCell')]";
		public String lnkLocationMenuHeader = "locationMenuHeader";
		public String lnkCancelEncounterTemp="//a[@id='cancelEncounter']/span";
		public String lnkAddResources="addResources";
		
		//Need to check with Indu on this
		public String chkBoxEncounterType="xpath=(//input[contains(@id,'checkBox')])[1]";
		public String chkBoxLanguage="xpath=(//input[contains(@id,'checkBox')])[2]";
		public String chkBoxContactMode="xpath=(//input[contains(@id,'checkBox')])[3]";
		public String chkBoxLocation="xpath=(//input[contains(@id,'checkBox')])[5]";
		public String chkBoxTime="xpath=(//input[contains(@id,'checkBox')])[7]";
		public String chkBoxDuration="xpath=(//input[contains(@id,'checkBox')])[8]";
		
		public String lnkOptionVisitSettings="xpath=(//button[contains(@id,'option')])[1]";
		public String lnkOptionCheifComplaint="xpath=(//button[contains(@id,'option')])[3]";
		public String chkBoxPastMedicalHistory="xpath=(//input[contains(@id,'checkBox')])[2]";
		public String lnkOptionPastMedicalHistory="xpath=(//button[contains(@id,'option')])[2]";
		public String chkBoxHistoryOfPresentIllness="xpath=(//input[contains(@id,'checkBox')])[4]";
		public String lnkOptionHistoryOfPresentIllness="xpath=(//button[contains(@id,'option')])[4]";
		public String chkBoxReviewOfSystems="xpath=(//input[contains(@id,'checkBox')])[5]";
		public String lnkOptionReviewOfSystems="xpath=(//button[contains(@id,'option')])[5]";
		public String chkBoxPhysicalExamAdult="xpath=(//input[contains(@id,'checkBox')])[6]";
		public String lnkOptionPhysicalExamAdult="xpath=(//button[contains(@id,'option')])[6]";
		public String chkBoxPhysicalExamPediatric="xpath=(//input[contains(@id,'checkBox')])[7]";
		public String lnkOptionPhysicalExamPediatric="xpath=(//button[contains(@id,'option')])[7]";
		public String chkBoxAssesments="xpath=(//input[contains(@id,'checkBox')])[8]";
		public String lnkOptionAssesments="xpath=(//button[contains(@id,'option')])[8]";
		public String chkBoxRecommendations="xpath=(//input[contains(@id,'checkBox')])[9]";
		public String lnkOptionRecommendations="xpath=(//button[contains(@id,'option')])[9]";
		public String widgetLink1="xpath=(//div[contains(@id,'widget')])[1]";
		public String widgetLink2="xpath=(//div[contains(@id,'widget')])[2]";
        
        public String widgetLink3="xpath=(//div[contains(@id,'widget')])[3]";
		public String widgetLink4="xpath=(//div[contains(@id,'widget')])[4]";
		
		public String lnkEditPasMedicalHistory="xpath=(//div[@id='editDiv']/a)[2]";
		public String chkBoxAllergies="xpath=(//input[contains(@id,'checkBox')])[1]";
		public String chkBoxProblemList="xpath=(//input[contains(@id,'checkBox')])[2]";
		public String chkBoxSurgicalHistory="xpath=(//input[contains(@id,'checkBox')])[3]";
		public String chkBoxMedication="xpath=(//input[contains(@id,'checkBox')])[4]";
		public String chkBoxImmunizations="xpath=(//input[contains(@id,'checkBox')])[5]";
		public String chkBoxInjections="xpath=(//input[contains(@id,'checkBox')])[6]";
		public String chkBoxSocialHistory="xpath=(//input[contains(@id,'checkBox')])[7]";
		public String chkBoxFamilyHistory="xpath=(//input[contains(@id,'checkBox')])[8]";
		public String chkBoxObstetHistory="xpath=(//input[contains(@id,'checkBox')])[9]";
		
		public String lnkEditReviewOfSystems="xpath=(//div[@id='editDiv']/a)[5]";
		public String chkBoxConsSympotms="xpath=(//input[contains(@id,'checkBox')])[1]";
		public String chkBoxEyes="xpath=(//input[contains(@id,'checkBox')])[2]";
		public String chkBoxEars="xpath=(//input[contains(@id,'checkBox')])[3]";
		public String chkBoxCardioVascular="xpath=(//input[contains(@id,'checkBox')])[4]";
		public String chkBoxRespiratory="xpath=(//input[contains(@id,'checkBox')])[5]";
		public String chkBoxGastro="xpath=(//input[contains(@id,'checkBox')])[6]";
		public String chkBoxzGenito="xpath=(//input[contains(@id,'checkBox')])[7]";
		public String chkBoxMusculos="xpath=(//input[contains(@id,'checkBox')])[8]";
		public String chkBoxIntugumentry="xpath=(//input[contains(@id,'checkBox')])[9]";
		public String chkBoxNeurological="xpath=(//input[contains(@id,'checkBox')])[10]";
		public String chkBoxPsychiatric="xpath=(//input[contains(@id,'checkBox')])[11]";
		public String chkBoxObstetEndoCrine="xpath=(//input[contains(@id,'checkBox')])[12]";
		public String chkBoxLympathic="xpath=(//input[contains(@id,'checkBox')])[13]";
		public String chkBoxAllergic="xpath=(//input[contains(@id,'checkBox')])[14]";
		
		public String lnkEditPhysicalExamAdult="xpath=(//div[@id='editDiv']/a)[6]";
		public String chkBoxVitals="xpath=(//input[contains(@id,'checkBox')])[1]";
		public String chkBoxEyess="xpath=(//input[contains(@id,'checkBox')])[2]";
		public String chkBoxEarsNose="xpath=(//input[contains(@id,'checkBox')])[3]";
		public String chkBoxCardio="xpath=(//input[contains(@id,'checkBox')])[4]";
		public String chkBoxResp="xpath=(//input[contains(@id,'checkBox')])[5]";
		public String chkBoxGastrointestinal="xpath=(//input[contains(@id,'checkBox')])[6]";
		public String chkBoxGenitourinary="xpath=(//input[contains(@id,'checkBox')])[7]";
		public String chkBoxMusculo="xpath=(//input[contains(@id,'checkBox')])[8]";
		public String chkBoxSkin="xpath=(//input[contains(@id,'checkBox')])[9]";
		public String chkBoxNeurologic="xpath=(//input[contains(@id,'checkBox')])[10]";
		public String chkBoxPsychiatrik="xpath=(//input[contains(@id,'checkBox')])[11]";
		public String chkBoxHemotologic="xpath=(//input[contains(@id,'checkBox')])[12]";
			
	/**
	 * goToMUMeasures
	 * Function to go to Meaningful Use Measures
	 * @param selenium
	 * @throws IOException 
	 */
	

public boolean goToMUMeasures(Selenium selenium)  {
		
		try{
			assertTrue(click(selenium, lnkQuickLink), "Could not click on Quick Actions",selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkClinicalList), "Could not click on Clinical Settings",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMuMeasures), "Could not click on Clinical Settings",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}
		catch(Exception e)
		{
		
		}
		return false;
	
	}
	
	public boolean unitTestForMU(Selenium selenium, ClinicalSettingUnitTest muData) {
		boolean returnValue = true;
		try{
			selectValueFromAjaxList(selenium, ajxProvider, muData.provider);
			if(muData.testCaseId.equals("TC_MUM_001"))
				type(selenium, ajxProvider, muData.provider);
			if(!muData.fromDate.equals("N/A"))
				assertTrue(enterDate(selenium, txtFromDate, muData.fromDate),"Could not enter show result from date",selenium, ClassName, MethodName);
			if(!muData.toDate.equals("N/A"))
				assertTrue(enterDate(selenium, txtToDate, muData.toDate),"Could not enter show result to date",selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkUpdateResults), "Could not click on update results",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;
		}
		catch(RuntimeException e){
			e.printStackTrace();
			returnValue = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	public boolean goToBeginEncounter(Selenium selenium) throws IOException {
		try {

			//String onBehalfOf= provider.replaceAll(", "+orderData.switchRole, "");
			//String location = "";
			if(isElementPresent(selenium, btnErrorClose))

				assertTrue(click(selenium, btnErrorClose),"Could not click ",selenium, ClassName, MethodName);


			if (isElementPresent(selenium, btnBeginEncounter)) {
				assertTrue(click(selenium, btnBeginEncounter),"could not click",selenium, ClassName, MethodName);

				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				// if (isElementPresent(selenium, lblEncounterChoosePanel)) {
				if (isElementPresent(selenium, lnkStartNewWncouter)) {
					waitForPageLoad(selenium);
					click(selenium, lnkStartNewWncouter);
				} else if (isElementPresent(selenium,
						"//body/div[4]/div/div/div[2]/div[2]")) {
					click(selenium, "//body/div[4]/div/div/div[2]/div[2]");
				} else if (isElementPresent(selenium,
						"//body/div[5]/div/div/div[2]/div[2]")) {
					click(selenium, "//body/div[5]/div/div/div[2]/div[2]");
				} else if (isElementPresent(selenium,
						"//div[4]/div/div/div[2]/div[2]")) {
					click(selenium, "//div[4]/div/div/div[2]/div[2]");
				} else {
					click(selenium, "//div[5]/div/div/div[2]/div[2]");
				}
				waitForPageLoad(selenium);
				// }
				if (isElementPresent(selenium,"//a[@class='wizard-step-circle']")) {
					selenium.clickAt("//a[@class='wizard-step-circle']", "");
				}
				if(isElementPresent(selenium, btnErrorClose))

					assertTrue(click(selenium, btnErrorClose),"Cold coffe ah "
							+ "",selenium, ClassName, MethodName);


				assertTrue(
						isElementPresent(selenium, lnkEncounterAction),
						"Sign button is not present",selenium, ClassName, MethodName);	
				if(selenium.isConfirmationPresent()){
					System.out.println(selenium.getConfirmation());
					selenium.chooseOkOnNextConfirmation();
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return true;
	}
	public boolean DeleteCustomSectioninDefaultEncounterTemplate(Selenium selenium) throws IOException
	{
		if(isElementPresent(selenium, btnRemove))
		{
			assertTrue(click(selenium, btnRemove),"Could not click Remove Button",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnYesButton),"Could not click Yes  Button",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
		}
		return true;
	}
	public boolean DeleteAllCustomSection(Selenium selenium) throws IOException
	{
		while(isElementPresent(selenium,"xpath=(//button[@type='button'])[7]"))
		{
			 assertTrue(click(selenium, "xpath=(//button[@type='button'])[7]"),"could not click",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(click(selenium, btnYesButton), "could not click yes button",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 if(!isElementPresent(selenium,"xpath=(//button[@type='button'])[7]"))
			 {
				 break;
			 }
		}
		return true;
	}
	
	/**
	 * verifyCheckBoxForVisitSettings
	 * Test for verify and click the check Box for Visit settings
	 * @param selenium
	 * @param muData
	 * @throws IOException 
	 * @since Oct 20, 2014
	 */
	
	public boolean verifyCheckBoxForVisitSettings(Selenium selenium)throws Exception
	{
		assertTrue(click(selenium,lnkEditReviewOfSystems),"Unable to click the edit button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!isChecked(selenium,chkBoxEncounterType))
		{
			assertTrue(click(selenium,chkBoxEncounterType),"Unable to click Encounter Type",selenium, ClassName, MethodName);
			
		}
		if(!isChecked(selenium,chkBoxLanguage))
		{
			assertTrue(click(selenium,chkBoxLanguage),"Unable to click chkBoxLanguage",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxContactMode))
		{
			assertTrue(click(selenium,chkBoxContactMode),"Unable to click ContactMode",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxLocation))
		{
			assertTrue(click(selenium,chkBoxLocation),"Unable to click Location",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxTime))
		{
			assertTrue(click(selenium,chkBoxTime),"Unable to click Time",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxDuration))
		{
			assertTrue(click(selenium,chkBoxDuration),"Unable to click Duration",selenium, ClassName, MethodName);
		}
		assertTrue(click(selenium,btnSaveCustomSection),"Unable to save the entire Visit Settings",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	
	/**
	 * verifyCheckBoxForPastMedicalHistory
	 * Test for verify and click the check Box for Past Medical History 
	 * @param selenium
	 * @param muData
	 * @throws IOException 
	 * @since Oct 20, 2014
	 */
	public boolean verifyCheckBoxForPastMedicalHistory(Selenium selenium)throws Exception
	{
		assertTrue(click(selenium,lnkEditPasMedicalHistory),"Unable to Click the edit link for Past Medical History",selenium,ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!isChecked(selenium,chkBoxAllergies))
		{
			assertTrue(click(selenium,chkBoxAllergies),"Unable to check Allergies",selenium,ClassName, MethodName);
			
		}
		if(!isChecked(selenium,chkBoxProblemList))
		{
			assertTrue(click(selenium,chkBoxProblemList),"Unable to check Problem LIst",selenium,ClassName, MethodName);
			
		}
		if(!isChecked(selenium,chkBoxSurgicalHistory))
		{
			assertTrue(click(selenium,chkBoxSurgicalHistory),"Unable to check Surgical History",selenium,ClassName, MethodName);
			
		}
		if(!isChecked(selenium,chkBoxMedication))
		{
			assertTrue(click(selenium,chkBoxMedication),"Unable to check medication",selenium,ClassName, MethodName);
			
		}
		if(!isChecked(selenium,chkBoxImmunizations))
		{
			assertTrue(click(selenium,chkBoxImmunizations),"Unable to check Immunizations",selenium,ClassName, MethodName);
			
		}
		if(!isChecked(selenium,chkBoxInjections))
		{
			assertTrue(click(selenium,chkBoxInjections),"Unable to check Injections",selenium,ClassName, MethodName);
			
		}
		if(!isChecked(selenium,chkBoxSocialHistory))
		{
			assertTrue(click(selenium,chkBoxSocialHistory),"Unable to check Social History",selenium,ClassName, MethodName);
			
		}
		if(!isChecked(selenium,chkBoxFamilyHistory))
		{
			assertTrue(click(selenium,chkBoxFamilyHistory),"Unable to check Family History",selenium,ClassName, MethodName);
			
		}
		if(!isChecked(selenium,chkBoxObstetHistory))
		{
			assertTrue(click(selenium,chkBoxObstetHistory),"Unable to check Obstet History",selenium,ClassName, MethodName);
			
		}
		
		assertTrue(click(selenium,btnSaveCustomSection),"Unable to click the save button",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
	
	/**
	 * verifyCheckBoxForReviewOfSystems
	 * Test for verify and click the check Box for Visit settings
	 * @param selenium
	 * @param muData
	 * @throws IOException 
	 * @since Oct 20, 2014
	 */
	public boolean verifyCheckBoxForReviewOfSystems(Selenium selenium)throws Exception
	{
		assertTrue(click(selenium,lnkEditReviewOfSystems),"Unable to click the edit button for review of systems",selenium,ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!isChecked(selenium,chkBoxConsSympotms))
		{
			assertTrue(click(selenium,chkBoxConsSympotms),"Unable to click the ConsSympotms check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxEyes))
		{
			assertTrue(click(selenium,chkBoxEyes),"Unable to click the Eyes check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxEars))
		{
			assertTrue(click(selenium,chkBoxEars),"Unable to click the Ears check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxCardioVascular))
		{
			assertTrue(click(selenium,chkBoxCardioVascular),"Unable to click the CardioVascular check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxRespiratory))
		{
			assertTrue(click(selenium,chkBoxRespiratory),"Unable to click the Respiratory check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxGastro))
		{
			assertTrue(click(selenium,chkBoxGastro),"Unable to click the Gastro check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxzGenito))
		{
			assertTrue(click(selenium,chkBoxzGenito),"Unable to click theGenito check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxMusculos))
		{
			assertTrue(click(selenium,chkBoxMusculos),"Unable to click the Musculos check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxIntugumentry))
		{
			assertTrue(click(selenium,chkBoxIntugumentry),"Unable to click the Intugumentry check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxNeurological))
		{
			assertTrue(click(selenium,chkBoxNeurological),"Unable to click the Neurological check box",selenium, ClassName, MethodName);
		}
		
		if(!isChecked(selenium,chkBoxPsychiatric))
		{
			assertTrue(click(selenium,chkBoxPsychiatric),"Unable to click the Psychiatric check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxObstetEndoCrine))
		{
			assertTrue(click(selenium,chkBoxObstetEndoCrine),"Unable to click the ObstetEndoCrine check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxLympathic))
		{
			assertTrue(click(selenium,chkBoxLympathic),"Unable to click the Lympathic check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxAllergic))
		{
			assertTrue(click(selenium,chkBoxAllergic),"Unable to click the Allergic check box",selenium, ClassName, MethodName);
		}
		assertTrue(click(selenium,btnSaveCustomSection),"Unable to click the save button",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	
	
	/**
	 * verifyCheckBoxForReviewOfSystems
	 * Test for verify and click the check Box for Visit settings
	 * @param selenium
	 * @param muData
	 * @throws IOException 
	 * @since Oct 20, 2014
	 */
	 public boolean verifyCheckBoxForPhysicalExam(Selenium selenium)throws Exception
	 {
		assertTrue(click(selenium,lnkEditPhysicalExamAdult),"Unable to click the edit button for review of systems",selenium,ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!isChecked(selenium,chkBoxVitals))
		{
			assertTrue(click(selenium,chkBoxVitals),"Unable to click the vitals check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxEyess))
		{
			assertTrue(click(selenium,chkBoxEyess),"Unable to click the Eyes check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxEarsNose))
		{
			assertTrue(click(selenium,chkBoxEarsNose),"Unable to click the EarsNose check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxCardio))
		{
			assertTrue(click(selenium,chkBoxCardio),"Unable to click the Cardio check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxResp))
		{
			assertTrue(click(selenium,chkBoxResp),"Unable to click the Resp check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxGastrointestinal))
		{
			assertTrue(click(selenium,chkBoxGastrointestinal),"Unable to click the Gastrointestinal check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxGenitourinary))
		{
			assertTrue(click(selenium,chkBoxGenitourinary),"Unable to click the Genitourinary check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxMusculo))
		{
			assertTrue(click(selenium,chkBoxMusculo),"Unable to click the Musculo check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxSkin))
		{
			assertTrue(click(selenium,chkBoxSkin),"Unable to click the Skin check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxNeurologic))
		{
			assertTrue(click(selenium,chkBoxNeurologic),"Unable to click the Neurologic check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxPsychiatrik))
		{
			assertTrue(click(selenium,chkBoxPsychiatrik),"Unable to click the Psychiatrik check box",selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxHemotologic))
		{
			assertTrue(click(selenium,chkBoxHemotologic),"Unable to click the Hemotologic Check box",selenium, ClassName, MethodName);
		}
		assertTrue(click(selenium,btnSaveCustomSection),"Unable to click the save button",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		return true;
	 }
	/**
	 * verifyCheckBoxForVisitSettings
	 * Test for verify and click the check Box for Visit settings
	 * @param selenium
	 * @param muData
	 * @throws IOException 
	 * @since Oct 20, 2014
	 */
        	
	public boolean verifyCheckBoxForVisitOutline(Selenium selenium)throws Exception
	{
		assertTrue(isElementPresent(selenium,lnkOptionVisitSettings),"Unable to find option button for cheif Complaint",selenium, ClassName, MethodName);
		assertTrue(isElementPresent(selenium,lnkOptionCheifComplaint),"Unable to find option button for cheif Complaint",selenium, ClassName, MethodName);
		if(!isChecked(selenium,chkBoxPastMedicalHistory))
		{
			assertTrue(click(selenium,chkBoxPastMedicalHistory),"Unable to click Encounter Type",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,lnkOptionPastMedicalHistory),"Option Button not present",selenium,ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxHistoryOfPresentIllness))
		{
			assertTrue(click(selenium,chkBoxHistoryOfPresentIllness),"Unable to click chkBoxLanguage",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,lnkOptionHistoryOfPresentIllness),"Option Button not present",selenium,ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxReviewOfSystems))
		{
			assertTrue(click(selenium,chkBoxReviewOfSystems),"Unable to click ContactMode",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,lnkOptionReviewOfSystems),"Option Button not present",selenium,ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxPhysicalExamAdult))
		{
			assertTrue(click(selenium,chkBoxPhysicalExamAdult),"Unable to click Location",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,lnkOptionPhysicalExamAdult),"Option Button not present",selenium,ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxPhysicalExamPediatric))
		{
			assertTrue(click(selenium,chkBoxPhysicalExamPediatric),"Unable to click Time",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,lnkOptionPhysicalExamPediatric),"Option Button not present",selenium,ClassName, MethodName);
		}
		if(!isChecked(selenium,chkBoxAssesments))
		{
			assertTrue(click(selenium,chkBoxAssesments),"Unable to click Duration",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,lnkOptionAssesments),"Option Button not present",selenium,ClassName, MethodName);
		}
		/*if(!isChecked(selenium,chkBoxRecommendations))
		{
			assertTrue(click(selenium,chkBoxRecommendations),"Unable to click Duration",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,lnkOptionRecommendations),"Option Button not present",selenium,ClassName, MethodName);
		}*/
		
		return true;
	}
	/**
	 * connectPostgres
	 * Function to connect with postgres db
	 * @param selenium
	 */
	public int connectPostgres(int metricResult, ClinicalSettingLib muData, String website){

		try {
			 Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
		System.out.println("Where is your PostgreSQL JDBC Driver?"+ "Include in your library path!");
			e.printStackTrace();
		}
 System.out.println();
 
 
 		if(!website.contains(url)){
 		   url = website.split(":")[1].replace("//", "");
 		}
 		
		System.out.println("PostgreSQL JDBC Driver Registered!");
		float numerator,denominator;
		
		try {
			Connection connection=null;
			
			String dburl = "jdbc:postgresql://"+url+":"+port+"/"+database+"?"+
			"ssl=true&"+"sslfactory=org.postgresql.ssl.NonValidatingFactory";
			connection = DriverManager.getConnection(dburl, dbusername, dbpwd);
			
			numerator = runNumeratorQuery(connection,muData);
			System.out.println("Numerator"+ numerator);
			
			denominator = runDenominatorQuery(connection,muData);
			System.out.println("Denominator"+ denominator);
			
			metricResult= (int) Math.round(((numerator)/(denominator))*100);
			System.out.println("metricResult"+ metricResult);	
			
		if (connection != null) {
			System.out.println("Connected Sucessfully");
		} 
		else{
			System.out.println("Failed to make connection!");
		}
		
		} catch (SQLException e) {
			 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			Assert.fail("Connection Failed! Check output console");

			
		}
		return metricResult;
		
	}
	/**
	 * runNumeratorQuery
	 * Function to run Numerator Query
	 * @param selenium
	* @throws SQLException 
	 */
	public int runNumeratorQuery(Connection connection,ClinicalSettingLib muData) throws SQLException{

		int numerator=0;
		try{
			Statement sql; 
			sql = connection.createStatement();
			ResultSet numeratorSet = sql.executeQuery(muData.numQuery);
		    
		    if (numeratorSet != null)
		    {
		      while (numeratorSet.next())
		      {
		        System.out.println(numeratorSet.getString("Numerator"));
		        numerator=Integer.parseInt(numeratorSet.getString("Numerator"));
		      }
		    }
		    numeratorSet.close();
		   }
		catch(RuntimeException e){
			e.printStackTrace();
			
		}
		return numerator;
	}
	
	/**
	 * navigateToActivateAndInActivateSearchValue
	 * Test for Navigate to next to default value in the search result
	 * @param selenium
	 * @param muData
	 * @throws IOException 
	 * @since Oct 27, 2014
	 */
	
	public boolean navigateToActivateAndInActivateSearchValue(Selenium selenium,ClinicalSettingLib encounterTemplateTestData)throws IOException
	{
		assertTrue(type(selenium, txtSearch, encounterTemplateTestData.templateName), "Could not type template name", selenium, ClassName, MethodName);
		selenium.keyPress(txtSearch, "\\13");
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkClickInActive),"Unable to Navigate to the search value",selenium,ClassName, MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
	
	/**
	 * verifySimpleView
	 * Test for verify the Simple view of the visit outline template
	 * @param selenium
	 * @param muData
	 * @throws IOException 
	 * @since Oct 28, 2014
	 */
	
	public boolean verifySimpleView(Selenium selenium,ClinicalSettingLib encounterTemplateTestData)throws IOException
	{
		assertTrue(getText(selenium,lnkTemplateName).contains(encounterTemplateTestData.templateName),"Template Name not matched with the actual data",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lnkTemplateDescription).equalsIgnoreCase(encounterTemplateTestData.templateDescription),"Template Description not match with the actual data",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	
	/**
	 * runNumeratorQuery
	 * Function to run Numerator Query
	 * @param selenium
	 * @throws SQLException 
	 */
	public int runDenominatorQuery(Connection connection,ClinicalSettingLib muData) throws SQLException{

		int denominator=0;
		try{
			Statement sql; 
			sql = connection.createStatement();
			ResultSet denominatorSet = sql.executeQuery(muData.denQuery);
		    if (denominatorSet != null)
		    {
		      while (denominatorSet.next())
		      {
		        System.out.println(denominatorSet.getString("Denominator"));
		        denominator=Integer.parseInt(denominatorSet.getString("Denominator"));
		      }
		    }
		    denominatorSet.close();
			}
		catch(RuntimeException e){
			e.printStackTrace();
			
		}
		return denominator;
	}
	
	/**
	 * verifyMeasure
	 * Test for verify result
	 * @param selenium
	 * @param muData
	 * @throws IOException 
	 * @since Nov 30, 2012
	 */
	public boolean verifyMeasure(Selenium selenium, ClinicalSettingLib muData) {
		boolean returnValue = true;
		try{
			selectValueFromAjaxList(selenium, ajxProvider, muData.provider);
			//Assert.assertTrue(enterDate(selenium, "//div[3]/input", muData.fromDate), "Could not enter show result from date");
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
			String date1 = date.format(cal.getTime());
			assertTrue(enterDate(selenium, txtToDate, date1), "Could not enter show result to date",selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkUpdateResults), "Could not click on update results",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;
		}
		catch(RuntimeException e){
			e.printStackTrace();
			returnValue = false;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	/**
	 * createNotes
	 * function to create a Notes
	 * @throws IOException 
	 * @since  	     Jan 18, 2013
	 */	
	public boolean createNotes(Selenium selenium,HomeLib noteData)  {
		try{
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			String date=DateFormat.format(cal.getTime());
			
			
			assertTrue(enterDate(selenium,txtNoteDate,date),"Could not enter date; More Details:"+noteData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxSuggestBox,noteData.category);
			
			
			assertTrue(type(selenium,txtNote,date), "Could not type patient note; More Details :"+noteData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave1),"Could not click save button; More Details:"+noteData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblNoteTitle)){
				return true;
			}else{
				return false;
				}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + noteData.toString());		
			return false;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * createNewPatientWithMandatory
	 * function to create New Patient With Mandatory
	 * @throws IOException 
	 * @since	Jan 16, 2012
	 */	
	public boolean createNewPatientWithMandatory(Selenium selenium, ChartPreVisitLib patientData) throws IOException{
		boolean returnValue = false;
		try{
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtLastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtFirstName,patientData.firstName),"Could not type the first Name : More Details"+patientData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,chkprematurecheckbox),"Could not click prematurecheck box : More Details"+patientData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxPrematureDuration,patientData.duration);
			selectValueFromAjaxList(selenium,ajxSex,patientData.sex);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxPrematureMeasurement,patientData.measure);
			selectValueFromAjaxList(selenium,ajxStatus,patientData.status);
			if(!patientData.dob.isEmpty())
				if(!patientData.dob.contains("N/A"))
					assertTrue(enterDate(selenium, txtDob, patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob,selenium, ClassName, MethodName);			
			click(selenium,btnBack1);
			if(isElementPresent(selenium,btnNoDuplicate))
			{
			click(selenium,btnNoDuplicate);
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnPatientSave),"Could not click Save button More Dateils"+patientData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;	
			}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
		}
		return returnValue;
	}
	/**
	 * deletelabReport
	 * function to delete lab report
	 * @throws IOException 
	 * @since  	    Jan 21, 2013
	 */	
	public boolean deletelabReport(Selenium selenium, ChartPreVisitLib labData) throws IOException{
		selenium.focus(lnkChartLabFlowSheet);
		selenium.clickAt(lnkChartLabFlowSheet, "");
		
		assertTrue(click(selenium,lnkLabtab ), "Could not click on lab link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		while(isElementPresent(selenium,lnkActionsLink)){
			int count=1;
			assertTrue(click(selenium,lnkActionsLink),"Could Click Action Button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnDeletelabReport),"Could Click delete Button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
assertTrue(type(selenium,txtdeleteReason,"Reason"), "Could not type reason",selenium, ClassName, MethodName);
			click(selenium,btnDeleteReasonBox);
			waitForPageLoad(selenium);
			 if(isElementPresent(selenium, "errorCloseButton"))
					assertTrue(click(selenium, "errorCloseButton"),"Could not click the ",selenium, ClassName, MethodName);
			count++;
			if(count>15){
				break;
			}
		}
		return true;
		
	}
	/**
	 * navigateTofileReport
	 * function to navigate To file Report
	 * @throws IOException 
	 * @since  	    Jan 21, 2013
	 */	
	public boolean navigateTofileReport(Selenium selenium, ChartPreVisitLib labData) throws IOException{
		assertTrue(click(selenium,lnkPatientOptionsLink ), "Could not click on patient options link",selenium, ClassName, MethodName);
		assertTrue(click(selenium,lnkLabReportLink ), "Could not click on file new report link",selenium, ClassName, MethodName);
		return true;
		
	}
	/**
	 * fileReport
	 * function to goToEncounterMedicationIcon
	 * @throws IOException 
	 * @since  	   Jan 21, 2013
	 */	
	public boolean fileReport(Selenium selenium, ChartPreVisitLib labData) throws IOException{
		
		assertTrue(click(selenium,btnEnterData),"Could not find enter data link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(labData.testCaseId.equals("TC_LR_005")||labData.testCaseId.equals("TC_LR_012")){
			assertTrue(click(selenium,rdoPartial),"Could not find partial radio button",selenium, ClassName, MethodName);
		}
		
		assertTrue(type(selenium,txtaccNumber, labData.accNumber), "Could not type accession number",selenium, ClassName, MethodName);
		if(isElementPresent(selenium,btnOkButton))
			click(selenium,btnOkButton);
		selectValueFromAjaxList(selenium,ajxLabProvider, labData.rProvider);
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium,ajxtoProvider, labData.oProvider);
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium,ajxLabName, labData.labName);
		waitForPageLoad(selenium);
		assertTrue(enterDate(selenium,txtCdate,labData.cDate),"Could not enter the collrction Date;More Details:"+labData.toString(),selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtCtime, labData.cTime), "Could not type time",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtNotes, labData.notes), "Could not type notes",selenium, ClassName, MethodName);
		selectValueFromAjaxList(selenium,ajxLabTestName, labData.testName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtResult, labData.result), "Could not type results",selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtLow, labData.low), "Could not type low",selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtHigh, labData.high), "Could not type high",selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtUnits, labData.units), "Could not type units",selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtComment, labData.comments), "Could not type comments",selenium, ClassName, MethodName);
		
		if(labData.testCaseId.equals("TC_LR_009"))
			if(isChecked(selenium,chkAbnormal))
				assertTrue(click(selenium,chkAbnormal),"Could not click abnormal check box",selenium, ClassName, MethodName);

		if(labData.testCaseId.equals("TC_LR_005")){
			assertTrue(click(selenium,chkAbnormal),"Could not find add test result button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxLabTestName1, labData.testName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtResult1, labData.result), "Could not type results",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtLow1, labData.low), "Could not type low",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtHigh1, labData.high), "Could not type high",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtUnits1, labData.units), "Could not type units",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtComment1, labData.comments), "Could not type comments",selenium, ClassName, MethodName);
		}
		
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnSign),"Could not find sign button",selenium, ClassName, MethodName);
		
		return true;
		
	}
	/**
	 * orderNewLabs
	 * Function to order New Labs
	 * @throws IOException 
	 * @since  	   Jan 21, 2013
	 */
	public boolean orderNewLabs(Selenium selenium, ChartPreVisitLib orderData) throws IOException{
		try{
			
			if(orderData.testCaseId.equals("TC_OL_004")){
				assertTrue(click(selenium,btnSaveButton), "Could not click on save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(getText(selenium,lblAlert).toLowerCase(new java.util.Locale("en","US")).trim().contains("You need to select one test at least for saving the report!".trim().toLowerCase(new java.util.Locale("en","US")))){
					return true;
				}
				else return false;
			}
			if(orderData.testCaseId.equals("TC_OL_004")){
				selectValueFromAjaxList(selenium, ajxLabTestName2,orderData.labTestName);
				assertTrue(click(selenium,btnSaveButton), "Could not click on save button",selenium, ClassName, MethodName);
				return true;
			}
			selectValueFromAjaxList(selenium, ajxLabTestName2,orderData.labTestName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtComments, orderData.labTestComments1), "Could not type comments",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, "labFacilitySuggestBoxsuggestBox",orderData.sendTo);
			if(orderData.testCaseId.equals("TC_OL_005")){
				assertTrue(click(selenium,btnLabSign), "Could not click on sign button",selenium, ClassName, MethodName);
				return true;
			}
		assertTrue(click(selenium,btnSaveButton), "Could not click on save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}
		catch(RuntimeException e){
			Assert.fail("Failed due to the Exception; \n Exception details: "+e.getMessage());
			return false;
		}


	}
	public boolean deleteAllEncounters(Selenium selenium ) throws IOException{
		boolean medDeleted=true;
		
		try{
			int count=0;
			while(isElementPresent(selenium,inkUnSignedEnCounterAction)){
				assertTrue(click(selenium,inkUnSignedEnCounterAction),"Could not click on Actions button;More Details",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,"//div[@id='actionList']/div[2]"),"Could not click on delete button;More Details",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtdeleteReason,"Reason"),"Could not type reason ;More Details",selenium, ClassName, MethodName);
				assertTrue(click(selenium,"//button[@id='deleteReason']"),"Could not click on Delete button;More Details",selenium, ClassName, MethodName);
				
				waitForPageLoad(selenium);
				count++;
				if(count>30)
				break;			
				}
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return medDeleted;
	}
	
	
	/**
	 * deleteAllMandatory
	 * function to delete All Mandatory
	 * @throws IOException 
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllMandatory(Selenium selenium) {
		boolean mandatoryDeleted = true;
		int caseCount = 0;
		try{
			waitForElement(selenium, lblMandatoryField, WAIT_TIME);
			while((Integer) selenium.getXpathCount(lblMandatoryField) > 0){
				caseCount = (Integer) selenium.getXpathCount(lblMandatoryField);
				assertTrue(click(selenium,lblMandatoryField),"could not click ",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYes),"could not click yes button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount(lblMandatoryField)){
					mandatoryDeleted = false;
					break;
				}
			}
			return mandatoryDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mandatoryDeleted;
	}
	
	/**
	 * searchPatientUsingPatientId
	 * function to search a patient using Patient ID
	 * @throws IOException 
	 * @since  	     Feb 09, 2012
	 */	
	public boolean searchPatientUsingPatientId(Selenium selenium,String patientId)throws IOException
	{
		assertTrue(type(selenium,lnkPatientSearchBox,patientId),"Unable to enter the patient Data",selenium,ClassName,MethodName);
		assertTrue(keyPress(selenium,lnkPatientSearchBox, "\\13"), "Could perform key press",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lblPatientInfo),"Unable to click the patient",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		return true;
	}

	/**
	 * createNewPatientWithMandatory
	 * function to create New Patient With Mandatory
	 * @throws IOException 
	 * @since  	     Feb 09, 2012
	 */	
	public boolean createNewPatientWithMandatory(Selenium selenium, HomeLib patientData,ClinicalSettingLib searchData )  {
		boolean returnValue = false;
		try{
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtLastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtFirstName,patientData.firstName),"Could not type the first Name : More Details"+patientData.toString(),selenium, ClassName, MethodName);
			if(searchData.testCaseId.equals("TC_VSS_001") || searchData.testCaseId.equals("TC_SWC_001")||searchData.testCaseId.equals("TC_SWC_002")|| searchData.testCaseId.equals("TC_SWC_003")||searchData.testCaseId.equals("TC_SWC_004")){
				selectValueFromAjaxList(selenium, ajxSex,"Male");
			}
			if(searchData.testCaseId.equals("TC_VSS_002")){
				selectValueFromAjaxList(selenium, ajxSex,"Female");
			}
			assertTrue(type(selenium, txtDob, patientData.dob), "Could not type DOB",selenium, ClassName, MethodName);
			
			if(searchData.testCaseId.equals("TC_VSA_003")||searchData.testCaseId.equals("TC_VSS_003")){
				selectValueFromAjaxList(selenium, ajxSex,"Female");
				assertTrue(type(selenium, txtDob, "11/27/2000"), "Could not type DOB",selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			click(selenium,btnBack1);
			assertTrue(click(selenium,btnPatientSave),"Could not click Save button More Dateils"+patientData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;	
			waitForPageLoad(selenium);
			}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	/**
	 * addEncounterVitals
	 * Function to create a Encounter Vitals
	 * @throws IOException 
	 * @since	Dec 21, 2012
	 */
	public boolean addEncounterVitals(Selenium selenium, ChartPreVisitLib vitalsData)  {
		try{
			
			
			
			
			assertTrue(type(selenium, txthieghtInFeet,vitalsData.heightInFeet), "Could not type Hight in feet",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txthieghtInCm,vitalsData.heightInCm), "Could not type Hight in inches",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxhight , vitalsData.heightMU);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtweight, vitalsData.weight), "Could not type weight",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxweight, vitalsData.weightMU);
			assertTrue(type(selenium, txtsystolicRate, vitalsData.systolicRate), "Could not type systolic Rate",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtdiastolicRate, vitalsData.diastolicRate), "Could not type diastolic Rate",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxposition, vitalsData.position);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxlimb, vitalsData.limb);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxcuff, vitalsData.cuffSize);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtbPM, vitalsData.bPM), "Could not type Heart Rate",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxdescription, vitalsData.description);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxrhythm, vitalsData.rhythm);
			waitForPageLoad(selenium);
			if(!(vitalsData.testCaseId.equalsIgnoreCase("TC_CV_001"))){
				if(getText(selenium,lblShowMoreDetails).contains("Show more details"))
					assertTrue(click(selenium, lblShowMoreDetails), "Could not click on show more details",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtWaist, vitalsData.waist), "Could not type waist",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxWaist, vitalsData.waistMU);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtTemp, vitalsData.temperature), "Could not type temperature",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxtempUnit, vitalsData.tempRU);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxtempLoc, vitalsData.location);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtBloodSugar, vitalsData.bloodSuger), "Could not type blood sugar",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxbloodSugarUnit, vitalsData.bSUnit);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtRepository, vitalsData.repositoryRate), "Could not type blood sugar",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxrespiratoryRate, vitalsData.rR_BPM);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtOxegenSaturation, vitalsData.oxygenSaturation), "Could not type oxygen saturation",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtpEFR, vitalsData.pEFR), "Could not type pefr",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxpefrDescription, vitalsData.pre_bronchodilator);
				waitForPageLoad(selenium);
			}
			
			assertTrue(click(selenium,btnAdd ), "Could not click on add button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			return true;
		}
		catch(RuntimeException e){
			Assert.fail("Failed due to the Exception; \n Exception details: "+e.getMessage());
			return false;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * navigateTo Medication Interaction Warning 
	 * Function to go to Medication Interaction Warning
	 * @param 	selenium
	 * @throws IOException 
	 * @since	March 12,2013
	 */
	public boolean navigateToInteracWarn(Selenium selenium) throws IOException{
		assertTrue(click(selenium, lnkSettings), "Could not click on Settings Link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkClinicalSettingsLink), "Could not click on Clinical settings",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkInteractionWarningLink), "Could not click on Interaction Warning button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}

	
	/**
	 * navigateTo Medication Interaction Warning 
	 * Function to go to Medication Interaction Warning
	 * @param 	selenium
	 * @throws IOException 
	 * @since	March 18,2013
	 */
	public boolean navigateToPatientOptionWarn(Selenium selenium) throws IOException{
		assertTrue(click(selenium, lnkPatientOptions), "Could not click on Quick Actions button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkPatientOptionInteracWaringLink), "Could not click on Clinical settings",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	
	/**
	 * navigateTo My Settings Medication Interaction Warning 
	 * Function to go to Medication Interaction Warning
	 * @param 	selenium
	 * @throws IOException 
	 * @since	March 12,2013
	 */
	public boolean navigateToMySettingsInteracWarn(Selenium selenium) throws IOException{
		assertTrue(click(selenium, lnkTopMenuHeader), "Could not click on Top Menu Header",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkMySettingsLink), "Could not click on Clinical settings",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkMySettingsInteractionWarningLink), "Could not click on Interaction Warning button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	
	/**
	 * editInteracWarn
	 * Function to edit Medication Interaction Warning
	 * @param 	selenium
	 * @throws IOException 
	 * @since	March 15,2013
	 */
	public boolean editInteracWarn(Selenium selenium,ClinicalSettingLib interacWarn) throws IOException{
		boolean returnValue=true;
		
		assertTrue(click(selenium, btnEditSave), "Could not click on Edit button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		
		if(interacWarn.severeOnly.equals("yes")){
			assertTrue(click(selenium, rdoSevereOnly), "Could not select warning option",selenium, ClassName, MethodName);
		}
		else if(interacWarn.highToSevere.equals("yes")){
			assertTrue(click(selenium, rdoHighToSevere), "Could not select warning option",selenium, ClassName, MethodName);
		}
		else if(interacWarn.moderateToSevere.equals("yes")){
			assertTrue(click(selenium,rdoModerateToSevere), "Could not select warning option",selenium, ClassName, MethodName);
		}
		else if(interacWarn.mildToSevere.equals("yes")){
			assertTrue(click(selenium, rdoMildToSevere), "Could not select warning option",selenium, ClassName, MethodName);
		}
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		if(interacWarn.testCaseId.equals("TC_IWM_002")){
			assertTrue(click(selenium, btnCancelWarning), "Could not click on Cancel button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		else{
		assertTrue(click(selenium, btnWarningSave), "Could not click on Save button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		
		return returnValue;
	}
	

	
	/**
	 * editInteracWarnMySettings
	 * Function to edit Medication Interaction Warning
	 * @param 	selenium
	 * @throws IOException 
	 * @since	March 15,2013
	 */
	public boolean editInteracWarnMySettings(Selenium selenium,ClinicalSettingLib interacWarn) throws IOException{
		boolean returnValue=true;
		if(interacWarn.testCaseId.equals("TC_IWM_003")){
			if(selenium.isTextPresent("Edit")){
				returnValue=false;
			}
			else return true;
		}
		
		assertTrue(click(selenium, btnEditSave), "Could not click on Edit button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(interacWarn.testCaseId.equals("TC_IWM_004")){
			if(selenium.isTextPresent("Severe Only")){
				returnValue=false;
			}
			else returnValue=true;
		}
		
		if(interacWarn.severeOnly.equals("yes")){
			assertTrue(click(selenium, rdoSevereOnly), "Could not select warning option",selenium, ClassName, MethodName);
		}
		else if(interacWarn.highToSevere.equals("yes")){
			assertTrue(click(selenium, rdoHighToSevere), "Could not select warning option",selenium, ClassName, MethodName);
		}
		else if(interacWarn.moderateToSevere.equals("yes")){
			assertTrue(click(selenium,rdoModerateToSevere), "Could not select warning option",selenium, ClassName, MethodName);
		}
		else if(interacWarn.mildToSevere.equals("yes")){
			assertTrue(click(selenium, rdoMildToSevere), "Could not select warning option",selenium, ClassName, MethodName);
		}
		
		if(interacWarn.testCaseId.equals("TC_IWM_002")){
			assertTrue(click(selenium, btnCancelWarning), "Could not click on Cancel button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		else{
		assertTrue(click(selenium, btnWarningSave), "Could not click on Save button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		
		return returnValue;
	}
	
	/**
	 * editInteracWarnPatientOptions
	 * Function to edit Medication Interaction Warning
	 * @param 	selenium
	 * @throws IOException 
	 * @since	March 15,2013
	 */
	public boolean editInteracWarnPatientOptions(Selenium selenium,ClinicalSettingLib interacWarn) throws IOException{
		boolean returnValue=true;
		if(interacWarn.testCaseId.equals("TC_IWM_003")){
			if(selenium.isTextPresent("Save")){
				returnValue=false;
			}
			else return true;
		}
		
		
	if(interacWarn.testCaseId.equals("TC_IWM_004")){
			if(selenium.isTextPresent("High")){
				returnValue=false;
			}
			else returnValue=true;
		}
		
		if(interacWarn.severeOnly.equals("yes")){
			assertTrue(click(selenium, rdoSevereOnly), "Could not select warning option",selenium, ClassName, MethodName);
		}
		else if(interacWarn.highToSevere.equals("yes")){
			assertTrue(click(selenium, rdoHighToSevere), "Could not select warning option",selenium, ClassName, MethodName);
		}
		else if(interacWarn.moderateToSevere.equals("yes")){
			assertTrue(click(selenium,rdoModerateToSevere), "Could not select warning option",selenium, ClassName, MethodName);
		}
		else if(interacWarn.mildToSevere.equals("yes")){
			assertTrue(click(selenium, rdoMildToSevere), "Could not select warning option",selenium, ClassName, MethodName);
		}
		
		if(interacWarn.testCaseId.equals("TC_IWM_002")){
			assertTrue(click(selenium, btnCancelWarning), "Could not click on Cancel button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		else{
		assertTrue(click(selenium,btnSaveOnPatientOptions), "Could not click on Save button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		
		return returnValue;
	}
	
	/**
	 * navigate To Prescribe Med InteracWarn
	 * Function to go to Medication Interaction Warning
	 * @param 	selenium
	 * @throws IOException 
	 * @since	March 12,2013
	 */
	public boolean navigateToPrescribeMedInteracWarn(Selenium selenium) throws IOException{
		assertTrue(click(selenium, lnkTopMenuHeader), "Could not click on Top Menu Header",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkMySettingsLink), "Could not click on Clinical settings",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkMySettingsInteractionWarningLink), "Could not click on Interaction Warning button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}

	/**
	 * Function to delete all allergy
	 * @since March 18,2013
	 * @param selenium
	 * @param allergyData
	 * @return boolean value to the called function
	 * @throws IOException 
	 */
	public boolean deleteAllAllergy(Selenium selenium ,ClinicalSettingLib allergyData) throws IOException{
		boolean historyDeleted=true;
		int historyCount=0;
		try{
			assertTrue(click(selenium,chkIncludeInactivecheckbox),"Could not click the show All recorded check box;More Details:"+allergyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForElement(selenium,lblAlergy, WAIT_TIME);
			while((Integer) selenium.getXpathCount(lblAlergy) > 0){
				historyCount=(Integer) selenium.getXpathCount(lblAlergy);
				assertTrue(click(selenium,lblAlergy),"could not click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtdeleteReason, allergyData.reason), "Could not type reason for deletion",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnDeleteReasonButton),"Could not click Delete button;More Details:"+allergyData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(historyCount == (Integer) selenium.getXpathCount(lblAlergy)){
					historyDeleted = false;
					break;
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return historyDeleted;
	}
	
	/**
	 * Function to create allergy
	 * @since March 18,2013
	 * @param selenium
	 * @param allergyData
	 * @return boolean value to the called function
	 * @throws IOException 
	 */
	public boolean createAllergy(Selenium selenium,ClinicalSettingLib allergyData) throws IOException{
		try{
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxAllergySuggestBox,allergyData.allergen);
			click(selenium, ajxSuggestBoxOption1);
			/*selectValueFromAjaxList(selenium,"allergyReactionsuggestBox",allergyData.reaction);
			
			if(getText(selenium, "//div[6]/div[3]/div[2]/div/div").equalsIgnoreCase("Show more details")){
				Assert.assertTrue(click(selenium,"//div[6]/div[3]/div[2]/div/div"),"Could not on show more button");
			}
			selectValueFromAjaxList(selenium,"severitysuggestBox",allergyData.severity);
			
			selectValueFromAjaxList(selenium,"statusSuggestBoxsuggestBox",allergyData.status);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			String date=DateFormat.format(cal.getTime());
			Assert.assertTrue(enterDate(selenium,"onsetDate",date),"Could not enter the Admin on ;More Details:"+allergyData.toString());
			
			selectValueFromAjaxList(selenium,"lifeStagesuggestBox",allergyData.lifeStage);
			
			Assert.assertTrue(type(selenium,"summaryComment",allergyData.comment),"Could not enter the comment;More Details:"+allergyData.toString());*/
			assertTrue(click(selenium,btnAdd),"Could not click the add button;More details:"+allergyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * Function to navigate to prescribe
	 * @since March 18,2013
	 * @param selenium
	 * @return boolean value to the called function
	 * @throws IOException 
	 */
	
	public boolean goToPrescribe(Selenium selenium) throws IOException{
		
			assertTrue(isElementPresent(selenium,lnkPatientOptionsLink),"Could not find link",selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkPatientOptionsLink),"Could not click the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkPrescribeLink),"Could not find the link",selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkPrescribeLink),"Could not click the click",selenium, ClassName, MethodName);
			return true;
		
	}
	
	/**
	 * navigateTo Encounter Template 
	 * Function to go to Encounter Template
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Sep 25,2013
	 */
	public boolean navigateToEncounterTemplate(Selenium selenium) throws IOException{
		assertTrue(click(selenium,lnkSettings), "Could not click on Settings link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkClinicalSettingsLink), "Could not click on Clinical settings",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkEncounterTemplate), "Could not click on encounter template link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!isElementPresent(selenium, btnAddCustom)){
			return false;
		}
		return true;
	}
	

	/**
	 * deleteAllEncounterTemplate
	 * function to delete All Encounter Template
	 * @throws IOException 
	 * @since  Sep 25, 2013
	 */
	
	public boolean deleteAllEncounterTemplate(Selenium selenium) throws IOException{
		boolean  encounterDeleted=true;
		
	
		if(isElementPresent(selenium,lblEncountertemplate))
		{
			String CheckDefault=selenium.getText(lblEncountertemplate);
			if(CheckDefault.trim().contains("Default"))
			{
				if(isElementPresent(selenium,"xpath=(//div[@id='templateFocusPanel'])[2]"))
				{
					assertTrue(click(selenium,"xpath=(//div[@id='templateFocusPanel'])[2]"), "could not click Template",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				
			}
			}
		
		
		while(isElementVisible(selenium,tbnEncounterTemplatedelete))
		{
			 assertTrue(click(selenium,tbnEncounterTemplatedelete), "could not click delete button",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(click(selenium, btnYesButton), "could not click yes button",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 if(!isElementPresent(selenium,tbnEncounterTemplatedelete))
			 {
				 break;
			 }
		}
	   /* int encounterDeleteCount=(Integer) selenium.getXpathCount(lnkDeleteEncounterTemplate);
		
	    for(int count=2;count<=encounterDeleteCount;count++){
			 Assert.assertTrue(click(selenium, lnkDeleteEncounterTemplate1), "Could not click the delete button");
			 waitForPageLoad(selenium);
			 Assert.assertTrue(click(selenium, btnYesButton), "Could not click the save button in encounter delete");
			 waitForPageLoad(selenium);
		}
		if(getText(selenium, lnkDeleteEncounterTemplate).equalsIgnoreCase("Delete")){
			encounterDeleted = false;
		} */
		return encounterDeleted;
	}
	
	
	
	/**
	 * addEncounterTemplate 
	 * Function to add Encounter Template
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Sep 25,2013
	 */
	public boolean addEncounterTemplate(Selenium selenium, ClinicalSettingLib encounterTemplateData) throws IOException{
		assertTrue(click(selenium, btnAddNew), "Could not click on add new button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy HH:MM");
		String date=DateFormat.format(cal.getTime());
		encounterTemplateData.templateName=encounterTemplateData.templateName+date;
		assertTrue(type(selenium, txtTemplateName, encounterTemplateData.templateName), "Could not type template name",selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtAreaTemplateDescription, encounterTemplateData.templateDescription), "Could not type template description",selenium, ClassName, MethodName);
		
		//It will be used for get the very first value of the visit type from the list
		assertTrue(click(selenium, ajxspecialitySuugestbox), "Could not click",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		encounterTemplateData.visitType1= getText(selenium, "//div[@class='gwt-PopupPanel dropdown-box']/div/div/div/div/div");
		
		assertTrue(selectValueFromAjaxList(selenium,ajxspecialitySuugestbox,encounterTemplateData.visitType1),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, ajxassociatedVisit), "Could not click",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		encounterTemplateData.visitType1= getText(selenium, "//div[@class='gwt-PopupPanel dropdown-box']/div/div/div/div/div");
		
		assertTrue(selectValueFromAjaxList(selenium,ajxassociatedVisit,encounterTemplateData.visitType1),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, lnkStartBlank), "Could not click start blank template name",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(encounterTemplateData.testCaseId.equalsIgnoreCase("TC_ET_006")){
			assertTrue(click(selenium,btnOptionPop), "Could not click option button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent("Display section as:"), "Could not click option button",selenium, ClassName, MethodName);		
			assertTrue(click(selenium,chkDisplayas), "Could not click option button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtEditName, encounterTemplateData.customSection1), "Could not type past medical history display as name",selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnOptionSave), "Could not click Save button",selenium, ClassName, MethodName);
					}	
		
			assertTrue(click(selenium, btnSaveEncounterTemp), "Could not click save encounter template",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium, btnAddNew)){
				return false;
			
		}
		return true;
	}

	
	/**
	* function to verify Store Values Encounter Template value in summary page
	* @param 	selenium 
	* @param 	encounterTemplateData
	* @since  	sep 25, 2013
	*/	
	public boolean verifyStoreValuesEncounterTemplate(Selenium selenium,ClinicalSettingLib encounterTemplateData){
		
		/*if(!getText(selenium,lblWholeEncounterTemplateSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterTemplateData.templateName.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;                       
		}
		if(!getText(selenium,lblWholeEncounterTemplateSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterTemplateData.templateDescription.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;                       
		}*/
		if(!selenium.isTextPresent(encounterTemplateData.templateDescription)){
			 return false;                       
		}
		return true;
		 
	}
	/**
	* function to Search the Template For outline
	* @param 	selenium 
	* @param 	encounterTemplateData
	 * @throws IOException 
	* @since  	June 25, 2014
	*/	
	public boolean SearchAddedTemplateForoutline(Selenium selenium,ClinicalSettingLib encounterTemplateTestData) throws IOException{
		assertTrue(type(selenium, txtSearch, encounterTemplateTestData.templateName), "Could not type template name",selenium, ClassName, MethodName);
		assertTrue(keyPress(selenium,txtSearch, "\\13"), "Could perform key press",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		waitForPageLoad(selenium);	
		if(isElementPresent(selenium,lblEncountertemplate2))	{
			assertTrue(click(selenium,lblEncountertemplate2), "Could not click",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	}
		else{
			Assert.fail("Serach result is not present");
		}
		return true;
	}
	

	/**
     * encounterTemplateDragAndDrop 
      * Function to verify drag and drop in Encounter Template 
      * @param          selenium
	 * @throws IOException 
     * @since             Sep 30,2013
     */
     public boolean encounterTemplateDragAndDropForEdit(Selenium selenium, ClinicalSettingLib encounterTemplateData) throws IOException{
                     waitForPageLoad(selenium);      
                     if(!isChecked(selenium, chkPastMEdical)){
                 		assertTrue( click(selenium, chkPastMEdical), "Could not Click",selenium, ClassName, MethodName);
                     }
                     if(!isChecked(selenium, chkCheifCompl)){
                    		assertTrue( click(selenium, chkCheifCompl), "Could not Click",selenium, ClassName, MethodName);
                     }
                     waitForPageLoad(selenium);
                     String possition2ValueBeforeDrag = getText(selenium,lnkdraganddrop3);
                     
                     selenium.dragAndDropToObject(lnkdraganddrop3,lnkdraganddrop4);


                     String possition1ValueAfterDrag = getText(selenium,lnkdraganddrop4);
                     
                     assertTrue( isTextPresent(selenium, possition2ValueBeforeDrag), "Could not find text ",selenium, ClassName, MethodName);
                     assertTrue( isTextPresent(selenium, possition1ValueAfterDrag), "Could not find text",selenium, ClassName, MethodName);
                     
                     assertTrue(click(selenium, btnCancelEncounterTemp), "Could not click save encounter template",selenium, ClassName, MethodName);
        
                     
                     return true;
     }

	
	/**
	* function to verify Store Values should not show in Encounter Template value in summary page
	* @param 	selenium 
	* @param 	encounterTemplateData
	* @since  	sep 26, 2013
	*/	
	public boolean verifyStoreValuesNotShowEncounterTemplate(Selenium selenium,ClinicalSettingLib encounterTemplateData){

		if(getText(selenium,lblWholeEncounterTemplateSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterTemplateData.templateName.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;                       
		}
		if(getText(selenium,lblWholeEncounterTemplateSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterTemplateData.templateDescription.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;                       
		}
		return true;
		 
	}
	
	/**
	 * editEncounterTemplate 
	 * Function to edit Encounter Template
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Sep 25,2013
	 */
	public boolean editEncounterTemplate(Selenium selenium, ClinicalSettingLib encounterTemplateData) throws IOException{
		assertTrue(click(selenium, EncoEdit), "Could not click on edit",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(type(selenium, txtTemplateName, encounterTemplateData.templateName), "Could not type template name",selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtAreaTemplateDescription, encounterTemplateData.templateDescription), "Could not type template description",selenium, ClassName, MethodName);
		
		//It will be used for get the very first value of the visit type from the list
		assertTrue(click(selenium,  ajxspecialitySuugestbox), "Could not click",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		encounterTemplateData.visitType1= getText(selenium, "//div[@class='gwt-PopupPanel dropdown-box']/div/div/div/div/div");
		
		assertTrue(selectValueFromAjaxList(selenium, ajxspecialitySuugestbox,encounterTemplateData.visitType1),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, btnSaveEncounterTemp), "Could not click save encounter template",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(!isElementPresent(selenium, btnAddNew)){
			return false;
		}
		return true;
	}
	
	
	/**
	 * addEncounterTemplateUnitTest 
	 * Function to add Encounter Template for unit test
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Sep 30,2013
	 */
	public boolean addEncounterTemplateUnitTest(Selenium selenium, ClinicalSettingUnitTest encounterTemplateData) throws IOException{
		assertTrue(click(selenium, btnAddNew), "Could not click on add new button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(type(selenium, txtTemplateName, encounterTemplateData.templateName), "Could not type template name",selenium, ClassName, MethodName);
		
		if(!encounterTemplateData.testCaseId.equalsIgnoreCase("TC_ET_003")){
			assertTrue(click(selenium, lnkStartBlank), "Could not click start blank template name",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		assertTrue(click(selenium, btnSaveEncounterTemp), "Could not click save encounter template",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
	
	
	/**
	 * encounterTemplateDragAndDrop 
	 * Function to verify drag and drop in Encounter Template 
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Sep 30,2013
	 */
	public boolean encounterTemplateDragAndDrop(Selenium selenium, ClinicalSettingLib encounterTemplateData) throws IOException{
		assertTrue(click(selenium, btnAddNew), "Could not click on add new button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(type(selenium, txtTemplateName, encounterTemplateData.templateName), "Could not type template name",selenium, ClassName, MethodName);
		
		assertTrue(click(selenium, lnkStartBlank), "Could not click start blank template name",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(!isChecked(selenium, "//tr[2]/td/div/div/div/div/div/span/input")){
			click(selenium, "//tr[2]/td/div/div/div/div/div/span/input");
		}
		if(!isChecked(selenium, "//tr[3]/td/div/div/div/div/div/span/input")){
			click(selenium, "//tr[3]/td/div/div/div/div/div/span/input");
		}
		
		String possition2ValueBeforeDrag = getText(selenium,lnkdraganddrop2);
		
		selenium.dragAndDropToObject(lnkdraganddrop2, lnkdraganddrop1);
		waitForPageLoad(selenium);

		String possition1ValueAfterDrag = getText(selenium,lnkdraganddrop1);
		
		//verify the possition-2 value placed in possition-1 or not
		if(possition1ValueAfterDrag.equalsIgnoreCase(possition2ValueBeforeDrag)){
			return false;
		}
		
		assertTrue(click(selenium, btnSaveEncounterTemp), "Could not click save encounter template",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
	
	/**
	 * applyExistingEncounterTemplate 
	 * Function to apply Existing Encounter Template
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 01,2013
	 */
	public boolean applyExistingEncounterTemplate(Selenium selenium, ClinicalSettingLib encounterTemplateData) throws IOException{
		assertTrue(click(selenium, btnAddNew), "Could not click on add new button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, lnkApplyExisting), "Could not click apply existing template",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//link created for the templates by the template name
		assertTrue(click(selenium, "link="+encounterTemplateData.templateName), "Could not click the previously created template",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, btnApplyTemplate), "Could not click apply template",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,btnYes))
		{
			assertTrue(click(selenium, btnYes), "Could not click YEs button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		encounterTemplateData.templateName= encounterTemplateData.templateName + "ApplyExisting";
		encounterTemplateData.templateDescription= encounterTemplateData.templateDescription + "ApplyExisting";
		
		assertTrue(type(selenium, txtTemplateName, encounterTemplateData.templateName), "Could not type template name",selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtAreaTemplateDescription, encounterTemplateData.templateDescription), "Could not type template description",selenium, ClassName, MethodName);
		
		//It will be used for get the second value of the visit type from the list
		click(selenium, ajxSuggestBox);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium, "//div[@class='gwt-PopupPanel dropdown-box']/div/div/div/div/div")){
			encounterTemplateData.visitType1= getText(selenium, "//div[@class='gwt-PopupPanel dropdown-box']/div/div/div/div/div");
		}
		else{
			System.out.println("Another visit type is not available in the list");
			assertTrue(true,"",selenium,ClassName,MethodName);
		}
		
		assertTrue(selectValueFromAjaxList(selenium,ajxSuggestBox,encounterTemplateData.visitType1),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		click(selenium, ajxSendTo);
		waitForPageLoad(selenium);
		encounterTemplateData.visitType1= getText(selenium, "//div[@class='gwt-PopupPanel dropdown-box']/div/div/div/div/div");
		
		assertTrue(selectValueFromAjaxList(selenium,ajxSendTo,encounterTemplateData.visitType1),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, btnSaveEncounterTemp), "Could not click save encounter template",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(!isElementPresent(selenium, btnAddNew)){
			return false;
		}
		return true;
	}
	

	/**
	 * addCustomSectionInEncounterTemplate 
	 /**
	 * addCustomSectionInEncounterTemplate 
	 * Function to add custom sections in Encounter Template
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 03,2013
	 */
	public boolean addCustomSectionInEncounterTemplate(Selenium selenium, ClinicalSettingLib encounterTemplateData) throws IOException{
		assertTrue(click(selenium, btnAddNew), "Could not click on add new button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		assertTrue(click(selenium, lnkStartBlank), "Could not click start blank template name",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		assertTrue(click(selenium, btnAddNewUserDefined), "Could not click add new custom section",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		assertTrue(type(selenium, txtUserDefinedName, encounterTemplateData.customSection1), "Could not type display as user defined section name",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxSelectLibrary,encounterTemplateData.selectlibrary),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		waitForPageLoad(selenium);		
		assertTrue(click(selenium,chkSelectall), "Could not click Select all check box in Section page custom section save",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSaveCustomSection), "Could not click Select all check box in Section page custom section save",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy HH:MM");
		String date=DateFormat.format(cal.getTime());
		encounterTemplateData.templateName=encounterTemplateData.templateName+date;
		assertTrue(type(selenium, txtTemplateName, encounterTemplateData.templateName), "Could not type template name",selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtAreaTemplateDescription, encounterTemplateData.templateDescription), "Could not type template description",selenium, ClassName, MethodName);		
		//It will be used for get the very first value of the visit type from the list
		assertTrue(click(selenium, ajxspecialitySuugestbox), "Could not click",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		encounterTemplateData.visitType1= getText(selenium, "//div[@class='gwt-PopupPanel dropdown-box']/div/div/div/div/div");		
		assertTrue(selectValueFromAjaxList(selenium,ajxspecialitySuugestbox,encounterTemplateData.visitType1),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, ajxassociatedVisit), "Could not type template name",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		encounterTemplateData.visitType2= getText(selenium, "//div[@class='gwt-PopupPanel dropdown-box']/div/div/div/div/div");		
		assertTrue(selectValueFromAjaxList(selenium,ajxassociatedVisit,encounterTemplateData.visitType2),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSaveEncounterTemp), "Could not click save encounter template",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!isElementPresent(selenium, btnAddNew)){
			return false;
		}
		return true;
	}

	/* function to verify Store Values Encounter Template value in summary page
	* @param 	selenium 
	* @param 	encounterTemplateData
	* @since  	June 24, 2014
	*/	
	public boolean VerifyCustomSectionAndComponent(Selenium selenium,ClinicalSettingLib encounterTemplateData){
		
		
		if(!selenium.isTextPresent(encounterTemplateData.templateDescription)){
			 return false;                       
		}

		if(!selenium.isTextPresent(encounterTemplateData.visitType1)){
			 return false;                       
		}

		if(!selenium.isTextPresent(encounterTemplateData.visitType2)){
			 return false;                       
		}

		if(!selenium.isTextPresent(encounterTemplateData.customSection1)){
			 return false;                       
		}

				return true;
		 
	}

	/* function to verify Store Values Encounter Template value in summary page
	* @param 	selenium 
	* @param 	encounterTemplateData
	* @since  	June 24, 2014
	*/	
	public boolean VerifyEncounterInExpandView(Selenium selenium,ClinicalSettingLib encounterTemplateData){
		
		
		if(!selenium.isTextPresent(encounterTemplateData.templateDescription)){
			 return false;                       
		}

		if(!selenium.isTextPresent(encounterTemplateData.visitType1)){
			 return false;                       
		}

		if(!selenium.isTextPresent(encounterTemplateData.visitType2)){
			 return false;                       
		}

		if(!selenium.isTextPresent(encounterTemplateData.customSection1)){
			 return false;                       
		}

		

		return true;
		 
	}
	/**
	 * addVisit Section
	 * Function to add Visit Section
	 * @param 	selenium
	 * @throws IOException 
	 * @since	June 25, 2014
	 */
	public boolean addVisitSection(Selenium selenium, ClinicalSettingLib encounterTemplateData) throws IOException{
		assertTrue(selectValueFromAjaxList(selenium,"templSuggestBoxsuggestBox","Visit Section"),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnAddNew), "Could not click on add new button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy HH:MM");
		String date=DateFormat.format(cal.getTime());
		encounterTemplateData.templateName=encounterTemplateData.templateName+date;
		assertTrue(type(selenium, txtTemplateName, encounterTemplateData.templateName), "Could not type template name",selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtAreaTemplateDescription, encounterTemplateData.templateDescription), "Could not type template description",selenium, ClassName, MethodName);
		
		//It will be used for get the very first value of the visit type from the list
		click(selenium, ajxSuggestBox);
		waitForPageLoad(selenium);
		encounterTemplateData.visitType1= getText(selenium, "//div[@class='gwt-PopupPanel dropdown-box']/div/div/div/div/div");
		
		assertTrue(selectValueFromAjaxList(selenium,ajxSuggestBox,encounterTemplateData.visitType1),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		click(selenium, "outlineSuggestBoxsuggestBox");
		waitForPageLoad(selenium);
		encounterTemplateData.visitType2= getText(selenium, "//div[@class='gwt-PopupPanel dropdown-box']/div/div/div/div/div");
		
		assertTrue(selectValueFromAjaxList(selenium,"outlineSuggestBoxsuggestBox",encounterTemplateData.visitType2),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, lnkStartBlank), "Could not click start blank template name",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, "css=div.canvas-item.canvas-item-empty"), "Could not click First row in create visit section page",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, "link=Title"), "Could not click Title label",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
	selenium.click("//div[2]/div/div/div[2]/input");
	selenium.focus("//div[2]/div/div/div[2]/input");
		selenium.type("//div[2]/div/div/div[2]/input", encounterTemplateData.customSection1);
		waitForPageLoad(selenium);	
		assertTrue(click(selenium, btnwidgtSave), "Could not click Save button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	assertTrue(click(selenium, btnSaveEncounterTemp), "Could not click save encounter template",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,"templSuggestBoxsuggestBox","Visit Section"),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
			if(!isElementPresent(selenium, btnAddNew)){
				return false;
			}
		
		return true;
	}
	
	
	
	
	/**
	 * addVisit Section
	 * Function to add Visit Section
	 * @param 	selenium
	 * @throws IOException 
	 * @since	June 25, 2014
	 */
	public boolean verifyduplicatewidget(Selenium selenium, ClinicalSettingLib encounterTemplateData) throws IOException{
		assertTrue(click(selenium, btnAddNew), "Could not click on add new button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy HH:MM");
		String date=DateFormat.format(cal.getTime());
		encounterTemplateData.templateName=encounterTemplateData.templateName+date;
		assertTrue(type(selenium, txtTemplateName, encounterTemplateData.templateName), "Could not type template name",selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtAreaTemplateDescription, encounterTemplateData.templateDescription), "Could not type template description",selenium, ClassName, MethodName);
		//It will be used for get the very first value of the visit type from the list
		assertTrue(click(selenium,txtWidgetRow1), "Could not click",selenium, ClassName, MethodName);
		assertTrue(click(selenium,lnkFreeTextLabelwid), "Could not click",selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtTitlelabel,"Free"), "Could not type n",selenium, ClassName, MethodName);
		assertTrue(click(selenium,btnQuestionsave), "Could not click",selenium, ClassName, MethodName);
		assertTrue(click(selenium,txtWidgetRow3), "Could not click",selenium, ClassName, MethodName);
		assertTrue(click(selenium,lnkFreeTextLabelwid), "Could not click",selenium, ClassName, MethodName);
		assertTrue(	type(selenium,txtTitlelabel,"Free"), "Could not type ",selenium, ClassName, MethodName);
		assertTrue(click(selenium,btnQuestionsave), "Could not click",selenium, ClassName, MethodName);
		assertTrue(isElementPresent(selenium,btnQuestionsave), "Could not click",selenium, ClassName, MethodName);
		return true;
	}
	
	
	
	
	
	
	/**
	 * deleteAllEncounterTemplate
	 * function to delete All Encounter Template
	 * @throws IOException 
	 * @since  June 24, 2014
	 */
	public boolean deleteAllVisitSection(Selenium selenium) throws IOException{
		boolean  encounterDeleted=true;
		assertTrue(selectValueFromAjaxList(selenium,ajxSelectiontemp,"Visit Section"),"Could not select visit type",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);

		if(isElementPresent(selenium,tbnEncounterTemplatedelete)){
		while(isElementVisible(selenium,tbnEncounterTemplatedelete))
		{
			 assertTrue(click(selenium, tbnEncounterTemplatedelete), "could not click delete button",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(click(selenium, btnYesButton), "could not click yes button",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 if(!isElementPresent(selenium,tbnEncounterTemplatedelete))
			 {
				 break;
			 }
		}}
	 
		return encounterDeleted;
	}

	/**
	 * addEncounterTemplateWithRestriction 
	 * Function to add Encounter Template with restriction
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 16,2013
	 */
	public boolean addEncounterTemplateWithRestriction(Selenium selenium, ClinicalSettingLib encounterTemplateData) throws IOException{
		assertTrue(click(selenium, btnAddNew), "Could not click on add new button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtTemplateName, encounterTemplateData.templateName), "Could not type template name",selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtAreaTemplateDescription, encounterTemplateData.templateDescription), "Could not type template description",selenium, ClassName, MethodName);
		
		//It will be used for get the very first value of the visit type from the list
		click(selenium, ajxSuggestBox);
		waitForPageLoad(selenium);
		encounterTemplateData.visitType1= getText(selenium, "//div[@class='gwt-PopupPanel dropdown-box']/div/div/div/div/div");
		
		assertTrue(selectValueFromAjaxList(selenium,ajxSuggestBox,encounterTemplateData.visitType1),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, lnkStartBlank), "Could not click start blank template name",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//check the 'review of system' check box
		if(!isChecked(selenium, chkReviewOfSystem)){
			assertTrue(click(selenium, chkReviewOfSystem), "Could not click the review of systems check box",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		assertTrue(click(selenium, lnkEditReviewOfSystem), "Could not click edit review of systems",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//check the 'Eyes' check box
		if(!isChecked(selenium, chkEyes)){
			assertTrue(click(selenium, chkEyes), "Could not click the 'eyes' check box",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		assertTrue(click(selenium, lnkAddRestrictionEyes), "Could not click 'add restriction' to eyes",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(encounterTemplateData.testCaseId.equalsIgnoreCase("TC_ET_014") || encounterTemplateData.testCaseId.equalsIgnoreCase("TC_ET_015") 
		   || encounterTemplateData.testCaseId.equalsIgnoreCase("TC_ET_016")){
			//set the restriction based age
			assertTrue(selectValueFromAjaxList(selenium,ajxAgeSuggestBox,encounterTemplateData.restrictType),"Could not select the age restriction"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(encounterTemplateData.testCaseId.equalsIgnoreCase("TC_ET_014")){
				assertTrue(type(selenium, txtAgeRestriction1, encounterTemplateData.ageRestriction1), "Could not type age restriction",selenium, ClassName, MethodName);
				assertTrue(type(selenium, txtAgeRestriction2, encounterTemplateData.ageRestriction2), "Could not type age restriction",selenium, ClassName, MethodName);
			}
			else if(encounterTemplateData.testCaseId.equalsIgnoreCase("TC_ET_015")){
				assertTrue(type(selenium, txtAgeRestriction1, encounterTemplateData.ageRestriction1), "Could not type age restriction",selenium, ClassName, MethodName);
			}
			else if(encounterTemplateData.testCaseId.equalsIgnoreCase("TC_ET_016")){
				assertTrue(type(selenium, txtAgeRestriction2, encounterTemplateData.ageRestriction1), "Could not type age restriction",selenium, ClassName, MethodName);
			}
			
			assertTrue(selectValueFromAjaxList(selenium,ajxAgeUnitSuggestBox,encounterTemplateData.ageRestrictionUnit),"Could not select the age restriction unit"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}
		else{
			//set the restriction based gender
			assertTrue(selectValueFromAjaxList(selenium,ajxSexSuggestBox,encounterTemplateData.restrictType),"Could not select the gender"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		assertTrue(click(selenium, btnSaveCustomSection), "Could not click save the sub menu changes in encounter template",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, btnSaveEncounterTemp), "Could not click save encounter template",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(!isElementPresent(selenium, btnAddNew)){
			return false;
		}
		return true;
	}
	
	/**
	 * addEncounterTemplateWithROSAndPE 
	 * Function to add Encounter Template With ROS And PE
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 17,2013
	 */
	public boolean addEncounterTemplateWithROSAndPE(Selenium selenium, ClinicalSettingLib encounterTemplateData) throws IOException{
		assertTrue(click(selenium, btnAddNew), "Could not click on add new button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtTemplateName, encounterTemplateData.templateName), "Could not type template name",selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtAreaTemplateDescription, encounterTemplateData.templateDescription), "Could not type template description",selenium, ClassName, MethodName);
		
		//It will be used for get the very first value of the visit type from the list
		assertTrue(click(selenium, ajxassociatedVisit),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);

		encounterTemplateData.visitType1= getText(selenium, "//div[@class='gwt-PopupPanel dropdown-box']/div/div/div/div/div");
		
		assertTrue(selectValueFromAjaxList(selenium,ajxassociatedVisit,encounterTemplateData.visitType1),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, lnkStartBlank), "Could not click start blank template name",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//check the 'review of system' check box
		if(!isChecked(selenium, Reviewsystems)){
			assertTrue(click(selenium, Reviewsystems), "Could not click the review of systems check box",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		//check the 'Physical Examination (Audit)' check box
		if(!isChecked(selenium, PhysicalExam1)){
			assertTrue(click(selenium, PhysicalExam1), "Could not click the Physical Examination (Audit) check box",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		//check the 'Physical Examination (Pediatric)' check box
		if(!isChecked(selenium, PhysicalExam2)){
			assertTrue(click(selenium, PhysicalExam2), "Could not click the Physical Examination (Pediatric) check box",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		assertTrue(click(selenium, lnkEditReviewOfSystem), "Could not click edit review of systems",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//check the 'Eyes' check box
		if(!isChecked(selenium, chkEyes)){
assertTrue(click(selenium, chkEyes), "Could not click the 'eyes' check box",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		//check the 'Ears' check box
		if(!isChecked(selenium, chkEars)){
			assertTrue(click(selenium, chkEars), "Could not click the 'ears' check box",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		assertTrue(click(selenium, btnSaveCustomSection), "Could not click save the sub menu changes in encounter template",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, btnSaveEncounterTemp), "Could not click save encounter template",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(!isElementPresent(selenium, btnAddNew)){
			return false;
		}

		return true;
	}
	

	/**
	 * addEncounterTemplateWithMultipleUserDefinedSection
	 * Function to add Encounter Template With Multiple User Defined Section
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Dec 19,2013
	 */
	
	public boolean addEncounterTemplateWithMultipleUserDefinedSection(Selenium selenium, ClinicalSettingLib encounterTemplateData ) throws IOException{
		//Add section #1
		assertTrue(click(selenium, lnkStartBlank), "Could not click start blank template name",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		assertTrue(click(selenium, btnAddNewUserDefined), "Could not click add new custom section",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		assertTrue(type(selenium, txtUserDefinedName, encounterTemplateData.customSection1), "Could not type display as user defined section name",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxSelectLibrary,encounterTemplateData.selectlibrary),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		assertTrue(click(selenium, btnSaveCustomSection), "Could not click Select all check box in Section page custom section save",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		//Add section #3
			
		assertTrue(click(selenium, btnAddNewUserDefined), "Could not click add new custom section",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		assertTrue(type(selenium, txtUserDefinedDisplayAs2, encounterTemplateData.customSection2), "Could not type display as user defined section name",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,templateName2,"Use Custom Content"),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		assertTrue(click(selenium, btnSaveCustomSection), "Could not click Select all check box in Section page custom section save",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		//Add section #3
				
		assertTrue(click(selenium, btnAddNewUserDefined), "Could not click add new custom section",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		assertTrue(type(selenium, txtUserDefinedDisplayAs3, encounterTemplateData.customSection3), "Could not type display as user defined section name",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,templateName3,"Use Custom Content"),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSaveCustomSection), "Could not click Select all check box in Section page custom section save",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		//Add section #4
		assertTrue(click(selenium, btnAddNewUserDefined), "Could not click add new custom section",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		assertTrue(type(selenium, txtUserDefinedDisplayAs4, encounterTemplateData.customSection4), "Could not type display as user defined section name",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,templateName4,"Use Custom Content"),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		
		assertTrue(click(selenium, btnSaveCustomSection), "Could not click Select all check box in Section page custom section save",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy HH:MM");
		String date=DateFormat.format(cal.getTime());
		encounterTemplateData.templateName=encounterTemplateData.templateName+date;
		assertTrue(type(selenium, txtTemplateName, encounterTemplateData.templateName), "Could not type template name",selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtAreaTemplateDescription, encounterTemplateData.templateDescription), "Could not type template description",selenium, ClassName, MethodName);		
		//It will be used for get the very first value of the visit type from the list
		assertTrue(click(selenium, ajxspecialitySuugestbox), "Could not click",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		encounterTemplateData.visitType1= getText(selenium, "//div[@class='gwt-PopupPanel dropdown-box']/div/div/div/div/div");		
		assertTrue(selectValueFromAjaxList(selenium,ajxspecialitySuugestbox,encounterTemplateData.visitType1),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, ajxassociatedVisit), "Could not click",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		encounterTemplateData.visitType2= getText(selenium, "//div[@class='gwt-PopupPanel dropdown-box']/div/div/div/div/div");		
		assertTrue(selectValueFromAjaxList(selenium,ajxassociatedVisit,encounterTemplateData.visitType2),"Could not select visit type"+encounterTemplateData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSaveEncounterTemp), "Could not click save encounter template",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		if(!isElementPresent(selenium, btnAddNew)){
			return false;
		}
		return true;
	}
	

	/**
	 * verifyUserDefindDetails
	 * function to verify User Defind Details
	 * @throws IOException 
	 * @since Dec 19, 2013
	 */	
	
	public boolean verifyUserDefindDetails(Selenium selenium,ClinicalSettingLib encounterTemplateData){
		
		if(!selenium.isTextPresent(encounterTemplateData.customSection1)){
			return false;
		}
		
		if(!selenium.isTextPresent(encounterTemplateData.customSection2)){
			return false;
		}
		if(!selenium.isTextPresent(encounterTemplateData.customSection3)){
			return false;
		}
		if(!selenium.isTextPresent(encounterTemplateData.customSection4)){
			return false;
		}
		
		return true;
	}
	
	
	
	
	/**
	 * noAccessUserClinicalSetting
	 * function to No Access User System Settings
	 * @throws IOException 
	 * @since Nov 08, 2013
	 */	
	public boolean noAccessUserClinicalSetting(Selenium selenium, ClinicalSettingLib cdsData, String userAccount) throws IOException {
		try{
			
			
			assertTrue(click(selenium,lnkQuickLink),"Could not click on the link" + cdsData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!selenium.isElementPresent("clinicalSettingsAction"),"System Setting Link is Visible",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			return true;
		}
		
			catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + cdsData.toString());
			return false;
		}
	}
	
	/**
	 * fullViewAccessUserClinicalSetting
	 * function to Full View Access User System Settings
	 * @throws IOException 
	 * @since  	     August 30, 2013
	 */	
	public boolean fullViewAccessUserClinicalSetting(Selenium selenium, ClinicalSettingLib cdsData, String userAccount) throws IOException {
		try{
			
			assertTrue(click(selenium,lnkSettings),"Could not click on the link" + cdsData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClinicalSettingsLink),"Could not click the systemSettings link;More Deatils:"+cdsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			
			return true;
		}
		
			catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + cdsData.toString());
			return false;
		}
	}
	
	  /**
	     * noAccessUserClinicalList
	     * function to No Access User System Settings
	     * @throws IOException 
	     * @since Nov 11, 2013
	     */   
	    public boolean noAccessUserClinicalList(Selenium selenium, ClinicalSettingLib cdsData, String userAccount) throws IOException {
	          try{
	                
	                
	                assertTrue(click(selenium,lnkQuickLink),"Could not click on the link" + cdsData .toString(), selenium, ClassName, MethodName);
	                waitForPageLoad(selenium);
	                
	                assertTrue(!selenium.isElementPresent("css=#clinicalListsAction > span.actionItemSpan"),"System Setting Link is Visible",selenium, ClassName, MethodName);
	                waitForPageLoad(selenium);
	                
	                assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
	                assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
	                return true;
	          }
	          
	                catch(RuntimeException e){
	                e.printStackTrace();
	                Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + cdsData.toString());
	                return false;
	          }
	    }
	    
	    /**
	     * fullViewAccessUserClinicalList
	     * function to Full View Access User System Settings
	     * @throws IOException 
	     * @since       August 30, 2013
	     */   
	    public boolean fullViewAccessUserClinicalList(Selenium selenium, ClinicalSettingLib cdsData, String userAccount) throws IOException {
	          try{
	                
	                assertTrue(click(selenium,lnkQuickLink),"Could not click on the link" + cdsData .toString(), selenium, ClassName, MethodName);
	                waitForPageLoad(selenium);
	                assertTrue(click(selenium,lnkClinicalList),"Could not click the systemSettings link;More Deatils:"+cdsData.toString(), selenium, ClassName, MethodName);
	                waitForPageLoad(selenium);
	                
	                assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
	                assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
	                
	                return true;
	          }
	          
	                catch(RuntimeException e){
	                e.printStackTrace();
	                Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + cdsData.toString());
	                return false;
	          }
	    }
	    
	    
	    /**
		 * navigateToVisitOutlineTemplate 
		 * Function for Navigate to visit online template from Homepage  
		 * @param 	selenium
		 * @throws IOException 
		 * @since	Oct 20,2014
		 */
		public boolean navigateToVisitOutlineTemplate(Selenium selenium) throws IOException{
			assertTrue(click(selenium, lnkSettings), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkClinicalSettingsLink), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkEncounterTemplate), "Could not click on practice library link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxSelectiontemp,"Visit Outline"),"Could not select template type", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!isElementPresent(selenium, btnAddCustom)){
				return false;
			}
			return true;
		}
		
		
		 /**
		 * verifyVisitOutlineTemplatePage 
		 * Function for Navigate to visit online template from Homepage  
		 * @param 	selenium
		 * @throws IOException 
		 * @since	Oct 20,2014
		 */
		public boolean verifyVisitOutlineTemplatePage(Selenium selenium) throws IOException{
			assertTrue(isElementPresent(selenium,txtTemplateName),"Template Name textBox not present",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,txtAreaTemplateDescription),"Template description not present",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,ajxassociatedVisit),"Visit Suggest Box",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,ajxspecialitySuugestbox),"Unable to find speciality SuggestBox",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
			}
		

		public boolean CreateVisitSectionWithWidget(Selenium selenium,ClinicalSettingLib encounterTemplateTestData) throws IOException, InterruptedException
			    {	
			    	assertTrue(click(selenium, btnAddCustom),"Click on Add section failed",selenium, ClassName, MethodName);
			    	waitForPageLoad(selenium);
			    	Calendar cal=Calendar.getInstance();
			    	SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy HH:MM");
			    	String date=DateFormat.format(cal.getTime());
			    	encounterTemplateTestData.NumericLabel=encounterTemplateTestData.NumericLabel+date;
			    	encounterTemplateTestData.FreeTextLabel=encounterTemplateTestData.FreeTextLabel+date;
			    	encounterTemplateTestData.QuestionLabel=encounterTemplateTestData.QuestionLabel+date;
			    	encounterTemplateTestData.TitleLabel=encounterTemplateTestData.TitleLabel+date;	
			    	encounterTemplateTestData.SectionName=encounterTemplateTestData.SectionName+date;
			    	 if(isElementPresent(selenium, btnErrorClose))
			 			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			    	assertTrue(type(selenium, txtTemplateName,encounterTemplateTestData.SectionName), "Could not type template name",selenium, ClassName, MethodName);
			    	assertTrue(type(selenium, txtAreaTemplateDescription, encounterTemplateTestData.SectionDescription), "Could not type template description",selenium, ClassName, MethodName);
			    	
			    /*	It will be used for get the very first value of the visit type from the list
			    	click(selenium, ajxSuggestBox);
			    	waitForPageLoad(selenium);
			    	encounterTemplateTestData.visitType1= getText(selenium, "//div[@class='gwt-PopupPanel dropdown-box']/div/div/div/div/div");*/
			    	if(!encounterTemplateTestData.testCaseId.equals("TC_VS_003")){
			    	//Free Text Widget
			    	assertTrue(selectValueFromAjaxList(selenium,ajxSpecialitySuggest,encounterTemplateTestData.visitType1),"Could not select visit type"+encounterTemplateTestData.toString(),selenium, ClassName, MethodName);
			    	waitForPageLoad(selenium);
			    	//assertTrue(click(selenium, lnkStartBlank), "Could not click start blank template name",selenium, ClassName, MethodName);
			    	//waitForPageLoad(selenium);
			    	assertTrue(click(selenium, txtWidgetRow1),"Coild not click the first row in Create visit sectio page", selenium, ClassName, MethodName);	
			    	waitForPageLoad(selenium);
			    	assertTrue(click(selenium, lnkFreeTextLabelwid),"Coild not click the first row in Create visit sectio page", selenium, ClassName, MethodName);
			    	waitForPageLoad(selenium);
			    	assertTrue(type(selenium, txtFreeTextLable,encounterTemplateTestData.FreeTextLabel),"Could not type the lable name", selenium, ClassName, MethodName);
			    	waitForPageLoad(selenium);
			    	assertTrue(click(selenium, btnSaveWidget),"Click on Save button  in section failed", selenium, ClassName, MethodName);	
			    	waitForPageLoad(selenium);
			    	waitForPageLoad(selenium);
			    	assertTrue(selenium.isTextPresent(encounterTemplateTestData.FreeTextLabel),"Numeric Label Not created", selenium, ClassName, MethodName);	
			    	
			    	if(encounterTemplateTestData.testCaseId.equals("TC_VS_004")){
			    		return true;
			    	}
			    	//Numeric Widget
			    	
			    	assertTrue(click(selenium, txtWidgetRow3),"Coild not click the first row in Create visit sectio page", selenium, ClassName, MethodName);	
			    	waitForPageLoad(selenium);
			    	assertTrue(click(selenium, lnkNumericWidget),"Coild not click the first row in Create visit sectio page", selenium, ClassName, MethodName);
			    	waitForPageLoad(selenium);
			    	assertTrue(type(selenium, txtNumericLabel,encounterTemplateTestData.NumericLabel),"Could not type the lable name", selenium, ClassName, MethodName);
			    	waitForPageLoad(selenium);
			    	assertTrue(selectValueFromAjaxList(selenium,ajxMumericFormat,encounterTemplateTestData.NumericLabelFormet),"Could not select visit type"+encounterTemplateTestData.toString(),selenium, ClassName, MethodName);
			    	waitForPageLoad(selenium);
			    	assertTrue(type(selenium, txtNumericMin,encounterTemplateTestData.Minvalue),"Could not type the MAx value", selenium, ClassName, MethodName);
			    	waitForPageLoad(selenium);
			    	assertTrue(type(selenium, txtNumericMax,encounterTemplateTestData.MaxValue),"Could not type the  Min value", selenium, ClassName, MethodName);
			    	waitForPageLoad(selenium);
			    	assertTrue(click(selenium, btnNumericWidgetSave),"Could not click the save button", selenium, ClassName, MethodName);	
			    	waitForPageLoad(selenium);
			    	waitForPageLoad(selenium);
			    	assertTrue(selenium.isTextPresent(encounterTemplateTestData.NumericLabel),"Numeric Label Not created", selenium, ClassName, MethodName);	
			    	}
			    	
			    	//Question Widget
			    	
			    	assertTrue(click(selenium, txtWidgetRow5),"Coild not click the first row in Create visit sectio page", selenium, ClassName, MethodName);	
			    	waitForPageLoad(selenium);
			    	assertTrue(click(selenium, lnkQuestionWidget),"Coild not click the first row in Create visit sectio page", selenium, ClassName, MethodName);
			    	waitForPageLoad(selenium);
			    	assertTrue(type(selenium, txtQuestionLabel,encounterTemplateTestData.QuestionLabel),"Could not type the lable name", selenium, ClassName, MethodName);
			    	waitForPageLoad(selenium);
			    	assertTrue(type(selenium, txtQuestionTotalAnswer,encounterTemplateTestData.QuestionAnswer),"Could not type the lable name", selenium, ClassName, MethodName);
			    	selenium.fireEvent(txtQuestionTotalAnswer, "blur");
			    	waitForPageLoad(selenium);
			    	assertTrue(type(selenium, txtQuestionAns1,encounterTemplateTestData.Answer1),"Could not type the lable name", selenium, ClassName, MethodName);
			    	assertTrue(type(selenium, txtQuestionAns2,encounterTemplateTestData.Answer2),"Could not type the lable name", selenium, ClassName, MethodName);
			    	assertTrue(type(selenium, txtQuestionAns3,encounterTemplateTestData.Answer3),"Could not type the lable name", selenium, ClassName, MethodName);			
			    	assertTrue(selectValueFromAjaxList(selenium,ajxQuestionDefault,encounterTemplateTestData.QuestionDefault),"Could not select value"+encounterTemplateTestData.toString(),selenium, ClassName, MethodName);
			    	waitForPageLoad(selenium);
			    	assertTrue(click(selenium, btnQuestionsave),"Click on Save button  in section failed",selenium, ClassName, MethodName);
			    	waitForPageLoad(selenium);
			    	waitForPageLoad(selenium);
			    	assertTrue(selenium.isTextPresent(encounterTemplateTestData.QuestionLabel),"Numeric Label Not created", selenium, ClassName, MethodName);	
			    	
			    	if(!encounterTemplateTestData.testCaseId.equals("TC_VS_003")){
			    	//TiTle Widget
			    	assertTrue(click(selenium, txtWidgetRow7),"Coild not click the first row in Create visit sectio page", selenium, ClassName, MethodName);	
			    	waitForPageLoad(selenium);
			    	assertTrue(click(selenium, lnkTitleWidget),"Coild not click the first row in Create visit sectio page", selenium, ClassName, MethodName);
			    	waitForPageLoad(selenium);
			    	assertTrue(type(selenium, txtTitlelabel,encounterTemplateTestData.TitleLabel),"Could not type the lable name", selenium, ClassName, MethodName);
			    	waitForPageLoad(selenium);
			    	assertTrue(click(selenium, btnQuestionsave),"Click on Save button  in section failed",selenium, ClassName, MethodName);
			    	waitForPageLoad(selenium);
			    	waitForPageLoad(selenium);
			    	assertTrue(selenium.isTextPresent(encounterTemplateTestData.TitleLabel),"Numeric Label Not created", selenium, ClassName, MethodName);	
			    	waitForPageLoad(selenium);
			    	assertTrue(click(selenium, btntopsave),"Coild not click the first row in Create visit sectio page", selenium, ClassName, MethodName);	
			    	waitForPageLoad(selenium);
			    	}
			    	return true;
			    }


	    public boolean selectdefaulttemplate(Selenium selenium) throws IOException{

	       		assertTrue(selenium.getText(lblTemplate).contains("Default"),"Could not click default template name",selenium, ClassName, MethodName);
	    		assertTrue(click(selenium,lblTemplate), "Could not click default template name",selenium, ClassName, MethodName);
	       	return true;
	    }
	    public boolean VerifyCreatedSection(Selenium selenium,ClinicalSettingLib encounterTemplateTestData)
	    {
	    	if(!selenium.isTextPresent(encounterTemplateTestData.FreeTextLabel)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.QuestionLabel)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.TitleLabel)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.NumericLabel)){
	    		return false;
	    	}
	    	
	    	return true;
	    		
	    }

	    public boolean VerifyEditedVisitSection(Selenium selenium,ClinicalSettingLib encounterTemplateTestData)
	    {
	    	if(!selenium.isTextPresent(encounterTemplateTestData.FreeTextLabelEdit)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.TitleLabelEdit)){
	    		return false;
	    	}
	    		return true;
	    		
	    }



	    public boolean VerifyDefaultTemplateInEncounterNote(Selenium selenium,ClinicalSettingLib encounterTemplateTestData)
	    {
	    	if(!selenium.isTextPresent(encounterTemplateTestData.FreeTextLabel)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.QuestionLabel)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.NumericLabel)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.TitleLabel)){
	    		return false;
	    	}	if(!selenium.isTextPresent(encounterTemplateTestData.Answer1)){
	    		return false;
	    	}	if(!selenium.isTextPresent(encounterTemplateTestData.Answer2)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.Answer3)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.ComponenetName)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.SectionName)){
	    		return false;
	    	}
	    		return true;
	    }

	    public boolean VerifyEditedDefaultTemplateInEncounterNote(Selenium selenium,ClinicalSettingLib encounterTemplateTestData)
	    {
	    	if(!selenium.isTextPresent(encounterTemplateTestData.FreeTextLabel)){
	    		return false;
	    	}
	    	//waitForPageLoad(selenium);
	    	if(!selenium.isTextPresent(encounterTemplateTestData.QuestionLabel)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.NumericLabel)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.TitleLabel)){
	    		return false;
	    	}	
	    	if(!selenium.isTextPresent(encounterTemplateTestData.Answer1)){
	    		return false;
	    	}	
	    	if(!selenium.isTextPresent(encounterTemplateTestData.Answer2)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.Answer3)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.ComponenetName))
	    	{
	    		return false;
	    	}if(!selenium.isTextPresent(encounterTemplateTestData.FreeTextLabelEdit)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.TitleLabelEdit)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.SectionName)){
	    		return false;
	    	}
	    	
	    		return true;
	    }


public boolean VerifyEditedDefaultTemplateInPrevouusEncounterNote(Selenium selenium,ClinicalSettingLib encounterTemplateTestData){
	    	
	    	if(!selenium.isTextPresent(encounterTemplateTestData.FreeTextLabel)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.QuestionLabel)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.NumericLabel)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.TitleLabel)){
	    		return false;
	    	}	if(!selenium.isTextPresent(encounterTemplateTestData.Answer1)){
	    		return false;
	    	}	if(!selenium.isTextPresent(encounterTemplateTestData.Answer2)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.Answer3)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.ComponenetName)){
	    		return false;
	    	}if(selenium.isTextPresent(encounterTemplateTestData.FreeTextLabelEdit)){
	    		return false;
	    	}
	    	if(selenium.isTextPresent(encounterTemplateTestData.TitleLabelEdit)){
	    		return false;
	    	}
	    	if(!selenium.isTextPresent(encounterTemplateTestData.SectionName)){
	    		return false;
	    	}
	    	
	    		return true;
	    	
	    	
	    }


      public boolean DeleteCustomComponenetInEditDefalutPage(Selenium selenium) throws IOException
       {
	while(true)
	    	{
	    	int getXpathCount=1;
	    	 while(isElementPresent(selenium,"xpath=(//a[contains(text(),'Remove')])["+getXpathCount+"]"))
	    		{	
	    		 getXpathCount++;
	    		}
	    	 getXpathCount=getXpathCount-1;
	    	int count=1;
	    while(!isElementVisible(selenium,"xpath=(//a[contains(text(),'Remove')])["+count+"]"))
	    		{	
	    	count++;
	    	if(count>getXpathCount)
 	    {
	    		return true;
 	    }
	    		}
	    		 assertTrue(click(selenium, "xpath=(//a[contains(text(),'Remove')])["+count+"]"),"could not click the deleted button",selenium, ClassName, MethodName);
	    		 waitForPageLoad(selenium);
	    		 assertTrue(click(selenium, btnYesButton), "could not click yes button",selenium, ClassName, MethodName);
	    		 waitForPageLoad(selenium);
	    	}
	    }

	    public boolean EditVisitSectionWithWidget(Selenium selenium,ClinicalSettingLib encounterTemplateTestData) throws IOException 
	    {
	    	try
	    	{
	    	Calendar cal=Calendar.getInstance();
	    	SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy HH:MM");
	    	String date=DateFormat.format(cal.getTime());
	    	encounterTemplateTestData.FreeTextLabelEdit=encounterTemplateTestData.FreeTextLabelEdit+date;	
	    	encounterTemplateTestData.TitleLabelEdit=encounterTemplateTestData.TitleLabelEdit+date;		
	    	assertTrue(click(selenium, txtWidgetRow9),"Coild not click the first row in Create visit sectio page", selenium, ClassName, MethodName);	
	    	waitForPageLoad(selenium);
	    	assertTrue(click(selenium, lnkFreeTextLabelwid),"Coild not click the first row in Create visit sectio page", selenium, ClassName, MethodName);
	    	waitForPageLoad(selenium);
	    	assertTrue(type(selenium, txtFreeTextLable,encounterTemplateTestData.FreeTextLabelEdit),"Could not type the lable name", selenium, ClassName, MethodName);	
	    	assertTrue(click(selenium, btnSaveWidget),"Click on Save button  in section failed",selenium, ClassName, MethodName);
	    	waitForPageLoad(selenium);
	    	assertTrue(selenium.isTextPresent(encounterTemplateTestData.FreeTextLabelEdit),"Numeric Label Not created", selenium, ClassName, MethodName);	
	    	waitForPageLoad(selenium);
	    	waitForPageLoad(selenium);
	    	assertTrue(click(selenium, txtWidgetRow11),"Coild not click the first row in Create visit sectio page", selenium, ClassName, MethodName);	
	    	waitForPageLoad(selenium);
	    	assertTrue(click(selenium, lnkTitleWidget),"Coild not click the first row in Create visit sectio page", selenium, ClassName, MethodName);
	    	waitForPageLoad(selenium);
	    	assertTrue(type(selenium, txtTitlelabel,encounterTemplateTestData.TitleLabelEdit),"Could not type the lable name", selenium, ClassName, MethodName);
	    	waitForPageLoad(selenium);
	    	assertTrue(click(selenium, btnQuestionsave),"Click on Save button  in section failed",selenium, ClassName, MethodName);
	    	waitForPageLoad(selenium);
	    	assertTrue(click(selenium, btnSectionSave),"Coild not click the first row in Create visit sectio page", selenium, ClassName, MethodName);	
	    	waitForPageLoad(selenium);
	    	}catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	return true;
	    	
	    }

	    /**
		 * searchAddEditVisitSection 
		 * Function for Edit widget 
		 * @param 	selenium
		 * @throws Exception 
		 * @since	Oct 30,2014
		 */
	    
	    public boolean searchAddEditVisitSection(Selenium selenium, ClinicalSettingLib encounterTemplateTestData)throws IOException
	    {         
	    	assertTrue(click(selenium,btnAddCustom),"Unable to click the create new button",selenium,ClassName,MethodName);
	    	waitForPageLoad(selenium);
			assertTrue(click(selenium,widgetLink1),"Unable to click the widget",selenium,ClassName,MethodName);
			assertTrue(type(selenium,lnkAddResources,encounterTemplateTestData.FreeTextLabel),"Unable to type the Sectionn Name",selenium,ClassName,MethodName);
			selenium.clickAt(btnsearch, "");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAddWidget),"Add to widget is fail",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
				assertTrue(click(selenium,widgetLink3),"Unable to click the widget",selenium,ClassName,MethodName);
			
			assertTrue(type(selenium,lnkAddResources,encounterTemplateTestData.FreeTextLabel),"Unable to type the Sectionn Name",selenium,ClassName,MethodName);
			selenium.clickAt(btnsearch, "");
			assertTrue(click(selenium,txtEditWidget),"Unable to click the edit button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtFreeTextLable,encounterTemplateTestData.SectionName+"Edit"),"Unable to type the Sectionn Name",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnSave2),"Unable to click the save button",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnPatientSave),"Unable to press the entire save button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		
	    	return true;
	 
	    }

	    public boolean selectPractice(Selenium selenium) throws IOException
	    {
	    	waitForPageLoad(selenium);
	    	waitForPageLoad(selenium);
	    	waitForPageLoad(selenium);
	    	if(!getText(selenium,lnkLocationMenuHeader).contains("Practice Libaray")){
	    		assertTrue(click(selenium,lnkLocationMenuHeader),"Could not click on practices link:", selenium, ClassName, MethodName);
	    		waitForPageLoad(selenium);
	    	 int Count;
	    		int Count1=(Integer) selenium.getXpathCount("//tr/td/a/span");
	    		for(Count=1;Count<=Count1;Count++)		{
	    			if(getText(selenium,"//tr["+Count+"]/td/a/span").contains("Practice Libaray")){
	    				
	    				assertTrue(click(selenium,"//tr["+Count+"]/td/a/span"),"Could not click on practices link:", selenium, ClassName, MethodName);
	    				waitForPageLoad(selenium);
	    			}
	    		}		
	    	}		
	    	return true;
	    }
	    
	    public boolean selectAutomationNexiaPractice(Selenium selenium) throws IOException
	    {
	    	waitForPageLoad(selenium);
	    	waitForPageLoad(selenium);
	    	waitForPageLoad(selenium);
	    	if(!getText(selenium,lnkLocationMenuHeader).trim().contains("Automation Nexia")){
	    		assertTrue(click(selenium,lnkLocationMenuHeader),"Could not click on practices link:", selenium, ClassName, MethodName);
	    		waitForPageLoad(selenium);
	    	 int Count;
	    		int Count1=(Integer) selenium.getXpathCount("//tr/td/a/span");
	    		for(Count=1;Count<=Count1;Count++)		{
	    			if(getText(selenium,"//tr["+Count+"]/td/a/span").contains("Automation Nexia Clinic")){
	    				
	    				assertTrue(click(selenium,"//tr["+Count+"]/td/a/span"),"Could not click on practices link:", selenium, ClassName, MethodName);
	    				waitForPageLoad(selenium);
	    			}
	    		}		
	    	}		
	    	return true;
	    }
	    
	    

	    public boolean selectAutomationPractice(Selenium selenium) throws IOException
	    {

	    	if(!getText(selenium,lnkLocationMenuHeader).contains("Automation")){
	    		assertTrue(click(selenium,lnkLocationMenuHeader),"Could not click on practices link:", selenium, ClassName, MethodName);
	    		waitForPageLoad(selenium);
	    	 int Count;
	    		int Count1=(Integer) selenium.getXpathCount("//tr/td/a/span");
	    		for(Count=1;Count<=Count1;Count++)		{
	    			if(getText(selenium,"//tr["+Count+"]/td/a/span").contains("Automation Nexia Clinic")){
	    				
	    				assertTrue(click(selenium,"//tr["+Count+"]/td/a/span"),"Could not click on practices link:", selenium, ClassName, MethodName);
	    				waitForPageLoad(selenium);
	    			}
	    		}		
	    	}		
	    	return true;
	    }
         /**
		 * EditDefaultTemplateInVisitOutline 
		 * Function for Edit Default template in VisitOutline 
		 * @param 	selenium
		 * @throws IOException 
		 * @since	Oct 28,2014
		 */
	    public boolean editDefaultTemplateInVisitOutline(Selenium selenium,ClinicalSettingLib encounterTemplateTestData)throws IOException
	    {
	    	assertTrue(selenium.getText(lblTemplate).contains("Default"),"Default template doesn't Present default template name",selenium, ClassName, MethodName);
	    	assertTrue(click(selenium,btnVisitysectionEdit),"Unable to click the Edit button",selenium, ClassName, MethodName);
	    	waitForPageLoad(selenium);
	    	if(!isElementPresent(selenium,lnkEditDefaultTemp))
	    	{
	    	assertTrue(click(selenium,lnkAddNewComponent),"Unable to click the add new component button",selenium, ClassName, MethodName);
	    	waitForPageLoad(selenium);
	    	}
	    	assertTrue(selectValueFromAjaxList(selenium,lnkEditDefaultTemp,encounterTemplateTestData.selectlibrary),"Unable to select the value in the ajax list",selenium,ClassName, MethodName);
	    	waitForPageLoad(selenium);
	    	assertTrue(click(selenium,btnSaveCustomSection),"Unable to click the save button",selenium, ClassName, MethodName);
	    	waitForPageLoad(selenium);
	    	assertTrue(type(selenium,lnkCustomTextInEdit,encounterTemplateTestData.section),"Unable to enter the value in the text field",selenium,ClassName,MethodName);
	    	assertTrue(click(selenium,btnSave2),"Unable to save the template",selenium,ClassName, MethodName);
	    	waitForPageLoad(selenium);
	    	return true;
	    }
	    /**
		 * verifyEditDefaultTemplateInVisitOutline 
		 * Function for Edit Default template in VisitOutline 
		 * @param 	selenium
		 * @throws IOException 
		 * @since	Oct 29,2014
		 */
	    public boolean verifyEditDefaultTemplateInVisitOutline(Selenium selenium,ClinicalSettingLib encounterTemplateTestData)throws IOException
	    {
	    	assertTrue(selenium.getText(lblTemplate).contains("Default"),"Default template doesn't Present default template name",selenium, ClassName, MethodName);
	    	assertTrue(click(selenium,btnVisitysectionEdit),"Unable to click the Edit button",selenium, ClassName, MethodName);
	    	waitForPageLoad(selenium);
	    	if(!isElementPresent(selenium,lnkEditDefaultTemp))
	    	{
	    	assertTrue(click(selenium,lnkAddNewComponent),"Unable to click the add new component button",selenium, ClassName, MethodName);
	    	waitForPageLoad(selenium);
	    	}
	    	assertTrue(selectValueFromAjaxList(selenium,lnkEditDefaultTemp,encounterTemplateTestData.selectlibrary),"Unable to select the value in the ajax list",selenium,ClassName, MethodName);
	    	waitForPageLoad(selenium);
	    	assertTrue(click(selenium,btnSaveCustomSection),"Unable to click the save button",selenium, ClassName, MethodName);
	    	waitForPageLoad(selenium);
	    	encounterTemplateTestData.sectionEdit	=encounterTemplateTestData.section+"Edited";
	    	assertTrue(type(selenium,lnkCustomTextInEdit,encounterTemplateTestData.sectionEdit),"Unable to enter the value in the text field",selenium,ClassName,MethodName);
	    	assertTrue(click(selenium,btnSave2),"Unable to save the template",selenium,ClassName, MethodName);
	    	waitForPageLoad(selenium);
	    	return true;
	    }
	    /**
		 * NavigateToPatientToPatientChart 
		 * Function for Navigate to patient Data to Encounter Template 
		 * @param 	selenium
		 * @throws IOException 
		 * @since	Oct 28,2014
		 */
	    public boolean NavigateToPatientToPatientChart(Selenium selenium)throws IOException
	    {
	    	assertTrue(click(selenium,lnkPatientOptions),"Unable to click patient options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSave),"Unable to click patient chart link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
	    }
	    /**
		 * NaviageToPatientRegisterationpageToEncounter 
		 * Function for patient data page to patient encounter page
		 * @param 	selenium
		 * @throws IOException 
		 * @since	Oct 28,2014
		 */
	    public boolean NaviageToPatientRegisterationpageToEncounter(Selenium selenium)throws IOException
	    {
	    	assertTrue(click(selenium, lnkQuickLink), "Could not click on Quick Actions",selenium, ClassName, MethodName);
	    	waitForPageLoad(selenium);
	    	assertTrue(click(selenium,lnknewPatientAction),"Unable to click new patient registration link",selenium,ClassName, MethodName);
	    	waitForPageLoad(selenium);
	     return true;	
	    }
	    public boolean cancelEncounterTemplate(Selenium selenium)throws IOException
	    {
	    	assertTrue(click(selenium,lnkEncounterAction),"Unable to find Action link for encounter",selenium,ClassName,MethodName);
	    	assertTrue(click(selenium,lnkCancelEncounterTemp),"Unable to Cancel the encounter",selenium,ClassName,MethodName);
	    	assertTrue(click(selenium,btnYesButton),"Unable to click the yes Button",selenium,ClassName,MethodName);
	    	waitForPageLoad(selenium);
	    	return true;
	    }
	    /**
		 * verifyDefaultEncounterTemplate 
		 * Function for verify Default template data in the patient encounter page
		 * @param 	selenium
		 * @throws IOException 
		 * @since	Oct 28,2014
		 */
	    public boolean verifyDefaultEncounterTemplate(Selenium selenium,ClinicalSettingLib encounterTemplateTestData)throws IOException
	    {
	    	assertTrue(click(selenium,btnBeginEncounter),"Unable to click Begin Encounter Button",selenium,ClassName,MethodName);
	    	waitForPageLoad(selenium);
	    	waitForPageLoad(selenium);
	        assertTrue(isTextPresent(selenium,encounterTemplateTestData.section),"Data not matched in template and Encounter page",selenium,ClassName,MethodName);
	    	assertTrue(click(selenium,lnkEncounterAction),"Unable to find Action link for encounter",selenium,ClassName,MethodName);
	    	waitForPageLoad(selenium);
	    	assertTrue(click(selenium,lnkSave),"Unable to save the encounter",selenium,ClassName,MethodName);
	    	waitForPageLoad(selenium);
	    	assertTrue(click(selenium,lnkencounterTab),"Unable to click the encounter tab link",selenium,ClassName,MethodName);
	    	waitForPageLoad(selenium);
	    	return true;
	    }
	    
	    public boolean verifyEditDefaultEncounterTemplate(Selenium selenium,ClinicalSettingLib encounterTemplateTestData)throws IOException
	    {
	    	assertTrue(click(selenium,btnBeginEncounter),"Unable to click Begin Encounter Button",selenium,ClassName,MethodName);
	    	waitForPageLoad(selenium);
	    	
	    	if(isElementPresent(selenium,lnkNewEncounterLink1))
	    	{
	    	assertTrue(click(selenium,lnkNewEncounterLink1),"Unable to click the new encounter",selenium,ClassName,MethodName);
	    	waitForPageLoad(selenium);
	    	}
	    	assertTrue(isTextPresent(selenium,encounterTemplateTestData.sectionEdit),"Data not matched in template and Encounter page",selenium,ClassName,MethodName);
	    	assertTrue(clickAt(selenium,lnkEncounterAction,""),"Unable to find Action link for encounter",selenium,ClassName,MethodName);
	    	waitForPageLoad(selenium);
	    	assertTrue(click(selenium,lnkSave),"Unable to save the encounter",selenium,ClassName,MethodName);
	    //	waitForPageLoad(selenium);
	    	assertTrue(click(selenium,lnkencounterTab),"Unable to click the encounter tab link",selenium,ClassName,MethodName);
	    	waitForPageLoad(selenium);
	    	return true;
	    }
	    }
