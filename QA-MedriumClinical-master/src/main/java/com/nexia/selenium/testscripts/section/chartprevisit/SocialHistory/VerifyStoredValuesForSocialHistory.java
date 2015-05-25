package com.nexia.selenium.testscripts.section.chartprevisit.SocialHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStoredValuesForSocialHistory extends AbstractChartPreVisit {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Value For Social History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValueForSocialHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib socialData = new ChartPreVisitLib();
		socialData.workSheetName = "CreateSocialHistory";
		socialData.testCaseId = "TC_CSH_029";
		socialData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Value for Edit Social History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValueForEditSocialHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib socialData = new ChartPreVisitLib();
		socialData.workSheetName = "CreateSocialHistory";
		socialData.testCaseId = "TC_CSH_030";
		socialData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Value for Add Social History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValueForSocialHistoryWithOther(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib socialData = new ChartPreVisitLib();
		socialData.workSheetName = "CreateSocialHistory";
		socialData.testCaseId = "TC_CSH_010";
		socialData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addSocialHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, socialData);
	}
	/**
	 * addSocialHistory
	 * function to add SocialHistory
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 23, 2012
	 */

	public boolean addSocialHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib socialData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + socialData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, socialData.userName, socialData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,socialData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Social History //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Social History Entries //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllSocialHistory(selenium,socialData),"Deletion failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Social History//
			//--------------------------------------------------------------------//
			
			assertTrue(createSocialHistory(selenium,socialData),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnProEdit),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyStoredValues(selenium,socialData)){
				Assert.fail("Social History details not saved properly in contacts page :"+ socialData.toString());
				returnValue=false;
			}else
				return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib proData) throws IOException{
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkSocialShowMore),"Could not on show more button",selenium, ClassName, MethodName);
		if(!getValue(selenium,ajxType).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(proData.type.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		/*if(!getValue(selenium,ajxStatus).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.status.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		if(proData.testCaseId.equals("TC_CSH_010"))
		{
			
			if(!getValue(selenium,ajxOtherType).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.other.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		else
		{
			if(!getValue(selenium,txtSocialQuickList).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.item.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			
			if(!getValue(selenium,txtDetailsNumBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.detailsNum.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			
			if(!getValue(selenium,txtDetailsSmallBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.detailsNum.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxPeriod).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.period.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,txtYear).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.year.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,txtStartAge).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.startAge.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxStopped).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.historyType.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,ajxLifeStage).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.lifeStage.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			if(!getValue(selenium,txtcomment).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.comment.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		return true;
	}	
	/**
	 * editSocialHistory
	 * function to edit SocialHistory
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 23, 2012
	 */

	public boolean editSocialHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib socialData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + socialData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, socialData.userName, socialData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,socialData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Social History //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkSocialHistory),"Could not click the Social History link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Social History Entries //
			//--------------------------------------------------------------------//
			waitForElement(selenium,btnDeleteSocial, WAIT_TIME);
			while((Integer) selenium.getXpathCount(btnDeleteSocial) > 0){
				int proCount=(Integer) selenium.getXpathCount(btnDeleteSocial);
				assertTrue(click(selenium,lnkSocDelete),"Could not clickon delete link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtdeleteReason,"NoReason"),"Could not enter the reason ;More Details:"+socialData.toString(),selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnDeleteReason),"Could not click on delete reason",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(proCount == (Integer) selenium.getXpathCount(btnDeleteSocial)){
					Assert.fail("Could not delete the entry");
					break;
				}
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Social History//
			//--------------------------------------------------------------------//
			
			assertTrue(createSocialHistory(selenium,socialData),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Edit Social History//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnProEdit),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			socialData.workSheetName = "CreateSocialHistory";
			socialData.testCaseId = "TC_CSH_003";
			socialData.fetchChartPreVisitTestData();
			assertTrue(createSocialHistory(selenium,socialData),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnProEdit),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifyStoredValues(selenium,socialData)){
				Assert.fail("Social History details not saved properly in contacts page :"+ socialData.toString());
				returnValue=false;
			}else
				return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
	