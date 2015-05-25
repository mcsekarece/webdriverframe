package com.nexia.selenium.genericlibrary.schedulingsettings;

import java.lang.reflect.Field;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.Assert;

import com.sharedlibrary.ReadFromExcel;

public class SchedulingUnitTestLib {
	
	public String testCaseId = null;
	public String userAccount = null;
	public String userName = null;
	public String userPassword = null;
	public String validationFieldID= null;
	public String validationMessage = null;
	public String switchRole=null;
	public String templateName=null;
	
	public String visitName=null;
	public String duration=null;
	public String cannotRepeat=null;
	
	public String confirmvisit=null;
	public String followVisit=null;
	public String allowmultipleBooking=null;
	public String followUp=null;
	public String followuptime = null;
	public String confirmationDate=null;
	
	public String searchResource = null;
	public String cycle  = null;
	public String effectiveDate = null;
	public String endDate = null;
	public String patternStartsDate=null;
	public String patternStartsMonth=null;
	public String patternEndDate=null;
	public String groupName=null;
	public String visitType=null;
	
	public String practiceName=null;
	public String location1=null;
	public String location2=null;
	public String startHour=null;
	public String startMin=null;
	public String endHour=null;
	public String endMin=null;
	
	public String programType = null;
	public String programType1 = null;
	public String description = null;
	public String plan = null;

	public String seriesName = null;
	public String gorupSize = null; 
	public String startDate = null;
	public String end = null;
	public String everyDay = null;
	public String useRecurringDate = null;
	public String endAfter = null;
	public String occurrence = null;
	
	public String interalStaff = null;
	public String role = null;
	public String externalStaff = null;
	public String firstName = null;
	public String lastName = null;
	public String credential = null;
	public String daily = null;
	public String weekly = null;
	public String monthly = null;
	public String hours = null;
	public String yearly = null;
	public String minutes = null;
	public String dayOfMonth = null;
	public String monthQualifier = null;
	public String individualDates = null;
	
	public String pgmName = null;
	public String grpCoordinator = null;
	public String locationType = null;
	public String room = null;
	public String timeAmPM = null;
	public String everyWeek = null;
	public String afterOcc = null;
	public String patientName = null;
	public String location=null;
	
	public String priorState=null;
	public String reason=null;
	public String comments=null;
	public String fName=null;
	public String lName=null;
	public String email = null;
	public String phone = null;
	public String credentials=null;
	
	public String workSheetName = null;
	public String workBookName = "TestData_UnitTest_Scheduling.xls";		
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
		
	public boolean fetchSchedulingSettingsTestData(){
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
								if(workSheetName.equalsIgnoreCase("UnitTest_VisitType")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
                                    visitName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitName")));
                                    duration = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
                                    cannotRepeat = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("CannotRepeat")));
                                    allowmultipleBooking = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AllowmultipleBooking")));
                                    followVisit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FollowVisit")));
                                    followUp = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FollowUp")));
                                    followuptime = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Followuptime")));
                                    confirmvisit = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Confirmvisit")));
                                    confirmationDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ConfirmationDate")));
                                    validationFieldID= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationID")));
                                    validationMessage= readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
									break;   
								}else if(workSheetName.equalsIgnoreCase("UnitTest_ResourceCalender")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
                                    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
                                    searchResource = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SearchResource")));
                                    cycle = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Cycle")));
                                    effectiveDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EffectiveOn")));
                                    endDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndDate")));
                                    patternStartsDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatternStartsDate")));
									patternStartsMonth = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatternStartsMonth")));
									patternEndDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatternEndDate")));
                                    validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
									

									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_VisitGroup")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
                                    userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));					
                                    groupName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupName")));
                                    visitType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("VisitType")));
                                    validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_LocationHours")){
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
                                    validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_CalendarTemplate")){
									userAccount = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("AccountNumber")));
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									templateName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("TemplateName")));
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_ProgramGroup")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole =readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									programType = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProgramType")));
									programType1 = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProgramType1")));
									groupName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GroupName")));
									description = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Description")));
									plan = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ProgramPlan")));
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_ScheduleSeries")){
									userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									role = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
									firstName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
									lastName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
									credential = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Credential")));
									seriesName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SeriesName")));
									gorupSize = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("GorupSize")));
									startDate =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("StartDate")));
									useRecurringDate =  readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UseRecurringDate")));
									everyDay = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EveryDay")));
									end = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("End")));
									endAfter = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndAfter")));
									occurrence = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Occurrence")));
									duration = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Duration")));
									endDate = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("EndDate")));
									daily = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Daily")));
									weekly = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Weekly")));
									monthly = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Monthly")));
									yearly = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Yearly")));
									hours = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Hours")));
									minutes = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("minutes")));
									dayOfMonth = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("DayOfMonth")));
									monthQualifier  = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("MonthQualifier")));
									individualDates = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("IndividualDates")));
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
									break;
								}else if(workSheetName.equalsIgnoreCase("UnitTest_SeriesWithParticipant")){
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
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
									break;
								}
								else if(workSheetName.equalsIgnoreCase("UniTest_Participant")){
								    userName = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("UserName")));
									userPassword = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Password")));
									switchRole = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("SwitchRole")));
									priorState=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PriorState")));
									reason=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Reason")));
									comments=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Comments")));
									role=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Role")));
									fName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("FirstName")));
									lName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("LastName")));
									email = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Email")));
									phone = readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Pphone")));
									credentials=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("Credentials")));
									patientName=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("PatientName")));
									validationFieldID=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationFieldID")));
									validationMessage=readTestData.convertHSSFCellToString(row.getCell(excelHeaders.get("ValidationMessage")));
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
