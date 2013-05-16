package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class ConfigVarsUpdateAction
    implements Action<ConfigVar> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private final String appIdOrName;

  public ConfigVarsUpdateAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public String httpMethod() {
    return "PATCH";
  }

  public String path() {
    return "/apps/{app-id-or-name}/config-vars".replace("{app-id-or-name}", appIdOrName);
  }

  public int expectedStatus() {
    return 200;
  }

  public Class<ConfigVar> responseClass() {
    return ConfigVar.class;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }
}
