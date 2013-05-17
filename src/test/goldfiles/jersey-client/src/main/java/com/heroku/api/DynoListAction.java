package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class DynoListAction
    implements Action<Dyno> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;

  public DynoListAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/apps/{app-id-or-name}/dynos".replace("{app-id-or-name}", appIdOrName);
  }

  public Object requestEntity() {
    return null;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200,206);
  }

  public Class<Dyno> responseClass() {
    return Dyno.class;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }
}
