package com.nexia.selenium.testscripts.section.clinicalLists.ClinicalQualityMeasures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCQM0038f extends AbstractClinicalList {
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureFor0038(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_016";
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
		int numerator1=0,denominator1=0;
		int updatedNumerator1=0,updatedDenominator1=0;
		String str1=null;
		
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
			assertTrue(editMeasure(selenium,cqmData), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: verify meaningful use measures						      //
			//--------------------------------------------------------------------//
			assertTrue(verifyMeasure(selenium, cqmData), "Could not enter required values", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Note down the the metric results					              //
			//--------------------------------------------------------------------//
			
			str1 = getText(selenium, lblMetricResult6For0038);
			if(!str1.equals("(No Results Found)")){
			waitForPageLoad(selenium);
			String[] splitStr1 = str1.split("[(^)]");
			waitForPageLoad(selenium);
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			waitForPageLoad(selenium);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			numerator1=Integer.parseInt(SplitStr2[0]);
			denominator1=Integer.parseInt((SplitStr2[3]));
			}
			else {
				numerator1=0;
				denominator1=0;
			}
			
			//--------------------------------------------------------------------//
			//  Step-6: Perform actions for calculating the metric
			//--------------------------------------------------------------------//
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "NewPatientCheckIn";
			PatientData.testCaseId = "TC_NPC_013";
			PatientData.fetchHomeTestData();
			
			assertTrue(click(selenium,lnkQuickActions),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnknewPatientAction),"Could not click the link view patient chart", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createNewPatientForBPM(selenium,PatientData,cqmData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPatientOptionsLink ), "Could not click on patient options link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkPatientChartView), "Could not click on patient chart link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Create first encounter
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxProvider1, cqmData.provider);
			assertTrue(enterDate(selenium, txtEncounterDate, "08/08/2011"),"could not enter", selenium, ClassName, MethodName);
			click(selenium,btnSign);		
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-8: Create encounter with procedure
			//--------------------------------------------------------------------//
		
			assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxProvider1, cqmData.provider);
			assertTrue(enterDate(selenium, txtEncounterDate, "08/08/2011"),"could not enter", selenium, ClassName, MethodName);
			
			ChartPreVisitLib clinicalProblemListData = new ChartPreVisitLib();
			clinicalProblemListData.workSheetName = "CreateProblemList";
			clinicalProblemListData.testCaseId = "TC_CPL_042";
			clinicalProblemListData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkProblemList),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProblemListforCQM(selenium,clinicalProblemListData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			clinicalProblemListData.workSheetName = "CreateProblemList";
			clinicalProblemListData.testCaseId = "TC_CPL_043";
			clinicalProblemListData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkProblemList),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProblemListforCQM(selenium,clinicalProblemListData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			click(selenium,btnSign);		
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-10: Verify CQM results
			//--------------------------------------------------------------------//
			assertTrue(goToClinicalQualityMeasures(selenium), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			assertTrue(editMeasure(selenium,cqmData), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			assertTrue(verifyMeasure(selenium, cqmData), "Could not enter required values", selenium, ClassName, MethodName);
			
			str1 = getText(selenium, lblMetricResult6For0038);
			if(!str1.equals("(No Results Found)")){
			waitForPageLoad(selenium);
			String[] splitStr1 = str1.split("[(^)]");
			waitForPageLoad(selenium);
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			waitForPageLoad(selenium);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			updatedNumerator1=Integer.parseInt(SplitStr2[0]);
			updatedDenominator1=Integer.parseInt((SplitStr2[3]));
			}
			
			if(updatedNumerator1-numerator1==1)
				if(updatedDenominator1-denominator1==1)
					returnValue=true;
				else
					returnValue=false;
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
