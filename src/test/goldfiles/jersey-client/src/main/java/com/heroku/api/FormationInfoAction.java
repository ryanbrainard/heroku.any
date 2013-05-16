package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class FormationInfoAction
    implements Action<Formation> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private final String appIdOrName;
  @org.codehaus.jackson.annotate.JsonIgnore
  private final String formationIdOrProcessType;

  public FormationInfoAction(String appIdOrName, String formationIdOrProcessType) {
    this.appIdOrName = appIdOrName;
    this.formationIdOrProcessType = formationIdOrProcessType;
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/apps/{app-id-or-name}/formation/{formation-id-or-process-type}".replace("{app-id-or-name}", appIdOrName).replace("{formation-id-or-process-type}", formationIdOrProcessType);
  }

  public int expectedStatus() {
    return 200;
  }

  public Class<Formation> responseClass() {
    return Formation.class;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }

  public String getFormationIdOrProcessType() {
    return this.formationIdOrProcessType;
  }
}
