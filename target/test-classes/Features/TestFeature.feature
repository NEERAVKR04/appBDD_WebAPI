Feature: Test feature file

@sanity
Scenario Outline: Test scenario 1 with product <Name>

Given I open web browser
When I browse to url "GreenKartUrl" from properties and I validate title with "GreenKart - veg and fruits kart"

#When I browse to url "GoogleUrl" from properties and I validate title with "Google"
#And I browse to url "GoogleUrl" from properties and I validate title with "Google"
And I search "<Name>" product on object "homeSearch" of homepage
And I go to top deals offer page and search "<Name>" product
#And I close current browser window

Examples:
|Name|
|Tom|
|Beet|

@regression
Scenario Outline: Test scenario 2 with product <Name>

Given I open web browser
When I browse to url "GreenKartUrl" from properties and I validate title with "GreenKart - veg and fruits kart"
And I search "<Name>" product on object "homeSearch" of homepage
And I go to top deals offer page and search "<Name>" product
#And I close current browser window

Examples:
|Name|
|Pota|
#|Tom|

#@regression
#Scenario: Test scenario 2
#
#Given I open web browser
#When I browse to url "GreenKartUrl" from properties and I validate title with "GreenKart - veg and fruits kart"
#
##When I browse to url "GoogleUrl" from properties and I validate title with "Google"
##And I browse to url "GoogleUrl" from properties and I validate title with "Google"
#And I search "Tom" product on object "homeSearch" of homepage
#And I go to top deals offer page and search "Tom" product
##And I close current browser window
