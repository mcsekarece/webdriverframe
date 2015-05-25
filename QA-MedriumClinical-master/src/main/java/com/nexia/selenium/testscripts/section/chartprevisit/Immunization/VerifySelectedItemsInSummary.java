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

public class VerifySelectedItemsInSummary extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying the added Immunization present in list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValueForImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_047";
		immunizationData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyCreateImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	/**
	 * verifyCreateImmunization
	 * function to verify the added Immunization present in list
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 02, 2012
	 */
public boolean verifyCreateImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib immunizationData) throws IOException{
		
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
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Delete Immunization//
			//--------------------------------------------------------------------//
			assertTrue(deleteImmunization(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Create Immunization//
			//--------------------------------------------------------------------//
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Editing immunization failed", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//  Step-5: verify stored values in summary  //
			//--------------------------------------------------------------------//
			if(!verifyCollapseViewForImmunization(selenium,immunizationData,userAccount)){
				Assert.fail("Medication details not saved properly in collapse view :"+ immunizationData.toString());
			}
			
			if(!verifyExpandViewForImmunization(selenium,immunizationData,userAccount)){
				Assert.fail("Medication details not saved properly in Expand view :"+ immunizationData.toString());
			}
			
			assertTrue(click(selenium,"//td/div/input"),"Could not on select check box", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not on select check box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify selected items in summary //
			//--------------------------------------------------------------------//
			if(selenium.isTextPresent("No immunizations added")){
				returnValue=true;
			}else
				returnValue=false;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
public boolean verifyCollapseView(Selenium selenium, ChartPreVisitLib immunizationData,String account) throws IOException{
	String date=null;
	
	assertTrue(selenium.isTextPresent(immunizationData.Vaccine1CA), "" + "immunization vaccine  Not Present", selenium, ClassName,MethodName);
	
	
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
	

	assertTrue(selenium.isTextPresent(immunizationData.comment), "" + "immunization comment  Not Present", selenium, ClassName,MethodName);

	
	assertTrue(selenium.isTextPresent(immunizationData.reaction), "" + "immunization reaction  Not Present", selenium, ClassName,MethodName);
	
		
	
		return true;
}	

public boolean verifyExpandView(Selenium selenium, ChartPreVisitLib immunizationData,String account) throws IOException{
	String date=null;
	assertTrue(click(selenium,lblCollapseViewArrow),"Could not click on Expand button", selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	waitForPageLoad(selenium);
	
	assertTrue(selenium.isTextPresent(immunizationData.dosage), "" 	+ "immunization Dosage  Not Present", selenium, ClassName, 	MethodName);
	

	assertTrue(selenium.isTextPresent(immunizationData.adminBy), ""	+ " Immunization adminBy Not Present", selenium, ClassName,	MethodName);
	

	assertTrue(selenium.isTextPresent(immunizationData.site), "" + "immunization site Not Present", selenium, ClassName,MethodName);
	

	assertTrue(selenium.isTextPresent(immunizationData.route), "" + " Immunization route Not Present", selenium, ClassName, MethodName);


	assertTrue(selenium.isTextPresent(immunizationData.lotNumber), "" + " Immunization lotNumber Not Present", selenium, ClassName, MethodName);
	
	
	assertTrue(selenium.isTextPresent(immunizationData.series), "" 	+ " Immunization series Not Present", selenium, ClassName,MethodName);
	

	assertTrue(selenium.isTextPresent(immunizationData.seriesof), "" + "immunization seriesof Not Present", selenium, ClassName,MethodName);
	

	assertTrue(selenium.isTextPresent(immunizationData.cpt1), "" + " Immunization cpt1 Not Present", selenium, ClassName,MethodName);
	

	assertTrue(selenium.isTextPresent(immunizationData.cpt2), "" + " Immunization cpt2 Not Present", selenium, ClassName, MethodName);
	
	
		
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
	
	assertTrue(selenium.isTextPresent(date), "" + "Date Not Present",
			selenium, ClassName, MethodName);
	waitForPageLoad(selenium);
	
	
	return true;
	}	
		
}

