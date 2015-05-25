package com.nexia.selenium.genericlibrary.clinicalList;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.sharedlibrary.AbstractTest;
import com.thoughtworks.selenium.Selenium;



public class AbstractClinicalList extends AbstractTest {
	
	//------------------------------------------------------------------//
	//					Page Factory									//
	//------------------------------------------------------------------//
	
	//ClinicalLists
	public String lnkShowMoreLink="showMoreActions";
	public String lnkSystemSettingLink="systemSettingsAction";
	public String lnkMandatoryUserFields  ="!adminMandatoryUserField";
	public String btnSearchClinicalList1 = "searchButton";
	public String lnkAutomatedRecallList="!automatedRecallList";
	public String btnTaskName = "taskNameButton";
	public String txtdeleteReason = "deleteReason";

	public String lnkEncounterProblemList = "xpath=(//a[contains(text(),'Problem List')])[2]";
    public String vfyQuickList = "//body/div[3]/div/div/div/div/div/div/span";
	public String lnkQuickActions = "link=Quick Actions";
	public String lnkClinicalLists = "clinicalListsAction";
	public String lnkClinicalPatientList = "css=#clinicalListsAction > span.actionItemSpan";
	public String lnkCustomList = "!advancedPatientSearchList";
	public String lnkSearch ="link=Search";
	public String lnkMuMeasures ="!qualityMeasurementMain";
	public String lnkAdvancedSearchList="!advancedPatientSearchList";
	public String lnkSystemSetting="systemSettingsAction";
	public String lnkAdminMandatory="!adminMandatoryUserField";
	public String lnkClinicalLists1 ="//a[4]/span";
	public String lnkNewSearch ="clinicalPatientListMatchAllAddNew";
	public String lnkDelete ="link=Delete";
	public String lnkEncounterMedication = "xpath=(//a[contains(text(),'Medications')])";
	public String ajxMedicationNameSuggestBox2="xpath=(//input[@id='medicationSuggestBox'])[3]";

	public String btnNewSearch="addIdentifierType";
	public String saveMedbtn="saveMedications";
	public String saveAlgbtn="saveAllergyButton";
	public String lnkCustomListTab="!advancedPatientSearchList";
	public String btnYes="yesButton";
	public String btnlabCancel="xpath=(//button[@id='cancel'])[2]";
	public String btnlabSave1="xpath=(//button[@id='save'])[2]";
	public String btnDelete="//a[contains(text(),'Delete')]";
	public String btnMedicationDelete = "//div[@id='MedicationsList']/table/tbody/tr/td[4]/div/a";
	public String btnAddNew="clinicalPatientListMatchAllAddNew";
	public String btnSave="saveID";
	//FIX-ME MNT-1345
	public String btnSaveBtn="css=div.popup-buttons > button.secondary-button";
	public String btnchangeCriteria="changeCriteriaID";
	public String btnEditQuality="clinicalEditQualityMeasuresButton";
	public String btnSaveButton="searchButton";
	public String btnSearchClinicalList = "searchButton";
	public String btnCancelCL="xpath=(//button[@type='button'])[3]";
	
	public String btnClear="xpath=(//button[@type='button'])[2]";
	public String btnEdit="//a[contains(text(),'Edit')]";
	public String btnDeleteImmunization = "//a[starts-with(@id,'Delete')]";
	public String btnSaveAs="saveAsID";
	public String btnDelete1="//div[3]/div/div[2]/div[2]/a";
	public String btnok="okButton";
	public String btnCancelId="cancelID";
	public String btnAdd="add";
	public String btnAddForMatchAll="clinicalPatientListDoNotIncludeAddNew";
	public String btnAddNewCriteria="xpath=(//button[@type='button'])[4]";
	public String btnAddNewCriteria1="clinicalPatientListMatchOneAddNew";
	public String btnSearch="//button";
	public String btnSortType="//div[4]/div/div/div/div/div[5]";
	public String btnSortType1="//body/div[3]/div/div/div/div/div[2]";
	public String btnSortCriteria="firstSortCriteriaanchor";
	public String btnBack="back";
	public String btnclinicalListsAction="clinicalListsAction";
	public String btnAddNewCriteria2="clinicalPatientListDoNotIncludeAddNew";
	public String btnAddNewCriteria3="//div[4]/div/div[2]/button";
	public String btnCqmCancel="cancel";

	public String ajxdeleteReason = "deleteReason";

	public String lnkDeleteReason = "//button[contains(@id,'deleteReason')]";
	public String txtClinicalListSave ="answer";
	public String ajxMedicalCondtion ="medicalConditionTextBox";
	public String ajxItemStatus ="itemStatusInputsuggestBox";
	public String ajxSearchType="searchTypeSuggestBoxsuggestBox";
	public String ajxAllergyBox="allergySuggestBox";
	public String ajxSearchTypeAnchor="searchTypeSuggestBoxanchor";
	public String ajxSearchCondtion="sexConditionSuggestBoxsuggestBox";
	public String ajxsexcatobox="3andsearchTypeSuggestBoxsuggestBoxsuggestBox";
	public String ajxDurationCondtion="durationConditionSuggestBoxsuggestBox";
	public String ajxtimeCondtion="timeConditionSuggestBoxsuggestBox";
	public String ajxFirstSorSuggestBox="firstSortCriteriasuggestBox";
	public String ajxMedicationTypeOption="//div[3]/div/div/div/div/div[6]";
	public String ajxMedicationNameSuggestBox="medicationSuggestBox";
	public String ajxMedicationNameSuggestBox1="xpath=(//input[@id='medicationSuggestBox'])[2]";
	public String ajxMedicationNameOption="//body/div[3]/div/div/div/div/div";
	public String ajxSeries="series1suggestBox";
	public String ajxSeriesOf="series2suggestBox";
	public String ajxSite="sitesuggestBox";
	public String ajxImmRoute="routesuggestBox";
	public String ajxConsent="consentsuggestBox";
	public String ajxadminsteredBy="administeredBy";
	public String ajxImmCpt1="cpt1suggestBox";
	public String ajxImmCp2="cpt2suggestBox";
	public String ajxImmreaction="reactionsuggestBox";
	public String ajxLabResult="labResultNameSuggestBoxsuggestBox";
	public String ajxPeriodCondition="periodConditionSuggestBoxsuggestBox";
	public String ajxLabProvider="receivingProviderSuggestsuggestBox";
	public String ajxLabProvider1="orderingProviderSuggestsuggestBox";
	public String ajxLabSuggestBox="reportingLabSuggestsuggestBox";
	public String ajxLabTest="testNameSuggestsuggestBox";
	public String ajxLabResultName="xpath=(//input[@id='labResultNameSuggestBoxsuggestBox'])[2]";
	public String ajxLabResult1="//div[2]/div/div/div/div[8]/div[2]/input";
	public String ajxTimeCondiiton="xpath=(//input[@id='timeConditionSuggestBoxsuggestBox'])[2]";
	public String ajxPeriod="//div[2]/div/div/div/div[9]/div[3]/div/div/div/input";
	public String ajxPeriodNumber="xpath=(//input[@id='clinicalListsPeriodConditionTextBox'])[2]";
	public String ajxPeriodCondtion="xpath=(//input[@id='periodConditionSuggestBoxsuggestBox'])[2]";
	public String ajxPeriodCondtion1="xpath=(//input[@id='periodConditionSuggestBoxsuggestBox'])[3]";
	public String ajxPblmDiag="xpath=(//input[@id='problemListSuggestBoxsuggestBox'])[2]";
	public String ajxPblmDiag1="xpath=(//input[@id='problemListSuggestBoxsuggestBox'])[3]";
	public String ajxMediDiag="xpath=(//input[@id='medicationSuggestBox'])[3]";
	public String ajxSearchType1="xpath=(//input[@id='searchTypeSuggestBoxsuggestBox'])[2]";
	public String ajxSex0CondtionForMatchAll="xpath=(//input[@id='sexConditionSuggestBoxsuggestBox'])[1]";
	public String ajxSex1CondtionForMatchAll="xpath=(//input[@id='sexConditionSuggestBoxsuggestBox'])[2]";
	public String ajxSearchType1ForMatchAll="xpath=(//input[@id='searchTypeSuggestBoxsuggestBox'])[2]";
	public String ajxDuration1ForMatchAll="xpath=(//input[@id='durationConditionSuggestBoxsuggestBox'])[2]";
	public String ajxSearchType2ForMatchAll="xpath=(//input[@id='searchTypeSuggestBoxsuggestBox'])[3]";
	public String ajxDuration2ForMatchAll="xpath=(//input[@id='durationConditionSuggestBoxsuggestBox'])[3]";
	public String ajxSex2CondtionForMatchAll="xpath=(//input[@id='sexConditionSuggestBoxsuggestBox'])[3]";
	public String ajxSearchType3ForMatchAll="xpath=(//input[@id='searchTypeSuggestBoxsuggestBox'])[4]";
	public String ajxDuration3ForMatchAll="xpath=(//input[@id='durationConditionSuggestBoxsuggestBox'])[4]";
	public String ajxPrescribeName="xpath=(//input[@id='medicationSuggestBox'])[3]";
	public String ajxTimeCondtion="xpath=(//input[@id='timeConditionSuggestBoxsuggestBox'])[3]";
	public String ajxTimeCondtion1="xpath=(//input[@id='timeConditionSuggestBoxsuggestBox'])[4]";
	public String ajxTimeCondtion2="xpath=(//input[@id='timeConditionSuggestBoxsuggestBox'])[5]";
	public String ajxTimeCondtion3="xpath=(//input[@id='timeConditionSuggestBoxsuggestBox'])[6]";
	public String ajxSearchType4ForMatchAll="xpath=(//input[@id='searchTypeSuggestBoxsuggestBox'])[5]";
	public String ajxLabResultMatchAll="xpath=(//input[@id='labResultNameSuggestBoxsuggestBox'])[5]";
	public String ajxDuration4ForMatchAll="xpath=(//input[@id='durationConditionSuggestBoxsuggestBox'])[5]";
	public String ajxSearchType5ForMatchAll="xpath=(//input[@id='searchTypeSuggestBoxsuggestBox'])[6]";
	public String ajxSearchTypeMediCondition="xpath=(//input[@id='medicationSuggestBox'])[6]";
	public String ajxAllergySuggestBox="xpath=(//input[@id='allergySuggestBox'])[2]";
	public String ajxAllergySuggestBox2="xpath=(//input[@id='allergySuggestBox'])[4]";
	public String ajxAllergySuggestBox1="xpath=(//input[@id='allergySuggestBox'])[3]";
	public String ajxSearchTypeForAge="//div[2]/div/div/div/div[2]/div/div/input";
	public String ajxdurationCondtion="//div[2]/div/div/div/div[8]/div/div/div/input";
	public String ajxSearchTypeForAge1="//div[3]/div/div/div/div[2]/div/div/input";
	public String ajxdurationCondtion1="//div[3]/div/div/div/div[8]/div/div/div/input";
	public String ajxProblemList="problemListSuggestBoxsuggestBox";
	public String ajxOption1="//div[5]/div/div/div/div/div";
	public String ajxOption2="//body/div[4]/div/div/div/div/div";
	public String ajxOption3="//div[6]/div[3]/div[2]/div/div";
	public String ajxLifeStage="lifeStagesuggestBox";
	public String ajxdiagnosissuggestBox="diagnosissuggestBox";
	public String ajxcodingSystemsuggestBox="codingSystemsuggestBox";
	public String ajxStuasSuggest="statusSuggestBoxsuggestBox";
	public String ajxSeveritySuggest="severitysuggestBox";
	public String ajxReaction="allergyReactionsuggestBox";
	public String txtProcedurename="searchProcedureTextBox";
	
	public String txtBtwyear1="//div[2]/div/div/div/div[8]/div[3]/input";
	public String txtBtwyear2="//div[2]/div/div/div/div[8]/div[3]/input[2]";
	public String txtBtwyear3="//div[3]/div/div/div/div[8]/div[3]/input";
	public String txtPeriodNum="xpath=(//input[@id='clinicalListsPeriodConditionTextBox'])[2]";
	public String txtPeriodNum1="xpath=(//input[@type='text'])[31]";
	public String txtWthyear1="xpath=(//input[@type='text'])[46]";
	public String txtWthyear2="xpath=(//input[@type='text'])[51]";
	public String txtAftyear1="xpath=(//input[@id='clinicalListsPeriodDateBox'])[3]";
	public String txtAftyear2="xpath=(//input[@id='clinicalListsPeriodDateBox'])[2]";
	public String txtAftyear3="//div[5]/div/div/div/div[8]/div[2]/input[2]";
	public String txtAftyear4="xpath=(//input[@type='text'])[79]";
	public String txtAge1="//div[5]/div[3]/div/div/div/div/div/div[8]/div[3]/input[2]";
	public String txtAge2="xpath=(//input[@type='text'])[30]";
	public String txtAgeMatch1="xpath=(//input[@type='text'])[12]";
	public String txtAgematch2="xpath=(//input[@type='text'])[13]";
	public String txtAgematch3="xpath=(//input[@type='text'])[63]";
	public String txtAgematch4="//div[3]/div/div/div/div[8]/div[3]/input[2]";
	public String txtResolvedDate="resolvedDate";
	public String txtLabResult1="durationDoubleMax";
	public String txtLabResult2="durationDoubleMin";
	public String txtLabResultForMoreThan="xpath=(//input[@id='durationDoubleMin'])[2]";
	public String txtPeriodNumber1="clinicalListsPeriodConditionTextBox";
	public String txtDate="xpath=(//input[@id='clinicalListsPeriodDateBox'])[2]";
	public String txtDate1="xpath=(//input[@id='clinicalListsPeriodDateBox'])[3]";
	public String txtLabDate="clinicalListsPeriodDateBox";
	public String txtCdate = "collectionDateBox";
	public String txtCTime ="timeTextBox";
	public String txtLabResult ="resultTextBox";
	public String txtLabResult3 ="css=input.suggestInputBox";
	public String txtLabResult4 ="//div[2]/div/div/div/div[8]/div[2]/input";
	public String txtLabResult5 ="durationDoubleMin";
	public String txtLastRefill="//div[2]/div[2]/div[2]/input";
	public String txtComments1="//div[2]/textarea";
	public String lblSearchResultDiv="//div[contains(@id,'collapsableDesc')]";
	public String lblSearchResult= "//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr/td[2]/div/div/div/div[2]/div/div/div/div/div";
	public String lblSavedSearchInSummary="//div[contains(@id,'collapsableTitle')]";
	public String lblSearchResult1="//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr/td[2]/div/div/div/div[2]/div/div/div/div[3]/div[3]/div/div/div";
	public String lblSearchEntry="//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr/td[2]/div/div/div/div[2]/div/div/div/div[5]/div[3]/div/div/div/div/div";
	public String lblSearchEntry1="//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr/td[2]/div/div/div/div[2]/div/div/div/div[4]/div[3]/div/div/div";
	public String lblSavedSearchResult="//div[@id='advancePatientSearchTabId']";
	public String lblSearchResultLabel="resultDisplaytitle";
	public String lblSortResult="css=div.addContainer";
	public String lblCollapsableTitle="collapsableTitle";
	public String lblSortResult1="//span/div/div/div[2]";
	public String lblSortResult2="xpath=(//div[@id='collapsableTitle'])[1]";
	public String lblSortResult3="xpath=(//div[@id='collapsableTitle'])[2]";
	public String lblError="css=td.dialogMiddleCenter";
	public String lblSeachText="//div[@id='printDiv']";
	public String lblLabManualEntry="//a[@id='patientOptionsManualEntry']/span";
	public String lblSeacrhText="//div[6]/div[2]";
	public String lblSeacrhTextForDNI="//div[6]/div[4]";
	public String lblAllergyEntry="//div[@id='AllergyList']/table/tbody/tr/td[4]/div/a";
	public String lblProblemList="//div[@id='ProblemsList']/table/tbody/tr/td[3]";
	public String yearType="durationIntegerMaxTextBox";
	public String yearType1="durationIntegerMinTextBox";
	public String lblCQM1="//div[@id='ClinicalQualityMeasureList']/table/tbody/tr/td/div/div[2]/table/tbody/tr[1]/td/div/input";
	public String lblCQM2="//div[@id='ClinicalQualityMeasureList']/table/tbody/tr/td/div/div[2]/table/tbody/tr[2]/td/div/input";
	public String lblCQM3="//div[@id='ClinicalQualityMeasureList']/table/tbody/tr/td/div/div[2]/table/tbody/tr[3]/td/div/input";
	public String lblCQM4="//div[@id='ClinicalQualityMeasureList']/table/tbody/tr/td/div/div[2]/table/tbody/tr[4]/td/div/input";
	public String lblCQM5="//div[@id='ClinicalQualityMeasureList']/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr[1]/td/div/input";
	public String lblCQM6="//div[@id='ClinicalQualityMeasureList']/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr[2]/td/div/input";
	public String lblCQM7="//div[@id='ClinicalQualityMeasureList']/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr[3]/td/div/input";
	public String lblCQM8="//div[@id='ClinicalQualityMeasureList']/table/tbody/tr[3]/td/div/div[2]/table/tbody/tr[1]/td/div/input";
	public String lblCQM9="//div[@id='ClinicalQualityMeasureList']/table/tbody/tr[3]/td/div/div[2]/table/tbody/tr[2]/td/div/input";
	public String lblCQM10="//div[@id='ClinicalQualityMeasureList']/table/tbody/tr[3]/td/div/div[2]/table/tbody/tr[3]/td/div/input";
	public String lblCQM11="//div[@id='ClinicalQualityMeasureList']/table/tbody/tr[3]/td/div/div[2]/table/tbody/tr[4]/td/div/input";
	
	public String chkContact="//td[2]/div/input";
	public String chkSort="//span/input";
	
	//FIX-ME MNT-1345
	public String chkAsc="//div[2]/div/div[3]/span[1]/input";
	public String chkIncludeInactive="includeInactivecheckbox";
	public String chkConsents="//div[4]/div/span/input";
	
	//---------------------------------------------------------------------------------
	//Clinical Quality Measures
	public String ajxProvider = "providerListSuggestBoxsuggestBox";
	public String ajxProvider1 = "providerSuggestBoxIdsuggestBox";
	
	public String lnkRegNewPatient ="newPatientAction";
	public String lnkProblemList ="link=Problem List";
	public String lnkSurgicalHistory ="link=Surgical History";
	public String lnkEncounterSurgicalHistory ="xpath=(//a[contains(text(),'Surgical History')])[2]";
	
	public String lnkVitals ="xpath=(//a[contains(text(),'VITALS')])[2]";
	public String lnkSocialHistory ="link=Social History";
	public String lnkNewEncounterLink1="beginNewEncounter";
	public String lnkImmunizations="link=Immunizations";
	public String lnknewPatientAction="newPatientAction";
	public String lnkInjections="link=Injections";
	public String lnkAllergies="link=Allergies";
	public String lnkExpandAll = "link=Expand all";
	public String lnkCollapseAll = "link=Collapse all";
	public String lnkClinicalQualityMeasures = "!clinicalQualityMeasurementProviderResult";
	public String lnkToMedication ="link=Medication";
	public String lnkShowMore ="//div[8]/div/div[2]";

	public String btnPatientChart = "css=#patientOptionsChartView > span";
	public String btnBeginEncounter = "BeginEncounterButton";
	public String btnDoneButton ="doneButtonId";
	public String btnSign ="sign";
	public String btnCancel = "//div[3]/div/a";
	public String btnMedicationSummary ="medicationSummaryWidget";
	public String btnsave = "save";
	public String btnAddClinicalSearch ="clinicalPatientListMatchAllAddNew";
	public String btnSaveInCqm = "css=button.gwt-Button";
	public String btnUpdateResults = "link=Update Results";
	public String btnPatientId ="patientID";
	public String btnSummaryCancel="cancel";
	public String btnCancelAllergy="cancelAllergyButton";
	public String txtCqmDate ="startedOn";
	public String txtSupplyBox ="supplyOnHand";
	public String txtComments ="//div[70]/textarea";
	public String txtPresOn ="xpath=(//input[@type='text'])[41]";
	public String txtRefill1 ="xpath=(//input[@type='text'])[43]";
	public String txtCqmDate1 ="clinicalQualityMeasuresToDate";
	public String txtFromDate = "clinicalQualityMeasuresFromDate";
	
	public String chkMetric = "//td/div/input";
	public String chkMetric2="xpath=(//input[@type='checkbox'])[2]";
	public String chkMetric3="xpath=(//input[@type='checkbox'])[3]";
	public String chkMetric4="xpath=(//input[@type='checkbox'])[4]";
	public String chkMetric5="xpath=(//input[@type='checkbox'])[5]";
	public String chkMetric6="xpath=(//input[@type='checkbox'])[6]";
	public String chkMetric7="xpath=(//input[@type='checkbox'])[7]";
	public String chkMetric8="xpath=(//input[@type='checkbox'])[8]";
	public String chkMetric9="xpath=(//input[@type='checkbox'])[9]";
	public String chkMetric10="xpath=(//input[@type='checkbox'])[10]";
	public String chkMetric11="xpath=(//input[@type='checkbox'])[11]";
	
