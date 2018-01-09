$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Calculate_travel_fees.feature");
formatter.feature({
  "line": 1,
  "name": "as a travel agency, I want to calculate travel fees depending on the departure and destination trip",
  "description": "",
  "id": "as-a-travel-agency,-i-want-to-calculate-travel-fees-depending-on-the-departure-and-destination-trip",
  "keyword": "Feature"
});
formatter.before({
  "duration": 114941362,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Determine the fees for a supported destination",
  "description": "",
  "id": "as-a-travel-agency,-i-want-to-calculate-travel-fees-depending-on-the-departure-and-destination-trip;determine-the-fees-for-a-supported-destination",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "the customer want to travel to \"Paris\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the travel fees are 800€",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "the agency fees are 50€",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "the system calculate the travel fees",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "the travel price is 850€",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Paris",
      "offset": 32
    }
  ],
  "location": "TravelFeesSteps.the_customer_want_to_travel_to(String)"
});
formatter.result({
  "duration": 201984765,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "800",
      "offset": 20
    }
  ],
  "location": "TravelFeesSteps.the_travel_fees_are_€(Integer)"
});
formatter.result({
  "duration": 8601212,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "50",
      "offset": 20
    }
  ],
  "location": "TravelFeesSteps.the_agency_fees_are_€(Integer)"
});
formatter.result({
  "duration": 266449,
  "status": "passed"
});
formatter.match({
  "location": "TravelFeesSteps.the_system_calculate_the_travel_fees()"
});
formatter.result({
  "duration": 12917573,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "850",
      "offset": 20
    }
  ],
  "location": "TravelFeesSteps.the_travel_price_is_€(Integer)"
});
formatter.result({
  "duration": 41721636,
  "status": "passed"
});
});