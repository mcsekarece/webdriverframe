package com.nexia.selenium.testscripts.section.chartprevisit.QuickList;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchProblemListQuickList extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the normal  Medical condition and quick list Medical condition is displayed in the Medical condition list ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchProblemListQuickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPL_019";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		quickListCheck(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	
	/****************************************************************************************************************************************** 
	* @purpose        Test for Verify the normal  Medical condition and quick list Medical condition is displayed in the Medical condition list 
	* @action 		  Verifying the normal  Medical condition and quick list Medical condition is displayed in the Medical condition list 
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Apr 25, 2013
	***************************************************************************************************/
	public boolean quickListCheck(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + proData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, proData.userName, proData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete All existing Problem List//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkProblemList),"Could not click the Immunization link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllProblemList(selenium, proData),"Delte porblem list failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnProblemListQuickList),"Could not click the QuickList button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			while((Integer) selenium.getXpathCount(lblMedicalConditionResults)>0){
				assertTrue(click(selenium,lnkPrescribeDelete1),"Could not delete the QuickList value;More details:"+proData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnProblemListQuickList),"Could not click the QuickList button;More details:"+proData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Add Procedure//
			//--------------------------------------------------------------------//
			
			assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnCancel),"Could not click cancel;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkProblemList),"Could not click the Immunization link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Add Procedure with quick list feature//
			//--------------------------------------------------------------------//
			proData.workSheetName = "CreateProblemList";
			proData.testCaseId = "TC_QL_003";
			proData.fetchChartPreVisitTestData();
			
			assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
             
			//--------------------------------------------------------------------//
			//  Step-6: Verify the presence of normal and quick list occurrence//
			//--------------------------------------------------------------------//
			selenium.focus(txtMedicatl);
			selenium.type(txtMedicatl,proData.medicalCondition1);
			selenium.fireEvent(txtMedicatl,"keydown");
			selenium.fireEvent(txtMedicatl,"keypress");                           
			selenium.fireEvent(txtMedicatl,"keyup");
			waitForPageLoad(selenium);
			
			
			if(getText(selenium,lblQuickValue).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.medicalCondition1.trim().toLowerCase(new java.util.Locale("en","US"))) && (isElementPresent(selenium,"css=img.gwt-Image.marginRight5"))){
					
				if(getText(selenium,lblQuickListResult2).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.medicalCondition1.trim().toLowerCase(new java.util.Locale("en","US")))){
					 if(!isElementPresent(selenium,lblQuickListResult2Img)){
						 return false;
					 }
				}
				 
			}
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify quick list datas only displayed//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnProblemListQuickList),"Could not click the QuickList button;More details:"+proData.toString(),selenium,ClassName,MethodName);

			
			if(getText(selenium,lblQuickValue).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.medicalCondition1.trim().toLowerCase(new java.util.Locale("en","US")))){
				 if(isElementPresent(selenium,imgStarIcon)){
					 returnValue=true;
				 }
			}
								
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + proData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
	
}
