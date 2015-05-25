package com.nexia.selenium.genericlibrary.chartprevisit;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import static com.sharedlibrary.ThreadSafeSeleniumSessionStorage.*;

import org.openqa.selenium.By;
import org.testng.Assert;


import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.sharedlibrary.AbstractTest;
import com.thoughtworks.selenium.Selenium;

import java.io.FileInputStream;
import java.net.MalformedURLException;
//import java.nio.file.FileSystemException;
import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.Selectors;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;

public class AbstractChartPreVisit extends AbstractTest {
	//
	public String lnkMore="link=More";
	public String lblCountOrder="//div[@id='Ordernotifications']/div/span";
	public String btnRestore="restore";
	public String taskNotificationQueue ="//div[@id='Tasknotifications']/div";
	public String ajxFirstTimeCountList = "xpath=(//input[@id='firsttimeCountSuggestBoxsuggestBox'])";
	public String ajxFirstTimeUnitList = "xpath=(//input[@id='dueInFirstTimeUnitSuggestBoxsuggestBox'])";	
	public String ajxSecondTimeCountList = "xpath=(//input[@id='secondtimeCountSuggestBoxsuggestBox'])";
	public String ajxSecondTimeUnitList = "xpath=(//input[@id='dueInSecondTimeUnitSuggestBoxsuggestBox'])";
	public String btnSave3 =  "saveCareAlerts";
	public String btnSaveRecallReason = "save";
	public String btnNoDuplicate = "notDuplicateButton";
	public String lblcorresQFirst="//div[@id='workQueueItem3']";
	public String txtDOB="dob";
    public String lblLabOrderEditIcon="encLabAction";
    public String lnkEditRemovalReasons = "xpath=(//a[contains(text(),'Click here to edit')])";
    public String lblDiOrderEditIcon = "xpath=//span[contains(@id,'lineTitle')]";


    public String lblCollapseFamilyHistory= "//a[contains(@id,'familyHistoryExpandAnchor_')]";

    public String lblPatientId = "patientID";
	public String saveBtn="saveButton";                                                                  
	public String prescriptionPageData="prescriptionReviewPanel";                                        
	public String btnInjection = "injectionQuickListButton";                                              
	public String quickButtonAttribute="//button[contains(@id,'injectionQuickListButton')]/@class";


	//

    public String yesLink="link=No";
	public String vitalsData="xpath=(//div[@id='vitalBoxWrapper']/textarea)[2]";
	public String cheifComplinatBox="chiefComplaintBox";
	public String cheifCompliantNote="chiefComplaintNote";
	public String historyNote="historyPresentIllnessNote";
	public String reviewTextBox="Constitutionalsymptoms";
	public String patientCheckBox="patientEducationProvidedcheckbox";
	public String btnSaveRemovalReason = "save";
	public String planNotes="planNote";
	public String btnremovebutton="remove";	
	public String btndownarrow="arrowAnchor";
	public String lnklabreport="//div[contains(@id,'unsignedLabReport')]";
	public String btnChooseDelete = "//button[@id='deleteReason']";
	public String tabInjectionQuickListBox = "css=input.gwt-TextBox.fullWidth";
	public String btnDeleteEncounterImmunization = "//a[@id='delete']/span";
	public String lblFamilyHistoryExpandView = "xpath=(//div[@id='menuArrow'])[2]";
	public String btnPrintLab="printNewLabs";
	public String btnDeleteConfirmation = "//a[@class='secondary-button' and text()='Yes']";
	public String labelImmEncounterdetails="//span[starts-with(@id,'immunization')]";
	public String allergyReaction="Chest tightness";
	public String txtPeopleNumber="numberOfPeopleSupportedsuggestBox";
	public String patientInfoWid= "patientInfoWidget";
	public String lnkUserRefListMore="userReferenceListViewMoreLink";
	public String btnInjectionSaveAfterAdd="saveInjection";
	public String injectionSummaryArrow = "//a[starts-with(@id,'injectionExpandAnchor')]";
	public String btnSignProblenList= "sign";
	public String lnkHome="link=Home";
	public String uniqueAccNumber;
	public String InkCorresShowMore="//table[@id='correspondanceDisclosurePanelHeader']";
	public String txtDurationNumber = "continueDurationNumberID";
	public String ajxContactMode = "contactModesuggestBox";
	public String ajxContinueDuration = "refillUsageSuggestBoxDurationContinueIncreaseDecreaseDoseDirectionsuggestBox";
	public String lblEncounterInjection = "//span[contains(@id,'injection')]";
	public String btnShoeMarkup="//a[@id='showMarkup']/span";
	public String  btnTask="//a[@id='assignTask']/span";
public String ajxCosign="coSignSuggestBoxsuggestBox";
public String lblMedsQueuePres="chartListPanel";
public String lnkDrug="//div[@id='tabPanel']/div";
public String patientInfoWid1= "xpath=(//div[contains(@id,'patientInfoWidget')])[2]";
public String txtpatient="//div[@id='patientPanel']/div";
public String txtIllness = "historyPresentIllnessNote";
public String txtGeneric = "Constitutionalsymptoms";
public String lnkDrugClassResultXpath = "xpath=(//a[contains(text(),'DES')])[";
public String lblEncounterDetails = "//span[contains(@id,'problems')]";
	//Git Practice Priya123
 //FIXME EMR-1409
	public String txtOrderDate = "//*[@id='printInfo']/div/div[3]/div/div/div/div[1]/div[1]/div/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[4]/div[2]/input";
	public String txtReceivedDate = "//*[@id='printInfo']/div/div[3]/div/div/div/div[1]/div[1]/div/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[5]/div[2]/input";
	public String txtServiceDate = "//*[@id='printInfo']/div/div[3]/div/div/div/div[1]/div[1]/div/div[2]/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/div[1]/div/div/div[8]/div[2]/input";		
	//mark up
	public String txtEncouDate= "dateField";
	public String btnForward="Forward";
	public String btnHistory="View History";
		public String btnDeleteCorres="//a[@id='deleteLabReports']/span";
	//Correspondence Report
		//FIXME EMR-1438
		public String lnkCollapseeMenuArrow="//td/div/div/div[3]/div";
		public String chkFirstCorresReport="//td/div/div/div/span/input";
		public String txtPrintPreview="css=div.textLayer";
		public String lnkExpandAll="expandAllComments";
		public String patientInfoWid2="xpath=(//div[@id='patientInfoWidget'])[2]";
		public String txtPatientDob="patientDoB";
		
		//FIXME MNT-1299
		public String lblMedicationdetails="//div[3]/div[2]/div/div[4]/div/div/div";
		//FIXME-1732
	public String txtReasonToOverrideAllergy = "css=div.quicklist-wrapper.inline-block > input.text-box";
	
	//FIXME-VEL-6549
	public String elementPatientHandoutAssessmentEntry = "//div[3]/div[3]/div/div[2]/div/div/div";
	
	
	public String elementPatientCloseHandout = "id=btnPatientHandoutCLose";
	public String lblgotopending="//a[contains(text(),'Go to Pending Medications ï¿½')]";
	public String btnAllergyCancel="cancelAllergyButton";
	public String btnAllergyEditsave="id=saveAllergy";
	public String lblCorres="link=Correspondences";
	public String chkFiletosection="fileToSectionradio";
	public String lnkUnmatchedQueue1="//div[@id='Unmatchedpatientrecords']/div/";
	public String lnkTabDiagnosticTests = "link=Diagnostic Tests";
	public String lnkTabMore = "link=More";
	public String btnRefile1 = "link=Refile";
	public String ajxFileTocategory="categorySuggestBoxsuggestBox";
	public String ajxFiletosection="fileToSectionSuggestBoxsuggestBox";
	public String lnkTabLabs = "link=Labs";	
	public String txtFacility = "facilitySearchBox";
	public String lblSignedLabOrders = "//*[contains(@id,'signedLabdescription')]";
	public String btnViewLabReport="viewReport";
	public String btnViewGraph="graph";
	public String btnback="link=Back";
	/*public String elementLabReportEntry = "//span[@id='unsignedLabdescription1']";
	public String elementSignedRecord = "signedLabdescription1";*/
	
	public String btnEditSave1="saveFamilyHistoryEdit";
	public String btnCancelFamilyHistory = "cancelFamilyHistory";
	public String btnSaveFamilyHistory = "saveFamilyHistory";
	public String btnDeleteFamilyHistory = "deleteFamilyHistoryEdit";
	public String lblAllgergy="Allergen_Div";
	public String txtEncounterDate= "dateField";
	public String ajxFatherStature = "fatherStatureSuggestBoxsuggestBox";
	public String 	txtFatherHeightInFeet = "fatherStatureHeightFeet";
	public String txtFatherHeightIn= "fatherStatureHeight";
	public String txtMotherHeightInFeet = "motherStatureHeightFeet";
	public String txtMotherHeightIn= "motherStatureHeight";
	public String ajxMotherStature = "motherStatureSuggestBoxsuggestBox";


	public String lblImmunizationCollapseView = "menuArrow";
	
	public String lnkShowMoreSocial = "medicationsMoreDetails";
	public String btnCnclSocHis = "cancelSocialHistory";
	public String btnSaveSocHis = "saveSocialHistory";
	
	public String btnEditSocHis ="xpath=(//a[contains(text(),'Edit')])";
	public String lblSocialHis = "SocialHistoryTitle";
	public String lblUnEncounterQueue = "//div[@id='unsignedEncounterListItem']";
	public String lblPlanRecomSection="//span[starts-with(@id='injection')]";
	public String lblMedication1="//div[contains(@class,'medication-name display-cell')]";
	
	

	public String lblPatientSearch="xpath=(//div[@id='patientInfoWidget'])[2]";
	public String elementaccNumberforCorres = "accessionNumber";
	public String txtServiceDate1="serviceDate";
	public String txtReceivingDate="receivedDate";
	public String ajxDisgnosis="diagnosisSuggestsuggestBox";
	public String txtreportComments="reportComments";
	public String txtBrowseFile="docManagementFileUpload-file-upload";
	public String btnunsignedcorresAction="link=Actions";
	public String btnCorresDelete="//a[@id='Delete']";
	public String QueeCorrespondenace="//div[@id='Correspondencereports']";
	public String lblUnsignedLabOrders = "//*[contains(@id,'unsignedLabdescription')]";
	

	/// Diagnostic Report 
	
	   public String queDiagnosticReport = "//div[@id='Diagnostictestreports']";
	   public String txtOrderedDate  = "orderedDate";
	   public String txtDIRecievedDate  = "recievedDate";
	   public String txtOrderingProviderSearchBox  = "orderingProviderSearchBox";
	   public String ajxCopyToSearchBox  = "copyToSearchBox";
	   public String txtTranscribedDate = "transcribedDate";
	   public String  txtTranscriptionist = "transcriptionist";
	   public String  txtDiComments= "diComments";
	   
	   public String vfyUnsignedDiReports = "//div[@id='diItemPanel1']/div";
	   public String vfyUnsignedDiReports1 = "//div[@id='diItemPanel2']/div";
	   public String vfyServicedate1 = "servicedate1"; 
	   public String vfyServicedate2 = "servicedate2"; 
		
	   public String vfyTestname1 = "testname1";
	   public String vfyTestname2 = "testname2";
	   
	   public String lnkForwardAction = "//a[@id='forwardLabReports']/span";
	   public String vfyForwardStatus = "receiptMethod1";
	   
	   public String vfyReportStatus = "reportStatus1";
	   public String vfyReceivedInfo = "receivedInfo1";
	   public String vfyPatientName = "name1";
	   public String vfyNewStatus = "newFlag1";
	   public String btnAddComments = "addCommentIcon";
	
	   public String lnkDiagnosticReports = "//a[@id='!chartDiagnosticImagingMore']";

	   public String lnkDiagnosticReports1 = "!chartDiagnosticImaging";
	 
	   public String txtDIPrintedDate = "printedDateBox";
	   public String lblDIPrintFrameTitle = "framePopupViewTitleLabel";
	   public String lnkDIShowReportDetails = "labReportDetailsText";
	   
	   public String vfycomments = "//div[@id='commentsAnchor']/div/div[1]";
	   public String vfycomments1 = "//div[@id='commentsAnchor']/div/div[2]";
	   
	   public String lnkViewHistory = "DEFAULTViewHistory";
	   public String btnNextQueue = "nextButton";
	   public String btnPreviousQueue = "previousButton";  
	   public String IconShowComments = "showCommentIcon";
	   
	   public String btnSignedAction = "//a[contains(@id,'ListItemActionAnchor')]";
	   public String lnkSignedViewReport = "//a[contains(@id,'view')]";
	   
	   public String btnPrintButton = "printButton";
	   public String btnFaxButton = "faxButton";
	   public String btnSelectAll = "selectAllForPrintCheckBoxElement";
	   public String btnFstDIReport = "printCheckBoxElement0";
	   public String btnSecDIReport = "printCheckBoxElement1";
	   
	   public String lblDIReportHeader = "labReportName";
	   public String txtReceivedInfo = "reportRecieveInfo";
	   public String txtOrderingProInfo = "orderingProv";
	   public String txtOrderedDateDI = "orderDate";
	   public String txtTranscriptionistDate = "transDate";
	   public String txtTranscriptionistName = "transcript";
	   public String txtPrintDate = "printDate";
	   public String txtCopiesTo = "copiesTo";
	   public String txtFileDocComment = "fileDocComment";
	   public String txtTestName = "//table[@id='resultPanel']/tbody/tr/td/div/div[2]/span";
	   public String txtTestResult = "//table[@id='resultPanel']/tbody/tr/td/div/div[3]/div[2]/div[2]/span";
	   public String txtTestComments = "//table[@id='resultPanel']/tbody/tr/td/div/div[3]/div[3]/div[2]/span";

	   public String btnShowList= "showListButton";
	 
	   public String vfyForwardedProviders = "xpath=(//div[contains(@id,'currentItem')])";
	   public String  lnkPracticeCount = "xpath=(//a[contains(@id,'practice5')])";
	   public String  lnkRefileOption = "//a[@id='refile']";
	   public String  lnkDIHistory = "//a[@id='labHistoryLabReports']";
	   public String  lblDIHistoryDetails = "//div[contains(@class,'arrowLabHistory')]";
	   public String  lblPatientInfoWid = "xpath=(//div[@id='patientInfoWidget'])[2]";
	   public String btnDISign="signButton"; 
	   
       public String  txtForwardedComments = "notesLabel";
	   	   
	   public String  vfySignedDiReportsChart = "//div[@id='unSigneddiItem1']";
	   public String  vfySignedDiReportsChart1 = "//div[@id='unSigneddiItem2']";
	   public String  vfyUnsignedDiReportsChart = "//div[@id='signeddiItem1']";
	   public String  vfyUnsignedDiReportsChart1 = "//div[@id='signeddiItem2']";
	   public String  vfySignedProDetails = "signedBy";
	   public String  btnPrintOrSendButton = "printSendButtonDiv";
	   public String  lnkProvidersCount = "ProviderCount";
	   public String vfySignedDiReportExpand = "signedByLabel6";
	   public String vfySignedDiReportExpand1 = "accessionNumber6";

	   public String  VfyForwardedComments = "forwardedNote";
	   public String  VfyForwardedStatusComment = "forwardedInfo";

	//Correspondence Report
	//FIXME  ticket  in review	
	public String lblFirstCorresReport="//tr[1]/td/div/div/div[2]/div/div[2]/div/span";
	public String btncommentSave="DEFAULTSave";
	public String btnEditcomments="DEFAULTEdit";
	public String txtDateField="xpath=//div[contains(@id,'correspondanceItem')]/div/div/div";
	public String btnCancelComment="DEFAULTCancel";
	public String btnHidecomments="DEFAULTHideComment";
	//EMR- 1418
	public String btnShowcomments="showCommentLabel";
	public String Searchicon="xpath=(//a[@id='searchMagnifier'])[2]";
	public String SearchCloseicon="searchClose";
	//FIXME EMR-1418
	public String lblsign ="sentDetails";
	public String lblOrderPro="orderingProvider";
	public String  ReceivingPro ="receivingProvider";
	public String lblDOS ="dateOfService";
	public String lblFirstSignedCorresReport="//div[2]/table/tbody/tr/td/div/div/div[2]";	
	public String lblNewTag="isNewPanel";
	public String btnReferralSave = "referPatientSaveButton";
	public String lnkAssignTask="id=Assign Task";
	public String lnkEditReferralNote = "//a[@id='edit']/span";
	public String lnkManageCareAlerts = "patientOptionsManageCareAlerts";            
	public String ajxProblemSuggestBox = "problemSuggestBoxsuggestBox";
	public String lblCollapseViewSocial  ="//a[contains(@id,'socialHistoryExpandAnchor')]";
	public String lnkEncounterActions = "//div[contains(text(),'Actions')]";
	public String lnkMarkup = "//div[contains(text(),'Show Markup')]";
	public String lblFirstEncounter ="xpath=(//div[contains(@id,'pendingCell')])[1]";
	public String lnkEditEncounter ="edit";
	//FIXME VEL-7032
	public String lnkSecondMarkupLink ="user2";
	public String lnkLegends ="editorsAnchor";
	public String lblLegend ="css=div.popup-pointer.popup-pointer-top-middle > div.popupContent";
	public String lnkWizardproblist ="//div[2]/div/div/div[2]/div[2]/div/div/div";
	public String lblLetterTemplates = "xpath=(//div[contains(@class, 'chart-list-item-title')])";
	public String txtHoldReason="Admission to hospital";
	//---------
	public String lblProblemListSumDetails = "xpath=(//div[@id='chartListItemFullWidthWrapper'])[1]";
	public String lblExportedAllergy = "//label[contains(text(),'Allergy/Drug Sensitivity')]/parent::span/parent::div";
	public String lblExportedPatientInfo = "//label[contains(text(),'Personal Information')]/parent::span/parent::div";

	public String lnkChartView = "link=View chart";
	public String txtSummaryDate ="css=input.text-box.date-select";
	public String lnkMandatoryUserFields = "!adminMandatoryUserField";
	public String lnkDeleteMandatoryUserFields = "//div[@id='adminMandatoryUserFieldList']/table/tbody/tr/td[2]/div/a";
	public String Tasktextbox="instructionsTextBoxId";
	public String lblTask = "Tasks";
	public String lblTaskNotification = "Task notifications";
	public String lblTransmissions = "Transmissions have failed";
	public String lblNotification = "//div[contains(text(),'Notifications')]/parent::div";
	public String lblAction = "css=div.homepage-left-column";
	public String lnkEncounterEntry ="xpath=(//div[@id='unsignedEncounterListItem'])[1]";
	public String ajxUnsignedEncounterQue = "xpath=(//input[@id='suggestBox'])[2]";
	public String btnDeleteInjectin="deleteInjectionEdit";
	public String lblRxrenewals = "Rx renewals";
	public String lblReport = "Lab reports";
	public String lblEncounter = "Unsigned encounters";
	public String lblUnMatched = "Unmatched Patient Records";
	public String lblbumpList = "Patients on bump list";
	public String lblwaitList = "Patients on wait list";
	public String lblUnConfirm = "Unconfirmed visits";
	public String btnMatch = "match";
	public String ajxcanSuggestbox="xpath=(//input[@id='immunizationCanadianSuggestBox'])[2]";
	public String ajxcanSuggestbox1="immunizationCanadianSuggestBox";
	public String BtnDeleteImmuni="deleteImmunizationEdit";
	public String lblEncounterSumDetails = "//tr[3]/td/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/span";
	public String btnEncounterCancel = "xpath=//div[@class='noPrint']/div[2]/a[2]";
	public String ajxReCatogorize = "recategorizesuggestBox";
	public String btnViewFullWidth = "viewFullWidthDiv";
	public String btnViewSplitWidth = "viewFullWidthDiv";
	public String btnOkButton = "xpath=(//button[@type='button'])[3]";
	public String btnGraph = "graphSelectedButton";
	public String chkLabEntry = "xpath=(//*[contains(@id,'flowSheetItemCheckbox')])[1]";
	public String lblprescribeProviderName1 = "name";
	public String lnkClinicalSetting = "clinicalSettingsAction";
	public String lnkCDS = "!cdsRuleAdminList";
	public String lnkInteractionwarning = "!interactionWarnings";
	public String lnkDirectoriesCa = "!adminPayerList";
	public String lnkRegisterPatient = "newPatientAction";
	public String lnkRegPatientOption = "patientOptionsRegistration";
	public String lnkQuickAction = "link=Quick Actions";
	public String lnkReferences = "references";
	public String lnkShowMoreLink="showMoreActions";
	public String lnkSystemsetting = "systemSettingsAction";
	public String imgQuickListIcon = "css=img.gwt-Image";
	public String lnkViewRegister = "patientOptionsRegistration";
	public String chkQuickList = "saveListcheckbox";
	public String imgStarIcon = "css=img.gwt-Image.marginRight5";
	public String btnDelete = "//a[contains(text(),'Delete')]";
	public String btnRefDelete = "referralDeleteBtn";
	private String btnBack1="notDuplicateButton"; 
	public String btnBackButton = "backButton";

	public String lnkRecentPatient = "link=Show recent patients";
	// public String lnkTopMenu = "topMenuHeader";
	public String lnkTopMenuPractice = "//div[@id='printInfo']/div/div/div/div/div[4]/div";
	public String lnkSignOut = "signOutAction";
	public String txtlastName = "lastName";
	public String txtFirstName = "firstName";
	public String txtpatientId = "patientID";
	public String txtSearchPatient = "searchPatientBox";
	public String imgMedicationWarning = "css=div.GKPPEI2BJJ";
	public String lnkPrint = "link=Print";
	public String lnkAdminOrgStructureLists = "!adminOrgStructureLists";
	public String lblAllerfyDateTime1 = "//div[starts-with(@id, 'ImmunizationList')]";
	public String lnkExpandArrow1 = "chartListItemTitle";
	public String chkNoknownItem = "nkdaCheckboxcheckbox";
	public String chkNoknownItem1 = "noEntryCheckboxcheckbox";
	public String vfyUserName1 = "lastUpdatedBy";
	public String btnDeleteMedication = "//div[@id='MedicationsList']/table/tbody/tr/td[4]/div/a";
	// Announcement
	public String btnAnnEdit = "css=div.dashboard-announcement-wrapper > div.edit-panel > button.gwt-Button";
	public String txtAnnouncement = "css=div.dashboard-announcement-wrapper > textarea.gwt-TextArea";
	public String btnAnnsave = "css=div.dashboard-announcement-wrapper > div.save-panel > button.gwt-Button";
	public String btnAnnCancel = "xpath=(//button[@type='button'])[6]";

	//signing authority
	public String lnkUserRole = "!adminUserRoleList";
	public String lnkUserRoleMore ="AdminUserRoleListMoreLink";
	public String lblClinicalCategory = "//*[@class='gwt-InlineHTML padding-left-10' and text()='Clinical' ]" ;
	public String lblOrdersCategory = "//*[@class='gwt-InlineHTML padding-left-20' and text()='Orders' ]";
	public String innerTables = "//table[@class='no-expand-single-sub-check-prw width-100-pct permission-form-row']";
	public String lblReportsCategory = "//*[@class='gwt-InlineHTML padding-left-20' and text()='Reports' ]";	
	public String btnAddNewUserRole = "addIdentifierType";
	public String chkNoAccessCheckBoxes = "xpath=(//table[@class='expand-prw width-100-pct permission-form-row']//input[@type='checkbox' and contains(@id,'chk1')])";
	public String chkViewOnlyCheckBoxes = "xpath=(//table[@class='expand-prw width-100-pct permission-form-row']//input[@type='checkbox' and contains(@id,'chk2')])";
	public String chkLimitedAccessCheckBoxes = "xpath=(//table[@class='expand-prw width-100-pct permission-form-row']//input[@type='checkbox' and contains(@id,'chk3')])";
	public String chkFullAccessCheckBoxes = "xpath=(//table[@class='expand-prw width-100-pct permission-form-row']//input[@type='checkbox' and contains(@id,'chk4')])";
	public String btnCancelID = "cancel";	

	// InteractionWanring

	public String rdoSevereOnly = "severeradio";
	public String rdoHighToSevere = "highradio";
	public String rdoModerateToSevere = "moderateradio";
	public String rdoMildToSevere = "mildradio";
	public String btnEditSave = "css=button.gwt-Button";

	// Note
	public String btnNoteEdit = "editButton";
	public String txtNote = "note";
	public String btnNoteSave = "saveButton";

	public String ajxComm = "commType1SuggestBoxsuggestBox";
	public String txtPrimaryPhone = "primaryPhone";
	public String txtPrimaryExtn = "primaryPhoneExtension";
	public String lblPatientInfo = "//div[4]/div/div[2]/div";
	public String lblMedsQueue1 = "xpath=(//div[starts-with(@id,'rxRenewalQueueItem')])[1]";
	// ProviderHomePage

	public String lnkUnsignedEncounterQueue = "//div[4]/div/div/span[2]";
	public String lblUns = "//span/div/div[4]/div";

	// RxRenewal Queue
	public String lnkRxRenewal = "Rxrenewals";
	public String txtRxPatientSearch = "medicationSlideWindowSearchBox";
	public String ajxRxShow = "suggestBox";
	public String ajxRxProvider = "xpath=(//input[@id='suggestBox'])[2]";
	public String lblPendingMeds = "//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div/div";

	public String btnRxEdit = "editButton";

	public String allergyReaction1="Runny nose ";
	// Lab Report Queue
	public String labReportlist = "//div[@id='Labreports']/div/span[2]";
	public String labReportQueue = "Labreports";
	public String showPickList = "suggestBox";
	public String searchBox = "searchPanel";
	public String forPickList = "forSuggestBoxsuggestBox";
	public String firstLabReport = "//div[@class='workqueue-list-item']/div[3]";
	public String lblLabReport = "//div/div/div[2]/div/div/div/div/div/div[2]/div[2]";
	public String labReport = "//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div";
	public String thirdLabReport = "//div/div/div[2]/div/div/div/div/div/div[3]";
	public String secondLabReport =  "xpath=//div[contains(@id,'LabReport')][2]";
	public String selectList = "//div[5]/div/div/div/div/div";
	public String verifyProvider = "//body/div[5]";
	public String testResult = "//div[5]/table/tbody/tr[2]/td[2]/div/div/div/div/div";
	public String labReportCheckBox = "//span[@id='checkBox']/input";
	public String hideQueue = "SlideWindowHideAnchor";
	public String delete = "deleteLabReports";
	public String forward = "//a[2]/span";
	public String forwardTo = "xpath=(//input[@id='suggestBox'])[2]";
	public String notes = "css=div.marginTop5 > textarea.gwt-TextArea";
	public String send = "send";
	public String back = "back";
	public String lnkLabListView = "ListViewTab";
	public String lnkLabFlowSheetView="FlowSheet";
	public String lnkShowLabReport = "labReportDetailsImage";
	public String btnSaveNext = "saveAndNext";
	public String ForwardedLabReport= "recievedInfo4";
	// Medication Queue
	public String btnEditMedication ="//a[contains(text(),'Edit')]";
	public String btnCancelMedication = "cancelMedications";
	public String lbldelete = "//a[contains(@id,'delete')]";
	public String btnPendingAction= "//a[contains(@id,'pendingAction')]";

	public String medicationQueue = "Rxrenewals";

	public String prescribe = "drugsSuggestBox";
	public String search = "xpath=(//button[@type='button'])[8]";

	public String warningsave = "//span/input";
	public String show = "suggestBox";
	public String forProviderSuggestBox = "forSuggestBoxsuggestBox";
	public String searchTextBox = "searchPanel";
	public String hide = "SlideWindowHideAnchor";
	public String HideTxt ="Hide";
	public String medsQueueFrame = "queueItem";
	public String appointmentFor = "resourceCalendarsuggestBox";
	public String day = "daysuggestBox";
	public String lblMedsQueue = "xpath=(//div[starts-with(@id,'rxRenewalQueueItem')])[1]";

	
	public String lblMedsQeueu2 = "css=div.chart-list-row";
	public String lblMedsQueue3 = "//div[4]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div";
	public String lblMedsQueue4 = "xpath=(//div[starts-with(@id,'rxRenewalQueueItem')])[1]";
	public String txtOfRefill = "ofRefillsid";
	// registerPatient
	public String txtDob = "dateOfBirth";
	public String comSex = "suggestBox";
	public String lnkviewmonograph="//a[contains(@id,'openmonograph')]";
	public String btnOption2="xpath=(//a[starts-with(@id,'pendingAction')])[2]";
	public String lblRxqitem ="xpath=(//div[starts-with(@id,'queueItem')])[1]";
	// Directories
	public String lnkDirectories = "!directories";
	public String btnAddDirectories = "css=button.secondary-button.float-right";

	// ProcedureaddVitalsForCds
	public String lnkSummary = "!chartSummary";
	public String lnkProcedure = "MedicalandSurgicalHistoryTitle";
	public String lnkEncounterProcedure = "xpath=(//a[contains(text(),'Medical and Surgical History')])[2]";
	public String imgCustomize = "css=div.userHintDialog";

	public String lnkDeleteProcedure = "//div[@id='ProcedureList']/table/tbody/tr/td[4]/div/a";
	public String lnkProcedureShowMore = "medicationsMoreDetails";
	public String lnkProcedureShowMoreArrow = "procedureMoreDetailsArrow";
	public String btnProcedureQuickList = "procedureQuickListButton";
	public String txtcpt = "cptSuggestBox0-1suggestBox";
	public String txtProcedureDate = "procedureDate";
	public String txtdeleteReason = "deleteReason";
	public String lnkSettings="link=Settings";
	public String txtProcedureName = "searchProcedureTextBox";
	public String chkConsentBox = "consentCheckBoxcheckbox";
	public String chkProcedure = "xpath=(//input[@type='checkbox'])[3]";
	public String consent_procedure = "consentSuggestBoxsuggestBox";
	public String cancel_procedure = "//div[3]/button";
	public String btnDeleteReason = "//button[@id='deleteReason']";
	public String lblProDetails = "//div[2]/div/div/div[4]/div/div";
	public String lblNoProcedure = "//div[4]/div[2]/div/div/div/div";
	public String lblEncounterProName = "css=span.bold.firepath-matching-node";
	public String lblProCollapseView = "menuArrow";
	public String lblProExpendView = "//td[2]/div/span/div[2]/div/div";
	public String btnProEdit = "//a[contains(text(),'Edit')]";
	public String btnSaveProcedure = "saveProcedures";
	public String btnSaveProcedure1 = "xpath=(//a[contains(text(),'Save')])[2]";
	public String lblEncouterSumDetailsProcedure = "//span[starts-with(@id, 'procedure')]";
	public String lblEncouterSumDetailsImmunization = "//span[starts-with(@id, 'immunization')]";
	public String lblEncouterSumDetails="div//span/span/span";
	public String lblEncounterProData1 = "//td[2]/div/span/div/div";
	public String lblSumProData = "//div[2]/div/div/div/div/div/div[2]/div/span/span";
	public String tabSearchProcedure = "searchProcedureTextBox";
	public String tabProcedureDate = "procedureDate";
	public String tabAjxProCp1t = "cptSuggestBox0-1suggestBox";
	public String tabbtnAddCpt = "css=button.absoluteTopRight";
	public String tabSummaryComment = "summaryComment";
	public String tabChkConsentBox = "consentCheckBoxcheckbox";
	public String btnCancelSocHis = "cancelSocialHistory";
	public String btnSaveSocialHis= "saveSocialHistory";
    public String btnVitalsDone="xpath=(//button[@id='doneVitalsEnc'])[2]";

	// Vitals
	public String lnkVitals = "link=VITALS";
	public String lnkVitals1 = "xpath=(//a[contains(text(),'VITALS')])[2]";
	public String lnkVitalShowmore = "vitalsMoreDetails";
	public String lnkVitalHeight = "//div[2]/div/div[2]/div/div";
	public String btnDoneButton = " xpath=(//button[@id='doneVitalsEnc'])[2]";
	public String lblNoVitals = "//div[71]/div/div[2]/div/div";
	public String lblChart = "chart";
	public String lblVitals = "Vitals";
	public String lblVitalspop = "css=div.popupContent > div";
	public String lblCreatedVitalsEntry = "//div/div[2]/div[2]/div";
	public String lblNoVitalsRecord = "//td[2]/div/div/div[4]/div/div/div/div";
	public String lblVitalsUpdate = "//div[3]/div/div/div[3]/div/div/div";
	public String lblVitalsDetails1 = "//div[3]/div/div/div[2]/table/tbody/tr/td[2]/div";
	public String lblVitalsDetails2 = "//div[3]/div/div/div[2]/table/tbody/tr[2]/td[2]/div";
	public String lblVitalsDetails3 = "//tr[3]/td[2]/div";
	public String lblVitalsDetails = "//tr[4]/td[2]/div";
	public String lblVitalsDetails4 = "//div/div/div[2]/table/tbody/tr[5]/td[2]/div";
	public String lblVitalsDetails5 = "//div/div/div[2]/table/tbody/tr[6]/td[2]/div";
	public String lblVitalsDetails7 = "//tr[8]/td[2]/div";
	public String lblVitalsDetails8 = "//tr[9]/td[2]/div";
	public String lblVitalsDetails9 = "//tr[10]/td[2]/div";
	public String lblVitalsDetails10 = "//tr[5]/td[2]/div/span/div[2]";
	public String lblVitalsDetails11 = "//tr[6]/td[2]/div/span/div[2]";
	public String lblVitalsDetails12 = "//tr[9]/td[2]/div/span/div[2]";
	public String lblVitalsDetails13 = "//tr[10]/td[2]/div/span/div[2]";
	public String lblVitalsDetails14 = "//tr[11]/td[2]/div/span/div[2]";
	public String lblVitalsDetails15 = "//tr[12]/td[2]/div/span/div[2]";
	public String lblVitalsDetails16 = "//tr[13]/td[2]/div";
	public String lblVitalsDetails17 = "//tr[13]/td[2]/div/span/div[2]";
	public String lblSummaryEnVitals1 = "//div[2]/div[2]/div/div/div[2]";
	public String lblSummaryEnVitals2 = "//div[2]/div[2]/div/div[2]/div[2]";
	public String lblSummaryEnVitals3 = "//div[2]/div/div[3]/div[2]";
	public String lblSummaryEnVitals4 = "//div[8]/div[2]";
	public String lblSummaryEnVitals5 = "//div[2]/div[2]/div[2]/div[2]/div[2]";
	public String lblSummaryEnVitals6 = "//div[2]/div[2]/div[2]";
	public String lblSummaryEnVitals7 = "//div[2]/div[3]/div[2]";
	public String lblSummaryEnVitals8 = "//div[2]/div[4]/div[2]";
	public String lblSummaryEnVitals9 = "//div[2]/div[5]/div[2]";
	public String lblSummaryEnVitals10 = "//div[5]/div[2]";
	public String lblSummaryEnVitals11 = "//div[7]/div[2]";
	public String lblSummaryEnVitals12 = "//div[2]/div[2]/div[2]/div/div[2]";
	public String lblSummaryEnVitals13 = "//div[6]/div[2]";
	public String lblVitalsSummary = "//td[2]/div/div/div/div/div/div/div/div/div/div[2]/div[2]";
	public String lblVitalsinChild = "//tr[2]/td[2]/div/span/div[2]";
	public String lblVitalsinChild1 = "//tr[3]/td[2]/div/span/div[2]";
	public String lblVitalsinChild2 = "//tr[4]/td[2]/div/span/div[2]";
	public String lblVitalsinChild3 = "//tr[8]/td[2]/div/span/div[2]";
	public String lblVitalsinChild4 = "//tr[7]/td[2]/div/span/div[2]";
	public String ajxHeight = "heightSuggestBoxsuggestBox";
	public String ajxWeight = "weightSuggestBoxsuggestBox";
	public String ajxPosition = "positionSuggestBoxsuggestBox";
	public String ajxLimb = "limbSuggestBoxsuggestBox";
	public String ajxCuffsize = "cuffSizeSuggestBoxsuggestBox";
	public String ajxdescription = "descriptionSuggestBoxsuggestBox";
	public String ajxrhythm = "rhythmSuggestBoxsuggestBox";
	public String ajxWaist = "waistSuggestBoxsuggestBox";
	public String ajxTempUnit = "temperatureUnitSuggestBoxsuggestBox";
	public String lblMedsQueueDate = "xpath=(//div[starts-with(@id,'rxRenewalQueueItem')])[1]";
	public String ajxTempLocation = "temperatureLocationSuggestBoxsuggestBox";
	public String ajxBloodSugar = "bloodSugarUnitSuggestBoxsuggestBox";
	public String ajxRespiratory = "respiratoryRateDescriptionSuggestBoxsuggestBox";
	public String ajxPefr = "pefrDescriptionSuggestBoxsuggestBox";
	public String ajxHead = "headSuggestBoxsuggestBox";
	public String txtWeight = "weight";
	public String txtHeight = "height";
	public String txtHeightIn = "heightFeet2";
	public String txtHeightInFeet = "heightFeet1";
	public String txtSystolic = "systolic";
	public String txtdiastolic = "diastolic";
	public String btnNoButton = "link=No";
	public String txtheartRate = "heartRate";
	public String txtwaist = "waist";
	public String txtwaist1 = "//input[@id='waist']";
	public String txtTemp = "temperature";
	public String txtBloodSugar = "bloodSugar";
	public String txtBloodSugar1 = "//input[@id='bloodSugar']";
	public String txtRespiratory = "respiratoryRate";
	public String txtOxygen = "oxygenSaturation";
	public String txtOxygen1 = "//input[@id='oxygenSaturation']";
	public String txtPefr = "pefr";
	public String txtPefr1 = "//input[@id='pefr']";
	public String txtPefrTime = "pefrTime";
	public String txtTime = "time";
	public String btnMoveToHistory = "//a[contains(@id,'moveToHistory')]";
	public String btnDeleteHistoryMed = "//a[contains(@id,'delete')]";

	// Injection
	public String lnkInjection = "link=Injections";
	public String lnkEncounterInjection = "xpath=(//a[contains(text(),'Injections')])[2]";
	public String strInjection="InjectionsTitle";
	public String btnEditInjection="xpath=(//a[contains(@id,'Edit')])[4]";
	public String chkInjection = "//div[@id='InjectionList']/table/tbody/tr/td/div/input";
	public String chkInjectionConsentBox = "consentcheckbox";
	public String btnInjectionEdit = "//div[@id='InjectionList']/table/tbody/tr/td[3]/div/a";
	
	public String btnInjection1 = "//button[starts-with(@class,'quick-list-button')]";
	public String btnInjEditSave = "xpath=(//a[contains(text(),'Save')])[2]";
	public String btnInjEditSave1 = "xpath=(//a[contains(text(),'Save')])[3]";
	public String chkshowAllRecords = "includeInactivecheckbox";
	public String lblUnsignedCorresReport="xpath=//div[contains(@id,'correspondancePanelUnsigned')]/div[2]";
	public String txtQuickinjection =   "//div[@id='searchInjection']/input";
	public String txtexpiryDate = "expiryDate";
	public String txtDosage = "dosageQuantity";
	public String txtadminOn = "administeredOn";
	public String lnkInjectionShowMore = "medicationsMoreDetails";
	public String lnkInjectionShowMoreArrow = "medicationsMoreDetails";
	public String ajxConsentSuggest = "consentsuggestBox";
	public String ajxDosageUnit = "dosageUnitsuggestBox";
	public String site = "siteSuggestBoxsuggestBox";
	public String ajxInjectionRoute = "routeSuggestBoxsuggestBox";
	public String ajxAdminBy = "administeredBysuggestBox";
	public String ajxCptCode1 = "cptCode1SuggestBoxsuggestBox";
	public String ajxCptCode2 = "cptCode2SuggestBoxsuggestBox";
	public String ajxReaction = "reactionSuggestBoxsuggestBox";
	// public String save_injection = "//div[5]/button";
	public String save_injection = "//a[@id='save']";
	public String lblCptDisclaimer = "css=div.gwt-Label";
	public String lblEnconuterInDetails = "//div[6]/div";
	public String lblEnVerifyInjection = "//div[4]/div/div/div[6]/div";
	public String lblSumInjection1 = "css=b";
	public String lblSumInjection2 = "//div[9]/div[2]/div/div/div/div/div/div[2]/div/span/div/div/span[2]";
	public String arrowSummInjection = "//div[9]/div[2]/div/div/div/div/div/div[3]/a";
	public String lblSumInjection3 = "//span/div/div[3]/div[3]/div";
	public String lblSumInjection4 = "//span/div[3]/div[2]/div";
	public String lblSumInjection5 = "//div[3]/div[3]/div[2]/div[2]/div";
	public String lblSumInjection6 = "//span/div/div[3]/div[3]/div[2]/div[2]/div[2]";
	public String lblSumInjection8 = "//div[3]/div[2]/div[2]/div";
	public String lblSumInjection7 = "//div[3]/div[3]/div[3]/span";
	public String lblSumInjection9 = "//div[3]/div[3]/div[2]/div";
	public String lblNoInjection = "xpath=(//div[@id='chartListItemFullWidthWrapper'])[9]";
	public String lblExpandInjection = "//td[2]/div/span/div/div[3]";
	public String lblInjectionCollapseview = "menuArrow";
	public String tabSite = "css=#siteSuggestBoxsuggestBox";
	public String tabLotNo = "css=#lotNumberBox";
	public String tabDosage = "css=#dosageQuantity";
	public String tabDosageUnit = "css=#dosageUnitsuggestBox";
	public String tabExpiryDate = "css=#expiryDate";
	public String tabAdminon = "css=#administeredOn";
	public String tabroute = "css=#routeSuggestBoxsuggestBox";
	public String tabAdminstered = "css=#administeredBysuggestBox";
	public String tabInCpt1 = "css=#cptCode1SuggestBoxsuggestBox";
	public String tabInCpt2 = "css=#cptCode2SuggestBoxsuggestBox";
	public String tabInReaction = "css=#reactionSuggestBoxsuggestBox";
	public String btnInjectionEditEncounter = "//a[@id='edit']";

	// Immunization
	public String btnImmunizationEdit = "//a[starts-with(@id, 'Edit')]";
	//public String btnImmEditSave = "xpath=(//a[contains(text(),'Save')])[2]";
	public String lblImmunixationWizard="//div[@id='printInfo']/div/div[3]/div/div[3]/div[2]/div[2]/div[2]/div/div[2]/div/div/div[2]/div[5]/div/div/div[2]";

	public String lnkImmunization = "link=Immunizations";
	public String lnkImmShowMore = "medicationsMoreDetails";
	public String lnkImmShowMoreArrow = "medicationsMoreDetails";
	public String lnkEncounterImmunization = "xpath=(//a[contains(text(),'Immunizations')])[2]";
	public String lnlEncounterEditImmunization = "//a/span";
	public String lblImmNoDate = "//div[8]/div[2]/div/div/div/div";
	public String lblImmCollapsableView = "menuArrow";

	public String lblEnImmDetails = "//span/span";
	public String lblImmData = "//span/div/div[2]/div/span";
	public String lblImmDetail1 = "//div[8]/div[2]/div/div/div/div/div/div[2]/div/span/div/div/span";
	public String lblImmDetails = "//td[2]/div/div/div/div[8]/div[2]/div/div/div/div";
	public String lblImmExpendView1 = "//div[9]/div[2]/div/div/div/div/div";
	public String lblImmExpendView2 = "//td[2]/div/span/div";
	public String lblImmExpendLotno = "//div[3]/div[3]/div";
	public String lblImmExpendView3 = "//div[3]/div[4]/div";
	public String lblImmExpendView4 = "//div[3]/div[3]/div[2]";
	public String lblImmExpendView5 = "//div[3]/div[4]/div[2]/div";
	public String lblImmExpendView6 = "//div[3]/div[4]/div[2]/div[2]";
	public String lblImmExpendTime = "//div[3]/div[6]/span";
	public String lblsummaryImm = "//div[8]/div[2]/div/div/div/div";
	public String lblsummaryImm1 = "//div[8]/div[2]/div/div/div/div/div/div[3]/a";
	public String lblsummaryImmMenuArrow = "menuArrow"; 
	public String lblsummaryImm2 = "div[2]divspandivdivdiv";
	public String lblsummaryImm3 = "css=span.red";
	public String lblSummaryImm4 = "//div[8]/div[2]/div/div/div/div/div/div[2]/div[3]/span/div/div";
	public String lblSummaryImm5 = "//span/div[3]/div";
	public String lblSummaryImm6 = "//span/div[3]/div[2]";
	public String lblSummaryImm7 = "//span/div[4]/div";
	public String lblSummaryImm8 = "//div[8]/div[2]/div/div/div/div/div/div[2]/div[3]/span/div[4]/div[2]/div";
	public String lblEncouterImmDetails = "//span[starts-with(@id, 'immunization')]";
	public String lblSummaryImm9 = "//div[8]/div[2]/div/div/div/div/div/div[2]/div[3]/span/div[4]/div[2]/div[2]";
	public String lblSummaryImm10 = "//span/div[2]/div";
	public String chkrefused = "refusedByPatientcheckbox";
	public String chkadmin = "administeredElsewherecheckbox";
	public String txtCssImm = "css=#immunizationSuggestBox";
	public String txtCssadmin = "administeredOnDate";
	public String txtCssRefeused = "refusedOnDate";
	public String txtRefusedImmunization = "xpath=(//input[@id='immunizationSuggestBox'])[2]";
	public String txtRefusedOndate = "refusedOnDate";
	public String txtRefusedComment = "xpath=(//textarea[@id='summaryComment'])[2]";
	public String txtadminOnDate = "administeredOnDate";
	public String txtLotNo = "lotNumberBox";
	public String txtImmDosage = "dosageValue";
	public String txtadminDate = "xpath=(//input[@id='administeredOnDate'])[2]";
	public String txtImmComment = "xpath=(//textarea[@id='summaryComment'])[3]";
	public String ajxImmunization = "immunizationSuggestBox";
	public String ajxVaccine = "searchVaccineBox";
	public String ajxImmdosage = "dosagesuggestBox";
	public String ajxSeries1 = "series1suggestBox";
	public String ajxSeries2 = "series2suggestBox";
	public String ajxSite = "sitesuggestBox";
	public String ajxadminsteredBy = "administeredBy";
	public String ajxImmCpt1 = "cpt1suggestBox";
	public String ajxImmCp2 = "cpt2suggestBox";
	public String ajxImmreaction = "reactionsuggestBox";
	public String ajxImmRoute = "routesuggestBox";
	public String btnImmQuickList = "ImmunizationQuickListButton";
	// FamilyHistory
	public String lnkFamilyHistory = "link=Family History";
	public String lnkMenuArrow = "menuArrow";
	public String lnkEncounterFamilyHistory = "xpath=(//a[contains(text(),'Family History')])[2]";
	public String lnkFamilkShowMoreDeatils = "medicationsMoreDetails";
	public String btnFamilyEdit = "//div[@id='FamilyHistoryList']/table/tbody/tr/td[3]/div/a";
	public String btnYes = "yesButton";
	public String btnFamilyQuickList = "familyHistoryQuicklistButton";
	public String btnSaveLink = "link=Save";
	public String btnSave2 = "id=save";
	public String btnDFamilyDelete = "//div[@id='FamilyHistoryList']/table/tbody/tr/td[4]/div/a";
	public String ajxFamilyMedical = "familyHistoryQuicklist";
	public String ajxFamilyrelation = "relationshipsuggestBox";
	public String ajxCodeingSystem = "codingSystemsuggestBox";
	public String ajxdiagnosis = "diagnosissuggestBox";
	public String txtAgeOfOnset = "ageOfOnset";
	public String txtAgeat = "ageAtDeath";
	public String txtTreatMent = "treatment";
	public String txtComment = "comment";
	public String lblFamilyExpanView = "//td[2]/div/span/div[2]";
	public String lblEncounterFamilyDetails = "//span[contains(@id,'familyHistory')]";
	public String lblEnSumSocHistoryDetails="xpath=(//span[contains(@id,'socialHistory')])";
	public String lblFamilyUppercase = "css=span.textUpperCase";
	public String lblNoFamily = "//div[6]/div[2]/div/div/div/div";
	public String lblEnSumFamilyDetails1 = "xpath=(//span[contains(@id,'familyHistory')])";
	public String lblEnProblemList = "//span[starts-with(@id, 'problems')]";
	public String lblLastUpdateBy="lastUpdatedBy";
	public String lblEnSumFamilyDetails = "//span/span[2]";
	public String lblEnSum = "//div[8]/div/div/span/span/span";
	public String lblFamilyDetails = "//div[6]/div[2]/div/div/div/div/div/div[2]/div/span/span";
	public String lblFamilyDetails1 = "//span/div[2]/div/div[4]";
	public String lblSumFamilyDetails1 = "//div[6]/div[2]/div/div/div/div";
	public String lblSumFamilyDetails2 = "//div[6]/div[2]/div/div/div/div/div/div[2]/div/span";
	public String lblSumFamilyDetails3 = "css=div.light.break-word";
	public String lblSumFamilyDetails4 = "//div[6]/div[2]/div/div/div/div/div/div[3]/a";
	public String lblSumFamilyDetails5 = "//div[3]/span/div";
	public String lblSumFamilyDetails6 = "//span/div[4]";
	public String lblSumFamilyDetails7 = "//span/div[5]";
	public String lblEncounterFamilyHistory = "//span[contains(@id,'familyHistory')]";

	
    //PreventiveCare
    public String btnCancelPopup = "cancel";
    public String lblReasonText = "xpath=(//*[@class='gwt-InlineLabel'])";
	public String btnCancelCareAlerts = "cancelCareAlerts";
    public String rdoAutomatedRecallButtons = "xpath=(//input[@id='fluShotsAutomatedRecallButtonradio'])";
       public String rdoNeverRecallButtons = "xpath=(//input[@id='fluShotsNeverRecallButtonradio'])";
       public String rdoForceRecallButtons = "xpath=(//input[@id='fluShotsForceRecallButtonradio'])";
      public String ajxPrefCommunication = "//*[@id='prefCommunicationSuggestBoxsuggestBox']";
      	public String tabEmailMethod = "currentItem_1";
      	public String tabMailMethod = "currentItem_2";
      	public String tabTelephoneMethod = "currentItem_3";
      	public String btnCancelChartItems="cancelButton";
    	public String lnkCancelPrefCommunication = "link=Cancel";
    public String lnkEditCommunicationMethod = "link=Edit";
    public String lnkSavePrefCommunication = "link=Save";
      	public String lblPrefMethod = "preference";
      	 public String btnClearPreview = "clearID";
     //   public String chkFirstEmail = "firstEmailCheckboxcheckbox";
       	public String chkSecondEmail = "secondEmailCheckboxcheckbox";
    	public String lnkMailTab = "mail";
    	
    	public String chkFirstMail = "firstMailCheckboxcheckbox";
    	public String chkSecondMail = "secondMailCheckboxcheckbox";	
    	public String ajxFirstNoticeTemplateMail = "firstNoticeTemplatetSuggestBoxsuggestBox";

        public String btnPrintPreview = "printID";
        public String ajxResponsibleProvider = "responsibleProviderSuggestBoxIdsuggestBox";
        public String lblPatientCompletedCounts = "//div[@class='percentage-total']";
        public String ajxFiscalYearPickList = "firstSortCriteriasuggestBox";
        public String ajxProviderFilterList = "providerFiltersuggestBox";
        public String ajxContactStageFilterList = "contactStageFiltersuggestBox";
        public String ajxProcedureStateFilterList = "procedureStateFiltersuggestBox";
        public String chkOnlyEnrolledPatients = "//input[@type='checkbox' and contains(@id,'gwt-uid-')]";  

      	public String btnBackCancel = "cancelID";
   	public String lnkCareAlertEdit = "xpath=(//*[@id='EditEdit'])";
   	public String lnkCareAlertStop = "xpath=(//*[@id='STOPSTOP'])";
   	public String lnkCareAlertStart = "xpath=(//*[@id='STARTSTART'])";
   	public String lnkCareAlertExpandOff = "xpath=(//*[@id='menuArrow'])";
   	public String lnkCareAlertExpandOn = "xpath=(//*[@id='menuArrowOpened'])";
   	public String lnkTelephoneTab = "telephone";
	public String ajxTimeCountList = "xpath=(//input[@id='timeCountSuggestBoxsuggestBox'])";
	public String ajxTaskCount="xpath=(//input[@id='timeCountSuggestBoxsuggestBox'])[3]";
	public String ajxTimeUnitCount="xpath=(//input[@id='dueInTimeUnitSuggestBoxsuggestBox'])[3]";
	public String ajxAssignToSuggBox="xpath=(//input[@id='assignToSuggestBoxsuggestBox'])[3]";
	public String ajxTimeUnitList = "xpath=(//input[@id='dueInTimeUnitSuggestBoxsuggestBox'])";
	public String ajxAssignToList = "xpath=(//input[@id='assignToSuggestBoxsuggestBox'])";
	public String txtInstructionTextBox = "xpath=(//textarea[@id='instructionsTextBoxId'])";
	public String txtCallerScriptTextBox = "scriptTextBoxId";
	public String lnkEmailTab = "email";
	public String chkEmailConfirmation = "emailConfirmationCheckboxcheckbox";
	public String chkFirstEmail = "firstEmailCheckboxcheckbox";
	public String ajxFollowUpTimeCountList = "firsttimeCountSuggestBoxsuggestBox";
	public String ajxFollowUpTimeUnitList = "dueInFirstTimeUnitSuggestBoxsuggestBox";
	public String ajxFirstNoticeTemplate = "firstNoticeTemplateSuggestBoxsuggestBox";
	public String ajxSecondNoticeTemplate = "xpath=(//input[@id='secondNoticeTemplateSuggestBoxsuggestBox'])";
     public String txtRemovalReason = "deleteReasonBox";    
     public  String lnkEditRemovalReasonFecal = "fobt_never_recall";
       public String tblAutomatedRecallAlertTable = "//table[@class='cellTable']";
       public String tblAlertPatientList = "//table[@id='auditCellList']";
       public String lnkClinicalList = "clinicalListsAction";
       public String lnkClinicalPatientList = "!automatedRecallList";
       public String lblCareAlerts = "xpath=(//*[@class='large'])";
       public String lnkCareAlertPreview = "xpath=(//a[contains(text(),'Preview')])";      
       public String lblEncounterSave1="//a[@id='saveEncounter']/span";
       public String btnSaveCareAlerts = "saveCareAlerts";

           public String lnkEditForceReasons = "xpath=(//a[contains(text(),'Click here to edit')])";
           public String lnkEditForceReasonsM="xpath=(//a[contains(text(),'Click here to edit')])[10]";
           public String txtRecallReason = "referringCode";
         
           public String ajxRecallFrequency = "repeatFrequencySuggestBoxsuggestBox";
           public String ajxRecallCount = "timeCountSuggestBoxsuggestBox";
           public String ajxRecallUnit = "dueInTimeUnitSuggestBoxsuggestBox";
       	
	
	//public String chkShowBox = "xpath=(//input[@type='checkbox'])[2]";
	public String txtUserSearchBox1 = "searchTextBoxUserView";
	public String lblAllergy = "menuArrow";
	public String chkShowBox = "//div[@style='outline:none;']/input";;
	public String chkCasue = "causeOfDeathcheckbox";
	public String chkShowAll = "includeInactivecheckbox";

	// problem list
	public String lnkProblemList = "link=Problem List";
	public String lnkProblemListShowMore = "medicationsMoreDetails";
	public String lnkProblemListShowMoreArrow = "medicationsMoreDetails";
	public String lnkEncounterProblemList = "xpath=(//a[contains(text(),'Problem List')])[2]";
	public String lnkSummaryEncounterProblemList = "//a[contains(text(),'Problem List')]";
	public String noSignificantProbList = "noEntryCheckboxcheckbox";
	public String btnDeleteProblemLisr = "//div[@id='ProblemsList']/table/tbody/tr/td[4]/div/a";
	public String btnPrbEditSave = "xpath=(//a[contains(text(),'Save')])[2]";
	public String txtUsername = "//div[@id='printInfo']/div/div/div/div/div[5]";
	public String txtMedicatl = "medicalConditionTextBox";
	public String txtResolvedDate = "resolvedDate";
	public String ajxItem = "itemStatusInputsuggestBox";
	public String lblProblemDetails = "//div[4]/div/div/div/div/div";
	public String lblNoProblemList = "//div[3]/div[2]/div/div/div/div";
	public String lblPbmDetails1 = "//div[3]/div[2]/div/div/div/div/div/div[3]/a";
	public String lblPbmDetails2 = "//div[3]/div[2]/div/div/div/div/div/div[2]/div[3]/span";
	public String lblEnSumDetails = "xpath=(//span[contains(@id,'problems')])";
	public String lblEnSumDetails1 = "//div[3]/div[2]/div/div/div/div/div/div[2]/div/span/div";
	public String lnkViewRegistration = "//a[@id='patientOptionsRegistration']/span";
	public String lblEnSumDetails2 = "//div[3]/div[2]/div/div/div/div/div/div/span/b";
	public String lblEnSumDetails3 = "//div[3]/div[2]/div/div/div/div/div/div[2]/div/span/span";
	public String lblNoProblem = "//td[2]/div/div/div/div[3]/div[2]/div/div/div/div";
	public String lblPrbDetails1 = "//span/div/div[2]/div[2]/div";
	public String lblPrbDetails2 = "//span/div/div[3]/div";
	public String lblPrbDetails3 = "//span/div/div[3]/div[2]";
	public String lblEnPrbDetails = "//div[3]/div[2]/div/div/div/div/div";
	public String lblEnPbmDetails1 = "//span/div/div[2]/div[5]";
	public String lblEnPbmDetails2 = "//span/div[2]/div/div[2]";
	public String lblEnPbmDetails3 = "//div[2]/div/div[2]/span";
	public String lblPbmUser = "//div[5]/table/tbody/tr[2]/td[2]/div/div/div/div/div[2]/div";
	public String chkPbmShowBox = "//div[@id='ProblemsList']/table/tbody/tr/td/div/input";
	public String tabMedical = "css=#medicalConditionTextBox";
	public String tabItem = "css=#itemStatusInputsuggestBox";
	public String tabResolve = "css=#resolvedDate";
	public String tabCodeingSys = "css=#codingSystemsuggestBox";

	// allergy
	public String lnkAllergy = "link=Allergies";
	public String lnkEncounterAllergy = "xpath=(//a[contains(text(),'Allergies')])[2]";
	public String lnkAllergyEdit = "//a[contains(text(),'Edit')]";
	public String lnkAllergyShowmore = "medicationsMoreDetails";
	public String lnkAllShowmore = "medicationsMoreDetails";
	public String chkAllergy = "//td/div/input";
	public String chkInto = "intoleranceradio";
	public String chkSelectListBox = "css=div > input[type='checkbox']";
	public String noKnownDrugAllergies = "nkdaCheckboxcheckbox";
	public String txtOnset = "onsetDate";
	public String txtcomment = "summaryComment";
	public String txtReasonToOverride = "xpath=(//input[@type='text'])[13]";
	public String rdoStopMed = "//td/span/input";
	public String rdoOverrideMed = "//td/span[2]/input";
	public String ajxSearchAllergy = "searchAllergyTextBox";
	public String ajxAllergyReaction = "reactionLink";
	public String btnNo="no";
	//public String btnCancelChartDis="cancelbutton";
	public String btnAllergy="saveAddAllergy";


	public String chkReaction="1checkboxAllergyReaction";
	public String lnkClose="multiSelectionCloseButton";
	public String lblAllergyReaction="xpath=(//span[contains(@id,'AllergyReaction')])";
	public String chkAllergyReaction="xpath=(//input[contains(@id,'checkboxAllergyReaction')])";
	public String lnkSelectionClose="multiSelectionCloseButton";
	public String ajxSeverity = "severitysuggestBox";
	public String ajxStatus = "statusSuggestBoxsuggestBox";

	public String ajxlifeStage = "lifeStagesuggestBox";
	public String ajxAllergyPopup = "css=div.item.item-selected";
	public String btnSummaryCancel = "xpath=(//button[@id='cancel'])[2]";
	public String btnCancelSummaryProblemList = "cancelProblemList";
	public String btnDeleteAllergy = "//a[contains(text(),'Delete')]";
	public String btnDeleteImmunization = "//a[starts-with(@id,'Delete')]";
	public String btnAdd = "//button[@id='add']";
	public String btnAddProvider = "addProvider";
	public String btnCancelProvider = "cancel";
	public String btnUpdate = "Update";
	public String btnSaveAllergyInteraction = "xpath=(//button[@id='save'])[2]";
	public String btnCancelAllergyInteraction = "xpath=(//button[@id='cancel'])[2]";
	public String lblEncounterSignedList="EncountersSignedList";
	public String btnChartEdit = "saveEditProcedures";
	public String btnSummaryEdit = "xpath=(//button[@id='save'])[2]";
	public String btnAllergyQuickList = "AllergyQuicklistButton";
	public String lblAddAllergyContainer = "css=div.addContainer";
	public String lblCollapseViewFamily = "//a[starts-with(@id,'familyHistoryExpandAnchor')]";
	public String lblCorresQue ="xpath=//div[contains(@id,'workQueueItem1')]";

	public String lblQuickValue = "css=span.gwt-InlineLabel";
	public String lblQuickValue1 = "css=span.gwt-InlineLabel.descriptionLabel";
	public String lblCollapseView = "//div[5]/table/tbody/tr[2]/td[2]/div/div/div/div/div/div[2]";
	public String lblCollapseView1 = "//div[2]/table/tbody/tr/td[2]/div/div//div[starts-with(@id, 'collapsableTitle')]";
	public String lblCollapseViewArrow = "menuArrow";
	public String lblAllergyExpendView1 = "//td[2]/div/span/div[2]";
	public String lnkAllergyExpandArrow = "//a[starts-with(@id,'allergyExpandAnchor')]";
	public String lblAllergyLife = "//td[2]/div/span/div[2]/div";
	public String lblAllergyExpandDate = "//span/div[2]/div[2]";
	public String lblAllerfyDateTime = "//td[2]/div/span/div[2]/span";
	public String lblAllergyDetails = "//div[2]/div[2]/div/div/div/div/div";
	public String lblAllergyDetails1 = "//td/div/div/div[2]/div/div/div/div";
	public String lblEncounterAllergy = "//a[contains(text(),'Allergies')]";
	public String lblEnDetails1 = "//div[8]/div[2]/div/div/div/div/div/div[3]/a";
	public String lblEncouterAllergyDetails = "//div[4]/div/div/div[4]/div/div";
	public String lblAllergyInteractionWindow = "//html/body/div[5]/div/div/div";
	public String lblAllergyInteraction = "//html/body/div[5]/div/div/div[2]";
	public String lblAllergyCollapseView = "//div[starts-with(@id, 'collapsableTitle')]";
	public String lblAllergyExpandView = "//div[@id='AllergyList']/table/tbody/tr/td[2]/div";
	public String taballergy = "css=#allergyradio";
	public String tabIntolerance = "css=#intoleranceradio";
	public String tabSearchAllergy = "css=#searchAllergyTextBox";
	public String tabReaction = "reactionLink";
	public String tabSeverity = "css=#severitysuggestBox";
	public String tabStatus = "css=#statusSuggestBoxsuggestBox";
	public String tabOnset = "css=#onsetDate";
	public String tablifeStage = "css=#lifeStagesuggestBox";
	public String tabComment = "css=#summaryComment";
	public String lblAllergyDetails2 ="//div[@class='lineHeight150']";
	public String lblAllergyExpandDate1="//div[@id='chartListItemHiddenDetails']/div";
	public String lblAllergyLife1="//div[@id='chartListItemHiddenDetails']/span";
	public String btnEdit1="xpath=(//a[contains(text(),'Edit')])";
	public String lblAllergyUpdatetime="lastUpdatedBy";
	public String injectiomSumArrow="xpath=(//div[@id='displayRow']/div[3]/a)[8]";

	// SummaryMedication



	public String btnholdreason="xpath=(//div[@id='panel']/input)[2]";
	public String lblEncounterMediDetails="css=div.chart-list-item-left-wrapper > div";
	//fixme=

	public String lnkEncounternoteMedi="//a[contains(text(),'Medications')]";		

	public String lblMedication = "MedicationTitle";
	public String lnkMedicationSummary = "medicationSummaryWidget";
	public String lnkEncounterMedication = "xpath=(//a[contains(text(),'Medications')])[2]";
	public String txtQuantity="//div[3]/div/div/div/div/div/div/div[2]/div/input";

	public String lnkMedication = "link=Medication";
	public String lnkMedsShowMore = "medicationsMoreDetails";
	public String lnkExpand = "link=Expand all";
	public String lblMedsDetails = "//span/span/div/div/span";
	public String lblMedsData = "//div[3]/a";
	public String lblSumMeds = "//div[5]/div[2]/div/div/div/div/div";
	public String lblMedsCollapseDetails = "menuArrow";
	public String dication = "//td[2]/div/div/div[3]/div/div[3]/div";
	public String lblEncouterMedsDetails = "//span/div/div/span";
	public String lblEnMeds = "css=span.pointer > div.inlineBlock > div";
	public String lblMedsExpand = "//span/div[2]";
	public String lblNoSignificant = "//div[6]/table/tbody/tr[2]/td[2]";
	public String lblMedsDetails1 = "//div[2]/div/span[2]";
	public String lblMedsDetails2 = "//span/div/div[2]/div[2]/span";
	public String lblMedsDetails3 = "//span/div[2]/div/div";
	public String lblSumMedsDetails = "//span/div/div/span[2]";
	public String lblSumMedsDetails1 = "//div[2]/div/span/div/div/span";
	public String lblSumMedsDetails2 = "//span/div/div[2]/span";
	public String lblSumMedsDetails3 = "//div[3]/span/div/div";
	public String lblSumMedsDetails4 = "//div[5]/div[2]/div/div/div/div/div/div[3]/a";
	public String lblEncounterMedication = "xpath=(//div/a[contains(text(),'Medications')])[2]/following-sibling::div/span";
	public String ajxSearchMedication = "medicationSuggestBox";
	public String chkFreetextBox = "enterAsFreeTextcheckbox";
	public String chknsmhBox = "nsmhCheckboxcheckbox";
	public String chkInDeDosecheckBox = "increaseDecreaseDosecheckbox";
	public String chkMultipleCheckBox = "multipleDirectionscheckbox";
	public String chkSaveListBox = "css=#saveListcheckbox";
	public String ChkboxNochange="//div[3]/div[2]/div/div/div/div[2]/div/span/input";
	public String txtStartOn = "startedOn";
	public String txtSupply = "supplyOnHand";
	public String txtPrescribedOn = "prescribedOn";
	public String txtRefill = "refills";
	public String txtPrescribedBy = "prescribedBy";
	public String txtRefilledOn = "lastRefilledOn";
	public String txtFreeBox = "freeTextArea";
	public String btnQuickMedication = "medicationQuickListButton";
	public String ajxMedsQuickCa = "//body/div[5]/div/div/div/div/div";
	public String ajxMedsQuickUs = "//body/div[4]/div/div/div/div/div";
	public String tabMedication = "css=#medicationSuggestBox";
	public String tabStartedon = "css=#startedOn";
	public String tabSupply = "css=#supplyOnHand";
	public String tabPrescribeon = "css=#prescribedOn";
	public String tabrefill = "css=#refills";
	public String tabPrescribedBy = "css=#prescribedBy";
	public String tabLastRefill = "css=#lastRefilledOn";
	public String tabComments = "css=#comment";
	public String tabInMethod = "css=#refillMethodSuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";
	public String tabInQuantity = "css=#refillQuantitySuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";
	public String tabInUnit = "css=#refillUnitSuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";
	public String tabInRoute = "css=#refillRouteSuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";
	public String tabInFrequency = "css=#refillFrequencySuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";
	public String tabInDuration = "css=#refillDurationSuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";
	public String tabInUsage = "css=#refillUsageSuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";
	public String tabInUsage1 = "css=#refillUsageSuggestBoxFillQuantityIncreaseDecreaseDoseDirectionsuggestBox";
	public String tabInDurationNo = "css=#durationNumberID";
	public String tabInUsage2 = "css=#refillUsageSuggestBoxDurationIncreaseDecreaseDoseDirectionsuggestBox";
	public String tabInUsage3 = "css=#refillUsageSuggestBoxQuantityIncreaseDecreaseDoseDirectionsuggestBox";
	public String tabInUsage4 = "css=#refillUsageSuggestBoxActionIncreaseDecreaseDoseDirectionsuggestBox";
	public String tabMDMethod = "css=#refillMethodSuggestBoxMultiDirectionssuggestBox";
	public String tabMDQuantity = "css=#refillQuantitySuggestBoxMultiDirectionssuggestBox";
	public String tabMDUnit = "css=#refillUnitSuggestBoxMultiDirectionssuggestBox";
	public String tabMDRoute = "css=#refillRouteSuggestBoxMultiDirectionssuggestBox";
	public String tabMDFrequency = "css=#refillFrequencySuggestBoxMultiDirectionssuggestBox";
	public String tabMDDuration = "css=#refillDurationSuggestBoxMultiDirectionssuggestBox";
	public String tabMDUsage = "css=#refillUsageSuggestBoxMultiDirectionssuggestBox";
	public String tabMDMethod1 = "css=#refillMethodSuggestBox1MultiDirectionssuggestBox";
	public String tabMDQuantity1 = "css=#refillQuantitySuggestBox1MultiDirectionssuggestBox";
	public String tabMDUnit1 = "css=#refillUnitSuggestBox1MultiDirectionssuggestBox";
	public String tabMDRoute1 = "css=#refillRouteSuggestBox1MultiDirectionssuggestBox";
	public String tabMDFrequency1 = "css=#refillFrequencySuggestBox1MultiDirectionssuggestBox";
	public String tabMDDuration1 = "css=#refillDurationSuggestBox1MultiDirectionssuggestBox";
	public String tabMDUsage1 = "css=#refillUsageSuggestBox1MultiDirectionssuggestBox";
	public String tabMethod = "css=#refillMethodSuggestBoxsuggestBox";
	public String tabQuantity = "css=#refillQuantitySuggestBoxsuggestBox";
	public String tabUnit = "css=#refillUnitSuggestBoxsuggestBox";
	public String tabRoute = "css=#refillRouteSuggestBoxsuggestBox";
	public String tabFrequency = "css=#refillFrequencySuggestBoxsuggestBox";
	public String tabDuration = "css=#refillDurationSuggestBoxsuggestBox";
	public String tabUsage = "css=#refillUsageSuggestBoxsuggestBox";

	// Social History
	public String lnkSocialHistory = "link=Social History";
	public String lnkEncounterSoicalHistory = "xpath=(//a[contains(text(),'Social History')])[2]";
	public String lnkSocialShowMore = "medicationsMoreDetails";
	public String lnlSocialArrow = "menuArrow";
	public String ajxType = "typeSuggestBoxsuggestBox";
	public String ajxOtherType = "otherType";
	public String ajxPeriod = "periodSuggestBoxsuggestBox";
	public String ajxStopped = "stoppedOngoingSuggestBoxsuggestBox";
	public String ajxLifeStage = "lifeStageSuggestBoxsuggestBox";
	public String txtSocialQuickList = "socialHistoryQuicklist";
	public String txtdetailsBox = "detailsTextBox";
	public String txtDetailsNumBox = "detailsNum";
	public String txtDetailsSmallBox = "detailsSmallTextBox";
	public String txtYear = "year";
	public String txtStartAge = "startAge";
	public String txtStopAge = "stopAge";
	public String btnDeleteSocial = "//div[@id='SocialHistoryList']/table/tbody/tr/td[4]/div/a";
	public String btnSaveSocial = "link=Save";
	public String lblEnSocialDetails = "xpath=(//div[contains(@id,'collapsableTitle')])";
	public String lblEnSocialDetails1 = "//div[2]/div/div/div/div/div/div/span/div/div";
	public String lblSocialDetails = "//div[7]/div[2]/div/div/div/div/div/div[2]/div/span";
	public String lblSocialDetails1 = "//div[7]/div[2]/div/div/div/div";
	public String lblSocialDetails2 = "//td[2]/div/span/div/div[2]/div/span";
	public String imgSocailarrow = "//div[7]/div[2]/div/div/div/div/div/div[3]/a";
	public String tabtype = "css=#typeSuggestBoxsuggestBox";
	public String tabSocial = "css=#socialHistoryQuicklist";
	public String tabDetailsTextBox = "css=#detailsTextBox";
	public String tabYear = "css=#year";
	public String btnDeleteProlist="deleteproblemEdit";
	public String tabStartAge = "css=#startAge";
	public String lnkCurrentItem1="xpath=(//div[contains(@id,'currentItem')])";
	public String btnSocialHistorysave ="saveSocialHistory";
	public String tabStopped = "css=#stoppedOngoingSuggestBoxsuggestBox";
	public String tabSociallifeStage = "css=#lifeStageSuggestBoxsuggestBox";
	public String arrowSocialHistory = "//tr[7]/td/div/div/div[2]/div/div/div/div/div/div[3]";
	public String lblSocialHistoryCollapseView = "//tr[7]/td/div/div/div[2]/div/div/div/div";
	public String btnSOSave = "xpath=(//a[contains(text(),'Save')])[2]";
	public String lnkSocDelete="//a[contains(@id,'Delete')]";
	public String btnEncounterNoteSign="signencounterNote";
	// MedicationTab

	//	publicÃ¯Â¿Â½StringÃ¯Â¿Â½ajxHoldReasonSuggest="xpath=(//div[@id='panel']/input)[2]";	

	public String MedicationReleaseButton="release";
	public String HoldReasonSuggest="xpath=(//div[@id='panel']/input)[2]";
	public String ajxReleasereasonSuggest="xpath=(//input[@id='suggestBox'])[2]";
	public String AddMedi="add";
	public String ChkBoxSelectAmmMedi="gwt-uid-4000";
	public String lblStopedMedi="css=div.med-alert.blue";
	public String lblStopedMedi1="//span[2]/span/div/div[3]";
	public String lnkMedicationTab = "!chartMedications";
	public String lnkMedicationTab1 ="!chartMedications";
	
	public String lnkMoreTab = "link=More";
	public String lnlCuEdit = "//div[2]/div/div/div/div/span[2]/button";
	public String btnViewFullInteraction = "viewFullInteraction";
	public String ajxMedShow = "suggestBox";
		
		public String lblCureentMedsname = "itemTitleCurrent1";
		public String iconWarning="//div[@id='mainPanel']/div/div[2]/div/a";
	public String lnkRestart = "link=Restart";
	public String lblHistoryMedsname = "//tr[3]/td/div/div[2]/table/tbody/tr/td/div/span/div";
	public String lblPrescibe = "mainPanelCurrent1";
	public String lblCuPrescribe = "xpath=(//div[@id='mainPanelCurrent1'])[2]";
	public String lblStopPrescribe = "//div[@id='Medications']/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr/td/div/span/div";
	public String lblRun = "css=span.listMedicationEnd";
	public String btnCureentEdit = "//tr[2]/td/div/div[2]/table/tbody/tr/td[2]/div/div";
	public String lnkHistory = "//div[5]/div/div/a/span";
	public String btnMedsDelete = "//div[3]/div/div/div[2]";
	// pending Medication
	public String btnAddToPending = "addToPending";
	public String lblAddMeds = "css=td.dialogMiddleCenter";
	public String lblMedsPrescribe = "//p/span[2]";
	public String lnkOption = "//a[starts-with(@id,'pendingAction')]";
	public String lnkOptionDelete = "//a[3]/span";
	public String lnkOptionEdit = "//a[2]/span";
	public String lnkOption1 = "link=Actions";
	public String lblpendingmeds = "//div[@id='Medications']/table/tbody/tr/td/div/div[2]/table/tbody/tr/td/div/span/div";
	public String lnkPendingSign = "//div[4]/div/div/a/span";
	public String lnkAddPending = "//div[4]/div/div/div[5]";
	public String lnkPendingDlete = "//body/div[4]/div/div/div[5]";
	public String lnlPendingDelete = "//span[3]/button";
	public String lnkPendingDlete1 = "//body/div[4]/div/div/div[3]";
	public String txtDeleteReaseon = "writtenReason";
	public String lblValidationReason = "writtenReasonStr3";
	public String ajxDeleteReaseon = "xpath=(//input[@id='suggestBox'])[3]";
	public String btnContinue = "saveReason";
	public String lblSignedby="signedBy";
	public String lnkDrugs = "link=Drugs & Supplements";
	public String chkStopbox = "//td[2]/div/span/input";
	public String lblStop = "css=span.listMedicationDesc";
	public String lblStart = "css=span.listMedicationStart";
	public String lblMedname = "css=span.chart-list-item-title";
	public String lblpendingmeds1 = "//div[6]/div/div/div/div[5]";
	public String btnQuickListForInteractionWarning = "//tr[3]/td/div/div/div/div/button";
	public String lblStoppedMedication = "css=span.listMedicationDesc";
	public String lblResonForStoppingMedication = "//div[2]/div/div[4]";
	public String lblPendingPrecribeName = "css=span.chart-list-item-title";
	public String lblPendingDetail = "//tr[2]/td/div/span/div";
	public String lblPendingDetai2 = "//tr[2]/td/div/span/div[2]/div";
	public String lblMedicationDetails = "//span/div/div[2]";
	public String lnkPendingExpand = "link=Expand all";
	public String lnkPendingOption = "//div[2]/table/tbody/tr[2]/td[2]/div/div";
	public String lnkPendingDlete2 = "//div[5]/div/div/div[3]";
	public String lblAssessmentInEncounter = "//div[@id='printInfo']/div/div/div[3]/div/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/div[2]/div[5]/table/tbody/tr[2]/td[2]/div/div/div/div/div[4]/div/div/div[13]/div";
	public String lblAssessmentInSummary = "//td[2]/div/div/div/div/div/div/div[3]";
	public String lblPrescribeMedsdetails = "//div[@id='Medications']/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr/td/div/span/div[2]";
	public String lblMedsdetails = "drugName";
	public String lblPendingMedsDetails = "//div[2]/div/div/div[2]/div/table/tbody/tr/td/div";
	public String lblPendingMedsDetails1 = "//div/div[2]/div[2]/div";
	public String lblPendingMedsDetails2 = "//div[2]/table";
	public String lblSummaryProblemList = "Problem ListSectionItem";

	// CurrentMedication
	public String lnkCurrentEdit ="//a[starts-with(@id,'edit')]";
	public String lblCurrentMedication = "mainPanel";
	public String ajxQuikListOption = "//body/div[6]/div/div/div/div/div/div";
	// EncounterTab
	public String encounterOptions = "//div[contains(@id,'action')]";
	public String encounterDelete = "//body/div[5]/div/div/div";

	// prescribeMedication
	public String lblMedSearchResultXpath1 =  "//*[@id='printInfo']/div/div[3]/div/div[3]/div[2]/div[2]/div[2]/div/div[2]/div/div/div[3]/div[";
	public String lblMedSearchResultXpath2 = "]";		
	public String lnkMedNameResultXpath1 = lblMedSearchResultXpath1;
	public String lnkPrimaryIngredientResultXpath1 = lblMedSearchResultXpath1;
	public String lnkPrimaryIngredientResultXpath2 = "]/div[1]/div[1]/div/a";	
	public String lnkMedNameResultXpath2 = "]/div[1]/span/a";
	public String lnkDrugClassResultXpath1 = lblMedSearchResultXpath1;
	public String lnkDrugClassResultXpath2 = "]/div[1]/div[2]/a";

	public String ajxAndThen = "andThenSuggestBoxIDsuggestBox";
	public String txtRefillDurationNo = "refillDurationNumberID";
	
	public String ajxRFDoNot = "doNotRefillDurationNumberID";
	public String chkWeight="weightCheckBoxcheckbox";
	public String chkExpires="scriptExpirescheckbox";
	public String imgPatient = "//img[@title='Patient']";
	public String btnSave = "link=Save";
	public String btnSaveProblemList = "saveProblemList";
	public String btnSaveProcedures = "saveProcedures";
	
	public String btnSave1 = "xpath=(//a[contains(text(),'Save')])[3]";
	public String btnSaveEditProblemList = "problemEditSaveButton";
	public String lblCompPackage = "//div[4]/i/span";
	public String btnEditEncounter = "link=Edit";
	public String btnEditLabOrder = "link=Edit";
	public String btnEdit = "edit";
	public String btnSend = "send";
	public String btnPrescribeCancel = "//div/div/div/div/div/div/button";
	public String btnContinueId = "continueID";
	public String btnOverride = "overrideButton";
	public String chkMed="css=a.medication-name";
	public String btnchangeMedication = "changeMedicationID";
	public String btnMedsCancel = "cancelID";
	public String btnCancel = "link=Cancel";
	public String btnCancelInjection = "cancelInjection";
public String btnunsignedsave="id=Continue";
	public String btnCancelProblemListEdit = "cancelProblemList";
	public String btnCancelProcedures = "cancelProcedures";
	public String btnEditCancel = "xpath=(//a[contains(text(),'Cancel')])[2]";
	public String btnCancelButton = "cancelButton";
	public String btnCancelButton1 = "cancelNewLabs";
	public String btnPrint = "print";
	public String btnRePrint = "reprint";
	public String btnRePrintSave = "save";
	public String btnResendCancel = "cancel";
	public String btnPrescibeQuick = "drugsQuicklistButton";
	public String btnFreeFrom = "xpath=(//button[@type='button'])[11]";
	public String btnPreviousPharmacy = "previousPharmacy";
	public String btnSearchDatabase = "searchDatabase";
	public String lnkEdit = "link=Edit";
	public String lnkCommentEdit = "LabReportsCommentEdit";
	public String lnlEdit1 = "xpath=(//a[contains(text(),'Edit')])[2]";
	public String lnlEdit2 = "xpath=(//a[contains(text(),'Edit')])[3]";
	public String lnkPrescribeDelete = "link=Delete";
	public String lnkPrescribeDelete1 = "xpath=(//a[contains(text(),'Delete')])[2]";
	public String lnkGoToPending = "//a[starts-with(text(),'Go to Pending Medications ')]";
	public String lnkApprove = "approveAll";
	public String lnkPatientOption = "link=Patient Options";
	public String lnkPatientInfo ="!patientInfoView";
	public String lnkcreateTase="//a[@id='patientOptionsCreateTask']/span";
	public String TaskDueInSuggestbox="xpath=(//input[@id='timeCountSuggestBoxsuggestBox'])[2]";
	public String AssignSuggestbox="assignToSuggestBoxsuggestBox";
	public String RequestSuggestbox="requestedBySuggestBoxsuggestBox";
	public String ReceptSuggestbox="recipientTypeSuggestBoxsuggestBox";
	public String DeliverySuggestbox="deliveryMethodSuggestBoxsuggestBox";
	public String ConsentSuggestbox="_consentNameSuggestBoxsuggestBox";
	public String TaskQueue="//div[@id='Tasks']/div";
	public String SelectRadio="includePartialChartradio";
	public String ShowFilterSuggestbox="showFiltersuggestBox";
	public String selectallcheckbox="selectAllTimelinecheckbox";
	public String TaskSelectitem="selectItems";
	public String Tasksuggestbox="taskTypeSuggestBoxsuggestBox";
	public String lnkExportChart = "patientOptionsExportChart";
	public String lnkPrescribeMedication = "patientOptionsPrescribeMedication";
	public String lnlAddToPending = "link=Add to Pending";
	public String lnlPendingEdit = "css=button.gwt-Button.width75";
	public String lnlPendingDelete1 = "//div[4]/div/div/div[3]";
	public String lblPendingDetails1 = "//div[6]/table/tbody/tr[2]/td[2]/div";
	public String lnkFreeFrom = "css=button.primary-button";
	public String lnlPopQuickList = "//div[4]/div/div/div/div/div/div/span";
	public String chkMultipleDirection = "multipleDirectionIDcheckbox";
	public String chkOneTimeOnly = "oneTimeOnlyIDcheckbox";
	public String chkFreeText = "freeTextIDcheckbox";
	public String chkIncreaseDecreaseDirection = "increaseDecreaseIDcheckbox";
	public String labPrescribeAllergen = "css=div.patient-allergy-alert-box";
	public String lblQukPrescribe = "css=div.inlineBlock.larger";
	public String lblPendingPrescribe = "css=div.paddingLeft10";
	public String lblPharmacy = "//div[6]/div/div[2]/table/tbody/tr/td/div/div/div";
	public String lblPharmacyDetails1 = "//div[4]/div[3]/div";
	public String lblPharmacyDetail2 = "//div[3]/div[2]";
	public String lblPharacyDetails3 = "//div[3]/div[3]";
	public String ajxProvider = "providerListSuggestBoxsuggestBox";
	public String ajxLoaction = "id=locationListSuggestBoxsuggestBox";
	public String allergyTitle="AllergiesTitle";
	public String ajxDrugsList = "drugsQuicklistBox";
	public String imgPrescribeStar = "//img[starts-with(@class,'gwt-Image marginRight')]";
	public String btnOverrideContinue = "continue";
	public String lblPrescribedata = "//div[14]";
	public String lblPrescribedata1 = "medicationListPanel";
	public String lblPrescribeDetails = "//div[5]/div/div/div/div[2]/div";
	public String txtOverride3 = "overrideReasonQuicklist";
	public String btnWarningQuickList = "overrideReasonQuicklistButton";
	public String lblReason = "//div[starts-with(@id, 'currentItem')]";
	public String lblNoMeds = "css=div.noDataLabel";
	public String lblNoPharmacyFound = "css=div.no-data-text";

	//FIXME VEL-6845
	public String graph ="//div[contains(@id,'graphFlowPanel')]/div";
	public String lblWeightInGraph = "xpath=(//div[contains(@id,'graphFlowPanel')]/div)[6]";
	public String lblHeightInGraph = "xpath=(//*[contains(@id,'graphFlowPanel')]/div)[7]";
	public String lblLbsInGraph = "xpath=(//*[contains(@id,'graphFlowPanel')]/div)[3]";
	public String lblBmiInGraph = "xpath=(//*[contains(@id,'graphFlowPanel')]/div)[4]";
	public String lblheadInGraph = "//div[@id='graphFlowPanel']/div/div/div/div[2]/div/div[5]/div/div";


	// IncreaseDecreaseDose
	public String ajxInRefillMethod = "refillMethodSuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";

	public String ajxInRefilUnit = "refillUnitSuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";
	public String ajxInRefillRoute = "refillRouteSuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";
	public String ajxInRefillFrequency = "refillFrequencySuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";
	public String ajxRefilUsage = "xpath=(//input[@id='refillUsageSuggestBoxIncreaseDecreaseDoseDirectionsuggestBox'])[2]";
	public String ajxInRefillUsage = "refillUsageSuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";
	public String ajxInRefillDuration = "refillDurationSuggestBoxIncreaseDecreaseDoseDirectionsuggestBox";
	public String ajxInUsage = "xpath=(//input[@type='text'])[26]";
	public String ajxinRefillQuantiti3="id=additionalIncDecFillQuantity";
	public String ajxInRefillQuantity = "xpath=(//input[@id='refillQuantity'])[2]";
	public String ajxInRefillUsage1 = "refillUsageSuggestBoxDurationIncreaseDecreaseDoseDirectionsuggestBox";
	public String ajxInRefillUsage2 = "refillUsageSuggestBoxQuantityIncreaseDecreaseDoseDirectionsuggestBox";
	public String ajaxInRefillUsage3 = "refillUsageSuggestBoxActionIncreaseDecreaseDoseDirectionsuggestBox";
	public String txtDuration = "durationNumberFirstID";
	public String txtDuration1 = "durationNumberEveryID";
	public String txtUntillReach="additionalIncDecFillQuantity2";
	public String btnMedicationEditSave="saveMedicationsEdit";
	// #fix me
	public String txtDuration3="xpath=(//input[@type='text'])[9]";
	public String txtDuration2="xpath=(//input[@type='text'])[29]";
	// MultiDirection
	public String ajxMDRefilMethod = "refillMethodSuggestBoxMultiDirectionssuggestBox";
	public String ajxMDRefillQuantity = "xpath=(//input[@id='refillQuantity'])[3]";
	public String ajxMDRefillUnit = "refillUnitSuggestBoxMultiDirectionssuggestBox";
	public String ajxMDRefillRoute = "refillRouteSuggestBoxMultiDirectionssuggestBox";
	public String ajxMDRefillFrequency = "refillFrequencySuggestBoxMultiDirectionssuggestBox";
	public String ajxMDRefillDuration = "refillDurationSuggestBoxMultiDirectionssuggestBox";
	public String ajxMDRefillUsage = "refillUsageSuggestBoxMultiDirectionssuggestBox";
	public String ajxMDMethod = "refillMethodSuggestBox1MultiDirectionssuggestBox";
	public String ajxMDQuantity = "refillQuantity1";
	public String ajxMDUnit = "refillUnitSuggestBox1MultiDirectionssuggestBox";
	public String ajxMDRoute = "refillRouteSuggestBox1MultiDirectionssuggestBox";
	public String ajxMDFrequency = "refillFrequencySuggestBox1MultiDirectionssuggestBox";
	public String ajxMDDuration = "refillDurationSuggestBox1MultiDirectionssuggestBox";
	public String ajxMDUsage = "refillUsageSuggestBox1MultiDirectionssuggestBox";
	public String lnkRefillOption="refillDisclosureText";
	public String txtRefillDispense="refillDispenseID";
	public String txtDateExpires="scriptExpiresDate";
	public String txtweight="weight";
	public String ajxWeighUnit="weightSuggestBoxsuggestBox";
	public String btnSaveMedication="saveMedications";
	// Normal
	public String ajxMethod = "refillMethodSuggestBoxsuggestBox";
	public String ajxQuantity = "refillQuantity";
	public String ajxUnit = "refillUnitSuggestBoxsuggestBox";
	public String ajxRoute = "refillRouteSuggestBoxsuggestBox";
	public String ajxFrequency = "refillFrequencySuggestBoxsuggestBox";
	public String ajxDuration = "refillDurationSuggestBoxsuggestBox";
	public String ajxUsage = "refillUsageSuggestBoxsuggestBox";
	// RefillDirection
	public String ajxrefillMethod = "refillMethodSuggestBoxsuggestBox";
	public String ajxRefillQuatity = "refillQuantitySuggestBoxsuggestBox";
	public String ajxRefillUnit = "refillUnitSuggestBoxsuggestBox";
	public String ajxRefillRoute = "refillRouteSuggestBoxsuggestBox";
	public String ajxRefillFrequency = "refillFrequencySuggestBoxsuggestBox";
	public String ajxRefillDuration = "refillDurationSuggestBoxsuggestBox";
	public String ajxRefillUsage = "refillUsageSuggestBoxsuggestBox";
	public String ajxUnitList = "unitListSuggestBoxsuggestBox";
	public String ajxRFDurationList = "durationListSuggestBoxsuggestBox";
	public String ajxRFMethod = "refillMethodSuggestBoxFillDirectionsuggestBox";
	public String ajxRFQuatity = "refillQuantitySuggestBoxFillDirectionsuggestBox";
	public String ajxRFUnit = "refillUnitListSuggestBoxsuggestBox";
	public String ajxRFRoute = "refillRouteSuggestBoxFillDirectionsuggestBox";
	public String ajxRFFrequency = "refillFrequencySuggestBoxFillDirectionsuggestBox";
	public String ajxRFDuration = "refillDurationSuggestBoxFillDirectionsuggestBox";
	public String ajxRFUsage = "refillUsageSuggestBoxFillDirectionsuggestBox";

	public String ajxSearch = "xpath=(//input[@id='searchTextBox'])[2]";
	public String txtNotesToPharmacy = "notesToPharmacyTextBoxId";
	public String txtDispense = "dispenseID";
	public String txtFreeFormText = "//div/div/div[2]/div/textarea";
	public String txtFillon = "fillOnID";
	public String txtofRefills = "ofRefillsid";
	public String txtDurationNo = "durationNumberID";
	public String txtDirectionNotes = "directionsNotesTextBoxId";
	public String txtSendTitle = "send@title";
	public String txtOverride = "overrideTextArea";
	public String txtMedsSearchTextBox = "searchTextBox";
	public String txtRePrintreason = "reason";
	public String txtRePassword = "password";
	public String txtFromZip = "fromZipText";
	public String chkFromZip = "fromZipradio";
	public String chkSubPermitted = "subPermittedcheckbox";
	public String chkComPackage = "comPackingcheckbox";
	public String ckkPrescribtionOption="prescriptionOptionsDisclosureText";
	public String chkSearchwithin = "searchWithinKmradio";
	public String chkSearchWithinMiles = "searchWithinMilesradio";
	public String chkPatient = "fromPatientradio";
	public String chkPractice = "fromPracticeradio";
	public String btnOptions = "link=Actions";
	public String lnkPrescribMedication="css=#patientOptionsPrescribeMedication > span";
	public String lnkAddToPending ="//a[starts-with(@id,'addToPending')]";
	public String btnUpdatepres="//button[starts-with(@id,'addToPending')]";
	public String btnMedsResend = "//div[7]";
	public String btnAddToPending1 = "//a[5]/span";
	public String btnAddToPendingDelete = "//a[3]/span";
	public String btnSearchPharmacy = "searchPharmacy";
	public String lblAddDirection = "css=i";
	public String lblPescirbeDetails = "//div[4]/div[2]";
	public String lblPrecrbeMeds = "//p[2]/span[2]";
	public String lblPrescribeMeds1 = "//p[3]/span[2]";
	public String lblPrescribeMeds2 = "//td[2]/div/div/div[4]";
	public String lblProviderName = "//div[5]/div[2]/div[2]";
	public String lblPatientName = "//div[@id='patientInfoPanel']/div";
	public String lblprescribeProviderName = "//div[5]/div[2]/div[2]";
	public String lblPrePatient = "//div[2]/div/div/div/div[4]/div/div";
	public String lblPrescribeData = "//div[2]/div/div/div/div[5]";
	public String lblPendingMedication = "//div[5]/table/tbody/tr[2]/td[2]/div/div/div/div/div/div";
	public String lblPendingDetails = "//div[5]/table/tbody/tr[2]/td[2]";
	public String lblPending1 = "xpath=(//button[@type='button'])[8]";
	public String lblPending2 = "xpath=(//button[@type='button'])[9]";
	public String lblWithRefill = "//div[9]/div[2]/div[2]";
	public String txtPassword = "//input[@type='password']";
	public String btnSignPassword = "css=span.buttons.marginLeft10 > button.gwt-Button";
	public String lblPendingsignoff = "//div[4]/div/table/tbody/tr[2]/td[2]";
	public String lblNoSearchresult = "css=span.gwt-InlineLabel";
	public String lblPrescribeMedsDetails = "//div[5]/div[2]/div/div/div/div";


	// MedsWarining

	public String imgDuplicateTherapy = "//div[starts-with(@id,'duplicateTherapySection')]/div/div/div/div/div";
	public String imgGeneralInteraction = "css=div.generalInteractionImg";
	public String imgFoodWarning = "//div[starts-with(@id,'otherSection')]/div/div/div/div/div";
	public String imgAllergyInteraction = "//div[starts-with(@id,'drugToAllergySection')]/div/div/div/div/div";
	public String lblAllergyIntWarning = "interactionLevel";
	public String lblWarningSeverity = "xpath=(//div[@id='interactionLevel'])[2]";
	public String lblWarningAllergen = "interactionName";
	public String lblWarningPrescribe = "xpath=(//div[@id='interactionName'])[2]";
	public String lblInteraction = "xpath=(//div[@id='interactionName'])[2]";
	public String lblFoodInteraction = "xpath=(//div[@id='interactionName'])[2]";
	public String lblWarning = "//div[2]/div/div/div[3]/div/div";
	public String lblWarning1 = "//div[2]/div/div[2]/div/div/div/div/a";
	public String lblWarning2 = "//div[5]/div/div/div";
	public String lblAllergyInteraction1 = "//div/div/div[2]/div/div/div/div/div/div/div/div";
	public String lblDuplicate = "//div[2]/div/div/div[2]/div/div/div/div/div";
	public String lblWarningReason = "//div[3]/div/div[2]/div";
	public String lalWarning4 = "//td[2]/div/div[2]";
	public String labSeverity = "//div[3]/div/div/div[2]/table/tbody/tr/td/div";
	public String lblIndication = "//div[3]/div/div[2]/table/tbody/tr/td/div";
	public String lblWarningReason1 = "//div[4]/div/div/div/div[2]/div/div";
	public String lblUser = "//div[4]/div[2]/div[2]/div";
	public String lblWarning5 = "css=li";
	public String lnlWarningEdit = "xpath=(//a[contains(text(),'Edit')])[2]";

	// Lab report
	public String lnkLabs="!chartLabReportsFlowSheet";
	public String lnkEnterData = "xpath=(//a[starts-with(text(),'Enter data')])";
	public String lnkLabSave = "LabReportsCommentSave";
	public String lnkHideComment = "LabReportsCommentHideComment";
	public String lnkOptions ="link=Options";
	public String lnkEditComment = "LabReportsCommentEdit";
	public String lnkCancelComment = "LabReportsCommentCancel";
	public String tabAccessNo = "css=#accessionNumberTextBox";
	public String tabRProvider = "css=#receivingProviderSuggestsuggestBox";
	public String tabOProvider = "css=#orderingProviderSuggestsuggestBox";
	public String tabLabReport = "css=#reportingLabSuggestsuggestBox";
	public String tabDate = "css=#collectionDateBox";
	public String tabTime = "css=#timeTextBox";
	public String tabNote = "css=#labNotes";
	public String tabLabTestName = "css=#testNameSuggestsuggestBox";
	public String tabResultBox = "css=#resultTextBox";
	public String tabLow = "css=#lowTextBox";
	public String tabHigh = "css=#highTextBox";
	public String tabUnits = "css=#unitsTextBox";
	public String tabNewLabComments = "css=#labComments";
	public String elementaccNumber = "accessionNumberTextBox";
	public String ajxRProvider = "receivingProviderSuggestsuggestBox";
	public String ajxOProvider = "orderingProviderSuggestsuggestBox";
	public String ajxNotifyDuration = "durationsuggestBox";
	public String ajxDurationUnit = "durationUnitsuggestBox";
	public String ajxLabName = "reportingLabSuggestsuggestBox";
	public String elementCdate = "collectionDateBox";
	public String elementOdate = "dateOrderedBox";
	public String elementCtime = "timeTextBox";
	public String elementNotes = "labNotes";
	public String ajxLabTestName = "testNameSuggestsuggestBox";
	public String elementResult = "resultTextBox";
	public String elementLow = "lowTextBox";
	public String elementHigh = "highTextBox";
	public String elementUnits = "unitsTextBox";
	public String elementComment = "labComments";
	public String btnActionLab = "//div[starts-with(@id,'unsignedLabItemAnchorDiv')]";
	public String btnSignActionLab = "//div[starts-with(@id,'signedLabItemAnchorDiv')]";	
	public String btnDeleteLab = "//div[starts-with(@id,'delete')]";
	//FIXME EMR774
	public String btnDeleteLab1 = "//body/div[5]/div/div/div";
public String lnkmedicationsearchresult="xpath=(//div[contains(@id,'medication')]/a)";
	public String lblCategoryTestName = "//div[@id='resultLine']/div[2]/div/div";
	public String lnkLabReportLink = "patientOptionsManualEntry";
	public String lnkActionsLink = "//div[contains(@id,'unsignedLabItemAnchorDiv')]";
	public String btnLabDelete = "button[@id='deleteReason']";

	public String lnkLabForward = "//div[2]/div/div/div[2]/table/tbody/tr/td/div";
	public String btnDeletebutton = "//a[contains(@id,'Delete')]";
	public String btnLabCancle = "//div[2]/div/div/div/table/tbody/tr/td/div";
	public String elementDeleteTestResult = "removeButton";
    public String labCountXpath="//a[contains(@id,'Enter data')]";
	public String elementSignedRecord = "signedLabdescription1";
	public String elementError = "css=li > div";
	public String elementLabOrderLink = "//img[@title='Order New Labs']";
	public String elementNewEncounterLink2 = "//div[5]/div/div/div[2]/div[2]";
	public String elementNewEncounterLink3 = "//body/div[4]/div/div/div[2]/div[2]";
	public String elementShowFilter = "suggestBox";
	public String elementLabSummary = "//div[contains(@class,'chart-content')]"; 
	public String elementAddTestResult = "addTestResult";
	public String elementLabTestName1 = "xpath=(//input[@id='testNameSuggestsuggestBox'])[2]";
	public String elementResult1 = "xpath=(//input[@id='resultTextBox'])[2]";
	public String elementLow1 = "xpath=(//input[@id='lowTextBox'])[2]";
	public String elementHigh1 = "xpath=(//input[@id='highTextBox'])[2]";
	public String elementUnits1 = "xpath=(//input[@id='unitsTextBox'])[2]";
	public String elementComment1 = "xpath=(//textarea[@id='labComments'])[2]";
	public String elementAbnormalLabel = "//td/span";
	public String elementAbnormalResultLabLabel = "labTestResultAbnormal";

	public String elementLabReportEntryOnSummery = "//td[3]/span";
	public String elementPartial = "partialRadioButton";
	public String elementAbnormalResultFinalLabel = "fileLabReportAbnormal";
	public String elementLabReportEntry = "//span[@id='unsignedLabdescription1']";
	public String elementLabReportEntry1 = "//span[contains(@id,'description')]";
	public String elementLabResltCheckBox = "//div[2]/table/tbody/tr/td/div";
	public String elementLabResltCheckBox1 = "xpath=(//span[@id='checkBox']/input)[2]";
	public String elementLabGraph = "graph";
	public String elementLabTestName2 = "//div[2]/div[2]/div/div[2]/div";
	public String elementLabReportChart = "chart";
	public String elementAlert = "css=div.large.dark";
	public String elementCommentIcon = "addCommentIcon";
	public String elementCommentIconInResult = "//div[@id='addCommentIcon']";
	public String elementCommentText = "LabReportsCommentCommentBox";
	public String elementCommentText1 = "DEFAULTCommentBox";
	public String elementShowAllComments = "link=Show all comments";
	public String elementHideAllComments = "link=Hide all comments";
	public String elementDeleteReports = "deleteLabReports";
	public String elementHideShow = "//a/table/tbody/tr/td[2]";
	public String elementSpecimenShowHide = "specimenDetailsText";
	public String elementLabReportDetails1 = "nameInfoReport";
	public String elementLabReportDetails2 = "//div/div[2]/div/table/tbody/tr[2]/td/div/div";
	public String elementLabReportDetails3 = "resultLine";
	public String elementLabHistory = "//div[8]/div/div/div/div[5]/div";
	public String elementErrorClose = "errorCloseButton";
	public String elementReportCommentsIcon = "id=addCommentIcon";
	public String btnSocialEditSave ="saveSocialHistoryEdit";
	public String lnkSaveComments = "LabReportsCommentSave";
	public String lnkCancelComments1 = "LabReportsCommentCancel";
	public String lnkHideComments = "LabReportsCommentHideComment";
	public String lnkSaveDiOrderCommetns="saveCommentDiagImaging";
	public String lnkCancelDiOrderCommetns="cancelCommentDiagImaging";
	public String lnkHideDiOrderCommetns="hideCommentDiagImaging";
	public String txtDiOrderComments = "//textarea[@id='commentBox']";

	public String elementViewHistory = "LabReportsCommentViewHistory";
	public String elementShowComments = "link=Show Comments";
	public String elementCancelComments2 = "LabReportsCommentCancelViewHistory";
	public String elementHistoryOfComments = "css=blockquote.commentsBubble";
	public String elementDateForComments = "//blockquote/div[2]/div/div";
	public String elementLabResltCheckBox2 = "xpath=(//span[@id='checkBox']/input)";

	// Lab Graph

	public String lblLabGraphMain = "//td/div/div[2]/div/div/div/div[2]/div";
	public String lblLabGraphER = "//div[4]/div/div/div[3]/div[2]/div/div[2]";
	public String lblLabGraphER1 = "//div[2]/div/div[4]";

	public String lnkLabtab = "id=ListViewTab";

	// Patient Handouts
	public String elementPatienHandOutLink = "//img[@title='View Handouts']";
	public String elementNoAssessmentLabel = "css=span.gwt-InlineHTML";

	public String ajxSearchtext = "searchtext_primary";
	public String lnkSearch = "css=input.searchgo";
	public String lblPatient = "css=div.content";
	public String lblHandoutsPrescribe = "//div[6]/table/tbody/tr[2]/td[2]/div/div/div[3]";
	//FIXME MNT-1212
	public String lblHandsMedicalCondition = "css=span.bold.break-word";
	public String lnkDurgs = "link=Drugs & Supplements";
	public String lnkViewHandout = "link=View Handout";
	public String lnkMoreOption = "xpath=(//a[contains(text(),'More')])[2]";
	public String lnkIndication = "id=section_1";
	public String lnkContraindication = "Contraindications";
	public String lnkWarning = "id=section_3";
	public String lnkAdverse = "id=Adverse Effects";
	public String lnkDrugInteraction = "id=Overdose";
	public String lnkActionClinical = "id=Supplied";
	public String lnkStorage = "Storage and Stability";
	public String lnkDosage = "Dosage Forms, Composition and Packaging";

	// Begin Encounter]
	
	 public String txtDistance="distance";
	public String savedEncounter = "//div[5]/div/div/table/tbody/tr/td/div/div/table/tbody/tr";
	public String lblPendingEncounterlist="css=div.inline-block.width320 > div > span.bold";
	public String chiefComplaint = "id=chiefComplaintBox";
	public String ajxProviderSugBox="providersuggestBox";
	public String chiefComplaintText = "chiefComplaintNote";
	public String chiefComplaintTextBox = "css=input.gwt-TextBox";
	public String ajxEncounterProvider = "providersuggestBox";
	public String btnBeginEncounter = "BeginEncounterButton";
	public String btnSaveImmunization ="saveImmunization";
	public String btnDone = "done";
	public String lnkEncounterAction = "actionAnchorEncounter";
	public String lnkStartNewWncouter = "beginNewEncounter";
	public String lnkUnsignedEncounter = "//div[3]/div/div/span[2]";
	public String lnkAssessment = "//div[2]/div/span";
	public String lnkAssessmentData = "//div[5]/div/div/div/div/div";
	public String lblEncounterChoosePanel = "xpath=(//div[@class='popupContent'])";
	public String lblAssessmentDetails = "//div[2]/div/div[3]/span";
	public String lblEncounterData = "xpath=(//span[contains(@id,'lineTitle')])";
	public String lblEnDetails = "//div[8]/div[2]/div/div/div/div/div";
	public String lblEncounterDetail1 = "//span[contains(@id,'lineTitle')]";
	public String lblEncounterDetail2 = "mainPanel";
	public String lblAssessment1 = "//div[5]/div/div/a/span";
	public String lblNote = "//td[2]/div/div/div[2]/div";
	public String ajxAssessmentSearch = "assessmentSearchBox";
	public String ajxAssessmentSearch2 = "xpath=(//input[@id='assessmentSearchBox'])[2]";
	public String lnkInj = "6";

	public String ajxBillToPayer = "billToPayersListSuggestBoxsuggestBox";
	public String imgPrescribeMedsIcon = "//img[@title='Prescribe Medication']";
	public String imgPrescribe = "//a[2]/img";
	public String imgReferrence = "//img[@title='References']";
	public String lnkEncounterLink2 = "//div[5]/div/div/div[2]/div[2]";
	public String lnkBeginEncounterAction = "actionAnchorEncounter";
	public String saveAllergyButton="saveAllergyButton";
	public String lnkReference = "referencesAction";
	public String txtLnkRefrence = "enterLinkData";	
	public String txtUrl = "css=input.text-box";
	public String inkUnSignedEnCounterAction = "xpath=(//div[contains(@id,'action')])";
	public String lnkDeleteEncounter = "//div[contains(@id,'encounterDelete')]";
	public String lnkDeleteReason = "//button[contains(@id,'deleteReason')]";
	public String lnkBeginEncounterCancel = "//a[contains(@id,'cancelEncounter')]";
	public String lnklabHistoryReports = "labHistoryLabReports";
	public String lnlPrintsend = "link=Print/Send";
	public String lblEncounterAllergyDetails = "//span[contains(@id,'allergy')]"; 
	public String btnEncoudeleteAllerge="//a[@id='deleteAllergy']";
	public String lstActionSaveEncounter = "//a[@id='saveEncounter']";  
	public String lnkEncounterPendingList="//div[contains(@id,'EncountersPendingList')]/table/tbody/tr";
	
	public String lstUnsignedEncShow = "currentItem_1";  
	public String lstUnsignedEncShow1 = "currentItem_2";
    public String lstUnsignedEncShow2 = "currentItem_3";

	public String lblPreviewPrescrib="prescriptionPreviewWrapper";
	public String btnEncouterCancle = "cancelEncounter";
	public String btnApply = "apply";
	public String btnRefileSave="saveAnchor";
	public String btnReport="link=View report";
	public String btnConClose="link=Close";
	public String lblSignedEncounter = "//div[contains(@id,'collapsableDesc')]";
	public String BeginEncounter = "BeginEncounterButton";
	public String action = "actionAnchorEncounter";
	public String lblEncounterSave = "//a[@id='saveEncounter']/span";
	public String lnkProblemListTitle = "ProblemListTitle";
	public String lblAssess = "//span[contains(@id,'detailPanel')]";

	public String lnkpatientchart="//a[@id='patientOptionsChartView']/";
	public String chkImmunization="Immunizations_Circle";
	public String lblEncounterQueueDate="css=div.smallPlus.reallyLighter ";

	public String lblPendingEncounter = "//div[@id='EncountersPendingList']/table/tbody/tr/td";
	public String imgProcedureIcon = "//img[@title='Add New Procedure']";
	public String imgDiOrderIcon = "//img[@title='Order New Diagnostic Imaging']";
	public String imgLabOrderIcon = "//img[@title='Order New Labs']";
	public String imgReferralIcon = "//img[@title='Add New Referral']";
	public String imgIjnectionIcon = "//img[@title='Add New Injection']";
	public String imgImmunizationIcon = "//img[@title='Add New Immunization']";
	public String imbPrescribeIcon = "//div[3]/div/img";
	public String ajxAssessment = "//div[5]/div/div/div/div/div/div";
	public String lblAssessment = "xpath=(//span[contains(@id,'problems')]/span)";
	public String btnAssessmentedit  ="//a[@id='edit']/span";
	public String lnkImmunEncounterdetails ="//span[contains(@id,'immunization')]";
	public String btnImmEditSave = "saveImmunizationEdit";
	public String btnInjectsave ="saveInjection";


	public String btnInjectionEditsave ="saveInjectionEdit";
	public String lblHighlightAssessment = "css=input.gwt-TextBox.fullWidth";
	public String lblEnLabDetails = "//span/div[2]/div/div[3]";
	public String txtUnsignedEncounterDate = "css=input.gwt-DateBox";
	public String lnkViewChart = "patientOptionsChartView";
	public String lnkDelete = "link=Delete";
	public String lnkUnSigned = "Unsignedencounters";
	public String lnkUnSignedlist = "unsignedEncounterListItem";
	public String lnkRunWizard = "//a[@id='runWizardAction']/span";
	public String lblComplaintEncounter = "//div[2]/table/tbody/tr/td/div";
	public String lblComplaintEncounter1 = "//div[2]/table/tbody/tr/td/div/div";
	public String lnkNext = "next";
	public String lnkDone = "done";
	public String chkLastRunWizardbutton = "//div[2]/div[9]/div/div/div";
	public String chkPrePareNote = "//div[@id='BlueNavigationWiget_MainPanel']/div[2]/div[2]/div/div/a";
	public String btnCosignDelete="//a[@id='delete']/span";
	// Order Diagnostic Image
	
	public String lnkLabDiDelete = "//a[contains(text(),'Remove')]";
	public String ajxTestName = "labTestNameSuggestBox";
	public String ajxLabFacility = "labFacilitySuggestBoxsuggestBox";
	public String txtLabComments = "labsComments";
	public String txtLabTestComments = "LabReportsCommentCommentBox";
	public String btnSignDiagnostic = "signDiagnosticImaging";
	public String btnDiagnosticSave = "saveDiagnosticImaging";
	public String btnDiagnosticCancel="cancelDiagnosticImaging";
	public String btnOk = "okButton";
	public String lblNeedtoSelected = "css=div.large.dark";
	//#FIXME EMR-1292
	public String lblDiorder = "//div[2]/div/a[2]/span[1]";


	public String labDiLink="encDIAction";
	public String labDiView="view";
	public String lblDiDetails = "//div[2]/div/a[2]";
	public String lblDiorderDetails = "//td[2]/div/div/div/div/div[2]/div/div/a";
	public String lblLabTestName = "xpath=//span[contains(@id,'lineTitle')]";
	public String imbCommentIcon = "//div[2]/div/div/div[2]/div/div/div[2]/a";
	public String tabTestName = "css=#labTestNameSuggestBox";
	public String tabLabComments = "css=#labsComments";
	public String tabLabFacility = "css=#labFacilitySuggestBoxsuggestBox";
	// Order New Lab
	public String btnEditLab="//a[@id='edit']/span";
	public String btnDeleteLabOrder="//a[@id='delete']/span";
	public String ajxTestName1 = "templateListSuggestBoxsuggestBox";
	public String ajxCopyTo = "copyToSuggestBoxsuggestBox";
	public String ajxPrintOn = "requisitionTypeSuggestBoxsuggestBox";
	public String ajaxPayer= "payerSearchSuggestBoxsuggestBox";
	public String txtComments = "comments";
	public String txtAuthorization = "authorization";
	public String btnOrderNewSign = "signNewLabs";
	public String btnNewSave = "saveNewLabs";
	public String btnNewSave1="//a[@id='save']/span";
	public String lnkAction="actionAnchor";
	public String chkboxUrgent="id=urgentcheckbox";


		
	public String chkTestName ="A1 Ab SerPl Ql_CB";

		

	public String btnNewLabCancel = "cancelNewLabs";
	public String lnkLabDelete = "//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr[2]/td[2]/div[2]/div[4]/table/tbody/tr[2]/td[2]/div/div/div[4]/div/div/div[14]/div[2]/div/a[2]/span";
	// Order Referral Lab
	public String btnReferral = "referPatientSaveButton";
	public String btnReferralCancel="referPatientCancelButton";
	public String ajxSearchReferral = "referralSearchBox";
	public String txtReferralNote = "referralNoteText";
	public String txtAuthcode = "referralAuthCodeText";
	public String btnRefSign="referPatientSignButton";

	public String lblPrintPreview = "//div[5]/table/tbody/tr[2]/td[2]/div/div/div/div";
	public String lblReferralDetails = "//td[2]/div/div/div[3]/div/div/div/div[2]";
	public String lblReDetails = "//div[2]/div/div[2]/div/div/div[1]/div[2]/div[1]/div[2]";
	public String tabReferralsearch = "css=#referralSearchBox";
	public String tabReferralNote = "css=#referralNoteText";
	public String tabReferralAuthcode = "css=#referralAuthCodeText";
	// CDS Alerts
	public String lblcdsAlert = "xpath=(//div[@id='chartListItemFullWidthWrapper'])[6]";
	public String lblpatientname = "xpath=//div[contains(@id,'patientInfoWidget')]";
	public String lblsearchResult = "patientInfoWidget";

	public String lblCreatedProblemListEntry = "//td[2]/div/span/div";

	public String lblUnsignedEncounterList = "//div[@id='EncountersPendingList']/table/tbody/tr/td/div";
	public String lblSignedEncounterList = "//div[@id='EncountersSignedList']/table/tbody/tr/td/div/span/div";
	public String lblCdsAlertForSH = "//div[7]/div/div/div[2]/span";
	public String lnkCheckCDS="xpath=(//div[@id='chartListItemFullWidthWrapper'])[6]";
	public String lblPatientChart = "//body/div[6]/div/div/div[2]/span";
	public String txtsearchbox = "searchPatientBox";
	public String lnkencounterTab = "!chartEncounters";
	public String btnSaveEncounter = "saveEncounter";
	public String btnApplyEncounter = "applyEncounter";
	public String lnkShowMore = "EncountersPendingListMoreLink";
	
	public String lblSummaryEncounetTab = "//div[@class='borderLight']";
	public String txtEncounterSearch = "encountersSearchBox";
	public String txtChiefCompliant = "chiefComplaintBox";
	public String lnkNewEncounterLink3 = "//body/div[4]/div/div/div[2]/div[2]";
	public String lnkUnsignedEncounterPopUp = "css=div.borderTopCCC.paddingTop5 > div.pointer";
	public String btnBack = "back";
	public String btnSign = "sign";
	public String btncorressign="signButton"; 
	
	public String txtSignedby="signedByPanel";
	public String btnCloseAlert = "//a/img";
	public String chkdoNotShowAgaincheckbox = "doNotShowAgaincheckbox";
	public String btnQuickListForInteractionWarning1 = "//div[2]/div/div/div/div/div/div/table/tbody/tr[3]/td/div/div/div/button";

	public String lblQuickListResult2 = "css=td.centerNoSidePadding > div.chartPanelHeight";
	public String lblQuickListResult2Img = "//div[4]/div/div/div/div/div[2]/div/img";
	public String lblMedicalConditionResults = "//body/div[4]/div/div/div/div/div";

	public String btnProblemListQuickList = "medicalConditionQuickListButton";
	public String lblProDetailsSignificant = "//div[3]/div[2]/div/div/div/div";

	// CcdExport
	public String lblExportPreviewSummary = "//div[@class='chart-main']/div/div[2]";
	public String lblExportPreviewSummary1 = "xpath=(//div[@class='chart-main']/div/div[2])[2]";

	public String lblPatientAddress = "patientAddress";
	public String lblPatientPrimaryPhone = "patientPrimaryPhone";
	public String lblPatientHomePhone = "patientHomePhone";
	public String lblPatientVacationPhone = "patientVacationPhone";
	public String lblPatientBusinessPhone = "patientBusinessPhone";
	public String lblPatientMobilePhone = "patientMobilePhone";
	public String lblPatientEmail = "patientEmail";
	public String lblPatientFirstName = "patientFirstName";
	public String lblPatientLastName = "patientLastName";
	public String lblPatientMiddleName = "patientMiddleName";
	public String lblPatientSex = "patientSex";
	public String lblPatientDOB = "patientDOB";
	public String lblPatientMaritalStatus = "patientMaritalStatus";
	public String lblPatientReligion = "patientReligion";
	public String lblPatientRace = "patientRace";
	public String lblPatientEthnicity = "patientEthnicity";

	// Provider
	public String btnProvider = "addProvider";
	public String btnSearchProvider = "css=div.border > span.buttons > button.gwt-Button";
	public String lnkProvider = "//div[@id='providers']/table/tbody/tr/td/div/div/span";
	public String txtSearchProvider = "xpath=(//input[@id='searchTextBox'])[4]";

	// Lab Report tab


	public String lnkLabReport = "!chartLabReportsFlowSheet";

	public String lnkLabQueue = "Labreports";
	public String lnkLabReportDelete = "deleteLabReports";
	public String lnkLabReportForward = "forwardLabReports";
	public String chkLabReport = "//a[@id='deleteLabReports']/span";
	public String lblLabData = "//div/div/div[2]/div/div/div/div/div/div[4]";
	public String lnkLabPrint = "printSend";
	// CdExport
	public String lnkExport = "//tr[5]/td/a/span";
	public String lnkPatientExport = "css=#patientOptionsExportChart > span.topMenuItemSpan.light";
	public String btnExportCancel = "cancelBtn";
	public String lblCCdExport1 = "//td[2]/div/div/div[2]/div/div/div[2]/div";
	public String lblCCdExport2 = "//div[2]/div/div/div[3]/div/div[2]";
	public String lblCCdExport3 = "//div[2]/div/div/div[5]/div/div[2]";
	public String lblCCdExport4 = "//div[2]/div/div/div[8]/div/div[2]";
	public String lblCCdExport5 = "//div[2]/div/div/div[2]/div/div/div/div/div[2]";
	public String lblCCdExport6 = "//tr[1]/td/div/input";
	public String lblExport7 = "//td/div/input";
	public String lblExport1 = "LotNumber_Div";
	public String lblExport2 = "AdministeredBy_Div";
	public String lblExport3 = "xpath=(//div[@id='Reaction_Div'])[2]";
	public String lblExport4 = "AdministeredOn_Div";
	public String lblExport5 = "//div[38]/div/div[2]";
	public String lblExport6 = "//div[3]/div/div/div[3]/div/div[2]";
	public String lblExport8 = "ProblemName_Div";
	public String lblExport9 = "//div[3]/div/div/div/div/div[2]";
	public String lblExport10 = "//div[3]/div/div/div[7]/div/div[2]";
	public String lblExport11 = "//div[3]/div/div/div[2]/div/div[2]";
	public String lblExport12 = "//div[2]/div[3]/div/div[2]";
	public String lblExport13 = "//div[2]/div[4]/div/div[2]";
	public String lblExport14 = "//div[3]/div/div[2]/div/div/div[2]";
	public String lblExport15 = "//div[2]/div[7]/div/div[2]";
	public String lblExport16 = "//div/div[2]/div[2]/div/div[2]";
	public String lblExport17 = "ResultType_Div";
	public String lblExport18 = "ResultStatus_Div";
	public String lblExport19 = "ResultValue_Div";
	public String lblExport20 = "ResultComments_Div";
	public String lblExport21 = "ResultReferenceRange_Div";
	public String lblExport22 = "//div[6]/div/div[2]/div[4]/div/div[2]";
	public String lblExport23 = "//div[6]/div/div[2]/div[5]/div/div[2]";
	public String lblExport24 = "//div[6]/div/div[2]/div[6]/div/div[2]";
	public String lblExport25 = "//div[6]/div/div[2]/div[7]/div/div[2]";
	public String lblSummaryPrescribeMed = "//div[5]/div[4]";
	public String btnOptions1 = btnCureentEdit;
	public String chkExportBox = "//div[2]/div[2]/div/div[2]/table/tbody/tr/td/div/input";
	public String btnEditForCS = "editWarningButton";
	public String btnEditWarning = "editWarningButton";
	public String ldlNojectionLabel="xpath=(//div[@id='chartListItemFullWidthWrapper'])[8]";
	public String btnEdit2 = "link=Edit";
	// External Providers

	public String lnkSystemSettings = "systemSettings";
	public String lnkExternalProviderList = "!adminExternalProviderList";
	public String lnkAddReferringProvider = "addReferringProvider";
	public String lnkexternalProviderDel = "//div[@id='AdminReferringProviderList']/table/tbody/tr/td[2]/div/a";
	public String lnkexternalProviderDel1 = "//div[@id='AdminReferringProviderList']/table/tbody ";
	public String lnkexternalProviderRecord = "//div[@id='AdminReferringProviderList']/table/tbody/tr/td/div/span";
	public String lnkexternalProviderRecord1 = "//div[@id='AdminReferringProviderList']/table/tbody/tr[2]/td/div/span";

	public String txtReferringCode = "referringCode";
	public String txtLastName = "lastName";
	public String txtMiddleName = "middleName";
	public String txtUserName = "userName";
	public String txtMiddleInitials = "mi";

	public String btnsaveProvider = "save";

	public String lblMargin = "css=button.floatRight.marginBottom10";
	public String btnDeleteExternalProvider = "//a[starts-with(@id,'Delete')]";

	// Lab Results
	public String lbFlowSheetView = "css=div.fullWidth";
	public String lnkChartLabFlowSheet = "!chartLabReportsFlowSheet";	
	public String btnLabOptions = "optionButton";	
	public String lblGraphPopup = "css=div.graphPopup";	
	public String lblGraph = "//div[5]/div/table/tbody/tr/td/div";
	public String btnClose = "close";	
	public String lblAlert = "css=div.large.dark";
	
	//FIXME MNT-1166
	public String btnMergeSelected = "id=mergeSelectedButton";
	public String btnGraphSelected = "xpath=(//button[@type='button'])[3]";
	
	public String lblCategory = "//div[3]/div/div/table/tbody/tr[2]/td/div";

	public String lblTestName = "testName";
	
	public String chkLabEntry1 = "xpath=(//*[contains(@id,'flowSheetItemCheckbox')])[2]";
	public String rdoFstLabTest = "//div[2]/table/tbody/tr/td/span/input";
	public String lnkContinue = "link=Continue";
	public String txtSearchBox = "searchTextBox";
	public String btnSearchBox = "xpath=(//button[@type='button'])[2]";
	public String btnCloseSearch = "css=a.searchClose";
	public String ajxShow = "suggestBox";

	// Refernce
	public String txtReference = "referenceName";
	public String lnkGo = "css=button.url-go-button.gradient";
	public String lnkBookMark = "css=div.add-button";
	public String txtBookDetails = "referenceName";
	public String txtBookUrl = "referenceUrl";

	public String lblPractice = "//div[@id='practices']/table/tbody/tr/td/div/span";

	// MySetting
	public String btnResetPassword = "resetPassword";
	public String btnCSEdit = "editButton";
	public String btnCSSave="saveButton";
	public String txtCurrentPassword = "currentPassword";
	public String txtNewPassword = "newPassword";
	public String txtConfirmPassword = "confirmNewPassword";
	public String btnYesButton = "Yes";
	public String lblHome = "//div[@id='printInfo']/div/div/div[3]/div";

	public String lnkMySetting = "mySettingsAction";
	public String lnkPatientSummary = "!summaryCustomization";
	public String lnkdraganddrop1 = "//tr[3]/td/div/div/div/div[2]/div";
	public String lnkdraganddrop2 = "VitalsLabel";
	public String lblSummaryValue = "//div[3]/div/div/div/div/table/tbody/tr/td/div/div/div/a";
	public String chkSectionName = "//span[@id='MedicalandSurgicalHistorycheckbox']/input";
	public String lnkScetionName = "MedicalandSurgicalHistoryLabel";
	public String btnPatSummaryCancel = "xpath=(//button[@type='button'])[2]";
	// public String chkAllergyOptionalElement =
	// "//tr[6]/td/div/div/div/div[4]/div/div/div/div/div[3]/table/tbody/tr[2]/td/span/input";
	public String chkAllergyOptionalElement = "//span[@id='CommentcheckBox_6']/input";
	public String lblAllergyOptionalElement = "//span[@id='CommentcheckBox_6']/label";
	public String chkProblemListOptionalElement = "//span[@id='CommentcheckBox_10']/input";
	public String lblProblemListOptionalElement = "//span[@id='CommentcheckBox_10']/label";
	public String chkFamilHistoryOptionalElement = "//span[@id='CommentcheckBox_24']/input";
	public String lblFamilyHistoryOptionalElement = "//span[@id='CommentcheckBox_24']/label";
	public String chkImmuizationOptionalElement = "//span[@id='CommentcheckBox_28']/input";
	public String lblImmuizationOptionalElement = "//span[@id='CommentcheckBox_28']/label";
	public String chkInjectionOptionalElement = "//span[@id='CommentcheckBox_37']/input";
	public String lblInjectionOptionalElement = "//span[@id='CommentcheckBox_37']/label";
	public String chkProcedureOptionalElement = "//span[@id='CommentcheckBox_16']/input";
	public String lblProcedureOptionalElement = "//span[@id='CommentcheckBox_16']/label";
	public String chkSocialHistoryOptionalElement = "//span[@id='ItemcheckBox_31']/input";
	public String lblSocialHistoryOptionalElement = "//span[@id='SocialHistorycheckbox']/input";

	//Co-sign	
	public String  chkIncludeInactiveProviderscheckbox = "xpath=(//input[@id='includeInactivescheckbox'])[2]";
	public String  vfyProgramDel2  = "xpath=(//input[@id='searchTextBox'])[4]";
	public String  vfyProgramDel3  = "xpath=(//button[@type='button'])[8]";
	public String  vfyProgramDel6  = "//div[@id='providers']/table/tbody/tr/td";	
	public String btnActiveHealth = "//a[contains(text(),'Activate')]";	
	public String ajxSupervisorName="supervisorsuggestBox";
	
	public String  btnProviderSearch="searchButtonProviderView";
	public String  txtProviderSearchbox  = "searchTextBoxProviderView";
	public String FirstProvider="xpath=(//div[contains(@id,'providerListItem')])[1]";
	public String btnActivateProvider="xpath=(//a[contains(@id,'ActivateProvider')])";
	public String lblProviderCount="providerCount";
	public String searchResProvider="css=#providers > table.cellTable.1.0";
	
	//FIXME =EMR-772
	public String txtDurationFrom="css=input.text-box";
	public String txtDurationTo="css=input.text-box.validation-override";
	// TimeLine
	public String lnkTimeLine = "!chartTimeline";
	public String lblEventLastVisit = "headerPanel";
	public String lblEventPreviousVisit = "//div[4]/div/div/div/div[2]/div/div/div[2]/div";
	public String chkTimeLine = "selectAllcheckbox";
	public String lblSummaryLab="contentPanel";
	public String lblPreviousEvent = "xpath=(//div[@id='headerPanel'])[2]";
	// NavigatetoSystemSetting
	public String lnkQuickLink = "link=Quick Actions";
	public String lnkSystemSettingLink = "systemSettingsAction";
	public String txtUserSearchBox = "//div[4]/div[2]/div/div/div[2]/div/div/div/div/input";
	public String lnkMedication1 = "link=Medication";
	public String lnkExpandArrow = "chartListItemTitle";
	public String vfyUserName = "username";
	public String txtUserName1 = "//div[@id='users']/table/tbody/tr/td";

	// cds
	public String lnkQuickActions = "link=Quick Actions";
	public String lnknewPatientAction = "newPatientAction";
	public String lnkPatientOptionsLink = "link=Patient Options";
	public String lnkPatientChartView = "patientOptionsChartView";
	public String ajxProvider1 = "providerSuggestBoxIdsuggestBox";
	public String ajxStuasSuggest = "statusSuggestBoxsuggestBox";
	public String btnClinicalBack = "backButton";
	public String btnClinicalSave = "saveButton";
	public String btnPatientId = "patientID";
	public String txtDob1 = "dob";
	public String lnkHelp = "helpIcon";
	public String lnkHowToUse = "howToUseNexiaAnchor";

	public String btnNotesCancel = "cancelButton";
	public String lnkUnfinshedTasks = "//div[@id='unfinishedItemMenuID']/a";
	public String lnkHelp1 = "css=h1";

	public String lblEnSumFamilyDetails2 = "//div[9]/div/a";
	public String lblSumFamilyDetails8 = "//td[2]/div/div/div/div/div/div/table/tbody/tr[6]/td/div/div/div[2]/div/div/div/div/div/div[2]/div/span/span";
	public String lblSummaryImm11 = "//tr[8]/td/div/div/div[2]/div/div/div/div/div/div[2]/div/span";

	public String btnSummaryEdit1 = "xpath=(//button[@id='save'])[2]";
	public String lblEncouterImmDetails1 = "//td[2]/div/span/div";

	public String lblEnVerifyInjection1 = "//tr[9]/td/div/div/div[2]/div/div/div/div";
	public String vfyUserName2 = "//div[3]/div[3]/div[3]/span";

	public String rdoTargetMergeLabReport = "//div[2]/table/tbody/tr/td/span/input";
	public String btnOption = "css=div.options-button";
	public String btnMergeTargetPopup = "css=div.mergePopup";
	public String btnMergeTargetPopupContinue = "css=span.secondary-button";
	public String lnkMergedReportOne = "//td[3]/table/tbody/tr/td/a";
	public String lnkMergedReportTwo = "//tr[2]/td/a";
	public String lnkLabRepInfo = "labReportDetailsImage";
	public String vfyFstReportDetails = "result";
	public String chkbxFstLabReport = "flowSheetItemCheckbox0";
	public String chkbxSecLabReport = "flowSheetItemCheckbox1";
	public String btnMergeLabReport = "mergeSelectedButton";

	public String lblPatientMeds = "//div[@id='tabPanel']/div/div[2]";
	public String arrowExpand = "link=Expand all";
	public String lblCollapseTitle="//div[contains(@id,'collapsableTitle')]";

	//Chart Disclosure
	public String lnkChartDisclosure="id=chartDisclosureRequestView";
	public String chartDLSInst="id=instructionsTextBoxId";
	public String btnChartDisSave="saveID";
	public String btnContinueChartDis="continueButton";

	public String txtChartDLSInst="id=instructionsTextBoxId";
	public String ajxChartReqBy="requestedBySuggestBoxsuggestBox";
	public String ajxChartRepType="recipientTypeSuggestBoxsuggestBox";
	public String ajxChartDeliverryMethod="deliveryMethodSuggestBoxsuggestBox";
	public String ajxChartConsentName="_consentNameSuggestBoxsuggestBox";
	public String btnCntnue="continue";
	public String btnEditRequest="editRequestButton";
	public String lnkTask="Tasks";
	public String txtSearchBox1 = "searchTextBox";
	public String lnkTaskList="taskListItem";
	public String ajxDueInCount="(//input[@id='timeCountSuggestBoxsuggestBox'])[2]";
	public String ajxDueInUnit="dueInTimeUnitSuggestBoxsuggestBox";
	public String ajxAssignToChartDis="assignToSuggestBoxsuggestBox";
	public String txtRequesterName="requestorNameTextBox";
	public String txtRequesterRel="requestorRelationship";
	// FIXME  #EMR-745
	public String txtContactPhone="css=input.gwt-TextBox";
	public String txtExtn="css=div.ext-wrapper > input.gwt-TextBox";
	public String txtRepConPhn="(//input[@type='text'])[19]";	
	public String txtRepExtn="(//input[@type='text'])[20]";
	//----------------------
	public String txtRecipientName="recipientNameTextBox";
	public String txtRecipientRel="recipientRelationship";
	public String txtAdd1="streetAdress1";
	public String txtAdd2="streetAdress2";
	public String txtCity="city";
	public String lstState="stateSuggestBoxsuggestBox";
	public String txtZip="countrySuggestBoxsuggestBox";
	public String lstCountry="countrySuggestBoxsuggestBox";
	public String txtFax="xpath=(//input[@type='text'])[28]";
	public String radMailOnFile="mailonfileradiobuttonradio";
	public String radOtherMail="othermailradiobuttonradio";
	public String radOtherFax="otherfaxradiobuttonradio";
	public String radFaxOnFile="otherfaxradiobuttonradio";
	public String btnSelectItems="selectItems";
	public String radIncludeFullChart="includePartialChartradio";
	public String radIncludePartialChart="includePartialChartradio";
	public String btnPrintClose="framePopupViewCloseButton";
	public String btnPrintChartDis="printButton";
	public String btnCancelChartDis="cancelButton";
	public String lstShowSuggestBox="showFiltersuggestBox";
	public String dateFromFilter="dateFromFilter";
	public String dateToFilter="dateToFilter";
	public String ajxAddFilterBy="andFilterByFiltersuggestBox";
	public String lnkSelectPayers="link=Click to select payers";
	public String lnkActions="actionsShowOne";
	public String lnkSelectAssesment="link=Click to select assessments";
	public String lnkEditRequest="editRequest";
	public String lnkEditSelection="editSelection";
	public String btnRegistrationEdit="editButton";
	public String lblContentPanel="//div[@class='activity-items-selection-view']/div";
	public String lnkExpandCollapseAll="expandCollapseAll";
	public String chkSelectAll="selectAllTimelinecheckbox";
	public String lnkRemove="//a[@class='inline-delete-button']";
	public String ajxFileReportType = "reportTypessuggestBox";
	public String btnEnterData = "//a[contains(text(),'Enter data')]";

	//Advance Search 
	public String lnkLab = "link=Labs";
	public String lnkUnmatchedQueue = "Unmatchedpatientrecords";
	public String txtAccessionNo = "css=input.text-box.clearInputValue";
	public String txtSearchUnmatchedRecord = "searchTextBox";
	public String btnAdvanceSearch = "searchAnchor";

	public String chkFileToPatient = "fileToPatientradio";
	public String chkReturnToUnMatch = "returnToUnmatchedradio";
	public String txtSearchFileToPatient = "xpath=(//input[@id='searchPatientBox'])[2]";
	public String btnSearchSavePatient ="//a[contains(text(),'Save')]";
	public String btnSearchPatientclose = "//a[contains(text(),'Close')]";
	public String btnRefile = "//a[contains(text(),'Refile')]";

	//Medication Reconciliation	
	public  String lblMedicationPlan="css=span.lineTitle."; 
	public String btnNext="//a[starts-with(@id,'next')]";
	public String btnSignLater="signLater";
	public String ChkBoxMediRecon="//input[@id='gwt-uid-7319']";
	//Fix ME EMR-731
	public String ChkCoxNonComplint="id=gwt-uid-7335";
	public String MedicationStopButton="stop";
	public String MedicationholdButton="hold";
	public String MedicationrenewButton="renew";
	public String btnEditBlue = "editButton";
	public String txtRefillQuan = "refillQuantity";
	public String lnkEditUnsigEnc = "//div[contains(@id,'encounterEdit')]";
	public String btnDeleteBlue = "delete";
	public String btnApproveBlue = "approve";
	public String btnSaveLab = "saveNewLabs";
	//FIXME EMR-731
	public String ChkselectAll="selectAllCheckbox";
	public String ChkBoxMedication="xpath=(//input[contains(@id,'selectCheckbox')])[1]";
	public String ChkNoncompliant="xpath=(//input[contains(@id,'nonCompliantCheckbox')])[1]";
	public String lblMediNonCompliant="//div[4]/span[3]";
	//EMR-772
	public String ajxCosignProv="coSignSuggestBoxsuggestBox";
	public String lnkFileDocu="id=scanAction";
	public String btnUploadFile="id=docManagementFileUpload-browse-anchor";
	public String btnFile="file";
	public String ajxDocuType="docTypeSuggestBoxsuggestBox";
	public String ajxReport="id=correspondenceTypeSuggestsuggestBox";
	public String txtSender="sender";
	public String CorresTab="!chartCorrespondencesMore";
	public String tabTimeLine = "!chartTimeline";
	
	//Implement Referrals
	public String ajxSelectTemplate = "templatesuggestBox";
	public String btnReferralContinue = "referPatientContinue";
	public String btnCreateTask = "createTask";
	public String ajxTaskType = "taskTypeSuggestBoxsuggestBox";
	public String txtTaskName = "taskQuickList";
	public String ajxTaskAssignTo = "assignToSuggestBoxsuggestBox";
	public String btnSaveTask = "saveID";
	public String lblReferredToInEncounterNote = "xpath=(//span[contains(@id,'lineTitle')]/span/span)[1]";
	public String lnkViewReferralNote = "//a[@id='view']/span";
	

	public String lnkLetterTemplate = "!templatesLetter" ;
	public String lnkTemplateSetup="templateSetupAction";
	public String btnAddLetterTemplate ="link=Add New";
	public String txtLetterTemplateName = "letterTemplateName";
	public String ajxPageSize = "letterTemplatePageSizesuggestBox";	
	public String ajxTemplateType = "letterTemplateTypesuggestBox";	
	public String lnkTemplateEdits = "xpath=(//a[contains(text(),'Edit')])" ;
	public String lnkTemplateCopys = "xpath=(//a[contains(text(),'Copy')])" ;
	public String lnkTemplateDeletes = "xpath=(//a[contains(text(),'Delete')])" ;	
	public String btnReferralLetterDone = "view-referral-letter-done-button";
    public String chkUrgentRefLetter = "urgentcheckbox";
    public String lbllettertexts = "//*[@id='cke_1_contents']/div/p";
    public String objReferralLetterTextArea = "//*[@id='cke_1_contents']/div";

	//FIXME TCH-349
	public String txtTemplateArea = "//textarea[contains(concat(' ',normalize-space(@class),' '),' cke_contents_ltr ')]";
	public String btnSource = "//span[contains(concat(' ',normalize-space(@class),' '),' cke_button__source_label ')]";
	public String lblGroupFields = "//div[contains(concat(' ',normalize-space(@class),' '),' dragdrop-handle ')]";
	
	public String linkSelectedTemplateFields = "//div[(@class='toodad')]";
	public String chkShowAllTemplates = "//input[@type='checkbox' and contains(@id,'gwt-uid')]";
	public String btnAddTemplateField = "//div[@class='add-button' and contains(text(),'Add new')]";
	public String txtFieldName = "toodadFieldName";
	public String ajxFieldType = "suggestBox";
	public String btnTemplateSecondrySave = "//a[@class='secondary-button' and contains(text(),'Save')]";
	public String btnTemplateSecondryDelete = "//a[@class='secondary-button left-button-spacer' and contains(text(),'Delete')]";
	public String objTemplateFieldsDropTarget = "//div[contains(@class, 'template-fields dragdrop-dropTarget')]";


    //EMR Security
	public String lnkSocioEconomics = "!patientSocialHistory";
	public String ajxRace = "raceSuggestBoxId1suggestBox";
	public String ajxEthnicity = "ethnicitysuggestBox";
	public String ajxReligion = "religionsuggestBox";
	public String ajxCitizenShip = "citizenshipsuggestBox";
	public String ajxStudentStatus = "studentStatussuggestBox";
	public String ajxHouseholdIncome = "householdIncomesuggestBox";
	public String ajxEmploymentStatus = "employmentsuggestBox";
	public String lnkDataSharing = "!datasharing";
	public String btnEditDataSharing = "//button[@class='primary-button left-button-spacer' and text()='Edit']";
	public String lblVitalInfo = "//*[@id='vitalBoxWrapper']/div[2]/div[1]";
	public String lblFirstPendingEncounter = "//*[@id='EncountersPendingList']/table/tbody[1]/tr[1]/td[1]";
	public String lblFirstSignedEncounter = "//*[@id='EncountersSignedList']/table/tbody[1]/tr[1]/td[1]";
	public String btnDataSharingSave ="//button[@class='primary-button' and text()='Save']";
	public String lblPracticeDataSharing = "//span[@class='padding-left-10']";
    public String lnkSecuritySettings = "securitySettingsAction";
    public String lnkEmergencyAccess = "!additionalAccess";
    public String btnEmergencyAccessEdit = "//button[@type='button' and contains(text(),'Edit')]";
    public String ChkFullAccess = "chk4Reportscheckbox";
    // FIXME TCH-280
    public String txtEmergencyAccessSearch = "//*[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div/div[3]/div/div/div/div/div/div[1]/div/div[1]/div[1]/div/div/input";
    public String btnEmergencyAccessSearch = "//button[contains(text(),'Search')]";
    public String chkSearchResult = "chkBoxcheckbox";
    public String btnEmergencyAccessSave = "//button[contains(text(),'Save')]";

    public String lnkRestrictChart = "patientOptionsRestrictChart";
    public String btnAddNewRestrictedUser = "//button[@class='primary-button']"; 
    public String ajxUserList = "xpath=(//input[@id='suggestBox'])[2]";
    public String btnAddNewUser = "//div[3]/button";
    public String btnSaveRestrictedUser = "//button[@class='primary-button' and contains(text(),'Save')]";
    public String btnSignOutConfirmation = "yesButton";
    public String lnkPatientChartEmergencyAccess = "//*[@id='patientChartViewEmergencyAccess']/span";
  
    public String txtEmergencyAccessDuration = "range";
    public String txtEmergencyAccessReason = "reasonForAccess";
    public String btnEmergencyAccessContinue = "//button[@class='gwt-Button' and text()='Continue']";
    public String btnEmergencyAccessPopupContinue = "//a[@class='secondary-button' and contains(text(),'Continue')]";
    
    //Export Chart
    public String lnkChartManagement="chartManagementAction";
    public String lnkChartMangExportChart="!chartExport";
    public String ajxExpSearchProvider="providerSuggestBoxsuggestBox";
    public String chkExpChartIncludeInactive="includeInactivescheckbox";
    public String btnExportChart="editWarningButton";
    public String ajxExpChartSearchProvider="providerSuggestBoxsuggestBox";
    public String txtExpChartPwd="password";
    public String radExpAllPatient="exportAllPatientsForThisProviderradio";
    public String radExpSelectedPatient="exportSelectedPatientsradio";
    public String radExpAllPatientData="exportAllPatientsDataradio";
    public String radExpSelectedPatientData="exportSelectedPatientsDataradio";
    public String btnExport="link=Export";
    public String btnCancelExport="link=Cancel";
    public String btnAddPatient="addButtonDiv";
    public String lnkClosePatient="closePopupButton";
    public String lnkDataCategories="dataCategoriesLink";
    public String ajxSearchPatient="xpath=(//input[@id='searchPatientBox'])[2]";
    public String chkIncludeInactivePatient="includeInactivescheckbox";
    public String lnkCloseDataCat="multiSelectionCloseButton";
    public String chkDataCat="checkbox";
    public String lblDataCat="label";      
    public String btnOkEC="yesButton";
    // FIXME VEL-5788
    public String lblProviderNameImportChart="xpath=(//span[contains(@id,'providerName')])[1]";
    public String lblStatusImportChart="xpath=(//div[contains(@id,'importStatus')])[1]";
    public String lblReportInfoImportChart="xpath=(//span[contains(@id,'importRequestInfo')])[1]";
    public String arrowEC="xpath=(//a[contains(@id,'expandAllExportData')])[1]";
    public String lblSummaryEc="css=div.chart-list-item";
    public String btnRemoveSystemNote="css=div.float-right > button.secondary-button";
    public String lblSystemNotificationEC="//div[2]/div/div[2]/div/div/div/div/div[2]";
    public String lnkDeleteEC="link=Delete";
    public String lnkDownload="link=Download";
    public String btnYesButtonEC = "yesButton";
    public String chkSelectAllEC="SQSelectAllcheckbox";
    public String lnkSystemNotification="Systemnotifications";
    public String ajxSearchSystemNote="systemNotificationSearchBox";
    public String ajxShowAllEC="suggestBox";
    public String lnkHideSystemNote="SlideWindowHideAnchor";
    public String lnkActivate="link=Activate";
    
    //Import Chart
    public String chkIncludeInactiveIC="includeInactivescheckbox";
    public String ajxImpProvider="searchTemplateTextBox";
    public String btnImpChart="editWarningButton";
    public String lnkDeleteIC="link=Delete";
    public String ajxImpChartProvider="providerSuggestBoxsuggestBox";
    public String txtImportFile="templatesDaysheetAddFileUpload-file-upload";
    public String btnBrowseIC = "id=templatesDaysheetAddFileUpload-browse-anchor";
    public String txtPasswordIC="password";
    public String btnImport="importButton";
    // FIXME VEL-5788
    public String btnCancelImport="cancelButton";
    public String lnkChartMangImportChart="!chartImport";
    public String btnYesButtonIC = "yesButton";
   
    //Lab Order
	public String printOn = "requisitionTypeSuggestBoxsuggestBox";
	public String ajxProvidersuggestBox="providersuggestBox";
    
    
    
    



	/**
	 * goToPrescribe function to goToPrescribe
	 * @throws IOException 
	 * 
	 * @since Sep 12, 2012
	 */
	public boolean goToPrescribe(Selenium selenium) throws IOException {

		assertTrue(isElementPresent(selenium, lnkPatientOption),
				"Could not find link",selenium, ClassName, MethodName);
		assertTrue(click(selenium, lnkPatientOption),
				"Could not click the link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		selenium.isVisible(lnkPrescribeMedication);
		assertTrue(isElementPresent(selenium, lnkPrescribeMedication),
				"Could not find the Prescribe Medication link",selenium, ClassName, MethodName);
		assertTrue(click(selenium, lnkPrescribeMedication),
				"Could not select Prescribe Medication",selenium, ClassName, MethodName);
		if(isElementPresent(selenium, "errorCloseButton"))
			assertTrue(click(selenium, "errorCloseButton"),"Could not click the Close Button link",selenium, ClassName, MethodName);
		return true;

	}

	/**
	 * chartDeleteMedication function to chartDeleteMedication
	 * 
	 * @since Sep 12, 2012
	 */

	public boolean deleteChartMedication(Selenium selenium,
			ChartPreVisitLib medsData) {
		boolean medicationDeleted = true;
		int medicationCount = 1;
		try {
			selectValueFromAjaxList(selenium, ajxRxShow, "Pending");
			waitForPageLoad(selenium);
			waitForElement(selenium, lnkOption, WAIT_TIME);
			while ((Integer) selenium.getXpathCount(lnkOption) > 0) {
				medicationCount = (Integer) selenium.getXpathCount(lnkOption);
				selenium.focus(lnkOption);
				selenium.clickAt(lnkOption, "");
				assertTrue(
						click(selenium, "//body/div[4]/div/div/div[3]"),
						"Could not click the delete",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtDeleteReaseon, medsData.reason),
						"Could not Enter the reason",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnContinue),
						"Could not click the save button",selenium, ClassName, MethodName);
				if (medicationCount == (Integer) selenium
						.getXpathCount(lnkOption)) {
					medicationDeleted = false;
					break;
				}

			}
			return medicationDeleted;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return medicationDeleted;

	}

	/**
	 * SearchPrescribeMed function to SearchPrescribeMed
	 * 
	 * @throws IOException
	 * @since Sep 12, 2012
	 */

	public boolean SearchPrescribeMed(Selenium selenium,
			ChartPreVisitLib prescribeData, String account) throws IOException {

		if(selenium.isConfirmationPresent()){
			System.out.println(selenium.getConfirmation());
			selenium.chooseOkOnNextConfirmation();   }

		//selectValueFromAjaxList(selenium, ajxProvider, prescribeData.provider);

		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium, ajxLoaction, prescribeData.loaction);
		waitForPageLoad(selenium);
		if (account.equals("CA2000"))
		{
			assertTrue(selectValueFromAjaxList(selenium, ajxDrugsList,prescribeData.prescribeCa),
							"Could not type Prescribe Medication;More Details:"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
		
			waitForPageLoad(selenium);
		} else 
		{
			assertTrue(
					selectValueFromAjaxList(selenium, ajxDrugsList,
							prescribeData.prescribe),
							"Could not type Prescribe Medication;More Details:"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		if (isElementPresent(selenium, "//img[@title='Patient']")) {
			waitForPageLoad(selenium);
			if(account.equalsIgnoreCase("CA2000")){
				assertTrue(click(selenium, lnkEdit),"Could not click the Prescribe link;More Deatils:"
								+ prescribeData.toString(),selenium, ClassName, MethodName);
			}
			else{
				assertTrue(click(selenium, lnlEdit1),
						"Could not click the Prescribe link;More Deatils:"
								+ prescribeData.toString(),selenium, ClassName, MethodName);
			}
		} 
		else{
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkEdit),
					"Could not click the Prescribe link;More Deatils:"
							+ prescribeData.toString(),selenium, ClassName, MethodName);
		}
		waitForPageLoad(selenium);

		
		waitForPageLoad(selenium);

		// Please Do not comment this section. Not sure why it was commented out
		if ((!isElementPresent(selenium, btnOverride))&& isElementPresent(selenium, btnCancelButton)){
			assertTrue(click(selenium, btnCancelButton),
					"Could not Click Proceed Anyway button"+ prescribeData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		if(selenium.isConfirmationPresent()){
			System.out.println(selenium.getConfirmation());
			selenium.chooseOkOnNextConfirmation(); } 
		return true;

	}



	/**
	 * searchPrescribeMedication
	 * This function performs search for a prescribed medication
	 * @param            selenium (an instance of current selenium browser )
	 * @param            prescribeData (Object of ChartPreVisitLib)
	 * @param            account (String to indicate typr of account)
	 * @since          May 13, 2014
	 */
	public boolean searchPrescribeMedication(Selenium selenium,
			ChartPreVisitLib prescribeData, String account) throws IOException {

		if(selenium.isConfirmationPresent()){
			System.out.println(selenium.getConfirmation());
			selenium.chooseOkOnNextConfirmation();   }

		//selectValueFromAjaxList(selenium, ajxProvider, prescribeData.provider);

		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium, ajxLoaction, prescribeData.loaction);
		waitForPageLoad(selenium);
		if (account.equals(CAAccount)) {
			assertTrue(selectValueFromAjaxList(selenium, ajxDrugsList, prescribeData.prescribeCa),
					"Could not type Prescribe Medication;More Details:"	+ prescribeData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		} else {
			assertTrue(selectValueFromAjaxList(selenium, ajxDrugsList,prescribeData.prescribe),
					"Could not type Prescribe Medication;More Details:"+ prescribeData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);

		return true;
	}

	/**
	 * SearchPrescribeMedForFreeFrom function to SearchPrescribeMed
	 * @throws IOException 
	 * 
	 * @since Sep 12, 2012
	 */

	public boolean SearchPrescribeMedForFreeFrom(Selenium selenium,
			ChartPreVisitLib prescribeData, String account) throws IOException {

		if (isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"Could not click on Error Close Button",selenium, ClassName, MethodName);

		selectValueFromAjaxList(selenium, ajxProvider, prescribeData.provider);
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium, ajxLoaction, prescribeData.loaction);

		assertTrue(click(selenium, lnkFreeFrom),
				"Could not click override button" + prescribeData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;

	}

	 /**
	* goToBeginEncounter function to goToBeginEncounter
	* 
	* @throws IOException
	* 
	* @since Sep 12, 2012
	*/

	public boolean goToBeginEncounter(Selenium selenium) throws IOException {
	try {

	//String onBehalfOf= provider.replaceAll(", "+orderData.switchRole, "");
	//String location = "";
	if(isElementPresent(selenium, btnErrorClose))

	assertTrue(click(selenium, btnErrorClose),"Could not click on Close Button",selenium, ClassName, MethodName);


	if (isElementPresent(selenium, btnBeginEncounter)) {
	assertTrue(click(selenium, btnBeginEncounter),"Could not click on Close Button",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	waitForPageLoad(selenium);
	waitForPageLoad(selenium);
	waitForPageLoad(selenium);
	// if (isElementPresent(selenium, lblEncounterChoosePanel)) {
	if (isElementPresent(selenium, lnkStartNewWncouter)) {
	waitForPageLoad(selenium);
	selenium.focus(lnkStartNewWncouter);
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

	assertTrue(click(selenium, btnErrorClose),"Could not click on Close Button",selenium, ClassName, MethodName);

	waitForPageLoad(selenium);
	waitForPageLoad(selenium);
	waitForPageLoad(selenium);
	assertTrue(isElementPresent(selenium, lnkEncounterAction),"Encounter Action button is not present ",selenium, ClassName, MethodName);
	if(selenium.isConfirmationPresent()){
	System.out.println(selenium.getConfirmation());
	selenium.chooseOkOnNextConfirmation();
	}
	if(isElementVisible(selenium,"contactModesuggestBox"))
	{
	selectValueFromAjaxList(selenium,"contactModesuggestBox","Scheduled");	
	}
	if(isElementVisible(selenium,ajxProviderSugBox))
	{ String providerNameTemp= getText(selenium, lnkTopMenu);

	if(providerNameTemp.toLowerCase().contains(" biller"))
	{
	String providerName= providerNameTemp.replaceAll(", BILLER", "");
	String tempArray[]=providerName.split(" ");
	String pName=tempArray[1]+", "+tempArray[0];
	selectValueFromAjaxList(selenium,ajxProviderSugBox,pName);	
	}
	else if(providerNameTemp.toLowerCase().contains(" full")){
	String providerName= providerNameTemp.replaceAll(", FULL", "");
	String tempArray[]=providerName.split(" ");
	String pName=tempArray[1]+", "+tempArray[0];
	System.out.println(pName);
	selectValueFromAjaxList(selenium,ajxProviderSugBox,pName);	
	}

	else{
		String providerName= providerNameTemp.replaceAll(", SignAutoTest", "");
		String tempArray[]=providerName.split(" ");
		String pName=tempArray[1]+", "+tempArray[0];
		System.out.println(pName);
		selectValueFromAjaxList(selenium,ajxProviderSugBox,pName);	
	}

	}

	}
	} catch (RuntimeException e) {
	e.printStackTrace();
	}
	return true;
	}

/**
 * addPrescribeMedication function to add Prescribe Medication
 * @throws IOException 
 * 
 * @since Sep 12, 2012
 */
	public boolean addPrescribeMedication(Selenium selenium,
			ChartPreVisitLib prescribeData, String account) throws IOException {
				String date = null;
				String str=null;
				
				try {
					waitForPageLoad(selenium);
					 String providerNameTemp= getText(selenium, lnkTopMenu);
					 
				 String providerName= providerNameTemp.replaceAll(", "+
					  prescribeData.switchRole , "");
					  
					  String tempArray[]=providerName.split(" ");
					  
					  String pName=tempArray[1]+", "+tempArray[0];
					  prescribeData.providerName=pName;
					 // selectValueFromAjaxList(selenium,ajxProvider,pName);
					 /* //selectValueFromAjaxList
					 * (selenium,ajxProvider,prescribeData.provider);
					 * click(selenium,"//body/div[5]/div/div/div/div/div");
					 * waitForPageLoad(selenium);
					 * selectValueFromAjaxList(selenium,ajxLoaction
					 * ,prescribeData.loaction);
					 * click(selenium,"//body/div[5]/div/div/div/div/div");
					 * waitForPageLoad(selenium);
					 */
//					 assertTrue(selectValueFromAjaxList(selenium,ajxLoaction,prescribeData.loaction),"Could not add location", selenium, ClassName, MethodName);
						
					selectValueFromAjaxList(selenium,ajxLoaction
							 ,prescribeData.loaction);
					if(selenium.isConfirmationPresent()){
						System.out.println(selenium.getConfirmation());
						selenium.chooseOkOnNextConfirmation();       
					}

					
					assertTrue(type(selenium, "durationNumberID", "2"),"Could not enter dispense;More Details:"
									+ prescribeData.toString(),selenium, ClassName, MethodName);

					if (account.equals(CAAccount)) {
						if (!isChecked(selenium, chkOneTimeOnly))
							assertTrue(click(selenium, chkOneTimeOnly),
									"Could not click the one time only check box;More Details:"
											+ prescribeData.toString(),selenium, ClassName, MethodName);
						if (prescribeData.freeText.equals("Yes")) {
							if (!isChecked(selenium, chkFreeText))
								assertTrue(click(selenium, chkFreeText),
										"Could not click the Free text check box;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
							assertTrue(
									type(selenium, txtDirectionNotes,
											prescribeData.direction),
											"Could not enter the text;More Details:"
													+ prescribeData.toString(),selenium, ClassName, MethodName);

						} else if (prescribeData.increaseDecreaseDose.equals("Yes")) {
							if (!isChecked(selenium, chkIncreaseDecreaseDirection))
								assertTrue(
										click(selenium, chkIncreaseDecreaseDirection),
										"Could not click the Increase/Decrease Dose check box;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);		
							
							
							selectValueFromAjaxList(selenium, ajxInRefillMethod,
									prescribeData.refillMethodCa);
						waitForPageLoad(selenium);

							type(selenium, "//div[6]/div/div/div/div/div[2]/div/input",
									prescribeData.refillQuantityCa);
						waitForPageLoad(selenium);

							selectValueFromAjaxList(selenium, ajxInRefilUnit,
									prescribeData.refillUnitCa);

							selectValueFromAjaxList(selenium, ajxInRefillRoute,
									prescribeData.refillRouteCa);

							selectValueFromAjaxList(selenium, ajxInRefillFrequency,
									prescribeData.refillFrequencyCa);
							/*selectValueFromAjaxList(selenium, ajxInRefillDuration,////
									prescribeData.refillFrequencyCa);*/
							selectValueFromAjaxList(selenium, ajxInRefillUsage,
									prescribeData.refillUsage4Ca);

							selectValueFromAjaxList(selenium, ajxRefilUsage,
									prescribeData.refillUsageCa);
							prescribeData.usageCa="1";
							/*type(selenium, "css=div.control-group.validation-error > input.gwt-TextBox",
									prescribeData.usageCa);*/
//					assertTrue(
//									type(selenium, "//div[4]/div/div/div/input",
//											prescribeData.durationIn),
//											"Could not type the duration;More Details;"
//													+ prescribeData.toString(),selenium, ClassName, MethodName);
			//
//						
							type(selenium, "//div[3]/div[2]/div/div/input",
									prescribeData.refillQuantity);
							assertTrue(
									type(selenium, txtDuration,
											prescribeData.durationIn),
											"Could not type the duration;More Details;"
													+ prescribeData.toString(),selenium, ClassName, MethodName);
							assertTrue(
									type(selenium, txtDuration1,
											prescribeData.durationIn),
											"Could not type the duration;More Details;"
													+ prescribeData.toString(),selenium, ClassName, MethodName);
							
							selectValueFromAjaxList(selenium, ajxInRefillUsage1,
									prescribeData.refillUsage1Ca);

							/*selectValueFromAjaxList(selenium, ajxInRefillUsage2,
									prescribeData.refillUsage2Ca);*/
							assertTrue(
									type(selenium, txtUntillReach,
											prescribeData.usageCa),
											"Could not enter the text;More Details:"
													+ prescribeData.toString(),selenium, ClassName, MethodName);
							
							selectValueFromAjaxList(selenium, ajaxInRefillUsage3,
									prescribeData.refillUsage3Ca);

							assertTrue(
									type(selenium, txtDirectionNotes,
											prescribeData.direction),
											"Could not enter the text;More Details:"
													+ prescribeData.toString(),selenium, ClassName, MethodName);
							waitForPageLoad(selenium);					
							
						} else if (prescribeData.multipleDirection.equals("Yes")) {
							if (!isChecked(selenium, chkMultipleDirection))
								assertTrue(
										click(selenium, chkMultipleDirection),
										"Could not click the multiple direction check box;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);

							selectValueFromAjaxList(selenium, ajxMDRefilMethod,
									prescribeData.refillMethodCa);

							selectValueFromAjaxList(selenium, ajxMDRefillQuantity,
									prescribeData.refillQuantityCa);

							selectValueFromAjaxList(selenium, ajxMDRefillUnit,
									prescribeData.refillUnitCa);

							selectValueFromAjaxList(selenium, ajxMDRefillRoute,
									prescribeData.refillRouteCa);

							selectValueFromAjaxList(selenium, ajxMDRefillFrequency,
									prescribeData.refillFrequencyCa);

							selectValueFromAjaxList(selenium, ajxMDRefillUsage,
									prescribeData.refillUsage5Ca);

							selectValueFromAjaxList(selenium, ajxMDMethod,
									prescribeData.methodCa);
							selectValueFromAjaxList(selenium, ajxAndThen,
									prescribeData.andThen);
							selectValueFromAjaxList(selenium, ajxMDQuantity,
									prescribeData.qualityCa);

							selectValueFromAjaxList(selenium, ajxMDUnit,
									prescribeData.unitCa);

							selectValueFromAjaxList(selenium, ajxMDRoute,
									prescribeData.routeCa);
							selectValueFromAjaxList(selenium, ajxMDFrequency,
									prescribeData.frequencyCa);


							selectValueFromAjaxList(selenium, ajxMDUsage,
									prescribeData.refillUsage4Ca);

							assertTrue(
									type(selenium, txtDirectionNotes,
											prescribeData.direction),
											"Could not enter the text;More Details:"
													+ prescribeData.toString(),selenium, ClassName, MethodName);

						} else if (!prescribeData.freeText.equals("Yes")
								&& !prescribeData.increaseDecreaseDose.equals("Yes")
								&& !prescribeData.multipleDirection.equals("Yes")) {

							if (isChecked(selenium, chkFreeText))
								assertTrue(click(selenium, chkFreeText),
										"Could not un check the Free text check box;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);

							if (isChecked(selenium, chkIncreaseDecreaseDirection))
								assertTrue(
										click(selenium, chkIncreaseDecreaseDirection),
										"Could not un check the Increase/Decrease Dose check box;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);

							if (isChecked(selenium, chkMultipleDirection))
								assertTrue(
										click(selenium, chkMultipleDirection),
										"Could not un check the multiple direction check box;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
						/*	assertTrue(
									type(selenium, txtDuration3,
											prescribeData.durationIn),
											"Could not type the duration;More Details;"
													+ prescribeData.toString(),selenium, ClassName, MethodName);*/

							waitForPageLoad(selenium);
							selectValueFromAjaxList(selenium, ajxMethod,
									prescribeData.refillMethodCa);
							
							assertTrue(
									type(selenium, txtRefillQuan,
											prescribeData.qualityCa),
											"Could not enter the text;More Details:"
													+ prescribeData.toString(),selenium, ClassName, MethodName);
						/*	type(selenium, txtRefillQuan,
									prescribeData.qualityCa);*/

							selectValueFromAjaxList(selenium, ajxUnit,
									prescribeData.unitCa);

							selectValueFromAjaxList(selenium, ajxRoute,
									prescribeData.routeCa);

							selectValueFromAjaxList(selenium, ajxFrequency,
									prescribeData.frequencyCa);

							if(isElementPresent(selenium,yesLink))
							{
								click(selenium,yesLink);
							}

							selectValueFromAjaxList(selenium, ajxUsage,
									prescribeData.refillUsage4Ca);

							assertTrue(
									type(selenium, txtDirectionNotes,
											prescribeData.direction),
											"Could not enter the text;More Details:"
													+ prescribeData.toString(),selenium, ClassName, MethodName);
							waitForPageLoad(selenium);
						}

						if (prescribeData.testCaseId.equalsIgnoreCase("TC_PM_023")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_029")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_042")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_043")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_073")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_074")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_075")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_076")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_077")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_087")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_090")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_102")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_103")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_109")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_111")) {
							assertTrue(
									type(selenium, txtFreeFormText,
											prescribeData.prescribeNameCa),
											"Could not enter the medication free text;More Details:"
													+ prescribeData.toString(),selenium, ClassName, MethodName);
							waitForPageLoad(selenium);
						}
						if (prescribeData.testCaseId.equalsIgnoreCase("TC_PM_013")) {
							selenium.clickAt(txtDirectionNotes, "");
							assertTrue(selenium.isTextPresent(prescribeData.addDirectionCount),
									"Additional directions count is not deducted properly",selenium, ClassName, MethodName);
						}

						assertTrue(
								type(selenium, txtDispense, prescribeData.dispense),////
								"Could not enter dispense;More Details:"
								+ prescribeData.toString(),selenium, ClassName, MethodName);
						waitForPageLoad(selenium);

						if(isElementPresent(selenium,yesLink))
								{
							click(selenium,yesLink);
								}
						selectValueFromAjaxList(selenium, ajxUnitList,
								prescribeData.unitListCA);
						waitForPageLoad(selenium);
//						click(selenium, "//body/div[5]/div/div/div/div/div");
						waitForPageLoad(selenium);
						if (account.equals(CAAccount)) {
							Calendar cal = Calendar.getInstance();				
							SimpleDateFormat DateFormat1 = new SimpleDateFormat(
									"dd/MM/yyyy");
							date = DateFormat1.format(cal.getTime());
						}
						else
						{
							Calendar cal = Calendar.getInstance();				
							SimpleDateFormat DateFormat1 = new SimpleDateFormat(
									"MM/dd/yyyy");
							date = DateFormat1.format(cal.getTime());
						}
						
						assertTrue(enterDate(selenium, txtFillon, date),
								"Could not enter the Date;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);

						if (!prescribeData.ofRefill.isEmpty()) {
							if (!prescribeData.testCaseId.equalsIgnoreCase("TC_PM_004")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_036")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_064")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_078")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_085")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_088")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_089")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_099")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_101")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_55")
								&& !prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_48"))
							{
								assertTrue(
										type(selenium, txtofRefills,
												prescribeData.ofRefill),
												"Could not enter the Refill;More Details:"
														+ prescribeData.toString(),selenium, ClassName, MethodName);
								waitForPageLoad(selenium);
								assertTrue(click(selenium,lnkRefillOption),"Could not click Refill Option;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
								assertTrue(
										type(selenium, txtRefillDurationNo,
												prescribeData.ofRefill),
												"Could not enter the no of Refill;More Details:"
														+ prescribeData.toString(),selenium, ClassName, MethodName);
								type(selenium, txtRefillDispense,
										prescribeData.dispense);
//								selectValueFromAjaxList(selenium, ajxRFMethod,
//										prescribeData.refillMethodCa);
			//
//								selectValueFromAjaxList(selenium, ajxRFQuatity,
//										prescribeData.refillQuantityCa);

								selectValueFromAjaxList(selenium, ajxRFUnit,
										prescribeData.refillUnitCa);
//								selectValueFromAjaxList(selenium, ajxRFRoute,
//										prescribeData.refillRouteCa);

//								selectValueFromAjaxList(selenium, ajxRFFrequency,
//										prescribeData.refillFrequencyCa);

//								selectValueFromAjaxList(selenium, ajxRFDuration,
//										prescribeData.refilldurationCa);
								type(selenium, ajxRFDoNot,
										prescribeData.refillDoNot);
							}
						}

					assertTrue(
								type(selenium, txtNotesToPharmacy,
										prescribeData.notesToPharmacy),
										"Could not enter dispense;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
						selenium.click(ckkPrescribtionOption);
						if (prescribeData.subPermitted.equals("Yes")) {
							if (!isChecked(selenium, chkSubPermitted))
								 assertTrue(click(selenium, chkSubPermitted),
										"Could not click the permitted check box;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
						}
						if (prescribeData.comePackage.equals("Yes")) {


							if (!isChecked(selenium, chkComPackage))
								assertTrue(click(selenium, chkComPackage),
										"Could not click the com Packing check box;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
						}
						if (prescribeData.weightPreMed.equals("Yes")) {


							if (!isChecked(selenium, chkWeight))
								 assertTrue(click(selenium, chkWeight),
										"Could not click the com Packing check box;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
							 assertTrue(type(selenium, txtweight, prescribeData.weight),
			                            "Could not enter the Date;More Details:"
			                                          + prescribeData.toString(),selenium, ClassName, MethodName);
							 assertTrue(selectValueFromAjaxList(selenium, ajxWeighUnit, prescribeData.weightPreMed),
			                            "Could not enter the Date;More Details:"
			                                          + prescribeData.toString(),selenium, ClassName, MethodName);
							
						}
						if (prescribeData.expires.equals("Yes")) {


							if (!isChecked(selenium, chkExpires))
								assertTrue(click(selenium, chkExpires),
										"Could not click the com Packing check box;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
			                assertTrue(enterDate(selenium, txtDateExpires, date),
			                        "Could not enter the Date;More Details:"
			                                      + prescribeData.toString(),selenium, ClassName, MethodName);

							
						}
						
						if (prescribeData.saveList.equals("Yes")) {
							if (!isChecked(selenium, chkQuickList))
								assertTrue(click(selenium, chkQuickList),
										"Could not click the save list;More Details"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
						}

						if ( prescribeData.testCaseId.equals("TC_PM_026")
								|| prescribeData.testCaseId.equals("TC_PM_071")
								|| prescribeData.testCaseId.equals("TC_PM_079")
								|| prescribeData.testCaseId.equals("TC_PM_080")
								|| prescribeData.testCaseId.equals("TC_PM_082")) {
							int count = 1;
							click(selenium, btnSearchDatabase);
							selectValueFromAjaxList(selenium, ajxSearch,
									prescribeData.pharmacyName);
							type(selenium, txtDistance,
									prescribeData.searchWithin);

							if (prescribeData.searchWithinKM.equals("Yes")) {
							 assertTrue(click(selenium, chkSearchwithin),
										"Could not click the KM radio button;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
							}
							if (prescribeData.searchWithinMiles.equals("Yes")) {
							 assertTrue(
										click(selenium, chkSearchWithinMiles),
										"Could not click the KM radio button;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
							}
							if (prescribeData.patient.equals("Yes")) {
							 assertTrue(click(selenium, chkPatient),
										"Could not click the patient button;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
							}
							if (prescribeData.practice.equals("Yes")) {
							 assertTrue(click(selenium, chkPractice),
										"Could not click the practice button;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
							}
							if (prescribeData.zipcodecheck.equals("Yes")) {
							 assertTrue(click(selenium, chkFromZip),
										"Could not click the Zip button;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
							 assertTrue(
										type(selenium, txtFromZip,
												prescribeData.zipcodeCa),
												"Could not type the Zip code;More Details"
														+ prescribeData.toString(),selenium, ClassName, MethodName);
							}

						 assertTrue(click(selenium, btnSearchPharmacy),
									"Could not click the search button;More Details:"
											+ prescribeData.toString(),selenium, ClassName, MethodName);
							waitForPageLoad(selenium);
							waitForPageLoad(selenium);
							waitForPageLoad(selenium);
							while (isElementPresent(selenium,
									"//div[@id='adminPharmacyListView']/table/tbody/tr["
											+ count + "]/td/div")) {
								if (getText(
										selenium,
										"//div[@id='adminPharmacyListView']/table/tbody/tr["
												+ count + "]/td/div")
												.toLowerCase(new java.util.Locale("en", "Us"))
												.trim()
												.contains(
														prescribeData.pharmacyNameUS.trim()
														.toLowerCase(
																new java.util.Locale(
																		"en", "Us")))) {
								 assertTrue(click(selenium, "//tr[" + count
											+ "]/td[2]/div/a"),"",selenium, ClassName, MethodName);
									break;
								} else
									count++;
							}
						}
					}

					else {
						if (!isChecked(selenium, chkOneTimeOnly))

							assertTrue(click(selenium, chkOneTimeOnly), ""+ "Could not click the one time only check box;More Details:", selenium, ClassName,MethodName);
						waitForPageLoad(selenium);


						if (prescribeData.freeText.equals("Yes")) {
							if (!isChecked(selenium, chkFreeText))
								assertTrue(click(selenium, chkFreeText),
										"Could not click the Free text check box;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
						 assertTrue(
									type(selenium, txtDirectionNotes,
											prescribeData.direction),
											"Could not enter the text;More Details:"
													+ prescribeData.toString(),selenium, ClassName, MethodName);

						} else if (prescribeData.increaseDecreaseDose.equals("Yes")) {

							if (!isChecked(selenium, chkIncreaseDecreaseDirection))
							 assertTrue(
										click(selenium, chkIncreaseDecreaseDirection),
										"Could not click the Increase/Decrease Dose check box;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);

							selectValueFromAjaxList(selenium, ajxInRefillMethod,
									prescribeData.refillMethod);

							assertTrue(type(selenium, ajxInRefillQuantity,
									prescribeData.refillQuantity),"Could not type the duration1;More Details;"
									+ prescribeData.toString(),selenium, ClassName, MethodName);

							selectValueFromAjaxList(selenium, ajxInRefilUnit,
									prescribeData.refillUnit);

							selectValueFromAjaxList(selenium, ajxInRefillRoute,
									prescribeData.refillRoute);

							selectValueFromAjaxList(selenium, ajxInRefillFrequency,
									prescribeData.refillFrequency);
							/*selectValueFromAjaxList(selenium, ajxInRefillDuration,
									prescribeData.refillduration);*/
							selectValueFromAjaxList(selenium, ajxInRefillUsage,
									prescribeData.refillUsage4);

							selectValueFromAjaxList(selenium, ajxRefilUsage,
									prescribeData.refillUsage);

						/*	selectValueFromAjaxList(selenium, ajxInUsage,
									prescribeData.usage);*/

							selectValueFromAjaxList(selenium, ajxContinueDuration,
									prescribeData.refillUsage1);
							
							assertTrue(
									type(selenium, txtUntillReach,
											prescribeData.usage),
											"Could not type the duration1;More Details;"
													+ prescribeData.toString(),selenium, ClassName, MethodName);
							
							assertTrue(
									type(selenium, txtDuration,
											prescribeData.usage),
											"Could not type the duration;More Details;"
													+ prescribeData.toString(),selenium, ClassName, MethodName);
							
							assertTrue(
									type(selenium, txtDuration1,
											prescribeData.usage),
											"Could not type the duration;More Details;"
													+ prescribeData.toString(),selenium, ClassName, MethodName);
							
							assertTrue(
									type(selenium, ajxinRefillQuantiti3,
											prescribeData.usage),
											"Could not type the duration;More Details;"
													+ prescribeData.toString(),selenium, ClassName, MethodName);
							
						 assertTrue(
									type(selenium, txtDuration,
											prescribeData.durationIn),
											"Could not type the duration;More Details;"
													+ prescribeData.toString(),selenium, ClassName, MethodName);
						 assertTrue(selectValueFromAjaxList(selenium, ajxInRefillUsage1,
									prescribeData.refillUsage1),"could not enter data",selenium, ClassName, MethodName);

						/*	selectValueFromAjaxList(selenium, ajxInRefillUsage2,
									prescribeData.refillUsage2);*/

							assertTrue(selectValueFromAjaxList(selenium, ajaxInRefillUsage3,
									prescribeData.refillUsage3),"could not enter refil",selenium, ClassName, MethodName);
			if(selenium.isVisible(txtDurationNumber))
			{
			assertTrue(type(selenium,txtDurationNumber,prescribeData.usage),"Could not enter num",selenium, ClassName, MethodName);
			}
						 assertTrue(
									type(selenium, txtDirectionNotes,
											prescribeData.direction),
											"Could not enter the text;More Details:"
													+ prescribeData.toString(),selenium, ClassName, MethodName);
							waitForPageLoad(selenium);
							waitForPageLoad(selenium);
						} else if (prescribeData.multipleDirection.equals("Yes")) {
							if (!isChecked(selenium, chkMultipleDirection))
							 assertTrue(
										click(selenium, chkMultipleDirection),
										"Could not click the multiple direction check box;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);

							selectValueFromAjaxList(selenium, ajxMDRefilMethod,
									prescribeData.refillMethod);

							selectValueFromAjaxList(selenium, ajxMDRefillQuantity,
									prescribeData.refillQuantity);

							selectValueFromAjaxList(selenium, ajxMDRefillUnit,
									prescribeData.refillUnit);

							selectValueFromAjaxList(selenium, ajxMDRefillRoute,
									prescribeData.refillRoute);

							selectValueFromAjaxList(selenium, ajxMDRefillFrequency,
									prescribeData.refillFrequency);

							selectValueFromAjaxList(selenium, ajxMDRefillDuration,
									prescribeData.refillduration);

							selectValueFromAjaxList(selenium, ajxMDRefillUsage,
									prescribeData.refillUsage5);

							selectValueFromAjaxList(selenium, ajxMDMethod,
									prescribeData.method);
							selectValueFromAjaxList(selenium, ajxMDQuantity,
									prescribeData.quality);

							selectValueFromAjaxList(selenium, ajxMDUnit,
									prescribeData.unit);

							selectValueFromAjaxList(selenium, ajxMDRoute,
									prescribeData.route);
							selectValueFromAjaxList(selenium, ajxMDFrequency,
									prescribeData.frequency);
							selectValueFromAjaxList(selenium, ajxMDUsage,
									prescribeData.refillUsage4);

						 assertTrue(
									type(selenium, txtDirectionNotes,
											prescribeData.direction),
											"Could not enter the text;More Details:"
													+ prescribeData.toString(),selenium, ClassName, MethodName);
						} else if (!prescribeData.freeText.equals("Yes")
								&& !prescribeData.increaseDecreaseDose.equals("Yes")
								&& !prescribeData.multipleDirection.equals("Yes")) {

							if (isChecked(selenium, chkFreeText))
							 assertTrue(click(selenium, chkFreeText),
										"Could not un check the Free text check box;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);

							if (isChecked(selenium, chkIncreaseDecreaseDirection))
							 assertTrue(
										click(selenium, chkIncreaseDecreaseDirection),
										"Could not un check the Increase/Decrease Dose check box;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);

							if (isChecked(selenium, chkMultipleDirection))
							 assertTrue(
										click(selenium, chkMultipleDirection),
										"Could not un check the multiple direction check box;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);

							waitForPageLoad(selenium);
							selectValueFromAjaxList(selenium, ajxMethod,
									prescribeData.refillMethod);
							selectValueFromAjaxList(selenium, ajxQuantity,
									prescribeData.quality);

							selectValueFromAjaxList(selenium, ajxUnit,
									prescribeData.unit);

							selectValueFromAjaxList(selenium, ajxRoute,
									prescribeData.route);

							selectValueFromAjaxList(selenium, ajxFrequency,
									prescribeData.frequency);

							selectValueFromAjaxList(selenium, ajxDuration,
									prescribeData.duration);

							selectValueFromAjaxList(selenium, ajxUsage,
									prescribeData.refillUsage4);

							assertTrue(
									type(selenium, txtDirectionNotes,
											prescribeData.direction),
											"Could not enter the text;More Details:"
													+ prescribeData.toString(),selenium, ClassName, MethodName);
							waitForPageLoad(selenium);
						}

						if (prescribeData.testCaseId.equalsIgnoreCase("TC_PM_023")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_029")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_042")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_043")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_073")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_074")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_075")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_076")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_077")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_087")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_090")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_091")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_102")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_103")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_109")
								|| prescribeData.testCaseId
								.equalsIgnoreCase("TC_PM_111")) {
							 assertTrue(
									type(selenium, txtFreeFormText,
											prescribeData.prescribeName),
											"Could not enter the medication free text;More Details:"
													+ prescribeData.toString(),selenium, ClassName, MethodName);
							waitForPageLoad(selenium);
						}

						if (prescribeData.testCaseId.equalsIgnoreCase("TC_PM_013")) {
							selenium.clickAt(txtDirectionNotes, "");

							 assertTrue(getText(selenium, lblAddDirection)
									.equalsIgnoreCase("190 characters remaining."),
									"Additional directions count is not deducted properly",selenium, ClassName, MethodName);
						}

						 assertTrue(
								type(selenium, "durationNumberID", "2"),
								"Could not enter dispense;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
						 assertTrue(
								type(selenium, txtDispense, prescribeData.dispense),
								"Could not enter dispense;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						if(isElementPresent(selenium,yesLink))
						{
					click(selenium,yesLink);
						}
						selectValueFromAjaxList(selenium, ajxUnitList,
								prescribeData.unitList);
						waitForPageLoad(selenium);
						click(selenium, "//body/div[5]/div/div/div/div/div");
						waitForPageLoad(selenium);
						Calendar cal = Calendar.getInstance();
						SimpleDateFormat DateFormat1 = new SimpleDateFormat(
								"MM/dd/yyyy");
						date = DateFormat1.format(cal.getTime());
						 assertTrue(enterDate(selenium, txtFillon, date),
								"Could not enter the Date;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
						
						/*
						 * if(prescribeData.testCaseId.equalsIgnoreCase("TC_PM_025")){
						 * Assert
						 * .assertTrue(type(selenium,txtofRefills,prescribeData.ofRefill
						 * ),"Could not enter the Refill;More Details:"+prescribeData.
						 * toString()); }
						 */

						if (!prescribeData.ofRefill.isEmpty()) {
							if (!prescribeData.testCaseId.equalsIgnoreCase("TC_PM_004")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_036")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_064")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_025")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_078")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_085")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_088")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_089")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_099")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_101")
									&& !prescribeData.testCaseId
									.equalsIgnoreCase("TC_PM_55")) {

								assertTrue(
										type(selenium, txtofRefills,
												prescribeData.ofRefill),
												"Could not enter the Refill;More Details:"
														+ prescribeData.toString(),selenium, ClassName, MethodName);
								assertTrue(
										type(selenium, txtDurationNo,
												prescribeData.ofRefill),
												"Could not enter the no of Refill;More Details:"
														+ prescribeData.toString(),selenium, ClassName, MethodName);
								selectValueFromAjaxList(selenium, ajxRFDurationList,
										prescribeData.refillUsage1);
								selectValueFromAjaxList(selenium, ajxRFMethod,
										prescribeData.refillMethod);

								selectValueFromAjaxList(selenium, ajxRFQuatity,
										prescribeData.refillQuantity);

								selectValueFromAjaxList(selenium, ajxRFUnit,
										prescribeData.refillUnit);
								selectValueFromAjaxList(selenium, ajxRFRoute,
										prescribeData.refillRoute);

								selectValueFromAjaxList(selenium, ajxRFFrequency,
										prescribeData.refillFrequency);

								selectValueFromAjaxList(selenium, ajxRFDuration,
										prescribeData.refillduration);
								selectValueFromAjaxList(selenium, ajxRFUsage,
										prescribeData.refillUsage4);
							}
						}
						assertTrue(
								type(selenium, txtNotesToPharmacy,
										prescribeData.notesToPharmacy),
										"Could not enter dispense;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
						if (prescribeData.subPermitted.equals("Yes")) {
							if (!isChecked(selenium, chkSubPermitted))
								assertTrue(click(selenium, chkSubPermitted),
										"Could not click the permitted check box;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
						}
						if (prescribeData.comePackage.equals("Yes")) {
							assertTrue(click(selenium, ckkPrescribtionOption),
									"Could not click the PrescribtionOption;More Details:"
											+ prescribeData.toString(),selenium, ClassName, MethodName);
							if (!isChecked(selenium, chkComPackage))
								assertTrue(click(selenium, chkComPackage),
										"Could not click the com Packing check box;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
						}
						if (prescribeData.saveList.equals("Yes")) {
							if (!isChecked(selenium, chkQuickList))
								assertTrue(click(selenium, chkQuickList),
										"Could not click the save list;More Details"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
						}

						if (prescribeData.testCaseId.equals("TC_PM_026")
								|| prescribeData.testCaseId.equals("TC_PM_071")
								|| prescribeData.testCaseId.equals("TC_PM_079")
								|| prescribeData.testCaseId.equals("TC_PM_080")
								|| prescribeData.testCaseId.equals("TC_PM_082")) {
							int count = 1;
							waitForPageLoad(selenium);
							assertTrue(click(selenium, btnSearchDatabase), ""
									+ "Could not click the Search Databbase button;More Details:", selenium, ClassName,
									MethodName);
							waitForPageLoad(selenium);
							selectValueFromAjaxList(selenium, ajxSearch,
									prescribeData.searchWithin);
							if (prescribeData.searchWithinKM.equals("Yes")) {

								waitForPageLoad(selenium);
								assertTrue(click(selenium, chkSearchwithin), ""
										+ "Could not click the KM radio button;More Details:", selenium, ClassName,
										MethodName);

							}
							if (prescribeData.searchWithinMiles.equals("Yes")) {

								assertTrue(click(selenium, chkSearchWithinMiles), ""
										+ "Could not click the Miles radio button;More Details:", selenium, ClassName,
										MethodName);						

							}
							if (prescribeData.patient.equals("Yes")) {
								assertTrue(click(selenium, chkPatient),
										"Could not click the patient button;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
							}
							if (prescribeData.practice.equals("Yes")) {
								assertTrue(click(selenium, chkPatient),
										"Could not click the practice button;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
							}
							if (prescribeData.zipcodecheck.equals("Yes")) {
								assertTrue(click(selenium, chkFromZip),
										"Could not click the Zip button;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
								assertTrue(
										type(selenium, txtFromZip,
												prescribeData.zipcode),
												"Could not type the Zip code;More Details"
														+ prescribeData.toString(),selenium, ClassName, MethodName);
							}

							assertTrue(click(selenium, btnSearchPharmacy),
									"Could not click the search button;More Details:"
											+ prescribeData.toString(),selenium, ClassName, MethodName);
							waitForPageLoad(selenium);
							waitForPageLoad(selenium);
							while (isElementPresent(selenium,
									"//div[@id='adminPharmacyListView']/table/tbody/tr["
											+ count + "]/td/div")) {
								if (getText(
										selenium,
										"//div[@id='adminPharmacyListView']/table/tbody/tr["
												+ count + "]/td/div")
												.toLowerCase(new java.util.Locale("en", "Us"))
												.trim()
												.contains(
														prescribeData.pharmacyName.trim()
														.toLowerCase(
																new java.util.Locale(
																		"en", "Us")))) {
									assertTrue(click(selenium, "//tr[" + count
											+ "]/td[2]/div/a"),"Could not Click",selenium, ClassName, MethodName);
									break;
								} else
									count++;
							}
						}
					}
			if(isElementPresent(selenium,"link=No"))
					{
						assertTrue(click(selenium, "link=No"),
								"Could not click No button in dispense window;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
					}

					assertTrue(click(selenium, btnContinueId),
							"Could not click the Continue button;More Details:"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
			waitForPageLoad(selenium);

					if (isElementPresent(selenium, btnEdit)) {
						return true;
					} else {
						return false;
					}

				} catch (RuntimeException e) {
					e.printStackTrace();
				}
				return false;
			}



	/**
	 * prescribeMedicationUnitTest function to create unit test for prescribe
	 * medication.
	 * @throws IOException 
	 * 
	 * @since Sep 18, 2012
	 */
	public boolean prescribeMedicationUnitTest(Selenium selenium,
			ChartPreVisitLibUnitTest prescribeTestData) throws IOException {
		boolean returnValue = false;
		try {
			waitForPageLoad(selenium);
			/*
			 * if(!prescribeTestData.responsibleProvider.isEmpty())
			 * if(!prescribeTestData.responsibleProvider.contains("N/A"))
			 * selectValueFromAjaxList
			 * (selenium,ajxProvider,prescribeTestData.responsibleProvider);
			 * click(selenium,"//body/div[4]/div/div/div/div/div");
			 * 
			 * if(!prescribeTestData.location.isEmpty())
			 * if(!prescribeTestData.location.contains("N/A"))
			 * selectValueFromAjaxList
			 * (selenium,"locationListSuggestBoxsuggestBox"
			 * ,prescribeTestData.location);
			 * click(selenium,"//body/div[4]/div/div/div/div/div");
			 */

			if (!prescribeTestData.oneTimeOnly.isEmpty())
				if (!prescribeTestData.oneTimeOnly.contains("N/A"))
					assertTrue(click(selenium, chkOneTimeOnly),
							"Could not click one time only check box More Dateils"
									+ prescribeTestData.toString(),selenium, ClassName, MethodName);
			if (!prescribeTestData.freeText.isEmpty()) {
				if (!prescribeTestData.freeText.contains("N/A"))
					if (!isChecked(selenium, chkFreeText)) {
						assertTrue(click(selenium, chkFreeText),
								"Could not click Ener As Free Text Check Box More Dateils"
										+ prescribeTestData.toString(),selenium, ClassName, MethodName);
						if (prescribeTestData.testCaseId
								.equalsIgnoreCase("TC_PM_090"))
							assertTrue(
									type(selenium,
											txtDirectionNotes,
											prescribeTestData.pharmacistDirection),
											"Could not type the afree text : More Details"
													+ prescribeTestData.toString(),selenium, ClassName, MethodName);
						else
							assertTrue(
									type(selenium, txtDirectionNotes,
											prescribeTestData.freeText),
											"Could not type the afree text : More Details"
													+ prescribeTestData.toString(),selenium, ClassName, MethodName);
					}
			} else if (!prescribeTestData.increaseDose.isEmpty()) {
				if (prescribeTestData.increaseDose.contains("Yes"))

				{
					if (!isChecked(selenium, chkIncreaseDecreaseDirection))
						assertTrue(
								click(selenium, chkIncreaseDecreaseDirection),
								"Could not click Increase/Decrease Check Box More Dateils"
										+ prescribeTestData.toString(),selenium, ClassName, MethodName);
					if (prescribeTestData.refillmethod.isEmpty())
						selectEmptyValueFromAjaxList(selenium,
								ajxInRefillMethod,
								prescribeTestData.refillmethod);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.refillQuantity.isEmpty())
						if (!prescribeTestData.refillQuantity.contains("N/A"))
							selectValueFromAjaxList(selenium,
									ajxInRefillQuantity,
									prescribeTestData.refillQuantity);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.refillUnit.isEmpty())
						if (!prescribeTestData.refillUnit.contains("N/A"))
							selectValueFromAjaxList(selenium, ajxInRefilUnit,
									prescribeTestData.refillUnit);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.refillRoute.isEmpty())
						if (!prescribeTestData.refillRoute.contains("N/A"))
							selectValueFromAjaxList(selenium, ajxInRefillRoute,
									prescribeTestData.refillRoute);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.refillFrequency.isEmpty())
						if (!prescribeTestData.refillFrequency.contains("N/A"))
							selectValueFromAjaxList(selenium,
									ajxInRefillFrequency,
									prescribeTestData.refillFrequency);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (prescribeTestData.reduce.isEmpty())
						selectEmptyValueFromAjaxList(selenium, ajxRefilUsage,
								prescribeTestData.reduce);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.reduceQuantity.isEmpty())
						if (!prescribeTestData.reduceQuantity.contains("N/A"))
							assertTrue(
									type(selenium, ajxInRefillUsage1,
											prescribeTestData.reduceUsage),
									"Could not type the reduce usage/duration",selenium, ClassName, MethodName);
					if (!prescribeTestData.refillDuration.isEmpty())
						if (!prescribeTestData.refillDuration.contains("N/A"))
							assertTrue(
									type(selenium, txtDuration,
											prescribeTestData.refillDuration),
									"could not type the duration",selenium, ClassName, MethodName);
					if (!prescribeTestData.reduceDuration.isEmpty())
						if (prescribeTestData.testCaseId.equals("TC_PM_064")
								|| prescribeTestData.testCaseId
								.equals("TC_PM_065")
								|| prescribeTestData.testCaseId
								.equals("TC_PM_066")) {

							selectValueFromAjaxList(selenium,
									ajxInRefillUsage1,
									prescribeTestData.reduceDuration);

						} else

							selectEmptyValueFromAjaxList(selenium,
									ajxInRefillUsage1,
									prescribeTestData.reduceDuration);

					click(selenium, "//body/div[4]/div/div/div/div/div");

					if (!prescribeTestData.stopQuantity.isEmpty())
						if (!prescribeTestData.stopQuantity.contains("N/A"))
							assertTrue(
									type(selenium, ajxInRefillUsage2,
											prescribeTestData.reduceQuantity),
									"Could not type the reduce quantity/target",selenium, ClassName, MethodName);

					if (prescribeTestData.stop.contains(""))
						selectEmptyValueFromAjaxList(selenium,
								ajaxInRefillUsage3, prescribeTestData.stop);
					click(selenium, "//body/div[4]/div/div/div/div/div");
				}
			} else if (!prescribeTestData.multipleDirections.isEmpty()) {
				if (prescribeTestData.multipleDirections.contains("Yes")) {

					if (!isChecked(selenium, chkMultipleDirection))
						assertTrue(
								click(selenium, chkMultipleDirection),
								"Could not click Increase/Decrease Check Box More Dateils"
										+ prescribeTestData.toString(),selenium, ClassName, MethodName);
					if (prescribeTestData.refillmethod.isEmpty())
						selectEmptyValueFromAjaxList(selenium,
								ajxMDRefilMethod,
								prescribeTestData.refillmethod);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.refillQuantity.isEmpty())
						if (!prescribeTestData.refillQuantity.contains("N/A"))
							selectValueFromAjaxList(selenium,
									ajxMDRefillQuantity,
									prescribeTestData.refillQuantity);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.refillUnit.isEmpty())
						if (!prescribeTestData.refillUnit.contains("N/A"))
							selectValueFromAjaxList(selenium, ajxMDRefillUnit,
									prescribeTestData.refillUnit);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.refillRoute.isEmpty())
						if (!prescribeTestData.refillRoute.contains("N/A"))
							selectValueFromAjaxList(
									selenium,
									"xpath=(//input[@id='refillRouteSuggestBoxsuggestBox'])[3]",
									prescribeTestData.refillRoute);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.refillFrequency.isEmpty())
						if (!prescribeTestData.refillFrequency.contains("N/A"))
							selectValueFromAjaxList(selenium,
									ajxMDRefillFrequency,
									prescribeTestData.refillFrequency);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.refillDuration.isEmpty())
						if (!prescribeTestData.refillDuration.contains("N/A"))
							selectValueFromAjaxList(selenium,
									ajxMDRefillDuration,
									prescribeTestData.refillDuration);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.refillUsage.isEmpty())
						if (!prescribeTestData.refillUsage.contains("N/A"))
							selectValueFromAjaxList(selenium, ajxMDRefillUsage,
									prescribeTestData.refillUsage);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (prescribeTestData.refillmethod1.isEmpty())
						selectEmptyValueFromAjaxList(selenium, ajxMDMethod,
								prescribeTestData.refillmethod);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.refillQuantity1.isEmpty())
						if (!prescribeTestData.refillQuantity1.contains("N/A"))
							selectValueFromAjaxList(selenium, ajxMDQuantity,
									prescribeTestData.refillQuantity1);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.refillUnit1.isEmpty())
						if (!prescribeTestData.refillUnit1.contains("N/A"))
							selectValueFromAjaxList(selenium, ajxMDUnit,
									prescribeTestData.refillUnit1);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.refillRoute1.isEmpty())
						if (!prescribeTestData.refillRoute1.contains("N/A"))
							selectValueFromAjaxList(selenium, ajxMDRoute,
									prescribeTestData.refillRoute1);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.refillFrequency1.isEmpty())
						if (!prescribeTestData.refillFrequency1.contains("N/A"))
							selectValueFromAjaxList(selenium, ajxMDFrequency,
									prescribeTestData.refillFrequency1);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.refillDuration1.isEmpty())
						if (!prescribeTestData.refillDuration1.contains("N/A"))
							selectValueFromAjaxList(selenium, ajxMDDuration,
									prescribeTestData.refillDuration1);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.refillUsage1.isEmpty())
						if (!prescribeTestData.refillUsage1.contains("N/A"))
							selectValueFromAjaxList(selenium, ajxMDUsage,
									prescribeTestData.refillUsage1);
					click(selenium, "//body/div[4]/div/div/div/div/div");
				}
			} else {
				if (isChecked(selenium, chkMultipleDirection))
					assertTrue(click(selenium, chkMultipleDirection),
							"Could not click multiple Direction Check Box More Dateils"
									+ prescribeTestData.toString(),selenium, ClassName, MethodName);
				if (isChecked(selenium, chkIncreaseDecreaseDirection))
					assertTrue(
							click(selenium, chkIncreaseDecreaseDirection),
							"Could not click Increase/Decrease Check Box More Dateils"
									+ prescribeTestData.toString(),selenium, ClassName, MethodName);
				if (isChecked(selenium, chkFreeText))
					assertTrue(click(selenium, chkFreeText),
							"Could not click free Text Check Box More Dateils"
									+ prescribeTestData.toString(),selenium, ClassName, MethodName);
				if (prescribeTestData.refillmethod.isEmpty())
					selectEmptyValueFromAjaxList(selenium, ajxMethod,
							prescribeTestData.refillmethod);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				if (!prescribeTestData.refillQuantity.isEmpty())
					if (!prescribeTestData.refillQuantity.contains("N/A"))
						selectValueFromAjaxList(selenium, ajxQuantity,
								prescribeTestData.refillQuantity);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				if (!prescribeTestData.refillUnit.isEmpty())
					if (!prescribeTestData.refillUnit.contains("N/A"))
						selectValueFromAjaxList(selenium, ajxUnit,
								prescribeTestData.refillUnit);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				if (!prescribeTestData.refillRoute.isEmpty())
					if (!prescribeTestData.refillRoute.contains("N/A"))
						selectValueFromAjaxList(selenium, ajxRoute,
								prescribeTestData.refillRoute);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				if (!prescribeTestData.refillFrequency.isEmpty())
					if (!prescribeTestData.refillFrequency.contains("N/A"))
						selectValueFromAjaxList(selenium, ajxFrequency,
								prescribeTestData.refillFrequency);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				if (!prescribeTestData.refillDuration.isEmpty())
					if (!prescribeTestData.refillDuration.contains("N/A"))
						selectValueFromAjaxList(selenium, ajxDuration,
								prescribeTestData.refillDuration);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				if (!prescribeTestData.refillUsage.isEmpty())
					if (!prescribeTestData.refillUsage.contains("N/A"))
						selectValueFromAjaxList(selenium, ajxRefillUsage,
								prescribeTestData.refillUsage);
				click(selenium, "//body/div[4]/div/div/div/div/div");
			}
			if (!prescribeTestData.adddirection.isEmpty())
				if (!prescribeTestData.adddirection.contains("N/A"))
					assertTrue(
							type(selenium, txtDirectionNotes,
									prescribeTestData.adddirection),
									"Could not type the additional directions : More Details"
											+ prescribeTestData.toString(),selenium, ClassName, MethodName);
			if (!prescribeTestData.dispense.contains("N/A"))
				type(selenium, txtDispense, prescribeTestData.dispense);
			if (!prescribeTestData.dispenseUnit.isEmpty())
				if (!prescribeTestData.dispenseUnit.contains("N/A"))
					selectValueFromAjaxList(selenium, ajxUnitList,
							prescribeTestData.dispenseUnit);
			click(selenium, "//body/div[4]/div/div/div/div/div");
			if (!prescribeTestData.fillOn.isEmpty())
				if (!prescribeTestData.fillOn.contains("N/A"))
					type(selenium, txtFillon, prescribeTestData.fillOn);
			if (!prescribeTestData.refills.isEmpty())
				if (!prescribeTestData.refills.contains("0")) {
					assertTrue(
							type(selenium, txtofRefills,
									prescribeTestData.refills),
							"Could not type refills",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					if (!prescribeTestData.refillDays.isEmpty())
						if (!prescribeTestData.refillDays.contains("N/A"))
							assertTrue(
									type(selenium, txtDurationNo,
											prescribeTestData.refillDays),
									"Could not type the refill days",selenium, ClassName, MethodName);
					if (prescribeTestData.pharmacistDuration.isEmpty())
						selectEmptyValueFromAjaxList(selenium,
								ajxRFDurationList,
								prescribeTestData.pharmacistDuration);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (prescribeTestData.pharmacistMethod.isEmpty())
						selectEmptyValueFromAjaxList(selenium, ajxrefillMethod,
								prescribeTestData.pharmacistMethod);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.pharmacistQuantity.isEmpty())
						if (!prescribeTestData.pharmacistQuantity
								.contains("N/A"))
							selectValueFromAjaxList(
									selenium,
									"//div[2]/div/div/div/div/div[2]/div/div/input",
									prescribeTestData.pharmacistQuantity);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.pharmacistUnit.isEmpty())
						if (!prescribeTestData.pharmacistUnit.contains("N/A"))
							selectValueFromAjaxList(
									selenium,
									"//div[2]/div/div/div/div/div[3]/div/div/input",
									prescribeTestData.pharmacistUnit);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.pharmacistRoute.isEmpty())
						if (!prescribeTestData.pharmacistRoute.contains("N/A"))
							selectValueFromAjaxList(
									selenium,
									"//div[2]/div/div/div/div/div[4]/div/div/input",
									prescribeTestData.pharmacistRoute);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.pharmacistFrequency.isEmpty())
						if (!prescribeTestData.pharmacistFrequency
								.contains("N/A"))
							selectValueFromAjaxList(
									selenium,
									"//div[9]/div[2]/div/div/div/div[2]/div/div/div/input",
									prescribeTestData.pharmacistFrequency);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.pharmacistDirection.isEmpty())
						if (!prescribeTestData.pharmacistDirection
								.contains("N/A"))
							selectValueFromAjaxList(
									selenium,
									"//div[2]/div/div/div/div[2]/div[2]/div/div/input",
									prescribeTestData.pharmacistDirection);
					if (!prescribeTestData.pharmacistUsage.isEmpty())
						if (!prescribeTestData.pharmacistUsage.contains("N/A"))
							selectValueFromAjaxList(
									selenium,
									"//div[2]/div/div/div/div[2]/div[3]/div/div/input",
									prescribeTestData.pharmacistUsage);
					click(selenium, "//body/div[4]/div/div/div/div/div");

				}
			if (prescribeTestData.testCaseId.equalsIgnoreCase("TC_PM_086")
					|| prescribeTestData.testCaseId
					.equalsIgnoreCase("TC_PM_088")) {
				assertTrue(
						type(selenium, "xpath=(//button[@type='button'])[9]",
								prescribeTestData.freeText),
								"Could not enter the medication free text;More Details:"
										+ prescribeTestData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if (!prescribeTestData.notesToPharmacy.isEmpty())
				if (!prescribeTestData.notesToPharmacy.contains("N/A"))
					assertTrue(
							type(selenium, txtNotesToPharmacy,
									prescribeTestData.notesToPharmacy),
									"Could not type the last name : More Details"
											+ prescribeTestData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, chkSubPermitted),
					"Could not click Substitutions permitted"
							+ prescribeTestData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					click(selenium, chkComPackage),
					"Could not click compliance packaging"
							+ prescribeTestData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					click(selenium, chkQuickList),
					"Could not click save to quick"
							+ prescribeTestData.toString(),selenium, ClassName, MethodName);
			if (!prescribeTestData.internalNotes.isEmpty())
				if (!prescribeTestData.notesToPharmacy.contains("N/A"))
					assertTrue(
							type(selenium, txtNotesToPharmacy,
									prescribeTestData.internalNotes),
									"Could not type the notes to pharmacy : More Details"
											+ prescribeTestData.toString(),selenium, ClassName, MethodName);
			if (!prescribeTestData.problem.isEmpty())
				if (!prescribeTestData.problem.contains("N/A"))
					selectValueFromAjaxList(selenium,
							"problemSuggestBoxsuggestBox",
							prescribeTestData.problem);
			click(selenium, "//body/div[4]/div/div/div/div/div");
			if (!prescribeTestData.searchDatabase.isEmpty())
				if (prescribeTestData.searchDatabase.contains("Yes")) {
					assertTrue(click(selenium, btnSearchDatabase),
							"Could not click search Database button More Dateils"
									+ prescribeTestData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					if (!prescribeTestData.searchWithin.isEmpty())
						if (!prescribeTestData.searchWithin.contains("N/A"))
							selectValueFromAjaxList(selenium, "searchWithin",
									prescribeTestData.searchWithin);
					click(selenium, "//body/div[4]/div/div/div/div/div");
					if (!prescribeTestData.zipText.isEmpty())
						if (!prescribeTestData.zipText.contains("N/A"))
							assertTrue(
									type(selenium, txtFromZip,
											prescribeTestData.zipText),
											"Could not type the zip text : More Details"
													+ prescribeTestData.toString(),selenium, ClassName, MethodName);
					assertTrue(click(selenium, btnSearchPharmacy),
							"Could not click Save button More Dateils"
									+ prescribeTestData.toString(),selenium, ClassName, MethodName);
				}
			if (!prescribeTestData.searchDatabase.contains("Yes"))
				if (!prescribeTestData.testCaseId.equalsIgnoreCase("TC_PM_086"))
					assertTrue(click(selenium, btnContinueId),
							"Could not click continue button More Dateils"
									+ prescribeTestData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;
			waitForPageLoad(selenium);
		} catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"
					+ e.getMessage()
					+ "\n\t*); Detailed data:"
					+ prescribeTestData.toString());
		}
		return returnValue;
	}

	/**
	 * deleteAllPendingMedication Function for delete All existing pending
	 * medication
	 * 
	 * @param selenium
	 * @param prescribeData
	 * @return
	 * @throws IOException
	 * @since Dec 18,2012
	 */
	public boolean deleteAllPendingMedication(Selenium selenium,
			ChartPreVisitLib prescribeData) throws IOException {
		boolean medDeleted = true;
		// int medCount=0;
		try {
			prescribeData.show="Pending";

//			assertTrue(click(selenium, lnkMore),
//					"Could not click on More  link",selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkMedicationTab),
					"could not click the medication tab", selenium, ClassName,
					MethodName);
			waitForElement(selenium, lnkOption1, WAIT_TIME);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxRxShow, prescribeData.show);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);

			waitForPageLoad(selenium);

			while ((selenium.isElementPresent("link=Actions") && selenium
					.isTextPresent("Pending Sign Off"))) {

				// medCount=(Integer) selenium.getXpathCount(lnkOption1);
				selenium.focus("link=Actions");
				selenium.clickAt("link=Actions", "");
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				if (isElementPresent(selenium, lnkDelete)) {
					assertTrue(click(selenium, lnkDelete),
							"Clcick delete link",selenium, ClassName, MethodName);
				} else
					assertTrue(click(selenium, "//a[3]/span"),
							"Clcick delete link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);				
				assertTrue(
						type(selenium, txtDeleteReaseon,"Reason"),
						"Could not type reason for deletion",selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnContinue),
						"Could not click Delete button;More Details:"
								+ prescribeData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				/*
				 * if(medCount == (Integer) selenium.getXpathCount(lnkOption1)){
				 * medDeleted = false; break; }
				 */
				waitForPageLoad(selenium);
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return medDeleted;
	}

	/**
	 * addPrescribeMedication function to add Prescribe Medication
	 * 
	 * @since Mar 06, 2012
	 */
	public boolean addSecondPrescribeMedication(Selenium selenium,
			ChartPreVisitLib prescribeData, String account) throws IOException {
		String date = null;
		try {
			if (account.equals(CAAccount)) {
				assertTrue(click(selenium, chkOneTimeOnly),
						"Could not click the one time only check box;More Details:"
								+ prescribeData.toString(),selenium, ClassName, MethodName);
				if (prescribeData.freeText.equals("Yes")) {
					if (!isChecked(selenium, chkFreeText))
						assertTrue(click(selenium, chkFreeText),
								"Could not click the Free text check box;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
					assertTrue(
							type(selenium, txtDirectionNotes,
									prescribeData.direction),
									"Could not enter the text;More Details:"
											+ prescribeData.toString(),selenium, ClassName, MethodName);
					assertTrue(
							type(selenium, txtDispense, prescribeData.dispense),
							"Could not enter dispense;More Details:"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium, ajxUnitList,
							prescribeData.unitListCA);

				}
				if (prescribeData.increaseDecreaseDose.equals("Yes")) {
					if (!isChecked(selenium, chkIncreaseDecreaseDirection))
						assertTrue(
								click(selenium, chkIncreaseDecreaseDirection),
								"Could not click the Increase/Decrease Dose check box;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium, ajxInRefillMethod,
							prescribeData.refillMethodCa);

					selectValueFromAjaxList(selenium, ajxInRefillQuantity,
							prescribeData.refillQuantityCa);

					selectValueFromAjaxList(selenium, ajxInRefilUnit,
							prescribeData.refillUnitCa);

					selectValueFromAjaxList(selenium, ajxInRefillRoute,
							prescribeData.refillRouteCa);

					selectValueFromAjaxList(selenium, ajxInRefillFrequency,
							prescribeData.refillFrequencyCa);
					selectValueFromAjaxList(selenium, ajxInRefillDuration,
							prescribeData.refilldurationCa);
					selectValueFromAjaxList(selenium, ajxInRefillUsage,
							prescribeData.refillUsageCa);

					selectValueFromAjaxList(selenium, ajxInUsage,
							prescribeData.usageCa);

					assertTrue(
							type(selenium, txtDuration, prescribeData.duration),
							"Could not type the duration;More Details;"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium, ajxInRefillUsage1,
							prescribeData.refillUsage1Ca);

					selectValueFromAjaxList(selenium, ajxInRefillUsage2,
							prescribeData.refillUsage2Ca);

					selectValueFromAjaxList(selenium, ajaxInRefillUsage3,
							prescribeData.refillUsage3Ca);

					waitForPageLoad(selenium);
				}
				if (prescribeData.multipleDirection.equals("Yes")) {
					if (!isChecked(selenium, chkMultipleDirection))
						assertTrue(
								click(selenium, chkMultipleDirection),
								"Could not click the multiple direction check box;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium, ajxMDRefilMethod,
							prescribeData.refillMethodCa);

					selectValueFromAjaxList(selenium, ajxMDRefillQuantity,
							prescribeData.refillQuantityCa);

					selectValueFromAjaxList(selenium, ajxMDRefillUnit,
							prescribeData.refillUnitCa);

					selectValueFromAjaxList(selenium, ajxMDRefillRoute,
							prescribeData.refillRouteCa);

					selectValueFromAjaxList(selenium, ajxMDRefillFrequency,
							prescribeData.refillFrequencyCa);

					selectValueFromAjaxList(selenium, ajxMDRefillDuration,
							prescribeData.refilldurationCa);

					selectValueFromAjaxList(selenium, ajxMDRefillUsage,
							prescribeData.refillUsage1Ca);

					selectValueFromAjaxList(selenium, ajxMDMethod,
							prescribeData.methodCa);
					selectValueFromAjaxList(selenium, ajxMDQuantity,
							prescribeData.qualityCa);

					selectValueFromAjaxList(selenium, ajxMDUnit,
							prescribeData.unitCa);

					selectValueFromAjaxList(selenium, ajxMDRoute,
							prescribeData.routeCa);
					selectValueFromAjaxList(selenium, ajxMDFrequency,
							prescribeData.frequencyCa);

					selectValueFromAjaxList(selenium, ajxMDDuration,
							prescribeData.duration);

					selectValueFromAjaxList(selenium, ajxMDUsage,
							prescribeData.usageCa);
				} else if (!prescribeData.freeText.equals("Yes")
						&& !prescribeData.increaseDecreaseDose.equals("Yes")
						&& !prescribeData.multipleDirection.equals("Yes")) {
					// waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium, ajxMethod,
							prescribeData.refillMethodCa);
					selectValueFromAjaxList(selenium, ajxQuantity,
							prescribeData.qualityCa);

					selectValueFromAjaxList(selenium, ajxUnit,
							prescribeData.unitCa);

					selectValueFromAjaxList(selenium, ajxRoute,
							prescribeData.routeCa);

					selectValueFromAjaxList(selenium, ajxFrequency,
							prescribeData.frequencyCa);

					selectValueFromAjaxList(selenium, ajxDuration,
							prescribeData.duration);

					selectValueFromAjaxList(selenium, ajxUsage,
							prescribeData.refillUsage4Ca);

					assertTrue(
							type(selenium, txtDirectionNotes,
									prescribeData.direction),
									"Could not enter the text;More Details:"
											+ prescribeData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				if (prescribeData.testCaseId.equalsIgnoreCase("TC_PM_023")
						|| prescribeData.testCaseId
						.equalsIgnoreCase("TC_PM_029")
						|| prescribeData.testCaseId
						.equalsIgnoreCase("TC_PM_042")
						|| prescribeData.testCaseId
						.equalsIgnoreCase("TC_PM_043")
						|| prescribeData.testCaseId
						.equalsIgnoreCase("TC_PM_030")) {
//					assertTrue(
//							type(selenium, txtFreeFormText,
//									prescribeData.prescribeNameCa),
//									"Could not enter the medication free text;More Details:"
//											+ prescribeData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				if (prescribeData.testCaseId.equalsIgnoreCase("TC_PM_013")) {
					selenium.clickAt(txtDirectionNotes, "");
					System.out.println(getText(selenium, lblAddDirection));
					assertTrue(getText(selenium, lblAddDirection)
							.equalsIgnoreCase(prescribeData.addDirectionCount),
							"Additional directions count is not deducted properly",selenium, ClassName, MethodName);
				}
				assertTrue(
						type(selenium, txtDispense, prescribeData.dispense),
						"Could not enter dispense;More Details:"
								+ prescribeData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				selectValueFromAjaxList(selenium, ajxUnitList,
						prescribeData.unitListCA);

				//click(selenium, "//body/div[4]/div/div/div/div/div");

				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat1 = new SimpleDateFormat(
						"dd/MM/yyyy");
				date = DateFormat1.format(cal.getTime());
				assertTrue(enterDate(selenium, txtFillon, date),
						"Could not enter the Date;More Details:"
								+ prescribeData.toString(),selenium, ClassName, MethodName);

				if (!prescribeData.ofRefill.isEmpty()) {
					if (!prescribeData.testCaseId.equalsIgnoreCase("TC_PM_004")
							&& !prescribeData.testCaseId
							.equalsIgnoreCase("TC_PM_036")) {
						assertTrue(
								type(selenium, txtofRefills,
										prescribeData.ofRefill),
										"Could not enter the Refill;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						assertTrue(click(selenium,lnkRefillOption),"Could not click Refill Option;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
						assertTrue(
								type(selenium, txtRefillDurationNo,
										prescribeData.ofRefill),
										"Could not enter the no of Refill;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
						type(selenium, txtRefillDispense,
								prescribeData.dispense);
//						selectValueFromAjaxList(selenium, ajxRFMethod,
//								prescribeData.refillMethodCa);
//
//						selectValueFromAjaxList(selenium, ajxRFQuatity,
//								prescribeData.refillQuantityCa);

						selectValueFromAjaxList(selenium, ajxRFUnit,
								prescribeData.refillUnitCa);
//						selectValueFromAjaxList(selenium, ajxRFRoute,
//								prescribeData.refillRouteCa);

//						selectValueFromAjaxList(selenium, ajxRFFrequency,
//								prescribeData.refillFrequencyCa);

//						selectValueFromAjaxList(selenium, ajxRFDuration,
//								prescribeData.refilldurationCa);
						type(selenium, ajxRFDoNot,
								prescribeData.refillDoNot);
					}
				}

				assertTrue(
						type(selenium, txtNotesToPharmacy,
								prescribeData.notesToPharmacy),
								"Could not enter dispense;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
				if (prescribeData.subPermitted.equals("Yes")) {
					assertTrue(click(selenium, chkSubPermitted),
							"Could not click the permitted check box;More Details:"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
				}
				if (prescribeData.comePackage.equals("Yes")) {
					assertTrue(click(selenium, chkComPackage),
							"Could not click the com Packing check box;More Details:"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
				}
				if (prescribeData.comePackage.equals("Yes")) {


					if (!isChecked(selenium, chkWeight))
						 assertTrue(click(selenium, chkWeight),
								"Could not click the com Packing check box;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
					 assertTrue(type(selenium, txtweight, prescribeData.weight),
	                            "Could not enter the Date;More Details:"
	                                          + prescribeData.toString(),selenium, ClassName, MethodName);
					 assertTrue(selectValueFromAjaxList(selenium, ajxWeighUnit, prescribeData.weightPreMed),
	                            "Could not enter the Date;More Details:"
	                                          + prescribeData.toString(),selenium, ClassName, MethodName);
					
				}
				if (prescribeData.comePackage.equals("Yes")) {


					if (!isChecked(selenium, chkExpires))
						assertTrue(click(selenium, chkExpires),
								"Could not click the com Packing check box;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
                    assertTrue(enterDate(selenium, txtDateExpires, date),
                            "Could not enter the Date;More Details:"
                                          + prescribeData.toString(),selenium, ClassName, MethodName);

					
				}
				if (prescribeData.saveList.equals("Yes")) {
					assertTrue(click(selenium, chkQuickList),
							"Could not click the save list;More Details"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
				}

				if (prescribeData.testCaseId.equals("TC_PM_002")
						|| prescribeData.testCaseId.equals("TC_PM_026")) {
					int count = 1;
					click(selenium, btnSearchDatabase);
					selectValueFromAjaxList(selenium, ajxSearch,
							prescribeData.pharmacyName);
					type(selenium, txtDistance,
							prescribeData.searchWithin);

					if (prescribeData.searchWithinKM.equals("Yes")) {
					 assertTrue(click(selenium, chkSearchwithin),
								"Could not click the KM radio button;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
					}
					if (prescribeData.searchWithinMiles.equals("Yes")) {
					 assertTrue(
								click(selenium, chkSearchWithinMiles),
								"Could not click the KM radio button;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
					}
					if (prescribeData.patient.equals("Yes")) {
					 assertTrue(click(selenium, chkPatient),
								"Could not click the patient button;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
					}
					if (prescribeData.practice.equals("Yes")) {
					 assertTrue(click(selenium, chkPractice),
								"Could not click the practice button;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
					}
					if (prescribeData.zipcodecheck.equals("Yes")) {
					 assertTrue(click(selenium, chkFromZip),
								"Could not click the Zip button;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
					 assertTrue(
								type(selenium, txtFromZip,
										prescribeData.zipcodeCa),
										"Could not type the Zip code;More Details"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
					}

					assertTrue(click(selenium, btnSearchPharmacy),
							"Could not click the search button;More Details:"
									+ prescribeData.toString(),selenium, ClassName, MethodName);

					while (isElementPresent(selenium,
							"//div[6]/div/div[2]/table/tbody/tr[" + count
							+ "]/td/div")) {
						if (getText(
								selenium,
								"//div[6]/div/div[2]/table/tbody/tr[" + count
								+ "]/td/div")
								.toLowerCase(new java.util.Locale("en", "Us"))
								.trim()
								.contains(
										prescribeData.pharmacyName.trim()
										.toLowerCase(
												new java.util.Locale(
														"en", "Us")))) {
							assertTrue(click(selenium, "//tr[" + count
									+ "]/td[2]/div/a"),"Could not click on the Xpath link",selenium, ClassName, MethodName);
							break;
						} else
							count++;
					}
				}

			} else {

				assertTrue(click(selenium, chkOneTimeOnly),
						"Could not click the one time only check box;More Details:"
								+ prescribeData.toString(),selenium, ClassName, MethodName);
				if (prescribeData.freeText.equals("Yes")) {
					if (!isChecked(selenium, chkFreeText))
						assertTrue(click(selenium, chkFreeText),
								"Could not click the Free text check box;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
					assertTrue(
							type(selenium, txtDirectionNotes,
									prescribeData.direction),
									"Could not enter the text;More Details:"
											+ prescribeData.toString(),selenium, ClassName, MethodName);
					assertTrue(
							type(selenium, txtDispense, prescribeData.dispense),
							"Could not enter dispense;More Details:"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);

					selectValueFromAjaxList(selenium, ajxUnitList,
							prescribeData.unitList);

				}
				if (prescribeData.increaseDecreaseDose.equals("Yes")) {
					if (!isChecked(selenium, chkIncreaseDecreaseDirection))
						assertTrue(
								click(selenium, chkIncreaseDecreaseDirection),
								"Could not click the Increase/Decrease Dose check box;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium, ajxInRefillMethod,
							prescribeData.refillMethod);

					selectValueFromAjaxList(selenium, ajxInRefillQuantity,
							prescribeData.refillQuantity);

					selectValueFromAjaxList(selenium, ajxInRefilUnit,
							prescribeData.refillUnit);

					selectValueFromAjaxList(selenium, ajxInRefillRoute,
							prescribeData.refillRoute);

					selectValueFromAjaxList(selenium, ajxInRefillFrequency,
							prescribeData.refillFrequency);
					selectValueFromAjaxList(selenium, ajxInRefillDuration,
							prescribeData.refillduration);
					selectValueFromAjaxList(selenium, ajxInRefillUsage,
							prescribeData.refillUsage);

					selectValueFromAjaxList(selenium, ajxInUsage,
							prescribeData.usage);

					assertTrue(
							type(selenium, txtDuration, prescribeData.duration),
							"Could not type the duration;More Details;"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium, ajxInRefillUsage1,
							prescribeData.refillUsage1);

					selectValueFromAjaxList(selenium, ajxInRefillUsage2,
							prescribeData.refillUsage2);

					selectValueFromAjaxList(selenium, ajaxInRefillUsage3,
							prescribeData.refillUsage3);

					waitForPageLoad(selenium);
				}
				if (prescribeData.multipleDirection.equals("Yes")) {
					if (!isChecked(selenium, chkMultipleDirection))
						assertTrue(
								click(selenium, chkMultipleDirection),
								"Could not click the multiple direction check box;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium, ajxMDRefilMethod,
							prescribeData.refillMethod);

					selectValueFromAjaxList(selenium, ajxMDRefillQuantity,
							prescribeData.refillQuantity);

					selectValueFromAjaxList(selenium, ajxMDRefillUnit,
							prescribeData.refillUnit);

					selectValueFromAjaxList(selenium, ajxMDRefillRoute,
							prescribeData.refillRoute);

					selectValueFromAjaxList(selenium, ajxMDRefillFrequency,
							prescribeData.refillFrequency);

					selectValueFromAjaxList(selenium, ajxMDRefillDuration,
							prescribeData.refillduration);

					selectValueFromAjaxList(selenium, ajxMDRefillUsage,
							prescribeData.refillUsage1);

					selectValueFromAjaxList(selenium, ajxMDMethod,
							prescribeData.method);
					selectValueFromAjaxList(selenium, ajxMDQuantity,
							prescribeData.quality);

					selectValueFromAjaxList(selenium, ajxMDUnit,
							prescribeData.unit);

					selectValueFromAjaxList(selenium, ajxMDRoute,
							prescribeData.route);
					selectValueFromAjaxList(selenium, ajxMDFrequency,
							prescribeData.frequency);

					selectValueFromAjaxList(selenium, ajxMDDuration,
							prescribeData.duration);

					selectValueFromAjaxList(selenium, ajxMDUsage,
							prescribeData.usage);
				} else if (!prescribeData.freeText.equals("Yes")
						&& !prescribeData.increaseDecreaseDose.equals("Yes")
						&& !prescribeData.multipleDirection.equals("Yes")) {
					// waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium, ajxMethod,
							prescribeData.refillMethod);
					selectValueFromAjaxList(selenium, ajxQuantity,
							prescribeData.quality);

					selectValueFromAjaxList(selenium, ajxUnit,
							prescribeData.unit);

					selectValueFromAjaxList(selenium, ajxRoute,
							prescribeData.route);

					selectValueFromAjaxList(selenium, ajxFrequency,
							prescribeData.frequency);

					selectValueFromAjaxList(selenium, ajxDuration,
							prescribeData.duration);

					selectValueFromAjaxList(selenium, ajxUsage,
							prescribeData.refillUsage4);

					assertTrue(
							type(selenium, txtDirectionNotes,
									prescribeData.direction),
									"Could not enter the text;More Details:"
											+ prescribeData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				if (prescribeData.testCaseId.equalsIgnoreCase("TC_PM_023")
						|| prescribeData.testCaseId
						.equalsIgnoreCase("TC_PM_029")
						|| prescribeData.testCaseId
						.equalsIgnoreCase("TC_PM_042")
						|| prescribeData.testCaseId
						.equalsIgnoreCase("TC_PM_043")
						|| prescribeData.testCaseId
						.equalsIgnoreCase("TC_PM_030")) {
					assertTrue(
							type(selenium, txtFreeFormText,
									prescribeData.prescribeName),
									"Could not enter the medication free text;More Details:"
											+ prescribeData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				if (prescribeData.testCaseId.equalsIgnoreCase("TC_PM_013")) {
					selenium.clickAt(txtDirectionNotes, "");
					System.out.println(getText(selenium, lblAddDirection));
					assertTrue(getText(selenium, lblAddDirection)
							.equalsIgnoreCase(prescribeData.addDirectionCount),
							"Additional directions count is not deducted properly",selenium, ClassName, MethodName);
				}
				assertTrue(
						type(selenium, txtDispense, prescribeData.dispense),
						"Could not enter dispense;More Details:"
								+ prescribeData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxUnitList,
						prescribeData.unitList);

				click(selenium, "//body/div[4]/div/div/div/div/div");

				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat1 = new SimpleDateFormat(
						"MM/dd/yyyy");
				date = DateFormat1.format(cal.getTime());
				assertTrue(enterDate(selenium, txtFillon, date),
						"Could not enter the Date;More Details:"
								+ prescribeData.toString(),selenium, ClassName, MethodName);

				if (!prescribeData.ofRefill.isEmpty()) {
					if (!prescribeData.testCaseId.equalsIgnoreCase("TC_PM_004")
							&& !prescribeData.testCaseId
							.equalsIgnoreCase("TC_PM_036")) {
						assertTrue(
								type(selenium, txtofRefills,
										prescribeData.ofRefill),
										"Could not enter the Refill;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
						assertTrue(
								type(selenium, txtDurationNo,
										prescribeData.ofRefill),
										"Could not enter the no of Refill;More Details:"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
						selectValueFromAjaxList(selenium, ajxRFDurationList,
								prescribeData.refillUsage1);
						selectValueFromAjaxList(selenium, ajxRFMethod,
								prescribeData.refillMethod);

						selectValueFromAjaxList(selenium, ajxRFQuatity,
								prescribeData.refillQuantity);

						selectValueFromAjaxList(selenium, ajxRFUnit,
								prescribeData.refillUnit);
						selectValueFromAjaxList(selenium, ajxRFRoute,
								prescribeData.refillRoute);

						selectValueFromAjaxList(selenium, ajxRFFrequency,
								prescribeData.refillFrequency);

						selectValueFromAjaxList(selenium, ajxRFDuration,
								prescribeData.refillduration);
						selectValueFromAjaxList(selenium, ajxRFUsage,
								prescribeData.usage);
					}
				}
				assertTrue(
						type(selenium, txtNotesToPharmacy,
								prescribeData.notesToPharmacy),
								"Could not enter dispense;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
				if (prescribeData.subPermitted.equals("Yes")) {
					assertTrue(click(selenium, chkSubPermitted),
							"Could not click the permitted check box;More Details:"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
				}
				if (prescribeData.comePackage.equals("Yes")) {
					assertTrue(click(selenium, chkComPackage),
							"Could not click the com Packing check box;More Details:"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
				}
				if (prescribeData.saveList.equals("Yes")) {
					assertTrue(click(selenium, chkQuickList),
							"Could not click the save list;More Details"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
				}
				if (prescribeData.weightPreMed.equals("Yes")) {


					if (!isChecked(selenium, chkWeight))
						assertTrue(click(selenium, chkWeight),
								"Could not click the com Packing check box;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
				}
				if (prescribeData.expires.equals("Yes")) {


					if (!isChecked(selenium, chkExpires))
						assertTrue(click(selenium, chkExpires),
								"Could not click the com Packing check box;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
				}


				if (prescribeData.testCaseId.equals("TC_PM_002")
						|| prescribeData.testCaseId.equals("TC_PM_026")) {
					int count = 1;
					click(selenium, btnSearchDatabase);
					selectValueFromAjaxList(selenium, ajxSearch,
							prescribeData.searchWithin);
					if (prescribeData.searchWithinKM.equals("Yes")) {
						assertTrue(click(selenium, chkSearchwithin),
								"Could not click the KM radio button;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
					}
					if (prescribeData.searchWithinMiles.equals("Yes")) {
						assertTrue(
								click(selenium, chkSearchWithinMiles),
								"Could not click the KM radio button;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
					}
					if (prescribeData.patient.equals("Yes")) {
						assertTrue(click(selenium, chkPatient),
								"Could not click the patient button;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
					}
					if (prescribeData.practice.equals("Yes")) {
						assertTrue(click(selenium, chkPatient),
								"Could not click the practice button;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
					}
					if (prescribeData.zipcodecheck.equals("Yes")) {
						assertTrue(click(selenium, chkFromZip),
								"Could not click the Zip button;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
						assertTrue(
								type(selenium, txtFromZip,
										prescribeData.zipcode),
										"Could not type the Zip code;More Details"
												+ prescribeData.toString(),selenium, ClassName, MethodName);
					}

					assertTrue(click(selenium, btnSearchPharmacy),
							"Could not click the search button;More Details:"
									+ prescribeData.toString(),selenium, ClassName, MethodName);

					while (isElementPresent(selenium,
							"//div[6]/div/div[2]/table/tbody/tr[" + count
							+ "]/td/div")) {
						if (getText(
								selenium,
								"//div[6]/div/div[2]/table/tbody/tr[" + count
								+ "]/td/div")
								.toLowerCase(new java.util.Locale("en", "Us"))
								.trim()
								.contains(
										prescribeData.pharmacyName.trim()
										.toLowerCase(
												new java.util.Locale(
														"en", "Us")))) {
							assertTrue(click(selenium, "//tr[" + count
									+ "]/td[2]/div/a"),"Could not click on the Xpath",selenium, ClassName, MethodName);
							break;
						} else
							count++;
					}
				}
			}
			assertTrue(click(selenium, btnContinueId),
					"Could not click the Continue button;More Details:"
							+ prescribeData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			if (isElementPresent(selenium, btnEdit)) {
				return true;
			} else {
				return false;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * prescribeMedicationUnitTestForMaxLength function to verify unit test for
	 * max length
	 * @throws IOException 
	 * 
	 * @since Sep 18, 2012
	 */
	public boolean prescribeMedicationUnitTestForMaxLength(Selenium selenium,
			ChartPreVisitLibUnitTest prescribeTestData) throws IOException {
		waitForPageLoad(selenium);
		boolean returnValue = true;
		try {
			if (!prescribeTestData.freeText.isEmpty()) {
				if (!prescribeTestData.freeText.contains("N/A"))
					if (!isChecked(selenium, chkFreeText))
						assertTrue(click(selenium, chkFreeText),
								"Could not click Ener As Free Text Check Box More Dateils"
										+ prescribeTestData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, txtDirectionNotes,
								prescribeTestData.freeText),
								"Could not type the afree text : More Details"
										+ prescribeTestData.toString(),selenium, ClassName, MethodName);
			} else {
				waitForPageLoad(selenium);
				if (isChecked(selenium, chkMultipleDirection))
					assertTrue(click(selenium, chkMultipleDirection),
							"Could not click multiple Direction Check Box More Dateils"
									+ prescribeTestData.toString(),selenium, ClassName, MethodName);
				if (isChecked(selenium, chkIncreaseDecreaseDirection))
					assertTrue(
							click(selenium, chkIncreaseDecreaseDirection),
							"Could not click Increase/Decrease Check Box More Dateils"
									+ prescribeTestData.toString(),selenium, ClassName, MethodName);
				if (isChecked(selenium, chkFreeText))
					assertTrue(click(selenium, chkFreeText),
							"Could not click free Text Check Box More Dateils"
									+ prescribeTestData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if (!prescribeTestData.adddirection.isEmpty())
				if (!prescribeTestData.adddirection.contains("N/A")) {
					waitForPageLoad(selenium);
					assertTrue(
							type(selenium, txtDirectionNotes,
									prescribeTestData.adddirection),
									"Could not type the additional directions : More Details"
											+ prescribeTestData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			if (!prescribeTestData.dispense.isEmpty())
				if (!prescribeTestData.dispense.contains("N/A")) {
					waitForPageLoad(selenium);
					assertTrue(
							type(selenium, txtDispense,
									prescribeTestData.dispense),
							"Could not type the dispense",selenium, ClassName, MethodName);
				}
			if (!prescribeTestData.refills.isEmpty())
				if (!prescribeTestData.refills.contains("0")) {
					waitForPageLoad(selenium);
					assertTrue(
							type(selenium, txtofRefills,
									prescribeTestData.refills),
							"Could not type refills",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			if (!prescribeTestData.notesToPharmacy.isEmpty())
				if (!prescribeTestData.notesToPharmacy.contains("N/A")) {
					waitForPageLoad(selenium);
					assertTrue(
							type(selenium, txtNotesToPharmacy,
									prescribeTestData.notesToPharmacy),
									"Could not type the notes to pharmacy : More Details"
											+ prescribeTestData.toString(),selenium, ClassName, MethodName);
				}
			assertTrue(click(selenium, chkSubPermitted),
					"could not click subpermitted check box",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		} catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"
					+ e.getMessage()
					+ "\n\t*); Detailed data:"
					+ prescribeTestData.toString());
		}
		return returnValue;
	}

	/**
	 * unitTestForTask function to create unit test for prescribe medication.
	 * @throws IOException 
	 * 
	 * @since Sep 21, 2012
	 */
	public boolean unitTestForTask(Selenium selenium,
			ChartPreVisitLibUnitTest taskTestData) throws IOException {
		boolean returnValue = false;
		try {

			if (!taskTestData.taskName.isEmpty())
				if (!taskTestData.taskName.contains("N/A"))
					assertTrue(
							type(selenium, "css=input.width370pxImportant",
									taskTestData.taskName),
									"Could not type the Task Name: More Details"
											+ taskTestData.toString(),selenium, ClassName, MethodName);
			if (!taskTestData.instructions.isEmpty())
				if (!taskTestData.instructions.contains("N/A"))
					assertTrue(
							type(selenium, "instructionsTextBoxId",
									taskTestData.instructions),
									"Could not type the instructions : More Details"
											+ taskTestData.toString(),selenium, ClassName, MethodName);
			if (!taskTestData.dueIn.isEmpty())
				if (!taskTestData.dueIn.contains("N/A"))
					selectValueFromAjaxList(selenium,
							"timeCountSuggestBoxsuggestBox", taskTestData.dueIn);
			if (!taskTestData.dueInUnit.isEmpty())
				if (!taskTestData.dueInUnit.contains("N/A"))
					selectValueFromAjaxList(selenium,
							"dueInTimeUnitSuggestBoxTime ",
							taskTestData.dueInUnit);
			if (taskTestData.urgentTask.contains("Yes"))
				assertTrue(click(selenium, "urgentTaskcheckbox"),
						"Could not click urgent task check box",selenium, ClassName, MethodName);
			if (!taskTestData.assignTask.isEmpty())
				if (!taskTestData.assignTask.contains("N/A"))
					selectValueFromAjaxList(selenium,
							"assignToSuggestBoxsuggestBox",
							taskTestData.assignTask);
			if (taskTestData.moreOptions.equals("Yes")) {
				if (taskTestData.asignToUserRole.contains("Yes"))
					assertTrue(click(selenium, "assignToFromcheckbox"),
							"Could not click Assign to a user/user role from another practice check box",selenium, ClassName, MethodName);
				if (taskTestData.recurring.contains("Yes"))
					assertTrue(click(selenium, "recurringcheckbox"),
							"Could not click recurring check box",selenium, ClassName, MethodName);
				if (!taskTestData.notifyMe.isEmpty())
					if (!taskTestData.notifyMe.contains("N/A"))
						selectValueFromAjaxList(
								selenium,
								"xpath=(//input[@id='timeCountSuggestBoxsuggestBox'])[2]",
								taskTestData.notifyMe);
				if (!taskTestData.notifyMeUnit.isEmpty())
					if (!taskTestData.notifyMeUnit.contains("N/A"))
						selectValueFromAjaxList(selenium,
								"notifyMeInTimeUnitSuggestBoxsuggestBox",
								taskTestData.notifyMeUnit);
				if (!taskTestData.notifyPatient.isEmpty())
					if (!taskTestData.notifyPatient.contains("N/A"))
						selectValueFromAjaxList(selenium,
								"notifyPatientInTimeCountSuggestBoxsuggestBox",
								taskTestData.notifyPatient);
				if (!taskTestData.notifyPatientUnit.isEmpty())
					if (!taskTestData.notifyPatientUnit.contains("N/A"))
						selectValueFromAjaxList(selenium,
								"notifyPatientInTimeUnitSuggestBoxsuggestBox",
								taskTestData.notifyPatientUnit);
				if (taskTestData.immediate.contains("Yes"))
					assertTrue(click(selenium, "immediatelycheckbox"),
							"Could not click Assign to a user/user role from another practice check box",selenium, ClassName, MethodName);

			}
			if (taskTestData.quickList.contains("Yes"))
				assertTrue(click(selenium, chkQuickList),
						"Could not click save to quick list check box",selenium, ClassName, MethodName);

			waitForPageLoad(selenium);
			assertTrue(click(selenium, "saveID"),
					"Could not click save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;
		} catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"
					+ e.getMessage()
					+ "\n\t*); Detailed data:"
					+ taskTestData.toString());
		}
		return returnValue;
	}

	/**
	 * createProviderWithMandatory function to create Provider With Mandatory * @since
	 * June 06, 2012
	 * @throws IOException 
	 */

	public boolean createProviderWithMandatory(Selenium selenium,
			ChartPreVisitLib providerData, String account) throws IOException {
		try {
			selectValueFromAjaxList(selenium, "providerTypesuggestBox",
					providerData.providerType);
			assertTrue(
					type(selenium, txtFirstName, providerData.firstName),
					"Could not enter the  name" + providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtlastName, providerData.lastName),
					"Could not type a last name" + providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, "maximumFTESuggestBoxsuggestBox",
					providerData.maximumFte);
			if (!account.equals(CAAccount)) {
				if (providerData.billingInfoCheck.equals("Yes")) {
					assertTrue(
							click(selenium, "signatureOnFilecheckbox"),
							"Could not click the signature file check box;More details:"
									+ providerData.toString(),selenium, ClassName, MethodName);
					assertTrue(
							enterDate(selenium, "signatureDate",
									providerData.signatureDate),
									"Could not enter date; More Details:"
											+ providerData.toString(),selenium, ClassName, MethodName);
				}
			}
			assertTrue(click(selenium, btnsaveProvider),
					"Could not click the save button;More Details:"
							+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,txtProviderSearchbox),"Search box not found",selenium, ClassName, MethodName);

		/*	if (isElementPresent(selenium,txtSearchProvider)) {
				return true;
			} else {
				return false;
			}*/
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * addPracticeToProvider function to add practice to provider
	 * 
	 * @param selenium
	 * @param providerData
	 * @throws IOException 
	 * @since Nov 14, 2012
	 */
	public boolean addPracticeToProvider(Selenium selenium,
			ChartPreVisitLib providerData) throws IOException {
		boolean returnValue = false;
		try {
			assertTrue(click(selenium, btnAdd),
					"Could not click add providers button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String Str = getText(selenium, "locationMenuHeader");
			String curPractice = Str.replaceAll("[.]", "");

			System.out.println(curPractice);
			assertTrue(type(selenium, "searchBox", curPractice),
					"Could not type practice name in search box",selenium, ClassName, MethodName);
			assertTrue(click(selenium, "search"),
					"Could not click the search button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if (!isChecked(selenium, "//span/input"))
				assertTrue(click(selenium, "//span/input"),
						"Could not click the search button",selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnSave),
					"Could not click the save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if (isElementPresent(selenium, btnAdd))
				returnValue = true;
			else
				Assert.fail("Could not add a practice for provider");
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}
	/**
	 * deleteProvider function to navigate to Add provider page
	 * 
	 * @param selenium
	 * @param providerData
	 * @throws IOException 
	 * 
	 * @since August 17, 2012
	 */
	public boolean deleteProvider(Selenium selenium,
			ChartPreVisitLib providerData) throws IOException {
		boolean returnValue = true;
		try {
			if (isElementPresent(selenium,
					txtProviderSearchbox))
				waitForPageLoad(selenium);
			assertTrue(
					type(selenium, txtProviderSearchbox,
							providerData.firstName),
							"Could not type the first name; More Details"
									+ providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(
					click(selenium, btnProviderSearch),
					"Could not click the search button"
							+ providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			int Counter = 1;
			while (isElementPresent(selenium,
					"xpath=(//div[contains(@id,'providerListItem')])[" + Counter
					+ "]")) {
				System.out.println(getText(selenium,
						"xpath=(//div[contains(@id,'providerListItem')])[" + Counter
						+ "]"));
				System.out.println(providerData.firstName);
				if (getText(
						selenium,
						"xpath=(//div[contains(@id,'providerListItem')])[" + Counter
						+ "]")
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								providerData.firstName.trim().toLowerCase(
										new java.util.Locale("en", "US")))) {
					assertTrue(
							click(selenium,
									"xpath=(//*[contains(@id,'DeleteProvider')])[" + Counter
									+ "]"),
											"Could not click the delete button"
													+ providerData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					click(selenium, btnYes);
					waitForPageLoad(selenium);
				} else
					Counter++;
				if (Counter > 15)
					break;
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}

	/**
	 * addToPending function to add To Pending
	 * @throws IOException 
	 * 
	 * @since Sep 24, 2012
	 */

	public boolean addToPending(Selenium selenium, ChartPreVisitLib pendingData) throws IOException {
		try {
			assertTrue(click(selenium, chkOneTimeOnly),
					"Could not click the one time only check box;More Details:"
							+ pendingData.toString(),selenium, ClassName, MethodName);
			if (pendingData.freeText.equals("Yes")) {
				assertTrue(click(selenium, chkFreeText),
						"Could not click the Free text check box;More Details:"
								+ pendingData.toString(),selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtDirectionNotes, pendingData.direction),
						"Could not enter the text;More Details:"
								+ pendingData.toString(),selenium, ClassName, MethodName);
			}
			if (pendingData.increaseDecreaseDose.equals("Yes")) {
				assertTrue(
						click(selenium, chkIncreaseDecreaseDirection),
						"Could not click the Increase/Decrease Dose check box;More Details:"
								+ pendingData.toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, "cmbInRefillMethod",
						pendingData.refillMethod);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxInRefillQuantity,
						pendingData.refillQuantity);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxInRefilUnit,
						pendingData.refillUnit);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxInRefilUnit,
						pendingData.refillRoute);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxInRefillFrequency,
						pendingData.refillFrequency);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxRefilUsage,
						pendingData.refillUsage);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxInRefillUsage,
						pendingData.usage);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				assertTrue(
						type(selenium, txtDuration, pendingData.duration),
						"Could not type the duration;More Details;"
								+ pendingData.toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxInRefillUsage1,
						pendingData.refillUsage1);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxInRefillUsage2,
						pendingData.refillUsage2);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajaxInRefillUsage3,
						pendingData.refillUsage3);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				waitForPageLoad(selenium);
			}
			if (pendingData.multipleDirection.equals("Yes")) {
				assertTrue(click(selenium, chkMultipleDirection),
						"Could not click the multiple direction check box;More Details:"
								+ pendingData.toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxMDRefilMethod,
						pendingData.refillMethod);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxMDRefillQuantity,
						pendingData.refillQuantity);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxMDRefillUnit,
						pendingData.refillUnit);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxMDRefillRoute,
						pendingData.refillRoute);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxMDRefillFrequency,
						pendingData.refillFrequency);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxMDRefillDuration,
						pendingData.refillduration);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxMDRefillUsage,
						pendingData.refillUsage1);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxMDMethod,
						pendingData.method);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxMDQuantity,
						pendingData.quality);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxMDUnit, pendingData.unit);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxMDRoute, pendingData.route);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxMDFrequency,
						pendingData.frequency);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxMDDuration,
						pendingData.duration);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxMDUsage, pendingData.usage);
				click(selenium, "//body/div[4]/div/div/div/div/div");
			} else if (!pendingData.freeText.equals("Yes")
					&& !pendingData.increaseDecreaseDose.equals("Yes")
					&& !pendingData.multipleDirection.equals("Yes")) {
				selectValueFromAjaxList(selenium, ajxQuantity,
						pendingData.quality);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxUnit, pendingData.unit);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxRoute, pendingData.route);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxFrequency,
						pendingData.frequency);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxDuration,
						pendingData.duration);
				click(selenium, "//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium, ajxRefillUsage,
						pendingData.usage);
				click(selenium, "//body/div[4]/div/div/div/div/div");
			}
			assertTrue(
					type(selenium, txtDirectionNotes, pendingData.direction),
					"Could not enter the text;More Details:"
							+ pendingData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtDispense, pendingData.dispense),
					"Could not enter dispense;More Details:"
							+ pendingData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					enterDate(selenium, txtFillon, pendingData.fillon),
					"Could not enter the Date;More Details:"
							+ pendingData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtofRefills, pendingData.ofRefill),
					"Could not enter the ofRefill;More Details:"
							+ pendingData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtNotesToPharmacy,
							pendingData.notesToPharmacy),
							"Could not enter dispense;More Details:"
									+ pendingData.toString(),selenium, ClassName, MethodName);
			if (pendingData.subPermitted.equals("Yes")) {
				assertTrue(click(selenium, chkSubPermitted),
						"Could not click the permitted check box;More Details:"
								+ pendingData.toString(),selenium, ClassName, MethodName);
			}
			if (pendingData.comePackage.equals("Yes")) {
				assertTrue(click(selenium, chkComPackage),
						"Could not click the com Packing check box;More Details:"
								+ pendingData.toString(),selenium, ClassName, MethodName);
			}
			if (pendingData.saveList.equals("Yes")) {
				assertTrue(click(selenium, chkQuickList),
						"Could not click the save list;More Details"
								+ pendingData.toString(),selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium, "problemSuggestBoxsuggestBox",
					pendingData.problemSuggest);
			click(selenium, "//body/div[4]/div/div/div/div/div");
			assertTrue(
					type(selenium, "internalNotesTextBoxId",
							pendingData.internalNote),
							"Could not enter the text;More Details:"
									+ pendingData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, "saveButtonId"),
					"Could not click the save button; More Details:"
							+ pendingData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * createInjection function to create Injection
	 * 
	 * @throws IOException
	 * 
	 * @since Sep 26, 2012
	 */
	public boolean createInjection(Selenium selenium,
			ChartPreVisitLib injectionData, String account, String providerName)
					throws IOException {
		String date = null;
		try {

			if (injectionData.testCaseId.equalsIgnoreCase("TC_CI_009")) {
				// assertTrue(click(selenium,"css=button.quickListButton"),"Could not click the QuickList button;More details:"+injectionData.toString(),selenium, ClassName, MethodName);

				if (!isChecked(selenium,
						"saveListcheckbox")) {
					assertTrue(
							click(selenium,
									"saveListcheckbox"),
									"Could not click the Save Quick List check box;More Details:"
											+ injectionData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			}

			selectValueFromAjaxList(selenium, txtQuickinjection,
					injectionData.injection);
			
			assertTrue(
					type(selenium, txtLotNo, injectionData.lotNumber),
					"Could not type the Lot Number;More Details:"
							+ injectionData.toString(),selenium, ClassName, MethodName);
			if (account.equals(CAAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				date = DateFormat.format(cal.getTime());
				assertTrue(enterDate(selenium, txtexpiryDate, date),
						"Could not enter the expiry Date;More Details:"
								+ injectionData.toString(),selenium, ClassName, MethodName);
			} else {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal.getTime());
				assertTrue(enterDate(selenium, txtexpiryDate, date),
						"Could not enter the expiry Date;More Details:"
								+ injectionData.toString(),selenium, ClassName, MethodName);
			}
			assertTrue(
					type(selenium, txtDosage, injectionData.dosage),
					"Could not enter the Dosage;More Details:"
							+ injectionData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxDosageUnit,
					injectionData.dosageUnit);
			waitForPageLoad(selenium);
		
			if (!(injectionData.testCaseId.equals("TC_CI_004")
					|| injectionData.testCaseId.equals("TC_CI_015")
					|| injectionData.testCaseId.equals("TC_CI_026") || injectionData.testCaseId
					.equals("TC_CI_056"))) {

				// Click if it not a EditInjection Function

				/*				if (!(injectionData.testCaseId.equals("TC_CI_002"))) {				

					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					assertTrue(click(selenium, lnkInjectionShowMoreArrow),
					"Could not click on Injection Show More Arrow",
					selenium, ClassName, MethodName);					

				}	*/


				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkInjectionShowMoreArrow),
						"Could not click on Injection Show More Arrow",
						selenium, ClassName, MethodName);

				/*
				 * if(getText(selenium,lnkInjectionShowMore).contains(
				 * "Show more details")){ waitForPageLoad(selenium);
				 * waitForPageLoad(selenium); assertTrue(click(selenium,
				 * lnkInjectionShowMore),
				 * "Could not click the show link;More Details:" +
				 * injectionData.toString(),selenium, ClassName, MethodName); waitForPageLoad(selenium); }
				 */
				waitForPageLoad(selenium);
				if (account.equals(CAAccount)) {
					assertTrue(enterDate(selenium, txtadminOn, date),
							"Could not enter the expiry Date;More Details:"
									+ injectionData.toString(),selenium, ClassName, MethodName);
				} else {
					assertTrue(enterDate(selenium, txtadminOn, date),
							"Could not enter the expiry Date;More Details:"
									+ injectionData.toString(),selenium, ClassName, MethodName);
				}
				if (injectionData.consentCheck.equalsIgnoreCase("yes")) {
					assertTrue(click(selenium, chkInjectionConsentBox),
							"Could not click the consent check box",selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium, ajxConsentSuggest,
							injectionData.consent);
					waitForPageLoad(selenium);
				}

				selectValueFromAjaxList(selenium, site, injectionData.site);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxInjectionRoute,
						injectionData.route);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxAdminBy, providerName);
				click(selenium,"//body/div[5]/div/div/div/div/div");
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxCptCode1,
						injectionData.cptCode1);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxCptCode2,
						injectionData.cptCode2);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxReaction,
						injectionData.reaction);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, txtComment, injectionData.comment),
						"Could not enter the comment;More Details:"
								+ injectionData.toString(),selenium, ClassName, MethodName);

			}

			if (injectionData.testCaseId.equals("TC_CI_056")) {
				assertTrue(click(selenium, lnkInjectionShowMore),
						"Could not click the show link;More Details:"
								+ injectionData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, txtComment, injectionData.comment),
						"Could not enter the comment;More Details:"
								+ injectionData.toString(),selenium, ClassName, MethodName);
			}

			if (injectionData.testCaseId.equals("TC_CI_010")) {
				assertTrue(click(selenium, btnSave),
						"Could not click on save button;More Details:"
								+ injectionData.toString(),selenium, ClassName, MethodName);
				return true;
			}

			if (injectionData.testCaseId.equals("TC_CI_002")) {
				assertTrue(click(selenium, btnInjEditSave),
						"Could not click on save button;More Details:"
								+ injectionData.toString(),selenium, ClassName, MethodName);
				return true;
			}

			if (injectionData.testCaseId.equals("TC_CI_005")) {
				assertTrue(click(selenium, btnCancelInjection),
						"Could not click on cancel button;More Details:"
								+ injectionData.toString(),selenium, ClassName, MethodName);
			} else
				assertTrue(click(selenium, btnAdd),
						"Could not click the Add buton;More Details:"
								+ injectionData.toString(),selenium, ClassName, MethodName);

			waitForPageLoad(selenium);

			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}



	/**
	 * verifyCollapseViewForInjection function to verifyCollapseViewForInjection
	 * 
	 * @throws IOException
	 * 
	 * @since Sep 26, 2012
	 */
	public boolean verifyCollapseViewForInjection(Selenium selenium,
			ChartPreVisitLib injectionData, String account) throws IOException {
		waitForPageLoad(selenium);
		String date = null;
		if (account.equals(CAAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MMM dd, yyyy");
			date = DateFormat.format(cal.getTime());
		} else {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat.format(cal.getTime());

		}

		assertTrue(selenium.isTextPresent(date), ""
				+ "Injection Date Not Present", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(injectionData.injection.toUpperCase()), ""
				+ "Injection Not Present", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(injectionData.reaction), ""
				+ "Injection Reaction Not Present", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		return true;
	}
	/**
	 * verifyExpandViewForInjection function to verifyExpandViewForInjection
	 * 
	 * @throws IOException
	 * 
	 * @since Sep 26, 2012
	 */
	public boolean verifyExpandViewForInjection(Selenium selenium,
			ChartPreVisitLib injectionData, String providerName, String date,
			String time) throws IOException {
		waitForPageLoad(selenium);
		int i=1;
		String arrowClick="xpath=(//div[contains(@id,'menuArrow')])[";
		while(isElementPresent(selenium,arrowClick+i+"]"))
		{
			click(selenium,arrowClick+i+"]");
			i++;
		}
		
		assertTrue(selenium.isTextPresent(injectionData.injection.toUpperCase()), ""
				+ "Injection Not Present", selenium, ClassName, MethodName);

		assertTrue(selenium.isTextPresent(injectionData.reaction), ""
				+ "Injection Reaction Not Present", selenium, ClassName,
				MethodName);

		assertTrue(selenium.isTextPresent(injectionData.comment), ""
				+ "Injection Comment Not Present", selenium, ClassName,
				MethodName);

		assertTrue(selenium.isTextPresent(injectionData.dosage), ""
				+ "Injection Dosage Not Present", selenium, ClassName,
				MethodName);

		assertTrue(selenium.isTextPresent(injectionData.dosageUnit), ""
				+ "Injection Dosage Unit Not Present", selenium, ClassName,
				MethodName);

		assertTrue(selenium.isTextPresent(providerName), ""
				+ "provider Name Not Present", selenium, ClassName, MethodName);

		assertTrue(selenium.isTextPresent(injectionData.route), ""
				+ "Injection Route Name Not Present", selenium, ClassName,
				MethodName);

		//assertTrue(selenium.isTextPresent(injectionData.site), ""
				//+ "Injection Site Not Present", selenium, ClassName, MethodName);

		assertTrue(selenium.isTextPresent(injectionData.lotNumber), ""
				+ "Injection Lot Number Not Present", selenium, ClassName,
				MethodName);

		assertTrue(selenium.isTextPresent(date), ""
				+ "Injection Date Not Present", selenium, ClassName, MethodName);

		//assertTrue(selenium.isTextPresent(injectionData.verifyCpt1), ""
				//+ "injectionData Cpt1 Not Present", selenium, ClassName,
				//MethodName);

		//assertTrue(selenium.isTextPresent(injectionData.verifyCpt2), ""
				//+ "injectionData Cpt2 Not Present", selenium, ClassName,
				//MethodName);

		// assertTrue(verifyTimeStampForProviderPage(selenium,
		// lblExpandInjection, date, time));
		// waitForPageLoad(selenium);
		return true;
	}

	/**
     * editInjection function to create Injection
     * @throws IOException 
      * 
      * @since Sep 26, 2012
     */
     public boolean editInjection(Selenium selenium,
                   ChartPreVisitLib injectionData, String account, String providerName) throws IOException {
            String date = null;
            try {

                   waitForPageLoad(selenium);
                   selectValueFromAjaxList(selenium, txtQuickinjection,
                                injectionData.injection);
                   waitForPageLoad(selenium);


                   assertTrue(type(selenium, txtLotNo, injectionData.lotNumber), ""+ "Could not type the Lot Number;More Details:", selenium, ClassName,MethodName);
                   waitForPageLoad(selenium);


                   // Assert.assertTrue(enterDate(selenium,expiryDate,injectionData.expiryData),"Could not enter the expiry Date;More Details:"+injectionData.toString());
                   if (account.equals(CAAccount)) {
                         Calendar cal = Calendar.getInstance();
                         SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
                         date = DateFormat.format(cal.getTime());
                         assertTrue(enterDate(selenium, txtexpiryDate, date),
                                       "Could not enter the expiry Date;More Details:"
                                                     + injectionData.toString(),selenium,ClassName,MethodName);
                   } else {
                         Calendar cal = Calendar.getInstance();
                         SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
                         date = DateFormat.format(cal.getTime());
                         assertTrue(enterDate(selenium, txtexpiryDate, date),
                                       "Could not enter the expiry Date;More Details:"
                                                     + injectionData.toString(),selenium,ClassName,MethodName);
                   }

                assertTrue(
                                type(selenium, txtDosage, injectionData.dosage),
                                "Could not enter the Dosage;More Details:"
                                              + injectionData.toString(), selenium, ClassName,
                              				MethodName);
                   selectValueFromAjaxList(selenium, ajxDosageUnit,
                                injectionData.dosageUnit);
                   waitForPageLoad(selenium);
                   
                   // Show more link 
                   assertTrue(click(selenium, lnkInjectionShowMoreArrow),
   						"Could not click on Injection Show More Arrow",
   						selenium, ClassName, MethodName);

                   
                   if (account.equals(CAAccount)) {
                     assertTrue(enterDate(selenium, txtadminOn, date),
                                       "Could not enter the expiry Date;More Details:"
                                                     + injectionData.toString(), selenium, ClassName,
                                     				MethodName);
                   } else {
                        assertTrue(enterDate(selenium, txtadminOn, date),
                                       "Could not enter the expiry Date;More Details:"
                                                     + injectionData.toString(), selenium, ClassName,
                                     				MethodName);
                   }
                   if (getText(selenium, lnkAllShowmore).equalsIgnoreCase(
                                "Show more details")) {
                      assertTrue(click(selenium, lnkAllergyShowmore),
                                       "Could not on show more button", selenium, ClassName,
                       				MethodName);
                   }

                   // Assert.assertTrue(enterDate(selenium,adminOn,injectionData.adminOn),"Could not enter the Administrator Date;More Details:"+injectionData.toString());
                   if (injectionData.consentCheck.equals("Yes")) {
                        assertTrue(click(selenium, chkInjectionConsentBox),
                                       "Could not click the consent check box", selenium, ClassName,
                       				MethodName);
                         selectValueFromAjaxList(selenium, ajxConsentSuggest,
                                       injectionData.consent);
                   }
                   selectValueFromAjaxList(selenium, site, injectionData.site);
                   waitForPageLoad(selenium);
                   selectValueFromAjaxList(selenium, ajxInjectionRoute,
                                injectionData.route);
                   waitForPageLoad(selenium);
                   selectValueFromAjaxList(selenium, ajxAdminBy, providerName);
                   waitForPageLoad(selenium);
                   selectValueFromAjaxList(selenium, ajxCptCode1,
                                injectionData.cptCode1);
                   waitForPageLoad(selenium);
                   selectValueFromAjaxList(selenium, ajxCptCode2,
                                injectionData.cptCode2);
                   waitForPageLoad(selenium);
                   selectValueFromAjaxList(selenium, ajxReaction,
                                injectionData.reaction);
                   waitForPageLoad(selenium);
                  assertTrue(
                                type(selenium, txtComment, injectionData.comment),
                                "Could not enter the comment;More Details:"
                                              + injectionData.toString(), selenium, ClassName,
                              				MethodName);
                   waitForPageLoad(selenium);
                   // Click on save
                  
                         assertTrue(click(selenium, btnInjectionEditsave),
                                       "Could not click the save list check box;More Details:"
                                                     + injectionData.toString(), selenium, ClassName,
                                     				MethodName);
                  
                   
                   waitForPageLoad(selenium);
                   return true;
            } catch (RuntimeException e) {
                   e.printStackTrace();
            }
            return false;
     }


	/**
	 * deleteInjection function to create Injection
	 * @throws IOException 
	 * 
	 * @since Sep 26, 2012
	 */
	public boolean deleteInjection(Selenium selenium) throws IOException {
		boolean injectionDeleted = true;
		int injCount = 0;
		try {
			int injCount1 = (Integer) selenium
					.getXpathCount("//div[@id='InjectionList']/table/tbody/tr/td[4]/div/a");
			System.out.println(injCount1);
			if (injCount1 >= 1) {
				// assertTrue(click(selenium, lnkInjection),
				// "Could not click Injections link;More Details:");
				waitForPageLoad(selenium);
				assertTrue(click(selenium, chkshowAllRecords),
						"Could not click on show all recorded items",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}

			while ((Integer) selenium
					.getXpathCount("//div[@id='InjectionList']/table/tbody/tr/td[4]/div/a") > 0) {
				injCount = (Integer) selenium
						.getXpathCount("//div[@id='InjectionList']/table/tbody/tr/td[4]/div/a");
				assertTrue(click(selenium,
						"//div[@id='InjectionList']/table/tbody/tr/td[4]/div/a"),"Could not click the xpath link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtdeleteReason, "reason"),
						"Could not type reason for deletion",selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnDeleteReason),
						"Could not click Delete button;More Details:",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (injCount == (Integer) selenium
						.getXpathCount("//div[@id='InjectionList']/table/tbody/tr/td[4]/div/a")) {
					injectionDeleted = false;
					break;
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return injectionDeleted;
	}

	/**
	 * deleteAllEncounterInjection function to delete all existing Encounter
	 * Allergy
	 * @throws IOException 
	 * 
	 * @since Oct 29, 2012
	 */
	public boolean deleteAllEncounterInjection(Selenium selenium,
			ChartPreVisitLib injectionData) throws IOException {
		boolean allergyDeleted = true;
		int historyCount = 0;
		try {
			waitForElement(selenium, lblPlanRecomSection, WAIT_TIME);
			while ((Integer) selenium.getXpathCount(lblPlanRecomSection) > 0) {
				historyCount = (Integer) selenium
						.getXpathCount(lblPlanRecomSection);
				assertTrue(click(selenium, lblPlanRecomSection),"Could not Click the link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						click(selenium,
								"//a[@id='delete']/span"),
								"Could not click the delete button;More Details:"
										+ injectionData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnYes),
						"Could not click Delete button;More Details:"
								+ injectionData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (historyCount == (Integer) selenium
						.getXpathCount(lblEncouterSumDetails)) {
					allergyDeleted = false;
					break;
				}
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return allergyDeleted;
	}


	/**
	 * unitTestForInjection function to verify unitTest For Injection
	 * @throws IOException 
	 * 
	 * @since Oct 01, 2012
	 */
	public boolean unitTestForInjection(Selenium selenium,
			ChartPreVisitLibUnitTest injectionData) throws IOException {
		try {
			assertTrue(click(selenium, lnkInjection),
					"Could not click Injections link;More Details:"
							+ injectionData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteInjection(selenium), "Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			selectValueFromAjaxList(selenium, txtQuickinjection,
					injectionData.injection);
			waitForPageLoad(selenium);
			assertTrue(
					type(selenium, txtLotNo, injectionData.lotNumber),
					"Could not type the Lot Number;More Details:"
							+ injectionData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					enterDate(selenium, txtexpiryDate, injectionData.expiryData),
					"Could not enter the expiry Date;More Details:"
							+ injectionData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtDosage, injectionData.dosage),
					"Could not enter the Dosage;More Details:"
							+ injectionData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxDosageUnit,
					injectionData.dosageUnit);
			assertTrue(
					enterDate(selenium, txtadminOn, injectionData.adminOn),
					"Could not enter the Administrator Date;More Details:"
							+ injectionData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkInjectionShowMore),
					"Could not click the show link;More Details:"
							+ injectionData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if (injectionData.consentCheck.equals("Yes")) {
				assertTrue(click(selenium, chkInjectionConsentBox),
						"Could not click the consent check box",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxConsentSuggest,
						injectionData.consent);
			}
			selectValueFromAjaxList(selenium, site, injectionData.site);
			selectValueFromAjaxList(selenium, ajxInjectionRoute,
					injectionData.route);
			selectValueFromAjaxList(selenium, ajxAdminBy, injectionData.adminBy);
			selectValueFromAjaxList(selenium, ajxCptCode1,
					injectionData.cptCode1);
			selectValueFromAjaxList(selenium, ajxCptCode2,
					injectionData.cptCode2);
			selectValueFromAjaxList(selenium, ajxReaction,
					injectionData.reaction);
			assertTrue(
					type(selenium, txtcomment, injectionData.comment),
					"Could not enter the comment;More Details:"
							+ injectionData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnAdd),
					"Could not click the Add buton;More Details:"
							+ injectionData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * unitTestForProcedure function to unitTest For Procedure
	 * @throws IOException 
	 * 
	 * @since Oct 03, 2012
	 */
	public boolean unitTestForProcedure(Selenium selenium,
			ChartPreVisitLibUnitTest proData, String account) throws IOException {
		try {
			assertTrue(
					type(selenium, txtProcedureName, proData.proName),
					"Could not on show more button",selenium, ClassName, MethodName);
			if (account.equals(CAAccount)) {
				assertTrue(
						enterDate(selenium, txtProcedureDate, proData.proDateCa),
						"Could not enter the Admin on ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			} else
				assertTrue(
						enterDate(selenium, txtProcedureDate, proData.proDate),
						"Could not enter the Admin on ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);

			// sert.assertTrue(enterDate(selenium,procedureDate,proData.proDate),"Could not enter the Admin on ;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkProcedureShowMore),
					"Could not on show more button",selenium, ClassName, MethodName);
			if (account.equals(CAAccount)) {
				assertTrue(
						enterDate(selenium, txtOnset, proData.onsetDateCa),
						"Could not enter the Admin on ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			} else
				assertTrue(
						enterDate(selenium, txtOnset, proData.onsetDate),
						"Could not enter the Admin on ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, txtcpt, proData.cpt);
			assertTrue(
					type(selenium, txtcomment, proData.comment),
					"Could not enter the comment;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, chkConsentBox),
					"Could not check the consent check box",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, consent_procedure,
					proData.consent);
			assertTrue(
					click(selenium, btnAdd),
					"Could not click the add button;More details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return true;
	}


	/**
	 * createImmunization function to create Immunization
	 * @throws IOException 
	 * 
	 * @since Sep 26, 2012
	 */


	public boolean createImmunization(Selenium selenium,
			ChartPreVisitLib immunizationData, String account) throws IOException {
		String providerNameTemp = getText(selenium, lnkTopMenu);
		String providerName = providerNameTemp.replaceAll(", FULL", "");
		immunizationData.adminBy = providerName;
		String date = null;
		
		if (account.equals(CAAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = DateFormat.format(cal.getTime());

		} else {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat.format(cal.getTime());

		}
		try {
			if(isElementPresent(selenium, btnErrorClose))
	            assertTrue(click(selenium, btnErrorClose),"Could not click on Close Button",selenium, ClassName, MethodName);

			if (immunizationData.refused.equals("yes")) {

				if (!isChecked(selenium, chkrefused))
				assertTrue(click(selenium, chkrefused),
							"Could not click refused check box;More Details:"
									+ immunizationData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (account.equals(CAAccount)) {
					assertTrue(selectValueFromAjaxList(selenium, ajxcanSuggestbox,
							immunizationData.immunizationCA),
							"Could not select"
									+ immunizationData.toString(), selenium, ClassName, MethodName);
				}
				else
				{
					assertTrue(selectValueFromAjaxList(selenium, txtRefusedImmunization,
							immunizationData.immunization),
							"Could not select"
									+ immunizationData.toString(), selenium, ClassName, MethodName);
				}
				
				assertTrue(enterDate(selenium, txtRefusedOndate, date),
						"Could not enter the resued Date;More Details:"
								+ immunizationData.toString(), selenium, ClassName, MethodName);

				assertTrue(
						type(selenium, txtRefusedComment,
								immunizationData.comment),
								"Could not enter the comment;More Details:"
										+ immunizationData.toString(), selenium, ClassName, MethodName);
			}
			if (immunizationData.admin.equals("yes")) {

				if (!isChecked(selenium, chkadmin))					
					assertTrue(click(selenium, chkadmin), "" + "Could not click the admin check box;More Details:", selenium, ClassName,MethodName);	
				waitForPageLoad(selenium);
		

				if (account.equals(CAAccount)) {
					assertTrue(selectValueFromAjaxList(selenium, ajxcanSuggestbox1,
							immunizationData.immunizationCA),
							"Could not select"
									+ immunizationData.toString(), selenium, ClassName, MethodName);
				}
				else
				{
					assertTrue(selectValueFromAjaxList(selenium, ajxImmunization,immunizationData.vaccineUS),"Could not click refused check box;More Details:"+ immunizationData.toString(), selenium, ClassName, MethodName);
				}
								
			assertTrue(enterDate(selenium, txtadminOnDate, date),
						"Could not enter the Admin on ;More Details:"
								+ immunizationData.toString(), selenium, ClassName, MethodName);
		assertTrue(
						type(selenium, txtcomment, immunizationData.comment),
						"Could not enter the comment;More Details:"
								+ immunizationData.toString(), selenium, ClassName, MethodName);
			} else if (!immunizationData.refused.equals("yes")
					&& !immunizationData.admin.equals("yes")) {
				if (isChecked(selenium, chkrefused))
				assertTrue(click(selenium, chkrefused),
							"Could not click refused check box;More Details:"
									+ immunizationData.toString(), selenium, ClassName, MethodName);

				if (isChecked(selenium, chkadmin))
				assertTrue(click(selenium, chkadmin),
							"Could not click the admin check box;More Details:"
									+ immunizationData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxVaccine,
							immunizationData.Vaccine1CA);
				}
				else
				{
					selectValueFromAjaxList(selenium, ajxVaccine,
							immunizationData.vaccineUS);
				}
			
				
				
			assertTrue(
						type(selenium, txtLotNo, immunizationData.lotNumber),
						"Could not enter the lot number", selenium, ClassName, MethodName);
		assertTrue(
						type(selenium, txtImmDosage, immunizationData.dosage),
						"Could not enter the dosage value;More Details:"
								+ immunizationData.toString(), selenium, ClassName, MethodName);

//				selectValueFromAjaxList(selenium, ajxImmdosage,
//						immunizationData.dosageUnit);

				assertTrue(enterDate(selenium, txtexpiryDate, date),
						"Could not enter the expiry date;More Details:"
								+ immunizationData.toString(), selenium, ClassName, MethodName);

			assertTrue(enterDate(selenium, txtadminDate, date),
						"Could not enter the Admin on date;More Details:"
								+ immunizationData.toString(), selenium, ClassName, MethodName);
				/*if (!(immunizationData.testCaseId.equals("TC_CIM_004") || immunizationData.testCaseId.equals("TC_CIM_008") || immunizationData.testCaseId.equals("TC_CIM_035")||immunizationData.testCaseId.equals("TC_CIM_043")||immunizationData.testCaseId.equals("TC_CIM_044")))
				{

				System.out.println(immunizationData.testCaseId);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkImmShowMoreArrow), ""	+ "Could not on show more Arrow", selenium, ClassName,MethodName);
				}	*/
if(!isElementVisible(selenium,ajxSeries1))
{
	click(selenium, lnkImmShowMoreArrow);
}
				selectValueFromAjaxList(selenium, ajxSeries1,
						immunizationData.series);

				selectValueFromAjaxList(selenium, ajxSeries2,
						immunizationData.seriesof);

				selectValueFromAjaxList(selenium, ajxSite,
						immunizationData.site);

				selectValueFromAjaxList(selenium, ajxImmRoute,
						immunizationData.route);

				if (immunizationData.consentCheck.equals("yes")) {
					assertTrue(click(selenium, chkConsentBox),
							"Could not click the check box",selenium,ClassName,MethodName);
					selectValueFromAjaxList(selenium, ajxConsentSuggest,
							immunizationData.consent);
				}
				selectValueFromAjaxList(selenium, ajxadminsteredBy,
						immunizationData.adminBy);

				selectValueFromAjaxList(selenium, ajxImmCpt1,
						immunizationData.cptCode1);

				selectValueFromAjaxList(selenium, ajxImmCp2,
						immunizationData.cptCode2);

				selectValueFromAjaxList(selenium, ajxImmreaction,
						immunizationData.reaction);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);

				//click(selenium, "//body/div[5]/div/div/div/div/div");
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtImmComment, immunizationData.comment), ""	+ "Could not type the comments;More Details", selenium, ClassName,MethodName);
				/*Assert.assertTrue(
						type(selenium, txtImmComment, immunizationData.comment),
						"Could not type the comments;More Details:"
								+ immunizationData.toString());*/
				if (immunizationData.saveList.equals("yes")) {
				assertTrue(click(selenium, chkQuickList),
							"Could not click the save list check box;More Details:"
									+ immunizationData.toString(), selenium, ClassName, MethodName);
				}

			}
			if (immunizationData.testCaseId.equalsIgnoreCase("TC_CIM_004")) {

				assertTrue(click(selenium,btnImmEditSave),
						"Could not click the save button;More Details:"
								+ immunizationData.toString(), selenium, ClassName, MethodName);
				return true;
			}

			/*
			 * if (immunizationData.testCaseId.equalsIgnoreCase("TC_CIM_008")) {
			 * Assert.assertTrue(click(selenium, btnSave),
			 * "Could not click the save button;More Details:" +
			 * immunizationData.toString()); return true; }
			 */
			if (immunizationData.testCaseId.equalsIgnoreCase("TC_CIM_029")) {
			assertTrue(click(selenium, btnSaveImmunization),
						"Could not click the save button;More Details:"
								+ immunizationData.toString(), selenium, ClassName, MethodName);
				return true;
			}
			 
				if (immunizationData.testCaseId.equalsIgnoreCase("TC_CIM_008")) {
				assertTrue(click(selenium, btnImmEditSave),
							"Could not click the save button;More Details:"
									+ immunizationData.toString(), selenium, ClassName, MethodName);
					return true;
				}
				if (immunizationData.testCaseId.equalsIgnoreCase("TC_CIM_069")) {
					assertTrue(click(selenium, btnImmEditSave),
								"Could not click the save button;More Details:"
										+ immunizationData.toString(), selenium, ClassName, MethodName);
						return true;
					}	
				waitForPageLoad(selenium);
				

			assertTrue(click(selenium, btnAdd),
					"Could not click the save button;More Details:"
							+ immunizationData.toString(), selenium, ClassName, MethodName);
		
			// "Could not click the add button;More details:"
			// + immunizationData.toString();
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return true;
    }

	/**
	 * verifyExpandView function to verify Expand View
	 * 
	 * @throws IOException
	 * 
	 * @since Oct 04, 2012
	 */
	/**
	 * verifyCollapseView function to verify Collapse View
	 * 
	 * @throws IOException
	 * 
	 * @since Oct 04, 2012
	 */
	public boolean verifyCollapseViewForImmunization(Selenium selenium,
			ChartPreVisitLib immunizationData, String account)
					throws IOException {
		String date = null;
		// System.out.println(getText(selenium, lblImmCollapsableView));

		if(account.equals(CAAccount)){
			if(!selenium.isTextPresent(immunizationData.Vaccine1CA))
			{
				return false;
			}
		}
		else
		{
			assertTrue(selenium.isTextPresent(immunizationData.vaccine.toUpperCase()),"Vaccine details r not present:"+immunizationData.toString(), selenium, ClassName, MethodName);
		}
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(immunizationData.reaction), ""
				+ "immunizationData reaction Not Present", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(immunizationData.comment), ""
				+ " Immunization Comment Not Present", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		if (account.equals(CAAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = DateFormat.format(cal.getTime());
		} else {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat.format(cal.getTime());

		}

		assertTrue(selenium.isTextPresent(date), "" + "Date Not Present",
				selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		waitForPageLoad(selenium);

		return true;
	}

	public boolean verifyExpandViewForImmunization(Selenium selenium,
			ChartPreVisitLib immunizationData, String account)
					throws IOException {
		String date = null;
		assertTrue(click(selenium, lblImmCollapsableView),
				"Could not clickthe arrow",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(immunizationData.dosage), ""
				+ "immunization Dosage  Not Present", selenium, ClassName,
				MethodName);
		
/*
		assertTrue(selenium.isTextPresent(immunizationData.dosageUnit), ""
				+ "immunization dosageUnit Not Present", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);*/

		assertTrue(selenium.isTextPresent(immunizationData.adminBy), ""
				+ " Immunization adminBy Not Present", selenium, ClassName,
				MethodName);
		

		assertTrue(selenium.isTextPresent(immunizationData.site), ""
				+ "immunization site Not Present", selenium, ClassName,
				MethodName);
		

		assertTrue(selenium.isTextPresent(immunizationData.route), ""
				+ " Immunization route Not Present", selenium, ClassName,
				MethodName);
	

		assertTrue(selenium.isTextPresent(immunizationData.lotNumber), ""
				+ " Immunization lotNumber Not Present", selenium, ClassName,
				MethodName);
	

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

		assertTrue(selenium.isTextPresent(date), "" + "Date Not Present",
				selenium, ClassName, MethodName);
	

		assertTrue(selenium.isTextPresent(immunizationData.series), ""
				+ " Immunization series Not Present", selenium, ClassName,
				MethodName);
	

		assertTrue(selenium.isTextPresent(immunizationData.seriesof), ""
				+ "immunization seriesof Not Present", selenium, ClassName,
				MethodName);
		

		assertTrue(selenium.isTextPresent(immunizationData.cpt1), ""
				+ " Immunization cpt1 Not Present", selenium, ClassName,
				MethodName);
		

		assertTrue(selenium.isTextPresent(immunizationData.cpt2), ""
				+ " Immunization cpt2 Not Present", selenium, ClassName,
				MethodName);
	

		return true;
	}
	

	/**
	 * unitTestForImmunization function to unit Test For Immunization
	 * @throws IOException 
	 * 
	 * @since Oct 04, 2012
	 */
	public boolean unitTestForImmunization(Selenium selenium,
			ChartPreVisitLibUnitTest immunizationData, String account) throws IOException {
		try {
			assertTrue(click(selenium, lnkImmunization),
					"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if (immunizationData.refused.equals("yes")) {
				assertTrue(click(selenium, chkrefused),
						"Could not click refused check box;More Details:"
								+ immunizationData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, txtRefusedImmunization,
								immunizationData.immunization),
								"Could not enter the immunization;More Details:"
										+ immunizationData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						enterDate(selenium, txtRefusedOndate,
								immunizationData.refusedDate),
								"Could not enter the resued Date;More Details:"
										+ immunizationData.toString(),selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtRefusedComment,
								immunizationData.comment),
								"Could not enter the comment;More Details:"
										+ immunizationData.toString(),selenium, ClassName, MethodName);
			}
			if (immunizationData.admin.equals("yes")) {
				assertTrue(click(selenium, chkadmin),
						"Could not click the admin check box;More Details:"
								+ immunizationData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, ajxImmunization,
								immunizationData.immunization),
								"Could not click refused check box;More Details:"
										+ immunizationData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				if (account.equals(CAAccount)) {
					assertTrue(
							enterDate(selenium, txtadminOnDate,
									immunizationData.adminOnCa),
									"Could not enter the Admin on ;More Details:"
											+ immunizationData.toString(),selenium, ClassName, MethodName);
				}
				assertTrue(
						enterDate(selenium, txtadminOnDate,
								immunizationData.adminOn),
								"Could not enter the Admin on ;More Details:"
										+ immunizationData.toString(),selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtcomment, immunizationData.comment),
						"Could not enter the comment;More Details:"
								+ immunizationData.toString(),selenium, ClassName, MethodName);
			} else if (!immunizationData.refused.equals("yes")
					&& !immunizationData.admin.equals("yes")) {
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, ajxVaccine, immunizationData.vaccine),
						"Could not enter the Data;More Details:"
								+ immunizationData.toString(),selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtLotNo, immunizationData.lotNumber),
						"Could not enter the Lot Number;More Details:"
								+ immunizationData.toString(),selenium, ClassName, MethodName);
				assertTrue(
						enterDate(selenium, txtexpiryDate,
								immunizationData.expiryData),
								"Could not enter the expiry date;More Details:"
										+ immunizationData.toString(),selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtImmDosage, immunizationData.dosage),
						"Could not enter the dosage value;More Details:"
								+ immunizationData.toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxImmdosage,
						immunizationData.dosageUnit);

				if (account.equals(CAAccount)) {
					assertTrue(
							enterDate(selenium, txtadminDate,
									immunizationData.adminOnCa),
									"Could not enter the Admin on ;More Details:"
											+ immunizationData.toString(),selenium, ClassName, MethodName);
				}
				assertTrue(
						enterDate(selenium, txtadminDate,
								immunizationData.adminOn),
								"Could not enter the Admin on ;More Details:"
										+ immunizationData.toString(),selenium, ClassName, MethodName);

				// assertTrue(enterDate(selenium,txtadminDate,immunizationData.adminOn),"Could not enter the Admin on date;More Details:"+immunizationData.toString(),selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkImmShowMore),
						"Could not click the link;More Details:"
								+ immunizationData.toString(),selenium, ClassName, MethodName);
				// waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxSeries1,
						immunizationData.series);
				selectValueFromAjaxList(selenium, ajxSeries2,
						immunizationData.seriesof);
				selectValueFromAjaxList(selenium, ajxSite,
						immunizationData.site);
				selectValueFromAjaxList(selenium, ajxImmRoute,
						immunizationData.route);
				if (immunizationData.consentCheck.equals("yes")) {
					assertTrue(click(selenium, chkConsentBox),
							"Could not click the check box",selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium, ajxConsentSuggest,
							immunizationData.consent);
				}
				selectValueFromAjaxList(selenium, ajxadminsteredBy,
						immunizationData.adminBy);
				selectValueFromAjaxList(selenium, ajxImmCpt1,
						immunizationData.cptCode1);
				selectValueFromAjaxList(selenium, ajxImmCp2,
						immunizationData.cptCode2);
				selectValueFromAjaxList(selenium, ajxImmreaction,
						immunizationData.reaction);
				assertTrue(
						type(selenium, txtImmComment, immunizationData.comment),
						"Could not type the comments;More Details:"
								+ immunizationData.toString(),selenium, ClassName, MethodName);
				if (immunizationData.saveList.equals("yes")) {
					assertTrue(click(selenium, chkQuickList),
							"Could not click the save list check box;More Details:"
									+ immunizationData.toString(),selenium, ClassName, MethodName);
				}
			}
			assertTrue(click(selenium, btnAdd),
					"Could not click the add button;More details:"
							+ immunizationData.toString(),selenium, ClassName, MethodName);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * deleteImmunization function to delete Immunization
	 * @throws IOException 
	 * 
	 * @since Sep 26, 2012
	 */


	public boolean deleteImmunization(Selenium selenium) throws IOException {
		
		boolean immunizationDeleted = true;
		int immCount = 0;
		try { 
			if(isElementPresent(selenium, btnErrorClose))
	            assertTrue(click(selenium, btnErrorClose),"Could not click on Close Button",selenium, ClassName, MethodName);

			waitForElement(selenium, btnDeleteImmunization, WAIT_TIME);
			while (isElementPresent(selenium, btnDeleteImmunization)) {

				assertTrue(click(selenium, btnDeleteImmunization),"Could not Click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtdeleteReason, "Reason"),
						"Could not type the reason",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnDeleteReason),"Could not Click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (!isElementPresent(selenium, btnDeleteImmunization)) {

					break;
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return immunizationDeleted;
	}

	public boolean deleteEncounterImmunization(Selenium selenium)
			throws IOException {

		boolean immunizationDeleted = true;
		int immCount = 0;
		try {

			waitForElement(selenium, labelImmEncounterdetails, WAIT_TIME);
			while (selenium.isElementPresent(labelImmEncounterdetails))	
				{
			
				assertTrue(click(selenium, labelImmEncounterdetails), "",
						selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnDeleteEncounterImmunization), "",
						selenium, ClassName, MethodName);
				/*assertTrue(type(selenium, txtdeleteReason, "Reason"),
						"Could not type", selenium, ClassName, MethodName);*/
				assertTrue(click(selenium, btnYes), "",
						selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,
					"Failed Due to the Exception; \n\t*) ExceptionDetails :"
							+ e.getMessage() + "\n\t*)", selenium, ClassName,
							MethodName);
		}
		return immunizationDeleted;
	}



	/**
		 *CorresPondenance
		 *  to labAdvanceSearch
		 * @throws IOException  
		 * @since Aug 25, 2014
		 */
		public boolean CorrespondenceAdvanceSearch(Selenium selenium, ChartPreVisitLib CorresData) throws IOException {
			assertTrue(type(selenium, txtAccessionNo,CorresData.AccessionNumber),"Could not type patient id", selenium, ClassName,MethodName);
			assertTrue(click(selenium, btnAdvanceSearch),"Could not click the search button", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
	waitForPageLoad(selenium);
	waitForPageLoad(selenium);
	waitForPageLoad(selenium);

			return true;
		}
	
	/**
	 * createAllergy function to create Allergy
	 * @throws IOException 
	 * 
	 * @since Nov 01, 2012
	 */
	public boolean createAllergy(Selenium selenium,
			ChartPreVisitLib allergyData, String account) throws IOException {
		try {
			waitForPageLoad(selenium);
			if (allergyData.testCaseId.equals("TC_CA_004")
					|| allergyData.testCaseId.equals("TC_CAE_004")) {
				assertTrue(click(selenium, chkInto),
						"Could not Intolernce radio button;More Details",selenium, ClassName, MethodName);
			}

			if (account.equalsIgnoreCase(CAAccount)) {
				selectValueFromAjaxList(selenium, ajxSearchAllergy,
						allergyData.allergenCa);
			} else {
				selectValueFromAjaxList(selenium, ajxSearchAllergy,
						allergyData.allergen);
			}
			//			selectValueFromAjaxList(selenium, ajxAllergyReaction,
			//					allergyData.reaction);

			assertTrue(click(selenium, ajxAllergyReaction),
					"Could not on show more button",selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, chkReaction),
					"Could not on show more button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkClose),
					"Could not on show more button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if (!(allergyData.testCaseId.equals("TC_CA_001") || allergyData.testCaseId
					.equals("TC_CAE_001"))) {
				if (getText(selenium, lnkAllShowmore).equalsIgnoreCase(
						"Show more details")) {
					assertTrue(click(selenium, lnkAllergyShowmore),
							"Could not on show more button",selenium, ClassName, MethodName);
				}
				if (getText(selenium, lnkAllShowmore).equalsIgnoreCase(
				"Show more details")) {
					assertTrue(click(selenium, lnkAllergyShowmore),
					"Could not on show more button",selenium, ClassName, MethodName);
				}

				selectValueFromAjaxList(selenium, ajxSeverity,
						allergyData.severity);

				selectValueFromAjaxList(selenium, ajxStatus, allergyData.status);

				if (account.equals(CAAccount)) {
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat DateFormat = new SimpleDateFormat(
							"dd/MM/yyyy");
					String date = DateFormat.format(cal.getTime());
					waitForPageLoad(selenium);
					assertTrue(enterDate(selenium, txtOnset, date),
							"Could not enter the Admin on ;More Details:"
									+ allergyData.toString(),selenium, ClassName, MethodName);
				} else {
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat DateFormat = new SimpleDateFormat(
							"MM/dd/yyyy");
					String date = DateFormat.format(cal.getTime());
					waitForPageLoad(selenium);
					assertTrue(enterDate(selenium, txtOnset, date),
							"Could not enter the Admin on ;More Details:"
									+ allergyData.toString(),selenium, ClassName, MethodName);
				}
				selectValueFromAjaxList(selenium, ajxlifeStage,
						allergyData.lifeStage);

				assertTrue(
						type(selenium, txtcomment, allergyData.comment),
						"Could not enter the comment;More Details:"
								+ allergyData.toString(),selenium, ClassName, MethodName);
			}
			if (allergyData.testCaseId.equalsIgnoreCase("TC_CA_041")) {
				assertTrue(
						type(selenium, txtcomment, allergyData.comment),
						"Could not enter the comment;More Details:"
								+ allergyData.toString(),selenium, ClassName, MethodName);
			}

			if (!(allergyData.testCaseId.equalsIgnoreCase("TC_CA_020"))) {
				if (allergyData.testCaseId.equalsIgnoreCase("TC_CA_005")
						|| allergyData.testCaseId
						.equalsIgnoreCase("TC_CAE_005")) {
					assertTrue(click(selenium, btnAllergyCancel),
							"Could not click the cancel button;More details:"
									+ allergyData.toString(),selenium, ClassName, MethodName);
				} else
					assertTrue(click(selenium, btnAdd),
							"Could not click the add button;More details:"
									+ allergyData.toString(),selenium, ClassName, MethodName);
			} else {
				assertTrue(click(selenium, btnSave),
						"Could not click the save button;More details:"
								+ allergyData.toString(),selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * navigateToCorres Report function
	 * @throws IOException 
	 * 
	 * @since Aug 25, 2014
	 */
	public boolean DeletecorrespondenceReport(Selenium selenium,
			ChartPreVisitLib labData)  {

		try {
			int count = 0;
			while (isElementPresent(selenium, btnunsignedcorresAction)) {
				assertTrue(click(selenium, btnunsignedcorresAction),
						"Could not click on Actions button;More Details",
						selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnCorresDelete),
						"Could not click on delete button;More Details",
						selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtdeleteReason, "Reason"),
						"Could not type reason ;More Details", selenium,
						ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkDeleteReason),
						"Could not click on Delete button;More Details",
						selenium, ClassName, MethodName);

				waitForPageLoad(selenium);
				assertTrue(click(selenium, CorresTab),"Could not click corres tab", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				count++;
				if (count > 30)
					break;
			return true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		

	}


	/**
	 * verifyAllergy function to verify Allergy
	 * @throws IOException 
	 * 
	 * @since July 08, 2013
	 */
	public boolean verifyAllergy(Selenium selenium,
			ChartPreVisitLib allergyData, String account) throws IOException {
		try {
			waitForPageLoad(selenium);

			if (account.equalsIgnoreCase(CAAccount)) {
				assertTrue(selenium.isTextPresent(allergyData.allergenCa
						.toUpperCase(new java.util.Locale("en", "Us"))),"Text Not Present",selenium, ClassName, MethodName);
			} else {

				assertTrue(selenium.isTextPresent(allergyData.allergen
						.toUpperCase(new java.util.Locale("en", "Us"))),"Text Not Present",selenium, ClassName, MethodName);
			}

			return true;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * navigateToCorres Report function
	 * @throws IOException 
	 * 
	 * @since Aug 25, 2014
	 */
	public boolean navigateToCorresReport(Selenium selenium,
			ChartPreVisitLib labData)  {

		try {
			assertTrue(click(selenium, lnkQuickAction),
					"Could not click on patient options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkFileDocu), "Could not click link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		

	}



	/**
	 * LogoutofApplication
	 * Function to logoutofApplication
	 * @param 	selenium
	 * @since	Sep 03,2013
	 */
	
	public boolean logoutofApplication(Selenium selenium){
		
		
		if(click(session(), lnkTopMenu)){
		    if(!isElementPresent(selenium,lnkSignout)){
			click(selenium,lnkTopMenu);
		    }
			if(click(session(), lnkSignout)){
				// increment the possition value after sign out
				possition =1;
				if(isElementPresent(session(),btnYes)){
					click(session(),btnYes);
				}else if(isElementPresent(session(),lnkBtnContinue)){
					click(session(),lnkBtnContinue);
					if(isElementPresent(session(),btnYes)){
						click(session(),btnYes);
					}else{
						click(session(),lnkBtnYes);
					}
				}else if(isElementPresent(session(),lnkContinuelogout)){
					click(session(),lnkContinuelogout);
					if(isElementPresent(session(),btnYes)){
						click(session(),btnYes);
					}else{
						click(session(),lnkBtnYes);
					}
				}else if(isElementPresent(session(),btnYesbutton)){
					click(session(),btnYesbutton);
				}
				
				else{
					click(session(),lnkBtnYes);
				}
				
			}
		}

	return true;	
	
	}
	






	/**
	 * Create a New Diagnostic Test Report					
	 * 
	 * @since Oct 15, 2014
	 */
	public boolean CreateDiagnosticReport(Selenium selenium,ChartPreVisitLib diData,String userAccount) throws IOException
	{
		try {
			String date = null;  
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat.format(cal.getTime());
			}else{
				Calendar cal1=Calendar.getInstance();
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
				date=DateForma1t.format(cal1.getTime());		
			}			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MdHHmmss");
			String uniqueTime=DateFormat.format(cal.getTime());
			diData.AccessionNumber = uniqueTime;
			System.out.println("Accession Number -"+uniqueTime);
			
			if (diData.testCaseId.equals("TC_CDR_007")){
				
				if(userAccount.equals(CAAccount)){
				    cal=Calendar.getInstance();
				    cal.add(Calendar.DATE, -1);
				    cal.add(Calendar.MONTH, -1);
					SimpleDateFormat dateFormat1=new SimpleDateFormat("dd/MM/yyyy");
					date=dateFormat1.format(cal.getTime());
				}else{					
				    cal=Calendar.getInstance();
				    cal.add(Calendar.DATE, -1);
					cal.add(Calendar.MONTH, -1);
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
				}
			}
			
			if (!diData.testCaseId.equals("TC_CDR_007")){
				diData.facilityName = diData.facilityName+uniqueTime;		
				System.out.println("Facility Name - " +diData.facilityName);
			}
			
			File dir1 = new File(".");
			String strBasePath = null;
			String file = null;
			String fileName = "Diagnostic_Report.doc";
			String sectionName = "chartprevisit";
			strBasePath = dir1.getCanonicalPath();
			file = strBasePath + File.separator + "src" + File.separator+ "main" + File.separator + "resources" + File.separator+ "nexia" + File.separator + "testdata" + File.separator+ sectionName + File.separator + fileName;
			waitForPageLoad(selenium);
			
			String providerNameTemp = getText(selenium, lnkTopMenu);
			String pName = providerNameTemp.replaceAll(", "
					+ diData.switchRole, "");
			String tempArray[] = pName.split(" ");
			String providerName = tempArray[1] + ", " + tempArray[0];
			diData.Receivingprovider = providerName;
			
			assertTrue(click(selenium, btnUploadFile),"Could not click upload btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium, txtBrowseFile, file),	"Could not select upload file", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			Robot robot = null;
			robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			assertTrue(click(selenium, btnFile),"Could not click File button btn", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
					
            assertTrue(type(selenium,txtSearchFileToPatient,diData.patientId),"Could not type patient id",selenium, ClassName, MethodName);
        	waitForPageLoad(selenium);
        	
			assertTrue(clickAt(selenium,txtSearchFileToPatient, ""),"Could not perform click At",selenium, ClassName, MethodName);
			assertTrue(focus(selenium,txtSearchFileToPatient),"Could not perform focus",selenium, ClassName, MethodName);
			assertTrue(fireEvent(selenium,txtSearchFileToPatient,"keypress"),"Could not perform fireevent",selenium, ClassName, MethodName);			
			assertTrue(keyPress(selenium,txtPatientBox, "\\9"),"Could not perform keypress",selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
		
			waitForElement(selenium, txtSearchFileToPatient, 30000);
			assertTrue(isElementPresent(selenium,txtSearchFileToPatient),"Search Results are not displayed for the patient with ID :-"+ diData.patientId,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,patientInfoWid)){
			System.out.println(getText(selenium,patientInfoWid));
     		assertTrue(getText(selenium,patientInfoWid).toLowerCase(new java.util.Locale("en", "US")).trim().contains(diData.patientId.trim().toLowerCase(new java.util.Locale("en", "US"))),"Could not get the text value",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
     		assertTrue(click(selenium, patientInfoWid),"Could not select the patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}else {
				System.out.println(getText(selenium,lblPatientInfoWid));
	     		assertTrue(getText(selenium,lblPatientInfoWid).toLowerCase(new java.util.Locale("en", "US")).trim().contains(diData.patientId.trim().toLowerCase(new java.util.Locale("en", "US"))),"Could not get the text value",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
	     		assertTrue(click(selenium, lblPatientInfoWid),"Could not select the patient",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(selectValueFromAjaxList(selenium, ajxDocuType,diData.DocumentType),"Could not select Docu type", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium, elementaccNumberforCorres,diData.AccessionNumber),"Could not  type Accession number", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(selectValueFromAjaxList(selenium,ajxRProvider,diData.Receivingprovider), "Could not select Receiving provider ",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium, txtFacility, diData.facilityName),"Could not type facility.", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(enterDate(selenium, txtOrderedDate, date),"Could not type ordered date.", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(enterDate(selenium, txtDIRecievedDate, date),"Could not type Received date.", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if (diData.testCaseId.equals("TC_CDR_009")){
			assertTrue(selectValueFromAjaxList(selenium,txtOrderingProviderSearchBox,diData.Receivingprovider), "Could not select Ordering provider",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			} else {
				assertTrue(selectValueFromAjaxList(selenium,txtOrderingProviderSearchBox,diData.Orderingprovider), "Could not select Ordering provider",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if (diData.testCaseId.equals("TC_CDR_010")){
			assertTrue(selectValueFromAjaxList(selenium,ajxCopyToSearchBox,diData.copiedTo), "Could not select CopyTo provider",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}else{
				assertTrue(selectValueFromAjaxList(selenium,ajxCopyToSearchBox,diData.Receivingprovider), "Could not select CopyTo provider",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(enterDate(selenium, txtServiceDate1, date),"Could not type Service date", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(enterDate(selenium,txtDIPrintedDate, date),"Could not type printed date", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtreportComments, diData.comments),"Could not type Report Comments", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if (diData.testCaseId.equals("TC_CDR_004") || diData.testCaseId.equals("TC_CDR_005")||diData.testCaseId.equals("TC_CDR_013")|| diData.testCaseId.equals("TC_CDR_014")
					|| diData.testCaseId.equals("TC_CDR_015")|| diData.testCaseId.equals("TC_CDR_018")|| diData.testCaseId.equals("TC_CDR_023") || diData.testCaseId.equals("TC_CDR_024") ){
				
			assertTrue(enterDate(selenium,txtTranscribedDate, date),"Could not type Transcribed date", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtTranscriptionist, diData.transcriptionist),"Could not type Transcriptionist", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,elementAddTestResult),"Could not click add test result", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxLabTestName,diData.labTestName),"Could not type Lab Test Name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,elementResult,diData.testResult),"Could not type Test Result", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtDiComments,diData.dicomment),"Could not type DI Comments", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			}
			assertTrue(click(selenium,btnSaveNext),"Could not click save & next", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!isElementPresent(selenium,btnSaveNext),"Could not save the uploaded file", selenium, ClassName,MethodName);
			
		}
		
	 catch (Exception e) {
		// TODO: handle exception
		Assert.fail(e.getMessage());
	}
	return true;
	
}	

	/**
	 * verifyCollapseViewForAllergy function to verifyCollapseViewForAllergy
	 * 
	 * @since Nov 01, 2012
	 */

	public boolean verifyCollapseViewForAllergy(Selenium selenium,
			ChartPreVisitLib allergyData, String userAccount) {
		waitForPageLoad(selenium);
		System.out.println(getText(selenium, lblAllergyCollapseView));
		if (!getText(selenium, lblAllergyCollapseView).trim().contains(
				allergyData.allergyType.trim())) {
			return false;
		}

		if (userAccount.equals(CAAccount)) {

			if (!getText(selenium, lblAllergyCollapseView)
					.toLowerCase(new java.util.Locale("en", "Us"))
					.trim()
					.contains(
							allergyData.allergenCa.trim().toLowerCase(
									new java.util.Locale("en", "Us")))) {
				return false;
			}
		} else {
			if (!getText(selenium, lblAllergyCollapseView)
					.toLowerCase(new java.util.Locale("en", "Us"))
					.trim()
					.contains(
							allergyData.allergen.trim().toLowerCase(
									new java.util.Locale("en", "Us")))) {
				return false;
			}
		}
		/*if (!getText(selenium, lblAllergyCollapseView)
				.toLowerCase(new java.util.Locale("en", "Us"))
				.trim()
				.contains(
						allergyData.reaction.trim().toLowerCase(
								new java.util.Locale("en", "Us")))) {
			return false;
		}*/
		if (!getText(selenium, lblAllergyCollapseView)
				.toLowerCase(new java.util.Locale("en", "Us"))
				.trim()
				.contains(
						allergyData.severity.trim().toLowerCase(
								new java.util.Locale("en", "Us")))) {
			return false;
		}
		if (!getText(selenium, lblAllergyCollapseView)
				.toLowerCase(new java.util.Locale("en", "Us"))
				.trim()
				.contains(
						allergyData.status.trim().toLowerCase(
								new java.util.Locale("en", "Us")))) {
			return false;
		}
		if (!getText(selenium, lblAllergyCollapseView)
				.toLowerCase(new java.util.Locale("en", "Us"))
				.trim()
				.contains(
						allergyData.comment.trim().toLowerCase(
								new java.util.Locale("en", "Us")))) {
			return false;
		}
		return true;
	}
	/**
	 * verifyExpandViewForAllergy function to verifyExpandViewForAllergy
	 * @throws IOException 
	 * 
	 * @since Nov 01, 2012
	 */
	
	public boolean verifyCollapseAllergyView(Selenium selenium,
			ChartPreVisitLib allergyData, String userAccount) throws IOException  {
		waitForPageLoad(selenium);
		//div[@id='collapsableTitle1148']
		assertTrue(selenium.isTextPresent(allergyData.allergyType),"Could not find Allergy type", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(allergyData.severity.toUpperCase()),"Could not find Severity", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(allergyData.status),"Could not find status", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(allergyData.comment),"Could not find comment", selenium, ClassName, MethodName);
		return true;
	}
	
	/**
	 * verifyverifyCollapseAllergyView function to verifyCollapseAllergyView
	 * @throws IOException 
	 * 
	 * @since Nov 01, 2012
	 */
	
	
	
	
	
	public boolean verifyExpandViewForAllergy(Selenium selenium,
			ChartPreVisitLib allergyData, String date, String time,
			String account) throws IOException {

		String upDate = null;

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("MMM dd, yyyy");
		upDate = DateFormat.format(cal.getTime());

		assertTrue(click(selenium, lblAllergyCollapseView),
				"Could not click the arrow",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		/*
		 * click(selenium,lblMedsData); waitForPageLoad(selenium);
		 */
		if (!getText(selenium, lblAllergyExpandView).trim().contains(
				allergyData.lifeStage.trim())) {
			return false;
		}
		System.out.println(getText(selenium, lblAllergyExpandView));
		if (!getText(selenium, lblAllergyExpandView).trim().contains(upDate)) {
			return false;
		}
		return true;

	}

	/**
	 * verifyStoredValueForAllergy function to verifyStoredValueForAllergy
	 * @throws IOException 
	 * 
	 * @since Nov 01, 2012
	 */
	
	public boolean verifyExpandAllergyView(Selenium selenium,
			ChartPreVisitLib allergyData, String date, String time,
			String account) throws IOException {

		String upDate = null;

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("MMM dd, yyyy");
		upDate = DateFormat.format(cal.getTime());
        assertTrue(click(selenium, lblAllergy),	"Could not click the allergy label",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(allergyData.lifeStage),"Could not find life stage", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(upDate),"Could not find Date", selenium, ClassName, MethodName);
		return true;

	}
	
	/**
	 * verifyStoredAllergyView function to verifyStoredValueForAllergy
	 * @throws IOException 
	 * 
	 * @since Nov 01, 2012
	 */

	
	
	public boolean verifyStoredValueForAllergyWithSummaryPage(
			Selenium selenium, ChartPreVisitLib allergyData, String account) throws IOException {

		String date = null;
		if (account.equals(CAAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = DateFormat.format(cal.getTime());

		} else {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat.format(cal.getTime());

		}
		// click(selenium,lblMedsData);
		//waitForPageLoad(selenium);

		/*
		 * if(!getText(selenium,lblAllergyDetails).trim().contains(allergyData.
		 * allergyType.trim())){ return false; }
		 */

		assertTrue(click(selenium, lblMedsCollapseDetails),"Could not click the Expand Arrow", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);


		if (account.equals(CAAccount)) {

			assertTrue(selenium.isTextPresent(allergyData.allergenCa.toUpperCase()), "" + "CA Allergen Not Present", selenium, ClassName, MethodName);

		} else {
			assertTrue(selenium.isTextPresent(allergyData.allergen.toUpperCase()), "" + "Allergen Not Present", selenium, ClassName, MethodName);
		}

		assertTrue(selenium.isTextPresent(allergyReaction), "" + "Allergy Reaction Not Present", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(allergyData.severity.toUpperCase()), "" + "Allergy Severity Not Present", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(allergyData.status), "" + "Allergy Status Not Present", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(allergyData.comment), "" + "Allergy comment Not Present", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(allergyData.lifeStage), "" + "Allergy lifeStage Not Present", selenium, ClassName, MethodName);
		return true;
	}


	/**
	 * deleteAllergy function to delete Allergy
	 * @throws IOException 
	 * 
	 * @since Oct 17, 2012
	 */
	public boolean deleteAllAllergy(Selenium selenium,
			ChartPreVisitLib allergyData) throws IOException {
		boolean historyDeleted = true;
		int historyCount = 0;
		try {

			assertTrue(click(selenium, chkshowAllRecords),
					"Could not click the show All recorded check box;More Details:"
							+ allergyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForElement(selenium, btnDeleteAllergy, WAIT_TIME);
			while ((Integer) selenium.getXpathCount(btnDeleteAllergy) > 0) {
				historyCount = (Integer) selenium
						.getXpathCount(btnDeleteAllergy);
				assertTrue(click(selenium, btnDeleteAllergy),"Could not Click the Delete Allergy Button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, txtdeleteReason,
								allergyData.userAccount),
						"Could not enter the reason",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkDeleteReason),"Could not click on Continue Button" ,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
			
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return historyDeleted;
	}



	/**
	 * editAllergy function to editAllergy
	 * @throws IOException 
	 * 
	 * @since Sep 27, 2012
	 */

	public boolean editAllergy(Selenium selenium, ChartPreVisitLib allergyData,
			String account) throws IOException {
		try {

			selenium.focus("intoleranceradio");
			selenium.clickAt("intoleranceradio", "");
			assertTrue(click(selenium, "intoleranceradio"),
					"Could not click allergy radio button;More Details",selenium, ClassName, MethodName);

			if (account.equals(CAAccount)) {
				selectValueFromAjaxList(selenium, ajxSearchAllergy,
						allergyData.allergenCa);
			} else {
				selectValueFromAjaxList(selenium, ajxSearchAllergy,
						allergyData.allergen);
			}

			/*selectValueFromAjaxList(selenium, ajxAllergyReaction,
					allergyData.reaction);*/

			/*
			 * if (getText(selenium, lnkAllShowmore).equalsIgnoreCase(
			 * "Show more details")) { assertTrue(click(selenium,
			 * lnkAllergyShowmore), "Could not on show more button"); }
			 */
			selectValueFromAjaxList(selenium, ajxSeverity, allergyData.severity);

			selectValueFromAjaxList(selenium, ajxStatus, allergyData.status);
			
			if(!selenium.isVisible(txtOnset))
			{
				assertTrue(click(selenium, lnkAllergyShowmore),	"Could not on show more button",selenium, ClassName, MethodName);
			}
			/*if (getText(selenium, lnkAllShowmore).equalsIgnoreCase(
					"Show more details")) {
						assertTrue(click(selenium, lnkAllergyShowmore),	"Could not on show more button",selenium, ClassName, MethodName);
					}*/

			if (account.equals(CAAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String date = DateFormat.format(cal.getTime());
				assertTrue(enterDate(selenium, txtOnset, date),
						"Could not enter the Admin on ;More Details:"
								+ allergyData.toString(),selenium, ClassName, MethodName);
			} else {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				String date = DateFormat.format(cal.getTime());
				assertTrue(enterDate(selenium, txtOnset, date),
						"Could not enter the Admin on ;More Details:"
								+ allergyData.toString(),selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium, ajxlifeStage,
					allergyData.lifeStage);

			assertTrue(
					type(selenium, txtcomment, allergyData.comment),
					"Could not enter the comment;More Details:"
							+ allergyData.toString(),selenium, ClassName, MethodName);
             
            if(allergyData.testCaseId.equals("TC_CA_046"))
            {
            	assertTrue(
            			click(selenium, btnAdd),
    					"Could not click add;More Details:"
    							+ allergyData.toString(),selenium, ClassName, MethodName);
    			waitForPageLoad(selenium);
    			return true;

            }
			assertTrue(click(selenium, btnAllergyEditsave),
					"Could not click the save button;More details:"
							+ allergyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}




	/**
	 * deleteAllEncounterAllergy function to delete all existing Encounter
	 * Allergy
	 * @throws IOException 
	 * 
	 * @since Oct 19, 2012
	 */
	public boolean deleteAllEncounterAllergy(Selenium selenium,
			ChartPreVisitLib historyData) throws IOException {
		boolean allergyDeleted = true;
		int historyCount = 0;
		try {
			waitForElement(selenium, "xpath=(//*[contains(@id,'Delete')])",
					WAIT_TIME);
			while ((Integer) selenium
					.getXpathCount("xpath=(//*[contains(@id,'Delete')])") > 0) {
				historyCount = (Integer) selenium
						.getXpathCount("xpath=(//*[contains(@id,'Delete')])");
				assertTrue(click(selenium,
						"xpath=(//*[contains(@id,'Delete')])"),"Could not click the xpath link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtdeleteReason, "reason"),
						"Could not type reason for deletion",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnDeleteReason),
						"Could not click Delete button;More Details:",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//assertTrue(click(selenium,lnkPrescribeDelete),
							//	"Could not click the delete button;More Details:"
									//	+ historyData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//assertTrue(click(selenium, btnYes),
						//"Could not click Yes button;More Details:"
							//	+ historyData.toString(),selenium, ClassName, MethodName);
				//waitForPageLoad(selenium);
				if (historyCount == (Integer) selenium
						.getXpathCount("xpath=(//*[contains(@id,'Delete')])")) {
					allergyDeleted = false;
					break;
				}
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return allergyDeleted;
	}


	/**
	 * unitTestForAllergy function to verify unit test
	 * @throws IOException 
	 * 
	 * @since Oct 22, 2012
	 */

	public boolean unitTestForAllergy(Selenium selenium,
			ChartPreVisitLibUnitTest allergyData) throws IOException {
		try {
			assertTrue(click(selenium, "chkQuickList"),
					"Could not click allergy radio button;More Details",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxSearchAllergy,
					allergyData.allergen);
			selectValueFromAjaxList(selenium, ajxAllergyReaction,
					allergyData.reaction);
			assertTrue(click(selenium, lnkAllergyShowmore),
					"Could not on show more button",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxSeverity, allergyData.severity);
			selectValueFromAjaxList(selenium, ajxStatus, allergyData.status);
			assertTrue(
					enterDate(selenium, txtOnset, allergyData.onsetDate),
					"Could not enter the Admin on ;More Details:"
							+ allergyData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxlifeStage,
					allergyData.lifeStage);
			assertTrue(
					type(selenium, txtcomment, allergyData.comment),
					"Could not enter the comment;More Details:"
							+ allergyData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnAdd),
					"Could not click the Add button;More details:"
							+ allergyData.toString(),selenium, ClassName, MethodName);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * createProcedure function to create Procedure
	 * @throws IOException 
	 * 
	 * @since Sep 28, 2012
	 */

	public boolean createProcedure(Selenium selenium, ChartPreVisitLib proData,
			String account) throws IOException {
		String date = "";
		if (account.equals(CAAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd");
			date = DateFormat.format(cal.getTime());
			int date1 = Integer.parseInt(date);
			if (date1 < 10) {
				SimpleDateFormat DateForma1t = new SimpleDateFormat("d/MM/yyyy");
				date = DateForma1t.format(cal.getTime());
			} else {
				SimpleDateFormat DateFormat2 = new SimpleDateFormat(
						"dd/MM/yyyy");
				date = DateFormat2.format(cal.getTime());
			}
		} else {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat.format(cal.getTime());

		}
		try {
			if (proData.testCaseId.equalsIgnoreCase("TC_CP_001")) {
				if (!isChecked(selenium, chkQuickList)) {
					assertTrue(click(selenium, chkQuickList),
							"Could not click the Save Quick List check box;More Details:"
									+ proData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			}
			assertTrue(
					type(selenium, txtProcedureName, proData.proName),
					"Could not type procedure name",selenium, ClassName, MethodName);

			assertTrue(
					enterDate(selenium, txtProcedureDate, date),
					"Could not enter the Admin on ;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);

			waitForPageLoad(selenium);
			if (proData.testCaseId.equals("TC_CP_002")
					|| proData.testCaseId.equals("TC_CP_017")
					|| proData.testCaseId.equals("TC_CP_018")
					|| proData.testCaseId.equals("TC_CP_019")
					|| proData.testCaseId.equals("TC_CP_020")
					|| proData.testCaseId.equals("TC_CP_021")
					|| proData.testCaseId.equals("TC_CP_022")
					|| proData.testCaseId.equals("TC_CP_023")
					|| proData.testCaseId.equals("TC_CP_024")
					|| proData.testCaseId.equals("TC_CP_026")
					|| proData.testCaseId.equals("TC_CP_027")
					|| proData.testCaseId.equals("TC_CP_028")
					|| proData.testCaseId.equals("TC_CP_029")
					|| proData.testCaseId.equals("TC_CP_030")
					|| proData.testCaseId.equals("TC_CP_031")
					|| proData.testCaseId.equals("TC_CP_032")
					|| proData.testCaseId.equals("TC_CP_033")
					|| proData.testCaseId.equals("TC_CP_052")) {
				assertTrue(click(selenium, lnkProcedureShowMore),
						"Could not on show more button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,txtOnset))
				{
					assertTrue(
							enterDate(selenium, txtOnset, date),
							"Could not enter the Admin on ;More Details:"
									+ proData.toString(),selenium, ClassName, MethodName);	
				}				

				selectValueFromAjaxList(selenium, txtcpt, proData.cpt);

				assertTrue(
						type(selenium, txtcomment, proData.comment),
						"Could not enter the comment;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
				if (proData.consentCheck.equals("yes")) {
					assertTrue(click(selenium, chkConsentBox),
							"Could not on show more button",selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium, consent_procedure,
							proData.consent);
				}
			}
			if (proData.testCaseId.equals("TC_CP_014")) {
				assertTrue(click(selenium, lnkAllergy),
						"Could not click the Allergy link;More Details",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				return true;
			}
			assertTrue(
					click(selenium, btnAdd),
					"Could not click the add button;More details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean createPatientMandatory(Selenium selenium, HomeLib patientData)throws Exception
	{
		
		assertTrue(type(selenium,txtLastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(), selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtFirstName,patientData.firstName),"Could not type the first Name : More Details"+patientData.toString(), selenium, ClassName, MethodName);
		assertTrue(enterDate(selenium, txtDOB, patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob, selenium, ClassName, MethodName);
		if(isElementPresent(selenium,btnNoDuplicate))
		{
			click(selenium,btnNoDuplicate);
		}
		assertTrue(click(selenium,btnClinicalSave),"Could not click Save button More Dateils"+patientData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,btnClinicalSave))
		{
			return false;
		}
		return true;
	}
	
	/**
	 * navigateToPatientNewPatientRegistration
	 * function to Navigate to patient registration page
	 * @since  	     November 03, 2014
	 */
	public boolean navigateToNewPatientRegistration(Selenium selenium)throws IOException
	{
		assertTrue(click(selenium,lnkQuickLink),"Could not click on quick action", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkRegisterPatient),"Could not click the Register Patient", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	/**
	 * verifyCollapseViewForProcedure function to verifyCollapseViewForProcedure
	 * 
	 * @throws IOException
	 * 
	 * @since Sep 28, 2012
	 */
	public boolean verifyCollapseViewForProcedure(Selenium selenium,
			ChartPreVisitLib proData, String account) throws IOException {
		String date = null;
		if (account.equals(CAAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = DateFormat.format(cal.getTime());
		} else {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat.format(cal.getTime());
		}

		assertTrue(selenium.isTextPresent(proData.proName),
				"Procedure Name Not Present", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(proData.comment),
				"Procedure Comment Not Present", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(date), "Date Not Present", selenium,
				ClassName, MethodName);
		waitForPageLoad(selenium);

		return true;
	}

	/**
	 * verifyExpandViewForProcedure function to verifyExpandViewForProcedure
	 * 
	 * @throws IOException
	 * 
	 * @since Sep 28, 2012
	 */
	public boolean verifyExpandViewForProcedure(Selenium selenium,
			ChartPreVisitLib proData, String userAccount) throws IOException {

		String date = "";
		if (userAccount.equals(CAAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd");
			date = DateFormat.format(cal.getTime());
			int date1 = Integer.parseInt(date);
			if (date1 < 10) {
				SimpleDateFormat DateForma1t = new SimpleDateFormat("MMM d, yyyy");
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

		assertTrue(click(selenium, lblProCollapseView),
				"Could not click the Arrow;More Details:", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(date), "Date Not Present", selenium,
				ClassName, MethodName);

		return true;
	}


	/**
	 * verifyCollapseViewForSocialHistory function to
	 * verifyCollapseViewForSocialHistort
	 * 
	 * @throws IOException
	 * 
	 * @since March 07, 2014
	 */
	public boolean verifyCollapseViewForSocialHistory(Selenium selenium,
			ChartPreVisitLib historyData, String account) throws IOException {
		System.out.println(getText(selenium, lblCollapseViewSocial));
		System.out.println(historyData.type);

		assertTrue(selenium.isTextPresent(historyData.type), ""
				+ "Social History Type Not Present", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		/*assertTrue(selenium.isTextPresent(historyData.status.toUpperCase()), ""
				+ "Social History Status Not Present", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);*/

		assertTrue(selenium.isTextPresent(historyData.detailsNum), ""
				+ "Social History Details Number Not Present", selenium,
				ClassName, MethodName);
		
		assertTrue(selenium.isTextPresent(historyData.detailsNum), ""
				+ "Social History Details Text Not Present", selenium,
				ClassName, MethodName);
		

		assertTrue(selenium.isTextPresent(historyData.period), ""
				+ "Social History Period Not Present", selenium, ClassName,
				MethodName);
		

		assertTrue(selenium.isTextPresent(historyData.year), ""
				+ "Social History Year Not Present", selenium, ClassName,
				MethodName);
	

		assertTrue(selenium.isTextPresent(historyData.comment), ""
				+ "Social History Comments Not Present", selenium, ClassName,
				MethodName);
	
		return true;

	}

	/**
	 * verifyExpandViewForSocialHistory function to
	 * verifyExpandViewForSocialHistory
	 * 
	 * @throws IOException
	 * 
	 * @since March 7, 2014
	 */
	public boolean verifyExpandViewForSocialHistory(Selenium selenium,
			ChartPreVisitLib historyData, String userAccount)
					throws IOException {

		assertTrue(
				click(selenium, lnlSocialArrow),
				"Colud not click the arrow;More Details:"
						+ historyData.toString(), selenium, ClassName,
						MethodName);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(historyData.lifeStage), ""
				+ "Social History LifeStage Not Present", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(historyData.startAge), ""
				+ "Social History StartAge Not Present", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(historyData.historyType), ""
				+ "Social History HistoryType Not Present", selenium,
				ClassName, MethodName);
		waitForPageLoad(selenium);

		return true;

	}

	/**
	 * deleteAllRecommendationAndPlan function to delete All existing
	 * Recommendation and Plan
	 * @throws IOException 
	 * 
	 * @since Dec 03, 2012
	 */
	public boolean deleteAllRecommendationAndPlan(Selenium selenium,
			ChartPreVisitLib proData) throws IOException {
		boolean procedureDeleted = true;
		int procedureCount = 0;
		try {
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				selenium.chooseOkOnNextConfirmation();
			}
			waitForElement(selenium, lblEncounterData, WAIT_TIME);
			while ((Integer) selenium.getXpathCount(lblEncounterData) > 0) {
				procedureCount = (Integer) selenium
						.getXpathCount(lblEncounterData);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lblEncounterData),"Could not click the Encounter Data link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (isElementPresent(selenium, "//div[6]/div/div/a[2]/span")) {
					assertTrue(
							click(selenium, "//div[6]/div/div/a[2]/span"),
							"Could not click the delete button;More Details:"
									+ proData.toString(),selenium, ClassName, MethodName);
				} else if (isElementPresent(selenium,
						"css=#delete > span.topMenuItemSpan.light")) {
					assertTrue(
							click(selenium,
									"css=#delete > span.topMenuItemSpan.light"),
									"Could not click the delete button;More Details:"
											+ proData.toString(),selenium, ClassName, MethodName);
				} else if (isElementPresent(selenium,
						"//div[5]/div/div/a[2]/span")) {
					assertTrue(
							click(selenium, "//div[5]/div/div/a[2]/span"),
							"Could not click the delete button;More Details:"
									+ proData.toString(),selenium, ClassName, MethodName);
				} else if (isElementPresent(selenium, btnDeletebutton)) {
					assertTrue(click(selenium, btnDeletebutton),
							"Could not click the delete button;More Details:"
									+ proData.toString(),selenium, ClassName, MethodName);
				}
				waitForPageLoad(selenium);
				assertTrue(
						click(selenium, btnYes),
						"Could not click yes button;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (procedureCount == (Integer) selenium
						.getXpathCount(lblEncounterData)) {
					procedureDeleted = false;
					break;
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return procedureDeleted;
	}
	/**
	 * deleteProcedure function to delete Procedure
	 * @throws IOException 
	 * 
	 * @since Oct 19, 2012
	 */
	public boolean deleteProcedure(Selenium selenium, ChartPreVisitLib proData) throws IOException {
		boolean procedureDeleted = true;
		int procedureCount;
		try {
			int deleteCount = (Integer) selenium
					.getXpathCount(lnkDeleteProcedure);
			for (procedureCount = 1; procedureCount <= deleteCount; procedureCount++) {
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkDeleteProcedure),
						"Could not clik the Delete button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, txtdeleteReason, proData.reason),
						"Could not type the reason; More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnDeleteReason),
						"Could not click the delete button;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return procedureDeleted;
	}

	/**
	 * createProcedureWithPartialDate function to create Procedure
	 * @throws IOException 
	 * 
	 * @since Sep 28, 2012
	 */

	public boolean createProcedureWithPartialDate(Selenium selenium,
			ChartPreVisitLib proData, String account) throws IOException {
		try {
			
			if(account.equals(CAAccount) ){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/yyyy");
				date=DateFormat.format(cal.getTime());
				
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/ yyyy");
				date=DateFormat.format(cal.getTime());
				
			}
			
			if (proData.testCaseId.equalsIgnoreCase("TC_CP_001")) {
				if (!isChecked(selenium, chkQuickList)) {
					assertTrue(click(selenium, chkQuickList),
							"Could not click the Save Quick List check box;More Details:"
									+ proData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			}
			assertTrue(
					type(selenium, txtProcedureName, proData.proName),
					"Could not type procedure name",selenium, ClassName, MethodName);

			assertTrue(
					enterDate(selenium, txtProcedureDate, date),
					"Could not enter the Admin on ;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);

			if (proData.testCaseId.equals("TC_CP_002")) {
				assertTrue(click(selenium, lnkProcedureShowMore),
						"Could not on show more button",selenium, ClassName, MethodName);

				assertTrue(
						enterDate(selenium, txtOnset, date),
						"Could not enter the Admin on ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);

				selectValueFromAjaxList(selenium, txtcpt, proData.cpt);

				assertTrue(
						type(selenium, txtcomment, proData.comment),
						"Could not enter the comment;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
				if (proData.consentCheck.equals("yes")) {
					assertTrue(click(selenium, chkConsentBox),
							"Could not on show more button",selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium, consent_procedure,
							proData.consent);
				}
			}
			assertTrue(
					click(selenium, btnAdd),
					"Could not click the add button;More details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * deleteEncounterProcedure function to delete Encounter Procedure
	 * @throws IOException 
	 * 
	 * @since Oct 19, 2012
	 */
	public boolean deleteEncounterProcedure(Selenium selenium,
			ChartPreVisitLib proData) throws IOException {
		boolean procedureDeleted = true;
		int procedureCount = 0;
		try {

			waitForElement(selenium, lblEncouterSumDetailsProcedure, WAIT_TIME);
			while ((Integer) selenium.getXpathCount(btnDeletebutton) > 0) {
				procedureCount = (Integer) selenium
						.getXpathCount(btnDeletebutton);
				assertTrue(click(selenium, btnDeletebutton),
						"Could not click the delete button;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtdeleteReason,proData.proName),"Could not enter the reason",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkDeleteReason),
						"Could not click the delete button;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (procedureCount == (Integer) selenium
						.getXpathCount(btnDeletebutton)) {
					procedureDeleted = false;
					break;
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return procedureDeleted;
	}

	public boolean editProcedure(Selenium selenium, ChartPreVisitLib proData,
			String account) throws IOException {
		String date = "";
		try {
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(
					type(selenium, txtProcedureName, proData.proName),
					"Could not on show more button",selenium, ClassName, MethodName);
			if (account.equals(CAAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				date = DateFormat.format(cal.getTime());
				assertTrue(
						enterDate(selenium, txtProcedureDate, date),
						"Could not enter the Admin on ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			} else {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal.getTime());
				assertTrue(
						enterDate(selenium, txtProcedureDate, date),
						"Could not enter the Admin on ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			}
			if (isElementVisible(selenium, lnkProcedureShowMore)) {


				assertTrue(click(selenium, lnkProcedureShowMore), ""
						+ "Could not on show more Arrow", selenium, ClassName,
						MethodName);
				//assertTrue(click(selenium, lnkProcedureShowMore),
				//		"Could not on show more button");
			}

			if (account.equals(CAAccount)) {
			/*	assertTrue(
						enterDate(selenium, txtOnset, date),
						"Could not enter the Admin on ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);*/
			} else


			/*	assertTrue(enterDate(selenium, txtOnset, date), ""+ " Could not enter the Admin on ;More Details:", selenium, ClassName,
						MethodName);*/
			waitForPageLoad(selenium);


			selectValueFromAjaxList(selenium, txtcpt, proData.cpt);

			assertTrue(
					type(selenium, txtcomment, proData.comment),
					"Could not enter the comment;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			if (proData.consentCheck.equals("yes")) {
				assertTrue(click(selenium, chkConsentBox),
						"Could not on show more button",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, consent_procedure,
						proData.consent);
			}

			if (proData.testCaseId.equals("TC_CP_005")) {
				assertTrue(click(selenium, btnEditCancel),
						"Could not click the Cancel button;More details:"
								+ proData.toString(),selenium, ClassName, MethodName);
				return true;
			}
			if (proData.testCaseId.equals("TC_CP_004")) {
				// assertTrue(click(selenium,
				// btnSummaryEdit),"Could not click the Edit button;More details:"+
				// proData.toString(),selenium, ClassName, MethodName);
				// waitForPageLoad(selenium);btnInjEditSave1
				if(isElementPresent(selenium,btnInjEditSave1)){
				assertTrue(click(selenium, btnInjEditSave1),
						"Could not click the Save button;More details:",
						selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				}
				else{
					assertTrue(click(selenium, btnSaveProcedure1),
							"Could not click the Save button;More details:",
							selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				

			} else
				if(isElementPresent(selenium,btnSOSave))
				{
					assertTrue(click(selenium, btnChartEdit),
							"Could not click the Edit button;More details:"
									+ proData.toString(),selenium, ClassName, MethodName);
				}
				else
				{
					assertTrue(click(selenium, btnChartEdit),
							"Could not click the Edit button;More details:"
									+ proData.toString(),selenium, ClassName, MethodName);
				}
				
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * create ProblemList function to create Procedure
	 * @throws IOException 
	 * 
	 * @since Sep 28, 2012
	 */

	public boolean createProblemList(Selenium selenium,
			ChartPreVisitLib proData, String account) throws IOException {
		try {
			String date = "";
			waitForPageLoad(selenium);
			if (proData.testCaseId.equals("TC_QL_001")
					|| (proData.testCaseId.equals("TC_QL_002"))
					|| (proData.testCaseId.equals("TC_QL_003"))
					|| proData.testCaseId.equals("TC_CPL_050"))
				assertTrue(
						type(selenium, txtMedicatl, proData.quickList),
						"Could not type medical condition",selenium, ClassName, MethodName);
			if (!proData.testCaseId.equals("TC_CPL_047")) {
				assertTrue(
						type(selenium, txtMedicatl, proData.medicalCondition1),
						"Could not type medical condition",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if (account.equals(CAAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				date = DateFormat.format(cal.getTime());
				assertTrue(
						enterDate(selenium, txtOnset, date),
						"Could not enter the Admin on ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			} else {
				Calendar cal1 = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal1.getTime());
				assertTrue(
						enterDate(selenium, txtOnset, date),
						"Could not enter the Admin on ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium, ajxItem, proData.itemStatus);
			if (proData.testCaseId.equals("TC_CPL_002")
					|| proData.testCaseId.equals("TC_CPL_013")
					|| proData.testCaseId.equals("TC_QL_001")
					|| proData.testCaseId.equals("TC_QL_002")
					|| proData.testCaseId.equals("TC_CPL_020")
					|| proData.testCaseId.equals("TC_CPL_021")
					|| proData.testCaseId.equals("TC_CPL_022")
					|| proData.testCaseId.equals("TC_CPL_023")
					|| proData.testCaseId.equals("TC_CPL_024")
					|| proData.testCaseId.equals("TC_CPL_025")
					|| proData.testCaseId.equals("TC_CPL_026")
					|| proData.testCaseId.equals("TC_CPL_027")
					|| proData.testCaseId.equals("TC_CPL_028")
					|| proData.testCaseId.equals("TC_CPL_029")
					|| proData.testCaseId.equals("TC_CPL_030")
					|| proData.testCaseId.equals("TC_CPL_031")
					|| proData.testCaseId.equals("TC_CPL_032")
					|| proData.testCaseId.equals("TC_CPL_033")
					|| proData.testCaseId.equals("TC_CPL_034")
					|| proData.testCaseId.equals("TC_CPL_035")
					|| proData.testCaseId.equals("TC_CPL_036")
					|| proData.testCaseId.equals("TC_CPL_037")
					|| proData.testCaseId.equals("TC_CPL_038")
					|| proData.testCaseId.equals("TC_CPL_039")
					|| proData.testCaseId.equals("TC_CPL_040")
					|| proData.testCaseId.equals("TC_CPL_041")
					|| proData.testCaseId.equals("TC_CPL_044")) {
				waitForPageLoad(selenium);
				click(selenium, lnkProblemListShowMoreArrow);


				selectValueFromAjaxList(selenium, ajxlifeStage,
						proData.lifeStage);

				if (account.equals(CAAccount)) {
					assertTrue(
							enterDate(selenium, txtResolvedDate, date),
							"Could not enter resolved date ;More Details:"
									+ proData.toString(),selenium, ClassName, MethodName);
					assertTrue(
							type(selenium, txtcomment, proData.comment),
							"Could not enter the comment;More Details:"
									+ proData.toString(),selenium, ClassName, MethodName);
				} else
					assertTrue(
							enterDate(selenium, txtResolvedDate, date),
							"Could not enter resolved date ;More Details:"
									+ proData.toString(),selenium, ClassName, MethodName);
/*
				selectValueFromAjaxList(selenium, ajxCodeingSystem,
						proData.codingSystem);*/
				waitForPageLoad(selenium);
				if(isElementVisible(selenium,ajxdiagnosis))
				{
					clickAt(selenium,ajxdiagnosis,"");
					//proData.diagnosis=getText(selenium,tabTelephoneMethod);					
					selectValueFromAjaxList(selenium, ajxdiagnosis,
							proData.diagnosis);
					waitForPageLoad(selenium);
				}
				assertTrue(
						type(selenium, txtcomment, proData.comment),
						"Could not enter the comment;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			}
			if (proData.testCaseId.equals("TC_CPL_050")) {
				return true;
			}
			if (proData.testCaseId.equals("TC_CPL_004")) {
				assertTrue(click(selenium, btnCancelSummaryProblemList),
						"Could not click the Cancel button;More details:"
								+ proData.toString(),selenium, ClassName, MethodName);
				return true;
			}
			if (proData.testCaseId.equals("TC_CPL_006")) {
				assertTrue(click(selenium, btnCancelProblemListEdit),
						"Could not click the Cancel button;More details:"
								+ proData.toString(),selenium, ClassName, MethodName);
				return true;
			}

			if (proData.testCaseId.equals("TC_QL_001")
					|| (proData.testCaseId.equals("TC_QL_002") || (proData.testCaseId
							.equals("TC_QL_005"))))
				assertTrue(click(selenium, chkQuickList),
						"Could not click the Save Quick List check box;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			if (!proData.testCaseId.equals("TC_CPL_018")) {

				if(selenium.isVisible(btnAdd)){
					assertTrue(click(selenium, btnAdd),
							"Could not click the add button;More details:"
									+ proData.toString(),selenium, ClassName, MethodName);
				}else
					assertTrue(click(selenium, btnSave1),
							"Could not click the add button;More details:"
									+ proData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			} else {
				assertTrue(click(selenium, btnSaveProblemList),
						"Could not click the add button;More details:"
								+ proData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * create Diagnosis Codes function to create Diagnosis Codes
	 * 
	 * @throws IOException
	 * @since Sep 28, 2012
	 */

	public boolean createDiagnosisCodes(Selenium selenium,
			ChartPreVisitLib proData, String account) throws IOException {
		int count = 0;
		while (isElementPresent(selenium, ajxAssessmentSearch)) {

			selectValueFromAjaxList(selenium,ajxAssessmentSearch,proData.medicalCondition1);
			waitForPageLoad(selenium);
			selenium.fireEvent(ajxAssessmentSearch,"keydown");
			selenium.fireEvent(ajxAssessmentSearch,"keypress");                           
			selenium.fireEvent(ajxAssessmentSearch,"keyup");
			waitForPageLoad(selenium);
			click(selenium,"chartListItemTitle");
			waitForPageLoad(selenium);
			selenium.clickAt(ajxAssessmentSearch, "");
			selenium.keyPress(ajxAssessmentSearch, "\\9");


			if (isElementPresent(selenium, txtMedicatl)) {
				break;
			}
			count++;

			if (count > 20) {
				break;
			}
		}

		/*	assertTrue(deleteAllProblemList(selenium, proData), "Creation failed",
				selenium, ClassName, MethodName);
		waitForPageLoad(selenium);*/



		assertTrue(createProblemList(selenium, proData, account),
				"Creation failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(click(selenium, btnSign), "Could not click the sign button",
				selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    waitForPageLoad(selenium);
	    waitForPageLoad(selenium);
		if(selenium.isElementPresent(btnContinue)&&selenium.isVisible(btnContinue)){
		assertTrue(click(selenium, btnContinue), "Could not click the sign button",
				selenium, ClassName, MethodName);
		}
		
		waitForPageLoad(selenium);

		if (!isElementPresent(selenium, ajxBillToPayer)) {
			return false;
		}
		return true;
	}

	/**
	 * edit ProblemList function to create Procedure
	 * @throws IOException 
	 * 
	 * @since Sep 28, 2012
	 */

	public boolean editProblemList(Selenium selenium, ChartPreVisitLib proData,
			String account) throws IOException {
		try {
			String date = "";
			waitForPageLoad(selenium);
			click(selenium, lnkProblemListShowMoreArrow);
			assertTrue(
					selectValueFromAjaxList(selenium, txtMedicatl, proData.medicalCondition1),
					"Could not type medical condition",selenium, ClassName, MethodName);
			if (account.equals(CAAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				date = DateFormat.format(cal.getTime());
				assertTrue(
						enterDate(selenium, txtOnset, date),
						"Could not enter the Admin on ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			} else {
				Calendar cal1 = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal1.getTime());
				assertTrue(
						enterDate(selenium, txtOnset, date),
						"Could not enter the Admin on ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium, ajxItem, proData.itemStatus);

			selectValueFromAjaxList(selenium, ajxlifeStage, proData.lifeStage);

			if (account.equals(CAAccount)) {
				assertTrue(enterDate(selenium, txtResolvedDate, date),
						"Could not enter resolved date ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			} else
				assertTrue(enterDate(selenium, txtResolvedDate, date),
						"Could not enter resolved date ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
		/*	selectValueFromAjaxList(selenium, ajxCodeingSystem,
					proData.codingSystem);*/

			waitForPageLoad(selenium);
			if(isElementVisible(selenium,ajxdiagnosis))
			{
				selectValueFromAjaxList(selenium, ajxdiagnosis, proData.diagnosis);
			}
			waitForPageLoad(selenium);
			assertTrue(
					type(selenium, txtcomment, proData.comment),
					"Could not enter the comment;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);

			if(isElementPresent(selenium,btnSaveEditProblemList))
			{assertTrue(
					click(selenium, btnSaveEditProblemList),
					"Could not click the add button;More details:"
							+ proData.toString(),selenium, ClassName, MethodName);
				
							}
			else
				{assertTrue(
					click(selenium, btnChartEdit),
					"Could not click the add button;More details:"
							+ proData.toString(),selenium, ClassName, MethodName);}
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * deleteProblemListInEncounter function to delete Probelm List in Encounter
	 * page
	 * @throws IOException 
	 * 
	 * @since Oct 04, 2012
	 */
	public boolean deleteProblemListInEncounter(Selenium selenium,
			ChartPreVisitLib proData) throws IOException {
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
	 * deleteAllProblemList Function to delete All Existing Problem List
	 * @throws IOException 
	 * 
	 * @since Nov 05, 2012
	 */
	public boolean deleteAllProblemList(Selenium selenium,
			ChartPreVisitLib proData) throws IOException {
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
	 * unitTestProblemList function to create Procedure
	 * @throws IOException 
	 * 
	 * @since Oct 10, 2012
	 */

	public boolean unitTestProblemList(Selenium selenium,
			ChartPreVisitLibUnitTest proData) throws IOException {
		try {
			assertTrue(
					type(selenium, txtMedicatl, proData.medicalCondition),
					"Could not type medical condition",selenium, ClassName, MethodName);
			assertTrue(
					enterDate(selenium, txtOnset, proData.onsetDate),
					"Could not enter the Admin on ;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxItem, proData.itemStatus);
			assertTrue(click(selenium, lnkProblemListShowMore),
					"Could not on show more button",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxlifeStage, proData.lifeStage);
			assertTrue(
					enterDate(selenium, txtResolvedDate, proData.resDate),
					"Could not enter resolved date ;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxCodeingSystem,
					proData.codingSystem);
			selectValueFromAjaxList(selenium, ajxdiagnosis, proData.diagnosis);
			assertTrue(
					type(selenium, txtcomment, proData.comment),
					"Could not enter the comment;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					click(selenium, btnAdd),
					"Could not click the add button;More details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * createFamilyHistory function to create FamilyHistory
	 * @throws IOException 
	 * 
	 * @since Oct 04, 2012
	 */
	public boolean createFamilyHistory(Selenium selenium,
			ChartPreVisitLib historyData) throws IOException {
		try {
			assertTrue(
					type(selenium, ajxFamilyMedical, historyData.medical),
					"Could not enter the medical",selenium, ClassName, MethodName);

			selectValueFromAjaxList(selenium, ajxFamilyrelation,
					historyData.relation);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxCodeingSystem,
					historyData.codingSystem);
			waitForPageLoad(selenium);

			assertTrue(
					type(selenium, txtAgeOfOnset, historyData.age),
					"Could not enter the age;More Details:"
							+ historyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxdiagnosis,
					historyData.diagnosis);
			waitForPageLoad(selenium);

			if (!(historyData.testCaseId.equals("TC_CFM_001")
					|| historyData.testCaseId.equals("TC_CFM_012") || historyData.testCaseId
					.equals("TC_CFM_025"))) {
				// assertTrue(click(selenium,"//div[3]/div[2]/div/div[2]"),"Could not click the show more Details link");
				// waitForPageLoad(selenium);

				assertTrue(click(selenium, lnkFamilkShowMoreDeatils),
						"Could not on show more button",selenium, ClassName, MethodName);

//				assertTrue(getValue(selenium, ajxlifeStage)
//						.equalsIgnoreCase(historyData.lifeStage),
//						"Life stage Auto-select is failed");
				if (historyData.cause.equals("yes")) {
					assertTrue(click(selenium, chkCasue),
							"Could not click the check box",selenium, ClassName, MethodName);
					assertTrue(
							type(selenium, txtAgeat, historyData.ageAtDeath),
							"Could not enter the age at death",selenium, ClassName, MethodName);
				}
				
				selectValueFromAjaxList(selenium, ajxlifeStage,
						historyData.lifeStage);
				assertTrue(
						type(selenium, txtTreatMent, historyData.treatment),
						"Could not enter the treatment;More Details:"
								+ historyData.toString(),selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtComment, historyData.comment),
						"Could not enter the comments;More Details:"
								+ historyData.toString(),selenium, ClassName, MethodName);
				
				if (historyData.saveList.equals("yes")) {
					assertTrue(click(selenium, chkQuickList),
							"Could not click the check box;More Details:"
									+ historyData.toString(),selenium, ClassName, MethodName);
				}
			}

			if (historyData.testCaseId.equals("TC_CFM_006")) {
				assertTrue(click(selenium, btnCancelFamilyHistory),
						"Could not click the Cancel button;More details:"
								+ historyData.toString(),selenium, ClassName, MethodName);
				return true;
			}

			if (historyData.testCaseId.equals("TC_CFM_011")) {
				assertTrue(click(selenium, btnSave),
						"Could not click the save button;More details:"
								+ historyData.toString(),selenium, ClassName, MethodName);
				return true;
			}

		
			assertTrue(
					click(selenium, btnAdd),
					"Could not click add button;More Details"
							+ historyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * createFamilyHistory function to create FamilyHistory
	 * @throws IOException 
	 * 
	 * @since Oct 04, 2012
	 */
	public boolean verifyFamilyHistory(Selenium selenium,
			ChartPreVisitLib historyData) throws IOException {
		try {

			assertTrue(
					type(selenium, ajxFamilyMedical, historyData.medical),
					"Could not enter the medical",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxFamilyrelation,
					historyData.relation);

			selectValueFromAjaxList(selenium, ajxCodeingSystem,
					historyData.codingSystem);

			assertTrue(
					type(selenium, txtAgeOfOnset, historyData.age),
					"Could not enter the age;More Details:"
							+ historyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxdiagnosis,
					historyData.diagnosis);

			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * verifyCollapseView function to verifyCollapseView
	 * 
	 * @throws IOException
	 * 
	 * @since Oct 17, 2012
	 */

	public boolean verifyCollapseViewForFamily(Selenium selenium,
			ChartPreVisitLib historyData) throws IOException {

		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(historyData.relation), ""
				+ "Family History Relation Not Present", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(historyData.medical), ""
				+ "Family History Medical Not Present", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(historyData.age), ""
				+ "Family History Age Not Present", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(historyData.comment), ""
				+ "Family History Comment Not Present", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		return true;
	}

	/**
	 * verifyExpandView function to verifyExpandView
	 * 
	 * @throws IOException
	 * @since Oct 17, 2012
	 */

	public boolean verifyExpandViewForFamily(Selenium selenium,
			ChartPreVisitLib historyData) throws IOException {
		if(historyData.testCaseId.equals("TC_CFM_019")) {
			assertTrue(
					click(selenium,lblFamilyHistoryExpandView),
					"Colud not click the arrow;More Details:"
							+ historyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			else
			{
				assertTrue(
						click(selenium,lblProCollapseView),
						"Colud not click the arrow;More Details:"
								+ historyData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}


		assertTrue(selenium.isTextPresent(historyData.lifeStage), ""
				+ "Family History LifeStage Not Present", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(historyData.diagnosis), ""
				+ "Family History Diagnosis Not Present", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		if (historyData.cause.equals("yes")) {

			assertTrue(selenium.isTextPresent(historyData.ageAtDeath), ""
					+ "Family History ageAtDeath Not Present", selenium,
					ClassName, MethodName);
			waitForPageLoad(selenium);
		}

		assertTrue(selenium.isTextPresent(historyData.treatment), ""
				+ "Family History treatment Not Present", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		return true;
	}

	/**
	 * editFamilyHistory function to edit FamilyHistory
	 * 
	 * @throws IOException
	 * 
	 * @since Oct 17, 2012
	 */
	public boolean editFamilyHistory(Selenium selenium,
			ChartPreVisitLib historyData) throws IOException {
		try {
			assertTrue(
					type(selenium, ajxFamilyMedical, historyData.medical),
					"Could not enter the medical",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxFamilyrelation,
					historyData.relation);

			selectValueFromAjaxList(selenium, ajxCodeingSystem,
					historyData.codingSystem);

			assertTrue(
					type(selenium, txtAgeOfOnset, historyData.age),
					"Could not enter the age;More Details:"
							+ historyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxdiagnosis,
					historyData.diagnosis);

			waitForPageLoad(selenium);

			selectValueFromAjaxList(selenium, ajxlifeStage,
					historyData.lifeStage);

			if (historyData.cause.equals("yes")) {
				if (getValue(selenium, chkCasue).equals("on")) {
					assertTrue(
							type(selenium, txtAgeat, historyData.ageAtDeath),
							"Could not enter the age at death",selenium, ClassName, MethodName);
				} else {
					assertTrue(click(selenium, chkShowAll),
							"Could not click the check box",selenium, ClassName, MethodName);
					assertTrue(
							type(selenium, txtAgeat, historyData.ageAtDeath),
							"Could not enter the age at death",selenium, ClassName, MethodName);
				}
			}
			if (historyData.cause.equals("no")) {
				if (getValue(selenium, chkShowAll).equals("on")) {
					assertTrue(click(selenium, chkShowAll),
							"Could not click the check box",selenium, ClassName, MethodName);
				}
			}
			assertTrue(
					type(selenium, txtTreatMent, historyData.treatment),
					"Could not enter the treatment;More Details:"
							+ historyData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtComment, historyData.comment),
					"Could not enter the comments;More Details:"
							+ historyData.toString(),selenium, ClassName, MethodName);
			if (historyData.saveList.equals("yes")) {
				assertTrue(click(selenium, chkQuickList),
						"Could not click the check box;More Details:"
								+ historyData.toString(),selenium, ClassName, MethodName);
			}

			waitForPageLoad(selenium);
			if (historyData.testCaseId.equals("TC_CFM_004")) {
				assertTrue(click(selenium, btnEditSave1),
						"Could not click edit button;More Details", selenium,
						ClassName, MethodName);
			} else
				assertTrue(click(selenium, btnEditSave1),
						"Could not click Edit button;More Details"
								+ historyData.toString(),selenium, ClassName, MethodName);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * deleteFamilyHistory function to delete FamilyHistory
	 * @throws IOException 
	 * 
	 * @since Oct 04, 2012
	 */
	public boolean deleteFamilyHistory(Selenium selenium,
			ChartPreVisitLib historyData) throws IOException {
		boolean historyDeleted = true;
		int historyCount = 0;
		try {

			waitForElement(selenium, btnDFamilyDelete, WAIT_TIME);
			while ((Integer) selenium.getXpathCount(btnDFamilyDelete) > 0) {
				historyCount = (Integer) selenium
						.getXpathCount(btnDFamilyDelete);
				assertTrue(click(selenium, btnDFamilyDelete),"Could not Click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, txtdeleteReason,
								historyData.userAccount),
						"Could not enter the reason",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkDeleteReason),"Could not click on Continue Button" ,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				
				/*
				 * assertTrue(type(selenium,txtdeleteReason,historyData.
				 * reason),"Could not type the reason");
				 * waitForPageLoad(selenium);
				 * assertTrue(click(selenium,"//div[3]/span/button"));
				 */
				waitForPageLoad(selenium);
				if (historyCount == (Integer) selenium
						.getXpathCount(btnDFamilyDelete)) {
					historyDeleted = false;
					break;
				}
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return historyDeleted;
	}
	/**
	 * deleteOrders function to delete Orders
	 * @throws IOException 
	 * 
	 * @since Nov 15, 2012
	 */
	public boolean deleteOrders(Selenium selenium, ChartPreVisitLib orderData) throws IOException {
		boolean orderDeleted = true;
		int proCount = 0;
		try {
			waitForElement(selenium, lnkLabDelete, WAIT_TIME);
			while ((Integer) selenium.getXpathCount(lnkLabDelete) > 0) {
				proCount = (Integer) selenium.getXpathCount(lnkLabDelete);
				assertTrue(click(selenium, lnkLabDelete),"Could not click on Delete Lab link",selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnDeletebutton),"Could not click on Delete Button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						click(selenium, btnYes),
						"Could not click Yes button;More Details:"
								+ orderData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (proCount == (Integer) selenium.getXpathCount(lnkLabDelete)) {
					Assert.fail("Could not delete the entry");
					orderDeleted = false;
					break;
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return orderDeleted;
	}

	/**
	 * deleteAssessment function to delete All existing assessment
	 * @throws IOException 
	 * 
	 * @since Nov 30, 2012
	 */
	public boolean deleteAssessment(Selenium selenium,
			ChartPreVisitLib orderData) throws IOException {
		boolean assessmentDeleted = true;
		int proCount = 0;
		try {
			waitForElement(selenium, lblAssessmentDetails, WAIT_TIME);
			while ((Integer) selenium.getXpathCount(lblAssessmentDetails) > 0) {
				proCount = (Integer) selenium
						.getXpathCount(lblAssessmentDetails);
				assertTrue(click(selenium, lblAssessmentDetails),"Could not click on Assessment link",selenium, ClassName, MethodName);
				assertTrue(click(selenium, "//a[@id='delete']/span"),"Could not click on Delete Link",selenium, ClassName, MethodName);
				if (proCount == (Integer) selenium
						.getXpathCount(lblAssessmentDetails)) {
					Assert.fail("Could not delete the entry");
					assessmentDeleted = false;
					break;
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return assessmentDeleted;
	}

	/**
	 * deleteFamilyHistory function to delete FamilyHistory
	 * @throws IOException 
	 * 
	 * @since Oct 04, 2012
	 */
	public boolean deleteFamilyHistoryForEncounter(Selenium selenium,
			ChartPreVisitLib historyData) throws IOException {
		boolean historyDeleted = true;
		int historyCount = 0;
		try {

			waitForElement(selenium, lblEncounterFamilyDetails, WAIT_TIME);
			while ((Integer) selenium.getXpathCount(lblEncounterFamilyDetails) > 0) {
				historyCount = (Integer) selenium
						.getXpathCount(lblEncounterFamilyDetails);
				assertTrue(click(selenium, lblEncounterFamilyDetails),"Could not click the link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnCosignDelete),
						"Could not click the delete button;More Details:"
								+ historyData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnYes),
						"Could not click Yes button;More Details:"
								+ historyData.toString(),selenium, ClassName, MethodName);
				/*
				 * assertTrue(type(selenium,txtdeleteReason,historyData.
				 * reason),"Could not type the reason");
				 * waitForPageLoad(selenium);
				 * assertTrue(click(selenium,"//div[3]/span/button"));
				 */
				waitForPageLoad(selenium);
				if (historyCount == (Integer) selenium
						.getXpathCount(lblEncounterFamilyDetails)) {
					historyDeleted = false;
					break;
				}
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return historyDeleted;
	}

	/**
	 * deleteSocialHistoryForEncounter function to delete FamilyHistory
	 * @throws IOException 
	 * 
	 * @since Oct 04, 2012
	 */
	public boolean deleteSocialHistoryForEncounter(Selenium selenium,
			ChartPreVisitLib historyData) throws IOException {
		boolean historyDeleted = true;
		int historyCount = 0;
		try {
			//waitForElement(selenium, lblEnSocialDetails, WAIT_TIME);
			while ((Integer) selenium.getXpathCount(lblEnSocialDetails) > 0) {
				historyCount = (Integer) selenium
						.getXpathCount(lblEnSocialDetails);
				assertTrue(click(selenium, lblEnSocialDetails),"Could not click the link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnDeletebutton),
						"Could not click the delete button;More Details:"
								+ historyData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				 assertTrue(type(selenium,txtdeleteReason,historyData.
				reason),"Could not type the reason",selenium,ClassName,MethodName);
				 waitForPageLoad(selenium);
				 assertTrue(click(selenium, btnChooseDelete),
							"Could not click Yes button;More Details:"
									+ historyData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (historyCount == (Integer) selenium
						.getXpathCount(lblEnSocialDetails)) {
					historyDeleted = false;
					break;
				}
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return historyDeleted;
	}

	/**
	 * unitTestForFamilyHistort function to unit Test For FamilyHistort
	 * @throws IOException 
	 * 
	 * @since Oct 10, 2012
	 */
	public boolean unitTestForFamilyHistory(Selenium selenium,
			ChartPreVisitLibUnitTest historyData) throws IOException {
		try {
			assertTrue(
					type(selenium, ajxFamilyMedical, historyData.medical),
					"Could not enter the medical ",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxFamilyrelation,
					historyData.relation);
			selectValueFromAjaxList(selenium, ajxCodeingSystem,
					historyData.codingSystem);
			assertTrue(
					type(selenium, txtAgeOfOnset, historyData.age),
					"Could not enter the age;More Details:"
							+ historyData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxdiagnosis,
					historyData.diagnosis);
			waitForPageLoad(selenium);
			// assertTrue(click(selenium,"//div[3]/div[2]/div/div[2]"),"Could not click the show more Details link");
			assertTrue(click(selenium, lnkFamilkShowMoreDeatils),
					"Could not click the show more Details link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxlifeStage,
					historyData.lifeStage);
			if (historyData.cause.equals("yes")) {
				waitForPageLoad(selenium);
				assertTrue(click(selenium, chkCasue),
						"Could not click the check box",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtAgeat, historyData.ageAtDeath),
						"Could not enter the age at death",selenium, ClassName, MethodName);
			}
			assertTrue(
					type(selenium, txtTreatMent, historyData.treatment),
					"Could not enter the treatment;More Details:"
							+ historyData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtComment, historyData.comment),
					"Could not enter the comments;More Details:"
							+ historyData.toString(),selenium, ClassName, MethodName);
			if (historyData.saveList.equals("yes")) {
				assertTrue(click(selenium, chkQuickList),
						"Could not click the check box;More Details:"
								+ historyData.toString(),selenium, ClassName, MethodName);
			}

			assertTrue(
					click(selenium, btnAdd),
					"Could not click add button;More Details"
							+ historyData.toString(),selenium, ClassName, MethodName);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * familyHistoryUnitTestForMaxLength function to family History UnitTest For
	 * MaxLength
	 * @throws IOException 
	 * 
	 * @since Oct 10, 2012
	 */
	public boolean familyHistoryUnitTestForMaxLength(Selenium selenium,
			ChartPreVisitLibUnitTest historyData) throws IOException {
		try {
			assertTrue(
					type(selenium, ajxFamilyMedical, historyData.medical),
					"Could not enter the medical ",selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkFamilkShowMoreDeatils),
					"Could not click the show more Details link",selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtTreatMent, historyData.treatment),
					"Could not enter the treatment;More Details:"
							+ historyData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtComment, historyData.comment),
					"Could not enter the comments;More Details:"
							+ historyData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					click(selenium, btnAdd),
					"Could not click add button;More Details"
							+ historyData.toString(),selenium, ClassName, MethodName);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * deleteMedication function to delete Medication
	 * @throws IOException 
	 * 
	 * @since Oct 10, 2012
	 */
	public boolean deleteMedication(Selenium selenium,
			ChartPreVisitLib medicationData) throws IOException {
		boolean medicationDeleted = true;
		int medicationCount = 0;
		try {
			waitForElement(selenium, btnDeleteMedication, WAIT_TIME);
			while ((Integer) selenium.getXpathCount(btnDeleteMedication) > 0) {
				medicationCount = (Integer) selenium
						.getXpathCount(btnDeleteMedication);
				assertTrue(click(selenium, btnDeleteMedication),"Could not Click",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, txtdeleteReason,
								medicationData.userAccount),
						"Could not enter the reason",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkDeleteReason),"Could not click on Continue Button" ,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				if (medicationCount == (Integer) selenium
						.getXpathCount(btnDeleteMedication)) {
					medicationDeleted = false;
					break;
				}
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return medicationDeleted;
	}


	/**
	 * deleteEncounterMedication function to delete Medication in Encounter
	 * @throws IOException 
	 * 
	 * @since Oct 23, 2012
	 */
	public boolean deleteEncounterMedication(Selenium selenium) throws IOException {
		boolean medicationDeleted = true;
		try {
			if (isElementPresent(selenium, lblMedsDetails)) {
				assertTrue(click(selenium, lblMedsDetails),
						"Could not select the medication in encounter",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnDeletebutton),
						"Could not click delete button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnYes),
						"Could not click yes button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return medicationDeleted;
	}


	/**
	 * Allergy As Stop reason
	 * @throws IOException 
	 */


	public boolean AllergyAsStopReason(Selenium selenium,
			ChartPreVisitLib allergyData, String account) throws IOException {
		try {
			waitForPageLoad(selenium);
			assertTrue(click(selenium, ajxAllergyReaction),
						"Could not on show more button",selenium, ClassName, MethodName);			
				waitForPageLoad(selenium);
				assertTrue(click(selenium, chkReaction),
						"Could not on show more button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkClose),
						"Could not on show more button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				assertTrue(	selectValueFromAjaxList(selenium, ajxSeverity,
						allergyData.severity),
						"Could not enter the comment;More Details:"
								+ allergyData.toString(),selenium, ClassName, MethodName);

				assertTrue(selectValueFromAjaxList(selenium, ajxStatus, allergyData.status),
						"Could not enter the comment;More Details:"
								+ allergyData.toString(),selenium, ClassName, MethodName);
			
				assertTrue(
						type(selenium, txtcomment, allergyData.comment),
						"Could not enter the comment;More Details:"
								+ allergyData.toString(),selenium, ClassName, MethodName);
			
			
				waitForPageLoad(selenium);
	
				assertTrue(click(selenium, btnAllergy),
						"Could not click the save button;More details:"
								+ allergyData.toString(),selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * createMedication function to cretae Medication
	 * 
	 * @throws IOException
	 * @since Oct 10, 2012
	 */

	public boolean createMedication(Selenium selenium,
			ChartPreVisitLib medicationData, String account) throws IOException {
		try {
			String date = "";
			if (account.equals(CAAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				date = DateFormat.format(cal.getTime());
				selectValueFromAjaxList(selenium, ajxSearchMedication,
						medicationData.prescribeCa);
			} else {
				Calendar cal1 = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal1.getTime());
				selectValueFromAjaxList(selenium, ajxSearchMedication,
						medicationData.prescribe);
			}

			//			selenium.type(ajxSearchMedication, "a");
			//			
			//			selenium.typeKeys(ajxSearchMedication, "a");
			//			
			/*
			 * if(isElementPresent(selenium,"css=div.item.item-selected")){
			 * assertTrue(click(selenium,"css=div.item.item-selected"));
			 * }
			 */
			if (medicationData.freeText.equals("Yes")) {
				assertTrue(click(selenium, chkFreetextBox),
						"Could not click the check box;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtFreeBox, medicationData.direction),
						"Could not enter the text;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
			}
			if (medicationData.increaseDecreaseDose.equals("Yes")) {
				assertTrue(click(selenium, chkInDeDosecheckBox),
						"Could not click the check box;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxInRefillMethod,
						medicationData.refillMethod);
				if (account.equals(CAAccount)) {
					type(selenium, ajxInRefillQuantity,
							medicationData.refillQuantityCa);
				} else
					type(selenium, ajxInRefillQuantity,
							medicationData.refillQuantity);
				selectValueFromAjaxList(selenium, ajxInRefilUnit,
						medicationData.refillUnit);

				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxInRefillRoute,
							medicationData.refillRouteCa);
					selectValueFromAjaxList(selenium, ajxInRefillFrequency,
							medicationData.refillFrequencyCa);
				} else {
					selectValueFromAjaxList(selenium, ajxInRefillRoute,
							medicationData.refillRoute);
					selectValueFromAjaxList(selenium, ajxInRefillFrequency,
							medicationData.refillFrequency);
				}

				selectValueFromAjaxList(selenium, ajxInRefillDuration,
						medicationData.refillduration);
				selectValueFromAjaxList(selenium, ajxRefilUsage,
						medicationData.refillUsage);
				selectValueFromAjaxList(selenium, ajxInRefillUsage1,
						medicationData.refillUsage1);
				selectValueFromAjaxList(selenium, txtDuration,
						medicationData.duration);
				selectValueFromAjaxList(selenium, ajxInRefillUsage2,
						medicationData.refillUsage2);

				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajaxInRefillUsage3,
							medicationData.refillUsage3Ca);
				} else
					selectValueFromAjaxList(selenium, ajaxInRefillUsage3,
							medicationData.refillUsage3);
				selectValueFromAjaxList(selenium, ajxInRefillUsage,
						medicationData.refillUsage4);
			}
			if (medicationData.multipleDirection.equals("Yes")) {
				assertTrue(click(selenium, chkMultipleCheckBox),
						"Could not click the check box;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxMDRefilMethod,
						medicationData.refillMethod);
				if (account.equals(CAAccount)) {
					type(selenium, ajxMDRefillQuantity,
							medicationData.refillQuantityCa);
				} else
					type(selenium, ajxMDRefillQuantity,
							medicationData.refillQuantity);
				selectValueFromAjaxList(selenium, ajxMDRefillUnit,
						medicationData.refillUnit);

				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxMDRefillRoute,
							medicationData.refillRouteCa);
					selectValueFromAjaxList(selenium, ajxMDRefillFrequency,
							medicationData.refillFrequencyCa);
				} else {
					selectValueFromAjaxList(selenium, ajxMDRefillFrequency,
							medicationData.refillFrequency);
					selectValueFromAjaxList(selenium, ajxMDRefillRoute,
							medicationData.refillRoute);
				}
				selectValueFromAjaxList(selenium, ajxMDRefillDuration,
						medicationData.refillduration);
				selectValueFromAjaxList(selenium, ajxMDRefillUsage,
						medicationData.refillUsage);
				selectValueFromAjaxList(selenium, ajxMDMethod,
						medicationData.method);
				if (account.equals(CAAccount)) {
					type(selenium, ajxMDQuantity,
							medicationData.quantityCa);
				} else
					type(selenium, ajxMDQuantity,
							medicationData.quality);

				selectValueFromAjaxList(selenium, ajxMDUnit,
						medicationData.unit);
				selectValueFromAjaxList(selenium, ajxMDRoute,
						medicationData.route);
				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxMDFrequency,
							medicationData.frequencyCa);
				} else
					selectValueFromAjaxList(selenium, ajxMDFrequency,
							medicationData.frequency);
				// selectValueFromAjaxList(selenium,"refillFrequencySuggestBox1suggestBox",medicationData.frequency);
				selectValueFromAjaxList(selenium, ajxMDDuration,
						medicationData.duration);
				selectValueFromAjaxList(selenium, ajxMDUsage,
						medicationData.usage);
			} else if (!medicationData.freeText.equals("Yes")
					&& !medicationData.increaseDecreaseDose.equals("Yes")
					&& !medicationData.multipleDirection.equals("Yes")) {
				selectValueFromAjaxList(selenium, ajxMethod,
						medicationData.refillMethod);
				waitForPageLoad(selenium);
				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxQuantity,
							medicationData.refillQuantityCa);
				} else
					selectValueFromAjaxList(selenium, ajxQuantity,
							medicationData.refillQuantity);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxUnit,
						medicationData.refillUnit);
				waitForPageLoad(selenium);

				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxRoute,
							medicationData.refillRouteCa);
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium, ajxFrequency,
							medicationData.refillFrequencyCa);
				} else {
					selectValueFromAjaxList(selenium, ajxRoute,
							medicationData.refillRoute);
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium, ajxFrequency,
							medicationData.refillFrequency);
				}

				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxDuration,
						medicationData.refillduration);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxRefillUsage,
						medicationData.refillUsage);
				waitForPageLoad(selenium);
			}

			assertTrue(enterDate(selenium, txtStartOn, date),
					"Could not enter the Admin on ;More Details:"
							+ medicationData.toString(),selenium, ClassName, MethodName);

			waitForPageLoad(selenium);
			selenium.focus(txtSupply);
			assertTrue(
					type(selenium, txtSupply, medicationData.supply),
					"Could not enter the supply;More Details:"
							+ medicationData.toString(),selenium, ClassName, MethodName);

			waitForPageLoad(selenium);
			if ((medicationData.testCaseId.equals("TC_PSM_006"))
					|| (medicationData.testCaseId.equals("TC_PSM_017"))
					|| (medicationData.testCaseId.equals("TC_PSM_018"))
					|| medicationData.testCaseId.equals("TC_QLM_001")
					|| medicationData.testCaseId.equals("TC_QLM_002")
					|| (medicationData.testCaseId.equals("TC_PSM_007"))
					|| (medicationData.testCaseId.equals("TC_PSM_001"))
					|| (medicationData.testCaseId.equals("TC_PSM_020"))
					|| (medicationData.testCaseId.equals("TC_PSM_021"))
					|| (medicationData.testCaseId.equals("TC_PSM_022"))
					|| (medicationData.testCaseId.equals("TC_PSM_026"))
					|| (medicationData.testCaseId.equals("TC_PSM_027"))
					|| (medicationData.testCaseId.equals("TC_PSM_027"))
					|| (medicationData.testCaseId.equals("TC_PSM_028"))
					|| (medicationData.testCaseId.equals("TC_PSM_029"))
					|| (medicationData.testCaseId.equals("TC_PSM_030"))
					|| (medicationData.testCaseId.equals("TC_PSM_031"))
					|| (medicationData.testCaseId.equals("TC_PSM_032"))
					|| (medicationData.testCaseId.equals("TC_PSM_033"))
					|| (medicationData.testCaseId.equals("TC_PSM_034"))
					|| (medicationData.testCaseId.equals("TC_PSM_035"))
					|| (medicationData.testCaseId.equals("TC_PSM_036"))
					|| (medicationData.testCaseId.equals("TC_PSM_037"))
					|| (medicationData.testCaseId.equals("TC_PSM_038"))
					|| (medicationData.testCaseId.equals("TC_PSM_039"))) {
				assertTrue(click(selenium, lnkMedsShowMore),
						"Could not click the show more link;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium, txtPrescribedOn, date),
						"Could not enter last refill",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtRefill, medicationData.refill),
						"Could not enter the refill;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtPrescribedBy,
								medicationData.prescribedby),
								"Could not enter the date;More Details:"
										+ medicationData.toString(),selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium, txtRefilledOn, date),
						"Could not enter last refill",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtComment, medicationData.comment),
						"Could not enter the commend;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
			}
			if (medicationData.testCaseId.equals("TC_QLM_001")
					|| medicationData.testCaseId.equals("TC_QLM_002")) {
				assertTrue(click(selenium, chkSaveListBox),
						"Could not click the Save to Quick List button;More details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
			}

			if (!medicationData.testCaseId.equals("TC_PSM_020")) {
				assertTrue(click(selenium, btnAdd),
						"Could not click the add button;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				// Check for the Dialog box (Proceed Anyway)
				if (isElementPresent(selenium, btnCancelButton)) {
					assertTrue(click(selenium, btnCancelButton),
							"Could not Click Proceed Anyway button"
									+ medicationData.toString(), selenium,
									ClassName, MethodName);
					waitForPageLoad(selenium);
				}

			} else {

				assertTrue(click(selenium, btnSave),
						"Could not click the add button;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}

			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();

		}
		return false;
	}

	/**
     * createEncounterMedication function to cretae Encounter Medication
     * 
      * @throws IOException
     * @since Oct 23, 2012
     */

	 public boolean createEncounterMedication(Selenium selenium,
             ChartPreVisitLib medicationData, String account) throws IOException {
String date = "";
try {
             if (account.equals(CAAccount)) {
            		assertTrue(    selectValueFromAjaxList(selenium, ajxSearchMedication,
                                                             medicationData.prescribeCa), "Could not select"
                                                                     + medicationData.toString(),selenium, ClassName, MethodName);
             } else
            		assertTrue( selectValueFromAjaxList(selenium, ajxSearchMedication,
                                                             medicationData.prescribe), "Could not select"
                                                                     + medicationData.toString(),selenium, ClassName, MethodName);

             if (medicationData.freeText.equals("Yes")) {
                             assertTrue(click(selenium, chkFreetextBox),
                                                             "Could not click the check box;More Details:"
                                                                                             + medicationData.toString(),selenium, ClassName, MethodName);
                             assertTrue(
 type(selenium, txtFreeBox, medicationData.direction),
                                                             "Could not enter the text;More Details:"
                                                                                             + medicationData.toString(),selenium, ClassName, MethodName);
             }
             if (medicationData.increaseDecreaseDose.equals("Yes")) {
                             assertTrue(click(selenium, chkInDeDosecheckBox),
                                                             "Could not click the check box;More Details:"
                                                                                             + medicationData.toString(),selenium, ClassName, MethodName);
                             assertTrue( selectValueFromAjaxList(selenium, ajxInRefillMethod,
                                                             medicationData.refillMethod),
                                                             "Could not Select"
                                                                     + medicationData.toString(),selenium, ClassName, MethodName);
                             if (account.equals(CAAccount)) {              
                                             medicationData.refillQuantityCa="1";
                                             assertTrue( type(selenium, ajxInRefillQuantity,                         //type and change declaration
                                                                             medicationData.refillQuantityCa),"Could not type" + medicationData.toString(),selenium, ClassName, MethodName);
                             } else
                             {
                                             medicationData.refillQuantityCa="1";
                                             assertTrue(type(selenium, ajxInRefillQuantity,
                                                                             medicationData.refillQuantity),"Could not type" + medicationData.toString(),selenium, ClassName, MethodName);
                             }
                                             
                             assertTrue( selectValueFromAjaxList(selenium, ajxInRefilUnit,
                                                             medicationData.refillUnit),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             assertTrue(selectValueFromAjaxList(selenium, ajxInRefillRoute,
                                                             medicationData.refillRoute),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             if (account.equals(CAAccount)) {
                            	 assertTrue(selectValueFromAjaxList(selenium, ajxInRefillFrequency,
                                                                             medicationData.refillFrequencyCa),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             } else
                            	 assertTrue(selectValueFromAjaxList(selenium, ajxInRefillFrequency,
                                                                             medicationData.refillFrequency),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             assertTrue(type(selenium, txtDuration,medicationData.duration),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             assertTrue( selectValueFromAjaxList(selenium, ajxInRefillUsage,medicationData.refillUsage),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             assertTrue(selectValueFromAjaxList(selenium, ajxRefilUsage,  medicationData.refillUsage4),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);                                   
                             
                             medicationData.refillQuantityCa="1";
                             assertTrue( type(selenium, ajxinRefillQuantiti3,medicationData.refillQuantity),"Could not type;",selenium, ClassName, MethodName);
                             assertTrue(type(selenium, txtDuration1,medicationData.duration),"Could not type the duration;More Details;",selenium, ClassName, MethodName);
             
                             /*selectValueFromAjaxList(selenium, ajxInRefillUsage1,
                                                             medicationData.refillUsage1);*/
             
                             
                             assertTrue(type(selenium,txtUntillReach,medicationData.duration),"Could not type the duration;More Details;",selenium, ClassName, MethodName);
                                                                             
                                                                                             if (account.equals(CAAccount)) {
                                                                                                 assertTrue(  selectValueFromAjaxList(selenium, ajaxInRefillUsage3,medicationData.refillUsage3Ca),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                                                                                             } else
                                                                                                 assertTrue(selectValueFromAjaxList(selenium, ajaxInRefillUsage3,medicationData.refillUsage3),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);

                                                                                             
                                                                                             
                             /*selectValueFromAjaxList(selenium, ajxInRefillDuration,                            //REfelection duration
                                                             medicationData.refillduration);
                             */
                             
/*                           
                             selectValueFromAjaxList(selenium, ajxInRefillUsage2,
                                                             medicationData.refillUsage2);*/

                             if (account.equals(CAAccount)) {
                            	 assertTrue(   selectValueFromAjaxList(selenium, ajaxInRefillUsage3,   medicationData.refillUsage3Ca),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             } else
                            	 assertTrue(selectValueFromAjaxList(selenium, ajaxInRefillUsage3,
                                                                             medicationData.refillUsage3),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);

                             
                             

             }
             if (medicationData.multipleDirection.equals("Yes")) {
                             assertTrue(click(selenium, chkMultipleCheckBox),
                                                             "Could not click the check box;More Details:"
                                                                                             + medicationData.toString(),selenium, ClassName, MethodName);
                             assertTrue(  selectValueFromAjaxList(selenium, ajxMDRefilMethod,medicationData.refillMethod),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             if (account.equals(CAAccount)) {
                                             medicationData.refillQuantityCa="1";
                                             assertTrue( type(selenium, ajxMDRefillQuantity,
                                                                             medicationData.refillQuantityCa),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             } else
                                             medicationData.refillQuantity="1";
                             assertTrue(type(selenium, ajxMDRefillQuantity,
                                                                             medicationData.refillQuantity),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             assertTrue( selectValueFromAjaxList(selenium, ajxMDRefillRoute,
                                                             medicationData.refillRoute),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             assertTrue( selectValueFromAjaxList(selenium, ajxMDRefillUnit,
                                                             medicationData.refillUnit),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);

                             if (account.equals(CAAccount)) {
                                 assertTrue(selectValueFromAjaxList(selenium, ajxMDRefillFrequency,
                                                                             medicationData.refillFrequencyCa),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             } else
                                 assertTrue( selectValueFromAjaxList(selenium, ajxMDRefillFrequency,
                                                                             medicationData.refillFrequency),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                                 assertTrue(  selectValueFromAjaxList(selenium, ajxMDRefillDuration,
                                                             medicationData.refillduration),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                                 assertTrue(selectValueFromAjaxList(selenium, ajxMDRefillUsage,
                                                             medicationData.refillUsage),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                                 assertTrue(selectValueFromAjaxList(selenium, ajxMDMethod,
                                                             medicationData.method),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             if (account.equals(CAAccount)) {
                                             medicationData.quantityCa="1";
                                             assertTrue(  type(selenium, ajxMDQuantity,
                                                                             medicationData.quantityCa),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             } else
                                             medicationData.quality="1";
                             assertTrue( type(selenium, ajxMDQuantity,
                                                                             medicationData.quality),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);

                             assertTrue(  selectValueFromAjaxList(selenium, ajxMDUnit,
                                                             medicationData.unit),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             assertTrue(selectValueFromAjaxList(selenium, ajxMDRoute,
                                                             medicationData.route),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             if (account.equals(CAAccount)) {
                                 assertTrue(  selectValueFromAjaxList(selenium, ajxMDFrequency,
                                                                             medicationData.frequencyCa),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             } else
                                 assertTrue( selectValueFromAjaxList(selenium, ajxMDFrequency,
                                                                             medicationData.frequency),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             // selectValueFromAjaxList(selenium,"refillFrequencySuggestBox1suggestBox",medicationData.frequency);
                                 assertTrue(  selectValueFromAjaxList(selenium, ajxMDDuration,
                                                             medicationData.refillduration),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                                 assertTrue(  selectValueFromAjaxList(selenium, ajxMDUsage,
                                                             medicationData.usage),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
             } else if (!medicationData.freeText.equals("Yes")
                                             && !medicationData.increaseDecreaseDose.equals("Yes")
                                             && !medicationData.multipleDirection.equals("Yes")) {
                             selectValueFromAjaxList(selenium, ajxMethod,
                                                             medicationData.refillMethod);
                             if (account.equals(CAAccount)) {
                                             medicationData.refillQuantityCa="1";
                                             assertTrue(  type(selenium, ajxQuantity,                       //type comment
                                                                             medicationData.refillQuantityCa),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             } else
                                             medicationData.refillQuantity="1";
                             assertTrue(  type(selenium, ajxQuantity,
                                                                             medicationData.refillQuantity),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             // selectValueFromAjaxList(selenium,ajxQuantity,medicationData.refillQuantity);
                             waitForPageLoad(selenium);
                            /* if (isElementPresent(selenium, "//div[11]/div/div/div/div/div")) {
                                             click(selenium, "//div[11]/div/div/div/div/div");
                             }
                             selectValueFromAjaxList(selenium, ajxUnit,
                                                             medicationData.refillUnit);
                             waitForPageLoad(selenium);
                             if (isElementPresent(selenium, "//div[11]/div/div/div/div/div")) {
                                             click(selenium, "//div[11]/div/div/div/div/div");
                             }
                             selectValueFromAjaxList(selenium, ajxRoute,
                                                             medicationData.refillRoute);
                             if (isElementPresent(selenium, "//div[11]/div/div/div/div/div")) {
                                             click(selenium, "//div[11]/div/div/div/div/div");
                             }*/

                             if (account.equals(CAAccount)) {
                                 assertTrue(     selectValueFromAjaxList(selenium, ajxFrequency,
                                                                             medicationData.refillFrequencyCa),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             } else
                                 assertTrue( selectValueFromAjaxList(selenium, ajxFrequency,
                                                                             medicationData.refillFrequency),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);

                             assertTrue( selectValueFromAjaxList(selenium, ajxUnit,
                                     "Tablet(s)"),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             if(account.equals(CAAccount)){
                            	 assertTrue( selectValueFromAjaxList(selenium, ajxRoute,medicationData.refillRouteCa),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             }
                             else{
                             assertTrue( selectValueFromAjaxList(selenium, ajxRoute,
                                     "Epidural"),"Could not select" + medicationData.toString(),selenium, ClassName, MethodName);
                             }
                             
                             // selectValueFromAjaxList(selenium,ajxFrequency,medicationData.refillFrequency
                             // );
      /*                       waitForPageLoad(selenium);
                             if (isElementPresent(selenium, "//div[11]/div/div/div/div/div")) {
                                             click(selenium, "//div[11]/div/div/div/div/div");
                             }
                             selectValueFromAjaxList(selenium, ajxDuration,
                                                             medicationData.refillduration);
                             waitForPageLoad(selenium);
                             if (isElementPresent(selenium, "//div[11]/div/div/div/div/div")) {
                                             click(selenium, "//div[11]/div/div/div/div/div");
                             }
                             selectValueFromAjaxList(selenium, ajxRefillUsage,
                                                             medicationData.refillUsage);
                             waitForPageLoad(selenium);
                             if (isElementPresent(selenium, "//div[11]/div/div/div/div/div")) {
                                             click(selenium, "//div[11]/div/div/div/div/div");
                             }*/
             }

             if (account.equals(CAAccount)) {
                             Calendar cal = Calendar.getInstance();
                             SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
                             date = DateFormat.format(cal.getTime());
                             assertTrue(enterDate(selenium, txtStartOn, date),
                                                             "Could not enter the Admin on ;More Details:"
                                                                                             + medicationData.toString(),selenium, ClassName, MethodName);
             } else {
                             Calendar cal1 = Calendar.getInstance();
                             SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
                             date = DateFormat.format(cal1.getTime());
                             assertTrue(enterDate(selenium, txtStartOn, date),
                                                             "Could not enter the Admin on ;More Details:"
                                                                                             + medicationData.toString(),selenium, ClassName, MethodName);
             }

             // assertTrue(enterDate(selenium,"css=div.controlsNoMargin.width125 > input.gwt-DateBox",medicationData.startDate),"Could not enter the Date;More Details:"+medicationData.toString(),selenium, ClassName, MethodName);
             assertTrue(
                                             type(selenium, txtSupply, medicationData.supply),
                                             "Could not enter the supply;More Details:"
                                                                             + medicationData.toString(),selenium, ClassName, MethodName);
             if (medicationData.testCaseId.equals("TC_PSM_006")
                                             || (medicationData.testCaseId.equals("TC_PSM_017"))
                                             || (medicationData.testCaseId.equals("TC_PSM_007"))
                                             || (medicationData.testCaseId.equals("TC_PSM_001"))
                                             || (medicationData.testCaseId.equals("TC_PSM_020"))
                                             || (medicationData.testCaseId.equals("TC_PSM_021"))
                                             || (medicationData.testCaseId.equals("TC_PSM_022"))
                                             || (medicationData.testCaseId.equals("TC_PSM_026"))
                                             || (medicationData.testCaseId.equals("TC_PSM_027"))
                                             || (medicationData.testCaseId.equals("TC_PSM_028"))
                                             || (medicationData.testCaseId.equals("TC_PSM_029"))
                                             || (medicationData.testCaseId.equals("TC_PSM_030"))
                                             || (medicationData.testCaseId.equals("TC_PSM_031"))
                                             || (medicationData.testCaseId.equals("TC_PSM_032"))
                                             || (medicationData.testCaseId.equals("TC_PSM_033"))
                                             || (medicationData.testCaseId.equals("TC_PSM_034"))
                                             || (medicationData.testCaseId.equals("TC_PSM_035"))
                                             || (medicationData.testCaseId.equals("TC_PSM_036"))
                                             || (medicationData.testCaseId.equals("TC_PSM_037"))
                                             || (medicationData.testCaseId.equals("TC_PSM_038"))
                                             || (medicationData.testCaseId.equals("TC_PSM_039"))) {
                             assertTrue(click(selenium, lnkMedsShowMore),
                                                             "Could not click the show more link;More Details:"
                                                                                             + medicationData.toString(),selenium, ClassName, MethodName);
                             waitForPageLoad(selenium);
                             if (account.equals(CAAccount)) {
                                             assertTrue(
                                                                             enterDate(selenium, txtPrescribedOn, date),
                                                                             "Could not enter last refill",selenium, ClassName, MethodName);
                                             assertTrue(
                                                                             type(selenium, txtRefill, medicationData.refill),
                                                                             "Could not enter the refill;More Details:"
                                                                                                             + medicationData.toString(),selenium, ClassName, MethodName);
                             } else
                                             assertTrue(
                                                                             enterDate(selenium, txtPrescribedOn, date),
                                                                             "Could not enter last refill",selenium, ClassName, MethodName);
                             assertTrue(
                                                             type(selenium, txtRefill, medicationData.refill),
                                                             "Could not enter the refill;More Details:"
                                                                                             + medicationData.toString(),selenium, ClassName, MethodName);
                             assertTrue(
                                                             type(selenium, txtPrescribedBy,
                                                                                             medicationData.prescribedby),
                                                                                             "Could not enter the date;More Details:"
                                                                                                                             + medicationData.toString(),selenium, ClassName, MethodName);
                             if (account.equals(CAAccount)) {
                                             assertTrue(enterDate(selenium, txtRefilledOn, date),
                                                                             "Could not enter last refill",selenium, ClassName, MethodName);
                             } else
                                             assertTrue(enterDate(selenium, txtRefilledOn, date),
                                                                             "Could not enter last refill",selenium, ClassName, MethodName);

                             assertTrue(type(selenium, txtComment, medicationData.comment),
                                                             "Could not enter the commend;More Details:"
                                                                                             + medicationData.toString(),selenium, ClassName, MethodName);
             }
             if (medicationData.testCaseId.equals("TC_PSM_011")) {
                             assertTrue(click(selenium, btnCancelMedication),
                                                             "Could not click the cancel button;More Details:"
                                                                                             + medicationData.toString(),selenium, ClassName, MethodName);
                             waitForPageLoad(selenium);
             } else
                             assertTrue(click(selenium, btnAdd),
                                                             "Could not click the add button;More Details:"
                                                                                             + medicationData.toString(),selenium, ClassName, MethodName);
             waitForPageLoad(selenium);

             // Check for the Dialog box (Proceed Anyway)

             if (isElementPresent(selenium, btnCancelButton)) {
                             assertTrue(click(selenium, btnCancelButton),
                                                             "Could not Click Proceed Anyway button"
                                                                                             + medicationData.toString(), selenium,
                                                                                             ClassName, MethodName);
                             waitForPageLoad(selenium);
             }

} catch (RuntimeException e) {
             e.printStackTrace();

}
return true;
}





	/**
	 * verifyCollapseViewForMedication function to verify Collapse View For
	 * Medication
	 * 
	 * @since Oct 25, 2012
	 */

	public boolean verifyCollapseViewForMedication(Selenium selenium,
			ChartPreVisitLib medicationData, String account) {
		if (account.equals(CAAccount)) {

			if (!selenium.isTextPresent(
					medicationData.prescribeCa.trim().toUpperCase()) ){
				return false;
			}
			if (!selenium.isTextPresent(
							medicationData.refillQuantityCa.trim()	)) {
				return false;
			}
			if (!selenium.isTextPresent(
							medicationData.refillFrequencyCa.trim())) {
				return false;
			}
		} else {
			if (!selenium.isTextPresent(
					medicationData.prescribeName.trim())) {
				return false;
			}
			if (!selenium.isTextPresent(
					medicationData.refillQuantity.trim().toLowerCase(
							new java.util.Locale("en", "US")))) {
				return false;
			}
			if (!selenium.isTextPresent(
					medicationData.refillFrequency.trim().toLowerCase(
							new java.util.Locale("en", "US")))) {
				return false;
			}
		}
		if (!selenium.isTextPresent(
				medicationData.refillMethod.trim())) {
			return false;
		}

		if (!selenium.isTextPresent(
				medicationData.refillUnit.trim())) {
			return false;
		}
		if (!selenium.isTextPresent(
				medicationData.refillRoute.trim())) {
			return false;
		}

		/*if (!selenium.isTextPresent(
				medicationData.refillduration.trim())) {
			return false;
		}*/
		if (!selenium.isTextPresent(
				medicationData.refillUsage.trim())) {
			return false;
		}

		return true;
	}
	/**
	 * verifyExpandViewForMedication function to verify Expand View For
	 * Medication
	 * @throws IOException 
	 * 
	 * @since Oct 25, 2012
	 */
	public boolean verifyExpandViewForMedication(Selenium selenium,
			ChartPreVisitLib medicationData, String account) throws IOException {
		assertTrue(click(selenium, lblMedsCollapseDetails),
				"Could not click on Expand button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		System.out.println(getText(selenium, lblFamilyExpanView));
		if (!selenium.isTextPresent(
				medicationData.refill.trim())) {
			return false;
		}
		return true;
	}

	/**
	 * editEncounterMedication function to edit Encounter Medication
	 * @throws IOException 
	 * 
	 * @since Oct 25, 2012
	 */

	public boolean editEncounterMedication(Selenium selenium,
			ChartPreVisitLib medicationData, String account) throws IOException {
		String date = "";
		if (account.equals(CAAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = DateFormat.format(cal.getTime());

		} else {
			Calendar cal1 = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat.format(cal1.getTime());

		}
		try {
			waitForPageLoad(selenium);
			if (medicationData.testCaseId.equals("TC_PSM_007")
					|| medicationData.testCaseId.equals("TC_PSM_022")) {
				medicationData.workSheetName = "EditMedication";
				medicationData.testCaseId = "TC_PSEM_001";
				medicationData.fetchChartPreVisitTestData();
			} else if (medicationData.testCaseId.equals("TC_PSM_008")
					|| medicationData.testCaseId.equals("TC_PSM_023")) {
				medicationData.workSheetName = "EditMedication";
				medicationData.testCaseId = "TC_PSEM_002";
				medicationData.fetchChartPreVisitTestData();
			} else if (medicationData.testCaseId.equals("TC_PSM_009")
					|| medicationData.testCaseId.equals("TC_PSM_024")) {
				medicationData.workSheetName = "EditMedication";
				medicationData.testCaseId = "TC_PSEM_003";
				medicationData.fetchChartPreVisitTestData();
			} else if (medicationData.testCaseId.equals("TC_PSM_010")
					|| medicationData.testCaseId.equals("TC_PSM_025")) {
				medicationData.workSheetName = "EditMedication";
				medicationData.testCaseId = "TC_PSEM_004";
				medicationData.fetchChartPreVisitTestData();
			}

			if (medicationData.freeText.equals("Yes")) {


				assertTrue(
						type(selenium, txtFreeBox, medicationData.direction),
						"Could not enter the text;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
			}
			if (medicationData.increaseDecreaseDose.equals("Yes")) {

				selectValueFromAjaxList(selenium, ajxInRefillMethod,
						medicationData.refillMethod);
				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxInRefillQuantity,
							medicationData.refillQuantityCa);
				} else
					selectValueFromAjaxList(selenium, ajxInRefillQuantity,
							medicationData.refillQuantity);
				selectValueFromAjaxList(selenium, ajxInRefilUnit,
						medicationData.refillUnit);
				selectValueFromAjaxList(selenium, ajxInRefillRoute,
						medicationData.refillRoute);
				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxInRefillFrequency,
							medicationData.refillFrequencyCa);
				} else
					selectValueFromAjaxList(selenium, ajxInRefillFrequency,
							medicationData.refillFrequency);

				selectValueFromAjaxList(selenium, ajxInRefillDuration,
						medicationData.refillduration);
				selectValueFromAjaxList(selenium, ajxInRefillUsage,
						medicationData.refillUsage);
				selectValueFromAjaxList(selenium, ajxInRefillUsage1,
						medicationData.refillUsage1);
				selectValueFromAjaxList(selenium, txtDuration,
						medicationData.duration);
				selectValueFromAjaxList(selenium, ajxInRefillUsage2,
						medicationData.refillUsage2);

				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajaxInRefillUsage3,
							medicationData.refillUsage3Ca);
				} else
					selectValueFromAjaxList(selenium, ajaxInRefillUsage3,
							medicationData.refillUsage3);

				selectValueFromAjaxList(selenium, ajxInUsage,
						medicationData.duration);
				selectValueFromAjaxList(selenium, ajxRefilUsage,
						medicationData.refillUsage4);
			}
			if (medicationData.multipleDirection.equals("Yes")) {

				selectValueFromAjaxList(selenium, ajxMDRefilMethod,
						medicationData.refillMethod);
				if (account.equals(CAAccount)) {
					medicationData.refillQuantityCa="1";
					type(selenium, ajxMDRefillQuantity,
							medicationData.refillQuantityCa);
				} else
					medicationData.refillQuantity="1";
					type(selenium, ajxMDRefillQuantity,
							medicationData.refillQuantity);
				selectValueFromAjaxList(selenium, ajxMDRefillUnit,
						medicationData.refillUnit);
				selectValueFromAjaxList(selenium, ajxMDRefillRoute,
						medicationData.refillRoute);
				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxMDRefillFrequency,
							medicationData.refillFrequencyCa);
				} else
					selectValueFromAjaxList(selenium, ajxMDRefillFrequency,
							medicationData.refillFrequency);
				selectValueFromAjaxList(selenium, ajxMDRefillDuration,
						medicationData.refillduration);
				selectValueFromAjaxList(selenium, ajxMDRefillUsage,
						medicationData.refillUsage);
				selectValueFromAjaxList(selenium, ajxMDMethod,
						medicationData.method);
				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxMDQuantity,
							medicationData.quantityCa);
				} else
					selectValueFromAjaxList(selenium, ajxMDQuantity,
							medicationData.quality);

				selectValueFromAjaxList(selenium, ajxMDUnit,
						medicationData.unit);
				selectValueFromAjaxList(selenium, ajxMDRoute,
						medicationData.route);
				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxMDFrequency,
							medicationData.frequencyCa);
				} else
					selectValueFromAjaxList(selenium, ajxMDFrequency,
							medicationData.frequency);
				// selectValueFromAjaxList(selenium,"refillFrequencySuggestBox1suggestBox",medicationData.frequency);

				selectValueFromAjaxList(selenium, ajxMDDuration,
						medicationData.refillduration);
				selectValueFromAjaxList(selenium, ajxMDUsage,
						medicationData.usage);
			} else if (!medicationData.freeText.equals("Yes")
					&& !medicationData.increaseDecreaseDose.equals("Yes")
					&& !medicationData.multipleDirection.equals("Yes")) {
				selectValueFromAjaxList(selenium, ajxMethod,
						medicationData.refillMethod);
				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxQuantity,
							medicationData.refillQuantityCa);
				} else
					selectValueFromAjaxList(selenium, ajxQuantity,
							medicationData.refillQuantity);

				selectValueFromAjaxList(selenium, ajxUnit,
						medicationData.refillUnit);
				selectValueFromAjaxList(selenium, ajxRoute,
						medicationData.refillRoute);
				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxFrequency,
							medicationData.refillFrequencyCa);
				} else
					selectValueFromAjaxList(selenium, ajxFrequency,
							medicationData.refillFrequency);

				// selectValueFromAjaxList(selenium,ajxFrequency,medicationData.refillFrequency
				// );
				selectValueFromAjaxList(selenium, ajxDuration,
						medicationData.refillduration);
				selectValueFromAjaxList(selenium, ajxRefillUsage,
						medicationData.refillUsage);
			}

			assertTrue(enterDate(selenium, txtStartOn, date),
					"Could not enter the Admin on ;More Details:"
							+ medicationData.toString(),selenium, ClassName, MethodName);

			// assertTrue(enterDate(selenium,"css=div.controlsNoMargin.width125 > input.gwt-DateBox",medicationData.startDate),"Could not enter the Date;More Details:"+medicationData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtSupply, medicationData.supply),
					"Could not enter the supply;More Details:"
							+ medicationData.toString(),selenium, ClassName, MethodName);
			if (medicationData.testCaseId.equals("TC_PSEM_001")) {
				if (getText(selenium, lnkMedsShowMore).equalsIgnoreCase(
						"Show more details"))
					assertTrue(click(selenium, lnkMedsShowMore),
							"Could not click the show more link;More Details:"
									+ medicationData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				assertTrue(enterDate(selenium, txtPrescribedOn, date),
						"Could not enter last refill",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtRefill, medicationData.refill),
						"Could not enter the refill;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtPrescribedBy,
								medicationData.prescribedby),
								"Could not enter the date;More Details:"
										+ medicationData.toString(),selenium, ClassName, MethodName);

				assertTrue(enterDate(selenium, txtRefilledOn, date),
						"Could not enter last refill",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtComment, medicationData.comment),
						"Could not enter the commend;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnInjEditSave1),
					"Could not click the add button;More Details:"
							+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

		} catch (RuntimeException e) {
			e.printStackTrace();

		}
		return true;
	}
	/**
	 * editMedication function to edit Medication
	 * @throws IOException 
	 * 
	 * @since Oct 10, 2012
	 */

	public boolean editMedication(Selenium selenium,
			ChartPreVisitLib medicationData, String account) throws IOException {
		String date = "";
		try {

			if (medicationData.freeText.equals("Yes")) {
				assertTrue(click(selenium, chkFreetextBox),
						"Could not click the check box;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtFreeBox, medicationData.direction),
						"Could not enter the text;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
			}
			if (medicationData.increaseDecreaseDose.equals("Yes")) {
				assertTrue(click(selenium, chkInDeDosecheckBox),
						"Could not click the check box;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxInRefillMethod,
						medicationData.refillMethod);
				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxInRefillQuantity,
							medicationData.refillQuantityCa);
				} else
					selectValueFromAjaxList(selenium, ajxInRefillQuantity,
							medicationData.refillQuantity);
				selectValueFromAjaxList(selenium, ajxInRefilUnit,
						medicationData.refillUnit);
				selectValueFromAjaxList(selenium, ajxInRefillRoute,
						medicationData.refillRoute);
				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxInRefillFrequency,
							medicationData.refillFrequencyCa);
				} else
					selectValueFromAjaxList(selenium, ajxInRefillFrequency,
							medicationData.refillFrequency);
				selectValueFromAjaxList(selenium, ajxInRefillDuration,
						medicationData.refillduration);
				selectValueFromAjaxList(selenium, ajxRefilUsage,
						medicationData.refillUsage);
				selectValueFromAjaxList(selenium, ajxInRefillUsage1,
						medicationData.refillUsage1);
				selectValueFromAjaxList(selenium, txtDuration,
						medicationData.duration);
				selectValueFromAjaxList(selenium, ajxInRefillUsage2,
						medicationData.refillUsage2);

				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajaxInRefillUsage3,
							medicationData.refillUsage3Ca);
				} else
					selectValueFromAjaxList(selenium, ajaxInRefillUsage3,
							medicationData.refillUsage3);
				selectValueFromAjaxList(selenium, ajxInRefillUsage,
						medicationData.refillUsage4);
			}
			if (medicationData.multipleDirection.equals("Yes")) {
				assertTrue(click(selenium, chkMultipleCheckBox),
						"Could not click the check box;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxMDRefilMethod,
						medicationData.refillMethod);
				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxMDRefillQuantity,
							medicationData.refillQuantityCa);
				} else
					selectValueFromAjaxList(selenium, ajxMDRefillQuantity,
							medicationData.refillQuantity);
				selectValueFromAjaxList(selenium, ajxMDRefillUnit,
						medicationData.refillUnit);
				selectValueFromAjaxList(selenium, ajxMDRefillRoute,
						medicationData.refillRoute);
				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxMDRefillFrequency,
							medicationData.refillFrequencyCa);
				} else
					selectValueFromAjaxList(selenium, ajxMDRefillFrequency,
							medicationData.refillFrequency);
				selectValueFromAjaxList(selenium, ajxMDRefillDuration,
						medicationData.refillduration);
				selectValueFromAjaxList(selenium, ajxMDRefillUsage,
						medicationData.refillUsage);
				selectValueFromAjaxList(selenium, ajxMDMethod,
						medicationData.method);
				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxMDQuantity,
							medicationData.quantityCa);
				} else
					selectValueFromAjaxList(selenium, ajxMDQuantity,
							medicationData.quality);

				selectValueFromAjaxList(selenium, ajxMDUnit,
						medicationData.unit);
				selectValueFromAjaxList(selenium, ajxMDRoute,
						medicationData.route);
				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxMDFrequency,
							medicationData.frequencyCa);
				} else
					selectValueFromAjaxList(selenium, ajxMDFrequency,
							medicationData.frequency);
				// selectValueFromAjaxList(selenium,"refillFrequencySuggestBox1suggestBox",medicationData.frequency);
				selectValueFromAjaxList(selenium, ajxMDDuration,
						medicationData.duration);
				selectValueFromAjaxList(selenium, ajxMDUsage,
						medicationData.usage);
			} else if (!medicationData.freeText.equals("Yes")
					&& !medicationData.increaseDecreaseDose.equals("Yes")
					&& !medicationData.multipleDirection.equals("Yes")) {
				selectValueFromAjaxList(selenium, ajxMethod,
						medicationData.refillMethod);
				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxQuantity,
							medicationData.refillQuantityCa);
				} else
					selectValueFromAjaxList(selenium, ajxQuantity,
							medicationData.refillQuantity);

				selectValueFromAjaxList(selenium, ajxUnit,
						medicationData.refillUnit);
				selectValueFromAjaxList(selenium, ajxRoute,
						medicationData.refillRoute);
				if (account.equals(CAAccount)) {
					selectValueFromAjaxList(selenium, ajxFrequency,
							medicationData.refillFrequencyCa);
				} else
					selectValueFromAjaxList(selenium, ajxFrequency,
							medicationData.refillFrequency);

				// selectValueFromAjaxList(selenium,ajxFrequency,medicationData.refillFrequency
				// );
				selectValueFromAjaxList(selenium, ajxDuration,
						medicationData.refillduration);
				selectValueFromAjaxList(selenium, ajxRefillUsage,
						medicationData.refillUsage);
			}

			if (account.equals(CAAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				date = DateFormat.format(cal.getTime());

			} else {
				Calendar cal1 = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal1.getTime());

			}

			assertTrue(enterDate(selenium, txtStartOn, date),
					"Could not enter the Admin on ;More Details:"
							+ medicationData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtSupply, medicationData.supply),
					"Could not enter the supply;More Details:"
							+ medicationData.toString(),selenium, ClassName, MethodName);
			if (medicationData.testCaseId.equals("TC_PSM_001")) {
				assertTrue(click(selenium, lnkMedsShowMore),
						"Could not click the show more link;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium, txtPrescribedOn, date),
						"Could not enter last refill",selenium, ClassName, MethodName);

				assertTrue(
						type(selenium, txtRefill, medicationData.refill),
						"Could not enter the refill;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtPrescribedBy,
								medicationData.prescribedby),
								"Could not enter the date;More Details:"
										+ medicationData.toString(),selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium, txtRefilledOn, date),
						"Could not enter last refill",selenium, ClassName, MethodName);

				assertTrue(
						type(selenium, txtComment, medicationData.comment),
						"Could not enter the commend;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnMedicationEditSave),
					"Could not click the add button;More Details:"
							+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();

		}
		return false;
	}


	/**
	 * deleteProblemListInEncounter function to delete Probelm List in Encounter
	 * page
	 * @throws IOException 
	 * 
	 * @since june 13, 2014
	 * 	 */
	public boolean deleteProbleforMedRecon(Selenium selenium,
			ChartPreVisitLib proData) throws IOException {
		boolean problemDeleted = true;
		int problemCount = 0;
		try {			
			while (selenium.isElementPresent(btnDeleteExternalProvider)) {


				assertTrue(click(selenium, btnDeleteExternalProvider),
						"Could not click the delete button;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						click(selenium, btnYes),
						"Could not click Yes button;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				if(!isElementPresent(selenium,btnDeleteExternalProvider))
				{
					break;
				}

			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return problemDeleted;
	}

	/**
	 * unitTestForMedication function to unit Test For Medication
	 * @throws IOException 
	 * 
	 * @since Oct 11, 2012
	 */

	public boolean unitTestForMedication(Selenium selenium,
			ChartPreVisitLibUnitTest medicationData, String account) throws IOException {
		try {
			assertTrue(
					type(selenium, ajxSearchMedication,
							medicationData.prescribe),
							"Could not enter the Prescribe;More Details"
									+ medicationData.toString(),selenium, ClassName, MethodName);
			if (medicationData.freeText.equals("Yes")) {
				assertTrue(click(selenium, chkFreetextBox),
						"Could not click the check box;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtFreeBox, medicationData.direction),
						"Could not enter the text;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
			}
			if (medicationData.increaseDecreaseDose.equals("Yes")) {
				assertTrue(click(selenium, chkInDeDosecheckBox),
						"Could not click the check box;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxInRefillMethod,
						medicationData.refillMethod);
				selectValueFromAjaxList(selenium, ajxInRefillQuantity,
						medicationData.refillQuantity);
				selectValueFromAjaxList(selenium, ajxInRefilUnit,
						medicationData.refillUnit);
				selectValueFromAjaxList(selenium, ajxInRefillRoute,
						medicationData.refillRoute);
				selectValueFromAjaxList(selenium, ajxInRefillFrequency,
						medicationData.refillFrequency);
				selectValueFromAjaxList(selenium, ajxRefilUsage,
						medicationData.refillUsage);
				selectValueFromAjaxList(selenium, ajxInRefillUsage1,
						medicationData.refillUsage1);
				selectValueFromAjaxList(selenium, txtDuration,
						medicationData.duration);
				selectValueFromAjaxList(selenium, ajxInRefillUsage1,
						medicationData.refillUsage2);
				selectValueFromAjaxList(selenium, ajxInRefillUsage2,
						medicationData.refillUsage3);
				selectValueFromAjaxList(selenium, ajaxInRefillUsage3,
						medicationData.refillUsage4);
			}
			if (medicationData.multipleDirection.equals("Yes")) {
				assertTrue(click(selenium, chkMultipleCheckBox),
						"Could not click the check box;More Details:"
								+ medicationData.toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxMDRefilMethod,
						medicationData.refillMethod);
				selectValueFromAjaxList(selenium, ajxMDRefillQuantity,
						medicationData.refillQuantity);
				selectValueFromAjaxList(selenium, ajxMDRefillUnit,
						medicationData.refillUnit);
				selectValueFromAjaxList(selenium, ajxMDRefillFrequency,
						medicationData.refillFrequency);
				selectValueFromAjaxList(selenium, ajxMDRefillDuration,
						medicationData.refillduration);
				selectValueFromAjaxList(selenium, ajxMDRefillUsage,
						medicationData.refillUsage);
				selectValueFromAjaxList(selenium, ajxMDMethod,
						medicationData.method);
				selectValueFromAjaxList(selenium, ajxMDQuantity,
						medicationData.quality);
				selectValueFromAjaxList(selenium, ajxMDUnit,
						medicationData.unit);
				selectValueFromAjaxList(selenium, ajxMDRoute,
						medicationData.route);
				selectValueFromAjaxList(selenium, ajxMDFrequency,
						medicationData.frequency);
				selectValueFromAjaxList(selenium, ajxMDDuration,
						medicationData.duration);
				selectValueFromAjaxList(selenium, ajxMDUsage,
						medicationData.usage);
			} else if (!medicationData.freeText.equals("Yes")
					&& !medicationData.increaseDecreaseDose.equals("Yes")
					&& !medicationData.multipleDirection.equals("Yes")) {
				selectValueFromAjaxList(selenium, ajxMethod,
						medicationData.refillMethod);
				selectValueFromAjaxList(selenium, ajxQuantity,
						medicationData.refillQuantity);
				selectValueFromAjaxList(selenium, ajxUnit,
						medicationData.refillUnit);
				selectValueFromAjaxList(selenium, ajxRoute,
						medicationData.refillRoute);
				selectValueFromAjaxList(selenium, ajxFrequency,
						medicationData.refillFrequency);
				selectValueFromAjaxList(selenium, ajxDuration,
						medicationData.refillduration);
				selectValueFromAjaxList(selenium, ajxRefillUsage,
						medicationData.refillUsage);
			}
			if (account.equals(CAAccount)) {
				assertTrue(
						enterDate(selenium, txtStartOn,
								medicationData.startDateCa),
								"Could not enter the Date;More Details:"
										+ medicationData.toString(),selenium, ClassName, MethodName);
			} else
				assertTrue(
						enterDate(selenium, txtStartOn,
								medicationData.startDate),
								"Could not enter the Date;More Details:"
										+ medicationData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtSupply, medicationData.supply),
					"Could not enter the supply;More Details:"
							+ medicationData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkMedsShowMore),
					"Could not click the show more link;More Details:"
							+ medicationData.toString(),selenium, ClassName, MethodName);
			if (account.equals(CAAccount)) {
				assertTrue(
						enterDate(selenium, txtPrescribedOn,
								medicationData.prescribeOnCa),
								"Could not enter the Date;More Details:"
										+ medicationData.toString(),selenium, ClassName, MethodName);
			} else
				assertTrue(
						enterDate(selenium, txtPrescribedOn,
								medicationData.prescribeOn),
								"Could not enter the Date;More Details:"
										+ medicationData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtRefill, medicationData.refill),
					"Could not enter the refill;More Details:"
							+ medicationData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtPrescribedBy, medicationData.prescribedby),
					"Could not enter the date;More Details:"
							+ medicationData.toString(),selenium, ClassName, MethodName);

			if (account.equals(CAAccount)) {
				assertTrue(
						enterDate(selenium, txtRefilledOn,
								medicationData.lastRefillCa),
								"Could not enter the Date;More Details:"
										+ medicationData.toString(),selenium, ClassName, MethodName);
			} else
				assertTrue(
						enterDate(selenium, txtRefilledOn,
								medicationData.lastRefill),
								"Could not enter the Date;More Details:"
										+ medicationData.toString(),selenium, ClassName, MethodName);

			assertTrue(
					type(selenium, txtComment, medicationData.comment),
					"Could not enter the commend;More Details:"
							+ medicationData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnAdd),
					"Could not click the add button;More Details:"
							+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * switchrole Function to switch role
	 * 
	 * @since Oct 12, 2012
	 */

	/*
	 * public boolean switchrole(Selenium selenium, ChartPreVisitLib
	 * historyData) { try { assertTrue(isElementPresent(selenium,
	 * lnkTopMenu),"Could not fine the link;More Details:"+
	 * historyData.toString(),selenium, ClassName, MethodName); assertTrue(click(selenium,
	 * lnkTopMenu),"Could not click the top Menu Header;More Details:"+
	 * historyData.toString(),selenium, ClassName, MethodName); waitForPageLoad(selenium); //
	 * assertTrue(click
	 * (selenium,lblEncounterData),"Could noy click the switch role;More Details:"
	 * +historyData.toString(),selenium, ClassName, MethodName); assertTrue(click(selenium,
	 * "switchRoleAction"),"Could not click the switch role;More Details:"+
	 * historyData.toString(),selenium, ClassName, MethodName); selectValueFromAjaxList(selenium, show,
	 * historyData.switchRole); click(selenium, "//div[7]/div/div/div/div/div");
	 * waitForPageLoad(selenium); assertTrue(click(selenium,
	 * txtdeleteReason),"Could not click the select button;More details:"+
	 * historyData.toString(),selenium, ClassName, MethodName); waitForPageLoad(selenium); return true; } catch
	 * (RuntimeException e) { e.printStackTrace(); } return false; }
	 */

	/**
	 * switchrole Function to switch role
	 * @throws IOException 
	 * 
	 * @since Oct 12, 2012
	 */

	public boolean switchroleSecondTime(Selenium selenium,
			ChartPreVisitLib historyData) throws IOException {
		try {
			assertTrue(
					isElementPresent(selenium, lnkTopMenu),
					"Could not fine the link;More Details:"
							+ historyData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkTopMenu),
					"Could not click the top Menu Header;More Details:"
							+ historyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			// assertTrue(click(selenium,lblEncounterData),"Could noy click the switch role;More Details:"+historyData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, "switchRoleAction"),
					"Could not click the switch role;More Details:"
							+ historyData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxRxProvider,
					historyData.switchRole);
			click(selenium, "//body/div[7]/div/div/div/div/div");
			waitForPageLoad(selenium);
			assertTrue(click(selenium, txtdeleteReason),
					"Could not click the select button;More details:"
							+ historyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnErrorClose))
			{
				click(selenium,btnErrorClose);
			}
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean createSocialHistory(Selenium selenium,
			ChartPreVisitLib proData) throws IOException {
		try {
			selectValueFromAjaxList(selenium, ajxType, proData.type);

		//	selectValueFromAjaxList(selenium, ajxStatus, proData.status);
			if (proData.testCaseId.equals("TC_CSH_010")){
				
			assertTrue(type(selenium,
					ajxOtherType,proData.other),"Could not enter the other type;More Details:",selenium,ClassName,MethodName);
			}
			
			
			
			if (proData.testCaseId.equals("TC_CSH_002")
					|| proData.testCaseId.equals("TC_CSH_003")
					|| proData.testCaseId.equals("TC_CPL_005")
					|| proData.testCaseId.equals("TC_CSH_013")
					|| proData.testCaseId.equals("TC_CSH_014")
					|| proData.testCaseId.equals("TC_CSH_015")
					|| proData.testCaseId.equals("TC_CSH_016")
					|| proData.testCaseId.equals("TC_CSH_017")
					|| proData.testCaseId.equals("TC_CSH_018")
					|| proData.testCaseId.equals("TC_CSH_019")
					|| proData.testCaseId.equals("TC_CSH_020")
					|| proData.testCaseId.equals("TC_CSH_021")
					|| proData.testCaseId.equals("TC_CSH_022")
					|| proData.testCaseId.equals("TC_CSH_023")
					|| proData.testCaseId.equals("TC_CSH_024")
					|| proData.testCaseId.equals("TC_CSH_025")
					|| proData.testCaseId.equals("TC_CSH_026")
					|| proData.testCaseId.equals("TC_CSH_027")
					|| proData.testCaseId.equals("TC_CSH_028")
					|| proData.testCaseId.equals("TC_CSH_029")
					|| proData.testCaseId.equals("TC_CSH_030")
					|| proData.testCaseId.equals("TC_CSH_031")
					|| proData.testCaseId.equals("TC_CSH_032")) {
				waitForPageLoad(selenium);
				assertTrue(click(selenium,  lnkShowMoreSocial),
						"Could not on show more button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, txtSocialQuickList, proData.item),
						"Could not enter the item;More Details:"
						,selenium,ClassName,MethodName);
				assertTrue(
						type(selenium, txtDetailsNumBox, proData.detailsNum),
						"Could not enter the details Num ;More Details:"
						,selenium,ClassName,MethodName);
			        assertTrue(
						type(selenium, txtDetailsSmallBox, proData.detailsNum),
						"Could not enter the details Text ;More Details:"
						,selenium,ClassName,MethodName);
				selectValueFromAjaxList(selenium, ajxPeriod, proData.period);
				waitForPageLoad(selenium);
			       assertTrue(type(selenium, txtYear, proData.year),
						"Could not enter the details year ;More Details:"
					,selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, txtStartAge, proData.startAge),
						"Could not enter the start age ;More Details:"
						,selenium,ClassName,MethodName);
				selectValueFromAjaxList(selenium, ajxStopped,
						proData.historyType);

				if (getValue(selenium, ajxStopped).equals("stopped")) {
					if (isElementPresent(selenium, txtStopAge)) {
						
						assertTrue(type(selenium, txtStopAge, proData.stopAge),
								"Could not enter the details year ;More Details:"
							,selenium,ClassName,MethodName);
					}
				}

				selectValueFromAjaxList(selenium, ajxLifeStage,
						proData.lifeStage);

			assertTrue(
						type(selenium, txtcomment, proData.comment),
						"Could not enter the comment;More Details:"
						,selenium,ClassName,MethodName);
			}
			if (proData.testCaseId.equals("TC_CSH_003")
					|| proData.testCaseId.equals("TC_CSH_005")
					|| proData.testCaseId.equals("TC_CSH_023")
					|| proData.testCaseId.equals("TC_CSH_025")) {
				if(selenium.isVisible(btnSocialEditSave)){	assertTrue(click(selenium, btnSocialEditSave),
						"Could not click the save button;More details:",
						selenium, ClassName, MethodName);
				}
				else 
					assertTrue(click(selenium, "saveSocialHistory"),
							"Could not click the save button;More details:",
							selenium, ClassName, MethodName); 
				waitForPageLoad(selenium);
				return true;
			}
			if (proData.testCaseId.equals("TC_CSH_004")) {
			assertTrue(click(selenium, btnCnclSocHis),
						"Could not click the Cancel button;More details:"
					,selenium,ClassName,MethodName);
				return true;
			}

			if (proData.testCaseId.equals("TC_CSH_011")) {
			assertTrue(click(selenium, btnSaveSocHis),
						"Could not click the Save button;More details:"
					,selenium,ClassName,MethodName);
				return true;
			}

			// Click Add on New Social History
			click(selenium, btnAdd);
			waitForPageLoad(selenium);

			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * deleteAllSocialHistory function to delete All existing Social history
	 * @throws IOException 
	 * 
	 * @since Nov 07, 2012
	 */

	public boolean deleteAllSocialHistory(Selenium selenium,
			ChartPreVisitLib socialData) throws IOException {
		boolean socialHistoryDeleted = true;
		int proCount = 0;
		try {
			waitForElement(selenium, btnDeleteSocial, WAIT_TIME);
			while ((Integer) selenium.getXpathCount(btnDeleteSocial) > 0) {
				proCount = (Integer) selenium.getXpathCount(btnDeleteSocial);
				assertTrue(click(selenium,
						"//div[@id='SocialHistoryList']/table/tbody/tr["
								+ proCount + "]/td[4]/div/a"),"Could not click on Social History Link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtdeleteReason, "NoReason"),
						"Could not enter the reason ;More Details:"
								+ socialData.toString(),selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnDeleteReason),"Could not Click on Delete Reason link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (proCount == (Integer) selenium
						.getXpathCount(btnDeleteSocial)) {
					Assert.fail("Could not delete the entry");
					socialHistoryDeleted = false;
					break;
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return socialHistoryDeleted;
	}

	/**
	 * unitTestForSocailHistory function to unit Test For FamilyHistort
	 * @throws IOException 
	 * 
	 * @since Oct 29, 2012
	 */
	public boolean unitTestForSocailHistory(Selenium selenium,
			ChartPreVisitLibUnitTest proData) throws IOException {
		try {
			selectValueFromAjaxList(selenium, ajxType, proData.type);

			selectValueFromAjaxList(selenium, ajxStatus, proData.status);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkSocialShowMore),
					"Could not on show more button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(
					type(selenium, txtSocialQuickList, proData.item),
					"Could not enter the item;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			if (proData.testCaseId.equals("TC_USH_001")
					|| proData.testCaseId.equals("TC_USH_002")) {
				assertTrue(
						type(selenium, txtdetailsBox, proData.detailsNum),
						"Could not enter the details Num ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			} else {
				assertTrue(
						type(selenium, txtDetailsNumBox, proData.detailsNum),
						"Could not enter the details Num ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtDetailsSmallBox, proData.detailsText),
						"Could not enter the details Text ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium, ajxPeriod, proData.period);
			assertTrue(
					type(selenium, txtYear, proData.year),
					"Could not enter the details year ;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtStartAge, proData.startAge),
					"Could not enter the start age ;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxStopped, proData.historyType);

			selectValueFromAjaxList(selenium, ajxLifeStage, proData.lifeStage);

			assertTrue(
					type(selenium, txtcomment, proData.comment),
					"Could not enter the comment;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					click(selenium, btnAdd),
					"Could not click add button;More Details"
							+ proData.toString(),selenium, ClassName, MethodName);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * editUnsignedEncounters function to edit Unsigned Encounters
	 * @throws IOException 
	 * 
	 * @since Nov 02, 2012
	 */
	public boolean editUnsignedEncounters(Selenium selenium,
			ChartPreVisitLib ecData, String account) throws IOException {
		try {
			/*assertTrue(
					enterDate(selenium, txtEncouDate, ecData.ecDate),
					"Could not enter the Date;More Details:"
							+ ecData.toString(),selenium, ClassName, MethodName);
//			selectValueFromAjaxList(selenium, ajxEncounterProvider,
//					ecData.providerName);
			if(isElementVisible(selenium,"contactModesuggestBox"))
			{
				selectValueFromAjaxList(selenium,"contactModesuggestBox","Scheduled");	
			}*/

			ChartPreVisitLib proData = new ChartPreVisitLib();
			proData.workSheetName = "CreateProblemList";
			proData.testCaseId = "TC_CPL_002";
			proData.fetchChartPreVisitTestData();

			assertTrue(click(selenium, lnkProblemList),
					"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(createProblemList(selenium,proData, account),"Creation failed", selenium, ClassName, MethodName);


			assertTrue(
					isElementPresent(selenium, lnkBeginEncounterAction),
					"Could not find the link;More Details:" + ecData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					click(selenium, lnkBeginEncounterAction),
					"Could not click the button;More Details:"
							+ ecData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(
					click(selenium, lblEncounterSave),
					"Could not click the save button;More Details:"
							+ ecData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}



	/**
	 * createNewPatientWithMandatory function to create New Patient With
	 * Mandatory
	 * @throws IOException 
	 * 
	 * @since Nov 09, 2012
	 */
	public boolean createNewPatientWithMandatory(Selenium selenium,
			ChartPreVisitLib patientData) throws IOException {
		boolean returnValue = false;
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat DateFormat1 = new SimpleDateFormat(
				"ddmmss");
		date = DateFormat1.format(cal1.getTime());
		 patientData.lastName= patientData.lastName+date;
		try {
			waitForPageLoad(selenium);
			assertTrue(
					type(selenium, txtlastName, patientData.lastName),
					"Could not type the last name : More Details"
							+ patientData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtFirstName, patientData.firstName),
					"Could not type the first Name : More Details"
							+ patientData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, "prematurecheckbox"),
					"Could not click prematurecheck box : More Details"
							+ patientData.toString(),selenium, ClassName, MethodName);
			
	if(selenium.isElementPresent(btnBack1))
	{
		assertTrue(click(selenium, btnBack1),
				"Could click back button, Expected value to be typed"
						+ patientData.dob,selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	}
				selectValueFromAjaxList(selenium,
					"prematureDurationSuggestBoxsuggestBox",
					patientData.duration);
			selectValueFromAjaxList(selenium, "sexSuggestBoxsuggestBox",
					patientData.sex);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,
					"prematureMeasureUnitSuggestBoxsuggestBox",
					patientData.measure);
			selectValueFromAjaxList(selenium, ajxStatus, patientData.status);
			if (!patientData.dob.isEmpty())
				if (!patientData.dob.contains("N/A"))
					assertTrue(
							enterDate(selenium, "dob", patientData.dob),
							"Could not Enter dob, Expected value to be typed"
									+ patientData.dob,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
	if(selenium.isElementPresent(btnBack1))
	{
		assertTrue(click(selenium, btnBack1),
				"Could click back button, Expected value to be typed"
						+ patientData.dob,selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	}
		
			assertTrue(
					click(selenium, btnNoteSave),
					"Could not click Save button More Dateils"
							+ patientData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium, btnNoteSave),
					"Patient details not created"
							+ patientData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			returnValue = true;
		} catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"
					+ e.getMessage()
					+ "\n\t*); Detailed data:"
					+ patientData.toString());
		}
		return returnValue;
	}

	/**
	 * addVitals Function to create a Vitals
	 * @throws IOException 
	 * 
	 * @throws InterruptedException
	 * @since Nov 09, 2012
	 */
	public boolean addVitals(Selenium selenium, ChartPreVisitLib vitalsData) throws IOException {
		DecimalFormat df = new DecimalFormat(".##");
		try {
			waitForPageLoad(selenium);
			System.out.println(vitalsData.heightMU);
			if (vitalsData.heightMU.equals("cm")) {
				selectValueFromAjaxList(selenium, ajxHeight,
						vitalsData.heightMU);
				assertTrue(
						type(selenium, txtHeight, vitalsData.heightInCm),
						"could not type height in cm",selenium, ClassName, MethodName);

			} else {
				selectValueFromAjaxList(selenium, ajxHeight,
						vitalsData.heightMU);
				selectValueFromAjaxList(selenium, ajxHeight,
						vitalsData.heightMU);
				assertTrue(
						type(selenium, "heightFeet1", vitalsData.heightInFeet),
						"Could not type Hight in feet",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, "heightFeet2", vitalsData.heightInCm),
						"Could not type Hight in cm or inches",selenium, ClassName, MethodName);

				waitForPageLoad(selenium);
			}
			if (vitalsData.testCaseId.equals("TC_CV_005"))
				getText(selenium, "//div[2]/div[4]/div").contains(
						vitalsData.htResult);
			if (vitalsData.testCaseId.equals("TC_CV_006"))
				getText(selenium, "//div[2]/div[4]/div").contains(
						vitalsData.htResult);
			// assertTrue(type(selenium,
			// "xpath=(//input[@type='text'])[7]", vitalsData.weight),
			// "Could not type weight");
			selectValueFromAjaxList(selenium, ajxWeight, vitalsData.weightMU);
			assertTrue(type(selenium, txtWeight, vitalsData.weight),
					"Could not type weight",selenium, ClassName, MethodName);

			// waitForPageLoad(selenium);
			if (vitalsData.testCaseId.equals("TC_CV_007"))
				getText(selenium, "//div[3]/div[2]/div[3]/div").contains(
						vitalsData.wtResult);
			if (vitalsData.testCaseId.equals("TC_CV_008"))
				getText(selenium, "//div[3]/div[2]/div[3]/div").contains(
						vitalsData.wtResult);
			if (vitalsData.testCaseId.equals("TC_CV_009")) {
				String kg = getValue(selenium,
						"xpath=(//input[@type='text'])[9]");
				float kgs = Float.valueOf(kg).floatValue();
				String cm = getValue(selenium,
						"xpath=(//input[@type='text'])[7]");
				float htInCm = Float.valueOf(cm).floatValue();
				float htInMetre = (float) (htInCm * 0.01);
				float BMI = kgs / (htInMetre * htInMetre);
				String expectedBMI = Float.toString(BMI);
				Assert.assertEquals(
						getText(selenium, "//div[4]/div/div/div[2]/div"),
						df.format(expectedBMI));
			}
			if (vitalsData.testCaseId.equals("TC_CV_010")) {
				String actuallbs = getValue(selenium,
						"xpath=(//input[@type='text'])[9]");
				Float lbs = Float.valueOf(actuallbs).floatValue();
				String cmS = getValue(selenium,
						"xpath=(//input[@type='text'])[7]");
				float cmF = Float.valueOf(cmS).floatValue();
				float inches = (float) (cmF / 2.54);
				float BMI2 = ((lbs * 703) / (inches * inches));
				String expectedBMI = Float.toString(BMI2);
				Assert.assertEquals(actuallbs, df.format(expectedBMI));
			}
			assertTrue(
					type(selenium, txtSystolic, vitalsData.systolicRate),
					"Could not type systolic Rate",selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtdiastolic, vitalsData.diastolicRate),
					"Could not type diastolic Rate",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxPosition, vitalsData.position);
			// waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxLimb, vitalsData.limb);
			// waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxCuffsize, vitalsData.cuffSize);
			// waitForPageLoad(selenium);
			assertTrue(type(selenium, txtheartRate, vitalsData.bPM),
					"Could not type Heart Rate",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxdescription,
					vitalsData.description);
			// waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxrhythm, vitalsData.rhythm);
			// waitForPageLoad(selenium);
			if (!vitalsData.testCaseId.equalsIgnoreCase("TC_CV_001")
					|| (!vitalsData.testCaseId.equalsIgnoreCase("TC_CV_011"))
					&& (!vitalsData.testCaseId.equalsIgnoreCase("TC_CV_013"))) {
				if (getText(selenium, lnkVitalShowmore).contains(
						"Show more details"))
					assertTrue(click(selenium, lnkVitalShowmore),
							"Could not click on show more details",selenium, ClassName, MethodName);
				// waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxWaist, vitalsData.waistMU);
				assertTrue(type(selenium, txtwaist, vitalsData.waist),
						"Could not type waist",selenium, ClassName, MethodName);

				// waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxTempUnit,
						vitalsData.tempRU);
				assertTrue(
						type(selenium, txtTemp, vitalsData.temperature),
						"Could not type temperature",selenium, ClassName, MethodName);

				// waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxTempLocation,
						vitalsData.location);
				// waitForPageLoad(selenium);
				assertTrue(
						type(selenium, txtBloodSugar, vitalsData.bloodSuger),
						"Could not type blood sugar",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxBloodSugar,
						vitalsData.bSUnit);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, txtRespiratory,
								vitalsData.repositoryRate),
						"Could not type Repository rate",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxRespiratory,
						vitalsData.rR_BPM);
				// waitForPageLoad(selenium);
				assertTrue(
						type(selenium, txtOxygen, vitalsData.oxygenSaturation),
						"Could not type oxygen saturation",selenium, ClassName, MethodName);
				assertTrue(type(selenium, txtPefr, vitalsData.pEFR),
						"Could not type pefr",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxPefr,
						vitalsData.pre_bronchodilator);
				waitForPageLoad(selenium);

				if (vitalsData.testCaseId.equalsIgnoreCase("TC_CV_025")) {
					assertTrue(
							selectValueFromAjaxList(selenium,
									"headSuggestBoxsuggestBox",
									vitalsData.headMU),
							"Could not type head Mu",selenium, ClassName, MethodName);
					assertTrue(
							type(selenium, "xpath=(//input[@type='text'])[11]",
									vitalsData.head), "Could not type head",selenium, ClassName, MethodName);

					assertTrue(
							selectValueFromAjaxList(selenium,
									ajxFatherStature,
									vitalsData.headMU),
							"Could not type head Mu",selenium, ClassName, MethodName);
					assertTrue(
							type(selenium, txtFatherHeightInFeet,
									vitalsData.fatherStature),
							"Could not typefather stature",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(
							type(selenium, txtFatherHeightIn,
									vitalsData.fatherStatureIn),
							"Could not type fatherstatureIn",selenium, ClassName, MethodName);

					assertTrue(
							selectValueFromAjaxList(selenium,
									ajxMotherStature,
									vitalsData.headMU),
							"Could not type head Mu",selenium, ClassName, MethodName);
					assertTrue(
							type(selenium, txtMotherHeightInFeet,
									vitalsData.motherStature),
							"Could not type miother stature",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(
							type(selenium, txtMotherHeightIn,
									vitalsData.motherStatureIn),
							"Could not type motherstaturein",selenium, ClassName, MethodName);
				}
			}

			if (vitalsData.testCaseId.equals("TC_CV_011")
					|| vitalsData.testCaseId.equals("TC_CV_012")) {
				if (getText(selenium, btnAdd).equalsIgnoreCase("Update")) {
					Thread.sleep(30000);
					assertTrue(click(selenium, btnAdd),
							"Could not click on Update button",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					if (isElementPresent(selenium, "errorCloseButton"))
						assertTrue(click(selenium, "errorCloseButton"),"Could not click on Error Close Button",selenium, ClassName, MethodName);

				} else {
					assertTrue(click(selenium, btnAdd),
							"Could not click on add button",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					if (isElementPresent(selenium, "errorCloseButton"))
						assertTrue(click(selenium, "errorCloseButton"),"Could not click on Close Button",selenium, ClassName, MethodName);
				}

			} else {
				assertTrue(click(selenium, btnAdd),
						"Could not click on add button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (isElementPresent(selenium, "errorCloseButton"))
					assertTrue(click(selenium, "errorCloseButton"),"Could not click on Close Button",selenium, ClassName, MethodName);
			}

		} catch (RuntimeException e) {
			Assert.fail("Failed due to the Exception; \n Exception details: "
					+ e.getMessage());
			return false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * noAccessUserClinicalSetting function to No Access User System Settings
	 * 
	 * @throws IOException
	 * @since Nov 08, 2013
	 */
	public boolean noAccessUserClinicalSetting(Selenium selenium,
			ChartPreVisitLib cdsData, String userAccount) throws IOException {
		try {

			assertTrue(click(selenium, lnkQuickLink),
					"Could not click on the link" + cdsData.toString(),
					selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(
					!selenium
					.isElementPresent("css=#clinicalSettingsAction > span.actionItemSpan"),
					"System Setting Link is Visible", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);

			assertTrue(!selenium.isTextPresent("No permission"),
					"No Permission Present", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),
					" Error Message Present", selenium, ClassName, MethodName);
			return true;
		}

		catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"
					+ e.getMessage()
					+ "\n\t*); Detailed data:"
					+ cdsData.toString());
			return false;
		}
	}

	/**
	 * fullViewAccessUserClinicalSetting function to Full View Access User
	 * System Settings
	 * 
	 * @throws IOException
	 * @since August 30, 2013
	 */
	public boolean fullViewAccessUserClinicalSetting(Selenium selenium,
			ChartPreVisitLib cdsData, String userAccount) throws IOException {
		try {

			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 
			assertTrue(click(selenium, lnkSettings),
					"Could not click on the link" + cdsData.toString(),
					selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(
					click(selenium,
							"clinicalSettingsAction"),
							"Could not click the systemSettings link;More Deatils:"
									+ cdsData.toString(), selenium, ClassName,
									MethodName);
			waitForPageLoad(selenium);

			assertTrue(!selenium.isTextPresent("No permission"),
					"No Permission Present", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),
					" Error Message Present", selenium, ClassName, MethodName);

			return true;
		}

		catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"
					+ e.getMessage()
					+ "\n\t*); Detailed data:"
					+ cdsData.toString());
			return false;
		}
	}

	/**
	 * addEncounterVitals Function to create a Encounter Vitals
	 * @throws IOException 
	 * 
	 * @since Dec 21, 2012
	 */
	public boolean addEncounterVitals(Selenium selenium,
			ChartPreVisitLib vitalsData) throws IOException {

		try {
			if (!((vitalsData.testCaseId.equalsIgnoreCase("TC_CV_011")) || (vitalsData.testCaseId
					.equalsIgnoreCase("TC_CV_012")))) {

				selectValueFromAjaxList(selenium, ajxHeight,
						vitalsData.heightMU);
				type(selenium, txtHeightInFeet, vitalsData.heightInFeet);
				assertTrue(
						type(selenium, txtHeightIn, vitalsData.heightInCm),
						"Could not type Hight in inches",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxWeight,
						vitalsData.weightMU);
				assertTrue(type(selenium, txtWeight, vitalsData.weight),
						"Could not type weight",selenium, ClassName, MethodName);

				assertTrue(
						type(selenium, txtSystolic, vitalsData.systolicRate),
						"Could not type systolic Rate",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtdiastolic, vitalsData.diastolicRate),
						"Could not type diastolic Rate",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxPosition,
						vitalsData.position);
				// waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxLimb, vitalsData.limb);
				// waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxCuffsize,
						vitalsData.cuffSize);
				// waitForPageLoad(selenium);
				assertTrue(type(selenium, txtheartRate, vitalsData.bPM),
						"Could not type Heart Rate",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxdescription,
						vitalsData.description);
				// waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxrhythm, vitalsData.rhythm);
				// waitForPageLoad(selenium);
				if (!(vitalsData.testCaseId.equalsIgnoreCase("TC_CV_001"))
						&& !(vitalsData.testCaseId
								.equalsIgnoreCase("TC_CV_011"))) {
					if (getText(selenium, lnkVitalShowmore).contains(
							"Show more details"))
						assertTrue(click(selenium, lnkVitalShowmore),
								"Could not click on show more details",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium, ajxWaist,
							vitalsData.waistMU);
					assertTrue(
							type(selenium, txtwaist, vitalsData.waist),
							"Could not type waist",selenium, ClassName, MethodName);

					// waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium, ajxTempUnit,
							vitalsData.tempRU);
					assertTrue(
							type(selenium, txtTemp, vitalsData.temperature),
							"Could not type temperature",selenium, ClassName, MethodName);

					// waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium, ajxTempLocation,
							vitalsData.location);
					// waitForPageLoad(selenium);
					assertTrue(
							type(selenium, txtBloodSugar, vitalsData.bloodSuger),
							"Could not type blood sugar",selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium, ajxBloodSugar,
							vitalsData.bSUnit);
					// waitForPageLoad(selenium);
					assertTrue(
							type(selenium, txtRespiratory,
									vitalsData.repositoryRate),
							"Could not type blood sugar",selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium, ajxRespiratory,
							vitalsData.rR_BPM);
					// waitForPageLoad(selenium);
					assertTrue(
							type(selenium, txtOxygen,
									vitalsData.oxygenSaturation),
							"Could not type oxygen saturation",selenium, ClassName, MethodName);
					assertTrue(type(selenium, txtPefr, vitalsData.pEFR),
							"Could not type pefr",selenium, ClassName, MethodName);

					selectValueFromAjaxList(selenium, ajxPefr,
							vitalsData.pre_bronchodilator);
					if (vitalsData.testCaseId.equals("TC_CV_025")) {
						selectValueFromAjaxList(selenium,
								ajxFatherStature, "inches");
						/*		assertTrue(
								type(selenium,
										"xpath=(//input[@type='text'])[14]",
										vitalsData.head),
								"Could not type head value");*/

						selectValueFromAjaxList(selenium,
								ajxMotherStature, "inches");
						assertTrue(
								type(selenium,
										txtFatherHeightInFeet,
										vitalsData.fatherStature),
								"Could not type father Stature",selenium, ClassName, MethodName);
						assertTrue(
								type(selenium,
										txtFatherHeightIn,
										vitalsData.fatherStatureIn),
								"Could not type father Stature Inches",selenium, ClassName, MethodName);
						assertTrue(
								type(selenium,
										txtMotherHeightInFeet,
										vitalsData.motherStature),
								"Could not type mother Stature",selenium, ClassName, MethodName);
						assertTrue(
								type(selenium,
										txtMotherHeightIn,
										vitalsData.motherStatureIn),
								"Could not type mother Stature inches",selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
					}
				}

				assertTrue(click(selenium, btnAdd),
						"Could not click on add button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}

			else {
				selectValueFromAjaxList(selenium, ajxHeight,
						vitalsData.heightMU);
				assertTrue(
						type(selenium, txtHeightInFeet, vitalsData.heightInFeet),
						"Could not type Hight in feet",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtHeightIn, vitalsData.heightInCm),
						"Could not type Hight in inches",selenium, ClassName, MethodName);

				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxWeight,
						vitalsData.weightMU);
				assertTrue(type(selenium, txtWeight, vitalsData.weight),
						"Could not type weight",selenium, ClassName, MethodName);

				assertTrue(
						type(selenium, txtSystolic, vitalsData.systolicRate),
						"Could not type systolic Rate",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtdiastolic, vitalsData.diastolicRate),
						"Could not type diastolic Rate",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxPosition,
						vitalsData.position);
				// waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxLimb, vitalsData.limb);
				// waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxCuffsize,
						vitalsData.cuffSize);
				// waitForPageLoad(selenium);
				assertTrue(type(selenium, txtheartRate, vitalsData.bPM),
						"Could not type Heart Rate",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxdescription,
						vitalsData.description);
				// waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxrhythm, vitalsData.rhythm);
				// waitForPageLoad(selenium);
				if (!(vitalsData.testCaseId.equalsIgnoreCase("TC_CV_011"))) {
					if (getText(selenium, lnkVitalShowmore).contains(
							"Show more details"))
						assertTrue(click(selenium, lnkVitalShowmore),
								"Could not click on show more details",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium, ajxWaist,
							vitalsData.waistMU);
					assertTrue(
							type(selenium, txtwaist, vitalsData.waist),
							"Could not type waist",selenium, ClassName, MethodName);

					// waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium, ajxTempUnit,
							vitalsData.tempRU);
					assertTrue(
							type(selenium, txtTemp, vitalsData.temperature),
							"Could not type temperature",selenium, ClassName, MethodName);

					// waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium, ajxTempLocation,
							vitalsData.location);
					// waitForPageLoad(selenium);
					assertTrue(
							type(selenium, txtBloodSugar, vitalsData.bloodSuger),
							"Could not type blood sugar",selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium, ajxBloodSugar,
							vitalsData.bSUnit);
					// waitForPageLoad(selenium);
					assertTrue(
							type(selenium, txtRespiratory,
									vitalsData.repositoryRate),
							"Could not type blood sugar",selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium, ajxRespiratory,
							vitalsData.rR_BPM);
					// waitForPageLoad(selenium);
					assertTrue(
							type(selenium, txtOxygen,
									vitalsData.oxygenSaturation),
							"Could not type oxygen saturation",selenium, ClassName, MethodName);
					assertTrue(type(selenium, txtPefr, vitalsData.pEFR),
							"Could not type pefr",selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium, ajxPefr,
							vitalsData.pre_bronchodilator);
					waitForPageLoad(selenium);
				}

				assertTrue(click(selenium, btnAdd),
						"Could not click on add button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}

			return true;
		} catch (RuntimeException e) {
			Assert.fail("Failed due to the Exception; \n Exception details: "
					+ e.getMessage());
			return false;
		}
	}


	/**
	 * verifyDefaultValueInLab
	 *  Function to verify Default Value In Lab
	 * @throws IOException 
	 * 
	 * @since Dec 12, 2014
	 */
	public boolean verifyDefaultValueInLab(Selenium selenium) throws IOException {
		try {
			assertTrue(getValue(selenium, ajxLabFacility).contains(""),"Not blank", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium, ajxNotifyDuration).contains(""),"Not blank", selenium, ClassName, MethodName);
			assertTrue(!isChecked(selenium, chkboxUrgent),"It is checked", selenium, ClassName, MethodName);

			 return true;
		}
		 catch (RuntimeException e) {
				Assert.fail("Failed due to the Exception; \n Exception details: "+ e.getMessage());
				return false;
		 }
	}
	
	/**
	 * orderNewLabs Function to order New Labs
	 * @throws IOException 
	 * 
	 * @since Nov 15, 2012
	 */
	public boolean orderNewLabs(Selenium selenium, ChartPreVisitLib orderData) throws IOException {
		try {

			if (isElementPresent(selenium, btnErrorClose)) {
				assertTrue(click(selenium, btnErrorClose),"Could not Click Close", selenium, ClassName,MethodName);
			}
			if (isElementPresent(selenium, btnOk)) {
				assertTrue(click(selenium, btnOk),"Could not Click Close", selenium, ClassName,MethodName);
			}
			/*
			 * assertTrue(click(selenium,"labTestNameSuggestBox" ),
			 * "Could not click on test name suggest box");
			 * assertTrue(type(selenium,"labTestNameSuggestBox",
			 * orderData.labTestName),
			 * "Could not click on test name suggest box");
			 * waitForPageLoad(selenium);
			 */
			String provider = getText(selenium, lnkTopMenu);
			String onBehalfOf = provider.replaceAll(", " + orderData.switchRole, "");
			orderData.provider = onBehalfOf;
			//	selectValueFromAjaxList(selenium,ajxProvider,orderData.provider);
			//	String providerNameTemp = getText(selenium, lnkTopMenu);
			//	String providerName = providerNameTemp.replaceAll(", "+ orderData.switchRole, "");
			String location = getText(selenium, lnkLocationHeader).replace("...", "");
			assertTrue(selectValueFromAjaxList(selenium, ajxLoaction, location),"Could not click on save button", selenium, ClassName,MethodName);
			
			if(orderData.testCaseId.equals("TC_OL_016")){
				assertTrue(selectValueFromAjaxList(selenium, printOn, orderData.printOn),"Could not click on save button", selenium, ClassName,MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxTestName,orderData.labTestName),"Could not click on save button", selenium, ClassName,MethodName);
				assertTrue(click(selenium, btnPrintLab),"Could not click on Print button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnCancelID),"Could not click on Cancel Print button", selenium, ClassName,MethodName);
				return true;
			}

			if (orderData.testCaseId.equals("TC_OL_004")) {
				assertTrue(click(selenium, lnkAction),
				"Could not click on save button",selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnNewSave1),
						"Could not click on save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (getText(selenium, lblNeedtoSelected).toLowerCase(new java.util.Locale("en", "US")).trim().contains("You need to select one test at least for saving the report!".trim().toLowerCase(new java.util.Locale("en", "US")))) {
					return true;
				} else
					return false;
			}
			if (orderData.testCaseId.equals("TC_OL_003")) {
				selectValueFromAjaxList(selenium, ajxTestName,
						orderData.labTestName);
				if (isElementPresent(selenium, btnOk)) {
					click(selenium, btnOk);
					selectValueFromAjaxList(selenium, ajxTestName,
							orderData.labTestName);
				}
				assertTrue(click(selenium, lnkAction),
				"Could not click on save button",selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnNewSave1),
						"Could not click on save button",selenium, ClassName, MethodName);
				return true;
			}
			assertTrue(selectValueFromAjaxList(selenium, ajxPrintOn,orderData.printon),"PrintOn  ajx failed",selenium,ClassName,MethodName);
			assertTrue(selectValueFromAjaxList(selenium, ajxTestName1,orderData.labTestName),"TestName  ajx failed",selenium,ClassName,MethodName);
			assertTrue(selectValueFromAjaxList(selenium, ajaxPayer,orderData.payer),"Payer  ajx failed",selenium,ClassName,MethodName);
			assertTrue(selectValueFromAjaxList(selenium, ajxCopyTo,orderData.copyTo),"CopyTo  ajx failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtLabComments, orderData.labTestComments1),"Could not type comments",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxLabFacility, orderData.sendTo);
			if (orderData.testCaseId.equals("TC_OL_005")) {
				return true;
			}
			if(orderData.testCaseId.equals("TC_OL_008")){
				assertTrue(click(selenium, btnNewLabCancel),"Could not click on cancel button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				return true;
			}
			if(!orderData.testCaseId.equals("TC_OL_009")){
			if(!isChecked(selenium,chkTestName))
			{
			assertTrue(click(selenium, chkTestName),"Could not click test name",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			assertTrue(click(selenium, lnkAction),"Could not click on save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnNewSave1),"Could not click on save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}else
				assertTrue(click(selenium, btnPrintLab),"Could not click on save button",selenium, ClassName, MethodName);
			
				
			return true;
		} catch (RuntimeException e) {
			Assert.fail("Failed due to the Exception; \n Exception details: "+ e.getMessage());
			return false;
		}
	}

	/**
	 * unitTestLabOrders Function to order New Labs
	 * @throws IOException 
	 * 
	 * @since Nov 19, 2012
	 */
	public boolean unitTestLabOrders(Selenium selenium,
			ChartPreVisitLibUnitTest orderData) throws IOException {
		try {
			if (orderData.testCaseId.equals("TC_ULO_001")) {
				assertTrue(click(selenium, btnSaveLab),
						"Could not click on save button",selenium, ClassName, MethodName);
				return true;
			}
			if (orderData.testCaseId.equals("TC_ULO_002")) {
				selectValueFromAjaxList(selenium, ajxTestName,
						orderData.labTestName);
				assertTrue(click(selenium, btnSaveLab),
						"Could not click on save button",selenium, ClassName, MethodName);
				return true;
			}
			selectValueFromAjaxList(selenium, ajxTestName,
					orderData.labTestName);
			waitForPageLoad(selenium);
			assertTrue(
					type(selenium, "css=textarea.width370pxImportant.height50",
							orderData.labTestComments1),
					"Could not type comments",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxRxProvider, orderData.sendTo);
			assertTrue(click(selenium, btnSaveLab),
					"Could not click on save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			Assert.fail("Failed due to the Exception; \n Exception details: "
					+ e.getMessage());
			return false;
		}
	}

	/**
	 * unitTestDiOrders Function to order New Labs
	 * @throws IOException 
	 * 
	 * @since Nov 30, 2012
	 */
	public boolean unitTestDiOrders(Selenium selenium,
			ChartPreVisitLibUnitTest orderData) throws IOException {
		try {
			selectValueFromAjaxList(selenium, ajxTestName,
					orderData.labTestName);
			assertTrue(
					type(selenium, txtComments, orderData.labTestComments1),
					"Could not type comments",selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtAuthorization, orderData.authorization),
					"Could not type authorization",selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnDiagnosticSave),
					"Could not click on save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			Assert.fail("Failed due to the Exception; \n Exception details: "
					+ e.getMessage());
			return false;
		}
	}

	/**
	 * orderNewDi Function to order New Di
	 * @throws IOException 
	 * 
	 * @since Nov 15, 2012
	 */
	public boolean orderNewDi(Selenium selenium, ChartPreVisitLib orderData) throws IOException {
		try {

			/*
			 * assertTrue(click(selenium,"labTestNameSuggestBox" ),
			 * "Could not click on test name suggest box");
			 * assertTrue(type(selenium,ajxTestName,
			 * orderData.labTestName),
			 * "Could not click on test name suggest box");
			 * waitForPageLoad(selenium);
			 */

			String provider= getText(selenium, lnkTopMenu);
			String onBehalfOf= provider.replaceAll(", "+orderData.switchRole, "");
			String onBehalfOf1[]=onBehalfOf.split(" ");
			assertTrue(selectValueFromAjaxList(selenium,ajxProvider,onBehalfOf1[1]),"could not entre the on Behalf of details", selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxLoaction,orderData.location),"could not entre the on Behalf of details", selenium, ClassName, MethodName);
			
			
			if (orderData.testCaseId.equals("TC_ODI_004")){
				assertTrue(click(selenium, btnDiagnosticSave),"Could not click on save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (getText(selenium, lblNeedtoSelected).toLowerCase(new java.util.Locale("en", "US")).trim().contains(
						"You need to select one test at least for saving the report!".trim().toLowerCase(new java.util.Locale("en", "US")))) {
					return true;
				} else
					return false;
			}
			if (orderData.testCaseId.equals("TC_ODI_003")) {
				selectValueFromAjaxList(selenium, ajxTestName,
						orderData.labTestName);
				if (isElementPresent(selenium, btnOk)) {
					assertTrue(click(selenium, btnOk),
							"Could not click the ok Button",selenium, ClassName, MethodName);
				}
				assertTrue(click(selenium, btnDiagnosticSave),
						"Could not click on save button",selenium, ClassName, MethodName);
				return true;
			}
			selectValueFromAjaxList(selenium, ajxTestName,orderData.labTestName);
			if (isElementPresent(selenium, btnOk)) {
				assertTrue(click(selenium, btnOk),
						"Could not click the ok Button",selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			//assertTrue(selectValueFromAjaxList(selenium,ajaxPayer, orderData.payer),"Could not enter the payer", selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtComments, orderData.labTestComments1),"Could not type notifyme",selenium, ClassName, MethodName);
			assertTrue(type(selenium, ajxNotifyDuration, "10"),"Could not type notifyme",selenium, ClassName, MethodName);
			assertTrue(type(selenium, ajxDurationUnit, orderData.notifymein),"Could not type notifymein",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAuthorization, orderData.authorization),"Could not type comments",selenium, ClassName, MethodName);
			assertTrue(click(selenium, chkboxUrgent),"Could not click the cancel button",selenium, ClassName, MethodName);
			
			if (orderData.testCaseId.equals("TC_OL_005")) {
				assertTrue(click(selenium, btnSignDiagnostic),"Could not click on sign button",selenium, ClassName, MethodName);
				return true;
			}
			if (orderData.testCaseId.equals("TC_OL_006")) {
				assertTrue(click(selenium, chkboxUrgent),"Could not check the Assessment",selenium, ClassName, MethodName);
			}

			if (orderData.testCaseId.equals("TC_OL_008")) {
				assertTrue(click(selenium, btnDiagnosticCancel),"Could not click the cancel button",selenium, ClassName, MethodName);
			}else
				assertTrue(click(selenium, btnDiagnosticSave),"Could not click on save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			Assert.fail("Failed due to the Exception; \n Exception details: "
					+ e.getMessage());
			return false;
		}
	}


	/**
	 * verifyCommentsIcon Function to order New Di
	 * @throws IOException 
	 * 
	 * @since Nov 15, 2012
	 */
	public boolean verifyCommentsIcon(Selenium selenium,
			ChartPreVisitLib orderData) throws IOException {
		try {

			boolean returnValue = false;
			if (orderData.testCaseId.equals("TC_DIC_001")) {
				selectValueFromAjaxList(selenium, ajxTestName,
						orderData.labTestName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, imbCommentIcon),
						"Could not click on comments icon",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtDiOrderComments,
								orderData.labTestComments1),
						"Could not type comments",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkSaveDiOrderCommetns),
						"Could not click on save button",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkHideDiOrderCommetns),
						"Could not click on hide comment link",selenium, ClassName, MethodName);
				assertTrue(click(selenium, imbCommentIcon),
						"Could not click on comments icon",selenium, ClassName, MethodName);
				if (getValue(selenium, txtDiOrderComments)
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								orderData.labTestComments1.trim().toLowerCase(
										new java.util.Locale("en", "US")))) {
					returnValue = true;
				}
				return returnValue;
			}
			if (orderData.testCaseId.equals("TC_DIC_002")) {
				selectValueFromAjaxList(selenium, ajxTestName,
						orderData.labTestName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, imbCommentIcon),
						"Could not click on comments icon",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtDiOrderComments,
								orderData.labTestComments1),
						"Could not type comments",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkSaveDiOrderCommetns),
						"Could not click on save button",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkHideDiOrderCommetns),
						"Could not click on hide comment link",selenium, ClassName, MethodName);
				assertTrue(click(selenium, imbCommentIcon),
						"Could not click on comments icon",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkEdit),
						"Could not click on edit link",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtDiOrderComments,
								orderData.labTestComments2),
						"Could not type comments",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkSaveDiOrderCommetns),
						"Could not click on save button",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkHideDiOrderCommetns),
						"Could not click on hide comment link",selenium, ClassName, MethodName);
				assertTrue(click(selenium, imbCommentIcon),
						"Could not click on comments icon",selenium, ClassName, MethodName);
				if (getValue(selenium, txtDiOrderComments)
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								orderData.labTestComments2.trim().toLowerCase(
										new java.util.Locale("en", "US")))) {
					returnValue = true;
				}
				return returnValue;

			}
			if (orderData.testCaseId.equals("TC_DIC_003")) {
				selectValueFromAjaxList(selenium, ajxTestName,
						orderData.labTestName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, imbCommentIcon),
						"Could not click on comments icon",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtDiOrderComments,
								orderData.labTestComments1),
						"Could not type comments",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkSaveDiOrderCommetns),
						"Could not click on save button",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkHideDiOrderCommetns),
						"Could not click on hide comment link",selenium, ClassName, MethodName);

				if (!getValue(selenium, txtDiOrderComments)
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								orderData.labTestComments1.trim().toLowerCase(
										new java.util.Locale("en", "US")))) {
					returnValue = true;
				}
				return returnValue;
			}
			if (orderData.testCaseId.equals("TC_DIC_004")) {
				selectValueFromAjaxList(selenium, ajxTestName,
						orderData.labTestName);
				assertTrue(click(selenium, imbCommentIcon),
						"Could not click on comments icon",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtDiOrderComments,
								orderData.labTestComments1),
						"Could not type comments",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkCancelDiOrderCommetns),
						"Could not click on cancel button",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkHideDiOrderCommetns),
				 "Could not click on hide comment link",selenium, ClassName, MethodName);
				assertTrue(click(selenium, imbCommentIcon),
						"Could not click on comments icon",selenium, ClassName, MethodName);
				if (!getValue(selenium, txtDiOrderComments)
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								orderData.labTestComments1.trim().toLowerCase(
										new java.util.Locale("en", "US")))) {
					returnValue = true;
				}
				return returnValue;

			}
			return returnValue;
		} catch (RuntimeException e) {
			Assert.fail("Failed due to the Exception; \n Exception details: "
					+ e.getMessage());
			return false;
		}
	}


	/**
	 * verifyCommentsIconForLabs Function to order New Di
	 * @throws IOException 
	 * 
	 * @since Nov 15, 2012
	 */
	public boolean verifyCommentsIconForLabs(Selenium selenium,
			ChartPreVisitLib labData) throws IOException {
		try {

			boolean returnValue = true;
			if (labData.testCaseId.equals("TC_LR_036")) {
				waitForPageLoad(selenium);
				assertTrue(click(selenium, elementCommentIcon),
						"Could not click on comments icon",selenium, ClassName, MethodName);
				if(isElementPresent(selenium,elementCommentIconInResult)){
				assertTrue(click(selenium, elementCommentIconInResult),
				"Could not click on comments icon",selenium, ClassName, MethodName);
				}
				assertTrue(
						type(selenium, elementCommentText, labData.comments),
						"Could not type comments",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkLabSave),
						"Could not click on save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (!getValue(selenium, elementCommentText)
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								labData.comments.trim().toLowerCase(
										new java.util.Locale("en", "US")))) {
					returnValue = false;
				}
				return returnValue;
			}
			if (labData.testCaseId.equals("TC_LR_037")) {
				waitForPageLoad(selenium);
				assertTrue(click(selenium, elementCommentIcon),
						"Could not click on comments icon",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkLabSave),
						"Could not click on save button",selenium, ClassName, MethodName);
				if(isElementPresent(selenium,lnkEditComment)){
					assertTrue(click(selenium, lnkEditComment),
					"Could not click on comments icon",selenium, ClassName, MethodName);
					}
				assertTrue(
						type(selenium, elementCommentText, labData.comments),
						"Could not type comments",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkLabSave),
						"Could not click on save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkEditComment),
						"Could not click on edit link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, elementCommentText, labData.comments),
						"Could not type comments",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkLabSave),
						"Could not click on save button",selenium, ClassName, MethodName);

				return returnValue;

			}
			if (labData.testCaseId.equals("TC_LR_038")) {

				assertTrue(click(selenium, elementCommentIcon),
						"Could not click on comments icon",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,elementCommentIconInResult)){
					assertTrue(click(selenium, elementCommentIconInResult),
					"Could not click on comments icon",selenium, ClassName, MethodName);
				}
				waitForPageLoad(selenium);
				assertTrue(type(selenium, elementCommentText, labData.comments),
						"Could not type comments",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkLabSave),
						"Could not click on save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkHideComment),
						"Could not click on hide comment link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (getValue(selenium, elementCommentText)
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								labData.comments.trim().toLowerCase(
										new java.util.Locale("en", "US")))) {
					returnValue = false;
				}
				return returnValue;
			}
			if (labData.testCaseId.equals("TC_LR_039")) {

				selenium.focus(elementCommentIcon);
			//selenium.clickAt(elementCommentIcon, "");
				assertTrue(click(selenium, elementCommentIcon),
						"Could not click on comments icon",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkLabSave),
						"Could not click on save button",selenium, ClassName, MethodName);
				if(isElementPresent(selenium,lnkEditComment)){
					assertTrue(click(selenium, lnkEditComment),
					"Could not click on comments icon",selenium, ClassName, MethodName);
					}
				assertTrue(
						type(selenium, elementCommentText, labData.comments),
						"Could not type comments",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkCancelComment),
						"Could not click on cancel button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkHideComment),
						"Could not click on hide comment link",selenium, ClassName, MethodName);
				assertTrue(click(selenium, elementCommentIcon),
						"Could not click on comments icon",selenium, ClassName, MethodName);
				if (getValue(selenium, elementCommentText)
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								labData.comments.trim().toLowerCase(
										new java.util.Locale("en", "US")))) {
					returnValue = false;
				}
				return returnValue;

			}
			if (labData.testCaseId.equals("TC_LR_010")) {

				assertTrue(click(selenium, elementCommentIcon),
						"Could not click on comments icon",selenium, ClassName, MethodName);
				assertTrue(click(selenium, elementCommentIconInResult),
				"Could not click on comments icon",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, elementCommentText, labData.comments),
						"Could not type comments",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkLabSave),
						"Could not click on save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkHideComment),
						"Could not click on hide comment link",selenium, ClassName, MethodName);
				assertTrue(click(selenium, elementCommentIconInResult),
				"Could not click on comments icon",selenium, ClassName, MethodName);
				if (!getValue(selenium, elementCommentText)
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								labData.comments.trim().toLowerCase(
										new java.util.Locale("en", "US")))) {
					returnValue = false;
				}
				return returnValue;

			}
			if (labData.testCaseId.equals("TC_LR_011")) {
				assertTrue(click(selenium, elementCommentIcon),
						"Could not click on comments icon",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementVisible(selenium,lnkEditComment))
				assertTrue(click(selenium, lnkEditComment),
				"Could not click on comments icon",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, elementCommentText, labData.comments),
						"Could not type comments",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkLabSave),
						"Could not click on save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium, lnkHideComment),
						"Could not click on hide comment link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				if (getValue(selenium, "elementCommentText")
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								labData.comments.trim().toLowerCase(
										new java.util.Locale("en", "US")))) {
					returnValue = false;
				}
				return returnValue;
			}
			return returnValue;
		} catch (RuntimeException e) {
			Assert.fail("Failed due to the Exception; \n Exception details: "
					+ e.getMessage());
			return false;
		}
	}

	public boolean verifyReportCommentsIconForLab(Selenium selenium,
			ChartPreVisitLib labData) throws IOException {
		boolean returnValue = false;

		try {
			waitForPageLoad(selenium);
			assertTrue(click(selenium, elementReportCommentsIcon),
					"Could not click on add comment icon",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(
					type(selenium, txtLabTestComments, labData.comments),
					"Could not type comments",selenium, ClassName, MethodName);
			if (labData.testCaseId.equals("TC_LR_015")) {
				assertTrue(click(selenium, lnkCancelComments1),
						"Could not click on cancel button",selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium,
						elementReportCommentsIcon),"",selenium, ClassName, MethodName);
				returnValue = true;
			}
			if (labData.testCaseId.equals("TC_LR_016")) {
				assertTrue(click(selenium, lnkSaveComments),
						"Could not click on save button",selenium, ClassName, MethodName);
				assertTrue(getValue(selenium, txtLabTestComments)
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								labData.comments.trim().toLowerCase(
										new java.util.Locale("en", "US"))),"Could not get the value",selenium, ClassName, MethodName);
				returnValue = true;
			}
			if (labData.testCaseId.equals("TC_LR_017")) {
				assertTrue(click(selenium, lnkSaveComments),
						"Could not click on save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkHideComments),
						"Could not click on hide comments",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,
						elementShowComments),"Element Not Present",selenium, ClassName, MethodName);
				returnValue = true;
			}
			if (labData.testCaseId.equals("TC_LR_018")) {
				assertTrue(click(selenium, lnkSaveComments),
						"Could not click on save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkCommentEdit),
						"Could not click on hide comments",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, txtLabTestComments, labData.notes),
						"Could not type comments",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkSaveComments),
						"Could not click on save button",selenium, ClassName, MethodName);
				assertTrue(getValue(selenium, txtLabTestComments)
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								labData.notes.trim().toLowerCase(
										new java.util.Locale("en", "US"))),"Could not get the Value",selenium, ClassName, MethodName);
				returnValue = true;
			}
			if (labData.testCaseId.equals("TC_LR_019")) {
				assertTrue(click(selenium, lnkSaveComments),
						"Could not click on save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, elementViewHistory),
						"Could not click on view history link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(getText(selenium,
						"css=div.borderBottomCCC.padding5px")
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								labData.comments.trim().toLowerCase(
										new java.util.Locale("en", "US"))),"Could not get the text",selenium, ClassName, MethodName);
				returnValue = true;
			}
			if (labData.testCaseId.equals("TC_LR_020")) {
				assertTrue(click(selenium, lnkSaveComments),
						"Could not click on save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkHideComments),
						"Could not click on hide comments",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, elementShowComments),
						"Could not click on show comments",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(getValue(selenium, txtLabTestComments)
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								labData.comments.trim().toLowerCase(
										new java.util.Locale("en", "US"))),"Could not get the value",selenium, ClassName, MethodName);
				returnValue = true;
			}
			if (labData.testCaseId.equals("TC_LR_021")) {
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkSaveComments),
						"Could not click on save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, elementViewHistory),
						"Could not click on view history link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, elementCancelComments2),
						"Could not click on cancel button",selenium, ClassName, MethodName);
				assertTrue(getValue(selenium, txtLabTestComments)
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								labData.comments.trim().toLowerCase(
										new java.util.Locale("en", "US"))),"Could not Get the value",selenium, ClassName, MethodName);
				returnValue = true;
			}
			return returnValue;
		} catch (RuntimeException e) {
			Assert.fail("Failed due to the Exception; \n Exception details: "
					+ e.getMessage());
			return false;
		}
	}


	/**
	 * orderNewReferral Function to order New Di
	 * @throws IOException 
	 * 
	 * @since Nov 15, 2012
	 */
	public boolean orderNewReferral(Selenium selenium,
			ChartPreVisitLib orderData) throws IOException {
		try {

			/*
			 * assertTrue(click(selenium,"labTestNameSuggestBox" ),
			 * "Could not click on test name suggest box");
			 * assertTrue(type(selenium,"labTestNameSuggestBox",
			 * orderData.labTestName),
			 * "Could not click on test name suggest box");
			 * waitForPageLoad(selenium);
			 */

			if (orderData.testCaseId.equals("TC_OR_004")) {
				assertTrue(click(selenium, btnReferral),
						"Could not click on save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (getText(selenium, lblNeedtoSelected)
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								"You need to select one test at least for saving the report!"
								.trim()
								.toLowerCase(
										new java.util.Locale("en", "US")))) {
					return true;
				} else
					return false;
			}
			if (orderData.testCaseId.equals("TC_OR_003")) {
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxSearchReferral,
						orderData.referral1);
				// assertTrue(type(selenium,ajxSearchReferral,orderData.referral1));
				selenium.keyPress(ajxSearchReferral, "\\13");
				assertTrue(click(selenium, btnReferral),
						"Could not click on save button",selenium, ClassName, MethodName);
				return true;
			}

			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxSearchReferral,
					orderData.referral1);
			// assertTrue(type(selenium,"referralSearchBox",orderData.referral1));
			selenium.keyPress(ajxSearchReferral, "\\13");
			waitForPageLoad(selenium);

			//			assertTrue(
			//					type(selenium, txtReferralNote, orderData.referralNoteText),
			//					"Could not type referral Notes");
			assertTrue(
					type(selenium, txtAuthcode, orderData.authorization),
					"Could not type comments",selenium, ClassName, MethodName);
			if (orderData.testCaseId.equals("TC_OR_005")) {
				assertTrue(click(selenium, btnRefSign),
						"Could not click on sign button",selenium, ClassName, MethodName);
				return true;
			}
			if(orderData.testCaseId.equals("TC_OR_006")){
				assertTrue(click(selenium, btnReferralCancel),"Could not click on sign button",selenium, ClassName, MethodName);
				return true;
			}
			assertTrue(selectValueFromAjaxList(selenium, ajxSelectTemplate, "Letter"),"Could not click on sign button",selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnReferral),
					"Could not click on save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			Assert.fail("Failed due to the Exception; \n Exception details: "
					+ e.getMessage());
			return false;
		}

	}


	public boolean unitTestForVitals(Selenium selenium,
			ChartPreVisitLibUnitTest vitalsData) throws IOException {
		boolean returnValue = true;
		try {
			assertTrue(click(selenium, lnkVitalShowmore),
					"Could not click on show more details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxHeight, vitalsData.heightMU);
			assertTrue(
					type(selenium, txtHeightInFeet, vitalsData.heightInFeet),
					"Could not type Hight in feet",selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtHeightIn, vitalsData.heightInCm),
					"Could not type Hight in cm or inches",selenium, ClassName, MethodName);

			// waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxWeight, vitalsData.weightMU);
			assertTrue(type(selenium, txtWeight, vitalsData.weight),
					"Could not type weight",selenium, ClassName, MethodName);

			// waitForPageLoad(selenium);
			assertTrue(
					type(selenium, txtSystolic, vitalsData.systolicRate),
					"Could not type systolic Rate",selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtdiastolic, vitalsData.diastolicRate),
					"Could not type diastolic Rate",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxPosition, vitalsData.position);
			// waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxLimb, vitalsData.limb);
			// waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxCuffsize, vitalsData.cuffSize);
			// waitForPageLoad(selenium);
			assertTrue(type(selenium, txtTime, vitalsData.time),
					"Could not type Blood pressure",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtheartRate, vitalsData.bPM),
					"Could not type Heart Rate",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxdescription,
					vitalsData.description);
			// waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxrhythm, vitalsData.rhythm);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtwaist, vitalsData.waist),
					"Could not type waist",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxWaist, vitalsData.waistMU);
			// waitForPageLoad(selenium);
			assertTrue(type(selenium, txtTemp, vitalsData.temperature),
					"Could not type temperature",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxTempUnit, vitalsData.tempRU);
			// waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxTempLocation,
					vitalsData.location);
			// waitForPageLoad(selenium);
			assertTrue(
					type(selenium, txtBloodSugar, vitalsData.bloodSuger),
					"Could not type blood sugar",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxBloodSugar, vitalsData.bSUnit);
			// waitForPageLoad(selenium);
			assertTrue(
					type(selenium, txtRespiratory, vitalsData.repositoryRate),
					"Could not type blood sugar",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxRespiratory, vitalsData.rR_BPM);
			// waitForPageLoad(selenium);
			assertTrue(
					type(selenium, txtOxygen, vitalsData.oxygenSaturation),
					"Could not type oxygen saturation",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtPefr, vitalsData.pEFR),
					"Could not type pefr",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxPefr,
					vitalsData.pre_bronchodilator);
			// waitForPageLoad(selenium);
			assertTrue(click(selenium, btnAdd),
					"Could not click on add button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;
		} catch (RuntimeException e) {
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}

	/**
	 * goToEncounterMedicationIcon function to goToEncounterMedicationIcon
	 * @throws IOException 
	 * 
	 * @since Dec 04, 2012
	 */
	public boolean goToEncounterMedicationIcon(Selenium selenium) throws IOException {
		waitForPageLoad(selenium);
		assertTrue(click(selenium, BeginEncounter),
				"Could not find link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, imgPrescribeMedsIcon),
				"Could not click the link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if (isElementPresent(selenium, "drugsSuggestBox"))
			return true;
		else
			return false;

	}

	public boolean fileReportwithSearch(Selenium selenium, ChartPreVisitLib labData,String account, String uniqueAccNumber) throws IOException{
		assertTrue(click(selenium,lnkEnterData),"Could not click the Enter Data link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		

		assertTrue(type(selenium, elementaccNumber, uniqueAccNumber),"Could not type accession number",selenium, ClassName, MethodName);
		labData.accNumber = uniqueAccNumber;

		ChartPreVisitLib labData1 = new ChartPreVisitLib();
		labData1.workSheetName = "FileLabReport";
		labData1.testCaseId = "TC_LR_002";
		labData1.fetchChartPreVisitTestData();
		
		if(account.equals(CAAccount)){
			selectValueFromAjaxList(selenium, ajxLabName, labData1.labNameCA);
		}else
			selectValueFromAjaxList(selenium, ajxLabName, labData1.labName);
		waitForPageLoad(selenium);
		if (account.equals(CAAccount)) {
			Calendar cal1 = Calendar.getInstance();
			SimpleDateFormat DateFormat1 = new SimpleDateFormat(
					"dd/MM/yyyy");
			date = DateFormat1.format(cal1.getTime());
			assertTrue(enterDate(selenium, elementCdate, date),
					"Could not enter the collrction Date;More Details:"
							+ labData1.toString(),selenium, ClassName, MethodName);
		} else {
			Calendar cal1 = Calendar.getInstance();
			SimpleDateFormat DateFormat1 = new SimpleDateFormat(
					"MM/dd/yyyy");
			date = DateFormat1.format(cal1.getTime());
			assertTrue(enterDate(selenium, elementCdate, date),
					"Could not enter the collrction Date;More Details:"
							+ labData1.toString(),selenium, ClassName, MethodName);
		}
		assertTrue(type(selenium, elementCtime, labData1.cTime),
				"Could not type time",selenium, ClassName, MethodName);
		
		assertTrue(type(selenium, elementResult, labData1.result),
				"Could not type results",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnsaveProvider),"Could not click the Save button in File New Report", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		
		
		return true;
	}
	/**
	 * fileReport function to goToEncounterMedicationIcon
	 * @throws IOException 
	 * 
	 * @since Dec 07, 2012
	 */
	public boolean fileReport(Selenium selenium, ChartPreVisitLib labData,
			String account) throws IOException {
		String date = null;

		try {

			String providerNameTemp = getText(selenium, lnkTopMenu);
			String pName = providerNameTemp.toLowerCase().replaceAll(", "
					+ labData.switchRole.toLowerCase(), "");
			String tempArray[] = pName.split(" ");
			String providerName = tempArray[1] + ", " + tempArray[0];

			labData.rProvider = providerName;

			if(selenium.isConfirmationPresent()){
                System.out.println(selenium.getConfirmation());
                selenium.chooseOkOnNextConfirmation();        }
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkEnterData),
					"Could not find enter data link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if (labData.testCaseId.equals("TC_LR_005")
					|| labData.testCaseId.equals("TC_LR_012")
					|| labData.testCaseId.equals("TC_LR_038")) {
				assertTrue(click(selenium, elementPartial),
						"Could not find partial radio button",selenium, ClassName, MethodName);
			}

			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat(
					"dd-MM-yyyy HH:mm");
			String uniqueAccNumber = DateFormat.format(cal.getTime());

			assertTrue(
					type(selenium, elementaccNumber, uniqueAccNumber),
					"Could not type accession number",selenium, ClassName, MethodName);
			if (isElementPresent(selenium, btnOk)) {
				assertTrue(click(selenium, btnOk),
						"Could not click the ok Button",selenium, ClassName, MethodName);
			}

			selectValueFromAjaxList(selenium, ajxRProvider, labData.rProvider);

			selectValueFromAjaxList(selenium, ajxOProvider, labData.oProvider);

			if(account.equals(CAAccount)){
				selectValueFromAjaxList(selenium, ajxLabName, labData.labNameCA);
			}else
				selectValueFromAjaxList(selenium, ajxLabName, labData.labName);
			waitForPageLoad(selenium);
			if (account.equals(CAAccount)) {
				Calendar cal1 = Calendar.getInstance();
				SimpleDateFormat DateFormat1 = new SimpleDateFormat(
						"dd/MM/yyyy");
				date = DateFormat1.format(cal1.getTime());
				assertTrue(enterDate(selenium, elementCdate, date),
						"Could not enter the collrction Date;More Details:"
								+ labData.toString(),selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium, elementOdate, "28/10/2014"),
						"Could not enter the Order Date;More Details:"
								+ labData.toString(),selenium, ClassName, MethodName);
				
			} else {
				Calendar cal1 = Calendar.getInstance();
				SimpleDateFormat DateFormat1 = new SimpleDateFormat(
						"MM/dd/yyyy");
				date = DateFormat1.format(cal1.getTime());
				assertTrue(enterDate(selenium, elementCdate, date),
						"Could not enter the collrction Date;More Details:"
								+ labData.toString(),selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium, elementOdate, "10/28/2014"),
						"Could not enter the Order Date;More Details:"
								+ labData.toString(),selenium, ClassName, MethodName);
			}
			assertTrue(type(selenium, elementCtime, labData.cTime),
					"Could not type time",selenium, ClassName, MethodName);
			assertTrue(type(selenium, elementNotes, labData.notes),
					"Could not type notes",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxLabTestName, labData.testName);

			if (labData.testCaseId.equals("TC_LR_009")
					|| labData.testCaseId.equals("TC_LR_031"))
				if (isChecked(selenium,
						"//span[@id='labTestResultAbnormal']/input"))
					assertTrue(
							click(selenium,
									"//span[@id='labTestResultAbnormal']/input"),
							"Could not click abnormal check box",selenium, ClassName, MethodName);

			assertTrue(type(selenium, elementResult, labData.result),
					"Could not type results",selenium, ClassName, MethodName);
			assertTrue(type(selenium, elementLow, labData.low),
					"Could not type low",selenium, ClassName, MethodName);
			assertTrue(type(selenium, elementHigh, labData.high),
					"Could not type high",selenium, ClassName, MethodName);
			assertTrue(type(selenium, elementUnits, labData.units),
					"Could not type units",selenium, ClassName, MethodName);
			assertTrue(type(selenium, elementComment, labData.comments),
					"Could not type comments",selenium, ClassName, MethodName);

			if (labData.testCaseId.equals("TC_LR_005")) {
				assertTrue(click(selenium, elementAddTestResult),
						"Could not find add test result button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, elementLabTestName1,
						labData.testName);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, elementResult1, labData.result),
						"Could not type results",selenium, ClassName, MethodName);
				assertTrue(type(selenium, elementLow1, labData.low),
						"Could not type low",selenium, ClassName, MethodName);
				assertTrue(type(selenium, elementHigh1, labData.high),
						"Could not type high",selenium, ClassName, MethodName);
				assertTrue(type(selenium, elementUnits1, labData.units),
						"Could not type units",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, elementComment1, labData.comments),
						"Could not type comments",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if (labData.testCaseId.equals("TC_LR_032")
					|| labData.testCaseId.equals("TC_LR_033")
					|| labData.testCaseId.equals("TC_LR_034")
					|| labData.testCaseId.equals("TC_LR_035")) {
				assertTrue(click(selenium, elementAddTestResult),
						"Could not find add test result button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, elementLabTestName1,
						labData.testName1);
				waitForPageLoad(selenium);
				assertTrue(
						type(selenium, elementResult1, labData.comments),
						"Could not type results",selenium, ClassName, MethodName);
				assertTrue(type(selenium, elementLow1, labData.low),
						"Could not type low",selenium, ClassName, MethodName);
				assertTrue(type(selenium, elementHigh1, labData.high),
						"Could not type high",selenium, ClassName, MethodName);
				assertTrue(type(selenium, elementUnits1, labData.units),
						"Could not type units",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, elementComment1, labData.comments),
						"Could not type comments",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			waitForPageLoad(selenium);
			if (labData.testCaseId.equals("TC_LR_001")
					|| labData.testCaseId.equals("TC_LR_002")
					|| labData.testCaseId.equals("TC_LR_005")
					|| labData.testCaseId.equals("TC_LR_006")
					|| labData.testCaseId.equals("TC_LR_009")
					|| labData.testCaseId.equals("TC_LR_010")
					|| labData.testCaseId.equals("TC_LR_011")
					|| labData.testCaseId.equals("TC_LR_012")
					|| labData.testCaseId.equals("TC_LR_013")
					|| labData.testCaseId.equals("TC_LR_022")
					|| labData.testCaseId.equals("TC_LR_023")
					|| labData.testCaseId.equals("TC_LR_015")
					|| labData.testCaseId.equals("TC_LR_016")
					|| labData.testCaseId.equals("TC_LR_017")
					|| labData.testCaseId.equals("TC_LR_018")
					|| labData.testCaseId.equals("TC_LR_019")
					|| labData.testCaseId.equals("TC_LR_024")
					|| labData.testCaseId.equals("TC_LR_020")
					|| labData.testCaseId.equals("TC_LR_021")
					|| labData.testCaseId.equals("TC_LR_022")
					|| labData.testCaseId.equals("TC_LR_028")
					|| labData.testCaseId.equals("TC_LR_030")
					|| labData.testCaseId.equals("TC_LR_032")
					|| labData.testCaseId.equals("TC_LR_033")
					|| labData.testCaseId.equals("TC_LR_034")
					|| labData.testCaseId.equals("TC_LR_035")
					|| labData.testCaseId.equals("TC_LR_036")
					|| labData.testCaseId.equals("TC_LR_037")
					|| labData.testCaseId.equals("TC_LR_038")
					|| labData.testCaseId.equals("TC_LR_039")
					|| labData.testCaseId.equals("TC_LR_039")
					|| labData.testCaseId.equals("TC_LR_041")
					|| labData.testCaseId.equals("TC_LR_040")
					|| labData.testCaseId.equals("TC_LR_042")
					|| labData.testCaseId.equals("TC_LR_043")
					|| labData.testCaseId.equals("TC_LR_044")
					|| labData.testCaseId.equals("TC_LR_045")
					|| labData.testCaseId.equals("TC_LR_029")
					|| labData.testCaseId.equals("TC_LR_048")) {
				Thread.sleep(10000);
				assertTrue(click(selenium, btnSave2),
						"Could not find save button",selenium, ClassName, MethodName);
				Thread.sleep(10000);
			} else if (labData.testCaseId.equals("TC_LR_003")) {
				assertTrue(click(selenium, elementDeleteTestResult),
						"Could not find delete button",selenium, ClassName, MethodName);
			} else if (labData.testCaseId.equals("TC_LR_004")
					|| labData.testCaseId.equals("TC_LR_046")) {
				assertTrue(click(selenium, btnSign),
						"Could not find sign button",selenium, ClassName, MethodName);
			} else if (labData.testCaseId.equals("TC_LR_007")) {
				assertTrue(click(selenium, btnResendCancel),
						"Could not find sign button",selenium, ClassName, MethodName);
			} else if (labData.testCaseId.equals("TC_LR_047")) {
				assertTrue(click(selenium, "saveAndNext"),
						"Couldnot click the save and Next button",selenium, ClassName, MethodName);
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}




	/**
	 * fileReportWithMandatory function to file Report With Mandatory
	 * @throws IOException 
	 * 
	 * @since Dec 07, 2012
	 */
	public boolean fileReportWithMandatory(Selenium selenium,
			ChartPreVisitLib labData, String account) throws IOException {
		String date = null;
		if (account.equals(CAAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = DateFormat.format(cal.getTime());

		} else {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat.format(cal.getTime());

		}			
		assertTrue(click(selenium, lnkEnterData),
				"Could not find enter data link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		if(selenium.isElementPresent("Continue")){
			waitForPageLoad(selenium);
			selenium.click("Continue");
		}


		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		String str = getText(selenium, lnkTopMenu);
		String Rprovider = str.replaceAll(", " + labData.switchRole, "");

		String tempArray[] = Rprovider.split(" ");
		String providerName = tempArray[1] + ", " + tempArray[0];

		if (!labData.testCaseId.equalsIgnoreCase("TC_LR_046")) {
			selectValueFromAjaxList(selenium, ajxRProvider, providerName);
		} else {
			selectValueFromAjaxList(selenium, ajxRProvider, labData.oProvider);
		}
		waitForPageLoad(selenium);

		selectValueFromAjaxList(selenium, ajxOProvider, labData.oProvider);
		waitForPageLoad(selenium);
		if(account.equals(CAAccount)){
			selectValueFromAjaxList(selenium, ajxLabName, labData.labNameCA);
		}else
			selectValueFromAjaxList(selenium, ajxLabName, labData.labName);
		waitForPageLoad(selenium);

		assertTrue(
				enterDate(selenium, elementCdate, date),
				"Could not enter the collrction Date;More Details:"
						+ labData.toString(),selenium, ClassName, MethodName);
		assertTrue(type(selenium, elementCtime, labData.cTime),
				"Could not type time",selenium, ClassName, MethodName);
		selenium.type(ajxLabTestName, "");
		type(selenium, ajxLabTestName, labData.testName);
		selenium.fireEvent(ajxLabTestName,"keydown");
		selenium.fireEvent(ajxLabTestName,"keypress");                           
		selenium.fireEvent(ajxLabTestName,"keyup");
		selenium.keyPress(ajxLabTestName, "\\13");
		selenium.clickAt(ajxLabTestName, "");
		waitForPageLoad(selenium);
		assertTrue(click(selenium,"currentItem_1"),"unable to select the lab test name",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, elementResult, labData.result),
				"Could not type results",selenium, ClassName, MethodName);waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSave2),
				"Could not find save button",selenium, ClassName, MethodName);

		return true;

	}


	/**
	 * deletelabReport function to delete lab report
	 * @throws IOException 
	 * 
	 * @since Dec 07, 2012
	 */
	public boolean deletelabReport(Selenium selenium, ChartPreVisitLib labData) throws IOException {

		assertTrue(click(selenium,lnkLabs),
				"Could not click on Lab Report link link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		clickAt(selenium,lnkLabs,"");
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkLabListView),
				"Could not click the List view",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(selenium.isConfirmationPresent()){
			System.out.println(selenium.getConfirmation());
			selenium.chooseOkOnNextConfirmation();    }
		while (isElementPresent(selenium, btnActionLab)) {
			int count = 1;
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnActionLab),
					"Could Click Action Button",selenium, ClassName, MethodName);

			waitForPageLoad(selenium);;
if(isElementPresent(selenium,"xpath=(//div[contains(@id,'delete')])"))
{
	 assertTrue(click(selenium,"xpath=(//div[contains(@id,'delete')])"),"Creation Failed", selenium, ClassName, MethodName);
		}
else if (getText(selenium, "//body/div[5]/div/div/div[3]").contains(
					"Delete")) {
			assertTrue(
						click(selenium, "//body/div[5]/div/div/div[3]"),
						"Could Click delete Button", selenium, ClassName, MethodName);
	
			} else if (getText(selenium, "//body/div[4]/div/div/div").contains(
					"Delete")) {
			assertTrue(click(selenium, "//body/div[4]/div/div/div"),
						"Could Click delete Button", selenium, ClassName, MethodName);
			} else if (getText(selenium, "//body/div[4]/div/div/div[2]")
					.contains("Delete")) {
		assertTrue(
						click(selenium, "//body/div[4]/div/div/div[2]"),
						"Could Click delete Button", selenium, ClassName, MethodName);
			} else if (getText(selenium, "//body/div[5]/div/div/div[2]")
					.contains("Delete")) {
		assertTrue(
						click(selenium, "//body/div[5]/div/div/div[2]"),
						"Could Click delete Button", selenium, ClassName, MethodName);
			} else if (getText(selenium, "//body/div[5]/div/div/div").contains(
					"Delete"))
		assertTrue(click(selenium, "//body/div[5]/div/div/div"),
						"Could Click delete Button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
			assertTrue(type(selenium, txtdeleteReason, "Reason"),
					"Could not type reason", selenium, ClassName, MethodName);
			click(selenium, btnDeleteReason);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkLabs),
					"Could not click on Lab Report link link",selenium, ClassName, MethodName);
		clickAt(selenium,lnkLabs,"");
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkLabListView),
					"Could not click the List view",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			count++;
			if (count > 15) {
				break;
			}
		}
		return true;

	}



	/**
	 * fileReportUnitTest function to goToEncounterMedicationIcon
	 * @throws IOException 
	 * 
	 * @since Dec 10, 2012
	 */
	public boolean fileReportUnitTest(Selenium selenium,
			ChartPreVisitLibUnitTest labData) throws IOException {
		assertTrue(click(selenium, lnkEnterData),
				"Could not find enter data link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, elementaccNumber, labData.accNumber),
				"Could not type accession number",selenium, ClassName, MethodName);
		selectValueFromAjaxList(selenium, ajxRProvider, labData.rProvider);
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium, ajxOProvider, labData.oProvider);
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium, ajxLabName, labData.labName);
		waitForPageLoad(selenium);
		assertTrue(
				enterDate(selenium, elementCdate, labData.cDate),
				"Could not enter the collrction Date;More Details:"
						+ labData.toString(),selenium, ClassName, MethodName);
		assertTrue(type(selenium, elementCtime, labData.cTime),
				"Could not type time",selenium, ClassName, MethodName);
		assertTrue(type(selenium, elementNotes, labData.notes),
				"Could not type notes",selenium, ClassName, MethodName);
		selectValueFromAjaxList(selenium, ajxLabTestName, labData.testName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, elementResult, labData.result),
				"Could not type results",selenium, ClassName, MethodName);
		assertTrue(type(selenium, elementLow, labData.low),
				"Could not type low",selenium, ClassName, MethodName);
		assertTrue(type(selenium, elementHigh, labData.high),
				"Could not type high",selenium, ClassName, MethodName);
		assertTrue(type(selenium, elementUnits, labData.units),
				"Could not type units",selenium, ClassName, MethodName);
		assertTrue(type(selenium, elementComment, labData.comments),
				"Could not type comments",selenium, ClassName, MethodName);
		assertTrue(click(selenium, btnSave),
				"Could not find click save button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		return true;

	}

	/**
	 * navigateTofileReport function to navigate To file Report
	 * @throws IOException 
	 * 
	 * @since Dec 07, 2012
	 */
	public boolean navigateTofileReport(Selenium selenium,
			ChartPreVisitLib labData)  {

		try {
			assertTrue(click(selenium, lnkPatientOption),
					"Could not click on patient options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.isVisible(lnkLabReportLink);
			assertTrue(click(selenium, lnkLabReportLink),
					"Could not click on file new report link",selenium, ClassName, MethodName);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		

	}

	/**
	 * verifyGraphForHideDetailsInVitals function to goToEncounterMedicationIcon
	 * @throws IOException 
	 * 
	 * @since Dec 04, 2012
	 */
	public boolean verifyGraphForHideDetailsInVitals(Selenium selenium,
			ChartPreVisitLib vitalsData) throws IOException {
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblExport7),
				"Could not click height check box",selenium, ClassName, MethodName);
		assertTrue(click(selenium, "//tr[2]/td/div/input"),
				"Could not click weight check box",selenium, ClassName, MethodName);
		assertTrue(click(selenium, "//tr[4]/td/div/input"),
				"Could not click BP check box",selenium, ClassName, MethodName);
		assertTrue(click(selenium, "//tr[5]/td/div/input"),
				"Could not click Heart Rate check box",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, "graph"),
				"Could not click Heart Rate check box",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		click(selenium, "okButton");
		assertTrue(isElementPresent(selenium, "css=div.gwt-Label"),
				"Could not find the height graph",selenium, ClassName, MethodName);
		assertTrue(
				isElementPresent(selenium,
						"//div[3]/div[2]/div[2]/div[2]/div[2]/div"),
				"Could not find the weight graph",selenium, ClassName, MethodName);
		assertTrue(
				isElementPresent(selenium, "//div[2]/div[3]/div[2]/div"),
				"Could not find the heart rate graph",selenium, ClassName, MethodName);
		assertTrue(
				isElementPresent(selenium, "//div[2]/div[4]/div[2]/div"),
				"Could not find the BP graph",selenium, ClassName, MethodName);

		assertTrue(selenium.isTextPresent(vitalsData.graph1), "" 	+ "Could not find the BP graph1", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//assertTrue(getText(selenium, "//div[2]/div[4]/div[2]/div").contains(vitalsData.graph1), "Could not find the BP graph");
		assertTrue(selenium.isTextPresent(vitalsData.graph2), "" 	+ "Could not find the BP graph2", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//assertTrue(getText(selenium, "//div[2]/div[3]/div[2]/div").contains(vitalsData.graph2), "Could not find the weight graph");
		assertTrue(selenium.isTextPresent(vitalsData.graph3), "" 	+ "Could not find the BP graph3", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//assertTrue(getText(selenium, "//div[3]/div[2]/div[2]/div/div[2]/div").contains(vitalsData.graph3),"Could not find the heart rate graph");
		assertTrue(selenium.isTextPresent(vitalsData.graph4), "" 	+ "Could not find the BP graph4", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//assertTrue(getText(selenium, "//div[3]/div[2]/div[2]/div[2]/div[2]/div")	.contains(vitalsData.graph4),"Could not find the Height graph");
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		return true;
	}

	/**
	 * navigateTofileReportUnitTest function to navigate To file Report
	 * @throws IOException 
	 * 
	 * @since Dec 10, 2012
	 */
	public boolean navigateTofileReportUnitTest(Selenium selenium,
			ChartPreVisitLibUnitTest labData) throws IOException {
		assertTrue(click(selenium, lnkPatientOption),
				"Could not click on patient options link",selenium, ClassName, MethodName);
		assertTrue(click(selenium, lnkLabReportLink),
				"Could not click on file new report link",selenium, ClassName, MethodName);
		return true;

	}

	/**
	 * verifyGraphForFullDetailsInVitals function to goToEncounterMedicationIcon
	 * @throws IOException 
	 * 
	 * @since Dec 11, 2012
	 */
	public boolean verifyGraphForFullDetailsInVitals(Selenium selenium,
			ChartPreVisitLib vitalsData) throws IOException {
		waitForPageLoad(selenium);

		assertTrue(click(selenium, "//tr[4]/td/div/input"),
				"Could not click BP check box",selenium, ClassName, MethodName);
		assertTrue(click(selenium, "//tr[5]/td/div/input"),
				"Could not click heartrate check box",selenium, ClassName, MethodName);
		assertTrue(click(selenium, "//tr[6]/td/div/input"),
				"Could not click temperature check box",selenium, ClassName, MethodName);
		assertTrue(click(selenium, "//tr[7]/td/div/input"),
				"Could not click blood sugar check box",selenium, ClassName, MethodName);
		assertTrue(click(selenium, "//tr[8]/td/div/input"),
				"Could not click PEFR check box",selenium, ClassName, MethodName);

		assertTrue(click(selenium, "//tr[9]/td/div/input"),
				"Could not click Oxygen Saturation check box",selenium, ClassName, MethodName);
		assertTrue(click(selenium, "//tr[10]/td/div/input"),
				"Could not click Respiratory check box",selenium, ClassName, MethodName);

		waitForPageLoad(selenium);
		assertTrue(click(selenium, "graph"),
				"Could not click Heart Rate check box",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium, graph),
				"Could not find the temp  graph",selenium, ClassName, MethodName);
		assertTrue(
				isElementPresent(selenium, lblWeightInGraph),
				"Could not find the Oxy Sat graph",selenium, ClassName, MethodName);
		assertTrue(
				isElementPresent(selenium, lblHeightInGraph),
				"Could not find the Respiratory graph",selenium, ClassName, MethodName);
		assertTrue(
				isElementPresent(selenium, lblLbsInGraph),
				"Could not find the temp graph",selenium, ClassName, MethodName);
		assertTrue(
				isElementPresent(selenium, lblBmiInGraph),
				"Could not find the heartrate  graph",selenium, ClassName, MethodName);

		assertTrue(
				selenium.isTextPresent(
						vitalsData.graph1), "Could not find the PERF graph",selenium, ClassName, MethodName);
		assertTrue(
				selenium.isTextPresent(
						vitalsData.graph2), "Could not find the Oxy Sat graph",selenium, ClassName, MethodName);
		assertTrue(
				selenium.isTextPresent(
						vitalsData.graph3),
				"Could not find the Respiratory graph",selenium, ClassName, MethodName);

		assertTrue(
				selenium.isTextPresent(
						vitalsData.graph4),
				"Could not find the blood sugar graph",selenium, ClassName, MethodName);
		assertTrue(
				selenium.isTextPresent(
						vitalsData.graph5), "Could not find the temp graph",selenium, ClassName, MethodName);

		assertTrue(
				selenium.isTextPresent(
						vitalsData.graph6),
				"Could not find the heart rate graph",selenium, ClassName, MethodName);
		assertTrue(
				selenium.isTextPresent(
						vitalsData.graph7),
				"Could not find the blood pressure graph",selenium, ClassName, MethodName);

		waitForPageLoad(selenium);
		return true;
	}

	/**
	 * deleteSinglelabReport function to delete lab report
	 * @throws IOException 
	 * 
	 * @since Dec 07, 2012
	 */
	public boolean deleteSinglelabReport(Selenium selenium,
			ChartPreVisitLib labData) throws IOException {
		assertTrue(click(selenium, lnkLabReport),
				"Could not click on Lab Report link link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkLabListView),
				"Could not click the List view",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		while (isElementPresent(selenium, btnActionLab)) {
			int count = 1;
			assertTrue(click(selenium, btnActionLab),
					"Could Click Action Button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);

			if (getText(selenium, "//body/div[5]/div/div/div[3]").contains(
					"Delete")) {
				assertTrue(
						click(selenium, "//body/div[5]/div/div/div[3]"),
						"Could Click delete Button",selenium, ClassName, MethodName);
			} else if (getText(selenium, "//body/div[4]/div/div/div").contains(
					"Delete")) {
				assertTrue(click(selenium, "//body/div[4]/div/div/div"),
						"Could Click delete Button",selenium, ClassName, MethodName);
			} else if (getText(selenium, "//body/div[4]/div/div/div[2]")
					.contains("Delete")) {
				assertTrue(
						click(selenium, "//body/div[4]/div/div/div[2]"),
						"Could Click delete Button",selenium, ClassName, MethodName);
			} else if (getText(selenium, "//body/div[5]/div/div/div[2]")
					.contains("Delete")) {
				assertTrue(
						click(selenium, "//body/div[5]/div/div/div[2]"),
						"Could Click delete Button",selenium, ClassName, MethodName);
			} else if (getText(selenium, "//body/div[5]/div/div/div").contains(
					"Delete"))
				assertTrue(click(selenium, "//body/div[5]/div/div/div"),
						"Could Click delete Button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtdeleteReason, "Reason"),
					"Could not type reason",selenium, ClassName, MethodName);
			click(selenium, btnDeleteReason);
			waitForPageLoad(selenium);
			if (count == 1) {
				break;
			}
		}
		return true;

	}

	/**
	 * verifyLabReport function to verify Lab Report
	 * @throws IOException 
	 * 
	 * @since August 12, 2013
	 */
	public boolean verifyLabReport(Selenium selenium, ChartPreVisitLib labData) throws IOException {

		/*
		 * assertTrue(click(selenium,labReportlist),
		 * "Could not click on Lab Reports link"); waitForPageLoad(selenium);
		 */

		assertTrue(click(selenium, lnkMore),"Could not click on Lab Report linkMore link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkLabReport),
				"Could not click on Lab Report link link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkLabListView),
				"Could not click the List view",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		if (selenium.isElementPresent(elementLabReportEntry)) {

			assertTrue(click(selenium, elementLabReportEntry),
					"Could not click on Unsigned Lab Reports link",selenium, ClassName, MethodName);

		} else if (selenium.isElementPresent(elementLabReportEntry1)) {

			assertTrue(click(selenium, elementLabReportEntry1),
					"Could not click on Unsigned Lab Reports link",selenium, ClassName, MethodName);

		}

		// assertTrue(click(selenium,elementLabReportEntry),
		// "Could not click on Unsigned Lab Reports link");
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkShowLabReport),
				"Could not click on link -- Show Lab report information",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(labData.providerID),"ProviderID not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		if (labData.testCaseId.equals("TC_ELR_004")) {

			assertTrue(selenium.isTextPresent(labData.ssNumber),"ssNumber Not Present",selenium, ClassName, MethodName);
		} else

		{
			//assertTrue(selenium.isTextPresent(labData.patientHCN));
			assertTrue(selenium.isTextPresent(labData.patientHCN),"patientHCN not Present", selenium, ClassName, MethodName);


		}
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(labData.labTest),"LabTest Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		if (!labData.testCaseId.equals("TC_ELR_004")) {
			assertTrue(selenium.isTextPresent(labData.labTest1),"LabTest1 Not Present" ,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}

		assertTrue(selenium.isTextPresent(labData.facilityName),"facilityName not Present",selenium, ClassName, MethodName);

		return true;
	}

	/**
	 * verifyLabHistory function to verify Lab History
	 * 
	 * @throws IOException
	 * @since August 15, 2013
	 */
	public boolean verifyLabHistory(Selenium selenium, ChartPreVisitLib labData)
			throws IOException {

		assertTrue(click(selenium, lnkMore),
				"Could not click on Lab Report linkMore link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkLabReport),
				"Could not click on Lab Report link link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkLabListView),
				"Could not click the List view",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		if (labData.testCaseId.equals("TC_ELR_005")
				|| labData.testCaseId.equals("TC_ELR_006")) {
			assertTrue(deleteSinglelabReport(selenium, labData),
					"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}

		assertTrue(click(selenium, elementLabReportEntry),
				"Could not click on Unsigned Lab Reports link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(click(selenium, lnkBeginEncounterAction),
				"Could not click on Action",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(click(selenium, lnklabHistoryReports),
				"Could not click on the link - Lab History",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(labData.labTest),"Text Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		if (!labData.testCaseId.equals("TC_ELR_004")) {
			assertTrue(selenium.isTextPresent(labData.labTest1),"Text Not Present",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}

		Assert.assertEquals(
				selenium.getXpathCount("//*[contains(text(), 'Normal')]"), 2);

		return true;
	}
	
	/**
     * Generates SFTP URL connection String
     * 
     * @param hostName
     *            HostName of the server
     * @param username
     *            UserName to login
     * @param password
     *            Password to login
     * @param remoteFilePath
     *            remoteFilePath. Should contain the entire remote file path -
     *            Directory and Filename with / as separator
     * @return concatenated SFTP URL string
     */
    public static String createConnectionString(String hostName, String username, String password, String remoteFilePath) {
        //return "sftp://" + username + ":" + password + "@" + hostName + "/" + remoteFilePath;
        return "sftp://" + username + ":" + password + "@" + hostName + remoteFilePath;
    }
	
	

	 public boolean ftpFileUpload1(Selenium selenium, String webSite,
				ChartPreVisitLib ElabData) throws MalformedURLException,
				IOException	 {
		 
		     boolean returnValue = false;
		     String strBasePath = null;
			 String filepath = null;

		     File dir1 = new File(".");
				strBasePath = dir1.getCanonicalPath();
		     
		     filepath = strBasePath + File.separator + "src" + File.separator
						+ "main" + File.separator + "resources" + File.separator
						+ "nexia" + File.separator + "testdata" + File.separator
						+ "hl7" + File.separator + ElabData.sourcePath;
	        File file = new File(filepath);
	        
	        
	        if (!file.exists())
	            throw new RuntimeException("Error. Local file not found");

	        StandardFileSystemManager manager = new StandardFileSystemManager();

	        try {
	            manager.init();

	            // Create local file object
	            FileObject localFile = manager.resolveFile(file.getAbsolutePath());

	            // Create remote file object
	            System.out.println(ElabData.ftpPasswordStage);
	            FileObject remoteFile = manager.resolveFile(createConnectionString(ElabData.ftpHost, ElabData.ftpUserStage, ElabData.ftpPasswordStage, ElabData.destDir), createDefaultOptions());
	            
	            /*
	             * use createDefaultOptions() in place of fsOptions for all default
	             * options - Ashok.
	             */

	            // Copy local file to sftp server
	            remoteFile.copyFrom(localFile, Selectors.SELECT_SELF);

	            System.out.println("File upload success");
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        } finally {
	            manager.close();
	        }
	        
	        return returnValue;
	    }

		
	 /**
	     * Method to setup default SFTP config
	     * 
	     * @return the FileSystemOptions object containing the specified
	     *         configuration options
	     * @throws FileSystemException
	     */
	    public static FileSystemOptions createDefaultOptions() throws Exception {
	        // Create SFTP options
	        FileSystemOptions opts = new FileSystemOptions();

	        // SSH Key checking
	        try {
				SftpFileSystemConfigBuilder.getInstance().setStrictHostKeyChecking(opts, "no");
			} catch (org.apache.commons.vfs2.FileSystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	        		
	        /*
	         * Using the following line will cause VFS to choose File System's Root
	         * as VFS's root. If I wanted to use User's home as VFS's root then set
	         * 2nd method parameter to "true"
	         */
	        // Root directory set to user home
	        SftpFileSystemConfigBuilder.getInstance().setUserDirIsRoot(opts, false);

	        // Timeout is count by Milliseconds
	        SftpFileSystemConfigBuilder.getInstance().setTimeout(opts, 10000);

	        return opts;
	    }
	
	
	
	
	/**
	 * ftpFileUpload function to ftp File Upload
	 * 
	 * @since August 07, 2013
	 */
	public boolean ftpFileUpload(Selenium selenium, String webSite,
			ChartPreVisitLib ElabData) throws MalformedURLException,
			IOException {
		boolean returnValue = false;
		String strBasePath = null;
		String file = null;

		try {
		
			
			FTPClient ftp = null;

			ftp = new FTPClient();
			ftp.addProtocolCommandListener(new PrintCommandListener(
					new PrintWriter(System.out)));
			int reply;
			System.out.println(webSite);
			if (webSite == "https://10.33.1.84:8443/") {
				System.out.println(webSite);
				ftp.connect(ElabData.ftpHostStage);
			} else {
				ftp.connect(ElabData.ftpHost);
			}

			// ftp.connect(ElabData.ftpHost);
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				throw new Exception("Exception in connecting to FTP Server");
			}

			if (webSite == "https://10.33.1.84:8443/") {
				ftp.login(ElabData.ftpUserStage, ElabData.ftpPasswordStage);
			} else {
				ftp.login(ElabData.ftpUser, ElabData.ftpPassword);
			}

			// ftp.setFileType(FTP.BINARY_FILE_TYPE);
			ftp.enterLocalPassiveMode();

			File dir1 = new File(".");
			strBasePath = dir1.getCanonicalPath();

			file = strBasePath + File.separator + "src" + File.separator
					+ "main" + File.separator + "resources" + File.separator
					+ "nexia" + File.separator + "testdata" + File.separator
					+ "hl7" + File.separator + ElabData.sourcePath;

			InputStream input = new FileInputStream(new File(file));

			try {

				String destination = ElabData.destDir;
				if (destination.endsWith("/")) {
					destination += today() + "-"
							+ new File(ElabData.sourcePath).getName();

				}
				ftp.storeFile(destination, input);
				System.out.println("Stored " + ElabData.sourcePath + " to "
						+ destination + ".");
			} finally {
				input.close();
			}

			ftp.logout();
			ftp.disconnect();

		}

		catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"
					+ e.getMessage() + "\n\t*); Detailed data:");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return returnValue;
	}

	/**
	 * createAssessment function to navigate To file Report
	 * @throws IOException 
	 * 
	 * @since Dec 10, 2012
	 */
	public boolean createAssessment(Selenium selenium,
			ChartPreVisitLib orderData, String account) throws IOException {
		String date = null;

		int count = 0;
		while (isElementPresent(selenium, lblHighlightAssessment)) {

			selectValueFromAjaxList(selenium, lblHighlightAssessment,
					orderData.medical);
			waitForPageLoad(selenium);

			selenium.fireEvent(lblHighlightAssessment, "keydown");
			selenium.fireEvent(lblHighlightAssessment, "keypress");
			selenium.fireEvent(lblHighlightAssessment, "keyup");
			waitForPageLoad(selenium);
			click(selenium, "//div[5]/div/div/div/div/div");
			waitForPageLoad(selenium);
			selenium.clickAt(lblHighlightAssessment, "");
			selenium.keyPress(lblHighlightAssessment, "\\9");

			if (isElementPresent(selenium, txtMedicatl)) {
				break;
			}
			count++;

			if (count > 20) {
				break;
			}
		}

		assertTrue(getValue(selenium, txtMedicatl).toLowerCase(new java.util.Locale("en", "US")).contains(orderData.medicalCondition.toLowerCase(new java.util.Locale("en", "US"))),"Could not get the value of Medical Condition",selenium, ClassName, MethodName);
		// selectValueFromAjaxList(selenium, lblHighlightAssessment,
		// orderData.medicalCondition);
		if (account.equals(CAAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
			date = DateFormat1.format(cal.getTime());
		} else {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat1.format(cal.getTime());
		}
		assertTrue(
				enterDate(selenium, txtOnset, date),
				"Could not enter the Admin on ;More Details:"
						+ orderData.toString(),selenium, ClassName, MethodName);
		selectValueFromAjaxList(selenium, ajxItem, orderData.itemStatus);
		assertTrue(click(selenium, btnAdd), "Could not click on add",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}

	private static String today() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}

	/**
	 * ftpFileUpload function to ftp File Upload
	 * 
	 * @since August 07, 2013
	 */
	/*
	 * public boolean ftpFileUpload(Selenium selenium,ChartPreVisitLib ElabData)
	 * throws MalformedURLException, IOException{ boolean returnValue = false;
	 * String strBasePath = null; String file = null;
	 * 
	 * try{
	 * 
	 * FTPClient ftp = null;
	 * 
	 * ftp = new FTPClient(); ftp.addProtocolCommandListener(new
	 * PrintCommandListener(new PrintWriter(System.out))); int reply;
	 * ftp.connect(ElabData.ftpHost); reply = ftp.getReplyCode(); if
	 * (!FTPReply.isPositiveCompletion(reply)) { ftp.disconnect(); throw new
	 * Exception("Exception in connecting to FTP Server"); }
	 * ftp.login(ElabData.ftpUser, ElabData.ftpPassword); //
	 * ftp.setFileType(FTP.BINARY_FILE_TYPE); ftp.enterLocalPassiveMode();
	 * 
	 * File dir1 = new File ("."); strBasePath=dir1.getCanonicalPath();
	 * 
	 * file=strBasePath+File.separator+"src"+File.separator+"main"+File.separator
	 * +
	 * "resources"+File.separator+"nexia"+File.separator+"testdata"+File.separator
	 * +"hl7"+File.separator+ElabData.sourcePath;
	 * 
	 * InputStream input = new FileInputStream(new File(file));
	 * 
	 * 
	 * try { String destination = ElabData.destDir; if
	 * (destination.endsWith("/")) { destination += today() + "-" + new
	 * File(ElabData.sourcePath).getName(); } ftp.storeFile(destination, input);
	 * System.out.println("Stored " + ElabData.sourcePath + " to " + destination
	 * + "."); } finally { input.close(); }
	 * 
	 * ftp.logout(); ftp.disconnect();
	 * 
	 * 
	 * }
	 * 
	 * catch(RuntimeException e) { e.printStackTrace();
	 * Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"
	 * +e.getMessage()+"\n\t*); Detailed data:"); } catch (Exception e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } return
	 * returnValue; }
	 */

	/**
	 * createNewPatientWithMandatory function to create New Patient With
	 * Mandatory
	 * @throws IOException 
	 * 
	 * @since Feb 09, 2012
	 */
	public boolean createNewPatientWithMandatory(Selenium selenium,
			HomeLib patientData) throws IOException {
		boolean returnValue = false;
		try {
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("ddmmss");
			date=DateFormat.format(cal.getTime());
			patientData.lastName=patientData.lastName+date;
			assertTrue(
					type(selenium, txtlastName, patientData.lastName),
					"Could not type the last name : More Details"
							+ patientData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtFirstName, patientData.firstName),
					"Could not type the first Name : More Details"
							+ patientData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxStatus, patientData.status);
			 click(selenium,btnBackButton);
			assertTrue(
					enterDate(selenium, txtDob1, patientData.dob),
					"Could not type the DOB : More Details"
							+ patientData.toString(),selenium, ClassName, MethodName);
			click(selenium, btnBack1);
			selectValueFromAjaxList(selenium, "sexSuggestBoxsuggestBox",
					patientData.sex);
			click(selenium, btnBack1);
			assertTrue(
					click(selenium, btnNoteSave),
					"Could not click Save button More Dateils"
							+ patientData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;
			waitForPageLoad(selenium);
		} catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"
					+ e.getMessage()
					+ "\n\t*); Detailed data:"
					+ patientData.toString());		}
		return returnValue;
	}
	/**
	 * goToRegisterPatient Function to go to RegisterPatient
	 * 
	 * @param selenium
	 * @throws IOException 
	 * @since Nov 21,2012
	 */
	public boolean goToRegisterPatient(Selenium selenium) throws IOException {
		assertTrue(click(selenium, lnkQuickAction),
				"Could not click on Quick Actions button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkRegisterPatient),
				"Could not click on Clinical Lists",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if (isElementPresent(selenium, btnNoteSave))
			return true;
		else
			return false;
	}
	/**
	 * goToExportChart Function to go to Export Chart
	 * 
	 * @param selenium
	 * @throws IOException 
	 * @since Nov 21,2012
	 */
public boolean goToExportChart(Selenium selenium) throws IOException {
		
		if(isElementPresent(selenium, btnErrorClose))
			 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		assertTrue(click(selenium, lnkQuickAction),
				"Could not click on Quick Actions button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(isElementPresent(selenium, btnErrorClose))
			 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		
		if(isElementPresent(selenium, lnkShowMoreLink))
	    assertTrue(click(selenium,lnkShowMoreLink),"could not click lnk Show More", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
	
		if(isElementPresent(selenium, lnkChartManagement))
			  assertTrue(click(selenium,lnkChartManagement),"could not click lnk Chart Management", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
				
		if (isElementPresent(selenium, lnkChartMangExportChart))
			return true;
		else
			return false;
	}

	/**
	 * ExportChart Function to Export  aChart
	 * 
	 * @param selenium
	 * @throws IOException 
	 * @since Nov 10,2014
	 */
	public boolean exportChart(Selenium selenium, ChartPreVisitLib exportChartData) throws IOException {
		assertTrue(isElementPresent(selenium, btnExportChart),
				"Could not click on Quick Actions button",selenium, ClassName, MethodName);
		assertTrue(click(selenium, btnExportChart),
				"Could not click on Quick Actions button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium, ajxExpSearchProvider, exportChartData.providerNameEC),
				"Could not select Provider",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtExpChartPwd, exportChartData.passwordEC),
				"Could not select Provider",selenium, ClassName, MethodName);
		if(exportChartData.testCaseId.equals("TC_EC_011")){
			assertTrue(click(selenium, btnCancelExport),
					"Could not select Provider",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium, btnExportChart),
					"Could not click on Quick Actions button",selenium, ClassName, MethodName);
			return true;
		}
			if(!isChecked(selenium, radExpSelectedPatient)){
				assertTrue(click(selenium, radExpSelectedPatient),
						"Could check Select Patient",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium, btnAddPatient),
					"Could not select Provider",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, ajxSearchPatient, exportChartData.patientId),
					"Could not select Provider",selenium, ClassName, MethodName);
			selenium.keyPress(ajxSearchPatient, "\\13");
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblpatientname),
					"Could not select Provider",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
//			assertTrue(click(selenium, lnkClosePatient),
//					"Could not click close link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
		
		if(!exportChartData.testCaseId.equals("TC_EC_005")){
			if(!isChecked(selenium, radExpAllPatientData)){
				assertTrue(click(selenium, radExpAllPatientData),
						"Could check All Patient Data",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
		}
		if(exportChartData.testCaseId.equals("TC_EC_005")){
			if(!isChecked(selenium, radExpSelectedPatientData)){
				assertTrue(click(selenium, radExpSelectedPatientData),
						"Could check selected Patient Data",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium, lnkDataCategories),
					"Could not click Select Data categories",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			ArrayList<String> dataCat=new ArrayList<String>();
			for(int i=1;i<4;i++){
				assertTrue(click(selenium, String.valueOf(i)+chkDataCat),
						"Could not click Select Data categories",selenium, ClassName, MethodName);
				dataCat.add(getText(selenium,String.valueOf(i)+lblDataCat));
			}
			assertTrue(click(selenium, lnkCloseDataCat),
					"Could not click close Data categories link",selenium, ClassName, MethodName);
			verifyDataCategory(selenium, dataCat);
		}
		assertTrue(click(selenium, btnExport),
				"Could not click close Data categories link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnOkEC),
				"Could not click Ok button",selenium, ClassName, MethodName);
		return true;
	}

	/**
	 * verifyDataCategory Function to verify Data Categories selected
	 * 
	 * @param selenium
	 * @throws IOException 
	 * @since Nov 10,2014
	 */
	public void verifyDataCategory(Selenium selenium, ArrayList<String> dataCat) throws IOException {
		String dataCatLink=getText(selenium,lnkDataCategories);
		for(int i=0;i<dataCat.size()-1;i++)
		assertTrue(dataCatLink.contains(dataCat.get(i)),
				"Data categories link not selected properly",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	}

	/**
	 * verifyDataCategory Function to verify Data Categories selected
	 * 
	 * @param selenium
	 * @throws IOException 
	 * @since Nov 10,2014
	 */
	public void verifySumDetailsAfterExportChart(Selenium selenium, ChartPreVisitLib exportChartData) throws IOException {
		String date=null;
		String providerName=getText(selenium, lblProviderNameImportChart);
		String status=getText(selenium, lblStatusImportChart);
		String requestInfo=getText(selenium, lblReportInfoImportChart);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat1 = new SimpleDateFormat(
				"MMM dd, yyyy");
		date = DateFormat1.format(cal.getTime());
		
		assertTrue(click(selenium, arrowEC),
				"Could not arrrow",selenium, ClassName, MethodName);
		assertTrue(requestInfo.contains("Exported started by "+exportChartData.userName.toUpperCase()+" "+"on"+" "+date),
					"Data categories link not selected properly",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		if(exportChartData.testCaseId.equals("TC_EC_006")){
			assertTrue(!(isElementPresent(selenium, lnkDeleteEC)&&isElementVisible(selenium, lnkDeleteEC)),
					"Could not click Delete Link",selenium, ClassName, MethodName);
			assertTrue(!(isElementPresent(selenium, lnkDownload)&&isElementVisible(selenium, lnkDownload)),
					"Could not click Delete Link",selenium, ClassName, MethodName);
				
		}
		if(exportChartData.testCaseId.equals("TC_EC_007")){
			statmentTrigger(selenium,"https://108.161.43.83:8443/AdminConsole/exportPatientBackend");
			goToExportChart(selenium);
			assertTrue((isElementPresent(selenium, lnkDeleteEC)&&isElementVisible(selenium, lnkDeleteEC)),
					"Could not click Delete Link",selenium, ClassName, MethodName);
			assertTrue((isElementPresent(selenium, lnkDownload)&&isElementVisible(selenium, lnkDownload)),
					"Could not click Delete Link",selenium, ClassName, MethodName);
			assertTrue(requestInfo.contains("Export completed on "+date),
					"Data categories link not selected properly",selenium, ClassName, MethodName);
			assertTrue(requestInfo.contains("Successful"),
					"Data categories link not selected properly",selenium, ClassName, MethodName);
			assertTrue(providerName.contains(exportChartData.providerNameEC.toUpperCase()),
					"Data categories link not selected properly",selenium, ClassName, MethodName);
			assertTrue(requestInfo.contains("Export 1 patients with"),
					"Data categories link not selected properly",selenium, ClassName, MethodName);
			
		}
	}
	/**
	 * deleteAllExportChart Function to delete all Exported Chart
	 * 
	 * @param selenium
	 * @throws IOException 
	 * @since Nov 11,2014
	 */
	public void deleteAllExportChart(Selenium selenium, ChartPreVisitLib exportChartData) throws IOException {
		while(isElementPresent(selenium, lnkDeleteEC)&&isElementVisible(selenium, lnkDeleteEC)){
			assertTrue(click(selenium, lnkDeleteEC),
					"Could not click Delete Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnYesButtonEC),
					"Could not click Delete Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
	}
	
	/**
	 * statmentTrigger function to run Export/Import process
	 * @param selenium
	 * @param website
	 * @return boolean value
	 * @throws IOException
	 * @since Nov 11,2014
	 */
	

	public boolean statmentTrigger(Selenium selenium, String webSite){
		try{			
			String genrateUrl = webSite;
			selenium.openWindow(genrateUrl, "Nexia");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * goToImportChart Function to go to Import Chart
	 * 
	 * @param selenium
	 * @throws IOException 
	 * @since Nov 11,2014
	 */
	public boolean goToImportChart(Selenium selenium) throws IOException {
		if (isElementPresent(selenium, "errorCloseButton"))
			assertTrue(click(selenium, "errorCloseButton"),"Could not Click on Error Close Button",selenium, ClassName, MethodName);
		assertTrue(click(selenium, lnkQuickAction),
				"Could not click on Quick Actions button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkChartManagement),
				"Could not click on chart Management",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if (isElementPresent(selenium, lnkChartMangImportChart)){
			assertTrue(click(selenium, lnkChartMangImportChart),
					"Could not click on chart Management",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * deleteAllExportChart Function to delete all Exported Chart
	 * 
	 * @param selenium
	 * @throws IOException 
	 * @since Nov 11,2014
	 */
	public void deleteAllImportChart(Selenium selenium, ChartPreVisitLib exportChartData) throws IOException {
		while(isElementPresent(selenium, lnkDeleteIC)&&isElementVisible(selenium, lnkDeleteIC)){
			assertTrue(click(selenium, lnkDeleteEC),
					"Could not click Delete Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnYesButtonEC),
					"Could not click Delete Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
	}
	/**
	 * verifySumDetailsAfterImportChart Function to verify Summary after Import Chart
	 * 
	 * @param selenium
	 * @throws IOException 
	 * @since Nov 10,2014
	 */
	public void verifySumDetailsAfterImportChart(Selenium selenium, ChartPreVisitLib importChartData) throws IOException {
		String date=null;
		String providerName=getText(selenium, lblProviderNameImportChart);
		String requestInfo=getText(selenium, lblReportInfoImportChart);
		String fIleName=getText(selenium,"xpath=(//span[contains(@id,'fileName')])");
		String importedDetails=getText(selenium,"xpath=//span[contains(@id,'lastUpdated')]");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat1 = new SimpleDateFormat(
				"MMM dd, yyyy");
		date = DateFormat1.format(cal.getTime());
		
		assertTrue(click(selenium, arrowEC),
				"Could not arrrow",selenium, ClassName, MethodName);
		String newstr="Export requested by "+importChartData.userName.toUpperCase()+" "+"on"+" "+date;
		System.out.print(newstr);
		assertTrue(requestInfo.contains("Export Requested by "+importChartData.userName.toUpperCase()+" "+"on"+" "+date),
					"Data categories link not selected properly",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		if(importChartData.testCaseId.equals("TC_IC_003")){
			assertTrue(!(isElementPresent(selenium, lnkDeleteEC)&&isElementVisible(selenium, lnkDeleteEC)),
					"Could not click Delete Link",selenium, ClassName, MethodName);
				
		}
		if(importChartData.testCaseId.equals("TC_IC_004")){
			statmentTrigger(selenium,"https://108.161.43.83:8443/AdminConsole/importPatientBackend");
			goToImportChart(selenium);
			assertTrue((isElementPresent(selenium, lnkDeleteEC)&&isElementVisible(selenium, lnkDeleteEC)),
					"Could not click Delete Link",selenium, ClassName, MethodName);
		 importedDetails=getText(selenium,"xpath=//span[contains(@id,'lastUpdated')]");
			String status=getText(selenium, lblStatusImportChart);
			 fIleName=getText(selenium,"xpath=(//span[contains(@id,'fileName')])");
			assertTrue(importedDetails.contains("Import completed on "+date),
					"Data categories link not selected properly",selenium, ClassName, MethodName);
			assertTrue(status.toLowerCase().contains("successful"),
					"Data categories link not selected properly",selenium, ClassName, MethodName);
			assertTrue(providerName.toLowerCase().contains(importChartData.providerNameEC.toLowerCase()),
					"Data categories link not selected properly",selenium, ClassName, MethodName);
			assertTrue(fIleName.contains("File name : "),
					"Data categories link not selected properly",selenium, ClassName, MethodName);
			
		}
		if(importChartData.testCaseId.equals("TC_IC_005")){
			assertTrue((isElementPresent(selenium, lnkDeleteEC)&&isElementVisible(selenium, lnkDeleteEC)),
					"Could not click Delete Link",selenium, ClassName, MethodName);
			assertTrue(importedDetails.contains("Import failed on"),
					"Data categories link not selected properly",selenium, ClassName, MethodName);
		
				
		}
	}	
	
	/**
	 * importChart Function to Import a Chart
	 * 
	 * @param selenium
	 * @throws IOException 
	 * @since Nov 10,2014
	 */
	public boolean importChart(Selenium selenium, ChartPreVisitLib importChartData) throws IOException {
		assertTrue(isElementPresent(selenium, btnImpChart),
				"Import Chart button not present",selenium, ClassName, MethodName);
		assertTrue(click(selenium, btnImpChart),
				"Could not click on Import Chart button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		File dir1 = new File (".");
		String strBasePath = null;
		String xmlName1 = "Colin_Clark_1234_02071960 -.zip";	
		String xmlName2 = "John_Smith_1235_03041940.zip";	
		String xmlName=null;
		String sectionName = "chartprevisit";
		String file = null;
		String desfile = null;
		//desfile="C:"+File.separator;
		//File destDir = new File(desfile);
		strBasePath=dir1.getCanonicalPath();
		if(!importChartData.testCaseId.equals("TC_IC_005")){
			xmlName=xmlName2;
		}else{
			xmlName=xmlName1;
		}
		file=strBasePath+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"nexia"+File.separator+"testdata"+File.separator+sectionName + File.separator + xmlName;
		//FileUtils.copyFileToDirectory(new File(file), destDir);
		assertTrue(selectValueFromAjaxList(selenium, ajxImpChartProvider, importChartData.providerNameEC),
				"Could not select Provider for importing chart",selenium, ClassName, MethodName);
		//file=strBasePath+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"nexia"+File.separator+"testdata"+File.separator+sectionName + File.separator + xmlName;
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtImportFile,file),"Could not browse the xml file", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtPasswordIC, importChartData.passwordEC),
				"Could not enter password",selenium, ClassName, MethodName);
		assertTrue(click(selenium, btnImport),
				"Could not click on Import Button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnYesButtonIC),
				"Could not click on Ok Button",selenium, ClassName, MethodName);
		//waitForPageLoad(selenium);
		return true;
	}




	/**
	 * navigateToCDS Function to go to RegisterPatient
	 * 
	 * @param selenium
	 * @throws IOException 
	 * @since Nov 21,2012
	 */
	public boolean navigateToCDS(Selenium selenium) throws IOException {
		assertTrue(click(selenium, lnkQuickAction),
				"Could not click on Quick Actions button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, "clinicalSettingsAction"),
				"Could not click on Clinical settings",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		click(selenium, "!cdsRuleAdminList");
		waitForPageLoad(selenium);
		return true;
	}

	/**
	 * navigateTo Medication Interaction Warning Function to go to Medication
	 * Interaction Warning
	 * 
	 * @param selenium
	 * @throws IOException 
	 * @since March 12,2013
	 */
	public boolean navigateToInteracWarn(Selenium selenium) throws IOException {
		assertTrue(click(selenium, lnkSettings),
				"Could not click on Quick Actions button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkClinicalSetting),
				"Could not click on Clinical settings",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkInteractionwarning),
				"Could not click on Interaction Warning button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	/**
	 * navigateToCDSUncheck Function to go to RegisterPatient
	 * 
	 * @param selenium
	 * @throws IOException 
	 * @since Nov 21,2012
	 */
	public boolean navigateToCDSUncheck(Selenium selenium) throws IOException {
		assertTrue(click(selenium, lnkSettings),
				"Could not click on Quick Actions button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, "clinicalSettingsAction"),
				"Could not click on Clinical settings",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		click(selenium, "!cdsRuleAdminList");
		waitForPageLoad(selenium);

		if (isChecked(selenium, "//tr[2]/td/div/input")) {
			click(selenium, "//tr[2]/td/div/input");
		}
		if (isChecked(selenium, lblExport7)) {
			click(selenium, lblExport7);
		}
		click(selenium, "clinicalDecisionSupportSave");
		waitForPageLoad(selenium);
		return true;
	}

	/**
	 * navigateToCDSUncheck Function to go to RegisterPatient
	 * 
	 * @param selenium
	 * @throws IOException 
	 * @since Nov 21,2012
	 */
	public boolean navigateToCDSCheck(Selenium selenium) throws IOException {
		assertTrue(click(selenium, lnkSettings),
				"Could not click on Quick Actions button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, "clinicalSettingsAction"),"Could not click on ClinicalSettingAction link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		click(selenium, "!cdsRuleAdminList");
		waitForPageLoad(selenium);

		if (!isChecked(selenium, "//tr[2]/td/div/input")) {
			click(selenium, "//tr[2]/td/div/input");
		}
		if (!isChecked(selenium, lblExport7)) {
			click(selenium, lblExport7);
		}
		click(selenium, "clinicalDecisionSupportSave");

		waitForPageLoad(selenium);
		return true;
	}

	/**
	 * navigateToCDSCheckCancel Function to go to RegisterPatient
	 * 
	 * @param selenium
	 * @throws IOException 
	 * @since Nov 21,2012
	 */
	public boolean navigateToCDSCheckCancel(Selenium selenium) throws IOException {
		assertTrue(click(selenium, lnkQuickAction),
				"Could not click on Quick Actions button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(
				click(selenium,
						"css=#clinicalSettingsAction > span.actionItemSpan"),
				"Could not click on Clinical settings",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		click(selenium, "!cdsRuleAdminList");
		waitForPageLoad(selenium);

		if (!isChecked(selenium, "//tr[2]/td/div/input")) {
			click(selenium, "//tr[2]/td/div/input");
		}
		if (!isChecked(selenium, lblExport7)) {
			click(selenium, lblExport7);
		}
		click(selenium, "clinicalDecisionSupportCancel");
		waitForPageLoad(selenium);
		return true;
	}
	/**
	 * assesmentSectionForSignedEncounter Function to assesment Section For
	 * Signed Encounter
	 * 
	 * @param selenium
	 * @throws IOException 
	 * @since Nov 21,2012
	 */
	//FIXME MNT-1221
	public boolean assesmentSectionForSignedEncounter(Selenium selenium,
			ChartPreVisitLib encounterData) throws IOException {
		
		try {
			assertTrue(
					type(selenium, vitalsData, encounterData.vitals),"Could not Enter the vitals data",selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, cheifComplinatBox,encounterData.chiefComplaint),"Could not enter the chiefcomplaint data",selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, cheifCompliantNote,encounterData.chief), "Could not Enter the chief",selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, historyNote,encounterData.historyType),"Could not Enter the Hiistory",selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, reviewTextBox,encounterData.review), "Could not Enter the Review",selenium, ClassName, MethodName);
			assertTrue(click(selenium, patientCheckBox),	"Could not click the check box",selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, planNotes, encounterData.notes),"Could not Enter the Plan notes",selenium, ClassName, MethodName);
			if (isElementPresent(selenium, planNotes)) {
				return true;
			} else
				return false;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean createDirectories(Selenium selenium,
			SystemSettingsLib directoriesData, String account) throws IOException {
		boolean returnValue = true;
		try {
			assertTrue(
					type(selenium, "pharmacyName", directoriesData.pharmacyName),
					"Could not type the pharmacyNema;More details:"
							+ directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, "addr1", directoriesData.street),
					"Could not type the street;More details:"
							+ directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, "city", directoriesData.city),
					"Could not type the city;More details:"
							+ directoriesData.toString(),selenium, ClassName, MethodName);

			if (account.equals(CAAccount)) {
				selectValueFromAjaxList(selenium, "stateSuggestBoxsuggestBox",
						directoriesData.stateCA);
				assertTrue(
						type(selenium, "zip", directoriesData.zipcodeCa),
						"Could not type the zip code;More details:"
								+ directoriesData.toString(),selenium, ClassName, MethodName);
			} else {
				selectValueFromAjaxList(selenium, "stateSuggestBoxsuggestBox",
						directoriesData.state);
				assertTrue(
						type(selenium, "zip", directoriesData.zipcode),
						"Could not type the zip code;More details:"
								+ directoriesData.toString(),selenium, ClassName, MethodName);
			}
			click(selenium, "noButton");
			selectValueFromAjaxList(selenium, "countrySuggestBoxsuggestBox",
					directoriesData.country);
			assertTrue(
					type(selenium, "phone", directoriesData.telephoneNo1),
					"Could not type the phone no;More details:"
							+ directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, "phoneExtension",
							directoriesData.telephoneextnNo1),
							"Could not type exten no;More details:"
									+ directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, "fax", directoriesData.fax),
					"Could not type the fax;More details:"
							+ directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, "email", directoriesData.email),
					"Could not type the email;More details:"
							+ directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, "website", directoriesData.webAddress),
					"Could not type the web address;More details:"
							+ directoriesData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, "titlesuggestBox",
					directoriesData.salutation);
			assertTrue(
					type(selenium, txtlastName, directoriesData.lastName),
					"Could not type the last Name;More details:"
							+ directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtFirstName, directoriesData.firstName),
					"Could not type the first name;More details:"
							+ directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, "commentTextBoxId", directoriesData.comments),
					"Could not type the comments;More details:"
							+ directoriesData.toString(),selenium, ClassName, MethodName);

			assertTrue(click(selenium, btnSaveRecallReason), ""	+ "Could not click the save button;More details:", selenium, ClassName,	MethodName);


			if (isElementPresent(selenium, txtMedsSearchTextBox)) {
				returnValue = true;
			} else
				returnValue = false;

		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}

	/**
	 * deleteDirectories function to delete Directories
	 * 
	 * @param selenium
	 * @throws IOException 
	 * @since August 27, 2012
	 */

	public boolean deleteDirectories(Selenium selenium) throws IOException {
		boolean directoriesDeleted = true;
		int directoriesCount = 0;
		try {
			waitForElement(
					selenium,
					"//div[@id='adminPharmacyListView']/table/tbody/tr/td[2]/div/a",
					WAIT_TIME);
			while ((Integer) selenium
					.getXpathCount("//div[@id='adminPharmacyListView']/table/tbody/tr/td[2]/div/a") > 0) {
				directoriesCount = (Integer) selenium
						.getXpathCount("//div[@id='adminPharmacyListView']/table/tbody/tr/td[2]/div/a");
				assertTrue(click(selenium,
						"//div[@id='adminPharmacyListView']/table/tbody/tr/td[2]/div/a"),"Could not click on the link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnYes),"Could not click on Yes Button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (directoriesCount == (Integer) selenium
						.getXpathCount("//div[@id='adminPharmacyListView']/table/tbody/tr/td[2]/div/a")) {
					directoriesDeleted = false;
					break;
				}
			}
			return directoriesDeleted;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}


	/**
	 * createPatient function to create a new patient check-in with full details
	 * @throws IOException 
	 * 
	 * @since Jan 16, 2012
	 */
	public boolean createPatient(Selenium selenium, HomeLib patientData) throws IOException {
		boolean returnValue = false;
		try {
			if (!patientData.patientIdchart.isEmpty())
				if (!patientData.patientIdchart.contains("N/A"))
					assertTrue(
							type(selenium, "chartNumber",
									patientData.patientIdchart),
									"Could not Enter the patientId chart, Expected value to be typed"
											+ patientData.patientIdchart,selenium, ClassName, MethodName);
			if (!patientData.primaryLocation.isEmpty())
				if (!patientData.primaryLocation.contains("N/A"))
					if (!selectValueFromAjaxList(selenium,
							"primaryLocationSuggestBoxsuggestBox",
							patientData.primaryLocation))
						Assert.fail("Could not Enter Primary Location, Expected value to be selected : "
								+ patientData.primaryLocation);
			if (!patientData.responsibleProvider.isEmpty())
				if (!patientData.responsibleProvider.contains("N/A"))
					if (!selectValueFromAjaxList(selenium,
							"responsibleProvSuggestBoxsuggestBox",
							patientData.responsibleProvider))
						Assert.fail("Could not Enter responsible Provider, Expected value to be selected"
								+ patientData.responsibleProvider);
			if (!patientData.pcpCheck.isEmpty())
				if (!patientData.pcpCheck.contains("No"))
					assertTrue(
							check(selenium, "responsibleProvPCPcheckbox"),
							"Could not check the pcp check box, Expected value for the check box : "
									+ patientData.pcpCheck,selenium, ClassName, MethodName);

			if (!patientData.lastName.isEmpty())
				if (!patientData.lastName.contains("N/A"))
					assertTrue(
							type(selenium, txtlastName, patientData.lastName),
							"Could not Enter Last name, Expected value to be typed"
									+ patientData.lastName,selenium, ClassName, MethodName);
			if (!patientData.firstName.isEmpty())
				if (!patientData.firstName.contains("N/A"))
					assertTrue(
							type(selenium, txtFirstName, patientData.firstName),
							"Could not Enter First name, Expected value to be typed"
									+ patientData.firstName,selenium, ClassName, MethodName);
			if (!patientData.middleName.isEmpty())
				if (!patientData.middleName.contains("N/A"))
					assertTrue(
							type(selenium, "middleName", patientData.middleName),
							"Could not Enter middle name, Expected value to be typed"
									+ patientData.middleName,selenium, ClassName, MethodName);
			if (!patientData.title.isEmpty())
				if (!patientData.title.contains("N/A"))
					if (!selectValueFromAjaxList(selenium,
							"titleSuggestBoxsuggestBox", patientData.title))
						Assert.fail("Could not Enter Title, Expected value to be selected"
								+ patientData.title);
			if (!patientData.suffix.isEmpty())
				if (!patientData.suffix.contains("N/A"))
					if (!selectValueFromAjaxList(selenium,
							"suffixSuggestBoxsuggestBox", patientData.suffix))
						Assert.fail("Could not Enter Suffix, Expected value to be selected"
								+ patientData.suffix);
			if (!patientData.alias1.isEmpty())
				if (!patientData.alias1.contains("N/A"))
					assertTrue(
							type(selenium, "alias1", patientData.alias1),
							"Could not Enter alias1, Expected value to be typed"
									+ patientData.alias1,selenium, ClassName, MethodName);
			if (!patientData.alias2.isEmpty())
				if (!patientData.alias2.contains("N/A"))
					assertTrue(
							type(selenium, "alias2", patientData.alias2),
							"Could not Enter alias2, Expected value to be typed"
									+ patientData.alias2,selenium, ClassName, MethodName);
			if (!patientData.dob.isEmpty())
				if (!patientData.dob.contains("N/A"))
					assertTrue(
							enterDate(selenium, "dob", patientData.dob),
							"Could not Enter dob, Expected value to be typed"
									+ patientData.dob,selenium, ClassName, MethodName);
			click(selenium, btnBackButton);
			if (!patientData.estimatedCheck.isEmpty())
				if (!patientData.estimatedCheck.contains("No"))
					assertTrue(click(selenium, "dobEstimatedcheckbox"),
							"Could not check the estimated check box, Expected value for the check box : "
									+ patientData.estimatedCheck,selenium, ClassName, MethodName);
			if(selenium.isElementPresent(btnBack1))
			{
				assertTrue(click(selenium, btnBack1),
						"Could click back button, Expected value to be typed"
								+ patientData.dob,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if (!patientData.prematureCheck.isEmpty())
				if (!patientData.prematureCheck.contains("No")) {
					assertTrue(click(selenium, "prematurecheckbox"),
							"Could not check the premature check box, Expected value for the check box : "
									+ patientData.prematureCheck,selenium, ClassName, MethodName);
					if (!patientData.duration.isEmpty())
						if (!patientData.duration.contains("N/A"))
							assertTrue(
									type(selenium, "prematureDuration",
											patientData.duration),
											"Could not Enter duration, Expected value to be typed : "
													+ patientData.duration,selenium, ClassName, MethodName);
					if (!patientData.measure.isEmpty())
						if (!patientData.measure.contains("N/A"))
							if (!selectValueFromAjaxList(selenium,
									"prematureMeasureUnitSuggestBoxsuggestBox",
									patientData.measure))
								Assert.fail("Could not Enter Premature Messure, Expected value to be selected"
										+ patientData.measure);
					waitForPageLoad(selenium);
				}
			if (!patientData.sex.isEmpty())
				if (!patientData.sex.contains("N/A"))
					if (!selectValueFromAjaxList(selenium,
							"sexSuggestBoxsuggestBox", patientData.sex))
						Assert.fail("Could not Enter Sex, Expected value to be selected"
								+ patientData.sex);
			waitForPageLoad(selenium);
			if (!patientData.maritalStatus.isEmpty())
				if (!patientData.maritalStatus.contains("N/A"))
					if (!selectValueFromAjaxList(selenium,
							"maritalStatusSuggestBoxsuggestBox",
							patientData.maritalStatus))
						Assert.fail("Could not Enter Marital Status, Expected value to be selected"
								+ patientData.maritalStatus);
			if (!patientData.status.isEmpty())
				if (!patientData.status.contains("N/A"))
					if (!selectValueFromAjaxList(selenium, ajxStatus,
							patientData.status))
						Assert.fail("Could not Enter Status, For; More Details"
								+ patientData.toString());
			if (!patientData.statusDate.isEmpty())
				if (!patientData.statusDate.contains("N/A"))
					assertTrue(
							enterDate(selenium, "statusDate",
									patientData.statusDate),
									"Could not Enter statusDate, For; More Details"
											+ patientData.toString(),selenium, ClassName, MethodName);
			if (patientData.status.equalsIgnoreCase("inactive"))
				if (!patientData.reasonForInactivation.isEmpty())
					if (!patientData.reasonForInactivation.contains("N/A"))
						if (!selectValueFromAjaxList(selenium,
								"statusInactivationReasonSuggestBoxsuggestBox",
								patientData.reasonForInactivation))
							Assert.fail("Could not Enter reason for inactivation, For; More Details"
									+ patientData.maritalStatus);
			if (!patientData.residentialAddrStreet1.isEmpty())
				if (!patientData.residentialAddrStreet1.contains("N/A"))
					assertTrue(
							type(selenium, "residentialAddr1",
									patientData.residentialAddrStreet1),
									"Could not Enter residential Addr1, Expected value to be typed"
											+ patientData.residentialAddrStreet1,selenium, ClassName, MethodName);
			if (!patientData.residentialAddrStreet2.isEmpty())
				if (!patientData.residentialAddrStreet2.contains("N/A"))
					assertTrue(
							type(selenium, "residentialAddr2",
									patientData.residentialAddrStreet2),
									"Could not Enter residential Addr2, Expected value to be typed"
											+ patientData.residentialAddrStreet2,selenium, ClassName, MethodName);
			if (!patientData.residentialAddrcity.isEmpty())
				if (!patientData.residentialAddrcity.contains("N/A"))
					assertTrue(
							type(selenium, "residentialCity",
									patientData.residentialAddrcity),
									"Could not Enter city, Expected value to be typed"
											+ patientData.residentialAddrcity,selenium, ClassName, MethodName);
			if (!patientData.residentialAddrstate.isEmpty())
				if (!patientData.residentialAddrstate.contains("N/A"))
					if (!selectValueFromAjaxList(selenium,
							"residentialStatesuggestBox",
							patientData.residentialAddrstate))
						Assert.fail("Could not Enter Residential Addr State, Expected value to be select"
								+ patientData.residentialAddrstate);
			if (!patientData.residentialAddrzipCode.isEmpty())
				if (!patientData.residentialAddrzipCode.contains("N/A"))
					assertTrue(
							type(selenium, "residentialZip",
									patientData.residentialAddrzipCode),
									"Could not Enter zip code, Expected value to be typed"
											+ patientData.residentialAddrzipCode,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.keyPress(ajxComm, "\\9");
			click(selenium, btnYes);
			waitForElementToEnable(selenium, "residentialCity");
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium, "residentialStatesuggestBox");
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium, "residentialCountrysuggestBox");
			waitForPageLoad(selenium);

			if (!patientData.telephoneType1.isEmpty())
				if (!patientData.telephoneType1.contains("N/A"))
					if (!selectValueFromAjaxList(selenium, ajxComm,
							patientData.telephoneType1))
						Assert.fail("Could not Enter Telephone Type1, Expected value to be Select"
								+ patientData.telephoneType1);
			if (!patientData.telephoneNo1.isEmpty())
				if (!patientData.telephoneNo1.contains("N/A"))
					assertTrue(
							type(selenium, txtPrimaryPhone,
									patientData.telephoneNo1),
									"Could not Enter telephone Number, Expected value to be Typed"
											+ patientData.telephoneNo1,selenium, ClassName, MethodName);
			if (!patientData.telephoneextnNo1.isEmpty())
				if (!patientData.telephoneextnNo1.contains("N/A"))
					assertTrue(
							type(selenium, txtPrimaryExtn,
									patientData.telephoneextnNo1),
									"Could not Enter telephone Extn Number, Expected value to be Typed"
											+ patientData.telephoneextnNo1,selenium, ClassName, MethodName);
			if (!patientData.telephoneType2.isEmpty())
				if (!patientData.telephoneType2.contains("N/A"))
					if (!selectValueFromAjaxList(selenium,
							"commType2SuggestBoxsuggestBox",
							patientData.telephoneType2))
						Assert.fail("Could not Enter Telephone Type2, Expected value to be Select"
								+ patientData.telephoneType2);

			if (!patientData.telephoneNo2.isEmpty())
				if (!patientData.telephoneNo2.contains("N/A"))
					assertTrue(
							type(selenium, "ohterPhone1",
									patientData.telephoneNo2),
									"Could not Enter telephone Number, Expected value to be Typed"
											+ patientData.telephoneNo2,selenium, ClassName, MethodName);
			if (!patientData.telephoneextnNo2.isEmpty())
				if (!patientData.telephoneextnNo2.contains("N/A"))
					assertTrue(
							type(selenium, "otherPhone1Extension",
									patientData.telephoneextnNo2),
									"Could not Enter telephone Extn Number, Expected value to be Typed"
											+ patientData.telephoneextnNo2,selenium, ClassName, MethodName);

			if (!patientData.telephoneType3.isEmpty())
				if (!patientData.telephoneType3.contains("N/A"))
					if (!selectValueFromAjaxList(selenium,
							"commType3SuggestBoxsuggestBox",
							patientData.telephoneType3))
						Assert.fail("Could not Enter Telephone Type3, Expected value to be Select"
								+ patientData.telephoneType3);

			if (!patientData.telephoneNo3.isEmpty())
				if (!patientData.telephoneNo3.contains("N/A"))
					assertTrue(
							type(selenium, "otherPhone2",
									patientData.telephoneNo3),
									"Could not Enter telephone Number, Expected value to be Typed"
											+ patientData.telephoneNo3,selenium, ClassName, MethodName);
			if (!patientData.telephoneextnNo3.isEmpty())
				if (!patientData.telephoneextnNo3.contains("N/A"))
					assertTrue(
							type(selenium, "otherPhone2Extension",
									patientData.telephoneextnNo3),
									"Could not Enter telephone Extn Number, Expected value to be Typed"
											+ patientData.telephoneNo3,selenium, ClassName, MethodName);

			if (!patientData.email.isEmpty())
				if (!patientData.email.contains("N/A"))
					assertTrue(
							type(selenium, "email", patientData.email),
							"Could not Enter email, Expected value to be Typed"
									+ patientData.email,selenium, ClassName, MethodName);

			if (!patientData.contactPreferences.isEmpty())
				if (!patientData.contactPreferences.contains("N/A"))
					if (!selectValueFromAjaxList(selenium,
							"//div[7]/div/div/div/div/div/div/input",
							patientData.contactPreferences))
						Assert.fail("Could not Enter Contact preference, Expected value to be Select"
								+ patientData.contactPreferences);

			if (!patientData.contactPreferences1.isEmpty())
				if (!patientData.contactPreferences1.contains("N/A"))
					assertTrue(click(selenium, "addButtonId"),
							"Could not click on add more button",selenium, ClassName, MethodName);
			if (!selectValueFromAjaxList(selenium,
					"//div[7]/div/div/div[2]/div/div/div/input",
					patientData.contactPreferences1))
				Assert.fail("Could not Enter Contact preference, Expected value to be Select"
						+ patientData.contactPreferences1);

			if (!patientData.contactPreferences2.isEmpty())
				if (!patientData.contactPreferences2.contains("N/A"))
					assertTrue(click(selenium, "addButtonId"),
							"Could not click on add more button",selenium, ClassName, MethodName);
			if (!selectValueFromAjaxList(selenium,
					"//div[3]/div/div/div/input",
					patientData.contactPreferences2))
				Assert.fail("Could not Enter Contact preference, Expected value to be Select"
						+ patientData.contactPreferences2);

			if (!patientData.contactPreferences4.isEmpty())
				if (!patientData.contactPreferences4.contains("N/A"))
					assertTrue(click(selenium, "addButtonId"),
							"Could not click on add more button",selenium, ClassName, MethodName);
			if (!selectValueFromAjaxList(selenium,
					"//div[4]/div/div/div/input",
					patientData.contactPreferences4))
				Assert.fail("Could not Enter Contact preference, Expected value to be Select"
						+ patientData.contactPreferences4);

			if (!patientData.sameAsResidentialAddressCheck.isEmpty()) {
				if (!patientData.sameAsResidentialAddressCheck.contains("No"))
					assertTrue(
							click(selenium, "mailingAsResidentialcheckbox"),
							"Could not check the ssn check box, Expected value for the check box : "
									+ patientData.sameAsResidentialAddressCheck,selenium, ClassName, MethodName);

				if (!patientData.mailingAddressStreet1.isEmpty())
					if (!patientData.mailingAddressStreet1.contains("N/A"))
						assertTrue(
								type(selenium, "mailingAddr1",
										patientData.mailingAddressStreet1),
										"Could not Enter Mailing Addr Street1, Expected value to be Typed"
												+ patientData.mailingAddressStreet1,selenium, ClassName, MethodName);
				if (!patientData.mailingAddressStreet2.isEmpty())
					if (!patientData.mailingAddressStreet2.contains("N/A"))
						assertTrue(
								type(selenium, "mailingAddr2",
										patientData.mailingAddressStreet2),
										"Could not Enter Mailing Addr Street12, Expected value to be Typed"
												+ patientData.mailingAddressStreet2,selenium, ClassName, MethodName);
				if (!patientData.mailingAddressCity.isEmpty())
					if (!patientData.mailingAddressCity.contains("N/A"))
						assertTrue(
								type(selenium, "mailingCity",
										patientData.mailingAddressCity),
										"Could not Enter Mailing address city, Expected value to be Typed"
												+ patientData.mailingAddressCity,selenium, ClassName, MethodName);
				if (!patientData.mailingAddressState.isEmpty())
					if (!patientData.mailingAddressState.contains("N/A"))
						selectValueFromAjaxList(selenium,
								"mailingStatesuggestBox",
								patientData.mailingAddressState);
				if (!patientData.mailingAddressState.isEmpty())
					if (!patientData.mailingAddressState.contains("N/A"))
						selectValueFromAjaxList(selenium,
								"mailingCountrysuggestBox",
								patientData.mailingAddressCountry);
				if (!patientData.mailingAddressZipcode.isEmpty())
					if (!patientData.mailingAddressZipcode.contains("N/A"))
						assertTrue(
								type(selenium, "mailingZip",
										patientData.mailingAddressZipcode),
										"Could not Enter Mailing address zip code, Expected value to be Typed"
												+ patientData.mailingAddressZipcode,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				selenium.keyPress(txtComments, "\\9");
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);

				click(selenium, btnYes);
				waitForElementToEnable(selenium, "mailingCity");
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium, "mailingStatesuggestBox");
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium, "mailingCountrysuggestBox");
				waitForPageLoad(selenium);

			} else {
				if (!patientData.mailingAddressStreet1.isEmpty())
					if (!patientData.mailingAddressStreet1.contains("N/A"))
						assertTrue(
								type(selenium, "mailingAddr1",
										patientData.mailingAddressStreet1),
										"Could not Enter Mailing Addr Street1, Expected value to be Typed"
												+ patientData.mailingAddressStreet1,selenium, ClassName, MethodName);
				if (!patientData.mailingAddressStreet2.isEmpty())
					if (!patientData.mailingAddressStreet2.contains("N/A"))
						assertTrue(
								type(selenium, "mailingAddr2",
										patientData.mailingAddressStreet2),
										"Could not Enter Mailing Addr Street12, Expected value to be Typed"
												+ patientData.mailingAddressStreet2,selenium, ClassName, MethodName);
				if (!patientData.mailingAddressCity.isEmpty())
					if (!patientData.mailingAddressCity.contains("N/A"))
						assertTrue(
								type(selenium, "mailingCity",
										patientData.mailingAddressCity),
										"Could not Enter Mailing address city, Expected value to be Typed"
												+ patientData.mailingAddressCity,selenium, ClassName, MethodName);

				if (!patientData.mailingAddressZipcode.isEmpty())
					if (!patientData.mailingAddressZipcode.contains("N/A"))
						assertTrue(
								type(selenium, "mailingZip",
										patientData.mailingAddressZipcode),
										"Could not Enter Mailing address zip code, Expected value to be Typed"
												+ patientData.mailingAddressZipcode,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selenium.keyPress(txtComments, "\\9");
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);

				click(selenium, btnYes);
				waitForElementToEnable(selenium, "mailingCity");
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium, "mailingStatesuggestBox");
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium, "mailingCountrysuggestBox");
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium, "mailingCounty");
				waitForPageLoad(selenium);

			}
			if (!patientData.comments.isEmpty())
				if (!patientData.comments.contains("N/A"))
					assertTrue(
							type(selenium, txtComments, patientData.comments),
							"Could not Enter comments, Expected value to be Selected"
									+ patientData.comments,selenium, ClassName, MethodName);
			click(selenium, btnNoteSave);
			waitForPageLoad(selenium);
			returnValue = true;
			waitForPageLoad(selenium);
		} catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"
					+ e.getMessage()
					+ "\n\t*); Detailed data:"
					+ patientData.toString());
		}
		return returnValue;
	}

	/**
	 * createSocioEconomic function to create a Socio Economic
	 * @throws IOException 
	 * 
	 * @since Jan 16, 2012
	 */
	public boolean createSocioEconomicForExport(Selenium selenium,
			HomeLib socioEconomicData) throws IOException {

		try {
			assertTrue(selectValueFromAjaxList(selenium, ajxRace,socioEconomicData.race), "Could not click Validate Button; More Details", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, "ethnicitysuggestBox",
					socioEconomicData.ethnicity);
			selectValueFromAjaxList(selenium, "religionsuggestBox",
					socioEconomicData.religion);
			assertTrue(click(selenium, btnSave3), ""	+ "Could not click Validate Button; More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//assertTrue(click(selenium, btnSave),"Could not click Validate Button; More Details"+ socioEconomicData.toString(),selenium, ClassName, MethodName);
			if (isElementPresent(selenium, "!patientSocialHistory")) {
				return true;
			} else {
				return false;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * verifyStoredValuesForPatientExportChart function to verify eport chart
	 * values
	 * 
	 * @since Jan 16, 2012
	 */
	public boolean verifyStoredValuesForPatientExportChart(Selenium selenium,
			HomeLib patientData, HomeLib sEconomicData, String patId) {

		if (!getText(selenium, lblExportedPatientInfo)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						patientData.lastName.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			return false;
		}
		if (!getText(selenium, lblExportedPatientInfo)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						patientData.firstName.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			return false;
		}
		if (!getText(selenium, lblExportedPatientInfo)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						patientData.middleName.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			return false;
		}
		if (!getText(selenium, lblExportedPatientInfo)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						patId.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			return false;
		}


		if (!getText(selenium, lblExportedPatientInfo)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						patientData.sex.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			return false;
		}
		if (!getText(selenium, lblExportedPatientInfo)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						patientData.maritalStatus.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			return false;
		}


		if (!getText(selenium, lblExportedPatientInfo).replaceAll(" ", "")
				.contains(patientData.telephoneNo1.trim())) {
			return false;
		}
		if (!getText(selenium, lblExportedPatientInfo)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						patientData.telephoneextnNo1.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			return false;
		}
		if (!getText(selenium, lblExportedPatientInfo).replaceAll(" ", "")
				.contains(patientData.telephoneNo2.trim())) {
			return false;
		}
		if (!getText(selenium, lblExportedPatientInfo)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						patientData.telephoneextnNo2.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			return false;
		}
		if (!getText(selenium, lblExportedPatientInfo).replaceAll(" ", "")
				.contains(patientData.telephoneNo3.trim())) {
			return false;
		}
		if (!getText(selenium, lblExportedPatientInfo)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						patientData.telephoneextnNo3.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			return false;
		}
		if (!getText(selenium, lblExportedPatientInfo)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						patientData.email.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			return false;
		}
		if (!getText(selenium, lblExportedPatientInfo)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						sEconomicData.religion.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			return false;
		}
		if (!getText(selenium, lblExportedPatientInfo)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						sEconomicData.race.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			return false;
		}

		return true;
	}

	/**
	 * verifyStoredValueForMedicationExportChart function to verify eport chart
	 * values
	 * 
	 * @since Jan 17, 2012
	 */
	public boolean verifyStoredValueForMedicationExportChart(Selenium selenium,
			ChartPreVisitLib medicationData, String account) {

		waitForPageLoad(selenium);
		// td[2]/div/div/div[2]/div/div/div[4]/div

		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillMethod.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillQuantity.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillUnit.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillRoute.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillFrequency.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillduration.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillUsage.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillFrequency.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillduration.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}

		String dateStart = "";
		String datePres = "";
		if (account.equals(CAAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dateStart = DateFormat.format(cal.getTime());
			datePres = DateFormat.format(cal.getTime());
			if (!getText(selenium, lblExportPreviewSummary1)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							dateStart.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				waitForPageLoad(selenium);
				return false;
			}
			if (!getText(selenium, lblExportPreviewSummary1)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							datePres.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				waitForPageLoad(selenium);
				return false;
			}
		} else {
			Calendar cal1 = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateStart = DateFormat.format(cal1.getTime());
			datePres = DateFormat.format(cal1.getTime());
			if (!getText(selenium, lblExportPreviewSummary1)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							dateStart.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				waitForPageLoad(selenium);
				return false;
			}
			if (!getText(selenium, lblExportPreviewSummary1)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							datePres.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				waitForPageLoad(selenium);
				return false;
			}
		}

		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillFrequency.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}

		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillduration.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillRoute.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}

		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillQuantity.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillUnit.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}

		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.prescribeName.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		System.out.println(medicationData.concentration);
		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.concentration.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refill.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}

		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.prescribedby.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary1)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.comment.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		return true;
	}

	/**
	 * verifyStoredValueForMedicationExportChart function to verify eport chart
	 * values
	 * 
	 * @since Jan 17, 2012
	 */
	public boolean verifyStoredValueForMedicationsExportChart(
			Selenium selenium, ChartPreVisitLib medicationData, String account) {

		waitForPageLoad(selenium);
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillMethod.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillQuantity.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillUnit.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillRoute.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillFrequency.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillduration.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillUsage.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		String dateStart = "";
		String datePres = "";
		if (account.equals(CAAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dateStart = DateFormat.format(cal.getTime());
			datePres = DateFormat.format(cal.getTime());
			if (!getText(selenium, lblExportPreviewSummary)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							dateStart.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				waitForPageLoad(selenium);
				return false;
			}
			if (!getText(selenium, lblExportPreviewSummary)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							datePres.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				waitForPageLoad(selenium);
				return false;
			}
		} else {
			Calendar cal1 = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			dateStart = DateFormat.format(cal1.getTime());
			datePres = DateFormat.format(cal1.getTime());
			if (!getText(selenium, lblExportPreviewSummary)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							dateStart.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				waitForPageLoad(selenium);
				return false;
			}
			if (!getText(selenium, lblExportPreviewSummary)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							datePres.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				waitForPageLoad(selenium);
				return false;
			}

		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillFrequency.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillduration.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}

		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillFrequency.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}

		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillduration.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillRoute.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}

		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillQuantity.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillUnit.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}

		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.prescribeName.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}

		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refill.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}

		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.prescribedby.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.comment.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		return true;
	}

	/**
	 * verifyStoredValueForMedicationExportChart function to verify eport chart
	 * values
	 * 
	 * @since Jan 17, 2012
	 */
	public boolean verifyStoredValueForMedicationsExportChart(
			Selenium selenium, ChartPreVisitLib medicationData) {

		waitForPageLoad(selenium);
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillMethod.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillQuantity.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillUnit.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillRoute.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillFrequency.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillduration.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillUsage.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillFrequency.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillduration.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.startDate.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}

		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillFrequency.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}

		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillduration.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillRoute.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}

		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillQuantity.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refillUnit.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}

		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.prescribeName.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.concentration.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.refill.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.prescribeOn.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.prescribedby.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		if (!getText(selenium, lblExportPreviewSummary)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						medicationData.comment.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			return false;
		}
		return true;
	}

	/**
	 * deleteEncounter function to navigate To file Report
	 * @throws IOException 
	 * 
	 * @since Jan 21, 2013
	 */
	public boolean deleteEncounter(Selenium selenium, ChartPreVisitLib labData) throws IOException {
		int counter = 1;
		while (isElementPresent(selenium, encounterOptions)) {
			assertTrue(click(selenium, encounterOptions),
					"Could not click on encounter options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(
					click(selenium, "//div[contains(text(),'Delete')]"),
					"Could not click on delete button",selenium, ClassName, MethodName);

			assertTrue(
					type(selenium, txtdeleteReason, labData.userName),
					"Could not type delete reason",selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnDeleteReason),
					"Could not click on continue button",selenium, ClassName, MethodName);
			if (isElementPresent(selenium, "errorCloseButton"))
				assertTrue(click(selenium, "errorCloseButton"),"Could not click on Close Button",selenium, ClassName, MethodName);
			counter++;
			if (counter == 10)
				break;
		}
		return true;

	}


	/**
	 * deleteAllCurrentMedication Function for delete All existing pending
	 * medication
	 * 
	 * @param selenium
	 * @param prescribeData
	 * @return
	 * @throws IOException 
	 * @since Jan 22,2013
	 */
	public boolean deleteAllCurrentMedication(Selenium selenium,
			ChartPreVisitLib prescribeData) throws IOException {
		boolean medDeleted = true;
		int medCount = 0;
		try {
			waitForElement(selenium, lnkOption, WAIT_TIME);

			if (getText(selenium,
					"//div[@id='Medications']/table/tbody/tr[2]/td/div/div/div")
					.contains("Current:")) {
				while ((Integer) selenium.getXpathCount(btnCureentEdit) > 0) {
					medCount = (Integer) selenium.getXpathCount(btnCureentEdit);
					assertTrue(click(selenium, btnCureentEdit),"Could not click on Current Edit Button",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium, "//div[5]/div/div/div[5]"),"Could not click on the XPath ",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(
							type(selenium, txtDeleteReaseon,
									prescribeData.userPassword),
							"Could not type reason for deletion",selenium, ClassName, MethodName);
					assertTrue(click(selenium, btnContinue),
							"Could not click Delete button;More Details:"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					if (medCount == (Integer) selenium.getXpathCount(lnkOption)) {
						medDeleted = false;
						break;
					}

				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return medDeleted;
	}

	public boolean SearchPrescribeMedUnit(Selenium selenium,
			ChartPreVisitLibUnitTest prescribeData, String account) throws IOException {

		selectValueFromAjaxList(selenium, ajxProvider, prescribeData.provider);
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium, ajxLoaction, prescribeData.loaction);
		if (account.equals(CAAccount)) {
			assertTrue(
					selectValueFromAjaxList(selenium, ajxDrugsList,
							prescribeData.prescribeCa),
							"Could not type Prescribe Medication;More Details:"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		} else {
			assertTrue(
					selectValueFromAjaxList(selenium, ajxDrugsList,
							prescribeData.prescribe),
							"Could not type Prescribe Medication;More Details:"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}

		assertTrue(click(selenium, lnkEdit),
				"Could not click the Prescribe link;More Deatils:"
						+ prescribeData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;

	}

	/**
     * deleteAllEncounters Function for delete All existing encounters
     * 
      * @param selenium
     * @param prescribeData
     * @return
     * @throws IOException
     * @since Jan 24,2013
     */
     public boolean deleteAllEncounters(Selenium selenium,
                                     ChartPreVisitLib prescribeData) {
                     boolean medDeleted = true;

                     try {
                    	 while(isElementVisible(selenium, lnkShowMore))

                         {
                    		 assertTrue(click(selenium, lnkShowMore),"could not click on Show More", selenium, ClassName, MethodName);
                    		 waitForPageLoad(selenium);
                         }
                                     int count = 0;
                                     count=(Integer)selenium.getXpathCount(inkUnSignedEnCounterAction);
                                     while(count>0)
                                     {
                                    	 while(isElementVisible(selenium, lnkShowMore))

                                         {
                                    		 assertTrue(click(selenium, lnkShowMore),"could not click on Show More", selenium, ClassName, MethodName);
                                    		 waitForPageLoad(selenium);
                                         }


                                                     if (isElementPresent(selenium, inkUnSignedEnCounterAction+"["+count+"]")) {
                                                                     assertTrue(click(selenium, inkUnSignedEnCounterAction+"["+count+"]"),
                                                                                                     "Could not click on Actions button;More Details",
                                                                                                     selenium, ClassName, MethodName);
                                                                     waitForPageLoad(selenium);
                                                     
                                                                     if(isElementPresent(selenium,lnkDeleteEncounter))
                                                                     {
                                                                                     assertTrue(click(selenium, lnkDeleteEncounter),
                                                                                                                     "Could not click on delete button;More Details",
                                                                                                                     selenium, ClassName, MethodName);
                                                                                     waitForPageLoad(selenium);
                                                                                     assertTrue(type(selenium, txtdeleteReason, "Reason"),
                                                                                                                     "Could not type reason ;More Details", selenium,
                                                                                                                     ClassName, MethodName);
                                                                                     waitForPageLoad(selenium);
                                                                                     assertTrue(click(selenium, lnkDeleteReason),
                                                                                                                     "Could not click on Delete button;More Details",
                                                                                                                     selenium, ClassName, MethodName);
                                                                     }
                                                                     else if(isElementPresent(selenium, lnkEncounterPendingList+"["+count+"]/td"))
                                                                     {
                                                                    	 click(selenium, lnkEncounterPendingList+"["+count+"]/td");
                                                                    	 waitForPageLoad(selenium);
                                                                    	 if(isElementPresent(selenium,btnErrorClose))
                                                                         {
                                                                        	 click(selenium,btnErrorClose);
                                                                         }
                                                                    	 assertTrue(click(selenium, lnkEncounterAction),
                                                                    			 	"Could not click on delete button;More Details",
                                                                    			 	selenium, ClassName, MethodName);
                                                                    	 waitForPageLoad(selenium);
                                                                    	 assertTrue(click(selenium, lstActionSaveEncounter),
                                                                 			 	"Could not click on delete button;More Details",
                                                                 			 	selenium, ClassName, MethodName);
                                                                    	 waitForPageLoad(selenium);
                                                                    	 click(selenium, lnkencounterTab);
                                                                    	 waitForPageLoad(selenium);
                                                                    	 while(isElementVisible(selenium, lnkShowMore))

                                                                         {
                                                                           assertTrue(click(selenium, lnkShowMore),"could not click on Show More", selenium, ClassName, MethodName);
                                                                           waitForPageLoad(selenium);
                                                                         }
                                                                    	 assertTrue(click(selenium, inkUnSignedEnCounterAction+"["+count+"]"),
                                                                                 "Could not click on Actions button;More Details",
                                                                                 selenium, ClassName, MethodName);
                                                                    	 waitForPageLoad(selenium);
                                                                     }
                                                                     if(isElementPresent(selenium,lnkDeleteEncounter))
                                                                     {
                                                                    	 if(isElementPresent(selenium,btnErrorClose))
                                                                         {
                                                                        	 click(selenium,btnErrorClose);
                                                                         }
                                                                                     assertTrue(click(selenium, lnkDeleteEncounter),
                                                                                                                     "Could not click on delete button;More Details",
                                                                                                                     selenium, ClassName, MethodName);
                                                                                     waitForPageLoad(selenium);
                                                                                     assertTrue(type(selenium, txtdeleteReason, "Reason"),
                                                                                                                     "Could not type reason ;More Details", selenium,
                                                                                                                     ClassName, MethodName);
                                                                                     waitForPageLoad(selenium);
                                                                                     assertTrue(click(selenium, lnkDeleteReason),
                                                                                                                     "Could not click on Delete button;More Details",
                                                                                                                     selenium, ClassName, MethodName);
                                                                                     
                                                                     }
                                                                     waitForPageLoad(selenium);
                                                                     
                                                                     }
                                                     if(isElementPresent(selenium,btnErrorClose))
                                                     {
                                                    	 click(selenium,btnErrorClose);
                                                     }
                                     
                                                     count--;
                                     }

                     } catch (RuntimeException e) {
                                     e.printStackTrace();
                     } catch (IOException e) {
                                     e.printStackTrace();
                     }
                     return medDeleted;
     }

	/**
	 * clickLabIcon Function for delete All existing encounters
	 * 
	 * @param selenium
	 * @param prescribeData
	 * @return
	 * @since Jan 24,2013
	 */
	public boolean clickLabIcon(Selenium selenium,
			ChartPreVisitLib prescribeData) throws IOException {
		try 
		{
			int i = 0;
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,ajxProvidersuggestBox)){
			assertTrue(selectValueFromAjaxList(selenium, ajxProvidersuggestBox, prescribeData.RenderingProviderName),"Could not click on save button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			}
			selenium.focus(imgLabOrderIcon);
			selenium.clickAt(imgLabOrderIcon, "");
			waitForPageLoad(selenium);

			while (isElementPresent(selenium, imgLabOrderIcon)) {
				click(selenium, imgLabOrderIcon);
				if (isElementPresent(selenium, btnSave)) {
					return true;
				} else
					i++;
				if (i > 10) {
					break;
				}
			}
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return true;
	}

		
	/**
	 * clickDiIcon Function for delete All existing encounters
	 * 
	 * @param selenium
	 * @param prescribeData
	 * @return
	 * @since Jan 24,2013
	 */
	public boolean clickDiIcon(Selenium selenium, ChartPreVisitLib prescribeData) {

		try {
			int i = 0;
			waitForPageLoad(selenium);
			selenium.focus(imgDiOrderIcon);
			selenium.clickAt(imgDiOrderIcon, "");
			// assertTrue(click(selenium,"//img[@title='Order New Labs']"),"Could not click on lab order link");
			waitForPageLoad(selenium);

			while (isElementPresent(selenium, imgDiOrderIcon)) {

				click(selenium, imgDiOrderIcon);
				if (isElementPresent(selenium, btnDiagnosticSave)) {
					return true;
				} else
					i++;
				if (i > 10) {
					break;
				}

			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * clickReferralIcon Function for delete All existing encounters
	 * 
	 * @param selenium
	 * @param prescribeData
	 * @return
	 * @since Jan 24,2013
	 */
	public boolean clickReferralIcon(Selenium selenium,
			ChartPreVisitLib prescribeData) {

		try {
			int i = 0;
			waitForPageLoad(selenium);
			selenium.focus(imgReferralIcon);
			selenium.clickAt(imgReferralIcon, "");
			// assertTrue(click(selenium,"//img[@title='Order New Labs']"),"Could not click on lab order link");
			waitForPageLoad(selenium);

			while (isElementPresent(selenium, imgReferralIcon)) {

				click(selenium, imgReferralIcon);
				if (isElementPresent(selenium, btnReferral)) {
					return true;
				} else
					i++;
				if (i > 10) {
					break;
				}

			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * addVitals Function to create a Vitals
	 * @throws IOException 
	 * 
	 * @since Nov 09, 2012
	 */
	public boolean addVitalsForCds(Selenium selenium,
			ChartPreVisitLib vitalsData) throws IOException {
		if (isElementPresent(selenium, "errorCloseButton"))
			assertTrue(click(selenium, "errorCloseButton"),"Could not Click on Error Close Button",selenium, ClassName, MethodName);
		DecimalFormat df = new DecimalFormat(".##");
		try {
			waitForPageLoad(selenium);
			System.out.println(vitalsData.heightMU);
			if (vitalsData.heightMU.equals("cm")) {
				selectValueFromAjaxList(selenium, ajxHeight,
						vitalsData.heightMU);
				assertTrue(
						type(selenium, txtHeight, vitalsData.heightInCm),
						"could not type height in cm",selenium, ClassName, MethodName);

			} else {
				selectValueFromAjaxList(selenium, ajxHeight,
						vitalsData.heightMU);
				assertTrue(
						type(selenium, "heightFeet1", vitalsData.heightInFeet),
						"Could not type Hight in feet",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, "heightFeet2", vitalsData.heightInCm),
						"Could not type Hight in cm or inches",selenium, ClassName, MethodName);

				waitForPageLoad(selenium);

				waitForPageLoad(selenium);
			}

			if (vitalsData.testCaseId.equals("TC_CV_005"))
				getText(selenium, "//div[2]/div[4]/div").contains(
						vitalsData.htResult);
			if (vitalsData.testCaseId.equals("TC_CV_006"))
				getText(selenium, "//div[2]/div[4]/div").contains(
						vitalsData.htResult);
			// assertTrue(type(selenium,
			// "xpath=(//input[@type='text'])[7]", vitalsData.weight),
			// "Could not type weight");
			selectValueFromAjaxList(selenium, ajxWeight, vitalsData.weightMU);
			assertTrue(type(selenium, txtWeight, vitalsData.weight),
					"Could not type weight",selenium, ClassName, MethodName);

			// waitForPageLoad(selenium);
			if (vitalsData.testCaseId.equals("TC_CV_007"))
				getText(selenium, "//div[3]/div[2]/div[3]/div").contains(
						vitalsData.wtResult);
			if (vitalsData.testCaseId.equals("TC_CV_008"))
				getText(selenium, "//div[3]/div[2]/div[3]/div").contains(
						vitalsData.wtResult);
			if (vitalsData.testCaseId.equals("TC_CV_009")) {
				String kg = getValue(selenium,
						"xpath=(//input[@type='text'])[9]");
				float kgs = Float.valueOf(kg).floatValue();
				String cm = getValue(selenium,
						"xpath=(//input[@type='text'])[7]");
				float htInCm = Float.valueOf(cm).floatValue();
				float htInMetre = (float) (htInCm * 0.01);
				float BMI = kgs / (htInMetre * htInMetre);
				String expectedBMI = Float.toString(BMI);
				Assert.assertEquals(
						getText(selenium, "//div[4]/div/div/div[2]/div"),
						df.format(expectedBMI));
			}
			if (vitalsData.testCaseId.equals("TC_CV_010")) {
				String actuallbs = getValue(selenium,
						"xpath=(//input[@type='text'])[9]");
				Float lbs = Float.valueOf(actuallbs).floatValue();
				String cmS = getValue(selenium,
						"xpath=(//input[@type='text'])[7]");
				float cmF = Float.valueOf(cmS).floatValue();
				float inches = (float) (cmF / 2.54);
				float BMI2 = ((lbs * 703) / (inches * inches));
				String expectedBMI = Float.toString(BMI2);
				Assert.assertEquals(actuallbs, df.format(expectedBMI));
			}
			assertTrue(
					type(selenium, txtSystolic, vitalsData.systolicRate),
					"Could not type systolic Rate",selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtdiastolic, vitalsData.diastolicRate),
					"Could not type diastolic Rate",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxPosition, vitalsData.position);
			// waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxLimb, vitalsData.limb);
			// waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxCuffsize, vitalsData.cuffSize);
			// waitForPageLoad(selenium);
			assertTrue(type(selenium, txtheartRate, vitalsData.bPM),
					"Could not type Heart Rate",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxdescription,
					vitalsData.description);
			// waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxrhythm, vitalsData.rhythm);
			// waitForPageLoad(selenium);

			assertTrue(click(selenium, btnAdd),
					"Could not click on add button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if (isElementPresent(selenium, "errorCloseButton"))
				assertTrue(click(selenium, "errorCloseButton"),"Could not click on error Close Button",selenium, ClassName, MethodName);

			return true;
		} catch (RuntimeException e) {
			Assert.fail("Failed due to the Exception; \n Exception details: "
					+ e.getMessage());
			return false;
		}
	}

	/**
	 * verifyRefillForControlled function to add Prescribe Medication
	 * @throws IOException 
	 * 
	 * @since Mar 01, 2013
	 */
	public boolean verifyRefillForControlled(Selenium selenium,
			ChartPreVisitLib prescribeData) throws IOException {
		boolean returnValue = false;
		try {
			assertTrue(click(selenium, chkOneTimeOnly),
					"Could not click the one time only check box;More Details:"
							+ prescribeData.toString(),selenium, ClassName, MethodName);
			if (prescribeData.freeText.equals("Yes")) {
				if (!isChecked(selenium, chkFreeText))
					assertTrue(click(selenium, chkFreeText),
							"Could not click the Free text check box;More Details:"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtDirectionNotes,
								prescribeData.direction),
								"Could not enter the text;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
			}
			if (prescribeData.increaseDecreaseDose.equals("Yes")) {
				if (!isChecked(selenium, chkIncreaseDecreaseDirection))
					assertTrue(
							click(selenium, chkIncreaseDecreaseDirection),
							"Could not click the Increase/Decrease Dose check box;More Details:"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, "cmbInRefillMethod",
						prescribeData.refillMethod);

				selectValueFromAjaxList(selenium, ajxInRefillQuantity,
						prescribeData.refillQuantity);

				selectValueFromAjaxList(selenium, ajxInRefilUnit,
						prescribeData.refillUnit);

				selectValueFromAjaxList(selenium, ajxInRefillRoute,
						prescribeData.refillRoute);

				selectValueFromAjaxList(selenium, ajxInRefillFrequency,
						prescribeData.refillFrequency);

				selectValueFromAjaxList(selenium, ajxRefilUsage,
						prescribeData.refillUsage);

				selectValueFromAjaxList(selenium, ajxInRefillUsage,
						prescribeData.usage);

				assertTrue(
						type(selenium, txtDuration, prescribeData.duration),
						"Could not type the duration;More Details;"
								+ prescribeData.toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxInRefillUsage1,
						prescribeData.refillUsage1);

				selectValueFromAjaxList(selenium, ajxInRefillUsage2,
						prescribeData.refillUsage2);

				selectValueFromAjaxList(selenium, ajaxInRefillUsage3,
						prescribeData.refillUsage3);

				waitForPageLoad(selenium);
			}
			if (prescribeData.multipleDirection.equals("Yes")) {
				if (!isChecked(selenium, chkMultipleDirection))
					assertTrue(click(selenium, chkMultipleDirection),
							"Could not click the multiple direction check box;More Details:"
									+ prescribeData.toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxMDRefilMethod,
						prescribeData.refillMethod);

				selectValueFromAjaxList(selenium, ajxMDRefillQuantity,
						prescribeData.refillQuantity);

				selectValueFromAjaxList(selenium, ajxMDRefillUnit,
						prescribeData.refillUnit);

				selectValueFromAjaxList(selenium, ajxMDRefillRoute,
						prescribeData.refillRoute);

				selectValueFromAjaxList(selenium, ajxMDRefillFrequency,
						prescribeData.refillFrequency);

				selectValueFromAjaxList(selenium, ajxMDRefillDuration,
						prescribeData.refillduration);

				selectValueFromAjaxList(selenium, ajxMDRefillUsage,
						prescribeData.refillUsage1);

				selectValueFromAjaxList(selenium, ajxMDMethod,
						prescribeData.method);

				selectValueFromAjaxList(selenium, ajxMDQuantity,
						prescribeData.quality);

				selectValueFromAjaxList(selenium, ajxMDUnit, prescribeData.unit);

				selectValueFromAjaxList(selenium, ajxMDRoute,
						prescribeData.route);

				selectValueFromAjaxList(selenium, ajxMDFrequency,
						prescribeData.frequency);

				selectValueFromAjaxList(selenium, ajxMDDuration,
						prescribeData.duration);

				selectValueFromAjaxList(selenium, ajxMDUsage,
						prescribeData.usage);
				click(selenium, "//body/div[4]/div/div/div/div/div");
			} else if (!prescribeData.freeText.equals("Yes")
					&& !prescribeData.increaseDecreaseDose.equals("Yes")
					&& !prescribeData.multipleDirection.equals("Yes")) {

				selectValueFromAjaxList(selenium, ajxMethod,
						prescribeData.refillMethod);

				selectValueFromAjaxList(selenium, ajxQuantity,
						prescribeData.quality);

				selectValueFromAjaxList(selenium, ajxUnit, prescribeData.unit);

				selectValueFromAjaxList(selenium, ajxRoute, prescribeData.route);

				selectValueFromAjaxList(selenium, ajxFrequency,
						prescribeData.frequency);

				selectValueFromAjaxList(selenium, ajxDuration,
						prescribeData.duration);

				selectValueFromAjaxList(selenium, ajxRefillUsage,
						prescribeData.usage);

				assertTrue(
						type(selenium, txtDirectionNotes,
								prescribeData.direction),
								"Could not enter the text;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if (prescribeData.testCaseId.equalsIgnoreCase("TC_PM_023")
					|| prescribeData.testCaseId.equalsIgnoreCase("TC_PM_029")) {
				assertTrue(
						type(selenium, txtFreeFormText,
								prescribeData.prescribeName),
								"Could not enter the medication free text;More Details:"
										+ prescribeData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if (prescribeData.testCaseId.equalsIgnoreCase("TC_PM_013")) {
				selenium.clickAt(txtDirectionNotes, "");
				System.out.println(getText(selenium, lblAddDirection));
				assertTrue(getText(selenium, lblAddDirection)
						.equalsIgnoreCase(prescribeData.addDirectionCount),
						"Additional directions count is not deducted properly",selenium, ClassName, MethodName);
			}
			assertTrue(
					type(selenium, txtDispense, prescribeData.dispense),
					"Could not enter dispense;More Details:"
							+ prescribeData.toString(),selenium, ClassName, MethodName);
	
			assertTrue(
					type(selenium, txtDurationNo, prescribeData.dispense),
					"Could not enter dispense;More Details:"
							+ prescribeData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(
					click(selenium, btnNoButton),
					"Could not enter dispense;More Details:"
							+ prescribeData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxUnitList,
					prescribeData.unitList);
		

			if (getText(selenium, lblWithRefill).contains("with"))
				return false;
			else
				returnValue = true;
			if (getText(selenium, lblWithRefill).contains("refills"))
				return false;
			else
				returnValue = true;

			assertTrue(click(selenium, btnContinueId),
					"Could not click the Continue button;More Details:"
							+ prescribeData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if (isElementPresent(selenium, btnEdit))
				return true;
			else
				return false;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	public boolean createAllergyQuickList(Selenium selenium,
			ChartPreVisitLib allergyData, String account) throws IOException {
		try {
			waitForPageLoad(selenium);

			if (account.equalsIgnoreCase(CAAccount)) {
				if (isElementPresent(selenium, "allergenSuggestBox")) {
					selectValueFromAjaxList(selenium, "allergenSuggestBox",
							allergyData.allergenCa);
				} else if (isElementPresent(selenium, ajxSearchAllergy)) {
					selectValueFromAjaxList(selenium, ajxSearchAllergy,
							allergyData.allergenCa);
				}
			} else {
				if (isElementPresent(selenium, "allergenSuggestBox")) {
					selectValueFromAjaxList(selenium, "allergenSuggestBox",
							allergyData.allergen);
				} else if (isElementPresent(selenium, ajxSearchAllergy)) {
					selectValueFromAjaxList(selenium, ajxSearchAllergy,
							allergyData.allergen);
				}
			}

			if (!allergyData.testCaseId.equals("TC_CA_001")) {
				if (getText(selenium, lnkAllergyShowmore).equalsIgnoreCase(
						"Show more details")) {
					assertTrue(click(selenium, lnkAllergyShowmore),
							"Could not on show more button",selenium, ClassName, MethodName);
				}
			}
			assertTrue(selectValueFromAjaxList(selenium, ajxStatus,allergyData.status),
					"Could not click the add button;More details:"
							+ allergyData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, ajxAllergyReaction),"Could not click Allergy reaction link"
					+ allergyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			int count=(Integer)selenium.getXpathCount(chkAllergyReaction);
			while(count>0){
				String xpath=lblAllergyReaction+"["+count+"]";
				if(getText(selenium, xpath).contains(allergyData.reaction)){
					click(selenium, chkAllergyReaction+"["+count+"]");
					break;
				}
				count--;
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSelectionClose),"Could not click Close button"
					+ allergyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			if (!isChecked(selenium, chkQuickList))
				assertTrue(click(selenium, chkQuickList),
						"Could not click the Save Quick List check box;More Details:"
								+ allergyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, btnAdd),
					"Could not click the add button;More details:"
							+ allergyData.toString(),selenium, ClassName, MethodName);

			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * SaveImmunizationQuickList function to SaveImmunication to QuickList
	 * @throws IOException 
	 * 
	 * @since March 15, 2013
	 */

	public boolean SaveImmunizationQuickList(Selenium selenium,
			ChartPreVisitLib QuicklstData, String account) throws IOException {
		try {

			if (QuicklstData.saveList.equals("yes")) {
				String date = "";
				if (isChecked(selenium, chkrefused))
					assertTrue(click(selenium, chkrefused),
							"Could not click refused check box;More Details:"
									+ QuicklstData.toString(),selenium, ClassName, MethodName);

				if (isChecked(selenium, chkadmin))
					assertTrue(click(selenium, chkadmin),
							"Could not click the admin check box;More Details:"
									+ QuicklstData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (account.equals(CAAccount)) {
					assertTrue(selectValueFromAjaxList(selenium, ajxVaccine,
							QuicklstData.vaccine),
							"Could not select vaccine",selenium, ClassName, MethodName);
				}
				else
				{
					assertTrue(selectValueFromAjaxList(selenium, ajxVaccine,
							QuicklstData.vaccineUS),
							"Could not select vaccine",selenium, ClassName, MethodName);
				}
			
				assertTrue(
						type(selenium, txtLotNo, QuicklstData.lotNumber),
						"Could not enter the lot number",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtImmDosage, QuicklstData.dosage),
						"Could not enter the dosage value;More Details:"
								+ QuicklstData.toString(),selenium, ClassName, MethodName);

				selectValueFromAjaxList(selenium, ajxImmdosage,
						QuicklstData.dosageUnit);

				if (account.equals(CAAccount)) {
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat DateFormat = new SimpleDateFormat(
							"dd/MM/yyyy");
					date = DateFormat.format(cal.getTime());

				} else {
					Calendar cal1 = Calendar.getInstance();
					SimpleDateFormat DateFormat = new SimpleDateFormat(
							"MM/dd/yyyy");
					date = DateFormat.format(cal1.getTime());
				}

				assertTrue(enterDate(selenium, txtexpiryDate, date),
						"Could not enter the expiry date ;More Details:"
								+ QuicklstData.toString(),selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium, txtadminDate, date),
						"Could not enter the Admin on ;More Details:"
								+ QuicklstData.toString(),selenium, ClassName, MethodName);

				assertTrue(
						click(selenium, lnkImmShowMore),
						"Could not click the link;More Details:"
								+ QuicklstData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				selectValueFromAjaxList(selenium, ajxSite, QuicklstData.site);
				waitForPageLoad(selenium);

				selectValueFromAjaxList(selenium, ajxImmRoute,
						QuicklstData.route);
				waitForPageLoad(selenium);

				selectValueFromAjaxList(selenium, ajxImmCpt1,
						QuicklstData.cptCode1);
				waitForPageLoad(selenium);

				selectValueFromAjaxList(selenium, ajxImmCp2,
						QuicklstData.cptCode2);
				waitForPageLoad(selenium);

				if (!isChecked(selenium, chkQuickList))
					assertTrue(click(selenium, chkQuickList),
							"Could not click the Save Quick List check box;More Details:"
									+ QuicklstData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

				assertTrue(click(selenium, btnAdd),
						"Could not click add button;More Details"
								+ QuicklstData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

			}

			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * createSocialHistory for QuickList function to create SocialHistory for
	 * QuickList
	 * @throws IOException 
	 * 
	 * @since March 25, 2013
	 */
	public boolean createSocialHistoryQuickList(Selenium selenium,
			ChartPreVisitLib socialData) throws IOException {
		try {

			selectValueFromAjaxList(selenium, ajxType, socialData.type);
			click(selenium, "//body/div[4]/div/div/div/div/div");
			assertTrue(
					type(selenium, ajxOtherType, socialData.item),
					"Could not enter the other type;More Details:"
							+ socialData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkSocialShowMore),
					"Could not click on show more button",selenium, ClassName, MethodName);

			assertTrue(
					type(selenium, "socialHistoryQuicklist", socialData.item),
					"Could not enter item details;More Details:"
							+ socialData.toString(),selenium, ClassName, MethodName);

			if (!isChecked(selenium, chkQuickList))
				assertTrue(click(selenium, chkQuickList),
						"Could not click the Save Quick List check box;More Details:"
								+ socialData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(
					click(selenium, btnAdd),
					"Could not click add button;More Details"
							+ socialData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * createFamilyHistory for QuickList function to create FamilyHistory for
	 * QuickList
	 * @throws IOException 
	 * 
	 * @since March 18, 2013
	 */
	public boolean createFamilyHistoryQuickList(Selenium selenium,
			ChartPreVisitLib historyData) throws IOException {
		try {

			assertTrue(
					type(selenium, ajxFamilyMedical, historyData.medical),
					"Could not enter the medical",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			selectValueFromAjaxList(selenium, ajxCodeingSystem,
					historyData.codingSystem);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxdiagnosis,
					historyData.diagnosis);
			waitForPageLoad(selenium);

			if (!isChecked(selenium, chkQuickList))
				assertTrue(click(selenium, chkQuickList),
						"Could not click the Save Quick List check box;More Details:"
								+ historyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(
					click(selenium, btnAdd),
					"Could not click add button;More Details"
							+ historyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * verify QuickList View For Medication function to create Procedure
	 * @throws IOException 
	 * 
	 * @since Sep 28, 2012
	 */

	public boolean verifyQuickListViewForMedication(Selenium selenium,
			ChartPreVisitLib medicationData, String account) throws IOException {
		try {
			if (account.equals(CAAccount)) {
				type(selenium, ajxSearchMedication, medicationData.prescribeCa);
			} else {
				type(selenium, ajxSearchMedication, medicationData.prescribe);
			}

			assertTrue(click(selenium, btnQuickMedication),"Could not click the QuickList button;More details:"+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			if (account.equals(CAAccount)) {
				assertTrue(
						click(selenium,
								tabEmailMethod),
								"Could not click the added quick list;More Details:"
										+ medicationData.toString(),selenium, ClassName, MethodName);
			} else {
				assertTrue(
						click(selenium,	tabEmailMethod),"Could not click the added quick list;More Details:"+ medicationData.toString(),selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);			
			if (account.equals(CAAccount)) {				
				assertTrue(getValue(selenium, ajxSearchMedication).toLowerCase(new java.util.Locale("en", "US")).trim().contains(medicationData.prescribeCa.toLowerCase(new java.util.Locale("en", "US")).trim()),"Could not find  Medication name;More details:"+ medicationData.toString(),selenium, ClassName, MethodName);
				
			} else {
				
				assertTrue(getValue(selenium, ajxSearchMedication).toLowerCase(new java.util.Locale("en", "US")).trim().contains(medicationData.prescribe.toLowerCase(new java.util.Locale("en", "US")).trim()),"Could not find Medication name ;More details:"+ medicationData.toString(),selenium, ClassName, MethodName);
				
				
			}

			if (getText(selenium, lnkMedsShowMore).equalsIgnoreCase("Show more details"))
					 {
				assertTrue(click(selenium, lnkMedsShowMore),
						"Could not on show more button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}

			if (!medicationData.testCaseId.equals("TC_QLM_002")) {
				
				
				assertTrue(getValue(selenium, ajxMethod).trim().contains(medicationData.refillMethod.trim()),"Could not find Method text ;More details:"+ medicationData.toString(),selenium, ClassName, MethodName);
				
				assertTrue(getValue(selenium, ajxUnit).trim().contains(medicationData.refillUnit.trim()),"Could not find unot ;More details:"+ medicationData.toString(),selenium, ClassName, MethodName);
			
				

				if (account.equals(CAAccount)) {
					
					assertTrue(getValue(selenium, ajxFrequency).trim().contains(	medicationData.refillFrequencyCa.trim()),"Could not find Frequency;More details:"+ medicationData.toString(),selenium, ClassName, MethodName);
					
					assertTrue(getValue(selenium, ajxQuantity).trim().contains(medicationData.refillQuantityCa.trim()),"Could not find Quantity;More details:"+ medicationData.toString(),selenium, ClassName, MethodName);
					
					assertTrue(getValue(selenium, ajxRoute).trim().contains(medicationData.refillRouteCa.trim()),"Could not find Route;More details:"+ medicationData.toString(),selenium, ClassName, MethodName);
					
				
				} else {
					assertTrue(getValue(selenium, ajxFrequency).trim().contains(medicationData.refillFrequency.trim()),"Could not find ;More details:"+ medicationData.toString(),selenium, ClassName, MethodName);
					
					assertTrue(getValue(selenium, ajxQuantity).trim().contains(medicationData.refillQuantity.trim()),"Could not find ;More details:"+ medicationData.toString(),selenium, ClassName, MethodName);
					
					assertTrue(getValue(selenium, ajxRoute).trim().contains(medicationData.refillRoute.trim()),"Could not find ;More details:"+ medicationData.toString(),selenium, ClassName, MethodName);
					
					
				
				}
			
				
			//	assertTrue(getValue(selenium, ajxDuration).trim().contains(medicationData.refillduration.trim()),"Could not find Duration;More details:"+ medicationData.toString(),selenium, ClassName, MethodName);
				
				assertTrue(getValue(selenium, ajxRefillUsage).trim().contains(medicationData.refillUsage.trim()),"Could not find Refill usage;More details:"+ medicationData.toString(),selenium, ClassName, MethodName);
				
			
			}
			
			assertTrue(getValue(selenium, txtRefill).trim().contains(medicationData.refill.trim()),"Could not find ;More details:"+ medicationData.toString(),selenium, ClassName, MethodName);
			
			assertTrue(!getValue(selenium, txtComment).trim().contains(medicationData.comment),"Could not find ;More details:"+ medicationData.toString(),selenium, ClassName, MethodName);

			
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * verify QuickListView For ProblemList function to create Procedure
	 * @throws IOException 
	 * 
	 * @since Sep 28, 2012
	 */
	public boolean verifyQuickListViewForProblemList(Selenium selenium,
			ChartPreVisitLib proData, String account) throws IOException {
		try {
			// String date=null;

			assertTrue(type(selenium, txtMedicatl, proData.quickList),
					"Could not type the problem list",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(
					click(selenium, "medicalConditionQuickListButton"),
					"Could not click the QuickList button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			if (getText(selenium, lblQuickValue1)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							proData.finalCheck.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				assertTrue(click(selenium, lblQuickValue1),
						"Could not click the quicklist problem list;More Details"
								+ proData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}

			assertTrue(click(selenium, lnkProblemListShowMore),
					"Could not on show more button",selenium, ClassName, MethodName);

			System.out.println(getValue(selenium, txtMedicatl).toLowerCase(
					new java.util.Locale("en", "US")));
			System.out.println(proData.quickList.trim().toLowerCase(
					new java.util.Locale("en", "US")));

			if (!getValue(selenium, txtMedicatl)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							proData.quickList.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				return false;
			}

			/*
			 * if(account.equals(CAAccount)){ Calendar
			 * cal=Calendar.getInstance(); SimpleDateFormat DateFormat=new
			 * SimpleDateFormat("MMM dd,yyyy");
			 * date=DateFormat.format(cal.getTime());
			 * if(!getValue(selenium,txtOnset).trim().contains(date.trim())){
			 * return false; } }else{ Calendar cal1=Calendar.getInstance();
			 * SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			 * date=DateFormat.format(cal1.getTime());
			 * if(!getValue(selenium,txtOnset).trim().contains(date.trim())){
			 * return false; } }
			 * 
			 * if(!getValue(selenium,ajxItem).toLowerCase(new
			 * java.util.Locale("en"
			 * ,"US")).trim().contains(proData.itemStatus.trim().toLowerCase(new
			 * java.util.Locale("en","US")))){ return false; }
			 * 
			 * assertTrue(click(selenium,"lnkProblemListShowMore"),
			 * "Could not on show more button");
			 * 
			 * if(!getValue(selenium,ajxlifeStage).toLowerCase(new
			 * java.util.Locale
			 * ("en","US")).trim().contains(proData.lifeStage.trim
			 * ().toLowerCase(new java.util.Locale("en","US")))){ return false;
			 * } if(account.equals(CAAccount)){
			 * if(!getValue(selenium,txtResolvedDate
			 * ).trim().contains(date.trim())){ return false; } }else
			 * if(!getValue
			 * (selenium,txtResolvedDate).trim().contains(date.trim())){ return
			 * false; }
			 
			if (!getValue(selenium, ajxCodeingSystem)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							proData.codingSystem.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				return false;
			}*/
			
			/*
			 * if(!getValue(selenium,txtcomment).toLowerCase(new
			 * java.util.Locale
			 * ("en","US")).trim().contains(proData.comment.trim(
			 * ).toLowerCase(new java.util.Locale("en","US")))){ return false; }
			 */
			return true;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * verifyQuickListViewForProblemListInAssessment function to
	 * verifyQuickListViewForProblemListInAssessment
	 * 
	 * @since Apr 16, 2013
	 */
	public boolean verifyQuickListViewForProblemListInAssessment(
			Selenium selenium, ChartPreVisitLib proData, String account) {
		String date = null;
		if (account.equals(CAAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = DateFormat.format(cal.getTime());
		} else {
			Calendar cal1 = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat.format(cal1.getTime());
		}
		if (!getText(selenium, lblAssessmentDetails)
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						proData.quickList.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			return false;
		}
		if (!getText(selenium, lblAssessmentDetails)
				.toLowerCase(new java.util.Locale("en", "US")).trim()
				.contains(date.trim())) {
			return false;
		}
		/*
		 * if(!getText(selenium,lblAssessmentDetails).toLowerCase(new
		 * java.util.Locale
		 * ("en","US")).trim().contains(proData.diagnosis.trim().toLowerCase(new
		 * java.util.Locale("en","US")))){ return false; }
		 */
		return true;
	}

	/**
	 * verify QuickListView For Allergy
	 * @throws IOException 
	 * 
	 * @since March 20, 2012
	 */

	public boolean verifyQuickListViewForAllergy(Selenium selenium,
			ChartPreVisitLib proData, String account) throws IOException {
		try {
			if (account.equalsIgnoreCase(CAAccount)) {
				assertTrue(type(selenium, ajxSearchAllergy, proData.allergenCa),"Could not type the Allergy",selenium, ClassName, MethodName);
			} else {
				assertTrue(
						type(selenium, ajxSearchAllergy, proData.allergen),"Could not type the Allergy",selenium, ClassName, MethodName);

			}
		
			assertTrue(click(selenium, btnAllergyQuickList),"Could not click the QuickList button",selenium, ClassName, MethodName);

			waitForPageLoad(selenium);
			if (account.equalsIgnoreCase(CAAccount)) {
				if (getText(selenium, lblQuickValue1).toLowerCase(new java.util.Locale("en", "US")).trim().contains(			proData.allergenCa.trim().toLowerCase(
										new java.util.Locale("en", "US")))) {
					assertTrue(click(selenium, lblQuickValue1),
							"Could not click the quicklist family history list;More Details"
									+ proData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			} else {
				if (getText(selenium, lblQuickValue1).toLowerCase(new java.util.Locale("en", "US")).trim().contains(proData.allergen.trim().toLowerCase(new java.util.Locale("en", "US")))) {
					assertTrue(click(selenium, lblQuickValue1),
							"Could not click the quicklist Allergy list value;More Details"
									+ proData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			}

			if (getText(selenium, lnkAllergyShowmore).equalsIgnoreCase(
					"Show more details")) {
				assertTrue(click(selenium, lnkAllergyShowmore),
						"Could not on show more button",selenium, ClassName, MethodName);
			}

			if (account.equalsIgnoreCase(CAAccount)) {
				assertTrue(getValue(selenium, ajxSearchAllergy).toLowerCase(new java.util.Locale("en", "US")).trim().equalsIgnoreCase(proData.allergenCa.trim().toLowerCase(new java.util.Locale("en", "US"))),	"Could  nit find Allergn details",selenium, ClassName, MethodName);
			} else {
				
				if (!getValue(selenium, ajxSearchAllergy).toLowerCase(new java.util.Locale("en", "US")).trim().contains(proData.allergen.trim().toLowerCase(new java.util.Locale("en", "US")))) {
					
					return false;
				}
			}
			assertTrue(selenium.isTextPresent(proData.reaction),"Could not finf reaction text",selenium, ClassName, MethodName);
		
		
	
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * verify QuickListView For Social History
	 * @throws IOException 
	 * 
	 * @since March 25, 2013
	 */

	public boolean verifyQuickListViewForSocialHistory(Selenium selenium,
			ChartPreVisitLib socialData, String account) throws IOException {
		try {

			assertTrue(click(selenium, lnkSocialShowMore),
					"Could not click on show more button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(
					type(selenium, "socialHistoryQuicklist", socialData.item),
					"Could not enter item details;More Details:"
							+ socialData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, "socialHistoryQuicklistButton"),
					"Could not click the QuickList button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			if (getText(selenium, lblQuickValue1)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							socialData.item.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				assertTrue(click(selenium, lblQuickValue1),
						"Could not click the quicklist family history list;More Details"
								+ socialData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}

			if (!getValue(selenium, ajxType)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.equalsIgnoreCase(
							socialData.type.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				return false;
			}

			if (!getValue(selenium, ajxOtherType)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.equalsIgnoreCase(
							socialData.item.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				return false;
			}

			if (!getValue(selenium, "socialHistoryQuicklist")
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							socialData.item.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				return false;
			}

			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * verify QuickListView For Immunization
	 * @throws IOException 
	 * 
	 * @since March 20, 2012
	 */

	public boolean verifyQuickListViewForImmunization(Selenium selenium,
			ChartPreVisitLib proData, String account) throws IOException {
		try {
			System.out.println(getText(selenium, lnkImmShowMore));
			if (account.equals(CAAccount)) {
				assertTrue(type(selenium, ajxVaccine, proData.vaccine),
						"Could not type the immunization",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			else
			{
				assertTrue(type(selenium, ajxVaccine, proData.vaccineUS),
						"Could not type the immunization",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
		

			assertTrue(click(selenium, btnImmQuickList),
					"Could not click the QuickList button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if (account.equals(CAAccount)) {
				
				if (getText(selenium, lblQuickValue1).toLowerCase(new java.util.Locale("en", "US")).trim().contains(proData.vaccine.trim().toLowerCase(new java.util.Locale("en", "US"))))
				
					assertTrue(click(selenium, lblQuickValue1),
							"Could not click the quicklist problem list;More Details"
									+ proData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				
					assertTrue(getValue(selenium, ajxVaccine)
							.toLowerCase(new java.util.Locale("en", "US"))
							.trim()
							.equalsIgnoreCase(
									proData.vaccine1.trim().toLowerCase(
											new java.util.Locale("en", "US")))
							,
							"Could not find vaccine vame;More Details:"
									+ proData.toString(),selenium, ClassName, MethodName);
							}
			else
			{
				
				assertTrue(getText(selenium, lblQuickValue1)
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								proData.vaccineUS.trim().toLowerCase(
										new java.util.Locale("en", "US"))),
										"Could not click the quicklist problem list;More Details"
												+ proData.toString(),selenium, ClassName, MethodName);
					assertTrue(click(selenium, lblQuickValue1),
												"Could not click the quicklist problem list;More Details"
														+ proData.toString(),selenium, ClassName, MethodName);
					
				
					
					waitForPageLoad(selenium);
					assertTrue(getValue(selenium, ajxVaccine)
							.toLowerCase(new java.util.Locale("en", "US"))
							.trim()
							.equalsIgnoreCase(
									proData.vaccineNameUS.trim().toLowerCase(
											new java.util.Locale("en", "US")))
							,
							"Could not find vaccine vame;More Details:"
									+ proData.toString(),selenium, ClassName, MethodName);
				
			}
			
		
			System.out.println(getText(selenium, lnkImmShowMore));
			if (getText(selenium, lnkImmShowMore).equalsIgnoreCase(
					"Show more details")) {
				assertTrue(
						click(selenium, lnkImmShowMore),
						"Could not click the link;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			}
		
			waitForPageLoad(selenium);
			String date = "";
		
		
	
			
			assertTrue(getValue(selenium, txtLotNo)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							proData.lotNumber.trim().toLowerCase(
									new java.util.Locale("en", "US")))
					,
					"Could not find ;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);

			assertTrue(getValue(selenium, txtImmDosage)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							proData.dosage.trim().toLowerCase(
									new java.util.Locale("en", "US")))
					,
					"Could not find ;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			
			
			assertTrue(getValue(selenium, ajxImmdosage)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							proData.dosageUnit.trim().toLowerCase(
									new java.util.Locale("en", "US")))
					,
					"Could not find ;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			
			
		
			waitForPageLoad(selenium);

			if (account.equals(CAAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat(
						"MMM dd,yyyy");
				date = DateFormat.format(cal.getTime());
				/*
				 * if(!getValue(selenium,expiryDate).trim().contains(date.trim())
				 * ){ return false; }
				 */
			} else {
				Calendar cal1 = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal1.getTime());
				/*
				 * if(!getValue(selenium,expiryDate).trim().contains(date.trim())
				 * ){ return false; }
				 */
			}
			
			assertTrue(
					click(selenium, lnkImmShowMore),
					"Could not click the link;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			waitForPageLoad(selenium);
			if (!isElementPresent(selenium, ajxSite)) 
				
			{
				assertTrue(click(selenium,lnkShowMoreSocial ),"Could not click show more details link",selenium,ClassName,MethodName);
				
			}

			assertTrue(getValue(selenium, ajxSite)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							proData.site.trim().toLowerCase(
									new java.util.Locale("en", "US")))
					,
					"Could not find ;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			
			
			
			assertTrue(getValue(selenium, ajxImmRoute)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.equalsIgnoreCase(
							proData.route.trim().toLowerCase(
									new java.util.Locale("en", "US")))
					,
					"Could not find ;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			
			assertTrue(getValue(selenium, ajxImmCpt1)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							proData.cptCode1.trim().toLowerCase(
									new java.util.Locale("en", "US")))
					,
					"Could not find ;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			
			assertTrue(getValue(selenium, ajxImmCp2).toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							proData.cptCode2.trim().toLowerCase(
									new java.util.Locale("en", "US")))
					,
					"Could not find ;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);
		
			waitForPageLoad(selenium);

			// waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}




	/**
	 * verify QuickListView For Family History
	 * @throws IOException 
	 * 
	 * @since March 20, 2012
	 */

	public boolean verifyQuickListViewForFamilyHistory(Selenium selenium,
			ChartPreVisitLib proData, String account) throws IOException {
		try {
			assertTrue(
					type(selenium, ajxFamilyMedical, proData.medical),
					"Could not type the family history",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, btnFamilyQuickList),
					"Could not click the QuickList button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			System.out.println(getText(selenium,
					"css=span.gwt-InlineLabel.descriptionLabel"));

			if (getText(selenium, "css=span.gwt-InlineLabel.descriptionLabel")
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							proData.medical.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				assertTrue(isElementPresent(selenium, imgStarIcon),
						"Could not find the user",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(
						click(selenium,
								"css=span.gwt-InlineLabel.descriptionLabel"),
								"Could not click the quicklist family history list;More Details"
										+ proData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}

			assertTrue(
					click(selenium, lnkFamilkShowMoreDeatils),
					"Could not click the link;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);

			if (!getValue(selenium, ajxFamilyMedical)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.equalsIgnoreCase(
							proData.medical.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				return false;
			}
			if (!getValue(selenium, ajxCodeingSystem)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							proData.codingSystem.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				return false;
			}
			if (!getValue(selenium, ajxdiagnosis)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							proData.diagnosis.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				return false;
			}

			
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * searchPractice function to search Practice
	 * @throws IOException 
	 * 
	 * @since Mar 21, 2013
	 */

	public boolean searchPractice(Selenium selenium, String practiceName) throws IOException {
		int count = 1;
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		while (getText(selenium, "//td[2]/div/div/div/div[2]/div/div")
				.toLowerCase(new java.util.Locale("en", "US"))
				.trim()
				.contains(
						practiceName.trim().toLowerCase(
								new java.util.Locale("en", "US")))) {
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if (getText(selenium,
					"//div[@id='practices']/table/tbody/tr[" + count + "]/td")
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							practiceName.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				waitForPageLoad(selenium);
				assertTrue(click(selenium,
						"//div[@id='practices']/table/tbody/tr[" + count
						+ "]/td"),"Could not click on the link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				break;
			} else if (getText(selenium, "xpath=(//button[@type='button'])[2]")
					.equalsIgnoreCase("Search")) {
				type(selenium, txtMedsSearchTextBox, practiceName);
				click(selenium, "xpath=(//button[@type='button'])[2]");
				waitForPageLoad(selenium);
				if (getText(
						selenium,
						"//div[@id='practices']/table/tbody/tr[" + count
						+ "]/td")
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								practiceName.trim().toLowerCase(
										new java.util.Locale("en", "US")))) {
					assertTrue(click(selenium,
							"//div[@id='practices']/table/tbody/tr[" + count
							+ "]/td"),"Could not click on practice link",selenium, ClassName, MethodName);
					break;
				}
			}
			count++;
			if (count > 20)
				break;
		}
		waitForPageLoad(selenium);
		if (isElementPresent(selenium, btnEdit)) {
			return true;
		} else
			return false;
	}
	
	/**
	 * verifyQuickListViewForInjection function to
	 * verifyQuickListViewForInjection
	 * @throws IOException 
	 * 
	 * @since Sep 28, 2012
	 */

	public boolean verifyQuickListViewForInjection(Selenium selenium,
			ChartPreVisitLib QuicklstData, String account) throws IOException {
		String date = null;
		try {

			assertTrue(
					type(selenium, txtQuickinjection, QuicklstData.injection),
					"Could not type the injection;More Details:"
							+ QuicklstData.toString(),selenium, ClassName, MethodName);
		

			selenium.focus(btnInjection);
			selenium.click(btnInjection);
			selenium.click(btnInjection);
			waitForPageLoad(selenium);
			if (getText(selenium, lstUnsignedEncShow)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							QuicklstData.injection.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				assertTrue(click(selenium, lstUnsignedEncShow),
						"Could not click the quicklist problem list;More Details"
								+ QuicklstData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}

			 /*click(selenium, lnkInjectionShowMore);
			waitForPageLoad(selenium); */

			if (!getValue(selenium, txtQuickinjection).trim().contains(
					QuicklstData.injection.trim())) {
				return false;
			}

			/*if (!getValue(selenium, txtDosage).trim().contains(
					QuicklstData.dosage.trim())) {
				return false;
			}
*/
			if (!getValue(selenium, ajxDosageUnit).trim().contains(
					QuicklstData.dosageUnit.trim())) {
				return false;
			}
			if (!getValue(selenium, txtLotNo).trim().contains(
					QuicklstData.lotNumber.trim())) {
				return false;
			}

			// Get current Date and Time
			if (account.equals(CAAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat(
						"MMM dd,yyyy");
				date = DateFormat.format(cal.getTime());
			} else {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal.getTime());
			}

			/*
			 * if(!getValue(selenium,expiryDate).trim().contains(date.trim())){
			 * return false; }
			 */

			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = DateFormat.format(cal.getTime());

			// if(!getValue(selenium,adminOn).trim().contains(date.trim())){
			// return false;
			// }
			/*
			 * if(!getText(selenium,adminBy).trim().contains(QuicklstData.adminBy
			 * .trim())){ return false; }
			 */
			if (!getValue(selenium, "siteSuggestBoxsuggestBox")
					.toLowerCase(new java.util.Locale("en", "Us"))
					.trim()
					.contains(
							QuicklstData.site.trim().toLowerCase(
									new java.util.Locale("en", "Us")))) {
				return false;
			}
			if (!getValue(selenium, ajxInjectionRoute)
					.toLowerCase(new java.util.Locale("en", "Us"))
					.trim()
					.contains(
							QuicklstData.route.trim().toLowerCase(
									new java.util.Locale("en", "Us")))) {
				return false;
			}

			/*
			 * if(!getText(selenium,"reactionSuggestBoxsuggestBox").toLowerCase(new
			 * java
			 * .util.Locale("en","Us")).trim().contains(QuicklstData.reaction
			 * .trim().toLowerCase(new java.util.Locale("en","Us")))){ return
			 * false; } if(!getText(selenium,txtcomment).toLowerCase(new
			 * java.util
			 * .Locale("en","Us")).trim().contains(QuicklstData.comment.
			 * trim().toLowerCase(new java.util.Locale("en","Us")))){ return
			 * false; }
			 */

			if (!getValue(selenium, ajxCptCode1).trim().contains(
					QuicklstData.cptCode1.trim())) {
				return false;
			}
			if (!getValue(selenium, ajxCptCode2).trim().contains(
					QuicklstData.cptCode2.trim())) {
				return false;
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return true;


	}
	/**
	 * createFamilyHistory for QuickList function to create FamilyHistory for
	 * QuickList
	 * @throws IOException 
	 * 
	 * @since March 18, 2013
	 */
	public boolean createProcedureQuickList(Selenium selenium,
			ChartPreVisitLib proData, String account) throws IOException {
		try {

			String date = "";
			if (proData.testCaseId.equalsIgnoreCase("TC_CP_002")
					|| proData.testCaseId.equalsIgnoreCase("TC_CP_016")
					|| proData.testCaseId.equalsIgnoreCase("TC_CP_015")) {
				if (!isChecked(selenium, chkQuickList)) {
					assertTrue(click(selenium, chkQuickList),
							"Could not click the Save Quick List check box;More Details:"
									+ proData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			}
			assertTrue(
					type(selenium, txtProcedureName, proData.proName),
					"Could not type procedure name",selenium, ClassName, MethodName);

			if (proData.testCaseId.equalsIgnoreCase("TC_CP_016")) {
				assertTrue(click(selenium, btnAdd),
						"Could not click the add button;More details:"
								+ proData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				return true;
			}

			if (account.equals(CAAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				date = DateFormat.format(cal.getTime());
				assertTrue(
						enterDate(selenium, txtProcedureDate, date),
						"Could not enter the Admin on ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			} else {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal.getTime());
				assertTrue(
						enterDate(selenium, txtProcedureDate, date),
						"Could not enter the Admin on ;More Details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			}
			if (proData.testCaseId.equals("TC_CP_002")) {
				assertTrue(click(selenium, lnkProcedureShowMore),
						"Could not on show more button",selenium, ClassName, MethodName);
	

				selectValueFromAjaxList(selenium, txtcpt, proData.cpt);

				// assertTrue(type(selenium,comment,proData.comment),"Could not enter the comment;More Details:"+proData.toString(),selenium, ClassName, MethodName);

			}

			waitForPageLoad(selenium);

			assertTrue(
					click(selenium, btnAdd),
					"Could not click the add button;More details:"
							+ proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * verify QuickListView For Procedure
	 * @throws IOException 
	 * 
	 * @since March 20, 2012
	 */
	public boolean verifyQuickListViewForProcedure(Selenium selenium,
			ChartPreVisitLib proData, String account) throws IOException {
		try {

			// String date=null;

			assertTrue(
					type(selenium, txtProcedureName, proData.proName),
					"Could not type procedure",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, btnProcedureQuickList),
					"Could not click the QuickList button;More details:"
							+ proData.toString(),selenium, ClassName, MethodName);

			if (!isElementPresent(selenium, imgStarIcon)) {
				return false;
			}
			if (getText(selenium, lblQuickValue1)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							proData.proName.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				assertTrue(click(selenium, lblQuickValue1),
						"Could not click the quicklist procedure;More Details"
								+ proData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}

			assertTrue(click(selenium, lnkProcedureShowMore),
					"Could not on show more button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			/*
			 * if(account.equals(CAAccount)){ Calendar
			 * cal=Calendar.getInstance(); SimpleDateFormat DateFormat=new
			 * SimpleDateFormat("dd/MM/yyyy");
			 * date=DateFormat.format(cal.getTime()); }else{ Calendar
			 * cal=Calendar.getInstance(); SimpleDateFormat DateFormat=new
			 * SimpleDateFormat("MM/dd/yyyy");
			 * date=DateFormat.format(cal.getTime()); }
			 */

			/*
			 * if(!getValue(selenium,"procedureDate").toLowerCase(new
			 * java.util.Locale
			 * ("en","US")).trim().equalsIgnoreCase(date.trim().toLowerCase(new
			 * java.util.Locale("en","US")))){ return false; }
			 * waitForPageLoad(selenium);
			 */
			if (!getValue(selenium, txtProcedureName)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							proData.proName.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				return false;
			}
			/*
			 * if(!getValue(selenium,txtOnset).toLowerCase(new
			 * java.util.Locale("en"
			 * ,"US")).trim().contains(date.trim().toLowerCase(new
			 * java.util.Locale("en","US")))){ return false; }
			 */

			if (proData.testCaseId.equalsIgnoreCase("TC_CP_016")) {
				return true;
			}

			if (!getValue(selenium, txtcpt)
					.toLowerCase(new java.util.Locale("en", "US"))
					.trim()
					.contains(
							proData.cpt.trim().toLowerCase(
									new java.util.Locale("en", "US")))) {
				return false;
			}
			/*
			 * if(!getValue(selenium,txtcomment).toLowerCase(new
			 * java.util.Locale
			 * ("en","US")).trim().contains(proData.comment.trim(
			 * ).toLowerCase(new java.util.Locale("en","US")))){ return false; }
			 */
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * verifyQuickListViewForAssessment
	 * @throws IOException 
	 * 
	 * @since March 20, 2012
	 */
	public boolean verifyQuickListViewForAssessment(Selenium selenium,
			ChartPreVisitLib proData, String account) throws IOException {
		assertTrue(
				type(selenium, ajxAssessmentSearch2, proData.quickList),
				"Could not type the Problem list name",selenium, ClassName, MethodName);
		selenium.fireEvent(ajxAssessmentSearch2, "keydown");
		selenium.fireEvent(ajxAssessmentSearch2, "keypress");
		selenium.fireEvent(ajxAssessmentSearch2, "keyup");
		selenium.keyPress(ajxAssessmentSearch2, "\\13");
		//waitForPageLoad(selenium);
		if (!isElementPresent(selenium, "chartListItemTitle")) {
			return false;
		}

		if (!getText(selenium,
				"chartListItemTitle").contains(
						proData.medicalCondition1)) {
			return false;
		}
		return true;
	}

	/**
	 * createProblemListWithPartialDate function to create Procedure
	 * @throws IOException 
	 * 
	 * @since Sep 28, 2012
	 */

	public boolean createProblemListWithPartialDate(Selenium selenium,
			ChartPreVisitLib proData, String account) throws IOException {
		try {
			waitForPageLoad(selenium);
			if (proData.testCaseId.equals("TC_QL_001"))
				assertTrue(
						type(selenium, txtMedicatl, proData.quickList),
						"Could not type medical condition",selenium, ClassName, MethodName);
			else
				assertTrue(
						type(selenium, txtMedicatl, proData.medicalCondition1),
						"Could not type medical condition",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(
					enterDate(selenium, txtOnset, proData.onsetDate),
					"Could not enter the Admin on ;More Details:"
							+ proData.toString(),selenium, ClassName, MethodName);

			selectValueFromAjaxList(selenium, ajxItem, proData.itemStatus);

			if (isElementPresent(selenium, btnAdd)) {
				assertTrue(click(selenium, btnAdd),
						"Could not click the add button;More details:"
								+ proData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			} else
				assertTrue(click(selenium, btnSummaryEdit),
						"Could not click the add button;More details:"
								+ proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * createAllergyForMedWarnings function to create Allergy
	 * @throws IOException 
	 * 
	 * @since Nov 01, 2012
	 */
	public boolean createAllergyForMedWarnings(Selenium selenium,
			ChartPreVisitLib allergyData, String account) throws IOException {
		try {
			waitForPageLoad(selenium);
			if (allergyData.testCaseId.equals("TC_CA_004")) {
				assertTrue(
						click(selenium,chkInto),
						"Could not Intolernce radio button;More Details",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if (account.equals(CAAccount)) {
				selectValueFromAjaxList(selenium, ajxSearchAllergy,
						allergyData.allergenCa);
				waitForPageLoad(selenium);
			} else {
				selectValueFromAjaxList(selenium, ajxSearchAllergy,
						allergyData.allergen);
			}

			//selectValueFromAjaxList(selenium, ajxReaction, allergyData.reaction);
			
			assertTrue(click(selenium, tabReaction),
					"Could not on show more button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, chkAllergyReaction),
					"Could not on show more button",selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkSelectionClose), 
					"Could not on show more button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
						
			if (!allergyData.testCaseId.equals("TC_CA_001")) {
				if (getText(selenium, lnkAllShowmore).contains(
						"Show more details")) {
					assertTrue(click(selenium, lnkAllShowmore),
							"Could not on show more button",selenium, ClassName, MethodName);
				}

				selectValueFromAjaxList(selenium, ajxSeverity,
						allergyData.severity);

				selectValueFromAjaxList(selenium, ajxStatus, allergyData.status);

				if (account.equals(CAAccount)) {
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat DateFormat = new SimpleDateFormat(
							"dd/MM/yyyy");
					String date = DateFormat.format(cal.getTime());
					assertTrue(enterDate(selenium, txtOnset, date),
							"Could not enter the Admin on ;More Details:"
									+ allergyData.toString(),selenium, ClassName, MethodName);
				} else {
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat DateFormat = new SimpleDateFormat(
							"MM/dd/yyyy");
					String date = DateFormat.format(cal.getTime());
					assertTrue(enterDate(selenium, txtOnset, date),
							"Could not enter the Admin on ;More Details:"
									+ allergyData.toString(),selenium, ClassName, MethodName);
				}
				selectValueFromAjaxList(selenium, ajxlifeStage,
						allergyData.lifeStage);

				assertTrue(
						type(selenium, txtcomment, allergyData.comment),
						"Could not enter the comment;More Details:"
								+ allergyData.toString(),selenium, ClassName, MethodName);
			}

			if (!(allergyData.testCaseId.equalsIgnoreCase("TC_CA_020"))) {
				if (allergyData.testCaseId.equalsIgnoreCase("TC_CA_005")) {
					assertTrue(click(selenium, "btnSummaryCancel"),
							"Could not click the cancel button;More details:"
									+ allergyData.toString(),selenium, ClassName, MethodName);
				} else
					assertTrue(click(selenium, btnAdd),
							"Could not click the add button;More details:"
									+ allergyData.toString(),selenium, ClassName, MethodName);
			} else {
				assertTrue(click(selenium, btnSave),
						"Could not click the save button;More details:"
								+ allergyData.toString(),selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);

			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}



	/**
	 * To verify allergy interaction
	 * 
	 * @param selenium
	 * @param allergyData
	 * @return
	 */

	public boolean verifyAllergyInteraction(Selenium selenium,
			ChartPreVisitLib allergyData) {
		System.out.println(allergyData.allergenCa);
		System.out.println(getText(selenium, lblAllergyInteraction));

		if (!(getText(selenium, lblAllergyInteraction).contains(
				allergyData.allergen) || (getText(selenium,
						lblAllergyInteraction).contains(allergyData.allergenCa)))) {
			return false;
		}
		return true;
	}

	/**
	 * To varify cancel in allergy interaction
	 * 
	 * @param selenium
	 * @param allergyData
	 * @param account
	 * @return
	 * @throws IOException 
	 */
	public boolean verifyCancelInAllergyInteraction(Selenium selenium,
			ChartPreVisitLib allergyData, String account) throws IOException {
		assertTrue(click(selenium, btnCancelAllergyInteraction),
				"Could not click cancel button in the allergy interaction window",selenium, ClassName, MethodName);
		if (account.equalsIgnoreCase(CAAccount)) {
			if (!getValue(selenium, "searchAllergyTextBox").contains(
					allergyData.allergenCa)) {
				return false;
			}
		} else {
			if (!getValue(selenium, ajxSearchAllergy).contains(
					allergyData.allergen)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * To verify stop in allergy interaction
	 * 
	 * @param selenium
	 * @param allergyData
	 * @return
	 * @throws IOException 
	 */
	public boolean verifyStopMedicationInAllergyInteraction(Selenium selenium,
			ChartPreVisitLib allergyData) throws IOException {

		boolean returnValue = true;
		if (!isChecked(selenium, rdoStopMed)) {
			assertTrue(click(selenium, rdoStopMed),
					"Could not click stop medication in the allergy interaction window",selenium, ClassName, MethodName);
		}
		assertTrue(click(selenium, btnSaveAllergyInteraction),
				"Could not click save in the allergy interaction window",selenium, ClassName, MethodName);
		click(selenium, btnSaveAllergyInteraction);
		if (isElementPresent(selenium, lnkAllergyEdit)) {
			returnValue = true;
		} else
			returnValue = false;

		assertTrue(click(selenium, btnCancel),
				"Could not click cancel button",selenium, ClassName, MethodName);
		assertTrue(click(selenium, lnkMore),
				"Could not click on more button",selenium, ClassName, MethodName);
		assertTrue(click(selenium, lnkMedicationTab),
				"Could not click medications tab",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);

		if (!selenium.isTextPresent("Stopped")) {
			returnValue = false;
		}
		return returnValue;
	}

	/**
	 * To verify override in allergy interaction
	 * 
	 * @param selenium
	 * @param allergyData
	 * @return
	 * @throws IOException 
	 */
	public boolean verifyOverrideInAllergyInteraction(Selenium selenium,
			ChartPreVisitLib allergyData) throws IOException {

		boolean returnValue = true;
		if (!isChecked(selenium, rdoOverrideMed)) {
			assertTrue(click(selenium, rdoOverrideMed),
					"Could not click stop medication in the allergy interaction window",selenium, ClassName, MethodName);
		}

		if (allergyData.testCaseId.equals("TC_PM_052")) {
			assertTrue(type(selenium, txtReasonToOverride, "Reason"),
					"Could not click save in the allergy interaction window",selenium, ClassName, MethodName);
		} else {
			assertTrue(type(selenium, txtReasonToOverride, ""),
					"Could not click save in the allergy interaction window",selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnSaveAllergyInteraction),
					"Could not click save in the allergy interaction window",selenium, ClassName, MethodName);
			if (getText(selenium, "\\p").contains("Reason cannot be empty.")) {
				return returnValue;
			} else
				Assert.fail("Validation message failed to appear on the screen");
		}

		assertTrue(click(selenium, btnSaveAllergyInteraction),
				"Could not click save in the allergy interaction window",selenium, ClassName, MethodName);

		if (isElementPresent(selenium, lnkAllergyEdit)) {
			returnValue = true;
		} else
			returnValue = false;

		return returnValue;
	}

	/**
	 * To verify quick list feature in allergy interaction
	 * 
	 * @param selenium
	 * @param allergyData
	 * @return
	 * @throws IOException 
	 */
	public boolean verifyQuicklistInAllergyInteraction(Selenium selenium,
			ChartPreVisitLib allergyData, String account) throws IOException {

		boolean returnValue = true;

		if (!isChecked(selenium, rdoOverrideMed)) {
			assertTrue(click(selenium, rdoOverrideMed),
					"Could not click stop medication in the allergy interaction window",selenium, ClassName, MethodName);
		}

		assertTrue(type(selenium, "//td/div/div/div/input", "Reason"),
				"Could not click save in the allergy interaction window",selenium, ClassName, MethodName);

		if (!isChecked(selenium, "xpath=(//input[@id='saveListcheckbox'])[2]")) {
			assertTrue(
					click(selenium,
							"xpath=(//input[@id='saveListcheckbox'])[2]"),
					"Could not click save to quick list in the allergy interaction window",selenium, ClassName, MethodName);
		}

		assertTrue(click(selenium, btnSaveAllergyInteraction),
				"Could not click save in the allergy interaction window",selenium, ClassName, MethodName);

		if (isElementPresent(selenium, lnkAllergyEdit)) {
			returnValue = true;
		} else
			returnValue = false;

		assertTrue(deleteAllAllergy(selenium, allergyData),
				"Deletion Failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(createAllergy(selenium, allergyData, account),
				"Creation failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		if (!isChecked(selenium, rdoOverrideMed)) {
			assertTrue(click(selenium, rdoOverrideMed),
					"Could not click stop medication in the allergy interaction window",selenium, ClassName, MethodName);
		}

		assertTrue(type(selenium, "//td/div/div/div/input", "Reason"),
				"Could not click save in the allergy interaction window",selenium, ClassName, MethodName);

		assertTrue(click(selenium, btnQuickListForInteractionWarning1),
				"Could not click quick list button in the allergy interaction window",selenium, ClassName, MethodName);
		assertTrue(click(selenium, ajxQuikListOption),
				"Could not click quick list option in the allergy interaction window",selenium, ClassName, MethodName);

		assertTrue(click(selenium, btnSaveAllergyInteraction),
				"Could not click save in the allergy interaction window",selenium, ClassName, MethodName);

		if (isElementPresent(selenium, lnkAllergyEdit)) {
			returnValue = true;
		} else
			returnValue = false;

		return returnValue;
	}

	/**
	 * verifyOrderForQuickListViewForInjection function to
	 * verifyQuickListViewForInjection
	 * @throws IOException 
	 * 
	 * @since Sep 28, 2012
	 */

	public boolean verifyOrderForQuickListViewForInjection(Selenium selenium,
			ChartPreVisitLib QuicklstData, String account) throws IOException {

		try {
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnInjection),
					"Could not click the QuickList button;More details:"
							+ QuicklstData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if (!getValue(selenium, lnlPopQuickList).trim().contains(
					QuicklstData.injection1.trim())) {
				return false;
			}
			if (!getValue(selenium, "//div[4]/div/div/div/div/div[2]/div/span")
					.trim().contains(QuicklstData.injection.trim())) {
				return false;
			}

			return true;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * To verify override in allergy interaction
	 * 
	 * @param selenium
	 * @param allergyData
	 * @return
	 * @throws IOException 
	 */
	public boolean verifyOverrideInAllergyInteraction(Selenium selenium,
			ChartPreVisitLib allergyData, ChartPreVisitLib prescribeData) throws IOException {

		boolean returnValue = true;
		if (!isChecked(selenium, rdoOverrideMed)) {
			assertTrue(click(selenium, rdoOverrideMed),
					"Could not click stop medication in the allergy interaction window",selenium, ClassName, MethodName);
		}

		if (prescribeData.testCaseId.equalsIgnoreCase("TC_PM_052")) {
			assertTrue(type(selenium, txtReasonToOverrideAllergy, "Reason"),
					"Could not Type reason in the allergy interaction window",selenium, ClassName, MethodName);
		}
		if (prescribeData.testCaseId.equalsIgnoreCase("TC_PM_059")) {
			{
				assertTrue(type(selenium, txtReasonToOverrideAllergy, ""),
						"Could not Type Reason in the allergy interaction window",selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnSaveAllergyInteraction),
						"Could not click save in the allergy interaction window",selenium, ClassName, MethodName);
				if (getText(selenium, "\\p")
						.contains("Reason cannot be empty.")) {
					return returnValue;
				} else
					Assert.fail("Validation message failed to appear on the screen");
			}

		}
		assertTrue(click(selenium, btnSaveAllergyInteraction),
				"Could not click save in the allergy interaction window",selenium, ClassName, MethodName);

		if (isElementPresent(selenium, lnkAllergyEdit)) {
			returnValue = true;
		} else
			returnValue = false;

		return returnValue;
	}

	/**
	 * createExternalProvider function to create an External Provider
	 * @throws IOException 
	 * 
	 * @since May 17, 2012
	 */
	public boolean createExternalProvider(Selenium selenium,
			SystemSettingsLib providerData, String uniqueNo) throws IOException {

		try {

			assertTrue(
					type(selenium, txtReferringCode, providerData.referringCode
							+ uniqueNo),
							"Could not type referring code; More Details"
									+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtLastName, providerData.lastName),
					"Could not type last name; More Details"
							+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtFirstName, providerData.firstName),
					"Could not type first name; More Details"
							+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtMiddleInitials,
							providerData.middleInitial),
							"Could not type middle initial; More Details"
									+ providerData.toString(),selenium, ClassName, MethodName);

			assertTrue(
					click(selenium, btnsaveProvider),
					"Could not click save button; More details"
							+ providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			if (isElementPresent(selenium, btnDeleteExternalProvider)) {
				return true;
			} else {
				return false;
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * deleteAllExternalProvider function to deleteAllExternalProvider
	 * @throws IOException 
	 * 
	 * @since APR 09, 2012
	 */
	public boolean deleteAllExternalProvider(Selenium selenium) throws IOException {
		waitForPageLoad(selenium);
		boolean providerDeleted = true;
		int caseCount = 0;
		try {

			waitForElement(selenium, lnkexternalProviderDel, WAIT_TIME);
			while ((Integer) selenium.getXpathCount(lnkexternalProviderDel) > 0) {
				waitForPageLoad(selenium);
				caseCount = (Integer) selenium
						.getXpathCount(lnkexternalProviderDel);
				assertTrue(click(selenium, lnkexternalProviderDel),"Could not click on external Provider Delete",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnYes),"Could not click on yes button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				// if(caseCount == (Integer)
				// selenium.getXpathCount("//div[@id='AdminReferringProviderList']/table/tbody/tr/td[2]/div/a")){
				if (caseCount == (Integer) selenium
						.getXpathCount(lnkexternalProviderDel1)) {
					providerDeleted = false;
					break;
				}
			}
			return providerDeleted;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * unitTestForReference function tounitTestForReference
	 * @throws IOException 
	 * 
	 * @since July 02, 2012
	 */
	public boolean unitTestForReference(Selenium selenium,
			ChartPreVisitLibUnitTest referData) throws IOException {
		try {

			assertTrue(
					type(selenium, txtReference, referData.reference),
					"Could not type the Referenc details",selenium, ClassName, MethodName);
			if (referData.testCaseId.equals("TC_ER_001")
					|| referData.testCaseId.equals("TC_ER_002")
					|| referData.testCaseId.equals("TC_ER_003")) {
				assertTrue(click(selenium, lnkGo),
						"Could not click the Go link",selenium, ClassName, MethodName);
			} else {
				assertTrue(click(selenium, lnkBookMark),
						"Could not click the Book Mark",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtBookDetails, referData.bookMark),
						"Could not type the Book mark details",selenium, ClassName, MethodName);
				assertTrue(
						type(selenium, txtBookUrl, referData.reference),
						"could not enter the details",selenium, ClassName, MethodName);
				assertTrue(click(selenium, lnkSaveComments),
						"Could not click the save button",selenium, ClassName, MethodName);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * createEncounterReference function to create Encounter Reference
	 * @throws IOException 
	 * 
	 * @since July 04, 2012
	 */
	public boolean createEncounterReference(Selenium selenium,
			ChartPreVisitLib referData) throws IOException {
		try {
			
		
				assertTrue(click(selenium, "class=add-button"),"Could not click add refrence button",selenium, ClassName, MethodName);
				   
			       assertTrue(type(selenium, "referenceName", referData.reference),
					"Could not type the Referenc details",selenium, ClassName, MethodName);
		
			/*
			 * if(referData.testCaseId.equals("TC_ER_001")){
			 * assertTrue(click
			 * (selenium,lnkGo),"Could not click the Go link"); }
			 */
			assertTrue(click(selenium, lnkBookMark),
					"Could not click the Book Mark",selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtBookDetails, referData.bookMark),
					"Could not type the Book mark details",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtBookUrl, referData.reference),
					"could not enter the details",selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnSaveProcedure1),
					"Could not click the save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * deleteEncounterReference function to delete Encounter Reference
	 * @throws IOException 
	 * 
	 * @since July 04, 2012
	 */
	public boolean deleteEncounterReference(Selenium selenium,
			ChartPreVisitLib referData) throws IOException {
		waitForPageLoad(selenium);
		boolean providerDeleted = true;
		int count = 1;
		try {
			while (getText(selenium,
					"//div[6]/table/tbody/tr[2]/td[2]/div/div/div[2]/div/div[3]")
					.toLowerCase(new java.util.Locale("en", "US")).contains(
							referData.bookMark.toLowerCase(
									new java.util.Locale("en", "US")).trim())) {
				if (getText(
						selenium,
						"//div[@id='userReferenceListView']/table/tbody/tr["
								+ count + "]/td")
								.toLowerCase(new java.util.Locale("en", "US"))
								.trim()
								.contains(
										referData.bookMark.toLowerCase(
												new java.util.Locale("en", "US"))
												.trim())) {
					assertTrue(click(selenium,
							"//div[@id='userReferenceListView']/table/tbody/tr["
									+ count + "]/td[3]/div/a"),"Could not click on the link",selenium, ClassName, MethodName);
					assertTrue(click(selenium, "link=Yes"),"Could not click on Yes Button",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				} else
					count++;

				if (count > 50) {
					break;
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
		return providerDeleted;
	}

	/**
	 * deleteEncounterReference function to delete Encounter Reference
	 * @throws IOException 
	 * 
	 * @since July 18, 2012
	 */
	public boolean deleteEncounterReferenceQA(Selenium selenium,
			ChartPreVisitLib referData) throws IOException {
		waitForPageLoad(selenium);
		boolean providerDeleted = true;
		int count = 1;
		try {
			while (getText(selenium, "//div[4]/div/div/div[2]/div/div[3]")
					.toLowerCase(new java.util.Locale("en", "US")).contains(
							referData.bookMark.toLowerCase(
									new java.util.Locale("en", "US")).trim())) {
				String s = getText(selenium, "//tr[" + count
						+ "]/td/div/div/span");
				if (getText(selenium, "//tr[" + count + "]/td/div/div/span")
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								referData.bookMark.toLowerCase(
										new java.util.Locale("en", "US"))
										.trim())) {
					assertTrue(click(selenium,
							"//div[@id='userReferenceListView']/table/tbody/tr["
									+ count + "]/td[3]/div/a"),"Could not click on the link",selenium, ClassName, MethodName);
					assertTrue(click(selenium, "link=Yes"),"Could not click on yes Link",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				} else
					count++;

				if (count > 50) {
					break;
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
		return providerDeleted;
	}

	/**
	 * goToReference function to Reference
	 * @throws IOException 
	 * 
	 * @since Jun 18, 2013
	 */

	public boolean goToReference(Selenium selenium) throws IOException {
		assertTrue(click(selenium, lnkQuickAction),
				"Could not click the link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium, lnkReferences),
				"Could not find the References link",selenium, ClassName, MethodName);
		assertTrue(click(selenium, lnkReferences),
				"Could not click References link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}

	/**
	 * navigateToMySetting function to navigateToMySetting
	 * 
	 * @throws IOException
	 * @since Aug 22, 2013
	 */

	public boolean navigateToPatientSummary(Selenium selenium)
			throws IOException {
		if(isElementPresent(selenium,btnErrorClose))
		{
			click(selenium,btnErrorClose);
		}
		assertTrue(click(selenium, lnkTopMenu), "Could not click the top menu",
				selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkMySetting),
				"Could not click the top menu", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		selenium.isVisible(lnkPatientSummary);
		assertTrue(click(selenium, lnkPatientSummary),
				"Could not click the top menu", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if (selenium.isTextPresent("Medical Summary")) {
			return true;
		} else
			return false;
	}

	/**
	 * uncheckOptionalElement function to unCheckOptionalElement
	 * 
	 * @throws IOException
	 * @since Aug 23, 2013
	 */
	int sectionCount;
	int count = 1;


	public boolean uncheckOptionalElement(Selenium selenium, String sectionItem)
			throws IOException {
		assertTrue(click(selenium, btnCSEdit),
				"Could not click the save button", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);
		assertTrue(
				click(selenium, sectionItem),
				"Could not click the link", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);
		return true;
	}




	public boolean checkOptionalElement(Selenium selenium, String sectionItem,
			String optionalElement) throws IOException {
		assertTrue(click(selenium, btnCSEdit),
				"Could not click the save button", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);

		sectionCount = (Integer) selenium.getXpathCount("//tr/td/div/div/div/div[2]");
		for (count = 1; count <= sectionCount; count++) {
			String sectionName = getText(selenium, "//tr[" + count + "]/td/div/div/div/div[2]").trim();
		if (sectionItem.equals(sectionName)) {
				assertTrue(click(selenium, "//tr[" + count	+ "]/td/div/div/div/div[4]/a"),
						"Could not click the link", selenium, ClassName,
						MethodName);
				if (!isChecked(selenium, optionalElement)) {
					assertTrue(click(selenium, optionalElement),
							"Could not click the Edit button", selenium,
							ClassName, MethodName);
					break;
				}
			}
		}

		return true;
	}


	/**
	 * verifyCollapseViewAndExpendForOptionalDetails function to Verify
	 * CollapseView And ExpendView For Optional Details
	 * 
	 * @throws IOException
	 * @since Aug 26, 2013verifyCollapseViewAndExpendViewForOptionalDetails
	 */
	public boolean verifyCollapseViewAndExpendViewForOptionalDetails(
			Selenium selenium, String sectionName, String uncheckElementName)
					throws IOException {

		int sectionCount = (Integer) selenium.getXpathCount("//div[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div/div[3]/div/div/div/div/div[2]/div/div[2]/div/div/div[3]/div");
		for (int count = 1; count <= sectionCount - 3; count++) {
			String section = selenium.getText("//div[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div/div[3]/div/div/div/div/div[2]/div/div[2]/div/div/div[3]/div["+count+"]");

			if (section.contains(sectionName)) {
				if (section.contains(uncheckElementName.trim())) {
					return false;
				}
				int countArrow;
				if(count>1){
					countArrow = count - 1;
				}else
					countArrow = count;
				assertTrue(
						click(selenium,
								"xpath=(//div[@id='displayRow']/div[3]/a)["+countArrow+"]"),
								"Could not click the arrow", selenium, ClassName,
								MethodName);
				String optionalElement = selenium
						.getText("//div[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div/div[3]/div/div/div/div/div[2]/div/div[2]/div/div/div[3]/div["+count+"]");
				System.out.println(optionalElement);
				System.out.println(uncheckElementName);
				if (!optionalElement.trim().contains(uncheckElementName.trim())) {
					return false;
				}
				break;
			}
		}
		return true;
	}

	/**
	 * verifyOptionalDetailsForChartSummaryPage function to Verify Optional
	 * Details For Chart Summary Page
	 * 
	 * @throws IOException
	 * @since Aug 27, 2013
	 */
	String date = null;
	String time = null;

	public boolean verifyOptionalDetailsForChartSummaryPage(Selenium selenium,
			String sectionName, String uncheckElementName, String account)
					throws IOException {

		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		if (account.equals(CAAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MMM d, yyyy");
			date = DateFormat.format(cal.getTime());
			// SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			// date = DateFormat.format(cal.getTime());
			DateFormat = new SimpleDateFormat("HH");
			time = DateFormat.format(cal.getTime());
		} else {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat.format(cal.getTime());
			DateFormat = new SimpleDateFormat("HH");
			time = DateFormat.format(cal.getTime());
		}

		int sectionCount = (Integer) selenium
				.getXpathCount("//div[@id='printInfo']/div/div[3]/div/div[3]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div");
		for (int count = 1; count <= sectionCount; count++) {
			String section = selenium
					.getText("//div[@id='printInfo']/div/div[3]/div/div[3]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div["
							+ count + "]");
			if (isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"Could not click on Error Close Button",selenium, ClassName, MethodName);

			if (section.contains(sectionName)) {
				if (section.trim().contains(uncheckElementName.trim())) {
					return false;
				}
				int countArrow;
				if(count>1){
					countArrow = count - 1;
				}else
					countArrow = count;

				assertTrue(
						click(selenium,
								"xpath=(//div[@id='displayRow']/div[3]/a)["
										+ countArrow + "]"),
										"Could not click the arrow", selenium, ClassName,
										MethodName);
				waitForPageLoad(selenium);

				String optionalElement = selenium
						.getText("//div[@id='printInfo']/div/div[3]/div/div[3]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div["
								+ count + "]");

				if (!optionalElement.contains(uncheckElementName)) {
					return false;
				}
				assertTrue(
						verifyTimeStampForProviderPage(
								selenium,
								"//div[@id='printInfo']/div/div[3]/div/div[3]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div["
										+ count + "]", date, time),
										"Time stamp is not displayed", selenium, ClassName,
										MethodName);
				waitForPageLoad(selenium);
				break;
			}

		}
		return true;
	}


	/**
	 * Verify the User Name function to Verify the User Name
	 * @throws IOException 
	 * 
	 * @since Aug 23, 2013
	 */
	public String verifyUserNameChart(Selenium selenium,
			ChartPreVisitLib userData) throws IOException {
		String ProviderName = null;
		String Provider_Name1 = null;

		try {
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, txtUserSearchBox1,
					userData.userName);
			assertTrue(click(selenium, txtUserName1),
					"Could not click on user Name",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnEdit),
					"Could not click on edit button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if (isChecked(selenium, "//span/input")) {
				ProviderName = getValue(selenium, show);
				String Pro_Name[] = ProviderName.split(",");
				Provider_Name1 = Pro_Name[1].trim() + " " + Pro_Name[0];
			} else {
				String Pro_FirstName = getValue(selenium, txtFirstName);
				String Pro_LastName = getValue(selenium, txtLastName);
				Provider_Name1 = Pro_FirstName + " " + Pro_LastName;
			}

			System.out.println("Provider_Name-" + Provider_Name1);

			String Pro_Name_Menu = getText(selenium, lnkTopMenu);
			String Pro_Name[] = Pro_Name_Menu.split(" ");
			Pro_Name[1] = Pro_Name[1].replace(",", " ");

			Pro_Name_Menu = Pro_Name[0] + " " + Pro_Name[1];

			System.out.println("Pro_Name_Menu-" + Pro_Name_Menu);

			if (!Provider_Name1.trim().equalsIgnoreCase(Pro_Name_Menu.trim())) {
				Assert.fail("Verify User Name failed");
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return Provider_Name1;

	}


	/**
	 * createNewPatientForCqm function to create New Patient With Mandatory
	 * @throws IOException 
	 * 
	 * @since Jan 07, 2013
	 */
	public boolean createNewPatientForBPM(Selenium selenium, HomeLib patientData) throws IOException {
		boolean returnValue = false;
		try {
			waitForPageLoad(selenium);
			assertTrue(
					type(selenium, txtLastName, patientData.lastName),
					"Could not type the last name : More Details"
							+ patientData.toString(),selenium, ClassName, MethodName);
			assertTrue(
					type(selenium, txtFirstName, patientData.firstName),
					"Could not type the first Name : More Details"
							+ patientData.toString(),selenium, ClassName, MethodName);

			selectValueFromAjaxList(selenium, ajxStuasSuggest,
					patientData.status);
			if(selenium.isElementPresent(btnBack1))
			{
				assertTrue(click(selenium, btnBack1),
						"Could click back button, Expected value to be typed"
								+ patientData.dob,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}

			assertTrue(enterDate(selenium, txtDob1, "01/01/1990"),
					"Could not Enter dob, Expected value to be typed"
							+ patientData.dob,selenium, ClassName, MethodName);
			if(selenium.isElementPresent(btnBack1))
			{
				assertTrue(click(selenium, btnBack1),
						"Could click back button, Expected value to be typed"
								+ patientData.dob,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}

			click(selenium, btnClinicalBack);
			waitForPageLoad(selenium);
			assertTrue(
					click(selenium, btnClinicalSave),
					"Could not click Save button More Dateils"
							+ patientData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;
			waitForPageLoad(selenium);
		} catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"
					+ e.getMessage()
					+ "\n\t*); Detailed data:"
					+ patientData.toString());
		}
		return returnValue;
	}

	/**
	 * deleteAllMandatory function to delete All Mandatory
	 * @throws IOException 
	 * 
	 * @since APR 09, 2012
	 */
	public boolean deleteAllMandatory(Selenium selenium) throws IOException {
		boolean mandatoryDeleted = true;
		int caseCount = 0;
		try {
			waitForElement(selenium, lnkDeleteMandatoryUserFields, WAIT_TIME);
			while ((Integer) selenium
					.getXpathCount(lnkDeleteMandatoryUserFields) > 0) {
				caseCount = (Integer) selenium
						.getXpathCount(lnkDeleteMandatoryUserFields);
				assertTrue(click(selenium, lnkDeleteMandatoryUserFields),"Could not click on Delete Mandatory UserField",selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnYesButton),"Could not click on Yes Button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if (caseCount == (Integer) selenium
						.getXpathCount(lnkDeleteMandatoryUserFields)) {
					mandatoryDeleted = false;
					break;
				}
			}
			return mandatoryDeleted;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}

	//*********************************************//
	//
	//
	//Select View Chart
	//
	//
	//********************************************//

	public boolean navigateToPatient(Selenium selenium,String  patientID) throws IOException{

		assertTrue(type(selenium, txtPatientBox, patientID),"Could not type patient id", selenium, ClassName,MethodName);
		selenium.clickAt("searchPatientBox","");
		selenium.focus("searchPatientBox");			
		selenium.fireEvent("searchPatientBox","keypress");		
		waitForElement(selenium, lblPatientResult, 10000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+ patientID, selenium, ClassName,MethodName);
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
	 * navigateTolabListView function to navigateTolabListView
	 * 
	 * @since Mar 04, 2014
	 */
	public boolean navigateTolabListView(Selenium selenium,
			ChartPreVisitLib labData) {
		try {
			
			selenium.focus(lnkLabReport);
			selenium.clickAt(lnkLabReport,"" );
			assertTrue(click(selenium, lnkLabReport),
					"Could not click lab tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkLabListView),
					"Could not click list view", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;

	}

	public boolean verifyStoredValueInManagementView(Selenium selenium,ChartPreVisitLib vitalsData,String currentDate,String currentTime,String account){

		String lblSummaryArea="//div[@class='full-vitals-wrapper']";

		String date = null;  
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			date=DateFormat.format(cal.getTime());

		}else{
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
			date=DateForma1t.format(cal1.getTime());

		}
		if(!getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.heightInFeet.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.heightInFeet.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.weight.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.weightMU.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		for(int i=4;i<15;i++){
			if(selenium.isElementPresent("//tr["+i+"]/td[2]/div/span/div[2]")){
				if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(vitalsData.systolicRate.trim())){
					return false;
				}
				if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(vitalsData.diastolicRate.trim())){
					return false;
				}

				if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(vitalsData.position.trim())){
					return false;
				}

				if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(vitalsData.limb.trim())){
					return false;
				}
				if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(vitalsData.cuffSize.trim())){
					return false;
				}
				String time = getValue(selenium, "xpath=(//input[@type='text'])[26]");
				if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(time)){
					return false;
				}

				if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(date)){
					return false;
				}
				break;
			}

		}

		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.bPM.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.description.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.rhythm.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.temperature.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.bloodSuger.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.bSUnit.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.repositoryRate.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.rR_BPM.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.oxygenSaturation.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.pEFR.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.pre_bronchodilator.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(date)){
			return false;
		}
		return true;
	}

	public boolean verifyStoredValueInManagementView(Selenium selenium,ChartPreVisitLib vitalsData,String currentTime,String account){

		String lblSummaryArea="//div[@class='full-vitals-wrapper']";

		String date = null;  
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			date=DateFormat.format(cal.getTime());

		}else{
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
			date=DateForma1t.format(cal1.getTime());

		}
		if(!getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.heightInFeet.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.heightInFeet.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.weight.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.weightMU.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		for(int i=4;i<15;i++){
			if(selenium.isElementPresent("//tr["+i+"]/td[2]/div/span/div[2]")){
				if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(vitalsData.systolicRate.trim())){
					return false;
				}
				if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(vitalsData.diastolicRate.trim())){
					return false;
				}

				if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(vitalsData.position.trim())){
					return false;
				}

				if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(vitalsData.limb.trim())){
					return false;
				}
				if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(vitalsData.cuffSize.trim())){
					return false;
				}
				String time = getValue(selenium, "xpath=(//input[@type='text'])[26]");
				if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(time)){
					return false;
				}

				if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(date)){
					return false;
				}
				break;
			}

		}

		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.bPM.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.description.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.rhythm.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.temperature.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.bloodSuger.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.bSUnit.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.repositoryRate.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.rR_BPM.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.oxygenSaturation.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.pEFR.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(date)){
			return false;
		}
		return true;
	}

	public boolean verifyStoredValueInManagementView(Selenium selenium,ChartPreVisitLib vitalsData, String account){

		String lblSummaryArea="//div[@class='full-vitals-wrapper']";

		String date = null;  
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			date=DateFormat.format(cal.getTime());

		}else{
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
			date=DateForma1t.format(cal1.getTime());

		}
		try{
			if(!getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.heightInFeet.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.heightInFeet.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.weight.trim())){
				return false;
			}
			if(!getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.weightMU.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			for(int i=4;i<15;i++){
				if(selenium.isElementPresent("//tr["+i+"]/td[2]/div/span/div[2]")){
					if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(vitalsData.systolicRate.trim())){
						return false;
					}
					if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(vitalsData.diastolicRate.trim())){
						return false;
					}

					if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(vitalsData.position.trim())){
						return false;
					}

					if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(vitalsData.limb.trim())){
						return false;
					}
					if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(vitalsData.cuffSize.trim())){
						return false;
					}
					String time = getValue(selenium, "xpath=(//input[@type='text'])[26]");
					if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(time)){
						return false;
					}

					if(!getText(selenium,"//tr["+i+"]/td[2]/div/span/div[2]").trim().contains(date)){
						return false;
					}
					break;
				}

			}

			if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.bPM.trim())){
				return false;
			}
			if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.description.trim())){
				return false;
			}
			if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.rhythm.trim())){
				return false;
			}
			if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.temperature.trim())){
				return false;
			}
			if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.repositoryRate.trim())){
				return false;
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return true;
	}

	public boolean verifyStoredValueInUpdateVitals(Selenium selenium,ChartPreVisitLib vitalsData){
		if(!getValue(selenium,"heightFeet1").toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.heightInFeet.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,ajxHeight).toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.heightMU.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtWeight).trim().contains(vitalsData.weight.trim())){
			return false;
		}
		if(!getValue(selenium,ajxWeight).toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.weightMU.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtwaist1).trim().contains(vitalsData.waist.trim())){
			return false;
		}
		if(!getValue(selenium,ajxWaist).trim().contains(vitalsData.waistMU.trim())){
			return false;
		}
		if(!getValue(selenium,txtSystolic).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.systolicRate.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getValue(selenium,txtdiastolic).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.diastolicRate.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getValue(selenium,ajxPosition).trim().contains(vitalsData.position.trim())){
			return false;
		}
		if(!getValue(selenium,ajxLimb).trim().contains(vitalsData.limb.trim())){
			return false;
		}
		if(!getValue(selenium,ajxCuffsize).trim().contains(vitalsData.cuffSize.trim())){
			return false;
		}
		String time = getValue(selenium,txtPefrTime);
		if(!getValue(selenium,txtPefrTime).trim().contains(time)){
			return false;
		}
		if(!getValue(selenium,ajxdescription).trim().contains(vitalsData.description.trim())){
			return false;
		}
		if(!getValue(selenium,ajxrhythm).trim().contains(vitalsData.rhythm.trim())){
			return false;
		}
		if(!getValue(selenium,txtTemp).trim().contains(vitalsData.temperature.trim())){
			return false;
		}
		if(!getValue(selenium,ajxTempUnit).trim().contains(vitalsData.tempRU.trim())){
			return false;
		}
		if(!getValue(selenium,txtBloodSugar1).trim().contains(vitalsData.bloodSuger.trim())){
			return false;
		}
		if(!getValue(selenium,ajxBloodSugar).trim().contains(vitalsData.bSUnit.trim())){
			return false;
		}
		if(!getValue(selenium,txtRespiratory).trim().contains(vitalsData.repositoryRate.trim())){
			return false;
		}
		if(!getValue(selenium,ajxRespiratory).trim().contains(vitalsData.rR_BPM.trim())){
			return false;
		}
		if(!getValue(selenium,txtOxygen1).trim().contains(vitalsData.oxygenSaturation.trim())){
			return false;
		}
		if(!getValue(selenium,txtPefr1).trim().contains(vitalsData.pEFR.trim())){
			return false;
		}
		if(!getValue(selenium,ajxPefr).trim().contains(vitalsData.pre_bronchodilator.trim())){
			return false;
		}
		String time1 = getValue(selenium, txtPefrTime);
		if(!getValue(selenium,txtPefrTime).trim().contains(time1)){
			return false;
		}
		return true;
	}
	public boolean verifyStoredValueForMedicalSummary(Selenium selenium,ChartPreVisitLib vitalsData,String account){
		String lblVitalsInSummary = "vitalBoxWrapper"; 
		waitForPageLoad(selenium);
		String date = null;  
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
			date=DateFormat.format(cal.getTime());
			int date1=Integer.parseInt(date);
			if(date1<10){
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
				date=DateForma1t.format(cal.getTime());
			}else{
				SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd,yyyy");
				date=DateFormat2.format(cal.getTime());
			}
		}else{
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
			date=DateForma1t.format(cal1.getTime());		
		}

		waitForPageLoad(selenium);
		if(!getText(selenium,lblVitalsInSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.heightInFeet.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.weight.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.weightMU.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.waist.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.waistMU.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.systolicRate.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.diastolicRate.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.position.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.bPM.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.rhythm.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.temperature.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.bloodSuger.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.bSUnit.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.repositoryRate.trim())){
			return false;
		}
		waitForPageLoad(selenium);
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.oxygenSaturation.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.pEFR.trim())){
			return false;
		}

		return true;
	}

	public boolean verifyStoredValueInManagementViewForChild(Selenium selenium,ChartPreVisitLib vitalsData,String currentDate,String currentTime) throws IOException{
		String lblSummaryArea="//div[@class='full-vitals-wrapper']";

		if(!getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.htResult)){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.wtResult)){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.waist.trim()+" in")){
			return false;
		}
		assertTrue(getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.systolicRate+"/"+vitalsData.diastolicRate+" "+vitalsData.position+" on "+vitalsData.limb+" using "+vitalsData.cuffSize+" "+currentDate+" at "),"Could not find", selenium, ClassName, MethodName);
			
		
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.bPM.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.description+"  "+vitalsData.rhythm)){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.temperature.trim()+".00 fahrenheit via "/*+vitalsData.loaction*/)){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.bloodSuger.trim()+" "+vitalsData.bSUnit)){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.repositoryRate.trim()+" bpm with "+vitalsData.rR_BPM)){
			return false;
		}

		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.oxygenSaturation.trim())){
			return false;
		}
		if(!getText(selenium,lblSummaryArea).trim().contains(vitalsData.pEFR.trim())){
			return false;
		}

		if(!getText(selenium,lblSummaryArea).trim().contains(currentDate)){
			return false;
		}
		return true;
	}
	public boolean verifyStoredValueForMedicalSummaryForChild(Selenium selenium,ChartPreVisitLib vitalsData,String account){
		String lblVitalsInSummary = "vitalBoxWrapper"; 
		@SuppressWarnings("unused")
		String date = null;  
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd,yyyy");
			date=DateFormat.format(cal.getTime());

		}else{
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
			date=DateForma1t.format(cal1.getTime());		
		}
		waitForPageLoad(selenium);
		if(!getText(selenium,lblVitalsInSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.heightInFeet.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.weight.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.weightMU.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.waist.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.waistMU.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.systolicRate.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.diastolicRate.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.position.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.bPM.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.rhythm.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.temperature.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.bloodSuger.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.bSUnit.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.repositoryRate.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.oxygenSaturation.trim())){
			return false;
		}
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.pEFR.trim())){
			return false;
		}
	
		if(!getText(selenium,lblVitalsInSummary).trim().contains(vitalsData.fatherStature.trim())){
			return false;
		}

		return true;
	}

	/**
	 * createChartDisclosure function to create Chart Disclosure
	 * @throws IOException 
	 * 
	 * @since April 29, 2014
	 */
	public boolean createMandatoryChartDisclosureFromPC(Selenium selenium,
			ChartPreVisitLib chartDisclosureData, String account) throws IOException {
		try {
			waitForPageLoad(selenium);
			assertTrue(
					type(selenium, txtChartDLSInst,
							chartDisclosureData.Instruction),
							"Could not type Instruction", selenium, ClassName,
							MethodName);
			assertTrue(
					selectValueFromAjaxList(selenium, ajxChartReqBy,
							chartDisclosureData.Requestedby),
							"Could not select Requested By", selenium,
							ClassName, MethodName);
			assertTrue(
					selectValueFromAjaxList(selenium, ajxChartRepType,
							chartDisclosureData.Recipienttype),
							"Could not select Recipient type", selenium,
							ClassName, MethodName);
			assertTrue(
					selectValueFromAjaxList(selenium, ajxChartDeliverryMethod,
							chartDisclosureData.Deliverymethod),
							"Could not select  Delivery method", selenium,
							ClassName, MethodName);
			selenium.typeKeys(ajxChartConsentName, "\b");
			selenium.type(ajxChartConsentName, "");
			waitForPageLoad(selenium);
			selenium.focus(ajxChartConsentName);
			waitForPageLoad(selenium);
			click(selenium,"currentItem_1");
//			assertTrue(
//					selectValueFromAjaxList(selenium, ajxChartConsentName,
//							chartDisclosureData.Consentname),
//							"Could not select Consent name", selenium,
//							ClassName, MethodName);
			if(chartDisclosureData.testCaseId.equals("TC_CD_002")){
				assertTrue(selectValueFromAjaxList(selenium, ajxDueInCount,chartDisclosureData.DueInCount),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium, ajxDueInUnit,chartDisclosureData.DueInUnit),"Could not select Requested By", selenium,ClassName, MethodName);
			} 
			if(chartDisclosureData.testCaseId.equals("TC_CD_003")||chartDisclosureData.testCaseId.equals("TC_CD_004")||chartDisclosureData.testCaseId.equals("TC_CD_005")||chartDisclosureData.testCaseId.equals("TC_CD_006")||chartDisclosureData.testCaseId.equals("TC_CD_007")){
				assertTrue(type(selenium, txtRequesterName,chartDisclosureData.RecipientName),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, txtRequesterRel,chartDisclosureData.RecipientRel),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, txtContactPhone,chartDisclosureData.ContactPhone),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, txtExtn,chartDisclosureData.Extn),"Could not select Requested By", selenium,ClassName, MethodName);
			} 
			if(chartDisclosureData.testCaseId.equals("TC_CD_004")){
				assertTrue(click(selenium, radOtherMail),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, txtAdd1,chartDisclosureData.Add1),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, txtAdd2,chartDisclosureData.Add2),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, txtCity,chartDisclosureData.City),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, lstState,chartDisclosureData.State),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, txtZip,chartDisclosureData.Zip),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, lstCountry,chartDisclosureData.Country),"Could not select Requested By", selenium,ClassName, MethodName);				 
			} 
			if(chartDisclosureData.testCaseId.equals("TC_CD_005")){
				assertTrue(type(selenium, txtRecipientName,chartDisclosureData.RecipientName),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, txtRecipientRel,chartDisclosureData.RecipientRel),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, txtRepConPhn,chartDisclosureData.ContactPhone),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, txtRepExtn,chartDisclosureData.Extn),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(click(selenium, radOtherFax),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, txtFax,chartDisclosureData.Fax),"Could not select Requested By", selenium,ClassName, MethodName);
			} 
			if(chartDisclosureData.testCaseId.equals("TC_CD_006")){
				assertTrue(type(selenium, txtRecipientName,chartDisclosureData.RecipientName),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, txtRecipientRel,chartDisclosureData.RecipientRel),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, txtRepConPhn,chartDisclosureData.ContactPhone),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, txtRepExtn,chartDisclosureData.Extn),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, txtAdd1,chartDisclosureData.Add1),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, txtAdd2,chartDisclosureData.Add2),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, txtCity,chartDisclosureData.City),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, lstState,chartDisclosureData.City),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, txtZip,chartDisclosureData.Zip),"Could not select Requested By", selenium,ClassName, MethodName);
				assertTrue(type(selenium, lstCountry,chartDisclosureData.Country),"Could not select Requested By", selenium,ClassName, MethodName);				 
			} 
			if(chartDisclosureData.testCaseId.equals("TC_CD_007")){
				assertTrue(type(selenium, txtFax,chartDisclosureData.Fax),"Could not select Requested By", selenium,ClassName, MethodName);			 
			}


			return true;


		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * navigateToPatient 
	 * function navigateToPatient
	 * @since Feb 04, 2014
	 **/ 
	public boolean navigateToPatient(Selenium selenium, ChartPreVisitLib PatientData) throws IOException{

		assertTrue(type(selenium, txtPatientBox, PatientData.patientId),"Could not type patient id", selenium, ClassName,MethodName);
		selenium.clickAt("searchPatientBox","");
		selenium.focus("searchPatientBox");			
		selenium.fireEvent("searchPatientBox","keypress");		
		waitForElement(selenium, lblPatientResult, 10000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+ PatientData.patientId, selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		selenium.mouseOver(lblPatientResult2);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		return true;
	}

	public boolean createChartDisclosureRequest(Selenium selenium,ChartPreVisitLib PatienttaskData){
		try{			
			selenium.type(Tasktextbox,PatienttaskData.Instruction);
			assertTrue(selectValueFromAjaxList(selenium,RequestSuggestbox,PatienttaskData.Requestedby),"Could not select the Method Of Payment", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ReceptSuggestbox,PatienttaskData.Recipienttype),"Could not select the Method Of Payment", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,DeliverySuggestbox,PatienttaskData.Deliverymethod),"Could not select the Method Of Payment", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ConsentSuggestbox,PatienttaskData.Consentname),"Could not select the Method Of Payment", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);		
			return true;
		}

		catch(Exception e){
			Assert.fail("Create Disclouser failed");
		}	
		return false;
	}
	/**
	 * verifyChartDisclosureData function to verify data after creating the Chart Disclosure
	 * @throws IOException 
	 * 
	 * @since May 07, 2014
	 */
	public boolean verifyChartDisclosureData(Selenium selenium,
			ChartPreVisitLib chartDisclosureData) throws IOException {
		try {
			assertTrue(selenium.isChecked(radIncludeFullChart),"Default selection is not Include Full Chart", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			if (!getText(selenium, txtChartDLSInst).trim().contains(
					chartDisclosureData.Instruction.trim()))
				return false;
			if (!getValue(selenium, ajxChartReqBy).trim().contains(
					chartDisclosureData.Requestedby.trim()))
				return false;
			if (!getValue(selenium, txtChartDLSInst).trim().contains(
					chartDisclosureData.Instruction.trim()))
				return false;
			if (!getValue(selenium, ajxChartRepType).trim().contains(
					chartDisclosureData.Recipienttype.trim()))
				return false;
			if (!getValue(selenium, ajxChartDeliverryMethod).trim().contains(
					chartDisclosureData.Deliverymethod.trim()))
				return false;
			if (!getValue(selenium, ajxChartConsentName).trim().contains(
					chartDisclosureData.Consentname.trim()))
				return false;


		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * verifyChartDisclosurePrintData 
	 * function to verify data after creating the Chart Disclosure
	 * @throws IOException  
	 * @since May 07, 2014
	 */
	public boolean verifyChartDisclosurePrintData(Selenium selenium,
			ChartPreVisitLib chartDisclosureData) throws IOException {

		try {
			waitForPageLoad(selenium);
			if (!selenium.isTextPresent(chartDisclosureData.Instruction.trim()))
				return false;
			if (!selenium.isTextPresent(chartDisclosureData.Recipienttype.trim()))
				return false;
			if (!selenium.isTextPresent(chartDisclosureData.Deliverymethod.trim()))
				return false;
			if (!selenium.isTextPresent(chartDisclosureData.Consentname.trim()))
				return false;
			assertTrue(selenium.isElementPresent(btnCancelChartDis),"Could not select the Method Of Payment", selenium , ClassName, MethodName);

			if(chartDisclosureData.testCaseId.equals("TC_CD_008")){
				assertTrue(click(selenium,radIncludePartialChart),"Include Partial Chart Radio Button not Present", selenium , ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(selenium.isElementPresent(lstShowSuggestBox),"Could not select the Method Of Payment", selenium , ClassName, MethodName);
				assertTrue(selenium.isElementPresent(dateFromFilter),"Could not select the Method Of Payment", selenium , ClassName, MethodName);
				assertTrue(selenium.isElementPresent(dateToFilter),"Could not select the Method Of Payment", selenium , ClassName, MethodName);
				assertTrue(selenium.isElementPresent(ajxAddFilterBy),"Could not select the Method Of Payment", selenium , ClassName, MethodName);
				assertTrue(selenium.isElementPresent(btnContinueChartDis),"Could not select the Method Of Payment", selenium , ClassName, MethodName);
				assertTrue(selenium.isElementPresent(btnEditRequest),"Could not select the Method Of Payment", selenium , ClassName, MethodName);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * labAdvanceSearch
	 * function to labAdvanceSearch
	 * @throws IOException  
	 * @since May 19, 2014
	 */
	public boolean labAdvanceSearch(Selenium selenium, ChartPreVisitLib labData, String account, String uniqueAccNumber) throws IOException {
		assertTrue(type(selenium, txtAccessionNo,uniqueAccNumber),"Could not type patient id", selenium, ClassName,MethodName);
		assertTrue(click(selenium, btnAdvanceSearch),"Could not click the search button", selenium,ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}

	/**
	 * verifySearchResultDetails 
	 * function to verifySearchResultDetails
	 * @throws IOException  
	 * @since May 19, 2014
	 */
	public boolean verifySearchResultDetails(Selenium selenium,ChartPreVisitLib labData, String patientName)throws IOException {
		 String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ labData.switchRole , "");
			assertTrue(selenium.isTextPresent(labData.authorization),"Authorization  is not present", selenium, ClassName,MethodName);
			assertTrue(selenium.isTextPresent(patientName),"Patient name is not present", selenium, ClassName,MethodName);
			assertTrue(selenium.isTextPresent("Dr."+providerName),"Patient name is not present", selenium, ClassName,MethodName);
			return true;
	}

	//Implement Referral methods
	public boolean verifyIfLetterTemplateExits(Selenium selenium, String templateName) {
		Boolean verificationResult = false;
		int templateIndex = getIndexOfLetterTemplate(selenium, templateName);
		if( templateIndex == 0 )
			System.out.println("The Letter template with name " + templateName + " not found");
		else {
			System.out.println("The Letter template with name " + templateName + " has index "+templateIndex);
			verificationResult = true;
		}	
		return verificationResult;
	}

	public int getIndexOfLetterTemplate(Selenium selenium,String givenTemplateName) {
		int indexOfGivenTemplateName = 0;		
		int rowCount = (Integer) selenium.getXpathCount(lblLetterTemplates);
		for (int i = 1; i <= rowCount; i++) {
			String lblLetterTemplate = lblLetterTemplates + "[" +i+ "]";
			String templateNameOfCurrentRow = getText(selenium, lblLetterTemplate);
			if(templateNameOfCurrentRow.equalsIgnoreCase(givenTemplateName)){
				indexOfGivenTemplateName = i;
				break;
			}

		}
		return indexOfGivenTemplateName;

	}


public boolean navigateToLetterTemplate(Selenium selenium) throws IOException{

		assertTrue(click(selenium, lnkSettings), "Could not click on Quick Actions link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkTemplateSetup), "Could not click on Template Setup", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkLetterTemplate), "Could not click on Letter Template link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!isElementPresent(selenium, btnAddLetterTemplate)){
			System.out.println("Not able to find Add Template button");
			return false;
		}
		return true;
	}





public boolean renameLetterTemplate(Selenium selenium, ChartPreVisitLib letterTemplateTestData) throws IOException {
	boolean result = true;
	assertTrue(deleteLetterTemplateIfExits(selenium,letterTemplateTestData.letterTemplateName), "The template " +letterTemplateTestData.letterTemplateName+ " not deleted succcesfully", selenium, ClassName, MethodName);
	String lnkTemplateEdit = "";
	
	waitForPageLoad(selenium);
	int templateIndex = getIndexOfLetterTemplate(selenium,letterTemplateTestData.letterTemplateName);
	if( templateIndex == 0 ){
		System.out.println("The Letter template with name " + letterTemplateTestData.letterTemplateName + " not found");
		assertTrue(addNewReferralLetterTemplate(selenium,letterTemplateTestData), "Could not create new referral letter template", selenium, ClassName, MethodName);
	}else
		System.out.println("The Letter template with name " + letterTemplateTestData.letterTemplateName + " has index "+templateIndex);

	templateIndex = getIndexOfLetterTemplate(selenium,letterTemplateTestData.letterTemplateName);
	lnkTemplateEdit = lnkTemplateEdits + "[" +templateIndex+ "]";

	assertTrue(click(selenium,lnkTemplateEdit),"Could not click Edit link.", selenium , ClassName, MethodName);				
	waitForPageLoad(selenium);
	assertTrue(type(selenium,txtLetterTemplateName,letterTemplateTestData.templateNameToRename),"Could not type template name", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);	
	assertTrue(selectValueFromAjaxList(selenium, ajxPageSize,letterTemplateTestData.templatePageSize), "Could not select Page Size in add Day sheet template", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);		
	assertTrue(selectValueFromAjaxList(selenium, ajxTemplateType,letterTemplateTestData.templateType), "Could not select Template Type in add Day sheet template", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);	
	assertTrue(click(selenium, btnSave ), "Could not click Save button", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);

	if (isElementPresent(selenium, ajxTemplateType)) {
		System.out.println("User is not navigated to Letter Templates list page after clicking Save button");
		result = false;
	}	

	return result;
}
	
	
	
	public boolean createAllTemplateField(Selenium selenium, String allTemplateFields) throws IOException {
		String fieldName;
		String groupFieldInfo ;
		boolean result = true;

		if( allTemplateFields.trim().isEmpty()) {
			System.out.println("No template fields supplied");
			return result;
		}

		try {	
			String[] templateField = allTemplateFields.split("&");		
			for (int i = 0; i < templateField.length; i++) {
				String[] templateFieldInfo = templateField[i].trim().split("=");
				fieldName = templateFieldInfo[0].trim();
				groupFieldInfo = templateFieldInfo[1].trim();
				String[] groupFieldInfoParams  = groupFieldInfo.split("_");
				
				if (!createTemplateGroupField(selenium, fieldName, groupFieldInfoParams) ) {
					System.out.println("Error occurred while creating template field with name - " +fieldName);
					result = false;
				}		

			}	

		}catch(Exception e) {
			System.out.println("Following error occured while creating all template fields: \n" +e.getMessage());
			result = false;
		}
		return result;
	}
	
	public boolean isTemplateFieldExists(Selenium selenium, String fieldName) {
		String linkCurrentSelectedField = "";
		String fieldNameOfCurrentField = "";
		boolean fieldFound = false;
		boolean result = false;
		int fieldsCount = (Integer) selenium.getXpathCount(linkSelectedTemplateFields);
		for (int i = 0; i <= fieldsCount-1; i++) {
			linkCurrentSelectedField = linkSelectedTemplateFields + "[" + (i+1)+ "]";
			fieldNameOfCurrentField = getText(selenium, linkCurrentSelectedField);
			if (fieldNameOfCurrentField.equals(fieldName)) {
				System.out.println("Template field - " +fieldName+ " found on index " + (i+1));
				fieldFound = true;
				result = true;
				return result;
			}
		}
		
		if (!fieldFound) {
			System.out.println("Template field - " +fieldName+ " not found");
			result = false;
		}
		
		return result;
	}

	public boolean createTemplateGroupField(Selenium selenium, String fieldName, String[] elementsToselect) throws IOException {
		boolean result = true;
		String objDraggableTemplateField;		
		String fieldType = elementsToselect[0];
		
		for (int i = 1; i < elementsToselect.length; i++) {
			
			if(i==1) {
				assertTrue(click(selenium, btnAddTemplateField ), "Could not click on Add New button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtFieldName,fieldName),"Could not type template name", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(selectValueFromAjaxList(selenium, ajxFieldType, fieldType), "Could not select field type", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}	
			objDraggableTemplateField = "//div[@class='gwt-Label' and text()='" +elementsToselect[i]+ "']";	
			if(elementsToselect[i].equals(".")||elementsToselect[i].equals(",") || elementsToselect[i].equals("-")
					||elementsToselect[i].equals(":")||elementsToselect[i].equals(";") ) {
				System.out.println("Found special symbol");
				selenium.doubleClick(objDraggableTemplateField);
			}			
			selenium.dragAndDropToObject(objDraggableTemplateField, objTemplateFieldsDropTarget);  
			waitForPageLoad(selenium);
			
			
		}
		assertTrue(click(selenium, btnTemplateSecondrySave ), "Could not click Save button in the popup", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		
		if (isElementPresent(selenium, objTemplateFieldsDropTarget)) {
			System.out.println("Add new field popup not closed after clicking Save button");
			result = false;
		}	
	
		return result;

	}
	
	public boolean selectLetterTemplateToEdit(Selenium selenium, ChartPreVisitLib letterTemplateTestData) throws IOException {
		String lnkTemplateEdit = "";
		if(!verifyIfLetterTemplateExits(selenium, letterTemplateTestData.letterTemplateName)){
			System.out.println("The Letter template with name " + letterTemplateTestData.letterTemplateName + " not found");
			assertTrue(addNewReferralLetterTemplate(selenium,letterTemplateTestData), "Could not create new referral letter template", selenium, ClassName, MethodName);
			
			assertTrue(navigateToLetterTemplate(selenium),"Could not navigate to Letter Template page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		int templateIndex = getIndexOfLetterTemplate(selenium,letterTemplateTestData.letterTemplateName);
		if( templateIndex == 0 ) {
			System.out.println("The Letter template with name " + letterTemplateTestData.letterTemplateName + " not found");			
		} else
			System.out.println("The Letter template with name " + letterTemplateTestData.letterTemplateName + " is "+templateIndex);

		lnkTemplateEdit = lnkTemplateEdits + "[" +templateIndex+ "]";
		assertTrue(click(selenium,lnkTemplateEdit),"Could not click Edit link.", selenium , ClassName, MethodName);				
		waitForPageLoad(selenium);

		if ( ! selenium.isTextPresent("Edit Letter Template") ) {
			//Not able to navigate to template letterTemplateName for editing
			return false;
		}

		return true;

	}
	public boolean deleteTemplateField(Selenium selenium, String fieldName) throws IOException {
		String linkCurrentSelectedField = "";
		String fieldNameOfCurrentField = "";
		boolean result = true;
		boolean fieldFound = false;

		int fieldsCount = (Integer) selenium.getXpathCount(linkSelectedTemplateFields);
		for (int i = 0; i <= fieldsCount-1; i++) {
			linkCurrentSelectedField = linkSelectedTemplateFields + "[" + (i+1)+ "]";
			fieldNameOfCurrentField = getText(selenium, linkCurrentSelectedField);
			if (fieldNameOfCurrentField.equals(fieldName)) {
				fieldFound = true;
				//perform delete operation
				selenium.doubleClick(linkCurrentSelectedField);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnTemplateSecondryDelete),"Could not click Edit link.", selenium , ClassName, MethodName);
				waitForPageLoad(selenium);
				result = true;
				return result;
			}
		}

		if(!fieldFound){
			System.out.println("The field " +fieldName+ " not found");
			result = false;
		}

		return result;
	}
	
	public boolean verifyIfTemplateFieldsPresent(Selenium selenium, String allTemplateFields) {
		String fieldName;
		String[] templateField = allTemplateFields.split("&");		
		for (int i = 0; i < templateField.length; i++) {
			String[] groupInfo = templateField[i].trim().split("=");
			fieldName = groupInfo[0].trim();
			 if (!isTemplateFieldExists(selenium, fieldName)) {
				 System.out.println("The template field " +fieldName+ " not found");
				 return false;
			 }
		}	
		return true;	
	}
	
	
//	public boolean createPatientTaskForCosign(Selenium selenium,ChartPreVisitLib TaskData) throws IOException
	public boolean createPatientTaskForCosign(Selenium selenium,ChartPreVisitLib TaskData) throws IOException
	{
		
		assertTrue(selectValueFromAjaxList(selenium, Tasksuggestbox,TaskData.TaskType), "Could not select field type", selenium, ClassName, MethodName);
		
		assertTrue(type(selenium, "instructionsTextBoxId","Task"), "Could not select field type", selenium, ClassName, MethodName);		
		
	//	assertTrue(type(selenium, chartDLSInst,TaskData.Instruction), "Could not select field type", selenium, ClassName, MethodName);
		
		
		assertTrue(selectValueFromAjaxList(selenium, "xpath=(//input[@id='timeCountSuggestBoxsuggestBox'])[2]","1"), "Could not select field type", selenium, ClassName, MethodName);
		
		
		assertTrue(selectValueFromAjaxList(selenium, ajxTaskAssignTo ,TaskData.AssignTo), "Could not select field type", selenium, ClassName, MethodName);
	
		assertTrue(click(selenium, "saveID" ), "Could not click Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(!isElementPresent(selenium,"saveID"), "Task is not saved ", selenium, ClassName, MethodName);
		return true;
	}

	
	public boolean addNewReferralLetterTemplate(Selenium selenium, ChartPreVisitLib letterTemplateTestData) throws IOException {
		boolean result = true;
		
		//  Check whether Letter Template already exists, if yes delete it
		assertTrue(deleteLetterTemplateIfExits(selenium,letterTemplateTestData.letterTemplateName), "The template " +letterTemplateTestData.letterTemplateName+ " not deleted succcesfully", selenium, ClassName, MethodName);
		
		assertTrue(click(selenium, btnAddLetterTemplate), "Could not click on add new Letter template button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		
		//Provide template header values		
		assertTrue(type(selenium,txtLetterTemplateName,letterTemplateTestData.letterTemplateName),"Could not type template name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		assertTrue(selectValueFromAjaxList(selenium, ajxPageSize,letterTemplateTestData.templatePageSize), "Could not select Page Size in add Day sheet template", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		assertTrue(selectValueFromAjaxList(selenium, ajxTemplateType,letterTemplateTestData.templateType), "Could not select Template Type in add Day sheet template", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//Select fields for the template
		assertTrue(createAllTemplateField(selenium, letterTemplateTestData.allTemplateFields), "Could not create all template field", selenium, ClassName, MethodName);
		
		//Write letter template
		assertTrue(click(selenium, btnSource), "Could not click Source button in Letter template toolbar", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
				
		assertTrue(type(selenium,txtTemplateArea ,letterTemplateTestData.templateHTML),"Could not type element", selenium, ClassName, MethodName);

		assertTrue(click(selenium, btnSource), "Could not click Source button in Letter template toolbar", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//Save the template
		assertTrue(click(selenium, btnSave ), "Could not click Save button in the popup", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if (isElementPresent(selenium, ajxTemplateType)) {
			System.out.println("User is not navigated to Letter Templates list page after clicking Save button");
			result = false;
		}	

		return result;
		
	}

	
	public boolean editReferralLetterTemplate(Selenium selenium, ChartPreVisitLib letterTemplateTestData) throws IOException {
		boolean result = true;
		
		//Select template to be modified
		assertTrue(selectLetterTemplateToEdit(selenium, letterTemplateTestData),"Could not click Edit link for template " +letterTemplateTestData.letterTemplateName, selenium , ClassName, MethodName);
		
		//Provide template header values
		assertTrue(type(selenium,txtLetterTemplateName,letterTemplateTestData.letterTemplateName),"Could not type template name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		assertTrue(selectValueFromAjaxList(selenium, ajxPageSize,letterTemplateTestData.templatePageSize), "Could not select Page Size in add Day sheet template", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
		assertTrue(selectValueFromAjaxList(selenium, ajxTemplateType,letterTemplateTestData.templateType), "Could not select Template Type in add Day sheet template", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Select fields for the template
		assertTrue(createAllTemplateField(selenium, letterTemplateTestData.editTemplateFields), "Could not create template field for modification", selenium, ClassName, MethodName);

		//Write letter template
		assertTrue(click(selenium, btnSource), "Could not click Source button in Letter template toolbar", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(type(selenium,txtTemplateArea, letterTemplateTestData.editTemplateHTML),"Could not type in Template text area", selenium, ClassName, MethodName);

		assertTrue(click(selenium, btnSource), "Could not click Source button in Letter template toolbar", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Save the template
		assertTrue(click(selenium, btnSave ), "Could not click Save button in the popup", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		if (isElementPresent(selenium, ajxTemplateType)) {
			System.out.println("User is not navigated to Letter Templates list page after clicking Save button");
			result = false;
		}	

		return result;

	}
	/**
	 * Create a New Correspondence Report					
	 * 
	 * @since June 23, 2014
	 */
	public boolean CreateCorrespondenceReport(Selenium selenium,ChartPreVisitLib medicationData,String userAccount) throws IOException
	{
		try {
		
			String date = null;  
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat.format(cal.getTime());

			}else{
				Calendar cal1=Calendar.getInstance();
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
				date=DateForma1t.format(cal1.getTime());		
			}
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("msH");
			String date1=DateFormat1.format(cal.getTime());
			medicationData.AccessionNumber=date1;			
			File dir1 = new File(".");
			String strBasePath = null;
			String file = null;
			String xmlName = "Medica_Report.doc";
			String sectionName = "chartprevisit";
			strBasePath = dir1.getCanonicalPath();
			file = strBasePath + File.separator + "src" + File.separator+ "main" + File.separator + "resources" + File.separator+ "nexia" + File.separator + "testdata" + File.separator+ sectionName + File.separator + xmlName;
			waitForPageLoad(selenium);
			String providerNameTemp = getText(selenium, lnkTopMenu);
			String pName = providerNameTemp.replaceAll(", "
					+ medicationData.switchRole, "");
			String tempArray[] = pName.split(" ");
			String providerName = tempArray[1] + ", " + tempArray[0];
			medicationData.Receivingprovider = providerName;
			assertTrue(click(selenium, btnUploadFile),		"Could not click upload btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtBrowseFile, file),	"Could not select Docu type", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			Robot robot = null;
			robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			assertTrue(click(selenium, btnFile),"Could not click File button btn", selenium, ClassName,	MethodName);
			 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtSearchFileToPatient,medicationData.patientId),"Could not type patient id",selenium, ClassName, MethodName);
			
			assertTrue(clickAt(selenium,txtSearchFileToPatient, ""),"Could not perform click At",selenium, ClassName, MethodName);
			assertTrue(focus(selenium,txtSearchFileToPatient),"Could not perform focus",selenium, ClassName, MethodName);
			assertTrue(fireEvent(selenium,txtSearchFileToPatient,"keypress"),"Could not perform fireevent",selenium, ClassName, MethodName);			
			assertTrue(keyPress(selenium,txtPatientBox, "\\9"),"Could not perform keypress",selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
		
			waitForElement(selenium, txtSearchFileToPatient, 30000);
			assertTrue(isElementPresent(selenium,txtSearchFileToPatient),"Search Results are not displayed for the patient with ID :-"+ medicationData.patientId,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,patientInfoWid).toLowerCase(new java.util.Locale("en", "US")).trim().contains(medicationData.patientId.trim().toLowerCase(new java.util.Locale("en", "US"))),"Could not get the text value",selenium, ClassName, MethodName);
			//assertTrue(getText(selenium,lblPatientResult).contains(patientID));
			waitForPageLoad(selenium);
			assertTrue(click(selenium, patientInfoWid),"Could not select the patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium, ajxDocuType,medicationData.DocumentType),		"Could not select Docu type", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, elementaccNumberforCorres,medicationData.AccessionNumber),"Could not  type Accession number", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);			 
			assertTrue(selectValueFromAjaxList(selenium, ajxReport,medicationData.ReportType), "Could not select Docu type",	selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(enterDate(selenium, txtServiceDate1, date ),"Could not type date.", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(enterDate(selenium, txtReceivingDate, date ),"Could not type date.", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(selectValueFromAjaxList(selenium,ajxRProvider,medicationData.Receivingprovider), "Could not select Docu type",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtSender,medicationData.Sender),"Could not select sender", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium, ajxOProvider,medicationData.Receivingprovider), "Could not select ordering provider ",	selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			assertTrue(selectValueFromAjaxList(selenium, ajxDisgnosis,medicationData.Diagnosis), "Could not select diagonosis",	selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(type(selenium, txtreportComments,medicationData.Comments),"Could not type report comment", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			
			if(	medicationData.testCaseId.equals("TC_CCR_016"))
			{
				assertTrue(click(selenium, btnSign),"Could not click Sign button btn", selenium, ClassName,MethodName);	
			}
			else
			{
				assertTrue(click(selenium, btnSaveNext),"Could not click File button btn", selenium, ClassName,MethodName);
			}			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium, btnSaveNext),"Could not click File button btn", selenium, ClassName,MethodName);
		
			if(	medicationData.testCaseId.equals("TC_PSM_007"))
			{
				assertTrue(searchPatientNexiaForProviderHomePage(selenium,	medicationData.patientId),"Could not search the patient", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, CorresTab),"Could not click File button btn", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				
				assertTrue(isElementPresent(selenium, lblFirstCorresReport),"Could not find the corresreport", selenium, ClassName,MethodName);
				
				waitForPageLoad(selenium);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail(e.getMessage());
		}
		return true;
		
	}


	public boolean deleteLetterTemplateIfExits(Selenium selenium, String templateName) throws IOException {
		boolean verificationResult = false;
		String lnkTemplateDelete = "";		
		
		int templateIndex = getIndexOfLetterTemplate(selenium, templateName);
		if( templateIndex == 0 ) {
			System.out.println("The Letter template with name " + templateName + " not found.");
			verificationResult = true;
			return verificationResult;
		}else {
			System.out.println("The Letter template with name " + templateName + " has index "+templateIndex);
		}
		
		lnkTemplateDelete = lnkTemplateDeletes + "[" +templateIndex+ "]";
		assertTrue(click(selenium,lnkTemplateDelete),"Could not click Delete link for template - " +templateName, selenium , ClassName, MethodName);				
		waitForPageLoad(selenium);

		if ( ! isElementPresent(selenium, btnDeleteConfirmation) ) {
			verificationResult = false;
			fail("Not able to find Yes button for confirming template deletion");
			return verificationResult;
		}
		
		assertTrue(click(selenium, btnDeleteConfirmation),"Could not click Yes button to confirm deletion of template - " +templateName, selenium , ClassName, MethodName);				
		waitForPageLoad(selenium);
		verificationResult = true;
		return verificationResult;
	}
	
	public boolean createLetterTemplate(Selenium selenium, ChartPreVisitLib letterTemplateTestData ) throws IOException {
		boolean result = false;
		
		//Navigate to Letter template  						  
		assertTrue(navigateToLetterTemplate(selenium),"Could not navigate to Letter Template page", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);			

		//Add new Referral Letter template  						  
		assertTrue(addNewReferralLetterTemplate(selenium,letterTemplateTestData), "Could not create new referral letter template", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Verify if presence of newly created Letter template
		assertTrue(verifyIfLetterTemplateExits(selenium,letterTemplateTestData.letterTemplateName), "The template " +letterTemplateTestData.letterTemplateName+ " not exits", selenium, ClassName, MethodName);
		
		if ( !verifyIfLetterTemplateExits(selenium,letterTemplateTestData.letterTemplateName)) {
			System.out.println("The template " +letterTemplateTestData.letterTemplateName+ " not exits");
			return result;
		}
		
		result = true;
		return result;
	}
	
	public boolean addNewReferralLetter(Selenium selenium, ChartPreVisitLib referralData) throws IOException {
		boolean result = false;
		
		assertTrue(navigateToReviewReferralLetterPage(selenium, referralData),"Could not navigate to Review Referral Letter page", selenium, ClassName, MethodName);
		
		assertTrue(selectValueFromAjaxList(selenium, ajxSearchReferral,"Martin"), "Could not select referal - " +referralData.referral1, selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium, ajxSelectTemplate ,referralData.letterTemplateName), "Could not select template",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//editReferralLetter() //This functionality cannot be automated using selenium RC 
				
		assertTrue(click(selenium,btnReferralSave),"Could not click Save button", selenium , ClassName, MethodName);
		
		waitForPageLoad(selenium);
		
		if ( ! selenium.isTextPresent("Encounter Note") ) {
			System.out.println("Not navigated to Encounter Note page");
			result = false;
			return result;
		}
				
		result = true;
		return result;
		
	}	
	
	public boolean checkIfReferralNoteAdded(Selenium selenium, ChartPreVisitLib referralData) throws IOException {		
		boolean result = false;
		assertTrue(selenium.isTextPresent("Encounter Note"),"Not in Encounter Note page", selenium , ClassName, MethodName);
		assertTrue(selenium.isTextPresent("Referred To"),"Text 'Referred To' not found.", selenium , ClassName, MethodName);		
		assertTrue(click(selenium,lblReferredToInEncounterNote),"Could not click Referred To link.", selenium , ClassName, MethodName);
		
		assertTrue(selenium.isElementPresent(lnkEditReferralNote),"Could not find link to edit Referral Letter.", selenium , ClassName, MethodName);
		assertTrue(click(selenium,lnkEditReferralNote),"Could not click the link to edit Referral Letter.", selenium , ClassName, MethodName);
		waitForPageLoad(selenium);	
		assertTrue(selenium.isTextPresent("Refer Patient"),"Could not find text Refer Patient", selenium , ClassName, MethodName);
		assertTrue(selenium.isTextPresent("Martin"),"Could not find Recipient "+ referralData.referral1, selenium , ClassName, MethodName);
		
		if ( !getValue(selenium, ajxSelectTemplate).equalsIgnoreCase(referralData.letterTemplateName)){
			System.out.println("Not able to find Template name " +referralData.letterTemplateName);
			result = false;
			return result;
		}
		
		assertTrue(click(selenium,btnReferralCancel),"Could not click Cancel button.", selenium , ClassName, MethodName);		
		result = true;
		return result;
	}
	
	public boolean navigateToReviewReferralLetterPage(Selenium selenium, ChartPreVisitLib referralData) throws IOException {
		boolean result = false;
		
		assertTrue(click(selenium,imgReferralIcon),"Could not click the referral order button", selenium, ClassName, MethodName);		
		waitForPageLoad(selenium);
		
		if ( ! selenium.isTextPresent("Refer Patient") ) { 
			System.out.println("Not navigated to Refer Patient  page");
			result = false;
			return result;
		}
				
		result = true;
		return result;
	}


	public ArrayList<String> readLetterText(Selenium selenium) {
		
		String lbllettertext = "";
		ArrayList<String> letterText = new ArrayList<String>();
		
		System.out.println("Reading letter text");
		click(selenium, objReferralLetterTextArea);
		waitForPageLoad(selenium);
		int n =  (Integer) selenium.getXpathCount(lbllettertexts);
		for (int i = 1; i <= n; i++) {
			lbllettertext = lbllettertexts + "[" +i+ "]";
			System.out.println("Referal Letter text in line " +i+ " is - " +  getText(selenium, lbllettertext) );
			letterText.add(getText(selenium, lbllettertext));
		}			
		
		return letterText;
	}
	
	public ArrayList<String> readLetterFromReviewReferralLetterPage(Selenium selenium, ChartPreVisitLib referralData) throws IOException {
		ArrayList<String> letterBody;
		
		assertTrue(navigateToReviewReferralLetterPage(selenium, referralData),"Could not navigate to Review Referral Letter page", selenium, ClassName, MethodName);
		
		assertTrue(selectValueFromAjaxList(selenium, ajxSearchReferral,referralData.referral1), "Could not select referal - " +referralData.referral1, selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium, ajxSelectTemplate ,referralData.letterTemplateName), "Could not select template",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		letterBody = readLetterText(selenium);
		return letterBody;		
	}

    public boolean verifyIfLetterContains(ArrayList<String> letterContents,String searchString ) {
        boolean result = false;
        ArrayList<String> resList = new ArrayList<String>();
        for (String curVal : letterContents){
          if (curVal.contains(searchString)){
            resList.add(curVal);
            System.out.println("Found value "+searchString+ " in " +curVal);
            result = true;
            return result;         
          }             
        }
        return result;
 }



	
	
	//EMR Security methods
	public boolean verifySocioEconomicsInfoFromPatientRegistration(Selenium selenium, ChartPreVisitLib patientData) throws IOException {

		assertTrue(navigateToEditSocioEconomicsPageFromPatientRegistration(selenium, patientData),"Could not navigate to Edit SocioEconomics page from Patient Registration",selenium,ClassName,MethodName);
		
		if(!getValue(selenium,ajxRace).trim().contains(patientData.race.trim())){
			return false;
		}
		if(!getValue(selenium,ajxEthnicity).trim().contains(patientData.ethnicity.trim())){
			return false;
		}
		if(!getValue(selenium,ajxReligion).trim().contains(patientData.religion.trim())){
			return false;
		}
		if(!getValue(selenium,ajxCitizenShip).trim().contains(patientData.citizenship.trim())){
			return false;
		}
		if(!getValue(selenium,ajxStudentStatus).trim().contains(patientData.studentStatus.trim())){
			return false;
		}
		if(!getValue(selenium,ajxHouseholdIncome).trim().contains(patientData.householdIncome.trim())){
			return false;
		}
		if(!getValue(selenium,ajxEmploymentStatus).trim().contains(patientData.employmentStatus.trim())){
			return false;
		}
		if(!getValue(selenium,txtComments).trim().contains(patientData.comments.trim())){
			return false;
		}
		
		
		return true;
	}

	public boolean editSocioEconomicsInfoFromPatientRegistration(Selenium selenium, ChartPreVisitLib patientData) throws IOException {
		
		assertTrue(navigateToEditSocioEconomicsPageFromPatientRegistration(selenium, patientData),"Could not navigate to Edit SocioEconomics page from Patient Registration",selenium,ClassName,MethodName);
					
		assertTrue(selectValueFromAjaxList(selenium, ajxRace, patientData.race),"Could not set race in Edit Socio-Economic Data page", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium, ajxEthnicity, patientData.ethnicity),"Could not set ethnicity in Edit Socio-Economic Data page", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium, ajxReligion, patientData.religion),"Could not set religion in Edit Socio-Economic Data page", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium, ajxCitizenShip, patientData.citizenship),"Could not set citizenship in Edit Socio-Economic Data page", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium, ajxStudentStatus, patientData.studentStatus),"Could not set student status in Edit Socio-Economic Data page", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium, ajxHouseholdIncome, patientData.householdIncome),"Could not set household income in Edit Socio-Economic Data page", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium, ajxEmploymentStatus, patientData.employmentStatus),"Could not set emplyment in Edit Socio-Economic Data page", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtComments, patientData.comments),"Could not type comments in Edit Socio-Economic Data page", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, btnSave3),"Could not click Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}

	public boolean navigateToEditSocioEconomicsPageFromPatientRegistration( Selenium selenium, ChartPreVisitLib patientData) throws IOException {
		boolean result = false;
		
		assertTrue(searchPatientNexiaForProviderHomePage(selenium, patientData.patientId),"Could not search for patient - " +patientData.patientId, selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(click(selenium, lnkPatientOption),"Could not click the Patient Options link",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);

		if( isElementPresent(selenium, lnkRegPatientOption) ) {
			assertTrue(click(selenium,lnkRegPatientOption),"Could not click View Registration link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		}
					
		assertTrue(isElementPresent(selenium, lnkSocioEconomics),"Could not find Socio Economic link",selenium,ClassName,MethodName);
				
		assertTrue(click(selenium, lnkSocioEconomics),"Could not click Socio Economic link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, btnEdit),"Could not click Edit button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if( selenium.isTextPresent("Edit Socio-Economic Data") ) {
			System.out.println("Navigated to Edit Socio-Economic Data page");
			result = true;
		}
		
		return result;
	}

	public boolean setDataSharingBetweenPractices(Selenium selenium, ChartPreVisitLib providerData) throws IOException {
		//FIX ME
		String lblPartialMainPractice1 = "//*[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div/div[3]/div/div/div/div/div[";
		String lblPartialMainPractice2 = "]/table/tbody/tr/td/div/div/div[1]/div/div/span[1]";
		String lblMainPractice = "";
		String practiceName = "";
		String subPracticeName = "";			
		String lblSubPractice = "";
		String chkSharingLevel = "";
		String dataSharing = providerData.dataShareLevel;
		boolean found = false;
		boolean result = false;

		assertTrue(switchRole(selenium,"FULL"), "Could not switch the role", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(click(selenium, lnkSettings), "Could not click on Quick Actions link", selenium, ClassName, MethodName);

		assertTrue(click(selenium,lnkSecuritySettings),"Could not click System Settings link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(click(selenium,lnkDataSharing ),"Could not click Data Sharing link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnEditDataSharing  ),"Could not click Edit Data Sharing button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);			

		int n = (Integer) selenium.getXpathCount(lblPracticeDataSharing);
		System.out.println("Total number of Practices - " +n);

		for (int i = 1; i <= n; i++) {
			lblMainPractice = lblPartialMainPractice1 +i+ lblPartialMainPractice2;
			practiceName = selenium.getText(lblMainPractice);
			System.out.println("Practice name is " +practiceName);

			if (practiceName.equalsIgnoreCase(providerData.practice)) { 
				System.out.println("Found source practice - " +practiceName);
				for (int j = 1; j < n; j++) { //Iterating to subelements of practice
					lblSubPractice = lblPartialMainPractice1 +i+ "]/div/div[" +j+ "]/table/tbody/tr/td/div/div/div[1]/div/span";
					subPracticeName = selenium.getText(lblSubPractice);
					System.out.println("SubPractice is " +subPracticeName);

					if (subPracticeName.equalsIgnoreCase(providerData.newPractice)) {
						System.out.println("Found target Practice- " +subPracticeName);
						found = true;

						if(dataSharing.equalsIgnoreCase("Restricted")) {
							chkSharingLevel = lblPartialMainPractice1 +i+ "]/div/div[" +j+ "]/table/tbody/tr/td/div/div/div[2]/div/span/input";
							assertTrue(click(selenium, chkSharingLevel),"Could not check Restricted level checkbox", selenium, ClassName, MethodName);
							System.out.println("Restricted sharing level selected");
							result = true;
						}else if(dataSharing.equalsIgnoreCase("Summary")) {
							chkSharingLevel = lblPartialMainPractice1 +i+ "]/div/div[" +j+ "]/table/tbody/tr/td/div/div/div[3]/div/span/input";
							assertTrue(click(selenium, chkSharingLevel),"Could not check Summary level checkbox", selenium, ClassName, MethodName);
							System.out.println("Summary sharing level selected");
							result = true;
						}else if(dataSharing.equalsIgnoreCase("Full")) {
							chkSharingLevel = lblPartialMainPractice1 +i+ "]/div/div[" +j+ "]/table/tbody/tr/td/div/div/div[4]/div/span/input";
							assertTrue(click(selenium, chkSharingLevel),"Could not check Full Sharing level checkbox", selenium, ClassName, MethodName);
							System.out.println("Full sharing level selected");
							result = true;
						}else {
							System.out.println("Incorrect Data sharing level provided");
							System.out.println("Please select any one of 'RESTRICTED', 'SUMMARY' and 'FULL' ");
							found = false;
							result = false;
							break;
						}

						break;
					}
				}
				if (found) {
					break;
				}

			}
		}

		if (! found) {
			System.out.println("Supplied Practice not found");
			result = false;
		}

		//Click Save button
		assertTrue(click(selenium, btnDataSharingSave),"Could not click Data Sharing Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return result;
	}

	public boolean switchPractice(Selenium selenium, String practiceName) throws IOException {

		String allPractices = "xpath=(//a[contains(@id,'practice')])";
		String currentPractice ="";
		String currentPracticeName = "";
		boolean practiceFound = false;
		boolean result = false;

		click(selenium, "locationMenuHeader");	
		waitForPageLoad(selenium);
		int n = (Integer) selenium.getXpathCount(allPractices);
		//System.out.println("Total practices for current user are = " +n);
		for (int i = 1; i <= n; i++) {
			currentPractice = allPractices + "[" +i+ "]";
			currentPracticeName = getText(selenium,currentPractice);
			System.out.println("Practice - " +i+ " is: " +currentPracticeName ) ;
            //waitForPageLoad(selenium);
			if (currentPracticeName.equalsIgnoreCase(practiceName)) {
				assertTrue(click(selenium, currentPractice),"Could not click Practice - " +currentPracticeName, selenium,ClassName,MethodName);
				System.out.println("Switching to practice - " + currentPracticeName);
				if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"Could not Clink",selenium, ClassName, MethodName);

				practiceFound = true;
				result = true;
				break;
			}

		}

		if (!practiceFound) {
			System.out.println("Not able to find Practice - " +practiceName);
			result = false;
		}

		return result;

	}

	public boolean enableEmergencyAccessForUser(Selenium selenium, ChartPreVisitLib providerData) throws IOException {

		//Navigate to Emergency Access page
		assertTrue(click(selenium,lnkSettings),"Could not click on Quick Action", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkSecuritySettings),"Could not click System Settings link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkEmergencyAccess),"Could not click Emergency Access link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Click Edit button in Emergency Access screen
		assertTrue(click(selenium,btnEmergencyAccessEdit),"Could not click the Emergency Access Edit button",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent("Edit Emergency Access Users"),"Not able to find text - Edit Emergency Access Users",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Provide user details for which emergency access needs to be provided
		assertTrue(type(selenium,txtEmergencyAccessSearch, providerData.provider),"Could not click the Edit button in Emergency Access page",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);

		assertTrue(click(selenium,btnEmergencyAccessSearch),"Could not click the Search button",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);

		assertTrue( check(selenium, chkSearchResult),"Could not click first search Result",selenium,ClassName,MethodName);			
		selenium.fireEvent(chkSearchResult,"click");
		waitForPageLoad(selenium);						

		//Click on Save button
		assertTrue(click(selenium,btnEmergencyAccessSave),"Could not click the Save button",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
	

	
public boolean makePatientChartRestricted(Selenium selenium, ChartPreVisitLib userData,String patientId) throws IOException {
		
		// Advanced search with Patient ID who want its chart to be restricted
		searchPatientNexiaForProviderHomePage(selenium,patientId);
		waitForPageLoad(selenium);

		if (isElementPresent(selenium, btnEmergencyAccessContinue)) {
			System.out.println("The patient is already restricted .Continue button for Emergency Access found");
			assertTrue(click(selenium,btnEmergencyAccessContinue),"Could not click Continue button for Emergency Access",selenium,ClassName,MethodName);
			return true;
		}
		
		// Navigate to Restricted users page
		assertTrue(goToRestrictedUsers(selenium),"Could not Navigate to prescribe medication page",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);

		//Click on Add New button in Restricted Users page
		assertTrue(click(selenium,btnAddNewRestrictedUser ),"Could not click the Add New button in Restricted Users page",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);

		//Add user for restriction
		assertTrue(click(selenium,lnkTimeLine ),"Could not click the TimeLine link",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxUserList,userData.provider),"Could not select user " +userData.provider, selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, btnAddNewUser ),"Could not click the Add New button",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);

		assertTrue(click(selenium,btnSaveRestrictedUser),"Could not click the Save button",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);

		//assertTrue(selenium.isTextPresent("regexpi:Restricted Users"), "Could not find text Restricted Users", selenium, ClassName, MethodName);

		return true;
	}
	
	public boolean goToRestrictedUsers(Selenium selenium) throws IOException {		

		assertTrue(click(selenium, lnkPatientOption),"Could not click the Patient Options link",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);		
		assertTrue(isElementPresent(selenium, lnkRestrictChart),"Could not find the Restrict Chart link",selenium,ClassName,MethodName);
		assertTrue(click(selenium,lnkRestrictChart),"Could not click the Restrict Chart link",selenium,ClassName,MethodName);

		return true;

	}
	   //PreventiveCare
	public boolean goToManageCareAlertsScreen(Selenium selenium) throws IOException {
		boolean result = false;
		
		assertTrue(isElementPresent(selenium, lnkPatientOption),"Could not find Patient Option link.", selenium , ClassName, MethodName);
		if(selenium.isConfirmationPresent()){
			System.out.println(selenium.getConfirmation());
			//Assert.assertEquals(selenium.getConfirmation(), "You are leaving a page with unsaved items. If you choose to continue, the changes will not be saved. Click OK to continue, or Cancel to stay on this page.","Navigation confirmation Message is not displayed");
			selenium.chooseOkOnNextConfirmation();
			}
		assertTrue(click(selenium, lnkPatientOption),"Could not click Patient Option link.", selenium , ClassName, MethodName);
		
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkManageCareAlerts),"Could not click Manage Care Alerts link.", selenium , ClassName, MethodName);
		waitForPageLoad(selenium);
		if (selenium.isTextPresent("Manage Care Alerts")) {
			System.out.println("Navigated to Manage Care Alerts page");
			result = true;
			return result;
		}else {
			System.out.println("Could not find text - Manage Care Alerts");
			result = false;
			return result;
		}
	}
	
	public int getCareAlertIndex(Selenium selenium, ChartPreVisitLib careData) {
		int index = -1;
		if ( careData.alertName.equalsIgnoreCase("Medication Reconciliation") ) {
			index = 1;
		}else if(careData.alertName.equalsIgnoreCase("Flu shot")) {
			index = 2;
		}else if(careData.alertName.equalsIgnoreCase("Fecal Occult Blood Test")) {
			index = 3;
		}else if(careData.alertName.equalsIgnoreCase("Pap Smear ")) {
			index = 4;
		}else if(careData.alertName.equalsIgnoreCase("Mammogram")) {
			index = 5;
		}else if(careData.alertName.equalsIgnoreCase("Child Immunization")) {
			index = 6;					
		}else {
			System.out.println("Invalid Alert name supplied in test data. Alert name: " +careData.alertName);
		}		
		
		return index;
	}

	public boolean isCareAlertPresentInPatientSummary(Selenium selenium, String alertName,  ChartPreVisitLib careData) throws IOException {
		boolean found = false;
		alertName = careData.alertName;
		
		searchPatientNexiaForProviderHomePage(selenium,careData.patientId);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, lnkPatientOption),"Could not click Patient Option link.", selenium , ClassName, MethodName);
		
		if(! isElementPresent(selenium, lnkRegPatientOption) ) {
			assertTrue(click(selenium,lnkPatientChartView),"Could not click View Patient Chart link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		
		assertTrue(click(selenium,lnkSummary),"Could not click Summary Tab",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
				
		int n = selenium.getXpathCount(lblCareAlerts).intValue();
		for (int i = 1; i <= n; i++) {
			String alertText = getText(selenium, lblCareAlerts + "[" +i+ "]" );
			if ( alertText.toLowerCase().contains(alertName.toLowerCase()) ) {
				System.out.println("Alert " +alertName+ " found in Patient Summary");
				found = true;
				break;
			}
		}		
		
		return found;
	}


public boolean navigateToAutomatedRecallListsPage(Selenium selenium) throws IOException {
	assertTrue(click(selenium, lnkQuickActions),"Could not click Quick Actions link.", selenium , ClassName, MethodName);
	assertTrue(click(selenium, lnkClinicalList ),"Could not click Clinical Lists link.", selenium , ClassName, MethodName);
	waitForPageLoad(selenium);			
	assertTrue(click(selenium, lnkClinicalPatientList),"Could not click Clinical Patient List link.", selenium , ClassName, MethodName);			
	assertTrue(click(selenium, lnkClinicalPatientList),"Could not click Clinical Patient List link.", selenium , ClassName, MethodName);
	waitForPageLoad(selenium);
	
	if(selenium.isTextPresent("system automated recall lists provided")) {
		return true;
	}else {
		System.out.println("Not able to navigate to Automated Recall Lists page");
		return false;
	}
	
}

public int getTableRowIndexWithTextInColumn(Selenium selenium, String  tableXpath, String textToFind, int columnIndex) {
	int rowIndex = -1;
	int rowCount;
	String tableCellText;
	String tableRows = tableXpath + "/tbody/tr";
	try {
		rowCount = selenium.getXpathCount(tableRows).intValue();
		for (int i = 1; i <= rowCount; i++) {
			tableCellText = selenium.getTable(tableXpath +"." +i+ "." +columnIndex);
			if (tableCellText.toLowerCase().contains(textToFind.toLowerCase())) {				
				System.out.println("Text - " +textToFind+ " found in row with index:" +i);
				rowIndex = i;
				break;
			}
		}
		
	} catch (Exception e) {
		System.out.println("Error occured while searching text in a table column");
		System.out.println(e.getMessage());
		rowIndex = -1;
	}
			
	return rowIndex;
}
public boolean setNeverRecallAlert(Selenium selenium, String userAccount, ChartPreVisitLib careData) throws IOException {
	
	boolean result = false;
	int index = getCareAlertIndex(selenium, careData);
	
	String rdoNeverRecallButton = rdoNeverRecallButtons + "[" +index+ "]";
	String lnkEditRemovalReason = lnkEditRemovalReasons + "[" +index+ "]" ;

	// Advanced search with Patient ID
	searchPatientNexiaForProviderHomePage(selenium,careData.patientId);
	waitForPageLoad(selenium);
	
	//Go to Manage Care Alerts screen 
	assertTrue(goToManageCareAlertsScreen(selenium),"Could not navigate Manage Care Alerts screen", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	
	//Make all Automated Recall radio buttons are selected
	int n = (Integer) selenium.getXpathCount(rdoAutomatedRecallButtons);
	for (int i = 1; i <= n; i++) {
		String rdoAutomatedRecallButton = rdoAutomatedRecallButtons + "[" +i+ "]";
		assertTrue(click(selenium,rdoAutomatedRecallButton),"Could not check Automated Recall radio button. Index - " +i, selenium , ClassName, MethodName);
		waitForPageLoad(selenium);
	}
		
	// Click Never Recall Radio button 
	assertTrue(click(selenium, rdoNeverRecallButton),"Could not click Never Recall radio button.", selenium , ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(selenium.isTextPresent("Reason:"),"Could not find text 'Reason:'" , selenium , ClassName, MethodName);
	
	// Click Edit Removal Reason link 
	assertTrue(click(selenium, lnkEditRemovalReason),"Could not click Edit Never Recall Reason link.", selenium , ClassName, MethodName);
	waitForPageLoad(selenium);
	
	//Type removal reason 
	assertTrue(type(selenium,txtRemovalReason,careData.reason),"Could not type Removal reason.", selenium , ClassName, MethodName);
	
	//Click Save on removal reason popup  
	assertTrue(click(selenium, btnSaveRemovalReason),"Could not click Save button in the popup.", selenium , ClassName, MethodName);
	waitForPageLoad(selenium);
	
	//Verify that removal reason appeared
	assertTrue(selenium.isTextPresent(careData.reason),"Could not find text for removal reason - " +careData.reason , selenium , ClassName, MethodName);

	//Click on Save button in the Manage Care Alert Page
	assertTrue(click(selenium, btnSaveCareAlerts),"Could not click Save button.", selenium , ClassName, MethodName);
	waitForPageLoad(selenium);

	//Verify id the Alerts have been save appropriately
	assertTrue(goToManageCareAlertsScreen(selenium),"Could not navigate Manage Care Alerts screen", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(selenium.isChecked(rdoNeverRecallButton),"Never Recall radio button is selected.", selenium , ClassName, MethodName);
	assertTrue(selenium.isTextPresent(careData.reason),"Could not find text for removal reason - " +careData.reason , selenium , ClassName, MethodName);	
	result = true;
	
	return result;
	
}

public boolean setForceRecallAlert(Selenium selenium, String userAccount, ChartPreVisitLib careData) throws IOException {
	boolean result = false;
	int index = getCareAlertIndex(selenium, careData);
	
	String rdoForceRecallButton = rdoForceRecallButtons + "[" +index+ "]";
	String lnkEditForceReason = lnkEditForceReasons + "[" +index+ "]";
	
	//Advanced search with Patient ID
	searchPatientNexiaForProviderHomePage(selenium,careData.patientId);
	waitForPageLoad(selenium);
	
	//Go to Manage Care Alerts screen 
	assertTrue(goToManageCareAlertsScreen(selenium),"Could not navigate Manage Care Alerts screen", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	
	//	Make all Automated Recall radio buttons are selected
	int n = (Integer) selenium.getXpathCount(rdoAutomatedRecallButtons);
	for (int i = 1; i <= n; i++) {
		String rdoAutomatedRecallButton = rdoAutomatedRecallButtons + "[" +i+ "]";
		assertTrue(click(selenium,rdoAutomatedRecallButton),"Could not check Automated Recall radio button. Index - " +i, selenium , ClassName, MethodName);
		waitForPageLoad(selenium);
	}
		
	//Click Force Recall Radio button
	assertTrue(click(selenium, rdoForceRecallButton),"Could not click Force Recall radio button.", selenium , ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(selenium.isTextPresent("Reason:"),"Could not find text 'Reason:'" , selenium , ClassName, MethodName);
	
	//Click Edit Force Reason link 
	if(careData.testCaseId.equals("TC_PC_012"))
	{
	assertTrue(click(selenium, lnkEditForceReasonsM),"Could not click Edit Force Recall Reason link.", selenium , ClassName, MethodName);
	waitForPageLoad(selenium);
	}
	else
	{
		assertTrue(click(selenium, lnkEditForceReason),"Could not click Edit Force Recall Reason link.", selenium , ClassName, MethodName);
		waitForPageLoad(selenium);
	}
	waitForPageLoad(selenium);
	
	//Type recall reason and other data								
	assertTrue(selectValueFromAjaxList(selenium, ajxRecallFrequency, careData.recallFrequency),"Could not set Recall Frequency.", selenium , ClassName, MethodName);
	waitForPageLoad(selenium);
	careData.recallCount = "" + (int)Float.parseFloat(careData.recallCount);
	assertTrue(selectValueFromAjaxList(selenium, ajxRecallCount, careData.recallCount),"Could not set Recall time count.", selenium , ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(selectValueFromAjaxList(selenium, ajxRecallUnit, careData.recallUnit ),"Could not set Recall time unit.", selenium , ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(type(selenium,txtRecallReason,careData.reason),"Could not type Recall reason.", selenium , ClassName, MethodName);
	
	//Click Save on popup 
	assertTrue(click(selenium, btnSaveRecallReason),"Could not click Save button in the popup.", selenium , ClassName, MethodName);
	waitForPageLoad(selenium);
	
	//Verify that reason appeared
	assertTrue(selenium.isTextPresent(careData.reason),"Could not find text for recall reason - " +careData.reason , selenium , ClassName, MethodName);

	//Click on Save button in the Manage Care Alert Page
	assertTrue(click(selenium, btnSaveCareAlerts),"Could not click Save button.", selenium , ClassName, MethodName);
	waitForPageLoad(selenium);

	//Verify id the Alerts have been save appropriately
	assertTrue(goToManageCareAlertsScreen(selenium),"Could not navigate Manage Care Alerts screen", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(selenium.isChecked(rdoForceRecallButton),"Never Recall radio button is selected.", selenium , ClassName, MethodName);
	
	result = true;
	return result;
}
//signing authority	
public boolean selectSigningAuthoriryForInnerFeature(Selenium selenium, String innerFeatureName, String outerFeatureName) throws IOException {
	String chkSigningAuthority = "/tbody/tr/td/div/div/div[6]/div/span/input";

	int innerFeatureIndex = -1;
	boolean result = false;

	innerFeatureIndex = getInnerFeatureindex(selenium, innerFeatureName);
	if (innerFeatureIndex == -1) {
		fail("Requested feature " +innerFeatureName+ " not found");
		result = false;
		return result;
	}		
	String chkReqSignAuthoCB = "xpath=((" +innerTables+ ")[" +innerFeatureIndex+ "]" +chkSigningAuthority + ")";		

	assertTrue( check(selenium, chkReqSignAuthoCB), "Could not select CheckBox with location: "+chkReqSignAuthoCB, selenium, ClassName, MethodName);
	result = true;
	return result;
}

public boolean setFullAccessRadioButtonForInnerFeature(Selenium selenium, String innerFeatureName, String outerFeatureName) throws IOException {

	String radFullAccess = "/tbody/tr/td/div/div/div[5]/div/span/input";
	int innerFeatureIndex = -1;
	String radReqFullAccessRB;
	boolean result = false;

	innerFeatureIndex = getInnerFeatureindex(selenium, innerFeatureName);
	if (innerFeatureIndex == -1) {
		System.out.println("Requested feature " +innerFeatureName+ " not found");
		result = false;
	}
	radReqFullAccessRB = "xpath=((" +innerTables+ ")[" +innerFeatureIndex+ "]" +radFullAccess + ")";
	assertTrue(click(selenium, radReqFullAccessRB), "Could not click Full Access radio button with locator: " +radReqFullAccessRB, selenium, ClassName, MethodName);
	result = true;

	return result;

}

public boolean setLimitedAccessRadioButtonForInnerFeature(Selenium selenium, String innerFeatureName, String outerFeatureName) throws IOException {
	
	String radFullAccess = "/tbody/tr/td/div/div/div[4]/div/span/input";
	int innerFeatureIndex = -1;
	String radReqFullAccessRB;
	boolean result = false;

	innerFeatureIndex = getInnerFeatureindex(selenium, innerFeatureName);
	if (innerFeatureIndex == -1) {
		System.out.println("Requested feature " +innerFeatureName+ " not found");
		result = false;
	}
	radReqFullAccessRB = "xpath=((" +innerTables+ ")[" +innerFeatureIndex+ "]" +radFullAccess + ")";
	assertTrue(click(selenium, radReqFullAccessRB), "Could not click Limited Access radio button with locator: " +radReqFullAccessRB, selenium, ClassName, MethodName);
	result = true;

	return result;

}

public boolean isSigningAuthoriryDisabledForInnerFeature(Selenium selenium, String innerFeatureName, String outerFeatureName) {
	String chkSigningAuthority = "/tbody/tr/td/div/div/div[6]/div/span/input";

	int innerFeatureIndex = -1;
	boolean result = false;

	innerFeatureIndex = getInnerFeatureindex(selenium, innerFeatureName);
	if (innerFeatureIndex == -1) {
		fail("Requested feature " +innerFeatureName+ " not found");
		result = false;
		return result;
	}		
	String chkReqSignAuthoCB = "xpath=((" +innerTables+ ")[" +innerFeatureIndex+ "]" +chkSigningAuthority + ")";

	result = selenium.isEditable(chkReqSignAuthoCB);
	return !result;
}

public boolean setViewOnlyRadioButtonForInnerFeature(Selenium selenium, String innerFeatureName, String outerFeatureName) throws IOException {		
	String radViewOnlys = "/tbody/tr/td/div/div/div[3]/div/span/input";

	int innerFeatureIndex = -1;
	String radReqViewOnlyRB;
	boolean result = false;

	innerFeatureIndex = getInnerFeatureindex(selenium, innerFeatureName);
	if (innerFeatureIndex == -1) {
		System.out.println("Requested feature " +innerFeatureName+ " not found");
		result = false;
		return result;
	}		
	radReqViewOnlyRB = "xpath=((" +innerTables+ ")[" +innerFeatureIndex+ "]" +radViewOnlys + ")";		
	assertTrue(click(selenium, radReqViewOnlyRB), "Could not click View Only radio button with locator: " +radReqViewOnlyRB, selenium, ClassName, MethodName);
	result = true;

	return result;
}

public int getInnerFeatureindex(Selenium selenium, String innerFeatureName) {		
	String lblFeatures = "//*[@class='padding-right-20 padding-left-30']";
	String lblFeature;
	String currentFeature;
	int rowIndex = -1;

	int n = (Integer) selenium.getXpathCount(lblFeatures);
	for (int i = 1; i <= n; i++) {
		lblFeature = "xpath=(" +lblFeatures+ ")[" +i+ "]";
		currentFeature = getText(selenium, lblFeature);
		if (currentFeature.equalsIgnoreCase(innerFeatureName) ) {
			rowIndex = i;
			break;
		}
	}
	return rowIndex;
}

public boolean navigateToEditUserRolePage(Selenium selenium, String userRoleToEdit) throws IOException {
	boolean result = true;


	assertTrue(click(selenium,lnkSettings),"Could not click settings link", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(click(selenium,lnkSecuritySettings),"Could not click System Settings link", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(click(selenium,lnkUserRole),"Could not click the User Role link.", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);

	while(getText(selenium, lnkUserRoleMore).contains("Show more...")){
		click(selenium,lnkUserRoleMore);
		waitForPageLoad(selenium);
	}
	waitForPageLoad(selenium);

	//  Select the user Role to edit
	int count = 1;
	int counter = 1;
	while(isElementPresent(selenium,"xpath=(//div[starts-with(@id,'collapsableTitle')])["+count+"]")){
		if(getText(selenium,"xpath=(//div[starts-with(@id,'collapsableTitle')])["+count+"]").contains(userRoleToEdit)){
			counter = count;
			break;
		}else
			count++;
	}
	assertTrue(click(selenium, "xpath=(//a[starts-with(@id,'Edit')])["+counter+"]"),"Could not click edit button of created User Role", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);

	if ( !selenium.isTextPresent("Edit User Role") ) {
		System.out.println("Could not find text Edit User Role in page");
		result = false;
		return result;
	}

	return result;

}
public boolean navigateToFileDocumentPage(Selenium selenium, String filePath, String patientID, String documentType) throws IOException {
	boolean result;
	String file = null;
	patientID = patientID.trim();
	
	
	//Set full access for File reports for current user role
	String entireUserName = getText(selenium, vfyUserName );
	String[] arrEntireUserName = entireUserName.split(",");
	String currentUserRole = arrEntireUserName[1];
		
	assertTrue(setFileReportAccessForUserRole(selenium, currentUserRole, "Full Access"), "Could not set Full Access for File Reports", selenium, ClassName, MethodName);
		
	if (filePath=="") {
		File dir1 = new File(".");
		String strBasePath = null;			
		String xmlName = "Medica_Report.doc";
		String sectionName = "chartprevisit";
		strBasePath = dir1.getCanonicalPath();
		file = strBasePath + File.separator + "src" + File.separator
				+ "main" + File.separator + "resources" + File.separator
				+ "nexia" + File.separator + "testdata" + File.separator
				+ sectionName + File.separator + xmlName;			
	} else {
		file = filePath;
	}

		assertTrue(click(selenium, lnkQuickActions),"Could not click Quick Actions link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkFileDocu), "Could not click link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//Check if Error dialog present
		if(isElementPresent(selenium,btnErrorClose))
		{
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnErrorClose),"Could not click Close button in error dialog box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}			
		
		assertTrue(click(selenium, btnUploadFile),"Could not click upload btn", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, "docManagementFileUpload-file-upload", file),"Could not upload document from path: " +file, selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,btnErrorClose))
		{
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnErrorClose),"Could not click Close button in error dialog box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}	
		assertTrue(click(selenium, btnFile),"Could not click File button btn", selenium, ClassName,	MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,btnErrorClose))
		{
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnErrorClose),"Could not click Close button in error dialog box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}	
		assertTrue(type(selenium,"xpath=(//input[@id='searchPatientBox'])[2]",	patientID),"Could not type patient id",selenium, ClassName, MethodName);

		selenium.clickAt("xpath=(//input[@id='searchPatientBox'])[2]", "");
		selenium.focus("xpath=(//input[@id='searchPatientBox'])[2]");
		selenium.fireEvent("xpath=(//input[@id='searchPatientBox'])[2]","keypress");
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		//selenium.keyPress(txtPatientBox, "\\9");
		waitForElement(selenium, lblPatientResult, 30000);
		assertTrue(	selenium.isElementPresent("css=#patientPanel > #patientInfoWidget"),
				"Search Results are not displayed for the patient with ID :-" +patientID,selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,"css=#patientPanel > #patientInfoWidget")
				.toLowerCase(new java.util.Locale("en", "US")).trim()
				.contains(patientID.toLowerCase(new java.util.Locale("en", "US"))),"Could not get the text value",selenium, ClassName, MethodName);

		waitForPageLoad(selenium);
		click(selenium, lblPatientResult);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium, ajxDocuType,documentType),
						"Could not select Document type", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);					

		if( !isElementVisible(selenium, ajxRProvider)){
			result = false;
		} else {
			result = true;
		}
		return result;
}
public boolean fillMandatoryCorrespondenceReportForFiling(Selenium selenium, ChartPreVisitLib accessData) throws IOException {
	
	assertTrue(selectValueFromAjaxList(selenium, ajxReport, accessData.corrsReportType),"Could not select correspondence Reort Type.", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(selectValueFromAjaxList(selenium, ajxRProvider, accessData.rProvider),"Could not selected Receiving Provider.", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(type(selenium, "sender", accessData.sender),"Could not type sender.", selenium, ClassName, MethodName);
	return true;
}

public boolean fillMandatoryDIReportForFiling(Selenium selenium, ChartPreVisitLib accessData) throws IOException {
	String popupCloseButton = "//a[@class='close-popup-x-monograph close-help-about-popup']";
	if( isElementPresent(selenium, popupCloseButton) ) {
		assertTrue(click(selenium, popupCloseButton),"Could not close popup button.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	}
	
	assertTrue(selectValueFromAjaxList(selenium, ajxReport, accessData.corrsReportType),"Could not select correspondence Reort Type.", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(selectValueFromAjaxList(selenium, ajxRProvider, accessData.rProvider),"Could not select Receiving Provider.", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);		
	assertTrue(type(selenium, txtFacility, accessData.facilityName),"Could not type facility.", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);

	SimpleDateFormat f = new SimpleDateFormat ("dd/MM/yyyy");
	String currentDate = f.format(new Date());

	assertTrue(enterDate(selenium, txtOrderDate, currentDate ),"Could not type date.", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(enterDate(selenium, txtReceivedDate, currentDate ),"Could not type date.", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);

assertTrue(selectValueFromAjaxList(selenium, txtOrderingProviderSearchBox, accessData.oProvider),"Could not select Ordering Provider.", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(enterDate(selenium, txtServiceDate, currentDate ),"Could not type date.", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	return true;
}
public boolean fillMandatoryLabReportForFiling(Selenium selenium, ChartPreVisitLib accessData, String account) throws IOException {
	
	assertTrue(selectValueFromAjaxList(selenium, ajxReport, accessData.corrsReportType),"Could not select correspondence Reort Type.", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(selectValueFromAjaxList(selenium, ajxRProvider, accessData.rProvider),"Could not selected Receiving Provider.", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(selectValueFromAjaxList(selenium, ajxOProvider, accessData.oProvider),"Could not select Ordering Provider.", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	if(account.equals(CAAccount)){
		assertTrue(selectValueFromAjaxList(selenium, ajxLabName, accessData.labNameCA),"Could not select lab.", selenium, ClassName, MethodName);
	}else{
		assertTrue(selectValueFromAjaxList(selenium, ajxLabName, accessData.labName),"Could not select lab.", selenium, ClassName, MethodName);
	}
	waitForPageLoad(selenium);
	
	SimpleDateFormat f = new SimpleDateFormat ("dd/MM/yyyy");
	String currentDate = f.format(new Date());
	assertTrue(enterDate(selenium, elementCdate, currentDate ),"Could not type date.", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);		
	assertTrue(selectValueFromAjaxList(selenium, ajxLabTestName, accessData.testName),"Could not select Test.", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(type(selenium, elementResult, accessData.result),"Could not type results",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	return true;
}




public boolean setFileReportAccessForUserRole(Selenium selenium, String currentUserRole,String accessLevel) throws IOException {
	boolean result = false;
	try {
		//Go to Security Settings and navigate to User Role			
		assertTrue(navigateToEditUserRolePage(selenium, currentUserRole), "Could not edit user role " +currentUserRole , selenium, ClassName, MethodName);		

		//set File Report permission
		assertTrue(click(selenium, lblClinicalCategory),"Could not click Clinical category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,ChkFullAccess), "Could not select Full Access Radio button for File Reports",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		//Click Save button
		assertTrue(click(selenium, btnsaveProvider), "Could not click Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		
		
	} catch (Exception e) {
		e.printStackTrace();
		result = false;
	}

	if(selenium.isTextPresent("Edit User Role")) {
		System.out.println("Not able to edit user role:" +currentUserRole);
		result = false;
	}else{
		System.out.println("User role saved");
		result = true;
	}
	return result;
	
}


public boolean CreateTaskForCorresReport(Selenium selenium,ChartPreVisitLib CorresData,String userAccount) throws IOException
{
	try
	{
		
		
		String date = null;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("MMddHHmm");
		date = DateFormat.format(cal.getTime());		
		ChartPreVisitLib PatienttaskData = new ChartPreVisitLib();
		PatienttaskData.workSheetName = "CreatePatientTask";
		PatienttaskData.testCaseId = "TC_CCD_003";
		PatienttaskData.fetchChartPreVisitTestData();	
		PatienttaskData.Instruction=PatienttaskData.Instruction+date;	
		CorresData.TaskInst=PatienttaskData.Instruction;	

		 assertTrue(selectValueFromAjaxList(selenium,Tasksuggestbox,PatienttaskData.TaskType),"Could not select the task type", selenium , ClassName, MethodName);
		 assertTrue(selectValueFromAjaxList(selenium, ajxAssignToChartDis,CorresData.switchRole),"Could not select Requested By", selenium,ClassName, MethodName);
		 assertTrue(type(selenium, txtTaskName,PatienttaskData.TaskType),"Could not type Instruction", selenium, ClassName,MethodName);
		 assertTrue(type(selenium, txtChartDLSInst,PatienttaskData.Instruction),"Could not type Instruction", selenium, ClassName,MethodName);
		 assertTrue(selectValueFromAjaxList(selenium, ajxDueInCount,PatienttaskData.DueInCount),"Could not select Requested By", selenium,ClassName, MethodName);
		 assertTrue(selectValueFromAjaxList(selenium, ajxDueInUnit,PatienttaskData.DueInUnit),"Could not select Requested By", selenium,ClassName, MethodName);
		 assertTrue(click(selenium, btnSaveTask),"Could not Click save button", selenium,ClassName, MethodName); 
		waitForPageLoad(selenium);
		waitForPageLoad(selenium); 
		 
	}
	
	catch(Exception e)
	{
		assertTrue(false,"Creation failed", selenium, ClassName, MethodName);	
	}
	
	return true;
}

/**
 * Function to Verify Added Details in Correspondence Report under Correspondence Tab
 * 
 * 
 * @param selenium
 * @param CorresData
 * @param userAccount
 * @return
 */
public boolean VerifyCorrespondenceReportInTab(Selenium selenium,ChartPreVisitLib CorresData, String userAccount)
{
	
	try {
		String providerNameTemp = getText(selenium, lnkTopMenu);
		String pName = providerNameTemp.replaceAll(", "+ CorresData.switchRole, "");					
			String date = null;  
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy ");
				date=DateFormat.format(cal.getTime());

			}else{
				Calendar cal1=Calendar.getInstance();
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
				date=DateForma1t.format(cal1.getTime());		
			}		
				
	String ReportData=CorresData.ReportType+" Signed";		
	String VerifyText="report sent by "+CorresData.Sender+" to Dr."+pName+" on "+date.trim();	
	assertTrue(getText(selenium,lblUnsignedCorresReport).toLowerCase(new java.util.Locale("en","US")).trim().contains(ReportData.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find the added details", selenium, ClassName,MethodName);
		
		//assertTrue(getText(selenium,lblUnsignedCorresReport).toLowerCase(new java.util.Locale("en","US")).trim().contains(VerifyText.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find the added details", selenium, ClassName,MethodName);
		
		return true;	
	}	
	
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;		
}


/**
 * Function to Verify Added Details in Correspondence Report under Correspondence Tab
 * 
 * 
 * @param selenium
 * @param CorresData
 * @param userAccount
 * @return
 */
public boolean VerifySignedCorrespondenceReportInTab(Selenium selenium,ChartPreVisitLib CorresData, String userAccount)
{
	
	try {
		String providerNameTemp = getText(selenium, lnkTopMenu);
		String pName = providerNameTemp.replaceAll(", "+ CorresData.switchRole, "");					
			String date = null;  
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy ");
				date=DateFormat.format(cal.getTime());

			}else{
				Calendar cal1=Calendar.getInstance();
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
				date=DateForma1t.format(cal1.getTime());		
			}		
		String ReportData=CorresData.ReportType+" Signed";		
		
		String VerifyText="report sent by "+CorresData.Sender+" to Dr."+pName+" on "+date.trim();	
		
		String SignedDetails="Signed by Dr."+pName+" at";
		
		assertTrue(getText(selenium,lblFirstCorresReport).toLowerCase(new java.util.Locale("en","US")).trim().contains(ReportData.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find the added details", selenium, ClassName,MethodName);
		
		assertTrue(getText(selenium,lblFirstCorresReport).toLowerCase(new java.util.Locale("en","US")).trim().contains(VerifyText.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find the added details", selenium, ClassName,MethodName);
		
		assertTrue(getText(selenium,lblFirstCorresReport).toLowerCase(new java.util.Locale("en","US")).trim().contains(SignedDetails.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not find Statement for signoff", selenium, ClassName,MethodName);
		
		return true;	
	}	
	
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;		
}
/**
 * Create a correspondence report with past date 
 * @param selenium
 * @param templateName
 * @return
 * @throws IOException
 */
	/**
	 * Create a New Correspondence Report					
	 * 
	 * @since June 23, 2014
	 */
	public boolean CreateCorrespondenceReportWithPastDate(Selenium selenium,ChartPreVisitLib medicationData,String userAccount) throws IOException
	{
		try {
		
			String date = null;  
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				  cal.add(Calendar.DATE, -1);
				    cal.add(Calendar.MONTH, -1);
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat.format(cal.getTime());

			}else{
				Calendar cal1=Calendar.getInstance();
				  cal1.add(Calendar.DATE, -1);
				    cal1.add(Calendar.MONTH, -1);
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
				date=DateForma1t.format(cal1.getTime());		
			}
			Calendar cal=Calendar.getInstance();
			
			SimpleDateFormat DateFormat1=new SimpleDateFormat("msH");
			String date1=DateFormat1.format(cal.getTime());
			medicationData.AccessionNumber=date1;			
			File dir1 = new File(".");
			String strBasePath = null;
			String file = null;
			String xmlName = "Medica_Report.doc";
			String sectionName = "chartprevisit";
			strBasePath = dir1.getCanonicalPath();
			file = strBasePath + File.separator + "src" + File.separator+ "main" + File.separator + "resources" + File.separator+ "nexia" + File.separator + "testdata" + File.separator+ sectionName + File.separator + xmlName;
			waitForPageLoad(selenium);
			String providerNameTemp = getText(selenium, lnkTopMenu);
			String pName = providerNameTemp.replaceAll(", "
					+ medicationData.switchRole, "");
			String tempArray[] = pName.split(" ");
			String providerName = tempArray[1] + ", " + tempArray[0];
			medicationData.Receivingprovider = providerName;
			assertTrue(click(selenium, btnUploadFile),		"Could not click upload btn", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtBrowseFile, file),	"Could not select Docu type", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			Robot robot = null;
			robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			assertTrue(click(selenium, btnFile),"Could not click File button btn", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtSearchFileToPatient,medicationData.patientId),"Could not type patient id",selenium, ClassName, MethodName);
			
			assertTrue(clickAt(selenium,txtSearchFileToPatient, ""),"Could not perform click At",selenium, ClassName, MethodName);
			assertTrue(focus(selenium,txtSearchFileToPatient),"Could not perform focus",selenium, ClassName, MethodName);
			assertTrue(fireEvent(selenium,txtSearchFileToPatient,"keypress"),"Could not perform fireevent",selenium, ClassName, MethodName);			
			assertTrue(keyPress(selenium,txtPatientBox, "\\9"),"Could not perform keypress",selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
		
			waitForElement(selenium, txtSearchFileToPatient, 30000);
			assertTrue(isElementPresent(selenium,txtSearchFileToPatient),"Search Results are not displayed for the patient with ID :-"+ medicationData.patientId,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(getText(selenium,patientInfoWid1).toLowerCase(new java.util.Locale("en", "US")).trim().contains(medicationData.patientId.trim().toLowerCase(new java.util.Locale("en", "US"))),"Could not get the text value",selenium, ClassName, MethodName);
			//assertTrue(getText(selenium,lblPatientResult).contains(patientID));
			waitForPageLoad(selenium);
			assertTrue(click(selenium, patientInfoWid1),"Could not select the patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium, ajxDocuType,medicationData.DocumentType),		"Could not select Docu type", selenium, ClassName,	MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, elementaccNumberforCorres,medicationData.AccessionNumber),"Could not  type Accession number", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);			 
			assertTrue(selectValueFromAjaxList(selenium, ajxReport,medicationData.ReportType), "Could not select Docu type",	selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(enterDate(selenium, txtServiceDate1, date ),"Could not type date.", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(enterDate(selenium, txtReceivingDate, date ),"Could not type date.", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(selectValueFromAjaxList(selenium,ajxRProvider,medicationData.Receivingprovider), "Could not select Docu type",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtSender,medicationData.Sender),"Could not select sender", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium, ajxOProvider,medicationData.Receivingprovider), "Could not select ordering provider ",	selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			assertTrue(selectValueFromAjaxList(selenium, ajxDisgnosis,medicationData.Diagnosis), "Could not select diagonosis",	selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(type(selenium, txtreportComments,medicationData.Comments),"Could not type report comment", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			assertTrue(click(selenium, btnSaveNext),"Could not click File button btn", selenium, ClassName,MethodName);		
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium, btnSaveNext),"Could not click File button btn", selenium, ClassName,MethodName);
						
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail(e.getMessage());
		}
		return true;
		
	}



	/**
	 * Create a correspondence report with past date 
	 * @param selenium
	 * @param templateName
	 * @return
	 * @throws IOException
	 */
		/**
		 * Create a New Correspondence Report					
		 * 
		 * @since June 23, 2014
		 */
		public boolean CreateCorrespondenceReportWithMandatDetails(Selenium selenium,ChartPreVisitLib medicationData,String userAccount) throws IOException
		{
			try {
			
				String date = null;  
				if(userAccount.equals(CAAccount)){
					Calendar cal=Calendar.getInstance();
					  cal.add(Calendar.DATE, -1);
					    cal.add(Calendar.MONTH, -1);
					SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
					date=DateFormat.format(cal.getTime());

				}else{
					Calendar cal1=Calendar.getInstance();
					  cal1.add(Calendar.DATE, -1);
					    cal1.add(Calendar.MONTH, -1);
					SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
					date=DateForma1t.format(cal1.getTime());		
				}
				Calendar cal=Calendar.getInstance();
				
				SimpleDateFormat DateFormat1=new SimpleDateFormat("msH");
				String date1=DateFormat1.format(cal.getTime());
				medicationData.AccessionNumber=date1;			
				File dir1 = new File(".");
				String strBasePath = null;
				String file = null;
				String xmlName = "Medica_Report.doc";
				String sectionName = "chartprevisit";
				strBasePath = dir1.getCanonicalPath();
				file = strBasePath + File.separator + "src" + File.separator+ "main" + File.separator + "resources" + File.separator+ "nexia" + File.separator + "testdata" + File.separator+ sectionName + File.separator + xmlName;
				waitForPageLoad(selenium);
				String providerNameTemp = getText(selenium, lnkTopMenu);
				String pName = providerNameTemp.replaceAll(", "
						+ medicationData.switchRole, "");
				String tempArray[] = pName.split(" ");
				String providerName = tempArray[1] + ", " + tempArray[0];
				medicationData.Receivingprovider = providerName;
				assertTrue(click(selenium, btnUploadFile),		"Could not click upload btn", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtBrowseFile, file),	"Could not select Docu type", selenium, ClassName,	MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				Robot robot = null;
				robot = new Robot();
				Thread.sleep(5000);
				robot.keyPress(KeyEvent.VK_ESCAPE); 
				assertTrue(click(selenium, btnFile),"Could not click File button btn", selenium, ClassName,	MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtSearchFileToPatient,medicationData.patientId),"Could not type patient id",selenium, ClassName, MethodName);
				
				assertTrue(clickAt(selenium,txtSearchFileToPatient, ""),"Could not perform click At",selenium, ClassName, MethodName);
				assertTrue(focus(selenium,txtSearchFileToPatient),"Could not perform focus",selenium, ClassName, MethodName);
				assertTrue(fireEvent(selenium,txtSearchFileToPatient,"keypress"),"Could not perform fireevent",selenium, ClassName, MethodName);			
				assertTrue(keyPress(selenium,txtPatientBox, "\\9"),"Could not perform keypress",selenium, ClassName, MethodName);
				
				waitForElement(selenium, txtSearchFileToPatient, 30000);
				assertTrue(isElementPresent(selenium,txtSearchFileToPatient),"Search Results are not displayed for the patient with ID :-"+ medicationData.patientId,selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(getText(selenium,txtpatient).toLowerCase(new java.util.Locale("en", "US")).trim().contains(medicationData.patientId.trim().toLowerCase(new java.util.Locale("en", "US"))),"Could not get the text value",selenium, ClassName, MethodName);
				//assertTrue(getText(selenium,lblPatientResult).contains(patientID));
				waitForPageLoad(selenium);
				assertTrue(click(selenium, txtpatient),"Could not select the patient",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(selectValueFromAjaxList(selenium, ajxDocuType,medicationData.DocumentType),		"Could not select Docu type", selenium, ClassName,	MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, elementaccNumberforCorres,medicationData.AccessionNumber),"Could not  type Accession number", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);			 
				assertTrue(selectValueFromAjaxList(selenium, ajxReport,medicationData.ReportType), "Could not select Docu type",	selenium, ClassName, MethodName);
				waitForPageLoad(selenium);						
				assertTrue(selectValueFromAjaxList(selenium,ajxRProvider,medicationData.Receivingprovider), "Could not select Docu type",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtSender,medicationData.Sender),"Could not select sender", selenium, ClassName,MethodName);
				assertTrue(type(selenium, txtreportComments,medicationData.Comments),"Could not type report comment", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);	
				waitForPageLoad(selenium);	
				assertTrue(click(selenium, btnSaveNext),"Could not click File button btn", selenium, ClassName,MethodName);		
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(!isElementPresent(selenium, btnSaveNext),"Could not click File button btn", selenium, ClassName,MethodName);
							
			} catch (Exception e) {
				// TODO: handle exception
				Assert.fail(e.getMessage());
			}
			return true;
			
		}

		/**
		 * Create a New Correspondence Report					
		 * @throws IOException 
		 * @throws AWTException 
		 * @throws InterruptedException 
		 * 
		 * @sinceNov 06,2014
		 */

public boolean CreateLabReportFromFileDocu(Selenium selenium,String userAccount,ChartPreVisitLib labData) throws IOException, AWTException, InterruptedException 
{
	String providerNameTemp = getText(selenium, lnkTopMenu);
	String pName = providerNameTemp.toLowerCase().replaceAll(", "
			+ labData.switchRole.toLowerCase(), "");
	String tempArray[] = pName.split(" ");
	String providerName = tempArray[1] + ", " + tempArray[0];

	labData.rProvider = providerName;
	File dir1 = new File(".");
	String strBasePath = null;
	String file = null;
	String xmlName = "Medica_Report.doc";
	String sectionName = "chartprevisit";
	strBasePath = dir1.getCanonicalPath();
	file = strBasePath + File.separator + "src" + File.separator+ "main" + File.separator + "resources" + File.separator+ "nexia" + File.separator + "testdata" + File.separator+ sectionName + File.separator + xmlName;
	waitForPageLoad(selenium);
	assertTrue(click(selenium, btnUploadFile),		"Could not click upload btn", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	assertTrue(type(selenium, txtBrowseFile, file),	"Could not select Docu type", selenium, ClassName,	MethodName);
	waitForPageLoad(selenium);
	waitForPageLoad(selenium);
	waitForPageLoad(selenium);
	Robot robot = null;
	robot = new Robot();
	Thread.sleep(5000);
	robot.keyPress(KeyEvent.VK_ESCAPE); 
	assertTrue(click(selenium, btnFile),"Could not click File button btn", selenium, ClassName,	MethodName);
	waitForPageLoad(selenium);
	waitForPageLoad(selenium);
	waitForPageLoad(selenium);
	assertTrue(type(selenium,txtSearchFileToPatient,labData.patientId),"Could not type patient id",selenium, ClassName, MethodName);
	
	assertTrue(clickAt(selenium,txtSearchFileToPatient, ""),"Could not perform click At",selenium, ClassName, MethodName);
	assertTrue(focus(selenium,txtSearchFileToPatient),"Could not perform focus",selenium, ClassName, MethodName);
	assertTrue(fireEvent(selenium,txtSearchFileToPatient,"keypress"),"Could not perform fireevent",selenium, ClassName, MethodName);			
	assertTrue(keyPress(selenium,txtPatientBox, "\\9"),"Could not perform keypress",selenium, ClassName, MethodName);
	
	waitForPageLoad(selenium);
	waitForPageLoad(selenium);

	waitForElement(selenium, txtSearchFileToPatient, 30000);
	assertTrue(isElementPresent(selenium,txtSearchFileToPatient),"Search Results are not displayed for the patient with ID :-"+ labData.patientId,selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(getText(selenium,patientInfoWid).toLowerCase(new java.util.Locale("en", "US")).trim().contains(labData.patientId.trim().toLowerCase(new java.util.Locale("en", "US"))),"Could not get the text value",selenium, ClassName, MethodName);
	//assertTrue(getText(selenium,lblPatientResult).contains(patientID));
	waitForPageLoad(selenium);
	assertTrue(click(selenium, patientInfoWid),"Could not select the patient",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	labData.DocumentType="Lab Report";
	assertTrue(selectValueFromAjaxList(selenium, ajxDocuType,labData.DocumentType),		"Could not select Docu type", selenium, ClassName,	MethodName);
	waitForPageLoad(selenium);
	
	Calendar cal=Calendar.getInstance();
	SimpleDateFormat DateFormat12=new SimpleDateFormat("msH");
	String date1=DateFormat12.format(cal.getTime());
	uniqueAccNumber=date1;
	assertTrue(
			type(selenium, elementaccNumber, uniqueAccNumber),
			"Could not type accession number",selenium, ClassName, MethodName);
	
	assertTrue(selectValueFromAjaxList(selenium, ajxRProvider, labData.rProvider),		"Could not select Provider", selenium, ClassName,	MethodName);

	assertTrue(selectValueFromAjaxList(selenium, ajxOProvider, labData.rProvider),		"Could not select provider", selenium, ClassName,	MethodName);

	if(userAccount.equals(CAAccount)){
		assertTrue(selectValueFromAjaxList(selenium, ajxLabName, labData.labNameCA),"Could not select select lab test", selenium, ClassName,	MethodName);
	}else
		assertTrue(selectValueFromAjaxList(selenium, ajxLabName, labData.labName),"Could not select lab test", selenium, ClassName,	MethodName);
	waitForPageLoad(selenium);
	if (userAccount.equals(CAAccount)) {
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat DateFormat1 = new SimpleDateFormat(
				"dd/MM/yyyy");
		date = DateFormat1.format(cal1.getTime());
		assertTrue(enterDate(selenium, elementCdate, date),
				"Could not enter the collrction Date;More Details:"
						+ labData.toString(),selenium, ClassName, MethodName);
		assertTrue(enterDate(selenium, elementOdate, "28/10/2014"),
				"Could not enter the Order Date;More Details:"
						+ labData.toString(),selenium, ClassName, MethodName);
		
	} else {
		Calendar cal1 = Calendar.getInstance();
		SimpleDateFormat DateFormat1 = new SimpleDateFormat(
				"MM/dd/yyyy");
		date = DateFormat1.format(cal1.getTime());
		assertTrue(enterDate(selenium, elementCdate, date),
				"Could not enter the collrction Date;More Details:"
						+ labData.toString(),selenium, ClassName, MethodName);
		assertTrue(enterDate(selenium, elementOdate, "10/28/2014"),
				"Could not enter the Order Date;More Details:"
						+ labData.toString(),selenium, ClassName, MethodName);
	}
	assertTrue(type(selenium, elementCtime, labData.cTime),
			"Could not type time",selenium, ClassName, MethodName);
	assertTrue(type(selenium, elementNotes, labData.notes),
			"Could not type notes",selenium, ClassName, MethodName);
	selectValueFromAjaxList(selenium, ajxLabTestName, labData.testName);

	assertTrue(type(selenium, elementResult, labData.result),
			"Could not type results",selenium, ClassName, MethodName);
	assertTrue(type(selenium, elementLow, labData.low),
			"Could not type low",selenium, ClassName, MethodName);
	assertTrue(type(selenium, elementHigh, labData.high),
			"Could not type high",selenium, ClassName, MethodName);
	assertTrue(type(selenium, elementUnits, labData.units),
			"Could not type units",selenium, ClassName, MethodName);
	assertTrue(type(selenium, elementComment, labData.comments),
			"Could not type comments",selenium, ClassName, MethodName);
	assertTrue(click(selenium, btnSaveNext),"Could not click File button btn", selenium, ClassName,MethodName);
	waitForPageLoad(selenium);
	return true;
}

/**
 * orderNewLabs Function to order New Labs
 * @throws IOException 
 * 
 * @since Nov 11,2014
 * 
 */
public boolean orderNewLabsWithNotify(Selenium selenium, ChartPreVisitLib orderData) throws IOException {
	
	String provider= getText(selenium, lnkTopMenu);
	String onBehalfOf= provider.replaceAll(", "+orderData.switchRole, "");
	orderData.provider = onBehalfOf;
	String providerNameTemp= getText(selenium, lnkTopMenu);
	String providerName= providerNameTemp.replaceAll( ", "+orderData.switchRole, "");
	String location = getText(selenium,lnkLocationHeader).replace("...", "") ;
	assertTrue(selectValueFromAjaxList(selenium, ajxLoaction,location),"Could not select the ajax value",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(selectValueFromAjaxList(selenium, ajxTestName,orderData.labTestName),"Could not select the ajax value",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	orderData.labTestName=selenium.getValue(ajxTestName).toString().trim();
	assertTrue(selectValueFromAjaxList(selenium, ajaxPayer,orderData.payer),"Could not select the ajax value",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(selectValueFromAjaxList(selenium, ajxLabFacility,orderData.sendTo),"Could not select the ajax value",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(selectValueFromAjaxList(selenium, ajxNotifyDuration,orderData.notifyme),"Could not select the ajax value",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);		
	assertTrue(selectValueFromAjaxList(selenium, ajxDurationUnit,orderData.notifymein),"Could not select the ajax value",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(click(selenium,chkboxUrgent),"Urgent field is missing ", selenium, ClassName, MethodName);
	assertTrue(type(selenium, txtLabComments, orderData.labTestComments1),"Could not type comments",selenium, ClassName, MethodName);
	assertTrue(click(selenium, lnkAction),"Could not click on save button",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(click(selenium, btnNewSave1),"Could not click on save button",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);

	
	return true;
	
}





public boolean SearchPatientInOrderQueue(Selenium selenium,String  PatientId ) throws IOException
{
	assertTrue(type(selenium,txtSearchBox,PatientId),"Could not type the patient name", selenium, ClassName,MethodName);		
	assertTrue(clickAt(selenium,txtSearchBox, ""),"Could not perform click At",selenium, ClassName, MethodName);
	assertTrue(focus(selenium,txtSearchBox),"Could not perform focus",selenium, ClassName, MethodName);
	assertTrue(fireEvent(selenium,txtSearchBox,"keypress"),"Could not perform fireevent",selenium, ClassName, MethodName);			
	assertTrue(keyPress(selenium,txtSearchBox, "\\13"),"Could not perform keypress",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	waitForPageLoad(selenium);
	return true;
}


/**
 * orderNewReferral Function to order New Di
 * @throws IOException 
 * 
 * @since Nov 12,, 2014
 */
public boolean orderNewReferralWithNotify(Selenium selenium,ChartPreVisitLib orderData) throws IOException {
	assertTrue(selectValueFromAjaxList(selenium, ajxSearchReferral,"a"),"Could not select the Referral provider",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	orderData.referral1=selenium.getValue(ajxSearchReferral);
	if(selenium.isChecked(chkboxUrgent))
	{
		assertTrue(click(selenium,chkboxUrgent),"Urgent field is missing ", selenium, ClassName, MethodName);
	}
		assertTrue(type(selenium, txtAuthcode, orderData.authorization),"Could not type comments",selenium, ClassName, MethodName);
		assertTrue(selectValueFromAjaxList(selenium, ajxNotifyDuration, orderData.notifyme),"Could not type notifyme",selenium, ClassName, MethodName);
		assertTrue(selectValueFromAjaxList(selenium, ajxDurationUnit, orderData.notifymein),"Could not type notifymein",selenium, ClassName, MethodName);
		assertTrue(click(selenium, btnReferral),"Could not click on save button",selenium, ClassName, MethodName);
		return true;	

}




public boolean orderNewDiWithNotify(Selenium selenium, ChartPreVisitLib orderData) throws IOException {
	String provider= getText(selenium, lnkTopMenu);
	String onBehalfOf= provider.replaceAll(", "+orderData.switchRole, "");
	String onBehalfOf1[]=onBehalfOf.split(" ");
	assertTrue(selectValueFromAjaxList(selenium,ajxProvider,onBehalfOf1[1]),"could not entre the on Behalf of details", selenium, ClassName, MethodName);
	assertTrue(selectValueFromAjaxList(selenium,ajxLoaction,orderData.location),"could not entre the on Behalf of details", selenium, ClassName, MethodName);
	selectValueFromAjaxList(selenium, ajxTestName,orderData.labTestName);
	assertTrue(type(selenium, txtComments, orderData.labTestComments1),"Could not type notifyme",selenium, ClassName, MethodName);
	assertTrue(selectValueFromAjaxList(selenium, ajxNotifyDuration, orderData.notifyme),"Could not type notifyme",selenium, ClassName, MethodName);
	assertTrue(selectValueFromAjaxList(selenium, ajxDurationUnit, orderData.notifymein),"Could not type notifymein",selenium, ClassName, MethodName);
	assertTrue(type(selenium, txtAuthorization, orderData.authorization),"Could not type comments",selenium, ClassName, MethodName);
	if(!selenium.isChecked(chkboxUrgent)){
		assertTrue(click(selenium, chkboxUrgent),"Could not click the cancel button",selenium, ClassName, MethodName);
	}
	assertTrue(click(selenium, btnDiagnosticSave),"Could not click on save button",selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	return true;
}

public boolean CreateFileNewReportForCareElement(Selenium selenium, ChartPreVisitLib labData,
		String account) throws IOException {
	String date = null;

	try {

//		String providerNameTemp = getText(selenium, lnkTopMenu);
//		String pName = providerNameTemp.toLowerCase().replaceAll(
//				", " + labData.switchRole.toLowerCase(), "");
//		String tempArray[] = pName.split(" ");
//		String providerName = tempArray[1] + ", " + tempArray[0];
//
//		labData.rProvider = providerName;
//
//		if (selenium.isConfirmationPresent()) {
//			System.out.println(selenium.getConfirmation());
//			selenium.chooseOkOnNextConfirmation();
//		}
//		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, lnkPatientOption),
				"Could not click on patient options link", selenium,
				ClassName, MethodName);
		
		assertTrue(click(selenium, lnkLabReportLink),
				"Could not click on file new report link", selenium,
				ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, lnkEnterData),
				"Could not find enter data link", selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);
		
//			assertTrue(click(selenium, elementPartial),
//					"Could not find partial radio button", selenium,
//					ClassName, MethodName);
		

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat(
				"dd-MM-yyyy HH:mm");
		String uniqueAccNumber = DateFormat.format(cal.getTime());

		assertTrue(type(selenium, elementaccNumber, uniqueAccNumber),
				"Could not type accession number", selenium, ClassName,
				MethodName);
		if (isElementPresent(selenium, btnOk)) {
			assertTrue(click(selenium, btnOk),
					"Could not click the ok Button", selenium, ClassName,
					MethodName);
		}

		selectValueFromAjaxList(selenium, ajxRProvider, labData.rProvider);

		selectValueFromAjaxList(selenium, ajxOProvider, labData.oProvider);

		if (account.equals(CAAccount)) {
			selectValueFromAjaxList(selenium, ajxLabName, labData.labNameCA);
		} else
			selectValueFromAjaxList(selenium, ajxLabName, labData.labName);
		waitForPageLoad(selenium);
		if (account.equals(CAAccount)) {
			Calendar cal1 = Calendar.getInstance();
			SimpleDateFormat DateFormat1 = new SimpleDateFormat(
					"dd/MM/yyyy");
			date = DateFormat1.format(cal1.getTime());
			assertTrue(enterDate(selenium, elementCdate, date),
					"Could not enter the collrction Date;More Details:"
							+ labData.toString(), selenium, ClassName,
					MethodName);
			assertTrue(enterDate(selenium, elementOdate, "28/10/2014"),
					"Could not enter the Order Date;More Details:"
							+ labData.toString(), selenium, ClassName,
					MethodName);

		} else {
			Calendar cal1 = Calendar.getInstance();
			SimpleDateFormat DateFormat1 = new SimpleDateFormat(
					"MM/dd/yyyy");
			date = DateFormat1.format(cal1.getTime());
			assertTrue(enterDate(selenium, elementCdate, date),
					"Could not enter the collrction Date;More Details:"
							+ labData.toString(), selenium, ClassName,
					MethodName);
			assertTrue(enterDate(selenium, elementOdate, "10/28/2014"),
					"Could not enter the Order Date;More Details:"
							+ labData.toString(), selenium, ClassName,
					MethodName);
		}
		assertTrue(type(selenium, elementCtime, labData.cTime),
				"Could not type time", selenium, ClassName, MethodName);
		assertTrue(type(selenium, elementNotes, labData.notes),
				"Could not type notes", selenium, ClassName, MethodName);
		selectValueFromAjaxList(selenium, ajxLabTestName, labData.testName);

		if (labData.testCaseId.equals("TC_LR_009")
				|| labData.testCaseId.equals("TC_LR_031"))
			if (isChecked(selenium,
					"//span[@id='labTestResultAbnormal']/input"))
				assertTrue(
						click(selenium,
								"//span[@id='labTestResultAbnormal']/input"),
						"Could not click abnormal check box", selenium,
						ClassName, MethodName);

		assertTrue(type(selenium, elementResult, labData.result),
				"Could not type results", selenium, ClassName, MethodName);
		assertTrue(type(selenium, elementLow, labData.low),
				"Could not type low", selenium, ClassName, MethodName);
		assertTrue(type(selenium, elementHigh, labData.high),
				"Could not type high", selenium, ClassName, MethodName);
		assertTrue(type(selenium, elementUnits, labData.units),
				"Could not type units", selenium, ClassName, MethodName);
		assertTrue(type(selenium, elementComment, labData.comments),
				"Could not type comments", selenium, ClassName, MethodName);

		if (labData.testCaseId.equals("TC_LR_005")) {
			assertTrue(click(selenium, elementAddTestResult),
					"Could not find add test result button", selenium,
					ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, elementLabTestName1,
					labData.testName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, elementResult1, labData.result),
					"Could not type results", selenium, ClassName,
					MethodName);
			assertTrue(type(selenium, elementLow1, labData.low),
					"Could not type low", selenium, ClassName, MethodName);
			assertTrue(type(selenium, elementHigh1, labData.high),
					"Could not type high", selenium, ClassName, MethodName);
			assertTrue(type(selenium, elementUnits1, labData.units),
					"Could not type units", selenium, ClassName, MethodName);
			assertTrue(type(selenium, elementComment1, labData.comments),
					"Could not type comments", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
		}
		if (labData.testCaseId.equals("TC_LR_032")
				|| labData.testCaseId.equals("TC_LR_033")
				|| labData.testCaseId.equals("TC_LR_034")
				|| labData.testCaseId.equals("TC_LR_035")) {
			assertTrue(click(selenium, elementAddTestResult),
					"Could not find add test result button", selenium,
					ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, elementLabTestName1,
					labData.testName1);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, elementResult1, labData.comments),
					"Could not type results", selenium, ClassName,
					MethodName);
			assertTrue(type(selenium, elementLow1, labData.low),
					"Could not type low", selenium, ClassName, MethodName);
			assertTrue(type(selenium, elementHigh1, labData.high),
					"Could not type high", selenium, ClassName, MethodName);
			assertTrue(type(selenium, elementUnits1, labData.units),
					"Could not type units", selenium, ClassName, MethodName);
			assertTrue(type(selenium, elementComment1, labData.comments),
					"Could not type comments", selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
		}
		waitForPageLoad(selenium);
		if (labData.testCaseId.equals("TC_LR_001")
				|| labData.testCaseId.equals("TC_LR_002")
				|| labData.testCaseId.equals("TC_LR_005")
				|| labData.testCaseId.equals("TC_LR_006")
				|| labData.testCaseId.equals("TC_LR_009")
				|| labData.testCaseId.equals("TC_LR_010")
				|| labData.testCaseId.equals("TC_LR_011")
				|| labData.testCaseId.equals("TC_LR_012")
				|| labData.testCaseId.equals("TC_LR_013")
				|| labData.testCaseId.equals("TC_LR_022")
				|| labData.testCaseId.equals("TC_LR_023")
				|| labData.testCaseId.equals("TC_LR_015")
				|| labData.testCaseId.equals("TC_LR_016")
				|| labData.testCaseId.equals("TC_LR_017")
				|| labData.testCaseId.equals("TC_LR_018")
				|| labData.testCaseId.equals("TC_LR_019")
				|| labData.testCaseId.equals("TC_LR_024")
				|| labData.testCaseId.equals("TC_LR_020")
				|| labData.testCaseId.equals("TC_LR_021")
				|| labData.testCaseId.equals("TC_LR_022")
				|| labData.testCaseId.equals("TC_LR_028")
				|| labData.testCaseId.equals("TC_LR_030")
				|| labData.testCaseId.equals("TC_LR_032")
				|| labData.testCaseId.equals("TC_LR_033")
				|| labData.testCaseId.equals("TC_LR_034")
				|| labData.testCaseId.equals("TC_LR_035")
				|| labData.testCaseId.equals("TC_LR_036")
				|| labData.testCaseId.equals("TC_LR_037")
				|| labData.testCaseId.equals("TC_LR_038")
				|| labData.testCaseId.equals("TC_LR_039")
				|| labData.testCaseId.equals("TC_LR_039")
				|| labData.testCaseId.equals("TC_LR_041")
				|| labData.testCaseId.equals("TC_LR_040")
				|| labData.testCaseId.equals("TC_LR_042")
				|| labData.testCaseId.equals("TC_LR_043")
				|| labData.testCaseId.equals("TC_LR_044")
				|| labData.testCaseId.equals("TC_LR_045")
				|| labData.testCaseId.equals("TC_LR_029")
				|| labData.testCaseId.equals("TC_LR_048") 
				|| labData.testCaseId.equals("TC_LR_053")) {

			Thread.sleep(10000);
			assertTrue(click(selenium, btnSave2),
					"Could not find save button", selenium, ClassName,
					MethodName);
			Thread.sleep(10000);
		} else if (labData.testCaseId.equals("TC_LR_003")) {
			assertTrue(click(selenium, elementDeleteTestResult),
					"Could not find delete button", selenium, ClassName,
					MethodName);
		} else if (labData.testCaseId.equals("TC_LR_004")
				|| labData.testCaseId.equals("TC_LR_046")) {
			assertTrue(click(selenium, btnSign),
					"Could not find sign button", selenium, ClassName,
					MethodName);
		} else if (labData.testCaseId.equals("TC_LR_007")) {
			assertTrue(click(selenium, btnResendCancel),
					"Could not find sign button", selenium, ClassName,
					MethodName);
		} else if (labData.testCaseId.equals("TC_LR_047")) {
			assertTrue(click(selenium, "saveAndNext"),
					"Couldnot click the save and Next button", selenium,
					ClassName, MethodName);
		}

	} catch (RuntimeException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return true;
}



}
