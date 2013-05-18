package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class DomainCreateAction
    implements Action<Domain> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;
  private String hostname;

  public DomainCreateAction(String appIdOrName, String hostname) {
    this.appIdOrName = appIdOrName;
    this.hostname = hostname;
  }

  public String httpMethod() {
    return "POST";
  }

  public String path() {
    return "/apps/{app-id-or-name}/domains".replace("{app-id-or-name}", appIdOrName);
  }

  public Object requestEntity() {
    return this;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(201);
  }

  public com.sun.jersey.api.client.GenericType<Domain> responseType() {
    return new com.sun.jersey.api.client.GenericType<Domain>(){};
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }

  public String getHostname() {
    return this.hostname;
  }
}
