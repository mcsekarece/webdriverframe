package com.projectname.testutils.genericutility.testDataLib;

import java.lang.reflect.Field;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;

import com.projectname.testutils.genericutility.ReadFromExcel;


/**
 *  SystemSettingLib
 * This Class will contain reusable functions which can be used in Nexia Interface
 * @Category 	SystemSettingsLib
 * @since  	     May 18, 2010
 */



public class SystemSettingsLib {
	
	public String testCaseId = null;
	public String userAccount = null;
	public String userAccountCA = null;
	public String userName = null;
	public String userPassword = null;
	public String patientId=null;
	public String CAPatientId=null;
	public String practiceType = null;
	public String consentType = null;
	public String consentName=null;
	public String validFor=null;
	public String validForType = null;
	public String restrictionLevel=null;
	public String startHour = null;
    public String practiceCA2 = null; 
    public String practiceCA3 = null; 
    public String practiceCA4 = null  ;

	public String schedulingSettings = null;
	public String schedulingPreferences = null;
	public String advancedPatientSearch = null;
	public String programGroups = null;
	public String cancellationReasons = null;
	public String lastName=null;
	public String firstName=null;
	public String referringCode=null;
	public String middleInitial=null;
	public String practiceNameReferral=null;
	public String credentials=null;
	public String licenseNum=null;
	public String reportMethod=null;
	public String specialty=null;
	public String billingExclusionCheck=null;
	public String picosEnrolledCheck=null;
	public String upin=null;
	public String npi=null;
	public String taxonomyCode=null;
	public String comments=null;	public String practiceName1=null;
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
	public String state2CA=null;
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
	public String Provider=null;
	public String SuperProvider=null;
	public String PFirstName=null;
	public String SFirstName=null;
	public String Enddate=null;

	public String global = null;
	public String local = null;
	public String teamLeavel=null;
	public String teamName = null;
	public String notes = null;
	public String name1 = null;
	public String role1 = null;
	public String name2 = null;
	public String name = null;
	public String role2 = null;
	
	public String contactLevel=null;
	public String contactType=null;
	public String contactCompany=null;
	public String salutation=null;
	public String middleName=null;
	public String jobTitle=null;
	public String department=null;
	public String telephoneType1 = null;
	public String telephoneNo1=null;	
	public String telephoneextnNo1=null;
	public String telephoneType2 = null;
	public String telephoneNo2=null;	
	public String telephoneextnNo2=null;
	public String telephoneType3 = null;
	public String telephoneNo3=null;	
	public String telephoneextnNo3=null;
	public String primaryPhoneExtn1=null;
	public String primaryPhoneNumber1=null;
	public String billingLocation = null;
	public String address1=null;
	public String address2=null;
	public String city=null;
	public String state=null;
	public String stateCA=null;	
	public String submitClaim=null;
	public String submitClaimsSub=null;
	public String claimDays=null;
	public String claimDaysTransfer=null;
	public String planName=null;
	public String coPay=null;
	public String specialistCoPay=null;
	public String deductible=null;
	public String coInsurance=null;
	public String county=null;
	public String zipcode=null;
	public String zipcodeCa=null;
	public String zipcodeCheckCA=null;
	public String zipcodeCa1=null;
	public String country=null;
	public String email=null;
	public String webAddress=null;
	
	public String chartsChecxBox = null;
	public String reasonForDelete=null;
	
	public String groupFor=null;
	public String groupName=null;
	public String groupDescription=null;
	public String groupDefault=null;

	public String department1=null;
	public String program=null;
	public String description=null;

	
	public String idGroup=null;
	public String idType=null;
	public String typeDescription=null;
	public String freeTextRadio=null;
	public String definedListRadio=null;
	public String idTypeMask=null;
	public String SupervisorSuggestBox=null;
	public String DurationTo=null;
	public String DurationFrom=null;
	public String typerestrictionLevel=null;
	public String expDate=null;
	public String typeDefault=null;
	public String restricted=null;
	public String typeStatus=null;
	public String identifier=null;
	public String providers=null;
	

	public String userName1=null;
	public String externalEmr=null;
	public String UserProvider=null;
	public String password=null;
	public String userRole=null;
	public String userRole1=null;
	public String practise=null;
	public String practise2=null;
	public String resetPassword=null;
	public String changedPassword=null;
	public String userRole2=null;
	public String practice2=null;
	public String userRole3=null;
	public String practice3=null;
	public String userRole4=null;
	public String userRole5=null;
	public String userRole6=null;
	public String userRole7=null;
	public String userRole8=null;
	public String userRole9=null;
	public String userRole10=null;
	public String userRole11=null;
	public String userRole12=null;
	public String userRole13=null;
	public String userRole14=null;
	public String userRole15=null;
	public String userRole16=null;
	public String practiseCA=null;
	public String practice4=null;

