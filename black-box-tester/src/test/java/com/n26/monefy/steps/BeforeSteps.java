package com.n26.monefy.steps;

import com.n26.TestConfig;
import com.n26.TestRunnerBase;
import com.n26.monefy.pages.AmountPO;
import com.n26.monefy.pages.CalendarMenuPO;
import com.n26.monefy.pages.HomePO;
import com.n26.monefy.pages.ThreeDotsMenuPO;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;


@Slf4j
@AllArgsConstructor
public class BeforeSteps {
    HomePO homePage;
    AmountPO amountPage;
    CalendarMenuPO calendarMenu;
    ThreeDotsMenuPO threeDotsMenu;

    @SneakyThrows
    @Before()
    public void beforeAll(Scenario scenario) {
        TestConfig props = TestRunnerBase.getProps();

        // Set the desired capabilities.
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(DEVICE_NAME, props.getDeviceName());
        dc.setCapability(PLATFORM_NAME, props.getPlatformName());
        dc.setCapability(APP, props.getApkPath());

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL(props.getAppiumURL()), dc);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(props.getDefaultTimeoutMilSec()),
                TimeUnit.MILLISECONDS);


        homePage.setDriver(driver);
        amountPage.setDriver(driver);
        calendarMenu.setDriver(driver);
        threeDotsMenu.setDriver(driver);
    }
}
