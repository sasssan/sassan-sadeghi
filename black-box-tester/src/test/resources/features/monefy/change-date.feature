@Monefy
@CriticalPath
Feature: Change date
  As a Monefy app user
  I want to be able to view and change the date range in which my transactions are shown
  So that I can manage my overall income and spendings over time


  Background: A reference date is picked

    Given Today's date is set to "1/1/21" on the app

    And The date displayed on the home page is set to "Friday, 1 January"


  Scenario Outline: Different date ranges are picked

    When The user sets the date range to "<Range>"

    Then The date displayed on the home page is set to "<DisplayedDate>"

    Examples:
      | Range | DisplayedDate  |
      | Week  | 27 Dec - 2 Jan |
      | Month | January        |
      | Year  | 2021           |
      | All   | 1 Jan - *      |
#    Wasn't sure about the correct range of "ALL" so used a wild card!


  Scenario: Only transactions within the current date range are displayed

    When The user taps on the "income" button

    And The user adds 100 dollars on the amounts page

    And The balance is showing 100 on the home page

    When Today's date is set to "1/2/21" on the app

    Then The balance is showing 0 on the home page

    When Today's date is set to "12/2/20" on the app

    And The user sets the date range to "Month"

    Then The balance is showing 0 on the home page





