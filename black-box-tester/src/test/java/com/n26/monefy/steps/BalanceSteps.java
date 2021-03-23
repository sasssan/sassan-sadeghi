package com.n26.monefy.steps;

import com.n26.monefy.pages.AmountPO;
import com.n26.monefy.pages.HomePO;
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


    @And("The user adds {int} dollars on the amounts page")
    public void addAmount(int amount) {
        if (amount == 100) {
            amountPage.addIncomeSalary100("test income note");
        } else if (amount == 51) {
            amountPage.addExpenseEatingOut51("test expense note");
        }
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



}
