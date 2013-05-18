package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class AppListAction
    implements Action<java.util.List> {


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

  public com.sun.jersey.api.client.GenericType<java.util.List> responseType() {
    return new com.sun.jersey.api.client.GenericType<java.util.List>(){};
  }
}
