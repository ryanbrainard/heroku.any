package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class KeysCreateAction
    implements Action<Key> {

  private String public_key;

  public KeysCreateAction(String publicKey) {
    this.public_key = publicKey;
  }

  public String httpMethod() {
    return "POST";
  }

  public String path() {
    return "/account/keys";
  }

  public int expectedStatus() {
    return 201;
  }

  public Class<Key> responseClass() {
    return Key.class;
  }

  public String getPublicKey() {
    return this.public_key;
  }
}
