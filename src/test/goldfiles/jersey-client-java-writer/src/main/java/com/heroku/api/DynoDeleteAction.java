package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class DynoDeleteAction
    implements Action<Dyno> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;
  @org.codehaus.jackson.annotate.JsonIgnore
  private String dynoIdOrName;

  public DynoDeleteAction(String appIdOrName, String dynoIdOrName) {
    this.appIdOrName = appIdOrName;
    this.dynoIdOrName = dynoIdOrName;
  }

  public Dyno execute(Connection connection) {
    return connection.execute(this);
  }

  public String httpMethod() {
    return "DELETE";
  }

  public String path() {
    return "/apps/{app-id-or-name}/dynos/{dyno-id-or-name}".replace("{app-id-or-name}", appIdOrName).replace("{dyno-id-or-name}", dynoIdOrName);
  }

  public Object requestEntity() {
    return null;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200);
  }

  public com.sun.jersey.api.client.GenericType<Dyno> responseType() {
    return new com.sun.jersey.api.client.GenericType<Dyno>(){};
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }

  public String getDynoIdOrName() {
    return this.dynoIdOrName;
  }
}
