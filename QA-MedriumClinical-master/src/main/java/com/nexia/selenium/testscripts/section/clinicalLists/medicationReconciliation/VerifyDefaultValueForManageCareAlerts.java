package com.nexia.selenium.testscripts.section.clinicalLists.medicationReconciliation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultValueForManageCareAlerts extends AbstractClinicalList  {
	@Test(enabled=false)
	/*@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Default Value For ManageCareAlerts")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	*/
	public void verifyDefaultValueForManageCareAlerts(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalListLib alertData = new ClinicalListLib();
		alertData.workSheetName = "ManageCareAlerts";
		alertData.testCaseId = "TC_MCA_006";
		alertData.fetchClinicalListTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    VerifyDefaultValue(seleniumHost, seleniumPort, browser, webSite, userAccount, alertData);
	    
	}
	
	/**
	 * Verify DefaultValue For ManageCare Alerts
	 * function to verify Default Value for   ManageCare Alerts
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 25, 2013
	 */

	public boolean VerifyDefaultValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib alertData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		@SuppressWarnings("unused")
		String date =null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + alertData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, alertData.userName, alertData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//---------------------------------------------------------- ----------//
			//  Step-2:Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,alertData.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to ManageCare Alerts //
			//--------------------------------------------------------------------//
		
			assertTrue(gotoManageCareAlerts(selenium),"Could not Navigate to goto ManageCare Alerts",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Default value for ManageCare Alerts //
			//--------------------------------------------------------------------//
			
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				cal.add(Calendar.YEAR,1); 
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
			 	date=DateFormat1.format(cal.getTime());
		    }else {
					Calendar cal=Calendar.getInstance();
					cal.add(Calendar.YEAR,1);
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
					date=DateFormat1.format(cal.getTime());
			}
			
			if(!isChecked(selenium,chkManageCare))
				assertTrue(click(selenium,chkManageCare),"Could not click the chk box ManageCare",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
			/*if(!getValue(selenium,txtDueDate.trim()).contains(date.trim())){
				Assert.fail("Verify Default value for ManageCare Alerts failed");
			}*/
				assertTrue(getValue(selenium,txtRecurring).contains(alertData.recurringPeriod),"Verify Default value for ManageCare Alerts failed",selenium,ClassName,MethodName);
				
				assertTrue(getValue(selenium,ajxOccurrenceUnitSuggestBox).contains(alertData.recurringUnit),"Verify Default value for ManageCare Alerts failed",selenium,ClassName,MethodName);
				
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
}		
}
	