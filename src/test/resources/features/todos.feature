Feature: Steps

  Background:
    Given a client has access to the Todos API

  Scenario: Steps T1
    When the client requests a list of TODOs
    Then the API returns a list of TODOs including expected items