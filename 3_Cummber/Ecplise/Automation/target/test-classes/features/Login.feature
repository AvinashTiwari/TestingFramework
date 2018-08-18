Feature: Applciation Login

Scenario: Home page default login 

Given User is on net banking Landing Page
When User login into application with username and password
Then Home page is populated
And Cards are Displayed