package com.heroku.api;

public class Account {

  /**
   * When account last authorized with Heroku
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date last_login;

  /**
   * Whether email has been verified
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private boolean verified;

  /**
   * Whether billing has been confirmed
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private boolean confirmed;

  /**
   * Unique identifier of account
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * When account was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * Email address of account
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String email;

  /**
   * Whether to allow web activity tracking with third-party services like Google Analytics
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private boolean allow_tracking;

  /**
   * Whether to utilize beta Heroku features
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private boolean beta;

  /**
   * Construct empty Account
   */
  public Account() {
  }

  public Account(java.util.Date last_login, boolean verified, boolean confirmed, java.util.UUID id, java.util.Date updated_at, String email, boolean allow_tracking, boolean beta) {
    this.last_login = last_login;
    this.verified = verified;
    this.confirmed = confirmed;
    this.id = id;
    this.updated_at = updated_at;
    this.email = email;
    this.allow_tracking = allow_tracking;
    this.beta = beta;
  }

  /**
   * Get when account last authorized with Heroku
   */
  public java.util.Date getLastLogin() {
    return this.last_login;
  }

  /**
   * Get whether email has been verified
   */
  public boolean getVerified() {
    return this.verified;
  }

  /**
   * Get whether billing has been confirmed
   */
  public boolean getConfirmed() {
    return this.confirmed;
  }

  /**
   * Get unique identifier of account
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get when account was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  /**
   * Get email address of account
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Get whether to allow web activity tracking with third-party services like Google Analytics
   */
  public boolean getAllowTracking() {
    return this.allow_tracking;
  }

  /**
   * Get whether to utilize beta Heroku features
   */
  public boolean getBeta() {
    return this.beta;
  }

}
