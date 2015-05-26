package com.projectname.testutils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.projectname.testutils.genericutility.ExceptionHandler;
import com.projectname.testutils.genericutility.testDataLib.ChartPreVisitLib;
import com.projectname.testutils.seleniumutils.SeleniumWebDriver;

public class SocialHistoryPage extends SeleniumWebDriver {

	private By readyLocator = By.id("socialHistoryQuicklist");
	
	private By ajxSocialHistoryType = By.id("typeSuggestBoxsuggestBox");
	private By txtStatus = By.id("statusSuggestBoxsuggestBox");
	private By txtsocialHistoryQuicklist = By.id("socialHistoryQuicklist");
	private By txtdetailsNum = By.id("detailsNum");
	private By txtDetailsSmallTextBox = By.id("detailsSmallTextBox");
	private By ajxPeriodSuggestBox = By.id("periodSuggestBoxsuggestBox");
	private By txtYear = By.id("year");
	private By txtStartAge = By.id("startAge");
	private By ajxStoppedOngoingSuggestBox = By.id("stoppedOngoingSuggestBoxsuggestBox");
	private By ajxStopAge = By.id("stopAge");
	
	private By ajxLifeStageSuggestBox = By.id("lifeStageSuggestBoxsuggestBox");
	private By txtSummaryComment = By.id("summaryComment");	
	private By lnkMoreDetails = By.id("medicationsMoreDetails");
	
	private By btnAdd = By.id("add");
	private By btnSaveSocialHistory = By.id("saveSocialHistory");
	
	private By btnEditSocialHistory = By.xpath("//a[contains(text(),'Edit')]");
	
	private By btnEditSaveSocialHistory = By.id("saveSocialHistoryEdit");
	

	
	
	public SocialHistoryPage(){
		PageFactory.initElements(SeleniumWebDriver.driver, this);	
		SeleniumWebDriver.isElementPresent(readyLocator);
	}
	
	/**
	 * createSocialHistory
	 * function to create Social History
	 * @param driver
	 * @since  	May 20, 2015
	 */	
	public boolean createSocialHistoryEndToEnd(WebDriver driver,ChartPreVisitLib socialHisData, String account) throws Exception {
     try{
    	 if (!socialHisData.type.equals("")){
	    	verifyTrue(selectValueFromAjaxList(driver,ajxSocialHistoryType,socialHisData.type),"Could not enter Social History Type",driver);
	      //	waitForPageLoad(driver);
    	 }
    	 if (!socialHisData.status.equals("")){
 	    	verifyTrue(selectValueFromAjaxList(driver,txtStatus,socialHisData.status),"Could not enter Social History status Type",driver);
 	      //	waitForPageLoad(driver);
     	 }
       	verifyTrue(click(driver,lnkMoreDetails),"Could not click show more link",driver);
	   	waitForPageLoad(driver);
	    if (!socialHisData.item.equals("")){
	    	verifyTrue(type(driver,txtsocialHistoryQuicklist,socialHisData.item),"Could not enter Social History Item",driver);
	      //	waitForPageLoad(driver);
    	 }
	    if (!socialHisData.detailsNum.equals("")){
	    	verifyTrue(type(driver,txtdetailsNum,socialHisData.detailsNum),"Could not enter details num",driver);
	      //	waitForPageLoad(driver);
    	 }
	    if (!socialHisData.detailsText.equals("")){
	    	verifyTrue(type(driver,txtDetailsSmallTextBox,socialHisData.detailsText),"Could not enter details text",driver);
	      //	waitForPageLoad(driver);
    	 }
	    if (!socialHisData.period.equals("")){
	    	verifyTrue(selectValueFromAjaxList(driver,ajxPeriodSuggestBox,socialHisData.period),"Could not enter details text",driver);
	      //	waitForPageLoad(driver);
    	 }
	    if (!socialHisData.year.equals("")){
	    	verifyTrue(type(driver,txtYear,socialHisData.year),"Could not enter details year",driver);
	      //	waitForPageLoad(driver);
    	 }
	    if (!socialHisData.startAge.equals("")){
	    	verifyTrue(type(driver,txtStartAge,socialHisData.startAge),"Could not enter Start age",driver);
	      //	waitForPageLoad(driver);
    	 }
	    if (!socialHisData.historyType.equals("")){
	    	verifyTrue(selectValueFromAjaxList(driver,ajxStoppedOngoingSuggestBox,socialHisData.historyType),"Could not select Stopped type",driver);
	      	//waitForPageLoad(driver);
    	 }
	    if (!socialHisData.stopAge.equals("")){
	    	verifyTrue(type(driver,ajxStopAge,socialHisData.stopAge),"Could not enter Stop age",driver);
	      	//waitForPageLoad(driver);
    	 }
	    if (!socialHisData.lifeStage.equals("")){
	    	verifyTrue(selectValueFromAjaxList(driver,ajxLifeStageSuggestBox,socialHisData.lifeStage),"Could not select lifeStage",driver);
	      //	waitForPageLoad(driver);
    	 }
	    if (!socialHisData.comment.equals("")){
	    	verifyTrue(type(driver,txtSummaryComment,socialHisData.comment),"Could not enter comment",driver);
	      //	waitForPageLoad(driver);
    	 }
	    
		} catch (RuntimeException e) {
			new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
	    }
	    return true;
	}
	
