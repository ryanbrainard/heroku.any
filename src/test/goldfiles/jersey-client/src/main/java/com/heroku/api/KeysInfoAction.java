package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class KeysInfoAction
    implements Action<Key> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private final String keyIdOrFingerprint;

  public KeysInfoAction(String keyIdOrFingerprint) {
    this.keyIdOrFingerprint = keyIdOrFingerprint;
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/account/keys/{key-id-or-fingerprint}".replace("{key-id-or-fingerprint}", keyIdOrFingerprint);
  }

  public int expectedStatus() {
    return 200;
  }

  public Class<Key> responseClass() {
    return Key.class;
  }

  public String getKeyIdOrFingerprint() {
    return this.keyIdOrFingerprint;
  }
}