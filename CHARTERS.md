# Charters

### test id:1

**Priority**: Critical

**Duration**: 30 minutes


*Explore* 

if the app can be installed and launched successfully on a range of Android mobile devices
 
<br />

*With* 

local or cloud based Android devices can be used. Use 5 recent android devices with the latest stable Android version. Download the app from the Play Store app like and end-user, then install and lunch it.
 
<br />

*To Discover* 

any problems with installation. See if the app can be installed and run for the first time without crashing.

<br />






---
### test id:2

**Priority**: Critical

**Duration**: 15 minutes


*Explore* 

adding income and expenses on the calculator and check if the balance is calculated and reflected correctly. Also try adding invalid amounts on the calculator page such as 0 or negative numbers, try dividing by 0, invalid decimal points, etc. Finally, try putting non-english, emojis and special characters on the notes text field.  

<br />

*With* 

local or cloud based Android devices with the latest stable OS version can be used.

<br />

*To Discover* 

if the app can calculate and reflect the values correctly plus if the calculator safely ignores invalid values and doesn't create an error or app crash. The note text field should also handle a wide range of characters gracefully.

<br />





---
### test id:3

**Priority**: Critical

**Duration**: 5 minutes


*Explore* 

if soft-closing, hard-closing, force stopping and clearing cache resets the app state. Create a few income and expenses to create a non-zero balance, then perform all the operations mentioned above (first individually, then combined); finally re-open the app and check if the data is still showing with no change.

<br />

*With* 

local or cloud based Android devices with the latest stable OS version can be used.

<br />

*To Discover* 

any dependency of the app state/data on cache or memory. Also check if soft closing and re-opening will land the user on the same page.

<br />




---
### test id:4

**Priority**: High

**Duration**: 30 minutes


*Explore* 

interacting with all the views such as buttons, text fields, menus etc. without worrying about business logic. just a quick smoke test to try every view at least once. Use the Monefy Pro features as well. 

<br />

*With* 

local or cloud based Android devices with the latest stable OS version can be used.

<br />

*To Discover* 

if the app crashes under any circumstances. if the app crashes, investigate if it can be re-opened and used with no issues.

<br />



---
### test id:5

**Priority**: High

**Duration**: 10 minutes


*Explore* 

if the app has internet access for paid users. check synchronization with google and dropbox.
<br />

*With* 

local or cloud based Android devices with the latest stable OS version can be used.
<br />

*To Discover* 

if the app has any connectivity issues when paid users try to connect the app to their google and dropbox accounts.

<br />


---
### test id:6

**Priority**: High

**Duration**: 30 minutes


*Explore* 

if the calendar menu on the right behaves correctly. see if the user is able to view expenses for valid date ranges. Plus try putting invalid values for day, month , year and check the error.

<br />

*With* 

local or cloud based Android devices with the latest stable OS version can be used.

<br />

*To Discover* 

if there are any problems with viewing expenses for a given date. Plus invalid dates need to be handled gracefully.

<br />


---
### test id:7

**Priority**: High

**Duration**: 15 minutes


*Explore* 

summoning phone calls, notifications and screen lock in the middle of using the app. 

<br />

*With* 

local or cloud based Android devices with the latest stable OS version can be used.

<br />

*To Discover* 

if interruptions such as phone calls, notifications and locking the screen will intefere with the app's functionality or causes a crash.

<br />


---
### test id:8

**Priority**: High

**Duration**: 15 minutes


*Explore* 

how using online features such as data backup in offline mode impacts the application. disconnect from wifi and try connecting to dropbox or getting a data backup.  

<br />

*With* 

local or cloud based Android devices with the latest stable OS version can be used.

<br />

*To Discover* 

if failure to online services leads to an unexpected error or crash.

<br />


---
### test id:9

**Priority**: High

**Duration**: 1 hour


*Explore* 

if the app correctly groups income and expenses based on multiple categories. generate several income and expenses on default and custom categories, check if the app correctly calculates and reflects all the amounts under each category.

<br />

*With* 

local or cloud based Android devices with the latest stable OS version can be used.

<br />

*To Discover* 

any misrepresentation of income and expenses based on categories

<br />


---
### test id:10

**Priority**: High

**Duration**: 15 minutes


*Explore* 

if all the Monefy Pro features will successfully send the user to the payment link.

<br />

*With* 

local or cloud based Android devices with the latest stable OS version can be used.

<br />

*To Discover* 

if there are any errors with the users subscribing to Monefy Pro features. Plus Pro features should only be available for subscribed users.

<br />



---
### test id:11

**Priority**: High

**Duration**: 15 minutes


*Explore* 

if the user can delete past expenses and income. Plus it should be possible to undo the delete.

<br />

*With* 

local or cloud based Android devices with the latest stable OS version can be used.

<br />

*To Discover* 

If there are issues with delete and undo-delete actions. 

<br />


---
### test id:12

**Priority**: High

**Duration**: 15 minutes


*Explore* 

if the user can search past transactions based on name, category and account. Partial strings should also work. 

<br />

*With* 

local or cloud based Android devices with the latest stable OS version can be used.

<br />

*To Discover* 

If any historical transactions will be missed in the search results. 

<br />


---

## Further Comments
This charter includes critical and high priority test cases for the Monefy application. Critical tests are targeting the most essential features without which the app should never be released. High priority tests are slightly less significant but they still have a huge impact on the business. These are the main areas I have targeted for a quick round of exploratory testing:

- Ability to download, install and run. The most important feature of every application.
- Ability to use the main functionalities such as recording and categorizing income and expenses, calendar functionalities, internet access for paid customers, etc. These features are the main reasons the customers would want to download and use the app.
- Ability to preserve user data. Losing user data can hugely impact app rating among customers.
- Ability to gracefully handle invalid inputs, boundary errors, connectivity issues etc.

Overall, I did not find any significant issues in my quick round of exploratory testing. There was only three minor issues witnessed in the following scenarios:
 1. Searching partial names of categories in the search bar (e.g. Deposit instead of Deposits). Categories will show in the results only when their names are searched in full.
 2. When the date range is set to "ALL" in the calendar menu, the upper date range displayed on the home page is set to the next Monday. I found this strange because normally one would expect to see all the expenses until the current day not in the future.
 3. On the money transfer page, If the user adds a note and then immediately taps on the amount text field, the native keyboard is not automatically hidden.