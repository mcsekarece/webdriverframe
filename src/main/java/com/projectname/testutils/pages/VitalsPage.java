package com.projectname.testutils.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.ClinicalSettingLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;


public class VitalsPage extends SeleniumWebDriver{
	private By readyLocator = By.id("heightSuggestBoxsuggestBox");

	private By  txtheight=By.id("height");
	private By  ajxHeightSuggest = By.id("heightSuggestBoxsuggestBox");
	private By  txtWeight = By.id("weight");
	private By  ajxWeightSuggest = By.id("weightSuggestBoxsuggestBox");
	private By  txtWaist = By.id("waist");
	private By  ajxWaistSuggestBox = By.id("waistSuggestBoxsuggestBox");
	private By  txtSystolic = By.id("systolic");
	private By  txtDiastolic = By.id("diastolic");
	private By  ajxPositionSuggestBox = By.id("positionSuggestBoxsuggestBox");
	private By  ajxLimbSuggestBox = By.id("limbSuggestBoxsuggestBox");
	private By  ajxCuffSizeSuggestBox= By.id("cuffSizeSuggestBoxsuggestBox");
	private By  txtTime = By.id("time");
	private By  txtHeartRate = By.id("heartRate");
	private By  ajxHeartRateDescription= By.id("descriptionSuggestBoxsuggestBox");
	private By  ajxRhythmSuggestBox = By.id("rhythmSuggestBoxsuggestBox");
	private By  txtTemperature = By.id("temperature");
	private By  ajxTemperatureUnitSuggestBox = By.id("temperatureUnitSuggestBoxsuggestBox");
	private By  ajxTemperatureLocationSuggestBox = By.id("temperatureLocationSuggestBoxsuggestBox");
	private By  txtBloodSugar = By.id("bloodSugar");
	private By  ajxBloodSugarUnitSuggestBox = By.id("bloodSugarUnitSuggestBoxsuggestBox");
	private By  txtRespiratoryRate = By.id("respiratoryRate");
	private By  ajxRespiratoryRateDescription= By.id("respiratoryRateDescriptionSuggestBoxsuggestBox");
	private By  txtOxygenSaturation = By.id("oxygenSaturation");
	private By  txtPefr = By.id("pefr");
	private By  ajxPefrDescription= By.id("pefrDescriptionSuggestBoxsuggestBox");
	private By  txtPefrTime  = By.id("pefrTime");
	private By lnkUpdateVitals = By.id("add");
	private By btnDoneVitals = By.xpath("(//button[@id='doneVitalsEnc'])[2]");
	private By lnkEncounterVitals = By.xpath("(//a[contains(text(),'VITALS')])[2]");
	private By lnkShowMoreDetails = By.id("vitalsMoreDetails");
	
	private By  txtBloodSugar1 = By.xpath("//input[@id='bloodSugar']");
	private By  txtPefr1 = By.xpath("//input[@id='pefr']");
	private By  txtWaist1 = By.xpath("//input[@id='waist']");
	private By  txtOxygenSaturation1 = By.xpath("//input[@id='oxygenSaturation']");
	
