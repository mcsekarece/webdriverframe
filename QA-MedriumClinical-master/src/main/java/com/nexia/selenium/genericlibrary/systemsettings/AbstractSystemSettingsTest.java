package com.nexia.selenium.genericlibrary.systemsettings;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;

import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.sharedlibrary.AbstractTest;
import com.thoughtworks.selenium.Selenium;

public class AbstractSystemSettingsTest extends AbstractTest{
	public String CAAccount = fetchProperty("clinical", "CAAccount").trim().equals("") ? "0" : fetchProperty("clinical", "CAAccount").trim();
	
	//-------------------------------------------------------------------------//
	//		Page Factory Definition Here						               //
	//-------------------------------------------------------------------------//
	public String  ajxProviderSupervisosuggestBox  =  "supervisorsuggestBox";
	public String ajxDurationFrom="css=input.text-box";
	public String ajxDurationTo="css=input.text-box.validation-override";
	public String lblProviderNames="xpath=(//span[@id='chartListItemTitle'])[2]";
	public String lnkViewRegistration="patientOptionsRegistration";
	public String lblPracticeListItem = "xpath=(//*[contains(@id,'practiceListItemMainContent')])";
	public String chkIncludeInactivePractice = "includeInactivesPracticeViewcheckbox";
	public String txtpracticebox="searchTextBoxPracticeView";
	public String btnpracticesearch="searchButtonPracticeView";
	public String txtProviderBillingNo="providerBillingNumber";
	public String languageLink="languageName";
	public String closeBtn="closeButton";
	public String lnkQuickActions="link=Quick Actions";
	  public String txtPayToNumber="payTo";
	public String  ajxLanguagesuggestBox1 = "chosenLanguagePanel";
	public String todate="todate";
	public String lblprovider = "//div[starts-with(@id,'providerListItemMainContent')]";
	public String lblDropDown = "//div[contains(@id,'currentItem')]";
	public String lnkDeleteProv = "//a[starts-with(@id, 'DeleteProvider')]";
	public String lnkPostCharge = "link=Post charges";
	public String lnkPostCharge1 = "xpath=(//a[contains(text(),'Post charges')])[2]";
	public String chkLimitedAccess="chk2ClinicalListscheckbox";
	public String addLanguage="addLanguageButton";
	public String chkBoxEnglish="SPA|Spanish; Castiliancheckbox";
	public String languageCheckBox="SPA|Spanish; Castiliancheckbox";
	public String programsSearchBox="searchButtonProgramView";
	
	public String lnkQuickLink = "link=Quick Actions";	
	public String dixCosign="css=div.popupContent";
	//NavigatetoSystemSetting
	public String btnSearchAssociate = "practiceProvidersearchButton";
	public String lblInactiveEntry="//span[contains(text(),'Inactive')]";
	public String lnkBillingHistory = "link=Billing history";
	public String lnkBillingSummary = "!billingSummaryHistory";
	public String lblPayerDetail = "//tr[3]/td/div/div/table/tbody/tr/td/div/div/div/div[7]/div";
	public String lblPayerDetail1 ="css=td > span.gwt-InlineHTML";
	
	public String btnEditLocation = "//a[starts-with(@id, 'Edit')]";
	public String btnIdentifierTypeDel = "//a[contains(text(),'Delete')]";
	public String lnkQuickLinkDiv = "//div[2]/div/div/a";
	public String lnkSystemSettingLink="systemSettingsAction";
	public String lnkSystemSettings = "systemSettings";  
	public String lnkSystemSettingsAction = "systemSettingsAction"; 
	public String lnkSecuritySetting="securitySettingsAction";
	public String lnkOrgStructures="!adminOrgStructureLists";
	public String lnkOrgStructuresId = "id=!adminOrgStructureLists";
	public String txtValidNum = "validForNumber";
	public String lblSecondPractice1 = "//a[contains(@id,'practice')]"; 
	public String lnkConsentShowMore  ="ConsentTypeListMoreLink";
	
	public String btnNextFromPractice = "next";
	  public String btnDeleteLocation = "xpath=(//a[contains(@id,'Delete')])";	  
	public String btnEditAssociatePayer1 = "xpath=(//a[contains(@id,'Edit')])";
	public String btnDonePratice= "done";
	public String AddLocation = "addNew";
	public String btnAddNewPractice = "addNew";

	  public String ajxPrimaryLocation="primaryLocationSuggestBoxsuggestBox";
	  public String txtBillingLocationName= "billingLocationNameTextbox";
	  public String txtBillingLocationName0= "billingLocationName0";
	  public String txtBillingLocationName1= "billingLocationName1";
	  public String txtBillingLocationName3= "billingLocationName2";
	  public String txtBillingLocationName4= "billingLocationName3";


	  public String lblPracticeName ="//div[@id='printInfo']/div/div/div/div/div[4]/div";
	  public String lblMessage = "css=span.loginMessageSpan";

	  public String lnkSystemSetting="systemSettingsAction";
 
	  public String lnkRegisterPatient =  "newPatientAction";
	  public String  lnkTopMenuHeader = "username";
	  public String  lnkSignOutAction = "signOutAction";
	  public String  lnkLoginAccountText =  "loginAccountText";
	  public String  lnkLoginUseridText =  "loginUseridText";
	  public String  lnkLoginPasswordText = " loginPasswordText";
	  public String  btnLogin = "loginButton";
	  public String  btnErrorClose = "errorCloseButton";
	  public String  btnYesAutomaticAreaByZip = "yesButton";
	  public String  btnNoAutomaticAreaByZip = "noButton";

	 
	  public String lblResultPractice="css=div.org-structure-main-item";

	  public String ajxRxProvider="xpath=(//input[@id='suggestBox'])[2]";
	  public String txtdeleteReason = "deleteReason";
	  public String btnOkButton="okButton";
	
	  public String ajxPracticeSuggestBox = "xpath=(//input[@id='suggestBox'])";
	  public String ajxUserRoleSuggestBox = "xpath=(//input[@id='userRolesuggestBox'])";
	  public String btnDeleteRole = "xpath=(//button[@id='delete'])";
	  
	 //FIXME VEL-5892
	  
	  public String lnkShowMoreLink="css=a.dropdown-item.show-more > span";

	  
	//Navigate to Security Setting
	
	public String lnkSecuritySettings = "securitySettingsAction"; 

	
	//User
	
	public String txtUserSearch="searchTextBoxUserView";
	public String txtSuggestBox = "suggestBox";
	public String btnUserSearch="searchButtonUserView";
	public String lblSearchDetails="//div[@id='users']/table/tbody/tr/td";
	public String btnadduser = "addUser";
	public String chkUserProvider = "//span/input";

     //User Roles
	
	public String lnkUserRole = "!adminUserRoleList";
	public String lnkUserRoleMore ="AdminUserRoleListMoreLink";
	public String lnkExpandAll ="link=Expand all";
	public String lnkSecuritySettings1="securitySettingsAction";
	
	public String txtUserRoleMore="userRoleName";
	
	public String ajxHomePageView="homePageViewsuggestBox";
	

		public String lblUserName="//div[2]/table/tbody/tr/td[2]";
		public String lblFullAccess="chk42checkbox";
		public String btndelete="delete0";
		public String lnkRightsRegistration="arrowRegistration@class";
		public String lnkArrowRegister="arrowRegistration";
		public String lnkRightsClinical="arrowClinical@class";
		public String lnkArrowClinical="arrowClinical";
		public String lnkRightsOrders="arrowOrders@class";
		public String lnkArrowOrders="arrowOrders";
		public String lnkRightsReports="arrowReports@class";
		public String lnkArrowReprots="arrowReports";
		public String lnkRightsMedicalSummary="arrowMedical Summary@class";
		public String lnkArrowMedicalSummary="arrowMedical Summary";
		public String lnkRightsClinicalList="arrowClinical Lists@class";
		public String lnkArrowClinicalList="arrowClinical Lists";
		public String lnkRightsClinicalSettings="arrowClinical Settings@class";
		public String lnkArrowClinicalSettings="arrowClinical Settings";
		public String lnkRightsAdministration="arrowSystem Settings@class";
		public String lnkArrowAdministration="arrowSystem Settings";
		public String lnkRightsOrganizationalStructure="arrowOrganizational Structure@class";
		public String lnkArrowOrganizationalStructure="arrowOrganizational Structure";
		public String lnkRightsDirectories="arrowDirectories@class";
		public String lnkArrowDirectories="arrowDirectories";
		public String lnkRightsGeneral="arrowGeneral@class";
		public String lnkArrowGeneral="arrowGeneral";
		public String lnkRightsSecuritySettings="arrowSecurity Settings@class";
		public String lnkArrowSecuritySettings="arrowSecurity Settings";
		public String lnkRightsReports1="xpath=(//span[@id='arrowReports'])[2]@class";
		public String lnkArrowReports1="xpath=(//span[@id='arrowReports'])[2]";
		public String lnkRightsScheduling="arrowScheduler@class";
		public String lnkArrowScheduling="arrowScheduler";
		public String lnkRightsCalenderSettings="arrowCalendar Settings@class";
		public String lnkArrowCalenderSettings="arrowCalendar Settings";
		public String lnkRightsCalenderView="arrowCalendar View@class";
		public String lnkArrowCalenderView="arrowCalendar View";
		public String lnkRightsPDG="arrowPDG@class";
		public String lnkArrowPDG="arrowPDG";
		public String lnkRightsTemplateSetup="arrowTemplate Settings@class";
		public String lnkArrowTemplateSetup="arrowTemplate Settings";
		public String lnkRightsBiller="arrowBilling@class";
		public String lnkArrowBiller="arrowBilling";
		public String lnkRightsBillingHistory="arrowBilling History@class";
		public String lnkArrowBillingHistory="arrowBilling History";
	
	//Password Rules
	public String lnkPasswordRules="!adminPasswordRulesShow";
	public String btnPREdit="editButton";
	public String btnPRSave="save";
	public String chkStartNumber="cantStartWithNumbercheckbox";
	public String lblStartWithNumber="//div[4]/li/div";
	
	// EnterPriseVariableAddressbook
	
	public String lnkEnterpriseVariables = "!enterpriseID";
	public String lnkDelete =  "link=Delete";
	public String lnkAddressBook = "!adminAddressBookList";
		
	public String lblTitle = "css=span.title";
	public String lblPopupPanel  = "css=div.gwt-PopupPanel.localizedSuggestBoxOracle";
	public String lblAdminSettings   = "css=div.adminSettings";
	
	public String txtVariableBox =  "variableValueTextFieldId";
	public String txtSearchBox = "searchTextBox";
	public String lblListPayers="//div[@id='adminPayerListView']/table/tbody/tr";
	public String listPayer = "//span[starts-with(@id,'payerEntry')]";
	
	public String txtUserSearchBox = "xpath=(//input[@id='searchTextBox'])[5]";
	public String btnSearchButton="searchTextBox";
	public String txtEnterpriseIdName = "css=input.gwt-TextBox";
	
	public String ajxSuggestBox =  "idTypeSuggestBoxsuggestBox";
	
	public String btnYes =  "yesButton";
	public String btnSearchBox = "xpath=(//button[@type='button'])[2]";
	public String btnAddenterprise =  "addEnterpriseID";
	public String btnSave =  "save";
	public String btnAddressBookEntry = "addNewAddressBookEntry";
	public String btnAddEdit = "editButton";
	public String btnEdit1 = "edit";
	public String btnBack = "back";
	public String btnEnter ="\\32";
	public String btnEnter1 = "\\13";
	public String btnEnter2 = "\\9";
	public String btnDelete = "//a[contains(text(),'Delete')]";
	public String btnPracticeBack = "//button[@type='button']";
	public String btnPatientCancel = "cancelButton";
	public String btnEditEnterprise = "//td[3]/div/div/a";
	public String btnElementEnable = "//td[3]/div/div/div/input";
	public String txtEditId = "//input[starts-with(@id,'eidTextBox')]";
	public String btnSaveEnterprise = "//a[starts-with(@id,'eidUpdate')]";
	public String FirstProvider="xpath=(//div[contains(@id,'providerListItem')])[1]";
	public String SecondProvider="xpath=(//span[contains(@id,'providerListItem')])[2]";
	public String btnProviderDelete="xpath=(//a[contains(@id,'DeleteProvider')])";
	public String btnActivateProvider="xpath=(//a[contains(@id,'ActivateProvider')])";
	//HealthCare
	
	public String lnkAdminHealthcareTeamList = "!adminHealthcareTeamList";
	public String lnkClosedArrow = "//div[@id='AdminHealthcareList']/table/tbody/tr/td/div/div";
	public String rdGlobalHealth = "//span/input";
	public String rdLocalHealth = "//span[2]/input";

	
	public String ajxName1 = "nameSuggestBoxId1suggestBox";
	public String ajxName2 = "nameSuggestBoxId2suggestBox";
	public String ajxRole2 = "//div[2]/div/div/div/div/input";
	public String ajxRole1 = "roleSuggestBoxId1suggestBox";
	public String ajxdeletingMem = "xpath=(//input[@id='suggestBox'])[5]";
	public String chkChartCheckBox1  = "//div[2]/span/input";
	public String chkChartCheckBox  ="//div[2]/div[2]/div[2]/span/input";
	public String txtTeamName = "teamName";
	public String txtNotes = "notes";
	public String btnAddHealthcareTeam = "addHealthcareTeam";
	//public String btnAddMember = "css=div.controls.buttons > button.gwt-Button";
	public String btnAddMember = "//span[@id='addMemberSpan']";
	public String btnSaveHealth =  "saveHealthcareTeam";
	public String btnEditHealth =   "//div[@id='AdminHealthcareList']/table/tbody/tr/td[2]/div/a";
	public String btnAddallCharts  = "//div[2]/span/input";
	public String btnDeleteHealth  = "//button[@id='deleteReason']";
	//
	public String btnInactiveHealth =  "//span/input";
	public String btnActiveHealth = "//a[contains(text(),'Activate')]";
	public String btnSearchHealth =   "searchButtonId";
	public String btnInactiveHealth1 =  "//span/input";
	
	public String btnEditHealth1 =  "//a[contains(text(),'Edit')]";
	public String vfyMembers1 =  "xpath=(//input[contains(@id,'nameSuggestBoxId')])[1]";
	public String vfyMembers2 =  "xpath=(//input[contains(@id,'nameSuggestBoxId')])[2]";
	public String lnkAdminHealthcareDel = "//div[@id='AdminHealthcareList']/table/tbody/tr/td[3]/div/a";
	
	//External providers
	
	public String lnkExternalProviderList = "!adminExternalProviderList";
	public String lnkAddReferringProvider =  "addReferringProvider";
	
	public String lnkAdminOrgStructureLists  = "!adminOrgStructureLists";
		
	public String txtReferringCode =  "referringCode";
	public String txtLastName = "lastName";
	public String txtFirstName = "firstName";
	public String txtMiddleName = "middleName";
	public String txtUserName = "userName";
	public String txtMiddleInitials =  "mi";
	public String txtCredentials =  "credentials";
	public String txtStateLicNum =  "stateLicNum";
	public String txtUpin =  "upin";
	public String txtNpi = "npi";
	public String txtTaxonomyCode = "taxonomyCode";
	public String txtComments =  "comments";
	public String txtPracticeName1=  "//input[starts-with(@id, 'practiceName')]";
	public String txtEpstreet11 = "xpath=//input[starts-with(@id, 'addr')]";
	public String txtEpstreet12 =  "xpath=(//input[starts-with(@id, 'addr')])[2]";
	public String txtEpcity1 = "xpath=//input[starts-with(@id, 'city')]";
	public String txtEpzipcode1  = "xpath=//input[starts-with(@id, 'zip')]";
	public String txtEpzipcode2  = "xpath=(//input[starts-with(@id, 'zip')])[2]";
	public String txtEpPhone1 = "xpath=//input[starts-with(@id, 'phoneExt')]";
	public String txtEpPhone2 = "xpath=(//input[starts-with(@id, 'phoneExt')])[2]";
	/*public String txtEpExtn1 =  "//input[2]";
	public String txtEpExtn2 =    "//div[2]/div[8]/div/input[2]";*/
	public String txtEpFax1 = "xpath=//input[starts-with(@id, 'fax')]";
	public String txtEpFax2 ="xpath=(//input[starts-with(@id, 'fax')])[2]";
	public String txtEpEmail1  = "xpath=//input[starts-with(@id, 'eMail')]";
	public String txtEpEmail2  ="xpath=(//input[starts-with(@id, 'eMail')])[2]";
	public String txtPracticeName2 = "practiceName2";
	public String txtEpstreet21  = "xpath=(//input[starts-with(@id, 'addr')])[3]";
	public String txtEpstreet22   = "xpath=(//input[starts-with(@id, 'addr')])[4]";
	public String txtEpcity2  = "xpath=(//input[starts-with(@id, 'addr')])[2]";
	
	public String ajxEpCountry1 =  "countrySuggestBox1suggestBox";
	public String ajxEpCountry2 = "countrySuggestBox2suggestBox";
	public String ajxEpstate1 =  "stateSuggestBox1suggestBox";
	public String ajxEpstate2  ="stateSuggestBox2suggestBox";
	public String ajxReportMethod =  "//input[@id='suggestBox']";
	public String ajxSpecialtySuggestBox = "specialtySuggestBoxIdsuggestBox";
	public String ajxResponsibleProviderSuggestBox = "responsibleProviderSuggestBoxIdsuggestBox";

	public String btnNO = "noButton";
	public String btnAddAddressBtn = "addAddressButton";
	public String btnDeleteProvider = "xpath=(//button[contains(@id, 'delete')])[2]";
	public String btnsaveProvider ="save";
	
	public String rdoPrimaryAddress = "//div[2]/div[2]/div/div/span/input";
	
	public String lblMargin =  "css=button.floatRight.marginBottom10";
	public String EditbtnExrlPro="editButtonId";

	public String chkBillingExBox =  "billingExclusioncheckbox";
	public String chkPecoscheckbox =  "pecoscheckbox";
	
	public String lnkexternalProviderDel = "//div[@id='AdminReferringProviderList']/table/tbody/tr/td[2]/div/a";
	public String lnkexternalProviderDel1 ="//div[@id='AdminReferringProviderList']/table/tbody ";
	public String lnkexternalProviderRecord  ="//div[@id='AdminReferringProviderList']/table/tbody/tr/td/div/div";
	public String lnkexternalProviderRecord1= "//div[@id='AdminReferringProviderList']/table/tbody/tr[2]/td/div/div";
	
	
	//Mandatory Fields
	public String lnkAdminMandatoryUserField  ="!adminMandatoryUserField";
	public String lnkAdminMandatoryUserDel  = "//div[@id='adminMandatoryUserFieldList']/table/tbody/tr/td[2]/div/a";
	public String lnkAdminMandatoryUserCount  ="//div[@id='adminMandatoryUserFieldList']/table/tbody/tr/td[2]/div/a";
	public String lnkAddMandatoryUserField  = "css=button.primary-button";
	public String ajxUnitSuggestBox  = "unitsuggestBox";
	public String ajxFieldSuggestBox  = "fieldsuggestBox";
	
	public String vfyStamp  ="css=span.inline";
	public String lstItemSelectedMan ="css=div.item-selected";
	public String lstSuggestBoxOracleMan ="css=div.gwt-PopupPanel.localizedSuggestBoxOracle";
	
   //SocioEconomic
	
	public String lnkNewPatientCheckIn  = "newPatientCheckIn";
	public String lnkPatietnSocialHistory  = "!patientSocialHistory";
	
	public String ajxParentEthnicitysuggestBox  = "parentEthnicitysuggestBox";
	public String ajxLivingArrangementsuggestBox  = "livingArrangementsuggestBox";
	public String ajxStudentStatussuggestBox  = "studentStatussuggestBox";
	public String ajxEducationLevelsuggestBox = "educationLevelsuggestBox";
	
	public String btnSaveSocio =  "css=button.gwt-Button";
	
	
	
	
	
	
	// Patient Contacts
	
	public String lnkPatientContact = "!patientContactsList";
	public String btnAddNewPatientContact = "addContact";
	public String txtAddContactSearch = "patientcontactSearchBox";
	public String btnAddContactSearch = "//div[2]/div/div/div/div/span/button";
	public String lblPatientContactPopup = "patientContactPopup";
	public String txtAddContactFstName= "firstName";
	

	
   // CreateAddressBook
	
	public String rdGlobal = "globalradio";
	public String rdLocal = "localradio";
	public String ajxContactSuggestBox  = "contactTypesuggestBox";
	public String txtAddContactCompany  = "addressBookContactCompany";
	public String ajxTitleSuggestBox =  "titlesuggestBox";
	public String txtDirectoriesLastName = "lastName";
	public String txtDirectoriesFirstName = "firstName";	
	public String txtAddBookLastName = "addressBookLastName";
	public String txtAddBkFirstName = "addressBookFirstName";
	public String txtAddBkMiddleName =  "addressBookMiddleName";
	public String txtJobtitle ="jobTitleFieldId";
	public String txtJobtitle1="jobTitleId";
	public String txtAddBkDepartment = "addressBookDepartment";
	public String ajxCommTy1suggestBox ="commType1suggestBox";
	public String ajxCommTy2suggestBox ="commType2suggestBox";
	public String ajxCommTy3suggestBox ="commType3suggestBox";
	public String txtAddBkPrimaryPhone = "addressBookPrimaryPhone";
	public String txtAddBkPrimaryPhoneExt = "addressBookPrimaryPhoneExt";
	public String txtAddBkAdd1 = "addressBookAddressAddr1";
	public String txtAddrBkAdd2 = "addressBookAddressAddr2";
	public String txtAddBkCity ="addressBookAddressCity";
	public String ajxAddBkStateSuggestBox = "addressBookAddressStatesuggestBox";
	public String txtAddBkZipCode = "addressBookAddressZip";
	public String cmbAddBkCountrySuggestBox="addressBookAddressCountrysuggestBox";
	public String btnYesbutton = "yesButton";
	public String ajxaddBkCountrySuggestBox ="addressBookAddressCountrysuggestBox";
	public String txtAddBkEmail = "addressBookEmail";
	public String txtAddBkWebAdd = "addressBookWebAddress";
	public String txtcmt = "comments";
	public String btnAddSave = "addressBookSave";
	public String lblBox=  "//td[2]/div/div/div/div";
	public String lnkDel="//a[contains(@id,'Delete')]";
    public String departmentListDelete="xpath=(//a[contains(@id,'DeleteDepartment')])[1]";
	
	// Consents
	
	public String lnkconsentList = "!adminConsentList";
	public String btnConsent = "addConsentType";
	public String btnEdit ="//a[contains(text(),'Edit')]";
	public String ajxConsentSuggestBox =  "consentTypeSuggestBoxsuggestBox";
	public String ajxValidType ="validForTypeInputFieldId";
	public String ajxRestrictionLevel = "restrictionLevelSuggestBoxsuggestBox";
	public String txtConsentName = "consentName";
	public String txtValidNumber = "validForNumberInputFieldId";
	public String txtValidNumberInEdit="validForTypeInputFieldId";
	public String txtValidNumInEdit="validForNumberInputFieldId";
	public String lblConsentForums = "//td[2]/div/div/div/div";
	public String lblConsentFullForums =  "css=div.adminSettings";
	public String lblConsentFullForumsSec = "//td[2]";
	public String lblConsentFull = "css=div.verticalExtendTabContainer";
	public String chkConsentCheckBox  ="includeInactiveConsentcheckbox";
	
	// Directories 
	
	public String lnkDirectories = "!directories";
	public String chkDoNotShowAgain ="notShowAgainIDcheckbox"; 
	public String btnUserHint ="payerAdmin_UserHintCloseButton";	
	public String btnAddNew ="css=button.secondary-button.float-right";
	public String btnPharamcybutton = "css=button.secondary-button.float-right";
	public String txtPharamcyName = "pharmacyName";
	public String txtPayerName = "payerName";
	public String txtPayerCode = "payerCode";
	public String txtPlanName = "planName";
	public String txtCoPay = "coPay"; 
	public String txtSpecialistCoPay = "specialistCoPay";
	public String txtDeductible = "deductible";
	public String txtCoInsurance = "coInsurance";
	
	
	public String txtLocation1Code   ="locationCode0";
	public String txtLocation2Code   ="locationCode1";
	public String txtAddr1   = "addr1";
	public String txtAddr1Loc1   = "addr10";
	public String txtAddr1Loc2   = "addr11";
	public String txtAddr1Loc3   = "addr12";
	public String txtAddr1Loc4   = "addr13";
	public String txtCity =  "city";
	public String txtCityLoc1 =  "city0";
	public String txtCityLoc2 =  "city1";
	public String txtCityLoc3 =  "city2";
	public String txtCityLoc4 =  "city3";
	public String ajxStateSuggestBoxSuggestBox =  "stateSuggestBoxsuggestBox";
	public String ajxSelectPayerType = "payerPickListsuggestBox";
	public String ajxStateSuggestBoxSuggestBoxLoc1 =  "stateSuggestBox0suggestBox";
	public String ajxStateSuggestBoxSuggestBoxLoc2 =  "stateSuggestBox1suggestBox";
	public String ajxStateSuggestBoxSuggestBoxLoc3 =  "stateSuggestBox2suggestBox";
	public String ajxStateSuggestBoxSuggestBoxLoc4 =  "stateSuggestBox3suggestBox";
	public String txtZip =  "zip";
	public String txtZipLoc1 =  "zip0";
	public String txtZipLoc2 =  "zip1";
	public String txtZipLoc3 =  "zip2";
	public String txtZipLoc4 =  "zip3";
	public String  btnNo =  "noButton";
	public String btnYesButton = "yesButton";
	public String btnDeleteDirectories ="//div[@id='adminPharmacyListView']/table/tbody/tr/td[2]/div/a";
	
	public String lblDeletePayerAdmin ="//div[@id='adminPayerListView']/table/tbody/tr/td/div/div/div";	
	public String btnDeletePayerAdmin ="deleteButton";
	public String btnAddNewPayer = "payerAddNewButton";
	public String btnEditPayerWizard = "payerWizardEditLink";
	
	public String ajxSelectPayerAdmin =  "payerMastersuggestBox";
	public String ajxDirectoryType =  "suggestBox";
	public String ajxSubmitClaimsSuggestBox =  "claimTypePickListPrimarysuggestBox";
	public String ajxSubmitClaimsSubsequentSuggestBox =  "claimTypePickListSubsequentsuggestBox";
	public String ajxClaimsDaysSuggestBox =  "claimDaysPickList1suggestBox";
	public String ajxClaimsDaysSuggestBox1 =  "claimDaysPickList2suggestBox";
	public String ajxDepartmentSuggestBox =  "departmentsuggestBox";
	public String txtSearchPractice ="searchTextBoxPracticeView";
	public String ajxStateCountryBoxSuggestBox =  "countrySuggestBoxsuggestBox";
	public String ajxStateCountryBoxSuggestBoxLoc1 =  "countrySuggestBox0suggestBox";
	public String ajxStateCountryBoxSuggestBoxLoc2 =  "countrySuggestBox1suggestBox";
	public String ajxStateCountryBoxSuggestBoxLoc3 =  "countrySuggestBox2suggestBox";
	public String ajxStateCountryBoxSuggestBoxLoc4 =  "countrySuggestBox3suggestBox";
	public String txtCommentTestBoxId    = "commentTextBoxId";
	public String txtPhone =  "phone";
	public String txtPhoneExtension = "phoneExtension";
	public String txtFax =  "fax";
	public String txtEmail  = "email";
	public String txtWebsite =  "website";
	public String txtRole = "role";
	
	public String btnSearchTextBox ="searchTextBox";
	public String buttonEdit = "editButton";
	public String btnSave1 =  "saveButton";
	public String btnSearch = "searchButton";
	
	
	public String btnAddNewPlan = "payerWizardAddNewPlansButton";
	public String btnNext = "payerWizardNextButton";
	public String btnAddNewContact = "payerWizardAddNewContactsButton";
	public String btnEditContact="xpath=(//a[contains(@id,'Edit')])[2]";
	public String btnEditPlan="payerWizardEditLink";
	public String btnDone = "payerWizardDoneButton";
	public String btnDeletePayer = "deleteButton";
	public String btnEditPayer = "editButton";
	public String chkNotShowAgain = "notShowAgainIDcheckbox";
	public String btnCrossPicklist = "//a[@id='payerAdmin_UserHintCloseButton']/img";
	
	public String lnkManagePharamcy  = "Manage Pharmacy ";
	
	public String vfyStoreTextPayer="css=div.settings-information-box";
	public String vfyStoreValuePayerAdmin = "//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr/td[2]/div/div/div/div[2]/div";
	
	public String vfyStoreValueContact = "//div[@id='PayerContactListView']/table/tbody/tr/td";
	public String vfyStoreValuePayersPlan = "//div[@id='adminPlanListView']/table/tbody/tr/td";
	
	//*********************
	//public String lnkPostCharge = "link=Post charges";
	public String lnkPostNewCharge = "link=Post new charges with no encounter.";
	 public String chkHardCopy="//div[@id='patientPayerWidget']/div/div/div[4]/div/div/div/div[4]/div[3]/div/span/input";
	 public String ajxBillPayer="billToPayersListSuggestBoxsuggestBox";
	 public String ajxRelationShip ="subscriberRelationshipSuggestBoxsuggestBox";
	 public String txtPayerStartDate ="css=input.gwt-DateBox.text-box";
	 public String ajxPayerSelect ="payerSearchSuggestBoxsuggestBox";
	 public String btnPayerList ="!patientPayersList";
	 public String btnPatientMedicalPayers= "medicalPayers";
	 public String btnMedicalPayersCA="addNewMedicalPayerButton";
	 public String btnOtherPayersCA="otherPayers";
	 public String btnAddNewMedPayer="addNewMedicalPayerButton";
	 public String btnlnkSave = "link=Save";
	 
	 public String fstProvider ="//div[@id='providers']/table/tbody/tr/td/div/div/div/span";
	 public String lnkAssociateProvider ="xpath=(//button[@id='add'])[3]";
	 public String payerSearchSugguestBox ="payerSearchSugguestBoxsuggestBox";
	 public String billingEDIStatusSugguestBox ="billingEDIStatusSugguestBoxsuggestBox";
	 
	
	//Identifiers
    public String lnkIdentifier="!patientExternalIdList";
    
    
	
    public String btnAddIdentifier="addExternalID";
    public String btnIdGroup =  "groupFor";
    public String btnEditIdGroup = "//a[contains(text(),'Edit')]";
    public String btnEditIdGroup1 = "//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[2]/div/a";
    public String btnEditId = "id=Edit887";
    public String btnEditIdType = "id=Edit957";
    public String txtGroup = "group";
    public String txtdescription  ="description";
    public String ajxGroup="groupsuggestBox";
    public String chkIdGroupBox = "//span/input";
    public String ajxType="typesuggestBox";
    public String btnStatusIdGroup = "status";
    public String lnkAddIdentifierType="addIdentifierType";
    public String lnkAddIdentifierTypeSec = "id=addIdentifierType";
    public String lnkIdentifierGroup="!adminIdentifierGroupList";
    public String lnkIdentifierGroupSec ="id=!adminIdentifierTypeList";
    public String lblPatientIdentifierGroup = "css=span.listPatientName";
	public String btnAddIdentifierGroup="addIdentifierGroup";
	public String btnIdentifierGroupDel = "//a[contains(text(),'Delete')]";
	
	public String lnkIdentifierType="!adminIdentifierTypeList";

	public String btnAddIdentifierType="addIdentifierType";

	public String lnkCloseArrow ="css=div.closedArrow";
	public String lnkldenCloseArrow = "//div[@id='AdminIdentifierTypeList']/table/tbody/tr/td/div/div"; 
	public String ajkPopupBox="css=div.gwt-PopupPanel.localizedSuggestBoxOracle";
    public String lblIdentifierTypeSummary="//td[2]/div/div/div";
    public String lnkPractice="//div[@id='printInfo']/div/div/div/div/div[4]/div/div";
    public String lblSecondPractice="//tr[2]/td/a/span"; 
    public String lblAddIdentifier  = "//span[2]/label";
    public String lblPayerPicklist = "css=div.userHintDialog";
   
    

    public String ajxSuggestBoxIdType = "suggestBox";
    public String txtType = "type";
    public String rdbtnDefinedList = "//span[@id='definedList']/input";
    public String rdbtnEnterprisseLevel =  "enterpriseLevelradio";
    public String rdbtnpracticeLevel = "practiceLevelradio";
    //
    public String chkRestrictedBox = "//span[@id='restricted']/input";
    public String chkEndDateRequiredBox = "//span[@id='endDateRequired']/input";
    public String chkDefaultBox = "//span[@id='defaultType']/input";
    
    public String txtIdentifier = "identifier";
    public String txtMask = "mask";
    public String btnAddId = "addID";

	//CreateAddressBookWithMandatoryField
	
	public String txtAddBkDept =  "addressBookDepartment";
	
	// Organisational Structures 
	public String lblProviderCount="providerCount";
	public String  btnAddProgram  =  "addProgram";
	public String  ajxSuggestBoxProg  =  "suggestBox";
	public String  typeProgramName  = "programName";
	public String  btnAddProvider  = "add";
	public String  btnAddProviderorg  = "addProvider";
	public String  btnIdentifierButtonId  = "AddAnIdentifierButtonId";
	public String  txtProviderSearchBox  = "providerSearchBox";
	public String  btnSearchProviderBox  =  "searchBox";
	public String  ajxProviderTypesuggestBox  =  "providerTypesuggestBox";
	public String  ajxResponsibleProvSuggestBoxsuggestBox  =  "responsibleProvSuggestBoxsuggestBox";
	public String  ajxResponsibleProvPCPcheckbox  =  "responsibleProvPCPcheckbox";
	public String  txtProviderCode  =    "providerCode";
	public String  txtSpecialtySuggestBox  =  "specialtysuggestBox";
	public String  txtChosenSpecialitySuggBox="chosenSpecialties";
	public String  txtSearchTextBox2 =  "id=searchTextBoxProgramView";
	public String btnProgramSearch="xpath=(//button[@type='button'])[4]";
	public String  btnAddSpecialtyButton =  "addSpecialtyButton";
	public String  ajxGendersuggestBox =  "gendersuggestBox";
	public String  ajxLanguagesuggestBox = "languagesuggestBox";
	public String  btnAddLanguageButton= "addLanguageButton";
	public String  txtCellPhone  = "cellPhone";
	public String  txtPager  =  "pager";
	public String  ajxMaximumFTESuggestBoxsuggestBox = "maximumFTESuggestBoxsuggestBox";
	public String  ajxHoursWorked="hoursWorked";
	public String  ajxBillingStatesuggestBox = "billingStatesuggestBox";
	public String  txtMailingStreet1  = "mailingStreet1";
	public String  txtMailingStreet2  = "mailingStreet2";
	public String  txtMailingCity  = "mailingCity";
	public String  txtMailingStatesuggestBox ="mailingStatesuggestBox";
	public String  txtMailingZipPostalCode= "mailingZipPostalCode";
	public String  txtMailingCountrysuggestBox = "mailingCountrysuggestBox";
	public String  txtMailingOfficePhone =    "mailingOfficePhone";
	public String  txtMailingOfficePhoneExt =    "mailingOfficePhoneExt";
	public String  txtMailingFax =  "mailingFax";
	public String  txtBillingStreet1 = "billingStreet1";
	public String  txtBillingStreet2 = "billingStreet2";
	public String  txtCityPro = "billingCity";
	public String  txtBillingZipPostalCode =  "billingZipPostalCode";
	public String  txtBillingCountrysuggestBox = "billingCountrysuggestBox";
	public String  chkSignatureOnFilecheckbox = "signatureOnFilecheckbox";
	public String  txtSignatureDate = "signatureDate";
	public String  txtDea = "dea";
    public String  programsListItem="xpath=(//div[contains(@id,'programListItem')])[1]";
	public String   txtUpinPro =  "upin";
	public String  chkIncludeInactivescheckbox =  "includeInactiveProgramscheckbox";
	public String btnActivateInactive="activateButton";
	public String lblPayerSummary="//div[@id='adminPayerListView']/table/tbody/tr/td";
	public String  chkIncludeInactiveUserscheckbox = "includeInactiveUserscheckbox";
	public String  chkIncludeInactiveProgramsCheckbox =  "includeInactiveProgramscheckbox";
	public String ajxReportMethodsuggestBox = "reportMethodsuggestBox";
	public String  chkSameAsMailingAddresscheckbox =  "sameAsMailingAddresscheckbox";
	public String  btnIdentifier =  "xpath=(//button[@type='button'])[7]";
	
	public String  ajxGroupName = "group0suggestBox";
	public String  ajxGroupFor = "type0suggestBox";
	public String ajxPractice =  "id=practice0suggestBox";
	public String ajxIdType =  "type0suggestBox";
	public String ajxIdTypeMask = "idMask0";
	public String  ajxProviderListSuggestBox =  "providerListSuggestBoxsuggestBox";
	public String  btnProviderSearch="searchButtonProviderView";
	public String  vfyProgramDel  ="//div[3]/div/div/div";
	public String  vfyProgramDel2  = "xpath=(//*[contains(@id,'searchTextBox')])[4]";
	public String  txtProviderSearchbox  = "searchTextBoxProviderView";
	public String  vfyProgramDel3  = "xpath=(//button[@type='button'])[8]";
	public String  vfyProgramDel4  = "//div[@id='providers']/table/tbody/tr/td[2]/div/a";
	public String  btnRemovePro  = "//div[@id='providers']/table/tbody/tr/td[2]/div/a";
	public String  vfyProgramDel5  = "//div[@id='providers']/table/tbody/tr/td/div/div/span";
	public String  vfyProgramDel6  = "//div[@id='providers']/table/tbody/tr/td";
	public String  txtFirstName2  = "//td[2]/div/div/div/div[4]/div/div";
	public String  btnDelete2  =  "//td[2]/div/div/div/div[4]/div/div";
	public String  btnDelProvider  = "//td[2]/div/a";
	public String  btnSearchOrg = "search";
	public String  chkBoxOrg =  "//span/input";
	public String  chkResetPassword =  "resetPasswordcheckbox";
	public String  btnResetPassword =  "resetPassword";
	public String  txtCurrentPassword = "currentPassword";
	public String  txtNewPassword ="newPassword";
	public String btnSearchUser="searchButton";
	public String   btnSearchOrg1 ="//div[4]/div/div/div/div[2]/span/button";
	public String   btnSearchOrg2 = "xpath=(//button[@type='button'])[8]";
	public String   btnSearchProvider = "//div[@id='providers']/table/tbody/tr/td/div/div";
	public String  txtProviderName =  "providerName";
	public String  txtFirstName1 = "//div[4]/div/div/div/div[2]/div/div/div/input";
	public String  btnAddButton =  "xpath=(//button[@id='add'])[2]";
	public String  btnSearchorg =  "//div[2]/div[2]/div/div/a";
	public String  btnDeleteUser = "//div[2]/div/div/div[3]/div/div[2]/table/tbody/tr/td[2]/div/a";
	public String  txtProFirstName = "searchTextBoxUserView";
	public String  txtPracFirstName ="xpath=(//input[@id='searchTextBox'])[4]";
	public String  txtProFirstName1 = "xpath=(//input[@id='searchTextBox'])[5]";
	public String  txtProFirstName2 = "xpath=(//button[@type='button'])[10]";
	public String btnActivateORANGE = "ActivateUserORANGE";
	public String lnkActivate = "link=Activate";
	public String getDepartmentCount ="departmentCount";
	public String getProgramCount ="programCount";

	public String  lnkSearchPractice = "//div[4]/div/div[2]/table/tbody/tr/td";
	public String  lblSusectionWidget =   "css=div.splitPanel45.marginRight30 > div.subSectionWidget";
	public String  lblTopMenu =   "css=span.topMenuItemSpan.light";
	public String  lnkUserLink =  "css=span.listText > span.large";
	
	public String  chkIncludeInactiveProviderscheckbox = "includeInactivesProviderViewcheckbox";
	public String  chkIncludeInactiveDepartmentsBox = "includeInactiveDepartmentscheckbox";
	public String txtUserName1 =  "//div[4]/div[2]/div";
	public String txtLastName1 =   "//div[@id='users']/table/tbody/tr/td";
	public String btnAddPractice = "addPractice";
	public String btnPracticeName ="practiceName";
	public String btnPracticeCode = "practiceCode";
	public String btnTaxId ="taxId";
	public String txtAddr2 ="addr2";
	public String txtAddr2Loc1 ="addr20";
	public String txtAddr2Loc2 ="addr21";
	public String txtAddr2Loc3 ="addr22";
	 public String txtAddr2Loc4 ="addr23";
	 public String txtPrimaryPhone ="primaryPhone";
	 public String txtOtherPhone1 = "ohterPhone1";
	 public String txtOtherPhone2 ="otherPhone2";
	 public String txtOtherPhone1Extn = "otherPhone1Extension";
	 public String txtOtherPhone2Extn = "otherPhone2Extension";
	 public String txtPrimaryPhoneExt ="primaryPhoneExtension";
	 public String txtBillingAddr1 = "billingAddr1";
	 public String txtBillingAddr2 = "billingAddr2";
	 public String txtGroupNpi ="groupNpi";
	 public String txtBillingStateSuggestBox =  "billingStateSuggestBoxsuggestBox";
	 public String txtBillingZip = "billingZip";
	 public String txtTaxRate = "taxRateTextbox";
	 public String ajxSLI="serviceLevelIndicatorSuggestBoxsuggestBox";
	 public String chkArticle16="locationArticle16checkbox";
	 public String chkArticle28="locationArticle28checkbox";
	 public String radOnSite16="article16OnSiteradio";
	 public String radOffSite16="article16OffSiteradio";
	 public String radOnSite28="article16OnSiteradio";
	 public String radOffSite28="article16OffSiteradio";
	 
	 public String ajxPracticeType = "practiceTypeSuggestBoxsuggestBox";
	 
	 public String txtAddLocationButton = "xpath=(//button[@type='button'])[5]";
	 public String txtLocationCode0= "locationCode0";

	 public String txtLocationDescription0=  "billingLocationNameTextbox";
	 public String txtLocationDescription1=  "locationDescription1";
	 public String txtLocationDescription3=  "locationDescription2";
	 public String txtLocationDescription4=  "locationDescription3";
	 public String txtLocationName="locationNameTextboxId";
	 public String txtLocationName0=  "//input[@id='locationNameTextboxId']";
	 public String txtLocationName1=  "locationName1";
	 public String txtLocationName3=  "locationName2";
	 public String txtLocationName4=  "locationName3";
	 public String txtCommType10SuggestBox = "commType1suggestBox";
	 public String txtCommType20SuggestBox = "commType2suggestBox";
	 public String txtCommType30SuggestBox =  "commType3suggestBox";
	 public String txtPrimaryPhone0 = "primaryPhone";
	 public String txtOhterPhone10 = "ohterPhone1";
	 public String txtOhterPhone20 = "otherPhone2";
	 public String txtOtherPhone1Extension0 =  "otherPhone1Extension";
	 public String txtOtherPhone2Extension0 = "otherPhone2Extension";
	 public String txtNpi0 =  "npi0";
	 public String txtAddr10 = "addr1";
	 public String txtAddr20 = "addr2";
	 public String txtCity0 = "city";
	 public String txtStateSuggestBox0suggestBox =  "stateSuggestBoxsuggestBox";
	 public String txtCountryBox0suggestBox = "countrySuggestBoxsuggestBox";
	 public String txtZip0 = "zip";
	 public String txtPrimaryPhoneExtension0 = "primaryPhoneExtension";
	 public String ajxBillingCountrySuggestBox = "billingCountrySuggestBoxsuggestBox";
	
	 public String  lnkSelectPeople = "selectPeople";
	 public String btnSearchPath = "//span/input";
	 public String lblPractice = "//div[@id='practices']/table/tbody/tr/td/div/span";
	 public String lblPractice1 = "//td[2]/div/div/div/div[2]/div/div";
			 
     // FIXME Tickets in Review 
	 public String lblPractice2 = "css=div.org-structure-child"; 
	
	 public String lnkDeletePractice= "//a[contains(@id,'DeletePractice')]";
	 public String lnkDeleteDepartment= "//a[contains(@id,'DeleteDepartment')]";
	 public String lnkDepartmentCount= "departmentCount";
	 public String lnkDeleteProgram= "//a[contains(@id,'DeleteProgram')]";
	 public String lnkDeleteProvider= "//a[contains(@id,'DeleteProvider')]";
	 public String lnkDeleteUser= "//a[contains(@id,'DeleteUser')]";
	 public String txtSearch2 = "//td[2]/div/div/div/div[2]/div/div";
	 public String lblProvider = "//div[@id='providers']/table/tbody/tr/td/div/span";
	 public String lblProvider1 = "//div[contains(@id,'practiceProviderItem')]";
	 public String lblUser1 = "//div[contains(@id,'practiceUserItem')]";
	 public String lblNormalSize =  "css=span.orangeFont.normalSize";
	 public String btnProviderAssociate ="//div[@id='practices']/table/tbody/tr/td[2]/div/a";
	 
	  public String vfyDelDepartment = "//div[3]/div[2]/div/div";
	  public String vfyDelPractice = "//td[2]/div/div/div/div[2]/div/div";
	  public String vfySearchDepartment = "//div[3]/div[2]/div";
	  public String vfySearchDepartment1 = "//div[@id='departments']/table/tbody/tr/td/div/span";
	  public String vfySearchDepartment2 = "//div[@id='departments']/table/tbody/tr/td[2]/div/a";
	  public String lblSearchDepartment = "//div[@id='departments']/table/tbody/tr[3]/td/div/span";
	  public String lblProgram = "css=span.gwt-InlineLabel";
	  public String txtStartDate = "startDate";
	  public String txtEndDate = "endDate";
	  public String txtDep =   "//div[@id='departments']/table/tbody/tr/td";
	  public String txtPassword =  "password";
	  
	  
	  public String ajxExternalEmrsuggestBox = "externalEmrsuggestBox";
	  public String ajxUserRolesuggestBox   = "userRolesuggestBox";
	  public String ajxRoleSuggestBox1suggestBox = "roleSuggestBox1suggestBox";
	  public String ajxRoleSuggestBox2suggestBox =  "roleSuggestBox2suggestBox";
	  public String ajxRoleSuggestBox3suggestBox = "roleSuggestBox3suggestBox";
	  public String ajxRoleSuggestBox4suggestBox = "roleSuggestBox4suggestBox";
	  public String ajxPracticeSuggestBox1 = "practiceSuggestBox1-1suggestBox";
	  public String ajxPractise = "xpath=(//input[@id='suggestBox'])[2]";
	  public String ajxPractiseName1 = "xpath=(//input[@id='searchTextBox'])[3]";
	  public String ajxPractise1 = "practiceSuggestBox2-1suggestBox";
	  public String ajxPractise2 = "practiceSuggestBox3-1suggestBox";
	  public String ajxPractise3 = "practiceSuggestBox4-1suggestBox";
	  
	  
	  
	  public String txtConfirmPassword="confirmPassword";
	  public String btnAddRole ="addRole";
	  public String btnDelete1 ="delete1";
	  public String btnDeleteTwo ="delete12";
	  public String btnDelete3 = "delete3";
	  public String btnDelete4 = "delete4";
	  public String btnAgree =  "agreeButton";
	  public String btnAssociatePayerRemove = "//div[@id='providers']/table/tbody/tr/td[3]/div/a";
	  public String btnEditAssociatePayer = "xpath=(//div[@id='providers']/table/tbody/tr/td[2]/div/a)[2]";
	  
	  public String lnkAddAssociatePayer = "xpath=(//button[@id='add'])[3]";
	  public String ajxPayerList="payerSearchSugguestBoxsuggestBox";
	  public String ajxEDIStatus = "billingEDIStatusSugguestBoxsuggestBox";
	  public String ajxAlernateProvider = "alternateProviderSugguestBoxsuggestBox";
	  
	  public String txtProviderId="payerProviderID";
	  public String txtGroupId ="groupID";
	  public String txtTaxonomy ="taxonomy";
	  public String APayerSave= "save";
	  public String APayerCancel = "cancel";
	  
	  
	  
	  public String lnkRemove =   "link=Remove";
	  public String lnkProgram =   "//div[@id='programs']/table/tbody/tr/td/div/div";
	  public String lnkSelectedProgram =  "//td[2]/div/div/div/div[3]/div/div";
	  public String lnkSelectedProgram1 = "//div[@id='programs']/table/tbody/tr/td/div/div/span";
	  public String lnkSelectedProgram2 = "//div[@id='programs']/table/tbody/tr/td[2]/div/a";
	  public String lnkSelectedProgram3 =  "//div[@id='providers']/table/tbody/tr/td/div/div/span";
	  public String lnkLocationMenuHeader = "locationMenuHeader";
	  public String lnkTestPractice = "TestPractice";
	 
	  public String chkSmokingSession =   "//div[2]/table/tbody/tr/td/span/input";
	  public String chkAvailableProgram = "//div[3]/table/tbody/tr/td/span/input";
	  public String chkItemName1 = "xpath=(//span[@id='itemName'])[2]";
	  public String chkItemName = "xpath=(//span[@id='itemName'])[3]";
	  public String chkProviderParticipates = "providerParticipatesInPayercheckbox";
	  public String chkProviderAccept = "providerAcceptsForPayercheckbox";
	  
	  
	  
	  
	  public String  tabDepartmentName =  "css=#departmentName";
	  public String  tabSuggestBox =   "css=#suggestBox";
	  public String  tabProgramName = "css=#programName";
	  public String  tabDescription =  "css=#description";
	  public String  tabPracticeName = "css=#practiceName";
	  public String  tabPracticeCode = "css=#practiceCode";
	  public String  tabTaxId = "css=#taxId";
	  public String  tabGroupNpi =  "css=#groupNpi";
	  public String  tabEmail =  "css=#email";
	  public String  tabCommType1suggestBox =  "css=#commType1suggestBox";
	  public String  tabPrimaryPhone =  "css=#primaryPhone";
	  public String  tabPrimaryPhoneExtn =   "css=#primaryPhoneExtension";
	  public String  tabCommType2suggestBox= "css=#commType2suggestBox";
	  public String  tabOhterPhone1 =  "css=#ohterPhone1";
	  public String  tabOhterPhone1Extn =   "css=#otherPhone1Extension";
	  public String  tabCommType3suggestBox= "css=#commType3suggestBox";
	  public String  tabOhterPhone2 =  "css=#ohterPhone2";
	  public String  tabOhterPhone2Extn =   "css=#otherPhone2Extension";
	  public String  tabCommentTextBoxId =  "css=#commentTextBoxIdcommentBoxId";
	 
	  public String tabAddr1 = "css=#addr1";
	  public String tabAddr2 = "css=#addr2";
	  public String tabCity =  "css=#city";
	  public String tabStateSuggestBox = "css=#stateSuggestBoxsuggestBox";
	  public String tabZip =  "css=#zip";
	  public String tabCountrySuggestBox= "css=#countrySuggestBoxsuggestBox";
	  public String tabBillingAddr1 ="css=#billingAddr1";
	  public String tabBillingAddr2 = "css=#billingAddr2";
	  public String tabBillingCity="css=#billingCity";
	  public String tabBillingStateSuggestBox = "css=#billingStateSuggestBoxsuggestBox";
	  public String tabBillingZip = "css=#billingZip";
	  public String  tabBillingCountrySuggestBox = "css=#billingCountrySuggestBoxsuggestBox";

	  public String  tabProviderTypesuggestBox = "css=#providerTypesuggestBox";
	  public String  tabExternalEmrsuggestBox =  "css=#externalEmrsuggestBox";
	  public String  tabPassword=  "css=#password";
	  public String  tabConfirmPassword = "css=#confirmPassword";
	  public String  tabRoleSuggestBox1suggestBox =   "css=#roleSuggestBox1suggestBox";
	  public String  tabPracticeSuggestBox1 =  "css=#practiceSuggestBox1-1suggestBox";
	  public String  tabAddCptButton1 = "css=#addCptButton1";
	  public String  tabRoleSuggestBox2suggestBox =   "css=#roleSuggestBox2suggestBox";
	  public String  tabPracticeSuggestBox2 =  "css=#practiceSuggestBox2-1suggestBox";
	  public String  tabAddCptButton2 = "css=#addCptButton2";
	  public String  tabStartDate = "css=#startDate";
	  public String  tabEndDate = "css=#endDate";
	  public String  tabProviderCode ="css=#providerCode";
	  public String  tabTitlesuggestBox ="css=#titlesuggestBox";
	  public String  tabLastName ="css=#lastName";
	  public String  tabFirstName ="css=#firstName";
	  public String  tabMiddleName ="css=#middleName";
	  public String  tabUserName = "css=#userName";
	  public String  tabCredentials ="css=#credentials";
	  public String  tabSpecialtysuggestBox ="css=#specialtysuggestBox";
	  public String  tabChosenSpecialties ="css=#chosenSpecialties";
	  public String  tabGendersuggestBox="css=#gendersuggestBox";
	  public String  tabLanguagesuggestBox ="css=#languagesuggestBox";
	  public String  tabChosenLanguagePanel ="chosenLanguagePanel";
	  public String  tabCellPhone ="css=#cellPhone";
	  public String  tabPager ="css=#pager";
	  public String  tabMaximumFTESuggestBoxsuggestBox ="css=#maximumFTESuggestBoxsuggestBox";
	  public String  tabHoursWorked ="css=#hoursWorked";
	  public String  tabcomments ="css=#comments";
	  public String  tabMailingStreet1 ="css=#mailingStreet1";
	  public String  tabMailingStreet2 ="css=#mailingStreet2";
	  public String  tabMailingCity ="css=#mailingCity";
	  public String  tabMailingStatesuggestBox ="css=#mailingStatesuggestBox";
	  public String  tabMailingZipPostalCode ="css=#mailingZipPostalCode";
	  public String  tabMailingCountrysuggestBox ="css=#mailingCountrysuggestBox";
	  public String  tabMailingOfficePhone ="css=#mailingOfficePhone";
	  public String  tabMailingOfficePhoneExt ="css=#mailingOfficePhoneExt";
	  public String  tabMailingFax ="css=#mailingFax";
	  public String  tabSameAsMailingAddresscheckbox="css=#sameAsMailingAddresscheckbox";
	  public String  tabBillingStreet1 ="css=#billingStreet1";
	  public String  tabBillingStreet2 ="css=#billingStreet2";
	  public String  tabBillingCity1 ="css=#billingCity";
	  public String  tabBillingStateSuggestBox1 ="css=#billingStatesuggestBox";
	  public String  tabBillingZipPostalCode ="css=#billingZipPostalCode";
	  public String  tabBillingCountrySuggestBox1 ="css=#billingCountrysuggestBox";	  
	  
	  public String btnAddAssociateUser="addAssociatedUsers";
	  public String txtAssociateUser="userSearchBox";
	  public String lblAssociateUser="//div[@id='practiceUsers']/table/tbody/tr/td/div/span/span";
	  
	  /// Security 
	  
	  public String lnkSecPractices = "//td/div/span";
	  public String lnkSecPractices1 ="//div[4]/div/div[2]/table/tbody/tr/td/div";
	  
	  public String txtPracticeProviderSearch ="practiceProvidersearchTextBox"; 
	

 	public String lnkSecProviders = "//div[3]/div/div[2]/table/tbody/tr[2]/td/div/div";
	  public String lnkSecProviders1 =  "//div[4]/div/div/div/div[2]/div/div/div/input";
	  public String lnkSecUsers = "//td/div/span/span";
	  public String btnCancel = "cancel";
	  
	  
	  // Patient Import
	  
	  public String txtPatientSearch =  "//form/div/div/div/input";
	  public String txtFstNameImpPatient =  "//div[10]/div/div[2]/div";
	  public String txtLstNameImpPatient =  "//div[11]/div/div[2]/div";
	  public String txtResultSection = "resultSection";
	  public String lnkImportPatientAction =  "importPatientAction";
	  public String lnkImportPatientActionCss = "css=#importPatientAction > span.actionItemSpan";
	  public String lnkImportChart ="!importChart";
	  public String lnkPatientOptions ="link=Patient Options";
	  public String lnkImpPatient =  "//div[2]/div/div/div/div/table/tbody/tr/td[2]/div/div[3]";
	  public String lnkImpPatient1 ="//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr[2]/td[2]/div[2]/div[5]/table/tbody/tr[2]/td[2]/div/div/div[2]/div/div/div[2]/span/label";
	  public String lnkImpPatient2 ="//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr[2]/td[2]/div[2]/div[5]/table/tbody/tr[2]/td[2]/div/div/div[2]/div/div/div/span/label";
	  
	  public String lblImportPatient =  "//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr/td[2]/div/div/div/div[2]/div/div/div/span/label";
	  public String lblImportPatient1 = "//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr[2]/td[2]/div[2]/div[5]/table/tbody/tr[2]/td[2]/div/div/div[2]/div/div/div[3]/span/label";
	  public String lblPatientOptionsExportChart = "patientOptionsExportChart";
	  
	  public String btnCancelBrowse = "cancelBrowseBtn";
	  public String btnImport =  "importBtn";
	  public String btnImportCancel = "cancelImportBtn";
	  public String txtSearchPatientBox = "searchPatientBox";
	  
	  public String VfyImportPatientAddress  = "//div[2]/div/div/div/div/div[3]/div/div[2]/div";
	  
	  public String getImportPatientAddress1  ="//div[3]/div/div[2]/div";
	  public String getImportPatientPrimaryPhone  = "//div[4]/div/div[2]/div";
	  public String getImportPatientHomePhone  = "//div[5]/div/div[2]/div";
	  public String getImportPatientVaccationPhone  = "//div[6]/div/div[2]/div";
	  public String getImportPatientBusinessPhone  = "//div[7]/div/div[2]/div";
	  public String getImportPatientMobilePhone  = "//div[8]/div/div[2]/div";
	  public String getImportPatientEmail  ="//div[9]/div/div[2]/div";
	  public String getImportPatientMname  ="//div[12]/div/div[2]/div";
	  public String getImportPatientSex  ="//div[13]/div/div[2]/div";
	  public String getImportPatientDOB  ="//div[14]/div/div[2]/div";
	  public String getImportPatientMaritalStatus  ="//div[15]/div/div[2]/div";
	  public String getImportPatientReligion  = "//div[16]/div/div[2]/div";
	  public String getImportPatientRace  =  "//div[17]/div/div[2]/div";
	  public String getImportPatientEthinity  ="//div[18]/div/div[2]/div";
	  
	  public String VfyImportPatientAddress1  ="patientAddress";
	  public String VfyImportPatientPrimaryPhone  = "patientPrimaryPhone";
	  public String VfyImportPatientHomePhone  = "patientHomePhone";
	  public String VfyImportPatientVaccationPhone  = "patientVacationPhone";
	  public String VfyImportPatientBusinessPhone  = "patientBusinessPhone";
	  public String VfyImportPatientMobilePhone  = "patientMobilePhone";
	  public String VfyImportPatientEmail  ="patientEmail";
	  public String VfyImportPatientMname  ="patientMiddleName";
	  public String VfyImportPatientSex  ="xpath=(//div[@id='patientSex'])[2]";
	  public String VfyImportPatientDOB  ="patientDOB";
	  public String VfyImportPatientMaritalStatus  ="patientMaritalStatus";
	  public String VfyImportPatientReligion  = "patientReligion";
	  public String VfyImportPatientRace  =  "patientRace";
	  public String VfyImportPatientEthinity  ="patientEthnicity";

	 
	 // Departmaent
	  
	  public String btnAddDepartment =  "addDepartment";
	  public String lnkDepartment1 =   "//div[2]/div/div/div[4]/div/div[2]/table/tbody/tr/td/div/span";
	  public String txtDepartmentName = "departmentName";
	  public String txtDepartmentSearch = "searchTextBoxDepartmentView";
	  public String btnDepartmentSearch = "xpath=(//button[@type='button'])[6]";
	  public String btnDepartmentSearchWithSearchText="searchButtonDepartmentView"; 
	  
	  
	  
	//Verify Store Value in Summary page 
	
	public String vfyStoreValinSummaryPage = "//div[@id='adminAddressBookListView']/table/tbody/tr/td/div";
	public String vfyStoreValinSummaryPageDirctories = "//div[2]/div/div/div/div[2]/table/tbody/tr/td/div";
	
	public String vfyStoreValinpharmacyName = "//div[2]/div[2]/div[2]/div/div/div/div";
	public String vfyStoreValinComments = "//div[2]/div[2]/div/div[2]";
	public String vfyStoreValinStreets ="//div[2]/div[2]/div/div[3]";
	public String vfyStoreValinCountry = "//div[2]/div[2]/div/div[3]";
	public String vfyStoreValinZipCode = "//div[2]/div[2]/div/div[3]";
	public String vfyStoreValinSalutation ="//div[2]/div/div[4]";
	public String vfyStoreValinLastName = "//div[2]/div/div[4]";
	public String vfyStoreValinFirstName = "//div[2]/div/div[4]";
	public String vfyStoreValinPhone = "//div[2]/div/div[5]";
	public String vfyStoreValinTelephoneExtnNo1= "//div[2]/div/div[5]";
	public String vfyStoreValinFax = "//div[2]/div/div[6]";
	public String vfyStoreValinEmail = "//div[7]";
	
	public String vfyStoreExternalProvider = "xpath=(//div[@class='search-split-panel-content'])[2]";
	public String vfyStoreExternalProvider1 = "//span/div";
	public String vfyStoreExternalProvider2 = "css=div.right-search-split-panel-wrapper > div.search-split-panel-content";
	public String vfyStoreExternalProvider3 = "css=span.gwt-InlineHTML > div.marginTop15";
	
	public String vfyStoreValinWebAddress ="//div[8]";
	public String vfyStoreValinHealthcare =  "//div[@id='AdminHealthcareList']/table/tbody/tr/td";		
	public String vfyStoreValinHealthcare1 = "//div[@id='AdminHealthcareList']/table/tbody/tr/td[2]/div/a";
	public String vfyStoreValinHealthcareNote = "//span/div[2]/div";
	public String vfyStoreValinHealthcareName = "//div[2]/div[2]";
	
	public String vfyStoreValinHealthcareName1 = "//div[2]/div/span";
	public String vfyStoreEnterprise = "//div[@id='EnterpriseIDList']/table/tbody/tr/td[2]/div/span";
	public String vfyStoreEnterprise1 = "//div[@id='EnterpriseIDList']/table/tbody/tr[2]/td[2]/div/span";
	public String vfyStoreIdGroup = "//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td/div";
	public String vfyStoreIdGroup1 = "//div[@id='AdminIdentifierGroupList']/table/tbody/tr[2]/td/div";
	
	public String vfyStoreIdGroupType = "//div[@id='AdminIdentifierTypeList']/table/tbody/tr/td/div";
	public String vfyStoreIdGroupType1 = "//div[2]/div[3]";
	public String vfyStoreIdGroupType2 ="//div[2]/div[2]";
	public String vfyStoreIdGroupType3 ="//span[3]";
	public String vfyStoreIdGroupType4 = "//tr[2]/td/div/span/div/span[3]";
	
	public String vfyStoreValinSummary =   "//td[2]/div/div/div/div/div";
	
	
	// verifySelectOptionForAddressBook
	
	public String lstItemSelected ="css=div.item-selected";
	public String lstSuggestBoxOracle ="css=div.gwt-PopupPanel.localizedSuggestBoxOracle";
	
	

    public String chkBillingLocation =   "billingLocationNamecheckbox";
    public String btnNextOne = "xpath=(//button[@type='button'])[2]";
   
    public String chkCentralisedBilling =   "centralizedBillingAddressCheckboxcheckbox";
    public String chkNextRadio="//div[@id='BlueNavigationWiget_MainPanel']/div[2]/div[2]/a";
    public String chkCentralised = "centralizedBillingAddressCheckboxcheckbox";
    public String btnDonePractice = "css=button.primary-button.left-button-spacer";	
    public String btnLocationCancel= "xpath=(//button[@type='button'])[8]";
    public String txtnpi = "npiNumber";
    public String txtStatement = "billingStatement";
    
    public String lnkLocationEdit = "link=Edit";
    public String btnLocationSave = "css=div.second-level-header-top-right > button.secondary-button.left-button-spacer";
    public String btnPlan = "//div[@id='BlueNavigationWiget_MainPanel']/div[2]/div[3]/a";
    public String lnkScheduling = "schedulingSettingsAction";
    public String lblLocationHoursDisplay="LocationHoursList";
    public String lblLocationDetails = "//div[@id='AdminUserRoleList']/table/tbody/tr/td/div/span/div";
    public String lblLocationDet= "//div[@id='AdminUserRoleList']/table/tbody/tr/td/div/span/div[2]";
    public String txtStartHour="defaultStartTime-hour";
    public String txtMammo ="mammographyCertificationId";
    public String btnSaveLocation = "saveLocationHours";
    public String chk24HrFormat = "useMilitaryTimecheckbox";
    public String chkSchedul = "schedulingAppointmentsFlagcheckbox";
    public String chkLocationLab="labFlagcheckbox";
    public String txtCLIANum="cliaNumber";
    public String lnkShowMoreIdentifierType="AdminIdentifierTypeListMoreLink";
    public String lnkShowMoreIdentifierGroup="AdminIdentifierGroupListMoreLink";
    
	public String lblInsuranceBalance ="//div[4]/div[2]/span";
	public String lblPatientBalance ="//div[3]/div[2]/span";
	public String btnPatientOtherPayers = "!patientOtherPayers";
	

	/**
	 * goToNewPatientCheckIn
	 * function to navigate to new patient check in page
	 * @since  	     Feb 08, 2012
	 */	
	public boolean goToNewPatientCheckIn(Selenium selenium) {
		boolean returnValue = false;
		waitForElement(selenium, lnkNewPatientCheckIn , 4000);
		if (selenium.isElementPresent( lnkNewPatientCheckIn )) {
			int i = 0;
			while (!selenium.isElementPresent("referredBysuggestBox")) {
				if (i == 10)
					break;
				try {
					i++;
					click(selenium, lnkNewPatientCheckIn );
					Thread.sleep(900);
				} catch (Exception e) {
					System.out.println(e.toString());
					break;
				}
			}
			if (selenium.isElementPresent("referredBysuggestBox")) {
				returnValue = true;
			}
		}
		return returnValue;
	}
	
	
	
	/**
	 * createConsents_UnitTest
	 * function to create Consents UnitTest
	 * @since  	     May 17, 2012
	 */	
	
		public boolean createConsents_UnitTest(Selenium selenium,SystemsSettingsUnitTest consentData){
			try{
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxConsentSuggestBox,consentData.consentType);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtConsentName,consentData.consentName),"Could not enter the consent name; More Details :" + consentData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtValidNum,consentData.validFor),"Could not the valid for; More Details"+consentData.toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,txtValidNumber,consentData.validType);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxRestrictionLevel,consentData.restractionLevel);
				waitForPageLoad(selenium);
				/*if((consentData.testCaseId.equalsIgnoreCase("TC_SSCON_006")||consentData.testCaseId.equalsIgnoreCase("TC_SSCON_007")||
					consentData.testCaseId.equalsIgnoreCase("TC_SSCON_008")||consentData.testCaseId.equalsIgnoreCase("TC_SSCON_009")))*/
			    assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ consentData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(selenium.isTextPresent("Add New Consent Form" )){
					return true;
				}else{
					return false;
				}
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		}


	/**
	 * createConsents
	 * function to create Consents 
	 * @since  	     May 18, 2012
	 */	
	 public boolean createConsents(Selenium selenium,SystemSettingsLib consentData){
			try{
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxConsentSuggestBox,consentData.consentType);
				
				assertTrue(type(selenium,txtConsentName,consentData.consentName),"Could not enter the consent name; More Details :" + consentData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtValidNum,consentData.validFor),"Could not the valid for; More Details"+consentData.toString(),selenium, ClassName, MethodName);
				select(selenium,txtValidNumber,consentData.validForType);
				
				selectValueFromAjaxList(selenium,ajxRestrictionLevel,consentData.restrictionLevel);
				
				assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ consentData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,btnConsent)){
					return true;
				}else{
					return false;
				}
			}catch(Exception e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + consentData.toString());		
				return false;
			}
		}
	/**
	 * enterpriseVariable_Consents
	 * function to enterprise Variable Consents 
	 * @since  	     May 18, 2012
	 */	
	 public boolean enterpriseVariable_Consents(Selenium selenium,SystemSettingsLib epData) throws IOException{
			try{
				assertTrue(click(selenium,lnkEnterpriseVariables),"Could not click on Identifier Group link:" + epData .toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				type(selenium,txtSearchBox,epData.consentType);
				click(selenium, btnSearchBox);
				waitForPageLoad(selenium);
				click(selenium,lnkDelete );
				waitForPageLoad(selenium);
				click(selenium, btnYes);
				assertTrue(click(selenium, btnAddenterprise),"Could not click on Add Identifier Group link:" + epData.toString(),selenium, ClassName, MethodName);
				
				selectValueFromAjaxList(selenium,ajxSuggestBox,epData.consentValue);
				waitForPageLoad(selenium);
				type(selenium,txtVariableBox,epData.consentType);		
				click(selenium, btnSave);
				
				if(isElementPresent(selenium, "errorCloseButton"))
					assertTrue(click(selenium, "errorCloseButton"),"Could not click Close button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			return true;
				
				
				
			}catch(RuntimeException e){
				e.printStackTrace();
				return false;
			}
		}
			
	
	/**
	 * editConsents
	 * function to edit Consents 
	 * @since  	     May 18, 2012
	 */	
	 public boolean editConsents(Selenium selenium,SystemSettingsLib consentData){
			try{
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxConsentSuggestBox,consentData.consentType);
				
				assertTrue(type(selenium,txtConsentName,consentData.consentName),"Could not enter the consent name; More Details :" + consentData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtValidNumInEdit,consentData.validFor),"Could not the valid for; More Details"+consentData.toString(),selenium, ClassName, MethodName);
				select(selenium,txtValidNumberInEdit,consentData.validForType);
				
				selectValueFromAjaxList(selenium,ajxRestrictionLevel,consentData.restrictionLevel);
				
				assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ consentData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(selenium.isTextPresent("Consent Forms")){
					return true;
				}else{
					return false;
				}
			}catch(Exception e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + consentData.toString());		
				return false;
			}
		}
	 
	 /**
	 * createExternalProvider
	 * function to create an External Provider
	 * @since  	     May 17, 2012
	 */	
	 
	 
	 public boolean createExternalProvider(Selenium selenium, SystemSettingsLib providerData,String uniqueNo,String account) throws IOException {
			
			try{
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtReferringCode,providerData.referringCode+uniqueNo),"Could not type referring code; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtLastName,providerData.lastName),"Could not type last name; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtFirstName,providerData.firstName),"Could not type first name; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtMiddleInitials ,providerData.middleInitial),"Could not type middle initial; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtCredentials,providerData.credentials),"Could not type credentials; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtStateLicNum,providerData.licenseNum),"Could not type license number; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium, ajxReportMethod,providerData.reportMethod);
				selectValueFromAjaxList(selenium, ajxSpecialtySuggestBox,providerData.specialty);
				
				if(providerData.billingExclusionCheck.equals("yes")){
					if(!selenium.isChecked( chkBillingExBox))
						assertTrue(click(selenium, chkBillingExBox),"Could not check billing Exclusion Checkbox; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				}
				if(providerData.picosEnrolledCheck.equals("yes")){
					if(!selenium.isChecked(chkPecoscheckbox ))
						click(selenium,chkPecoscheckbox );
				}
				
				type(selenium,txtUpin,providerData.upin);
				type(selenium,txtNpi,providerData.npi);
				type(selenium,txtTaxonomyCode,providerData.taxonomyCode);
				assertTrue(type(selenium,txtComments,providerData.comments),"Could not type comments; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtPracticeName1,providerData.practiceName1),"Could not type practice name; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtEpstreet11 ,providerData.epstreet11),"Could not type street name1; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtEpstreet12,providerData.epstreet12),"Could not type street name2; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtEpcity1 ,providerData.epcity1),"Could not type city name; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				if(account.equals(CAAccount)){
					selectValueFromAjaxList(selenium,ajxEpstate1,providerData.state2CA);
					waitForPageLoad(selenium);
				    assertTrue(type(selenium,txtEpzipcode1,providerData.zipcodeCa),"Could not type zipcode; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				}else {
					selectValueFromAjaxList(selenium,ajxEpstate1,providerData.epstate1);
					waitForPageLoad(selenium);
					assertTrue(type(selenium,txtEpzipcode1,providerData.epzipcode1),"Could not type zipcode; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				}
					click(selenium,btnNO);
				selectValueFromAjaxList(selenium,ajxEpCountry1,providerData.epcountry1);
				assertTrue(type(selenium,txtEpPhone1,providerData.epphone1),"Could not type phone number1; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				//Assert.assertTrue(type(selenium,txtEpExtn1,providerData.epextn1),"Could not type extn number1; More Details"+providerData.toString());
				assertTrue(type(selenium,txtEpFax1,providerData.epfax1),"Could not type fax number1; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtEpEmail1,providerData.epemail1),"Could not type email; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				if(providerData.testCaseId.equalsIgnoreCase("TC_EP_003")){
					assertTrue(click(selenium, btnAddAddressBtn), "Could not click Add Another Address Button"+providerData.toString(),selenium, ClassName, MethodName);
					assertTrue(type(selenium, txtPracticeName2,providerData.practiceName2),"Could not type practice name; More Details"+providerData.toString(),selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtEpstreet21 ,providerData.epstreet21),"Could not type street name1; More Details"+providerData.toString(),selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtEpstreet22 ,providerData.epstreet22),"Could not type street name2; More Details"+providerData.toString(),selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtEpcity2,providerData.epcity2),"Could not type city name; More Details"+providerData.toString(),selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,ajxEpstate2,providerData.epstate2);
					if(account.equals(CAAccount)){
						assertTrue(type(selenium, txtEpzipcode2,providerData.zipcodeCa1),"Could not type zipcode; More Details"+providerData.toString(),selenium, ClassName, MethodName);
					}else
						assertTrue(type(selenium, txtEpzipcode2,providerData.epzipcode2),"Could not type zipcode; More Details"+providerData.toString(),selenium, ClassName, MethodName);
					click(selenium,btnNo);
					selectValueFromAjaxList(selenium,ajxEpCountry2,providerData.epcountry2);
					assertTrue(type(selenium, txtEpPhone2,providerData.epphone2),"Could not type phone number1; More Details"+providerData.toString(),selenium, ClassName, MethodName);
					//Assert.assertTrue(type(selenium,txtEpExtn2,providerData.epextn2),"Could not type extn number1; More Details"+providerData.toString());
					assertTrue(type(selenium,txtEpFax2,providerData.epfax2),"Could not type fax number1; More Details"+providerData.toString(),selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtEpEmail2,providerData.epemail2),"Could not type email; More Details"+providerData.toString(),selenium, ClassName, MethodName);
					assertTrue(click(selenium, rdoPrimaryAddress),"Could not Check Primary Address Radio Button",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnDeleteProvider), "Could not click delete button",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				if(account.equals(CAAccount)){
					selectValueFromAjaxList(selenium,ajxEpstate1,providerData.state2CA);
					waitForPageLoad(selenium);
					assertTrue(type(selenium,txtEpzipcode1,providerData.zipcodeCa),"Could not type zipcode; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				}else {
					selectValueFromAjaxList(selenium,ajxEpstate1,providerData.epstate1);
					waitForPageLoad(selenium);
					assertTrue(type(selenium,txtEpzipcode1,providerData.epzipcode1),"Could not type zipcode; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				}
					click(selenium,btnNO);
					waitForPageLoad(selenium);
				assertTrue(click(selenium,btnsaveProvider),"Could not click save button; More details"+ providerData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			    
				if(!providerData.testCaseId.equals("TC_EP_004")){
					if(!isElementPresent(selenium, lnkAddReferringProvider)){
						return false;
					}else{
						return true;
					}
				}else
					return true;
			 }
			catch(RuntimeException e){
				e.printStackTrace();
				return false;
			}
		}





	/**
	 * deleteAllExternalProvider
	 * function to deleteAllExternalProvider
	 * @since  	     APR 09, 2012
	 */
	 public boolean deleteAllExternalProvider(Selenium selenium) throws IOException{
			waitForPageLoad(selenium);
			boolean providerDeleted = true;
			int procedureCount ;
			try{
		
				waitForElement(selenium,lnkexternalProviderDel, WAIT_TIME);
				/*while((Integer) selenium.getXpathCount( lnkexternalProviderDel) > 0){
					waitForPageLoad(selenium);
					caseCount = (Integer) selenium.getXpathCount( lnkexternalProviderDel);
					Assert.assertTrue(click(selenium, lnkexternalProviderDel));
					waitForPageLoad(selenium);
					Assert.assertTrue(click(selenium,btnYes));
					waitForPageLoad(selenium);
				//	if(caseCount == (Integer) selenium.getXpathCount("//div[@id='AdminReferringProviderList']/table/tbody/tr/td[2]/div/a")){
					if(caseCount == (Integer) selenium.getXpathCount( lnkexternalProviderDel1)){
						providerDeleted = false;
						break;
					}
				}*/
				
				int deleteCount = (Integer) selenium.getXpathCount(lnkexternalProviderDel);
				for(procedureCount = 1;procedureCount<= deleteCount;  procedureCount++){
					assertTrue(click(selenium, lnkexternalProviderDel),"Could not clik the Delete button",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium, btnYes),"Could not click the yes button;More Details:",selenium, ClassName, MethodName);
				}
				
				
				return providerDeleted;
			}catch (RuntimeException e) {
				e.printStackTrace();
				return false;
			}
		}

	/**
	 * createHealthCareTeam
	 * function to create a HealthCare Team 
	 * @since  	     May 21, 2012
	 */	
	
	 public boolean createHealthCareTeam(Selenium selenium, SystemSettingsLib HealthCareData,String uniqueName) throws IOException{
			
			try{
				if(HealthCareData.global.equals("Yes")){
					    assertTrue(click(selenium,rdGlobalHealth),"Could not click the globle ration button;More details:"+HealthCareData.toString(),selenium, ClassName, MethodName);
				}
				else{
						assertTrue(click(selenium,rdLocalHealth),"Could no click the radio button: More details"+HealthCareData.toString(),selenium, ClassName, MethodName);
				}
				assertTrue(type(selenium,txtTeamName,HealthCareData.teamName+uniqueName), "Could not enter the Team Name;More deatils:"+HealthCareData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtNotes,HealthCareData.notes),"Could not enter the Notes;More details:"+HealthCareData.toString(),selenium, ClassName, MethodName);
			    assertTrue(click(selenium,btnAddMember),"Could not click the Add member button"+HealthCareData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxName1,HealthCareData.name1);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxRole1,HealthCareData.role1);
				
				waitForPageLoad(selenium);
				if(HealthCareData.chartsChecxBox.equals("Yes")){
					assertTrue(click(selenium,chkChartCheckBox1),"Could not click the chart check box; More details:"+ HealthCareData.toString(),selenium, ClassName, MethodName);
				}
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnSaveHealth ),"Could not click save button;More details:"+HealthCareData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(selenium.isTextPresent(HealthCareData.teamName+uniqueName), "Health Care Team Not Created",selenium, ClassName, MethodName);
				return true;
				
				/*if(isElementPresent(selenium,lblTitle)){
					return true;
				}else{
					return false;
				}*/
			}catch(RuntimeException e){
				e.printStackTrace();
				return false;
			}
			
		}
	 /**
		 * createHealthCareTeamWithManyMembers
		 * function to create a HealthCare Team 
		 * @since  	     Sep 12, 2012
		 */	
		
		 public boolean createHealthCareTeamWithManyMembers(Selenium selenium, SystemSettingsLib HealthCareData,String uniqueName) throws IOException{
				
				try{
					if(HealthCareData.global.equals("Yes")){
						assertTrue(click(selenium,rdGlobal),"Could not click the globle ration button;More details:"+HealthCareData.toString(),selenium, ClassName, MethodName);
					}
					else{
							assertTrue(click(selenium,rdLocal),"Could no click the radio button: More details"+HealthCareData.toString(),selenium, ClassName, MethodName);
					}
				    assertTrue(type(selenium,txtTeamName,HealthCareData.teamName+uniqueName), "Could not enter the Team Name;More deatils:"+HealthCareData.toString(),selenium, ClassName, MethodName);
				    assertTrue(type(selenium,txtNotes ,HealthCareData.notes),"Could not enter the Notes;More details:"+HealthCareData.toString(),selenium, ClassName, MethodName);
				    assertTrue(click(selenium,btnAddMember),"Could not click the Add member button"+HealthCareData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(selectValueFromAjaxList(selenium,ajxName1,HealthCareData.name1),"Could not select"+HealthCareData.toString(),selenium, ClassName, MethodName);
					//waitForPageLoad(selenium);
					assertTrue(selectValueFromAjaxList(selenium,ajxRole1,HealthCareData.role1),"Could not select"+HealthCareData.toString(),selenium, ClassName, MethodName);
					
				    assertTrue(click(selenium,btnAddMember),"Could not click the Add member button"+HealthCareData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					 assertTrue(selectValueFromAjaxList(selenium,ajxName2,HealthCareData.name2), "Could not select seconf name"+HealthCareData.toString(),selenium, ClassName, MethodName);
					//waitForPageLoad(selenium);
					 assertTrue(selectValueFromAjaxList(selenium,ajxRole2,HealthCareData.role1),"Could not click the Add member button"+HealthCareData.toString(),selenium, ClassName, MethodName);
					//waitForPageLoad(selenium);
					if(HealthCareData.chartsChecxBox.equals("Yes")){
						  assertTrue(click(selenium,"//div[2]/span/input"),"Could not click the chart check box; More details:"+ HealthCareData.toString(),selenium, ClassName, MethodName);
					}
					waitForPageLoad(selenium);
					   assertTrue(click(selenium,"saveHealthcareTeam"),"Could not click save button;More details:"+HealthCareData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					
					   assertTrue(selenium.isTextPresent("Healthcare Team Administration"),"Could not click save button;More details:"+HealthCareData.toString(),selenium, ClassName, MethodName);
					
				}catch(RuntimeException e){
					e.printStackTrace();
					return false;
				}
				
				return true;
			}


	/**
	 * deleteAllHCT
	 * function to delete All HCT
	 * @since  	     APR 09, 2012
	 */
	 public boolean deleteAllHCT(Selenium selenium,SystemSettingsLib epData) throws IOException{
			boolean hCTDeleted = true;
			int hctCount = 0;
			try{
			waitForPageLoad(selenium);
			    assertTrue(type(selenium,txtSearchBox,epData.teamName),"Could not type the first name; More Details"+epData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnSearchBox),"Could not click the search button"+epData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				waitForElement(selenium, lnkAdminHealthcareDel, WAIT_TIME);
				while((Integer) selenium.getXpathCount( lnkAdminHealthcareDel) > 0){
					hctCount = (Integer) selenium.getXpathCount( lnkAdminHealthcareDel);
					assertTrue(click(selenium, lnkAdminHealthcareDel),"Could not click the Link button in healthcare",selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,txtSuggestBox,epData.reasonForDelete);
					click(selenium,"//div[5]/div/div/div/div/div");
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnDeleteHealth),"Could not click the Delete button ",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					if(hctCount == (Integer) selenium.getXpathCount( lnkAdminHealthcareDel)){
						hCTDeleted = false;
						break;
					}
				}
				return hCTDeleted;
			}catch (RuntimeException e) {
				e.printStackTrace();
				return false;
			}
		}
	
	/**
	 * createAdminEnterPriseVariable
	 * function to create Admin EnterPriseVariable
	 * @throws IOException 
	 * @since  	    Aug 21, 2012
	 */	
	public boolean createAdminEnterPriseVariable(Selenium selenium,SystemSettingsLib epData) throws IOException{
		boolean returnValue = false;
		try{
			assertTrue(click(selenium,lnkEnterpriseVariables),"Could not click on Identifier Group link:" + epData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			type(selenium,txtSearchBox,epData.roleValue);
			click(selenium,btnSearchBox );
			waitForPageLoad(selenium);
			click(selenium,lnkDelete);
			waitForPageLoad(selenium);
			click(selenium,btnYes);
			assertTrue(click(selenium,btnAddenterprise),"Could not click on Add Identifier Group link:" ,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxSuggestBox,epData.role);
			waitForPageLoad(selenium);
			type(selenium,txtVariableBox,epData.roleValue);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			
			type(selenium,txtSearchBox,epData.reasonForDelete);
			click(selenium,btnSearchBox );
			waitForPageLoad(selenium);
			click(selenium,lnkDelete);
			waitForPageLoad(selenium);
			click(selenium,btnYes);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddenterprise),"Could not click on Add Identifier Group link:" + epData.toString() ,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxSuggestBox,epData.deleteValue);
			waitForPageLoad(selenium);
			type(selenium,txtVariableBox,epData.reasonForDelete);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return returnValue;
			
		}
	}
	
	/**
	 * createAddressBook
	 * function to create Address Book
	 * @since  	     May 21, 2012
	 */	
	public boolean createAddressBook(Selenium selenium, SystemSettingsLib providerData, String userAccount) throws IOException {
		try{
			if(providerData.contactLevel.equalsIgnoreCase("Global"))
			{
				assertTrue(click(selenium,rdGlobal), "could not click contact level",selenium, ClassName, MethodName);
			}
			else{
			    assertTrue(click(selenium, rdLocal), "could not click contact level",selenium, ClassName, MethodName);
			}
				
			selectValueFromAjaxList(selenium, ajxContactSuggestBox, providerData.contactType);
		    assertTrue(type(selenium, txtAddContactCompany, providerData.contactCompany),"Could not Enter the Company;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxTitleSuggestBox,providerData.salutation);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,  txtAddBookLastName, providerData.lastName),"Could not enter Last Name; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkFirstName, providerData.firstName),"Could not enter First Name; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkMiddleName,providerData.middleName),"Could not enter the Middle name;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			
			assertTrue(type(selenium, txtJobtitle,providerData.jobTitle),"Could not Enter the Job Name;More Details"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkDepartment, providerData.department),"Could not enter Department; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxCommTy1suggestBox,providerData.telephoneType1);
			assertTrue(type(selenium, txtAddBkPrimaryPhone, providerData.telephoneNo1),"Could not enter primary phone number; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkPrimaryPhoneExt, providerData.telephoneextnNo1),"Could not enter primary extn number; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
		    assertTrue(type(selenium, txtAddBkAdd1,providerData.address1),"Could not enter the Street1;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddrBkAdd2,providerData.address2),"Could not enter the Street2;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkCity, providerData.city),"Colud not enter the city;More Details"+providerData.toString(),selenium, ClassName, MethodName);
			
			if(userAccount.equalsIgnoreCase(CAAccount)){				
				selectValueFromAjaxList(selenium, ajxAddBkStateSuggestBox,providerData.stateCA);
			    assertTrue(type(selenium, txtAddBkZipCode, providerData.zipcodeCa),"Could not enter Zip; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
				
			}
			else{				
				selectValueFromAjaxList(selenium, ajxAddBkStateSuggestBox,providerData.state);
				assertTrue(type(selenium, txtAddBkZipCode, providerData.zipcode),"Could not enter Zip; More Details:" + providerData.toString(),selenium, ClassName, MethodName);			
			}
			
			selenium.keyPress(cmbAddBkCountrySuggestBox, "\\9");
			waitForPageLoad(selenium);
			click(selenium,btnYesbutton);
			selectValueFromAjaxList(selenium, ajxaddBkCountrySuggestBox,providerData.country);
			assertTrue(type(selenium, txtAddBkEmail,providerData.email),"Could not Enter the Mail;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,  txtAddBkWebAdd,providerData.webAddress),"Could not enter the Web Address;Mor Details"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtcmt,providerData.comments),"Could not type the Comments; More Details"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnAddSave),"Could not find save button; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(selenium.isTextPresent("Manage Address Book")){
				return true;
			}else{
				return false;
				}
			}
			catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString());
			return false;
		}
	}

	/**
	 * NoAccessUserSystemSetting
	 * function to No Access User System Settings
	 * @throws IOException 
	 * @since  	     August 30, 2013
	 */	
	public boolean noAccessUserSystemSetting(Selenium selenium, SystemSettingsLib adminAddrData, String userAccount) throws IOException {
		try{
			
			if(isElementPresent(selenium, btnErrorClose)) {
				 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 }
			 
	    	 assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
	         waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose)) {
				 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 }
			assertTrue(!selenium.isElementPresent(lnkSystemSettingLink),"System Setting Link is Visible",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			return true;
		}
		
			catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + adminAddrData.toString());
			return false;
		}
	}
	
	
	
	
	
	/**
	 * NoAccessMixSecuritySystemSetting
	 * function to No Access MixSecurity System Settings
	 * @throws IOException 
	 * @since  	     Feb 19, 2014
	 */	
	public boolean noAccessMixSecuritySystemSetting(Selenium selenium, SystemSettingsLib adminAddrData, String userAccount) throws IOException {
		try{
			
			if(isElementPresent(selenium, btnErrorClose)) {
				 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 }
			assertTrue(click(selenium,lnkSettings),"Could not click on the link" + adminAddrData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, btnErrorClose)) {
				 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 }
		
			assertTrue(click(selenium,lnkSystemSettingLink),"Could not click the systemSettings link;More Deatils:"+adminAddrData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose)) {
				 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 }
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			return true;
		}
		
			catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + adminAddrData.toString());
			return false;
		}
	}
	
	/**
	 * FullViewAccessUserSystemSetting
	 * function to Full View Access User System Settings
	 * @throws IOException 
	 * @since  	     August 30, 2013
	 */	
	public boolean fullViewAccessUserSystemSetting(Selenium selenium, SystemSettingsLib adminAddrData, String userAccount) throws IOException {
		try{
			 if(isElementPresent(selenium, btnErrorClose)) {
				 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 }	
			 
	    	  assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
	          waitForPageLoad(selenium);
			 	 
		   	assertTrue(click(selenium,lnkSystemSettingLink),"Could not click the systemSettings link;More Deatils:"+adminAddrData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 if(isElementPresent(selenium, btnErrorClose)) {
				 assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			 }
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
				
			return true;
		}
		
			catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + adminAddrData.toString());
			return false;
		}
	}
	
	/**
	 * noAccessUserSecuritySetting
	 * function to No Access User Security Settings
	 * @throws IOException 
	 * @since  	     August 30, 2013
	 */	
	public boolean noAccessUserSecuritySetting(Selenium selenium, SystemSettingsLib adminAddrData, String userAccount) throws IOException {
		try{
			
			
			assertTrue(click(selenium,lnkQuickLink),"Could not click on the link" + adminAddrData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(!selenium.isElementPresent(lnkSecuritySetting),"Security Setting Link is Visible",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			return true;
		}
		
			catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + adminAddrData.toString());
			return false;
		}
	}
	
	
	/**
	 * fullViewAccessUserSecuritySetting
	 * function to Full View Access User System Settings
	 * @throws IOException 
	 * @since  	     August 30, 2013
	 */	
	public boolean fullViewAccessUserSecuritySetting(Selenium selenium, SystemSettingsLib adminAddrData, String userAccount) throws IOException {
		try{
			
			assertTrue(click(selenium,lnkQuickLink),"Could not click on the link" + adminAddrData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,lnkSecuritySetting),"Could not click the Security Settings link;More Deatils:"+adminAddrData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			
			return true;
		}
		
			catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + adminAddrData.toString());
			return false;
		}
	}
	
	/**
	 * deleteAllContact
	 * function to delete All Contact
	 * @since  	    Aug 14, 2012
	 */
	public boolean deleteAllContact(Selenium selenium){
		boolean contactDeleted = true;
		int contactCount = 0;
		try{
			waitForElement(selenium, "//div[@id='PatientContactList']/table/tbody/tr/td[3]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='PatientContactList']/table/tbody/tr/td[3]/div/a") > 0){
				contactCount = (Integer) selenium.getXpathCount("//div[@id='PatientContactList']/table/tbody/tr/td[3]/div/a");
				try {
					assertTrue(click(selenium,"//div[@id='PatientContactList']/table/tbody/tr/td[3]/div/a"),"Could not click patient contact",selenium, ClassName, MethodName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					assertTrue(click(selenium,btnYes),"Could not click Yes button",selenium, ClassName, MethodName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				waitForPageLoad(selenium);
				if(contactCount == (Integer) selenium.getXpathCount("//div[@id='PatientContactList']/table/tbody/tr/td[3]/div/a")){
					contactDeleted = false;
					break;
				}
			}
			return contactDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 *switchrole
	 * Function to switch role
	 * @throws IOException 
	 * @since  	    Oct 12, 2012
	 */	
	
	public boolean switchroleSecondTime(Selenium selenium,SystemSettingsLib dirData) throws IOException{
		try{
			assertTrue(isElementPresent(selenium,lnkTopMenu),"Could not fine the link;More Details:"+dirData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkTopMenu),"Could not click the top Menu Header;More Details:"+dirData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//Assert.assertTrue(click(selenium,lblEncounterData),"Could noy click the switch role;More Details:"+historyData.toString());
			assertTrue(click(selenium,"switchRoleAction"),"Could not click the switch role;More Details:"+dirData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxRxProvider,dirData.switchRole);
			click(selenium,"//body/div[7]/div/div/div/div/div");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,txtdeleteReason),"Could not click the select button;More details:"+dirData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * deleteAllAddressBook
	 * function to deleteAllAddressBook
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllAddressBook(Selenium selenium){
		boolean addressDeleted = true;
		int caseCount = 0;
		try{
			waitForElement(selenium, lnkDel, WAIT_TIME);
			while((Integer) selenium.getXpathCount(lnkDel) > 0){
				caseCount = (Integer) selenium.getXpathCount(lnkDel);
				click(selenium,lnkDel);
				waitForPageLoad(selenium);
				click(selenium,btnYes);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount("//div[@id='adminAddressBookListView']/table/tbody/tr/td[2]/div/a")){
					addressDeleted = false;
					break;
				}
			}
			return addressDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * createAddressBookWithMandatoryField
	 * function to create Address Book With Mandatory Field
	 * @since  	     May 21, 2012
	 */	
	public boolean enterPriseVariable_Addressbook(Selenium selenium, SystemSettingsLib epData){
		try{
			try {
				assertTrue(click(selenium,lnkEnterpriseVariables),"Could not click on Identifier Group link:" + epData .toString(),selenium, ClassName, MethodName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitForPageLoad(selenium);
			type(selenium,txtSearchBox,epData.contactValue);
			click(selenium,btnSearchBox);
			waitForPageLoad(selenium);
			click(selenium, lnkDelete);
			
			click(selenium,btnYes);
			waitForPageLoad(selenium);
			try {
				assertTrue(click(selenium,btnAddenterprise),"Could not click on Add Identifier Group link:" + epData.toString(),selenium, ClassName, MethodName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxSuggestBox,epData.contactType);
			
			type(selenium, txtVariableBox,epData.contactValue);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * createAddressBookWithMandatoryField
	 * function to create Address Book With Mandatory Field
	 * @throws IOException 
	 
	 * @since  	     May 21, 2012
	 */	
	public boolean createAddressBookWithMandatoryField(Selenium selenium, SystemSettingsLib providerData) throws IOException {
		try{
			if(providerData.contactLevel.equalsIgnoreCase("Global")){
				assertTrue(click(selenium,rdGlobal), "could not click contact level",selenium, ClassName, MethodName);
			}
			else{
				assertTrue(click(selenium,rdLocal), "could not click contact level",selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium, ajxContactSuggestBox , providerData.contactType);
			assertTrue(type(selenium, txtAddBookLastName, providerData.lastName),"Could not enter Last Name; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkFirstName , providerData.firstName),"Could not enter First Name; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			//Assert.assertTrue(type(selenium, txtAddBkDept, providerData.department),"Could not enter Department; More Details:" + providerData.toString());
			assertTrue(type(selenium, txtAddContactCompany, providerData.contactCompany),"Could not enter contact company; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, "addressBookSave"),"Could not find save button; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(selenium.isTextPresent("Manage Address Book")){
				return true;
			}else{
				return false;
				}
			}
			catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString());
				return false;
			}
		}
	/**
	 * editAddressBook
	 * function to edit Address Book
	 * @since  	     May 21, 2012
	 */	
	
	public boolean editAddressBook(Selenium selenium, SystemSettingsLib providerData, String userAccount) throws IOException {
		try{
			if(providerData.contactLevel.equalsIgnoreCase("Global")){
		        assertTrue(click(selenium,rdGlobal), "could not click contact level",selenium, ClassName, MethodName);
			}
			else{
			    assertTrue(click(selenium,rdLocal), "could not click contact level",selenium, ClassName, MethodName);
			}
				
			selectValueFromAjaxList(selenium, ajxContactSuggestBox, providerData.contactType);
			
		    assertTrue(type(selenium, txtAddContactCompany, providerData.contactCompany),"Could not Enter the Company;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxTitleSuggestBox,providerData.salutation);
			
		    assertTrue(type(selenium,txtAddBookLastName, providerData.lastName),"Could not enter Last Name; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddBkFirstName, providerData.firstName),"Could not enter First Name; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkMiddleName,providerData.middleName),"Could not enter the Middle name;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtJobtitle1,providerData.jobTitle),"Could not Enter the Job Name;More Details"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddBkDepartment, providerData.department),"Could not enter Department; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,  ajxCommTy1suggestBox,providerData.telephoneType1);
			assertTrue(type(selenium, txtAddBkPrimaryPhone, providerData.telephoneNo1),"Could not enter primary phone number; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkPrimaryPhoneExt, providerData.telephoneextnNo1),"Could not enter primary extn number; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			
			assertTrue(type(selenium, txtAddBkAdd1,providerData.address1),"Could not enter the Street1;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,  txtAddrBkAdd2,providerData.address2),"Could not enter the Street2;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddBkCity, providerData.city),"Colud not enter the city;More Details"+providerData.toString(),selenium, ClassName, MethodName);
			if(userAccount.equalsIgnoreCase(CAAccount)){				
				selectValueFromAjaxList(selenium, ajxAddBkStateSuggestBox,providerData.stateCA);
				assertTrue(type(selenium, txtAddBkZipCode, providerData.zipcodeCa),"Could not enter Zip; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
				
			}
			else{				
				selectValueFromAjaxList(selenium, ajxAddBkStateSuggestBox,providerData.state);
				assertTrue(type(selenium, txtAddBkZipCode, providerData.zipcode),"Could not enter Zip; More Details:" + providerData.toString(),selenium, ClassName, MethodName);			
			}
			selenium.keyPress(cmbAddBkCountrySuggestBox, "\\9");
			waitForPageLoad(selenium);
			click(selenium,btnYesbutton);
			selectValueFromAjaxList(selenium, ajxaddBkCountrySuggestBox,providerData.country);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtAddBkEmail,providerData.email),"Could not Enter the Mail;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkWebAdd,providerData.webAddress),"Could not enter the Web Address;Mor Details"+providerData.toString(),selenium, ClassName, MethodName);
		    assertTrue(type(selenium, txtcmt,providerData.comments),"Could not type the Comments; More Details"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnAddSave),"Could not find save button; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(selenium.isTextPresent("Manage Address Book")){
						return true;
					}else{
				return false;
			}
				}
		catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString());
			return false;
		}
	}

	/**
	 * createIdGroup
	 * function to create an Identifier Group.
	 * @throws IOException 
	 * @since  	     May 17, 2012
	 */	
	public boolean createIdGroup(Selenium selenium, SystemSettingsLib idGroupData) throws IOException {
		
		try{
			select(selenium, btnIdGroup,idGroupData.groupFor);
			assertTrue(type(selenium,txtGroup ,idGroupData.groupName),"Could not enter the group;More details:"+idGroupData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtdescription ,idGroupData.groupDescription),"Could not enter the group decription;More details:"+idGroupData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(idGroupData.groupDefault.equals("yes")||idGroupData.groupDefault.equals("Default")){
				assertTrue(click(selenium,chkIdGroupBox ),"Could not click the check box"+idGroupData.toString(),selenium, ClassName, MethodName);
			}
			assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ idGroupData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, btnEditIdGroup)){
				return true;
			}else{
				return false;
			}
		 }
		catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} 
	}

	/**
	 * deleteAllIdentifersGroup
	 * function to deleteAllIdentifiersGroup
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllIdentifiersGroup(Selenium selenium){
		boolean caseDeleted = true;
		int caseCount = 0;
		try{
			waitForElement(selenium,  btnIdentifierGroupDel, WAIT_TIME);
			System.out.println((Integer) selenium.getXpathCount( btnIdentifierGroupDel));
			while((Integer) selenium.getXpathCount( btnIdentifierGroupDel) > 0){
				
				while(getText(selenium, lnkShowMoreIdentifierGroup).equalsIgnoreCase("Show more...")){
					click(selenium, lnkShowMoreIdentifierGroup);
					waitForPageLoad(selenium);
				}
				
				caseCount = (Integer) selenium.getXpathCount( btnIdentifierGroupDel);
				
				if(caseCount>0){
				try {
					assertTrue(click(selenium, btnIdentifierGroupDel),"Could notclick delete button",selenium, ClassName, MethodName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				waitForPageLoad(selenium);
				try {
					assertTrue(click(selenium,btnYes),"Could not click delete button",selenium, ClassName, MethodName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				waitForPageLoad(selenium);
				}
				if(caseCount == (Integer) selenium.getXpathCount( btnIdentifierGroupDel)){
					caseDeleted = false;
					break;
				}
			}
			return caseDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} 
		
	}
	
	/**
	 * createIdType
	 * function to create an Identifier Group.
	 * @since  	     May 17, 2012
	 */	
public boolean createIdType(Selenium selenium, SystemSettingsLib idTypeData) throws IOException {
		
		try{
			select(selenium, btnIdGroup,idTypeData.groupFor);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxSuggestBoxIdType,idTypeData.idGroup);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtType,idTypeData.idType),"Could not enter the group;More details:"+idTypeData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    assertTrue(type(selenium,txtdescription ,idTypeData.typeDescription),"Could not enter the group decription;More details:"+idTypeData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!idTypeData.freeTextRadio.equalsIgnoreCase("yes")){
				assertTrue(click(selenium,rdbtnDefinedList ),"Could not click on radio button; More details"+ idTypeData.toString(),selenium, ClassName, MethodName);
				assertTrue(click(selenium,rdbtnDefinedList ),"Could not click on radio button; More details"+ idTypeData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtIdentifier,idTypeData.identifier),"Could not enter the identifier;More details:"+idTypeData.toString(),selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnAddId),"Could not click on add button; More details"+ idTypeData.toString(),selenium, ClassName, MethodName);
			}
			type(selenium,txtMask ,idTypeData.idTypeMask);
			if(idTypeData.restricted.equals("Yes")){
				assertTrue(click(selenium,chkRestrictedBox ),"Could not click the reatractionlevel check box;More Details:"+idTypeData.toString(),selenium, ClassName, MethodName);
			}
			if(idTypeData.expDate.equals("Yes")){
				assertTrue(click(selenium,chkEndDateRequiredBox),"Could not click the reatractionlevel check box;More Details:"+idTypeData.toString(),selenium, ClassName, MethodName);
			}
			
			if(idTypeData.typeDefault.equals("Yes")){
				assertTrue(click(selenium,chkDefaultBox),"Could not click the defaultType check box;More Details:"+idTypeData.toString(),selenium, ClassName, MethodName);
			}
			
			if(idTypeData.enterprise.equals("Yes")){
				assertTrue(click(selenium, rdbtnEnterprisseLevel),"Could not click the enterprise Level radio;More Details:"+idTypeData.toString(),selenium, ClassName, MethodName);
			}
			
			if(idTypeData.practice.equals("Yes")){
				assertTrue(click(selenium,rdbtnpracticeLevel),"Could not click the practice Level radio box;More Details:"+idTypeData.toString(),selenium, ClassName, MethodName);
			}
			
			assertTrue(click(selenium,btnSave),"Could not click save button; More details"+ idTypeData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnEditIdGroup )){
				return true;
			}else{
				return false;
			}
		 }
		catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
		 
	

	/**
	 * deleteAllIdentifiersTypes
	 * function to delete All Identifiers Types
	 * @throws IOException 
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllIdentifiersTypes(Selenium selenium) throws IOException{
		boolean caseDeleted = true;
		int caseCount = 0;
		
		try{
			                         
			waitForElement(selenium,btnIdentifierTypeDel, WAIT_TIME);
			while((Integer) selenium.getXpathCount(btnIdentifierTypeDel) > 0){
				while(getText(selenium, lnkShowMoreIdentifierType).equalsIgnoreCase("Show more...")){
					click(selenium, lnkShowMoreIdentifierType);
					waitForPageLoad(selenium);
				}
				caseCount = (Integer) selenium.getXpathCount(btnIdentifierTypeDel);
				if(caseCount>0){
				assertTrue(click(selenium,btnIdentifierTypeDel),"Could not click delete label",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnYes),"Could not click Yes button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				}
				if(caseCount == (Integer) selenium.getXpathCount(btnIdentifierTypeDel)){
					caseDeleted = false;
					break;
				}
			}
			return caseDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}


	/**
	 * createUserWithManyRoles
	 * function to create an User with many roles.
	 * @param 		selenium
	 * @param 		userData
	 * @param 		uniqueName
	 * @since  	     May 17, 2012
	 */	
	public boolean createUserWithManyRoles(Selenium selenium,SystemSettingsLib userData,String uniqueName) throws IOException{
		try{
			
			assertTrue(click(selenium,btnadduser),"Could not click on add a user link:" + userData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxExternalEmrsuggestBox,userData.externalEmr);
			assertTrue(type(selenium,txtLastName,userData.lastName+uniqueName),"Could not type a last name",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstName,userData.firstName),"Could not type a first name" + userData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtUserName,userData.userName1+uniqueName),"Could not type a user name" + userData .toString(),selenium, ClassName, MethodName);
			
			assertTrue(type(selenium,txtCredentials,userData.credentials),"Could not type a credential" + userData .toString(),selenium, ClassName, MethodName);
			
			assertTrue(type(selenium,txtPassword,userData.password),"Could not type a password" + userData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtConfirmPassword,userData.password),"Could not type confirmation password" + userData .toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxRoleSuggestBox1suggestBox,userData.userRole);
			selectValueFromAjaxList(selenium,ajxPracticeSuggestBox1,userData.practise);
			assertTrue(click(selenium,btnAddRole),"Could not click on add a role button" + userData .toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAddRole),"Could not click on add a role button" + userData .toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAddRole),"Could not click on add a role button" + userData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnDelete1)&&isElementPresent(selenium,"delete2")){
				selectValueFromAjaxList(selenium,ajxRoleSuggestBox2suggestBox,userData.userRole2);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxPractise1,userData.practice2);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,btnDelete3)&&isElementPresent(selenium,btnDelete4)){
					selectValueFromAjaxList(selenium,ajxRoleSuggestBox3suggestBox,userData.userRole3);
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium,ajxPractise2,userData.practice3);
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium,ajxRoleSuggestBox4suggestBox,userData.userRole4);
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium,ajxPractise3,userData.practice4);
					click(selenium,"body/div[3]/div/div/div/div/div");
				}
			}
			
			
			assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + userData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnEdit1)){
				return true;
			}
			else
			{
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * loginForNexiaToVerifyForcePwdReset
	 * This function will login to Nexia Site and to verify Force Password Reset
	 * @param 		selenium (an instance of current selenium browser )
	 * @param 		userAccount
	 * @param 		userName
	 * @param 		userPassword
	 * @since  	     Mar 29, 2010
	 */
	public boolean loginForNexiaToVerifyForcePwdReset(Selenium selenium, String userAccount, String userName, String userPassword){            
        if(!waitForElement(selenium, lnkLoginAccountText , WAIT_TIME*3)){
        	Assert.fail("Login Page Not loaded More Details; UserAccount :- "+userAccount +"  UserName :- " +userName+ " UserPassword :- "+ userPassword);
        }
        type(selenium, lnkLoginAccountText , userAccount);
        type(selenium, lnkLoginUseridText, userName);
        type(selenium, lnkLoginPasswordText, userPassword);
        click(selenium, btnLogin);
        waitForPageLoad(selenium);
        waitForPageLoad(selenium);
        if(selenium.isTextPresent("Your password has expired. Please reset your password below to continue.")){
        	
               return true;
        }else{
               return false;
        }
	}
	
	/**
	 * deleteUser
	 * function to navigate to Add provider page
	 * @param 		selenium
	 * @param 		UserData
	 * @throws IOException 
	 * @since  	    September 11, 2013
	 */	
	public boolean deleteUser(Selenium selenium,SystemSettingsLib userData) throws IOException{
		
		boolean returnValue=true;
		
		try{
			
		if(selenium.isVisible(txtUserSearch)){
			
		assertTrue(type(selenium,txtUserSearch,userData.firstName),"Could not type first name;More deatils :"+userData.firstName,selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,btnUserSearch),"Could not click the serach button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		int Counter=1;
		//int counter=1;
		while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td")){
			if(getText(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
				selenium.clickAt("//div[@id='users']/table/tbody/tr["+Counter+"]/td[2]/div/a","");
				click(selenium,btnYes);
				waitForPageLoad(selenium);
				
			}else Counter++;
			if(Counter>15)
				break;
			}
		
		}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		
		
		
		return returnValue;		
}

	
	
	/**
	 * searchUser
	 * function to navigate to Add provider page
	 * @param 		selenium
	 * @param 		UserData
	 * @throws IOException 
	 * @since  	    September 11, 2013
	 */	
	public boolean searchDeleteUser(Selenium selenium,SystemSettingsLib userData,SystemSettingsLib deptData ) throws IOException{
		
		boolean returnValue=true;
		
		try{
			
		if(isElementPresent(selenium,txtUserSearch)){
			
		assertTrue(type(selenium,txtUserSearch,userData.firstName),"Could not type first name;More deatils :"+userData.firstName,selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,btnUserSearch),"Could not click the serach button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		int Counter=1;
		//int counter=1;
		while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td")){
			if(getText(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
				click(selenium,"//div[2]/div/div/div[3]/div/div[2]/table/tbody/tr["+Counter+"]/td[2]/div/a");
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
							
				
				if(deptData.testCaseId.equals("TC_VSP_001")){
					
					assertTrue(!selenium.isTextPresent("Are you sure you want to delete the selected user?"),"Required Text is Present",selenium, ClassName, MethodName);
					assertTrue(!selenium.isElementPresent(btnYes),"Delete Button is Present",selenium, ClassName, MethodName);
					//System.out.println("Limited Access");					
					break;
						
				}else if (deptData.testCaseId.equals("TC_VSP_004")){
					
					assertTrue(selenium.isTextPresent("Are you sure you want to delete the selected user?"),"Required Text is Present",selenium, ClassName, MethodName);
					assertTrue(selenium.isElementPresent(btnYes),"Delete Button is not Present",selenium, ClassName, MethodName);
					//System.out.println("Full Access");
					break;
					
				}				
				
				waitForPageLoad(selenium);
				
			}else Counter++;
			if(Counter>4)
				break;
			}
		
		}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return returnValue;		
	}

	
	
	
	/**
	 * createNewUser
	 * function to create New User
	 * @param 		selenium
	 * @param 		userData
	 * @param 		uniqueName
	 * @since  	     May 17, 2012
	 */	
	public boolean createNewUser(Selenium selenium,SystemSettingsLib userData,String uniqueName) throws IOException{
		try{
			assertTrue(click(selenium,btnadduser),"Could not click on add a user link:" + userData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtLastName,userData.lastName+uniqueName),"Could not type a last name",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstName,userData.firstName),"Could not type a first name" + userData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtUserName,userData.userName1+uniqueName),"Could not type a user name" + userData .toString(),selenium, ClassName, MethodName);
			
			assertTrue(type(selenium,txtCredentials,userData.credentials),"Could not type a credential" + userData .toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxExternalEmrsuggestBox,userData.externalEmr);
			assertTrue(type(selenium,txtPassword,userData.password),"Could not type a password" + userData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtConfirmPassword,userData.password),"Could not type confirmation password" + userData .toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxRoleSuggestBox1suggestBox,userData.userRole);
			selectValueFromAjaxList(selenium,ajxPracticeSuggestBox1,userData.practise);
			click(selenium,"//div[3]/div/div/div/div/div");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + userData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!userData.testCaseId.equals("TC_CU_001")){	
				if(isElementPresent(selenium,btnEdit1)){
					return true;
				}else{
					return false;
				}
			}else
				return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}


	/**
	 * createUserUnitTest
	 * function to create an unit test for user.
	 * @param 		selenium
	 * @param 		userData
	 * @since  	     May 17, 2012
	 */	

	public boolean createUserUnitTest(Selenium selenium,SystemsSettingsUnitTest userData) throws IOException{
		try{
			
			assertTrue(click(selenium,btnadduser),"Could not click on add a user link:" + userData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxExternalEmrsuggestBox,userData.externalEmr);
			assertTrue(type(selenium,txtLastName,userData.lastName),"Could not type a last name",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstName,userData.firstName),"Could not type a first name" + userData .toString(),selenium, ClassName, MethodName);
		    assertTrue(type(selenium,txtUserName,userData.userName1),"Could not type a user name" + userData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCredentials,userData.credentials),"Could not type a credential" + userData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPassword,userData.password),"Could not type a password" + userData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtConfirmPassword,userData.password2),"Could not type confirmation password" + userData .toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxRoleSuggestBox1suggestBox,userData.userRole);
			selectValueFromAjaxList(selenium,ajxPractise,userData.practise);
			assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + userData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
			}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + userData.toString());
			return false;
			}
		}

	/**
	 * editUserUnitTest
	 * function to edit User Unit Test
	 * @param 		selenium
	 * @param 		userData
	 * @param		uniqueName
	 * @since  	     May 17, 2012
	 */	
	public boolean editUserUnitTest(Selenium selenium,SystemsSettingsUnitTest userData,String uniqueName) throws IOException{	
		assertTrue(click(selenium,btnadduser),"Could not click on add a user link:" + userData .toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtLastName,userData.lastName+uniqueName),"Could not type a last name",selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtFirstName,userData.firstName),"Could not type a first name" + userData .toString(),selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtUserName,userData.userName1+uniqueName),"Could not type a user name" + userData .toString(),selenium, ClassName, MethodName);
		selectValueFromAjaxList(selenium,ajxExternalEmrsuggestBox,userData.externalEmr);
		assertTrue(type(selenium,txtCredentials,userData.credentials),"Could not type a credential" + userData .toString(),selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtPassword,userData.password),"Could not type a password" + userData .toString(),selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtConfirmPassword,userData.password),"Could not type confirmation password" + userData .toString(),selenium, ClassName, MethodName);
		selectValueFromAjaxList(selenium,ajxRoleSuggestBox1suggestBox,userData.userRole);
		selectValueFromAjaxList(selenium,ajxPractise,userData.practise);
		click(selenium,"//div[3]/div/div/div/div/div");
		waitForPageLoad(selenium);
		assertTrue(enterDate(selenium,txtStartDate,userData.startDate),"Could not enter the start Date",selenium, ClassName, MethodName);
		assertTrue(enterDate(selenium,txtEndDate,userData.endDate),"Could not enter the end Date",selenium, ClassName, MethodName);
		
		assertTrue(click(selenium,btnSave),"Could not click on save a User link:" + userData .toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnEdit1),"Could not click on edit a User link:" + userData .toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(userData.resetPassword.equalsIgnoreCase("Yes")){
			assertTrue(click(selenium,chkResetPassword),"Colud not click on Reset Password",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtPassword,userData.password3),"Could not type a password" + userData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtConfirmPassword,userData.password4),"Could not type confirmation password" + userData .toString(),selenium, ClassName, MethodName);
		}
		else{
			assertTrue(click(selenium,chkResetPassword),"Colud not click on Reset Password",selenium, ClassName, MethodName);
		    assertTrue(click(selenium,chkResetPassword),"Could not click on Reset Password",selenium, ClassName, MethodName);
		}
		waitForPageLoad(selenium);
		return true;
	}
	/**
	 * editUser
	 * function to create an User.
	 * @param 		selenium
	 * @param 		userData
	 * @since  	     May 17, 2012
	 */	
	public boolean editUser(Selenium selenium,SystemSettingsLib userData,String uniqueName) throws IOException{
		try{
			
		    assertTrue(type(selenium,txtLastName,userData.lastName+uniqueName),"Could not type a last name",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstName,userData.firstName),"Could not type a first name" + userData .toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxExternalEmrsuggestBox,userData.externalEmr);			
			assertTrue(type(selenium,txtCredentials,userData.credentials),"Could not type a credential" + userData .toString(),selenium, ClassName, MethodName);
			if(userData.resetPassword.equalsIgnoreCase("Yes")){
				assertTrue(click(selenium,chkResetPassword),"Could not click Reset password",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtPassword,userData.changedPassword),"Could not type a password" + userData .toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtConfirmPassword,userData.changedPassword),"Could not type confirmation password" + userData .toString(),selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium,ajxUserRolesuggestBox,userData.userRole);
			//selectValueFromAjaxList(selenium,ajxSuggestBoxProg ,userData.practise);
			assertTrue(enterDate(selenium,txtStartDate,userData.startDate),"Could not enter the start Date"+userData.toString(),selenium, ClassName, MethodName);
			click(selenium,"//div[3]/div/div/div/div/div");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + userData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnEdit1))
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * createProgram
	 * function to navigate to Add provider page
	 * @param 		selenium
	 * @param 		programData
	 * @param		uniqueName
	 * @since  	    August 17, 2012
	 */	
	public boolean createProgram(Selenium selenium,SystemSettingsLib programData,String uniqueName) throws IOException{
		boolean returnValue=false;
		try{
			
			selectValueFromAjaxList(selenium,ajxSuggestBoxProg ,programData.department);
			assertTrue(type(selenium,typeProgramName ,programData.program+uniqueName),"Could not type a program name" + programData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtdescription ,programData.description),"Could not type a description" + programData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + programData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!programData.testCaseId.equals("TC_CP_007")){
				if(isElementPresent(selenium,btnEdit1))
					returnValue=true;
				else
					Assert.fail("Program is not getting saved");
			}else
				returnValue=true;
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}
	
	/**
	 * searchDeleteProgram
	 * function to navigate to Add provider page
	 * @param 		selenium
	 * @param 		UserData
	 * @since  	    September 11, 2013
	 */	
	
public boolean searchDeleteProgram(Selenium selenium,SystemSettingsLib programData,SystemSettingsLib deptData ) throws IOException{
		
		boolean returnValue=true;
		
		try{
			
		if(isElementPresent(selenium,txtSearchTextBox2)){
			
		assertTrue(type(selenium,txtSearchTextBox2,programData.program),"Could not type first name;More deatils :"+programData.program,selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,btnProgramSearch),"Could not click the serach button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		int Counter=1;
		//int counter=1;
		while(isElementPresent(selenium,"//div[@id='programs']/table/tbody/tr["+Counter+"]/td/div/div")){
			if(getText(selenium,"//div[@id='programs']/table/tbody/tr["+Counter+"]/td/div/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.program.trim().toLowerCase(new java.util.Locale("en","US")))){
				click(selenium,"//div[3]/div/div/div/div[4]/div/div[2]/table/tbody/tr["+Counter+"]/td[2]/div/a");
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
							
				
				if(deptData.testCaseId.equals("TC_VSP_001")){
					
					assertTrue(!selenium.isTextPresent("Are you sure you want to delete the selected program?"),"Required Text is Present",selenium, ClassName, MethodName);
					assertTrue(!selenium.isElementPresent(btnYes),"Delete Button is Present",selenium, ClassName, MethodName);
					//System.out.println("Limited Access");					
					break;
						
				}else if (deptData.testCaseId.equals("TC_VSP_004")){
					
					assertTrue(selenium.isTextPresent("Are you sure you want to delete the selected program?"),"Required Text is Present",selenium, ClassName, MethodName);
					assertTrue(selenium.isElementPresent(btnYes),"Delete Button is not Present",selenium, ClassName, MethodName);
					//System.out.println("Full Access");
					break;
					
				}				
				
				waitForPageLoad(selenium);
				
			}else Counter++;
			if(Counter>4)
				break;
			}
		
		}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		
		
		
		return returnValue;		
}

	/**
	 * createProgramForPort
	 * function to navigate to Add provider page
	 * @param 		selenium
	 * @param 		programData
	 * @param		uniqueName
	 * @since  	    August 17, 2012
	 */	
public boolean createProgramForPort(Selenium selenium,SystemSettingsLib programData) throws IOException{
	boolean returnValue=false;
	try{
		
		selectValueFromAjaxList(selenium,ajxSuggestBoxProg ,programData.department);
		assertTrue(type(selenium,typeProgramName ,programData.program),"Could not type a program name" + programData .toString(),selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtdescription ,programData.description),"Could not type a description" + programData .toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + programData .toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,btnEdit1))
			returnValue=true;
		else
			Assert.fail("Program is not getting saved");
		waitForPageLoad(selenium);
	}catch(RuntimeException e){
		e.printStackTrace();
		return false;
	}
	return returnValue;
}
	/**
	 * editProgram
	 * function to edit a program
	 * @since  	    August 23, 2012
	 */	
public boolean editProgram(Selenium selenium,SystemSettingsLib programData,String uniqueName) throws IOException
{
	boolean returnValue=false;
	try{
		
		assertTrue(selectValueFromAjaxList(selenium,ajxSuggestBoxProg ,programData.department),"Could not select a department",selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtdescription ,programData.description),"Could not type a description" + programData .toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + programData .toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,btnEdit1))
			returnValue=true;
		else
			Assert.fail("Program is not getting saved");
		waitForPageLoad(selenium);
	}catch(RuntimeException e){
		e.printStackTrace();
		return false;
	}
	return returnValue;
}
	/**
	 * addProviderToProgram
	 * function to add a provider to a program.
	 * @param 		selenium
	 * @param 		programData
	 * @since  	    August 17, 2012
	 */	
   public boolean addProviderToProgram(Selenium selenium,SystemSettingsLib programData) throws IOException
     {
	boolean returnValue=false;
	try{
		assertTrue(click(selenium,btnAddProvider),"Could not click add providers button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtProviderSearchBox ,programData.provider1),"Could not type in the search box",selenium, ClassName, MethodName);
		assertTrue(click(selenium,btnSearch),"Could not click the search button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//Assert.assertTrue(click(selenium,"//span/input"),"Could not click the search button");
		assertTrue(click(selenium,btnSave),"Could not click the save button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,btnAddProvider))
			returnValue=true;
		else
			Assert.fail("Could not add provider to a program.");
	}catch(RuntimeException e){
		e.printStackTrace();
		return false;
	}
	return returnValue;
}
	/**deleteAssociatedPractice
	 * Function to delete Associated practice
	 * @since	Nov 14, 2012
	 */
	/*public boolean deleteAssociatedPractice(Selenium selenium){
		boolean returnValue = false;
		try{
			while(isElementPresent(selenium, "//td[2]/div/a")){
				Assert.assertTrue(click(selenium,"//td[2]/div/a"));
				Assert.assertTrue(click(selenium,btnYes));
				waitForPageLoad(selenium);
				returnValue = true;
			}
		}
		catch(RuntimeException e){
			Assert.fail("Could not delete Associated practice for provider");
			returnValue = false;
			e.printStackTrace();
		}return returnValue;
	}*/
	
	/**
	 * addPracticeToProvider
	 * function to add practice to provider
	 * @param 		selenium
	 * @param 		providerData
	 * @since  	    Nov 14, 2012
	 */	
   public boolean addPracticeToProvider(Selenium selenium,SystemSettingsLib providerData) throws IOException
	{
		boolean returnValue=false;
		try{
			assertTrue(click(selenium,btnAddProvider),"Could not click add providers button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, btnSearchProviderBox,providerData.practiceName),"Could not type practice name in search box",selenium, ClassName, MethodName);
			assertTrue(click(selenium,"search"),"Could not click the search button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!isChecked(selenium, "//span/input"))
				assertTrue(click(selenium,"//span/input"),"Could not click the search button",selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click the save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnAddProvider))
				returnValue=true;
			else
				Assert.fail("Could not add a practice for provider");
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}

	/**
	 * deleteProviderToProgram
	 * function to add a provider to a program.
	 * @param 		selenium
	 * @param 		programData
	 * @throws IOException 
	 * @since  	    August 17, 2012
	 */	
	public boolean deleteProviderToProgram(Selenium selenium,SystemSettingsLib programData) throws IOException
	{
		boolean returnValue=true;
		try{
			if(getText(selenium, vfyProgramDel6).contains(programData.provider))
			{
				assertTrue(click(selenium, btnDelProvider ),"Could not delete the provider" ,selenium, ClassName, MethodName);
				returnValue= true;
			}
			else
				returnValue= false;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}
	
	/**
	 * searchForProgram
	 * function to search a program
	 * @param 		selenium
	 * @param 		programData
	 * @since  	    August 17, 2012
	 */	
	public boolean searchForProgram(Selenium selenium,SystemSettingsLib programData,String uniqueName){
		boolean returnValue=false;
		try{
			int counter=1;
			while(getText(selenium,"//div[3]/div/div/div").contains(programData.program+uniqueName.trim().toLowerCase(new java.util.Locale("en","US")))){
				if(getText(selenium,"//div[@id='programs']/table/tbody/tr["+counter+"]/td/div/div/span").contains(programData.program+uniqueName.trim().toLowerCase(new java.util.Locale("en","US")))){
					click(selenium,"//div[@id='programs']/table/tbody/tr["+counter+"]/td/div/div/span");
					break;
				}
				counter++;
			}
			waitForPageLoad(selenium);
			if(getText(selenium,typeProgramName ).equalsIgnoreCase(programData.program+uniqueName))
				returnValue=true;
			else
				Assert.fail("Could not navigate to system settings.");
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}
	/**
	 * deleteProgram
	 * function to delete a program
	 * @param 		selenium
	 * @param 		programData
	 * @since  	    August 17, 2012
	 */	
	public boolean deleteProgram(Selenium selenium,SystemSettingsLib programData){
		boolean returnValue=true;
		try{
			waitForPageLoad(selenium);
			int counter=1;
			while(getText(selenium, vfyProgramDel).contains(programData.program)){
			if(getText(selenium,"//div[@id='programs']/table/tbody/tr["+counter+"]/td/div/div/span").toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.program.trim().toLowerCase(new java.util.Locale("en","US")))){
				try {
					assertTrue(click(selenium,"//div[@id='programs']/table/tbody/tr["+counter+"]/td[2]/div/a"),"Could not delete the program",selenium, ClassName, MethodName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				click(selenium,btnYes);
				waitForPageLoad(selenium);
			}else counter++;
			if(counter>10)
				break;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}
	
	/**
	 * goToAddProgramPage
	 * function to navigate to Add provider page
	 * @param 		selenium
	 * @param 		programData
	 * @since  	    August 17, 2012
	 */	
	public boolean goToAddProgramPage(Selenium selenium,SystemSettingsLib programData) throws IOException{
		boolean returnValue=false;
		try{
			if(isElementPresent(selenium,btnBack ))
				assertTrue(click(selenium,btnBack ),"Could not click the back button.",selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkSystemSettings),"Could not click on System settings link:" + programData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddProgram),"Could not click on add a program link:" + programData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,ajxSuggestBoxProg ))
				returnValue=true;
			else
				Assert.fail("Could not navigate to system settings.");
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}
	/**
	 * deleteProvider
	 * function to navigate to Add provider page
	 * @param 		selenium
	 * @param 		providerData
	 * @since  	    August 17, 2012
	 */	
	public boolean deleteProvider(Selenium selenium,SystemSettingsLib providerData){
		boolean returnValue=true;
		try{
			if(selenium.isVisible(txtProviderSearchbox)){
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtProviderSearchbox,providerData.firstName),"Could not type the first name; More Details"+providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnProviderSearch),"Could not click the search button"+providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			int Counter=(Integer) selenium.getXpathCount(vfyProgramDel4);
			while(isElementPresent(selenium,"//div[@id='providers']/table/tbody/tr["+Counter+"]/td[2]/div/a")){
				waitForPageLoad(selenium);
				assertTrue(click(selenium,"//div[@id='providers']/table/tbody/tr["+Counter+"]/td[2]/div/a"),"Could not click the delete button"+providerData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				click(selenium,btnYes);
				waitForPageLoad(selenium);
				int counterAfterDeletion=(Integer) selenium.getXpathCount(vfyProgramDel4);
				if((Counter==counterAfterDeletion)&&(counterAfterDeletion!=0)){
					Assert.fail("Could not delete the provider;More Details:"+providerData.toString());
					returnValue=false;
				}
				waitForPageLoad(selenium);
				Counter--;
			}
			}
			else{
				if(getText(selenium,vfyProgramDel5).contains(providerData.firstName))
				{
					click(selenium,vfyProgramDel4);
					assertTrue(click(selenium,btnYes),"Could not click the yes button",selenium, ClassName, MethodName);
					returnValue=true;
				}
				int count1=1;
				int counter1=(Integer)selenium.getXpathCount(vfyProgramDel5);
				while(getText(selenium,txtFirstName2).contains(providerData.firstName)&&count1<counter1){
				if(getText(selenium,"//div[@id='providers']/table/tbody/tr["+count1+"]/td/div/div").contains(providerData.firstName)){
					assertTrue(click(selenium,"//div[@id='providers']/table/tbody/tr["+count1+"]/td[2]/div/a"),"Could not delete the program",selenium, ClassName, MethodName);
					assertTrue(click(selenium,btnYes),"Could not click the yes button",selenium, ClassName, MethodName);
					returnValue=true;
					break;
				}
				count1++;
				}
				
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	/**
	 * searchProvider
	 * function to navigate to Add provider page
	 * @param 		selenium
	 * @param 		providerData
	 * @since  	    August 17, 2012
	 */
	
	
	public boolean searchProvider(Selenium selenium,SystemSettingsLib providerData){

		boolean returnValue=false;
		try{
			assertTrue(click(selenium,lnkOrgStructuresId),"Could not click the search button"+providerData.toString(),selenium, ClassName, MethodName);

			if(isElementPresent(selenium,vfyProgramDel2))
			{
				assertTrue(type(selenium,vfyProgramDel2,providerData.firstName),"Could not type the first name; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,vfyProgramDel3),"Could not click the search button"+providerData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,btnSearchProvider))
				{
				assertTrue(click(selenium,btnSearchProvider),"could not click the data;More Details"+providerData.toString(),selenium, ClassName, MethodName);
				returnValue=true;
				waitForPageLoad(selenium);
				}
				else
					returnValue=false;
			}
			
			else{
				if(getText(selenium,vfyProgramDel5).contains(providerData.firstName))
				{
					click(selenium, vfyProgramDel5 );
					returnValue=true;
				}
				int count1=1;
				int counter1=(Integer)selenium.getXpathCount(vfyProgramDel5);
				while(getText(selenium,txtFirstName2).contains(providerData.firstName)&&count1<counter1){
				if(getText(selenium,"//div[@id='providers']/table/tbody/tr["+count1+"]/td/div/div").contains(providerData.firstName)){
					assertTrue(click(selenium,"//div[@id='providers']/table/tbody/tr["+count1+"]/td/div/div"),"Could not select the provider",selenium, ClassName, MethodName);
					returnValue=true;
					break;
				}
				count1++;
				}
				
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

	/**
	 * createProvider
	 * function to create an Provider.
	 * @param 		selenium
	 * @param 		providerData
	 * @since  	     May 17, 2012
	 */	
	public boolean createProvider(Selenium selenium,SystemSettingsLib providerData,String providerCodeUnique) throws IOException{
		try{
			selectValueFromAjaxList(selenium,ajxProviderTypesuggestBox,providerData.providerType);
			assertTrue(type(selenium,txtProviderCode,providerCodeUnique),"Could not enter the provider code",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxTitleSuggestBox,providerData.title);
		    assertTrue(type(selenium, txtFirstName,providerData.firstName),"Could not enter the  name"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtLastName,providerData.lastName),"Could not type a last name"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMiddleName,providerData.middleName),"Could not type a middle name"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCredentials,providerData.credentials),"Could not type credentials"+ providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,txtSpecialtySuggestBox,providerData.specialty);
			waitForPageLoad(selenium);
			click(selenium,btnAddSpecialtyButton);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxGendersuggestBox ,providerData.gender);
			selectValueFromAjaxList(selenium,ajxLanguagesuggestBox,providerData.language);
			
			click(selenium,btnAddLanguageButton);
			assertTrue(type(selenium,txtCellPhone ,providerData.cellPhone),"Could not type cell phone number"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPager,providerData.pager),"Could not type pager number"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtEmail ,providerData.email),"Could not type email"+ providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxMaximumFTESuggestBoxsuggestBox,providerData.maximumFte);
			assertTrue(type(selenium,ajxHoursWorked,providerData.hoursWorked),"Could not type hours worked"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtcmt,providerData.comments),"Could not type comments"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtMailingStreet1,providerData.address1),"Could not type street"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMailingStreet2 ,providerData.address2),"Could not type street2"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMailingCity,providerData.city),"Could not type city"+ providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,txtMailingStatesuggestBox,providerData.state);
			assertTrue(type(selenium,txtMailingZipPostalCode,providerData.zipcode),"Could not type Zip Code"+ providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.keyPress(txtMailingCountrysuggestBox, "\\9");
			click(selenium,btnYes);
			waitForElementToEnable(selenium,txtMailingCity);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,txtMailingStatesuggestBox);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,txtMailingCountrysuggestBox);
			waitForPageLoad(selenium);
		    assertTrue(type(selenium,"mailingOfficePhone",providerData.officePhone),"Could not type office phone"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMailingOfficePhoneExt,providerData.officePhone1),"Could not type office phone extno"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMailingFax,providerData.fax),"Could not type fax number,"+providerData.toString(),selenium, ClassName, MethodName);
			
			
			
			
			if(providerData.billingAddressCheck.equalsIgnoreCase("No")){	
				
					if(isChecked(selenium,chkSameAsMailingAddresscheckbox))
						assertTrue(click(selenium,chkSameAsMailingAddresscheckbox),"Could not click mailing address Check Box",selenium, ClassName, MethodName);
					assertTrue(type(selenium, txtBillingStreet1,providerData.billingStreet1), "Could not type the billing address"+providerData.toString(),selenium, ClassName, MethodName);
					assertTrue(type(selenium, txtBillingStreet2,providerData.billingStreet2), "Could not type the billing address2"+providerData.toString(),selenium, ClassName, MethodName);
					assertTrue(type(selenium, txtCityPro,providerData.billingCity), "Could not type the billing city"+providerData.toString(),selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,ajxBillingStatesuggestBox,providerData.billingState);
					assertTrue(type(selenium,txtBillingZipPostalCode,providerData.billingZipcode), "Could not type the billing zip code"+providerData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					selenium.keyPress(txtBillingCountrysuggestBox, "\\9");
					click(selenium,btnYes);
					waitForElementToEnable(selenium, txtCityPro);
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,ajxBillingStatesuggestBox);
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,txtBillingCountrysuggestBox);
					waitForPageLoad(selenium);
					
				
			}
			if(providerData.billingInfoCheck.equals("Yes")){
				assertTrue(click(selenium, chkSignatureOnFilecheckbox),"Could not click the signature file check box;More details:"+providerData.toString(),selenium, ClassName, MethodName);
				assertTrue(enterDate(selenium,txtSignatureDate,providerData.signatureDate),"Could not enter date; More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			}
			assertTrue(type(selenium,  txtDea ,providerData.dEA),"Could not enter the dea; More Details"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtUpinPro,providerData.uPIN),"Could not enter the UPIN;More Details"+providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxReportMethodsuggestBox,providerData.reportMethod);
			
			assertTrue(click(selenium,"xpath=(//button[@type='button'])[7]"),"Could not click the identifier; More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxPractice,providerData.practice);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxGroupName,providerData.groupName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxGroupFor,providerData.idType);
			waitForPageLoad(selenium);
			//Assert.assertTrue(type(selenium,ajxIdTypeMask,providerData.idTypeMask),"Could not Enter the mask value;More Details:"+providerData.toString());
			//waitForPageLoad(selenium);
			assertTrue(type(selenium,txtNpi,providerData.nPI),"Could not enter the NPI;More Details"+providerData.toString(),selenium, ClassName, MethodName);
			
			
			
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			if(isElementPresent(selenium,"//div[4]/div/div/div/div[2]/div/div/div/input")){
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * createProvider
	 * function to create an Provider.
	 * @param 		selenium
	 * @param 		providerData
	 * @since  	     May 17, 2012
	 */	
	public boolean createProviderCAView(Selenium selenium,SystemSettingsLib providerData,String providerCodeUnique, String userAccount) throws IOException{
		try{
			selectValueFromAjaxList(selenium,ajxProviderTypesuggestBox,providerData.providerType);
			assertTrue(type(selenium,txtProviderCode,providerCodeUnique),"Could not enter the provider code",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxTitleSuggestBox,providerData.title);
			assertTrue(type(selenium, txtFirstName,providerData.firstName),"Could not enter the  name"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtLastName,providerData.lastName),"Could not type a last name"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMiddleName,providerData.middleName),"Could not type a middle name"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCredentials,providerData.credentials),"Could not type credentials"+ providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,txtSpecialtySuggestBox,providerData.specialty);
			//waitForPageLoad(selenium);
			click(selenium, btnAddSpecialtyButton);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxGendersuggestBox ,providerData.gender);
			assertTrue(click(selenium,languageLink),"unable to click the language suggestion link",selenium,ClassName,MethodName);
		    assertTrue(click(selenium,chkBoxEnglish),"unable to click the check box",selenium,ClassName,MethodName);
		    click(selenium,closeBtn);
		    //Script is updated for new UI- VEL-7528
		    //assertTrue(click(selenium,addLanguage),"unable to type the value in the language search box",selenium,ClassName,MethodName);
			//selectValueFromAjaxList(selenium,ajxLanguagesuggestBox,providerData.language);
			//waitForPageLoad(selenium);
			//click(selenium,btnAddLanguageButton);
			assertTrue(type(selenium,txtCellPhone ,providerData.cellPhone),"Could not type cell phone number"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPager,providerData.pager),"Could not type pager number"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtEmail ,providerData.email),"Could not type email"+ providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxMaximumFTESuggestBoxsuggestBox,providerData.maximumFte);
			assertTrue(type(selenium,ajxHoursWorked,providerData.hoursWorked),"Could not type hours worked"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtcmt,providerData.comments),"Could not type comments"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtMailingStreet1,providerData.address1),"Could not type street"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMailingStreet2 ,providerData.address2),"Could not type street2"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMailingCity,providerData.city),"Could not type city"+ providerData.toString(),selenium, ClassName, MethodName);
			/*selectValueFromAjaxList(selenium,txtMailingStatesuggestBox,providerData.state);
			Assert.assertTrue(type(selenium,txtMailingZipPostalCode,providerData.zipcode),"Could not type Zip Code"+ providerData.toString());*/
			waitForPageLoad(selenium);
			selenium.keyPress(txtMailingCountrysuggestBox, "\\9");
			click(selenium,btnYes);
			waitForElementToEnable(selenium,txtMailingCity);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,txtMailingStatesuggestBox);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,txtMailingCountrysuggestBox);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtMailingOfficePhone,providerData.officePhone),"Could not type office phone"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMailingOfficePhoneExt,providerData.officePhone1),"Could not type office phone extno"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMailingFax,providerData.fax),"Could not type fax number,"+providerData.toString(),selenium, ClassName, MethodName);
			
			
			if(!(userAccount.equalsIgnoreCase(CAAccount))){
			
				if(providerData.billingAddressCheck.equalsIgnoreCase("No")){	
					
						if(isChecked(selenium,chkSameAsMailingAddresscheckbox))
					    assertTrue(click(selenium,chkSameAsMailingAddresscheckbox),"Could not click Address check box",selenium, ClassName, MethodName);
						assertTrue(type(selenium, txtBillingStreet1,providerData.billingStreet1), "Could not type the billing address"+providerData.toString(),selenium, ClassName, MethodName);
						assertTrue(type(selenium, txtBillingStreet2,providerData.billingStreet2), "Could not type the billing address2"+providerData.toString(),selenium, ClassName, MethodName);
						assertTrue(type(selenium, txtCityPro,providerData.billingCity), "Could not type the billing city"+providerData.toString(),selenium, ClassName, MethodName);
						selectValueFromAjaxList(selenium,ajxBillingStatesuggestBox,providerData.billingState);
						assertTrue(type(selenium,txtBillingZipPostalCode,providerData.billingZipcode), "Could not type the billing zip code"+providerData.toString(),selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						selenium.keyPress(txtBillingCountrysuggestBox, "\\9");
						click(selenium,btnYes);
						waitForElementToEnable(selenium, txtCityPro);
						waitForPageLoad(selenium);
						waitForElementToEnable(selenium,ajxBillingStatesuggestBox);
						waitForPageLoad(selenium);
						waitForElementToEnable(selenium,txtBillingCountrysuggestBox);
						waitForPageLoad(selenium);
										
				}
/*	Funcationality changed  for CA View 			
 *  if(providerData.billingInfoCheck.equals("Yes")){
					assertTrue(click(selenium, chkSignatureOnFilecheckbox),"Could not click the signature file check box;More details:"+providerData.toString(),selenium, ClassName, MethodName);
					assertTrue(enterDate(selenium,txtSignatureDate,providerData.signatureDate),"Could not enter date; More Details:"+providerData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				assertTrue(type(selenium,  txtDea ,providerData.dEA),"Could not enter the dea; More Details"+providerData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtUpinPro,providerData.uPIN),"Could not enter the UPIN;More Details"+providerData.toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajxReportMethodsuggestBox,providerData.reportMethod);*/
				
				assertTrue(click(selenium,btnIdentifier),"Could not click the identifier; More Details:"+providerData.toString(),selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajxPractice,providerData.practice);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxGroupName,providerData.groupName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxIdType ,providerData.idType);
				waitForPageLoad(selenium);
				type(selenium,ajxIdTypeMask,providerData.idTypeMask);
				//waitForPageLoad(selenium);
				//assertTrue(type(selenium,txtNpi,providerData.nPI),"Could not enter the NPI;More Details"+providerData.toString(),selenium, ClassName, MethodName);
			
			}
			
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * createProviderWithMandatory
	 * function to create Provider With Mandatory
	 * @since  	     June 06, 2012
	 */	

	public boolean createProviderWithMandatory(Selenium selenium,SystemSettingsLib providerData) throws IOException{
		try{
			selectValueFromAjaxList(selenium,ajxProviderTypesuggestBox,providerData.providerType);
			selectValueFromAjaxList(selenium,ajxProviderSupervisosuggestBox,providerData.SupervisorSuggestBox);
			waitForPageLoad(selenium);
			if(isElementVisible(selenium,ajxDurationFrom)){
				enterDate(selenium,ajxDurationFrom,providerData.DurationFrom);
				waitForPageLoad(selenium);
				enterDate(selenium,ajxDurationTo,providerData.DurationTo);
			}
			assertTrue(type(selenium, txtFirstName,providerData.firstName),"Could not enter the  name"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtLastName,providerData.lastName),"Could not type a last name"+ providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,txtSpecialtySuggestBox,providerData.specialty);
			assertTrue(click(selenium,btnAddSpecialtyButton),"Could not click the save button;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,txtSpecialtySuggestBox,providerData.specialty);
			assertTrue(click(selenium,btnAddSpecialtyButton),"Could not click the save button;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxMaximumFTESuggestBoxsuggestBox,providerData.maximumFte);
			waitForPageLoad(selenium);
			if(providerData.billingInfoCheck.equals("Yes")){
				if(!isChecked(selenium, chkSignatureOnFilecheckbox))
					click(selenium, chkSignatureOnFilecheckbox);
				enterDate(selenium,txtSignatureDate,providerData.signatureDate);
			}
			else
			{
				if(isChecked(selenium, chkSignatureOnFilecheckbox))
					click(selenium, chkSignatureOnFilecheckbox);
				
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			/*if(isElementPresent(selenium,btnEdit1)){
				return true;
			}
			else{
				return false;
			}*/
			assertTrue(!isElementPresent(selenium,btnSave),"Could not click the save button;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}




	
	/**
	 * createProviderWithMandatory
	 * function to create Provider With Mandatory
	 * @since  	     June 06, 2012
	 */	

	public boolean createProviderWithMandatoryCAView (Selenium selenium,SystemSettingsLib providerData) throws IOException{
		try{
			selectValueFromAjaxList(selenium,ajxProviderTypesuggestBox,providerData.providerType);
			selectValueFromAjaxList(selenium,ajxProviderSupervisosuggestBox,providerData.SupervisorSuggestBox);
			waitForPageLoad(selenium);
			if(isElementVisible(selenium,ajxDurationFrom)){
				enterDate(selenium,ajxDurationFrom,providerData.DurationFrom);
				waitForPageLoad(selenium);
				enterDate(selenium,ajxDurationTo,providerData.DurationTo);
			}  		

			
			assertTrue(type(selenium, txtFirstName,providerData.firstName),"Could not enter the  name"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtLastName,providerData.lastName),"Could not type a last name"+ providerData.toString(),selenium, ClassName, MethodName);
			
			selectValueFromAjaxList(selenium,txtSpecialtySuggestBox,"Neurology");
			assertTrue(click(selenium,btnAddSpecialtyButton),"Could not click the save button;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,txtSpecialtySuggestBox,"Dermatology");
			assertTrue(click(selenium,btnAddSpecialtyButton),"Could not click the save button;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			
			selectValueFromAjaxList(selenium,ajxMaximumFTESuggestBoxsuggestBox,providerData.maximumFte);			
			
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			if(isElementPresent(selenium,btnAddProviderorg)){
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}

	
	/**
	 * editProvider
	 * function to edit Provider.
	 * @since  	     June 06, 2012
	 */	
	public boolean editProvider(Selenium selenium,SystemSettingsLib providerData,String providerCodeUnique,String userAccount) throws IOException{
		try
		{
			selectValueFromAjaxList(selenium,ajxProviderTypesuggestBox,providerData.providerType);
			assertTrue(type(selenium,txtProviderCode,providerCodeUnique),"Could not enter the provider code",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxTitleSuggestBox,providerData.title);
			assertTrue(type(selenium, txtFirstName,providerData.firstName),"Could not enter the  name"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtLastName,providerData.lastName),"Could not type a last name"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMiddleName,providerData.middleName),"Could not type a middle name"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCredentials,providerData.credentials),"Could not type credentials"+ providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,txtSpecialtySuggestBox,providerData.specialty);
			waitForPageLoad(selenium);
			click(selenium,btnAddSpecialtyButton);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxGendersuggestBox ,providerData.gender);
		    assertTrue(click(selenium,languageLink),"unable to click the language suggestion link",selenium,ClassName,MethodName);
		    //Updated the script for New UI. VEL-7528
		    //assertTrue(type(selenium,addLanguage,providerData.language),"unable to type the value in the language search box",selenium,ClassName,MethodName);
		    assertTrue(click(selenium,chkBoxEnglish),"unable to click the check box",selenium,ClassName,MethodName);
		    click(selenium,closeBtn);
			//selectValueFromAjaxList(selenium,ajxLanguagesuggestBox,providerData.language);
			//waitForPageLoad(selenium);
			//click(selenium,btnAddLanguageButton);
			assertTrue(type(selenium,txtCellPhone ,providerData.cellPhone),"Could not type cell phone number"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPager,providerData.pager),"Could not type pager number"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtEmail ,providerData.email),"Could not type email"+ providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxMaximumFTESuggestBoxsuggestBox,providerData.maximumFte);
			assertTrue(type(selenium,ajxHoursWorked,providerData.hoursWorked),"Could not type hours worked"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtcmt,providerData.comments),"Could not type comments"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtMailingStreet1,providerData.address1),"Could not type street"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMailingStreet2 ,providerData.address2),"Could not type street2"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMailingCity,providerData.city),"Could not type city"+ providerData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,txtMailingStatesuggestBox,providerData.state);
			assertTrue(type(selenium,txtMailingZipPostalCode,providerData.zipcode),"Could not type Zip Code"+ providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.keyPress(txtMailingCountrysuggestBox, "\\9");
			click(selenium,btnYes);
			waitForElementToEnable(selenium,txtMailingCity);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,txtMailingStatesuggestBox);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,txtMailingCountrysuggestBox);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,"mailingOfficePhone",providerData.officePhone),"Could not type office phone"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMailingOfficePhoneExt,providerData.officePhone1),"Could not type office phone extno"+ providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMailingFax,providerData.fax),"Could not type fax number,"+providerData.toString(),selenium, ClassName, MethodName);
			if(providerData.billingAddressCheck.equalsIgnoreCase("No"))
			{
					if(isChecked(selenium,chkSameAsMailingAddresscheckbox))
					assertTrue(click(selenium,chkSameAsMailingAddresscheckbox),"Could not click Check Box",selenium, ClassName, MethodName);
					assertTrue(type(selenium, txtBillingStreet1,providerData.billingStreet1), "Could not type the billing address"+providerData.toString(),selenium, ClassName, MethodName);
					assertTrue(type(selenium, txtBillingStreet2,providerData.billingStreet2), "Could not type the billing address2"+providerData.toString(),selenium, ClassName, MethodName);
					assertTrue(type(selenium, txtCityPro,providerData.billingCity), "Could not type the billing city"+providerData.toString(),selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,ajxBillingStatesuggestBox,providerData.billingState);
					assertTrue(type(selenium,txtBillingZipPostalCode,providerData.billingZipcode), "Could not type the billing zip code"+providerData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					selenium.keyPress(txtBillingCountrysuggestBox, "\\9");
					click(selenium,btnYes);
					waitForElementToEnable(selenium, txtCityPro);
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,ajxBillingStatesuggestBox);
					waitForPageLoad(selenium);
					waitForElementToEnable(selenium,txtBillingCountrysuggestBox);
					waitForPageLoad(selenium);
					
				
			}
			if(!userAccount.equals(CAAccount)){
			if(providerData.billingInfoCheck.equals("Yes")){
				click(selenium, chkSignatureOnFilecheckbox);
				assertTrue(enterDate(selenium,txtSignatureDate,providerData.signatureDate),"Could not type Date More Details:"+providerData.toString(),selenium, ClassName, MethodName);
				
			}
			assertTrue(type(selenium,txtDea,providerData.dEA),"Could not type txt DEA More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtUpinPro,providerData.uPIN),"Could not type txt uPIN More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtNpi,providerData.nPI),"Could not type txt nPI More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium,ajxReportMethodsuggestBox,providerData.reportMethod);
			while(isElementPresent(selenium,"//div[17]/div/div[2]/div/div/div/span/button")){
				assertTrue(click(selenium,"//div[17]/div/div[2]/div/div/div/span/button"),"Could not click Button",selenium, ClassName, MethodName);
				while(selenium.getConfirmation().matches("Are you sure you want to delete this identifier?"));
				selenium.chooseOkOnNextConfirmation();
				click(selenium,btnYes);
				waitForPageLoad(selenium);
				}
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			if(isElementPresent(selenium,"okButton")){
				click(selenium,"okButton");
			}
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}

	
	/**
	 * addProgramInProvider
	 * @param 		selenium
	 * @param 		providerData
	 * @throws IOException 
	 * @since  	    August 17, 2012
	 */	
	
	public boolean addProgramInProvider(Selenium selenium,SystemSettingsLib providerData) throws IOException
	{
		boolean returnValue=false;
		try{
			click(selenium,btnAddButton );
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSearchOrg ),"Could not click the search button"+providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,chkBoxOrg),"Could not click the check box"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			
			if(getText(selenium,txtProviderName).contains(providerData.firstName))
				returnValue=true;
			else
				Assert.fail("Could not add program in providers.");
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}

	/**
	 * deleteProgramInProvider
	 * @param 		selenium
	 * @param 		providerData
	 * @since  	    August 23, 2012
	 */	
	public boolean deleteProgramInProvider(Selenium selenium,SystemSettingsLib providerData)
	{
		boolean returnValue=false;
		try{
			click(selenium,btnAddButton );
			waitForPageLoad(selenium);
			while(isElementPresent(selenium,btnSearchorg)){
				waitForPageLoad(selenium);
				click(selenium,btnSearchorg);
				waitForPageLoad(selenium);
				try {
					assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,btnYes))
					returnValue=true;
				else
					Assert.fail("Could not add program in providers.");
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}

	/**
	 * createEnterPrise
	 * function to create EnterPrise
	 * @since  	     June 06, 2012
	 */	
	public boolean createEnterPrise(Selenium selenium,SystemSettingsLib enterPriseData,String uniqueName){
		try{
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxSuggestBox,enterPriseData.idType);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtVariableBox,enterPriseData.idName+uniqueName),"Could not enter the IdName;More Details:"+enterPriseData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String eName = getValue(selenium,txtVariableBox);
			enterPriseData.idName = eName;
			
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+enterPriseData.toString(),selenium, ClassName, MethodName);
			
			// Verify if the created enterprise Variables is present. Using the IsTextPresent instead of ElementPresent 
			//selenium.isTextPresent (enterPriseData.idName+uniqueName);
		
			/*if(isElementPresent(selenium,lblTitle)){
				return true;
			}else{
				return false;
			}*/
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
	 * deleteEnterPrise
	 * function to delete EnterPrise
	 * @since  	     June 06, 2012
	 */	
	public boolean deleteEnterPrise(Selenium selenium,SystemSettingsLib epData){
		try{
			waitForPageLoad(selenium);
			assertTrue(type(selenium,btnSearchButton ,epData.idName),"Could not enter the variable type",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSearchBox),"Could not click on Search button:" + epData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			int count =1;
			while(isElementPresent(selenium,"//div[@id='EnterpriseIDList']/table/tbody/tr["+count+"]/td/div")){
				assertTrue(click(selenium,btnSearchBox),"Could not click on Search button:" + epData .toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				if((getText(selenium,"//div[@id='EnterpriseIDList']/table/tbody/tr["+count+"]/td").trim().contains(epData.idType.trim()))
						&& (getText(selenium,"//div[@id='EnterpriseIDList']/table/tbody/tr["+count+"]/td[2]").trim().contains(epData.idName.trim()))){
					click(selenium,"//div[@id='EnterpriseIDList']/table/tbody/tr["+count+"]/td[3]/div/div/a[2]");
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnYes),"Could not click on Search button:" + epData .toString(),selenium, ClassName, MethodName);
					}else {count++;}
				if(count>15){
					break;
				}
			}	
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	
	/**
	 * create Associate Department
	 * function to create Associate Department
	 * @since  	     June 06, 2012
	 */	
	public boolean createAssociateDepartment(Selenium selenium,SystemSettingsLib departmentData, String departCode) throws IOException{
		
		try{
			assertTrue(type(selenium,txtDepartmentName,departmentData.department+departCode),"Could not type a program name" + departmentData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtdescription ,departmentData.description),"Could not type a description" + departmentData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + departmentData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddProgram),"Could not click the add button;More Details:"+departmentData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxSuggestBoxProg ,departmentData.department+departCode);
			assertTrue(type(selenium,typeProgramName ,departmentData.department+departCode),"Could not type the program;More Deatils:"+departmentData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtdescription ,departmentData.description),"Could not type the description;More Deatils:"+departmentData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+departmentData.toString(),selenium, ClassName, MethodName);
			if(isElementPresent(selenium,btnEdit1)){
				assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click on Org Structures Link;More Details:"+departmentData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				return true;
			}else{
				return false;
			}
			
				
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + departmentData.toString());
		}
		return true;
		
	}	
	
	/**
	 * createAddressBookForSearch
	 * function to add a AddressBook
	  * @since  	     may 17, 2012
	 */  
	
	public boolean createAddressBookForSearch(Selenium selenium, SystemSettingsLib providerData) throws IOException {
		try{
			if(providerData.contactLevel.equalsIgnoreCase("Global"))
			{
				assertTrue(click(selenium,rdGlobal), "could not click contact level",selenium, ClassName, MethodName);
			}
			else{
				assertTrue(click(selenium,rdLocal), "could not click contact level",selenium, ClassName, MethodName);
			}
				
			selectValueFromAjaxList(selenium,  ajxContactSuggestBox, providerData.contactType);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtAddContactCompany, providerData.contactCompany),"Could not Enter the Company;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,  txtAddBookLastName, providerData.lastName),"Could not enter Last Name; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddBkFirstName, providerData.firstName),"Could not enter First Name; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,  txtAddBkDept, providerData.department),"Could not enter Department; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddSave),"Could not find save button; More Details:" + providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			if(isElementPresent(selenium, txtSearchBox )){
				return true;
			}else{
				return false;
				}
			}
			catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString());
			return false;
		}
	}
	
	/**
	 * createMandatoryUserField
	 * function to create Mandatory User Field
	 * @since  	    June 27, 2012
	 */	
	public boolean createMandatoryUserField(Selenium selenium,SystemSettingsLib mandData){
		try{
			waitForPageLoad(selenium);
			click(selenium,"unitsuggestBox");
			selectValueFromAjaxList(selenium,"unitsuggestBox",mandData.unit);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"fieldsuggestBox",mandData.field);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+mandData.toString() ,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selenium.isTextPresent(mandData.unit), "unit not present" ,selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			return true;
			
			/*if(isElementPresent(selenium,lblPatientIdentifierGroup)){
				return true;
			}else{
				return false;
			}*/
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * deleteAllMandatoryUserField
	 * function to delete All MandatoryUserField
	 * @throws IOException 
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllMandatoryUserField(Selenium selenium) throws IOException{
		boolean mandatoryDeleted = true;
		int mandatoryCount = 0;
		try{
			waitForElement(selenium, "//div[@id='adminMandatoryUserFieldList']/table/tbody/tr/td[2]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='adminMandatoryUserFieldList']/table/tbody/tr/td[2]/div/a") > 0){
				mandatoryCount = (Integer) selenium.getXpathCount("//div[@id='adminMandatoryUserFieldList']/table/tbody/tr/td[2]/div/a");
				assertTrue(click(selenium,"//div[@id='adminMandatoryUserFieldList']/table/tbody/tr/td[2]/div/a"),"Click Failed",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYes),"Clic Failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(mandatoryCount == (Integer) selenium.getXpathCount("//div[@id='adminMandatoryUserFieldList']/table/tbody/tr/td[2]/div/a")){
					mandatoryDeleted = false;
					break;
				}
			}
			return mandatoryDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * createMandatoryUserFieldUniTests
	 * function to create Mandatory User Field
	 * @since  	    June 27, 2012
	 */	
	public boolean createMandatoryUserFieldUniTests(Selenium selenium,SystemsSettingsUnitTest mandData){
		try{
			waitForPageLoad(selenium);
			click(selenium,"unitsuggestBox");
			selectValueFromAjaxList(selenium,"unitsuggestBox",mandData.unit);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"fieldsuggestBox",mandData.field);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click the save button;More Details:"+mandData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    if(isElementPresent(selenium,lblPatientIdentifierGroup)){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * verifySelectOptionForIntenalProvider
	 * function to verify the display of the selected option in the pick list 
	 * @since  	    July 05, 2012
	 */	
	public boolean verifySelectOptionForIntenalProvider(Selenium selenium, SystemSettingsLib providerData){
		boolean returnValue=true;
		try{
			selectValueFromAjaxList(selenium,ajxProviderTypesuggestBox,providerData.providerType);
			waitForPageLoad(selenium);
			selenium.clickAt(ajxProviderTypesuggestBox,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lstItemSelected ))
			{
				if(getText(selenium, lstItemSelected ).equalsIgnoreCase(providerData.providerType))
					if(isElementPresent(selenium,lstSuggestBoxOracle))
					{
						returnValue=true;
						click(selenium, lstItemSelected );
					}
			}
			else
				return false;
			selectValueFromAjaxList(selenium, ajxTitleSuggestBox,providerData.title);
			waitForPageLoad(selenium);
			selenium.clickAt( ajxTitleSuggestBox,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lstItemSelected ))
			{
				if(getText(selenium, lstItemSelected ).equalsIgnoreCase(providerData.title))
					if(isElementPresent(selenium,lstSuggestBoxOracle))
					{
						returnValue=true;
						click(selenium, lstItemSelected );
					}
			}
			else
				return false;
			selectValueFromAjaxList(selenium,ajxGendersuggestBox ,providerData.gender);
			waitForPageLoad(selenium);
			selenium.clickAt(ajxGendersuggestBox ,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lstItemSelected ))
			{
				if(getText(selenium, lstItemSelected ).equalsIgnoreCase(providerData.gender))
					if(isElementPresent(selenium,lstSuggestBoxOracle))
					{
						returnValue=true;
						click(selenium, lstItemSelected );
					}
			}
			else
				return false;
			
			selectValueFromAjaxList(selenium,txtMailingStatesuggestBox,providerData.state);
			waitForPageLoad(selenium);
			selenium.clickAt(txtMailingStatesuggestBox,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lstItemSelected ))
			{
				if(getText(selenium, lstItemSelected ).equalsIgnoreCase(providerData.state))
					if(isElementPresent(selenium,lstSuggestBoxOracle))
					{
						returnValue=true;
						click(selenium, lstItemSelected );
					}
			}
			else
				return false;
			selectValueFromAjaxList(selenium,txtMailingCountrysuggestBox,providerData.country);
			waitForPageLoad(selenium);
			selenium.clickAt(txtMailingCountrysuggestBox,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lstItemSelected ))
			{
				if(getText(selenium, lstItemSelected ).equalsIgnoreCase(providerData.country))
					if(isElementPresent(selenium,lstSuggestBoxOracle))
					{
						returnValue=true;
						click(selenium, lstItemSelected );
					}
			}
			else
				return false;
		}catch(Exception e){
			e.printStackTrace();
		}return returnValue;
	}
	/**
	 * verifySelectOptionForUser
	 * function to verify the display of the selected option in the pick list 
	 * @since  	    July 05, 2012
	 */	
	public boolean verifySelectOptionForUser(Selenium selenium, SystemSettingsLib UserData){
		boolean returnValue=true;
		try{
			selectValueFromAjaxList(selenium,ajxExternalEmrsuggestBox,UserData.externalEmr);
			waitForPageLoad(selenium);
			selenium.clickAt(ajxExternalEmrsuggestBox,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lstItemSelected ))
			{
				if(getText(selenium, lstItemSelected ).equalsIgnoreCase(UserData.externalEmr))
					if(isElementPresent(selenium,lstSuggestBoxOracle))
					{
						returnValue=true;
						click(selenium,lstItemSelected);
					}
			}
			else
				return false;
			
			selectValueFromAjaxList(selenium,ajxRoleSuggestBox1suggestBox,UserData.userRole);
			waitForPageLoad(selenium);
			selenium.clickAt(ajxRoleSuggestBox1suggestBox,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lstItemSelected ))
			{
				if(getText(selenium, lstItemSelected ).equalsIgnoreCase(UserData.userRole))
					if(isElementPresent(selenium,lstSuggestBoxOracle))
					{
						returnValue=true;
						click(selenium,lstItemSelected);
					}
			}
			else
				return false;
			selectValueFromAjaxList(selenium,ajxPracticeSuggestBox1,UserData.practice);
			waitForPageLoad(selenium);
			selenium.clickAt(ajxPracticeSuggestBox1,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lstItemSelected ))
			{
				if(getText(selenium, lstItemSelected ).equalsIgnoreCase(UserData.practice))
					if(isElementPresent(selenium,lstSuggestBoxOracle))
					{
						returnValue=true;
						click(selenium,lstItemSelected);
					}
			}
			else
				return false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			
		}return returnValue;
	}
	/**
	 * verifySelectOptionForAddressBook
	 * function to verify the display of the selected option in the pick list 
	 * @since  	    July 05, 2012
	 */	
	public boolean verifySelectOptionForAddressBook(Selenium selenium, SystemSettingsLib AddbookData){
		boolean returnValue=true;
		try{
			selectValueFromAjaxList(selenium,ajxContactSuggestBox,AddbookData.contactType);
			waitForPageLoad(selenium);
			selenium.clickAt(ajxContactSuggestBox,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lstItemSelected)){
				if(getText(selenium, lstItemSelected).equalsIgnoreCase(AddbookData.contactType))
					if(isElementPresent(selenium,lstSuggestBoxOracle)){
						returnValue=true;
						click(selenium,lstItemSelected);
					}
			}
			else
				return false;
			
			selectValueFromAjaxList(selenium,ajxTitleSuggestBox,AddbookData.title);
			waitForPageLoad(selenium);
			selenium.clickAt( ajxTitleSuggestBox,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lstItemSelected)){
				if(getText(selenium, lstItemSelected).equalsIgnoreCase(AddbookData.title))
					if(isElementPresent(selenium,lstSuggestBoxOracle)){
						returnValue=true;
						click(selenium,lstItemSelected);
					}
			}
			else
				return false;
			
			selectValueFromAjaxList(selenium,ajxCommTy1suggestBox,AddbookData.telephoneType1);
			waitForPageLoad(selenium);
			selenium.clickAt(ajxCommTy1suggestBox,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lstItemSelected)){
				if(getText(selenium, lstItemSelected).equalsIgnoreCase(AddbookData.telephoneType1))
					if(isElementPresent(selenium,lstSuggestBoxOracle)){
						returnValue=true;
						click(selenium, lstItemSelected );
					}
			}
			else
				return false;
			
			selectValueFromAjaxList(selenium,ajxCommTy2suggestBox,AddbookData.telephoneType2);
			waitForPageLoad(selenium);
			selenium.clickAt(ajxCommTy2suggestBox,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lstItemSelected)){
				if(getText(selenium, lstItemSelected).equalsIgnoreCase(AddbookData.telephoneType2))
					if(isElementPresent(selenium,lstSuggestBoxOracle)){
						returnValue=true;
						click(selenium,lstItemSelected);
					}
			}
			else
				return false;
			
			selectValueFromAjaxList(selenium,ajxCommTy3suggestBox,AddbookData.telephoneType3);
			waitForPageLoad(selenium);
			selenium.clickAt(ajxCommTy3suggestBox,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lstItemSelected)){
				if(getText(selenium, lstItemSelected).equalsIgnoreCase(AddbookData.telephoneType3))
					if(isElementPresent(selenium,lstSuggestBoxOracle)){
						returnValue=true;
						click(selenium,lstItemSelected);
					}
			}
			else
				return false;
			
			selectValueFromAjaxList(selenium,ajxAddBkStateSuggestBox,AddbookData.state);
			waitForPageLoad(selenium);
			selenium.clickAt(ajxAddBkStateSuggestBox,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lstItemSelected)){
				if(getText(selenium, lstItemSelected).equalsIgnoreCase(AddbookData.state))
					if(isElementPresent(selenium,lstSuggestBoxOracle)){
						returnValue=true;
						click(selenium,lstItemSelected);
					}
			}
			else
				return false;
			
			selectValueFromAjaxList(selenium,cmbAddBkCountrySuggestBox,AddbookData.country);
			waitForPageLoad(selenium);
			selenium.clickAt(cmbAddBkCountrySuggestBox,"");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, lstItemSelected)){
				if(getText(selenium, lstItemSelected).equalsIgnoreCase(AddbookData.country))
					if(isElementPresent(selenium,lstSuggestBoxOracle)){
						returnValue=true;
						click(selenium,lstItemSelected);
					}
			}
			else
				return false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
		
		
	}
	
	/**
	 * addPractice
	 * function to create an Provider.
	 * @param 		selenium
	 * @param 		pracData
	 * @since  	    July 30, 2012
	 */	
	public boolean addPractice(Selenium selenium,SystemSettingsLib pracData,String account) throws IOException{
		try{
			
			assertTrue(type(selenium,btnPracticeName,pracData.practiceName),"Could not enter the practice name"+ pracData.toString(),selenium, ClassName, MethodName);
			//Assert.assertTrue(type(selenium,btnPracticeCode,pracData.practiceCode),"Could not enter the practice code"+ pracData.toString());
		    assertTrue(type(selenium,btnTaxId,pracData.taxId),"Could not enter the tax id"+ pracData.toString(),selenium, ClassName, MethodName);
			//Assert.assertTrue(type(selenium,txtGroupNpi,pracData.groupNpi),"Could not enter the tax id"+ pracData.toString());
			assertTrue(type(selenium,txtEmail ,pracData.email),"Could not enter email"+ pracData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxCommTy1suggestBox,pracData.primaryPhoneType1);
			assertTrue(type(selenium,txtPrimaryPhone,pracData.primaryPhoneNumber1),"Could not enter primary phone number"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPrimaryPhoneExt,pracData.primaryPhoneExtn1),"Could not enter primary phone extension"+ pracData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxCommTy2suggestBox,pracData.primaryPhoneType2);
			assertTrue(type(selenium,txtOtherPhone1 ,pracData.primaryPhoneNumber2),"Could not enter other phone type"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtOtherPhone1Extn,pracData.primaryPhoneExtn2),"Could not enter other phone extn"+ pracData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxCommTy3suggestBox,pracData.primaryPhoneType3);
			assertTrue(type(selenium,txtOtherPhone2,pracData.primaryPhoneNumber3),"Could not enter other phone"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtOtherPhone2Extn,pracData.primaryPhoneExtn3),"Could not enter other phone extn"+ pracData.toString(),selenium, ClassName, MethodName);
			//Assert.assertTrue(type(selenium,"css=textarea.gwt-TextArea",pracData.comments),"Could not enter comments"+ pracData.toString());
			
			assertTrue(type(selenium,txtAddr1,pracData.address1),"Could not enter address1"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr2,pracData.address2),"Could not enter address2"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter city"+ pracData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.state);
			if(account.equals(CAAccount)){
				assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}else
				assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			click(selenium,"noButton");
			selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,pracData.country);
			
			/*Assert.assertTrue(type(selenium,txtBillingAddr1,pracData.billlingaddress1),"Could not enter billing address1"+ pracData.toString());
			Assert.assertTrue(type(selenium,txtBillingAddr2,pracData.billingaddress2),"Could not enter billing address2"+ pracData.toString());
			Assert.assertTrue(type(selenium, txtCityPro,pracData.billingcity),"Could not enter billing city"+ pracData.toString());
			selectValueFromAjaxList(selenium,txtBillingStateSuggestBox,pracData.billingstate);
			//Assert.assertTrue(type(selenium,txtBillingZip,pracData.billingzipcode),"Could not enter billing zipcode"+ pracData.toString());
			if(account.equals(CAAccount)){
				Assert.assertTrue(type(selenium,txtBillingZip,pracData.billingzipcodeCA),"Could not enter zipcode"+ pracData.toString());
			}else
				Assert.assertTrue(type(selenium,txtBillingZip,pracData.billingzipcode),"Could not enter zipcode"+ pracData.toString());
			
			click(selenium,"noButton");
			selectValueFromAjaxList(selenium,ajxBillingCountrySuggestBox,pracData.billingcountry);*/
	
			if(!pracData.testCaseId.contains("TC_CPR_006")){
				assertTrue(click(selenium,btnDonePratice),"Could not click on save button"+ pracData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			if(pracData.testCaseId.contains("TC_CPR_003")){
				return true;
			}
			
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * addPracticeWithMandatory
	 * function to create an Provider.
	 * @param 		selenium
	 * @param 		pracData
	 * @since  	    July 31, 2012
	 */	
	public boolean addPracticeWithMandatory(Selenium selenium,SystemSettingsLib pracData,String account) throws IOException  {
		try{
			assertTrue(click(selenium,btnAddPractice),"Could not find add practice button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(type(selenium,btnPracticeName,pracData.practiceName+uniqueName),"Could not enter the practice name"+ pracData.toString(),selenium, ClassName, MethodName);
			if(!account.equals(CAAccount)){
			assertTrue(type(selenium,btnTaxId,pracData.taxId),"Could not enter the tax id"+ pracData.toString(),selenium, ClassName, MethodName);
			}
			/*selectValueFromAjaxList(selenium,ajxCommTy1suggestBox,pracData.primaryPhoneType1);
			Assert.assertTrue(type(selenium,txtPrimaryPhone,pracData.primaryPhoneNumber1),"Could not enter primary phone number"+ pracData.toString());
			Assert.assertTrue(type(selenium,txtPrimaryPhoneExt,pracData.primaryPhoneExtn1),"Could not enter primary phone extension"+ pracData.toString());*/
			assertTrue(type(selenium,txtAddr1,pracData.address1),"Could not enter address1"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr2,pracData.address2),"Could not enter address2"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter city"+ pracData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxPracticeType,pracData.practiceType);
			if(account.equals(CAAccount)){
				selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.stateCA);
				assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}else{
				selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.state);
				assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}
				
			click(selenium,btnYes);
			selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,pracData.country);
			
			
			/*Assert.assertTrue(type(selenium,txtBillingAddr1,pracData.billlingaddress1),"Could not enter billing address1"+ pracData.toString());
			Assert.assertTrue(type(selenium,txtBillingAddr2,pracData.billingaddress2),"Could not enter billing address2"+ pracData.toString());
			Assert.assertTrue(type(selenium, txtCityPro,pracData.billingcity),"Could not enter billing city"+ pracData.toString());
			selectValueFromAjaxList(selenium,txtBillingStateSuggestBox,pracData.billingstate);
			Assert.assertTrue(type(selenium,txtBillingZip,pracData.billingzipcode),"Could not enter billing zipcode"+ pracData.toString());
			click(selenium,btnYes);
			selectValueFromAjaxList(selenium,ajxBillingCountrySuggestBox,pracData.billingcountry);*/
			//Assert.assertTrue(click(selenium,btnSave),"Could not click on save button"+ pracData.toString());
			
			assertTrue(click(selenium,"xpath=(//button[@type='button'])[3]"),"could not click the done button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			System.out.println();
			if(isElementPresent(selenium,"edit")){
				return true;
			}
			else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * addPracticeWithMandatory
	 * function to create an Provider.
	 * @param 		selenium
	 * @param 		pracData
	 * @throws IOException 
	 * @since  	    July 31, 2012
	 */	
	public boolean addPracticeWithMandatoryPortability(Selenium selenium,SystemSettingsLib pracData,String account) throws IOException{
		try{
			assertTrue(click(selenium,btnAddPractice),"Could not find add practice button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,btnPracticeName,pracData.practiceName),"Could not enter the practice name"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,btnTaxId,pracData.taxId),"Could not enter the tax id"+ pracData.toString(),selenium, ClassName, MethodName);
			/*selectValueFromAjaxList(selenium,ajxCommTy1suggestBox,pracData.primaryPhoneType1);
			Assert.assertTrue(type(selenium,txtPrimaryPhone,pracData.primaryPhoneNumber1),"Could not enter primary phone number"+ pracData.toString());
			Assert.assertTrue(type(selenium,txtPrimaryPhoneExt,pracData.primaryPhoneExtn1),"Could not enter primary phone extension"+ pracData.toString());*/
			assertTrue(type(selenium,txtAddr1,pracData.address1),"Could not enter address1"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr2,pracData.address2),"Could not enter address2"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter city"+ pracData.toString(),selenium, ClassName, MethodName);
			
			if(account.equals(CAAccount)){
				selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.stateCA);
				assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}else{
				selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.state);
				assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}
			click(selenium,btnYes);
			selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,pracData.country);
			assertTrue(type(selenium,txtBillingAddr1,pracData.billlingaddress1),"Could not enter billing address1"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtBillingAddr2,pracData.billingaddress2),"Could not enter billing address2"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtCityPro,pracData.billingcity),"Could not enter billing city"+ pracData.toString(),selenium, ClassName, MethodName);
			
			if(account.equals(CAAccount)){
				selectValueFromAjaxList(selenium,txtBillingStateSuggestBox,pracData.stateCA);
				assertTrue(type(selenium,txtBillingZip,pracData.billingzipcodeCA),"Could not enter billing zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}
			else{
				selectValueFromAjaxList(selenium,txtBillingStateSuggestBox,pracData.state);
				assertTrue(type(selenium,txtBillingZip,pracData.billingzipcode),"Could not enter billing zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}
			click(selenium,btnYes);
			selectValueFromAjaxList(selenium,ajxBillingCountrySuggestBox,pracData.billingcountry);
			
			
			//Add first location for the created practice
			assertTrue(click(selenium,txtAddLocationButton),"Could not click add location button",selenium, ClassName, MethodName);
			
			
			assertTrue(type(selenium,txtLocationName0,pracData.locationCode),"Could not enter location code"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtLocationDescription0,pracData.locationName1),"Could not location description"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtBillingLocationName0,pracData.locationName1),"Could not enter location name"+ pracData.toString(),selenium, ClassName, MethodName);
			
			assertTrue(type(selenium,txtAddr1Loc1,pracData.address1),"Could not enter address1"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr2Loc1,pracData.address2),"Could not enter address2"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCityLoc1 ,pracData.city),"Could not enter city"+ pracData.toString(),selenium, ClassName, MethodName);
			
			if(account.equals(CAAccount)){
				selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBoxLoc1,pracData.stateCA);
				assertTrue(type(selenium,txtZipLoc1,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}else{
				selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBoxLoc1,pracData.state);
				assertTrue(type(selenium,txtZipLoc1,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}
			click(selenium,btnYes);
			selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBoxLoc1,pracData.country);
			
			
			//Add second location for the created practice
			assertTrue(click(selenium,txtAddLocationButton),"Could not click add location button",selenium, ClassName, MethodName);
			
			
			assertTrue(type(selenium,txtLocationName1,pracData.locationCode),"Could not enter location code"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtLocationDescription1,pracData.locationName2),"Could not location description"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtBillingLocationName1,pracData.locationName2),"Could not enter location name"+ pracData.toString(),selenium, ClassName, MethodName);
			
			assertTrue(type(selenium,txtAddr1Loc2,pracData.address1),"Could not enter address1"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr2Loc2,pracData.address2),"Could not enter address2"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCityLoc2 ,pracData.city),"Could not enter city"+ pracData.toString(),selenium, ClassName, MethodName);
			if(account.equals(CAAccount)){
				selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBoxLoc2,pracData.stateCA);
				assertTrue(type(selenium,txtZipLoc2,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}else{
				selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBoxLoc2,pracData.state);
				assertTrue(type(selenium,txtZipLoc2,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}
			click(selenium,btnYes);
			selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBoxLoc2,pracData.country);
			
			
			
			assertTrue(click(selenium,btnSave),"Could not click on save button"+ pracData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			if(isElementPresent(selenium,lnkSelectPeople)){
				return true;
			}
			else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	public boolean addLocationPortability(Selenium selenium,SystemSettingsLib pracData,String account){
		try{
			assertTrue(click(selenium,btnEdit1),"Could not click edit button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"xpath=(//button[@type='button'])[2]"),"Could not click next button in practice wizard",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"xpath=(//button[@type='button'])[7]"),"Could not click cancel button in practice wizard location",selenium, ClassName, MethodName);
			
			
			int count=0;
			while(isElementPresent(selenium, "link=Delete")){
				if(getText(selenium, "link=Delete").equalsIgnoreCase("Delete")){
					click(selenium, "link=Delete");
					click(selenium,"yesButton");
				}
				count++;
				if(count>20){
					break;
				}
			}
			
			
			//Add first location for the created practice
			//Assert.assertTrue(click(selenium,txtAddLocationButton),"Could not click add location button");
			assertTrue(click(selenium,"css=button.secondary-button.left-button-spacer"),"Could not click add location button",selenium, ClassName, MethodName);
			
			
		    assertTrue(type(selenium,txtLocationName,pracData.locationCode),"Could not enter location code"+ pracData.toString(),selenium, ClassName, MethodName);
			//Assert.assertTrue(type(selenium,txtLocationDescription0,pracData.locationName1),"Could not location description"+ pracData.toString());
			assertTrue(type(selenium,txtBillingLocationName,pracData.locationName1),"Could not enter location name"+ pracData.toString(),selenium, ClassName, MethodName);
			
			assertTrue(type(selenium,txtAddr1,pracData.address1),"Could not enter address1"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr2,pracData.address2),"Could not enter address2"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter city"+ pracData.toString(),selenium, ClassName, MethodName);
			
			if(account.equals(CAAccount)){
				selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.stateCA);
				assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}else{
				selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBoxLoc1,pracData.state);
				assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}
			click(selenium,btnYes);
			selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,pracData.country);
			
			if(!isChecked(selenium,"schedulingAppointmentsFlagcheckbox")){
				click(selenium,"schedulingAppointmentsFlagcheckbox");
			}
			
			//Add second location for the created practice
			assertTrue(click(selenium,txtAddLocationButton),"Could not click add location button",selenium, ClassName, MethodName);
			
			
			assertTrue(type(selenium,txtLocationName,pracData.locationCode),"Could not enter location code"+ pracData.toString(),selenium, ClassName, MethodName);
			//Assert.assertTrue(type(selenium,txtLocationDescription1,pracData.locationName2),"Could not location description"+ pracData.toString());
			assertTrue(type(selenium,txtBillingLocationName,pracData.locationName2),"Could not enter location name"+ pracData.toString(),selenium, ClassName, MethodName);
			
			assertTrue(type(selenium,txtAddr1,pracData.address1),"Could not enter address1"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr2,pracData.address2),"Could not enter address2"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter city"+ pracData.toString(),selenium, ClassName, MethodName);
			
			if(account.equals(CAAccount)){
				selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.stateCA);
				assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}else{
				selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.state);
				assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}
			click(selenium,btnYes);
			selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,pracData.country);
			

			if(!isChecked(selenium,"schedulingAppointmentsFlagcheckbox")){
				click(selenium,"schedulingAppointmentsFlagcheckbox");
			}
			
			if(pracData.testCaseId.equals("TC_CPR_002")){
				assertTrue(click(selenium,txtAddLocationButton),"Could not click add location button",selenium, ClassName, MethodName);
				
				
				assertTrue(type(selenium,txtLocationName,pracData.locationCode),"Could not enter location code"+ pracData.toString(),selenium, ClassName, MethodName);
				//Assert.assertTrue(type(selenium,txtLocationDescription3,pracData.locationName3),"Could not location description"+ pracData.toString());
				assertTrue(type(selenium,txtBillingLocationName,pracData.locationName3),"Could not enter location name"+ pracData.toString(),selenium, ClassName, MethodName);
				
				assertTrue(type(selenium,txtAddr1,pracData.address1),"Could not enter address1"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtAddr2,pracData.address2),"Could not enter address2"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter city"+ pracData.toString(),selenium, ClassName, MethodName);
				
				if(account.equals(CAAccount)){
					selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.stateCA);
					assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
				}else{
					selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.state);
					assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
				}
				click(selenium,btnYes);
				selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,pracData.country);
				
				if(!isChecked(selenium,"schedulingAppointmentsFlagcheckbox")){
					click(selenium,"schedulingAppointmentsFlagcheckbox");
				}
				
				assertTrue(click(selenium,txtAddLocationButton),"Could not click add location button",selenium, ClassName, MethodName);
				
				
				assertTrue(type(selenium,txtLocationName,pracData.locationCode),"Could not enter location code"+ pracData.toString(),selenium, ClassName, MethodName);
				//Assert.assertTrue(type(selenium,txtLocationDescription4,pracData.locationName4),"Could not location description"+ pracData.toString());
				assertTrue(type(selenium,txtBillingLocationName,pracData.locationName4),"Could not enter location name"+ pracData.toString(),selenium, ClassName, MethodName);
				
				assertTrue(type(selenium,txtAddr1,pracData.address1),"Could not enter address1"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtAddr2,pracData.address2),"Could not enter address2"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter city"+ pracData.toString(),selenium, ClassName, MethodName);
				
				if(account.equals(CAAccount)){
					selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.stateCA);
					assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
				}else{
					selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.state);
					assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
				}
				click(selenium,btnYes);
				selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBoxLoc4,pracData.country);
				if(!isChecked(selenium,"schedulingAppointmentsFlagcheckbox")){
					click(selenium,"schedulingAppointmentsFlagcheckbox");
				}
			}
			
			//Assert.assertTrue(click(selenium,btnSave),"Could not click on save button"+ pracData.toString());
			assertTrue(click(selenium,"xpath=(//button[@type='button'])[6]"),"Could not click on save button"+ pracData.toString(),selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			
			
			if(isElementPresent(selenium,lnkSelectPeople)){
				if(!(getText(selenium, lblResultPractice).contains(pracData.locationName1))&&
						(getText(selenium, lblResultPractice).contains(pracData.locationName2))){
					return true;
				}
			}
			else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	
	/**
	 * createPacticeUnitTest
	 * function to create unit test for provider fields
	 * @param 		selenium
	 * @param 		practiceData
	 * @throws IOException 
	 * @since  	    August 13, 2012
	 */	
	public boolean createPacticeUnitTest(Selenium selenium,SystemsSettingsUnitTest practiceData) throws IOException{
		try{
			
			assertTrue(type(selenium,btnPracticeName,practiceData.practiceName),"Could not type the practice name",selenium, ClassName, MethodName);
			assertTrue(type(selenium,btnPracticeCode,practiceData.practiceCode),"Could not type the practice name",selenium, ClassName, MethodName);
			assertTrue(type(selenium,btnTaxId,practiceData.taxId),"Could not type the practice name",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtGroupNpi,practiceData.groupNPI),"Could not type the practice name",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtEmail ,practiceData.email),"Could not type the practice name",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxCommTy1suggestBox,practiceData.telephoneType1);
			assertTrue(type(selenium,txtPrimaryPhone,practiceData.telephoneNo1),"Could not type the primary phone number",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPrimaryPhoneExt,practiceData.telephoneextnNo1),"Could not type the primary phone number extension",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxCommTy2suggestBox,practiceData.telephoneType2);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtOtherPhone1 ,practiceData.telephoneNo2),"Could not type the other phone extension 1",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtOtherPhone1Extn,practiceData.telephoneextnNo2),"Could not type telephone extension 1",selenium, ClassName, MethodName);
		    assertTrue(type(selenium,ajxCommTy3suggestBox,practiceData.telephoneType3),"Could not type the primary phone number",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtOtherPhone2,practiceData.telephoneNo3),"Could not type the primary phone number",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtOtherPhone2Extn,practiceData.telephoneextnNo3),"Could not type the primary phone number",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr1,practiceData.address1),"Could not type the practice name",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr2,practiceData.address2),"Could not type the practice name",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCity ,practiceData.city),"Could not type the practice name",selenium, ClassName, MethodName);
			assertTrue(type(selenium, ajxStateSuggestBoxSuggestBox,practiceData.state),"Could not type the practice name",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtZip,practiceData.zipcode),"Could not type the practice name",selenium, ClassName, MethodName);
			assertTrue(type(selenium,ajxStateCountryBoxSuggestBox,practiceData.country),"Could not type the practice name",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtBillingAddr1,practiceData.billingStreet1),"Could not type the practice name",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtBillingAddr2,practiceData.billingStreet2),"Could not type the practice name",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtCityPro,practiceData.billingCity),"Could not type the practice name",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtBillingStateSuggestBox,practiceData.billingState),"Could not type the practice name",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtBillingZip,practiceData.billingZipcode),"Could not type the practice name",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxBillingCountrySuggestBox,practiceData.billingCountry);
			
			if(practiceData.locationPresent.equals("Yes"))
			{
				assertTrue(click(selenium,txtAddLocationButton),"Could not click Add Location button.",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtLocationCode0,practiceData.locationCode),"Could not type the location code",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtLocationDescription0,practiceData.description),"Could not type the location description",selenium, ClassName, MethodName);
				assertTrue(type(selenium, txtLocationName0,practiceData.billingLocationName),"Could not type the location name",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,txtCommType10SuggestBox,practiceData.locationtelephoneType1);
				click(selenium,"//div[9]/div/div/div/div/div");				
				assertTrue(type(selenium,txtPrimaryPhone0,practiceData.locationtelephoneNo1),"Could not type the primary phone number",selenium, ClassName, MethodName);
				waitForElementToEnable(selenium,txtPrimaryPhoneExtension0);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtPrimaryPhoneExtension0,practiceData.locationtelephoneextnNo1),"Could not type the primary phone number extension",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,txtCommType20SuggestBox,practiceData.locationtelephoneType2);
				click(selenium,"//div[9]/div/div/div/div/div");	
				assertTrue(type(selenium,txtOhterPhone10,practiceData.locationtelephoneNo2),"Could not type the other phone extension 1",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForElementToEnable(selenium,txtOtherPhone1Extension0);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtOtherPhone1Extension0,practiceData.locationtelephoneextnNo1),"Could not type the primary phone number",selenium, ClassName, MethodName);
				selectEmptyValueFromAjaxList(selenium,txtCommType30SuggestBox,practiceData.locationtelephoneType3);
				click(selenium,"//div[9]/div/div/div/div/div");	
				assertTrue(type(selenium,txtOhterPhone20,practiceData.locationtelephoneNo3),"Could not type the primary phone number",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtOtherPhone2Extension0,practiceData.locationtelephoneextnNo3),"Could not type the primary phone number",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtNpi0,practiceData.npiNumber),"Could not type the NPI number",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtAddr10,practiceData.businessaddress1),"Could not type the bussiness address1",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtAddr20,practiceData.businessaddress2),"Could not type the business address 2",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtCity0,practiceData.businesscity),"Could not type the business city",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtStateSuggestBox0suggestBox,practiceData.businessstate),"Could not type the business state",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtZip0,practiceData.businesszipcode),"Could not type the business zip",selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,txtCountryBox0suggestBox,practiceData.businesscountry);
			}
			assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + practiceData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}

	
	public boolean addLocation(Selenium selenium,SystemsSettingsUnitTest practiceData, String account) throws IOException{
		
		//Assert.assertTrue(type(selenium,txtLocationName0,practiceData.locationCode),"Could not type the location code");
		assertTrue(type(selenium,txtLocationDescription0,practiceData.description),"Could not type the location description",selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtLocationName0,practiceData.billingLocationName),"Could not type the  location name",selenium, ClassName, MethodName);
		selectValueFromAjaxList(selenium,txtCommType10SuggestBox,practiceData.locationtelephoneType1);
		click(selenium,"//div[9]/div/div/div/div/div");				
		assertTrue(type(selenium,txtPrimaryPhone0,practiceData.locationtelephoneNo1),"Could not type the primary phone number",selenium, ClassName, MethodName);
		waitForElementToEnable(selenium,txtPrimaryPhoneExtension0);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtPrimaryPhoneExtension0,practiceData.locationtelephoneextnNo1),"Could not type the primary phone number extension",selenium, ClassName, MethodName);
		selectValueFromAjaxList(selenium,txtCommType20SuggestBox,practiceData.locationtelephoneType2);
		click(selenium,"//div[9]/div/div/div/div/div");	
		assertTrue(type(selenium,txtOhterPhone10,practiceData.locationtelephoneNo2),"Could not type the other phone extension 1",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForElementToEnable(selenium,txtOtherPhone1Extension0);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtOtherPhone1Extension0,practiceData.locationtelephoneextnNo1),"Could not type the primary phone number",selenium, ClassName, MethodName);
		selectEmptyValueFromAjaxList(selenium,txtCommType30SuggestBox,practiceData.locationtelephoneType3);
		click(selenium,"//div[9]/div/div/div/div/div");	
		assertTrue(type(selenium,txtOhterPhone20,practiceData.locationtelephoneNo3),"Could not type the primary phone number",selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtOtherPhone2Extension0,practiceData.locationtelephoneextnNo3),"Could not type the primary phone number",selenium, ClassName, MethodName);
		assertTrue(type(selenium,"npiNumber",practiceData.npiNumber),"Could not type the NPI number",selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtAddr10,practiceData.businessaddress1),"Could not type the bussiness address1",selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtAddr20,practiceData.businessaddress2),"Could not type the business address 2",selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtCity0,practiceData.businesscity),"Could not type the business city",selenium, ClassName, MethodName);
		
		if(account.equalsIgnoreCase(CAAccount)){
			assertTrue(type(selenium,txtStateSuggestBox0suggestBox,practiceData.businessstateCA),"Could not type the business state",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtZip0,practiceData.businesszipcodeCA),"Could not type the business zip",selenium, ClassName, MethodName);
		}
		
		else{
			assertTrue(type(selenium,txtStateSuggestBox0suggestBox,practiceData.businessstate),"Could not type the business state",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtZip0,practiceData.businesszipcode),"Could not type the business zip",selenium, ClassName, MethodName);
		}
		waitForPageLoad(selenium);
		if(isElementPresent(selenium, btnYesAutomaticAreaByZip))
			assertTrue(click(selenium, btnYesAutomaticAreaByZip) ,"Could not click Yes button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium,txtCountryBox0suggestBox,practiceData.businesscountry);
		
		assertTrue(click(selenium,"xpath=(//button[@type='button'])[7]"),"Could not click on save a program link:" + practiceData .toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	/**
	 * addProviderInPractice
	 * function to search practice
	 * @param 		selenium
	 * @param 		practiceData
	 * @since  	    August 17, 2012
	 */	
	public boolean addProviderInPractice(Selenium selenium,SystemSettingsLib practiceData){
		boolean returnValue=false;
		try{
			
			assertTrue(click(selenium,btnAddProvider),"Could not click add providers button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtProviderSearchBox ,practiceData.provider1),"Could not type in the search box",selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSearch),"Could not click the search button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"//span/input"),"Could not click the search button",selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click the save button",selenium, ClassName, MethodName);
			if(isElementPresent(selenium,btnEdit1))
				returnValue=true;
			else
				returnValue=false;
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	/**
	 * deleteDepartment
	 * function to delete department
	 * @param 		selenium
	 * @param 		deptData
	 * @throws IOException 
	 * @since  	    August 23, 2012
	 */	
	public boolean deleteDepartment(Selenium selenium,SystemSettingsLib deptData) throws IOException{
		boolean returnValue=true;
		try{
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String departCount=getText(selenium, lnkDepartmentCount);
			System.out.println(departCount);
			
	        String splitStr1 = departCount.replaceAll("[()]","");
	        System.out.println(splitStr1);
	        waitForPageLoad(selenium);
	        int departmentCount = Integer.parseInt(splitStr1);
			int counter = 1;
			
			if(departmentCount<=10){
				while(getText(selenium,vfyDelDepartment).contains(deptData.department.trim().toLowerCase(new java.util.Locale("en","US")))){
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					if(getText(selenium,"//div[@id='departments']/table/tbody/tr["+counter+"]/td/div/span".toLowerCase(new java.util.Locale("en","US"))).contains(deptData.department.toLowerCase(new java.util.Locale("en","US")))){
						waitForPageLoad(selenium);
						waitForPageLoad(selenium);
						assertTrue(click(selenium,"//div[@id='departments']/table/tbody/tr["+counter+"]/td[2]/div/a"),"Could not click the delete button",selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						waitForPageLoad(selenium);
						assertTrue(click(selenium,btnYes),"Could not click the yes button",selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						
					}else{
						counter++;
					}
				}
				
			}else{
				
				assertTrue(type(selenium,txtDepartmentSearch,deptData.department),"Could not enter the department name",selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnDepartmentSearch),"Could not click the search button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				while(getText(selenium,vfyDelDepartment.toLowerCase(new java.util.Locale("en","US"))).contains(deptData.department.trim().toLowerCase(new java.util.Locale("en","US")))){
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					if(getText(selenium,"//div[@id='departments']/table/tbody/tr["+counter+"]/td/div/span".toLowerCase(new java.util.Locale("en","US"))).contains(deptData.department.toLowerCase(new java.util.Locale("en","US")))){
						waitForPageLoad(selenium);
						waitForPageLoad(selenium);
						assertTrue(click(selenium,"//div[@id='departments']/table/tbody/tr["+counter+"]/td[2]/div/a"),"Could not click the delete button",selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						waitForPageLoad(selenium);
						assertTrue(click(selenium,btnYes),"Could not click the yes button",selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						
					}
					//counter++;	
				}
				
			}
			
			
			
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}
	
	/**
	 * createDepartment
	 * function to create department
	 * @param 		selenium
	 * @param 		deptData
	 * @since  	    August 23, 2012
	 */	
	public boolean createDepartment(Selenium selenium,SystemSettingsLib deptData,String uniqueName){
		boolean returnValue=false;
		try{
			
			assertTrue(click(selenium,btnAddDepartment),"Could not click on add a department link:" + deptData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtDepartmentName,deptData.department+uniqueName),"Could not type a program name" + deptData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtdescription ,deptData.description),"Could not type a description" + deptData .toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + deptData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!deptData.testCaseId.equals("TC_CD_004")){
				if(isElementPresent(selenium,btnAddDepartment))
						returnValue=true;
					else
						returnValue=false;
			}else
				returnValue=true;
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	/**
	 * createDepartmentForPort
	 * function to create department
	 * @param 		selenium
	 * @param 		deptData
	 * @since  	    August 23, 2012
	 */	
	public boolean createDepartmentForPort(Selenium selenium,SystemSettingsLib deptData){
		boolean returnValue=false;
		try{
			
			assertTrue(click(selenium,btnAddDepartment),"Could not click on add a department link:" + deptData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtDepartmentName,deptData.department),"Could not type a program name" + deptData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtdescription ,deptData.description),"Could not type a description" + deptData .toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + deptData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnAddDepartment))
				returnValue=true;
			else
				returnValue=false;
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	/**
	 * editDepartment
	 * function to edit department
	 * @param 		selenium
	 * @param 		deptData
	  * @since  	    August 23, 2012
	 */	
	public boolean editDepartment(Selenium selenium,SystemSettingsLib deptData,String uniqueName1){
		boolean returnValue=false;
		try{
			assertTrue(type(selenium,txtDepartmentName,deptData.department+uniqueName1),"Could not type a program name" + deptData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtdescription ,deptData.description),"Could not type a description" + deptData .toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + deptData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnAddDepartment))
				returnValue=true;
			else
				returnValue=false;
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

	/**
	 * searchDepartment
	 * function to search department
	 * @param 		selenium
	 * @param 		deptData
	 * @since  	    August 23, 2012
	 */	
	public boolean searchDepartment(Selenium selenium,SystemSettingsLib deptData,String uniqueName){
		boolean returnValue=false;
		try{
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String departCount=getText(selenium, lnkDepartmentCount);
			String splitStr1 = departCount.replaceAll("[()]","");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
				int departmentCount = Integer.parseInt(splitStr1);
				int counter = 1;
			
				if(departmentCount<=10){
					while(selenium.isTextPresent(deptData.department)){
							if(getText(selenium,"//div[@id='departments']/table/tbody/tr["+counter+"]/td/div").contains(deptData.department+uniqueName)){
							waitForPageLoad(selenium);
							waitForPageLoad(selenium);
							waitForPageLoad(selenium);
							assertTrue(click(selenium,"//div[@id='departments']/table/tbody/tr["+counter+"]/td/div"),"Could not click Department From table",selenium, ClassName, MethodName);
							waitForPageLoad(selenium);
							waitForPageLoad(selenium);
							waitForPageLoad(selenium);
							returnValue = true;
							
							
						}else {
							counter++;
						}
					}
					
				}else{
					
					assertTrue(type(selenium,txtDepartmentSearch,deptData.department+uniqueName),"Could not enter the department name",selenium, ClassName, MethodName);
					assertTrue(click(selenium, btnDepartmentSearch),"Could not click the search button",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					while(selenium.isTextPresent(deptData.department)){
						if(getText(selenium,"//div[@id='departments']/table/tbody/tr["+counter+"]/td/div").contains(deptData.department)){
							waitForPageLoad(selenium);
							waitForPageLoad(selenium);
							waitForPageLoad(selenium);
							assertTrue(click(selenium,"//div[@id='departments']/table/tbody/tr["+counter+"]/td/div"),"Could not click departments from table",selenium, ClassName, MethodName);
							waitForPageLoad(selenium);
							waitForPageLoad(selenium);
							waitForPageLoad(selenium);
							returnValue = true;
							
							
						}
						
					}
					
				}
			
			
			
			/*
			int counter=1;
			while(getText(selenium,vfySearchDepartment).toLowerCase(new java.util.Locale("en","US")).trim().contains(deptData.department+uniqueName.trim().toLowerCase(new java.util.Locale("en","US")))){
			if(getText(selenium,"//div[@id='departments']/table/tbody/tr["+counter+"]/td/div/span",10000).toLowerCase(new java.util.Locale("en","US")).trim().contains(deptData.department+uniqueName.trim().toLowerCase(new java.util.Locale("en","US")))){
				click(selenium,"//div[@id='departments']/table/tbody/tr["+counter+"]/td/div/span");
				waitForPageLoad(selenium);
				break;
			}else if(getText(selenium,lblSearchDepartment,10000).toLowerCase(new java.util.Locale("en","US")).trim().contains(deptData.department+uniqueName.trim().toLowerCase(new java.util.Locale("en","US")))){
				click(selenium,lblSearchDepartment);
				break;
			}
				counter++;
			}
			waitForPageLoad(selenium);
			
			
			if(isElementPresent(selenium,txtDepartmentName))
				returnValue=true;
			else
				returnValue=false;
			*/
			}catch(RuntimeException e){
			e.printStackTrace();
			
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return returnValue;
	}
	/**
	 * verifyInternalProviderInPatient
	 * function to verify whether the created provider is present in patient info
	 * @param 		selenium
	 * @param 		providerData
	 * @since  	    August 23, 2012
	 */	
	public boolean verifyInternalProviderInPatient(Selenium selenium,SystemSettingsLib providerData){
		boolean returnValue=true;
		try{
			selectValueFromAjaxList(selenium,ajxProviderTypesuggestBox,providerData.providerType);
			/*if(providerData.pcpCheck.equals("yes")){
				if(!isChecked(selenium,ajxResponsibleProvPCPcheckbox))
				Assert.assertTrue(click(selenium,ajxResponsibleProvPCPcheckbox),"Colud not click the pcp check box;More Details:"+providerData.toString());
			}*/
			assertTrue(type(selenium,txtLastName,providerData.lastName),"Could not enter the last name;More Details"+providerData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstName,providerData.firstName),"Could not enter the last name;More Details"+providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxMaximumFTESuggestBoxsuggestBox,providerData.maximumFte);
			
			if(providerData.billingInfoCheck.equals("Yes")){
				if(!isChecked(selenium, chkSignatureOnFilecheckbox))
					click(selenium, chkSignatureOnFilecheckbox);
				enterDate(selenium,txtSignatureDate,providerData.signatureDate);
			}
			
			assertTrue(click(selenium, btnPRSave),"Could not click the save button;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	/**
	 * navigateToDirectories
	 * function to navigateToDirectories
	 * @param 		selenium
	 * @throws IOException 
	 * @since  	    June 26, 2013
	 */	
	
	public boolean goToDirectories(Selenium selenium, SystemSettingsLib payerAdminData) throws IOException{
		assertTrue(click(selenium,lnkSettings),"Could not click on System settings link:" + payerAdminData .toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkSystemSettingLink),"Could not click on System settings link:" + payerAdminData .toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkDirectories),"Could not click the Directories link;More Details:"+payerAdminData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;	
	}
	
	
	
	/**
	 * createSubmitClaims
	 * function to createSubmitClaims
	 * @since  	    June 27, 2013
	 */	
	public boolean createSubmitClaims(Selenium selenium,SystemSettingsLib payerAdminData, String userAccount){
		boolean returnValue=true;
		try{
			selectValueFromAjaxList(selenium,ajxSubmitClaimsSuggestBox,payerAdminData.submitClaim);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxSubmitClaimsSubsequentSuggestBox,payerAdminData.submitClaimsSub);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxClaimsDaysSuggestBox,payerAdminData.claimDays);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxClaimsDaysSuggestBox1,payerAdminData.claimDaysTransfer);
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}
	
	
	/**
	 * verifyStoreSubmitedClaims
	 * function to Verify verifyStoreSubmitedClaims
	 * @since  	    July 10, 2013
	 */
	
	public boolean verifyStoreSubmitedClaims(Selenium selenium,SystemSettingsLib payerAdminData, String userAccount){
				
		if(!getValue(selenium,ajxSubmitClaimsSuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(payerAdminData.submitClaim.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		
		if(!getValue(selenium,ajxSubmitClaimsSubsequentSuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(payerAdminData.submitClaimsSub.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		
		if(!getValue(selenium,ajxClaimsDaysSuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(payerAdminData.claimDays.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		
		if(!getValue(selenium,ajxClaimsDaysSuggestBox1).toLowerCase(new java.util.Locale("en","US")).trim().contains(payerAdminData.claimDaysTransfer.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		
		return true;
		
	 }
	
	
	/**
	 * 
	 * function to createPayers
	 * @since  	    June 27, 2013
	 */	
	public boolean createPayers(Selenium selenium,SystemSettingsLib payerAdminData, String userAccount){
		boolean returnValue=true;
		try{
								
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("ddHHmm");
			String uniqueName=DateFormat.format(cal.getTime());
			
			if(userAccount.equals(CAAccount)){
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxSelectPayerAdmin,payerAdminData.payerWizardCA);
				waitForPageLoad(selenium);
				
			}else {
				selectValueFromAjaxList(selenium,ajxSelectPayerAdmin,payerAdminData.payerWizard);
				waitForPageLoad(selenium);
				
			}		
			
			assertTrue(type(selenium, txtPayerName,payerAdminData.payerName+uniqueName),"Could not type the PayerName;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!userAccount.equals(CAAccount)){
				assertTrue(type(selenium, txtPayerCode,payerAdminData.payerCode+uniqueName),"Could not type the Payer Code;More details:",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);			
			}
			
			selectValueFromAjaxList(selenium,ajxSelectPayerType,payerAdminData.payerType);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtAddr1,payerAdminData.street),"Could not type the Payer Street Address;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    assertTrue(type(selenium, txtCity,payerAdminData.city),"Could not type the Payer City Name;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(userAccount.equalsIgnoreCase(CAAccount)){
				
				selectValueFromAjaxList(selenium,ajxStateSuggestBoxSuggestBox,payerAdminData.stateCA);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtZip,payerAdminData.zipcodeCa),"Could not type the Payer Zip Code;More details:",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			else{
				selectValueFromAjaxList(selenium,ajxStateSuggestBoxSuggestBox,payerAdminData.state);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtZip,payerAdminData.zipcode),"Could not type the Payer Zip Code;More details:",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			}	
			
			waitForPageLoad(selenium);
			selenium.keyPress(txtPhone, "\\9");
			click(selenium,btnYesButton);
			waitForElementToEnable(selenium,txtCity);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,ajxStateSuggestBoxSuggestBox);
			waitForPageLoad(selenium);			
				
			assertTrue(type(selenium, txtPhone,payerAdminData.phone),"Could not type the Payer Phone Number;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtPhoneExtension,payerAdminData.telephoneextnNo1),"Could not type the Payer Phone Extension;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtFax,payerAdminData.fax),"Could not type the Payer Fax Number;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtWebsite,payerAdminData.webAddress),"Could not type the Payer Fax Number;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSave),"Could not click Save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	
	public boolean createPayersMandatory(Selenium selenium,SystemSettingsLib payerAdminData, String userAccount){
		boolean returnValue=true;
		try{
								
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("ddHHmm");
			String uniqueName=DateFormat.format(cal.getTime());
						
			if(userAccount.equals(CAAccount)){
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxSelectPayerAdmin,payerAdminData.payerWizardCA);
				waitForPageLoad(selenium);
				
			}else {
				selectValueFromAjaxList(selenium,ajxSelectPayerAdmin,payerAdminData.payerWizard);
				waitForPageLoad(selenium);
				
			}			
			
			assertTrue(type(selenium, txtPayerName,payerAdminData.payerName+uniqueName),"Could not type the PayerName;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!userAccount.equals(CAAccount)){
				assertTrue(type(selenium, txtPayerCode,payerAdminData.payerCode+uniqueName),"Could not type the Payer Code;More details:",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);			
			}			
			
			selectValueFromAjaxList(selenium,ajxSelectPayerType,payerAdminData.payerType);
			waitForPageLoad(selenium);
						
			assertTrue(click(selenium,btnSave),"Could not click Save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	
	/**
	 * createPayers Contact 
	 * function to createPayers
	 * @since  	    June 27, 2013
	 */	
	public boolean createPayersContact(Selenium selenium,SystemSettingsLib payerAdminData, String userAccount){
		boolean returnValue=true;
		try{
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxDepartmentSuggestBox,payerAdminData.department),"Could not Select value from drop down list",selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxTitleSuggestBox,payerAdminData.title),"Could not Select value from drop down list",selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtLastName,payerAdminData.lastName),"Could not type the Payer's Last Name;More details:",selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtFirstName,payerAdminData.firstName),"Could not type the Payer's First Name;More details:",selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtRole,payerAdminData.role),"Could not type the Payer's Role;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtPhone,payerAdminData.phone),"Could not type the Payer Phone Number;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtPhoneExtension,payerAdminData.telephoneextnNo1),"Could not type the Payer Phone Extension;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtFax,payerAdminData.fax),"Could not type the Payer Fax Number;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		

			if(!userAccount.equals(CAAccount)){				
				assertTrue(type(selenium, txtEmail,payerAdminData.email),"Could not type the Payer's Email ;More details:",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);						
			}		
			assertTrue(type(selenium, txtCommentTestBoxId,payerAdminData.comments),"Could not type the Payer's Comment ;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSave),"Could not click on Save Button; More details"+payerAdminData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

	
	/**
	 * createPayers Plan 
	 * function to createPayers Plan
	 * @since  	    June 28, 2013
	 */	
	public boolean createPayersPlan(Selenium selenium,SystemSettingsLib payerAdminData, String userAccount){
		boolean returnValue=true;
		try{
						
			assertTrue(type(selenium, txtPlanName,payerAdminData.planName),"Could not type the Payer's Plan Name;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtCoPay,payerAdminData.coPay),"Could not type the Payer's Co-Pay Amount;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtSpecialistCoPay,payerAdminData.specialistCoPay),"Could not type the Specialist Co Pay;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtDeductible,payerAdminData.deductible),"Could not type the Payer Deductible Amount;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			
			if(!userAccount.equals(CAAccount)){				
				assertTrue(type(selenium, txtCoInsurance,payerAdminData.coInsurance),"Could not type the Payer Co-insurance Percentage;More details:",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);								
			}		
					
			assertTrue(click(selenium,btnSave),"Could not click on Save Button; More details"+payerAdminData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

	
	
	/**
	 * verifyPayersPlanValuesInSummaryPage
	 * function to Verify verifyPayersPlanValuesInSummaryPage
	 * @since  	    June 28, 2013
	 */	
	public boolean verifyPayersPlanValuesInSummaryPage(Selenium selenium,SystemSettingsLib payerAdminData, String userAccount){
				
			if(!getText(selenium,vfyStoreValuePayersPlan).trim().contains(payerAdminData.planName.trim())){
				return false;
			}
			
			/*if(!getText(selenium,vfyStoreValuePayersPlan).trim().contains(payerAdminData.coPay.trim())){
				return false;
			}*/
			/*if(!getText(selenium,vfyStoreValuePayersPlan).trim().contains(payerAdminData.coInsurance.trim())){
				return false;
			}*/
		return true;
		
	 }
	
	
	/**
	 * verifyContactValuesInSummaryPage
	 * function to Verify verifyContactValuesInSummaryPage
	 * @since  	    June 28, 2013
	 */	
	public boolean verifyContactValuesInSummaryPage(Selenium selenium,SystemSettingsLib payerAdminData, String userAccount){
				
			if(!getText(selenium,vfyStoreValueContact).trim().contains(payerAdminData.department.trim())){
				return false;
			}
			
			if(!getText(selenium,vfyStoreValueContact).trim().contains(payerAdminData.lastName.trim())){
				return false;
			}
			if(!getText(selenium,vfyStoreValueContact).trim().contains(payerAdminData.firstName.trim())){
				return false;
			}
		return true;
		
	}
	
	/**
	 * 
	 * function to Verify verifyPayerAdminValuesInSummaryPage
	 * @since  	    June 27, 2013
	 */	
	public boolean verifyPayerAdminValuesInSummaryPage(Selenium selenium,SystemSettingsLib payerAdminData, String userAccount){ 


		if(!getText(selenium,vfyStoreTextPayer).trim().contains(payerAdminData.payerName.trim())){ 
		return false; 
		} 

		/*if(!getText(selenium,vfyStoreValuePayerAdmin).trim().contains(payerAdminData.payerCode.trim())){

		return false; 
		}*/ 
		if(!getText(selenium,vfyStoreTextPayer).trim().contains(payerAdminData.street.trim())){ 
		return false; 
		} 

		if(userAccount.equals(USAccount)){ 
			if(!getText(selenium,vfyStoreTextPayer).trim().contains(payerAdminData.city.trim())){ 
			return false; 
			} 
		} 
		/*if(!getText(selenium,vfyStoreValuePayerAdmin).trim().contains(payerAdminData.phone.trim())){ 
		return false; 
		}*/ 
		if(!getText(selenium,vfyStoreTextPayer).trim().contains(payerAdminData.telephoneextnNo1.trim())){

		return false; 
		} 
		/*if(!getText(selenium,vfyStoreValuePayerAdmin).trim().contains(payerAdminData.fax.trim())){ 
		return false; 
		}*/ 
		return true; 

		}


	
	/**
	 * checkPayerPicklist
	 * function to Check Payer Picklist
	 * @param 		selenium
	 * @since  	    July 03, 2013
	 */	
	
	public boolean checkPayerPicklist(Selenium selenium){
		try{
			if(isElementPresent(selenium,lblPayerPicklist)){
				try {
					assertTrue(click(selenium,chkNotShowAgain),"Could not click the checkbox Not Show Again",selenium, ClassName, MethodName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					assertTrue(click(selenium,btnCrossPicklist),"Could not click picklist close button",selenium, ClassName, MethodName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				waitForPageLoad(selenium);
			}
			
		return true;								
	
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	
	/**
	 * deletePayerAdmin
	 * function to delete PayerAdmim
	 * @param 		selenium
	 * @throws IOException 
	 * @since  	    July 03, 2013
	 */	
	
	public boolean deletePayerAdmin(Selenium selenium,SystemSettingsLib payerAdminData) throws IOException{
		
		assertTrue(type(selenium,"searchTextBox",payerAdminData.payerName),"Could not seacrh the payer name",selenium, ClassName, MethodName);
		selenium.focus("searchTextBox");
		selenium.keyPress("searchTextBox", "\\13");
		
		

		int PayerAdminCount=(Integer) selenium.getXpathCount(lblDeletePayerAdmin);
		while(PayerAdminCount!=2){
			for(int count=1;count<=PayerAdminCount-2;count++){
				 assertTrue(click(selenium, btnDeletePayerAdmin), "Could not click the delete button",selenium, ClassName, MethodName);
				 assertTrue(click(selenium, btnYes), "Could not click the yes button in delete pop up",selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
			 }
			 PayerAdminCount=(Integer) selenium.getXpathCount(lblDeletePayerAdmin);
			 System.out.println(selenium.getXpathCount(lblDeletePayerAdmin));
		}	  
		 
		 return true;
		
	}
	
	
	/**
	 * deleteDirectories
	 * function to delete Directories
	 * @param 		selenium
	 * @throws IOException 
	 * @since  	    August 27, 2012
	 */	
	
	public boolean deleteDirectories(Selenium selenium) throws IOException{
		boolean directoriesDeleted = true;
		int directoriesCount = 0;
		try{
			waitForElement(selenium,  btnDeleteDirectories, WAIT_TIME);
			while((Integer) selenium.getXpathCount( btnDeleteDirectories) > 0){
				directoriesCount = (Integer) selenium.getXpathCount( btnDeleteDirectories);
				assertTrue(click(selenium, btnDeleteDirectories),"Could not click Delete directories button",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYes),"Could not click yes button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				/*if(directoriesCount == (Integer) selenium.getXpathCount( btnDeleteDirectories)){
					directoriesDeleted = false;
					break;
				}*/
			}
			return directoriesDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * createDirectories
	 * function to createDirectories
	 * @since  	    Aug 27, 2012
	 */	
	public boolean createDirectories(Selenium selenium,SystemSettingsLib directoriesData, String userAccount){
		boolean returnValue=true;
		try{
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtPharamcyName,directoriesData.pharmacyName),"Could not type the pharmacyNema;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtAddr1 ,directoriesData.street),"Could not type the street;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtCity,directoriesData.city),"Could not type the city;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			
			if(userAccount.equalsIgnoreCase(CAAccount)){
				
				selectValueFromAjaxList(selenium,ajxStateSuggestBoxSuggestBox,directoriesData.stateCA);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtZip,directoriesData.zipcodeCa),"Could not type the zip code;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			}
			else{				
				selectValueFromAjaxList(selenium,ajxStateSuggestBoxSuggestBox,directoriesData.state);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtZip,directoriesData.zipcode),"Could not type the zip code;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			
			}	
			
			click(selenium,btnNo);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox ,directoriesData.country);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtPhone,directoriesData.telephoneNo1),"Could not type the phone no;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPhoneExtension,directoriesData.telephoneextnNo1),"Could not type exten no;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtFax,directoriesData.fax),"Could not type the fax;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtEmail,directoriesData.email),"Could not type the email;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtWebsite,directoriesData.webAddress),"Could not type the web address;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxTitleSuggestBox,directoriesData.salutation);
			waitForPageLoad(selenium);
			
							
				assertTrue(type(selenium,txtDirectoriesLastName,directoriesData.lastName),"Could not type the last Name;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtDirectoriesFirstName,directoriesData.firstName),"Could not type the first name;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
											
						
			assertTrue(type(selenium,txtCommentTestBoxId,directoriesData.comments),"Could not type the comments;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click the save button;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			if(isElementPresent(selenium,btnSearchTextBox)){
				returnValue=true;
			}else
				returnValue=false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	


	
	
	//--------------------------------------------------------------------//
	//  Verifying Store Values InSummaryPage							  //
	//--------------------------------------------------------------------//
	
	
	public boolean verifyStoreValuesInSummaryPage(Selenium selenium,SystemSettingsLib directoriesData, String userAccount) {
		waitForPageLoad(selenium);
		if(!selenium.isTextPresent(directoriesData.pharmacyName.trim())){
			return false;
		}
		waitForPageLoad(selenium);
		if(!selenium.isTextPresent(directoriesData.comments.trim())){
			return false;
		}
		waitForPageLoad(selenium);
		if(!selenium.isTextPresent(directoriesData.street.trim())){
			return false;
		}
		waitForPageLoad(selenium);
		if(!selenium.isTextPresent(directoriesData.country.trim())){
			return false;
		}
		
		
		if(userAccount.equalsIgnoreCase(CAAccount)){
			
			if(!selenium.isTextPresent(directoriesData.zipcodeCa.trim())){
				return false;
			}
			
		}
		else{
			
			if(!selenium.isTextPresent(directoriesData.zipcode.trim())){
				return false;
			}
		
		}
			
		
		/*if(!getText(selenium,vfyStoreValinSalutation).toLowerCase(new java.util.Locale("en","Us")).trim().contains(directoriesData.salutation.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}*/
		if(!selenium.isTextPresent(directoriesData.lastName)){
			return false;
		}
		if(!selenium.isTextPresent(directoriesData.firstName)){
			return false;
		}
		if(!selenium.isTextPresent(directoriesData.phone.trim())){
			return false;
		}
		if(!selenium.isTextPresent(directoriesData.telephoneextnNo1.trim())){
			return false;
		}
		if(!selenium.isTextPresent(directoriesData.fax1.trim())){
			return false;
		}
		if(!selenium.isTextPresent(directoriesData.email.trim())){
			return false;
		}
		if(!selenium.isTextPresent(directoriesData.webAddress.trim())){
			return false;
		}
		return true;
	}

	
	//--------------------------------------------------------------------//
	//  Step-5: Verifying Entered Details are saved properly  //
	//--------------------------------------------------------------------//
	
	
	public boolean verifyStoreValue(Selenium selenium,SystemSettingsLib directoriesData, String userAccount) {
		waitForPageLoad(selenium);
		if(!getValue(selenium,txtPharamcyName).trim().contains(directoriesData.pharmacyName.trim())){
			return false;
		}
		waitForPageLoad(selenium);
		if(!getValue(selenium, txtAddr1 ).trim().contains(directoriesData.street.trim())){
			return false;
		}
		waitForPageLoad(selenium);
		if(!getValue(selenium, txtCity).trim().contains(directoriesData.city.trim())){
			return false;
		}		
		waitForPageLoad(selenium);
		if(userAccount.equalsIgnoreCase(CAAccount)){			
			if(!getValue(selenium,ajxStateSuggestBoxSuggestBox).trim().contains(directoriesData.stateCA.trim())){
				return false;
			}
			if(!getValue(selenium,txtZip).trim().contains(directoriesData.zipcodeCa.trim())){
				return false;
			}			
		}
		
		else{			
			if(!getValue(selenium,ajxStateSuggestBoxSuggestBox).trim().contains(directoriesData.state.trim())){
				return false;
			}
			if(!getValue(selenium,txtZip).trim().contains(directoriesData.zipcode.trim())){
				return false;
			}		
		}
		waitForPageLoad(selenium);	
		if(!getValue(selenium,ajxStateCountryBoxSuggestBox).trim().contains(directoriesData.country.trim())){
			return false;
		}
		waitForPageLoad(selenium);
		if(!getValue(selenium,txtPhone).trim().contains(directoriesData.phone.trim())){
			return false;
		}
		
		if(!getValue(selenium,txtPhoneExtension).trim().contains(directoriesData.telephoneextnNo1.trim())){
			return false;
		}
		if(!getValue(selenium,txtFax).trim().contains(directoriesData.fax1.trim())){
			return false;
		}
		if(!getValue(selenium,txtEmail).trim().contains(directoriesData.email.trim())){
			return false;
		}
		if(!getValue(selenium, txtWebsite ).trim().contains(directoriesData.webAddress.trim())){
			return false;
		}
		/*if(!getValue(selenium,ajxTitleSuggestBox ).toLowerCase(new java.util.Locale("en","Us")).trim().contains(directoriesData.salutation.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}*/
		
		
				
		if(!getValue(selenium,txtDirectoriesLastName).toLowerCase(new java.util.Locale("en","Us")).trim().contains(directoriesData.lastName.trim().toLowerCase(new java.util.Locale("en","Us")))){
				return false;
			}
			if(!getValue(selenium,txtDirectoriesFirstName).toLowerCase(new java.util.Locale("en","Us")).trim().contains(directoriesData.firstName.trim().toLowerCase(new java.util.Locale("en","Us")))){
				return false;
		}		
			
			
		
		if(!getValue(selenium, txtCommentTestBoxId).trim().contains(directoriesData.comments.trim())){
			return false;
		}
		return true;
	}
	
	
	/**
	 * createDirectories
	 * function to createDirectories
	 * @since  	    Aug 28, 2012
	 */	
	
	public boolean UnitTest_Directories(Selenium selenium,SystemsSettingsUnitTest directoriesData, String userAccount){
		boolean returnValue=false;
		try{
			
			assertTrue(type(selenium, txtPharamcyName,directoriesData.pharmacyName),"Could not type the pharmacyNema;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAddr1 ,directoriesData.street),"Could not type the street;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtCity,directoriesData.city),"Could not type the city;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxStateSuggestBoxSuggestBox,directoriesData.state);
			assertTrue(type(selenium,txtZip,directoriesData.zipcode),"Could not type the zip code;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox ,directoriesData.country);
			assertTrue(type(selenium,txtPhone,directoriesData.telephoneNo1),"Could not type the phone no;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPhoneExtension,directoriesData.telephoneextnNo1),"Could not type exten no;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtFax,directoriesData.fax),"Could not type the fax;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtEmail,directoriesData.email),"Could not type the email;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtWebsite,directoriesData.webAddress),"Could not type the web address;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxTitleSuggestBox,directoriesData.salutation);
			waitForPageLoad(selenium);

			assertTrue(type(selenium,txtDirectoriesLastName,directoriesData.lastName),"Could not type the last Name;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtDirectoriesFirstName,directoriesData.firstName),"Could not type the first name;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
				
			
			assertTrue(type(selenium,txtCommentTestBoxId,directoriesData.comments),"Could not type the comments;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
		    if(directoriesData.testCaseId.equals("TC_DIR_033"))
			{
				selenium.typeKeys(txtCommentTestBoxId, "b");
				return true;
			}
			assertTrue(click(selenium,btnSave),"Could not click the save button;More details:"+directoriesData.toString(),selenium, ClassName, MethodName);
		
			returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	

	/**
	 * UnitTest PayerAdmin
	 * function to UnitTest PayerAdmin
	 * @since  	    July 16, 2013
	 */	
	
	public boolean UnitTest_PayerAdmin(Selenium selenium,SystemsSettingsUnitTest payerAdminData, String userAccount){
		boolean returnValue=false;
		try{
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("ddHHmm");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(type(selenium, txtPayerName,payerAdminData.payerName),"Could not type the PayerName;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!payerAdminData.testCaseId.equals("TC_PA_002") && !userAccount.equals(CAAccount))
			 {	
				assertTrue(type(selenium, txtPayerCode,payerAdminData.payerCode+uniqueName),"Could not type the Payer Code;More details:",selenium, ClassName, MethodName);
			 }
			/*else
				{
				Assert.assertTrue(type(selenium, txtPayerCode,payerAdminData.payerCode+uniqueName),"Could not type the Payer Code;More details:");
				}*/
			
			waitForPageLoad(selenium);			
			assertTrue(type(selenium, txtAddr1,payerAdminData.street),"Could not type the Payer Street Address;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtCity,payerAdminData.city),"Could not type the Payer City Name;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			assertTrue(type(selenium, txtZip,payerAdminData.zipcode),"Could not type the Payer Zip Code;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			
			click(selenium, btnNO);
			
			assertTrue(type(selenium, txtPhone,payerAdminData.telephoneNo1),"Could not type the Payer Phone Number;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtPhoneExtension,payerAdminData.telephoneextnNo1),"Could not type the Payer Phone Extension;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtFax,payerAdminData.fax),"Could not type the Payer Fax Number;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtWebsite,payerAdminData.webAddress),"Could not type the Payer Fax Number;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSave),"Could not click the save button;More details:"+ payerAdminData.toString() ,selenium, ClassName, MethodName);
		
			returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	
	/**
	 * UnitTest PayerAdminContact
	 * function to UnitTest PayerAdminContact
	 * @throws IOException 
	 * @since  	    July 17, 2013
	 */	
	
	public boolean UnitTest_PayerAdminContact(Selenium selenium,SystemsSettingsUnitTest payerAdminData, String userAccount) throws IOException{
		boolean returnValue=false;
		try{
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("ddHHmm");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(selectValueFromAjaxList(selenium,ajxDepartmentSuggestBox,payerAdminData.department),"Could not click on suggest box",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium, txtPhone,payerAdminData.telephoneNo1),"Could not type the Payer Phone Number;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtPhoneExtension,payerAdminData.telephoneextnNo1),"Could not type the Payer Phone Extension;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtFax,payerAdminData.fax),"Could not type the Payer Fax Number;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!userAccount.equalsIgnoreCase(CAAccount)){			
			assertTrue(type(selenium, txtEmail,payerAdminData.email),"Could not type the Payer's Email ;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			}
								
			/*Assert.assertTrue(type(selenium, txtCommentTestBoxId,payerAdminData.comments),"Could not type the Payer's Comment ;More details:");
			waitForPageLoad(selenium);*/
			
			
			assertTrue(click(selenium,btnSave),"Could not click the save button;More details:"+ payerAdminData.toString(),selenium, ClassName, MethodName);
		
			returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}
	
	
	/**
	 * UnitTest PayerAdminPlan
	 * function to UnitTest PayerAdminPlan
	 * @since  	    July 17, 2013
	 */	
	
	public boolean UnitTest_PayerAdminPlan(Selenium selenium,SystemsSettingsUnitTest payerAdminData, String userAccount){
		boolean returnValue=false;
		try{
			
			assertTrue(type(selenium, txtPlanName,payerAdminData.planName),"Could not type the Payer's Plan Name;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtCoPay,payerAdminData.coPay),"Could not type the Payer's Co-Pay Amount;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtSpecialistCoPay,payerAdminData.specialistCoPay),"Could not type the Specialist Co Pay;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtDeductible,payerAdminData.deductible),"Could not type the Payer Deductible Amount;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			
			if(!userAccount.equalsIgnoreCase(CAAccount)){				
				assertTrue(type(selenium, txtCoInsurance,payerAdminData.coInsurance),"Could not type the Payer Co-insurance Percentage;More details:",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);				
			}					
			
			assertTrue(click(selenium,btnSave),"Could not click the save button;More details:"+ payerAdminData.toString(),selenium, ClassName, MethodName);
		
			returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	
	public boolean createPayersMandatory(Selenium selenium,SystemsSettingsUnitTest payerAdminData, String userAccount){
		boolean returnValue=true;
		try{
								
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("ddHHmm");
			String uniqueName=DateFormat.format(cal.getTime());
						
			selectValueFromAjaxList(selenium,ajxSelectPayerAdmin,payerAdminData.payerWizard);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtPayerName,payerAdminData.payerName),"Could not type the PayerName;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!userAccount.equals(CAAccount)){
				assertTrue(type(selenium, txtPayerCode,payerAdminData.payerCode+uniqueName),"Could not type the Payer Code;More details:",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);			
			}			
												
			assertTrue(click(selenium,btnSave),"Could not click Save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	
	
	
	/**
	 * createUserRole
	 * function to create User Role
	 * @since  	    Aug 30, 2012
	 */	
	
	public boolean createUserRole(Selenium selenium,SystemSettingsLib userRole,String uniqueName){ 
		 try{
			 
			 assertTrue(type(selenium,txtUserRoleMore,userRole.userRole+uniqueName),"Could not type the user role;More details"+userRole.toString(),selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtdescription ,userRole.description),"Could not type the user role;More details"+userRole.toString(),selenium, ClassName, MethodName);
			 selectValueFromAjaxList(selenium, ajxHomePageView, userRole.homePage);
			 if(userRole.limitedAccess.equalsIgnoreCase("yes")){
				 assertTrue(click(selenium,chkLimitedAccess),"Could nod click the check box",selenium, ClassName, MethodName);
			 }
			 assertTrue(click(selenium,btnSave),"Could not click the save button",selenium, ClassName, MethodName);
			 if(isElementPresent(selenium,lnkExpandAll)){
				 return true;
			 }else
				 return false;
		 }catch(RuntimeException e){
			 e.printStackTrace();
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return true;
	 }


	/**
	 * createUserRole
	 * function to create User Role
	 * @since  	    Aug 30, 2012
	 */	
	
	public boolean createUserRolePortability(Selenium selenium,SystemSettingsLib userRole, String userAccount){
		 try{
			 String arrowPossition = "";
			 waitForPageLoad(selenium);
			 assertTrue(type(selenium,txtUserRoleMore,userRole.userRole),"Could not type the user role;More details"+userRole.toString(),selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtdescription ,userRole.description),"Could not type the user role;More details"+userRole.toString(),selenium, ClassName, MethodName);
			 selectValueFromAjaxList(selenium, ajxHomePageView, userRole.homePage);
			 //Handle roles in patient Registration
			 if((userRole.patientRegistration.equals(""))){
				 arrowPossition = selenium.getAttribute(lnkRightsRegistration);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					assertTrue(click(selenium,lnkArrowRegister),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
				 }
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.personalInfo)+"PersonalInfo3radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.socioEconomics)+"Socio-Economics4radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.houseHold)+"Household5radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.contacts)+"Contacts6radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.identifiers)+"7radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.payers)+"Payers8radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.referrals)+"Referrals9radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.consents)+"Consents10radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.notes)+"Notes11radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.cases)+"Cases12radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.programs)+"Programs13radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.healthCareTeam)+"HealthcareTeam14radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.patientTimeLine)+"Timeline303radio"),"Could nod check the sub options in patientRegistration",selenium, ClassName, MethodName);
			 }else{
				 assertTrue(click(selenium,"chk"+getAccessPossition(userRole.patientRegistration)+"Registrationcheckbox"),"Could nod check access role of patientRegistration",selenium, ClassName, MethodName);
		 	  }
		
			 
			//Handle roles in Clinical
			 if((userRole.clinical.equals(""))){
				arrowPossition = selenium.getAttribute(lnkRightsClinical);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					 assertTrue(click(selenium,lnkArrowClinical),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
				 }
				 
				 if((userRole.orders.equals(""))){
					  arrowPossition = selenium.getAttribute(lnkRightsOrders);
					 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
						 assertTrue(click(selenium,lnkArrowOrders),"Could nod click the expand arrow of orders",selenium, ClassName, MethodName);
					 }
					
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.labsOrders)+"48radio"),"Could not check the lab reports in orders",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.diagnosticTestsOrders)+"463radio"),"Could not check the diagnostic test orders in orders",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.prescription)+"63radio"),"Could not check the prescriptions in orders",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.referralsOrders)+"464radio"),"Could not check the referrals in orders",selenium, ClassName, MethodName);
					 if(userRole.testCaseId.equalsIgnoreCase("TC_UR_035")|| userRole.testCaseId.equalsIgnoreCase("TC_UR_034" )){
						 assertTrue(click(selenium,"chk148checkbox"),"Could not check Signing Authority Check Box",selenium, ClassName, MethodName); 
						 assertTrue(click(selenium,"chk1463checkbox"),"Could not check Signing Authority Check Box",selenium, ClassName, MethodName); 
						 assertTrue(click(selenium,"chk163checkbox"),"Could not check Signing Authority Check Box",selenium, ClassName, MethodName); 
						 assertTrue(click(selenium,"chk1464checkbox"),"Could not check Signing Authority Check Box",selenium, ClassName, MethodName); 
					 }
				 }
				 else{
					 assertTrue(click(selenium,"chk"+getAccessPossition(userRole.orders)+"Orderscheckbox"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
				 }
				 
				 if((userRole.reports.equals(""))){
					  arrowPossition = selenium.getAttribute(lnkRightsReports);
					 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
						 assertTrue(click(selenium,lnkArrowReprots),"Could nod click the expand arrow of reports",selenium, ClassName, MethodName);
					 }
					
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.labsReports)+"47radio"),"Could not check the lab reports in reports",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.diagnosticTestsRepords)+"455radio"),"Could not check the diagnostic test orders in reports",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.correspondence)+"456radio"),"Could not check the correspondence in reports",selenium, ClassName, MethodName);
					 if(userRole.testCaseId.equalsIgnoreCase("TC_UR_035")|| userRole.testCaseId.equalsIgnoreCase("TC_UR_034" )){
						 assertTrue(click(selenium,"chk147checkbox"),"Could not check Signing Authority Check Box",selenium, ClassName, MethodName); 
						 assertTrue(click(selenium,"chk1455checkbox"),"Could not check Signing Authority Check Box",selenium, ClassName, MethodName); 
						 assertTrue(click(selenium,"chk1456checkbox"),"Could not check Signing Authority Check Box",selenium, ClassName, MethodName);  
					 }
				 }
				 else{
					 assertTrue(click(selenium,"chk"+getAccessPossition(userRole.reports)+"Reportscheckbox"),"Could not check the reports in Clinical",selenium, ClassName, MethodName);
				 }
				 
				 
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.chartDisclosure)+"ChartDisclosure454radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.encounters)+"Encounters72radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.timeLine)+"Timeline74radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.careAlerts)+"ManageCareAlerts258radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
				 
				
				 
				 if((userRole.medicalSummary.equals(""))){
					 arrowPossition = selenium.getAttribute(lnkRightsMedicalSummary);
					 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
						  assertTrue(click(selenium,lnkArrowMedicalSummary),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
					 }
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.allergies)+"46radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.patientProblems)+"68radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.immunizations)+"43radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.injections)+"61radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.socialHistory)+"65radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.familyHistory)+"59radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.vitals)+"67radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.procedures)+"66radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.medicationsSummary)+"75radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
				 }
				 else{
					 assertTrue(click(selenium,"chk"+getAccessPossition(userRole.medicalSummary)+"MedicalSummarycheckbox"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
				 }
				 
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.fileReport)+"FileReport73radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.exportChartData)+"ExportChartData80radio"),"Could nod check the sub options in Clinical",selenium, ClassName, MethodName);
			 }
			 else{
				 assertTrue(click(selenium,"chk"+getAccessPossition(userRole.clinical)+"Clinicalcheckbox"),"Could nod click the expand arrow of Clinical",selenium, ClassName, MethodName);
			 }
			 
			 
			 
			 //Handle roles in Clinical Lists
			 if((userRole.clinicalLists.equals(""))){
				 arrowPossition = selenium.getAttribute(lnkRightsClinicalList);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					 assertTrue(click(selenium,lnkArrowClinicalList),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
				 }
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.clinicalPatientList)+"ClinicalPatientList78radio"),"Could nod check the sub options in Clinical Lists",selenium, ClassName, MethodName);
				 if(!userAccount.equalsIgnoreCase(CAAccount)){
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.clinicalQualityMeasures)+"ClinicalQualityMeasures85radio"),"Could nod check the sub options in Clinical Lists",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.meaningfulUseMeasures)+"MeaningfulUseMeasures81radio"),"Could nod check the sub options in Clinical Lists",selenium, ClassName, MethodName);
				 }
			 }
			 else{
				 assertTrue(click(selenium,"chk"+getAccessPossition(userRole.clinicalLists)+"ClinicalListscheckbox"),"Could nod check access role of Clinical Lists",selenium, ClassName, MethodName);
			 }
			 
			 
			//Handle roles in Clinical Setting
			 if((userRole.clinicalSetting.equals(""))){
				 arrowPossition = selenium.getAttribute(lnkRightsClinicalSettings);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					 assertTrue(click(selenium,lnkArrowClinicalSettings),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
				 }
				 
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.encounterTemplates)+"PracticeLibrary260radio"),"Could nod check the sub options in Clinical Setting",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.clinicalDecisionSupport)+"ClinicalDecisionSupport84radio"),"Could nod check the sub options in Clinical Setting",selenium, ClassName, MethodName);
				 
				 //change
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.electronicReports)+"ElectronicReports460radio"),"Could nod check the electronic report in Clinical Setting",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.laboratoryTemplates)+"LaboratoryTemplates311radio"),"Could nod check the labratory template in Clinical Setting",selenium, ClassName, MethodName);
				 //end
				 
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.interactionWarning)+"InteractionWarnings90radio"),"Could nod check the sub options in Clinical Setting",selenium, ClassName, MethodName);
				 
			 }
			 else{
				 assertTrue(click(selenium,"chk"+getAccessPossition(userRole.clinicalSetting)+"ClinicalSettingscheckbox"),"Could nod check access role of Clinical Setting",selenium, ClassName, MethodName);
			 }
			 
			 
			//Handle roles in Administration
			 if((userRole.administration.equals(""))){
				 arrowPossition = selenium.getAttribute(lnkRightsAdministration);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					assertTrue(click(selenium,lnkArrowAdministration),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
				 }
				 
				
				 
				//Handle roles in organizational structure 
				 if((userRole.organizationalStructure.equals(""))){
					 arrowPossition = selenium.getAttribute(lnkRightsOrganizationalStructure);
					 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
						 assertTrue(click(selenium,lnkArrowOrganizationalStructure),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
					 }
					
					 
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.practice)+"Practice17radio"),"Could nod check the sub options in organizational structure",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.providers)+"Providers19radio"),"Could nod check the sub options in organizational structure",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.users)+"Users20radio"),"Could nod check the sub options in organizational structure",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.departments)+"Departments22radio"),"Could nod check the sub options in organizational structure",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.programsOrg)+"Programs36radio"),"Could nod check the sub options in organizational structure",selenium, ClassName, MethodName);
				 }
				 else{
					 assertTrue(click(selenium,"chk"+getAccessPossition(userRole.organizationalStructure)+"OrganizationalStructurecheckbox"),"Could nod check the sub options in Administration",selenium, ClassName, MethodName);
				 }
				 
				 
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.enterpriseVariables)+"EnterpriseVariables23radio"),"Could nod check the sub options in Administration",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.mandatoryFields)+"MandatoryFields24radio"),"Could nod check the sub options in Administration",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.addressBook)+"AddressBook25radio"),"Could nod check the sub options in Administration",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.externalProviders)+"ExternalProviders28radio"),"Could nod check the sub options in Administration",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.identifiersAdmin)+"Identifiers29radio"),"Could nod check the sub options in Administration",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.healthCareTeamAdmin)+"HealthcareTeam31radio"),"Could nod check the sub options in Administration",selenium, ClassName, MethodName);
				 
				//Handle roles in directories 
				 if((userRole.directories.equals(""))){
					 arrowPossition = selenium.getAttribute(lnkRightsDirectories);
					 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
						 assertTrue(click(selenium,lnkArrowDirectories),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
					 }
					
					 
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.referringProviders)+"ReferringProviders103radio"),"Could nod check the sub options in directories",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.payerDirectories)+"Payers252radio"),"Could nod check the sub options in directories",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.Pharmacies)+"Pharmacies50radio"),"Could nod check the sub options in directories",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.governmentAgencies)+"GovernmentAgencies104radio"),"Could nod check the sub options in directories",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.hospitals)+"Hospitals105radio"),"Could nod check the sub options in directories",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.labs)+"106radio"),"Could nod check the sub options in directories",selenium, ClassName, MethodName);
				 }
				 else{
					 assertTrue(click(selenium,"chk"+getAccessPossition(userRole.directories)+"Directoriescheckbox"),"Could nod check the sub options in Administration",selenium, ClassName, MethodName);
				 }
			 }
			 else{
				  assertTrue(click(selenium,"chk"+getAccessPossition(userRole.administration)+"SystemSettingscheckbox"),"Could nod check access role of Administration",selenium, ClassName, MethodName);
			 }
			 
			 
			 
			//Handle roles in General 
			 if((userRole.general.equals(""))){
				 
				 arrowPossition = selenium.getAttribute(lnkRightsGeneral);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					 assertTrue(click(selenium, lnkArrowGeneral),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
				 }
				  
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.unmatchedItems)+"UnmatchedItems97radio"),"Could nod check the sub options in General",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.importChartData)+"ImportChartData91radio"),"Could nod check the sub options in General",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.failedTransmition)+"FailedTransmissions192radio"),"Could nod check the sub options in General",selenium, ClassName, MethodName);
				 
				 //change
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.unmatchedProviders)+"UnmatchedProviders461radio"),"Could nod check the un matched providers in General",selenium, ClassName, MethodName);
				 //end
				 
				
			 }
			 else{
				  assertTrue(click(selenium,"chk"+getAccessPossition(userRole.general)+"Generalcheckbox"),"Could nod check access role of General",selenium, ClassName, MethodName);
			 }
			 
			 
			//Handle roles in Security Settings 
			 if((userRole.securitySettings.equals(""))){
				 arrowPossition = selenium.getAttribute(lnkRightsSecuritySettings);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					 assertTrue(click(selenium,lnkArrowSecuritySettings),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
				 }
				
				 
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.auditLog)+"AuditLog35radio"),"Could nod check the sub options in securitySettings",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.consentsSec)+"Consents38radio"),"Could nod check the sub options in securitySettings",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.userRoles)+"UserRoles39radio"),"Could nod check the sub options in securitySettings",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.passwordRules)+"PasswordManagement37radio"),"Could nod check the sub options in securitySettings",selenium, ClassName, MethodName);
				 //change
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.emergencyAccess)+"EmergencyAccess458radio"),"Could nod check the sub options in securitySettings",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.userAccessExceptions)+"UserExceptions474radio"),"Could nod check the sub options in securitySettings",selenium, ClassName, MethodName);
				 //end
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.manageRecords)+"ManageRecords96radio"),"Could nod check the sub options in securitySettings",selenium, ClassName, MethodName);
				 //change
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.dataSharing)+"DataSharing457radio"),"Could nod check the sub options in securitySettings",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.restrictPatientChart)+"RestrictPatientChart459radio"),"Could nod check the sub options in securitySettings",selenium, ClassName, MethodName);
				 //end
			 }
			 else{
				 assertTrue(click(selenium,"chk"+getAccessPossition(userRole.securitySettings)+"SecuritySettingscheckbox"),"Could nod check access role of securitySettings",selenium, ClassName, MethodName);
			 }
			 
			 
			//Handle roles in Reports 
			 if((userRole.reports.equals(""))){
				 
				 arrowPossition = selenium.getAttribute(lnkRightsReports1);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					  assertTrue(click(selenium,lnkArrowReports1),"Could nod click the expand arrow of patientRegistration",selenium, ClassName, MethodName);
				 }
				
				 
				   assertTrue(click(selenium,"rd"+getAccessPossition(userRole.generalReports)+"GeneralReports100radio"),"Could nod check the sub options in Reports",selenium, ClassName, MethodName);
				 
				
			 }
			 else{
				   assertTrue(click(selenium,"xpath=(//input[@id='chk"+getAccessPossition(userRole.reports)+"Reportscheckbox'])[2]"),"Could nod check access role of Reports",selenium, ClassName, MethodName);
			 }
			
			 
			 
			//Handle roles in Scheduling 
			 if((userRole.scheduler.equals(""))){
				
				 arrowPossition = selenium.getAttribute(lnkRightsScheduling);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					 assertTrue(click(selenium,lnkArrowScheduling),"Could nod click the expand arrow of scheduling",selenium, ClassName, MethodName);
				 }
				 
				 if((userRole.calendarSettings.equals(""))){
					 arrowPossition = selenium.getAttribute(lnkRightsCalenderSettings);
					 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
						 assertTrue(click(selenium,lnkArrowCalenderSettings),"Could nod click the expand arrow of Calendar setting",selenium, ClassName, MethodName);
					 }
					 
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.locationHours)+"LocationHours202radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.nonProviderResources)+"Non-ProviderResources203radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.resourceGroups)+"ResourceGroups204radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.visitTypes)+"VisitTypes205radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.visitGroups)+"VisitGroups206radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.calendarTemplates)+"CalendarTemplates207radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.resourceCalendars)+"ResourceCalendars208radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.calendarPreferences)+"CalendarPreferences209radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.programGroups)+"ProgramGroups112radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.cancellationReasons)+"CancellationReasons306radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
					 
				 }
				 else{
					 assertTrue(click(selenium,"chk"+getAccessPossition(userRole.calendarSettings)+"CalendarSettingscheckbox"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 }
				 
				 
				 if((userRole.calendarView.equals(""))){
					 arrowPossition = selenium.getAttribute(lnkRightsCalenderView);
					 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
						assertTrue(click(selenium,lnkArrowCalenderView),"Could nod click the expand arrow of calendar view" ,selenium, ClassName, MethodName);
					 }
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.calendarSuperUser)+"213radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.events)+"Events218radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.confirmAppt)+"ConfirmAppt214radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.checkinPatient)+"CheckinPatient215radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 }
				 else{
					 assertTrue(click(selenium,"chk"+getAccessPossition(userRole.calendarView)+"CalendarViewcheckbox"),"Could nod check the sub options in Scheduling" ,selenium, ClassName, MethodName); 
				 }
				 
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.bumpList)+"BumpList221radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.waitListManagement)+"WaitListManagement216radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.recordAttendance)+"RecordAttendance113radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				
				 if((userRole.PDG.equals(""))){
					 arrowPossition = selenium.getAttribute(lnkRightsPDG);
					 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
						 assertTrue(click(selenium,lnkArrowPDG),"Could nod click the expand arrow of pdg",selenium, ClassName, MethodName);
					 }
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.openPDGSessions)+"OpenPDGSessions300radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
					 //change
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.viewEditPDGsession)+"View/EditPDGSessions110radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.unexplainedabsentees)+"UnexplainedAbsenteeismsWorkQueue111radio"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
					 //end
				 }
				 else{
					 assertTrue(click(selenium,"chk"+getAccessPossition(userRole.PDG)+"PDGcheckbox"),"Could nod check the sub options in Scheduling",selenium, ClassName, MethodName);
				 }
				
			 }
			 else{
				 assertTrue(click(selenium,"chk"+getAccessPossition(userRole.scheduler)+"Schedulercheckbox"),"Could nod check access role of Scheduling",selenium, ClassName, MethodName);
			 }
			 
			 
			//Handle roles in Template Setup 
			 if((userRole.templateSetup.equals(""))){
				 arrowPossition = selenium.getAttribute(lnkRightsTemplateSetup);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					 assertTrue(click(selenium,lnkArrowTemplateSetup),"Could nod click the expand arrow of Template setup",selenium, ClassName, MethodName);
				 }
				 
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.daysheetTemplates)+"DaysheetTemplate211radio"),"Could nod check the sub options in Template Setup",selenium, ClassName, MethodName);
				 //change
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.letterTemplates)+"LetterTemplates219radio"),"Could nod check the sub options in Template Setup",selenium, ClassName, MethodName);
				//end
			 }
			 else{
				  assertTrue(click(selenium,"chk"+getAccessPossition(userRole.templateSetup)+"TemplateSettingscheckbox"),"Could nod check access role of Template Setup",selenium, ClassName, MethodName);
			 }
			 
			 
			//Handle roles in Biller 
			 if((userRole.biller.equals(""))){
				 arrowPossition = selenium.getAttribute(lnkRightsBiller);
				 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
					 assertTrue(click(selenium,lnkArrowBiller),"Could nod click the expand arrow of Biller",selenium, ClassName, MethodName);
				 }
				 
				 if((userRole.billingSettings.equals(""))){
					 arrowPossition = selenium.getAttribute("arrowBilling Settings@class");
					 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
						 assertTrue(click(selenium,"arrowBilling Settings"),"Could nod click the expand arrow of Billing setting",selenium, ClassName, MethodName);
					 }
					 
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.superbillSetup)+"SuperbillSetup403radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.statementPreferences)+"StatementPreferences402radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.serviceCodes)+"ServiceCodes405radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.adjustmentReasons)+"AdjustmentReasons407radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.batchEligibilityPreferences)+"BatchEligibilitySettings453radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.billingRulesAdmin)+"BillingRules408radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 }
				 else{
					 assertTrue(click(selenium,"chk"+getAccessPossition(userRole.billingSettings)+"BillingSettingscheckbox"),"Could nod check access role of billing setting",selenium, ClassName, MethodName);
				 }
				 
				 
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.superbillsToReview)+"UnpostedSuperbills411radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.rejectionsToReview)+"ClaimRejections431radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.onHoldClaims)+"ClaimsonHold435radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.unprintedStatements)+"UnprintedStatements434radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.unpostedPayerBatches)+"UnpostedPayerBatches412radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.paperClaimsToReview)+"PaperClaimstoReview452radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.postCharges)+"PostCharges430radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.postPatientPayments)+"PostPatientPayments413radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.postPayerPayments)+"PostPayerPayments425radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.insuranceAging)+"InsuranceAging433radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.patientsFailedEligibility)+"PatientFailedEligibility429radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 
				 if((userRole.billingHistory.equals(""))){
					 arrowPossition = selenium.getAttribute("arrowBilling History@class");
					 if(arrowPossition.equalsIgnoreCase("closed-arrow")){
						 assertTrue(click(selenium,"arrowBilling History"),"Could nod click the expand arrow of Billing history",selenium, ClassName, MethodName);
					 }
					 
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.summary)+"Summary421radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.charges)+"Charges422radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.payments)+"Payments423radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
					 assertTrue(click(selenium,"rd"+getAccessPossition(userRole.statements)+"Statements424radio"),"Could nod check the sub options in biller",selenium, ClassName, MethodName);
				 }
				 else{
					 assertTrue(click(selenium,"chk"+getAccessPossition(userRole.billingHistory)+"BillingHistorycheckbox"),"Could nod check access role of billing history",selenium, ClassName, MethodName);
				 }
				 
			 }
			 else{
				 assertTrue(click(selenium,"chk"+getAccessPossition(userRole.biller)+"Billingcheckbox"),"Could nod check access role of biller",selenium, ClassName, MethodName);
			 }
			 
			 
			 assertTrue(click(selenium,btnSave),"Could not click the save button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
			 if(isElementPresent(selenium,"link=Expand all")){
				 return true;
			 }else
				 return false;
		 }catch(RuntimeException e){
			 e.printStackTrace();
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return true;
	 }
	

	
	public int getAccessPossition(String role){
		int accessPossition=0;
		if(role.equalsIgnoreCase("No Access")){
			accessPossition=1;
		}else if(role.equalsIgnoreCase("View Only")){
			accessPossition=2;
		}else if(role.equalsIgnoreCase("Limited Access")){
			accessPossition=3;
		}else if(role.equalsIgnoreCase("Full Access")){
			accessPossition=4;
		}
		return accessPossition;
	}
	

	/**
	 * editUserRole
	 * function to create User Role
	 * @since  	    Aug 30, 2012
	 */	
	
	public boolean editUserRole(Selenium selenium,SystemSettingsLib userRole,String uniqueName){ 
		 try{
			 
			 assertTrue(type(selenium,txtUserRoleMore,userRole.userRole+uniqueName),"Could not type the user role;More details"+userRole.toString(),selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtdescription ,userRole.description),"Could not type the user role;More details"+userRole.toString() ,selenium, ClassName, MethodName);
			 selectValueFromAjaxList(selenium, ajxHomePageView, userRole.homePage);
			 if(userRole.fullAccess.equalsIgnoreCase("yes")){
				 assertTrue(click(selenium,lblFullAccess),"Could nod click the check box",selenium, ClassName, MethodName);
			 }
			 assertTrue(click(selenium,btnSave),"Could not click the save button",selenium, ClassName, MethodName);
			 if(isElementPresent(selenium,lnkExpandAll)){
				 return true;
			 }else
				 return false;
		 }catch(RuntimeException e){
			 e.printStackTrace();
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return true;
	 }
	
	/**
	 * gotoSystemSetting
	 * function to gotoSystemSetting
	 * @throws IOException 
	 * @since  	    Aug 30, 2012
	 */	
	
	public boolean gotoSystemSetting(Selenium selenium) throws IOException{
		
		 
  	  	assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
        waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkSystemSettingLink),"Could not click the system setting link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,lnkAdminOrgStructureLists)){
			return true;
		}else
			return false;
		
	}
	
	/**
	 * createNewUserUsView
	 * function to createNewUserUsViewr
	 * @param 		selenium
	 * @param 		userData
	 * @param 		uniqueName
	 * @throws IOException 
	 * @since  	     May 17, 2012
	 */	
	public boolean createUser(Selenium selenium,SystemSettingsLib userData) throws IOException{
		try{
			assertTrue(click(selenium,btnadduser),"Could not click on add a user link:" + userData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtLastName,userData.lastName),"Could not type a last name",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstName,userData.firstName),"Could not type a first name" + userData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtUserName,userData.userName1),"Could not type a user name" + userData .toString(),selenium, ClassName, MethodName);
			
			assertTrue(type(selenium,txtCredentials,userData.credentials),"Could not type a credential" + userData .toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxExternalEmrsuggestBox,userData.externalEmr);
			assertTrue(type(selenium,txtPassword,userData.password),"Could not type a password" + userData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtConfirmPassword,userData.password),"Could not type confirmation password" + userData .toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxRoleSuggestBox1suggestBox,userData.userRole);
			selectValueFromAjaxList(selenium,ajxPractise,userData.practise);
			click(selenium,"//div[3]/div/div/div/div/div");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + userData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnEdit1)){
				return true;
			}
			else{
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * createNewUserUsView
	 * function to createNewUserUsViewr
	 * @param 		selenium
	 * @param 		userData
	 * @param 		uniqueName
	 * @throws IOException 
	 * @since  	     May 17, 2012
	 */	
	
	public boolean createUserPortability(Selenium selenium,SystemSettingsLib userData,String userAccount) throws IOException{
		try{
			String practice=null;
			if(userAccount.equalsIgnoreCase(CAAccount)){
				practice=userData.practiseCA;
			}
			else{
				practice=userData.practise;
			}
			assertTrue(click(selenium,btnadduser),"Could not click on add a user link:" + userData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			if(userData.testCaseId.equalsIgnoreCase("TC_NU_001")||userData.testCaseId.equalsIgnoreCase("TC_NU_002")
					||userData.testCaseId.equalsIgnoreCase("TC_NU_007")||userData.testCaseId.equalsIgnoreCase("TC_NU_008")
					||userData.testCaseId.equalsIgnoreCase("TC_NU_009") ||userData.testCaseId.equalsIgnoreCase("TC_NU_015")){
				
				if(isElementPresent(selenium,"//span/input")){
					if(!isChecked(selenium, "//span/input")){
						click(selenium, "//span/input");
					}
				}
				/*click(selenium, ajxSuggestBoxIdType);
				userData.providerName = getText(selenium, "//div[@class='gwt-PopupPanel dropdown-box']/div[@class='popupContent']/div/div/div/div");*/
				
				selectValueFromAjaxList(selenium,ajxSuggestBoxProg,userData.providerName);
			}
			else{
				if(isElementPresent(selenium,"//span/input")){
					if(isChecked(selenium, "//span/input")){
						click(selenium, "//span/input");
					}
				}
			}
			
			
			int count=2;
			int tempCount=1;
			while(isElementPresent(selenium, "xpath=(//span[contains(text(),'Delete')] )["+count+"]")){
				assertTrue(click(selenium, "xpath=(//span[contains(text(),'Delete')] )["+count+"]"),"Could not click on delete a role link:" + userData .toString(),selenium, ClassName, MethodName);
				tempCount++;
				if(tempCount>16){
					break;
				}
			}
			
			assertTrue(type(selenium,txtLastName,userData.lastName),"Could not type a last name",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstName,userData.firstName),"Could not type a first name" + userData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtUserName,userData.userName1),"Could not type a user name" + userData .toString(),selenium, ClassName, MethodName);
			
			assertTrue(type(selenium,txtCredentials,userData.credentials),"Could not type a credential" + userData .toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxExternalEmrsuggestBox,userData.externalEmr);
			assertTrue(type(selenium,txtPassword,userData.password),"Could not type a password" + userData .toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtConfirmPassword,userData.password),"Could not type confirmation password" + userData .toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxRoleSuggestBox1suggestBox,userData.userRole);
			selectValueFromAjaxList(selenium,"practiceSuggestBox1-1suggestBox",practice);
			click(selenium,"//div[3]/div/div/div/div/div");
			waitForPageLoad(selenium);
			
			if( (userData.testCaseId.equalsIgnoreCase("TC_NU_017")) ) {				
				
				String practice2, practice3,practice4;
				if(userAccount.equalsIgnoreCase(CAAccount)){
					practice2= userData.practiceCA2;
					practice3= userData.practiceCA3;
					practice4= userData.practiceCA4;
				}
				else{
					practice2= userData.practice2;
					practice3= userData.practice3;
					practice4= userData.practice4;
				}				
				
				assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxRoleSuggestBox2suggestBox,userData.userRole2);
				selectValueFromAjaxList(selenium,"practiceSuggestBox2-1suggestBox",practice);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxRoleSuggestBox3suggestBox,userData.userRole);
				selectValueFromAjaxList(selenium,"practiceSuggestBox3-1suggestBox",practice2);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxRoleSuggestBox4suggestBox,userData.userRole2);
				selectValueFromAjaxList(selenium,"practiceSuggestBox4-1suggestBox",practice2);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"roleSuggestBox5suggestBox",userData.userRole);
				selectValueFromAjaxList(selenium,"practiceSuggestBox5-1suggestBox",practice3);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"roleSuggestBox6suggestBox",userData.userRole2);
				selectValueFromAjaxList(selenium,"practiceSuggestBox6-1suggestBox",practice3);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"roleSuggestBox7suggestBox",userData.userRole);
				selectValueFromAjaxList(selenium,"practiceSuggestBox7-1suggestBox",practice4);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"roleSuggestBox8suggestBox",userData.userRole2);
				selectValueFromAjaxList(selenium,"practiceSuggestBox8-1suggestBox",practice4);
				waitForPageLoad(selenium);
			}
			
			if((userData.testCaseId.equalsIgnoreCase("TC_NU_007")) || (userData.testCaseId.equalsIgnoreCase("TC_NU_003"))|| (userData.testCaseId.equalsIgnoreCase("TC_NU_002"))|| (userData.testCaseId.equalsIgnoreCase("TC_NU_001"))|| (userData.testCaseId.equalsIgnoreCase("TC_NU_009"))
					|| (userData.testCaseId.equalsIgnoreCase("TC_NU_014"))){
				
				assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxRoleSuggestBox2suggestBox,userData.userRole2);
				selectValueFromAjaxList(selenium,"practiceSuggestBox2-1suggestBox",practice);
				waitForPageLoad(selenium);
				
				if((userData.testCaseId.equalsIgnoreCase("TC_NU_007")) || (userData.testCaseId.equalsIgnoreCase("TC_NU_001"))|| (userData.testCaseId.equalsIgnoreCase("TC_NU_002"))|| (userData.testCaseId.equalsIgnoreCase("TC_NU_003"))|| (userData.testCaseId.equalsIgnoreCase("TC_NU_014"))){
					assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium,ajxRoleSuggestBox3suggestBox,userData.userRole3);
					selectValueFromAjaxList(selenium,"practiceSuggestBox3-1suggestBox",practice);
					waitForPageLoad(selenium);
					
					
					assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium,ajxRoleSuggestBox4suggestBox,userData.userRole4);
					selectValueFromAjaxList(selenium,"practiceSuggestBox4-1suggestBox",practice);
					waitForPageLoad(selenium);
					
					
					if(userData.testCaseId.equalsIgnoreCase("TC_NU_007") || userData.testCaseId.equalsIgnoreCase("TC_NU_014")){
						assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						selectValueFromAjaxList(selenium,"roleSuggestBox5suggestBox",userData.userRole5);
						selectValueFromAjaxList(selenium,"practiceSuggestBox5-1suggestBox",practice);
						waitForPageLoad(selenium);
						
						
						assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						selectValueFromAjaxList(selenium,"roleSuggestBox6suggestBox",userData.userRole6);
						selectValueFromAjaxList(selenium,"practiceSuggestBox6-1suggestBox",practice);
						waitForPageLoad(selenium);
						
						assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						selectValueFromAjaxList(selenium,"roleSuggestBox7suggestBox",userData.userRole7);
						selectValueFromAjaxList(selenium,"practiceSuggestBox7-1suggestBox",practice);
						waitForPageLoad(selenium);
						
						assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						selectValueFromAjaxList(selenium,"roleSuggestBox8suggestBox",userData.userRole8);
						selectValueFromAjaxList(selenium,"practiceSuggestBox8-1suggestBox",practice);
						waitForPageLoad(selenium);
						
						assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						selectValueFromAjaxList(selenium,"roleSuggestBox9suggestBox",userData.userRole9);
						selectValueFromAjaxList(selenium,"practiceSuggestBox9-1suggestBox",practice);
						waitForPageLoad(selenium);
						
						
						assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						selectValueFromAjaxList(selenium,"roleSuggestBox10suggestBox",userData.userRole10);
						selectValueFromAjaxList(selenium,"practiceSuggestBox10-1suggestBox",practice);
						waitForPageLoad(selenium);
						
						assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						selectValueFromAjaxList(selenium,"roleSuggestBox11suggestBox",userData.userRole11);
						selectValueFromAjaxList(selenium,"practiceSuggestBox11-1suggestBox",practice);
						waitForPageLoad(selenium);
						
						assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						selectValueFromAjaxList(selenium,"roleSuggestBox12suggestBox",userData.userRole12);
						selectValueFromAjaxList(selenium,"practiceSuggestBox12-1suggestBox",practice);
						waitForPageLoad(selenium);
						
						assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						selectValueFromAjaxList(selenium,"roleSuggestBox13suggestBox",userData.userRole13);
						selectValueFromAjaxList(selenium,"practiceSuggestBox13-1suggestBox",practice);
						waitForPageLoad(selenium);
							
						if(userData.testCaseId.equalsIgnoreCase("TC_NU_014")){
							assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
							waitForPageLoad(selenium);
							selectValueFromAjaxList(selenium,"roleSuggestBox14suggestBox",userData.userRole14);
							selectValueFromAjaxList(selenium,"practiceSuggestBox14-1suggestBox",practice);
							waitForPageLoad(selenium);
							
							assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
							waitForPageLoad(selenium);
							selectValueFromAjaxList(selenium,"roleSuggestBox15suggestBox",userData.userRole15);
							selectValueFromAjaxList(selenium,"practiceSuggestBox15-1suggestBox",practice);
							waitForPageLoad(selenium);
							
							assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
							waitForPageLoad(selenium);
							selectValueFromAjaxList(selenium,"roleSuggestBox16suggestBox",userData.userRole16);
							selectValueFromAjaxList(selenium,"practiceSuggestBox16-1suggestBox",practice);
							waitForPageLoad(selenium);
						}
					}
				}
			}
		
			assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + userData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnEdit1)){
				return true;
			}
			else{
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} 
	}
	


/**
	 * createNewUserUsView
	 * function to createNewUserUsViewr
	 * @param 		selenium
	 * @param 		userData
	 * @param 		uniqueName
	 * @throws IOException 
	 * @since  	     May 17, 2012
	 */	
	public boolean editUserPortability(Selenium selenium,SystemSettingsLib userData, String userAccount) throws IOException{
		try{
			
			String practice=null;
			if(userAccount.equalsIgnoreCase(CAAccount)){
				practice=userData.practiseCA;
			}
			else{
				practice=userData.practise;
			}
			
			waitForPageLoad(selenium);
		
			
			if(userData.testCaseId.equalsIgnoreCase("TC_NU_001")||userData.testCaseId.equalsIgnoreCase("TC_NU_002")
					||userData.testCaseId.equalsIgnoreCase("TC_NU_007")||userData.testCaseId.equalsIgnoreCase("TC_NU_008")
					||userData.testCaseId.equalsIgnoreCase("TC_NU_009")|| userData.testCaseId.equalsIgnoreCase("TC_NU_015")){
				
				if(isElementPresent(selenium,"//span/input")){
					if(!isChecked(selenium, "//span/input")){
						click(selenium, "//span/input");
					}
				}
				
				/*click(selenium, ajxSuggestBoxIdType);
				userData.providerName = getText(selenium, "//div[@class='gwt-PopupPanel dropdown-box']/div[@class='popupContent']/div/div/div/div");*/
				
				selectValueFromAjaxList(selenium,ajxSuggestBoxProg,userData.providerName);
			}
			else{
				if(isElementPresent(selenium,"//span/input")){
					if(isChecked(selenium, "//span/input")){
						click(selenium, "//span/input");
					}
				}
			}
			
			
			int count=2;
			int tempCount=1;
			
			//3 7 8 14
			while(isElementPresent(selenium, "xpath=(//span[contains(text(),'Delete')] )["+count+"]")){
				assertTrue(click(selenium, "xpath=(//span[contains(text(),'Delete')] )["+count+"]"),"Could not click on delete a role link:" + userData .toString(),selenium, ClassName, MethodName);
				tempCount++;
				if(tempCount>16){
					break;
				}
			}					
			
			assertTrue(type(selenium,txtLastName,userData.lastName),"Could not type a last name",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtFirstName,userData.firstName),"Could not type a first name" + userData .toString(),selenium, ClassName, MethodName);
			
			assertTrue(type(selenium,txtCredentials,userData.credentials),"Could not type a credential" + userData .toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxUserRolesuggestBox,userData.userRole);
			selectValueFromAjaxList(selenium,ajxRxProvider,practice);
			click(selenium,"//div[3]/div/div/div/div/div");
			waitForPageLoad(selenium);

			if( (userData.testCaseId.equalsIgnoreCase("TC_NU_017")) ) {								
				String practice2, practice3,practice4;
				if(userAccount.equalsIgnoreCase(CAAccount)){
					practice2 = userData.practiceCA2;
					practice3 = userData.practiceCA3;
					practice4= userData.practiceCA4;
				}
				else{
					practice2 = userData.practice2;
					practice3 = userData.practice3;
					practice4 = userData.practice4;
				}				
								
				if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[2]"))){
					assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
				}
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[2]",userData.userRole2);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[3]",practice);
				waitForPageLoad(selenium);
				
				if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[3]"))){
					assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
				}
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[3]",userData.userRole);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[4]",practice2);
				waitForPageLoad(selenium);
				
				if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[4]"))){
					assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
				}
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[4]",userData.userRole2);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[5]",practice2);
				waitForPageLoad(selenium);
				
				if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[5]"))){
					assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
				}
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[5]",userData.userRole);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[6]",practice3);
				waitForPageLoad(selenium);
				
				if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[6]"))){
					assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
				}
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[6]",userData.userRole2);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[7]",practice3);
				waitForPageLoad(selenium);
				
				if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[7]"))){
					assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
				}
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[7]",userData.userRole);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[8]",practice4);
				waitForPageLoad(selenium);
				
				if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[8]"))){
					assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
				}
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[8]",userData.userRole2);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[9]",practice4);
				waitForPageLoad(selenium);
			}
			
			if((userData.testCaseId.equalsIgnoreCase("TC_NU_007")) || (userData.testCaseId.equalsIgnoreCase("TC_NU_003"))|| (userData.testCaseId.equalsIgnoreCase("TC_NU_002"))|| (userData.testCaseId.equalsIgnoreCase("TC_NU_001"))
					|| (userData.testCaseId.equalsIgnoreCase("TC_NU_014"))){
				
				if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[2]"))){
					assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
				}
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[2]",userData.userRole2);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[3]",practice);
				waitForPageLoad(selenium);
				
				
				if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[3]"))){
					assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
				}
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[3]",userData.userRole3);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[4]",practice);
				waitForPageLoad(selenium);
				
				
				if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[4]"))){
					assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
				}
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[4]",userData.userRole4);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[5]",practice);
				waitForPageLoad(selenium);
				
				if(userData.testCaseId.equalsIgnoreCase("TC_NU_007") || userData.testCaseId.equalsIgnoreCase("TC_NU_014")){
					if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[5]"))){
						assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
					}
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[5]",userData.userRole5);
					selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[6]",practice);
					waitForPageLoad(selenium);
					
					
					if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[6]"))){
						assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
					}
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[6]",userData.userRole6);
					selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[7]",practice);
					waitForPageLoad(selenium);
					
					if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[7]"))){
						assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
					}
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[7]",userData.userRole7);
					selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[8]",practice);
					waitForPageLoad(selenium);
					
					if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[8]"))){
						assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
					}
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[8]",userData.userRole8);
					selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[9]",practice);
					waitForPageLoad(selenium);
					
					if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[9]"))){
						assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
					}
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[9]",userData.userRole9);
					selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[10]",practice);
					waitForPageLoad(selenium);
					
					
					if(userData.testCaseId.equalsIgnoreCase("TC_NU_014")){
						
						if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[10]"))){
							assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
						}
						waitForPageLoad(selenium);
						selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[10]",userData.userRole10);
						selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[11]",practice);
						waitForPageLoad(selenium);
						
						
						if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[11]"))){
							assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
						}
						waitForPageLoad(selenium);
						selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[11]",userData.userRole11);
						selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[12]",practice);
						waitForPageLoad(selenium);
						
						if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[12]"))){
							assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
						}
						waitForPageLoad(selenium);
						selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[12]",userData.userRole12);
						selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[13]",practice);
						waitForPageLoad(selenium);
						
						if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[13]"))){
							assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
						}
						waitForPageLoad(selenium);
						selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[13]",userData.userRole13);
						selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[14]",practice);
						waitForPageLoad(selenium);
						
						
						if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[14]"))){
							assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
						}
						waitForPageLoad(selenium);
						selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[14]",userData.userRole14);
						selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[15]",practice);
						waitForPageLoad(selenium);
						
						if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[15]"))){
							assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
						}
						waitForPageLoad(selenium);
						selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[15]",userData.userRole15);
						selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[16]",practice);
						waitForPageLoad(selenium);
						
						if(!(isElementPresent(selenium, "xpath=(//input[@id='userRolesuggestBox'])[16]"))){
							assertTrue(click(selenium,btnAddRole),"Could not click on add a role link:" + userData .toString(),selenium, ClassName, MethodName);
						}
						waitForPageLoad(selenium);
						selectValueFromAjaxList(selenium,"xpath=(//input[@id='userRolesuggestBox'])[16]",userData.userRole16);
						selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[17]",practice);
						waitForPageLoad(selenium);
						
					}
				}
				
			}
			
			
			
			
			assertTrue(click(selenium,btnSave),"Could not click on save a program link:" + userData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnEdit1)){
				return true;
			}
			else{
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}


	/**
	 * navigatetoSystem setting
	 * function to navigate to System setting
	 * @throws IOException 
	 * @since  	    Mar 21, 2013
	 */	
	public boolean navigatetoSystemSetting(Selenium selenium) throws IOException{

		assertTrue(click(selenium, lnkSettings), "Could not click on Quick Actions button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
	//	waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkSystemSettingLink), "Could not click on Clinical settings",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	
	/**
	 * searchPractice
	 * function to search Practice
	 * @throws IOException 
	 * @since  	    Mar 21, 2013
	 */	
	
	public boolean searchPractice(Selenium selenium,SystemSettingsLib practice) throws IOException{
		int count=0;
		System.out.println(getText(selenium,lblPractice1));
		System.out.println(practice.practiceName);
		while(getText(selenium,lblPractice1).toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){
			if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){
				assertTrue(click(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td"),"Could not click practices",selenium, ClassName, MethodName);
			}else if(getText(selenium,btnSearchBox).equalsIgnoreCase("Search")){
				type(selenium,txtSearchBox,practice.practiceName);
				
				click(selenium,btnSearchBox);
				waitForPageLoad(selenium);
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(practice.practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){
					assertTrue(click(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td"),"Could not click practices",selenium, ClassName, MethodName);
				}
			}
				count++;
			if(count>20)
				break;
			}
		if(isElementPresent(selenium,btnEdit1)){
			return true;
		}else
			return false;
	}
	
	/**
	 * searchUser
	 * function to search User
	 * @throws IOException 
	 * @since  	    Mar 21, 2013
	 */	
	
	public boolean searchUser(Selenium selenium,SystemSettingsLib userData) throws IOException{
		assertTrue(click(selenium,lnkOrgStructuresId),"Could not click the link list",selenium, ClassName, MethodName);
		assertTrue(type(selenium,"xpath=(//input[@id='searchTextBox'])[5]",userData.userName),"Could not type the last name",selenium, ClassName, MethodName);
		assertTrue(click(selenium,btnUserSearch),"Could not click the search button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		System.out.println(getText(selenium,txtLastName1));
		if(getText(selenium,txtUserName1).toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			if(getText(selenium,txtLastName1).trim().contains(userData.firstName.trim())){
			      assertTrue(click(selenium,txtLastName1),"Could not click Last name",selenium, ClassName, MethodName);
				}else{
					return false;
					}
				}
			if(isElementPresent(selenium,btnEdit1)){
				assertTrue(click(selenium,btnEdit1),"Could not click edit button",selenium, ClassName, MethodName);
			return true;
		}else
			return false;
		}
	/**
	 * goToPrescribe
	 * function to goToPrescribe
	 * @throws IOException 
	 * @since  	    Sep 12, 2012
	 */	
	
	public boolean goToPrescribe(Selenium selenium) throws IOException{
		
			assertTrue(isElementPresent(selenium,lnkPatientOptions),"Could not find link",selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkPatientOptions),"Could not click the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,"patientOptionsPrescribeMedication"),"Could not find the link",selenium, ClassName, MethodName);
			assertTrue(click(selenium,"patientOptionsPrescribeMedication"),"Could not click the click",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		
	}
	
	/**
	 * goToSecuritysetting
	 * function to goToSecuritysetting
	 * @throws IOException 
	 * @since  	    Apr 17,2013
	 */	
	public boolean goToSecuritysetting(Selenium selenium) throws IOException{
		
		assertTrue(isElementPresent(selenium,lnkQuickLink),"Could not find link",selenium, ClassName, MethodName);
		assertTrue(click(selenium,lnkQuickLink),"Could not click the link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(isElementPresent(selenium,lnkSecuritySetting),"Could not find the link",selenium, ClassName, MethodName);
		assertTrue(click(selenium,lnkSecuritySetting),"Could not click the click",selenium, ClassName, MethodName);
		return true;
	
}
	
	
	
	/**
	 * searchPractice
	 * function to search Practice
	 * @throws IOException 
	 * @since  	    Mar 21, 2013
	 */	
	
	public boolean searchPractice(Selenium selenium,String practiceName) throws IOException{
		int count=1;
		boolean booleanVariable = true;
		
		waitForPageLoad(selenium);
		
		
		if(getText(selenium,btnSearchBox).equalsIgnoreCase("Search")){
			type(selenium,txtSearchBox,practiceName);
			click(selenium,btnSearchBox);
			waitForPageLoad(selenium);
			while(booleanVariable){
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){
					assertTrue(click(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td"),"Click Falied",selenium, ClassName, MethodName);
					booleanVariable=false;
				}
				count++;
				if(count>10)
					break;
				
			}
		}
		
		else if(getText(selenium,lblPractice1).toLowerCase(new java.util.Locale("en","US")).trim().contains(practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			while(booleanVariable){
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){
					waitForPageLoad(selenium);
					try {
						assertTrue(click(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td"),"Could not click Practices from table",selenium, ClassName, MethodName);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					waitForPageLoad(selenium);
					booleanVariable=false;
				}
				count++;
				if(count>10)
					break;
			}
		}

					
			
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,btnEdit1)){
			return true;
		}else
			return false;
	}
	public boolean verifyStoredValuesIdentifierAccessLevel(Selenium selenium, SystemSettingsLib idTypeData){
		if(!getText(selenium,lblIdentifierTypeSummary).trim().contains(idTypeData.idType.trim())){
				return false;
		}
		if(!getText(selenium,lblIdentifierTypeSummary).trim().contains(idTypeData.idGroup.trim())){
			return false;
		}
		
		if(!getText(selenium,lblIdentifierTypeSummary).trim().contains(idTypeData.idTypeMask.trim())){
				return false;
		}
		if(!getText(selenium,lblIdentifierTypeSummary).trim().contains(idTypeData.expDate.trim())){
			return false;
		}
		return true;
	}	

	
	/**
	 * addAdminPracticeWithMandatory
	 * function to create an Provider.
	 * @param 		selenium
	 * @param 		pracData
	 * @throws IOException 
	 * @since  	    Sep 01, 2012
	 */	
	public boolean addAdminPracticeAWithMandatoryPortability(Selenium selenium,SystemSettingsLib pracData,String account) throws IOException{
		try{
			assertTrue(type(selenium,btnPracticeName,pracData.practiceName),"Could not enter the practice name"+ pracData.toString(),selenium, ClassName, MethodName);
			//Assert.assertTrue(type(selenium,btnPracticeCode,pracData.practiceCode),"Could not enter the practice code"+ pracData.toString());
			if(!account.equals(CAAccount)){
			assertTrue(type(selenium,btnTaxId,pracData.taxId),"Could not enter the tax id"+ pracData.toString(),selenium, ClassName, MethodName);
			}
			//Assert.assertTrue(type(selenium,txtGroupNpi,pracData.groupNpi),"Could not enter the tax id"+ pracData.toString());
			assertTrue(type(selenium,txtEmail ,pracData.email),"Could not enter email"+ pracData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxCommTy1suggestBox,pracData.primaryPhoneType1);
			assertTrue(type(selenium,txtPrimaryPhone,pracData.primaryPhoneNumber1),"Could not enter primary phone number"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPrimaryPhoneExt,pracData.primaryPhoneExtn1),"Could not enter primary phone extension"+ pracData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxCommTy2suggestBox,pracData.primaryPhoneType2);
			assertTrue(type(selenium,txtOtherPhone1 ,pracData.primaryPhoneNumber2),"Could not enter other phone type"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtOtherPhone1Extn,pracData.primaryPhoneExtn2),"Could not enter other phone extn"+ pracData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxCommTy3suggestBox,pracData.primaryPhoneType3);
			assertTrue(type(selenium,txtOtherPhone2,pracData.primaryPhoneNumber3),"Could not enter other phone"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtOtherPhone2Extn,pracData.primaryPhoneExtn3),"Could not enter other phone extn"+ pracData.toString(),selenium, ClassName, MethodName);
			//Assert.assertTrue(type(selenium,"css=textarea.gwt-TextArea",pracData.comments),"Could not enter comments"+ pracData.toString());
			
			assertTrue(type(selenium,txtAddr1,pracData.address1),"Could not enter address1"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr2,pracData.address2),"Could not enter address2"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter city"+ pracData.toString(),selenium, ClassName, MethodName);
			
			if(account.equals(CAAccount)){
				selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.stateCA);
				assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}else{
				selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.state);
				assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}
			click(selenium,"noButton");
			selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,pracData.country);
			
			if(isChecked(selenium, "schedulingAppointmentsFlagcheckbox")){
				assertTrue(click(selenium,"schedulingAppointmentsFlagcheckbox"),"Couldnot click the next button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			selectValueFromAjaxList(selenium,ajxPracticeType,pracData.practiceType);
			
			assertTrue(click(selenium,btnNextFromPractice),"Couldnot click the next button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtLocationName ,pracData.locationName1),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtBillingLocationName ,pracData.locationName1),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtnpi ,pracData.groupNpi),"Could not enter group npi"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr1 ,pracData.address1),"Could not enter address 1"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr2 ,pracData.address2),"Could not enter address 2"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
			//Assert.assertTrue(selectValueFromAjaxList(selenium,ajxStateSuggestBoxSuggestBox ,pracData.state),"Could not enter Location name"+ pracData.toString());
			if(account.equals(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium,ajxStateSuggestBoxSuggestBox ,pracData.stateCA),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}else{
				assertTrue(selectValueFromAjaxList(selenium,ajxStateSuggestBoxSuggestBox ,pracData.state),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}
			click(selenium,"noButton");
			selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,pracData.country);
			
			
			if(isChecked(selenium, "schedulingAppointmentsFlagcheckbox")){
				assertTrue(click(selenium,"schedulingAppointmentsFlagcheckbox"),"Couldnot click the next button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			
			assertTrue(click(selenium,btnLocationSave),"could not click the save button From Location Page",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//click Add new from Location page
			assertTrue(click(selenium,"css=button.secondary-button.left-button-spacer"),"could not click the Add New button From Location Page",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtLocationName ,pracData.locationName2),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtBillingLocationName ,pracData.locationName2),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtnpi ,pracData.groupNpi),"Could not enter group npi"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr1 ,pracData.address1),"Could not enter address 1"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr2 ,pracData.address2),"Could not enter address 2"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxStateSuggestBoxSuggestBox ,pracData.state),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
			if(account.equals(CAAccount)){
				assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}else
				assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			click(selenium,"noButton");
			selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,pracData.country);
			
			assertTrue(click(selenium,btnLocationSave),"could not click the save button From Location Page",selenium, ClassName, MethodName);
			
			if(pracData.testCaseId.equals("TC_CPR_002")){
				assertTrue(click(selenium,"css=button.secondary-button.left-button-spacer"),"could not click the Add New button From Location Page",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtLocationName ,pracData.locationName3),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtBillingLocationName ,pracData.locationName3),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtnpi ,pracData.groupNpi),"Could not enter group npi"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtAddr1 ,pracData.address1),"Could not enter address 1"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtAddr2 ,pracData.address2),"Could not enter address 2"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium,ajxStateSuggestBoxSuggestBox ,pracData.state),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
				if(account.equals(CAAccount)){
					assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
				}else
					assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
				click(selenium,"noButton");
				selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,pracData.country);
				
				assertTrue(click(selenium,btnLocationSave),"could not click the save button From Location Page",selenium, ClassName, MethodName);
				
				//Click on add New button
				assertTrue(click(selenium,"css=button.secondary-button.left-button-spacer"),"could not click the Add New button From Location Page",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtLocationName ,pracData.locationName1),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtBillingLocationName ,pracData.locationName1),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtnpi ,pracData.groupNpi),"Could not enter group npi"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtAddr1 ,pracData.address1),"Could not enter address 1"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtAddr2 ,pracData.address2),"Could not enter address 2"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium,ajxStateSuggestBoxSuggestBox ,pracData.state),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
				if(account.equals(CAAccount)){
					assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
				}else
					assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
				click(selenium,"noButton");
				selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,pracData.country);
				
				assertTrue(click(selenium,btnLocationSave),"could not click the save button From Location Page",selenium, ClassName, MethodName);
			}
			
			
			
		      assertTrue(click(selenium,"xpath=(//button[@type='button'])[3]"),"could not click the done button",selenium, ClassName, MethodName);
		      waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnEdit1)){
				return true;
			}else{
				return false;
			}

			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		
	}

	
	public boolean addLocationAdminPortability(Selenium selenium,SystemSettingsLib pracData,String account){
		try{
			assertTrue(click(selenium,btnEdit1),"Could not click edit button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(click(selenium,btnNextFromPractice),"Couldnot click the next button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			/*int count=0;
			waitForPageLoad(selenium);
			while(isElementPresent(selenium, "link=Delete")){
				
				if(pracData.testCaseId.equals("TC_CPR_002")){
					if((selenium.isTextPresent(pracData.locationName1))&&(selenium.isTextPresent(pracData.locationName2))
							&&(selenium.isTextPresent(pracData.locationName3))&&(selenium.isTextPresent(pracData.locationName4))){
						return true;
					}
				}
				else if(!pracData.testCaseId.equals("TC_CPR_002")){
						(selenium.isTextPresent(pracData.locationName1))&&
						(selenium.isTextPresent(pracData.locationName2))){
					return true;
						}
				}
				if(getText(selenium, "link=Delete").equalsIgnoreCase("Delete")){
					click(selenium, "link=Delete");
					click(selenium,"yesButton");
				}
				count++;
				if(count>20){
					break;
				}
			}*/
			
			
			//Add first location for the created practice
			if(!selenium.isTextPresent(pracData.locationName1)){
				assertTrue(click(selenium,"css=button.secondary-button.left-button-spacer"),"Could not click add location button",selenium, ClassName, MethodName );
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtLocationName,pracData.locationName1),"Could not enter location code"+ pracData.toString(),selenium, ClassName, MethodName);
				
				waitForPageLoad(selenium);
				//Assert.assertTrue(type(selenium,txtLocationDescription0,pracData.locationName1),"Could not location description"+ pracData.toString());
				assertTrue(type(selenium,txtBillingLocationName,pracData.locationName1),"Could not enter location name"+ pracData.toString(),selenium, ClassName, MethodName);
				
				assertTrue(type(selenium,txtAddr1,pracData.address1),"Could not enter address1"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtAddr2,pracData.address2),"Could not enter address2"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter city"+ pracData.toString(),selenium, ClassName, MethodName);
				
				if(account.equals(CAAccount)){
					selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.stateCA);
					assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
				}else{
					selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBoxLoc1,pracData.state);
					assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
				}
				click(selenium,btnYes);
				selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,pracData.country);
				
				if(isChecked(selenium,"schedulingAppointmentsFlagcheckbox")){
					click(selenium,"schedulingAppointmentsFlagcheckbox");
				}
				
				assertTrue(click(selenium,btnLocationSave),"could not click the save button From Location Page",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//Add second location for the created practice
			if(!selenium.isTextPresent(pracData.locationName2)){
				assertTrue(click(selenium,txtAddLocationButton),"Could not click add location button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtLocationName,pracData.locationName2),"Could not enter location code"+ pracData.toString(),selenium, ClassName, MethodName);
				//Assert.assertTrue(type(selenium,txtLocationDescription1,pracData.locationName2),"Could not location description"+ pracData.toString());
				assertTrue(type(selenium,txtBillingLocationName,pracData.locationName2),"Could not enter location name"+ pracData.toString(),selenium, ClassName, MethodName);
				
				assertTrue(type(selenium,txtAddr1,pracData.address1),"Could not enter address1"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtAddr2,pracData.address2),"Could not enter address2"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter city"+ pracData.toString(),selenium, ClassName, MethodName);
				
				if(account.equals(CAAccount)){
					selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.stateCA);
				    assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
				}else{
					selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.state);
					assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
				}
				click(selenium,btnYes);
				selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,pracData.country);
				
	
				if(isChecked(selenium,"schedulingAppointmentsFlagcheckbox")){
					click(selenium,"schedulingAppointmentsFlagcheckbox");
				}
			     assertTrue(click(selenium,btnLocationSave),"could not click the save button From Location Page",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if(pracData.testCaseId.equals("TC_CPR_002")){
				if(!selenium.isTextPresent(pracData.locationName3)){
					assertTrue(click(selenium,txtAddLocationButton),"Could not click add location button",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					assertTrue(type(selenium,txtLocationName,pracData.locationName3),"Could not enter location code"+ pracData.toString(),selenium, ClassName, MethodName);
					//Assert.assertTrue(type(selenium,txtLocationDescription3,pracData.locationName3),"Could not location description"+ pracData.toString());
					assertTrue(type(selenium,txtBillingLocationName,pracData.locationName3),"Could not enter location name"+ pracData.toString(),selenium, ClassName, MethodName);
					
					assertTrue(type(selenium,txtAddr1,pracData.address1),"Could not enter address1"+ pracData.toString(),selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtAddr2,pracData.address2),"Could not enter address2"+ pracData.toString(),selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter city"+ pracData.toString(),selenium, ClassName, MethodName);
					
					if(account.equals(CAAccount)){
						selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.stateCA);
						assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
					}else{
						selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.state);
						assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
					}
					click(selenium,btnYes);
					selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,pracData.country);
					
					if(isChecked(selenium,"schedulingAppointmentsFlagcheckbox")){
						click(selenium,"schedulingAppointmentsFlagcheckbox");
					}
					
					assertTrue(click(selenium,btnLocationSave),"could not click the save button From Location Page",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
				}
				
				if(!selenium.isTextPresent(pracData.locationName4)){
					assertTrue(click(selenium,txtAddLocationButton),"Could not click add location button",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					assertTrue(type(selenium,txtLocationName,pracData.locationName4),"Could not enter location code"+ pracData.toString(),selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					//Assert.assertTrue(type(selenium,txtLocationDescription4,pracData.locationName4),"Could not location description"+ pracData.toString());
					assertTrue(type(selenium,txtBillingLocationName,pracData.locationName4),"Could not enter location name"+ pracData.toString(),selenium, ClassName, MethodName);
					
					assertTrue(type(selenium,txtAddr1,pracData.address1),"Could not enter address1"+ pracData.toString(),selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtAddr2,pracData.address2),"Could not enter address2"+ pracData.toString(),selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter city"+ pracData.toString(),selenium, ClassName, MethodName);
					
					if(account.equals(CAAccount)){
						selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.stateCA);
						assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString() ,selenium, ClassName, MethodName);
					}else{
						selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.state);
						assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
					}
					click(selenium,btnYes);
					selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBoxLoc4,pracData.country);
					if(isChecked(selenium,"schedulingAppointmentsFlagcheckbox")){
						click(selenium,"schedulingAppointmentsFlagcheckbox");
					}
					
					assertTrue(click(selenium,btnLocationSave),"could not click the save button From Location Page",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			}
			//Assert.assertTrue(click(selenium,btnSave),"Could not click on save button"+ pracData.toString());
			//Assert.assertTrue(click(selenium,"xpath=(//button[@type='button'])[8]"),"Could not click on save button"+ pracData.toString());
			
			waitForPageLoad(selenium);
			if(pracData.testCaseId.equals("TC_CPR_002")){
				if((selenium.isTextPresent(pracData.locationName1))&&(selenium.isTextPresent(pracData.locationName2))
						&&(selenium.isTextPresent(pracData.locationName3))&&(selenium.isTextPresent(pracData.locationName4))){
					return true;
				}
			}else if(!pracData.testCaseId.equals("TC_CPR_002")){ 
				if((selenium.isTextPresent(pracData.locationName1))&&
					(selenium.isTextPresent(pracData.locationName2))){
				return true;
				}
			}
			else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	
	
	/**
	 * Add New Payer
	 * function to Add New Payer
	 * @throws IOException 
	 * @since  	     Sep 13, 2013
	 */	
	public boolean addNewPayer(Selenium selenium,SystemSettingsLib createPayer,String account) throws IOException{
		    assertTrue(selectValueFromAjaxList(selenium,ajxSuggestBoxIdType,"add"),"Could not add payer manually"+ createPayer.toString(),selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
		    assertTrue(type(selenium,txtPayerName ,createPayer.payerName),"Could not type a PayerName" + createPayer.toString(),selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
			if(!account.equals((CAAccount))){
			assertTrue(type(selenium,txtPayerCode ,createPayer.payerCode),"Could not type a Payer Code" + createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			assertTrue(selectValueFromAjaxList(selenium,ajxSelectPayerType,createPayer.payerType),"Could not select Payer Type"+ createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtAddr1,createPayer.streetName),"Could not type a Payer Street" + createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtCity,createPayer.city),"Could not type a Payer City" + createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(account.equals((CAAccount))){
			assertTrue(selectValueFromAjaxList(selenium,ajxStateSuggestBoxSuggestBox,createPayer.stateCA),"Could not select Payer State"+ createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtZip,createPayer.zipcodeCa),"Could not type a Zipcode" + createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}else{
				assertTrue(selectValueFromAjaxList(selenium,ajxStateSuggestBoxSuggestBox,createPayer.state),"Could not select Payer State"+ createPayer.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtZip,createPayer.zipcode),"Could not type a Zipcode" + createPayer.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			click(selenium,"noButton");
			assertTrue(type(selenium,txtPhone,createPayer.telePhoneNo),"Could not type a Phone" + createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click on save a Payer link:" + createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnDone),"Could not click the Done button;More Details:"+createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnEditPayer)){
				return true;
			}else{
				
			}return false;
			
	}	
	
	
	/**
	 * addPractice
	 * function to create an Provider.
	 * @param 		selenium
	 * @param 		pracData
	 * @since  	    July 30, 2012
	 */	
	public boolean addAdminPractice(Selenium selenium,SystemSettingsLib pracData,String account,String uniqueName){
		try{
			
			assertTrue(type(selenium,btnPracticeName,pracData.practiceName+uniqueName),"Could not enter the practice name"+ pracData.toString(),selenium, ClassName, MethodName);
			//Assert.assertTrue(type(selenium,btnPracticeCode,pracData.practiceCode),"Could not enter the practice code"+ pracData.toString());
			if(!account.equals(CAAccount)){
			assertTrue(type(selenium,btnTaxId,pracData.taxId),"Could not enter the tax id"+ pracData.toString(),selenium, ClassName, MethodName);
			//Assert.assertTrue(type(selenium,txtGroupNpi,pracData.groupNpi),"Could not enter the tax id"+ pracData.toString());
			}
			assertTrue(type(selenium,txtEmail ,pracData.email),"Could not enter email"+ pracData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxCommTy1suggestBox,pracData.primaryPhoneType1);
			assertTrue(type(selenium,txtPrimaryPhone,pracData.primaryPhoneNumber1),"Could not enter primary phone number"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPrimaryPhoneExt,pracData.primaryPhoneExtn1),"Could not enter primary phone extension"+ pracData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxCommTy2suggestBox,pracData.primaryPhoneType2);
			assertTrue(type(selenium,txtOtherPhone1 ,pracData.primaryPhoneNumber2),"Could not enter other phone type"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtOtherPhone1Extn,pracData.primaryPhoneExtn2),"Could not enter other phone extn"+ pracData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxCommTy3suggestBox,pracData.primaryPhoneType3);
			assertTrue(type(selenium,txtOtherPhone2,pracData.primaryPhoneNumber3),"Could not enter other phone"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtOtherPhone2Extn,pracData.primaryPhoneExtn3),"Could not enter other phone extn"+ pracData.toString(),selenium, ClassName, MethodName);
			//Assert.assertTrue(type(selenium,"css=textarea.gwt-TextArea",pracData.comments),"Could not enter comments"+ pracData.toString());
			
			assertTrue(type(selenium,txtAddr1,pracData.address1),"Could not enter address1"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr2,pracData.address2),"Could not enter address2"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter city"+ pracData.toString(),selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.state);
			if(account.equals(CAAccount)){
				assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}else
				assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			click(selenium,"noButton");
			selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,pracData.country);
			selectValueFromAjaxList(selenium,ajxPracticeType,pracData.practiceType);
			if(pracData.testCaseId.equals("TC_CPR_013")){
				assertTrue(click(selenium,btnNextOne),"Could not click the Next button",selenium, ClassName, MethodName);
			}else
			assertTrue(click(selenium,btnDonePratice),"Could not click the done button",selenium, ClassName, MethodName);
			
			if(!pracData.testCaseId.equals("TC_CPR_013"))
				if(!isElementPresent(selenium,btnEdit1)){
					return false; 
				}else
					return true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * addPracticeWithMandatory
	 * function to create an Provider.
	 * @param 		selenium
	 * @param 		pracData
	 * @since  	    July 31, 2012
	 */	
	public boolean addAdminPracticeWithMandatory(Selenium selenium,SystemSettingsLib pracData,String account,String uniqueName){
		try{
			
			assertTrue(type(selenium,btnPracticeName,pracData.practiceName+uniqueName),"Could not enter the practice name"+ pracData.toString(),selenium, ClassName, MethodName);
			
			if(account.equals(USAccount)) {
				assertTrue(type(selenium,btnTaxId,pracData.taxId),"Could not enter the tax id"+ pracData.toString(),selenium, ClassName, MethodName);
			}
			else{
				assertTrue(!(isElementPresent(selenium,btnTaxId)&&isElementVisible(selenium,btnTaxId)),"Tax Id should not be visible for CA Account"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(!(isElementPresent(selenium,txtGroupNpi)&&isElementVisible(selenium,txtGroupNpi)),"Group NPI should not be visible for CA Account"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(!(isElementPresent(selenium,chkBillingLocation)&&isElementVisible(selenium,chkBillingLocation)),"Billing Location should not be visible for CA Account"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(!(isElementPresent(selenium,txtMammo)&&isElementVisible(selenium,txtMammo)),"Mammography Certification should not be visible for CA Account"+ pracData.toString(),selenium, ClassName, MethodName);
				assertTrue(!(isElementPresent(selenium,txtTaxRate)&&isElementVisible(selenium,txtTaxRate)),"Tax Rate should not be visible for CA Account"+ pracData.toString(),selenium, ClassName, MethodName);	
			}
			/*selectValueFromAjaxList(selenium,ajxCommTy1suggestBox,pracData.primaryPhoneType1);
			assertTrue(type(selenium,txtPrimaryPhone,pracData.primaryPhoneNumber1),"Could not enter primary phone number"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPrimaryPhoneExt,pracData.primaryPhoneExtn1),"Could not enter primary phone extension"+ pracData.toString(),selenium, ClassName, MethodName);*/
			assertTrue(type(selenium,txtAddr1,pracData.address1),"Could not enter address1"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr2,pracData.address2),"Could not enter address2"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter city"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium,ajxPracticeType,pracData.practiceType),"Could not enter Practice Type"+ pracData.toString(),selenium, ClassName, MethodName);
			if(account.equals(CAAccount)){
				selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.stateCA);
				assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}else{
				selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,pracData.state);
				assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			click(selenium,btnYes);
			selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,pracData.country);
			if(pracData.testCaseId.equals("TC_CPR_016")){
				assertTrue(click(selenium,chkArticle16),"Could not check Location is an Article 16 Facility checkbox" + pracData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue((isElementPresent(selenium,radOnSite16)&&isElementVisible(selenium,radOnSite16)),"On-site radio button note present "+ pracData.toString(),selenium, ClassName, MethodName);	
				assertTrue((isElementPresent(selenium,radOffSite16)&&isElementVisible(selenium,radOffSite16)),"Off-site radio button note present "+ pracData.toString(),selenium, ClassName, MethodName);	
				assertTrue(isChecked(selenium,radOnSite16),"On-site should a default value"+ pracData.toString(),selenium, ClassName, MethodName);	
			}
			if(pracData.testCaseId.equals("TC_CPR_017")){
				assertTrue(click(selenium,chkArticle28),"Could not check Location is an Article 16 Facility checkbox" + pracData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue((isElementPresent(selenium,radOnSite28)&&isElementVisible(selenium,radOnSite28)),"On-site radio button note present "+ pracData.toString(),selenium, ClassName, MethodName);	
				assertTrue((isElementPresent(selenium,radOffSite28)&&isElementVisible(selenium,radOffSite28)),"Off-site radio button note present "+ pracData.toString(),selenium, ClassName, MethodName);	
				assertTrue(isChecked(selenium,radOnSite28),"On-site should a default value"+ pracData.toString(),selenium, ClassName, MethodName);	
			}
			if(pracData.testCaseId.equals("TC_CPR_018")){
				assertTrue(selectValueFromAjaxList(selenium,ajxSLI,pracData.SLI),"Not able to enter Service Level indicator"+ pracData.toString(),selenium, ClassName, MethodName);	
			}
			
			if(pracData.testCaseId.equals("TC_CPR_007")){
			    assertTrue(click(selenium,btnNextOne),"Could not click on Next location Radio button"+ pracData.toString(),selenium, ClassName, MethodName);
			}else
				assertTrue(click(selenium,btnDonePratice),"Could not click on save button"+ pracData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	
	/**
	 * addLocation
	 * function to add Location
	 * @param 		selenium
	 * @param 		pracData
	 * @throws IOException 
	 * @since  	    Sep 16, 2012
	 */	
	public boolean addLocation(Selenium selenium,SystemSettingsLib pracData, String account) throws IOException{
		assertTrue(type(selenium,txtLocationName ,pracData.locationName1),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtAddr1 ,pracData.address1),"Could not enter address 1"+ pracData.toString(),selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtAddr2 ,pracData.address2),"Could not enter address 2"+ pracData.toString(),selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtCity ,pracData.city),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
		
		waitForPageLoad(selenium);
		if(account.equals(CAAccount)){
			assertTrue(selectValueFromAjaxList(selenium,ajxStateSuggestBoxSuggestBox ,pracData.stateCA),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtZip,pracData.zipcodeCa),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
		}else{
			assertTrue(selectValueFromAjaxList(selenium,ajxStateSuggestBoxSuggestBox ,pracData.state),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
		    assertTrue(type(selenium,txtZip,pracData.zipcode),"Could not enter zipcode"+ pracData.toString(),selenium, ClassName, MethodName);
		}

		if(account.equals(USAccount)) {
			assertTrue(type(selenium,txtBillingLocationName ,pracData.locationName1),"Could not enter Location name"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtnpi ,pracData.groupNpi),"Could not enter group npi"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtTaxRate,pracData.taxRate),"Could not enter the tax rate"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtMammo,pracData.mammography),"Could not enter Maamography"+ pracData.toString(),selenium, ClassName, MethodName);
		}
		else{
			assertTrue(!(isElementPresent(selenium,btnTaxId)&&isElementVisible(selenium,btnTaxId)),"Tax Id should not be visible for CA Account"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(!(isElementPresent(selenium,txtGroupNpi)&&isElementVisible(selenium,txtGroupNpi)),"Group NPI should not be visible for CA Account"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(!(isElementPresent(selenium,chkBillingLocation)&&isElementVisible(selenium,chkBillingLocation)),"Billing Location should not be visible for CA Account"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(!(isElementPresent(selenium,txtMammo)&&isElementVisible(selenium,txtMammo)),"Mammography Certification should not be visible for CA Account"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue(!(isElementPresent(selenium,txtTaxRate)&&isElementVisible(selenium,txtTaxRate)),"Tax Rate should not be visible for CA Account"+ pracData.toString(),selenium, ClassName, MethodName);
			assertTrue((isElementPresent(selenium,ajxSLI)&&isElementVisible(selenium,ajxSLI)),"Tax Rate should not be visible for CA Account"+ pracData.toString(),selenium, ClassName, MethodName);	
		}
			
		click(selenium,"noButton");
		selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,pracData.country);
		waitForPageLoad(selenium);
		
		
		
		
		if(pracData.testCaseId.equals("TC_CPR_009")){
			//coverred in class itself(VerifyHoursFormatInLocationHours.java)
			/*if(!isChecked(selenium,chk24HrFormat)){
				Assert.assertTrue(click(selenium,chk24HrFormat),"Could not click the check box ");
				Assert.assertTrue(click(selenium,chkSchedul),"Could not click the scheduling check box check box ");
			}*/
		}else if (pracData.testCaseId.equals("TC_CPR_010")){
			/*//coverred in class itself(VerifyHoursFormatInLocationHours.java)
			if(isChecked(selenium,chk24HrFormat)){
				assertTrue(click(selenium,chk24HrFormat),"Could not click the check box ",selenium, ClassName, MethodName);
				assertTrue(click(selenium,chkSchedul),"Could not click the scheduling check box check box ",selenium, ClassName, MethodName);
			}*/
		}
		
		if(pracData.testCaseId.equals("TC_CPR_014")){
			if(!isChecked(selenium, chkLocationLab)){
				assertTrue(click(selenium,chkLocationLab),"Could not check Location is Lab CheckBox ",selenium, ClassName, MethodName);
			}
		
			assertTrue(type(selenium,txtCLIANum,pracData.CLIANumber),"Could not check Location is Lab CheckBox ",selenium, ClassName, MethodName);
		}
		if(pracData.testCaseId.equals("TC_CPR_015")){
			if(isChecked(selenium, chkLocationLab)){
				assertTrue(click(selenium,chkLocationLab),"Could not check Location is Lab CheckBox ",selenium, ClassName, MethodName);
			}
			assertTrue((!isElementPresent(selenium,txtCLIANum)||!isElementVisible(selenium,txtCLIANum)),"CLIA Number text Box is present in CA view",selenium, ClassName, MethodName);
		}
		
		
		assertTrue(click(selenium,"css=div.second-level-header-top-right > button.secondary-button.left-button-spacer"),"could not click the save button From Location Page",selenium, ClassName, MethodName);
		
		if(!isElementPresent(selenium,lnkLocationEdit)){
			return false;
		}else
			return true;
	}
	/**
	 * createPacticeUnitTest
	 * function to create unit test for provider fields
	 * @param 		selenium
	 * @param 		practiceData
	 * @throws IOException 
	 * @since  	    August 13, 2012
	 */	
	public boolean createAdminPacticeUnitTest(Selenium selenium,SystemsSettingsUnitTest practiceData, String uniqueName, String account) throws IOException{
		try{
			
		    	if(!practiceData.testCaseId.equals("TC_SSPRAC_001")){
		    	assertTrue(type(selenium,btnPracticeName,practiceData.practiceName+uniqueName),"Could not type the practice name",selenium, ClassName, MethodName);
		    	}
		    assertTrue(type(selenium,btnTaxId,practiceData.taxId),"Could not type the practice name",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtGroupNpi,practiceData.groupNPI),"Could not type the practice name",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtEmail ,practiceData.email),"Could not type the practice name",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxCommTy1suggestBox,practiceData.telephoneType1);
			assertTrue(type(selenium,txtPrimaryPhone,practiceData.telephoneNo1),"Could not type the primary phone number",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPrimaryPhoneExt,practiceData.telephoneextnNo1),"Could not type the primary phone number extension",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxCommTy2suggestBox,practiceData.telephoneType2);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtOtherPhone1 ,practiceData.telephoneNo2),"Could not type the other phone extension 1",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtOtherPhone1Extn,practiceData.telephoneextnNo2),"Could not type telephone extension 1",selenium, ClassName, MethodName);
			assertTrue(type(selenium,ajxCommTy3suggestBox,practiceData.telephoneType3),"Could not type the primary phone number",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtOtherPhone2,practiceData.telephoneNo3),"Could not type the primary phone number",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtOtherPhone2Extn,practiceData.telephoneextnNo3),"Could not type the primary phone number",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr1,practiceData.address1),"Could not type the practice name",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtAddr2,practiceData.address2),"Could not type the practice name",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCity ,practiceData.city),"Could not type the practice name",selenium, ClassName, MethodName);
			if(account.equalsIgnoreCase(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,practiceData.stateCA),"Could not type the practice name",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtZip,practiceData.zipcodeCA),"Could not enter zipcode"+ practiceData.toString(),selenium, ClassName, MethodName);
				click(selenium,"yesButton");
				assertTrue(selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,practiceData.countryCA),"Could not type the practice name",selenium, ClassName, MethodName);
			}
			else{
				assertTrue(selectValueFromAjaxList(selenium, ajxStateSuggestBoxSuggestBox,practiceData.state),"Could not type the practice name",selenium, ClassName, MethodName);
			    assertTrue(type(selenium,txtZip,practiceData.zipcode),"Could not enter zipcode"+ practiceData.toString(),selenium, ClassName, MethodName);
				click(selenium,"yesButton");
				assertTrue(selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,practiceData.country),"Could not type the practice name",selenium, ClassName, MethodName);
			}
			assertTrue(type(selenium,txtTaxRate,practiceData.taxRate),"could not enter the tax rate",selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxPracticeType,practiceData.practiceType);
			
			
			
			
			assertTrue(click(selenium,chkNextRadio),"Could not click on save button"+ practiceData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} 
	}
	
	/**
	 * addLocation_Unit
	 * function to add Location_Unit
	 * @param 		selenium
	 * @param 		practiceData
	 * @throws IOException 
	 * @since  	    August 13, 2012
	 */	
	public boolean addLocation_Unit(Selenium selenium,SystemsSettingsUnitTest practiceData) throws IOException{
		
	   assertTrue(type(selenium,txtLocationName,practiceData.locationCode),"Could not type the location code",selenium, ClassName, MethodName);
		//Assert.assertTrue(type(selenium,txtLocationDescription0,practiceData.description),"Could not type the location description");
		assertTrue(type(selenium,txtBillingLocationName,practiceData.billingLocationName),"Could not type the  location name",selenium, ClassName, MethodName);
		
		selectValueFromAjaxList(selenium,ajxCommTy1suggestBox,practiceData.locationtelephoneType1);
		click(selenium,"//div[9]/div/div/div/div/div");				
		assertTrue(type(selenium,txtPrimaryPhone,practiceData.locationtelephoneNo1),"Could not type the primary phone number",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtPrimaryPhoneExt,practiceData.locationtelephoneextnNo1),"Could not type the primary phone number extension",selenium, ClassName, MethodName);
		
		
		selectValueFromAjaxList(selenium,ajxCommTy2suggestBox,practiceData.locationtelephoneType2);
		click(selenium,"//div[9]/div/div/div/div/div");	
		assertTrue(type(selenium,txtOtherPhone1,practiceData.locationtelephoneNo2),"Could not type the other phone extension 1",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtOtherPhone1Extn,practiceData.locationtelephoneextnNo2),"Could not type the primary phone number",selenium, ClassName, MethodName);
		
		selectEmptyValueFromAjaxList(selenium,ajxCommTy3suggestBox,practiceData.locationtelephoneType3);
		click(selenium,"//div[9]/div/div/div/div/div");	
		assertTrue(type(selenium,txtOtherPhone2,practiceData.locationtelephoneNo3),"Could not type the primary phone number",selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtOtherPhone2Extn,practiceData.locationtelephoneextnNo3),"Could not type the primary phone number",selenium, ClassName, MethodName);
		
		
		assertTrue(type(selenium,txtnpi,practiceData.npiNumber),"Could not type the NPI number",selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtAddr1,practiceData.businessaddress1),"Could not type the bussiness address1",selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtAddr2,practiceData.businessaddress2),"Could not type the business address 2",selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtCity,practiceData.businesscity),"Could not type the business city",selenium, ClassName, MethodName);
		
	
		assertTrue(type(selenium,ajxStateSuggestBoxSuggestBox,practiceData.businessstate),"Could not type the business state",selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtZip,practiceData.businesszipcode),"Could not type the business zip",selenium, ClassName, MethodName);
		
		
		selectValueFromAjaxList(selenium,ajxStateCountryBoxSuggestBox,practiceData.businesscountry);

		assertTrue(click(selenium,"//div[2]/div/div/div/div/div[2]/button[2]"),"Could not click on save a program link:" + practiceData .toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	

	
	
	public boolean centralizedAddress_Unit(Selenium selenium,SystemsSettingsUnitTest practiceData) throws IOException{
		
		if(!isChecked(selenium,chkCentralisedBilling)){
			assertTrue(click(selenium,chkCentralisedBilling),"Could not click the billing check box",selenium, ClassName, MethodName);
		}
		
		assertTrue(type(selenium,txtBillingAddr1,practiceData.billingStreet1),"Could not enter billing address1"+ practiceData.toString(),selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtBillingAddr2,practiceData.billingStreet2),"Could not enter billing address2"+ practiceData.toString(),selenium, ClassName, MethodName);
		assertTrue(type(selenium, txtCityPro,practiceData.billingCity), "Could not type the billing city"+practiceData.toString(),selenium, ClassName, MethodName);
		
		if(!practiceData.testCaseId.equalsIgnoreCase("TC_SSPRAC_042"))
			assertTrue(type(selenium,txtBillingZip,practiceData.zipcode),"Could not enter zipcode"+ practiceData.toString(),selenium, ClassName, MethodName);
		assertTrue(click(selenium,btnDonePratice),"Could not click on Done button:" + practiceData .toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
		
		
	}
	
	
	/**
	 * Create New Payer
	 * function to Add New Payer
	 * @throws IOException 
	 * @since  	     Sep 13, 2013
	 */	
	public boolean createNewPayer(Selenium selenium,SystemSettingsLib createPayer,String account) throws IOException{
		
			if(createPayer.testCaseId.equals("TC_AP_011")){
				assertTrue(selectValueFromAjaxList(selenium,ajxSuggestBoxIdType,"OHIP"),"Could not add payer manually"+ createPayer.toString(),selenium, ClassName, MethodName);
			}else{
			    assertTrue(selectValueFromAjaxList(selenium,ajxSuggestBoxIdType,"add"),"Could not add payer manually"+ createPayer.toString(),selenium, ClassName, MethodName);
			}
		    waitForPageLoad(selenium);
		    assertTrue(type(selenium,txtPayerName ,createPayer.payerName),"Could not type a PayerName" + createPayer.toString(),selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
			if(!account.equals((CAAccount))){
			assertTrue(type(selenium,txtPayerCode ,createPayer.payerCode),"Could not type a Payer Code" + createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			assertTrue(selectValueFromAjaxList(selenium,ajxSelectPayerType,createPayer.payerType),"Could not select Payer Type"+ createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtAddr1,createPayer.streetName),"Could not type a Payer Street" + createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtCity,createPayer.city),"Could not type a Payer City" + createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(account.equals((CAAccount))){
			assertTrue(selectValueFromAjaxList(selenium,ajxStateSuggestBoxSuggestBox,createPayer.stateCA),"Could not select Payer State"+ createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtZip,createPayer.zipcodeCa),"Could not type a Zipcode" + createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}else{
				assertTrue(selectValueFromAjaxList(selenium,ajxStateSuggestBoxSuggestBox,createPayer.state),"Could not select Payer State"+ createPayer.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtZip,createPayer.zipcode),"Could not type a Zipcode" + createPayer.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			click(selenium,"noButton");
			assertTrue(type(selenium,txtPhone,createPayer.telePhoneNo),"Could not type a Phone" + createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click on save a Payer link:" + createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
		// Create a Plan	
			
			assertTrue(click(selenium,btnPlan),"Could not click the Plan button;More Details:"+createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddNewPlan),"Could not click the Add New Plan button;More Details:"+createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			assertTrue(type(selenium,txtPlanName,createPayer.planName),"Could not type a Zipcode" + createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtCoPay,createPayer.coPay),"Could not type the Payer's Co-Pay Amount;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtSpecialistCoPay,createPayer.specialistCoPay),"Could not type the Specialist Co Pay;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    assertTrue(type(selenium, txtDeductible,createPayer.deductible),"Could not type the Payer Deductible Amount;More details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			
			if(!account.equals(CAAccount)){				
				assertTrue(type(selenium, txtCoInsurance,createPayer.coInsurance),"Could not type the Payer Co-insurance Percentage;More details:",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);								
			}		
					
			assertTrue(click(selenium,btnSave),"Could not click on Save Button; More details"+createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			assertTrue(click(selenium,btnDone),"Could not click the Done button;More Details:"+createPayer.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		
			if(isElementPresent(selenium,btnEditPayer)){
				return true;
			}else{
				
			}return false;
			
	}	
	
	/**
	 * goToPostNewCharge function go To Post New Charge
	 * 
	 * @since Jan 24, 2014
	 */
	public boolean goToPostNewCharge(Selenium selenium,
			BillingLib chargeEntryData,HomeLib payerData) {
		try {

			assertTrue(
					type(selenium, txtPatientBox, payerData.patientId),
					"Could not type patient id", selenium, ClassName,
					MethodName);
			selenium.clickAt("searchPatientBox","");
			selenium.focus("searchPatientBox");			
			selenium.fireEvent("searchPatientBox","keypress");
			//selenium.keyPress(txtPatientBox, "\\9");
			waitForElement(selenium, lblPatientResult, 10000);
			assertTrue(selenium.isElementPresent(lblPatientResult),
					"Search Results are not displayed for the patient with ID :-"
							+ payerData.patientId, selenium, ClassName,
					MethodName);
			waitForPageLoad(selenium);
			assertTrue(
					getText(selenium, lblPatientResult)
							.toLowerCase(new java.util.Locale("en", "US"))
							.trim()
							.contains(
								payerData.patientId.trim().toLowerCase(
											new java.util.Locale("en", "US"))),
					"match failed", selenium, ClassName, MethodName);
			// assertTrue(getText(selenium,lblPatientResult).contains(patientID));
			waitForPageLoad(selenium);

			selenium.mouseOver(lblPatientResult);
			waitForPageLoad(selenium);

			
			if(isElementPresent(selenium, lnkPostCharge1)){
				
				assertTrue(click(selenium, lnkPostCharge1),
			"Could not click the Booking Appointment", selenium,
			ClassName, MethodName);
	waitForPageLoad(selenium);
	}
	else{
		assertTrue(click(selenium, lnkPostCharge),
				"Could not click the Booking Appointment", selenium,
				ClassName, MethodName);
		waitForPageLoad(selenium);
	}
	waitForPageLoad(selenium);

			assertTrue(click(selenium, lnkPostNewCharge),
					"Could not click the Booking Appointment", selenium,
					ClassName, MethodName);
			waitForPageLoad(selenium);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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
	public boolean goToBillingHistory(Selenium selenium, HomeLib billingData)
			throws IOException {
		 if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		boolean returnValue = true;
		try {
			assertTrue(type(selenium, txtPatientBox, billingData.patientId),
					"Could not type patient id", selenium, ClassName,
					MethodName);
		} catch (Exception e) {
			assertTrue(type(selenium, txtPatientBox, billingData.patientId),
					"Could not type patient id", selenium, ClassName,
					MethodName);
		}
		
		selenium.clickAt("searchPatientBox","");
		selenium.focus("searchPatientBox");			
		selenium.fireEvent("searchPatientBox","keypress");
		
		//selenium.keyPress(txtPatientBox, "\\9");
		waitForElement(selenium, lblPatientResult, 10000);
		assertTrue(selenium.isElementPresent(lblPatientResult),
				"Search Results are not displayed for the patient with ID :-"
						+ billingData.patientId, selenium, ClassName,
				MethodName);
		waitForPageLoad(selenium);
		assertTrue(
				getText(selenium, lblPatientResult)
						.toLowerCase(new java.util.Locale("en", "US"))
						.trim()
						.contains(
								billingData.patientId.trim().toLowerCase(
										new java.util.Locale("en", "US"))),
				"match failed", selenium, ClassName, MethodName);
		// assertTrue(getText(selenium,lblPatientResult).contains(patientID));
		waitForPageLoad(selenium);

		selenium.mouseOver(lblPatientResult);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium, lnkBillingHistory)){

		assertTrue(click(selenium, lnkBillingHistory),
				"could not click Billing Settings", selenium, ClassName,
				MethodName);
		}
		waitForPageLoad(selenium);

		if (!(isElementPresent(selenium, lnkBillingSummary))) {
			returnValue = false;
		}

		return returnValue;
	}
	
	/**
	 * function to addPayer
	 * @param selenium
	 * @return boolean value
	 * @throws IOException
	 * @since Feb 19,2014
	 */
	public boolean addPayer(Selenium selenium, SystemSettingsLib payerData,SystemSettingsLib providerData ) throws IOException{
		if(payerData.userAccount.equals("US2000")){
		selectValueFromAjaxList(selenium,ajxPayerList,payerData.payerName);
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium,ajxEDIStatus,providerData.eDIStatus);
		assertTrue(type(selenium, txtProviderId,providerData.providerId ),"Could not enter the Provider id", selenium, ClassName,MethodName);
		selectValueFromAjaxList(selenium,ajxAlernateProvider,providerData.alernateProvider);
		assertTrue(type(selenium, txtGroupId,providerData.groupId ),"Could not enter the Group id", selenium, ClassName,MethodName);
		assertTrue(type(selenium, txtTaxonomy,providerData.providerId ),"Could not enter the Taxonomy Id", selenium, ClassName,MethodName);
	}else
	{
		assertTrue(selectValueFromAjaxList(selenium,ajxPayerList,payerData.payerName),"could not enter Payer name", selenium, ClassName,MethodName);
		assertTrue(type(selenium, txtProviderBillingNo,providerData.providerBillingNumber ),"Could not enter the Provider billing Number", selenium, ClassName,MethodName);
		assertTrue(type(selenium,txtPayToNumber,providerData.payToNumber),"Could not enter the Pat To Number", selenium, ClassName,MethodName);
		
	}
		if(payerData.testCaseId.equals("TC_AP_007")){
			assertTrue(click(selenium,APayerCancel),"Could not click the cancel button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}else{
			assertTrue(click(selenium,APayerSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}
		waitForPageLoad(selenium);

		assertTrue(!isElementPresent(selenium,APayerSave),"", selenium, ClassName, MethodName);
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


	

	
	
}

