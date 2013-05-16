package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class RegionsInfoAction
    implements Action<Region> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private final String regionIdOrName;

  public RegionsInfoAction(String regionIdOrName) {
    this.regionIdOrName = regionIdOrName;
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/regions/{region-id-or-name}".replace("{region-id-or-name}", regionIdOrName);
  }

  public int expectedStatus() {
    return 200;
  }

  public Class<Region> responseClass() {
    return Region.class;
  }

  public String getRegionIdOrName() {
    return this.regionIdOrName;
  }
}
