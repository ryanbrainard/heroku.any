package com.heroku.api;

public class User {

  /**
   * Email
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String email;

  /**
   * Id
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * Construct empty User
   */
  public User() {
  }

  public User(String email, java.util.UUID id) {
    this.email = email;
    this.id = id;
  }

  /**
   * Get email
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Get id
   */
  public java.util.UUID getId() {
    return this.id;
  }

  @Override
  public String toString() {
    return "User{" + 
        "email='" + email + '\'' +
        ", " + "id='" + id + '\'' +
        '}';
  }

}
