package com.nexia.selenium.genericlibrary.chartprevisit;
import java.lang.reflect.Field;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;
import com.sharedlibrary.ReadFromExcel;

/**
* @class  		ChartPreVisitLibUnitTest
* This Class will contain reusable functions which can be used in Nexia Interface
* @category 	Charts
* @since  	     Sep 12, 2010
*/
public class ChartPreVisitLibUnitTest {
	public String testCaseId = null;
	public String userAccount = null;
	public String userName = null;
	public String userPassword = null;
	public String switchRole=null;
	public String patientID = null;
	public String workSheetName = null;
	public String workBookName = "TestData_UnitTest_ChartPrevisit.xls";		
	public String sectionName = "chartprevisit";
	
	public String  test=null;
	public String  oneTimeOnly=null;
	public String  freeText=null;
	public String  responsibleProvider=null;
	public String  location=null;
	public String  increaseDose=null;
	public String  refillmethod=null;
	public String  refillQuantity=null;
	public String  refillUnit=null;
	public String  refillUnitCa=null;
	
	public String  refillRoute=null;
	public String  refillFrequency=null;
	public String  reduce=null;
	public String  reduceUsage=null;
	public String  reduceQuantity=null;
	public String  refillDuration=null;
	public String  reduceDuration=null;
	public String  stopQuantity=null;
	public String  stop=null;
	public String  multipleDirections=null;
	public String  refillUsage=null;
	public String  refillmethod1=null;
	public String  refillQuantity1=null;
	public String  refillUnit1=null;
	public String  refillRoute1=null;
	public String  refillFrequency1=null;
	public String  refillDuration1=null;
	public String  refillUsage1=null;
	public String  adddirection=null;
	public String  dispense=null;
	public String  dispenseUnit=null;
	public String  fillOn=null;
	public String  refills=null;
	public String  refillDays=null;
	public String  pharmacistDuration=null;
	public String  pharmacistMethod=null;
	public String  pharmacistQuantity=null;
	public String  pharmacistRoute=null;
	public String  pharmacistUnit=null;
	public String  pharmacistFrequency=null;
	public String  pharmacistDirection=null;
	public String  pharmacistUsage=null;
	public String  notesToPharmacy=null;
	public String  internalNotes=null;
	public String  problem=null;
	public String  searchDatabase=null;
	public String  searchWithin=null;
	public String  zipText=null;
	public String  maxLength=null;
	public String prescribeCa=null;
	
	public String  taskName=null;
	public String  instructions=null;
	public String  dueIn=null;
	public String  dueInUnit=null;
	public String  urgentTask=null;
	public String  assignTask=null;
	public String  moreOptions=null;
	public String  asignToUserRole=null;
	public String  recurring=null;
	public String  notifyMe=null;
	public String  notifyMeUnit=null;
	public String  notifyPatient=null;
	public String  notifyPatientUnit=null;
	public String  immediate=null;
	public String  quickList=null;

	public String consentCheck=null;
	public String injection=null;
	public String lotNumber=null;
	public String expiryData=null;
	public String dosage=null;
	public String dosageUnit=null;
	public String consent=null;
	public String site=null;
	public String adminOn=null;
	public String adminOnCa=null;
	public String adminBy=null;
	public String cptCode1=null;
	public String cptCode2=null;
	public String reaction=null;
	public String route=null;
	public String comment=null;
	
	public String refused=null;
	public String immunization=null;
	public String refusedDate=null;
	public String admin=null;
	public String vaccine=null;
	public String show=null;
	public String series=null;
	public String seriesof=null;
	public String vaccine1=null;
	public String immunization1=null;
	public String cpt1=null;
	public String cpt2=null;
	
	public String proName=null;
	public String cpt=null;
	public String lifeStage=null;
	public String onsetDate=null;
	public String proDate=null;
	public String proDateCa=null;
	public String onsetDateCa=null;
	
	public String announcements=null;
	public String noteToeSelf=null;
	
	public String saveList=null;
	
	public String medicalCondition=null;
	public String itemStatus=null;
	public String codingSystem=null;
	public String diagnosis=null;
	public String resDate=null;
	public String medical=null;
	public String cause=null;
	public String relation=null;
	public String age=null;
	public String ageAtDeath=null;
	public String treatment=null;
	public String reason=null;

