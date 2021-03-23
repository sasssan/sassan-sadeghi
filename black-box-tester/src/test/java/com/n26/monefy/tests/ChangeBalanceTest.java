package com.n26.monefy.tests;


import com.n26.TestRunnerBase;
import cucumber.api.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features/monefy/change-balance.feature",
        glue = {"com.n26.monefy.steps"},
        plugin = {"json:target/cucumber-reports/changeBalance.json"}
)
public class ChangeBalanceTest extends TestRunnerBase {
}
