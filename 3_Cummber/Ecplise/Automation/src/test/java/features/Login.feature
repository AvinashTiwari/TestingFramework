Feature: Applciation Login





Scenario Outline: Home page default login 

Given User is on net banking Landing Page
When User login in to application with <Username> and <Password>
Then Home page is populated
And Cards diplayed are "true"

Examples:
|Username| Password| 
|user1|    password1|
|user2|    password2|
|user3|    password3|
|user4|    password4|


Scenario: Home page default login 

Given User is on net banking Landing Page
When User signup with folliwng details
|jenny| abcd | john@acbd.com | Aussie | 13131 |

Then Home page is populated
And Cards diplayed are "false"





Scenario: Home page default login 

Given User is on net banking Landing Page
When User login into application with "jin" and "1234"
Then Home page is populated
And Cards are Displayed



Scenario: Home page default login 

Given User is on net banking Landing Page
When User login into application with "jhon" and "4321"
Then Home page is populated
And Cards are not Displayed


Scenario: Home page default login 

Given User is on net banking Landing Page
When User login into application with username and password
Then Home page is populated
And Cards are Displayed