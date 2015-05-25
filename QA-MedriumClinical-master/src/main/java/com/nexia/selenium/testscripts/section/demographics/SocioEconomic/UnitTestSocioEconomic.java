package com.nexia.selenium.testscripts.section.demographics.SocioEconomic;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestSocioEconomic extends AbstractHomeTest {
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "RaceOther With Special characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void raceOtherWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest sEconomicData= new HomeLibUnitTest();
		sEconomicData.workSheetName = "UnitTest_FV_PC_SocioEconomic";
		sEconomicData.testCaseId = "TC_SE_001";
		sEconomicData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addSocioEconomic(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "ReligionOther With Special characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void religionOtherWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest sEconomicData= new HomeLibUnitTest();
		sEconomicData.workSheetName = "UnitTest_FV_PC_SocioEconomic";
		sEconomicData.testCaseId = "TC_SE_002";
		sEconomicData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addSocioEconomic(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "CitizenshipOther With Special characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void citizenshipOtherWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest sEconomicData= new HomeLibUnitTest();
		sEconomicData.workSheetName = "UnitTest_FV_PC_SocioEconomic";
		sEconomicData.testCaseId = "TC_SE_003";
		sEconomicData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addSocioEconomic(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Interpreter With Special characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void interpreterWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest sEconomicData= new HomeLibUnitTest();
		sEconomicData.workSheetName = "UnitTest_FV_PC_SocioEconomic";
		sEconomicData.testCaseId = "TC_SE_004";
		sEconomicData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addSocioEconomic(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Number of people Supported With Special characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void numberOfPeopleSupportedWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest sEconomicData= new HomeLibUnitTest();
		sEconomicData.workSheetName = "UnitTest_FV_PC_SocioEconomic";
		sEconomicData.testCaseId = "TC_SE_005";
		sEconomicData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addSocioEconomic(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Comments with Max Length")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void commentsWithMaxLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest sEconomicData= new HomeLibUnitTest();
		sEconomicData.workSheetName = "UnitTest_FV_PC_SocioEconomic";
		sEconomicData.testCaseId = "TC_SE_006";
		sEconomicData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addSocioEconomic(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "RaceOther With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void raceOtherWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest sEconomicData= new HomeLibUnitTest();
		sEconomicData.workSheetName = "UnitTest_FV_PC_SocioEconomic";
		sEconomicData.testCaseId = "TC_SE_007";
		sEconomicData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addSocioEconomic(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "ReligionOther With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void religionOtherWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest sEconomicData= new HomeLibUnitTest();
		sEconomicData.workSheetName = "UnitTest_FV_PC_SocioEconomic";
		sEconomicData.testCaseId = "TC_SE_008";
		sEconomicData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addSocioEconomic(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "CitizenshipOther With Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void citizenshipOtherWithEmpty(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest sEconomicData= new HomeLibUnitTest();
		sEconomicData.workSheetName = "UnitTest_FV_PC_SocioEconomic";
		sEconomicData.testCaseId = "TC_SE_009";
		sEconomicData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addSocioEconomic(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Date of Arrival With Invalid data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void dateOfArrivalWithInvalidData(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest sEconomicData= new HomeLibUnitTest();
		sEconomicData.workSheetName = "UnitTest_FV_PC_SocioEconomic";
		sEconomicData.testCaseId = "TC_SE_010";
		sEconomicData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addSocioEconomic(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Education Level With Other With Special characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void educationLevelOtherWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest sEconomicData= new HomeLibUnitTest();
		sEconomicData.workSheetName = "UnitTest_FV_PC_SocioEconomic";
		sEconomicData.testCaseId = "TC_SE_011";
		sEconomicData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addSocioEconomic(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicData);
	}
	@Test(groups = {"RegressionUSUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "Current House hold With Other With Special characters")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void currentHouseholdOtherWithSpecialCharacters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest sEconomicData= new HomeLibUnitTest();
		sEconomicData.workSheetName = "UnitTest_FV_PC_SocioEconomic";
		sEconomicData.testCaseId = "TC_SE_012";
		sEconomicData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		addSocioEconomic(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify unit test for Socio Economic
	* @action 		  verifying unit test for Socio Economic
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 09, 2012
	***************************************************************************************************/
	public boolean addSocioEconomic(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,HomeLibUnitTest sEconomicData) throws IOException{
		
		Selenium selenium = null;
		String alertText="";
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			// Step-1:Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + sEconomicData.toString());
			loginForNexiaFromPublicSite(selenium, userAccount, sEconomicData.userName, sEconomicData.userPassword);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,sEconomicData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Search for a patient  //
			//--------------------------------------------------------------------//
			/*waitForElement(selenium, registerPatient, 6000);
			if (isElementPresent(selenium, registerPatient))*/
			searchPatientNexia(selenium,sEconomicData.patientID);
			waitForPageLoad(selenium);
			
			click(selenium,lnkSocioEconomics);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-4: Edit Socio-Economic for a patient //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnEdit),"Could not Click on edit Button:"+ sEconomicData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:  Enter Test Data and Submit                               //
			//--------------------------------------------------------------------//
			try {
				if(!addsEconomic(selenium, sEconomicData) && sEconomicData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).contains("yes")){
					if(isElementPresent(selenium,"//p")){
						alertText = getText(selenium, "//p");
						if(alertText.toLowerCase(new java.util.Locale("en", "US")).startsWith(sEconomicData.alertMessage.trim().toLowerCase(new java.util.Locale("en", "US"))))
						{
				   			return returnValue;			
						}else{
							Assert.fail("An unxpected Alert is displayed with message; The Expected :"+sEconomicData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + sEconomicData.toString());
						}
					}else{
						Assert.fail("Alert is not getting displayed; The Expected :"+sEconomicData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + sEconomicData.toString());
					}	
				}else if(sEconomicData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).equals("no")){
					return returnValue;
				}else{
					Assert.fail("Expected Alert is not displayed; The Expected :"+sEconomicData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + sEconomicData.toString());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + sEconomicData.toString());
				returnValue=false;
			}
		}	
		catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	/*************************************************************************************************** 
	* @purpose        To verify unit test for Socio Economic
	* @action 		  verifying unit test for Socio Economic
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 09, 2012
	***************************************************************************************************/
	public boolean addsEconomic(Selenium selenium, HomeLibUnitTest sEconomicData ) throws InterruptedException, IOException{
		
		try{
			if(sEconomicData.race.contains("Other")){
			selectValueFromAjaxList(selenium,ajxRaceSocio,sEconomicData.race);
			waitForPageLoad(selenium);
			waitForElementToEnable(selenium, txtRaceOther);
			assertTrue(isElementPresent(selenium,txtRaceOther),"Could 4 not type race other value; More Details"+sEconomicData.toString(), selenium, ClassName, MethodName);
			Thread.sleep(10000);
			assertTrue(type(selenium,txtRaceOther,sEconomicData.raceOtherValue),"Could not type race other value; More Details"+sEconomicData.toString(), selenium, ClassName, MethodName);
			}
			else if(!sEconomicData.race.contains("Other")){
				selectValueFromAjaxList(selenium,ajxRaceSocio,sEconomicData.race);	
			}
			
			selectValueFromAjaxList(selenium,ajxEthniCity,sEconomicData.ethnicity);
			
			if(sEconomicData.religion.contains("Other")){
				selectValueFromAjaxList(selenium,ajxReligion,sEconomicData.religion);
				assertTrue(type(selenium,txtReligionOther,sEconomicData.religionOtherValue),"Could not type race other value; More Details"+sEconomicData.toString(), selenium, ClassName, MethodName);
			}
			else if(!sEconomicData.religion.contains("Other")){
				selectValueFromAjaxList(selenium,ajxReligion,sEconomicData.religion);	
			}
			
			if(sEconomicData.citizenship.contains("Other")){
				selectValueFromAjaxList(selenium,ajxCitizenship,sEconomicData.citizenship);
				assertTrue(type(selenium,txtCitizenshipOther,sEconomicData.citizenshipOtherValue),"Could not type race other value; More Details"+sEconomicData.toString(), selenium, ClassName, MethodName);
			}
			else if(!sEconomicData.citizenship.contains("Other")){
				selectValueFromAjaxList(selenium,ajxCitizenship,sEconomicData.citizenship);	
			}
			selectValueFromAjaxList(selenium,ajxCountry,sEconomicData.countryPanel);
			selectValueFromAjaxList(selenium,ajxLanguageSpoken,sEconomicData.languagespoken);
			assertTrue(enterDate(selenium,txtDateOfArrival,sEconomicData.arrivalDate),"could not enter the date; More Details :"+sEconomicData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxSpokenLanguage,sEconomicData.languagePanel);
			if(sEconomicData.interpreterrequired.trim().toLowerCase(new java.util.Locale("en", "US")).contains("yes")){
				if(!isElementPresent(selenium,lblInterupter))
                assertTrue(click(selenium,chkInterupterRequired),"Could not check the Interpreter check box, Expected value for check box:"+sEconomicData.interpreterrequired, selenium, ClassName, MethodName);
                assertTrue(type(selenium,txtInterupterName,sEconomicData.interpreter),"Could not type interpreter; More Details"+sEconomicData.toString(), selenium, ClassName, MethodName);

                }else if(sEconomicData.interpreterrequired.trim().toLowerCase(new java.util.Locale("en", "US")).contains("No")){
                	 assertTrue(click(selenium,chkInterupterRequired),"Could not check the Interpreter check box, Expected value for check box:"+sEconomicData.interpreterrequired, selenium, ClassName, MethodName);
                }
			selectValueFromAjaxList(selenium,ajxParentEthnicity,sEconomicData.parentEthnicityPanel);
			selectValueFromAjaxList(selenium,ajxLiveArrangements,sEconomicData.livingArrangement);
			selectValueFromAjaxList(selenium,ajxStudentStatus,sEconomicData.studentStatus);
			
			if(sEconomicData.educationLevel.contains("Other")){
				selectValueFromAjaxList(selenium,ajxEducationLevel,sEconomicData.educationLevel);
				assertTrue(type(selenium,txtEducationLevel,sEconomicData.educationLevelOtherValue),"Could not find other option for education level; More Details"+sEconomicData.toString(), selenium, ClassName, MethodName);
			}
			else if(!sEconomicData.educationLevel.contains("Other")){
				selectValueFromAjaxList(selenium,ajxEducationLevel,sEconomicData.educationLevel);	
			}
			
			selectValueFromAjaxList(selenium,ajxHouseHoldIncome,sEconomicData.householdIncome);
			assertTrue(type(selenium,txtPeopleNumber,sEconomicData.numPeopleText),"Could not type number of people; More Details"+sEconomicData.toString(), selenium, ClassName, MethodName);
			
			if(sEconomicData.householdComposition.contains("Other")){
				selectValueFromAjaxList(selenium,ajxHouseHoldIncome,sEconomicData.householdComposition);
				assertTrue(type(selenium,txtHouseHold,sEconomicData.householdCompositionOtherValue),"Could not find other option for house hold compostion; More Details"+sEconomicData.toString(), selenium, ClassName, MethodName);
			}
			else if(!sEconomicData.householdComposition.contains("Other")){
				selectValueFromAjaxList(selenium,ajxHouseHoldIncome,sEconomicData.householdComposition);	
			}
			selectValueFromAjaxList(selenium,ajxHouseHoldIncome,sEconomicData.householdComposition);
			if(sEconomicData.homelessIndicatorCheck.equals("Yes")){
				assertTrue(click(selenium,chkHouseHoldIndicator),"could not click the homeless check box;More Details:"+sEconomicData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxHouseLess,sEconomicData.homelessStatus);
			}
			if(sEconomicData.ssi.equals("Yes")){
				assertTrue(click(selenium,chkSSI),"could not click the ssi check box;More Details:"+sEconomicData.toString(), selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium,ajxEmployeement,sEconomicData.employmentStatus);
			assertTrue(type(selenium,txtComments,sEconomicData.comments1),"Could not type comments; More Details"+sEconomicData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click Validate Button; More Details"+sEconomicData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnCancl)){
				return false;
			}
		
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;
	}
}


