package com.projectname.testutils.pages;

import java.io.IOException;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.genericutility.testDataLib.HomeLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class ReferralsPage extends SeleniumWebDriver{

	public   ReferralsPage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);
		SeleniumWebDriver.isElementPresent(readyLocator);

		}
	
	    private static By readyLocator=By.id("addReferral");
	    private static By lnkDeleteReferrals=By.xpath("//div[@id='ReferralList']/table/tbody/tr/td[3]/div/a");
	    private static By btnAddReferral=By.id("addReferral");
	   private By ajxReferralType=By.id("referralTypesuggestBox");
	    private By ajxReferredBy=By.id("referredFromsuggestBox");
	    private By ajxReferralSpecial =By.id( "referralSpecialtysuggestBox");
	    private By ajxReferralDiagnoses = By.id("referralDiagnosessuggestBox");
	    private By txtReferralReason = By.id("referralReason");
	    private By txtReferralEndDate =By.id( "referralEndDate");
	    private By txtReferralComments =By.id( "referralComments");
	    private By btnAddAuthorization =By.id( "addAuthorizationButton");
	    private By ajxPayer = By.id("payerSuggestBox1suggestBox");
	    private By txtRequestDate = By.id("requestDate1");
	    private By txtApprovalDate =By.id( "approvalDate1");
	    private By txtAuthorizationNum =By.id( "authorizationNum1");
	    private By txtNumAuthorizationVisit = By.id("numAuthorizedVisits1");
	    private By txtStartDate1 =By.id( "startDate1");
	    private By txtEndDate1 = By.id("endDate1");
	    private By txtNumVisit = By.id("numAuthorizedVisits1");
	    private By ajxNumVisit = By.id("numVisitTypeSuggestBox1suggestBox");
	    private By ajxList = By.xpath("//body/div[4]/div/div/div/div/div");
	    private By txtReferralDate=By.id("referralDate");
	    private By ajxCPT=By.id("cptSuggestBox1-1suggestBox");
	    private By ajxReferedTo=By.id("referredTosuggestBox");
	    private By ajxReferedToAddress=By.id("referredToAddresssuggestBox");
	    private By lblNoDetailsAdded=By.xpath("//div[@class='listNoData']");
	    private By btnSave =  By.id("save");
	    private By lnkReferrals=By.id("!patientReferralList");
	    private By lnkReferralValue=By.xpath("(//div[@id='ReferralList'])[1]");
	    private By btnYesButton = By.id("yesButton");
		private By lblItemSelected=By.cssSelector("div.item-selected");
	    private By lblPatientResult=By.id("patientInfoWidget");
	    private By btnErrorClose = By.id("errorCloseButton");
	    private By txtPatientBox = By.id("searchPatientBox");
	    private By patientInfo=By.cssSelector("div.patientInfoWidget");
	    private By patientWidget=By.cssSelector("div.patientInfoWidget");
	    private By lnkArrow=By.id("menuArrow");
	    
	    
	    /**
		 * create referral
		 * fuction to create referral for a patient
		 * @param 	refData- data to create referral
		 * @throws  Exception 
		 * @since  	Dec 17, 2014
		 * @version 2.1
		 */
	
