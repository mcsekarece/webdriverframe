package com.nexia.selenium.testscripts.section.clinicalLists.ClinicalQualityMeasures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;

import com.thoughtworks.selenium.Selenium;

public class VerifyCQM0421 extends AbstractClinicalList {
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureFor0421a(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_008";
		cqmData.fetchClinicalListTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, cqmData);
	}
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureFor0421b(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_009";
		cqmData.fetchClinicalListTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, cqmData);
	}
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureFor0421AWithPregnancyExclusion(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_011";
		cqmData.fetchClinicalListTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, cqmData);
	}
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureFor0421AWithIllnessExclusion(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_012";
		cqmData.fetchClinicalListTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, cqmData);
	}
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureFor0421BWithPregnancyExclusion(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_013";
		cqmData.fetchClinicalListTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, cqmData);
	}
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureFor0421BWithIllnessExclusion(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_014";
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
		int numerator=0,denominator=0,updatedNumerator=0, updatedDenominator=0,excludeNumerator=0,excludeDenominator=0;
		String[] splitStr1,SplitStr2,splitStr3,SplitStr4;
		String str1,str2,str3;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + cqmData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, cqmData.userName, cqmData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			switchRole(selenium,cqmData.role);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to Meaningful measures								  //
			//--------------------------------------------------------------------//
			
			assertTrue(goToClinicalQualityMeasures(selenium), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxProvider, cqmData.provider);
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
			if(cqmData.testCaseId.equals("TC_CQM_008")||cqmData.testCaseId.equals("TC_CQM_011")||cqmData.testCaseId.equals("TC_CQM_012")){
				str1 = getText(selenium, lblMetricResult1For0038);
			}
			else str1 = getText(selenium, lblMetricResult2For0038);
			
			if(!str1.equals("(No Results Found)")){
				waitForPageLoad(selenium);
				splitStr1 = str1.split("[(^)]");
				waitForPageLoad(selenium);
				System.out.println(splitStr1[1]);
				waitForPageLoad(selenium);
				SplitStr2 = splitStr1[1].split(" ");
				System.out.println(SplitStr2[0]);
				System.out.println(SplitStr2[3]);
				numerator=Integer.parseInt(SplitStr2[0]);
				denominator=Integer.parseInt((SplitStr2[3]));
			}else {
				numerator=0;
				denominator=0;
			}
				
			//--------------------------------------------------------------------//
			//  Step-6: Perform actions for calculating the metric
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
			
			assertTrue(createNewPatientForCqm(selenium,cqmData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String patId = getText(selenium, btnPatientId);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPatientOptionsLink ), "Could not click on z link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientChartView), "Could not click on patient chart link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Create first encounter
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(goToBeginEncounter(selenium),"Could not Begin encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			selectValueFromAjaxList(selenium, ajxProvider1, cqmData.provider);
			waitForPageLoad(selenium);
			assertTrue(enterDate(selenium, txtEncounterDate, "01/06/2013"),"could not enter", selenium, ClassName, MethodName);
			click(selenium,btnSign);		
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-8: Create encounter with Vitals
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not Begin encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium, ajxProvider1, cqmData.provider);
			waitForPageLoad(selenium);
			assertTrue(enterDate(selenium, txtEncounterDate, "01/06/2013"),"could not enter", selenium, ClassName, MethodName);
			ChartPreVisitLib vitalsData = new ChartPreVisitLib();
			vitalsData.workSheetName = "CreateVitals";
			vitalsData.testCaseId = "TC_CV_023";
			vitalsData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkVitals),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(addEncounterVitals(selenium,vitalsData),"Encounter Vitals Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnDoneButton),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,btnSign);		
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-10: Verify CQM results
			//--------------------------------------------------------------------//
			assertTrue(goToClinicalQualityMeasures(selenium), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium, ajxProvider, cqmData.provider);
			assertTrue(editMeasure(selenium,cqmData), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			assertTrue(verifyMeasure(selenium, cqmData), "Could not enter required values", selenium, ClassName, MethodName);
			
			if(cqmData.testCaseId.equals("TC_CQM_008")||cqmData.testCaseId.equals("TC_CQM_011")||cqmData.testCaseId.equals("TC_CQM_012")){
				str2 = getText(selenium, lblMetricResult1For0038);
			}
			else  str2 = getText(selenium, lblMetricResult2For0038);
			if(!str1.equals("(No Results Found)")){
				waitForPageLoad(selenium);
				splitStr3 = str2.split("[(^)]");
				waitForPageLoad(selenium);
				SplitStr4 = splitStr3[1].split("\\s",4);
				waitForPageLoad(selenium);
				System.out.println(SplitStr4[0]);
				System.out.println(SplitStr4[3]);
				 updatedNumerator=Integer.parseInt(SplitStr4[0]);
				 updatedDenominator=Integer.parseInt((SplitStr4[3]));
			}
			if(updatedNumerator-numerator>=1){
				if(updatedDenominator-denominator>=1){
					returnValue=true;
				}else
					Assert.fail("Denominator not updated properly");
			}
			else{
				Assert.fail("Numerator not updated properly");
			}
			
			/*if(!str2.equals("(No Results Found)")){
				splitStr3 = str2.split("[(^)]");
				SplitStr4 = splitStr3[1].split(" ");
				System.out.println(SplitStr4[3]);
				System.out.println(SplitStr4[3]);
				numerator=Integer.parseInt(SplitStr4[0]);
				denominator=Integer.parseInt((SplitStr4[3]));
				}
				else {
					numerator=0;
					denominator=0;
				}
			
			
			
			
			splitStr3 = str2.split("[(^)]");
			SplitStr4 = splitStr3[1].split(" ",4);
			System.out.println(SplitStr4[0]);
			System.out.println(SplitStr4[3]);
			int updatedNumerator=Integer.parseInt(SplitStr4[0]);
			int updatedDenominator=Integer.parseInt((SplitStr4[3]));*/
			
			/*if(updatedNumerator-numerator==1)
				if(updatedDenominator-denominator==1)
					returnValue=true;
				else
					returnValue=false;*/
			
			if(cqmData.testCaseId.equals("TC_CQM_011")||cqmData.testCaseId.equals("TC_CQM_012")||cqmData.testCaseId.equals("TC_CQM_013")||cqmData.testCaseId.equals("TC_CQM_014")){
				if(cqmData.testCaseId.equals("TC_CQM_011")||cqmData.testCaseId.equals("TC_CQM_013")){
				ChartPreVisitLib proData = new ChartPreVisitLib();
				proData.workSheetName = "CreateProblemList";
				proData.testCaseId = "TC_CPL_010";
				proData.fetchChartPreVisitTestData();
				
				
				searchPatientNexiaForProviderHomePage(selenium,patId);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkProblemList),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(createProblemListforCQM(selenium,proData),"Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
				if(cqmData.testCaseId.equals("TC_CQM_012")||cqmData.testCaseId.equals("TC_CQM_014")){
					ChartPreVisitLib proData = new ChartPreVisitLib();
					proData.workSheetName = "CreateProblemList";
					proData.testCaseId = "TC_CPL_011";
					proData.fetchChartPreVisitTestData();
					
					
					searchPatientNexiaForProviderHomePage(selenium,patId);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,lnkProblemList),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					
					assertTrue(createProblemListforCQM(selenium,proData),"Creation failed", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
			
				
				assertTrue(goToClinicalQualityMeasures(selenium), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-10: verify meaningful use measures						      //
				//--------------------------------------------------------------------//
				assertTrue(verifyMeasure(selenium, cqmData), "Could not enter required values", selenium, ClassName, MethodName);			
				if(cqmData.testCaseId.equals("TC_CQM_008")||cqmData.testCaseId.equals("TC_CQM_011")||cqmData.testCaseId.equals("TC_CQM_012")){
					str3 = getText(selenium, lblMetricResult1For0038);
				}
				else  str3 = getText(selenium, lblMetricResult2For0038);
				if(!str1.equals("(No Results Found)")){
					waitForPageLoad(selenium);
					String[] splitStr5 = str3.split("[(^)]");
					waitForPageLoad(selenium);
					String[] SplitStr6 = splitStr5[1].split("\\s",4);
					waitForPageLoad(selenium);
					System.out.println(SplitStr6[0]);
					System.out.println(SplitStr6[3]);
					excludeNumerator=Integer.parseInt(SplitStr6[0]);
					excludeDenominator=Integer.parseInt((SplitStr6[3]));
				}
				if(updatedNumerator-excludeNumerator==1){
					if(updatedDenominator-excludeDenominator==1)
						returnValue=true;
					else
						Assert.fail("Denominator not updated properly");
				}
				else{
					Assert.fail("Numerator not updated properly");
				}
			
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}


}
