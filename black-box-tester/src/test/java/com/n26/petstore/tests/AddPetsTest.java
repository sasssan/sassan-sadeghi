package com.n26.petstore.tests;


import com.n26.TestRunnerBase;
import cucumber.api.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features/petstore/add-new-pets.feature",
        glue = {"com.n26.petstore.steps"},
        plugin = {"json:target/cucumber-reports/addPets.json"}
)
public class AddPetsTest extends TestRunnerBase {
}
