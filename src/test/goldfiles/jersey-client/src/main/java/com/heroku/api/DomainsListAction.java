package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class DomainsListAction
    implements Action<Domain> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;

  public DomainsListAction(String appIdOrName) {
    this.appIdOrName = appIdOrName;
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/apps/{app-id-or-name}/domains".replace("{app-id-or-name}", appIdOrName);
  }

  public int expectedStatus() {
    return 200;
  }

  public Class<Domain> responseClass() {
    return Domain.class;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }
}
