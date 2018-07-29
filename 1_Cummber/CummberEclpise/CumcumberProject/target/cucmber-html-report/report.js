$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("shopping.feature");
formatter.feature({
  "line": 3,
  "name": "Adding items to basket",
  "description": "",
  "id": "adding-items-to-basket",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Smoke"
    },
    {
      "line": 1,
      "name": "@Sanity"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "No item selected in basket",
  "description": "",
  "id": "adding-items-to-basket;no-item-selected-in-basket",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I start the application",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I should see a selection of products",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I browse \"without\" buying product",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "my basket \"should\" be empty",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "I \"cannot\" buy an item",
  "keyword": "And "
});
formatter.match({
  "location": "shoppingStep.I_start_the_application()"
});
formatter.result({
  "duration": 919014704,
  "status": "passed"
});
formatter.match({
  "location": "shoppingStep.I_should_see_a_selection_of_products()"
});
formatter.result({
  "duration": 160256,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "without",
      "offset": 10
    }
  ],
  "location": "shoppingStep.I_browse_without_buying_product(String)"
});
formatter.result({
  "duration": 16544298,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "should",
      "offset": 11
    }
  ],
  "location": "shoppingStep.my_basket_should_be_empty(String)"
});
formatter.result({
  "duration": 293377,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "cannot",
      "offset": 3
    }
  ],
  "location": "shoppingStep.I_cannot_buy_an_item(String)"
});
formatter.result({
  "duration": 279040,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "No item selected in basket",
  "description": "",
  "id": "adding-items-to-basket;no-item-selected-in-basket",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "I start the application",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I should see a selection of products",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "I browse \"with\" buying product",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "my basket \"shouldnot\" be empty",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "I \"can\" buy an item",
  "keyword": "And "
});
formatter.match({
  "location": "shoppingStep.I_start_the_application()"
});
formatter.result({
  "duration": 197632,
  "status": "passed"
});
formatter.match({
  "location": "shoppingStep.I_should_see_a_selection_of_products()"
});
formatter.result({
  "duration": 146945,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "with",
      "offset": 10
    }
  ],
  "location": "shoppingStep.I_browse_without_buying_product(String)"
});
formatter.result({
  "duration": 363521,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "shouldnot",
      "offset": 11
    }
  ],
  "location": "shoppingStep.my_basket_should_be_empty(String)"
});
formatter.result({
  "duration": 347649,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "can",
      "offset": 3
    }
  ],
  "location": "shoppingStep.I_cannot_buy_an_item(String)"
});
formatter.result({
  "duration": 243712,
  "status": "passed"
});
});