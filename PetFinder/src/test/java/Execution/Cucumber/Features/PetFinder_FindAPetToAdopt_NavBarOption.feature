Feature: Find a pet to adopt navbar feature on the home page

  Scenario: validate that the user cannot find a pet without entering a location

    Given i navigate to the Url home page
    And i click find pets button  | WebElmenet Click ""
    Then i should not be navigated to a result page
    And i should stay on the home page
    And a pop up field should appear that says "Please fill out this field." under the location text field box



