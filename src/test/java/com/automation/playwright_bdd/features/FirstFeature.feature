@Smoke
Feature:FirstTest

@URLCheck
Scenario:FirstScenario

Given User opens the Automation site
When User sees the title of the page as "Automation Practice Site"
Then User should see the logo of the page

@SignupCheck
Scenario:SecondScenario
Given User opens the Automation site
When User clicks on the "Signup/Login" button
And User enters the "config:Name", "config:Email" and clicks on the Signup button
Then User should see the text "ENTER ACCOUNT INFORMATION"

@IncorrectSignupCheck
Scenario:ThirdScenario
Given User opens the Automation site
When User clicks on the "Signup/Login" button
And User enters the "Ssdf", "Testuser@test.com" and clicks on the Signup button
Then User should see the error message "Email Address already exist!"