package com.nexia.selenium.testscripts.section.systemsettings.patientimport;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyElectronicDataImportAllergy extends AbstractSystemSettingsTest {
	String fName=null;
	String lName=null;
	String onSetDate[]=new String[10];
	String intollerance[]=new String[10];
	String allergen[]=new String[10];
	String productCode[]=new String[10];
	String allergyReaction[]=new String[10];
	String reactionCode[]=new String[10];
	String allergySeverityCoded[]=new String[10];
	String allergySeverityText[]=new String[10];
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying cancel functionality In patient import")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientImport(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		SystemSettingsLib mandData = new SystemSettingsLib();
		mandData.workSheetName = "VerifySecurityOption";
		mandData.testCaseId = "TC_VSP_005";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCancel(seleniumHost, seleniumPort, browser, webSite,userAccount, mandData);
	}
	/**
	 * verifyCancel
	 * Function to verify Cancel in patient import
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 26, 2012
	 */
	
	public boolean verifyCancel(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount ,SystemSettingsLib mandData) throws IOException{
		Selenium selenium=null;
		
		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mandData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, mandData.userName, mandData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//----------------------------//
            // Step-2:Change Switch Role  //
            //----------------------------//
            assertTrue(switchRole(selenium,mandData.switchRole), "Switch role failed",selenium, ClassName, MethodName);
            waitForPageLoad(selenium);

			//-------------------------------------//
			//  Step-3: Navigate to import section //
			//-------------------------------------//
			assertTrue(click(selenium,lnkQuickLink),"Could not click on the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkImportPatientAction),"Could not click the systemSettings link;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//-------------------------------------//
			//  Step-4: Import and Verify the file //
			//-------------------------------------//
			File dir1 = new File (".");
			String strBasePath = null;
			String file = null;
			String xmlName = "EP_JaneAndrews_CCR.xml";		
			String sectionName = "SystemSetting";
			strBasePath=dir1.getCanonicalPath();
			
			file=strBasePath+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"nexia"+File.separator+"testdata"+File.separator+sectionName + File.separator + xmlName;
			assertTrue(type(selenium,txtPatientSearch,file),"Could not browse the patient fie;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForElement(selenium, txtFstNameImpPatient, WAIT_TIME);
			
			fName=selenium.getText(txtFstNameImpPatient);
			lName=selenium.getText(txtLstNameImpPatient);
			
			//label[contains(text(),'Allergy')]/parent::span/following-sibling::div/div[1]
			
			int validAllergy=0;
			for(int count=1;count<=5;count++){
				if(getText(selenium,"//label[contains(text(),'Allergy')]/parent::span/following-sibling::div/div["+count+"]").contains("Allergy Onset Date")){
					if(!(getText(selenium,"//label[contains(text(),'Allergy')]/parent::span/following-sibling::div/div["+count+"]").contains("Failed to map"))){
						validAllergy=validAllergy+1;
						onSetDate[validAllergy]=selenium.getText("//div/div/div[2]/div/div["+count+"]/div/div/div/div[2]");
						intollerance[validAllergy]=selenium.getText("//div/div/div[2]/div/div["+count+"]/div/div[2]/div/div[2]");
						allergen[validAllergy]=selenium.getText("//div/div/div[2]/div/div["+count+"]/div/div[3]/div/div[2]");
						productCode[validAllergy]=selenium.getText("//div["+count+"]/div/div[4]/div/div[2]/span");
						allergyReaction[validAllergy]=selenium.getText("//div[2]/div/div["+count+"]/div/div[5]/div/div[2]");
						reactionCode[validAllergy]=selenium.getText("//div[2]/div/div["+count+"]/div/div[6]/div/div[2]");
						allergySeverityCoded[validAllergy]=selenium.getText("//div[2]/div/div["+count+"]/div/div[7]/div/div[2]");
						allergySeverityText[validAllergy]=selenium.getText("//div[2]/div/div["+count+"]/div/div[8]/div/div[2]");
					
				}
				}
			}
			
			assertTrue(click(selenium,btnImport),"Could not click on the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//Search for recently imported patient
			assertTrue(type(selenium,txtSearchPatientBox,fName+" "+lName),"Could not browse the patient fie;More Details:", selenium, ClassName, MethodName);
			selenium.typeKeys(txtSearchPatientBox, "\b");
			waitForPageLoad(selenium);
			click(selenium,lblPatientResult);
			waitForPageLoad(selenium);
			
			
			//Navigate to export chart section
			assertTrue(click(selenium,lnkPatientOptions),"Could not Click on patient Options"+ mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblPatientOptionsExportChart),"Could not Click on Export chart option"+ mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//If all the allergy is not valid, Then we set the default allergy value to the allergy details
			if(validAllergy==0){
				onSetDate[1]="-";
				intollerance[1]="-";
				allergen[1]="-";
				productCode[1]="-";
				allergyReaction[1]="-";
				reactionCode[1]="-";
				allergySeverityCoded[1]="-";
				allergySeverityText[1]="-";
				validAllergy=1;
			}
			
			assertTrue(verifyExportChartVAlue(selenium,validAllergy),"Could not match with imported patient information"+ mandData.toString(), selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	private boolean verifyExportChartVAlue(Selenium selenium,int validAllergy) {
		
		if(selenium.isElementPresent("saveBtn")){
			for(int count=1;count<=validAllergy;count++){
			
			if(!(selenium.getText("xpath=(//div[@id='AllergyOnsetDate_Div'])["+count+"]").equalsIgnoreCase(onSetDate[count]))){
				return false;
			}
			if(!(selenium.getText("xpath=(//div[@id='Allergy/Intolerance_Div'])["+count+"]").equalsIgnoreCase(intollerance[count]))){
				return false;
			}
			if(!(selenium.getText("xpath=(//div[@id='Allergen_Div'])["+count+"]").equalsIgnoreCase(allergen[count]))){
				return false;
			}
			if(!(selenium.getText("xpath=(//div[@id='ProductCoded_Div'])["+count+"]").equalsIgnoreCase(productCode[count]))){
				return false;
			}
			if(!(selenium.getText("xpath=(//div[@id='AllergyReaction_Div'])["+count+"]").equalsIgnoreCase(allergyReaction[count]))){
				return false;
			}
			if(!(selenium.getText("xpath=(//div[@id='AllergySeverity-Coded_Div'])["+count+"]").equalsIgnoreCase(reactionCode[count]))){
				return false;
			}
			if(!(selenium.getText("xpath=(//div[@id='AllergySeverity-Text_Div'])["+count+"]").equalsIgnoreCase(allergySeverityCoded[count]))){
				return false;
			}
			if(!(selenium.getText("xpath=(//div[@id='ReactionCoded_Div'])["+count+"]").equalsIgnoreCase(allergySeverityText[count]))){
				return false;
			}
			}
			
		}
		return true;
	}
	
}
