package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class ConfigVarUpdateAction
    implements Action<java.util.Map> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;
  private java.util.Map keyPairs;

  public ConfigVarUpdateAction(String appIdOrName, java.util.Map keyPairs) {
    this.appIdOrName = appIdOrName;
    this.keyPairs = keyPairs;
  }

  public String httpMethod() {
    return "PATCH";
  }

  public String path() {
    return "/apps/{app-id-or-name}/config-vars".replace("{app-id-or-name}", appIdOrName);
  }

  public Object requestEntity() {
    return keyPairs;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200);
  }

  public com.sun.jersey.api.client.GenericType<java.util.Map> responseType() {
    return new com.sun.jersey.api.client.GenericType<java.util.Map>(){};
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }

  public java.util.Map getKeyPairs() {
    return this.keyPairs;
  }
}
