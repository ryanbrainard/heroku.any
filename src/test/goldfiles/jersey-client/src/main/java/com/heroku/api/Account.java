package com.heroku.api;

public class Account {

  /**
   * Whether to utilize beta Heroku features
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private boolean beta;

  /**
   * When account was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * When account last authorized with Heroku
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date last_login;

  /**
   * Email address of account
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String email;

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
   * Whether to allow web activity tracking with third-party services like Google Analytics
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private boolean allow_tracking;

  /**
   * Unique identifier of account
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * When account was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * Account is created in response to API calls
   */
  protected Account() {
  }

  /**
   * Get whether to utilize beta Heroku features
   */
  public boolean getBeta() {
    return this.beta;
  }

  /**
   * Get when account was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  /**
   * Get when account last authorized with Heroku
   */
  public java.util.Date getLastLogin() {
    return this.last_login;
  }

  /**
   * Get email address of account
   */
  public String getEmail() {
    return this.email;
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
   * Get whether to allow web activity tracking with third-party services like Google Analytics
   */
  public boolean getAllowTracking() {
    return this.allow_tracking;
  }

  /**
   * Get unique identifier of account
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get when account was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    Account account = (Account) o;

    if (beta != account.beta) return false;
    if (updated_at != account.updated_at) return false;
    if (last_login != account.last_login) return false;
    if (email != account.email) return false;
    if (verified != account.verified) return false;
    if (confirmed != account.confirmed) return false;
    if (allow_tracking != account.allow_tracking) return false;
    if (id != account.id) return false;
    if (created_at != account.created_at) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Account{" + 
        "beta='" + beta + '\'' +
        ", " + "updatedAt='" + updated_at + '\'' +
        ", " + "lastLogin='" + last_login + '\'' +
        ", " + "email='" + email + '\'' +
        ", " + "verified='" + verified + '\'' +
        ", " + "confirmed='" + confirmed + '\'' +
        ", " + "allowTracking='" + allow_tracking + '\'' +
        ", " + "id='" + id + '\'' +
        ", " + "createdAt='" + created_at + '\'' +
        '}';
  }

}
