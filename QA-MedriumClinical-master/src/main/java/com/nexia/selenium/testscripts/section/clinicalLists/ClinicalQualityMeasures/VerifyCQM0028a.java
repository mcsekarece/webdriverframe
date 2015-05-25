package com.nexia.selenium.testscripts.section.clinicalLists.ClinicalQualityMeasures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalList.AbstractClinicalList;
import com.nexia.selenium.genericlibrary.clinicalList.ClinicalListLib;

import com.thoughtworks.selenium.Selenium;

public class VerifyCQM0028a extends AbstractClinicalList{
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForAdultWeightScreening(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ClinicalListLib cqmData = new ClinicalListLib();
		cqmData.workSheetName = "CQM";
		cqmData.testCaseId = "TC_CQM_001";
		cqmData.fetchClinicalListTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, cqmData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Measure
	* @action 		  verifying Measure
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    SingleThreadUS
	* @since  	      Jan 07, 2012
	***************************************************************************************************/
	public boolean verifyMeasure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalListLib cqmData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + cqmData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, cqmData.userName, cqmData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnErrorClose))
		       	click(selenium,btnErrorClose);
		    
			//--------------------------------------------------------------------//
			//  Step-2: Go to Meaningful measures								  //
			//--------------------------------------------------------------------//
			assertTrue(goToClinicalQualityMeasures(selenium), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Edit CQM Measures							  //
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium, ajxProvider, cqmData.provider);
			assertTrue(editMeasure(selenium,cqmData), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: verify meaningful use measures						      //
			//--------------------------------------------------------------------//
			assertTrue(verifyMeasure(selenium, cqmData), "Could not enter required values", selenium, ClassName, MethodName);			
			int numerator;
			int denominator;
			String str1 = getText(selenium, lblMetricResultFor0028a);
			if(!str1.equals("(No Results Found)")){
			waitForPageLoad(selenium);
			String[] splitStr1 = str1.split("[(^)]");
			waitForPageLoad(selenium);
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			waitForPageLoad(selenium);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			numerator=Integer.parseInt(SplitStr2[0]);
			denominator=Integer.parseInt((SplitStr2[3]));
			}
			else {
				numerator=0;
				denominator=0;
			}
			
			//--------------------------------------------------------------------//
			// step-5: Create a new patient                                       // 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkQuickActions),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkRegNewPatient),"Could not click the link to register a patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createNewPatientForCqm(selenium,cqmData),"Could not create a new patient", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkPatientOptionsLink),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnPatientChart),"Could not click the link view patient chart", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(goToBeginEncounter(selenium),"Could not Begin encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Sign the first Encounter//
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,ajxProvider1,cqmData.provider);
			assertTrue(enterDate(selenium,txtEncounterDate,cqmData.date),"Could not enter encounter date", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSign),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Sign another Encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not Begin encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxProvider1,cqmData.provider);
			assertTrue(enterDate(selenium,txtEncounterDate,cqmData.date),"Could not enter encounter date", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSign),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// step-9: Create a new patient                                       // 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkQuickActions),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkRegNewPatient),"Could not click the link to register a patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createNewPatientForCqm(selenium,cqmData),"Could not create a new patient", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-10: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkPatientOptionsLink),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnPatientChart),"Could not click the link view patient chart", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(goToBeginEncounter(selenium),"Could not Begin encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxProvider1,cqmData.provider);
			assertTrue(enterDate(selenium,txtEncounterDate,cqmData.date),"Could not enter encounter date", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-11: Add Social History//
			//--------------------------------------------------------------------//
			assertTrue(createSocialHistoryCQM(selenium,cqmData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSign),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-12: Sign another Encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not Begin encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxProvider1,cqmData.provider);
			assertTrue(enterDate(selenium,txtEncounterDate,cqmData.date),"Could not enter encounter date", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSign),"Could not click the button;More Details:"+cqmData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(goToClinicalQualityMeasures(selenium), "Could not navigate to meaningful use measures", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-13: verify meaningful use measures						      //
			//--------------------------------------------------------------------//
			assertTrue(verifyMeasure(selenium, cqmData), "Could not enter required values", selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);
			String str2=getText(selenium,lblMetricResultFor0028a);
			waitForPageLoad(selenium);
			String[] splitStr3 = str2.split("[(^)]");
			waitForPageLoad(selenium);
			String[] SplitStr4 = splitStr3[1].split("\\s",4);
			waitForPageLoad(selenium);
			System.out.println(SplitStr4[0]);
			System.out.println(SplitStr4[3]);
			int updatedNumerator=Integer.parseInt(SplitStr4[0]);
			int updatedDenominator=Integer.parseInt((SplitStr4[3]));
			if(updatedNumerator-numerator==1){
				if(updatedDenominator>denominator)
					returnValue=true;
				else
					Assert.fail("CQM Verification Failed");
			}
			else{
				Assert.fail("CQM Verification Failed");
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
