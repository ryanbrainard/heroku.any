package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class AppsListAction
    implements Action<App> {


  public AppsListAction() {
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/apps";
  }

  public int expectedStatus() {
    return 200;
  }

  public Class<App> responseClass() {
    return App.class;
  }
}
