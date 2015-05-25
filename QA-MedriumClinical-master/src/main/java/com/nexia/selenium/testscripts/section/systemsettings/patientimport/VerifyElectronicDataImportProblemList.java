package com.nexia.selenium.testscripts.section.systemsettings.patientimport;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyElectronicDataImportProblemList extends AbstractSystemSettingsTest {
	String fName=null;
	String lName=null;
	String onSetDate[]=new String[10];
	String resolvedDate[]=new String[10];
	String type[]=new String[10];
	String name[]=new String[10];
	String code[]=new String[10];
	String provider[]=new String[10];
	String ageAtOnSet[]=new String[10];
	String causeOfDeath[]=new String[10];
	String ageAtDeath[]=new String[10];
	
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
	
	public boolean verifyCancel(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, SystemSettingsLib mandData) throws IOException{
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
            assertTrue(switchRole(selenium,mandData.switchRole1),"Switch role one failed", selenium, ClassName, MethodName);
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
			waitForElement(selenium, txtFstNameImpPatient, WAIT_TIME);
			
			fName=selenium.getText(txtFstNameImpPatient);
			lName=selenium.getText(txtLstNameImpPatient);
			
			
			
			int validProblemList=0;
			for(int count=1;count<=5;count++){
				if(getText(selenium,"//label[contains(text(),'Problems')]/parent::span/following-sibling::div/div["+count+"]").contains("Problem Onset Date")){
					if(!(getText(selenium,"//label[contains(text(),'Problems')]/parent::span/following-sibling::div/div["+count+"]").contains("Failed to map"))){
						validProblemList=validProblemList+1;
						onSetDate[validProblemList]=selenium.getText("//div[3]/div/div/div/div[3]/div/div["+count+"]/div/div/div/div[2]");
						resolvedDate[validProblemList]=selenium.getText("//div[3]/div/div/div/div[3]/div/div["+count+"]/div/div[2]/div/div[2]");
						type[validProblemList]=selenium.getText("//div[3]/div/div/div/div[3]/div/div["+count+"]/div/div[3]/div/div[2]");
						name[validProblemList]=selenium.getText("//div[3]/div/div/div/div[3]/div/div["+count+"]/div/div[4]/div/div[2]");
						code[validProblemList]=selenium.getText("//div[3]/div/div/div/div[3]/div/div["+count+"]/div/div[5]/div/div[2]");
						provider[validProblemList]=selenium.getText("//div[3]/div/div/div/div[3]/div/div["+count+"]/div/div[6]/div/div[2]");
						ageAtOnSet[validProblemList]=selenium.getText("//div[3]/div/div/div/div[3]/div/div["+count+"]/div/div[7]/div/div[2]");
						causeOfDeath[validProblemList]=selenium.getText("//div[3]/div/div/div/div[3]/div/div["+count+"]/div/div[8]/div/div[2]");
						ageAtDeath[validProblemList]=selenium.getText("//div[3]/div/div/div/div[3]/div/div["+count+"]/div/div[9]/div/div[2]");
					
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
			
			//If all the problem list is not valid, Then we set the default allergy value to the allergy details
			if(validProblemList==0){
				onSetDate[1]="-";
				resolvedDate[1]="-";
				type[1]="-";
				name[1]="-";
				code[1]="-";
				provider[1]="-";
				ageAtOnSet[1]="-";
				causeOfDeath[1]="-";
				ageAtDeath[1]="-";
				validProblemList=1;
			}
			
			assertTrue(verifyExportChartVAlue(selenium,validProblemList),"Could not match with imported patient information"+ mandData.toString(), selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	private boolean verifyExportChartVAlue(Selenium selenium,int validAllergy) {
		
		if(selenium.isElementPresent("saveBtn")){
			for(int count=1;count<=validAllergy;count++){
			if(!(selenium.getText("xpath=(//div[@id='ProblemOnsetDate_Div'])["+count+"]").equalsIgnoreCase(onSetDate[count]))){
				return false;
			}
			if(!(selenium.getText("xpath=(//div[@id='ProblemResolvedDate_Div'])["+count+"]").equalsIgnoreCase(resolvedDate[count]))){
				return false;
			}
			if(!(selenium.getText("xpath=(//div[@id='ProblemType_Div'])["+count+"]").equalsIgnoreCase(type[count]))){
				return false;
			}
			if(!(selenium.getText("xpath=(//div[@id='ProblemName_Div'])["+count+"]").equalsIgnoreCase(name[count]))){
				return false;
			}
			/*if(!(selenium.getText("//div[3]/div/div["+count+"]/div[5]/div/div[2]").equalsIgnoreCase(code[count]))){
				return false;
			}*/
			if(!(selenium.getText("xpath=(//div[@id='TreatingProvider_Div'])["+count+"]").equalsIgnoreCase(provider[count]))){
				return false;
			}
			/*if(!(selenium.getText("//div[3]/div/div["+count+"]/div[7]/div/div[2]").equalsIgnoreCase(ageAtOnSet[count]))){
				return false;
			}*/
			if(!(selenium.getText("xpath=(//div[@id='CauseofDeath_Div'])["+count+"]").equalsIgnoreCase(causeOfDeath[count]))){
				return false;
			}
			if(!(selenium.getText("xpath=(//div[@id='AgeatDeath_Div'])["+count+"]").equalsIgnoreCase(ageAtDeath[count]))){
				return false;
			}
			}
			
		}
		return true;
	}
	
}
