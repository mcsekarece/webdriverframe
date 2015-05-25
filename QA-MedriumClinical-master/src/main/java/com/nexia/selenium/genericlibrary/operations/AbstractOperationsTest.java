package com.nexia.selenium.genericlibrary.operations;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.sharedlibrary.AbstractTest;
import com.thoughtworks.selenium.Selenium;

public class AbstractOperationsTest extends AbstractTest{

	//Quick Action
	public String chkbxIncludeInactive = "includeInactiveTemplatescheckbox";
	
	public String lnkReports= "link=Reports";
	public String IcoWebReports= "WebReportsLogo";


	public String lnkQuickAction= "link=Quick Actions";
	public String lnkScheduling = "schedulingSettingsAction";
	public String lnkOperations = "operationsAction";
	public String lnkWaitList = "link=Wait List Management";
	public String vfyPatientInstructions ="//div[@id='printInfo']/div/div/div[3]/div/div/div[2]/div/div[2]/span[2]";
    public String vfyBookInstructions ="//div[@id='printInfo']/div/div/div[3]/div/div/div[3]/div/div[4]/div/div/div[2]/span";
    public String lnkBumpList = "Patientsonbumplist";
    public String lblCurrentItem1 ="currentItem_1";
    
    
    //Wait List Management
    public String txtpatientSearchBox = "searchTextBox";
    public String lnkWaitListMgmt="waitListAction";
    public String txtReasonForDeleteWaitList="reasonForCancellationSuggestBoxsuggestBox";
    public String txtCallBackNumber=" ";
    public String ajxPriority="bassWaitingPrioritySuggestBoxsuggestBox";
    public String ajxVisitType="bassVisitTypeSuggestBoxsuggestBox";
    public String ajxResource="bassResourceSuggestBoxsuggestBox";
    public String ajxLocationWaitList="bassLocationSuggestBoxsuggestBox";
    public String txtDurationWaitList="duration";
    public String txtDurationWaitList1="xpath=(//input[@type='text'])[15]";
    public String lblWaitListMgmtSummary="WaitListManagementList";
    public String txtAreaComment="comments" ; 
    public String showUser="showToUserWhen";
	public String userCheckBoxOne="xpath=(//input[contains(@id,'checkboxshowToUser')])[1]";
	public String closeButton="multiSelectionCloseButton";
    public String lnkEditWaitList="EditWaitListManagementEdit";
    public String txtLastName="xpath=(//input[@type='text'])[4]";
    public String txtFirstName="xpath=(//input[@type='text'])[5]";
    public String txtDOB="xpath=(//input[@type='text'])[6]";
    public String txtEmail="xpath=(//input[@type='text'])[7]";
    public String txtPrimaryPhone="xpath=(//input[@type='text'])[8]";
    public String txtPatientSearch="searchTextBox";
    public String ajxVisitTypeWL = "xpath=(//input[@id='suggestBox'])[2]";
    public String ajxPriorityWL = "xpath=(//input[@id='suggestBox'])[3]";
    public String ajxLocationWL = "xpath=(//input[@id='suggestBox'])[4]";
    public String lnkClear="link=Clear";
    public String lblQuickValue1 = "css=span.gwt-InlineLabel.descriptionLabel";
    
    public String lnkWaitListQueue= "Patientsonwaitlist";
    public String lblWaitListQueueSummary="WaitListList";
    public String lblFirstWaitListQueue="//div[@id='WaitListList']/table/tbody/tr/td";
    public String lnkBack="back";
    public String lnkHideWaitListQueue="SlideWindowHideAnchor";
    public String lnkFirstWaitListQueue="//div[@id='WaitListList']/table/tbody/tr";
    public String lnkWaitListNext="xpath=(//button[@type='button'])[3]";
    public String lnkWaitListPrevious="//button[@type='button']";
    
    public String lblPatientInfoQueue="//div[@class='patientInfoWidget']";
    public String ajxVisitTypeQueue="xpath=(//input[@id='bassLocationSuggestBoxsuggestBox'])[2]";
    public String ajxResourceQueue="xpath=(//input[@id='suggestBox'])[8]";
    public String ajxLocationQueue="xpath=(//input[@id='suggestBox'])[9]";
    public String ajxDurationQueue="bassDuration";
    public String lnkMoreOptionQueue="//div[@class='inlineBlock pointer closedHeaderArrowNoABS']";
    
    public String btnLeftMessage="leftAMessage";
    public String btnAction="//button[@id='leftAMessage']/following-sibling::div";
    public String lnkCannotReach="//div[@class='waitListActions roundedCorner5px borderSolid1px999 lineHeight22 backgroundColourFAFAFA pointer textAlignLeft']/div/table/tbody/tr[1]/td/a";
    public String lnkRemoveFromWaitList="//div[@class='waitListActions roundedCorner5px borderSolid1px999 lineHeight22 backgroundColourFAFAFA pointer textAlignLeft']/div/table/tbody/tr[2]/td/div";
    public String txtAreaRemoveReason="//div[@class='popupTopRightPointer width300 addToWaitList']/div/div/div[2]/textarea";
    public String btnRemoveSave="xpath=(//button[@id='save'])[3]";
    
    public String chkAddPatientAlert="//label[text()='Add comment to patient alerts']/preceding-sibling::input";
    
    public String ajxConcerning="alertQuickList";

    public String txtCommentPatientAlert="xpath=(//textarea[@id='comments'])[2]";
    public String txtEndDate="endDate";
    //Enhancement Ticket in review
    public String lblPatientAlertArea="css=div.paddingTop15.paddingBottom5";
    
    
	//BookingAssistant
	public String lnkBookingAssistant = "!schedulingOperationsBookingAssistant";
	public String lnkVisitType="!schedulingSettingsVisitTypesList";
	public String ajxBassLocationVisitType = "bassLocationSuggestBoxsuggestBox";
	public String ajxBassLocationResource = "bassResourceSuggestBoxsuggestBox";
	public String ajxLocation = "bassLocationSuggestBoxsuggestBox";
	public String lnkAppointment = "//div[@id='bassAppointment0']";
	
	
	public String ajxShowTime2 = "bassShowOnly2SuggestBoxsuggestBox";
	public String txtBassDate1= "bassDate1";
	public String txtBassDate2= "bassDate2";
	public String btnShowMoreDetails = "//div[2]/div[2]/div/div[2]";
	public String txtDuration = "bassDuration";
	public String chkbxselectall = "bassSelectAllCheckBoxcheckbox";
	
	public String csspathsGroup1[]={"css=#searchResourceGroupsBox"};
	public String csspathsGroup[]={"css=#visitGroupName","css=#SearchBox"};
	
	public String tabVisitType = "css=#bassLocationSuggestBoxsuggestBox";
	public String tabResource = "css=#suggestBox";
	public String tabBassDuration = "css=#bassDuration";
	public String tabShowOnly = "css=#bassShowOnly1SuggestBoxsuggestBox";
	public String tabShowTime = "css=#bassShowOnly2SuggestBoxsuggestBox";
	public String tabStartDate = "css=#bassDate1";
	public String tabEndDate = "css=#bassDate2";
	public String tabSelectAll = "css=#bassSelectAllCheckBoxcheckbox";
	
	public String vfyRequiredSlot = "//div[@id='bookingAssistantAllSlots']/div/div/div/div[2]/div/table";
	public String txtReason = "reasonForVisitTextBox";
	public String chkbxSaveToQuickLst	=  "saveToQuickListcheckbox";
	public String btnQuickLst	= "css=button.quick-list-button.gradient";
	public String txtRecurringvisit	=  "//span/span/input";
	public String txtComment	= "//textarea";
	public String btnSaveId = "save";
	public String btnCancel = "cancel";
	
	public String txtpatientsearch = "searchPatientBoxInBookVisit";
	public String patientList1 = "SearchPatientPopupItem1";
	
	
	public String txtDurationVisit = "//div[2]/div[3]/div/div/div/input";
	public String chkBoxRecurringVisit = "//span/span/input";
	public String txtRecurringDays = "//div[3]/div/div/input";
	public String txtRecurringEnd = "//div[5]/div[2]/div/div/input";
	public String txtRecurringMonth =	"//div[2]/div/input"; 
	
	public String rdDailyRadio =	"dailyradio";
	public String rdMonthlyRadio =	"monthlyradio";
	public String rdDayOfMonth = "dayOfMonthradio";
	public String rdWeekOfMonth = "weekOfMonthradio";
	public String rdYearlyRadio =  "yearlyradio";
	public String rdDateRadio=	"dateradio";
	public String rdAfterRadio=	"afterradio";
	public String txtRecurringMonthlyOccurence =  "recurringMonthlyQualifierSuggestBoxsuggestBox";
	public String txtDaySelectionSuggestBoxsuggestBox = "daySelectionSuggestBoxsuggestBox";
	public String txtDateOfMonthSuggestBoxsuggestBox = "dateOfMonthSuggestBoxsuggestBox";
	
