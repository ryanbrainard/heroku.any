package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class AppsUpdateAction
    implements Action<App> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private final String appIdOrName;

  public AppsUpdateAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public String httpMethod() {
    return "PATCH";
  }

  public String path() {
    return "/apps/{app-id-or-name}".replace("{app-id-or-name}", appIdOrName);
  }

  public int expectedStatus() {
    return 200;
  }

  public Class<App> responseClass() {
    return App.class;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }
}
