package com.nexia.selenium.genericlibrary.auditLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.testng.Assert;

import bsh.This;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.sharedlibrary.AbstractTest;
import com.thoughtworks.selenium.Selenium;
public class AbstractAuditLog extends AbstractTest{
	
	public String btnPayerList ="!patientPayersList";
	public String btnDeletePayer="//a[contains(text(),'Delete')]";
	public String btnEditPayer="//a[contains(text(),'Edit')]";
	
	
	public String btnPatientMedicalPayers= "!patientMedicalPayers";
	public String btnPatientOtherPayers= "!patientOtherPayers";
	
	public String btnAddNewPayer = "css=div.add-button";
	public String ajxPayerSelect ="payerSearchSuggestBoxsuggestBox";
	public String ajxRelationShip ="subscriberRelationshipSuggestBoxsuggestBox";
	public String txtPayerStartDate ="css=input.gwt-DateBox.text-box";
	public String txtPayerEndDate ="xpath=(//input[@type='text'])[11]";
	public String txtPayerEndDateOther ="xpath=(//input[@type='text'])[15]";
	
	public String txtRelationDob ="xpath=(//input[@type='text'])[38]";
	
	
	
	public String txtCoPay = "coPayDollarsId"; 
	public String txtSpecialistCoPay = "xpath=(//input[@id='coPayDollarsId'])[2]";
	public String txtDeductible = "xpath=(//input[@id='coPayDollarsId'])[3]";
	public String txtCoInsurance = "xpath=(//input[@id='coPayDollarsId'])[4]";
	
	public String txtPayerNewSeriesEndDate ="xpath=(//input[@type='text'])[5]";
	
	public String txtMemberID = "memberId";
	public String txtGroupNoID = "groupNumberId";
	public String txtGroupNameID = "groupNameId";
	
	public String btnlnkChangeBillingOrder = "link=Change Billing Order";
	public String btnlnkSave = "link=Save";
	public String btnlnkCancel = "link=Cancel";
	public String btnlnkNewDateSave = "//div[3]/div/div[2]/a";
	
	public String btnlnkAddAnother =  "link=Save and add another";
	public String btnOK = "okButton";
	public String txtBillingAddr1 ="billingAddr1";
	public String txtBillingAddr2 ="billingAddr2";
	public String txtBillingCity ="billingCity";
	public String ajxBillingCountrySuggestBox ="billingCountrySuggestBoxsuggestBox";
	public String txtRelationFirstName="firstNameId";
	public String txtRelationLastName="lastNameId";


	public String txtBillingZip ="billingZip";
	public String ajxBillingStateSuggestBox ="billingStateSuggestBoxsuggestBox";
	public String ajxTypeOfCoverageSuggest ="typeOfCoverageSuggestBoxsuggestBox";
	public String ajxReleaseOfInformatiom ="releaseOfInformationSuggestBoxsuggestBox";
	
	

	
	public String chkBoxOutOfNetworkBenefit ="outOfNetworkBenefitsIdcheckbox";
	public String chkBoxauthorizationRequired ="authorizationRequiredIdcheckbox";
	public String chkBoxAcceptAssignment ="acceptAssignmentIdcheckbox";
	
	public String lnkPayerDel ="link=Delete";
	public String lnkPayerDel1 ="//a[contains(text(),'Delete')]";
	
	
	public String vfyPayerDetails = "//div/div[2]/div[2]/div/div";
	public String vfyPayerDetails2 = "//div[2]/div[2]/div[2]/div";
	public String vfyPayerDetails1 = "//div[2]/div[2]/div/div[5]";
	
	public String vfyCurrentPayerDetails = "//div[3]/div/div/div/div[3]/div/div/div";
	
	public String vfyExpiredSeries = "//div[3]/div[2]/div/div";
	public String vfyExpiredSeries1 = "//div[3]/div[2]/div[2]/div[2]/div";
	public String vfyExpiredSeries2 = "//div[3]/div[2]/div[2]/div[2]/div[2]";
	public String vfyExpiredSeries3 = "//td[2]/div/div/div/div/div/div[3]/div/div/div/div[3]/div[2]/div/div";

	
	public String vfyEndDateExpiredSeries = "//div[3]/div[3]/div";
	public String vfyEndDatePayerName = "//div[3]/div[3]/div[2]/div[2]/div";
	public String vfyEndDatePayerName1 = "//div[3]/div[3]/div[2]/div[2]/div[2]/div";
	
	
	
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
	
	public String  dragSource =    "//div[3]/div/table/tbody/tr[1]/td/div";
	public String  dragDestination =  "//div[3]/div/table/tbody/tr[2]/td/div";
	
	public String  txtRelationAddr1 =  "addr1";
	public String  txtRelationAddr2 =  "addr2";
	
	public String  ajxRelationState =  "stateSuggestBoxsuggestBox";
	public String  ajxRelationcountry =  "countrySuggestBoxsuggestBox";
	public String  ajxRelationSex =  "sexSuggestBoxsuggestBox";
	
	public String  txtRelationDobOther =  "xpath=(//input[@type='text'])[37]";	
	public String  txtRelationDobMedical =  "xpath=(//input[@type='text'])[33]";	
			
	public String  txtRelationZip =  "zip";
	
	public String vfyEditPatientInfo  = "//form/div/div[2]";	
	
	//Encounter Template
	public String lnkQuickLink ="link=Quick actions";
	public String lnkClinicalSettingsLink = "css=#clinicalSettingsAction > span.actionItemSpan";
	public String lnkEncounterTemplate="!encounterTemplates";
	public String btnAddNew="addNew";
	public String lnkStartBlank="//div[@class='wizard-options-wrapper']/div[1]/a";
	public String lnkDeleteEncounterTemplate="//a[contains(text(),'Delete')]";
	public String btnYesButton="yesButton";
	public String txtTemplateName="css=input.gwt-TextBox";
	public String txtAreaTemplateDescription="css=textarea.text-area";
	public String btnSaveEncounterTemp="xpath=(//button[@type='button'])[2]";
	public String ajxSuggestBox="suggestBox";
	public String lblEncounterTemplateSummary="//div[@class='paddingBottom25 cellTableLastColumnAlignTop']/div[3]";
	public String lnkEdit="link=Edit";
	
	//timeLine 
	public String btnNoteSave="saveButton";
	public String lnkViewRegister="css=span.topMenuItemSpan.light";
	public String lblEncounterChoosePanel="css=div.pickupEncounterPanel.zIndex1000";
	public String btnSign="sign";
	public String lnkTimeLine="!chartTimeline";
	public String txtlastName="lastName";
	public String txtFirstName="firstName";
	public String ajxStatus="statusSuggestBoxsuggestBox";
	public String btnBackButton="backButton";
	public String lnlPrintsend="link=Print/Send";
	
	public String lnkRegisterPatient="css=span.actionItemSpan";
	public String lnkQuickAction="link=Quick actions";
	public String lnkPatientOption="link=Patient Options";
	public String lnkChartSummary="css=span.topMenuItemSpan.light";
	public String lnkFamilyHistory="link=Family History";
	public String lnkMedicationTab="!chartMedications";
	
	public String lnkInjection = "link=Injections";
	public String btnInjectionEdit="//div[@id='InjectionList']/table/tbody/tr/td[3]/div/a";
	public String chkshowAllRecords = "includeInactivecheckbox";
	
	public String txtdeleteReason = "deleteReason";
	public String btnDeleteReason = "//button[@id='deleteReason']";
	public String txtQuickinjection = "injectionQuicklistBox";
	public String txtLotNo="lotNumberBox";
	public String txtexpiryDate = "expiryDate";
	public String txtDosage = "dosageQuantity";
	public String txtadminOn = "administeredOn";
	public String ajxDosageUnit = "dosageUnitsuggestBox";
	public String btnAdd="add";
	
	//ProcedureaddVitalsForCds
	public String summary_link = "!chartSummary";
	public String procedureLink = "link=Surgical History";
	public String proName = "css=div.controlsNoMargin > input.gwt-TextBox";
	public String showMoreDetails_Procedure = "css=div.inlineBlock.pointer > div.inlineBlock.light";
	public String onSetDate = "onsetDate";
	public String cpt = "cptSuggestBox0-1suggestBox";
	public String comment = "summaryComment";
	public String consentCheckBox_procedure = "consentCheckBoxcheckbox";
	public String consent_procedure  = "consentSuggestBoxsuggestBox";
	public String add = "add";
	public String procedureDate = "procedureDate";
	public String cancel_procedure = "//div[3]/button";
	public String save_procedure = "xpath=(//button[@id='save'])[2]";
	public String deleteReason = "deleteReason";
	public String deleteButton = "//button[@id='deleteReason']";
	public String yesButton = "yesButton";
	public String save = "save";
	public String BeginEncounter = "//div[3]/button";
	public String action = "actionAnchorEncounter";
	public String save_button = "css=span.topMenuItemSpan.light";
	
	//Vitals
	public String lnkVitals="link=VITALS";
	public String lnkMoreDetails="vitalsMoreDetails";
	public String btnadd="add";
	public String ajxHeight="heightSuggestBoxsuggestBox";
	public String ajxWeight="weightSuggestBoxsuggestBox";
	public String ajxlimb="limbSuggestBoxsuggestBox";
	public String ajxCuffSize="cuffSizeSuggestBoxsuggestBox";
	public String ajxdescription="descriptionSuggestBoxsuggestBox";
	public String ajxrhythm="rhythmSuggestBoxsuggestBox";
	public String ajxWaist="waistSuggestBoxsuggestBox";
	public String ajxTemp = "temperatureUnitSuggestBoxsuggestBox";
	public String ajxTempLocation= "temperatureLocationSuggestBoxsuggestBox";
	public String ajxbloodSugar="bloodSugarUnitSuggestBoxsuggestBox";
	public String ajxRespiratory ="respiratoryRateDescriptionSuggestBoxsuggestBox";
	public String ajxpefrDescription="pefrDescriptionSuggestBoxsuggestBox";
	public String txtHight="height";
	public String txtHeightInFeet="heightFeet1";
	public String txtHeightInCm="heightFeet2";
	public String txtWeight="weight";
	public String txtSystolic="systolic";
	public String txtDiastolic="diastolic";
	public String txtHeartRate= "heartRate";
	public String txtWaist="waist";
	public String txtTemp="temperature";
	public String txtbloodSugar="bloodSugar";
	public String txtRespiratory="respiratoryRate";
	public String txtOxygen="oxygenSaturation";
	public String txtPefr="pefr";

	
	
	
	
	
	
	/**
	 * goToAuditLog
	 * function go To AuditLog
	 
	 * @since  	    Jun	20, 2012
	 */	
	public boolean goToAuditLog(Selenium selenium){
		try{
			click(selenium,"back");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"link=Quick actions"),"could not click Quick Link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"securitySettingsAction"),"could not click security Settings", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"!audit"),"Could not click on Audit log link:", selenium, ClassName,MethodName);
			if(waitForElement(selenium,"filterUserssuggestBox",WAIT_TIME)){
				return true;
			}else
				return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * goToAuditLog
	 * function go To AuditLog
	 
	 * @since  	    Jun	20, 2012
	 */	
	public boolean goToAuditLogFromChartPreVisit(Selenium selenium){
		try{
			click(selenium,"back");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
		
			//code handle alert
			if(isElementPresent(selenium, "errorCloseButton"))
				assertTrue(click(selenium, "errorCloseButton"),"could not click error close", selenium, ClassName,MethodName);
			
			assertTrue(click(selenium,"link=Quick actions"),"could not click Quick Link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"css=#securitySettingsAction > span.actionItemSpan"),"could not click security Settings", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"!audit"),"Could not click on Audit log link:", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(waitForElement(selenium,"filterUserssuggestBox",WAIT_TIME)){
				return true;
			}else
				return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * auditLog
	 * function to auditLog
	 
	 * @since  	    July	27, 2012
	 */	
	
	public boolean auditLog(Selenium selenium,AuditLogLib auditData ,String account ){
		try{
			String date=null;
			String providerName = null;
			if(account.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat.format(cal.getTime());
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
			}
				
			String providerNameTemp= getText(selenium, lnkTopMenu);
			if(selenium.isTextPresent("FULL")){
				providerName= providerNameTemp.replaceAll(", FULL", "");
			}else if(selenium.isTextPresent("FrontDesk")){
				providerName= providerNameTemp.replaceAll(", FrontDesk", "");
			}else if(selenium.isTextPresent("Administrator")){
				providerName= providerNameTemp.replaceAll(", Administrator", "");
			}
			
			assertTrue(enterDate(selenium,"fromDateId",date),"Could not type the date;More Details"+auditData.toString(), selenium, ClassName,MethodName);
			
			selectValueFromAjaxList(selenium,"filterUserssuggestBox",providerName);
				
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"filterActivitysuggestBox",auditData.filterActivity);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"filterSectionssuggestBox",auditData.filterSection);
					
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"search"),"Could not click the search button;More Details:"+auditData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"filterUserssuggestBox")){
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + auditData.toString());
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * getOwnIP
	 * function to getOwnIP
	 * @since  	    July 27, 2012
	 */	
	
