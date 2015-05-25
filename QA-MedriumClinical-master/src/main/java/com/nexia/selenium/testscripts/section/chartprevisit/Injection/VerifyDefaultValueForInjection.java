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

public class VerifyDefaultValueForInjection extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "function to verify Default Store Values")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addInjectionWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_021";
		injectionData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDefaultStoreValues(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}
	/**
	 * verifyDefaultStoreValues
	 * function to verify Default Store Values
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  		Nov 06, 2012
	 */

	public boolean verifyDefaultStoreValues(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib injectionData) throws IOException{
		boolean returnValue=true;
		Selenium selenium=null;
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
			//  Step-3: Delete Immunization//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkInjection),"Could not click Injections link;More Details:"+injectionData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteInjection(selenium),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkInjectionShowMore),"Could not click the link;More Details:"+injectionData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Default Values//
			//--------------------------------------------------------------------//
			if(!verifyDefaultStoredValue(selenium,injectionData,userAccount)){
				Assert.fail("Defalut values are not present properly; More Details :"+ injectionData.toString());
			}else 
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public boolean verifyDefaultStoredValue(Selenium selenium,ChartPreVisitLib injectionData,String account){
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
		if(!getValue(selenium, txtadminOn).trim().equalsIgnoreCase(date)){
			return false;
		}
		
		if(!getValue(selenium,txtQuickinjection).trim().equals("")){
			return false;
		}
		if(!getValue(selenium,txtLotNo).trim().equals("")){
			return false;
		}
		if(!getValue(selenium,"xpath=(//input[@type='text'])[9]").trim().equals("")){
			return false;
		}
		if(!getValue(selenium,txtDosage).trim().equals("")){
		return false;
		}
		if(!getValue(selenium,txtexpiryDate).trim().equals("")){
			return false;
		}
		if(!getValue(selenium,site).trim().equals("")){
			return false;
		}
		//if(!getValue(selenium,ajxRoute).trim().equals("")){
			//return false;
		//}
		if(!getText(selenium,vfyUserName).trim().contains(getValue(selenium,ajxAdminBy).trim())){
			return false;
		}
		if(!getValue(selenium,ajxCptCode1).trim().equals("")){
			return false;
		}
		if(!getValue(selenium,ajxCptCode2).trim().equals("")){
			return false;
		}
		if(!getValue(selenium,ajxReaction).trim().equals("")){
			return false;
		}
		if(!getValue(selenium,txtcomment).trim().equals("")){
			return false;
		}
		return true;
	}
}
