Feature: Account Page Features

  @Accounts
  Scenario: Account page Header test
    Given when user is on the account page
    When user finds the list header of the account page
    Then user should be able find the below headers on the acc page

    | My Account |
    | My Orders  |
    | My Affiliate Account |
    | Newsletter |

  @Accounts
  Scenario Outline: product count test
    Given when user is on the account page
    When user search for the "<productName>"
    Then user should be able to find <resultCount> products

    Examples:
    | productName | resultCount|
    | imac        | 1          |
    | MacBook     | 3          |
    | Samsung     | 2          |
    | Airtel      | 0          |

    @Accounts
    Scenario: Logout link presence check
      Given when user is on the account page
      When user looks for logout link
      Then user should be able to find the logout link