	public String txtDateOfMonthYerlySuggestsuggestBox = "dateOfMonthYearlySuggestBoxsuggestBox";
	public String txtMonthSelectionSuggestBoxsuggestBox = "monthSelectionSuggestBoxsuggestBox";
	
	public String  chkPatientAlert = "//div[2]/div/div/span/input";
	public String  btnSave2 =  "xpath=(//button[@id='save'])[2]";
	public String  txtStartDate = "//div[4]/div/input";
	//CheckInAssistant
	
	public String lnkCheckInAssistant = "!schedulingOperationsCheckInAssistant";
	public String lnkCalenderPreferences = "!schedulingSettingsPreferencesShow";
	public String chkEnablePatientTracking = "enablePatientTrackingcheckbox";
	public String lnkCheckInAssistantList = "AppointmentList";
	public String btnNextButton = "checkInWizard_NextButton";
	public String btnDoneButton = "checkInWizard_DoneButton";
	public String btnRefreshButton = "refreshButton";
	public String lnkPatientCheckout = "a.absoluteTopRight.checkOutPatient";
	public String lnkCheckInAppointmentCell = "appointmentCell";	
	public String btnEdit = "link=Edit";
	public String btnSave = "link=Save";
	public String popupCheckinWizard = "//div[@id='printInfo']/div/div/div[3]/div/div/div/div[3]/div/div/div/div[3]/div/div";
	public String vfyCheckinWizard = "//div[@id='printInfo']/div/div/div[3]/div/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div[2]/div/div";
	public String lnkActionClose ="//div[@id='printInfo']/div/div/div[3]/div/div/div/div[3]/div/div/div/div[3]/div/div/div/div/div[2]/div[2]/a/img";
	public String chkShowAgainIDcheckbox = "notShowAgainIDcheckbox";
	public String vfyRoomView = "//div[@id='roomsViewContainer']/div/div";
	public String vfyCheckinWizard1 ="//div[@id='blueHintMessagePanel']/div";
	
	public String vfyTodayDate = "//div[3]/div/div/div/div/div[2]/div";
	public String txtCheckInTime ="checkinTime-mins";
	public String txtCheckOutTime ="checkoutTime-mins";
	
	//CalenderView
	
	public String lnkOperationsCalender = "!schedulingOperationsCalendar";
	public String lnkAddResource = "Add Resource to this view";
	public String chkProviderCheckbox = "providerCheckbox1checkbox";
	
	
	public String btnActivate="Activate61";
	//public String btnActivate="//a[contains(@id,'Activate')]";
	public String chkIncludeInactive = "includeInactiveTemplatescheckbox";
	public String  txtSearchResourceCal=  "searchResourceCalTextBox";
	public String VfyCalenderViewDate =	"//div[3]/div/div/div/a";
	public String VfyCalenderView = "//div[3]/div/div/div/div[2]/div";
	public String VfyResource1 =  "//td/div/div[2]/div/a";
	public String VfyResource =  "//td[2]/table/tbody/tr/td/div/div/div/a";
	public String txtSearchResources = "searchResources";
	public String txtCancelReason = "cancellationReasonSuggestBoxsuggestBox";
	
	public String txtAddResources ="addResources";
	public String lnkAddResources ="//div[2]/a[2]";
	public String btnAdd  = "link=Add New";
	public String chkProvider ="//span/input";
	
	public String vfyVisitDetails ="//div[3]/div/div/div[2]/div/div";
	public String btnDelete="//a[contains(text(),'Delete')]";

	public String btnClose ="css=a.inlineBlock.remove-resource-from-view";
	public String lnkActions ="link=Actions";
	public String btnActions ="topMenuHeader";
	public String btnCancelAction ="cancelAction";
	public String rdoDoNotBump ="doNotBumpVisitsradio";
	public String lnkAssignCoveringResource ="css=span.topMenuItemSpan.light";
	public String lnkCancelRestOfDay ="css=#cancelAction > span.topMenuItemSpan.light";

	public String txtStartTime ="startTime-hour";
	public String txtEndTime ="setupEndTime-hour";	
	public String txtStartMin ="startTime-mins";
	public String txtStartFormat ="startTime-ampmsuggestBox";
	
	public String lnkCurrentView="link=Set current view as My View";
	public String lblCalendarView="css=div.gwt-Label";
	public String lnkBackView="link=Back to My View";
	public String lnkDay="link=Day";
	public String lnkWeek="link=Week";
	public String lnkAction1="xpath=(//a[contains(text(),'Actions')])[2]";
	public String lnkAction="xpath=(//a[contains(text(),'Actions')])[1]";
	
	public String lnkCancel="link=Cancel";
	public String lblNoResourceFound="noResourceFound";
	public String lnkClose="css=a.searchClose";
	
	public String lblPatientInfoInCheckInAssist= "//div[@id='wizardContentSection']/div";
	public String lnkCollectPayment="//div[@id='BlueNavigationWiget_MainPanel']/div[2]/div[2]/a";
	public String ajxSuggestBox="suggestBox";
	public String ajxResourceList ="resourceListSuggestBoxsuggestBox";
	public String ajxLocationList ="locationListSuggestBoxsuggestBox";
	
	public String ajxVisitLocation ="visitLocationBoxsuggestBox";
	public String ajxVisitTypeBox ="visitTypeOrGroupBoxsuggestBox";
	
	public String txtEndMinBox = "(//input[@id='mins'])[2]";
	public String txtEndHourBox = "(//input[@id='hour'])[2]";
	
	//ResourceCalender
    public String lnkResourceCalender = "!schedulingSettingsResourceCalendarsList";
    public String lnkResourceCalendarDel = "//div[@id='ResourceCalendarsList']/table/tbody/tr/td[4]/div/a";
    public String btnYesButton="yesButton";
	public String btnAddResCalandar="css=span.add";
    
    public String lblResourceCalendarSummaryArea="ResourceCalendarsList";
    public String ajxResCalOwnerBoxsuggestBox = "resCalOwnerBoxsuggestBox";
    public String ajxrunningMonthsBoxsuggestBox = "runningMonthsBoxsuggestBox";
    public String txtResCalEffectiveDate = "resCalEffectiveDate";
    public String txtPatternStartDayBoxsuggestBox = "patternStartDayBoxsuggestBox";
    public String txtPatternStartMonthBoxsuggestBox =  "patternStartMonthBoxsuggestBox";
    
    public String  btnresCalSave = "resCalSave";
    public String btnAddPatientButton="addPatientButton";
    
    //Non provider resource
    public String lnkDeleteNonProviderResource="//div[@id='NonProviderResourcesRoomsListWidget']/table/tbody/tr/td[3]/div/a";
    public String lnkNonProviderResource = "!schedulingSettingsNonProviderResourcesRoomsList";
	public String btnAddNonProviderResource = "nonProviderAdd";
	public String txtRoomName = "roomName";
	public String ajxlocation = "locationListSuggestBoxsuggestBox";
	public String btnSaveNonProviderResource = "link=Save";
	
	
	//Cases
	public String lnkDeleteCases="//div[@id='PatientCaseList']/table/tbody/tr/td[3]/div/a";
	public String btnAddCase="css=span.buttons > button.gwt-Button";
	public String txtDescription="description";
	public String ajkProgram="programIDSuggestBoxsuggestBox";
	public String lblTitle="css=span.title";
	public String btnSaveCases="save";
	public String lnkPatientCaseList="!patientCasesList";
	public String lnkExpandAll="link=Expand all";
	public String lnkEdit="//div[@id='PatientCaseList']/table/tbody/tr/td[2]/div/a";

	public String lnkAdd ="link=Add";
	public String lnkSave ="link=Save";
	public String chkBlkCoveringResourcecheckbox = "blockCoveringResourcecheckbox";
	public String chkBlkSelectedResourcecheckbox = "blockSelectedResourcecheckbox";
	public String chkBlkcoverDaycheckbox = "coverDaycheckbox";
	public String lnkDate = "//div[3]/div/div/div/a";
	public String lnkFourMonth = "//td[4]/table/tbody/tr/td/table/tbody/tr/td[2]";

	//WaitList Management
	public String lnkCreateGeneralTsk = "newGeneralTaskAction";
	public String lnkPrint = "css=div.marginTop5.printSendButton";
	//Patient Search
	
	public String lnkViewChart="link=View chart";
	public String lnkTimeLine="!chartTimeline";
	public String lnkBookAppont="link=Book appointment";
	public String lnkShowRecentPatient="link=Show recent patients";
	/**
	 * goToOperationsSection
	 * function to Operations section
	 * @throws IOException 
	 * @since  	    Jun 20, 2013
	 */	
	
