Login

Meta:
@tag login
@tag regression

Narrative
    In order to use app functionality
    As a user
    I want to be able to login

Scenario: Successful user login
Meta:
@tag login01
Given I open Landing page

When I click on 'Sign in' button
Then I should be on Login page


When I sign In as 'testchitest@gmail.com' , 'Qwerty12'
Then Home page is loaded

