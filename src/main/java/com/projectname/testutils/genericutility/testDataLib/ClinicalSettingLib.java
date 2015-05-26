package com.projectname.testutils.genericutility.testDataLib;

import java.lang.reflect.Field;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;

import com.projectname.testutils.genericutility.ReadFromExcel;



public class ClinicalSettingLib {
	
	//Encounter Template
	public String templateName=null;
	public String templateDescription=null;
	public String visitType1=null;
	public String visitType2=null;
	public String customSection1=null;
	public String customSection2 = null;
	public String customSection3 = null;
	public String customSection4 = null;
	public String restrictType=null;
	public String ageRestriction1=null;
	public String ageRestriction2=null;
	public String ageRestrictionUnit=null;
	public String testCaseId=null;
	public String userAccount = null;
	public String userName = null;
	public String userPassword = null;
	public String Forvalue=null;
	public String provider = null;
	public String severity = null;
	public String fromDate = null;
	public String toDate = null; 
	public String freeTextComment = null;
	public String numericWidgetValue = null;
	public String	numericWidgetValuedecimal=null;
	public String encounterdateverfify=null;
	public String freetextcomponent=null;
	public String freetextsectionnote=null;
	public String freetextdes=null;
	public String numericWidgetComment = null;
	public String numericWidgetCommentreuse=null;
	public String numericWidgetCommentreuse3=null;
	public String questionWidgetAnswer1 = null;
	public String templateNameType=null;
	public String questionWidgetComment = null;
	public String dateComment = null;
	public String type=null;
	public String referredBy=null;
    public String moreRequired=null;
	public String numQuery = null;
	public String denQuery = null;
	public String resultList=null;
	public String QuestionWidgetComment1=null;
	public String questionWidgetComment3=null;
	public String questionWidgetComment4=null;
	public String switchRole=null;
	public String encounterDate=null;
	public String role=null;
	 public String selectlibrary=null;
public String section=null;
public String sectionEdit=null;
public String encounterdate=null;
	public String description=null;
	public String targetLevel=null;
	public String checkBox=null;
	public String visitType=null;
	public String severeOnly=null;
	public String highToSevere=null;
	public String moderateToSevere=null;
	public String mildToSevere=null;
	
	public String warning=null;
	public String patientId=null;
	public String reason=null;
	public String allergen=null;
	public String allergenCA=null;
	public String location=null;
	public String medication=null;
	public String SectionName=null;
	public String sectionName2=null;
	public String SectionDescription=null;
	public String Speciality=null;
		public String WidgetRow1=null;
	public String  WidgetRow2=null;
	public String  WidgetRow3=null;
	public String  WidgetRow4=null;

	public String medicationName1=null;
	public String MedicationDrugClassName1 = null;
	public String MedicationDrugClassName2 = null;
	public String DrugClassName1=null;
	public String medicationName2=null;
	public String DrugClassName2=null;
	public String usmedicationName1=null;
	public String usDrugClassName1=null;
	public String usmedicationName2=null;
	public String usDrugClassName2=null;
	public String drugType=null;
	public String allergyType=null;
	public String category=null;
	public String display=null;
	public String due=null;
	public String dueType=null;
	public String immunization=null;
	public String customWidget=null;
	public String measurement=null;
	public String targetType=null;
	public String heightUpperLimit=null;
	public String heightLowerLimit=null;
	public String measurementScale=null;
	public String targetExceptionType=null;
	public String eheightUpperLimit=null;
	public String eheightLowerLimit=null;
	public String forWho=null;
	public String condtionType=null;
	public String condtionAge=null;
	public String conditionAgeIn=null;
	public String singlewidget=null;
	public String FreeTextLabel=null;

	public String NumericLabel = null;
	public String textTemplateName=null;
	public String numericTemplateName=null;
	public String questionTemplateName=null;
	public String assessmenttextbox=null;
	public String deleteCategory=null;
	
		public String NumericLabelFormet = null;
		public String MaxValue = null;		
		public String Minvalue = null;
		
		public String NumericLabelFormet1 = null;
		public String MaxValue1 = null;		
		public String Minvalue1= null;
		public String minmumvalue1= null;
		public String minmumvalue2= null;
		public String minmumvalue3= null;
		public String minmumvalue4= null;
		
		public String NumericDefaultvalue = null;
		public String QuestionLabel = null;
		public String QuestionAnswer = null;
		public String QuestionDefault = null;
		
