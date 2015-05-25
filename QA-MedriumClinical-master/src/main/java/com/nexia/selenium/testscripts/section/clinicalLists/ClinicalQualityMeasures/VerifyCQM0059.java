package com.nexia.selenium.testscripts.section.clinicalLists.ClinicalQualityMeasures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCQM0059 extends AbstractClinicalList{
	
	@Test(groups = {"AdvancedSmokeUS","SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForHbA1cPoorControl(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_004";
		cqmData.fetchClinicalListTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, cqmData);
	}
	
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForHbA1cPoorControlExclusion(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_006";
		cqmData.fetchClinicalListTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, cqmData);
	}
	
	/**
	 * verifyMeasure
	 * Test for Verify result 
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @param cqmData 
	 * @param cqmData
	 * @throws IOException 
	 * @since Jan 08, 2012
	 */
	
	public boolean verifyMeasure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib cqmData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;
		int numerator,denominator;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + cqmData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, cqmData.userName, cqmData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to ClinicalQualityMeasures						  //
			//--------------------------------------------------------------------//
			
			assertTrue(goToClinicalQualityMeasures(selenium), "Could not navigate to Clinical Quality Measures ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Edit CQM Measures							  //
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium, ajxProvider, cqmData.provider);
			assertTrue(enterDate(selenium, txtFromDate, cqmData.fromDate), "Could not enter show result from date", selenium, ClassName, MethodName);
			
			assertTrue(editMeasure(selenium,cqmData), "Could not Edit  measures", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: verify meaningful use measures						      //
			//--------------------------------------------------------------------//
		
			
			assertTrue(verifyMeasure(selenium, cqmData), "Could not enter required values", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Connect with database						              //
			//--------------------------------------------------------------------//
			
			String str1=getText(selenium,lblMetricResultFor0059);
			System.out.println(str1);
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
				numerator=0;
				denominator=0;
			}
			//--------------------------------------------------------------------//
			// step-6: Create a new patient                                       // 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkQuickActions),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkRegNewPatient),"Could not click the link to register a new patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createNewPatientForCqm(selenium,cqmData),"Could not create a new patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String patId = getText(selenium, btnPatientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Encounter //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientOptionsLink),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnPatientChart),"Could not click the link view patient chart", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(goToBeginEncounter(selenium),"Could not Begin encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxProvider1,cqmData.provider);
			assertTrue(enterDate(selenium,txtEncounterDate,cqmData.date),"Could not enter encounter date", selenium, ClassName, MethodName);
			/*assertTrue(click(selenium,lnkMedication),"Could not click the medication link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-8: Add Medication//
			//--------------------------------------------------------------------//
			
			/*ChartPreVisitLib medicationData = new ChartPreVisitLib();
			medicationData.workSheetName = "CreateMedication";
			medicationData.testCaseId = "TC_PSM_013";
			medicationData.fetchChartPreVisitTestData();
			
			assertTrue(createMedicationCqm(selenium,medicationData),"Create Medication failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSign),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			//--------------------------------------------------------------------//
			//  Step-9: Begin another Encounter//
			//--------------------------------------------------------------------//

			/*assertTrue(isElementPresent(selenium,btnBeginEncounter),"Could not fine the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnBeginEncounter),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxProvider1,cqmData.provider);
			assertTrue(enterDate(selenium,txtEncounterDate,cqmData.date),"Could not enter encounter date", selenium, ClassName, MethodName);*/
			
			//--------------------------------------------------------------------//
			//  Step-10: Add Problem List//
			//--------------------------------------------------------------------//
			
			ChartPreVisitLib proData = new ChartPreVisitLib();
			proData.workSheetName = "CreateProblemList";
			proData.testCaseId = "TC_CPL_009";
			proData.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,lnkEncounterProblemList),"Could not click the Problem List link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			assertTrue(createProblemListforCQM(selenium,proData),"Problem List Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSign),"Could not click the Sign button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11: File New Report//
			//--------------------------------------------------------------------//
		
			ChartPreVisitLib labData = new ChartPreVisitLib();
			labData.workSheetName = "FileLabReport";
			labData.testCaseId = "TC_LR_025";
			labData.fetchChartPreVisitTestData();
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientOptionsLink ), "Could not click on patient options link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkLabReportLink ), "Could not click on file new report link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(fileReportCqm0059(selenium,labData),"Could not file a new lab report", selenium, ClassName, MethodName);
			
			assertTrue(goToClinicalQualityMeasures(selenium), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-12: Clinical quality measures for Exclusion				   //
			//--------------------------------------------------------------------//
			
			assertTrue(verifyMeasure(selenium, cqmData), "Could not enter required values", selenium, ClassName, MethodName);			
			String str2=getText(selenium,lblMetricResultFor0059);
			waitForPageLoad(selenium);
			String[] splitStr3 = str2.split("[(^)]");
			waitForPageLoad(selenium);
			String[] SplitStr4 = splitStr3[1].split("\\s",4);
			waitForPageLoad(selenium);
			System.out.println(SplitStr4[0]);
			System.out.println(SplitStr4[3]);
			int updatedNumerator=Integer.parseInt(SplitStr4[0]);
			int updatedDenominator=Integer.parseInt((SplitStr4[3]));
			if(updatedNumerator-numerator==1){
				if(updatedDenominator-denominator==1)
					returnValue=true;
				else
					Assert.fail("Verify CQM Results Failed");
			}	else
			//		Assert.fail("Verify CQM Results Failed");
		
			//--------------------------------------------------------------------//
			//  Step-13: verify clinical quality measures for Exclusion					      //
			//--------------------------------------------------------------------//
		
			if(cqmData.testCaseId.equals("TC_CQM_006"))
			{
				proData.workSheetName = "CreateProblemList";
				proData.testCaseId = "TC_CPL_045";
				proData.fetchChartPreVisitTestData();
				
				searchPatientNexiaForProviderHomePage(selenium,patId);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnBeginEncounter),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,ajxProvider1,cqmData.provider);
				assertTrue(enterDate(selenium,txtEncounterDate,cqmData.date),"Could not enter encounter date", selenium, ClassName, MethodName);
			
				assertTrue(click(selenium,lnkProblemList),"Could not click the Problem  link;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(createProblemListforCQM(selenium,proData),"Creation Problem List failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnSign),"Could not click the Sign button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(goToClinicalQualityMeasures(selenium), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
				
				//--------------------------------------------------------------------//
				//  Step-10: verify meaningful use measures						      //
				//--------------------------------------------------------------------//
				
				assertTrue(verifyMeasure(selenium, cqmData), "Could not enter required values", selenium, ClassName, MethodName);			
				String str3=getText(selenium,lblMetricResultFor0059);
				waitForPageLoad(selenium);
				String[] splitStr5 = str3.split("[(^)]");
				waitForPageLoad(selenium);
				String[] SplitStr6 = splitStr5[1].split("\\s",4);
				waitForPageLoad(selenium);
				System.out.println(SplitStr6[0]);
				System.out.println(SplitStr6[3]);
				int excludeNumerator=Integer.parseInt(SplitStr6[0]);
				int excludeDenominator=Integer.parseInt((SplitStr6[3]));
				if(updatedNumerator-excludeNumerator==1){
					if(updatedDenominator-excludeDenominator==1)
						returnValue=true;
					else
						Assert.fail("Verify CQM Results for Exclusion Failed");
				} 	else{
					Assert.fail("Verify CQM Results for Exclusion Failed");
				}
			}
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
