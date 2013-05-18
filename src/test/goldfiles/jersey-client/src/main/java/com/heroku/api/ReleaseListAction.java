package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class ReleaseListAction
    implements Action<java.util.List<Release>> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;

  public ReleaseListAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/apps/{app-id-or-name}/releases".replace("{app-id-or-name}", appIdOrName);
  }

  public Object requestEntity() {
    return null;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200,206);
  }

  public com.sun.jersey.api.client.GenericType<java.util.List<Release>> responseType() {
    return new com.sun.jersey.api.client.GenericType<java.util.List<Release>>(){};
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }
}
