package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class KeyDeleteAction
    implements Action<Key> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String keyIdOrFingerprint;

  public KeyDeleteAction(String keyIdOrFingerprint) {
    this.keyIdOrFingerprint = keyIdOrFingerprint;
  }

  public Key execute(Connection connection) {
    return connection.execute(this);
  }

  public String httpMethod() {
    return "DELETE";
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

  public com.sun.jersey.api.client.GenericType<Key> responseType() {
    return new com.sun.jersey.api.client.GenericType<Key>(){};
  }

  public String getKeyIdOrFingerprint() {
    return this.keyIdOrFingerprint;
  }
}
