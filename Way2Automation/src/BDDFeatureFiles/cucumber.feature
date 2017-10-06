Feature: accepatance testing to see if a customer can make a withdrawl and view that withdrawl


Scenario: validate that user can make a withdrawl and view that withdrawl in his account.

    Given i am on the home page "http://www.way2automation.com/angularjs-protractor/banking/#/login" of XYZ bank website
    when i click customer login button, i should be directed to the customer login page.
    And select my name from the drop down list
    Then i will click login button
    Then i should be directed to Account page
    And i will click the withdrawl button
    When i click the withdrawl button, the "Amount to be withdrawn" text input field should appear
    Then i will enter the amount i want to withdrawl
    And i will click the withdrawl button
    Then the Transaction should fail because there is no money in the account balance.


