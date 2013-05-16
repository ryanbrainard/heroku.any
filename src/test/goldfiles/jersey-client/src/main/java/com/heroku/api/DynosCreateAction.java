package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class DynosCreateAction
    implements Action<Dyno> {

  private final String command;
  @org.codehaus.jackson.annotate.JsonIgnore
  private final String appIdOrName;

  public DynosCreateAction(String command, String appIdOrName) {
    this.command = command;
    this.appIdOrName = appIdOrName;
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

  public String getCommand() {
    return this.command;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }
}
