package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class ConfigVarInfoAction
    implements Action<java.util.Map> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;

  public ConfigVarInfoAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/apps/{app-id-or-name}/config-vars".replace("{app-id-or-name}", appIdOrName);
  }

  public Object requestEntity() {
    return null;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200);
  }

  public Class<java.util.Map> responseClass() {
    return java.util.Map.class;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }
}
