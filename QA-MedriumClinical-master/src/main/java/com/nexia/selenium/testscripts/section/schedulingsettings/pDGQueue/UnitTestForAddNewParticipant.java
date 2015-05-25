//package com.nexia.selenium.testscripts.section.schedulingsettings.pDGQueue;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//
//import org.testng.Assert;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
//import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
//import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingUnitTestLib;
//import com.thoughtworks.selenium.Selenium;
//
//public class UnitTestForAddNewParticipant extends AbstractSchedulingTest{
//	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For First Name with empty")
//	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
//	public void firstNameWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
//		SchedulingUnitTestLib pData = new SchedulingUnitTestLib();
//		pData.workSheetName = "UniTest_Participant";
//		pData.testCaseId = "TC_UP_011";
//		pData.fetchSchedulingSettingsTestData();
//		ClassName=this.getClass().getName().substring(39);	
//		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
//		unitNewParticipant(seleniumHost, seleniumPort, browser, webSite, userAccount, pData);
//	}
//	 
//	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Last Name with empty")
//	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
//	public void lastNameWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
//		SchedulingUnitTestLib pData = new SchedulingUnitTestLib();
//		pData.workSheetName = "UniTest_Participant";
//		pData.testCaseId = "TC_UP_012";
//		pData.fetchSchedulingSettingsTestData();
//		ClassName=this.getClass().getName().substring(39);	
//		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
//		unitNewParticipant(seleniumHost, seleniumPort, browser, webSite, userAccount, pData);
//	}
//	 
//	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For primary phone with empty")
//	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
//	public void primaryPhoneWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
//		SchedulingUnitTestLib pData = new SchedulingUnitTestLib();
//		pData.workSheetName = "UniTest_Participant";
//		pData.testCaseId = "TC_UP_013";
//		pData.fetchSchedulingSettingsTestData();
//		ClassName=this.getClass().getName().substring(39);	
//		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
//		unitNewParticipant(seleniumHost, seleniumPort, browser, webSite, userAccount, pData);
//	}
//	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Email with empty")
//	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
//	public void eMailWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
//		SchedulingUnitTestLib pData = new SchedulingUnitTestLib();
//		pData.workSheetName = "UniTest_Participant";
//		pData.testCaseId = "TC_UP_014";
//		pData.fetchSchedulingSettingsTestData();
//		ClassName=this.getClass().getName().substring(39);	
//		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
//		unitNewParticipant(seleniumHost, seleniumPort, browser, webSite, userAccount, pData);
//	}
//	 
//	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Reason Name with empty")
//	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
//	public void reasonWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
//		SchedulingUnitTestLib pData = new SchedulingUnitTestLib();
//		pData.workSheetName = "UniTest_Participant";
//		pData.testCaseId = "TC_UP_015";
//		pData.fetchSchedulingSettingsTestData();
//		ClassName=this.getClass().getName().substring(39);	
//		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
//		unitNewParticipant(seleniumHost, seleniumPort, browser, webSite, userAccount, pData);
//	}
//	
//	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For prior State with empty")
//	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
//	public void priorStateWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
//		SchedulingUnitTestLib pData = new SchedulingUnitTestLib();
//		pData.workSheetName = "UniTest_Participant";
//		pData.testCaseId = "TC_UP_016";
//		pData.fetchSchedulingSettingsTestData();
//		ClassName=this.getClass().getName().substring(39);	
//		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
//		unitNewParticipant(seleniumHost, seleniumPort, browser, webSite, userAccount, pData);
//	}
//	
//	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For First Name with max length")
//	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
//	public void firstNameWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
//		SchedulingUnitTestLib pData = new SchedulingUnitTestLib();
//		pData.workSheetName = "UniTest_Participant";
//		pData.testCaseId = "TC_UP_017";
//		pData.fetchSchedulingSettingsTestData();
//		ClassName=this.getClass().getName().substring(39);	
//		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
//		unitNewParticipant(seleniumHost, seleniumPort, browser, webSite, userAccount, pData);
//	}
//	
//	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For last Name with max length")
//	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
//	public void lastNameWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
//		SchedulingUnitTestLib pData = new SchedulingUnitTestLib();
//		pData.workSheetName = "UniTest_Participant";
//		pData.testCaseId = "TC_UP_018";
//		pData.fetchSchedulingSettingsTestData();
//		ClassName=this.getClass().getName().substring(39);	
//		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
//		unitNewParticipant(seleniumHost, seleniumPort, browser, webSite, userAccount, pData);
//	}
//	
//	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For reason with max length")
//	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
//	public void resonWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
//		SchedulingUnitTestLib pData = new SchedulingUnitTestLib();
//		pData.workSheetName = "UniTest_Participant";
//		pData.testCaseId = "TC_UP_019";
//		pData.fetchSchedulingSettingsTestData();
//		ClassName=this.getClass().getName().substring(39);	
//		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
//		unitNewParticipant(seleniumHost, seleniumPort, browser, webSite, userAccount, pData);
//	}
//	
//	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For comment with max length")
//	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
//	public void commentWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
//		SchedulingUnitTestLib pData = new SchedulingUnitTestLib();
//		pData.workSheetName = "UniTest_Participant";
//		pData.testCaseId = "TC_UP_020";
//		pData.fetchSchedulingSettingsTestData();
//		ClassName=this.getClass().getName().substring(39);	
//		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
//		unitNewParticipant(seleniumHost, seleniumPort, browser, webSite, userAccount, pData);
//	}
//	
//	@Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For phone No with Invalid Data")
//	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
//	public void phoneNoWithInValidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
//		SchedulingUnitTestLib pData = new SchedulingUnitTestLib();
//		pData.workSheetName = "UniTest_Participant";
//		pData.testCaseId = "TC_UP_021";
//		pData.fetchSchedulingSettingsTestData();
//		ClassName=this.getClass().getName().substring(39);	
//		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
//		unitNewParticipant(seleniumHost, seleniumPort, browser, webSite, userAccount, pData);
//	}
//	 /*************************************************************************************************** 
//	* @purpose        To verify unitTest_AddNewParticipant
//	* @action 	 	  verify unitTest_AddNewParticipant
//	* @expected       To Ensure that the unitTest_AddNewParticipant works fine 
//	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES / & SRS_ADMIN_PDG_Rev 0.0  
//	* @author         Aspire Qa
//	* @state          Developing
//	* @useraccount    Both (US and Canada)
//	* @since  	      Oct 24, 2013
//	***************************************************************************************************/
//	public boolean unitNewParticipant(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingUnitTestLib pData) throws Exception{
//		Selenium selenium=null;
//		boolean returnValue=true;
//		
//		try{
//			//--------------------------------------------------------------------//
//			//  Step-1: Login to the application and search for the given patient //
//			//--------------------------------------------------------------------//
//			    
//			SchedulingTestLib pDGData = new SchedulingTestLib();
//			pDGData.workSheetName = "ScheduleSeries";
//			pDGData.testCaseId = "TC_SS_014";
//			pDGData.fetchSchedulingTestData();
//				
//			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
//			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pDGData.toString());
//			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, pDGData.userName, pDGData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
//		
//			//--------------------------------------------------------------------//
//			//  Step-2:Change Switch Role  										  //
//			//--------------------------------------------------------------------//
//			assertTrue(switchRole(selenium,pDGData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
//				
//			//--------------------------------------------------------------------//
//			//  Step-3:Navigate To Progarm Group						  //
//			//--------------------------------------------------------------------//
//			assertTrue(goToScheduling(selenium),"Could not navigate to Calender Setting", selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
//				
//			waitForPageLoad(selenium);
//			assertTrue(click(selenium, lnkProgramGroup), "could not able to click the Program group link", selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
//				
//			//--------------------------------------------------------------------//
//			//  Step-4: Delete Program Group					  //
//			//--------------------------------------------------------------------//
//			SchedulingTestLib pDAData = new SchedulingTestLib();
//			pDAData.workSheetName = "ProgramGroupAdmin";
//			pDAData.testCaseId = "TC_PDG_009";
//			pDAData.fetchSchedulingTestData();
//			
//			assertTrue(deleteProgramForPDGAdmin(selenium,pDGData),"Could not delete Program Group", selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
//				
//			assertTrue(click(selenium,btnAdd),"Could not click add new button",selenium,ClassName,MethodName);
//			waitForPageLoad(selenium);
//					
//			//--------------------------------------------------------------------//
//			//  Step-5: Create Program					  //
//			//--------------------------------------------------------------------//
//			selectValueFromAjaxList(selenium,ajxProgramType,pDAData.programType);
//			waitForPageLoad(selenium);
//				
//			Calendar cal=Calendar.getInstance();
//			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//			String uniqueName=DateFormat.format(cal.getTime());
//				
//			assertTrue(createProgramForPDGAdmin(selenium,pDAData,uniqueName),"Could not Create Program Group", selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
//				
//			//--------------------------------------------------------------------//
//			//  Step-6 : Verify Schedule series 					  //
//			//--------------------------------------------------------------------//
//			assertTrue(selenium.isTextPresent("Schedule Series"),"Schedule Series text is not present", selenium, ClassName, MethodName);
//				
//			if(selenium.isTextPresent(pDAData.groupName)){
//				returnValue = true;
//			}else{
//				Assert.fail("Group Name is not present");
//			}
//				
//			//--------------------------------------------------------------------//
//			//  Step-7: Create Schedule Series				  //
//			//--------------------------------------------------------------------//
//			String providerNameTemp= getText(selenium, lnkTopMenu);
//			String providerName= providerNameTemp.replaceAll( ", "+pDGData.switchRole, "");
//				
//			String location = getText(selenium,lnkLocationHeader).replace("...", "") ;
//			assertTrue(createScheduleSerieswithPersonalType(selenium,pDGData,uniqueName,providerName, location,userAccount),"Could not Create Schedule Series", selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
//			assertTrue(click(selenium,btnSeriesNext),"Could not click the next button", selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
//			
//			assertTrue(click(selenium,"seriesDoneButton"),"Could not click the next button", selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
//		
//			assertTrue(click(selenium,btnNexiaLogo),"Could not click logo",selenium,ClassName,MethodName);
//			waitForPageLoad(selenium);
//			
//			//--------------------------------------------------------------------//
//			//  Step-8: Navigate to Take Attendance//
//			//--------------------------------------------------------------------//
//			assertTrue(navigateToTakeAttendance(selenium,pDGData,pDAData,uniqueName),"Could not Navigate to Take Attendance", selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
//			
//			//--------------------------------------------------------------------//
//			//  Step-9:Add a Patient//
//			//--------------------------------------------------------------------//
//			assertTrue(click(selenium,btnAdd),"Could not click on add new button", selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
//			
//			click(selenium,"css=div.add-button");
//			assertTrue(unitNewPatient(selenium,pData),"Add patient", selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
//			pData.validationFieldID = pData.validationFieldID == null ? pData.validationFieldID ="" : pData.validationFieldID.trim();
//			if(!pData.validationFieldID.equals("")){
//				assertTrue(isElementPresent(selenium, pData.validationFieldID), "The validation message field did not appear",selenium, ClassName, MethodName);
//				assertTrue(getText(selenium, pData.validationFieldID).contains(pData.validationMessage), "The expected validation message should contain the text - "+ pData.validationMessage + " The actual validation message shown - " + getText(selenium, pData.validationFieldID),selenium, ClassName, MethodName);
//			}else{
//				if(pData.testCaseId.equals("TC_UP_017")){
//					if(getValue(selenium,txtFirstName).contains(pData.fName)){
//						return false;
//					}
//				}
//				if(pData.testCaseId.equals("TC_UP_018")){
//					if(getValue(selenium,txtLastName).contains(pData.lName)){
//						return false;
//					}
//				}
//				if(pData.testCaseId.equals("TC_UP_019")){
//					if(getValue(selenium,txtReason).contains(pData.reason)){
//						return false;
//					}
//				}
//				if(pData.testCaseId.equals("TC_UP_020")){
//					if(getValue(selenium,txtComments).contains(pData.comments)){
//						return false;
//					}
//				}
//				
//			}
//
//		}
//		catch(RuntimeException e){
//		e.printStackTrace();
//		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
//		}
//		return returnValue;
//	}
//
//}
