package com.heroku.api;

public class Collaborator {

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
   * Construct empty Collaborator
   */
  public Collaborator() {
  }

  public Collaborator(User user, java.util.UUID id, java.util.Date created_at, java.util.Date updated_at) {
    this.user = user;
    this.id = id;
    this.created_at = created_at;
    this.updated_at = updated_at;
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
  public String toString() {
    return "Collaborator{" + 
        "user='" + user + '\'' +
        ", " + "id='" + id + '\'' +
        ", " + "createdAt='" + created_at + '\'' +
        ", " + "updatedAt='" + updated_at + '\'' +
        '}';
  }

}
