package com.nexia.selenium.genericlibrary.demographics;

import java.lang.reflect.Field;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;

import com.sharedlibrary.ReadFromExcel;

/**
 *  HomeLibUnitTest
 * This Class will contain reusable functions which can be used in Nexia Interface
<<<<<<< HEAD
 * @category 	Charts
=======
 * @Category 	HomeLibUnitTest
>>>>>>> jagmit/master
 * @since  	     Apr 30, 2010
 */

public class HomeLibUnitTest {
	public String testCaseId = null;
	public String userAccount = null;
	public String userName = null;
	public String userPassword = null;
	public String patientId = null;
	public String patientHearabout=null;
	public String patientProvider=null;
	public String patientProgram=null;
	public String patientReferraldate=null;
	
	
	public String workSheetName = null;
	public String workBookName = "TestData_UnitTest_Home.xls";		
	public String sectionName = "home";
	
	public String unit=null;
	public String field=null; 
	
	public String patientID=null;
	public String patientIdchart = null;
	public String rosteredCheck = null;
	public String canadianProvince=null;
	public String hCN=null;
	public String expireDate = null;
	public String primaryLocation=null;
	public String responsibleProvider = null;
	public String pcpCheck = null;
	public String lastName = null;
	public String firstName = null;	
	public String middleName=null;
	public String title=null;
	public String suffix = null;
	public String alias1=null;
	public String alias2=null;
	public String dob=null;
	public String estimatedCheck=null;
	public String prematureCheck=null;
	public String duration=null;
	public String measure=null;
	public String sex=null;
	public String ssn = null;
	public String newBornCheck = null;
	public String maritalStatus = null;
	public String status=null;
	public String statusDate=null;
	public String reasonForInactivation=null;	
	public String residentialAddrStreet1=null;
	public String residentialAddrStreet2=null;
	public String residentialAddrcity=null;
	public String residentialAddrstate=null;
	public String residentialAddrzipCode=null;	
	public String residentialAddrcountry=null;
	public String residentialAddrCounty=null;
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
	public String contactMailCheck = null;
	public String contactPreferences=null;
	public String preference2Present=null;
	public String contactPreference2=null;
	public String customMandatory=null;
	public String sameAsResidentialAddressCheck=null;
	public String mailingAddressStreet1=null;
	public String mailingAddressStreet2=null;
	public String mailingAddressCity=null;
	public String mailingAddressState=null;
	public String mailingAddressZipcode=null;	
	public String mailingAddressCountry=null;
	public String comments=null;
	public String county=null;
	public String validationFieldID=null;	
	public String validationMessage=null;
	
	public String relationship=null;
	public String consentType = null;
	public String consentName = null;
	public String dateSigned = null;
	public String signedBy= null;
	public String expirationDate=null;
	public String inactivation = null;
	public String alertMessage = null;
	public String alertMessageCA = null;
	
	public String patientnote=null;
	public String notedate=null;
	public String followup=null;
	public String category = null;
	
	public String contactType = null;
	public String contactType1 = null;
	public String country=null;
	public String description=null;
	public String languageSpoken=null;
	
	public String testDescription=null;
	public String suggestBox = null;
	public String referralType = null;
	public String referredFrom = null;
	public String referredTo = null;
	public String billing = null;
	public String authorization  = null;
	public String payer = null;
	public String referralstatus = null;
	public String reasonforreferral = null;
	
	public String  startDateUS = null;
	public String  startDateCA = null;
	public String  endDateUS = null;
	public String  endDateCA = null;
	public String  endDate = null;
	
	public String daterequest = null;
	public String dateapproved = null;
	public String visitallowed = null;
	public String visitscheduled = null;
	public String visitused = null;
	public String amount = null;
	public String nextappt = null;
	
	
	public String department=null;
	public String program=null;
	public String fromdate=null;
	public String todate=null;
	public String priorstate=null;
	public String outcome=null;
	
