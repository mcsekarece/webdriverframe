package com.nexia.selenium.testscripts.section.demographics.SocioEconomic;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyClearFieldForSocioEconomic extends AbstractHomeTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Clear Field For SocioEconomic ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyClearFieldForSocioEconomic(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib sEconomicData = new HomeLib();
		sEconomicData.workSheetName = "NewSocioEconomic";
		sEconomicData.testCaseId = "TC_SE_001";
		sEconomicData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyClearFieldForSocioEconomic(seleniumHost, seleniumPort, browser, webSite, userAccount, sEconomicData);
	}	
	
	/*************************************************************************************************** 
	* @purpose        To verify Clear Field For SocioEconomic 
	* @action 		  verifying Clear Field For SocioEconomic 
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Apr 02, 2012
	***************************************************************************************************/
	public boolean verifyClearFieldForSocioEconomic(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib sEconomicData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + sEconomicData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, sEconomicData.userName, sEconomicData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,sEconomicData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Advanced search with Patient ID 						      //
			//--------------------------------------------------------------------//
			searchPatientNexia(selenium,sEconomicData.patientID);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Go to SocialHistory 										  //
			//--------------------------------------------------------------------//	
			click(selenium, lnkSocioEconomics);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Select SocialHistory edit button 						  //
			//--------------------------------------------------------------------//	
			click(selenium,btnEdit);
			waitForPageLoad(selenium);
				
			assertTrue(createSocioEconomic(selenium,sEconomicData, userAccount),"Socio-Economic creation Failed", selenium, ClassName, MethodName);
			
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			click(selenium,btnEdit);
			waitForPageLoad(selenium);
			
				
			//if(!verifyStoredValues(selenium,sEconomicData)){
			if(!verifyStoredValuesCreateSocioEconomics(selenium,sEconomicData, userAccount)){
			Assert.fail("Socio-Economic details not saved properly; More Details :"+ sEconomicData.toString());
				returnValue=false;
			}else
				returnValue=true;
				
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			click(selenium,btnEdit);
			waitForPageLoad(selenium);
				
			sEconomicData.workSheetName = "NewSocioEconomic";
			sEconomicData.testCaseId = "TC_SE_003";
			sEconomicData.fetchHomeTestData();
			
			//--------------------------------------------------------------------//
			//  Step-6:Socio Economic Fields are cleared and saved 				  //
			//--------------------------------------------------------------------//	
			if(!clearFieldForSocioEconomic(selenium,sEconomicData)){
				Assert.fail("Cleared field of Socio-Economic not saved properly; More Details :"+ sEconomicData.toString());
				returnValue=false;
			}else
				returnValue=true;
			
			//--------------------------------------------------------------------//
			//  Step-7:Select SocialHistory edit button							  //
			//--------------------------------------------------------------------//
			click(selenium,btnEdit);
			waitForPageLoad(selenium);
								
			if(!verifyStoredValuesClearFieldSocioEconomics(selenium,sEconomicData)){
				Assert.fail("Cleared field Socio-Economic details not saved properly; More Details :"+ sEconomicData.toString());
				returnValue=false;
			}else
				return true;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean clearFieldForSocioEconomic(Selenium selenium,HomeLib sEconomicData) throws InterruptedException, IOException{
		boolean returnValue=true;
		try{
			if(!sEconomicData.race.contains("N/A")){
				selectEmptyValue(selenium,ajxRaceSocio,sEconomicData.race );
				waitForPageLoad(selenium);}
			if(!sEconomicData.ethnicity.contains("N/A")){
				selectEmptyValue(selenium,ajxEthniCity,sEconomicData.ethnicity);
				waitForPageLoad(selenium);}
			if(!sEconomicData.religion.contains("N/A")){
				selectEmptyValue(selenium,ajxReligion,sEconomicData.religion);
				waitForPageLoad(selenium);}
			if(!sEconomicData.citizenship.contains("N/A")){
				selectEmptyValue(selenium,ajxCitizenship,sEconomicData.citizenship);
				waitForPageLoad(selenium);}
			if(!sEconomicData.countryPanel.contains("N/A")){
				selectEmptyValue(selenium,ajxCountry,sEconomicData.countryPanel);
				waitForPageLoad(selenium);}
			if(!sEconomicData.languagespoken.contains("N/A")){
				selectEmptyValue(selenium,ajxLanguageSpoken,sEconomicData.languagespoken);
				waitForPageLoad(selenium);}
			if(!sEconomicData.arrivalDate.contains("N/A")){
				assertTrue(enterDate(selenium,txtDateOfArrival,sEconomicData.arrivalDate),"could not enter the date; More Details :"+sEconomicData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);}
			if(!sEconomicData.languagePanel.contains("N/A")){
				selectEmptyValue(selenium,ajxSpokenLanguage,sEconomicData.languagePanel);
				waitForPageLoad(selenium);}
			if(isChecked(selenium, chkInterupterRequired))
				assertTrue(click(selenium,chkInterupterRequired),"Could not check the Interpreter check box, Expected value for check box:"+sEconomicData.interpreterrequired, selenium, ClassName, MethodName);
			if(!sEconomicData.parentEthnicityPanel.contains("N/A")){
				selectEmptyValue(selenium,ajxParentEthnicity,sEconomicData.parentEthnicityPanel);
				waitForPageLoad(selenium);}
			if(!sEconomicData.livingArrangement.contains("N/A")){
				selectEmptyValue(selenium,ajxLiveArrangements,sEconomicData.livingArrangement);
				waitForPageLoad(selenium);}
			if(!sEconomicData.studentStatus.contains("N/A")){
				selectEmptyValue(selenium,ajxStudentStatus,sEconomicData.studentStatus);
				waitForPageLoad(selenium);}
			if(!sEconomicData.educationLevel.contains("N/A")){
				selectEmptyValue(selenium,ajxEducationLevel,sEconomicData.educationLevel);
				waitForPageLoad(selenium);}
			if(!sEconomicData.householdIncome.contains("N/A")){
				selectEmptyValue(selenium,ajxHouseHoldIncome,sEconomicData.householdIncome);
				waitForPageLoad(selenium);}
			if(!sEconomicData.numPeopleText.contains("N/A"))
					assertTrue(type(selenium,txtPeopleNumber,sEconomicData.numPeopleText),"Could not type number of people; More Details"+sEconomicData.toString(), selenium, ClassName, MethodName);
			if(!sEconomicData.householdComposition.contains("N/A")){
				selectEmptyValue(selenium,ajxHouseHoldComposition,sEconomicData.householdComposition);
				waitForPageLoad(selenium);}
			if(!sEconomicData.homelessStatus.contains("N/A")){
				selectEmptyValue(selenium,ajxHouseLess,sEconomicData.homelessStatus);
				waitForPageLoad(selenium);}
			if(isChecked(selenium,chkHouseHoldIndicator))
				assertTrue(click(selenium, chkHouseHoldIndicator),"Could not check the homeless check box, Expected value for check box:"+sEconomicData.homelessIndicatorCheck, selenium, ClassName, MethodName);
			if(!sEconomicData.employmentStatus.contains("N/A")){
				selectEmptyValue(selenium,ajxEmployeement,sEconomicData.employmentStatus);
				waitForPageLoad(selenium);}
			if(isChecked(selenium,chkSSI))						
				assertTrue(click(selenium, chkSSI),"Could not check the ssi check box, Expected value for check box:"+sEconomicData.ssi, selenium, ClassName, MethodName);
				if(!sEconomicData.comments1.contains("N/A"))
					assertTrue(type(selenium,txtComments,sEconomicData.comments1),"Could not type comments; More Details"+sEconomicData.toString(), selenium, ClassName, MethodName);
				    waitForPageLoad(selenium);
					assertTrue(click(selenium,btnSave),"Could not click save Button; More Details"+sEconomicData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
			if(isElementPresent(selenium, lnkSocioEconomics)){
				returnValue=true;
			}else{
				returnValue= false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + sEconomicData.toString());
			Thread.sleep(10000);
		}
		return returnValue;
	}
	public boolean selectEmptyValue(Selenium selenium,String textboxName,String valueForSelection) throws InterruptedException, IOException{
		boolean returnValue=true;
		try{
			if(!textboxName.equals("") && valueForSelection.equals("") && waitForElement(selenium, textboxName, WAIT_TIME)){
			waitForElement(selenium, textboxName, 200);
			selenium.focus(textboxName);
			selenium.keyDown(textboxName, "\\46");
			selenium.keyPress(textboxName, "\\46");
			selenium.keyUp(textboxName, "\\46");
			selenium.clickAt(emptyspaceid,"");
			return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
