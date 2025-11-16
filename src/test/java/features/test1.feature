Feature: Test1

  Scenario Outline: Verify greeting message
    Given user name is "<text>"
    When system generates greeting <number>
    Then message should be

  Examples:
    | text | number |
    | aa   | 1      |
    | b    | 2      |