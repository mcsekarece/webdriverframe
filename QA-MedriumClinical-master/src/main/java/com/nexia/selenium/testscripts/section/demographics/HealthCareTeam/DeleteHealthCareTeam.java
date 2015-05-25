package com.nexia.selenium.testscripts.section.demographics.HealthCareTeam;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteHealthCareTeam extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleting a New Health Care Team")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteHealthCareTeamForPatientInfo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib healthTestData = new  HomeLib();
		healthTestData.workSheetName = "EditHealthCareTeam";
		healthTestData.testCaseId = "TC_HCT_004";
		healthTestData.fetchHomeTestData();	
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		deleteHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, healthTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Delete Health Care Team
	* @action 		  Deleting Health Care Team
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 21, 2012
	***************************************************************************************************/
	public boolean deleteHealthCareTeam(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib healthTestData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		String date,time=null;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + healthTestData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, healthTestData.userName, healthTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,healthTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-3:Create role and reason For deletion at Admin section//
			//--------------------------------------------------------------------//
			HomeLib epData = new  HomeLib();
			epData.workSheetName = "AdminHealthCareTeam";
			epData.testCaseId = "TC_HCTA_001";
			epData.fetchHomeTestData();
			
			//---------------------------------------------------------- ----------//
			//  Step-4:Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,healthTestData.patientID);
			waitForPageLoad(selenium);
			
			//Create a new Health Care Team
			click(selenium,lnkPatientHealthcare);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-5: Deleting existing Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllHealthCareteam(selenium,epData,userAccount), "Could not delete all health care team ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			//  Step-6: Edit Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit),"Could not click the edit button;More details:"+healthTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createHealthCare(selenium,healthTestData,epData,userAccount),"Health Care team Editing failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat.format(cal.getTime());
				DateFormat=new SimpleDateFormat("HH");
				 time=DateFormat.format(cal.getTime());
			}else{
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat.format(cal.getTime());
					DateFormat=new SimpleDateFormat("HH");
					time=DateFormat.format(cal.getTime());
			}
			assertTrue(click(selenium,lnkExpandAll),"Could not click Expand All; More Details :" + healthTestData.toString(), selenium, ClassName, MethodName);
			assertTrue(verifyTimeStamp(selenium, "css=span.last-updated-by.button-alignment", date, time),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-7: Delete newly added Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllHealthCareteam(selenium,epData,userAccount), "Could not delete all health care team ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-8: Verify deleted Health Care Team //
			//--------------------------------------------------------------------//
				int count=1;
				while(isElementPresent(selenium,"//div[@id='PatientHealthcareTeamList']/table/tbody/tr["+count+"]/td/div/span/div")){
					if(getText(selenium,"//div[@id='PatientHealthcareTeamList']/table/tbody/tr["+count+"]/td/div/span/div").contains(healthTestData.duration)) {
						click(selenium,"//div[@id='AdminReferringProviderList']/table/tbody/tr["+count+"]/td/div/span");
						Assert.fail("HealthC are details not deleted properly");
						waitForPageLoad(selenium);
					}
				}
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	} 
}
