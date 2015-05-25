package com.nexia.selenium.testscripts.section.chartprevisit.PatientMeds;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMedicationSummary extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for restart a medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_012";
		medicationData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		medicationSummarydetails(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	
	/**
	 * medicationSummarydetails
	 * Function to medication Summary details
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Nov 20, 2012
	 */
	public boolean medicationSummarydetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + medicationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, medicationData.userName, medicationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Delete Medication //
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,lnkMedication),"Could not find the link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkMedication),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteMedication(selenium,medicationData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Create Medication//
			//--------------------------------------------------------------------//
			assertTrue(createMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Medication Queue//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkMore),"Could not click on More  link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the Medication link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify Store value//
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,showPickList,"Current");
		//	click(selenium,"//body/div[5]/div/div/div/div/div");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			int count=(Integer)selenium.getXpathCount(lblCureentMedsname);
			int counter=2;
			if(getText(selenium,lblCureentMedsname).contains(medicationData.prescribeName)
				||getText(selenium,lblCureentMedsname).contains(medicationData.prescribeCa)){
				if(!verifyStoreValueForMedication(selenium,medicationData)){
					returnValue=false;
				}else
					returnValue = true;
			}else{
				while(count>=counter){
					if(getText(selenium,"//tr["+counter+"]/td/div/span/div").contains(medicationData.prescribeName)
							||getText(selenium,"//tr["+counter+"]/td/div/span/div").contains(medicationData.prescribeCa)){
						assertTrue(click(selenium,"//tr["+counter+"]/td/div/span/div/div[4]"),"Could not click the arrow link", selenium, ClassName, MethodName);
						if(!verifyStoreValueForMedication(selenium,medicationData)){
							returnValue=false;
						}else
							returnValue = true;
						//break;
					}
					counter++;
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	return returnValue;
	}
	
	public boolean verifyStoreValueForMedication(Selenium selenium,ChartPreVisitLib medicationData){
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MMMM-dd-yyyy");
		System.out.print("Month is :"+ Calendar.MONTH);
		String uniqueName=DateFormat.format(cal.getTime());
		if(!getText(selenium,lblMedname).toLowerCase(new java.util.Locale("en","Us")).trim().contains(medicationData.prescribeName.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
			
		if(!getText(selenium,lblStart).contains(medicationData.startDate1)){
			return false;
		}
			
		if(!getText(selenium,lblStop).contains(uniqueName)){
			return false;
		}
			
		if(!getText(selenium,lblMedicationDetails).contains(uniqueName)){
			return false;
		}
			
		if(!getText(selenium,lblMedicationDetails).toLowerCase(new java.util.Locale("en","Us")).trim().contains(medicationData.prescribeName.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
		
		if(!getText(selenium,lblMedicationDetails).toLowerCase(new java.util.Locale("en","Us")).trim().contains(medicationData.addby.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}
	return true;
	}
}
