package com.heroku.api;

public class Release {

  /**
   * When release was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * User
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private User user;

  /**
   * Unique name assigned to the release
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String name;

  /**
   * When region was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * Description of changes in this release
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String description;

  /**
   * Unique identifier of this release
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * Construct empty Releases
   */
  public Release() {
  }

  public Release(java.util.Date created_at, User user, String name, java.util.Date updated_at, String description, java.util.UUID id) {
    this.created_at = created_at;
    this.user = user;
    this.name = name;
    this.updated_at = updated_at;
    this.description = description;
    this.id = id;
  }

  /**
   * Get when release was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get user
   */
  public User getUser() {
    return this.user;
  }

  /**
   * Get unique name assigned to the release
   */
  public String getName() {
    return this.name;
  }

  /**
   * Get when region was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  /**
   * Get description of changes in this release
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Get unique identifier of this release
   */
  public java.util.UUID getId() {
    return this.id;
  }

}
