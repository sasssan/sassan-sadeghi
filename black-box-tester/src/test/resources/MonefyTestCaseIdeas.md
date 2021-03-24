## Monefy Test Case Ideas

### test id:1

**Idea**: Add some income and expense and check if they are reflected correctly on the home page.

**Priority**: Critical. Showstopper if not working.

**Automation Candidate**: Yes. UI test automation.

---

### test id:2

**Idea**: Add some income and expense and check if the balance is calculated and displayed correctly.

**Priority**: Critical. Showstopper if not working.

**Automation Candidate**: Yes. The logic for calculating balance can be covered in unit tests. Displaying balance on the UI needs to be tested at the UI level. 

---

### test id:3

**Idea**: Test if the income and expenses are added to the right category. Test if past transactions are grouped and displayed based on categories.

**Priority**: Critical. Showstopper if not working.

**Automation Candidate**: Yes. Most of the logic that assigns each transaction to a particular category can be covered in unit tests. UI test automation is required to test if category groups are displayed on the screen. 

---

### test id:4

**Idea**: Test if soft-closing and hard-closing the app doesn't lead to losing user data.

**Priority**: Critical. Showstopper if not working.

**Automation Candidate**: Yes. Some UI automation tools can simulate soft-closing and hard-closing. 

---

### test id:5

**Idea**: Test if only the transactions for the selected date range are displayed.

**Priority**: Critical. Showstopper if not working.

**Automation Candidate**: Yes. The logic to assign a date to each transaction can be unit tested. One UI test is enough to check if changing the date range will update the displayed balance, transactions, etc. 

---

### test id:6

**Idea**: Test if transactions are grouped based on date and displayed on the home page.

**Priority**: Critical. Showstopper if not working.

**Automation Candidate**: Yes. Business logic already unit tested for test 5. One UI test needed to check if date groups are displayed. 

---

### test id:7

**Idea**: Test if the the home page pie chart correctly displays category percentage for a given date range.

**Priority**: High. Can significantly impact customer rating.

**Automation Candidate**: Yes. Unit test for calculating percentages. UI test for displaying.

---

### test id:8

**Idea**: Test if search bar can lookup transactions based on notes, category and accounts.

**Priority**: High. Can significantly impact customer rating.

**Automation Candidate**: Yes. Unit tests for search logic. UI tests to perform one successful search on the UI.

---

### test id:9

**Idea**: Test if past transactions can be deleted. Also delete can be undone.

**Priority**: High. Can significantly impact customer rating.

**Automation Candidate**: Yes. unit test to ensure a delete will remove the record from the app's datasource and an undo in the allowed time will add the record back. UI test to delete and un-delete at least one transaction.  

---

### test id:10

**Idea**: Test if Monefy Pro features will lead the user to the payment link. Also if non-paid customers don't have access to Pro features.

**Priority**: High. Can significantly impact customer rating and business revenue.

**Automation Candidate**: Yes. Unit tests to check all Pro features are configured with the correct link. One UI test to tap on a Pro feature and verify the correct action is triggered.

---

### test id:11

**Idea**: Test if the category shortcut keys will take the user to amount page, with the category field prepopulated.

**Priority**: Medium. Problems with this feature need to be fixed before release.

**Automation Candidate**: Yes. Safer to cover all scenarios in UI tests.

---

### test id:12

**Idea**: Test if the user can create new accounts.

**Priority**: Medium. Problems with this feature need to be fixed before release.

**Automation Candidate**: Yes. One UI test to create one new category.

---

### test id:13

**Idea**: Test if currency can be changed.

**Priority**: High. Can significantly impact customer rating.

**Automation Candidate**: Yes. UI test to change the currency. Unit test to verify the list of available currencies.

---

### test id:14

**Idea**: Test if new categories can be created.

**Priority**: Low. There are already a wide range of default categories.

**Automation Candidate**: Yes. UI test to create one category.

---

### test id:15

**Idea**: Test if all transactions are correctly grouped and displayed based on accounts.

**Priority**: Critical. Showstopper if not working.

**Automation Candidate**: Yes. Unit tests to verify all transactions are linked with the correct account. UI test to see if the right values are displayed.

---

### test id:16

**Idea**: Test if paid customers can sync with their google and dropbox accounts.

**Priority**: High. Can significantly impact customer rating.

**Automation Candidate**: Yes for the configuration part. UI test only to check if the correct actions are triggered to take the user to google's or dropbox's authentication page. Third party pages should not be part of Monefy's automation suite but a manual test can be done with real google and dropbox accounts to verify the full E2E integration. 

---

### test id:17

**Idea**: Test if paid users can backup, restore and clear their data in the cloud. 

**Priority**: High. Can significantly impact customer rating.

**Automation Candidate**: Yes. UI test to tap on sync, restore and clear data view elements. Also need a stub server that simulates the actual cloud server. This way we can run the test locally and verify if the correct web requests are sent to the cloud servers.

---

### test id:18

**Idea**: Test if the user can export data correctly to csv file.

**Priority**: Medium. Problems with this feature need to be fixed before release.

**Automation Candidate**: Yes. unit tests to test the logic for correctly populating the csv file. One UI test to check if the file can be generated.

---

### test id:19

**Idea**: Test if the user can change the language.

**Priority**: High. Can significantly impact customer rating.

**Automation Candidate**: Yes. Unit test to ensure localization libraries are correctly configured and used in the app. Also unit test to verify the list of available languages. UI test to change one language and verify if it's correctly displayed.

---

### test id:20

**Idea**: Test if the user can configure first day of the week and month.

**Priority**: Low. Not part of the main features.

**Automation Candidate**: Yes. Unit test for week and month logic and configuration. UI test to check if those configurations are displayed correctly.  

---

### test id:21

**Idea**: Test if the dark mode won't cause any UI issues.

**Priority**: Medium. Problems with this feature need to be fixed before release.

**Automation Candidate**: Partially Yes. There are automation tools that provide image procesing capabilities. But at the end of the day this features need to also be tested manually. 

---

### test id:22

**Idea**: Test if the user can make recurring expenses and income.

**Priority**: High. Can significantly impact customer rating.

**Automation Candidate**: Yes. Unit test for business logic. UI test to check if one recurring payment is displayed in the target date.

---

### test id:23

**Idea**: Test if category and account names can be edited.

**Priority**: Low. Not a main feature.

**Automation Candidate**: Yes. Unit test for business logic which includes verifying all the transactions assigned to an account or category are still preserved after editing. UI test to edit one category and one account name. Verify the edited name is displayed correctly.

---

### test id:24

**Idea**: Test if budget mode can be used with a set limit.

**Priority**: High. Can significantly impact customer rating.

**Automation Candidate**: Yes. Unit test to verify logic behind assigning budget limits to each month. UI test to verify that limit is displayed correctly. 

---

### test id:25

**Idea**: Test if tapping on categories will highlight the pie chart.

**Priority**: Low. Not a main feature.

**Automation Candidate**: Yes. UI test to check the presence and text value of the highlighted element for each category. Might be a little challenging to automate because the user is immediately taken to the amount page. 


---

### test id:26

**Idea**: Test if notes can be added to transactions and later displayed on the home page.

**Priority**: Medium. Problems with this feature need to be fixed before release.

**Automation Candidate**: Yes. Unit tests to verify the logic of assigning notes to transactions. UI tests to display them on the screen.


---

### test id:27

**Idea**: Test if the calculator on the amount page works correctly.

**Priority**: Medium. Problems with this feature need to be fixed before release.

**Automation Candidate**: Yes. Unit tests to verify all the calculator operations. UI test to verify the right buttons are linked with the right numbers and math operations.



