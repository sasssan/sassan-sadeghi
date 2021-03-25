@Monefy
@CriticalPath
Feature: Transfer money between accounts
  As a Monefy app user
  I want to be able to view my accounts and transfer money between them
  So that I can manage the balance for my accounts


  Scenario: money is transferred between user accounts

    Given The user opens the account list from the three dots menu

    And The user selects money transfer

    When The user transfers "100" dollars from Cash to Card

    And The user opens the account list from the three dots menu

    Then The balance displayed for "Cash" Account is "-$100" dollars

    And The balance displayed for "Card" Account is "$100" dollars