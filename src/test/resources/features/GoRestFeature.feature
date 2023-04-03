Feature: This feature tests GoRest API

  @Users
  Scenario: Create new Users
    Given Create new users from file

  Scenario: Get all users
    Given All users is listed

  Scenario: Gets random user details, update it and remove it
    Given Get user details
    Then Change user "name" to "Jeremy Clarkson"
    And Delete user with updated details

