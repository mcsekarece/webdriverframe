package com.nexia.selenium.testscripts.section.chartprevisit.Allergies;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyLifeStageOnEnteringOnsetDate extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying life stage on entering the onset date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createAllergyWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_018";
		allergyData.fetchChartPreVisitTestData();
		verifyLifeStage(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}

	/**
	 * verifyLifeStage
	 * function to verify Life Stage on entering Onset date
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	  * @since  	Nov 19, 2012
	 */
	
	public boolean verifyLifeStage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			
			//Click on Allergies Link
			assertTrue(click(selenium,lnkAllergy),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(getText(selenium, lnkAllShowmore).equalsIgnoreCase("Show more details")){
				assertTrue(click(selenium,lnkAllergyShowmore),"Could not on show more button", selenium, ClassName, MethodName);
			}
			assertTrue(enterDate(selenium,txtOnset,allergyData.onsetDate),"Could not enter the Admin on ;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			selenium.clickAt(txtcomment,"");
			if(getValue(selenium,ajxlifeStage).equals(allergyData.lifeStage))
				returnValue=true;
			else
				return false;
			assertTrue(enterDate(selenium,txtOnset,allergyData.onsetDate1),"Could not enter the Admin on ;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			selenium.clickAt(txtcomment,"");
			if(getValue(selenium,ajxlifeStage).contains(allergyData.lifeStage1))
				returnValue=true;
			else
				return false;
			assertTrue(enterDate(selenium,txtOnset,allergyData.onsetDate2),"Could not enter the Admin on ;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			selenium.clickAt(txtcomment,"");
			if(getValue(selenium,ajxlifeStage).contains(allergyData.lifeStage2))
				returnValue=true;
			else
				return false;
			assertTrue(enterDate(selenium,txtOnset,allergyData.onsetDate3),"Could not enter the Admin on ;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			selenium.clickAt(txtcomment,"");
			if(getValue(selenium,ajxlifeStage).contains(allergyData.lifeStage3))
				returnValue=true;
			else
				return false;
			assertTrue(enterDate(selenium,txtOnset,allergyData.onsetDate4),"Could not enter the Admin on ;More Details:"+allergyData.toString(), selenium, ClassName, MethodName);
			selenium.clickAt(txtcomment,"");
			if(getValue(selenium,ajxlifeStage).contains(allergyData.lifeStage4))
				returnValue=true;
			else
				return false;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
