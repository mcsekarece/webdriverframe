package com.nexia.selenium.testscripts.section.chartprevisit.CustomizationSummary;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMandatoryAndOptionalElements extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Mandatory And Optional Elements")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMandatoryAndOptionalFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib customiszeData = new ChartPreVisitLib();
		customiszeData.workSheetName = "PatientSummary";
		customiszeData.testCaseId = "TC_PS_001";
		customiszeData.fetchChartPreVisitTestData();
		verifyMandatoryAndOptionalElements(seleniumHost, seleniumPort, browser, webSite, userAccount, customiszeData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Mandatory and Optional element in patient summary page
	* @action 		  verifying Mandatory and Optional element in patient summary page
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Aug 26, 2013
	***************************************************************************************************/
	
	public boolean verifyMandatoryAndOptionalElements(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLib customiszeData) throws IOException{
	
		boolean returnValue = false;
		Selenium selenium = null;
		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + customiszeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, customiszeData.userName, customiszeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to My Setting//
			//--------------------------------------------------------------------//
			assertTrue(navigateToPatientSummary(selenium), "Could not Navigate the Patient Summary", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnCSEdit),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Mandatory And Optional Element//
			//--------------------------------------------------------------------//
			
			if(!verifyMandatoryAndOptionalFields(selenium)){
				Assert.fail("The Optional  Element is getting displayed");
			}else
				returnValue = true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
	public boolean verifyMandatoryAndOptionalFields(Selenium selenium) throws IOException{
		int sectionCount = (Integer) selenium.getXpathCount("//tr/td/div/div");
		for (int count = 2 ;count <= sectionCount-2; count++){
			String section = selenium.getText("//tr["+count+"]/td/div/div");
			if(section.contains("Allergies")){
				assertTrue(selenium.isTextPresent("Severity")," Text(Severity)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Allergen")," Text(Allergen)the text is not present", selenium, ClassName, MethodName);
				assertTrue(click(selenium,"//tr["+count+"]/td/div/div/div/div[4]/a"), "Could not click the arrow", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Status")," Text(Status)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Type Allergy VS Intolerance")," Text(Type Allergy VS Intolerance)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Reaction")," Text(Reaction)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Comment")," Text(Comment)the text is not present", selenium, ClassName, MethodName);
				
			}else if(section.contains("Social History")){
				assertTrue(selenium.isTextPresent("Status")," Text(Status)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Type")," Text(Type)the text is not present", selenium, ClassName, MethodName);
				assertTrue(click(selenium,"//tr["+count+"]/td/div/div/div/div[4]/a"), "Could not click the arrow", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Item")," Text(Item)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent(" Details")," Text( Details)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Comment")," Text(Comment)the text is not present", selenium, ClassName, MethodName);
			}else if(section.contains("Surgical History")){
				assertTrue(selenium.isTextPresent("Procedure Date")," Text(Procedure Date)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Procedure Name")," Text(Procedure Name)the text is not present", selenium, ClassName, MethodName);
				assertTrue(click(selenium,"//tr["+count+"]/td/div/div/div/div[4]/a"), "Could not click the arrow", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Comment")," Text(Comment)the text is not present", selenium, ClassName, MethodName);
			}else if(section.contains("Problem List")){
				assertTrue(selenium.isTextPresent("Status")," Text(Procedure Date)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Procedure Name")," Text(Procedure Name)the text is not present", selenium, ClassName, MethodName);
				assertTrue(click(selenium,"//tr["+count+"]/td/div/div/div/div[4]/a"), "Could not click the arrow", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Onset Date")," Text(Onset Date)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent(" Comment")," Text( Comment)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Life Stage")," Text(Life Stage)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Resolved Date")," Text(Resolved Date)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Diagnoses")," Text(Diagnoses)the text is not present", selenium, ClassName, MethodName);
			}else if(section.contains("Injections")){
				assertTrue(selenium.isTextPresent("Date Administered")," Text(Date Administered)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Injection")," Text(Injection )the text is not present", selenium, ClassName, MethodName);
				assertTrue(click(selenium,"//tr["+count+"]/td/div/div/div/div[4]/a"), "Could not click the arrow", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Reaction")," Text(Reaction)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Comment")," Text(Comment)the text is not present", selenium, ClassName, MethodName);
			}else if(section.contains("Immunizations")){
				assertTrue(selenium.isTextPresent("Date Administered")," Text(Date Administered)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Vaccine Name")," Text(Vaccine Name )the text is not present", selenium, ClassName, MethodName);
				assertTrue(click(selenium,"//tr["+count+"]/td/div/div/div/div[4]/a"), "Could not click the arrow", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Reaction")," Text(Reaction)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Comment")," Text(Comment)the text is not present", selenium, ClassName, MethodName);
			}else if(section.contains("Family History")){
				assertTrue(selenium.isTextPresent("Relationship")," Text(Relationship)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Medical Condition")," Text(Medical Condition)the text is not present", selenium, ClassName, MethodName);
				assertTrue(click(selenium,"//tr["+count+"]/td/div/div/div/div[4]/a"), "Could not click the arrow", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Onset Age")," Text(Onset Age)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Comment")," Text(Comment)the text is not present", selenium, ClassName, MethodName);
			}else if(section.contains("Medication")){
				assertTrue(selenium.isTextPresent("Started on Date")," Text(Started on Date)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Medication")," Text(Medication)the text is not present", selenium, ClassName, MethodName);
				assertTrue(click(selenium,"//tr["+count+"]/td/div/div/div/div[4]/a"), "Could not click the arrow", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("SIG/Direction")," Text(SIG/Direction)the text is not present", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent(" Notes to Pharmacy")," Text( Notes to Pharmacy)the text is not present", selenium, ClassName, MethodName);
			}
			System.out.println(count);
		}
		return true;
	}
}