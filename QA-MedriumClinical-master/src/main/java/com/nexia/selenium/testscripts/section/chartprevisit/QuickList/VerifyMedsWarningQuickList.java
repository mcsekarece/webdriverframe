package com.nexia.selenium.testscripts.section.chartprevisit.QuickList;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMedsWarningQuickList extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Meds Warning  quick list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyQuickListIcon(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_059";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyMedsWarningQuickList(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}

	/*************************************************************************************************** 
	 * @purpose        To Verify Created Meds Warning  quick list
	 * @action 		  Verifying created Meds Warning quick list 
	 * @expected       After add theMeds Warning, When click the quick list, It should shows the added Meds medication
	 * @author         Aspire QA
	 * @state          Developing
	 * @defect 		  #3446 	
	 * @useraccount    Both
	 * @since  	      April 03, 2013
	 ***************************************************************************************************/
	public boolean verifyMedsWarningQuickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		try{
			Selenium selenium=null;
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrieve the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ",selenium,ClassName,MethodName);

			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);

			// Add allergy
			ChartPreVisitLib allergyData = new ChartPreVisitLib();
			allergyData.workSheetName = "CreateAllergy";
			allergyData.testCaseId = "TC_CA_001";
			allergyData.fetchChartPreVisitTestData();
			
			assertTrue(selenium.isVisible(lnkAllergy),"Allergy Link Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			if(isElementPresent(selenium,btnWarningQuickList)){
				assertTrue(click(selenium,btnWarningQuickList),"Could not click the QuickList button;More details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				while((Integer) selenium.getXpathCount("//*[contains(@id,'currentItem_')]")>0){
					assertTrue(click(selenium,lnkPrescribeDelete),"Could not delete the QuickList value;More details:"+prescribeData.toString(),selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnWarningQuickList),"Could not click the QuickList button;More details:"+prescribeData.toString(),selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
				}
			}
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				if(!isChecked(selenium,chkQuickList))
					assertTrue(click(selenium,chkQuickList),"Could not click Quicklist checkbox"+prescribeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}

			
			/*assertTrue(click(selenium,btnSave),"Could not click Save button"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);*/

			//--------------------------------------------------------------------//
			//  Step-5: Cancel Medication //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnMedsCancel),"Could not click override button"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-6: Verify Override Value //
			//--------------------------------------------------------------------//
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,btnWarningQuickList),"Could not click the QuickList button;More details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			assertTrue(getText(selenium,lblReason).toLowerCase(new java.util.Locale("en", "Us"))
					.trim().contains(prescribeData.reason.toLowerCase(new java.util.Locale("en", "Us"))
							.trim()),
					"The value not store properly", selenium, ClassName, MethodName);

		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return false;
	}
}