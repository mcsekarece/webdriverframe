
package com.nexia.selenium.genericlibrary.demographics;


import com.sharedlibrary.AbstractTest;

public class DemographicsPageFactoring extends AbstractTest{
	public String btnSearchBox = "xpath=(//button[@type='button'])[2]";
	public String btnSearchBoxOnChart1 = "xpath=(//input[@id='searchPatientBox'])[2]";
	public String btnMerge = "editWarningButton";
	public String lnkChartMgmt = "chartManagementAction";
	public String lnkMergeCharts = "!mergeChartsSearch";
	public String ajkProgram="programIDSuggestBoxsuggestBox";
	public String ajkCaseStatus="caseStatusSuggestBoxsuggestBox";
	public String txtDateType="dateTypeSuggestBoxsuggestBox";
	public String chkHeadOfHouseHold1="xpath=//input[contains(@id,'headOfHousehold')]";
	public String chkHeadOfHouseHold2="xpath=//input[contains(@id,'headOfHousehold')]";
	public String lnkShowMoreLink="showMoreActions";
	public String txtTerminationReasonEdit="terminationReason";
	public String txtTerminationDateReason="terminationReason";
	public String lblPatientInfoChart1 = "patientTableLeft";
	public String lblpatientIdLeft = "patientIDLabel1";
	public String lblPatientIdRight="patientIDLabel2";
	public String lnkShowRecentPatient="link=Show recent patients »";
	public String lblPatientInfoChart2 = "patientTableRight";
	public String lblSocioInfo1 = "//div[2]/div/div/div/div[3]/div";
	public String lblSocioInfo2 = "//div[3]/div/div/div/div[2]/div/div[2]/div/div[3]/div";
			
	public String btnSearchBoxOnChart2 = "xpath=(//input[@id='searchPatientBox'])[3]";
	public String lnkPopUnfinishedItem = "css=div.popupContent > div";
	public String lnkReports="link=Reports";
	public String lnkPrint="link=Print";
	public String txtNumVisit="numAuthorizedVisits1";
	public String showUser="showToUserWhen";
	public String userCheckBoxOne="1checkboxshowToUserWhen";
	public String closeButton="multiSelectionCloseButton";
	public String btnEdit1="link=Edit";
	public String lnlPayerDelCommon ="xpath=(//*[contains(@id,'deleteAnchor')])[%d]";
	public String lnkDirectories = "!adminPayerList";
	public String btnDelete = "deleteButton";
    public String lnkMedicAcid = "link=www.medicaid.com";
    public String lnkExpandAll1="css=div.visits-list-item-main-content";
    public String lnkDeleteMandatoryField = "//a[starts-with(@id,'Delete')]";
    public String ajxSwitchrole1="xpath=(//input[@id='suggestBox'])[2]";
    public String txtSearchProvider="xpath=(//input[@id='searchTextBox'])[4]";
    public String txtSearchButton="xpath=(//button[@type='button'])[8]";
    public String  txtTerminationDateEdit="terminationDate";
    public String btnlogoutYesButton="Yes";
    
   public String txtEligibilityCheckDate = "eligibilityCheckDate";
   public String lnkCheckEligibility  = "checkEligibilityAnchor";
   public String lstPayers ="//div[@id='patientMedicalPayer']/div[2]/div/div/div[2]/div[3]/div/div[2]/div[2]/div";
   
    //FIXME-MNT-1300
    public String lblFirstProvider="//div[4]/div/div/div[3]/div/div[2]/table/tbody/tr/td/div/div/div/span";
    public String btnAddNewPayer="xpath=(//button[@id='add'])[3]";
    public String ajxPayerSuggestBox="payerSearchSugguestBoxsuggestBox";
    public String ajxDistrict="districtOfficeSugguestBoxsuggestBox";
    public String txtBilling="providerBillingNumber";
	//--------------------------------------------------------//
	//      Page factoring cases                              //
	//--------------------------------------------------------//
	
    public String lnkPayerDirectories = "!directories";
    // FIXME 	
    public String btnEdit2="//div[2]/div[2]/div/a[2]";
    //public String btnYesbutton = "yesButton";

	public String csspathsCases[]={"css=#description","css=#programIDSuggestBoxsuggestBox","css=#reason","css=#referralList","css=#startDate","css=#caseStatusSuggestBoxsuggestBox","css=#addCaseDates"};
	public String lblTimeStamp="//div[@id='PatientCaseList']/table/tbody/tr/td/div";
	public String lnkDeleteCases="//div[@id='PatientCaseList']/table/tbody/tr/td[3]/div/a";
	public String lnkEdit="//div[@id='PatientCaseList']/table/tbody/tr/td[2]/div/a";
	public String txtCaseId="css=span.gwt-InlineLabel";
	public String txtDescription="description";

	public String txtDepartment="//div[4]/div/span";
	public String txtReason="reason";
	
	public String txtTerminationEndDate="terminationDate";
	public String txtTerminationReason="terminationReason";
	public String txtStartDate="startDate";
	
	public String txtDate="date";
	public String btnCancl="cancel";
	public String lnkCloseArrow="//div[@id='PatientCaseList']/table/tbody/tr/td/div/div";
	public String lblInline="//div[@id='PatientCaseList']/table/tbody/tr/td/div/span/div";
	public String lblDescription="//div[@id='PatientCaseList']/table/tbody/tr/td/div/span/div";
	
	public String lblStartDate="//div[@id='PatientCaseList']/table/tbody/tr/td/div/span/div";
	public String lblProgram="//div[@id='PatientCaseList']/table/tbody/tr/td/div";
	public String lstReferral="referralList";
	public String lblReferralSummary="ReferralList";
	public String btnSave="save";
	public String txtDischargeDate="dischargeDate";
	public String txtDisPosition="disposition";
	//public String txtTerminationDate="terminationDate";
	
	public String txtTerminationDate="terminationDate";
	
	public String btnAddCaseDates="addCaseDates";
	public String ajkValueSelect1="//div[4]/div/div/div/div/div";
	public String ajkValueSelect2="//div[5]/div/div/div/div/div";
	public String ajkValueSelect3="//div[6]/div/div/div/div/div";
	public String txtDateType1="xpath=(//input[@id='dateTypeSuggestBoxsuggestBox'])[2]";
	public String txtDate1="xpath=(//input[@id='date'])[2]";
	public String txtNewPatientCheckin="newPatientCheckIn";
	public String lnkPatientCaseList="!patientCasesList";
	public String btnAddCase="addButton";
	public String lnkExpandAll="link=Expand all";
	public String lnkCollapseAll="link=Collapse all";
	public String lnkReferralList="!patientReferralList";
	public String lnkPatientOption="link=Patient Options";
	public String lnkPatientOptionRegistration="patientOptionsRegistration";
	public String btnDeleteCase="//a[contains(text(),'Delete')]";
	public String btnEditCase="//a[contains(text(),'Edit')]";
	public String lblPatientBorderBottom="css=div.patientInfoWidget";
	public String btnYesButton="yesButton";
	public String lblItemSelected="css=div.item-selected";
	public String ajkDateTypeSelected="//body/div[3]/div/div/div/div/div";
	public String ajkPopupBox="css=div.gwt-PopupPanel.localizedSuggestBoxOracle";
	
	//--------------------------------------------------------//
	//      Page factoring consents                           //
	//--------------------------------------------------------//
	public String csspathspatient[]={"css=#consentTypesuggestBox","css=#consentNamesuggestBox","css=#statussuggestBox","css=#dateSigned"};	
	public String csspathssubstitution[]={"css=#relationshipsuggestBox","css=#firstName","css=#lastName"};
	public String lnkSystemSetting="systemSettingsAction";
	public String lnkEnterpriseVariable="!enterpriseID";
	public String btnBackButton="back";
	public String lnkSecuritySetting="securitySettings";

