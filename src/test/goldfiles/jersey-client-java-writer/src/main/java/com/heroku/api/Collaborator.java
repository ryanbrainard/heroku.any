package com.heroku.api;

public class Collaborator
    implements java.io.Serializable {

  protected static final long serialVersionUID = 1160402056L;

  /**
   * When collaborator was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * Unique identifier of this collaborator
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * When collaborator was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * User
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private User user;

  /**
   * Collaborator is created in response to API calls
   */
  protected Collaborator() {
  }

  /**
   * Get when collaborator was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get unique identifier of this collaborator
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get when collaborator was updated
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    Collaborator collaborator = (Collaborator) o;

    if (created_at != null ? !created_at.equals(collaborator.created_at) : collaborator.created_at != null) return false;
    if (id != null ? !id.equals(collaborator.id) : collaborator.id != null) return false;
    if (updated_at != null ? !updated_at.equals(collaborator.updated_at) : collaborator.updated_at != null) return false;
    if (user != null ? !user.equals(collaborator.user) : collaborator.user != null) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Collaborator{" + 
        "createdAt='" + created_at + '\'' +
        ", " + "id='" + id + '\'' +
        ", " + "updatedAt='" + updated_at + '\'' +
        ", " + "user='" + user + '\'' +
        '}';
  }

}
