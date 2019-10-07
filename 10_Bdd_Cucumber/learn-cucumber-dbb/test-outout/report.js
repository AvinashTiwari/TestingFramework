$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/java/Features/Hooks.feature");
formatter.feature({
  "line": 1,
  "name": "Add New Deal",
  "description": "",
  "id": "add-new-deal",
  "keyword": "Feature"
});
formatter.before({
  "duration": 9248832700,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Login Free CRM with Valid Creadentials",
  "description": "",
  "id": "add-new-deal;login-free-crm-with-valid-creadentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "User is on Application Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Application Page Tittle is FREE CRM",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user enters username and password",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 7
    },
    {
      "cells": [
        "anshulc55",
        "Anshul@123"
      ],
      "line": 8
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user clicks on Login Butoon",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "User navigate to user Profile page",
  "keyword": "When "
});
formatter.match({
  "location": "MultiDealsSteps.user_is_on_Application_Home_Page()"
});
formatter.result({
  "duration": 2793505901,
  "status": "passed"
});
formatter.match({
  "location": "MultiDealsSteps.application_Page_Tittle_is_FREE_CRM()"
});
formatter.result({
  "duration": 152065600,
  "error_message": "junit.framework.ComparisonFailure: expected:\u003cFree CRM [in the cloud software boosts sales]\u003e but was:\u003cFree CRM [#1 cloud software for any business large or small]\u003e\r\n\tat junit.framework.Assert.assertEquals(Assert.java:100)\r\n\tat junit.framework.Assert.assertEquals(Assert.java:107)\r\n\tat StepDefinitions.MultiDealsSteps.application_Page_Tittle_is_FREE_CRM(MultiDealsSteps.java:64)\r\n\tat ✽.When Application Page Tittle is FREE CRM(src/main/java/Features/Hooks.feature:5)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "MultiDealsSteps.user_enters_username_and_password(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MultiDealsSteps.user_clicks_on_Login_Butoon()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MultiDealsSteps.user_navigate_to_user_Profile_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 859170800,
  "status": "passed"
});
formatter.before({
  "duration": 5611325600,
  "status": "passed"
});
formatter.before({
  "duration": 228299,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Login Free CRM with InValid Creadentials",
  "description": "",
  "id": "add-new-deal;login-free-crm-with-invalid-creadentials",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "User is on Application Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "Application Page Tittle is FREE CRM",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "user enters username and password",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 18
    },
    {
      "cells": [
        "anshulc55",
        "nshul@123"
      ],
      "line": 19
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "user clicks on Login Butoon",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "Application Page Tittle is FREE CRM",
  "keyword": "When "
});
formatter.match({
  "location": "MultiDealsSteps.user_is_on_Application_Home_Page()"
});
formatter.result({
  "duration": 1413789000,
  "status": "passed"
});
formatter.match({
  "location": "MultiDealsSteps.application_Page_Tittle_is_FREE_CRM()"
});
formatter.result({
  "duration": 16176000,
  "error_message": "junit.framework.ComparisonFailure: expected:\u003cFree CRM [in the cloud software boosts sales]\u003e but was:\u003cFree CRM [#1 cloud software for any business large or small]\u003e\r\n\tat junit.framework.Assert.assertEquals(Assert.java:100)\r\n\tat junit.framework.Assert.assertEquals(Assert.java:107)\r\n\tat StepDefinitions.MultiDealsSteps.application_Page_Tittle_is_FREE_CRM(MultiDealsSteps.java:64)\r\n\tat ✽.When Application Page Tittle is FREE CRM(src/main/java/Features/Hooks.feature:16)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "MultiDealsSteps.user_enters_username_and_password(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MultiDealsSteps.user_clicks_on_Login_Butoon()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MultiDealsSteps.application_Page_Tittle_is_FREE_CRM()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 998664500,
  "status": "passed"
});
formatter.after({
  "duration": 101900,
  "status": "passed"
});
formatter.before({
  "duration": 5369205500,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "Add New Multi Deal",
  "description": "",
  "id": "add-new-deal;add-new-multi-deal",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 26,
  "name": "User is on Application Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "Application Page Tittle is FREE CRM",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "user enters username and password",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 29
    },
    {
      "cells": [
        "anshulc55",
        "Anshul@123"
      ],
      "line": 30
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "user clicks on Login Butoon",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "User navigate to user Profile page",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "Go to Deals",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "Open New Deal Form",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "user enters deal data",
  "rows": [
    {
      "cells": [
        "Title",
        "Amount",
        "Probability",
        "Commission",
        "Description",
        "Next Step"
      ],
      "line": 37
    },
    {
      "cells": [
        "New Deal",
        "1000",
        "20",
        "3",
        "This is new Deal",
        "To Be Discussed"
      ],
      "line": 38
    },
    {
      "cells": [
        "CX Deal",
        "1000",
        "20",
        "3",
        "This is new Deal",
        "To Be Discussed"
      ],
      "line": 39
    },
    {
      "cells": [
        "Shoes Top",
        "1000",
        "20",
        "3",
        "This is new Deal",
        "To Be Discussed"
      ],
      "line": 40
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "Save the Deal",
  "keyword": "Then "
});
formatter.match({
  "location": "MultiDealsSteps.user_is_on_Application_Home_Page()"
});
formatter.result({
  "duration": 1731004900,
  "status": "passed"
});
formatter.match({
  "location": "MultiDealsSteps.application_Page_Tittle_is_FREE_CRM()"
});
formatter.result({
  "duration": 511282200,
  "error_message": "junit.framework.ComparisonFailure: expected:\u003cFree CRM [in the cloud software boosts sales]\u003e but was:\u003cFree CRM [#1 cloud software for any business large or small]\u003e\r\n\tat junit.framework.Assert.assertEquals(Assert.java:100)\r\n\tat junit.framework.Assert.assertEquals(Assert.java:107)\r\n\tat StepDefinitions.MultiDealsSteps.application_Page_Tittle_is_FREE_CRM(MultiDealsSteps.java:64)\r\n\tat ✽.When Application Page Tittle is FREE CRM(src/main/java/Features/Hooks.feature:27)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "MultiDealsSteps.user_enters_username_and_password(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MultiDealsSteps.user_clicks_on_Login_Butoon()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MultiDealsSteps.user_navigate_to_user_Profile_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MultiDealsSteps.go_to_Deals()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MultiDealsSteps.open_New_Deal_Form()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MultiDealsSteps.user_enters_deal_data(DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MultiDealsSteps.save_the_Deal()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 1006413799,
  "status": "passed"
});
});