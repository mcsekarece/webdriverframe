package com.nexia.selenium.genericlibrary.auditLog;

import java.lang.reflect.Field;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;

import com.sharedlibrary.ReadFromExcel;



public class AuditLogLib {
	//Payer
	public String coPay=null;
	public String specialistCoPay=null;
	public String deductible=null;
	public String coInsurance=null;

	public String  typeofCoverage =null;
	public String  billingAddr1 =null;
	public String  billingAddr2 =null;
	public String  billingCity =null;
	public String  billingZip =null;
	public String billingState =null;
	public String  billingCountry=null;
	public String payerName = null;
	public String relationshipStatus = null;
	public String releaseInformation = null;
	public String dobCA = null;
	public String telNum2 = null;
	public String telNum1 = null;
	public String planName = null;
	public String patientSearch=null;
	public String memberId=null;
	public String groupNo=null;
	
	//Encounter Template
	public String templateName=null;
	public String templateDescription=null;
	public String visitType1=null;
	
	public String testCaseId = null;
	public String switchRole=null;
	public String userAccount = null;
	public String userName = null;
	public String userPassword = null;
	public String patientId = null;
	public String patientID=null;
	public String expirationDate=null;
	public String inactivation = null;
	public String service=null;
	public String department=null;
	public String program=null;
	public String fromdate=null;
	public String todate = null;
	public String priorstate=null;
	public String outcome=null;
	public String filter = null;
	public String filterActivity = null;
	public String filterSection=null;
	public String user=null;
	public String practice = null;
	public String patientName=null;
	public String section=null;
	public String action=null;
	public String programId=null;
	public String departmentId=null;
	public String startdate=null;
	public String endDate=null;
	public String startdate1=null;
	public String endDate1=null;
	public String outcome1=null;
	public String priorstate1=null;
	public String created=null;
	public String createdby=null;
	public String lastUpdate=null;
	public String ipAddress=null;
	public String refFrom=null;
	public String referredTo=null;
	public String refDate=null;
	
	public String description=null;
	public String program1=null;
	public String reason=null;
	public String referral=null;
	public String icecode = null;
	public String string=null;
	public String casesstatus=null;
	public String datetype1=null;
	public String date1=null;
	public String datetype2=null;
	public String date2=null;
	public String searchName = null;
	public String terminationDate=null;
	public String terminationReason=null;
	public String startDateAudit=null;
	public String descriptionEdit=null;
	public String programEdit=null;
	public String departmentEdit=null;
	public String reasonEdit=null;
	public String startDateEdit=null;
	public String caseStatusEdit=null;
	public String terminationDateEdit=null;
	public String terminationReasonEdit=null;
	public String dateType1Edit=null;
	public String date1Edit=null;
	
	public String refType=null;
	public String refBy=null;
	public String refBy1=null;
	public String addr=null;
	public String addr1=null;
	public String refTo=null;
	public String diagCode=null;
	public String referralReason=null;
	public String referralDate=null;
	public String referralEndDate=null;
	public String refComments=null;
	public String speciality=null;
	public String payer = null;
	public String numVisits1=null;
	public String numVisitType=null;
	public String requestDate2=null;
	public String approvalDate2=null;
	public String authorizationNum2=null;
	public String numAuthorizedVisits2=null;
	public String startDate2=null;
	public String endDate2=null;
	public String cptSuggestBox2=null;
	
	
	public String notedate = null;
	public String category = null;
	public String patientnote = null;
	public String followup = null;
	public String notedate1 = null;
	public String patientnote1 = null;
	public String followup1 = null;
	public String notesType=null;
	public String notesValue=null;
	public String notedate2= null;
	public String followup2= null;
	public String notesdate=null;
	public String followupDate = null;
	public String workSheetName = null;
	public String terminationDateAudit=null;
	public String dateAudit=null;
	
	public String relationship=null;
	public String lastName = null;
	public String firstName = null;	
	public String middleName=null;
	public String title=null;
	public String suffix = null;
	public String residentialAddrStreet1=null;
	public String residentialAddrStreet2=null;
	public String residentialAddrcity=null;
	public String residentialAddrstate=null;
	public String residentialAddrcity1=null;
	public String residentialAddrstate1=null;
	public String residentialAddrzipCode=null;
	public String residentialAddrcountry = null;
	public String country = null;
	public String telephoneType1 = null;
	public String telephoneNo1=null;	
	public String telephoneextnNo1=null;
	public String telephoneType2 = null;
	public String telephoneNo2=null;	
	public String telephoneextnNo2=null;
	public String telephoneType3 = null;
	public String telephoneNo3=null;	
	public String telephoneextnNo3=null;
	public String email=null;	
	public String comments=null;
	public String languageSpoken=null;
	
