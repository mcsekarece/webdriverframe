package com.nexia.selenium.testscripts.section.chartprevisit.OrderLabDiReferral;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAssessmentInDiOrder extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Assessment In Di Order(")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAssessmentInDiOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib orderData = new ChartPreVisitLib();
		orderData.workSheetName = "CreateDiganosticImaging";
		orderData.testCaseId = "TC_ODI_006";
		orderData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAssessmentInDiOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, orderData);
	}
	/**
	 * verifyAssessmentInDiOrder
	 * verify assessment in Diagnostic imaging 
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @param orderData
	 * @return
	 * @throws IOException 
	 * @since Nov 30, 2012
	 */
	public boolean verifyAssessmentInDiOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib orderData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date = null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + orderData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, orderData.userName, orderData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,orderData.switchRole), "could not switch role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,orderData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Encounter from Encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,orderData),"", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate to Encounter ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementVisible(selenium,ajxProviderSugBox)){
				String str = getText(selenium, lnkTopMenu);
				String Rprovider = str.replaceAll(", " + orderData.switchRole, "");
				String tempArray[] = Rprovider.split(" ");
				String providerName = tempArray[1] + ", " + tempArray[0];

				assertTrue(selectValueFromAjaxList(selenium,ajxProviderSugBox,providerName),"ajx failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				}
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Lab Orders//
			//--------------------------------------------------------------------//
			assertTrue(deleteOrders(selenium,orderData),"Diagnostic imaging Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete Existing Assessment//
			//--------------------------------------------------------------------//
			assertTrue(deleteAssessment(selenium,orderData),"Assessment Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Create New Assessment//
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,lblHighlightAssessment,orderData.medicalCondition );
			waitForPageLoad(selenium);
			click(selenium,"//body/div[5]/div/div/div/div/div");
			assertTrue(getValue(selenium, txtMedicatl).toLowerCase().contains(orderData.medicalCondition.toLowerCase()),"", selenium, ClassName, MethodName);
			//selectValueFromAjaxList(selenium, lblHighlightAssessment, orderData.medicalCondition);
			if(userAccount.equals(CAAccount)){
				Calendar cal1=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat1.format(cal1.getTime());
			}else{
				Calendar cal2=Calendar.getInstance();
				SimpleDateFormat DateFormat2=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat2.format(cal2.getTime());
			}
			assertTrue(enterDate(selenium,txtOnset,date),"Could not enter the Admin on ;More Details:"+orderData.toString(), selenium, ClassName, MethodName);
			selectValueFromAjaxList(selenium,ajxItem,orderData.itemStatus);
			if(isElementPresent(selenium, btnAdd)){
				//assertTrue(click(selenium, btnAdd), "Could not click on add", selenium, ClassName, MethodName);
				selenium.click(btnAdd);
				waitForPageLoad(selenium);
			}
			else if(isElementPresent(selenium, btnPrbEditSave)){
				assertTrue(click(selenium, btnPrbEditSave), "Could not click on save", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate to Diagnostic Imaging Page//
			//--------------------------------------------------------------------//
			assertTrue(clickDiIcon(selenium,orderData),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Create Lab Order Page//
			//--------------------------------------------------------------------//
			assertTrue(orderNewDi(selenium,orderData),"Order Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Click on edit and verify Assessment						  //
			//--------------------------------------------------------------------//
			assertTrue(isTextPresent(selenium,orderData.medicalCondition ), "Could not click on diagnostic imaging", selenium, ClassName, MethodName);
		}
		catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
		
	}
}
