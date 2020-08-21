Feature: Login Action

Scenario: Successfull Login with Valide Credentails
Given User in Login Page 
When User view Login Page Successfull
And User enters "tomsmith" and "SuperSecretPassword!" 
Then Message displayed ogin Page 

