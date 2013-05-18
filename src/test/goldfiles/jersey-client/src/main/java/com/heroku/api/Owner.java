package com.heroku.api;

public class Owner
    implements java.io.Serializable {

  protected static final long serialVersionUID = 1291589011L;

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
   * Owner is created in response to API calls
   */
  protected Owner() {
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
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    Owner owner = (Owner) o;

    if (id != owner.id) return false;
    if (email != owner.email) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Owner{" + 
        "id='" + id + '\'' +
        ", " + "email='" + email + '\'' +
        '}';
  }

}
