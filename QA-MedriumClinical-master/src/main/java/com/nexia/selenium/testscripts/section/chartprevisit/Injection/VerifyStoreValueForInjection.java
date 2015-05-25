
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

public class VerifyStoreValueForInjection extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Store Value For Injection")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValueForInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_028";
		injectionData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Store Value For Injection")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValueForEditInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_029";
		injectionData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyEditInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Store Value For Injection")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValueForPatientSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_030";
		injectionData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		patientSummary(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}
	/**
	 * verifyInjection
	 * function to verify Injection
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Sep 27, 2012
	 */
	public boolean verifyInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib injectionData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date=null;
		String time=null;
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
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Exit Injection//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkInjection),"Could not click Injections link;More Details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteInjection(selenium),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Create Injection//
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ injectionData.switchRole , "");
			
			assertTrue(createInjection(selenium,injectionData,userAccount,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//assertTrue(click(selenium,btnInjectionSaveAfterAdd),"unable to click the save injection",selenium,ClassName,MethodName);
			//waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Verify Stored Values//
			//--------------------------------------------------------------------//
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
					date=DateFormat.format(cal.getTime());
					int date1=Integer.parseInt(date);
					if(date1<10){
						SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM dd, yyyy");
						date=DateForma1t.format(cal.getTime());
						DateFormat=new SimpleDateFormat("HH");
						time=DateFormat.format(cal.getTime());
					}else{
						SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");
						date=DateFormat2.format(cal.getTime());
						DateFormat=new SimpleDateFormat("HH");
						time=DateFormat.format(cal.getTime());
					}
				}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
				DateFormat=new SimpleDateFormat("HH");
				time=DateFormat.format(cal.getTime());
			}
			waitForPageLoad(selenium);
			if(!verifyStoredValueInSummaryPage(selenium,injectionData,providerName, date,time)){
				Assert.fail("Injection details not saved properly; More Details :"+ injectionData.toString());
				returnValue= false;
			}waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnInjectionEdit),"click action failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyStoredValue(selenium , injectionData,userAccount,providerName)){
				Assert.fail("Injection details not saved properly; More Details :"+ injectionData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValueInSummaryPage(Selenium selenium,ChartPreVisitLib injectionData,String providerName,String date,String time) throws IOException{
	
		
		
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,injectionSummaryArrow),"click Collapse view lbl  failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		assertTrue(selenium.isTextPresent(injectionData.injection),""+"Injection Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
			
		assertTrue(selenium.isTextPresent(injectionData.reaction),""+"Injection Reaction Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selenium.isTextPresent(injectionData.comment),""+"Injection Comment Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//assertTrue(selenium.isTextPresent(injectionData.dosage),""+"Injection Dosage Not Present",selenium, ClassName, MethodName);
		//waitForPageLoad(selenium);		
	
		//assertTrue(selenium.isTextPresent(injectionData.dosageUnit),""+"Injection Dosage Unit Not Present",selenium, ClassName, MethodName);
		//waitForPageLoad(selenium);
		
		assertTrue(selenium.isTextPresent(date),""+"Injection Date Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selenium.isTextPresent(providerName),""+"provider Name Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		 
		assertTrue(selenium.isTextPresent(injectionData.route),""+"Injection Route Name Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//assertTrue(selenium.isTextPresent(injectionData.site),""+"Injection Site Not Present",selenium, ClassName, MethodName);
		//waitForPageLoad(selenium);
		
		assertTrue(selenium.isTextPresent(injectionData.lotNumber),""+"Injection Lot Number Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//assertTrue(selenium.isTextPresent(injectionData.verifyCpt1),""+"injectionData Cpt1 Not Present",selenium, ClassName, MethodName);
		//waitForPageLoad(selenium);

		//assertTrue(selenium.isTextPresent(injectionData.verifyCpt2),""+"injectionData Cpt2 Not Present",selenium, ClassName, MethodName);
		//waitForPageLoad(selenium);
			
		/*assertTrue(verifyTimeStampForProviderPage(selenium, lblInjectionCollapseview, date, time),"Verification failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);*/
		return true;
	}
	
	public boolean verifyStoredValue(Selenium selenium,ChartPreVisitLib injectionData,String account,String providerName){
		waitForPageLoad(selenium);
	
		String date="";
		/*if(!getText(selenium,"css=div.small.paddingTop20 > div.gwt-Label").trim().contains("American Medical Association.".trim())){
			return false;
		}*/
		if (getText(selenium, lnkInjectionShowMoreArrow).equalsIgnoreCase(
				"Show more details")) {
			try {
				assertTrue(click(selenium, lnkInjectionShowMoreArrow),
						"Could not on show more button", selenium, ClassName, MethodName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			date=DateFormat.format(cal.getTime());
			
		}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
			
		}
		
		if(!getValue(selenium,txtadminOn).trim().contains(date.trim())){
			return false;
		}
		if(!getValue(selenium,ajxReaction).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.reaction.trim().toLowerCase(new java.util.Locale("en","Us")))){
		return false;
		}
		/*if(!getValue(selenium,txtcomment).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.comment.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}*/
		if(!getValue(selenium,txtDosage).trim().contains(injectionData.dosage.trim())){
			return false;
		}
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
	/**
	 * verifyEditInjection
	 * function to verify Edit Injection
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 10, 2012
	 */
	
	public boolean verifyEditInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib injectionData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date=null;
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
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Exit Injection//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkInjection),"Could not click Injections link;More Details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteInjection(selenium),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Create Injection//
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ injectionData.switchRole , "");
			
			assertTrue(createInjection(selenium,injectionData,userAccount,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Edit Injection//
			//--------------------------------------------------------------------//
			injectionData.workSheetName = "CreateInjection";
			injectionData.testCaseId = "TC_CI_002";
			injectionData.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,btnInjectionEdit),"Could not click on edit button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//String providerNameTemp= getText(selenium, lnkTopMenu);
			//String providerName= providerNameTemp.replaceAll(", "+ injectionData.switchRole , "");
			
			assertTrue(editInjection(selenium,injectionData,userAccount,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSave),"could not click on save",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkInjection),"Could not click Injections link;More Details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnInjectionEdit),"Could not click on edit",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify Stored Values//
			//--------------------------------------------------------------------//
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
					date=DateFormat.format(cal.getTime());
					int date1=Integer.parseInt(date);
					if(date1<10){
						SimpleDateFormat DateForma1t=new SimpleDateFormat("MMMMMMM d, yyyy");
						date=DateForma1t.format(cal.getTime());
					
					}else{
						SimpleDateFormat DateFormat2=new SimpleDateFormat("MMMMMMM dd, yyyy");
						date=DateFormat2.format(cal.getTime());
						
					}
				}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
				
			}
			
			if(!verifyStoredValue(selenium,injectionData,userAccount,providerName)){
				Assert.fail("Injection details not saved properly; More Details :"+ injectionData.toString());
				returnValue= false;
			}else 
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/**
	 *patientSummary
	 * function to patient Summary
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 10, 2012
	 */
	
	public boolean patientSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib injectionData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date=null;
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
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Exit Injection//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkInjection),"Could not click Injections link;More Details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteInjection(selenium),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Create Injection//
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ injectionData.switchRole , "");
			
			assertTrue(createInjection(selenium,injectionData,userAccount,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
						
			//--------------------------------------------------------------------//
			//  Step-5: verify Stored Value In PatientSummarys//
			//--------------------------------------------------------------------//
			
			
			//assertTrue(click(selenium,btnInjectionEdit),"could not click on edit",selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			if(userAccount.equals(CAAccount)){
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
			if(!verifyStoredValueInPatientSummary(selenium,injectionData,providerName,date)){
				Assert.fail("Injection details not saved properly; More Details :"+ injectionData.toString());
				returnValue= false;
			}else 
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyStoredValueInPatientSummary(Selenium selenium , ChartPreVisitLib injectionData,String providerName, String date) throws IOException{
		
		waitForPageLoad(selenium);
		
		waitForPageLoad(selenium);
		click(selenium,lblInjectionCollapseview);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(injectionData.injection),""+"Injection Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);		
			
		assertTrue(selenium.isTextPresent(injectionData.reaction),""+"Injection Reaction Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
    	assertTrue(selenium.isTextPresent(injectionData.comment),""+"Injection Comment Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	
		assertTrue(selenium.isTextPresent(injectionData.dosage),""+"Injection Dosage Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(injectionData.dosageUnit.trim().toLowerCase()),""+"Injection Dosage Unit Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selenium.isTextPresent(providerName),""+"provider Name Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selenium.isTextPresent(injectionData.route),""+"Injection Route Name Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//assertTrue(selenium.isTextPresent(injectionData.site),""+"Injection Site Not Present",selenium, ClassName, MethodName);
		//waitForPageLoad(selenium);
		
		assertTrue(selenium.isTextPresent(injectionData.lotNumber),""+"Injection Lot Number Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selenium.isTextPresent(date),""+"Injection Date Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

					
			
	
	return true;
	}
}
