package com.heroku.api;

public class Key {

  /**
   * Unique identifier of this key
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * A unique identifying string based on contents
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String fingerprint;

  /**
   * When key was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * Full public_key as uploaded
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String public_key;

  /**
   * Email address provided in key contents
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String email;

  /**
   * When key was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * Construct empty Keys
   */
  public Key() {
  }

  public Key(java.util.UUID id, String fingerprint, java.util.Date updated_at, String public_key, String email, java.util.Date created_at) {
    this.id = id;
    this.fingerprint = fingerprint;
    this.updated_at = updated_at;
    this.public_key = public_key;
    this.email = email;
    this.created_at = created_at;
  }

  /**
   * Get unique identifier of this key
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get a unique identifying string based on contents
   */
  public String getFingerprint() {
    return this.fingerprint;
  }

  /**
   * Get when key was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  /**
   * Get full public_key as uploaded
   */
  public String getPublicKey() {
    return this.public_key;
  }

  /**
   * Get email address provided in key contents
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Get when key was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

}
