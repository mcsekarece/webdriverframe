package com.nexia.selenium.testscripts.section.clinicalsettings.cdmflowsheets;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractCdmFlowSheets;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMultipleEncounterValues extends AbstractCdmFlowSheets{
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify the Paging arrows and Encounter values for multiple encounters.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMultipleEncounterValues(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_037";
		mcTemplate.fetchClinicalSettingsTestData();
		verifyMultipleEncounterValue(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	/*************************************************************************************************** 
	* @purpose        To verify the Paging arrows and Encounter values for multiple encounters.
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verifying Paging arrows and Encounter values for multiple encounters
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Nov 14, 2014
	***************************************************************************************************/
	
	public boolean verifyMultipleEncounterValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws IOException{
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mcTemplate.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, mcTemplate.userName, mcTemplate.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Change the switch role 									  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,mcTemplate.switchRole),"Could not change the switch role;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Managed Care Template						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareTemplate(selenium),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Managed Care Template						          //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllManagedCareTemplate(selenium,mcTemplate),"Deletion Failed:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Managed Care Template						          //
			//--------------------------------------------------------------------//
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=dateFormat.format(cal1.getTime());
			assertTrue(enterDetailsForeManagedCareTemplate(selenium,mcTemplate,uniqueName),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(addVitalsCareElement(selenium,mcTemplate,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Advanced search with Patient ID                           //
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,mcTemplate.patientId);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-7: Add Vital        								          //
			//--------------------------------------------------------------------//
			AbstractChartPreVisit obj=new AbstractChartPreVisit();
			ChartPreVisitLib vitalsData = new ChartPreVisitLib();
			vitalsData.workSheetName = "CreateVitals";
			vitalsData.testCaseId = "TC_CV_042";
			vitalsData.fetchChartPreVisitTestData();
			for(int i=1;i<=4;i++){
			assertTrue(addVitalsInMultipleEncounters(selenium,vitalsData,uniqueName,userAccount,i),"Creation Failed", selenium, ClassName, MethodName);
			
			assertTrue(obj.goToBeginEncounter(selenium),"Could not navigate to encounter", selenium, ClassName, MethodName);  
			
			}
			assertTrue(addVitalsInMultipleEncounters(selenium,vitalsData,uniqueName,userAccount,-4),"Creation Failed", selenium, ClassName, MethodName);

			Calendar cal = Calendar.getInstance();
			SimpleDateFormat dateFormat1=new SimpleDateFormat("MMM dd, yyyy");
			String date0=dateFormat1.format(cal.getTime());
			cal.add(Calendar.DATE, 2);
			String date1=dateFormat1.format(cal.getTime());
			
			Calendar cal2 = Calendar.getInstance();
			cal2.add(Calendar.DATE, 3);
			SimpleDateFormat dateFormat11=new SimpleDateFormat("MMM dd, yyyy");
			String date2=dateFormat11.format(cal2.getTime());
			
			Calendar cal3 = Calendar.getInstance();
			cal3.add(Calendar.DATE, 4);
			SimpleDateFormat dateFormat12=new SimpleDateFormat("MMM dd, yyyy");
			String date3=dateFormat12.format(cal3.getTime());

			Calendar cal4 = Calendar.getInstance();
			cal4.add(Calendar.DATE, -4);
			SimpleDateFormat dateFormat13=new SimpleDateFormat("MMM dd, yyyy");
			String date4=dateFormat13.format(cal4.getTime());
			
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Managed Care//
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareFlowSheet(selenium,mcTemplate,userAccount ),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify Paging Arrows                                      //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,btnRight),"Could not click the rightArrow", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(selenium.isTextPresent("Baseline ("+date0+")"),"Baseline text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(date2),"date2 text is not present", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent(date3),"date3 text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(mcTemplate.display),"display text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(date1),"display text is not present", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent(date4),"date4 text is present", selenium, ClassName, MethodName);

			assertTrue(click(selenium,btnLeft),"Could not click the rightArrow", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(selenium.isTextPresent("Baseline ("+date0+")"),"Baseline text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(date2),"date2 text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(date3),"date3 text is not present", selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent(mcTemplate.display),"display text is not present", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent(date1),"display text is not present", selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent(date4),"date4 text is present", selenium, ClassName, MethodName);

			
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
}
}
