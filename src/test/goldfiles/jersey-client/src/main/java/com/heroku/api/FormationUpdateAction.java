package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class FormationUpdateAction
    implements Action<Formation> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;
  @org.codehaus.jackson.annotate.JsonIgnore
  private String formationIdOrProcessType;
  private Number quantity;

  public FormationUpdateAction(String appIdOrName, String formationIdOrProcessType, Number quantity) {
    this.appIdOrName = appIdOrName;
    this.formationIdOrProcessType = formationIdOrProcessType;
    this.quantity = quantity;
  }

  public String httpMethod() {
    return "PATCH";
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

  public Number getQuantity() {
    return this.quantity;
  }
}
