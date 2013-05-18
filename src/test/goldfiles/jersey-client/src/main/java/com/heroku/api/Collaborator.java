package com.heroku.api;

public class Collaborator
    implements java.io.Serializable {

  protected static final long serialVersionUID = -169753450L;

  /**
   * User
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private User user;

  /**
   * Unique identifier of this collaborator
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * When collaborator was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * When collaborator was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * Collaborator is created in response to API calls
   */
  protected Collaborator() {
  }

  /**
   * Get user
   */
  public User getUser() {
    return this.user;
  }

  /**
   * Get unique identifier of this collaborator
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get when collaborator was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get when collaborator was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    Collaborator collaborator = (Collaborator) o;

    if (user != null ? !user.equals(collaborator.user) : collaborator.user != null) return false;
    if (id != collaborator.id) return false;
    if (created_at != collaborator.created_at) return false;
    if (updated_at != collaborator.updated_at) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Collaborator{" + 
        "user='" + user + '\'' +
        ", " + "id='" + id + '\'' +
        ", " + "createdAt='" + created_at + '\'' +
        ", " + "updatedAt='" + updated_at + '\'' +
        '}';
  }

}
