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

public class ApprovePendingMedicationInQueue extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for approving pending medication in meds queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void approvePendingMedicationFromQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_018";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPendingMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for approving all pending medication for a patient in meds queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void approveAllPendingMedicationFromQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_019";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPendingMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * editPendingMedication
	 * Function to edit pending medication from meds queue
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    Dec 17, 2012
	 */
	public boolean editPendingMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
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
			
//			assertTrue(click(selenium,lnkMore),"Could not click the search button;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
			assertTrue(selenium.isVisible(lnkMedicationTab),"link is not visible",selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the search button;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
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
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
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
			click(selenium,"//body/div[5]/div/div/div/div/div");
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxRxProvider,"Myself");
			click(selenium,"//body/div[5]/div/div/div/div/div");
			waitForPageLoad(selenium);
						
			assertTrue(verifyStoredValues(selenium,prescribeData,userAccount),"The values are not stored properly", selenium, ClassName, MethodName);
		
			int count1=(Integer)selenium.getXpathCount("//div[starts-with(@id,'rxRenewalQueueItem')]");
			int counter1=2;
			
			if(getText(selenium,lblMedsQueue).contains(prescribeData.patientId)){
				assertTrue(click(selenium,lblMedsQueue),"Could not click on the patient medication", selenium, ClassName, MethodName);
			}

			else{
				while(getText(selenium,"xpath=(//div[starts-with(@id,'rxRenewalQueueItem')])").contains(prescribeData.patientId)){
					if(getText(selenium,"xpath=(//div[starts-with(@id,'rxRenewalQueueItem'])["+counter1+"]").contains(prescribeData.patientId)){
						assertTrue(click(selenium,"xpath=(//div[starts-with(@id,'rxRenewalQueueItem'])["+counter1+"]"),"Could not click on the patient medication", selenium, ClassName, MethodName);
						break;
					}
					counter1++;
					if(count1<counter1)
						break;
				}
			}	
			    waitForPageLoad(selenium);
				//assertTrue(click(selenium,"link=Actions"),"Could not click on the approve all button",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				if(selenium.isElementPresent(btnPrint)){
					Assert.fail("The Print button is not found");
				}
				
				assertTrue(verifyApprovedStoredValues(selenium,prescribeData,userAccount),"The approved values are not stored properly", selenium, ClassName, MethodName);
						
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
			date=DateFormat.format(cal.getTime());
			System.out.println(getText(selenium,lblMedsQueue));
		if(account.equals(CAAccount)){
			
			assertTrue(getText(selenium,lblMedsQueue).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.prescribeNameCa.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not click on the approve all button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
		
		}else{
			assertTrue(getText(selenium,lblMedsQueue).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.prescribeName.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not click on the approve all button",selenium, ClassName, MethodName);
			
			
		}
		
		assertTrue(getText(selenium,lblMedsQueue).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.patientId.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not click on the approve all button",selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblMedsQueue).trim().contains("On "+date.trim()),"Could not click on the approve all button",selenium, ClassName, MethodName);
		
		
		return true;
	}	
	public boolean  verifyApprovedStoredValues(Selenium selenium, ChartPreVisitLib prescribeData,String account) throws IOException{
		
		waitForPageLoad(selenium);	
	
		if(account.equals(CAAccount)){
			
			assertTrue(getText(selenium,lblMedsQeueu2).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.prescribeNameCa.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not click on the approve all button",selenium, ClassName, MethodName);
			
					
		
		}else{
			
			assertTrue(getText(selenium,lblMedsQeueu2).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.prescribeName.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not click on the approve all button",selenium, ClassName, MethodName);
			
		}
		
		assertTrue(getText(selenium,lblMedsQeueu2).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.direction.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not click on the approve all button",selenium, ClassName, MethodName);
		
		
		assertTrue(getValue(selenium,txtOfRefill).trim().contains(prescribeData.duration.trim()),"Could not click on the approve all button",selenium, ClassName, MethodName);
		
		return true;
	}

}
