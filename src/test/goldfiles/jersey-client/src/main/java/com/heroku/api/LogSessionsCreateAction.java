package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class LogSessionsCreateAction
    implements Action<LogSession> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;

  public LogSessionsCreateAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public String httpMethod() {
    return "POST";
  }

  public String path() {
    return "/apps/{app-id-or-name}/log-sessions".replace("{app-id-or-name}", appIdOrName);
  }

  public int expectedStatus() {
    return 201;
  }

  public Class<LogSession> responseClass() {
    return LogSession.class;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }
}
