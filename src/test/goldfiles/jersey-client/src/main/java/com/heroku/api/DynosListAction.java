package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class DynosListAction
    implements Action<Dyno> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private final String appIdOrName;

  public DynosListAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/apps/{app-id-or-name}/dynos".replace("{app-id-or-name}", appIdOrName);
  }

  public int expectedStatus() {
    return 200;
  }

  public Class<Dyno> responseClass() {
    return Dyno.class;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }
}
