package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class KeysListAction
    implements Action<Key> {


  public KeysListAction() {
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/account/keys";
  }

  public int expectedStatus() {
    return 200;
  }

  public Class<Key> responseClass() {
    return Key.class;
  }
}
