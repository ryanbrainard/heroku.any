package com.heroku.api;

public class LogSession {

  /**
   * When log connection was created
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date created_at;

  /**
   * Url for log streaming session
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private String logplex_url;

  /**
   * When log session was updated
   */
  @org.codehaus.jackson.annotate.JsonProperty
  private java.util.Date updated_at;

  /**
   * Construct empty Log Sessions
   */
  public LogSession() {
  }

  public LogSession(java.util.Date created_at, String logplex_url, java.util.Date updated_at) {
    this.created_at = created_at;
    this.logplex_url = logplex_url;
    this.updated_at = updated_at;
  }

  /**
   * Get when log connection was created
   */
  public java.util.Date getCreatedAt() {
    return this.created_at;
  }

  /**
   * Get url for log streaming session
   */
  public String getLogplexUrl() {
    return this.logplex_url;
  }

  /**
   * Get when log session was updated
   */
  public java.util.Date getUpdatedAt() {
    return this.updated_at;
  }

}
