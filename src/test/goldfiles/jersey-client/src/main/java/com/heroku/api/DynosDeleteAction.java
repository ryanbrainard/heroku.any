package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class DynosDeleteAction
    implements Action<Dyno> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;
  @org.codehaus.jackson.annotate.JsonIgnore
  private String dynoIdOrName;

  public DynosDeleteAction(String appIdOrName, String dynoIdOrName) {
    this.appIdOrName = appIdOrName;
    this.dynoIdOrName = dynoIdOrName;
  }

  public String httpMethod() {
    return "DELETE";
  }

  public String path() {
    return "/apps/{app-id-or-name}/dynos/{dyno-id-or-name}".replace("{app-id-or-name}", appIdOrName).replace("{dyno-id-or-name}", dynoIdOrName);
  }

  public int expectedStatus() {
    return 202;
  }

  public Class<Dyno> responseClass() {
    return Dyno.class;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }

  public String getDynoIdOrName() {
    return this.dynoIdOrName;
  }
}
