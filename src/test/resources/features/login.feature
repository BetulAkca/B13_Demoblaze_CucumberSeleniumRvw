@login
Feature: Login Test
  # Agile story : As a user, I should be able to login with valid credentials
  Background:
    Given The user navigates to website


  Scenario: Positive Login Test 1 without parameter
    When The user clicks login button and enters valid credentials
    Then The user verifies welcome message


  Scenario: Positive Login Test 2 with parameter
    When The user clicks on login button and enters "JhonyQ" and "Test1234" credentials
    Then The user verifies welcome message contains "JhonyQ"


  Scenario Outline: Positive Login Test 3 with scenarioOutline
    When The user clicks on login button and enters "<username>" and "<password>" credentials
    Then The user verifies welcome message contains "<username>"
    Examples:
      | username | password |
      | JhonyQ   | Test1234 |


  Scenario Outline: Positive Login Test 4 with scenarioOutline and data table
    When The user clicks on login button and enters following credentials
      | username | <user_username> |
      | password | <user_password> |
    Then The user verifies welcome message contains "<user_username>"
    Examples:
      | user_username | user_password |
      | JhonyQ        | Test1234      |

  Scenario Outline: Negative Login test 5
    When The user clicks on login button and enters "<invalid_username>" and "<invalid_password>" credentials
    Then The user verifies invalid access message is "<message>"
    Examples:
      | invalid_username | invalid_password | message                                |
      | JhonyQ           |                  | Please fill out Username and Password. |
      | JhonyQ           | Test1234!!!      | Wrong password.                        |
      | JhonyQQQ         | Test1234         | User does not exist.                   |
      |                  | Test1234         | Please fill out Username and Password. |
      |                  |                  | Please fill out Username and Password. |
      | JhonyQQQ         | Test1234!!       | User does not exist.                   |