package com.heroku.api;

public class Account
    implements java.io.Serializable {

  protected static final long serialVersionUID = 1L;

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
   * Whether billing has been confirmed
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private boolean confirmed;

  /**
   * When account was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * Email address of account
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String email;

  /**
   * Unique identifier of account
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.UUID id;

  /**
   * When account last authorized with Heroku
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date last_login;

  /**
   * When account was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * Whether email has been verified
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private boolean verified;

  /**
   * Account is created in response to API calls
   */
  protected Account() {
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

  /**
   * Get whether billing has been confirmed
   */
  public boolean getConfirmed() {
    return this.confirmed;
  }

  /**
   * Get when account was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get email address of account
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * Get unique identifier of account
   */
  public java.util.UUID getId() {
    return this.id;
  }

  /**
   * Get when account last authorized with Heroku
   */
  public java.util.Date getLastLogin() {
    return this.last_login;
  }

  /**
   * Get when account was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

  /**
   * Get whether email has been verified
   */
  public boolean getVerified() {
    return this.verified;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

    Account account = (Account) o;

    if (allow_tracking != account.allow_tracking) return false;
    if (beta != account.beta) return false;
    if (confirmed != account.confirmed) return false;
    if (created_at != account.created_at) return false;
    if (email != account.email) return false;
    if (id != account.id) return false;
    if (last_login != account.last_login) return false;
    if (updated_at != account.updated_at) return false;
    if (verified != account.verified) return false;
    return true;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Account{" + 
        "allowTracking='" + allow_tracking + '\'' +
        ", " + "beta='" + beta + '\'' +
        ", " + "confirmed='" + confirmed + '\'' +
        ", " + "createdAt='" + created_at + '\'' +
        ", " + "email='" + email + '\'' +
        ", " + "id='" + id + '\'' +
        ", " + "lastLogin='" + last_login + '\'' +
        ", " + "updatedAt='" + updated_at + '\'' +
        ", " + "verified='" + verified + '\'' +
        '}';
  }

}
