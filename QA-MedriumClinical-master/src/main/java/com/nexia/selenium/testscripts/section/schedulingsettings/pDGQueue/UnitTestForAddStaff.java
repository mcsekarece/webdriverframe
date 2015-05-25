/*package com.nexia.selenium.testscripts.section.schedulingsettings.pDGQueue;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingUnitTestLib;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForAddStaff extends AbstractSchedulingTest {
    @Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Create staff With Interal")
    @Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
    public void roleWithInvalid(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib pData = new SchedulingUnitTestLib();
		pData.workSheetName = "UniTest_Participant";
		pData.testCaseId = "TC_UP_004";
		pData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addStaff(seleniumHost, seleniumPort, browser, webSite, userAccount, pData);
    }
    @Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Create staff With Interal")
    @Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
    public void roleWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib pData = new SchedulingUnitTestLib();
		pData.workSheetName = "UniTest_Participant";
		pData.testCaseId = "TC_UP_005";
		pData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addStaff(seleniumHost, seleniumPort, browser, webSite, userAccount, pData);
    }
    @Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Create staff With Interal")
    @Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
    public void fnameWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib pData = new SchedulingUnitTestLib();
		pData.workSheetName = "UniTest_Participant";
		pData.testCaseId = "TC_UP_006";
		pData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addStaff(seleniumHost, seleniumPort, browser, webSite, userAccount, pData);
    }
    @Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Create staff With Interal")
    @Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
    public void lnameWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib pData = new SchedulingUnitTestLib();
		pData.workSheetName = "UniTest_Participant";
		pData.testCaseId = "TC_UP_007";
		pData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addStaff(seleniumHost, seleniumPort, browser, webSite, userAccount, pData);
    }
    @Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Create staff With Interal")
    @Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
    public void fnameWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib pData = new SchedulingUnitTestLib();
		pData.workSheetName = "UniTest_Participant";
		pData.testCaseId = "TC_UP_008";
		pData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addStaff(seleniumHost, seleniumPort, browser, webSite, userAccount, pData);
    }
    @Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Create staff With Interal")
    @Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
    public void lnameWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib pData = new SchedulingUnitTestLib();
		pData.workSheetName = "UniTest_Participant";
		pData.testCaseId = "TC_UP_009";
		pData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addStaff(seleniumHost, seleniumPort, browser, webSite, userAccount, pData);
    }
    @Test(groups = {"SingleThreadUnit","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Create staff With Interal")
    @Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
    public void credentialsWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingUnitTestLib pData = new SchedulingUnitTestLib();
		pData.workSheetName = "UniTest_Participant";
		pData.testCaseId = "TC_UP_010";
		pData.fetchSchedulingSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addStaff(seleniumHost, seleniumPort, browser, webSite, userAccount, pData);
    }

    *//*************************************************************************************************** 
	* @purpose        To create staff with Internal and External
	* @action 	  verify create staff with Internal and External 
	* @expected       To Ensure that the staff with Internal and External works fine 
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES / & SRS_ADMIN_PDG_Rev 0.0  
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 24, 2013
	***************************************************************************************************//*
	public boolean addStaff(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingUnitTestLib pData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
		    SchedulingTestLib pDGData = new SchedulingTestLib();
			pDGData.workSheetName = "ScheduleSeries";
			pDGData.testCaseId = "TC_SS_018";
			pDGData.fetchSchedulingTestData();
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pDGData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, pDGData.userName, pDGData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
	
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pDGData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate To Progarm Group						  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Could not navigate to Calender Setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkProgramGroup), "could not able to click the Program group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Program Group					  //
			//--------------------------------------------------------------------//
			assertTrue(deleteProgramForPDGAdmin(selenium,pDGData),"Could not delete Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAdd),"Could not click add new button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-5: Create Program					  //
			//--------------------------------------------------------------------//
			SchedulingTestLib pDAData = new SchedulingTestLib();
			pDAData.workSheetName = "ProgramGroupAdmin";
			pDAData.testCaseId = "TC_PDG_009";
			pDAData.fetchSchedulingTestData();
			
			selectValueFromAjaxList(selenium,ajxProgramType,pDAData.programType);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createProgramForPDGAdmin(selenium,pDAData,uniqueName),"Could not Create Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6 : Verify Schedule series 					  //
			//--------------------------------------------------------------------//
			assertTrue(selenium.isTextPresent("Schedule Series"),"Schedule Series text is not present", selenium, ClassName, MethodName);
			
			if(selenium.isTextPresent(pDAData.groupName)){
				returnValue = true;
			}else{
				Assert.fail("Group Name is not present");
			}
			
			//--------------------------------------------------------------------//
			//  Step-7: Create Schedule Series				  //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll( ", "+pDGData.switchRole, "");
			
			String location = getText(selenium,lnkLocationHeader).replace("...", "") ;
			assertTrue(createScheduleSerieswithPersonalType(selenium,pDGData,uniqueName,providerName, location,userAccount),"Could not Create Schedule Series", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSeriesNext),"Could not click the next button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,"seriesDoneButton"),"Could not click the next button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click logo",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//assertTrue(selectValueFromAjaxList(selenium,"pdgFiltersuggestBox","All Series"),"Could not enter patinet name", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			int count =1;
			int dataCount = (Integer) selenium.getXpathCount("//div[@id='printInfo']/div/div/div[3]/div/div[2]/div[2]/div");
			for(count = 1; count <= dataCount  ; count++){
				System.out.println(getText(selenium,"//div[@id='printInfo']/div/div/div[3]/div/div[2]/div[2]/div["+count+"]"));
				System.out.println(pDAData.groupName);
				if(getText(selenium,"//div[@id='printInfo']/div/div/div[3]/div/div[2]/div[2]/div["+count+"]").contains(pDGData.seriesName)){
				    assertTrue(click(selenium,"xpath=(//a[@id='viewChart'])["+count+"]"),"Could not click down arrow",selenium,ClassName,MethodName);
				    waitForPageLoad(selenium);	
				    break;
				}
			
				if(count == dataCount){
					if(selenium.getAttribute("//div[@class='subSectionBorderTopRoundedCorner formWidgets width630px']/div/div/div[4]/a@class").contains("inlineBlock arrowDownOn")){
						assertTrue(click(selenium,"//div[@class='subSectionBorderTopRoundedCorner formWidgets width630px']/div/div/div[4]/a"), selenium, ClassName, MethodName);
						count = 1;
					}else
						break;
				}
			}
			
			int count=0;
			while(selenium.isVisible(btnDownArrow)){
			    assertTrue(click(selenium,btnDownArrow),"Could not click down arrow",selenium,ClassName,MethodName);
			    waitForPageLoad(selenium);
			    count++;
			    if(count>15){
				break;
			    }
			}
			int count1=1;
			while(isElementPresent(selenium,"//div[@id='printInfo']/div/div/div[3]/div/div[2]/div[2]/div["+count1+"]")){
			    if(getText(selenium,"//div[@id='printInfo']/div/div/div[3]/div/div[2]/div[2]/div["+count1+"]").toLowerCase(new java.util.Locale("en","Us")).trim().contains(pDGData.seriesName.toLowerCase(new java.util.Locale("en","Us")).trim())){
				assertTrue(click(selenium,"xpath=(//a[@id='viewChart'])["+count1+"]"),"Could not click down arrow",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				count1++;
				
				if(count1>15){
				    break;
				}
			    }
			}
			
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Take Attendance//
			//--------------------------------------------------------------------//
			assertTrue(navigateToTakeAttendanceStaff(selenium,pDAData,pDGData,uniqueName),"Could not Navigate to Take Attendance", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddStaff),"Could not click add new button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,chkExternal),"Could not click External button button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[2]",pData.switchRole);
			assertTrue(type(selenium,"firstName",pData.fName),"Could not enter reason", selenium, ClassName, MethodName);
			assertTrue(type(selenium,"xpath=(//input[@id='firstName'])[2]",pData.lName),"Could not enter reason", selenium, ClassName, MethodName);
			assertTrue(type(selenium,"credentials",pData.credentials),"Could not enter reason", selenium, ClassName, MethodName);
			
			
			if(!(pData.testCaseId.equals("TC_UP_008")||pData.testCaseId.equals("TC_UP_009")||pData.testCaseId.equals("TC_UP_010"))){
			    assertTrue(click(selenium,"//div[4]/div/a/div"),"Could not click add",selenium,ClassName,MethodName);
			    waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify Validation Message//
			//--------------------------------------------------------------------//
			if(!pData.validationFieldID.equals("")){
				assertTrue(isElementPresent(selenium, pData.validationFieldID), "The validation message field did not appear",selenium, ClassName, MethodName);
				assertTrue(getText(selenium, pData.validationFieldID).contains(pData.validationMessage), "The expected validation message should contain the text - "+ pData.validationMessage + " The actual validation message shown - " + getText(selenium, pData.validationFieldID),selenium, ClassName, MethodName);
			}
			//--------------------------------------------------------------------//
			//  Step-8:Verify Max Length details//
			//--------------------------------------------------------------------//
			else{
			    if(pData.testCaseId.equals("TC_UP_008")){
					if(getValue(selenium,"firstName").toLowerCase(new java.util.Locale("en","US")).trim().contains(pData.fName.trim().toLowerCase(new java.util.Locale("en","US")))){
					       return false;
					}
			    }
			    if(pData.testCaseId.equals("TC_UP_009")){
					if(getValue(selenium,"xpath=(//input[@id='firstName'])[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(pData.lName.trim().toLowerCase(new java.util.Locale("en","US")))){
					    	return false;
					}
			    }
			    if(pData.testCaseId.equals("TC_UP_010")){
					if(getValue(selenium,"credentials").toLowerCase(new java.util.Locale("en","US")).trim().contains(pData.credentials.trim().toLowerCase(new java.util.Locale("en","US")))){
					    	return false;
					}
			    }
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}*/