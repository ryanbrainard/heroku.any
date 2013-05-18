package com.heroku.api;

public class Release {

  /**
   * When release was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * Unique version assigned to the release
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Number version;

  /**
   * When region was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * User
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private User user;

  /**
   * Unique identifier of this release
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * Description of changes in this release
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String description;

  /**
   * Construct empty Release
   */
  public Release() {
  }

  public Release(java.util.Date created_at, Number version, java.util.Date updated_at, User user, java.util.UUID id, String description) {
    this.created_at = created_at;
    this.version = version;
    this.updated_at = updated_at;
    this.user = user;
    this.id = id;
    this.description = description;
  }

  /**
   * Get when release was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get unique version assigned to the release
   */
  public Number getVersion() {
    return this.version;
  }

  /**
   * Get when region was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  /**
   * Get user
   */
  public User getUser() {
    return this.user;
  }

  /**
   * Get unique identifier of this release
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get description of changes in this release
   */
  public String getDescription() {
    return this.description;
  }

  @Override
  public String toString() {
    return "Release{" + 
        "createdAt='" + created_at + '\'' +
        ", " + "version='" + version + '\'' +
        ", " + "updatedAt='" + updated_at + '\'' +
        ", " + "user='" + user + '\'' +
        ", " + "id='" + id + '\'' +
        ", " + "description='" + description + '\'' +
        '}';
  }

}
