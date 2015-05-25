package com.nexia.selenium.testscripts.section.chartprevisit.Allergies;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAllergyInteractionForPrescribedMed extends AbstractChartPreVisit{
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Allergy Interaction For Prescribed Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAllergyInteractionWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_046";
		prescribeData.fetchChartPreVisitTestData();
		stopMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}

	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Cancel In Allergy Interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelInAllergyInteractionWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_050";
		prescribeData.fetchChartPreVisitTestData();
		stopMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
		@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Stop Medication In Allergy Interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStopMedicationInAllergyInteractionWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_051";
		prescribeData.fetchChartPreVisitTestData();
		stopMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify override Medication In Allergy Interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOverrideMedicationInAllergyInteractionWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_052";
		prescribeData.fetchChartPreVisitTestData();
		stopMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify QuickList In Allergy Interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyQuickListInAllergyInteractionWarning(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_053";
		prescribeData.fetchChartPreVisitTestData();
		stopMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify QuickList In Allergy Interaction Warning")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOverrideWarningWithEmptyReason(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_059";
		prescribeData.fetchChartPreVisitTestData();
		stopMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verifying Allergy Interaction For Prescribed Medication
	* @action 		  verifying Allergy Interaction For Prescribed Medication
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @testcaseid     TAC_AL_34 to TAC_AL_39
	* @since  	      April 11, 2013
	***************************************************************************************************/
	public boolean stopMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		int counter=1;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,prescribeData.switchRole),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Create a new patient and get Patient Id					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			ChartPreVisitLib prescribePatientData = new ChartPreVisitLib();
			prescribePatientData.workSheetName = "NewPatientCheckIn";
			prescribePatientData.testCaseId = "TC_NP_001";
			prescribePatientData.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,prescribePatientData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
	        String lastName="";
			char[] processLastName=providerName.toCharArray();
			int i=providerName.length();
			 i=i-1;
			 while(processLastName[i]!=' ')
			 {
				 lastName=lastName+processLastName[i];
				 i--;
			 }
			 String lastname="";
			 int length = lastName.length();
		      for ( i = length - 1 ; i >= 0 ; i-- )
		    	  lastname = lastname + lastName.charAt(i);
			assertTrue(selectValueFromAjaxList(selenium,ajxProvider,lastname),"unable to select the provider",selenium,ClassName,MethodName);
		
			assertTrue(click(selenium,btnPrescibeQuick),"Could not click the QuickList button;More details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			while((Integer) selenium.getXpathCount(ajxMedsQuickUs)>0){
				assertTrue(click(selenium,lnkPrescribeDelete),"Could not delete the QuickList value;More details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnPrescibeQuick),"Could not click the QuickList button;More details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnPrescibeQuick),"Could not click the QuickList button;More details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
			}
			
			assertTrue(click(selenium,btnPrescibeQuick),"Could not click the QuickList button;More details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				}

			
			//--------------------------------------------------------------------//
			//  Step-6 : create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnEdit),"Edit Button Not Present", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnPrint),"Could not click the print button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			Robot robot = new Robot();
			Thread.sleep(20000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			
			assertTrue(click(selenium, lnkMore),"Could not click on More  link", selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,lnkMedicationTab),"Could not find Medication Tab", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium, lnkMedicationTab),"Could not click the medication tab", selenium, ClassName, MethodName);
				
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MMMM dd, yyy");
			String uniqueName=DateFormat.format(cal.getTime());
			System.out.println(uniqueName);
			
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxRxShow,"Current");
			waitForPageLoad(selenium);
			
			//counter=1;
			
			/*if(!((getText(selenium,"//tr["+counter+"]/td/div/span/div").contains(prescribeData.prescribeName))
					|| getText(selenium,"//tr["+counter+"]/td/div/span/div").contains(prescribeData.prescribeNameCa))){
				Assert.fail("Record is not getting displayed");
			}*/

			assertTrue(verifyValue(selenium,prescribeData),"Could not find PrescribeData", selenium, ClassName, MethodName);
			
			ChartPreVisitLib allergyData = new ChartPreVisitLib();
			allergyData.workSheetName = "CreateAllergy";
			allergyData.testCaseId = "TC_CA_022";
			allergyData.fetchChartPreVisitTestData();
			
			
			//--------------------------------------------------------------------//
			//  Step-7: Delete Allergy//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSummary),"Could not click the chart summary;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Add Allergy//
			//--------------------------------------------------------------------//
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(getText(selenium,lblAllergyInteractionWindow).contains("Allergy Interaction Warning")){
				
				if(prescribeData.testCaseId.equalsIgnoreCase("TC_PM_046")){
					assertTrue(verifyAllergyInteraction(selenium,allergyData),"Allergy interaction verification failed", selenium, ClassName, MethodName);
				}
				else if(prescribeData.testCaseId.equalsIgnoreCase("TC_PM_050")){
					assertTrue(verifyCancelInAllergyInteraction(selenium,allergyData,userAccount),"Cancel feature in Allergy interaction verification failed", selenium, ClassName, MethodName);			
				}
				else if(prescribeData.testCaseId.equalsIgnoreCase("TC_PM_051")){
					assertTrue(verifyStopMedicationInAllergyInteraction(selenium,allergyData),"Stop medication feature in Allergy interaction verification failed", selenium, ClassName, MethodName);
				}
				else if(prescribeData.testCaseId.equalsIgnoreCase("TC_PM_052") || prescribeData.testCaseId.equalsIgnoreCase("TC_PM_059")){
					assertTrue(verifyOverrideInAllergyInteraction(selenium,allergyData,prescribeData),"Override medication feature in Allergy interaction verification failed", selenium, ClassName, MethodName);
				}
				else if(prescribeData.testCaseId.equalsIgnoreCase("TC_PM_053")){
					assertTrue(verifyQuicklistInAllergyInteraction(selenium,allergyData,userAccount),"QuickList feature in Allergy interaction verification failed", selenium, ClassName, MethodName);
				}
				
				
			}else
				//Assert.fail("Interaction Warning is not getting displayed");
			return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
	public boolean verifyValue(Selenium selenium,ChartPreVisitLib  prescribeData){
		System.out.println(selenium.isTextPresent(prescribeData.prescribe));
		if(!((selenium.isTextPresent(prescribeData.prescribe.toUpperCase()))||(selenium.isTextPresent(prescribeData.prescribeCa.toUpperCase())))){
			return false;
		}
		return true;
	}
}
