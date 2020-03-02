package com.acc.manager;

import org.openqa.selenium.WebDriver;
import com.acc.pageobjects.CareersAtAccPage;
import com.acc.pageobjects.AboutUsPage;
import com.acc.pageobjects.HomePage;
import com.acc.pageobjects.WorkingAtAccPage;

public class PageObjectManager {

	private WebDriver driver;

	private HomePage homePage;

	private AboutUsPage aboutUsPage;

	private WorkingAtAccPage workingAtAccPage;
	
	private CareersAtAccPage careersAtAccPage;

	public PageObjectManager(WebDriver _driver)
	{
		driver = _driver;	
	}

	public HomePage getHomePage()
	{
		if(homePage==null)
			homePage= new HomePage(driver);
		return homePage;
	}

	public AboutUsPage getAboutUsPage()
	{
		if(aboutUsPage==null)
			aboutUsPage= new AboutUsPage(driver);
		return aboutUsPage;
	}

	public WorkingAtAccPage getWorkingAtAccPage()
	{
		if(workingAtAccPage==null)
			workingAtAccPage= new WorkingAtAccPage(driver);
		return workingAtAccPage;
	}

	public CareersAtAccPage getCareersAtAccPage()
	{
		if(careersAtAccPage==null)
			careersAtAccPage=new CareersAtAccPage(driver);
		return careersAtAccPage;
	}
	
	
}
