package com.nexia.selenium.testscripts.section.clinicalsettings.MUMeasures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.thoughtworks.selenium.Selenium;



public class VerifyCPOEResult extends AbstractChartPreVisit{
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing CPOE Result For After Deleteing the Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createMedicationForSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_001";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCPOEResult(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	/******************************************************************************************************* 
	* @purpose        To Verify CPOE Result For After Deleteing the Medication
	* @action 		   Verify CPOE Result For After Deleteing the Medication
	* @expected       To Ensure that the  Verify CPOE Result For After Deleteing the Medication works fine 
	* @author         Aspire Qa
	* @state          Developing
	* @defect 		  #7732
	* @useraccount    US
	* @since  	      Dec 18, 2013
	*********************************************************************************************************/
	
	public boolean verifyCPOEResult(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=true;
		String resultList = null;
		String afterCreatedList = null;
		String afterDeletedList = null;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + medicationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, medicationData.userName, medicationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Naviagte to MU Measures//
			//--------------------------------------------------------------------//
			AbstractClinicalSettings muData = new AbstractClinicalSettings();
			ClinicalSettingLib muMData = new ClinicalSettingLib();
			muMData.workSheetName = "MUMeasures";
			muMData.testCaseId = "TC_MU_012";
			muMData.fetchClinicalSettingsTestData();
			
			assertTrue(muData.goToMUMeasures(selenium), "Could not navigate to meaningful use measures",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: verify meaningful use measures						      //
			//--------------------------------------------------------------------//
			assertTrue(muData.verifyMeasure(selenium, muMData), "Could not enter required values",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			resultList = getText(selenium,muData.lblResultList7);
			
			String[] splitStr1 = resultList.split("[(^%,)]");
			String[] SplitStr2 = splitStr1[2].split("\\s");
			int resultlist = Integer.parseInt(SplitStr2[SplitStr2.length-1]);
			System.out.println(resultlist);
			//--------------------------------------------------------------------//
			//  Step-4: Click Nexia Logo//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-5: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Delete Medication //
			//--------------------------------------------------------------------//
			assertTrue(selenium.isVisible(lnkMedication),"Medication Link is Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedication),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteMedication(selenium,medicationData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Create Medication//
			//--------------------------------------------------------------------//
			assertTrue(createMedication(selenium,medicationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to meaningful use measures						      //
			//--------------------------------------------------------------------//
			assertTrue(muData.goToMUMeasures(selenium), "Could not navigate to meaningful use measures",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: verify meaningful use measures						      //
			//--------------------------------------------------------------------//
			assertTrue(muData.verifyMeasure(selenium, muMData), "Could not enter required values",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			afterCreatedList = getText(selenium,muData.lblResultList7);
			String[] splitStr3 = afterCreatedList.split("[(^%,)]");
			String[] SplitStr4 = splitStr3[2].split("\\s");
			int afterCreatList = Integer.parseInt(SplitStr4[SplitStr4.length-1]);
			System.out.println(afterCreatList);
			//--------------------------------------------------------------------//
			//  Step-10: Click Nexia Logo//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-11: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-12: Delete Medication //
			//--------------------------------------------------------------------//
			assertTrue(selenium.isVisible(lnkMedication),"Medication Link is Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedication),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteMedication(selenium,medicationData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on Nexia Logo", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-13: Navigate to meaningful use measures					  //
			//--------------------------------------------------------------------//
			assertTrue(muData.goToMUMeasures(selenium), "Could not navigate to meaningful use measures",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-14: verify meaningful use measures						      //
			//--------------------------------------------------------------------//
			assertTrue(muData.verifyMeasure(selenium, muMData), "Could not enter required values",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			afterDeletedList = getText(selenium,muData.lblResultList7);
			String[] splitStr5 = afterDeletedList.split("[(^%,)]");
			String[] SplitStr6 = splitStr5[2].split("\\s");
			int afterDeleteList = Integer.parseInt(SplitStr6[SplitStr6.length-1]);
			System.out.println(afterDeleteList);
			
			//Verify the count
			if(afterCreatList<=afterDeleteList){
				if(!(resultlist==afterDeleteList)){
					Assert.fail("Details are not displayed properly");
				}else
					returnValue = true;
			}

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