public boolean createReferral(WebDriver driver, HomeLib refData) throws Exception{
		
		try{		
			
			selectValueFromAjaxList(driver,ajxReferralType, refData.refType);
			waitForPageLoad(driver);
			selectValueFromAjaxList(driver,ajxReferredBy, refData.refBy);
			waitForPageLoad(driver);
			//waitForElementToEnable(driver,ajxAddress);
			//waitForPageLoad(driver);
			//selectValueFromAjaxList(driver,ajxAddress, refData.addr);
			
			selectValueFromAjaxList(driver,ajxReferedTo, refData.refTo);
			waitForPageLoad(driver);
			selectValueFromAjaxList(driver,ajxReferedToAddress, refData.refToAddress);
			
			selectValueFromAjaxList(driver,ajxReferralSpecial, refData.speciality);
			
			if(refData.testCaseId.equalsIgnoreCase("TC_CRL_007")){
				driver.findElement(ajxReferralDiagnoses).sendKeys(Keys.ENTER);
				waitForPageLoad(driver);
			}else
				selectValueFromAjaxList(driver,ajxReferralDiagnoses, refData.diagCode);
			
			assertTrue(type(driver,txtReferralReason,refData.referralReason),"Could not enter the referral Reason; More Details :" + refData.toString(), driver, className, methodName);
			//assertTrue(enterDate(driver,txtReferralDate, refData.referralDate),"Could not enter referral date; More Details :" + refData.toString(), driver, className, methodName);
			assertTrue(enterDate(driver,txtReferralEndDate,refData.referralEndDate),"Could not enter the referralEndDate; More Details :" + refData.toString(), driver, className, methodName);
			assertTrue(type(driver,txtReferralComments,refData.refComments),"Could not enter referral Comments; More Details :" + refData.toString(), driver, className, methodName);
			if(!(refData.testCaseId.equals("TC_CRL_017")||refData.testCaseId.equals("TC_CRL_018")||refData.testCaseId.equals("TC_CRL_019")||refData.testCaseId.equals("TC_CRL_020")||refData.testCaseId.equals("TC_CRL_021"))){
			assertTrue(click(driver,btnAddAuthorization),"Could not click on add Authorization Button; More Details :" + refData.toString(), driver, className, methodName);
			assertTrue(click(driver,ajxPayer),"Could not click Save Button; More Details :" + refData.toString(), driver, className, methodName);
			waitForPageLoad(driver);
			String dummy = getText(driver,ajxList);
			System.out.println(dummy);
			refData.payer = dummy.split(" ")[0];
			selectValueFromAjaxList(driver,ajxPayer, refData.payer);
			assertTrue(type(driver,txtNumVisit,refData.numVisits1),"Could not enter numVisits1; More Details :" + refData.toString(),driver,className,methodName);
			selectValueFromAjaxList(driver,ajxNumVisit,refData.numVisitType);
			//Assert.assertTrue(type(driver,ajxNumVisit,refData.numVisitType),"Could not enter numVisits Type; More Details :" + refData.toString());
			if(!refData.requestDate2.equals("")){
			waitForElementToEnable(driver,txtRequestDate);
			waitForPageLoad(driver);
			click(driver,txtRequestDate);
			assertTrue(enterDate(driver,txtRequestDate,refData.requestDate2),"Could not enter the request Date; More Details :" + refData.toString(), driver, className, methodName);
			waitForPageLoad(driver);
			}
			if(!refData.approvalDate2.equals("")){
				waitForElementToEnable(driver,txtApprovalDate);
				waitForPageLoad(driver);
				assertTrue(isElementPresent(driver,txtApprovalDate)," ", driver, className, methodName);
				assertTrue(enterDate(driver,txtApprovalDate,refData.approvalDate2),"Could not enter the approvalDate; More Details :" + refData.toString(), driver, className, methodName);
			}
			assertTrue(type(driver,txtAuthorizationNum,refData.authorizationNum2),"Could not enter authorizationNum; More Details :" + refData.toString(), driver, className, methodName);
			
			assertTrue(type(driver,txtNumAuthorizationVisit,refData.numAuthorizedVisits2),"Could not enter numAuthorizedVisits; More Details :" + refData.toString(), driver, className, methodName);
			assertTrue(enterDate(driver,txtStartDate1,refData.startDate2),"Could not enter the start Date; More Details :" + refData.toString(), driver, className, methodName);
			assertTrue(enterDate(driver,txtEndDate1,refData.endDate2),"Could not enter the end Date; More Details :" + refData.toString(), driver, className, methodName);
			selectValueFromAjaxList(driver,ajxCPT, refData.cptSuggestBox2);
			}
			assertTrue(click(driver,btnSave),"Could not click Save Button; More Details :" + refData.toString(), driver, className, methodName);
			waitForPageLoad(driver);
			if(isElementPresent(driver, btnAddReferral)){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + refData.toString());		
			return false;
		}
	}
	
	/**
	 * createReferralWithMandatory
	 * function to create a Referral
	 * @throws IOException 
	 * @since  	     May 08, 2012
	 */	
	public boolean createReferralWithMandatory(WebDriver driver, HomeLib refData) throws Exception{
		
		try{		
			waitForPageLoad(driver);
			selectValueFromAjaxList(driver,ajxReferralType, refData.refType);
			
			selectValueFromAjaxList(driver,ajxReferredBy, refData.refBy);
			
			selectValueFromAjaxList(driver,ajxReferralDiagnoses, refData.diagCode);
			
			assertTrue(enterDate(driver,txtReferralDate, refData.referralDate),"Could not enter referral date; More Details :" + refData.toString(), driver, className, methodName);
			if(!refData.testCaseId.equals("TC_CRL_008")){
			assertTrue(click(driver,btnSave),"Could not click Save Button; More Details :" + refData.toString(), driver, className, methodName);
			waitForPageLoad(driver);
			
			}
			if(isElementPresent(driver, lnkReferrals)){
				return true;
			}else{
				return false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + refData.toString());		
			return false;
		}
	}
	/**
	 * deleteAllReferral
	 * function to delete All Referral
	 * @throws IOException 
	 * @since  	    Aug 14, 2012
	 */
	public boolean deleteAllReferral(WebDriver driver) throws Exception{
		
		int referralCount = 0;
		
			waitForElement(driver, lnkDeleteReferrals, WAIT_TIME);
			while((Integer) getXpathCount(driver,lnkDeleteReferrals) > 0){
				referralCount = (Integer) getXpathCount(driver,lnkDeleteReferrals);
				assertTrue(click(driver,lnkDeleteReferrals)," ", driver, className, methodName);
				assertTrue(click(driver,btnYesButton)," ", driver, className, methodName);
				waitForPageLoad(driver);
				if(referralCount == (Integer)getXpathCount(driver,lnkDeleteReferrals)){
					break;
				}
			}
			return true;
		}
	/**
	 * verifyTimeStamp
	 * function to verify referral with time stamp
	 * @throws IOException 
	 * @since   Aug 14, 2012
	 */
	public boolean verifyTimeStamp(WebDriver driver , By elementId, String date, String time)throws Exception{
		boolean returnValue=false;
		try{
			String lastUpdate="Last updated by";
			if(getText(driver,elementId).contains(lastUpdate))
				waitForPageLoad(driver);
				if(getText(driver, elementId).contains(date))
					waitForPageLoad(driver);					
					if(getText(driver, elementId).contains(time))
						
						returnValue = true;
					
			else{
				Assert.fail("Time stamp is not present in summary page");
				returnValue = false;
			}
			return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * verifyStoredValuesReferrals
	 * function to verify stored values referrals
	 * @throws IOException 
	 * @since   Aug 14, 2012
	 */
	public boolean verifyStoredValuesReferrals(WebDriver driver, HomeLib refData)throws Exception{
		waitForPageLoad(driver);
		if(!getValue(driver,ajxReferralType).trim().contains(refData.refType.trim())){
			return false;
		}
		if(!getValue(driver,ajxReferredBy).trim().equalsIgnoreCase(refData.refBy.trim())){
			return false;
		}
		/*if(!getValue(driver,ajxAddress).trim().contains(refData.addr.trim())){
			return false;
		}*/
		if(!getValue(driver,ajxReferedTo).trim().contains(refData.refTo.trim())){
			return false;
		}
		if(!getValue(driver,ajxReferralSpecial).trim().contains(refData.speciality.trim())){
			return false;
		}
		if(!getValue(driver,ajxReferralDiagnoses).trim().contains(refData.diagCode.trim())){
			return false;
		}
		if(!getValue(driver,txtReferralReason).trim().contains(refData.referralReason.trim())){
			return false;
		}
		if(!getValue(driver,txtReferralDate).trim().contains(refData.referralDate.trim())){
			return false;
		}
		if(!getValue(driver,txtReferralEndDate).trim().contains(refData.referralEndDate.trim())){
			return false;
		}
		if(!getValue(driver,txtReferralComments).trim().contains(refData.refComments.trim())){
			return false;
		}
		if(!getValue(driver,ajxPayer).trim().contains(refData.payer.trim())){
			return false;
		}
		if(!getValue(driver,txtNumVisit).trim().contains(refData.numVisits1.trim())){
			return false;
		}
		if(!getValue(driver,txtRequestDate).trim().contains(refData.requestDate2.trim())){
			return false;
		}
		if(!getValue(driver,txtApprovalDate).trim().contains(refData.approvalDate2.trim())){
			return false;
		}
		if(!getValue(driver,txtAuthorizationNum).trim().contains(refData.authorizationNum2.trim())){
			return false;
		}
		if(!getValue(driver,txtNumAuthorizationVisit).trim().contains(refData.numAuthorizedVisits2.trim())){
			return false;
		}
		if(!getValue(driver,txtStartDate1).trim().contains(refData.startDate2.trim())){
			return false;
		}
		if(!getValue(driver,txtEndDate1).trim().contains(refData.endDate2.trim())){
			return false;
		}
		return true;
	}

	/**
	 * verifyStoredValuesForMandatoryReferrals
	 * function to verify stored values referrals with mandatory fields
	 * @throws IOException 
	 * @since   Aug 14, 2012
	 */
	public boolean verifyStoredValuesForMandatoryReferrals(WebDriver driver, HomeLib refData){
		waitForPageLoad(driver);
		if(!getValue(driver,ajxReferralType).trim().contains(refData.refType.trim())){
			return false;
		}
		if(!getValue(driver,ajxReferredBy).trim().equalsIgnoreCase(refData.refBy.trim())){
				
			return false;
		}
		if(!getValue(driver,txtReferralDate).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(refData.referralDate.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
	/**
	 * verifyStoredValues
	 * function to verify stored values in referrals
	 * @throws IOException 
	 * @since   Aug 14, 2012
	 */
public boolean verifyStoredValues(WebDriver driver, HomeLib refData) throws IOException{
		
		assertTrue(isElementPresent(driver,lblNoDetailsAdded), 
				"Not able to find element - No Detail List", driver, className, methodName);
		return true;
	}
	
/**
 * verifySelectOptionsInReferral
 * function to verify select options a Referral
 * @throws IOException 
 * @since  	     July 05, 2012
 */	
public boolean verifySelectOptionsInPatientReferral(WebDriver driver, HomeLib refData) throws Exception{
	boolean returnValue=false;
	try{		
		waitForPageLoad(driver);
		selectValueFromAjaxList(driver,ajxReferralType, refData.refType);
		driver.findElement(ajxReferralType).click();
		waitForPageLoad(driver);
		if(isElementPresent(driver,lblItemSelected))
		{
			if(getText(driver,lblItemSelected).equalsIgnoreCase(refData.refType))
				{
					returnValue=true;
					click(driver,lblItemSelected);
				}
		}
		else
			return false;	
		selectValueFromAjaxList(driver,ajxReferredBy, refData.refBy);
		driver.findElement(ajxReferredBy).click();
		waitForPageLoad(driver);
		if(isElementPresent(driver,lblItemSelected))
		{
			if(getText(driver,lblItemSelected).equalsIgnoreCase(refData.refBy))
				{
					returnValue=true;
					click(driver,lblItemSelected);
				}
		}
		else
		{
			return false;
		}
		selectValueFromAjaxList(driver,ajxReferedTo, refData.refTo);
		driver.findElement(ajxReferedTo).click();
		waitForPageLoad(driver);
		if(isElementPresent(driver,lblItemSelected))
		{
			if(getText(driver,lblItemSelected).equalsIgnoreCase(refData.refTo))
				{
					returnValue=true;
					click(driver,lblItemSelected);
				}
		}
		else
		{
			return false;
		}
		selectValueFromAjaxList(driver,ajxReferralDiagnoses, refData.diagCode);
		driver.findElement(ajxReferralDiagnoses).click();
		waitForPageLoad(driver);
		if(isElementPresent(driver,lblItemSelected))
		{
			if(getText(driver,lblItemSelected).equalsIgnoreCase(refData.diagCode))
				{
					returnValue=true;
					click(driver,lblItemSelected);
				}
		}
		else
		{
		        return false;
		}
		assertTrue(click(driver,btnAddAuthorization),"Could not click on add Authorization Button; More Details :" + refData.toString(), driver, className, methodName);
		selectValueFromAjaxList(driver,ajxNumVisit, refData.numVisitType);
		driver.findElement(ajxNumVisit).click();
		waitForPageLoad(driver);
		if(isElementPresent(driver,lblItemSelected))
		{
			if(getText(driver,lblItemSelected).equalsIgnoreCase(refData.numVisitType))
				{
					returnValue=true;
					click(driver,lblItemSelected);
				}
		}
		else
			return false;	
		
		
	}catch (RuntimeException e){
		e.printStackTrace();
		Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + refData.toString());		
		return false;
	}
	return returnValue;
}

/**
 * searchPatientNexia
 * function for Searching a patient in the Nexia application for NoAccess (Mix Security)   
 * @param 		selenium
 * @param 		patientID (Patient ID to be searched)
 * @throws IOException 
 
 * @since  	     Feb 20 21, 2014
 */

public boolean searchPatientNexiaMixSecurityNoAccess(WebDriver driver,String patientID) throws Exception{
	try{
		
	assertTrue(!isTextPresent(driver,"No permission"),"No Permission Present",driver, className, methodName);
	assertTrue(!isTextPresent(driver,"error")," Error Message Present",driver, className, methodName);	
		
	if(isElementPresent(driver, btnErrorClose))
		assertTrue(click(driver, btnErrorClose), "could not click error close", driver, className,methodName);
	assertTrue(type(driver,txtPatientBox,patientID),"Could not type patient id", driver, className,methodName);
	driver.findElement(txtPatientBox).sendKeys(Keys.ENTER);	
	waitForElement(driver,lblPatientResult,10000);		
	assertTrue(!isElementPresent(patientInfo),"Search Results are displayed for the patient with ID :-"+patientID, driver, className,methodName);
	assertTrue(!getText(driver,patientWidget).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientID.trim().toLowerCase(new java.util.Locale("en","US"))),"could not click error close", driver, className,methodName);
			
	}		
	catch(RuntimeException e){
		e.printStackTrace();
	}
	return true;
}	

	public void clickArrow(){
		click(lnkArrow);
		waitForPageLoad(driver);
	}
	/**
	 * verifySchedulingInReferralSummary
	 * function to verify scheduling details in Referral  summary
	 * @param 	authoNumber- authorization number
	 * @param 	visitsScheduled- visits Scheduled
	 * @param 	visitsAllowed- visits Allowed
	 * @param 	visitsUsed- visits Used
	 * @param 	testCaseID- testCase ID
	 * @throws  Exception 
	 * @since  	Dec 17, 2014
	 * @version 2.1
	 */
	
	public boolean verifySchedulingInReferralSummary(String authoNumber, String visitsScheduled,String visitsAllowed, String visitsUsed, String testCaseID){
		clickArrow();
		if(!authoNumber.equals(""))
			assertTrue(isTextPresent(driver,"Authorization Number: "+authoNumber), "Proper Authorization number not present" , driver, className, methodName);
		if(!visitsAllowed.equals(""))
			assertTrue(isTextPresent(driver,"Number of visits allowed: "+visitsAllowed), "Proper Visits number not present" , driver, className, methodName);
		if(!visitsUsed.equals(""))
			assertTrue(isTextPresent(driver,"Number of visits used: "+visitsUsed), "Proper Visits number not present" , driver, className, methodName);
		if(!visitsScheduled.equals(""))
			assertTrue(isTextPresent(driver,"Number of visits scheduled: "+visitsScheduled), "Proper Visits number not present" , driver, className, methodName);
		
		return true;
		
	}
	
	/**
	 * verifySchedulingInReferralSummary
	 * function to verify scheduling details in Referral  summary
	 * @param 	inOut- inGoing/outGoing
	 * @param 	providerPracticeBy- Provider name By/Practice name By
	 * @param 	providerPracticeTo- Provider name To/Practice name To
	 * @param 	Date- Date Created
	 * @throws  Exception 
	 * @since   May 12, 2015
	 * @version 2.1
	 */
	public boolean verifyReferralSummary(String inOut, String providerPracticeBy, String providerPracticeTo, String Date){
		clickArrow();
		try {
				if(!inOut.equals(""))
				assertTrue(getText(driver, lnkReferralValue).toLowerCase().contains(inOut.toLowerCase()), "Proper Referral type not present" , driver, className, methodName);
			
				if(!providerPracticeBy.equals(""))
					assertTrue(getText(driver, lnkReferralValue).toLowerCase().contains(providerPracticeBy.toLowerCase()), "Proper Referred by is not present" , driver, className, methodName);
				
				if(!providerPracticeTo.equals(""))
					assertTrue(getText(driver, lnkReferralValue).toLowerCase().contains(providerPracticeTo.toLowerCase()), "Proper Referred To is not present" , driver, className, methodName);
				
				if(!Date.equals(""))
					assertTrue(getText(driver, lnkReferralValue).toLowerCase().contains(Date.toLowerCase()), "Proper Referral date is not present" , driver, className, methodName);
			} catch(Exception e){

			       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
			}      
 		return true;
		
	}
	/**
	 * clickAddReferral
	 * function to click Add Referral Button
	 * @param 	referralsPage- Page
	 * @throws  Exception 
	 * @since  	Dec 17, 2014
	 * @version 2.1
	 */
	public void clickAddReferral(){
		click(driver, btnAddReferral);
	}
	
	//public void verifyReferral

	/**
	 * verifyReferralDetails
	 * function to verify Referral Details
	 * @param driver,referralData,date
	 * @since  	May 12, 2015
	 */	
	
	public boolean verifyReferralDetails(WebDriver driver,ChartPreVisitLib referralData,String date)throws Exception
	{
		assertTrue(isTextPresent(driver,referralData.referral1), "Couldn't find Referred By Provider" , driver, className, methodName);
		
		assertTrue(isTextPresent(driver,referralData.otherReferral), "Couldn't find Referred To Provider" , driver, className, methodName);
		
		assertTrue(isTextPresent(driver,"Outgoing"), "Couldn't find Outgoing Provider type" , driver, className, methodName);
		
		assertTrue(isTextPresent(driver,date), "Couldn't find Correct Date" , driver, className, methodName);
		
		
		
		return true;
	}
	
	
}
