package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class KeyListAction
    implements Action<Key> {


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

  public Class<Key> responseClass() {
    return Key.class;
  }
}
