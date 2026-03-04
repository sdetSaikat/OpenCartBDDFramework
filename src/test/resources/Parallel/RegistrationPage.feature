Feature: Registration page feature test

@register
  Scenario Outline: Registration Functionality test
    Given The user is on the registration page
    When the user registers with "<firstName>","<LastName>","<phoneNumber>","<password>","<subscribe>"
    Then user should be able to register themselves.

    Examples:
    | firstName | LastName | phoneNumber | password  | subscribe |
    | Saikat    | Maity    |9932867239   | Saikat@123| yes       |
    | Subh      | Raha     |9932867238   | Subh@123  | no        |
    | Bibhas    | Mandol   |9932867237   | Bitu@123  | yes       |

