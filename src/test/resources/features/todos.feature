Feature: TODOs

  Background:
    Given a client has access to the Todos API

  Scenario: TODOs T1 List TODOs
    When the client requests a list of TODOs
    Then the API returns a list of TODOs including expected items

  Scenario Outline: TODOs T1 Get TODO
    When the client requests a TODO with ID <id>
    Then the API returns a TODO with the correct ID and title <title>

    Examples:
      | id | title                                |
      | 1  | "delectus aut autem"                 |
      | 2  | "quis ut nam facilis et officia qui" |