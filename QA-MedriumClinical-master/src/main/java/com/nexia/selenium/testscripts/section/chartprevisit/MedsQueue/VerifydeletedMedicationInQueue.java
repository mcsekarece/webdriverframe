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

public class VerifydeletedMedicationInQueue extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying deleted pending medication not in meds queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createPrescribeMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_107";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	    verifyDeleteMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * verifyDeleteMedication
	 * Function to verify pending medication in meds queue
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    Dec 17, 2012
	 */
	public boolean verifyDeleteMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
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
			assertTrue(goToPrescribe(selenium),"Navigate to prescribe medication", selenium, ClassName, MethodName);
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
			
			
			//--------------------------------------------------------------------//
			//  Step-6: Serach Pending Medication in meds Queue//
			//--------------------------------------------------------------------//
			//Click on Nexia a Logo 
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Clcik on Rx Renewal
			assertTrue(click(selenium,lnkRxRenewal),"Could not click the Meds queue button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Search Pending medication In Queue
			assertTrue(type(selenium,txtRxPatientSearch,prescribeData.patientId),"Could not enter the search text;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.keyPress(txtRxPatientSearch, "\\13");
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxRxShow,prescribeData.show);
			waitForPageLoad(selenium);
			

			selectValueFromAjaxList(selenium,ajxRxProvider,prescribeData.provider);
			waitForPageLoad(selenium);
			   waitForElement(selenium, lblRxqitem, WAIT_TIME*5);    
			//--------------------------------------------------------------------//
			//  Step-7: Verify Store Value in meds Queue//
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValues(selenium,prescribeData),"The values are not stored properly in queue", selenium, ClassName, MethodName);
							
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			for(int i=0;i<3;i++){
			selenium.focus(lblMedsQueue1);
			selenium.clickAt(lblMedsQueue1, "");
			selenium.fireEvent(lblMedsQueue1,"click");
			}
			//assertTrue(click(selenium,lblMedsQueue1),"Could not click the patient medication button;More Deatils:"+prescribeData.toString());
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8: Delete All Pending Medication //
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,ajxRxShow, prescribeData.show);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnDeleteBlue),"Clcick delete link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtDeleteReaseon , prescribeData.reasonForDelete), "Could not type reason for deletion", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnContinue),"Could not click Delete button;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Serach Deleted Medication in meds Queue						//
			//--------------------------------------------------------------------//
			//Click on Nexia a Logo 
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the back button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Clcik on Rx Renewal
			assertTrue(click(selenium,lnkRxRenewal),"Could not click the Meds queue button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//Deleted medication In Queue
			assertTrue(type(selenium,txtRxPatientSearch,prescribeData.patientId),"Could not enter the search text;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.keyPress(txtRxPatientSearch, "\\13");
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxRxShow,prescribeData.show);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxRxProvider,prescribeData.provider);
			waitForPageLoad(selenium);

			assertTrue(!getText(selenium,lblMedsQueue).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.patientId.trim().toLowerCase(new java.util.Locale("en","US"))),"Verify Delete Medication failed", selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib prescribeData) throws IOException{
		String  date = null;  
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MMMMMMMM dd, yyyy");
		date=DateFormat.format(cal.getTime());
			assertTrue(((getText(selenium,lblMedsQueue).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.prescribeName.trim().toLowerCase(new java.util.Locale("en","US"))))
			|| (getText(selenium,lblMedsQueue).toLowerCase(new java.util.Locale("en","US")).trim().contains(prescribeData.prescribeNameCa.trim().toLowerCase(new java.util.Locale("en","US"))))),"Verification failed", selenium, ClassName, MethodName);

	assertTrue(isTextPresent(selenium,prescribeData.patientId),"Verification failed", selenium, ClassName, MethodName);
		
	assertTrue(isTextPresent(selenium,("On "+date.trim())),"Verification failed", selenium, ClassName, MethodName);
	
		return true;
	}	
}