	public String lnkConsents="!adminConsentList";
	public String btnAddConsents="addConsentType";
	public String btnAddDemoConsents="consentadd";
	public String btnDeleteConsents="//a[contains(text(),'Delete')]";
	public String btnEditConsents="//a[contains(text(),'Edit')]";
	public String lnkEditConsents="//div[@id='PatientConsentList']/table/tbody/tr/td[2]/div/a";
	public String ajkConsentsType="consentTypesuggestBox";
	public String ajkConsentsName="consentNamesuggestBox";
	public String ajkStatus="enrolementstatussuggestBox";
	public String ajkInactivation="id=reasonForInactivationsuggestBox";
	public String txtDateSigned="dateSigned";
	public String ajkRelationship="id=relationshipsuggestBox";
	public String txtFirstName="firstName";
	public String txtLastName="lastName";
	public String ajkEnrolementStatusSugBox="enrolementstatussuggestBox";
	public String ajkEnrolledSugBox="enrolledTosuggestBox";
	public String ajkEnrolementDte="enrolmentDate";
	public String txtCommentsConsents="comments";
	public String txtEnrolmentEndDate="enrolmentEndDate";
	public String txtReasonConsents="reasonForTerminationsuggestBox";
	public String txtSearchBox="searchTextBox";
	public String btnEnterpriseSearch="searchButtonId";
	public String btnEnterpriseAdd="addEnterpriseID";
	public String ajkVariableType="idTypeSuggestBoxsuggestBox";
	public String txtVariableValue="variableValueTextFieldId";
	public String ajkSSConsentsType="consentTypeSuggestBoxsuggestBox";
	public String txtSSConsentsName="consentName";
	public String txtSSValidNumber="validForNumber";
	public String ajkSSValidType="validForType";
	public String ajkSSRestrictionLevel="restrictionLevelSuggestBoxsuggestBox";
	public String ajkListSelect="//td[2]/div/div/div/div";
	public String rdoSubstitude="//span[2]/input";
	public String lnkConsentsPatient="!patientConsentsList";
	public String btnConsentsAdd="id=consentadd";
	public String lnkConsentsDelete="//div[@id='PatientConsentList']/table/tbody/tr/td[3]/div/a";
	public String rdoSubstitutionMark="//span[@id='signedByOther']/input";
	public String rdoSignedByOthers="signedByOtherradio";
	public String activeElementInPage="dom=document.activeElement";
	public String lblconsentSummary="PatientConsentList";
	public String lnkConsentExpandDetails="//span/div[2]";
	
	//--------------------------------------------------------//
	//      Record Locking                                    //
	//--------------------------------------------------------//
	
	public String lnkRecordLocking="!recordLockingMain";
	public String lnkSearch="//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr/td[2]/div/div/div/div[3]/div[2]/div/div/div/div/a";
	public String chkEntry="css=input[type=\"checkbox\"]";
	public String lnkUnlock="link=Unlock";
	public String lnkEditRL="css=a.trigger-view-record-locking-settings.floatRight";
	public String txtTime="css=input.gwt-TextBox";
	public String ajxTimeUnit="timeUnitSuggestBoxanchor";
	public String lblRecordLockPopupEdit="css=button.secondary-button.absoluteTopRight";
	public String lblRecordLockEdit="css=span.gwt-InlineHTML";
	public String lblRecordLockDelete="css=div.gwt-Label";
	public String lblRecordLockClose="css=a.close-popup-x.close-help-about-popup";
	public String btnNo="no";
	//--------------------------------------------------------//
	//      Page factoring contacts                           //
	//--------------------------------------------------------//
	public String csspathsContacts[]={"css=#guarantorcheckbox","css=#emergencyContactcheckbox","css=#guardiancheckbox","css=#subsDecisionMarkercheckbox","css=#othercheckbox","css=#relationshipsuggestBox","css=#titlesuggestBox","css=#lastName","css=#firstName","css=#suffixsuggestBox","css=#email","css=#languagesuggestBox","css=#comments","css=#contactAddr1","id=contactAddr2","css=#contactCity","css=#contactStatesuggestBox","css=#contactZip","css=#contactCountrysuggestBox","css=#commType1suggestBox","css=#primaryPhone","css=#primaryPhoneExt","css=#commType2suggestBox","css=#secondaryPhone","css=#secondaryPhoneExt","css=#commType3suggestBox","css=#tertiaryPhone","css=#tertiaryPhoneExt"};
	public String lnkContactList="!patientContactsList";
	public String deleteContact="link=Delete";
	public String editContact="link=Edit";
	public String yesButton1="yesButton";
	public String btnAddContact="addContact";
	public String lnkDeleteContact="//div[@id='PatientContactList']/table/tbody/tr/td[3]/div/a";
	public String lnkEditContact="//div[@id='PatientContactList']/table/tbody/tr/td[2]/div/a";
	public String txtEmail="email";
	public String txtContactAddr1="contactAddr1";
	public String txtContactAddr2="contactAddr2";
	public String txtContactZipCode="contactZip";
	public String txtComments="comments";
	public String lblContactSummaryArea="//div[@id='PatientContactList']/table/tbody/tr/td/div/div[2]";
	public String lblContactSummaryArea1="//div[@id='PatientContactList']/table/tbody/tr/td/div/div";
	public String lblContactSummaryAreaManda="//div[@id='PatientContactList']/table/tbody/tr/td";
	public String chkSubDesicionMaker="subsDecisionMarkercheckbox";
	public String chkGuarantor="guarantorcheckbox";
	public String chkEmergencyContact="emergencyContactcheckbox";
	public String ajkTitle="titlesuggestBox";
	public String ajkSuffix="suffixsuggestBox";
	public String ajkLanguage="languagesuggestBox";
	public String txtContactCity="contactCity";
	public String ajkContactState="contactStatesuggestBox";
	public String ajkContactCountry="contactCountrysuggestBox";
	public String ajkPrimPhone1="commType1suggestBox";
	public String txtPrimPhoneExtn="primaryPhoneExt";
	public String txtPrimaryPhone="primaryPhone";
	public String ajkPrimPhone2="commType2suggestBox";
	public String txtSecPhoneExtn="secondaryPhoneExt";
	public String txtSecPhone="secondaryPhone";
	public String ajkPrimPhone3="commType3suggestBox";
	public String txtTertiaryPhoneExtn="tertiaryPhoneExt";
	public String txtTertiaryPhone="tertiaryPhone";
	public String btnErrorClose="errorCloseButton";
	public String yesButton="Yes";
	public String chkGuardian="guardiancheckbox";
	public String chkOtherContactType="otherContactTypesuggestBox";
	public String lnkPatientInfoSummary="!patientInfoSummary";
	public String lblFirstNameSummary="//span/span[2]";
	public String lblLastNameSummary="//span/span[3]";
	public String lblContactTypeSummary="//div[2]/span[2]/span";
	public String txtPatientcontactSearchBox="patientcontactSearchBox";
	public String ajkContactSearch="css=button.secondary-button.left-button-spacer";
	public String ajkSelectContactSearch="//div[@id='patientContactPopup']/div/div/div/div/div/div";
	public String lblPatientSummary="//form/div/div";
	public String lblNoDetailsAdded="//div[@class='listNoData']";
	public String lblNoContactDetailsAdded="//div[3]/div/div/div/div/div/div[3]/div";
	public String lblContactWholeSummary="//td[2]/div/table/tbody/tr/td[2]";
	
