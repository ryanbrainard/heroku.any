package com.heroku.api;

public class User
    implements java.io.Serializable {

  protected static final long serialVersionUID = 1L;

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
   * User is created in response to API calls
   */
  protected User() {
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
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    if (email != user.email) return false;
    if (id != user.id) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "User{" + 
        "email='" + email + '\'' +
        ", " + "id='" + id + '\'' +
        '}';
  }

}
