package com.nexia.selenium.testscripts.section.chartprevisit.Allergies;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteAllergy extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for delete Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteAllegy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_025";
		allergyData.fetchChartPreVisitTestData();
		deleteAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	/**
	 * deleteAllergy
	 * function to delete Allergy
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 18, 2012
	 */
	
	public boolean deleteAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//based on defect id '5284' implemented the following 'if' block
			if(!getText(selenium, appointmentFor).equalsIgnoreCase("Any")){
				return false;
			}
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Allergy                                               //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAllergy),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Add Allergy                                               //
			//--------------------------------------------------------------------//
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnCancel), "Could not click on cancel", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSummary), "Could not click on summary link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!getText(selenium, "//div[2]/div/span").equalsIgnoreCase("No allergies added")){
				fail("Allergy deletion Failed");
				returnValue = false;
			}else
				returnValue = true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}
