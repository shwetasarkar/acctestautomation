package com.acc.stepdefinitions;

import com.acc.cucumberhelper.TestContext;
import com.acc.pageobjects.AboutUsPage;

import io.cucumber.java.en.When;

public class AboutUsPageStepDefs {
	
	
	TestContext testContext;
	AboutUsPage aboutUsPage;

	public AboutUsPageStepDefs(TestContext _testContext) {

		testContext = _testContext;
		aboutUsPage = testContext.getPageObjectManager().getAboutUsPage();
		
	}
	
	@When("I click on working at ACC")
	public void i_click_on_working_at_ACC() throws Throwable {

		aboutUsPage.clickOnWorkingAtLink();
	}

}
