Feature: This feature tests GoRest API

  @Users
  Scenario: Create new User and remove all of them after
    Given Create new users from file

  Scenario: List all users
    Given All users is listed

  Scenario: Gets random user details
    Given Get user details

  Scenario: Update User details
    Given Change user "name" to "Jeremy Clarkson"

  Scenario: Delete User
    Given Delete user with updated details

