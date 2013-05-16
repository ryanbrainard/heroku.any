package com.heroku.api;

public class App {

  /**
   * Unique identifier of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * Owner
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Owner owner;

  /**
   * Maintenance status of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private boolean maintenance;

  /**
   * When app was last released
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date released_at;

  /**
   * When app was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * Tier level of account
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String tier;

  /**
   * App slug size in bytes
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Number slug_size;

  /**
   * App git repo size in bytes
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Number repo_size;

  /**
   * Unique name of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String name;

  /**
   * Description from buildpack of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String buildpack_provided_description;

  /**
   * Web url of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String web_url;

  /**
   * Legacy id of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String legacy_id;

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
   * Region
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Region region;

  /**
   * When app was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * Construct empty Apps
   */
  public App() {
  }

  public App(java.util.UUID id, Owner owner, boolean maintenance, java.util.Date released_at, java.util.Date created_at, String tier, Number slug_size, Number repo_size, String name, String buildpack_provided_description, String web_url, String legacy_id, String git_url, String stack, Region region, java.util.Date updated_at) {
    this.id = id;
    this.owner = owner;
    this.maintenance = maintenance;
    this.released_at = released_at;
    this.created_at = created_at;
    this.tier = tier;
    this.slug_size = slug_size;
    this.repo_size = repo_size;
    this.name = name;
    this.buildpack_provided_description = buildpack_provided_description;
    this.web_url = web_url;
    this.legacy_id = legacy_id;
    this.git_url = git_url;
    this.stack = stack;
    this.region = region;
    this.updated_at = updated_at;
  }

  /**
   * Get unique identifier of app
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get owner
   */
  public Owner getOwner() {
    return this.owner;
  }

  /**
   * Get maintenance status of app
   */
  public boolean getMaintenance() {
    return this.maintenance;
  }

  /**
   * Get when app was last released
   */
  public java.util.Date getReleasedAt() {
    return this.released_at;
  }

  /**
   * Get when app was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get tier level of account
   */
  public String getTier() {
    return this.tier;
  }

  /**
   * Get app slug size in bytes
   */
  public Number getSlugSize() {
    return this.slug_size;
  }

  /**
   * Get app git repo size in bytes
   */
  public Number getRepoSize() {
    return this.repo_size;
  }

  /**
   * Get unique name of app
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get description from buildpack of app
   */
  public String getBuildpackProvidedDescription() {
    return this.buildpack_provided_description;
  }

  /**
   * Get web url of app
   */
  public String getWebUrl() {
    return this.web_url;
  }

  /**
   * Get legacy id of app
   */
  public String getLegacyId() {
    return this.legacy_id;
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
   * Get region
   */
  public Region getRegion() {
    return this.region;
  }

  /**
   * Get when app was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

}
