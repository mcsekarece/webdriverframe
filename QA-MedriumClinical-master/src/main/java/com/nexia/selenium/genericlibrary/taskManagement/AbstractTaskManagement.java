package com.nexia.selenium.genericlibrary.taskManagement;

import static com.sharedlibrary.ThreadSafeSeleniumSessionStorage.session;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;

import com.sharedlibrary.AbstractTest;
import com.thoughtworks.selenium.Selenium;
//import org.apache.tools.ant.types.CommandlineJava.SysProperties;

public class AbstractTaskManagement  extends AbstractTest{

	//Navigateto Create General Task
	public String lnkQuickLink = "link=Quick actions";
	public String lnkCreateGeneralTsk = "newGeneralTaskAction";
	public String commentImage= "css=div.display-cell.workqueue-comment" ; 
	//Create General Task
	public String txtTaskName = "instructionsTextBox";
	public String txtInstructions = "instructionsTextBoxId";
	
	// FIXME  VEL-6936
	public String txtReassignReason = "reAssignReason";

	public String PopUpEncounterChoosePanel= "xpath=(//div[@class='popupContent'])";
	public String ajxDueIn1 = "timeCountSuggestBoxsuggestBox";
	public String ajxDueIn = "dueInTimeCountSuggestBoxsuggestBox";
	public String ajxAssignUser = "assignToSuggestBoxsuggestBox";
	public String chkUrgentBox = "urgentTaskcheckbox";
	public String ajxNotifyMe = "notifyMeInTimeCountSuggestBoxsuggestBox";
	public String ajxNotifyMeFormat ="notifyMeInTimeUnitSuggestBoxsuggestBox";
	public String lnkMoreOptions = "link=More options";
	public String btnSave = "saveID";
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
    public String txtDailyDate = "interval";
    public String txtWeeklyDate = "//div[3]/div/div/input";
    public String txtRecurringEnd = "xpath=(//input[@type='text'])[16]";
    public String txtYearly = "css=input.inline-text-box.width-45"; 

	//Navigate to Create Patient Task
	public String lnkPatientOption = "link=Patient Options";
	public String lnkCreateTask = "patientOptionsCreateTask";
	
	//Create Patient Task
	public String txtTaskType="taskTypeSuggestBoxsuggestBox";
	public String txttaskName="taskQuickList";
	public String txtInstruction = "instructionsTextBoxId";
	public String txtEveryDay= "css=input.inline-text-box.width-45";
	public String txtOccurrences = "occurrencenum";
	public String txtEndDate = "xpath=(//input[@type='text'])[21]";
	public String ajxDateOfMonth = "dateOfMonthSuggestBoxsuggestBox";
	public String ajxDueTimeCount = "xpath=(//input[@id='timeCountSuggestBoxsuggestBox'])[2]";
	public String ajxPractice = "selectPracticeSuggestBoxsuggestBox";
	public String ajxUserrole = "selectUserSuggestBoxsuggestBox";
	public String ajxWeekOfMonth = "recurringMonthlyQualifierSuggestBoxsuggestBox";
	public String ajxDayofMonth = "daySelectionSuggestBoxsuggestBox";
	public String ajxDateOfYear="dateOfMonthYearlySuggestBoxsuggestBox";
	public String ajxMonth = "monthSelectionSuggestBoxsuggestBox";
	public String ajxNotifyMeIn= "xpath=(//input[@id='timeCountSuggestBoxsuggestBox'])[3]";
	public String chkDaily = "dailyradio";
	public String chkMonthly = "monthlyradio";
	public String chkDayOfMonth = "dayOfMonthradio";
	public String chkWeekOfMonth = "weekOfMonthradio";
	public String chkYearly = "yearlyradio";
	public String chkAfter= "afterradio";
	public String chkEndDate = "dateradio";
	public String chkUrgentTask="urgentTaskcheckbox";
	
	//Navigate to Task Queue
	public String backbtn= "back";
	public String lnkTask = "Tasks";
	public String lnkTaskNotification = "Tasknotifications";

	public String lblWorkQueueListItem ="workqueueListItem";
	

	public String lblWorkQueueListItem1 ="taskTypeOrName1";
	