	public boolean getOwnIP(Selenium selenium,AuditLogLib auditData) throws Exception {
		try{
			InetAddress ownIP=InetAddress.getLocalHost();
			auditData.ipAddress=ownIP.getHostAddress();
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * verifyStoredValue
	 * function to verify Stored Value
	 * @throws UnknownHostException 
	 * @since  	    July 27, 2012
	 */	
	public boolean verifyStoredValue(Selenium selenium, AuditLogLib auditData,String account) {
		try{
			String systemDate=null;
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String PName = null;
			
			
			String providerName = null;
			
			if(selenium.isTextPresent("FULL")){
				PName= providerNameTemp.replaceAll(", FULL", "");
				String tempArray[]=PName.split(" ");
				providerName=tempArray[1]+", "+tempArray[0];
			}else if(selenium.isTextPresent("FrontDesk")){
				PName= providerNameTemp.replaceAll(", FrontDesk", "");
				String tempArray[]=PName.split(" ");
				providerName=tempArray[1]+", "+tempArray[0];
			}else if(selenium.isTextPresent("Administrator")){
				PName= providerNameTemp.replaceAll(", Administrator", "");
				String tempArray[]=PName.split(" ");
				providerName=tempArray[1]+", "+tempArray[0];
			}
			
			
			
			String LocationName = getText(selenium,"locationMenuHeader");
			if(account.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy");
				systemDate=DateFormat.format(cal.getTime());
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				systemDate=DateFormat.format(cal.getTime());
			}
			
			
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			int count=1;
			while(isElementPresent(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div")){
				if(getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div").contains(auditData.action)&&getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div/div/div[8]").equalsIgnoreCase(auditData.section)){
					click(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div");
					break;
				}
				count++;
				if(count>20)
					Assert.fail("Program details not found;More details:"+auditData.toString());
			}
			
				
			
			if(!getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div").trim().contains(systemDate.trim())){
				return false;
			}
			/*if(!getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.user.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
			if(!getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.patientName.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(LocationName.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerName.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(count>1){
				
				if(!getText(selenium,"xpath=(//div[@id='collapsableTitle']/div/div[8])["+count+"]").contains(auditData.section)){
					return false;
				}
				if(!getText(selenium,"xpath=(//div[@id='collapsableTitle']/div/div[9])["+count+"]").contains(auditData.action)){
					return false;
				}
				if(!getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(LocationName.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				if(!getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerName.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
			}if(count==1){
				
				/*if(!getText(selenium,"collapsableTitle").trim().contains(auditData.ipAddress)){
					return false;
				}*/
				if(!getText(selenium,"//div[@id='collapsableTitle']/div/div[6]").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.patientName.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				if(!getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(LocationName.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				if(!getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerName.trim().toLowerCase(new java.util.Locale("en","US")))){
					return false;
				}
				if(!getText(selenium,"//div[@id='collapsableTitle']/div/div[8]").contains(auditData.section)){
					return false;
				}
				if(!getText(selenium,"//div[@id='collapsableTitle']/div/div[9]").contains(auditData.action)){
					return false;
				}
			}
			
			
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		
	}
	/**
	 * verifyStoredValue
	 * function to verify Stored Value
	 * @throws UnknownHostException 
	 * @since  	    July 27, 2012
	 */	
	public boolean verifyStoredValuePrescribe(Selenium selenium, AuditLogLib auditData,String patId) {
		try{
			int count=1;
			while(isElementPresent(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div")){
				if(getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div").contains(auditData.action)&&getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div").contains(auditData.section)&&(!getText(selenium,"//tr["+count+"]/td/div/span/div/div/div[5]").isEmpty())){
					click(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div");
					break;
				}
				count++;
				if(count>20)
					Assert.fail("Program details not found;More details:"+auditData.toString());
			}
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			String systemDate=DateFormat.format(cal.getTime());
			System.out.println(systemDate);
			if(!getText(selenium,"collapsableTitle").trim().contains(systemDate.trim())){
				return false;
			}
			if(!getText(selenium,"collapsableTitle").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.user.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getText(selenium,"collapsableTitle").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.userName.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			/*if(!getText(selenium,"collapsableTitle").trim().contains(thisIP.getHostAddress())){
				return false;
			}*/
		/*	if(!getText(selenium,"collapsableTitle").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.practice.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
			
			if(count>1){
				if(auditData.testCaseId.equalsIgnoreCase("TC_ALPM_003")||auditData.testCaseId.equalsIgnoreCase("TC_ALPM_004"))
				{
					if(!getText(selenium,"xpath=(//div[@id='collapsableTitle']/div/div[7])["+count+"]").trim().contains(patId)){
						return false;
					}
				}else
				{
					if(!getText(selenium,"xpath=(//div[@id='collapsableTitle']/div/div[7])["+count+"]").trim().contains(auditData.patientId)){
						return false;
					}
				}
				/*if(!getText(selenium,"xpath=(//div[@id='collapsableTitle']/div/div[5])["+count+"]").contains(thisIP.getHostAddress())){
					return false;
				}*/
				if(!getText(selenium,"xpath=(//div[@id='collapsableTitle']/div/div[6])["+count+"]").contains(auditData.patientName)){
					return false;
				}
				
				if(!getText(selenium,"xpath=(//div[@id='collapsableTitle']/div/div[8])["+count+"]").contains(auditData.section)){
					return false;
				}
				if(!getText(selenium,"xpath=(//div[@id='collapsableTitle']/div/div[9])["+count+"]").contains(auditData.action)){
					return false;
				}
			}if(count==1){
				if(!getText(selenium,"//div[@id='collapsableTitle']/div/div[7]").trim().contains(auditData.patientId)){
					return false;
				}
				/*if(!getText(selenium,"collapsableTitle").trim().contains(auditData.ipAddress)){
					return false;
				}*/
				if(!getText(selenium,"//div[@id='collapsableTitle']/div/div[6]").contains(auditData.patientName)){
					return false;
				}
				
				if(!getText(selenium,"//div[@id='collapsableTitle']/div/div[8]").contains(auditData.section)){
					return false;
				}
				if(!getText(selenium,"//div[@id='collapsableTitle']/div/div[9]").contains(auditData.action)){
					return false;
				}
			}
			
			
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		
	}
	/**
	 * createProgram
	 * function to create a Program
	 
	 * @since  	     Feb 21, 2012
	 */	
	public boolean createProgram(Selenium selenium, AuditLogLib programData){
		
		try{		
			selectValueFromAjaxList(selenium,"suggestBox", programData.programId);
			waitForPageLoad(selenium);
			assertTrue(enterDate(selenium,"fromDate", programData.fromdate),"Could not enter date; More Details :" + programData.toString(), selenium, ClassName,MethodName);
			assertTrue(enterDate(selenium,"toDate",programData.todate),"Could not enter the date; More Details :" + programData.toString(), selenium, ClassName,MethodName);
			assertTrue(enterDate(selenium,"priorState",programData.priorstate),"Could not enter the Prior State value; More Details :" + programData.toString(), selenium, ClassName,MethodName);
			assertTrue(enterDate(selenium,"outcome",programData.outcome),"Could not enter the Outcome value; More Details :" + programData.toString(), selenium, ClassName,MethodName);
			if(programData.testCaseId.equals("TC_P_005")){
				selectValueFromAjaxList(selenium,"referralSourcesuggestBox", programData.refFrom);
				selectValueFromAjaxList(selenium,"referredTosuggestBox", programData.referredTo);
				assertTrue(enterDate(selenium,"referralDate", programData.refDate),"Could not enter referral date; More Details :" + programData.toString(), selenium, ClassName,MethodName);
			}
			assertTrue(click(selenium,"save"),"Could not click Save Button; More Details :" + programData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "PatientContactList")){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + programData.toString());		
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * adminNotes
	 * function to adminNotes
	 
	 * @since  	    July 27, 2012
	 */	
	public boolean adminNotes (Selenium selenium, AuditLogLib notesData){
		try{
			assertTrue(click(selenium,"!enterpriseID"),"Could not click on Identifier Group link:" + notesData .toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			type(selenium,"searchTextBox",notesData.notesValue);
			click(selenium,"css=span.buttons.searchButton > button.gwt-Button");
			waitForPageLoad(selenium);
			click(selenium,"link=Delete");
			waitForPageLoad(selenium);
			click(selenium,"yesButton");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"addEnterpriseID"),"Could not click on Add Identifier Group link:" + notesData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"idTypeSuggestBoxsuggestBox",notesData.notesType);
			waitForPageLoad(selenium);
			type(selenium,"css=input.gwt-TextBox",notesData.notesValue);
			click(selenium,"save");
			if(isElementPresent(selenium,"css=span.title")){
				return true;
			}else{
				return false;
			}
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
	 * goToEnterPriseVarible
	 * function go To EnterPriseVarible
	 * @since  	    Jun	20, 2012
	 */	
	public boolean goToEnterPriseVarible(Selenium selenium){
		try{
			assertTrue(click(selenium,"systemSettings"),"could not click security Settings", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"!enterpriseID"),"Could not click on Audit log link:", selenium, ClassName,MethodName);
			if(waitForElement(selenium,"searchTextBox",WAIT_TIME)){
				return true;
			}else
				return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * createNotes
	 * function to create a Notes
	 * @since  	     Feb 21, 2012
	 */	
	public boolean createNotes(Selenium selenium,AuditLogLib noteData){
		try{
			waitForPageLoad(selenium);
			assertTrue(enterDate(selenium,"noteDate",noteData.notedate),"Could not enter date; More Details:"+noteData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"suggestBox",noteData.category);
			assertTrue(type(selenium,"note",noteData.patientnote), "Could not type patient note; More Details :"+noteData.toString(), selenium, ClassName,MethodName);
			assertTrue(click(selenium,"save"),"Could not click save button; More Details:"+noteData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=span.title")){
				return true;
			}else{
				return false;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + noteData.toString());		
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * deleteAllCases
	 * function to create a Case
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllCases(Selenium selenium){
		boolean caseDeleted = true;
		int caseCount = 0;
		try{
			waitForElement(selenium, "//div[@id='PatientCaseList']/table/tbody/tr/td[3]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='PatientCaseList']/table/tbody/tr/td[3]/div/a") > 0){
				caseCount = (Integer) selenium.getXpathCount("//div[@id='PatientCaseList']/table/tbody/tr/td[3]/div/a");
				assertTrue(click(selenium,"//div[@id='PatientCaseList']/table/tbody/tr/td[3]/div/a"),"click patient case list", selenium, ClassName,MethodName);
				click(selenium,"yesButton");
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount("//div[@id='PatientCaseList']/table/tbody/tr/td[3]/div/a")){
					caseDeleted = false;
					break;
				}
			}
			return caseDeleted;
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
	 * createCases
	 * function to create a Case
	 * @since  	     July 29, 2012
	 */	

	public boolean createCases(Selenium selenium, AuditLogLib casesData){
		
	try{		
		
		assertTrue(type(selenium,"description",casesData.description),"Could not enter Description ; More Details :"+casesData.toString(), selenium, ClassName,MethodName);
		selectValueFromAjaxList(selenium,"programIDSuggestBoxsuggestBox", casesData.program);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,"reason",casesData.reason),"Could not enter Reason ; More Details :"+casesData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"referralList",casesData.referral);
			//Assert.assertTrue(type(selenium,"icdCode",casesData.icecode),"Could not icecode; More Details :" + casesData.toString());
			assertTrue(enterDate(selenium,"startDate",casesData.startdate),"Could not enter the date; More Details :" + casesData.toString(), selenium, ClassName,MethodName);
			click(selenium,"addCaseDates");
			if (isElementPresent(selenium, "dateTypeSuggestBoxsuggestBox")){
				selectValueFromAjaxList(selenium,"dateTypeSuggestBoxsuggestBox", casesData.datetype1);
				click(selenium,"//body/div[3]/div/div/div/div/div");
				assertTrue(enterDate(selenium,"date",casesData.date1),"Could not enter the date; More Details :" + casesData.toString(), selenium, ClassName,MethodName);
			}
			
			assertTrue(click(selenium,"save"),"Could not click Save Button; More Details :" + casesData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, "css=span.title")){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + casesData.toString());		
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * editCases
	 * function to create a Case
	 * @since  	     July 29, 2012
	 */	

	public boolean editCases(Selenium selenium, AuditLogLib casesData){
		try{
		waitForPageLoad(selenium);
		assertTrue(type(selenium,"description",casesData.descriptionEdit),"Could not type patient cases; More Detils"+casesData.toString(), selenium, ClassName,MethodName);
		selectValueFromAjaxList(selenium,"programIDSuggestBoxsuggestBox", casesData.programEdit);
		
		assertTrue(type(selenium,"reason",casesData.reasonEdit),"Could not enter Reason ; More Details :"+casesData.toString(), selenium, ClassName,MethodName);
		selectValueFromAjaxList(selenium,"referralList",casesData.referral);
		//Assert.assertTrue(type(selenium,"icdCode",casesData.icecode),"Could not icecode; More Details :" + casesData.toString());
		assertTrue(enterDate(selenium,"startDate",casesData.startDateEdit),"Could not enter the date; More Details :" + casesData.toString(), selenium, ClassName,MethodName);
		selectValueFromAjaxList(selenium,"caseStatusSuggestBoxsuggestBox",casesData.caseStatusEdit);
		waitForPageLoad(selenium);
		assertTrue(enterDate(selenium,"terminationEndDate",casesData.terminationDateEdit),"Could not enter the date; More Details :" + casesData.toString(), selenium, ClassName,MethodName);
		assertTrue(type(selenium,"terminationReason",casesData.terminationReasonEdit),"Could not enter the Reason ; More Details :"+casesData.toString(), selenium, ClassName,MethodName);
		click(selenium,"addCaseDates");
		if (!casesData.dateType1Edit.equals("")){
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"dateTypeSuggestBoxsuggestBox", casesData.dateType1Edit);
			waitForPageLoad(selenium);
			assertTrue(enterDate(selenium,"date",casesData.date1Edit),"Could not enter the date; More Details :" + casesData.toString(), selenium, ClassName,MethodName);
		}
		assertTrue(click(selenium,"save"),"Could not click Save Button; More Details :" + casesData.toString(), selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,"css=span.title"))
			return true;
		else
			return false;
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + casesData.toString());		
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * createReferral
	 * function to create a Referral
	 * @since  	    july 31, 2012
	 */	
	public boolean createReferral(Selenium selenium, AuditLogLib refData){
		
		try{		
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"referralTypesuggestBox", refData.refType);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"referredFromsuggestBox", refData.refBy);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"addresssuggestBox");
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"addresssuggestBox", refData.addr);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"referredTosuggestBox", refData.refTo);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"referralSpecialtysuggestBox", refData.speciality);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"referralDiagnosessuggestBox", refData.diagCode);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,"referralReason",refData.referralReason),"Could not enter the referral Reason; More Details :" + refData.toString(), selenium, ClassName,MethodName);
			assertTrue(enterDate(selenium,"referralDate", refData.referralDate),"Could not enter referral date; More Details :" + refData.toString(), selenium, ClassName,MethodName);
			assertTrue(enterDate(selenium,"referralEndDate",refData.referralEndDate),"Could not enter the referralEndDate; More Details :" + refData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"referralComments",refData.refComments),"Could not enter referral Comments; More Details :" + refData.toString(), selenium, ClassName,MethodName);
			assertTrue(click(selenium,"addAuthorizationButton"),"Could not click on add Authorization Button; More Details :" + refData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"payerSuggestBox1suggestBox", refData.payer);
			assertTrue(type(selenium,"numVisits1",refData.numVisits1),"Could not enter numVisits1; More Details :" + refData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"numVisitTypeSuggestBox1suggestBox",refData.numVisitType),"Could not enter numVisits Type; More Details :" + refData.toString(), selenium, ClassName,MethodName);
			waitForElementToEnable(selenium,"requestDate1");
			waitForPageLoad(selenium);
			click(selenium,"requestDate1");
			assertTrue(enterDate(selenium,"requestDate1",refData.requestDate2),"Could not enter the request Date; More Details :" + refData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"approvalDate1");
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,"approvalDate1"), "approval date not present",selenium, ClassName,MethodName);
			assertTrue(enterDate(selenium,"approvalDate1",refData.approvalDate2),"Could not enter the approvalDate; More Details :" + refData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"authorizationNum1",refData.authorizationNum2),"Could not enter authorizationNum; More Details :" + refData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"numAuthorizedVisits1",refData.numAuthorizedVisits2),"Could not enter numAuthorizedVisits; More Details :" + refData.toString(), selenium, ClassName,MethodName);
			assertTrue(enterDate(selenium,"startDate1",refData.startDate2),"Could not enter the start Date; More Details :" + refData.toString(), selenium, ClassName,MethodName);
			assertTrue(enterDate(selenium,"endDate1",refData.endDate2),"Could not enter the end Date; More Details :" + refData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"cptSuggestBox1-1suggestBox", refData.cptSuggestBox2);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"save"),"Could not click Save Button; More Details :" + refData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "!patientReferralList")){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + refData.toString());		
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * createContact
	 * function to create a Contact
	 * @since  	     Feb 22, 2012
	 */	
	public boolean createContact(Selenium selenium, AuditLogLib ContactData){
		
		try{		
			
			assertTrue(check(selenium, "subsDecisionMarkercheckbox"), "Could not check the contact type, " + ContactData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium, "relationshipsuggestBox", ContactData.relationship);
			selectValueFromAjaxList(selenium, "titlesuggestBox",ContactData.title);
			assertTrue(type(selenium, "lastName", ContactData.lastName),"Could not enter Last Name; More Details:" + ContactData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium, "firstName", ContactData.firstName),"Could not enter First Name; More Details:" + ContactData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"suffixsuggestBox",ContactData.suffix);
			assertTrue(type(selenium, "email", ContactData.email),"Could not enter Email; More Details:" + ContactData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium, "languagesuggestBox",ContactData.languageSpoken);
			assertTrue(type(selenium, "comments", ContactData.comments), "Could not Enter comments, Expected value to be Selected" + ContactData.comments, selenium, ClassName,MethodName);
			assertTrue(type(selenium, "contactAddr1", ContactData.residentialAddrStreet1),"Could not enter Residential Address; More Details:" + ContactData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium, "contactAddr2", ContactData.residentialAddrStreet2),"Could not enter Residential Address; More Details:" + ContactData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium, "contactCity", ContactData.residentialAddrcity),"Could not enter City; More Details:" + ContactData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium, "contactStatesuggestBox",ContactData.residentialAddrstate);
			assertTrue(type(selenium, "contactZip", ContactData.residentialAddrzipCode),"Could not enter Zip; More Details:" + ContactData.toString(), selenium, ClassName,MethodName);
			selenium.keyPress("contactCountrysuggestBox", "\\9");
			click(selenium,"yesButton");
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"contactAddr1");
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"contactAddr2");
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"contactCity");
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"contactStatesuggestBox");
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium,"contactCountrysuggestBox");
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, "commType1suggestBox",ContactData.telephoneType1);
			assertTrue(type(selenium, "primaryPhone", ContactData.telephoneNo1),"Could not enter phone number; More Details:" + ContactData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium, "primaryPhoneExt", ContactData.telephoneextnNo1),"Could not enter extn number; More Details:" + ContactData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium, "commType2suggestBox",ContactData.telephoneType2);
			assertTrue(type(selenium, "secondaryPhone", ContactData.telephoneNo2),"Could not enter Phone number; More Details:" + ContactData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium, "secondaryPhoneExt", ContactData.telephoneextnNo2),"Could not enter extn number; More Details:" + ContactData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium, "commType3suggestBox",ContactData.telephoneType3);
			assertTrue(type(selenium, "tertiaryPhone", ContactData.telephoneNo3),"Could not enter Fax number; More Details:" + ContactData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium, "tertiaryPhoneExt", ContactData.telephoneextnNo3),"Could not enter extn number; More Details:" + ContactData.toString(), selenium, ClassName,MethodName);
			assertTrue(click(selenium, "save"),"Could not find save button; More Details:" + ContactData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "css=span.title")){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + ContactData.toString());		
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * editUserForAuditLog
	 * function to edit User For AuditLog
	 * @since  	     Feb 09, 2012
	 */	

	public boolean editUserForAuditLog(Selenium selenium,AuditLogLib userData){
		try{
			
			assertTrue(type(selenium,"lastName",userData.lastName),"Could not type a last name", selenium, ClassName,MethodName);
			assertTrue(type(selenium,"firstName",userData.firstName),"Could not type a first name" + userData .toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"userName",userData.userName),"Could not type a user name" + userData .toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"externalEmrsuggestBox",userData.externalEmr);
			assertTrue(type(selenium,"credentials",userData.credentials),"Could not type a credential" + userData .toString(), selenium, ClassName,MethodName);
			if(userData.resetPswCheck.equalsIgnoreCase("Yes")){
				assertTrue(click(selenium,"resetPasswordcheckbox"),"could not click reset password", selenium, ClassName,MethodName);
				
				assertTrue(type(selenium,"password",userData.resetPassword),"Could not type a password" + userData .toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,"confirmPassword",userData.changedPassword),"Could not type confirmation password" + userData .toString(), selenium, ClassName,MethodName);
			}
			assertTrue(click(selenium,"save"),"Could not click the save Button;More Deatils:"+userData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			click(selenium,"!adminOrgStructureLists");
			if(isElementPresent(selenium,"//div[3]/div[2]/div/div/div/span")){
				return true;
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
			return false;
		}
	}
	
	/**
	 * createEnterPriseForConsents
	 * function to Create EnterPrise For Consents
	 * @since  	    sep 21, 2012
	 */	
	public boolean createEnterPriseForConsents(Selenium selenium,AuditLogLib epData){
		boolean returnValue = false;
		try{
			assertTrue(click(selenium,"!enterpriseID"),"Could not click on enterPrise Link:" + epData .toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			type(selenium,"searchTextBox",epData.consentType);
			click(selenium,"searchButtonId");
			waitForPageLoad(selenium);
			click(selenium,"link=Delete");
			waitForPageLoad(selenium);
			click(selenium,"yesButton");
			assertTrue(click(selenium,"addEnterpriseID"),"Could not click on Add Identifier Group link:" + epData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"idTypeSuggestBoxsuggestBox",epData.consentValue);
			waitForPageLoad(selenium);
			type(selenium,"variableValueTextFieldId",epData.consentType);
			click(selenium,"save");
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return returnValue;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * createSSConsents
	 * function to create SSConsents 
	 * @since  	     May 18, 2012
	 */	
	public boolean createSSConsents(Selenium selenium,AuditLogLib consentData){
		try{
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"consentTypeSuggestBoxsuggestBox",consentData.consentType);
			
			assertTrue(type(selenium,"consentName",consentData.consentName),"Could not enter the consent name; More Details :" + consentData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"validForNumber",consentData.validFor),"Could not the valid for; More Details"+consentData.toString(), selenium, ClassName,MethodName);
			select(selenium,"validForType",consentData.validForType);
			
			selectValueFromAjaxList(selenium,"restrictionLevelSuggestBoxsuggestBox",consentData.restrictionLevel);
			
			assertTrue(click(selenium,"save"),"Could not click save button; More details"+ consentData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"//td[2]/div/div/div/div")){
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
	 * CreateConsents
	 * function to create consents
	 * @since  	    Feb 21, 2012
	 */	
	public boolean createConsent(Selenium selenium, AuditLogLib consentData){
		boolean returnValue = false;
		try{	
					
			selectValueFromAjaxList(selenium,"consentTypesuggestBox", consentData.consentType);
			
			selectValueFromAjaxList(selenium,"consentNamesuggestBox", consentData.consentName);
			
			selectValueFromAjaxList(selenium,"statussuggestBox", consentData.status);
			
			if (isElementPresent(selenium, "reasonForInactivationsuggestBox"))
			selectValueFromAjaxList(selenium,"reasonForInactivationsuggestBox",consentData.inactivation);
			assertTrue(enterDate(selenium,"dateSigned", consentData.dateSigned),"Could not enter date; More Details :" + consentData.toString(), selenium, ClassName,MethodName);
			
			 if(consentData.signedBy.equals("Substitution Decision Maker")){
				assertTrue(click(selenium,"//span[2]/input"),"Could not select the susbstitution maker; More Details :" + consentData.toString(), selenium, ClassName,MethodName);
				waitForElementToEnable(selenium,"relationshipsuggestBox");
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"relationshipsuggestBox",consentData.relationship);
			
				assertTrue(type(selenium,"firstName",consentData.firstName),"Could not enter the first name; More Details :" + consentData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,"lastName",consentData.lastName),"Could not enter last name; More Details :" + consentData.toString(), selenium, ClassName,MethodName);
				assertTrue(click(selenium,"save"),"Could not click Save Button; More Details :" + consentData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			 }
			 else
				 assertTrue(click(selenium,"save"),"Could not click Save Button; More Details :" + consentData.toString(), selenium, ClassName,MethodName);
				 waitForPageLoad(selenium);
				 
			if(isElementPresent(selenium, "css=span.title")){
				return true;
			}else{
				return false;
			}
		}
		catch(RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + consentData.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}
	/**
	 * createIdGroup
	 * function to create a createIdGroup
	 * @since  	     Feb 22, 2012
	 */	
	
	public boolean createIdGroup(Selenium selenium,AuditLogLib identifierData){
		boolean caseDeleted = true;
		try{
			assertTrue(click(selenium,"!adminIdentifierGroupList"),"Could not click on Identifier Group link:" + identifierData .toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			int caseCount = 0;
			
				
				waitForElement(selenium, "//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a", WAIT_TIME);
				while((Integer) selenium.getXpathCount("//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a") > 0){
					caseCount = (Integer) selenium.getXpathCount("//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a");
					assertTrue(click(selenium,"//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a"),"could not clic admin identifier group", selenium, ClassName,MethodName);
					assertTrue(click(selenium,"yesButton"),"could not click yes button", selenium, ClassName,MethodName);
					waitForPageLoad(selenium);
					if(caseCount == (Integer) selenium.getXpathCount("//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a")){
						caseDeleted = false;
						break;
					}
				}
			assertTrue(click(selenium,"addIdentifierGroup"),"Could not click on Add Identifier Group link:" + identifierData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			select(selenium,"groupFor",identifierData.groupFor);
			assertTrue(type(selenium,"group",identifierData.groupName),"Could not enter the group;More details:"+identifierData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"description",identifierData.groupDescription),"Could not enter the group decription;More details:"+identifierData.toString(), selenium, ClassName,MethodName);
			if(identifierData.groupDefault.equals("yes")||identifierData.groupDefault.equals("Default")){
				assertTrue(click(selenium,"//span/input"),"Could not click the check box"+identifierData.toString(), selenium, ClassName,MethodName);
			}
			assertTrue(click(selenium,"save"),"Could not click save button; More details"+ identifierData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"addIdentifierGroup")){
				caseDeleted = true;
			}else{
				caseDeleted = false;
			} 
		}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
				return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return caseDeleted;
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
			
			waitForElement(selenium, "//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a") > 0){
				caseCount = (Integer) selenium.getXpathCount("//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a");
				assertTrue(click(selenium,"//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a"),"could not click admin identifier group list", selenium, ClassName,MethodName);
				assertTrue(click(selenium,"yesButton"),"could not click yes button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount("//div[@id='AdminIdentifierGroupList']/table/tbody/tr/td[3]/div/a")){
					caseDeleted = false;
					break;
				}
			}
			return caseDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean createIdType(Selenium selenium,AuditLogLib identifierData){
		boolean caseDeleted = true;
		int caseCount = 0;
		try{
			assertTrue(click(selenium,"!adminIdentifierTypeList"),"Could not click on Identifier Group link:" + identifierData .toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForElement(selenium, "//div[@id='AdminIdentifierTypeList']/table/tbody/tr/td[3]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='AdminIdentifierTypeList']/table/tbody/tr/td[3]/div/a") > 0){
				caseCount = (Integer) selenium.getXpathCount("//div[@id='AdminIdentifierTypeList']/table/tbody/tr/td[3]/div/a");
				assertTrue(click(selenium,"//div[@id='AdminIdentifierTypeList']/table/tbody/tr/td[3]/div/a"),"could not click admin identifier group list", selenium, ClassName,MethodName);
				assertTrue(click(selenium,"yesButton"),"could not click yes button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount("//div[@id='AdminIdentifierTypeList']/table/tbody/tr/td[3]/div/a")){
					caseDeleted = false;
					break;
				}
			}
			assertTrue(click(selenium,"addIdentifierType"),"Could not click on Add Identifier Type link:" + identifierData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			select(selenium,"groupFor",identifierData.groupFor);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, "suggestBox",identifierData.idGroup);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,"type",identifierData.idType),"Could not enter the group;More details:"+identifierData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"description",identifierData.typeDescription),"Could not enter the group decription;More details:"+identifierData.toString(), selenium, ClassName,MethodName);
			if(!identifierData.freeTextRadio.equalsIgnoreCase("yes")){
				assertTrue(click(selenium,"//span[@id='definedList']/input"),"Could not click on radio button; More details"+ identifierData.toString(), selenium, ClassName,MethodName);
				assertTrue(click(selenium,"//span[@id='definedList']/input"),"Could not click on radio button; More details"+ identifierData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,"identifier",identifierData.identifier),"Could not enter the identifier;More details:"+identifierData.toString(), selenium, ClassName,MethodName);
				assertTrue(click(selenium,"addID"),"Could not click on add button; More details"+ identifierData.toString(), selenium, ClassName,MethodName);
			}
			type(selenium,"mask",identifierData.idTypeMask);
			if(identifierData.restricted.equals("Yes")){
				assertTrue(click(selenium,"//span[@id='restricted']/input"),"Could not click the reatractionlevel check box;More Details:"+identifierData.toString(), selenium, ClassName,MethodName);
			}
			if(identifierData.expDate.equals("Yes")){
				assertTrue(click(selenium,"//span[@id='endDateRequired']/input"),"Could not click the reatractionlevel check box;More Details:"+identifierData.toString(), selenium, ClassName,MethodName);
			}
			
			if(identifierData.typeDefault.equals("Yes")){
				assertTrue(click(selenium,"//span[@id='defaultType']/input"),"Could not click the defaultType check box;More Details:"+identifierData.toString(), selenium, ClassName,MethodName);
			}
			assertTrue(click(selenium,"save"),"Could not click save button; More details"+ identifierData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "addIdentifierType")){
				caseDeleted= true;
			}else{
				caseDeleted= false;
			}
		}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
				return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return caseDeleted;
	}
	
	
	/**
	 * deleteAllIdentifersGroup
	 * function to deleteAllIdentifiersGroup
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllIdentifiers(Selenium selenium){
		boolean caseDeleted = true;
		int caseCount = 0;
		try{
			
			waitForElement(selenium, "//div[@id='PatientExternalIDList']/table/tbody/tr/td[3]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='PatientExternalIDList']/table/tbody/tr/td[3]/div/a") > 0){
				caseCount = (Integer) selenium.getXpathCount("//div[@id='PatientExternalIDList']/table/tbody/tr/td[3]/div/a");
				assertTrue(click(selenium,"//div[@id='PatientExternalIDList']/table/tbody/tr/td[3]/div/a"),"could not click patient external ID list", selenium, ClassName,MethodName);
				assertTrue(click(selenium,"yesButton"),"could not click yes button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount("//div[@id='PatientExternalIDList']/table/tbody/tr/td[3]/div/a")){
					caseDeleted = false;
					break;
				}
			}
			return caseDeleted;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean createIdentifier(Selenium selenium,AuditLogLib identifierData){
		try{
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"groupsuggestBox",identifierData.groupName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"typesuggestBox",identifierData.idType);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,"idMask",identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString(), selenium, ClassName,MethodName);
			/*if(identifierData.idType.contains("TestType1")){
				assertTrue(type(selenium,"idMask",identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString());
			}*/
		    if(identifierData.type.equalsIgnoreCase("Driver's License Number")){
			assertTrue(type(selenium,"expirationdate",identifierData.expirationdate),"Could not enter Expire date ; More Details :"+identifierData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"idMask",identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString(), selenium, ClassName,MethodName);
		    }
			assertTrue(click(selenium,"save"),"could not click save button; More Details:"+identifierData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=span.title")){
				return true;
			}else{
				return false;
			} 
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				assertTrue(click(selenium,"//div[@id='PatientContactList']/table/tbody/tr/td[3]/div/a"),"could not click patient contact list", selenium, ClassName,MethodName);
				assertTrue(click(selenium,"yesButton"),"could not click yes button", selenium, ClassName,MethodName);
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * editIdentifiers
	 * function to edit Identifiers
	 * @since  	     Feb 22, 2012
	 */	
	
	public boolean editIdentifiers(Selenium selenium,AuditLogLib identifierData){
		try{
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"suggestBox",identifierData.groupName);
			selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[2]",identifierData.idType);
			if(identifierData.idType.contains("TestType1")){
				assertTrue(type(selenium,"idMask",identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString(), selenium, ClassName,MethodName);
			}
			    if(identifierData.idType.equalsIgnoreCase("TestType2")){
				
				assertTrue(type(selenium,"idMask",identifierData.value),"Could not enter mask ; More Details :"+identifierData.toString(), selenium, ClassName,MethodName);
				assertTrue(enterDate(selenium,"expirationdate",identifierData.expirationdate),"Could not enter Expire date ; More Details :"+identifierData.toString(), selenium, ClassName,MethodName);
			}
				assertTrue(click(selenium,"save"),"could not click save button; More Details:"+identifierData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			if(isElementPresent(selenium,"css=span.title")){
				return true;
			}else{
				return false;
			} 
		}catch(RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + identifierData.toString());		
				return false;
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		}
	/**
	 * createSocioEconomic
	 * function to create a Socio Economic
	 * @throws IOException 
	 * @since  	     Feb 22, 2012
	 */	
	public boolean createSocioEconomic(Selenium selenium, AuditLogLib socioEconomicData) throws IOException{
		
		try{	
			selectValueFromAjaxList(selenium,"racesuggestBox",socioEconomicData.race);
			selectValueFromAjaxList(selenium,"ethnicitysuggestBox",socioEconomicData.ethnicity);
			selectValueFromAjaxList(selenium,"religionsuggestBox",socioEconomicData.religion);
			selectValueFromAjaxList(selenium,"citizenshipsuggestBox",socioEconomicData.citizenship);
			selectValueFromAjaxList(selenium,"countrysuggestBox",socioEconomicData.countryPanel);
			selectValueFromAjaxList(selenium,"languageSpokensuggestBox",socioEconomicData.languagespoken);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			assertTrue(enterDate(selenium,"dateOfArrival",socioEconomicData.arrivalDate),"could not enter the date; More Details :"+socioEconomicData.toString(),selenium,ClassName,MethodName);
			selectValueFromAjaxList(selenium,"spokenLanguagesuggestBox",socioEconomicData.languagePanel);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			if(socioEconomicData.interpreterrequired.equalsIgnoreCase("Yes")){
				if(isChecked(selenium, "interpreterRequiredcheckbox")){
					assertTrue(type(selenium,"interpreterName",socioEconomicData.interpreter),"Could not type interpreter; More Details"+socioEconomicData.toString(), selenium, ClassName,MethodName);
				}else{
					assertTrue(click(selenium,"interpreterRequiredcheckbox"),"Could not check the Interpreter check box, Expected value for check box:"+socioEconomicData.interpreterrequired, selenium, ClassName,MethodName);
					assertTrue(type(selenium,"interpreterName",socioEconomicData.interpreter),"Could not type interpreter; More Details"+socioEconomicData.toString(), selenium, ClassName,MethodName);
				}
			}else if(socioEconomicData.interpreterrequired.equalsIgnoreCase("No")){
				if(isChecked(selenium, "interpreterRequiredcheckbox")){
					assertTrue(click(selenium,"interpreterRequiredcheckbox"),"Could not check the Interpreter check box, Expected value for check box:"+socioEconomicData.interpreterrequired, selenium, ClassName,MethodName);
				}
			}
			selectValueFromAjaxList(selenium,"parentEthnicitysuggestBox",socioEconomicData.parentEthnicityPanel);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selectValueFromAjaxList(selenium,"livingArrangementsuggestBox",socioEconomicData.livingArrangement);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selectValueFromAjaxList(selenium,"studentStatussuggestBox",socioEconomicData.studentStatus);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selectValueFromAjaxList(selenium,"educationLevelsuggestBox",socioEconomicData.educationLevel);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			selectValueFromAjaxList(selenium,"householdIncomesuggestBox",socioEconomicData.householdIncome);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			assertTrue(type(selenium,"numPeopleText",socioEconomicData.numPeopleText),"Could not type number of people; More Details"+socioEconomicData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"householdCompositionsuggestBox",socioEconomicData.householdComposition);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			assertTrue(click(selenium,"homelessIndCheckboxcheckbox"),"Could not check the Homeless Indicator, Expected value for check box:"+socioEconomicData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"homelesssuggestBox",socioEconomicData.homelessStatus);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			assertTrue(click(selenium,"ssicheckbox"),"Could not check the ssi element, Expected value for check box:"+socioEconomicData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"employmentsuggestBox",socioEconomicData.employmentStatus);
			click(selenium,"//body/div[4]/div/div/div/div/div");
		    assertTrue(type(selenium,"comments",socioEconomicData.comments1),"Could not type comments; More Details"+socioEconomicData.toString(), selenium, ClassName,MethodName);
			assertTrue(click(selenium,"save"),"Could not click Validate Button; More Details"+socioEconomicData.toString(), selenium, ClassName,MethodName);

			if(isElementPresent(selenium, "!patientSocialHistory")){
				return true;
			}else{
				return false;
			}
		}
		catch (RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * addPractice
	 * function to create an Provider.
	 * @param 		selenium
	 * @param 		pracData
	 * @throws IOException 
	 * @since  	    July 30, 2012
	 */	
	public boolean addPractice(Selenium selenium,AuditLogLib pracData) throws IOException{
		try{
			
			assertTrue(type(selenium,"practiceName",pracData.practiceName),"Could not enter the practice name"+ pracData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"practiceCode",pracData.practiceCode),"Could not enter the practice code"+ pracData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"taxId",pracData.taxId),"Could not enter the tax id"+ pracData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"groupNpi",pracData.groupNpi),"Could not enter the tax id"+ pracData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"email",pracData.email),"Could not enter email"+ pracData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"commType1suggestBox",pracData.primaryPhoneType1);
			assertTrue(type(selenium,"primaryPhone",pracData.primaryPhoneNumber1),"Could not enter primary phone number"+ pracData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"primaryPhoneExtension",pracData.primaryPhoneExtn1),"Could not enter primary phone extension"+ pracData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"commType2suggestBox",pracData.primaryPhoneType2);
			assertTrue(type(selenium,"ohterPhone1",pracData.primaryPhoneNumber2),"Could not enter other phone type"+ pracData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"otherPhone1Extension",pracData.primaryPhoneExtn2),"Could not enter other phone extn"+ pracData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"commType3suggestBox",pracData.primaryPhoneType3);
			assertTrue(type(selenium,"otherPhone2",pracData.primaryPhoneNumber3),"Could not enter other phone"+ pracData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"otherPhone2Extension",pracData.primaryPhoneExtn3),"Could not enter other phone extn"+ pracData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"css=textarea.gwt-TextArea",pracData.comments),"Could not enter comments"+ pracData.toString(), selenium, ClassName,MethodName);
			
			assertTrue(type(selenium,"addr1",pracData.address1),"Could not enter address1"+ pracData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"addr2",pracData.address2),"Could not enter address2"+ pracData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"city",pracData.city),"Could not enter city"+ pracData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"stateSuggestBoxsuggestBox",pracData.state);
			assertTrue(type(selenium,"zip",pracData.zipcode),"Could not enter zipcode"+ pracData.toString(), selenium, ClassName,MethodName);
			click(selenium,"noButton");
			selectValueFromAjaxList(selenium,"countrySuggestBoxsuggestBox",pracData.country);
			
			assertTrue(type(selenium,"billingAddr1",pracData.billlingaddress1),"Could not enter billing address1"+ pracData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"billingAddr2",pracData.billingaddress2),"Could not enter billing address2"+ pracData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"billingCity",pracData.billingcity),"Could not enter billing city"+ pracData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"billingStateSuggestBoxsuggestBox",pracData.billingstate);
			assertTrue(type(selenium,"billingZip",pracData.billingzipcode),"Could not enter billing zipcode"+ pracData.toString(), selenium, ClassName,MethodName);
			click(selenium,"noButton");
			selectValueFromAjaxList(selenium,"billingCountrySuggestBoxsuggestBox",pracData.billingcountry);
			assertTrue(click(selenium,"save"),"Could not click on save button"+ pracData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(pracData.testCaseId.contains("TC_CPR_003")){
				return true;
			}
			
			if(isElementPresent(selenium,"selectPeople")){
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
	 * createDepartment
	 * function to create department
	 * @param 		selenium
	 * @param 		deptData
	 * @since  	    August 23, 2012
	 */	
	public boolean createDepartment(Selenium selenium,AuditLogLib deptData,String uniqueName){
		boolean returnValue=false;
		try{
			assertTrue(type(selenium,"departmentName",deptData.department+uniqueName),"Could not type a program name" + deptData .toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"description",deptData.description),"Could not type a description" + deptData .toString(), selenium, ClassName,MethodName);
			assertTrue(click(selenium,"save"),"Could not click on save a program link:" + deptData .toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"addDepartment"))
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
	public boolean searchDepartment(Selenium selenium,AuditLogLib deptData,String uniqueName){
		boolean returnValue=true;
		try{
			int counter=1;
			while(getText(selenium,"//div[3]/div[2]/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(deptData.department+uniqueName.trim().toLowerCase(new java.util.Locale("en","US")))){
			if(getText(selenium,"//div[@id='departments']/table/tbody/tr["+counter+"]/td/div/span",10000).toLowerCase(new java.util.Locale("en","US")).trim().contains(deptData.department+uniqueName.trim().toLowerCase(new java.util.Locale("en","US")))){
				click(selenium,"//div[@id='departments']/table/tbody/tr["+counter+"]/td/div/span");
				waitForPageLoad(selenium);
				break;
			}else if(getText(selenium,"//div[@id='departments']/table/tbody/tr[3]/td/div/span",10000).toLowerCase(new java.util.Locale("en","US")).trim().contains(deptData.department+uniqueName.trim().toLowerCase(new java.util.Locale("en","US")))){
				click(selenium,"//div[@id='departments']/table/tbody/tr[3]/td/div/span");
				break;
			}
				counter++;
			}
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"departmentName"))
				returnValue=true;
			else
				returnValue=false;
			}catch(RuntimeException e){
			e.printStackTrace();
			
		}
		return returnValue;
	}

	
	/**
	 * createProgram
	 * function to navigate to Add provider page
	 * @param 		selenium
	 * @param 		programData
	 * @param		uniqueName
	 * @since  	    August 17, 2012
	 */	
	public boolean addProgram(Selenium selenium,AuditLogLib programData,String uniqueName){
		boolean returnValue=false;
		try{
			
			selectValueFromAjaxList(selenium,"suggestBox",programData.department);
			assertTrue(type(selenium,"programName",programData.program+uniqueName),"Could not type a program name" + programData .toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"description",programData.description),"Could not type a description" + programData .toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"save"),"Could not click on save a program link:" + programData .toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"edit"))
				returnValue=true;
			else
				Assert.fail("Program is not getting saved");
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
	 * createNewUser
	 * function to create New User
	 * @param 		selenium
	 * @param 		userData
	 * @param 		uniqueName
	 * @throws IOException 
	 * @since  	     May 17, 2012
	 */	
	public boolean createNewUser(Selenium selenium,AuditLogLib userData,String uniqueName) throws IOException{
		try{
			
			assertTrue(type(selenium,"lastName",userData.lastName+uniqueName),"Could not type a last name", selenium, ClassName,MethodName);
			assertTrue(type(selenium,"firstName",userData.firstName),"Could not type a first name" + userData .toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"userName",userData.userName1+uniqueName),"Could not type a user name" + userData .toString(), selenium, ClassName,MethodName);
			
			assertTrue(type(selenium,"credentials",userData.credentials),"Could not type a credential" + userData .toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"externalEmrsuggestBox",userData.externalEmr);
			assertTrue(type(selenium,"password",userData.password),"Could not type a password" + userData .toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"confirmPassword",userData.password),"Could not type confirmation password" + userData .toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"roleSuggestBox1suggestBox",userData.userRole);
			selectValueFromAjaxList(selenium,"//div[2]/div[2]/div/div/div/div/div/div/input",userData.practise);
			click(selenium,"//div[3]/div/div/div/div/div");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"save"),"Could not click on save a program link:" + userData .toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
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
	 * editUser
	 * function to create an User.
	 * @param 		selenium
	 * @param 		userData
	 * @throws IOException 
	 * @since  	     May 17, 2012
	 */	
	public boolean editUser(Selenium selenium,AuditLogLib userData,String uniqueName) throws IOException{
		try{
			
			assertTrue(type(selenium,"lastName",userData.lastName+uniqueName),"Could not type a last name", selenium, ClassName,MethodName);
			assertTrue(type(selenium,"firstName",userData.firstName),"Could not type a first name" + userData .toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"externalEmrsuggestBox",userData.externalEmr);			
			assertTrue(type(selenium,"credentials",userData.credentials),"Could not type a credential" + userData .toString(), selenium, ClassName,MethodName);
			
				assertTrue(click(selenium,"resetPasswordcheckbox"),"Could not click Reset Password", selenium, ClassName,MethodName);
				assertTrue(type(selenium,"password",userData.password),"Could not type a password" + userData .toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,"confirmPassword",userData.password),"Could not type confirmation password" + userData .toString(), selenium, ClassName,MethodName);
			
			selectValueFromAjaxList(selenium,"userRolesuggestBox",userData.userRole);
			//selectValueFromAjaxList(selenium,"suggestBox",userData.practise);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			String date=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			
			assertTrue(enterDate(selenium,"startDate",date),"Could not enter the start Date"+userData.toString(), selenium, ClassName,MethodName);
			click(selenium,"//div[3]/div/div/div/div/div");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"save"),"Could not click on save a program link:" + userData .toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"edit")){
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
	 * createExternalProvider
	 * function to create an External Provider
	 * @throws IOException 
	 * @since  	     May 17, 2012
	 */	
	public boolean createExternalProvider(Selenium selenium, AuditLogLib providerData,String uniqueNo) throws IOException {
		
		try{
			if(!(providerData.testCaseId.equals("TC_ALEP_002"))){
				assertTrue(type(selenium,"referringCode",providerData.referringCode+uniqueNo),"Could not type referring code; More Details"+providerData.toString(),selenium,ClassName,MethodName);
			}
			assertTrue(type(selenium,"lastName",providerData.lastName),"Could not type last name; More Details"+providerData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"firstName",providerData.firstName),"Could not type first name; More Details"+providerData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"mi",providerData.middleInitial),"Could not type middle initial; More Details"+providerData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"credentials",providerData.credentials),"Could not type credentials; More Details"+providerData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"stateLicNum",providerData.licenseNum),"Could not type license number; More Details"+providerData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"suggestBox",providerData.reportMethod);
			selectValueFromAjaxList(selenium,"specialtySuggestBoxIdsuggestBox",providerData.specialty);
			
			if(providerData.billingExclusionCheck.equals("yes")){
				if(!selenium.isChecked("billingExclusioncheckbox"))
					assertTrue(click(selenium,"billingExclusioncheckbox"),"Could not check billing Exclusion Checkbox; More Details"+providerData.toString(),selenium,ClassName,MethodName);
			}
			if(providerData.picosEnrolledCheck.equals("yes")){
				if(!selenium.isChecked("pecoscheckbox"))
					assertTrue(click(selenium,"pecoscheckbox"),"Could not check picos Enrolled Checkbox; More Details"+providerData.toString(),selenium,ClassName,MethodName);
			}
			
			assertTrue(type(selenium,"upin",providerData.upin),"Could not type upin; More Details"+providerData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"npi",providerData.npi),"Could not type npi; More Details"+providerData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"taxonomyCode",providerData.taxonomyCode),"Could not type taxonomy Code; More Details"+providerData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"comments",providerData.comments),"Could not type comments; More Details"+providerData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"//div[2]/div[2]/div/div/div/input",providerData.practiceName1),"Could not type practice name; More Details"+providerData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"//div[2]/div[2]/div/div[2]/div/input",providerData.epstreet11),"Could not type street name1; More Details"+providerData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"//div[2]/div[2]/div/div[3]/div/input",providerData.epstreet12),"Could not type street name2; More Details"+providerData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"//div[2]/div[2]/div/div[4]/div/input",providerData.epcity1),"Could not type city name; More Details"+providerData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"//div[5]/div/div/div/div/input",providerData.epstate1);
			assertTrue(type(selenium,"//div[2]/div[2]/div/div[6]/div/input",providerData.epzipcode1),"Could not type zipcode; More Details"+providerData.toString(), selenium, ClassName,MethodName);
			click(selenium,"noButton");
			selectValueFromAjaxList(selenium,"//div[2]/div[2]/div/div[7]/div/div/div/div/input",providerData.epcountry1);
			assertTrue(type(selenium,"//div[8]/div/input",providerData.epphone1),"Could not type phone number1; More Details"+providerData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"//input[2]",providerData.epextn1),"Could not type extn number1; More Details"+providerData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"//div[2]/div[2]/div/div[9]/div/input",providerData.epfax1),"Could not type fax number1; More Details"+providerData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"//div[2]/div[2]/div/div[10]/div/input",providerData.epemail1),"Could not type email; More Details"+providerData.toString(), selenium, ClassName,MethodName);
			if(providerData.testCaseId.equalsIgnoreCase("TC_EP_003")){
				assertTrue(click(selenium, "addAddressButton"), "Could not click Add Another Address Button"+providerData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,"//div[2]/div/div/input",providerData.practiceName2),"Could not type practice name; More Details"+providerData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,"//div[2]/div[2]/div/input",providerData.epstreet21),"Could not type street name1; More Details"+providerData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,"//div[2]/div[3]/div/input",providerData.epstreet22),"Could not type street name2; More Details"+providerData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,"//div[2]/div[4]/div/input",providerData.epcity2),"Could not type city name; More Details"+providerData.toString(), selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,"//div[2]/div[5]/div/div/div/div/input",providerData.epstate2);
				assertTrue(type(selenium,"//div[2]/div[6]/div/input",providerData.epzipcode2),"Could not type zipcode; More Details"+providerData.toString(), selenium, ClassName,MethodName);
				click(selenium,"noButton");
				selectValueFromAjaxList(selenium,"//div[2]/div[7]/div/div/div/div/input",providerData.epcountry2);
				assertTrue(type(selenium,"//div[2]/div[8]/div/input",providerData.epphone2),"Could not type phone number1; More Details"+providerData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,"//div[2]/div[8]/div/input[2]",providerData.epextn2),"Could not type extn number1; More Details"+providerData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,"//div[2]/div[9]/div/input",providerData.epfax2),"Could not type fax number1; More Details"+providerData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,"//div[2]/div[10]/div/input",providerData.epemail2),"Could not type email; More Details"+providerData.toString(), selenium, ClassName,MethodName);
				assertTrue(click(selenium, "//div[2]/span/div/span/span/input"),"Could not Check Primary Address Radio Button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, "//span[2]/button"), "Could not click delete button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,"save"),"Could not click save button; More details"+ providerData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
		    
			if(isElementPresent(selenium, "css=button.floatRight.marginBottom10")){
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
	 * deleteAllExternalProvider
	 * function to deleteAllExternalProvider
	 * @throws IOException 
	 * @since  	     APR 09, 2012
	 */
	public boolean deleteAllExternalProvider(Selenium selenium) throws IOException{
		boolean providerDeleted = true;
		int caseCount = 0;
		try{
			
			waitForElement(selenium, "//div[@id='AdminReferringProviderList']/table/tbody/tr/td[2]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='AdminReferringProviderList']/table/tbody/tr/td[2]/div/a") > 0){
				caseCount = (Integer) selenium.getXpathCount("//div[@id='AdminReferringProviderList']/table/tbody/tr/td[2]/div/a");
			    assertTrue(click(selenium,"//div[@id='AdminReferringProviderList']/table/tbody/tr/td[2]/div/a"),"Could not click Provider List",selenium, ClassName,MethodName);
				assertTrue(click(selenium,"yesButton"),"Could not click Yes Button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(caseCount == (Integer) selenium.getXpathCount("//div[@id='AdminReferringProviderList']/table/tbody/tr/td[2]/div/a")){
					providerDeleted = false;
					break;
				}
			}
			return providerDeleted;
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
				assertTrue(click(selenium,"!enterpriseID"),"Could not click on Identifier Group link:" + epData .toString(), selenium, ClassName,MethodName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitForPageLoad(selenium);
			type(selenium,"searchTextBox",epData.contactValue);
			click(selenium,"searchButtonId");
			waitForPageLoad(selenium);
			click(selenium,"link=Delete");
			
			click(selenium,"yesButton");
			try {
				assertTrue(click(selenium,"addEnterpriseID"),"Could not click on Add Identifier Group link:" + epData.toString(), selenium, ClassName,MethodName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"idTypeSuggestBoxsuggestBox",epData.contactType);
			
			type(selenium,"css=input.gwt-TextBox",epData.contactValue);
			click(selenium,"save");
			waitForPageLoad(selenium);
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
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
			waitForElement(selenium, "//div[@id='adminAddressBookListView']/table/tbody/tr/td[2]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='adminAddressBookListView']/table/tbody/tr/td[2]/div/a") > 0){
				caseCount = (Integer) selenium.getXpathCount("//div[@id='adminAddressBookListView']/table/tbody/tr/td[2]/div/a");
				click(selenium,"//div[@id='adminAddressBookListView']/table/tbody/tr/td[2]/div/a");
				waitForPageLoad(selenium);
				click(selenium,"yesButton");
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
	 * createAddressBook
	 * function to create Address Book
	 * @throws IOException 
	 * @since  	     May 21, 2012
	 */	
	public boolean createAddressBook(Selenium selenium, AuditLogLib adminAddrData) throws IOException {
		try{
			if(adminAddrData.contactLevel.equalsIgnoreCase("Global"))
			{
				assertTrue(click(selenium,"//span/input"), "could not click contact level", selenium, ClassName,MethodName);
			}
			else{
				assertTrue(click(selenium,"//span[2]/input"), "could not click contact level", selenium, ClassName,MethodName);
			}
				
			selectValueFromAjaxList(selenium, "contactTypesuggestBox", adminAddrData.contactType);
			assertTrue(type(selenium, "addressBookContactCompany", adminAddrData.contactCompany),"Could not Enter the Company;More Details:"+adminAddrData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium, "titlesuggestBox",adminAddrData.salutation);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, "addressBookLastName", adminAddrData.lastName),"Could not enter Last Name; More Details:" + adminAddrData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium, "addressBookFirstName", adminAddrData.firstName),"Could not enter First Name; More Details:" + adminAddrData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium, "addressBookMiddleName",adminAddrData.middleName),"Could not enter the Middle name;More Details:"+adminAddrData.toString(), selenium, ClassName,MethodName);
			if(isElementPresent(selenium,"jobTitleFieldId")){
			assertTrue(type(selenium, "jobTitleFieldId",adminAddrData.jobTitle),"Could not Enter the Job Name;More Details"+adminAddrData.toString(), selenium, ClassName,MethodName);
			}else
				assertTrue(type(selenium, "jobTitleId",adminAddrData.jobTitle),"Could not Enter the Job Name;More Details"+adminAddrData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium, "addressBookDepartment", adminAddrData.department),"Could not enter Department; More Details:" + adminAddrData.toString(), selenium, ClassName,MethodName);
			//selectValueFromAjaxList(selenium, "commType1suggestBox",adminAddrData.telephoneType1);
			assertTrue(type(selenium, "addressBookPrimaryPhone", adminAddrData.telephoneNo1),"Could not enter primary phone number; More Details:" + adminAddrData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium, "addressBookPrimaryPhoneExt", adminAddrData.telephoneextnNo1),"Could not enter primary extn number; More Details:" + adminAddrData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium, "faxFieldId", adminAddrData.telephoneNo2),"Could not enter primary extn number; More Details:" + adminAddrData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium, "addressBookAddress1",adminAddrData.address1),"Could not enter the Street1;More Details:"+adminAddrData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium, "addressBookAddress2",adminAddrData.address2),"Could not enter the Street2;More Details:"+adminAddrData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium, "addressBookCity", adminAddrData.city),"Colud not enter the city;More Details"+adminAddrData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium, "addressBookStatesuggestBox",adminAddrData.state);
			assertTrue(type(selenium, "addressBookZipCode", adminAddrData.zipcode),"Could not enter Zip; More Details:" + adminAddrData.toString(), selenium, ClassName,MethodName);
			selenium.keyPress("addressBookCountrysuggestBox", "\\9");
			waitForPageLoad(selenium);
			click(selenium,"yesButton");
			selectValueFromAjaxList(selenium, "addressBookCountrysuggestBox",adminAddrData.country);
			assertTrue(type(selenium, "addressBookEmail",adminAddrData.email),"Could not Enter the Mail;More Details:"+adminAddrData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium, "addressBookWebAddress",adminAddrData.webAddress),"Could not enter the Web Address;Mor Details"+adminAddrData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium, "comments",adminAddrData.comments),"Could not type the Comments; More Details"+adminAddrData.toString(), selenium, ClassName,MethodName);
			assertTrue(click(selenium, "addressBookSave"),"Could not find save button; More Details:" + adminAddrData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, "//td[2]/div/div/div/div")){
				return true;
			}else{
				return false;
				}
			}
			catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + adminAddrData.toString());
			return false;
		}
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
			waitForElement(selenium, "//div[@id='adminPharmacyListView']/table/tbody/tr/td[2]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='adminPharmacyListView']/table/tbody/tr/td[2]/div/a") > 0){
				directoriesCount = (Integer) selenium.getXpathCount("//div[@id='adminPharmacyListView']/table/tbody/tr/td[2]/div/a");
				assertTrue(click(selenium,"//div[@id='adminPharmacyListView']/table/tbody/tr/td[2]/div/a"),"Could not clik Pharmacy List", selenium, ClassName,MethodName);
				assertTrue(click(selenium,"yesButton"),"Could not click Yes Button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(directoriesCount == (Integer) selenium.getXpathCount("//div[@id='adminPharmacyListView']/table/tbody/tr/td[2]/div/a")){
					directoriesDeleted = false;
					break;
				}
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
	 * @throws IOException 
	 * @since  	    Aug 27, 2012
	 */	
	public boolean createDirectories(Selenium selenium,AuditLogLib directoriesData) throws IOException{
		boolean returnValue=true;
		try{
			waitForPageLoad(selenium);
			assertTrue(type(selenium,"pharmacyName",directoriesData.pharmacyName),"Could not type the pharmacyNema;More details:"+directoriesData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"addr1",directoriesData.street),"Could not type the street;More details:"+directoriesData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"city",directoriesData.city),"Could not type the city;More details:"+directoriesData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"stateSuggestBoxsuggestBox",directoriesData.state);
			assertTrue(type(selenium,"zip",directoriesData.zipcode),"Could not type the zip code;More details:"+directoriesData.toString(), selenium, ClassName,MethodName);
			click(selenium,"noButton");
			selectValueFromAjaxList(selenium,"countrySuggestBoxsuggestBox",directoriesData.country);
			assertTrue(type(selenium,"phone",directoriesData.telephoneNo1),"Could not type the phone no;More details:"+directoriesData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"phoneExtension",directoriesData.telephoneextnNo1),"Could not type exten no;More details:"+directoriesData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"fax",directoriesData.fax),"Could not type the fax;More details:"+directoriesData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"email",directoriesData.email),"Could not type the email;More details:"+directoriesData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"website",directoriesData.webAddress),"Could not type the web address;More details:"+directoriesData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"titlesuggestBox",directoriesData.salutation);
			assertTrue(type(selenium,"lastName",directoriesData.lastName),"Could not type the last Name;More details:"+directoriesData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"firstName",directoriesData.firstName),"Could not type the first name;More details:"+directoriesData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"commentTextBoxId",directoriesData.comments),"Could not type the comments;More details:"+directoriesData.toString(), selenium, ClassName,MethodName);
			assertTrue(click(selenium,"save"),"Could not click the save button;More details:"+directoriesData.toString(), selenium, ClassName,MethodName);
			if(isElementPresent(selenium,"searchTextBox")){
				returnValue=true;
			}else
				returnValue=false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}
	
	/**
	 * goToBeginEncounter
	 * function to goToBeginEncounter
	 * @throws IOException 
	 * @since  	    Sep 12, 2012
	 */	
	
	public boolean goToBeginEncounter(Selenium selenium) throws IOException{
		try{
			if(isElementPresent(selenium, "BeginEncounterButton")){
				assertTrue(click(selenium, "BeginEncounterButton"),"Could not click Begin Encounter Button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,"css=div.pickupEncounterPanel.zIndex1000")){
					if(isElementPresent(selenium,"beginNewEncounter")){
						waitForPageLoad(selenium);
						click(selenium,"beginNewEncounter");
					}else if(isElementPresent(selenium,"//body/div[4]/div/div/div[2]/div[2]")){
						click(selenium,"//body/div[4]/div/div/div[2]/div[2]");
					}else if(isElementPresent(selenium,"//body/div[5]/div/div/div[2]/div[2]")){
						click(selenium,"//body/div[5]/div/div/div[2]/div[2]");
					}else if(isElementPresent(selenium,"//div[4]/div/div/div[2]/div[2]")){
						click(selenium,"//div[4]/div/div/div[2]/div[2]");
					}else{
						click(selenium,"//div[5]/div/div/div[2]/div[2]");
					}
					waitForPageLoad(selenium);
				}
				assertTrue(isElementPresent(selenium,"done"),"Could not click on done button", selenium, ClassName,MethodName);
				click(selenium,"done");
				assertTrue(isElementPresent(selenium,"//a[contains(text(),'Actions')]"),"Sign button is not present", selenium, ClassName,MethodName);
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 *deleteAllergy
	 * function to delete  Allergy
	 * @since  	    Oct 17, 2012
	 */	
	public boolean deleteAllAllergy(Selenium selenium ,AuditLogLib allergyData){
		boolean historyDeleted=true;
		int historyCount=0;
		try{
			assertTrue(click(selenium,"includeInactivecheckbox"),"Could not click the show All recorded check box;More Details:"+allergyData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForElement(selenium,"//div[@id='AllergyList']/table/tbody/tr/td[4]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='AllergyList']/table/tbody/tr/td[4]/div/a") > 0){
				historyCount=(Integer) selenium.getXpathCount("//div[@id='AllergyList']/table/tbody/tr/td[4]/div/a");
				assertTrue(click(selenium,"//div[@id='AllergyList']/table/tbody/tr/td[4]/div/a"),"Could not click Allergy List", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, "deleteReason", allergyData.reason), "Could not type reason for deletion", selenium, ClassName,MethodName);
				assertTrue(click(selenium,"//button[@id='deleteReason']"),"Could not click Delete button;More Details:"+allergyData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(historyCount == (Integer) selenium.getXpathCount("//div[@id='AllergyList']/table/tbody/tr/td[4]/div/a")){
					historyDeleted = false;
					break;
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return historyDeleted;
	}

	/**
	 * createAllergy
	 * function to create Allergy
	* @since  	    Sep 27, 2012
	 */	
	
	public boolean createAllergy(Selenium selenium,AuditLogLib allergyData){
		try{
			if(allergyData.testCaseId.equals("TC_CA_004")){
				assertTrue(click(selenium,"//div[6]/div[2]/div/div/span[2]/input"),"Could not Intolernce radio button;More Details", selenium, ClassName,MethodName);
			}
			selectValueFromAjaxList(selenium,"allergenSuggestBox",allergyData.allergen);
			
			selectValueFromAjaxList(selenium,"allergyReactionsuggestBox",allergyData.reaction);
			
			if(!allergyData.testCaseId.equals("TC_CA_001")){
				assertTrue(click(selenium,"//div[6]/div[3]/div[2]/div/div"),"Could not on show more button", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,"severitysuggestBox",allergyData.severity);
				
				selectValueFromAjaxList(selenium,"statusSuggestBoxsuggestBox",allergyData.status);
				
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				String date=DateFormat.format(cal.getTime());
				assertTrue(enterDate(selenium,"onsetDate",date),"Could not enter the Admin on ;More Details:"+allergyData.toString(), selenium, ClassName,MethodName);
				
				selectValueFromAjaxList(selenium,"lifeStagesuggestBox",allergyData.lifeStage);
				
				assertTrue(type(selenium,"summaryComment",allergyData.comment),"Could not enter the comment;More Details:"+allergyData.toString(), selenium, ClassName,MethodName);
			}if(allergyData.testCaseId.equalsIgnoreCase("TC_CA_005")){
				assertTrue(click(selenium,"xpath=(//button[@id='cancel'])[2]"),"Could not click the cancel button;More details:"+allergyData.toString(), selenium, ClassName,MethodName);
			}else
				assertTrue(click(selenium,"add"),"Could not click the add button;More details:"+allergyData.toString(), selenium, ClassName,MethodName);
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
	 * deleteAllProblemList
	 * Function to delete All Existing Problem List 
	 * @since	Nov 05, 2012
	 */	
	public boolean deleteAllProblemList(Selenium selenium ,AuditLogLib proData){
		boolean problemDeleted=true;
		int problemCount=0;
		try{
			
			waitForElement(selenium,"//div[@id='ProblemsList']/table/tbody/tr/td[3]", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='ProblemsList']/table/tbody/tr/td[3]") > 0){
				problemCount=(Integer) selenium.getXpathCount("//div[@id='ProblemsList']/table/tbody/tr/td[3]");
				assertTrue(click(selenium,"//a[contains(text(),'Delete')]"),"Could not click Delete Button", selenium, ClassName,MethodName);
				assertTrue(click(selenium,"yesButton"),"Could not click Yes Button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(problemCount == (Integer) selenium.getXpathCount("//div[@id='ProblemsList']/table/tbody/tr/td[3]")){
					Assert.fail("Could not delete the entry");
					break;
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return problemDeleted;
	}
	
	/**
	 * create ProblemList
	 * function to create Procedure
	 * @since  	    Sep 28, 2012
	 */	
	
	public boolean createProblemList(Selenium selenium,AuditLogLib proData){
		try{
			waitForPageLoad(selenium);
			assertTrue(type(selenium,"medicalConditionTextBoxId",proData.medicalCondition1),"Could not type medical condition", selenium, ClassName,MethodName);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			String date=DateFormat.format(cal.getTime());
			assertTrue(enterDate(selenium,"onsetDate",date),"Could not enter the Admin on ;More Details:"+proData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"itemStatusInputsuggestBox",proData.itemStatus);
			
			
			assertTrue(click(selenium,"//div[6]/div[3]/div[2]/div/div"),"Could not on show more button", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"lifeStagesuggestBox",proData.lifeStage);
			
			assertTrue(enterDate(selenium,"resolvedDate",date),"Could not enter resolved date ;More Details:"+proData.toString(), selenium, ClassName,MethodName);
			
			selectValueFromAjaxList(selenium,"codingSystemsuggestBox",proData.codingSystem);
			
			waitForPageLoad(selenium);
 			selectValueFromAjaxList(selenium,"diagnosissuggestBox",proData.diagnosis);
 			
 			waitForPageLoad(selenium);
			assertTrue(type(selenium,"summaryComment",proData.comment),"Could not enter the comment;More Details:"+proData.toString(), selenium, ClassName,MethodName);
			
			if(proData.testCaseId.equals("TC_APL_002")){
				assertTrue(click(selenium,"xpath=(//button[@id='save'])[2]"),"Could not click the add button;More details:"+proData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}else if(isElementPresent(selenium,"add")){
			assertTrue(click(selenium,"add"),"Could not click the add button;More details:"+proData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			}
				
			
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
	 *deleteProcedure
	 * function to delete Procedure 
	 * @since  	    Oct 19, 2012
	 */	
	public boolean deleteProcedure(Selenium selenium ,AuditLogLib proData){
		boolean procedureDeleted=true;
		int procedureCount=0;
		try{
			
			waitForElement(selenium,"//div[@id='ProcedureList']/table/tbody/tr/td[4]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='ProcedureList']/table/tbody/tr/td[4]/div/a") > 0){
				procedureCount=(Integer) selenium.getXpathCount("//div[@id='ProcedureList']/table/tbody/tr/td[4]/div/a");
				assertTrue(click(selenium,"//div[@id='ProcedureList']/table/tbody/tr/td[4]/div/a"),"Coul not click Procedure List", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,"deleteReason",proData.reason),"Could not type the reason; More Details:"+proData.toString(), selenium, ClassName,MethodName);
				assertTrue(click(selenium,"//button[@id='deleteReason']"),"Could not click the delete button;More Details:"+proData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(procedureCount == (Integer) selenium.getXpathCount("//div[@id='ProcedureList']/table/tbody/tr/td[4]/div/a")){
					procedureDeleted = false;
					break;
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return procedureDeleted;
	}
	
	/**
	 * createProcedure
	 * function to create Procedure
	 * @since  	    Sep 28, 2012
	 */	
	
	public boolean createProcedure(Selenium selenium,AuditLogLib proData){
		try{
			
			if(isElementPresent(selenium,proName)){
				assertTrue(type(selenium,proName,proData.proName),"Could not type procedure name", selenium, ClassName,MethodName);
			}
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			String date=DateFormat.format(cal.getTime());
		
			assertTrue(enterDate(selenium,procedureDate,date),"Could not enter the Admin on ;More Details:"+proData.toString(), selenium, ClassName,MethodName);
			//if(proData.testCaseId.equals("TC_CP_002"))
				assertTrue(click(selenium,showMoreDetails_Procedure),"Could not on show more button", selenium, ClassName,MethodName);
				Calendar cal1=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
				String date1=DateFormat1.format(cal1.getTime());
				assertTrue(enterDate(selenium,onSetDate,date1),"Could not enter the Admin on ;More Details:"+proData.toString(), selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,cpt,proData.cpt);
				
				assertTrue(type(selenium,comment,proData.comment),"Could not enter the comment;More Details:"+proData.toString(), selenium, ClassName,MethodName);
				assertTrue(click(selenium,consentCheckBox_procedure),"Could not on show more button", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,consent_procedure,proData.consent);
				
				if(proData.testCaseId.equals("")){
					assertTrue(click(selenium,add),"Could not click the add button;More details:"+proData.toString(), selenium, ClassName,MethodName);
				}else
				assertTrue(click(selenium,add),"Could not click the add button;More details:"+proData.toString(), selenium, ClassName,MethodName);
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
	 *deleteMedication
	 * function to delete Medication
	 * @since  	    Oct 10, 2012
	 */	
	public boolean deleteMedication(Selenium selenium,AuditLogLib medicationData){
		boolean medicationDeleted=true;
		int medicationCount=0;
		try{
			waitForElement(selenium,"//a[contains(text(),'Delete')]", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//a[contains(text(),'Delete')]") > 0){
				medicationCount=(Integer) selenium.getXpathCount("//a[contains(text(),'Delete')]");
				assertTrue(click(selenium,"//a[contains(text(),'Delete')]"),"Could not click Delete Button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,"writtenReason",medicationData.userAccount),"Could not enter the reason", selenium, ClassName,MethodName);
				assertTrue(click(selenium,"saveReason"),"Could not click save Reason Button", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(medicationCount == (Integer) selenium.getXpathCount("//a[contains(text(),'Delete')]")){
					medicationDeleted = false;
					break;
				}
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return medicationDeleted;
	}
	
	/**
	 *createMedication
	 * function to cretae Medication
	 * @since  	    Oct 10, 2012
	 */	
	
	public boolean createMedication(Selenium selenium,AuditLogLib medicationData){
		try{
			selectValueFromAjaxList(selenium,"medicationSuggestBox",medicationData.prescribeName);
			//Assert.assertTrue(type(selenium,"medicationSuggestBox",medicationData.prescribe),"Could not enter the text;More Details:"+medicationData.toString());
			waitForPageLoad(selenium);
			if(medicationData.freeText.equals("Yes")){
				assertTrue(click(selenium,"enterAsFreeTextcheckbox"),"Could not click the check box;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,"css=div.marginTop10 > textarea.gwt-TextArea",medicationData.direction),"Could not enter the text;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
			}if(medicationData.increaseDecreaseDose.equals("Yes")){
				assertTrue(click(selenium,"increaseDecreaseDosecheckbox"),"Could not click the check box;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillMethodSuggestBoxsuggestBox'])[2]",medicationData.refillMethod);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillQuantitySuggestBoxsuggestBox'])[2]",medicationData.refillQuantity);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillUnitSuggestBoxsuggestBox'])[2]",medicationData.refillUnit);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillRouteSuggestBoxsuggestBox'])[2]",medicationData.refillRoute);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillFrequencySuggestBoxsuggestBox'])[2]",medicationData.refillFrequency);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[2]",medicationData.refillUsage);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[3]",medicationData.refillUsage1);
				selectValueFromAjaxList(selenium,"durationNumberID",medicationData.duration);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[4]",medicationData.refillUsage2);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[5]",medicationData.refillUsage3);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[6]",medicationData.refillUsage4);
			}if(medicationData.multipleDirection.equals("Yes")){
				assertTrue(click(selenium,"multipleDirectionscheckbox"),"Could not click the check box;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillMethodSuggestBoxsuggestBox'])[3]",medicationData.refillMethod);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillQuantitySuggestBoxsuggestBox'])[3]",medicationData.refillQuantity);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillUnitSuggestBoxsuggestBox'])[3]",medicationData.refillUnit);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillFrequencySuggestBoxsuggestBox'])[3]",medicationData.refillFrequency);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillDurationSuggestBoxsuggestBox'])[2]",medicationData.refillduration);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[7]",medicationData.refillUsage);
				selectValueFromAjaxList(selenium,"refillMethodSuggestBox1suggestBox",medicationData.method);
				selectValueFromAjaxList(selenium,"refillQuantitySuggestBox1suggestBox",medicationData.quality);
				selectValueFromAjaxList(selenium,"refillUnitSuggestBox1suggestBox",medicationData.unit);
				selectValueFromAjaxList(selenium,"refillRouteSuggestBox1suggestBox",medicationData.route);
				selectValueFromAjaxList(selenium,"refillFrequencySuggestBox1suggestBox",medicationData.frequency);
				selectValueFromAjaxList(selenium,"refillDurationSuggestBox1suggestBox",medicationData.duration);
				selectValueFromAjaxList(selenium,"refillUsageSuggestBox1suggestBox",medicationData.usage);
			}
			else if(!medicationData.freeText.equals("Yes")&& !medicationData.increaseDecreaseDose.equals("Yes")&& !medicationData.multipleDirection.equals("Yes")){
				selectValueFromAjaxList(selenium,"refillMethodSuggestBoxsuggestBox",medicationData.refillMethod);
				selectValueFromAjaxList(selenium,"refillQuantitySuggestBoxsuggestBox",medicationData.refillQuantity);
				selectValueFromAjaxList(selenium,"refillUnitSuggestBoxsuggestBox",medicationData.refillUnit);
				selectValueFromAjaxList(selenium,"refillRouteSuggestBoxsuggestBox",medicationData.refillRoute);
				selectValueFromAjaxList(selenium,"refillFrequencySuggestBoxsuggestBox",medicationData.refillFrequency );
				selectValueFromAjaxList(selenium,"refillDurationSuggestBoxsuggestBox",medicationData.refillduration);
				selectValueFromAjaxList(selenium,"refillUsageSuggestBoxsuggestBox",medicationData.refillUsage);
			}
			assertTrue(enterDate(selenium,"css=input.gwt-DateBox",medicationData.startDate),"Could not enter the Date;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"//div[2]/div/div[2]/input",medicationData.supply),"Could not enter the supply;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
				assertTrue(click(selenium,"//div[8]/div/div[2]"),"Could not click the show more link;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				assertTrue(enterDate(selenium,"xpath=(//input[@type='text'])[41]",medicationData.prescribeOn),"Could not enter Data", selenium, ClassName,MethodName);
				assertTrue(type(selenium,"xpath=(//input[@type='text'])[43]",medicationData.refill),"Could not enter the refill;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,"//div[2]/div[2]/input",medicationData.prescribedby),"Could not enter the date;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				assertTrue(enterDate(selenium,"//div[2]/div[2]/div[2]/input",medicationData.lastRefill),"Could not enter Data", selenium, ClassName,MethodName);
				assertTrue(type(selenium,"//div[2]/textarea",medicationData.comment),"Could not enter the commend;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
			
		
			if(isElementPresent(selenium,"xpath=(//button[@id='save'])[2]")){
				assertTrue(click(selenium,"xpath=(//button[@id='save'])[2]"),"Could not click the show more link;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
				return true;
			}
			assertTrue(click(selenium,"add"),"Could not click the add button;More Details:"+medicationData.toString(), selenium, ClassName,MethodName);
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
	 *deleteFamilyHistory
	 * function to delete FamilyHistory
	 * @since  	    Oct 04, 2012
	 */	
	public boolean deleteFamilyHistory(Selenium selenium ,AuditLogLib historyData){
		boolean historyDeleted=true;
		int historyCount=0;
		try{
			
			waitForElement(selenium,"//div[@id='FamilyHistoryList']/table/tbody/tr/td[4]/div/a", WAIT_TIME);
			while((Integer) selenium.getXpathCount("//div[@id='FamilyHistoryList']/table/tbody/tr/td[4]/div/a") > 0){
				historyCount=(Integer) selenium.getXpathCount("//div[@id='FamilyHistoryList']/table/tbody/tr/td[4]/div/a");
				assertTrue(click(selenium,"//div[@id='FamilyHistoryList']/table/tbody/tr/td[4]/div/a"),"Could not click Family History List", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,"yesButton"),"Could not click Yes button;More Details:"+historyData.toString(), selenium, ClassName,MethodName);
				/*Assert.assertTrue(type(selenium,"deleteReason",historyData.reason),"Could not type the reason");
				waitForPageLoad(selenium);
				Assert.assertTrue(click(selenium,"//div[3]/span/button"));*/
				waitForPageLoad(selenium);
				if(historyCount == (Integer) selenium.getXpathCount("//div[@id='FamilyHistoryList']/table/tbody/tr/td[4]/div/a")){
					historyDeleted = false;
					break;
				}
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return historyDeleted;
	}
	/**
	 * createFamilyHistory
	 * function to create FamilyHistory
	 * @since  	    Oct 04, 2012
	 */	
	public boolean createFamilyHistory(Selenium selenium,AuditLogLib historyData){
		try{
			assertTrue(type(selenium,"medicalCondition",historyData.medical),"Could not enter the medical ", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"relationshipsuggestBox",historyData.relation);
			
			selectValueFromAjaxList(selenium,"codingSystemsuggestBox",historyData.codingSystem);
			
			assertTrue(type(selenium,"css=div.inlineBlock.width100 > input.gwt-TextBox",historyData.age),"Could not enter the age;More Details:"+historyData.toString(), selenium, ClassName,MethodName);
			
			selectValueFromAjaxList(selenium,"diagnosissuggestBox",historyData.diagnosis);
			
			
				//Assert.assertTrue(click(selenium,"//div[3]/div[2]/div/div[2]"),"Could not click the show more Details link");
				//waitForPageLoad(selenium);
				
				assertTrue(click(selenium,"css=div.inlineBlock.pointer > div.inlineBlock.light"),"Could not on show more button",selenium,ClassName,MethodName);
							
				
				assertTrue(getValue(selenium, "lifeStagesuggestBox").equalsIgnoreCase(historyData.lifeStage), "Life stage Auto-select is failed",selenium,ClassName,MethodName);
				if(historyData.cause.equals("yes")){
					assertTrue(click(selenium,"//div/div/div/div[2]/div/span/input"),"Could not click the check box",selenium,ClassName,MethodName);
					assertTrue(type(selenium,"ageAtDeath",historyData.ageAtDeath),"Could not enter the age at death",selenium,ClassName,MethodName);
				}
				assertTrue(type(selenium,"treatment",historyData.treatment),"Could not enter the treatment;More Details:"+historyData.toString(),selenium,ClassName,MethodName);
				assertTrue(type(selenium,"comment",historyData.comment),"Could not enter the comments;More Details:"+historyData.toString(),selenium,ClassName,MethodName);
				if(historyData.saveList.equals("yes")){
					assertTrue(click(selenium,"saveListcheckbox"),"Could not click the check box;More Details:"+historyData.toString(),selenium,ClassName,MethodName);
				}
			
			
			if(historyData.testCaseId.equals("TC_AFH_002")){
				assertTrue(click(selenium,"xpath=(//button[@id='cancel'])[2]"),"Could not click the Cancel button;More details:"+historyData.toString(),selenium,ClassName,MethodName);
				return true;
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"add"),"Could not click add button;More Details"+historyData.toString(),selenium,ClassName,MethodName);
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
	 * addPrescribeMedication
	 * function to add Prescribe Medication
	 * @since  	    Sep 12, 2012
	 */	
	public boolean addPrescribeMedication(Selenium selenium,AuditLogLib prescribeData){
		try{
			//waitForPageLoad(selenium);
			//selectValueFromAjaxList(selenium,"providerListSuggestBoxsuggestBox",prescribeData.provider);
			//waitForPageLoad(selenium);
			//selectValueFromAjaxList(selenium,"locationListSuggestBoxsuggestBox",prescribeData.loaction);
			//selenium.clickAt("locationListSuggestBoxsuggestBox", "");
			//click(selenium,"//body/div[5]/div/div/div/div/div");
			//waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"oneTimeOnlyIDcheckbox"),"Could not click the one time only check box;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			if(prescribeData.freeText.equals("Yes")){
				if(!isChecked(selenium,"freeTextIDcheckbox"))
				assertTrue(click(selenium,"freeTextIDcheckbox"),"Could not click the Free text check box;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,"directionsNotesTextBoxId",prescribeData.direction),"Could not enter the text;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
			    assertTrue(type(selenium,"dispenseID",prescribeData.dispense),"Could not enter dispense;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"unitListSuggestBoxsuggestBox",prescribeData.unitList);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
			}if(prescribeData.increaseDecreaseDose.equals("Yes")){
				if(!isChecked(selenium,"increaseDecreaseIDcheckbox"))
					assertTrue(click(selenium,"increaseDecreaseIDcheckbox"),"Could not click the Increase/Decrease Dose check box;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,"//div[4]/div/div/div/div/div/div/div/input",prescribeData.refillMethod);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"//div[4]/div/div/div/div/div[2]/div/div/input",prescribeData.refillQuantity);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"//div[4]/div/div/div/div/div[3]/div/div/input",prescribeData.refillUnit);
				//click(selenium,"//body/div[5]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"//div[4]/div/div/div/div/div[4]/div/div/input",prescribeData.refillRoute);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"//div[4]/div/div/div/div[2]/div/div/div/input",prescribeData.refillFrequency);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"//div[3]/div/div/div/input",prescribeData.refillUsage);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"//div[3]/div[2]/div/div/input",prescribeData.usage);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				assertTrue(type(selenium,"durationNumberID",prescribeData.duration),"Could not type the duration;More Details;"+prescribeData.toString(),selenium,ClassName,MethodName);
				selectValueFromAjaxList(selenium,"//div[3]/div[4]/div/div/input",prescribeData.refillUsage1);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"//div[4]/div/div/div/input",prescribeData.refillUsage2);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"//div[4]/div[3]/div/div/input",prescribeData.refillUsage3);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				waitForPageLoad(selenium);
			}if(prescribeData.multipleDirection.equals("Yes")){
		if(!isChecked(selenium,"multipleDirectionIDcheckbox"))
					assertTrue(click(selenium,"multipleDirectionIDcheckbox"),"Could not click the multiple direction check box;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,"//div[5]/div/div/div/div/div/div/div/div/div/input",prescribeData.refillMethod);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"//div[5]/div/div/div/div/div/div/div[2]/div/div/input",prescribeData.refillQuantity);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"//div[5]/div/div/div/div/div/div/div[3]/div/div/input",prescribeData.refillUnit);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"//div[5]/div/div/div/div/div/div/div[4]/div/div/input",prescribeData.refillRoute);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"//div[5]/div/div/div/div/div/div[2]/div/div/div/input",prescribeData.refillFrequency);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"//div[5]/div/div/div/div/div/div[2]/div[2]/div/div/input",prescribeData.refillduration);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"//div[5]/div/div/div/div/div/div[2]/div[3]/div/div/input",prescribeData.refillUsage1);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"refillMethodSuggestBox1suggestBox",prescribeData.method);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"//div[2]/div[2]/div/div[2]/div/div/input",prescribeData.quality);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"refillUnitSuggestBox1suggestBox",prescribeData.unit);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"refillRouteSuggestBox1suggestBox",prescribeData.route);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"refillFrequencySuggestBox1suggestBox",prescribeData.frequency);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"refillDurationSuggestBox1suggestBox",prescribeData.duration);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"refillUsageSuggestBox1suggestBox",prescribeData.usage);
				click(selenium,"//body/div[4]/div/div/div/div/div");
			}
			else if(!prescribeData.freeText.equals("Yes")&&!prescribeData.increaseDecreaseDose.equals("Yes")&&!prescribeData.multipleDirection.equals("Yes")){
				//waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"refillMethodSuggestBoxsuggestBox",prescribeData.refillMethod);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"refillQuantitySuggestBoxsuggestBox",prescribeData.quality);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"refillUnitSuggestBoxsuggestBox",prescribeData.unit);
				//click(selenium,"//body/div[5]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"refillRouteSuggestBoxsuggestBox",prescribeData.route);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"refillFrequencySuggestBoxsuggestBox",prescribeData.frequency);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"refillDurationSuggestBoxsuggestBox",prescribeData.duration);
				//click(selenium,"//body/div[4]/div/div/div/div/div");
				selectValueFromAjaxList(selenium,"refillUsageSuggestBoxsuggestBox",prescribeData.usage);
				//click(selenium,"//body/div[4]/div/div/div/div/div");

				assertTrue(type(selenium,"directionsNotesTextBoxId",prescribeData.direction),"Could not enter the text;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			if(prescribeData.testCaseId.equalsIgnoreCase("TC_ALPM_001")||prescribeData.testCaseId.equalsIgnoreCase("TC_ALPM_002"))
			{
				assertTrue(type(selenium,"//div/div/div[2]/div/textarea",prescribeData.prescribeName),"Could not enter the medication free text;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			if(prescribeData.testCaseId.equalsIgnoreCase("TC_PM_013")){
				selenium.clickAt("directionsNotesTextBoxId", "");
				System.out.println(getText(selenium, "css=i"));
				assertTrue(getText(selenium, "css=i").equalsIgnoreCase(prescribeData.addDirectionCount), "Additional directions count is not deducted properly", selenium, ClassName,MethodName);
			}
			assertTrue(type(selenium,"dispenseID",prescribeData.dispense),"Could not enter dispense;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"unitListSuggestBoxsuggestBox",prescribeData.unitList);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			
			/*Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
			String date=DateFormat1.format(cal.getTime());
			Assert.assertTrue(enterDate(selenium,"fillOnID",date),"Could not enter the Date;More Details:"+prescribeData.toString());*/
			
			if(!prescribeData.ofRefill.isEmpty())
			{
				assertTrue(type(selenium,"ofRefillsid",prescribeData.ofRefill),"Could not enter the Refill;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
				assertTrue(type(selenium,"xpath=(//input[@id='durationNumberID'])[2]",prescribeData.ofRefill),"Could not enter the no of Refill;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,"durationListSuggestBoxsuggestBox",prescribeData.refillUsage1);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillMethodSuggestBoxsuggestBox'])[4]",prescribeData.refillMethod);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillQuantitySuggestBoxsuggestBox'])[4]",prescribeData.refillQuantity);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillUnitSuggestBoxsuggestBox'])[4]",prescribeData.refillUnit);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillRouteSuggestBoxsuggestBox'])[4]",prescribeData.refillRoute);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillFrequencySuggestBoxsuggestBox'])[4]",prescribeData.refillFrequency);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillDurationSuggestBoxsuggestBox'])[3]",prescribeData.refillduration);
				selectValueFromAjaxList(selenium,"xpath=(//input[@id='refillUsageSuggestBoxsuggestBox'])[8]",prescribeData.usage);
			}
			assertTrue(type(selenium,"notesToPharmacyTextBoxId",prescribeData.notesToPharmacy),"Could not enter dispense;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
			if(prescribeData.subPermitted.equals("Yes")){
				assertTrue(click(selenium,"subPermittedcheckbox"),"Could not click the permitted check box;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
			}
			if(prescribeData.comePackage.equals("Yes")){
				assertTrue(click(selenium,"comPackingcheckbox"),"Could not click the com Packing check box;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
			}
			if(prescribeData.saveList.equals("Yes")){
				assertTrue(click(selenium,"saveListcheckbox"),"Could not click the save list;More Details"+prescribeData.toString(), selenium, ClassName,MethodName);
			}
			/*if(prescribeData.testCaseId.equals("TC_PM_001")){
			selectValueFromAjaxList(selenium,"problemSuggestBoxsuggestBox",prescribeData.problemSuggest);
			click(selenium,"//body/div[4]/div/div/div/div/div");
			Assert.assertTrue(type(selenium,"internalNotesTextBoxId",prescribeData.internalNote),"Could not type the internal Note;More Details"+prescribeData.toString());
			Assert.assertTrue(click(selenium,"previousPharmacy"),"Could not click the previous pharmacy;More Details:"+prescribeData.toString());
			click(selenium,"Select2");
			}*/
			if(prescribeData.testCaseId.equals("TC_PM_002")) {
				int count = 1;
				click(selenium,"searchDatabase");
				selectValueFromAjaxList(selenium,"searchWithinSuggestBoxsuggestBox",prescribeData.searchWithin);
				if(prescribeData.searchWithinKM.equals("Yes")){
					assertTrue(click(selenium,"searchWithinKmradio"),"Could not click the KM radio button;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
				}
				if(prescribeData.searchWithinMiles.equals("Yes")){
					assertTrue(click(selenium,"searchWithinMilesradio"),"Could not click the KM radio button;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
				}
				if(prescribeData.patient.equals("Yes")){
					assertTrue(click(selenium,"fromPatientradio"),"Could not click the patient button;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
				}
				if(prescribeData.practice.equals("Yes")){
					assertTrue(click(selenium,"fromPracticeradio"),"Could not click the practice button;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
				}
				if(prescribeData.zipcodecheck.equals("Yes")){
					assertTrue(click(selenium,"fromZipradio"),"Could not click the Zip button;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
					assertTrue(type(selenium,"fromZipText",prescribeData.zipcode),"Could not type the Zip code;More Details"+prescribeData.toString(), selenium, ClassName,MethodName);
				}
				
				assertTrue(click(selenium,"searchPharmacy"),"Could not click the search button;More Details:"+prescribeData.toString(), selenium, ClassName,MethodName);
				
				while(isElementPresent(selenium,"//div[6]/div/div[2]/table/tbody/tr["+count+"]/td/div")){
					if(getText(selenium,"//div[6]/div/div[2]/table/tbody/tr["+count+"]/td/div").toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescribeData.pharmacyName.trim().toLowerCase(new java.util.Locale("en","Us")))){
						assertTrue(click(selenium,"//tr["+count+"]/td[2]/div/a"),"Unable to Click the Element ID",selenium,ClassName,MethodName);
						break;
					}else
						count++;
				}
			}
			assertTrue(type(selenium,"internalNotesTextBoxId",prescribeData.internalNote),"Could not type the internal Note;More Details"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"continueID"),"Could not click the Continue button;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		if(isElementPresent(selenium,"edit"))
				return true;
			else
				return false;
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * goToPrescribe
	 * function to goToPrescribe
	 * @since  	    Feb 26, 2012
	 */	
	
	public boolean goToPrescribe(Selenium selenium){
		try {
			assertTrue(isElementPresent(selenium,"link=Patient Options"),"Could not find link", selenium, ClassName,MethodName);
			assertTrue(click(selenium,"link=Patient Options"),"Could not click the link", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,"css=#patientOptionsPrescribeMedication > span.topMenuItemSpan.light"),"Could not find the link", selenium, ClassName,MethodName);
			assertTrue(click(selenium,"css=#patientOptionsPrescribeMedication > span.topMenuItemSpan.light"),"Could not click the click", selenium, ClassName,MethodName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		
	}
	/**
	 * createNewPatientWithMandatory
	 * function to create New Patient With Mandatory
	 * @since	Feb 27, 2013
	 */	
	public boolean createNewPatientWithMandatory(Selenium selenium, AuditLogLib patientData){
		boolean returnValue = false;
		try{
			waitForPageLoad(selenium);
			assertTrue(type(selenium,"lastName",patientData.lastName),"Could not type the last name : More Details"+patientData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,"firstName",patientData.firstName),"Could not type the first Name : More Details"+patientData.toString(), selenium, ClassName,MethodName);
			assertTrue(click(selenium,"prematurecheckbox"),"Could not click prematurecheck box : More Details"+patientData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"prematureDurationSuggestBoxsuggestBox",patientData.duration);
			selectValueFromAjaxList(selenium,"sexSuggestBoxsuggestBox",patientData.sex);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"prematureMeasureUnitSuggestBoxsuggestBox",patientData.measure);
			selectValueFromAjaxList(selenium,"statusSuggestBoxsuggestBox",patientData.status);
			if(!patientData.dob.isEmpty())
				if(!patientData.dob.contains("N/A"))
					assertTrue(enterDate(selenium, "dob", patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob, selenium, ClassName,MethodName);			
			click(selenium,"backButton");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"saveButton"),"Could not click Save button More Dateils"+patientData.toString(), selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			returnValue = true;	
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
	 * deleteAllEncounters
	 * Function for delete All existing encounters
	 * @param selenium
	 * @param prescribeData
	 * @return
	 * @since Jan 24,2013
	 */
	public boolean deleteAllEncounters(Selenium selenium ,AuditLogLib prescribeData){
		boolean medDeleted=true;
		try{
			int count=0;
			while(isElementPresent(selenium,"//div[2]/div/div[2]/table/tbody/tr[1]/td[2]/div/div")){
				assertTrue(click(selenium,"//div[2]/div/div[2]/table/tbody/tr[1]/td[2]/div/div"),"Could not click on Actions button;More Details", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium, "//body/div[5]/div/div/div")){
					assertTrue(click(selenium,"//body/div[5]/div/div/div"),"Could not click on delete button;More Details", selenium, ClassName,MethodName);
				}
				else if(isElementPresent(selenium, "//body/div[4]/div/div/div")){
					assertTrue(click(selenium,"//body/div[4]/div/div/div"),"Could not click on delete button;More Details", selenium, ClassName,MethodName);
				}
				assertTrue(type(selenium,"deleteReason","Reason"),"Could not type reason ;More Details",selenium,ClassName,MethodName);
				if(isElementPresent(selenium, "//div[6]/div/div/div[3]/span/button")){
					assertTrue(click(selenium,"//div[6]/div/div/div[3]/span/button"),"Could not click on Delete button;More Details", selenium, ClassName,MethodName);
				}
				else if(isElementPresent(selenium, "//div[5]/div/div/div[3]/span/button")){
					assertTrue(click(selenium,"//div[5]/div/div/div[3]/span/button"),"Could not click on Delete button;More Details", selenium, ClassName,MethodName);
				}
				waitForPageLoad(selenium);
				count++;
				if(count>30)
				break;			
				}
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return medDeleted;
	}
	
	
	/**
	 * addVitals
	 * Function to create a Vitals
	 * @throws InterruptedException 
	 * @since	Nov 09, 2012
	 */
	public boolean addVitals(Selenium selenium, AuditLogLib vitalsData){
		DecimalFormat df = new DecimalFormat(".##");
		try{
			waitForPageLoad(selenium);
			System.out.println(vitalsData.heightMU);
			if(vitalsData.heightMU.equals("cm")){
				assertTrue(type(selenium, txtHight,vitalsData.heightInCm), "could not type height in cm", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxHeight , vitalsData.heightMU);
				
			}else{
				selectValueFromAjaxList(selenium, ajxHeight, vitalsData.heightMU);
				assertTrue(type(selenium,txtHeightInFeet ,vitalsData.heightInFeet), "Could not type Hight in feet", selenium, ClassName,MethodName);
				assertTrue(type(selenium,txtHeightInCm , vitalsData.heightInCm), "Could not type Hight in cm or inches", selenium, ClassName,MethodName);
				
				waitForPageLoad(selenium);
			}
			getText(selenium, "//div[2]/div[4]/div").contains(vitalsData.htResult);
			//Assert.assertTrue(type(selenium, "xpath=(//input[@type='text'])[7]", vitalsData.weight), "Could not type weight");
			assertTrue(type(selenium,txtWeight , vitalsData.weight), "Could not type weight", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,ajxWeight , vitalsData.weightMU);
			//waitForPageLoad(selenium);
			
			if(vitalsData.testCaseId.equals("TC_CV_001")){
				String kg = getValue(selenium, "xpath=(//input[@type='text'])[9]");
				float kgs = Float.valueOf(kg).floatValue();
				String cm = getValue(selenium, "xpath=(//input[@type='text'])[7]");
				float htInCm = Float.valueOf(cm).floatValue();
				float htInMetre = (float) (htInCm * 0.01);
				float BMI = kgs / (htInMetre * htInMetre);
				String expectedBMI =  Float.toString(BMI);
				Assert.assertEquals(getText(selenium, "//div[4]/div/div/div[2]/div"), df.format(expectedBMI));
			}
			if(vitalsData.testCaseId.equals("TC_CV_002")){
				String actuallbs = getValue(selenium, "xpath=(//input[@type='text'])[9]");
				Float lbs = Float.valueOf(actuallbs).floatValue();
				String cmS = getValue(selenium, "xpath=(//input[@type='text'])[7]");
				float cmF = Float.valueOf(cmS).floatValue();
				float inches = (float) (cmF / 2.54);
			    float BMI2 = ((lbs * 703) / (inches * inches));
			    String expectedBMI = Float.toString(BMI2);
			    Assert.assertEquals(actuallbs, df.format(expectedBMI));
			}
			assertTrue(type(selenium,txtSystolic , vitalsData.systolicRate), "Could not type systolic Rate", selenium, ClassName,MethodName);
			assertTrue(type(selenium,txtDiastolic , vitalsData.diastolicRate), "Could not type diastolic Rate", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium, "positionSuggestBoxsuggestBox", vitalsData.position);
			//waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxlimb , vitalsData.limb);
			//waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxCuffSize , vitalsData.cuffSize);
			//waitForPageLoad(selenium);
			assertTrue(type(selenium,txtHeartRate, vitalsData.bPM), "Could not type Heart Rate", selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,ajxdescription , vitalsData.description);
			//waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxrhythm, vitalsData.rhythm);
			//waitForPageLoad(selenium);
			if(getText(selenium,lnkMoreDetails).contains("Show more details"))
					assertTrue(click(selenium, lnkMoreDetails), "Could not click on show more details", selenium, ClassName,MethodName);
				//waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtWaist, vitalsData.waist), "Could not type waist", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxWaist , vitalsData.waistMU);
				//waitForPageLoad(selenium);
				assertTrue(type(selenium,txtTemp, vitalsData.temperature), "Could not type temperature", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxTemp, vitalsData.tempRU);
				//waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxTempLocation, vitalsData.location);
				//waitForPageLoad(selenium);
				assertTrue(type(selenium, txtbloodSugar, vitalsData.bloodSuger), "Could not type blood sugar", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxbloodSugar , vitalsData.bSUnit);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtRespiratory, vitalsData.repositoryRate), "Could not type Repository rate", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium, ajxRespiratory, vitalsData.rR_BPM);
				//waitForPageLoad(selenium);
				assertTrue(type(selenium,txtOxygen , vitalsData.oxygenSaturation), "Could not type oxygen saturation", selenium, ClassName,MethodName);
				assertTrue(type(selenium,txtPefr , vitalsData.pEFR), "Could not type pefr", selenium, ClassName,MethodName);
				selectValueFromAjaxList(selenium,ajxpefrDescription , vitalsData.pre_bronchodilator);
				waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnadd ), "Could not click on add button", selenium, ClassName,MethodName);
					
			
		}
		catch(RuntimeException e){
			Assert.fail("Failed due to the Exception; \n Exception details: "+e.getMessage());
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return true;
	}
	
	/**
	 * verifyStoredValueForVitals
	 * function to verify Stored Value Vitals
	 * @since  	    Apr 16, 2013
	 */	
	
	public boolean verifyStoredValueForViatls(Selenium selenium, AuditLogLib vitalsData,String account){
		
		String systemDate=null;
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd,yyyy");
			systemDate=DateFormat.format(cal.getTime());
		}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			systemDate=DateFormat.format(cal.getTime());
		}
		if(!getText(selenium,"collapsableDesc").trim().contains(systemDate.trim())){
			return false; 
		} 
		
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.createdby.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false; 
		} 
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(vitalsData.heightMU.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false; 
		} 
		return true;
	}

	
	/**
	 * deleteInjection
	 * function to create Injection
	 * @since  	    Sep 26, 2012
	 */	
	public boolean deleteInjection(Selenium selenium){
		boolean injectionDeleted=true;
		int injCount=0;
		try{
			assertTrue(click(selenium,lnkInjection),"Could not click Injections link;More Details:", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,chkshowAllRecords), "Could not click on show all recorded items", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			while((Integer) selenium.getXpathCount("//div[@id='InjectionList']/table/tbody/tr/td[4]/div/a") > 0){
				injCount=(Integer) selenium.getXpathCount("//div[@id='InjectionList']/table/tbody/tr/td[4]/div/a");
				assertTrue(click(selenium,"//div[@id='InjectionList']/table/tbody/tr/td[4]/div/a"),"Could not click Injection List", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium, txtdeleteReason, "reason"), "Could not type reason for deletion", selenium, ClassName,MethodName);
				assertTrue(click(selenium,btnDeleteReason),"Could not click Delete button;More Details:", selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
				if(injCount == (Integer) selenium.getXpathCount("//div[@id='InjectionList']/table/tbody/tr/td[4]/div/a")){
					injectionDeleted = false;
					break;
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return injectionDeleted;
	}

	
	/**
	 * createInjection
	 * function to create Injection
	 * @since  	    Sep 26, 2012
	 */	
	public boolean createInjection(Selenium selenium,AuditLogLib injectionData,String account){
		String date=null;
		try{
			
			selectValueFromAjaxList(selenium,txtQuickinjection,injectionData.injection);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtLotNo,injectionData.lotNumber),"Could not type the Lot Number;More Details:"+injectionData.toString(), selenium, ClassName,MethodName);
			if(account.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat.format(cal.getTime());
				assertTrue(enterDate(selenium,txtexpiryDate,date),"Could not enter the expiry Date;More Details:"+injectionData.toString(), selenium, ClassName,MethodName);
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
				assertTrue(enterDate(selenium,txtexpiryDate,date),"Could not enter the expiry Date;More Details:"+injectionData.toString(), selenium, ClassName,MethodName);
			}
			assertTrue(type(selenium,txtDosage,injectionData.dosage),"Could not enter the Dosage;More Details:"+injectionData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,ajxDosageUnit,injectionData.dosageUnit);
			waitForPageLoad(selenium);
			if(account.equals(CAAccount)){
				assertTrue(enterDate(selenium,txtadminOn,date),"Could not enter the expiry Date;More Details:"+injectionData.toString(), selenium, ClassName,MethodName);
			}else{
				assertTrue(enterDate(selenium,txtadminOn,date),"Could not enter the expiry Date;More Details:"+injectionData.toString(), selenium, ClassName,MethodName);
			}
			
			assertTrue(click(selenium,btnAdd),"Could not click the Add buton;More Details:"+injectionData.toString(), selenium, ClassName,MethodName);
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
	 * navigateTo Encounter Template 
	 * Function to go to Encounter Template
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 21,2013
	 */
	public boolean navigateToEncounterTemplate(Selenium selenium) throws IOException{
		assertTrue(click(selenium, lnkQuickLink), "Could not click on Quick Actions button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkClinicalSettingsLink), "Could not click on Clinical settings", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkEncounterTemplate), "Could not click on encounter template link", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		if(!isElementPresent(selenium, btnAddNew)){
			return false;
		}
		return true;
	}
	
	
	/**
	 * deleteAllEncounterTemplate
	 * function to delete All Encounter Template
	 * @throws IOException 
	 * @since  Oct 21, 2013
	 */
	public boolean deleteAllEncounterTemplate(Selenium selenium) throws IOException{
		boolean  encounterDeleted=true;
		
		waitForPageLoad(selenium);
	    int encounterDeleteCount=(Integer) selenium.getXpathCount(lnkDeleteEncounterTemplate);
		
	    for(int count=1;count<=encounterDeleteCount;count++){
			 assertTrue(click(selenium, lnkDeleteEncounterTemplate), "Could not click the delete button", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
			 assertTrue(click(selenium, btnYesButton), "Could not click the save button in encounter delete", selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
		}
		if(getText(selenium, lnkDeleteEncounterTemplate).equalsIgnoreCase("Delete")){
			encounterDeleted = false;
		} 
		return encounterDeleted;
	}
	
	/**
	 * addEncounterTemplate 
	 * Function to add Encounter Template
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 21,2013
	 */
	public boolean addEncounterTemplate(Selenium selenium, AuditLogLib encounterTemplateData) throws IOException{
		assertTrue(click(selenium, btnAddNew), "Could not click on add new button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtTemplateName, encounterTemplateData.templateName), "Could not type template name", selenium, ClassName,MethodName);
		assertTrue(type(selenium, txtAreaTemplateDescription, encounterTemplateData.templateDescription), "Could not type template description", selenium, ClassName,MethodName);
		
		//It will be used for get the very first value of the visit type from the list
		click(selenium, ajxSuggestBox);
		waitForPageLoad(selenium);
		encounterTemplateData.visitType1= getText(selenium, "//body/div[3]/div/div/div/div/div");
		
		assertTrue(selectValueFromAjaxList(selenium,ajxSuggestBox,encounterTemplateData.visitType1),"Could not select visit type"+encounterTemplateData.toString(), selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, lnkStartBlank), "Could not click start blank template name", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, btnSaveEncounterTemp), "Could not click save encounter template", selenium, ClassName,MethodName);
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
	* @since  	Oct 21, 2013
	*/	
	public boolean verifyStoreValuesEncounterTemplate(Selenium selenium,AuditLogLib encounterTemplateData){

		if(!getText(selenium,lblEncounterTemplateSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterTemplateData.templateName.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;                       
		}
		if(!getText(selenium,lblEncounterTemplateSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterTemplateData.templateDescription.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;                       
		}
		if(!getText(selenium,lblEncounterTemplateSummary).toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterTemplateData.visitType1.trim().toLowerCase(new java.util.Locale("en","US")))){
			 return false;                       
		}
		return true;
		 
	}
	
	/**
	 * editEncounterTemplate 
	 * Function to edit Encounter Template
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 21,2013
	 */
	public boolean editEncounterTemplate(Selenium selenium, AuditLogLib encounterTemplateData) throws IOException{
		assertTrue(click(selenium, lnkEdit), "Could not click on edit", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(type(selenium, txtTemplateName, encounterTemplateData.templateName), "Could not type template name", selenium, ClassName,MethodName);
		assertTrue(type(selenium, txtAreaTemplateDescription, encounterTemplateData.templateDescription), "Could not type template description", selenium, ClassName,MethodName);
		
		//It will be used for get the very first value of the visit type from the list
		click(selenium, ajxSuggestBox);
		waitForPageLoad(selenium);
		encounterTemplateData.visitType1= getText(selenium, "//body/div[3]/div/div/div/div/div");
		
		assertTrue(selectValueFromAjaxList(selenium,ajxSuggestBox,encounterTemplateData.visitType1),"Could not select visit type"+encounterTemplateData.toString(), selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, btnSaveEncounterTemp), "Could not click save encounter template", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
		if(!isElementPresent(selenium, btnAddNew)){
			return false;
		}
		return true;
	}
	
	
	/**
	 * goToRegisterPatient
	 * Function to go to RegisterPatient
	 * @param 	selenium
	 * @throws IOException 
	 * @since	Oct 21,2012
	 */
	public boolean goToRegisterPatient(Selenium selenium) throws IOException{
		assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkRegisterPatient), "Could not click on Clinical Lists", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium, btnNoteSave))
			return true;
		else
			return false;
	}
	
	/**
	 * createNewPatientWithMandatory
	 * function to create New Patient With Mandatory
	 * @throws IOException 
	 * @since	Oct 21, 2013
	 */	
	public boolean createNewPatientWithMandatory(Selenium selenium, HomeLib patientData) throws IOException{
		boolean returnValue = false;
		try{
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtlastName,patientData.lastName),"Could not type the last name : More Details"+patientData.toString(), selenium, ClassName,MethodName);
			assertTrue(type(selenium,txtFirstName,patientData.firstName),"Could not type the first Name : More Details"+patientData.toString(), selenium, ClassName,MethodName);
			assertTrue(click(selenium,"prematurecheckbox"),"Could not click prematurecheck box : More Details"+patientData.toString(), selenium, ClassName,MethodName);
			selectValueFromAjaxList(selenium,"prematureDurationSuggestBoxsuggestBox",patientData.duration);
			selectValueFromAjaxList(selenium,"sexSuggestBoxsuggestBox",patientData.sex);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"prematureMeasureUnitSuggestBoxsuggestBox",patientData.measure);
			selectValueFromAjaxList(selenium,ajxStatus,patientData.status);
			if(!patientData.dob.isEmpty())
				if(!patientData.dob.contains("N/A"))
					assertTrue(enterDate(selenium, "dob", patientData.dob), "Could not Enter dob, Expected value to be typed" + patientData.dob,selenium,ClassName,MethodName);			
			click(selenium,btnBackButton);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNoteSave),"Could not click Save button More Dateils"+patientData.toString(), selenium, ClassName,MethodName);
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
	 * Add a New Payer
	 * 
	 * function to  Add a New Payer
	 * @throws IOException 
	 * @since  	     Sep  16, 2013
	 */	
	 public boolean addNewPayer(Selenium selenium,AuditLogLib payerData,String date) throws IOException {
		 
		 assertTrue(selectValueFromAjaxList(selenium,ajxPayerSelect,payerData.payerName),"Could not select payer"+ payerData.toString(), selenium, ClassName,MethodName);
		 waitForPageLoad(selenium);
	
		 if(payerData.testCaseId.equals("TC_ALPAY_002")||payerData.testCaseId.equals("TC_ALPAY_004")){
			 assertTrue(selectValueFromAjaxList(selenium,ajxTypeOfCoverageSuggest,payerData.typeofCoverage),"Could not select Type of Coverage"+ payerData.toString(), selenium, ClassName,MethodName);
			 waitForPageLoad(selenium);
			}else{
				 if(!isChecked(selenium,chkBoxOutOfNetworkBenefit)){
						assertTrue(click(selenium,chkBoxOutOfNetworkBenefit),"Could not click the Network Benefit check box; More details"+payerData.toString(), selenium, ClassName, MethodName);
					}
				 if(!isChecked(selenium,chkBoxauthorizationRequired)){
						assertTrue(click(selenium,chkBoxauthorizationRequired),"Could not click the Network Benefit check box; More details"+payerData.toString(), selenium, ClassName, MethodName);
					}
				 if(!isChecked(selenium,chkBoxAcceptAssignment)){
						assertTrue(click(selenium,chkBoxAcceptAssignment),"Could not click the Accept Assignment check box; More details"+payerData.toString(), selenium, ClassName, MethodName);
				 }
			}
    	 
		 assertTrue(enterDate(selenium,txtPayerStartDate,date), "Could not enter start Date", selenium, ClassName,MethodName);
		 assertTrue(type(selenium,txtMemberID,payerData.memberId),"Could not type MemberID "+ payerData.toString(), selenium, ClassName,MethodName);
		 assertTrue(type(selenium,txtGroupNoID,payerData.groupNo),"Could not type Group No  "+ payerData.toString(), selenium, ClassName,MethodName);
		 assertTrue(type(selenium,txtGroupNameID,payerData.groupName),"Could not type Group name "+ payerData.toString(), selenium, ClassName,MethodName);
		 assertTrue(selectSecondMatchingValueFromAjaxList(selenium,ajxPlanName,payerData.planName),"Could not select Plan Name"+ payerData.toString(), selenium, ClassName,MethodName);
		 assertTrue(type(selenium,txtBillingAddr1,payerData.billingAddr1),"Could not type BillingAddr1"+ payerData.toString(), selenium, ClassName,MethodName);
		 assertTrue(type(selenium,txtBillingAddr2,payerData.billingAddr2),"Could not type BillingAddr2"+ payerData.toString(), selenium, ClassName,MethodName);
		 assertTrue(type(selenium,txtBillingCity,payerData.billingCity),"Could not type txtBillingCity"+ payerData.toString(), selenium, ClassName,MethodName);
		 assertTrue(type(selenium,txtBillingZip,payerData.billingZip),"Could not type BillingZip"+ payerData.toString(), selenium, ClassName,MethodName);
		 assertTrue(selectValueFromAjaxList(selenium,ajxBillingStateSuggestBox,payerData.billingState),"Could not select Billing State"+ payerData.toString(), selenium, ClassName,MethodName);
		 assertTrue(selectValueFromAjaxList(selenium,ajxBillingCountrySuggestBox,payerData.billingCountry),"Could not select Billing Country"+ payerData.toString(), selenium, ClassName,MethodName);
		 assertTrue(selectValueFromAjaxList(selenium,ajxRelationShip,payerData.relationshipStatus),"Could not select Relationship Status"+ payerData.toString(), selenium, ClassName,MethodName);
		 assertTrue(selectValueFromAjaxList(selenium,ajxReleaseOfInformatiom,payerData.releaseInformation),"Could not select Relationship Status"+ payerData.toString(), selenium, ClassName,MethodName);
		 
		 assertTrue(click(selenium, btnlnkSave), "Could not click Save button" +  payerData.toString(), selenium, ClassName,MethodName);
		 waitForPageLoad(selenium);
		 
		 click(selenium,btnOK);
		 
		if(!isElementPresent(selenium,btnAddNewPayer)){
			return false;
		}
	 return true;
	 }

	/**
	 * Verify Delete All Payers
	 *  function to Verify Delete All Payers
	 * @since  	     Sep  20, 2013
	 * @return
	 * @throws IOException 
	 */
	
	public boolean deleteAllPayers(Selenium selenium) throws IOException{
		waitForPageLoad(selenium);
		boolean payersDeleted = true;
		int count ;
		while((Integer) selenium.getXpathCount("//a[contains(text(),'Delete')]") > 0){
			count = (Integer) selenium.getXpathCount("//a[contains(text(),'Delete')]");		
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"//a[contains(text(),'Delete')]"),"could not click delete button", selenium, ClassName,MethodName);
		 	waitForPageLoad(selenium);
			waitForPageLoad(selenium);
 			int counter = (Integer) selenium.getXpathCount("//a[contains(text(),'Delete')]");
			waitForPageLoad(selenium);
			if(count == counter){
				payersDeleted = false;
				break;
			}
			
		}
		return payersDeleted;
	}


}