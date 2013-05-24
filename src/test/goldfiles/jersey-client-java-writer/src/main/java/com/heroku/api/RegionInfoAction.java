package com.heroku.api;

@org.codehaus.jackson.map.annotate.JsonSerialize
public final class RegionInfoAction
    implements Action<Region> {

  @org.codehaus.jackson.annotate.JsonIgnore
  private String regionIdOrName;

  public RegionInfoAction(String regionIdOrName) {
    this.regionIdOrName = regionIdOrName;
  }

  public Region execute(Connection connection) {
    return connection.execute(this);
  }

  public String httpMethod() {
    return "GET";
  }

  public String path() {
    return "/regions/{region-id-or-name}".replace("{region-id-or-name}", regionIdOrName);
  }

  public Object requestEntity() {
    return null;
  }

  public java.util.Collection<Integer> expectedStatuses() {
    return java.util.Arrays.asList(200);
  }

  public com.sun.jersey.api.client.GenericType<Region> responseType() {
    return new com.sun.jersey.api.client.GenericType<Region>(){};
  }

  public String getRegionIdOrName() {
    return this.regionIdOrName;
  }
}