	public String providerType = null;
	public String providerCode = null;
	public String title = null;
	public String speciality = null;
	public String gender = null;
	public String language=null;
	public String cellPhone=null;
	public String pager=null;
	public String maximumFte=null;
	public String hoursWorked = null;
	public String officePhone=null;
	public String officePhone1=null;
	public String fax=null;
	public String billingAddressCheck=null;
	public String billingStreet1=null;
	public String billingStreet2=null;
	public String billingCity=null;
	public String billingState=null;
	public String billingZipcode=null;
	public String billingCountry=null;
	public String billingInfoCheck=null;
	public String signatureDate=null;
	public String dEA=null;
	public String uPIN=null;
	public String nPI=null;
	public String reportMEthod = null;
	public String practice=null; 
	public String enterprise=null; 
	public int wait = 5000;
	
	public String searchElement=null;
	public String patientHearabout=null;
	public String patientProvider=null;
	public String patientProgram=null;
	public String patientReferraldate=null;
	public String provider=null;
	public String pcpCheck = null;
	public String provider1=null;
	
	public String description1=null;
	public String idName=null;
	public String editIdName=null;
	
	public String parentEthnicityPanel=null;
	public String livingArrangement=null;
	public String studentStatus = null;
	public String educationLevel=null;
	
	public String unit=null;
	public String field=null;
	
	public String contactType1=null;
	public String contactValue=null;
	public String contactValue1=null;
	
	public String practiceName;
	public String practiceCode;
	public String taxId;
	public String groupNpi;
	public String primaryPhoneType1;
	public String primaryPhoneType2;
	public String primaryPhoneNumber2;
	public String primaryPhoneExtn2;
	public String primaryPhoneType3;
	public String primaryPhoneNumber3;
	public String primaryPhoneExtn3;
	public String billlingaddress1;
	public String billingaddress2;
	public String billingcity;
	public String billingstate;
	public String billingzipcode;
	public String billingzipcodeCA=null;
	public String billingcountry;
	public String patientName=null;
	public String locationCode=null;
	public String locationName1=null;
	public String locationName2=null;
	public String locationName3=null;
	public String locationName4=null;
	
	public String deleteValue=null;
	public String role=null;
	public String roleValue=null;
	
	public String startDate=null; 
	public String homePage = null;
	public String verifyPhoneNo1=null;
	public String verifyPhoneNo2=null;
	public String verifyPhoneNo3=null;
	
	public String password1=null;
	
	public String pharmacyName=null;
	public String directoryType=null;
	public String payerWizard=null;
	public String payerWizardCA=null;
	public String payerName=null;
	public String payerCode=null;
	public String payerType=null;
	public String streetName = null;
	public String telePhoneNo = null;
	
	public String street=null;
	public String phone=null;
	public String fax1=null;
	
	public String noAccess=null;
	public String viewOnly=null;
	public String limitedAccess=null;
	public String fullAccess=null;
	
	public String switchRole=null;
	public String switchRole1=null; 
	public String consentValue=null;
	public String consentType1=null;
	public String newpassword=null;
	public String providerName=null;
	
	public String patientRegistration=null;
	public String personalInfo=null;
	public String socioEconomics=null;
	public String houseHold=null;
	public String contacts=null;
	public String identifiers=null;
	public String payers=null;
	public String referrals=null;
	public String consents=null;
	public String consentsSec=null;
	public String cases=null;
	public String programs=null;
	public String healthCareTeam=null;
	public String patientTimeLine= null;
	
	public String administration=null;
	public String organizationalStructure=null;	
	public String users=null;
	public String departments=null;
	public String programsOrg=null;	
	public String enterpriseVariables=null;
	public String mandatoryFields=null;
	public String addressBook=null;
	public String identifiersAdmin=null;
	public String externalProviders=null;
	public String healthCareTeamAdmin=null;
	public String directories=null;
	public String referringProviders=null;
	public String payerDirectories=null;
	public String Pharmacies=null;
	public String governmentAgencies=null;
	public String hospitals=null;
	public String labs=null;

	public String securitySettings=null;
	public String auditLog=null;
	public String passwordRules=null;
	public String emergencyAccess=null;
	public String userAccessExceptions=null;
	public String userRoles=null;
	public String manageRecords=null;
	public String dataSharing=null;
	public String restrictPatientChart=null;
	
	public String clinical=null;
	
    public String orders=null;
    public String labsOrders=null;
    public String diagnosticTestsOrders=null;
    public String prescription=null;
    public String referralsOrders=null;