	public String race=null;
	public String ethnicity=null;
	public String religion=null;
	public String citizenship=null;
	public String countryPanel=null;
	public String languagePanel=null;
	public String arrivalDate=null;
	public String languagespoken=null;
	public String interpreterrequired=null;
	public String interpreter=null;
	public String parentEthnicityPanel=null;
	public String livingArrangement=null;
	public String studentStatus=null;
	public String educationLevel=null;
	public String householdIncome=null;
	public String numPeopleText=null;
	public String householdComposition=null;
	public String homelessIndicatorCheck=null;
	public String homelessStatus=null;
	public String lanuage=null;
	public String service = null;
	public String poverty = null;
	public String rural = null;
	public String aboriginalPeopels=null;
	public String raclized = null;
	public String ageGroup=null;
	public String jobCode= null;
	public String occupation=null;
	public String ssi=null;
	public String employmentStatus=null;
	public String comments1=null;
	public String raceOtherValue=null;
	public String religionOtherValue=null;
	public String citizenshipOtherValue=null;
	public String educationLevelOtherValue=null;
	public String householdCompositionOtherValue=null;
	public String searchpatient=null;
	public String reason=null;
	public String startdate=null;
	public String datetype1=null;
	public String date1=null;
	public String datetype2=null;
	public String date2=null;
	public String caseStatus=null;
	public String caseStatus1=null;
	public String referral=null;
	public String dischargeDate=null;
	public String disposition=null;
	public String terDate=null;
	public String terStatus=null;
	public String group = null;
	public String type = null;
	public String typeCA = null;
	public String value = null;
	public String expirationdate=null;
	public String newPassword=null;
	public String newConfirmPassword=null;
	public String currentPassword=null;
	public String teamName=null;
	public String searchMember=null;
	public String itemCheckBox=null;
	public String itemCheckBox1=null;
	public String pcpCheckbox=null;
	public String teamLead = null;
	public String teamMember=null;
	public String role = null;
	public String duration1=null;
	public String endNumber = null;
	public String timeperiod=null;
	public String location = null;
	public String specialty=null;
	public String reasonForDelete=null;
	public String alert=null;
	public String alertCA=null;
	public String refType=null;
	public String refBy=null;
	public String addr=null;
	public String refTo=null;
	public String diagCode=null;
	public String referralReason=null;
	public String referralDate=null;
	public String referralEndDate=null;
	public String refComments=null;
	public String speciality=null;
	public String numVisits1=null;
	public String numVisitType=null;
	public String requestDate2=null;
	public String approvalDate2=null;
	public String authorizationNum2=null;
	public String numAuthorizedVisits2=null;
	public String startDate2=null;
	public String endDate2=null;
	public String cptSuggestBox2=null;
	public String auditStartDate=null;
	public String auditEndDate=null;
	public String activityFilter=null;
	public String userFilter=null;
	public String patientFilter=null;
	public String sectionFilter=null;
	
	public String entrolled=null;
	public String entrolledDate=null;
	
	public String refFrom=null;
	public String refDate=null;
	
	public String entrolledTo=null;
	public String enttolledDate=null;
	
	public String groupFor=null;
	public String  groupName=null;
	public String  groupNo=null;
	public String  anotherPatientId=null;
	public String  memberId=null;
	
	
	public String  groupDescription=null;
	public String  groupDefault=null;
	
	public String  idGroup=null;
	public String  idType=null;
	public String  typeDescription=null;
	public String  freeTextRadio=null;
	public String  definedListRadio=null;
	public String  identifier=null;
	public String  idTypeMask=null;
	public String expDate=null;
	public String  typeDefault=null;
	public String  restricted=null;
	public String  typeStatus=null;
	

	public String startDate=null;
	public String supply=null;
	public String refillUsage4=null;
	public String prescribeOn=null;
	public String refill=null;
	public String prescribedby=null;
	public String lastRefill=null;
	public String date=null;
	public String comment=null;
	public String eligibilityStatus=null;
	
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
	public String relationAddr1 = null;
	public String relationAddr2 = null;
	public String relationState = null;
	public String relationZipCode = null;
	public String relationCountry = null;
	public String relationSex = null;
	
	public String dobCA = null;
	public String telNum2 = null;
	public String telNum1 = null;
	public String planName = null;
	
	public String newSeriesStartDate = null;
	public String newSeriesEndDate = null;
	public String defaultEndDateUS = null;
	public String defaultEndDateCA = null;
	
	
	
	public String roleType=null;
	public String reasonForDeleteType=null;
	
