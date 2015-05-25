package com.nexia.selenium.testscripts.section.clinicalLists.ClinicalQualityMeasures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCQM0024 extends AbstractClinicalList{
	@Test(groups = {"AdvancedSmokeUS","SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForWeightAssessmentCriteria1Age2to10(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_020";
		cqmData.fetchClinicalListTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, cqmData);
	}
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForWeightAssessmentCriteria1Age11to16(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_021";
		cqmData.fetchClinicalListTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, cqmData);
	}
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForWeightAssessmentCriteria2Age2to10(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_022";
		cqmData.fetchClinicalListTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, cqmData);
	}
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForWeightAssessmentCriteria2Age11to16(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	 
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_023";
		cqmData.fetchClinicalListTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, cqmData);
	}
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForWeightAssessmentCriteria3Age2to10(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_024";
		cqmData.fetchClinicalListTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, cqmData);
	}
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForWeightAssessmentCriteria3Age11to16(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_025";
		cqmData.fetchClinicalListTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, cqmData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Measure
	* @action 		  verifying Measure
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    SingleThreadUS
	* @since  	      Jan 15, 2012
	***************************************************************************************************/
	public boolean verifyMeasure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib cqmData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;
		String str1;
		int numerator;
		int denominator;
		String str3;
		int commonNumerator;
		int commonDenominator;
		
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
			if(cqmData.testCaseId.equals("TC_CQM_020")||cqmData.testCaseId.equals("TC_CQM_021"))
			{
				if(cqmData.testCaseId.equals("TC_CQM_020"))
					str1=getText(selenium,"//div[@id='collapsableTitle0024']/div[5]/div[2]");
				else
					str1=getText(selenium,"//div[@id='collapsableTitle0024']/div[6]/div[2]");
				if(!str1.equals("(No Results Found)")){
					waitForPageLoad(selenium);
					String[] splitStr1 = str1.split("[(^)]");
					waitForPageLoad(selenium);
					System.out.println(splitStr1);
					waitForPageLoad(selenium);
					String[] SplitStr2 = splitStr1[1].split("\\s",4);
					waitForPageLoad(selenium);
					System.out.println(splitStr1[1]);
					System.out.println(SplitStr2[0]);
					System.out.println(SplitStr2[3]);
					waitForPageLoad(selenium);
					numerator=Integer.parseInt(SplitStr2[0]);
					denominator=Integer.parseInt((SplitStr2[3]));
					}
					else {
						numerator=0;
						denominator=0;
					}
				
				str3=getText(selenium,"//div[@id='collapsableTitle0024']/div[4]/div[2]");
				if(!str3.equals("(No Results Found)"))
				{
				waitForPageLoad(selenium);
				String[] splitStr5 = str3.split("[(^)]");
				waitForPageLoad(selenium);
				String[] SplitStr6 = splitStr5[1].split("\\s",4);
				System.out.println(SplitStr6[0]);
				System.out.println(SplitStr6[3]);
				commonNumerator=Integer.parseInt(SplitStr6[0]);
				commonDenominator=Integer.parseInt((SplitStr6[3]));
				}else {
					commonNumerator=0;
					commonDenominator=0;
				}
			}else if(cqmData.testCaseId.equals("TC_CQM_022")||cqmData.testCaseId.equals("TC_CQM_023")){
				if(cqmData.testCaseId.equals("TC_CQM_022"))
					str1=getText(selenium,"//div[@id='collapsableTitle0024']/div[8]/div[2]");
				else
					str1=getText(selenium,"//div[@id='collapsableTitle0024']/div[9]/div[2]");
				if(!str1.equals("(No Results Found)")){
					waitForPageLoad(selenium);
				String[] splitStr1 = str1.split("[(^)]");
				waitForPageLoad(selenium);
				String[] SplitStr2 = splitStr1[1].split("\\s",4);
				System.out.println(SplitStr2[0]);
				System.out.println(SplitStr2[3]);
				numerator=Integer.parseInt(SplitStr2[0]);
				denominator=Integer.parseInt((SplitStr2[3]));
				}else {
					numerator=0;
					denominator=0;
				}
				str3=getText(selenium,"//div[@id='collapsableTitle0024']/div[7]/div[2]");
				if(!str3.equals("(No Results Found)"))
				{
					waitForPageLoad(selenium);
				String[] splitStr5 = str3.split("[(^)]");
				String[] SplitStr6 = splitStr5[1].split("\\s",4);
				waitForPageLoad(selenium);
				System.out.println(SplitStr6[0]);
				System.out.println(SplitStr6[3]);
				commonNumerator=Integer.parseInt(SplitStr6[0]);
				commonDenominator=Integer.parseInt((SplitStr6[3]));
				}else {
					commonNumerator=0;
					commonDenominator=0;
				}
			}else{
				if(cqmData.testCaseId.equals("TC_CQM_024"))
					
					str1=getText(selenium,lblMetricResult2For0024);
				
				else
					str1=getText(selenium,lblMetricResult3For0024);
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
				}else {
					numerator=0;
					denominator=0;
				}
				str3=getText(selenium,lblMetricResult1For0024);
				if(!str3.equals("(No Results Found)"))
				{
				waitForPageLoad(selenium);
				String[] splitStr5 = str3.split("[(^)]");
				String[] SplitStr6 = splitStr5[1].split("\\s",4);
				waitForPageLoad(selenium);
				System.out.println(SplitStr6[0]);
				System.out.println(SplitStr6[3]);
				commonNumerator=Integer.parseInt(SplitStr6[0]);
				commonDenominator=Integer.parseInt((SplitStr6[3]));
				}else {
					commonNumerator=0;
					commonDenominator=0;
				}
			}
			
			//--------------------------------------------------------------------//
			// step-6: Create a new patient                                       // 
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
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickActions),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			assertTrue(click(selenium,lnkRegNewPatient),"Could not click the link to register a new patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createNewPatientForCqm(selenium,cqmData),"Could not create a new patient", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Encounter //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkPatientOptionsLink),"Could not click the patient options;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnPatientChart),"Could not click the link view patient chart", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxProvider1,cqmData.provider);
			assertTrue(enterDate(selenium,txtEncounterDate,cqmData.date),"Could not enter encounter date", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//  Step-8: Add Problem List//
			//--------------------------------------------------------------------//
			ChartPreVisitLib problemData = new ChartPreVisitLib();
			problemData.workSheetName = "CreateProblemList";
			problemData.testCaseId = "TC_CPL_009";
			problemData.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,lnkProblemList),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createProblemListforCQM(selenium,problemData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSurgicalHistory),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Add Procedure//
			//--------------------------------------------------------------------//
			ChartPreVisitLib proData = new ChartPreVisitLib();
			proData.workSheetName = "CreateProcedure";
			proData.testCaseId = "TC_CP_012";
			proData.fetchChartPreVisitTestData();
			
			assertTrue(createProcedure(selenium,proData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Add vitals//
			//--------------------------------------------------------------------//
			ChartPreVisitLib vitalsData = new ChartPreVisitLib();
			vitalsData.workSheetName = "CreateVitals";
			vitalsData.testCaseId = "TC_CV_023";
			vitalsData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkVitals),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(addEncounterVitals(selenium,vitalsData),"Encounter Vitals Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnDoneButton),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//Add Notes
			assertTrue(type(selenium,txtComments,cqmData.note),"Could not type the encounter note", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			assertTrue(click(selenium,btnSign),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(goToClinicalQualityMeasures(selenium), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-11: verify meaningful use measures						      //
			//--------------------------------------------------------------------//
			assertTrue(verifyMeasure(selenium, cqmData), "Could not enter required values", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			int updatedNumerator;
			int updatedDenominator;
			String str2;
			int updatedCommonNumerator = 0;
			int updatedCommonDenominator=0;
			String str4;
			if(cqmData.testCaseId.equals("TC_CQM_020")||cqmData.testCaseId.equals("TC_CQM_021"))
			{
			    	waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				if(cqmData.testCaseId.equals("TC_CQM_020"))
					str2=getText(selenium,lblMetricResult5For0024);
				else
					str2=getText(selenium,lblMetricResult6For0024);
				waitForPageLoad(selenium);
				if(!str2.equals("(No Results Found)")){
				waitForPageLoad(selenium);
				String[] splitStr3 = str2.split("[(^)]");
				waitForPageLoad(selenium);
				String[] SplitStr4 = splitStr3[1].split("\\s",4);
				System.out.println(SplitStr4[0]);
				System.out.println(SplitStr4[3]);
				updatedNumerator=Integer.parseInt(SplitStr4[0]);
				updatedDenominator=Integer.parseInt((SplitStr4[3]));
				}else{
					updatedNumerator=0;
					updatedDenominator=0;
				}
				str4=getText(selenium,lblMetricResult4For0024);
				if(!str4.equals("(No Results Found)")){
				waitForPageLoad(selenium);
				String[] splitStr7 = str4.split("[(^)]");
				waitForPageLoad(selenium);
				String[] SplitStr8 = splitStr7[1].split("\\s",4);
				System.out.println(SplitStr8[0]);
				System.out.println(SplitStr8[3]);
				updatedCommonNumerator=Integer.parseInt(SplitStr8[0]);
				updatedCommonDenominator=Integer.parseInt((SplitStr8[3]));
				}else{
					updatedCommonNumerator=0;
					updatedCommonDenominator=0;
				}
			}else if(cqmData.testCaseId.equals("TC_CQM_022")||cqmData.testCaseId.equals("TC_CQM_023"))
			{
				if(cqmData.testCaseId.equals("TC_CQM_022"))
					str2=getText(selenium,lblMetricResult8For0024);
				else
					str2=getText(selenium,lblMetricResult9For0024);
				if(!str2.equals("(No Results Found)")){
				waitForPageLoad(selenium);
				String[] splitStr3 = str2.split("[(^)]");
				waitForPageLoad(selenium);
				String[] SplitStr4 = splitStr3[1].split("\\s",4);
				System.out.println(SplitStr4[0]);
				System.out.println(SplitStr4[3]);
				updatedNumerator=Integer.parseInt(SplitStr4[0]);
				updatedDenominator=Integer.parseInt((SplitStr4[3]));
				}else{
					updatedNumerator=0;
					updatedDenominator=0;
				}
				str4=getText(selenium,lblMetricResult7For0024);
				if(!str4.equals("(No Results Found)")){
					waitForPageLoad(selenium);
					String[] splitStr7 = str4.split("[(^)]");
					waitForPageLoad(selenium);
					String[] SplitStr8 = splitStr7[1].split("\\s",4);
					waitForPageLoad(selenium);
					System.out.println(SplitStr8[0]);
					System.out.println(SplitStr8[3]);
					updatedCommonNumerator=Integer.parseInt(SplitStr8[0]);
					updatedCommonDenominator=Integer.parseInt((SplitStr8[3]));
					}else{
						updatedCommonNumerator=0;
						updatedCommonDenominator=0;
					}
			}else{
				if(cqmData.testCaseId.equals("TC_CQM_024"))
					str2=getText(selenium,lblMetricResult2For0024);
				else
					str2=getText(selenium,lblMetricResult3For0024);
				if(!str2.equals("(No Results Found)")){
					waitForPageLoad(selenium);
					String[] splitStr3 = str2.split("[(^)]");
					waitForPageLoad(selenium);
					String[] SplitStr4 = splitStr3[1].split("\\s",4);
					waitForPageLoad(selenium);
					System.out.println(SplitStr4[0]);
					System.out.println(SplitStr4[3]);
					updatedNumerator=Integer.parseInt(SplitStr4[0]);
					updatedDenominator=Integer.parseInt((SplitStr4[3]));
					}else{
						updatedNumerator=0;
						updatedDenominator=0;
					}
				str4=getText(selenium,lblMetricResult1For0024);
				if(!str4.equals("(No Results Found)")){
					waitForPageLoad(selenium);
					String[] splitStr7 = str4.split("[(^)]");
					waitForPageLoad(selenium);
					String[] SplitStr8 = splitStr7[1].split("\\s",4);
					System.out.println(SplitStr8[0]);
					System.out.println(SplitStr8[3]);
					updatedCommonNumerator=Integer.parseInt(SplitStr8[0]);
					updatedCommonDenominator=Integer.parseInt((SplitStr8[3]));
					}else{
						updatedCommonNumerator=0;
						updatedCommonDenominator=0;
					}
			}
			
			//--------------------------------------------------------------------//
			//  Step-12: verify meaningful use measures						      //
			//--------------------------------------------------------------------//
			if(updatedNumerator-numerator==1){
				if(updatedDenominator-denominator==1)
					returnValue=true;
				else
					Assert.fail("CQM Verification Failed");
			}
			else{
				Assert.fail("CQM Verification Failed");
			}
			if(updatedCommonNumerator-commonNumerator==1){
				if(updatedCommonDenominator-commonDenominator==1)
					returnValue=true;
				else
					Assert.fail("CQM Verification Failed");
			}
			else{
				Assert.fail("CQM Verification Failed");
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
