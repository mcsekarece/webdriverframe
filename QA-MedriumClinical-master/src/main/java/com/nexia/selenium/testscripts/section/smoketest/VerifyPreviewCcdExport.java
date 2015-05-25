package com.nexia.selenium.testscripts.section.smoketest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.smoketest.SmokeTestLib;
import com.nexia.selenium.genericlibrary.smoketest.AbstractSmokeTest;
import com.thoughtworks.selenium.Selenium;

public class VerifyPreviewCcdExport extends AbstractSmokeTest {
	
	@Test(groups = {"SmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExportChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SmokeTestLib allergyData = new SmokeTestLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_002";
		allergyData.fetchSmokeTestData();		
		addAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}	

	/**
	 * addAllergy
	 * function to add Allergy
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 17, 2012
	 */
	
	public boolean addAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SmokeTestLib allergyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ", selenium, ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage_smoke(selenium,allergyData.patientId),"", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Add Allergy//
			//--------------------------------------------------------------------//
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);		
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify export preview for allergy//
			//--------------------------------------------------------------------//
			if(!verifyExportChartPreview(selenium,allergyData,userAccount)){
				Assert.fail("Allergy details not saved properly; More Details :"+ allergyData.toString());
				returnValue= false;
			}else 
				returnValue=true;
			
			}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + allergyData.toString());
		}
		return returnValue;
	}
	public boolean verifyExportChartPreview(Selenium selenium , SmokeTestLib allergyData, String userAccount ) throws IOException{
		
		String date="";
		assertTrue(click(selenium,lnkPatientOption),"Could not click the link", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkExportChart),"Could not click the Export Chart Link", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
				
		if(!selenium.isTextPresent(allergyData.allergyType)){
			return false;
		}
		
			
		if(userAccount.equalsIgnoreCase(CAAccount)){
			assertTrue(getText(selenium,"Allergen_Div").toLowerCase(new java.util.Locale("en","US")).trim().contains(allergyData.allergenCA.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not click on More  link", selenium, ClassName, MethodName);
	    }
		else{
		
	
	
			assertTrue(getText(selenium,lblAllgergy).toLowerCase(new java.util.Locale("en","US")).trim().contains(allergyData.allergen.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not allgergy details", selenium, ClassName, MethodName);
	
		}
			
		waitForPageLoad(selenium);
		if(!selenium.isTextPresent(allergyReaction)){
			return false;
		}
		
		waitForPageLoad(selenium);
		
		if(!selenium.isTextPresent(allergyData.severity)){
			return false;
		}
		
		waitForPageLoad(selenium);
		if(userAccount.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MMM d, yyyy");
			date=DateFormat.format(cal.getTime());
			
		}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
			
		}
			
		
		return true;
	}

}

