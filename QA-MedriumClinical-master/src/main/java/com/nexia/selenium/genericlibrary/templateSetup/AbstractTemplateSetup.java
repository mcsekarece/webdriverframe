package com.nexia.selenium.genericlibrary.templateSetup;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.openqa.selenium.internal.seleniumemulation.TypeKeys;
import org.testng.Assert;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.sharedlibrary.AbstractTest;
import com.thoughtworks.selenium.Selenium;

public class AbstractTemplateSetup  extends AbstractTest{

	
	public String btnUploadFile="id=docManagementFileUpload-browse-anchor";
	public String txtBrowseFile="docManagementFileUpload-file-upload";
	//TemplateSetup
	public String lnkTemplateSetup="templateSetupAction";
	public String lnkDaySheetTemplate="!templatesDaysheet";
	public String btnAddDaySheetTemplate="link=Add New";
	public String btnEdit="link=Edit";
	public String btnDelete="//a[contains(text(),'Delete')]";
	public String txtTemplateName="templatesDaysheetAddName";
	public String txtTemplateEditName="templatesDaysheetEditName";
	public String txtFileUpload="templatesDaysheetAddFileUpload-file-upload";
	public String txtFileUploadInEdit="templatesDaysheetEditFileUpload-file-upload";
	public String chkTemplatesDaysheetAddIncludeEmptySlots="templatesDaysheetAddIncludeEmptySlotscheckbox";
	public String ajxTemplatesDaysheetAddSort="templatesDaysheetAddSortLSBsuggestBox";
	public String btnSave="link=Save";
	public String btnCancel="link=Cancel";
	public String btnPreview="link=Preview";
	public String lblSummaryDaySheetTemplate="//div[@class='display-table daysheet-list-panel']/div[1]";
	public String lblWholeSummaryDaySheetTemplate="//div[@class='display-table daysheet-list-panel']";
	public String chkIncludeInactive="//label[text()='Include inactives']/preceding-sibling::input";
	public String txtSearchDaySheetTemplate="xpath=(//input[@class='search-box'])[2]";
	public String lnkActive="link=Activate";
	public String lnkSearchClose="//a[@class='searchClose']";
	public String lblErrorMessage="//ol[@class='errorList']/li/div";
	public String btnErrorMEssageClose="errorCloseButton";
	public String lblTitlePreview="framePopupViewTitleLabel";
	public String lnkClosePreview="framePopupViewCloseButton";
	public String ajxSortDataBy="templatesDaysheetAddSortLSBsuggestBox";
	public String chkIncludeEmptyTimeSlot="templatesDaysheetAddIncludeEmptySlotscheckbox";
	public String lnkViewDetails="link=View details";
	public String btnDownload="//button[text()='Download']";
	public String lnkDelete = "link=Delete";
	
	//Daysheet Print
	public String lnkCalendar="operationsAction";
	public String lnkPrintReport="link=Print Report";
	public String ajxSelectDaySheetTemplate="OCPVUsingUsingSuggestBoxsuggestBox";
	public String txtSearchResource=txtSearchDaySheetTemplate;
	public String chkSelectAllResource="printReportSelectAllCheckBoxcheckbox";
	public String lnkSearch="link=Search";
	public String chkFirstResource="//div[@class='display-table searchResourcesPanel']/div/span/input";
	public String lblFirstResourceName="//div[@class='display-table searchResourcesPanel']/div/div";
	public String lblFirstResourceType="//div[@class='display-table searchResourcesPanel']/div/div[2]";
	public String lblSecondResourceName="//div[@class='display-table searchResourcesPanel']/div[2]/div";
	public String lblSecondResourceType="//div[@class='display-table searchResourcesPanel']/div[2]/div[2]";
	public String btnReset="link=Reset";
	public String btnPrint="link=Print";
	public String lblAddedResource="//div[@class='display-table addedResourcesPanel']";
	public String lblNoAddedResource="//div[@class='printReportAddedResourcesPanel']/div[2]";
	public String rdoPrintReportToday="printReportTodayCheckBoxradio";
	public String rdoPrintReportSpecificDate="printReportSpecificDateCheckBoxradio";
	public String txtPrintReportSpecificDate="printReportSpecificDateBox";
	public String rdoPrintReportDateRange="printReportDateRangeCheckBoxradio";
	public String txtPrintReportDateRangeFrom="printReportFromDateBox";
	public String txtPrintReportDateRangeTo="printReportToDateBox";
	public String rdoPrintReportFullDay="printReportFullDayCheckBoxradio";
	public String rdoPrintReportMorning="printReportMorningCheckBoxradio";
	public String rdoPrintReportAfternoon="printReportAfternoonCheckBoxradio";
	public String rdoPrintReportTimeRange="printReportTimeRangeCheckBoxradio";
	public String txtPrintReportFromTimeHour="OCPVPrintReportFromTimeInputPanel-hour";
	public String txtPrintReportFromTimeMins="OCPVPrintReportFromTimeInputPanel-mins";
	public String ajxFromTimeFormat="suggestBox";
	public String txtPrintReportToTimeHour="OCPVPrintReportToTimeInputPanel-hour";
	public String txtPrintReportToTimeMins="OCPVPrintReportToTimeInputPanel-mins";
	public String ajxToTimeFormat="xpath=(//input[@id='suggestBox'])[2]";
	public String lblSearchResourceSummary="//div[@class='display-table searchResourcesPanel']";
	