	public String lblMetricResult="//span/div/div[3]";
	public String lblMetricResultDescription="//span/div/div[3]";
	public String lblMetricResult1="//tr[2]/td/div/span/div/div[2]";
	public String lblMetricResult9="//tr[2]/td/div/span/div";
	public String lblMetricResult2="//tr[3]/td/div/span/div";
	public String lblMetricResult3="//tr[4]/td/div/span/div";
	public String lblMetricResult4="//tr[2]/td/div/div[2]/table/tbody/tr/td/div/span/div";
	public String lblMetricResult5="//tr[3]/td/div/div[2]/table/tbody/tr[2]/td/div/span/div/div[3]";
	public String lblMetricResult6="//tr[3]/td/div/div[2]/table/tbody/tr[2]/td/div/span/div/div[4]";
	public String lblMetricResult7="//tr[3]/td/div/div[2]/table/tbody/tr[3]/td/div/span/div";
	public String lblMetricResult8="//tr[3]/td/div/div[2]/table/tbody/tr[4]/td/div/span/div";
	public String lblMetricResult1For0024="//div[@id='collapsableTitle0024']/div[10]/div[2]";
	public String lblMetricResult2For0024="//div[@id='collapsableTitle0024']/div[11]/div[2]";
	public String lblMetricResult3For0024="//div[@id='collapsableTitle0024']/div[12]/div[2]";
	public String lblMetricResult4For0024="//div[@id='collapsableTitle0024']/div[4]/div[2]";
	public String lblMetricResult5For0024="//div[@id='collapsableTitle0024']/div[5]/div[2]";
	public String lblMetricResult6For0024="//div[@id='collapsableTitle0024']/div[6]/div[2]";
	public String lblMetricResult7For0024="//div[@id='collapsableTitle0024']/div[7]/div[2]";
	public String lblMetricResult8For0024="//div[@id='collapsableTitle0024']/div[8]/div[2]";
	public String lblMetricResult9For0024="//div[@id='collapsableTitle0024']/div[9]/div[2]";
	public String lblMetricResultFor0028a="//div[@id='collapsableTitle0028a']/div[3]";
	public String lblMetricResultFor0028b="//div[@id='collapsableTitle0028b']/div[3]";
	public String lblMetricResult1For0038="//div[4]/div[2]";
	public String lblMetricResult2For0038="//div[5]/div[2]";
	public String lblMetricResult3For0038="//div[6]/div[2]";
	public String lblMetricResult4For0038="//div[7]/div[2]";
	public String lblMetricResult5For0038="//div[8]/div[2]";
	public String lblMetricResult6For0038="//div[9]/div[2]";
	public String lblMetricResult7For0038="//div[10]/div[2]";
	public String lblMetricResult8For0038="//div[11]/div[2]";
	public String lblMetricResult9For0038="//div[12]/div[2]";
	public String lblMetricResult10For0038="//div[13]/div[2]";
	public String lblMetricResult11For0038="//div[14]/div[2]";
	public String lblMetricResult12For0038="//div[15]/div[2]";
	public String lblMetricResultFor0043="//span/div/div[3]";
	public String lblMetricResultFor0043WithIPV="//div[5]/div[2]";
	public String lblMetricResultFor0059="//div[@id='collapsableTitle0059']/div[3]";
	public String lblMetricResultFor0061="//div[@id='collapsableTitle0061']/div[3]";
	public String lblMetricResultFor0064="//div[@id='collapsableTitle0064']/div[4]/div[2]";
	public String lblMetricResult1For0064="//div[@id='collapsableTitle0064']/div[5]/div[2]";
	public String lblMetricDesriptions="//td[2]/div/div/div/div[4]";
	public String lblMetricDesriptions1="//td[2]/div/div/div/div[4]";
	public String lblDesriptions="//span/div/div[2]";
	public String lblDesriptions1="//tr[2]/td[2]/div/span/div/div[2]";
	public String lnkSummary = "!chartSummary";

	//Procedure
	public String btnsave_button = "css=span.topMenuItemSpan.light";
	public String btncancel_procedure = "//div[3]/button";
	public String btnProadd = "add";
	
	public String txtproName = "css=div.controlsNoMargin > input.gwt-TextBox";
	public String txtProcomment = "summaryComment";
	public String txtprocedureDate = "procedureDate";
	
	public String lnkshowMoreDetails_Procedure = "procedureMoreDetails";
	
	public String ajxProcpt = "cptSuggestBox0-1suggestBox";

	//Lab report
	public String btnErrorClose="errorCloseButton";
	public String btnLabSave = "save";
	public String btnLabSign="xpath=(//button[@id='sign'])[2]";
	
	public String lnkPatientOptionsLink = "link=Patient Options";
	public String lnkLabReportLink = "patientOptionsManualEntry";
	public String lnkPatientChartView = "patientOptionsChartView";
	public String lnkLabOrderLink="//img[@title='Order New Labs']";
	public String lnkLabEnterData="//a[starts-with(text(),'Enter data')]";
	public String lnkBeginEncounterAction="actionAnchorEncounter";
	
	public String lblAlert="css=div.large.dark";
	
	public String txtonSetDate = "onsetDate";
	
	public String txtLabComment ="css=textarea.width370pxImportant.height50";
	public String txtaccNumber = "accessionNumberTextBox";
	public String txtLabdate = "collectionDateBox";
	public String txtCtime = "timeTextBox";
	public String txtNotes =  "labNotes";
	public String txtResult = "resultTextBox";
	public String txtLow = "lowTextBox";
	public String txtHigh = "highTextBox";
	public String txtUnits = "unitsTextBox";
	public String txtComment ="labComments";
	
	public String ajxrProvider = "receivingProviderSuggestsuggestBox";
	public String ajxoProvider ="orderingProviderSuggestsuggestBox";
	public String ajxLabName = "reportingLabSuggestsuggestBox";
	public String ajxLabTestName ="testNameSuggestsuggestBox";
	public String ajxLab ="labTestNameSuggestBox";
	
	
	public String chkPartial = "//span[2]/input";
	
	//Injection
	
	public String txtLotNumber="lotNumberBox";
	public String txtDosage = "dosageQuantity";
	public String txtadminOn="administeredOn";
	public String ajxInSite="siteSuggestBoxsuggestBox";
	public String ajxDosageUnit = "dosageUnitsuggestBox";
	public String ajxInjection="injectionQuicklistBox";
	public String lnkInjectionShowMore = "injectionMoreDetails";
	public String chkInjectionConsentBox = "consentcheckbox";	
	public String ajxInjectionRoute="routeSuggestBoxsuggestBox";
	public String ajxAdminBy = "administeredBysuggestBox";
	public String ajxCptCode1 = "cptCode1SuggestBoxsuggestBox";
	public String ajxCptCode2 = "cptCode2SuggestBoxsuggestBox";
	//Encounter
	
	public String lnkTopMenuHeader="topMenuHeader";
	public String lnkSwitchRole="css=#switchRoleAction > span.topMenuItemSpan.light";
	public String lnkNewEncounterLink3="//body/div[4]/div/div/div[2]/div[2]";
	public String lnkNewEncounterLink4="//body/div[5]/div/div/div[2]/div[2]";
	public String lnkNewEncounterLink2="//div[4]/div/div/div[2]/div[2]";
	public String lnkNewEncounterLink5="//div[5]/div/div/div[2]/div[2]";
	public String lnkActionsLink = "//a[contains(text(),'Actions')]";
	public String lnkEnterData1="//td[2]/div/a";
	public String lnkEnterData = "//a[starts-with(text(),'Enter data')]";
	
	public String ajxSwitchRole="suggestBox";
	public String ajxOption="//div[6]/div/div/div/div/div";
	public String ajxSexSuggestBox="sexSuggestBoxsuggestBox";
	public String ajxPrimaryLoc="primaryLocationSuggestBoxsuggestBox";
	public String ajxResProvider="responsibleProvSuggestBoxsuggestBox";
	public String ajxCommType="commType1SuggestBoxsuggestBox";
	
	public String lblEncounterChoosePanel="xpath=(//div[@class='popupContent'])";
	public String lblMandEntry="//div[@id='adminMandatoryUserFieldList']/table/tbody/tr/td[2]/div/a";
	
	public String txtLastName="lastName";
	public String txtFirstName="firstName";
	public String txtDob="dob";
	public String txtwrittenReason="writtenReason";
	public String txtPrimaryPhone="primaryPhone";
	public String txtPrimaryPhoneextn="primaryPhoneExtension";
	public String txtEncounterDate="css=input.gwt-DateBox";
	
	public String btnClinicalBack="notDuplicateButton";
	public String btnClinicalSave="saveButton";
	public String btnOkDelete="saveReason";
	public String btnQuickMedication="medicationQuickListButton";
	public String lnkContinue="link=Continue";
	
	//Medication
	//Normal
	public String ajxMethod="refillMethodSuggestBoxsuggestBox";
	public String ajxQuantity="refillQuantitySuggestBoxsuggestBox";
	public String ajxUnit="refillUnitSuggestBoxsuggestBox";
	public String ajxRoute="refillRouteSuggestBoxsuggestBox";
	public String ajxFrequency="refillFrequencySuggestBoxsuggestBox";
	public String ajxDuration="refillDurationSuggestBoxsuggestBox";
	public String ajxUsage="refillUsageSuggestBoxsuggestBox";
	public String btnCancelButton="cancelButton";
	
	//RefillDirection
	public String ajxrefillMethod = "refillMethodSuggestBoxsuggestBox";
	public String ajxRefillQuatity="refillQuantitySuggestBoxsuggestBox";
	public String ajxRefillUnit="refillUnitSuggestBoxsuggestBox";
	public String ajxRefillRoute="refillRouteSuggestBoxsuggestBox";
	public String ajxRefillFrequency="refillFrequencySuggestBoxsuggestBox";
	public String ajxRefillDuration="refillDurationSuggestBoxsuggestBox";
	public String ajxRefillUsage="refillUsageSuggestBoxsuggestBox";
	public String ajxUnitList="unitListSuggestBoxsuggestBox";
	public String ajxRFDurationList="durationListSuggestBoxsuggestBox";
	public String ajxRFMethod="refillMethodSuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";
	public String ajxRFQuatity="refillQuantitySuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";
	public String ajxRFUnit="refillUnitSuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";
	public String ajxRFRoute="refillRouteSuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";
	public String ajxRFFrequency="refillFrequencySuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";
	public String ajxRFUsage="refillUsageSuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";
	public String ajxRFUsage5="xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[7]";
	public String ajxRFMethod1="xpath=(//input[@id='refillMethodSuggestBoxsuggestBox'])[3]";
	public String ajxRFQuatity1="xpath=(//input[@id='refillQuantitySuggestBoxsuggestBox'])[3]";
	public String ajxRFUnit1="xpath=(//input[@id='refillUnitSuggestBoxsuggestBox'])[3]";
	public String ajxRFRoute1="xpath=(//input[@id='refillRouteSuggestBoxsuggestBox'])[3]";
	public String ajxRFFrequency1="xpath=(//input[@id='refillFrequencySuggestBoxsuggestBox'])[3]";
	public String ajxRFDuration="xpath=(//input[@id='refillDurationSuggestBoxsuggestBox'])[2]";
	public String ajxRFmethod="refillMethodSuggestBox1suggestBox";
	public String ajxRFquantity="refillQuantitySuggestBox1suggestBox";
	public String ajxRFunit="refillUnitSuggestBox1suggestBox";
	public String ajxRFroute="refillRouteSuggestBox1suggestBox";
	public String ajxRFfreq="refillFrequencySuggestBox1suggestBox";
	public String ajxRFduration="refillDurationSuggestBox1suggestBox";
	public String ajxRFusage="refillUsageSuggestBox1suggestBox";
	public String ajxRFmethod1="refillMethodSuggestBoxsuggestBox";
	public String ajxRFquantity1="refillQuantitySuggestBoxsuggestBox";
	public String ajxRFunit1="refillUnitSuggestBoxsuggestBox";
	public String ajxRFroute1="refillRouteSuggestBoxsuggestBox";
	public String ajxRFfreq1="refillFrequencySuggestBoxsuggestBox";
	public String ajxRFduration1="refillDurationSuggestBoxsuggestBox";
	public String ajxRFusage1="refillUsageSuggestBoxsuggestBox";
	public String ajxAllergy="searchAllergyTextBox";
	public String ajxStatus = "statusSuggestBoxsuggestBox";
	public String ajxType="typeSuggestBoxsuggestBox";
	public String ajxRFUsage1="xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[3]";
	public String ajxRFUsage2="xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[4]";
	public String ajxRFUsage3="xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[5]";
	public String ajxRFUsage4="xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[6]";
	public String ajxDuration1="durationNumberID";
	public String ajxSearchMedication="medicationSuggestBox";
	public String ajxImmunization="xpath=(//input[@id='immunizationSuggestBox'])[2]";
	public String ajxImmunization1="immunizationSuggestBox";
	public String ajxVaccine="searchVaccineBox";
	public String ajxDosage="dosagesuggestBox";
	public String ajxMedsQuickCa="//body/div[5]/div/div/div/div/div";
	public String ajxMedsQuickUs=ajxOption2;
	
	public String txtNotesToPharmacy="notesToPharmacyTextBoxId";
	public String txtDispense="dispenseID";
	public String txtFreeFormText="//div/div/div[2]/div/textarea";
	public String txtFillon="fillOnID";
	public String txtofRefills="ofRefillsid";
	public String txtDurationNo="xpath=(//input[@id='durationNumberID'])[2]";
	public String txtDirectionNotes="directionsNotesTextBoxId";
	public String txtSendTitle="send@title";
	public String txtOverride = "overrideTextArea";
	public String txtMedsSearchTextBox = "searchTextBox";
	public String txtRePrintreason="reason";
	public String txtRePassword="password";
	public String txtStartOn="startedOn";
	public String txtSupply="supplyOnHand";
	public String txtPrescribedOn="prescribedOn";
	public String txtRefill="refills";
	public String txtPrescribedBy="prescribedBy";
	public String txtRefilledOn="lastRefilledOn";
	public String txtFreeBox="freeTextArea";
	public String txtSummaryComment="summaryComment";
	public String txtImmunizationLot="css=input.width150";
	public String txtImmunizationDosage="//div[2]/div[2]/div/div[2]/input";
	public String txtExpiry="expiryDate";
	public String txtAdminOnDate="xpath=(//input[@id='administeredOnDate'])[2]";
	public String txtImmComment="xpath=(//textarea[@id='summaryComment'])[3]";
	public String txtSummaryComment1="xpath=(//textarea[@id='summaryComment'])[2]";
	public String txtRefusedDate="refusedOnDate";
	public String txtAdminDate="administeredOnDate";
	
	public String btnOptions="//div[2]/table/tbody/tr/td[2]/div/div";
	public String btnAddToPending1="//div[2]/table/tbody/tr/td[2]/div/div";
	public String btnAdd1="add";
	public String btnEditLink="xpath=(//a[contains(text(),'Edit')])[2]";
	
	public String lblPescirbeDetails="//div[4]/div[2]";
	public String lblPrecrbeMeds="//p[2]/span[2]";
	public String lblPrescribeMeds1="//p[3]/span[2]";
	public String lblPrescribeMeds2="//td[2]/div/div/div[4]";
	public String lblProviderName="//div[5]/div[2]/div";
	public String lblPatientName="//div[2]/div/div/div/div[5]/div/div";
	public String lblPendingMedication="//div[5]/table/tbody/tr[2]/td[2]/div/div/div/div/div/div";
	public String lblPendingDetails="//div[5]/table/tbody/tr[2]/td[2]";
	public String lblPending1="xpath=(//button[@type='button'])[8]";
	public String lblPending2="xpath=(//button[@type='button'])[9]";
	public String lblMedsDetails="//span/span/div/div/span";
	public String lblMedsData="//div[3]/a";
	public String lblSumMeds="//div[5]/div[2]/div/div/div/div/div";
	public String lblMedsCollapseDetails="//div[@id='MedicationsList']/table/tbody/tr/td[2]/div/span/div";
	public String lblNoMedication="//td[2]/div/div/div[3]/div/div[3]/div";
	public String lblEncouterMedsDetails="//span/div/div/span";
	public String lblEnMeds="css=span.pointer > div.inlineBlock > div";
	public String lblMedsExpand="//span/div[2]";
	public String lblNoSignificant="//div[6]/table/tbody/tr[2]/td[2]";
	public String lblMedsDetails1="//div[2]/div/span[2]";
	public String lblMedsDetails2="//span/div/div[2]/div[2]/span";
	public String lblMedsDetails3="//span/div[2]/div/div";
	public String lblSumMedsDetails="//span/div/div/span[2]";
	public String lblSumMedsDetails1="//div[2]/div/span/div/div";
	public String lblSumMedsDetails2="//span/div/div[2]/span";
	public String lblSumMedsDetails3="//div[3]/span/div/div";
	public String lblSumMedsDetails4="//div[5]/div[2]/div/div/div/div/div/div[3]/a";
	
	public String lnkMedication="xpath=(//a[contains(text(),'Medications')])[2]";
	public String lnkMedsShowMore="medicationsMoreDetails";
	public String lnkImmShowMore="immunizationMoreDetails";
	public String lnkExpand="//span/div/div[3]";
	
	public String chkFreetextBox="enterAsFreeTextcheckbox";
	public String chknsmhBox="nsmhCheckboxcheckbox";
	public String chkInDeDosecheckBox="increaseDecreaseDosecheckbox";
	public String chkMultipleCheckBox="multipleDirectionscheckbox";
	public String chkSaveListBox="css=#saveListcheckbox";
	public String chkSaveListBox1="saveListcheckbox";
	public String chkRefusedBox= "//div[5]/div[2]/span/input";
	
	//Vitals
	
	public String ajxHeight="heightSuggestBoxsuggestBox";
	public String ajxWeight="weightSuggestBoxsuggestBox";
	public String ajxPosition="positionSuggestBoxsuggestBox";
	public String ajxLimb="limbSuggestBoxsuggestBox";
	public String ajxCuffsize="cuffSizeSuggestBoxsuggestBox";
	public String ajxdescription="descriptionSuggestBoxsuggestBox";
	public String ajxrhythm="rhythmSuggestBoxsuggestBox";
	public String ajxWaist="waistSuggestBoxsuggestBox";
	public String ajxTempUnit="temperatureUnitSuggestBoxsuggestBox";
	public String ajxTempLocation="temperatureLocationSuggestBoxsuggestBox";
	public String ajxBloodSugar="bloodSugarUnitSuggestBoxsuggestBox";
	public String ajxRespiratory="respiratoryRateDescriptionSuggestBoxsuggestBox";
	public String ajxPefr="pefrDescriptionSuggestBoxsuggestBox";
	
	public String txtWeight="weight";
	public String txtHeightInFeet="heightFeet1";
	public String txtHeight="height";
	public String txtHeightIn="heightFeet2";
	public String txtSystolic1="systolic";
	public String txtdiastolic1="diastolic";
	public String txtBPM="xpath=(//input[@type='text'])[32]";
	public String txtwaist1="waist";
	public String txtTemp1="xpath=(//input[@type='text'])[35]";
	public String txtBloodSugar1="xpath=(//input[@type='text'])[38]";
	public String txtRespiratory1="xpath=(//input[@type='text'])[40]";
	public String txtOxygen1="xpath=(//input[@type='text'])[42]";
	public String txtSystolic="systolic";
	public String txtdiastolic="diastolic";
	public String txtheartRate="heartRate";
	public String txtwaist="waist";
	public String txtTemp="temperature";
	public String txtBloodSugar="bloodSugar";
	public String txtRespiratory="respiratoryRate";
	public String txtOxygen="oxygenSaturation";
	public String txtPefr="pefr";
	public String btnShowMore="vitalsMoreDetails";

	
	
	// Manage Care Alerts
	
	public String lnkPatientOption="link=Patient Options";
	public String lnkManageCare="patientOptionsManageCareAlerts";
	public String chkManageCare = "//div[2]/div/div/span/input";
	public String txtDueDate = "css=input.text-box";
	public String txtRecurring = "css=div.display-cell.width-40 > input.text-box";
	public String ajxOccurrenceUnitSuggestBox = "occurrenceUnitSuggestBoxsuggestBox";
	public String txtAddReason = "addReason";
	public String txtDeleteReason = "deleteReasonBox";
	
	public String btnEditRecall = "EditEdit";
	
	public String vfyExpandDetails = "css=div.chart-summary-quick-info-box";
	public String vfyManageAlertsInSummary = "css=div.chart-summary-quick-info-box";
	public String lnkClosedArrow = "menuArrow";
	public String vfyDeleteEManageAlertsInSummary = "xpath=(//div[@class='chart-content'])[3]";
													
	public String vfyMedicationReconciliationResults = "//div[3]/table";
	public String lnkAutomatedRecall= "link=Automated Recall Lists";
	public String lnkPreview= "PreviewPreview";
	public String lnkPreviewRecall= "previewID";
	public String btnSave2="xpath=(//button[@id='save'])[2]";
	
	public String vfyMedicationReconResultsCnt = "//div[3]/table/tbody/tr/td/div/div";


	public String lblAutomatedRecallListSummary = "AdminUserRoleList";
	
	public String btnCancelAlert="xpath=(//button[@id='cancel'])[2]";
	public String btnCancelAlert1="cancel";
	
	public String vfyCurrentDateAlert ="//span[contains(text(),'Medication Reconciliation')]/font";
	

	public String ajxFirstCriteria = "firstSortCriteriasuggestBox";
	public String ajxSecondCriteria = "secondSortFiltersuggestBox";
	
	public String txtTaskReasonName = "taskName";
	public String ajxDueIn = "timeCountSuggestBoxsuggestBox";
	public String ajxAssignUser = "assignToSuggestBoxsuggestBox";
	public String ajxDueInUnit = "dueInTimeUnitSuggestBoxsuggestBox";
	
	public String MedicationStopButton="stop";
	public String MedicationholdButton="hold";
	public String MedicationrenewButton="renew";
	public String MedicationReleaseButton="release";
	
	
	/**
	 * switchRole
	 * This function will switchRole to Nexia Site
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		switchRole
	 * @since  	 Jan 31, 2013
	 */
	/*public boolean switchRole(Selenium selenium, String switchRole){
		if(!waitForElement(selenium, lnkTopMenuHeader, WAIT_TIME*3)){
			Assert.fail(" Top Menu Header not opened More Details; switchRole :- "+switchRole);
		}
		click(selenium,lnkTopMenuHeader);
		click(selenium,lnkSwitchRole);
		selectValueFromAjaxList(selenium,ajxSwitchRole,switchRole);
		click(selenium,ajxOption);
		click(selenium,"//div[7]/div/div/div/div/div");
		click(selenium,ajxdeleteReason);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		if(getText(selenium, lnkTopMenuHeader).contains(switchRole)){
			waitForPageLoad(selenium);  
			return true;
		}else{
			return false;
		}
	}
	*/
	/**
	 * unitTestForCQM
	 * function to unit test for cqm
	 * @param selenium
	 * @param cqmData
	 * @return
	 * @throws IOException 
	 * @since Dec 24, 2012
	 */
	