	//--------------------------------------------------------//
	//      Page factoring Health care team                   //
	//--------------------------------------------------------//
	public String csspathsHealthCareTeam[]={"css=#suggestBox","css=#searchBox"};
	public String lnkPatientHealthcare="!patientHealthcareList";
	public String btnEnterpriseVariableSearch="searchButtonId";
	public String txtBoxValue="css=input.gwt-TextBox";
	public String ajkSuggestBox="suggestBox";
	public String lnkDeleteHelthCareTeam="//div[@id='PatientHealthcareTeamList']/table/tbody/tr/td[2]/div/a";
	public String txtDeleteReason="deleteReason";
	public String btnSearch="searchButton";
	public String chkPcP="pcp_2checkbox";
	public String chkTeamLead="teamLead_2checkbox";
	public String chkPcPCA="pcp_2172checkbox";
	public String chkTeamLeadCA="teamLead_2172checkbox";	
	public String ajkDuration="//input[starts-with(@id,'durationSuggest')]";
	public String txtEndDate="//input[starts-with(@id,'endBy')]";
	public String txtEndDateCA="//div[2]/div/div/div[2]/div/div/input";
	public String ajkRole="//input[starts-with(@id,'teamRoleSuggest')]";
	public String ajkRoleCA="//input[starts-with(@id,'teamRoleSuggest')]";
	public String txtEndNumber="//input[2]";
	public String txtEndNumberCA="//div[@id='selectedMemberList']/div/div[3]/div/div[2]/input[2]";
	public String ajxTimePeriod="//input[starts-with(@id,'endAfterTypeSuggest')]";
	public String ajxTimePeriodCA="//input[starts-with(@id,'endAfterTypeSuggest')]";
	public String ajxLocation="locationSuggestBoxsuggestBox";
	public String ajxSpeciality="specialtySuggestBoxsuggestBox";
	public String lnkExternalProvider="!adminExternalProviderList";
	public String lnkDeleteExternalProvider="//div[@id='AdminReferringProviderList']/table/tbody/tr/td[2]/div/a";
	public String btnAddExternalProvider="addReferringProvider";
	public String lblHealthCareTeamSummary="//div[@id='PatientHealthcareTeamList']/table/tbody/tr/td";
	public String lblHealthCareTeamExpandedSummary="//div[@class='chart-list-detail-item-top-spacer']";
	public String txtSearchTextBox="searchBox";
	public String lblHealthCareSearchDisplayedArea="//div[3]/div[2]/div/div";
	public String lblSearchedFirstStaffDisplay="//span/label";
	public String lblSearchedSecondStaffDisplay="//div[2]/span/label";
	public String lnkDeleteHealthCareList="//div[@id='AdminHealthcareList']/table/tbody/tr/td[3]/div/a";
	public String btnDeleteReason="//button[@id='deleteReason']";
	public String txtTeamName="teamName";
	public String txtNotes="notes";
	public String btnAddMember="addMemberSpan";
	public String ajxName="//div[2]/div[2]/div/div/div/div/div/div/input";
	public String ajxRole="roleSuggestBoxId1suggestBox";
	public String btnSaveHCT="saveHealthcareTeam";
	
	//--------------------------------------------------------//
	//      Page factoring Household          //
	//--------------------------------------------------------//
	public String lnkHouseHold="!familyMember";
	public String btnAddHouseHold="addfamilymember";
	public String lnkSearchPatient="css=div.gwt-TabBarItem.rightTab > div.gwt-HTML";
	public String txtSearchboxHouseHold="familyMemberSearchBox";
	public String btnSearchHouseHold="search";
	public String chkFirstHouseholdResult="//span/input";
	public String lblNoPatientDataFound="noPatientFound";	
	public String lblHouseHoldSummary1="xpath=//div[contains(@id,'collapsableTitle')]";
	public String lblHouseHoldSummary2="xpath=//div[contains(@id,'collapsableTitle')]";
	public String lnkHouseHoldDelete="//a[contains(text(),'Delete')]";
	public String chkCheckBox="//span/input";
	public String lnkDelete="link=Delete";
	public String lnkSystemSettings = "systemSettings"; 
	public String lnkExternalProviderList = "!adminExternalProviderList"; 
	public String lnkAddReferringProvider =  "addReferringProvider"; 
	public String btnAddHealthcareTeam = "addHealthcareTeam"; 
	public String lnkAdminHealthcareTeamList = "!adminHealthcareTeamList";
	
	//--------------------------------------------------------//
	//      Page factoring Login Page                         //
	//--------------------------------------------------------//
	public String txtAccountNumber="loginAccountText";
	public String txtUserName="loginUseridText";
	public String txtPassword="loginPasswordText";
	public String btnLogin="loginButton";
	public String lblValidation="//div[@class='login-panel']";
	public String lnkTopMenu="username";
	public String lnkSignOut="signOutAction";
	public String lnkAlertSgnout = "//div[@class='gwt-Label']";

	
	//--------------------------------------------------------//
	//      Page factoring Identifiers                //
	//--------------------------------------------------------//
	public String csspathsIdentifiers[]={"css=#groupsuggestBox","css=#typesuggestBox"};
	public String lnkIdentifier="!patientExternalIdList";
	public String btnAddIdentifier="addExternalID";
	public String lblDateIdentifier="//div[@id='PatientExternalIDList']/table/tbody/tr/td/div/div";
	public String lnkEditIdentifier="//div[@id='PatientExternalIDList']/table/tbody/tr/td[2]/div/a";
	public String ajxTypeIdentifier="xpath=(//input[@id='suggestBox'])[2]";
	public String txtExpiration="expirationdate";
	public String txtValueMask="idMask";
	public String lnkDeleteIdentifier="//div[@id='PatientExternalIDList']/table/tbody/tr/td[3]/div/a";
	public String ajxGroup="groupsuggestBox";
	public String ajxType="typesuggestBox";
	public String  lnkIdentifierGroup="!adminIdentifierGroupList";
	public String btnAddIdentifierGroup="addIdentifierGroup";
	public String lnkIdentifierType="!adminIdentifierTypeList";
	public String btnAddIdentifierType="addIdentifierType";
	public String lblIdentifierTypeSummary="//td[2]/div/div/div";
	public String lnkPractice="//div[@id='printInfo']/div/div/div/div/div[4]/div/div";
	public String lblSecondPractice="//tr[2]/td/a/span";
	public String lnkDeleteIdentifierGroup="//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[2]/div/div/a[2]";
	public String ajxGroupFor="groupFor";
	public String txtGroupName="group";
	public String lnkDeleteIdentifierType="//div[@id='AdminIdentifierTypeList']/table/tbody/tr/td[3]/div/a";
	public String txtType="type";
	public String txtMask="mask";
	public String chkRestricted="//span[@id='restricted']/input";
	public String chkExpiryDate="//span[@id='endDateRequired']/input";
	public String chkDefault="//span[@id='defaultType']/input";
	public String lnkEditIdentifierType="//a[contains(text(),'Edit')]";
	public String rdbDefinedList="//span[@id='definedList']/input";
	public String txtIdentifier="identifier";
	public String btnIdentifier="addID";
	public String lnkDeleteIdentifiers="//a[contains(text(),'Delete')]";
	public String lnkDeleteIdentifierType1="//a[contains(text(),'Delete')]";
	
	//--------------------------------------------------------//
	//      Page factoring My setting              			  //
	//--------------------------------------------------------//
	public String btnContinue="continueButton";
	public String txtCurrentPassword="currentPassword";
	public String txtNewPassword="newPassword";
	public String txtConfirmPassword="confirmNewPassword";
	public String lnkSignout="signOutAction";
	public String btnOk="okButton";
	public String lnkOrganizationalStructure="!adminOrgStructureLists";
	public String txtUserSearch="xpath=(//input[@id='searchTextBox'])[5]";
	public String btnUserSearch="xpath=(//button[@type='button'])[10]";
	public String lnkMySetting="css=#mySettingsAction > span.topMenuItemSpan.light";
	public String btnResetPassword="resetPassword";
	public String lnkPracticeAndRoles="!mySettingsPracticeEdit";
	public String lblUserSearchResult="css=span.listText > span.large";
	public String chkIncludeInactiveUsers="includeInactiveUserscheckbox";
	public String lblActivateAppleUser="ActivateUserAAAPPLE";
	public String lnkSwitchRole="switchRoleAction";
	public String lnkAdminUserRoleList="!adminUserRoleList";
	public String lnkAdminUserRoleMoreLink="AdminUserRoleListMoreLink";
	public String ajxHomePageView="homePageViewsuggestBox";
	public String lblHomePageContent="//span/div/div/div/div";
	public String lblHomePageContent1="css=div.dashboardActionCategory";
	public String lblHomePageContent2="css=span.reallyLighter.bold";
	public String lnkLanguageSwitch="css=#languageSwitchAction > span.topMenuItemSpan.light";
	public String lnkAudit="!audit";
	
	//--------------------------------------------------------//
	//      Page factoring For Notes Section                //
	//--------------------------------------------------------//
	public String csspathsNotes[]={"css=#noteDate","css=#suggestBox","css=#note"};
	public String lnkNotes="!patientNotesList";
	public String btnAddNote="addNote";
	public String lblNotesSummary="//div[@class='chart-list-item-left-wrapper no-hover']";
	public String lnkEditNotes="//div[@id='PatientNoteList']/table/tbody/tr/td[2]/div/a";
	public String lnkDeleteNotes="//div[@id='PatientNoteList']/table/tbody/tr/td[3]/div/a";
	public String txtNoteDate="noteDate";
	public String txtNote="note";
	public String lblDeleteNote="//a[contains(text(),'Delete')]";
	public String lblEditNote="//a[contains(text(),'Edit')]";
	public String lnkSystemSettingAction="systemSettingsAction";
	public String ajxCatagoryValue="css=div.item-selected";
	
