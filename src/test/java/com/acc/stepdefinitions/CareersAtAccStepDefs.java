package com.acc.stepdefinitions;

import org.junit.Assert;

import com.acc.cucumberhelper.TestContext;
import com.acc.pageobjects.CareersAtAccPage;

import io.cucumber.java.en.Then;

public class CareersAtAccStepDefs {

	TestContext testContext;
	CareersAtAccPage careersAtAccPage;

	public CareersAtAccStepDefs(TestContext _testContext) {

		testContext = _testContext;
		careersAtAccPage = testContext.getPageObjectManager().getCareersAtAccPage();
		
	}
	
	
	@Then("I search {string} jobs in {word}")
	public void i_search_jobs_in_given_Location(String jobName, String location) throws Throwable {
	  careersAtAccPage.typeJobName(jobName);
	  careersAtAccPage.selectLocation(location);
	  careersAtAccPage.clickOnSearchButton();
	}

	@Then("I verify {string} in the results")
	public void i_verify_jobName_in_the_results(String jobName) throws Throwable {
	   Assert.assertTrue( "Job name not present in the list", careersAtAccPage.verifyJobNameFromSearchList(jobName));
	}
}
