package com.heroku.api;

public class Release
    implements java.io.Serializable {

  protected static final long serialVersionUID = 1L;

  /**
   * When release was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

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
   * Unique version assigned to the release
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private Number version;

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
   * Get unique version assigned to the release
   */
  public Number getVersion() {
    return this.version;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    Release release = (Release) o;

    if (created_at != release.created_at) return false;
    if (description != release.description) return false;
    if (id != release.id) return false;
    if (updated_at != release.updated_at) return false;
    if (user != null ? !user.equals(release.user) : release.user != null) return false;
    if (version != release.version) return false;
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
        ", " + "description='" + description + '\'' +
        ", " + "id='" + id + '\'' +
        ", " + "updatedAt='" + updated_at + '\'' +
        ", " + "user='" + user + '\'' +
        ", " + "version='" + version + '\'' +
        '}';
  }

}
