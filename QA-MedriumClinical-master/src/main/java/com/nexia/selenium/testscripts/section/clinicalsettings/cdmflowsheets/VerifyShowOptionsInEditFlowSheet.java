package com.nexia.selenium.testscripts.section.clinicalsettings.cdmflowsheets;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
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

public class VerifyShowOptionsInEditFlowSheet extends AbstractCdmFlowSheets{
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify the various filter options for care elements in patient chart.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyShowOptionsInEditFlowSheet(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_033";
		mcTemplate.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
		verifyShowOptions(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify the various filter options for care elements in patient chart.")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDisplayOfCareElementsOnMouseOver(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib mcTemplate = new ClinicalSettingLib();
		mcTemplate.workSheetName = "ManagedCaredTemplate";
		mcTemplate.testCaseId = "TC_MCT_054";
		mcTemplate.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
		verifyShowOptions(seleniumHost, seleniumPort, browser, webSite, userAccount, mcTemplate);
	}

	/*************************************************************************************************** 
	* @purpose        To verify the various filter options in patient chart.
	* @Specification  SRS_EMR_CDM_Flowsheets Rev0.0
	* @action 		  Verifying filter options in patient chart for care elements
	* @author         AspireQA
	* @throws 		  IOException 
	 * @throws ParseException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 30, 2014
	***************************************************************************************************/
	
	public boolean verifyShowOptions(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib mcTemplate) throws Exception{
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
			assertTrue(navigateToVisitSection(selenium),"Unable to navigate to visit section",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			ClinicalSettingLib vsTemplate = new ClinicalSettingLib();
			vsTemplate.workSheetName = "CreateVisitSection";
			vsTemplate.testCaseId = "TC_VS_001";
			vsTemplate.fetchClinicalSettingsTestData();
			assertTrue(deleteAllCustomSection(selenium),"unable to delete widget",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(createVisitSectionWithSingleTextWidget(selenium,vsTemplate),"unable to create a single visit section",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
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
			cal=Calendar.getInstance();
			dateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			uniqueName=dateFormat.format(cal.getTime());
			assertTrue(enterDetailsForeManagedCareTemplate(selenium,mcTemplate,uniqueName),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//assertTrue(click(selenium,btnEdit),"Could not click Edit button", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-6: Add Template with all details			                  //
			//--------------------------------------------------------------------//
			assertTrue(addCustomWidgetCareElement(selenium,mcTemplate,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(addLabTestCareElement(selenium,mcTemplate,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			ClinicalSettingLib mcTemplate1 = new ClinicalSettingLib();
			mcTemplate1.workSheetName = "ManagedCaredTemplate";
			mcTemplate1.testCaseId = "TC_MCT_034";
			mcTemplate1.fetchClinicalSettingsTestData();						
			assertTrue(addImmunizationCareElement(selenium,mcTemplate1,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
						
			ClinicalSettingLib mcTemplate2 = new ClinicalSettingLib();
			mcTemplate2.workSheetName = "ManagedCaredTemplate";
			mcTemplate2.testCaseId = "TC_MCT_035";
			mcTemplate2.fetchClinicalSettingsTestData();
			assertTrue(addVitalsCareElement(selenium,mcTemplate2,uniqueName,userAccount),"Creation Failed"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-7: Advanced search with Patient ID                           //
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,mcTemplate.patientId);
			waitForPageLoad(selenium);
			AbstractChartPreVisit obj=new AbstractChartPreVisit();
			assertTrue(obj.goToBeginEncounter(selenium),"Could not navigate to encounter", selenium, ClassName, MethodName);  
			assertTrue(click(selenium,lnkSummary),"Could not click the Summary tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-8: Add Immunization                                          //
			//--------------------------------------------------------------------//
			assertTrue(selenium.isVisible(lnkImmunization),"Immunization Link Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(obj.deleteImmunization(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-9: Create Immunization                                       //
			//--------------------------------------------------------------------//
			ChartPreVisitLib immunizationData = new ChartPreVisitLib();
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_070";
			immunizationData.fetchChartPreVisitTestData();
			
			assertTrue(obj.createImmunization(selenium,immunizationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-10: Delete Existing Lab Orders                                //
			//--------------------------------------------------------------------//
			ChartPreVisitLib labData = new ChartPreVisitLib();
			labData.workSheetName = "FileLabReport";
			labData.testCaseId = "TC_LR_048";
			labData.fetchChartPreVisitTestData();
			assertTrue(obj.deleteOrders(selenium,labData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11: Navigate to Lab Order Page                                //
			//--------------------------------------------------------------------//
			assertTrue(obj.navigateTofileReport(selenium,labData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-12: File new lab report                                       //
			//--------------------------------------------------------------------//
			
			assertTrue(obj.fileReport(selenium,labData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-13: Navigate to Managed Care                                  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToManagedCareFlowSheet(selenium,mcTemplate,userAccount ),"Could not navigate to managed care teamplates;More Details:"+mcTemplate.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-14: Verify 'All' Filter Search Result                         //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,ajxTemplateName,"All"),"Could not select All", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isTextPresent(selenium,mcTemplate.display),"could ot click cancel", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,mcTemplate.display),"could ot click cancel", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,mcTemplate1.display),"could ot click cancel", selenium, ClassName, MethodName);
			assertTrue(isTextPresent(selenium,mcTemplate2.display),"could ot click cancel", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-15: Verify 'Upcoming' Filter Search Result                         //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,ajxTemplateName,"Upcoming"),"Could not select All", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isTextPresent(selenium,mcTemplate.display),"could ot click cancel", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-16: Verify 'Overdue' Filter Search Result                         //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,ajxTemplateName,"Overdue"),"Could not select All", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isTextPresent(selenium,mcTemplate.display),"could ot click cancel", selenium, ClassName, MethodName);
			
			if(mcTemplate.testCaseId.equals("TC_MCT_054")){
			selenium.mouseOver(careMouseOver);
			System.out.println("target:"+mcTemplate.eheightLowerLimit+"-"+mcTemplate.eheightUpperLimit);
			if(isElementPresent(selenium, careTargerValue)){
			assertTrue(careTargerValue.contains(mcTemplate.eheightLowerLimit),"Target value is not Visible", selenium, ClassName, MethodName);
			}
			else{
			assertTrue(isTextPresent(selenium,"target:"+mcTemplate.eheightLowerLimit+"-"+mcTemplate.eheightUpperLimit),"Target is not present", selenium, ClassName, MethodName);
			}
			System.out.println(mcTemplate.due+" "+mcTemplate.dueType);
			if(isElementPresent(selenium, careDueValue)){
			assertTrue(careDueValue.contains(mcTemplate.eheightLowerLimit),"Target value is not Visible", selenium, ClassName, MethodName);
			}
			else{
			assertTrue(isTextPresent(selenium,mcTemplate.due+" "+mcTemplate.dueType),"Due is not present", selenium, ClassName, MethodName);
			}
			//date validation for color 
			if (userAccount.equals(CAAccount)) {
				dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				date = dateFormat.format(cal.getTime());
			}
			else if(userAccount.equals(USAccount)) {
				dateFormat= new SimpleDateFormat("MMM dd, yyyy");
				String currentDateStr = dateFormat.format(cal.getTime());
				Date currenDate=(Date) dateFormat.parse(currentDateStr);
				System.out.println(date);
				
				String CreatedDateStr=getText(selenium,dateAddNewManagedCare);
				Date CreatedDate=(Date) dateFormat.parse(CreatedDateStr);
				
				if(currenDate.after(CreatedDate) || currenDate.equals(CreatedDate)){
					assertTrue(careEleAttribute.contains("red"),"Not in red color", selenium, ClassName, MethodName);
				}
				else{
					assertTrue(careEleAttribute.contains("orange"),"Not in red color", selenium, ClassName, MethodName);
				}
			}
			}
			
			//--------------------------------------------------------------------//
			//  Step-17: Verify 'Out-of-target' Filter Search Result              //
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,ajxTemplateName,"Out-of-target"),"Could not select All", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isTextPresent(selenium,mcTemplate2.display),"could ot click cancel", selenium, ClassName, MethodName);
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
}
	

}
