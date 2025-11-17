Feature: Test1
API tests

Scenario Outline: API test 1
  Given return "pokemon" with id "<id>"
  Then expect object name to be "<name>"

  Examples:
    | id | name      |
    | 6  | charizard |
    | 9  | blastoise |


  Scenario: API test2
    Given step one
    Then step two




