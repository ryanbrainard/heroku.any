package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class CollaboratorDeleteAction
    implements Action<Collaborator> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;
  @org.codehaus.jackson.annotate.JsonIgnore
  private String collaboratorIdOrEmail;

  public CollaboratorDeleteAction(String appIdOrName, String collaboratorIdOrEmail) {
    this.appIdOrName = appIdOrName;
    this.collaboratorIdOrEmail = collaboratorIdOrEmail;
  }

  public String httpMethod() {
    return "DELETE";
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

  public Class<Collaborator> responseClass() {
    return Collaborator.class;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }

  public String getCollaboratorIdOrEmail() {
    return this.collaboratorIdOrEmail;
  }
}