	//--------------------------------------------------------//
	//      Page factoring For Patient check in info          //
	//--------------------------------------------------------//
	public String cssPathPatientCheckinCA[]={"css=#uploadButton","css=#chartNumber","css=#canadianProvincesuggestBox","css=#healthcardNumber","css=#expiryDate","css=#primaryLocationSuggestBoxsuggestBox","css=#responsibleProvSuggestBoxsuggestBox","css=#lastName","css=#firstName","css=#middleName","css=#titleSuggestBoxsuggestBox","css=#suffixSuggestBoxsuggestBox","css=#alias1","css=#alias2","css=#dob","css=#dobEstimatedcheckbox","css=#prematurecheckbox","css=#prematureDuration","css=#prematureMeasureUnitSuggestBoxsuggestBox","css=#sexSuggestBoxsuggestBox","css=#maritalStatusSuggestBoxsuggestBox","css=#statusSuggestBoxsuggestBox","css=#statusDate","css=#residentialAddr1","css=#residentialAddr2","css=#residentialCity","css=#residentialStatesuggestBox","css=#residentialZip","css=#residentialCountrysuggestBox","css=#commType1SuggestBoxsuggestBox","css=#primaryPhone","css=#primaryPhoneExtension","css=#commType2SuggestBoxsuggestBox","css=#ohterPhone1","css=#otherPhone1Extension","css=#commType3SuggestBoxsuggestBox","css=#otherPhone2","css=#otherPhone2Extension","css=#email","css=#contactPreferenceSuggestBoxId1suggestBox","css=#mailingAsResidentialcheckbox","css=#comments"};
	public String cssPathPatientCheckin[]={"css=#uploadButton","css=#chartNumber","css=#primaryLocationSuggestBoxsuggestBox","css=#responsibleProvSuggestBoxsuggestBox","css=#lastName","css=#firstName","css=#middleName","css=#titleSuggestBoxsuggestBox","css=#alias1","css=#alias2","css=#dob","css=#dobEstimatedcheckbox","css=#prematurecheckbox","css=#sexSuggestBoxsuggestBox","css=#maritalStatusSuggestBoxsuggestBox","css=#statusSuggestBoxsuggestBox","css=#statusDate","css=#residentialAddr1","css=#residentialAddr2","css=#residentialCity","css=#residentialStatesuggestBox","css=#residentialZip","css=#residentialCountrysuggestBox","css=#residentialCounty","css=#commType1SuggestBoxsuggestBox","css=#primaryPhone","css=#primaryPhoneExtension","css=#commType2SuggestBoxsuggestBox","css=#ohterPhone1","css=#otherPhone1Extension","css=#commType3SuggestBoxsuggestBox","css=#otherPhone2","css=#otherPhone2Extension","css=#email","css=#contactPreferenceSuggestBoxId1suggestBox","css=#mailingAsResidentialcheckbox","css=#mailingAddr1","css=#mailingCity","css=#mailingStatesuggestBox","css=#mailingZip","css=#mailingCountrysuggestBox","css=#comments"};
	public String lnkMandatoryUserFields="!adminMandatoryUserField";
	public String lnkEnterpriseVariables = "!enterpriseID";
	public String txtMiddleName="middleName";
	public String btnAddenterprise =  "addEnterpriseID";
	public String ajxSuggestBox =  "idTypeSuggestBoxsuggestBox";
	public String txtVariableBox =  "css=input.gwt-TextBox";
	public String ajxTitle="titleSuggestBoxsuggestBox";
	public String ajxSuffix="suffixSuggestBoxsuggestBox";
	public String txtAlias1="alias1";
	public String txtAlias2="alias2";
	public String txtDOB="dob";
	public String ajxPrematureMeasure="prematureMeasureUnitSuggestBoxsuggestBox";
	public String ajxSex="sexSuggestBoxsuggestBox";
	public String ajxmartialStatus="maritalStatusSuggestBoxsuggestBox";
	public String ajxStatus="statusSuggestBoxsuggestBox";
	public String txtStatusDate="statusDate";
	public String txtResidentAddress1="residentialAddr1";
	public String txtResidentAddress2="residentialAddr2";
	public String txtResidentialZip="residentialZip";
	public String ajxPhoneType1="commType1SuggestBoxsuggestBox";
	public String ajxPhoneType2="commType2SuggestBoxsuggestBox";
	public String ajxPhoneType3="commType3SuggestBoxsuggestBox";
	public String txtPrimaryPhoneExtn="primaryPhoneExtension";
	public String txtOtherPhone1Extn="otherPhone1Extension";
	public String txtOtherPhone2Extn="otherPhone2Extension";
	public String txtOtherPhone1="ohterPhone1";
	public String txtOtherPhone2="otherPhone2";
	public String txtMailingAddress1="mailingAddr1";
	public String txtMailingAddress2="mailingAddr2";
	public String txtMailingZip="mailingZip";
	public String lblStatus="status";
	public String lblAge="age";
	public String lblPatientName="patientName";
	public String lblTitlePatient="title";
	public String lblSuffix="suffix";
	public String lblAlais="alias";
	public String lblSex="sex";
	public String lblPatientDetails="patientDetails";
	public String lblPhoneType1="commType1";
	public String lblPhoneType2="commType2";
	public String lblPhoneType3="commType3";
	public String lblPhoneExtn1="commExtNum1";
	public String lblPhoneExtn2="commExtNum2";
	public String lblPhoneExtn3="commExtNum3";
	public String lblContactPreference="//div[8]/span[2]";
	public String chkPremature="prematurecheckbox";
	public String ajxPrematureDuration="prematureDurationSuggestBoxsuggestBox";
	public String lnkDeleteMandatoryUserFields="//div[@id='adminMandatoryUserFieldList']/table/tbody/tr/td[2]/div/a";
	public String txtChartNumber="chartNumber";
	public String btnBack="notDuplicateButton";
	
	public String chkDOBEstimated="dobEstimatedcheckbox";
	public String txtPrematureDuration="prematureDuration";
	public String ajxStationInactivation="statusInactivationReasonSuggestBoxsuggestBox";
	public String txtResidentialCity="residentialCity";
	public String ajxResidentialState="residentialStatesuggestBox";
	public String ajxResidentialCountry="residentialCountrysuggestBox";
	public String txtResidentialCountry="residentialCounty";
	public String ajxContactPreference="contactPreferenceSuggestBoxId1suggestBox";
	public String btnAddContactPreference="addButtonId";
	public String ajxContactPreference1="//div[7]/div/div/div[2]/div/div/div/input";
	public String ajxContactPreference2="//div[3]/div/div/div/input";
	public String ajxContactPreference4="//div[4]/div/div/div/input";
	public String chkMailingAsResidential="mailingAsResidentialcheckbox";
	public String txtMailingCity="mailingCity";
	public String ajxMailingState="mailingStatesuggestBox";
	public String ajxMailingCountry="mailingCountrysuggestBox";
	public String txtMailingCountry="mailingCounty";
	public String lblPicture="css=button.pictureButton";
	public String lblHealthCareNumber="healthcareNumber";
	public String txtHealthCareNumber="css=#healthcardNumber";
	public String ajxResponsibleProvider="//div[@id='responsibleProvider']/div/div/input";
	public String ajxPrimaryLocation="primaryLocationSuggestBoxsuggestBox";
	public String ajxResponsbleProvider="responsibleProvSuggestBoxsuggestBox";
	public String chkResponsibleProvider="responsibleProvPCPcheckbox";
	public String btnNoButton="noButton";
	public String lnkPatientInfoView="!patientInfoView";
	public String btnEditPatientNote="patientNoteEditButton";
	public String txtPatientNote="patientNote";
	public String btnSavePatientNote="patientNoteSaveButton";
	public String lblPatientNote="//div[2]/div[2]/div";
	public String lblPatientNoteShow="id=patientNoteShow";
	public String lblPatientNoteHide="id=patientNoteHide";
	public String lnkPatientNoteHide="patientNoteHide";
	public String lnkSocioEconomics="!patientSocialHistory";
	public String lnkReferrals="!patientReferralList";
	public String lnkProgram="!patientProgramsList";
	public String btnCancel="cancelButton";
	public String btnAddExtnalProvider="css=button.primary-button";
	public String ajxLiveArrangements="livingArrangementsuggestBox";
	public String ajxRace="raceSuggestBoxIdsuggestBox";
	public String txtRaceOther="raceOther";
	public String lblPracticeName="//div[@id='printInfo']/div/div/div/div/div[4]/div";

