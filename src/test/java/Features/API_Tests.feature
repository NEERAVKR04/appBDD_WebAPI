Feature: Add Location API tests

@apiTests
Scenario Outline: Add new location api scenario

Given I set Add Place api payload with "<name>" and "<phone_no>" and "<address>" and "<language>"
When I hit "AddPlaceAPI" api with "post" request
Then I validate response status with status code "200"
And I validate response param "status" with value "OK"
And I store value of response param "place_id" in "placeId" variable
And I store value of response param "scope" in "scope" variable
And I validate response param variable "scope" value with "APP"
And I set query "fetch_user_data_id_and_name"
And I connect to db "dbURL_postgres" using db query "fetch_user_data_id_and_name" and store output in variables "id, name"


Examples:
|name ||phone_no||address||language|
|Neerav||+91 70117782004||Gurgaon, Haryana-122015||English - IN|

@getPlaceId
Scenario: GET place id created

Given I set Get Place api payload with place_id
When I hit "getPlaceAPI" api with "get" request
Then I validate response status with status code "200"
And I store value of response param "address" in "addressCust" variable
And I validate response param variable "addressCust" value with "Gurgaon, Haryana-122015"
#And I validate response param "status" with value "OK"



@deletePlaceId
Scenario: Delete place id created

Given I set Delete Place api payload with place_id
When I hit "deletePlaceAPI" api with "delete" request
Then I validate response status with status code "200"
#And I validate response param "status" with value "OK"


