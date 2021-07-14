$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/add.feature");
formatter.feature({
  "name": "Add new product",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "user is able to update a name and price of the product",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user update the name and price of the product",
  "keyword": "When "
});
formatter.match({
  "location": "com.fruitshop.step_definitions.updateProduct_stepdefinitions.user_update_the_name_and_price_of_the_product()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is able to verify the updated name and a price",
  "keyword": "Then "
});
formatter.match({
  "location": "com.fruitshop.step_definitions.updateProduct_stepdefinitions.user_is_able_to_verify_the_updated_name_and_a_price()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "list the product",
  "keyword": "Then "
});
formatter.match({
  "location": "com.fruitshop.step_definitions.updateProduct_stepdefinitions.list_the_product()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});