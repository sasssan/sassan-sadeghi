# Charters

###test id:1
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
###test id:2
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
###test id:3
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
###test id:4
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
###test id:5
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
###test id:6
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
###test id:7
**Priority**: High

**Duration**: 15 minutes


*Explore* 

summoning phone calls, notifications, etc in the middle of using the app 

<br />

*With* 

<br />

*To Discover* 

<br />


---
###test id:8
**Priority**: 

**Duration**: 


*Explore* 

<br />

*With* 

<br />

*To Discover* 

<br />