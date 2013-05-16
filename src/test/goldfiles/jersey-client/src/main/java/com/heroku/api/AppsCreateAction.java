package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class AppsCreateAction
    implements Action<App> {

  private String name;
  private Region region;
  private String stack;

  public AppsCreateAction() {
  }

  public String httpMethod() {
    return "POST";
  }

  public String path() {
    return "/apps";
  }

  public int expectedStatus() {
    return 201;
  }

  public Class<App> responseClass() {
    return App.class;
  }

  public String getName() {
    return this.name;
  }

  public Region getRegion() {
    return this.region;
  }

  public String getStack() {
    return this.stack;
  }

  /**
   * Set unique name of app
   */
  public AppsCreateAction setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Set region
   */
  public AppsCreateAction setRegion(Region region) {
    this.region = region;
    return this;
  }

  /**
   * Set stack of app
   */
  public AppsCreateAction setStack(String stack) {
    this.stack = stack;
    return this;
  }
}
