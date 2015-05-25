package com.nexia.selenium.testscripts.section.clinicalsettings.encounterTemplate;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultEncounterTemplateWithEncounterNote extends AbstractClinicalSettings {
	
	@Test(groups = {"SingleThread","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing default encounter template")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultEncounterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClinicalSettingLib encounterTemplateTestData = new ClinicalSettingLib();
		encounterTemplateTestData.workSheetName = "EncounterTemplate";
		encounterTemplateTestData.testCaseId = "TC_ET_008";
		encounterTemplateTestData.fetchClinicalSettingsTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		encounterTemplate(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterTemplateTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify default encounter template
	* @Specification  SRS_EMR_Encounter_Structure_Templates Rev0.0
	* @action 		  Verifying default encounter template
	* @author         AspireQA
	* @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 16, 2013
	***************************************************************************************************/

	public boolean encounterTemplate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib encounterTemplateTestData) throws IOException{
	
		Selenium selenium=null;
	
		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterTemplateTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterTemplateTestData.userName, encounterTemplateTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Change the switch role 									  //
			//--------------------------------------------------------------------//
			//assertTrue(selectAutomationNexiaPractice(selenium),"Could not change the practice",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(switchRole(selenium,encounterTemplateTestData.switchRole),"Could not change the switch role;More Details:"+encounterTemplateTestData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter Template 							  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToEncounterTemplate(selenium),"Navigation to encounter template Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Delete All Encounter Template 							  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllEncounterTemplate(selenium),"Could not Delete All Encounter Template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
						
			//----------------------------------------------------------------------------//
			//  Step-5: verify the default encounter template values in summary page      //
			//----------------------------------------------------------------------------//
			assertTrue(verifyStoreValuesEncounterTemplate(selenium, encounterTemplateTestData),"Verification failed for added encounter template in summary page", selenium, ClassName, MethodName);
			
			/*if(getText(selenium, lnkDeleteEncounterTemplate).equalsIgnoreCase("Delete")){
				return false;
			} */
			
			//----------------------------------------------------------------------------//
			//  Step-6: Edit the default encounter template						 	      //
			//----------------------------------------------------------------------------//
			assertTrue(click(selenium, EncoEdit), "Could not click on edit", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//----------------------------------------------------------------------------//
			//  Step-7: Verify all the menu's are checked in by default				 	  //
			//----------------------------------------------------------------------------//
			// get the number of encounter template menus
			assertTrue(DeleteCustomSectioninDefaultEncounterTemplate(selenium), "Other Menu section deletion failed in Default template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			int encounterTempCount= (Integer) selenium.getXpathCount("//div[@class='display-cell checkbox-col']");
			String[] DefaultSection = new String[100];
			for(int count=1; count<= encounterTempCount; count++){
				if(!isChecked(selenium, "//tr["+count+"]/td/div/div/div/div/div/span/input")){
					assertTrue(click(selenium,"//tr["+count+"]/td/div/div/div/div/div/span/input"), "Could not check the component Check box", selenium, ClassName, MethodName);
				}
				//System.out.println("//tr["+count+"]/td/div/div/div/div/div[2]/div");
				if(isElementPresent(selenium,"//tr["+count+"]/td/div/div/div/div/div[2]/div")){
				
				 DefaultSection[count]=selenium.getText("//tr["+count+"]/td/div/div/div/div/div[2]/div").toString();
				
				}
				else
				{
					Assert.fail("Section Name not Present in Edit mode of Default Encounter Template");
				}
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSaveEncounterTemp), "Could not click save encounter template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//----------------------------------------------------------------------------//
			//  Step-8: Verify default Template with Patient Encounter Note			 	  //
			//----------------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickLink), "Could not click Quick Action Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not click Quick Action Button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			ChartPreVisitLib PatientData = new ChartPreVisitLib();	
			PatientData.workSheetName = "NewPatientCheckIn";
			PatientData.testCaseId = "TC_NP_001";
			String date=null;	
			PatientData.fetchChartPreVisitTestData();		
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MMMMddHH");
				date = DateFormat.format(cal.getTime());
			PatientData.lastName=PatientData.lastName+date;
			assertTrue( createNewPatientWithMandatory(selenium,PatientData),"Could not create a patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//----------------------------------------------------------------------------//
			//  Step-9:Search Newly created Patient 	  //
			//----------------------------------------------------------------------------//
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,PatientData.lastName);
			waitForPageLoad(selenium);
			//----------------------------------------------------------------------------//
			//  Step-9:Goto Encounter 													  //
			//----------------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation failed",selenium, ClassName, MethodName);
			//----------------------------------------------------------------------------//
			//  Step-9:GotoVerify default Template in Encounter Note													  //
			//----------------------------------------------------------------------------//
			for(int count=2; count<= encounterTempCount; count++){
			
				if(selenium.isTextPresent(DefaultSection[count])){
					returnValue=true;
			}
				else
				{
					
					Assert.fail("Verification of Default template in Encounter Note Failed");return false;
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean VerifydefaulttemplateTemplateinEncounterNote(Selenium selenium,String  DefaultSection)
	{
		
		return true;
	}
	
	
	
	
	
	
	
	
	
}