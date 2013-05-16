package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class CollaboratorsListAction
    implements Action<Collaborator> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;

  public CollaboratorsListAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/apps/{app-id-or-name}/collaborators".replace("{app-id-or-name}", appIdOrName);
  }

  public int expectedStatus() {
    return 200;
  }

  public Class<Collaborator> responseClass() {
    return Collaborator.class;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }
}
