package com.nexia.selenium.genericlibrary.schedulingsettings;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;

import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.nexia.selenium.genericlibrary.operations.OperationsTestLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.sharedlibrary.AbstractTest;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.seleniumemulation.JavascriptLibrary;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractSchedulingTest extends AbstractTest{
	
	// Test Commit
	//public By chkbxIncludeInactive = By.linkText("includeInactiveTemplatescheckbox");
	//public By chkProvider = By.xpath("//input[contains(@id,'checkbox')]");

	//Quick Action
	public String chkbxIncludeInactive = "includeInactiveTemplatescheckbox";
	public String chkProvider = "//input[contains(@id,'checkbox')]";
	public String classQuickLink = "footer-menu-quick-actions";
	
	public String lnkSystemSetting = "systemSettingsAction";	
	public String lnkSchedulingSetting="schedulingSettingsAction";	
	public String lnkAdminOrgStructureLists = "!adminOrgStructureLists";
	
	public String lnkOrgStructures="!adminOrgStructureLists";
	public String lblProviderCount = "providerCount";
	public String showMoreBtn="VisitTypeListMoreLink";
	public String txtLastname="lastName";
	public String txtFirstname="firstName";
	public String txtUsername="userName";
	public String txtMaxmum="maximumFTESuggestBoxsuggestBox";
	
	public String ajxProvider = "providerListSuggestBoxsuggestBox";
	
	public String txtProviderWD = "searchTextBoxProviderView";
	public String btnSearchProviderWD = "searchButtonProviderView";
	public String lblProviderNameWD = "//div[contains(@id,'providerListItem')]";
	public String lnkDeleteProviderWD = "//a[contains(@id,'DeleteProvider')]";
	public String txtSearchProvider = "practiceProvidersearchTextBox";
	public String btnSearchProvider = "practiceProvidersearchButton";
	
	
	
	public String lblAutomationNexia = "practiceListItemTitle10";
	
	//Record Attendance
	public String btnAddVisitGroup ="link=Add new";
	public String lnkRecordAttendance= "recordAttendanceAction";
	public String lblRecordAttendanceSummary= "attendanceGroupList";
	public String lblFirstRecordAttendance= "//div[@id='attendanceGroupList']/table/tbody/tr[1]";
	public String lnkFirstRecordAttendance="//div[@id='attendanceGroupList']/table/tbody/tr[1]/td[2]/div/div";
	public String txtSearchAttendanceGroupBox= "searchAttendanceGroupBox";
	public String ajxAttendanceOrderTypesuggestBox= "attendanceOrderTypesuggestBox";
	public String btnCancelRecordAttendance = "recordAttendanceCancelButton";
	public String btnCancelAttendanceGroup="attendanceGroupCancelButton";
	public String btnSaveAttendanceGroup ="attendanceGroupSaveButton";
	public String lblNeedAction= "css=div.dashboardActionCategory";
	public String btnUpdateParticipant="css=div.add-button";
	public String lblAttendanceGroupSummary= "attendanceGroupContents";
	public String btnAddUpdateParticipants="updateParticipantSaveButton";
	public String lnkNextWeek="css=span.next-arrow";
	public String lnkPreviousWeek="css=span.prev-arrow";
	public String lblDateShow="attendanceGroupNaviWeekDays";
	public String lblFirstRecordGroupParticipantName="//div[@id='attendanceGroupContents']/div[4]/div/div/div/div/div/div";
	public String txtstartDate="startDate";
	public String lblStartDateFeature="startDateDate2";
	public String lblStartDatePast="startDateDate5";
	public String lblAttenSundayFirstRecordGroupParticipantName="//div[@id='attendanceGroupContents']/div[4]/div/div/div/div/div/div[2]/div/a";
	public String lblAttenMondayFirstRecordGroupParticipantName="//div[@id='attendanceGroupContents']/div[4]/div/div/div/div/div/div[3]/div/a";
	public String lblToolTipMondayFirstRecordGroupParticipantName="//div[@id='attendanceGroupContents']/div[4]/div/div/div/div/div/div[3]/div/div[2]";
	public String chkCenterClosedMonday="1checkboxsingleSelection";
	public String lnkSaveMondayAttendanceAbsent="xpath=(//a[@id='singleSelectionWidgetCloseButton'])[2]";
	public String chkConsents ="consentsEnabledcheckbox";
    public String ajxConsentsReason ="consentsBox0suggestBox";
	//Quick Action
 // FIXME #VEL-5892
 	public String lnkShowMoreLink="css=a.dropdown-item.show-more > span";
	public String lnkQuickAction= "link=Quick Actions";
	public String lnkOperations = "operationsAction";
	public String lnkScheduling = "schedulingSettingsAction";
	public String rdoAllLocation = "//div[2]/span/span/input";  
    public String rdoSelectedLocation = "//div[2]/span[1]/span/input ";  
    public String txtSearchLocation = "locationsBox0suggestBox";
    public String btnSummaryBack = "back";
    public String lnkExpandDetails = "css=div.visits-list-item-main-content";
    
	//Non Provider Resource 
	
	public String lnkNonProviderResource = "!schedulingSettingsNonProviderResourcesRoomsList";
	public String lnkNonProviderResourceEquipment = "!schedulingSettingsNonProviderResourcesEquipmentList";
	public String lnkNonProviderResourceSupportStaff = "!schedulingSettingsNonProviderResourcesSupportStaffList";
	public String btnAddNonProviderResource = "nonProviderAdd";
	public String lnkDeleteNonProviderResource="xpath=(//a[contains(text(),'Delete')])[1]";
	public String btnDeleteNPR="//a[contains(text(),'Delete')]";
	public String txtSearchNonProviderResource = "searchNonProviderBox";
	public String txtRoomName = "roomName";
	public String txtSupportStaffName = "staffName";
	public String ajxlocation = "locationListSuggestBoxsuggestBox";
	public String btnSaveNonProviderResource = "link=Save";
	public String lblSummaryPageNonProviderResourceRoom = "NonProviderResourcesRoomsListWidget";
	public String lblSummaryNonProviderResource = "//div[@id='NonProviderResourcesRoomsListWidget']/table/tbody/tr/td";
	public String lblNonProvider = "//div[@id='NonProviderResourcesRoomsListWidget']/table/tbody/tr/td";
	public String rdoMobilityNonProviderEquipMultiLocation = "multiLocationsradio";
	public String  rdoMobilityNonProviderEquipStationary = "stationaryradio";
	public String chkIncludeInactiveCheckboxNPR  = "includeInactivecheckbox" ;
	public String lnkShowMoreNPRR="NonProviderResourcesRoomsListWidgetMoreLink";
	public String lblRooms = "//a[starts-with(text(),'Rooms')]";
	public String lblNPRDetails = "//div[@id='printInfo']/div/div/div/div[2]/div[3]/div/div/div/div[2]/div/div/div[2]/table/tbody/tr/td";
	public String activateLink="link=Activate";
	
	// Resource Groups
	
	public String lnkResourceGroup = "!schedulingSettingsResourceGroupsList";
	public String btnAddResourceGroup = "addResourceGroup";
	public String btnSaveResourceGroup = "updateResourceGroup";
	public String txtResourceGroupName = "resourceGroupName";
	public String lblSummaryPageResourceGroup = "ResourceGroupsListWidget";
	public String showMore = "ResourceGroupsListWidgetMoreLink";
	public String lnkDeleteResourceGroup = "//div[@id='ResourceGroupsListWidget']/table/tbody/tr/td[3]/div/a";
	public String btnSearchResources = "search";
	public String chkSelectAllResources = "selectAllcheckbox";
	public String txtSearchResources = "resourceSearchBox";
	public String txtSearchResourceGroup = "searchResourceGroupsBox";
	public String lnkCalendar ="schedulingSettingsAction";
	public String lblSummaryResourceGroup = "//div[@id='ResourceGroupsListWidget']/table/tbody/tr[2]/td";
	public String lblResourceGroup = "//div[@id='ResourceGroupsListWidget']/table/tbody/tr/td/div/span/div";
	
	//Visit Type
	public String csspathsNotes[]={"css=#visitTypeName","css=#durationMinutes","css=#cannotRepeatBefore","//button[@type='button']","css=#isBillablecheckbox","css=#isAllowMultipleBookingscheckbox","css=#visitModelBoxsuggestBox"};
	public String activeElementInPage="dom=document.activeElement";

	public String lnkVisitType="!schedulingSettingsVisitTypesList";
	public String lnkColorStrip="//tr[2]/td/div/span/div/div/span"+"@style";
	public String lnkVisitMoreOption = "link=More Options";
	public String lnkHideOption="link=Hide Options";
	public String lnkEdit="link=Edit";
	public String lnkActivate="link=Activate";
	public String lnkAddMore="link=Add more";
	public String btnAdd="link=Add New";
	public String btnAddClass="add-button";
	public String btnAddNew="add";
	
	public String btnAddParticipant="addNewButton";
	public String btnAddStaff1="addButtonDiv";
	public String btnDelete="//a[contains(text(),'Delete')]";
	public String btnEdit="//a[contains(text(),'Edit')]";
	public String btnEdit2="edit";
	public String btnSave="link=Save";
	public String btnSave2="save";
	public String btnCancel="link=Cancel";
	public String btnSaveAdd="link=Save and add another";
	public String btnSaveAdd1="link=Save And Add Another";
	public String chkVisitInclude = "//div[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div/div[3]/div/div/div[3]/span/input";
									
	//public String btnSaveAdd="//a[contains(text(),'Save and add another')]";
	public String btnCustom="//button[@type='button']";
	public String txtvisitType="visitTypeName";
	public String txtduration="durationMinutes";
	public String txtCannotRepeat="cannotRepeatBefore";
	public String txtlimitMultiple="limitMultipleBookingsDays";
	public String txtFollow="followUpNumberOfTimeUnits";
	public String txtConfirmationDay="confirmationDays";
	public String txtBookInstruction="bookingInstructions";
	public String txtPatientInstruction="patientInstructions";
	public String txtSearchType="searchVisitTypeBox";
	public String txtLocation1="locationsBox0suggestBox";
	public String txtLocation2="locationBox1suggestBox";
	public String chkFollowUpVisit="visitTypeFollowUpcheckbox";
	public String chkConfirmVisit="visitTypeConfirmcheckbox";
	public String chkAllowMultiple="isAllowMultipleBookingscheckbox";
	public String chklimit="limitToradio";
	public String chkUnLimted="unlimitedradio";
	public String chkColor="//span/div/div/div[5]";
	public String chkcolor1="//tr[1]/td[11]/div";
	public String chkInclude="//span/input";
	public String chkAllow="//div[2]/span/span/input";
	public String chkSelect="//div[2]/span[2]/span/input";
	public String chkSelectedLocations = "//div[2]/span[2]/span/input";
	public String ajxFollowUp="followUpTimeUnitsBoxsuggestBox";
	public String ajxVisitModel="visitModelBoxsuggestBox";
	public String ajxVisitGroup="visitTypeGroupBoxsuggestBox";
	public String lblSummaryVisitDetails="//div[@id='VisitTypeList']/table/tbody/tr/td/div/div";
	public String lblSummaryVisitDetails1="//div[@id='VisitTypeList']/table/tbody/tr/td/div/div/span[2]";
	public String lblcolor="//div[@id='VisitTypeList']/table/tbody/tr/td/div/div/span/";
	public String chkIncludeInactiveVisitType = "//span/input";
	public String lblRedColour = "//div[contains(text(),'Color')]/following-sibling::div/div/table/tbody/tr/td/span/div/div/div";
	public String lblPinkColour ="//div[contains(text(),'Color')]/following-sibling::div/div/table/tbody/tr/td/span/div/div/div[9]";
	public String lblYellowColour = "//div[contains(text(),'Color')]/following-sibling::div/div/table/tbody/tr/td/span/div/div/div[3]";
	public String lblDarkBlueColour = "//div[contains(text(),'Color')]/following-sibling::div/div/table/tbody/tr/td/span/div/div/div[8]";
	public String lblLightBlueColour = "//div[contains(text(),'Color')]/following-sibling::div/div/table/tbody/tr/td/span/div/div/div[5]";
	//ResourceCalender
	
	//public String btnActivate="//a[contains(text(),'Activate')]";
	public String btnActivate="Activate1";
	public String lblDisplayRow="displayRowDiv";
	public String btnLocationNext="locationNextButton";
    public String lnkResourceCalender = "!schedulingSettingsResourceCalendarsList";
    public String lnkResourceCalenderViewDetails = "link=View details";
    public String  txtSearchResourceCal=  "searchResourceCalTextBox";
    public String  txtBlockReason= "blockReason";
    public String btnNextInGroup="//a[@id='seriesBackButton']/div";
    
    //FIXME MNT-1506
    public String lblBlockTime = "//div[5]/div/div/div[2]/div[2]/div";
    public String lblDeleteTime = "//div[2]/div[3]/div";
    
    
    public String  ajxResCalOwnerBoxsuggestBox = "resCalOwnerBoxsuggestBox";
    public String  ajxLocationSuggestBox = "suggestBox";
    public String  ajxvisitLocationsuggestBox = "visitLocationBoxsuggestBox";
    public String  ajxvisitTypesuggestBox = "visitTypeOrGroupBoxsuggestBox";
    public String  ajxrunningMonthsBoxsuggestBox = "runningMonths";
    public String  txtMaxBooking = "maxBookings"; 
    public String  txtStartTimehour = "setupStartTime-hour";
    public String  txtEndTimehour = "setupEndTime-hour";
    public String  ajxTimeSuggestBox = "setupEndTime-ampmsuggestBox";
    public String  ajxPMSelection = "currentItem_2";
    public String  btnAppointmentSave = "setupSaveButton";
    public String  btnAppointmentSave2 = "saveButton";    
    public String  txtResCalEffectiveDate = "resCalEffectiveDate";
    public String  txtResCalEndDate = "resCalEndDate";
    public String  btnresCalSave = "resCalSave";
    public String  lnkStartBlank = "startBlank";
    public String  txtPatternEndDate = "patternEndDate";
    public String  coordinateNoon = "x0y10";
    public String  txtPatternStartDayBoxsuggestBox = "patternStartDayBoxsuggestBox";
    public String  txtPatternStartMonthBoxsuggestBox =  "patternStartMonthBoxsuggestBox";
    public String  rdEndsBeforeNext= "endsBeforeNextradio";
    public String  rdEndsOnDateradio = "endsOnDateradio";
    public String  chkNoEndDatecheckbox = "noEndDatecheckbox";
    public String  chkIncludeInactiveCheckbox ="includeInactiveTemplatescheckbox";
    public String  lnkResourceAddNew="link=Add new";
    public String  lnkResourceCalendarDel = "//div[@id='ResourceCalendarsList']/table/tbody/tr/td[4]/div/a";
    public String  lnkResourceCalendarDetials1 = "//div[@id='ResourceCalendarsList']/table/tbody/tr/td/div";
    public String  lnkResourceCalendarDetails ="calendarContainer";
    public String  lnkResourceCalendarDetials2 = "//td[2]/div/div/div/div[3]/div/div[2]/table/tbody/tr/td";
    public String  lblResourceCalendarDetials = "//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr/td[2]";
  
    public String  lblResourceCalendarDetials1 = "//div[@id='ResourceCalendarsList']/table/tbody/tr/td";
    public String  tabResCalOwnerBoxsuggestBox = "css=#resCalOwnerBoxsuggestBox";
    public String  tabRunningMonthsBoxsuggestBox = "css=#runningMonths";
    public String  tabResCalEffectiveDate = "css=#resCalEffectiveDate";
    public String  tabResCalEndDate = "css=#resCalEndDate";
    
    public String  lnkResourceCalendarPattern1 = "//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr/td[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[6]";
    public String  lnkResourceCalendarPattern2 = "//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr/td[2]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[3]/div/div/div[7]";
    public String  vfyStorevaluePattern = "//td[2]/div/div/div/div[3]/div/div[2]/div/div";
    public String  vfyStorevaluePattern1 = "//td[2]/div/div/div/div[3]/div/div[2]/div[2]/div";
    public String  vfyStorevaluePattern2 =  "//div[3]/div/div[2]/div[3]/div";
     
    public String  curPattern = "";
    
    public String   lnkMarkerPattern1  = "//div[2]/div/div[2]/div/div/div/div[3]/div"; 
    public String lblFirstResourceCalendar="//div[@id='ResourceCalendarsList']/table/tbody/tr";
    public String btnEditRes="resCalEdit";
    
	//CalenderTemplate
	public String lnkCalendarTemplate="!schedulingSettingsCalendarTemplatesList";
	public String btnAddNewCalendarTemplate="//a[@id='calTemplateAdd']/span";
	public String txtTemplateName="calTemplateName";
	public String btnEditNewCalendarTemplate="Edit";
	public String btnSaveCalendarTemplate="calTemplateSave";
	public String lnkDeleteCalendarTemplate="//div[@id='CalendarTemplatesList']/table/tbody/tr/td[4]/div/a";
	public String btnYesButton="yesButton";
	//public String inActiveCheckBox = "includeInactiveTemplatescheckbox";
	public String lblSummaryPageCalendarTemplate="CalendarTemplatesList";
	public String txtSearchCalendarTemplate="searchTemplateTextBox";
	public String chkIncludeInactive="includeInactiveTemplatescheckbox";
	public String lnkActivateCalendarTemplate="link=Activate";
	public String btnPreviewCalendarTemplate="calTemplatePreview"; 
	public String lnkViewDetails="link=View details";
	public String lnkViewDetails2="View details1";
	public String lnkViewDetailsXPath=".//*[contains(@id,'View details')]";
	public String lblViewDetailsSummary="css=div.gwt-HTML";

	//Visit Group
	public String lnkVisitGroup="!schedulingSettingsVisitGroupsList";
	public String txtGroupName="visitGroupName";
	public String txtSearch="SearchBox";
	public String txtSearchGroup="searchResourceGroupsBox";
	public String lblNoVisitTypeFound="noVisitTypeFound";
	public String lblGroupsummary="menuArrow";
	public String lblGroupsummary2="//div[@id='VisitGroupsListWidget']/table/tbody/tr";
	public String btnSearch="link=Search";
	public String chkViistType="//input[starts-with(@id,'gwt-uid')]";
	public String chkCustomColor="//tr[1]/td[11]/div";
	public String chkGroupIncude="includeInactiveTemplatescheckbox";
	public String chkGreenColor="//span/div/div/div[4]";
	public String lblGroupcolor="xpath=(//div[contains(@id,'collapsableTitle')])";
	public String lblVisitName="//div[2]/div[3]/div";
	public String lblGroupsummary1="//div[@id='VisitGroupsListWidget']/table/tbody/tr[2]/td/div/span/div[2]";
	public String csspathsGroup[]={"css=#visitGroupName","css=#SearchBox"};
	public String csspathsGroup1[]={"css=#searchResourceGroupsBox"};

	//Location Hours
	public String lnkTopPracticeMenu="locationMenuHeader";
	public String lnkLocationHours="!schedulingSettingsLocationHoursList";
	public String btnEditLocation=".//*[contains(@id,'Edit')]";
	public String lblLocationHoursDisplay="LocationHoursList";
	public String txtSearchBox="searchTextBox";
	public String btnSearchClose="css=a.searchClose";
	public String btnsaveLocationHours="saveLocationHours";
	public String txtStartHour="defaultStartTime-hour";
	public String txtStartMin="defaultStartTime-mins";
	public String txtEndHour="defaultEndTime-hour";
	public String txtEndMin="defaultEndTime-mins";
	public String lblLocationHours="//td[2]/div/div/div/div[3]/div/div[2]/table/tbody/tr/td";
	public String btncancelLocationHours="cancelLocationHours";
	public String btnallowHolidayBookingcheckbox="allowHolidayBookingcheckbox";
	

	public String chkclosedWeekendscheckbox="closedWeekendscheckbox";
	public String ajxampmSuggestBox1="defaultStartTime-ampmsuggestBox";
	public String ajxampmSuggestBox2="defaultEndTime-ampmsuggestBox";

	public String icnColourYellow="//span/div/div/div[3]";
	public String icnColourBlue="//div[8]";
	public String icnColourRed="//span/div/div/div";
	public String icnColourPink="//div[11]";
	
	public String ajxHourFormatStart="defaultStartTime-ampmsuggestBox";
	public String ajxHourFormatEnd="defaultEndTime-ampmsuggestBox";
	
	public String  chkIncludeInactivescheckbox =  "includeInactivescheckbox";
	public String btnSearchButton="//td[2]/div/div/div/div[2]/div/div/div/div[2]/span/button";
	public String btnSearchTextBox ="searchTextBox";
	public String lblResultPractice="//div[@id='printInfo']/div/div/div[3]/div/div[2]/table/tbody/tr/td[2]/div/div/div/div/div/div/div[3]/div";
	public String chk24HourFormat="use24hourtimecheckbox";
	
	
	//Calendar Preference
	public String lnkCalenderPreference = "!schedulingSettingsPreferencesShow";
	public String ajxDefaultCancellation = "defaultCancellationBoxsuggestBox";
	public String vfyCancellation ="id=defaultCancellationBoxsuggestBox";

	//Patient Option
	public String lnkRegisterPatient = "newPatientAction";
	public String lnkPatientOption = "link=Patient Options";
	public String btnBack="backButton";
	//Register patient
	public String txtLastName = "lastName";
	public String txtFirstName="firstName";
	public String txtDOB="dob";
	public String noDuplicationBtn="notDuplicateButton";
	public String txtPhonNo = "primaryPhone";
	public String txtExtnNo = "primaryPhoneExtension";
	public String chkPremature="prematurecheckbox";
	public String ajxPrematureDuration="prematureDurationSuggestBoxsuggestBox";
	public String ajxPrematureMeasure="prematureMeasureUnitSuggestBoxsuggestBox";
	public String ajxSex="sexSuggestBoxsuggestBox";
	public String ajxStatus="statusSuggestBoxsuggestBox";
	public String ajxPhoneType = "commType1SuggestBoxsuggestBox";
	public String btnSave1="saveButton";
	public String lblPtientId = "patientID";
	
	
	
	//Patient Time Line
	public String lnkPatientTimeLine="!patientTimelineVisits";
	public String lnkViewRegistration = "css=#patientOptionsRegistration > span";
	public String lnkAppoinments = "link=Appointments";
	public String lnkBooking = "!patientTimelineBilling";
	public String lnkContact = "!patientTimelineContact";
	public String lnkAction = "link=Actions";
	public String lnkPatientAction = "//div[3]/div[2]/a";
	public String lnkCancelVisit="//a[@id='cancelVisit']/span";
	public String lnkConfirmVisit = "//a[@id='confirmVisit']/span";
	public String lnkEditVisit = "//a[@id='editVisit']/span";
	public String lnkHideComment = "DEFAULTHideComment";
	public String lblPatientTimeLine = "//div/div[2]/div[2]/div";
	public String lblExpandPatientTimeLine = "//div/div[2]/div[2]";
	public String lblComment = "css=blockquote.commentsBubble";
	public String ajxSearchVisitOrResouce = "css=input.roundedSearchBox";
	public String ajxshowFillter = "suggestBox"; 
	public String ajxOutComePickList = "xpath=(//input[@id='suggestBox'])[2]";
	public String ajxTimeLineVisitStatus = "xpath=(//div[@id='panel']/input)[3]";
	public String ajxTimeLineReferredBy = "xpath=(//div[@id='panel']/input)[4]";
	public String chkAddBumpList = "//div[6]/div/span/input";
	public String txtTimeLineDuration = "//div[4]/div/div[2]/div/input";
	public String txtTimeLineComment= "//div[3]/div/textarea";
	public String txtCancelTextArea = "//div[2]/textarea";
	public String txtTLComment = "DEFAULTCommentBox";
	
	public String imgCommentPopup = "css=a.visits-list-item-comment-anchor";
	public String imgCommentTextPopUp = "//div[4]/div[2]/div/div[2]/div/div";
	public String btnCancelVisitSave = "//span[2]/a";
	public String btnEditVisitSave = "xpath=(//a[contains(text(),'Save')])[3]";
	public String btnDfSave ="DEFAULTSave";
	public String btnDfEdit = "DEFAULTEdit";
	
	//Booking Assist
	public String lnkBookingAssistant = "!schedulingOperationsBookingAssistant";
	public String lnkMore = "link=More";
	public String ajxVisitType = "bassVisitTypeSuggestBoxsuggestBox";
	public String aJxPhoneType= "suggestBox";
	public String imgCalenderSlot = "//div[@id='bassAppointment0']";
	public String lblProvider = "css=div.resource-name";
	public String lblLocation = "//tr[3]/td/div";
	public String txtPatientSearch = "xpath=(//input[@id='searchPatientBox'])[2]";
	public String lblPatient = "css=div.patientItem";
	public String lblvisitDetails = "//div[@id='printInfo']/div/div/div[3]/div/div/div[2]/div";
	public String btnBookSave = "save";
	
	//Program Groups 
	public String lnkProgramGroup = "!schedulingSettingsProgramGroupList";
	public String lnkProgramAction = "//div[contains(@id,'actions')]";
	public String lnkProgramDelete = "//div[text()='Delete']";
	public String lnkProgramEdit = "//div[text()='Edit']";
	public String lnkGroupActivate= "//div[text()='Activate']";
	public String lnkViewSeries = "//div[text()='View all series']";
	public String lnkCopySeries = "viewAllSeriesCopyToNewSeries";
	public String lnkGroupEdit = "//div[text()='Edit']";
	public String lnkXmark = "css=a.close-x";
	
	public String lnkgroupObjective = "groupObjectiveLink";
	public String lnkplannedActivite ="plannedActivitiesLink";
	public String lnkageGroup="ageGroupsLink";
	public String lnkGender = "genderLink";
	public String lnkPrimary = "primaryLanguageLink";
	public String lnkCulture = "cultureLink";
	public String inkRole = "roleIdentityStatusLink";
	public String lnkphysical = "physicalMentalConditionsLink";
	public String lnkSocial="socialDemographicLink";
	public String lnkNo="link=No";
	public String lnkYes= "link=Yes";
	public String lnkCancelNo = " xpath=(//a[contains(text(),'No')])[3]";
	public String ajxProgramType = "programTypeSuggestBoxsuggestBox";
	public String txtgroupName = "groupName";
	public String txtDescription = "description";
	public String txtprogramPlan = "programPlan";
	public String txtPrimary = "searchMultiSelectionBox";
	public String txtCulture = "xpath=(//input[@id='searchMultiSelectionBox'])[6]";
	public String txtSearchProgram= "searchProgramGroupBox";
	public String chkGroupObjective = "1checkboxGroup Objective";
	public String chkPlannedActivities = "1checkboxPlanned activities";
	public String chkAgeGroups = "1checkboxAge Groups";
	public String chkGender = "1checkboxgender";
	public String chkPrimary="1checkboxPrimary Language";
	public String chkCulture = "1checkboxCulture is";
	public String chkRole="1checkboxRole, identity or status";
	public String chkPhysical = "1checkboxPhysical or mental Conditions";
	public String chkSocial="1checkboxSocial demographic";
	//FIXME MNT-1295
	   public String Duplicate="css=div.popupContent";
	public String imgGroubObjective = "multiSelectionCloseButton";
	public String imgPlanClose = "multiSelectionCloseButton";
	public String imgAgeClose = "xpath=(//a[@id='multiSelectionCloseButton'])[3]";
	public String imgGenderClose = "xpath=(//a[@id='multiSelectionCloseButton'])[4]";
	public String imgPrimaryClose = "xpath=(//a[@id='multiSelectionCloseButton'])[5]";
	public String imgCultureClose = "xpath=(//a[@id='multiSelectionCloseButton'])[6]";
	public String imgRoleClose = "xpath=(//a[@id='multiSelectionCloseButton'])[7]";
	public String imgPhysicalClose="xpath=(//a[@id='multiSelectionCloseButton'])[8]";
	public String imgSocialClose = "xpath=(//a[@id='multiSelectionCloseButton'])[9]";
	
	public String lblGroupObjective = "//span[@id='1Group Objective']/label";
	public String lblPlannedActivite = "//span[@id='1Planned activities']/label";
	public String lblAge = "//span[@id='1Age Groups']/label";
	public String lblgender="css=#1gender > label";
	public String lblPrimary = "//span[@id='1Primary Language']/label";
	public String lblCulture = "//span[@id='1Culture is']/label";
	public String lblRole = "//span[@id='1Role, identity or status']/label";
	public String lblPhysical = "//span[@id='1Physical or mental Conditions']/label";
	public String lblSocial = "//span[@id='1Social demographic']/label";
	public String lblPGCollapsableView = "//div[starts-with(@id,'collapsableTitle')]";
	public String lblPGExpandView = "//div[starts-with(@id,'collapsableDesc')]";
	public String lblPDGroup="//div[@class='scheduling-information-box']";
	public String lblPSeries = "//div[@id='chartListItem']";
	
	
	
	public String btnSaveProgramGroup= "saveResourceGroup";
	public String btnCancelProgramGroup = "cancelResourceGroup";
	
	public String Intendedpopulation[]= new String[10];
	public String btnActivateNonProvider="ActivateNon Provider";
	
	//Schedule Series
	public String txtSeriesName = "seriesName";
	public String txtGroup = "groupSize";
	public String txtCVDays = "confirmVisitDays";
	public String txtOccurence = "id=occurrencenum";
	public String txtEndDate = "enddate";
	public String txtLastNanme= "xpath=(//input[@id='firstName'])[2]";
	public String txtcredentials = "credentials";
	public String txtStaff = "xpath=(//input[@class='search-box'])[2]";
	public String txtrecurringTime = "recurringStartTime-hour";
	public String txtrecurringMin = "recurringStartTime-mins";
	public String txtIndividualDate ="durationValue_2";
	public String txtIndividualDate1 = "durationValue_1";
	public String txtIndividualHour = "individualStartTime_2-hour";
	public String txtIndividualHour1 = "individualStartTime_1-hour";
	public String txtIndividualMin = "individualStartTime_2-mins";
	public String txtDuration = "durationValue";
	public String txtInDuration ="null1";
	public String ajxSeriesTriggered = "seriesTriggeredBySuggestBoxsuggestBox";
	public String akxOtherSeries = "otherPdgListSuggestBoxsuggestBox";
	public String ajxGroupCoordinator = "groupCoordinatorSuggestBoxsuggestBox";
	public String ajxLocationType = "locationTypeSuggestBoxsuggestBox";
	public String ajxLocation="locationSuggestBoxsuggestBox";
	public String ajxDateOfMonth = "dateOfMonthSuggestBoxsuggestBox";
	public String ajxRole = "roleSuggestBox";
	public String ajxRoleExternalStaff="searchExternalRoleSBsuggestBox";
	public String ajxExternalRole="pdgRoleSuggestBoxsuggestBox";
	public String ajxduration = "recurringDurationUnitSuggestBoxsuggestBox";
	public String ajxTimeDuration = "individualTimeDurationSuggestBox1suggestBox";
	public String ajxInTimeDuration = "individualTimeDurationSuggestBox2suggestBox";
	public String ajxMonthlyQualifier= "recurringMonthlyQualifierSuggestBoxsuggestBox";
	public String ajxMonthlyDaySelection = "daySelectionSuggestBoxsuggestBox";
	public String chkConfirmVisitSeries = "confirmVisitcheckbox";
	public String chkAllowOnly = "allowOnlyRegParticipantscheckbox";
	public String chkJoin = "joinAfterFirstSessioncheckbox";
	public String chkAllowDrop = "allowDropInscheckbox";
	public String chkUseRecurring="useRecurringradio";
	public String chkIndividual = "individualDatesradio";
	public String chkdaily = "dailyradio";
	public String chkMonthly = "monthlyradio";
	public String chkWeekOf = "weekOfMonthradio";
	public String chkYearly = "yearlyradio";
	public String chkWeekly = "weeklyradio";
	public String chkday = "mondaycheckbox";
	
	public String chkAfter="afterradio";
	public String chkDate = "dateradio";
	public String chkExternal = "//span[2]/input";
	
	
	public String lblStaff="nameLabel";
	public String btnSeriesBack = "seriesBackButton";
	public String btnSeriesNext = "seriesNextButton";
	public String chkblueSummary = "//div[@id='BlueNavigationWiget_MainPanel']/div[2]/div[3]/a";
	public String cssPathForScheduleSeries[]={"css=#seriesName","css=#groupSize","css=#seriesTriggeredBySuggestBoxsuggestBox","css=#groupCoordinatorSuggestBoxsuggestBox","css=#confirmVisitcheckbox",
			"css=#allowOnlyRegParticipantscheckbox","css=#joinAfterFirstSessioncheckbox","css=#locationTypeSuggestBoxsuggestBox","css=#locationSuggestBoxsuggestBox","css=#useRecurringradio","css=#recurringStartDate",
			"css=#recurringStartTime-hour","css=#recurringStartTime-mins","css=#dailyradio","interval","css=#afterradio","occurrencenum","css=#durationValue","css=#recurringDurationUnitSuggestBoxsuggestBox"};
	
	//Staff
	public String lnkStaffDelete="//a[contains(text(),'Delete')]";
	public String lnkbtnExternalAdd="link=Add";
	public String lnkseriousEdit = "//a[contains(text(),'Edit')]";
	public String lnkIndividualDateAddMore = "link=Add more";
	
	public String txtsessionDuration = "sessionDurationValue";
	public String ajxDurationUnit = "durationUnitSuggestBoxsuggestBox";
	public String lblSeriesDetails = "//div[@id='printInfo']/div/div/div[3]/div/div[2]/div/div";
	
	//Add PDG Series
	 public String txtseriesName="seriesName";
	 public String txtGroupSize="groupSize";
	 public String ajxPgm="programSuggestBoxsuggestBox";
	 public String ajxGrpCoordinator="groupCoordinatorSuggestBoxsuggestBox";
	 public String ajxLocationType1="locationTypeSuggestBoxsuggestBox";
	 public String ajxLocation1="locationSuggestBoxsuggestBox";
	 public String ajxRoom="roomSuggestBoxsuggestBox";
	 public String txtStartdate="recurringStartDate";
	 public String txtStartTimeHour="recurringStartTime-hour";
	 public String txtStartTimeMins="recurringStartTime-mins";
	 public String ajxForAmPMSeries="recurringStartTime-ampmsuggestBox";
	 public String ajxForAmPM="recurringStartTime-ampmsuggestBox";
	 public String rdoWeekly="weeklyradio";
	 public String rdoAfter="afterradio";
	 public String rdoDate="dateradio";
	 public String txtEvery="interval";
	 public String chkMonday="mondaycheckbox";
	 public String chkTuesday="tuesdaycheckbox";
	 public String chkWed="wednesaycheckbox";
	 public String chkThursday=" thursdaycheckbox";
	 public String chkFri="fridaycheckbox";
	 public String chkSat="saturdaycheckbox";
	 public String chkSun="sundaycheckbox";
	 public String txtAfterOcc="occurrencenum";
	 public String txtEndDate1="enddate";
	    
	 public String btnNext="css=div.nextIconArrow";
	 public String btnDone="seriesDoneButton";
	 public String recordGroupOutCome="Record Group OutcomeCircle";
	 public String btnEditInPatient="xpath=(//a[contains(@id,'editSession')])[1]";
	 public String txtSearch1="xpath=(//input[@id='searchPatientBox'])[2]";
	//FIXME EMR-1344
	 public String lblAddparticipant="css=div.chart-list-item-left-wrapper.no-hover";
	
	 public String btnSeriesAction="//div[starts-with(@id,'actions')]";
	 public String lnkViewAllSeries="//div[starts-with(@id,'actionViewAllSeries')]";
	 public String lblSeries="leftPanel";
	 public String lnkEditSeries="//a[starts-with(@id,'viewAllSeriesEdit')]";
	 public String lnkDelete="link=Delete";
	
	 public String chkParticipants="css=a.pdg-staff-blueCheckMark";
	 public String unChkParticipants="css=a.pdg-staff-blueCheckMark-invisible";
	 //PDG Queue
	 public String ajxPdgFilter = "pdgFiltersuggestBox";
	 public String ajxPriorstate = "xpath=(//div[@id='panel']/input)[2]";
	 public String txtPdgDate = "pdgHomepageSelectedDate";
	 public String txtReason = "xpath=(//textarea[@id='reasonForJoining'])[2]";

	 public String txtOutComeComments = "//textarea[1]";
	 public String txtEmail = "emailAddress";
	 public String txtTimeHour = "startTime-hour";
	 public String txtTimeMins = "startTime-mins";
	 public String btnAddStaff = "addButtonDiv";

	 public String btnWizardNext = "checkInWizard_NextButton";
	 public String btnWizardDone = "checkInWizard_DoneButton";
	 public String btnRecordSessionNoteShow = "css=span.inline-block.normalSize";

	 public String btnGroupOutComeShow= "//div[@id='wizardContentSection']/div/div[3]/div/div/div/div/span";
	 
	 
	 public String btnAddPatient = "addPatientButtonDiv";
	 public String btnCancelNewPatient = "cancelRegisterButtonDiv";
	 public String txtComments = "comments";
	 public String btnGroupOutCome= "Record Group OutcomeCircle";

	
	public String btnGroupOutShow = "showHideLabelId";
	 
	//UnFinished Item
	public String lnkDeleteUnfinishedItem="//div[@id='unfinishedItemMenuID']/div[2]/ul/li/div/div[4]/a";
	public String btnYesUnfinishedItem = "link=Yes";
	public String btnYesUnfinishedItem1 = "Yes";

	public String btnNoUnfinishedItem= "No";
	public String btnDeleteNoUnfinishedItem= "link=No";
	public String lnkUnfinishedItemOpenArrow="css=#unfinishedItemMenuID > div.menu-arrow.menu-opened";
	public String lnkUnfinishedItem= "//div[@id='unfinishedItemMenuID']/a";
	public String lnkContinueUnfinishedItem="link=Continue";
	public String lnkCancelUnfinishedItem="link=Cancel";
	public String lnkFirstUnfinishedItem="css=div.unfinished-item-name";
	public String lnkShowMoreUnfinishedItem="//li[@class='showMoreUnfinishedItems']";
	public String lnkOpenUnfinishedItem="link=Open Unfinished Item";
	public String btnCancelUnfinishedItem= "Cancel";
	public String lnkLocationHeader= "locationMenuHeader";	
	
	public String lnkLogo="css=a.floatLeft.patientNavigationLogo";
	public String btnDownArrow="css=a.inlineBlock.arrowDownOn";
	
	public String popUPDeleteUnfinishedItem= "css=div.popup-content.width240";
	public String popUPUnfinishedItem= "//body/div[4]/div/div/div";
	public String popUPlogoutUnfinishedItem= "//body/div[5]/div/div/div";
	public String popUPlogoutYes= "//body/div[5]/div/div/div/div";
	public String btnlogoutUnfinishedItem= "link=Continue logging out";
	
	 
	public String btnCancelUpdateParticipants="updateParticipantCancelButton";
	public String lnkUpdateParticipantDaySelection="updateParticipantDaySelectionLink";
	public String chk1="1checkbox";
	public String chk2="2checkbox";
	public String btnCloseSelection="multiSelectionCloseButton";
	public String lblSelectionAlert="Mul1";

	//recordSessionNote
	public String ajxIcdList = "icdSuggestBoxsuggestBox";
	public String txtSession = "css=textarea.height140Important";
	 
	/**
	 * goToSchedulingsection
	 * function to scheduling section
	 * @throws IOException 
	 * @since  	    Jun 06, 2013
	 */	
	
	public boolean goToScheduling(Selenium selenium) throws IOException{
	  	  assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
	      waitForPageLoad(selenium);
	  	  assertTrue(click(selenium,lnkCalendar),"Could not click on Calendar link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		}
	
	public boolean goToScheduling(WebDriver driver){
		
		driver.findElement(By.linkText("Quick actions")).click();	
		
		if(isElementPresentWebDriver(By.id(lnkScheduling), driver)){			
			driver.findElement(By.id(lnkScheduling)).click();			
		}	 		  		 
       
		return true;
	}

	
	public boolean gotoSystemSetting(WebDriver driver){		
		try {			
			
			assertTrue(clickClassName(driver,classQuickLink),"Could not click the Quick option",driver, ClassName, MethodName);			
			assertTrue(click(driver,lnkSystemSetting),"Could not click the system setting link",driver, ClassName, MethodName);				
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(isElementPresent(driver,lnkAdminOrgStructureLists)){
			return true;
		}else
			return false;
		
	}
	
	
	/**
	 * deleteProvider (WebDriver)
	 * function to navigate to Add provider page
	 * @param 		selenium
	 * @param 		providerData
	 * @since  	    September 15, 2014
	 */	
	public boolean deleteProvider(WebDriver driver,SystemSettingsLib providerData){
		boolean returnValue=true;
		try{
			
			String proCount=driver.findElement(By.id(lblProviderCount)).getText();
					
			System.out.println(proCount);			
	        String splitStr1 = proCount.replaceAll("[()]","");	        
	        int ProviderCount = Integer.parseInt(splitStr1);
	        
	        System.out.println(ProviderCount);
	        
			int counter = 1;
			
			if(ProviderCount<=10){
				
				driver.getPageSource().contains(providerData.firstName);
				
				/*while(getText(selenium,"//div[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div[2]/div/div/div/div[2]/div[4]").contains(providerData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
					if(getText(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td/div/div".toLowerCase(new java.util.Locale("en","US"))).contains(providerData.firstName.toLowerCase(new java.util.Locale("en","US")))){
						
						assertTrue(click(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td[2]/div/a"),"Could not click the delete button",selenium, ClassName, MethodName);
						assertTrue(click(selenium,btnYes),"Could not click the yes button",selenium, ClassName, MethodName);
			
						
					}else{
						counter++;
					}
				}*/
				
			}else{
				
				//driver.findElement(By.xpath(txtProviderWD)).sendKeys(providerData.firstName);				
				assertTrue(typeXPath(driver,txtProviderWD,providerData.firstName),"Could not enter the department name",driver, ClassName, MethodName);
				assertTrue(clickXPath(driver, btnSearchProviderWD),"Could not click the search button",driver, ClassName, MethodName);
				
				//System.out.println(getText(,"//div[@id='printInfo']/div/div[3]/div/div/div/div/div/div[2]/div/div[4]/div/div[2]/div/div/div/div[2]/div[4]".toLowerCase(new java.util.Locale("en","US"))));
				System.out.println(providerData.firstName.trim());
								
					if(driver.getPageSource().contains(providerData.firstName)){
				
						assertTrue(clickXPath(driver,lnkDeleteProviderWD),"Could not click the delete Provider button",driver, ClassName, MethodName);
						assertTrue(click(driver,btnYesButton),"Could not click the yes button",driver, ClassName, MethodName);
						
					}
					
				
			}	
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	
	
	/**
	 * createProviderWithMandatory (WebDriver)
	 * function to create Provider With Mandatory
	 * @throws InterruptedException 
	 * @since  	     September 17, 2014
	 */	

	public boolean createProviderWithMandatory(WebDriver driver,SystemSettingsLib providerData, String userAccount ) throws InterruptedException{
		try{
			selectValueFromAjaxList(driver,"providerTypesuggestBox",providerData.providerType);
			
			assertTrue(type(driver,txtFirstname,providerData.firstName),"Could not enter the  name"+ providerData.toString(),driver, ClassName, MethodName);
			assertTrue(type(driver,txtLastName,providerData.lastName),"Could not type a last name"+ providerData.toString(),driver, ClassName, MethodName);
			
			selectValueFromAjaxList(driver,"maximumFTESuggestBoxsuggestBox",providerData.maximumFte);
			
			
			
			if(!userAccount.equalsIgnoreCase(CAAccount)){
				
				if(providerData.billingInfoCheck.equals("Yes")){
					assertTrue(click(driver,"signatureOnFilecheckbox"),"Could not click the signature file check box;More details:"+providerData.toString(),driver, ClassName, MethodName);
					assertTrue(enterDate(driver,"signatureDate",providerData.signatureDate),"Could not enter date; More Details:"+providerData.toString(),driver, ClassName, MethodName);
				}
				if(providerData.billingInfoCheck.equals("No")){
					assertTrue(click(driver,"signatureOnFilecheckbox"),"Could not click the signature file check box;More details:"+providerData.toString(),driver, ClassName, MethodName);
					assertTrue(enterDate(driver,"signatureDate",providerData.signatureDate),"Could not enter date; More Details:"+providerData.toString(),driver, ClassName, MethodName);
				}					
		    }
			
			
			assertTrue(click(driver,btnSave2),"Could not click the save button;More Details:"+providerData.toString(),driver, ClassName, MethodName);
			return true;
		
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Check Inactive Resources 
	 * function to Check Inactive Resources  With MandatoryFields
 * @throws IOException 
	 * @throws InterruptedException 
	 * @since  	     June 07, 2013
	 */	

 public boolean checkInactiveResource (WebDriver driver,SchedulingTestLib createResourceCalData, String account) throws IOException, InterruptedException {
		
	  	  
		    //Check Include Inactive				
			if(!isChecked(driver,chkIncludeInactive)){
				assertTrue(click(driver,chkIncludeInactive),"Could not click check include inactive", driver, ClassName, MethodName);
				waitForPageLoad(driver);
			} 
			
			// Search for a Specific Resource
			assertTrue(type(driver,txtSearchResourceCal,createResourceCalData.search),"Could not select search resource", driver, ClassName, MethodName);
			//Thread.sleep(6000); 
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);			

			
			if (driver.getPageSource().contains("View details"))					  
			  {			
			  		
				System.out.println("Do Nothing");
				
				if(!verifyStoreValues(driver,createResourceCalData)){
			    					
					System.out.println("The Pattern Values are not stored properly");
			    	System.out.println("Edit the new resource");
			    	
					assertTrue(click(driver,btnEditRes),"Could not click Edit Resource button", driver, ClassName, MethodName);
					waitForPageLoad(driver);						
		    		assertTrue(editResourceCalender(driver, createResourceCalData,account), "Create Resource Calender With Mandatory Fields failed", driver, ClassName, MethodName);
		    		waitForPageLoad(driver);
			    }
				
								
				return true;
			  			  
			  }
			
			else if (getText(driver,lblDisplayRow).contains("inactive") && isXPATHElementPresent(driver,btnEdit)) {				
				System.out.println("Inside Activate loop");
				waitForPageLoad(driver);
				waitForPageLoad(driver);
				waitForPageLoad(driver);
				assertTrue(click(driver,btnActivate),"Could not click Activate button", driver, ClassName, MethodName);
				waitForPageLoad(driver);
				assertTrue(click(driver,btnYesButton),"Could not click Yes button", driver, ClassName, MethodName);
				waitForPageLoad(driver);
				return true;
			}							      
	      
	  	return false;
	  	
	 } 
	

 public boolean  verifyStoreValues(WebDriver driver,SchedulingTestLib createResourceCalData) throws IOException, InterruptedException{
	 
	  String date =null;
	  Calendar cal=Calendar.getInstance();
	  SimpleDateFormat DateFormat1=new SimpleDateFormat("MMMM dd");
	  date=DateFormat1.format(cal.getTime());
	  
	  //assertTrue(clickXPath(driver,lnkViewDetails2),"Could not click the link View Details", driver, ClassName, MethodName);
	  
	  assertTrue(clickXPath(driver,lnkViewDetailsXPath),"Could not click the link View Details", driver, ClassName, MethodName);
	  	  	  
	  waitForPageLoad(driver);
	  
	  if(!isTextPresent(driver,createResourceCalData.visitType)){
			 return false;
	    }  
	  
	  waitForPageLoad(driver);	
	 return true; 
}	
 
 
	/**
	 * navigateToNonProviderResource 
	 * function to navigate to Non Provider Resource
	 * @throws IOException 
	 * @since  	     June 06, 2013
	 */	
	 public boolean navigateToNonProviderResource(Selenium selenium) throws IOException {
assertTrue(click(selenium, lnkSettings), "could not able to click the quick action link",selenium, ClassName, MethodName);
waitForPageLoad(selenium);
assertTrue(click(selenium, lnkScheduling), "could not able to click the Scheduling Setting link",selenium, ClassName, MethodName);
		 assertTrue(click(selenium, lnkNonProviderResource), "could not able to click the Non Provider Resource link",selenium, ClassName, MethodName);
		 if(!isElementPresent(selenium, btnAddNonProviderResource)){
			 return false;
		 } 
		 return true;
	 }
	
	 
	 
	 /**
	 * deleteAllNonProviderResource Room
	 * function to delete All Non Provider Resource Room
	 * @throws IOException 
	 * @since  	     June 06, 2013
	 */	
	 
	 
	 public boolean deleteAllNonProviderResource(Selenium selenium, SchedulingTestLib nonProvider) throws IOException {
		 waitForPageLoad(selenium);
		 int nonProviderCount=1;//(Integer) selenium.getXpathCount(lnkDeleteNonProviderResource);
		 //xpath=(//a[contains(text(),'Delete')])[1]
		 while(isElementPresent(selenium,"xpath=(//a[contains(text(),'Delete')])["+nonProviderCount+"]"))
		 {
			 nonProviderCount++;
		 }
		 waitForPageLoad(selenium);
		 waitForPageLoad(selenium);
		 waitForPageLoad(selenium);
		 for(int count=1;count<nonProviderCount;count++){
			 assertTrue(click(selenium, lnkDeleteNonProviderResource), "Could not click the delete button",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 //waitForPageLoad(selenium);
			 //waitForPageLoad(selenium);
			 assertTrue(click(selenium, btnYesButton), "Could not click the yes button in delete pop up",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 //waitForPageLoad(selenium);
		 }
		 
		 assertTrue(!isElementPresent(selenium, lnkDeleteNonProviderResource), "Could not click the yes button in delete pop up",selenium, ClassName, MethodName);
		 waitForPageLoad(selenium);
		
		 return true;
	 }
	 
	 
	 /**
		 * deleteAllResourceGroups
		 * function to delete All Resource Groups
	 * @throws IOException 
		 * @since  	     June 13, 2013
		 */	
		 
		 
		 public boolean deleteAllResourceGroups(Selenium selenium, SchedulingTestLib resourceGroup) throws IOException {
			 int resourceGroupCount=(Integer) selenium.getXpathCount(lnkDeleteResourceGroup);
			 waitForPageLoad(selenium);
			 for(int count=1;count<=resourceGroupCount;count++){
				 assertTrue(click(selenium, lnkDeleteResourceGroup), "Could not click the delete button",selenium, ClassName, MethodName);
				 assertTrue(click(selenium, btnYesButton), "Could not click the yes button in delete pop up",selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
			 }
			 if(getText(selenium, lnkDeleteResourceGroup).equalsIgnoreCase("Delete")){
				 return false;
			 } 
			 return true;
		 }
	
		 
		 /**
			 * createNewNonProviderResource Room
			 * function to create New Non Provider Resource Room
		 * @throws IOException 
			 * @since  	     June 06, 2013
		 */	
		 public boolean createNewNonProviderResourceRoom(Selenium selenium, SchedulingTestLib nonProvider,String uniqueName) throws IOException {
				 					 
			 
				// Add/Edit new Room Resource
				if(nonProvider.testCaseId.equals("TC_NP_001") || nonProvider.testCaseId.equals("TC_NP_001a") || nonProvider.testCaseId.equals("TC_NP_001b") || nonProvider.testCaseId.equals("TC_NP_001c") || nonProvider.testCaseId.equals("TC_NP_001d") || nonProvider.testCaseId.equals("TC_NP_002") || nonProvider.testCaseId.equals("TC_NP_003")){
				 assertTrue(type(selenium, txtRoomName, nonProvider.roomName+uniqueName), "Could not type the Room name",selenium, ClassName, MethodName);
				 selectValueFromAjaxList(selenium, ajxlocation, nonProvider.location);
				}
				
				 // Add new Equipment Resource
				 if(nonProvider.testCaseId.equals("TC_NP_004") ||nonProvider.testCaseId.equals("TC_NP_004a") || nonProvider.testCaseId.equals("TC_NP_004b") || nonProvider.testCaseId.equals("TC_NP_004c") || nonProvider.testCaseId.equals("TC_NP_005") || nonProvider.testCaseId.equals("TC_NP_006")){
					assertTrue(type(selenium, txtRoomName, nonProvider.equipmentName+uniqueName), "Could not type the Equipment name",selenium, ClassName, MethodName);
					// Check is the Mobility is Stationary or MultiLocation				
					if(nonProvider.mobilitystat.equals("yes")){
					
					assertTrue(click(selenium, rdoMobilityNonProviderEquipStationary), "could not able to click radio button for Stationary",selenium, ClassName, MethodName);					
					selectValueFromAjaxList(selenium, ajxlocation, nonProvider.location);	
						
					} else {					
				    assertTrue(click(selenium, rdoMobilityNonProviderEquipMultiLocation), "could not able to click radio button for Multi-Locations",selenium, ClassName, MethodName);
					}
				 }
				 
				// Add new Resource - Support Staff
				if(nonProvider.testCaseId.equals("TC_NP_007") || nonProvider.testCaseId.equals("TC_NP_007a") || nonProvider.testCaseId.equals("TC_NP_007b") || nonProvider.testCaseId.equals("TC_NP_008") || nonProvider.testCaseId.equals("TC_NP_009")||nonProvider.testCaseId.equals("TC_NP_010")){
					 assertTrue(type(selenium, txtSupportStaffName, nonProvider.staffName+uniqueName), "Could not type the Support Staff Name",selenium, ClassName, MethodName);
					 selectValueFromAjaxList(selenium, ajxlocation, nonProvider.location);
				 }
				 
				 waitForPageLoad(selenium);
				 assertTrue(click(selenium, btnSaveNonProviderResource), "Could not click the save button",selenium, ClassName, MethodName);
				 
				 if(!isElementPresent(selenium, btnAddNonProviderResource)){
					 return false;
				 } 
				 return true;
		 }
		 
		  
		 
	 
	 /**
		 * createNewResourceGroups 
		 * function to create New Resource Group
	 * @throws IOException 
		 * @since  	     June 13, 2013
	 */	
	 public boolean createaddNewResourceGroups(Selenium selenium, SchedulingTestLib resourceGroup, String uniqueName) throws IOException {
		 
		
		 
		// Add/Edit new Resource Group
		assertTrue(type(selenium, txtResourceGroupName, resourceGroup.resourceGroupName + uniqueName), "Could not type the Resource Group name",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtSearchResources, resourceGroup.searchResourceName), "Could not type the Search Resource Name",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSearchResources), "Could not click the Search button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		assertTrue(click(selenium, chkSelectAllResources), "Could not click the check box Select All Resources",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSaveResourceGroup), "Could not click the save button",selenium, ClassName, MethodName);
		if(!isElementPresent(selenium, btnAddResourceGroup)){
			return false;
		} 
		return true;
	 }
	 
	 
	 	
	 /**
	 * verfyStoredValuesForNonProviderResource
	 * function to verify Stored Values For Non Provider Resource
	 * @throws IOException 
	 * @since  	     June 06, 2013
	 */
	 public boolean verfyStoredValuesForNonProviderResource(Selenium selenium, SchedulingTestLib nonProvider) throws IOException {
		// check for the Non Provider Resource - Equipment				 
		if(nonProvider.testCaseId.equals("TC_NP_004") || nonProvider.testCaseId.equals("TC_NP_005") || nonProvider.testCaseId.equals("TC_NP_006")){					 
		  assertTrue(getText(selenium, lblSummaryPageNonProviderResourceRoom).toLowerCase(new java.util.Locale("en","Us")).trim().contains(nonProvider.equipmentName.toLowerCase(new java.util.Locale("en","Us")).trim()),"Verification Failed",selenium, ClassName, MethodName);
			
			return true;
		}
		// check for the Non Provider Resource - Support Staff				 
	   if(nonProvider.testCaseId.equals("TC_NP_007") || nonProvider.testCaseId.equals("TC_NP_008") || nonProvider.testCaseId.equals("TC_NP_009")){					 
		   assertTrue(getText(selenium, lblSummaryPageNonProviderResourceRoom).toLowerCase(new java.util.Locale("en","Us")).trim().contains(nonProvider.staffName.toLowerCase(new java.util.Locale("en","Us")).trim()),"Does not contains Non provider Staff name",selenium, ClassName, MethodName);
		 return true;
	   }	
	   System.out.println(getText(selenium, lblSummaryPageNonProviderResourceRoom));
	   System.out.println(nonProvider.roomName);
	   assertTrue(getText(selenium, lblSummaryPageNonProviderResourceRoom).toLowerCase(new java.util.Locale("en","Us")).trim().contains(nonProvider.roomName.toLowerCase(new java.util.Locale("en","Us")).trim()),"Does not contains  room name",selenium, ClassName, MethodName);
	
	
	 return true;
	}
	 
	/**
	* verfyStoredValuesForResourceGroup
	* function to verify Stored Values For Resource Group
	 * @throws IOException 
	* @since  	     June 13, 2013
	 */	
		 
	 public boolean verifyStoredValuesForResourceGroup(Selenium selenium, SchedulingTestLib resourceGroup) throws IOException {
		assertTrue(getText(selenium, lblSummaryPageResourceGroup).contains(resourceGroup.resourceGroupName),"Does not contains resource group name",selenium, ClassName, MethodName);
			
		 return true;
	 }
 
	
	/**
	 *  unit_VisitType
	 * function to  unit_Visit Type
	 * @throws IOException 
	 * @since  	    Jun 06, 2013
	 */	
	public boolean unit_VisitType(Selenium selenium,SchedulingUnitTestLib visitTypeData) throws IOException{
		boolean returnValue = false;
		try{
			assertTrue(click(selenium,lnkVisitType),"Could not click on the visit type link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAdd),"Could not click the add new button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtvisitType,visitTypeData.visitName),"Could not enter the visit type",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtduration,visitTypeData.duration),"Could not enter the duration",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCannotRepeat,visitTypeData.cannotRepeat),"Could not enter the cannotrepeat",selenium, ClassName, MethodName);
		
			if(!isChecked(selenium,chkAllowMultiple)){
				assertTrue(click(selenium,chkAllowMultiple),"Could not click the allow multiple check box",selenium, ClassName, MethodName);
				if(!isChecked(selenium,chklimit))
					assertTrue(click(selenium,chklimit),"Could not click the limited radio button",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtlimitMultiple,visitTypeData.allowmultipleBooking),"Could not type multiple Booking",selenium, ClassName, MethodName);
			}
			
			click(selenium,lnkVisitMoreOption);
			
			/*Assert.assertTrue(click(selenium,lnkVisitMoreOption),"Could not click on More Option");
			waitForPageLoad(selenium);*/
			
			if(visitTypeData.followVisit.equals("Yes")){
				assertTrue(click(selenium,chkFollowUpVisit),"Could not click on Follow check box",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtFollow,visitTypeData.followUp),"Could not enter the follow up value",selenium, ClassName, MethodName);
				selectValueFromajxListForUnit(selenium,ajxFollowUp,visitTypeData.followuptime);
			}
			
			if(visitTypeData.confirmvisit.equals("Yes")){
				assertTrue(click(selenium,chkConfirmVisit),"Could not click on Follow check box",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtConfirmationDay,visitTypeData.confirmationDate),"Could not enter the follow up value",selenium, ClassName, MethodName);
			}
			
			assertTrue(click(selenium,btnSave),"could not click on the link",selenium, ClassName, MethodName);
			returnValue = true;
		}catch(RuntimeException e){
			e.printStackTrace();
			fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + visitTypeData.toString());
		}
		return returnValue;
	}
	
	
	/**
	 *  createVisitType
	 * function to  create Visit Type
	 * @throws IOException 
	 * @since  	    Jun 06, 2013
	 */	
	
	public boolean createVisitType(Selenium selenium,SchedulingTestLib visitTypeData, String uniqueName) throws IOException{
		boolean returnValue = false;
		try{
			if(getText(selenium,lnkHideOption).equalsIgnoreCase("Hide Options")){
				assertTrue(click(selenium,lnkHideOption),"Could not click on hide Option link",selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			}
			    
			assertTrue(type(selenium,txtvisitType,visitTypeData.visitName+uniqueName),"Could not enter the visit type",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtduration,visitTypeData.duration),"Could not enter the duration",selenium, ClassName, MethodName);
			
			
			assertTrue(type(selenium,txtCannotRepeat,visitTypeData.cannotRepeat),"Could not enter the cannotrepeat",selenium, ClassName, MethodName);
		
			selectValueFromAjaxList(selenium,ajxVisitModel,visitTypeData.visitModel);
			//waitForPageLoad(selenium);
			if(!isChecked(selenium,chkAllowMultiple)){
				assertTrue(click(selenium,chkAllowMultiple),"Could not click the allow multiple check box",selenium, ClassName, MethodName);
				assertTrue(click(selenium,chklimit),"Could not click the limited radio button",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtlimitMultiple,visitTypeData.allowmultipleBooking),"Could not type multiple Booking",selenium, ClassName, MethodName);
				if(visitTypeData.testCaseId.equals("TC_VT_002"))
				{
					if(!isChecked(selenium,chkUnLimted)){
						assertTrue(click(selenium,chkUnLimted),"Could not click the limited radio button",selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
					}
				}
			}
			if(visitTypeData.testCaseId.equals("TC_VT_008")){
				assertTrue(click(selenium,chkColor),"Could not click the color box",selenium, ClassName, MethodName);
			}
			if(visitTypeData.testCaseId.equals("TC_VT_009")){
				assertTrue(click(selenium,btnCustom),"Could not click the custom box",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,chkcolor1),"Could not click the color box",selenium, ClassName, MethodName);
			}
			
			if(visitTypeData.testCaseId.equals("TC_VT_002")||visitTypeData.testCaseId.equals("TC_VT_003")||visitTypeData.testCaseId.equals("TC_VT_005")||visitTypeData.testCaseId.equals("TC_VT_006")){
				if(getText(selenium,lnkVisitMoreOption).equalsIgnoreCase("More options"))
					assertTrue(click(selenium,lnkVisitMoreOption),"Could not click on More Option",selenium, ClassName, MethodName);
				    waitForPageLoad(selenium);
				    
				if(visitTypeData.followVisit.equals("Yes")){
					assertTrue(click(selenium,chkFollowUpVisit),"Could not click on Follow check box",selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtFollow,visitTypeData.followUp),"Could not enter the follow up value",selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,ajxFollowUp,visitTypeData.followuptime);
				}
			   if(visitTypeData.confirmvisit.equals("Yes")){
					assertTrue(click(selenium,chkConfirmVisit),"Could not click on Follow check box",selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtConfirmationDay,visitTypeData.confirmationDate),"Could not enter the follow up value",selenium, ClassName, MethodName);
				}
				assertTrue(type(selenium,txtBookInstruction,visitTypeData.bookingDetails),"Could not enter the book Instruction details",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtPatientInstruction,visitTypeData.patientDetails),"Could not enter the patient Instruction details",selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			
			if(visitTypeData.testCaseId.equals("TC_VT_010")){
				if(getText(selenium,lnkVisitMoreOption).equalsIgnoreCase("More options"))
				assertTrue(click(selenium,lnkVisitMoreOption),"Could not click on More Option",selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
				assertTrue(click(selenium,rdoAllLocation),"Could not click rdo All Location",selenium, ClassName, MethodName);
				assertTrue(click(selenium,rdoSelectedLocation),"Could not click rdo Selected Location",selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium,txtSearchLocation,visitTypeData.regional),"could select serch location",selenium, ClassName, MethodName);
				if(!visitTypeData.testCaseId.equals("TC_VT_010")){
				assertTrue(click(selenium,chkConsents),"Could not click consent check box",selenium, ClassName, MethodName);
				assertTrue(selectValueFromAjaxList(selenium,txtSearchLocation,visitTypeData.consentReason),"could select consent reason",selenium, ClassName, MethodName);
				}
		    }
			 if(visitTypeData.testCaseId.equals("TC_VT_007")){
					assertTrue(click(selenium,btnSaveAdd1),"could not click on save and add another button",selenium, ClassName, MethodName);
			}if(visitTypeData.testCaseId.equals("TC_VT_006")||visitTypeData.testCaseId.equals("TC_VT_007")){
				assertTrue(click(selenium,btnCancel),"could not click on cancel button",selenium, ClassName, MethodName);
			}else
			assertTrue(click(selenium,btnSave),"could not click on save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + visitTypeData.toString());
		}
		return returnValue;
	}
	
	
	/**
	 *  createVisitTypePortability
	 * function to  create Visit Type Portability
	 * @throws IOException 
	 * @since  	    Jun 19, 2013
	 */	
	
	public boolean createVisitTypePortability(Selenium selenium,SchedulingTestLib visitTypeData)  {
		boolean returnValue = false;
		try{
			assertTrue(click(selenium,btnAdd),"Could not click on add new button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtvisitType,visitTypeData.visitName),"Could not enter the visit type",selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtduration,visitTypeData.duration),"Could not enter the duration",selenium, ClassName, MethodName);
			
			
			assertTrue(type(selenium,txtCannotRepeat,visitTypeData.cannotRepeat),"Could not enter the cannotrepeat",selenium, ClassName, MethodName);
		
			
			if(visitTypeData.allowmultipleBooking.equals("Yes")){
				assertTrue(click(selenium,chkAllowMultiple),"Could not click the allow multiple check box",selenium, ClassName, MethodName);
				if(visitTypeData.testCaseId.equals("TC_PVT_017")||visitTypeData.testCaseId.equals("TC_PVT_018")||visitTypeData.testCaseId.equals("TC_PVT_019")||visitTypeData.testCaseId.equals("TC_PVT_020")||visitTypeData.testCaseId.equals("TC_PVT_029")||visitTypeData.testCaseId.equals("TC_PVT_030")||visitTypeData.testCaseId.equals("TC_PVT_031")||visitTypeData.testCaseId.equals("TC_PVT_032")){
					assertTrue(click(selenium,chklimit),"Could not click the limited radio button",selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtlimitMultiple,visitTypeData.multipleBooking),"Could not type the multiple booking",selenium, ClassName, MethodName);
				}else{
					if(!isChecked(selenium,chkUnLimted))
						assertTrue(click(selenium,chkUnLimted),"Could not click the limited radio button",selenium, ClassName, MethodName);
					}
				}
			if(getText(selenium,lnkVisitMoreOption).equalsIgnoreCase("More options"))
				assertTrue(click(selenium,lnkVisitMoreOption),"Could not click on More Option",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			if(!isChecked(selenium,chkAllow)){
				assertTrue(click(selenium,chkUnLimted),"Could not click the limited radio button",selenium, ClassName, MethodName);
			}
			if(visitTypeData.selectedLoaction.equals("Yes")){
				assertTrue(click(selenium,chkSelectedLocations),"Could not click selected loaction",selenium, ClassName, MethodName);
	
				assertTrue(selectValueFromAjaxList(selenium,txtLocation1,visitTypeData.location1),"Could not enter the loaction",selenium, ClassName, MethodName);
				if(visitTypeData.testCaseId.equals("TC_PVT_021")||visitTypeData.testCaseId.equals("TC_PVT_022")||visitTypeData.testCaseId.equals("TC_PVT_023")||visitTypeData.testCaseId.equals("TC_PVT_024")||visitTypeData.testCaseId.equals("TC_PVT_025")||visitTypeData.testCaseId.equals("TC_PVT_026")||
						visitTypeData.testCaseId.equals("TC_PVT_027")||visitTypeData.testCaseId.equals("TC_PVT_028")||visitTypeData.testCaseId.equals("TC_PVT_029")||visitTypeData.testCaseId.equals("TC_PVT_030")||visitTypeData.testCaseId.equals("TC_PVT_031")||visitTypeData.testCaseId.equals("TC_PVT_032")){
						assertTrue(click(selenium,lnkAddMore),"Could not click on the add more button",selenium, ClassName, MethodName);
						assertTrue(selectValueFromAjaxList(selenium,txtLocation2,visitTypeData.location2),"Could not enter the loaction",selenium, ClassName, MethodName);
					}
				}
			
			if(visitTypeData.testCaseId.equals("TC_PVT_033")){
				if(!isChecked(selenium,"visitTypeConfirmcheckbox")){
					assertTrue(click(selenium,"visitTypeConfirmcheckbox"),"Could not click the More Option",selenium, ClassName, MethodName );
				}
				assertTrue(type(selenium,"confirmationDays","3"),"could not enter the value",selenium, ClassName, MethodName);
			}

			assertTrue(click(selenium,btnSave),"could not click on save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			returnValue = true;
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + visitTypeData.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

	/**
	 * deleteAllVisitType
	 * function to  delete Visit Type
	 * @throws IOException 
	 * @since  	    Jun 06, 2013
	 */	
	
	public boolean deleteAllVisitType(Selenium selenium,SchedulingTestLib visitType ) throws IOException{
		boolean visitTypeDeleted=true;
		int visitCount; 
		try{
			
			
			/*waitForPageLoad(selenium);
			while((Integer) selenium.getXpathCount(btnDelete) > 0){
				visitCount=(Integer) selenium.getXpathCount(btnDelete);
				Assert.assertTrue(click(selenium,btnDelete));
				selenium.click("okButton");
				waitForPageLoad(selenium);
				Assert.assertTrue(click(selenium,btnYesButton),"Could not click Delete button;More Details:");
				waitForPageLoad(selenium);
				if(visitCount == (Integer) selenium.getXpathCount(btnDelete)){
					visitTypeDeleted = false;
					break;
				}*/
			selectValueFromAjaxList(selenium,txtSearchType,visitType.visitName);
			selenium.typeKeys(txtSearchType, "a");
			waitForPageLoad(selenium);
			int visitDeleteCount=(Integer) selenium.getXpathCount("//div[@id='VisitTypeList']/table/tbody/tr/td[3]/div/a");
			for(visitCount = 1;visitCount<=visitDeleteCount;visitCount++  ){
				waitForPageLoad(selenium);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				assertTrue(click(selenium,btnDelete),"Could not click Selete Button",selenium, ClassName, MethodName);
				//selenium.click("okButton");
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnYesButton),"Could not click Delete button;More Details:",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			return visitTypeDeleted;

		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}

	
	
	/**
	 * verfyStoredValuesForVisitType
	 * function to verify Stored Values For Visit Type
	 * @since  	     June 06, 2013
	 */	
	 public boolean verfyStoredValuesForVisitType(Selenium selenium, SchedulingTestLib visitType) {
		 waitForPageLoad(selenium);
		 
		 if(!selenium.isTextPresent(visitType.visitName)){
			 return false;
		 }
		 if(!selenium.isTextPresent(visitType.visitModel)){
			 return false;
		 }
		 return true;
	 }
	

	/**
	* verifyCollapseViewForVisitType
	* function to verify Stored Values For Visit Type
	 * @throws IOException 
	* @since  	     June 06, 2013
	*/	
	public boolean verifyCollapseViewForVisitType(Selenium selenium, SchedulingTestLib visitType) throws IOException {
		assertTrue(getText(selenium, lblSummaryVisitDetails).contains(visitType.visitName),"verification failed", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium, lblSummaryVisitDetails).trim().contains(visitType.duration.trim()),"verification failed", selenium, ClassName, MethodName);
		
		
		assertTrue(getText(selenium, lblSummaryVisitDetails).toLowerCase(new java.util.Locale("en","Us")).trim().contains(visitType.visitModel.trim().toLowerCase(new java.util.Locale("en","Us"))),"verification failed", selenium, ClassName, MethodName);
		 return true;
			 
	}
	 
	/**
	 * verifyExpendViewForVisitType
	 * function to verify ExpendView For VisitType
	 * @throws IOException 
	 * @since  	     June 10, 2013
	 */	
	 public boolean verifyExpendViewForVisitType(Selenium selenium, SchedulingTestLib visitType) throws IOException {
     assertTrue(click(selenium,lblSummaryVisitDetails),"could not click the arrow",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(getText(selenium, lblSummaryVisitDetails1).contains(visitType.allowmultipleBooking),"Verification failed",selenium, ClassName, MethodName);
		return true;
	}
	/**
	* verifyCollapseViewForVisitType
	* function to verify Stored Values For Visit Type
	 * @throws IOException 
	* @since  	     June 06, 2013
	*/	
	public boolean verifyStoreValueForEditVisitType(Selenium selenium, SchedulingTestLib visitType) throws IOException {
	
		 assertTrue(getValue(selenium,txtvisitType ).contains(visitType.visitName),"Verification Failed",selenium, ClassName, MethodName);
			
		 assertTrue(getValue(selenium, txtduration).trim().contains(visitType.duration.trim()),"Verification Failed",selenium, ClassName, MethodName);
		 
		 assertTrue(getValue(selenium, txtCannotRepeat).trim().contains(visitType.cannotRepeat.trim()),"Verification Failed",selenium, ClassName, MethodName);
		 assertTrue(getValue(selenium, ajxVisitModel).trim().contains(visitType.visitModel.trim()),"Verification Failed",selenium, ClassName, MethodName);
		 
		 
		 assertTrue(getValue(selenium, txtBookInstruction).trim().contains(visitType.bookingDetails.trim()),"Verification Failed",selenium, ClassName, MethodName);
		 assertTrue(getValue(selenium, txtPatientInstruction).trim().contains(visitType.patientDetails.trim()),"Verification Failed",selenium, ClassName, MethodName);
		 assertTrue(getValue(selenium, txtFollow).trim().contains(visitType.followUp.trim()),"Verification Failed",selenium, ClassName, MethodName);
		 assertTrue(getValue(selenium, ajxFollowUp).trim().contains(visitType.followuptime.trim()),"Verification Failed",selenium, ClassName, MethodName);
		 assertTrue(getValue(selenium, txtConfirmationDay).trim().contains(visitType.confirmationDate.trim()),"Verification Failed",selenium, ClassName, MethodName);
		 return true;
	 }	 
	 
	/**
	* addResourceCalUnitTest
	* function to AddNewResourceCalender
	 * @throws IOException 
	* @since Jun 06, 2013
	*/ 
	
	
	public boolean  addResourceCalUnitTest(Selenium  selenium, SchedulingUnitTestLib resourceCalTestData, String account) throws IOException{
		
		String date = null;
		if(resourceCalTestData.testCaseId.equals("TC_RC_001")||resourceCalTestData.testCaseId.equals("TC_RC_002")){		
		assertTrue(selectValueFromajxListForUnit(selenium,ajxResCalOwnerBoxsuggestBox,resourceCalTestData.searchResource),"Could not select search resource"+resourceCalTestData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromajxListForUnit(selenium,ajxrunningMonthsBoxsuggestBox,resourceCalTestData.cycle),"Could not select proper cycle"+resourceCalTestData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}else{
			assertTrue(selectValueFromAjaxList(selenium,ajxResCalOwnerBoxsuggestBox,resourceCalTestData.searchResource),"Could not select search resource"+resourceCalTestData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,ajxrunningMonthsBoxsuggestBox,resourceCalTestData.cycle),"Could not select proper cycle"+resourceCalTestData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		if(resourceCalTestData.testCaseId.equals("TC_RC_006")||resourceCalTestData.testCaseId.equals("TC_RC_007")||resourceCalTestData.testCaseId.equals("TC_RC_008")||resourceCalTestData.testCaseId.equals("TC_RC_009")){
			assertTrue(type(selenium,txtResCalEffectiveDate,resourceCalTestData.effectiveDate),"Could enter effectiveDate",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		else{
			if(account.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat1.format(cal.getTime());
				
				}else {
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
				}
		assertTrue(enterDate(selenium,txtResCalEffectiveDate,date),"Could not enter the Effective Date;More Details:"+resourceCalTestData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	 }
		if(resourceCalTestData.testCaseId.equals("TC_RC_010")){
			if(isChecked(selenium,chkNoEndDatecheckbox)){
	            assertTrue(click(selenium,chkNoEndDatecheckbox),"Could not click EndDate Checkbox",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
		}
		 assertTrue(enterDate(selenium,txtResCalEndDate,resourceCalTestData.endDate),"Could not enter the End Date;More Details:"+resourceCalTestData.toString(),selenium, ClassName, MethodName);
		 waitForPageLoad(selenium);	
		
		}
		if(resourceCalTestData.testCaseId.equals("TC_RC_011")||resourceCalTestData.testCaseId.equals("TC_RC_012")||resourceCalTestData.testCaseId.equals("TC_RC_013")||resourceCalTestData.testCaseId.equals("TC_RC_014")){
			
			if(isChecked(selenium,chkNoEndDatecheckbox)){
	            assertTrue(click(selenium,chkNoEndDatecheckbox),"Could not click EndDate Checkbox",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				}
			assertTrue(enterDate(selenium,txtResCalEndDate,resourceCalTestData.endDate),"Could not enter End Date",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}
		if(resourceCalTestData.testCaseId.equals("TC_RC_015")||resourceCalTestData.testCaseId.equals("TC_RC_016")||resourceCalTestData.testCaseId.equals("TC_RC_017")||resourceCalTestData.testCaseId.equals("TC_RC_018")){
		
			assertTrue(type(selenium,txtPatternStartDayBoxsuggestBox,resourceCalTestData.patternStartsDate),"Could not enter PatternStartDate",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtPatternStartMonthBoxsuggestBox,resourceCalTestData.patternStartsMonth),"Could not enter PatternStartsmonth",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}
		if(resourceCalTestData.testCaseId.equals("TC_RC_019")){
			
			assertTrue(type(selenium,txtPatternStartDayBoxsuggestBox,resourceCalTestData.patternStartsDate),"Could not enter PatternStartDate",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtPatternStartMonthBoxsuggestBox,resourceCalTestData.patternStartsMonth),"Could not enter PatternStartsmonth",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,rdEndsOnDateradio),"Could not click EndsOnDate Radio button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtPatternEndDate,resourceCalTestData.patternEndDate),"Could not enter PatternEndDate",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}
		
		
		
		assertTrue(click(selenium,btnresCalSave),"Could not click save button;More Details:"+resourceCalTestData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}




	
	/**
	 * navigateToCalendarTemplate
	 * function to navigate to Calendar Template
	 * @throws IOException 
	 * @since  	     June 06, 2013
	 */	
	 public boolean navigateToCalendarTemplate(Selenium selenium) throws IOException {
		 assertTrue(click(selenium, lnkQuickAction), "could not able to click the quick action link",selenium, ClassName, MethodName);
		 assertTrue(click(selenium, lnkScheduling), "could not able to click the Scheduling Setting link",selenium, ClassName, MethodName);
		 assertTrue(click(selenium, lnkCalendarTemplate), "could not able to click the Calendar Template link",selenium, ClassName, MethodName);
		 if(!isElementPresent(selenium, btnAddNewCalendarTemplate)){
			 return false;
		 } 
		 return true;
	 }
	 
	 
	 
	 
	 
	 
	 /**
	 * createNewCalendarTemplate
	 * function to create New Calendar Template
	 * @throws IOException 
	 * @since  	     June 06, 2013
	 */	
	 public boolean createNewCalendarTemplate(Selenium selenium, SchedulingTestLib calendarTemplate,String uniqueName) throws IOException {
		assertTrue(click(selenium, btnAddNewCalendarTemplate), "could not able to click create new Calendar Template",selenium, ClassName, MethodName);
		 assertTrue(type(selenium, txtTemplateName, calendarTemplate.templateName+uniqueName), "Could not type the template name",selenium, ClassName, MethodName);
		 assertTrue(click(selenium, btnSaveCalendarTemplate), "Could not click the save button",selenium, ClassName, MethodName);
		 
		 if(!isElementPresent(selenium, btnAddNewCalendarTemplate)){
			 return false;
		 } 
		 return true;
	 }
	 
	 /**
		 * editNewCalendarTemplate
		 * function to create New Calendar Template
	 * @throws IOException 
		 * @since  	     June 06, 2013
		 */	
		 public boolean editNewCalendarTemplate(Selenium selenium, SchedulingTestLib calendarTemplate,String uniqueName) throws IOException {
			 assertTrue(click(selenium, lnkEdit), "could not able to click create new Calendar Template",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(type(selenium, txtTemplateName, calendarTemplate.templateName), "Could not type the template name",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(click(selenium, btnSaveCalendarTemplate), "Could not click the save button",selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 if(!isElementPresent(selenium, btnAddNewCalendarTemplate)){
				 return false;
			 } 
			 return true;
		 }

	 /**
		 * deleteAllCalendarTemplate
		 * function to delete All Calendar Template
	 * @throws IOException 
		 * @since  	     June 06, 2013
		 */	
		 public boolean deleteAllCalendarTemplate(Selenium selenium, SchedulingTestLib calendarTemplate) throws IOException {
			 int calendarTemplateCount=(Integer) selenium.getXpathCount(btnDelete);
			 
			 for(int count=1;count<=calendarTemplateCount;count++){
				assertTrue(click(selenium, btnDelete), "Could not click the delete button",selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnYesButton), "Could not click the yes button in delete pop up",selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
			 }
			 waitForPageLoad(selenium);
			 if(getText(selenium, btnDelete).equalsIgnoreCase("Delete")){
				 return false;
			 } 
			 return true;
		 }

	 
	 /**
	 * verfyStoredValuesForCalendarTemplate
	 * function to verfy Stored Values For Calendar Template
	 * @throws IOException 
	 * @since  	     June 06, 2013
	 */	
	 public boolean verfyStoredValuesForCalendarTemplate(Selenium selenium, SchedulingTestLib calendarTemplate) throws IOException {
		 
		 assertTrue(getText(selenium, lblSummaryPageCalendarTemplate).toLowerCase(new java.util.Locale("en","Us")).trim().contains(calendarTemplate.templateName.toLowerCase(new java.util.Locale("en","Us")).trim()),"Verification Failed",selenium, ClassName, MethodName);
		 return true;
	 }
	 
	 /**
		 * verfyViewDetailsStoredValuesForCalendarTemplate
		 * function to verfy view details Values For Calendar Template
	 * @throws IOException 
		 * @since  	     June 06, 2013
		 */	
		 public boolean verfyViewDetailsStoredValuesForCalendarTemplate(Selenium selenium, SchedulingTestLib calendarTemplate) throws IOException {
			 assertTrue(click(selenium, lnkViewDetails),"Could not click the view details link",selenium, ClassName, MethodName);
			 assertTrue(getText(selenium, lblViewDetailsSummary).trim().contains(calendarTemplate.templateName.trim()),"Verification Failed",selenium, ClassName, MethodName);
			 return true;
		 }

	 /*
		 * createResourceCalenderWithMandatoryFields
		 * function to createResourceCalender With MandatoryFields
		 * @since  	     June 07, 2013
		 */	
	 
	 
		 public boolean  createResourceCalenderWithMandatoryFields(Selenium selenium,SchedulingTestLib createResourceCalData, String account) throws IOException{
				
				String date = null;  
			 
			    assertTrue(selectValueFromAjaxList(selenium,ajxResCalOwnerBoxsuggestBox,createResourceCalData.searchResource),"Could not select search resource"+createResourceCalData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(type(selenium,ajxrunningMonthsBoxsuggestBox,createResourceCalData.cycle),"Could not select proper cycle"+createResourceCalData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			     
				if(account.equals(CAAccount)){
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
					date=DateFormat1.format(cal.getTime());
					
			    }else {
						Calendar cal=Calendar.getInstance();
						SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
						date=DateFormat1.format(cal.getTime());
				}
			
				
				assertTrue(enterDate(selenium,txtResCalEffectiveDate,date),"Could not enter the Effective Date;More Details:"+createResourceCalData.toString(),selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			    
			    if(createResourceCalData.testCaseId.equals("TC_CRC_005")){
			    	if(isChecked(selenium,chkNoEndDatecheckbox)){
			            assertTrue(click(selenium,chkNoEndDatecheckbox),"Could not click EndDate Checkbox",selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
						}
			    	if(account.equals(CAAccount)){
			    	 assertTrue(enterDate(selenium,txtResCalEndDate,createResourceCalData.endDate),"Could not enter the End Date;More Details:"+createResourceCalData.toString(),selenium, ClassName, MethodName);
			   		 waitForPageLoad(selenium);	
			      	}else{
			    		assertTrue(enterDate(selenium,txtResCalEndDate,createResourceCalData.endDate),"Could not enter the End Date;More Details:"+createResourceCalData.toString(),selenium, ClassName, MethodName);
			   		 waitForPageLoad(selenium);	
			    	}
			    	
			    }
			    
			    assertTrue(click(selenium,btnresCalSave),"Could not click save button;More Details:"+createResourceCalData.toString(),selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				 waitForPageLoad(selenium);	
				 waitForPageLoad(selenium);	
				
				if(!isElementPresent(selenium,btnEdit)){
					
					return false;
				}
				
			 return true;
		 }

 
		 /*
			 * createResourceCalender
			 * function to createResourceCalender With MandatoryFields
			 * @since  	     June 07, 2013
			 */	
		 
			 public boolean  createResourceCalender(WebDriver driver,SchedulingTestLib createResourceCalData, String account) throws IOException, InterruptedException{
		            
					String date = null;  
	       
					assertTrue(clickClassName(driver,btnAddClass),"Could not click add New button Class", driver, ClassName, MethodName);
					waitForPageLoad(driver);	
					
					if(createResourceCalData.testCaseId.equals("TC_SBA_006")){
					 assertTrue(selectValueFromAjaxList(driver,ajxResCalOwnerBoxsuggestBox,createResourceCalData.searchResource),"Could not select search resource", driver, ClassName, MethodName);
					 waitForPageLoad(driver);
					
					}else{
						assertTrue(selectValueFromAjaxList(driver,ajxResCalOwnerBoxsuggestBox,createResourceCalData.searchResource),"Could not select search resource", driver, ClassName, MethodName);
						waitForPageLoad(driver);
					}
					
					assertTrue(type(driver,ajxrunningMonthsBoxsuggestBox,createResourceCalData.cycle),"Could not select proper cycle", driver, ClassName, MethodName);
				    waitForPageLoad(driver);
				     
					if(account.equals(CAAccount)){
						Calendar cal=Calendar.getInstance();
						SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
						date=DateFormat1.format(cal.getTime());
						
				    }else {
							Calendar cal=Calendar.getInstance();
							SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
							date=DateFormat1.format(cal.getTime());
					}
				
					
					assertTrue(enterDate(driver,txtResCalEffectiveDate,date),"Could not enter the Effective Date;More Details:"+createResourceCalData.toString(),driver, ClassName, MethodName);
				    waitForPageLoad(driver);
				    
				    assertTrue(click(driver,lnkStartBlank),"Could not click Start Blank Link;More Details:", driver, ClassName, MethodName);
					waitForPageLoad(driver);
					
					assertTrue(selectValueFromAjaxList(driver,ajxLocationSuggestBox,createResourceCalData.location),"Could not select the location", driver, ClassName, MethodName);
					waitForPageLoad(driver);
					
					assertTrue(click(driver,btnLocationNext),"Could not click location Next Button;More Details:", driver, ClassName, MethodName);
					waitForPageLoad(driver);
				    
					// Make 5 different daily appointments in a week (Monday-Friday)
					
					assertTrue(makeResourceAppointment(driver, createResourceCalData,"Monday"), "Create Appointment failed", driver, ClassName, MethodName);
					waitForPageLoad(driver);
					
					assertTrue(makeResourceAppointment(driver, createResourceCalData, "Tuesday"), "Create Appointment failed", driver, ClassName, MethodName);
					waitForPageLoad(driver);
					
					assertTrue(makeResourceAppointment(driver, createResourceCalData, "Wednesday"), "Create Appointment failed", driver, ClassName, MethodName);
					waitForPageLoad(driver);
					
					assertTrue(makeResourceAppointment(driver, createResourceCalData, "Thursday"), "Create Appointment failed", driver, ClassName, MethodName);
					waitForPageLoad(driver);
					
					assertTrue(makeResourceAppointment(driver, createResourceCalData,"Friday"), "Create Appointment failed", driver, ClassName, MethodName);
					waitForPageLoad(driver);
										
					
				    assertTrue(click(driver,btnresCalSave),"Could not click Start Blank Link;More Details:", driver, ClassName, MethodName);
					waitForPageLoad(driver);			    
				    
				    
					
					if(isChecked(driver,chkbxIncludeInactive)){
						assertTrue(click(driver,chkbxIncludeInactive),"Could not click check include inactive", driver, ClassName, MethodName);
						waitForPageLoad(driver);
					}
					if(!isXPATHElementPresent(driver,btnEdit)){
						return false;
					}
					
				 return true;
		    }


			 /*
				 * createResourceCalender
				 * function to createResourceCalender With MandatoryFields
				 * @since  	     June 07, 2013
				 */	
			 
				 public boolean  editResourceCalender(WebDriver driver,SchedulingTestLib createResourceCalData, String account) throws IOException, InterruptedException{
			            
						String date = null;  
		       
						//assertTrue(click(driver,btnAdd),"Could not click add new button", driver, ClassName, MethodName);
						//waitForPageLoad(driver);	
						
						if(createResourceCalData.testCaseId.equals("TC_SBA_006")){
						 assertTrue(selectValueFromAjaxList(driver,ajxResCalOwnerBoxsuggestBox,createResourceCalData.searchResource),"Could not select search resource", driver, ClassName, MethodName);
						 waitForPageLoad(driver);
						
						}else{
							assertTrue(selectValueFromAjaxList(driver,ajxResCalOwnerBoxsuggestBox,createResourceCalData.searchResource),"Could not select search resource", driver, ClassName, MethodName);
							waitForPageLoad(driver);
						}
						
						assertTrue(type(driver,ajxrunningMonthsBoxsuggestBox,createResourceCalData.cycle),"Could not select proper cycle", driver, ClassName, MethodName);
					    waitForPageLoad(driver);
										     
						if(account.equals(CAAccount)){
							Calendar cal=Calendar.getInstance();
							SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
							date=DateFormat1.format(cal.getTime());
							
					    }else {
								Calendar cal=Calendar.getInstance();
								SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
								date=DateFormat1.format(cal.getTime());
						}
					
						
						assertTrue(enterDate(driver,txtResCalEffectiveDate,date),"Could not enter the Effective Date;More Details:"+createResourceCalData.toString(), driver, ClassName, MethodName);
					    waitForPageLoad(driver);
					   
					    assertTrue(makeResourceAppointment(driver, createResourceCalData, "Monday"), "Create Appointment failed", driver, ClassName, MethodName);
						waitForPageLoad(driver);
						
						assertTrue(makeResourceAppointment(driver, createResourceCalData, "Tuesday"), "Tuesday Appointment failed", driver, ClassName, MethodName);
						waitForPageLoad(driver);
						
						assertTrue(makeResourceAppointment(driver, createResourceCalData, "Wednesday"), "Wednesday Appointment failed", driver, ClassName, MethodName);
						waitForPageLoad(driver);
						
						assertTrue(makeResourceAppointment(driver, createResourceCalData, "Thursday"), "Thursday Appointment failed", driver, ClassName, MethodName);
						waitForPageLoad(driver);
						
						assertTrue(makeResourceAppointment(driver, createResourceCalData,"Friday"), "Friday Appointment failed", driver, ClassName, MethodName);
						waitForPageLoad(driver);
					    
					    assertTrue(click(driver,btnresCalSave),"Could not click save button;More Details:", driver, ClassName, MethodName);
						waitForPageLoad(driver);
						
						
						
					 return true;
		 }

			 
 
	 /**
	 * deleteAllResourceCalendar
	 * function to delete All  Resource Calendar 
	 * @throws IOException 
	 * @since  	     June 07, 2013
	 */	
	 public boolean deleteAllResourceCalendar(Selenium selenium) throws IOException{
		boolean  resourceCalendarDeleted=true;
		
	    int resourceCalendarCount=(Integer) selenium.getXpathCount(btnDelete);
		
		 for(int count=1;count<=resourceCalendarCount;count++){
			 assertTrue(click(selenium, btnDelete), "Could not click the delete button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(click(selenium, btnYesButton), "Could not click the yes button in delete pop up", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
		 }
		if(getText(selenium, btnDelete).equalsIgnoreCase("Delete")){
			 resourceCalendarDeleted = false;
		 } 
		return resourceCalendarDeleted;
	}
	 
	 /**
	  * unitTestforVisitGroup
	 * function to Unit test for Visit Group
	 * @throws IOException 
	 * @since  	     June 12, 2013
	 */	
	 
	 public boolean unit_VisitGroup(Selenium selenium,SchedulingUnitTestLib visitGroupData ) throws IOException{
		 boolean returnValue=false;
		 try{
			 assertTrue(click(selenium,lnkVisitGroup),"Could not click the link", selenium, ClassName, MethodName);
			 assertTrue(click(selenium,btnAdd),"Could not click the add new button", selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtGroupName,visitGroupData.groupName),"Could not type the group name", selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtSearch,visitGroupData.visitType),"Could not type the visit type", selenium, ClassName, MethodName);
			 assertTrue(click(selenium,btnSearch),"Could not click the search button", selenium, ClassName, MethodName);
			 if(visitGroupData.testCaseId.equals("TC_UVG001"))
			 assertTrue(click(selenium,btnSave),"Could not click the save button", selenium, ClassName, MethodName);
			 returnValue=true;
		 }catch(RuntimeException e ){
			 e.printStackTrace();
			 Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + visitGroupData.toString());
		 }
		return returnValue;
	 }
	 
	 /**
	  * createVisitGroup
	 * function to create Visit Group
	 * @throws IOException 
	 * @since  	     June 12, 2013
	 */	
	 
	 public boolean createVisitGroup(Selenium selenium,SchedulingTestLib visitGroupData,String uniqueName) throws IOException{
		 boolean returnValue=false;
		 try{
			 /*if(visitGroupData.testCaseId.equals("TC_VG_001")){
				 Assert.assertTrue(type(selenium,txtGroupName,visitGroupData.groupName),"Could not enter the group name");
			 }*/
			 
		
			 			 
			 assertTrue(type(selenium,txtGroupName,visitGroupData.groupName + uniqueName),"Could not enter the group name", selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtSearch,visitGroupData.visitName),"Could not enter the visit type ", selenium, ClassName, MethodName);
			 assertTrue(click(selenium,btnSearch),"could not click on the search button", selenium, ClassName, MethodName);
			 
			 waitForPageLoad(selenium);
			 
			if(!(visitGroupData.testCaseId.equals("TC_VG_001")|| visitGroupData.testCaseId.equals("TC_VG_003")|| visitGroupData.testCaseId.equals("TC_VG_002"))){
				if(!isChecked(selenium,chkViistType)){
					assertTrue(click(selenium,chkViistType),"Could not click on the check box", selenium, ClassName, MethodName);
				}
			 }
			 if(visitGroupData.testCaseId.equals("TC_VG_006")){
				 assertTrue(click(selenium,chkColor),"Could not click on the color", selenium, ClassName, MethodName);
			 }
			 if(visitGroupData.testCaseId.equals("TC_VG_007")){
				 assertTrue(click(selenium,btnCustom),"Could not click on the custom color button", selenium, ClassName, MethodName);
				 assertTrue(click(selenium,chkCustomColor),"Could not click on the  color", selenium, ClassName, MethodName);
			 }
			 if(visitGroupData.testCaseId.equals("TC_VG_005")){
				 assertTrue(click(selenium,btnSaveAdd),"Could not click the Save and add another button", selenium, ClassName, MethodName);
			 }
			 if(visitGroupData.testCaseId.equals("TC_VG_003")||(visitGroupData.testCaseId.equals("TC_VG_005"))){
				 assertTrue(click(selenium,btnCancel),"Could not click the cancel button", selenium, ClassName, MethodName);
			 }else
				 assertTrue(click(selenium,btnSave),"Could not click the save button", selenium, ClassName, MethodName);
			 
			 
			 
			 returnValue=true;
			}catch(RuntimeException e){
			 e.printStackTrace();
			 Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + visitGroupData.toString());
		 }
		return returnValue;
	 }
	 
	 /**
	  * deleteVisitGroup
	 * function to delete Visit Group
	 * @throws IOException 
	 * @since  	     June 12, 2013
	 */	

		public boolean deleteVisitGroup(Selenium selenium) throws IOException{
			waitForPageLoad(selenium);
			boolean visitGroupDeleted=true;
			int visitCount=0; 
			try{
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				while((Integer) selenium.getXpathCount(btnDelete) > 0){
					visitCount=(Integer) selenium.getXpathCount(btnDelete);
					assertTrue(click(selenium,btnDelete),"Could not click the delete button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnYesButton),"Could not click Delete button;More Details:", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					if(visitCount == (Integer) selenium.getXpathCount(btnDelete)){
						visitGroupDeleted = false;
						break;
					}
				}
				return visitGroupDeleted;

			}catch(RuntimeException e){
				e.printStackTrace();
				return false;
			}
		}
	 
	 
	 
	 /**
	  * verfyStoredValuesForVisitGroup
	 * function to verfy Stored Values For VisitGroup
	 * @throws IOException 
	 * @since  	     June 12, 2013
	 */	
	 public boolean verfyStoredValuesForVisitGroup(Selenium selenium,SchedulingTestLib visitGroupData, String uniqueName) throws IOException{
		 waitForPageLoad(selenium);
		 assertTrue(getText(selenium,"VisitGroupsListWidget").trim().contains(visitGroupData.groupName+uniqueName.trim()),"Verification Failed",selenium, ClassName, MethodName);
		 return true;
	 }
	 
	 /**
	  * verifyCollapseViewForVisitGroup
	 * function to verify Collapse View For VisitGroup
	 * @throws IOException 
	 * @since  	     June 21, 2013
	 */	
	 
	 public boolean verifyCollapseViewForVisitGroup(Selenium selenium,SchedulingTestLib visitGroupData) throws IOException{
		 waitForPageLoad(selenium);
		 
		 
		 assertTrue(selenium.isTextPresent(visitGroupData.groupName),""+"Visit Group Name Not Present",selenium, ClassName, MethodName);
		 waitForPageLoad(selenium);
			
		 assertTrue(click(selenium,lblGroupsummary),"could not click the arrow", selenium, ClassName, MethodName);
		 
		 assertTrue(selenium.isTextPresent(visitGroupData.visitName),""+"Visit Group Visit Name not Present",selenium, ClassName, MethodName);
		 waitForPageLoad(selenium);
		 
		 return true;
	 }
	 
	 
	 /**
	  * verfyStoredValuesForEditVisitGroup
	 * function to verfy Stored Values For Edit VisitGroup
	 * @throws IOException 
	 * @since  	     June 12, 2013
	 */	
	 public boolean verfyStoredValuesForEditVisitGroup(Selenium selenium,SchedulingTestLib visitGroupData) throws IOException{
		 waitForPageLoad(selenium);
		 assertTrue(getValue(selenium,txtGroupName.trim()).contains(visitGroupData.groupName.trim()),"Verification Failed",selenium, ClassName, MethodName);
		 		 
		 return true;
	 }
	 
	 
	 /**
	 	 * locationHourUnitTest
		* function to locationHourUnitTest
	 * @throws IOException 
		* @since Jun 12, 2013
		*/ 
		
	 	public boolean  locationHourUnitTest(Selenium  selenium, SchedulingUnitTestLib lhour) throws IOException{
	 			waitForPageLoad(selenium);
			 assertTrue(click(selenium, lnkEdit), "could not able to click the edit link", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(type(selenium,txtStartHour,lhour.startHour),"Could enter start hour", selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtStartMin,lhour.startMin),"Could enter start Min", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(type(selenium,txtEndHour,lhour.endHour),"Could enter End hour", selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtEndMin,lhour.endMin),"Could enter End Min", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 if(lhour.testCaseId.equalsIgnoreCase("TC_ULH_016")){
				 assertTrue(selectValueFromAjaxList(selenium,ajxampmSuggestBox2,"am"),"Could not select end time format"+lhour.toString(), selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
			 }
			 
			 assertTrue(click(selenium, btnsaveLocationHours), "could not able to click SaveLocatioHours", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 return true;
		}


	 	/**
		 * verfyStoredValuesForCalendarTemplate
		 * function to verfy Stored Values For Calendar Template
	 	 * @throws IOException 
		 * @since  	     June 06, 2013
		 */	
		 public boolean verfySearchResultForCalendarTemplate(Selenium selenium, String newCalendarTemplate, String oldCalendarTemplate) throws IOException {
			 assertTrue(getText(selenium, lblSummaryPageCalendarTemplate).contains(newCalendarTemplate),"Verification Failed",selenium, ClassName, MethodName);
			 assertTrue(!getText(selenium, lblSummaryPageCalendarTemplate).contains(oldCalendarTemplate),"Verification Failed",selenium, ClassName, MethodName);
			 return true;
		 }

		 
	 /**
	 * createNewCalendarTemplate
	 * function to create New Calendar Template
	 * @throws IOException 
	 * @since  	     June 06, 2013
	 */	
	 public boolean createNewCalendarTemplateUnitTest(Selenium selenium, SchedulingUnitTestLib calendarTemplate) throws IOException {
		 assertTrue(click(selenium, btnAddNewCalendarTemplate), "could not able to click create new Calendar Template", selenium, ClassName, MethodName);
		 assertTrue(type(selenium, txtTemplateName, calendarTemplate.templateName), "Could not type the template name", selenium, ClassName, MethodName);
		 assertTrue(click(selenium, btnSaveCalendarTemplate), "Could not click the save button", selenium, ClassName, MethodName);
		if(!isElementPresent(selenium, btnSaveCalendarTemplate)){
			 return false;
		} return true;
	}
	 
	 /**
	 	 * editlocationHour
		* function to locationHourUnitTest
	 * @throws IOException 
		* @since Jun 14, 2013
		*/ 
		
	 	public boolean  editlocationHour(Selenium  selenium, SchedulingTestLib lhour) throws IOException{
	 		
	 		
			 assertTrue(click(selenium, lnkEdit), "could not able to click the edit link", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 
			 if((selenium.isVisible( ajxHourFormatStart) && selenium.isVisible( ajxHourFormatEnd))){

				 assertTrue(type(selenium,txtStartHour,lhour.startHour),"Could enter start hour", selenium, ClassName, MethodName);
				 assertTrue(type(selenium,txtStartMin,lhour.startMin),"Could enter start Min", selenium, ClassName, MethodName);
				 assertTrue(selectValueFromAjaxList(selenium,ajxHourFormatStart,lhour.startFormat),"Could not select proper format"+lhour.toString(), selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
				 assertTrue(type(selenium,txtEndHour,lhour.endHour),"Could enter End hour", selenium, ClassName, MethodName);
				 assertTrue(type(selenium,txtEndMin,lhour.endMin),"Could enter End Min", selenium, ClassName, MethodName);
				 assertTrue(selectValueFromAjaxList(selenium,ajxHourFormatEnd,lhour.endFormat),"Could not select proper format"+lhour.toString(), selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
				 
				 if(!lhour.testCaseId.equals("TC_LH_008")){
					 assertTrue(click(selenium, btnsaveLocationHours), "could not able to click SaveLocatioHours", selenium, ClassName, MethodName);
					 waitForPageLoad(selenium);
				 }
			 
				 else{
					 assertTrue(click(selenium, btncancelLocationHours), "could not able to click SaveLocatioHours", selenium, ClassName, MethodName);
					 waitForPageLoad(selenium);
				 }
			 }
			 else{
				 return false;
			 }
			 return true;
		}
	 	
		 /**
	 	 * editlocationHour
		* function to locationHourUnitTest
		 * @throws IOException 
		 * @throws InterruptedException 
		* @since Jun 14, 2013
		*/ 
		
	 	public boolean  editlocationHour(WebDriver driver, SchedulingTestLib lhour) throws IOException, InterruptedException{
			 
	 		 assertTrue(clickXPath(driver, btnEditLocation), "could not able to click the edit link",driver, ClassName, MethodName);
			 waitForPageLoad(driver);
			 
			 if((isElementVisible(driver,ajxHourFormatStart) && isElementVisible(driver, ajxHourFormatEnd))){

				 assertTrue(type(driver,txtStartHour,lhour.startHour),"Could enter start hour",driver, ClassName, MethodName);
				 waitForPageLoad(driver);
				 assertTrue(type(driver,txtStartMin,lhour.startMin),"Could enter start Min",driver, ClassName, MethodName);
				 waitForPageLoad(driver);
				 //assertTrue(selectValueFromAjaxList(driver,ajxHourFormatStart,lhour.startFormat),"Could not select proper format"+lhour.toString(),driver, ClassName, MethodName);
				 waitForPageLoad(driver);
				 assertTrue(type(driver,txtEndHour,lhour.endHour),"Could enter End hour",driver, ClassName, MethodName);
				 waitForPageLoad(driver);
				 assertTrue(type(driver,txtEndMin,lhour.endMin),"Could enter End Min",driver, ClassName, MethodName);
				 waitForPageLoad(driver);
				 //assertTrue(selectValueFromAjaxList(driver,ajxHourFormatEnd,lhour.endFormat),"Could not select proper format"+lhour.toString(),driver, ClassName, MethodName);
				 waitForPageLoad(driver);
				 
				/* if(!lhour.testCaseId.equals("TC_LH_008")){
					 Assert.assertTrue(click(selenium, btnsaveLocationHours), "could not able to click SaveLocatioHours");
					 waitForPageLoad(selenium);
				 }
			 
				 else{
					 Assert.assertTrue(click(selenium, btncancelLocationHours), "could not able to click SaveLocatioHours");
					 waitForPageLoad(selenium);
				 }*/
				 
				 assertTrue(click(driver, btnsaveLocationHours), "could not able to click SaveLocatioHours",driver, ClassName, MethodName); 
				 
			 }
			 else{
				 return false;
			 }
			 return true;
		}
	 	
	 	/*
		 * createPatternForResourceCalender
		 * function to createPatternForResourceCalender With MandatoryFields
		 * @since  	     June 17, 2013
		 */	
	 
	 
		 public boolean  createPatternForResourceCalender(Selenium selenium,SchedulingTestLib createResourceCalData, String account) throws IOException{
	            
				String date = null;  
			 
			    assertTrue(selectValueFromAjaxList(selenium,ajxResCalOwnerBoxsuggestBox,createResourceCalData.searchResource),"Could not select search resource"+createResourceCalData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(type(selenium,ajxrunningMonthsBoxsuggestBox,createResourceCalData.cycle),"Could not select proper cycle"+createResourceCalData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			     
				if(account.equals(CAAccount)){
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
					date=DateFormat1.format(cal.getTime());
					
			    }else {
						Calendar cal=Calendar.getInstance();
						SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
						date=DateFormat1.format(cal.getTime());
				}
											
                assertTrue(enterDate(selenium,txtResCalEffectiveDate,date),"Could not enter the Effective Date;More Details:"+createResourceCalData.toString(), selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			  
			    if(createResourceCalData.testCaseId.equals("TC_CRC_004")||createResourceCalData.testCaseId.equals("TC_CRC_003")){
			    
			    	assertTrue(selectValueFromAjaxList(selenium,txtPatternStartDayBoxsuggestBox,createResourceCalData.patternStartsDate),"Could not select Pattern Day" +createResourceCalData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
			    	assertTrue(selectValueFromAjaxList(selenium,txtPatternStartMonthBoxsuggestBox,createResourceCalData.patternStartsMonth),"Could not select Pattern "+createResourceCalData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					 if(createResourceCalData.testCaseId.equals("TC_CRC_003")){ 
						  
						assertTrue(selectValueFromAjaxList(selenium,txtPatternStartDayBoxsuggestBox,createResourceCalData.patternStartsDate1),"Could not select Pattern Day" +createResourceCalData.toString(), selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
				    	
						assertTrue(selectValueFromAjaxList(selenium,txtPatternStartMonthBoxsuggestBox,createResourceCalData.patternStartsMonth1),"Could not select Pattern Day"+createResourceCalData.toString(), selenium, ClassName, MethodName);
						waitForPageLoad(selenium);
				}
		    }
						    
			    assertTrue(click(selenium,btnresCalSave),"Could not click save button;More Details:"+createResourceCalData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(!isElementPresent(selenium,btnEdit)){
					return false;
				}
				
			 return true;
		 }
		 
		 
		 /*
			 * createPatternForResourceCalender
			 * function to createPatternForResourceCalender With MandatoryFields (WebDriver)
			 * @since  	     June 17, 2013
			 */	
		 
		 
			 public boolean  createPatternForResourceCalender(WebDriver driver,Selenium selenium,SchedulingTestLib createResourceCalData, String account) throws IOException, InterruptedException{
		            
					String date = null;
					
				    //Assert.assertTrue(selectValueFromAjaxList(selenium,ajxResCalOwnerBoxsuggestBox,createResourceCalData.searchResource),"Could not select search resource"+createResourceCalData.toString());
				    assertTrue(selectValueFromAjaxList(driver,ajxResCalOwnerBoxsuggestBox,createResourceCalData.searchResource),"Could not select search resource"+createResourceCalData.toString(), selenium, ClassName, MethodName);
				    waitForPageLoad(driver);
				    //Assert.assertTrue(type(driver,ajxrunningMonthsBoxsuggestBox,createResourceCalData.cycle),"Could not select proper cycle"+createResourceCalData.toString());
				    waitForPageLoad(driver);					
				     
					if(account.equals(CAAccount)){
						Calendar cal=Calendar.getInstance();
						SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
						date=DateFormat1.format(cal.getTime());
						
				    }else {
							Calendar cal=Calendar.getInstance();
							SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
							date=DateFormat1.format(cal.getTime());
					}				
										
					assertTrue(makeResourceAppointment(driver, createResourceCalData, "Monday"), "Create Appointment failed", selenium, ClassName, MethodName);
					waitForPageLoad(driver);
					
	                //Assert.assertTrue(enterDate(selenium,txtResCalEffectiveDate,date),"Could not enter the Effective Date;More Details:"+createResourceCalData.toString());
				    //waitForPageLoad(selenium);
				  
				/*    if(createResourceCalData.testCaseId.equals("TC_CRC_004")||createResourceCalData.testCaseId.equals("TC_CRC_003")){
				    
				    	Assert.assertTrue(selectValueFromAjaxList(selenium,txtPatternStartDayBoxsuggestBox,createResourceCalData.patternStartsDate),"Could not select Pattern Day" +createResourceCalData.toString());
						waitForPageLoad(selenium);
				    	Assert.assertTrue(selectValueFromAjaxList(selenium,txtPatternStartMonthBoxsuggestBox,createResourceCalData.patternStartsMonth),"Could not select Pattern "+createResourceCalData.toString());
						waitForPageLoad(selenium);
						 if(createResourceCalData.testCaseId.equals("TC_CRC_003")){ 
							  
							Assert.assertTrue(selectValueFromAjaxList(selenium,txtPatternStartDayBoxsuggestBox,createResourceCalData.patternStartsDate1),"Could not select Pattern Day" +createResourceCalData.toString());
							waitForPageLoad(selenium);
					    	
							Assert.assertTrue(selectValueFromAjaxList(selenium,txtPatternStartMonthBoxsuggestBox,createResourceCalData.patternStartsMonth1),"Could not select Pattern Day"+createResourceCalData.toString());
							waitForPageLoad(selenium);
					    }
			        }*/
					
					
					assertTrue(click(driver,btnresCalSave),"Could not click Save Calender button", driver, ClassName, MethodName );
					waitForPageLoad(driver);							    
					
					if(!isXPathElementPresent(driver,btnEdit,50)){
						return false;
					}
					
				 return true;
			 }	 	

			 /**
				 * Make an appointment
				 * function to create New Calendar Template
			 * @throws InterruptedException 
			 * @throws IOException 
				 * @since  	     June 06, 2013
			 */
			 
			 public boolean makeResourceAppointment(WebDriver driver, SchedulingTestLib createResourceCalData, String WeekDay) throws InterruptedException, IOException {
				    waitForPageLoad(driver);
				    
				   System.out.println(WeekDay);
				    
				    if (WeekDay.equals("Monday"))
				    {System.out.println("Inside the Monday Loop");
				    	WebElement mnuElement2 = driver.findElement(By.id(createResourceCalData.coordinateMon));
				    Actions builder2 = new Actions(driver);					
					builder2.moveToElement(mnuElement2).clickAndHold().build().perform();}
				    else if(WeekDay.equals("Tuesday")) 
				    {System.out.println("Inside the Tuesday Loop");
				    WebElement mnuElement3 = driver.findElement(By.id(createResourceCalData.coordinateTues));
				    Actions builder3 = new Actions(driver);					
					builder3.moveToElement(mnuElement3).clickAndHold().build().perform();				    
				    }
				    else if(WeekDay.equals("Wednesday")) 
				    {System.out.println("Inside the Wednesday Loop");
				    WebElement mnuElement4 = driver.findElement(By.id(createResourceCalData.coordinateWed));
				    Actions builder4 = new Actions(driver);					
					builder4.moveToElement(mnuElement4).clickAndHold().build().perform();				    
				    }
				    else if(WeekDay.equals("Thursday")) 
				    {System.out.println("Inside the Thursday Loop");
				    WebElement mnuElement5 = driver.findElement(By.id(createResourceCalData.coordinateThur));
				    Actions builder5 = new Actions(driver);					
					builder5.moveToElement(mnuElement5).clickAndHold().build().perform();				    
				    }
				    else if(WeekDay.equals("Friday")) 
				    {System.out.println("Inside the Friday Loop");
				    WebElement mnuElement6 = driver.findElement(By.id(createResourceCalData.coordinateFri));
				    Actions builder6 = new Actions(driver);					
					builder6.moveToElement(mnuElement6).clickAndHold().build().perform();				    
				    }
				    
				    
				 
					waitForPageLoad(driver);
					waitForPageLoad(driver);					
					assertTrue(selectValueFromAjaxList(driver,ajxvisitLocationsuggestBox,createResourceCalData.location),"Could not click Resource Calender link", driver, ClassName, MethodName);
				    waitForPageLoad(driver);
				    
				    assertTrue(selectValueFromAjaxList(driver,ajxvisitTypesuggestBox,createResourceCalData.visitType),"Could not select visitType"+createResourceCalData.toString(), driver, ClassName, MethodName);
				    waitForPageLoad(driver);
				    
				    //Assert.assertTrue(type(driver,txtStartTimehour,createResourceCalData.maxBooking),"Could not select proper cycle"+createResourceCalData.toString());
				    //waitForPageLoad(driver);
				    
				    //Assert.assertTrue(type(driver,txtEndTimehour,createResourceCalData.maxBooking),"Could not select proper cycle"+createResourceCalData.toString());
				    //waitForPageLoad(driver);
				    
				    assertTrue(click(driver,ajxTimeSuggestBox),"Could not Click on AM/PM Selection Box", driver, ClassName, MethodName );
				    waitForPageLoad(driver);
				    
				    assertTrue(click(driver,ajxPMSelection),"Could not Click on PM Selection", driver, ClassName, MethodName );
				    waitForPageLoad(driver);
				    
				    assertTrue(type(driver,txtMaxBooking,createResourceCalData.maxBooking),"Could not select proper cycle"+createResourceCalData.toString(), driver, ClassName, MethodName);
				    waitForPageLoad(driver);
				    
				    assertTrue(click(driver,btnAppointmentSave),"Could not click Save button", driver, ClassName, MethodName );
				    waitForPageLoad(driver);
				    waitForPageLoad(driver);
				    
				   
					return true;
			 }
		 

		 /**
			 * createNewCalendarTemplate
			 * function to create New Calendar Template
		 * @throws IOException 
			 * @since  	     June 06, 2013
			 */	
			 public boolean verifyPreviewInCreateNewCalendarTemplate(Selenium selenium, SchedulingTestLib calendarTemplate) throws IOException {
				 assertTrue(click(selenium, btnAddNewCalendarTemplate), "could not able to click create new Calendar Template", selenium, ClassName, MethodName);
				 assertTrue(type(selenium, txtTemplateName, calendarTemplate.templateName), "Could not type the template name", selenium, ClassName, MethodName);
				 
				 assertTrue(click(selenium, btnPreviewCalendarTemplate), "Could not click the preview button", selenium, ClassName, MethodName);
				 
				 if(!isElementPresent(selenium, btnAddNewCalendarTemplate)){
					 return false;
				 } 
				 return true;
			 }

			 
			
			 	
			 	 /**
			 	 * editlocationHour
				* function to locationHourUnitTest
			 	 * @throws IOException 
				* @since Jun 14, 2013
				*/ 
				
			 	public boolean  editlocationHourportability(Selenium  selenium, SchedulingTestLib lhour) throws IOException{
					
					 assertTrue(click(selenium, lnkEdit), "could not able to click the edit link", selenium, ClassName, MethodName);
					 waitForPageLoad(selenium);
					 assertTrue(type(selenium,txtStartHour,lhour.startHour),"Could enter start hour", selenium, ClassName, MethodName);
					 assertTrue(type(selenium,txtStartMin,lhour.startMin),"Could enter start Min", selenium, ClassName, MethodName);
					
					 selectValueFromAjaxList(selenium,ajxampmSuggestBox1,"am");
					 
					 assertTrue(type(selenium,txtEndHour,lhour.endHour),"Could enter End hour", selenium, ClassName, MethodName);
					 assertTrue(type(selenium,txtEndMin,lhour.endMin),"Could enter End Min", selenium, ClassName, MethodName);
					 
					 selectValueFromAjaxList(selenium,ajxampmSuggestBox2,"pm");
					 
					 if(isChecked(selenium,btnallowHolidayBookingcheckbox)){
							click(selenium,btnallowHolidayBookingcheckbox);
					 }
					 if(isChecked(selenium,chkclosedWeekendscheckbox)){
							click(selenium,chkclosedWeekendscheckbox);
					 }
					 
					 assertTrue(click(selenium, btnsaveLocationHours), "could not able to click SaveLocatioHours", selenium, ClassName, MethodName);
					 waitForPageLoad(selenium);
					 
					 
					 return true;
				}
			 	 /**
				 * createNewNonProviderResourceRoomPortability
				 * function to create New Non Provider Resource Room
			 	 * @throws IOException 
				 * @since  	     June 06, 2013
			 */	
			 public boolean createNewNonProviderResourceRoomPortability(Selenium selenium, SchedulingTestLib nonProvider) throws IOException {
					 					 
				 
					
					 assertTrue(type(selenium, txtRoomName, nonProvider.roomName), "Could not type the Room name", selenium, ClassName, MethodName);
					 selectValueFromAjaxList(selenium, ajxlocation, nonProvider.location);
					
					if(nonProvider.testCaseId.equals("TC_NPR_001")){
						click(selenium,icnColourYellow);
					}
					if(nonProvider.testCaseId.equals("TC_NPR_002")){
						click(selenium,icnColourBlue);
					}
					if(nonProvider.testCaseId.equals("TC_NPR_003")){
						click(selenium,icnColourRed);
					}
					if(nonProvider.testCaseId.equals("TC_NPR_004")){
						click(selenium,icnColourPink);
					}
					 assertTrue(click(selenium, btnSaveNonProviderResource), "Could not click the save button", selenium, ClassName, MethodName);
					 
					 if(!isElementPresent(selenium, btnAddNonProviderResource)){
						 return false;
					 } 
					 return true;
			 }
			 /**
				 * createNewNonProviderResourceEquipPort Room
				 * function to create New Non Provider Resource Room
			 * @throws IOException 
				 * @since  	     June 19, 2013
			 */	
			 public boolean createNewNonProviderResourceEquipPort(Selenium selenium, SchedulingTestLib nonProvider) throws IOException {
					 					 
				 
					
						assertTrue(type(selenium, txtRoomName, nonProvider.equipmentName), "Could not type the Equipment name", selenium, ClassName, MethodName);
						// Check is the Mobility is Stationary or MultiLocation				
						if(nonProvider.mobilitystat.equals("yes")){
						
						assertTrue(click(selenium, rdoMobilityNonProviderEquipStationary), "could not able to click radio button for Stationary", selenium, ClassName, MethodName);					
						selectValueFromAjaxList(selenium, ajxlocation, nonProvider.location);	
							
						} else {					
					    assertTrue(click(selenium, rdoMobilityNonProviderEquipMultiLocation), "could not able to click radio button for Multi-Locations", selenium, ClassName, MethodName);
						}
					 
					 
					 assertTrue(click(selenium, btnSaveNonProviderResource), "Could not click the save button", selenium, ClassName, MethodName);
					 
					 if(!isElementPresent(selenium, btnAddNonProviderResource)){
						 return false;
					 } 
					 return true;
			 }
			 
			 /**
				 * createNewNonProviderResourceStaffPort Room
				 * function to create New Non Provider Resource Room
			 * @throws IOException 
				 * @since  	     June 06, 2013
			 */	
			 public boolean createNewNonProviderResourceStaffPort(Selenium selenium, SchedulingTestLib nonProvider) throws IOException {
					 					 
				 
						// Add new Resource - Support Staff
					
						 assertTrue(type(selenium, txtSupportStaffName, nonProvider.staffName), "Could not type the Support Staff Name", selenium, ClassName, MethodName);
						 selectValueFromAjaxList(selenium, ajxlocation, nonProvider.location);
					 
					 waitForPageLoad(selenium);
					 assertTrue(click(selenium, btnSaveNonProviderResource), "Could not click the save button", selenium, ClassName, MethodName);
					 
					 if(!isElementPresent(selenium, btnAddNonProviderResource)){
						 return false;
					 } 
					 return true;
			 }
	/**
	* createVisitGroupPortability Room
	* function to create Visit Group Portability
	 * @throws IOException 
	* @since  	     June 20, 2013
	*/
			 
	public boolean createVisitGroupPortability(Selenium selenium,SchedulingTestLib visitGroupData)  {
		 boolean returnValue=false;
		try{
			assertTrue(click(selenium,btnAdd),"Could not click on add new button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtGroupName,visitGroupData.groupName),"Could not enter the group name", selenium, ClassName, MethodName);
			 assertTrue(type(selenium,txtSearch,visitGroupData.visitName),"Could not enter the visit type ", selenium, ClassName, MethodName);
			 assertTrue(click(selenium,btnSearch),"could not click on the search button", selenium, ClassName, MethodName);
			 assertTrue(click(selenium,chkViistType),"Cpuld not click on the check box", selenium, ClassName, MethodName);
			 
			 if(visitGroupData.testCaseId.equals("TC_VG_001")){
				 assertTrue(click(selenium,chkGreenColor),"Could not click on the color", selenium, ClassName, MethodName);
			 }
			assertTrue(click(selenium,btnSave),"Could not click the save button", selenium, ClassName, MethodName);
			 returnValue=true;
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
	
	
	public boolean searchCurrentPractice(Selenium selenium,SchedulingTestLib lHour, boolean check) throws IOException{
		boolean returnValue=true;
		int possition=1;		
		assertTrue(click(selenium,chkIncludeInactivescheckbox),"Could not click on System settings link:" + lHour .toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//if number of programs not exist more than ten means, text box will not be appear.
		if((getText(selenium, btnSearchButton)).equalsIgnoreCase("Search")){
			assertTrue(type(selenium,btnSearchTextBox,lHour.practiceName ),"Could not click on System settings link:" + lHour .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSearchButton),"Could not click on System settings link:" + lHour .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}
		else{
			//So, We use loop to find the position of program in the displayed list
			String proCount=getText(selenium,"//td[2]/div/div/div/div[2]/div/div/div/div/span/span/span");
			int progCount=Integer.parseInt(proCount.replaceAll(".*\\(|\\).*", ""));					
			for(int count=1;count<=progCount;count++){
				
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(lHour.practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){		
					
					possition=count;							
					break;
				}
			}
		}
		
		//after finding possition, verify the practice name
		if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+possition+"]/td/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(lHour.practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){
			//to check the practice name active/in active
			if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+possition+"]/td/div").toLowerCase(new java.util.Locale("en","US")).trim().contains("Inactive".trim().toLowerCase(new java.util.Locale("en","US")))){
				assertTrue(click(selenium,"//div[@id='practices']/table/tbody/tr["+possition+"]/td[2]/div/a"),"Could not click on activate link:" + lHour .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
			}
			if(getText(selenium, "//div[@id='practices']/table/tbody/tr["+possition+"]/td[2]/div/a").equalsIgnoreCase("Delete")){
				//Verify presence of Location's
				assertTrue(click(selenium,"//div[@id='practices']/table/tbody/tr["+possition+"]/td/div"),"Could not click on practice:" + lHour .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				if(getText(selenium, lblResultPractice).contains(lHour.location1)){
					assertTrue(click(selenium, "edit"),"Practice Creation Failed", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					
					if(check){
						if(!isChecked(selenium, chk24HourFormat))
							click(selenium, chk24HourFormat);
					}
					else{
						if(isChecked(selenium, chk24HourFormat))
							click(selenium, chk24HourFormat);
					}
					
					
				}
				returnValue=false;
			}
			else{
				returnValue = true;
			}
		}					
		click(selenium, "save");
		
		return returnValue;
	}
	
	/**
	* goToTimeLine
	* function to goToTimeLine
	 * @throws IOException 
	* @since  Sep 20,2013
	*/
			 
	public boolean goToTimeLine(Selenium selenium) throws IOException{
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkPatientOption),"Could not click the patient option link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent("View Registration"),"The text is not present", selenium, ClassName, MethodName);
		assertTrue(click(selenium,lnkViewRegistration),"could not click the View Registraction",selenium, ClassName, MethodName);
		if(!isElementPresent(selenium,lnkPatientTimeLine)){
			return false;
		}else
		return true;
		
	}
	
	
	/**
	* goToRegisterPatient
	* function to goToRegisterPatient
	 * @throws IOException 
	* @since  Sep 20,2013
	*/
	public boolean goToRegisterPatient(Selenium selenium) throws IOException{
		assertTrue(click(selenium,lnkQuickAction),"could not click the Qucik action", selenium, ClassName, MethodName);
		assertTrue(click(selenium,lnkRegisterPatient),"could not click the register patient link", selenium, ClassName, MethodName);
		if(!isElementPresent(selenium,txtLastName)){
			return false;
		}else
			return true;
	}
	
	/**
	 * createNewPatientWithMandatory
	 * function to create New Patient With Mandatory
	 * @throws IOException 
	 * @since  	     Feb 09, 2012
	 */	
	public boolean createNewPatientWithMandatory(Selenium selenium, SchedulingTestLib patientData) throws IOException{
		boolean returnValue = false;
		try{
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtLastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtFirstName,patientData.firstName),"Could not type the first Name : More Details"+patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium, txtDOB, patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob, selenium, ClassName, MethodName);
            if(isElementPresent(selenium,noDuplicationBtn))
			{
				assertTrue(click(selenium,noDuplicationBtn),"Unable to click the not same patient button",selenium,ClassName,MethodName);
			}
			click(selenium,btnBack);
			assertTrue(click(selenium,chkPremature),"Could not click prematurecheck box : More Details"+patientData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxPrematureDuration,patientData.duration);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxPrematureMeasure,patientData.measure);
			selectValueFromAjaxList(selenium,ajxStatus,patientData.status);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxPhoneType,patientData.phoneType);
			assertTrue(type(selenium,txtPhonNo,patientData.phoneNo),"Could not type the Phone No : More Details"+patientData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtExtnNo,patientData.extnNo),"Could not type the Extn no : More Details"+patientData.toString(), selenium, ClassName, MethodName);
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
	 * goToOperationsSection
	 * function to Operations section
	 * @throws IOException 
	 * @since  	    Jun 20, 2013
	 */	
	
	public boolean goToCalender(Selenium selenium) throws IOException{
		
		assertTrue(click(selenium,lnkQuickAction),"Could not click the link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium,lnkOperations),"Could not find the Operations link", selenium, ClassName, MethodName);
		assertTrue(click(selenium,lnkOperations),"Could not click Operations link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
	

	/**
	 * verifyPatientDetails
	 * function to verify Patient Details
	 * @throws IOException 
	 * @since  	    Sep 23, 2013
	 */	
	
	
	public boolean verifyPatientDetails(Selenium selenium,SchedulingTestLib patientTimeLineData , String providerName, String location) throws IOException{
		
		/*if(!getText(selenium,lblvisitDetails).contains(providerName)){
			return false;
		}if(!getText(selenium,lblvisitDetails).contains(location)){
			return false;
		}*/
		if(!selenium.isTextPresent(providerName)){
			return false;
		}
		if(!selenium.isTextPresent(location)){
			return false;
		}
		assertTrue(getValue(selenium,aJxPhoneType).contains(patientTimeLineData.phoneType),"Verification Failed",selenium, ClassName, MethodName);
		System.out.println(getValue(selenium,"css=input.textboxHeight20.marginLeft5"));
		System.out.println(patientTimeLineData.phoneNoFormat);
		assertTrue(getValue(selenium,"css=input.textboxHeight20.marginLeft5").contains(patientTimeLineData.phoneNoFormat),"Verification Failed",selenium, ClassName, MethodName);
		
		return true;
	}
	
	/**
	 * verifyPatientTimeLine
	 * function to verify Patient Time Line
	 * @since  	    Sep 23, 2013
	 */	
	
	public boolean verifyPatientTimeLine(Selenium selenium,SchedulingTestLib patientTimeLineData , String providerName, String location) throws IOException{
		
		assertTrue(getText(selenium,lblPatientTimeLine).contains(providerName),"Verification Failed",selenium, ClassName, MethodName);
		
		/*if(!getText(selenium,lblPatientTimeLine).contains(location)){
			return false;
		}*/
		
		assertTrue(click(selenium,lblPatientTimeLine),"Could not click the time line", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(getText(selenium,lblExpandPatientTimeLine).contains("To be confirmed"),"Verification Failed",selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblExpandPatientTimeLine).contains("Scheduled"),"Verification Failed",selenium, ClassName, MethodName);
		return true;
	}
	
	/**
	 * editVisitPatientTimeLine
	 * function to edit Visit Patient Time Line
	 * @throws IOException 
	 * @since  	    Sep 23, 2013
	 */	
	
	public boolean editVisitPatientTimeLine(Selenium selenium, SchedulingTestLib patientTimeLineData) throws IOException{
		
		selectValueFromAjaxList(selenium,ajxTimeLineVisitStatus,patientTimeLineData.editVisitType);
		selectValueFromAjaxList(selenium,ajxTimeLineReferredBy,patientTimeLineData.referredBy);
		assertTrue(type(selenium,txtTimeLineDuration,patientTimeLineData.duration),"could not enter the duration", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtTimeLineComment,patientTimeLineData.comments),"could not enter the duration", selenium, ClassName, MethodName);
		assertTrue(click(selenium,"//div[3]/div/div[2]/div/div[2]/a"),"could not click the save button", selenium, ClassName, MethodName);
		if(!isElementPresent(selenium,lnkAction)){
			return false;
		}else
			return true;
	}
	
	/**
	 * unitTestForPDGAdmin
	 * function to unit Test For PDG Admin
	 * @throws IOException 
	 * @since  	    Oct 15, 2013
	 */	
	
	
	public boolean unitTestForPDGAdmin(Selenium selenium, SchedulingUnitTestLib pdgAdminData) throws IOException{
		
		if(pdgAdminData.testCaseId.equals("TC_PDG_001")){
			selectValueFromajxListForUnit(selenium,ajxProgramType,pdgAdminData.programType1);
		}
		assertTrue(type(selenium,txtgroupName,pdgAdminData.groupName),"Group name is empty", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtDescription,pdgAdminData.description),"could not enter the description", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtprogramPlan,pdgAdminData.plan),"could not enter the Paln", selenium, ClassName, MethodName);
		assertTrue(click(selenium,btnSaveProgramGroup), "Could not click save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}


	/**
	 * deleteProgramForPDGAdmin
	 * function to delete Program For PDG Admin
	 * @throws IOException 
	 * @since  	    Oct 18, 2013
	 */	
	
	public boolean deleteProgramForPDGAdmin(Selenium selenium, SchedulingTestLib pDGData ) throws IOException{
		waitForPageLoad(selenium);
		boolean programGroupDeleted=true;
		int programCount=0; 
		try{
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			
			while((Integer) selenium.getXpathCount(lnkProgramAction) > 0){
				programCount=(Integer) selenium.getXpathCount(lnkProgramAction);
				click(selenium,lnkXmark);
				assertTrue(click(selenium,lnkProgramAction),"", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkProgramDelete),"", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(selenium.isTextPresent("Are you sure you want to delete this record?"),"Are you sure you want to delete this record? message is not getting displayed", selenium, ClassName, MethodName);
				if(pDGData.testCaseId.equals("TC_PDG_011")){
					assertTrue(click(selenium,lnkNo),"Could not click Delete button;More Details:", selenium, ClassName, MethodName);
				}else
				assertTrue(click(selenium,lnkYes),"Could not click Delete button;More Details:", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			return programGroupDeleted;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return programGroupDeleted;
	}
	
	
	/**
	 * createProgramForPDGAdmin
	 * function to create Program For PDG Admin
	 * @throws IOException 
	 * @since  	    Oct 18, 2013
	 */	
	
	public boolean createProgramForPDGAdmin(Selenium selenium, SchedulingTestLib pdgAdminData, String uniqueName) throws IOException{
		int count =0;
		if(pdgAdminData.programType.equals("Personal Development")){
			pdgAdminData.groupName = pdgAdminData.groupName + uniqueName;
			assertTrue(type(selenium,txtgroupName,pdgAdminData.groupName),"Group name is empty", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtDescription,pdgAdminData.description),"could not enter the description", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtprogramPlan,pdgAdminData.plan),"could not enter the Paln", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkgroupObjective),"Could not click group Objetive",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!isChecked(selenium,chkGroupObjective)){
				assertTrue(click(selenium,chkGroupObjective),"Could not check the Group Objective",selenium, ClassName, MethodName);
				Intendedpopulation[count++]=getText(selenium,lblGroupObjective);
				assertTrue(click(selenium,imgGroubObjective),"Could not click the close icon for Group objective",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,lnkplannedActivite),"Could not click planned Activite",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!isChecked(selenium,chkPlannedActivities)){
				assertTrue(click(selenium,chkPlannedActivities),"Could not check the Palanned Activite check box",selenium, ClassName, MethodName);
				Intendedpopulation[count++]=getText(selenium,lblPlannedActivite);
				assertTrue(click(selenium,imgPlanClose),"Could not click the close icon for Plan Activite",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			
			assertTrue(click(selenium,lnkageGroup),"Could not click link Age Group",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!isChecked(selenium,chkAgeGroups)){
				assertTrue(click(selenium,chkAgeGroups),"Could not check the Age Group Check box",selenium, ClassName, MethodName);
				Intendedpopulation[count++]=getText(selenium,lblAge);
				assertTrue(click(selenium,imgPlanClose),"Could not click the close icon for age",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			
			assertTrue(click(selenium,lnkGender),"Could not click link Gender",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!isChecked(selenium,chkGender)){
				assertTrue(click(selenium,chkGender),"Could not check the Palanned Activite check box",selenium, ClassName, MethodName);
				Intendedpopulation[count++]=getText(selenium,lblgender);
				assertTrue(click(selenium,imgPlanClose),"Could not click the close icon for Gender",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(click(selenium,lnkPrimary),"Could not click Primary",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtPrimary,pdgAdminData.language),"Could not type Primary",selenium, ClassName, MethodName);
			if(!isChecked(selenium,chkPrimary)){
				assertTrue(click(selenium,chkPrimary),"Could not check the Primary check box",selenium, ClassName, MethodName);
				Intendedpopulation[count++]=getText(selenium,lblPrimary);
				assertTrue(click(selenium,imgPlanClose),"Could not click the close icon for Primary",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}

			assertTrue(click(selenium,lnkCulture),"Could not click Culture link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtPrimary,pdgAdminData.culture),"Could not type Culture",selenium, ClassName, MethodName);
			if(!isChecked(selenium,chkCulture)){
				assertTrue(click(selenium,chkCulture),"Could not check the culture check box",selenium, ClassName, MethodName);
				Intendedpopulation[count++]=getText(selenium,lblCulture);
				assertTrue(click(selenium,imgPlanClose),"Could not click the close icon for culture",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			
			
			assertTrue(click(selenium,inkRole),"Could not click role link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!isChecked(selenium,chkRole)){
				assertTrue(click(selenium,chkRole),"Could not check the Role check box",selenium, ClassName, MethodName);
				Intendedpopulation[count++]=getText(selenium,lblRole);
				assertTrue(click(selenium,imgPlanClose),"Could not click the close icon for Role",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			
			assertTrue(click(selenium,lnkphysical),"Could not click physical link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!isChecked(selenium,chkPhysical)){
				assertTrue(click(selenium,chkPhysical),"Could not check the Physical check box",selenium, ClassName, MethodName);
				Intendedpopulation[count++]=getText(selenium,lblPhysical);
				assertTrue(click(selenium,imgPlanClose),"Could not click the close icon for Physical",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
	
			assertTrue(click(selenium,lnkSocial),"Could not click link Social",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!isChecked(selenium,chkSocial)){
				assertTrue(click(selenium,chkSocial),"Could not check the Physical check box",selenium, ClassName, MethodName);
				Intendedpopulation[count++]=getText(selenium,lblSocial);
				assertTrue(click(selenium,imgPlanClose),"Could not click the close icon for Social",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
		

		}else{
			assertTrue(type(selenium,txtgroupName,pdgAdminData.groupName+uniqueName),"Group name is empty", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtDescription,pdgAdminData.description),"could not enter the description", selenium, ClassName, MethodName);
		}
		if(pdgAdminData.testCaseId.equals("TC_PDG_005")){
			assertTrue(click(selenium,btnCancelProgramGroup), "Could not click cancel button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//assertTrue(click(selenium,lnkCancelNo), "Could not click No button", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
		}else if((pdgAdminData.testCaseId.equals("TC_PDG_009"))|| (pdgAdminData.testCaseId.equals("TC_PDG_010")||(pdgAdminData.testCaseId.equals("TC_PDG_012")))
				|| (pdgAdminData.testCaseId.equals("TC_PDG_016"))){
			assertTrue(click(selenium,btnSaveProgramGroup), "Could not click save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkYes), "Could not click Yes button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}else if((pdgAdminData.testCaseId.equals("TC_PDG_013"))||(pdgAdminData.testCaseId.equals("TC_PDG_014"))
				||(pdgAdminData.testCaseId.equals("TC_PDG_015"))||(pdgAdminData.testCaseId.equals("TC_PDG_017")) ||(pdgAdminData.testCaseId.equals("TC_PDG_018"))){
            assertTrue(click(selenium,lnkVisitType), "Could not click visit type link", selenium, ClassName, MethodName);
            waitForPageLoad(selenium);
        }else if((pdgAdminData.testCaseId.equals("TC_PDG_019"))||(pdgAdminData.testCaseId.equals("TC_PDG_020"))||(pdgAdminData.testCaseId.equals("TC_PDG_021"))){
          return true;
        }else if((pdgAdminData.testCaseId.equals("TC_PDG_022"))||(pdgAdminData.testCaseId.equals("TC_PDG_023"))||(pdgAdminData.testCaseId.equals("TC_PDG_024"))
        		||(pdgAdminData.testCaseId.equals("TC_PDG_025"))){
        	assertTrue(click(selenium,btnSaveProgramGroup), "Could not click save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
          return true;
        }
		else{
			assertTrue(click(selenium,btnSaveProgramGroup), "Could not click save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkNo), "Could not click No button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
			return true;
	}
	
	/**
	 *verifyStoreValueInPGSummary
	 * function to verify Store Value In PGSummary
	 * @throws IOException 
	 * @since  	    Oct 22, 2013
	 */	
	
	public boolean verifyStoreValueInPGSummary(Selenium selenium, SchedulingTestLib pdgAdminData, String uniqueName, String account) throws IOException{
		String date = null;
		String time =null;

		assertTrue(getText(selenium,lblPGCollapsableView).contains(pdgAdminData.groupName),"Verification Failed",selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblPGCollapsableView).contains(pdgAdminData.description),"Verification Failed",selenium, ClassName, MethodName);
		
		assertTrue(click(selenium,lblPGCollapsableView),"Could not click the Expand arrow", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblPGExpandView).contains(Intendedpopulation[0]),"Verification Failed",selenium, ClassName, MethodName);
	
		assertTrue(getText(selenium,lblPGExpandView).contains(pdgAdminData.plan),"Verification Failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPGExpandView).contains(Intendedpopulation[1]),"Verification Failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPGExpandView).contains(Intendedpopulation[2]),"Verification Failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPGExpandView).contains(Intendedpopulation[3]),"Verification Failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPGExpandView).contains(Intendedpopulation[4]),"Verification Failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPGExpandView).contains(Intendedpopulation[5]),"Verification Failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPGExpandView).contains(Intendedpopulation[6]),"Verification Failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPGExpandView).contains(Intendedpopulation[7]),"Verification Failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPGExpandView).contains(Intendedpopulation[8]),"Verification Failed",selenium, ClassName, MethodName);
		
		if(account.equals(CAAccount)){
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			date=DateFormat1.format(cal1.getTime());
			 DateFormat1=new SimpleDateFormat("HH");
			 time=DateFormat1.format(cal1.getTime());
		}else{
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
			 date=DateFormat1.format(cal1.getTime());
			 DateFormat1=new SimpleDateFormat("HH");
			 time=DateFormat1.format(cal1.getTime());
			}
		
		String providerNameTemp= getText(selenium, lnkTopMenu);
		String providerName= providerNameTemp.replaceAll(", FULL", "");
		
		assertTrue(getText(selenium,lblPGExpandView).contains("Last updated by " + providerName + " at " + time ),"Verification Failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPGExpandView).contains( " on " + date  ),"Verification Failed",selenium, ClassName, MethodName);
		
		return true;
	}
	
	/**
	 * createScheduleSerieswithPersonalType
	 * function to createScheduleSerieswithPersonalType
	 * @throws IOException 
	 * @since  	    Oct 23, 2013
	 */	
	
	public boolean createScheduleSerieswithPersonalType(Selenium selenium,SchedulingTestLib seriesData, String uniqueName,String providerName, String location,String account) throws IOException{
		String time = null;
		String timeFormat = null;
		String date = null;
		
		assertTrue(type(selenium,txtSeriesName, seriesData.seriesName),"Could not enter the series", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtGroup, seriesData.groupsize),"Could not enter the series", selenium, ClassName, MethodName);
		selectValueFromAjaxList(selenium,ajxSeriesTriggered,seriesData.seriesTrigger);
		System.out.println();
		
		
		selectValueFromAjaxList(selenium,ajxGroupCoordinator,providerName);
		
		if(!isChecked(selenium,chkConfirmVisitSeries)){
			assertTrue(click(selenium,chkConfirmVisitSeries),"Could not click the Visit check box", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtCVDays, seriesData.visitDate),"Could not enter the visit Days", selenium, ClassName, MethodName);
		}
		
		if(!isChecked(selenium,chkAllowOnly)){
			assertTrue(click(selenium,chkAllowOnly),"Could not click the allow check box", selenium, ClassName, MethodName);
		}
		
		if(!isChecked(selenium,chkJoin)){
			assertTrue(click(selenium,chkJoin),"Could not click the allow check box", selenium, ClassName, MethodName);
		}
		
		if(!isChecked(selenium,chkAllowDrop)){
			assertTrue(click(selenium,chkAllowDrop),"Could not click the allow check box", selenium, ClassName, MethodName);
		}
		
		selectValueFromAjaxList(selenium,ajxLocationType,seriesData.taskPlace);
		
		
		selectValueFromAjaxList(selenium,ajxLocation,location);
		
		
		//Time Calculation
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("mm");
		String time1=DateFormat.format(cal.getTime());
		
		SimpleDateFormat DateFormat1=new SimpleDateFormat("hh");
		
		
		SimpleDateFormat DateFormat2=new SimpleDateFormat("hh");
	/*	cal.setTime(date);
		cal.add(cal.HOUR, 1);*/
		cal.add(cal.HOUR_OF_DAY, 1);
		String timeValue = DateFormat2.format(cal.getTime());
		
		
		//int minutes=Integer.parseInt(time);
		//int hours=Integer.parseInt(time1);
		
		if(seriesData.recurringDate.equals("Yes")){
			assertTrue(click(selenium,chkUseRecurring),"Could not click the Recurring check box", selenium, ClassName, MethodName);
			
			
			if(cal.get(Calendar.AM_PM)==0){
				timeFormat = "am";
			}else{
				timeFormat = "pm";
			}
				
				
			if((timeFormat =="am")&&(timeValue=="11") ){
				selectValueFromAjaxList(selenium,ajxForAmPMSeries,"pm");
			}else if((timeFormat =="pm")&&(timeValue=="11") ){
				selectValueFromAjaxList(selenium,ajxForAmPMSeries,"am");
			}else
				selectValueFromAjaxList(selenium,ajxForAmPMSeries,timeFormat);
				
			/*else{
				cal.add(minutes, 5);
				String min = String.valueOf(minutes);
				assertTrue(type(selenium,txtrecurringMin,min),"Could not click the daily check box", selenium, ClassName, MethodName);
			}*/
			cal.add(Calendar.HOUR,1);
			time = DateFormat1.format(cal.getTime());
			
			assertTrue(type(selenium,txtrecurringTime,time),"Could not click the daily check box", selenium, ClassName, MethodName);
			
			if(seriesData.daily.equals("Yes")){
				assertTrue(click(selenium,chkdaily),"Could not click the daily check box", selenium, ClassName, MethodName);
			}
			
			if(seriesData.weekly.equals("Yes")){
				assertTrue(click(selenium,chkWeekly),"Could not click the weekly check box", selenium, ClassName, MethodName);
				assertTrue(click(selenium,chkday),"Could not click the days check box", selenium, ClassName, MethodName);

			}
			if(seriesData.monthly.equals("Yes")){
				assertTrue(click(selenium,chkMonthly),"Could not click the Monthly check box", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajxDateOfMonth,"5");
				
			}
			if(seriesData.yearly.equals("Yes")){
				assertTrue(click(selenium,chkYearly),"Could not click the Yearly check box", selenium, ClassName, MethodName);
			}
			
			if(seriesData.end.equals("Yes")){
				assertTrue(click(selenium,chkAfter),"Could not click the after check box", selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtOccurence, seriesData.endOccurence),"Could not enter the Occurence text", selenium, ClassName, MethodName);
			}
			
			if(seriesData.endDate.equals("Yes")){
				assertTrue(click(selenium,chkDate),"Could not click the after check box", selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtEndDate, seriesData.recurrenceDate),"Could not enter the Occurence text", selenium, ClassName, MethodName);
			}
			assertTrue(type(selenium,txtDuration, seriesData.duration1),"Could not enter the Duration text", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxduration,seriesData.duration);

		}
		
		//Date Calculation
		if(seriesData.individualDate.equals("Yes")){
			assertTrue(click(selenium,chkIndividual),"Could not click the individual Date check box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//String timeValue1=timeValue+1;
			assertTrue(type(selenium,txtIndividualHour1,timeValue),"Could not enter the time", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxTimeDuration,seriesData.duration);
			
			System.out.print(cal.get(Calendar.AM_PM));
			
			if(cal.get(Calendar.AM_PM)==0){
				timeFormat = "am";
			}else{
				timeFormat = "pm";
			}	
			if((timeFormat.equalsIgnoreCase("am"))&&(timeValue.equalsIgnoreCase("11")) ){
			    
				selectValueFromAjaxList(selenium,ajxForAmPMSeries,"pm");
			}else if((timeFormat =="pm")&&(timeValue=="11") ){
				selectValueFromAjaxList(selenium,ajxForAmPMSeries,"am");
			}else
				selectValueFromAjaxList(selenium,ajxForAmPMSeries,timeFormat);
			
			if(seriesData.testCaseId.equals("TC_SS_007")){
				selectValueFromAjaxList(selenium,"individualStartTime_1-ampmsuggestBox",timeFormat);
			}
			
			if(seriesData.testCaseId.equals("TC_SS_010")){
				assertTrue(click(selenium,lnkIndividualDateAddMore),"Could not click add More button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				if(account.equals(CAAccount)){
					Calendar cal1=Calendar.getInstance();
					SimpleDateFormat DateFormat4=new SimpleDateFormat("dd/MM/yyyy");
					  date=DateFormat4.format(cal1.getTime());
					 
				}else{
				SimpleDateFormat DateFormat3=new SimpleDateFormat("MM/dd/YYYY");
				cal.add(Calendar.DATE,1);
				
				date = DateFormat3.format(cal.getTime());
				}	assertTrue(enterDate(selenium,txtIndividualDate1,date),"Could not enter the date", selenium, ClassName, MethodName);		
					assertTrue(enterDate(selenium,txtIndividualDate,date),"Could not enter the date", selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtIndividualHour,timeValue),"Could not enter the time", selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtIndividualMin,"50"),"Could not enter the mins", selenium, ClassName, MethodName);
					
					
					if((timeFormat =="am")&&(timeValue=="11") ){
						selectValueFromAjaxList(selenium,"individualStartTime_2-ampmsuggestBox","pm");
					}else if((timeFormat =="pm")&&(timeValue=="11") ){
						selectValueFromAjaxList(selenium,"individualStartTime_2-ampmsuggestBox","am");
					}else
						selectValueFromAjaxList(selenium,"individualStartTime_2-ampmsuggestBox",timeFormat);

					selectValueFromAjaxList(selenium,ajxInTimeDuration,seriesData.duration);
				}
			}
		if(!seriesData.testCaseId.equals("TC_SS_010"))
			assertTrue(click(selenium,btnSeriesNext),"Could not click the next button", selenium, ClassName, MethodName);
		return true;
	}

	/**
	 * verifyStoreScheduleSeriesValueInSummary
	 * function to verify Store Schedule Series Value In Summary
	 * @throws IOException 
	 * @since  	    Oct 15, 2013
	 */	
	
	public boolean verifyStoreScheduleSeriesValueInSummary(Selenium selenium,SchedulingTestLib seriesData,String providerName, String location, String account) throws IOException{
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat;
		String startDate;
		String enddate;
		
		if(account.equals(CAAccount)){
		/*	if(cal.DATE<10){
				DateFormat =new SimpleDateFormat("MMM d, yyyy");
			}else{
				DateFormat =new SimpleDateFormat("MMM dd, yyyy");
			}
			
			startDate=DateFormat.format(cal.getTime());
			cal.add(Calendar.DATE,Integer.valueOf(seriesData.endOccurence)-1);
			
			enddate = DateFormat.format(cal.getTime());  */
			DateFormat=new SimpleDateFormat("MMM d, yyyy");
			startDate = DateFormat.format(cal.getTime());
			cal.add(Calendar.DATE, 1);
			enddate = DateFormat.format(cal.getTime());
			 
		}else{
			DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			startDate = DateFormat.format(cal.getTime());
			enddate = DateFormat.format(cal.getTime());
		}
		
		
		assertTrue(selenium.isTextPresent(seriesData.seriesName), "" + "Series Name Not Present", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
			
		
		if(seriesData.testCaseId.equals("TC_SS_001")){
			//Adding dates verified here
			assertTrue(selenium.isTextPresent(startDate + " to " + enddate +"\n"), "" + "startDate to EndDate Not Present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			assertTrue(selenium.isTextPresent(seriesData.duration), "" + "Series Duration Not Present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);					
			
			assertTrue(selenium.isTextPresent(seriesData.duration1), "" + "Series Duration Not Present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
						
		}
		
		if(seriesData.testCaseId.equals("TC_SS_002")){
			startDate=enddate;
				assertTrue(selenium.isTextPresent(startDate+" " +"to"+" "+ enddate), "" + "startDate to EndDate Not Present", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		assertTrue(selenium.isTextPresent(providerName), "" + "providerName Not Present", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		return true;
		
	}

	/**
	 * unitTestForScheduleSeries
	 * function to unit Test For Schedule Series
	 * @throws IOException 
	 * @since  	    Oct 15, 2013
	 */	
	

	public boolean unitTestForScheduleSeries(Selenium selenium, SchedulingUnitTestLib pdgAdminData) throws IOException{
		assertTrue(type(selenium,txtSeriesName,pdgAdminData.seriesName),"Could not enter Series name", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtGroup,pdgAdminData.gorupSize),"could not enter the description", selenium, ClassName, MethodName);

		if(pdgAdminData.useRecurringDate.equals("Yes")){
			
			assertTrue(click(selenium,chkUseRecurring),"Could not click the Recurring check box", selenium, ClassName, MethodName);

			
			
			if(pdgAdminData.daily.equals("Yes")){
				assertTrue(click(selenium,chkdaily),"Could not click the daily check box", selenium, ClassName, MethodName);
			}
			
			if(pdgAdminData.weekly.equals("Yes")){
				assertTrue(click(selenium,chkWeekly),"Could not click the weekly check box", selenium, ClassName, MethodName);
				assertTrue(click(selenium,chkday),"Could not click the days check box", selenium, ClassName, MethodName);

			}
			if(pdgAdminData.monthly.equals("Yes")){
				assertTrue(click(selenium,chkMonthly),"Could not click the Monthly check box", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajxDateOfMonth,"5");
				
			}
			if(pdgAdminData.yearly.equals("Yes")){
				assertTrue(click(selenium,chkYearly),"Could not click the Yearly check box", selenium, ClassName, MethodName);
			}
			
			if(pdgAdminData.end.equals("Yes")){
				assertTrue(click(selenium,chkAfter),"Could not click the after check box", selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtOccurence, pdgAdminData.occurrence),"Could not enter the Occurence text", selenium, ClassName, MethodName);
				
			}
			
			if(pdgAdminData.endAfter.equals("Yes")){
				assertTrue(click(selenium,chkDate),"Could not click the after check box", selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtEndDate, pdgAdminData.endDate),"Could not enter the Occurence text", selenium, ClassName, MethodName);
			}
			assertTrue(type(selenium,txtDuration, pdgAdminData.duration),"Could not enter the Duration text", selenium, ClassName, MethodName);
			
		}
		
		if(pdgAdminData.individualDates.equals("Yes")){
			assertTrue(click(selenium,chkIndividual),"Could not click the individual Date check box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(enterDate(selenium,txtIndividualDate1,pdgAdminData.startDate),"Could not enter the date", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtInDuration, pdgAdminData.duration),"Could not enter the Duration text", selenium, ClassName, MethodName);
			
				
			}
		
		
		assertTrue(click(selenium,btnSeriesNext), "Could not click save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	
	
	/**
     * addStaff
     * function to addStaff
     * @throws IOException 
     * @since      Oct 24, 2013
     */   
    public boolean addStaff(Selenium selenium,SchedulingTestLib staffData, String providerName) throws IOException{
          if(staffData.interalStaff.equals("Yes")){
               // assertTrue(click(selenium,"name=addNewStaff"),"Could not click External button button", selenium, ClassName, MethodName);
                selectValueFromAjaxList(selenium,ajxRole,staffData.role);
                selectValueFromAjaxList(selenium,txtStaff,providerName);
                if(!staffData.testCaseId.equals("TC_SS_017")){
                      assertTrue(click(selenium,lblStaff),"could not click the staff name", selenium, ClassName, MethodName);
                }
          }
          if(staffData.externalStaff.equals("Yes")){
                assertTrue(click(selenium,chkExternal),"Could not click External button button", selenium, ClassName, MethodName);
                selectValueFromAjaxList(selenium,ajxRoleExternalStaff,staffData.role);
                assertTrue(type(selenium,txtFirstName,"first" ),"Could not enter the first name", selenium, ClassName, MethodName);
                assertTrue(type(selenium,txtLastNanme,"last" ),"Could not enter the Last name", selenium, ClassName, MethodName);
                assertTrue(type(selenium,txtcredentials,staffData.credential ),"Could not enter the credentials name", selenium, ClassName, MethodName);
                assertTrue(click(selenium,lnkbtnExternalAdd),"Could not click add new button",selenium,ClassName,MethodName);
                waitForPageLoad(selenium);
          }
          
          if(staffData.testCaseId.equals("TC_SS_017")){
                assertTrue(click(selenium,btnCancel),"Could not click add new button",selenium,ClassName,MethodName);
                waitForPageLoad(selenium);
          }
          
          return true;
    }

	
	/**
	 * unitTestForAddStaff
	 * function to unit Test For Add Staff
	 * @throws IOException 
	 * @since  	    Oct 26, 2013
	 */	
	
	public boolean unitTestForAddStaff(Selenium selenium,SchedulingUnitTestLib staffData) throws IOException{
		assertTrue(click(selenium,btnAdd),"Could not click add new button",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		if(!isChecked(selenium,chkExternal)){
			assertTrue(click(selenium,chkExternal),"Could not click External button button", selenium, ClassName, MethodName);
			if(staffData.testCaseId.equals("TC_SS_002")){
				assertTrue(type(selenium,txtFirstName,staffData.firstName ),"Could not enter the first name", selenium, ClassName, MethodName);
			}else{
				selectValueFromAjaxList(selenium,ajxRoleExternalStaff,staffData.role);
			}
			assertTrue(type(selenium,txtFirstName,staffData.firstName ),"Could not enter the first name", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtLastNanme,staffData.lastName ),"Could not enter the Last name", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtcredentials,staffData.credential ),"Could not enter the credentials name", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkbtnExternalAdd),"Could not click add new button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		return true;
	}
	
	
	
	
	/**
	 * deleteIndividualDate
	 * function to ddelete Individual Date
	 * @throws IOException 
	 * @since  	    Oct 25, 2013
	 */	
	
	public boolean deleteIndividualDate(Selenium selenium ) throws IOException{
		waitForPageLoad(selenium);
		boolean dateDeleted=true;
		int dateCount=0; 
		try{
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			while((Integer) selenium.getXpathCount(lnkDelete) > 0){
				dateCount=(Integer) selenium.getXpathCount(lnkDelete);
				assertTrue(click(selenium,lnkDelete),"could not click Delete button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(dateCount == (Integer) selenium.getXpathCount(lnkDelete)){
					dateDeleted = false;
					break;
				}
			}
			return dateDeleted;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return dateDeleted;
	}

	/**
	 * deleteStaff
	 * function to delete Staff
	 * @throws IOException 
	 * @since  	    Oct 24, 2013
	 */	
	public boolean deleteStaff(Selenium selenium ) throws IOException{
		waitForPageLoad(selenium);
		boolean programGroupDeleted=true;
		int programCount=0; 
		try{
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			while((Integer) selenium.getXpathCount(lnkStaffDelete) > 0){
				programCount=(Integer) selenium.getXpathCount(lnkStaffDelete);
				assertTrue(click(selenium,lnkStaffDelete),"could not click Delete button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkYes),"Could not click yes button;More Details:", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(programCount == (Integer) selenium.getXpathCount(lnkStaffDelete)){
					programGroupDeleted = false;
					break;
				}
			}
			return programGroupDeleted;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return programGroupDeleted;
	}
	
	/**
	 * editSession
	 * function to edit Session
	 * @throws IOException 
	 * @since  	    Oct 24, 2013
	 */	
	
	public boolean editSession(Selenium selenium, SchedulingTestLib sessionData, String providerName) throws IOException{
		assertTrue(type(selenium,txtsessionDuration,sessionData.duration1 ),"Could not enter the duration", selenium, ClassName, MethodName);
		selectValueFromAjaxList(selenium,ajxDurationUnit,sessionData.duration);
		selectValueFromAjaxList(selenium,ajxLocationType,sessionData.taskPlace);
	    int i=0;
		String locationCurrent="";
		String location = getText(selenium,lnkLocationHeader).trim();
		char[] calcLocation=location.toCharArray();
		 while(calcLocation[i]!='.')
		 {
			 locationCurrent=locationCurrent+calcLocation[i];
			 i++;
		 }
		if(sessionData.testCaseId.equals("TC_SS_009")){
			selectValueFromAjaxList(selenium,ajxLocation,sessionData.location);
		}else
			selectValueFromAjaxList(selenium,ajxLocation,locationCurrent);
		
		assertTrue(click(selenium,btnAddStaff),"Could not click add new button",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(addStaff(selenium,sessionData,providerName),"Could not Create Staff", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(sessionData.testCaseId.equals("TC_SS_009")){
			assertTrue(click(selenium,btnCancel),"Could not click on cancel button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		}else
			assertTrue(click(selenium,btnSaveNonProviderResource),"Could not click on Save button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		return true;
	}
	
	/**
	 * verifyStaffDetails
	 * function to verify Staff Details
	 * @throws IOException 
	 * @since Oct 24, 2013
	 */	
	
	public boolean verifyStaffDetails( Selenium selenium, SchedulingTestLib staffData) throws IOException{
		if(staffData.testCaseId.equals("TC_SS_003")||staffData.testCaseId.equals("TC_SS_019") ){
			
			assertTrue(selenium.isTextPresent("EXTERNAL"),"Could not Find text", selenium, ClassName, MethodName);
			
			assertTrue(selenium.isTextPresent(staffData.firstName),"Could not Find text", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(staffData.lastName),"Could not Find text", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(staffData.credential),"Could not Find text", selenium, ClassName, MethodName);
		
			if(staffData.testCaseId.equals("TC_SS_003")){
				
				assertTrue(selenium.isTextPresent(staffData.role.toUpperCase()),"Could not Find text", selenium, ClassName, MethodName);
							
			}if(staffData.testCaseId.equals("TC_SS_019")){
				
			
				
				if(!selenium.isTextPresent(staffData.role.toUpperCase(new java.util.Locale("en","US")))){
			
					return false;
				}
			}
		}else if(staffData.testCaseId.equals("TC_SS_002")){
			
			assertTrue(getValue(selenium,ajxRole).contains(staffData.role),"Could not find", selenium, ClassName, MethodName);
			
		}else if(staffData.testCaseId.equals("TC_SS_018")){
			
	
			assertTrue(getValue(selenium,ajxRole).toLowerCase().contains(staffData.role.toLowerCase()),"Could not Create Staff", selenium, ClassName, MethodName);
			
		
			
			
		
					}
		return true;
	}
	
	
	/**
	 * verifyStoredValuesForSeries
	 * function to create new series
	 * @throws IOException 
	 * @since Oct 24, 2013
	 */	
	public boolean verifyGroupDetails(Selenium selenium,SchedulingTestLib pdgAdminData, String uniqueName) throws IOException{
		
		if(pdgAdminData.testCaseId.equals("TC_PDG_001")){
			assertTrue(type(selenium,txtSearchProgram,pdgAdminData.plan),"Could not type the Program name",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}else{
			assertTrue(type(selenium,txtSearchProgram,pdgAdminData.groupName),"Could not type the Program name",selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
		    //selenium.typeKeys(txtSearchProgram, "a");
		}
		
		selenium.keyPress(txtSearchProgram, "\\13");
		waitForPageLoad(selenium);
		String getPath="xpath=(//div[contains(@id,'collapsableTitle')])["; 
		String actionClick="xpath=(//div[contains(@id,'actions')])[";
		int count=1;
		while(isElementPresent(selenium,getPath+count+"]"))
		{
		if(getText(selenium,getPath+count+"]").contains(pdgAdminData.groupName))	
		{
		assertTrue(click(selenium,actionClick+count+"]"),"Could not click the action", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkViewSeries), "could not click the view all series", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		break;
		}
		count++;
		}
		assertTrue(getText(selenium,lblPDGroup).contains(pdgAdminData.groupName),"Verification Failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPDGroup).contains(pdgAdminData.description),"Verification Failed",selenium, ClassName, MethodName);
		
		return true;
	}

	

	
	
	
	/**
	 * verifyStoredValuesForSeries
	 * function to create new series
	 * @throws IOException 
	 * @since Oct 24, 2013
	 */	
	public boolean verifySriesDetails(Selenium selenium,SchedulingTestLib pdgAdminData, String account, String location){
		try{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat;
			String startDate;
			String enddate;
			

			if(account.equals(CAAccount)){
				if(cal.DATE<10){
					DateFormat =new SimpleDateFormat("MMM d, yyyy");
				}else{
					DateFormat =new SimpleDateFormat("MMM dd, yyyy");
				}
				
				startDate=DateFormat.format(cal.getTime());
				cal.add(Calendar.DATE,Integer.valueOf(pdgAdminData.endOccurence)-1);
				
				enddate = DateFormat.format(cal.getTime());
				 
			}else{
				DateFormat=new SimpleDateFormat("MM/dd/YYYY");
				startDate = DateFormat.format(cal.getTime());
				cal.add(Calendar.DATE,Integer.valueOf(pdgAdminData.endOccurence)-1);
				enddate = DateFormat.format(cal.getTime());
			}
			
		
		
		
		if(pdgAdminData.testCaseId.equals("TC_SS_016"))	{
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1;
			String enddate1;
			
			if(account.equals(CAAccount)){
				DateFormat1 =new SimpleDateFormat("dd/MM/yyyy");
				
				cal1.add(Calendar.DATE,Integer.valueOf(pdgAdminData.endOccurence)-1);
				enddate1 = DateFormat1.format(cal1.getTime());
				 
			}else{
				DateFormat1=new SimpleDateFormat("MM/dd/YYYY");
				startDate = DateFormat1.format(cal1.getTime());
				cal1.add(Calendar.DATE,Integer.valueOf(pdgAdminData.endOccurence)-1);
				enddate1 = DateFormat1.format(cal1.getTime());
			}
			
			assertTrue(enterDate(selenium,txtSearchResourceCal,enddate1),"Could not type the End date for search", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.typeKeys(txtSearchResourceCal, "\\13");
			waitForPageLoad(selenium);
		}else if(pdgAdminData.testCaseId.equals("TC_SS_023"))	{
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1;
			String startDate1 = null;
			if(account.equals(CAAccount)){
				DateFormat1 =new SimpleDateFormat("dd/MM/yyyy");
				startDate1 = DateFormat1.format(cal1.getTime());
			}
			assertTrue(enterDate(selenium,txtSearchResourceCal,startDate1),"Could not type the End date for search", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.typeKeys(txtSearchResourceCal, "\\13");
		}else{
			assertTrue(type(selenium,txtSearchResourceCal,pdgAdminData.seriesName),"Could not type the Program name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//selenium.typeKeys(txtSearchResourceCal, "a");
		}
		assertTrue(getText(selenium,lblPSeries).contains(pdgAdminData.seriesName),"Verification Failed",selenium, ClassName, MethodName);
	
		
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,lblPSeries).contains(startDate),"Verification Failed",selenium, ClassName, MethodName);

		assertTrue(getText(selenium,lblPSeries).contains("to "+enddate),"Verification Failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPSeries).contains("in "+location.toUpperCase()),"Verification Failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPSeries).contains(pdgAdminData.duration),"Verification Failed",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPSeries).contains(pdgAdminData.duration1),"Verification Failed",selenium, ClassName, MethodName);

		assertTrue(click(selenium,lblSeries),"Could not click", selenium, ClassName, MethodName);
		
		
		int numberOfOccurence = Integer.valueOf(pdgAdminData.endOccurence)+2;
		for(int count = 2; count < numberOfOccurence; count ++ ){
			cal=Calendar.getInstance();
			cal.add(Calendar.DATE, numberOfOccurence-count-1);
			String dynamicdate = DateFormat.format(cal.getTime());
			
			assertTrue(isTextPresent(selenium,dynamicdate),"Verification Failed",selenium, ClassName, MethodName);
			
			
		}
		}
		catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return true;
	}
	
	
	/*
	 * addNewSeries
	 * function to create new series
	 * @throws IOException 
	 * @since Oct 24, 2013
	 */	
	public boolean addNewSeries(Selenium selenium, SchedulingTestLib pdgSeriesData) throws IOException{
	    boolean returnValue=true;
	    
	    assertTrue(type(selenium,txtseriesName,pdgSeriesData.seriesName ),"Could not enter the series Name", selenium, ClassName, MethodName);
	    assertTrue(type(selenium,txtGroupSize,pdgSeriesData.groupName ),"Could not enter the Group Name", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	   // selectValueFromAjaxList(selenium,ajxPgm,pdgSeriesData.pgmName);
	  
	    
	    String providerName = null;
	    String providerNameTemp = null;
	    String location = null;
	    //String locationTemp = null;
	    //get the provider name from top menu

	    providerNameTemp= getText(selenium, lnkTopMenu);

	    if(selenium.isTextPresent(pdgSeriesData.switchRole)){
			providerName = providerNameTemp.replaceAll(", "+pdgSeriesData.switchRole, "");
		    }else{
		    	Assert.fail("Not able to get the provider name");
		   }
	    
	   // location = getText(selenium,lnkTopPracticeMenu);
	    assertTrue(click(selenium,lnkTopPracticeMenu),"could not click the practice link", selenium, ClassName, MethodName);
	    location = getText(selenium,"css=div.header-bar-dropdown");
	    
	    pdgSeriesData.location = location;
	    selectValueFromAjaxList(selenium,ajxGrpCoordinator,providerName);
	    selenium.click(ajxLocationType1);
	    waitForPageLoad(selenium);
	    waitForPageLoad(selenium);
	    pdgSeriesData.locationType=selenium.getText("currentItem_1");
	    waitForPageLoad(selenium);
	    selectValueFromAjaxList(selenium,ajxLocationType1,pdgSeriesData.locationType);
	    
	    selectValueFromAjaxList(selenium,ajxLocation1,pdgSeriesData.location);
	    selectValueFromAjaxList(selenium,ajxRoom,pdgSeriesData.room);
	    
	    assertTrue(enterDate(selenium,txtStartdate,pdgSeriesData.startDate),"Could not enter the start Date;More Details:"+pdgSeriesData.toString(), selenium, ClassName, MethodName);
	    assertTrue(type(selenium,txtStartTimeHour,pdgSeriesData.startHour ),"Could not enter the starting hour ", selenium, ClassName, MethodName);
	    assertTrue(type(selenium,txtStartTimeMins,pdgSeriesData.startMin ),"Could not enter the starting min", selenium, ClassName, MethodName);
		
	    selectValueFromAjaxList(selenium,ajxForAmPMSeries,pdgSeriesData.timeAmPM);
	    
	    if(!pdgSeriesData.testCaseId.equals("TC_PAS_002")|| pdgSeriesData.testCaseId.equals("TC_PAS_004")){
		assertTrue(click(selenium,rdoWeekly),"could not click the radio button", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtEvery,pdgSeriesData.everyWeek ),"Could not enter on every text box", selenium, ClassName, MethodName);
		if(!isChecked(selenium,chkMonday)){
		    assertTrue(click(selenium,chkMonday),"could not click Monday check box", selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkTuesday)){
		    assertTrue(click(selenium,chkTuesday),"could not click Tuesday check box", selenium, ClassName, MethodName);
		}
		
		assertTrue(click(selenium,rdoAfter),"could not click the radio button", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtAfterOcc,pdgSeriesData.afterOcc ),"Could not enter on after occurence", selenium, ClassName, MethodName);
		
	    }
	
	    if(pdgSeriesData.testCaseId.equals("TC_PAS_002")|| pdgSeriesData.testCaseId.equals("TC_PAS_004")){
		assertTrue(click(selenium,rdoWeekly),"could not click the radio button", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtEvery,pdgSeriesData.everyWeek ),"Could not enter on every text box", selenium, ClassName, MethodName);
		if(!isChecked(selenium,chkMonday)){
		    assertTrue(click(selenium,chkMonday),"could not click Monday check box", selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkTuesday)){
		    assertTrue(click(selenium,chkTuesday),"could not click Tuesday check box", selenium, ClassName, MethodName);
		}
		
		assertTrue(click(selenium,rdoDate),"could not click the radio button", selenium, ClassName, MethodName);
		assertTrue(enterDate(selenium,txtEndDate1,pdgSeriesData.endDate),"Could not enter the End Date;More Details:"+pdgSeriesData.toString(), selenium, ClassName, MethodName);
		
	    }
	    assertTrue(click(selenium,btnNext),"could not click Next button", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    assertTrue(selectValueFromAjaxList(selenium,txtSearch1,pdgSeriesData.patientName ),"Could not enter patinet name", selenium, ClassName, MethodName);
	    selenium.keyPress(txtPatientBox, "\\9");
	    waitForElement(selenium,lblPatientResult,10000);
	    waitForPageLoad(selenium);
	    if(selenium.isElementPresent("patientInfoWidget")){
		assertTrue(selenium.isElementPresent("patientInfoWidget"),"Search Results are not displayed for the patient with ID :-"+pdgSeriesData.patientName, selenium, ClassName, MethodName);
		assertTrue(getText(selenium,"patientInfoWidget").toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.patientName.trim().toLowerCase(new java.util.Locale("en","US"))),"Not same", selenium, ClassName, MethodName);
		click(selenium,"patientInfoWidget");
	    }else{
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+pdgSeriesData.patientName, selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.patientName.trim().toLowerCase(new java.util.Locale("en","US"))),"Comparison wrong", selenium, ClassName, MethodName);
		click(selenium,lblPatientResult);
		}
		waitForPageLoad(selenium);
	    if(!selenium.isTextPresent(pdgSeriesData.patientName.toUpperCase())){
		Assert.fail("Add participant Failed");
	    }
	    
	    if(!selenium.isTextPresent("Mon, Tue")){
		Assert.fail("Add participant Failed");
	    }
	       
	    if(pdgSeriesData.testCaseId.equals("TC_PAS_006")){
		int count=0;
		while(isElementPresent(selenium,lnkDelete)){
		    assertTrue(click(selenium,lnkDelete),"Could not find delete ", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
		    assertTrue(click(selenium,lnkYes),"Could not click yes ", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
		    count++;
		    if(count>30){
			break;
		    }
		}
		
		if(selenium.isTextPresent("None Added")){
		    return true;
		}
		else{
		    Assert.fail("Deletion Unsuccessful");
		}
		
		String Count=getText(selenium,"//div[2]/div/div/div[2]/div[2]/div");
		//String resultList=getText(selenium,medicationQueue);
		String[] splitS = Count.split("[(^)]");
		int counter = Integer.parseInt(splitS[1]);
		    
		if(counter==0){
		    return true;
		}
		else{
		    Assert.fail("Deletion Unsuccessful");
		}
	    }
	    
	    if(pdgSeriesData.testCaseId.equals("TC_PAS_009")){
		int count=1;
		while(isElementPresent(selenium,"//div[3]/div["+count+"]/div[2]/a")){
		    count++;
		    
		    if(count>20){
			break;
		    }
		}
		
		String Count=getText(selenium,"//div[contains(text(),'Selected Participants ')]/span/div");
		//String resultList=getText(selenium,medicationQueue);
		String[] splitS = Count.split("[(^)]");
		int counter = Integer.parseInt(splitS[1]);
		
		if(counter!=(count-1)){
		    Assert.fail("Count Incorrect");
		}
		
		return true;
	    }
	    if(pdgSeriesData.testCaseId.equals("TC_PAS_010")){
		
		assertTrue(click(selenium,"//div[3]/div/div/div/div/div[2]/a"),"Could not find delete ", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(isChecked(selenium,chk1)){
		    assertTrue(click(selenium,chk1),"could not click Monday check box", selenium, ClassName, MethodName);
		}
		if(isChecked(selenium,chk2)){
		    assertTrue(click(selenium,chk2),"could not click Tuesday check box", selenium, ClassName, MethodName);
		}
		
		assertTrue(click(selenium,btnCloseSelection),"could not click Close Selection", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(isElementPresent(selenium,lblSelectionAlert), "The validation message field did not appear",selenium, ClassName, MethodName);
		assertTrue(getText(selenium, lblSelectionAlert).contains("Day selection cannot be empty"), "The expected validation message should contain the text - ",selenium, ClassName, MethodName);
		
		return true;
	    }
	    
	    assertTrue(click(selenium,btnDone),"could not click Done button", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    if(isElementPresent(selenium,btnAdd)){
		 return returnValue;
	    }
	    else{
		Assert.fail("Series Creation Failed");
	    }
	    return returnValue;
	}

	/**
	 * verifyStoredValuesForSeriesInSummary
	 * function to create new series
	 * @throws IOException 
	 * @since Oct 24, 2013
	 */	
	
	public boolean verifyStoredValuesForSeriesInSummary(Selenium selenium, SchedulingTestLib pdgSeriesData) throws IOException{
	    boolean returnValue=true;
	    
	   assertTrue(getText(selenium,lblSeries).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.seriesName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   
	   assertTrue(getText(selenium,lblSeries).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.location.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   
	   assertTrue(getText(selenium,lblSeries).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.everyWeek.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   assertTrue(getText(selenium,lblSeries).toLowerCase(new java.util.Locale("en","US")).trim().contains("Mon".trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   assertTrue(getText(selenium,lblSeries).toLowerCase(new java.util.Locale("en","US")).trim().contains("Tue".trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   assertTrue(getText(selenium,lblSeries).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.startHour.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   assertTrue(getText(selenium,lblSeries).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.startMin.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   assertTrue(getText(selenium,lblSeries).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.timeAmPM.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   return returnValue;
	}

	
	
	
	/**
	 * verifyStoredValuesForSeries
	 * function to create new series
	 * @throws IOException 
	 * @since Oct 24, 2013
	 */	
	
	public boolean verifyStoredValuesForSeries(Selenium selenium, SchedulingTestLib pdgSeriesData) throws IOException{
	    boolean returnValue=true;
	    
	    String providerName = null;
	    String providerNameTemp = null;
	    //get the provider name from top menu

	    providerNameTemp= getText(selenium, lnkTopMenu);

	    if(selenium.isTextPresent(pdgSeriesData.switchRole)){
		providerName = providerNameTemp.replaceAll(", "+pdgSeriesData.switchRole, "");
	    }
	    else{
		Assert.fail("Not able to get the provider name");
	    }
	    
	   assertTrue(getValue(selenium,txtseriesName).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.seriesName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   assertTrue(getValue(selenium,txtGroupSize).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.groupName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	  /* if(!getValue(selenium,ajxPgm).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.pgmName.trim().toLowerCase(new java.util.Locale("en","US")))){
	       return false;
	   }*/
	   assertTrue(getValue(selenium,ajxGrpCoordinator).toLowerCase(new java.util.Locale("en","US")).trim().contains(providerName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   assertTrue(getValue(selenium,ajxLocationType1).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.locationType.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	    
	   assertTrue(getValue(selenium,ajxLocation1).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.location.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   assertTrue(getValue(selenium,txtStartdate).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.startDate.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   assertTrue(getValue(selenium,txtStartTimeHour).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.startHour.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   assertTrue(getValue(selenium,txtStartTimeMins).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.startMin.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   assertTrue(getValue(selenium,ajxForAmPM).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.timeAmPM.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   
	   if(pdgSeriesData.testCaseId.equals("TC_PAS_001")||pdgSeriesData.testCaseId.equals("TC_PAS_003")){
		   assertTrue(getValue(selenium,txtAfterOcc).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.afterOcc.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   }
	   else if(pdgSeriesData.testCaseId.equals("TC_PAS_002")||pdgSeriesData.testCaseId.equals("TC_PAS_004")){
		   assertTrue(getValue(selenium,txtEndDate1).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.endDate.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   }
	   
	   return returnValue;
	}
	
	/*
	 * addNewSeries
	 * function to create new series
	 * @throws IOException 
	 * @since Oct 24, 2013
	 */	
	
	public boolean unitTestForaddNewSeries(Selenium selenium, SchedulingUnitTestLib pdgSeriesData) throws IOException{
	    boolean returnValue=true;
	    
	    assertTrue(type(selenium,txtseriesName,pdgSeriesData.seriesName ),"Could not enter the series Name", selenium, ClassName, MethodName);
	    assertTrue(type(selenium,txtGroupSize,pdgSeriesData.groupName ),"Could not enter the Group Name", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    selectValueFromAjaxList(selenium,ajxPgm,pdgSeriesData.pgmName);
	    waitForPageLoad(selenium);
	    
	    String providerName = null;
	    String providerNameTemp = null;
	    //get the provider name from top menu

	    providerNameTemp= getText(selenium, lnkTopMenu);

	    if(selenium.isTextPresent(pdgSeriesData.switchRole)){
		providerName = providerNameTemp.replaceAll(", "+pdgSeriesData.switchRole, "");
	    }
	    else{
		Assert.fail("Not able to get the provider name");
	    }

	    selectValueFromAjaxList(selenium,ajxGrpCoordinator,providerName);
	    
	    if(pdgSeriesData.testCaseId.equals("TC_UAS_006")){
		selectValueFromAjaxList(selenium,ajxGrpCoordinator,"abc");
	    }
	    
	    selectValueFromAjaxList(selenium,ajxLocationType1,pdgSeriesData.locationType);
	    selectValueFromAjaxList(selenium,ajxLocation1,pdgSeriesData.location);
	    selectValueFromAjaxList(selenium,ajxRoom,pdgSeriesData.room);
	    
	    assertTrue(enterDate(selenium,txtStartdate,pdgSeriesData.startDate),"Could not enter the start Date;More Details:"+pdgSeriesData.toString(), selenium, ClassName, MethodName);
	    assertTrue(type(selenium,txtStartTimeHour,pdgSeriesData.startHour ),"Could not enter the starting hour ", selenium, ClassName, MethodName);
	    assertTrue(type(selenium,txtStartTimeMins,pdgSeriesData.startMin ),"Could not enter the starting min", selenium, ClassName, MethodName);
		
	    selectValueFromAjaxList(selenium,ajxForAmPM,pdgSeriesData.timeAmPM);
	    
	    if(pdgSeriesData.testCaseId.equals("TC_UAS_011")){
		String date="";
		String time="";
		int time1=0, time2=0;
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
		date=DateFormat.format(cal.getTime());
		DateFormat=new SimpleDateFormat("HH");
		time=DateFormat.format(cal.getTime());
	        time1 = Integer.parseInt(time);
	        if(time1>12){
	            time1=time1-12;
	        }
	        time2 = time1-1;
	        String str = Integer.toString(time2);
	        assertTrue(enterDate(selenium,txtStartdate,date),"Could not enter the start Date;More Details:"+pdgSeriesData.toString(), selenium, ClassName, MethodName);
	        assertTrue(type(selenium,txtStartTimeHour,str),"Could not enter the starting hour ", selenium, ClassName, MethodName);
	    }
	    
	    if(pdgSeriesData.testCaseId.equals("TC_UAS_026")){
		assertTrue(click(selenium,rdoWeekly),"could not click the radio button", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtEvery,pdgSeriesData.everyWeek ),"Could not enter on every text box", selenium, ClassName, MethodName);
		assertTrue(click(selenium,rdoAfter),"could not click the radio button", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtAfterOcc,pdgSeriesData.afterOcc ),"Could not enter on after occurence", selenium, ClassName, MethodName);
		assertTrue(click(selenium,btnDone),"could not click Done button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	    }
	    
	    if(!pdgSeriesData.testCaseId.equals("TC_UAS_027")|| pdgSeriesData.testCaseId.equals("TC_UAS_028")|| pdgSeriesData.testCaseId.equals("TC_UAS_029")){
		assertTrue(click(selenium,rdoWeekly),"could not click the radio button", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtEvery,pdgSeriesData.everyWeek ),"Could not enter on every text box", selenium, ClassName, MethodName);
		if(!isChecked(selenium,chkMonday)){
		    assertTrue(click(selenium,chkMonday),"could not click Monday check box", selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkTuesday)){
		    assertTrue(click(selenium,chkTuesday),"could not click Tuesday check box", selenium, ClassName, MethodName);
		}
		
		assertTrue(click(selenium,rdoAfter),"could not click the radio button", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtAfterOcc,pdgSeriesData.afterOcc ),"Could not enter on after occurence", selenium, ClassName, MethodName);
		
	    }
	
	    if(pdgSeriesData.testCaseId.equals("TC_UAS_027")|| pdgSeriesData.testCaseId.equals("TC_UAS_028")|| pdgSeriesData.testCaseId.equals("TC_UAS_029")){
		assertTrue(click(selenium,rdoWeekly),"could not click the radio button", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtEvery,pdgSeriesData.everyWeek ),"Could not enter on every text box", selenium, ClassName, MethodName);
		if(!isChecked(selenium,chkMonday)){
		    assertTrue(click(selenium,chkMonday),"could not click Monday check box", selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkTuesday)){
		    assertTrue(click(selenium,chkTuesday),"could not click Tuesday check box", selenium, ClassName, MethodName);
		}
		
		assertTrue(click(selenium,rdoDate),"could not click the radio button", selenium, ClassName, MethodName);
		assertTrue(enterDate(selenium,txtEndDate1,pdgSeriesData.endDate),"Could not enter the End Date;More Details:"+pdgSeriesData.toString(), selenium, ClassName, MethodName);
		
	    }
	    
	   /* assertTrue(click(selenium,btnNext),"could not click Next button", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    assertTrue(selectValueFromAjaxList(selenium,txtSearch1,pdgSeriesData.patientName ),"Could not enter patinet name", selenium, ClassName, MethodName);
	    selenium.keyPress(txtPatientBox, "\\9");
	    waitForElement(selenium,lblPatientResult,10000);
	    waitForPageLoad(selenium);
	    if(selenium.isElementPresent("css=div.patientInfoWidget")){
		Assert.assertTrue(selenium.isElementPresent("css=div.patientInfoWidget"),"Search Results are not displayed for the patient with ID :-"+pdgSeriesData.patientName);
		Assert.assertTrue(getText(selenium,"css=div.patientInfoWidget").toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.patientName.trim().toLowerCase(new java.util.Locale("en","US"))));
		click(selenium,"css=div.patientInfoWidget");
	    }else{
		Assert.assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+pdgSeriesData.patientName);
		Assert.assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.patientName.trim().toLowerCase(new java.util.Locale("en","US"))));
		click(selenium,lblPatientResult);
		}
		waitForPageLoad(selenium);
	    if(!getText(selenium,lblAddparticipant).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.patientName.toLowerCase(new java.util.Locale("en","US")).trim())){
		Assert.fail("Add participant Failed");
	    }
	    
	    if(pdgSeriesData.testCaseId.equals("TC_PAS_006")){
		int count=0;
		while(isElementPresent(selenium,lnkDelete)){
		    assertTrue(click(selenium,lnkDelete),"Could not find delete ", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
		    assertTrue(click(selenium,lnkYes),"Could not click yes ", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
		    count++;
		    if(count>30){
			break;
		    }
		}
		   
		    return true;
	    }*/
	    assertTrue(click(selenium,btnDone),"could not click Done button", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    /*if(isElementPresent(selenium,btnAdd)){
		 return returnValue;
	    }
	    else{
		Assert.fail("Series Creation Failed");
	    }*/
	    return returnValue;
	}

	
	/*
	 * verifyPDGValueInQueue
	 * function to verifyPDGValueInQueue
	 * @throws IOException 
	 * @since Oct 30, 2013
	 */	
	public boolean verifyPDGValueInQueue(Selenium selenium, SchedulingTestLib pDGData,SchedulingTestLib pDAData, String uniqueName ) throws IOException{
		boolean requrieddataFound = false;
		int count =1;
		int dataCount = (Integer) selenium.getXpathCount("//span[@id='SeriesName']");
		for(count = 1; count <= dataCount  ; count++){
			/*System.out.println(getText(selenium,"//div[@id='printInfo']/div/div/div[3]/div/div[2]/div[2]/div["+count+"]"));
			System.out.println(pDAData.groupName+uniqueName);*/
			if(getText(selenium,"xpath=(//span[@id='SeriesName'])["+count+"]").contains(pDGData.seriesName)){
				
				 assertTrue(getText(selenium,"xpath=(//span[@id='SeriesName'])["+count+"]").contains(pDGData.seriesName),"Verification failed", selenium, ClassName, MethodName);
				
				/*if(!getText(selenium,"xpath=(//span[@id='sessionNumber'])["+count+"]").contains("of " + pDGData.endOccurence )){
					return false;
				}*/
				
				assertTrue(getText(selenium,"xpath=(//span[@id='seriesDes'])["+count+"]").contains(pDAData.groupName ),"Verification failed", selenium, ClassName, MethodName);
				 /*requrieddataFound = true;
				 return requrieddataFound;*/
				int countArrow = count;
				}
						
			if(count == dataCount){
				if(selenium.getAttribute("//div[@class='top-right']/a[2]/@class").contains("inlineBlock arrowDownOff")){
					assertTrue(click(selenium,"xpath=(//div[@id='openSessionDiv'])[+count+]"),"Click Failed", selenium, ClassName, MethodName);
					count = 1;
				}else
					break;
			}
		}
		
		
	return requrieddataFound = true;
	}
		

	/*
	 * navigateToTake Attendance
	 * function to Navigate to Take Attendance
	 * @throws IOException 
	 * @since Oct 31, 2013
	 */	
	public boolean navigateToTakeAttendance(Selenium selenium, SchedulingTestLib pDGData,SchedulingTestLib pDAData, String uniqueName ) throws IOException{
		boolean requrieddataFound = false;
		waitForPageLoad(selenium);
		int count =1;
		try
		{
		assertTrue(selectValueFromAjaxList(selenium, ajxPdgFilter,"Me as PDG Coordinator"),"Selection failed", selenium, ClassName, MethodName);
		int dataCount = (Integer) selenium.getXpathCount("//span[@id='SeriesName']");
		for(count = 1; count <= dataCount  ; count++){
			System.out.println(getText(selenium,"xpath=(//span[@id='SeriesName'])["+count+"]"));
			System.out.println(pDAData.groupName+uniqueName);
			
			//if(getText(selenium,"//div[@id='printInfo']/div/div/div[3]/div/div[2]/div[2]/div["+count+"]").contains(pDAData.groupName+uniqueName)){
				
				if(getText(selenium,"xpath=(//span[@id='seriesDes'])["+count+"]").toLowerCase(new java.util.Locale("en","US")).contains(uniqueName)){
					//assertTrue(click(selenium,"xpath=(//a[@id='viewChart'])["+count+"]"),"Click Failed", selenium, ClassName, MethodName);
					assertTrue(click(selenium,"xpath=(//*[@id='openSessionDiv'])["+count+"]"),"Click Failed", selenium, ClassName, MethodName);
					 waitForPageLoad(selenium);
					 requrieddataFound = true;
					 return requrieddataFound;
				}
				
			//}
			if(count == dataCount){
				//FIXME- VEL-VEL-8074
				if(selenium.getAttribute("//div[@id='printInfo']/div/div[3]/div/div/div/div[2]/div/div/div/div/div/div[4]/a[2]@class").contains("inline-block arrowDownOn")){
					assertTrue(click(selenium,"//div[@id='printInfo']/div/div[3]/div/div/div/div[2]/div/div/div/div/div/div[4]/a[2]"),"Click Failed", selenium, ClassName, MethodName);
					count = 0;
				}else
					break;
			}
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	return requrieddataFound;
	}
	
	
	
	/*
	 * navigateToTake Attendance
	 * function to Navigate to Take Attendance
	 * @throws IOException 
	 * @since Oct 31, 2013
	 */	
	public boolean navigateToTakeAttendanceStaff(Selenium selenium, SchedulingTestLib pDGData,SchedulingTestLib pDAData, String uniqueName ) throws IOException{
		boolean requrieddataFound = false;
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium, ajxPdgFilter,"All Series");
		int count =1;
		int dataCount = (Integer) selenium.getXpathCount("//div[@id='printInfo']/div/div/div[3]/div/div[2]/div[2]/div");
		for(count = 1; count <= dataCount  ; count++){
			System.out.println(getText(selenium,"//div[@id='printInfo']/div/div/div[3]/div/div[2]/div[2]/div["+count+"]"));
			System.out.println(pDAData.groupName+uniqueName);
			
			if(getText(selenium,"//div[@id='printInfo']/div/div/div[3]/div/div[2]/div[2]/div["+count+"]").contains(pDGData.groupName+uniqueName)){
				
				//if(getText(selenium,"//div[@id='printInfo']/div/div/div[3]/div/div[2]/div[2]/div["+count+"]").toLowerCase(new java.util.Locale("en","US")).contains(pDGData.seriesName.toLowerCase(new java.util.Locale("en","US")))){
					assertTrue(click(selenium,"//div[@id='printInfo']/div/div/div[3]/div/div[2]/div[2]/div["+count+"]/div[3]/div/a"),"could not click the button", selenium, ClassName, MethodName);
					 requrieddataFound = true;
					 return requrieddataFound;
				//}
				
			}
			if(count == dataCount){
				if(selenium.getAttribute("//div[@class='subSectionBorderTopRoundedCorner formWidgets width630px']/div/div/div[4]/a@class").contains("inlineBlock arrowDownOn")){
					assertTrue(click(selenium,"//div[@class='subSectionBorderTopRoundedCorner formWidgets width630px']/div/div/div[4]/a"),"could not click", selenium, ClassName, MethodName);
					count = 0;
				}else
					break;
			}
		}
	return requrieddataFound;
	}
	
	/**
	 * deleteAllUnfinishedItem
	 * function for deleteAllUnfinishedItem
	 * @throws IOException 
	 * @since  	    Nov 04, 2013
	 */	
	
	
	public boolean deleteAllUnfinishedItem(Selenium selenium) throws ParseException, IOException {
		String lnkUnfinishedItemOpenArrow="css=#unfinishedItemMenuID > div.menu-arrow.menu-opened";
		String lnkShowMoreUnfinishedItem="//li[@class='showMoreUnfinishedItems']";
		
		boolean unfinishedItemDeleted = true;
		int timeLimitDoNotDelete=30;//In minute
		int deleteElementPossition=1;
		try{
			//open the unfinished item menu if it is closed
			if(isElementPresent(selenium, lnkUnfinishedItemOpenArrow)){
				assertTrue(click(selenium,lnkUnfinishedItem),"Click failed", selenium, ClassName, MethodName);
			}
			
			//if show more link exists then click the show more link in unfinished item(need for get unfinished item count)
			if(isElementPresent(selenium, lnkShowMoreUnfinishedItem)){
				click(selenium, lnkShowMoreUnfinishedItem);
			}
			
			
			waitForElement(selenium, lnkDeleteUnfinishedItem, WAIT_TIME);
			
			//check the not needed unfinished items in the list
			while((Integer) selenium.getXpathCount(lnkDeleteUnfinishedItem) >= deleteElementPossition){
				String temp = getText(selenium, "//div[@id='unfinishedItemMenuID']/div[2]/ul/li/div/div/div[2]");
				
				if(temp. equalsIgnoreCase("Today")){
					//get the time of unfinished item created with AM/ PM format
					String timeWithAMPM =selenium.getText("//div[@id='unfinishedItemMenuID']/div[2]/ul/li["+deleteElementPossition+"]/div/div/div");
					
															
					//get the time only from the above string
					String timeOnly= timeWithAMPM.replaceAll("[A-Z]", "");
					
					//get the Hour and Minute
					String SplitTimeOnly[]= timeOnly.split(":");
						
					int Hour= Integer.parseInt(SplitTimeOnly[0]);
					int Minute= Integer.parseInt(SplitTimeOnly[1]);
						
					//Calculate to 24 hour format
					if(timeWithAMPM.endsWith("PM")){
						
						if(Hour!=12){
							Hour= Hour + 12;
						}
					}
					else {
						if(Hour==12){
							Hour=0;
						}
					}
					
					//Now the unfinished item time format changed to 24 hour format
					String changedTimeFormat= String.valueOf(Hour)+":"+String.valueOf(Minute);
					    
				     
				     SimpleDateFormat format = new SimpleDateFormat("HH:mm");
				     
				     //get the current time
				     Date date = new Date();
				     String currenttime = format.format(date);
				     
				     
				     Date date1 = format.parse(changedTimeFormat);
				     Date date2 = format.parse(currenttime);
				     //get the difference between current time and unfinished item created time
				     long difference = date2.getTime() - date1.getTime(); 
				     
				     
				     //use the condition to exclude the unfinished item do not delete
				     if( !(difference<(timeLimitDoNotDelete*60*1000))){
				    	 assertTrue(click1(selenium,"//div[@id='unfinishedItemMenuID']/div[2]/ul/li["+deleteElementPossition+"]/div/div[4]/a"),"click failed", selenium, ClassName, MethodName);
						 assertTrue(click(selenium,btnYesUnfinishedItem),"Click failed", selenium, ClassName, MethodName);
						 waitForPageLoad(selenium);
						 
						 if(isElementPresent(selenium, lnkShowMoreUnfinishedItem)){
							 click(selenium, lnkShowMoreUnfinishedItem);
						 }
				     }
				
				     //here we used else logic for do not distrub the particular unfinished item in the next iteration
				     else{
				    	 deleteElementPossition= deleteElementPossition + 1;
				     }
				}
				
				else{
					 assertTrue(click1(selenium,"//div[@id='unfinishedItemMenuID']/div[2]/ul/li["+deleteElementPossition+"]/div/div[4]/a"),"Click failed", selenium, ClassName, MethodName);
					 assertTrue(click(selenium,btnYesUnfinishedItem),"Click Failed", selenium, ClassName, MethodName);
					 waitForPageLoad(selenium);
					 
					 if(isElementPresent(selenium, lnkShowMoreUnfinishedItem)){
						 click(selenium, lnkShowMoreUnfinishedItem);
					 }
				}
			     
			    
				
				 waitForElement(selenium, lnkDeleteUnfinishedItem, WAIT_TIME);
				
			}
			
			//close the unfinished item menu if it is opened
			if(!isElementPresent(selenium, lnkUnfinishedItemOpenArrow)){
				assertTrue(click(selenium,lnkUnfinishedItem),"Click Failed", selenium, ClassName, MethodName);
			}
			
			return unfinishedItemDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
    }



	/**
	 * navigateToUnfinishedItem
	 * function for navigateToUnfinishedItem
	 * @throws IOException 
	 * @since  	    Nov 04, 2013
	 */	
	public boolean navigateToUnfinishedItem(Selenium selenium, String currentUnfinishedItem) throws IOException{
		//if unfinished item menu not opened, then open it
		if(isElementPresent(selenium, lnkUnfinishedItemOpenArrow)){
			assertTrue(click(selenium,lnkUnfinishedItem),"Click Failed", selenium, ClassName, MethodName);
		}
		
		int count=1;
		int unfinishedItemcount=(Integer) (selenium.getXpathCount(lnkDeleteUnfinishedItem));
		//use this loop for select the unfinished item we want from the whole item list
		while(unfinishedItemcount>=count){
			if(getText(selenium, "//div[@id='unfinishedItemMenuID']/div[2]/ul/li["+count+"]/div/div[2]").contains(currentUnfinishedItem)){
				assertTrue(click(selenium,"//div[@id='unfinishedItemMenuID']/div[2]/ul/li["+count+"]/div/div[2]"),"Click failed", selenium, ClassName, MethodName);
				return true;
			}
			count++;
		}
		return false;
	}
	
	/**
	 * addPatient
	 * function for addPatient
	 * @throws IOException 
	 * @since  	    Nov 04, 2013
	 */	
	public boolean addPatient(Selenium selenium,SchedulingTestLib pDGData) throws IOException{
		
		//--------------------------------------------------------------------//
		//  Step-8: Mouse hover to the patient name in patient search		  //
		//--------------------------------------------------------------------//
		
		assertTrue(selectValueFromAjaxList(selenium,txtPatientSearch,pDGData.patientName),"Could not type patient name", selenium, ClassName, MethodName);
		selenium.fireEvent(txtPatientSearch,"keydown");
		selenium.fireEvent(txtPatientSearch,"keypress");                           
		selenium.fireEvent(txtPatientSearch,"keyup");
		selenium.keyPress(txtPatientSearch, "\\13");
		waitForElement(selenium,lblPatientResult,10000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with name :-"+pDGData.patientName, selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(pDGData.patientName.trim().toLowerCase(new java.util.Locale("en","US"))),"", selenium, ClassName, MethodName);
		
		selenium.mouseOver(lblPatientResult);
		waitForPageLoad(selenium);
		
		selenium.click(lblPatientResult);
		waitForPageLoad(selenium);
		
		selectValueFromAjaxList(selenium,ajxPriorstate,pDGData.priorState);
		assertTrue(type(selenium,txtReason, pDGData.reason),"Could not enter the reason", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtComments, pDGData.comments),"Could not enter the comments", selenium, ClassName, MethodName);
		
		assertTrue(click(selenium, btnAddPatient),"Could not click the add button", selenium, ClassName, MethodName);
		return true;
	}
	
	/**
	 * addNewPatient
	 * function for addNewPatient
	 * @throws IOException 
	 * @since  	    Nov 04, 2013
	 */	
	public boolean addNewPatient(Selenium selenium, SchedulingTestLib pDGData) throws IOException{
		
		//--------------------------------------------------------------------//
		//  Step-8: Search InValid Patient		  //
		//--------------------------------------------------------------------//
		assertTrue(selectValueFromAjaxList(selenium,txtPatientSearch,pDGData.patientName),"Could not type patient name", selenium, ClassName, MethodName);
		selenium.keyPress(txtPatientSearch, "\\9");
		waitForElement(selenium,lblPatientResult,10000);
		if(selenium.isTextPresent("Patient not found. Add new patient")){
			return false;
		}
		//assertTrue(selenium.isTextPresent("Patient not found. Add new patient"),"Patient not found. Add new patient text is not present", selenium, ClassName, MethodName);
		
		click(selenium,"//div[5]/div/div/div/div[2]/div/div/div/div");
		
		//Create New Patient
		assertTrue(type(selenium,txtFirstName, pDGData.firstName),"Could not enter the reason", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtLastName, pDGData.lastName),"Could not enter the comments", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtPhonNo, pDGData.pPhone),"Could not enter the reason", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtEmail, pDGData.eMail),"Could not enter the comments", selenium, ClassName, MethodName);
		selectValueFromAjaxList(selenium,ajxshowFillter,pDGData.priorState);
		assertTrue(type(selenium,txtReason, pDGData.reason),"Could not enter the reason", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtComments, pDGData.comments),"Could not enter the comments", selenium, ClassName, MethodName);
		
		if(pDGData.testCaseId.equals("TC_SS_022")){
			assertTrue(click(selenium,btnCancelNewPatient),"Could not click the Cancel button", selenium, ClassName, MethodName);
		}else{
			assertTrue(click(selenium,lnkbtnExternalAdd),"Could not click the add button", selenium, ClassName, MethodName);
		}
		return true;
	}
	
	
	
	/**
	 * navigateToRecordAttendance
	 * function for navigate To Record Attendance section
	 * @throws IOException 
	 * @since  	    Nov 04, 2013
	 */	
	
	public boolean navigateToRecordAttendance(Selenium selenium,SchedulingTestLib pdgSeriesData, SchedulingTestLib pDGData) throws IOException{
		assertTrue(click(selenium,lnkQuickAction),"Could not click the link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkRecordAttendance),"Could not click record attendance link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(verifyStoredValuesForRecordAttendanceSummary(selenium,pdgSeriesData, pDGData),"Could not verify the Created series in record attendance", selenium, ClassName, MethodName);
		
		assertTrue(click(selenium,lnkFirstRecordAttendance),"Could not click the first record in attendance group", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(isElementPresent(selenium, "errorCloseButton"))
			assertTrue(click(selenium, "errorCloseButton"),"Could not click", selenium, ClassName, MethodName);
		
		waitForPageLoad(selenium);
		int count= (Integer) selenium.getXpathCount("//a[@id='singleSelectionWidgetCloseButton']");
		while(isElementPresent(selenium, "xpath=(//a[@id='singleSelectionWidgetCloseButton'])["+count+"]")){
		    assertTrue(click(selenium,"xpath=(//a[@id='singleSelectionWidgetCloseButton'])["+count+"]"),"could not click ", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
		    count--;
		    
		    if(count<=0){
			break;
		    }
		}
		
		assertTrue(click(selenium,btnUpdateParticipant),"could not click update participants button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(isElementPresent(selenium,txtPatientSearch)){
		    return true;
		}
		
		else{
		    Assert.fail("Navigation failed");
		}
		return true;
	}
	
	/**
	 * recordSessionNote
	 * function to record Session Note
	 * @throws IOException 
	 * @since Nov 10, 2013
	 */	
	public boolean recordSessionNote(Selenium selenium, SchedulingTestLib pDGData) throws IOException{
		assertTrue(selectValueFromAjaxList(selenium,ajxIcdList,pDGData.taskPlace),"Could not type take place", selenium, ClassName, MethodName);
		assertTrue(selectValueFromAjaxList(selenium,ajxLocation,pDGData.location),"Could not type location", selenium, ClassName, MethodName);
		assertTrue(selectValueFromAjaxList(selenium,ajxOutComePickList,pDGData.issueAddressed),"Could not type Issue", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtSession,pDGData.comments),"Could not type the session details", selenium, ClassName, MethodName);
		assertTrue(click(selenium,btnWizardDone),"Could not click the done button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(!selenium.isTextPresent("PDG sessions for")){
			return false;
		}else
			return true;
		
	}
	/**
	 * verifyAttendingParticipantsDetails
	 * function to verifyAttendingParticipantsDetails
	 * @throws IOException 
	 * @since Nov 10, 2013
	 */	
	public boolean verifyAttendingParticipantsDetails(Selenium selenium,SchedulingTestLib pDGData){
	
		if(!selenium.isTextPresent(pDGData.patientName)){
			return false;
		}
		if(!selenium.isTextPresent(pDGData.reason)){
			return false;
		}
		if(!selenium.isTextPresent(pDGData.priorState)){
			return false;
		}
		return true;
		
	}
	/**
	 * verifyStoredValuesForRecordAttendanceSummary
	 * function to verify Stored Values For Record Attendance Summary
	 * @throws IOException 
	 * @since Nov 04, 2013
	 */	
	
	public boolean verifyStoredValuesForRecordAttendanceSummary(Selenium selenium, SchedulingTestLib pdgSeriesData, SchedulingTestLib pDGData) throws IOException{
	    boolean returnValue=true;
	    waitForPageLoad(selenium);
	   //String lastAttendance="Last attendance taken by "+pdgSeriesData.grpCoordinator;
	   
	   assertTrue(getText(selenium,lblRecordAttendanceSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.seriesName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   assertTrue(getText(selenium,lblRecordAttendanceSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(pDGData.groupName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   /*if(!getText(selenium,lblRecordAttendanceSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.startHour.trim().toLowerCase(new java.util.Locale("en","US")))){
	       return false;
	   }
	   if(!getText(selenium,lblRecordAttendanceSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.startMin.trim().toLowerCase(new java.util.Locale("en","US")))){
	       return false;
	   }*/
	   /*if(!getText(selenium,lblRecordAttendanceSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.timeAmPM.trim().toLowerCase(new java.util.Locale("en","US")))){
	       return false;
	   }*/
	   
	   
	   /* if(!getText(selenium,lblRecordAttendanceSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(lastAttendance.trim().toLowerCase(new java.util.Locale("en","US")))){
	       return false;
	   }*/
	   
	   return returnValue;
	}
	
	/**
	 * verifyStoredValuesForFirstRecordAttendance
	 * function to verify Stored Values For first Record Attendance Summary
	 * @throws IOException 
	 * @since Nov 04, 2013
	 */	
	
	public boolean verifyStoredValuesForFirstRecordAttendance(Selenium selenium, SchedulingTestLib pdgSeriesData, SchedulingTestLib pDGData) throws IOException{
	    boolean returnValue=true;
	    
	   assertTrue(getText(selenium,lblFirstRecordAttendance).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.seriesName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   assertTrue(getText(selenium,lblFirstRecordAttendance).toLowerCase(new java.util.Locale("en","US")).trim().contains(pDGData.groupName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   assertTrue(getText(selenium,lblFirstRecordAttendance).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.startHour.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   assertTrue(getText(selenium,lblFirstRecordAttendance).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.startMin.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   assertTrue(getText(selenium,lblFirstRecordAttendance).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.timeAmPM.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	   
	   return returnValue;
	}
	
	
	
	/*
	 * addNewSeriesForAttendanceGroup
	 * function to create new series for attendance group
	 * @throws IOException 
	 * @since Nov 05, 2013
	 */	
	
	public boolean addNewSeriesForAttendanceGroup(Selenium selenium, SchedulingTestLib pdgSeriesData, String userAccount) throws IOException{
	    boolean returnValue=true;
	    SimpleDateFormat DateFormat = null;

	    assertTrue(type(selenium,txtseriesName,pdgSeriesData.seriesName ),"Could not enter the series Name", selenium, ClassName, MethodName);
	    assertTrue(type(selenium,txtGroupSize,pdgSeriesData.groupName ),"Could not enter the Group Name", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    selectValueFromAjaxList(selenium,ajxPgm,pdgSeriesData.pgmName);
	    waitForPageLoad(selenium);
	    
	    String providerName = null;
	    String providerNameTemp = null;
	    //get the provider name from top menu

	    providerNameTemp= getText(selenium, lnkTopMenu);

	    if(selenium.isTextPresent(pdgSeriesData.switchRole)){
		providerName = providerNameTemp.replaceAll(", "+pdgSeriesData.switchRole, "");
	    }
	    else{
		Assert.fail("Not able to get the provider name");
	    }

	    selectValueFromAjaxList(selenium,ajxGrpCoordinator,providerName);
	    
	    selectValueFromAjaxList(selenium,ajxLocationType1,pdgSeriesData.locationType);
	    
	    pdgSeriesData.location = getText(selenium,lnkLocationHeader).replace("...", "") ;
	    
	    selectValueFromAjaxList(selenium,ajxLocation1,pdgSeriesData.location);
	    selectValueFromAjaxList(selenium,ajxRoom,pdgSeriesData.room);
	    
	    Calendar cal=Calendar.getInstance();
		
		cal.add(Calendar.YEAR,1);

		cal.add( Calendar.DAY_OF_WEEK, -(cal.get(Calendar.DAY_OF_WEEK)-1)); 
		
		if(userAccount.equalsIgnoreCase(CAAccount)){
			DateFormat=new SimpleDateFormat("dd/MM/yyyy");
		}else{
			DateFormat=new SimpleDateFormat("MM/dd/yyyy");
		}
		cal.add(Calendar.DATE, -((cal.get(Calendar.DATE)/7)*7));
		
		pdgSeriesData.startDate=DateFormat.format(cal.getTime());
		
		cal.add(Calendar.DATE, 21);
	    
		if(userAccount.equalsIgnoreCase(CAAccount)){
			DateFormat=new SimpleDateFormat("dd/MM/yyyy");
		}else{
			DateFormat=new SimpleDateFormat("MM/dd/yyyy");
		}
		
		pdgSeriesData.endDate=DateFormat.format(cal.getTime());
	    
	    assertTrue(enterDate(selenium,txtStartdate,pdgSeriesData.startDate),"Could not enter the start Date;More Details:"+pdgSeriesData.toString(), selenium, ClassName, MethodName);
	    assertTrue(type(selenium,txtStartTimeHour,pdgSeriesData.startHour ),"Could not enter the starting hour ", selenium, ClassName, MethodName);
	    assertTrue(type(selenium,txtStartTimeMins,pdgSeriesData.startMin ),"Could not enter the starting min", selenium, ClassName, MethodName);
		
	    selectValueFromAjaxList(selenium,ajxForAmPMSeries,pdgSeriesData.timeAmPM);
	    
	
		assertTrue(click(selenium,rdoWeekly),"could not click the radio button", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtEvery,pdgSeriesData.everyWeek ),"Could not enter on every text box", selenium, ClassName, MethodName);
		if(!isChecked(selenium,chkMonday)){
		    assertTrue(click(selenium,chkMonday),"could not click Monday check box", selenium, ClassName, MethodName);
		}
		if(!isChecked(selenium,chkTuesday)){
		    assertTrue(click(selenium,chkTuesday),"could not click Tuesday check box", selenium, ClassName, MethodName);
		}
		
		assertTrue(click(selenium,rdoDate),"could not click the radio button", selenium, ClassName, MethodName);
		assertTrue(enterDate(selenium,txtEndDate1,pdgSeriesData.endDate),"Could not enter the End Date;More Details:"+pdgSeriesData.toString(), selenium, ClassName, MethodName);
		
	    assertTrue(click(selenium,btnNext),"could not click Next button", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    assertTrue(selectValueFromAjaxList(selenium,txtSearch1,pdgSeriesData.patientName ),"Could not enter patinet name", selenium, ClassName, MethodName);
	    selenium.keyPress(txtPatientBox, "\\9");
	    waitForElement(selenium,lblPatientResult,10000);
	    waitForPageLoad(selenium);
	    if(selenium.isElementPresent("css=div.patientInfoWidget")){
		assertTrue(selenium.isElementPresent("css=div.patientInfoWidget"),"Search Results are not displayed for the patient with ID :-"+pdgSeriesData.patientName, selenium, ClassName, MethodName);
		assertTrue(getText(selenium,"css=div.patientInfoWidget").toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.patientName.trim().toLowerCase(new java.util.Locale("en","US"))), "",selenium, ClassName, MethodName);
		click(selenium,"css=div.patientInfoWidget");
	    }else{
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+pdgSeriesData.patientName, selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.patientName.trim().toLowerCase(new java.util.Locale("en","US"))),"cant fine text", selenium, ClassName, MethodName);
		click(selenium,lblPatientResult);
		}
		waitForPageLoad(selenium);
	    assertTrue(getText(selenium,lblAddparticipant).toLowerCase(new java.util.Locale("en","US")).trim().contains(pdgSeriesData.patientName.toLowerCase(new java.util.Locale("en","US")).trim()),"Add participant failed", selenium, ClassName, MethodName);
	    
	    assertTrue(click(selenium,btnDone),"could not click Done button", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    
	    if(isElementPresent(selenium,btnAdd)){
	    	return returnValue;
	    }
	    else{
	    	Assert.fail("Series Creation Failed");
	    }
	    return returnValue;
	}

	  /**
	     * noAccessUserSchedulingSettings
	     * function to No Access User System Settings
	     * @throws IOException 
	     * @since Nov 11, 2013
	     */   
	    public boolean noAccessUserSchedulingSettings(Selenium selenium, SchedulingTestLib cdsData, String userAccount) throws IOException {
	          try{
	                
	                
	                assertTrue(click(selenium,lnkQuickAction),"Could not click on the link" + cdsData .toString(), selenium, ClassName, MethodName);
	                waitForPageLoad(selenium);
	                
	                assertTrue(!selenium.isElementPresent("css=#schedulingSettingsAction > span.actionItemSpan"),"System Setting Link is Visible",selenium, ClassName, MethodName);
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
	     * fullViewAccessUserSchedulingSettings
	     * function to Full View Access User System Settings
	     * @throws IOException 
	     * @since       August 30, 2013
	     */   
	    public boolean fullViewAccessUserSchedulingSettings(Selenium selenium, SchedulingTestLib cdsData, String userAccount) throws IOException {
	          try{
	                
	                assertTrue(click(selenium,lnkSettings),"Could not click on the link" + cdsData .toString(), selenium, ClassName, MethodName);
	                waitForPageLoad(selenium);
	                assertTrue(click(selenium,lnkScheduling),"Could not click the systemSettings link;More Deatils:"+cdsData.toString(), selenium, ClassName, MethodName);
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
	    
	    
	    public boolean switchPractice(Selenium selenium, String practiceName) throws IOException {

			String allPractices = "xpath=(//a[contains(@id,'practice')])";
			String currentPractice ="";
			String currentPracticeName = "";
			boolean practiceFound = false;
			boolean result = false;

			click(selenium, "locationMenuHeader");	

			int n = (Integer) selenium.getXpathCount(allPractices);
			System.out.println("Total practices for current user are = " +n);
			for (int i = 1; i <= n; i++) {
				currentPractice = allPractices + "[" +i+ "]";
				currentPracticeName = getText(selenium,currentPractice);
				System.out.println("Practice - " +i+ " is: " +currentPracticeName ) ;

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
                 return practiceFound;
			}
	    /**
		 * unitNewPatient
		 * function for unitNewPatient
		 * @throws IOException 
		 * @since  	    Nov 11, 2013
		 */	
		public boolean unitNewPatient(Selenium selenium, SchedulingUnitTestLib pDGData) throws IOException{
				
			//--------------------------------------------------------------------//
			//  Step-8: Search InValid Patient		  //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,txtPatientSearch,pDGData.patientName),"Could not type patient name", selenium, ClassName, MethodName);
				
			selenium.keyPress(txtPatientSearch, "\\9");
			waitForElement(selenium,lblPatientResult,10000);
			if(selenium.isElementPresent("css=div.patientInfoWidget")){
			assertTrue(selenium.isElementPresent("css=div.patientInfoWidget"),"Search Results are not displayed for the patient with ID :-"+pDGData.patientName, selenium, ClassName, MethodName);
			assertTrue(getText(selenium,"css=div.patientInfoWidget").toLowerCase(new java.util.Locale("en","US")).trim().contains(pDGData.patientName.trim().toLowerCase(new java.util.Locale("en","US"))),"cant find the text", selenium, ClassName, MethodName);
			click(selenium,"css=div.patientInfoWidget");
			}else{
				assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+pDGData.patientName, selenium, ClassName, MethodName);
				assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(pDGData.patientName.trim().toLowerCase(new java.util.Locale("en","US"))),"cant finf text", selenium, ClassName, MethodName);
				click(selenium,lblPatientResult);
			}
			if(selenium.isTextPresent("Patient not found. Add new patient"))
			{
			assertTrue(selenium.isTextPresent("Patient not found. Add new patient"),"Patient not found. Add new patient text is not present", selenium, ClassName, MethodName);
				
			assertTrue(click(selenium,"//div[@class='searchPatientPopupItem borderBottom padding15 large']"),"Could not click ", selenium, ClassName, MethodName);
				
			//Create New Patient
			assertTrue(type(selenium,txtFirstName, pDGData.fName),"Could not enter the reason", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtLastName, pDGData.lName),"Could not enter the comments", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPhonNo, pDGData.phone),"Could not enter the reason", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtEmail, pDGData.email),"Could not enter the comments", selenium, ClassName, MethodName);
			}
			if(pDGData.testCaseId.equals("TC_UP_016")){
				selectValueFromajxListForUnit(selenium,ajxshowFillter,pDGData.priorState);
			}else
			selectValueFromAjaxList(selenium,ajxshowFillter,pDGData.priorState);
			assertTrue(type(selenium,txtReason, pDGData.reason),"Could not enter the reason", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtComments, pDGData.comments),"Could not enter the comments", selenium, ClassName, MethodName);
			
			if(pDGData.testCaseId.equals("TC_UP_012")||pDGData.testCaseId.equals("TC_UP_013")||pDGData.testCaseId.equals("TC_UP_014")
					||pDGData.testCaseId.equals("TC_UP_015")||pDGData.testCaseId.equals("TC_UP_016")||pDGData.testCaseId.equals("TC_UP_021")){
				assertTrue(click(selenium,lnkbtnExternalAdd),"Could not click the add button", selenium, ClassName, MethodName);
			}
				
			return true;
		}
		

	}	





	


