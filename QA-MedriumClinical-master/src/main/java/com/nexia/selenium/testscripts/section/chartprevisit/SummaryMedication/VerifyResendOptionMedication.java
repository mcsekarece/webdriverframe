package com.nexia.selenium.testscripts.section.chartprevisit.SummaryMedication;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyResendOptionMedication extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Resend option In Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void ResendOptionMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_044";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyRsendOption(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}

	/**
	 * verifyRsendOption
	 * function to verify Rsend Option in Medication 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @defect 		#7642
	 * @throws      IOException 
	 * @since  	    Dec 20, 2013
	 */
	
	public boolean verifyRsendOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;
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
			assertTrue(click(selenium,lnkMedication),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(deleteMedication(selenium,medicationData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Create Medication//
			//--------------------------------------------------------------------//
			assertTrue(createMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSave),"Could not click the Save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:  Navigate to Patient Meds//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTabMore),"Could not click the more tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the Medication tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Search Created Medication  //
			//--------------------------------------------------------------------//
			if(userAccount.equals(CAAccount)){
				assertTrue(type(selenium,txtMedsSearchTextBox, medicationData.prescribeCa),"Could not type the Canada medication", selenium,ClassName, MethodName);
			}else
			assertTrue(type(selenium,txtMedsSearchTextBox, medicationData.prescribe),"Could not type the US medication", selenium,ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.keyPress(txtMedsSearchTextBox, "\\13");
			
			selectValueFromAjaxList(selenium,showPickList,"Current");
			waitForPageLoad(selenium);
			//----------------------------------------------------------------------//
			//  Step-7: Verify Created Medication  and Move From Current to History//
			//----------------------------------------------------------------------//
			int count=(Integer)selenium.getXpathCount(lblCureentMedsname);
			int counter=2;
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
				if(getText(selenium,lblCureentMedsname).contains(medicationData.prescribe)
						||getText(selenium,lblCureentMedsname).contains(medicationData.prescribeCa)){
					//assertTrue(click(selenium,lnkOption),"Could not click options button", selenium, ClassName, MethodName);
					selenium.focus(lnkOption1);;
					selenium.clickAt(lnkOption1, "");
					if(selenium.isTextPresent("Resend")){
						Assert.fail("REsend Option is getting displayed");
					}
						
					
				}
				else{
					while(count>=counter){
						if(getText(selenium,"//tr["+counter+"]/td/div/span/div").contains(medicationData.prescribe)
								||getText(selenium,"//tr["+counter+"]/td/div/span/div").contains(medicationData.prescribeCa)){
							waitForPageLoad(selenium);
							//assertTrue(click(selenium,"//div[@id='Medications']/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr["+counter+"]/td[2]/div/div"),"Could not click the options button");
							selenium.focus("//div[4]/div["+counter+"]/div[2]/div/a/span");
							selenium.clickAt("//div[4]/div["+counter+"]/div[2]/div/a/span", "");
							if(selenium.isTextPresent("Resend"))
								Assert.fail("REsend Option is getting displayed");
							break;
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
}
