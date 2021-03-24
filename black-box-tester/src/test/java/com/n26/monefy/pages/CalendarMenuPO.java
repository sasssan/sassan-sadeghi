package com.n26.monefy.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
@AllArgsConstructor
public class CalendarMenuPO {

    @Setter
    private static AndroidDriver<AndroidElement> driver;
    public static final By chooseDateBtn = By.id("show_datepicker_button");
    public static final String editDateBtnAccessID = "Switch to text input mode";
    public static final By confirmDateBtn = By.id("confirm_button");
    public static final By dateTextField = By.xpath("//*/android.widget.EditText");
    public static final By dateGroupList = By.xpath("//*/android.widget.RadioGroup/android.widget.RadioButton");

    public enum DateGroupLabel {
        DAY,
        WEEK,
        MONTH,
        YEAR,
        ALL,
        CHOOSEDATE
    }


    public void tapOnButton(DateGroupLabel button) {
        switch (button) {
            case DAY -> driver.findElements(dateGroupList).get(0).click();
            case WEEK -> driver.findElements(dateGroupList).get(1).click();
            case MONTH -> driver.findElements(dateGroupList).get(2).click();
            case YEAR -> driver.findElements(dateGroupList).get(3).click();
            case ALL -> driver.findElements(dateGroupList).get(4).click();
            case CHOOSEDATE -> {
                AndroidElement chooseElement = driver.findElement(chooseDateBtn);
                chooseElement.click();
                try {
                    chooseElement.click();
                } catch (Exception e) { }
            }
        }
    }

    public void editDateByText(String date) {
        driver.findElementByAccessibilityId(editDateBtnAccessID).click();
        driver.findElement(dateTextField).sendKeys(date);
        driver.findElement(confirmDateBtn).click();
    }


}