	//Search Task Data
	public String txtTaskSearchbox= "searchTextBox";
	// #FIXME MNT-1373 
	public String txtReason = "css=div.margin-bottom-10.width-410 > textarea.gwt-TextArea";
	public String txtCannotCompleteReason = "//div[2]/div[2]/textarea";
	public String txtNotify= "//div[5]/div[2]/textarea";
	public String txtComment ="//blockquote/div/div/input";
	public String ajxSuggest="suggestBox";
	public String lnkTaskList="TaskListMoreLink";
	public String lnkAction = "actionAnchor";
	public String lnkPutOnHold= "taskActionPutOnHold";
	public String lnkNotifyAssigner= "taskActionNotifyAssigner";
	public String lnkCannotComplete="taskActionCannotComplete";
	public String lnkReassign = "taskActionReassign";
	public String lnkAddComment= "link=Add Comment";
	public  String lnkSave="link=Save";
	public String recurrencePopUp = "css=div.popupContent";
	public String btnContinue="continueCompleteButton";
	public String btnComplete= "complete";
	public String btnSend= "sendButton";
	public String btnCancel="cancelCompleteButton";
	public String btnRemove= "remove";
	public String btnRemove1= "css=button.primary-button";
	public String btnEdit= "editReassign";
	public String imgComment = "css=div.comments-numbered";
	public String labcomment = "//div[3]/div/div/blockquote";
	public String chkSelectAllBox = "selectAllcheckbox";
	public String chckOnlyThisRecurrence = "taskEditOnlyThisradio";
	public String chkAllRecurrence="taskEditAllradio";
	public String lnkShowMoreTask="TaskListMoreLink";
	
	//Encounter
	public String lnkencounterTab ="!chartEncounters";
	public String inkUnSignedEnCounterAction="//div[starts-with(@id,'action')]";
	public String txtdeleteReason = "deleteReason";
	public String btnBeginEncounter="BeginEncounterButton";
	public String lblEncounterChoosePanel="xpath=(//div[@class='popupContent'])[2]";
	public String lnkStartNewWncouter="beginNewEncounter";
	public String lnkEncounterAction="//a[contains(text(),'Actions')]";
	public String lnkAssginTask = "assignTask";
	public String lnkBeginEncounterAction="actionAnchorEncounter";
	public String lnkDeleteEncounter= "//div[contains(@id,'encounterDelete')]";
	public String lnkDeleteReason="//button[@id='deleteReason']";	
	public String lblEncounterTask = "//span[@id='patientEducationProvided']/following-sibling::div";
	public String lblEncounterEditTask = "//span[@id='patientEducationProvided']/following-sibling::div/div/a[2]";
	public String lnkTaskEdit = "edit";
	public String ajxProviderSugBox="providersuggestBox";
	public String btnErrorClose="errorCloseButton";
	public String lnkShowMore = "EncountersPendingListMoreLink";
	public String lnkEncounterPendingList="//div[contains(@id,'EncountersPendingList')]/table/tbody/tr";
	public String lstActionSaveEncounter = "//a[@id='saveEncounter']";  

	
	//chart Summary
	public String lnkchartSummary = "!chartSummary";
	public String lnktimeLine= "!chartTimeline";
	public String lnkEncounter = "!chartEncounters";
	public String lnkLab = "!chartLabReportsFlowSheet";
	public String lnkMedication = "!chartMedications";
	
	//Attachment
	public String lnkAttachment = "addAttachment";
	public String btnUpload="docManagementFileUpload-browse-anchor";
	public String btnFileSave="save";
	public String lnkViewAttachment = "link=View Attachment";
	public String txtuploadpop="docManagementFileUpload-file-upload";
	
	//Reports
	public String lnkReport="xpath=(//a[@id='securitySettingsAction']/span)[2]";
	
