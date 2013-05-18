package com.heroku.api;

public class Key
    implements java.io.Serializable {

  protected static final long serialVersionUID = 821562460L;

  /**
   * Full public_key as uploaded
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String public_key;

  /**
   * When key was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * When key was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

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
   * Key is created in response to API calls
   */
  protected Key() {
  }

  /**
   * Get full public_key as uploaded
   */
  public String getPublicKey() {
    return this.public_key;
  }

  /**
   * Get when key was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get when key was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    Key key = (Key) o;

    if (public_key != key.public_key) return false;
    if (created_at != key.created_at) return false;
    if (updated_at != key.updated_at) return false;
    if (email != key.email) return false;
    if (fingerprint != key.fingerprint) return false;
    if (id != key.id) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Key{" + 
        "publicKey='" + public_key + '\'' +
        ", " + "createdAt='" + created_at + '\'' +
        ", " + "updatedAt='" + updated_at + '\'' +
        ", " + "email='" + email + '\'' +
        ", " + "fingerprint='" + fingerprint + '\'' +
        ", " + "id='" + id + '\'' +
        '}';
  }

}