	public String externalEmr=null;
	public String credentials=null;
	public String resetPassword=null;
	public String changedPassword=null;
	public String userName1=null;
	public String resetPswCheck=null;
	
	public String consentType=null;
	public String consentValue=null;
	public String consentName=null;
	public String validFor=null;
	public String validForType=null;
	public String restrictionLevel=null;
	public String status=null;
	public String dateSigned=null;
	public String signedBy=null;
	public String consentType1=null;
	public String groupFor=null;
	public String groupName=null;
	public String groupDescription=null;
	public String groupDefault=null;
	public String idGroup=null;
	public String idType=null;
	public String typeDescription=null;
	public String freeTextRadio=null;
	public String identifier=null;
	public String idTypeMask=null;
	public String restricted=null;
	public String expDate=null;
	public String typeDefault=null;
	public String typeStatus=null;
	public String group=null;
	public String definedListRadio=null;
	
	public String value=null;
	public String expirationdate=null;
	public String type=null;
	public String expirationdate1 = null;
	public String county=null;
	public String race=null;
	public String ethnicity=null;
	public String religion=null;
	public String citizenship=null;
	public String countryPanel=null;
	public String languagespoken=null;
	public String arrivalDate=null;
	public String languagePanel=null;
	public String interpreter=null;
	public String interpreterrequired=null;
	public String parentEthnicityPanel=null;
	public String livingArrangement=null;
	public String studentStatus=null;
	public String educationLevel=null;
	public String householdIncome=null;
	public String numPeopleText=null;
	public String householdComposition=null;
	public String homelessStatus=null;
	public String employmentStatus=null;
	public String comments1=null;
	public String homelessIndicatorCheck=null;
	public String ssi=null;
	public String sectionFilter=null;
	
	public String role=null; 
	public String defaultPractice=null;
	
	public String practiceName=null;
	public String practiceCode=null;
	public String taxId=null;
	public String groupNpi=null;
	public String primaryPhoneType1=null;
	public String primaryPhoneNumber1=null;
	public String primaryPhoneExtn1=null;
	public String primaryPhoneType2=null;
	public String primaryPhoneNumber2=null;
	public String primaryPhoneExtn2=null;
	public String primaryPhoneType3=null;
	public String primaryPhoneNumber3=null;
	public String primaryPhoneExtn3=null;
	public String address1=null;
	public String address2=null;
	public String city=null;
	public String state=null;
	public String zipcode=null;
	public String billlingaddress1=null;
	public String billingaddress2=null;
	public String billingcity=null;
	public String billingstate=null;
	public String billingzipcode=null;
	public String billingcountry=null;
	public String verifyPhoneNo1=null;
	public String verifyPhoneNo2= null;
	public String verifyPhoneNo3= null;
	public String active=null;

	public String password=null;
	public String userRole=null;
	public String practise=null;
	public String newpassword=null;
	public String userRole2=null;
	public String passwordField=null;
	public String startDate=null;
	
	public String contactValue=null;
	public String contactType=null;
	public String reason1=null;
	public String contactCompany=null;
	public String salutation=null;
	public String jobTitle=null;
	public String webAddress=null;
	public String contactLevel=null;
	
	public String contactType1=null;
	public String contactValue1=null;
	
	public String pharmacyName=null;
	public String street=null;
	public String fax=null;
	public String phone=null;
	public String fax1=null;
	
	public String referringCode=null;
	public String middleInitial=null;
	public String licenseNum=null;
	public String reportMethod=null;
	public String specialty=null;
	public String billingExclusionCheck=null;
	public String picosEnrolledCheck=null;
	public String upin=null;
	public String npi=null;
	public String taxonomyCode=null;
	public String practiceName1=null;
	public String practiceName2=null;
	public String epstreet11=null;
	public String epstreet21=null;
	public String epstreet12=null;
	public String epstreet22=null;
	public String epcity1=null;
	public String epcity2=null;
	public String epstate1=null;
	public String epstate2=null;
	public String epzipcode1=null;
	public String epzipcode2=null;
	public String epcountry1=null;
	public String epcountry2=null;
	public String epphone1=null;
	public String epphone2=null;
	public String epextn1=null;
	public String epextn2=null;
	public String epfax1=null;
	public String epfax2=null;
	public String epemail1=null;
	public String epemail2=null;
	public String section1=null;
	

	public String allergen=null;
	public String allergyType=null;
	public String onsetDate1=null;
	public String lifeStage1=null;
	public String onsetDate2=null;
	public String lifeStage2=null;
	public String onsetDate3=null;
	public String lifeStage3=null;
	public String onsetDate4=null;
	public String lifeStage4=null;
	public String startDate1=null;
	public String reaction=null;
	public String comment=null;
	public String severity=null;
	public String onsetDate=null;
	public String lifeStage=null;
	
