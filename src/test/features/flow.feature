Feature: Four Seasons Hotel Booking Flow

  Scenario: Search and add Los Cabos room to cart, verify price
    Given User navigates to the Four Seasons homepage
    And User accepts cookie banner
    And User clicks All Hotels and Resorts
    And User clicks North America button
    And User selects Los Cabos CDS hotel
    And User opens date picker
    And User selects check-in date
    And User selects check-out date
    And User submit rates
    And User adds first room to cart
    And User clicks cart icon
    And User verifies cart price