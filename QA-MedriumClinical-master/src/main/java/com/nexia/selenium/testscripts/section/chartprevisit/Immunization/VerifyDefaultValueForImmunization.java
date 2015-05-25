package com.nexia.selenium.testscripts.section.chartprevisit.Immunization;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultValueForImmunization extends AbstractChartPreVisit{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Default Value")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValuesForImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_040";
		immunizationData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyDefaultStoreValues(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	/**
	 * verifyDefaultStoreValues
	 * function to verify Default Store Values
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	  * @since  	Oct 04, 2012
	 */

	public boolean verifyDefaultStoreValues(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib immunizationData) throws IOException{
		boolean returnValue=true;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + immunizationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, immunizationData.userName, immunizationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,immunizationData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Immunization//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteImmunization(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Click Add button//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnAdd),"Could not click the add button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkImmShowMore),"Could not click the link;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Verify Default Values//
			//--------------------------------------------------------------------//
			assertTrue(verifyDefaultStoredValue(selenium,immunizationData,userAccount),"Immunization details not saved properly; More Details :"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
					}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyDefaultStoredValue(Selenium selenium,ChartPreVisitLib immunizationData,String account) throws IOException{
		
		String date=null;
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			date=DateFormat.format(cal.getTime());
		}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
		
		}
		
		assertTrue(getValue(selenium,txtadminDate).trim().equalsIgnoreCase(date.trim()),"Could not Find the text"+immunizationData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	
		waitForPageLoad(selenium);
		String providerNameTemp= getText(selenium, lnkTopMenu);
		String providerName= providerNameTemp.replaceAll(", FULL", "");
		assertTrue(getValue(selenium,ajxadminsteredBy).toLowerCase(new java.util.Locale("en","Us")).toLowerCase(new java.util.Locale("en","Us")).trim().contains(providerName.toLowerCase(new java.util.Locale("en","Us"))),"Could not Find the text"+immunizationData.toString(), selenium, ClassName, MethodName);
				return true;
	}
}
