package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class DomainsDeleteAction
    implements Action<Domain> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private final String appIdOrName;
  @org.codehaus.jackson.annotate.JsonIgnore
  private final String domainIdOrDomain;

  public DomainsDeleteAction(String appIdOrName, String domainIdOrDomain) {
    this.appIdOrName = appIdOrName;
    this.domainIdOrDomain = domainIdOrDomain;
  }

  public String httpMethod() {
    return "DELETE";
  }

  public String path() {
    return "/apps/{app-id-or-name}/domains/{domain-id-or-domain}".replace("{app-id-or-name}", appIdOrName).replace("{domain-id-or-domain}", domainIdOrDomain);
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

  public String getDomainIdOrDomain() {
    return this.domainIdOrDomain;
  }
}
