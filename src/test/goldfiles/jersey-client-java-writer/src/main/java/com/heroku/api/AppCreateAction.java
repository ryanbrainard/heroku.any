package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class AppCreateAction
    implements Action<App> {

  private String name;
  private Region region;
  private String stack;

  public AppCreateAction() {
  }

  public App execute(Connection connection) {
    return connection.execute(this);
  }

  public String httpMethod() {
    return "POST";
  }

  public String path() {
    return "/apps";
  }

  public Object requestEntity() {
    return this;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(201);
  }

  public com.sun.jersey.api.client.GenericType<App> responseType() {
    return new com.sun.jersey.api.client.GenericType<App>(){};
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
  public AppCreateAction setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Set region
   */
  public AppCreateAction setRegion(Region region) {
    this.region = region;
    return this;
  }

  /**
   * Set stack of app
   */
  public AppCreateAction setStack(String stack) {
    this.stack = stack;
    return this;
  }
}
