package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class ReleaseInfoAction
    implements Action<Release> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String appIdOrName;
  @org.codehaus.jackson.annotate.JsonIgnore
  private String releaseIdOrName;

  public ReleaseInfoAction(String appIdOrName, String releaseIdOrName) {
    this.appIdOrName = appIdOrName;
    this.releaseIdOrName = releaseIdOrName;
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/apps/{app-id-or-name}/releases/{release-id-or-name}".replace("{app-id-or-name}", appIdOrName).replace("{release-id-or-name}", releaseIdOrName);
  }

  public Object requestEntity() {
    return null;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200);
  }

  public Class<Release> responseClass() {
    return Release.class;
  }

  public String getAppIdOrName() {
    return this.appIdOrName;
  }

  public String getReleaseIdOrName() {
    return this.releaseIdOrName;
  }
}
