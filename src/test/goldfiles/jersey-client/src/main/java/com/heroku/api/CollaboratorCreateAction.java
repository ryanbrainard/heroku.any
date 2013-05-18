package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class CollaboratorCreateAction
    implements Action<Collaborator> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;
  private User user;

  public CollaboratorCreateAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public String httpMethod() {
    return "POST";
  }

  public String path() {
    return "/apps/{app-id-or-name}/collaborators".replace("{app-id-or-name}", appIdOrName);
  }

  public Object requestEntity() {
    return this;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(201);
  }

  public com.sun.jersey.api.client.GenericType<Collaborator> responseType() {
    return new com.sun.jersey.api.client.GenericType<Collaborator>(){};
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }

  public User getUser() {
    return this.user;
  }

  /**
   * Set user
   */
  public CollaboratorCreateAction setUser(User user) {
    this.user = user;
    return this;
  }
}
