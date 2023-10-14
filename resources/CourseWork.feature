Feature: Desktop Checkout for Guest User
  As a customer
  I want to be able proceed to checkout
  So that I can specify my delivery and payment details and place order

  Scenario: Proceed to checkout, final review and place order as guest user
    Given I am an anonymous customer with clear cookies
    And I open the Home page
    And I search for Thinking in Java
    And I am redirected to a Search results page
    And Search results contain 35 items
    And I sort Search results from newest
    And top search result is Thinking in Pictures: Adventures in Trying to be Smart
    And I apply the following search filters
      | Format       | Paperback  |
      | Availability | In Stock   |
      | Language     | English    |
      | Price range  | 1160 UAH + |
    And Search results contain the following products
      | Exact Thinking in Demented Times                                                                                |
      | 3D Thinking in Design and Architecture                                                                          |
      | Re-thinking Childrens Work in Churches                                                                          |
      | Human Frontiers. The Future of Big Ideas in an Age of Small Thinking                                            |
      | Assessing and Developing Communication and Thinking Skills in People with Autism and Communication Difficulties |
      | 59 Paintings. In which the artist considers the process of thinking about and making work                       |
    And I click Add to basket button for product wit name 3D Thinking in Design and Architecture
    And I select Basket Checkout in basket pop-up
    And I am redirected to a Basket page
    And I fill in personal and delivery information manually
      | First Name | Last Name | Cell Number | Email              | Town/City | Warehouse | Patronimic | Street Name | Building Number |
      | Michael    | Keaton    | 0962352783  | test4life@yaka.boo | Київ      | 99        | Gustavson  | Saliutna    | 2               |
    When I press Pay button
    And I am redirected to Checkout
    And I fill in valid payment information
      | cardNumber   | 5409530000000077 |
      | Expiry Year  | 2023             |
      | Expiry Month | 02               |
      | CVV          | 124              |
    And I click Submit button
    And I am redirected to payment provider page
    Then I receive error notification

