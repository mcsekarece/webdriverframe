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

public class VerifyExportPreviewForImmunization extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Export Chart")
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
			
			assertTrue(click(selenium,lnkImmunization),"Could not click the Allergy link;More Details",selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			
			
			deleteImmunization(selenium);
			//-------------------------//
			//  Step-3: Add Immuization//
			//-------------------------//
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//------------------------------------------------//
			//  Step-4: Verify export preview for immunization//
			//------------------------------------------------//
			
			
			assertTrue(verifyExportChartPreview(selenium,immunizationData,userAccount),"Immunization details not saved properly; More Details :"+ immunizationData.toString(),selenium, ClassName, MethodName);
			
			
			}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + immunizationData.toString());
		}
		return returnValue;
	}
	public boolean verifyExportChartPreview(Selenium selenium , ChartPreVisitLib immunizationData,String account) throws IOException{
		String date=null;
		String vaccine="RSV";
		// Change this based on the immunization vaccine
		assertTrue(click(selenium,lnkPatientOption),"Could not click the link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkExportChart),"Could not click the link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		System.out.println(getText(selenium,"//div[5]/div/div/div[7]/div/div[2]"));
		if(account.equals(CAAccount)){
			
		assertTrue(vaccine.toLowerCase(new java.util.Locale("en","Us")).trim().contains(getText(selenium,"//div[5]/div/div/div[7]/div/div[2]").trim().toLowerCase(new java.util.Locale("en","Us"))),"Vaccination Value not matched",selenium, ClassName, MethodName);	
			
		}
		else{
			
			assertTrue(immunizationData.vaccine1.toLowerCase(new java.util.Locale("en","Us")).trim().contains(getText(selenium,"//div[5]/div/div/div[7]/div/div[2]").trim().toLowerCase(new java.util.Locale("en","Us"))),"Immutation value not matched",selenium,ClassName, MethodName);
			
		}
		
		System.out.println(getText(selenium,lblExport1));
		assertTrue(getText(selenium,lblExport1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.lotNumber.trim().toLowerCase(new java.util.Locale("en","Us"))),"",selenium,ClassName, MethodName);
		
		System.out.println(getText(selenium,lblExport2));
		assertTrue(getText(selenium,lblExport2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.adminBy.trim().toLowerCase(new java.util.Locale("en","Us"))),"",selenium,ClassName, MethodName);
		
		System.out.println(getText(selenium,lblExport3));
		assertTrue(getText(selenium,lblExport3).toLowerCase(new java.util.Locale("en","Us")).trim().contains(immunizationData.reaction.trim().toLowerCase(new java.util.Locale("en","Us"))),"",selenium,ClassName, MethodName);
		
		System.out.println(getText(selenium,"//div[@id='AdministeredOn_Div']"));
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
				date=DateFormat.format(cal.getTime());
				int date1=Integer.parseInt(date);
				if(date1<10){
					SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
					date=DateForma1t.format(cal.getTime());
					
				}else{
					SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");
					date=DateFormat2.format(cal.getTime());
				}
			}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
		
		}
		
		assertTrue(getText(selenium,"//div[@id='AdministeredOn_Div']").trim().contains(date.trim()),"Date Could not match",selenium,ClassName, MethodName);
		
		return true;
	}
}
