@PetStore
Feature: New pets are added to the store
  As a pet store store owner
  I want to be able to add new pets to my pet store
  So that I can sell new pets to customers

  Scenario Outline: New Pet is added with the correct status

    Given Pet with the name "<Pet Name>" and status "<Pet Status>" does not exist in the store

    When Pet with the name "<Pet Name>" and status "<Pet Status>" is posted into the pet store API

    Then The response has the status code 200

    And Pet with the name "<Pet Name>" and status "<Pet Status>" is returned in the findByStatus response

    Examples:
      | Pet Name  | Pet Status |
      | Donkey    | available  |
      | Turtle    | pending    |
      | Crocodile | sold       |
