package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class DomainDeleteAction
    implements Action<Domain> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;
  @org.codehaus.jackson.annotate.JsonIgnore
  private String domainIdOrHostname;

  public DomainDeleteAction(String appIdOrName, String domainIdOrHostname) {
    this.appIdOrName = appIdOrName;
    this.domainIdOrHostname = domainIdOrHostname;
  }

  public String httpMethod() {
    return "DELETE";
  }

  public String path() {
    return "/apps/{app-id-or-name}/domains/{domain-id-or-hostname}".replace("{app-id-or-name}", appIdOrName).replace("{domain-id-or-hostname}", domainIdOrHostname);
  }

  public Object requestEntity() {
    return null;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200);
  }

  public com.sun.jersey.api.client.GenericType<Domain> responseType() {
    return new com.sun.jersey.api.client.GenericType<Domain>(){};
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }

  public String getDomainIdOrHostname() {
    return this.domainIdOrHostname;
  }
}
