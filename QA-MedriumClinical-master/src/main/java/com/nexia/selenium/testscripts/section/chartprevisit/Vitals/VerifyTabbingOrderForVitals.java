package com.nexia.selenium.testscripts.section.chartprevisit.Vitals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForVitals extends AbstractChartPreVisit{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to verify tabbing order")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForVitals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalData = new ChartPreVisitLib();
		vitalData.workSheetName = "CreateVitals";
		vitalData.testCaseId = "TC_CV_038";
		vitalData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTabbingOrderForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalData);
	}
	/**
	 * verifyTabbingOrderForVitals
	 * Function to verify tabbing order
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 28, 2012
	 */	
	public void verifyTabbingOrderForVitals(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,ChartPreVisitLib vitalData) throws InterruptedException, IOException{
		Selenium selenium = null;
		try{
			String csspaths[]={txtHeight, ajxHeight, txtWeight, ajxWeighUnit, txtSystolic, txtdiastolic, ajxPosition, ajxLimb, ajxCuffsize, txtTime, txtheartRate, ajxdescription, ajxrhythm};
			String csspaths1[]={txtHeight, ajxHeight, txtWeight, ajxWeighUnit, txtSystolic,txtdiastolic, ajxPosition,ajxLimb,ajxCuffsize,txtTime,txtheartRate,ajxdescription, ajxrhythm,ajxTempUnit, ajxTempLocation, txtBloodSugar, ajxBloodSugar, txtRespiratory, ajxRespiratory, txtOxygen, txtPefr, ajxPefr, txtPefrTime};
				
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + vitalData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, vitalData.userName, vitalData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID                           //
			//--------------------------------------------------------------------//
			System.out.print(vitalData.patientId);
			searchPatientNexiaForProviderHomePage(selenium,vitalData.patientId);
			waitForPageLoad(selenium);
			//unable to add vitals in the summary page. So Update the script with the begin encounter script.
			goToBeginEncounter(selenium);
			//---------------------------------------------------------- ---------//
			//  Step-3: Navigate to vitals                                        //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkVitals),"Could not click the vitals link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Tab order                                                  //
			//--------------------------------------------------------------------//
			for(int i =0;i<csspaths.length;i++){
				assertTrue(isElementPresent(selenium,csspaths[i]),"Not found",selenium,ClassName,MethodName);
				selenium.focus(csspaths[i]);
				waitForElementToEnable(selenium,csspaths[i]);
				selenium.keyPress(csspaths[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths[i]));
			}
			
			//--------------------------------------------------------------------//
			//  Step-5:Tab order after click on show more details                 //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkVitalShowmore),"Could not click show mor details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			for(int i =0;i<csspaths1.length;i++){
				assertTrue(isElementPresent(selenium,csspaths1[i]),"Not found",selenium,ClassName,MethodName);
				selenium.focus(csspaths1[i]);
				waitForElementToEnable(selenium,csspaths1[i]);
				selenium.keyPress(csspaths1[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths1[i]));
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)");
		}
	}
}
