package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class CollaboratorListAction
    implements Action<java.util.List<Collaborator>> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;

  public CollaboratorListAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/apps/{app-id-or-name}/collaborators".replace("{app-id-or-name}", appIdOrName);
  }

  public Object requestEntity() {
    return null;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200,206);
  }

  public com.sun.jersey.api.client.GenericType<java.util.List<Collaborator>> responseType() {
    return new com.sun.jersey.api.client.GenericType<java.util.List<Collaborator>>(){};
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }
}
