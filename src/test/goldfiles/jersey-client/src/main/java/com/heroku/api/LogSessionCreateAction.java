package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class LogSessionCreateAction
    implements Action<LogSession> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;

  public LogSessionCreateAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public LogSession execute(Connection connection) {
    return connection.execute(this);
  }

  public String httpMethod() {
    return "POST";
  }

  public String path() {
    return "/apps/{app-id-or-name}/log-sessions".replace("{app-id-or-name}", appIdOrName);
  }

  public Object requestEntity() {
    return this;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(201);
  }

  public com.sun.jersey.api.client.GenericType<LogSession> responseType() {
    return new com.sun.jersey.api.client.GenericType<LogSession>(){};
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }
}
