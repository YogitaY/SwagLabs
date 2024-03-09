Feature: Test the login functionality of Swag Labs

  Scenario Outline: Test the valid login
    Given user is on login page
    When user enters <username> and <password>
    And click on login button
    Then user should land on Home page

    Examples: 
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_      |
