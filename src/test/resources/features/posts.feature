Feature: Posts

  Background:
    Given a client has access to the Posts API

  Scenario: Posts T1 List Posts
    When the client requests a list of Posts
    Then the API returns a list of Posts including expected items