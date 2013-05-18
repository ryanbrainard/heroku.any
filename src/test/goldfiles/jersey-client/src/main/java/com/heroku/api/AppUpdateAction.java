package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class AppUpdateAction
    implements Action<App> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;
  private String name;
  private boolean maintenance;
  private Owner owner;

  public AppUpdateAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public String httpMethod() {
    return "PATCH";
  }

  public String path() {
    return "/apps/{app-id-or-name}".replace("{app-id-or-name}", appIdOrName);
  }

  public Object requestEntity() {
    return this;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200);
  }

  public com.sun.jersey.api.client.GenericType<App> responseType() {
    return new com.sun.jersey.api.client.GenericType<App>(){};
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
  public AppUpdateAction setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Set maintenance status of app
   */
  public AppUpdateAction setMaintenance(boolean maintenance) {
    this.maintenance = maintenance;
    return this;
  }

  /**
   * Set owner
   */
  public AppUpdateAction setOwner(Owner owner) {
    this.owner = owner;
    return this;
  }
}
