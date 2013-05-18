package com.heroku.api;

public class App
    implements java.io.Serializable {

  protected static final long serialVersionUID = -1561520212L;

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
   * App is created in response to API calls
   */
  protected App() {
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
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    App app = (App) o;

    if (buildpack_provided_description != app.buildpack_provided_description) return false;
    if (legacy_id != app.legacy_id) return false;
    if (name != app.name) return false;
    if (tier != app.tier) return false;
    if (region != null ? !region.equals(app.region) : app.region != null) return false;
    if (maintenance != app.maintenance) return false;
    if (git_url != app.git_url) return false;
    if (stack != app.stack) return false;
    if (id != app.id) return false;
    if (repo_size != app.repo_size) return false;
    if (owner != null ? !owner.equals(app.owner) : app.owner != null) return false;
    if (web_url != app.web_url) return false;
    if (slug_size != app.slug_size) return false;
    if (created_at != app.created_at) return false;
    if (updated_at != app.updated_at) return false;
    if (released_at != app.released_at) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
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
