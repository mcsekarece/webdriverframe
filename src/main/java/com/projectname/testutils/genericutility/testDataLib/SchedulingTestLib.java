package com.projectname.testutils.genericutility.testDataLib;


import java.lang.reflect.Field;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;

import com.projectname.testutils.genericutility.ReadFromExcel;

public class SchedulingTestLib {

	public String testCaseId = null;
	public String userAccount = null;
	public String userName = null;
	public String userPassword = null;
	public String switchRole=null;
	public String switchRole1=null;
	public String consentReason = null;
	public String visitName=null;
	public String duration=null;
	public String duration1 = null;
	public String cannotRepeat=null;
	public String refferedBy=null;
	public String confirmvisit=null;
	public String followVisit=null;
	public String practice=null;
	public String editStatus=null;
	public String allowmultipleBooking=null;
	public String multipleBooking=null;
	public String selectedLoaction=null;
	public String followUp=null;
	public String providerName=null;
	public String followuptime = null;
	public String confirmationDate=null;
	public String bookingDetails=null;
	public String patientDetails = null;
	public String visitModel=null;
	public String regional = null;
	public String templateName=null;
	
	public String roomName=null;
	public String location=null;
	public String equipmentName=null;
	public String mobilitystat=null;
	public String coordinate=null;
	
	public String staffName=null;
	public String searchResource = null;
	public String resource = null;
	public String cycle  = null;
	public String effectiveDate = null;
	public String search=null;
	public String patternStartsDate=null;
	public String patternStartsMonth=null;
	public String patternStartsMonth1=null;
	public String patternEndDate=null;
	public String patternStartsDate1=null;
	public String endDate=null;
	public String endDateCa=null;
	public String practiceName=null;
	public String location1=null;
	public String location2=null;
	
	public String coordinateMon=null;
	public String coordinateTues=null;
	public String coordinateWed=null;
	public String coordinateThur=null;
	public String coordinateFri=null;	
	
	public String groupName=null;
	public String resourceGroupName=null;
	public String searchResourceName=null;	
	
	public String startHour=null;
	public String startMin=null;
	public String startFormat=null;
	public String endHour=null;
	public String endMin=null;
	public String endFormat=null;
	public String maxBooking=null;
	public String patientId = null;
	
	public String lastName = null;
	public String firstName = null;
	public String middleName = null;
	public String resourceName=null;
	public String title = null;
	public String suffix = null;
	public String alias1 = null;
	public String alias2 = null;
	public String dob = null;
	public String dobCa = null;
	public String estimatedCheck = null;
	public String prematureCheck = null;
	public String measure =null;
	public String sex = null;
	public String maritalStatus = null;
	public String status = null;
	public String statusDate = null;
	public String reasonForInactivation =null;
	public String phoneType =null;
	public String phoneNo = null;
	public String phoneNoFormat =null;
	public String extnNo = null;
	public String visitType = null;
	public String editVisitType = null;
	public String referredBy = null;
	public String referredByVisit = null;
	public String comments =null;
	
	public String programType = null;
	public String description = null;
	public String plan = null;
	public String culture = null;
	public String language = null;
	
	public String seriesName = null;
	public String groupsize = null;
	public String seriesTrigger = null;
	public String visit = null;
	public String visitDate = null;
	public String allowOnly = null;
	public String participantscan = null;
	public String taskPlace = null;
	public String recurringDate = null;
	public String individualDate = null;
	public String daily = null;
	public String weekly = null;
	public String monthly = null;
	public String yearly = null;
	public String end = null;
	public String endOccurence = null;
	public String recurrenceDate = null;
	public String interalStaff = null;
	public String externalStaff = null;
	public String role = null;
	public String credential = null;
	public String priorState = null;
	public String reason = null;
	public String pPhone = null;
	public String eMail = null;
	public String issueAddressed = null;
	public String referredByProvider = null;
	public String referredByPracticename = null;
	
	public String pgmName = null;
	public String grpCoordinator = null;
	public String locationType = null;
	public String room = null;
	public String startDate = null;
	public String timeAmPM = null;
	public String everyWeek = null;
	public String afterOcc = null;
	public String patientName = null;
	
	public String verifyAuthorization=null;
	public String verifyVisitsAllowed=null;
	public String verifyVisitsScheduled=null;
	public String verifyNumberUsed=null;
	
