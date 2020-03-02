package com.acc.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(strict=true, 
                 features="features/searchJobs.feature", 
                 glue= {"com.acc"},
                 plugin= { "de.monochromata.cucumber.report.PrettyReports:target/cucumber" },
                 monochrome= true
                 )

public class TestRunnerJunit {
	
}
