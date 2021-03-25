package com.n26.monefy.steps;

import com.n26.monefy.pages.AmountPO;
import com.n26.monefy.pages.HomePO;
import com.n26.monefy.pages.ThreeDotsMenuPO;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.n26.monefy.pages.HomePO.AmountLabel.THREEDOTS;
import static com.n26.monefy.pages.ThreeDotsMenuPO.MenuLabels.ACCOUNTS;
import static com.n26.monefy.pages.ThreeDotsMenuPO.MenuLabels.TRANSFER;

@Slf4j
@AllArgsConstructor
public class AccountsSteps {

    HomePO homePage;
    AmountPO amountPage;
    ThreeDotsMenuPO threeDotsMenu;

    @Given("^The user opens the account list from the three dots menu$")
    public void openAccountsFromMenu() {
        homePage.tapOnButton(THREEDOTS);
        threeDotsMenu.tapOn(ACCOUNTS);
    }

    @And("^The user selects money transfer$")
    public void selectMoneyTransfer() {
        threeDotsMenu.tapOn(TRANSFER);
    }

    @When("^The user transfers \"([^\"]*)\" dollars from Cash to Card$")
    public void transferFromCashToCard(String amount) {
        amountPage.showKeyboard();
        amountPage.addAmountToCategory(Integer.parseInt(amount), "");
    }

}