	public String notesType=null;
	public String notesValue=null;
	public String raceOther=null;
	
	public String switchRole=null;
	
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
								if(workSheetName.equalsIgnoreCase("UnitTest_FV_NP_Register")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    patientHearabout=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SuggestBox1")));
                                    patientProvider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SuggestBox2")));
                                    patientProgram=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SuggestBox3")));
                                    patientReferraldate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RefferralDate")));
                                    validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
								}else if(workSheetName.equalsIgnoreCase("UnitTest_FV_PC_Info" )){									
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
                                    patientnote=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("patientNote")));
                                    patientIdchart = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientIdchart")));
                                  	primaryLocation=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrimaryLocation")));	
                                    responsibleProvider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ResponsibleProvider")));
                                    pcpCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PCPCheck")));
                                    lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
                                    firstName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
                                    middleName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MiddleName")));
                                    title=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Title"))); 
                                    suffix=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Suffix")));
                                    alias1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alias1")));
									alias2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alias2")));    
									dob=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DOB")));		
									estimatedCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EstimatedCheck")));		
									prematureCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrematureCheck")));
									duration=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
									measure=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Measure")));
									sex=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sex")));
									maritalStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaritalStatus")));
									status=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
									statusDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StatusDate")));
									reasonForInactivation = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForInactivation")));
									livingArrangement=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LivingArrangement")));
									raceOther=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RaceOther")));
									residentialAddrStreet1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ResidentialAddrStreet1")));
									residentialAddrStreet2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ResidentialAddr2Street2")));
									residentialAddrcity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("City")));
									residentialAddrstate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("State")));
									residentialAddrzipCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCode")));
									residentialAddrcountry = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country")));
									residentialAddrCounty= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("County")));
									telephoneType1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PhoneNoType1")));
									telephoneNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TelNum1")));
									telephoneextnNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExtnNum1")));
									telephoneType2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PhoneNoType2")));
									telephoneNo2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TelNum2")));
									telephoneextnNo2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExtnNum2")));
									telephoneType3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PhoneNoType3")));
									telephoneNo3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TelNum3")));
									telephoneextnNo3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExtnNum3")));									
									email=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("email")));
									contactPreferences=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ContactPreferences")));
									preference2Present=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Preference2present")));
									contactPreference2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ContactPreference2")));
									sameAsResidentialAddressCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SameAsResidentialAddressCheck")));
									mailingAddressStreet1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MailingAddressStreet1")));
									mailingAddressStreet2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MailingAddressStreet2")));
									mailingAddressCity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MailingAddressCity")));
									mailingAddressState=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MailingAddressState")));
									mailingAddressZipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MailingAddressZipcode")));									
									mailingAddressCountry=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaillingAddressCountry")));
									comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
                                    break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_FV_PC_Consents")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
									consentType= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentType")));
									consentName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentName")));
									status=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("status")));
									inactivation=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason for inactivation")));
									dateSigned=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DateSigned")));
									signedBy=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SignedBy")));
									firstName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
									lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
									relationship =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("relationship")));
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
									break;
								}else if (workSheetName.equalsIgnoreCase("UnitTest_FV_PC_Info_Notes")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
                                    notedate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("notedate")));
                                    category=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Category")));
                                    patientnote=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("patientnote")));
								    followup=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("followupdate")));
								    alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
				                    alertMessage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
				                    
				                    alertCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresentCA")));
				                    alertMessageCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessageCA")));
				                    
				                    break;
								}else if (workSheetName.equalsIgnoreCase("AdminNotes")){
									notesType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NotesType")));
									notesValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NotesValue")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_FV_PC_Info_Household")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
                                    searchpatient=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchPatient")));
                                    alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Result")));
				                    alertMessage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Result Message")));
                                    break;
								}else if (workSheetName.equalsIgnoreCase("UnitTest_FV_PC_Info_Cases")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
                                    description=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
                                    program=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Program")));
                                    department=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department")));
                                    reason=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
                                    referral=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Referral")));
                                    startdate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate")));
                                    caseStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Case Status")));
                                    caseStatus1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CaseStatus1")));
                                    dischargeDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Discharge Date")));
                                    disposition=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Disposition")));
                                    terDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Termination Date")));
                                    terStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Termination Status")));
                                    datetype1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DateType1")));
                                    date1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Date1")));
                                    datetype2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DateType2")));
                                    date2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Date2")));
                                    alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert Message")));
                                    break;
				                }else if(workSheetName.equalsIgnoreCase("UnitTest_FV_PC_Contacts" )){
                                    userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
                                    contactType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Contact Type")));
                                    contactType1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ContactType1")));
                                    relationship =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Relationship")));
									title= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Title")));
									lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Last name")));
									firstName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("First name")));
									suffix=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Suffix")));
									telephoneType1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Primary Phone Type")));
									telephoneNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Primary Phone Number")));
									telephoneextnNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Primary Phone Extn")));
									telephoneType2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Secondary Phone Type")));
									telephoneNo2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Secondary Phone Number")));
									telephoneextnNo2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Secondary Phone Extn")));
									telephoneType3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Tertiary Phone Type")));
									telephoneNo3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Tertiary Phone Number")));
									telephoneextnNo3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Tertiary Phone Extn")));
									residentialAddrStreet1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Address1")));
									residentialAddrStreet2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Address2")));
									residentialAddrcity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("City")));
									residentialAddrstate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("State")));
									residentialAddrzipCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCode")));
									country= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country")));
									county=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("County")));
									email=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("E-mail")));
									languageSpoken=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Language")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert Message")));
									alertMessageCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert MessageCA")));
									description=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Test Description")));
                                    break;
				                }else if(workSheetName.equalsIgnoreCase("UnitTest_FV_PC_Referrals" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									testDescription=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestDescription")));
									suggestBox = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SuggestBox")));
									referralType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferralType")));
									referredFrom=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferredFrom")));
									referredTo=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferredTo")));
									authorization=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Authorization")));
									payer=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Payer")));
									referralstatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Referralstatus")));
									reasonforreferral=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reasonforreferral")));
									startDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate")));
									endDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndData")));
									daterequest=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Daterequest")));
									dateapproved=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Dateapproved")));
									visitallowed=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Visitallowed")));
									visitscheduled=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Visitscheduled")));
									visitused=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Visitused")));
									amount=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Amount")));
									nextappt=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Nextappt")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
				                    alertMessage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
								}else if (workSheetName.equalsIgnoreCase("UnitTest_FV_PC_Programs")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
                                    department=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department")));
                                    program=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Program")));
                                    fromdate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FromDate")));
                                    todate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ToDate")));
                                    priorstate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PriorState")));
                                    outcome=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Outcome")));
                                    refFrom=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferralSource")));
                                    referredTo=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferredTo")));
                                    refDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferralDate")));
				                    alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
				                    alertMessage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
				                    alertMessageCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessageCA")));
				                    break;
				               }else if (workSheetName.equalsIgnoreCase("UnitTest_FV_PC_SocioEconomic")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
                                    race=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Race")));
                                    raceOtherValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RaceOther")));
                                    ethnicity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Ethnicity")));
                                    religion=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Religion")));
                                    religionOtherValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReligionOther")));
                                    citizenship=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Citizenship")));
                                    citizenshipOtherValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CitizenshipOther")));
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
                                    educationLevelOtherValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EducationLevel Other")));
                                    householdIncome=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HouseholdIncome")));
                                    numPeopleText=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NumberOfPeople")));
                                    householdComposition=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HouseholdComposition")));
                                    householdCompositionOtherValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HouseholdIncome Other")));
                                    homelessIndicatorCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HomelessIndicatorCheck")));
                                    homelessStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HomelessStatus")));
                                    ssi=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Ssi")));
                                    employmentStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EmploymentStatus")));
                                    comments1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CommentsForSE")));
                                    alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
				                    alertMessage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert Message")));
				                    break;
				                }else if (workSheetName.equalsIgnoreCase("UnitTest_FV_PC_Identifier")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
									group= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Group")));
									type=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Type")));
									typeCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TypeCA")));
									value=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Value")));
									expirationdate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Expiration Date")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
				                    alertMessage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert Message")));
									break;
				                }
				                else if(workSheetName.equalsIgnoreCase("IdentifiersAdmin")){
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
									typeDefault=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Default")));
									restricted=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Restricted")));
									typeStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
									value=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Value")));
									expirationdate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Expiration Date")));
                                    break;
								}else if (workSheetName.equalsIgnoreCase("UnitTest_FV_PC_HealthCareTeam")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
	                                userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
	                                userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
	                                switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
	                                patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
	                                teamName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TeamName")));
	                                searchMember=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchMember")));
	                                itemCheckBox=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ItemCheckBox")));
	                                pcpCheckbox=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PcpCheckbox")));
	                                teamLead=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TeamLead")));
	                                duration =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
	                                role=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
	                                endDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndDate")));
	                                endNumber=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndNumber")));
	                                timeperiod=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Timeperiod")));
	                                location=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location")));
	                                specialty=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Specialty")));
	                                reasonForDelete=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForDelete")));
	                                alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
	                                alertCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertCA")));
				                    alertMessage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert Message")));
	                                break;
								}else if (workSheetName.equalsIgnoreCase("AdminHealthCareTeam")){
									roleType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RoleType")));
									role=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
									reasonForDeleteType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForDeleteType")));
                                    reasonForDelete=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForDelete")));
                                    break;
								}
								else if(workSheetName.equalsIgnoreCase("UnitTest_FV_PC_Referral" )){
									userAccount=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
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
									cptSuggestBox2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Cpt1")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
					                alertMessage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert Message")));
					                alertCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertCA")));
				                    alertMessageCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert MessageCA")));	
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_FV_PC_MySettings" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									currentPassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CurrentPassword")));
									newPassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NewPassword")));
									newConfirmPassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NewConfirmPassword")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									alertMessage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert Message")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_FV_CM_Field")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    unit= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Unit")));
                                   field= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Field")));
                                   break;
								}else if (workSheetName.equalsIgnoreCase("UnitTest_FV_PC_SocioEconomic_CA")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
                                    race=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Race")));
                                    raceOtherValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RaceOther")));
                                    ethnicity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Ethnicity")));
                                    religion=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Religion")));
                                    religionOtherValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReligionOther")));
                                    citizenship=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Citizenship")));
                                    citizenshipOtherValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CitizenshipOther")));
                                    countryPanel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CountryPanel")));
                                    lanuage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Lanuage")));
                                    languagePanel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LanguagePanel")));
                                    arrivalDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ArrivalDate")));
                                    languagespoken=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Languagespoken")));
                                    interpreterrequired=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Interpreterrequired")));
                                    interpreter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Interpreter")));
                                    service=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Service")));
                                    parentEthnicityPanel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ParentEthnicityPanel")));
                                    livingArrangement=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LivingArrangement")));
                                    studentStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StudentStatus")));
                                    educationLevel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EducationLevel")));
                                    educationLevelOtherValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EducationLevel Other")));
                                    householdIncome=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HouseholdIncome")));
                                    numPeopleText=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NumberOfPeople")));
                                    householdComposition=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HouseholdComposition")));
                                    householdCompositionOtherValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HouseholdIncome Other")));
                                    homelessIndicatorCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HomelessIndicatorCheck")));
                                    homelessStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HomelessStatus")));
                                    poverty=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Poverty")));
                                    rural=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Rural")));
                                    aboriginalPeopels=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AboriginalPeopels")));
                                    raclized=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Raclized")));
                                    employmentStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EmploymentStatus")));
                                    ageGroup=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AgeGroup")));
                                    jobCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("JobCode")));
                                    occupation=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Occupation")));
                                    comments1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CommentsForSE")));
                                    alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
				                    alertMessage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert Message")));
				                    break;
				                }else if(workSheetName.equalsIgnoreCase("UnitTest_FV_SS_AuditLog" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									auditStartDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate")));
									auditEndDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndDate")));
									activityFilter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ActivityType")));
									userFilter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User")));
									patientFilter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Patient")));
									sectionFilter=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Section")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									alertMessage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert Message")));
									break;
				                }else if(workSheetName.equalsIgnoreCase("UnitTest_FV_PC_ConsentsCAView")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientID")));
									consentType= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentType")));
									consentName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentName")));
									status=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("status")));
									inactivation=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason for inactivation")));
									dateSigned=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DateSigned")));
									signedBy=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SignedBy")));
									firstName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
									lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
									relationship =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("relationship")));
									entrolledTo=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EntrolledTo")));
									entrolledDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EntrolledDate")));
									endDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndDate")));
									reason=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
									comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_FV_PC_InfoCAView" )){									
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    rosteredCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RosteredCheck")));
                                    patientIdchart = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientIdchart")));
                                    canadianProvince= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CanadianProvince")));
                                    hCN=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HCN")));
                                    reason=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
                                    newBornCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NewBornCheck")));
                                    expireDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpireDate")));
                                  	primaryLocation=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrimaryLocation")));	
                                    responsibleProvider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ResponsibleProvider")));
                                    pcpCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PCPCheck")));
                                    lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
                                    firstName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
                                    middleName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MiddleName")));
                                    title=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Title"))); 
                                    suffix=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Suffix")));
                                    alias1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alias1")));
									alias2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alias2")));    
									dob=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DOB")));		
									estimatedCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EstimatedCheck")));		
									prematureCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrematureCheck")));
									duration=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
									measure=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Measure")));
									sex=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sex")));
									maritalStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaritalStatus")));
									status=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
									statusDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StatusDate")));
									reasonForInactivation = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForInactivation")));
									livingArrangement=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LivingArrangement")));
									residentialAddrStreet1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ResidentialAddrStreet1")));
									residentialAddrStreet2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ResidentialAddr2Street2")));
									residentialAddrcity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("City")));
									residentialAddrstate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("State")));
									residentialAddrzipCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCode")));
									residentialAddrcountry = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country")));
									residentialAddrCounty= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("County")));
									telephoneType1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PhoneNoType1")));
									telephoneNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TelNum1")));
									telephoneextnNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExtnNum1")));
									telephoneType2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PhoneNoType2")));
									telephoneNo2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TelNum2")));
									telephoneextnNo2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExtnNum2")));
									telephoneType3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PhoneNoType3")));
									telephoneNo3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TelNum3")));
									telephoneextnNo3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExtnNum3")));									
									email=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("email")));
									contactPreferences=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ContactPreferences")));
									preference2Present=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Preference2present")));
									contactPreference2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ContactPreference2")));
									sameAsResidentialAddressCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SameAsResidentialAddressCheck")));
									mailingAddressStreet1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MailingAddressStreet1")));
									mailingAddressStreet2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MailingAddressStreet2")));
									mailingAddressCity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MailingAddressCity")));
									mailingAddressState=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MailingAddressState")));
									mailingAddressZipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MailingAddressZipcode")));									
									mailingAddressCountry=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaillingAddressCountry")));
									comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
                                  break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_LoginPage")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_AddPayer")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									payerName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerName")));
									relationshipStatus = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RelationshipStatus")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									memberId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MemberId")));
									startDateUS = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDateUS")));
									startDateCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDateCA")));
									endDateUS = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndDateUS")));
									endDateCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndDateCA")));
									coPay=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoPay")));
	                                specialistCoPay=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SpecialistCoPay")));
	                                deductible=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Deductible")));
	                                coInsurance=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoInsurance")));
									typeofCoverage = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TypeofCoverage")));
									billingAddr1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingAddr1")));
									billingAddr2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingAddr2")));
									billingCity = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingCity")));
									billingZip = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingZip")));
									billingState = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingState")));
									billingCountry = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingCountry")));
									dobCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DOBCA")));
									dob = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DOB")));
									sex = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sex")));
									telNum1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TelNum1")));
									telNum2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TelNum2")));
									planName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PlanName")));
									comment = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comment")));
									eligibilityStatus = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EligibilityStatus")));
									releaseInformation =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReleaseInformation")));
									relationAddr1 =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RelationAddress1")));
									relationAddr2 =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RelationAddress2")));
									relationState =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RelationState")));
									relationZipCode =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RelationZipCode")));
									relationCountry =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RelationCountry")));
									validationMessage =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
	                                validationFieldID =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									
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


