package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class DynoCreateAction
    implements Action<Dyno> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;
  private String command;

  public DynoCreateAction(String appIdOrName, String command) {
    this.appIdOrName = appIdOrName;
    this.command = command;
  }

  public String httpMethod() {
    return "POST";
  }

  public String path() {
    return "/apps/{app-id-or-name}/dynos".replace("{app-id-or-name}", appIdOrName);
  }

  public Object requestEntity() {
    return this;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(201);
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