	public String uploadFileName= null;
	
	//File Document 
	public String lnkFileDoucment = "scanAction";
	public String ajxSelectBatch = "suggestBox";
	public String txtPatientSearch = "xpath=(//input[@id='searchPatientBox'])[2]";
	public String btnUpload="upload";
	public String btnFileDeleteDelete = "DW_btnRemoveCurrentImage";
	
	//FIXME VEL-5892
	public String lnkShowMoreActions = "css=a.dropdown-item.show-more";
	/**
	 * function to navigate day sheet template
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 22,2013
	 */
	public boolean navigateToDaySheetTemplate(Selenium selenium) throws IOException{
		
		assertTrue(click(selenium, lnkSettings), "Could not click on Quick Actions link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		assertTrue(click(selenium, lnkTemplateSetup), "Could not click on Template setup", selenium, ClassName, MethodName);
		
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkDaySheetTemplate), "Could not click on Day sheet template", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!isElementPresent(selenium, btnAddDaySheetTemplate)){
			return false;
		}
		return true;
	}
	
	/**
	 * function to navigate day sheet template
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 22,2013
	 */
	public boolean navigateToFileDocument(Selenium selenium) throws IOException{
		
		assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkFileDoucment), "Could not click on Template setup", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(!isElementPresent(selenium, ajxSelectBatch)){
			return false;
		}
		return true;
	}
	
	/**
	 * function to navigate print calendar
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 25,2013
	 */
	public boolean navigateToPrintCalendar(Selenium selenium) throws IOException{
		
		assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkCalendar), "Could not click on calendar link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkPrintReport), "Could not click on print report", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!isElementPresent(selenium, btnPrint)){
			return false;
		}
		return true;
	}
	
	/**
	 * function to delete All day sheet template
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 22,2013
	 */	
	 public boolean deleteAllDaySheetTemplate(Selenium selenium) throws IOException{
		boolean  waitListDeleted=true;
		waitForPageLoad(selenium);
		
	    while((Integer) selenium.getXpathCount(btnDelete) > 0){
			 assertTrue(click(selenium, btnDelete), "Could not click the delete button", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(click(selenium, lnkBtnYes),"Could not click Delete button;More Details:",selenium, ClassName, MethodName
);
			 waitForPageLoad(selenium);
		}
		if(getText(selenium, btnDelete).equalsIgnoreCase("Delete")){
			waitListDeleted = false;
		} 
		return waitListDeleted;
	}
	 
	/**
	* function to add new day sheet template
	* @param 	selenium
	* @throws IOException 
	* @since	Oct 22,2013
	*/	
	public boolean addNewDaySheetTemplate(Selenium selenium, TemplateSetupLib daySheetTemplateTestData, String account) throws IOException{
		File dir = new File(".");
		String strBasePath = null;
		String uploadFileFullPath = null;
		String uploadFileDirectory = null;
		String sectionName = "templateSetup";
		strBasePath = dir.getCanonicalPath();

		// get the file upload directory
		uploadFileDirectory = strBasePath + File.separator + "src"
				+ File.separator + "main" + File.separator + "resources"
				+ File.separator + "nexia" + File.separator + "testdata"
				+ File.separator + sectionName;

		File folder = new File(uploadFileDirectory);
		File[] listOfFiles = folder.listFiles();

		// loop through the list of files in the folder and get the file we want to rename
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				if (listOfFiles[i].getName().startsWith("standard")) {
					uploadFileName = listOfFiles[i].getName();
					break;
				}
			}
		}

		// get the full path of file we are going to upload
		uploadFileFullPath = strBasePath + File.separator + "src"
				+ File.separator + "main" + File.separator + "resources"
				+ File.separator + "nexia" + File.separator + "testdata"
				+ File.separator + sectionName + File.separator
				+ uploadFileName;


		// modify the file name with append of some random string
		Random ran =new Random();
		
		String randomString = generateRandomString(ran, "RandomStriung", 6);
		
		uploadFileName = "standard" + randomString + ".docx";

		String modifiedUploadFileFullPath = strBasePath + File.separator
				+ "src" + File.separator + "main" + File.separator
				+ "resources" + File.separator + "nexia" + File.separator
				+ "testdata" + File.separator + sectionName + File.separator
				+ uploadFileName;

		File oldFileName = new File(uploadFileFullPath);
		File newFileName = new File(modifiedUploadFileFullPath);

		if (!oldFileName.renameTo(newFileName)) {
			Assert.fail("Rename failed, for the file we are going to upload");
		} 
		assertTrue(click(selenium, btnAddDaySheetTemplate), "Could not click on add new Day sheet template", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//assertTrue(type(selenium,txtTemplateName,daySheetTemplateTestData.templateName),"Could not type template name", selenium, ClassName, MethodName);
			
		assertTrue(type(selenium,txtFileUpload, modifiedUploadFileFullPath),"Could not upload the file", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_TS_003")||daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_TS_004")||daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_TS_005")
			||daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_TS_006")||daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_TS_007")){

			assertTrue(selectValueFromAjaxList(selenium, ajxSortDataBy, daySheetTemplateTestData.sortDataBy), "Could not select sort data by in add Day sheet template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//check the include empty time slot
			if(!isChecked(selenium, chkIncludeEmptyTimeSlot)){
				assertTrue(click(selenium, chkIncludeEmptyTimeSlot), "Could not check the include empty time slot in Day sheet template", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
		}
		
		if(!daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_TS_008")){
			assertTrue(click(selenium,btnSave),"Could click save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		return true;
	}
	
	/**
	* function to edit day sheet template
	* @param 	selenium
	* @throws IOException 
	* @since	Oct 22,2013
	*/	
	public boolean editDaySheetTemplate(Selenium selenium, TemplateSetupLib daySheetTemplateTestData, String account) throws IOException{
		File dir = new File(".");
		String strBasePath = null;
		String uploadFileFullPath = null;
		String uploadFileDirectory = null;
		String sectionName = "templateSetup";
		strBasePath = dir.getCanonicalPath();

		// get the file upload directory
		uploadFileDirectory = strBasePath + File.separator + "src"
				+ File.separator + "main" + File.separator + "resources"
				+ File.separator + "nexia" + File.separator + "testdata"
				+ File.separator + sectionName;

		File folder = new File(uploadFileDirectory);
		File[] listOfFiles = folder.listFiles();

		// loop through the list of files in the folder and get the file we want to rename
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				if (listOfFiles[i].getName().startsWith("standard")) {
					uploadFileName = listOfFiles[i].getName();
					break;
				}
			}
		}

		// get the full path of file we are going to upload
		uploadFileFullPath = strBasePath + File.separator + "src"
				+ File.separator + "main" + File.separator + "resources"
				+ File.separator + "nexia" + File.separator + "testdata"
				+ File.separator + sectionName + File.separator
				+ uploadFileName;

		// modify the file name with append of some random string
		Random ran =new Random();
		
		String randomString = generateRandomString(ran, "RandomStriung", 6);
		
		uploadFileName = "standard" + randomString + ".docx";

		String modifiedUploadFileFullPath = strBasePath + File.separator
				+ "src" + File.separator + "main" + File.separator
				+ "resources" + File.separator + "nexia" + File.separator
				+ "testdata" + File.separator + sectionName + File.separator
				+ uploadFileName;

		File oldFileName = new File(uploadFileFullPath);
		File newFileName = new File(modifiedUploadFileFullPath);

		if (!oldFileName.renameTo(newFileName)) {
			Assert.fail("Rename failed, for the file we are going to upload");
		} 
		
		assertTrue(click(selenium, btnEdit), "Could not click on edit Day sheet template", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		type(selenium, txtTemplateEditName, "");
		assertTrue(type(selenium,txtFileUploadInEdit, modifiedUploadFileFullPath),"Could not upload the file", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		
		//While edit file extension also append with file name. So, Replace that using below logic
		//Replace File Extention
		uploadFileName= uploadFileName.replace(".docx", "");
		
		assertTrue(type(selenium,txtTemplateEditName,uploadFileName),"Could not type template name", selenium, ClassName, MethodName);
		
		
		assertTrue(click(selenium,btnSave),"Could click save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	 
	/**
	* function to verify Store Values for day sheet template
	* @param 	selenium 
	* @param 	daySheetTemplateTestData
	* @param 	userAccount
	* @since  	oct 22, 2013
	*/	
	public boolean verifyStoreValuesDaySheetTemplate(Selenium selenium,TemplateSetupLib daySheetTemplateTestData, String userAccount){
		String lastUpdated = null;
		String providerName = null;
		String providerNameTemp = null;
		String date =null;
		
		//get the provider name from top menu
		providerNameTemp= getText(selenium, lnkTopMenu);
		
		if(selenium.isTextPresent(daySheetTemplateTestData.switchRole)){
			providerName = providerNameTemp.replaceAll(", "+daySheetTemplateTestData.switchRole, "");
			lastUpdated ="Last updated by " + providerName;
		}
		else{
			Assert.fail("Not able to get the provider name");
		}
		
		//get the date format for the current account
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat;
		if(userAccount.equalsIgnoreCase(CAAccount)){
			DateFormat=new SimpleDateFormat("MMM d, YYYY");
		}
		else{
			DateFormat=new SimpleDateFormat("MM/dd/YYYY");
		}
		date=DateFormat.format(cal.getTime());
		
		
		//Replace File Extention
		uploadFileName= uploadFileName.replace(".docx", "");
		
		if(!getText(selenium,lblSummaryDaySheetTemplate).toLowerCase(new java.util.Locale("en","US")).trim().contains(uploadFileName.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;                       
		}
		if(!getText(selenium,lblSummaryDaySheetTemplate).toLowerCase(new java.util.Locale("en","US")).trim().contains(lastUpdated.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		if(!getText(selenium,lblSummaryDaySheetTemplate).toLowerCase(new java.util.Locale("en","US")).trim().contains(date.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		return true;
	}
	
	/**
	* function to verify print report using day sheet template
	* @param 	selenium
	* @throws IOException 
	* @throws AWTException 
	* @throws InterruptedException 
	* @since	Oct 25,2013
	*/	
	public boolean verifyPrintReportUsingDaySheetTemplate(Selenium selenium, TemplateSetupLib daySheetTemplateTestData, String account) throws IOException, AWTException, InterruptedException{
		assertTrue(selectValueFromAjaxList(selenium, ajxSelectDaySheetTemplate, uploadFileName), "Could not select Day sheet template", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,rdoPrintReportToday),"Could not check print report for today", selenium, ClassName, MethodName);
		
		assertTrue(click(selenium,rdoPrintReportFullDay),"Could not check print report for full day", selenium, ClassName, MethodName);
		
		if(!isChecked(selenium, chkFirstResource)){
			assertTrue(click(selenium,chkFirstResource),"Could not check the first resource", selenium, ClassName, MethodName);
		}
		String resourceName=getText(selenium, lblFirstResourceName);
		String resourceType=getText(selenium, lblFirstResourceType);
		
		if(!getText(selenium,lblAddedResource).toLowerCase(new java.util.Locale("en","US")).trim().contains(resourceName.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		if(!getText(selenium,lblAddedResource).toLowerCase(new java.util.Locale("en","US")).trim().contains(resourceType.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		
		assertTrue(click(selenium,btnPrint),"Could not click the print button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		Robot robot = new Robot();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ESCAPE); 
		
		if(!isElementPresent(selenium, lnkClosePreview)){
			 return false;
		}
		return true;
		
	}
	
	/**
	* function to verify search resource in print calendar report
	* @param 	selenium
	* @throws 	IOException 
	* @since	Oct 28,2013
	*/	
	public boolean verifySearchResourceInPrintCalendarReport(Selenium selenium, TemplateSetupLib daySheetTemplateTestData, String account) throws IOException, AWTException, InterruptedException{
		String resourceNameFirst=getText(selenium, lblFirstResourceName);
		String resourceTypeFirst=getText(selenium, lblFirstResourceType);
		
		String resourceNameSecond=getText(selenium, lblSecondResourceName);
		String resourceTypeSecond=getText(selenium, lblSecondResourceType);

		//verify search in the resource name
		selenium.type(txtSearchDaySheetTemplate,resourceNameFirst);
		selenium.fireEvent(txtSearchDaySheetTemplate,"keydown");
		selenium.fireEvent(txtSearchDaySheetTemplate,"keypress");                           
		selenium.fireEvent(txtSearchDaySheetTemplate,"keyup");
		
		assertTrue(click(selenium,lnkSearch),"Could not click the search button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		//verify the existence of first resource name in search result 
		if(!getText(selenium,lblSearchResourceSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(resourceNameFirst.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		if(!getText(selenium,lblSearchResourceSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(resourceTypeFirst.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		
		//verify the non-existence of second resource name in search result.. Because, we searched based on first resource name
		if(getText(selenium,lblSearchResourceSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(resourceNameSecond.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		
		//verify close link in the search box
		assertTrue(click(selenium,lnkSearchClose),"Could not click the close in search box", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//verify the existence of first and second resource name in search result 
		if(!getText(selenium,lblSearchResourceSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(resourceNameFirst.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		if(!getText(selenium,lblSearchResourceSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(resourceTypeFirst.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		
		if(!getText(selenium,lblSearchResourceSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(resourceNameSecond.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		if(!getText(selenium,lblSearchResourceSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(resourceTypeSecond.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		
		return true;
		
	}
	
	/**
	* function to verify delete added resource in print calendar report
	* @param 	selenium
	* @throws 	IOException 
	* @since	Oct 28,2013
	*/	
	public boolean verifyDeleteAddedResourceInPrintCalendarReport(Selenium selenium, TemplateSetupLib daySheetTemplateTestData, String account) throws IOException, AWTException, InterruptedException{
		
		if(!getText(selenium,lblNoAddedResource).toLowerCase(new java.util.Locale("en","US")).trim().contains("No resource has been added".trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		if(!isChecked(selenium, chkFirstResource)){
			assertTrue(click(selenium,chkFirstResource),"Could not check the first resource", selenium, ClassName, MethodName);
		}
		String resourceName=getText(selenium, lblFirstResourceName);
		String resourceType=getText(selenium, lblFirstResourceType);
		
		//verify the selected resource in under "added resource" 
		if(!getText(selenium,lblAddedResource).toLowerCase(new java.util.Locale("en","US")).trim().contains(resourceName.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		if(!getText(selenium,lblAddedResource).toLowerCase(new java.util.Locale("en","US")).trim().contains(resourceType.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		if(getText(selenium,lblNoAddedResource).toLowerCase(new java.util.Locale("en","US")).trim().contains("No resource has been added".trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		
		//delete the added resource
		assertTrue(click(selenium, lnkDelete), "Could not click the delete button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//verify the deleted resource is not available under "added resource" 
		if(getText(selenium,lblAddedResource).toLowerCase(new java.util.Locale("en","US")).trim().contains(resourceName.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		if(getText(selenium,lblAddedResource).toLowerCase(new java.util.Locale("en","US")).trim().contains(resourceType.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		if(!getText(selenium,lblNoAddedResource).toLowerCase(new java.util.Locale("en","US")).trim().contains("No resource has been added".trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
				
		return true;
		
	}
	
	/**
	* function to verify select all in print calendar report
	* @param 	selenium
	* @throws 	IOException 
	* @since	Oct 28,2013
	*/	
	public boolean verifySelectAllInPrintCalendarReport(Selenium selenium, TemplateSetupLib daySheetTemplateTestData, String account) throws IOException, AWTException, InterruptedException{
		
		//declare the string array to hold resource name and type
		String listOfResourceNames[]=new String[15];
		String listOfResourceTypes[]=new String[15];
		
		//get the total number of resources available
		int resourceCount=(Integer) selenium.getXpathCount("//div[@class='display-table searchResourcesPanel']/div");
		
		//verify and check the "select all" check box
		if(!isChecked(selenium, chkSelectAllResource)){
			assertTrue(click(selenium,chkSelectAllResource),"Could not check select all resource", selenium, ClassName, MethodName);
		}
		
		//After "select all", Verify all the resource names are checked
		//If resource name checked get the name and type of the resource
		//If resource name not checked else part will be execute( case will be gets failed)
		for(int count=1; count<=resourceCount; count++){
			if(isChecked(selenium, "//div[@class='display-table searchResourcesPanel']/div["+count+"]/span/input")){
				listOfResourceNames[count]=getText(selenium, "//div[@class='display-table searchResourcesPanel']/div["+count+"]/div");
				listOfResourceTypes[count]=getText(selenium, "//div[@class='display-table searchResourcesPanel']/div["+count+"]/div[2]");
			}
			else{
				Assert.fail("The following resource names is not checked :: "+ getText(selenium, "//div[@class='display-table searchResourcesPanel']/div["+count+"]/div"));
			}
		}
		
		//Verify all the resource names and types available in the added resource side
		for(int count=1; count<=resourceCount; count++){
			
			if(!getText(selenium,"//div[@class='display-table addedResourcesPanel']/div["+count+"]/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(listOfResourceNames[count].trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;
			}
			if(!getText(selenium,"//div[@class='display-table addedResourcesPanel']/div["+count+"]/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(listOfResourceTypes[count].trim().toLowerCase(new java.util.Locale("en","US")))){
				 return false;
			}
		}
		
		
		//Uncheck the "selectall" check box
		if(isChecked(selenium, chkSelectAllResource)){
			assertTrue(click(selenium,chkSelectAllResource),"Could not un-check select all resource", selenium, ClassName, MethodName);
		}
		
		//After uncheck "select all", Verify none of the resource name should checked
		for(int count=1; count<=resourceCount; count++){
			if(isChecked(selenium, "//div[@class='display-table searchResourcesPanel']/div["+count+"]/span/input")){
				Assert.fail("The following resource names is checked after un select all:: "+ getText(selenium, "//div[@class='display-table searchResourcesPanel']/div["+count+"]/div"));
			}
		}
		
		//After uncheck, the resource names in the added resource also gone.. So, verify the "No resource has been added" message" 
		if(!getText(selenium,lblNoAddedResource).toLowerCase(new java.util.Locale("en","US")).trim().contains("No resource has been added".trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		
		return true;
		
	}
	
	
	/**
	* function to verify print report based on date and time
	* @param 	selenium
	* @throws IOException 
	* @since	Oct 28,2013
	*/	
	public boolean verifyPrintReportBasedOnDateAndTime(Selenium selenium, TemplateSetupLib daySheetTemplateTestData, String account) throws IOException, AWTException, InterruptedException{
		String date =null;

		// get the date format for the current account type
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat;
		if(account.equalsIgnoreCase(CAAccount)){
			DateFormat=new SimpleDateFormat("MMM dd, YYYY");
		}
		else{
			DateFormat=new SimpleDateFormat("MM/dd/YYYY");
		}
		date = DateFormat.format(cal.getTime());
		
		
		assertTrue(selectValueFromAjaxList(selenium, ajxSelectDaySheetTemplate, uploadFileName), "Could not select Day sheet template", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//click the relevant radio button based on read data from excel
		assertTrue(click(selenium,daySheetTemplateTestData.timeAndDateID),"Could not check print report based on date and time", selenium, ClassName, MethodName);
		
		//enter time/ date for the needed test cases
		if(daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_TS_010")){
		
			assertTrue(enterDate(selenium,txtPrintReportSpecificDate, date),"Could not enter the date in 'print report based on specific date' field", selenium, ClassName, MethodName);
		
		}else if(daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_TS_011")){
			
			assertTrue(enterDate(selenium,txtPrintReportDateRangeFrom, date),"Could not enter the date in 'print report based on date range from' field", selenium, ClassName, MethodName);
			assertTrue(enterDate(selenium,txtPrintReportDateRangeTo, date),"Could not enter the date in 'print report based on date range to' field", selenium, ClassName, MethodName);
		
		}else if(daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_TS_015")){
			
			int hour = cal.get(Calendar.HOUR);
			int minutes= cal.get(Calendar.MINUTE);
			
			//for getting the minutes divisable by '5'... because, minutes allowed only 5 series
			//maximum minutes '55'
			if(minutes<54){
				minutes= minutes+ (5-(minutes%5));
			}
			else{
				minutes=55;
			}
			
			String timeFormat =null;
			
			if(cal.get(Calendar.AM_PM)==0){
				timeFormat = "am";
			}else{
				timeFormat = "pm";
			}
			
			assertTrue(type(selenium,txtPrintReportFromTimeHour, String.valueOf(hour)),"Could not enter the hour in 'print report based on time range from hour' field", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPrintReportFromTimeMins, String.valueOf(minutes)),"Could not enter the minute in 'print report based on time range from minute' field", selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, ajxFromTimeFormat, timeFormat), "Could not select the date format for from time range", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtPrintReportToTimeHour, String.valueOf(hour)),"Could not enter the hour in 'print report based on time range to hour' field", selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtPrintReportToTimeMins, String.valueOf(minutes)),"Could not enter the minute in 'print report based on time range to minute' field", selenium, ClassName, MethodName);
			assertTrue(selectValueFromAjaxList(selenium, ajxToTimeFormat, timeFormat), "Could not select the date format for to time range", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		
		if(!isChecked(selenium, chkFirstResource)){
			assertTrue(click(selenium,chkFirstResource),"Could not check the first resource", selenium, ClassName, MethodName);
		}
		String resourceName=getText(selenium, lblFirstResourceName);
		String resourceType=getText(selenium, lblFirstResourceType);
		
		if(!getText(selenium,lblAddedResource).toLowerCase(new java.util.Locale("en","US")).trim().contains(resourceName.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		if(!getText(selenium,lblAddedResource).toLowerCase(new java.util.Locale("en","US")).trim().contains(resourceType.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		
		assertTrue(click(selenium,btnPrint),"Could not click the print button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		Robot robot = new Robot();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ESCAPE); 
		
		if(!isElementPresent(selenium, lnkClosePreview)){
			 return false;
		}
		return true;
		
	}
	
	/**
	* function to verify 'reset' in print calendar report
	* @param 	selenium
	* @throws   IOException 
	* @since	Oct 28,2013
	*/	
	public boolean verifyResetInPrintCalendarReport(Selenium selenium, TemplateSetupLib daySheetTemplateTestData, String account) throws IOException, AWTException, InterruptedException{
		String date =null;

		// get the date format for the current account type
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat;
		if(account.equalsIgnoreCase(CAAccount)){
			DateFormat=new SimpleDateFormat("MMM dd, YYYY");
		}
		else{
			DateFormat=new SimpleDateFormat("MM/dd/YYYY");
		}
		date = DateFormat.format(cal.getTime());
		
		assertTrue(click(selenium,rdoPrintReportSpecificDate),"Could not check print report for specific date", selenium, ClassName, MethodName);
		assertTrue(enterDate(selenium,txtPrintReportSpecificDate, date),"Could not enter the date in 'print report based on specific date' field", selenium, ClassName, MethodName);
		
		assertTrue(click(selenium,rdoPrintReportMorning),"Could not check print report for morning", selenium, ClassName, MethodName);
		
		if(!isChecked(selenium, chkFirstResource)){
			assertTrue(click(selenium,chkFirstResource),"Could not check the first resource", selenium, ClassName, MethodName);
		}
		String resourceName=getText(selenium, lblFirstResourceName);
		String resourceType=getText(selenium, lblFirstResourceType);
		
		if(!getText(selenium,lblAddedResource).toLowerCase(new java.util.Locale("en","US")).trim().contains(resourceName.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		if(!getText(selenium,lblAddedResource).toLowerCase(new java.util.Locale("en","US")).trim().contains(resourceType.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;
		}
		
		return true;
		
	}
	
	
	/**
	* function to add new day sheet template for unit test
	* @param 	selenium
	* @throws IOException 
	* @since	Oct 28,2013
	*/	
	public boolean addNewDaySheetTemplateUnitTest(Selenium selenium, TemplateSetupUnitLib daySheetTemplateTestData, String account) throws IOException{
		
		assertTrue(click(selenium, btnAddDaySheetTemplate), "Could not click on add new Day sheet template", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		if((daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UTS_003")) || (daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UTS_004"))){
			File dir = new File(".");
			String strBasePath = null;
			String uploadFileFullPath = null;
			String sectionName = "templateSetup";
			strBasePath = dir.getCanonicalPath();
	
	
			if(daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UTS_003")){
				uploadFileName = "InvalidFormat.txt";
			}else if(daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UTS_004")){
				uploadFileName = "InvalidTemplate.docx";
			}
	
			uploadFileFullPath = strBasePath + File.separator
					+ "src" + File.separator + "main" + File.separator
					+ "resources" + File.separator + "nexia" + File.separator
					+ "testdata" + File.separator + sectionName + File.separator
					+ uploadFileName;
	
			
			assertTrue(type(selenium,txtFileUpload, uploadFileFullPath),"Could not upload the file", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium, btnErrorClose)){
				return false;
			}
		}
		
		else{
			
			assertTrue(type(selenium,txtTemplateName, daySheetTemplateTestData.templateName),"Could not enter the template name", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSave),"Could click save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		return true;
	}

	
	/**
	* function to verify print report unit test
	* @param 	selenium
	* @throws   IOException 
	* @throws   AWTException 
	* @throws   InterruptedException 
	* @since	Oct 29,2013
	*/	
	public boolean verifyPrintReportUnitTest(Selenium selenium, TemplateSetupUnitLib daySheetTemplateTestData, String account) throws IOException, AWTException, InterruptedException{
		
		String date =null;

		// get the date format for the current account type
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat;
		if(account.equalsIgnoreCase(CAAccount)){
			DateFormat=new SimpleDateFormat("dd/MM/YYYY");
		}
		else{
			DateFormat=new SimpleDateFormat("MM/dd/YYYY");
		}
		date = DateFormat.format(cal.getTime());
		

		assertTrue(click(selenium,daySheetTemplateTestData.timeAndDateID),"Could not check print report for date and time", selenium, ClassName, MethodName);
		
		
		// enter the date, time in the needed place for needed cases
		
		if((daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_004")||daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_005"))){
			
			assertTrue(enterDate(selenium,txtPrintReportSpecificDate, daySheetTemplateTestData.inputData),"Could not enter the date in 'print report based on specific date' field", selenium, ClassName, MethodName);
		
		}
		else if((daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_006")||daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_007"))){
			
			assertTrue(enterDate(selenium,txtPrintReportDateRangeFrom, daySheetTemplateTestData.inputData),"Could not enter the date in 'print report based on date range From' field", selenium, ClassName, MethodName);
		
		}
		else if((daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_008")||daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_009"))){
			
			assertTrue(enterDate(selenium,txtPrintReportDateRangeFrom, date),"Could not enter the date in 'print report based on date range From' field", selenium, ClassName, MethodName);
			
			assertTrue(enterDate(selenium,txtPrintReportDateRangeTo, daySheetTemplateTestData.inputData),"Could not enter the date in 'print report based on date range To' field", selenium, ClassName, MethodName);
		
			assertTrue(click(selenium, txtSearchDaySheetTemplate), "Could not click search resource text field", selenium, ClassName, MethodName);
			
		}
		else if((daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_010")|| daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_012")||daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_013"))){
			
			assertTrue(type(selenium, txtPrintReportFromTimeHour, daySheetTemplateTestData.inputData), "Could not type hour in 'print report based on time range From' field", selenium, ClassName, MethodName);
		
		}
		else if((daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_014")|| daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_016")||daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_017"))){
		
			assertTrue(type(selenium, txtPrintReportFromTimeMins, daySheetTemplateTestData.inputData), "Could not type min in 'print report based on time range From' field", selenium, ClassName, MethodName);
		
		}
		else if((daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_018")|| daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_020")||daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_021"))){
		
			assertTrue(type(selenium, txtPrintReportToTimeHour, daySheetTemplateTestData.inputData), "Could not type hour in 'print report based on time range To' field", selenium, ClassName, MethodName);
	
		}
		else if((daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_022")|| daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_024")||daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_025"))){
		
			assertTrue(type(selenium, txtPrintReportToTimeMins, daySheetTemplateTestData.inputData), "Could not type min in 'print report based on time range To' field", selenium, ClassName, MethodName);
	
		}
		
		else if((daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_011") || daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_015")
				|| daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_019") || daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_023"))){
			assertTrue(type(selenium, daySheetTemplateTestData.maximumFieldId, daySheetTemplateTestData.inputData), "Could not type min in 'print report based on time range To' field", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium, txtSearchDaySheetTemplate), "Could not click search resource text field", selenium, ClassName, MethodName);
			
		}
		
		else if(daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_026")){
			
			String tempDate= date;
			cal.add(Calendar.DATE, 1);  // number of days to add
			date = DateFormat.format(cal.getTime());
			
			assertTrue(enterDate(selenium,txtPrintReportDateRangeFrom, date),"Could not enter the date in 'print report based on date range from' field", selenium, ClassName, MethodName);
			
			assertTrue(enterDate(selenium,txtPrintReportDateRangeTo, tempDate),"Could not enter the date in 'print report based on date range to' field", selenium, ClassName, MethodName);
		
			assertTrue(click(selenium, txtSearchDaySheetTemplate), "Could not click search resource text field", selenium, ClassName, MethodName);
		}
		else if(daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_027")){
			int hour = cal.get(Calendar.HOUR);
			//int minutes= cal.get(Calendar.MINUTE);
			
			if(hour==12){
				cal.add(Calendar.HOUR, -1);  // number of hour to subtract
				hour = cal.get(Calendar.HOUR);
			}
			assertTrue(type(selenium,txtPrintReportToTimeHour, String.valueOf(hour)),"Could not type the time in 'print report based on time range' field", selenium, ClassName, MethodName);
			
		
			cal.add(Calendar.HOUR, 1);  // number of hour to add
			hour = cal.get(Calendar.HOUR);
			
			assertTrue(type(selenium,txtPrintReportFromTimeHour, String.valueOf(hour)),"Could not type the time in 'print report based on time range' field", selenium, ClassName, MethodName);
			
		}
		
		
		
		//this if block is used for append one extra character in the text field, To verify maximum length
		if((daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_013") || daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_017")
				|| daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_021") || daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_025"))){
			selenium.typeKeys(daySheetTemplateTestData.maximumFieldId, "a");
			
		}
		
		
		// the following if block to restrict some of the cases do not click ,print, button
		if(!(daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_019") || daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_011")
				|| daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_015") || daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_019")
				|| daySheetTemplateTestData.testCaseId.equalsIgnoreCase("TC_UCR_023") )){
			assertTrue(click(selenium,btnPrint),"Could not click the print button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		return true;
		
	}
	
	
	public boolean patientSearch (Selenium selenium) throws IOException{
		assertTrue(type(selenium,txtPatientSearch,"MATHEWAAAA"),"Could not search the patient",selenium, ClassName, MethodName);
		
		
		selenium.keyPress(txtPatientSearch, "\\9");
		waitForPageLoad(selenium);
		
		if(isElementPresent(selenium, "css=div.patientItem > div.patientInfoWidget")){
			click(selenium, "css=div.patientItem > div.patientInfoWidget");
		}else{
			Assert.fail("Add new patient is not available");
		}
		return true;
	}
	
	
	public static String generateRandomString(Random rng, String characters, int length)
	{
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    return new String(text);
	}
	
	/**
	 * Create a New Correspondence Report					
	 * 
	 * @since June 23, 2014
	 */
	public boolean createCorrespondenceReport(Selenium selenium,ChartPreVisitLib medicationData,String userAccount) throws IOException
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
			waitForPageLoad(selenium);

		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail(e.getMessage());
		}
		return true;
		
	}

	
}



