package com.heroku.api;

public class App {

  /**
   * Description from buildpack of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String buildpack_provided_description;

  /**
   * Deprecated id format
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String legacy_id;

  /**
   * Unique name of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String name;

  /**
   * App tier
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String tier;

  /**
   * Region
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Region region;

  /**
   * Maintenance status of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private boolean maintenance;

  /**
   * Git repo url of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String git_url;

  /**
   * Stack of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String stack;

  /**
   * Unique identifier of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * App git repo size in bytes
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Number repo_size;

  /**
   * Owner
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Owner owner;

  /**
   * Web url of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String web_url;

  /**
   * App slug size in bytes
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Number slug_size;

  /**
   * When app was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * When app was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * When app was last released
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date released_at;

  /**
   * Construct empty App
   */
  public App() {
  }

  public App(String buildpack_provided_description, String legacy_id, String name, String tier, Region region, boolean maintenance, String git_url, String stack, java.util.UUID id, Number repo_size, Owner owner, String web_url, Number slug_size, java.util.Date created_at, java.util.Date updated_at, java.util.Date released_at) {
    this.buildpack_provided_description = buildpack_provided_description;
    this.legacy_id = legacy_id;
    this.name = name;
    this.tier = tier;
    this.region = region;
    this.maintenance = maintenance;
    this.git_url = git_url;
    this.stack = stack;
    this.id = id;
    this.repo_size = repo_size;
    this.owner = owner;
    this.web_url = web_url;
    this.slug_size = slug_size;
    this.created_at = created_at;
    this.updated_at = updated_at;
    this.released_at = released_at;
  }

  /**
   * Get description from buildpack of app
   */
  public String getBuildpackProvidedDescription() {
    return this.buildpack_provided_description;
  }

  /**
   * Get Deprecated id format
   */
  public String getLegacyId() {
    return this.legacy_id;
  }

  /**
   * Get unique name of app
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get App tier
   */
  public String getTier() {
    return this.tier;
  }

  /**
   * Get region
   */
  public Region getRegion() {
    return this.region;
  }

  /**
   * Get maintenance status of app
   */
  public boolean getMaintenance() {
    return this.maintenance;
  }

  /**
   * Get git repo url of app
   */
  public String getGitUrl() {
    return this.git_url;
  }

  /**
   * Get stack of app
   */
  public String getStack() {
    return this.stack;
  }

  /**
   * Get unique identifier of app
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get app git repo size in bytes
   */
  public Number getRepoSize() {
    return this.repo_size;
  }

  /**
   * Get owner
   */
  public Owner getOwner() {
    return this.owner;
  }

  /**
   * Get web url of app
   */
  public String getWebUrl() {
    return this.web_url;
  }

  /**
   * Get app slug size in bytes
   */
  public Number getSlugSize() {
    return this.slug_size;
  }

  /**
   * Get when app was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get when app was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  /**
   * Get when app was last released
   */
  public java.util.Date getReleasedAt() {
    return this.released_at;
  }

  @Override
  public String toString() {
    return "App{" + 
        "buildpackProvidedDescription='" + buildpack_provided_description + '\'' +
        ", " + "legacyId='" + legacy_id + '\'' +
        ", " + "name='" + name + '\'' +
        ", " + "tier='" + tier + '\'' +
        ", " + "region='" + region + '\'' +
        ", " + "maintenance='" + maintenance + '\'' +
        ", " + "gitUrl='" + git_url + '\'' +
        ", " + "stack='" + stack + '\'' +
        ", " + "id='" + id + '\'' +
        ", " + "repoSize='" + repo_size + '\'' +
        ", " + "owner='" + owner + '\'' +
        ", " + "webUrl='" + web_url + '\'' +
        ", " + "slugSize='" + slug_size + '\'' +
        ", " + "createdAt='" + created_at + '\'' +
        ", " + "updatedAt='" + updated_at + '\'' +
        ", " + "releasedAt='" + released_at + '\'' +
        '}';
  }

}
