package com.heroku.api;

public class Key {

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
   * Construct empty Key
   */
  public Key() {
  }

  public Key(String public_key, java.util.Date created_at, java.util.Date updated_at, String email, String fingerprint, java.util.UUID id) {
    this.public_key = public_key;
    this.created_at = created_at;
    this.updated_at = updated_at;
    this.email = email;
    this.fingerprint = fingerprint;
    this.id = id;
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
