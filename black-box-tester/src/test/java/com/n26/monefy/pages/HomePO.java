package com.n26.monefy.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

@AllArgsConstructor
public class HomePO {

    @Setter
    @Getter
    private static AndroidDriver<AndroidElement> driver;
    public static final By incomeBtn = By.id("income_button");
    public static final By expenseBtn = By.id("expense_button");
    public static final By balanceBtn = By.id("balance_amount");
    public static final By incomeTxt = By.id("income_amount_text");
    public static final By expenseTxt = By.id("expense_amount_text");

    public enum AmountLabel {
        INCOME,
        EXPENSE,
        BALANCE
    }

    public boolean isOnHomePage(){
        return driver.findElement(balanceBtn).isEnabled();
    }

    public void tapOnButton(AmountLabel button) {
        switch (button) {
            case INCOME -> driver.findElement(incomeBtn).click();
            case EXPENSE -> driver.findElement(expenseBtn).click();
            case BALANCE -> driver.findElement(balanceBtn).click();
        }
    }

    public float getAmount(AmountLabel amount) {
        switch (amount) {
            case INCOME -> {
                return Float.parseFloat(driver.findElement(incomeTxt).getText().replace("$", ""));
            }
            case EXPENSE -> {
                return Float.parseFloat(driver.findElement(expenseTxt).getText().replace("$", ""));
            }
            case BALANCE -> {
                return Float.parseFloat(driver.findElement(balanceBtn).getText().replace("Balance $", ""));
            }
            default -> {
                return 0;
            }
        }
    }

}
