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
   * Release is created in response to API calls
   */
  protected Release() {
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
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    Release release = (Release) o;

    if (created_at != release.created_at) return false;
    if (version != release.version) return false;
    if (updated_at != release.updated_at) return false;
    if (user != null ? !user.equals(release.user) : release.user != null) return false;
    if (id != release.id) return false;
    if (description != release.description) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
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
