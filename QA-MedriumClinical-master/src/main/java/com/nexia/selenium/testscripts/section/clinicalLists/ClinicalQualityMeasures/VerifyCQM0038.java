package com.nexia.selenium.testscripts.section.clinicalLists.ClinicalQualityMeasures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCQM0038 extends AbstractClinicalList {
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
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureFor0038ForDTABWithExclusion(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_017";
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
		int numerator1=0,denominator1=0,numerator2=0,denominator2=0,numerator3=0,denominator3=0,numerator4=0,denominator4=0,numerator5=0,denominator5=0,numerator6=0,
		denominator6=0,numerator7=0,denominator7=0,numerator8=0,denominator8=0,numerator9=0,denominator9=0,numerator10=0,denominator10=0,numerator11=0,denominator11=0,numerator12=0,denominator12;
		int updatedNumerator1=0,updatedDenominator1=0,updatedNumerator2=0,updatedDenominator2=0,updatedNumerator3=0,updatedDenominator3=0,updatedNumerator4=0,updatedDenominator4=0,updatedNumerator5=0,updatedDenominator5=0,updatedNumerator6=0,
		updatedDenominator6=0,updatedNumerator7=0,updatedDenominator7=0,updatedNumerator8=0,updatedDenominator8=0,updatedNumerator9=0,updatedDenominator9=0,updatedNumerator10=0,updatedDenominator10=0,updatedNumerator11=0,updatedDenominator11=0,updatedNumerator12=0,updatedDenominator12=0;
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
			selectValueFromAjaxList(selenium, ajxProvider, cqmData.provider);
			assertTrue(editMeasure(selenium,cqmData), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: verify meaningful use measures						      //
			//--------------------------------------------------------------------//
			assertTrue(verifyMeasure(selenium, cqmData), "Could not enter required values", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Note down the the metric results					              //
			//--------------------------------------------------------------------//
			
			str1 = getText(selenium, lblMetricResult1For0038);
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
			
			str1 = getText(selenium, lblMetricResult2For0038);
			if(!str1.equals("(No Results Found)")){
			waitForPageLoad(selenium);
			String[] splitStr1 = str1.split("[(^)]");
			waitForPageLoad(selenium);
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			waitForPageLoad(selenium);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			numerator2=Integer.parseInt(SplitStr2[0]);
			denominator2=Integer.parseInt((SplitStr2[3]));
			}
			else {
				numerator2=0;
				denominator2=0;
			}
			str1 = getText(selenium, lblMetricResult3For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			numerator3=Integer.parseInt(SplitStr2[0]);
			denominator3=Integer.parseInt((SplitStr2[3]));
			}
			else {
				numerator3=0;
				denominator3=0;
			}
			str1 = getText(selenium, lblMetricResult4For0038);
			if(!str1.equals("(No Results Found)")){
			waitForPageLoad(selenium);
			String[] splitStr1 = str1.split("[(^)]");
			waitForPageLoad(selenium);
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			waitForPageLoad(selenium);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			numerator4=Integer.parseInt(SplitStr2[0]);
			denominator4=Integer.parseInt((SplitStr2[3]));
			}
			else {
				numerator4=0;
				denominator4=0;
			}
			str1 = getText(selenium, lblMetricResult5For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			numerator5=Integer.parseInt(SplitStr2[0]);
			numerator5=Integer.parseInt((SplitStr2[3]));
			}
			else {
				numerator5=0;
				numerator5=0;
			}
			str1 = getText(selenium, lblMetricResult6For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			numerator6=Integer.parseInt(SplitStr2[0]);
			denominator6=Integer.parseInt((SplitStr2[3]));
			}
			else {
				numerator6=0;
				denominator6=0;
			}
			str1 = getText(selenium, lblMetricResult7For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			numerator7=Integer.parseInt(SplitStr2[0]);
			denominator7=Integer.parseInt((SplitStr2[3]));
			}
			else {
				numerator7=0;
				denominator7=0;
			}
			
			str1 = getText(selenium, lblMetricResult8For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			numerator8=Integer.parseInt(SplitStr2[0]);
			denominator8=Integer.parseInt((SplitStr2[3]));
			}
			else {
				numerator8=0;
				denominator8=0;
			}
			str1 = getText(selenium, lblMetricResult9For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			numerator9=Integer.parseInt(SplitStr2[0]);
			denominator9=Integer.parseInt((SplitStr2[3]));
			}
			else {
				numerator9=0;
				denominator9=0;
			}
			str1 = getText(selenium, lblMetricResult10For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			numerator10=Integer.parseInt(SplitStr2[0]);
			numerator10=Integer.parseInt((SplitStr2[3]));
			}
			else {
				numerator10=0;
				numerator10=0;
			}
			str1 = getText(selenium, lblMetricResult11For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			numerator11=Integer.parseInt(SplitStr2[0]);
			denominator11=Integer.parseInt((SplitStr2[3]));
			}
			else {
				numerator11=0;
				denominator11=0;
			}
			str1 = getText(selenium, lblMetricResult12For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			numerator12=Integer.parseInt(SplitStr2[0]);
			denominator12=Integer.parseInt((SplitStr2[3]));
			}
			else {
				numerator12=0;
				denominator12=0;
			}
			
			//--------------------------------------------------------------------//
			//  Step-6: Perform actions for calculating the metric
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,cqmData.firstName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Create first encounter
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not Begin encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxProvider, cqmData.provider);
			waitForPageLoad(selenium);
			assertTrue(enterDate(selenium, txtEncounterDate, "2/15/2012"),"could not enter", selenium, ClassName, MethodName);
			click(selenium,btnSign);		
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-8: Create encounter with procedure
			//--------------------------------------------------------------------//
		
			assertTrue(goToBeginEncounter(selenium),"Could not Begin encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxProvider, cqmData.provider);
			waitForPageLoad(selenium);
			assertTrue(enterDate(selenium, txtEncounterDate, "02/15/2012"),"could not enter", selenium, ClassName, MethodName);
			
			ChartPreVisitLib immunizationData = new ChartPreVisitLib();
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_013";
			immunizationData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkImmunizations),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(createImmunizationForCqm(selenium,immunizationData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_014";
			immunizationData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkImmunizations),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(createImmunizationForCqm(selenium,immunizationData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_015";
			immunizationData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkImmunizations),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(createImmunizationForCqm(selenium,immunizationData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_016";
			immunizationData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkImmunizations),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(createImmunizationForCqm(selenium,immunizationData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_017";
			immunizationData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkImmunizations),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(createImmunizationForCqm(selenium,immunizationData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_018";
			immunizationData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkImmunizations),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(createImmunizationForCqm(selenium,immunizationData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_019";
			immunizationData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkImmunizations),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(createImmunizationForCqm(selenium,immunizationData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_020";
			immunizationData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkImmunizations),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(createImmunizationForCqm(selenium,immunizationData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_021";
			immunizationData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkImmunizations),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(createImmunizationForCqm(selenium,immunizationData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_022";
			immunizationData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkImmunizations),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(createImmunizationForCqm(selenium,immunizationData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_023";
			immunizationData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkImmunizations),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(createImmunizationForCqm(selenium,immunizationData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_024";
			immunizationData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkImmunizations),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(createImmunizationForCqm(selenium,immunizationData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_025";
			immunizationData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkImmunizations),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(createImmunizationForCqm(selenium,immunizationData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_026";
			immunizationData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,lnkImmunizations),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			assertTrue(createImmunizationForCqm(selenium,immunizationData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSign),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-10: Verify CQM results
			//--------------------------------------------------------------------//
			assertTrue(goToClinicalQualityMeasures(selenium), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			assertTrue(editMeasure(selenium,cqmData), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			assertTrue(verifyMeasure(selenium, cqmData), "Could not enter required values", selenium, ClassName, MethodName);
			
			str1 = getText(selenium, lblMetricResult1For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
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
			str1 = getText(selenium, lblMetricResult2For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			updatedNumerator2=Integer.parseInt(SplitStr2[0]);
			updatedDenominator2=Integer.parseInt((SplitStr2[3]));
			}
			
			if(updatedNumerator2-numerator2==1)
				if(updatedDenominator2-denominator2==1)
					returnValue=true;
				else
					returnValue=false;
			
			str1 = getText(selenium, lblMetricResult3For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			updatedNumerator3=Integer.parseInt(SplitStr2[0]);
			updatedDenominator3=Integer.parseInt((SplitStr2[3]));
			}
			
			if(updatedNumerator3-numerator3==1)
				if(updatedDenominator3-denominator3==1)
					returnValue=true;
				else
					returnValue=false;
			str1 = getText(selenium, lblMetricResult4For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			updatedNumerator4=Integer.parseInt(SplitStr2[0]);
			updatedDenominator4=Integer.parseInt((SplitStr2[3]));
			}
			
			if(updatedNumerator4-numerator4==1)
				if(updatedDenominator4-denominator4==1)
					returnValue=true;
				else
					returnValue=false;
			str1 = getText(selenium, lblMetricResult5For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			updatedNumerator5=Integer.parseInt(SplitStr2[0]);
			updatedDenominator5=Integer.parseInt((SplitStr2[3]));
			}
			
			if(updatedNumerator5-numerator5==1)
				if(updatedDenominator5-denominator5==1)
					returnValue=true;
				else
					returnValue=false;
			str1 = getText(selenium, lblMetricResult6For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			updatedNumerator6=Integer.parseInt(SplitStr2[0]);
			updatedDenominator6=Integer.parseInt((SplitStr2[3]));
			}
			
			if(updatedNumerator6-numerator6==1)
				if(updatedDenominator6-denominator6==1)
					returnValue=true;
				else
					returnValue=false;
			str1 = getText(selenium, lblMetricResult7For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			updatedNumerator7=Integer.parseInt(SplitStr2[0]);
			updatedDenominator7=Integer.parseInt((SplitStr2[3]));
			}
			
			if(updatedNumerator7-numerator7==0)
				if(updatedDenominator7-denominator7==1)
					returnValue=true;
				else
					returnValue=false;
			str1 = getText(selenium, lblMetricResult8For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			updatedNumerator8=Integer.parseInt(SplitStr2[0]);
			updatedDenominator8=Integer.parseInt((SplitStr2[3]));
			}
			
			if(updatedNumerator8-numerator8==0)
				if(updatedDenominator8-denominator8==1)
					returnValue=true;
				else
					returnValue=false;
			str1 = getText(selenium, lblMetricResult9For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			updatedNumerator9=Integer.parseInt(SplitStr2[0]);
			updatedDenominator9=Integer.parseInt((SplitStr2[3]));
			}
			
			if(updatedNumerator9-numerator9==0)
				if(updatedDenominator9-denominator9==1)
					returnValue=true;
				else
					returnValue=false;
			str1 = getText(selenium, lblMetricResult10For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			updatedNumerator10=Integer.parseInt(SplitStr2[0]);
			updatedDenominator10=Integer.parseInt((SplitStr2[3]));
			}
			
			if(updatedNumerator10-numerator10==0)
				if(updatedDenominator10-denominator10==1)
					returnValue=true;
				else
					returnValue=false;
			str1 = getText(selenium, lblMetricResult11For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			updatedNumerator11=Integer.parseInt(SplitStr2[0]);
			updatedDenominator11=Integer.parseInt((SplitStr2[3]));
			}
			
			if(updatedNumerator11-numerator11==1)
				if(updatedDenominator11-denominator11==1)
					returnValue=true;
				else
					returnValue=false;
			str1 = getText(selenium, lblMetricResult12For0038);
			if(!str1.equals("(No Results Found)")){
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			updatedNumerator12=Integer.parseInt(SplitStr2[0]);
			updatedDenominator12=Integer.parseInt((SplitStr2[3]));
			}
			
			if(updatedNumerator12-numerator12==0)
				if(updatedDenominator12-denominator12==1)
					returnValue=true;
				else
					returnValue=false;
			
			
			if(cqmData.testCaseId.equals("TC_CQM_0017")){
				searchPatientNexiaForProviderHomePage(selenium,cqmData.firstName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnUpdateResults),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				ChartPreVisitLib allergyData = new ChartPreVisitLib();
				allergyData.workSheetName = "CreateAllergy";
				allergyData.testCaseId = "TC_CA_016";
				allergyData.fetchChartPreVisitTestData();
				assertTrue(createAllergyCqm(selenium,allergyData),"Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				

				assertTrue(goToClinicalQualityMeasures(selenium), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
				assertTrue(verifyMeasure(selenium, cqmData), "Could not enter required values", selenium, ClassName, MethodName);		
				String str3 = getText(selenium, lblMetricResult1For0038);
				
				String[] splitStr5 = str3.split("[(^)]");
				String[] SplitStr6 = splitStr5[1].split("\\s",4);
				System.out.println(SplitStr6[0]);
				System.out.println(SplitStr6[3]);
				int excludeNumerator=Integer.parseInt(SplitStr6[0]);
				int excludeDenominator=Integer.parseInt((SplitStr6[3]));
				if(updatedNumerator1-excludeNumerator==1)
					if(updatedDenominator1-excludeDenominator==1)
						returnValue=true;
					else
						return false;	
			}
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}


}