		public String answer12=null;
		public String answer13=null;
		public String answer14=null;
		public String answer15=null;
		public String answer16=null;
		public String answer17=null;
		public String answer18=null;
		public String answer19=null;
		public String answer20=null;
		public String answer21=null;
		public String answer22=null;
		public String answer23=null;
		public String answer24=null;
		public String answer25=null;
		public String answer26=null;
		public String answer27=null;
		public String answer28=null;
		public String answer29=null;
		public String answer30=null;
		public String Answer1=null;
		public String Answer2=null;
		public String Answer3=null;
		public String Answer4=null;
		public String Answer5=null;
		public String Answer6=null;
		public String Answer7=null;
		public String Answer8=null;
		public String Answer9=null;
		public String answer10=null;
		public String answer11=null;
		public String assessment=null;
		public String assessmenturl=null;
		public String assessmentscore=null;
		public String scoreone=null;
		public String scoretwo=null;
public String scorefieldone=null;
public String scorefieldtwo=null;

public String imageName=null;
public String imageType=null;
public String annotations=null;
public String numOfMarkers=null;
public String marker1=null;
public String marker2=null;
public String description1=null;
public String description2=null;
public String freeText=null;
public String editedImageName=null;
public String saveAsNew=null;		
public String imageFileName=null;	
public String uncheckproblemlist=null;
		
		public String TitleLabel=null;
		public String ComponenetName=null;
		public String ComponenetName2=null;
		public String FreeTextLabelEdit=null;
		public String TitleLabelEdit=null;
		public String instructionWidget=null;
	public String datelabel=null;
 public String dateformate=null;
	public String sectionA=null;
	public String sectionB=null;
	public String sectionC=null;
	public String sectionD=null;
public String planAndRecom=null;
	public String workSheetName = null;
	public String workBookName = "TestData_ClinicalSettings.xls";		
	public String sectionName = "clinicalsettings";
	public String QuestionLabel1 = null;
	public String QuestionLabel3 = null;
	public String QuestionLabel4 = null;
	public String questionLabel5 = null;
	public String QuestionAnswer1 = null;
	public String QuestionAnswer2 = null;
	public String QuestionAnswer4 = null;
	public String questionAnswer5 = null;	
	public String dateformateEdited= null;
	public String InstructionstoUserEdit=null;
	public String QuestionLabel1Edit= null;
	public String 	QuestionLabelEdited= null;
	public Hashtable<String, Integer> excelHeaders = new Hashtable<String, Integer>();
	public Hashtable<String, Integer> excelrRowColumnCount = new Hashtable<String, Integer>();

    public String questionTemplateOne=null;
    public String questionTemplateTwo=null;
    public String questionTemplateThree=null;
    public String questionTemplateFour=null;
	
		public String toString() {
        StringBuffer listOfValues  = new StringBuffer();
        @SuppressWarnings("rawtypes")
		Class cls = this.getClass();
        Field[] fields = cls.getDeclaredFields( );

        Field field = null;
        try {
            for (int i=0; i < fields.length; i++) {
                field = fields[i];
                Object subObj = field.get(this);
                if (subObj != null && !field.getName().equals("logger") ) {
                    listOfValues.append(":");
                    listOfValues.append(field.getName());
                    listOfValues.append("=");
                    listOfValues.append(subObj.toString());
                }
            }
        }
        catch (RuntimeException e) {
            Assert.fail("toString",e);
        } catch (IllegalAccessException e) {
        	Assert.fail("Error During Execution; Execution Failed More detaisl " + e);
		}   
        return listOfValues.toString();
    }
		
