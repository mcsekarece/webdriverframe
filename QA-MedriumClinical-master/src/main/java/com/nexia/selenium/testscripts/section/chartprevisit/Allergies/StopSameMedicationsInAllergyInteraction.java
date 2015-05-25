package com.nexia.selenium.testscripts.section.chartprevisit.Allergies;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class StopSameMedicationsInAllergyInteraction extends AbstractChartPreVisit{
	@Test(groups = {"SmokeSingle","SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Stop Same Medications In Allergy Interaction")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void stopSameMedicationsInAllergyInteraction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_046";
		prescribeData.fetchChartPreVisitTestData();
		stopMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verifying Stop Same Medications In Allergy Interaction
	* @action 		  verifying Stop Same Medications In Allergy Interaction
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      June 05, 2013
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
			assertTrue(click(selenium,lnkMore),"Could not click the More Tab;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,lnkMedicationTab),"Could not find the Link Medication Tab", selenium, ClassName, MethodName);
			
				click(selenium, lnkMedicationTab);
				
			
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxRxShow,"Current");
			waitForPageLoad(selenium);
			counter=1;
				if (userAccount.equals(CAAccount)) {
				assertTrue(selenium.isTextPresent(prescribeData.prescribeCa.toUpperCase()),"Could not Fine current Medication;More Details:"+ prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			} else {
				assertTrue(selenium.isTextPresent(prescribeData.prescribe.toUpperCase()),"Could not Fine current Medication;More Details:"+ prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-7: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium,btnErrorClose)){
				assertTrue(isElementPresent(selenium, btnErrorClose),"Error Close Button Not Present", selenium, ClassName, MethodName);
				assertTrue(click(selenium, btnErrorClose),"Could not click Error Close Button", selenium, ClassName, MethodName);}
			selectValueFromAjaxList(selenium,ajxProvider,prescribeData.provider);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxLoaction,prescribeData.loaction);
			waitForPageLoad(selenium);
			if(userAccount.equals(CAAccount)){
				assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,prescribeData.prescribeCa),"Could not type Prescribe Medication;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			}else{
				assertTrue(selectValueFromAjaxList(selenium,ajxDrugsList,prescribeData.prescribe),"Could not type Prescribe Medication;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
			}
			//click(selenium, "//body/div[4]/div/div/div/div/div");
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkEdit)){
				assertTrue(click(selenium,lnlEdit1),"Could not click the Prescribe link;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			 }else
				 assertTrue(click(selenium,lnlEdit2),"Could not click the Prescribe link;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnOverride),"Could not find override button"+prescribeData.toString(), selenium, ClassName, MethodName);
			
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-8 : create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnEdit),"Could not find the Edit Buttion", selenium, ClassName, MethodName);

			assertTrue(click(selenium,btnPrint),"Could not click the print button;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			assertTrue(click(selenium,lnkMore),"Could not click the More Tab;More Deatils:"+prescribeData.toString(), selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,lnkMedicationTab),"Could not Find the Medication Link Tab", selenium, ClassName, MethodName);
			
				click(selenium, lnkMedicationTab);
				
			
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxRxShow,"Current");
			waitForPageLoad(selenium);
			counter=2;
			if (userAccount.equals(CAAccount)) {
				assertTrue(selenium.isTextPresent(prescribeData.prescribeCa.toUpperCase()),"Could not Fine current Medication;More Details:"+ prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			} else {
				assertTrue(selenium.isTextPresent(prescribeData.prescribe.toUpperCase()),"Could not Fine current Medication;More Details:"+ prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-9: Delete Allergy//
			//--------------------------------------------------------------------//
			ChartPreVisitLib allergyData = new ChartPreVisitLib();
			allergyData.workSheetName = "CreateAllergy";
			allergyData.testCaseId = "TC_CA_022";
			allergyData.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,lnkSummary),"Could not click the chart summary;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-10: Add Allergy//
			//--------------------------------------------------------------------//
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(getText(selenium,lblAllergyInteractionWindow).contains("Allergy Interaction Warning")){
				
                if(getText(selenium,lblAllergyInteraction).contains(allergyData.allergen)){
                   assertTrue(click(selenium, "//td/span/input"), "Radio Button In Allergy Interaction warning could not be selected", selenium, ClassName, MethodName);
                   assertTrue(click(selenium, "//div[2]/div/div/table/tbody/tr[2]/td/span/input"), "Radio Button In Allergy Interaction warning could not be selected", selenium, ClassName, MethodName);
                   assertTrue(click(selenium, "xpath=(//button[@id='save'])[3]"), "Save Button In Allergy Interaction warning could not be clicked", selenium, ClassName, MethodName);
                }
	                    
				
			}else
				Assert.fail("Interaction Warning is not getting displayed");
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