	public boolean unitTestForCQM(Selenium selenium, ClinicalListLibUnitTest cqmData) throws IOException{
		try{
			selectValueFromAjaxList(selenium, ajxProvider, cqmData.provider);
			if(cqmData.testCaseId.equals("TA_cqm_001"))
				type(selenium, ajxProvider, cqmData.provider);
			assertTrue(enterDate(selenium, txtFromDate, cqmData.fromDate), "Could not enter show results from Date", selenium, ClassName,MethodName);
			assertTrue(enterDate(selenium, txtCqmDate1, cqmData.toDate), "Could not enter show results to Date", selenium, ClassName,MethodName);
			assertTrue(click(selenium, btnUpdateResults),"Could not click Update results", selenium, ClassName,MethodName);
			return true;
		}
		catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * goToBeginEncounter
	 * function to goToBeginEncounter
	 * @since  	Sep 12, 2012
	 */	
	
	public boolean goToBeginEncounter(Selenium selenium){
		try{
			if(isElementPresent(selenium, btnBeginEncounter)){
				assertTrue(click(selenium, btnBeginEncounter),"could not click begin encounter", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lblEncounterChoosePanel)){
					if(isElementPresent(selenium,lnkNewEncounterLink1)){
						click(selenium,lnkNewEncounterLink1);
					}else if(isElementPresent(selenium,lnkNewEncounterLink3)){
						click(selenium,lnkNewEncounterLink3);
					}else if(isElementPresent(selenium,lnkNewEncounterLink4)){
						click(selenium,lnkNewEncounterLink4);
					}else if(isElementPresent(selenium,lnkNewEncounterLink2)){
						click(selenium,lnkNewEncounterLink2);
					}else{
						click(selenium,lnkNewEncounterLink5);
					}
					waitForPageLoad(selenium);
				}
				assertTrue(isElementPresent(selenium,lnkActionsLink),"Sign button is not present", selenium, ClassName,MethodName);
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * goToCQM
	 * Function to go to clinical quality measures
	 * @param selenium
	 * @return
	 * @since Dec 24, 2012
	 */
	public boolean goToCQM(Selenium selenium){
		try {
			assertTrue(click(selenium, lnkQuickActions), "Could not click on Quick Actions", selenium, ClassName,MethodName);
		
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkClinicalLists), "Could not click on Clinical Lists", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkClinicalQualityMeasures), "Could not click on clinical quality measures", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnEditQuality))
				return true;
			else 
				return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	
	/**
	 * runSearchQueryForSex
	 * function to goToPrescribe
	 * @since  	Nov 21, 2012
	 */	
	
	public boolean runSearchQueryForSex(Selenium selenium,ClinicalListLib searchData,String doNotInclude, int possition ){
		String searchField=null;
		
		String filterType=null;
		try {
		if(doNotInclude.equalsIgnoreCase("MatchAll" )){
			 filterType=lnkNewSearch;
		}else if(doNotInclude.equalsIgnoreCase("OneOrMore")){
			filterType=btnAddNewCriteria1;
		}else if(doNotInclude.equalsIgnoreCase("doNotInclude")){
			filterType=btnAddNewCriteria2;
		}
		
		
		if(doNotInclude.equalsIgnoreCase("MatchAll" )){
			 filterType=lnkNewSearch;
			searchField="andsearchTypeSuggestBoxsuggestBoxsuggestBox";
			 
		}else if(doNotInclude.equalsIgnoreCase("OneOrMore")){
			filterType=btnAddNewCriteria1;
			searchField="orsearchTypeSuggestBoxsuggestBoxsuggestBox";
			
		}else if(doNotInclude.equalsIgnoreCase("doNotInclude")){
			filterType=btnAddNewCriteria2;
			searchField="excludesearchTypeSuggestBoxsuggestBoxsuggestBox";
			
		}
		selectValueFromAjaxList(selenium,String.valueOf(possition)+searchField,searchData.searchType);
		selectValueFromAjaxList(selenium,ajxSearchCondtion,searchData.sex);
		if(searchData.testCaseId.equals("TC_VSS_003")|| searchData.testCaseId.equals("TC_VSS_004")){
			assertTrue(click(selenium,filterType),"Could not click on Add New button;More Details", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			possition= possition+1;
			selectValueFromAjaxList(selenium,String.valueOf(possition)+searchField,searchData.searchType);
			selectValueFromAjaxList(selenium,ajxSex1CondtionForMatchAll,searchData.sex1);
		}
		
			assertTrue(click(selenium,btnSearchClinicalList),"Could not click on search button:", selenium, ClassName,MethodName);
		
		waitForPageLoad(selenium);
		possition = possition + 1 ;
		searchData.currentValue = String.valueOf(possition);
		return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * runSearchQueryForSex
	 * function to goToPrescribe
	 * @since  	Nov 21, 2012
	 */	
	
	public boolean runSearchQueryForSexWithDonNotInclude(Selenium selenium,ClinicalListLib searchData,int possition){
		try {
		selectValueFromAjaxList(selenium,String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType);
		selectValueFromAjaxList(selenium,ajxSearchCondtion,searchData.sex);
		if(searchData.testCaseId.equals("TC_VSS_003")|| searchData.testCaseId.equals("TC_VSS_004")){
			assertTrue(click(selenium,btnAddForMatchAll),"Could not click on Add New button;More Details", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			possition = possition + 1;
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType);
			selectValueFromAjaxList(selenium,ajxSex1CondtionForMatchAll,searchData.sex1);
		}
		
		assertTrue(click(selenium,btnSearchClinicalList),"Could not click on search button:", selenium, ClassName,MethodName);
		
		waitForPageLoad(selenium);
		possition= possition+1;
		searchData.currentValue = String.valueOf(possition);
		return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * deleteAllMandatory
	 * function to delete All Mandatory
	 * @since  	 APR 09, 2012
	 */
	public boolean deleteAllMandatory(Selenium selenium){
		boolean mandatoryDeleted = true;
		int caseCount = 0;
		try{
			waitForElement(selenium, lblMandEntry, WAIT_TIME);
			while((Integer) selenium.getXpathCount(lblMandEntry) > 0){
				caseCount = (Integer) selenium.getXpathCount(lblMandEntry);
				assertTrue(click(selenium,lblMandEntry),"could not click label Mand Entry", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnYes),"could not click yes button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount(lblMandEntry)){
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
			return false;
		}
	}
	/**
	 * createNewPatientWithMandatory
	 * function to create New Patient With Mandatory
	 * @since  	 Feb 09, 2012
	 */	
	public boolean createNewPatientWithMandatory(Selenium selenium, HomeLib patientData,ClinicalListLib searchData,String account ){
		boolean returnValue = false;
		try{
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtLastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,txtFirstName,patientData.firstName),"Could not type the first Name : More Details"+patientData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium, ajxSexSuggestBox,"Female");
			if(account.equals(CAAccount)){
				assertTrue(enterDate(selenium, txtDob, "27/11/2000"), "Could not type DOB", selenium, ClassName,MethodName);
				click(selenium,btnClinicalBack);
			}else{
				assertTrue(enterDate(selenium, txtDob, "11/27/2000"), "Could not type DOB", selenium, ClassName,MethodName);
				click(selenium,btnClinicalBack);
			}
			
			if(searchData.testCaseId.equals("TC_VSS_001") || searchData.testCaseId.equals("TC_SWC_001")||searchData.testCaseId.equals("TC_SWC_002")|| searchData.testCaseId.equals("TC_SWC_003")||searchData.testCaseId.equals("TC_SWC_004")|| searchData.testCaseId.equals("TC_SM_012")||searchData.testCaseId.equals("TC_SM_010")){
				selectValueFromAjaxList(selenium, ajxSexSuggestBox,"Male");
			}if(searchData.testCaseId.equals("TC_VSS_002")||searchData.testCaseId.equals("TC_SM_011")){
				selectValueFromAjaxList(selenium, ajxSexSuggestBox,"Female");
			}
			if(searchData.testCaseId.equals("TC_VSA_003")||searchData.testCaseId.equals("TC_VSS_003")){
					
					if(account.equals(CAAccount)){
						assertTrue(enterDate(selenium, txtDob, "27/11/2000"), "Could not type DOB", selenium, ClassName,MethodName);
					}else{
						assertTrue(enterDate(selenium, txtDob, "11/27/2000"), "Could not type DOB", selenium, ClassName,MethodName);
					}
					click(selenium,btnClinicalBack);
					selectValueFromAjaxList(selenium, ajxSexSuggestBox,"Female");
			}
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnClinicalSave),"Could not click Save button More Dateils"+patientData.toString(), selenium, ClassName,MethodName);
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
			return false;
		}
		return returnValue;
	}
	

	/**
	 * navigateTofileReport
	 * function to navigate To file Report
	 * @since  	Dec 07, 2012
	 */	
	public boolean navigateTofileReport(Selenium selenium, ChartPreVisitLib labData){
		try {
			assertTrue(click(selenium,lnkPatientOptionsLink ), "Could not click on patient options link", selenium, ClassName,MethodName);
			assertTrue(click(selenium,lnkLabReportLink ), "Could not click on file new report link", selenium, ClassName,MethodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	
	/**
	 *deleteMedication
	 * function to delete Medication
	 * @since  	Nov 21, 2012
	 */	
	public boolean deleteMedication(Selenium selenium,ClinicalListLib medicationData){
		boolean medicationDeleted=true;
		int medicationCount=0;
		try{
			waitForElement(selenium,btnMedicationDelete, WAIT_TIME);
			while((Integer) selenium.getXpathCount(btnMedicationDelete) > 0){
				medicationCount=(Integer) selenium.getXpathCount(btnMedicationDelete);
				assertTrue(click(selenium,btnMedicationDelete),"could not click Medication delete",selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, ajxdeleteReason,
								medicationData.userAccount),
						"Could not enter the reason",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkDeleteReason),"Could not click on Continue Button" ,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
			}
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return medicationDeleted;
	}

	
	/**
	* fileReport
	 * function to goToEncounterMedicationIcon
	 * @since  	Dec 07, 2012
	 */	
	public boolean fileReportCqm(Selenium selenium, ChartPreVisitLib labData){
		try{
			if(labData.testCaseId.equals("TC_LR_026"))
			{
				assertTrue(click(selenium,lnkEnterData1),"Could not find enter data link", selenium, ClassName,MethodName);
			}
			else{
				assertTrue(click(selenium,lnkEnterData),"Could not find enter data link", selenium, ClassName,MethodName);
			}
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtaccNumber, labData.accNumber), "Could not type accession number", selenium, ClassName,MethodName);
		selectValueFromAjaxList(selenium,ajxrProvider, labData.rProvider);

		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium,ajxoProvider, labData.oProvider);
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium,ajxLabName, labData.labName);
		waitForPageLoad(selenium);
		if(labData.testCaseId.equals("TC_LR_025")){
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat curDate = new SimpleDateFormat("MM/dd/yyyy");
			String currentDate = curDate.format(cal.getTime());
			assertTrue(enterDate(selenium,txtCdate,currentDate),"Could not enter the collrction Date;More Details:"+labData.toString(), selenium, ClassName,MethodName);
		}
		else{
		assertTrue(enterDate(selenium,txtCdate,labData.cDate),"Could not enter the collrction Date;More Details:"+labData.toString(), selenium, ClassName,MethodName);
		}
		assertTrue(type(selenium, txtCtime, labData.cTime), "Could not type time", selenium, ClassName,MethodName);
		assertTrue(type(selenium, txtNotes, labData.notes), "Could not type notes", selenium, ClassName,MethodName);
		selectValueFromAjaxList(selenium,ajxLabTestName, labData.testName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtResult, labData.result), "Could not type results", selenium, ClassName,MethodName);
		assertTrue(type(selenium,txtLow, labData.low), "Could not type low", selenium, ClassName,MethodName);
		assertTrue(type(selenium,txtHigh, labData.high), "Could not type high", selenium, ClassName,MethodName);
		assertTrue(type(selenium, txtUnits, labData.units), "Could not type units", selenium, ClassName,MethodName);
		assertTrue(type(selenium, txtComment, labData.comments), "Could not type comments", selenium, ClassName,MethodName);
		if(labData.testCaseId.equals("TC_LR_025"))
		{
			assertTrue(click(selenium,btnSign),"Could not click Sign button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		}else
		assertTrue(click(selenium,btnLabSave),"Could not find save button", selenium, ClassName,MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	/**
	* fileReport
	 * function to goToEncounterMedicationIcon
	 * @throws IOException 
	 * @since  	Dec 07, 2012
	 */	
	public boolean fileReportCqm0059(Selenium selenium, ChartPreVisitLib labData) throws IOException{
		try{
		    	assertTrue(click(selenium,lnkPatientOptionsLink ), "Could not click on patient options link", selenium, ClassName, MethodName);
		    	waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkLabReportLink ), "Could not click on file new report link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(labData.testCaseId.equals("TC_LR_026"))
			{
				assertTrue(click(selenium,lnkEnterData1),"Could not find enter data link", selenium, ClassName,MethodName);
			}
			else{
				assertTrue(click(selenium,lnkEnterData),"Could not find enter data link", selenium, ClassName,MethodName);
			}
		click(selenium,"link=Enter data >");
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtaccNumber, labData.accNumber), "Could not type accession number", selenium, ClassName,MethodName);
		selectValueFromAjaxList(selenium,ajxrProvider, labData.rProvider);

		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium,ajxoProvider, labData.oProvider);
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium,ajxLabName, labData.labName);
		waitForPageLoad(selenium);
		if(labData.testCaseId.equals("TC_LR_025")){
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat curDate = new SimpleDateFormat("MM/dd/yyyy");
			String currentDate = curDate.format(cal.getTime());
			assertTrue(enterDate(selenium,txtCdate,currentDate),"Could not enter the collrction Date;More Details:"+labData.toString(), selenium, ClassName,MethodName);
		}
		else{
		assertTrue(enterDate(selenium,txtCdate,labData.cDate),"Could not enter the collrction Date;More Details:"+labData.toString(), selenium, ClassName,MethodName);
		}
		assertTrue(type(selenium, txtCtime, labData.cTime), "Could not type time", selenium, ClassName,MethodName);
		assertTrue(type(selenium, txtNotes, labData.notes), "Could not type notes", selenium, ClassName,MethodName);
		selectValueFromAjaxList(selenium,ajxLabTestName, "Hemoglobin A1c/Hemoglobin.total");
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtResult, labData.result), "Could not type results", selenium, ClassName,MethodName);
		assertTrue(type(selenium,txtLow, labData.low), "Could not type low", selenium, ClassName,MethodName);
		assertTrue(type(selenium,txtHigh, labData.high), "Could not type high", selenium, ClassName,MethodName);
		assertTrue(type(selenium, txtUnits, "%"), "Could not type units", selenium, ClassName,MethodName);
		assertTrue(type(selenium, txtComment, labData.comments), "Could not type comments", selenium, ClassName,MethodName);		
		if(labData.testCaseId.equals("TC_LR_025"))
		{
			assertTrue(click(selenium,btnSign),"Could not click Sign button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		}else
			assertTrue(click(selenium,btnLabSave),"Could not find save button", selenium, ClassName,MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return true;
		
	}



	
	/**
	 *
	 * function to cretae Medication
	 * @since  	Oct 10, 2012
	 */	
	
	public boolean createMedicationCqm(Selenium selenium,ChartPreVisitLib medicationData){
		try{
			selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,medicationData.prescribe);
			waitForPageLoad(selenium);
			if(medicationData.freeText.equals("Yes")){
				assertTrue(click(selenium,chkFreetextBox),"Could not click the check box;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,txtFreeBox,medicationData.direction),"Could not enter the text;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
			}if(medicationData.increaseDecreaseDose.equals("Yes")){
				assertTrue(click(selenium,chkInDeDosecheckBox),"Could not click the check box;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxRFMethod,medicationData.refillMethod);
				selectValueFromAjaxList(selenium,ajxRFQuatity,medicationData.refillQuantity);
				selectValueFromAjaxList(selenium,ajxRFUnit,medicationData.refillUnit);
				selectValueFromAjaxList(selenium,ajxRFRoute,medicationData.refillRoute);
				selectValueFromAjaxList(selenium,ajxRFFrequency,medicationData.refillFrequency);
				selectValueFromAjaxList(selenium,ajxRFUsage,medicationData.refillUsage);
				selectValueFromAjaxList(selenium,ajxRFUsage1,medicationData.refillUsage1);
				selectValueFromAjaxList(selenium,ajxDuration1,medicationData.duration);
				selectValueFromAjaxList(selenium,ajxRFUsage2,medicationData.refillUsage2);
				selectValueFromAjaxList(selenium,ajxRFUsage3,medicationData.refillUsage3);
				selectValueFromAjaxList(selenium,ajxRFUsage4,medicationData.refillUsage4);
			}if(medicationData.multipleDirection.equals("Yes")){
				assertTrue(click(selenium,chkMultipleCheckBox),"Could not click the check box;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxRFMethod1,medicationData.refillMethod);
				selectValueFromAjaxList(selenium,ajxRFQuatity1,medicationData.refillQuantity);
				selectValueFromAjaxList(selenium,ajxRFUnit1,medicationData.refillUnit);
				selectValueFromAjaxList(selenium,ajxRFFrequency1,medicationData.refillFrequency);
				selectValueFromAjaxList(selenium,ajxRFDuration,medicationData.refillduration);
				selectValueFromAjaxList(selenium,ajxRFUsage5,medicationData.refillUsage);
				selectValueFromAjaxList(selenium,ajxRFmethod,medicationData.method);
				selectValueFromAjaxList(selenium,ajxRFquantity,medicationData.quality);
				selectValueFromAjaxList(selenium,ajxRFunit,medicationData.unit);
				selectValueFromAjaxList(selenium,ajxRFroute,medicationData.route);
				selectValueFromAjaxList(selenium,ajxRFfreq,medicationData.frequency);
				selectValueFromAjaxList(selenium,ajxRFduration,medicationData.duration);
				selectValueFromAjaxList(selenium,ajxRFusage,medicationData.usage);
			}
			else if(!medicationData.freeText.equals("Yes")&& !medicationData.increaseDecreaseDose.equals("Yes")&& !medicationData.multipleDirection.equals("Yes")){
				
				selectValueFromAjaxList(selenium,ajxRFmethod1,medicationData.refillMethod);
				selectValueFromAjaxList(selenium,ajxRFquantity1,medicationData.refillQuantity);
				selectValueFromAjaxList(selenium,ajxRFunit1,medicationData.refillUnit);
				selectValueFromAjaxList(selenium,ajxRFroute1,medicationData.refillRoute);
				selectValueFromAjaxList(selenium,ajxRFfreq1,medicationData.refillFrequency );
				selectValueFromAjaxList(selenium,ajxRFduration1,medicationData.refillduration);
				selectValueFromAjaxList(selenium,ajxRFusage1,medicationData.refillUsage);
			}
			if(medicationData.testCaseId.equals("TC_PSM_014") || medicationData.testCaseId.equals("TC_PSM_040")|| medicationData.testCaseId.equals("TC_PSM_041"))
			{
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat curDate = new SimpleDateFormat("MM/dd/yyyy");
				String currentDate = curDate.format(cal.getTime());
				assertTrue(enterDate(selenium,txtCqmDate,currentDate),"Could not enter the Date;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			else
			{
				assertTrue(enterDate(selenium,txtCqmDate,medicationData.startDate),"Could not enter the Date;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
			}
			assertTrue(type(selenium,txtSupplyBox,medicationData.supply),"Could not enter the supply;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(medicationData.testCaseId.equals("TC_PSM_006")){
				assertTrue(click(selenium,lnkShowMore),"Could not click the show more link;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				assertTrue(enterDate(selenium,txtPresOn,medicationData.prescribeOn),"could not enter date",selenium, ClassName,MethodName);
				assertTrue(type(selenium,txtRefill1,medicationData.refill),"Could not enter the refill;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,txtLabResult,medicationData.prescribedby),"Could not enter the date;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				assertTrue(enterDate(selenium,txtLastRefill,medicationData.lastRefill),"could not enter date", selenium, ClassName,MethodName);
				assertTrue(type(selenium,txtComments1,medicationData.comment),"Could not enter the commend;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
			}
			
			assertTrue(click(selenium,btnAdd1),"Could not click the add button;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
			
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * orderNewLabs
	 * Function to order New Labs
	 * @since	Nov 15, 2012
	 */
	public boolean orderNewLabs(Selenium selenium, ChartPreVisitLib orderData){
		try{
			
			/*Assert.assertTrue(click(selenium,ajxLab ), "Could not click on test name suggest box");
			Assert.assertTrue(type(selenium,ajxLab, orderData.labTestName), "Could not click on test name suggest box");
			waitForPageLoad(selenium);*/
			if(orderData.testCaseId.equals("TC_OL_004")){
				assertTrue(click(selenium,btnsave), "Could not click on save button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(getText(selenium,lblAlert).toLowerCase(new java.util.Locale("en","US")).trim().contains("You need to select one test at least for saving the report!".trim().toLowerCase(new java.util.Locale("en","US")))){
					return true;
				}
				else return false;
			}
			if(orderData.testCaseId.equals("TC_OL_004")){
				selectValueFromAjaxList(selenium, ajxLab,orderData.labTestName);
				assertTrue(click(selenium,btnsave), "Could not click on save button", selenium, ClassName,MethodName);
				return true;
			}
			selectValueFromAjaxList(selenium, ajxLab,orderData.labTestName);
			assertTrue(type(selenium, txtLabComment, orderData.labTestComments1), "Could not type comments", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium, ajxrProvider,orderData.sendTo);
			if(orderData.testCaseId.equals("TC_OL_005")){
				assertTrue(click(selenium,btnLabSign), "Could not click on sign button", selenium, ClassName,MethodName);
				return true;
			}
			assertTrue(click(selenium,"saveNewLabs"), "Could not click on save button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			return true;
		}
		catch(RuntimeException e){
			Assert.fail("Failed due to the Exception; \n Exception details: "+e.getMessage());
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}


	}


	
	/**
	 *createMedication
	 * function to create Medication
	 * @throws IOException 
	 * @since  	Nov 21, 2012
	 */	
	
	public boolean createMedication(Selenium selenium,ClinicalListLib medicationData,String account) throws IOException{
		String date=null;
		try{
			if(account.equals(CAAccount)){
				selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,medicationData.prescribeca);
				waitForPageLoad(selenium);
			}else
				selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,medicationData.prescribeName);
			if(account.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat.format(cal.getTime());
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
			}
			waitForPageLoad(selenium);
			if(medicationData.freeText.equals("Yes")){
				assertTrue(click(selenium,chkFreetextBox),"Could not click the check box;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,txtFreeBox,medicationData.direction),"Could not enter the text;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
			}if(medicationData.increaseDecreaseDose.equals("Yes")){
				assertTrue(click(selenium,chkInDeDosecheckBox),"Could not click the check box;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxRFMethod,medicationData.refillMethod);
				selectValueFromAjaxList(selenium,ajxRFMethod,medicationData.refillMethod);
				selectValueFromAjaxList(selenium,ajxRFQuatity,medicationData.refillQuantity);
				selectValueFromAjaxList(selenium,ajxRFUnit,medicationData.refillUnit);
				selectValueFromAjaxList(selenium,ajxRFRoute,medicationData.refillRoute);
				selectValueFromAjaxList(selenium,ajxRFFrequency,medicationData.refillFrequency);
				selectValueFromAjaxList(selenium,ajxRFUsage,medicationData.refillUsage);
				selectValueFromAjaxList(selenium,ajxRFUsage1,medicationData.refillUsage1);
				selectValueFromAjaxList(selenium,ajxDuration1,medicationData.duration);
				selectValueFromAjaxList(selenium,ajxRFUsage2,medicationData.refillUsage2);
				selectValueFromAjaxList(selenium,ajxRFUsage3,medicationData.refillUsage3);
				selectValueFromAjaxList(selenium,ajxRFUsage4,medicationData.refillUsage4);
			}if(medicationData.multipleDirection.equals("Yes")){
				assertTrue(click(selenium,chkMultipleCheckBox),"Could not click the check box;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxRFMethod1,medicationData.refillMethod);
				selectValueFromAjaxList(selenium,ajxRFQuatity1,medicationData.refillQuantity);
				selectValueFromAjaxList(selenium,ajxRFUnit1,medicationData.refillUnit);
				selectValueFromAjaxList(selenium,ajxRFFrequency1,medicationData.refillFrequency);
				selectValueFromAjaxList(selenium,ajxRFDuration,medicationData.refillduration);
				selectValueFromAjaxList(selenium,ajxRFUsage5,medicationData.refillUsage);
				selectValueFromAjaxList(selenium,ajxRFmethod,medicationData.method);
				selectValueFromAjaxList(selenium,ajxRFquantity,medicationData.quality);
				selectValueFromAjaxList(selenium,ajxRFunit,medicationData.unit);
				selectValueFromAjaxList(selenium,ajxRFroute,medicationData.route);
				selectValueFromAjaxList(selenium,ajxRFfreq,medicationData.frequency);
				selectValueFromAjaxList(selenium,ajxRFduration,medicationData.duration);
				selectValueFromAjaxList(selenium,ajxRFusage,medicationData.usage);
			}
			else if(!medicationData.freeText.equals("Yes")&& !medicationData.increaseDecreaseDose.equals("Yes")&& !medicationData.multipleDirection.equals("Yes")){
				selectValueFromAjaxList(selenium,ajxRFmethod1,medicationData.refillMethod);
				selectValueFromAjaxList(selenium,ajxRFquantity1,medicationData.refillQuantity);
				selectValueFromAjaxList(selenium,ajxRFunit1,medicationData.refillUnit);
				selectValueFromAjaxList(selenium,ajxRFroute1,medicationData.refillRoute);
				selectValueFromAjaxList(selenium,ajxRFfreq1,medicationData.refillFrequency );
				selectValueFromAjaxList(selenium,ajxRFduration1,medicationData.refillduration);
				selectValueFromAjaxList(selenium,ajxRFusage1,medicationData.refillUsage);
			}
			assertTrue(enterDate(selenium,txtCqmDate,date),"Could not enter the Date;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,txtSupplyBox,medicationData.supply),"Could not enter the supply;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(medicationData.testCaseId.equals("TC_PSM_006")){
				assertTrue(click(selenium,lnkShowMore),"Could not click the show more link;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				assertTrue(enterDate(selenium,txtPresOn,medicationData.prescribeOn),"could not enter date", selenium, ClassName,MethodName);
				assertTrue(type(selenium,txtRefill1,medicationData.refill),"Could not enter the refill;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,txtLabResult,medicationData.prescribedby),"Could not enter the date;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				assertTrue(enterDate(selenium,txtLastRefill,medicationData.lastRefill),"could not enter date", selenium, ClassName,MethodName);
				assertTrue(type(selenium,txtComments1,medicationData.comment),"Could not enter the commend;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
			}
									
			assertTrue(click(selenium,btnAdd1),"Could not click the add button;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			// Check for the Dialog box (Proceed Anyway)
			if(isElementPresent(selenium,btnCancelButton)){
				assertTrue(click(selenium,btnCancelButton),"Could not Click Proceed Anyway button"+medicationData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			
		}
		return false;
	}
	/**
	 * goToClinicalLists
	 * Function to go to clinical Lists
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Nov 21,2012
	 */
	public boolean goToClinicalLists(Selenium selenium) throws IOException{
		assertTrue(click(selenium, lnkQuickActions), "Could not click on Quick Actions button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkClinicalLists), "Could not click on Clinical Lists", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkCustomList), "Could not click on custom Lists", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		if(isElementPresent(selenium, "addIdentifierType"))
			return true;
		else
			return false;
	
		}
	
	
	
	/**
	 * goToRegisterPatient
	 * Function to go to RegisterPatient
	 * @param 	selenium
	 * @since	Nov 21,2012
	 */
	public boolean goToRegisterPatient(Selenium selenium){
		try {
			assertTrue(click(selenium, lnkQuickActions), "Could not click on Quick Actions button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegNewPatient), "Could not click on Clinical Lists", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnClinicalSave))
				return true;
			else
				return false;
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * verifySearchTextForMatchAllSex
	 * Function to go to RegisterPatient
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Nov 22,2012
	 */
	public boolean verifySearchTextForMatchAllSex(Selenium selenium,ClinicalListLib searchData) throws IOException{
		if(!searchData.testCaseId.equals("TC_VSS_001")){
			assertTrue(selenium.isTextPresent("Show all patients"),"Text Not Present", selenium, ClassName,MethodName);
			assertTrue(selenium.isTextPresent(searchData.sex),"Text Not Present", selenium, ClassName,MethodName);
			assertTrue(selenium.isTextPresent(searchData.searchType),"Text Not Present", selenium, ClassName,MethodName);
	
	}
		return true;
	}
	/**
	 * verifySearchTextForMatchOneOrMoreSex
	 * Function to go to RegisterPatient
	 * @param 	selenium
	 * @since	Nov 22,2012
	 */
	public boolean verifySearchTextForMatchOneOrMoreSex(Selenium selenium,ClinicalListLib searchData){
		if(!searchData.testCaseId.equals("TC_VSS_001")){
		if(!getText(selenium,lblSeacrhText).toLowerCase(new java.util.Locale("en","US")).trim().contains("Include one or more of those".trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblSeacrhText).toLowerCase(new java.util.Locale("en","US")).trim().contains(searchData.searchType.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblSeacrhText).toLowerCase(new java.util.Locale("en","US")).trim().contains(searchData.sex.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
	}
		else if(searchData.testCaseId.equals("TC_VSS_003")){
			if(!getText(selenium,lblSeacrhText).toLowerCase(new java.util.Locale("en","US")).trim().contains("Include one or more of those".trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getText(selenium,lblSeacrhText).toLowerCase(new java.util.Locale("en","US")).trim().contains(searchData.searchType.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getText(selenium,lblSeacrhText).toLowerCase(new java.util.Locale("en","US")).trim().contains(searchData.sex.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getText(selenium,lblSeacrhText).toLowerCase(new java.util.Locale("en","US")).trim().contains(searchData.sex1.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getText(selenium,lblSeacrhText).toLowerCase(new java.util.Locale("en","US")).trim().contains("or".trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		
		return true;
	}
	/**
	 * verifySearchTextForDoNotIncludeSex
	 * Function to go to RegisterPatient
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Nov 22,2012
	 */
	public boolean verifySearchTextForDoNotIncludeSex(Selenium selenium,ClinicalListLib searchData) throws IOException{
		if(!searchData.testCaseId.equals("TC_VSS_003")){
		assertTrue(selenium.isTextPresent("Do not include those"),"Text Not Present", selenium, ClassName,MethodName);
			
		assertTrue(selenium.isTextPresent(searchData.searchType),"Text Not Present", selenium, ClassName,MethodName);
		assertTrue(selenium.isTextPresent(searchData.sex),"Text Not Present", selenium, ClassName,MethodName);
	}
		else if(searchData.testCaseId.equals("TC_VSS_003")){
			
			assertTrue(selenium.isTextPresent("Do not include those"),"Text Not Present", selenium, ClassName,MethodName);
			
			assertTrue(selenium.isTextPresent(searchData.searchType),"Text Not Present", selenium, ClassName,MethodName);
			assertTrue(selenium.isTextPresent(searchData.sex),"Text Not Present", selenium, ClassName,MethodName);
			assertTrue(selenium.isTextPresent(searchData.sex1),"Text Not Present", selenium, ClassName,MethodName);

		}
		
		return true;
	}
	/**
	 * filterForAge
	 * Function to filter Match All
	 * @since	Nov 21, 2012
	 */
	public boolean filterForAge(Selenium selenium, ClinicalListLib ageData, String doNotInclude, int possition){
		
		if(ageData.testCaseId.equals("TC_CLA_002")){
			yearType=txtCTime;
		}
		
		String filterType="";
		String searchFiltertype="";
		String SearchDurationType="";
		String txtYearType="";
		String txtMinYear="";
		if(doNotInclude.equalsIgnoreCase("MatchAll" )){
			 filterType=lnkNewSearch;
			 searchFiltertype="andsearchTypeSuggestBoxsuggestBoxsuggestBox";
			 SearchDurationType="anddurationConditionSuggestBoxsuggestBoxsuggestBox";
			 txtMinYear="anddurationIntegerMin";
			 txtYearType="anddurationIntegerMax";
		}else if(doNotInclude.equalsIgnoreCase("OneOrMore")){
			filterType=btnAddNewCriteria1;
			searchFiltertype="orsearchTypeSuggestBoxsuggestBoxsuggestBox";
			SearchDurationType="ordurationConditionSuggestBoxsuggestBoxsuggestBox";
			txtMinYear="ordurationIntegerMin";
			txtYearType="ordurationIntegerMax";
		}else if(doNotInclude.equalsIgnoreCase("doNotInclude")){
			filterType=btnAddNewCriteria2;
			searchFiltertype="excludesearchTypeSuggestBoxsuggestBoxsuggestBox";
			SearchDurationType="excludedurationConditionSuggestBoxsuggestBoxsuggestBox";
			 txtMinYear="excludedurationIntegerMin";
			txtYearType="excludedurationIntegerMax";
		}
		try{
			selectValueFromAjaxList(selenium, String.valueOf(possition)+searchFiltertype, ageData.searchType);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+SearchDurationType , ageData.durationCondition);
			waitForPageLoad(selenium);
			if(ageData.durationCondition.equalsIgnoreCase("between")){
				assertTrue(type(selenium, String.valueOf(possition)+txtMinYear, ageData.year), "Could not enter minimum year", selenium, ClassName,MethodName);
				assertTrue(type(selenium, String.valueOf(possition)+txtYearType, ageData.maxYear), "Could not enter maximum year", selenium, ClassName,MethodName);
			}else{
				if(selenium.isVisible(String.valueOf(possition)+txtMinYear)){
					assertTrue(type(selenium,  String.valueOf(possition)+txtMinYear, ageData.year), "Could not enter the year", selenium, ClassName,MethodName);
				}else{
					assertTrue(type(selenium, String.valueOf(possition)+txtYearType, ageData.year), "Could not enter maximum year", selenium, ClassName,MethodName);
				}
					
			}
			if(!ageData.durationCondition1.equals("")){
				possition = possition+1;
				assertTrue(click(selenium, filterType), "Could not click on Add new button", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium, String.valueOf(possition)+searchFiltertype, ageData.searchType);
				selectValueFromAjaxList(selenium, String.valueOf(possition)+SearchDurationType, ageData.durationCondition1);
				waitForPageLoad(selenium);
				if(ageData.durationCondition1.equalsIgnoreCase("between")){
					assertTrue(type(selenium,String.valueOf(possition)+txtMinYear, ageData.year), "Could not enter minimum year", selenium, ClassName,MethodName);
					assertTrue(type(selenium, String.valueOf(possition)+txtYearType, ageData.maxYear), "Could not enter maximum year", selenium, ClassName,MethodName);
				}else if(ageData.testCaseId.equals("TC_CLA_014")||ageData.testCaseId.equals("TC_CLA_013")||ageData.testCaseId.equals("TC_CLA_009")||ageData.testCaseId.equals("TC_CLA_010")){
					assertTrue(type(selenium, String.valueOf(possition)+txtYearType, ageData.maxYear), "Could not enter maximum year", selenium, ClassName,MethodName);
				}
				else{
					if(selenium.isVisible(String.valueOf(possition)+txtMinYear)){
						assertTrue(type(selenium,String.valueOf(possition)+txtMinYear, ageData.year1), "Could not enter the year", selenium, ClassName,MethodName);
					}else
						assertTrue(type(selenium,String.valueOf(possition)+txtYearType, ageData.year1), "Could not enter the year", selenium, ClassName,MethodName);
				}
			}
			if(!ageData.durationCondition2.equals("")){
				possition = possition+1;
				assertTrue(click(selenium, filterType), "Could not click on Add new button", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium, String.valueOf(possition)+searchFiltertype, ageData.searchType);
				selectValueFromAjaxList(selenium, String.valueOf(possition)+SearchDurationType, ageData.durationCondition2);
				waitForPageLoad(selenium);
				if(ageData.durationCondition2.equalsIgnoreCase("between")){
					assertTrue(type(selenium, String.valueOf(possition)+txtMinYear, ageData.year), "Could not enter minimum year", selenium, ClassName,MethodName);
					assertTrue(type(selenium, String.valueOf(possition)+txtYearType, ageData.maxYear), "Could not enter maximum year", selenium, ClassName,MethodName);
				}
				else{
					if(selenium.isVisible(String.valueOf(possition)+txtMinYear)){
						assertTrue(type(selenium, String.valueOf(possition)+txtMinYear, ageData.year2), "Could not enter the year", selenium, ClassName,MethodName);
					}else{
						assertTrue(type(selenium, String.valueOf(possition)+txtYearType, ageData.year2), "Could not enter the year", selenium, ClassName,MethodName);
					}
				}
			}
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSearchClinicalList), "Could not click on seach button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			possition = possition+1;
			ageData.currentValue = String.valueOf(possition);
			return true;
		}
		catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed due to Exception");
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * searchMedicationWithOptionsForMatchAll
	 * function to search medication with multiple options
	 * @since  	Nov 22, 2012
	 */	
	
	public boolean searchMedicationWithOptionsForMatchAll(Selenium selenium,ClinicalListLib clinicalMedicationData,String account,int possition ){
		String date=null;
		try {
			if(account.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat.format(cal.getTime());
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
			}
			
			assertTrue(click(selenium,lnkNewSearch),"Could not click the clinical list button", selenium, ClassName,MethodName);
			
			assertTrue(click(selenium,lnkNewSearch),"Could not click the clinical list button", selenium, ClassName,MethodName);
			if(clinicalMedicationData.testCaseId.equals("TC_SM_007"))
				assertTrue(click(selenium,lnkNewSearch),"Could not click the clinical list button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox",clinicalMedicationData.searchField);
			if(clinicalMedicationData.testCaseId.equals("TC_SM_008"))
				if(account.equals(CAAccount)){
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeNameCa);
				}else
				selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeName);
			else{
				if(account.equals(CAAccount)){
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeNameCa);
				}else
				selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeName);
			}
			selectValueFromAjaxList(selenium,ajxtimeCondtion,clinicalMedicationData.timeCondition);
			
			possition = possition + 1;
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox",clinicalMedicationData.searchField);
			if(clinicalMedicationData.testCaseId.equals("TC_SM_008"))
				if(account.equals(CAAccount)){
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox1,clinicalMedicationData.prescribeNameCa1);
				}else
				selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox1,clinicalMedicationData.prescribeName1);
			else{
				if(account.equals(CAAccount)){
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox1,clinicalMedicationData.prescribeNameCa);
				}else
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox1,clinicalMedicationData.prescribeName);
			}
				
			selectValueFromAjaxList(selenium,ajxTimeCondiiton,clinicalMedicationData.timeCondition1);
			
			if(clinicalMedicationData.testCaseId.equals("TC_SM_004")){
				assertTrue(type(selenium,ajxPeriodNumber,clinicalMedicationData.periodNumber1),"Could not type the period Number", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxPeriodCondtion,clinicalMedicationData.period1);
			}
			else if(clinicalMedicationData.testCaseId.equals("TC_SM_005")){
				assertTrue(enterDate(selenium,txtDate,date),"Could not click the clinical list button", selenium, ClassName,MethodName);
			}else if(clinicalMedicationData.testCaseId.equals("TC_SM_006")){
	
				assertTrue(type(selenium,txtPeriodNumber1,clinicalMedicationData.periodNumber),"Could not type the period Number", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxPeriodCondition,clinicalMedicationData.period);
				assertTrue(enterDate(selenium,txtDate,date),"Could not click the clinical list button", selenium, ClassName,MethodName);
			}else if(clinicalMedicationData.testCaseId.equals("TC_SM_007")){
				possition = possition + 1;
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox",clinicalMedicationData.searchField);
				if(account.equals(CAAccount)){
					selectValueFromAjaxList(selenium,ajxPrescribeName,clinicalMedicationData.prescribeNameCa);
				}else
				selectValueFromAjaxList(selenium,ajxPrescribeName,clinicalMedicationData.prescribeName);
				selectValueFromAjaxList(selenium,ajxTimeCondtion,clinicalMedicationData.timeCondition2);
				
				assertTrue(type(selenium,ajxPeriodNumber,clinicalMedicationData.periodNumber1),"Could not type the period Number", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxPeriodCondtion,clinicalMedicationData.period1);
				
				assertTrue(enterDate(selenium,txtDate1,date),"Could not click the clinical list button", selenium, ClassName,MethodName);
			}
			assertTrue(click(selenium,btnSearchClinicalList1),"Could not click the search button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			possition = possition + 1;
			clinicalMedicationData.currentValue = String.valueOf(possition);
			return true;
		}catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
		}
	}
	
	/**
	 * searchMedicationWithOptionsForDoNotInclude
	 * function to search medication with multiple options
	 * @since  	Nov 22, 2012
	 */	
	
	public boolean searchMedicationWithOptionsForDoNotInclude(Selenium selenium,ClinicalListLib clinicalMedicationData,String account,int possition ){
		try {
			assertTrue(click(selenium,btnAddNewCriteria2),"Could not click the clinical list button", selenium, ClassName,MethodName);
			String date=null;
			if(account.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat.format(cal.getTime());
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
			}
			if(clinicalMedicationData.testCaseId.equals("TC_SM_008")||clinicalMedicationData.testCaseId.equals("TC_SM_005")||clinicalMedicationData.testCaseId.equals("TC_SM_006")||clinicalMedicationData.testCaseId.equals("TC_SM_004")||clinicalMedicationData.testCaseId.equals("TC_SM_007")){
				assertTrue(click(selenium,btnAddNewCriteria2),"Could not click the clinical list button", selenium, ClassName,MethodName);
			}
			if(clinicalMedicationData.testCaseId.equals("TC_SM_007"))
				assertTrue(click(selenium,btnAddNewCriteria2),"Could not click the clinical list button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox",clinicalMedicationData.searchField);
			//selectValueFromAjaxList(selenium,ajxSearchType,clinicalMedicationData.searchField);
			if(account.equals(CAAccount)){
				if(clinicalMedicationData.testCaseId.equals("TC_SM_008"))
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeNameCa);
				else
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeNameCa);
			}else{
				if(clinicalMedicationData.testCaseId.equals("TC_SM_008"))
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeName);
				else
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeName);
			}
			selectValueFromAjaxList(selenium,ajxtimeCondtion,clinicalMedicationData.timeCondition);
			possition = possition+1;
	 		selectValueFromAjaxList(selenium,String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox",clinicalMedicationData.searchField);
			if(account.equals(CAAccount)){
		 		if(clinicalMedicationData.testCaseId.equals("TC_SM_008"))
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox1,clinicalMedicationData.prescribeNameCa1);
				else
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox1,clinicalMedicationData.prescribeNameCa);
			}else{
				if(clinicalMedicationData.testCaseId.equals("TC_SM_008"))
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox1,clinicalMedicationData.prescribeName1);
				else
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox1,clinicalMedicationData.prescribeName);
			}
			selectValueFromAjaxList(selenium,ajxTimeCondiiton,clinicalMedicationData.timeCondition1);
			
			if(clinicalMedicationData.testCaseId.equals("TC_SM_004")){
				assertTrue(type(selenium,ajxPeriodNumber,clinicalMedicationData.periodNumber1),"Could not type the period Number", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxPeriodCondtion,clinicalMedicationData.period1);
			}
			else if(clinicalMedicationData.testCaseId.equals("TC_SM_005")){
				assertTrue(enterDate(selenium,txtDate,date),"Could not click the clinical list button", selenium, ClassName,MethodName);
			}else if(clinicalMedicationData.testCaseId.equals("TC_SM_006")){
	
				assertTrue(type(selenium,txtPeriodNumber1,clinicalMedicationData.periodNumber),"Could not type the period Number", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxPeriodCondition,clinicalMedicationData.period);
				//assertTrue(enterDate(selenium,txtDate,clinicalMedicationData.date1),"Could not click the clinical list button");
			}else if(clinicalMedicationData.testCaseId.equals("TC_SM_007")){
				possition = possition + 1;
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox",clinicalMedicationData.searchField);
				if(account.equals(CAAccount)){
					selectValueFromAjaxList(selenium,ajxPrescribeName,clinicalMedicationData.prescribeNameCa);
				}else
				selectValueFromAjaxList(selenium,ajxPrescribeName,clinicalMedicationData.prescribeName);
				selectValueFromAjaxList(selenium,ajxTimeCondtion,clinicalMedicationData.timeCondition2);
				
				assertTrue(type(selenium,ajxPeriodNumber,clinicalMedicationData.periodNumber1),"Could not type the period Number", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxPeriodCondtion,clinicalMedicationData.period1);
				assertTrue(enterDate(selenium,txtDate1,date),"Could not click the clinical list button", selenium, ClassName,MethodName);
			}
			assertTrue(click(selenium,btnSearchClinicalList1),"Could not click the search button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			possition = possition + 1;
			clinicalMedicationData.currentValue = String.valueOf(possition);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * searchMedicationWithOptionsForMatchOneOrMore
	 * function to search medication with multiple options
	 * @since  	Nov 22, 2012
	 */	
	
	public boolean searchMedicationWithOptionsForMatchOneOrMore(Selenium selenium,ClinicalListLib clinicalMedicationData,String account,int possition ){
		String date = null;
		if(account.equals(CAAccount)){
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
		date=DateFormat1.format(cal.getTime());
		}else{
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
		date=DateFormat1.format(cal.getTime());
		}
		try {
			assertTrue(click(selenium,btnAddNewCriteria3),"Could not click the clinical list button", selenium, ClassName,MethodName);
			assertTrue(click(selenium,btnAddNewCriteria3),"Could not click the clinical list button", selenium, ClassName,MethodName);
			if(clinicalMedicationData.testCaseId.equals("TC_SM_007"))
				assertTrue(click(selenium,btnAddNewCriteria3),"Could not click the clinical list button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",clinicalMedicationData.searchField);
			if(clinicalMedicationData.testCaseId.equals("TC_SM_008")){
				if(account.equals(CAAccount))
				    selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeNameCa1);
				else
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeName1);
				
			}else{
				if(account.equals(CAAccount))
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeNameCa);
				else
				     selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,clinicalMedicationData.prescribeName);
					
			}	
			selectValueFromAjaxList(selenium,ajxtimeCondtion,clinicalMedicationData.timeCondition);
			possition = possition+1;
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",clinicalMedicationData.searchField);
			if(clinicalMedicationData.testCaseId.equals("TC_SM_008")){
				if(account.equals(CAAccount))
				    selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox1,clinicalMedicationData.prescribeNameCa1);
				else
				selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox1,clinicalMedicationData.prescribeName1);
			}else{
				if(account.equals(CAAccount))
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox1,clinicalMedicationData.prescribeNameCa);
				else
				selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox1,clinicalMedicationData.prescribeName);
			
			}
			selectValueFromAjaxList(selenium,ajxTimeCondiiton,clinicalMedicationData.timeCondition1);
			
			if(clinicalMedicationData.testCaseId.equals("TC_SM_004")){
				assertTrue(type(selenium,ajxPeriodNumber,clinicalMedicationData.periodNumber1),"Could not type the period Number", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxPeriodCondtion,clinicalMedicationData.period1);
			}
			else if(clinicalMedicationData.testCaseId.equals("TC_SM_005")){
				assertTrue(enterDate(selenium,txtDate,date),"Could not click the clinical list button", selenium, ClassName,MethodName);
			}else if(clinicalMedicationData.testCaseId.equals("TC_SM_006")){
	
				assertTrue(type(selenium,txtPeriodNumber1,clinicalMedicationData.periodNumber),"Could not type the period Number", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxPeriodCondition,clinicalMedicationData.period);
				assertTrue(enterDate(selenium,txtDate,date),"Could not click the clinical list button", selenium, ClassName,MethodName);
			}else if(clinicalMedicationData.testCaseId.equals("TC_SM_007")){
				possition = possition+1;
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",clinicalMedicationData.searchField);
				if(account.equals(CAAccount))
					selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox2,clinicalMedicationData.prescribeNameCa);
				else
				selectValueFromAjaxList(selenium,ajxPrescribeName,clinicalMedicationData.prescribeName);
				selectValueFromAjaxList(selenium,ajxTimeCondtion,clinicalMedicationData.timeCondition2);
				
				assertTrue(type(selenium,ajxPeriodNumber,clinicalMedicationData.periodNumber1),"Could not type the period Number", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxPeriodCondtion,clinicalMedicationData.period1);
			    assertTrue(enterDate(selenium,txtDate1,date),"Could not click the clinical list button", selenium, ClassName,MethodName);
			}
			assertTrue(click(selenium,btnSearchClinicalList1),"Could not click the search button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			possition = possition+1;
			clinicalMedicationData.currentValue = String.valueOf(possition);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}




	/**
	 * deleteAllAllergy
	 * function to delete all existing Allergy
	 * @since	Nov 23, 2012
	 */	
	public boolean deleteAllAllergy(Selenium selenium ,ClinicalListLib allergyData){
		boolean allergyDeleted=true;
		int allergyCount=0;
		try{
			assertTrue(click(selenium,chkIncludeInactive),"Could not click the show All recorded check box;More Details:"+allergyData.toString(), selenium, ClassName,MethodName);
			
			waitForPageLoad(selenium);
			waitForElement(selenium,lblAllergyEntry, WAIT_TIME);
			while((Integer) selenium.getXpathCount(lblAllergyEntry) > 0){
				allergyCount=(Integer) selenium.getXpathCount(lblAllergyEntry);
				assertTrue(click(selenium,lblAllergyEntry),"could not click allergy entry", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, ajxdeleteReason, allergyData.reason), "Could not type reason for deletion", selenium, ClassName,MethodName);
				
				assertTrue(click(selenium,btnSaveBtn),"Could not click Delete button;More Details:"+allergyData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(allergyCount == (Integer) selenium.getXpathCount(lblAllergyEntry)){
					allergyDeleted = false;
					break;
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return allergyDeleted;
	}
	
	/**
	 * filterForSearchAllergicTo
	 * function to filter the Allergies
	 * @since Nov 23, 2012
	 */
	public boolean filterForSearchAllergicTo(Selenium selenium, ClinicalListLib allergyData, String doNotInclude,String account, int possition){
		String filterType="";
		String currentDate=null;
		if(doNotInclude.equalsIgnoreCase("MatchAll" )){
			 filterType=lnkNewSearch;
		}else if(doNotInclude.equalsIgnoreCase("OneOrMore")){
			filterType=btnAddNewCriteria1;
		}else if(doNotInclude.equalsIgnoreCase("doNotInclude")){
			filterType=btnAddNewCriteria2;
		}
		
		String searchFiltertype="";
		
		if(doNotInclude.equalsIgnoreCase("MatchAll" )){
			 filterType=lnkNewSearch;
			 searchFiltertype="andsearchTypeSuggestBoxsuggestBoxsuggestBox";
			
		}else if(doNotInclude.equalsIgnoreCase("OneOrMore")){
			filterType=btnAddNewCriteria1;
			searchFiltertype="orsearchTypeSuggestBoxsuggestBoxsuggestBox";
			
		}else if(doNotInclude.equalsIgnoreCase("doNotInclude")){
			filterType=btnAddNewCriteria2;
			searchFiltertype="excludesearchTypeSuggestBoxsuggestBoxsuggestBox";
			
		}
		System.out.println(filterType);
		
		boolean returnValue = true;
		try{
			
			selectValueFromAjaxList(selenium, String.valueOf(possition)+searchFiltertype,allergyData.searchType);
			if(account.equals(CAAccount)){
				selectValueFromAjaxList(selenium,ajxAllergyBox,allergyData.allergenCa);
			}else
			selectValueFromAjaxList(selenium,ajxAllergyBox,allergyData.allergen);
			selectValueFromAjaxList(selenium,ajxtimeCondtion,allergyData.timeCondition);
			if(allergyData.timeCondition.equalsIgnoreCase("within the last")){
				assertTrue(type(selenium, txtPeriodNumber1, allergyData.periodNumber), "Could not type period number", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium, ajxPeriodCondition, allergyData.periodCondition);
			}
			if(allergyData.timeCondition.equalsIgnoreCase("after this date")){
				if(account.equals(CAAccount)){
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat curDate = new SimpleDateFormat("dd/MM/yyyy");
					 currentDate = curDate.format(cal.getTime());
					}else{
						Calendar cal = Calendar.getInstance();
						SimpleDateFormat curDate = new SimpleDateFormat("MM/dd/yyyy");
						currentDate = curDate.format(cal.getTime());
					}
				Assert.assertEquals(getValue(selenium, txtLabDate), currentDate);
				}
			
			if(!allergyData.timeCondition1.equals("")){
				possition = possition+1;
				assertTrue(click(selenium, filterType), "Could not click on Add New button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, String.valueOf(possition)+searchFiltertype,allergyData.searchType);
				if(account.equals(CAAccount)){
					selectValueFromAjaxList(selenium,ajxAllergySuggestBox,allergyData.allergenCa);
				}else
				selectValueFromAjaxList(selenium,ajxAllergySuggestBox,allergyData.allergen);
				selectValueFromAjaxList(selenium,ajxTimeCondiiton,allergyData.timeCondition1);
				waitForPageLoad(selenium);
				if(allergyData.timeCondition1.equals("within the last")){
					if(isElementPresent(selenium,txtPeriodNum)){
						assertTrue(type(selenium, txtPeriodNum, allergyData.periodNumber), "Could not type period number", selenium, ClassName,MethodName);
						selectValueFromAjaxList(selenium, ajxPeriodCondtion, allergyData.periodCondition);
					}else
						assertTrue(type(selenium, txtPeriodNum1, allergyData.periodNumber), "Could not type period number", selenium, ClassName,MethodName);	
					selectValueFromAjaxList(selenium, ajxPeriodCondtion, allergyData.periodCondition);
				}
				
			}
			if(!allergyData.timeCondition2.equals("")){
				possition = possition+1;
				assertTrue(click(selenium, filterType), "Could not click on Add New button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, String.valueOf(possition)+searchFiltertype,allergyData.searchType);
				if(account.equals(CAAccount)){
					selectValueFromAjaxList(selenium,ajxAllergySuggestBox1,allergyData.allergenCa);
				}else
				selectValueFromAjaxList(selenium,ajxAllergySuggestBox1,allergyData.allergen);
				selectValueFromAjaxList(selenium,ajxTimeCondtion,allergyData.timeCondition2);
				waitForPageLoad(selenium);
				if(allergyData.timeCondition2.equalsIgnoreCase("within the last")){
					if(isElementPresent(selenium,txtWthyear1)){
						assertTrue(type(selenium, txtWthyear1, allergyData.periodNumber), "Could not type period number", selenium, ClassName,MethodName);
					}else
						assertTrue(type(selenium, txtWthyear2, allergyData.periodNumber), "Could not type period number", selenium, ClassName,MethodName);
					selectValueFromAjaxList(selenium, ajxPeriodCondtion1, allergyData.periodCondition);
				}
				if(allergyData.timeCondition2.equalsIgnoreCase("after this date")){
					if(account.equals(CAAccount)){
						Calendar cal = Calendar.getInstance();
						SimpleDateFormat curDate = new SimpleDateFormat("dd/MM/yyyy");
						currentDate = curDate.format(cal.getTime());
					}else{
						Calendar cal = Calendar.getInstance();
						SimpleDateFormat curDate = new SimpleDateFormat("MM/dd/yyyy");
						currentDate = curDate.format(cal.getTime());
					}
					if(isElementPresent(selenium,txtAftyear1)){
						Assert.assertEquals(getValue(selenium, txtAftyear1), currentDate);
					}
					else
						Assert.assertEquals(getValue(selenium, txtAftyear2), currentDate);
					}
				}
			if(allergyData.testCaseId.equals("TC_SA_008")){
				if(!allergyData.allergen1.equals("")){
					possition = possition+1;
					assertTrue(click(selenium, filterType), "Could not click on Add New button", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium, String.valueOf(possition)+searchFiltertype,allergyData.searchType);
					if(account.equals(CAAccount)){
						selectValueFromAjaxList(selenium,ajxAllergySuggestBox2,allergyData.allergenCa);
					}else
					selectValueFromAjaxList(selenium,ajxAllergySuggestBox2,allergyData.allergen1);
					selectValueFromAjaxList(selenium,ajxTimeCondtion1,allergyData.timeCondition);
					
				}
			}
			assertTrue(click(selenium,btnSearchClinicalList),"Could not click the search button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			possition = possition+1;
			allergyData.currentValue = String.valueOf(possition);
			return returnValue;
		}
		catch(RuntimeException e){
			Assert.fail("Failed due to Exception");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}
	
	/**
	 * createAllergy
	 * Function to create an Allergy
	 * @since Nov 23, 2012
	 */
	public boolean createAllergy(Selenium selenium, ClinicalListLib allergyData,String account){
		boolean returnValue = true;
		try{
			if(!allergyData.allergen1.equals("")){
				if(account.equals(CAAccount)){
					selectValueFromAjaxList(selenium,ajxAllergy,allergyData.allergen1Ca);
				}else
				selectValueFromAjaxList(selenium, ajxAllergy, allergyData.allergen1);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, "reactionLink"),
						"Could not on show more button",selenium, ClassName, MethodName);			
				waitForPageLoad(selenium);
				assertTrue(click(selenium, "1checkboxAllergyReaction"),
						"Could not on show more button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, "	multiSelectionCloseButton"),
						"Could not on show more button",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxStatus, "Active");
				assertTrue(click(selenium,btnAdd1),"Could not click the add button;More details:"+allergyData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium, btnEditLink))
					returnValue = true;
			}
			else{
				if(account.equals(CAAccount)){
					selectValueFromAjaxList(selenium,ajxAllergy,allergyData.allergenCa);
				}else
				selectValueFromAjaxList(selenium, ajxAllergy, allergyData.allergen);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, "reactionLink"),
						"Could not on show more button",selenium, ClassName, MethodName);			
				waitForPageLoad(selenium);
				assertTrue(click(selenium, "1checkboxAllergyReaction"),
						"Could not on show more button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, "	multiSelectionCloseButton"),
						"Could not on show more button",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxStatus, "Active");
				assertTrue(click(selenium,btnAdd1),"Could not click the add button;More details:"+allergyData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				if(isElementPresent(selenium, btnEdit))
					returnValue = true;
			}
		}
		catch(RuntimeException e){
			Assert.fail("Failed due to exception");
			e.printStackTrace();
			returnValue = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}
	
	/**
	 * deleteAllProblemList Function to delete All Existing Problem List
	 * @throws IOException 
	 * 
	 * @since Nov 05, 2012
	 */
	public boolean deleteAllProblemList(Selenium selenium,
			ClinicalListLib proData) throws IOException {
		boolean problemDeleted = true;
		int problemCount = 0;
		try {

			waitForElement(selenium, btnDeleteImmunization, WAIT_TIME);
			while (isElementPresent(selenium, btnDeleteImmunization)) {

				assertTrue(click(selenium, btnDeleteImmunization),"Could not click on the immunization button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, txtdeleteReason,
								proData.patientId),
						"Could not enter the reason",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkDeleteReason),"Could not click on Continue Button" ,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				
				if (!isElementPresent(selenium, btnDeleteImmunization)) {

					break;
				}
				problemCount++;
				if(problemCount>15){
					break;
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return problemDeleted;
	}
	
	/**
	 * searchWithProblemList
	 * Function to search a patient with problem list
	 * @since	Nov 23, 2012
	 */	
	
	public boolean searchWithProblemList(Selenium selenium ,ClinicalListLib clinicalProblemListData,String doNotInclude,int possition){
		boolean problemDeleted=true;
		String searchFiltertype=null;
		
			if(doNotInclude.equalsIgnoreCase("MatchAll" )){
				searchFiltertype="andsearchTypeSuggestBoxsuggestBoxsuggestBox";
				 
			}else if(doNotInclude.equalsIgnoreCase("OneOrMore")){
				searchFiltertype="orsearchTypeSuggestBoxsuggestBoxsuggestBox";
				
			}else if(doNotInclude.equalsIgnoreCase("doNotInclude")){
				searchFiltertype="excludesearchTypeSuggestBoxsuggestBoxsuggestBox";
				
			}
		try{
			selectValueFromAjaxList(selenium,String.valueOf(possition)+searchFiltertype,clinicalProblemListData.searchField);
			selenium.type(ajxProblemList,clinicalProblemListData.diagnosis1);
			//selenium.typeKeys(textboxName,valueForSelection);
			selenium.fireEvent(ajxProblemList,"keydown");
			//selenium.fireEvent(ajxProblemList,"keypress");                           
			selenium.fireEvent(ajxProblemList,"keyup");
			waitForPageLoad(selenium);
			selenium.keyPress(ajxProblemList, "\\13");
			waitForPageLoad(selenium);
			selenium.clickAt(ajxProblemList, "");
			waitForPageLoad(selenium);
			selenium.keyPress(ajxProblemList, "\\13");
			selenium.clickAt(ajxProblemList, "");
			click(selenium,currentItem); 
			selenium.clickAt(ajxProblemList,"");
			click(selenium,currentItem); 
			selectValueFromAjaxList(selenium,ajxtimeCondtion,clinicalProblemListData.timeCondition);
			if(clinicalProblemListData.testCaseId.equals("TC_SPL_002")){
				assertTrue(type(selenium,txtPeriodNumber1,clinicalProblemListData.periodNumber),"Could not type the period Number", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxPeriodCondition,clinicalProblemListData.period);
			}
			else if(clinicalProblemListData.testCaseId.equals("TC_SPL_003")){
				assertTrue(type(selenium,txtLabDate,clinicalProblemListData.date),"Could not click the clinical list button", selenium, ClassName,MethodName);
			}
			assertTrue(click(selenium,btnSearchClinicalList1),"Could not click the search button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			possition = possition + 1;
			clinicalProblemListData.currentValue = String.valueOf(possition);
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return problemDeleted;
	}
	/**
	 * create ProblemList
	 * function to create Problem list
	 * @since  	Nov 23, 2012
	 */	
	
	public boolean createProblemList(Selenium selenium,ClinicalListLib clinicalProblemListData,String account){
		String date=null;
		try{
			if(!clinicalProblemListData.diagnosis2.equals(""))
				assertTrue(type(selenium,ajxMedicalCondtion,clinicalProblemListData.medicalCondition),"Could not type medical condition", selenium, ClassName,MethodName);
			else
				assertTrue(type(selenium,ajxMedicalCondtion,clinicalProblemListData.medicalCondition),"Could not type medical condition", selenium, ClassName,MethodName);
			if(account.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat.format(cal.getTime());
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
			}
			assertTrue(enterDate(selenium,txtonSetDate,date),"Could not enter the Admin on ;More Details:"+clinicalProblemListData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,ajxItemStatus,clinicalProblemListData.itemStatus);
			if(isElementPresent(selenium,ajxOption2)){
				click(selenium,ajxOption2);
			}else if(isElementPresent(selenium,ajxOption1)){
			click(selenium,ajxOption1);
			}
			assertTrue(click(selenium,"medicationsMoreDetails"),"Could not on show more button", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,ajxLifeStage,clinicalProblemListData.lifeStage);
			if(isElementPresent(selenium,ajxOption2)){
				click(selenium,ajxOption2);
			}else if(isElementPresent(selenium,ajxOption1)){
			click(selenium,ajxOption1);
			}
			assertTrue(enterDate(selenium,txtResolvedDate,date),"Could not enter resolved date ;More Details:"+clinicalProblemListData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			//selectValueFromAjaxList(selenium,ajxcodingSystemsuggestBox,clinicalProblemListData.codingSystem);
			if(isElementPresent(selenium,ajxOption2)){
				click(selenium,ajxOption2);
			}else if(isElementPresent(selenium,ajxOption1)){
			click(selenium,ajxOption1);
			}
			waitForPageLoad(selenium);
			if(selenium.isVisible(ajxdiagnosissuggestBox)){
			if(clinicalProblemListData.diagnosis2.equals(""))
				selectValueFromAjaxList(selenium,ajxdiagnosissuggestBox,clinicalProblemListData.diagnosis1);
			else
				selectValueFromAjaxList(selenium,ajxdiagnosissuggestBox,clinicalProblemListData.diagnosis2);
 			if(isElementPresent(selenium,ajxOption2)){
				click(selenium,ajxOption2);
			}else if(isElementPresent(selenium,ajxOption1)){
			click(selenium,ajxOption1);
			}
			}
 			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtSummaryComment,clinicalProblemListData.comment),"Could not enter the comment;More Details:"+clinicalProblemListData.toString(), selenium, ClassName,MethodName);
			assertTrue(click(selenium,btnAdd1),"Could not click the add button;More details:"+clinicalProblemListData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium); 
			return true;
			}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		return false;
	}

	/**
	 * create ProblemList
	 * function to create Procedure
	 * @since  	Sep 28, 2012
	 */	
	
	public boolean createProblemListforCQM(Selenium selenium,ChartPreVisitLib proData){
		try{
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxMedicalCondtion,proData.medicalCondition1);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			String date=DateFormat.format(cal.getTime());
			assertTrue(enterDate(selenium,txtonSetDate,date),"Could not enter the Admin on ;More Details:"+proData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,ajxItemStatus,proData.itemStatus);
			if(isElementPresent(selenium,ajxOption2)){
				click(selenium,ajxOption2);
			}else if(isElementPresent(selenium,ajxOption1)){
			click(selenium,ajxOption1);
			}
			if(proData.testCaseId.equals("TC_CPL_002")||proData.testCaseId.equals("TC_CPL_007")||proData.testCaseId.equals("TC_CPL_012")||proData.testCaseId.equals("TC_CPL_042")||proData.testCaseId.equals("TC_CPL_043")||proData.testCaseId.equals("TC_CPL_011")||proData.testCaseId.equals("TC_CPL_010")||proData.testCaseId.equals("TC_CPL_046")||proData.testCaseId.equals("TC_CPL_009")){
				assertTrue(click(selenium,"problemsMoreDetails"),"Could not on show more button", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxLifeStage,proData.lifeStage);
				if(isElementPresent(selenium,ajxOption2)){
					click(selenium,ajxOption2);
				}else if(isElementPresent(selenium,ajxOption1)){
				click(selenium,ajxOption1);
				}
				assertTrue(enterDate(selenium,txtResolvedDate,date),"Could not enter resolved date ;More Details:"+proData.toString(), selenium, ClassName,MethodName);
				
				selectValueFromAjaxList(selenium,ajxcodingSystemsuggestBox,proData.codingSystem);
				if(isElementPresent(selenium,ajxOption2)){
					click(selenium,ajxOption2);
				}else if(isElementPresent(selenium,ajxOption1)){
				click(selenium,ajxOption1);
				}
				waitForPageLoad(selenium);
	 			selectValueFromAjaxList(selenium,ajxdiagnosissuggestBox,proData.diagnosis);
	 			if(isElementPresent(selenium,ajxOption2)){
					click(selenium,ajxOption2);
				}else if(isElementPresent(selenium,ajxOption1)){
				click(selenium,ajxOption1);
				}
	 			waitForPageLoad(selenium);
				assertTrue(type(selenium,txtSummaryComment,proData.comment),"Could not enter the comment;More Details:"+proData.toString(), selenium, ClassName,MethodName);
			}
			if(proData.testCaseId.equals("TC_CPL_004")){
				assertTrue(click(selenium,lnkNewSearch),"Could not click the Cancel button;More details:"+proData.toString(), selenium, ClassName,MethodName);
				return true;
			}
			if(proData.testCaseId.equals("TC_CPL_006")){
				assertTrue(click(selenium,btnlabCancel),"Could not click the Cancel button;More details:"+proData.toString(), selenium, ClassName,MethodName);
				return true;
			}
			
			if(isElementPresent(selenium,btnAdd1)){
			assertTrue(click(selenium,btnAdd1),"Could not click the add button;More details:"+proData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			}else
				assertTrue(click(selenium,btnlabSave1),"Could not click the add button;More details:"+proData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			return true;
			}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}

	
	/**
	 * createImmunization
	 * function to create Immunization
	 * @since  	   Sep 26, 2012
	 */	

	public boolean createImmunization(Selenium selenium,ChartPreVisitLib immunizationData){
		try{
			if(immunizationData.refused.equals("yes")){
				assertTrue(click(selenium,chkRefusedBox),"Could not click refused check box;More Details:"+immunizationData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);  
				selectValueFromAjaxList(selenium,ajxImmunization,immunizationData.immunization);
				waitForPageLoad(selenium);
				assertTrue(enterDate(selenium,txtRefusedDate,immunizationData.refusedDate),"Could not enter the resued Date;More Details:"+immunizationData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,txtSummaryComment1,immunizationData.comment),"Could not enter the comment;More Details:"+immunizationData.toString(), selenium, ClassName,MethodName);
			}if(immunizationData.admin.equals("yes")){
				assertTrue(click(selenium,chkPartial),"Could not click the admin check box;More Details:"+immunizationData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxImmunization1,immunizationData.immunization);
				waitForPageLoad(selenium);
				assertTrue(enterDate(selenium,txtAdminDate,immunizationData.adminOn),"Could not enter the Admin on ;More Details:"+immunizationData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,txtSummaryComment,immunizationData.comment),"Could not enter the comment;More Details:"+immunizationData.toString(), selenium, ClassName,MethodName);
			}else if(!immunizationData.refused.equals("yes")&& !immunizationData.admin.equals("yes")){
				// Fixed based on begin encounter immunization
				selectValueFromAjaxList(selenium,"searchVaccineBox",immunizationData.vaccine);
				assertTrue(type(selenium,txtImmunizationLot,immunizationData.lotNumber),"Could not enter the lot number", selenium, ClassName,MethodName);
				assertTrue(type(selenium,txtImmunizationDosage,immunizationData.dosage),"Could not enter the dosage value;More Details:"+immunizationData.toString(), selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxDosage,immunizationData.dosageUnit);
				click(selenium,ajxMedicationNameOption);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(enterDate(selenium,txtExpiry,immunizationData.expiryData),"Could not enter the expiry date;More Details:"+immunizationData.toString(), selenium, ClassName,MethodName);
				assertTrue(enterDate(selenium,txtAdminOnDate,immunizationData.adminOn),"Could not enter the Admin on date;More Details:"+immunizationData.toString(), selenium, ClassName,MethodName);
				assertTrue(click(selenium,lnkImmShowMore),"Could not click the link;More Details:"+immunizationData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxSeries,immunizationData.series);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxSeriesOf,immunizationData.seriesof);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxSite,immunizationData.site);
				selectValueFromAjaxList(selenium,ajxImmRoute,immunizationData.route);
				if(immunizationData.consentCheck.equals("yes")){
					assertTrue(click(selenium,chkConsents),"Could not click the check box", selenium, ClassName,MethodName);
					selectValueFromAjaxList(selenium,ajxConsent,immunizationData.consent);
				}
				selectValueFromAjaxList(selenium,ajxadminsteredBy,immunizationData.adminBy);
				
				selectValueFromAjaxList(selenium,ajxImmCpt1,immunizationData.cptCode1);
				
				selectValueFromAjaxList(selenium,ajxImmCp2,immunizationData.cptCode2);
				
				selectValueFromAjaxList(selenium,ajxImmreaction,immunizationData.reaction);
				
				assertTrue(type(selenium,txtImmComment,immunizationData.comment),"Could not type the comments;More Details:"+immunizationData.toString(), selenium, ClassName,MethodName);
				if(immunizationData.saveList.equals("yes")){
					assertTrue(click(selenium,chkSaveListBox1),"Could not click the save list check box;More Details:"+immunizationData.toString(), selenium, ClassName,MethodName);
				}
			}
			if(immunizationData.testCaseId.equalsIgnoreCase("TC_CIM_004")||immunizationData.testCaseId.equalsIgnoreCase("TC_CIM_006")||immunizationData.testCaseId.equalsIgnoreCase("TC_CIM_007")||immunizationData.testCaseId.equalsIgnoreCase("TC_CIM_008")){
				assertTrue(click(selenium,btnlabSave1),"Could not click the save button;More Details:"+immunizationData.toString(), selenium, ClassName,MethodName);
				return true;
			}
			assertTrue(click(selenium,btnAdd1),"Could not click the add button;More details:"+immunizationData.toString(), selenium, ClassName,MethodName);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/** createImmunizationForCqm
	 * function to create Immunization
	 * @since  	   Jan 21, 2012
	 */	

	public boolean createImmunizationForCqm(Selenium selenium,ChartPreVisitLib immunizationData){
		try{
			
				selectValueFromAjaxList(selenium,ajxVaccine,immunizationData.vaccine1);
				assertTrue(enterDate(selenium,txtAdminOnDate,immunizationData.adminOn),"Could not enter the Admin on date;More Details:"+immunizationData.toString(), selenium, ClassName,MethodName);
				assertTrue(click(selenium,lnkImmShowMore),"Could not click the link;More Details:"+immunizationData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"cpt1suggestBox",immunizationData.cptCode1);
				selectValueFromAjaxList(selenium,"cpt2suggestBox",immunizationData.cptCode2);
				assertTrue(click(selenium,btnAdd1),"Could not click the add button;More details:"+immunizationData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	
	/**
	 * searchProblemListWithOptions
	 * function to search problem list with multiple options
	 * @since  	Nov 23, 2012
	 */	
	
	public boolean searchProblemListWithOptions(Selenium selenium,ClinicalListLib clinicalProblemListData, String doNotInclude, int possition){
		 String searchFiltertype = null; 
		if(doNotInclude.equalsIgnoreCase("MatchAll" )){
			searchFiltertype="andsearchTypeSuggestBoxsuggestBoxsuggestBox";
			 
		}else if(doNotInclude.equalsIgnoreCase("OneOrMore")){
			searchFiltertype="orsearchTypeSuggestBoxsuggestBoxsuggestBox";
			
		}else if(doNotInclude.equalsIgnoreCase("doNotInclude")){
			searchFiltertype="excludesearchTypeSuggestBoxsuggestBoxsuggestBox";
			
		}
		try{
		selectValueFromAjaxList(selenium,String.valueOf(possition)+searchFiltertype,clinicalProblemListData.searchField);
		if(clinicalProblemListData.testCaseId.equals("TC_SPL_008"))
			selectValueFromAjaxList(selenium,ajxProblemList,clinicalProblemListData.diagnosis1);
		else
			selectValueFromAjaxList(selenium,ajxProblemList,clinicalProblemListData.diagnosis1);
		selectValueFromAjaxList(selenium,ajxtimeCondtion,clinicalProblemListData.timeCondition);
		possition = possition+1;
		selectValueFromAjaxList(selenium,String.valueOf(possition)+searchFiltertype,clinicalProblemListData.searchField);
		if(clinicalProblemListData.testCaseId.equals("TC_SPL_008"))
			selectValueFromAjaxList(selenium,ajxPblmDiag,clinicalProblemListData.diagnosis1);
		else
			selectValueFromAjaxList(selenium,ajxPblmDiag,clinicalProblemListData.diagnosis1);
		
		selectValueFromAjaxList(selenium,ajxTimeCondiiton,clinicalProblemListData.timeCondition1);
		
		if(clinicalProblemListData.testCaseId.equals("TC_SPL_004")){
			assertTrue(type(selenium,ajxPeriodNumber,clinicalProblemListData.periodNumber1),"Could not type the period Number", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,ajxPeriodCondtion,clinicalProblemListData.period1);
		}
		else if(clinicalProblemListData.testCaseId.equals("TC_SPL_005")){
			assertTrue(enterDate(selenium,txtDate,clinicalProblemListData.date1),"Could not click the clinical list button", selenium, ClassName,MethodName);
		}else if(clinicalProblemListData.testCaseId.equals("TC_SPL_006")){
			assertTrue(type(selenium,txtPeriodNumber1,clinicalProblemListData.periodNumber),"Could not type the period Number", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,ajxPeriodCondition,clinicalProblemListData.period);
			assertTrue(enterDate(selenium,txtDate,clinicalProblemListData.date1),"Could not click the clinical list button", selenium, ClassName,MethodName);
		}else if(clinicalProblemListData.testCaseId.equals("TC_SPL_007")){
			possition = possition + 1;
			selectValueFromAjaxList(selenium,String.valueOf(possition)+searchFiltertype,clinicalProblemListData.searchField);
			selectValueFromAjaxList(selenium,ajxPblmDiag1,clinicalProblemListData.diagnosis1);
			selectValueFromAjaxList(selenium,ajxTimeCondtion,clinicalProblemListData.timeCondition2);
			assertTrue(type(selenium,ajxPeriodNumber,clinicalProblemListData.periodNumber1),"Could not type the period Number", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,ajxPeriodCondtion,clinicalProblemListData.period1);
			assertTrue(enterDate(selenium,txtDate1,clinicalProblemListData.date1),"Could not click the clinical list button", selenium, ClassName,MethodName);
		}
		assertTrue(click(selenium,btnSearchClinicalList1),"Could not click the search button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		possition = possition + 1;
		clinicalProblemListData.currentValue = String.valueOf(possition);
		return true;
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	/**
	 * searchWithAll
	 * function to search with all search types
	 * @throws IOException 
	 * @since  	Nov 27, 2012
	 */	
	
	public boolean searchWithAll(Selenium selenium,ClinicalListLib searchData,String account, int possition) throws IOException{
		/*String searchFiltertype="";
		String SearchDurationType="";
		String txtYearType="";
		String txtMinYear="";*/
		if(searchData.testCaseId.equals("TC_VSA_003")){
			assertTrue(click(selenium, btnAddForMatchAll), "Could not click on Add New button for Match All Filter", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium, String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox", searchData.searchType1);
			selectValueFromAjaxList(selenium, String.valueOf(possition)+"excludedurationConditionSuggestBoxsuggestBoxsuggestBox", searchData.durationCondition1);
			assertTrue(type(selenium, String.valueOf(possition)+"excludedurationIntegerMax", searchData.year1), "Could not enter minimum year", selenium, ClassName,MethodName);
		}
		
		else if(searchData.testCaseId.equals("TC_VSA_002")){
			assertTrue(click(selenium, btnAddNewCriteria1), "Could not click on Add New button for Match All Filter", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium, String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox", searchData.searchType1);
			selectValueFromAjaxList(selenium, String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox",searchData.durationCondition1);
			assertTrue(type(selenium, String.valueOf(possition)+"ordurationIntegerMax", searchData.year1), "Could not enter minimum year", selenium, ClassName,MethodName);
		}
		else if(searchData.testCaseId.equals("TC_VSA_001")){
			assertTrue(click(selenium, lnkNewSearch), "Could not click on Add New button for Match All Filter", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium, String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox", searchData.searchType1);
			selectValueFromAjaxList(selenium, String.valueOf(possition)+"anddurationConditionSuggestBoxsuggestBoxsuggestBox", searchData.durationCondition1);
			assertTrue(type(selenium, String.valueOf(possition)+"anddurationIntegerMax", searchData.year1), "Could not enter minimum year", selenium, ClassName,MethodName);
		}
		
		
		possition = possition+1;
		
		if(searchData.testCaseId.equals("TC_VSA_003")){
			assertTrue(click(selenium, btnAddForMatchAll), "Could not click on Add New button for Match All Filter", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium, String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType2);
		}
		
		else if(searchData.testCaseId.equals("TC_VSA_002")){
			assertTrue(click(selenium, btnAddNewCriteria1), "Could not click on Add New button for Match All Filter", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType2);
		}
		else if(searchData.testCaseId.equals("TC_VSA_001")){
			assertTrue(click(selenium, lnkNewSearch), "Could not click on Add New button for Match All Filter", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType2);
		}
		
		selectValueFromAjaxList(selenium,ajxSex1CondtionForMatchAll,searchData.sex);
		
		possition = possition+1;
		
		if(searchData.testCaseId.equals("TC_VSA_003")){
			assertTrue(click(selenium, btnAddForMatchAll), "Could not click on Add New button for Match All Filter", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType3);
		}
		
		else if(searchData.testCaseId.equals("TC_VSA_002")){
			assertTrue(click(selenium, btnAddNewCriteria1), "Could not click on Add New button for Match All Filter", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType3);
		}
		else if(searchData.testCaseId.equals("TC_VSA_001")){
			assertTrue(click(selenium, lnkNewSearch), "Could not click on Add New button for Match All Filter", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType3);
		}
		
		selectValueFromAjaxList(selenium,ajxPblmDiag1,searchData.prescribe);
		selectValueFromAjaxList(selenium,ajxTimeCondtion,searchData.timeCondition1);
		
		possition = possition+1;
		if(searchData.testCaseId.equals("TC_VSA_003")){
			assertTrue(click(selenium, btnAddForMatchAll), "Could not click on Add New button for Match Dont Include Filter", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType4);
		}
		
		else if(searchData.testCaseId.equals("TC_VSA_002")){
			assertTrue(click(selenium, btnAddNewCriteria1), "Could not click on Add New button for Match one or more Filter", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType4);
		}
		else if(searchData.testCaseId.equals("TC_VSA_001")){
			assertTrue(click(selenium, lnkNewSearch), "Could not click on Add New button for Match All Filter", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType4);
		}
		
		waitForPageLoad(selenium);
		if(account.equals(CAAccount)){
			selectValueFromAjaxList(selenium,ajxAllergySuggestBox2,searchData.allergenCa);
		}else
		selectValueFromAjaxList(selenium,ajxAllergySuggestBox2,searchData.allergen);
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium,ajxTimeCondtion1,searchData.timeCondition2);
		
		possition = possition+1;
		if(searchData.testCaseId.equals("TC_VSA_003")){
			assertTrue(click(selenium, btnAddForMatchAll), "Could not click on Add New button for Match Dont Include Filter", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType5);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"excludedurationConditionSuggestBoxsuggestBoxsuggestBox",searchData.durationCondition2);
		}
		
		else if(searchData.testCaseId.equals("TC_VSA_002")){
			assertTrue(click(selenium, btnAddNewCriteria1), "Could not click on Add New button for Match One or more Filter", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType5);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox",searchData.durationCondition2);
		}
		else if(searchData.testCaseId.equals("TC_VSA_001")){
			assertTrue(click(selenium, lnkNewSearch), "Could not click on Add New button for Match All Filter", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType5);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"anddurationConditionSuggestBoxsuggestBoxsuggestBox",searchData.durationCondition2);
		}
	
		selenium.type(ajxLabResultMatchAll,searchData.labResult);
		//selenium.typeKeys(textboxName,valueForSelection);
		selenium.fireEvent(ajxLabResultMatchAll,"keydown");
		selenium.fireEvent(ajxLabResultMatchAll,"keypress");                           
		selenium.fireEvent(ajxLabResultMatchAll,"keyup");
		waitForPageLoad(selenium);
		selenium.keyPress(ajxLabResultMatchAll, "\\13");
		waitForPageLoad(selenium);
		selenium.clickAt(ajxLabResultMatchAll, "");
		waitForPageLoad(selenium);
		selenium.keyPress(ajxLabResultMatchAll, "\\13");
		selenium.clickAt(ajxLabResultMatchAll, "");
		click(selenium,currentItem); 
		selenium.clickAt(ajxLabResultMatchAll,"");
		click(selenium,currentItem); 
		
		if(isElementPresent(selenium,txtAftyear3)){
		assertTrue(type(selenium, txtAftyear3, searchData.year2), "Could not enter minimum year", selenium, ClassName,MethodName);
		}else
		//Assert.assertTrue(type(selenium, txtAftyear4, searchData.year2), "Could not enter minimum year");
		assertTrue(type(selenium, txtAftyear4, searchData.year2), ""	+ "Could not enter minimum year", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
			
		//selectValueFromAjaxList(selenium,txtAftyear3,searchData.year2);
		selectValueFromAjaxList(selenium,ajxTimeCondtion2,searchData.timeCondition3);
		
		possition = possition+1;
		if(searchData.testCaseId.equals("TC_VSA_003")){
			assertTrue(click(selenium, btnAddForMatchAll), "Could not click on Add New button for Match Dont Include Filter", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType6);
		}
		
		else if(searchData.testCaseId.equals("TC_VSA_002")){
			assertTrue(click(selenium, btnAddNewCriteria1), "Could not click on Add New button for Match One or More Filter", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType6);
		}
		else if(searchData.testCaseId.equals("TC_VSA_001")){
			assertTrue(click(selenium, lnkNewSearch), "Could not click on Add New button for Match All Filter", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox",searchData.searchType6);
		}
		
		waitForPageLoad(selenium);
		if(account.equals(CAAccount)){
			selectValueFromAjaxList(selenium,ajxSearchTypeMediCondition,searchData.medicalConditionCA);
		}else
		selectValueFromAjaxList(selenium,ajxSearchTypeMediCondition,searchData.medical);
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium,ajxTimeCondtion3,searchData.timeCondition4);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnSearchClinicalList),"Could not click on search button:", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		possition = possition+1;
		searchData.currentValue = String.valueOf(possition);
		return true;
	}
	
	/**
	 * unitTestForMatchAll
	 * Function to verify unit test for Match All Filter
	 * @param selenium
	 * @param matchAllData
	 * @since Nov 27, 2012
	 */
	
	
	
	public boolean unitTestForMatchAll(Selenium selenium, ClinicalListLibUnitTest matchAllData, int possition){
		boolean returnValue = false;
		try{
			selectValueFromAjaxList(selenium, String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox", matchAllData.searchType);
			if(matchAllData.testCaseId.equals("TC_UMA_001"))
				type(selenium,String.valueOf(possition)+"andsearchTypeSuggestBoxsuggestBoxsuggestBox", matchAllData.searchType);
			if(matchAllData.searchType.equalsIgnoreCase("Age is")){
				selectValueFromAjaxList(selenium, String.valueOf(possition)+"anddurationConditionSuggestBoxsuggestBoxsuggestBox", matchAllData.durationCondition);
				if(matchAllData.durationCondition.equalsIgnoreCase("between")){
					assertTrue(type(selenium, String.valueOf(possition)+"anddurationIntegerMinTextBox", matchAllData.minYear), "Could not enter minimum year", selenium, ClassName,MethodName);
					assertTrue(type(selenium, String.valueOf(possition)+"anddurationIntegerMaxTextBox", matchAllData.maxYear), "Could not enter maximum year", selenium, ClassName,MethodName);
				}else{
					assertTrue(type(selenium, String.valueOf(possition)+"anddurationIntegerMaxTextBox", matchAllData.maxYear), "Could not enter the year", selenium, ClassName,MethodName);
				}
			}else if(matchAllData.searchType.equalsIgnoreCase("Sex is")){
				type(selenium,ajxSearchCondtion,matchAllData.sex);
				
			}else if(matchAllData.searchType.equalsIgnoreCase("Problem is")){
				selectValueFromAjaxList(selenium,ajxProblemList,matchAllData.diagnosis);
				selectValueFromAjaxList(selenium,ajxtimeCondtion,matchAllData.timeCondition);
				if(matchAllData.testCaseId.equals("TC_UMA_026")||matchAllData.testCaseId.equals("TC_UMA_027")||matchAllData.testCaseId.equals("TC_UMA_028")||matchAllData.testCaseId.equals("TC_UMA_029"))
					type(selenium,ajxtimeCondtion,matchAllData.timeCondition);
			
			}else if(matchAllData.searchType.equalsIgnoreCase("Allergic to")){
				selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,matchAllData.allergen);
				selectValueFromAjaxList(selenium,ajxtimeCondtion,matchAllData.timeCondition);
				if(matchAllData.timeCondition.equalsIgnoreCase("within the last")){
					assertTrue(type(selenium, txtPeriodNumber1, matchAllData.periodNumber), "Could not type period number", selenium, ClassName,MethodName);
					selectValueFromAjaxList(selenium, ajxPeriodCondition, matchAllData.period);
					if(matchAllData.testCaseId.equals("TC_UMA_050")||matchAllData.testCaseId.equals("TC_UMA_051")||matchAllData.testCaseId.equals("TC_UMA_052")||matchAllData.testCaseId.equals("TC_UMA_053")){
						type(selenium,ajxPeriodCondition,matchAllData.period);
					}
				}
				if(matchAllData.timeCondition.equalsIgnoreCase("after this date")){
					assertTrue(enterDate(selenium, txtLabDate, matchAllData.date), "Could not enter the date", selenium, ClassName,MethodName);
				}
			}else if(matchAllData.searchType.equalsIgnoreCase("Lab result is")){
				selectValueFromAjaxList(selenium,ajxLabResult,matchAllData.labResult);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"anddurationConditionSuggestBoxsuggestBoxsuggestBox",matchAllData.durationCondition);
				assertTrue(type(selenium, txtLabResult1, matchAllData.maxYear), "Could not type period number", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxtimeCondtion,matchAllData.timeCondition);
			}
			else if(matchAllData.searchType.equalsIgnoreCase("Medication is")){
				selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,matchAllData.medication);
				selectValueFromAjaxList(selenium,ajxtimeCondtion,matchAllData.timeCondition);
			}else{
				selectValueFromAjaxList(selenium, String.valueOf(possition)+"anddurationConditionSuggestBoxsuggestBoxsuggestBox", matchAllData.durationCondition);
				type(selenium, String.valueOf(possition)+"anddurationIntegerMaxTextBox", matchAllData.maxYear);
			}
			if(matchAllData.testCaseId.equals("TC_UMA_006")||matchAllData.testCaseId.equals("TC_UMA_007")||matchAllData.testCaseId.equals("TC_UMA_008")||matchAllData.testCaseId.equals("TC_UMA_005"))
				type(selenium,String.valueOf(possition)+"anddurationConditionSuggestBoxsuggestBoxsuggestBox",matchAllData.durationCondition);
			if(!matchAllData.testCaseId.equals("TC_UMA_037")){
				assertTrue(click(selenium, btnSaveButton), "Could not click on seach button", selenium, ClassName,MethodName);
			}
			waitForPageLoad(selenium);
			returnValue = true;
		}
		catch(RuntimeException e){
			e.printStackTrace();
			returnValue = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnValue=false;
		}
		return returnValue;
	}

	/**
	 * unitTestForMatchOneOrMore
	 * Function to verify unit test for Match one or more Filter
	 * @param selenium
	 * @param matchOneOrMoreData
	 * @since Nov 27, 2012
	 */
	
	public boolean unitTestForMatchOneOrMore(Selenium selenium, ClinicalListLibUnitTest matchOneOrMoreData, String possition){
		boolean returnValue = false;
		try{
			selectValueFromAjaxList(selenium, String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox", matchOneOrMoreData.searchType);
			if(matchOneOrMoreData.testCaseId.equals("TC_MOM_001"))
				type(selenium, String.valueOf(possition)+"orsearchTypeSuggestBoxsuggestBoxsuggestBox", matchOneOrMoreData.searchType);
			if(matchOneOrMoreData.searchType.equalsIgnoreCase("Age is")){
				selectValueFromAjaxList(selenium, String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox", matchOneOrMoreData.durationCondition);
				if(matchOneOrMoreData.durationCondition.equalsIgnoreCase("between")){
					assertTrue(type(selenium, String.valueOf(possition)+"ordurationIntegerMinTextBox", matchOneOrMoreData.minYear), "Could not enter minimum year", selenium, ClassName,MethodName);
					assertTrue(type(selenium, String.valueOf(possition)+"ordurationIntegerMaxTextBox", matchOneOrMoreData.maxYear), "Could not enter maximum year", selenium, ClassName,MethodName);
				}else if(matchOneOrMoreData.durationCondition.equalsIgnoreCase("less than")){
					type(selenium,String.valueOf(possition)+"ordurationIntegerMaxTextBox" , matchOneOrMoreData.maxYear);
				}
				else{
					type(selenium,String.valueOf(possition)+"ordurationIntegerMinTextBox" , matchOneOrMoreData.maxYear);
				}
			}
			else if(matchOneOrMoreData.searchType.equalsIgnoreCase("Sex is")){
				assertTrue(type(selenium, ajxSearchCondtion, matchOneOrMoreData.sex), "Could not type the type", selenium, ClassName,MethodName);
			}
			else if(matchOneOrMoreData.searchType.equalsIgnoreCase("Problem is")){
				selectValueFromAjaxList(selenium,ajxProblemList,matchOneOrMoreData.diagnosis);
				selectValueFromAjaxList(selenium,ajxtimeCondtion,matchOneOrMoreData.timeCondition);
				if(matchOneOrMoreData.testCaseId.equals("TC_MOM_026")||matchOneOrMoreData.testCaseId.equals("TC_MOM_027")||matchOneOrMoreData.testCaseId.equals("TC_MOM_028")||matchOneOrMoreData.testCaseId.equals("TC_MOM_029"))
					type(selenium,ajxtimeCondtion,matchOneOrMoreData.timeCondition);
			}
			else if(matchOneOrMoreData.searchType.equalsIgnoreCase("Allergic to")){
				selectValueFromAjaxList(selenium,ajxAllergyBox,matchOneOrMoreData.allergen);
				selectValueFromAjaxList(selenium,ajxtimeCondtion,matchOneOrMoreData.timeCondition);
				if(matchOneOrMoreData.timeCondition.equalsIgnoreCase("within the last")){
					assertTrue(type(selenium, txtPeriodNumber1, matchOneOrMoreData.periodNumber), "Could not type period number", selenium, ClassName,MethodName);
					selectValueFromAjaxList(selenium, ajxPeriodCondition, matchOneOrMoreData.period);
					if(matchOneOrMoreData.testCaseId.equalsIgnoreCase("TC_MOM_037")){
						selenium.typeKeys(txtPeriodNumber1, "9");

					}
					if(matchOneOrMoreData.testCaseId.equals("TC_MOM_050")||matchOneOrMoreData.testCaseId.equals("TC_MOM_051")||matchOneOrMoreData.testCaseId.equals("TC_MOM_052")||matchOneOrMoreData.testCaseId.equals("TC_MOM_053"))
					{
						type(selenium,ajxPeriodCondition,matchOneOrMoreData.period);
					}
				}
				if(matchOneOrMoreData.timeCondition.equalsIgnoreCase("after this date")){
					assertTrue(enterDate(selenium, txtLabDate, matchOneOrMoreData.date), "Could not enter the date", selenium, ClassName,MethodName);
				}
			}else if(matchOneOrMoreData.searchType.equalsIgnoreCase("Lab result is")){
				selectValueFromAjaxList(selenium,ajxLabResult,matchOneOrMoreData.labResult);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox",matchOneOrMoreData.durationCondition);
				assertTrue(type(selenium, txtLabResult1, matchOneOrMoreData.count), "Could not type period number", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox",matchOneOrMoreData.timeCondition);
			}else if(matchOneOrMoreData.searchType.equalsIgnoreCase("Medication is")){
				selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,matchOneOrMoreData.medication);
				selectValueFromAjaxList(selenium,ajxtimeCondtion,matchOneOrMoreData.timeCondition);
			}
			else{
				selectValueFromAjaxList(selenium, String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox", matchOneOrMoreData.durationCondition);
				type(selenium, String.valueOf(possition)+"ordurationIntegerMaxTextBox", matchOneOrMoreData.maxYear);
			}
			if(matchOneOrMoreData.testCaseId.equals("TC_MOM_006")||matchOneOrMoreData.testCaseId.equals("TC_MOM_007")||matchOneOrMoreData.testCaseId.equals("TC_MOM_008")||matchOneOrMoreData.testCaseId.equals("TC_MOM_005"))
				type(selenium,String.valueOf(possition)+"ordurationConditionSuggestBoxsuggestBoxsuggestBox",matchOneOrMoreData.durationCondition);
			if(!matchOneOrMoreData.testCaseId.equalsIgnoreCase("TC_MOM_037")){
			assertTrue(click(selenium, btnSaveButton), "Could not click on seach button", selenium, ClassName,MethodName);
			}
			waitForPageLoad(selenium);
			returnValue = true;
		}
		catch(RuntimeException e){
			e.printStackTrace();
			returnValue = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnValue=false;
		}
		return returnValue;
	}
	
	/**
	 * unitTestForDoNotInclude
	 * Function to verify unit test for Match Do not Include Filter
	 * @param selenium
	 * @param doNotIncludeData
	 * @since Nov 27, 2012
	 */
	
	public boolean unitTestForDoNotInclude(Selenium selenium, ClinicalListLibUnitTest doNotIncludeData, int possition){
		boolean returnValue = false;
		try{
			selectValueFromAjaxList(selenium, String.valueOf(possition)+"excludesearchTypeSuggestBoxsuggestBoxsuggestBox", doNotIncludeData.searchType);
			if(doNotIncludeData.searchType.equalsIgnoreCase("Age is")){
				selectValueFromAjaxList(selenium, String.valueOf(possition)+"excludedurationConditionSuggestBoxsuggestBoxsuggestBox", doNotIncludeData.durationCondition);
				if(doNotIncludeData.durationCondition.equalsIgnoreCase("between")){
					assertTrue(type(selenium, String.valueOf(possition)+"excludedurationIntegerMinTextBox", doNotIncludeData.minYear), "Could not enter minimum year", selenium, ClassName,MethodName);
					assertTrue(type(selenium, String.valueOf(possition)+"excludedurationIntegerMaxTextBox", doNotIncludeData.maxYear), "Could not enter maximum year", selenium, ClassName,MethodName);
				}
				else if(doNotIncludeData.durationCondition.equalsIgnoreCase("less than")){
					type(selenium, String.valueOf(possition)+"excludedurationIntegerMaxTextBox", doNotIncludeData.maxYear);
				}else{
					type(selenium, String.valueOf(possition)+"excludedurationIntegerMinTextBox", doNotIncludeData.maxYear);
				}
			}
			else if(doNotIncludeData.searchType.equalsIgnoreCase("Sex is")){
				type(selenium,ajxSearchCondtion,doNotIncludeData.sex);
			}
			else if(doNotIncludeData.searchType.equalsIgnoreCase("Problem is")){
				selectValueFromAjaxList(selenium,ajxProblemList,doNotIncludeData.diagnosis);
				selectValueFromAjaxList(selenium,ajxtimeCondtion,doNotIncludeData.timeCondition);
			}
			
			else if(doNotIncludeData.searchType.equalsIgnoreCase("Allergic to")){
				selectValueFromAjaxList(selenium,ajxAllergyBox,doNotIncludeData.allergen);
				selectValueFromAjaxList(selenium,ajxtimeCondtion,doNotIncludeData.timeCondition);
				if(doNotIncludeData.timeCondition.equalsIgnoreCase("within the last")){
					assertTrue(type(selenium, txtPeriodNumber1, doNotIncludeData.periodNumber), "Could not type period number", selenium, ClassName,MethodName);
					if(doNotIncludeData.testCaseId.equalsIgnoreCase("TC_DNI_037")){
						selenium.typeKeys(txtPeriodNumber1, "9");
					}
					if(!doNotIncludeData.testCaseId.equalsIgnoreCase("TC_DNI_037")){
						selectValueFromAjaxList(selenium, ajxPeriodCondition, doNotIncludeData.period);
					}
				}
				if(doNotIncludeData.timeCondition.equalsIgnoreCase("after this date")){
					assertTrue(enterDate(selenium, txtLabDate, doNotIncludeData.date), "Could not enter the date", selenium, ClassName,MethodName);
				}
			}
			else if(doNotIncludeData.searchType.equalsIgnoreCase("Lab result is")){
				selectValueFromAjaxList(selenium,ajxLabResult,doNotIncludeData.labResult);
				selectValueFromAjaxList(selenium,String.valueOf(possition)+"excludedurationConditionSuggestBoxsuggestBoxsuggestBox",doNotIncludeData.durationCondition);
				assertTrue(type(selenium, txtLabResult1, doNotIncludeData.count), "Could not type period number", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxtimeCondtion,doNotIncludeData.timeCondition);
			}
			else if(doNotIncludeData.searchType.equalsIgnoreCase("Medication is")){
				selectValueFromAjaxList(selenium,ajxMedicationNameSuggestBox,doNotIncludeData.medication);
				selectValueFromAjaxList(selenium,ajxtimeCondtion,doNotIncludeData.timeCondition);
			}
			else{
				selectValueFromAjaxList(selenium, String.valueOf(possition)+"excludedurationConditionSuggestBoxsuggestBoxsuggestBox", doNotIncludeData.durationCondition);
				type(selenium, String.valueOf(possition)+"excludedurationIntegerMaxTextBox", doNotIncludeData.maxYear);
			}
			if(doNotIncludeData.testCaseId.equals("TC_DNI_006")||doNotIncludeData.testCaseId.equals("TC_DNI_007")||doNotIncludeData.testCaseId.equals("TC_DNI_008")||doNotIncludeData.testCaseId.equals("TC_DNI_005"))
				type(selenium,String.valueOf(possition)+"excludedurationConditionSuggestBoxsuggestBoxsuggestBox",doNotIncludeData.durationCondition);
			if(!doNotIncludeData.testCaseId.equalsIgnoreCase("TC_DNI_037")){
				assertTrue(click(selenium, btnSaveButton), "Could not click on seach button", selenium, ClassName,MethodName);
			}
			waitForPageLoad(selenium);
			returnValue = true;
		}
		catch(RuntimeException e){
			e.printStackTrace();
			returnValue = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnValue=false;
		}
		return returnValue;
	}

	
	/**
	 * createNewPatient
	 * function to create New Patient
	 * @since  	Dec 21, 2012
	 */	

	public boolean createNewPatient(Selenium selenium, ClinicalListLib patientData, String account){
		try{
			String dob = null;
			selectValueFromAjaxList(selenium,ajxPrimaryLoc,patientData.primaryLocation);
			selectValueFromAjaxList(selenium,ajxResProvider,patientData.responsibleProvider);
			assertTrue(type(selenium,txtLastName,patientData.lastName),"Could not enter the last name;More Details"+patientData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,txtFirstName,patientData.firstName),"Could not enter the last name;More Details"+patientData.toString(), selenium, ClassName,MethodName);
			if(account.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				dob=DateFormat.format(cal.getTime());
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				dob=DateFormat.format(cal.getTime());
			}
			assertTrue(enterDate(selenium,txtDob,dob),"Could not enter date; More Details:"+patientData.toString(), selenium, ClassName,MethodName);
			click(selenium,btnClinicalBack);
			selectValueFromAjaxList(selenium,ajxSexSuggestBox,patientData.sex);
			selectValueFromAjaxList(selenium,ajxCommType,patientData.telephoneType1);
			assertTrue(type(selenium,txtPrimaryPhone,patientData.telephoneNo1),"Could not Enter telephone Number, Expected value to be Typed" + patientData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,txtPrimaryPhoneextn,patientData.telephoneextnNo1),"Could not Enter telephone Exten Number; More Details"+patientData.toString(), selenium, ClassName,MethodName);
			click(selenium,btnClinicalSave);
			waitForPageLoad(selenium);
			return true;	
		
		
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * goToClinicalQualityMeasures
	 * Function to go to Meaningful Use Measures
	 * @since  	Dec 24, 2012
	 */
	public boolean goToClinicalQualityMeasures(Selenium selenium){
		try {
			assertTrue(click(selenium, lnkQuickActions), "Could not click on Quick Actions", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnclinicalListsAction), "Could not click on Clinical List", selenium, ClassName,MethodName);
			assertTrue(click(selenium, lnkClinicalQualityMeasures), "Could not click on Clinical lists", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * clickDiIcon
	 * Function for delete All existing encounters
	 * @param selenium
	 * @param prescribeData
	 * @return
	 * @since Jan 24,2013
	 */
	public boolean clickEditMeasure(Selenium selenium ,ClinicalListLib prescribeData){
		
		try{
			int i=0;
			waitForPageLoad(selenium);
			selenium.focus(btnSaveInCqm);
			selenium.clickAt(btnSaveInCqm, "");
			//Assert.assertTrue(click(selenium,"//img[@title='Order New Labs']"),"Could not click on lab order link");
			waitForPageLoad(selenium);
			
			while(isElementPresent(selenium,btnSaveInCqm)){
				
				click(selenium,btnSaveInCqm);
				if(isElementPresent(selenium,btnSaveInCqm)){
					return true;
				}
				else 
					i++;
				if(i>10){
					break;
				}
				
			}		
		}
		catch(RuntimeException e){
			e.printStackTrace();
		}
		return true;
		}
	
	
	/**
	 * VerifyErrorPresent
	 * Function to verify the presence of error and Capture Screenshot
	 * 
	 * @since May 28,2013
	 */	
	
  public void verifyErrorPresent(Selenium selenium, String ClassName, String MethodName) throws IOException {
		
		waitForPageLoad(selenium);	
			   
		if (selenium.isTextPresent("An error has occurred")) {
			
			//--------------------------------------------------------------------//
			//  Create Capture Screenshot Directory, If not Present				  //
			//--------------------------------------------------------------------//
						
			File theDir = new File("C:\\screenshot3\\");

			  // if the directory does not exist, create it
			  if (!theDir.exists())
			  {
			    System.out.println("creating directory: " + theDir);
			    boolean result = theDir.mkdir();  
			    if(result){    
			       System.out.println(theDir + " DIR created");  
			     }

			  }
			  
			//--------------------------------------------------------------------//
			//  Capture Screenshot												  // 
			//--------------------------------------------------------------------// 
			  			
			String failureImageFileName = ClassName + "_" + MethodName  + "_"+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime())
	                + ".png";		
			selenium.captureScreenshot(theDir + "\\" + failureImageFileName);
		   			
			Assert.fail("An error has occurred. Please try to resolve it");
	    }

	}
	

	/**
	 * checkAllMeasures
	 * Function to check all Measures
	 *  @since  	Dec 24, 2012
	 */
	public boolean checkAllMeasures(Selenium selenium,ClinicalListLib muData){
		
		try {
			assertTrue(click(selenium, btnSaveButton), "Could not click on Edit quality measures button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		if(!isChecked(selenium,chkMetric))
			assertTrue(click(selenium, chkMetric), "Could not click on check box", selenium, ClassName,MethodName);
		if(!isChecked(selenium,chkMetric2))
			assertTrue(click(selenium, chkMetric2), "Could not click on check box", selenium, ClassName,MethodName);
		if(!isChecked(selenium,chkMetric3))
			assertTrue(click(selenium, chkMetric3), "Could not click on check box", selenium, ClassName,MethodName);
		if(!isChecked(selenium,chkMetric4))
			assertTrue(click(selenium, chkMetric4), "Could not click on check box", selenium, ClassName,MethodName);
		if(!isChecked(selenium,chkMetric5))
			assertTrue(click(selenium, chkMetric5), "Could not click on check box", selenium, ClassName,MethodName);
		if(!isChecked(selenium,chkMetric6))
			assertTrue(click(selenium, chkMetric6), "Could not click on check box", selenium, ClassName,MethodName);
		if(!isChecked(selenium,chkMetric7))
			assertTrue(click(selenium, chkMetric7), "Could not click on check box", selenium, ClassName,MethodName);
		if(!isChecked(selenium,chkMetric8))
			assertTrue(click(selenium, chkMetric8), "Could not click on check box", selenium, ClassName,MethodName);
		if(!isChecked(selenium,chkMetric9))
			assertTrue(click(selenium, chkMetric9), "Could not click on check box", selenium, ClassName,MethodName);
		if(!isChecked(selenium,chkMetric10))
			assertTrue(click(selenium, chkMetric10), "Could not click on check box", selenium, ClassName,MethodName);
		if(!isChecked(selenium,chkMetric11))
			assertTrue(click(selenium, chkMetric11), "Could not click on check box", selenium, ClassName,MethodName);
		if(muData.testCaseId.equalsIgnoreCase("TC_CQM_014")){
			assertTrue(click(selenium, btnCqmCancel), "Could not click on cancel button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		else{
			assertTrue(click(selenium, btnSaveButton), "Could not click on save button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	
	/**
	 * verifyMeasure
	 * Test for verify result
	 * @param selenium
	 * @param muData
	 * @since Nov 30, 2012
	 */
	public boolean verifyMeasure(Selenium selenium, ClinicalListLib muData){
		boolean returnValue = true;
		try{
			selectValueFromAjaxList(selenium, ajxProvider, muData.provider);
			assertTrue(enterDate(selenium, txtFromDate, muData.fromDate), "Could not enter show result from date", selenium, ClassName,MethodName);
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
			String date1 = date.format(cal.getTime());
			if(muData.testCaseId.equals("TC_CQM_016")){
				assertTrue(enterDate(selenium, txtCqmDate1, date1), "Could not enter show result to date", selenium, ClassName,MethodName);
			}
			else assertTrue(enterDate(selenium, txtCqmDate1, date1), "Could not enter show result to date", selenium, ClassName,MethodName);
			assertTrue(click(selenium, btnUpdateResults), "Could not click on update results", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			returnValue = true;
		}
		catch(RuntimeException e){
			e.printStackTrace();
			returnValue = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnValue=false;
		}
		return returnValue;
	}


	/**
	 * editMeasure
	 * Test for verify result
	 * @param selenium
	 * @param muData
	 * @since Nov 30, 2012
	 */
	public boolean editMeasure(Selenium selenium,ClinicalListLib cqmData){
		boolean returnValue = true;
		try{
			assertTrue(click(selenium, btnEditQuality), "Could not click on edit button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			unCheckAll(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, cqmData.checkBox), "Could not click on metric check box", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnsave), "Could not click on edit button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			returnValue = true;
		}
		catch(RuntimeException e){
			e.printStackTrace();
			returnValue = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}


	/**
	 * createManageCareAlerts
	 * Test for create Manage CareAlerts
	 * @param selenium
	 * @param muData
	 * @since Oct 23, 2013
	 */
	
	public boolean createManageCareAlerts(Selenium selenium,ClinicalListLib alertData,String date){
		boolean returnValue = true;
		try{
			if(!isChecked(selenium,chkManageCare))
			assertTrue(click(selenium,chkManageCare),"Could not click the chk box ManageCare", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(enterDate(selenium,txtDueDate,date), "Could not enter due Date", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtRecurring,alertData.recurringPeriod), "Could not type Recurring period", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxOccurrenceUnitSuggestBox,alertData.recurringUnit), "Could not type Recurring unit ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtAddReason,alertData.reason), "Could not type Reason", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(alertData.testCaseId.equals("TC_MCA_005")){
    			assertTrue(click(selenium, btnCancelAlert1), "Could not click on cancel button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}else{
			assertTrue(click(selenium, btnsave), "Could not click on save button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			}
			
			returnValue = true;
		
		}
		catch(RuntimeException e){
			e.printStackTrace();
			returnValue = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}
	
	/**
	 * 
	 * Test for create Manage Automated Task
	 * @param selenium
	 * @param muData
	 * @since Oct 26, 2013
	 */
	
	public boolean createManageAutomatedTask(Selenium selenium,ClinicalListLib alertData,String date,String  providerName){
		boolean returnValue = true;
		try{
		
			assertTrue(type(selenium,txtTaskReasonName,alertData.reason), "Could not type task reason name", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		
			
			assertTrue(selectValueFromAjaxList(selenium,ajxAssignUser,providerName), "Could not select assign user ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxDueIn,alertData.recurringPeriod), "Could not select due date ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxDueInUnit,alertData.recurringUnit), "Could not select due period unit", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		
			
			assertTrue(click(selenium, chkSaveListBox1), "Could not click on Quick list  button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPreviewRecall),"Could not click on link Preview", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(alertData.testCaseId.equals("TC_MCA_008")){
				assertTrue(click(selenium,btnCancelId),"Could not click on cancel button ", selenium, ClassName,MethodName);
		       waitForPageLoad(selenium);
		
			}else{
			
			assertTrue(click(selenium,btnSave),"Could not click on save button ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
		}		
			returnValue = true;
		
		}
		catch(RuntimeException e){
			e.printStackTrace();
			returnValue = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}
	
	/**
	 * 
	 *  UnitTest For AutomatedRecall
	 * @param selenium
	 * @param muData
	 * @since Oct 26, 2013
	 */
	
	public boolean UnitTestForAutomatedRecall(Selenium selenium,ClinicalListLibUnitTest alertData,String date){
		boolean returnValue = true;
		try{
		
			assertTrue(type(selenium,txtTaskReasonName,alertData.taskName), "Could not type task reason name", selenium, ClassName,MethodName);
		    waitForPageLoad(selenium);
			
			assertTrue(selectValueFromajxListForUnit(selenium,ajxAssignUser,alertData.assignTo), "Could not select assign user ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(selectValueFromajxListForUnit(selenium,ajxDueIn,alertData.assignTaskDate), "Could not select due date ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromajxListForUnit(selenium,ajxDueInUnit,alertData.assignTaskUnit), "Could not select due period unit", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
						
			assertTrue(click(selenium,lnkPreviewRecall),"Could not click on link Preview", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
						
			returnValue = true;
		
		}
		catch(RuntimeException e){
			e.printStackTrace();
			returnValue = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}
	

	/**
	 * gotoManageCareAlerts
	 * Test for create Manage CareAlerts
	 * @param selenium
	 * @param muData
	 * @since Oct 23, 2013
	 */
	public boolean gotoManageCareAlerts(Selenium selenium){
		
			try {
				assertTrue(isElementPresent(selenium,lnkPatientOption),"Could not find patiet option  link", selenium, ClassName,MethodName);
			
				assertTrue(click(selenium,lnkPatientOption),"Could not click the link", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,lnkManageCare),"Could not find tlnkManageCare link", selenium, ClassName,MethodName);
				assertTrue(click(selenium,lnkManageCare),"Could not select lnkManageCare ", selenium, ClassName,MethodName);
				if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		
	}
	

	/**
	 * DeleteManageCareAlerts
	 * Test for Delete Manage CareAlerts
	 * @param selenium
	 * @param muData
	 * @since Oct 23, 2013
	 */
	
	
	public boolean deleteManageCareAlerts(Selenium selenium,ClinicalListLib alertData){
		waitForPageLoad(selenium);
		try {
			 if(isChecked(selenium,chkManageCare))
			
					assertTrue(click(selenium,chkManageCare),"Could not click the chk box ManageCare", selenium, ClassName,MethodName);
				
			    waitForPageLoad(selenium);
				assertTrue(type(selenium,txtDeleteReason,alertData.deleteReason), "Could not type Delete Reason", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnSave2), "Could not click on save button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium, btnsave), "Could not click on save button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	}

	
	
	/**
	 * unCheckAll
	 * Test for verify result
	 * @param selenium
	 * @param muData
	 * @since Nov 30, 2012
	 */
	public boolean unCheckAll(Selenium selenium){
		boolean returnValue = true;
		try{
			if(isChecked(selenium,lblCQM1)){
			click(selenium,lblCQM1);
			}
			if(isChecked(selenium,lblCQM2)){
			click(selenium,lblCQM2);
			}
			if(isChecked(selenium,lblCQM3)){
			click(selenium,lblCQM3);
			}
			if(isChecked(selenium,lblCQM4)){
			click(selenium,lblCQM4);
			}
			if(isChecked(selenium,lblCQM5)){
			click(selenium,lblCQM5);
			}
			if(isChecked(selenium,lblCQM6)){
			click(selenium,lblCQM6);
			}
			if(isChecked(selenium,lblCQM7)){
			click(selenium,lblCQM7);
			}
			if(isChecked(selenium,lblCQM8)){
			click(selenium,lblCQM8);
			}
			if(isChecked(selenium,lblCQM9)){
			click(selenium,lblCQM9);
			}
			if(isChecked(selenium,lblCQM10)){
			click(selenium,lblCQM10);
			}
			if(isChecked(selenium,lblCQM11)){
			click(selenium,lblCQM11);
			}

			returnValue = true;
		}
		catch(RuntimeException e){
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}
	
	/**
	 * createProcedure
	 * function to create Procedure
	 * @since  	Sep 28, 2012
	 */	
	
	public boolean createProcedure(Selenium selenium,ChartPreVisitLib proData){
		try{
			
			assertTrue(type(selenium,txtProcedurename,proData.proName),"Could not on show more button", selenium, ClassName,MethodName);
			
			assertTrue(enterDate(selenium,txtprocedureDate,proData.proDate),"Could not enter the Admin on ;More Details:"+proData.toString(), selenium, ClassName,MethodName);
			assertTrue(click(selenium,lnkshowMoreDetails_Procedure),"Could not on show more button", selenium, ClassName,MethodName);
		
			assertTrue(enterDate(selenium,txtonSetDate,proData.onsetDate),"Could not enter the Admin on ;More Details:"+proData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,ajxProcpt,proData.cpt);
			waitForPageLoad(selenium);
			if(proData.testCaseId.equals("TC_CP_034")||proData.testCaseId.equals("TC_CP_035")||proData.testCaseId.equals("TC_CP_036")){
			click(selenium,"xpath=(//button[@type='button'])[13]");
			selectValueFromAjaxList(selenium,"cptSuggestBox0-2suggestBox","90700 - DIPHTHERIA, TETANUS TOXOIDS, AND ACELLULAR PERTUSSIS VACCINE (DTAP), WHEN ADMINISTERED TO INDIVIDUALS YOUNGER THAN 7 YEARS, FOR INTRAMUSCULAR USE");
			}
			if(proData.testCaseId.equals("TC_CP_037")||proData.testCaseId.equals("TC_CP_038")||proData.testCaseId.equals("TC_CP_039")){
				click(selenium,"xpath=(//button[@type='button'])[13]");
				selectValueFromAjaxList(selenium,"cptSuggestBox0-2suggestBox","90723 - DIPHTHERIA, TETANUS TOXOIDS, ACELLULAR PERTUSSIS VACCINE, HEPATITIS B, AND POLIOVIRUS VACCINE, INACTIVATED (DTAP-HEPB-IPV), FOR INTRAMUSCULAR USE");
				}
			if(proData.testCaseId.equals("TC_CP_040")){
				click(selenium,"xpath=(//button[@type='button'])[13]");
				selectValueFromAjaxList(selenium,"cptSuggestBox0-2suggestBox","90709 - Rubella and mumps virus vaccine, live, for subcutaneous use");
				}
			if(proData.testCaseId.equals("TC_CP_042")){
				click(selenium,"xpath=(//button[@type='button'])[13]");
				selectValueFromAjaxList(selenium,"cptSuggestBox0-2suggestBox","90681 - ROTAVIRUS VACCINE, HUMAN, ATTENUATED, 2 DOSE SCHEDULE, LIVE, FOR ORAL USE");
				}
			if(proData.testCaseId.equals("TC_CP_044")||proData.testCaseId.equals("TC_CP_043")){
				click(selenium,"xpath=(//button[@type='button'])[13]");
				selectValueFromAjaxList(selenium,"cptSuggestBox0-2suggestBox","90662 - INFLUENZA VIRUS VACCINE, SPLIT VIRUS, PRESERVATIVE FREE, ENHANCED IMMUNOGENICITY VIA INCREASED ANTIGEN CONTENT, FOR INTRAMUSCULAR USE");
				}
			if(proData.testCaseId.equals("TC_CP_049")||proData.testCaseId.equals("TC_CP_050")||proData.testCaseId.equals("TC_CP_051")){
				click(selenium,"xpath=(//button[@type='button'])[13]");
				selectValueFromAjaxList(selenium,"cptSuggestBox0-2suggestBox","90646 - HEMOPHILUS INFLUENZA B VACCINE (HIB), PRP-D CONJUGATE, FOR BOOSTER USE ONLY, INTRAMUSCULAR USE");
				}
			if(isElementPresent(selenium,ajxOption2)){
				click(selenium,ajxOption2);
			}else if(isElementPresent(selenium,ajxMedsQuickCa)){
			click(selenium,ajxMedsQuickCa);
			}
			assertTrue(type(selenium,txtProcomment,proData.comment),"Could not enter the comment;More Details:"+proData.toString(), selenium, ClassName,MethodName);
			assertTrue(click(selenium,btnProadd),"Could not click the add button;More details:"+proData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				return true;
			
		
			}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		return false;
	}

	
	/**
	 * addEncounterVitals
	 * Function to create a Encounter Vitals
	 * @since	Dec 21, 2012
	 */
	public boolean addEncounterVitals(Selenium selenium, ChartPreVisitLib vitalsData){
		
		try{
			
			//Assert.assertTrue(type(selenium, txtAgeMatch1,vitalsData.heightInFeet), "Could not type Hight in feet");
			selectValueFromAjaxList(selenium, ajxHeight, vitalsData.heightMU);
			type(selenium, txtHeightInFeet,vitalsData.heightInFeet);
			assertTrue(type(selenium, txtHeightIn,vitalsData.heightInCm), "Could not type Hight in inches", selenium, ClassName,MethodName);
			
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxWeight, vitalsData.weightMU);
			assertTrue(type(selenium, txtWeight, vitalsData.weight), "Could not type weight", selenium, ClassName,MethodName);
			assertTrue(type(selenium, txtSystolic, vitalsData.systolicRate), "Could not type systolic Rate", selenium, ClassName,MethodName);
			assertTrue(type(selenium, txtdiastolic, vitalsData.diastolicRate), "Could not type diastolic Rate", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium, ajxPosition, vitalsData.position);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxLimb, vitalsData.limb);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxCuffsize, vitalsData.cuffSize);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtheartRate, vitalsData.bPM), "Could not type Heart Rate", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium, ajxdescription, vitalsData.description);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxrhythm, vitalsData.rhythm);
			waitForPageLoad(selenium);
			if(!(vitalsData.testCaseId.equalsIgnoreCase("TC_CV_001"))){
				if(getText(selenium,btnShowMore).contains("Show more details"))
					assertTrue(click(selenium, btnShowMore), "Could not click on show more details", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtwaist, vitalsData.waist), "Could not type waist", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium, ajxWaist, vitalsData.waistMU);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtTemp, vitalsData.temperature), "Could not type temperature", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium, ajxTempUnit, vitalsData.tempRU);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxTempLocation, vitalsData.location);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtBloodSugar, vitalsData.bloodSuger), "Could not type blood sugar", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium, ajxBloodSugar, vitalsData.bSUnit);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtRespiratory, vitalsData.repositoryRate), "Could not type blood sugar", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium, ajxRespiratory, vitalsData.rR_BPM);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtOxygen1, vitalsData.oxygenSaturation), "Could not type oxygen saturation", selenium, ClassName,MethodName);
				assertTrue(type(selenium, txtRefill1, vitalsData.pEFR), "Could not type pefr", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium, ajxPefr, vitalsData.pre_bronchodilator);
				waitForPageLoad(selenium);
			}
			
			assertTrue(click(selenium,btnAdd1 ), "Could not click on add button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			return true;
		}
		catch(RuntimeException e){
			Assert.fail("Failed due to the Exception; \n Exception details: "+e.getMessage());
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * connectPostgres
	 * Function to connect with postgres db
	 * @param selenium
	 */
	public int connectPostgres(int metricResult, ClinicalSettingLib muData){

		try {
			 Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
		System.out.println("Where is your PostgreSQL JDBC Driver?"+ "Include in your library path!");
			e.printStackTrace();
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
		float numerator,denominator;
		
		try {
			Connection connection=null;
			connection = DriverManager.getConnection("jdbc:postgresql://"+url+":"+port+"/"+database,dbusername,dbpwd);
			
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
	 * createNewPatientForCqm
	 * function to create New Patient With Mandatory
	 * @since  	 Jan 07, 2013
	 */	
	public boolean createNewPatientForCqm(Selenium selenium, ClinicalListLib patientData){
		boolean returnValue = false;
		try{
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lnkContinue)){
				click(selenium, lnkContinue);
			}
			assertTrue(type(selenium,txtLastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,txtFirstName,patientData.firstName),"Could not type the first Name : More Details"+patientData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,ajxStuasSuggest,patientData.status);
			selectValueFromAjaxList(selenium,ajxSexSuggestBox,patientData.sex);
			if(patientData.testCaseId.equals("TC_CQM_020")|| patientData.testCaseId.equals("TC_CQM_022")||patientData.testCaseId.equals("TC_CQM_024")){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/");
				String date=DateFormat.format(cal.getTime());
				int year = Calendar.getInstance().get(Calendar.YEAR);
				int year1=year-9;
				assertTrue(enterDate(selenium, txtDob, date+year1), "Could not Enter dob, Expected value to be typed" + patientData.dob, selenium, ClassName,MethodName);
			}else if(patientData.testCaseId.equals("TC_CQM_021")|| patientData.testCaseId.equals("TC_CQM_023")||patientData.testCaseId.equals("TC_CQM_025")){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/");
				String date=DateFormat.format(cal.getTime());
				int year = Calendar.getInstance().get(Calendar.YEAR);
				int year1=year-12;
				assertTrue(enterDate(selenium, txtDob, date+year1), "Could not Enter dob, Expected value to be typed" + patientData.dob, selenium, ClassName,MethodName);
			}
			else
			assertTrue(enterDate(selenium, txtDob, patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob, selenium, ClassName,MethodName);			
			click(selenium,btnClinicalBack);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnClinicalSave),"Could not click Save button More Dateils"+patientData.toString(), selenium, ClassName,MethodName);
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
			returnValue=false;
		}
		return returnValue;
	}
	/**
	 * createNewPatientForCqm
	 * function to create New Patient With Mandatory
	 * @since  	 Jan 07, 2013
	 */	
	public boolean createNewPatientForBPM(Selenium selenium,HomeLib patientData,ClinicalListLib cqmData){
		boolean returnValue = false;
		try{
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtLastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,txtFirstName,patientData.firstName),"Could not type the first Name : More Details"+patientData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,ajxStuasSuggest,patientData.status);
			assertTrue(enterDate(selenium, txtDob, patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob, selenium, ClassName,MethodName);			
			click(selenium,btnClinicalBack);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnClinicalSave),"Could not click Save button More Dateils"+patientData.toString(), selenium, ClassName,MethodName);
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
			returnValue = false;
		}
		return returnValue;
	}
	/**
	 * createSocialHistoryCQM
	 * function to create SocialHistory
	 * @since  	Sep 28, 2012
	 */	
	
	public boolean createSocialHistoryCQM(Selenium selenium,ClinicalListLib proData){
		try{
			selectValueFromAjaxList(selenium,ajxType,proData.type);
			click(selenium,ajxOption2);
			selectValueFromAjaxList(selenium,ajxStuasSuggest,proData.item);
			click(selenium,ajxOption2);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAdd1),"Could not click the add button;More details:"+proData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			
			return true;
			}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		return false;
	}
	/**
	 * createAllergy
	 * function to create Allergy
	* @since  	Sep 27, 2012
	 */	
	
	public boolean createAllergyCqm(Selenium selenium,ChartPreVisitLib allergyData){
		try{
			if(allergyData.testCaseId.equals("TC_CA_004")){
				assertTrue(click(selenium,"//div[6]/div[2]/div/div/span[2]/input"),"Could not Intolernce radio button;More Details", selenium, ClassName,MethodName);
			}
			selectValueFromAjaxList(selenium,ajxAllergy,allergyData.allergen);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxReaction,allergyData.reaction);
			waitForPageLoad(selenium);
			if(!allergyData.testCaseId.equals("TC_CA_001")){
				assertTrue(click(selenium,ajxOption3),"Could not on show more button", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxSeveritySuggest,allergyData.severity);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxStuasSuggest,allergyData.status);
				waitForPageLoad(selenium);
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				String date=DateFormat.format(cal.getTime());
				assertTrue(enterDate(selenium,txtonSetDate,date),"Could not enter the Admin on ;More Details:"+allergyData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxLifeStage,allergyData.lifeStage);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtSummaryComment,allergyData.comment),"Could not enter the comment;More Details:"+allergyData.toString(), selenium, ClassName,MethodName);
			}if(allergyData.testCaseId.equalsIgnoreCase("TC_CA_005")){
				assertTrue(click(selenium,btnlabCancel),"Could not click the cancel button;More details:"+allergyData.toString(), selenium, ClassName,MethodName);
			}else
				assertTrue(click(selenium,btnAdd1),"Could not click the add button;More details:"+allergyData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	/**
	 * createInjection
	 * function to create Injection
	 * @since  	    Sep 26, 2012
	 */	
	public boolean createInjection(Selenium selenium,ChartPreVisitLib injectionData){
		
		try{
			/*if(injectionData.testCaseId.equalsIgnoreCase("TC_CI_009")){
				//Assert.assertTrue(click(selenium,"css=button.quickListButton"),"Could not click the QuickList button;More details:"+injectionData.toString());
				
				if(!isChecked(selenium,"xpath=(//input[@id='saveListcheckbox'])[2]")){
					Assert.assertTrue(click(selenium,"xpath=(//input[@id='saveListcheckbox'])[2]"),"Could not click the Save Quick List check box;More Details:"+injectionData.toString());
					waitForPageLoad(selenium);
				}
			}*/
			
			selectValueFromAjaxList(selenium,ajxInjection,injectionData.injection);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtLotNumber,injectionData.lotNumber),"Could not type the Lot Number;More Details:"+injectionData.toString(), selenium, ClassName,MethodName);
			
			assertTrue(enterDate(selenium,txtExpiry,injectionData.expiryData),"Could not enter the expiry Date;More Details:"+injectionData.toString(), selenium, ClassName,MethodName);
			
			assertTrue(type(selenium,txtDosage,injectionData.dosage),"Could not enter the Dosage;More Details:"+injectionData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,ajxDosageUnit,injectionData.dosageUnit);
			waitForPageLoad(selenium);
			
			assertTrue(enterDate(selenium,txtadminOn,injectionData.adminOn),"Could not enter the expiry Date;More Details:"+injectionData.toString(), selenium, ClassName,MethodName);
			
			if(!(injectionData.testCaseId.equals("TC_CI_004"))){
				assertTrue(click(selenium,lnkInjectionShowMore),"Could not click the show link;More Details:"+injectionData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				if(injectionData.consentCheck.equalsIgnoreCase("yes")){
					assertTrue(click(selenium,chkInjectionConsentBox),"Could not click the consent check box", selenium, ClassName,MethodName);
					selectValueFromAjaxList(selenium,ajxConsent,injectionData.consent);
					waitForPageLoad(selenium);
				}
					
				selectValueFromAjaxList(selenium,ajxInSite,injectionData.site);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxInjectionRoute,injectionData.route);
				waitForPageLoad(selenium);
				//selectValueFromAjaxList(selenium,ajxAdminBy,injectionData.adminBy);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxCptCode1,injectionData.cptCode1);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxCptCode2,injectionData.cptCode2);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxReaction,injectionData.reaction);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtSummaryComment,injectionData.comment),"Could not enter the comment;More Details:"+injectionData.toString(), selenium, ClassName,MethodName);
				
			}assertTrue(click(selenium,btnAdd),"Could not click the Add buton;More Details:"+injectionData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}


	/*public String retrunSearchBoxElementName(Selenium selenium){
		int elementCounter = 0;
		String elementArray[] = selenium.getAllFields();
		while (elementCounter < elementArray.length){
			if(elementArray[elementCounter].trim().endsWith("andsearchTypeSuggestBoxsuggestBoxsuggestBox")){
				break;
			}
		}
		return elementArray[elementCounter];
	}*/
	
	
	/**
	 * createProblemListforMeasure0061
	 * function to create Procedure
	 * @since  	Sep 28, 2012
	 */	
	
	public boolean createProblemListforMeasure0061(Selenium selenium,ChartPreVisitLib proData){
		try{
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			String date=DateFormat.format(cal.getTime());
			
			selectValueFromAjaxList(selenium,ajxMedicalCondtion,proData.medicalCondition1);
			assertTrue(enterDate(selenium,txtonSetDate,proData.onsetDate),"Could not enter the Admin on ;More Details:"+proData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,ajxItemStatus,proData.itemStatus);
			if(isElementPresent(selenium,ajxOption2)){
				click(selenium,ajxOption2);
			}else if(isElementPresent(selenium,ajxOption1)){
			click(selenium,ajxOption1);
			}
			if(proData.testCaseId.equals("TC_CPL_002")||proData.testCaseId.equals("TC_CPL_007")||proData.testCaseId.equals("TC_CPL_012")||proData.testCaseId.equals("TC_CPL_042")||proData.testCaseId.equals("TC_CPL_043")|| proData.testCaseId.equals("TC_CPL_009")){
			assertTrue(click(selenium,"problemsMoreDetails"),"Could not on show more button", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,ajxLifeStage,proData.lifeStage);
			if(isElementPresent(selenium,ajxOption2)){
				click(selenium,ajxOption2);
			}else if(isElementPresent(selenium,ajxOption1)){
			click(selenium,ajxOption1);
			}
			assertTrue(enterDate(selenium,txtResolvedDate,date),"Could not enter resolved date ;More Details:"+proData.toString(), selenium, ClassName,MethodName);
			
			selectValueFromAjaxList(selenium,ajxcodingSystemsuggestBox,proData.codingSystem);
			if(isElementPresent(selenium,ajxOption2)){
				click(selenium,ajxOption2);
			}else if(isElementPresent(selenium,ajxOption1)){
			click(selenium,ajxOption1);
			}
			waitForPageLoad(selenium);
 			selectValueFromAjaxList(selenium,ajxdiagnosissuggestBox,proData.diagnosis);
 			if(isElementPresent(selenium,ajxOption2)){
				click(selenium,ajxOption2);
			}else if(isElementPresent(selenium,ajxOption1)){
			click(selenium,ajxOption1);
			}
 			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtSummaryComment,proData.comment),"Could not enter the comment;More Details:"+proData.toString(), selenium, ClassName,MethodName);
			}
			if(proData.testCaseId.equals("TC_CPL_004")){
				assertTrue(click(selenium,lnkNewSearch),"Could not click the Cancel button;More details:"+proData.toString(), selenium, ClassName,MethodName);
				return true;
			}
			if(proData.testCaseId.equals("TC_CPL_006")){
				assertTrue(click(selenium,btnlabCancel),"Could not click the Cancel button;More details:"+proData.toString(), selenium, ClassName,MethodName);
				return true;
			}
			
			if(isElementPresent(selenium,btnAdd1)){
			assertTrue(click(selenium,btnAdd1),"Could not click the add button;More details:"+proData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			}else
				assertTrue(click(selenium,btnlabSave1),"Could not click the add button;More details:"+proData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			return true;
			}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}
	
	  /**
	     * noAccessUserClinicalList
	     * function to No Access User System Settings
	     * @throws IOException 
	     * @since Nov 11, 2013
	     */   
	    public boolean noAccessUserClinicalList(Selenium selenium, ClinicalListLib cdsData, String userAccount) throws IOException {
	          try{
	                
	                
	                assertTrue(click(selenium,lnkQuickActions),"Could not click on the link" + cdsData .toString(), selenium, ClassName, MethodName);
	                waitForPageLoad(selenium);
	                
	                assertTrue(!selenium.isElementPresent(lnkClinicalLists),"System Setting Link is Visible",selenium, ClassName, MethodName);
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
	    public boolean fullViewAccessUserClinicalList(Selenium selenium, ClinicalListLib cdsData, String userAccount) throws IOException {
	          try{
	                if(isElementPresent(selenium, btnErrorClose)){
	                	assertTrue(click(selenium,btnErrorClose),"Could not click on the link" + cdsData .toString(), selenium, ClassName, MethodName);
		                	
	                }
	                assertTrue(click(selenium,lnkQuickActions),"Could not click on the link" + cdsData .toString(), selenium, ClassName, MethodName);
	                waitForPageLoad(selenium);
	                if(isElementPresent(selenium, btnErrorClose)){
	                	assertTrue(click(selenium,btnErrorClose),"Could not click on the link" + cdsData .toString(), selenium, ClassName, MethodName);
		                	
	                }
	                assertTrue(click(selenium,lnkClinicalLists),"Could not click the systemSettings link;More Deatils:"+cdsData.toString(), selenium, ClassName, MethodName);
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

}

