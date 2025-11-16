Feature: Test1

  Scenario Outline: API test
    Given return object with id "<id>"
    Then expect object name to be "<name>"


  Examples:
    | id   | name      |
    | 6    | charizard |
    | 9    | blastoise |
    | 63   | abra      |