package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class CollaboratorsCreateAction
    implements Action<Collaborator> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private final String appIdOrName;

  public CollaboratorsCreateAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public String httpMethod() {
    return "POST";
  }

  public String path() {
    return "/apps/{app-id-or-name}/collaborators".replace("{app-id-or-name}", appIdOrName);
  }

  public int expectedStatus() {
    return 201;
  }

  public Class<Collaborator> responseClass() {
    return Collaborator.class;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }
}
