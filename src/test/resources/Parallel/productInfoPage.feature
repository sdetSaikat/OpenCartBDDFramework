Feature: Product Info page functionality

  @info
  Scenario Outline: Product image count test
    Given  The user lands on the "<productName>" info page
    When user finds total number of images for the product
    Then user should be able to find <imageCount> images

    Examples:
    | productName | imageCount |
    | iMac        | 3          |
    | MacBook     | 5          |