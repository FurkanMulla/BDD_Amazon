Feature: Amazon home page functionality

@sanity
Scenario: Validation of title
Given User is at landing page
Then Page title should contains "Shopping"

@smoke
Scenario: Verify cart icon
Given User is at landing page
Then Cart icon should get displayed

@regression
Scenario: Verify the deal section
Given User is at landing page
When User click on smartphones deal
Then Deal section should get open

@sanity
Scenario: Login to application
Given User is at landing page
When User hover on sign in 
And click on sign in button
Then sign in page should get open
