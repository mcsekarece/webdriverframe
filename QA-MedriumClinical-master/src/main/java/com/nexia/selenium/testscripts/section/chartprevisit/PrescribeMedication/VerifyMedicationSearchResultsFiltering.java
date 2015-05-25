package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;
				
public class VerifyMedicationSearchResultsFiltering extends AbstractChartPreVisit {	

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify that the system filters resultset of prescribable medications in order - first patient medications then quick list and then test data base result")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMedicationSearchResultsFilter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_119";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyMedSearchResultsFilter(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}

	/*************************************************************************************************** 
	 * @purpose        To verify that the system filters resultset of prescribable medications in order - patient medications, quicklist and database result" 
	 * @Specification  SRS_EMR_MEDS_Search Medication_Rev0.2
	 * @action 		   Search for a drug in Prescribe Medication Screen
	 * @expected       Search results should get displayed in order - Medication name (Trade), Primary Ingredient (Generic name), Drug Class
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       May 20, 2014
	 ***************************************************************************************************/

	public boolean verifyMedSearchResultsFilter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		int resultCount;
		String imgMedResultXpath;
		String imgMedResultSrcAtrribute;
		String srcValue;
		boolean flag_p = false;
		boolean flag_s = false;
		boolean flag_b = false;

		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ",selenium,ClassName,MethodName);

			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);

			if(isElementPresent(selenium, btnErrorClose)) {
				assertTrue(click(selenium, btnErrorClose),"Could not close button",selenium,ClassName,MethodName);
			}
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not Navigate to prescribe medication page",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not search for prescribed medicine", selenium, ClassName, MethodName);
						
			//--------------------------------------------------------------------//
			//  Step-5: create Prescribe Medication with QuickList option //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
						
			assertTrue(click(selenium,btnPrint),"Could not click the print button; More Deatils:"+prescribeData.toString(),selenium,ClassName,MethodName);
			Robot robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ESCAPE);			
			
			//--------------------------------------------------------------------//
			//  Step-6: create Prescribe Medication without QuickList option//
			//--------------------------------------------------------------------//
			//Saving medicine names. This to ensure that both medication appears in search results if search is performed with first similar character 
			String originalPrescibedMed = getTestData_Prescribe(prescribeData, userAccount);
			prescribeData.workSheetName = "PrescribeMedi";
			prescribeData.testCaseId = "TC_PM_120";
			prescribeData.fetchChartPreVisitTestData();
			String newPrescibedMed = getTestData_Prescribe(prescribeData, userAccount);
			
			if (newPrescibedMed.equalsIgnoreCase(originalPrescibedMed)) {
				fail("Drug search string for Quicklist is same as patient list");
			}
			
			// Search  Prescribe Medication
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not search for prescribed medicine", selenium, ClassName, MethodName);			

			// create Prescribe Medication 
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			
			assertTrue(click(selenium,btnPrint),"Could not click the print button; More Deatils:"+prescribeData.toString(),selenium,ClassName,MethodName);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			
			//--------------------------------------------------------------------//
			//  Step-7: perform medication search so that above two drugs gets listed in search results
			//--------------------------------------------------------------------//			
			String s1 = originalPrescibedMed.substring(0, 1);
			String s2 = newPrescibedMed.substring(0, 1);
			
			if (s1.equalsIgnoreCase(s2)) {
				prescribeData.prescribe = s1;
				System.out.println("Search String is:" +s1);
			} else {				
 				fail("First character of Prescribed medicine not matched with Quick List. Please change test data");
			}			
			
			assertTrue(searchPrescribeMedication(selenium,prescribeData,userAccount),"Could not search for prescribed medicine", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-8: Retrieve Test results and verify that result set order is maintained
			//--------------------------------------------------------------------//			
			//Get count of all results retrieved
			String imgMedResultXpath1 = lblMedSearchResultXpath1;
			String imgMedResultXpath2 = "]/div[2]/div/div[2]/div/div[1]/img";			
			resultCount = getCountOfElementsWithSimilarXpath(selenium, imgMedResultXpath1,imgMedResultXpath2);
			
			//Extract information from every result
			for (int i = 1; i <= resultCount; i++) {			
				
				imgMedResultXpath = imgMedResultXpath1 + i + imgMedResultXpath2;
				
				if (selenium.isVisible(imgMedResultXpath)) {
					imgMedResultSrcAtrribute = imgMedResultXpath + "/@src";
					srcValue = selenium.getAttribute(imgMedResultSrcAtrribute);
					System.out.println("Attribute src value of Element " +i+ " is: " +srcValue);
					
					if( srcValue.contains("patient-list") ) {						
						if (flag_s || flag_b){
							System.out.println("Patient icon found after Star icon or no image");
							fail("Patient icon found after Star icon or no image");
							returnValue = false;
						} 						
						flag_p = true;
					}
					else if (srcValue.contains("quicklist-star")) {
						if(flag_b){
							System.out.println("Star icon found after no image");
							fail("Star icon found after no image");
							returnValue = false;
						}
						flag_s = true;
					}
					else {
						fail("Image other than Patient or Star appeared in search results ");
						returnValue = false;
					}
				}
				else {
					//System.out.println("Image is not present");
					flag_b = true;
				}						
									
			}			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}

	/**
	 * This is a utility function to extract prescribed medicine names
	 * @param prescribeData
	 * @param account
	 * @return 
	 */
	private String getTestData_Prescribe(ChartPreVisitLib prescribeData, String account) {
		String prescribe;
		if (account.equals(CAAccount)) {
			prescribe = prescribeData.prescribeCa;			
		} else {
			prescribe = prescribeData.prescribe;			
		}
		return prescribe;

	}	
}




