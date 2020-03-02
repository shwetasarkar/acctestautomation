package com.acc.stepdefinitions;

import com.acc.cucumberhelper.TestContext;
import com.acc.pageobjects.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageStepDefs {

	
	TestContext testContext;
	HomePage homePage;

	public HomePageStepDefs(TestContext _testContext) {

		testContext = _testContext;
		homePage = testContext.getPageObjectManager().getHomePage();
		
	}
		
	@Given("I am on homepage")
	public void i_am_on_homepage() {

	}

	@When("I click on about us")
	public void i_click_on_about_us() throws Throwable {

		homePage.clickOnAboutUs();
	}

	

		
}
