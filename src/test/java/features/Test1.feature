Feature: Test1
API tests

Scenario Outline: GET API test
  When User sends  a GET request at "pokemon" endpoint with id "<id>"
  Then Expect response object name to be "<name>"

  Examples:
    | id | name      |
    | 6  | charizard |
    | 9  | blastoise |


Scenario Outline: Post API test
  Given Request body set to "<name>" "<baseStat>" "<statName>" "<url>"
  When User sends a POST with request body
  Then Expect response object to match "<name>" "<baseStat>" "<statName>" "<url>"

  Examples:
    | name  | baseStat | statName | url    |
    | poke1 | 60       | HP       | urlTxt |
    | poke2 | 45       | Attack   | urlTxt |

Scenario: Query test
  When User sends a query for 20 items on "pokemon" resource




