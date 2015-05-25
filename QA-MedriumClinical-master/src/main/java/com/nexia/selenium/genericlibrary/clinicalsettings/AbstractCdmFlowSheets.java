package com.nexia.selenium.genericlibrary.clinicalsettings;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.sharedlibrary.AbstractTest;
import com.thoughtworks.selenium.Selenium;

public class AbstractCdmFlowSheets extends AbstractTest {
	public String careMouseOver="//a[contains(@id,'subCategory')]";
	public String careTargerValue="targetValue";
	public String careDueValue="dueValue";
	public String overDue="css=span.overdue-element";
	public Calendar cal;
	public SimpleDateFormat dateFormat;
	public String uniqueName;
	public String careEleAttribute="";
	public String date="";
	public String dateAddNewManagedCare="//table[@id='flowsheetGrid']/tbody/tr/td[3]";
	public String lnkLocationMenuHeader = "locationMenuHeader";
	public String EditFlowSheetMedSuggest="id=medicationSuggestBoxsuggestBox";
	public String EditFlowSheetMedSuggestClass="id=medicationClassSuggestBoxsuggestBox";
	public String userName="id=username";
	public String lnkCloseTemplate="id=closeButton";
	public String btnSaveAllergy="id=saveAllergyButton";
	public String lnkQuickLink ="link=Quick Actions";
	public String btnSectionSave="topSave";
	public String lnkNewPatientReg="id=newPatientAction";
	public String lnkClinicalSettingsLink = "clinicalSettingsAction";
	public String lnkPracticeLibrary="!encounterTemplates";
	public String lnkstartBlankTemplate="startBlankTemplate";
	public String lnkApplyExistingTemplate="applyExistingTemplate";
	public String lnkEditMedications="link=Edit";
	public String lnkEditAllergy="xpath=(//a[contains(text(),'Edit')])[2]";
	public String lnkEditFlowSheets="xpath=(//a[contains(text(),'Edit')])[4]";
	public String lnkSave="link=Save";
	public String btncancelManage ="cancel";
	public String btnOk ="okButton";
	public String txtWidgetRow2="xpath=(//div[contains(@id,'widget')])[2]";
	public String lnkClosePreview="singleSelectionWidgetCloseButton";
	public String medicationPreview="id=1readOnly";
	public String lnkCancelMedication="link=Cancel";
	public String lnkHome="id=logoAnchor";
	public String lnkPatientOptions="link=Patient Options";
	public String btnBack="id=back";
	public String buttonBack="backButton";
	public String btnRight ="rightArrow";
	public String btnLeft ="leftArrow";
	public String btnYesButton="yesButton";
	public String TemplateMedEdit="id=Medications_edit";
	public String TemplateAllergyEdit="id=Allergies_edit";
	public String TemplateFlowSheetEdit="id=Flowsheet_edit";
	public String ajxValue="currentItem_2";
	public String txtTempName="id=templateName";
	public String txtTempDes="templateDescription";
	public String patientChart="css=#patientOptionsChartView > span";
	//Image Fields 
	public String txtCategoryName ="category";
			public String btnSaveCategoryName ="//button[@id='save']";
					public String btnCancelCategoryName ="//button[@id='cancel']";

	public String lnkTemp="startBlankTemplate";
	public String lnkExitTemp="applyExistingTemplate";
	public String lnkPatientInfo ="!patientInfoView";
		//public String btnSave="id=saveButton";

	/**
	 * navigatePatientChartToTemplate 
	 * Function to navigate from patient chart to Managed Care
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 17,2014
	 */
	
