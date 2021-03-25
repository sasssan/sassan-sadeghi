package com.n26.monefy.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
@AllArgsConstructor
public class ThreeDotsMenuPO {

    @Setter
    private static AndroidDriver<AndroidElement> driver;
    public static final By accountsList = By.xpath("//*/android.widget.LinearLayout[2]/" +
            "android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout");
    public static final By transferBtn = By.xpath("//android.widget.ListView[@content-desc=\"List of accounts\"]/android.widget.LinearLayout[2]");
    public static final By cashAccountAmount = By.xpath("//*/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]");
    public static final By cardAccountAmount = By.xpath("//*/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.TextView[2]");

    public enum MenuLabels {
        ACCOUNTS,
        TRANSFER
    }

    public void tapOn(MenuLabels label) {
        switch (label) {
            case ACCOUNTS -> driver.findElement(accountsList).click();
            case TRANSFER -> driver.findElement(transferBtn).click();
        }
    }

    public String getAmountByAccountName(String accountName) {
        switch (accountName.toLowerCase()) {
            case "cash" -> {
                return driver.findElement(cashAccountAmount).getText();
            }
            case "card" -> {
                return driver.findElement(cardAccountAmount).getText();
            }
            default -> {
                return "0";
            }
        }
    }


    public static final By chooseDateBtn = By.id("show_datepicker_button");
}
