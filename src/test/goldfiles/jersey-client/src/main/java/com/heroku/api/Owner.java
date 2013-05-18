package com.heroku.api;

public class Owner {

  /**
   * Id
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * Email
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String email;

  /**
   * Construct empty Owner
   */
  public Owner() {
  }

  public Owner(java.util.UUID id, String email) {
    this.id = id;
    this.email = email;
  }

  /**
   * Get id
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get email
   */
  public String getEmail() {
    return this.email;
  }

  @Override
  public String toString() {
    return "Owner{" + 
        "id='" + id + '\'' +
        ", " + "email='" + email + '\'' +
        '}';
  }

}
