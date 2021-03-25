package com.n26.monefy.tests;

import com.n26.TestRunnerBase;
import cucumber.api.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features/monefy/accounts-transfer.feature",
        glue = {"com.n26.monefy.steps"},
        plugin = {"json:target/cucumber-reports/accountsTransfer.json"}
)
public class AccountsTransferTest extends TestRunnerBase {
}
