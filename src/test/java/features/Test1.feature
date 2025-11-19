Feature: Test1
API tests

Scenario Outline: GET API test
  Given "pokemon" endpoint with id "<id>"
  Then expect response object name to be "<name>"

  Examples:
    | id | name      |
    | 6  | charizard |
    | 9  | blastoise |


Scenario Outline: Post API test
  Given step one
  Then step two

  Examples:
    | id | name      |
    | 6  | charizard |



