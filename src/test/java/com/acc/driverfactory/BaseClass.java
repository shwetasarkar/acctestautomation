package com.acc.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.acc.enums.DriverType;
import com.acc.manager.FileReaderManager;
import com.acc.utilities.Utility;



public class BaseClass {

	private WebDriver driver;
	private static DriverType drivertype;
	private static final String CHROME_DRIVER_PROPERTY= "webdriver.chrome.driver";

	
	public BaseClass()
	{
		drivertype= FileReaderManager.getInstance().getConfigReader().getBrowserName();
	}

	public WebDriver getDriver()
	{
		if(driver==null)
			driver= setDriver();

		return driver;
	}


	private WebDriver setDriver()
	{
		switch(drivertype)
		{
		case CHROME:
			getChromeDriver();
			break;

			//firefox driver code is not added
		case FIREFOX:
			getFirefoxDriver();
			break;
			//iexplorer driver code is not added
		case INTERNETEXPLORER:
			getInternetExplorer();
			break;
		}

		return driver;
	}

	public void closeDriver() {
		driver.close();
	}
	public void quitDriver() {
		driver.close();
		driver.quit();
	}

	//	public void launchChromeDriver()
	public void getChromeDriver()
	{
		System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getChromeDriverPath());
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	    Utility.waitForPageLoaded(driver);

	}
	public void getFirefoxDriver()
	{

	}
	public void getInternetExplorer()
	{

	}



}
