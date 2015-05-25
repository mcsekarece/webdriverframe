package com.nexia.selenium.testscripts.section.chartprevisit.ProblemList;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultValueForProblemList extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "function to verify Default Store Values")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProblemListWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPL_028";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDefaultStoreValues(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	/**
	 * verifyDefaultStoreValues
	 * function to verify Default Store Values
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	  * @since  	Nov 07, 2012
	 */

	public boolean verifyDefaultStoreValues(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws IOException{
		boolean returnValue=true;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + proData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, proData.userName, proData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			AbstractClinicalSettings clinicalSettings= new AbstractClinicalSettings();
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSettings),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkClinicalSetting),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,clinicalSettings.lnkPracticePref),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String CodSys=selenium.getText(clinicalSettings.lblCodingSystem);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete All existing Problem List//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllProblemList(selenium, proData),"Deletion faied",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium, lnkProblemListShowMore),"Could not click on link show more",selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkProblemListShowMore),"Could not click the link;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Default Values//
			//--------------------------------------------------------------------//
			if(!verifyDefaultStoredValue(selenium,proData,CodSys)){
				Assert.fail("Defalut values are not present properly; More Details :"+ proData.toString());
				returnValue= false;
			}else 
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public boolean verifyDefaultStoredValue(Selenium selenium,ChartPreVisitLib allergyData, String CodSys){
		if(!getValue(selenium, txtMedicatl).equals("")){
			return false;
		}
		if(!getValue(selenium,txtOnset).equals("")){
			return false;
		}
		if(!getValue(selenium,ajxItem).equals("")){
			return false;
		}
		if(!getValue(selenium,ajxlifeStage).trim().equals("")){
			return false;
		}
		if(!getValue(selenium,txtResolvedDate).trim().equals("")){
			return false;
		}
		if(!getValue(selenium,ajxCodeingSystem).trim().equals(CodSys)){
			return false;
		}
		
		if(!getValue(selenium,ajxdiagnosis).trim().equals("")){
			return false;
		}
		if(!getValue(selenium,txtcomment).equals("")){
			return false;
		}
		return true;
	}
}
