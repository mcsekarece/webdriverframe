
package com.nexia.selenium.testscripts.section.demographics.Consents;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class UpdateNewConsent extends AbstractHomeTest  {
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Updating a New patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void updateConsent(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib updateconsentData = new HomeLib();
		updateconsentData.workSheetName = "NewConsent";
		updateconsentData.testCaseId = "TC_NC_004";
		updateconsentData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		updateconsent(seleniumHost, seleniumPort, browser, webSite, userAccount, updateconsentData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Updating a New patient
	* @action 		  Verifying Update a New patient
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    Both
	* @since  	      April 02, 2012
	***************************************************************************************************/
		
	public boolean updateconsent(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib updateconsentData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = true;
		try{
			//--------------------------------------------------------------------//	
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//	
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + updateconsentData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, updateconsentData.userName, updateconsentData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,updateconsentData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to security setting and create consents       //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkQuickActions),"Could not click on quick actions:" + updateconsentData .toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkSecuritysetting),"Could not click the System settings link;More Details:"+updateconsentData.toString(), selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			HomeLib ssConsentsData = new  HomeLib();
			ssConsentsData.workSheetName = "SSConsents";
			ssConsentsData.testCaseId = "TC_SSC_001";
			ssConsentsData.fetchHomeTestData();
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkConsents),"Could not click the Admin consent; More details"+ssConsentsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddConsents),"Could not click the Admin consent; More details"+ssConsentsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createSSConsents(selenium,ssConsentsData),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to Consents and deleting existing Consents       //
			//--------------------------------------------------------------------//
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			
			searchPatientNexia(selenium,updateconsentData.patientID);
			waitForPageLoad(selenium);
			
			
			click(selenium,lnkConsentsPatient);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//	
			//  Step-6: Edit the existing Consent
			//--------------------------------------------------------------------//	
			if(isElementPresent(selenium,lnkConsentsDelete)){
				click(selenium,lnkEditConsents);
				waitForPageLoad(selenium);
			
				updateconsentData.workSheetName = "NewConsent";
				updateconsentData.testCaseId = "TC_NC_002";
				updateconsentData.fetchHomeTestData();
				
				selectValueFromAjaxList(selenium,ajkConsentsType, updateconsentData.consentType);
				selectValueFromAjaxList(selenium,ajkConsentsName, updateconsentData.consentName);
				selectValueFromAjaxList(selenium,ajkStatus,updateconsentData.status);
				if (isElementPresent(selenium, ajkInactivation))
				selectValueFromAjaxList(selenium,ajkInactivation,updateconsentData.inactivation);
				assertTrue(enterDate(selenium,txtDateSigned, updateconsentData.dateSigned),"Could not enter date; More Details :" + updateconsentData.toString(), selenium, ClassName, MethodName);
				
				if(updateconsentData.signedBy.equalsIgnoreCase("Patient")){
					assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" +updateconsentData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				else if(updateconsentData.signedBy.equalsIgnoreCase("Substitution Decision Maker")){
					assertTrue(click(selenium,rdoSubstitutionMark),"Could not select the susbstitution maker; More Details :" + updateconsentData.toString(), selenium, ClassName, MethodName);
					selectValueFromAjaxList(selenium,ajkRelationship,updateconsentData.relationship);
					assertTrue(type(selenium,txtFirstName,updateconsentData.firstName),"Could not enter the first name; More Details :" + updateconsentData.toString(), selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtLastName,updateconsentData.lastName),"Could not enter last name; More Details :" + updateconsentData.toString(), selenium, ClassName, MethodName);
					
				
				assertTrue(verifyStoredValuesForConsents(selenium,updateconsentData),"Consent details not saved properly; More Details :"+ updateconsentData.toString(),selenium, ClassName, MethodName);
					return returnValue;
			}
			}
			
			//--------------------------------------------------------------------//	
			//  Step-7: Create new consent if no existing consents available
			//--------------------------------------------------------------------//	
			
			else if(!selenium.isElementPresent(lnkConsentsDelete)){
			assertTrue(click(selenium,btnConsentsAdd),"Could not Click on Add Consents Button:"+ updateconsentData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createConsent(selenium,updateconsentData),"Consent creation Failed", selenium, ClassName, MethodName);
						
			click(selenium,lnkEditConsents);
			waitForPageLoad(selenium);
				
			updateconsentData.workSheetName = "NewConsent";
			updateconsentData.testCaseId = "TC_NC_002";
			updateconsentData.fetchHomeTestData();
			
			//--------------------------------------------------------------------//	
			//  Step-8: Edit the newly created consent
			//--------------------------------------------------------------------//
			
			selectValueFromAjaxList(selenium,ajkConsentsType, updateconsentData.consentType);
			selectValueFromAjaxList(selenium,ajkConsentsName, updateconsentData.consentName);
			selectValueFromAjaxList(selenium,ajkStatus,updateconsentData.status);
			if (isElementPresent(selenium, ajkInactivation))
				selectValueFromAjaxList(selenium,ajkInactivation,updateconsentData.inactivation);
				assertTrue(enterDate(selenium,txtDateSigned, updateconsentData.dateSigned),"Could not enter date; More Details :" + updateconsentData.toString(), selenium, ClassName, MethodName);
				
			if(updateconsentData.signedBy.equalsIgnoreCase("Patient")){
				assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" +updateconsentData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			else if(updateconsentData.signedBy.equalsIgnoreCase("Substitution Decision Maker")){
				assertTrue(click(selenium,rdoSubstitutionMark),"Could not select the susbstitution maker; More Details :" + updateconsentData.toString(), selenium, ClassName, MethodName);
				selectValueFromAjaxList(selenium,ajkRelationship,updateconsentData.relationship);
				assertTrue(type(selenium,txtFirstName,updateconsentData.firstName),"Could not enter the first name; More Details :" + updateconsentData.toString(), selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtLastName,updateconsentData.lastName),"Could not enter last name; More Details :" + updateconsentData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click Save Button; More Details :" +updateconsentData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			}
			click(selenium,lnkEditConsents);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//	
			//  Step-9: Verify stored values
			//--------------------------------------------------------------------//	
				assertTrue(verifyStoredValuesUpdateNewConsents(selenium,updateconsentData),"Consent details not saved properly; More Details :"+ updateconsentData.toString(), selenium, ClassName, MethodName);
					return returnValue;
			}
			catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
			return returnValue;
		}
	
	
}
