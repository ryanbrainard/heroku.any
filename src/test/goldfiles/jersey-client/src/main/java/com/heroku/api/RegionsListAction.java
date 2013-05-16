package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class RegionsListAction
    implements Action<Region> {


  public RegionsListAction() {
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/regions";
  }

  public int expectedStatus() {
    return 200;
  }

  public Class<Region> responseClass() {
    return Region.class;
  }
}
