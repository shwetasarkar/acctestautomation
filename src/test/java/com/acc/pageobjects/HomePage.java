package com.acc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acc.utilities.Utility;

public class HomePage {

	public WebDriver driver;
	Utility utility;
	
	public HomePage(WebDriver _driver) {
		driver = _driver;
		utility = new Utility(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[href='/about-us/']")
	private WebElement aboutUsLink;
	
	
	public void clickOnAboutUs() throws Throwable
	{
		utility.click(aboutUsLink, "aboutUsLink");
	}
	
}
