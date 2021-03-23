@Monefy
@CriticalPath
Feature: Change and view balance
  As a Monefy app user
  I want to be able to view and change my balance by adding income and expenses
  So that I can keep track of my money

  Scenario: Balance is updated by income and expenses

    Given The balance is showing 0 on the home page

    When The user taps on the "income" button

    And The user adds 100 dollars on the amounts page

    Then The user is returned to the home page

    And The income is showing 100 on the home page

    And The balance is showing 100 on the home page

#  Please note that I'm trying to get as much coverage as I can in three days otherwise each of
#  these scenarios (add income, add expense, calculate balance, etc.) should be tested independently
    When The user taps on the "expense" button

    And The user adds 51 dollars on the amounts page

    Then The user is returned to the home page

    And The expense is showing 51 on the home page

    And The balance is showing 49 on the home page
