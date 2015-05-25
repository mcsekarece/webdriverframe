package com.nexia.selenium.genericlibrary.systemsettings;

import java.lang.reflect.Field;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;

import com.sharedlibrary.ReadFromExcel;



/**
 * SystemsSettingsUnitTest
 * This Class will contain reusable functions which can be used in Nexia Interface
 * @Category 	SystemsSettingsUnitTest
 * @since  	     May 17, 2010
 */
public class SystemsSettingsUnitTest {
	public String testCaseID=null;
	public String testCaseId = null;
	public String userAccount = null;
	public String userName = null;
	public String userPassword = null;
	
	public String consentType=null;
	public String consentName=null;
	public String validFor=null;
	public String validType=null;
	public String restractionLevel=null;
	public String alert=null;
	public String alertCA=null;
	public String alertMessage=null;
	public String alertMessageCa=null;
	
	public String referringCode=null;
	public String credentials=null;
	public String licenseNumber=null;
	public String reportMethod=null;
	public String speciality=null;
	public String upin=null;
	public String npi=null;
	public String taxonomyCode=null;
	public String practiceName=null;
	public String street=null;
	public String fax=null;
	
	public String contactLevel=null;
	public String contactType=null;
	public String contactCompany=null;
	public String salutation=null;
	public String lastName=null;
	public String firstName=null;
	public String middleName=null;
	public String middleInitial=null;
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
	public String address1=null;
	public String address2=null;
	public String city=null;
	public String state=null;
	public String county=null;
	public String zipcode=null;
	public String country=null;
	public String stateCA=null;
	public String zipcodeCA=null;
	public String countryCA=null;
	public String email=null;
	public String webAddress=null;
	public String comments=null;
	public String billingExclusion=null;
	public String pecos=null;
	public String street1= null;
	
	public String global=null;
	public String local=null;
	public String teamName=null;
	public String notes=null;
	public String name1=null;
	public String role1=null;
	public String name2=null;
	public String role2=null;
	public String editMembers=null;
	public String deleteMembers=null;
	public String deleteFromAll=null;
	public String reasonForDeletingMember=null;
	public String reasonForDelete= null;
	public String chartsChecxBox= null;

	
	public String groupFor=null;
	public String groupName=null;
	public String groupDescription=null;
	public String groupStatus=null;

	
	public String idGroup=null;
	public String idType=null;
	public String typeDescription=null;
	public String freeTextRadio=null;
	public String definedListRadio=null;
	public String idTypeMask=null;
	public String typerestrictionLevel=null;
	public String expDate=null;
	public String typeDefault=null;
	public String restricted=null;
	public String typeStatus=null;
	public String identifier=null;
	
	public String program=null;
	public String description=null;
	public String unitProgram=null;
	public String providerPresent=null;
	public String provider=null;

	public String userName1=null;
	public String externalEmr=null;
	public String password=null;
	public String password2=null;
	public String userRole=null;
	public String practise=null;
	public String resetPassword=null;
	public String password3=null;
	public String password4=null;
	
	public String providerType = null;
	public String providerCode = null;
	public String title = null;
	public String specialty=null;
	public String gender = null;
	public String language=null;
	public String cellPhone=null;
	public String pager=null;
	public String maximumFte=null;
	public String hoursWorked = null;
	public String officePhone=null;
	public String officePhone1=null;
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
	
	public String idName=null;
	
	public String unit=null;
	public String field=null;
	public String unit1=null;
	public String startDate=null;
	public String endDate=null;
	public String contactValue=null;
	
	public String reasonValue=null; 
	public String validationFieldID=null;
	public String pwdlength=null;
	public String resetsBeforeReuse=null;
	public String expires=null;
	public String failedAttempts=null;
	public String validationMessage=null;
	
