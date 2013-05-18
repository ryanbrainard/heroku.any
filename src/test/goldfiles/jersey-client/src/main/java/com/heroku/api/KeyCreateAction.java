package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class KeyCreateAction
    implements Action<Key> {

  private String public_key;

  public KeyCreateAction(String publicKey) {
    this.public_key = publicKey;
  }

  public String httpMethod() {
    return "POST";
  }

  public String path() {
    return "/account/keys";
  }

  public Object requestEntity() {
    return this;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(201);
  }

  public com.sun.jersey.api.client.GenericType<Key> responseType() {
    return new com.sun.jersey.api.client.GenericType<Key>(){};
  }

  public String getPublicKey() {
    return this.public_key;
  }
}
