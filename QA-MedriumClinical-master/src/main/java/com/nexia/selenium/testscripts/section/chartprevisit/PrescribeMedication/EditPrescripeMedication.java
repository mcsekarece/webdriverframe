package com.nexia.selenium.testscripts.section.chartprevisit.PrescribeMedication;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class EditPrescripeMedication extends AbstractChartPreVisit{
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editPrescribeMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_004";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPrescribes(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a Prescribe Medication With Free Text")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editPrescribeMedicationWithFreeText(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_069";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPrescribes(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a Prescribe Medication With Increasing Decreasing Dose")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editPrescribeMedicationWithIncreasingDecreasingDose(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_070";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPrescribes(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a Prescribe Medication With Multiple Directions")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editPrescribeMedicationWithMultipleDirections(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_071";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPrescribes(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a Prescribe Medication With Refills")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editPrescribeMedicationWithRefills(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_072";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPrescribes(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(enabled=false)
	//This Test for checking "free form". It removed from UI. So, Disable the script from execution
	//@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Prescribe Medication with refills")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editPrescribeMedicationWithFreeForm(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_073";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPrescribes(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}
	@Test(enabled=false)
	//This Test for checking "free form". It removed from UI. So, Disable the script from execution
	//@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Prescribe Medication with refills")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editPrescribeMedicationWithFreeFormDirections(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib prescribeData = new ChartPreVisitLib();
		prescribeData.workSheetName = "PrescribeMedi";
		prescribeData.testCaseId = "TC_PM_074";
		prescribeData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editPrescribes(seleniumHost, seleniumPort, browser, webSite, userAccount, prescribeData);
	}

	/**
	 * editPrescribes
	 * function to edit Prescribes
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    Sep 12, 2012
	 */
	public boolean editPrescribes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib prescribeData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + prescribeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, prescribeData.userName, prescribeData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,prescribeData.patientId);
			waitForPageLoad(selenium);
			

			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Prescribe Medication//
			//--------------------------------------------------------------------//
			assertTrue(goToPrescribe(selenium),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ prescribeData.switchRole , "");
			String tempArray[]=providerName.split(" ");
			String pName=tempArray[1]+", "+tempArray[0];
			System.out.println(pName);
			prescribeData.provider = pName;
			
			if(prescribeData.testCaseId.equals("TC_PM_073")||prescribeData.testCaseId.equals("TC_PM_074")){
				assertTrue(SearchPrescribeMedForFreeFrom(selenium,prescribeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			else
				assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"Could not click the link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
					
			
			if(isElementPresent(selenium,btnOverride)){
				assertTrue(type(selenium,txtOverride3,prescribeData.reason),"Could not type reason;More Details:"+prescribeData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnOverride),"Could not click override button"+prescribeData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-5: create Prescribe Medication //
			//--------------------------------------------------------------------//
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnEdit),"Could not find the edit button;More details:"+prescribeData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: create Prescribe Medication //
			//--------------------------------------------------------------------//
			if(prescribeData.testCaseId.equals("TC_PM_004")){
				prescribeData.workSheetName = "PrescribeMedi";
				prescribeData.testCaseId = "TC_PM_006";
				prescribeData.fetchChartPreVisitTestData();
				assertTrue(click(selenium,btnEdit),"Could not click the edit button;More details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Editing Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(verifyStoredValuesInSummaryPage(selenium,prescribeData))
					returnValue=true;
				else
					returnValue=true;
			}
			else if(prescribeData.testCaseId.equals("TC_PM_069")){
				prescribeData.workSheetName = "PrescribeMedi";
				prescribeData.testCaseId = "TC_PM_014";
				prescribeData.fetchChartPreVisitTestData();
				assertTrue(click(selenium,btnEdit),"Could not click the edit button;More details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Editing Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(verifyStoredValuesInSummaryPageForFreeText(selenium,prescribeData))
					returnValue=true;
				else
					returnValue=true;
			}
			else if(prescribeData.testCaseId.equals("TC_PM_010")){
				prescribeData.workSheetName = "PrescribeMedi";
				prescribeData.testCaseId = "TC_PM_011";
				prescribeData.fetchChartPreVisitTestData();
				assertTrue(click(selenium,btnEdit),"Could not click the edit button;More details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Editing Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(verifyStoredValuesInSummaryPageForRefill(selenium,prescribeData,userAccount))
					returnValue=true;
				else
					returnValue=true;
			}
			else if(prescribeData.testCaseId.equals("TC_PM_070")){
				prescribeData.workSheetName = "PrescribeMedi";
				prescribeData.testCaseId = "TC_PM_005";
				prescribeData.fetchChartPreVisitTestData();
				assertTrue(click(selenium,btnEdit),"Could not click the edit button;More details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Editing Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(verifyStoredValuesInSummaryPageForIncreasingDecreasingDose(selenium,prescribeData,userAccount))
					returnValue=true;
				else
					returnValue=true;
			}
			else if(prescribeData.testCaseId.equals("TC_PM_071")){
				prescribeData.workSheetName = "PrescribeMedi";
				prescribeData.testCaseId = "TC_PM_012";
				prescribeData.fetchChartPreVisitTestData();
				assertTrue(click(selenium,btnEdit),"Could not click the edit button;More details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Editing Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(verifyStoredValuesInSummaryPageForMultipleDirections(selenium,prescribeData))
					returnValue=true;
				else
					returnValue=true;
			}else if(prescribeData.testCaseId.equals("TC_PM_073")){
				prescribeData.workSheetName = "PrescribeMedi";
				prescribeData.testCaseId = "TC_PM_028";
				prescribeData.fetchChartPreVisitTestData();
				assertTrue(click(selenium,btnEdit),"Could not click the edit button;More details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Editing Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(verifyStoredValuesInSummaryPageForFreeText(selenium,prescribeData))
					returnValue=true;
				else
					returnValue=true;
			}else if(prescribeData.testCaseId.equals("TC_PM_074")){
				prescribeData.workSheetName = "PrescribeMedi";
				prescribeData.testCaseId = "TC_PM_030";
				prescribeData.fetchChartPreVisitTestData();
				assertTrue(click(selenium,btnEdit),"Could not click the edit button;More details:"+prescribeData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Editing Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(verifyStoredValuesInSummaryPage(selenium,prescribeData))
					returnValue=true;
				else
					returnValue=true;
			}
			
			if(isElementPresent(selenium,btnEdit)){
				return returnValue;
			}else
				returnValue=false;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + prescribeData.toString(),selenium,ClassName,MethodName);
		}
		return false;
	}
	public boolean verifyStoredValuesInSummaryPage(Selenium selenium,ChartPreVisitLib prescripeData){
		/*	
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
			String date=DateFormat1.format(cal.getTime());*/
			
			waitForPageLoad(selenium);
			System.out.println(getText(selenium,"//div[2]/div/div/div/div[5]/div/div"));
			System.out.println(prescripeData.patientName);
			if(!getText(selenium,"//div[2]/div/div/div/div[5]/div/div").toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescripeData.patientName.trim().toLowerCase(new java.util.Locale("en","Us")))){
				return false;
			}
			if(!getText(selenium,"//div[5]/div[2]/div").toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescripeData.providerName.trim().toLowerCase(new java.util.Locale("en","Us")))){
				return false;
			}
			if(!getText(selenium,lblPrecrbeMeds).trim().contains(prescripeData.refillMethod.trim())){
				return false;
			}
			/*if(!getText(selenium,lblPrecrbeMeds).trim().contains(prescripeData.refillQuantity.trim())){
				return false;
			}*/
			if(!getText(selenium,lblPrecrbeMeds).trim().contains(prescripeData.refillUnit.trim())){
				return false;
			}
			if(!getText(selenium,lblPrecrbeMeds).trim().contains(prescripeData.refillRoute.trim())){
				return false;
			}
			if(!getText(selenium,lblPrecrbeMeds).trim().contains(prescripeData.refillFrequency.trim())){
				return false;
			}
			if(!getText(selenium,lblPrecrbeMeds).trim().contains(prescripeData.refillUsage.trim())){
				return false;
			}
			if(!getText(selenium,lblPrecrbeMeds).trim().contains(prescripeData.usage.trim())){
				return false;
			}
			if(!getText(selenium,lblPrecrbeMeds).trim().contains(prescripeData.refillUsage2.trim())){
				return false;
			}
			if(!getText(selenium,lblPrecrbeMeds).trim().contains(prescripeData.refillUsage3.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds1).trim().contains(prescripeData.dispense.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds1).trim().contains(prescripeData.unitList.trim())){
				return false;
			}
			
			return true;
		}
		public boolean verifyStoredValuesInSummaryPageForIncreasingDecreasingDose(Selenium selenium,ChartPreVisitLib prescripeData,String account){			
				waitForPageLoad(selenium);
				if(!getText(selenium,lblPrescribeData).toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescripeData.patientName.trim().toLowerCase(new java.util.Locale("en","Us")))){
					return false;
				}
				/*if(!getText(selenium,lblPrescribeMeds2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescripeData.providerName.trim().toLowerCase(new java.util.Locale("en","Us")))){
					return false;
				}*/
				if(account.equals(CAAccount)){
					if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.patientAddressCa.trim())){
						return false;
					}
					if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.providerAddressCa.trim())){
						return false;
					}
				}else{
					if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.patientAddress.trim())){
						return false;
					}
					if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.providerAddress.trim())){
						return false;
					}
				}
				if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.patientPhone.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.providerPhone.trim())){
					return false;
				}	
				if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.refillMethod.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.quality.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.unit.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.route.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.frequency.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.duration.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.usage.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeData).trim().contains("**"+prescripeData.dispense.trim()+"** "+prescripeData.dispenseWord.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.unitList.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeData).trim().contains(prescripeData.notesToPharmacy.trim())){
					return false;
				}			
				return true;
			}
		public boolean verifyStoredValuesInSummaryPageForMultipleDirections(Selenium selenium,ChartPreVisitLib prescripeData){			
			waitForPageLoad(selenium);
			if(!getText(selenium,lblPrescribeMeds2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescripeData.patientName.trim().toLowerCase(new java.util.Locale("en","Us")))){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescripeData.providerName.trim().toLowerCase(new java.util.Locale("en","Us")))){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.patientAddress.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.providerAddress.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.patientPhone.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.providerPhone.trim())){
				return false;
			}	
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.refillMethod.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.refillQuantity.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.refillUnit.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.refillRoute.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.refillFrequency.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.refillduration.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.refillUsage1.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.method.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.quality.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.unit.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.route.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.frequency.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.duration.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.usage.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains("**"+prescripeData.dispense.trim()+"** "+prescripeData.dispenseWord.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.unitList.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.notesToPharmacy.trim())){
				return false;
			}			
			return true;
		}
		public boolean verifyStoredValuesInSummaryPageForRefill(Selenium selenium,ChartPreVisitLib prescripeData,String account){			
			waitForPageLoad(selenium);
			if(!getText(selenium,lblPrescribeMeds2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescripeData.patientName.trim().toLowerCase(new java.util.Locale("en","Us")))){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescripeData.providerName.trim().toLowerCase(new java.util.Locale("en","Us")))){
				return false;
			}
			if(account.equals(CAAccount)){
				if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.patientAddressCa.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.providerAddressCa.trim())){
					return false;
				}
			}else{
				if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.patientAddress.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.providerAddress.trim())){
					return false;
				}
			}	
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.patientPhone.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.providerPhone.trim())){
				return false;
			}			
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.direction.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains("**"+prescripeData.dispense.trim()+"** "+prescripeData.dispenseWord.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.direction.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.ofRefill.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.refillUsage1.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.refillMethod.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.refillQuantity.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.refillUnit.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.refillRoute.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.refillFrequency.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.refillduration.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.usage.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains("**"+prescripeData.ofRefill.trim()+"** "+prescripeData.dispenseWord.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.unitList.trim())){
				return false;
			}
			if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.notesToPharmacy.trim())){
				return false;
			}			
			return true;
		}
		public boolean verifyStoredValuesInSummaryPageForFreeText(Selenium selenium,ChartPreVisitLib prescripeData){
				
				/*Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
				String date=DateFormat1.format(cal.getTime());*/
				
				waitForPageLoad(selenium);
				if(!getText(selenium,lblPrescribeMeds2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescripeData.patientName.trim().toLowerCase(new java.util.Locale("en","Us")))){
					return false;
				}
				if(!getText(selenium,lblPrescribeMeds2).toLowerCase(new java.util.Locale("en","Us")).trim().contains(prescripeData.providerName.trim().toLowerCase(new java.util.Locale("en","Us")))){
					return false;
				}
				if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.patientAddress.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.providerAddress.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.patientPhone.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.providerPhone.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.direction.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeMeds2).trim().contains("**"+prescripeData.dispense.trim()+"** "+prescripeData.dispenseWord.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.unitList.trim())){
					return false;
				}
				if(!getText(selenium,lblPrescribeMeds2).trim().contains(prescripeData.notesToPharmacy.trim())){
					return false;
				}			
				return true;
			}

}