	public String startDate=null;
	public String startDateCa=null;
	public String supply=null;
	public String refillUsage4=null;
	public String prescribeOn=null;
	public String prescribeOnCa=null;
	public String refill=null;
	public String prescribedby=null;
	public String lastRefill=null;
	public String lastRefillCa=null;
	public String prescribe=null;
	public String prescribeName=null;
	public String provider=null;
	public String loaction=null;
	public String direction=null;
	public String increaseDecreaseDose=null;
	public String refillMethod=null;
	public String usage=null;
	public String duration=null;
	public String refillUsage2=null;
	public String refillUsage3=null;
	public String multipleDirection=null;
	public String refillduration=null;
	public String method=null;
	public String quality=null;
	public String unit=null;
	public String frequency=null;
	
	public String status=null;
	public String severity=null;
	public String allergen=null;
	
	public String type=null;
	public String item=null;
	public String detailsNum=null;
	public String detailsText=null;
	public String period=null;
	public String year=null;
	public String startAge=null;
	public String stopAge=null;
	public String historyType=null;
	
	public String accNumber=null;
	public String rProvider=null;
	public String oProvider=null;
	public String labName=null;
	public String cDate=null;
	public String cTime=null;
	public String notes=null;
	public String testName=null;
	public String result=null;
	public String low=null;
	public String high=null;
	public String units=null;
	public String comments=null;
	
	public String labTestName=null;
	public String labTestComments1=null;
	public String labTestComments2=null;
	public String sendTo=null;
	public String patientId=null;
	public String encounterDate=null;
	

	public String heightInFeet = null;
	public String heightMU = null;
	public String heightInCm = null;
	public String weightMU = null;
	public String weight = null;
	public String systolicRate = null;
	public String diastolicRate = null;
	public String position = null;
	public String limb = null;
	public String cuffSize = null;
	public String time = null;
	public String bPM =null;
	public String description = null;
	public String rhythm = null;
	public String waist = null;
	public String waistMU = null;
	public String temperature = null;
	public String tempRU = null;
	public String bloodSuger = null;
	public String rR_BPM = null;
	public String bSUnit = null;
	public String repositoryRate = null;
	public String oxygenSaturation = null;
	public String pEFR = null;
	public String pre_bronchodilator = null;
	public String addDirectionCount = null;
	public String authorization = null;
	public String validationFieldID=null;	
	public String validationMessage=null;
	
	public String reference=null;
	public String bookMark=null;
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
	 * fetchCodingInterfaceTestData
	 * function for fetching Test data based on test case id  

	 * @since  	     Apr 30, 2010	  
	 */
    
