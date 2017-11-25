Feature: this feature is for making sure a user can login with a valid username and password

  Scenario: validate that a user can login with valid username and password

    Given i navigate to the Url
    And I click sign in button
    And I enter the the following data for logging in
      | username               | password  |
      | samisabir212@gmail.com | Apples212 |
    And I click Login button
    Then I can click the 'My pet Finder button'
    And I should be Redirected to the Profile page



#  Scenario Outline:  validate that a user can login with valid username and password using Scenario outline
#
#
#    Given i navigate to the Url
#    And I click sign in button
#    And I enter the <username> and <password>
#    And I click Login button
#    Then I can click the 'My pet Finder button'
#    And I should be Redirected to the Profile page
#
#
#    Examples:
#      | username               | password  |
#      | samisabir212@gmail.com | Apples212 |