	public VitalsPage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}

	/**
	 * addVitalsInEncountersummaryPage
	 * Function to add Vitals in Encounter summary page
	 * @param 	driver, vitalsData
	 * @throws IOException 
	 * @since	Mar 18,2015
	 */
	public boolean addVitals(WebDriver driver,ChartPreVisitLib vitalsData){
	try{
		if (!vitalsData.heightInCm.equals("")){
			verifyTrue(type(driver, txtheight,vitalsData.heightInCm), "Could not type height", driver);
			waitForPageLoad(driver);
			}
		if (!vitalsData.heightMU.equals("")){
		verifyTrue(selectValueFromAjaxList(driver,ajxHeightSuggest,vitalsData.heightMU),"Could not select height option as cm/inches", driver);
		waitForPageLoad(driver);
		}
		
		if (!vitalsData.weight.equals("")){
			verifyTrue(type(driver, txtWeight,vitalsData.weight), "Could not type weight", driver);
			waitForPageLoad(driver);
		}
		
		if (!vitalsData.weightMU.equals("")){
			verifyTrue(selectValueFromAjaxList(driver,ajxWeightSuggest,vitalsData.weightMU),"Could not Weight option as lbs/kgs", driver);
			waitForPageLoad(driver);
		}
		
		verifyTrue(click(driver, lnkShowMoreDetails), "Could not Click lnk Show More Details", driver);
		waitForPageLoad(driver);

		if (!vitalsData.waist.equals("")){
			verifyTrue(type(driver, txtWaist,vitalsData.waist), "Could not type waist", driver);
			waitForPageLoad(driver);
		}
		
		if (!vitalsData.waistMU.equals("")){
			verifyTrue(selectValueFromAjaxList(driver,ajxWaistSuggestBox,vitalsData.waistMU),"Could not waist option as waist", driver);
			waitForPageLoad(driver);
		}
		

		if (!vitalsData.systolicRate.equals("")){
			verifyTrue(type(driver, txtSystolic,vitalsData.systolicRate), "Could not type systolic Rate", driver);
			waitForPageLoad(driver);
		}
		

		if (!vitalsData.diastolicRate.equals("")){
			verifyTrue(type(driver, txtDiastolic,vitalsData.diastolicRate), "Could not type diastolic Rate", driver);
			waitForPageLoad(driver);
		}
		
		if (!vitalsData.position.equals("")){
			verifyTrue(selectValueFromAjaxList(driver,ajxPositionSuggestBox,vitalsData.position),"Could not select blood pressure option position", driver);
			waitForPageLoad(driver);
		}
		
		if (!vitalsData.limb.equals("")){
			verifyTrue(selectValueFromAjaxList(driver,ajxLimbSuggestBox,vitalsData.limb),"Could not select blood pressure option limb", driver);
			waitForPageLoad(driver);
		}
		
		if (!vitalsData.cuffSize.equals("")){
			verifyTrue(selectValueFromAjaxList(driver,ajxCuffSizeSuggestBox,vitalsData.cuffSize),"Could not select blood pressure option cuffSize", driver);
			waitForPageLoad(driver);
		}
		
		
		if (!vitalsData.time.equals("")){
			verifyTrue(type(driver, txtTime,vitalsData.time), "Could not type time", driver);
			waitForPageLoad(driver);
		}
		
		if (!vitalsData.bPM.equals("")){
			verifyTrue(type(driver,txtHeartRate,vitalsData.bPM), "Could not type heart rate BPM ", driver);
			waitForPageLoad(driver);
		}
		
		if (!vitalsData.description.equals("")){
			verifyTrue(selectValueFromAjaxList(driver,ajxHeartRateDescription,vitalsData.description), "Could not type heart rate description ", driver);
			waitForPageLoad(driver);
		}
		
		if (!vitalsData.rhythm.equals("")){
			verifyTrue(selectValueFromAjaxList(driver,ajxRhythmSuggestBox,vitalsData.rhythm), "Could not type heart rate rhythm ", driver);
			waitForPageLoad(driver);
		}
		
		if (!vitalsData.temperature.equals("")){
			verifyTrue(type(driver,txtTemperature,vitalsData.temperature), "Could not type temperature ", driver);
			waitForPageLoad(driver);
		}
		
		if (!vitalsData.tempRU.equals("")){
			verifyTrue(selectValueFromAjaxList(driver,ajxTemperatureUnitSuggestBox,vitalsData.tempRU), "Could not select Temperature Unit Suggest Box ", driver);
			waitForPageLoad(driver);
		}
		
		if (!vitalsData.location.equals("")){
			verifyTrue(selectValueFromAjaxList(driver,ajxTemperatureLocationSuggestBox,vitalsData.location), "Could not select Temperature Location Suggest Box ", driver);
			waitForPageLoad(driver);
		}
		
		if (!vitalsData.bloodSuger.equals("")){
			verifyTrue(type(driver,txtBloodSugar,vitalsData.bloodSuger), "Could not type blood sugar ", driver);
			waitForPageLoad(driver);
		}
		
		if (!vitalsData.bSUnit.equals("")){
			verifyTrue(selectValueFromAjaxList(driver,ajxBloodSugarUnitSuggestBox,vitalsData.bSUnit), "Could not select blood Unit Suggest Box ", driver);
			waitForPageLoad(driver);
		}

		if (!vitalsData.repositoryRate.equals("")){
			verifyTrue(type(driver,txtRespiratoryRate,vitalsData.repositoryRate), "Could not type repository Rate ", driver);
			waitForPageLoad(driver);
		}
		
		if (!vitalsData.rR_BPM.equals("")){
			verifyTrue(selectValueFromAjaxList(driver,ajxRespiratoryRateDescription,vitalsData.rR_BPM), "Could not select Repository rate Unit Suggest Box ", driver);
			waitForPageLoad(driver);
		}
		if (!vitalsData.oxygenSaturation.equals("")){
			verifyTrue(type(driver,txtOxygenSaturation,vitalsData.oxygenSaturation), "Could not type oxygen Saturation ", driver);
			waitForPageLoad(driver);
		}
		if (!vitalsData.pEFR.equals("")){
			verifyTrue(type(driver,txtPefr,vitalsData.pEFR), "Could not type PEFR ", driver);
			waitForPageLoad(driver);
		}
		
		verifyTrue(click(driver, lnkUpdateVitals), "Could not Click update vitals button", driver);
		waitForPageLoad(driver);
		verifyTrue(click(driver, btnDoneVitals), "Could not click done vitals button", driver);
		waitForPageLoad(driver);
		
	}catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	}
		return true;
}
	
	/**
	 * removeVitalsInEncountersummaryPage
	 * Function to remove Vitals in Encounter summary page
	 * @param 	driver
	 * @throws IOException 
	 * @since	Apr 29,2015
	 */
	public boolean removeEncounterVitals(WebDriver driver){
	try{
		waitForPageLoad(driver);
		      verifyTrue(type(driver, txtheight," "), "Could not remove height", driver);
		      waitForPageLoad(driver);
		      waitForPageLoad(driver);
		
		      verifyTrue(selectValueFromAjaxList(driver,ajxHeightSuggest,""),"Could not empty height option as cm/inches", driver);
		      waitForPageLoad(driver);
	

		     verifyTrue(type(driver, txtWeight," "), "Could not empty weight", driver);
		     waitForPageLoad(driver);
		
			verifyTrue(selectValueFromAjaxList(driver,ajxWeightSuggest,""),"Could not empty Weight option as lbs/kgs", driver);
			waitForPageLoad(driver);
		
				
		     verifyTrue(click(driver, lnkShowMoreDetails), "Could not Click lnk Show More Details", driver);
			 waitForPageLoad(driver);
			
			verifyTrue(type(driver, txtWaist1," "), "Could not empty waist", driver);
			waitForPageLoad(driver);
	
			verifyTrue(type(driver, txtSystolic," "), "Could not empty  systolic Rate", driver);
			waitForPageLoad(driver);

			verifyTrue(type(driver, txtDiastolic," "), "Could not empty diastolic Rate", driver);
			waitForPageLoad(driver);

			verifyTrue(type(driver,txtHeartRate," "), "Could not empty heart rate BPM ", driver);
			waitForPageLoad(driver);
	
			verifyTrue(type(driver,txtTemperature," "), "Could not empty temperature ", driver);
			waitForPageLoad(driver);
		
			verifyTrue(type(driver,txtBloodSugar1," "), "Could not empty blood sugar ", driver);
			waitForPageLoad(driver);
		
			verifyTrue(type(driver,txtRespiratoryRate," "), "Could not empty repository Rate ", driver);
			waitForPageLoad(driver);

			verifyTrue(type(driver,txtOxygenSaturation1," "), "Could not empty oxygen Saturation ", driver);
			waitForPageLoad(driver);

			verifyTrue(type(driver,txtPefr1," "), "Could not empty PEFR ", driver);
			
			waitForPageLoad(driver);
		
	   	verifyTrue(click(driver, lnkUpdateVitals), "Could not Click update vitals button", driver);
		waitForPageLoad(driver);
		verifyTrue(click(driver, btnDoneVitals), "Could not click done vitals button", driver);
		waitForPageLoad(driver);
		
	}catch (Exception e) {
		new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );		
	}
		return true;
}
	
	
}