	public boolean goToOperations(Selenium selenium) throws IOException{
		
		assertTrue(click(selenium,lnkQuickAction),"Could not click the link", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium,lnkOperations),"Could not find the Operations link", selenium, ClassName,MethodName);
		assertTrue(click(selenium,lnkOperations),"Could not click Operations link", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
	
	
	/**
	 * goToOperationsSection (Webdriver)
	 * function to Operations section
	 * @throws IOException 
	 * @since  	    Jun 20, 2013
	 */	
	
	public boolean goToOperations(WebDriver driver) throws IOException{
		
		
		driver.findElement(By.linkText("Quick actions")).click();
		
		//assertTrue(clickLinkText(driver,lnkQuickAction),"Could not click the link", driver, ClassName,MethodName);
		waitForPageLoad(driver);
		assertTrue(isElementPresent(driver,lnkOperations),"Could not find the Operations link",driver, ClassName,MethodName);
		assertTrue(click(driver,lnkOperations),"Could not click Operations link", driver, ClassName,MethodName);
		waitForPageLoad(driver);
		
		return true;
	}
	
	

	
	
	/**
	 * No Access User Navigation
	 * function to No Access Nvigation
	 * @throws IOException 
	 * @since  	    Jun 20, 2013
	 */	
	
	public boolean goToQuickActionNoAccess(Selenium selenium) throws IOException{
				
		assertTrue(click(selenium,lnkQuickAction),"Could not click the link", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present", selenium, ClassName,MethodName);
		assertTrue(!selenium.isTextPresent("error"),"Text Not Present", selenium, ClassName,MethodName);		
		assertTrue(selenium.isTextPresent("System Settings"),"Text Not Present", selenium, ClassName,MethodName);
		if(!selenium.isTextPresent("Calendar Settings")){
			return true;
		}
			
		return true;
	}
	
	
	/**
	 * goToSchedulingsection
	 * function to scheduling section
	 * @throws IOException 
	 * @since  	    Jun 26, 2013
	 */	
	
	public boolean goToScheduling(Selenium selenium) throws IOException{
		assertTrue(click(selenium,lnkQuickAction),"Could not click the link", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium,lnkScheduling),"Could not find the Scheduling link", selenium, ClassName,MethodName);
		assertTrue(click(selenium,lnkScheduling),"Could not click Scheduling link", selenium, ClassName,MethodName);
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
	
	
	/**
	 * Visit Details
	 * Visit Details  booking assistant section
	 * @throws IOException 
	 * @since  	    Jun 27, 2013
	 */	
	
	public boolean visitDetials(Selenium selenium,OperationsTestLib bookingAssistTestData) throws IOException{
		
	    if(bookingAssistTestData.testCaseId.equals("TC_VSP_005")){
	    	assertTrue(click(selenium,"saveAndAdd"),"Could not find save and Add", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[8]","ABRAHAM, ABBY"),"Could not select"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[9]","Medium"),"Could not select"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,"xpath=(//button[@id='save'])[2]"),"Could not click save button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		return true;
	    }
	    
		assertTrue(type(selenium,txtReason,bookingAssistTestData.reason),"Could not enter reason", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(type(selenium,txtComment,bookingAssistTestData.comment),"Could not enter comment", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
	
		assertTrue(click(selenium,btnSaveId),"Could click save button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,btnSaveId),"Could click save button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(isElementPresent(selenium,"saveAndAdd"),"Could not find save and Add", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		
		
		if(selenium.isElementPresent(lnkQuickAction)){
			return true;
		}else{
			return false;
		}
	
	}	
	
	/**
	 * visitDetialsForNewPatient
	 * Visit Details for new patient in  booking assistant section
	 * @throws IOException 
	 * @since  	    Oct 18, 2013
	 */	
	public boolean visitDetialsForNewPatient(Selenium selenium,OperationsTestLib bookingAssistTestData, String userAccount) throws IOException{
		
		String date =null;
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat;
		if(userAccount.equalsIgnoreCase(CAAccount)){
			DateFormat=new SimpleDateFormat("dd/MM/YYYY");
		}
		else{
			DateFormat=new SimpleDateFormat("MM/dd/YYYY");
		}
		date=DateFormat.format(cal.getTime());
		
		assertTrue(type(selenium,txtLastName,bookingAssistTestData.patientName),"Could not type last name", selenium, ClassName,MethodName);
		assertTrue(type(selenium,txtFirstName,bookingAssistTestData.patientName),"Could not type first name", selenium, ClassName,MethodName);
		assertTrue(enterDate(selenium,txtDOB,date),"Could not type DOB", selenium, ClassName,MethodName);
		assertTrue(type(selenium,txtPrimaryPhone,bookingAssistTestData.callBackNum),"Could not type primary number", selenium, ClassName,MethodName);

		assertTrue(click(selenium,btnSaveId),"Could click save button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		if(selenium.isElementPresent(lnkQuickAction)){
			return true;
		}else{
			return false;
		}
	
	}	
	
	/**
	 * SelectRequiredSlot
	 * SelectRequiredSlot in Booking Assistant
	 * @throws IOException 
	 * @since  	    Jun 28, 2013
	 */
	
	public boolean selectRequiredSlot(Selenium selenium,OperationsTestLib bookingAssistTestData) throws IOException{
		
		
		assertTrue(selectValueFromAjaxList(selenium,ajxBassLocationVisitType,bookingAssistTestData.visitType),"Could not select Visit type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		if(!bookingAssistTestData.testCaseId.equals("TC_SBA_004")){
		
			assertTrue(selectValueFromAjaxList(selenium,ajxBassLocationResource,bookingAssistTestData.resource),"Could not select resource type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxLocation,bookingAssistTestData.location),"Could not select location type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		
			if(getText(selenium,vfyRequiredSlot).toLowerCase(new java.util.Locale("en","Us")).trim().contains(bookingAssistTestData.resourceName.trim().toLowerCase(new java.util.Locale("en","Us")))){
				assertTrue(click(selenium,vfyRequiredSlot),"Could not click  required slot link", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			 }else{
				 return false;
			 }
			if(!selenium.isElementPresent(txtpatientsearch)){
				return false;
			}
		}
		return true;
		
	}



	/**
	* bookingAssistantUnitTest
	* function to Booking Assistant UnitTest
	 * @throws IOException 
	* @since Jun 20, 2013
	*/ 
					
	public boolean  bookingAssistantUnitTest(Selenium  selenium, OperationsUnitTestlib bookingAssistTestData,String account) throws IOException{ 	
	
	   
		assertTrue(selectValueFromAjaxList(selenium,ajxBassLocationVisitType,bookingAssistTestData.visitType),"Could not select Visit type"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
 		assertTrue(click(selenium,btnShowMoreDetails),"Could not click Show more details button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		if(bookingAssistTestData.testCaseId.equals("TC_UBA_003")){
			assertTrue(type(selenium,txtDuration,bookingAssistTestData.duration),"Could not enter Duration", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			return true;
		}else{
			assertTrue(type(selenium,txtDuration,bookingAssistTestData.duration),"Could not enter Duration", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		if((bookingAssistTestData.testCaseId.equals("TC_UBA_004"))||(bookingAssistTestData.testCaseId.equals("TC_UBA_005"))||(bookingAssistTestData.testCaseId.equals("TC_UBA_006"))||(bookingAssistTestData.testCaseId.equals("TC_UBA_007"))||(bookingAssistTestData.testCaseId.equals("TC_UBA_012"))||(bookingAssistTestData.testCaseId.equals("TC_UBA_014"))){
			if(account.equals(CAAccount)){
				assertTrue(type(selenium,txtBassDate1,bookingAssistTestData.startDateCA),"Could not enter StartDate", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
		    }else {
		    	assertTrue(type(selenium,txtBassDate1,bookingAssistTestData.startDate),"Could not enter StartDate", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}
		}
		
		if((bookingAssistTestData.testCaseId.equals("TC_UBA_008"))||(bookingAssistTestData.testCaseId.equals("TC_UBA_009"))||(bookingAssistTestData.testCaseId.equals("TC_UBA_010"))||(bookingAssistTestData.testCaseId.equals("TC_UBA_011"))||(bookingAssistTestData.testCaseId.equals("TC_UBA_013"))||(bookingAssistTestData.testCaseId.equals("TC_UBA_015"))){
						
			assertTrue(selectValueFromAjaxList(selenium,ajxShowTime2,bookingAssistTestData.showTime),"Could not select show time period"+bookingAssistTestData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(account.equals(CAAccount)){
				assertTrue(type(selenium, txtBassDate2,bookingAssistTestData.endDateCA),"Could not enter endDate", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selenium.click(txtBassDate2);
				selenium.keyPress(txtBassDate2, "\\13");
				selenium.fireEvent(txtBassDate2,"keydown");
				selenium.fireEvent(txtBassDate2,"keypress"); 
		    }else {
		    	
				assertTrue(type(selenium, txtBassDate2,bookingAssistTestData.endDate),"Could not enter endDate", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selenium.click(txtBassDate2);
				selenium.keyPress(txtBassDate2, "\\13");
				selenium.fireEvent(txtBassDate2,"keydown");
				selenium.fireEvent(txtBassDate2,"keypress"); 
			}
		
		}
		
		selenium.focus(chkbxselectall);
		selenium.click(chkbxselectall);
	   
	/*	Assert.assertTrue(click(selenium,chkbxselectall),"Could not click select all box");
		waitForPageLoad(selenium);*/
		
		
		return true;
	}


	
	/**
	* bookingVisitDetails UnitTest
	* function to booking VisitDetails UnitTest
	 * @throws IOException 
	* @since July 02, 2013
	*/ 
					
	public boolean  bookingVisitDetailsUnitTest(Selenium  selenium, OperationsUnitTestlib bookingAssistTestData,String account) throws IOException{ 	
	   
		assertTrue(type(selenium,txtReason,bookingAssistTestData.reason),"Could not enter reason", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
        
		if((bookingAssistTestData.testCaseId.equals("TC_UBV_001"))||(bookingAssistTestData.testCaseId.equals("TC_UBV_002"))
        		 ||(bookingAssistTestData.testCaseId.equals("TC_UBV_003"))||(bookingAssistTestData.testCaseId.equals("TC_UBV_004"))){
			assertTrue(type(selenium,txtDurationVisit,bookingAssistTestData.duration),"Could not enter reason", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		
		if(bookingAssistTestData.testCaseId.equals("TC_UBV_004")){
			return true;
		}
		
		}
		

		assertTrue(type(selenium,txtComment,bookingAssistTestData.comment),"Could not enter comment", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		if(bookingAssistTestData.testCaseId.equals("TC_UBV_023")||bookingAssistTestData.testCaseId.equals("TC_UBV_024")|| bookingAssistTestData.testCaseId.equals("TC_UBV_025")){
			if(!selenium.isChecked(chkPatientAlert)){
				assertTrue(click(selenium,chkPatientAlert),"Could not click Patient Alert check box",selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(type(selenium,txtStartDate,bookingAssistTestData.pateintAlertStartDate),"Could not type Date Of patient alert", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSave2),"Could click save button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			return true;
		}
		
		if(!(bookingAssistTestData.testCaseId.equals("TC_UBV_001")) || (bookingAssistTestData.testCaseId.equals("TC_UBV_002"))||(bookingAssistTestData.testCaseId.equals("TC_UBV_003")) || (bookingAssistTestData.testCaseId.equals("TC_UBV_004"))){
		
		if(!selenium.isChecked(chkBoxRecurringVisit)){
			assertTrue(click(selenium,chkBoxRecurringVisit),"Could not click Recurring Visit check box", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		}
	
		if((bookingAssistTestData.testCaseId.equals("TC_UBV_005")) || (bookingAssistTestData.testCaseId.equals("TC_UBV_006"))||(bookingAssistTestData.testCaseId.equals("TC_UBV_007"))){	 
		
			assertTrue(click(selenium,rdDailyRadio),"Could  not click Daily Radio ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(type(selenium,txtRecurringDays,bookingAssistTestData.recurringVisitDays),"Could not type Recurring Visit Days", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		if(bookingAssistTestData.testCaseId.equals("TC_UBV_007")){
			return true;
		}
		}

		if((bookingAssistTestData.testCaseId.equals("TC_UBV_008")) || (bookingAssistTestData.testCaseId.equals("TC_UBV_009"))||(bookingAssistTestData.testCaseId.equals("TC_UBV_010"))){
		
		     assertTrue(click(selenium,rdAfterRadio),"Could click After Radio ", selenium, ClassName,MethodName);
		     waitForPageLoad(selenium);
		     assertTrue(type(selenium,txtRecurringEnd,bookingAssistTestData.recurringVisitEnd),"Could not type Recurring Visit End", selenium, ClassName,MethodName);
		     waitForPageLoad(selenium);
		
		if(bookingAssistTestData.testCaseId.equals("TC_UBV_010")){
			return true;
		}

		}

		if((bookingAssistTestData.testCaseId.equals("TC_UBV_011")) || (bookingAssistTestData.testCaseId.equals("TC_UBV_012"))){
			assertTrue(click(selenium,rdDateRadio),"Could click Date Radio ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtRecurringMonth,bookingAssistTestData.recurringVisitEnd),"Could not type Recurring Visit Month", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		if((bookingAssistTestData.testCaseId.equals("TC_UBV_013")) || (bookingAssistTestData.testCaseId.equals("TC_UBV_014"))){
			
			assertTrue(click(selenium,rdMonthlyRadio),"Could click Monthly Radio ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,rdDayOfMonth),"Could click Day of Monthly Radio ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtDateOfMonthSuggestBoxsuggestBox,bookingAssistTestData.recurringVisitMonthly),"Could not type Date Of Month Suggest", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		
		}
		if((bookingAssistTestData.testCaseId.equals("TC_UBV_015")) || (bookingAssistTestData.testCaseId.equals("TC_UBV_016"))
				||(bookingAssistTestData.testCaseId.equals("TC_UBV_017")) || (bookingAssistTestData.testCaseId.equals("TC_UBV_018"))) {
			assertTrue(click(selenium,rdMonthlyRadio),"Could click Monthly Radio", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,rdWeekOfMonth),"Could click week of month Radio", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtRecurringMonthlyOccurence,bookingAssistTestData.recurringVisitMonthlyOccurence),"Could  not type  MonthlyOccurence", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtDaySelectionSuggestBoxsuggestBox,bookingAssistTestData.recurringVisitMonthly),"Could not type Monthly DaySelection", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		}
		
		if((bookingAssistTestData.testCaseId.equals("TC_UBV_019")) || (bookingAssistTestData.testCaseId.equals("TC_UBV_020"))
				|| (bookingAssistTestData.testCaseId.equals("TC_UBV_021"))|| (bookingAssistTestData.testCaseId.equals("TC_UBV_022"))){
			
			assertTrue(click(selenium,rdYearlyRadio),"Could click Yearly Radio", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtMonthSelectionSuggestBoxsuggestBox,bookingAssistTestData.recurringYearlyMonth),"Could  not type  yearly Month", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtDateOfMonthYerlySuggestsuggestBox,bookingAssistTestData.recurringVisitMonthly),"Could not type DateOfMonthYerly", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			}
		}
		
		assertTrue(click(selenium,btnSaveId),"Could click save button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
	/**
	 * searchPatientForBookingVisit
	 * function forsearchPatientForBookinfVisit 
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws IOException 
	 
	 * @since  	    jun 27, 2013
	 */
public boolean searchPatientForBookingVisit(Selenium selenium,String patientID) throws IOException{
		
		
		assertTrue(type(selenium,txtpatientsearch,patientID),"Could not type patient id", selenium, ClassName,MethodName);
	
		selenium.clickAt(txtpatientsearch,"");
		selenium.focus(txtpatientsearch);			
		selenium.fireEvent(txtpatientsearch,"keypress");
		waitForElement(selenium,lblPatientResult,10000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patientID, selenium, ClassName,MethodName);
		assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not get text", selenium, ClassName,MethodName);
	
		click(selenium,lblPatientResult);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,btnYesButton))
		{
			click(selenium,btnYesButton);
		}
		
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"Click Failed", selenium, ClassName, MethodName);
		return true;
		
	}
	
	/**
	 * searchPatientForBookingVisit
	 * function forsearchPatientForBookinfVisit 
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws IOException 
	 * @throws InterruptedException 
	 
	 * @since  	    July 30, 2014
	 */
	public boolean searchPatientForBookingVisitWD(WebDriver driver,String patientID) throws IOException, InterruptedException{
		
		try{
        assertTrue(type(driver,txtpatientsearch,patientID),"Could not type patient id",driver,ClassName,MethodName);
		
		Thread.sleep(6000); 
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);		
				
		if(isElementPresent(driver,patientList1)){
		assertTrue(isElementPresent(driver,patientList1),"Search Results are not displayed for the patient with ID :-"+patientID,driver,ClassName,MethodName);	
		
		click(driver,patientList1);
		}
		waitForPageLoad(driver);
		
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return true;		
	}
	
	
	/**
	 * BookingVisitForPatient
	 * function forsearchPatientForBookinfVisit 
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws IOException 
	 * @throws InterruptedException 
	 
	 * @since  	    July 30, 2014
	 */
	public boolean bookVisitWebDriver(WebDriver driver,OperationsTestLib bookingAssistTestData) throws IOException, InterruptedException{
		try{
			
        assertTrue(type(driver,txtReason,bookingAssistTestData.reason),"Could not type Reason for Visit",driver,ClassName,MethodName);
		
		Thread.sleep(6000); 
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);
		waitForPageLoad(driver);	
				
		
		assertTrue(click(driver,btnSaveId),"Could not type Reason for Visit",driver,ClassName,MethodName);
		
		}catch(RuntimeException e){
			e.printStackTrace();
		}
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
			 assertTrue(click(selenium, btnDelete), "Could not click the delete button", selenium, ClassName,MethodName);
			 assertTrue(click(selenium, btnYesButton), "Could not click the yes button in delete pop up", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
		 }
		if(getText(selenium, btnDelete).equalsIgnoreCase("Delete")){
			 resourceCalendarDeleted = false;
		 } 
		return resourceCalendarDeleted;
	}
	 
	 /*
	 * createPatternForResourceCalender
	 * function to createPatternForResourceCalender With MandatoryFields
	 * @since  	     July 05, 2013
	 */	
	 public boolean  createPatternForResourceCalender(Selenium selenium,OperationsTestLib createResourceCalData, String account) throws IOException{
            
			String date = null;  
		 
		    assertTrue(selectValueFromAjaxList(selenium,ajxResCalOwnerBoxsuggestBox,createResourceCalData.resource),"Could not select search resource"+createResourceCalData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
		    assertTrue(selectValueFromAjaxList(selenium,ajxrunningMonthsBoxsuggestBox,createResourceCalData.cycle),"Could not select proper cycle"+createResourceCalData.toString(), selenium, ClassName,MethodName);
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
		
			assertTrue(enterDate(selenium,txtResCalEffectiveDate,date),"Could not enter the Effective Date;More Details:"+createResourceCalData.toString(), selenium, ClassName,MethodName);
		    waitForPageLoad(selenium);
		  
		    	
	    	assertTrue(selectValueFromAjaxList(selenium,txtPatternStartDayBoxsuggestBox,createResourceCalData.patternStartsDate),"Could not select Pattern Day" +createResourceCalData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
	    	assertTrue(selectValueFromAjaxList(selenium,txtPatternStartMonthBoxsuggestBox,createResourceCalData.patternStartsMonth),"Could not select Pattern "+createResourceCalData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
	    
					    
		    assertTrue(click(selenium,btnresCalSave),"Could not click save button;More Details:"+createResourceCalData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium,btnEdit)){
				return false;
			}
			
		 return true;
	 }	 	
	
	 
	 /*
	 * createPatternForResourceCalender
	 * function to createPatternForResourceCalender With MandatoryFields
	 * @since  	     July 05, 2013
	 */	
	 public boolean  createPatternForResourceCalenderUnitTest(Selenium selenium,OperationsUnitTestlib createResourceCalData, String account) throws IOException{
            
			String date = null;  
		 
		    assertTrue(selectValueFromAjaxList(selenium,ajxResCalOwnerBoxsuggestBox,createResourceCalData.resource),"Could not select search resource"+createResourceCalData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxrunningMonthsBoxsuggestBox,createResourceCalData.cycle),"Could not select proper cycle"+createResourceCalData.toString(), selenium, ClassName,MethodName);
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
		
			assertTrue(enterDate(selenium,txtResCalEffectiveDate,date),"Could not enter the Effective Date;More Details:"+createResourceCalData.toString(), selenium, ClassName,MethodName);
		    waitForPageLoad(selenium);
		  
		    	
	    	assertTrue(selectValueFromAjaxList(selenium,txtPatternStartDayBoxsuggestBox,createResourceCalData.patternStartsDate),"Could not select Pattern Day" +createResourceCalData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
	    	assertTrue(selectValueFromAjaxList(selenium,txtPatternStartMonthBoxsuggestBox,createResourceCalData.patternStartsMonth),"Could not select Pattern "+createResourceCalData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
	    
					    
		    assertTrue(click(selenium,btnresCalSave),"Could not click save button;More Details:"+createResourceCalData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium,btnEdit)){
				return false;
			}
			
		 return true;
	 }
	 
	 /**
	 * navigateToNonProviderResource 
	 * function to navigate to Non Provider Resource
	 * @throws IOException 
	 * @since  	     June 06, 2013
	 */	
	 public boolean navigateToNonProviderResource(Selenium selenium) throws IOException {
		 assertTrue(click(selenium, lnkQuickAction), "could not able to click the quick action link", selenium, ClassName,MethodName);
		 assertTrue(click(selenium, lnkScheduling), "could not able to click the Scheduling Setting link", selenium, ClassName,MethodName);
		 assertTrue(click(selenium, lnkNonProviderResource), "could not able to click the Non Provider Resource link", selenium, ClassName,MethodName);
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
	 
	 
	 public boolean deleteAllNonProviderResource(Selenium selenium) throws IOException {
		 int nonProviderCount=(Integer) selenium.getXpathCount(lnkDeleteNonProviderResource);
		 
		 for(int count=1;count<=nonProviderCount;count++){
			 assertTrue(click(selenium, lnkDeleteNonProviderResource), "Could not click the delete button", selenium, ClassName,MethodName);
			 assertTrue(click(selenium, btnYesButton), "Could not click the yes button in delete pop up", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
		 }
		 
		 if(getText(selenium, lnkDeleteNonProviderResource).equalsIgnoreCase("Delete")){
			 return false;
		 } 
		 return true;
	 }
	 
	 /**
		 * Check Inactive Resources 
		 * function to Check Inactive Resources  With MandatoryFields
	 * @throws IOException 
		 * @since  	     June 07, 2013
		 */	
	
	 public boolean checkInactiveResource (Selenium selenium,OperationsTestLib createResourceCalData, String account) throws IOException {
			
		  boolean returnValue = false;
			 //Check Include Inactive
				
				if(!isChecked(selenium,"includeInactiveTemplatescheckbox")){
					assertTrue(click(selenium,"includeInactiveTemplatescheckbox"),"Could not click check include inactive", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
				}
				int resourceCount = (Integer)selenium.getXpathCount("//div[@id='ResourceCalendarsList']/table/tbody/tr/td/div");
				int activateCount = (Integer)selenium.getXpathCount("//tr[1]/td[5]/div/a");
				
				for(int count=1; count <=resourceCount; count++){				
					
					if(getText(selenium,"//div[@id='ResourceCalendarsList']/table/tbody/tr["+count+"]/td/div").contains("inactive")){
				      if(getText(selenium,"//div[@id='ResourceCalendarsList']/table/tbody/tr["+count+"]/td/div").contains(createResourceCalData.resourceName)){
							if(getText(selenium,"//tr["+count+"]/td[5]/div/a").contains("Activate")){
							assertTrue(click(selenium,"//tr["+count+"]/td[5]/div/a"),"Could not click activate button", selenium, ClassName,MethodName);
 						waitForPageLoad(selenium);
 						assertTrue(click(selenium,btnYes),"Could not click yes button", selenium, ClassName,MethodName);
 						waitForPageLoad(selenium);
 					   if(!createResourceCalData.testCaseId.equals("TC_SBA_006")){
 				   	    return returnValue = true;
 					         }
					       }
				       }
	             	}
					
					
					
					
				}
		      if(createResourceCalData.testCaseId.equals("TC_SBA_006")){
		    	  for(int count1=1; count1 <=resourceCount; count1++){
					if(getText(selenium,"//div[@id='ResourceCalendarsList']/table/tbody/tr["+count1+"]/td/div").contains("inactive")){
					      if(getText(selenium,"//div[@id='ResourceCalendarsList']/table/tbody/tr["+count1+"]/td/div").contains(createResourceCalData.resourceName1)){
								if(getText(selenium,"//tr["+count1+"]/td[5]/div/a").contains("Activate")){
								assertTrue(click(selenium,"//tr["+count1+"]/td[5]/div/a"),"Could not click activate button", selenium, ClassName,MethodName);
	    						waitForPageLoad(selenium);
	    						assertTrue(click(selenium,btnYes),"Could not click yes button", selenium, ClassName,MethodName);
	    						waitForPageLoad(selenium);
	    						return returnValue = true;
	    					  
							}
						}
					}
				}
		      }	
		      
		  	return returnValue;	 
		 
		 }
	 
	 
	 /**
		 * Check Inactive Resources 
		 * function to Check Inactive Resources  With MandatoryFields
	 * @throws IOException 
		 * @since  	     June 07, 2013
		 */	
	
	 public boolean checkInactiveResource (WebDriver driver,OperationsTestLib createResourceCalData, String account) throws IOException {
			
		  boolean returnValue = false;
			    //Check Include Inactive				
				if(!isChecked(driver,chkIncludeInactive)){
					assertTrue(click(driver,chkIncludeInactive),"Could not click check include inactive", driver, ClassName, MethodName);
					waitForPageLoad(driver);
				}
				
				//List<WebElement> allElements = driver.findElements(By.xpath("//resourceCalendarItem")); 
				
				int resourceCount = driver.findElements(By.xpath("//div[@id='resourceCalendarItem']")).size();			
				//int resourceCount = allElements.size();
				//int activateCount = (Integer)selenium.getXpathCount("//tr[1]/td[5]/div/a");
				
				System.out.println("resourceCount = " + resourceCount);
				
				System.out.println("First ResourceCalendar = " + driver.findElement(By.xpath("//div[@id='ResourceCalendarsList']/table/tbody/tr[1]/td")).getText());
				
				for(int count=1; count <=resourceCount; count++){												
					
					if(driver.findElement(By.xpath("//div[@id='ResourceCalendarsList']/table/tbody/tr["+count+"]/td")).getText().contains("inactive")){
						
						assertTrue(type(driver,txtSearchResourceCal,"Bbb"),"Could not select search resource", driver, ClassName, MethodName);
						waitForPageLoad(driver);
						waitForPageLoad(driver);
						waitForPageLoad(driver);
						
					    //if(driver.findElement(By.xpath("//div[@id='ResourceCalendarsList']/table/tbody/tr["+count+"]/td")).getText().contains(createResourceCalData.resourceName)){					
					    if(isElementPresent(driver,btnActivate)){
					    	assertTrue(click(driver,btnActivate),"Could not click activate button", driver, ClassName, MethodName);
					    	waitForPageLoad(driver);
							assertTrue(click(driver,btnYes),"Could not click yes button", driver, ClassName, MethodName);
							waitForPageLoad(driver);
						 if(!createResourceCalData.testCaseId.equals("TC_SBA_006")){
					   	    return returnValue = true;
						         }
						       }
					    //}
		             }				
				}
					      
		      
		  	return returnValue;	 
		 
		 }
		 
	 
	    /*
		 * createResourceCalender
		 * function to createResourceCalender With MandatoryFields
		 * @since  	     June 07, 2013
		 */	
	 
		 public boolean  createResourceCalender(Selenium selenium,OperationsTestLib createResourceCalData, String account) throws IOException{
	            
				String date = null;  
       
				assertTrue(click(selenium,btnAdd),"Could not click add new button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);	
				
				if(createResourceCalData.testCaseId.equals("TC_SBA_006")){
				 assertTrue(selectValueFromAjaxList(selenium,ajxResCalOwnerBoxsuggestBox,createResourceCalData.searchResource1),"Could not select search resource"+createResourceCalData.toString(), selenium, ClassName,MethodName);
				 waitForPageLoad(selenium);
				
				}else{
					assertTrue(selectValueFromAjaxList(selenium,ajxResCalOwnerBoxsuggestBox,createResourceCalData.searchResource),"Could not select search resource"+createResourceCalData.toString(), selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
				}
				
				assertTrue(selectValueFromAjaxList(selenium,ajxrunningMonthsBoxsuggestBox,createResourceCalData.cycle),"Could not select proper cycle"+createResourceCalData.toString(), selenium, ClassName,MethodName);
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
			
				
				assertTrue(enterDate(selenium,txtResCalEffectiveDate,date),"Could not enter the Effective Date;More Details:"+createResourceCalData.toString(), selenium, ClassName,MethodName);
			    waitForPageLoad(selenium);
			   
			    
			    assertTrue(click(selenium,btnresCalSave),"Could not click save button;More Details:"+createResourceCalData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(isChecked(selenium,chkbxIncludeInactive)){
					assertTrue(click(selenium,chkbxIncludeInactive),"Could not click check include inactive", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
				}
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
		 
			 public boolean  createResourceCalender(WebDriver driver,OperationsTestLib createResourceCalData, String account) throws IOException, InterruptedException{
		            
					String date = null;  
	       
					assertTrue(click(driver,btnAdd),"Could not click add new button", driver, ClassName, MethodName);
					waitForPageLoad(driver);	
					
					if(createResourceCalData.testCaseId.equals("TC_SBA_006")){
					 assertTrue(selectValueFromAjaxList(driver,ajxResCalOwnerBoxsuggestBox,createResourceCalData.searchResource1),"Could not select search resource", driver, ClassName, MethodName);
					 waitForPageLoad(driver);
					
					}else{
						assertTrue(selectValueFromAjaxList(driver,ajxResCalOwnerBoxsuggestBox,createResourceCalData.searchResource),"Could not select search resource", driver, ClassName, MethodName);
						waitForPageLoad(driver);
					}
					
					assertTrue(selectValueFromAjaxList(driver,ajxrunningMonthsBoxsuggestBox,createResourceCalData.cycle),"Could not select proper cycle", driver, ClassName, MethodName);
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
				
					
					assertTrue(enterDate(driver,txtResCalEffectiveDate,date),"Could not enter the Effective Date;More Details:"+createResourceCalData.toString(), driver, ClassName,MethodName);
				    waitForPageLoad(driver);
				   
				    
				    assertTrue(click(driver,btnresCalSave),"Could not click save button;More Details:", driver, ClassName, MethodName);
					waitForPageLoad(driver);
					if(isChecked(driver,chkbxIncludeInactive)){
						assertTrue(click(driver,chkbxIncludeInactive),"Could not click check include inactive", driver, ClassName, MethodName);
						waitForPageLoad(driver);
					}
					if(!isElementPresent(driver,btnEdit)){
						return false;
					}
				 return true;
			 }

		 
		 
	 	/**
		 * goToCases
		 * function to create a Case
		 * @since  	     APR 09, 2012
		 */	
		public boolean goToCases(Selenium selenium){
			try{
				
				click(selenium,lnkPatientCaseList);
				waitForPageLoad(selenium);
				if(waitForElement(selenium, btnAddCase, WAIT_TIME)){
					return true;
				}else{
					return false;
				}
			}catch (RuntimeException e) {
				e.printStackTrace();
				return false;
				
			}
		}
		
		/**
		 * deleteAllCases
		 * function to create a Case
		 * @throws IOException 
		 * @since  	     APR 09, 2012
		 */
		public boolean deleteAllCases(Selenium selenium) throws IOException{
			boolean caseDeleted = true;
			int caseCount = 0;
			try{
				waitForElement(selenium, lnkDeleteCases, WAIT_TIME);
				while((Integer) selenium.getXpathCount(lnkDeleteCases) > 0){
					caseCount = (Integer) selenium.getXpathCount(lnkDeleteCases);
					assertTrue(click(selenium,lnkDeleteCases),"Could not click Link Delete Cases", selenium, ClassName,MethodName);
					click(selenium,btnYesButton);
					waitForPageLoad(selenium);
					if(caseCount == (Integer) selenium.getXpathCount(lnkDeleteCases)){
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
		 * Go To Add Case
		 * function to navigate to add case
		 * @since  	     APR 09, 2012
		 */
		public boolean goToAddCase(Selenium selenium){
			try{
				try {
					assertTrue(click(selenium,btnAddCase), "Could not click Add Case", selenium, ClassName,MethodName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				waitForPageLoad(selenium);
				if(waitForElement(selenium, txtDescription, WAIT_TIME)){
					return true;
				}else{
					return false;
				}
			}catch (RuntimeException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		
		/**
		 * createCases
		 * function to create a Case
		 * @since  	     APR 09, 2012
		 */	

		public boolean createCases(Selenium selenium, HomeLib casesData,String account){
			
			try{
				assertTrue(type(selenium,txtDescription,casesData.description),"Could not enter Description ; More Details :"+casesData.toString(),selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajkProgram, casesData.program);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnSaveCases),"Could not click Save Button; More Details :" + casesData.toString(),selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(!isElementPresent(selenium,lblTitle ))
				{
					return false;
				}
			
			}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + casesData.toString());		
				return false;
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return true;
		}
	 
		/**
		 * Create New Cases
		 * @param selenium
		 * @param casesData
		 * @return
		 */
		public boolean verifyStoredValuesCreateCase(Selenium selenium, HomeLib casesData,String date,String account){
			boolean returnValue=true;
			waitForPageLoad(selenium);
			if(!getValue(selenium,txtDescription).trim().contains(casesData.description.trim())){
				returnValue= false;
			}
			if(!getValue(selenium,ajkProgram).trim().contains(casesData.program.trim())){
				returnValue= false;
			}
			return returnValue;
		}
		
		/**
		 * navigateTo Create a General Task
		 * Function to go to Create a General Task
		 * @param 	selenium
		 * @throws IOException 
		 * @since	August 28,2013
		 */
		public boolean navigateToCreateGeneralTask(Selenium selenium) throws IOException{
			
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkCreateGeneralTsk), "Could not click on Create General Task button",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			return true;
		}

		/**
		 * function to navigate wait list management
		 * @param 	selenium
		 * @throws IOException 
		 * @since	Sep 18,2013
		 */
		public boolean navigateToWaitListMgmt(Selenium selenium) throws IOException{
			
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions link",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkWaitListMgmt), "Could not click on wait list management link",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			return true;
		}
		
		/**
		 * function to delete All wait list
		 * @param 	selenium
		 * @throws IOException 
		 * @since  	     sep 18, 2013
		 */	
		 public boolean deleteAllWaitList(Selenium selenium) throws IOException{
			boolean  waitListDeleted=true;
			waitForPageLoad(selenium);
			
		    while((Integer) selenium.getXpathCount(btnDelete) > 0){
				 assertTrue(click(selenium, btnDelete), "Could not click the delete button",selenium, ClassName,MethodName);
				 waitForPageLoad(selenium);
				 assertTrue(type(selenium, txtReasonForDeleteWaitList, "Reason"), "Could not click the delete button",selenium, ClassName,MethodName);
				 assertTrue(click(selenium, btnSaveId), "Could not click the save button in delete reason pop up",selenium, ClassName,MethodName);
				 waitForPageLoad(selenium);
			}
			if(getText(selenium, btnDelete).equalsIgnoreCase("Delete")){
				waitListDeleted = false;
			} 
			return waitListDeleted;
		}
		 
		 /**
			* function to fill Wait List Details For Existing Patient
			* @param 	selenium
		 * @throws IOException 
			* @since  	     sep 18, 2013
			*/	
			public boolean fillWaitListDetailsForExistingPatient(Selenium selenium,OperationsTestLib waitListData, String userAccount) throws IOException{
				assertTrue(type(selenium,txtCallBackNumber,waitListData.callBackNum),"Could not type call back number",selenium, ClassName,MethodName);

				assertTrue(type(selenium,txtReason,waitListData.reason),"Could not type duration value",selenium, ClassName,MethodName);
				
				if(waitListData.testCaseId.equalsIgnoreCase("TC_VWL_010")){
					if(!isChecked(selenium, chkbxSaveToQuickLst))
						assertTrue(click(selenium,chkbxSaveToQuickLst),"Could not click save to quick list button",selenium, ClassName,MethodName);
				}

				assertTrue(selectValueFromAjaxList(selenium,ajxPriority,waitListData.priority),"Could not select priority value"+waitListData.toString(),selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				//It will be used for get the very first value of the visit type from the list
				/*click(selenium, ajxVisitType);
				waitForPageLoad(selenium);
				waitListData.visitType= getText(selenium, "//body/div[3]/div/div/div/div/div");*/
				
				assertTrue(selectValueFromAjaxList(selenium,ajxVisitType,waitListData.visitType),"Could not select visit type"+waitListData.toString(),selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(selectValueFromAjaxList(selenium,ajxResource,waitListData.resource),"Could not select resource"+waitListData.toString(),selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(selectValueFromAjaxList(selenium,ajxLocationWaitList,waitListData.location),"Could not select location"+waitListData.toString(),selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(type(selenium,txtDurationWaitList,waitListData.duration),"Could not type duration value",selenium, ClassName,MethodName);
				
				assertTrue(type(selenium,txtAreaComment,waitListData.comment),"Could not type duration value",selenium, ClassName,MethodName);
				
				
				if(waitListData.testCaseId.equalsIgnoreCase("TC_VWL_013")){
					assertTrue(click(selenium,chkAddPatientAlert),"Could check add patient alert check box",selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					assertTrue(type(selenium,ajxConcerning,waitListData.concerning),"Could not select concerning"+waitListData.toString(),selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,showUser),"unable to click to click to select",selenium,ClassName,MethodName);
					assertTrue(click(selenium,userCheckBoxOne),"Unable to click check box one",selenium,ClassName,MethodName);
					assertTrue(click(selenium,closeButton),"unable to click close button",selenium,ClassName,MethodName);
					assertTrue(type(selenium,txtCommentPatientAlert,waitListData.comment),"Could not type duration value",selenium, ClassName,MethodName);
					String date =null;
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat;
					if(userAccount.equalsIgnoreCase(CAAccount)){
						DateFormat=new SimpleDateFormat("dd/mm/yyyy");
					}
					else{
						DateFormat=new SimpleDateFormat("mm/dd/yyyy");
					}
					date=DateFormat.format(cal.getTime());
					
					assertTrue(enterDate(selenium,txtEndDate,date),"Could not type end date",selenium, ClassName,MethodName);
					
					assertTrue(click(selenium,btnSave2),"Could click save buttonin add patient alert",selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
				}
				
				assertTrue(click(selenium,btnSaveId),"Could click save button",selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				
				if(selenium.isElementPresent(lnkQuickAction)){
					return true;
				}else{
					return false;
				}
			
			}	
		
		/**
		* function to fill Wait List Details For New Patient
		* @param 	selenium
		 * @throws IOException 
		* @since  	     sep 18, 2013
		*/	
		public boolean fillWaitListDetailsForNewPatient(Selenium selenium,OperationsTestLib waitListData, String userAccount) throws IOException{
			String date =null;
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if(userAccount.equalsIgnoreCase(CAAccount)){
				DateFormat=new SimpleDateFormat("dd/MM/YYYY");
			}
			else{
				DateFormat=new SimpleDateFormat("MM/dd/YYYY");
			}
			date=DateFormat.format(cal.getTime());
			
			assertTrue(type(selenium,txtLastName,waitListData.patientName),"Could not type last name",selenium, ClassName,MethodName);
			assertTrue(type(selenium,txtFirstName,waitListData.patientName),"Could not type first name",selenium, ClassName,MethodName);
			assertTrue(enterDate(selenium,txtDOB,date),"Could not type DOB",selenium, ClassName,MethodName);
			assertTrue(type(selenium,txtPrimaryPhone,waitListData.callBackNum),"Could not type primary number",selenium, ClassName,MethodName);
 
			assertTrue(type(selenium,txtReason,waitListData.reason),"Could not type duration value",selenium, ClassName,MethodName);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxPriority,waitListData.priority),"Could not select priority value"+waitListData.toString(),selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//It will be used for get the very first value of the visit type from the list
			click(selenium, ajxVisitType);
			waitForPageLoad(selenium);
			waitListData.visitType= getText(selenium, "//body/div[3]/div/div/div/div/div");
			
			assertTrue(selectValueFromAjaxList(selenium,ajxVisitType,waitListData.visitType),"Could not select visit type"+waitListData.toString(),selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxResource,waitListData.resource),"Could not select resource"+waitListData.toString(),selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxLocationWaitList,waitListData.location),"Could not select location"+waitListData.toString(),selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtDurationWaitList1,waitListData.duration),"Could not type duration value",selenium, ClassName,MethodName);
			
			assertTrue(type(selenium,txtAreaComment,waitListData.comment),"Could not type duration value",selenium, ClassName,MethodName);
			
			assertTrue(click(selenium,btnSaveId),"Could click save button",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(selenium.isElementPresent(lnkQuickAction)){
				return true;
			}else{
				return false;
			}
		
		}	
		
		/**
		* function to verify Store Values Wait List Management
		* @param 	selenium 
		* @param 	waitListData
		* @param 	userAccount
		* @since  	sep 18, 2013
		*/	
		public boolean verifyStoreValuesWaitListMgmt(Selenium selenium,OperationsTestLib waitListData, String userAccount){
			String date =null;
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if(userAccount.equalsIgnoreCase(CAAccount)){
				DateFormat=new SimpleDateFormat("MMM d, yyyy");
			}
			else{
				DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			}
			date=DateFormat.format(cal.getTime());
			
			if(!getText(selenium,lblWaitListMgmtSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.priority.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			if(!getText(selenium,lblWaitListMgmtSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;
			}
			if(!getText(selenium,lblWaitListMgmtSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.patientName.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			if(!getText(selenium,lblWaitListMgmtSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.visitType.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			if(!getText(selenium,lblWaitListMgmtSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.duration.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			/*if(!getText(selenium,lblWaitListMgmtSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.resource.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}*/
			if(!getText(selenium,lblWaitListMgmtSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.reason.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			return true;
			 
		}
		
		
		/**
		* function to verify Store Values Wait List Queue
		* @param 	selenium 
		* @param 	waitListData
		* @param 	userAccount
		* @since  	Oct 09, 2013
		*/	
		public boolean verifyStoreValuesWaitListQueueSummary(Selenium selenium,OperationsTestLib waitListData, String userAccount){
			String date =null;
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if(userAccount.equalsIgnoreCase(CAAccount)){
				DateFormat=new SimpleDateFormat("MMM dd, YYYY");
			}
			else{
				DateFormat=new SimpleDateFormat("MM/dd/YYYY");
			}
			date=DateFormat.format(cal.getTime());
			
			if(!getText(selenium,lblWaitListQueueSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.priority.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			if(!getText(selenium,lblWaitListQueueSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;
			}
			if(!getText(selenium,lblWaitListQueueSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.patientName.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			if(!getText(selenium,lblWaitListQueueSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.visitType.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			if(!getText(selenium,lblWaitListQueueSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.duration.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			/*if(!getText(selenium,lblWaitListQueueSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.resource.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}*/
			if(!getText(selenium,lblWaitListQueueSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.reason.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			return true;
			 
		}
		
		/**
		* function to verify Store Values Wait List Queue
		* @param 	selenium 
		* @param 	waitListData
		* @param 	userAccount
		* @since  	Oct 10, 2013
		*/	
		public boolean verifyStoreValuesWaitListQueue(Selenium selenium,OperationsTestLib waitListData, String userAccount){
			if(!getText(selenium,lblPatientInfoQueue).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.patientName.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			if(!getValue(selenium,ajxVisitTypeQueue).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.visitType.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			if(!getValue(selenium,ajxResourceQueue).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.resource.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			if(!getValue(selenium,ajxLocationQueue).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.location.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			if(!getValue(selenium,txtReason).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.reason.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			
			if(isElementPresent(selenium, lnkMoreOptionQueue)){
				click(selenium, lnkMoreOptionQueue);
			}
			if(!getValue(selenium,ajxDurationQueue).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.duration.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			
			return true;
			 
		}
		
		/**
		* function to verify Store Values Wait List Management
		* @param 	selenium 
		* @param 	waitListData
		* @param 	userAccount
		* @since  	sep 18, 2013
		*/	
		public boolean verifyStoreValuesDoNotPresentInWaitListMgmt(Selenium selenium,OperationsTestLib waitListData, String userAccount){
			
			if(getText(selenium,lblWaitListMgmtSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.priority.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			if(getText(selenium,lblWaitListMgmtSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.patientName.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			if(getText(selenium,lblWaitListMgmtSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.duration.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			/*if(getText(selenium,lblWaitListMgmtSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.resource.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}*/
			if(getText(selenium,lblWaitListMgmtSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.reason.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			return true;
			 
		}
		
		
		/**
		* function to verify Store Values Wait List Queue
		* @param 	selenium 
		* @param 	waitListData
		* @param 	userAccount
		* @since  	Oct 09, 2013
		*/	
		public boolean verifyStoreValuesDoNotPresentInWaitListQueue(Selenium selenium,OperationsTestLib waitListData, String userAccount){
			
			if(getText(selenium,lblWaitListQueueSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.priority.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			if(getText(selenium,lblWaitListQueueSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.patientName.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			if(getText(selenium,lblWaitListQueueSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.duration.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			/*if(getText(selenium,lblWaitListQueueSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.resource.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}*/
			if(getText(selenium,lblWaitListQueueSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.reason.trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;                       
			}
			return true;
			 
		}
		
		/**
		* function to fill Wait List Details For Existing Patient Unit Test
		* @param 	selenium
		 * @throws IOException 
		* @since  	     sep 23, 2013
		*/	
		public boolean fillWaitListDetailsForExistingPatientUnitTest(Selenium selenium,OperationsUnitTestlib waitListData, String userAccount) throws IOException{
			assertTrue(type(selenium,txtCallBackNumber,waitListData.callBackNum),"Could not type call back number",selenium, ClassName,MethodName);

			assertTrue(type(selenium,txtReason,waitListData.reason),"Could not type duration value",selenium, ClassName,MethodName);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxPriority,waitListData.priority),"Could not select priority value"+waitListData.toString(),selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxVisitType,waitListData.visitType),"Could not select visit type"+waitListData.toString(),selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxResource,waitListData.resource),"Could not select resource"+waitListData.toString(),selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxLocationWaitList,waitListData.location),"Could not select location"+waitListData.toString(),selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtDurationWaitList,waitListData.duration),"Could not type duration value",selenium, ClassName,MethodName);
			
			assertTrue(type(selenium,txtAreaComment,waitListData.comment),"Could not type duration value",selenium, ClassName,MethodName);
			
			if(waitListData.testCaseId.equalsIgnoreCase("TC_UWL_003")){
				selenium.typeKeys(txtCallBackNumber, "a");
			}
			
			if(!waitListData.testCaseId.equalsIgnoreCase("TC_UWL_003")){
				assertTrue(click(selenium,btnSaveId),"Could click save button",selenium, ClassName,MethodName);
			}
			waitForPageLoad(selenium);
			
			if(selenium.isElementPresent(lnkQuickAction)){
				return true;
			}else{
				return false;
			}
		
		}	
		
		/**
		* function to fill Wait List Details For Existing Patient Unit Test
		* @param 	selenium
		 * @throws IOException 
		* @since  	     sep 24, 2013
		*/	
		public boolean fillWaitListDetailsForNewPatientUnitTest(Selenium selenium,OperationsUnitTestlib waitListData, String userAccount) throws IOException{
			String date =null;
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat;
			if(userAccount.equalsIgnoreCase(CAAccount)){
				DateFormat=new SimpleDateFormat("dd/MM/YYYY");
			}
			else{
				DateFormat=new SimpleDateFormat("MM/dd/YYYY");
			}
			date=DateFormat.format(cal.getTime());
			
			assertTrue(type(selenium,txtLastName,waitListData.lastName),"Could not type last name",selenium, ClassName,MethodName);
			assertTrue(type(selenium,txtFirstName,waitListData.firstName),"Could not type first name",selenium, ClassName,MethodName);
			
			if(waitListData.testCaseId.equalsIgnoreCase("TC_UWL_004")||waitListData.testCaseId.equalsIgnoreCase("TC_UWL_005")){
				assertTrue(enterDate(selenium,txtDOB,waitListData.DOB),"Could not type DOB",selenium, ClassName,MethodName);
			}else{
				assertTrue(enterDate(selenium,txtDOB,date),"Could not type DOB",selenium, ClassName,MethodName);
			}
			
			
			
			assertTrue(type(selenium,txtEmail,waitListData.eMail),"Could not type email address",selenium, ClassName,MethodName);

			assertTrue(type(selenium,txtReason,waitListData.reason),"Could not type duration value",selenium, ClassName,MethodName);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxPriority,waitListData.priority),"Could not select priority value"+waitListData.toString(),selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxVisitType,waitListData.visitType),"Could not select visit type"+waitListData.toString(),selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxResource,waitListData.resource),"Could not select resource"+waitListData.toString(),selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(selectValueFromAjaxList(selenium,ajxLocationWaitList,waitListData.location),"Could not select location"+waitListData.toString(),selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtDurationWaitList1,waitListData.duration),"Could not type duration value",selenium, ClassName,MethodName);
			
			assertTrue(type(selenium,txtAreaComment,waitListData.comment),"Could not type duration value",selenium, ClassName,MethodName);
			
			assertTrue(type(selenium,txtPrimaryPhone,waitListData.callBackNum),"Could not type primary number",selenium, ClassName,MethodName);
			
			if(waitListData.testCaseId.equalsIgnoreCase("TC_UWL_008")){
				selenium.typeKeys(txtPrimaryPhone, "a");
			}
			
			if(!waitListData.testCaseId.equalsIgnoreCase("TC_UWL_008")){
				assertTrue(click(selenium,btnSaveId),"Could click save button",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(selenium.isElementPresent(lnkQuickAction)){
				return true;
			}else{
				return false;
			}
			}
			return true;
		}	
		
		/**
		* function to verify Store Values Wait List Management
		* @param 	selenium 
		* @param 	waitListData
		* @param 	userAccount
		 * @throws IOException 
		* @since  	sep 18, 2013
		*/	
		public boolean verifyQuickListInWaitListMgmt(Selenium selenium,OperationsTestLib waitListData) throws IOException{
		assertTrue(click(selenium, lnkEditWaitList), "Could not click the edit wait list",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnQuickLst), "Could not click the quick list button",selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(!getText(selenium,lblQuickValue1).toLowerCase(new java.util.Locale("en","US")).trim().contains(waitListData.reason.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			return true;
		}
}

	
	


	
	