	/**
	 * saveSummarySocialHistory function to a Social History
	 * @param driver  	
	 * @since May 21, 2015
	 * @version 2.1
	 */
	
	public boolean saveSummarySocialHistory(WebDriver driver)
	{
		try{
			verifyTrue(click(driver, btnAdd), "add button not found", driver);
			waitForPageLoad(driver);
			verifyTrue(click(driver, btnSaveSocialHistory), "btn Save Social History not found", driver);
			
			waitForPageLoad(driver);
		}
		catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}
	
	/**
	 * clickEditEncounterSocialHistory function to a Social History
	 * @param driver  	
	 * @since May 21, 2015
	 * @version 2.1
	 */
	
	public boolean clickEditEncounterSocialHistory(WebDriver driver)
	{
		try{
			verifyTrue(click(driver, btnEditSocialHistory), "Social History Edit button not found", driver);
			waitForPageLoad(driver);
	
		}
		catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}
	/**
	 * clickSaveEditSocialHistory function to a Click Save button
	 * @param driver
	 * @since May 21, 2015
	 * @version 2.1
	 */
	
	public boolean clickSaveEditSocialHistory(WebDriver driver)
	{
		try{
			verifyTrue(click(driver, btnEditSaveSocialHistory), "Edit save button not found", driver);
			waitForPageLoad(driver);
		}catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}
	
	
	/**
	 * clickSaveSummaryEditSocialHistory function to a Click Save button
	 * @param driver
	 * @since May 21, 2015
	 * @version 2.1
	 */
	
	public boolean clickSaveSummaryEditSocialHistory(WebDriver driver)
	{
		try{
			verifyTrue(click(driver, btnSaveSocialHistory), "Edit save button not found", driver);
			waitForPageLoad(driver);
		}catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}
	
	
	/**
	 * addEncounterSocialHistory function to a Click Add button
	 * @param driver
	 * @since May 22, 2015
	 * @version 2.1
	 */
	
	public boolean addEncounterSocialHistory(WebDriver driver)
	{
		try{
			verifyTrue(click(driver, btnAdd), "Add button not found", driver);
			waitForPageLoad(driver);
			waitForPageLoad(driver);
		}catch(Exception e){
		       new ExceptionHandler(e, driver, getCustomAttributeValue(getCurrentMethodName(), "", "", "fail", "", getCallingMethodAndLineNumber()) );
		}  
		return true;
	}
	
	

}
