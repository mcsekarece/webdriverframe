package com.nexia.selenium.testscripts.section.chartprevisit.EMRSecurity;

import java.io.IOException;

import org.openqa.selenium.internal.seleniumemulation.GetXpathCount;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyIndicationForUseDataSharing extends AbstractChartPreVisit{

	@Test(groups = {"Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate that Indication for Use is shared for two practices with full share data access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationsInfoForFullDataSharingTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "EMRSecurity";
		prescribeData.testCaseId = "TC_ES_018";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		medicationsInfoDataSharingTest(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	/*************************************************************************************************** 
	 * @purpose        Test to validate that Indication for Use is shared for two practices with full share data access  
	 * @Specification  TCH-5 - Improve Security in Nexia 
	 * @action 		   Data Sharing function for a practice
	 * @expected       User with emergency access should be listed in Emergency Access page
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       July 17, 2014
	 ***************************************************************************************************/
	public boolean medicationsInfoDataSharingTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		ChartPreVisitLib proData = new ChartPreVisitLib();
		boolean returnValue=true;
		String firstMedicalCondn = "";
		String secondMedicalCondn = "";
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ",selenium,ClassName,MethodName);

			//--------------------------------------------------------------------//
			// Step-2: Set Data Sharing between Practices- both giving access to each other
			//--------------------------------------------------------------------//
			assertTrue(setDataSharingBetweenPractices(selenium, prescribeData), "Could not set Data Sharing level between practices", selenium, ClassName, MethodName);

			//Make both practices share each other data
			String originalPrac = prescribeData.practice;
			String newPrac = prescribeData.newPractice;
			prescribeData.newPractice = originalPrac;
			prescribeData.practice = newPrac;
			assertTrue(setDataSharingBetweenPractices(selenium, prescribeData), "Could not set Data Sharing level between practices", selenium, ClassName, MethodName);
			prescribeData.practice = originalPrac;
			prescribeData.newPractice = newPrac;		
					
			//--------------------------------------------------------------------//
			// Step-3: Switch practice to Practice1
			//--------------------------------------------------------------------//
			assertTrue(switchPractice(selenium, prescribeData.practice), "Could not switch the practice", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4:Change Switch Role - FULL  									 //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,prescribeData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Add medical condition1 to the problem list from Practice1
			//--------------------------------------------------------------------//
			proData.workSheetName = "CreateProblemList";
			proData.testCaseId = "TC_CPL_048";
			proData.fetchChartPreVisitTestData();
			firstMedicalCondn = proData.medicalCondition1;
			assertTrue(createProblemlist(selenium, userAccount, proData),"Could not create Problem List for first Practice",selenium, ClassName, MethodName);		

			//--------------------------------------------------------------------//
			// Step-6: Switch practice to Practice2
			//--------------------------------------------------------------------//
			assertTrue(switchPractice(selenium, prescribeData.newPractice), "Could not switch the practice", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-7: Change Switch Role - FULL  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,prescribeData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-8: Add medical condition1 to the problem list from Practice2
			//--------------------------------------------------------------------//
			proData.workSheetName = "CreateProblemList";
			proData.testCaseId = "TC_CPL_049";
			proData.fetchChartPreVisitTestData();
			secondMedicalCondn =  proData.medicalCondition1;

			assertTrue(createProblemlist(selenium, userAccount, proData),"Could not create Problem List for first Practice",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			// Step-9: Switch practice to Practice1
			//--------------------------------------------------------------------//
			assertTrue(switchPractice(selenium, prescribeData.practice), "Could not switch the practice", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-10:Change Switch Role - FULL  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,prescribeData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-11: Advanced search with Patient ID//
			//--------------------------------------------------------------------//			
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-12: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-13: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescribeData.provider = pName;
			
			if(selenium.isConfirmationPresent()){
				System.out.println(selenium.getConfirmation());
				selenium.chooseOkOnNextConfirmation();   }

			selectValueFromAjaxList(selenium, ajxProvider, prescribeData.provider);

			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxLoaction, prescribeData.location); 
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium, ajxDrugsList,	prescribeData.prescribe),"Could not type Prescribe Medication;More Details:"	+ prescribeData.toString(), selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkEdit),	"Could not click the Prescribe link;More Deatils:"+ prescribeData.toString(), selenium, ClassName, MethodName);			
			
			if ((!isElementPresent(selenium, btnOverride))&& isElementPresent(selenium, btnCancelButton)){
				assertTrue(click(selenium, btnCancelButton),
						"Could not Click Proceed Anyway button"+ prescribeData.toString(), selenium, ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-14: Check Values for Indication For Use dropdown//
			//--------------------------------------------------------------------//	
			
			selenium.click(ckkPrescribtionOption);			
			selenium.click(ajxProblemSuggestBox); 
			
			String indicationForUseValues = "";
			String medConditions = "html/body/div[4]/div/div/div/div/div";
			int n = (Integer) selenium.getXpathCount(medConditions);
			for (int i = 1; i <= n; i++) {
				indicationForUseValues = indicationForUseValues + getText(selenium, medConditions + "[" +i+ "]");				
			}
			
			if (indicationForUseValues.contains(firstMedicalCondn) && indicationForUseValues.contains(secondMedicalCondn)) {
				System.out.println("Medical conditions from Practice1 and Practice2 are found in dropdown values for Indication For Use");
			}else {
				fail("Medical conditions from Practice1 and Practice2 are NOT found in dropdown values for Indication For Use");
				returnValue = false;
			}	
	

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}

	private boolean createProblemlist(Selenium selenium,String userAccount, ChartPreVisitLib proData) throws IOException {
	
		// Advanced search with Patient ID		
		searchPatientNexiaForProviderHomePage(selenium, proData.patientId);
		waitForPageLoad(selenium);
								
		assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium, ClassName, MethodName);
		assertTrue(deleteAllEncounters(selenium,proData),"Deletion Failed",selenium, ClassName, MethodName);
		
		// Delete Existing Problem List							
		//Check if the Problem List link is Visible
		assertTrue(selenium.isVisible(lnkProblemList),"Problem List Link Not Visible;More Details",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);			
		assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(deleteAllProblemList(selenium, proData),"Deletion faied",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//  Begin Encounter
		waitForPageLoad(selenium);
		assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	
		//Delete Encounter Problem list//		
		assertTrue(isElementPresent(selenium,lnkProblemList),"Could not find the link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		selenium.clickAt(lnkProblemList,"");
		selenium.focus(lnkProblemList);
		selenium.fireEvent(lnkProblemList,"keypress");
		
		waitForPageLoad(selenium);
		
		//Add Problem
		assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//Verify Added Problem									  //
		assertTrue(selenium.isTextPresent(proData.medicalCondition1),"Medical ondition not present", selenium, ClassName, MethodName);

		return true;
	}

}
