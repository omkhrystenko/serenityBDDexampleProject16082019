Login

Meta
@tag product:login

Narrative
    In order to use app functionality
    As a user
    I want to be able to login

Scenario: Successful user login
Given I open Landing page
Given I go to Login page
When I submit authentication data (testchitest@gmail.com, Qwerty12)
Then Home page is loaded
