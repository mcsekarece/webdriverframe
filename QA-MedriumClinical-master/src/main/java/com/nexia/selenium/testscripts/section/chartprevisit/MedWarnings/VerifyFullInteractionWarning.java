package com.nexia.selenium.testscripts.section.chartprevisit.MedWarnings;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyFullInteractionWarning extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWarningDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_016";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyFullInteractionWarning(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/*************************************************************************************************** 
	* @purpose        To verify Warning Message by Full Interaction
	* @action 		  verifying Warning Meassage  after clicking the Full Interaction Warning button
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Closed
	* #defect         #2008
	* @useraccount    Both
	* @since  	      April 05, 2013
	***************************************************************************************************/
	
	public boolean verifyFullInteractionWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws IOException{
		
		Selenium selenium =null;
		boolean returnValue=true;
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
			//  Step-3: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create allgery//
			//--------------------------------------------------------------------//
			prescribeData.workSheetName = "CreateAllergy";
			prescribeData.testCaseId = "TC_CA_001";
			prescribeData.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllAllergy(selenium,prescribeData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createAllergy(selenium,prescribeData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnCancel),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5:Delete all Pending Medication in Medication tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkMore),"Could not click the Medication Tab;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the Medication Tab;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllPendingMedication(selenium, prescribeData), "Pending medication deleteion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,prescribeData),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7:Navigate to EnCounter//
			//--------------------------------------------------------------------//

			assertTrue(goToBeginEncounter(selenium),"Could not navigate to begin encouter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8:Create Prescribe Medication//
			//--------------------------------------------------------------------//
			selenium.focus(imgPrescribeMedsIcon);
			selenium.click(imgPrescribeMedsIcon);
			
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not serach the Prescribe Medication", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnEdit),"Edit button is missing", selenium, ClassName, MethodName);
			
			
			assertTrue(click(selenium, btnAddToPending), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-9:Verify Interaction Warining details//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkMore),"Could not click the Medication Tab;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedicationTab),"Could not click the Medication Tab;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			int count=(Integer)selenium.getXpathCount(lblCureentMedsname);
			int counter=2;
			
			if(getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeNameCa)
					||getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeName)){
				assertTrue(isElementPresent(selenium, lblWarning1),"", selenium, ClassName, MethodName);
				selenium.mouseOver(lblWarning1);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium, "viewFullInteraction"),"", selenium, ClassName, MethodName);
				returnValue = true;
			}
			else{
				while(count>=counter){
					if(getText(selenium,"//tr["+counter+"]/td/div/span/div").contains(prescribeData.prescribeNameCa)
							||getText(selenium,"//tr["+counter+"]/td/div/span/div").contains(prescribeData.prescribeName)){
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
			assertTrue(getText(selenium,lblWarningReason).equals(prescribeData.reason),"Didn't match", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnViewFullInteraction ), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(getValue(selenium,txtOverride3).equals(prescribeData.reason),"Didn't match ", selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;

	}
	
}
