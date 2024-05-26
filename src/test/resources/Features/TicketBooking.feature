Feature: TicketBooking
  @Regression

  Scenario: Booking a ticket in bus

    Given Customer login to the application
    When Customer FROM and TO and DATE
    And Customer clicks on search
    Then Customer checking for the seats
