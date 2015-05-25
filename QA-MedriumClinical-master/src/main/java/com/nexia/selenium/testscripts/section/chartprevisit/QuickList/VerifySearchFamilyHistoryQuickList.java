package com.nexia.selenium.testscripts.section.chartprevisit.QuickList;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchFamilyHistoryQuickList extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the normal  Medical condition and quick list Medical condition is displayed in the Medical condition list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchFamilyHistoryQuickList(final String seleniumHost, final int seleniumPort,final String browser, final String webSite, String userAccount) throws Exception {
		ChartPreVisitLib QuicklstData = new ChartPreVisitLib();
		QuicklstData.workSheetName = "CreateFamilyHistory";
		QuicklstData.testCaseId = "TC_CFM_008";
		QuicklstData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyQuickListFamilyHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, QuicklstData);
	}
	
	/****************************************************************************************************************************************** 
	* @purpose        Test for Verify the normal  Medical condition and quick list Medical condition is displayed in the Medical condition list 
	* @action 		  Verifying the normal  Medical condition and quick list Medical condition is displayed in the Medical condition list 
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Apr 25, 2013
	*******************************************************************************************************************************************/
	public boolean verifyQuickListFamilyHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib QuicklstData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + QuicklstData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, QuicklstData.userName, QuicklstData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,QuicklstData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete All existing normal and quick list Family history//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the Family History link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteFamilyHistory(selenium,QuicklstData ),"Deletion Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnFamilyQuickList),"Could not click the QuickList button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			while((Integer) selenium.getXpathCount(lblMedicalConditionResults)>0){
				assertTrue(click(selenium,lnkPrescribeDelete1),"Could not delete the QuickList value;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnFamilyQuickList),"Could not click the QuickList button;More details:"+QuicklstData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: add Family History 						  //
			//--------------------------------------------------------------------//
			assertTrue(createFamilyHistory(selenium,QuicklstData),"FamilyHistory creation failed",selenium,ClassName,MethodName);			
			//assertTrue((selenium,createFamilyHistory),"Save Immunization to Quick List failed");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: add Family History with quick list feature				//
			//--------------------------------------------------------------------//
			ChartPreVisitLib QuicklstData1 = new ChartPreVisitLib();
			QuicklstData1.workSheetName = "CreateFamilyHistory";
			QuicklstData1.testCaseId = "TC_CFM_010";
			QuicklstData1.fetchChartPreVisitTestData();
			
			assertTrue(createFamilyHistoryQuickList(selenium,QuicklstData1),"FamilyHistory creation failed",selenium,ClassName,MethodName);			
			//assertTrue((selenium,createFamilyHistory),"Save Immunization to Quick List failed");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify the presence of normal and quick list occurrence//
			//--------------------------------------------------------------------//
			selenium.focus("familyHistoryQuicklist");
			selenium.type("familyHistoryQuicklist",QuicklstData1.medical);
			selenium.fireEvent("familyHistoryQuicklist","keydown");
			selenium.fireEvent("familyHistoryQuicklist","keypress");                           
			selenium.fireEvent("familyHistoryQuicklist","keyup");
			waitForPageLoad(selenium);
			
			
			if(getText(selenium,lblQuickValue).toLowerCase(new java.util.Locale("en","US")).trim().contains(QuicklstData1.medical.trim().toLowerCase(new java.util.Locale("en","US"))) && (isElementPresent(selenium,"css=img.gwt-Image.marginRight5"))){
					
				if(getText(selenium,lblQuickListResult2).toLowerCase(new java.util.Locale("en","US")).trim().contains(QuicklstData.medical.trim().toLowerCase(new java.util.Locale("en","US")))){
					 if(!isElementPresent(selenium,lblQuickListResult2Img)){
						 return false;
					 }
				}
				 
			}
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify quick list datas only displayed//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnFamilyQuickList),"Could not click the QuickList button;More details:"+QuicklstData1.toString(),selenium,ClassName,MethodName);

			
			if(getText(selenium,lblQuickValue).toLowerCase(new java.util.Locale("en","US")).trim().contains(QuicklstData1.medical.trim().toLowerCase(new java.util.Locale("en","US")))){
				 if(isElementPresent(selenium,imgStarIcon)){
					 returnValue=true;
				 }
			}
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + QuicklstData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}

}
