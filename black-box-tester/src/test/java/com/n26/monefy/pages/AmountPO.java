package com.n26.monefy.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.By;

@AllArgsConstructor
public class AmountPO {

    @Setter
    public static AndroidDriver<AndroidElement> driver;
    public static final By key1 = By.id("buttonKeyboard1");
    public static final By key0 = By.id("buttonKeyboard0");
    public static final By key5 = By.id("buttonKeyboard5");
    public static final By amountNote = By.id("textViewNote");
    public static final By categoryBtn = By.id("keyboard_action_button");
    public static final By salaryBtn = By.xpath("//*/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ImageView");
    public static final By eatingOutBtn = By.xpath("//*/android.widget.FrameLayout[5]/android.widget.LinearLayout");


    private void addAmount(int amount) {
        // of course this is not very reusable but we don't have much time!
        if (amount == 100) {
            driver.findElement(key1).click();
            driver.findElement(key0).click();
            driver.findElement(key0).click();
        } else if (amount == 51) {
            driver.findElement(key5).click();
            driver.findElement(key1).click();
        }
    }

    public void addIncomeSalary100(String note){
        addAmount(100);
        driver.findElement(amountNote).sendKeys(note);
        driver.findElement(categoryBtn).click();
        driver.findElement(salaryBtn).click();
    }


    public void addExpenseEatingOut51(String note){
        addAmount(51);
        driver.findElement(amountNote).sendKeys(note);
        driver.findElement(categoryBtn).click();
        driver.findElement(eatingOutBtn).click();
    }

}
