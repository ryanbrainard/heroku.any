package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class FormationListAction
    implements Action<java.util.List> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;

  public FormationListAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/apps/{app-id-or-name}/formation".replace("{app-id-or-name}", appIdOrName);
  }

  public Object requestEntity() {
    return null;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200,206);
  }

  public com.sun.jersey.api.client.GenericType<java.util.List> responseType() {
    return new com.sun.jersey.api.client.GenericType<java.util.List>(){};
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }
}
