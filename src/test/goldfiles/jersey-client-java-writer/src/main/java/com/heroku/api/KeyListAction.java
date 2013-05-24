package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class KeyListAction
    implements Action<java.util.List<Key>> {


  public KeyListAction() {
  }

  public java.util.List<Key> execute(Connection connection) {
    return connection.execute(this);
  }

  public Iterable<Key> executeList(Connection connection) {
    return connection.executeList(this);
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

  public com.sun.jersey.api.client.GenericType<java.util.List<Key>> responseType() {
    return new com.sun.jersey.api.client.GenericType<java.util.List<Key>>(){};
  }
}
