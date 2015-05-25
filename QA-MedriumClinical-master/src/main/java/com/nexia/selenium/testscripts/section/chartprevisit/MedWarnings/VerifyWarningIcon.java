package com.nexia.selenium.testscripts.section.chartprevisit.MedWarnings;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyWarningIcon extends AbstractChartPreVisit{
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWarningIcon(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_016";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyWarningIcon(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * verifyWarningIcon
	 * Function to verify Warning Icon
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 13, 2012
	 */
	public boolean verifyWarningIcon(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue = false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,prescribeData.switchRole),"Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Delete existing pending medication//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the medication tab;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllPendingMedication(selenium, prescribeData), "Pending medication deleteion failed", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-5: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnEdit),"Edit button is not available", selenium, ClassName, MethodName);
			
			
			assertTrue(click(selenium, btnAddToPending), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			int count=(Integer)selenium.getXpathCount(lblCureentMedsname);
			int counter=2;
			
			if(getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeNameCa)
					|| getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeName)){
				assertTrue(isElementPresent(selenium, lblWarning1),"", selenium, ClassName, MethodName);
				selenium.mouseOver(lblWarning1);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium, "viewFullInteraction"),"", selenium, ClassName, MethodName);
				returnValue = true;
			}
			else{
				while(count>=counter){
					if(getText(selenium,"//tr["+counter+"]/td/div/span/div").contains(prescribeData.prescribeNameCa)
							|| getText(selenium,"//tr["+counter+"]/td/div/span/div").contains(prescribeData.prescribeName)){
						assertTrue(isElementPresent(selenium, "//tr["+counter+"]/td/div/span/div/div/div"),"", selenium, ClassName, MethodName);
						selenium.mouseOver("//tr["+counter+"]/td/div/span/div/div/div");
						waitForPageLoad(selenium);
						assertTrue(isElementPresent(selenium, lblWarning2),"", selenium, ClassName, MethodName);
						returnValue = true;
						break;
						}
					counter++;
					}
				}
			
			
			assertTrue(!isElementPresent(selenium,btnSave),"Override button present", selenium, ClassName, MethodName);
			System.out.println(getText(selenium,lblWarningReason1));
			assertTrue(getText(selenium,lblWarningReason1).contains(prescribeData.reason),"data is not matched", selenium, ClassName, MethodName);
			assertTrue(getText(selenium,lblWarning5).contains(prescribeData.interactionWarning),"Interaction not present in the warning", selenium, ClassName, MethodName);
			
			String str = getText(selenium,"topMenuHeader");
			String user= str.replaceAll(", FULL","");
		
			assertTrue(getText(selenium,lblUser).contains(user),"Data is not matched", selenium, ClassName, MethodName);
				
			/*if(isElementPresent(selenium,btnCancel))
				returnValue=true;
			else
				Assert.fail("Override button present");
			return returnValue;*/
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
}
