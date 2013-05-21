package com.heroku.api;

public class Owner
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
   * Owner is created in response to API calls
   */
  protected Owner() {
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

    Owner owner = (Owner) o;

    if (email != owner.email) return false;
    if (id != owner.id) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Owner{" + 
        "email='" + email + '\'' +
        ", " + "id='" + id + '\'' +
        '}';
  }

}
