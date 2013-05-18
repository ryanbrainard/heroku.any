package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class ConfigVarUpdateAction
    implements Action<java.util.Map<String,String>> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;
  private java.util.Map<String,String> keyValuePairs;

  public ConfigVarUpdateAction(String appIdOrName, java.util.Map<String,String> keyValuePairs) {
    this.appIdOrName = appIdOrName;
    this.keyValuePairs = keyValuePairs;
  }

  public java.util.Map<String,String> execute(Connection connection) {
    return connection.execute(this);
  }

  public String httpMethod() {
    return "PATCH";
  }

  public String path() {
    return "/apps/{app-id-or-name}/config-vars".replace("{app-id-or-name}", appIdOrName);
  }

  public Object requestEntity() {
    return keyValuePairs;
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

  public java.util.Map<String,String> getKeyValuePairs() {
    return this.keyValuePairs;
  }
}
