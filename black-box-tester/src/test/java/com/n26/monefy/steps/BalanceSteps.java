package com.n26.monefy.steps;

import com.n26.monefy.pages.AmountPO;
import com.n26.monefy.pages.HomePO;
import com.n26.monefy.pages.ThreeDotsMenuPO;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;

import static com.n26.monefy.pages.HomePO.AmountLabel.*;

@Slf4j
@AllArgsConstructor
public class BalanceSteps {

    HomePO homePage;
    AmountPO amountPage;
    ThreeDotsMenuPO threeDotsMenu;

    @And("The balance is showing {int} on the home page")
    public void assertBalance(int balance) {
        float actualBalance = homePage.getAmount(BALANCE);
        Assert.assertTrue(actualBalance == balance,
                "expected balance to be $" + balance + " but found $" + actualBalance);
    }

    @When("^The user taps on the \"([^\"]*)\" button$")
    public void selectIncome(String btnName) {
        homePage.tapOnButton(HomePO.AmountLabel.valueOf(btnName.toUpperCase()));
    }


    @Then("^The user is returned to the home page$")
    public void assertHomePage() {
        Assert.assertTrue(homePage.isOnHomePage());
    }


    @And("The user adds {int} dollars on the amounts page for Salary")
    public void addIncome(int amount) {
        amountPage.addIncomeSalary100("test income note");
    }

    @And("The user adds {int} dollars on the amounts page for Eating Out")
    public void addExpense(int amount) {
        amountPage.addExpenseEatingOut51("test expense note");
    }

    @Then("The {string} category is displayed in the list")
    public void assertCategoryInList(String category) {
        Assert.assertTrue(homePage.categoryExistsInList(category));
    }

    @And("The income is showing {int} on the home page")
    public void assertIncome(int income) {
        float actualIncome = homePage.getAmount(INCOME);
        Assert.assertTrue(actualIncome == income,
                "expected income to be $" + income + " but found $" + actualIncome);
    }

    @And("The expense is showing {int} on the home page")
    public void assertExpense(int expense) {
        float actualExpense = homePage.getAmount(EXPENSE);
        Assert.assertTrue(actualExpense == expense,
                "expected expense to be $" + expense + " but found $" + actualExpense);
    }

    @And("^The balance displayed for \"([^\"]*)\" Account is \"([^\"]*)\" dollars$")
    public void assertAccountBalance(String account, String amount) {
        Assert.assertEquals(amount, threeDotsMenu.getAmountByAccountName(account).split("\\.")[0]);
    }


}
