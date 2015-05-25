package com.nexia.selenium.testscripts.section.clinicalLists.ClinicalQualityMeasures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;

import com.thoughtworks.selenium.Selenium;

public class VerifyCQM0043 extends AbstractClinicalList {
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureFor0043(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_015";
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
	 * @throws IOException 
	 * @since Dec 24, 2012
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
			//  Step-5: Note down the the metric results					      //
			//--------------------------------------------------------------------//
			
			String str1 = getText(selenium, lblMetricResultFor0043);
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
			}
			else {
				numerator=0;
				denominator=0;
			}
				
			//--------------------------------------------------------------------//
			//  Step-6: Create first patient
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkQuickActions),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);;

			assertTrue(click(selenium,lnkShowMoreLink),"Could not click show more link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingLink),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 
			// Delete All Mandatory data //
			assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click admin Mandatory", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(deleteAllMandatory(selenium), "Could not delete all mandatory fields", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickActions),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnknewPatientAction),"Could not click the link view patient chart", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createNewPatientForCqm(selenium,cqmData),"Could not create a new patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientOptionsLink ),"Could not click on patient options link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkPatientChartView), "Could not click on patient chart link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Create first encounter
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxProvider1,cqmData.provider);
			waitForPageLoad(selenium);
			assertTrue(enterDate(selenium, txtEncounterDate,"01/06/2013"),"could not enter", selenium, ClassName, MethodName);
			click(selenium,btnSign);		
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Create Second patient
			//--------------------------------------------------------------------//
			
			ClinicalListLib cqmSecPatient = new ClinicalListLib();
			cqmSecPatient.workSheetName = "CQM";
			cqmSecPatient.testCaseId = "TC_CQM_015";
			cqmSecPatient.fetchClinicalListTestData();
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the button;More Details:"+cqmSecPatient.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnknewPatientAction),"Could not click the link view patient chart", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createNewPatientForCqm(selenium,cqmSecPatient),"Could not create a new patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientOptionsLink ),"Could not click on patient options link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkPatientChartView), "Could not click on patient chart link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Create Second encounter
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxProvider1, cqmData.provider);
			assertTrue(enterDate(selenium, txtEncounterDate, "01/06/2013"),"could not enter", selenium, ClassName, MethodName);
			click(selenium,btnSign);		
			waitForPageLoad(selenium);
				
		/*	//--------------------------------------------------------------------//
			//  Step-10: Create encounter with Medication
			//--------------------------------------------------------------------//
		
			assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxProvider1, cqmData.provider);
			assertTrue(enterDate(selenium, txtEncounterDate, "01/06/2013"),"could not enter", selenium, ClassName, MethodName);
			ChartPreVisitLib medicationData = new ChartPreVisitLib();
			medicationData.workSheetName = "CreateMedication";
			medicationData.testCaseId = "TC_PSM_015";
			medicationData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,btnCancel),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createMedicationCqm(selenium,medicationData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,"sign");		
			waitForPageLoad(selenium);
			click(selenium,btnBack);	
			waitForPageLoad(selenium);*/
				
			assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxProvider1, cqmData.provider);
			assertTrue(enterDate(selenium, txtEncounterDate, "01/07/2013"),"could not enter", selenium, ClassName, MethodName);

			ChartPreVisitLib injectionData = new ChartPreVisitLib();
			injectionData.workSheetName = "CreateInjection";
			injectionData.testCaseId = "TC_CI_057";
			injectionData.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,"link=Injections"),"Could not find the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createInjection(selenium,injectionData),"Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Create encounter with  Immunizations
			//--------------------------------------------------------------------//
			/*assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxProvider1, cqmData.provider);
			assertTrue(enterDate(selenium, txtEncounterDate, "01/06/2013"),"Could not enter", selenium, ClassName, MethodName);
			ChartPreVisitLib immunizationData = new ChartPreVisitLib();
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_010";
			immunizationData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkImmunizations),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(createImmunization(selenium,immunizationData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			click(selenium,btnSign);		
			waitForPageLoad(selenium);
			click(selenium,btnBack);	
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-11: Verify CQM results
			//--------------------------------------------------------------------//
		
			assertTrue(goToClinicalQualityMeasures(selenium), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(editMeasure(selenium,cqmData), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(verifyMeasure(selenium, cqmData), "Could not enter required values", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String str2=getText(selenium,lblMetricResultFor0043);
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
				if(updatedDenominator-denominator==2)
					returnValue=true;
				else
					Assert.fail("Verify CQM Results Failed");
			}	else
					Assert.fail("Verify CQM Results Failed");
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}


}