    public String reportsClinical=null;
    public String labsReports=null;
    public String diagnosticTestsRepords=null;
    public String correspondence=null;
    public String chartDisclosure=null;
    
	//public String labReports=null;
	public String encounters=null;
	public String timeLine=null;
	//public String medications=null;
	public String medicalSummary=null;
	public String fileReport=null;
	public String exportChartData=null;
	
	public String careAlerts=null;
	//public String patientMedications=null;
	//public String rxRenewals=null;
	public String allergies=null;
	public String immunizations=null;
	public String injections=null;
	public String socialHistory=null;
	public String familyHistory=null;
	public String vitals=null;
	public String procedures=null;
	public String medicationsSummary=null;
	public String patientProblems=null;
		
	public String clinicalSetting=null;
	public String encounterTemplates=null;
	public String clinicalDecisionSupport=null;
	public String electronicReports=null;
	public String laboratoryTemplates=null;
	public String interactionWarning=null;
	
	public String clinicalLists=null;
	public String clinicalPatientList=null;
	public String clinicalQualityMeasures=null;
	public String meaningfulUseMeasures=null;
	
	public String general=null;
	public String unmatchedItems=null;
	public String importChartData=null;
	public String failedTransmition=null;
	public String unmatchedProviders=null;
    
	public String calendarSettings=null;
	public String scheduling=null;
	public String bumpList=null;
    public String waitListManagement=null;
    public String recordAttendance=null;
    public String calendarView=null;
    public String calendarView1=null;
    public String events=null;
    public String PDG=null;
    public String openPDGSessions=null;
    public String viewEditPDGsession= null;
    public String unexplainedabsentees= null;
    
    public String locationHours=null;
	public String nonProviderResources=null;
	public String resourceGroups=null;
	public String visitTypes=null;
    public String visitGroups=null;
    public String calendarTemplates=null;    
	public String resourceCalendars=null;
	public String calendarPreferences=null;
	
	public String reports=null;
	public String generalReports=null;
	
	public String scheduler=null;
    
    public String calendarSuperUser=null;
	public String confirmAppt=null;
	public String checkinPatient=null;
	
	
	public String templateSetup=null;
	public String daysheetTemplates=null;
	public String letterTemplates=null;
	
    public String biller=null;
	public String billingSettings=null;
	public String superbillSetup=null;
	public String statementPreferences=null;
 	public String serviceCodes=null;
 	public String feeSchedule=null;
 	public String adjustmentReasons=null;
 	public String batchEligibilityPreferences=null;
 	public String billingRulesAdmin=null;
 	public String superbillsToReview=null;
 	public String rejectionsToReview=null;
 	public String onHoldClaims=null;
 	public String unprintedStatements=null;
	public String unpostedPayerBatches=null;
	public String paperClaimsToReview=null;
	public String postCharges=null;
 	public String postPatientPayments=null;
 	public String postPayerPayments=null;
 	public String insuranceAging=null;
 	public String patientsFailedEligibility=null;
 	public String billingHistory=null;
 	public String summary=null;
 	public String charges=null;
 	public String payments=null;
 	public String statements=null;
	
	public String aprovider1=null;
	public String aprovider2=null;
	public String aprovider3=null;
	public String aprovider4=null;
	public String aprovider5=null;
	public String aprovider6=null;
	public String aprovider7=null;
	public String aprovider8=null;
	public String aprovider9=null;
	
