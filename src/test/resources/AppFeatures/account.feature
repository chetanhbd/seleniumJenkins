Feature: account page feature
  @account
  Scenario: Login into application
    Given user has already logged into the application
    |username|password|
    |csascsit2014@gmail.com|12345|

    @account
    Scenario: verify account page title
      Given user has already logged into the application
        |username|password|
        |csascsit2014@gmail.com|12345|
      When user is on accounts page
      And user gets the title of the page
      Then page title should be "My account - My Store"


      @account
      Scenario: verify account section
        Given user has already logged into the application
          |username|password|
          |csascsit2014@gmail.com|12345|
        When user is on accounts page
        Then my account information should be displayed
        |ORDER HISTORY AND DETAILS|
        |MY WISHLISTS|
        |MY CREDIT SLIPS|
        |MY ADDRESSES|
        |MY PERSONAL INFORMATION|
        |Home|
        And account count should be 6
