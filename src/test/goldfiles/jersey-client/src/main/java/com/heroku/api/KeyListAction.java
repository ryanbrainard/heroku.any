package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class KeyListAction
    implements Action<java.util.List> {


  public KeyListAction() {
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/account/keys";
  }

  public Object requestEntity() {
    return null;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200);
  }

  public com.sun.jersey.api.client.GenericType<java.util.List> responseType() {
    return new com.sun.jersey.api.client.GenericType<java.util.List>(){};
  }
}