	public String workSheetName = null;
	public String workBookName = "TestData_Scheduling.xls";		
	public String sectionName = "schedulingsettings";
	
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
		
	public boolean fetchSchedulingTestData(){
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
					for(int c = 0; c < excelrRowColumnCount.get("ColumnCount"); ) {						
						cell = row.getCell(excelHeaders.get("TestID"));
						if(cell != null){
							temptestCaseId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TestID")));
							if(temptestCaseId.equals(testCaseId)){
								isDataFound = true;	
								
								if(workSheetName.equalsIgnoreCase("VerifySecurityOption")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									break;
								}else if(workSheetName.equalsIgnoreCase("CreateVisittype")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									visitName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitName")));
									duration = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
	                                cannotRepeat = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CannotRepeat")));
	                                visitModel = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitModel")));
	                                allowmultipleBooking = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllowmultipleBooking")));
	                                followVisit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FollowVisit")));
	                                followUp = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FollowUp")));
	                                followuptime = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Followuptime")));
	                                confirmvisit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Confirmvisit")));
	                                confirmationDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConfirmationDate")));
									bookingDetails = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("BookingInstructions")));
									patientDetails = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientInstruction")));
									regional = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Regional")));
	                                break;
								}else if(workSheetName.equalsIgnoreCase("CalendarTemplate")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									templateName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplateName")));
									break;
								}else if(workSheetName.equalsIgnoreCase("NonProviderResource")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									roomName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RoomName")));
									location=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location")));
									equipmentName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EquipmentName")));
									mobilitystat=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MobilityStationary")));
									staffName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StaffName")));
									break;
								}else if(workSheetName.equalsIgnoreCase("ResourceGroup")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									resourceGroupName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ResourceGroupName")));									
									searchResourceName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchResourceName")));
									break;
								}else if(workSheetName.equalsIgnoreCase("CreateResourceCalender")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									searchResource = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchResource")));
									resource = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Resource")));
	                                cycle = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Cycle")));
	                                effectiveDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EffectiveOn")));
	                                endDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndDate")));
	                                endDateCa = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndDateCA")));
	                                search =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Search")));
	                                patternStartsDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatternDate")));
									patternStartsMonth = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatternMonth")));
									patternStartsDate1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatternDate1")));
									patternStartsMonth1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatternMonth1")));
									patternEndDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatternEndDate")));
									location = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location")));
									visitType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitType")));
									coordinateMon = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoordinateMon")));
									coordinateTues = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoordinateTues")));
									coordinateWed = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoordinateWed")));
									coordinateThur = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoordinateThur")));
									coordinateFri = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CoordinateFri")));									
									startHour = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartHour")));
									startMin = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartMin")));
									startFormat = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartFormat")));
									endHour = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndHour")));
									endMin = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndMin")));
									endFormat = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndFormat")));
									maxBooking = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaxBooking")));
									reason = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
									referredByProvider= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferredByProvider")));
									referredByPracticename= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferredByPracticename")));
									break;									
								}else if(workSheetName.equalsIgnoreCase("LocationHours")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									practiceName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeName")));
									location1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location1")));
									location2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location2")));
									startHour=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartHour")));
									startMin=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartMin")));
									startFormat=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartFormat")));
									endHour=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndHour")));
									endMin=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndMin")));
									endFormat=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndFormat")));
									break;
								}else if(workSheetName.equalsIgnoreCase("CreateVisitGroup")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									groupName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupName")));
									visitName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitName")));
									break;
								}else if(workSheetName.equalsIgnoreCase("PortVisitTypeCAView")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									visitName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitName")));
									duration = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
	                                cannotRepeat = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CannotRepeat")));
	                                allowmultipleBooking = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllowmultipleBooking")));
	                                multipleBooking = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MultipleBooking")));
	                                selectedLoaction= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SelectedLoaction")));
	                                location1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location1")));
	                                location2= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location2")));
	                                break;
								}else if(workSheetName.equalsIgnoreCase("PortCreateVisitTypeUSView")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									visitName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitName")));
									practiceName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeName")));
									duration = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
									visitModel = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitModel")));
									break;
								}else if(workSheetName.equalsIgnoreCase("PortVisitGroup")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									practiceName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeName")));
									groupName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupName")));
									visitName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitName")));
									break;
								}else if(workSheetName.equalsIgnoreCase("NonProviderResourcePortability")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									roomName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RoomName")));
									location=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location")));
									equipmentName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EquipmentName")));
									mobilitystat=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MobilityStationary")));
									staffName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StaffName")));
									break;
								} 
								else if(workSheetName.equalsIgnoreCase("LocationHoursPortability")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									practiceName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PracticeName")));
									location1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location1")));
									location2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location2")));
									startHour=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartHour")));
									startMin=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartMin")));
									endHour=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndHour")));
									endMin=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndMin")));
									break;
									
								}else if(workSheetName.equalsIgnoreCase("PatientTimeLine")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									visitType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitType")));
									editVisitType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EditVisitType")));
									referredBy  = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferredBy")));
									referredByVisit  = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReferredByVisit")));
									duration  = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
									comments  = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
									break;
									
								}else if(workSheetName.equalsIgnoreCase("NewPatientCheckIn" )){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password"))); 
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
                                    firstName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
                                    middleName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MiddleName")));
                                    title=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Title"))); 
                                    suffix=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Suffix")));
                                    alias1=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alias1")));
									alias2=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Alias2")));    
									dob=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DOB")));		
									dobCa=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DOBCA")));
									estimatedCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EstimatedCheck")));		
									prematureCheck=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrematureCheck")));
									duration=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
									measure=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Measure")));
									sex=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Sex")));
									maritalStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MaritalStatus")));
									status=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Status")));
									statusDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StatusDate")));
									reasonForInactivation = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ReasonForInactivation")));
									phoneType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PhoneType")));
									phoneNo = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PhoneNo")));
									phoneNoFormat = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PhoneNoFormat")));
									extnNo = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExtnNo")));
									break;
									
                                  }else if(workSheetName.equalsIgnoreCase("ProgramGroupAdmin")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									switchRole1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole1")));
									programType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProgramType")));
									groupName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupName")));
									description = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
									plan = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProgramPlan")));
									culture = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Culture")));
									language = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Language")));
									break;
									
								}else if(workSheetName.equalsIgnoreCase("ScheduleSeries")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									seriesName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SeriesName")));
									groupsize = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Groupsize")));
									seriesTrigger = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SeriesTrigger")));
									visitDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitDate")));
									taskPlace = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TaskPlace")));
									recurringDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RecurringDate")));
									individualDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IndividualDate")));
									daily = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Daily")));
									weekly = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Weekly")));
									monthly = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Monthly")));
									yearly = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Yearly")));
									end = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("End")));
									endOccurence = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndOccurence")));
									endDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndDate")));
									duration = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
									duration1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration1")));
									recurrenceDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("RecurrenceDate")));
									interalStaff = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("InteralStaff")));
									externalStaff = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ExternalStaff")));
									role = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
									firstName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
									lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
									credential = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Credential")));
									location = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Loaction")));
									patientName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
									priorState = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PriorState")));
									reason = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
									comments = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
									pPhone = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PrimaryPhone")));
									eMail = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Email")));
									issueAddressed = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IssueAddressed")));
									break;
									
								}else if(workSheetName.equalsIgnoreCase("ProgramAddSeries")){
								    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									seriesName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SeriesName")));
									groupName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupSize")));
									pgmName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProgramName")));
									grpCoordinator=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupCoordinator")));
									locationType=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LocationType")));
									location=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location")));
									room=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Room")));
									startDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate")));
									startHour=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartHour")));
									startMin=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartMin")));
									timeAmPM=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TimeAmPm")));
									everyWeek=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EveryWeek")));
									afterOcc=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AfterOccurrence")));
									endDate=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndDate")));
									patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
									break;
								}else if(workSheetName.equalsIgnoreCase("VisitsEndToEnd"))
								{
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									patientId = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientId")));
									verifyAuthorization=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Authorization")));
									verifyVisitsAllowed=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitsAllowed")));
									verifyVisitsScheduled=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitsScheduled")));
									verifyNumberUsed=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("NumberUsed")));
									editStatus=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EditStatus")));
									location=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Location")));
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