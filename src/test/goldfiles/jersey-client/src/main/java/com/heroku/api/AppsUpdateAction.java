package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class AppsUpdateAction
    implements Action<App> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;
  private String name;
  private boolean maintenance;
  private Owner owner;

  public AppsUpdateAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public String httpMethod() {
    return "PATCH";
  }

  public String path() {
    return "/apps/{app-id-or-name}".replace("{app-id-or-name}", appIdOrName);
  }

  public int expectedStatus() {
    return 200;
  }

  public Class<App> responseClass() {
    return App.class;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }

  public String getName() {
    return this.name;
  }

  public boolean getMaintenance() {
    return this.maintenance;
  }

  public Owner getOwner() {
    return this.owner;
  }

  /**
   * Set unique name of app
   */
  public AppsUpdateAction setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Set maintenance status of app
   */
  public AppsUpdateAction setMaintenance(boolean maintenance) {
    this.maintenance = maintenance;
    return this;
  }

  /**
   * Set owner
   */
  public AppsUpdateAction setOwner(Owner owner) {
    this.owner = owner;
    return this;
  }
}
