package com.nexia.selenium.testscripts.section.chartprevisit.ReferralLetter;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySystemGeneratedGroupingOfFields extends AbstractChartPreVisit {	

	//System Generated Groups 
	String[] fieldtype = {"Recipient","Patient Vitals","Patient Demographics","Patient Allergies" ,
			"Patient Problem List", "Patient Procedures", "Patient Medications", "Patient Family History",
			"Patient Social History", "Patient Immunizations", "Patient Injections", "Patient Encounter Sections",
			"Patient Health Maintenance", "Provider Demographics" };
	
	//Provider Demographics Fields
	String[] providerDemographicsFields = {"Provider Type", "Title", "Last Name", "First Name", "Middle Name", 
			"Credentials", "Specialty", "Billing Address", "Cell Phone", "Office Phone", "Fax", "Email"};
	
	//Patient Demographics Fields
	String[] patientDemographicsFields = {"Last Name", "First Name", "Middle Name", "Title", "Suffix", "Alias1", 
			"Alias2", "DOB", "HCN", "Expiry Date", "Newborn", "Primary Location", "Responsible Provider", "PCP", 
			"Sex", "Marital Status", "Address", "Mailing Address", "Primary Phone", "Other Phone", "E-mail"};
	
	//Patient Allergies fields
	String[] patientAllergiesFields = {"Allergy Type", "Allergen", "Reaction", "Severity", "Onset date", "Status", 
			"Life Stage", "Comments"};

	//Patient Family History fields
	String[] patientFamilyHistoryFields = {"Medical Condition", "Relationship", "Coding System", "Age at Onset", 
			"Diagnosis", "Life Stage", "Cause of Death", "Age at Death", "Treatment", "Comment"};
	
	//Patient Social History Fields
	String[] patientSocialHistoryFields = {"Type", "Status", "Details", "Item", "Started at Age", 
			"Stopped at Age", "Life Stage", "Comment"};
	
	//Patient Problem List
	String[] patientProblemList = {"Medical Condition", "Status", "Onset Date", "Resolved Date", "Life Stage", 
			"Coding System", "Diagnosis", "Comment"};
	
	//Patient Procedures Fields
	String[] patientProceduresFields = {"Procedure","Procedure Date", "CPT Code", "Comment"};
	
	//Patient Injections Fields 
	String[] patientInjectionsFields = {"Injection","Lot Number","Dosage","Expiry Date","Administered On","Site",
			"Administered By","Route","CPT Code 1","CPT Code 2","Reaction",	"Comment"};
	
	//Patient Medications Fields
	String[] patientMedicationsFields = {"Medication","Method", "Quantity", "Unit", "Route", "Frequency", 
			"Duration","Usage directions"};
	
	//Patient Immunizations fields 
	String[] patientImmunizationsFields = {"Refused by Patient","Administered Elsewhere","Vaccine","Lot Number",
			"Dosage","Expiration Date","Administered On","Series","Administered By","Site","Route","CPT Code 1",
			"CPT Code 2","Reaction","Comment"};
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify that system automatically groups the fields based on their categories")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void automaticGroupingOfFieldTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {


		ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IR_008"; //Dummy value, No data from test case sheet required
		letterTemplateTestData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		checkGroupingOfFields(seleniumHost, seleniumPort, browser, webSite, userAccount,letterTemplateTestData);
	}

	/*************************************************************************************************** 
	 * @purpose        Verify that system automatically groups the fields based on their categories 
	 * @action 		   Open Widget to add fields 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       June 20, 2014	
	 ***************************************************************************************************/

	public boolean checkGroupingOfFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib letterTemplateTestData ) throws IOException{

		Selenium selenium=null;
		boolean returnValue=true;


		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application 								  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + letterTemplateTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, letterTemplateTestData.userName, letterTemplateTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,letterTemplateTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Letter templates page  						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToLetterTemplate(selenium),"Could not navigate to Letter Template page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			

			//--------------------------------------------------------------------//
			//  Step-4: Click Add New button 						  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddLetterTemplate), "Could not click on add new Letter template button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	

			//--------------------------------------------------------------------//
			//  Step-5: Verify all system generated template fields groups    //
			//--------------------------------------------------------------------//
			assertTrue(verifyAllTemplateFieldGroups(selenium), "Could not find all system generated template field groups", selenium, ClassName, MethodName);


		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	private boolean verifyAllTemplateFieldGroups(Selenium selenium) throws IOException {
		
		assertTrue(click(selenium, btnAddTemplateField ), "Could not click on Add New button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		for (int i = 0; i < fieldtype.length; i++) {

			assertTrue(selectValueFromAjaxList(selenium, ajxFieldType, fieldtype[i]), "Could not select the field type " +fieldtype[i], selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			int n = (Integer) selenium.getXpathCount(lblGroupFields);
			System.out.println("Total number of field for fieldtype " +fieldtype[i]+" are: " +n);		
			
			if (fieldtype[i].equals("Provider Demographics")) { // Provider Demographic fields
				assertTrue(verifyAvaialbleFieldsOfAGroup(selenium, providerDemographicsFields, fieldtype[i]), "All fields under Group-" +fieldtype[i]+ " not found.", selenium, ClassName, MethodName);
				
			}else if (fieldtype[i].equals("Patient Demographics")) {  //Patient Demographics fields
				assertTrue(verifyAvaialbleFieldsOfAGroup(selenium, patientDemographicsFields, fieldtype[i]), "All fields under Group-" +fieldtype[i]+ " not found.", selenium, ClassName, MethodName);
			
			} else if (fieldtype[i].equals("Patient Allergies")) {  //Patient Allergies fields
				assertTrue(verifyAvaialbleFieldsOfAGroup(selenium, patientAllergiesFields, fieldtype[i]), "All fields under Group-" +fieldtype[i]+ " not found.", selenium, ClassName, MethodName);
			
			}else if (fieldtype[i].equals("Patient Family History")) {  //Patient Allergies fields
				assertTrue(verifyAvaialbleFieldsOfAGroup(selenium, patientFamilyHistoryFields, fieldtype[i]), "All fields under Group-" +fieldtype[i]+ " not found.", selenium, ClassName, MethodName);
			
			}else if (fieldtype[i].equals("Patient Social History")) {  //Patient Social History Fields
				assertTrue(verifyAvaialbleFieldsOfAGroup(selenium, patientSocialHistoryFields, fieldtype[i]), "All fields under Group-" +fieldtype[i]+ " not found.", selenium, ClassName, MethodName);
				
			}else if (fieldtype[i].equals("Patient Problem List")) {  //Patient Problem List
				assertTrue(verifyAvaialbleFieldsOfAGroup(selenium, patientProblemList, fieldtype[i]), "All fields under Group-" +fieldtype[i]+ " not found.", selenium, ClassName, MethodName);
				
			}else if (fieldtype[i].equals("Patient Procedures")) {  //Patient Procedures Fields
				assertTrue(verifyAvaialbleFieldsOfAGroup(selenium, patientProceduresFields, fieldtype[i]), "All fields under Group-" +fieldtype[i]+ " not found.", selenium, ClassName, MethodName);
				
			}else if (fieldtype[i].equals("Patient Injections")) {  //Patient Injections Fields
				assertTrue(verifyAvaialbleFieldsOfAGroup(selenium, patientInjectionsFields, fieldtype[i]), "All fields under Group-" +fieldtype[i]+ " not found.", selenium, ClassName, MethodName);
				
			}else if (fieldtype[i].equals("Patient Medications")) {  //Patient Medications Fields
				assertTrue(verifyAvaialbleFieldsOfAGroup(selenium, patientMedicationsFields, fieldtype[i]), "All fields under Group-" +fieldtype[i]+ " not found.", selenium, ClassName, MethodName);
				
			}else if (fieldtype[i].equals("Patient Immunizations")) {  //Patient ImmunizationsFields
				assertTrue(verifyAvaialbleFieldsOfAGroup(selenium, patientImmunizationsFields, fieldtype[i]), "All fields under Group-" +fieldtype[i]+ " not found.", selenium, ClassName, MethodName);
				
			}

		}		

		return true;
	}

	private boolean verifyAvaialbleFieldsOfAGroup(Selenium selenium, String[] allGroupFields, String fieldtype) {
		boolean result = true;
		String availableField = "";
		for (int j = 0; j < allGroupFields.length; j++) {
			availableField = "//div[@class='gwt-Label' and text()='" +allGroupFields[j]+ "']";
			if(isElementPresent(selenium, availableField) )
				System.out.println("Field-" +allGroupFields[j]+ " is present under Group-" +fieldtype );
			else {
				System.out.println("Field-" +allGroupFields[j]+ " is not present under Group-" +fieldtype );
				result = false;
				return result;
			}
		}		
		return result;
	}

}