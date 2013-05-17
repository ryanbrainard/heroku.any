package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class KeyInfoAction
    implements Action<Key> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String keyIdOrFingerprint;

  public KeyInfoAction(String keyIdOrFingerprint) {
    this.keyIdOrFingerprint = keyIdOrFingerprint;
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/account/keys/{key-id-or-fingerprint}".replace("{key-id-or-fingerprint}", keyIdOrFingerprint);
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

  public String getKeyIdOrFingerprint() {
    return this.keyIdOrFingerprint;
  }
}
