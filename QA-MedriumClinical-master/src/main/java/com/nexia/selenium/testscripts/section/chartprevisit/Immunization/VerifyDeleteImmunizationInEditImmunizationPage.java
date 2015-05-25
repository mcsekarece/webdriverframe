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

public class VerifyDeleteImmunizationInEditImmunizationPage extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Delete  Immunization in Edit Encounter Immunization")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditEncourdsnterImmunizationFromSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_041";
		immunizationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	/**
	 * editImmunization
	 * function to edited Immunization in summary present in encounter
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @defect 		#7654
	 * @throws IOException 
	 * @since  	    Nov 02, 2012
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
			
			assertTrue(click(selenium,lnkencounterTab),"Could not click the Encounter link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllEncounters(selenium,immunizationData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Immunization//
			//--------------------------------------------------------------------//
			
			assertTrue(deleteImmunization(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveImmunization),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Begin Encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium)," Could not navigate to begin encounters", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Encounter Immunization//
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,lnkEncounterImmunization),"Could not find the link", selenium, ClassName, MethodName);
			selenium.clickAt(lnkEncounterImmunization,"");
			//selenium.focus(lnkImmunization);
			//selenium.fireEvent(lnkImmunization,"keypress");
			waitForPageLoad(selenium);
					
			//--------------------------------------------------------------------//
			//  Step-6: Create Encounter Immunization//
			//--------------------------------------------------------------------//
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Edit Encounter Immunization//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkImmunEncounterdetails),"Could not find the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.clickAt(lnkImmunEncounterdetails,"");
		
			assertTrue(click(selenium,btnEdit),"Could not click the edit button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8:Verify Edit Immunization Details//
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValue(selenium, immunizationData,userAccount),"ImmunizationData details not saved properly; More Details :"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-9: Delete Immunization in Edid Immunization page                      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,BtnDeleteImmuni),"Could not click the Delete button;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtdeleteReason,"Reason" ),"Could not click the Delete button;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnDeleteReason),"Could not click the Delete button;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			
			//--------------------------------------------------------------------//
			//  Step-10:Verify Delete Record in Encounter Note Page               //
			//--------------------------------------------------------------------//
			assertTrue(!selenium.isElementPresent(lnkImmunEncounterdetails),"Could not delted", selenium, ClassName, MethodName);
			
			
			
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
		
		assertTrue(getValue(selenium,txtexpiryDate).trim().contains(date.trim()),"Could not Find value", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtadminDate).trim().contains(date),"Could not Find value", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,ajxVaccine).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.Vaccine1CA.trim().toLowerCase(new java.util.Locale("en","Us"))),"Could not Find value", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtImmComment).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.comment.trim().toLowerCase(new java.util.Locale("en","Us"))),"Could not Find value", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,ajxadminsteredBy).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.adminBy.trim().toLowerCase(new java.util.Locale("en","Us"))),"Could not Find value", selenium, ClassName, MethodName);
	
		/*if(!getValue(selenium,ajxImmreaction).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.reaction.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}*/
		/*if(!getValue(selenium,txtImmDosage).trim().contains(immunizationData.dosage.trim())){
			return false;
		}
		if(!getValue(selenium,ajxImmdosage).trim().contains(immunizationData.dosageUnit.trim())){
			return false;
		}*/
		
		/*if(!getValue(selenium,ajxImmRoute).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.route.trim().toLowerCase(new java.util.Locale("en","Us")))){
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
		}*/
		return true;
	}
}