	public String medicalCondition1=null;
	public String itemStatus=null;
	public String codingSystem=null;
	public String diagnosis=null;
	public String diagnosis1=null;
	public String resDate=null;
	public String proName=null;
	public String proDate=null;
	
	public String provider=null;
	public String cpt=null;
	public String consent=null;
	
	public String workBookName = "TestData_NewNexiaInterface_audit.xls";		
	public String sectionName = "audit";
	
	
	public Hashtable<String, Integer> excelHeaders = new Hashtable<String, Integer>();
	public Hashtable<String, Integer> excelrRowColumnCount = new Hashtable<String, Integer>();
	public Object freeText=null;
	public String prescribeName=null;
	public String direction=null;
	public String increaseDecreaseDose=null;
	public String multipleDirection=null;
	public String duration=null;
	public String refillMethod=null;
	public String refillQuantity=null;
	public String refillUnit=null;
	public String refillRoute=null;
	public String refillFrequency=null;
	public String refillUsage=null;
	public String refillUsage1=null;
	public String refillUsage2=null;
	public String refillUsage3=null;
	public String refillUsage4=null;
	public String refillduration=null;
	public String method=null;
	public String quality=null;
	public String unit=null;
	public String route=null;
	public String frequency=null;
	public String usage=null;
	public String supply=null;
	public String prescribeOn=null;
	public String refill=null;
	public String prescribedby=null;
	public String lastRefill=null;
	public String prescribe=null;
	public String medical=null;
	public String relation=null;
	public String age=null;
	public String ageAtDeath=null;
	public String treatment=null;
	public String cause=null;
	public String saveList=null;
	public String location=null;	
	
	public String addDirectionCount=null;
	public String dispense=null;
	public String unitList=null;
	public String fillon=null;
	public String ofRefill=null;
	public String notesToPharmacy=null;
	public String subPermitted=null;
	public String comePackage=null;
	public String problemSuggest=null;
	public String internalNote=null;
	public String searchWithin=null;
	public String searchWithinKM=null;
	public String searchWithinMiles=null;
	public String patient=null;
	public String zipcodecheck=null;
	public String providerName=null;
	public String patientAddress=null;
	public String providerAddress=null;
	public String dispenseWord=null;
	public String patientPhone=null;
	public String providerPhone=null;
	public String reasonForRestart=null;
	public String reasonForDelete=null;
	public String show=null;
	public String signPassword=null;
	public String alert=null;
	
	public String prematureCheck=null;
	public String sex=null;
	public String measure=null;
	public String dob=null;