	/**
	 * navigateTo Create a General Task
	 * Function to go to Create a General Task
	 * @param 	selenium
	 * @throws  
	 * @since	August 28,2013
	 */
	public boolean navigateToCreateGeneralTask(Selenium selenium)  {
		
		try {
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkCreateGeneralTsk), "Could not click on Create General Task button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	

	/**
	 * CreateGeneralTaskUnit
	 * Function to Create a General Task for  Unit Test
	 * @param 	selenium
	 * @since	August 28,2013
	 */
	
	public boolean UnitTest_CreateGeneralTask(Selenium selenium,TaskManagementUnitLib CreateGeneralTask){
try{
		assertTrue(type(selenium,  txtTaskName,CreateGeneralTask.taskName), "Could not type Task Name",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,  txtInstructions,CreateGeneralTask.instructions), "Could not type Instructions",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(CreateGeneralTask.testCaseId.equals("TC_UCG_002")){
			assertTrue(selectValueFromajxListForUnit(selenium,ajxAssignUser,CreateGeneralTask.assignTo), "Could not type assign To ",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}else{
				assertTrue(selectValueFromAjaxList(selenium,ajxAssignUser,CreateGeneralTask.assignTo), "Could not type assign To ",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
		
		if(CreateGeneralTask.testCaseId.equals("TC_UCG_004")){
		assertTrue(selectValueFromajxListForUnit(selenium,ajxDueIn,CreateGeneralTask.dueIn), "Could not type dueIn",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}else{
			assertTrue(selectValueFromAjaxList(selenium,ajxDueIn,CreateGeneralTask.dueIn), "Could not type dueIn",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		if(CreateGeneralTask.testCaseId.equals("TC_UCG_006")){
		assertTrue(selectValueFromajxListForUnit(selenium,ajxDueInUnit,CreateGeneralTask.dueDateUnit), "Could not type dueDate unit",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}else{
		assertTrue(selectValueFromAjaxList(selenium,ajxDueInUnit,CreateGeneralTask.dueDateUnit), "Could not typedueDate unit ",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}

		assertTrue(click(selenium, lnkMoreOptions), "Could not click on more options button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(CreateGeneralTask.testCaseId.equals("TC_UCG_008")){
		assertTrue(click(selenium,chkAssignTo), "Could not click on check  box AssignTo button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		if(CreateGeneralTask.testCaseId.equals("TC_UCG_011")||CreateGeneralTask.testCaseId.equals("TC_UCG_012")||CreateGeneralTask.testCaseId.equals("TC_UCG_013")||CreateGeneralTask.testCaseId.equals("TC_UCG_014")
				||CreateGeneralTask.testCaseId.equals("TC_UCG_015")||CreateGeneralTask.testCaseId.equals("TC_UCG_016")||CreateGeneralTask.testCaseId.equals("TC_UCG_017")||CreateGeneralTask.testCaseId.equals("TC_UCG_018")
				||CreateGeneralTask.testCaseId.equals("TC_UCG_019")||CreateGeneralTask.testCaseId.equals("TC_UCG_020")||CreateGeneralTask.testCaseId.equals("TC_UCG_021")||CreateGeneralTask.testCaseId.equals("TC_UCG_022")
				||CreateGeneralTask.testCaseId.equals("TC_UCG_023")||CreateGeneralTask.testCaseId.equals("TC_UCG_024")||CreateGeneralTask.testCaseId.equals("TC_UCG_025")||CreateGeneralTask.testCaseId.equals("TC_UCG_026")
				||CreateGeneralTask.testCaseId.equals("TC_UCG_027")||CreateGeneralTask.testCaseId.equals("TC_UCG_028"))	{

			assertTrue(click(selenium,chkRecurring), "Could not click on check  box Recurring button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(CreateGeneralTask.testCaseId.equals("TC_UCG_011")||CreateGeneralTask.testCaseId.equals("TC_UCG_012")){
				assertTrue(type(selenium, txtOccurences,CreateGeneralTask.endAfterOccurences), "Could not type End after occurences",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				}
			if(CreateGeneralTask.testCaseId.equals("TC_UCG_013")||CreateGeneralTask.testCaseId.equals("TC_UCG_014")){
				assertTrue(click(selenium,rdoRecurringEnd), "Could not click on check  Recurring End radio button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(type(selenium, txtRecurringEnd,CreateGeneralTask.recurringEndDate), "Could not type Recurring EndDate",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			if(CreateGeneralTask.testCaseId.equals("TC_UCG_015")||CreateGeneralTask.testCaseId.equals("TC_UCG_016")){
				assertTrue(click(selenium,rdoRecurringDaily), "Could not click on check  Recurring Daily radio button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				if(CreateGeneralTask.testCaseId.equals("TC_UCG_015")){
				assertTrue(selectValueFromajxListForUnit(selenium,txtDailyDate,CreateGeneralTask.recurringDailyDate), "Could not type Recurring Daily Date ",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				}else{
					assertTrue(selectValueFromAjaxList(selenium,txtDailyDate,CreateGeneralTask.recurringDailyDate), "Could not type Recurring Daily Date ",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			}
			
           if(CreateGeneralTask.testCaseId.equals("TC_UCG_017")||CreateGeneralTask.testCaseId.equals("TC_UCG_018")){
				
				assertTrue(click(selenium,rdoRecurringWeekly), "Could not click on check  Recurring Weekly Radio button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				if(CreateGeneralTask.testCaseId.equals("TC_UCG_017")){
				assertTrue(selectValueFromajxListForUnit(selenium,txtWeeklyDate,CreateGeneralTask.recurringDailyDate), "Could not type Recurring Weelkly",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				}else{
					
					assertTrue(selectValueFromAjaxList(selenium,txtWeeklyDate,CreateGeneralTask.recurringDailyDate), "Could not type Recurring Weelkly",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			}
          
           if(CreateGeneralTask.testCaseId.equals("TC_UCG_019")||CreateGeneralTask.testCaseId.equals("TC_UCG_020")){
				
				assertTrue(click(selenium,rdoRecurringMonthly), "Could not click on check  Recurring Monthly Radio button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(click(selenium,rdoRecurringDayofMonth), "Could not click on check  Recurring Day of Month Radio button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(selectValueFromAjaxList(selenium,txtRecurringDayofMonth,CreateGeneralTask.recurringDailyDate), "Could not type Monthly Day of Month ",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
          
           if(CreateGeneralTask.testCaseId.equals("TC_UCG_021")||CreateGeneralTask.testCaseId.equals("TC_UCG_022")||CreateGeneralTask.testCaseId.equals("TC_UCG_023")||CreateGeneralTask.testCaseId.equals("TC_UCG_024")){
				
				assertTrue(click(selenium,rdoRecurringMonthly), "Could not click on check  Recurring Monthly Radio button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(click(selenium,rdoRecurringWeekOfMonth), "Could not click on check  Recurring Week of Month Radio button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(selectValueFromAjaxList(selenium,txtRecurringMonthlyQualifier,CreateGeneralTask.recurringDailyDate), "Could not type Recurring Monthly Qualifier of Month ",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(selectValueFromAjaxList(selenium,txtRecurringDaySelection,CreateGeneralTask.recurringDailyDate), "Could not type Recurring Day Selection of Month ",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);

           }
           
           if(CreateGeneralTask.testCaseId.equals("TC_UCG_025")||CreateGeneralTask.testCaseId.equals("TC_UCG_026")||CreateGeneralTask.testCaseId.equals("TC_UCG_027")||CreateGeneralTask.testCaseId.equals("TC_UCG_028")){
				
				assertTrue(click(selenium,chkYearly), "Could not click on check  Recurring Yearly Radio button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(type(selenium, txtYearly,CreateGeneralTask.recurringEndDate), "Could not type Recurring EndDate",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(selectValueFromAjaxList(selenium,ajxDateOfYear,CreateGeneralTask.recurringDailyDate), "Could not type Recurring Date of Yearly ",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(selectValueFromAjaxList(selenium,ajxMonth,CreateGeneralTask.recurringDailyDate), "Could not type Recurring Month of Yearly ",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
          }
			
		}
		
		if(CreateGeneralTask.testCaseId.equals("TC_UCG_009")||CreateGeneralTask.testCaseId.equals("TC_UCG_010")){
		
		assertTrue(selectValueFromAjaxList(selenium,ajxNotifyMe,CreateGeneralTask.notifyMe), "Could not type NotifyMe",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selectValueFromAjaxList(selenium,ajxNotifyMeFormat,CreateGeneralTask.notifyUnit), "Could not type notify Format",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		
		}
		
		assertTrue(click(selenium, btnSave), "Could not click on Save button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
	catch (Exception e){
		Assert.fail();
		
	}
return false;
	}

	/**
	 * CreateGeneralTask
	 * Function to Create a General Task 
	 * @param 	selenium
	 * @since	Sep 03,2013
	 */
	
	public boolean CreateGeneralTask(Selenium selenium,TaskManagementLib CreateGeneralTask,String uniqueName){
		try{
		String provider= getText(selenium, lnkTopMenu);
		String onBehalfOf= provider.replaceAll(", "+CreateGeneralTask.switchRole, "");
		
		if(CreateGeneralTask.testCaseId.equals("TC_GT_007")||CreateGeneralTask.testCaseId.equals("TC_GT_008")){

		assertTrue(type(selenium,txtTaskName,CreateGeneralTask.taskName+uniqueName), "Could not type unique Task Name",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}else if(CreateGeneralTask.testCaseId.equals("TC_GT_009")){
			assertTrue(type(selenium,txtTaskName,CreateGeneralTask.taskName+uniqueName), "Could not type Task Name",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}else{
		
			assertTrue(type(selenium,txtTaskName,CreateGeneralTask.taskName), "Could not type Task Name",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		assertTrue(selectValueFromAjaxList(selenium,ajxDueIn,CreateGeneralTask.dueIn), "Could not type dueIn",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxDueInUnit,CreateGeneralTask.dueDateUnit), "Could not typedueDate unit ",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(CreateGeneralTask.testCaseId.equals("TC_GT_007")||CreateGeneralTask.testCaseId.equals("TC_GT_008")||CreateGeneralTask.testCaseId.equals("TC_GT_009")){
			assertTrue(selectValueFromAjaxList(selenium,ajxAssignUser,onBehalfOf), "Could not type assign To ",selenium, ClassName, MethodName);
		}else if(CreateGeneralTask.testCaseId.equals("TC_GT_007")){
			assertTrue(selectValueFromAjaxList(selenium,ajxAssignUser,CreateGeneralTask.switchRole), "Could not type assign To ",selenium, ClassName, MethodName);
		}
		else
		assertTrue(selectValueFromAjaxList(selenium,ajxAssignUser,CreateGeneralTask.assignTo), "Could not type assign To ",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!CreateGeneralTask.testCaseId.equals("TC_GT_001")){
		assertTrue(type(selenium, txtInstructions,CreateGeneralTask.instructions), "Could not type Instructions",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkMoreOptions), "Could not click on more options button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		if(CreateGeneralTask.testCaseId.equals("TC_GT_004")){
			
			assertTrue(click(selenium,chkRecurring), "Could not click on check  box Recurring button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,rdoRecurringDaily), "Could not click on check  Recurring Daily radio button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(type(selenium,txtDailyDate,CreateGeneralTask.recurringDailyDate), "Could not type Recurring Daily Date ",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtOccurences,CreateGeneralTask.endAfterOccurences), "Could not type End after occurences",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}
		if(CreateGeneralTask.testCaseId.equals("TC_GT_005")){
			
			assertTrue(click(selenium,chkAssignTo), "Could not click on check  box AssignTo button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxPractice,CreateGeneralTask.otherPractice), "Could not type NotifyM",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxSelectAssignUser,"FULL"), "Could not type  select assign To ",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		assertTrue(selectValueFromAjaxList(selenium,ajxNotifyMe,CreateGeneralTask.notifyMe), "Could not type NotifyMe",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxNotifyMeFormat,CreateGeneralTask.notifyUnit), "Could not type notify Format",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		}
		if(CreateGeneralTask.testCaseId.equals("TC_GT_008")){
		    String providerName = null;
		    String providerNameTemp = null;
		    //get the provider name from top menu

		    providerNameTemp= getText(selenium, lnkTopMenu);
		    System.out.println(providerNameTemp);
		   providerName = providerNameTemp.replaceAll(", "+CreateGeneralTask.switchRole, "");
		   System.out.println(providerName);
		   assertTrue(selectValueFromAjaxList(selenium,ajxAssignUser,providerName), "Could not type assign To ",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    	/*Assert.assertTrue(click(selenium,"Administrator"), "Could not click on check  box AssignTo button");
			waitForPageLoad(selenium);*/
			assertTrue(click(selenium, chkUrgentBox), "Could not click on Urgent check box ",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		if(CreateGeneralTask.testCaseId.equals("TC_GT_006")){

			assertTrue(click(selenium, chkSaveToQuickList), "Could not click on Quick List check box ",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		assertTrue(click(selenium, btnSave), "Could not click on Save button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(isElementPresent(selenium,txtTaskName)){
			return false;
		}else{
			
			return true;
		}

		}
		catch(Exception e)
		{
			Assert.fail();
		}
		return false;
	}
	

	/**
	 * navigateToCreateTask
	 * Function to navivgate To Create Task
	 * @param 	selenium
	 * @throws IOException 
	 * @since	August 29,2013
	 */
	
	public boolean navigateToCreateTask(Selenium selenium) throws IOException{
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"could not click"
					+ "",selenium, ClassName, MethodName);
		
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkPatientOption), "Could not click on Patient option link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkCreateTask), "Could not click on create Task link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	
	/**
	 * unitTestInCreateTask
	 * Function to unit test in create task
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Sep 02,2013
	 */
	
	public boolean unitTest_CreateTask(Selenium selenium,TaskManagementUnitLib taskData) throws IOException{
		
		selectValueFromAjaxList(selenium,txtTaskType, taskData.taskType);
		assertTrue(type(selenium,txttaskName,taskData.taskName),"Could not enter the task", selenium, ClassName, MethodName);
		if(taskData.testCaseId.equals("TC_UCT_032")){
			selectValueFromajxListForUnit(selenium,ajxDueInUnit,taskData.onBehalfOf);
		}
		assertTrue(type(selenium,txtInstruction,taskData.instructions),"Could not enter the Instruction", selenium, ClassName, MethodName);
		if(taskData.testCaseId.equals("TC_UCT_002")){
			selectValueFromajxListForUnit(selenium,ajxDueTimeCount,taskData.dueIn);
		}else{
			selectValueFromAjaxList(selenium,ajxDueTimeCount, taskData.dueIn);
		}
		if(taskData.testCaseId.equals("TC_UCT_005")){
			selectValueFromajxListForUnit(selenium,ajxDueInUnit,taskData.dueDateUnit);
		}else if(!taskData.testCaseId.equals("TC_UCT_002")){
			selectValueFromAjaxList(selenium,ajxDueInUnit,taskData.dueDateUnit);
		}
		if(taskData.testCaseId.equals("TC_UCT_008")){
			selectValueFromajxListForUnit(selenium,ajxAssignUser,taskData.assignTo);
		}else if((!taskData.testCaseId.equals("TC_UCT_002"))&&(!taskData.testCaseId.equals("TC_UCT_005"))){
			selectValueFromAjaxList(selenium,ajxAssignUser,taskData.assignTo);
		}
		if(taskData.testCaseId.equals("TC_UCT_011")||taskData.testCaseId.equals("TC_UCT_012")||taskData.testCaseId.equals("TC_UCT_013")||taskData.testCaseId.equals("TC_UCT_014")||taskData.testCaseId.equals("TC_UCT_015")||taskData.testCaseId.equals("TC_UCT_016")||taskData.testCaseId.equals("TC_UCT_017")||taskData.testCaseId.equals("TC_UCT_018")||taskData.testCaseId.equals("TC_UCT_019")
				||taskData.testCaseId.equals("TC_UCT_020")||taskData.testCaseId.equals("TC_UCT_021")||taskData.testCaseId.equals("TC_UCT_022")||taskData.testCaseId.equals("TC_UCT_023")||taskData.testCaseId.equals("TC_UCT_024")||taskData.testCaseId.equals("TC_UCT_025")||taskData.testCaseId.equals("TC_UCT_026")||taskData.testCaseId.equals("TC_UCT_027")||taskData.testCaseId.equals("TC_UCT_028")||taskData.testCaseId.equals("TC_UCT_030")){
			assertTrue(click(selenium,lnkMoreOptions),"could not click the more option", selenium, ClassName, MethodName);
			if(taskData.assignToUser.equals("Yes")){
				assertTrue(click(selenium,chkAssignTo),"could not click the assign to User check box", selenium, ClassName, MethodName);
				if(taskData.testCaseId.equals("TC_UCT_011")){
					selectValueFromajxListForUnit(selenium,ajxPractice,taskData.assignToPractice);
				}else{
					selectValueFromAjaxList(selenium,ajxPractice,taskData.assignToPractice);
				}if(taskData.testCaseId.equals("TC_UCT_013")){
					selectValueFromajxListForUnit(selenium,ajxUserrole,taskData.assignToUserorUserRole);
				}else{
					selectValueFromAjaxList(selenium,ajxUserrole,taskData.assignToUserorUserRole);
				}
			}
			if(taskData.recurring.equals("Yes")){
				assertTrue(click(selenium,chkRecurring),"could not click the Recurring check box", selenium, ClassName, MethodName);
				if(taskData.daily.equals("Yes")){
					assertTrue(click(selenium,chkDaily),"could not click the Daily ration button", selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtEveryDay,taskData.intervalperiod),"Could not enter the interval period", selenium, ClassName, MethodName);
					
				}
				if(taskData.monthly.equals("Yes")){
					assertTrue(click(selenium,chkMonthly),"could not click the Monthly Radio button", selenium, ClassName, MethodName);
					if(taskData.testCaseId.equals("TC_UCT_018")){
						assertTrue(click(selenium,chkDayOfMonth),"could not click the Day of Month Radio button", selenium, ClassName, MethodName);
						selectValueFromajxListForUnit(selenium,ajxDateOfMonth,taskData.intervalperiod);
					}
					if(taskData.testCaseId.equals("TC_UCT_019")||taskData.testCaseId.equals("TC_UCT_020")){
						assertTrue(click(selenium,chkWeekOfMonth),"could not click the Day of Month Radio button", selenium, ClassName, MethodName);
						selectValueFromAjaxList(selenium,ajxWeekOfMonth,taskData.weekOfMonth);
						selectValueFromAjaxList(selenium,ajxDayofMonth,taskData.dayOfMonth);
					}
				}
				if(taskData.yearly.equals("Yes")){
					assertTrue(click(selenium,chkYearly),"could not click the Yearly Radio button", selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,ajxDateOfYear,taskData.weekOfMonth);
					selectValueFromAjaxList(selenium,ajxMonth,taskData.dayOfMonth);
				}
					
				if(taskData.testCaseId.equals("TC_UCT_023")||taskData.testCaseId.equals("TC_UCT_024")||taskData.testCaseId.equals("TC_UCT_025")){
					assertTrue(click(selenium,chkAfter),"could not click the After Radio button", selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtOccurrences,taskData.ocurrence),"Could not enter the Ocurrence", selenium, ClassName, MethodName);
				}
				if(taskData.testCaseId.equals("TC_UCT_026")||taskData.testCaseId.equals("TC_UCT_027")||taskData.testCaseId.equals("TC_UCT_028")){
					assertTrue(click(selenium,chkEndDate),"could not click the After Radio button", selenium, ClassName, MethodName);
					assertTrue(enterDate(selenium,txtEndDate,taskData.endDate),"Could not enter the Ocurrence", selenium, ClassName, MethodName);
				}
			}
			if(taskData.testCaseId.equals("TC_UCT_030")){
				selectValueFromAjaxList(selenium,ajxNotifyMeIn,taskData.notifyMe);
			}
			selectValueFromAjaxList(selenium,ajxDateOfYear,taskData.weekOfMonth);
		}
		assertTrue(click(selenium,btnSave),"could not click the save button",selenium, ClassName, MethodName);
		return true;
	}
	
	public boolean createPatientTask(Selenium selenium,TaskManagementLib taskData,String uniqueName) throws IOException{
		String providerNameTemp= getText(selenium, lnkTopMenu);
		String onBehalfOf= providerNameTemp.replaceAll(", "+taskData.switchRole, "");
	
		String provideTemp= getText(selenium, lnkTopMenu);
		String provideTemp1= provideTemp.replaceAll(", "+taskData.switchRole, "");
		String tempArray[]=provideTemp1.split(" ");
		String provider=tempArray[1]+", "+tempArray[0];
		
		
		String userRoleTemp= getText(selenium, lnkTopMenu);
		String userRole= userRoleTemp.replaceAll(provideTemp1+",", "");
		
		if(!taskData.testCaseId.equals("TC_CGT_018")){
			selectValueFromAjaxList(selenium,txtTaskType, taskData.taskType);
		}
		if(taskData.testCaseId.equals("TC_CGT_004")||taskData.testCaseId.equals("TC_CGT_005")||taskData.testCaseId.equals("TC_CGT_012")
				||taskData.testCaseId.equals("TC_CGT_013")||taskData.testCaseId.equals("TC_CGT_014")||taskData.testCaseId.equals("TC_CGT_015")){
			assertTrue(type(selenium,txttaskName,taskData.taskName+uniqueName),"Could not enter the Reason", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxDueIn1,provider);
			waitForPageLoad(selenium);
		}else
			assertTrue(type(selenium,txttaskName,taskData.taskName+uniqueName),"Could not enter the task", selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtInstruction,taskData.instructions),"Could not enter the Instruction", selenium, ClassName, MethodName);
		selectValueFromAjaxList(selenium,ajxDueTimeCount, taskData.dueIn);
		selectValueFromAjaxList(selenium,ajxDueInUnit,taskData.dueDateUnit);
		if(taskData.testCaseId.equals("TC_CGT_006")||taskData.testCaseId.equals("TC_CGT_007")||taskData.testCaseId.equals("TC_CGT_008")||taskData.testCaseId.equals("TC_CGT_009")||taskData.testCaseId.equals("TC_CGT_010")
				||taskData.testCaseId.equals("TC_CGT_011")|| taskData.testCaseId.equals("TC_CGT_014")|| taskData.testCaseId.equals("TC_CGT_015")|| taskData.testCaseId.equals("TC_CGT_016")|| taskData.testCaseId.equals("TC_CGT_018")
					|| taskData.testCaseId.equals("TC_CGT_020")){
			if(taskData.testCaseId.equals("TC_CGT_008")||taskData.testCaseId.equals("TC_CGT_009")||taskData.testCaseId.equals("TC_CGT_010")
					||taskData.testCaseId.equals("TC_CGT_011")|| taskData.testCaseId.equals("TC_CGT_016")|| taskData.testCaseId.equals("TC_CGT_018")
					|| taskData.testCaseId.equals("TC_CGT_020")|| taskData.testCaseId.equals("TC_CGT_021")){
				selectValueFromAjaxList(selenium,ajxAssignUser,onBehalfOf);
			}else if(taskData.testCaseId.equals("TC_CGT_007")){
				selectValueFromAjaxList(selenium,ajxAssignUser,userRole);
			}else if(taskData.testCaseId.equals("TC_CGT_014")|| taskData.testCaseId.equals("TC_CGT_015")){
				selectValueFromAjaxList(selenium,ajxAssignUser,taskData.switchRole);
			}else{
				assertTrue(click(selenium,chkUrgentTask),"Could not click the urgent check box", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajxAssignUser,onBehalfOf);
			}
		}else if(taskData.testCaseId.equals("TC_CGT_012")|| taskData.testCaseId.equals("TC_CGT_013")){
			selectValueFromAjaxList(selenium,ajxAssignUser,userRole);
		}else
			selectValueFromAjaxList(selenium,ajxAssignUser,taskData.assignTo);
		
		if(taskData.testCaseId.equals("TC_CGT_002")||taskData.testCaseId.equals("TC_CGT_003")||taskData.testCaseId.equals("TC_CGT_020")){
			assertTrue(click(selenium,lnkMoreOptions),"could not click the more option", selenium, ClassName, MethodName);
			
			if(taskData.testCaseId.equals("TC_CGT_002")||taskData.testCaseId.equals("TC_CGT_020")){
				assertTrue(click(selenium,chkRecurring),"could not click the Recurring check box", selenium, ClassName, MethodName);
				assertTrue(click(selenium,chkDaily),"could not click the Daily ration button", selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtDailyDate,taskData.intervalperiod),"Could not enter the interval period", selenium, ClassName, MethodName);
				assertTrue(click(selenium,chkAfter),"could not click the After Radio button", selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtOccurrences,taskData.endAfterOccurences),"Could not enter the Ocurrence", selenium, ClassName, MethodName);
			}
			if(taskData.testCaseId.equals("TC_CGT_003")){
				assertTrue(click(selenium,chkAssignTo),"could not click the assign to User check box", selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajxPractice,taskData.anotherPractice);
				selectValueFromAjaxList(selenium,ajxUserrole,taskData.anotherUserOrUserRole);
			}
			selectValueFromAjaxList(selenium,ajxNotifyMe,taskData.notifyMe);
			selectValueFromAjaxList(selenium,ajxNotifyMeUnit,taskData.notifyUnit);
		}
		
		if(taskData.testCaseId.equals("TC_CGT_019")|| taskData.testCaseId.equals("TC_CGT_021")){
			assertTrue(click(selenium,btnEditCancel),"could not click the Cancel button",selenium, ClassName, MethodName);
		}else{
			assertTrue(click(selenium,btnSave),"could not click the save button",selenium, ClassName, MethodName);
		}
		
		
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"",selenium, ClassName, MethodName);
		
		return true;
	}
	
	/**
	 * LogoutofApplication
	 * Function to logoutofApplication
	 * @param 	selenium
	 * @since	Sep 03,2013
	 */
	
	public boolean logoutofApplication(Selenium selenium,TaskManagementLib CreateGeneralTask){
		
		
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
	 * verifyStoredValuesInTaskNotification
	 * Function to verifyStoredValuesInTaskNotification
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Sep 11,2013
	 */
	public boolean verifyStoredValuesInTaskNotification(Selenium selenium,TaskManagementLib createPatientTask, String account, int tempCount,String uniqueName) throws IOException{
		String date = null;
		String providerNameTemp= getText(selenium, lnkTopMenu);
		String onBehalfOf= providerNameTemp.replaceAll(", "+createPatientTask.switchRole, "");		
		
		String userRoleTemp= getText(selenium, lnkTopMenu);
		//String userRole= userRoleTemp.replaceAll("John Billy,", "");	
		Calendar cal=Calendar.getInstance();
		if(account.equals(CAAccount)){
			
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
			date=DateFormat.format(cal.getTime());
			int date1=Integer.parseInt(date);
			if(date1<10){
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
				date=DateForma1t.format(cal.getTime());
				
			}else{
				SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");
				date=DateFormat2.format(cal.getTime());
				
			}
		}else{
			SimpleDateFormat DateFormat2=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat2.format(cal.getTime());
		}
		
		assertTrue(isTextPresent(selenium,createPatientTask.patientID.toUpperCase().trim()),"",selenium, ClassName, MethodName);
			
		assertTrue(isTextPresent(selenium,createPatientTask.taskName+uniqueName.trim()),"",selenium, ClassName, MethodName);
			
	//	System.out.println(getText(selenium,lblWorkQueueListItem).toLowerCase(new java.util.Locale("en","US")).trim());
		
		
		if(!createPatientTask.testCaseId.equals("TC_CGT_012")||createPatientTask.testCaseId.equals("TC_CGT_013")){
			assertTrue(isTextPresent(selenium,"Task assigned to "),"",selenium, ClassName, MethodName);
				
		}else{
			//System.out.println(getText(selenium,"/workqueueListItem"));
		//	System.out.println("Task assigned to " + createPatientTask.switchRole + " on");
			assertTrue(isTextPresent(selenium,"Task assigned to " + createPatientTask.switchRole + " on"),"",selenium, ClassName, MethodName);
		}
		assertTrue(isTextPresent(selenium,date.trim()),"",selenium, ClassName, MethodName);
		return true;
	}
	
	/**
	 * deleteAllEncounters
	 * Function for delete All existing encounters
	 * @param selenium
	 * @param prescribeData
	 * @return
	 * @throws IOException 
	 * @since Jan 24,2013
	 */
	public boolean deleteAllEncounters(Selenium selenium,  TaskManagementLib createPatientTask) {
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
	 * goToBeginEncounter
	 * function to goToBeginEncounter
	 * @throws IOException 
	 * @since  	    Sep 12, 2012
	 */	
	
	public boolean goToBeginEncounter(Selenium selenium) throws IOException{
		try {

			//String onBehalfOf= provider.replaceAll(", "+orderData.switchRole, "");
			//String location = "";
			if(isElementPresent(selenium, btnErrorClose))

			assertTrue(click(selenium, btnErrorClose),"Could not click on Close Button",selenium, ClassName, MethodName);


			if (isElementPresent(selenium, btnBeginEncounter)) {
			assertTrue(click(selenium, btnBeginEncounter),"Could not click on Close Button",selenium, ClassName, MethodName);

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

			assertTrue(click(selenium, btnErrorClose),"Could not click on Close Button",selenium, ClassName, MethodName);

			waitForPageLoad(selenium);
			assertTrue(
			isElementPresent(selenium, lnkEncounterAction),
			"Sign button is not present",selenium, ClassName, MethodName);
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
	 * addAttachment
	 * function to addAttachment
	 * @throws      IOException 
	 * @throws InterruptedException 
	 * @since  	    Dec 26, 2012
	 */	
	
	public boolean addAttachment (Selenium selenium) throws IOException{
		
//	
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnUpload),"Could not click the Add Attachement Button", selenium, ClassName, MethodName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File dir1 = new File (".");
		String strBasePath = null;
		String file = null;
		String imgName = "Report.png";		
		String sectionName = "taskManagement";
		strBasePath=dir1.getCanonicalPath();
		
		file=strBasePath+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"nexia"+File.separator+"testdata"+File.separator+sectionName + File.separator + imgName;
		assertTrue(type(selenium,txtuploadpop,file),"Could not click Upload file", selenium, ClassName, MethodName);
		Robot robot = null;
		try {
			robot = new Robot();
			Thread.sleep(5000);
		}catch (AWTException e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ESCAPE);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnFileSave),"Could not click the save Button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
	
		
		
		return true;
	}
	
	
}



