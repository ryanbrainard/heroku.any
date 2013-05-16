package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class DomainsCreateAction
    implements Action<Domain> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;
  private String hostname;

  public DomainsCreateAction(String appIdOrName, String hostname) {
    this.appIdOrName = appIdOrName;
    this.hostname = hostname;
  }

  public String httpMethod() {
    return "POST";
  }

  public String path() {
    return "/apps/{app-id-or-name}/domains".replace("{app-id-or-name}", appIdOrName);
  }

  public int expectedStatus() {
    return 201;
  }

  public Class<Domain> responseClass() {
    return Domain.class;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }

  public String getHostname() {
    return this.hostname;
  }
}
