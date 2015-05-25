package com.nexia.selenium.testscripts.section.chartprevisit.PatientMeds;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class AddCurrentMedication  extends AbstractChartPreVisit{

	@Test (enabled = false)
	//	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for adding a medication in current section with free form")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addCurrentMedicationForFreeForm(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_023";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		pendingMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	
	@Test (enabled = false)
	//@Test(groups ={"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for adding a medication in current section with free form")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addCurrentMedicationForFreeFormWithMedications(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_029";
		prescribeData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		pendingMedication(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	/**
	 * pendingMedication
	 * Function to create Pending medication
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Sep 18, 2012
	 */
	public boolean pendingMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
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
			//  Step-2: Create Patient//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			ChartPreVisitLib patientData = new ChartPreVisitLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NP_001";
			patientData.fetchChartPreVisitTestData();
			
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescribeData.provider = pName;
			
			assertTrue(goToPrescribe(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(SearchPrescribeMedForFreeFrom(selenium,prescribeData,userAccount),"Could not click the Free from link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-5: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnPrint), "Could not click on Add to pending button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Robot robot = new Robot();
			Thread.sleep(20000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to Medication tab//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkMedicationTab),"Could not click medication tab"+prescribeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(userAccount.equals(CAAccount)){
				if(getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeCa)){
					returnValue=true;
				}else
					Assert.fail("Could not add add to pending medication");
			}else
				if(getText(selenium,lblCureentMedsname).contains(prescribeData.prescribeName)){
					returnValue=true;
				}else
					Assert.fail("Could not add add to pending medication");
				
			/*if(!verifyStoredValuesInDrugdbPage(selenium,prescribeData,userAccount)){
				Assert.fail("Pending medication details not saved properly; More Details :"+ prescribeData.toString());
				returnValue = false;
			}else 
				returnValue = true;*/
			if(!verifyStoredValuesInSummaryPage(selenium,prescribeData,userAccount)){
				Assert.fail("Pending medication details not saved properly; More Details :"+ prescribeData.toString());
				returnValue = false;
			}else 
				return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	/**
	 * verifyStoredValuesInSearchMedPage
	 * @param selenium
	 * @param prescribeData
	 * @return
	 * @throws IOException 
	 */
	/*public boolean verifyStoredValuesInDrugdbPage(Selenium selenium, ChartPreVisitLib prescribeData,String account){
		if(account.equals(CAAccount)){
			if(!getText(selenium, "//div[3]/div[3]/div/div").contains(prescribeData.prescribeCa))
				return false;
			if(prescribeData.testCaseId.equals("TC_PM_004")){
				if(!getText(selenium,"//div[3]/div[3]/div/div[2]").trim().contains(prescribeData.methodCa.trim())){
					return false;
				}
				if(!getText(selenium,"//div[3]/div[3]/div/div[2]").trim().contains(prescribeData.qualityCa.trim())){
					return false;
				}
				if(!getText(selenium,"//div[3]/div[3]/div/div[2]").trim().contains(prescribeData.unitCa.trim())){
					return false;
				}
				if(!getText(selenium,"//div[3]/div[3]/div/div[2]").trim().contains(prescribeData.routeCa.trim())){
					return false;
				}
				if(!getText(selenium,"//div[3]/div[3]/div/div[2]").trim().contains(prescribeData.frequencyCa.trim())){
					return false;
				}
				if(!getText(selenium,"//div[3]/div[3]/div/div[2]").trim().contains(prescribeData.duration.trim())){
					return false;
				}
				if(!getText(selenium,"//div[3]/div[3]/div/div[2]").trim().contains(prescribeData.usageCa.trim())){
					return false;
				}
			}
			return true;
			}
		else
			if(!getText(selenium, "//div[3]/div[3]/div/div").contains(prescribeData.prescribe))
				return false;
			if(prescribeData.testCaseId.equals("TC_PM_004")){
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
			}
			return true;
			}*/
	
	public boolean verifyStoredValuesInSummaryPage(Selenium selenium, ChartPreVisitLib prescribeData,String account) throws IOException{
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("MMMMMMMM dd, yyyy");
		String date=DateFormat1.format(cal.getTime());
		if(account.equals(CAAccount)){
		if(!getText(selenium, lblProDetails).contains(prescribeData.prescribeCa))
			return false;
		if(!getText(selenium, lblProDetails).contains(date))
			return false;
		if(prescribeData.testCaseId.equals("TC_PM_029")){
			/*assertTrue(click(selenium,"css=div.closedArrow"),"Could not click the Expand button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			if(!getText(selenium,lblProDetails).contains(prescribeData.methodCa))
				return false;
			if(!getText(selenium, lblProDetails).contains(date))
				return false;
			if(!getText(selenium,lblProDetails).trim().contains(prescribeData.refillMethodCa.trim())){
				return false;
			}
			if(!getText(selenium,lblProDetails).trim().contains(prescribeData.unitCa.trim())){
				return false;
			}
			if(!getText(selenium,lblProDetails).trim().contains(prescribeData.routeCa.trim())){
				return false;
			}
			if(!getText(selenium,lblProDetails).trim().contains(prescribeData.frequencyCa.trim())){
				return false;
			}
			if(!getText(selenium,lblProDetails).trim().contains(prescribeData.duration.trim())){
				return false;
			}
			if(!getText(selenium,lblProDetails).trim().contains(prescribeData.usageCa.trim())){
				return false;
			}
		}
		return true;
	}else
		if(!getText(selenium, lblProDetails).contains(prescribeData.prescribe))
			return false;
		System.out.println(getText(selenium, lblProDetails));
		System.out.println(date);
		if(!getText(selenium, lblProDetails).contains(date))
			return false;
		if(prescribeData.testCaseId.equals("TC_PM_029")){
			/*assertTrue(click(selenium,"css=div.closedArrow"),"Could not click the Expand button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			System.out.println(prescribeData.refillMethod);
			if(!getText(selenium, lblProDetails).contains(prescribeData.refillMethod))
				return false;
			if(!getText(selenium, lblProDetails).contains(date))
				return false;
			if(!getText(selenium,lblProDetails).trim().contains(prescribeData.quality.trim())){
				return false;
			}
			if(!getText(selenium,lblProDetails).trim().contains(prescribeData.unit.trim())){
				return false;
			}
			if(!getText(selenium,lblProDetails).trim().contains(prescribeData.route.trim())){
				return false;
			}
			if(!getText(selenium,lblProDetails).trim().contains(prescribeData.frequency.trim())){
				return false;
			}
			if(!getText(selenium,lblProDetails).trim().contains(prescribeData.duration.trim())){
				return false;
			}
			if(!getText(selenium,lblProDetails).trim().contains(prescribeData.usage.trim())){
				return false;
			}
		}
		return true;

	}
}