	public String taxRate = null;
	public String mammography = null;
	public String associateUser= null;
	public String CLIANumber=null;
	
	
	//Ass Payer
	public String eDIStatus = null;
	public String providerId = null;
	public String alernateProvider = null;
	public String groupId= null;
	public String taxonomy= null;
	public String providerBillingNumber=null;
	public String payToNumber=null;
	
	
	public String workSheetName = null;
	public String workBookName = "TestData_SystemSetting.xls";		
	public String sectionName = "systemsetting";
	
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
public boolean fetchSystemSettingTestData(){
		
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
								if(workSheetName.equalsIgnoreCase("AdminNewConsent")){
									userAccount=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									consentType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentType")));
									consentName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentName")));
									validFor=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidFor")));
									validForType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidForType")));
									restrictionLevel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("restrictionLevel")));
									break;
								}else if(workSheetName.equalsIgnoreCase("EP_Consent")){
									consentType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentType")));
									consentType1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentType1")));
									consentValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentValue")));
									break;
								}else if(workSheetName.equalsIgnoreCase("AdminEnterPriseVariables")){
									userAccount=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									idType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Idtype")));
									idName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Idname")));
									editIdName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EditIdName")));
									break;
								}else if(workSheetName.equalsIgnoreCase("NewSocioEconomic")){
									userAccount=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									
									CAPatientId=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CAPatientId")));
									parentEthnicityPanel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ParentEthnicityPanel")));
                                    livingArrangement=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LivingArrangement")));
                                    studentStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StudentStatus")));
                                    educationLevel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EducationLevel")));
                                    break;
								}else if(workSheetName.equalsIgnoreCase("CreateExternalProviders" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									referringCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferringCode")));
									lastName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
									firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
									middleInitial=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MiddleInitial")));
									practiceNameReferral=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeName")));
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
									zipcodeCa=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCodeCA")));
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
									state2CA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StateCA")));
									zipcodeCa1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EZipCodeCA")));
									epcountry2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country2")));
									epphone2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Phone2")));
									epextn2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Extn2")));
									epfax2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fax2")));
									epemail2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("E-mail2")));
									break;
								}else if(workSheetName.equalsIgnoreCase("EP_HealthCareTeam")){
									deleteValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DeleteValue")));
									reasonForDelete=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForDelete")));
									role=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
									roleValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RoleValue")));
									break;
								}else if(workSheetName.equalsIgnoreCase("CreateHealthCareTeam" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									global = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Global")));
									local = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Local")));
									teamName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TeamName")));
									notes = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Notes")));
									name1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Name1")));
									role1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role1")));
									name2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Name2")));
									name = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Name")));
									chartsChecxBox=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ChartsChecxBox")));
									reasonForDelete=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForDelete")));
									break;
								}else if(workSheetName.equalsIgnoreCase("EditHealthCareTeam" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									global = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Global")));
									local = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Local")));
									teamName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TeamName")));
									notes = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Notes")));
									name1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Name1")));
									role1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role1")));
									chartsChecxBox=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ChartsChecxBox")));
									reasonForDelete=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForDelete")));
									break;
								}else if(workSheetName.equalsIgnoreCase("CreateAddressBook")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
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
                                    stateCA = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StateCA")));
                                    zipcode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCode")));
                                    zipcodeCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCodeCA")));
                                    country = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country")));
                                    email = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("E-mail")));
                                    webAddress = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WebAddress")));
                                    comments = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
                                    break;
								}else if(workSheetName.equalsIgnoreCase("EP_AddressBook")){
									contactType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ContactType")));
									contactType1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ContactType1")));
									contactValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Contact")));
									contactValue1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Contact1")));
									break;
								}else if(workSheetName.equalsIgnoreCase("CreateIdentifierGroups" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									groupFor=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupFor")));
									groupName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupName")));
									groupDescription=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
									groupDefault=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Default")));
									break;
								}else if(workSheetName.equalsIgnoreCase("CreateProgram" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									department=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department")));
									program=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Program")));
									description=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
									providers=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Providers")));
									break;
								}else if(workSheetName.equalsIgnoreCase("CreatePractice" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
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
									stateCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StateCA")));
									zipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCode")));
									zipcodeCa=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipcodeCa")));
									country=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country")));
									billlingaddress1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingAddr1")));
									billingaddress2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingAddr2")));
									billingcity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingCity")));
									billingstate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingState")));
									billingzipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingZipCode")));
									billingzipcodeCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingZipCodeCA")));
									billingcountry=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingCountry")));
									patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
									firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
									locationName1 =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationName1")));
									billingLocation =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingLocation")));
									practiceType =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeType")));
									startHour =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartHours")));
									taxRate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TaxRate")));
									mammography = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Mammography")));
									associateUser = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AssociateUser")));
									CLIANumber = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CLIANumber")));
									
									break;
								}else if(workSheetName.equalsIgnoreCase("EditProgram" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									department1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department")));
									program=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Program")));
									description=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
									break;
								}else if(workSheetName.equalsIgnoreCase("CreateIdentifierTypes" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
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
									enterprise=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Enterprise")));
									practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
									break;
								}else if(workSheetName.equalsIgnoreCase("CreateDepartment" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									department=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department")));
									description=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
									break;
								}else if(workSheetName.equalsIgnoreCase("CreateUser" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									lastName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
									firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
									userName1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName1")));
									UserProvider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									credentials=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Credentials")));
									externalEmr=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExternalEMR")));
									password=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password1")));
									newpassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Newpassword")));
									userRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole")));
									practise=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practise")));
									userRole2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole2")));
									practice2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practise2")));
									userRole3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole3")));
									practice3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practise3")));
									userRole4=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole4")));
									practice4=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practise4")));
									break;
								}else if(workSheetName.equalsIgnoreCase("PortPractice" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
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
									stateCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StateCa")));
									zipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCode")));
									zipcodeCa=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCodeCa")));
									country=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country")));
									billlingaddress1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingAddr1")));
									billingaddress2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingAddr2")));
									billingcity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingCity")));
									billingstate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingState")));
									billingzipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingZipCode")));
									billingzipcodeCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingZipCodeCa")));
									billingcountry=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingCountry")));
									locationCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationCode")));
									locationName1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationName1")));
									locationName2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationName2")));
									locationName3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationName3")));
									locationName4=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationName4")));
									practiceType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeType")));
									break;
								}else if(workSheetName.equalsIgnoreCase("ForcePasswordReset" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									externalEmr=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExternalEMR")));
									resetPassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ResetPassword")));
									userName1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName1")));
									password1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password1")));
									startDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("EditUser" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									lastName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
									firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
									userName1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName1")));
									credentials=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Credentials")));
									externalEmr=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExternalEMR")));
									resetPassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ResetPassword")));
									password=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									changedPassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password1")));
									userRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole")));
									practise=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practise")));
									startDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate")));
									break;
								}else if(workSheetName.equalsIgnoreCase("CreateProvider" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									providerType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderType")));
									providerCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("providerCode")));
									title=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Title")));
									lastName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
									firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
									middleName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MiddleName")));
									credentials=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Credentials")));
									specialty=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Specialty")));
									gender=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Gender")));
									language=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Language")));
									cellPhone=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CellPhone")));
									pager=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Pager")));
									email=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Email")));
									maximumFte=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaximumFte")));
									hoursWorked=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HoursWorked")));
									comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
									address1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Address1")));
									address2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Address2")));
									city=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("City")));
									state=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("State")));
									zipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Zipcode")));
									country=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country")));
									officePhone=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OfficePhone")));
									officePhone1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OfficePhone1")));
									fax=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fax")));
									billingAddressCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BllingAddressCheck")));
									billingStreet1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingStreet1")));
									billingStreet2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingStreet2")));
									billingCity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingCity")));
									billingState=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingState")));
									billingZipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingZipcode")));
									billingCountry=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingCountry")));
									billingInfoCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("InfoCheck")));
									signatureDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SignatureDate")));
									dEA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DEA")));
									uPIN=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UPIN")));
									nPI=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NPI")));
									reportMethod=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReportMethod")));
									practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
									groupName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupName")));
									groupFor=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupFor")));
									idTypeMask=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IdTypeMask")));
									program=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Program")));
									eDIStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EDIStatus")));
									
									providerId=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderId")));
									alernateProvider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlernateProvider")));
									groupId=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupId")));
									taxonomy=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Taxonomy")));
									providerBillingNumber=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderBillingNumber")));
									payToNumber=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayToNumber")));
									
									
									
									break;
								}	else if(workSheetName.equalsIgnoreCase("PortProvider" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									providerType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderType")));
									providerCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("providerCode")));
									title=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Title")));
									lastName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
									firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
									middleName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MiddleName")));
									credentials=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Credentials")));
									specialty=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Specialty")));
									gender=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Gender")));
									language=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Language")));
									cellPhone=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CellPhone")));
									pager=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Pager")));
									email=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Email")));
									maximumFte=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaximumFte")));
									hoursWorked=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("HoursWorked")));
									comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
									address1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Address1")));
									address2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Address2")));
									city=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("City")));
									state=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("State")));
									stateCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StateCa")));
									zipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Zipcode")));
									zipcodeCa=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipcodeCA")));
									country=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country")));
									officePhone=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OfficePhone")));
									officePhone1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OfficePhone1")));
									fax=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fax")));
									billingAddressCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BllingAddressCheck")));
									billingStreet1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingStreet1")));
									billingStreet2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingStreet2")));
									billingCity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingCity")));
									billingState=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingState")));
									billingZipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingZipcode")));
									billingCountry=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingCountry")));
									billingInfoCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("InfoCheck")));
									signatureDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SignatureDate")));
									dEA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DEA")));
									uPIN=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UPIN")));
									nPI=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NPI")));
									reportMethod=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReportMethod")));
									practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
									groupName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupName")));
									groupFor=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupFor")));
									idTypeMask=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IdTypeMask")));
									SupervisorSuggestBox=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Supervisor")));
									
									DurationTo=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DurationTo")));
									DurationFrom=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DurationFrom")));	
									
									break;
								}
								
								else if(workSheetName.equalsIgnoreCase("PatientInfo")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    provider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
                                    pcpCheck = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PcpCheck")));
                                    provider1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider1")));
                                    firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
                                    lastName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
                                    break;
								}else if(workSheetName.equalsIgnoreCase("CreateAssociateDepartment")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    department=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department")));
                                    description=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
                                    department1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department1")));
                                    program=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Program")));
                                    description1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description1")));
                                    break;
                                  }else if(workSheetName.equalsIgnoreCase("CreateProviderForProgram")){
    								userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    department=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department")));
                                    provider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
                                    program=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Program")));
                                    provider1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NewProvider")));
                                    break;
    							}else if(workSheetName.equalsIgnoreCase("CreatePracticeForProvider")){
    								userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    department=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department")));
                                    provider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
                                    program=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Program")));
                                    break;
    							}
                                  else if(workSheetName.equalsIgnoreCase("CreateAddressBookForSearch")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    contactLevel = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Contact Level")));
                                    contactType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Contact Type")));
                                    contactCompany = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Contact Company")));
                                    lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Last Name")));
                                    firstName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("First Name")));
                                    department = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department")));
                                    searchElement = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Search Element")));
                                    break;
								}else if(workSheetName.equalsIgnoreCase("CreateMandatoryField")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    unit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Unit")));
                                    field=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Field")));
                                    break;
								}else if(workSheetName.equalsIgnoreCase("CreateProviderForPractice")){
    								userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    provider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
                                    practiceName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeName")));
                                    provider1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NewProvider")));
                                    providerName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProviderName")));
                                    break;
    							}else if(workSheetName.equalsIgnoreCase("CreateDirectories")){
    								userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
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
                                    stateCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StateCA")));
                                    zipcodeCa=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipcodeCA")));
                                    zipcodeCheckCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipcodeCheckCA")));
                                    break;
    							}else if(workSheetName.equalsIgnoreCase("PayerAdmin")){
    								userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    directoryType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DirectoryType")));
                                    payerWizard=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerWizard")));
                                    payerWizardCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerWizardCA")));
                                    payerName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerName")));
                                    payerCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerCode")));
                                    payerType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerType")));
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
                                    submitClaim=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SubmitClaims")));
                                    submitClaimsSub=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SubmitClaimsSub")));
                                    claimDays=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ClaimDays")));
                                    claimDaysTransfer=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ClaimDaysTransfer")));
                                    department=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department")));
                                    title=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Title")));
                                    lastName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
                                    firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
                                    role=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
                                    comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
                                    stateCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StateCA")));
                                    zipcodeCa=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipcodeCA")));                                    
                                    planName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PlanName")));
                                    coPay=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoPay")));
                                    specialistCoPay=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SpecialistCoPay")));
                                    deductible=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Deductible")));
                                    coInsurance=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoInsurance")));
                                    break;
    							} else if(workSheetName.equalsIgnoreCase("SearchDirectories")){
    								userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
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
                                    break;
    							}else if(workSheetName.equalsIgnoreCase("CreateUserRole")){
    								userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    userRole= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole")));
                                    description= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
                                    homePage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Home Page")));
                                    noAccess= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NoAccess")));
                                    viewOnly=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ViewOnly")));
                                    limitedAccess=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LimitedAccess")));
                                    fullAccess=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FullAccess")));
                                    break;
    							}else if(workSheetName.equalsIgnoreCase("UserRole")){
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    userRole= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole")));
                                    description= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
                                    homePage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Home Page")));
                                    
                                    
                                    patientRegistration = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Patient Registration")));
                                    personalInfo=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Personal Info")));
                                    socioEconomics=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Socio Economics")));
                                    houseHold=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Household")));
                                    contacts= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Contacts")));
                                    identifiers=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Identifiers")));
                                    payers=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Payers")));
                                    referrals=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Referrals")));
                                    consents= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Consents")));
                                    notes=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Notes")));
                                    cases=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Cases")));
                                    programs=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Programs")));
                                    healthCareTeam= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Healthcare Team")));
                                    patientTimeLine= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientTimeLine")));
                                    
                                    
                                    administration=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Administration")));
                                    organizationalStructure=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Organizational Structure")));
                                    practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
                                    providers= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Providers")));
                                    users=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Users")));
                                    departments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Departments")));
                                    programsOrg=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProgramsOrg")));
                                    enterpriseVariables=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Enterprise Variables")));
                                    mandatoryFields= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Mandatory Fields")));
                                    addressBook=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Address Book")));
                                    externalProviders=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("External Providers")));
                                    identifiersAdmin=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IdentifiersAdmin")));
                                    healthCareTeamAdmin= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Healthcare TeamAdmin")));
                                    directories=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Directories")));
                                    referringProviders=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Referring Providers")));
                                    payerDirectories=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerDirectories")));
                                    Pharmacies=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Pharmacies")));
                                    governmentAgencies=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Government Agencies")));
                                    hospitals=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Hospitals")));
                                    labs=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Labs")));
                                    
                                    securitySettings=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Security Settings")));
                                    auditLog=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Audit Log")));
                                    consentsSec=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentsSec")));
                                    userRoles=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("User Roles")));
                                    passwordRules= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password Rules")));
                                    emergencyAccess= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EmergencyAccess")));
                                    userAccessExceptions= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserAccessExceptions")));
                                    manageRecords=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Manage Records")));
                                    dataSharing= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DataSharing")));
                                    restrictPatientChart= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RestrictPatientChart")));
                                    
                                    clinical=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Clinical")));
                                    orders= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Orders")));
                                    labsOrders= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LabsOrders")));
                                    diagnosticTestsOrders= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DiagnosticTestsOrders")));
                                    prescription= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Prescription")));
                                    referralsOrders= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferralsOrders")));
                                    
                                    reportsClinical= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reports")));
                                    labsReports= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LabsReports")));
                                    diagnosticTestsRepords= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DiagnosticTestsRepords")));
                                    correspondence= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Correspondence")));
                                    chartDisclosure= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ChartDisclosure")));
                                    
                                    encounters=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Encounters")));
                                    timeLine=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TimeLine")));
                                    careAlerts=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Care Alerts")));
                                    
                                    medicalSummary=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medical Summary")));
                                    allergies= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Allergies")));
                                    patientProblems= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Patient Problems")));
                                    immunizations= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Immunizations")));
                                    injections= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Injections")));
                                    socialHistory= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Social History")));
                                    familyHistory= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Family History")));
                                    vitals= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Vitals")));
                                    procedures= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Procedures")));
                                    medicationsSummary= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Medications Summary")));
 
                                    fileReport= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("File Report")));
                                    exportChartData=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Export Chart Data")));
                                    
                                    
                                    clinicalSetting=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Clinical Settings")));
                                    encounterTemplates=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Encounter Templates")));
                                    clinicalDecisionSupport=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Clinical Decision Support")));
                                    electronicReports=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ElectronicReports")));
                                    laboratoryTemplates=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LaboratoryTemplates")));
                                    interactionWarning=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Interaction Warnings")));
                                    
                                    
                                    clinicalLists=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Clinical Lists")));
                                    clinicalPatientList=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Clinical Patient List")));
                                    clinicalQualityMeasures= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Clinical Quality Measures")));
                                    meaningfulUseMeasures=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Meaningful Use Measures")));
                                    
                                    
                                    general=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("General")));
                                    unmatchedItems=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Unmatched Items")));
                                    importChartData=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Import Chart Data")));
                                    failedTransmition= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Failed Transmissions")));
                                    unmatchedProviders= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UnmatchedProviders")));

                                    
                                    reports=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reports")));
                                    generalReports=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("General Reports")));
                                    
                                    
                                    scheduler=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Scheduler")));
                                    calendarSettings=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Calendar Settings")));
                                    locationHours=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location Hours")));
                                    nonProviderResources=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Non-Provider Resources")));
                                    resourceGroups=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Resource Groups")));
                                    visitTypes=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Visit Types")));
                                    visitGroups=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Visit Groups")));
                                    calendarTemplates=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Calendar Templates")));
                                    resourceCalendars=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Resource Calendars")));
                                    calendarPreferences=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Calendar Preferences")));
                                    programGroups=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Program Groups")));
                                    cancellationReasons =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Cancellation Reasons")));
                                    
                                    calendarView=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Calendar View")));
                                    calendarSuperUser=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Calendar SuperUser")));
                                    confirmAppt=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Confirm Appt")));
                                    checkinPatient=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Check in Patient"))); 
                                    bumpList=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Bump List")));
                                    waitListManagement=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Wait List Management")));
                                    recordAttendance=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Record Attendance")));
                                    
                                    PDG=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PDG")));
                                    openPDGSessions=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Open PDG Sessions")));
                                    viewEditPDGsession=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("View/EditPDGsession")));
                                    unexplainedabsentees=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Unexplainedabsentees")));
                                    
                                    templateSetup=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Template Setup")));
                                    daysheetTemplates=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Daysheet Templates")));
                                    letterTemplates=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LetterTemplates")));
                                 	
                                    biller=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Biller")));
                                    billingSettings=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Billing Settings")));
                                    superbillSetup=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Superbill Setup")));
                                    statementPreferences=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Statement Preferences")));
                                    serviceCodes=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Service Codes")));
                                    feeSchedule=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fee Schedule")));
                                    adjustmentReasons=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Adjustment Reasons")));
                                    batchEligibilityPreferences=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Batch Eligibility Preferences")));
                                    billingRulesAdmin=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Billing Rules Admin")));
                                    superbillsToReview=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Superbills to Review")));
                                    rejectionsToReview=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Rejections to Review")));
                                    onHoldClaims=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("On Hold Claims")));
                                    unprintedStatements=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Unprinted Statements")));
                                    unpostedPayerBatches=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Unposted Payer Batches")));
                                    paperClaimsToReview=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Paper Claims to Review")));
                                    postCharges=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Post Charges")));
                                    postPatientPayments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Post Patient Payments")));
                                    postPayerPayments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Post Payer Payments")));
                                    insuranceAging=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Insurance Aging")));
                                    patientsFailedEligibility=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Patients Failed Eligibility")));
                                    billingHistory=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Billing History")));
                                    summary=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Summary")));
                                    charges=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Charges")));
                                    payments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Payments")));
                                    statements=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Statements")));
                                   
                                    break;
    							}else if(workSheetName.equalsIgnoreCase("LoginWithUpdateUser" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									userName1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName1")));
									password1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password1")));
									userRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole")));
									userRole1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole1")));
									break;
								}else if(workSheetName.equalsIgnoreCase("VerifySecurityOption")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									switchRole1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole1")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UserData" )){
									//userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									providerName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									lastName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
									firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
									userName1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName1")));
									UserProvider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									credentials=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Credentials")));
									externalEmr=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExternalEMR")));
									password=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password1")));
									//newpassword=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Newpassword")));
									practise=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practise")));
									//practise2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practise2")));
									practiseCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PractiseCA")));
									userRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole")));
									userRole2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole2")));
									userRole3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole3")));
									userRole4=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole4")));
									userRole5=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole5")));
									userRole6=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole6")));
									userRole7=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole7")));
									userRole8=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole8")));
									userRole9=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole9")));
									userRole10=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole10")));
									userRole11=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole11")));
									userRole12=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole12")));
									userRole13=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole13")));
									userRole14=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole14")));
									userRole15=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole15")));
									userRole16=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole16")));
					                practice2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practise2")));
					                practice3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practise3")));
					                practice4=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practise4")));
					                
					                practiceCA2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PractiseCA2")));
					                practiceCA3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PractiseCA3")));
					                practiceCA4=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PractiseCA4")));

									break;
								} else if(workSheetName.equalsIgnoreCase("AssociateProvider" )){
									
									aprovider1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AProvider1")));
									aprovider2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AProvider2")));
									aprovider3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AProvider3")));
									aprovider4=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AProvider4")));
									aprovider5=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AProvider5")));
									aprovider6=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AProvider6")));
									aprovider7=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AProvider7")));
									aprovider8=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AProvider8")));
									aprovider9=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AProvider9")));
									break;
								}else if(workSheetName.equalsIgnoreCase("PortAdminPractice")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
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
									stateCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StateCa")));
									zipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCode")));
									zipcodeCa=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCodeCa")));
									country=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country")));
									billlingaddress1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingAddr1")));
									billingaddress2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingAddr2")));
									billingcity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingCity")));
									billingstate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingState")));
									billingzipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingZipCode")));
									billingzipcodeCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingZipCodeCa")));
									billingcountry=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingCountry")));
									locationCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationCode")));
									locationName1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationName1")));
									locationName2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationName2")));
									locationName3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationName3")));
									locationName4=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationName4")));
									break;
								}else if(workSheetName.equalsIgnoreCase("PortAddPayers" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									role = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
									payerName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerName")));
									payerType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerType")));
									payerCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerCode")));
									streetName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StreetName")));
									city=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("City")));
									state=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("State")));
									zipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Zipcode")));
									stateCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StateCA")));
									zipcodeCa=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipcodeCA")));
									telePhoneNo=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TelePhoneNo")));
									planName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PlanName")));
                                    coPay=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoPay")));
                                    specialistCoPay=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SpecialistCoPay")));
                                    deductible=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Deductible")));
                                    coInsurance=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoInsurance")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("CosignProvider" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									role = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
									Provider= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									SuperProvider= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SuperProvider")));
									PFirstName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PFirstName")));
									SFirstName= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SFirstName")));
										Enddate= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Enddate")));
									break;
								}
								else{
									break;
								}
							}else{
								break;
							}
						}else{
							break;
						}
					}
				}if(isDataFound){
					break;
				}
			}if(!isDataFound){
				Assert.fail("\nTest Data not found in test data sheet for Test Case Id  : " + testCaseId);
			}
		}catch (RuntimeException e) {
			Assert.fail("Error During Execution; Execution Failed More detaisl " + e);
			e.printStackTrace();
		}
		return isDataFound;
	}	
}