	public String lblResultPractice="//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr/td[2]/div/div/div/div/div/div/div[3]/div";
	public String lblPatientId="patientID";
	public String lblAgeInResult="css=div.patientDetails > div > span.dark.normalSize";
	public String lnkPatientChart="patientOptionsChartView";
	public String lnkPrescribeMed="patientOptionsPrescribeMedication";
	public String lnkExportPatientPort="css=#patientOptionsExportCCDToPatientPortal > span.topMenuItemSpan.light";
	public String lnkFileNewReport="patientOptionsManualEntry";
	public String lnkViewRegistration="patientOptionsRegistration";
	public String lnkExportChart="patientOptionsExportChart";
	public String lblSelectRecentPatient="//div[2]/div/table/tbody/tr/td[2]/div/div[3]";
	public String registerPatient="newPatientAction";
	public String lnkQuickActions="link=Quick Actions";
	public String lnkSettings = "link=Settings";
	public String lnkClinicalSettings = "clinicalSettingsAction";
	public String lnkRegisterPatient="newPatientAction";
	public String lnkQuickActionsRegisterPatient="css=span.actionItemSpan";
	public String btnRegistrationEdit="editButton";
	public String txtSearchPatientBox="searchPatientBox";
	public String btnSave1="saveButton";
	public String lnkAdminMandatoryUserField ="!adminMandatoryUserField";
	public String lnkPatientExportPortal="//a[@id='patientOptionsExportCCDToPatientPortal']/span";
	//-----------------------------------------//
	//      Page factoring For Programs        //
	//-----------------------------------------//
	public String lblProgramSummary1= "//div[@class='chart-list-item-main-content']";
	public String csspathsPrograms[]={"css=#suggestBox","css=#fromDate","css=#toDate","css=#priorState","css=#outcome"};		
	public String btnAddPrograms="addPrograms";
	public String lblTimeStampProgram="//div[2]/table/tbody/tr/td/div/div";
	public String lnkEditPrograms="//div[@id='PatientContactList']/table/tbody/tr/td[2]/div/a";
	public String ajxProgram="program";
	public String txtFromDate="fromDate";
	public String txtToDate="toDate";
	public String txtPrior="priorState";
	public String txtOutCome="outcome";
	public String lnkDeleteProgram="//a[contains(text(),'Delete')]";
	public String ajxReferalSource="referralSourcesuggestBox";
	public String ajxReferedTo="referredTosuggestBox";
	public String txtReferralDate="referralDate";
	public String lblPatientContactList="PatientContactList";
	public String lblArea="css=b";
	public String lblPara="//p";
	public String lblWholeProgram="//div[3]/div/div/div";
	public String lblProgram1="//div[@id='programs']/table/tbody/tr/td/div/div";
	public String lblProgramOnly="//div[@id='programs']/table/tbody/tr/td/div/div/span";
	public String chkIncludeInactive="includeInactiveProgramscheckbox";
	public String txtProgramSearch="xpath=(//input[@id='searchTextBox'])[2]";
	public String btnProgramSearch="xpath=(//button[@type='button'])[4]";
	public String lblProgramPossition="//div[@id='programs']/table/tbody/tr[2]/td/div/div";
	public String lblProgramPossition1="//td[2]/div/div/div/div[3]/div/div";
	public String lblProgramSummary="//div[@class='chart-list-item-main-content']";
	public String lblProgramsummaryOrder="//div[@id='PatientContactList']/table/tbody/tr[2]/td/div";
	public String lnkEditProgrem="//a[contains(text(),'Edit')]";
	public String btnAddProgram = "addProgram"; 
	public String ajxSuggestBoxProg = "suggestBox";
	public String lstItemSelected ="css=div.item-selected";
    public String lstSuggestBoxOracle ="css=div.gwt-PopupPanel.localizedSuggestBoxOracle";


	
	//-----------------------------------------//
	//      Page factoring For Referrals        //
	//-----------------------------------------//
	public String csspathsReferrals[]={"css=#referralTypesuggestBox","css=#referredFromsuggestBox","css=#referredTosuggestBox","referralSpecialtysuggestBox","css=#referralDiagnosessuggestBox","css=#referralReason","css=#referralDate","css=#referralEndDate","css=#referralComments","css=#addAuthorizationButton","css=#delete1","css=#payerSuggestBox1suggestBox","css=#numVisits1","css=#numVisitTypeSuggestBox1suggestBox","css=#requestDate1","css=#approvalDate1","css=#authorizationNum1","id=numAuthorizedVisits1","css=#startDate1","css=#endDate1","css=#cptSuggestBox0-1suggestBox","css=#addCptButton1"};
	public String lnkDeleteReferrals="xpath=//a[contains(@id,'Delete')]";
	public String btnAddReferral="addReferral";
	public String ajxReferralType="referralTypesuggestBox";
	public String ajxReferredBy="referredFromsuggestBox";
	public String ajxReferralSpecial="referralSpecialtysuggestBox";
	public String ajxReferralDiagnoses="referralDiagnosessuggestBox";
	public String txtReferralReason="referralReason";
	public String txtReferralEndDate="referralEndDate";
	public String txtReferralComments="referralComments";
	public String btnAddAuthorization="addAuthorizationButton";
	public String ajxPayer="payerSuggestBox1suggestBox";
	public String ajxNumVisit="numVisitTypeSuggestBox1suggestBox";
	public String txtRequestDate="requestDate1";
	public String txtApprovalDate="approvalDate1";
	public String txtAuthorizationNum="authorizationNum1";
	public String txtNumAuthorizationVisit="numAuthorizedVisits1";
	public String txtStartDate1="startDate1";
	public String txtEndDate1="endDate1";
	public String ajxCPT="cptSuggestBox1-1suggestBox";
	public String lblTimeStampReferral="//td/div/div[2]/div[2]";
	public String lnkEditReferral="//div[@id='ReferralList']/table/tbody/tr/td[2]/div/a";
	public String ajxAddress="addresssuggestBox";
	public String rdGlobal = "//span/input";
	public String rdLocal = "//span[2]/input";
	public String ajxContactSuggestBox  = "contactTypesuggestBox";
	public String txtAddContactCompany  = "addressBookContactCompany";
	public String ajxTitleSuggestBox =  "titlesuggestBox";
	public String txtAddBookLastName = "addressBookLastName";
	public String txtAddBkFirstName = "addressBookFirstName";
	public String txtAddBkMiddleName =  "addressBookMiddleName";
	public String txtJobtitle ="//div[9]/div/input";
	public String txtAddBkDepartment = "addressBookDepartment";
	public String ajxCommTy1suggestBox ="commType1suggestBox";
	public String txtAddBkPrimaryPhone = "addressBookPrimaryPhone";
	public String txtAddBkPrimaryPhoneExt = "addressBookPrimaryPhoneExt";
	public String txtAddBkAdd1 = "addressBookAddressAddr1";
	public String txtAddrBkAdd2 = "addressBookAddressAddr2";
	public String txtAddBkCity ="addressBookAddressCity";
	public String ajxAddBkStateSuggestBox = "addressBookAddressStatesuggestBox";
	public String txtAddBkZipCode = "addressBookAddressZip";
	public String cmbAddBkCountrySuggestBox="addressBookAddressCounty";
	public String btnYesbutton = "yesButton";
	public String ajxaddBkCountrySuggestBox ="addressBookAddressCountrysuggestBox";
	public String txtAddBkEmail = "addressBookEmail";
	public String txtAddBkWebAdd = "addressBookWebAddress";
	public String txtcmt = "comments";
	public String btnAddSave = "addressBookSave";
	public String lblBox=  "//div[@id='adminAddressBookListView']/table/tbody/tr/td/div/div";
	public String lnkDeleteAddressBook="//div[@id='adminAddressBookListView']/table/tbody/tr/td[2]/div/a";
	public String btnAddAddressBook="addNewAddressBookEntry";
	public String btnAuthorization="css=#addAuthorizationButton";
	public String ajxCPT1="cptSuggestBox0-1suggestBox";
	public String vfySummaryReferral = "//span/div/div";
	public String  lnkExpand = "css=#collapsableTitle206 > div.closedArrow";
	public String vfySummaryReferralExpand = "//span/div[2]";
	//------------------------------------------------//
	//      Page factoring For Socio Economics        //
	//------------------------------------------------//
	//	public String csspathsSocioEconomicsCA[]={/*"css=#racesuggestBox",*/"css=#ethnicitysuggestBox","css=#religionsuggestBox","id=citizenshipsuggestBox","css=#countrysuggestBox","css=#spokenLanguagesuggestBox","css=#dateOfArrival","css=#officialLangsuggestBox","css=#languageSpokensuggestBox","css=#interpreterRequiredcheckbox","css=#parentEthnicitysuggestBox","css=#livingArrangementsuggestBox","css=#studentStatussuggestBox","css=#educationLevelsuggestBox","css=#householdIncomesuggestBox","css=#numberOfPeopleSupportedsuggestBox","householdCompositionSuggestBoxId1suggestBox","css=#homelessIndCheckboxcheckbox","css=#povertycheckbox","css=#ruralcheckbox","css=#aboriginalcheckbox","css=#racializedcheckbox","css=#ageGroupsuggestBox","css=#employmentsuggestBox","css=#comments"};
	

