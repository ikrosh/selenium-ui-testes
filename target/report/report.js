$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/selenium/ui/google/zadanie1/Page.feature");
formatter.feature({
  "line": 1,
  "name": "Zadanie1",
  "description": "",
  "id": "zadanie1",
  "keyword": "Feature"
});
formatter.before({
  "duration": 17303842514,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Gogle page test",
  "description": "",
  "id": "zadanie1;gogle-page-test",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I am on google search page",
  "keyword": "Given "
});
formatter.match({
  "location": "PageSteps.iAmOnGooglePage()"
});
formatter.result({
  "duration": 2777215526,
  "status": "passed"
});
});