	public boolean navigatePatientChartToTemplate(Selenium selenium)throws IOException
	{
		assertTrue(click(selenium, lnkMore), "Could not click on more link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkFlowSheets), "Could not click on flow sheets link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}
		
		public String TemplateAllMed="id=allRadioButton";
		public String TemplateSpecMed="id=specifyRadioButton";
		public String TemplateMedSuggest="id=medicationSuggestBox_1";
		public String TemplateMedSuggestClass="id=medicationClassSuggestBox_1";	
		public String TemplateMedSave="link=Save";
		public String TemplateCancel="id=cancelButon";
		public String TemplateCancelYes="id=yesButton";
	public String lnkPatientChart="//a/span";
	public String lnkFreeTextLabelwid="addButton-Free text";
	public String lnkAllergy="id=AllergiesTitle";
	public String txtFreeTextLable="titleText";
	public String lnkAllergyTempEdit="link=View/Edit";
	public String lnkForCheckAllergy="scrollPanel";
	public String linkAllergyExpandAnchor ="//a[contains(@id,'allergyExpandAnchor')]";
	public String lnkMedicationExpandAnchor ="//a[contains(@id,'medicationExpandAnchor')]";
	public String lnkMedicationTitle ="MedicationTitle";
	public String btnCreateCustom ="createCustomTmplbtn";
	public String btnDelete="deletetBtn";
	public String btncancel ="cancelButton";
	public String btnUseThis="link=Use this";
	public String lnkSearchedItem="templateFocusPanel";
	public String lblFirstResult="templateFocusPanel";
	public String btnEdit="id=editBtn";
	public String allergyEdtBtn="id=Allergies_edit";
	public String ajxsortCriteria ="sortCriteriasuggestBox";
	public String ajxMedicationName1="id=medicationSuggestBox_1";
	public String ajxMedicationDrugName1="id=medicationClassSuggestBox_1";
	public String ajxMedicationName2="medicationSuggestBox_2";
	public String ajxMedicationDrugName2="medicationClassSuggestBox_2";
	public String txtDisplayAs="id=displayAsTextBox";
	public String txtDue="id=dueEveryTextBox";
	public String txtUpcoming="id=upcomingTextBox";
	public String ajxImmunizationSearch="id=immunizationSuggestBox";
	public String ajxSearchImmunization = "//div[@id='searchPanel']/input";
	public String chkImmunization1="//input[contains(@id,'elementCheckBox')]";
	public String DeleteCareElement = "//a[contains(@id,'remove_CareElment')]";
	public String btnActivates = "id=activateBtn";
	public String DeleteCategory = "//a[contains(@id,'remove_CareCategory')]";
public String btnSaveCare ="save";
	public String btnSaveAnother ="saveAnother";
	public String btnClose = "closeAnchor";
	public String btnOption ="//a[@id='actions']";
	public String btnGraph ="graphSelectedButton";
	public String btnPrint ="printSendButton";
	public String btnRecordData ="recordDataButton";
	public String btnClosePrint ="framePopupViewCloseButton";
	public String btnCloseGraph ="//button[@id='closeButton']";
	public String btnTemplateSave="id=saveButton";
	public String btnSave="xpath=(//button[@type='button'])[1]";
	public String btnCancel="xpath=(//button[@type='button'])[2]";
	public String btnSaveVitals="//button[@id='save']";
	public String btnYes="yesButton";
	public String btnNo="noButton";
	public String btnActivate="css=button.secondary-button";
	public String btnAddNewMedication="xpath=(//button[@type='button'])[4]";
	public String btnDeleteMedication="xpath=(//button[@type='button'])[5]";
	public String btnPreview="css=button.secondary-button.verticalAlignMiddle";
	public String btnViewEdit ="//a[contains(@id,'viewButton')]";
	public String btnSaveWhole = "saveButton";
	public String btnBaseLine ="baselineButton";
	public String btnSign ="sign";
    public String txtAreaTemplateDescription="templateDescription";
	public String btnAddCustom ="createCustomTmplbtn";
	public String rdoSingleAnswer ="singleAnswerradio";
	public String rdoMultipleAnswer ="multipleAnswerradio";
	public String txtHeightUpperLimt="minTextBox";
	public String txtHeightLowerLimt="maxTextBox";
	public String txteHeightUpperLimt="minSystoli";
	public String txteHeightLowerLimt="maxSystoli";
	public String txteConditionAge="yearsAgeMin";
	public String ajxNameMedication = "suggestBox";
	public String txtBaseLineDate = "baselineDate";

	public String ajxTemplateType="templateSuggestBoxsuggestBox";
	public String ajxTemplateSearch="css=input.search-box.width150";
	public String ajxaAlergyName1="foodTypesuggestBox" ;
	public String ajxAlergySugg= "allergyTypesuggestBox";

	
	public String txtTemplateName="css=input.gwt-TextBox";
	public String txtTemplateDescription="css=textarea.text-area";
	public String txtSearch="xpath=(//input[@type='text'])[4]";
	public String txtDate="xpath=(//input[@type='text'])[6]";
	public String txtPatientFirstName="id=firstName";
	public String txtPatientLastName="id=lastName";
	public String txtDateValue="id=baselineDate";
	
	public String chkMedication="//tr[1]/td/div/div/div/div/div/div/span/input";
	public String chkAllergy="//tr[2]/td/div/div/div/div/div/div/span/input";
	public String chkRiskFactors="//tr[3]/td/div/div/div/div/div/div/span/input";
	public String chkFlowSheets="//tr[4]/td/div/div/div/div/div/div/span/input";
	public String chkIncludeInactive="//span/input";
	public String lnkProblemListTitle = "ProblemListTitle";
	public String lnkFlowSheet ="flowsheetLink";
	public String lnkSummary = "!chartSummary";
	public String lnkVitals = "link=VITALS";
	public String lnkImmunization = "ImmunizationsTitle";
	public String txtNewEncounterDate = "dateField";
	public String rdoAll="//span/input";
	public String rdoSelected="specifyRadioButton";
	public String rdoSelect="//div[2]/span/input";
	
	
	public String lblCareElement ="//td[2]/a";
	public String btnEdit1 ="//table[@id='flowsheetEditTable']/tbody/tr[3]/td[5]/a";
	//public String btnAdd1 ="//table[@id='flowsheetEditTable']/tbody/tr/td[6]/button";
	public String popUpContent = "xpath=(//div[@id='scrollPanel'])[2]";
	public String lblValue ="//td[3]/div/div/div/span";
	public String chkTrackCondition ="trackThisChkBox";
	public String btnSaveWidget="save";
	public String btnAdd1 ="//button[contains(@id,'flowsheetWidget')]";
	public String ajxLab ="//div[@id='searchPanel']/input";
	public String chkSelection = "//input[contains(@id,'flowSheetItemCheckbox')]";
	
	//FIXME VEL-4925
	public String chkWidget = "//div[100]/div/div/div/div[3]/div/span/input";
	public String chkWidget2 ="//span[2]/input";
	public String lblCareElementName ="//table[@id='flowsheetGrid']/tbody/tr[3]/td[2]";
	public String lblCareElementValue ="//table[@id='flowsheetGrid']/tbody/tr[3]/td[3]";
	public String lblEncounterValue ="//table[@id='flowsheetGrid']/tbody/tr[3]/td[4]";
	public String lblEncounterDate ="//table[@id='flowsheetGrid']/tbody/tr/td[4]";
	public String lblBaseLine ="//table[@id='flowsheetGrid']/tbody/tr/td[3]";
	public String lblEncounterValueCollapse ="//td[4]/div/div/div[2]";
	public String lblCareElementValueollapse ="//td[3]/div/div/div[2]";
	
	
	
	public String chkChecked ="checked";
	public String chkUnchecked ="unChecked";
	public String lblAllergy1 ="intolerenceAllergy";
        public String lblAllergy2 ="xpath=(//span[@id='intolerenceAllergy'])[2]";

	public String chkAllergy1 ="//span[@id='checkBox']/input";
	public String chkAllergy2 ="xpath=(//span[@id='checkBox']/input)[2]";
	
	
	public String lblTemplate1="//div[contains(@id,'listPanel')]/div[1]";
	public String lblTemplate2="//div[contains(@id,'listPanel')]/div[2]";
	public String lblTemplate3="//div[contains(@id,'listPanel')]/div[3]";
	public String lblCategory ="//div[contains(@id,'Category')]";
	
	//Care Elements
	public String btnViewFullWidth = "viewFullWidthDiv";
	public String btnAddCategory="css=button.secondary-button";
	public String btnSaveCategory="css=div.popup-buttons > button.secondary-button";
	public String btnAddCareElement="css=button.secondary-button.left-button-spacer";
	public String btnAddNew="addNewButton";
	public String btnRemove="//a[contains(@id,'deleteButton')]";
	public String btnCancelProblemList="cancelProblemList";
	public String btnAdd ="add";
	public String btnEditSaveProblemList ="problemEditSaveButton";
	public String btnSaveProblemList = "saveProblemList";
	public String btnEditProblemList ="//a[contains(text(),'Edit')]";
	public String txtCategory="css=input.text-box";
	public String txtSearchCareElement = "searchTextBox";
	public String lblSearchList= "searchList";
	public String lblTemplateDetails ="xpath=(//div[@id='templateFocusPanel'])";
	//FIX ME:Ticket In Review
	public String ChartCareMed="xpath=(//a[contains(text(),'Medication')])[3]";
	//public String ChartTempMed="xpath=(//span[@id='detailPanel']/span)[5]";
	public String ChartTempMed="scrollPanel";	//chartListItemFullWidthWrapper
	public String btnSaveMedication="id=saveMedications";
	public String lnkRemove="link=Remove";
	public String lnkClickToSelect="link=Click to select";
	public String lnkDelete="link=Delete";
	public String lnkClose="css=a.close-x";
	public String lnkClickToAdd="link=Click to add";
	public String lnkMore="link=More";
	public String lnkFlowSheets="!flowsheetMore";
	public String lnkViewEdit="link=View/Edit";
	public String lnkFullView="css=div.view-full-width-button";
	public String lnkToManagedCare="//a[@id='!flowsheetMore']/span";
	public String LinkViewChart="link=View Chart";
	public String chkVaricella = "id=elementCheckBox_Varicella";
	public String ajxCategory="categoryPanelsuggestBox";
	public String ajxCareElementPanelsuggestBox="careElementPanelsuggestBox";
	public String ajxDueType="monthsPanel1suggestBox";
	public String ajxAdvanceDue="upcomingPanel1suggestBox";
	public String ajxCarepanel="xpath=(//input[@id='categoryPanelsuggestBox'])[2]";
	public String ajxtargetType="xpath=(//input[@id='categoryPanelsuggestBox'])[3]";
	public String ajxtargetExceptionType="ageSuggestBoxsuggestBox";
	public String ajxForWho="sexSuggestBoxsuggestBox";
	public String ajxConditionType="yearsSuggestBoxsuggestBox";
	public String ajxCondtionAgeIn="xpath=(//input[@id='sexSuggestBoxsuggestBox'])[2]";
	public String ajxStatus="id=statusSuggestBoxsuggestBox";
	public String ajxTemplateName="id=suggestBox";
	public String ajxTemplate = "careSummarysuggestBox";
	public String applyExistTemplate = "css=span.apply-icon";
	public String btnAction = "actionAnchorEncounter";
	public String btnSaveEncounter ="//a[@id='saveEncounter']";
	//------------------------------------------------------------------------------------------------------------
	
	/**
	 * navigateToManagedCareTemplate 
	 * Function to go to Managed Care Template 
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Jun 25,2014
	 */
	public boolean navigateToManagedCareTemplate(Selenium selenium) throws IOException{
		if(selenium.isConfirmationPresent()){
			System.out.println(selenium.getConfirmation());
			selenium.chooseOkOnNextConfirmation();
			}
		assertTrue(click(selenium, lnkSettings), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkClinicalSettingsLink), "Could not click on Clinical settings", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkPracticeLibrary), "Could not click on practice library link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxTemplateType,"Managed Care"),"Could not select template type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!isElementPresent(selenium, btnCreateCustom)){
			return false;
		}
		return true;
	}
	
	public boolean navigateToManagedCare(Selenium selenium)throws Exception
	{
	assertTrue(click(selenium, lnkPracticeLibrary), "Could not click on practice library link", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	assertTrue(selectValueFromAjaxList(selenium,ajxTemplateType,"Managed Care"),"Could not select template type", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	return true;
	}
	
	public boolean navigateToVisitSection(Selenium selenium) throws IOException{
		assertTrue(click(selenium, lnkSettings), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkClinicalSettingsLink), "Could not click on Clinical settings", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkPracticeLibrary), "Could not click on practice library link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxTemplateType,"Visit Section"),"Could not select template type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
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
	 * navigateToManagedCareTemplate 
	 * Function to go to Managed Care Template 
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Nov 14,2014
	 */
	public boolean addVitalsInMultipleEncounters(Selenium selenium,ChartPreVisitLib mcTemplate,String uniqueName, String account,int i) throws IOException{
		AbstractChartPreVisit obj=new AbstractChartPreVisit();
		if(i!=1){
		if (account.equals(CAAccount)) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, i);
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String date = DateFormat.format(cal.getTime());
		

			assertTrue(enterDate(selenium, txtNewEncounterDate, date),
					"Could not enter the Admin on ;More Details:"
							,selenium, ClassName, MethodName);
		} else {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, i);
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			String date = DateFormat.format(cal.getTime());
			

			assertTrue(enterDate(selenium, txtNewEncounterDate, date),
					"Could not enter the Admin on ;More Details:"
							,selenium, ClassName, MethodName);
		}
		}
		assertTrue(click(selenium,lnkSummary),"Could not click the Summary tab", selenium, ClassName, MethodName);
		
		assertTrue(click(selenium,lnkVitals),"Could not click the Vitals link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		selectValueFromAjaxList(selenium, obj.ajxHeight,
				"cm");
		assertTrue(
				type(selenium, obj.txtHeight, mcTemplate.heightInCm),
				"could not type height in cm",selenium, ClassName, MethodName);
		assertTrue(click(selenium,btnAdd),"Could not click the Add", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,obj.btnDoneButton),"Could not click on Done", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(i!=1){
		assertTrue(click(selenium,btnAction),"Could not click on Action", selenium, ClassName, MethodName);
		assertTrue(click(selenium,btnSaveEncounter),"Could not click on Save encounter", selenium, ClassName, MethodName);
		}
		return true;
		
	}
	
	/**
	 * createManagedCareTemplate 
	 * Function to add Managed Care Template 
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Jun 25,2014
	 */
	public boolean createManagedCareTemplateWithMandatory(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName) throws IOException{
		if(isElementPresent(selenium,btnCreateCustom)){
		assertTrue(click(selenium, btnCreateCustom), "Could not click on create button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		else{
			if(!mcTemplate.testCaseId.equals("TC_MCT_004")){
			assertTrue(selenium.isTextPresent("Edit Managed Care Summary Template"),"Edit Managed Care Summary Template text is not present", selenium, ClassName, MethodName);
			}
		}
		
		if(isElementPresent(selenium,lnkstartBlankTemplate)){
		assertTrue(click(selenium, lnkstartBlankTemplate), "Could not click on Start Blank Template", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		assertTrue(type(selenium,txtTemplateName,mcTemplate.templateName+uniqueName),"Could not type the last name : More Details"+mcTemplate.toString(), selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtTemplateDescription,mcTemplate.templateDescription),"Could not type the last name : More Details"+mcTemplate.toString(), selenium, ClassName, MethodName);
		
		if(!isChecked(selenium,chkMedication)){
			assertTrue(click(selenium, chkMedication), "Could not click on Medicatio check box ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		if(!isChecked(selenium,chkAllergy)){
			assertTrue(click(selenium, chkAllergy), "Could not click on Allergy check box ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		if(!isChecked(selenium,chkRiskFactors)){
			assertTrue(click(selenium, chkRiskFactors), "Could not click on Risk Factors check box ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		if(!isChecked(selenium,chkFlowSheets)){
			assertTrue(click(selenium, chkFlowSheets), "Could not click on Flow sheets check box ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		assertTrue(click(selenium, btnSave), "Could not click on save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(mcTemplate.testCaseId.equals("TC_MCT_025")){
			assertTrue(selenium.isTextPresent("Duplicate template name entered."),"Warning not present", selenium, ClassName, MethodName);
			return true;
		}
		if(!isElementPresent(selenium, btnCreateCustom)){
			return false;
		}
		return true;
	}
	 /**
		 * navigateToManagedCare 
		 * Function to navigate to Managed Care
		 * @param 	selenium
		 * @throws IOException 
		 * @since	Nov 06,2014
		 */
	    public boolean navigateToManagedCare(Selenium selenium,ClinicalSettingLib mcTemplate, String account,String uniqueName) throws IOException
	    {
	    	String date="";
	    	assertTrue(click(selenium, lnkMore), "Could not click on more link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
	    	assertTrue(click(selenium,lnkToManagedCare),"Unable to navigate to Managed care template",selenium,ClassName,MethodName);
	    	waitForPageLoad(selenium);
	    	assertTrue(click(selenium,btnAddNew),"Unable to click the add new button",selenium,ClassName,MethodName);
	    	waitForPageLoad(selenium);
	    	assertTrue(selectValueFromAjaxList(selenium,ajxNameMedication,mcTemplate.templateName+uniqueName),"Unable to enter the name of the template",selenium,ClassName,MethodName);
	    	if (account.equals(CAAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				date = DateFormat.format(cal.getTime());

			} else if(account.equals(USAccount)) {
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal.getTime());

			}
	    	assertTrue(enterDate(selenium,txtBaseLineDate,date),"Unable to enter the Date",selenium,ClassName,MethodName);
	    	waitForPageLoad(selenium);
	    	assertTrue(click(selenium,btnTemplateSave),"Unable to click the save button",selenium,ClassName,MethodName);
	    	waitForPageLoad(selenium);
	    	
	        return true;	
	    }
	    
	    public boolean createVisitSectionWithSingleTextWidget(Selenium selenium,ClinicalSettingLib encounterTemplateTestData)throws Exception
	    {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy HH:SS");
		String uniqueName = DateFormat.format(cal.getTime());
		
		    	assertTrue(click(selenium, btnAddCustom),"Click on Add section failed",selenium, ClassName, MethodName);
		    	waitForPageLoad(selenium);	   
		    	assertTrue(type(selenium, txtTemplateName,encounterTemplateTestData.SectionName+uniqueName), "Could not type template name",selenium, ClassName, MethodName);
		    	assertTrue(type(selenium, txtAreaTemplateDescription, encounterTemplateTestData.SectionDescription), "Could not type template description",selenium, ClassName, MethodName);
		       	assertTrue(click(selenium, txtWidgetRow2),"Coild not click the first row in Create visit sectio page",selenium, ClassName, MethodName);
		    	assertTrue(click(selenium, lnkFreeTextLabelwid),"Coild not click the first row in Create visit sectio page",selenium, ClassName, MethodName);
		    	assertTrue(type(selenium, txtFreeTextLable,encounterTemplateTestData.FreeTextLabel),"Could not type the lable name",selenium, ClassName, MethodName);
		    	assertTrue(click(selenium, btnSaveWidget),"Click on Save button  in section failed",selenium, ClassName, MethodName);
		    	waitForPageLoad(selenium);
		    	assertTrue(isTextPresent(selenium,encounterTemplateTestData.FreeTextLabel),"Widget is not added",selenium, ClassName, MethodName);
		    	assertTrue(click(selenium, btnSectionSave),"Coild not click the first row in Create visit sectio page",selenium, ClassName, MethodName);
		    	waitForPageLoad(selenium);
	    	return true;
	    }
	
	    
	    
	/**
	 * deleteAllManagedCareTemplate 
	 * Function to delete all Managed Care Template 
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Jun 25,2014
	 */
	public boolean deleteAllManagedCareTemplate(Selenium selenium,ClinicalSettingLib mcTemplate) throws IOException{
		int count=0;
		while(isElementPresent(selenium,btnDelete)){
			assertTrue(click(selenium, btnDelete), "Could not click on delete button", selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnYes), "Could not click on delete button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(count>15){
				break;
			}
		}
		return true;
	}
	
	/**
	 * verifyCreatedManagedCareTemplate 
	 * Function to verify created Managed Care Template 
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Jun 25,2014
	 */
	public boolean verifyCreatedManagedCareTemplate(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName) throws IOException{
		assertTrue(selectValueFromAjaxList(selenium,ajxTemplateType,"Managed Care"),"Could not select template type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(searchTempateUsingTemplateName(selenium,mcTemplate,uniqueName),"Could not select template type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//assertTrue(selenium.isTextPresent("MANAGED CARE"),"managed care text is not present", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(mcTemplate.templateName+uniqueName),"Template name is not present", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(mcTemplate.templateDescription),"Template description is not present", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent("Practice template"),"Practice template text is not present", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent("Practice template"),"Practice template text is not present", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent("Medications"),"Medication text is not present", selenium, ClassName, MethodName);
		//assertTrue(selenium.isTextPresent("Display all medications"),"Medication text is not present", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent("Allergies"),"Allergies text is not present", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent("Risk Factors"),"Risk Factors text is not present", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent("Flowsheet"),"Flowsheet text is not present", selenium, ClassName, MethodName);
		
		if(mcTemplate.testCaseId.equals("TC_MCT_022")){
			assertTrue(selenium.isTextPresent(mcTemplate.display),"Flowsheet text is not present", selenium, ClassName, MethodName);
		}
		return true;
	}
	
	
	/**
	 * verifyGraphSelected 
	 * Function to verify Graph in patient chart 
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 28,2014
	 */
	public boolean verifyGraphSelected(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName) throws IOException{
	
	 assertTrue(click(selenium,btnOption),"Could not click the Option btn;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,chkSelection),"Could not click the check box;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,btnGraph),"Could not click the graph;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			assertTrue(isElementPresent(selenium,popUpContent),"Pop up not present", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,btnPrint),"Print button not present", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,btnCloseGraph),"Close up not present", selenium, ClassName, MethodName);

			assertTrue(getText(selenium,popUpContent).toLowerCase(new java.util.Locale("en","Us")).trim().contains(mcTemplate.display.trim().toLowerCase(new java.util.Locale("en","Us"))),"Care Element is present", selenium, ClassName, MethodName);

	return true;
	}
	
	/**
	 * verifyRemoveCareElementInPatientChart 
	 * Function to verify remove care element in patient chart 
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 29,2014
	 */
	public boolean verifyRemoveCareElementInPatientChart(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName) throws IOException{
	
	assertTrue(click(selenium, lnkRemove), "Could not click on remove button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnYes), "Could not click on Yes button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnSaveWhole), "Could not click on Save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!isTextPresent(selenium,mcTemplate.display),"Care Element is present", selenium, ClassName, MethodName);
 
		return true;
	}
	
	/**
	 * enterDetailsForeManagedCareTemplate 
	 * Function to enter details for managed care template
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Jul 08,2014
	 */
	public boolean enterDetailsForeManagedCareTemplate(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName) throws IOException{
		if(isElementPresent(selenium,btnCreateCustom)){
		assertTrue(click(selenium, btnCreateCustom), "Could not click on create button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		else{
			if(!mcTemplate.testCaseId.equals("TC_MCT_004")){
			assertTrue(selenium.isTextPresent("Edit Managed Care Summary Template"),"Edit Managed Care Summary Template text is not present", selenium, ClassName, MethodName);
			}
		}
		
		if(isElementPresent(selenium,lnkstartBlankTemplate)){
		assertTrue(click(selenium, lnkstartBlankTemplate), "Could not click on Start Blank Template", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		assertTrue(type(selenium,txtTemplateName,mcTemplate.templateName+uniqueName),"Could not type the last name : More Details"+mcTemplate.toString(), selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtTemplateDescription,mcTemplate.templateDescription),"Could not type the last name : More Details"+mcTemplate.toString(), selenium, ClassName, MethodName);
		
		if(!isChecked(selenium,chkMedication)){
			assertTrue(click(selenium, chkMedication), "Could not click on Medication check box ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		if(!isChecked(selenium,chkAllergy)){
			assertTrue(click(selenium, chkAllergy), "Could not click on Allergy check box ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		if(!isChecked(selenium,chkRiskFactors)){
			assertTrue(click(selenium, chkRiskFactors), "Could not click on Risk Factors check box ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		if(!isChecked(selenium,chkFlowSheets)){
			assertTrue(click(selenium, chkFlowSheets), "Could not click on Flow sheets check box ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		/*assertTrue(click(selenium, btnSave), "Could not click on save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);*/
		if(!isElementPresent(selenium, btnSave)){
			return false;
		}
		return true;
	}
	
	/**
	 * addAllergyTotemplate 
	 * Function to add allergy to template
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Jul 11,2014
	 */
	public boolean addAllergyTotemplate(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName) throws IOException{
		assertTrue(click(selenium, lnkEditAllergy), "Could not click on edit medication", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, rdoSelect), "Could not click on select radio button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxaAlergyName1,mcTemplate.drugType),"Could not select medication name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxAlergySugg,mcTemplate.allergyType),"Could not select medication name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkSave), "Could not click on save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	
	/**
	 * addMedicationTotemplate 
	 * Function to add allergy to template
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Jul 11,2014
	 */
	public boolean addMedicationTotemplate(Selenium selenium,ClinicalSettingLib mcTemplate,String userAccount) throws IOException{
		assertTrue(click(selenium, lnkEditMedications), "Could not click on edit medication", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, rdoSelect), "Could not click on select radio button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		
		if(userAccount.equals(CAAccount)){
		assertTrue(selectValueFromAjaxList(selenium,ajxMedicationName1,mcTemplate.medicationName1),"Could not select medication name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxMedicationDrugName1,mcTemplate.DrugClassName1),"Could not select drug class name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnAddNewMedication), "Could not click on Add New medication", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxMedicationName2,mcTemplate.medicationName2),"Could not select medication name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxMedicationDrugName2,mcTemplate.DrugClassName2),"Could not select drug class name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		else{
		assertTrue(selectValueFromAjaxList(selenium,ajxMedicationName1,mcTemplate.usmedicationName1),"Could not select medication name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxMedicationDrugName1,mcTemplate.usDrugClassName1),"Could not select drug class name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnAddNewMedication), "Could not click on Add New medication", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxMedicationName2,mcTemplate.usmedicationName2),"Could not select medication name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxMedicationDrugName2,mcTemplate.usDrugClassName2),"Could not select drug class name", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
	//	assertTrue(click(selenium, MedDropdown), "Could not click on drop down", selenium, ClassName, MethodName);
	//	assertTrue(click(selenium, lblItem2), "Could not click on Lable from drop down ", selenium, ClassName, MethodName);
		}
		
		//Use test case id 18, if you want to save it
		if(!mcTemplate.testCaseId.equals("TC_MCT_022") && !mcTemplate.testCaseId.equals("TC_MCT_008") && !mcTemplate.testCaseId.equals("TC_MCT_006")){
			assertTrue(click(selenium, lnkSave), "Could not click on save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}		
		return true;
	}
	
	/**
	 * navigateToVisitOutlineTemplate 
	 * Function for Navigate to visit online template from Homepage  
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 17,2014
	 */
	public boolean navigateToVisitOutlineTemplate(Selenium selenium) throws IOException{
		assertTrue(click(selenium, lnkQuickLink), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkClinicalSettingsLink), "Could not click on Clinical settings", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkPracticeLibrary), "Could not click on practice library link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxTemplateType,"Visit Outline"),"Could not select template type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!isElementPresent(selenium, btnCreateCustom)){
			return false;
		}
		return true;
	}
	
	/**
	 * addImmunizationCareElement 
	 * Function to add Immunization Care Element
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Jul 14,2014
	 */
	public boolean addImmunizationCareElement(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName,String account) throws IOException{
		assertTrue(click(selenium, lnkEditFlowSheets), "Could not click on edit flow sheets", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!mcTemplate.testCaseId.equals("TC_MCT_034")){
			assertTrue(deleteandaddCategory(selenium, mcTemplate), "Adding category failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
		assertTrue(click(selenium, btnAddCareElement), "Could not click on Add button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxCategory,mcTemplate.category),"Could not category", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxCareElementPanelsuggestBox,"Immunizations"),"Could not select Immunizations", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtDisplayAs,mcTemplate.display), "Could not type display as", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtDue,mcTemplate.due), "Could not type due", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxDueType,mcTemplate.dueType),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtUpcoming,mcTemplate.due), "Could not type due", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxAdvanceDue,mcTemplate.dueType),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkClickToSelect), "Could not click on select link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!account.equals(CAAccount)){
			assertTrue(selectValueFromAjaxList(selenium, ajxSearchImmunization,mcTemplate.immunization), "Could not type due", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}else{
			assertTrue(selectValueFromAjaxList(selenium, ajxSearchImmunization,mcTemplate.immunization), "Could not type due", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		if(!isChecked(selenium,chkImmunization1)){
			assertTrue(click(selenium, chkImmunization1), "Could not check Immunization", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		if(isElementPresent(selenium,lnkDelete)){
			assertTrue(click(selenium, lnkClose), "Could not click close", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		if(mcTemplate.testCaseId.equals("TC_MCT_045")||mcTemplate.testCaseId.equals("TC_MCT_046")){
			return true;
		}
		assertTrue(click(selenium, lnkSave), "Could not click save", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(isElementPresent(selenium, btnAddCategory), "Immunization care element addition failed", selenium, ClassName, MethodName);
		
		if(!mcTemplate.testCaseId.equals("TC_MCT_022")&&!mcTemplate.testCaseId.equals("TC_MCT_027")&&!mcTemplate.testCaseId.equals("TC_MCT_034")&&!mcTemplate.testCaseId.equals("TC_MCT_056")){
		assertTrue(click(selenium, btnSave), "Could not click save", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(isElementPresent(selenium, btnCreateCustom), "Immunization care element addition failed", selenium, ClassName, MethodName);
		}
		else{
			assertTrue(click(selenium, lnkSave), "Could not click save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		return true;
	}




	/**
	 * addLabTestCareElement 
	 * Function to add Lab Test Care Element
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 28,2014
	 */
	public boolean addLabTestCareElement(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName,String account) throws IOException{
		assertTrue(click(selenium, lnkEditFlowSheets), "Could not click on edit flow sheets", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!mcTemplate.testCaseId.equals("TC_MCT_033")){
		assertTrue(deleteandaddCategory(selenium, mcTemplate), "Adding category failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		assertTrue(click(selenium, btnAddCareElement), "Could not click on Add button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxCategory,mcTemplate.category),"Could not category", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxCareElementPanelsuggestBox,"Lab test"),"Could not select Immunizations", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtDisplayAs,mcTemplate.display), "Could not type display as", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtDue,mcTemplate.due), "Could not type due", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxDueType,mcTemplate.dueType),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtUpcoming,mcTemplate.due), "Could not type due", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxAdvanceDue,mcTemplate.dueType),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkClickToSelect), "Could not click on select link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		assertTrue(type(selenium, ajxLab,mcTemplate.immunization), "Could not type due", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		selenium.clickAt(ajxLab,"");
		//selenium.focus(ajxLab);
		selenium.keyDown(ajxLab, "\\13");
		selenium.keyUp(ajxLab, "\\13");
		selenium.keyPress(ajxLab, "\\13");

		if(!isChecked(selenium,chkImmunization1)){
			assertTrue(click(selenium, chkImmunization1), "Could not check Immunization", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		
		if(isElementPresent(selenium,lnkDelete)){
			assertTrue(click(selenium, lnkClose), "Could not click close", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		assertTrue(selectValueFromAjaxList(selenium, ajxCarepanel,mcTemplate.targetExceptionType), "Could not type due", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtHeightUpperLimt,mcTemplate.eheightUpperLimit), "Could not type Upper limit height", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtHeightLowerLimt,mcTemplate.eheightLowerLimit), "Could not type Lower limit height", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkClickToAdd), "Could not click on add link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selectValueFromAjaxList(selenium,ajxtargetExceptionType,mcTemplate.targetExceptionType),"Could not select measurement", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txteHeightUpperLimt,mcTemplate.eheightUpperLimit), "Could not type Upper limit height", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txteHeightLowerLimt,mcTemplate.eheightLowerLimit), "Could not type Lower limit height", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxForWho,mcTemplate.forWho),"Could not select measurement", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxConditionType,mcTemplate.condtionType),"Could not select measurement", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txteConditionAge,mcTemplate.condtionAge), "Could not type Lower limit height", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxCondtionAgeIn,mcTemplate.conditionAgeIn),"Could not select measurement", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
				
		assertTrue(click(selenium, btnClose), "Could not click save vitals button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkSave), "Could not click save", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkSave), "Could not click save", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		return true;
		
	}
	
	/**
	 * addCustomWidgetCareElement 
	 * Function to add custom widget Care Element
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Jul 15,2014
	 */
	public boolean addCustomWidgetCareElement(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName,String account) throws IOException{
		assertTrue(click(selenium, lnkEditFlowSheets), "Could not click on edit flow sheets", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!mcTemplate.testCaseId.equals("TC_MCT_027")&&!mcTemplate.testCaseId.equals("TC_MCT_056")){
		assertTrue(deleteandaddCategory(selenium, mcTemplate), "Adding category failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		assertTrue(click(selenium, btnAddCareElement), "Could not click on Add button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxCategory,mcTemplate.category),"Could not category", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxCareElementPanelsuggestBox,"Custom Widget"),"Could not select custom widget", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtDisplayAs,mcTemplate.display), "Could not type display as", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtDue,mcTemplate.due), "Could not type due", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxDueType,mcTemplate.dueType),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtUpcoming,mcTemplate.due), "Could not type due", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxAdvanceDue,mcTemplate.dueType),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxCarepanel,mcTemplate.addCareElement),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!mcTemplate.testCaseId.equals("TC_MCT_032")){
		assertTrue(click(selenium, lnkSave), "Could not click save", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		else 
		{
			assertTrue(click(selenium, btnSaveAnother), "Could not click save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			return true;
		}
		assertTrue(isElementPresent(selenium, btnAddCategory), "Immunization care element addition failed", selenium, ClassName, MethodName);
		
		if(!mcTemplate.testCaseId.equals("TC_MCT_022")&&!mcTemplate.testCaseId.equals("TC_MCT_027")&&!mcTemplate.testCaseId.equals("TC_MCT_033")&&!mcTemplate.testCaseId.equals("TC_MCT_056")){
			assertTrue(click(selenium, btnSave), "Could not click save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium, btnCreateCustom), "Immunization care element addition failed", selenium, ClassName, MethodName);
		}
		else{
				assertTrue(click(selenium, lnkSave), "Could not click save", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
		}
		return true;
	}
	
	/**
	 * addQuestionWidgetCareElement 
	 * Function to add question widget Care Element
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Nov 03,2014  
	 */
	public boolean addQuestionWidgetCareElement(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName,String account) throws IOException{
		assertTrue(click(selenium, lnkEditFlowSheets), "Could not click on edit flow sheets", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!mcTemplate.testCaseId.equals("TC_MCT_043")){
		assertTrue(deleteandaddCategory(selenium, mcTemplate), "Adding category failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		assertTrue(click(selenium, btnAddCareElement), "Could not click on Add button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxCategory,mcTemplate.category),"Could not category", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxCareElementPanelsuggestBox,"Custom Widget"),"Could not select custom widget", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtDisplayAs,mcTemplate.display), "Could not type display as", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtDue,mcTemplate.due), "Could not type due", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxDueType,mcTemplate.dueType),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtUpcoming,mcTemplate.due), "Could not type due", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxAdvanceDue,mcTemplate.dueType),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selectValueFromAjaxList(selenium,ajxCarepanel,"What is Your Age?"),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxtargetType,mcTemplate.heightUpperLimit),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent("Selected widget:"),"custom widget is not present", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(!mcTemplate.testCaseId.equals("TC_MCT_032")){
		assertTrue(click(selenium, lnkSave), "Could not click save", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(mcTemplate.testCaseId.equals("TC_MCT_043")){
			assertTrue(isTextPresent(selenium,"Duplicate care element name entered."), "Verify duplicate care element failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnOk), "Could not click ok button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btncancelManage), "Could not click save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			return true;
			}
		}
		else 
		{
			assertTrue(click(selenium, btnSaveAnother), "Could not click save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			return true;
		}
		assertTrue(isElementPresent(selenium, btnAddCategory), "Immunization care element addition failed", selenium, ClassName, MethodName);
		
		if(!mcTemplate.testCaseId.equals("TC_MCT_022")&&!mcTemplate.testCaseId.equals("TC_MCT_027")&&!mcTemplate.testCaseId.equals("TC_MCT_033")&&!mcTemplate.testCaseId.equals("TC_MCT_036")){
			assertTrue(click(selenium, btnSave), "Could not click save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium, btnCreateCustom), "Immunization care element addition failed", selenium, ClassName, MethodName);
		}
		else{
				assertTrue(click(selenium, lnkSave), "Could not click save", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
		}
		return true;
	}
	
	
	/**
	 * addCustomWidgetCareElementInPatientChart 
	 * Function to add custom widget Care Element in Patient Chart
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 16,2014
	 */
	public boolean addCustomWidgetCareElementInPatientChart(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName,String account) throws IOException{
		if(!mcTemplate.testCaseId.equals("TC_MCT_024")&&!mcTemplate.testCaseId.equals("TC_MCT_028")&&!mcTemplate.testCaseId.equals("TC_MCT_029")){
            assertTrue(click(selenium, btnAdd1), "Could not click on Add button", selenium, ClassName, MethodName);
            waitForPageLoad(selenium);
            assertTrue(selectValueFromAjaxList(selenium,ajxCategory,"No results found"),"Could not category", selenium, ClassName, MethodName);
            waitForPageLoad(selenium);
            assertTrue(type(selenium,txtCategoryName,mcTemplate.category),"Could not type the last name : More Details"+mcTemplate.toString(), selenium, ClassName, MethodName);
            assertTrue(click(selenium,btnSaveCategoryName),"could ot click save1", selenium, ClassName, MethodName);
            waitForPageLoad(selenium);
            }
		else
		{
			assertTrue(click(selenium, btnEdit1), "Could not click on Add button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

		}
		/*assertTrue(selectValueFromAjaxList(selenium,ajxCategory,mcTemplate.category),"Could not category", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);*/
		assertTrue(selectValueFromAjaxList(selenium,ajxCareElementPanelsuggestBox,"Custom Widget"),"Could not select custom widget", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtDisplayAs,mcTemplate.display), "Could not type display as", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtDue,mcTemplate.due), "Could not type due", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxDueType,mcTemplate.dueType),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtUpcoming,mcTemplate.due), "Could not type due", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxAdvanceDue,mcTemplate.dueType),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selectValueFromAjaxList(selenium,ajxCarepanel,mcTemplate.addCareElement),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtDisplayAs,mcTemplate.display), "Could not type display as", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		assertTrue(click(selenium, btnSaveCare), "Could not click save", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
	
	/**
	 * addNewCategoryInAddCareElementPage
	 * Function to add New 'Category' in 'Add Care Element' Page
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 16,2014
	 */
	public boolean addNewCategoryInAddCareElementPage(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName,String account) throws IOException{
		assertTrue(click(selenium,lnkEditFlowSheets),"could ot click edit", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,btnAddCareElement),"could ot click add", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,ajxCategory),"could ot click category", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,"currentItem_1"),"could ot click option", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(type(selenium,txtCategoryName,mcTemplate.category),"Could not type the last name : More Details"+mcTemplate.toString(), selenium, ClassName, MethodName);
		if(mcTemplate.testCaseId.equals("TC_MCT_022")){

		assertTrue(click(selenium,btnSaveCategoryName),"could ot click save1", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		else
		{
		assertTrue(click(selenium,btnCancelCategoryName),"could ot click cancel", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		return true;
	}
	
	/**
	 * deleteandaddCategory 
	 * Function to add Category
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Sep 16,2014
	 */
	public boolean deleteandaddCategory(Selenium selenium,ClinicalSettingLib mcTemplate){
		//assertTrue(deleteAllCategory(selenium, mcTemplate), "Adding category failed", selenium, ClassName, MethodName);
		try {
		if(selenium.isElementPresent(DeleteCareElement)) {
		assertTrue(click(selenium, DeleteCareElement), "Could not delete care element", selenium, ClassName, MethodName);
		assertTrue(click(selenium, btnYes), "Could not click on yes", selenium, ClassName, MethodName);
		}
		waitForPageLoad(selenium);
		if(selenium.isElementPresent(DeleteCategory)) {

		assertTrue(click(selenium, DeleteCategory), "Could not delete category", selenium, ClassName, MethodName);
		assertTrue(click(selenium, btnYes), "Could not yes", selenium, ClassName, MethodName);
		}
		waitForPageLoad(selenium);

		assertTrue(click(selenium, btnAddCategory), "Could not click on add new category", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtCategory,mcTemplate.category), "Could not type category", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSaveCategory), "Could not click on save category", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * addVitalsCareElement 
	 * Function to add vitals Care Element
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Jul 15,2014
	 */
	public boolean addVitalsCareElement(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName,String account) throws IOException{
		assertTrue(click(selenium, lnkEditFlowSheets), "Could not click on edit flow sheets", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!mcTemplate.testCaseId.equals("TC_MCT_035")){
			assertTrue(deleteandaddCategory(selenium, mcTemplate), "Adding category failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
		assertTrue(click(selenium, btnAddCareElement), "Could not click on Add button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxCategory,mcTemplate.category),"Could not category", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxCareElementPanelsuggestBox,"Vitals"),"Could not select Vitals", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtDisplayAs,mcTemplate.display), "Could not type display as", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtDue,mcTemplate.due), "Could not type due", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxDueType,mcTemplate.dueType),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtUpcoming,mcTemplate.due), "Could not type due", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxAdvanceDue,mcTemplate.dueType),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selectValueFromAjaxList(selenium,ajxCarepanel,mcTemplate.measurement),"Could not select measurement", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!mcTemplate.testCaseId.equals("TC_MCT_045")){
		assertTrue(selectValueFromAjaxList(selenium,ajxtargetType,mcTemplate.targetType),"Could not select target Type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(type(selenium, txtHeightUpperLimt,mcTemplate.heightUpperLimit), "Could not type upper limit height", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtHeightLowerLimt,mcTemplate.heightLowerLimit), "Could not type lower limit height", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		if(mcTemplate.testCaseId.equals("TC_MCT_037")||mcTemplate.testCaseId.equals("TC_MCT_038")||mcTemplate.testCaseId.equals("TC_MCT_039")||mcTemplate.testCaseId.equals("TC_MCT_040")){
			return true;
		}
		assertTrue(click(selenium, lnkClickToAdd), "Could not click on add link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selectValueFromAjaxList(selenium,ajxtargetExceptionType,mcTemplate.targetExceptionType),"Could not select measurement", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txteHeightUpperLimt,mcTemplate.eheightUpperLimit), "Could not type Upper limit height", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txteHeightLowerLimt,mcTemplate.eheightLowerLimit), "Could not type Lower limit height", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxForWho,mcTemplate.forWho),"Could not select measurement", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxConditionType,mcTemplate.condtionType),"Could not select measurement", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txteConditionAge,mcTemplate.condtionAge), "Could not type Lower limit height", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxCondtionAgeIn,mcTemplate.conditionAgeIn),"Could not select measurement", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, btnSaveVitals), "Could not click save vitals button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		assertTrue(click(selenium, lnkSave), "Could not click save", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(isElementPresent(selenium, btnAddCategory), "Immunization care element addition failed", selenium, ClassName, MethodName);
		assertTrue(isTextPresent(selenium, mcTemplate.category),"Failed", selenium, ClassName, MethodName);

		assertTrue(click(selenium, lnkSave), "Could not click save", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(isElementPresent(selenium, lnkEditFlowSheets), "custom widget addition failed", selenium, ClassName, MethodName);
		return true;
	}
	/**
	 * addVitalsCareElementInPatientChart 
	 * Function to add vitals Care Element In Patient Chart
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 27,2014
	 */
	public boolean addVitalsCareElementInPatientChart(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName,String account) throws IOException{
		assertTrue(click(selenium, btnEdit1), "Could not click on Add button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selectValueFromAjaxList(selenium,ajxCareElementPanelsuggestBox,"Vitals"),"Could not select Vitals", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtDisplayAs,mcTemplate.display), "Could not type display as", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtDue,mcTemplate.due), "Could not type due", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxDueType,mcTemplate.dueType),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtUpcoming,mcTemplate.due), "Could not type due", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxAdvanceDue,mcTemplate.dueType),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selectValueFromAjaxList(selenium,ajxCarepanel,mcTemplate.measurement),"Could not select measurement", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxtargetType,mcTemplate.targetType),"Could not select target Type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtHeightUpperLimt,mcTemplate.heightUpperLimit), "Could not type upper limit height", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSaveCare), "Could not click save", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
	
	/**
	 * addQuestionWidgetWithMultipleResponses 
	 * Function to add question widget Care Element
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Nov 06,2014  
	 */
	public boolean addQuestionWidgetWithMultipleResponses(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName,String account) throws IOException{
		assertTrue(click(selenium, lnkEditFlowSheets), "Could not click on edit flow sheets", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(deleteandaddCategory(selenium, mcTemplate), "Adding category failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnAddCareElement), "Could not click on Add button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxCategory,mcTemplate.category),"Could not category", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxCareElementPanelsuggestBox,"Custom Widget"),"Could not select custom widget", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtDue,mcTemplate.due), "Could not type due", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxDueType,mcTemplate.dueType),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtUpcoming,mcTemplate.due), "Could not type due", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxAdvanceDue,mcTemplate.dueType),"Could not type due type", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxCarepanel,"What is Your Age?"),"Could not type due type", selenium, ClassName, MethodName);

		assertTrue(isElementPresent(selenium, rdoSingleAnswer), "rdoSingleAnswer not present", selenium, ClassName, MethodName);
		assertTrue(isElementPresent(selenium, rdoMultipleAnswer), "rdoMultipleAnswer not present", selenium, ClassName, MethodName);
		assertTrue(isTextPresent(selenium, mcTemplate.heightUpperLimit), "Answer1 not present", selenium, ClassName, MethodName);
		assertTrue(isTextPresent(selenium, mcTemplate.heightLowerLimit), "Answer2 not present", selenium, ClassName, MethodName);
		if(mcTemplate.testCaseId.equals("TC_MCT_036")){

		assertTrue(click(selenium, rdoSingleAnswer), "Could not click on rdoSingleAnswer button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		else {
		assertTrue(click(selenium, rdoMultipleAnswer), "Could not click on rdoMultipleAnswer button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, chkChecked,mcTemplate.due), "Could not type Checked", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, chkUnchecked,mcTemplate.due), "Could not type Unchecked", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}		
		assertTrue(click(selenium, btnSaveCare), "Could not click save", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkSave), "Could not click save", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
	
	
	/**
	 * addVitalsCareElement 
	 * Function to add vitals Care Element
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Jul 15,2014
	 */
	public boolean addTargetException(Selenium selenium,ClinicalSettingLib mcTemplate,String account) throws IOException{
		assertTrue(click(selenium, lnkClickToAdd), "Could not click on add link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!mcTemplate.testCaseId.equals("TC_MCT_040")){

		assertTrue(selectValueFromAjaxList(selenium,ajxtargetExceptionType,mcTemplate.targetExceptionType),"Could not select measurement", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txteHeightUpperLimt,mcTemplate.eheightUpperLimit), "Could not type Upper limit height", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!mcTemplate.testCaseId.equals("TC_MCT_039")){

		assertTrue(type(selenium, txteHeightLowerLimt,mcTemplate.eheightLowerLimit), "Could not type Lower limit height", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		}
		assertTrue(selectValueFromAjaxList(selenium,ajxForWho,mcTemplate.forWho),"Could not select measurement", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxConditionType,mcTemplate.condtionType),"Could not select measurement", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!mcTemplate.testCaseId.equals("TC_MCT_040")){

		assertTrue(type(selenium, txteConditionAge,mcTemplate.condtionAge), "Could not type Lower limit height", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxCondtionAgeIn,mcTemplate.conditionAgeIn),"Could not select measurement", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		
		return true;
	}
	
	/**
	 * addCategory 
	 * Function to add Category
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Jul 14,2014
	 */
	public boolean addCategory(Selenium selenium,ClinicalSettingLib mcTemplate) throws IOException{
		assertTrue(deleteAllCategory(selenium, mcTemplate), "Adding category failed", selenium, ClassName, MethodName);
		assertTrue(click(selenium, btnAddCategory), "Could not click on add new category", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtCategory,mcTemplate.category), "Could not type category", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSaveCategory), "Could not click on save category", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	
	/**
	 * deleteCategory 
	 * Function to Delete Category
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Jul 14,2014
	 */
	public boolean deleteAllCategory(Selenium selenium,ClinicalSettingLib mcTemplate) throws IOException{
		int count=0;
		while(isElementPresent(selenium,lnkRemove)){
			click(selenium,lnkRemove);
			click(selenium, btnYes);
			waitForPageLoad(selenium);
			count++;
			if(count>15){
				break;
			}
		}
		return true;
	}
	/**
	 * editManagedCareTemplate 
	 * Function to Edit Managed Care template
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 29,2014
	 */
	public boolean editManagedCareTemplate(Selenium selenium)throws IOException
    {
    	assertTrue(click(selenium,btnEdit),"Unable to click the edit Button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,allergyEdtBtn),"Unable to click the allergy edit Button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
    }
	
	/**
	 * selectParticularAllergiesInManagedCare 
	 * Function to select particular Allergies in Managed Care Template
	 * @param 	selenium
	 * @throws IOException 
	 * @since  Oct 29,2014
	 */
	public boolean selectParticularAllergiesInManagedCare(Selenium selenium,ClinicalSettingLib templateData )throws IOException
	{
		assertTrue(click(selenium,rdoSelected),"Unable to click the selected radio Button",selenium, ClassName, MethodName);
		assertTrue(selectValueFromAjaxList(selenium,ajxaAlergyName1,templateData.drugType),"Unable to click the edit Button",selenium, ClassName, MethodName);
		assertTrue(selectValueFromAjaxList(selenium,ajxAlergySugg,templateData.allergyType),"Unable to click the edit Button",selenium, ClassName, MethodName);
		assertTrue(click(selenium,lnkSave),"Unable to save the allergy template",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnSaveWhole),"Unable to click the save Button",selenium, ClassName, MethodName);
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
		assertTrue(click(selenium,lnkPatientChart),"Unable to click patient chart link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
    }
	
    /**
	 * navigateToManagedCare 
	 * Function to navigate to Managed Care
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Jul 17,2014
	 */
	public boolean navigateToManagedCareFlowSheet(Selenium selenium,ClinicalSettingLib mcTemplate, String account) throws IOException{
		String date="";
		assertTrue(click(selenium, lnkMore), "Could not click on more link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkFlowSheets), "Could not click on flow sheets link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(!this.MethodName.equals("verifySortOfManagedCareTemplate")){
			assertTrue(deleteAllCategory(selenium, mcTemplate), "Adding category failed", selenium, ClassName, MethodName);
		}assertTrue(click(selenium, btnAddCareElement), "Could not click on add care element", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxTemplateName,mcTemplate.templateName),"Could not select measurement", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		if (account.equals(CAAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = DateFormat.format(cal.getTime());

		} else if(account.equals(USAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat.format(cal.getTime());

		}
		assertTrue(enterDate(selenium,txtDateValue,date),"Could not enter the start Date", selenium, ClassName, MethodName);
		assertTrue(click(selenium, btnTemplateSave), "Could not click on save link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium, lnkViewEdit), "Could not click on view link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(mcTemplate.testCaseId.equals("TC_VSP_007")){
		assertTrue(!selenium.isVisible(btnRemove),"Could not click the Rmove link;More Details", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		assertTrue(click(selenium, lnkViewEdit), "Could not click on view link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium, lnkFullView), "Flow Sheet is not displayed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
	
	
	public boolean navigateToManagedCareFlowSheetWithUniqueName(Selenium selenium,ClinicalSettingLib mcTemplate, String account,String uniquename) throws IOException{
		String date="";
		assertTrue(click(selenium, lnkMore), "Could not click on more link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkFlowSheets), "Could not click on flow sheets link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(deleteAllCategory(selenium, mcTemplate), "Adding category failed", selenium, ClassName, MethodName);
		assertTrue(click(selenium, btnAddCareElement), "Could not click on add care element", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxTemplateName,mcTemplate.templateName+uniquename),"Could not select measurement", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		if (account.equals(CAAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = DateFormat.format(cal.getTime());

		} else if(account.equals(USAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat.format(cal.getTime());

		}
		assertTrue(enterDate(selenium,txtDate,date),"Could not enter the start Date", selenium, ClassName, MethodName);
		assertTrue(click(selenium, lnkSave), "Could not click on save link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium, lnkViewEdit), "Could not click on view link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(mcTemplate.testCaseId.equals("TC_VSP_007")){
		assertTrue(!selenium.isVisible(btnRemove),"Could not click the Rmove link;More Details", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		assertTrue(click(selenium, lnkViewEdit), "Could not click on view link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium, lnkFullView), "Flow Sheet is not displayed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
	
	/**
	 * addManagedCareFlowSheetInProblemList 
	 * Function to add  Managed Care Template in Problem list
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Nov 03,2014
	 */
	public boolean addManagedCareFlowSheetInProblemList(Selenium selenium,ClinicalSettingLib mcTemplate, String uniqueName, String account) throws IOException{
		String date="";
		assertTrue(click(selenium,chkTrackCondition),"Could not click the Track Condition check box", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,ajxTemplate),"Could not click the Track Condition check box", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(!selenium.isTextPresent(mcTemplate.templateName+uniqueName),"Template name is present", selenium, ClassName, MethodName);

		assertTrue(selectValueFromAjaxList(selenium,ajxTemplate,mcTemplate.templateName),"Could not select template ", selenium, ClassName, MethodName);

		if (account.equals(CAAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			date = DateFormat.format(cal.getTime());

		} else if(account.equals(USAccount)) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy");
			date = DateFormat.format(cal.getTime());

		}
		assertTrue(enterDate(selenium,txtDate,date),"Could not enter the start Date", selenium, ClassName, MethodName);
		
		assertTrue(click(selenium,btnAdd),"Could not click the Add button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,btnEditProblemList),"Could not click the edit button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selenium.isEditable(chkTrackCondition),"Could not click the edit button", selenium, ClassName, MethodName);
		
		assertTrue(click(selenium,btnEditSaveProblemList),"Could not click the Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,btnSaveProblemList),"Could not click the Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		return true;
		
	}
		
	/**
	 * removeAllTemplateInPatientChart 
	 * Function to remove All Template In Patient Chart
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Nov 03,2014
	 */
	public boolean removeAllTemplateInPatientChart(Selenium selenium,ClinicalSettingLib mcTemplate) throws IOException{
		int count=0;
		while(isElementPresent(selenium,lnkRemove)){
			click(selenium,lnkRemove);
			click(selenium, btnYes);
			waitForPageLoad(selenium);
			count++;
			if(count>15){
				break;
			}
		}
		return true;
	}
	
	/**
	 * createNewPatientWithMandatoryFields
	 * Function to create a New Patient with Mandatory Fields only 
	 * @param 	selenium
	 * @throws IOException 
	 * @since   Oct 16,2014
	 */
	
	public boolean createNewPatientWithMandatoryFields(Selenium selenium,HomeLib PatientData)throws IOException
	{
		assertTrue(click(selenium,lnkQuickLink),"Unable click quick actions link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkNewPatientReg),"Unable to click Register New patient",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtPatientFirstName,PatientData.firstName),"Unable to Enter the Patient First Name",selenium, ClassName, MethodName);
		assertTrue(type(selenium,txtPatientLastName,PatientData.lastName),"Unable to Enter the patient last name",selenium, ClassName, MethodName);
		assertTrue(selectValueFromAjaxList(selenium,ajxStatus,PatientData.status),"Unable to enter the patient status",selenium, ClassName, MethodName);
		assertTrue(click(selenium,btnSaveWhole),"Unable to save the patient data",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		
	return true;
	}
	/** 
	 * verifyFlowSheet 
	 * Function to verify flow sheet
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Jul 18,2014
	 */
	public boolean verifyFlowSheet(Selenium selenium,ClinicalSettingLib mcTemplate, String account) throws IOException{
		assertTrue(getText(selenium,lnkAllergy).toLowerCase().trim().contains("ALLERGIES".toLowerCase().trim()),"Allergy is not added to template", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lnkMedicationTitle).toLowerCase().trim().contains("MEDICATION".toLowerCase().trim()),"MEDICATION is not added to template", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lnkFlowSheet).toLowerCase().trim().contains("FLOWSHEET".toLowerCase().trim()),"FLOWSHEET is not added to template", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(mcTemplate.templateName), "Template name is not present", selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(mcTemplate.category), "category is not present", selenium, ClassName, MethodName);
		//assertTrue(selenium.isTextPresent(mcTemplate.display), "category is not present", selenium, ClassName, MethodName);
		return true;
	}
	
	/**
	 * searchPatientNexiaForProviderHomePage
	 * function for Searching a patient in the Nexia application   
	 * @param 		selenium
	 * @param 		patientID (Patient ID to be searched)
	 * @throws IOException 
	 
	 * @since  	    Sep 29, 2012
	 */
	public boolean searchPatientNexiaForProviderHomePage(Selenium selenium,String patientID){
	try{
		
		try{
			assertTrue(type(selenium,txtPatientBox,patientID),"Could not type patient id", selenium, ClassName, MethodName);
		}catch(Exception e){
			assertTrue(type(selenium,txtPatientBox,patientID),"Could not type patient id", selenium, ClassName, MethodName);
		}
		
		selenium.clickAt("searchPatientBox","");
		selenium.focus("searchPatientBox");			
		selenium.fireEvent("searchPatientBox","keypress");
		
		//selenium.keyPress(txtPatientBox, "\\9");
		waitForElement(selenium,lblPatientResult,30000);
		assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patientID, selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))),"", selenium, ClassName, MethodName);
		//Assert.assertTrue(getText(selenium,lblPatientResult).contains(patientID));
		waitForPageLoad(selenium);
		click(selenium,lblPatientResult);
		waitForPageLoad(selenium);
		assertTrue(isElementPresent(selenium,lblPatientName),"The searched patient information could not be loaded", selenium, ClassName, MethodName);
		if(isElementPresent(selenium,lnkPatientSelect)){
			assertTrue(click(selenium,lnkPatientSelect),"Could not click the ", selenium, ClassName, MethodName);
		}	
		
		if(isElementPresent(selenium,lnkContinue)){
			selenium.click(lnkContinue);
		}
		if(isElementPresent(selenium, btnErrorClose))

			assertTrue(click(selenium, btnErrorClose),"Could not click Error close Button", selenium, ClassName, MethodName);
	}catch(RuntimeException e){
		e.printStackTrace();
	}catch(Exception e){
		
	}
		return true;
		
	}
	
	public boolean createSpecifiedMedication(Selenium selenium,ClinicalSettingLib mcTemplate,String userAccount) throws IOException{
		try{
		assertTrue(click(selenium, TemplateMedEdit), "Could not click on Template Medication edit button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, TemplateSpecMed), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
		if(userAccount.equals(CAAccount)){
	    assertTrue(selectValueFromAjaxList(selenium,TemplateMedSuggest,mcTemplate.medicationName1), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    assertTrue(selectValueFromAjaxList(selenium,TemplateMedSuggestClass,mcTemplate.DrugClassName1), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
		}
		else{
			assertTrue(selectValueFromAjaxList(selenium,TemplateMedSuggest,mcTemplate.usmedicationName1), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
		    assertTrue(selectValueFromAjaxList(selenium,TemplateMedSuggestClass,mcTemplate.usDrugClassName1), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
		}
	    assertTrue(click(selenium, TemplateMedSave), "Could not click on save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSave), "Could not click on save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		catch(RuntimeException e){
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean verifyCreatedMedicationAddedonTemplate(Selenium selenium,ChartPreVisitLib mcTemplate,String userAccount) throws IOException{
		try{
			assertTrue(selenium.isElementPresent(ChartTempMed),"Added medication ID is not visible in Template", selenium, ClassName, MethodName);
			System.out.println(getText(selenium,ChartTempMed));
			if(userAccount.equals(CAAccount)){
			System.out.println(mcTemplate.prescribeCa);
			
			assertTrue(getText(selenium,ChartTempMed).contains(mcTemplate.prescribeCa),"Medication is not added to template", selenium, ClassName, MethodName);
			}
			else{
				System.out.println(mcTemplate.prescribe);
				assertTrue(getText(selenium,ChartTempMed).contains(mcTemplate.prescribe),"Medication is not added to template", selenium, ClassName, MethodName);
			}
		}
		catch(RuntimeException e){
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean verifyCreatedMedicationAddedonTemplateEdit(Selenium selenium,ChartPreVisitLib mcTemplate,String userAccount) throws IOException{
		try{
			assertTrue(selenium.isElementPresent(ChartTempMed),"Added medication ID is not visible in Template", selenium, ClassName, MethodName);
			System.out.println(getText(selenium,ChartTempMed));
			if(userAccount.equals(CAAccount)){
			System.out.println(mcTemplate.prescribeCa);
			
			assertTrue(getText(selenium,ChartTempMed).contains(mcTemplate.prescribeCa),"Medication is not added to template", selenium, ClassName, MethodName);
			}
			else{
				System.out.println(mcTemplate.prescribe);
				assertTrue(getText(selenium,ChartTempMed).contains(mcTemplate.prescribe),"Medication is not added to template", selenium, ClassName, MethodName);
			}
		}
		catch(RuntimeException e){
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean verifyUpdatedMedicationAddedonTemplate(Selenium selenium,ClinicalSettingLib mcTemplate,String userAccount) throws IOException{
		try{
			
			assertTrue(selenium.isElementPresent(ChartTempMed),"Added medication ID is not visible in Template", selenium, ClassName, MethodName);
			if(userAccount.equals(CAAccount)){
			System.out.println(mcTemplate.medicationName2);
			System.out.println(getText(selenium,ChartTempMed));
			assertTrue(getText(selenium,ChartTempMed).contains(mcTemplate.medicationName2),"Specified is not added to template", selenium, ClassName, MethodName);
			}
			else{
				System.out.println(mcTemplate.usmedicationName2);
				System.out.println(getText(selenium,ChartTempMed));
				assertTrue(getText(selenium,ChartTempMed).contains(mcTemplate.usmedicationName2),"Specified is not added to template", selenium, ClassName, MethodName);	
			}
		}
		catch(RuntimeException e){
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean createSpecifiedMedicationClass(Selenium selenium,ClinicalSettingLib mcTemplate,String userAccount) throws IOException{
		try{
		assertTrue(click(selenium, TemplateMedEdit), "Could not click on Template Medication edit button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, TemplateSpecMed), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
		if(userAccount.equals(CAAccount)){
	    assertTrue(selectValueFromAjaxList(selenium,TemplateMedSuggest,mcTemplate.DrugClassName1), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	   }
		else{
			assertTrue(selectValueFromAjaxList(selenium,TemplateMedSuggest,mcTemplate.usDrugClassName1), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
		}
	    assertTrue(click(selenium, TemplateMedSave), "Could not click on save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnSave), "Could not click on save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		}
		catch(RuntimeException e){
			e.printStackTrace();
		}
		return true;
	}
	
	
	 public boolean selectPracticeNexia(Selenium selenium) throws IOException
	    {
	    	if(!getText(selenium,lnkLocationMenuHeader).contains("Encounter")){
	    		assertTrue(click(selenium,lnkLocationMenuHeader),"Could not click on practices link:", selenium, ClassName, MethodName);
	    		waitForPageLoad(selenium);
	    	 int Count;
	    		int Count1=(Integer) selenium.getXpathCount("//tr/td/a/span");
	    		for(Count=1;Count<=Count1;Count++)		{
	    			if(getText(selenium,"//tr["+Count+"]/td/a/span").contains("Automation")){
	    				
	    				assertTrue(click(selenium,"//tr["+Count+"]/td/a/span"),"Could not click on practices link:", selenium, ClassName, MethodName);
	    				waitForPageLoad(selenium);
	    			}
	    		}		
	    	}
	    	 if(isElementPresent(selenium, btnErrorClose))
	 			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	    	return true;
	    }





	public boolean updateTemplateMedication(Selenium selenium,ClinicalSettingLib mcTemplate,String userAccount,String uniqueName) throws IOException{
		try{
			assertTrue(navigateToManagedCareTemplate(selenium),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(searchTempateUsingTemplateName(selenium,mcTemplate,uniqueName),"Could not select template type", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnEdit), "Could not click on Template Edit button", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, TemplateMedEdit), "Could not click on Template Medication edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(userAccount.equals(CAAccount)){
			assertTrue(selectValueFromAjaxList(selenium,ajxTemplateName,mcTemplate.MedicationDrugClassName2), "Could not Select Medication class", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
			}
			else{
				assertTrue(selectValueFromAjaxList(selenium,ajxTemplateName,mcTemplate.usDrugClassName2), "Could not Select Medication class", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			}
		    assertTrue(click(selenium, TemplateMedSave), "Could not click on save button",selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSave), "Could not click on save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		catch(RuntimeException e){
		e.printStackTrace();
	}
	return true;
  }
	
	public boolean searchTextBox(Selenium selenium,String element,String value) throws IOException{
		try{	
			selenium.clickAt(element,"");
			assertTrue(type(selenium, element,value), "Could not type Name", selenium, ClassName, MethodName);
			selenium.keyDown(element, "\\13");
			selenium.keyUp(element, "\\13");
			selenium.keyPress(element, "\\13");
			waitForPageLoad(selenium);
	    }
		catch(RuntimeException e){
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean cancelUpdateTemplateMedication(Selenium selenium,ClinicalSettingLib mcTemplate,String userAccount,String uniqueName) throws IOException{
		try{
			assertTrue(navigateToManagedCareTemplate(selenium),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(searchTempateUsingTemplateName(selenium,mcTemplate,uniqueName),"Could not select template type", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnEdit), "Could not click on Template Edit button", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, TemplateMedEdit), "Could not click on Template Medication Edit button", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
			if(userAccount.equals(CAAccount)){
			assertTrue(selectValueFromAjaxList(selenium,ajxTemplateName,mcTemplate.MedicationDrugClassName2), "Could not Select Medication class", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
			}
			else{
				assertTrue(selectValueFromAjaxList(selenium,ajxTemplateName,mcTemplate.MedicationDrugClassName2), "Could not Select Medication class", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			}
		    assertTrue(click(selenium, TemplateMedSave), "Could not click on Medication save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    assertTrue(click(selenium, TemplateCancel), "Could not click on Template Cancel  button",selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
			assertTrue(click(selenium, TemplateCancelYes), "Could not click on Yes in Warning message",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		catch(RuntimeException e){
		e.printStackTrace();
	}
	return true;
  }
	
	public boolean navigateToManagedCareFlowSheetEdit(Selenium selenium,ClinicalSettingLib mcTemplate) throws IOException{
		try{
			assertTrue(click(selenium, lnkMore), "Could not click on more link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkFlowSheets), "Could not click on flow sheets link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium, lnkViewEdit), "Could not Find on view/Edit Link ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkViewEdit), "Could not click on view/Edit link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,ChartCareMed), "Could not click on Medication Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		catch(RuntimeException e){
		e.printStackTrace();
	}
	return true;
  }
	
	public boolean verifyEditTitle(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName,String userAccount) throws IOException{
		try{
			//Medication
			assertTrue(click(selenium, TemplateMedEdit), "Could not click on Template Medication edit button", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Edit Medications"),"Medication Text Not Present", selenium, ClassName,MethodName);
			System.out.println("Edit Medications");
			assertTrue(click(selenium, TemplateSpecMed), "Could not select Specified Medication Checkbox", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
		    if(userAccount.equals(CAAccount)){
			    assertTrue(selectValueFromAjaxList(selenium,TemplateMedSuggest,mcTemplate.medicationName1), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			    assertTrue(selectValueFromAjaxList(selenium,TemplateMedSuggestClass,mcTemplate.DrugClassName1), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
				}
				else{
					assertTrue(selectValueFromAjaxList(selenium,TemplateMedSuggest,mcTemplate.usmedicationName1), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
				    waitForPageLoad(selenium);
				    assertTrue(selectValueFromAjaxList(selenium,TemplateMedSuggestClass,mcTemplate.usDrugClassName1), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
				    waitForPageLoad(selenium);
				}
			assertTrue(click(selenium, lnkSave), "Could not click on Save button", selenium, ClassName, MethodName);
			//Allergy
			assertTrue(click(selenium, TemplateAllergyEdit), "Could not click on Template Allergy edit button", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Edit Allergies"),"Allergy Text Not Present", selenium, ClassName,MethodName);
			System.out.println("Edit Allergies");
			assertTrue(click(selenium,rdoSelected),"Unable to click the selected radio Button",selenium, ClassName, MethodName);
			System.out.println(mcTemplate.drugType);
			assertTrue(selectValueFromAjaxList(selenium,ajxaAlergyName1,mcTemplate.drugType),"Unable to Select Drug",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxAlergySugg,mcTemplate.allergyType),"Unable to select Allergy type",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkSave), "Could not click on Save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//Flow Sheet
			assertTrue(click(selenium, TemplateFlowSheetEdit), "Could not click on Template Flow Sheet edit button", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Edit Flowsheet"),"Flow Sheet Text Not Present", selenium, ClassName,MethodName);
			System.out.println("Edit Flowsheet");
			assertTrue(click(selenium, btnBack), "Could not click on Back button", selenium, ClassName, MethodName);
			assertTrue(addLabTestCareElement(selenium,mcTemplate,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium, btnTemplateSave), "Could not click on Template save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		catch(RuntimeException e){
		e.printStackTrace();
	}
	return true;
  }
	
	public boolean verifyDisplayofFlowSheets(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName,String userAccount) throws IOException{
		try{
			assertTrue(searchTempateUsingTemplateName(selenium,mcTemplate,uniqueName),"Could not select template type", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkSearchedItem), "Could not click on searched item from the list", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			System.out.println(mcTemplate.userName.toUpperCase(new java.util.Locale("en", "US")));
			assertTrue(selenium.isTextPresent(mcTemplate.userName.toUpperCase(new java.util.Locale("en", "US"))), "User Name is not visible", selenium, ClassName, MethodName);
			 if(userAccount.equals(CAAccount)){
			assertTrue(selenium.isTextPresent(mcTemplate.DrugClassName1), "Added Medication Class is not visible", selenium, ClassName, MethodName);
			 }
			 else{
				 assertTrue(selenium.isTextPresent(mcTemplate.usDrugClassName1), "Added Medication Class is not visible", selenium, ClassName, MethodName);
			 }
			assertTrue(selenium.isTextPresent(mcTemplate.drugType), "Added Allergy Drug is not visible", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(mcTemplate.allergyType), "Added Allergy Type is not visible", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(mcTemplate.category), "Care Elements Category is not visible", selenium, ClassName,MethodName);
			assertTrue(selenium.isTextPresent(mcTemplate.display), "Care Element Display as is not visible", selenium, ClassName, MethodName);
//			assertTrue(selenium.isTextPresent(mcTemplate.targetExceptionType), "Target Exception is not visible", selenium, ClassName,MethodName);
//			assertTrue(selenium.isTextPresent(mcTemplate.due), "Due date is not visible", selenium, ClassName, MethodName);
//			assertTrue(selenium.isTextPresent(mcTemplate.dueType), "Due type is not visible", selenium, ClassName, MethodName);
		}
		catch(RuntimeException e){
		e.printStackTrace();
	}
	return true;
  }
	
	public boolean useExistingTemplate(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName) throws IOException{
		try{
			assertTrue(selectValueFromAjaxList(selenium,ajxTemplateType,"Managed Care"),"Could not select template type", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnCreateCustom), "Could not click on create button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkstartBlankTemplate), "Could not click on existing template link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, applyExistTemplate), "Could not click on existing template link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(searchTempateUsingTemplateName(selenium,mcTemplate,uniqueName),"Could not select template type", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, "link="+mcTemplate.templateName+uniqueName), "Could not click on searched item from the list", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnUseThis), "Could not click on use this icon", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, TemplateCancelYes), "Could not click on use this icon", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName1=DateFormat1.format(cal1.getTime());
			assertTrue(createManagedCareTemplateWithMandatory(selenium,mcTemplate,uniqueName1),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		catch(RuntimeException e){
		e.printStackTrace();
	}
	return true;
  }
	
	public boolean USsearchPatientGotoChart(Selenium selenium,String patientID)throws IOException{
		try{
			assertTrue(type(selenium,txtPatientBox,patientID),"Could not type patient id", selenium, ClassName, MethodName);
			selenium.clickAt("searchPatientBox","");
			selenium.focus("searchPatientBox");			
			selenium.fireEvent("searchPatientBox","keypress");
			waitForElement(selenium,lblPatientResult,30000);
			assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-"+patientID, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lblPatientName),"The searched patient information could not be loaded", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblPatientResult).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))),"Patiend Id", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblPatientResult),"Couldnt click on the searched result", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!isElementPresent(selenium,lnkMore)){
				assertTrue(click(selenium,lnkPatientOptions),"Could not click Patient options :-"+patientID, selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,patientChart),"Could not click on Pateint chart", selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);

			if(isElementPresent(selenium,lnkContinue))
				selenium.click(lnkContinue);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"Could not click Error close Button", selenium, ClassName, MethodName);
		}		
		catch(RuntimeException e){
		e.printStackTrace();
	}
	return true;
  }
	
	 public boolean selectPractice(Selenium selenium) throws IOException
	    {
	    	if(!getText(selenium,lnkLocationMenuHeader).contains("Encounter")){
	    		assertTrue(click(selenium,lnkLocationMenuHeader),"Could not click on practices link:", selenium, ClassName, MethodName);
	    		waitForPageLoad(selenium);
	    	 int Count;
	    		int Count1=(Integer) selenium.getXpathCount("//tr/td/a/span");
	    		for(Count=1;Count<=Count1;Count++)		{
	    			if(getText(selenium,"//tr["+Count+"]/td/a/span").contains("Encounter")){
	    				
	    				assertTrue(click(selenium,"//tr["+Count+"]/td/a/span"),"Could not click on practices link:", selenium, ClassName, MethodName);
	    				waitForPageLoad(selenium);
	    			}
	    		}		
	    	}
	    	 if(isElementPresent(selenium, btnErrorClose))
	 			assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
	    	return true;
	    }
	 public boolean createSpecifiedMedicationInFlowSheet(Selenium selenium,ClinicalSettingLib mcTemplate,String userAccount) throws IOException{
			try{
			if(userAccount.equals(CAAccount)){
		    assertTrue(selectValueFromAjaxList(selenium,EditFlowSheetMedSuggest,mcTemplate.medicationName1), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
		    assertTrue(selectValueFromAjaxList(selenium,EditFlowSheetMedSuggestClass,mcTemplate.DrugClassName1), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
			}
			else{
				assertTrue(selectValueFromAjaxList(selenium,EditFlowSheetMedSuggest,mcTemplate.usmedicationName1), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			    assertTrue(selectValueFromAjaxList(selenium,EditFlowSheetMedSuggestClass,mcTemplate.usDrugClassName1), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			}
		    }
			catch(RuntimeException e){
				e.printStackTrace();
			}
			return true;
		}
		
		public boolean createSpecifiedMedicationClassInFlowSheet(Selenium selenium,ClinicalSettingLib mcTemplate,String userAccount) throws IOException{
			try{
			if(userAccount.equals(CAAccount)){
		    assertTrue(selectValueFromAjaxList(selenium,EditFlowSheetMedSuggest,mcTemplate.DrugClassName1), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
			}
			else{
			    assertTrue(selectValueFromAjaxList(selenium,EditFlowSheetMedSuggest,mcTemplate.usDrugClassName1), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			}
		    }
			catch(RuntimeException e){
				e.printStackTrace();
			}
			return true;
		}
		
		public boolean searchTempateUsingTemplateName(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName) throws IOException{
			try{
				selenium.focus(txtSearchCareElement);
				selenium.clickAt(txtSearchCareElement,"");
				assertTrue(type(selenium,txtSearchCareElement,mcTemplate.templateName+uniqueName), "Could not type Name", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selenium.keyPress(txtSearchCareElement, "\\13");
				waitForPageLoad(selenium);
		    }
			catch(RuntimeException e){
				e.printStackTrace();
			}
			return true;
		}
		
		public boolean verifyPreviewMedicationButton(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName,String userAccount) throws IOException{
			try{	
				assertTrue(click(selenium, TemplateMedEdit), "Could not click on Template Medication edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, TemplateSpecMed), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			    assertTrue(click(selenium, btnPreview), "Could not click on Preview button", selenium, ClassName, MethodName);
			    assertTrue(!isElementPresent(selenium,medicationPreview), "Preview button is visible even drug class name is not selected.", selenium, ClassName, MethodName);
				if(userAccount.equals(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium,TemplateMedSuggest,mcTemplate.DrugClassName1), "Could not select drug class", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
				}
				else{
				assertTrue(selectValueFromAjaxList(selenium,TemplateMedSuggest,mcTemplate.usDrugClassName1), "Could not select drug class", selenium, ClassName, MethodName);
				}
			    assertTrue(click(selenium, btnPreview), "Could not click on Preview button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,medicationPreview), "Preview button is not visible after drug class name is selected.", selenium, ClassName, MethodName);
				assertTrue(click(selenium,lnkClosePreview), "Preview button is not visible after drug class name is selected.", selenium, ClassName, MethodName);
				assertTrue(click(selenium, TemplateMedSave), "Could not click on save button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnSave), "Could not click on save button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
		    }
			catch(RuntimeException e){
				e.printStackTrace();
			}
			return true;
		}
		
		
		
		public boolean verifyPreviewMedicationClass(Selenium selenium,ClinicalSettingLib mcTemplate,String uniqueName,String userAccount) throws IOException{
			try{	
				assertTrue(click(selenium, TemplateMedEdit), "Could not click on Template Medication edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, TemplateSpecMed), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			if(userAccount.equals(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium,TemplateMedSuggest,mcTemplate.medicationName1), "Could not select drug class", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
				}
				else{
					assertTrue(selectValueFromAjaxList(selenium,TemplateMedSuggest,mcTemplate.usmedicationName1), "Could not select drug class", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				assertTrue(isElementPresent(selenium,TemplateMedSuggestClass), "Drug class is not visible even Medication name is not selected.", selenium, ClassName, MethodName);
				if(userAccount.equals(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium,TemplateMedSuggestClass,mcTemplate.DrugClassName1), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				}
				else{
					assertTrue(selectValueFromAjaxList(selenium,TemplateMedSuggestClass,mcTemplate.usDrugClassName1), "Could not click on Template Specified Medication edit button", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				assertTrue(click(selenium, TemplateMedSave), "Could not click on save button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnSave), "Could not click on save button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
		    }
			
			
			catch(RuntimeException e){
				e.printStackTrace();
			}
				return true;
		}
		
		
		public boolean verifyCancelledMedication(Selenium selenium,ClinicalSettingLib mcTemplate,String userAccount) throws IOException{
			try{
				
				assertTrue(selenium.isElementPresent(ChartTempMed),"Added medication ID is not visible in Template", selenium, ClassName, MethodName);
				if(userAccount.equals(CAAccount)){
				System.out.println(mcTemplate.medicationName2);
				System.out.println(getText(selenium,ChartTempMed));
				assertTrue(!getText(selenium,ChartTempMed).contains(mcTemplate.medicationName2),"Specified is not added to template", selenium, ClassName, MethodName);
				}
				else{
					System.out.println(mcTemplate.usmedicationName2);
					System.out.println(getText(selenium,ChartTempMed));
					assertTrue(!getText(selenium,ChartTempMed).contains(mcTemplate.usmedicationName2),"Specified is added to template", selenium, ClassName, MethodName);	
				}
			}
			catch(RuntimeException e){
				e.printStackTrace();
			}
			return true;
		}
		
		 public boolean deleteAllCustomSection(Selenium selenium) throws IOException
			{ 
		      int count=1;
			  int Count1=(Integer) selenium.getXpathCount("//div[contains(@id,'templateFocusPanel')]");
			  
			while(Count1>0)
			{
				String template="xpath=(//div[contains(@id,'templateFocusPanel')])["+count+"]";
				
				if(isElementPresent(selenium,btnDelete)&&isElementPresent(selenium,template))
				{
					click(selenium,template);
					assertTrue(click(selenium, btnDelete),"could not click",selenium, ClassName, MethodName);
					 waitForPageLoad(selenium);
					 assertTrue(click(selenium, btnYesButton), "could not click yes button",selenium, ClassName, MethodName);
					 waitForPageLoad(selenium);		
				}
			
				 if(isElementPresent(selenium,btnErrorClose)){
		            	click(selenium,btnErrorClose);}
				 Count1--;
			    }
			return true;
			}
			  
}



