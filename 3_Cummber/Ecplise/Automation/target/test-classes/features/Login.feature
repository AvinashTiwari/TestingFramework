Feature: Applciation Login



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