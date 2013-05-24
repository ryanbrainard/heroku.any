package com.heroku.api;

public class Key
    implements java.io.Serializable {

  protected static final long serialVersionUID = 2078852442L;

  /**
   * When key was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * Email address provided in key contents
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String email;

  /**
   * A unique identifying string based on contents
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String fingerprint;

  /**
   * Unique identifier of this key
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * Full public_key as uploaded
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String public_key;

  /**
   * When key was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * Key is created in response to API calls
   */
  protected Key() {
  }

  /**
   * Get when key was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get email address provided in key contents
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Get a unique identifying string based on contents
   */
  public String getFingerprint() {
    return this.fingerprint;
  }

  /**
   * Get unique identifier of this key
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get full public_key as uploaded
   */
  public String getPublicKey() {
    return this.public_key;
  }

  /**
   * Get when key was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    Key key = (Key) o;

    if (created_at != null ? !created_at.equals(key.created_at) : key.created_at != null) return false;
    if (email != null ? !email.equals(key.email) : key.email != null) return false;
    if (fingerprint != null ? !fingerprint.equals(key.fingerprint) : key.fingerprint != null) return false;
    if (id != null ? !id.equals(key.id) : key.id != null) return false;
    if (public_key != null ? !public_key.equals(key.public_key) : key.public_key != null) return false;
    if (updated_at != null ? !updated_at.equals(key.updated_at) : key.updated_at != null) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Key{" + 
        "createdAt='" + created_at + '\'' +
        ", " + "email='" + email + '\'' +
        ", " + "fingerprint='" + fingerprint + '\'' +
        ", " + "id='" + id + '\'' +
        ", " + "publicKey='" + public_key + '\'' +
        ", " + "updatedAt='" + updated_at + '\'' +
        '}';
  }

}
