package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class ReleasesListAction
    implements Action<Release> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;

  public ReleasesListAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/apps/{app-id-or-name}/releases".replace("{app-id-or-name}", appIdOrName);
  }

  public int expectedStatus() {
    return 200;
  }

  public Class<Release> responseClass() {
    return Release.class;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }
}
