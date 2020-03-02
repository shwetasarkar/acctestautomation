package com.acc.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acc.utilities.Utility;
import com.acc.utilities.Log;

public class CareersAtAccPage {

	public WebDriver driver;
	Utility utility;
	static Logger log = LogManager.getLogger(Utility.class.getName());

	public CareersAtAccPage(WebDriver _driver) {
		driver = _driver;
		utility = new Utility(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="keyword")
	private WebElement jobSearchField;

	@FindBy(id="jLocInputHldr")
	private WebElement locationSearchField;

	@FindBy(css="input[value='All locations']")
	private WebElement locationSearchBox;

	@FindBy(css="[class='chzn-results']>[class='active-result highlighted']")
	private WebElement locationDropDown;

	//	@FindBy(css="[data-dropdowntype^='Locations']")
	//	private WebElement locationDropDown;

	@FindBy(id="jSearchSubmit")
	private WebElement searchButton;

	@FindAll(@FindBy(css="[id='jResultsArea']  a[class^='job_link']"))
	private List<WebElement> jobSearchResultList;

	@FindBy(css="[class$='jSearchTitle']")
	private WebElement jobSearchTitle;

	private String locationLocator = "//ul[@class='chzn-results']/li[text()='%s']";
	
	//Your search matching keyword(s) Devloper did not return any job results.

	public void typeJobName(String jobName) throws Throwable
	{
		Utility.waitForPageLoaded(driver);
		utility.SendKeys(jobSearchField, jobName);
	}

	public void selectLocation(String locationValue) throws Throwable
	{
		utility.click(locationSearchField, "locationSearchField");
		utility.click(driver.findElement(By.xpath(String.format(locationLocator, locationValue))), "location");
	}

	public void clickOnSearchButton() throws Throwable
	{
		utility.click(searchButton, "searchButton");

	}

	public boolean verifyJobNameFromSearchList(String jobName) throws Throwable
	{
		boolean flag=false;
		utility.waitUntilVisible(jobSearchTitle);
		if(jobSearchResultList.size()>0)
		{
			for (WebElement result : jobSearchResultList) {
				if(result.getAttribute("text").contains(jobName)) {
					flag = true;
					break;
				}
			}
		}

		if(flag==false)
		{
			Log.logInfo(log, "No matching job results found " +jobName);
		}else if(flag==true)
		{
			Log.logInfo(log, "Matching job results found " +jobName);
		}
		return flag;
	}
}

	