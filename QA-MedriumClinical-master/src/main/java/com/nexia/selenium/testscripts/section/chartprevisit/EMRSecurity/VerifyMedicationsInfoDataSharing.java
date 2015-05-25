package com.nexia.selenium.testscripts.section.chartprevisit.EMRSecurity;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMedicationsInfoDataSharing extends AbstractChartPreVisit{

	@Test(groups = {"Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate that user can see free form medication ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationsInfoForFullDataSharingTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "EMRSecurity";
		prescribeData.testCaseId = "TC_ES_012";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		medicationsInfoDataSharingTest(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	@Test(groups = {"Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate that medication from the Medication tab will be displyed from Practice that shares Medical Chart")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationsInfoForPatientChartDataSharingTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "EMRSecurity";
		prescribeData.testCaseId = "TC_ES_013";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		medicationsInfoDataSharingTest(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to validate that user can see free form medication  
	 * @Specification  TCH-5 - Improve Security in Nexia 
	 * @action 		   Data Sharing fuction for a practice
	 * @expected       User with emergency access should be listed in Emergency Access page
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       July 11, 2014
	 ***************************************************************************************************/
	public boolean medicationsInfoDataSharingTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ",selenium,ClassName,MethodName);

			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"Could not click error close button", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			// Step-2: Set Data Sharing between Practices
			//--------------------------------------------------------------------//
			assertTrue(setDataSharingBetweenPractices(selenium, prescribeData), "Could not set Data Sharing level between practices", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			// Step-3: Switch practice to Practice which will share data
			//--------------------------------------------------------------------//
			assertTrue(switchPractice(selenium, prescribeData.practice), "Could not switch the practice", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4:Change Switch Role - FULL  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,prescribeData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Advanced search with Patient ID//
			//--------------------------------------------------------------------//			
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-6: Delete all existing pending Medication//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllPendingMedication(selenium, prescribeData), "Pending medication deleteion failed",selenium,ClassName,MethodName);

			// Load Medication data
			String newPractice = prescribeData.newPractice;
			prescribeData.workSheetName = "PrescribeMedi";
			prescribeData.testCaseId = "TC_PM_125";
			prescribeData.fetchChartPreVisitTestData();
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-8: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescribeData.provider = pName;

			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-9: Create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, btnAddToPending), "Could not click Add to Pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			// Step-10: Switch practice to different Practice which gets Full access
			//--------------------------------------------------------------------//
			assertTrue(switchPractice(selenium,newPractice), "Could not switch the practice-" +newPractice, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-11: Change Switch Role - FULL  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,"FULL"), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-12: Verify Patient Medication info in new Practice   										  //
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage(selenium, prescribeData.patientId),"Could not search for patient - " +prescribeData.patientId, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, lnkPatientOption),"Could not click the Patient Options link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			if( isElementPresent(selenium, lnkPatientChartView) ) {
				assertTrue(click(selenium,lnkPatientChartView),"Could not click View Registration link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}else
				click(selenium, lnkPatientOption);

			assertTrue(click(selenium,lnkSummary),"Could not click the summary link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			if(!verifyStoredValues(selenium, prescribeData,userAccount))
				Assert.fail("The values are not stored in the summary");
			else
				return returnValue;

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}

	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib prescribeData, String account){
		if(account.equals(CAAccount)){
			if(!getText(selenium,lblPrescribeMedsDetails).contains(prescribeData.prescribeNameCa))
				return false;
		}else{
			if(!getText(selenium,lblPrescribeMedsDetails).contains(prescribeData.prescribeName))
				return false;
		}

		if(!getText(selenium,lblPrescribeMedsDetails).trim().contains(prescribeData.refillMethod.trim())){
			return false;
		}if(account.equals(CAAccount)){
			if(!getText(selenium,lblPrescribeMedsDetails).trim().contains(prescribeData.refillQuantityCa.trim())){
				return false;
			}
		}else{
			if(!getText(selenium,lblPrescribeMedsDetails).trim().contains(prescribeData.refillQuantity.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMedsDetails).trim().contains(prescribeData.refillUnit.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMedsDetails).trim().contains(prescribeData.refillRoute.trim())){
				return false;
			}
		}if(account.equals(CAAccount)){
			if(!getText(selenium,lblPrescribeMedsDetails).trim().contains(prescribeData.refillFrequencyCa.trim())){
				return false;
			}
		}else{
			if(!getText(selenium,lblPrescribeMedsDetails).trim().contains(prescribeData.refillFrequency.trim())){
				return false;
			}
		}
		if(!getText(selenium,lblPrescribeMedsDetails).trim().contains(prescribeData.refillUsage.trim())){
			return false;
		}

		return true;
	}

}
