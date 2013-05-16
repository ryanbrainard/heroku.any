package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class FormationUpdateAction
    implements Action<Formation> {

  private final Number quantity;
  @org.codehaus.jackson.annotate.JsonIgnore
  private final String appIdOrName;
  @org.codehaus.jackson.annotate.JsonIgnore
  private final String formationIdOrProcessType;

  public FormationUpdateAction(Number quantity, String appIdOrName, String formationIdOrProcessType) {
    this.quantity = quantity;
    this.appIdOrName = appIdOrName;
    this.formationIdOrProcessType = formationIdOrProcessType;
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

  public Number getQuantity() {
    return this.quantity;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }

  public String getFormationIdOrProcessType() {
    return this.formationIdOrProcessType;
  }
}
