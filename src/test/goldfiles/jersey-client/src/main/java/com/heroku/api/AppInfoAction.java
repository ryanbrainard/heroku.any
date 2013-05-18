package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class AppInfoAction
    implements Action<App> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;

  public AppInfoAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/apps/{app-id-or-name}".replace("{app-id-or-name}", appIdOrName);
  }

  public Object requestEntity() {
    return null;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200);
  }

  public com.sun.jersey.api.client.GenericType<App> responseType() {
    return new com.sun.jersey.api.client.GenericType<App>(){};
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }
}
