package com.nexia.selenium.testscripts.section.chartprevisit.MedsQueue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyValueInQueueEqualsChart extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying pending medication in meds queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPrescribeMedicationWithFreeForm(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_034";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    verifyPendingMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * verifyPendingMedication
	 * Function to verify pending medication in meds queue
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 18, 2012
	 */
	public boolean verifyPendingMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,prescribeData.switchRole), "could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			assertTrue(deleteAllPendingMedication(selenium,prescribeData),"Could not delete the pending medications", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescribeData.provider = pName;
			
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.patientId),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-5: Add to Pending Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddToPending),"Could not click the Add to Pending button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the back button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkRxRenewal),"Could not click the Meds queue button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtRxPatientSearch,prescribeData.patientId),"Could not enter the search text;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.keyPress(txtRxPatientSearch, "\\13");
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxRxShow,prescribeData.show);
			waitForPageLoad(selenium);
		/*	click(selenium,"//div[5]/div/div/div/div/div");*/
			selectValueFromAjaxList(selenium,ajxRxProvider,"Myself");
			waitForPageLoad(selenium);
			/*click(selenium,"//div[5]/div/div/div/div/div");*/
			waitForPageLoad(selenium);
			
			assertTrue(verifyStoredValues(selenium,prescribeData,userAccount),"The values are not stored properly in queue", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			String resultList1=getText(selenium,medicationQueue);
			String[] splits = resultList1.split(" ");
			int metricResult = Integer.parseInt(splits[0]);
		
			for(int count=1;count<=metricResult;count++){
				if(getText(selenium, "xpath=(//div[starts-with(@id,'rxRenewalQueueItem')])["+count+"]").contains(prescribeData.prescribeCa)
						||getText(selenium, "xpath=(//div[starts-with(@id,'rxRenewalQueueItem')])["+count+"]").contains(prescribeData.prescribeName)){
					assertTrue(click(selenium,"xpath=(//div[starts-with(@id,'rxRenewalQueueItem')])["+count+"]"),"Could not click on the created medication in Meds queue button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
					break;
					}
				}
			
			
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			
			assertTrue(verifyStoredValuesInPendingPrescriptions(selenium,prescribeData,userAccount),"The Edit values are not stored properly in queue", selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib prescribeData,String account) throws IOException{
		waitForPageLoad(selenium);
		String date = null;  
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MMMMMMMM dd, yyyy");
	    date =DateFormat.format(cal.getTime());
		System.out.println(date);
		if(account.equals(CAAccount)){
			assertTrue(getText(selenium,lblMedsQueue4).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.prescribeCa.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
		}else{
			assertTrue(getText(selenium,lblMedsQueue4).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.prescribeName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
					}
		System.out.println(getText(selenium,lblMedsQueue4).toLowerCase(new java.util.Locale("en","US")));
		System.out.println(prescribeData.patientName.trim().toLowerCase(new java.util.Locale("en","US")));
		assertTrue(getText(selenium,lblMedsQueue4).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.patientId.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
		assertTrue(getText(selenium,lblMedsQueue4).trim().contains(date.trim()),"Couldn't get the value", selenium, ClassName, MethodName);
		return true;
	}	
	public boolean verifyStoredValuesInPendingPrescriptions(Selenium selenium, ChartPreVisitLib prescribeData,String account) throws IOException{
		waitForPageLoad(selenium);	
		waitForPageLoad(selenium);	
		if(account.equals(CAAccount)){
			
			assertTrue(getText(selenium,lblMedsQueuePres).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.prescribeCa.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not enter the search text;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			
		}else{
			
			assertTrue(getText(selenium,lblMedsQueuePres).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.prescribeName.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not enter the search text;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
		}
		
		
		assertTrue(isElementPresent(selenium,"sign"),"Could not enter the search text;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
		
		
		return true;
	}	
} 