package com.acc.stepdefinitions;

import com.acc.cucumberhelper.TestContext;
import com.acc.pageobjects.WorkingAtAccPage;

import io.cucumber.java.en.When;

public class WorkingAtAccStepDefs {
	
	TestContext testContext;
	WorkingAtAccPage workingAtAccPage;

	public WorkingAtAccStepDefs(TestContext _testContext) {

		testContext = _testContext;
		workingAtAccPage = testContext.getPageObjectManager().getWorkingAtAccPage();
		
	}

	@When("I click on careers and navigate to Careers page")
	public void i_click_on_careers_and_navigate_to_Careers_page() throws Throwable {
		workingAtAccPage.clickOnCarreerAtAccLink();

	}

}
