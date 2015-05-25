package com.nexia.selenium.testscripts.section.clinicalsettings.cdmflowsheets;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractCdmFlowSheets;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.testscripts.section.demographics.patientCheckinInfo.CreateNewPatientCheckinInfo;
import com.thoughtworks.selenium.Selenium;

public class VerifyDisplayOfEditFlowsheetOnMouseOver extends AbstractCdmFlowSheets {

	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Edit Title and Specified details are Displayed in the Template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void careElementValueMouseOver(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_054";
		mcTemplate.fetchClinicalSettingsTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifyCareElementValueMouseOver(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	/*************************************************************************************************** 
	* @purpose        Verify Edit Title Display in Template
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verify Edit Title Display in Template
	* @author         AspireQA
	 * @throws Exception 
	* @state          Developing
	* @useraccount    Both 
	* @since  	      Jun 25, 2014
	***************************************************************************************************/
	
	public boolean VerifyCareElementValueMouseOver(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws Exception{
		Selenium selenium=null;
		boolean returnValue= true;
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
			//  Step-5: Add Managed Care Template with lab test care element      //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
    		String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(enterDetailsForeManagedCareTemplate(selenium,mcTemplate,uniqueName),"Template creation failed", selenium, ClassName, MethodName);
			assertTrue(addLabTestCareElement(selenium,mcTemplate,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveWhole),"could ot click save", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-6: Create Patient with mandatory datum					      //
			//--------------------------------------------------------------------//
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_002";
			patientData.fetchHomeTestData();
			assertTrue(createNewPatientWithMandatoryFields(selenium,patientData),"Mandatory patient cration failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String patId = getText(selenium, "patientID");
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			if(userAccount.equals(CAAccount)){
				searchPatientNexiaForProviderHomePage(selenium,patId);
				waitForPageLoad(selenium);
				}
				else{
					USsearchPatientGotoChart(selenium,patId);
					waitForPageLoad(selenium);
				}
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Managed Care flow sheet in Patient Chart and edit FlowSheet  // 
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareFlowSheetWithUniqueName(selenium,mcTemplate,userAccount,uniqueName),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.mouseOver(careMouseOver);
			System.out.println(mcTemplate.eheightLowerLimit);
			assertTrue(getText(selenium,careTargerValue).contains(mcTemplate.eheightLowerLimit),"Target value is not Visible", selenium, ClassName, MethodName);
			System.out.println(mcTemplate.due+" "+mcTemplate.dueType);
			assertTrue(getText(selenium,careDueValue).contains(mcTemplate.due+" "+mcTemplate.dueType),"Target value is not Visible", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium, overDue),"Overdue red warning", selenium, ClassName, MethodName);
			selenium.mouseOut(careMouseOver);

			ChartPreVisitLib labData = new ChartPreVisitLib();
			labData.workSheetName = "FileLabReport";
			labData.testCaseId = "TC_LR_053";
			labData.fetchChartPreVisitTestData();
			AbstractChartPreVisit lab=new AbstractChartPreVisit();
			assertTrue(lab.CreateFileNewReportForCareElement(selenium,labData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(navigateToManagedCareFlowSheetWithUniqueName(selenium,mcTemplate,userAccount,uniqueName),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isTextPresent(selenium,"Baseline"),"Base line date is not present", selenium, ClassName, MethodName);
			selenium.mouseOver(careMouseOver);
			System.out.println(mcTemplate.eheightLowerLimit);
			assertTrue(getText(selenium,careTargerValue).contains(mcTemplate.eheightLowerLimit),"Target value is not Visible", selenium, ClassName, MethodName);
			System.out.println(mcTemplate.due+" "+mcTemplate.dueType);
			assertTrue(getText(selenium,careDueValue).contains(mcTemplate.due+" "+mcTemplate.dueType),"Target value is not Visible", selenium, ClassName, MethodName);
			assertTrue(!isElementPresent(selenium, overDue),"Overdue red warning", selenium, ClassName, MethodName);

		}catch(RuntimeException e){
		e.printStackTrace();
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}	
	return returnValue;
	}	

	
}