	package com.acc.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.acc.cucumberhelper.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	TestContext testContext;

	public Hooks(TestContext testcontext) {
		this.testContext = testcontext;
	}

	@Before()
	public void driverSetup() {
		// database connection setup
		// anything before scenario
	}

	@After(order = 0)
	public void afterScenario() {
		System.setProperty("cucumber.reporting.config.file", "src/test/resources/configs/cucumber-reporting.properties");
		testContext.getBaseClass().closeDriver();
	}

	@After(order = 1)
	public void embedScreenshotOnFail(Scenario sceanrio) {
		if (sceanrio.isFailed())
			try {
				byte[] screenshot = ((TakesScreenshot) testContext.getBaseClass().getDriver())
						.getScreenshotAs(OutputType.BYTES);
				sceanrio.embed(screenshot, "image/png", sceanrio.getName());
			} catch (Exception e) {
				throw e;
			}
	}
}
