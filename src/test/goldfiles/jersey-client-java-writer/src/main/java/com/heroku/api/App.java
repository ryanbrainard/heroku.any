package com.heroku.api;

public class App
    implements java.io.Serializable {

  protected static final long serialVersionUID = 132134333L;

  /**
   * Description from buildpack of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String buildpack_provided_description;

  /**
   * When app was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * Git repo url of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String git_url;

  /**
   * Unique identifier of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * Deprecated id format
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String legacy_id;

  /**
   * Maintenance status of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private boolean maintenance;

  /**
   * Unique name of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String name;

  /**
   * Owner
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Owner owner;

  /**
   * Region
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Region region;

  /**
   * When app was last released
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date released_at;

  /**
   * App git repo size in bytes
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Number repo_size;

  /**
   * App slug size in bytes
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Number slug_size;

  /**
   * Stack of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String stack;

  /**
   * App tier
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String tier;

  /**
   * When app was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * Web url of app
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String web_url;

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
   * Get when app was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get git repo url of app
   */
  public String getGitUrl() {
    return this.git_url;
  }

  /**
   * Get unique identifier of app
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get Deprecated id format
   */
  public String getLegacyId() {
    return this.legacy_id;
  }

  /**
   * Get maintenance status of app
   */
  public boolean getMaintenance() {
    return this.maintenance;
  }

  /**
   * Get unique name of app
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get owner
   */
  public Owner getOwner() {
    return this.owner;
  }

  /**
   * Get region
   */
  public Region getRegion() {
    return this.region;
  }

  /**
   * Get when app was last released
   */
  public java.util.Date getReleasedAt() {
    return this.released_at;
  }

  /**
   * Get app git repo size in bytes
   */
  public Number getRepoSize() {
    return this.repo_size;
  }

  /**
   * Get app slug size in bytes
   */
  public Number getSlugSize() {
    return this.slug_size;
  }

  /**
   * Get stack of app
   */
  public String getStack() {
    return this.stack;
  }

  /**
   * Get App tier
   */
  public String getTier() {
    return this.tier;
  }

  /**
   * Get when app was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  /**
   * Get web url of app
   */
  public String getWebUrl() {
    return this.web_url;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    App app = (App) o;

    if (buildpack_provided_description != null ? !buildpack_provided_description.equals(app.buildpack_provided_description) : app.buildpack_provided_description != null) return false;
    if (created_at != null ? !created_at.equals(app.created_at) : app.created_at != null) return false;
    if (git_url != null ? !git_url.equals(app.git_url) : app.git_url != null) return false;
    if (id != null ? !id.equals(app.id) : app.id != null) return false;
    if (legacy_id != null ? !legacy_id.equals(app.legacy_id) : app.legacy_id != null) return false;
    if (maintenance != app.maintenance) return false;
    if (name != null ? !name.equals(app.name) : app.name != null) return false;
    if (owner != null ? !owner.equals(app.owner) : app.owner != null) return false;
    if (region != null ? !region.equals(app.region) : app.region != null) return false;
    if (released_at != null ? !released_at.equals(app.released_at) : app.released_at != null) return false;
    if (repo_size != null ? !repo_size.equals(app.repo_size) : app.repo_size != null) return false;
    if (slug_size != null ? !slug_size.equals(app.slug_size) : app.slug_size != null) return false;
    if (stack != null ? !stack.equals(app.stack) : app.stack != null) return false;
    if (tier != null ? !tier.equals(app.tier) : app.tier != null) return false;
    if (updated_at != null ? !updated_at.equals(app.updated_at) : app.updated_at != null) return false;
    if (web_url != null ? !web_url.equals(app.web_url) : app.web_url != null) return false;
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
        ", " + "createdAt='" + created_at + '\'' +
        ", " + "gitUrl='" + git_url + '\'' +
        ", " + "id='" + id + '\'' +
        ", " + "legacyId='" + legacy_id + '\'' +
        ", " + "maintenance='" + maintenance + '\'' +
        ", " + "name='" + name + '\'' +
        ", " + "owner='" + owner + '\'' +
        ", " + "region='" + region + '\'' +
        ", " + "releasedAt='" + released_at + '\'' +
        ", " + "repoSize='" + repo_size + '\'' +
        ", " + "slugSize='" + slug_size + '\'' +
        ", " + "stack='" + stack + '\'' +
        ", " + "tier='" + tier + '\'' +
        ", " + "updatedAt='" + updated_at + '\'' +
        ", " + "webUrl='" + web_url + '\'' +
        '}';
  }

}
