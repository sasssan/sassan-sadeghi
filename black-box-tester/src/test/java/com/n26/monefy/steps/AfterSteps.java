package com.n26.monefy.steps;

import com.n26.monefy.pages.HomePO;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class AfterSteps {

    @SneakyThrows
    @After()
    public void afterAll(Scenario scenario) {
        HomePO.getDriver().closeApp();
        HomePO.getDriver().quit();
    }
}