	public String heightMU=null;
	public String heightInCm=null;
	public String heightInFeet=null;
	public String htResult=null;
	public String weight=null;
	public String systolicRate=null;
	public String diastolicRate=null;
	public String position=null;
	public String limb=null;
	public String cuffSize=null;
	public String time = null;
	public String bPM =null;
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
	public String weightMU = null;
	
	
	
	
	public String injection=null;
	public String lotNumber=null;
	public String dosage=null;
	public String dosageUnit=null;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
									if(workSheetName.equalsIgnoreCase("AuditLogForCreateProgram")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
	                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
	                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
	                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
	                                    filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
	                                    filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
	                                    user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
	                                    practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
	                                    ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
	                                    patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
	                                    section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
	                                    patientId=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
	                                    action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
	                                    programId=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Program")));
	                                    departmentId=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department")));
	                                    fromdate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FromDate")));
	                                    todate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ToDate")));
	                                    startdate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate")));
	                                    endDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndDate")));
	                                    priorstate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PriorState")));
	                                    outcome=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Outcome")));
	                                    startdate1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate1")));
	                                    endDate1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndDate1")));
	                                    priorstate1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PriorState1")));
	                                    outcome1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Outcome1")));
	                                    break;
									}else if (workSheetName.equalsIgnoreCase("AuditLogForCases")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
	                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
	                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
	                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
	                                    filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
	                                    patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
	                                    description=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
	                                    program=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Program")));
	                                    program1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Program1")));
	                                    department=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department")));
	                                    reason=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
	                                    referral=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Referral")));
	                                    icecode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Icecode")));
	                                    startdate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate")));
	                                    casesstatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("caseStatus")));
	                                    terminationDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TerminationDate")));
	                                    terminationReason=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Terminationreason")));
	                                    startdate1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate1")));
	                                    datetype1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DateType1")));
	                                    date1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Date1")));
	                                    datetype2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DateType2")));
	                                    date2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Date2")));
	                                    startDateAudit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDateAudit")));
	                                    terminationDateAudit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TerminationDateAudit")));
	                                    dateAudit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DateAudit")));
	                                    reason1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason1")));
	                                    descriptionEdit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DescriptionEdit")));
	                                    programEdit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProgramEdit")));
	                                    departmentEdit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DepartmentEdit")));
	                                    reasonEdit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonEdit")));
	                                    startDateEdit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDateEdit")));
	                                    caseStatusEdit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CasesstatusEdit")));
	                                    terminationDateEdit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TerminationDateEdit")));
	                                    terminationReasonEdit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TerminationReasonEdit")));
	                                    dateType1Edit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DateType1Edit")));
	                                    date1Edit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Date1Edit")));
	                                    break;
	                                }else if (workSheetName.equalsIgnoreCase("AuditLogForNotes")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
	                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
	                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
	                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
	                                    filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
	                                    patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
	                                    notedate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NoteDate")));
	                                    category=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Category")));
	                                    patientnote=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientNote")));
	                                    notesdate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NotesDate")));
	                                    notedate1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NoteDate1")));
	                                    patientnote1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientNote1")));
	                                    notedate2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NoteDate1")));
	                                    notesType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NotesType")));
										notesValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NotesValue")));
	                                    break;
	                                }else if(workSheetName.equalsIgnoreCase("AuditLogForReferrals")){
										userAccount=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										  switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
										filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
	                                 	patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
										refType= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Referral Type")));
										refBy=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Referred By")));
										addr=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Address")));
										refTo=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Referred To")));
										speciality=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Speciality")));
										diagCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Diagnosis Code")));
										referralReason=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Referral Reason")));
										referralDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Referral Start Date")));
										referralEndDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Referral End  Date")));
										refComments =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
										payer=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Payer")));
										numVisits1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllowedVisits")));
										numVisitType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Visit Type")));
										requestDate2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RequestDate")));
										approvalDate2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ApprovalDate")));
										authorizationNum2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Authorization")));
										numAuthorizedVisits2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Authr Visits")));
										startDate2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate")));
										endDate2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndDate")));
										cptSuggestBox2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Cpt")));
										break;
									}else if(workSheetName.equalsIgnoreCase("AuditLogForContact" )){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
										filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
										patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
										relationship =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Relationship")));
										title= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Title")));
										lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Last name")));
										firstName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("First name")));
										suffix=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Suffix")));
										email=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("E-mail")));
										languageSpoken=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Language")));
										comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
										residentialAddrStreet1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Address1")));
										residentialAddrStreet2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Address2")));
										residentialAddrzipCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCode")));
										residentialAddrcity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Addrcity")));
										residentialAddrstate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Addrstate")));
										country= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country")));
										telephoneType1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Primary Phone Type")));
										telephoneNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Primary Phone Number")));
										telephoneextnNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Primary Phone Extn")));
										telephoneType2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Secondary Phone Type")));
										telephoneNo2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Secondary Phone Number")));
										telephoneextnNo2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Secondary Phone Extn")));
										telephoneType3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Tertiary Phone Type")));
										telephoneNo3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Tertiary Phone Number")));
										telephoneextnNo3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Tertiary Phone Extn")));
										break;
									}else if(workSheetName.equalsIgnoreCase("AuditLogForSystemAccess")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
	                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
	                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
	                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
	                                    filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
	                                    filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
	                                    user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
	                                    practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
	                                    ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
	                                    patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
	                                    section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
	                                    action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
	                                    break;
									}else if(workSheetName.equalsIgnoreCase("AuditLogForCreateConsents")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
										filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
										patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
										consentType= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentType")));
										consentName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentName")));
										status=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("status")));
										inactivation=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reasonforinactivation")));
										dateSigned=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DateSigned")));
										signedBy=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SignedBy")));
										firstName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
										lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
										relationship =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("relationship")));
										break;
									}else if(workSheetName.equalsIgnoreCase("ConsentsEnterPrise" )){
										consentValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentValue")));
										consentType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentType")));
										consentType1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentType1")));
										break;
									}else if(workSheetName.equalsIgnoreCase("SSConsents" )){
										consentType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentType")));
										consentName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentName")));
										validFor=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidFor")));
										validForType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidForType")));
										restrictionLevel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("restrictionLevel")));
										break;
									}else if(workSheetName.equalsIgnoreCase("CreateIdentifiers")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
	                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
	                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
	                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
	                                    patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
	                                    group = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Group")));
	                                    type = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Type")));
	                                    value=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Value")));
	                                    expirationdate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Expiration Date")));
	                                    break;
									}else if(workSheetName.equalsIgnoreCase("IdentifiersAdmin")){
										patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
										groupFor=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupFor")));
										groupName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupName")));
										groupDescription=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
										groupDefault=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Default")));
										groupFor=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupFor")));
										idGroup=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IdGroup")));
										idType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IdType")));
										typeDescription=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
										freeTextRadio=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FreeTextRadio")));
										definedListRadio=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DefinedListRadio")));
										identifier=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Identifier")));
										idTypeMask=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IdTypeMask")));
										expDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpDate")));
										typeDefault=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TypeDefault")));
										restricted=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Restricted")));
										typeStatus = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
										value=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Value")));
										expirationdate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Expiration Date")));
	                                    break;

									}else if (workSheetName.equalsIgnoreCase("NewSocioEconomic")){
					                	userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
		                                userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
		                                userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
		                                switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
		                                patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
		                                race=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Race")));
	                                    ethnicity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Ethnicity")));
	                                    religion=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Religion")));
	                                    citizenship=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Citizenship")));
	                                    countryPanel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CountryPanel")));
	                                    languagePanel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LanguagePanel")));
	                                    arrivalDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ArrivalDate")));
	                                    languagespoken=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Languagespoken")));
	                                    interpreterrequired=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Interpreterrequired")));
	                                    interpreter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Interpreter")));
	                                    parentEthnicityPanel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ParentEthnicityPanel")));
	                                    livingArrangement=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LivingArrangement")));
	                                    studentStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StudentStatus")));
	                                    educationLevel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EducationLevel")));
	                                    householdIncome=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HouseholdIncome")));
	                                    numPeopleText=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NumberOfPeople")));
	                                    householdComposition=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HouseholdComposition")));
	                                     homelessIndicatorCheck = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HomelessIndicatorCheck")));
	                                    homelessStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HomelessStatus")));
	                                    ssi=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Ssi")));
	                                    employmentStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EmploymentStatus")));
	                                    comments1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CommentsForSE")));
					                    break;
					               }else if(workSheetName.equalsIgnoreCase("AuditLogForSocioEconomic")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
	                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
	                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
	                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
	                                    filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
	                                    filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
	                                    sectionFilter = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SectionFilter")));
	                                    user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
	                                    practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
	                                    ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
	                                    patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
	                                    patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
	                                    section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
	                                    action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
	                                    break;
									}else if(workSheetName.equalsIgnoreCase("EditUser" )){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
										lastName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
										firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
										userName1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName1")));
										externalEmr=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExternalEMR")));
										credentials=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Credentials")));
										resetPswCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ResetPasswordCheck")));
										resetPassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ResetPassword")));
										changedPassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ChangedPassword")));
										break;
									}else if(workSheetName.equalsIgnoreCase("AuditLogForAccessPermissions" )){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
	                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
	                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
	                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
	                                    filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
	                                    filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
	                                    sectionFilter = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SectionFilter")));
	                                    user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
	                                    practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
	                                    ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
	                                    patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
	                                    patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
	                                    section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
	                                    action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
	                                    createdby=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Createdby")));
	                                    created=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Created")));
	                                    role=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
	                                    defaultPractice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DefaultPractice")));
	                                    
	                                    break;
										
									}else if(workSheetName.equalsIgnoreCase("AuditLogForCreatePractice" )){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
										filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                                patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                active=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Active")));
										practiceName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeName")));
										practiceCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeCode")));
										taxId=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TaxId")));
										groupNpi=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupNPI")));
										email=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Email")));
										primaryPhoneType1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CommType1")));
										primaryPhoneNumber1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrimaryPhone")));
										primaryPhoneExtn1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("primaryPhoneExtension")));
										primaryPhoneType2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CommType2")));
										primaryPhoneNumber2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OtherPhone1")));
										primaryPhoneExtn2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OtherPhoneExtension1")));
										primaryPhoneType3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CommType3")));
										primaryPhoneNumber3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OtherPhone1")));
										primaryPhoneExtn3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OtherPhoneExtension1")));
										verifyPhoneNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VerifyPrimaryPhone")));
										verifyPhoneNo2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VerifyOtherPhone1")));
										verifyPhoneNo3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VerifyOtherPhone2")));
										comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
										address1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Addr1")));
										address2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Addr2")));
										city=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("City")));
										state=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("State")));
										zipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCode")));
										country=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country")));
										billlingaddress1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingAddr1")));
										billingaddress2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingAddr2")));
										billingcity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingCity")));
										billingstate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingState")));
										billingzipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingZipCode")));
										billingcountry=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingCountry")));
										break;
									}else if(workSheetName.equalsIgnoreCase("AuditLogForCreateorgProgram" )){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
										filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                                patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                active=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Active")));
		                                department=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department")));
										program=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Program")));
										description=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
										
										break;
									}else if(workSheetName.equalsIgnoreCase("AuditLogForCreateDepartment" )){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
										filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                                patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                active=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Active")));
		                                department=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department")));
										description=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
										break;
									}else if(workSheetName.equalsIgnoreCase("AuditLogForCreateUser" )){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
										filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                                patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                active=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Active")));
		                                lastName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
										firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
										userName1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName1")));
										credentials=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Credentials")));
										externalEmr=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExternalEMR")));
										password=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password1")));
										passwordField=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PasswordField")));
										startDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate")));
										userRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole")));
										practise=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practise")));
										break;
									}else if(workSheetName.equalsIgnoreCase("AuditLogForAddressBook")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
	                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
	                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
	                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
	                                    filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                                patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                active=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Active")));
	                                    contactLevel = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Contact Level")));
	                                    contactType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Contact Type")));
	                                    contactCompany = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Contact Company")));
	                                    salutation = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Salutation")));
	                                    lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Last Name")));
	                                    firstName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("First Name")));
	                                    middleName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Middle Name")));
	                                    jobTitle = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Job Title")));
	                                    department = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department")));
	                                    telephoneType1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Primary Phone Type")));
	                                    telephoneNo1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Primary Phone Number")));
	                                    telephoneextnNo1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Primary Phone Extn")));
	                                    telephoneType2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Secondary Phone Type")));
	                                    telephoneNo2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Secondary Phone Number")));
	                                    telephoneextnNo2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Secondary Phone Extn")));
	                                    telephoneType3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Tertiary Phone Type")));
	                                    telephoneNo3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Tertiary Phone Number")));
	                                    telephoneextnNo3 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Tertiary Phone Extn")));
	                                    primaryPhoneExtn1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Primary Phone Extn1")));
	                                    primaryPhoneNumber1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Primary Phone Number1")));
	                                    address1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Address1")));
	                                    address2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Address2")));
	                                    city = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("City")));
	                                    state = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("State")));
	                                    zipcode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCode")));
	                                    country = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country")));
	                                    email = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("E-mail")));
	                                    webAddress = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WebAddress")));
	                                    comments = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
	                                    createdby = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Createdby")));
	                                    break;
									}else if(workSheetName.equalsIgnoreCase("EP_AddressBook")){
										contactType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ContactType")));
										contactType1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ContactType1")));
										contactValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Contact")));
										contactValue1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Contact1")));
										break;
									}else if(workSheetName.equalsIgnoreCase("AuditLogForCreateDirectories")){
	    								userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
	                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
	                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
	                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
	                                    filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                                patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                active=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Active")));
	                                    pharmacyName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PharmacyName")));
	                                    street=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Street")));
	                                    city=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("City")));
	                                    state=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("State")));
	                                    zipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Zipcode")));
	                                    country=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country")));
	                                    telephoneNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TelephoneNo")));
	                                    phone=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Phone")));
	                                    telephoneextnNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExtnNo")));
	                                    fax=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fax")));
	                                    fax1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fax1")));
	                                    email=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Email")));
	                                    webAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Website")));
	                                    salutation=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Salutation")));
	                                    lastName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
	                                    firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
	                                    comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
	                                    createdby = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Createdby")));
	                                    break;
									}else if(workSheetName.equalsIgnoreCase("AuditLogForExternalProvider" )){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
										filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                                patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                section1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section1")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                active=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Active")));
										referringCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferringCode")));
										lastName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
										firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
										middleInitial=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MiddleInitial")));
										credentials=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Credentials")));
										licenseNum=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LicenseNumber")));
										reportMethod=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReportMethod")));
										specialty=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Specialty")));
										billingExclusionCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingExclusion")));
										picosEnrolledCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PicosEnrolled")));
										upin=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UPIN")));
										npi=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NPI")));
										taxonomyCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TaxonomyCode")));
										comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
										practiceName1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeName1")));
										epstreet11=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Street11")));
										epstreet12=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Street12")));
										epcity1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("City1")));
										epstate1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("State1")));
										epzipcode1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCode1")));
										epcountry1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country1")));
										epphone1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Phone1")));
										epextn1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Extn1")));
										epfax1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fax1")));
										epemail1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("E-mail1")));
										practiceName2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeName2")));
										epstreet21=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Street21")));
										epstreet22=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Street22")));
										epcity2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("City2")));
										epstate2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("State2")));
										epzipcode2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCode2")));
										epcountry2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country2")));
										epphone2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Phone2")));
										epextn2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Extn2")));
										epfax2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fax2")));
										epemail2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("E-mail2")));
										break;
									}	
									else if(workSheetName.equalsIgnoreCase("AuditLogForIdentifierGroups")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
										groupFor=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupFor")));
										groupName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupName")));
										groupDescription=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
										groupDefault=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Default")));
										
										filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                                patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                active=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Active")));
										break;
									}
									else if(workSheetName.equalsIgnoreCase("AuditLogForAllergy")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
										allergyType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllergyType")));
										allergen = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Allergen")));
										reaction= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reaction")));
										comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
										severity= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Severity")));
										status= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
										onsetDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSet Date")));
										lifeStage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage")));
										reason= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForDeletion")));
										onsetDate1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSet Date1")));
										lifeStage1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage1")));
										onsetDate2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSet Date2")));
										lifeStage2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage2")));
										onsetDate3= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSet Date3")));
										lifeStage3= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage3")));
										onsetDate4= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSet Date4")));
										lifeStage4= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage4")));
										filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
										filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("userName")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                createdby = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                active=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Active")));
		                                switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
										break;
									}
									else if(workSheetName.equalsIgnoreCase("AuditLogForInjection")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
										
										injection= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Injection")));
										lotNumber= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LotNumber")));
										dosage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Dosage")));
										dosageUnit= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DosageUnit")));
										
										/*allergyType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllergyType")));
										allergen = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Allergen")));
										reaction= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reaction")));
										comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
										severity= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Severity")));
										status= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
										onsetDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSet Date")));
										lifeStage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage")));
										reason= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForDeletion")));
										onsetDate1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSet Date1")));
										lifeStage1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage1")));
										onsetDate2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSet Date2")));
										lifeStage2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage2")));
										onsetDate3= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSet Date3")));
										lifeStage3= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage3")));
										onsetDate4= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSet Date4")));
										lifeStage4= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage4")));*/
										
										filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
										filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("userName")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                createdby = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                active=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Active")));
		                                switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
										break;
									}
									else if(workSheetName.equalsIgnoreCase("AuditLogForLoginFailed")){
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
										break;
									}
									else if(workSheetName.equalsIgnoreCase("AuditLogForProblemList")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
										patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
										filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                filterSection =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterSection")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                                patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                               // section1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section1")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
										medicalCondition1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medical Condtion")));
										onsetDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Onset Date")));
										itemStatus= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Item Status")));
										lifeStage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Life Stage")));
										resDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Resloved Date")));
										codingSystem= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Coding System")));
										diagnosis= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Diagnosis")));
										comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
										diagCode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DiagCode")));
										createdby = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										break;
									}else if(workSheetName.equalsIgnoreCase("AuditLogForProcedure")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
										//patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
										filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                filterSection =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterSection")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                                patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                               // section1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section1")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                active=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Active")));
										patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
										provider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
										proName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProcedureName")));
										proDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProcedureDate")));
										onsetDate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OnSetDate")));
										cpt= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CPT")));
										comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
										consent= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Consent")));
										reason= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
										createdby = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										break;
									}else if(workSheetName.equalsIgnoreCase("CreateMedication")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
										prescribe = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribe")));
										freeText = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FreeText")));
										direction = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Direction")));
										increaseDecreaseDose = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IncreaseDecreaseDose")));
										refillMethod = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillMethod")));
										refillQuantity = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillQuantity")));
										refillUnit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUnit")));
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
										supply= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Supply")));
										refillUsage4= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUsage4")));
										prescribeOn= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeOn")));
										refill= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Refill")));
										prescribedby= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribedby")));
										lastRefill= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastRefill")));
										comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
										//startDate1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate1")));
										//addby= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Addby")));
										prescribeName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeName")));
										//concentration=	readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Concentation")));
										switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
										//patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
										filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                filterSection =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterSection")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                                patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                               //section1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section1")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                active=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Active")));
		                                createdby = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
		                            	//diagCode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DiagCode")));
										break;
									}else if(workSheetName.equalsIgnoreCase("AuditLogForFamilyHistory")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
										medical= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medical")));
										cause= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Cause")));
										relation= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Relation")));
										lifeStage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LifeStage")));
										codingSystem= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CodingSystem")));
										age= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Age")));
										diagnosis= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Diagnosis")));
										diagnosis1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Diagnosis1")));
										ageAtDeath= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Ageatdeath")));
										treatment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Treatment")));
										comment= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
										saveList= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SaveList")));
										reason= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
										switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
										//patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
										filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                filterSection =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterSection")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                               // patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                               //section1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section1")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                active=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Active")));
		                                createdby = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										break;
									}else if(workSheetName.equalsIgnoreCase("AuditLogForPrescribeMedication")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
										patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
										switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
	                                    filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));		                                
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                section1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section1")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                createdby = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										prescribe = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescribe")));
										provider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
										location = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Loaction")));
										freeText = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FreeText")));
										direction = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Direction")));
										addDirectionCount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AdditionalDirectionCount")));
										increaseDecreaseDose = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IncreaseDecreaseDose")));
										refillMethod = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillMethod")));
										refillQuantity = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillQuantity")));
										refillUnit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefillUnit")));
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
										dispense = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Dispense")));
										unitList = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UnitList")));
										fillon = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fillon")));
										ofRefill = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OfRefill")));
										notesToPharmacy = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NotesToPharmacy")));
										subPermitted = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SubPermitted")));
										comePackage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ComePackage")));
										saveList = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SaveList")));
										problemSuggest = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProblemSuggest")));
										internalNote = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("InternalNote")));
										/*previousPharmacy = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PreviousPharmacy")));
										searchDatabase = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchDatabase")));*/
										searchWithin = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchWithin")));
										searchWithinKM = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchWithinKM")));
										searchWithinMiles = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchWithinMiles")));
										patient = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Patient")));
										practice  = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
										zipcodecheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Zipcodecheck")));
										zipcode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Zipcode")));
										pharmacyName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Pharmacyname")));
										prescribeName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrescribeName")));
										patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
										providerName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderName")));
										reason=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
										patientAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientAddress")));
										providerAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderAddress")));
										dispenseWord=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DispenseWord")));
										patientPhone=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientPhone")));
										providerPhone=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderPhone")));
										reasonForRestart=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForRestart")));
										reasonForDelete=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForDelete")));
										show=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Show")));
										signPassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SignPassword")));
										alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
										break;
									}else if(workSheetName.equalsIgnoreCase("NewPatientCheckIn")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										lastName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
										firstName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
										prematureCheck= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrematureCheck")));
										duration=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
										measure= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Measure")));
										status= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
										dob= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DOB")));
										sex= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sex")));
										role= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
										break;
									}
									
									
									else if(workSheetName.equalsIgnoreCase("AuditLogEncounter")){
										date1= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EncounterDate")));
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
										filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("userName")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                createdby = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                active=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Active")));
		                                switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
		                                filterSection =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterSection")));
										break;
									}else if(workSheetName.equalsIgnoreCase("AuditLogForVitals")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
	                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
	                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
	                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
	                                    patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
	                                    heightInFeet = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HeightInFeet")));
	                                    heightInCm = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HeightInCmOrInches")));
	                                    heightMU = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HeightMU")));
	                                    htResult = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HeightConversion")));
	                                    weight = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Weight")));
	                                    weightMU = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WeightMU")));
	                                   
	                                    category = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Category")));
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
	                                    filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
										filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
										filterSection =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterSection")));
										
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                createdby = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                active=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Active")));
	                                    break;
									}else if (workSheetName.equalsIgnoreCase("AuditLogForEncounterTemplate")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										switchRole= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
										templateName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplateName")));
										templateDescription= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplateDescription")));
										visitType1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitType1")));
										
										patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
	                                    filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("userName")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                active=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Active")));
		                                break;
									}else if (workSheetName.equalsIgnoreCase("AuditLogForTimeLine")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										switchRole= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
										provider = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
										
										patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
	                                    filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
		                                filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
		                                user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("userName")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                active=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Active")));
		                                break;
									}else if(workSheetName.equalsIgnoreCase("AuditLogForPayers")){
										userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
										userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
										userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
										switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
										payerName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerName")));
										relationshipStatus = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RelationshipStatus")));
										patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									    patientSearch = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientSearch")));
										memberId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MemberId")));
										groupName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupName")));
										groupNo = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupNo")));
										typeofCoverage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TypeofCoverage")));
										coPay=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoPay")));
		                                specialistCoPay=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SpecialistCoPay")));
		                                deductible=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Deductible")));
		                                coInsurance=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoInsurance")));
										billingAddr1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingAddr1")));
										billingAddr2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingAddr2")));
										billingCity = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingCity")));
										billingZip = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingZip")));
										billingState = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingState")));
										billingCountry = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingCountry")));
										telNum1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TelNum1")));
										telNum2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TelNum2")));
										planName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PlanName")));
										comment = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									    releaseInformation =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReleaseInformation")));
									    filter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Filter")));
										filterActivity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterActivity")));
										filterSection =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FilterSection")));
										user=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
		                                practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
		                                ipAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IpAddress")));
		                                patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
		                                section=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
		                                createdby = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
		                                action=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Action")));
		                                active=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Active")));
										
										break;
									}
									
									else {
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