	//public String ajxRaceSocio="racesuggestBox";
	public String ajxRaceSocio="raceSuggestBoxId1suggestBox";
	
	public String ajxEthniCity="ethnicitysuggestBox";
	public String ajxReligion="religionsuggestBox";
	public String ajxCitizenship="citizenshipsuggestBox";
	public String ajxCountry="countrysuggestBox";
	public String ajxLanguageSpoken="langSuggestBoxId1suggestBox";
	public String ajxPrefferedLanguage = "preferredLanguageSuggestBoxId1suggestBox";
	public String txtDateOfArrival="dateOfArrival";
	public String ajxSpokenLanguage="langSuggestBoxId1suggestBox";
	public String chkInterupterRequired="interpreterRequiredcheckbox";
	public String txtInterupterName="interpreterName";
	public String ajxParentEthnicity="parentEthnicitysuggestBox";
	public String ajxStudentStatus="studentStatussuggestBox";
	
	public String ajxHouseHoldIncome="householdIncomesuggestBox";
	public String txtPeopleNumber="numberOfPeopleSupportedsuggestBox";
	public String ajxHouseHoldComposition="householdCompositionSuggestBoxId1suggestBox";
	public String chkHouseHoldIndicator="homelessIndCheckboxcheckbox";
	public String ajxHouseLess="homelesssuggestBox";
	public String chkSSI="ssicheckbox";
	public String ajxEmployeement="employmentsuggestBox";
	public String ajxOfficialLanguage="officialLangsuggestBox";
	public String ajxPreferredLanguage="preferredLanguageSuggestBoxId1suggestBox";
	public String btnAddLanguage="addlanguageButtonId";
	public String ajxOtherLanguage="otherLanguageSuggestBoxId2suggestBox";
	public String txtInterupterService="interpreterService";
	public String chkPoverty="povertycheckbox";
	public String ajxAgeGroup="ageGroupsuggestBox";
	public String ajxJobCode="jobCodessuggestBox";
	public String txtReligionOther="religionOther";
	public String txtCitizenshipOther="citizenshipOther";
	public String lblInterupter="interpreter";
	public String txtEducationLevel="educationLevelOther";
	public String txtHouseHold="householdCompositionOther";
	public String chkRural="ruralcheckbox";
	public String chkAboriginal="aboriginalcheckbox";
	public String chkRacialized="racializedcheckbox";
	public String ajxJobCode1="jobCode";
	public String txtOccupation="occupation";
	public String lblCurrentItemSelected="css=div.currentItem.item-selected";
	public String socioEconomic="!patientSocialHistory";
	public String lblTitle="//div[4]/div/div/div[2]/div/div";
	public String lblTitleHouseHold = "//div[@class='chart-header']";
	public String btnEdit="edit";
	public String ajxEducationLevel="educationLevelsuggestBox";
	
	public String csspathsSocioEconomicsCA[]={ajxRaceSocio,ajxEthniCity,ajxReligion,ajxCitizenship,ajxCountry,ajxLanguageSpoken,txtDateOfArrival,ajxSpokenLanguage,chkInterupterRequired,ajxParentEthnicity,ajxLiveArrangements,ajxStudentStatus,ajxEducationLevel,ajxHouseHoldIncome,txtPeopleNumber,ajxHouseHoldComposition,chkHouseHoldIndicator,chkPoverty,"id=ruralcheckbox","id=aboriginalcheckbox","id=racializedcheckbox",ajxAgeGroup,ajxEmployeement,"id=comments"};	
	//------------------------------------------------//
    // Page factoring For Password Rules //
    //----------------------------------------------//
    public String lnkPasswordRules="!adminPasswordRulesShow";
    public String txtPwdLength="minLength";
    public String txtresetsBeforeReuse="resetsBeforeReuse";
    public String txtExpires="expires";
    public String txtfailedAttempts="failedAttempts";

    //	Empty space @ socio economi edit page  //
			public String emptyspaceid="id=editSocioEconomicData";

    
    //------------------------------------------------//
    // Page factoring For Protablity Medication //
    //----------------------------------------------//
    public String lnkMedication= "medicationSummaryWidget";
    public String btnPREdit= "css=button.gwt-Button";
    public String btnEditMedication="//a[contains(text(),'Edit')]";
    public String btnDeleteMedication = "//a[contains(text(),'Delete')]";
    public String btnSaveMedication="saveReason";
    public String txtdeleteReason= "writtenReason";
    
    
	//--------------------------------------------------------//
	//      Page factoring For Unfinished item      		//
	//--------------------------------------------------------//
	public String lnkDeleteUnfinishedItem="//div[@id='unfinishedItemMenuID']/div[2]/ul/li/div/div[4]/a";
	public String btnYesUnfinishedItem= "link=Yes";
	public String btnDeleteNoUnfinishedItem= "link=No";
	public String lnkUnfinishedItemOpenArrow="css=#unfinishedItemMenuID > div.menu-arrow.menu-opened";
	public String lnkUnfinishedItem= "//div[@id='unfinishedItemMenuID']/a";
	public String lnkContinueUnfinishedItem="link=Continue";
	public String lnkCancelUnfinishedItem="link=Cancel";
	public String lnkFirstUnfinishedItem="css=div.unfinished-item-name";
	public String lnkShowMoreUnfinishedItem="css=li.showMoreUnfinishedItems";
	public String lnkOpenUnfinishedItem="link=Open Unfinished Item";

	public String lnkLocationHeader= "locationMenuHeader";
	
	//--------------------------------------------------------//
	//      Page factoring For Payers     		//
	//--------------------------------------------------------//
	public String btnPayerList ="!patientPayersList";
	public String btnDeletePayer="//a[contains(text(),'Delete')]";
	public String btnEditPayer="//a[contains(text(),'Edit')]";
	public String btnActivate="xpath=(//a[contains(text(),'Activate')])";
	public String vfyPayerDetailsExpand = "visitListItem1";
	public String lnkViewDetails1 = "viewFailedDetailsAnchor1";
	public String lnkViewDetailsFailed = "viewFailedDetailsAnchor1";
	public String lnkViewDetailsPassed = "viewPassedDetailsAnchor1";
	public String btnPatientMedicalPayers= "medicalPayers";
	public String btnPatientOtherPayers= "otherPayers";
	public String btnAddNewOtherPayer="addNewOtherPayerButton";
	public String btnlnkSaveEligiblity="xpath=(//a[contains(text(),'Save')])[3]";
	public String btnDeleteForNotes="xapth=(//a[contains(text(),'Delete')])[%s]";
	public String btnDeleteForNotes1="xpath=(//a[contains(text(),'Delete')])";
	public String btnAddNew ="addNewMedicalPayerButton";
	public String btnAddOtherNew="css=#addNewOtherPayerButton > div.add-button";
	public String btnAddNewForOtherPayer= "addNewOtherPayerButton";
	public String ajxPayerSelect ="payerSearchSuggestBoxsuggestBox";
	public String ajxOtherpayerSelect = "payerSearchSuggestBoxsuggestBox";
	public String ajxOtherPayerRelationShip = "subscriberRelationshipSuggestBoxsuggestBox";
	public String ajxRelationShip ="subscriberRelationshipSuggestBoxsuggestBox";
	public String txtPayerStartDate ="startDate";
	//public String txtPayerEndDate="endDate";
	public String txtOtherPayerStartDate = "startDate";
	public String txtPayerEndDate ="xpath=//label[contains(text(),'End Date')]/parent::div/following-sibling::div/input";
	public String txtPayerEndDateOther ="//input[starts-with(@id, 'endDate')]";

