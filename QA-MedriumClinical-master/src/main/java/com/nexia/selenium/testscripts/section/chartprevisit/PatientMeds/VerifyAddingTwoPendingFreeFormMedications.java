package com.nexia.selenium.testscripts.section.chartprevisit.PatientMeds;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAddingTwoPendingFreeFormMedications extends AbstractChartPreVisit{
  @Test (enabled = false)
	//@Test(groups ={"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Stored Value of Prescribe Medication withtwo free Free form medications")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForEditFreeFormWithDirections(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_090";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPendingMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * editPendingMedication
	 * Function to edit Pending medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Sep 18, 2012
	 */
	
	public boolean editPendingMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,prescribeData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete all existing pending Medication//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllPendingMedication(selenium, prescribeData), "Pending medication deleteion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescribeData.provider = pName;
			assertTrue(SearchPrescribeMedForFreeFrom(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnSave)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnSave),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//--------------------------------------------------------------------//
			//  Step-6: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnAddToPending), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkGoToPending)){

				returnValue = true;
			}else
				returnValue=false;
			ChartPreVisitLib prescribeData1 = new ChartPreVisitLib();
			prescribeData1.workSheetName = "PrescribeMedi";
			prescribeData1.testCaseId = "TC_PM_030";
			prescribeData1.fetchChartPreVisitTestData();

			assertTrue(SearchPrescribeMedForFreeFrom(selenium,prescribeData,userAccount),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Edit Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addSecondPrescribeMedication(selenium,prescribeData1,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnAddToPending), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkGoToPending)){

				returnValue = true;
			}else
				returnValue=false;
			
			assertTrue(click(selenium, lnkMedicationTab), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			/*if(!verifyStoredValuesInDrugdbPage(selenium,prescribeData,prescribeData1)){
				Assert.fail("Pending medication details not saved properly; More Details :"+ prescribeData.toString());
				returnValue = false;
			}else 
				returnValue = true;*/
			if(!verifyStoredValuesInSummaryPage(selenium,prescribeData,prescribeData1,userAccount)){
				Assert.fail("Pending medication details not saved properly; More Details :"+ prescribeData.toString());
				returnValue = false;
			}else 
				return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return false;
	}
	
