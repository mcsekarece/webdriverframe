package com.nexia.selenium.testscripts.section.chartprevisit.Injection;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeleteInjectionInEditInjectionPage extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to verify, Edited Injection in summary page present in Encounter page ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeleteInjectionInEncounterFromSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_025";
		injectionData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDeleteInjectionInEncounterFromSummary(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}
	/**
	 * editInjection
	 * Function to verify, Edited Injection in summary page present in Encounter page 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @defect 		#7654
	 * @throws      IOException 
	 * @since  	    Dec 20, 2013
	 */
	public boolean verifyDeleteInjectionInEncounterFromSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib injectionData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + injectionData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, injectionData.userName, injectionData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,injectionData.patientId);
			waitForPageLoad(selenium);
			
			
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,injectionData),"Deletion failed",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Begin Encounter                               //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Encounter Immunization//
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,lnkEncounterInjection),"Could not find the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkEncounterInjection,"");
			selenium.focus(lnkEncounterInjection);
			selenium.fireEvent(lnkEncounterInjection,"keypress");
			
			waitForPageLoad(selenium);
			assertTrue(deleteInjection(selenium),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ injectionData.switchRole , "");
			
			assertTrue(createInjection(selenium,injectionData,userAccount,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Edit Encounter Injection//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,strInjection),"unable to click the injection link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEditInjection),"Could not click the edit button;More Details:"+injectionData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8:Verify Edit Injection Page Details//
			//--------------------------------------------------------------------//
			
			if(!verifyStoredValue(selenium, injectionData,providerName,userAccount )){
				Assert.fail("ImmunizationData details not saved properly; More Details :"+ injectionData.toString());
				returnValue= false;
			}
			
			//--------------------------------------------------------------------//
			//  Step-9: Delete Immunization in Edid Immunization page                      //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnDeleteInjectin),"Could not click the Delete button;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtdeleteReason,injectionData.reason ),"Could not click the Delete button;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnDeleteReason),"Could not click the Delete button;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10:Verify Delete Record in Encounter Note Page               //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin encounter button;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
						
			if((selenium.isTextPresent(injectionData.injection))){
				Assert.fail("Reocrd is not Deleted");
			}else
				returnValue = true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + injectionData.toString());
		}
		return returnValue;
	}
	
	public boolean verifyStoredValue(Selenium selenium,ChartPreVisitLib injectionData,String providerName,String account) throws IOException{
		waitForPageLoad(selenium);
	
		String date="";
		/*if(!getText(selenium,"css=div.small.paddingTop20 > div.gwt-Label").trim().contains("American Medical Association.".trim())){
			return false;
		}*/
		
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			date=DateFormat.format(cal.getTime());
			
		}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
			
		}
		if (getText(selenium, lnkAllShowmore).equalsIgnoreCase(
				"Show more details")) {
			assertTrue(click(selenium, lnkAllergyShowmore),
					"Could not on show more button", selenium, ClassName, MethodName);
		}
		
		if(!getValue(selenium,txtadminOn).trim().contains(date.trim())){
			return false;
		}
		if(!getValue(selenium,ajxReaction).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.reaction.trim().toLowerCase(new java.util.Locale("en","Us")))){
		return false;
		}
		
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(injectionData.comment),""+"Injection Comment Not Present",selenium, ClassName, MethodName);
		//waitForPageLoad(selenium);
		
		
		//if(!getValue(selenium,txtDosage).trim().contains(injectionData.dosage.trim())){
			//return false;
		//}
		if(!getValue(selenium,ajxDosageUnit).trim().contains(injectionData.dosageUnit.trim())){
			return false;
		}
		if(!getValue(selenium,ajxAdminBy).trim().contains(providerName.trim())){
			return false;
		}
		if(!getValue(selenium,site).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.site.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getValue(selenium,ajxInjectionRoute).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.route.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		if(!getValue(selenium,txtLotNo).trim().contains(injectionData.lotNumber.trim())){
			return false;
		}
		if(!getValue(selenium,txtexpiryDate).trim().contains(date.trim())){
			return false;
		}
		/*if(!getValue(selenium,cptCode1).trim().contains(injectionData.cptCode1.trim())){
		return false;
	    }
	   if(!getValue(selenium,cptCode2).trim().contains(injectionData.cptCode2.trim())){
		return false;
    }*/
		return true;
	}
}
