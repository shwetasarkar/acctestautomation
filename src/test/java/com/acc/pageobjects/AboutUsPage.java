package com.acc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acc.utilities.Utility;

public class AboutUsPage {

	public WebDriver driver;
	Utility utility;
	
	public AboutUsPage(WebDriver _driver) {
		driver = _driver;
		utility = new Utility(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[href*='/working-at-acc/']")
	private WebElement workingAtLink;
	
	public void clickOnWorkingAtLink() throws Throwable
	{
		utility.scrollWithOffset(workingAtLink, 20, 20);
		utility.click(workingAtLink, "workingAtLink");
	}
}
