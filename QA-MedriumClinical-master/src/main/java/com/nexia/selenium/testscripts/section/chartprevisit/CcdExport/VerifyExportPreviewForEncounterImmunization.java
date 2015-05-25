package com.nexia.selenium.testscripts.section.chartprevisit.CcdExport;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyExportPreviewForEncounterImmunization extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExportChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_003";
		immunizationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addImmunizationData(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
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
	
	public boolean addImmunizationData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib immunizationData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + immunizationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, immunizationData.userName, immunizationData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//-----------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//-----------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,immunizationData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Existing Encounters//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			int count1=1;
			
			while(isElementPresent(selenium,"//div[starts-with(@id,'action')]")){
				assertTrue(click(selenium,"//div[starts-with(@id,'action')]"),"Could not click on Actions button;More Details",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,"//div[starts-with(@id,'encounterDelete')]"),"Could not click on Actions button;More Details",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtdeleteReason,"Reason"),"Could not type reason ;More Details",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnDeleteReason),"Could not click on Delete button;More Details",selenium, ClassName, MethodName);
				if(isElementPresent(selenium, "errorCloseButton"))
					assertTrue(click(selenium, "errorCloseButton"),"Could not click on error close",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				count1++;
				
				if(count1>15)
					break;
			}
			
			assertTrue(click(selenium,BeginEncounter),"Could not click the Begin Encounter;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			if(isElementPresent(selenium, lnkStartNewWncouter)){
				assertTrue(click(selenium,lnkStartNewWncouter),"Could not click the Start New  Encounter;More Details",selenium, ClassName, MethodName);
			}
			
			waitForPageLoad(selenium);
		/*	for(int i=1;i<3;i++){
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
            selenium.focus("//div[4]/div/div/div[5]/div/");				
			assertTrue(click(selenium,"//div[4]/div/div/div[5]/div/a"),"Could not click the Immunization link;More Details");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			}*/
			
		     selenium.focus(lnkImmunization);
		     selenium.clickAt(lnkImmunization,"");
			// assertTrue(click(selenium,"//div[4]/div/div/div[5]/div/a"),"Could not click the Immunization link;More Details");
			
			deleteImmunization(selenium);
			
			//-------------------------//
			//  Step-4: Add Immuization//
			//-------------------------//
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------//
			//  Step-5: Export Encounter//
			//--------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnlPrintsend),"Could not click on print tab;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			/*assertTrue(click(selenium,"//span[3]/button"),"Could not click on Delete button;More Details");
			waitForPageLoad(selenium);*/
			
			assertTrue(click(selenium,lblExport7),"Could not check the created encounter;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//------------------------------------------------//
			//  Step-6: Verify export preview for immunization//
			//------------------------------------------------//
			if(!verifyExportChartPreview(selenium,immunizationData, userAccount)){
				Assert.fail("Problem List details not saved properly; More Details :"+ immunizationData.toString());
				returnValue= false;
			}else 
				returnValue=true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + immunizationData.toString());
		}
		return returnValue;
	}
	public boolean verifyExportChartPreview(Selenium selenium , ChartPreVisitLib immunizationData, String account) throws IOException{
		
		String date="";
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
				date=DateFormat.format(cal.getTime());
				int date1=Integer.parseInt(date);
				if(date1<10){
					SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
					date=DateForma1t.format(cal.getTime());
					
				}else{
					SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd,yyyy");
					date=DateFormat2.format(cal.getTime());
				}
			}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
		
		}
		
		assertTrue(click(selenium,lnkPatientOption),"Could not click the link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkExportChart),"Could not click the link",selenium, ClassName, MethodName);
	
		System.out.println(getText(selenium,"//div[5]/div/div/div[7]/div/div[2]"));
		assertTrue(immunizationData.vaccine1.toLowerCase(new java.util.Locale("en","Us")).trim().contains(getText(selenium,"//div[5]/div/div/div[7]/div/div[2]").trim().toLowerCase(new java.util.Locale("en","Us"))),"testdata not matched",selenium, ClassName, MethodName);
		
		System.out.println(getText(selenium,lblExport1));
		assertTrue(getText(selenium,lblExport1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.lotNumber.trim().toLowerCase(new java.util.Locale("en","Us"))),"test Data not matched",selenium, ClassName, MethodName);
				System.out.println(getText(selenium,lblExport2));
		assertTrue(getText(selenium,lblExport2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.adminBy.trim().toLowerCase(new java.util.Locale("en","Us"))),"test Data Not matched",selenium, ClassName, MethodName);

		
		System.out.println(getText(selenium,lblExport3));
		assertTrue(getText(selenium,lblExport3).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.reaction.trim().toLowerCase(new java.util.Locale("en","Us"))),"Test DATA not matched",selenium, ClassName, MethodName);
		
		System.out.println(getText(selenium,lblExport4));
		assertTrue(getText(selenium,lblExport4).toLowerCase(new java.util.Locale("en","Us")).contains(date.toLowerCase(new java.util.Locale("en","Us"))),"TEST DATA NOT Matched",selenium, ClassName, MethodName);
		
	
		return true;
	}
}