	public String practiceCode=null;
	public String taxId=null;
	public String groupNPI=null;
	public String locationPresent=null;
	public String locationCode=null;
	public String billingLocationName=null;
	public String labIndicator=null;
	public String schedulingLocation=null;
	public String npiNumber=null;
	public String locationtelephoneType1 = null;
	public String locationtelephoneNo1=null;	
	public String locationtelephoneextnNo1=null;
	public String locationtelephoneType2 = null;
	public String locationtelephoneNo2=null;	
	public String locationtelephoneextnNo2=null;
	public String locationtelephoneType3 = null;
	public String locationtelephoneNo3=null;	
	public String locationtelephoneextnNo3=null;
	public String businessaddress1=null;
	public String businessaddress2=null;
	public String businesscity=null;
	public String businessstate=null;
	public String businesszipcode=null;
	
	public String businessstateCA=null;
	public String businesszipcodeCA=null;
	public String businesscountry=null;
	public String sameAsBusinessAddress=null;
	public String locationbillingaddress1=null;
	public String locationbillingaddress2=null;
	public String locationbillingcity=null;
	public String locationbillingstate=null;
	public String locationbillingzipcode=null;
	public String locationbillingcountry=null;
	public String taxRate = null;
	public String practiceType = null;
	
	public String pharmacyName=null;
	public String payerWizard=null;
	public String payerWizardCA=null;
	public String payerName=null;
	public String payerCode=null;
	public String elementId=null;
	public String planName=null;
	public String coPay=null;	
	public String specialistCoPay=null;
	public String deductible=null;
	public String coInsurance=null;
	
	public String phone=null;
	public String fax1=null;
	
	public String switchRole=null;
	
