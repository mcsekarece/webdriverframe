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

public class VerifyStoreValuesForImmunization extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for  verify Store Values For Immunization ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValuesForImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_048";
		immunizationData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyStoreValues(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Store Values For SummaryPage")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValuesForSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_049";
		immunizationData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyStoreValuesInSummaryPage(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Store Values For Edit Immunization")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValuesForEditImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_050";
		immunizationData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		editImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	/**
	 * verifyStoreValues
	 * function to verify Store Values
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Sep 26, 2012
	 */
	
	public boolean verifyStoreValues(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib immunizationData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
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
			//  Step-4: Create Immunization//
			//--------------------------------------------------------------------//
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Verify Stored Values//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnImmunizationEdit),"Could not click edit button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyStoredValue(selenium, immunizationData,userAccount)){
				Assert.fail("ImmunizationData details not saved properly; More Details :"+ immunizationData.toString());
				returnValue= false;
			}
			else 
				returnValue=true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
	public boolean verifyStoredValue(Selenium selenium,ChartPreVisitLib immunizationData,String account) throws IOException{
		
		String date=null;
		//waitForPageLoad(selenium);
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			 date=DateFormat.format(cal.getTime());
			 
		}else{
				Calendar cal1=Calendar.getInstance();
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
				date=DateForma1t.format(cal1.getTime());
				
		}
		if(!getValue(selenium,txtexpiryDate).trim().contains(date.trim())){
			return false;
		}
		
		if(!getValue(selenium,txtadminDate).trim().contains(date)){
			return false;
		}
		/*
		if (getText(selenium, lnkAllShowmore).equalsIgnoreCase(
				"Show more details")) {
			Assert.assertTrue(click(selenium, lnkAllergyShowmore),
					"Could not on show more button");
		}*/
		if(account.equals(CAAccount)){
			assertTrue(selenium.isTextPresent(immunizationData.Vaccine1CA.toUpperCase()),"Vaccine details r not present:"+immunizationData.toString(), selenium, ClassName, MethodName);
		}
		else
		{
			assertTrue(selenium.isTextPresent(immunizationData.vaccine1.toUpperCase()),"Vaccine details r not present:"+immunizationData.toString(), selenium, ClassName, MethodName);
		}
		if(!getValue(selenium,txtImmComment).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.comment.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getValue(selenium,ajxImmreaction).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.reaction.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getValue(selenium,txtImmDosage).trim().contains(immunizationData.dosage.trim())){
			return false;
		}
		/*if(!getValue(selenium,ajxImmdosage).trim().contains(immunizationData.dosageUnit.trim())){
			return false;
		}*/
		if(!getValue(selenium,ajxadminsteredBy).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.adminBy.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getValue(selenium,ajxImmRoute).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.route.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getValue(selenium,ajxSite).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.site.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getValue(selenium,ajxSeries1).trim().contains(immunizationData.series.trim())){
			return false;
		}
		if(!getValue(selenium,ajxSeries2).trim().contains(immunizationData.seriesof.trim())){
			return false;
		}
	
		if(!getValue(selenium,ajxImmCpt1).trim().contains(immunizationData.cptCode1.trim())){
			return false;
		}
		if(!getValue(selenium,ajxImmCp2).trim().contains(immunizationData.cptCode2.trim())){
			return false;
		}
		return true;
	}
	
	/**
	 * verifyStoreValuesInSummaryPage
	 * function to verify Store Values In SummaryPage
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Sep 26, 2012
	 */
	
	public boolean verifyStoreValuesInSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib immunizationData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + immunizationData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, immunizationData.userName, immunizationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
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
			//  Step-4: Create Immunization//
			//--------------------------------------------------------------------//
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Verify Stored Values//
			//--------------------------------------------------------------------//
			if(!verifyStoredValueInSummaryPage(selenium,immunizationData,userAccount)){
				Assert.fail("Immunization details not saved properly; More Details :"+ immunizationData.toString());
				returnValue= false;
			}else 
				returnValue=true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyStoredValueInSummaryPage(Selenium selenium,ChartPreVisitLib immunizationData,String account) throws IOException{
		//waitForPageLoad(selenium);
		String date=null;
		//assertTrue(click(selenium,lblsummaryImm1),"Could not click the arrow;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lblsummaryImmMenuArrow),"Could not click the arrow;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
	if(account.equals(CAAccount)){
			assertTrue(selenium.isTextPresent(immunizationData.Vaccine1CA.toUpperCase()),"Vaccine details r not present:"+immunizationData.toString(), selenium, ClassName, MethodName);
		}
		else
		{
			assertTrue(selenium.isTextPresent(immunizationData.vaccine1.toUpperCase()),"Vaccine details r not present:"+immunizationData.toString(), selenium, ClassName, MethodName);
		}
		assertTrue(selenium.isTextPresent(immunizationData.comment), "" + "immunization comment  Not Present", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);		
		
		assertTrue(selenium.isTextPresent(immunizationData.reaction), "" + "immunization reaction  Not Present", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		
	
		assertTrue(selenium.isTextPresent(immunizationData.dosage), "" + "immunization Dosage  Not Present", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);

				
		assertTrue(selenium.isTextPresent(immunizationData.adminBy), ""	+ " Immunization adminBy Not Present", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(immunizationData.site), ""  + "immunization site Not Present", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(immunizationData.route), "" + " Immunization route Not Present", selenium, ClassName,	MethodName);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(immunizationData.lotNumber), "" + " Immunization lotNumber Not Present", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selenium.isTextPresent(immunizationData.series), "" 	+ " Immunization series Not Present", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(immunizationData.seriesof), "" + "immunization seriesof Not Present", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);

				
		
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat.format(cal.getTime());
				
			}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
			
		}
		
		assertTrue(selenium.isTextPresent(date), "" + "Date Not Present", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
				
		assertTrue(selenium.isTextPresent(immunizationData.cpt1), "" + " Immunization cpt1 Not Present", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(immunizationData.cpt2), "" + " Immunization cpt2 Not Present", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		
		return true;
	}
	
	
	/**
	 * editImmunization
	 * function to editImmunization
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 10, 2012
	 */
	
	public boolean editImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib immunizationData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
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
			//  Step-4: Create Immunization//
			//--------------------------------------------------------------------//
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Edit Immunization//
			//--------------------------------------------------------------------//
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_004";
			immunizationData.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,btnImmunizationEdit),"Could not click edit button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Edition failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnImmunizationEdit),"Could not click edit button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Stored Values//
			//--------------------------------------------------------------------//
			if(!verifyStoredValue(selenium, immunizationData,userAccount)){
				Assert.fail("ImmunizationData details not saved properly; More Details :"+ immunizationData.toString());
				returnValue= false;
			}
			else 
				returnValue=true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
