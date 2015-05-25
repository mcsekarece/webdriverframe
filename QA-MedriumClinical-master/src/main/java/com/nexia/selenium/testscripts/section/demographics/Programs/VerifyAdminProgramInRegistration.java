package com.nexia.selenium.testscripts.section.demographics.Programs;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAdminProgramInRegistration extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify admin New Patient Check in Programs")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewProgramForPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib programData = new HomeLib();
		programData.workSheetName = "AdminProgram";
		programData.testCaseId = "TC_AP_001";
		programData.fetchHomeTestData();

		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		verifyAdminProgramInRegistration(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}

	/*************************************************************************************************** 
	 * @purpose        To verify admin New Patient Check in Programs
	 * @action 		  verify admin New Patient Check in Programs
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	      june 05, 2010
	 ***************************************************************************************************/
	public boolean verifyAdminProgramInRegistration(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib programData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not retrieve the new Selenium Session; More Details :" + programData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, programData.userName, programData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,programData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//-------------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to Organizational Structure //
			//-------------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSettings),"Could not click on quick action",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingAction),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(getText(selenium,lblWholeProgram).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.program1.trim().toLowerCase(new java.util.Locale("en","US")))){
				if(getText(selenium,lblProgram1).equalsIgnoreCase(programData.program1)){
					click(selenium, lblProgramOnly);
					waitForPageLoad(selenium);
				}
				else{
					int counter=(Integer)selenium.getXpathCount(lblProgram1);
					System.out.println(counter);
					while(getText(selenium,lblWholeProgram).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.program1.trim().toLowerCase(new java.util.Locale("en","US")))){
						/*if(getText(selenium,"//div[@id='programs']/table/tbody/tr["+counter+"]/td/div/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.program1.trim().toLowerCase(new java.util.Locale("en","US")))){
								click(selenium,"//div[@id='programs']/table/tbody/tr["+counter+"]/td/div/div");
								break;
							}*/
						if(getText(selenium,lblProgramTitleList + "[" +counter+ "]").toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.program1.trim().toLowerCase(new java.util.Locale("en","US")))){
							click(selenium,lblProgramTitleList + "[" +counter+ "]");
							break;
						}


						counter--;
					}
					waitForPageLoad(selenium);
				}
			}
			else{
				if(isElementPresent(selenium,chkIncludeInactive))
					click(selenium,chkIncludeInactive);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,txtProgramSearch)){
					type(selenium,txtProgramSearch, programData.program1);
					click(selenium, btnProgramSearch);

					waitForPageLoad(selenium);
				}
				
				int count = (Integer) selenium.getXpathCount(lblProgramPossition);
				while(getText(selenium,lblProgramPossition1).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.program1.trim().toLowerCase(new java.util.Locale("en","US")))){
					/*if(getText(selenium, "//div[@id='programs']/table/tbody/tr["+count+"]/td/div/div").contains(programData.program1))
						click(selenium,"//div[@id='programs']/table/tbody/tr["+count+"]/td[2]/div/a");
					break;*/
					if(getText(selenium, lblProgramTitleList + "["+count+"]").contains(programData.program1))
						click(selenium, lnkDeleteProgram + "["+count+"]" );
					break;
				}
				count--;
			}
			click(selenium,chkIncludeInactive);

			//Advanced search with Patient ID
			programData.workSheetName = "NewProgram";
			programData.testCaseId = "TC_P_004";
			programData.fetchHomeTestData();

			click(selenium,btnBackButton);
			waitForPageLoad(selenium);
			assertTrue(searchPatientNexia(selenium, programData.patientID), 
					"Could not find patient with Id " + programData.patientID, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			click(selenium,lnkProgram);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4:Deleting existing Programs for the selected patient               //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllPrograms(selenium), "Could not delete all programs", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//---------------------------------------------------------- ----------//
			//  Step-5:Create a new Program                                               //
			//---------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddPrograms),"Could not Click on Add Programs Button:"+ programData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProgram(selenium,programData,userAccount),"Program creation Failed", selenium, ClassName, MethodName);

			click(selenium,lnkEditPrograms);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-6:Verifying Entered Details are saved properly                      //
			//--------------------------------------------------------------------//
			assertTrue( verifyStoredValuesAdminProgram(selenium,programData,userAccount ),
					"Program details not saved properly; More Details :"+ programData.toString(), selenium, ClassName, MethodName);

		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}


