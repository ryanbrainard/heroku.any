package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class DynosCreateAction
    implements Action<Dyno> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private final String appIdOrName;
  private final String command;

  public DynosCreateAction(String appIdOrName, String command) {
    this.appIdOrName = appIdOrName;
    this.command = command;
  }

  public String httpMethod() {
    return "POST";
  }

  public String path() {
    return "/apps/{app-id-or-name}/dynos".replace("{app-id-or-name}", appIdOrName);
  }

  public int expectedStatus() {
    return 201;
  }

  public Class<Dyno> responseClass() {
    return Dyno.class;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }

  public String getCommand() {
    return this.command;
  }
}
