package com.nexia.selenium.testscripts.section.systemsettings.patientimport;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyElectronicDataImportPatientInfo extends AbstractSystemSettingsTest {
	String address=null;
	String primaryPhNo=null;
	String homePhone=null;
	String vacationPh=null;
	String businessPh=null;
	String mobilePh=null;
	String eMail=null;
	String fName=null;
	String lName=null;
	String mName=null;
	String sex=null;
	String dob=null;
	String martialStatus=null;
	String religion=null;
	String race=null;
	String enthity=null;
	
	
	
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
			assertTrue(loginForNexiaFromPublicSite(selenium,userAccount, mandData.userName, mandData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

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
			waitForElement(selenium, VfyImportPatientAddress1, WAIT_TIME);
			
			address=selenium.getText(getImportPatientAddress1);
			primaryPhNo=selenium.getText(getImportPatientPrimaryPhone);
			homePhone=selenium.getText(getImportPatientHomePhone);
			vacationPh=selenium.getText(getImportPatientVaccationPhone);
			businessPh=selenium.getText(getImportPatientBusinessPhone);
			mobilePh=selenium.getText(getImportPatientMobilePhone);
			eMail=selenium.getText(getImportPatientEmail);
			fName=selenium.getText(txtFstNameImpPatient);
			lName=selenium.getText(txtLstNameImpPatient);
			mName=selenium.getText(getImportPatientMname);
			sex=selenium.getText(getImportPatientSex);
			dob=selenium.getText(getImportPatientDOB);
			martialStatus=selenium.getText(getImportPatientMaritalStatus);
			religion=selenium.getText(getImportPatientReligion);
			race=selenium.getText(getImportPatientRace);
			enthity=selenium.getText(getImportPatientEthinity);
			
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
			
			assertTrue(verifyExportChartVAlue(selenium),"Could not match with imported patient information"+ mandData.toString(), selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	private boolean verifyExportChartVAlue(Selenium selenium) {
		
		if(selenium.isElementPresent("saveBtn")){

			if(!(selenium.getText(VfyImportPatientAddress1).equalsIgnoreCase(address))){
				return false;
			}
			if(!(selenium.getText(VfyImportPatientPrimaryPhone).equalsIgnoreCase(primaryPhNo))){
				return false;
			}
			
			if(!(selenium.getText(VfyImportPatientHomePhone).equalsIgnoreCase(homePhone))){
				return false;
			}
			/*if(!(selenium.getText(VfyImportPatientVaccationPhone).equalsIgnoreCase(vacationPh))){
				return false;
			}*/
			if(!(selenium.getText(VfyImportPatientBusinessPhone).equalsIgnoreCase(businessPh))){
				return false;
			}
			if(!(selenium.getText(VfyImportPatientMobilePhone).equalsIgnoreCase(mobilePh))){
				return false;
			}
			if(!(selenium.getText(VfyImportPatientEmail).equalsIgnoreCase(eMail))){
				return false;
			}
			if(!(selenium.getText(txtFstNameImpPatient).equalsIgnoreCase(fName))){
				return false;
			}
			if(!(selenium.getText(txtLstNameImpPatient).equalsIgnoreCase(lName))){
				return false;
			}
			if(!(selenium.getText(VfyImportPatientMname).equalsIgnoreCase(mName))){
				return false;
			}
			if(!(selenium.getText(VfyImportPatientSex).equalsIgnoreCase(sex))){
				return false;
			}
			if(!(selenium.getText(VfyImportPatientDOB).equalsIgnoreCase(dob))){
				return false;
			}
			if(!(selenium.getText(VfyImportPatientMaritalStatus).equalsIgnoreCase(martialStatus))){
				return false;
			}
			if(!(selenium.getText(VfyImportPatientReligion).equalsIgnoreCase(religion))){
				return false;
			}
			if(!(selenium.getText(VfyImportPatientRace).equalsIgnoreCase(race))){
				return false;
			}
			if(!(selenium.getText(VfyImportPatientEthinity).equalsIgnoreCase(enthity))){
				return false;
			}
		}
		return true;
	}
	
}
