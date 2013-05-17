package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class FormationInfoAction
    implements Action<Formation> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;
  @org.codehaus.jackson.annotate.JsonIgnore
  private String formationIdOrType;

  public FormationInfoAction(String appIdOrName, String formationIdOrType) {
    this.appIdOrName = appIdOrName;
    this.formationIdOrType = formationIdOrType;
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/apps/{app-id-or-name}/formation/{formation-id-or-type}".replace("{app-id-or-name}", appIdOrName).replace("{formation-id-or-type}", formationIdOrType);
  }

  public Object requestEntity() {
    return null;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200);
  }

  public Class<Formation> responseClass() {
    return Formation.class;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }

  public String getFormationIdOrType() {
    return this.formationIdOrType;
  }
}
