package com.nexia.selenium.genericlibrary.clinicalsettings;

import java.lang.reflect.Field;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;

import com.sharedlibrary.ReadFromExcel;

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
	public String numQuery = null;
	public String denQuery = null;
	public String resultList=null;
	public String switchRole=null;
	public String encounterDate=null;
	public String role=null;
	 public String selectlibrary=null;
public String section=null;
public String sectionEdit=null;
    public String addCareElement=null;
	public String description=null;
	public String targetLevel=null;
	public String checkBox=null;
	
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
	public String FreeTextLabel=null;

	public String NumericLabel = null;
		public String NumericLabelFormet = null;
		public String MaxValue = null;
		
		public String Minvalue = null;
		public String NumericDefaultvalue = null;
		public String QuestionLabel = null;
		public String QuestionAnswer = null;
		public String QuestionDefault = null;

		public String Answer1=null;
		public String Answer2=null;
		public String Answer3=null;
		public String Answer4=null;
		public String Answer5=null;
		
		public String TitleLabel=null;
		public String ComponenetName=null;
		public String FreeTextLabelEdit=null;
		public String TitleLabelEdit=null;
	
	public String workSheetName = null;
	public String workBookName = "TestData_ClinicalSettings.xls";		
	public String sectionName = "clinicalsettings";
	
	public Hashtable<String, Integer> excelHeaders = new Hashtable<String, Integer>();
	public Hashtable<String, Integer> excelrRowColumnCount = new Hashtable<String, Integer>();
	
	
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
									addCareElement=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CareElementName")));;
									break;
								}
								else if(workSheetName.equalsIgnoreCase("CreateVisitSection")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									SectionName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SectionName")));
									SectionDescription= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SectionDescription")));
									Speciality = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Speciality")));
									WidgetRow1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WidgetRow1")));
									WidgetRow2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WidgetRow2")));
									WidgetRow3= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WidgetRow3")));
									WidgetRow4= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WidgetRow4")));
									visitType1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitType1")));
									FreeTextLabel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FreeTextLabel")));
									NumericLabel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NumericLabel")));
									NumericLabelFormet=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NumericLabelFormet")));
									MaxValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaxValue")));
									Minvalue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Minvalue")));
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
									ComponenetName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ComponenetName")));
									FreeTextLabelEdit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FreeTextLabelEdit")));
									TitleLabelEdit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TitleLabelEdit")));
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
			e.printStackTrace();
		}
		return isDataFound;
	}
}

