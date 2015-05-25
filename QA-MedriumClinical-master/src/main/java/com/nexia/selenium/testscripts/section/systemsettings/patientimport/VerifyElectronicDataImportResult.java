package com.nexia.selenium.testscripts.section.systemsettings.patientimport;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyElectronicDataImportResult extends AbstractSystemSettingsTest {
	String fName=null;
	String lName=null;
	String resultId[]=new String[10];
	String resultDateTime[]=new String[10];
	String type[]=new String[10];
	String status[]=new String[10];
	String value[]=new String[10];
	String comments[]=new String[10];
	String referenceRange[]=new String[10];
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying imported result In patient import")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientImport(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		SystemSettingsLib mandData = new SystemSettingsLib();
		mandData.workSheetName = "VerifySecurityOption";
		mandData.testCaseId = "TC_VSP_005";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyResult(seleniumHost, seleniumPort, browser, webSite,userAccount, mandData);
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
	
	public boolean verifyResult(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, SystemSettingsLib mandData) throws IOException{
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
            assertTrue(switchRole(selenium,mandData.switchRole),"Switch role failed",selenium, ClassName, MethodName);
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
			
			int validProblemList=0;
			for(int count=1;count<=10;count++){

				if(getText(selenium,"//label[contains(text(),'Result')]/parent::span/following-sibling::div/div["+count+"]").contains("Result ID")){
					if(!(getText(selenium,"//label[contains(text(),'Result')]/parent::span/following-sibling::div/div["+count+"]").contains("Failed to map"))){
						validProblemList=validProblemList+1;
						
						resultId[validProblemList]=selenium.getText("//div[6]/div/div["+count+"]/div/div[1]/div/div[2]");
						resultDateTime[validProblemList]=selenium.getText("//div[6]/div/div["+count+"]/div/div[2]/div/div[2]");
						type[validProblemList]=selenium.getText("//div[6]/div/div["+count+"]/div/div[3]/div/div[2]");
						status[validProblemList]=selenium.getText("//div[6]/div/div["+count+"]/div/div[4]/div/div[2]");
						value[validProblemList]=selenium.getText("//div[6]/div/div["+count+"]/div/div[5]/div/div[2]");
						comments[validProblemList]=selenium.getText("//div[6]/div/div["+count+"]/div/div[6]/div/div[2]");
						referenceRange[validProblemList]=selenium.getText("//div[6]/div/div["+count+"]/div/div[7]/div/div[2]");
						
					}
				}
				else{
					break;
				}
			}
			
			assertTrue(click(selenium,btnImport),"Could not click on the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//Search for recently imported patient
			assertTrue(type(selenium,txtSearchPatientBox,fName+" "+lName),"Could not browse the patient fie;More Details:", selenium, ClassName, MethodName);
			selenium.typeKeys(txtSearchPatientBox, "\b");
			waitForPageLoad(selenium);
			/*if(selenium.isEditable("css=button.searchArrowDown")){
				selenium.click("css=button.searchArrowDown");
			}*/
			//div[2]/div/div/div[10]/div
			click(selenium,lblPatientResult);
			waitForPageLoad(selenium);
			
			
			//Navigate to export chart section
			assertTrue(click(selenium,lnkPatientOptions),"Could not Click on patient Options"+ mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblPatientOptionsExportChart),"Could not Click on Export chart option"+ mandData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//If all the problem list is not valid, Then we set the default allergy value to the allergy details
			if(validProblemList==0){
				resultId[1]="-";
				resultDateTime[1]="-";
				type[1]="-";
				status[1]="-";
				value[1]="-";
				comments[1]="-";
				referenceRange[1]="-";
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
		
		if(selenium.isElementPresent(txtResultSection)){
			for(int count=1;count<=validAllergy;count++){
			if(!(selenium.getText("//div[6]/div/div["+count+"]/div[1]/div/div[2]").contains(resultId[count]))){
				return false;
			}
		/*	if(!(selenium.getText("//div[3]/div/div["+count+"]/div[2]/div/div[2]").equalsIgnoreCase(resultDateTime[count]))){
				return false;
			}*/
			if(!(selenium.getText("//div[6]/div/div["+count+"]/div[3]/div/div[2]").contains(type[count]))){
				return false;
			}
			/*if(!(selenium.getText("//div[6]/div/div["+count+"]/div[4]/div/div[2]").contains(status[count]))){
				return false;
			}*/
			/*if(!(selenium.getText("//div[6]/div/div["+count+"]/div[5]/div/div[2]").contains(value[count]))){
				return false;
			}*/
			if(!(selenium.getText("//div[6]/div/div["+count+"]/div[6]/div/div[2]").contains(comments[count]))){
				return false;
			}
			/*if(!(selenium.getText("//div[6]/div/div["+count+"]/div[7]/div/div[2]").contains(referenceRange[count]))){
				return false;
			}*/
			}
			
		}
		return true;
	}
	
}
