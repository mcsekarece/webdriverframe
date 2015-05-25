package com.nexia.selenium.testscripts.section.clinicalLists.ClinicalQualityMeasures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCQM0064 extends AbstractClinicalList{
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForLDL(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_010";
		cqmData.fetchClinicalListTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, cqmData);
	}
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForLDLLessThan100(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_019";
		cqmData.fetchClinicalListTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, cqmData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Measure
	* @action 		  verifying Measure
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    SingleThreadUS
	* @since  	      Jan 08, 2012
	***************************************************************************************************/
	public boolean verifyMeasure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib cqmData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;
		int numerator =0, denominator= 0, updatedNumerator = 0, updatedDenominator = 0; 
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + cqmData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, cqmData.userName, cqmData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to Meaningful measures								  //
			//--------------------------------------------------------------------//
			assertTrue(goToClinicalQualityMeasures(selenium), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Edit CQM Measures							  //
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium, ajxProvider, cqmData.provider);
			assertTrue(editMeasure(selenium,cqmData), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: verify meaningful use measures						      //
			//--------------------------------------------------------------------//
			assertTrue(verifyMeasure(selenium, cqmData), "Could not enter required values", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Connect with database						              //
			//--------------------------------------------------------------------//
			
			String str1;
			
			
			if(cqmData.testCaseId.equalsIgnoreCase("TC_CQM_010")){
				str1=getText(selenium,lblMetricResultFor0064);
			}
			else{
				str1=getText(selenium,lblMetricResult1For0064);
			}
			if(!str1.equals("(No Results Found)")){
				waitForPageLoad(selenium);
				String[] splitStr1 = str1.split("[(^)]");
				waitForPageLoad(selenium);
				String[] SplitStr2 = splitStr1[1].split("\\s",4);
				waitForPageLoad(selenium);
				System.out.println(SplitStr2[0]);
				System.out.println(SplitStr2[3]);
				numerator=Integer.parseInt(SplitStr2[0]);
				denominator=Integer.parseInt((SplitStr2[3]));
			}else{
				numerator = 0;
				denominator = 0;
			}
			//--------------------------------------------------------------------//
			// step-6: Create a new patient                                       // 
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickActions),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkRegNewPatient),"Could not click the link to register a new patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createNewPatientForCqm(selenium,cqmData),"Could not create a new patient", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkPatientOptionsLink),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnPatientChart),"Could not click the link view patient chart", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnBeginEncounter),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxProvider1,cqmData.provider);
			assertTrue(enterDate(selenium,txtEncounterDate,cqmData.date),"Could not enter encounter date", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkSurgicalHistory),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Add Procedure//
			//--------------------------------------------------------------------//
			ChartPreVisitLib proData = new ChartPreVisitLib();
			proData.workSheetName = "CreateProcedure";
			proData.testCaseId = "TC_CP_008";
			proData.fetchChartPreVisitTestData();
			
			assertTrue(createProcedure(selenium,proData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Add Problem List//
			//--------------------------------------------------------------------//
			ChartPreVisitLib problemData = new ChartPreVisitLib();
			problemData.workSheetName = "CreateProblemList";
			problemData.testCaseId = "TC_CPL_046";
			problemData.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,lnkProblemList),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createProblemListforCQM(selenium,problemData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Add Medication//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,"xpath=(//a[contains(text(),'Medications')])[2]"),"Could not click the medication link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			ChartPreVisitLib medicationData = new ChartPreVisitLib();
			medicationData.workSheetName = "CreateMedication";
			medicationData.testCaseId = "TC_PSM_041";
			medicationData.fetchChartPreVisitTestData();
			
			assertTrue(createMedicationCqm(selenium,medicationData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			ChartPreVisitLib orderData = new ChartPreVisitLib();
			orderData.workSheetName = "CreateLabOrder";
			orderData.testCaseId = "TC_OL_007";
			orderData.fetchChartPreVisitTestData();
			
			//--------------------------------------------------------------------//
			//  Step-11: Navigate to Lab Order Page//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkLabOrderLink),"Could not click on lab order link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(orderNewLabs(selenium,orderData),"Order Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-12: Verify Created Lab Order on File Lab Report Page//
			//--------------------------------------------------------------------//
			assertTrue(navigateTofileReport(selenium,orderData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(cqmData.testCaseId.contains("TC_CQM_019")){
				ChartPreVisitLib labData = new ChartPreVisitLib();
				labData.workSheetName = "FileLabReport";
				labData.testCaseId = "TC_LR_026";
				labData.fetchChartPreVisitTestData();
				assertTrue(fileReportCqm(selenium,labData),"Could not file a new lab report", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}else{
				ChartPreVisitLib labData = new ChartPreVisitLib();
				labData.workSheetName = "FileLabReport";
				labData.testCaseId = "TC_LR_027";
				labData.fetchChartPreVisitTestData();
				assertTrue(fileReportCqm(selenium,labData),"Could not file a new lab report", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,btnSign),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(goToClinicalQualityMeasures(selenium), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-13: verify meaningful use measures						      //
			//--------------------------------------------------------------------//
			assertTrue(verifyMeasure(selenium, cqmData), "Could not enter required values", selenium, ClassName, MethodName);			
			String str2;
			
			if(cqmData.testCaseId.equalsIgnoreCase("TC_CQM_010")){
				str2=getText(selenium,lblMetricResultFor0064);
			}
			else{
				str2=getText(selenium,lblMetricResult1For0064);
			}
			if(!str1.equals("(No Results Found)")){
			waitForPageLoad(selenium);
			String[] splitStr3 = str2.split("[(^)]");
			waitForPageLoad(selenium);
			String[] SplitStr4 = splitStr3[1].split("\\s",4);
			waitForPageLoad(selenium);
			System.out.println(SplitStr4[0]);
			System.out.println(SplitStr4[3]);
			 updatedNumerator=Integer.parseInt(splitStr3[0]);
			 updatedDenominator=Integer.parseInt((splitStr3[3]));
			}
			if(updatedNumerator-numerator==1){
				if(updatedDenominator>denominator)
					returnValue=true;
				else
					Assert.fail("Numerator not updated properly");
			}
			else{
				Assert.fail("Numerator not updated properly");
			}
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
