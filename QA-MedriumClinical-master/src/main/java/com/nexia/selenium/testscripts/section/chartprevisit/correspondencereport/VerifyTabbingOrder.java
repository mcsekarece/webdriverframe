package com.nexia.selenium.testscripts.section.chartprevisit.correspondencereport;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrder extends AbstractChartPreVisit {


	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Time line")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabs(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib corresData = new ChartPreVisitLib();
		corresData.workSheetName = "CreateCorresReport";
		corresData.testCaseId = "TC_CCR_018";
		corresData.fetchChartPreVisitTestData();		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();		
		createCorresReport(seleniumHost, seleniumPort, browser, webSite, userAccount, corresData);
	}
	
	public boolean createCorresReport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib corresData) throws IOException, AWTException, InterruptedException{
		Selenium selenium=null;	
	
	
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + corresData.toString());
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, corresData.userName, corresData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
		//--------------------------------------------------------------------//
		//  Step-2:Navigate to Correspondence Report 
		//--------------------------------------------------------------------//		
		assertTrue(navigateToCorresReport(selenium,corresData),"Could not Navigate to File document",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		//--------------------------------------------------------------------//
		//  Step-3:Upload any file and check tabbing 
		//--------------------------------------------------------------------//	
		assertTrue(navigateToCorresWindow(selenium,corresData),"Could not Navigate to Create correspondence  window",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		//--------------------------------------------------------------------//
		//  Step-4:Verify tabing order 
		//--------------------------------------------------------------------//	
		assertTrue(verifyTabOrder(selenium,corresData),"tab order verification failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		
	return true;
	}

	public boolean navigateToCorresWindow(Selenium selenium,ChartPreVisitLib corresData) throws IOException, AWTException, InterruptedException
	
	{
		File dir1 = new File(".");
		String strBasePath = null;
		String file = null;
		String xmlName = "Medica_Report.doc";
		String sectionName = "chartprevisit";
		strBasePath = dir1.getCanonicalPath();
		file = strBasePath + File.separator + "src" + File.separator+ "main" + File.separator + "resources" + File.separator+ "nexia" + File.separator + "testdata" + File.separator+ sectionName + File.separator + xmlName;
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnUploadFile),		"Could not click upload btn", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium, txtBrowseFile, file),	"Could not select Docu type", selenium, ClassName,	MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		Robot robot = null;
		robot = new Robot();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ESCAPE); 
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, btnFile),"Could not click File button btn", selenium, ClassName,	MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtSearchFileToPatient,corresData.patientId),"Could not type patient id",selenium, ClassName, MethodName);
		
		assertTrue(clickAt(selenium,txtSearchFileToPatient, ""),"Could not perform click At",selenium, ClassName, MethodName);
		assertTrue(focus(selenium,txtSearchFileToPatient),"Could not perform focus",selenium, ClassName, MethodName);
		assertTrue(fireEvent(selenium,txtSearchFileToPatient,"keypress"),"Could not perform fireevent",selenium, ClassName, MethodName);			
		assertTrue(keyPress(selenium,txtPatientBox, "\\9"),"Could not perform keypress",selenium, ClassName, MethodName);
		
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
	
		waitForElement(selenium, txtSearchFileToPatient, 30000);
		assertTrue(isElementPresent(selenium,txtSearchFileToPatient),"Search Results are not displayed for the patient with ID :-"+ corresData.patientId,selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,patientInfoWid).toLowerCase(new java.util.Locale("en", "US")).trim().contains(corresData.patientId.trim().toLowerCase(new java.util.Locale("en", "US"))),"Could not get the text value",selenium, ClassName, MethodName);
		//assertTrue(getText(selenium,lblPatientResult).contains(patientID));
		waitForPageLoad(selenium);
		assertTrue(click(selenium, patientInfoWid),"Could not select the patient",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium, ajxDocuType,corresData.DocumentType),		"Could not select Docu type", selenium, ClassName,	MethodName);
		waitForPageLoad(selenium);
		return true;
	}
	public boolean verifyTabOrder(Selenium selenium,ChartPreVisitLib corresData) throws IOException 
	{
		String csspaths[]={elementaccNumberforCorres,ajxReport,txtServiceDate1,txtReceivingDate,ajxRProvider,txtSender,ajxOProvider,ajxDisgnosis,txtreportComments};
		for(int i =0;i<csspaths.length;i++){
			assertTrue(isElementPresent(selenium,csspaths[i]),"Not found", selenium, ClassName, MethodName);
			selenium.focus(csspaths[i]);
			waitForElementToEnable(selenium,csspaths[i]);
			selenium.keyPress(csspaths[i], "\\9");
			Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths[i]));
		}
		
		return true;
	}
}