	public String txtOtherpayerMemberID = "memberId";
	public String txtOtherPayerGroupNoID="groupNumberId";
	public String txtOtherPayerGroupNameId="groupNameId";

	public String txtOterPayerBillingAddr1="billingAddr1";
	public String txtOterPayerBillingAddr2="billingAddr2";
	public String txtotherpayerBillingCity="billingCity"; 
	public String txtOtherbillingZip="billingZip";
	public String ajxotherBillingStateSuggestBox="billingStateSuggestBoxsuggestBox";
	public String ajxOtherpayerBillingCountrySuggestBox="billingCountrySuggestBoxsuggestBox";
	public String OtherRelationship="subscriberRelationshipSuggestBoxsuggestBox";
	public String lnkotherPayerDel="css=div.chart-list-item-right-wrapper > a.inline-delete-button";
	public String btnEditOther="editAnchor0";
	public String vfyEditPatientInfo1  = "//form/div/div";	
	
	public String txtRelationDob ="//input[starts-with(@id, 'dob')]";
	public String btnEditMedicalPayer="xpath=(//*[contains(@id,'editAnchor')])[1]";
	public String btnEditOtherPayer="editAnchor0";
	public String txtCoPay = "coPayDollarsId"; 
	public String txtSpecialistCoPay = "specialistCopayDollars";
	public String txtDeductible = "deductibleDollars";
	public String txtCoInsurance = "coInsurancePercentage";
	
	
	public String txtPayerNewSeriesEndDate ="xpath=(//input[@type='text'])[5]";
	
	public String txtMemberID = "memberId";
	public String txtGroupNoID = "groupNumberId";
	public String txtGroupNameID = "groupNameId";
	
	public String btnlnkChangeBillingOrder = "link=Change Billing Order";
	public String btnlnkSave = "link=Save";
	public String btnOtherPayersSave="xpath=(//a[contains(text(),'Save')])[4]";
	public String btnlnkCancel = "link=Cancel";
	public String btnlnkCancel1 = "xpath=(//a[contains(text(),'Cancel')])[2]";
	public String btnlnkCancel2 = "xpath=(//a[contains(text(),'Cancel')])[3]";
	
	public String btnlnkNewDateSave = "//div[3]/div/div[2]/a";
	
	public String btnlnkAddAnother =  "link=Save and add another";
	public String btnOK = "okButton";
	public String txtBillingAddr1 ="billingAddr1";
	public String txtBillingAddr2 ="billingAddr2";
	public String txtBillingCity ="billingCity";
	public String ajxBillingCountrySuggestBox ="billingCountrySuggestBoxsuggestBox";
	public String txtRelationFirstName="firstNameId";
	public String txtRelationLastName="lastNameId";
    public String txtOtherRelationLastName="xpath=(//input[@id='lastNameId'])[2]";

	public String txtBillingZip ="billingZip";
	public String ajxBillingStateSuggestBox ="billingStateSuggestBoxsuggestBox";
	public String ajxTypeOfCoverageSuggest ="typeOfCoverageSuggestBoxsuggestBox";
	public String ajxReleaseOfInformatiom ="releaseOfInformationSuggestBoxsuggestBox";
	
	public String ajxListPatientForPayers="xpath=(//li[contains(@id, 'li')])";
	

	public String txtExceptionCodes ="exceptionCodesId";
	public String txtSequenceNumberId ="sequenceNumberId";
	public String chkbxExcemptFromCopay="excemptFromCopayIdcheckbox";
	public String  ajxSecondaryReason="secondaryReasonSuggestBoxsuggestBox";
	
	
	public String chkBoxOutOfNetworkBenefit ="outOfNetworkBenefitsIdcheckbox";
	public String chkBoxauthorizationRequired ="authorizationRequiredIdcheckbox";
	public String chkBoxAcceptAssignment ="acceptAssignmentIdcheckbox";
	
	public String lnkViewCard = "link=View card";
	public String lnkPayerDel ="link=Delete";
	public String lnkPayerDel1 ="//a[contains(text(),'Delete')]";
	public String lnkDelOtherPayer="//div[@id='patientOtherPayer']//a[contains(text(),'Delete')]";
	public String lnkDelOtherPayerCommon ="xpath=(//div[@id='patientOtherPayer']//a[contains(text(),'Delete')])[%d]";
	public String lnkOtherPayerDel="css=div.chart-list-item-right-wrapper > a.inline-delete-button";
	
	
	public String vfyPayerDetails = "leftPanel0";
	public String vfyPayerDetails2 = "//div[2]/div[2]/div[2]/div";
	 public String vfyPayerDetails1 = "//div[3]/div/div/div[4]";
	 

	public String vfyMedPayerDetails = "visitListItem1";
	public String vfyCurrentPayerDetails = "//div[3]/div/div/div/div[3]/div/div/div";
	
	public String vfyExpiredSeries = "//div[3]/div[2]/div/div";
	public String vfyExpiredSeries1 = "//div[3]/div[2]/div[2]/div[2]/div";
	public String vfyExpiredSeries2 = "//div[3]/div[2]/div[2]/div[2]/div[2]";
	public String vfyExpiredSeries3 = "//td[2]/div/div/div/div/div/div[3]/div/div/div/div[3]/div[2]/div/div";

	
	public String vfyEndDateExpiredSeries = "//div[3]/div[3]/div";
	public String vfyEndDatePayerName = "//div[3]/div[3]/div[2]/div[2]/div/div";
	public String vfyEndDatePayerName1 = "//div[3]/div[3]/div[2]/div[2]/div[2]/div/div/div/div";
	
	
	
	public String lblPayerTimeStamp = "//div[5]/div[6]";
	public String ajxPlanName = "link=Select Plan";
	
	public String ajxSearchType = "css=input.show-filter-pick-list.show-filter-pick-list-readonly";
	
	public String lnkPreviousPayer = "link=previous patient payer";
	public String lnkDifferentPayer = "link=different patient";
	public String lnkSelectPayer = "link=Select Payer";
	public String lnkPayerCount = "//div[@class='pick-list-wrapper payerSelectWrapper left-button-spacer inlineBlock']/div/div/div";
	public String searchPatientBox ="xpath=(//input[@id='searchPatientBox'])[2]";
	public String lnkPatientPayerResult = "css=div.patientItem";
	
	public String btnCheckEligibility = "link=Check Eligibility";
	public String ajxEligibilityStatus = "passFailedStatus";
	public String ajxPassedStatus = "link=Passed";
	
	public String ajxFailedStatus = "link=Failed";
	public String lnkViewDetails = "link=View Details";
	public String popupViewDetails = "//div[5]/div[4]/div";
	
	public String txtComment = "css=textarea.text-area";
	public String vfyCheckEligibility  = "css=div.visits-list-item-status";
		
	
	public String  btnChangeBillingOrder = "link=Change Billing Order";
	public String  btnSaveWithNewDates = "link=Save with new date(s)";
	
	public String  dragSource =    "//table[@class='paddingBottom80 fullWidth dragdrop-dropTarget']/tbody/tr/td/div/div/div/div/div/span/span";
	public String  dragDestination =  "//table[@class='paddingBottom80 fullWidth dragdrop-dropTarget']/tbody/tr[2]/td/div/div/div/div/div/span/span";
	
	public String  txtRelationAddr1 =  "addr1";
	public String txtOtherRelationAddr1="xpath=(//input[@id='addr1'])[2]";
	public String  txtRelationAddr2 =  "addr2";
	public String txtOtherRelationAddr2="xpath=(//input[@id='addr2'])[2]";
	public String  ajxRelationState =  "stateSuggestBoxsuggestBox";
	public String  ajxRelationcountry =  "countrySuggestBoxsuggestBox";
	public String  ajxRelationSex =  "sexSuggestBoxsuggestBox";
	
	public String  txtRelationDobOther =  "//input[starts-with(@id, 'dob')]";	
	public String  txtRelationDobMedical =  "xpath=(//input[@type='text'])[33]";	
	public String txtSpecialistCopayOther="xpath=(//input[starts-with(@id, 'coPayDollarsId')])[2]";

