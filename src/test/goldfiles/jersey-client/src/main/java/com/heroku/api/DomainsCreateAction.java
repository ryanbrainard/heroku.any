package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class DomainsCreateAction
    implements Action<Domain> {

  private final String hostname;
  @org.codehaus.jackson.annotate.JsonIgnore
  private final String appIdOrName;

  public DomainsCreateAction(String hostname, String appIdOrName) {
    this.hostname = hostname;
    this.appIdOrName = appIdOrName;
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

  public String getHostname() {
    return this.hostname;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }
}
