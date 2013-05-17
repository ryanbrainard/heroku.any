package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class RegionListAction
    implements Action<Region> {


  public RegionListAction() {
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/regions";
  }

  public Object requestEntity() {
    return null;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200,206);
  }

  public Class<Region> responseClass() {
    return Region.class;
  }
}