	public String txtDeductibleother="xpath=(//input[starts-with(@id, 'coPayDollarsId')])[3]";
	public String txtCoInsuranceother="xpath=(//input[starts-with(@id, 'coPayDollarsId')])[4]";
	//public String ajxotherBillingStateSuggestBox="xpath=(//input[@id='billingStateSuggestBoxsuggestBox'])[2]";
	
	
	public String  txtRelationZip =  "zip";
	
	public String vfyEditPatientInfo  = "//form/div/div[2]";	
	

	public String lblPatientInfo="usPanelDiv";
	public String lnkBillingHistory="link=Billing history";
	public String lnkBillingSummary="!billingSummaryHistory";
	public String lnkChargeHistory="!billingChargesHistory";
	public String lnkPaymentHistory="!billingPaymentsHistory";
	public String lnkStatementHistory="!billingStatementsHistory";
	public String lnkPayerHistory="!billingPayersHistory";
	public String lnkVisitHistory="!billingVisitHistory";
	public String lnkPersonalHistory="!billingPersonalHistory";
	public String lnkReferralsHistory="!billingReferralsHistory";
	public String lblgender="female";
	public String lbldob="01/19/1966";
	public String lblAddress="789 Memory Lane, Bakersfield CA 93309";
	public String lblContactNumber="(661) 123-1234";
	
	
	//--------------------------------------------------------//
	//      Page factoring For Front Office Home page     		//
	//--------------------------------------------------------//

	public String btnAppointmentCout ="//div[2]/div[2]";
	public String lblAppointment ="//div[@id='printInfo']/div/div/div[3]/div/div[2]/div";
	public String txtResource ="addResources";

	public String lblCenterFrontdesk ="//div[@id='printInfo']/div/div/div[3]/div/div[2]/div";
	public String lblNeedsAction ="//div[@id='printInfo']/div/div/div[3]/div/div";
	public String txtSearchResources ="searchResources";
	public String lnkResource ="xpath=(//a[contains(text(),'ABBY ABRAHAM')])[2]";
	public String lnkViewCalender = "css=button.secondary-button";
	public String lnkCurrentVIew = "link=Set current view as My View";
	public String lnkViewCalender1 = "viewCalendar";
	public String lnkAddResource ="link=Add Resource to this view";
	public String btnNexiaLogo ="css=a.float-left.header-bar-logo";
	
	//Task
	public String backbtn= "back";
	public String lnkTask = "Tasks";
	public String lnkTaskNotification = "TaskNotifications";
	public String lnkCreateGeneralTsk = "newGeneralTaskAction";
	
	//Create General Task
	public String txtTaskName = "instructionsTextBox";
	public String txtInstructions = "instructionsTextBoxId";
	public String txtReassignReason = "css=textarea.width320px";
	public String ajxDueIn = "timeCountSuggestBoxsuggestBox";
	public String ajxAssignUser = "assignToSuggestBoxsuggestBox";
	public String chkUrgentBox = "urgentTaskcheckbox";
	public String ajxNotifyMe = "xpath=(//input[@id='timeCountSuggestBoxsuggestBox'])[2]";
	public String ajxNotifyMeFormat ="notifyMeInTimeUnitSuggestBoxsuggestBox";
	public String lnkMoreOptions = "link=More options";
	public String btnSaveTask = "saveID";
	public String btnEditCancel = "cancelID";
	public String ajxDueInUnit = "dueInTimeUnitSuggestBoxsuggestBox";
	public String ajxNotifyMeUnit ="notifyMeInTimeUnitSuggestBoxsuggestBox";
	public String chkAssignTo = "assignToFromcheckbox";
	public String ajxSelectAssignUser = "selectUserSuggestBoxsuggestBox";
	public String chkSaveToQuickList = "saveListcheckbox";
	public String btnQuickList = "instructionsTextButton";
	public String vfyQuickList = "css=div.quickListSuggestBoxOracle";
	public String vfyTaskDetails = "css=div.task-notification.split-chart-position-wrapper";
	
	//Recurring
	public String chkRecurring = "recurringcheckbox";
	public String txtOccurences = "xpath=(//input[@type='text'])[15]";
	public String rdoRecurringEnd = "dateradio";
    public String rdoRecurringDaily = "dailyradio";
    public String rdoRecurringWeekly = "weeklyradio";
    public String rdoRecurringMonthly = "monthlyradio";
    public String rdoRecurringDayofMonth = "dayOfMonthradio";
    public String rdoRecurringWeekOfMonth = "weekOfMonthradio";
    public String txtRecurringDayofMonth = "dateOfMonthSuggestBoxsuggestBox";
    public String txtRecurringMonthlyQualifier = "recurringMonthlyQualifierSuggestBoxsuggestBox";
    public String txtRecurringDaySelection = "daySelectionSuggestBoxsuggestBox";
    public String txtDailyDate = "//div[3]/div/div/input";
    public String txtWeeklyDate = "//div[3]/div/div/input";
    public String txtRecurringEnd = "xpath=(//input[@type='text'])[16]";
    public String ajxPractice = "selectPracticeSuggestBoxsuggestBox";
	
	//Queue
    
    public String lblBumpList = "Patientsonbumplist";
    public String lblWaitList = "Patientsonwaitlist";
    public String lblUnconfirmedvisits ="Unconfirmedvisits";
    public String lnkHide ="SlideWindowHideAnchor";
    public String lnkHelp ="helpIcon";
    public String lnkHowToUse = "//div[@class='marginTop10 help-about-menu']/div[2]/a";

	
    public String lblPatientSearchResults ="//div[3]/div/div/div/div[2]/div/div/div/div";
    
    public String lnkUpdateDemographics ="link=Update demographics";
    
    
//Patient Search
    
    public String lnkSystemSettin="css=#systemSettingsAction > span.actionItemSpan";
    public String lnkPatientRes="//td[2]/div/div/span[2]";
    public String chkIncludeInactiveBox="includeInactivescheckbox";
    public String lblPatientid="//td[2]/div/div[3]/span";
    
    public String btnNavArrowDown="css=button.searchArrowDown";
    public String btnNavArrowUP="css=button.searchArrowUp";
    public String lblPatSearch="//div[4]/div/div/table/tbody/tr/td[2]/div/div[3]/span";
    public String lblPatSearch1="//div[3]/span";
    public String lblPatSearch2="//td[2]/div/div[3]/span";
    public String lnkYes="link=Yes";
    public String vfyMedPayer = "xpath=(//div[contains(@id,'visitListItemDiv')])[5]";
    //Fo
    
    public String lblResource= "//div[4]/div/div/div[2]/div/div/div/a";
    public String lnkAdd="link=Add";
    public String lnkSetCurrentView="link=Set current view as My View";
    public String lblTopMenu="//div[5]/div/div";
    public String lnkHelp1="css=h1";
    public String lnkSearchClose="css=a.searchClose";
    
    public String vfyCurrentPayerDetails1 = "//div[3]/div/div/div/span";

    public String vfyExpiredSeries4 = "//div[3]/div/div/div/div[2]/div[3]/div[2]/div/div";

    public String vfyEndDateExpiredSeries1 = "//div[3]/div[3]/div/div";
    public String vfyFirstPayer = "//div[contains(@id,'visitListItem')]";
	public String txtOtherCoPay = "xpath=(//input[@id='coPayDollarsId'])[1]"; 
	public String txtSpecialistotherCoPay = "xpath=(//input[@id='coPayDollarsId'])[2]";
	public String txtOtherDeductible = "xpath=(//input[@id='coPayDollarsId'])[3]";
	public String txtOtherCoInsurance = "xpath=(//input[@id='coPayDollarsId'])[4]";
    
    //Home Page
    public String lblUnmatchedRecord = "Unmatched Patient Records";
    public String lblBumpListRecord = "Patients on bump list";
    public String lblwailtList= "Patients on wait list";
    public String lblUnConfirmed = "Unconfirmed visits";
    public String csspathsSocioEconomics[]={ajxRaceSocio,ajxEthniCity,ajxReligion,ajxCitizenship,ajxCountry,ajxLanguageSpoken,txtDateOfArrival,ajxSpokenLanguage,chkInterupterRequired,ajxParentEthnicity,"id=livingArrangementsuggestBox",ajxStudentStatus,ajxEducationLevel,ajxHouseHoldIncome,txtPeopleNumber,ajxHouseHoldComposition,chkHouseHoldIndicator,ajxEmployeement,"id=comments"};

}