	public boolean fetchHomeTestData(){
		
		ReadFromExcel readTestData = new ReadFromExcel();
		boolean isDataFound = false;
		testCaseId = testCaseId != null ? testCaseId.trim() : "";
		try{
			  //******************************************************************//
			  //Fetching the test data for New Nexia Interface
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
					for(int c = 0; c < excelrRowColumnCount.get("ColumnCount"); c++) {						
						cell = row.getCell(excelHeaders.get("TestID"));
						if(cell != null){
							temptestCaseId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestID")));
							if(temptestCaseId.equals(testCaseId)){
								isDataFound = true;
								if(workSheetName.equalsIgnoreCase("UnitTest_Prescribe_Medication")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
                                    responsibleProvider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ResponsibleProvider")));
                                    location=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location")));
                                    test=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Test")));
                                    oneTimeOnly=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OneTimeOnly")));
									freeText=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FreeText")));
									increaseDose=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IncraseDose")));
									refillmethod=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillMethod")));
									refillQuantity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillQuantity")));
									refillUnit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUnit")));
									refillRoute=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillRoute")));
									refillFrequency=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillFrequency")));
									reduce=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reduce")));
									reduceUsage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReduceUsage")));
									reduceQuantity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReduceQuantity")));
									refillDuration=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillDuration")));
									reduceDuration=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReduceDuration")));
									stopQuantity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StopQuantity")));
									stop=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Stop")));
									multipleDirections=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MultipleDirections")));
									refillUsage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage")));
									refillmethod1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillMethod1")));
									refillQuantity1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillQuantity1")));
									refillUnit1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUnit1")));
									refillRoute1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillRoute1")));
									refillFrequency1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillFrequency1")));
									refillDuration1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillDuration1")));
									refillUsage1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage1")));
									adddirection=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AddDirection")));
									dispense=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Dispense")));
									dispenseUnit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DispenseUnit")));
									fillOn=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FillOn")));
									refills=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Refills")));
									refillDays=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillDays")));
									pharmacistDuration=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PharmacistDuration")));
									pharmacistMethod=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PharmacistMethod")));
									pharmacistQuantity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PharmacistQuantity")));
									pharmacistRoute=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PharmacistRoute")));
									pharmacistUnit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PharmacistUnit")));
									pharmacistFrequency=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PharmacistFrequency")));
									pharmacistDirection=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PharmacistDirection")));
									pharmacistUsage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PharmacistUsage")));
									notesToPharmacy=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NotesToPharmacy")));
									internalNotes=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("InternalNotes")));
									problem=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Problem")));
									searchDatabase=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchDatabase")));
									searchWithin=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchWithin")));
									zipText=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipText")));
									maxLength=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaxLength")));
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
									reason=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_Task")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
	                                userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
	                                userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
	                              	taskName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TaskName")));
									instructions=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Instructions")));
									dueIn=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DueIn")));
									dueInUnit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DueInUnit")));
									urgentTask=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UrgentTask")));
									assignTask=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AssignTask")));
									moreOptions=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MoreOptions")));
									asignToUserRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AssignToUserRole")));
									recurring=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Recurring")));
									notifyMe=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NotifyMe")));
									notifyMeUnit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NotifyMeUnit")));
									notifyPatient=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NotifyPatient")));
									notifyPatientUnit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NotifyPatientUnit")));
									immediate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Immediate")));
									quickList=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("QuickList")));
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_Injection")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									consentCheck= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentCheck")));
									injection= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Injection")));
									lotNumber= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LotNumber")));
									expiryData = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpiryData")));
									dosage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Dosage")));
									dosageUnit= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DosageUnit")));
									consent= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Consent")));
									site= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Site")));
									adminOn= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AdminOn")));
									adminBy= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AdminBy")));
									cptCode1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CptCode1")));
									cptCode2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CptCode2")));
									reaction= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reaction")));
									comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									route= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Route")));
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("UnitTest_Procedure")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									proName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProcedureName")));
									proDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProcedureDate")));
									onsetDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSetDate")));
									proDateCa= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProcedureDateCa")));
									onsetDateCa= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSetDateCa")));
									cpt= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CPT")));
									comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									consent= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Consent")));
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("ProviderHomePage")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									noteToeSelf=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NoteToeSelf")));
									announcements=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Announcement")));
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
									break;
								}

								else if(workSheetName.equalsIgnoreCase("ProviderHomePage")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									noteToeSelf=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NoteToeSelf")));
									announcements=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Announcement")));
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("UnitTest_Immunization")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									refused= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Refused")));
									immunization= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Immunization")));
									refusedDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefusedDate")));
									admin= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Admin")));
									vaccine= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Vaccine")));
									series= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Series")));
									seriesof= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("seriesof")));
									consentCheck= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentCheck")));
									lotNumber= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LotNumber")));
									expiryData = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpiryData")));
									dosage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Dosage")));
									dosageUnit= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DosageUnit")));
									consent= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Consent")));
									site= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Site")));
									adminOn= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AdminOn")));
									adminOnCa= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AdminOnCA")));
									adminBy= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AdminBy")));
									cptCode1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CptCode1")));
									cptCode2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CptCode2")));
									reaction= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reaction")));
									comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									route= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Route")));
									saveList= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SaveList")));
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("UnitTest_ProblemList")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									medicalCondition= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medical Condtion")));
									onsetDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Onset Date")));
									itemStatus= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Item Status")));
									lifeStage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage")));
									resDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Resloved Date")));
									codingSystem= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Coding System")));
									diagnosis= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Diagnosis")));
									comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("UnitTest_History")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									test=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Test")));
									medical= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medical")));
									cause= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Cause")));
									relation= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Relation")));
									lifeStage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LifeStage")));
									codingSystem= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CodingSystem")));
									age= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Age")));
									diagnosis= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Diagnosis")));
									//diagnosis1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Diagnosis1")));
									ageAtDeath= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Ageatdeath")));
									treatment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Treatment")));
									comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									saveList= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SaveList")));
									reason= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
									maxLength=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaxLength")));
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_Medication")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									test=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Test")));
									patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									prescribe = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribe")));
									prescribeCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeCa")));
									freeText = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FreeText")));
									direction = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Direction")));
									increaseDecreaseDose = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IncreaseDecreaseDose")));
									refillMethod = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillMethod")));
									refillQuantity = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillQuantity")));
									refillUnit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUnit")));
									refillUnitCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUnitCa")));
									refillRoute = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillRoute")));
									refillFrequency = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillFrequency")));
									refillUsage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage")));
									usage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Usage")));
									duration = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
									refillUsage1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage1")));
									refillUsage2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage2")));
									refillUsage3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage3")));
									multipleDirection = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MultipleDirection")));
									refillduration = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Refillduration")));
									method = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Method")));
									quality = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Quality")));
									unit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Unit")));
									route = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Route")));
									frequency = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Frequency")));
									startDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate")));
									startDateCa= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDateCa")));
									supply= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Supply")));
									refillUsage4= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage4")));
									prescribeOn= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeOn")));
									prescribeOnCa= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeOnCa")));
									refill= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Refill")));
									prescribedby= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribedby")));
									lastRefill= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastRefill")));
									lastRefillCa= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastRefillCa")));
									maxLength=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaxLength")));
									comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("UnitTest_Allergy")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									allergen= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Allergen")));
									reaction= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reaction")));
									comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									severity= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Severity")));
									status = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
									onsetDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSet Date")));
									lifeStage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage")));
									validationFieldID= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("UnitTest_SocialHistory")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									type = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Type")));
									status = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
									item = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Item")));
									detailsNum = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DetailsNum")));
									detailsText = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DetailsText")));
									period = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Period")));
									year = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("year")));
									startAge = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartAge")));
									historyType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HistoryType")));
									stopAge = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StopAge")));
									lifeStage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LifeStage")));
									comment=  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									validationFieldID= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
									break;
								}
                 				else if(workSheetName.equalsIgnoreCase("UnitTestLabOrder" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
                                    test = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Test")));
                                    labTestName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LabTestName")));
                                    labTestComments1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
                                    sendTo= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SendTo")));
                                    maxLength=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaxLength")));
                                    break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_EncounterOverAll" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
                                    encounterDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EncounterDate")));
                                    validationFieldID= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
                                    validationMessage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
                                    break;
								}
								else if(workSheetName.equalsIgnoreCase("UnitTest_Vitals")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
                                    heightInFeet = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HeightInFeet")));
                                    heightInCm = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HeightInCmOrInches")));
                                    heightMU = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HeightMU")));
                                    weight = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Weight")));
                                    weightMU = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WeightMU")));
                                    systolicRate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SystolicRate")));
                                    diastolicRate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DiastolicRate")));
                                    position = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Position")));
                                    limb = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Limb")));
                                    cuffSize = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Cuff Size")));
                                    time = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Time")));
                                    bPM = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BPM")));
                                    description = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
                                    rhythm = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Rhythm")));
                                    waist = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Waist")));
                                    waistMU = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WaistMU")));
                                    temperature = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Temperature")));
                                    tempRU = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TempRU")));
                                    location = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location")));
                                    bloodSuger = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BloodSuger")));
                                    bSUnit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BSUnit")));
                                    repositoryRate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Repository Rate")));
                                    rR_BPM = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RR-BPM")));
                                    oxygenSaturation = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OxygenSaturation")));
                                    pEFR = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PEFR")));
                                    pre_bronchodilator = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Pre-bronchodilator")));
                                    validationFieldID= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
                                    validationMessage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
                                    break;
								}
								else if(workSheetName.equalsIgnoreCase("UnitTest_DiOrder" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
                                    test = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Test")));
                                    labTestName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LabTestName")));
                                    labTestComments1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
                                    authorization = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Authorization")));
                                    maxLength=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaxLength")));
                                    
                                    validationFieldID= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
                                    validationMessage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
                                    break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_LabReportManual" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    patientID = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
                                    accNumber=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccessionNumber")));
                                	rProvider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Rprovider")));
                                	oProvider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Oprovider")));
                                	labName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReportingLab")));
                                	cDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CollectionDate")));
                                	cTime=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CollectionTime")));
                                	notes=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Notes")));
                                	testName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestName")));
                                	result=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Result")));
                                	low=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Low")));
                                	high=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("High")));
                                	comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Units")));
                                	units=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
                                	validationFieldID= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
                                    validationMessage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
                                    break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_MedWarnings" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
                                    provider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("provider")));
                                    loaction = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Loaction")));
                                    prescribe= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribe")));
                                    prescribeName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeName")));
                                    reason = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
                                    maxLength=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaxLength")));
                                    validationFieldID= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
                                    validationMessage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
                                    test= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Test")));
                                    break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_EncounterReference" )){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
                                    reference = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reference")));
                                    bookMark = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BookMark")));
                                    validationFieldID= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
                                    validationMessage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
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
			e.printStackTrace();
			Assert.fail("Error During Execution; Execution Failed More details " + e);
		}
		return isDataFound;
	}

	/**
	 * checkAlertMessage
	 * function for checking the alert message with the expected one  

	 * @since  	     Apr 30, 2010	  
	 */
	
	public boolean checkAlertMessage(String alertText, String actualText){
		
		if(alertText == null || actualText.equals("") ){
			return false;
		}
		alertText = alertText.replaceAll("\\s","");
		actualText = actualText.replaceAll("\\s", "");
		
		if(alertText.toLowerCase(new java.util.Locale("en", "US")).contains(actualText.toLowerCase(new java.util.Locale("en", "US")))){
			return true;
		}else {
			return false;
		}
	}	
}