	/**
	 * fetchClinicalSettingsTestData
	 * function for fetching Test data based on test case id  
	 * @since  	     Apr 30, 2010	  
	 */
	public boolean fetchClinicalSettingsTestData(){
		
		ReadFromExcel readTestData = new ReadFromExcel();
		boolean isDataFound = false;
		testCaseId = testCaseId != null ? testCaseId.trim() : "";
		
		try{
			  //******************************************************************//
			  //Fetching the test data for New Clinical Interface
			  //******************************************************************//

			HSSFSheet sheet = null;
			// function call to initiate a connection to an excel sheet
			sheet = readTestData.initiateExcelConnectionNexia(workSheetName, sectionName, workBookName); 

			// function to find number of rows and columns
			excelrRowColumnCount = readTestData.findRowColumnCount(sheet, excelrRowColumnCount);
			
			// function call to find excel header fields
			excelHeaders = readTestData.readExcelHeaders(sheet, excelHeaders, excelrRowColumnCount);

			HSSFRow row = null;
			HSSFCell cell = null;			
			String temptestCaseId = null;

			for(int r = 0; r < excelrRowColumnCount.get("RowCount"); r++) {
				row = sheet.getRow(r);  
				if(row != null) {
					for(int c = 0; c < excelrRowColumnCount.get("ColumnCount"); ) {						
						cell = row.getCell(excelHeaders.get("TestID"));
						if(cell != null){
							temptestCaseId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestID")));
							if(temptestCaseId.equals(testCaseId)){
								isDataFound = true;
								if(workSheetName.equalsIgnoreCase("MUMeasures")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    provider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
                                    fromDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("From Date")));
                                    toDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("To Date")));
                                    numQuery = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NumQuery")));
                                    denQuery = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DenQuery")));
                                    description=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
                                    targetLevel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TargetLevel")));
                                    checkBox=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CheckBox")));
                                    encounterDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EncounterDate")));
                                    role=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
                                    break;

								}else if(workSheetName.equalsIgnoreCase("VerifySecurityOption")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									break;
								}else if(workSheetName.equalsIgnoreCase("InteractionWarning")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									severeOnly=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SevereOnly")));
									highToSevere=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HighToSevere")));
									moderateToSevere=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ModerateToSevere")));
									mildToSevere=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MildToSevere")));
									warning=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Warning")));
									patientId=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									reason=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
									allergen=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Allergen")));
									allergenCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllergenCA")));
									location=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Loaction")));
									medication=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medication")));
									provider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									severity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Severity")));
									break;
								}else if(workSheetName.equalsIgnoreCase("EncounterTemplate")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
									templateName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplateName")));
									templateDescription= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplateDescription")));
									visitType1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitType1")));
									visitType2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitType2")));
									customSection1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CustomSection1")));
									customSection2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CustomSection2")));
									customSection3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CustomSection3")));
									customSection4 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CustomSection4")));
									restrictType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RestrictType")));
									ageRestriction1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AgeRestriction1")));
									ageRestriction2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AgeRestriction2")));
									ageRestrictionUnit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AgeRestrictionUnit")));
									selectlibrary=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("selectlibrary")));
									section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("section")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("ManagedCaredTemplate")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
									templateName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplateName")));
									templateDescription= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplateDescription")));
									medicationName1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MedicationName1")));
									DrugClassName1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MedicationDrugClassName1")));
									medicationName2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MedicationName2")));
									DrugClassName2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MedicationDrugClassName2")));
									usmedicationName1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("USMedicationName1")));
									usDrugClassName1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("USMedicationDrugClassName1")));
									usmedicationName2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("USMedicationName2")));
									usDrugClassName2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("USMedicationDrugClassName2")));
									drugType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DrugType")));
									allergyType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllergyType")));
									category=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Category")));
									display=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DisplayAs")));
									due=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Due")));
									dueType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DueType")));
									immunization=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Immunization")));
									customWidget=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CustomWidget")));
									measurement=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Measurement")));
									targetType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TargetType")));
									heightUpperLimit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HeightUpperLimt")));
									heightLowerLimit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HeightLowerLimt")));
									measurementScale=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MeasurementScale")));
									targetExceptionType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TargetExceptionType")));
									eheightUpperLimit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EHeightUpperLimt")));
									eheightLowerLimit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EHeightLowerLimt")));
									forWho=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ForWho")));
									condtionType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConditionType")));
									condtionAge=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConditionAge")));
									conditionAgeIn=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConditionAgeIn")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									type=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ContactMode")));
									referredBy=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferredBy")));
									textTemplateName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TextTemplateName")));
									numericTemplateName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NumericTemplateName")));
									questionTemplateOne=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionTemplateName")));
									questionTemplateTwo=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionTemplateName2")));
									questionTemplateThree=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionTemplateName3")));
									questionTemplateFour=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionTemplateName4")));
									deleteCategory=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DeleteCategory")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("CreateVisitSection")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									SectionName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SectionName")));
									sectionName2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SectionName2")));									
									SectionDescription= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SectionDescription")));
									Speciality = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Speciality")));
									WidgetRow1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WidgetRow1")));
									WidgetRow2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WidgetRow2")));
									WidgetRow3= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WidgetRow3")));
									WidgetRow4= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WidgetRow4")));
									visitType1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitType1")));
									FreeTextLabel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FreeTextLabel")));
									NumericLabel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NumericLabel")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									NumericLabelFormet=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NumericLabelFormet")));
									MaxValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaxValue")));
									Minvalue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Minvalue")));
									NumericLabelFormet1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NumericLabelFormet1")));
									MaxValue1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaxValue1")));
									Minvalue1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Minvalue1")));
									NumericDefaultvalue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NumericDefaultvalue")));
									QuestionLabel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionLabel")));
									QuestionAnswer=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionAnswer")));
									QuestionDefault=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionDefault")));
									TitleLabel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TitleLabel")));
									Answer1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Answer1")));
									Answer2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Answer2")));
									Answer3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Answer3")));
									Answer4=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Answer4")));
									Answer5=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Answer5")));
									Answer6=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Answer6")));
									Answer7=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Answer7")));
									Answer8=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Answer8")));
									Answer9=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Answer9")));
									answer12=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer12")));
									answer13=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer13")));
									answer14=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer14")));
									answer15=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer15")));
									answer16=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer16")));
									answer17=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer17")));
									answer18=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer18")));
									answer19=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer19")));
									answer20=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer20")));
									answer21=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer21")));
									answer22=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer22")));
									answer23=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer23")));
									answer24=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer24")));
									answer25=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer25")));
									answer26=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer26")));
									answer27=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer27")));
									answer28=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer28")));
									answer29=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer29")));
									answer30=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("answer30")));									
									assessment=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("assessment")));
									assessmenturl=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("assessmenturl")));
									assessmentscore=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("assessmentscore")));
									scoreone=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("scoreone")));
									scoretwo=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("scoretwo")));
									ComponenetName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ComponenetName")));
									ComponenetName2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ComponenetName2")));
									FreeTextLabelEdit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FreeTextLabelEdit")));
									TitleLabelEdit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TitleLabelEdit")));
									instructionWidget=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("InstructionstoUser")));
									datelabel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("datelabel")));
									dateformate	=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("dateformate")));
									QuestionLabel1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionLabel1")));
									QuestionLabel3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionLabel3")));
									QuestionLabel4=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionLabel4")));
									QuestionAnswer1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionAnswer1")));
									QuestionAnswer2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionAnswer2")));
									QuestionAnswer4=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionAnswer4")));
									QuestionLabelEdited=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionLabelEdited")));
									QuestionLabel1Edit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionLabel1Edit")));
									dateformateEdited=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("dateformateEdited")));
									InstructionstoUserEdit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("InstructionstoUserEdit")));
									freeTextComment=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FreeTextComment")));
									numericWidgetValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NumericWidgetValue")));
									numericWidgetComment=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NumericWidgetComment")));
									questionWidgetAnswer1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionWidgetAnswer1")));
									questionWidgetComment=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionWidgetComment")));
									fromDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FromDate")));
									toDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ToDate")));
									dateComment=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DateComment")));
									provider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									singlewidget=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SingleWidget")));
									sectionA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SectionA")));
									sectionB=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SectionB")));
									sectionC=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SectionC")));
									sectionD=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SectionD")));
									planAndRecom=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PlanAndRecom")));
									visitType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitType")));
									moreRequired=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MoreWidgets")));
									QuestionWidgetComment1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionWidgetComment1")));
									questionWidgetComment3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("questionWidgetComment3")));
									questionWidgetComment4=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("questionWidgetComment4")));
									scorefieldone=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("scorefieldone")));
									scorefieldtwo=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("scorefieldtwo")));
									assessmenttextbox=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("assessmenttextbox")));
									encounterdate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("encounterdate")));
									questionLabel5=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("questionLabel5")));
									questionAnswer5=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuestionAnswer5")));
									answer10=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Answer10")));
									answer11=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Answer11")));
									numericWidgetValuedecimal=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("numericWidgetValuedecimal")));
									minmumvalue1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("minmumvalue1")));
									minmumvalue2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("minmumvalue2")));
									minmumvalue3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("minmumvalue3")));
									minmumvalue4=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("minmumvalue4")));
									numericWidgetCommentreuse=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("numericWidgetCommentreuse")));
									numericWidgetCommentreuse3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("numericWidgetCommentreuse3")));
									encounterdateverfify=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("encounterdateverfify")));
									freetextcomponent=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("freetextcomponent")));
									freetextsectionnote=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("freetextsectionnote")));
									imageName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ImageName")));
									imageType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ImageType")));
									annotations=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Annotations")));
									numOfMarkers=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NumOfMarkers")));
									marker1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Marker1")));
									description1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description1")));
									marker2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Marker2")));
									description2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description2")));
									freeText=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FreeText")));
									editedImageName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EditImageName")));
									saveAsNew=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SaveAsNew")));
									imageFileName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ImageFile")));
									uncheckproblemlist=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("uncheckproblemlist")));

									
									break;
								}

							}else {
								break;
							}							
						}else {
							break;
						}
					}
				}
				if(isDataFound){					
					break;
				}
			}
			if(!isDataFound){
				Assert.fail("\nTest Data not found in test data sheet for Test Case Id  : " + testCaseId);
			}
		}catch (RuntimeException e) {
			Assert.fail("Error During Execution; Execution Failed More detaisl " + e);
			
		}
		return isDataFound;
	}
}

