package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class ConfigVarUpdateAction
    implements Action<java.util.Map<String,String>> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;
  private java.util.Map<String,String> keyPairs;

  public ConfigVarUpdateAction(String appIdOrName, java.util.Map<String,String> keyPairs) {
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

  public com.sun.jersey.api.client.GenericType<java.util.Map<String,String>> responseType() {
    return new com.sun.jersey.api.client.GenericType<java.util.Map<String,String>>(){};
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }

  public java.util.Map<String,String> getKeyPairs() {
    return this.keyPairs;
  }
}
