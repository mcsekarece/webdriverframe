
package com.nexia.selenium.testscripts.section.chartprevisit.SocialHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultValueForSocialHistory extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "function to verify Default Store Values")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createSocialHistoryWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib socialData = new ChartPreVisitLib();
		socialData.workSheetName = "CreateSocialHistory";
		socialData.testCaseId = "TC_CSH_019";
		socialData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDefaultStoreValues(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	/**
	 * verifyDefaultStoreValues
	 * function to verify Default Store Values
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  		Nov 07, 2012
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
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete All existing Problem List//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllSocialHistory(selenium,proData),"Deletion failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
					
			//--------------------------------------------------------------------//
			//  Step-5: Verify Default Values//
			//--------------------------------------------------------------------//
			if(!verifyDefaultStoredValue(selenium,proData)){
				Assert.fail("Defalut values are not present properly; More Details :"+ proData.toString());
				returnValue= false;
			}else 
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public boolean verifyDefaultStoredValue(Selenium selenium,ChartPreVisitLib proData) throws IOException{
		
		assertTrue(click(selenium,lnkInjectionShowMore),"Could not on show more button",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(!getValue(selenium, ajxType).equals("")){
			return false;
		}
		
		/*if(!getValue(selenium,ajxStatus).equals("")){
			return false;
		}*/
		if(!getValue(selenium,txtSocialQuickList).equals("")){
			return false;
		}
		
		if(!getValue(selenium,txtdetailsBox).trim().equals("")){
			return false;
		}
		
		if(!getValue(selenium,txtYear).trim().equals("")){
			return false;
		}
		if(!getValue(selenium,txtStartAge).trim().equals("")){
			return false;
		}
		if(!getValue(selenium,ajxStopped).equals("")){
			return false;
		}
		if(!getValue(selenium,ajxLifeStage).equals("")){
			return false;
		}
		if(!getValue(selenium,txtcomment).equals("")){
			return false;
		}
		
		/*if(!getValue(selenium,"answer1Moreradio").equals("off")){
			return false;
		}
		if(!getValue(selenium,"answer1Lessradio").equals("off")){
			return false;
		}
		if(!getValue(selenium,"answer2Yesradio").equals("off")){
			return false;
		}
		if(!getValue(selenium,"answer2Noradio").equals("off")){
			return false;
		}
		if(!getValue(selenium,"answer3Yesradio").equals("off")){
			return false;
		}
		if(!getValue(selenium,"answer3Noradio").equals("off")){
			return false;
		}
		if(!getValue(selenium,"answer4Yesradio").equals("off")){
			return false;
		}
		if(!getValue(selenium,"answer4Noradio").equals("off")){
			return false;
		}*/
		
		
		
		return true;
	}
}