	public String workSheetName = null;
	public String workBookName = "TestData_UnitTest_SystemSetting.xls";		
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
								if(workSheetName.equalsIgnoreCase("UnitTest_SS_Constents")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    consentType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentType")));
                                    consentName =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConsentName")));
                                    validFor=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidFor")));
                                    validType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("validType")));
                                    restractionLevel=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("restractionLevel")));
									alert = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_SystemSettings_EP")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    referringCode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferringCode")));
                                    lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Last Name")));
                                    firstName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("First Name")));
                                    middleInitial = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Middle Initial")));                                  
                                    credentials=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Credentials")));
                                    licenseNumber = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LicenseNumber")));
                                    reportMethod=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReportMethod")));
                                    speciality=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Speciality")));
                                    billingExclusion=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingExclusion")));
                                    pecos=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Pecos")));
                                    upin=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UPIN")));
                                    npi=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NPI")));
                                    taxonomyCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TaxonomyCode")));
                                    comments = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
                                    practiceName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeName")));
                                    street=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Street")));
                                    street1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Street1")));
                                    city=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("City")));
                                    state=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("State")));
                                    zipcode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCode")));
                                    country = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country")));
                                    telephoneNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PhoneNo")));
                                    telephoneextnNo1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PhoneNoExt")));
                                    fax=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fax")));
                                    email = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("E-mail")));
                                    alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));	
									alertMessageCa=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessageCA")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_SS_AddressBook")){
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
                                    address1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Address1")));
                                    address2 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Address2")));
                                    city = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("City")));
                                    state = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("State")));
                                    zipcode = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCode")));
                                    country = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country")));
                                    email = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("E-mail")));
                                    webAddress = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("WebAddress")));
                                    comments = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
                                    alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("EP_AddressBook")){
									contactType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ContatctType")));
									contactValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Contact")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_SS_HealthCare")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    global=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Global")));
                                    local=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Local")));
                                    teamName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TeamName")));
                                    notes=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Notes")));
                                    name1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Name1")));
                                    role1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("role1")));
                                    name2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Name2")));
                                    role2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("role2")));
                                    editMembers=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EditMembers")));
                                    deleteMembers=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DeleteMembers")));
                                    deleteFromAll=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DeleteFromAllCheckBox")));
                                    reasonForDeletingMember=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForDeletingMember")));
                                    reasonForDelete=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForDelete")));
                                    chartsChecxBox=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ChartsChecxBox")));
                                    alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("EP_HealthCareTeam")){
									reasonValue=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonValue")));
									reasonForDelete=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForDelete")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_SS_IdGroups" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									groupFor=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupFor")));
									groupName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupName")));
									groupDescription=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
									groupStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_SS_IdTypes" )){
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
									practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
									typeDefault=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Default")));
									restricted=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Restricted")));
									typeStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_SS_Program")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									unitProgram=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UnitProgram")));
									program=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Program")));
									department=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department")));
									description=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
									providerPresent=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProvidersPresent")));
									provider=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Provider")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_SS_Department" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									department=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department")));
									description=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_SS_User" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									lastName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
									firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
									userName1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName1")));
									credentials=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Credentials")));
									externalEmr=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExternalEMR")));
									password=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password1")));
									password2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password2")));
									userRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole")));
									practise=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practise")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_SS_EditUser" )){
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
									password=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password1")));
									password2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password2")));
									userRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole")));
									practise=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practise")));
									startDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate")));
									endDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndDate")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
									password3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password3")));
									password4=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password4")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_SS_Provider" )){
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
									npi=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NPI")));
									reportMethod=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReportMethod")));
									practice=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Practice")));
									groupName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupName")));
									groupFor=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupFor")));
									idTypeMask=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IdTypeMask")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_SS_EnterpriseVariable" )){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									idType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IdType")));
									idName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IdName")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_SS_MandatoryField")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    unit=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Unit")));
                                    unit1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Unit1")));
                                    field=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Field")));
                                    alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alert")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertMessage")));
                                    break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_SS_PassWordRules")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    pwdlength=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PasswordLength")));
                                    resetsBeforeReuse=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PasswordReuse")));
                                    expires=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PasswordExpiry")));
                                    failedAttempts=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NumOfLoginAttempts")));
                                    validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
                                    break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_SS_Practice")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    practiceName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeName")));
                                    practiceCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeCode")));
                                    taxId=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TaxId")));
                                    groupNPI=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupNPI")));
                                    email=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Email")));
                                    telephoneType1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrimaryPhone")));
                                    telephoneNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrimaryPhoneNum")));
                                    telephoneextnNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrimaryPhoneExt")));
                                    telephoneType2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OtherPhone1")));
                                    telephoneNo2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OhterPhone1Num")));
                                    telephoneextnNo2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OhterPhone1Ext")));
                                    telephoneType3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OtherPhone2")));
                                    telephoneNo3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OhterPhone2Num")));
                                    telephoneextnNo3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("OhterPhone2Ext")));
                                    comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
                                    address1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Street1")));
                                    address2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Street2")));
                                    city=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("City")));
                                    state=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("State")));
                                    stateCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StateCA")));
                                    zipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCode")));
                                    zipcodeCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ZipCodeCA")));
                                    country=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country")));
                                    countryCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CountryCA")));
                                    billingStreet1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingStreet1")));
									billingStreet2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingStreet2")));
									billingCity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingCity")));
									billingState=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingState")));
									billingZipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingZipCode")));
									billingCountry=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingCountry")));
									locationPresent=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationPresent")));
									locationCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationCode")));
									description=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
									billingLocationName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BillingLocationName")));
									labIndicator=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LabIndicator")));
									schedulingLocation=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SchedulingLocation")));
									npiNumber=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NPINumber")));
									locationtelephoneType1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationPrimaryPhone")));
									locationtelephoneNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationPrimaryPhoneNum")));
									locationtelephoneextnNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationPrimaryPhoneExt")));
									locationtelephoneType2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationOtherPhone1")));
									locationtelephoneNo2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationOhterPhone1Num")));
									locationtelephoneextnNo2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationOhterPhone1Ext")));
									locationtelephoneType3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationOtherPhone2")));
									locationtelephoneNo3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationOhterPhone2Num")));
									locationtelephoneextnNo3=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationOhterPhone2Ext")));
									businessaddress1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BusinessStreet1")));
									businessaddress2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BusinessStreet2")));
									businesscity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BusinessCity")));
									businessstate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BusinessState")));
									businesszipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BusinessZipCode")));
									businessstateCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BusinessStateCA")));
									businesszipcodeCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BusinessZipCodeCA")));
									businesscountry=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BusinessCountry")));
									sameAsBusinessAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SameAsBusinessAddress")));
									locationbillingaddress1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationBillingStreet1")));
									locationbillingaddress2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationBillingStreet2")));
									locationbillingcity=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationBillingCity")));
									locationbillingstate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationBillingState")));
									locationbillingzipcode =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationBillingZipCode")));
									taxRate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TaxRate")));
									locationbillingcountry =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationBillingCountry")));
									practiceType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeType")));
									alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
									alertCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresentCA")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
									alertMessageCa=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessageCA")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_SS_Directories")){
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
                                    //phone=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Phone")));
                                    telephoneextnNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExtnNo")));
                                    fax=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fax")));
                                    //fax1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fax1")));
                                    email=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Email")));
                                    webAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Website")));
                                    salutation=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Salutation")));
                                    lastName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
                                    firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
                                    comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
                                    alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
                                    break;
    							} else if(workSheetName.equalsIgnoreCase("UnitTest_SS_PayerAdmin")){
    								userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    payerWizard=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerWizard")));
                                    payerWizardCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerWizardCA")));
                                    payerName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerName")));
                                    payerCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerCode")));
                                    street=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Street")));
                                    city=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("City")));
                                    state=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("State")));
                                    zipcode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Zipcode")));
                                    country=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Country")));
                                    telephoneNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TelephoneNo")));
                                    //phone=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Phone")));
                                    telephoneextnNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExtnNo")));
                                    fax=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fax")));
                                    //fax1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fax1")));
                                    email=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Email")));
                                    webAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Website")));
                                    salutation=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Salutation")));
                                    lastName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
                                    firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
                                    comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
                                    alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
									alertMessageCa=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessageCA")));
									elementId=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ElementId")));
                                    break;
    							    }  else if(workSheetName.equalsIgnoreCase("UnitTest_SS_PayerAdminContact")){
    								userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    payerWizard=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerWizard")));
                                    payerWizardCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerWizardCA")));
                                    payerName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerName")));
                                    payerCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerCode")));
                                    department=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Department")));
                                    telephoneNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TelephoneNo")));
                                    telephoneextnNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExtnNo")));
                                    fax=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fax")));
                                    email=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Email")));
                                    alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
									alertMessageCa=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessageCA")));
                                    break;
    							  } else if(workSheetName.equalsIgnoreCase("UnitTest_SS_PayerAdminPlan")){
        								userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                        userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                        userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
                                        switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                        payerWizard=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerWizard")));
                                        payerWizardCA=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerWizardCA")));
                                        payerName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerName")));
                                        payerCode=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PayerCode")));
                                        planName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PlanName")));
                                        coPay=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoPay")));
                                        specialistCoPay=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SpecialistCoPay")));
                                        deductible=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Deductible")));
                                        coInsurance=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoInsurance")));
                                        alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
    									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
    									alertMessageCa=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessageCA")));
                                        break;
        							  }else if(workSheetName.equalsIgnoreCase("UnitTest_SS_DirectoriesCAView")){
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
                                    //phone=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Phone")));
                                    telephoneextnNo1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExtnNo")));
                                    fax=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fax")));
                                    //fax1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Fax1")));
                                    email=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Email")));
                                    webAddress=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Website")));
                                    salutation=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Salutation")));
                                    lastName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
                                    firstName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
                                    comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
                                    alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
                                    break;
    							}	else if(workSheetName.equalsIgnoreCase("UitTest_SS_UserRole")){
    								userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    userRole= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserRole")));
                                    description= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
                                    alert=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AlertPresent")));
									alertMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExpectedMessage")));
                                    break;
    							}
							}else{
								break;
							}
						}else {
							break;
						}
					}	
				}if(isDataFound){
					break;
				}
			}if(!isDataFound){
				Assert.fail("\nTest Data not found in test data sheet for Test Case Id  : " + testCaseId);
			}
		}catch(RuntimeException e){
			Assert.fail("Error During Execution; Execution Failed More detaisl " + e);
			e.printStackTrace();
		}
		return isDataFound;
	}
}
							
