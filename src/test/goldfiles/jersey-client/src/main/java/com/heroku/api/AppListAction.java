package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class AppListAction
    implements Action<App> {


  public AppListAction() {
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/apps";
  }

  public Object requestEntity() {
    return null;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200,206);
  }

  public Class<App> responseClass() {
    return App.class;
  }
}
