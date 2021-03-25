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
    public static final String threeDotsBtnAccessID = "Settings";
    public static final By incomeTxt = By.id("income_amount_text");
    public static final By expenseTxt = By.id("expense_amount_text");
    public static final String calendarMenuBtnAccessID = "Open navigation";
    public static final By dateTxt = By.xpath("//*/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.TextView[1]");
    public static final By categoryList = By.xpath("//*/android.widget.ExpandableListView/android.widget.RelativeLayout");
    public static final By categoryName = By.xpath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]");

    public enum AmountLabel {
        INCOME,
        EXPENSE,
        BALANCE,
        CALENDAR,
        THREEDOTS
    }

    public boolean isOnHomePage() {
        return driver.findElement(balanceBtn).isEnabled();
    }

    public void tapOnButton(AmountLabel button) {
        switch (button) {
            case INCOME -> driver.findElement(incomeBtn).click();
            case EXPENSE -> driver.findElement(expenseBtn).click();
            case BALANCE -> driver.findElement(balanceBtn).click();
            case CALENDAR -> driver.findElementByAccessibilityId(calendarMenuBtnAccessID).click();
            case THREEDOTS -> driver.findElementByAccessibilityId(threeDotsBtnAccessID).click();
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

    public String getDateText() {
        return driver.findElement(dateTxt).getText();
    }

    public boolean categoryExistsInList(String category) {
        return driver.findElements(categoryList).stream().
                anyMatch(element -> element.findElement(categoryName).getText().equalsIgnoreCase(category));
    }

}
