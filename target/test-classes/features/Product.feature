Feature: Add/Buy a product to cart


	Scenario: User should be able to add a product to the cart
	Given the user is on amazon home page
	When the user search for a product "iPhone 16"
	And the user navigates to the product page
	And the user clicks Add to Cart button 
	Then the product should be added to the cart
	
	
	Scenario: User should not be able to buy a product without logging in 
  Given the user is on amazon home page
  When the user search for a product "iPhone 16"
	And the user navigates to the product page
	And the user clicks Buy now button 
	Then the user should be redirected to login page