/*	*//**
	 * verifyStoredValuesInSearchMedPage
	 * @param selenium
	 * @param prescribeData
	 * @return
 * @throws IOException 
	 *//*
	public boolean verifyStoredValuesInDrugdbPage(Selenium selenium, ChartPreVisitLib prescribeData,ChartPreVisitLib prescribeData1){
			if(!getText(selenium, lblPendingMedsDetails2).contains(prescribeData.prescribe))
			return false;
			if(!getText(selenium,"//div[3]/div[3]/div/div[2]").trim().contains(prescribeData.method.trim())){
				return false;
			}
			if(!getText(selenium,"//div[3]/div[3]/div/div[2]").trim().contains(prescribeData.quality.trim())){
				return false;
			}
			if(!getText(selenium,"//div[3]/div[3]/div/div[2]").trim().contains(prescribeData.unit.trim())){
				return false;
			}
			if(!getText(selenium,"//div[3]/div[3]/div/div[2]").trim().contains(prescribeData.route.trim())){
				return false;
			}
			if(!getText(selenium,"//div[3]/div[3]/div/div[2]").trim().contains(prescribeData.frequency.trim())){
				return false;
			}
			if(!getText(selenium,"//div[3]/div[3]/div/div[2]").trim().contains(prescribeData.duration.trim())){
				return false;
			}
			if(!getText(selenium,"//div[3]/div[3]/div/div[2]").trim().contains(prescribeData.usage.trim())){
				return false;
			}
			if(!getText(selenium, "//div[3]/div[2]/div").contains(prescribeData1.prescribe))
				return false;
				if(!getText(selenium,"//div[3]/div[2]/div[2]").trim().contains(prescribeData1.method.trim())){
					return false;
				}
				if(!getText(selenium,"//div[3]/div[2]/div[2]").trim().contains(prescribeData1.quality.trim())){
					return false;
				}
				if(!getText(selenium,"//div[3]/div[2]/div[2]").trim().contains(prescribeData1.unit.trim())){
					return false;
				}
				if(!getText(selenium,"//div[3]/div[2]/div[2]").trim().contains(prescribeData1.route.trim())){
					return false;
				}
				if(!getText(selenium,"//div[3]/div[2]/div[2]").trim().contains(prescribeData1.frequency.trim())){
					return false;
				}
				if(!getText(selenium,"//div[3]/div[2]/div[2]").trim().contains(prescribeData1.duration.trim())){
					return false;
				}
				if(!getText(selenium,"//div[3]/div[2]/div[2]").trim().contains(prescribeData1.usage.trim())){
					return false;
				}
		return true;
	}*/
	
	public boolean verifyStoredValuesInSummaryPage(Selenium selenium, ChartPreVisitLib prescribeData,ChartPreVisitLib prescribeData1,String account) throws IOException{
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("MMMMMMMM dd, yyyy");
		String date=DateFormat1.format(cal.getTime());
		System.out.println(getText(selenium, lnkPendingExpand));
		System.out.println(prescribeData1.prescribeCa);
		if(account.equals(CAAccount)){
			if(!getText(selenium, lnkPendingExpand).contains(prescribeData1.prescribeCa))
				return false;
			if(!getText(selenium, lnkPendingExpand).contains("Added to pending on "+date))
				return false;
			if(prescribeData1.testCaseId.equals("TC_PM_030")){
				assertTrue(click(selenium,lnkPendingExpand),"Could not click the Expand button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(!getText(selenium, lnkPendingExpand).contains("Added to pending on "+date))
					return false;
				if(!getText(selenium,lblPendingMedsDetails).trim().contains(prescribeData1.refillMethodCa.trim())){
					return false;
				}
				if(!getText(selenium,lblPendingMedsDetails).trim().contains(prescribeData1.qualityCa.trim())){
					return false;
				}
				if(!getText(selenium,lblPendingMedsDetails).trim().contains(prescribeData1.unit.trim())){
					return false;
				}
				if(!getText(selenium,lblPendingMedsDetails).trim().contains(prescribeData1.routeCa.trim())){
					return false;
				}
				
				if(!getText(selenium,lblPendingMedsDetails).trim().contains(prescribeData1.duration.trim())){
					return false;
				}
				if(!getText(selenium,lblPendingMedsDetails).trim().contains(prescribeData1.usage.trim())){
					return false;
				}
			}
			if(!getText(selenium, lblPendingMedsDetails1).contains(prescribeData.prescribeCa))
				return false;
			if(!getText(selenium,  lblPendingMedsDetails1).contains("Added to pending on "+date))
				return false;
			if(prescribeData.testCaseId.equals("TC_PM_090")){
				assertTrue(click(selenium, lblPendingMedsDetails1),"Could not click the Expand button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(!getText(selenium, lblPendingMedsDetails2).contains(prescribeData.refillMethod))
					return false;
				
				if(!getText(selenium,lblPendingMedsDetails2).trim().contains(prescribeData.qualityCa.trim())){
					return false;
				}
				if(!getText(selenium,lblPendingMedsDetails2).trim().contains(prescribeData.unit.trim())){
					return false;
				}
				if(!getText(selenium,lblPendingMedsDetails2).trim().contains(prescribeData.routeCa.trim())){
					return false;
				}
				
				if(!getText(selenium,lblPendingMedsDetails2).trim().contains(prescribeData.duration.trim())){
					return false;
				}
				if(!getText(selenium,lblPendingMedsDetails2).trim().contains(prescribeData.usage.trim())){
					return false;
				}
			}
		}else{
			if(!getText(selenium, lnkPendingExpand).contains(prescribeData1.prescribe))
				return false;
			if(!getText(selenium, lnkPendingExpand).contains("Added to pending on "+date))
				return false;
			if(prescribeData1.testCaseId.equals("TC_PM_030")){
				assertTrue(click(selenium,lnkPendingExpand),"Could not click the Expand button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(!getText(selenium, lnkPendingExpand).contains("Added to pending on "+date))
					return false;
				if(!getText(selenium, lblPendingMedsDetails).contains(prescribeData1.method))
					return false;
				if(!getText(selenium,lblPendingMedsDetails).trim().contains(prescribeData1.quality.trim())){
					return false;
				}
				if(!getText(selenium,lblPendingMedsDetails).trim().contains(prescribeData1.unit.trim())){
					return false;
				}
				if(!getText(selenium,lblPendingMedsDetails).trim().contains(prescribeData1.route.trim())){
					return false;
				}
				if(!getText(selenium,lblPendingMedsDetails).trim().contains(prescribeData1.frequency.trim())){
					return false;
				}
				if(!getText(selenium,lblPendingMedsDetails).trim().contains(prescribeData1.duration.trim())){
					return false;
				}
				if(!getText(selenium,lblPendingMedsDetails).trim().contains(prescribeData1.usage.trim())){
					return false;
				}
			}
			if(!getText(selenium, lblPendingMedsDetails1).contains(prescribeData.prescribe))
				return false;
			if(!getText(selenium, lblPendingMedsDetails1).contains("Added to pending on "+date))
				return false;
			if(prescribeData.testCaseId.equals("TC_PM_090")){
				assertTrue(click(selenium,lblPendingMedsDetails1),"Could not click the Expand button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(!getText(selenium, lblPendingMedsDetails2).contains(prescribeData.method))
					return false;
				
				if(!getText(selenium,lblPendingMedsDetails2).trim().contains(prescribeData.quality.trim())){
					return false;
				}
				if(!getText(selenium,lblPendingMedsDetails2).trim().contains(prescribeData.unit.trim())){
					return false;
				}
				if(!getText(selenium,lblPendingMedsDetails2).trim().contains(prescribeData.route.trim())){
					return false;
				}
				if(!getText(selenium,lblPendingMedsDetails2).trim().contains(prescribeData.frequency.trim())){
					return false;
				}
				if(!getText(selenium,lblPendingMedsDetails2).trim().contains(prescribeData.duration.trim())){
					return false;
				}
				if(!getText(selenium,lblPendingMedsDetails2).trim().contains(prescribeData.usage.trim())){
					return false;
				}
			}
		}
		return true;
	}
}
