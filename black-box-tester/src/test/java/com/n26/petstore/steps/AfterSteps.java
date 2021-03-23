package com.n26.petstore.steps;

import com.n26.petstore.clients.PetStoreRestClient;
import com.n26.petstore.clients.RestClientBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@AllArgsConstructor
public class AfterSteps {

    private PetStoreRestClient petStore;


    @After()
    public void afterAll(Scenario scenario) {
        handleRestFailure(scenario, petStore);
    }

    /**
     * logs the latest captured responses from apis in case of failure
     *
     * @param scenario
     * @param apis
     */
    protected void handleRestFailure(Scenario scenario, RestClientBase... apis) {
        if (scenario.isFailed()) {
            scenario.write("\nTest Failed. Last captured response(s) from API(s): \n");
            for (RestClientBase api : apis) {
                scenario.write(api.getName() + ":\n" + api.getPrettyResponse());
            }
        } else {
            scenario.write("Test Passed.");
        }
    }
}
