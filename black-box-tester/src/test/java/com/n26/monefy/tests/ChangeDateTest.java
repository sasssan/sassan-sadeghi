package com.n26.monefy.tests;


import com.n26.TestRunnerBase;
import cucumber.api.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features/monefy/change-date.feature",
        glue = {"com.n26.monefy.steps"},
        plugin = {"json:target/cucumber-reports/changeDate.json"}
)
public class ChangeDateTest extends TestRunnerBase {
}
