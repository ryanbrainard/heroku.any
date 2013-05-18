package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class FormationListAction
    implements Action<java.util.List<Formation>> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;

  public FormationListAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public java.util.List<Formation> execute(Connection connection) {
    return connection.execute(this);
  }

  public Iterable<Formation> executeList(Connection connection) {
    return connection.executeList(this);
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

  public com.sun.jersey.api.client.GenericType<java.util.List<Formation>> responseType() {
    return new com.sun.jersey.api.client.GenericType<java.util.List<Formation>>(){};
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }
}
