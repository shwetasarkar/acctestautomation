package com.acc.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acc.utilities.Utility;

public class WorkingAtAccPage {
	
	public WebDriver driver;
	Utility utility;
	
	public WorkingAtAccPage(WebDriver _driver) {
		driver = _driver;
		utility = new Utility(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="a[title='Find jobs at ACC']")
	private WebElement careetAtAccLink;
	
	public void clickOnCarreerAtAccLink() throws Throwable
	{
		utility.scrollWithOffset(careetAtAccLink, 5, 5);
		utility.Jsclick(careetAtAccLink, "careetAtAccLink");
	}
}
