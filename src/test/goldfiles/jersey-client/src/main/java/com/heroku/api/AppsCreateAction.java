package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class AppsCreateAction
    implements Action<App> {


  public AppsCreateAction() {
  }

  public String httpMethod() {
    return "POST";
  }

  public String path() {
    return "/apps";
  }

  public int expectedStatus() {
    return 201;
  }

  public Class<App> responseClass() {
    return App.class;
  }
}
