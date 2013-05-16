package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class AppsDeleteAction
    implements Action<App> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;

  public AppsDeleteAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public String httpMethod() {
    return "DELETE";
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
