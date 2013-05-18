package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class CollaboratorInfoAction
    implements Action<Collaborator> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;
  @org.codehaus.jackson.annotate.JsonIgnore
  private String collaboratorIdOrEmail;

  public CollaboratorInfoAction(String appIdOrName, String collaboratorIdOrEmail) {
    this.appIdOrName = appIdOrName;
    this.collaboratorIdOrEmail = collaboratorIdOrEmail;
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/apps/{app-id-or-name}/collaborators/{collaborator-id-or-email}".replace("{app-id-or-name}", appIdOrName).replace("{collaborator-id-or-email}", collaboratorIdOrEmail);
  }

  public Object requestEntity() {
    return null;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200);
  }

  public com.sun.jersey.api.client.GenericType<Collaborator> responseType() {
    return new com.sun.jersey.api.client.GenericType<Collaborator>(){};
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }

  public String getCollaboratorIdOrEmail() {
    return this.collaboratorIdOrEmail;
  }
}
