package com.n26;


import com.n26.petstore.clients.RestClientBase;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

/**
 * The parent class for all test runners.
 * Contains all the configuration steps necessary to be carried out before and after the execution of test cases.
 */
@Slf4j
@CucumberOptions(
        strict = true
)
public class TestRunnerBase extends AbstractTestNGCucumberTests {

    private static final String timeStamp = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
    @Getter
    private static String reportPath = null;
    @Getter
    private static TestConfig props = null;
//    @Getter
//    private static AndroidDriver<AndroidElement> driver;

    @BeforeSuite
    public void beforeSuite() {
        config();
//        initDriver();
        deleteExistingReportDir();
        reportPath = System.getProperty("reportPath") == null ? "target/test-reports-" + timeStamp : System.getProperty("reportPath");

    }

    @AfterSuite
    public void afterSuite() {
        TestReportGenerator.generate(props);
    }


    /**
     * Reads and saves the properties file
     *
     * @throws Exception
     */
    public static void config() {
        Config common = ConfigFactory.load("local-config.conf");
        Config envOverrides = ConfigFactory.systemProperties()
                .withFallback(ConfigFactory.systemEnvironment());
        // in this case, there's only one environment which is local so common config and local config are the same!
        Config profile = ConfigFactory.parseResourcesAnySyntax("local-config-.conf");
        props = new TestConfig(envOverrides.withFallback(profile).withFallback(common).resolve());
        RestClientBase.init(props);
    }

//    @SneakyThrows
//    private void initDriver() {
//        // Set the desired capabilities.
//        DesiredCapabilities dc = new DesiredCapabilities();
//        dc.setCapability(DEVICE_NAME, props.getDeviceName());
//        dc.setCapability(PLATFORM_NAME, props.getPlatformName());
//        dc.setCapability(APP, props.getApkPath());
//
//        driver = new AndroidDriver<AndroidElement>(new URL(props.getAppiumURL()), dc);
//        driver.manage().timeouts().implicitlyWait(Long.parseLong(props.getDefaultTimeoutMilSec()),
//                TimeUnit.MILLISECONDS);
//    }


    /**
     * removes any existing cucumber reports directory remaining from the previous runs
     */
    public static void deleteExistingReportDir() {
        log.info("root dir:" + System.getProperty("user.dir"));
        String reportPath = "/target/cucumber-reports";

        File dir = new File(System.getProperty("user.dir") + reportPath);
        if (dir.isDirectory()) {
            String[] entries = dir.list();
            for (String s : entries) {
                File currentFile = new File(dir.getPath(), s);
                currentFile.delete();
            }
            dir.delete();
        }

    }

}
